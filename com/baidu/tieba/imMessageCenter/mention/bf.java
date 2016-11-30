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
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class bf extends BaseFragment implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter dAl;
    private z dAm;
    private az dAn;
    private j dAo;
    private k dAp;
    private au dAq;
    private e dAr;
    private ProgressBar mProgressBar;
    private boolean mLayoutHasInit = false;
    private int mMaxHeight = 0;
    private int mPreHeight = 0;
    private int currentPageType = -1;
    private CustomMessageListener dAs = new bg(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private CustomMessageListener dAt = new bh(this, CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.dAq = new au(this);
        this.dAq.setUniqueId(getUniqueId());
        this.dAr = new e(this);
        this.dAr.setUniqueId(getUniqueId());
        this.dAm = new z(this);
        this.dAp = new k(this);
        this.dAn = new az(this);
        this.dAo = new j(this);
        if (bundle != null) {
            this.dAq.d(bundle);
            this.dAr.d(bundle);
            this.dAm.f(bundle);
            this.dAp.f(bundle);
            this.dAn.f(bundle);
            this.dAo.f(bundle);
        } else {
            this.dAq.d(null);
            this.dAr.d(null);
            this.dAm.f(null);
            this.dAp.f((Bundle) null);
            this.dAn.f((Bundle) null);
            this.dAo.f(null);
        }
        View me = this.dAm.me();
        this.dAm.lT();
        this.dAm.a(getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.dAm.aBq();
        if (getActivity() != null) {
            UtilHelper.startHardAccelerated(getActivity().getWindow());
        }
        MentionActivityConfig.newJumpIn = true;
        lI().addEventDelegate(this);
        registerListener(this.dAs);
        registerListener(this.dAt);
        anI();
        return me;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aBB() {
        View findViewById;
        if (getView() != null && getView().getParent() != null && getView().getParent().getParent() != null && (findViewById = ((ViewGroup) getView().getParent().getParent()).findViewById(r.g.tabcontainer_wrapper)) != null) {
            View findViewById2 = getFragmentActivity().getWindow().getDecorView().findViewById(16908290);
            if (findViewById2 != null && findViewById2.getParent() != null) {
                com.baidu.tbadk.core.util.at.l((View) findViewById2.getParent(), r.d.cp_bg_line_c);
            }
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aBC() {
        View findViewById;
        if (getView() != null && getView().getParent() != null && getView().getParent().getParent() != null && (findViewById = ((ViewGroup) getView().getParent().getParent()).findViewById(r.g.tabcontainer_wrapper)) != null) {
            findViewById.setVisibility(0);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.dAn.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dAm != null) {
            this.dAm.a(getPageContext(), i);
        }
        if (this.dAp != null) {
            this.dAp.a(getPageContext(), i);
        }
        if (this.dAn != null) {
            this.dAn.a(getPageContext(), i);
        }
        if (this.dAo != null) {
            this.dAo.a(getPageContext(), i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (getActivity() != null && s(getActivity().getIntent())) {
            this.dAm.onNewIntent(getActivity().getIntent());
        } else {
            this.dAm.aeN();
        }
        super.onViewCreated(view, bundle);
    }

    private boolean s(Intent intent) {
        return (intent == null || intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1) == -1) ? false : true;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!this.dAn.onActivityResult(i, i2, intent) && i2 == -1) {
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
        if (this.dAm.aBs() != null && this.dAm.YO() != null) {
            if (z) {
                this.dAm.aBs().setScrollable(true);
                if (this.dAm.YO().getChildCount() == 3) {
                    this.dAm.YO().getChildAt(1).setEnabled(true);
                    this.dAm.YO().getChildAt(2).setEnabled(true);
                    return;
                }
                return;
            }
            this.dAm.aBs().setScrollable(false);
            if (this.dAm.YO().getChildCount() == 3) {
                this.dAm.YO().getChildAt(1).setEnabled(false);
                this.dAm.YO().getChildAt(2).setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean mF(int i) {
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
        if (this.dAn != null) {
            this.dAn.destroy();
        }
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT);
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.EQ() == 9485) {
            com.baidu.tbadk.mvc.b.a ER = bVar.ER();
            if (ER instanceof FeedData) {
                return e((FeedData) ER);
            }
        } else if (bVar.EQ() == 9484) {
            com.baidu.tbadk.mvc.b.a ER2 = bVar.ER();
            if (ER2 instanceof FeedData) {
                return g((FeedData) ER2);
            }
        } else if (bVar.EQ() == 9483) {
            com.baidu.tbadk.mvc.b.a ER3 = bVar.ER();
            if (ER3 instanceof FeedData) {
                return h((FeedData) ER3);
            }
        } else if (bVar.EQ() == 9486) {
            this.dAn.d(bVar);
            return true;
        } else if (bVar.EQ() == 9487) {
            com.baidu.tbadk.mvc.b.a ER4 = bVar.ER();
            if (ER4 instanceof FeedData) {
                return f((FeedData) ER4);
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
            } else if (this.dAm.getCurrentTabType() == 1) {
                TiebaStatic.eventStat(getActivity(), "chat_2_aio", "click", 1, new Object[0]);
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getActivity(), com.baidu.adp.lib.h.b.c(feedData.getReplyer().getUserId(), 0L), feedData.getReplyer().getName_show(), feedData.getReplyer().getPortrait(), 0, feedData.getReplyer().getIsMyFriend(), feedData.toJson())));
            } else if (this.dAm.getCurrentTabType() == 2) {
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
        if (!aBD()) {
            UtilHelper.showToast(getActivity(), r.j.plugin_config_not_found);
            return false;
        }
        PraiseListActivityConfig praiseListActivityConfig = new PraiseListActivityConfig(getPageContext().getPageActivity(), feedData.getThread_id(), feedData.getPost_id(), feedData.getTitle(), false);
        praiseListActivityConfig.setIsGraffitiPraiseList();
        praiseListActivityConfig.setIsAuthor(feedData.isAuthor());
        return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, praiseListActivityConfig));
    }

    private boolean aBD() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PraiseListActivityConfig.class);
    }

    private boolean g(FeedData feedData) {
        if (feedData != null) {
            if (feedData.getIsFloor()) {
                if (this.dAm.getCurrentTabType() == 2) {
                    TiebaStatic.log("new_at_me_visit_post");
                } else if (this.dAm.getCurrentTabType() == 1) {
                    TiebaStatic.log("new_my_reply_visit_post");
                    if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                        TiebaStatic.log("zan_mlist");
                    }
                }
                String thread_id = feedData.getThread_id();
                String post_id = feedData.getPost_id();
                String userName = feedData.getReplyer() == null ? "" : feedData.getReplyer().getUserName();
                if (feedData.getThread_Type() == 33) {
                    return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveCommentActivityConfig(getPageContext().getPageActivity()).createPhotoLiveCommentActivityConfig(thread_id, post_id, false)));
                }
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, post_id, "mention", false, userName, false, post_id, 0)));
            }
            if (this.dAm.getCurrentTabType() == 2) {
                TiebaStatic.log("new_at_me_visit_pb");
            } else if (this.dAm.getCurrentTabType() == 1) {
                TiebaStatic.log("new_my_reply_visit_pb");
                if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                    TiebaStatic.log("zan_mlist");
                }
            }
            if (feedData.getThread_Type() == 33) {
                TiebaStatic.log("c10384");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), feedData.getThread_id()).cj(feedData.getPost_id()).ck("mention").oZ()));
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

    public ViewEventCenter lI() {
        if (this.dAl == null) {
            this.dAl = new ViewEventCenter();
        }
        return this.dAl;
    }

    public az aBE() {
        return this.dAn;
    }

    public j aBF() {
        return this.dAo;
    }

    public au aBG() {
        return this.dAq;
    }

    public e aBH() {
        return this.dAr;
    }

    public k aBI() {
        return this.dAp;
    }

    public z aBJ() {
        return this.dAm;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (errorData != null && !StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean lL() {
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
                this.mProgressBar.setIndeterminateDrawable(TbadkCoreApplication.m9getInst().getResources().getDrawable(r.f.progressbar));
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

    private void anI() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_IM_REPLY_ME_BACK_EVENT, new bi(this));
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public void mA(int i) {
        this.dAp.mA(i);
        this.dAn.mA(i);
        this.dAo.mA(i);
    }
}
