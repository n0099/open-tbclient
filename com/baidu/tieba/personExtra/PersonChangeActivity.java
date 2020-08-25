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
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.view.b;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import java.util.Calendar;
import java.util.Date;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes18.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private ImageView dSB;
    private View dSC;
    private com.baidu.tbadk.coreExtra.view.b ezx;
    private View liN;
    private TextView liO;
    private View liP;
    private View liQ;
    private View liR;
    private View liS;
    private com.baidu.tbadk.core.dialog.a liT;
    private String liU;
    private LinearLayout liV;
    private TextView liW;
    private TextView liX;
    private RelativeLayout liY;
    private TextView liZ;
    private View lit;
    private TextView lja;
    private PermissionJudgePolicy mPermissionJudgement;
    public final int lir = 90;
    private Boolean lis = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView jsD = null;
    private LinearLayout hIM = null;
    private ScrollView liu = null;
    private TextView liv = null;
    private RelativeLayout liw = null;
    private TextView lix = null;
    private LinearLayout liy = null;
    private TextView fRI = null;
    private EditText gIp = null;
    private LinearLayout liz = null;
    private TextView liA = null;
    private TextView liB = null;
    private TextView liC = null;
    private InputMethodManager mInputManager = null;
    private boolean liD = false;
    private PersonChangeModel liE = null;
    protected HeadImageView hOb = null;
    private com.baidu.adp.widget.ImageView.a jkD = null;
    private a liF = null;
    private b liG = null;
    private ProgressBar liH = null;
    private DialogInterface.OnCancelListener hJE = null;
    private com.baidu.tbadk.core.dialog.a jLH = null;
    private com.baidu.tbadk.core.dialog.i liI = null;
    private boolean liJ = false;
    private boolean iEw = false;
    private boolean liK = false;
    private int mSex = 0;
    private final int liL = 500;
    private boolean liM = false;
    private boolean hTD = false;
    private final View.OnClickListener ljb = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.liE.dhJ().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.liJ = true;
            }
            if (PersonChangeActivity.this.liJ) {
                PersonChangeActivity.this.jLH.bhg();
                return;
            }
            if (PersonChangeActivity.this.liE != null && PersonChangeActivity.this.liE.dhJ().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.lis.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.liE.dhJ());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.liE.dhJ());
                }
                PersonChangeActivity.this.dhH();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener hUC = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.hTD = true;
                        PersonChangeActivity.this.liU = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener ljc = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.liE != null && PersonChangeActivity.this.liE.dhJ() != null && personChangeData != null) {
                    PersonChangeActivity.this.liE.dhJ().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.liE.dhJ().setMem(personChangeData.getMen());
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
        aF(bundle);
        bAC();
        if (bundle != null) {
            this.lis = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.lis = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.hUC);
        registerListener(this.ljc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hUC);
        if (this.liF != null) {
            this.liF.cancel();
        }
        if (this.liG != null) {
            this.liG.cancel();
        }
        if (this.liH != null) {
            this.liH.setVisibility(8);
        }
        if (this.gIp != null) {
            this.gIp.addTextChangedListener(null);
        }
        if (this.ezx != null) {
            this.ezx.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hOb || view == this.liS) {
            if (this.liE != null && this.liE.ljg != null && !this.liE.ljg.canModifyAvatar()) {
                if (!StringUtils.isNull(this.liE.ljg.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.liE.ljg.getCantModifyAvatarDesc());
                    return;
                } else {
                    l.showLongToast(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
                    return;
                }
            }
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                dhC();
            }
        } else if (view == this.lit) {
            if (!this.iEw && !this.liK) {
                finish();
            }
            if (this.lis.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.iEw) {
                dhE();
            } else if (this.liK) {
                dhI();
            }
        } else if (view == this.liw) {
            dhF();
        } else if (view == this.liy) {
            dhA();
        } else if (view == this.gIp) {
            Fk(800);
        } else if (view == this.liQ) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                dhy();
            } else {
                int nickNameLeftDays = this.liE.dhJ().getNickNameLeftDays();
                if (this.liE.dhJ().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.zz(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).bhg();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.liN) {
            if (this.liE == null || this.liE.dhJ() == null || StringUtils.isNull(this.liE.dhJ().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.liY) {
            PersonConstellationActivity.a(getActivity(), this.liE.dhJ().getBirthdayTime(), this.liE.dhJ().getBirthdayShowStatus());
        }
    }

    private void dhy() {
        if (this.liT == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.liT = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.liT.aX(inflate);
            this.liT.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.cUV(), true)));
                    aVar.dismiss();
                }
            });
            this.liT.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.liT.b(getPageContext());
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), R.color.cp_cont_b);
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.liT.bhg();
    }

    private void i(AccountData accountData) {
        if (this.ezx == null) {
            this.ezx = new com.baidu.tbadk.coreExtra.view.b(this);
            this.ezx.a(new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.Ou(accountData2.getAccount());
                    }
                }
            });
        }
        this.ezx.bpU();
        this.ezx.setAccountData(accountData);
        this.ezx.bpQ();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.liD = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.liD) {
            dhz();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhz() {
        if (this.gIp.getVisibility() == 0) {
            String replaceAll = this.gIp.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.fRI.setText(replaceAll);
            } else {
                this.fRI.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.liE.dhJ().getIntro() == null || !this.liE.dhJ().getIntro().equals(replaceAll)) {
                this.liJ = true;
            }
            this.liE.dhJ().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.gIp);
        }
    }

    private void dhA() {
        if (this.gIp.getVisibility() != 0) {
            this.fRI.setVisibility(8);
            this.gIp.setText(this.liE.dhJ().getIntro());
            this.gIp.setSelection(this.gIp.getText().length());
            this.gIp.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.gIp);
            Fk(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fk(int i) {
        this.liu.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.liu.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aF(Bundle bundle) {
        this.hJE = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.liG != null) {
                    PersonChangeActivity.this.liG.cancel();
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
        this.liE = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.hIM);
        SvgManager.bjq().a(this.dSB, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.hOb.refresh();
        ap.setViewTextColor(this.liO, R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.liE.dhJ() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.liE.dhJ()));
        }
    }

    private void bAC() {
        this.liS = findViewById(R.id.photo_pop_icon);
        this.liS.setOnClickListener(this);
        this.hOb = (HeadImageView) findViewById(R.id.photo);
        this.hOb.setOnClickListener(this);
        this.hOb.startLoad(q.zV(this.liE.dhJ().getPortrait()), 25, false);
        this.hIM = (LinearLayout) findViewById(R.id.parent);
        this.liu = (ScrollView) findViewById(R.id.person_change_scroll);
        this.liw = (RelativeLayout) findViewById(R.id.person_sex);
        this.lix = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.dSC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.ljb);
        this.dSB = (ImageView) this.dSC.findViewById(R.id.widget_navi_back_button);
        this.dSB.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.lit = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.jsD = (TextView) this.lit.findViewById(R.id.right_textview);
        this.jsD.setText(getPageContext().getString(R.string.save));
        ap.setViewTextColor(this.jsD, R.color.navi_op_text, 1);
        this.lit.setOnClickListener(this);
        this.liw.setOnClickListener(this);
        this.liy = (LinearLayout) findViewById(R.id.intro_click);
        this.liy.setOnClickListener(this);
        this.liy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.liD = true;
                    return false;
                }
                return false;
            }
        });
        this.liv = (TextView) findViewById(R.id.nick_name_show);
        this.liv.setText(this.liE.dhJ().getNameShow());
        this.liQ = findViewById(R.id.person_nickname);
        this.liQ.setOnClickListener(this);
        this.liR = findViewById(R.id.nick_name_more);
        dhB();
        this.liO = (TextView) findViewById(R.id.user_name_show);
        this.liN = findViewById(R.id.person_name);
        this.liP = findViewById(R.id.user_name_more_icon);
        this.liN.setOnClickListener(this);
        if (StringUtils.isNull(this.liE.dhJ().getName())) {
            this.liO.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.liM = false;
            this.liN.setClickable(true);
            this.liP.setVisibility(0);
        } else {
            this.liO.setText(this.liE.dhJ().getName());
            this.liM = true;
            this.liN.setClickable(false);
            this.liP.setVisibility(8);
        }
        this.liz = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.liA = (TextView) findViewById(R.id.intro_text_tip_num);
        this.liB = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.liC = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.fRI = (TextView) findViewById(R.id.intro);
        this.fRI.setVisibility(8);
        if (this.liE.dhJ().getIntro() != null && this.liE.dhJ().getIntro().length() > 0) {
            this.fRI.setText(this.liE.dhJ().getIntro());
        } else {
            this.fRI.setText(getPageContext().getString(R.string.add_intro));
        }
        this.gIp = (EditText) findViewById(R.id.edit);
        this.gIp.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.gIp.setHintTextColor(ap.getColor(R.color.cp_cont_c));
        this.gIp.setCursorVisible(false);
        if (!at.isEmpty(this.liE.dhJ().getIntro())) {
            this.gIp.setText(this.liE.dhJ().getIntro());
            this.liA.setText(this.liE.dhJ().getIntro().length() + "");
        } else {
            this.liA.setText("0");
        }
        this.liz.setVisibility(0);
        this.gIp.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.dhz();
                }
            }
        });
        this.gIp.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.liD = true;
                    PersonChangeActivity.this.gIp.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.gIp.setOnClickListener(this);
        this.gIp.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.gIp.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.liA.setText(String.valueOf(length));
                PersonChangeActivity.this.liz.setVisibility(0);
                PersonChangeActivity.this.Fk(0);
                PersonChangeActivity.this.dhD();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.gIp.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.gIp.getSelectionStart() - 1 > PersonChangeActivity.this.gIp.getSelectionEnd()) {
                        PersonChangeActivity.this.gIp.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.gIp.getSelectionStart() - 1, PersonChangeActivity.this.gIp.getSelectionEnd());
                        PersonChangeActivity.this.gIp.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.gIp.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.liE.dhJ().getIntro())) {
                    PersonChangeActivity.this.iEw = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(PersonChangeActivity.this.jsD, R.color.navi_op_text, 1);
                    } else {
                        ap.setViewTextColor(PersonChangeActivity.this.jsD, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.liE.dhJ().getSex() == 1) {
            this.mSex = 1;
            this.lix.setText(R.string.male);
        } else if (this.liE.dhJ().getSex() == 2) {
            this.mSex = 2;
            this.lix.setText(R.string.female);
        } else {
            this.lix.setText(R.string.change_sex);
        }
        this.liH = (ProgressBar) findViewById(R.id.image_progress);
        this.jLH = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.jLH.zz(getPageContext().getString(R.string.confirm_giveup));
        this.jLH.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.dhE();
            }
        });
        this.jLH.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.liE.dhJ().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.lis.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.liE.dhJ());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.liE.dhJ());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.dhH();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.jLH.b(getPageContext());
        this.liV = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.liW = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.liE.dhJ().getAlaId() > 0) {
            this.liV.setVisibility(0);
            this.liW.setText(this.liE.dhJ().getAlaId() + "");
        }
        this.liX = (TextView) findViewById(R.id.person_forum_age_show);
        this.liX.setText(getResources().getString(R.string.person_forum_age_suffix, this.liE.dhJ().getForumAge()));
        this.liY = (RelativeLayout) findViewById(R.id.person_constellation);
        this.liY.setOnClickListener(this);
        this.liZ = (TextView) findViewById(R.id.constellation_txt);
        this.lja = (TextView) findViewById(R.id.age_txt);
        if (this.liE.dhJ().getBirthdayTime() != 0) {
            this.liZ.setText(at.p(new Date(this.liE.dhJ().getBirthdayTime() * 1000)));
        }
        if (this.liE.dhJ().getUserAge() > 0 && this.liE.dhJ().getBirthdayShowStatus() == 2) {
            this.lja.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.liE.dhJ().getUserAge())));
            this.lja.setVisibility(0);
        } else {
            this.lja.setVisibility(8);
        }
        this.liu.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.liu.scrollTo(0, 0);
            }
        });
    }

    private void dhB() {
        if (NickNameActivitySwitch.isOn() || this.liE.dhJ().getNickNameLeftDays() == 0) {
            this.liR.setVisibility(0);
        } else {
            this.liR.setVisibility(8);
        }
    }

    public void dhC() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.nx(R.string.operation);
        bVar.a(strArr, new b.InterfaceC0538b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
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
        bVar.bhi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhD() {
        int color;
        if (this.gIp.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = ap.getColor(R.color.common_color_10159);
        } else {
            color = ap.getColor(R.color.common_color_10077);
        }
        Fl(color);
    }

    private void Fl(int i) {
        this.liA.setTextColor(i);
        this.liB.setTextColor(i);
        this.liC.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhE() {
        if (this.liE != null && this.liE.dhJ() != null) {
            dhz();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.liE.dhJ().setIntro(this.gIp.getText().toString().replaceAll("\\s*", ""));
            this.liE.dhJ().setSex(this.mSex);
            if (this.liG == null) {
                this.liG = new b(this.liE);
                this.liG.setPriority(3);
                this.liG.execute(new String[0]);
            }
        }
    }

    private void dhF() {
        if (this.liI == null) {
            this.liI = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.liI.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.liI != null && PersonChangeActivity.this.liI.isShowing()) {
                        PersonChangeActivity.this.liI.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.lix.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.lix.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.liE.dhJ().getSex()) {
                            PersonChangeActivity.this.iEw = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                ap.setViewTextColor(PersonChangeActivity.this.jsD, R.color.navi_op_text, 1);
                            } else {
                                ap.setViewTextColor(PersonChangeActivity.this.jsD, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.liI.Nv();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            dhz();
            this.ljb.onClick(null);
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
                        if (longExtra != this.liE.dhJ().getBirthdayTime() || intExtra != this.liE.dhJ().getBirthdayShowStatus()) {
                            this.liE.dhJ().setBirthdayShowStatus(intExtra);
                            this.liE.dhJ().setBirthdayTime(longExtra);
                            this.liJ = true;
                            this.iEw = true;
                            Date date = new Date(longExtra * 1000);
                            this.liZ.setText(at.p(date));
                            if (this.liE.dhJ().getBirthdayShowStatus() == 2) {
                                this.lja.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(r(date))));
                                this.lja.setVisibility(0);
                                return;
                            }
                            this.lja.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            aj(intent);
                            return;
                        } else {
                            ab(intent);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.liE.dhJ().setPhotoChanged(true);
                    dhG();
                    this.iEw = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.jsD, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.jsD, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.liE.dhJ().setPhotoChanged(true);
                    if (intent != null) {
                        this.hOb.setImageBitmap(null);
                        this.hOb.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.iEw = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.jsD, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.jsD, R.color.cp_link_tip_a, 1);
                        return;
                    }
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    ao.g(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    public static int r(Date date) {
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

    private void Ot(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.liK = true;
            this.liE.dhJ().setPhotoChanged(true);
            this.liE.dhJ().setNameShow(str);
            this.liE.dhJ().setNickNameLeftDays(90);
            this.liv.setText(str);
            dhB();
        }
    }

    private void ab(Intent intent) {
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

    private void aj(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_CAMERA, RequestResponseCode.REQUEST_CAMERA_VIEW, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void dhG() {
        if (this.liF != null) {
            this.liF.cancel();
        }
        this.jkD = null;
        this.liF = new a();
        this.liF.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhH() {
        if (this.liE != null && this.liE.dhJ() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.liE.dhJ()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.liH.setVisibility(0);
            PersonChangeActivity.this.hOb.setImageDrawable(null);
            PersonChangeActivity.this.jkD = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public Bitmap doInBackground(Object... objArr) {
            return n.getImage(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.liF = null;
            PersonChangeActivity.this.liH.setVisibility(8);
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
            PersonChangeActivity.this.liF = null;
            PersonChangeActivity.this.liH.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.jkD = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.jkD.drawImageTo(PersonChangeActivity.this.hOb);
                com.baidu.tbadk.imageManager.c.bsW().a(PersonChangeActivity.this.liE.dhJ().getPortrait(), PersonChangeActivity.this.jkD, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhI() {
        Intent intent = new Intent();
        if (this.lis.booleanValue()) {
            intent.putExtra("person_change_data", this.liE.dhJ());
        } else {
            intent.putExtra("data", this.liE.dhJ());
        }
        setResult(-1, intent);
        dhH();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private aa bDY = null;
        private PersonChangeModel liE;

        public b(PersonChangeModel personChangeModel) {
            this.liE = null;
            this.liE = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.liG = null;
            if (this.bDY != null) {
                this.bDY.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.liG = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.bDY != null) {
                if (this.bDY.biQ().bjw().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.dhI();
                } else {
                    PersonChangeActivity.this.showToast(this.bDY.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.hJE);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.liE != null) {
                this.bDY = new aa(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.bDY.addPostData("sex", String.valueOf(this.liE.dhJ().getSex()));
                this.bDY.addPostData("intro", this.liE.dhJ().getIntro());
                this.bDY.addPostData("birthday_time", String.valueOf(this.liE.dhJ().getBirthdayTime()));
                this.bDY.addPostData("birthday_show_status", String.valueOf(this.liE.dhJ().getBirthdayShowStatus()));
                this.bDY.postMultiNetData();
                if (this.bDY.biQ().bjw().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.dxt();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hTD && !TextUtils.isEmpty(this.liU)) {
            Ot(this.liU);
            this.hTD = false;
            this.liU = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ou(String str) {
        if (!StringUtils.isNull(str)) {
            this.liM = true;
            this.liO.setText(str);
            this.liN.setClickable(false);
            this.liP.setVisibility(8);
        }
    }
}
