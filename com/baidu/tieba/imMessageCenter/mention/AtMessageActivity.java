package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.List;
/* loaded from: classes4.dex */
public class AtMessageActivity extends BaseActivity<AtMessageActivity> implements h.c, com.baidu.tbadk.mvc.c.a {
    private d gVB;
    private AtMeModelController gVC;
    private ViewEventCenter gVD;
    private CustomMessageListener gVE = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMessageActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (AtMessageActivity.this.gVC != null) {
                    AtMessageActivity.this.gVC.bbK();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gVC = new AtMeModelController(this);
        registerListener(this.gVE);
        this.gVC.setUniqueId(getUniqueId());
        this.gVB = new d(this);
        if (bundle != null) {
            this.gVC.K(bundle);
        } else {
            this.gVC.K(null);
        }
        this.gVB.aKY();
        awx().addEventDelegate(this);
        this.gVC.bbK();
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void onListPullRefresh(boolean z) {
        this.gVC.boL();
    }

    public void bmw() {
        this.gVC.bbL();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean avP() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.avQ() == 9484) {
            com.baidu.tbadk.mvc.b.a avR = bVar.avR();
            if (avR instanceof FeedData) {
                return c((FeedData) avR);
            }
        } else if (bVar.avQ() == 9483) {
            com.baidu.tbadk.mvc.b.a avR2 = bVar.avR();
            if (avR2 instanceof FeedData) {
                return b((FeedData) avR2);
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
        if (feedData != null) {
            if (feedData.getIsFloor()) {
                TiebaStatic.log("new_at_me_visit_post");
                String thread_id = feedData.getThread_id();
                String post_id = feedData.getPost_id();
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, post_id, "mention", false, feedData.getReplyer() == null ? "" : feedData.getReplyer().getUserName(), false, post_id, 0);
                if (feedData.getFromForumId() > 0) {
                    createSubPbActivityConfig.setKeyFromForumId(String.valueOf(feedData.getFromForumId()));
                }
                createSubPbActivityConfig.setKeyPageStartFrom(13);
                createSubPbActivityConfig.setHighLightPostId(post_id);
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
            }
            TiebaStatic.log("new_at_me_visit_pb");
            PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(feedData.getThread_id(), feedData.getPost_id(), 1, "mention");
            createNormalCfg.setStartFrom(13);
            if (feedData.getFromForumId() > 0) {
                createNormalCfg.setForumId(String.valueOf(feedData.getFromForumId()));
            }
            createNormalCfg.setHighLightPostId(feedData.getPost_id());
            return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
        return false;
    }

    public ViewEventCenter awx() {
        if (this.gVD == null) {
            this.gVD = new ViewEventCenter();
        }
        return this.gVD;
    }

    public void bFv() {
        this.gVB.bFv();
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        this.gVB.c(bVar);
    }

    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        this.gVB.a(aVar);
    }

    public void bFw() {
        this.gVB.bFw();
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
        this.gVB.onChangeSkinType(getPageContext(), i);
    }
}
