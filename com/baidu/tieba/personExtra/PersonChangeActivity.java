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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.util.z;
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
    private ImageView dJt;
    private View dJu;
    private com.baidu.tbadk.coreExtra.view.b epl;
    private View kSD;
    private View kSX;
    private TextView kSY;
    private View kSZ;
    private View kTa;
    private View kTb;
    private View kTc;
    private com.baidu.tbadk.core.dialog.a kTd;
    private String kTe;
    private LinearLayout kTf;
    private TextView kTg;
    private TextView kTh;
    private RelativeLayout kTi;
    private TextView kTj;
    private TextView kTk;
    private PermissionJudgePolicy mPermissionJudgement;
    public final int kSB = 90;
    private Boolean kSC = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView jdD = null;
    private LinearLayout hvx = null;
    private ScrollView kSE = null;
    private TextView kSF = null;
    private RelativeLayout kSG = null;
    private TextView kSH = null;
    private LinearLayout kSI = null;
    private TextView fGr = null;
    private EditText gwq = null;
    private LinearLayout kSJ = null;
    private TextView kSK = null;
    private TextView kSL = null;
    private TextView kSM = null;
    private InputMethodManager mInputManager = null;
    private boolean kSN = false;
    private PersonChangeModel kSO = null;
    protected HeadImageView hAM = null;
    private com.baidu.adp.widget.ImageView.a iVE = null;
    private a kSP = null;
    private b kSQ = null;
    private ProgressBar kSR = null;
    private DialogInterface.OnCancelListener hwp = null;
    private com.baidu.tbadk.core.dialog.a jwm = null;
    private com.baidu.tbadk.core.dialog.i kSS = null;
    private boolean kST = false;
    private boolean iqs = false;
    private boolean kSU = false;
    private int mSex = 0;
    private final int kSV = 500;
    private boolean kSW = false;
    private boolean hGn = false;
    private final View.OnClickListener kTl = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.kSO.cWM().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.kST = true;
            }
            if (PersonChangeActivity.this.kST) {
                PersonChangeActivity.this.jwm.aYL();
                return;
            }
            if (PersonChangeActivity.this.kSO != null && PersonChangeActivity.this.kSO.cWM().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.kSC.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.kSO.cWM());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.kSO.cWM());
                }
                PersonChangeActivity.this.cWK();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener hHm = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.hGn = true;
                        PersonChangeActivity.this.kTe = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener kTm = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.kSO != null && PersonChangeActivity.this.kSO.cWM() != null && personChangeData != null) {
                    PersonChangeActivity.this.kSO.cWM().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.kSO.cWM().setMem(personChangeData.getMen());
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
        aG(bundle);
        brF();
        if (bundle != null) {
            this.kSC = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.kSC = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.hHm);
        registerListener(this.kTm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hHm);
        if (this.kSP != null) {
            this.kSP.cancel();
        }
        if (this.kSQ != null) {
            this.kSQ.cancel();
        }
        if (this.kSR != null) {
            this.kSR.setVisibility(8);
        }
        if (this.gwq != null) {
            this.gwq.addTextChangedListener(null);
        }
        if (this.epl != null) {
            this.epl.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hAM || view == this.kTc) {
            if (this.kSO != null && this.kSO.kTq != null && !this.kSO.kTq.canModifyAvatar()) {
                if (!StringUtils.isNull(this.kSO.kTq.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.kSO.kTq.getCantModifyAvatarDesc());
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
                cWF();
            }
        } else if (view == this.kSD) {
            if (!this.iqs && !this.kSU) {
                finish();
            }
            if (this.kSC.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.iqs) {
                cWH();
            } else if (this.kSU) {
                cWL();
            }
        } else if (view == this.kSG) {
            cWI();
        } else if (view == this.kSI) {
            cWD();
        } else if (view == this.gwq) {
            CP(800);
        } else if (view == this.kTa) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                cWB();
            } else {
                int nickNameLeftDays = this.kSO.cWM().getNickNameLeftDays();
                if (this.kSO.cWM().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.xl(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).aYL();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.kSX) {
            if (this.kSO == null || this.kSO.cWM() == null || StringUtils.isNull(this.kSO.cWM().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.kTi) {
            PersonConstellationActivity.a(getActivity(), this.kSO.cWM().getBirthdayTime(), this.kSO.cWM().getBirthdayShowStatus());
        }
    }

    private void cWB() {
        if (this.kTd == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.kTd = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.kTd.aV(inflate);
            this.kTd.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.cKh(), true)));
                    aVar.dismiss();
                }
            });
            this.kTd.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.kTd.b(getPageContext());
            ao.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), R.color.cp_cont_b);
            ao.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.kTd.aYL();
    }

    private void i(AccountData accountData) {
        if (this.epl == null) {
            this.epl = new com.baidu.tbadk.coreExtra.view.b(this);
            this.epl.a(new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.LB(accountData2.getAccount());
                    }
                }
            });
        }
        this.epl.bhi();
        this.epl.setAccountData(accountData);
        this.epl.bhe();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.kSN = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.kSN) {
            cWC();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWC() {
        if (this.gwq.getVisibility() == 0) {
            String replaceAll = this.gwq.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.fGr.setText(replaceAll);
            } else {
                this.fGr.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.kSO.cWM().getIntro() == null || !this.kSO.cWM().getIntro().equals(replaceAll)) {
                this.kST = true;
            }
            this.kSO.cWM().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.gwq);
        }
    }

    private void cWD() {
        if (this.gwq.getVisibility() != 0) {
            this.fGr.setVisibility(8);
            this.gwq.setText(this.kSO.cWM().getIntro());
            this.gwq.setSelection(this.gwq.getText().length());
            this.gwq.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.gwq);
            CP(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CP(int i) {
        this.kSE.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.kSE.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aG(Bundle bundle) {
        this.hwp = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.kSQ != null) {
                    PersonChangeActivity.this.kSQ.cancel();
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
        this.kSO = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.hvx);
        SvgManager.baR().a(this.dJt, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.hAM.refresh();
        ao.setViewTextColor(this.kSY, R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.kSO.cWM() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.kSO.cWM()));
        }
    }

    private void brF() {
        this.kTc = findViewById(R.id.photo_pop_icon);
        this.kTc.setOnClickListener(this);
        this.hAM = (HeadImageView) findViewById(R.id.photo);
        this.hAM.setOnClickListener(this);
        this.hAM.startLoad(q.xH(this.kSO.cWM().getPortrait()), 25, false);
        this.hvx = (LinearLayout) findViewById(R.id.parent);
        this.kSE = (ScrollView) findViewById(R.id.person_change_scroll);
        this.kSG = (RelativeLayout) findViewById(R.id.person_sex);
        this.kSH = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.dJu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.kTl);
        this.dJt = (ImageView) this.dJu.findViewById(R.id.widget_navi_back_button);
        this.dJt.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.kSD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.jdD = (TextView) this.kSD.findViewById(R.id.right_textview);
        this.jdD.setText(getPageContext().getString(R.string.save));
        ao.setViewTextColor(this.jdD, R.color.navi_op_text, 1);
        this.kSD.setOnClickListener(this);
        this.kSG.setOnClickListener(this);
        this.kSI = (LinearLayout) findViewById(R.id.intro_click);
        this.kSI.setOnClickListener(this);
        this.kSI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.kSN = true;
                    return false;
                }
                return false;
            }
        });
        this.kSF = (TextView) findViewById(R.id.nick_name_show);
        this.kSF.setText(this.kSO.cWM().getNameShow());
        this.kTa = findViewById(R.id.person_nickname);
        this.kTa.setOnClickListener(this);
        this.kTb = findViewById(R.id.nick_name_more);
        cWE();
        this.kSY = (TextView) findViewById(R.id.user_name_show);
        this.kSX = findViewById(R.id.person_name);
        this.kSZ = findViewById(R.id.user_name_more_icon);
        this.kSX.setOnClickListener(this);
        if (StringUtils.isNull(this.kSO.cWM().getName())) {
            this.kSY.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.kSW = false;
            this.kSX.setClickable(true);
            this.kSZ.setVisibility(0);
        } else {
            this.kSY.setText(this.kSO.cWM().getName());
            this.kSW = true;
            this.kSX.setClickable(false);
            this.kSZ.setVisibility(8);
        }
        this.kSJ = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.kSK = (TextView) findViewById(R.id.intro_text_tip_num);
        this.kSL = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.kSM = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.fGr = (TextView) findViewById(R.id.intro);
        this.fGr.setVisibility(8);
        if (this.kSO.cWM().getIntro() != null && this.kSO.cWM().getIntro().length() > 0) {
            this.fGr.setText(this.kSO.cWM().getIntro());
        } else {
            this.fGr.setText(getPageContext().getString(R.string.add_intro));
        }
        this.gwq = (EditText) findViewById(R.id.edit);
        this.gwq.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.gwq.setHintTextColor(ao.getColor(R.color.cp_cont_c));
        this.gwq.setCursorVisible(false);
        if (!as.isEmpty(this.kSO.cWM().getIntro())) {
            this.gwq.setText(this.kSO.cWM().getIntro());
            this.kSK.setText(this.kSO.cWM().getIntro().length() + "");
        } else {
            this.kSK.setText("0");
        }
        this.kSJ.setVisibility(0);
        this.gwq.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.cWC();
                }
            }
        });
        this.gwq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.kSN = true;
                    PersonChangeActivity.this.gwq.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.gwq.setOnClickListener(this);
        this.gwq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.gwq.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.kSK.setText(String.valueOf(length));
                PersonChangeActivity.this.kSJ.setVisibility(0);
                PersonChangeActivity.this.CP(0);
                PersonChangeActivity.this.cWG();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.gwq.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.gwq.getSelectionStart() - 1 > PersonChangeActivity.this.gwq.getSelectionEnd()) {
                        PersonChangeActivity.this.gwq.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.gwq.getSelectionStart() - 1, PersonChangeActivity.this.gwq.getSelectionEnd());
                        PersonChangeActivity.this.gwq.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.gwq.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.kSO.cWM().getIntro())) {
                    PersonChangeActivity.this.iqs = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ao.setViewTextColor(PersonChangeActivity.this.jdD, R.color.navi_op_text, 1);
                    } else {
                        ao.setViewTextColor(PersonChangeActivity.this.jdD, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.kSO.cWM().getSex() == 1) {
            this.mSex = 1;
            this.kSH.setText(R.string.male);
        } else if (this.kSO.cWM().getSex() == 2) {
            this.mSex = 2;
            this.kSH.setText(R.string.female);
        } else {
            this.kSH.setText(R.string.change_sex);
        }
        this.kSR = (ProgressBar) findViewById(R.id.image_progress);
        this.jwm = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.jwm.xl(getPageContext().getString(R.string.confirm_giveup));
        this.jwm.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.cWH();
            }
        });
        this.jwm.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.kSO.cWM().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.kSC.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.kSO.cWM());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.kSO.cWM());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.cWK();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.jwm.b(getPageContext());
        this.kTf = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.kTg = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.kSO.cWM().getAlaId() > 0) {
            this.kTf.setVisibility(0);
            this.kTg.setText(this.kSO.cWM().getAlaId() + "");
        }
        this.kTh = (TextView) findViewById(R.id.person_forum_age_show);
        this.kTh.setText(getResources().getString(R.string.person_forum_age_suffix, this.kSO.cWM().getForumAge()));
        this.kTi = (RelativeLayout) findViewById(R.id.person_constellation);
        this.kTi.setOnClickListener(this);
        this.kTj = (TextView) findViewById(R.id.constellation_txt);
        this.kTk = (TextView) findViewById(R.id.age_txt);
        if (this.kSO.cWM().getBirthdayTime() != 0) {
            this.kTj.setText(as.p(new Date(this.kSO.cWM().getBirthdayTime() * 1000)));
        }
        if (this.kSO.cWM().getUserAge() > 0 && this.kSO.cWM().getBirthdayShowStatus() == 2) {
            this.kTk.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.kSO.cWM().getUserAge())));
            this.kTk.setVisibility(0);
        } else {
            this.kTk.setVisibility(8);
        }
        this.kSE.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.kSE.scrollTo(0, 0);
            }
        });
    }

    private void cWE() {
        if (NickNameActivitySwitch.isOn() || this.kSO.cWM().getNickNameLeftDays() == 0) {
            this.kTb.setVisibility(0);
        } else {
            this.kTb.setVisibility(8);
        }
    }

    public void cWF() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.lr(R.string.operation);
        bVar.a(strArr, new b.InterfaceC0492b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0492b
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
        bVar.aYN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWG() {
        int color;
        if (this.gwq.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = ao.getColor(R.color.common_color_10159);
        } else {
            color = ao.getColor(R.color.common_color_10077);
        }
        CQ(color);
    }

    private void CQ(int i) {
        this.kSK.setTextColor(i);
        this.kSL.setTextColor(i);
        this.kSM.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWH() {
        if (this.kSO != null && this.kSO.cWM() != null) {
            cWC();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.kSO.cWM().setIntro(this.gwq.getText().toString().replaceAll("\\s*", ""));
            this.kSO.cWM().setSex(this.mSex);
            if (this.kSQ == null) {
                this.kSQ = new b(this.kSO);
                this.kSQ.setPriority(3);
                this.kSQ.execute(new String[0]);
            }
        }
    }

    private void cWI() {
        if (this.kSS == null) {
            this.kSS = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.kSS.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.kSS != null && PersonChangeActivity.this.kSS.isShowing()) {
                        PersonChangeActivity.this.kSS.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.kSH.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.kSH.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.kSO.cWM().getSex()) {
                            PersonChangeActivity.this.iqs = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                ao.setViewTextColor(PersonChangeActivity.this.jdD, R.color.navi_op_text, 1);
                            } else {
                                ao.setViewTextColor(PersonChangeActivity.this.jdD, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.kSS.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cWC();
            this.kTl.onClick(null);
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
                        if (longExtra != this.kSO.cWM().getBirthdayTime() || intExtra != this.kSO.cWM().getBirthdayShowStatus()) {
                            this.kSO.cWM().setBirthdayShowStatus(intExtra);
                            this.kSO.cWM().setBirthdayTime(longExtra);
                            this.kST = true;
                            this.iqs = true;
                            Date date = new Date(longExtra * 1000);
                            this.kTj.setText(as.p(date));
                            if (this.kSO.cWM().getBirthdayShowStatus() == 2) {
                                this.kTk.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(r(date))));
                                this.kTk.setVisibility(0);
                                return;
                            }
                            this.kTk.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ah(intent);
                            return;
                        } else {
                            Z(intent);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.kSO.cWM().setPhotoChanged(true);
                    cWJ();
                    this.iqs = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ao.setViewTextColor(this.jdD, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ao.setViewTextColor(this.jdD, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.kSO.cWM().setPhotoChanged(true);
                    if (intent != null) {
                        this.hAM.setImageBitmap(null);
                        this.hAM.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.iqs = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ao.setViewTextColor(this.jdD, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ao.setViewTextColor(this.jdD, R.color.cp_link_tip_a, 1);
                        return;
                    }
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    an.g(getPageContext());
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

    private void LA(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.kSU = true;
            this.kSO.cWM().setPhotoChanged(true);
            this.kSO.cWM().setNameShow(str);
            this.kSO.cWM().setNickNameLeftDays(90);
            this.kSF.setText(str);
            cWE();
        }
    }

    private void Z(Intent intent) {
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

    private void ah(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, RequestResponseCode.REQUEST_CAMERA_VIEW, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void cWJ() {
        if (this.kSP != null) {
            this.kSP.cancel();
        }
        this.iVE = null;
        this.kSP = new a();
        this.kSP.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWK() {
        if (this.kSO != null && this.kSO.cWM() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.kSO.cWM()));
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
            PersonChangeActivity.this.kSR.setVisibility(0);
            PersonChangeActivity.this.hAM.setImageDrawable(null);
            PersonChangeActivity.this.iVE = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(Object... objArr) {
            return n.getImage(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.kSP = null;
            PersonChangeActivity.this.kSR.setVisibility(8);
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
            PersonChangeActivity.this.kSP = null;
            PersonChangeActivity.this.kSR.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.iVE = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.iVE.drawImageTo(PersonChangeActivity.this.hAM);
                com.baidu.tbadk.imageManager.c.bkk().a(PersonChangeActivity.this.kSO.cWM().getPortrait(), PersonChangeActivity.this.iVE, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWL() {
        Intent intent = new Intent();
        if (this.kSC.booleanValue()) {
            intent.putExtra("person_change_data", this.kSO.cWM());
        } else {
            intent.putExtra("data", this.kSO.cWM());
        }
        setResult(-1, intent);
        cWK();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private z byq = null;
        private PersonChangeModel kSO;

        public b(PersonChangeModel personChangeModel) {
            this.kSO = null;
            this.kSO = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.kSQ = null;
            if (this.byq != null) {
                this.byq.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.kSQ = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.byq != null) {
                if (this.byq.bav().baX().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.cWL();
                } else {
                    PersonChangeActivity.this.showToast(this.byq.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.hwp);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.kSO != null) {
                this.byq = new z(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.byq.addPostData("sex", String.valueOf(this.kSO.cWM().getSex()));
                this.byq.addPostData("intro", this.kSO.cWM().getIntro());
                this.byq.addPostData("birthday_time", String.valueOf(this.kSO.cWM().getBirthdayTime()));
                this.byq.addPostData("birthday_show_status", String.valueOf(this.kSO.cWM().getBirthdayShowStatus()));
                this.byq.postMultiNetData();
                if (this.byq.bav().baX().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.dlY();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hGn && !TextUtils.isEmpty(this.kTe)) {
            LA(this.kTe);
            this.hGn = false;
            this.kTe = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LB(String str) {
        if (!StringUtils.isNull(str)) {
            this.kSW = true;
            this.kSY.setText(str);
            this.kSX.setClickable(false);
            this.kSZ.setVisibility(8);
        }
    }
}
