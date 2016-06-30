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
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class bf extends BaseFragment implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter deG;
    private z deH;
    private az deI;
    private j deJ;
    private k deK;
    private au deL;
    private e deM;
    private ProgressBar mProgressBar;
    private boolean mLayoutHasInit = false;
    private int mMaxHeight = 0;
    private int mPreHeight = 0;
    private int currentPageType = -1;
    private CustomMessageListener deN = new bg(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private CustomMessageListener deO = new bh(this, CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.deL = new au(this);
        this.deL.setUniqueId(getUniqueId());
        this.deM = new e(this);
        this.deM.setUniqueId(getUniqueId());
        this.deH = new z(this);
        this.deK = new k(this);
        this.deI = new az(this);
        this.deJ = new j(this);
        if (bundle != null) {
            this.deL.d(bundle);
            this.deM.d(bundle);
            this.deH.i(bundle);
            this.deK.i(bundle);
            this.deI.i(bundle);
            this.deJ.i(bundle);
        } else {
            this.deL.d(null);
            this.deM.d(null);
            this.deH.i(null);
            this.deK.i((Bundle) null);
            this.deI.i(null);
            this.deJ.i(null);
        }
        View lk = this.deH.lk();
        this.deH.kZ();
        this.deH.a(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.deH.atw();
        if (getActivity() != null) {
            UtilHelper.startHardAccelerated(getActivity().getWindow());
        }
        MentionActivityConfig.newJumpIn = true;
        kO().addEventDelegate(this);
        registerListener(this.deN);
        registerListener(this.deO);
        agl();
        return lk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void atI() {
        View findViewById;
        if (getView() != null && getView().getParent() != null && getView().getParent().getParent() != null && (findViewById = ((ViewGroup) getView().getParent().getParent()).findViewById(u.g.tabcontainer_wrapper)) != null) {
            View findViewById2 = getFragmentActivity().getWindow().getDecorView().findViewById(16908290);
            if (findViewById2 != null && findViewById2.getParent() != null) {
                com.baidu.tbadk.core.util.av.l((View) findViewById2.getParent(), u.d.cp_bg_line_c);
            }
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void atJ() {
        View findViewById;
        if (getView() != null && getView().getParent() != null && getView().getParent().getParent() != null && (findViewById = ((ViewGroup) getView().getParent().getParent()).findViewById(u.g.tabcontainer_wrapper)) != null) {
            findViewById.setVisibility(0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.deI.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.deH != null) {
            this.deH.a(getPageContext(), i);
        }
        if (this.deK != null) {
            this.deK.a(getPageContext(), i);
        }
        if (this.deI != null) {
            this.deI.a(getPageContext(), i);
        }
        if (this.deJ != null) {
            this.deJ.a(getPageContext(), i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (getActivity() != null && s(getActivity().getIntent())) {
            this.deH.onNewIntent(getActivity().getIntent());
        } else {
            this.deH.atv();
        }
        super.onViewCreated(view, bundle);
    }

    private boolean s(Intent intent) {
        return (intent == null || intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1) == -1) ? false : true;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!this.deI.onActivityResult(i, i2, intent) && i2 == -1) {
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
        if (this.deH.aty() != null && this.deH.RY() != null) {
            if (z) {
                this.deH.aty().setScrollable(true);
                if (this.deH.RY().getChildCount() == 3) {
                    this.deH.RY().getChildAt(1).setEnabled(true);
                    this.deH.RY().getChildAt(2).setEnabled(true);
                    return;
                }
                return;
            }
            this.deH.aty().setScrollable(false);
            if (this.deH.RY().getChildCount() == 3) {
                this.deH.RY().getChildAt(1).setEnabled(false);
                this.deH.RY().getChildAt(2).setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lG(int i) {
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
        if (this.deI != null) {
            this.deI.destroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT);
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.Ds() == 9485) {
            com.baidu.tbadk.mvc.b.a Dt = bVar.Dt();
            if (Dt instanceof FeedData) {
                return e((FeedData) Dt);
            }
        } else if (bVar.Ds() == 9484) {
            com.baidu.tbadk.mvc.b.a Dt2 = bVar.Dt();
            if (Dt2 instanceof FeedData) {
                return g((FeedData) Dt2);
            }
        } else if (bVar.Ds() == 9483) {
            com.baidu.tbadk.mvc.b.a Dt3 = bVar.Dt();
            if (Dt3 instanceof FeedData) {
                return h((FeedData) Dt3);
            }
        } else if (bVar.Ds() == 9486) {
            this.deI.d(bVar);
            return true;
        } else if (bVar.Ds() == 9487) {
            com.baidu.tbadk.mvc.b.a Dt4 = bVar.Dt();
            if (Dt4 instanceof FeedData) {
                return f((FeedData) Dt4);
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
            } else if (this.deH.getCurrentTabType() == 1) {
                TiebaStatic.eventStat(getActivity(), "chat_2_aio", "click", 1, new Object[0]);
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getActivity(), com.baidu.adp.lib.h.b.c(feedData.getReplyer().getUserId(), 0L), feedData.getReplyer().getName_show(), feedData.getReplyer().getPortrait(), 0, feedData.getReplyer().getIsMyFriend(), feedData.toJson())));
            } else if (this.deH.getCurrentTabType() == 2) {
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
        if (!atK()) {
            UtilHelper.showToast(getActivity(), u.j.plugin_config_not_found);
            return false;
        }
        PraiseListActivityConfig praiseListActivityConfig = new PraiseListActivityConfig(getPageContext().getPageActivity(), feedData.getThread_id(), feedData.getPost_id(), feedData.getTitle(), false);
        praiseListActivityConfig.setIsGraffitiPraiseList();
        praiseListActivityConfig.setIsAuthor(feedData.isAuthor());
        return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, praiseListActivityConfig));
    }

    private boolean atK() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PraiseListActivityConfig.class);
    }

    private boolean g(FeedData feedData) {
        if (feedData != null) {
            if (feedData.getIsFloor()) {
                if (this.deH.getCurrentTabType() == 2) {
                    TiebaStatic.log("new_at_me_visit_post");
                } else if (this.deH.getCurrentTabType() == 1) {
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
            if (this.deH.getCurrentTabType() == 2) {
                TiebaStatic.log("new_at_me_visit_pb");
            } else if (this.deH.getCurrentTabType() == 1) {
                TiebaStatic.log("new_my_reply_visit_pb");
                if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                    TiebaStatic.log("zan_mlist");
                }
            }
            if (feedData.getThread_Type() == 33) {
                TiebaStatic.log("c10384");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), feedData.getThread_id()).cg(feedData.getPost_id()).ch("mention").ol()));
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

    public ViewEventCenter kO() {
        if (this.deG == null) {
            this.deG = new ViewEventCenter();
        }
        return this.deG;
    }

    public az atL() {
        return this.deI;
    }

    public j atM() {
        return this.deJ;
    }

    public au atN() {
        return this.deL;
    }

    public e atO() {
        return this.deM;
    }

    public k atP() {
        return this.deK;
    }

    public z atQ() {
        return this.deH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (errorData != null && !StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean kR() {
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
                this.mProgressBar.setIndeterminateDrawable(TbadkCoreApplication.m9getInst().getResources().getDrawable(u.f.progressbar));
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

    private void agl() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, new bi(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void lB(int i) {
        this.deK.lB(i);
        this.deI.lB(i);
        this.deJ.lB(i);
    }
}
