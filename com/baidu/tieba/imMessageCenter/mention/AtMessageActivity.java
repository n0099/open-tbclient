package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveCommentActivityConfig;
import com.baidu.tbadk.core.atomData.StoryPageActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.k;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AtMessageActivity extends BaseActivity<AtMessageActivity> implements k.b, com.baidu.tbadk.mvc.c.a {
    private d dFT;
    private AtMeModelController dFU;
    private ViewEventCenter dFV;
    private CustomMessageListener dFW = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMessageActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (AtMessageActivity.this.dFU != null) {
                    AtMessageActivity.this.dFU.Yg();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dFU = new AtMeModelController(this);
        registerListener(this.dFW);
        this.dFU.setUniqueId(getUniqueId());
        this.dFT = new d(this);
        if (bundle != null) {
            this.dFU.f(bundle);
        } else {
            this.dFU.f(null);
        }
        this.dFT.Yj();
        FN().addEventDelegate(this);
        this.dFU.Yg();
    }

    @Override // com.baidu.tbadk.core.view.k.b
    public void onListPullRefresh(boolean z) {
        this.dFU.azS();
    }

    public void Nv() {
        this.dFU.Yh();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Fe() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.Ff() == 9484) {
            com.baidu.tbadk.mvc.b.a Fg = bVar.Fg();
            if (Fg instanceof FeedData) {
                return d((FeedData) Fg);
            }
        } else if (bVar.Ff() == 9483) {
            com.baidu.tbadk.mvc.b.a Fg2 = bVar.Fg();
            if (Fg2 instanceof FeedData) {
                return b((FeedData) Fg2);
            }
        } else if (bVar.Ff() == 9489) {
            com.baidu.tbadk.mvc.b.a Fg3 = bVar.Fg();
            if (Fg3 instanceof FeedData) {
                return c((FeedData) Fg3);
            }
        }
        return false;
    }

    private boolean b(FeedData feedData) {
        String str;
        String str2;
        List<LikeData> praiseList;
        LikeData likeData;
        if (feedData != null) {
            String userId = feedData.getReplyer().getUserId();
            String userName = feedData.getReplyer().getUserName();
            if (!TextUtils.isEmpty(userId) || (praiseList = feedData.getPraiseList()) == null || praiseList.size() <= 0 || (likeData = praiseList.get(0)) == null) {
                str = userName;
                str2 = userId;
            } else {
                str2 = likeData.getId();
                str = likeData.getName();
            }
            if (str2 != null && str2.length() > 0) {
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getActivity(), str2, str)));
            }
        }
        return false;
    }

    private boolean c(FeedData feedData) {
        if (feedData == null) {
            return false;
        }
        ArrayList<MetaData> arrayList = new ArrayList<>();
        MetaData metaData = new MetaData();
        metaData.setUserIdLong(-2L);
        metaData.setUserName(TbadkCoreApplication.getCurrentAccountName());
        arrayList.add(metaData);
        return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new StoryPageActivityConfig(getActivity()).createNormalConfig(arrayList, 0, feedData.getFromForumId(), com.baidu.adp.lib.g.b.d(feedData.getThread_id(), 0L))));
    }

    private boolean d(FeedData feedData) {
        if (feedData != null) {
            if (feedData.getIsFloor()) {
                TiebaStatic.log("new_at_me_visit_post");
                String thread_id = feedData.getThread_id();
                String post_id = feedData.getPost_id();
                String userName = feedData.getReplyer() == null ? "" : feedData.getReplyer().getUserName();
                if (feedData.getThread_Type() == 33) {
                    return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(getPageContext().getPageActivity()).createPhotoLiveCommentActivityConfig(thread_id, post_id, false)));
                }
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, post_id, "mention", false, userName, false, post_id, 0);
                if (feedData.getFromForumId() > 0) {
                    createSubPbActivityConfig.setKeyFromForumId(String.valueOf(feedData.getFromForumId()));
                }
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
            TiebaStatic.log("new_at_me_visit_pb");
            if (feedData.getThread_Type() == 33) {
                TiebaStatic.log("c10384");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), feedData.getThread_id()).cC(feedData.getPost_id()).cD("mention").po()));
                return false;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(feedData.getThread_id(), feedData.getPost_id(), 1, "mention");
            if (feedData.getFromForumId() > 0) {
                createNormalCfg.setForumId(String.valueOf(feedData.getFromForumId()));
            }
            return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
        return false;
    }

    public ViewEventCenter FN() {
        if (this.dFV == null) {
            this.dFV = new ViewEventCenter();
        }
        return this.dFV;
    }

    public void azU() {
        this.dFT.azU();
    }

    public void b(com.baidu.tbadk.mvc.d.b bVar) {
        this.dFT.b(bVar);
    }

    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        this.dFT.a(aVar);
    }

    public void azV() {
        this.dFT.azV();
    }

    public void a(ErrorData errorData) {
        if (errorData != null && !StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dFT.d(getPageContext(), i);
    }
}
