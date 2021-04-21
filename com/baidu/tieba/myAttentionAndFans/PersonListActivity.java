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
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.myAttentionAndFans.ConcernSelectView;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.NavigationBarCoverTip;
import d.b.i0.r.q.g1;
import d.b.j0.n0.a.d;
/* loaded from: classes3.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    public static final int MAX_TIP_COUNT = 2;
    public static final String TAG_FOLLOW = "follow";
    public static final String TAG_ID = "user_id";
    public static final String TAG_PORTRAIT = "portrait";
    public static final String TAG_SEX = "user_sex";
    public static final String TAG_TOTLEFOLLOWNUM = "total_follow_num";
    public static final int TYPE_SHOW_BOTH_REMOVE_AND_LOOK = 3;
    public static final int TYPE_SHOW_LOOK_ALL = 1;
    public static final int TYPE_SHOW_REMOVE_ALL = 2;
    public NavigationBarShadowView mConcernSelectShadowView;
    public RelativeLayout mContainer;
    public NavigationBarCoverTip mCoverTipNaviBar;
    public d.b.j0.n0.a.d mForbiddenFansController;
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
    public d.b.j0.b0.e mSelectMenuGuideTipController;
    public ConcernSelectView mSelectView;
    public BdListView mFollowListView = null;
    public View mSubTitleViewRoot = null;
    public View mSubTitleViewParent = null;
    public TextView mSubTitleText = null;
    public View mHeaderTitleViewRoot = null;
    public TextView mHeaderTitleText = null;
    public d.b.j0.v1.b mAdapter = null;
    public NoPressedRelativeLayout mParent = null;
    public boolean isFirstEnter = true;
    public TextView mTitleText = null;
    public int mUserSex = 0;
    public boolean mIsBjhUser = false;
    public int mTotalFollowNum = 0;
    public int mChatPersonPosition = 0;
    public final AntiHelper.k mAntiInjectListener = new g();
    public CustomMessageListener attentionListener = new h(2001115);
    public HttpMessageListener mRemoveFansListener = new i(CmdConfigHttp.CMD_REMOVE_FANS);
    public AbsListView.OnScrollListener mOnScrollListener = new j();
    public PersonListModel.c mCallBack = new l();

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonListActivity.this.startGetNetData();
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class c implements ConcernSelectView.g {
        public c() {
        }

        @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.g
        public void a(int i) {
            PersonListActivity.this.mFollowListView.setSelection(0);
            PersonListActivity.this.mModel.B(i);
        }

        @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.g
        public void onExpand(boolean z) {
            if (z) {
                PersonListActivity.this.showGuideTip();
            } else if (PersonListActivity.this.mSelectMenuGuideTipController != null) {
                PersonListActivity.this.mSelectMenuGuideTipController.H();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonListActivity.this.mSelectMenuGuideTipController != null) {
                PersonListActivity.this.mSelectMenuGuideTipController.H();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends ClickableSpan {
        public e() {
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

    /* loaded from: classes3.dex */
    public class f extends ClickableSpan {
        public f() {
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

    /* loaded from: classes3.dex */
    public class g implements AntiHelper.k {
        public g() {
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(d.b.i0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(d.b.i0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
        }
    }

    /* loaded from: classes3.dex */
    public class h extends CustomMessageListener {
        public h(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || updateAttentionMessage.getData().f13364c == null || (message = updateAttentionMessage.getmOrginalMessage()) == null || message.getTag() == null || !message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId()) || updateAttentionMessage.getData().k == null || AntiHelper.t(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().k, PersonListActivity.this.mAntiInjectListener) == null) {
                    return;
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends HttpMessageListener {
        public i(int i) {
            super(i);
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
            if (PersonListActivity.this.mAdapter.f63424f) {
                PersonListActivity.this.processNoData(null, false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements AbsListView.OnScrollListener {
        public j() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                String id = PersonListActivity.this.mModel.getId();
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.y()) {
                    PersonListActivity.this.mNavigationShadowView.a();
                } else {
                    PersonListActivity.this.mConcernSelectShadowView.a();
                }
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (PersonListActivity.this.mModel == null) {
                return;
            }
            if (i == 1 || i == 2) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                String id = PersonListActivity.this.mModel.getId();
                if (currentAccount == null || !currentAccount.equals(id) || !PersonListActivity.this.mModel.y()) {
                    PersonListActivity.this.mNavigationShadowView.c();
                } else {
                    PersonListActivity.this.mConcernSelectShadowView.c();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements d.e {
        public k() {
        }

        @Override // d.b.j0.n0.a.d.e
        public void a() {
            PersonListActivity personListActivity = PersonListActivity.this;
            personListActivity.showLoadingDialog(personListActivity.getString(R.string.remove_fans_loading));
        }

        @Override // d.b.j0.n0.a.d.e
        public void b(int i, String str, boolean z, int i2, long j) {
            if (z) {
                PersonListActivity.this.closeLoadingDialog();
                if (i == 2260104) {
                    return;
                }
                if (PersonListActivity.this.mResultTipView == null) {
                    PersonListActivity.this.mResultTipView = new TextView(PersonListActivity.this.getActivity());
                    PersonListActivity.this.mResultTipView.setGravity(19);
                    PersonListActivity.this.mResultTipView.setPadding(d.b.c.e.p.l.g(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                    PersonListActivity.this.mResultTipView.setLayoutParams(new ViewGroup.LayoutParams(-1, d.b.c.e.p.l.g(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                    PersonListActivity.this.mResultTipView.setTextSize(0, d.b.c.e.p.l.g(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                    PersonListActivity.this.mResultTipView.setTextColor(PersonListActivity.this.getResources().getColor(R.color.CAM_X0101));
                }
                PersonListActivity.this.mResultTipView.setText(str);
                if (i == 0) {
                    PersonListActivity.this.mCoverTipNaviBar.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                } else {
                    PersonListActivity.this.mCoverTipNaviBar.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                }
                PersonListActivity.this.mCoverTipNaviBar.m(PersonListActivity.this.getActivity(), PersonListActivity.this.mResultTipView, 3000);
            }
            if (i2 == 0) {
                PersonListActivity.this.mForbiddenTipView.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                SkinManager.setViewTextColor(PersonListActivity.this.mForbiddenTipView, R.color.CAM_X0109);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements PersonListModel.c {
        public l() {
        }

        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.c
        public g1 a(g1 g1Var, boolean z) {
            if (g1Var != null && g1Var.f51539e != PersonListActivity.this.mTotalFollowNum && PersonListActivity.this.mModel != null && PersonListActivity.this.mModel.y() && PersonListActivity.this.mModel.z() == 0) {
                PersonListActivity.this.mModel.I(PersonListActivity.this.mPortrait);
            }
            PersonListActivity.this.update(g1Var, z);
            return null;
        }

        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.c
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

    /* loaded from: classes3.dex */
    public class m implements NoPressedRelativeLayout.a {
        public m() {
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

    /* loaded from: classes3.dex */
    public class n implements View.OnClickListener {
        public n() {
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
            if (PersonListActivity.this.mModel.y()) {
                TiebaStatic.log(new StatisticItem("c12772").param("obj_locate", "1").param("obj_param1", userData.getUserId()));
            } else {
                TiebaStatic.log(new StatisticItem("c12605").param("obj_locate", 1).param("obj_param1", userData.getUserId()));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), null, AddFriendActivityConfig.TYPE_FOCUS)));
        }
    }

    /* loaded from: classes3.dex */
    public class o implements View.OnClickListener {
        public o() {
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
        d.b.j0.v1.b bVar = this.mAdapter;
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

    private void attatchListTitleHeader() {
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.mHeaderTitleViewRoot = inflate;
        inflate.setVisibility(8);
        this.mHeaderTitleViewRoot.setClickable(false);
        this.mHeaderTitleViewRoot.setEnabled(false);
        this.mHeaderTitleText = (TextView) this.mHeaderTitleViewRoot.findViewById(R.id.person_list_title);
        this.mFollowListView.addHeaderView(this.mHeaderTitleViewRoot, null, false);
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
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str3, new e());
        }
        if (!StringUtils.isNull(str2)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str2, new f());
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
            personListModel.G(bundle.getBoolean("follow", false));
            this.mModel.F(bundle.getString("user_id"));
            this.mUserSex = bundle.getInt("user_sex");
            this.mIsBjhUser = bundle.getBoolean(IntentConfig.IS_BJH_USER, false);
            this.mTotalFollowNum = bundle.getInt("total_follow_num");
            this.mPortrait = bundle.getString("portrait");
            this.mModel.setSex(this.mUserSex);
            return;
        }
        Intent intent = getIntent();
        this.mModel.G(intent.getBooleanExtra("follow", false));
        this.mModel.F(intent.getStringExtra("user_id"));
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
            if (this.mModel.y()) {
                this.mTitleText.setText(R.string.my_attention);
                this.mParent.setDispathEventAction(new m());
            } else {
                this.mTitleText.setText(R.string.fans);
            }
        } else if (this.mModel.y()) {
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
        n nVar = new n();
        o oVar = new o();
        a aVar = new a();
        z = (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.mAdapter = new d.b.j0.v1.d(this, getIntent().getBooleanExtra("follow", false), z, sex, nVar, oVar, aVar);
            this.mSubTitleViewRoot.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mParent, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, d.b.c.e.p.l.g(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.mAdapter = new d.b.j0.v1.c(this, z, sex, nVar, aVar);
            this.mSubTitleViewRoot.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.mParent, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.GIFT, d.b.c.e.p.l.g(getActivity(), R.dimen.tbds530)), null, null);
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
        this.mLoadMoreView.r(d.b.c.e.p.l.g(getActivity(), R.dimen.tbds182));
        this.mFollowListView.setNextPage(this.mLoadMoreView);
    }

    private void loadDataFirstTime() {
        showLoadingView(this.mContainer);
        this.mModel.E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lookForAllForbiddenFans() {
        TiebaStatic.log(new StatisticItem("c13103"));
        if (!d.b.c.e.p.l.C()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage(2002001, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01a7  */
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
        if (this.mModel.y()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mSubTitleViewRoot.setVisibility(0);
                this.mFollowListView.removeHeaderView(this.mHeaderTitleViewRoot);
                textView = this.mSubTitleText;
                textView.setVisibility(0);
                this.mSelectView.setVisibility(0);
                if (this.mModel.z() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                string2 = getPageContext().getString(R.string.person);
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
                textView.setText(string + StringHelper.numberUniformFormat(g1Var.f51539e) + string2);
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
        this.mFollowListView.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.y()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.mSelectView.setVisibility(0);
                this.mSubTitleText.setVisibility(0);
                this.mSubTitleViewRoot.setVisibility(0);
                this.mHeaderTitleViewRoot.setVisibility(8);
                if (this.mModel.z() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.e.d(null, getResources().getString(this.mModel.z() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention)));
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
            if (g1Var != null && !StringUtils.isNull(g1Var.f51541g) && !this.mIsBjhUser) {
                this.mNoDataView.getSuTextView().setText(getForbiddenTipSpannableString(g1Var.f51541g, g1Var.f51542h));
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
        if (!d.b.c.e.p.l.C()) {
            showToast(getString(R.string.neterror));
        } else {
            this.mForbiddenFansController.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGuideTip() {
        if (this.mSelectMenuGuideTipController == null) {
            d.b.j0.b0.e eVar = new d.b.j0.b0.e(getPageContext(), this.mSelectView.l);
            this.mSelectMenuGuideTipController = eVar;
            eVar.c0(R.drawable.bg_tip_blue_up);
            this.mSelectMenuGuideTipController.S(2);
            this.mSelectMenuGuideTipController.M(3000);
            this.mSelectMenuGuideTipController.f0(-10);
            this.mSelectMenuGuideTipController.g0(-16);
            this.mSelectMenuGuideTipController.L(new d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGetNetData() {
        d.b.j0.v1.b bVar = this.mAdapter;
        if (bVar != null) {
            bVar.notifyDataSetChanged();
        }
        this.mModel.E();
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
            if (!this.mModel.y()) {
                d.b.i0.s.d.b.g0().c0(0);
            }
            updateView(g1Var, z);
        }
    }

    private void updateAdapter(g1 g1Var, boolean z) {
        d.b.j0.v1.b bVar = this.mAdapter;
        if (bVar != null) {
            if (!z) {
                if (g1Var.f51538d == 1) {
                    bVar.e();
                }
                this.mAdapter.f(g1Var.f51540f);
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
        if (!g1Var.f51540f && !StringUtils.isNull(g1Var.f51541g) && !this.mIsBjhUser) {
            initAndRefreshForbiddenTipView(g1Var.f51541g, g1Var.f51542h);
            this.mFollowListView.removeFooterView(this.mForbiddenTipContainer);
            this.mFollowListView.addFooterView(this.mForbiddenTipContainer);
            this.mFollowListView.removeFooterView(this.mLoadMoreView.b());
            TiebaStatic.log(new StatisticItem("c13106").param("obj_locate", 2));
        } else if (!g1Var.f51540f) {
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
        this.mModel.H(g1Var.f51538d);
    }

    private void updateView(g1 g1Var, boolean z) {
        if (this.mModel.A() == 0 || this.mModel.A() == 1) {
            hideLoadingView(this.mContainer);
            if (g1Var.f51539e > 0 && !ListUtils.isEmpty(g1Var.b())) {
                processHaveData(g1Var);
            } else {
                processNoData(g1Var, z);
            }
        }
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
        d.b.j0.v1.b bVar = this.mAdapter;
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
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_list_activity);
        initData(bundle);
        initUI();
        d.b.j0.n0.a.d dVar = new d.b.j0.n0.a.d(getPageContext(), getUniqueId());
        this.mForbiddenFansController = dVar;
        dVar.g(new k());
        registerListener(this.attentionListener);
        registerListener(this.mRemoveFansListener);
        this.mModel.C();
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
        d.b.j0.b0.e eVar = this.mSelectMenuGuideTipController;
        if (eVar != null) {
            eVar.H();
        }
        this.mCoverTipNaviBar.i();
        this.mModel.D();
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
        bundle.putBoolean("follow", this.mModel.y());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.mUserSex);
        bundle.putBoolean(IntentConfig.IS_BJH_USER, this.mIsBjhUser);
    }
}
