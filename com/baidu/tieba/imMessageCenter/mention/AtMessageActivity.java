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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class AtMessageActivity extends BaseActivity<AtMessageActivity> implements f.c, com.baidu.tbadk.mvc.c.a {
    private d kIC;
    private AtMeModelController kID;
    private ViewEventCenter kIE;
    private CustomMessageListener kIF = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMessageActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (AtMessageActivity.this.kID != null) {
                    AtMessageActivity.this.kID.crS();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kID = new AtMeModelController(this);
        registerListener(this.kIF);
        this.kID.setUniqueId(getUniqueId());
        this.kIC = new d(this);
        if (bundle != null) {
            this.kID.aj(bundle);
        } else {
            this.kID.aj(null);
        }
        this.kIC.bUv();
        bDq().addEventDelegate(this);
        this.kID.crS();
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.kID.cHN();
    }

    public void cEl() {
        this.kID.crT();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bCU() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.bCV() == 9484) {
            com.baidu.tbadk.mvc.b.a bCW = bVar.bCW();
            if (bCW instanceof FeedData) {
                return d((FeedData) bCW);
            }
        } else if (bVar.bCV() == 9483) {
            com.baidu.tbadk.mvc.b.a bCW2 = bVar.bCW();
            if (bCW2 instanceof FeedData) {
                return c((FeedData) bCW2);
            }
        } else if (bVar.bCV() == 9489) {
            com.baidu.tbadk.mvc.b.a bCW3 = bVar.bCW();
            if (bCW3 instanceof FeedData) {
                this.kIC.b((FeedData) bCW3);
                return true;
            }
        }
        return false;
    }

    private boolean c(FeedData feedData) {
        String str;
        List<LikeData> praiseList;
        LikeData likeData;
        if (feedData != null) {
            String userId = feedData.getReplyer().getUserId();
            String userName = feedData.getReplyer().getUserName();
            if (!TextUtils.isEmpty(userId) || (praiseList = feedData.getPraiseList()) == null || praiseList.size() <= 0 || (likeData = praiseList.get(0)) == null) {
                str = userName;
            } else {
                String id = likeData.getId();
                str = likeData.getName();
                userId = id;
            }
            if (userId != null && userId.length() > 0) {
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getActivity(), userId, str)));
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

    public ViewEventCenter bDq() {
        if (this.kIE == null) {
            this.kIE = new ViewEventCenter();
        }
        return this.kIE;
    }

    public void cXd() {
        this.kIC.cXd();
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        this.kIC.c(bVar);
    }

    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        this.kIC.a(aVar);
    }

    public void cXe() {
        this.kIC.cXe();
    }

    public void a(ErrorData errorData) {
        if (errorData != null && errorData.error_code != 0) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            }
            if (this.kIC.kIy != null) {
                this.kIC.kIy.setVisibility(8);
            }
            showNetRefreshView(this.kIC.rootView, getString(R.string.refresh_view_title_text), null, getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kIC.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (com.baidu.adp.lib.util.l.isNetOk() && this.kID != null) {
            this.kID.cHN();
        }
    }

    public void Vq() {
        if (this.kIC != null) {
            if (this.kIC.kIy != null) {
                this.kIC.kIy.setVisibility(0);
            }
            hideNetRefreshView(this.kIC.rootView);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a079";
    }
}
