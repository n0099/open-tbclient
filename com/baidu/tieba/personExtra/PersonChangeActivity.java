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
    private View koQ;
    private TextView koR;
    private View koS;
    private View koT;
    private View koU;
    private View koV;
    private com.baidu.tbadk.core.dialog.a koW;
    private String koX;
    private LinearLayout koY;
    private TextView koZ;
    private View kow;
    private TextView kpa;
    private RelativeLayout kpb;
    private TextView kpc;
    private TextView kpd;
    private PermissionJudgePolicy mPermissionJudgement;
    public final int kou = 90;
    private Boolean kov = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView iDA = null;
    private LinearLayout hdp = null;
    private ScrollView kox = null;
    private TextView koy = null;
    private RelativeLayout koz = null;
    private TextView koA = null;
    private LinearLayout koB = null;
    private TextView fpL = null;
    private EditText gdP = null;
    private LinearLayout koC = null;
    private TextView koD = null;
    private TextView koE = null;
    private TextView koF = null;
    private InputMethodManager mInputManager = null;
    private boolean koG = false;
    private PersonChangeModel koH = null;
    protected HeadImageView hiG = null;
    private com.baidu.adp.widget.ImageView.a iwH = null;
    private a koI = null;
    private b koJ = null;
    private ProgressBar koK = null;
    private DialogInterface.OnCancelListener heh = null;
    private com.baidu.tbadk.core.dialog.a iVG = null;
    private com.baidu.tbadk.core.dialog.i koL = null;
    private boolean koM = false;
    private boolean hVf = false;
    private boolean koN = false;
    private int mSex = 0;
    private final int koO = 500;
    private boolean koP = false;
    private boolean hnT = false;
    private final View.OnClickListener kpe = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.koH.cOo().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.koM = true;
            }
            if (PersonChangeActivity.this.koM) {
                PersonChangeActivity.this.iVG.aST();
                return;
            }
            if (PersonChangeActivity.this.koH != null && PersonChangeActivity.this.koH.cOo().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.kov.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.koH.cOo());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.koH.cOo());
                }
                PersonChangeActivity.this.cOm();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener hoG = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.hnT = true;
                        PersonChangeActivity.this.koX = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener kpf = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.koH != null && PersonChangeActivity.this.koH.cOo() != null && personChangeData != null) {
                    PersonChangeActivity.this.koH.cOo().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.koH.cOo().setMem(personChangeData.getMen());
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
        bmb();
        if (bundle != null) {
            this.kov = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.kov = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.hoG);
        registerListener(this.kpf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hoG);
        if (this.koI != null) {
            this.koI.cancel();
        }
        if (this.koJ != null) {
            this.koJ.cancel();
        }
        if (this.koK != null) {
            this.koK.setVisibility(8);
        }
        if (this.gdP != null) {
            this.gdP.addTextChangedListener(null);
        }
        if (this.eap != null) {
            this.eap.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hiG || view == this.koV) {
            if (this.koH != null && this.koH.kpj != null && !this.koH.kpj.canModifyAvatar()) {
                if (!StringUtils.isNull(this.koH.kpj.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.koH.kpj.getCantModifyAvatarDesc());
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
                cOh();
            }
        } else if (view == this.kow) {
            if (!this.hVf && !this.koN) {
                finish();
            }
            if (this.kov.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.hVf) {
                cOj();
            } else if (this.koN) {
                cOn();
            }
        } else if (view == this.koz) {
            cOk();
        } else if (view == this.koB) {
            cOf();
        } else if (view == this.gdP) {
            Bl(800);
        } else if (view == this.koT) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                cOd();
            } else {
                int nickNameLeftDays = this.koH.cOo().getNickNameLeftDays();
                if (this.koH.cOo().getMen() <= 0) {
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
        } else if (view == this.koQ) {
            if (this.koH == null || this.koH.cOo() == null || StringUtils.isNull(this.koH.cOo().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.kpb) {
            PersonConstellationActivity.a(getActivity(), this.koH.cOo().getBirthdayTime(), this.koH.cOo().getBirthdayShowStatus());
        }
    }

    private void cOd() {
        if (this.koW == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.koW = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.koW.aP(inflate);
            this.koW.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.cBR(), true)));
                    aVar.dismiss();
                }
            });
            this.koW.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.koW.b(getPageContext());
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), (int) R.color.cp_cont_b);
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), (int) R.color.common_color_10122);
        }
        this.koW.aST();
    }

    private void i(AccountData accountData) {
        if (this.eap == null) {
            this.eap = new com.baidu.tbadk.coreExtra.view.b(this);
            this.eap.a(new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.Kl(accountData2.getAccount());
                    }
                }
            });
        }
        this.eap.bbw();
        this.eap.setAccountData(accountData);
        this.eap.bbs();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.koG = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.koG) {
            cOe();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOe() {
        if (this.gdP.getVisibility() == 0) {
            String replaceAll = this.gdP.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.fpL.setText(replaceAll);
            } else {
                this.fpL.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.koH.cOo().getIntro() == null || !this.koH.cOo().getIntro().equals(replaceAll)) {
                this.koM = true;
            }
            this.koH.cOo().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.gdP);
        }
    }

    private void cOf() {
        if (this.gdP.getVisibility() != 0) {
            this.fpL.setVisibility(8);
            this.gdP.setText(this.koH.cOo().getIntro());
            this.gdP.setSelection(this.gdP.getText().length());
            this.gdP.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.gdP);
            Bl(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bl(int i) {
        this.kox.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.kox.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aD(Bundle bundle) {
        this.heh = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.koJ != null) {
                    PersonChangeActivity.this.koJ.cancel();
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
        this.koH = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.hdp);
        SvgManager.aUV().a(this.dyq, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.hiG.refresh();
        am.setViewTextColor(this.koR, (int) R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.koH.cOo() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.koH.cOo()));
        }
    }

    private void bmb() {
        this.koV = findViewById(R.id.photo_pop_icon);
        this.koV.setOnClickListener(this);
        this.hiG = (HeadImageView) findViewById(R.id.photo);
        this.hiG.setOnClickListener(this);
        this.hiG.startLoad(o.wj(this.koH.cOo().getPortrait()), 25, false);
        this.hdp = (LinearLayout) findViewById(R.id.parent);
        this.kox = (ScrollView) findViewById(R.id.person_change_scroll);
        this.koz = (RelativeLayout) findViewById(R.id.person_sex);
        this.koA = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.dyr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.kpe);
        this.dyq = (ImageView) this.dyr.findViewById(R.id.widget_navi_back_button);
        this.dyq.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.kow = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.iDA = (TextView) this.kow.findViewById(R.id.right_textview);
        this.iDA.setText(getPageContext().getString(R.string.save));
        am.setViewTextColor(this.iDA, R.color.navi_op_text, 1);
        this.kow.setOnClickListener(this);
        this.koz.setOnClickListener(this);
        this.koB = (LinearLayout) findViewById(R.id.intro_click);
        this.koB.setOnClickListener(this);
        this.koB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.koG = true;
                    return false;
                }
                return false;
            }
        });
        this.koy = (TextView) findViewById(R.id.nick_name_show);
        this.koy.setText(this.koH.cOo().getNameShow());
        this.koT = findViewById(R.id.person_nickname);
        this.koT.setOnClickListener(this);
        this.koU = findViewById(R.id.nick_name_more);
        cOg();
        this.koR = (TextView) findViewById(R.id.user_name_show);
        this.koQ = findViewById(R.id.person_name);
        this.koS = findViewById(R.id.user_name_more_icon);
        this.koQ.setOnClickListener(this);
        if (StringUtils.isNull(this.koH.cOo().getName())) {
            this.koR.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.koP = false;
            this.koQ.setClickable(true);
            this.koS.setVisibility(0);
        } else {
            this.koR.setText(this.koH.cOo().getName());
            this.koP = true;
            this.koQ.setClickable(false);
            this.koS.setVisibility(8);
        }
        this.koC = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.koD = (TextView) findViewById(R.id.intro_text_tip_num);
        this.koE = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.koF = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.fpL = (TextView) findViewById(R.id.intro);
        this.fpL.setVisibility(8);
        if (this.koH.cOo().getIntro() != null && this.koH.cOo().getIntro().length() > 0) {
            this.fpL.setText(this.koH.cOo().getIntro());
        } else {
            this.fpL.setText(getPageContext().getString(R.string.add_intro));
        }
        this.gdP = (EditText) findViewById(R.id.edit);
        this.gdP.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.gdP.setHintTextColor(am.getColor(R.color.cp_cont_c));
        this.gdP.setCursorVisible(false);
        if (!aq.isEmpty(this.koH.cOo().getIntro())) {
            this.gdP.setText(this.koH.cOo().getIntro());
            this.koD.setText(this.koH.cOo().getIntro().length() + "");
        } else {
            this.koD.setText("0");
        }
        this.koC.setVisibility(0);
        this.gdP.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.cOe();
                }
            }
        });
        this.gdP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.koG = true;
                    PersonChangeActivity.this.gdP.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.gdP.setOnClickListener(this);
        this.gdP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.gdP.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.koD.setText(String.valueOf(length));
                PersonChangeActivity.this.koC.setVisibility(0);
                PersonChangeActivity.this.Bl(0);
                PersonChangeActivity.this.cOi();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.gdP.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.gdP.getSelectionStart() - 1 > PersonChangeActivity.this.gdP.getSelectionEnd()) {
                        PersonChangeActivity.this.gdP.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.gdP.getSelectionStart() - 1, PersonChangeActivity.this.gdP.getSelectionEnd());
                        PersonChangeActivity.this.gdP.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.gdP.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.koH.cOo().getIntro())) {
                    PersonChangeActivity.this.hVf = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(PersonChangeActivity.this.iDA, R.color.navi_op_text, 1);
                    } else {
                        am.setViewTextColor(PersonChangeActivity.this.iDA, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.koH.cOo().getSex() == 1) {
            this.mSex = 1;
            this.koA.setText(R.string.male);
        } else if (this.koH.cOo().getSex() == 2) {
            this.mSex = 2;
            this.koA.setText(R.string.female);
        } else {
            this.koA.setText(R.string.change_sex);
        }
        this.koK = (ProgressBar) findViewById(R.id.image_progress);
        this.iVG = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.iVG.vO(getPageContext().getString(R.string.confirm_giveup));
        this.iVG.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.cOj();
            }
        });
        this.iVG.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.koH.cOo().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.kov.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.koH.cOo());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.koH.cOo());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.cOm();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.iVG.b(getPageContext());
        this.koY = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.koZ = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.koH.cOo().getAlaId() > 0) {
            this.koY.setVisibility(0);
            this.koZ.setText(this.koH.cOo().getAlaId() + "");
        }
        this.kpa = (TextView) findViewById(R.id.person_forum_age_show);
        this.kpa.setText(getResources().getString(R.string.person_forum_age_suffix, this.koH.cOo().getForumAge()));
        this.kpb = (RelativeLayout) findViewById(R.id.person_constellation);
        this.kpb.setOnClickListener(this);
        this.kpc = (TextView) findViewById(R.id.constellation_txt);
        this.kpd = (TextView) findViewById(R.id.age_txt);
        if (this.koH.cOo().getBirthdayTime() != 0) {
            this.kpc.setText(aq.m(new Date(this.koH.cOo().getBirthdayTime() * 1000)));
        }
        if (this.koH.cOo().getUserAge() > 0 && this.koH.cOo().getBirthdayShowStatus() == 2) {
            this.kpd.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.koH.cOo().getUserAge())));
            this.kpd.setVisibility(0);
        } else {
            this.kpd.setVisibility(8);
        }
        this.kox.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.kox.scrollTo(0, 0);
            }
        });
    }

    private void cOg() {
        if (NickNameActivitySwitch.isOn() || this.koH.cOo().getNickNameLeftDays() == 0) {
            this.koU.setVisibility(0);
        } else {
            this.koU.setVisibility(8);
        }
    }

    public void cOh() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.kH(R.string.operation);
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
    public void cOi() {
        int color;
        if (this.gdP.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = am.getColor(R.color.common_color_10159);
        } else {
            color = am.getColor(R.color.common_color_10077);
        }
        Bm(color);
    }

    private void Bm(int i) {
        this.koD.setTextColor(i);
        this.koE.setTextColor(i);
        this.koF.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOj() {
        if (this.koH != null && this.koH.cOo() != null) {
            cOe();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.koH.cOo().setIntro(this.gdP.getText().toString().replaceAll("\\s*", ""));
            this.koH.cOo().setSex(this.mSex);
            if (this.koJ == null) {
                this.koJ = new b(this.koH);
                this.koJ.setPriority(3);
                this.koJ.execute(new String[0]);
            }
        }
    }

    private void cOk() {
        if (this.koL == null) {
            this.koL = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.koL.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.koL != null && PersonChangeActivity.this.koL.isShowing()) {
                        PersonChangeActivity.this.koL.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.koA.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.koA.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.koH.cOo().getSex()) {
                            PersonChangeActivity.this.hVf = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                am.setViewTextColor(PersonChangeActivity.this.iDA, R.color.navi_op_text, 1);
                            } else {
                                am.setViewTextColor(PersonChangeActivity.this.iDA, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.koL.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cOe();
            this.kpe.onClick(null);
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
                        if (longExtra != this.koH.cOo().getBirthdayTime() || intExtra != this.koH.cOo().getBirthdayShowStatus()) {
                            this.koH.cOo().setBirthdayShowStatus(intExtra);
                            this.koH.cOo().setBirthdayTime(longExtra);
                            this.koM = true;
                            this.hVf = true;
                            Date date = new Date(longExtra * 1000);
                            this.kpc.setText(aq.m(date));
                            if (this.koH.cOo().getBirthdayShowStatus() == 2) {
                                this.kpd.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(o(date))));
                                this.kpd.setVisibility(0);
                                return;
                            }
                            this.kpd.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ae(intent);
                            return;
                        } else {
                            Y(intent);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.koH.cOo().setPhotoChanged(true);
                    cOl();
                    this.hVf = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.iDA, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.iDA, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.koH.cOo().setPhotoChanged(true);
                    if (intent != null) {
                        this.hiG.setImageBitmap(null);
                        this.hiG.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.hVf = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.iDA, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.iDA, R.color.cp_link_tip_a, 1);
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

    private void Kk(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.koN = true;
            this.koH.cOo().setPhotoChanged(true);
            this.koH.cOo().setNameShow(str);
            this.koH.cOo().setNickNameLeftDays(90);
            this.koy.setText(str);
            cOg();
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

    private void ae(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, RequestResponseCode.REQUEST_CAMERA_VIEW, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void cOl() {
        if (this.koI != null) {
            this.koI.cancel();
        }
        this.iwH = null;
        this.koI = new a();
        this.koI.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOm() {
        if (this.koH != null && this.koH.cOo() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.koH.cOo()));
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
            PersonChangeActivity.this.koK.setVisibility(0);
            PersonChangeActivity.this.hiG.setImageDrawable(null);
            PersonChangeActivity.this.iwH = null;
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
            PersonChangeActivity.this.koI = null;
            PersonChangeActivity.this.koK.setVisibility(8);
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
            PersonChangeActivity.this.koI = null;
            PersonChangeActivity.this.koK.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.iwH = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.iwH.drawImageTo(PersonChangeActivity.this.hiG);
                com.baidu.tbadk.imageManager.c.bet().a(PersonChangeActivity.this.koH.cOo().getPortrait(), PersonChangeActivity.this.iwH, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOn() {
        Intent intent = new Intent();
        if (this.kov.booleanValue()) {
            intent.putExtra("person_change_data", this.koH.cOo());
        } else {
            intent.putExtra("data", this.koH.cOo());
        }
        setResult(-1, intent);
        cOm();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private x bth = null;
        private PersonChangeModel koH;

        public b(PersonChangeModel personChangeModel) {
            this.koH = null;
            this.koH = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.koJ = null;
            if (this.bth != null) {
                this.bth.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.koJ = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.bth != null) {
                if (this.bth.aUA().aVb().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.cOn();
                } else {
                    PersonChangeActivity.this.showToast(this.bth.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.heh);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.koH != null) {
                this.bth = new x(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.bth.addPostData("sex", String.valueOf(this.koH.cOo().getSex()));
                this.bth.addPostData("intro", this.koH.cOo().getIntro());
                this.bth.addPostData("birthday_time", String.valueOf(this.koH.cOo().getBirthdayTime()));
                this.bth.addPostData("birthday_show_status", String.valueOf(this.koH.cOo().getBirthdayShowStatus()));
                this.bth.postMultiNetData();
                if (this.bth.aUA().aVb().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.den();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hnT && !TextUtils.isEmpty(this.koX)) {
            Kk(this.koX);
            this.hnT = false;
            this.koX = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kl(String str) {
        if (!StringUtils.isNull(str)) {
            this.koP = true;
            this.koR.setText(str);
            this.koQ.setClickable(false);
            this.koS.setVisibility(8);
        }
    }
}
