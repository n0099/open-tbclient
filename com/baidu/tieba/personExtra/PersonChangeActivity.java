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
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import java.util.Calendar;
import java.util.Date;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes11.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private com.baidu.tbadk.coreExtra.view.c dLU;
    private ImageView dkm;
    private View dkn;
    private View jWT;
    private TextView jWU;
    private View jWV;
    private View jWW;
    private View jWX;
    private View jWY;
    private com.baidu.tbadk.core.dialog.a jWZ;
    private View jWz;
    private String jXa;
    private LinearLayout jXb;
    private TextView jXc;
    private TextView jXd;
    private RelativeLayout jXe;
    private TextView jXf;
    private TextView jXg;
    private PermissionJudgePolicy mPermissionJudgement;
    public final int jWx = 90;
    private Boolean jWy = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView ioO = null;
    private LinearLayout gOx = null;
    private ScrollView jWA = null;
    private TextView jWB = null;
    private RelativeLayout jWC = null;
    private TextView jWD = null;
    private LinearLayout jWE = null;
    private TextView fcd = null;
    private EditText fPa = null;
    private LinearLayout jWF = null;
    private TextView jWG = null;
    private TextView jWH = null;
    private TextView jWI = null;
    private InputMethodManager mInputManager = null;
    private boolean jWJ = false;
    private PersonChangeModel jWK = null;
    protected HeadImageView gTO = null;
    private com.baidu.adp.widget.ImageView.a ihS = null;
    private a jWL = null;
    private b jWM = null;
    private ProgressBar jWN = null;
    private DialogInterface.OnCancelListener gPp = null;
    private com.baidu.tbadk.core.dialog.a iGC = null;
    private com.baidu.tbadk.core.dialog.i jWO = null;
    private boolean jWP = false;
    private boolean hGn = false;
    private boolean jWQ = false;
    private int mSex = 0;
    private final int jWR = 500;
    private boolean jWS = false;
    private boolean gZb = false;
    private final View.OnClickListener jXh = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.jWK.cHr().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.jWP = true;
            }
            if (PersonChangeActivity.this.jWP) {
                PersonChangeActivity.this.iGC.aMU();
                return;
            }
            if (PersonChangeActivity.this.jWK != null && PersonChangeActivity.this.jWK.cHr().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.jWy.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.jWK.cHr());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.jWK.cHr());
                }
                PersonChangeActivity.this.cHp();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener gZM = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.gZb = true;
                        PersonChangeActivity.this.jXa = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener jXi = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.jWK != null && PersonChangeActivity.this.jWK.cHr() != null && personChangeData != null) {
                    PersonChangeActivity.this.jWK.cHr().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.jWK.cHr().setMem(personChangeData.getMen());
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
        bfR();
        if (bundle != null) {
            this.jWy = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.jWy = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.gZM);
        registerListener(this.jXi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gZM);
        if (this.jWL != null) {
            this.jWL.cancel();
        }
        if (this.jWM != null) {
            this.jWM.cancel();
        }
        if (this.jWN != null) {
            this.jWN.setVisibility(8);
        }
        if (this.fPa != null) {
            this.fPa.addTextChangedListener(null);
        }
        if (this.dLU != null) {
            this.dLU.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gTO || view == this.jWY) {
            if (this.jWK != null && this.jWK.jXm != null && !this.jWK.jXm.canModifyAvatar()) {
                if (!StringUtils.isNull(this.jWK.jXm.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.jWK.jXm.getCantModifyAvatarDesc());
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
                cHk();
            }
        } else if (view == this.jWz) {
            if (!this.hGn && !this.jWQ) {
                finish();
            }
            if (this.jWy.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.hGn) {
                cHm();
            } else if (this.jWQ) {
                cHq();
            }
        } else if (view == this.jWC) {
            cHn();
        } else if (view == this.jWE) {
            cHi();
        } else if (view == this.fPa) {
            AA(800);
        } else if (view == this.jWW) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                cHg();
            } else {
                int nickNameLeftDays = this.jWK.cHr().getNickNameLeftDays();
                if (this.jWK.cHr().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.uf(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).aMU();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.jWT) {
            if (this.jWK == null || this.jWK.cHr() == null || StringUtils.isNull(this.jWK.cHr().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.jXe) {
            PersonConstellationActivity.a(getActivity(), this.jWK.cHr().getBirthdayTime(), this.jWK.cHr().getBirthdayShowStatus());
        }
    }

    private void cHg() {
        if (this.jWZ == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.jWZ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.jWZ.aP(inflate);
            this.jWZ.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.cvd(), true)));
                    aVar.dismiss();
                }
            });
            this.jWZ.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jWZ.b(getPageContext());
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), (int) R.color.cp_cont_b);
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), (int) R.color.common_color_10122);
        }
        this.jWZ.aMU();
    }

    private void i(AccountData accountData) {
        if (this.dLU == null) {
            this.dLU = new com.baidu.tbadk.coreExtra.view.c(this);
            this.dLU.a(new c.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.Iw(accountData2.getAccount());
                    }
                }
            });
        }
        this.dLU.aVp();
        this.dLU.setAccountData(accountData);
        this.dLU.aVl();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.jWJ = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.jWJ) {
            cHh();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHh() {
        if (this.fPa.getVisibility() == 0) {
            String replaceAll = this.fPa.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.fcd.setText(replaceAll);
            } else {
                this.fcd.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.jWK.cHr().getIntro() == null || !this.jWK.cHr().getIntro().equals(replaceAll)) {
                this.jWP = true;
            }
            this.jWK.cHr().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.fPa);
        }
    }

    private void cHi() {
        if (this.fPa.getVisibility() != 0) {
            this.fcd.setVisibility(8);
            this.fPa.setText(this.jWK.cHr().getIntro());
            this.fPa.setSelection(this.fPa.getText().length());
            this.fPa.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.fPa);
            AA(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AA(int i) {
        this.jWA.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.jWA.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void ax(Bundle bundle) {
        this.gPp = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.jWM != null) {
                    PersonChangeActivity.this.jWM.cancel();
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
        this.jWK = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.gOx);
        SvgManager.aOU().a(this.dkm, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gTO.refresh();
        am.setViewTextColor(this.jWU, (int) R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.jWK.cHr() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.jWK.cHr()));
        }
    }

    private void bfR() {
        this.jWY = findViewById(R.id.photo_pop_icon);
        this.jWY.setOnClickListener(this);
        this.gTO = (HeadImageView) findViewById(R.id.photo);
        this.gTO.setOnClickListener(this);
        this.gTO.startLoad(o.uA(this.jWK.cHr().getPortrait()), 25, false);
        this.gOx = (LinearLayout) findViewById(R.id.parent);
        this.jWA = (ScrollView) findViewById(R.id.person_change_scroll);
        this.jWC = (RelativeLayout) findViewById(R.id.person_sex);
        this.jWD = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.dkn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.jXh);
        this.dkm = (ImageView) this.dkn.findViewById(R.id.widget_navi_back_button);
        this.dkm.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.jWz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.ioO = (TextView) this.jWz.findViewById(R.id.right_textview);
        this.ioO.setText(getPageContext().getString(R.string.save));
        am.setViewTextColor(this.ioO, R.color.navi_op_text, 1);
        this.jWz.setOnClickListener(this);
        this.jWC.setOnClickListener(this);
        this.jWE = (LinearLayout) findViewById(R.id.intro_click);
        this.jWE.setOnClickListener(this);
        this.jWE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.jWJ = true;
                    return false;
                }
                return false;
            }
        });
        this.jWB = (TextView) findViewById(R.id.nick_name_show);
        this.jWB.setText(this.jWK.cHr().getNameShow());
        this.jWW = findViewById(R.id.person_nickname);
        this.jWW.setOnClickListener(this);
        this.jWX = findViewById(R.id.nick_name_more);
        cHj();
        this.jWU = (TextView) findViewById(R.id.user_name_show);
        this.jWT = findViewById(R.id.person_name);
        this.jWV = findViewById(R.id.user_name_more_icon);
        this.jWT.setOnClickListener(this);
        if (StringUtils.isNull(this.jWK.cHr().getName())) {
            this.jWU.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.jWS = false;
            this.jWT.setClickable(true);
            this.jWV.setVisibility(0);
        } else {
            this.jWU.setText(this.jWK.cHr().getName());
            this.jWS = true;
            this.jWT.setClickable(false);
            this.jWV.setVisibility(8);
        }
        this.jWF = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.jWG = (TextView) findViewById(R.id.intro_text_tip_num);
        this.jWH = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.jWI = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.fcd = (TextView) findViewById(R.id.intro);
        this.fcd.setVisibility(8);
        if (this.jWK.cHr().getIntro() != null && this.jWK.cHr().getIntro().length() > 0) {
            this.fcd.setText(this.jWK.cHr().getIntro());
        } else {
            this.fcd.setText(getPageContext().getString(R.string.add_intro));
        }
        this.fPa = (EditText) findViewById(R.id.edit);
        this.fPa.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.fPa.setHintTextColor(am.getColor(R.color.cp_cont_c));
        this.fPa.setCursorVisible(false);
        if (!aq.isEmpty(this.jWK.cHr().getIntro())) {
            this.fPa.setText(this.jWK.cHr().getIntro());
            this.jWG.setText(this.jWK.cHr().getIntro().length() + "");
        } else {
            this.jWG.setText("0");
        }
        this.jWF.setVisibility(0);
        this.fPa.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.cHh();
                }
            }
        });
        this.fPa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.jWJ = true;
                    PersonChangeActivity.this.fPa.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.fPa.setOnClickListener(this);
        this.fPa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.fPa.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.jWG.setText(String.valueOf(length));
                PersonChangeActivity.this.jWF.setVisibility(0);
                PersonChangeActivity.this.AA(0);
                PersonChangeActivity.this.cHl();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.fPa.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.fPa.getSelectionStart() - 1 > PersonChangeActivity.this.fPa.getSelectionEnd()) {
                        PersonChangeActivity.this.fPa.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.fPa.getSelectionStart() - 1, PersonChangeActivity.this.fPa.getSelectionEnd());
                        PersonChangeActivity.this.fPa.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.fPa.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.jWK.cHr().getIntro())) {
                    PersonChangeActivity.this.hGn = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(PersonChangeActivity.this.ioO, R.color.navi_op_text, 1);
                    } else {
                        am.setViewTextColor(PersonChangeActivity.this.ioO, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.jWK.cHr().getSex() == 1) {
            this.mSex = 1;
            this.jWD.setText(R.string.male);
        } else if (this.jWK.cHr().getSex() == 2) {
            this.mSex = 2;
            this.jWD.setText(R.string.female);
        } else {
            this.jWD.setText(R.string.change_sex);
        }
        this.jWN = (ProgressBar) findViewById(R.id.image_progress);
        this.iGC = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.iGC.uf(getPageContext().getString(R.string.confirm_giveup));
        this.iGC.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.cHm();
            }
        });
        this.iGC.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.jWK.cHr().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.jWy.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.jWK.cHr());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.jWK.cHr());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.cHp();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.iGC.b(getPageContext());
        this.jXb = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.jXc = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.jWK.cHr().getAlaId() > 0) {
            this.jXb.setVisibility(0);
            this.jXc.setText(this.jWK.cHr().getAlaId() + "");
        }
        this.jXd = (TextView) findViewById(R.id.person_forum_age_show);
        this.jXd.setText(getResources().getString(R.string.person_forum_age_suffix, this.jWK.cHr().getForumAge()));
        this.jXe = (RelativeLayout) findViewById(R.id.person_constellation);
        this.jXe.setOnClickListener(this);
        this.jXf = (TextView) findViewById(R.id.constellation_txt);
        this.jXg = (TextView) findViewById(R.id.age_txt);
        if (this.jWK.cHr().getBirthdayTime() != 0) {
            this.jXf.setText(aq.l(new Date(this.jWK.cHr().getBirthdayTime() * 1000)));
        }
        if (this.jWK.cHr().getUserAge() > 0 && this.jWK.cHr().getBirthdayShowStatus() == 2) {
            this.jXg.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.jWK.cHr().getUserAge())));
            this.jXg.setVisibility(0);
        } else {
            this.jXg.setVisibility(8);
        }
        this.jWA.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.jWA.scrollTo(0, 0);
            }
        });
    }

    private void cHj() {
        if (NickNameActivitySwitch.isOn() || this.jWK.cHr().getNickNameLeftDays() == 0) {
            this.jWX.setVisibility(0);
        } else {
            this.jWX.setVisibility(8);
        }
    }

    public void cHk() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.kh(R.string.operation);
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
        bVar.aMV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHl() {
        int color;
        if (this.fPa.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = am.getColor(R.color.common_color_10159);
        } else {
            color = am.getColor(R.color.common_color_10077);
        }
        AB(color);
    }

    private void AB(int i) {
        this.jWG.setTextColor(i);
        this.jWH.setTextColor(i);
        this.jWI.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHm() {
        if (this.jWK != null && this.jWK.cHr() != null) {
            cHh();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.jWK.cHr().setIntro(this.fPa.getText().toString().replaceAll("\\s*", ""));
            this.jWK.cHr().setSex(this.mSex);
            if (this.jWM == null) {
                this.jWM = new b(this.jWK);
                this.jWM.setPriority(3);
                this.jWM.execute(new String[0]);
            }
        }
    }

    private void cHn() {
        if (this.jWO == null) {
            this.jWO = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.jWO.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.jWO != null && PersonChangeActivity.this.jWO.isShowing()) {
                        PersonChangeActivity.this.jWO.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.jWD.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.jWD.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.jWK.cHr().getSex()) {
                            PersonChangeActivity.this.hGn = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                am.setViewTextColor(PersonChangeActivity.this.ioO, R.color.navi_op_text, 1);
                            } else {
                                am.setViewTextColor(PersonChangeActivity.this.ioO, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.jWO.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cHh();
            this.jXh.onClick(null);
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
                        if (longExtra != this.jWK.cHr().getBirthdayTime() || intExtra != this.jWK.cHr().getBirthdayShowStatus()) {
                            this.jWK.cHr().setBirthdayShowStatus(intExtra);
                            this.jWK.cHr().setBirthdayTime(longExtra);
                            this.jWP = true;
                            this.hGn = true;
                            Date date = new Date(longExtra * 1000);
                            this.jXf.setText(aq.l(date));
                            if (this.jWK.cHr().getBirthdayShowStatus() == 2) {
                                this.jXg.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(n(date))));
                                this.jXg.setVisibility(0);
                                return;
                            }
                            this.jXg.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            au(intent);
                            return;
                        } else {
                            ao(intent);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.jWK.cHr().setPhotoChanged(true);
                    cHo();
                    this.hGn = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.ioO, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.ioO, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.jWK.cHr().setPhotoChanged(true);
                    if (intent != null) {
                        this.gTO.setImageBitmap(null);
                        this.gTO.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.hGn = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.ioO, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.ioO, R.color.cp_link_tip_a, 1);
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

    private void Iv(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jWQ = true;
            this.jWK.cHr().setPhotoChanged(true);
            this.jWK.cHr().setNameShow(str);
            this.jWK.cHr().setNickNameLeftDays(90);
            this.jWB.setText(str);
            cHj();
        }
    }

    private void ao(Intent intent) {
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

    private void au(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, RequestResponseCode.REQUEST_CAMERA_VIEW, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void cHo() {
        if (this.jWL != null) {
            this.jWL.cancel();
        }
        this.ihS = null;
        this.jWL = new a();
        this.jWL.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHp() {
        if (this.jWK != null && this.jWK.cHr() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.jWK.cHr()));
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
            PersonChangeActivity.this.jWN.setVisibility(0);
            PersonChangeActivity.this.gTO.setImageDrawable(null);
            PersonChangeActivity.this.ihS = null;
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
            PersonChangeActivity.this.jWL = null;
            PersonChangeActivity.this.jWN.setVisibility(8);
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
            PersonChangeActivity.this.jWL = null;
            PersonChangeActivity.this.jWN.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.ihS = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.ihS.drawImageTo(PersonChangeActivity.this.gTO);
                com.baidu.tbadk.imageManager.c.aYm().a(PersonChangeActivity.this.jWK.cHr().getPortrait(), PersonChangeActivity.this.ihS, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHq() {
        Intent intent = new Intent();
        if (this.jWy.booleanValue()) {
            intent.putExtra("person_change_data", this.jWK.cHr());
        } else {
            intent.putExtra("data", this.jWK.cHr());
        }
        setResult(-1, intent);
        cHp();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private x blF = null;
        private PersonChangeModel jWK;

        public b(PersonChangeModel personChangeModel) {
            this.jWK = null;
            this.jWK = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.jWM = null;
            if (this.blF != null) {
                this.blF.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.jWM = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.blF != null) {
                if (this.blF.aOy().aPa().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.cHq();
                } else {
                    PersonChangeActivity.this.showToast(this.blF.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.gPp);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.jWK != null) {
                this.blF = new x(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.blF.addPostData("sex", String.valueOf(this.jWK.cHr().getSex()));
                this.blF.addPostData("intro", this.jWK.cHr().getIntro());
                this.blF.addPostData("birthday_time", String.valueOf(this.jWK.cHr().getBirthdayTime()));
                this.blF.addPostData("birthday_show_status", String.valueOf(this.jWK.cHr().getBirthdayShowStatus()));
                this.blF.postMultiNetData();
                if (this.blF.aOy().aPa().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.cXi();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gZb && !TextUtils.isEmpty(this.jXa)) {
            Iv(this.jXa);
            this.gZb = false;
            this.jXa = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iw(String str) {
        if (!StringUtils.isNull(str)) {
            this.jWS = true;
            this.jWU.setText(str);
            this.jWT.setClickable(false);
            this.jWV.setVisibility(8);
        }
    }
}
