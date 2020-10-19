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
/* loaded from: classes24.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private com.baidu.tbadk.coreExtra.view.b eNM;
    private ImageView egR;
    private View egS;
    private View lGI;
    private View lHd;
    private TextView lHe;
    private View lHf;
    private View lHg;
    private View lHh;
    private View lHi;
    private com.baidu.tbadk.core.dialog.a lHj;
    private String lHk;
    private LinearLayout lHl;
    private TextView lHm;
    private TextView lHn;
    private RelativeLayout lHo;
    private TextView lHp;
    private TextView lHq;
    private PermissionJudgePolicy mPermissionJudgement;
    public final int lGG = 90;
    private Boolean lGH = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView jQi = null;
    private LinearLayout ieS = null;
    private ScrollView lGJ = null;
    private TextView lGK = null;
    private RelativeLayout lGL = null;
    private TextView lGM = null;
    private LinearLayout lGN = null;
    private TextView ghq = null;
    private EditText lGO = null;
    private LinearLayout lGP = null;
    private TextView lGQ = null;
    private TextView lGR = null;
    private TextView lGS = null;
    private InputMethodManager mInputManager = null;
    private boolean lGT = false;
    private PersonChangeModel lGU = null;
    protected HeadImageView ikg = null;
    private com.baidu.adp.widget.ImageView.a jIk = null;
    private a lGV = null;
    private b lGW = null;
    private ProgressBar lGX = null;
    private DialogInterface.OnCancelListener ifK = null;
    private com.baidu.tbadk.core.dialog.a kjp = null;
    private com.baidu.tbadk.core.dialog.i lGY = null;
    private boolean lGZ = false;
    private boolean jaP = false;
    private boolean lHa = false;
    private int mSex = 0;
    private final int lHb = 500;
    private boolean lHc = false;
    private boolean ipK = false;
    private final View.OnClickListener lHr = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.lGU.doZ().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.lGZ = true;
            }
            if (PersonChangeActivity.this.lGZ) {
                PersonChangeActivity.this.kjp.bkJ();
                return;
            }
            if (PersonChangeActivity.this.lGU != null && PersonChangeActivity.this.lGU.doZ().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.lGH.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.lGU.doZ());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.lGU.doZ());
                }
                PersonChangeActivity.this.doX();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener iqJ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.ipK = true;
                        PersonChangeActivity.this.lHk = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener lHs = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.lGU != null && PersonChangeActivity.this.lGU.doZ() != null && personChangeData != null) {
                    PersonChangeActivity.this.lGU.doZ().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.lGU.doZ().setMem(personChangeData.getMen());
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
        bEB();
        if (bundle != null) {
            this.lGH = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.lGH = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.iqJ);
        registerListener(this.lHs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iqJ);
        if (this.lGV != null) {
            this.lGV.cancel();
        }
        if (this.lGW != null) {
            this.lGW.cancel();
        }
        if (this.lGX != null) {
            this.lGX.setVisibility(8);
        }
        if (this.lGO != null) {
            this.lGO.addTextChangedListener(null);
        }
        if (this.eNM != null) {
            this.eNM.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ikg || view == this.lHi) {
            if (this.lGU != null && this.lGU.lHw != null && !this.lGU.lHw.canModifyAvatar()) {
                if (!StringUtils.isNull(this.lGU.lHw.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.lGU.lHw.getCantModifyAvatarDesc());
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
                doS();
            }
        } else if (view == this.lGI) {
            if (!this.jaP && !this.lHa) {
                finish();
            }
            if (this.lGH.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.jaP) {
                doU();
            } else if (this.lHa) {
                doY();
            }
        } else if (view == this.lGL) {
            doV();
        } else if (view == this.lGN) {
            doQ();
        } else if (view == this.lGO) {
            Gr(800);
        } else if (view == this.lHg) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                doO();
            } else {
                int nickNameLeftDays = this.lGU.doZ().getNickNameLeftDays();
                if (this.lGU.doZ().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.AH(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).bkJ();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.lHd) {
            if (this.lGU == null || this.lGU.doZ() == null || StringUtils.isNull(this.lGU.doZ().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.lHo) {
            PersonConstellationActivity.a(getActivity(), this.lGU.doZ().getBirthdayTime(), this.lGU.doZ().getBirthdayShowStatus());
        }
    }

    private void doO() {
        if (this.lHj == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.lHj = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.lHj.ba(inflate);
            this.lHj.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.dck(), true)));
                    aVar.dismiss();
                }
            });
            this.lHj.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.lHj.b(getPageContext());
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), R.color.cp_cont_b);
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.lHj.bkJ();
    }

    private void i(AccountData accountData) {
        if (this.eNM == null) {
            this.eNM = new com.baidu.tbadk.coreExtra.view.b(this);
            this.eNM.a(new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.PL(accountData2.getAccount());
                    }
                }
            });
        }
        this.eNM.btz();
        this.eNM.setAccountData(accountData);
        this.eNM.btv();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.lGT = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.lGT) {
            doP();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doP() {
        if (this.lGO.getVisibility() == 0) {
            String replaceAll = this.lGO.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.ghq.setText(replaceAll);
            } else {
                this.ghq.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.lGU.doZ().getIntro() == null || !this.lGU.doZ().getIntro().equals(replaceAll)) {
                this.lGZ = true;
            }
            this.lGU.doZ().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.lGO);
        }
    }

    private void doQ() {
        if (this.lGO.getVisibility() != 0) {
            this.ghq.setVisibility(8);
            this.lGO.setText(this.lGU.doZ().getIntro());
            this.lGO.setSelection(this.lGO.getText().length());
            this.lGO.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.lGO);
            Gr(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gr(int i) {
        this.lGJ.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.lGJ.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aF(Bundle bundle) {
        this.ifK = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.lGW != null) {
                    PersonChangeActivity.this.lGW.cancel();
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
        this.lGU = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.ieS);
        SvgManager.bmU().a(this.egR, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ikg.refresh();
        ap.setViewTextColor(this.lHe, R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.lGU.doZ() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.lGU.doZ()));
        }
    }

    private void bEB() {
        this.lHi = findViewById(R.id.photo_pop_icon);
        this.lHi.setOnClickListener(this);
        this.ikg = (HeadImageView) findViewById(R.id.photo);
        this.ikg.setOnClickListener(this);
        this.ikg.startLoad(q.Be(this.lGU.doZ().getPortrait()), 25, false);
        this.ieS = (LinearLayout) findViewById(R.id.parent);
        this.lGJ = (ScrollView) findViewById(R.id.person_change_scroll);
        this.lGL = (RelativeLayout) findViewById(R.id.person_sex);
        this.lGM = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.egS = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.lHr);
        this.egR = (ImageView) this.egS.findViewById(R.id.widget_navi_back_button);
        this.egR.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.lGI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.jQi = (TextView) this.lGI.findViewById(R.id.right_textview);
        this.jQi.setText(getPageContext().getString(R.string.save));
        ap.setViewTextColor(this.jQi, R.color.navi_op_text, 1);
        this.lGI.setOnClickListener(this);
        this.lGL.setOnClickListener(this);
        this.lGN = (LinearLayout) findViewById(R.id.intro_click);
        this.lGN.setOnClickListener(this);
        this.lGN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.lGT = true;
                    return false;
                }
                return false;
            }
        });
        this.lGK = (TextView) findViewById(R.id.nick_name_show);
        this.lGK.setText(this.lGU.doZ().getNameShow());
        this.lHg = findViewById(R.id.person_nickname);
        this.lHg.setOnClickListener(this);
        this.lHh = findViewById(R.id.nick_name_more);
        doR();
        this.lHe = (TextView) findViewById(R.id.user_name_show);
        this.lHd = findViewById(R.id.person_name);
        this.lHf = findViewById(R.id.user_name_more_icon);
        this.lHd.setOnClickListener(this);
        if (StringUtils.isNull(this.lGU.doZ().getName())) {
            this.lHe.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.lHc = false;
            this.lHd.setClickable(true);
            this.lHf.setVisibility(0);
        } else {
            this.lHe.setText(this.lGU.doZ().getName());
            this.lHc = true;
            this.lHd.setClickable(false);
            this.lHf.setVisibility(8);
        }
        this.lGP = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.lGQ = (TextView) findViewById(R.id.intro_text_tip_num);
        this.lGR = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.lGS = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.ghq = (TextView) findViewById(R.id.intro);
        this.ghq.setVisibility(8);
        if (this.lGU.doZ().getIntro() != null && this.lGU.doZ().getIntro().length() > 0) {
            this.ghq.setText(this.lGU.doZ().getIntro());
        } else {
            this.ghq.setText(getPageContext().getString(R.string.add_intro));
        }
        this.lGO = (EditText) findViewById(R.id.edit);
        this.lGO.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.lGO.setHintTextColor(ap.getColor(R.color.cp_cont_c));
        this.lGO.setCursorVisible(false);
        if (!at.isEmpty(this.lGU.doZ().getIntro())) {
            this.lGO.setText(this.lGU.doZ().getIntro());
            this.lGQ.setText(this.lGU.doZ().getIntro().length() + "");
        } else {
            this.lGQ.setText("0");
        }
        this.lGP.setVisibility(0);
        this.lGO.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.doP();
                }
            }
        });
        this.lGO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.lGT = true;
                    PersonChangeActivity.this.lGO.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.lGO.setOnClickListener(this);
        this.lGO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.lGO.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.lGQ.setText(String.valueOf(length));
                PersonChangeActivity.this.lGP.setVisibility(0);
                PersonChangeActivity.this.Gr(0);
                PersonChangeActivity.this.doT();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.lGO.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.lGO.getSelectionStart() - 1 > PersonChangeActivity.this.lGO.getSelectionEnd()) {
                        PersonChangeActivity.this.lGO.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.lGO.getSelectionStart() - 1, PersonChangeActivity.this.lGO.getSelectionEnd());
                        PersonChangeActivity.this.lGO.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.lGO.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.lGU.doZ().getIntro())) {
                    PersonChangeActivity.this.jaP = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(PersonChangeActivity.this.jQi, R.color.navi_op_text, 1);
                    } else {
                        ap.setViewTextColor(PersonChangeActivity.this.jQi, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.lGU.doZ().getSex() == 1) {
            this.mSex = 1;
            this.lGM.setText(R.string.male);
        } else if (this.lGU.doZ().getSex() == 2) {
            this.mSex = 2;
            this.lGM.setText(R.string.female);
        } else {
            this.lGM.setText(R.string.change_sex);
        }
        this.lGX = (ProgressBar) findViewById(R.id.image_progress);
        this.kjp = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.kjp.AH(getPageContext().getString(R.string.confirm_giveup));
        this.kjp.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.doU();
            }
        });
        this.kjp.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.lGU.doZ().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.lGH.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.lGU.doZ());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.lGU.doZ());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.doX();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.kjp.b(getPageContext());
        this.lHl = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.lHm = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.lGU.doZ().getAlaId() > 0) {
            this.lHl.setVisibility(0);
            this.lHm.setText(this.lGU.doZ().getAlaId() + "");
        }
        this.lHn = (TextView) findViewById(R.id.person_forum_age_show);
        this.lHn.setText(getResources().getString(R.string.person_forum_age_suffix, this.lGU.doZ().getForumAge()));
        this.lHo = (RelativeLayout) findViewById(R.id.person_constellation);
        this.lHo.setOnClickListener(this);
        this.lHp = (TextView) findViewById(R.id.constellation_txt);
        this.lHq = (TextView) findViewById(R.id.age_txt);
        if (this.lGU.doZ().getBirthdayTime() != 0) {
            this.lHp.setText(at.p(new Date(this.lGU.doZ().getBirthdayTime() * 1000)));
        }
        if (this.lGU.doZ().getUserAge() > 0 && this.lGU.doZ().getBirthdayShowStatus() == 2) {
            this.lHq.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.lGU.doZ().getUserAge())));
            this.lHq.setVisibility(0);
        } else {
            this.lHq.setVisibility(8);
        }
        this.lGJ.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.lGJ.scrollTo(0, 0);
            }
        });
    }

    private void doR() {
        if (NickNameActivitySwitch.isOn() || this.lGU.doZ().getNickNameLeftDays() == 0) {
            this.lHh.setVisibility(0);
        } else {
            this.lHh.setVisibility(8);
        }
    }

    public void doS() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.og(R.string.operation);
        bVar.a(strArr, new b.InterfaceC0550b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0550b
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
        bVar.bkL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doT() {
        int color;
        if (this.lGO.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = ap.getColor(R.color.common_color_10159);
        } else {
            color = ap.getColor(R.color.common_color_10077);
        }
        Gs(color);
    }

    private void Gs(int i) {
        this.lGQ.setTextColor(i);
        this.lGR.setTextColor(i);
        this.lGS.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doU() {
        if (this.lGU != null && this.lGU.doZ() != null) {
            doP();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.lGU.doZ().setIntro(this.lGO.getText().toString().replaceAll("\\s*", ""));
            this.lGU.doZ().setSex(this.mSex);
            if (this.lGW == null) {
                this.lGW = new b(this.lGU);
                this.lGW.setPriority(3);
                this.lGW.execute(new String[0]);
            }
        }
    }

    private void doV() {
        if (this.lGY == null) {
            this.lGY = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.lGY.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.lGY != null && PersonChangeActivity.this.lGY.isShowing()) {
                        PersonChangeActivity.this.lGY.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.lGM.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.lGM.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.lGU.doZ().getSex()) {
                            PersonChangeActivity.this.jaP = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                ap.setViewTextColor(PersonChangeActivity.this.jQi, R.color.navi_op_text, 1);
                            } else {
                                ap.setViewTextColor(PersonChangeActivity.this.jQi, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.lGY.Pd();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            doP();
            this.lHr.onClick(null);
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
                        if (longExtra != this.lGU.doZ().getBirthdayTime() || intExtra != this.lGU.doZ().getBirthdayShowStatus()) {
                            this.lGU.doZ().setBirthdayShowStatus(intExtra);
                            this.lGU.doZ().setBirthdayTime(longExtra);
                            this.lGZ = true;
                            this.jaP = true;
                            Date date = new Date(longExtra * 1000);
                            this.lHp.setText(at.p(date));
                            if (this.lGU.doZ().getBirthdayShowStatus() == 2) {
                                this.lHq.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(r(date))));
                                this.lHq.setVisibility(0);
                                return;
                            }
                            this.lHq.setVisibility(8);
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
                    this.lGU.doZ().setPhotoChanged(true);
                    doW();
                    this.jaP = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.jQi, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.jQi, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.lGU.doZ().setPhotoChanged(true);
                    if (intent != null) {
                        this.ikg.setImageBitmap(null);
                        this.ikg.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.jaP = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.jQi, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.jQi, R.color.cp_link_tip_a, 1);
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

    private void PK(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.lHa = true;
            this.lGU.doZ().setPhotoChanged(true);
            this.lGU.doZ().setNameShow(str);
            this.lGU.doZ().setNickNameLeftDays(90);
            this.lGK.setText(str);
            doR();
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
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_CAMERA, RequestResponseCode.REQUEST_CAMERA_VIEW, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void doW() {
        if (this.lGV != null) {
            this.lGV.cancel();
        }
        this.jIk = null;
        this.lGV = new a();
        this.lGV.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doX() {
        if (this.lGU != null && this.lGU.doZ() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.lGU.doZ()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.lGX.setVisibility(0);
            PersonChangeActivity.this.ikg.setImageDrawable(null);
            PersonChangeActivity.this.jIk = null;
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
            PersonChangeActivity.this.lGV = null;
            PersonChangeActivity.this.lGX.setVisibility(8);
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
            PersonChangeActivity.this.lGV = null;
            PersonChangeActivity.this.lGX.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.jIk = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.jIk.drawImageTo(PersonChangeActivity.this.ikg);
                com.baidu.tbadk.imageManager.c.bwL().a(PersonChangeActivity.this.lGU.doZ().getPortrait(), PersonChangeActivity.this.jIk, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doY() {
        Intent intent = new Intent();
        if (this.lGH.booleanValue()) {
            intent.putExtra("person_change_data", this.lGU.doZ());
        } else {
            intent.putExtra("data", this.lGU.doZ());
        }
        setResult(-1, intent);
        doX();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private aa bML = null;
        private PersonChangeModel lGU;

        public b(PersonChangeModel personChangeModel) {
            this.lGU = null;
            this.lGU = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.lGW = null;
            if (this.bML != null) {
                this.bML.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.lGW = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.bML != null) {
                if (this.bML.bmu().bnb().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.doY();
                } else {
                    PersonChangeActivity.this.showToast(this.bML.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.ifK);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.lGU != null) {
                this.bML = new aa(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.bML.addPostData("sex", String.valueOf(this.lGU.doZ().getSex()));
                this.bML.addPostData("intro", this.lGU.doZ().getIntro());
                this.bML.addPostData("birthday_time", String.valueOf(this.lGU.doZ().getBirthdayTime()));
                this.bML.addPostData("birthday_show_status", String.valueOf(this.lGU.doZ().getBirthdayShowStatus()));
                this.bML.postMultiNetData();
                if (this.bML.bmu().bnb().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.dFd();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.ipK && !TextUtils.isEmpty(this.lHk)) {
            PK(this.lHk);
            this.ipK = false;
            this.lHk = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PL(String str) {
        if (!StringUtils.isNull(str)) {
            this.lHc = true;
            this.lHe.setText(str);
            this.lHd.setClickable(false);
            this.lHf.setVisibility(8);
        }
    }
}
