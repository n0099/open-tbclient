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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
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
    private ImageView dDw;
    private View dDx;
    private com.baidu.tbadk.coreExtra.view.b eiZ;
    private View kJA;
    private View kJU;
    private TextView kJV;
    private View kJW;
    private View kJX;
    private View kJY;
    private View kJZ;
    private com.baidu.tbadk.core.dialog.a kKa;
    private String kKb;
    private LinearLayout kKc;
    private TextView kKd;
    private TextView kKe;
    private RelativeLayout kKf;
    private TextView kKg;
    private TextView kKh;
    private PermissionJudgePolicy mPermissionJudgement;
    public final int kJy = 90;
    private Boolean kJz = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView iVr = null;
    private LinearLayout hpL = null;
    private ScrollView kJB = null;
    private TextView kJC = null;
    private RelativeLayout kJD = null;
    private TextView kJE = null;
    private LinearLayout kJF = null;
    private TextView fBh = null;
    private EditText gqU = null;
    private LinearLayout kJG = null;
    private TextView kJH = null;
    private TextView kJI = null;
    private TextView kJJ = null;
    private InputMethodManager mInputManager = null;
    private boolean kJK = false;
    private PersonChangeModel kJL = null;
    protected HeadImageView hva = null;
    private com.baidu.adp.widget.ImageView.a iOz = null;
    private a kJM = null;
    private b kJN = null;
    private ProgressBar kJO = null;
    private DialogInterface.OnCancelListener hqD = null;
    private com.baidu.tbadk.core.dialog.a jnG = null;
    private com.baidu.tbadk.core.dialog.i kJP = null;
    private boolean kJQ = false;
    private boolean ikn = false;
    private boolean kJR = false;
    private int mSex = 0;
    private final int kJS = 500;
    private boolean kJT = false;
    private boolean hAx = false;
    private final View.OnClickListener kKi = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.kJL.cSV().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.kJQ = true;
            }
            if (PersonChangeActivity.this.kJQ) {
                PersonChangeActivity.this.jnG.aUN();
                return;
            }
            if (PersonChangeActivity.this.kJL != null && PersonChangeActivity.this.kJL.cSV().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.kJz.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.kJL.cSV());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.kJL.cSV());
                }
                PersonChangeActivity.this.cST();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener hBr = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.hAx = true;
                        PersonChangeActivity.this.kKb = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener kKj = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.kJL != null && PersonChangeActivity.this.kJL.cSV() != null && personChangeData != null) {
                    PersonChangeActivity.this.kJL.cSV().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.kJL.cSV().setMem(personChangeData.getMen());
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
        boC();
        if (bundle != null) {
            this.kJz = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.kJz = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.hBr);
        registerListener(this.kKj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hBr);
        if (this.kJM != null) {
            this.kJM.cancel();
        }
        if (this.kJN != null) {
            this.kJN.cancel();
        }
        if (this.kJO != null) {
            this.kJO.setVisibility(8);
        }
        if (this.gqU != null) {
            this.gqU.addTextChangedListener(null);
        }
        if (this.eiZ != null) {
            this.eiZ.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hva || view == this.kJZ) {
            if (this.kJL != null && this.kJL.kKn != null && !this.kJL.kKn.canModifyAvatar()) {
                if (!StringUtils.isNull(this.kJL.kKn.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.kJL.kKn.getCantModifyAvatarDesc());
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
                cSO();
            }
        } else if (view == this.kJA) {
            if (!this.ikn && !this.kJR) {
                finish();
            }
            if (this.kJz.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.ikn) {
                cSQ();
            } else if (this.kJR) {
                cSU();
            }
        } else if (view == this.kJD) {
            cSR();
        } else if (view == this.kJF) {
            cSM();
        } else if (view == this.gqU) {
            Cp(800);
        } else if (view == this.kJX) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                cSK();
            } else {
                int nickNameLeftDays = this.kJL.cSV().getNickNameLeftDays();
                if (this.kJL.cSV().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.we(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).aUN();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.kJU) {
            if (this.kJL == null || this.kJL.cSV() == null || StringUtils.isNull(this.kJL.cSV().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.kKf) {
            PersonConstellationActivity.a(getActivity(), this.kJL.cSV().getBirthdayTime(), this.kJL.cSV().getBirthdayShowStatus());
        }
    }

    private void cSK() {
        if (this.kKa == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.kKa = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.kKa.aP(inflate);
            this.kKa.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.cGx(), true)));
                    aVar.dismiss();
                }
            });
            this.kKa.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.kKa.b(getPageContext());
            an.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), (int) R.color.cp_cont_b);
            an.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), (int) R.color.common_color_10122);
        }
        this.kKa.aUN();
    }

    private void i(AccountData accountData) {
        if (this.eiZ == null) {
            this.eiZ = new com.baidu.tbadk.coreExtra.view.b(this);
            this.eiZ.a(new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.KN(accountData2.getAccount());
                    }
                }
            });
        }
        this.eiZ.bdz();
        this.eiZ.setAccountData(accountData);
        this.eiZ.bdv();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.kJK = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.kJK) {
            cSL();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSL() {
        if (this.gqU.getVisibility() == 0) {
            String replaceAll = this.gqU.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.fBh.setText(replaceAll);
            } else {
                this.fBh.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.kJL.cSV().getIntro() == null || !this.kJL.cSV().getIntro().equals(replaceAll)) {
                this.kJQ = true;
            }
            this.kJL.cSV().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.gqU);
        }
    }

    private void cSM() {
        if (this.gqU.getVisibility() != 0) {
            this.fBh.setVisibility(8);
            this.gqU.setText(this.kJL.cSV().getIntro());
            this.gqU.setSelection(this.gqU.getText().length());
            this.gqU.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.gqU);
            Cp(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cp(int i) {
        this.kJB.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.kJB.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aF(Bundle bundle) {
        this.hqD = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.kJN != null) {
                    PersonChangeActivity.this.kJN.cancel();
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
        this.kJL = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.hpL);
        SvgManager.aWQ().a(this.dDw, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.hva.refresh();
        an.setViewTextColor(this.kJV, (int) R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.kJL.cSV() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.kJL.cSV()));
        }
    }

    private void boC() {
        this.kJZ = findViewById(R.id.photo_pop_icon);
        this.kJZ.setOnClickListener(this);
        this.hva = (HeadImageView) findViewById(R.id.photo);
        this.hva.setOnClickListener(this);
        this.hva.startLoad(p.wz(this.kJL.cSV().getPortrait()), 25, false);
        this.hpL = (LinearLayout) findViewById(R.id.parent);
        this.kJB = (ScrollView) findViewById(R.id.person_change_scroll);
        this.kJD = (RelativeLayout) findViewById(R.id.person_sex);
        this.kJE = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.dDx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.kKi);
        this.dDw = (ImageView) this.dDx.findViewById(R.id.widget_navi_back_button);
        this.dDw.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.kJA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.iVr = (TextView) this.kJA.findViewById(R.id.right_textview);
        this.iVr.setText(getPageContext().getString(R.string.save));
        an.setViewTextColor(this.iVr, R.color.navi_op_text, 1);
        this.kJA.setOnClickListener(this);
        this.kJD.setOnClickListener(this);
        this.kJF = (LinearLayout) findViewById(R.id.intro_click);
        this.kJF.setOnClickListener(this);
        this.kJF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.kJK = true;
                    return false;
                }
                return false;
            }
        });
        this.kJC = (TextView) findViewById(R.id.nick_name_show);
        this.kJC.setText(this.kJL.cSV().getNameShow());
        this.kJX = findViewById(R.id.person_nickname);
        this.kJX.setOnClickListener(this);
        this.kJY = findViewById(R.id.nick_name_more);
        cSN();
        this.kJV = (TextView) findViewById(R.id.user_name_show);
        this.kJU = findViewById(R.id.person_name);
        this.kJW = findViewById(R.id.user_name_more_icon);
        this.kJU.setOnClickListener(this);
        if (StringUtils.isNull(this.kJL.cSV().getName())) {
            this.kJV.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.kJT = false;
            this.kJU.setClickable(true);
            this.kJW.setVisibility(0);
        } else {
            this.kJV.setText(this.kJL.cSV().getName());
            this.kJT = true;
            this.kJU.setClickable(false);
            this.kJW.setVisibility(8);
        }
        this.kJG = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.kJH = (TextView) findViewById(R.id.intro_text_tip_num);
        this.kJI = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.kJJ = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.fBh = (TextView) findViewById(R.id.intro);
        this.fBh.setVisibility(8);
        if (this.kJL.cSV().getIntro() != null && this.kJL.cSV().getIntro().length() > 0) {
            this.fBh.setText(this.kJL.cSV().getIntro());
        } else {
            this.fBh.setText(getPageContext().getString(R.string.add_intro));
        }
        this.gqU = (EditText) findViewById(R.id.edit);
        this.gqU.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.gqU.setHintTextColor(an.getColor(R.color.cp_cont_c));
        this.gqU.setCursorVisible(false);
        if (!ar.isEmpty(this.kJL.cSV().getIntro())) {
            this.gqU.setText(this.kJL.cSV().getIntro());
            this.kJH.setText(this.kJL.cSV().getIntro().length() + "");
        } else {
            this.kJH.setText("0");
        }
        this.kJG.setVisibility(0);
        this.gqU.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.cSL();
                }
            }
        });
        this.gqU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.kJK = true;
                    PersonChangeActivity.this.gqU.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.gqU.setOnClickListener(this);
        this.gqU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.gqU.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.kJH.setText(String.valueOf(length));
                PersonChangeActivity.this.kJG.setVisibility(0);
                PersonChangeActivity.this.Cp(0);
                PersonChangeActivity.this.cSP();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.gqU.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.gqU.getSelectionStart() - 1 > PersonChangeActivity.this.gqU.getSelectionEnd()) {
                        PersonChangeActivity.this.gqU.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.gqU.getSelectionStart() - 1, PersonChangeActivity.this.gqU.getSelectionEnd());
                        PersonChangeActivity.this.gqU.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.gqU.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.kJL.cSV().getIntro())) {
                    PersonChangeActivity.this.ikn = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        an.setViewTextColor(PersonChangeActivity.this.iVr, R.color.navi_op_text, 1);
                    } else {
                        an.setViewTextColor(PersonChangeActivity.this.iVr, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.kJL.cSV().getSex() == 1) {
            this.mSex = 1;
            this.kJE.setText(R.string.male);
        } else if (this.kJL.cSV().getSex() == 2) {
            this.mSex = 2;
            this.kJE.setText(R.string.female);
        } else {
            this.kJE.setText(R.string.change_sex);
        }
        this.kJO = (ProgressBar) findViewById(R.id.image_progress);
        this.jnG = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.jnG.we(getPageContext().getString(R.string.confirm_giveup));
        this.jnG.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.cSQ();
            }
        });
        this.jnG.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.kJL.cSV().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.kJz.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.kJL.cSV());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.kJL.cSV());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.cST();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.jnG.b(getPageContext());
        this.kKc = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.kKd = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.kJL.cSV().getAlaId() > 0) {
            this.kKc.setVisibility(0);
            this.kKd.setText(this.kJL.cSV().getAlaId() + "");
        }
        this.kKe = (TextView) findViewById(R.id.person_forum_age_show);
        this.kKe.setText(getResources().getString(R.string.person_forum_age_suffix, this.kJL.cSV().getForumAge()));
        this.kKf = (RelativeLayout) findViewById(R.id.person_constellation);
        this.kKf.setOnClickListener(this);
        this.kKg = (TextView) findViewById(R.id.constellation_txt);
        this.kKh = (TextView) findViewById(R.id.age_txt);
        if (this.kJL.cSV().getBirthdayTime() != 0) {
            this.kKg.setText(ar.m(new Date(this.kJL.cSV().getBirthdayTime() * 1000)));
        }
        if (this.kJL.cSV().getUserAge() > 0 && this.kJL.cSV().getBirthdayShowStatus() == 2) {
            this.kKh.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.kJL.cSV().getUserAge())));
            this.kKh.setVisibility(0);
        } else {
            this.kKh.setVisibility(8);
        }
        this.kJB.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.kJB.scrollTo(0, 0);
            }
        });
    }

    private void cSN() {
        if (NickNameActivitySwitch.isOn() || this.kJL.cSV().getNickNameLeftDays() == 0) {
            this.kJY.setVisibility(0);
        } else {
            this.kJY.setVisibility(8);
        }
    }

    public void cSO() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.kX(R.string.operation);
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
        bVar.aUO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSP() {
        int color;
        if (this.gqU.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = an.getColor(R.color.common_color_10159);
        } else {
            color = an.getColor(R.color.common_color_10077);
        }
        Cq(color);
    }

    private void Cq(int i) {
        this.kJH.setTextColor(i);
        this.kJI.setTextColor(i);
        this.kJJ.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSQ() {
        if (this.kJL != null && this.kJL.cSV() != null) {
            cSL();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.kJL.cSV().setIntro(this.gqU.getText().toString().replaceAll("\\s*", ""));
            this.kJL.cSV().setSex(this.mSex);
            if (this.kJN == null) {
                this.kJN = new b(this.kJL);
                this.kJN.setPriority(3);
                this.kJN.execute(new String[0]);
            }
        }
    }

    private void cSR() {
        if (this.kJP == null) {
            this.kJP = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.kJP.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.kJP != null && PersonChangeActivity.this.kJP.isShowing()) {
                        PersonChangeActivity.this.kJP.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.kJE.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.kJE.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.kJL.cSV().getSex()) {
                            PersonChangeActivity.this.ikn = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                an.setViewTextColor(PersonChangeActivity.this.iVr, R.color.navi_op_text, 1);
                            } else {
                                an.setViewTextColor(PersonChangeActivity.this.iVr, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.kJP.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cSL();
            this.kKi.onClick(null);
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
                        if (longExtra != this.kJL.cSV().getBirthdayTime() || intExtra != this.kJL.cSV().getBirthdayShowStatus()) {
                            this.kJL.cSV().setBirthdayShowStatus(intExtra);
                            this.kJL.cSV().setBirthdayTime(longExtra);
                            this.kJQ = true;
                            this.ikn = true;
                            Date date = new Date(longExtra * 1000);
                            this.kKg.setText(ar.m(date));
                            if (this.kJL.cSV().getBirthdayShowStatus() == 2) {
                                this.kKh.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(o(date))));
                                this.kKh.setVisibility(0);
                                return;
                            }
                            this.kKh.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ag(intent);
                            return;
                        } else {
                            Y(intent);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.kJL.cSV().setPhotoChanged(true);
                    cSS();
                    this.ikn = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        an.setViewTextColor(this.iVr, R.color.navi_op_text, 1);
                        return;
                    } else {
                        an.setViewTextColor(this.iVr, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.kJL.cSV().setPhotoChanged(true);
                    if (intent != null) {
                        this.hva.setImageBitmap(null);
                        this.hva.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.ikn = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        an.setViewTextColor(this.iVr, R.color.navi_op_text, 1);
                        return;
                    } else {
                        an.setViewTextColor(this.iVr, R.color.cp_link_tip_a, 1);
                        return;
                    }
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    am.g(getPageContext());
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

    private void KM(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.kJR = true;
            this.kJL.cSV().setPhotoChanged(true);
            this.kJL.cSV().setNameShow(str);
            this.kJL.cSV().setNickNameLeftDays(90);
            this.kJC.setText(str);
            cSN();
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

    private void ag(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, RequestResponseCode.REQUEST_CAMERA_VIEW, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void cSS() {
        if (this.kJM != null) {
            this.kJM.cancel();
        }
        this.iOz = null;
        this.kJM = new a();
        this.kJM.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cST() {
        if (this.kJL != null && this.kJL.cSV() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.kJL.cSV()));
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
            PersonChangeActivity.this.kJO.setVisibility(0);
            PersonChangeActivity.this.hva.setImageDrawable(null);
            PersonChangeActivity.this.iOz = null;
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
            PersonChangeActivity.this.kJM = null;
            PersonChangeActivity.this.kJO.setVisibility(8);
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
            PersonChangeActivity.this.kJM = null;
            PersonChangeActivity.this.kJO.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.iOz = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.iOz.drawImageTo(PersonChangeActivity.this.hva);
                com.baidu.tbadk.imageManager.c.bgz().a(PersonChangeActivity.this.kJL.cSV().getPortrait(), PersonChangeActivity.this.iOz, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSU() {
        Intent intent = new Intent();
        if (this.kJz.booleanValue()) {
            intent.putExtra("person_change_data", this.kJL.cSV());
        } else {
            intent.putExtra("data", this.kJL.cSV());
        }
        setResult(-1, intent);
        cST();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private y byb = null;
        private PersonChangeModel kJL;

        public b(PersonChangeModel personChangeModel) {
            this.kJL = null;
            this.kJL = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.kJN = null;
            if (this.byb != null) {
                this.byb.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.kJN = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.byb != null) {
                if (this.byb.aWu().aWW().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.cSU();
                } else {
                    PersonChangeActivity.this.showToast(this.byb.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.hqD);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.kJL != null) {
                this.byb = new y(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.byb.addPostData("sex", String.valueOf(this.kJL.cSV().getSex()));
                this.byb.addPostData("intro", this.kJL.cSV().getIntro());
                this.byb.addPostData("birthday_time", String.valueOf(this.kJL.cSV().getBirthdayTime()));
                this.byb.addPostData("birthday_show_status", String.valueOf(this.kJL.cSV().getBirthdayShowStatus()));
                this.byb.postMultiNetData();
                if (this.byb.aWu().aWW().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.diO();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hAx && !TextUtils.isEmpty(this.kKb)) {
            KM(this.kKb);
            this.hAx = false;
            this.kKb = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KN(String str) {
        if (!StringUtils.isNull(str)) {
            this.kJT = true;
            this.kJV.setText(str);
            this.kJU.setClickable(false);
            this.kJW.setVisibility(8);
        }
    }
}
