package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.m0.g0.c.b;
import d.a.m0.r.f0.f;
import d.a.n0.g1.b.d;
import java.util.List;
/* loaded from: classes4.dex */
public class AtMessageActivity extends BaseActivity<AtMessageActivity> implements f.g, d.a.m0.g0.c.a {
    public AtMeModelController atMeModelController;
    public d atMeViewController;
    public CustomMessageListener mMessageFromNotifyCenterListener = new a(2016321);
    public ViewEventCenter viewEventController;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (AtMessageActivity.this.atMeModelController != null) {
                    AtMessageActivity.this.atMeModelController.u();
                }
            }
        }
    }

    private boolean toPb(FeedData feedData) {
        if (feedData != null) {
            if (ThreadCardUtils.isUgcThreadType(feedData.getBaijiahaoData())) {
                TiebaStatic.log("new_at_me_visit_pb");
                PbActivityConfig createNormalCfg = new PbActivityConfig(getActivity()).createNormalCfg(feedData.getThread_id(), (String) null, 1, "mention");
                createNormalCfg.setStartFrom(13);
                if (feedData.getFromForumId() > 0) {
                    createNormalCfg.setForumId(String.valueOf(feedData.getFromForumId()));
                }
                createNormalCfg.setBjhData(feedData.getBaijiahaoData());
                createNormalCfg.setHighLightPostId(feedData.getPost_id());
                return MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
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
                return MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            } else {
                TiebaStatic.log("new_at_me_visit_pb");
                PbActivityConfig createNormalCfg2 = new PbActivityConfig(getActivity()).createNormalCfg(feedData.getThread_id(), feedData.getPost_id(), 1, "mention");
                createNormalCfg2.setStartFrom(13);
                if (feedData.getFromForumId() > 0) {
                    createNormalCfg2.setForumId(String.valueOf(feedData.getFromForumId()));
                }
                createNormalCfg2.setHighLightPostId(feedData.getPost_id());
                return MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg2));
            }
        }
        return false;
    }

    private boolean toPersonInfo(FeedData feedData) {
        List<LikeData> praiseList;
        LikeData likeData;
        if (feedData != null) {
            String userId = feedData.getReplyer().getUserId();
            String userName = feedData.getReplyer().getUserName();
            if (TextUtils.isEmpty(userId) && (praiseList = feedData.getPraiseList()) != null && praiseList.size() > 0 && (likeData = praiseList.get(0)) != null) {
                userId = likeData.getId();
                userName = likeData.getName();
            }
            if (userId != null && userId.length() > 0) {
                return MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getActivity(), userId, userName)));
            }
        }
        return false;
    }

    public void dismissPullRefresh() {
        this.atMeViewController.h();
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.m0.k0.a
    public String getCurrentPageKey() {
        return "a079";
    }

    public ViewEventCenter getEventCenter() {
        if (this.viewEventController == null) {
            this.viewEventController = new ViewEventCenter();
        }
        return this.viewEventController;
    }

    public void hideNetRefreshView() {
        d dVar = this.atMeViewController;
        if (dVar != null) {
            BdListView bdListView = dVar.f55007b;
            if (bdListView != null) {
                bdListView.setVisibility(0);
            }
            hideNetRefreshView(this.atMeViewController.f55008c);
        }
    }

    @Override // d.a.m0.g0.c.a
    public boolean isEventMustSelf() {
        return false;
    }

    public void loadMoreData() {
        this.atMeModelController.w();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.atMeViewController.j(getPageContext(), i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.atMeModelController = new AtMeModelController(this);
        registerListener(this.mMessageFromNotifyCenterListener);
        this.atMeModelController.setUniqueId(getUniqueId());
        this.atMeViewController = new d(this);
        if (bundle != null) {
            this.atMeModelController.v(bundle);
        } else {
            this.atMeModelController.v(null);
        }
        this.atMeViewController.k();
        getEventCenter().addEventDelegate(this);
        this.atMeModelController.u();
    }

    @Override // d.a.m0.g0.c.a
    public boolean onEventDispatch(b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.b() == 9484) {
            d.a.m0.g0.b.a a2 = bVar.a();
            if (a2 instanceof FeedData) {
                return toPb((FeedData) a2);
            }
            return false;
        } else if (bVar.b() == 9483) {
            d.a.m0.g0.b.a a3 = bVar.a();
            if (a3 instanceof FeedData) {
                return toPersonInfo((FeedData) a3);
            }
            return false;
        } else if (bVar.b() == 9489) {
            d.a.m0.g0.b.a a4 = bVar.a();
            if (a4 instanceof FeedData) {
                this.atMeViewController.g((FeedData) a4);
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    @Override // d.a.m0.r.f0.f.g
    public void onListPullRefresh(boolean z) {
        this.atMeModelController.y();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        AtMeModelController atMeModelController;
        super.onNetRefreshButtonClicked();
        if (!l.D() || (atMeModelController = this.atMeModelController) == null) {
            return;
        }
        atMeModelController.y();
    }

    public void onServerError(ErrorData errorData) {
        if (errorData == null || errorData.error_code == 0) {
            return;
        }
        if (!StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
        BdListView bdListView = this.atMeViewController.f55007b;
        if (bdListView != null) {
            bdListView.setVisibility(8);
        }
        showNetRefreshView(this.atMeViewController.f55008c, getString(R.string.refresh_view_title_text), null, getString(R.string.refresh_view_button_text), true, getNetRefreshListener());
        setNetRefreshViewEmotionMarginTop(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds530));
    }

    public void onViewDataChanged(d.a.m0.g0.b.a aVar) {
        this.atMeViewController.m(aVar);
    }

    public void onViewStateChanged(d.a.m0.g0.d.b bVar) {
        this.atMeViewController.n(bVar);
    }

    public void showPullRefresh() {
        this.atMeViewController.o();
    }
}
