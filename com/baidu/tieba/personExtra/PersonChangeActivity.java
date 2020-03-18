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
    private ImageView cLf;
    private com.baidu.tbadk.coreExtra.view.c dlZ;
    private View jmF;
    private TextView jmG;
    private View jmH;
    private View jmI;
    private View jmJ;
    private View jmK;
    private com.baidu.tbadk.core.dialog.a jmL;
    private String jmM;
    private LinearLayout jmN;
    private TextView jmO;
    private TextView jmP;
    private RelativeLayout jmQ;
    private TextView jmR;
    private TextView jmS;
    private View jmk;
    private View mCloseView;
    private PermissionJudgePolicy mPermissionJudgement;
    public final int jmi = 90;
    private Boolean jmj = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView hEY = null;
    private LinearLayout gfp = null;
    private ScrollView jml = null;
    private TextView jmm = null;
    private RelativeLayout jmn = null;
    private TextView jmo = null;
    private LinearLayout jmq = null;
    private TextView exW = null;
    private EditText fkI = null;
    private LinearLayout jmr = null;
    private TextView jms = null;
    private TextView jmt = null;
    private TextView jmu = null;
    private InputMethodManager mInputManager = null;
    private boolean jmv = false;
    private PersonChangeModel jmw = null;
    protected HeadImageView gkH = null;
    private com.baidu.adp.widget.ImageView.a hyf = null;
    private a jmx = null;
    private b jmy = null;
    private ProgressBar jmz = null;
    private DialogInterface.OnCancelListener ggh = null;
    private com.baidu.tbadk.core.dialog.a hWL = null;
    private com.baidu.tbadk.core.dialog.i jmA = null;
    private boolean jmB = false;
    private boolean gWw = false;
    private boolean jmC = false;
    private int mSex = 0;
    private final int jmD = 500;
    private boolean jmE = false;
    private boolean gpV = false;
    private final View.OnClickListener jmT = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.jmw.cwG().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.jmB = true;
            }
            if (PersonChangeActivity.this.jmB) {
                PersonChangeActivity.this.hWL.aEG();
                return;
            }
            if (PersonChangeActivity.this.jmw != null && PersonChangeActivity.this.jmw.cwG().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.jmj.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.jmw.cwG());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.jmw.cwG());
                }
                PersonChangeActivity.this.cwE();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener gqE = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.gpV = true;
                        PersonChangeActivity.this.jmM = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener jmU = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.jmw != null && PersonChangeActivity.this.jmw.cwG() != null && personChangeData != null) {
                    PersonChangeActivity.this.jmw.cwG().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.jmw.cwG().setMem(personChangeData.getMen());
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
        aXM();
        if (bundle != null) {
            this.jmj = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.jmj = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.gqE);
        registerListener(this.jmU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gqE);
        if (this.jmx != null) {
            this.jmx.cancel();
        }
        if (this.jmy != null) {
            this.jmy.cancel();
        }
        if (this.jmz != null) {
            this.jmz.setVisibility(8);
        }
        if (this.fkI != null) {
            this.fkI.addTextChangedListener(null);
        }
        if (this.dlZ != null) {
            this.dlZ.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gkH || view == this.jmK) {
            if (this.jmw != null && this.jmw.jmY != null && !this.jmw.jmY.canModifyAvatar()) {
                if (!StringUtils.isNull(this.jmw.jmY.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.jmw.jmY.getCantModifyAvatarDesc());
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
                cwz();
            }
        } else if (view == this.jmk) {
            if (!this.gWw && !this.jmC) {
                finish();
            }
            if (this.jmj.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.gWw) {
                cwB();
            } else if (this.jmC) {
                cwF();
            }
        } else if (view == this.jmn) {
            cwC();
        } else if (view == this.jmq) {
            cwx();
        } else if (view == this.fkI) {
            zZ(800);
        } else if (view == this.jmI) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                cwv();
            } else {
                int nickNameLeftDays = this.jmw.cwG().getNickNameLeftDays();
                if (this.jmw.cwG().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.sR(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).aEG();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.jmF) {
            if (this.jmw == null || this.jmw.cwG() == null || StringUtils.isNull(this.jmw.cwG().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.jmQ) {
            PersonConstellationActivity.a(getActivity(), this.jmw.cwG().getBirthdayTime(), this.jmw.cwG().getBirthdayShowStatus());
        }
    }

    private void cwv() {
        if (this.jmL == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.jmL = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.jmL.aO(inflate);
            this.jmL.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.cky(), true)));
                    aVar.dismiss();
                }
            });
            this.jmL.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jmL.b(getPageContext());
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), (int) R.color.cp_cont_b);
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), (int) R.color.common_color_10122);
        }
        this.jmL.aEG();
    }

    private void i(AccountData accountData) {
        if (this.dlZ == null) {
            this.dlZ = new com.baidu.tbadk.coreExtra.view.c(this);
            this.dlZ.a(new c.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.GO(accountData2.getAccount());
                    }
                }
            });
        }
        this.dlZ.aMS();
        this.dlZ.setAccountData(accountData);
        this.dlZ.aMO();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.jmv = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.jmv) {
            cww();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cww() {
        if (this.fkI.getVisibility() == 0) {
            String replaceAll = this.fkI.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.exW.setText(replaceAll);
            } else {
                this.exW.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.jmw.cwG().getIntro() == null || !this.jmw.cwG().getIntro().equals(replaceAll)) {
                this.jmB = true;
            }
            this.jmw.cwG().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.fkI);
        }
    }

    private void cwx() {
        if (this.fkI.getVisibility() != 0) {
            this.exW.setVisibility(8);
            this.fkI.setText(this.jmw.cwG().getIntro());
            this.fkI.setSelection(this.fkI.getText().length());
            this.fkI.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.fkI);
            zZ(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zZ(int i) {
        this.jml.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.jml.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void ax(Bundle bundle) {
        this.ggh = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.jmy != null) {
                    PersonChangeActivity.this.jmy.cancel();
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
        this.jmw = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.gfp);
        SvgManager.aGG().a(this.cLf, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gkH.refresh();
        am.setViewTextColor(this.jmG, (int) R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.jmw.cwG() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.jmw.cwG()));
        }
    }

    private void aXM() {
        this.jmK = findViewById(R.id.photo_pop_icon);
        this.jmK.setOnClickListener(this);
        this.gkH = (HeadImageView) findViewById(R.id.photo);
        this.gkH.setOnClickListener(this);
        this.gkH.startLoad(o.tm(this.jmw.cwG().getPortrait()), 25, false);
        this.gfp = (LinearLayout) findViewById(R.id.parent);
        this.jml = (ScrollView) findViewById(R.id.person_change_scroll);
        this.jmn = (RelativeLayout) findViewById(R.id.person_sex);
        this.jmo = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mCloseView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.jmT);
        this.cLf = (ImageView) this.mCloseView.findViewById(R.id.widget_navi_back_button);
        this.cLf.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.jmk = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.hEY = (TextView) this.jmk.findViewById(R.id.right_textview);
        this.hEY.setText(getPageContext().getString(R.string.save));
        am.setViewTextColor(this.hEY, R.color.navi_op_text, 1);
        this.jmk.setOnClickListener(this);
        this.jmn.setOnClickListener(this);
        this.jmq = (LinearLayout) findViewById(R.id.intro_click);
        this.jmq.setOnClickListener(this);
        this.jmq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.jmv = true;
                    return false;
                }
                return false;
            }
        });
        this.jmm = (TextView) findViewById(R.id.nick_name_show);
        this.jmm.setText(this.jmw.cwG().getNameShow());
        this.jmI = findViewById(R.id.person_nickname);
        this.jmI.setOnClickListener(this);
        this.jmJ = findViewById(R.id.nick_name_more);
        cwy();
        this.jmG = (TextView) findViewById(R.id.user_name_show);
        this.jmF = findViewById(R.id.person_name);
        this.jmH = findViewById(R.id.user_name_more_icon);
        this.jmF.setOnClickListener(this);
        if (StringUtils.isNull(this.jmw.cwG().getName())) {
            this.jmG.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.jmE = false;
            this.jmF.setClickable(true);
            this.jmH.setVisibility(0);
        } else {
            this.jmG.setText(this.jmw.cwG().getName());
            this.jmE = true;
            this.jmF.setClickable(false);
            this.jmH.setVisibility(8);
        }
        this.jmr = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.jms = (TextView) findViewById(R.id.intro_text_tip_num);
        this.jmt = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.jmu = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.exW = (TextView) findViewById(R.id.intro);
        this.exW.setVisibility(8);
        if (this.jmw.cwG().getIntro() != null && this.jmw.cwG().getIntro().length() > 0) {
            this.exW.setText(this.jmw.cwG().getIntro());
        } else {
            this.exW.setText(getPageContext().getString(R.string.add_intro));
        }
        this.fkI = (EditText) findViewById(R.id.edit);
        this.fkI.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.fkI.setHintTextColor(am.getColor(R.color.cp_cont_c));
        this.fkI.setCursorVisible(false);
        if (!aq.isEmpty(this.jmw.cwG().getIntro())) {
            this.fkI.setText(this.jmw.cwG().getIntro());
            this.jms.setText(this.jmw.cwG().getIntro().length() + "");
        } else {
            this.jms.setText("0");
        }
        this.jmr.setVisibility(0);
        this.fkI.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.cww();
                }
            }
        });
        this.fkI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.jmv = true;
                    PersonChangeActivity.this.fkI.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.fkI.setOnClickListener(this);
        this.fkI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.fkI.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.jms.setText(String.valueOf(length));
                PersonChangeActivity.this.jmr.setVisibility(0);
                PersonChangeActivity.this.zZ(0);
                PersonChangeActivity.this.cwA();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.fkI.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.fkI.getSelectionStart() - 1 > PersonChangeActivity.this.fkI.getSelectionEnd()) {
                        PersonChangeActivity.this.fkI.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.fkI.getSelectionStart() - 1, PersonChangeActivity.this.fkI.getSelectionEnd());
                        PersonChangeActivity.this.fkI.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.fkI.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.jmw.cwG().getIntro())) {
                    PersonChangeActivity.this.gWw = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(PersonChangeActivity.this.hEY, R.color.navi_op_text, 1);
                    } else {
                        am.setViewTextColor(PersonChangeActivity.this.hEY, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.jmw.cwG().getSex() == 1) {
            this.mSex = 1;
            this.jmo.setText(R.string.male);
        } else if (this.jmw.cwG().getSex() == 2) {
            this.mSex = 2;
            this.jmo.setText(R.string.female);
        } else {
            this.jmo.setText(R.string.change_sex);
        }
        this.jmz = (ProgressBar) findViewById(R.id.image_progress);
        this.hWL = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hWL.sR(getPageContext().getString(R.string.confirm_giveup));
        this.hWL.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.cwB();
            }
        });
        this.hWL.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.jmw.cwG().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.jmj.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.jmw.cwG());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.jmw.cwG());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.cwE();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.hWL.b(getPageContext());
        this.jmN = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.jmO = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.jmw.cwG().getAlaId() > 0) {
            this.jmN.setVisibility(0);
            this.jmO.setText(this.jmw.cwG().getAlaId() + "");
        }
        this.jmP = (TextView) findViewById(R.id.person_forum_age_show);
        this.jmP.setText(getResources().getString(R.string.person_forum_age_suffix, this.jmw.cwG().getForumAge()));
        this.jmQ = (RelativeLayout) findViewById(R.id.person_constellation);
        this.jmQ.setOnClickListener(this);
        this.jmR = (TextView) findViewById(R.id.constellation_txt);
        this.jmS = (TextView) findViewById(R.id.age_txt);
        if (this.jmw.cwG().getBirthdayTime() != 0) {
            this.jmR.setText(aq.l(new Date(this.jmw.cwG().getBirthdayTime() * 1000)));
        }
        if (this.jmw.cwG().getUserAge() > 0 && this.jmw.cwG().getBirthdayShowStatus() == 2) {
            this.jmS.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.jmw.cwG().getUserAge())));
            this.jmS.setVisibility(0);
        } else {
            this.jmS.setVisibility(8);
        }
        this.jml.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.jml.scrollTo(0, 0);
            }
        });
    }

    private void cwy() {
        if (NickNameActivitySwitch.isOn() || this.jmw.cwG().getNickNameLeftDays() == 0) {
            this.jmJ.setVisibility(0);
        } else {
            this.jmJ.setVisibility(8);
        }
    }

    public void cwz() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.ka(R.string.operation);
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
        bVar.aEH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwA() {
        int color;
        if (this.fkI.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = am.getColor(R.color.common_color_10159);
        } else {
            color = am.getColor(R.color.common_color_10077);
        }
        Aa(color);
    }

    private void Aa(int i) {
        this.jms.setTextColor(i);
        this.jmt.setTextColor(i);
        this.jmu.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwB() {
        if (this.jmw != null && this.jmw.cwG() != null) {
            cww();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.jmw.cwG().setIntro(this.fkI.getText().toString().replaceAll("\\s*", ""));
            this.jmw.cwG().setSex(this.mSex);
            if (this.jmy == null) {
                this.jmy = new b(this.jmw);
                this.jmy.setPriority(3);
                this.jmy.execute(new String[0]);
            }
        }
    }

    private void cwC() {
        if (this.jmA == null) {
            this.jmA = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.jmA.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.jmA != null && PersonChangeActivity.this.jmA.isShowing()) {
                        PersonChangeActivity.this.jmA.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.jmo.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.jmo.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.jmw.cwG().getSex()) {
                            PersonChangeActivity.this.gWw = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                am.setViewTextColor(PersonChangeActivity.this.hEY, R.color.navi_op_text, 1);
                            } else {
                                am.setViewTextColor(PersonChangeActivity.this.hEY, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.jmA.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cww();
            this.jmT.onClick(null);
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
                        if (longExtra != this.jmw.cwG().getBirthdayTime() || intExtra != this.jmw.cwG().getBirthdayShowStatus()) {
                            this.jmw.cwG().setBirthdayShowStatus(intExtra);
                            this.jmw.cwG().setBirthdayTime(longExtra);
                            this.jmB = true;
                            this.gWw = true;
                            Date date = new Date(longExtra * 1000);
                            this.jmR.setText(aq.l(date));
                            if (this.jmw.cwG().getBirthdayShowStatus() == 2) {
                                this.jmS.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(n(date))));
                                this.jmS.setVisibility(0);
                                return;
                            }
                            this.jmS.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            av(intent);
                            return;
                        } else {
                            ap(intent);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.jmw.cwG().setPhotoChanged(true);
                    cwD();
                    this.gWw = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.hEY, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.hEY, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.jmw.cwG().setPhotoChanged(true);
                    if (intent != null) {
                        this.gkH.setImageBitmap(null);
                        this.gkH.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.gWw = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.hEY, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.hEY, R.color.cp_link_tip_a, 1);
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

    private void GN(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jmC = true;
            this.jmw.cwG().setPhotoChanged(true);
            this.jmw.cwG().setNameShow(str);
            this.jmw.cwG().setNickNameLeftDays(90);
            this.jmm.setText(str);
            cwy();
        }
    }

    private void ap(Intent intent) {
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

    private void av(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, RequestResponseCode.REQUEST_CAMERA_VIEW, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void cwD() {
        if (this.jmx != null) {
            this.jmx.cancel();
        }
        this.hyf = null;
        this.jmx = new a();
        this.jmx.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwE() {
        if (this.jmw != null && this.jmw.cwG() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.jmw.cwG()));
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
            PersonChangeActivity.this.jmz.setVisibility(0);
            PersonChangeActivity.this.gkH.setImageDrawable(null);
            PersonChangeActivity.this.hyf = null;
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
            PersonChangeActivity.this.jmx = null;
            PersonChangeActivity.this.jmz.setVisibility(8);
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
            PersonChangeActivity.this.jmx = null;
            PersonChangeActivity.this.jmz.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.hyf = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.hyf.drawImageTo(PersonChangeActivity.this.gkH);
                com.baidu.tbadk.imageManager.c.aPV().a(PersonChangeActivity.this.jmw.cwG().getPortrait(), PersonChangeActivity.this.hyf, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwF() {
        Intent intent = new Intent();
        if (this.jmj.booleanValue()) {
            intent.putExtra("person_change_data", this.jmw.cwG());
        } else {
            intent.putExtra("data", this.jmw.cwG());
        }
        setResult(-1, intent);
        cwE();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private x cLQ = null;
        private PersonChangeModel jmw;

        public b(PersonChangeModel personChangeModel) {
            this.jmw = null;
            this.jmw = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.jmy = null;
            if (this.cLQ != null) {
                this.cLQ.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.jmy = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.cLQ != null) {
                if (this.cLQ.aGk().aGM().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.cwF();
                } else {
                    PersonChangeActivity.this.showToast(this.cLQ.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.ggh);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.jmw != null) {
                this.cLQ = new x(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.cLQ.addPostData("sex", String.valueOf(this.jmw.cwG().getSex()));
                this.cLQ.addPostData("intro", this.jmw.cwG().getIntro());
                this.cLQ.addPostData("birthday_time", String.valueOf(this.jmw.cwG().getBirthdayTime()));
                this.cLQ.addPostData("birthday_show_status", String.valueOf(this.jmw.cwG().getBirthdayShowStatus()));
                this.cLQ.postMultiNetData();
                if (this.cLQ.aGk().aGM().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.cMm();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gpV && !TextUtils.isEmpty(this.jmM)) {
            GN(this.jmM);
            this.gpV = false;
            this.jmM = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GO(String str) {
        if (!StringUtils.isNull(str)) {
            this.jmE = true;
            this.jmG.setText(str);
            this.jmF.setClickable(false);
            this.jmH.setVisibility(8);
        }
    }
}
