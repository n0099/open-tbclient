package com.baidu.tieba.myAttentionAndFans;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MyForbiddenFansActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tbadk.switchs.FollowListSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.myAttentionAndFans.ConcernSelectView;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.NavigationBarCoverTip;
import d.a.m0.r.q.g1;
import d.a.n0.o0.a.d;
/* loaded from: classes4.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    public static final int FOLLOW_TIP_X_OFFSET = 50;
    public static final int MAX_TIP_COUNT = 2;
    public static final int SHOW_FOLLOW_TIP_MAX_COUNT = 1;
    public static final String TAG_FOLLOW = "follow";
    public static final String TAG_ID = "user_id";
    public static final String TAG_PORTRAIT = "portrait";
    public static final String TAG_SEX = "user_sex";
    public static final String TAG_TOTLEFOLLOWNUM = "total_follow_num";
    public static final int TIP_DISMISS_TIME = 3000;
    public static final int TYPE_SHOW_BOTH_REMOVE_AND_LOOK = 3;
    public static final int TYPE_SHOW_LOOK_ALL = 1;
    public static final int TYPE_SHOW_REMOVE_ALL = 2;
    public NavigationBarShadowView mConcernSelectShadowView;
    public RelativeLayout mContainer;
    public NavigationBarCoverTip mCoverTipNaviBar;
    public d.a.n0.d0.e mFollowSwitchTipController;
    public d.a.n0.o0.a.d mForbiddenFansController;
    public View mForbiddenTipContainer;
    public TextView mForbiddenTipView;
    public boolean mHasNetData;
    public PbListView mLoadMoreView;
    public PersonListModel mModel;
    public NavigationBar mNavigationBar;
    public NavigationBarShadowView mNavigationShadowView;
    public NoDataView mNoDataView;
    public String mPortrait;
    public TextView mResultTipView;
    public d.a.n0.d0.e mSelectMenuGuideTipController;
    public ConcernSelectView mSelectView;
    public static final int M_W_X002 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X002);
    public static final int TBDS26 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
    public BdListView mFollowListView = null;
    public View mSubTitleViewRoot = null;
    public View mSubTitleViewParent = null;
    public TextView mSubTitleText = null;
    public View mHeaderTitleViewRoot = null;
    public TextView mHeaderTitleText = null;
    public d.a.n0.w1.b mAdapter = null;
    public NoPressedRelativeLayout mParent = null;
    public boolean isFirstEnter = true;
    public TextView mTitleText = null;
    public ImageView mFollowSwitch = null;
    public View mTitleLayout = null;
    public int mUserSex = 0;
    public boolean mIsBjhUser = false;
    public int mTotalFollowNum = 0;
    public int mChatPersonPosition = 0;
    public AttentionMode mAttentionMode = AttentionMode.NULL;
    public final AntiHelper.k mAntiInjectListener = new i();
    public CustomMessageListener attentionListener = new j(2001115);
    public HttpMessageListener mRemoveFansListener = new k(CmdConfigHttp.CMD_REMOVE_FANS);
    public AbsListView.OnScrollListener mOnScrollListener = new l();
    public PersonListModel.d mCallBack = new n();
    public View.OnClickListener mFollowSwitchListener = new d();

    /* loaded from: classes4.dex */
    public enum AttentionMode {
        ALL,
        TIEBA,
        NULL
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonListActivity.this.startGetNetData();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BdListView.p {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.p
        public void onScrollToBottom() {
            if (PersonListActivity.this.mAdapter == null || !PersonListActivity.this.mAdapter.c()) {
                return;
            }
            if (PersonListActivity.this.mLoadMoreView != null && !PersonListActivity.this.mLoadMoreView.l()) {
                PersonListActivity.this.mLoadMoreView.O();
            }
            PersonListActivity.this.startGetNetData();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ConcernSelectView.g {
        public c() {
        }

        @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.g
        public void a(int i2) {
            PersonListActivity.this.mFollowListView.setSelection(0);
            PersonListActivity.this.mModel.F(i2);
        }

        @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.g
        public void onExpand(boolean z) {
            if (z) {
                PersonListActivity.this.showGuideTip();
            } else if (PersonListActivity.this.mSelectMenuGuideTipController != null) {
                PersonListActivity.this.mSelectMenuGuideTipController.I();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonListActivity.this.hideFollowSwitchGuideTip();
            if (PersonListActivity.this.mModel == null) {
                return;
            }
            int i2 = h.f18466a[PersonListActivity.this.mAttentionMode.ordinal()];
            if (i2 == 1) {
                PersonListActivity.this.mAttentionMode = AttentionMode.TIEBA;
                PersonListActivity.this.mTitleText.setText(R.string.tieba_attention);
                PersonListActivity.this.sendFollowSwitchMessage(2);
            } else if (i2 != 2) {
            } else {
                PersonListActivity.this.mAttentionMode = AttentionMode.ALL;
                PersonListActivity.this.mTitleText.setText(R.string.all_attention);
                PersonListActivity.this.sendFollowSwitchMessage(1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonListActivity.this.mSelectMenuGuideTipController != null) {
                PersonListActivity.this.mSelectMenuGuideTipController.I();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends ClickableSpan {
        public f() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            PersonListActivity.this.lookForAllForbiddenFans();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(SkinManager.getColor(R.color.CAM_X0302));
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
        }
    }

    /* loaded from: classes4.dex */
    public class g extends ClickableSpan {
        public g() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            PersonListActivity.this.removeAllForbiddenFans();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(SkinManager.getColor(R.color.CAM_X0302));
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class h {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18466a;

        static {
            int[] iArr = new int[AttentionMode.values().length];
            f18466a = iArr;
            try {
                iArr[AttentionMode.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18466a[AttentionMode.TIEBA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements AntiHelper.k {
        public i() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.a.m0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }
    }

    /* loaded from: classes4.dex */
    public class j extends CustomMessageListener {
        public j(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f12638c == null || (message = updateAttentionMessage.getmOrginalMessage()) == null || message.getTag() == null || !message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) || updateAttentionMessage.getData().l == null || AntiHelper.t(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().l, PersonListActivity.this.mAntiInjectListener) == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k extends HttpMessageListener {
        public k(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage == null || httpResponsedMessage.getError() != 0 || (orginalMessage = httpResponsedMessage.getOrginalMessage()) == null || !(orginalMessage.getExtra() instanceof Long)) {
                return;
            }
            if (PersonListActivity.this.mAdapter.d(((Long) orginalMessage.getExtra()).longValue())) {
                PersonListActivity.this.mAdapter.b();
                PersonListActivity.this.mAdapter.notifyDataSetChanged();
            }
            if (PersonListActivity.this.mAdapter.f66200f) {
                PersonListActivity.this.processNoData(null, false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class l implements AbsListView.OnScrollListener {
        public l() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            View childAt;
            if (i2 == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                String id = PersonListActivity.this.mModel.getId();
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.C()) {
                    PersonListActivity.this.mNavigationShadowView.a();
                } else {
                    PersonListActivity.this.mConcernSelectShadowView.a();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (PersonListActivity.this.mModel == null) {
                return;
            }
            if (i2 == 1 || i2 == 2) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                String id = PersonListActivity.this.mModel.getId();
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.C()) {
                    PersonListActivity.this.mNavigationShadowView.c();
                } else {
                    PersonListActivity.this.mConcernSelectShadowView.c();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class m implements d.e {
        public m() {
        }

        @Override // d.a.n0.o0.a.d.e
        public void a() {
            PersonListActivity personListActivity = PersonListActivity.this;
            personListActivity.showLoadingDialog(personListActivity.getString(R.string.remove_fans_loading));
        }

        @Override // d.a.n0.o0.a.d.e
        public void b(int i2, String str, boolean z, int i3, long j) {
            if (z) {
                PersonListActivity.this.closeLoadingDialog();
                if (i2 == 2260104) {
                    return;
                }
                if (PersonListActivity.this.mResultTipView == null) {
                    PersonListActivity.this.mResultTipView = new TextView(PersonListActivity.this.getActivity());
                    PersonListActivity.this.mResultTipView.setGravity(19);
                    PersonListActivity.this.mResultTipView.setPadding(d.a.c.e.p.l.g(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                    PersonListActivity.this.mResultTipView.setLayoutParams(new ViewGroup.LayoutParams(-1, d.a.c.e.p.l.g(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                    PersonListActivity.this.mResultTipView.setTextSize(0, d.a.c.e.p.l.g(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                    PersonListActivity.this.mResultTipView.setTextColor(PersonListActivity.this.getResources().getColor(R.color.CAM_X0101));
                }
                PersonListActivity.this.mResultTipView.setText(str);
                if (i2 == 0) {
                    PersonListActivity.this.mCoverTipNaviBar.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                } else {
                    PersonListActivity.this.mCoverTipNaviBar.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                }
                PersonListActivity.this.mCoverTipNaviBar.m(PersonListActivity.this.getActivity(), PersonListActivity.this.mResultTipView, 3000);
            }
            if (i3 == 0) {
                PersonListActivity.this.mForbiddenTipView.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                SkinManager.setViewTextColor(PersonListActivity.this.mForbiddenTipView, R.color.CAM_X0109);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class n implements PersonListModel.d {
        public n() {
        }

        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.d
        public g1 a(g1 g1Var, boolean z) {
            if (g1Var != null && g1Var.f53705e != PersonListActivity.this.mTotalFollowNum && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.C() && PersonListActivity.this.mModel.D() == 0) {
                PersonListActivity.this.mModel.O(PersonListActivity.this.mPortrait);
            }
            PersonListActivity.this.update(g1Var, z);
            return null;
        }

        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.d
        public void b(String str, boolean z) {
            if (z) {
                return;
            }
            if (PersonListActivity.this.isLoadingViewAttached()) {
                PersonListActivity personListActivity = PersonListActivity.this;
                personListActivity.hideLoadingView(personListActivity.mContainer);
            }
            if (!TextUtils.isEmpty(str)) {
                PersonListActivity.this.showToast(str);
            }
            PersonListActivity.this.processNoData(null, false);
        }
    }

    /* loaded from: classes4.dex */
    public class o implements NoPressedRelativeLayout.a {
        public o() {
        }

        @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
        public void a(MotionEvent motionEvent) {
            Rect rect = new Rect();
            PersonListActivity.this.mSelectView.getGlobalVisibleRect(rect);
            if (!PersonListActivity.this.mSelectView.l() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                PersonListActivity.this.mParent.setNeedInterceptTouchEvent(false);
                return;
            }
            PersonListActivity.this.mSelectView.h();
            PersonListActivity.this.mParent.setNeedInterceptTouchEvent(true);
        }
    }

    /* loaded from: classes4.dex */
    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserData userData;
            if (view == null || !(view.getTag() instanceof Integer)) {
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            if (PersonListActivity.this.mAdapter == null || PersonListActivity.this.mAdapter.getItemViewType(intValue) != 0 || (userData = (UserData) PersonListActivity.this.mAdapter.getItem(intValue)) == null || userData.getUserId() == null) {
                return;
            }
            if (PersonListActivity.this.mModel.C()) {
                TiebaStatic.log(new StatisticItem("c12772").param("obj_locate", "1").param("obj_param1", userData.getUserId()));
            } else {
                TiebaStatic.log(new StatisticItem("c12605").param("obj_locate", 1).param("obj_param1", userData.getUserId()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), null, AddFriendActivityConfig.TYPE_FOCUS)));
        }
    }

    /* loaded from: classes4.dex */
    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonListActivity.this.mChatPersonPosition = ((Integer) view.getTag()).intValue();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                PersonListActivity.this.StartChat();
            } else {
                TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, 11028)));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void StartChat() {
        UserData userData;
        d.a.n0.w1.b bVar = this.mAdapter;
        if (bVar == null || bVar.getItemViewType(this.mChatPersonPosition) != 0 || (userData = (UserData) this.mAdapter.getItem(this.mChatPersonPosition)) == null || userData.getUserId() == null || userData.getUserName() == null || userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            return;
        }
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "enter_chat", "personlistclick", 1, new Object[0]);
        try {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(getPageContext().getPageActivity(), Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void addFollowSwitch() {
        this.mTitleText.setText(R.string.all_attention);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTitleText.getLayoutParams();
        int i2 = M_W_X002;
        layoutParams.rightMargin = i2;
        layoutParams.leftMargin = i2;
        this.mTitleText.setLayoutParams(layoutParams);
        ImageView imageView = (ImageView) this.mNavigationBar.getCenterImgBox();
        this.mFollowSwitch = imageView;
        imageView.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mFollowSwitch.getLayoutParams();
        int i3 = TBDS26;
        layoutParams2.width = i3;
        layoutParams2.height = i3;
        this.mFollowSwitch.setLayoutParams(layoutParams2);
        View centerImgBoxLayout = this.mNavigationBar.getCenterImgBoxLayout();
        this.mTitleLayout = centerImgBoxLayout;
        centerImgBoxLayout.setClickable(true);
        this.mTitleLayout.setOnClickListener(this.mFollowSwitchListener);
        this.mTitleLayout.setVisibility(8);
    }

    private void attatchListTitleHeader() {
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.mHeaderTitleViewRoot = inflate;
        inflate.setVisibility(8);
        this.mHeaderTitleViewRoot.setClickable(false);
        this.mHeaderTitleViewRoot.setEnabled(false);
        this.mHeaderTitleText = (TextView) this.mHeaderTitleViewRoot.findViewById(R.id.person_list_title);
        this.mFollowListView.addHeaderView(this.mHeaderTitleViewRoot, null, false);
    }

    private void dealFollowSwitchGuideTip() {
        if (d.a.m0.r.d0.b.j().g("key_follow_guide_tip", false)) {
            return;
        }
        d.a.m0.r.d0.b.j().t("key_follow_guide_tip", true);
        showFollowSwitchGuideTip();
    }

    private SpannableStringBuilder getForbiddenTipSpannableString(String str, int i2) {
        String str2;
        String str3 = null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (i2 == 1) {
            spannableStringBuilder.append((CharSequence) "，");
            String string = getString(R.string.click_for_look_all);
            spannableStringBuilder.append((CharSequence) string);
            str3 = string;
            str2 = null;
        } else if (i2 == 2) {
            spannableStringBuilder.append((CharSequence) "，");
            str2 = getString(R.string.remove_all_forbidden_fans);
            spannableStringBuilder.append((CharSequence) str2);
        } else if (i2 != 3) {
            str2 = null;
        } else {
            str3 = getString(R.string.click_for_look_all);
            str2 = getString(R.string.remove_all_forbidden_fans);
            spannableStringBuilder.append((CharSequence) "，");
            spannableStringBuilder.append((CharSequence) str3);
            spannableStringBuilder.append((CharSequence) getString(R.string.tip_or));
            spannableStringBuilder.append((CharSequence) str2);
        }
        if (!StringUtils.isNull(str3)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str3, new f());
        }
        if (!StringUtils.isNull(str2)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str2, new g());
        }
        return spannableStringBuilder;
    }

    private void initAndRefreshForbiddenTipView(String str, int i2) {
        if (this.mForbiddenTipContainer == null) {
            View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.mForbiddenTipContainer = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.view_forbidden_tip);
            this.mForbiddenTipView = textView;
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.mForbiddenTipContainer, R.color.CAM_X0201);
        }
        if (StringUtils.isNull(str)) {
            this.mForbiddenTipContainer.setVisibility(8);
            return;
        }
        this.mForbiddenTipView.setText(getForbiddenTipSpannableString(str, i2));
        this.mForbiddenTipView.setMovementMethod(LinkMovementMethod.getInstance());
        this.mForbiddenTipView.setHighlightColor(getResources().getColor(R.color.transparent));
    }

    private void initData(Bundle bundle) {
        PersonListModel personListModel = new PersonListModel(this, this.mCallBack);
        this.mModel = personListModel;
        if (bundle != null) {
            personListModel.M(bundle.getBoolean("follow", false));
            this.mModel.L(bundle.getString("user_id"));
            this.mUserSex = bundle.getInt("user_sex");
            this.mIsBjhUser = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.mTotalFollowNum = bundle.getInt("total_follow_num");
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.mUserSex);
            return;
        }
        Intent intent = getIntent();
        this.mModel.M(intent.getBooleanExtra("follow", false));
        this.mModel.L(intent.getStringExtra("user_id"));
        this.mUserSex = intent.getIntExtra("user_sex", 0);
        this.mIsBjhUser = intent.getBooleanExtra(IntentConfig.IS_BJH_USER, false);
        this.mTotalFollowNum = intent.getIntExtra("total_follow_num", 0);
        this.mPortrait = intent.getStringExtra("portrait");
        this.mModel.setSex(this.mUserSex);
    }

    private void initUI() {
        this.mParent = (NoPressedRelativeLayout) findViewById(R.id.parent);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        this.mTitleText = navigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationShadowView = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_fans);
        this.mConcernSelectShadowView = (NavigationBarShadowView) findViewById(R.id.navi_shadow_view_my_concern);
        View findViewById = findViewById(R.id.sub_title_root);
        this.mSubTitleViewRoot = findViewById;
        this.mSubTitleViewParent = findViewById.findViewById(R.id.newheader_root);
        this.mSubTitleViewRoot.setVisibility(8);
        this.mSubTitleViewRoot.setClickable(false);
        this.mSubTitleViewRoot.setEnabled(false);
        this.mSubTitleText = (TextView) this.mSubTitleViewRoot.findViewById(R.id.person_list_title);
        this.mSelectView = (ConcernSelectView) findViewById(R.id.select_layout);
        this.mCoverTipNaviBar = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        boolean z = true;
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.C()) {
                this.mTitleText.setText(R.string.my_attention);
                if (FollowListSwitch.isOn()) {
                    addFollowSwitch();
                }
                this.mParent.setDispathEventAction(new o());
            } else {
                this.mTitleText.setText(R.string.fans);
            }
        } else if (this.mModel.C()) {
            int i2 = this.mUserSex;
            if (i2 == 2) {
                this.mTitleText.setText(R.string.her_attention_people);
            } else if (i2 == 1) {
                this.mTitleText.setText(R.string.his_attention_people);
            } else {
                this.mTitleText.setText(R.string.its_attention_people);
            }
        } else {
            int i3 = this.mUserSex;
            if (i3 == 2) {
                this.mTitleText.setText(R.string.attention_to_her);
            } else if (i3 == 1) {
                this.mTitleText.setText(R.string.attention_to_him);
            } else {
                this.mTitleText.setText(R.string.attention_to_it);
            }
        }
        p pVar = new p();
        q qVar = new q();
        a aVar = new a();
        z = (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.mAdapter = new d.a.n0.w1.d(this, getIntent().getBooleanExtra("follow", false), z, sex, pVar, qVar, aVar);
            this.mSubTitleViewRoot.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mParent, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, d.a.c.e.p.l.g(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.mAdapter = new d.a.n0.w1.c(this, z, sex, pVar, aVar);
            this.mSubTitleViewRoot.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mParent, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, d.a.c.e.p.l.g(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.mContainer = (RelativeLayout) findViewById(R.id.container);
        BdListView bdListView = (BdListView) findViewById(R.id.list);
        this.mFollowListView = bdListView;
        bdListView.setAdapter((ListAdapter) this.mAdapter);
        attatchListTitleHeader();
        this.mFollowListView.setOnSrollToBottomListener(new b());
        this.mFollowListView.setOnScrollListener(this.mOnScrollListener);
        this.mSelectView.setOnExpandListener(new c());
        this.mSelectView.setVisibility(8);
        this.mHeaderTitleViewRoot.setVisibility(8);
        PbListView pbListView = new PbListView(getActivity());
        this.mLoadMoreView = pbListView;
        pbListView.b();
        this.mLoadMoreView.o(R.color.CAM_X0205);
        this.mLoadMoreView.v();
        this.mLoadMoreView.C(SkinManager.getColor(R.color.CAM_X0107));
        this.mLoadMoreView.E(R.dimen.tbfontsize33);
        this.mLoadMoreView.y(R.color.CAM_X0110);
        this.mLoadMoreView.r(d.a.c.e.p.l.g(getActivity(), R.dimen.tbds182));
        this.mFollowListView.setNextPage(this.mLoadMoreView);
    }

    private void loadDataFirstTime() {
        showLoadingView(this.mContainer);
        this.mModel.K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lookForAllForbiddenFans() {
        TiebaStatic.log(new StatisticItem("c13103"));
        if (!d.a.c.e.p.l.D()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void processHaveData(g1 g1Var) {
        TextView textView;
        String string;
        String string2;
        boolean z;
        if (g1Var == null) {
            return;
        }
        this.mFollowListView.setVisibility(0);
        this.mNoDataView.setVisibility(8);
        if (this.mModel.C()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mSubTitleViewRoot.setVisibility(0);
                this.mFollowListView.removeHeaderView(this.mHeaderTitleViewRoot);
                textView = this.mSubTitleText;
                textView.setVisibility(0);
                this.mSelectView.setVisibility(0);
                if (FollowListSwitch.isOn()) {
                    if (this.mModel.D() == 0) {
                        string = getPageContext().getString(R.string.altogether_attention);
                    } else {
                        string = getPageContext().getString(R.string.each_concerned);
                    }
                    string2 = getPageContext().getString(R.string.forum_friend);
                } else {
                    if (this.mModel.D() == 0) {
                        string = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string = getPageContext().getString(R.string.each_concerned);
                    }
                    string2 = getPageContext().getString(R.string.person);
                }
                this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.not_have_attention)));
            } else {
                this.mSubTitleViewRoot.setVisibility(8);
                this.mHeaderTitleViewRoot.setVisibility(0);
                textView = this.mHeaderTitleText;
                textView.setVisibility(8);
                this.mSelectView.setVisibility(8);
                int i2 = this.mUserSex;
                if (i2 == 2) {
                    string = getPageContext().getString(R.string.she_attention_prefix);
                } else if (i2 == 1) {
                    string = getPageContext().getString(R.string.he_attention_prefix);
                } else {
                    string = getPageContext().getString(R.string.he_attention_prefix);
                }
                this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.not_have_attention_guest)));
                string2 = getPageContext().getString(R.string.person);
                z = !ListUtils.isEmpty(g1Var.a());
                if (!z) {
                    textView.setVisibility(0);
                    textView.setText(getPageContext().getString(R.string.we_common_fans));
                    return;
                }
                textView.setText(string + StringHelper.numberUniformFormat(g1Var.f53705e) + string2);
                return;
            }
        } else {
            this.mSubTitleViewRoot.setVisibility(8);
            this.mHeaderTitleViewRoot.setVisibility(0);
            textView = this.mHeaderTitleText;
            this.mSelectView.setVisibility(8);
            textView.setVisibility(8);
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                string = getPageContext().getString(R.string.my_fans_prefix);
                string2 = getPageContext().getString(R.string.fans_suffix);
                this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.not_have_fans)));
            } else {
                int i3 = this.mUserSex;
                if (i3 == 2) {
                    string = getPageContext().getString(R.string.her_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                } else if (i3 == 1) {
                    string = getPageContext().getString(R.string.his_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                } else {
                    string = getPageContext().getString(R.string.his_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                }
                this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.her_no_fan_guest)));
            }
        }
        z = false;
        if (!z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processNoData(g1 g1Var, boolean z) {
        String string;
        String string2;
        this.mFollowListView.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.C()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mSelectView.setVisibility(0);
                this.mSubTitleText.setVisibility(0);
                this.mSubTitleViewRoot.setVisibility(0);
                this.mHeaderTitleViewRoot.setVisibility(8);
                if (FollowListSwitch.isOn()) {
                    if (this.mModel.D() == 0) {
                        string = getPageContext().getString(R.string.altogether_attention);
                    } else {
                        string = getPageContext().getString(R.string.each_concerned);
                    }
                    string2 = getPageContext().getString(R.string.forum_friend);
                } else {
                    if (this.mModel.D() == 0) {
                        string = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string = getPageContext().getString(R.string.each_concerned);
                    }
                    string2 = getPageContext().getString(R.string.person);
                }
                this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(this.mModel.D() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
                TextView textView = this.mSubTitleText;
                textView.setText(string + 0 + string2);
                return;
            }
            this.mSelectView.setVisibility(8);
            this.mSubTitleText.setVisibility(8);
            this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.not_have_attention_guest)));
            return;
        }
        this.mSelectView.setVisibility(8);
        this.mSubTitleText.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (g1Var != null && !StringUtils.isNull(g1Var.f53707g) && !this.mIsBjhUser) {
                this.mNoDataView.getSuTextView().setText(getForbiddenTipSpannableString(g1Var.f53707g, g1Var.f53708h));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new StatisticItem("c13106").param("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.not_have_fans)));
            return;
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(R.string.her_no_fan_guest)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeAllForbiddenFans() {
        TiebaStatic.log(new StatisticItem("c13104").param("obj_locate", 1));
        if (!d.a.c.e.p.l.D()) {
            showToast(getString(R.string.neterror));
        } else {
            this.mForbiddenFansController.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendFollowSwitchMessage(int i2) {
        BdListView bdListView = this.mFollowListView;
        if (bdListView != null) {
            bdListView.setVisibility(8);
        }
        d.a.n0.w1.b bVar = this.mAdapter;
        if (bVar != null) {
            bVar.e();
        }
        PersonListModel personListModel = this.mModel;
        if (personListModel != null) {
            personListModel.N(0);
        }
        showLoadingView(this.mContainer);
        setTitleClickable(false);
        this.mModel.J(i2);
    }

    private void setTitleClickable(boolean z) {
        View view = this.mTitleLayout;
        if (view != null) {
            view.setClickable(z);
        }
    }

    private void showFollowSwitchGuideTip() {
        if (this.mFollowSwitchTipController == null) {
            d.a.n0.d0.e eVar = new d.a.n0.d0.e(getPageContext(), this.mTitleLayout);
            this.mFollowSwitchTipController = eVar;
            eVar.g0(R.drawable.bg_tip_blue_up);
            this.mFollowSwitchTipController.T(1);
            this.mFollowSwitchTipController.N(3000);
            this.mFollowSwitchTipController.j0(50);
        }
        this.mFollowSwitchTipController.l0(getResources().getString(R.string.click_to_view_tieba_attention));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGuideTip() {
        if (this.mSelectMenuGuideTipController == null) {
            d.a.n0.d0.e eVar = new d.a.n0.d0.e(getPageContext(), this.mSelectView.l);
            this.mSelectMenuGuideTipController = eVar;
            eVar.g0(R.drawable.bg_tip_blue_up);
            this.mSelectMenuGuideTipController.T(2);
            this.mSelectMenuGuideTipController.N(3000);
            this.mSelectMenuGuideTipController.j0(-10);
            this.mSelectMenuGuideTipController.k0(-16);
            this.mSelectMenuGuideTipController.M(new e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGetNetData() {
        d.a.n0.w1.b bVar = this.mAdapter;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
        this.mModel.K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void update(g1 g1Var, boolean z) {
        if (this.mModel != null && g1Var != null) {
            if (z && this.mHasNetData) {
                return;
            }
            if (!z) {
                this.mHasNetData = true;
                updateModel(g1Var);
            }
            updateLoadMoreView(g1Var);
            updateAdapter(g1Var, z);
            if (!this.mModel.C()) {
                d.a.m0.s.d.b.g0().c0(0);
            }
            updateView(g1Var, z);
            updateTitleView(g1Var);
        }
    }

    private void updateAdapter(g1 g1Var, boolean z) {
        d.a.n0.w1.b bVar = this.mAdapter;
        if (bVar != null) {
            if (!z) {
                if (g1Var.f53704d == 1) {
                    bVar.e();
                }
                this.mAdapter.f(g1Var.f53706f);
                this.mAdapter.a(g1Var);
                this.mAdapter.b();
                this.mAdapter.notifyDataSetChanged();
                return;
            }
            bVar.f(false);
            this.mAdapter.a(g1Var);
            this.mAdapter.b();
            this.mAdapter.notifyDataSetChanged();
        }
    }

    private void updateLoadMoreView(g1 g1Var) {
        if (g1Var == null) {
            return;
        }
        if (!g1Var.f53706f && !StringUtils.isNull(g1Var.f53707g) && !this.mIsBjhUser) {
            initAndRefreshForbiddenTipView(g1Var.f53707g, g1Var.f53708h);
            this.mFollowListView.removeFooterView(this.mForbiddenTipContainer);
            this.mFollowListView.addFooterView(this.mForbiddenTipContainer);
            this.mFollowListView.removeFooterView(this.mLoadMoreView.b());
            TiebaStatic.log(new StatisticItem("c13106").param("obj_locate", 2));
        } else if (!g1Var.f53706f) {
            this.mFollowListView.removeFooterView(this.mForbiddenTipContainer);
            this.mLoadMoreView.A(getString(R.string.no_more_data_tip));
            this.mLoadMoreView.f();
        } else {
            this.mFollowListView.removeFooterView(this.mForbiddenTipContainer);
            this.mLoadMoreView.A(getString(R.string.pb_load_more));
            this.mLoadMoreView.f();
        }
    }

    private void updateModel(g1 g1Var) {
        this.mModel.N(g1Var.f53704d);
    }

    private void updateTitleView(g1 g1Var) {
        if (this.mTitleLayout != null) {
            if (isLoadingViewAttached()) {
                hideLoadingView(this.mContainer);
                setTitleClickable(true);
            }
            if (g1Var.f53705e > 0) {
                processHaveData(g1Var);
            }
            int i2 = g1Var.j;
            if (i2 == 1) {
                this.mAttentionMode = AttentionMode.ALL;
                this.mTitleLayout.setVisibility(0);
                this.mTitleText.setText(R.string.all_attention);
                dealFollowSwitchGuideTip();
            } else if (i2 != 2) {
                this.mAttentionMode = AttentionMode.NULL;
            } else {
                this.mAttentionMode = AttentionMode.TIEBA;
                this.mTitleLayout.setVisibility(0);
                this.mTitleText.setText(R.string.tieba_attention);
            }
        }
    }

    private void updateView(g1 g1Var, boolean z) {
        if (this.mModel.E() == 0 || this.mModel.E() == 1) {
            hideLoadingView(this.mContainer);
            setTitleClickable(true);
            if (g1Var.f53705e > 0 && !ListUtils.isEmpty(g1Var.b())) {
                processHaveData(g1Var);
            } else {
                processNoData(g1Var, z);
            }
        }
    }

    public void hideFollowSwitchGuideTip() {
        d.a.n0.d0.e eVar = this.mFollowSwitchTipController;
        if (eVar == null || !eVar.J()) {
            return;
        }
        this.mFollowSwitchTipController.I();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1 && i2 == 11028) {
            StartChat();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        SkinManager.setBackgroundResource(this.mParent, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.mContainer, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        d.a.n0.w1.b bVar = this.mAdapter;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
        NoDataView noDataView = this.mNoDataView;
        if (noDataView != null) {
            noDataView.f(getPageContext(), i2);
        }
        this.mSelectView.m(i2);
        SkinManager.setBackgroundColor(this.mSubTitleText, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.mSubTitleText, R.color.CAM_X0109);
        SkinManager.setBackgroundColor(this.mHeaderTitleText, R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.mHeaderTitleText, R.color.CAM_X0109);
        getLayoutMode().k(i2 == 1);
        if (this.mSubTitleViewParent != null) {
            getLayoutMode().j(this.mSubTitleViewParent);
        }
        if (this.mHeaderTitleViewRoot != null) {
            getLayoutMode().j(this.mHeaderTitleViewRoot);
        }
        if (this.mForbiddenTipContainer != null) {
            SkinManager.setViewTextColor(this.mForbiddenTipView, R.color.CAM_X0109);
            SkinManager.setBackgroundColor(this.mForbiddenTipContainer, R.color.CAM_X0201);
        }
        this.mForbiddenFansController.d();
        this.mLoadMoreView.C(SkinManager.getColor(R.color.CAM_X0109));
        this.mLoadMoreView.d(i2);
        WebPManager.setPureDrawable(this.mFollowSwitch, R.drawable.icon_pure_topbar_fans_change, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_list_activity);
        initData(bundle);
        initUI();
        d.a.n0.o0.a.d dVar = new d.a.n0.o0.a.d(getPageContext(), getUniqueId());
        this.mForbiddenFansController = dVar;
        dVar.g(new m());
        registerListener(this.attentionListener);
        registerListener(this.mRemoveFansListener);
        this.mModel.H();
        this.mModel.G();
        if (this.isFirstEnter) {
            this.isFirstEnter = false;
            loadDataFirstTime();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.mAdapter != null) {
            this.mAdapter = null;
        }
        d.a.n0.d0.e eVar = this.mSelectMenuGuideTipController;
        if (eVar != null) {
            eVar.I();
        }
        d.a.n0.d0.e eVar2 = this.mFollowSwitchTipController;
        if (eVar2 != null) {
            eVar2.I();
        }
        this.mCoverTipNaviBar.i();
        this.mModel.I();
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            if (this.mSelectView.l()) {
                this.mSelectView.h();
                return false;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.C());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.mUserSex);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.mIsBjhUser);
    }
}
