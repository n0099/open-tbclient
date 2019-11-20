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
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MyForbiddenFansActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.e;
import com.baidu.tieba.myAttentionAndFans.ConcernSelectView;
import com.baidu.tieba.myAttentionAndFans.PersonListModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes5.dex */
public class PersonListActivity extends BaseActivity<PersonListActivity> {
    private PbListView dvS;
    private TextView fpB;
    private NavigationBarCoverTip fpw;
    private boolean hyi;
    private ConcernSelectView hyk;
    private com.baidu.tieba.c.d hyl;
    private View hym;
    private TextView hyn;
    private e hyo;
    private PersonListModel mModel;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private BdListView hya = null;
    private View hyb = null;
    private View hyc = null;
    private TextView hyd = null;
    private View hye = null;
    private TextView hyf = null;
    private b hyg = null;
    private NoPressedRelativeLayout hyh = null;
    private boolean eBk = true;
    private TextView aqd = null;
    private int dRb = 0;
    int hyj = 0;
    private final AntiHelper.a fvK = new AntiHelper.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.1
        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).O("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
        public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).O("obj_locate", at.a.LOCATE_LIKE_PERSON));
        }
    };
    private CustomMessageListener fvL = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Message<?> message;
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && (message = updateAttentionMessage.getmOrginalMessage()) != null && message.getTag() != null && message.getTag().equals(PersonListActivity.this.getPageContext().getUniqueId())) {
                    if (updateAttentionMessage.getData().cvM != null) {
                        if (AntiHelper.a(PersonListActivity.this.getActivity(), updateAttentionMessage.getData().cvM, PersonListActivity.this.fvK) != null) {
                            TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).O("obj_locate", at.a.LOCATE_LIKE_PERSON));
                        }
                    } else if (updateAttentionMessage.getData().isSucc && updateAttentionMessage.getData().isAttention) {
                        l.showToast(PersonListActivity.this.getPageContext().getPageActivity(), (int) R.string.attention_success);
                    }
                }
            }
        }
    };
    private HttpMessageListener hyp = new HttpMessageListener(1003396) { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Message<?> orginalMessage;
            if (httpResponsedMessage != null && httpResponsedMessage.getError() == 0 && (orginalMessage = httpResponsedMessage.getOrginalMessage()) != null && (orginalMessage.getExtra() instanceof Long)) {
                if (PersonListActivity.this.hyg.dB(((Long) orginalMessage.getExtra()).longValue())) {
                    PersonListActivity.this.hyg.aMx();
                    PersonListActivity.this.hyg.notifyDataSetChanged();
                }
                if (PersonListActivity.this.hyg.dQR) {
                    PersonListActivity.this.c(null, false);
                }
            }
        }
    };
    public PersonListModel.a hyq = new PersonListModel.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.10
        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public void U(String str, boolean z) {
            if (!z) {
                if (PersonListActivity.this.isProgressBarShown()) {
                    PersonListActivity.this.hideProgressBar();
                }
                if (!TextUtils.isEmpty(str)) {
                    PersonListActivity.this.showToast(str);
                }
                PersonListActivity.this.c(null, false);
            }
        }

        @Override // com.baidu.tieba.myAttentionAndFans.PersonListModel.a
        public as e(as asVar, boolean z) {
            PersonListActivity.this.a(asVar, z);
            return null;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_list_activity);
        initData(bundle);
        initUI();
        this.hyo = new e(getPageContext(), getUniqueId());
        this.hyo.a(new e.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.9
            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void a(int i, String str, boolean z, int i2, long j) {
                if (z) {
                    PersonListActivity.this.closeLoadingDialog();
                    if (i != 2260104) {
                        if (PersonListActivity.this.fpB == null) {
                            PersonListActivity.this.fpB = new TextView(PersonListActivity.this.getActivity());
                            PersonListActivity.this.fpB.setGravity(19);
                            PersonListActivity.this.fpB.setPadding(l.getDimens(PersonListActivity.this.getActivity(), R.dimen.ds34), 0, 0, 0);
                            PersonListActivity.this.fpB.setLayoutParams(new ViewGroup.LayoutParams(-1, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.tbds112)));
                            PersonListActivity.this.fpB.setTextSize(0, l.getDimens(PersonListActivity.this.getActivity(), R.dimen.fontsize30));
                            PersonListActivity.this.fpB.setTextColor(PersonListActivity.this.getResources().getColor(R.color.cp_cont_a));
                        }
                        PersonListActivity.this.fpB.setText(str);
                        if (i == 0) {
                            PersonListActivity.this.fpw.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.cp_link_tip_a_alpha95));
                        } else {
                            PersonListActivity.this.fpw.setBackgroundColor(PersonListActivity.this.getResources().getColor(R.color.nav_bar_tip_error));
                        }
                        PersonListActivity.this.fpw.a(PersonListActivity.this.getActivity(), PersonListActivity.this.fpB, 3000);
                    } else {
                        return;
                    }
                }
                if (i2 == 0) {
                    PersonListActivity.this.hyn.setText(PersonListActivity.this.getString(R.string.no_more_data_tip));
                    am.setViewTextColor(PersonListActivity.this.hyn, (int) R.color.cp_cont_d);
                }
            }

            @Override // com.baidu.tieba.forbidden.fans.e.a
            public void bih() {
                PersonListActivity.this.showLoadingDialog(PersonListActivity.this.getString(R.string.remove_fans_loading));
            }
        });
        registerListener(this.fvL);
        registerListener(this.hyp);
        this.mModel.aIS();
        if (this.eBk) {
            this.eBk = false;
            aMD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        am.setBackgroundResource(this.hyh, R.color.cp_bg_line_d);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        if (this.hyg != null) {
            this.hyg.notifyDataSetChanged();
        }
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(getPageContext(), i);
        }
        this.hyk.onChangeSkinType(i);
        am.setBackgroundColor(this.hyd, R.color.cp_bg_line_d);
        am.setViewTextColor(this.hyd, (int) R.color.cp_cont_d);
        am.setBackgroundColor(this.hyf, R.color.cp_bg_line_d);
        am.setViewTextColor(this.hyf, (int) R.color.cp_cont_d);
        getLayoutMode().setNightMode(i == 1);
        if (this.hyc != null) {
            getLayoutMode().onModeChanged(this.hyc);
        }
        if (this.hye != null) {
            getLayoutMode().onModeChanged(this.hye);
        }
        if (this.hym != null) {
            am.setViewTextColor(this.hyn, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.hym, R.color.cp_bg_line_d);
        }
        this.hyo.onChangeSkinType();
        this.dvS.setTextColor(am.getColor(R.color.cp_cont_d));
        this.dvS.changeSkin(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.hyg != null) {
            this.hyg = null;
        }
        if (this.hyl != null) {
            this.hyl.uQ();
        }
        this.fpw.onDestroy();
        this.mModel.removeListener();
        super.onDestroy();
    }

    private void initData(Bundle bundle) {
        this.mModel = new PersonListModel(this, this.hyq);
        if (bundle != null) {
            this.mModel.hi(bundle.getBoolean("follow", false));
            this.mModel.setId(bundle.getString("user_id"));
            this.dRb = bundle.getInt("user_sex");
            this.mModel.setSex(this.dRb);
            return;
        }
        Intent intent = getIntent();
        this.mModel.hi(intent.getBooleanExtra("follow", false));
        this.mModel.setId(intent.getStringExtra("user_id"));
        this.dRb = intent.getIntExtra("user_sex", 0);
        this.mModel.setSex(this.dRb);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("follow", this.mModel.aMz());
        bundle.putString("user_id", this.mModel.getId());
        bundle.putInt("user_sex", this.dRb);
    }

    private void initUI() {
        boolean z = true;
        this.hyh = (NoPressedRelativeLayout) findViewById(R.id.parent);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.aqd = this.mNavigationBar.setCenterTextTitle("");
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.hyb = findViewById(R.id.sub_title_root);
        this.hyc = this.hyb.findViewById(R.id.newheader_root);
        this.hyb.setVisibility(8);
        this.hyb.setClickable(false);
        this.hyb.setEnabled(false);
        this.hyd = (TextView) this.hyb.findViewById(R.id.person_list_title);
        this.hyk = (ConcernSelectView) findViewById(R.id.select_layout);
        this.fpw = (NavigationBarCoverTip) findViewById(R.id.navi_cover_tip_fan_list);
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        String id = this.mModel.getId();
        if (currentAccount != null && currentAccount.equals(id)) {
            if (this.mModel.aMz()) {
                this.aqd.setText(R.string.my_attention);
                this.hyh.setDispathEventAction(new NoPressedRelativeLayout.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.11
                    @Override // com.baidu.tbadk.core.view.NoPressedRelativeLayout.a
                    public void q(MotionEvent motionEvent) {
                        Rect rect = new Rect();
                        PersonListActivity.this.hyk.getGlobalVisibleRect(rect);
                        if (!PersonListActivity.this.hyk.bNh() || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                            PersonListActivity.this.hyh.setNeedInterceptTouchEvent(false);
                            return;
                        }
                        PersonListActivity.this.hyk.bNg();
                        PersonListActivity.this.hyh.setNeedInterceptTouchEvent(true);
                    }
                });
            } else {
                this.aqd.setText(R.string.fans);
            }
        } else if (this.mModel.aMz()) {
            if (this.dRb == 2) {
                this.aqd.setText(R.string.her_attention_people);
            } else if (this.dRb == 1) {
                this.aqd.setText(R.string.his_attention_people);
            } else {
                this.aqd.setText(R.string.his_attention_people);
            }
        } else if (this.dRb == 2) {
            this.aqd.setText(R.string.attention_to_her);
        } else {
            this.aqd.setText(R.string.attention_to_him);
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserData userData;
                if (view != null && (view.getTag() instanceof Integer)) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    if (PersonListActivity.this.hyg != null && PersonListActivity.this.hyg.getItemViewType(intValue) == 0 && (userData = (UserData) PersonListActivity.this.hyg.getItem(intValue)) != null && userData.getUserId() != null) {
                        if (PersonListActivity.this.mModel.aMz()) {
                            TiebaStatic.log(new an("c12772").bS("obj_locate", "1").bS("obj_param1", userData.getUserId()));
                        } else {
                            TiebaStatic.log(new an("c12605").O("obj_locate", 1).bS("obj_param1", userData.getUserId()));
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), userData.getUserId(), userData.getName_show(), null, AddFriendActivityConfig.TYPE_FOCUS)));
                    }
                }
            }
        };
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.13
            /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.myAttentionAndFans.PersonListActivity */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.hyj = ((Integer) view.getTag()).intValue();
                String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount2 != null && currentAccount2.length() > 0) {
                    PersonListActivity.this.bNm();
                } else {
                    TbadkCoreApplication.getInst().login(PersonListActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(PersonListActivity.this.getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_CHAT)));
                }
            }
        };
        View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonListActivity.this.bNl();
            }
        };
        if (this.mModel.getId() == null || !this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            z = false;
        }
        int sex = this.mModel.getSex();
        if (getIntent().getBooleanExtra("follow", false)) {
            this.hyg = new d(this, getIntent().getBooleanExtra("follow", false), z, sex, onClickListener, onClickListener2, onClickListener3);
            this.hyb.setVisibility(0);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.hyh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        } else {
            this.hyg = new c(this, z, sex, onClickListener, onClickListener3);
            this.hyb.setVisibility(8);
            this.mNoDataView = NoDataViewFactory.a(getPageContext().getPageActivity(), this.hyh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(getActivity(), R.dimen.tbds530)), null, null);
        }
        this.hya = (BdListView) findViewById(R.id.list);
        this.hya.setAdapter((ListAdapter) this.hyg);
        bNk();
        this.hya.setOnSrollToBottomListener(new BdListView.e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.2
            @Override // com.baidu.adp.widget.ListView.BdListView.e
            public void onScrollToBottom() {
                if (PersonListActivity.this.hyg != null && PersonListActivity.this.hyg.isHasMore()) {
                    if (PersonListActivity.this.dvS != null && !PersonListActivity.this.dvS.isLoading()) {
                        PersonListActivity.this.dvS.startLoadData();
                    }
                    PersonListActivity.this.bNl();
                }
            }
        });
        this.hyk.setOnExpandListener(new ConcernSelectView.a() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.3
            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void np(boolean z2) {
                if (z2) {
                    PersonListActivity.this.bfg();
                } else if (PersonListActivity.this.hyl != null) {
                    PersonListActivity.this.hyl.uQ();
                }
            }

            @Override // com.baidu.tieba.myAttentionAndFans.ConcernSelectView.a
            public void rG(int i) {
                PersonListActivity.this.hya.setSelection(0);
                PersonListActivity.this.mModel.mf(i);
            }
        });
        if (com.baidu.tbadk.core.sharedPref.b.alP().getInt(SharedPrefConfig.KEY_MY_CONCERNED_PERSON_TIP, 0) < 2 && z && this.mModel.aMz()) {
            this.hyk.bNf();
        }
        this.hyk.setVisibility(8);
        this.hye.setVisibility(8);
        this.dvS = new PbListView(getActivity());
        this.dvS.getView();
        this.dvS.setContainerBackgroundColorResId(R.color.cp_bg_line_e);
        this.dvS.setLineGone();
        this.dvS.setTextColor(am.getColor(R.color.cp_cont_j));
        this.dvS.setTextSize(R.dimen.tbfontsize33);
        this.dvS.setNoMoreTextColorId(R.color.cp_cont_e);
        this.dvS.setHeight(l.getDimens(getActivity(), R.dimen.tbds182));
        this.hya.setNextPage(this.dvS);
    }

    private void bNk() {
        this.hye = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_list_newheader, (ViewGroup) null);
        this.hye.setVisibility(8);
        this.hye.setClickable(false);
        this.hye.setEnabled(false);
        this.hyf = (TextView) this.hye.findViewById(R.id.person_list_title);
        this.hya.addHeaderView(this.hye, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfg() {
        if (this.hyl == null) {
            this.hyl = new com.baidu.tieba.c.d(getPageContext(), this.hyk.hxG);
            this.hyl.bB(R.drawable.bg_tip_blue_up);
            this.hyl.pf(2);
            this.hyl.bC(3000);
            this.hyl.pg(-10);
            this.hyl.setYOffset(-16);
            this.hyl.c(new View.OnClickListener() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonListActivity.this.hyl != null) {
                        PersonListActivity.this.hyl.uQ();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(as asVar, boolean z) {
        if (this.mModel != null && asVar != null && (!z || !this.hyi)) {
            if (!z) {
                this.hyi = true;
                d(asVar);
            }
            b(asVar);
            d(asVar, z);
            if (!this.mModel.aMz()) {
                com.baidu.tbadk.coreExtra.messageCenter.b.aqr().setMsgFans(0);
            }
            b(asVar, z);
        }
    }

    private void b(as asVar) {
        if (asVar != null) {
            if (!asVar.hasMore && !StringUtils.isNull(asVar.bZB)) {
                aY(asVar.bZB, asVar.type);
                this.hya.removeFooterView(this.hym);
                this.hya.addFooterView(this.hym);
                this.hya.removeFooterView(this.dvS.getView());
                TiebaStatic.log(new an("c13106").O("obj_locate", 2));
            } else if (!asVar.hasMore) {
                this.hya.removeFooterView(this.hym);
                this.dvS.setText(getString(R.string.no_more_data_tip));
                this.dvS.endLoadData();
            } else {
                this.hya.removeFooterView(this.hym);
                this.dvS.setText(getString(R.string.pb_load_more));
                this.dvS.endLoadData();
            }
        }
    }

    private void b(as asVar, boolean z) {
        if (this.mModel.getPage() == 0 || this.mModel.getPage() == 1) {
            hideProgressBar();
            if (asVar.bZA > 0 && !v.isEmpty(asVar.ahB())) {
                c(asVar);
            } else {
                c(asVar, z);
            }
        }
    }

    private void c(as asVar) {
        TextView textView;
        String string;
        String string2;
        boolean z;
        String string3;
        String string4;
        if (asVar != null) {
            this.hya.setVisibility(0);
            this.mNoDataView.setVisibility(8);
            if (this.mModel.aMz()) {
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    this.hyb.setVisibility(0);
                    this.hya.removeHeaderView(this.hye);
                    TextView textView2 = this.hyd;
                    textView2.setVisibility(0);
                    this.hyk.setVisibility(0);
                    if (this.mModel.getLoadType() == 0) {
                        string4 = getPageContext().getString(R.string.all_concerned);
                    } else {
                        string4 = getPageContext().getString(R.string.each_concerned);
                    }
                    String string5 = getPageContext().getString(R.string.person);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.not_have_attention));
                    z = false;
                    string = string4;
                    textView = textView2;
                    string2 = string5;
                } else {
                    this.hyb.setVisibility(8);
                    this.hye.setVisibility(0);
                    TextView textView3 = this.hyf;
                    textView3.setVisibility(8);
                    this.hyk.setVisibility(8);
                    if (this.dRb == 2) {
                        string3 = getPageContext().getString(R.string.she_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.her_no_attention_other));
                    } else if (this.dRb == 1) {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.him_no_attention_other));
                    } else {
                        string3 = getPageContext().getString(R.string.he_attention_prefix);
                        this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.him_no_attention_other));
                    }
                    String string6 = getPageContext().getString(R.string.person);
                    string = string3;
                    textView = textView3;
                    z = v.isEmpty(asVar.ahC()) ? false : true;
                    string2 = string6;
                }
            } else {
                this.hyb.setVisibility(8);
                this.hye.setVisibility(0);
                textView = this.hyf;
                this.hyk.setVisibility(8);
                textView.setVisibility(8);
                if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                    string = getPageContext().getString(R.string.my_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.not_have_fans));
                    z = false;
                } else if (this.dRb == 2) {
                    string = getPageContext().getString(R.string.her_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.her_no_fan_other));
                    z = false;
                } else if (this.dRb == 1) {
                    string = getPageContext().getString(R.string.his_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.him_no_fan_other));
                    z = false;
                } else {
                    string = getPageContext().getString(R.string.his_fans_prefix);
                    string2 = getPageContext().getString(R.string.fans_suffix);
                    this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.him_no_fan_other));
                    z = false;
                }
            }
            if (z) {
                textView.setVisibility(0);
                textView.setText(getPageContext().getString(R.string.we_common_fans));
                return;
            }
            textView.setText(string + aq.numberUniformFormat(asVar.bZA) + string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(as asVar, boolean z) {
        String string;
        this.hya.setVisibility(8);
        if (!z) {
            this.mNoDataView.setVisibility(0);
        }
        if (this.mModel.aMz()) {
            if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
                this.hyk.setVisibility(0);
                this.hyd.setVisibility(0);
                this.hyb.setVisibility(0);
                this.hye.setVisibility(8);
                if (this.mModel.getLoadType() == 0) {
                    string = getPageContext().getString(R.string.all_concerned);
                } else {
                    string = getPageContext().getString(R.string.each_concerned);
                }
                String string2 = getPageContext().getString(R.string.person);
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(this.mModel.getLoadType() == 0 ? R.string.not_have_attention : R.string.not_have_each_attention));
                this.hyd.setText(string + 0 + string2);
                return;
            }
            this.hyk.setVisibility(8);
            this.hyd.setVisibility(8);
            if (this.dRb == 2) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.her_no_attention_other));
                return;
            } else if (this.dRb == 1) {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.him_no_attention_other));
                return;
            } else {
                this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.him_no_attention_other));
                return;
            }
        }
        this.hyk.setVisibility(8);
        this.hyd.setVisibility(8);
        if (this.mModel.getId() != null && this.mModel.getId().equals(TbadkCoreApplication.getCurrentAccount())) {
            if (asVar != null && !StringUtils.isNull(asVar.bZB)) {
                this.mNoDataView.getSuTextView().setText(aZ(asVar.bZB, asVar.type));
                this.mNoDataView.getSuTextView().setMovementMethod(LinkMovementMethod.getInstance());
                this.mNoDataView.getSuTextView().setHighlightColor(getResources().getColor(R.color.transparent));
                TiebaStatic.log(new an("c13106").O("obj_locate", 1));
                return;
            }
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.not_have_fans));
        } else if (this.dRb == 2) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.her_no_fan_other));
        } else if (this.dRb == 1) {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.him_no_fan_other));
        } else {
            this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(R.string.him_no_fan_other));
        }
    }

    private void d(as asVar) {
        this.mModel.setPage(asVar.pageNum);
    }

    private void d(as asVar, boolean z) {
        if (this.hyg != null) {
            if (!z) {
                if (asVar.pageNum == 1) {
                    this.hyg.resetData();
                }
                this.hyg.setHasMore(asVar.hasMore);
                this.hyg.a(asVar);
                this.hyg.aMx();
                this.hyg.notifyDataSetChanged();
                return;
            }
            this.hyg.setHasMore(false);
            this.hyg.a(asVar);
            this.hyg.aMx();
            this.hyg.notifyDataSetChanged();
        }
    }

    private void aMD() {
        showProgressBar(true, 0, 0);
        this.mModel.aMA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNl() {
        if (this.hyg != null) {
            this.hyg.notifyDataSetChanged();
        }
        this.mModel.aMA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNm() {
        UserData userData;
        if (this.hyg != null && this.hyg.getItemViewType(this.hyj) == 0 && (userData = (UserData) this.hyg.getItem(this.hyj)) != null && userData.getUserId() != null && userData.getUserName() != null && !userData.getUserId().equals(TbadkCoreApplication.getCurrentAccount())) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "enter_chat", "personlistclick", 1, new Object[0]);
            try {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(getPageContext().getPageActivity(), Long.parseLong(userData.getUserId()), userData.getUserName(), userData.getName_show(), userData.getPortrait(), userData.getSex())));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 11028) {
            bNm();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hyk.bNh()) {
                this.hyk.bNg();
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void aY(String str, int i) {
        if (this.hym == null) {
            this.hym = LayoutInflater.from(getActivity()).inflate(R.layout.forbidden_tip_layout, (ViewGroup) null);
            this.hyn = (TextView) this.hym.findViewById(R.id.view_forbidden_tip);
            am.setViewTextColor(this.hyn, (int) R.color.cp_cont_d);
            am.setBackgroundColor(this.hym, R.color.cp_bg_line_d);
        }
        if (StringUtils.isNull(str)) {
            this.hym.setVisibility(8);
            return;
        }
        this.hyn.setText(aZ(str, i));
        this.hyn.setMovementMethod(LinkMovementMethod.getInstance());
        this.hyn.setHighlightColor(getResources().getColor(R.color.transparent));
    }

    private SpannableStringBuilder aZ(String str, int i) {
        String string;
        String str2 = null;
        if (StringUtils.isNull(str)) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        switch (i) {
            case 1:
                spannableStringBuilder.append((CharSequence) "，");
                string = getString(R.string.click_for_look_all);
                spannableStringBuilder.append((CharSequence) string);
                break;
            case 2:
                spannableStringBuilder.append((CharSequence) "，");
                String string2 = getString(R.string.remove_all_forbidden_fans);
                spannableStringBuilder.append((CharSequence) string2);
                string = null;
                str2 = string2;
                break;
            case 3:
                string = getString(R.string.click_for_look_all);
                str2 = getString(R.string.remove_all_forbidden_fans);
                spannableStringBuilder.append((CharSequence) "，");
                spannableStringBuilder.append((CharSequence) string);
                spannableStringBuilder.append((CharSequence) getString(R.string.tip_or));
                spannableStringBuilder.append((CharSequence) str2);
                break;
            default:
                string = null;
                break;
        }
        if (!StringUtils.isNull(string)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), string, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.5
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.bNo();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(am.getColor(R.color.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        if (!StringUtils.isNull(str2)) {
            UtilHelper.setSpan(spannableStringBuilder, spannableStringBuilder.toString(), str2, new ClickableSpan() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivity.6
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    PersonListActivity.this.bNn();
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(am.getColor(R.color.cp_link_tip_a));
                    textPaint.setUnderlineText(false);
                    textPaint.clearShadowLayer();
                }
            });
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNn() {
        TiebaStatic.log(new an("c13104").O("obj_locate", 1));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            this.hyo.removeAll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNo() {
        TiebaStatic.log(new an("c13103"));
        if (!l.isNetOk()) {
            showToast(getString(R.string.neterror));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MyForbiddenFansActivityConfig(getActivity())));
        }
    }
}
