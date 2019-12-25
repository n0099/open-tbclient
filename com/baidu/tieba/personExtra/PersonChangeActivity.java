package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import java.util.Calendar;
import java.util.Date;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private ImageView cGD;
    private com.baidu.tbadk.coreExtra.view.c dhg;
    private View jfW;
    private TextView jgA;
    private RelativeLayout jgB;
    private TextView jgC;
    private TextView jgD;
    private View jgq;
    private TextView jgr;
    private View jgs;
    private View jgt;
    private View jgu;
    private View jgv;
    private com.baidu.tbadk.core.dialog.a jgw;
    private String jgx;
    private LinearLayout jgy;
    private TextView jgz;
    private View mCloseView;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public final int jfU = 90;
    private Boolean jfV = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView hxI = null;
    private LinearLayout fZh = null;
    private ScrollView jfX = null;
    private TextView jfY = null;
    private RelativeLayout jfZ = null;
    private TextView jga = null;
    private LinearLayout jgb = null;
    private TextView erQ = null;
    private EditText fdJ = null;
    private LinearLayout jgc = null;
    private TextView jgd = null;
    private TextView jge = null;
    private TextView jgf = null;
    private InputMethodManager mInputManager = null;
    private boolean jgg = false;
    private PersonChangeModel jgh = null;
    protected HeadImageView geA = null;
    private com.baidu.adp.widget.ImageView.a hqP = null;
    private a jgi = null;
    private b jgj = null;
    private ProgressBar jgk = null;
    private DialogInterface.OnCancelListener fZZ = null;
    private com.baidu.tbadk.core.dialog.a hPv = null;
    private com.baidu.tbadk.core.dialog.i jgl = null;
    private boolean jgm = false;
    private boolean gPH = false;
    private boolean jgn = false;
    private int mSex = 0;
    private final int jgo = 500;
    private boolean jgp = false;
    private boolean gjL = false;
    private final View.OnClickListener jgE = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.jgh.ctI().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.jgm = true;
            }
            if (PersonChangeActivity.this.jgm) {
                PersonChangeActivity.this.hPv.aBW();
                return;
            }
            if (PersonChangeActivity.this.jgh != null && PersonChangeActivity.this.jgh.ctI().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.jfV.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.jgh.ctI());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.jgh.ctI());
                }
                PersonChangeActivity.this.ctG();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener gkv = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.gjL = true;
                        PersonChangeActivity.this.jgx = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener jgF = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.jgh != null && PersonChangeActivity.this.jgh.ctI() != null && personChangeData != null) {
                    PersonChangeActivity.this.jgh.ctI().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.jgh.ctI().setMem(personChangeData.getMen());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ax(bundle);
        aUX();
        if (bundle != null) {
            this.jfV = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.jfV = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.gkv);
        registerListener(this.jgF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gkv);
        if (this.jgi != null) {
            this.jgi.cancel();
        }
        if (this.jgj != null) {
            this.jgj.cancel();
        }
        if (this.jgk != null) {
            this.jgk.setVisibility(8);
        }
        if (this.fdJ != null) {
            this.fdJ.addTextChangedListener(null);
        }
        if (this.dhg != null) {
            this.dhg.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.geA || view == this.jgv) {
            if (this.jgh != null && this.jgh.jgJ != null && !this.jgh.jgJ.canModifyAvatar()) {
                if (!StringUtils.isNull(this.jgh.jgJ.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.jgh.jgJ.getCantModifyAvatarDesc());
                    return;
                } else {
                    l.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.person_cant_edit_avatar_default_tip);
                    return;
                }
            }
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                ctB();
            }
        } else if (view == this.jfW) {
            if (!this.gPH && !this.jgn) {
                finish();
            }
            if (this.jfV.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.gPH) {
                ctD();
            } else if (this.jgn) {
                ctH();
            }
        } else if (view == this.jfZ) {
            ctE();
        } else if (view == this.jgb) {
            ctz();
        } else if (view == this.fdJ) {
            zF(800);
        } else if (view == this.jgt) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                ctx();
            } else {
                int nickNameLeftDays = this.jgh.ctI().getNickNameLeftDays();
                if (this.jgh.ctI().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.sz(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
                        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), 24);
                                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_MY_DATA, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                                    PersonChangeActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                                    TiebaStatic.log(TbadkCoreStatisticKey.MODIFY_NICK_ENTER_OPNEN_MEM_CLICK);
                                } else {
                                    PersonChangeActivity.this.showToast(R.string.neterror);
                                }
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(getPageContext()).aBW();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.jgq) {
            if (this.jgh == null || this.jgh.ctI() == null || StringUtils.isNull(this.jgh.ctI().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.jgB) {
            PersonConstellationActivity.a(getActivity(), this.jgh.ctI().getBirthdayTime(), this.jgh.ctI().getBirthdayShowStatus());
        }
    }

    private void ctx() {
        if (this.jgw == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.jgw = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.jgw.aK(inflate);
            this.jgw.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.d.chp(), true)));
                    aVar.dismiss();
                }
            });
            this.jgw.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jgw.b(getPageContext());
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), (int) R.color.cp_cont_b);
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), (int) R.color.common_color_10122);
        }
        this.jgw.aBW();
    }

    private void i(AccountData accountData) {
        if (this.dhg == null) {
            this.dhg = new com.baidu.tbadk.coreExtra.view.c(this);
            this.dhg.a(new c.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.Gq(accountData2.getAccount());
                    }
                }
            });
        }
        this.dhg.aJW();
        this.dhg.setAccountData(accountData);
        this.dhg.aJS();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.jgg = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.jgg) {
            cty();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cty() {
        if (this.fdJ.getVisibility() == 0) {
            String replaceAll = this.fdJ.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.erQ.setText(replaceAll);
            } else {
                this.erQ.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.jgh.ctI().getIntro() == null || !this.jgh.ctI().getIntro().equals(replaceAll)) {
                this.jgm = true;
            }
            this.jgh.ctI().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.fdJ);
        }
    }

    private void ctz() {
        if (this.fdJ.getVisibility() != 0) {
            this.erQ.setVisibility(8);
            this.fdJ.setText(this.jgh.ctI().getIntro());
            this.fdJ.setSelection(this.fdJ.getText().length());
            this.fdJ.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.fdJ);
            zF(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zF(int i) {
        this.jfX.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.jfX.fullScroll(130);
            }
        }, i);
    }

    private void ax(Bundle bundle) {
        this.fZZ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.jgj != null) {
                    PersonChangeActivity.this.jgj.cancel();
                }
            }
        };
        PersonChangeData personChangeData = null;
        if (bundle != null) {
            String string = bundle.getString("data");
            if (!StringUtils.isNull(string)) {
                personChangeData = (PersonChangeData) OrmObject.objectWithJsonStr(string, PersonChangeData.class);
            }
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.jgh = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.fZh);
        SvgManager.aDW().a(this.cGD, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.geA.refresh();
        am.setViewTextColor(this.jgr, (int) R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.jgh.ctI() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.jgh.ctI()));
        }
    }

    private void aUX() {
        this.jgv = findViewById(R.id.photo_pop_icon);
        this.jgv.setOnClickListener(this);
        this.geA = (HeadImageView) findViewById(R.id.photo);
        this.geA.setOnClickListener(this);
        this.geA.startLoad(o.sU(this.jgh.ctI().getPortrait()), 25, false);
        this.fZh = (LinearLayout) findViewById(R.id.parent);
        this.jfX = (ScrollView) findViewById(R.id.person_change_scroll);
        this.jfZ = (RelativeLayout) findViewById(R.id.person_sex);
        this.jga = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mCloseView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.jgE);
        this.cGD = (ImageView) this.mCloseView.findViewById(R.id.widget_navi_back_button);
        this.cGD.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.jfW = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.hxI = (TextView) this.jfW.findViewById(R.id.right_textview);
        this.hxI.setText(getPageContext().getString(R.string.save));
        am.setViewTextColor(this.hxI, R.color.navi_op_text, 1);
        this.jfW.setOnClickListener(this);
        this.jfZ.setOnClickListener(this);
        this.jgb = (LinearLayout) findViewById(R.id.intro_click);
        this.jgb.setOnClickListener(this);
        this.jgb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.jgg = true;
                    return false;
                }
                return false;
            }
        });
        this.jfY = (TextView) findViewById(R.id.nick_name_show);
        this.jfY.setText(this.jgh.ctI().getNameShow());
        this.jgt = findViewById(R.id.person_nickname);
        this.jgt.setOnClickListener(this);
        this.jgu = findViewById(R.id.nick_name_more);
        ctA();
        this.jgr = (TextView) findViewById(R.id.user_name_show);
        this.jgq = findViewById(R.id.person_name);
        this.jgs = findViewById(R.id.user_name_more_icon);
        this.jgq.setOnClickListener(this);
        if (StringUtils.isNull(this.jgh.ctI().getName())) {
            this.jgr.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.jgp = false;
            this.jgq.setClickable(true);
            this.jgs.setVisibility(0);
        } else {
            this.jgr.setText(this.jgh.ctI().getName());
            this.jgp = true;
            this.jgq.setClickable(false);
            this.jgs.setVisibility(8);
        }
        this.jgc = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.jgd = (TextView) findViewById(R.id.intro_text_tip_num);
        this.jge = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.jgf = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.erQ = (TextView) findViewById(R.id.intro);
        this.erQ.setVisibility(8);
        if (this.jgh.ctI().getIntro() != null && this.jgh.ctI().getIntro().length() > 0) {
            this.erQ.setText(this.jgh.ctI().getIntro());
        } else {
            this.erQ.setText(getPageContext().getString(R.string.add_intro));
        }
        this.fdJ = (EditText) findViewById(R.id.edit);
        this.fdJ.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.fdJ.setHintTextColor(am.getColor(R.color.cp_cont_c));
        this.fdJ.setCursorVisible(false);
        if (!aq.isEmpty(this.jgh.ctI().getIntro())) {
            this.fdJ.setText(this.jgh.ctI().getIntro());
            this.jgd.setText(this.jgh.ctI().getIntro().length() + "");
        } else {
            this.jgd.setText("0");
        }
        this.jgc.setVisibility(0);
        this.fdJ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.cty();
                }
            }
        });
        this.fdJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.jgg = true;
                    PersonChangeActivity.this.fdJ.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.fdJ.setOnClickListener(this);
        this.fdJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.fdJ.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.jgd.setText(String.valueOf(length));
                PersonChangeActivity.this.jgc.setVisibility(0);
                PersonChangeActivity.this.zF(0);
                PersonChangeActivity.this.ctC();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.fdJ.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.fdJ.getSelectionStart() - 1 > PersonChangeActivity.this.fdJ.getSelectionEnd()) {
                        PersonChangeActivity.this.fdJ.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.fdJ.getSelectionStart() - 1, PersonChangeActivity.this.fdJ.getSelectionEnd());
                        PersonChangeActivity.this.fdJ.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.fdJ.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.jgh.ctI().getIntro())) {
                    PersonChangeActivity.this.gPH = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(PersonChangeActivity.this.hxI, R.color.navi_op_text, 1);
                    } else {
                        am.setViewTextColor(PersonChangeActivity.this.hxI, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.jgh.ctI().getSex() == 1) {
            this.mSex = 1;
            this.jga.setText(R.string.male);
        } else if (this.jgh.ctI().getSex() == 2) {
            this.mSex = 2;
            this.jga.setText(R.string.female);
        } else {
            this.jga.setText(R.string.change_sex);
        }
        this.jgk = (ProgressBar) findViewById(R.id.image_progress);
        this.hPv = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hPv.sz(getPageContext().getString(R.string.confirm_giveup));
        this.hPv.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.ctD();
            }
        });
        this.hPv.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.jgh.ctI().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.jfV.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.jgh.ctI());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.jgh.ctI());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.ctG();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.hPv.b(getPageContext());
        this.jgy = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.jgz = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.jgh.ctI().getAlaId() > 0) {
            this.jgy.setVisibility(0);
            this.jgz.setText(this.jgh.ctI().getAlaId() + "");
        }
        this.jgA = (TextView) findViewById(R.id.person_forum_age_show);
        this.jgA.setText(getResources().getString(R.string.person_forum_age_suffix, this.jgh.ctI().getForumAge()));
        this.jgB = (RelativeLayout) findViewById(R.id.person_constellation);
        this.jgB.setOnClickListener(this);
        this.jgC = (TextView) findViewById(R.id.constellation_txt);
        this.jgD = (TextView) findViewById(R.id.age_txt);
        if (this.jgh.ctI().getBirthdayTime() != 0) {
            this.jgC.setText(aq.l(new Date(this.jgh.ctI().getBirthdayTime() * 1000)));
        }
        if (this.jgh.ctI().getUserAge() > 0 && this.jgh.ctI().getBirthdayShowStatus() == 2) {
            this.jgD.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.jgh.ctI().getUserAge())));
            this.jgD.setVisibility(0);
        } else {
            this.jgD.setVisibility(8);
        }
        this.jfX.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.jfX.scrollTo(0, 0);
            }
        });
    }

    private void ctA() {
        if (NickNameActivitySwitch.isOn() || this.jgh.ctI().getNickNameLeftDays() == 0) {
            this.jgu.setVisibility(0);
        } else {
            this.jgu.setVisibility(8);
        }
    }

    public void ctB() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.jJ(R.string.operation);
        bVar.a(strArr, new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                if (i == 0) {
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) PersonChangeActivity.this.getPageContext().getPageActivity(), PersonChangeActivity.this.mWriteImagesInfo.toJsonString(), true);
                    albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    albumActivityConfig.setResourceType(2);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                } else if (i == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST)));
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext());
        bVar.aBX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctC() {
        int color;
        if (this.fdJ.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = am.getColor(R.color.common_color_10159);
        } else {
            color = am.getColor(R.color.common_color_10077);
        }
        zG(color);
    }

    private void zG(int i) {
        this.jgd.setTextColor(i);
        this.jge.setTextColor(i);
        this.jgf.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctD() {
        if (this.jgh != null && this.jgh.ctI() != null) {
            cty();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.jgh.ctI().setIntro(this.fdJ.getText().toString().replaceAll("\\s*", ""));
            this.jgh.ctI().setSex(this.mSex);
            if (this.jgj == null) {
                this.jgj = new b(this.jgh);
                this.jgj.setPriority(3);
                this.jgj.execute(new String[0]);
            }
        }
    }

    private void ctE() {
        if (this.jgl == null) {
            this.jgl = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.jgl.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.jgl != null && PersonChangeActivity.this.jgl.isShowing()) {
                        PersonChangeActivity.this.jgl.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.jga.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.jga.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.jgh.ctI().getSex()) {
                            PersonChangeActivity.this.gPH = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                am.setViewTextColor(PersonChangeActivity.this.hxI, R.color.navi_op_text, 1);
                            } else {
                                am.setViewTextColor(PersonChangeActivity.this.hxI, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.jgl.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cty();
            this.jgE.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1001:
                    if (intent != null) {
                        long longExtra = intent.getLongExtra("constellation_birthday", 0L);
                        int intExtra = intent.getIntExtra("constellation_show_status", 0);
                        if (longExtra != this.jgh.ctI().getBirthdayTime() || intExtra != this.jgh.ctI().getBirthdayShowStatus()) {
                            this.jgh.ctI().setBirthdayShowStatus(intExtra);
                            this.jgh.ctI().setBirthdayTime(longExtra);
                            this.jgm = true;
                            this.gPH = true;
                            Date date = new Date(longExtra * 1000);
                            this.jgC.setText(aq.l(date));
                            if (this.jgh.ctI().getBirthdayShowStatus() == 2) {
                                this.jgD.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(n(date))));
                                this.jgD.setVisibility(0);
                                return;
                            }
                            this.jgD.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            aw(intent);
                            return;
                        } else {
                            ap(intent);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.jgh.ctI().setPhotoChanged(true);
                    ctF();
                    this.gPH = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.hxI, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.hxI, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.jgh.ctI().setPhotoChanged(true);
                    if (intent != null) {
                        this.geA.setImageBitmap(null);
                        this.geA.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.gPH = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.hxI, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.hxI, R.color.cp_link_tip_a, 1);
                        return;
                    }
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    al.e(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    public static int n(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (calendar.before(date)) {
            return 0;
        }
        int i = calendar.get(1);
        int i2 = calendar.get(2) + 1;
        int i3 = calendar.get(5);
        calendar.setTime(date);
        int i4 = calendar.get(1);
        int i5 = calendar.get(2) + 1;
        int i6 = calendar.get(5);
        int i7 = i - i4;
        if (i2 <= i5) {
            if (i2 == i5) {
                if (i3 < i6) {
                    return i7 - 1;
                }
                return i7;
            }
            return i7 - 1;
        }
        return i7;
    }

    private void Gp(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jgn = true;
            this.jgh.ctI().setPhotoChanged(true);
            this.jgh.ctI().setNameShow(str);
            this.jgh.ctI().setNickNameLeftDays(90);
            this.jfY.setText(str);
            ctA();
        }
    }

    private void ap(Intent intent) {
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
            if (this.mWriteImagesInfo.getChosedFiles() != null && this.mWriteImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.mWriteImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.mWriteImagesInfo.clear();
        }
    }

    private void aw(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, RequestResponseCode.REQUEST_CAMERA_VIEW, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void ctF() {
        if (this.jgi != null) {
            this.jgi.cancel();
        }
        this.hqP = null;
        this.jgi = new a();
        this.jgi.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctG() {
        if (this.jgh != null && this.jgh.ctI() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.jgh.ctI()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.jgk.setVisibility(0);
            PersonChangeActivity.this.geA.setImageDrawable(null);
            PersonChangeActivity.this.hqP = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(Object... objArr) {
            return m.getImage(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.jgi = null;
            PersonChangeActivity.this.jgk.setVisibility(8);
            super.cancel(true);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((a) bitmap);
            PersonChangeActivity.this.jgi = null;
            PersonChangeActivity.this.jgk.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.hqP = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.hqP.drawImageTo(PersonChangeActivity.this.geA);
                com.baidu.tbadk.imageManager.c.aMZ().a(PersonChangeActivity.this.jgh.ctI().getPortrait(), PersonChangeActivity.this.hqP, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctH() {
        Intent intent = new Intent();
        if (this.jfV.booleanValue()) {
            intent.putExtra("person_change_data", this.jgh.ctI());
        } else {
            intent.putExtra("data", this.jgh.ctI());
        }
        setResult(-1, intent);
        ctG();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private x cHo = null;
        private PersonChangeModel jgh;

        public b(PersonChangeModel personChangeModel) {
            this.jgh = null;
            this.jgh = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.jgj = null;
            if (this.cHo != null) {
                this.cHo.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.jgj = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.cHo != null) {
                if (this.cHo.aDB().aEc().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.ctH();
                } else {
                    PersonChangeActivity.this.showToast(this.cHo.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.fZZ);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.jgh != null) {
                this.cHo = new x(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.cHo.addPostData("sex", String.valueOf(this.jgh.ctI().getSex()));
                this.cHo.addPostData("intro", this.jgh.ctI().getIntro());
                this.cHo.addPostData("birthday_time", String.valueOf(this.jgh.ctI().getBirthdayTime()));
                this.cHo.addPostData("birthday_show_status", String.valueOf(this.jgh.ctI().getBirthdayShowStatus()));
                this.cHo.postMultiNetData();
                if (this.cHo.aDB().aEc().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.cJl();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gjL && !TextUtils.isEmpty(this.jgx)) {
            Gp(this.jgx);
            this.gjL = false;
            this.jgx = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gq(String str) {
        if (!StringUtils.isNull(str)) {
            this.jgp = true;
            this.jgr.setText(str);
            this.jgq.setClickable(false);
            this.jgs.setVisibility(8);
        }
    }
}
