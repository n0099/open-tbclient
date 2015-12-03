package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class bc extends BaseFragment implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter cfe;
    private y cff;
    private aw cfg;
    private j cfh;
    private k cfi;
    private ar cfj;
    private e cfk;
    private ProgressBar mProgressBar;
    private BdUniqueId uniqueId = BdUniqueId.gen();
    private boolean mLayoutHasInit = false;
    private int mMaxHeight = 0;
    private int mPreHeight = 0;
    private int currentPageType = -1;
    private CustomMessageListener cfl = new bd(this, CmdConfigCustom.METHOD_ACCOUNT_CHANGE);
    private CustomMessageListener cfm = new be(this, CmdConfigCustom.CMD_MESSAGE_CENTER_NOTIFY);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.cfj = new ar(this);
        this.cfj.setUniqueId(getUniqueId());
        this.cfk = new e(this);
        this.cfk.setUniqueId(getUniqueId());
        this.cff = new y(this);
        this.cfi = new k(this);
        this.cfg = new aw(this);
        this.cfh = new j(this);
        if (bundle != null) {
            this.cfj.f(bundle);
            this.cfk.f(bundle);
            this.cff.h(bundle);
            this.cfi.h(bundle);
            this.cfg.h(bundle);
            this.cfh.h(bundle);
        } else {
            this.cfj.f(null);
            this.cfk.f(null);
            this.cff.h(null);
            this.cfi.h((Bundle) null);
            this.cfg.h(null);
            this.cfh.h(null);
        }
        View pg = this.cff.pg();
        this.cff.oX();
        this.cff.a(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.cff.adn();
        if (getActivity() != null) {
            UtilHelper.startHardAccelerated(getActivity().getWindow());
        }
        MentionActivityConfig.newJumpIn = true;
        addGlobalLayoutListener();
        oM().addEventDelegate(this);
        registerListener(this.cfl);
        registerListener(this.cfm);
        return pg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adB() {
        View findViewById;
        if (getView() != null && getView().getParent() != null && getView().getParent().getParent() != null && (findViewById = ((ViewGroup) getView().getParent().getParent()).findViewById(n.f.tabcontainer_wrapper)) != null) {
            View findViewById2 = getFragmentActivity().getWindow().getDecorView().findViewById(16908290);
            if (findViewById2 != null && findViewById2.getParent() != null) {
                com.baidu.tbadk.core.util.as.j((View) findViewById2.getParent(), n.c.cp_bg_line_c);
            }
            findViewById.setVisibility(8);
            View view = null;
            if (findViewById2 != null) {
                view = findViewById2.findViewById(n.f.maintab);
            }
            if (view != null) {
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adC() {
        View findViewById;
        if (getView() != null && getView().getParent() != null && getView().getParent().getParent() != null && (findViewById = ((ViewGroup) getView().getParent().getParent()).findViewById(n.f.tabcontainer_wrapper)) != null) {
            findViewById.setVisibility(0);
        }
    }

    protected void addGlobalLayoutListener() {
        getFragmentActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new bf(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardHeightChanged(int i) {
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.cfg.onSaveInstanceState(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.cff.a(getPageContext(), i);
        this.cfi.a(getPageContext(), i);
        this.cfg.a(getPageContext(), i);
        this.cfh.a(getPageContext(), i);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        if (getActivity() != null && Q(getActivity().getIntent())) {
            this.cff.onNewIntent(getActivity().getIntent());
        } else {
            this.cff.adm();
        }
        super.onViewCreated(view, bundle);
    }

    private boolean Q(Intent intent) {
        return (intent == null || intent.getIntExtra(MentionActivityConfig.KEY_INTENT_NOTIFICATION_ID, -1) == -1) ? false : true;
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!this.cfg.onActivityResult(i, i2, intent) && i2 == -1) {
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (this.cff.adp() != null && this.cff.adq() != null) {
            if (z) {
                this.cff.adp().setScrollable(true);
                if (this.cff.adq().getChildCount() == 3) {
                    this.cff.adq().getChildAt(1).setEnabled(true);
                    this.cff.adq().getChildAt(2).setEnabled(true);
                    return;
                }
                return;
            }
            this.cff.adp().setScrollable(false);
            if (this.cff.adq().getChildCount() == 3) {
                this.cff.adq().getChildAt(1).setEnabled(false);
                this.cff.adq().getChildAt(2).setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean iX(int i) {
        return i == this.currentPageType;
    }

    public void iY(int i) {
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
        if (this.cfg != null) {
            this.cfg.destroy();
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar.Du() == 9485) {
            com.baidu.tbadk.mvc.b.a Dv = bVar.Dv();
            if (Dv instanceof FeedData) {
                return c((FeedData) Dv);
            }
        } else if (bVar.Du() == 9484) {
            com.baidu.tbadk.mvc.b.a Dv2 = bVar.Dv();
            if (Dv2 instanceof FeedData) {
                return d((FeedData) Dv2);
            }
        } else if (bVar.Du() == 9483) {
            com.baidu.tbadk.mvc.b.a Dv3 = bVar.Dv();
            if (Dv3 instanceof FeedData) {
                return e((FeedData) Dv3);
            }
        } else if (bVar.Du() == 9486) {
            this.cfg.d(bVar);
            return true;
        }
        return false;
    }

    private boolean c(FeedData feedData) {
        if (feedData != null) {
            if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                List<LikeData> praiseList = feedData.getPraiseList();
                if (praiseList == null || praiseList.size() <= 0) {
                    return false;
                }
                LikeData likeData = praiseList.get(0);
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getActivity(), likeData.getId(), likeData.getNameShow(), likeData.getPortrait(), feedData.getFname(), false, AddFriendActivityConfig.TYPE_REPLY_ME)));
            } else if (this.cff.getCurrentTabType() == 1) {
                TiebaStatic.eventStat(getActivity(), "chat_2_aio", "click", 1, new Object[0]);
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getActivity(), com.baidu.adp.lib.h.b.c(feedData.getReplyer().getUserId(), 0L), feedData.getReplyer().getName_show(), feedData.getReplyer().getPortrait(), 0, feedData.getReplyer().getIsMyFriend(), feedData.toJson())));
            } else if (this.cff.getCurrentTabType() == 2) {
                return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AddFriendActivityConfig(getActivity(), feedData.getReplyer().getUserId(), feedData.getReplyer().getName_show(), feedData.getReplyer().getPortrait(), feedData.getFname(), false, AddFriendActivityConfig.TYPE_AT_ME)));
            } else {
                return false;
            }
        }
        return false;
    }

    private boolean d(FeedData feedData) {
        if (feedData != null) {
            if (feedData.getIsFloor()) {
                if (this.cff.getCurrentTabType() == 2) {
                    TiebaStatic.log("new_at_me_visit_post");
                } else if (this.cff.getCurrentTabType() == 1) {
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
            if (this.cff.getCurrentTabType() == 2) {
                TiebaStatic.log("new_at_me_visit_pb");
            } else if (this.cff.getCurrentTabType() == 1) {
                TiebaStatic.log("new_my_reply_visit_pb");
                if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                    TiebaStatic.log("zan_mlist");
                }
            }
            if (feedData.getThread_Type() == 33) {
                TiebaStatic.log("c10384");
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(getPageContext().getPageActivity(), feedData.getThread_id()).cl(feedData.getPost_id()).cm("mention").rw()));
                return false;
            }
            return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(getActivity()).createNormalCfg(feedData.getThread_id(), feedData.getPost_id(), "mention")));
        }
        return false;
    }

    private boolean e(FeedData feedData) {
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

    public ViewEventCenter oM() {
        if (this.cfe == null) {
            this.cfe = new ViewEventCenter();
        }
        return this.cfe;
    }

    public aw adD() {
        return this.cfg;
    }

    public j adE() {
        return this.cfh;
    }

    public ar adF() {
        return this.cfj;
    }

    public e adG() {
        return this.cfk;
    }

    public k adH() {
        return this.cfi;
    }

    public y adI() {
        return this.cff;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ErrorData errorData) {
        if (errorData != null && !StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean oP() {
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.mvc.c.a
    public BdUniqueId getUniqueId() {
        return this.uniqueId;
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
                this.mProgressBar.setIndeterminateDrawable(TbadkCoreApplication.m411getInst().getResources().getDrawable(n.e.progressbar));
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
}
