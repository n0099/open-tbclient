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
/* loaded from: classes22.dex */
public class AtMessageActivity extends BaseActivity<AtMessageActivity> implements f.c, com.baidu.tbadk.mvc.c.a {
    private d kHY;
    private AtMeModelController kHZ;
    private ViewEventCenter kIa;
    private CustomMessageListener kIb = new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY) { // from class: com.baidu.tieba.imMessageCenter.mention.AtMessageActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (AtMessageActivity.this.kHZ != null) {
                    AtMessageActivity.this.kHZ.csQ();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kHZ = new AtMeModelController(this);
        registerListener(this.kIb);
        this.kHZ.setUniqueId(getUniqueId());
        this.kHY = new d(this);
        if (bundle != null) {
            this.kHZ.aj(bundle);
        } else {
            this.kHZ.aj(null);
        }
        this.kHY.bVH();
        bEP().addEventDelegate(this);
        this.kHZ.csQ();
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.kHZ.cIE();
    }

    public void cFi() {
        this.kHZ.csR();
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean bEs() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.bEt() == 9484) {
            com.baidu.tbadk.mvc.b.a bEu = bVar.bEu();
            if (bEu instanceof FeedData) {
                return d((FeedData) bEu);
            }
        } else if (bVar.bEt() == 9483) {
            com.baidu.tbadk.mvc.b.a bEu2 = bVar.bEu();
            if (bEu2 instanceof FeedData) {
                return c((FeedData) bEu2);
            }
        } else if (bVar.bEt() == 9489) {
            com.baidu.tbadk.mvc.b.a bEu3 = bVar.bEu();
            if (bEu3 instanceof FeedData) {
                this.kHY.b((FeedData) bEu3);
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

    public ViewEventCenter bEP() {
        if (this.kIa == null) {
            this.kIa = new ViewEventCenter();
        }
        return this.kIa;
    }

    public void dbr() {
        this.kHY.dbr();
    }

    public void c(com.baidu.tbadk.mvc.d.b bVar) {
        this.kHY.c(bVar);
    }

    public void a(com.baidu.tbadk.mvc.b.a aVar) {
        this.kHY.a(aVar);
    }

    public void dbs() {
        this.kHY.dbs();
    }

    public void a(ErrorData errorData) {
        if (errorData != null && errorData.error_code != 0) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            }
            if (this.kHY.kHU != null) {
                this.kHY.kHU.setVisibility(8);
            }
            showNetRefreshView(this.kHY.rootView, getString(R.string.refresh_view_title_text), null, getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
            setNetRefreshViewEmotionMarginTop(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.kHY.onChangeSkinType(getPageContext(), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        super.onNetRefreshButtonClicked();
        if (com.baidu.adp.lib.util.l.isNetOk() && this.kHZ != null) {
            this.kHZ.cIE();
        }
    }

    public void Yb() {
        if (this.kHY != null) {
            if (this.kHY.kHU != null) {
                this.kHY.kHU.setVisibility(0);
            }
            hideNetRefreshView(this.kHY.rootView);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a079";
    }
}
