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
    private ImageView dSF;
    private View dSG;
    private com.baidu.tbadk.coreExtra.view.b ezB;
    private View liA;
    private View liU;
    private TextView liV;
    private View liW;
    private View liX;
    private View liY;
    private View liZ;
    private com.baidu.tbadk.core.dialog.a lja;
    private String ljb;
    private LinearLayout ljc;
    private TextView ljd;
    private TextView lje;
    private RelativeLayout ljf;
    private TextView ljg;
    private TextView ljh;
    private PermissionJudgePolicy mPermissionJudgement;
    public final int liy = 90;
    private Boolean liz = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView jsJ = null;
    private LinearLayout hIS = null;
    private ScrollView liB = null;
    private TextView liC = null;
    private RelativeLayout liD = null;
    private TextView liE = null;
    private LinearLayout liF = null;
    private TextView fRM = null;
    private EditText gIt = null;
    private LinearLayout liG = null;
    private TextView liH = null;
    private TextView liI = null;
    private TextView liJ = null;
    private InputMethodManager mInputManager = null;
    private boolean liK = false;
    private PersonChangeModel liL = null;
    protected HeadImageView hOh = null;
    private com.baidu.adp.widget.ImageView.a jkJ = null;
    private a liM = null;
    private b liN = null;
    private ProgressBar liO = null;
    private DialogInterface.OnCancelListener hJK = null;
    private com.baidu.tbadk.core.dialog.a jLN = null;
    private com.baidu.tbadk.core.dialog.i liP = null;
    private boolean liQ = false;
    private boolean iEC = false;
    private boolean liR = false;
    private int mSex = 0;
    private final int liS = 500;
    private boolean liT = false;
    private boolean hTJ = false;
    private final View.OnClickListener lji = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.liL.dhK().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.liQ = true;
            }
            if (PersonChangeActivity.this.liQ) {
                PersonChangeActivity.this.jLN.bhg();
                return;
            }
            if (PersonChangeActivity.this.liL != null && PersonChangeActivity.this.liL.dhK().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.liz.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.liL.dhK());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.liL.dhK());
                }
                PersonChangeActivity.this.dhI();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener hUI = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.hTJ = true;
                        PersonChangeActivity.this.ljb = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener ljj = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.liL != null && PersonChangeActivity.this.liL.dhK() != null && personChangeData != null) {
                    PersonChangeActivity.this.liL.dhK().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.liL.dhK().setMem(personChangeData.getMen());
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
        bAD();
        if (bundle != null) {
            this.liz = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.liz = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.hUI);
        registerListener(this.ljj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hUI);
        if (this.liM != null) {
            this.liM.cancel();
        }
        if (this.liN != null) {
            this.liN.cancel();
        }
        if (this.liO != null) {
            this.liO.setVisibility(8);
        }
        if (this.gIt != null) {
            this.gIt.addTextChangedListener(null);
        }
        if (this.ezB != null) {
            this.ezB.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hOh || view == this.liZ) {
            if (this.liL != null && this.liL.ljn != null && !this.liL.ljn.canModifyAvatar()) {
                if (!StringUtils.isNull(this.liL.ljn.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.liL.ljn.getCantModifyAvatarDesc());
                    return;
                } else {
                    l.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.person_cant_edit_avatar_default_tip);
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
                dhD();
            }
        } else if (view == this.liA) {
            if (!this.iEC && !this.liR) {
                finish();
            }
            if (this.liz.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.iEC) {
                dhF();
            } else if (this.liR) {
                dhJ();
            }
        } else if (view == this.liD) {
            dhG();
        } else if (view == this.liF) {
            dhB();
        } else if (view == this.gIt) {
            Fk(800);
        } else if (view == this.liX) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                dhz();
            } else {
                int nickNameLeftDays = this.liL.dhK().getNickNameLeftDays();
                if (this.liL.dhK().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.zA(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
        } else if (view == this.liU) {
            if (this.liL == null || this.liL.dhK() == null || StringUtils.isNull(this.liL.dhK().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.ljf) {
            PersonConstellationActivity.a(getActivity(), this.liL.dhK().getBirthdayTime(), this.liL.dhK().getBirthdayShowStatus());
        }
    }

    private void dhz() {
        if (this.lja == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.lja = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.lja.aX(inflate);
            this.lja.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.cUW(), true)));
                    aVar.dismiss();
                }
            });
            this.lja.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.lja.b(getPageContext());
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), (int) R.color.cp_cont_b);
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), (int) R.color.common_color_10122);
        }
        this.lja.bhg();
    }

    private void i(AccountData accountData) {
        if (this.ezB == null) {
            this.ezB = new com.baidu.tbadk.coreExtra.view.b(this);
            this.ezB.a(new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.Ov(accountData2.getAccount());
                    }
                }
            });
        }
        this.ezB.bpV();
        this.ezB.setAccountData(accountData);
        this.ezB.bpR();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.liK = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.liK) {
            dhA();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhA() {
        if (this.gIt.getVisibility() == 0) {
            String replaceAll = this.gIt.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.fRM.setText(replaceAll);
            } else {
                this.fRM.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.liL.dhK().getIntro() == null || !this.liL.dhK().getIntro().equals(replaceAll)) {
                this.liQ = true;
            }
            this.liL.dhK().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.gIt);
        }
    }

    private void dhB() {
        if (this.gIt.getVisibility() != 0) {
            this.fRM.setVisibility(8);
            this.gIt.setText(this.liL.dhK().getIntro());
            this.gIt.setSelection(this.gIt.getText().length());
            this.gIt.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.gIt);
            Fk(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fk(int i) {
        this.liB.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.liB.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aF(Bundle bundle) {
        this.hJK = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.liN != null) {
                    PersonChangeActivity.this.liN.cancel();
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
        this.liL = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.hIS);
        SvgManager.bjq().a(this.dSF, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.hOh.refresh();
        ap.setViewTextColor(this.liV, (int) R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.liL.dhK() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.liL.dhK()));
        }
    }

    private void bAD() {
        this.liZ = findViewById(R.id.photo_pop_icon);
        this.liZ.setOnClickListener(this);
        this.hOh = (HeadImageView) findViewById(R.id.photo);
        this.hOh.setOnClickListener(this);
        this.hOh.startLoad(q.zW(this.liL.dhK().getPortrait()), 25, false);
        this.hIS = (LinearLayout) findViewById(R.id.parent);
        this.liB = (ScrollView) findViewById(R.id.person_change_scroll);
        this.liD = (RelativeLayout) findViewById(R.id.person_sex);
        this.liE = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.dSG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.lji);
        this.dSF = (ImageView) this.dSG.findViewById(R.id.widget_navi_back_button);
        this.dSF.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.liA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.jsJ = (TextView) this.liA.findViewById(R.id.right_textview);
        this.jsJ.setText(getPageContext().getString(R.string.save));
        ap.setViewTextColor(this.jsJ, R.color.navi_op_text, 1);
        this.liA.setOnClickListener(this);
        this.liD.setOnClickListener(this);
        this.liF = (LinearLayout) findViewById(R.id.intro_click);
        this.liF.setOnClickListener(this);
        this.liF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.liK = true;
                    return false;
                }
                return false;
            }
        });
        this.liC = (TextView) findViewById(R.id.nick_name_show);
        this.liC.setText(this.liL.dhK().getNameShow());
        this.liX = findViewById(R.id.person_nickname);
        this.liX.setOnClickListener(this);
        this.liY = findViewById(R.id.nick_name_more);
        dhC();
        this.liV = (TextView) findViewById(R.id.user_name_show);
        this.liU = findViewById(R.id.person_name);
        this.liW = findViewById(R.id.user_name_more_icon);
        this.liU.setOnClickListener(this);
        if (StringUtils.isNull(this.liL.dhK().getName())) {
            this.liV.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.liT = false;
            this.liU.setClickable(true);
            this.liW.setVisibility(0);
        } else {
            this.liV.setText(this.liL.dhK().getName());
            this.liT = true;
            this.liU.setClickable(false);
            this.liW.setVisibility(8);
        }
        this.liG = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.liH = (TextView) findViewById(R.id.intro_text_tip_num);
        this.liI = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.liJ = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.fRM = (TextView) findViewById(R.id.intro);
        this.fRM.setVisibility(8);
        if (this.liL.dhK().getIntro() != null && this.liL.dhK().getIntro().length() > 0) {
            this.fRM.setText(this.liL.dhK().getIntro());
        } else {
            this.fRM.setText(getPageContext().getString(R.string.add_intro));
        }
        this.gIt = (EditText) findViewById(R.id.edit);
        this.gIt.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.gIt.setHintTextColor(ap.getColor(R.color.cp_cont_c));
        this.gIt.setCursorVisible(false);
        if (!at.isEmpty(this.liL.dhK().getIntro())) {
            this.gIt.setText(this.liL.dhK().getIntro());
            this.liH.setText(this.liL.dhK().getIntro().length() + "");
        } else {
            this.liH.setText("0");
        }
        this.liG.setVisibility(0);
        this.gIt.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.dhA();
                }
            }
        });
        this.gIt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.liK = true;
                    PersonChangeActivity.this.gIt.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.gIt.setOnClickListener(this);
        this.gIt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.gIt.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.liH.setText(String.valueOf(length));
                PersonChangeActivity.this.liG.setVisibility(0);
                PersonChangeActivity.this.Fk(0);
                PersonChangeActivity.this.dhE();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.gIt.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.gIt.getSelectionStart() - 1 > PersonChangeActivity.this.gIt.getSelectionEnd()) {
                        PersonChangeActivity.this.gIt.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.gIt.getSelectionStart() - 1, PersonChangeActivity.this.gIt.getSelectionEnd());
                        PersonChangeActivity.this.gIt.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.gIt.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.liL.dhK().getIntro())) {
                    PersonChangeActivity.this.iEC = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(PersonChangeActivity.this.jsJ, R.color.navi_op_text, 1);
                    } else {
                        ap.setViewTextColor(PersonChangeActivity.this.jsJ, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.liL.dhK().getSex() == 1) {
            this.mSex = 1;
            this.liE.setText(R.string.male);
        } else if (this.liL.dhK().getSex() == 2) {
            this.mSex = 2;
            this.liE.setText(R.string.female);
        } else {
            this.liE.setText(R.string.change_sex);
        }
        this.liO = (ProgressBar) findViewById(R.id.image_progress);
        this.jLN = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.jLN.zA(getPageContext().getString(R.string.confirm_giveup));
        this.jLN.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.dhF();
            }
        });
        this.jLN.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.liL.dhK().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.liz.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.liL.dhK());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.liL.dhK());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.dhI();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.jLN.b(getPageContext());
        this.ljc = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.ljd = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.liL.dhK().getAlaId() > 0) {
            this.ljc.setVisibility(0);
            this.ljd.setText(this.liL.dhK().getAlaId() + "");
        }
        this.lje = (TextView) findViewById(R.id.person_forum_age_show);
        this.lje.setText(getResources().getString(R.string.person_forum_age_suffix, this.liL.dhK().getForumAge()));
        this.ljf = (RelativeLayout) findViewById(R.id.person_constellation);
        this.ljf.setOnClickListener(this);
        this.ljg = (TextView) findViewById(R.id.constellation_txt);
        this.ljh = (TextView) findViewById(R.id.age_txt);
        if (this.liL.dhK().getBirthdayTime() != 0) {
            this.ljg.setText(at.p(new Date(this.liL.dhK().getBirthdayTime() * 1000)));
        }
        if (this.liL.dhK().getUserAge() > 0 && this.liL.dhK().getBirthdayShowStatus() == 2) {
            this.ljh.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.liL.dhK().getUserAge())));
            this.ljh.setVisibility(0);
        } else {
            this.ljh.setVisibility(8);
        }
        this.liB.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.liB.scrollTo(0, 0);
            }
        });
    }

    private void dhC() {
        if (NickNameActivitySwitch.isOn() || this.liL.dhK().getNickNameLeftDays() == 0) {
            this.liY.setVisibility(0);
        } else {
            this.liY.setVisibility(8);
        }
    }

    public void dhD() {
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
    public void dhE() {
        int color;
        if (this.gIt.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = ap.getColor(R.color.common_color_10159);
        } else {
            color = ap.getColor(R.color.common_color_10077);
        }
        Fl(color);
    }

    private void Fl(int i) {
        this.liH.setTextColor(i);
        this.liI.setTextColor(i);
        this.liJ.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhF() {
        if (this.liL != null && this.liL.dhK() != null) {
            dhA();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.liL.dhK().setIntro(this.gIt.getText().toString().replaceAll("\\s*", ""));
            this.liL.dhK().setSex(this.mSex);
            if (this.liN == null) {
                this.liN = new b(this.liL);
                this.liN.setPriority(3);
                this.liN.execute(new String[0]);
            }
        }
    }

    private void dhG() {
        if (this.liP == null) {
            this.liP = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.liP.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.liP != null && PersonChangeActivity.this.liP.isShowing()) {
                        PersonChangeActivity.this.liP.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.liE.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.liE.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.liL.dhK().getSex()) {
                            PersonChangeActivity.this.iEC = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                ap.setViewTextColor(PersonChangeActivity.this.jsJ, R.color.navi_op_text, 1);
                            } else {
                                ap.setViewTextColor(PersonChangeActivity.this.jsJ, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.liP.Nv();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            dhA();
            this.lji.onClick(null);
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
                        if (longExtra != this.liL.dhK().getBirthdayTime() || intExtra != this.liL.dhK().getBirthdayShowStatus()) {
                            this.liL.dhK().setBirthdayShowStatus(intExtra);
                            this.liL.dhK().setBirthdayTime(longExtra);
                            this.liQ = true;
                            this.iEC = true;
                            Date date = new Date(longExtra * 1000);
                            this.ljg.setText(at.p(date));
                            if (this.liL.dhK().getBirthdayShowStatus() == 2) {
                                this.ljh.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(r(date))));
                                this.ljh.setVisibility(0);
                                return;
                            }
                            this.ljh.setVisibility(8);
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
                    this.liL.dhK().setPhotoChanged(true);
                    dhH();
                    this.iEC = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.jsJ, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.jsJ, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.liL.dhK().setPhotoChanged(true);
                    if (intent != null) {
                        this.hOh.setImageBitmap(null);
                        this.hOh.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.iEC = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.jsJ, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.jsJ, R.color.cp_link_tip_a, 1);
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

    private void Ou(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.liR = true;
            this.liL.dhK().setPhotoChanged(true);
            this.liL.dhK().setNameShow(str);
            this.liL.dhK().setNickNameLeftDays(90);
            this.liC.setText(str);
            dhC();
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

    private void dhH() {
        if (this.liM != null) {
            this.liM.cancel();
        }
        this.jkJ = null;
        this.liM = new a();
        this.liM.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhI() {
        if (this.liL != null && this.liL.dhK() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.liL.dhK()));
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
            PersonChangeActivity.this.liO.setVisibility(0);
            PersonChangeActivity.this.hOh.setImageDrawable(null);
            PersonChangeActivity.this.jkJ = null;
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
            PersonChangeActivity.this.liM = null;
            PersonChangeActivity.this.liO.setVisibility(8);
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
            PersonChangeActivity.this.liM = null;
            PersonChangeActivity.this.liO.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.jkJ = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.jkJ.drawImageTo(PersonChangeActivity.this.hOh);
                com.baidu.tbadk.imageManager.c.bsX().a(PersonChangeActivity.this.liL.dhK().getPortrait(), PersonChangeActivity.this.jkJ, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhJ() {
        Intent intent = new Intent();
        if (this.liz.booleanValue()) {
            intent.putExtra("person_change_data", this.liL.dhK());
        } else {
            intent.putExtra("data", this.liL.dhK());
        }
        setResult(-1, intent);
        dhI();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private aa bEb = null;
        private PersonChangeModel liL;

        public b(PersonChangeModel personChangeModel) {
            this.liL = null;
            this.liL = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.liN = null;
            if (this.bEb != null) {
                this.bEb.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.liN = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.bEb != null) {
                if (this.bEb.biQ().bjw().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.dhJ();
                } else {
                    PersonChangeActivity.this.showToast(this.bEb.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.hJK);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.liL != null) {
                this.bEb = new aa(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.bEb.addPostData("sex", String.valueOf(this.liL.dhK().getSex()));
                this.bEb.addPostData("intro", this.liL.dhK().getIntro());
                this.bEb.addPostData("birthday_time", String.valueOf(this.liL.dhK().getBirthdayTime()));
                this.bEb.addPostData("birthday_show_status", String.valueOf(this.liL.dhK().getBirthdayShowStatus()));
                this.bEb.postMultiNetData();
                if (this.bEb.biQ().bjw().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.dxy();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hTJ && !TextUtils.isEmpty(this.ljb)) {
            Ou(this.ljb);
            this.hTJ = false;
            this.ljb = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ov(String str) {
        if (!StringUtils.isNull(str)) {
            this.liT = true;
            this.liV.setText(str);
            this.liU.setClickable(false);
            this.liW.setVisibility(8);
        }
    }
}
