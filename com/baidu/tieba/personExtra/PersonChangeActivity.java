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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes11.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private ImageView dyq;
    private View dyr;
    private com.baidu.tbadk.coreExtra.view.b eap;
    private View kpC;
    private View kpW;
    private TextView kpX;
    private View kpY;
    private View kpZ;
    private View kqa;
    private View kqb;
    private com.baidu.tbadk.core.dialog.a kqc;
    private String kqd;
    private LinearLayout kqe;
    private TextView kqf;
    private TextView kqg;
    private RelativeLayout kqh;
    private TextView kqi;
    private TextView kqj;
    private PermissionJudgePolicy mPermissionJudgement;
    public final int kpA = 90;
    private Boolean kpB = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView iEn = null;
    private LinearLayout hdA = null;
    private ScrollView kpD = null;
    private TextView kpE = null;
    private RelativeLayout kpF = null;
    private TextView kpG = null;
    private LinearLayout kpH = null;
    private TextView fpW = null;
    private EditText gea = null;
    private LinearLayout kpI = null;
    private TextView kpJ = null;
    private TextView kpK = null;
    private TextView kpL = null;
    private InputMethodManager mInputManager = null;
    private boolean kpM = false;
    private PersonChangeModel kpN = null;
    protected HeadImageView hiR = null;
    private com.baidu.adp.widget.ImageView.a ixu = null;
    private a kpO = null;
    private b kpP = null;
    private ProgressBar kpQ = null;
    private DialogInterface.OnCancelListener hes = null;
    private com.baidu.tbadk.core.dialog.a iWt = null;
    private com.baidu.tbadk.core.dialog.i kpR = null;
    private boolean kpS = false;
    private boolean hVS = false;
    private boolean kpT = false;
    private int mSex = 0;
    private final int kpU = 500;
    private boolean kpV = false;
    private boolean hoe = false;
    private final View.OnClickListener kqk = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.kpN.cOE().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.kpS = true;
            }
            if (PersonChangeActivity.this.kpS) {
                PersonChangeActivity.this.iWt.aST();
                return;
            }
            if (PersonChangeActivity.this.kpN != null && PersonChangeActivity.this.kpN.cOE().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.kpB.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.kpN.cOE());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.kpN.cOE());
                }
                PersonChangeActivity.this.cOC();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener hoR = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.hoe = true;
                        PersonChangeActivity.this.kqd = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener kql = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.kpN != null && PersonChangeActivity.this.kpN.cOE() != null && personChangeData != null) {
                    PersonChangeActivity.this.kpN.cOE().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.kpN.cOE().setMem(personChangeData.getMen());
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
        aD(bundle);
        bmd();
        if (bundle != null) {
            this.kpB = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.kpB = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.hoR);
        registerListener(this.kql);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hoR);
        if (this.kpO != null) {
            this.kpO.cancel();
        }
        if (this.kpP != null) {
            this.kpP.cancel();
        }
        if (this.kpQ != null) {
            this.kpQ.setVisibility(8);
        }
        if (this.gea != null) {
            this.gea.addTextChangedListener(null);
        }
        if (this.eap != null) {
            this.eap.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hiR || view == this.kqb) {
            if (this.kpN != null && this.kpN.kqp != null && !this.kpN.kqp.canModifyAvatar()) {
                if (!StringUtils.isNull(this.kpN.kqp.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.kpN.kqp.getCantModifyAvatarDesc());
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
                cOx();
            }
        } else if (view == this.kpC) {
            if (!this.hVS && !this.kpT) {
                finish();
            }
            if (this.kpB.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.hVS) {
                cOz();
            } else if (this.kpT) {
                cOD();
            }
        } else if (view == this.kpF) {
            cOA();
        } else if (view == this.kpH) {
            cOv();
        } else if (view == this.gea) {
            Bn(800);
        } else if (view == this.kpZ) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                cOt();
            } else {
                int nickNameLeftDays = this.kpN.cOE().getNickNameLeftDays();
                if (this.kpN.cOE().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.vO(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).aST();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.kpW) {
            if (this.kpN == null || this.kpN.cOE() == null || StringUtils.isNull(this.kpN.cOE().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.kqh) {
            PersonConstellationActivity.a(getActivity(), this.kpN.cOE().getBirthdayTime(), this.kpN.cOE().getBirthdayShowStatus());
        }
    }

    private void cOt() {
        if (this.kqc == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.kqc = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.kqc.aP(inflate);
            this.kqc.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.cCh(), true)));
                    aVar.dismiss();
                }
            });
            this.kqc.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.kqc.b(getPageContext());
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), (int) R.color.cp_cont_b);
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), (int) R.color.common_color_10122);
        }
        this.kqc.aST();
    }

    private void i(AccountData accountData) {
        if (this.eap == null) {
            this.eap = new com.baidu.tbadk.coreExtra.view.b(this);
            this.eap.a(new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.Km(accountData2.getAccount());
                    }
                }
            });
        }
        this.eap.bbx();
        this.eap.setAccountData(accountData);
        this.eap.bbt();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.kpM = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.kpM) {
            cOu();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOu() {
        if (this.gea.getVisibility() == 0) {
            String replaceAll = this.gea.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.fpW.setText(replaceAll);
            } else {
                this.fpW.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.kpN.cOE().getIntro() == null || !this.kpN.cOE().getIntro().equals(replaceAll)) {
                this.kpS = true;
            }
            this.kpN.cOE().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.gea);
        }
    }

    private void cOv() {
        if (this.gea.getVisibility() != 0) {
            this.fpW.setVisibility(8);
            this.gea.setText(this.kpN.cOE().getIntro());
            this.gea.setSelection(this.gea.getText().length());
            this.gea.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.gea);
            Bn(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bn(int i) {
        this.kpD.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.kpD.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aD(Bundle bundle) {
        this.hes = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.kpP != null) {
                    PersonChangeActivity.this.kpP.cancel();
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
        this.kpN = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.hdA);
        SvgManager.aUW().a(this.dyq, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.hiR.refresh();
        am.setViewTextColor(this.kpX, (int) R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.kpN.cOE() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.kpN.cOE()));
        }
    }

    private void bmd() {
        this.kqb = findViewById(R.id.photo_pop_icon);
        this.kqb.setOnClickListener(this);
        this.hiR = (HeadImageView) findViewById(R.id.photo);
        this.hiR.setOnClickListener(this);
        this.hiR.startLoad(o.wj(this.kpN.cOE().getPortrait()), 25, false);
        this.hdA = (LinearLayout) findViewById(R.id.parent);
        this.kpD = (ScrollView) findViewById(R.id.person_change_scroll);
        this.kpF = (RelativeLayout) findViewById(R.id.person_sex);
        this.kpG = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.dyr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.kqk);
        this.dyq = (ImageView) this.dyr.findViewById(R.id.widget_navi_back_button);
        this.dyq.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.kpC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.iEn = (TextView) this.kpC.findViewById(R.id.right_textview);
        this.iEn.setText(getPageContext().getString(R.string.save));
        am.setViewTextColor(this.iEn, R.color.navi_op_text, 1);
        this.kpC.setOnClickListener(this);
        this.kpF.setOnClickListener(this);
        this.kpH = (LinearLayout) findViewById(R.id.intro_click);
        this.kpH.setOnClickListener(this);
        this.kpH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.kpM = true;
                    return false;
                }
                return false;
            }
        });
        this.kpE = (TextView) findViewById(R.id.nick_name_show);
        this.kpE.setText(this.kpN.cOE().getNameShow());
        this.kpZ = findViewById(R.id.person_nickname);
        this.kpZ.setOnClickListener(this);
        this.kqa = findViewById(R.id.nick_name_more);
        cOw();
        this.kpX = (TextView) findViewById(R.id.user_name_show);
        this.kpW = findViewById(R.id.person_name);
        this.kpY = findViewById(R.id.user_name_more_icon);
        this.kpW.setOnClickListener(this);
        if (StringUtils.isNull(this.kpN.cOE().getName())) {
            this.kpX.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.kpV = false;
            this.kpW.setClickable(true);
            this.kpY.setVisibility(0);
        } else {
            this.kpX.setText(this.kpN.cOE().getName());
            this.kpV = true;
            this.kpW.setClickable(false);
            this.kpY.setVisibility(8);
        }
        this.kpI = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.kpJ = (TextView) findViewById(R.id.intro_text_tip_num);
        this.kpK = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.kpL = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.fpW = (TextView) findViewById(R.id.intro);
        this.fpW.setVisibility(8);
        if (this.kpN.cOE().getIntro() != null && this.kpN.cOE().getIntro().length() > 0) {
            this.fpW.setText(this.kpN.cOE().getIntro());
        } else {
            this.fpW.setText(getPageContext().getString(R.string.add_intro));
        }
        this.gea = (EditText) findViewById(R.id.edit);
        this.gea.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.gea.setHintTextColor(am.getColor(R.color.cp_cont_c));
        this.gea.setCursorVisible(false);
        if (!aq.isEmpty(this.kpN.cOE().getIntro())) {
            this.gea.setText(this.kpN.cOE().getIntro());
            this.kpJ.setText(this.kpN.cOE().getIntro().length() + "");
        } else {
            this.kpJ.setText("0");
        }
        this.kpI.setVisibility(0);
        this.gea.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.cOu();
                }
            }
        });
        this.gea.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.kpM = true;
                    PersonChangeActivity.this.gea.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.gea.setOnClickListener(this);
        this.gea.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.gea.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.kpJ.setText(String.valueOf(length));
                PersonChangeActivity.this.kpI.setVisibility(0);
                PersonChangeActivity.this.Bn(0);
                PersonChangeActivity.this.cOy();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.gea.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.gea.getSelectionStart() - 1 > PersonChangeActivity.this.gea.getSelectionEnd()) {
                        PersonChangeActivity.this.gea.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.gea.getSelectionStart() - 1, PersonChangeActivity.this.gea.getSelectionEnd());
                        PersonChangeActivity.this.gea.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.gea.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.kpN.cOE().getIntro())) {
                    PersonChangeActivity.this.hVS = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(PersonChangeActivity.this.iEn, R.color.navi_op_text, 1);
                    } else {
                        am.setViewTextColor(PersonChangeActivity.this.iEn, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.kpN.cOE().getSex() == 1) {
            this.mSex = 1;
            this.kpG.setText(R.string.male);
        } else if (this.kpN.cOE().getSex() == 2) {
            this.mSex = 2;
            this.kpG.setText(R.string.female);
        } else {
            this.kpG.setText(R.string.change_sex);
        }
        this.kpQ = (ProgressBar) findViewById(R.id.image_progress);
        this.iWt = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.iWt.vO(getPageContext().getString(R.string.confirm_giveup));
        this.iWt.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.cOz();
            }
        });
        this.iWt.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.kpN.cOE().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.kpB.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.kpN.cOE());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.kpN.cOE());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.cOC();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.iWt.b(getPageContext());
        this.kqe = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.kqf = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.kpN.cOE().getAlaId() > 0) {
            this.kqe.setVisibility(0);
            this.kqf.setText(this.kpN.cOE().getAlaId() + "");
        }
        this.kqg = (TextView) findViewById(R.id.person_forum_age_show);
        this.kqg.setText(getResources().getString(R.string.person_forum_age_suffix, this.kpN.cOE().getForumAge()));
        this.kqh = (RelativeLayout) findViewById(R.id.person_constellation);
        this.kqh.setOnClickListener(this);
        this.kqi = (TextView) findViewById(R.id.constellation_txt);
        this.kqj = (TextView) findViewById(R.id.age_txt);
        if (this.kpN.cOE().getBirthdayTime() != 0) {
            this.kqi.setText(aq.m(new Date(this.kpN.cOE().getBirthdayTime() * 1000)));
        }
        if (this.kpN.cOE().getUserAge() > 0 && this.kpN.cOE().getBirthdayShowStatus() == 2) {
            this.kqj.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.kpN.cOE().getUserAge())));
            this.kqj.setVisibility(0);
        } else {
            this.kqj.setVisibility(8);
        }
        this.kpD.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.kpD.scrollTo(0, 0);
            }
        });
    }

    private void cOw() {
        if (NickNameActivitySwitch.isOn() || this.kpN.cOE().getNickNameLeftDays() == 0) {
            this.kqa.setVisibility(0);
        } else {
            this.kqa.setVisibility(8);
        }
    }

    public void cOx() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.kJ(R.string.operation);
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
        bVar.aSU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOy() {
        int color;
        if (this.gea.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = am.getColor(R.color.common_color_10159);
        } else {
            color = am.getColor(R.color.common_color_10077);
        }
        Bo(color);
    }

    private void Bo(int i) {
        this.kpJ.setTextColor(i);
        this.kpK.setTextColor(i);
        this.kpL.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOz() {
        if (this.kpN != null && this.kpN.cOE() != null) {
            cOu();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.kpN.cOE().setIntro(this.gea.getText().toString().replaceAll("\\s*", ""));
            this.kpN.cOE().setSex(this.mSex);
            if (this.kpP == null) {
                this.kpP = new b(this.kpN);
                this.kpP.setPriority(3);
                this.kpP.execute(new String[0]);
            }
        }
    }

    private void cOA() {
        if (this.kpR == null) {
            this.kpR = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.kpR.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.kpR != null && PersonChangeActivity.this.kpR.isShowing()) {
                        PersonChangeActivity.this.kpR.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.kpG.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.kpG.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.kpN.cOE().getSex()) {
                            PersonChangeActivity.this.hVS = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                am.setViewTextColor(PersonChangeActivity.this.iEn, R.color.navi_op_text, 1);
                            } else {
                                am.setViewTextColor(PersonChangeActivity.this.iEn, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.kpR.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cOu();
            this.kqk.onClick(null);
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
                        if (longExtra != this.kpN.cOE().getBirthdayTime() || intExtra != this.kpN.cOE().getBirthdayShowStatus()) {
                            this.kpN.cOE().setBirthdayShowStatus(intExtra);
                            this.kpN.cOE().setBirthdayTime(longExtra);
                            this.kpS = true;
                            this.hVS = true;
                            Date date = new Date(longExtra * 1000);
                            this.kqi.setText(aq.m(date));
                            if (this.kpN.cOE().getBirthdayShowStatus() == 2) {
                                this.kqj.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(o(date))));
                                this.kqj.setVisibility(0);
                                return;
                            }
                            this.kqj.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            af(intent);
                            return;
                        } else {
                            Y(intent);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.kpN.cOE().setPhotoChanged(true);
                    cOB();
                    this.hVS = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.iEn, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.iEn, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.kpN.cOE().setPhotoChanged(true);
                    if (intent != null) {
                        this.hiR.setImageBitmap(null);
                        this.hiR.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.hVS = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.iEn, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.iEn, R.color.cp_link_tip_a, 1);
                        return;
                    }
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    al.d(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    public static int o(Date date) {
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

    private void Kl(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.kpT = true;
            this.kpN.cOE().setPhotoChanged(true);
            this.kpN.cOE().setNameShow(str);
            this.kpN.cOE().setNickNameLeftDays(90);
            this.kpE.setText(str);
            cOw();
        }
    }

    private void Y(Intent intent) {
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

    private void af(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, RequestResponseCode.REQUEST_CAMERA_VIEW, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void cOB() {
        if (this.kpO != null) {
            this.kpO.cancel();
        }
        this.ixu = null;
        this.kpO = new a();
        this.kpO.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOC() {
        if (this.kpN != null && this.kpN.cOE() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.kpN.cOE()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.kpQ.setVisibility(0);
            PersonChangeActivity.this.hiR.setImageDrawable(null);
            PersonChangeActivity.this.ixu = null;
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
            PersonChangeActivity.this.kpO = null;
            PersonChangeActivity.this.kpQ.setVisibility(8);
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
            PersonChangeActivity.this.kpO = null;
            PersonChangeActivity.this.kpQ.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.ixu = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.ixu.drawImageTo(PersonChangeActivity.this.hiR);
                com.baidu.tbadk.imageManager.c.beu().a(PersonChangeActivity.this.kpN.cOE().getPortrait(), PersonChangeActivity.this.ixu, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOD() {
        Intent intent = new Intent();
        if (this.kpB.booleanValue()) {
            intent.putExtra("person_change_data", this.kpN.cOE());
        } else {
            intent.putExtra("data", this.kpN.cOE());
        }
        setResult(-1, intent);
        cOC();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private x bth = null;
        private PersonChangeModel kpN;

        public b(PersonChangeModel personChangeModel) {
            this.kpN = null;
            this.kpN = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.kpP = null;
            if (this.bth != null) {
                this.bth.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.kpP = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.bth != null) {
                if (this.bth.aUA().aVc().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.cOD();
                } else {
                    PersonChangeActivity.this.showToast(this.bth.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.hes);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.kpN != null) {
                this.bth = new x(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.bth.addPostData("sex", String.valueOf(this.kpN.cOE().getSex()));
                this.bth.addPostData("intro", this.kpN.cOE().getIntro());
                this.bth.addPostData("birthday_time", String.valueOf(this.kpN.cOE().getBirthdayTime()));
                this.bth.addPostData("birthday_show_status", String.valueOf(this.kpN.cOE().getBirthdayShowStatus()));
                this.bth.postMultiNetData();
                if (this.bth.aUA().aVc().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.deC();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hoe && !TextUtils.isEmpty(this.kqd)) {
            Kl(this.kqd);
            this.hoe = false;
            this.kqd = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Km(String str) {
        if (!StringUtils.isNull(str)) {
            this.kpV = true;
            this.kpX.setText(str);
            this.kpW.setClickable(false);
            this.kpY.setVisibility(8);
        }
    }
}
