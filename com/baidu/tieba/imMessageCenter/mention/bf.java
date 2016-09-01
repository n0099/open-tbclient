package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.MentionActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveCommentActivityConfig;
import com.baidu.tbadk.core.atomData.PraiseListActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class bf extends BaseFragment implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter dtj;
    private z dtk;
    private az dtl;
    private j dtm;
    private k dtn;
    private au dto;
    private e dtp;
    private ProgressBar mProgressBar;
    private boolean mLayoutHasInit = false;
    private int mMaxHeight = 0;
    private int mPreHeight = 0;
    private int currentPageType = -1;
    private CustomMessageListener dtq = new bg(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private CustomMessageListener dtr = new bh(this, CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dto = new au(this);
        this.dto.setUniqueId(getUniqueId());
        this.dtp = new e(this);
        this.dtp.setUniqueId(getUniqueId());
        this.dtk = new z(this);
        this.dtn = new k(this);
        this.dtl = new az(this);
        this.dtm = new j(this);
        if (bundle != null) {
            this.dto.d(bundle);
            this.dtp.d(bundle);
            this.dtk.f(bundle);
            this.dtn.f(bundle);
            this.dtl.f(bundle);
            this.dtm.f(bundle);
        } else {
            this.dto.d(null);
            this.dtp.d(null);
            this.dtk.f(null);
            this.dtn.f((Bundle) null);
            this.dtl.f((Bundle) null);
            this.dtm.f(null);
        }
        View mb = this.dtk.mb();
        this.dtk.lQ();
        this.dtk.a(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.dtk.ayW();
        if (getActivity() != null) {
            UtilHelper.startHardAccelerated(getActivity().getWindow());
        }
        MentionActivityConfig.newJumpIn = true;
        lF().addEventDelegate(this);
        registerListener(this.dtq);
        registerListener(this.dtr);
        alz();
        return mb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void azh() {
        View findViewById;
        if (getView() != null && getView().getParent() != null && getView().getParent().getParent() != null && (findViewById = ((ViewGroup) getView().getParent().getParent()).findViewById(t.g.tabcontainer_wrapper)) != null) {
            View findViewById2 = getFragmentActivity().getWindow().getDecorView().findViewById(16908290);
            if (findViewById2 != null && findViewById2.getParent() != null) {
                com.baidu.tbadk.core.util.av.l((View) findViewById2.getParent(), t.d.cp_bg_line_c);
            }
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void azi() {
        View findViewById;
        if (getView() != null && getView().getParent() != null && getView().getParent().getParent() != null && (findViewById = ((ViewGroup) getView().getParent().getParent()).findViewById(t.g.tabcontainer_wrapper)) != null) {
            findViewById.setVisibility(0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.dtl.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dtk != null) {
            this.dtk.a(getPageContext(), i);
        }
        if (this.dtn != null) {
            this.dtn.a(getPageContext(), i);
        }
        if (this.dtl != null) {
            this.dtl.a(getPageContext(), i);
        }
        if (this.dtm != null) {
            this.dtm.a(getPageContext(), i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (getActivity() != null && t(getActivity().getIntent())) {
            this.dtk.onNewIntent(getActivity().getIntent());
        } else {
            this.dtk.ayV();
        }
        super.onViewCreated(view, bundle);
    }

    private boolean t(Intent intent) {
        return (intent == null || intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1) == -1) ? false : true;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!this.dtl.onActivityResult(i, i2, intent) && i2 == -1) {
            switch (i) {
                case 12011:
                    Bundle extras = intent.getExtras();
                    String string = extras.getString("user_id");
                    String string2 = extras.getString("user_name");
                    String string3 = extras.getString(IntentConfig.PORTRAIT);
                    if (string2 != null && string != null) {
                        try {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getActivity(), Long.parseLong(string), string2, string3, 0)));
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (this.currentPageType == 1) {
            TiebaStatic.log("c10524");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (this.dtk.ayY() != null && this.dtk.Xs() != null) {
            if (z) {
                this.dtk.ayY().setScrollable(true);
                if (this.dtk.Xs().getChildCount() == 3) {
                    this.dtk.Xs().getChildAt(1).setEnabled(true);
                    this.dtk.Xs().getChildAt(2).setEnabled(true);
                    return;
                }
                return;
            }
            this.dtk.ayY().setScrollable(false);
            if (this.dtk.Xs().getChildCount() == 3) {
                this.dtk.Xs().getChildAt(1).setEnabled(false);
                this.dtk.Xs().getChildAt(2).setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mp(int i) {
        return i == this.currentPageType;
    }

    public void setPageType(int i) {
        this.currentPageType = i;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dtl != null) {
            this.dtl.destroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT);
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.EL() == 9485) {
            com.baidu.tbadk.mvc.b.a EM = bVar.EM();
            if (EM instanceof FeedData) {
                return e((FeedData) EM);
            }
        } else if (bVar.EL() == 9484) {
            com.baidu.tbadk.mvc.b.a EM2 = bVar.EM();
            if (EM2 instanceof FeedData) {
                return g((FeedData) EM2);
            }
        } else if (bVar.EL() == 9483) {
            com.baidu.tbadk.mvc.b.a EM3 = bVar.EM();
            if (EM3 instanceof FeedData) {
                return h((FeedData) EM3);
            }
        } else if (bVar.EL() == 9486) {
            this.dtl.d(bVar);
            return true;
        } else if (bVar.EL() == 9487) {
            com.baidu.tbadk.mvc.b.a EM4 = bVar.EM();
            if (EM4 instanceof FeedData) {
                return f((FeedData) EM4);
            }
        }
        return false;
    }

    private boolean e(FeedData feedData) {
        if (feedData != null) {
            if (FeedData.TYPE_GRAFFITI.equals(feedData.getPraiseItemType()) || FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                List<LikeData> praiseList = feedData.getPraiseList();
                if (praiseList == null || praiseList.size() <= 0) {
                    return false;
                }
                LikeData likeData = praiseList.get(0);
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getActivity(), likeData.getId(), likeData.getNameShow(), likeData.getPortrait(), feedData.getFname(), false, AddFriendActivityConfig.TYPE_REPLY_ME)));
            } else if (this.dtk.getCurrentTabType() == 1) {
                TiebaStatic.eventStat(getActivity(), "chat_2_aio", "click", 1, new Object[0]);
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getActivity(), com.baidu.adp.lib.h.b.c(feedData.getReplyer().getUserId(), 0L), feedData.getReplyer().getName_show(), feedData.getReplyer().getPortrait(), 0, feedData.getReplyer().getIsMyFriend(), feedData.toJson())));
            } else if (this.dtk.getCurrentTabType() == 2) {
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getActivity(), feedData.getReplyer().getUserId(), feedData.getReplyer().getName_show(), feedData.getReplyer().getPortrait(), feedData.getFname(), false, AddFriendActivityConfig.TYPE_AT_ME)));
            } else {
                return false;
            }
        }
        return false;
    }

    private boolean f(FeedData feedData) {
        if (feedData == null) {
            return false;
        }
        TiebaStatic.log("c10967");
        if (!azj()) {
            UtilHelper.showToast(getActivity(), t.j.plugin_config_not_found);
            return false;
        }
        PraiseListActivityConfig praiseListActivityConfig = new PraiseListActivityConfig(getPageContext().getPageActivity(), feedData.getThread_id(), feedData.getPost_id(), feedData.getTitle(), false);
        praiseListActivityConfig.setIsGraffitiPraiseList();
        praiseListActivityConfig.setIsAuthor(feedData.isAuthor());
        return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, praiseListActivityConfig));
    }

    private boolean azj() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PraiseListActivityConfig.class);
    }

    private boolean g(FeedData feedData) {
        if (feedData != null) {
            if (feedData.getIsFloor()) {
                if (this.dtk.getCurrentTabType() == 2) {
                    TiebaStatic.log("new_at_me_visit_post");
                } else if (this.dtk.getCurrentTabType() == 1) {
                    TiebaStatic.log("new_my_reply_visit_post");
                    if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                        TiebaStatic.log("zan_mlist");
                    }
                }
                String thread_id = feedData.getThread_id();
                String post_id = feedData.getPost_id();
                if (feedData.getThread_Type() == 33) {
                    return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(getPageContext().getPageActivity()).createPhotoLiveCommentActivityConfig(thread_id, post_id, false)));
                }
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, post_id, "mention", false)));
            }
            if (this.dtk.getCurrentTabType() == 2) {
                TiebaStatic.log("new_at_me_visit_pb");
            } else if (this.dtk.getCurrentTabType() == 1) {
                TiebaStatic.log("new_my_reply_visit_pb");
                if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                    TiebaStatic.log("zan_mlist");
                }
            }
            if (feedData.getThread_Type() == 33) {
                TiebaStatic.log("c10384");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), feedData.getThread_id()).ci(feedData.getPost_id()).cj("mention").oW()));
                return false;
            }
            return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getActivity()).createNormalCfg(feedData.getThread_id(), feedData.getPost_id(), 1, "mention")));
        }
        return false;
    }

    private boolean h(FeedData feedData) {
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

    public ViewEventCenter lF() {
        if (this.dtj == null) {
            this.dtj = new ViewEventCenter();
        }
        return this.dtj;
    }

    public az azk() {
        return this.dtl;
    }

    public j azl() {
        return this.dtm;
    }

    public au azm() {
        return this.dto;
    }

    public e azn() {
        return this.dtp;
    }

    public k azo() {
        return this.dtn;
    }

    public z azp() {
        return this.dtk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (errorData != null && !StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean lI() {
        return false;
    }

    public void showProgressBar() {
        try {
            showProgressBarWithOffset(0, 0);
        } catch (OutOfMemoryError e) {
            BdBaseApplication.getInst().onAppMemoryLow();
        }
    }

    public void showProgressBarWithOffset(int i, int i2) {
        if (this.mProgressBar == null) {
            try {
                this.mProgressBar = new ProgressBar(getPageContext().getPageActivity());
                this.mProgressBar.setIndeterminateDrawable(TbadkCoreApplication.m9getInst().getResources().getDrawable(t.f.progressbar));
                if (getView() instanceof ViewGroup) {
                    ((ViewGroup) getView()).addView(this.mProgressBar, new FrameLayout.LayoutParams(-2, -2, 17));
                }
            } catch (Throwable th) {
                return;
            }
        }
        this.mProgressBar.setPadding(com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), i), com.baidu.adp.lib.util.k.dip2px(getPageContext().getContext(), i2), 0, 0);
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        if (this.mProgressBar != null) {
            this.mProgressBar.setVisibility(8);
        }
    }

    private void alz() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, new bi(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void mk(int i) {
        this.dtn.mk(i);
        this.dtl.mk(i);
        this.dtm.mk(i);
    }
}
