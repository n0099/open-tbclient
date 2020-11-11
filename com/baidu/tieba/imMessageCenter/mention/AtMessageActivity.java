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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import java.util.List;
/* loaded from: classes22.dex */
public class AtMessageActivity extends BaseActivity<AtMessageActivity> implements f.c, com.baidu.tbadk.mvc.c.a {
    private d ktS;
    private AtMeModelController ktT;
    private ViewEventCenter ktU;
    private CustomMessageListener ktV = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMessageActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (AtMessageActivity.this.ktT != null) {
                    AtMessageActivity.this.ktT.cpb();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ktT = new AtMeModelController(this);
        registerListener(this.ktV);
        this.ktT.setUniqueId(getUniqueId());
        this.ktS = new d(this);
        if (bundle != null) {
            this.ktT.aj(bundle);
        } else {
            this.ktT.aj(null);
        }
        this.ktS.bSD();
        bBX().addEventDelegate(this);
        this.ktT.cpb();
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.ktT.cDM();
    }

    public void cBo() {
        this.ktT.cpc();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bBA() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.bBB() == 9484) {
            com.baidu.tbadk.mvc.b.a bBC = bVar.bBC();
            if (bBC instanceof FeedData) {
                return d((FeedData) bBC);
            }
        } else if (bVar.bBB() == 9483) {
            com.baidu.tbadk.mvc.b.a bBC2 = bVar.bBC();
            if (bBC2 instanceof FeedData) {
                return c((FeedData) bBC2);
            }
        } else if (bVar.bBB() == 9489) {
            com.baidu.tbadk.mvc.b.a bBC3 = bVar.bBC();
            if (bBC3 instanceof FeedData) {
                this.ktS.b((FeedData) bBC3);
                return true;
            }
        }
        return false;
    }

    private boolean c(FeedData feedData) {
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

    private boolean d(FeedData feedData) {
        if (feedData != null) {
            if (ay.a(feedData.getBaijiahaoData())) {
                TiebaStatic.log("new_at_me_visit_pb");
                PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(feedData.getThread_id(), (String) null, 1, "mention");
                createNormalCfg.setStartFrom(13);
                if (feedData.getFromForumId() > 0) {
                    createNormalCfg.setForumId(String.valueOf(feedData.getFromForumId()));
                }
                createNormalCfg.setBjhData(feedData.getBaijiahaoData());
                createNormalCfg.setHighLightPostId(feedData.getPost_id());
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
            } else if (feedData.getIsFloor()) {
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
            } else {
                TiebaStatic.log("new_at_me_visit_pb");
                PbActivityConfig createNormalCfg2 = new PbActivityConfig(getActivity()).createNormalCfg(feedData.getThread_id(), feedData.getPost_id(), 1, "mention");
                createNormalCfg2.setStartFrom(13);
                if (feedData.getFromForumId() > 0) {
                    createNormalCfg2.setForumId(String.valueOf(feedData.getFromForumId()));
                }
                createNormalCfg2.setHighLightPostId(feedData.getPost_id());
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
            }
        }
        return false;
    }

    public ViewEventCenter bBX() {
        if (this.ktU == null) {
            this.ktU = new ViewEventCenter();
        }
        return this.ktU;
    }

    public void cWy() {
        this.ktS.cWy();
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        this.ktS.c(bVar);
    }

    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        this.ktS.a(aVar);
    }

    public void cWz() {
        this.ktS.cWz();
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
        this.ktS.onChangeSkinType(getPageContext(), i);
    }
}
