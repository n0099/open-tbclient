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
    private com.baidu.tbadk.coreExtra.view.c dLY;
    private ImageView dkq;
    private View dkr;
    private View jWD;
    private View jWX;
    private TextView jWY;
    private View jWZ;
    private View jXa;
    private View jXb;
    private View jXc;
    private com.baidu.tbadk.core.dialog.a jXd;
    private String jXe;
    private LinearLayout jXf;
    private TextView jXg;
    private TextView jXh;
    private RelativeLayout jXi;
    private TextView jXj;
    private TextView jXk;
    private PermissionJudgePolicy mPermissionJudgement;
    public final int jWB = 90;
    private Boolean jWC = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView ioU = null;
    private LinearLayout gOD = null;
    private ScrollView jWE = null;
    private TextView jWF = null;
    private RelativeLayout jWG = null;
    private TextView jWH = null;
    private LinearLayout jWI = null;
    private TextView fci = null;
    private EditText fPf = null;
    private LinearLayout jWJ = null;
    private TextView jWK = null;
    private TextView jWL = null;
    private TextView jWM = null;
    private InputMethodManager mInputManager = null;
    private boolean jWN = false;
    private PersonChangeModel jWO = null;
    protected HeadImageView gTU = null;
    private com.baidu.adp.widget.ImageView.a ihY = null;
    private a jWP = null;
    private b jWQ = null;
    private ProgressBar jWR = null;
    private DialogInterface.OnCancelListener gPv = null;
    private com.baidu.tbadk.core.dialog.a iGI = null;
    private com.baidu.tbadk.core.dialog.i jWS = null;
    private boolean jWT = false;
    private boolean hGt = false;
    private boolean jWU = false;
    private int mSex = 0;
    private final int jWV = 500;
    private boolean jWW = false;
    private boolean gZh = false;
    private final View.OnClickListener jXl = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.jWO.cHp().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.jWT = true;
            }
            if (PersonChangeActivity.this.jWT) {
                PersonChangeActivity.this.iGI.aMS();
                return;
            }
            if (PersonChangeActivity.this.jWO != null && PersonChangeActivity.this.jWO.cHp().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.jWC.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.jWO.cHp());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.jWO.cHp());
                }
                PersonChangeActivity.this.cHn();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener gZS = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.gZh = true;
                        PersonChangeActivity.this.jXe = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener jXm = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.jWO != null && PersonChangeActivity.this.jWO.cHp() != null && personChangeData != null) {
                    PersonChangeActivity.this.jWO.cHp().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.jWO.cHp().setMem(personChangeData.getMen());
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
        bfP();
        if (bundle != null) {
            this.jWC = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.jWC = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.gZS);
        registerListener(this.jXm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gZS);
        if (this.jWP != null) {
            this.jWP.cancel();
        }
        if (this.jWQ != null) {
            this.jWQ.cancel();
        }
        if (this.jWR != null) {
            this.jWR.setVisibility(8);
        }
        if (this.fPf != null) {
            this.fPf.addTextChangedListener(null);
        }
        if (this.dLY != null) {
            this.dLY.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gTU || view == this.jXc) {
            if (this.jWO != null && this.jWO.jXq != null && !this.jWO.jXq.canModifyAvatar()) {
                if (!StringUtils.isNull(this.jWO.jXq.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.jWO.jXq.getCantModifyAvatarDesc());
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
                cHi();
            }
        } else if (view == this.jWD) {
            if (!this.hGt && !this.jWU) {
                finish();
            }
            if (this.jWC.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.hGt) {
                cHk();
            } else if (this.jWU) {
                cHo();
            }
        } else if (view == this.jWG) {
            cHl();
        } else if (view == this.jWI) {
            cHg();
        } else if (view == this.fPf) {
            AA(800);
        } else if (view == this.jXa) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                cHe();
            } else {
                int nickNameLeftDays = this.jWO.cHp().getNickNameLeftDays();
                if (this.jWO.cHp().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.ui(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).aMS();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.jWX) {
            if (this.jWO == null || this.jWO.cHp() == null || StringUtils.isNull(this.jWO.cHp().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.jXi) {
            PersonConstellationActivity.a(getActivity(), this.jWO.cHp().getBirthdayTime(), this.jWO.cHp().getBirthdayShowStatus());
        }
    }

    private void cHe() {
        if (this.jXd == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.jXd = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.jXd.aP(inflate);
            this.jXd.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.cvb(), true)));
                    aVar.dismiss();
                }
            });
            this.jXd.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jXd.b(getPageContext());
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), (int) R.color.cp_cont_b);
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), (int) R.color.common_color_10122);
        }
        this.jXd.aMS();
    }

    private void i(AccountData accountData) {
        if (this.dLY == null) {
            this.dLY = new com.baidu.tbadk.coreExtra.view.c(this);
            this.dLY.a(new c.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.Iz(accountData2.getAccount());
                    }
                }
            });
        }
        this.dLY.aVn();
        this.dLY.setAccountData(accountData);
        this.dLY.aVj();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.jWN = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.jWN) {
            cHf();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHf() {
        if (this.fPf.getVisibility() == 0) {
            String replaceAll = this.fPf.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.fci.setText(replaceAll);
            } else {
                this.fci.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.jWO.cHp().getIntro() == null || !this.jWO.cHp().getIntro().equals(replaceAll)) {
                this.jWT = true;
            }
            this.jWO.cHp().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.fPf);
        }
    }

    private void cHg() {
        if (this.fPf.getVisibility() != 0) {
            this.fci.setVisibility(8);
            this.fPf.setText(this.jWO.cHp().getIntro());
            this.fPf.setSelection(this.fPf.getText().length());
            this.fPf.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.fPf);
            AA(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AA(int i) {
        this.jWE.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.jWE.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void ax(Bundle bundle) {
        this.gPv = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.jWQ != null) {
                    PersonChangeActivity.this.jWQ.cancel();
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
        this.jWO = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.gOD);
        SvgManager.aOR().a(this.dkq, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gTU.refresh();
        am.setViewTextColor(this.jWY, (int) R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.jWO.cHp() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.jWO.cHp()));
        }
    }

    private void bfP() {
        this.jXc = findViewById(R.id.photo_pop_icon);
        this.jXc.setOnClickListener(this);
        this.gTU = (HeadImageView) findViewById(R.id.photo);
        this.gTU.setOnClickListener(this);
        this.gTU.startLoad(o.uD(this.jWO.cHp().getPortrait()), 25, false);
        this.gOD = (LinearLayout) findViewById(R.id.parent);
        this.jWE = (ScrollView) findViewById(R.id.person_change_scroll);
        this.jWG = (RelativeLayout) findViewById(R.id.person_sex);
        this.jWH = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.dkr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.jXl);
        this.dkq = (ImageView) this.dkr.findViewById(R.id.widget_navi_back_button);
        this.dkq.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.jWD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.ioU = (TextView) this.jWD.findViewById(R.id.right_textview);
        this.ioU.setText(getPageContext().getString(R.string.save));
        am.setViewTextColor(this.ioU, R.color.navi_op_text, 1);
        this.jWD.setOnClickListener(this);
        this.jWG.setOnClickListener(this);
        this.jWI = (LinearLayout) findViewById(R.id.intro_click);
        this.jWI.setOnClickListener(this);
        this.jWI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.jWN = true;
                    return false;
                }
                return false;
            }
        });
        this.jWF = (TextView) findViewById(R.id.nick_name_show);
        this.jWF.setText(this.jWO.cHp().getNameShow());
        this.jXa = findViewById(R.id.person_nickname);
        this.jXa.setOnClickListener(this);
        this.jXb = findViewById(R.id.nick_name_more);
        cHh();
        this.jWY = (TextView) findViewById(R.id.user_name_show);
        this.jWX = findViewById(R.id.person_name);
        this.jWZ = findViewById(R.id.user_name_more_icon);
        this.jWX.setOnClickListener(this);
        if (StringUtils.isNull(this.jWO.cHp().getName())) {
            this.jWY.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.jWW = false;
            this.jWX.setClickable(true);
            this.jWZ.setVisibility(0);
        } else {
            this.jWY.setText(this.jWO.cHp().getName());
            this.jWW = true;
            this.jWX.setClickable(false);
            this.jWZ.setVisibility(8);
        }
        this.jWJ = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.jWK = (TextView) findViewById(R.id.intro_text_tip_num);
        this.jWL = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.jWM = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.fci = (TextView) findViewById(R.id.intro);
        this.fci.setVisibility(8);
        if (this.jWO.cHp().getIntro() != null && this.jWO.cHp().getIntro().length() > 0) {
            this.fci.setText(this.jWO.cHp().getIntro());
        } else {
            this.fci.setText(getPageContext().getString(R.string.add_intro));
        }
        this.fPf = (EditText) findViewById(R.id.edit);
        this.fPf.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.fPf.setHintTextColor(am.getColor(R.color.cp_cont_c));
        this.fPf.setCursorVisible(false);
        if (!aq.isEmpty(this.jWO.cHp().getIntro())) {
            this.fPf.setText(this.jWO.cHp().getIntro());
            this.jWK.setText(this.jWO.cHp().getIntro().length() + "");
        } else {
            this.jWK.setText("0");
        }
        this.jWJ.setVisibility(0);
        this.fPf.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.cHf();
                }
            }
        });
        this.fPf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.jWN = true;
                    PersonChangeActivity.this.fPf.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.fPf.setOnClickListener(this);
        this.fPf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.fPf.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.jWK.setText(String.valueOf(length));
                PersonChangeActivity.this.jWJ.setVisibility(0);
                PersonChangeActivity.this.AA(0);
                PersonChangeActivity.this.cHj();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.fPf.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.fPf.getSelectionStart() - 1 > PersonChangeActivity.this.fPf.getSelectionEnd()) {
                        PersonChangeActivity.this.fPf.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.fPf.getSelectionStart() - 1, PersonChangeActivity.this.fPf.getSelectionEnd());
                        PersonChangeActivity.this.fPf.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.fPf.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.jWO.cHp().getIntro())) {
                    PersonChangeActivity.this.hGt = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(PersonChangeActivity.this.ioU, R.color.navi_op_text, 1);
                    } else {
                        am.setViewTextColor(PersonChangeActivity.this.ioU, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.jWO.cHp().getSex() == 1) {
            this.mSex = 1;
            this.jWH.setText(R.string.male);
        } else if (this.jWO.cHp().getSex() == 2) {
            this.mSex = 2;
            this.jWH.setText(R.string.female);
        } else {
            this.jWH.setText(R.string.change_sex);
        }
        this.jWR = (ProgressBar) findViewById(R.id.image_progress);
        this.iGI = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.iGI.ui(getPageContext().getString(R.string.confirm_giveup));
        this.iGI.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.cHk();
            }
        });
        this.iGI.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.jWO.cHp().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.jWC.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.jWO.cHp());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.jWO.cHp());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.cHn();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.iGI.b(getPageContext());
        this.jXf = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.jXg = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.jWO.cHp().getAlaId() > 0) {
            this.jXf.setVisibility(0);
            this.jXg.setText(this.jWO.cHp().getAlaId() + "");
        }
        this.jXh = (TextView) findViewById(R.id.person_forum_age_show);
        this.jXh.setText(getResources().getString(R.string.person_forum_age_suffix, this.jWO.cHp().getForumAge()));
        this.jXi = (RelativeLayout) findViewById(R.id.person_constellation);
        this.jXi.setOnClickListener(this);
        this.jXj = (TextView) findViewById(R.id.constellation_txt);
        this.jXk = (TextView) findViewById(R.id.age_txt);
        if (this.jWO.cHp().getBirthdayTime() != 0) {
            this.jXj.setText(aq.l(new Date(this.jWO.cHp().getBirthdayTime() * 1000)));
        }
        if (this.jWO.cHp().getUserAge() > 0 && this.jWO.cHp().getBirthdayShowStatus() == 2) {
            this.jXk.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.jWO.cHp().getUserAge())));
            this.jXk.setVisibility(0);
        } else {
            this.jXk.setVisibility(8);
        }
        this.jWE.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.jWE.scrollTo(0, 0);
            }
        });
    }

    private void cHh() {
        if (NickNameActivitySwitch.isOn() || this.jWO.cHp().getNickNameLeftDays() == 0) {
            this.jXb.setVisibility(0);
        } else {
            this.jXb.setVisibility(8);
        }
    }

    public void cHi() {
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
        bVar.aMT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHj() {
        int color;
        if (this.fPf.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = am.getColor(R.color.common_color_10159);
        } else {
            color = am.getColor(R.color.common_color_10077);
        }
        AB(color);
    }

    private void AB(int i) {
        this.jWK.setTextColor(i);
        this.jWL.setTextColor(i);
        this.jWM.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHk() {
        if (this.jWO != null && this.jWO.cHp() != null) {
            cHf();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.jWO.cHp().setIntro(this.fPf.getText().toString().replaceAll("\\s*", ""));
            this.jWO.cHp().setSex(this.mSex);
            if (this.jWQ == null) {
                this.jWQ = new b(this.jWO);
                this.jWQ.setPriority(3);
                this.jWQ.execute(new String[0]);
            }
        }
    }

    private void cHl() {
        if (this.jWS == null) {
            this.jWS = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.jWS.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.jWS != null && PersonChangeActivity.this.jWS.isShowing()) {
                        PersonChangeActivity.this.jWS.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.jWH.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.jWH.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.jWO.cHp().getSex()) {
                            PersonChangeActivity.this.hGt = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                am.setViewTextColor(PersonChangeActivity.this.ioU, R.color.navi_op_text, 1);
                            } else {
                                am.setViewTextColor(PersonChangeActivity.this.ioU, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.jWS.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cHf();
            this.jXl.onClick(null);
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
                        if (longExtra != this.jWO.cHp().getBirthdayTime() || intExtra != this.jWO.cHp().getBirthdayShowStatus()) {
                            this.jWO.cHp().setBirthdayShowStatus(intExtra);
                            this.jWO.cHp().setBirthdayTime(longExtra);
                            this.jWT = true;
                            this.hGt = true;
                            Date date = new Date(longExtra * 1000);
                            this.jXj.setText(aq.l(date));
                            if (this.jWO.cHp().getBirthdayShowStatus() == 2) {
                                this.jXk.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(n(date))));
                                this.jXk.setVisibility(0);
                                return;
                            }
                            this.jXk.setVisibility(8);
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
                            ab(intent);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.jWO.cHp().setPhotoChanged(true);
                    cHm();
                    this.hGt = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.ioU, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.ioU, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.jWO.cHp().setPhotoChanged(true);
                    if (intent != null) {
                        this.gTU.setImageBitmap(null);
                        this.gTU.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.hGt = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.ioU, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.ioU, R.color.cp_link_tip_a, 1);
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

    private void Iy(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jWU = true;
            this.jWO.cHp().setPhotoChanged(true);
            this.jWO.cHp().setNameShow(str);
            this.jWO.cHp().setNickNameLeftDays(90);
            this.jWF.setText(str);
            cHh();
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

    private void ah(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, RequestResponseCode.REQUEST_CAMERA_VIEW, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void cHm() {
        if (this.jWP != null) {
            this.jWP.cancel();
        }
        this.ihY = null;
        this.jWP = new a();
        this.jWP.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHn() {
        if (this.jWO != null && this.jWO.cHp() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.jWO.cHp()));
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
            PersonChangeActivity.this.jWR.setVisibility(0);
            PersonChangeActivity.this.gTU.setImageDrawable(null);
            PersonChangeActivity.this.ihY = null;
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
            PersonChangeActivity.this.jWP = null;
            PersonChangeActivity.this.jWR.setVisibility(8);
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
            PersonChangeActivity.this.jWP = null;
            PersonChangeActivity.this.jWR.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.ihY = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.ihY.drawImageTo(PersonChangeActivity.this.gTU);
                com.baidu.tbadk.imageManager.c.aYk().a(PersonChangeActivity.this.jWO.cHp().getPortrait(), PersonChangeActivity.this.ihY, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHo() {
        Intent intent = new Intent();
        if (this.jWC.booleanValue()) {
            intent.putExtra("person_change_data", this.jWO.cHp());
        } else {
            intent.putExtra("data", this.jWO.cHp());
        }
        setResult(-1, intent);
        cHn();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private x blK = null;
        private PersonChangeModel jWO;

        public b(PersonChangeModel personChangeModel) {
            this.jWO = null;
            this.jWO = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.jWQ = null;
            if (this.blK != null) {
                this.blK.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.jWQ = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.blK != null) {
                if (this.blK.aOw().aOX().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.cHo();
                } else {
                    PersonChangeActivity.this.showToast(this.blK.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.gPv);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.jWO != null) {
                this.blK = new x(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.blK.addPostData("sex", String.valueOf(this.jWO.cHp().getSex()));
                this.blK.addPostData("intro", this.jWO.cHp().getIntro());
                this.blK.addPostData("birthday_time", String.valueOf(this.jWO.cHp().getBirthdayTime()));
                this.blK.addPostData("birthday_show_status", String.valueOf(this.jWO.cHp().getBirthdayShowStatus()));
                this.blK.postMultiNetData();
                if (this.blK.aOw().aOX().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.cXg();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gZh && !TextUtils.isEmpty(this.jXe)) {
            Iy(this.jXe);
            this.gZh = false;
            this.jXe = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iz(String str) {
        if (!StringUtils.isNull(str)) {
            this.jWW = true;
            this.jWY.setText(str);
            this.jWX.setClickable(false);
            this.jWZ.setVisibility(8);
        }
    }
}
