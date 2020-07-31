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
    private View kSB;
    private View kSV;
    private TextView kSW;
    private View kSX;
    private View kSY;
    private View kSZ;
    private View kTa;
    private com.baidu.tbadk.core.dialog.a kTb;
    private String kTc;
    private LinearLayout kTd;
    private TextView kTe;
    private TextView kTf;
    private RelativeLayout kTg;
    private TextView kTh;
    private TextView kTi;
    private PermissionJudgePolicy mPermissionJudgement;
    public final int kSz = 90;
    private Boolean kSA = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView jdB = null;
    private LinearLayout hvx = null;
    private ScrollView kSC = null;
    private TextView kSD = null;
    private RelativeLayout kSE = null;
    private TextView kSF = null;
    private LinearLayout kSG = null;
    private TextView fGr = null;
    private EditText gwq = null;
    private LinearLayout kSH = null;
    private TextView kSI = null;
    private TextView kSJ = null;
    private TextView kSK = null;
    private InputMethodManager mInputManager = null;
    private boolean kSL = false;
    private PersonChangeModel kSM = null;
    protected HeadImageView hAM = null;
    private com.baidu.adp.widget.ImageView.a iVC = null;
    private a kSN = null;
    private b kSO = null;
    private ProgressBar kSP = null;
    private DialogInterface.OnCancelListener hwp = null;
    private com.baidu.tbadk.core.dialog.a jwk = null;
    private com.baidu.tbadk.core.dialog.i kSQ = null;
    private boolean kSR = false;
    private boolean iqq = false;
    private boolean kSS = false;
    private int mSex = 0;
    private final int kST = 500;
    private boolean kSU = false;
    private boolean hGn = false;
    private final View.OnClickListener kTj = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.kSM.cWM().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.kSR = true;
            }
            if (PersonChangeActivity.this.kSR) {
                PersonChangeActivity.this.jwk.aYL();
                return;
            }
            if (PersonChangeActivity.this.kSM != null && PersonChangeActivity.this.kSM.cWM().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.kSA.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.kSM.cWM());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.kSM.cWM());
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
                        PersonChangeActivity.this.kTc = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener kTk = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.kSM != null && PersonChangeActivity.this.kSM.cWM() != null && personChangeData != null) {
                    PersonChangeActivity.this.kSM.cWM().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.kSM.cWM().setMem(personChangeData.getMen());
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
            this.kSA = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.kSA = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.hHm);
        registerListener(this.kTk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hHm);
        if (this.kSN != null) {
            this.kSN.cancel();
        }
        if (this.kSO != null) {
            this.kSO.cancel();
        }
        if (this.kSP != null) {
            this.kSP.setVisibility(8);
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
        if (view == this.hAM || view == this.kTa) {
            if (this.kSM != null && this.kSM.kTo != null && !this.kSM.kTo.canModifyAvatar()) {
                if (!StringUtils.isNull(this.kSM.kTo.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.kSM.kTo.getCantModifyAvatarDesc());
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
        } else if (view == this.kSB) {
            if (!this.iqq && !this.kSS) {
                finish();
            }
            if (this.kSA.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.iqq) {
                cWH();
            } else if (this.kSS) {
                cWL();
            }
        } else if (view == this.kSE) {
            cWI();
        } else if (view == this.kSG) {
            cWD();
        } else if (view == this.gwq) {
            CP(800);
        } else if (view == this.kSY) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                cWB();
            } else {
                int nickNameLeftDays = this.kSM.cWM().getNickNameLeftDays();
                if (this.kSM.cWM().getMen() <= 0) {
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
        } else if (view == this.kSV) {
            if (this.kSM == null || this.kSM.cWM() == null || StringUtils.isNull(this.kSM.cWM().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.kTg) {
            PersonConstellationActivity.a(getActivity(), this.kSM.cWM().getBirthdayTime(), this.kSM.cWM().getBirthdayShowStatus());
        }
    }

    private void cWB() {
        if (this.kTb == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.kTb = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.kTb.aV(inflate);
            this.kTb.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.cKh(), true)));
                    aVar.dismiss();
                }
            });
            this.kTb.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.kTb.b(getPageContext());
            ao.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), R.color.cp_cont_b);
            ao.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.kTb.aYL();
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
        this.kSL = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.kSL) {
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
            if (this.kSM.cWM().getIntro() == null || !this.kSM.cWM().getIntro().equals(replaceAll)) {
                this.kSR = true;
            }
            this.kSM.cWM().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.gwq);
        }
    }

    private void cWD() {
        if (this.gwq.getVisibility() != 0) {
            this.fGr.setVisibility(8);
            this.gwq.setText(this.kSM.cWM().getIntro());
            this.gwq.setSelection(this.gwq.getText().length());
            this.gwq.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.gwq);
            CP(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CP(int i) {
        this.kSC.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.kSC.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aG(Bundle bundle) {
        this.hwp = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.kSO != null) {
                    PersonChangeActivity.this.kSO.cancel();
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
        this.kSM = new PersonChangeModel(personChangeData);
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
        ao.setViewTextColor(this.kSW, R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.kSM.cWM() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.kSM.cWM()));
        }
    }

    private void brF() {
        this.kTa = findViewById(R.id.photo_pop_icon);
        this.kTa.setOnClickListener(this);
        this.hAM = (HeadImageView) findViewById(R.id.photo);
        this.hAM.setOnClickListener(this);
        this.hAM.startLoad(q.xH(this.kSM.cWM().getPortrait()), 25, false);
        this.hvx = (LinearLayout) findViewById(R.id.parent);
        this.kSC = (ScrollView) findViewById(R.id.person_change_scroll);
        this.kSE = (RelativeLayout) findViewById(R.id.person_sex);
        this.kSF = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.dJu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.kTj);
        this.dJt = (ImageView) this.dJu.findViewById(R.id.widget_navi_back_button);
        this.dJt.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.kSB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.jdB = (TextView) this.kSB.findViewById(R.id.right_textview);
        this.jdB.setText(getPageContext().getString(R.string.save));
        ao.setViewTextColor(this.jdB, R.color.navi_op_text, 1);
        this.kSB.setOnClickListener(this);
        this.kSE.setOnClickListener(this);
        this.kSG = (LinearLayout) findViewById(R.id.intro_click);
        this.kSG.setOnClickListener(this);
        this.kSG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.kSL = true;
                    return false;
                }
                return false;
            }
        });
        this.kSD = (TextView) findViewById(R.id.nick_name_show);
        this.kSD.setText(this.kSM.cWM().getNameShow());
        this.kSY = findViewById(R.id.person_nickname);
        this.kSY.setOnClickListener(this);
        this.kSZ = findViewById(R.id.nick_name_more);
        cWE();
        this.kSW = (TextView) findViewById(R.id.user_name_show);
        this.kSV = findViewById(R.id.person_name);
        this.kSX = findViewById(R.id.user_name_more_icon);
        this.kSV.setOnClickListener(this);
        if (StringUtils.isNull(this.kSM.cWM().getName())) {
            this.kSW.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.kSU = false;
            this.kSV.setClickable(true);
            this.kSX.setVisibility(0);
        } else {
            this.kSW.setText(this.kSM.cWM().getName());
            this.kSU = true;
            this.kSV.setClickable(false);
            this.kSX.setVisibility(8);
        }
        this.kSH = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.kSI = (TextView) findViewById(R.id.intro_text_tip_num);
        this.kSJ = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.kSK = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.fGr = (TextView) findViewById(R.id.intro);
        this.fGr.setVisibility(8);
        if (this.kSM.cWM().getIntro() != null && this.kSM.cWM().getIntro().length() > 0) {
            this.fGr.setText(this.kSM.cWM().getIntro());
        } else {
            this.fGr.setText(getPageContext().getString(R.string.add_intro));
        }
        this.gwq = (EditText) findViewById(R.id.edit);
        this.gwq.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.gwq.setHintTextColor(ao.getColor(R.color.cp_cont_c));
        this.gwq.setCursorVisible(false);
        if (!as.isEmpty(this.kSM.cWM().getIntro())) {
            this.gwq.setText(this.kSM.cWM().getIntro());
            this.kSI.setText(this.kSM.cWM().getIntro().length() + "");
        } else {
            this.kSI.setText("0");
        }
        this.kSH.setVisibility(0);
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
                    PersonChangeActivity.this.kSL = true;
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
                PersonChangeActivity.this.kSI.setText(String.valueOf(length));
                PersonChangeActivity.this.kSH.setVisibility(0);
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.kSM.cWM().getIntro())) {
                    PersonChangeActivity.this.iqq = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ao.setViewTextColor(PersonChangeActivity.this.jdB, R.color.navi_op_text, 1);
                    } else {
                        ao.setViewTextColor(PersonChangeActivity.this.jdB, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.kSM.cWM().getSex() == 1) {
            this.mSex = 1;
            this.kSF.setText(R.string.male);
        } else if (this.kSM.cWM().getSex() == 2) {
            this.mSex = 2;
            this.kSF.setText(R.string.female);
        } else {
            this.kSF.setText(R.string.change_sex);
        }
        this.kSP = (ProgressBar) findViewById(R.id.image_progress);
        this.jwk = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.jwk.xl(getPageContext().getString(R.string.confirm_giveup));
        this.jwk.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.cWH();
            }
        });
        this.jwk.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.kSM.cWM().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.kSA.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.kSM.cWM());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.kSM.cWM());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.cWK();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.jwk.b(getPageContext());
        this.kTd = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.kTe = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.kSM.cWM().getAlaId() > 0) {
            this.kTd.setVisibility(0);
            this.kTe.setText(this.kSM.cWM().getAlaId() + "");
        }
        this.kTf = (TextView) findViewById(R.id.person_forum_age_show);
        this.kTf.setText(getResources().getString(R.string.person_forum_age_suffix, this.kSM.cWM().getForumAge()));
        this.kTg = (RelativeLayout) findViewById(R.id.person_constellation);
        this.kTg.setOnClickListener(this);
        this.kTh = (TextView) findViewById(R.id.constellation_txt);
        this.kTi = (TextView) findViewById(R.id.age_txt);
        if (this.kSM.cWM().getBirthdayTime() != 0) {
            this.kTh.setText(as.p(new Date(this.kSM.cWM().getBirthdayTime() * 1000)));
        }
        if (this.kSM.cWM().getUserAge() > 0 && this.kSM.cWM().getBirthdayShowStatus() == 2) {
            this.kTi.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.kSM.cWM().getUserAge())));
            this.kTi.setVisibility(0);
        } else {
            this.kTi.setVisibility(8);
        }
        this.kSC.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.kSC.scrollTo(0, 0);
            }
        });
    }

    private void cWE() {
        if (NickNameActivitySwitch.isOn() || this.kSM.cWM().getNickNameLeftDays() == 0) {
            this.kSZ.setVisibility(0);
        } else {
            this.kSZ.setVisibility(8);
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
        this.kSI.setTextColor(i);
        this.kSJ.setTextColor(i);
        this.kSK.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWH() {
        if (this.kSM != null && this.kSM.cWM() != null) {
            cWC();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.kSM.cWM().setIntro(this.gwq.getText().toString().replaceAll("\\s*", ""));
            this.kSM.cWM().setSex(this.mSex);
            if (this.kSO == null) {
                this.kSO = new b(this.kSM);
                this.kSO.setPriority(3);
                this.kSO.execute(new String[0]);
            }
        }
    }

    private void cWI() {
        if (this.kSQ == null) {
            this.kSQ = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.kSQ.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.kSQ != null && PersonChangeActivity.this.kSQ.isShowing()) {
                        PersonChangeActivity.this.kSQ.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.kSF.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.kSF.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.kSM.cWM().getSex()) {
                            PersonChangeActivity.this.iqq = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                ao.setViewTextColor(PersonChangeActivity.this.jdB, R.color.navi_op_text, 1);
                            } else {
                                ao.setViewTextColor(PersonChangeActivity.this.jdB, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.kSQ.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cWC();
            this.kTj.onClick(null);
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
                        if (longExtra != this.kSM.cWM().getBirthdayTime() || intExtra != this.kSM.cWM().getBirthdayShowStatus()) {
                            this.kSM.cWM().setBirthdayShowStatus(intExtra);
                            this.kSM.cWM().setBirthdayTime(longExtra);
                            this.kSR = true;
                            this.iqq = true;
                            Date date = new Date(longExtra * 1000);
                            this.kTh.setText(as.p(date));
                            if (this.kSM.cWM().getBirthdayShowStatus() == 2) {
                                this.kTi.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(r(date))));
                                this.kTi.setVisibility(0);
                                return;
                            }
                            this.kTi.setVisibility(8);
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
                    this.kSM.cWM().setPhotoChanged(true);
                    cWJ();
                    this.iqq = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ao.setViewTextColor(this.jdB, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ao.setViewTextColor(this.jdB, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.kSM.cWM().setPhotoChanged(true);
                    if (intent != null) {
                        this.hAM.setImageBitmap(null);
                        this.hAM.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.iqq = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ao.setViewTextColor(this.jdB, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ao.setViewTextColor(this.jdB, R.color.cp_link_tip_a, 1);
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
            this.kSS = true;
            this.kSM.cWM().setPhotoChanged(true);
            this.kSM.cWM().setNameShow(str);
            this.kSM.cWM().setNickNameLeftDays(90);
            this.kSD.setText(str);
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
        if (this.kSN != null) {
            this.kSN.cancel();
        }
        this.iVC = null;
        this.kSN = new a();
        this.kSN.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWK() {
        if (this.kSM != null && this.kSM.cWM() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.kSM.cWM()));
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
            PersonChangeActivity.this.kSP.setVisibility(0);
            PersonChangeActivity.this.hAM.setImageDrawable(null);
            PersonChangeActivity.this.iVC = null;
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
            PersonChangeActivity.this.kSN = null;
            PersonChangeActivity.this.kSP.setVisibility(8);
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
            PersonChangeActivity.this.kSN = null;
            PersonChangeActivity.this.kSP.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.iVC = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.iVC.drawImageTo(PersonChangeActivity.this.hAM);
                com.baidu.tbadk.imageManager.c.bkk().a(PersonChangeActivity.this.kSM.cWM().getPortrait(), PersonChangeActivity.this.iVC, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWL() {
        Intent intent = new Intent();
        if (this.kSA.booleanValue()) {
            intent.putExtra("person_change_data", this.kSM.cWM());
        } else {
            intent.putExtra("data", this.kSM.cWM());
        }
        setResult(-1, intent);
        cWK();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes18.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private z byq = null;
        private PersonChangeModel kSM;

        public b(PersonChangeModel personChangeModel) {
            this.kSM = null;
            this.kSM = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.kSO = null;
            if (this.byq != null) {
                this.byq.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.kSO = null;
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
            if (this.kSM != null) {
                this.byq = new z(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.byq.addPostData("sex", String.valueOf(this.kSM.cWM().getSex()));
                this.byq.addPostData("intro", this.kSM.cWM().getIntro());
                this.byq.addPostData("birthday_time", String.valueOf(this.kSM.cWM().getBirthdayTime()));
                this.byq.addPostData("birthday_show_status", String.valueOf(this.kSM.cWM().getBirthdayShowStatus()));
                this.byq.postMultiNetData();
                if (this.byq.bav().baX().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.dlX();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hGn && !TextUtils.isEmpty(this.kTc)) {
            LA(this.kTc);
            this.hGn = false;
            this.kTc = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LB(String str) {
        if (!StringUtils.isNull(str)) {
            this.kSU = true;
            this.kSW.setText(str);
            this.kSV.setClickable(false);
            this.kSX.setVisibility(8);
        }
    }
}
