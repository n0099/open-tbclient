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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes2.dex */
public class AtMessageActivity extends BaseActivity<AtMessageActivity> implements f.c, com.baidu.tbadk.mvc.c.a {
    private d kQT;
    private AtMeModelController kQU;
    private ViewEventCenter kQV;
    private CustomMessageListener kQW = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMessageActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (AtMessageActivity.this.kQU != null) {
                    AtMessageActivity.this.kQU.ctl();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kQU = new AtMeModelController(this);
        registerListener(this.kQW);
        this.kQU.setUniqueId(getUniqueId());
        this.kQT = new d(this);
        if (bundle != null) {
            this.kQU.aj(bundle);
        } else {
            this.kQU.aj(null);
        }
        this.kQT.bVr();
        bDI().addEventDelegate(this);
        this.kQU.ctl();
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.kQU.cJh();
    }

    public void cFF() {
        this.kQU.ctm();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bDm() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.bDn() == 9484) {
            com.baidu.tbadk.mvc.b.a bDo = bVar.bDo();
            if (bDo instanceof FeedData) {
                return d((FeedData) bDo);
            }
        } else if (bVar.bDn() == 9483) {
            com.baidu.tbadk.mvc.b.a bDo2 = bVar.bDo();
            if (bDo2 instanceof FeedData) {
                return c((FeedData) bDo2);
            }
        } else if (bVar.bDn() == 9489) {
            com.baidu.tbadk.mvc.b.a bDo3 = bVar.bDo();
            if (bDo3 instanceof FeedData) {
                this.kQT.b((FeedData) bDo3);
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
            if (az.a(feedData.getBaijiahaoData())) {
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

    public ViewEventCenter bDI() {
        if (this.kQV == null) {
            this.kQV = new ViewEventCenter();
        }
        return this.kQV;
    }

    public void cZi() {
        this.kQT.cZi();
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        this.kQT.c(bVar);
    }

    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        this.kQT.a(aVar);
    }

    public void cZj() {
        this.kQT.cZj();
    }

    public void a(ErrorData errorData) {
        if (errorData != null && errorData.error_code != 0) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            }
            if (this.kQT.kQP != null) {
                this.kQT.kQP.setVisibility(8);
            }
            showNetRefreshView(this.kQT.rootView, getString(R.string.refresh_view_title_text), null, getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kQT.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (com.baidu.adp.lib.util.l.isNetOk() && this.kQU != null) {
            this.kQU.cJh();
        }
    }

    public void WZ() {
        if (this.kQT != null) {
            if (this.kQT.kQP != null) {
                this.kQT.kQP.setVisibility(0);
            }
            hideNetRefreshView(this.kQT.rootView);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a079";
    }
}
