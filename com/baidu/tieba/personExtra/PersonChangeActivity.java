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
    private ImageView cKU;
    private com.baidu.tbadk.coreExtra.view.c dlM;
    private View jkL;
    private View jlf;
    private TextView jlg;
    private View jlh;
    private View jli;
    private View jlj;
    private View jlk;
    private com.baidu.tbadk.core.dialog.a jll;
    private String jlm;
    private LinearLayout jln;
    private TextView jlo;
    private TextView jlp;
    private RelativeLayout jlq;
    private TextView jlr;
    private TextView jls;
    private View mCloseView;
    private PermissionJudgePolicy mPermissionJudgement;
    public final int jkJ = 90;
    private Boolean jkK = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView hDy = null;
    private LinearLayout geH = null;
    private ScrollView jkM = null;
    private TextView jkN = null;
    private RelativeLayout jkO = null;
    private TextView jkP = null;
    private LinearLayout jkQ = null;
    private TextView exA = null;
    private EditText fkj = null;
    private LinearLayout jkR = null;
    private TextView jkS = null;
    private TextView jkT = null;
    private TextView jkU = null;
    private InputMethodManager mInputManager = null;
    private boolean jkV = false;
    private PersonChangeModel jkW = null;
    protected HeadImageView gjZ = null;
    private com.baidu.adp.widget.ImageView.a hwF = null;
    private a jkX = null;
    private b jkY = null;
    private ProgressBar jkZ = null;
    private DialogInterface.OnCancelListener gfz = null;
    private com.baidu.tbadk.core.dialog.a hVl = null;
    private com.baidu.tbadk.core.dialog.i jla = null;
    private boolean jlb = false;
    private boolean gVp = false;
    private boolean jlc = false;
    private int mSex = 0;
    private final int jld = 500;
    private boolean jle = false;
    private boolean gpl = false;
    private final View.OnClickListener jlt = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.jkW.cwn().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.jlb = true;
            }
            if (PersonChangeActivity.this.jlb) {
                PersonChangeActivity.this.hVl.aEC();
                return;
            }
            if (PersonChangeActivity.this.jkW != null && PersonChangeActivity.this.jkW.cwn().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.jkK.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.jkW.cwn());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.jkW.cwn());
                }
                PersonChangeActivity.this.cwl();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener gpU = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.gpl = true;
                        PersonChangeActivity.this.jlm = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener jlu = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.jkW != null && PersonChangeActivity.this.jkW.cwn() != null && personChangeData != null) {
                    PersonChangeActivity.this.jkW.cwn().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.jkW.cwn().setMem(personChangeData.getMen());
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
        aXI();
        if (bundle != null) {
            this.jkK = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.jkK = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.gpU);
        registerListener(this.jlu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gpU);
        if (this.jkX != null) {
            this.jkX.cancel();
        }
        if (this.jkY != null) {
            this.jkY.cancel();
        }
        if (this.jkZ != null) {
            this.jkZ.setVisibility(8);
        }
        if (this.fkj != null) {
            this.fkj.addTextChangedListener(null);
        }
        if (this.dlM != null) {
            this.dlM.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gjZ || view == this.jlk) {
            if (this.jkW != null && this.jkW.jly != null && !this.jkW.jly.canModifyAvatar()) {
                if (!StringUtils.isNull(this.jkW.jly.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.jkW.jly.getCantModifyAvatarDesc());
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
                cwg();
            }
        } else if (view == this.jkL) {
            if (!this.gVp && !this.jlc) {
                finish();
            }
            if (this.jkK.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.gVp) {
                cwi();
            } else if (this.jlc) {
                cwm();
            }
        } else if (view == this.jkO) {
            cwj();
        } else if (view == this.jkQ) {
            cwe();
        } else if (view == this.fkj) {
            zR(800);
        } else if (view == this.jli) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                cwc();
            } else {
                int nickNameLeftDays = this.jkW.cwn().getNickNameLeftDays();
                if (this.jkW.cwn().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.sS(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).aEC();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.jlf) {
            if (this.jkW == null || this.jkW.cwn() == null || StringUtils.isNull(this.jkW.cwn().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.jlq) {
            PersonConstellationActivity.a(getActivity(), this.jkW.cwn().getBirthdayTime(), this.jkW.cwn().getBirthdayShowStatus());
        }
    }

    private void cwc() {
        if (this.jll == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.jll = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.jll.aO(inflate);
            this.jll.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.cke(), true)));
                    aVar.dismiss();
                }
            });
            this.jll.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jll.b(getPageContext());
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), (int) R.color.cp_cont_b);
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), (int) R.color.common_color_10122);
        }
        this.jll.aEC();
    }

    private void i(AccountData accountData) {
        if (this.dlM == null) {
            this.dlM = new com.baidu.tbadk.coreExtra.view.c(this);
            this.dlM.a(new c.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.GP(accountData2.getAccount());
                    }
                }
            });
        }
        this.dlM.aMO();
        this.dlM.setAccountData(accountData);
        this.dlM.aMK();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.jkV = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.jkV) {
            cwd();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwd() {
        if (this.fkj.getVisibility() == 0) {
            String replaceAll = this.fkj.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.exA.setText(replaceAll);
            } else {
                this.exA.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.jkW.cwn().getIntro() == null || !this.jkW.cwn().getIntro().equals(replaceAll)) {
                this.jlb = true;
            }
            this.jkW.cwn().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.fkj);
        }
    }

    private void cwe() {
        if (this.fkj.getVisibility() != 0) {
            this.exA.setVisibility(8);
            this.fkj.setText(this.jkW.cwn().getIntro());
            this.fkj.setSelection(this.fkj.getText().length());
            this.fkj.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.fkj);
            zR(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zR(int i) {
        this.jkM.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.jkM.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void ax(Bundle bundle) {
        this.gfz = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.jkY != null) {
                    PersonChangeActivity.this.jkY.cancel();
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
        this.jkW = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.geH);
        SvgManager.aGC().a(this.cKU, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gjZ.refresh();
        am.setViewTextColor(this.jlg, (int) R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.jkW.cwn() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.jkW.cwn()));
        }
    }

    private void aXI() {
        this.jlk = findViewById(R.id.photo_pop_icon);
        this.jlk.setOnClickListener(this);
        this.gjZ = (HeadImageView) findViewById(R.id.photo);
        this.gjZ.setOnClickListener(this);
        this.gjZ.startLoad(o.tn(this.jkW.cwn().getPortrait()), 25, false);
        this.geH = (LinearLayout) findViewById(R.id.parent);
        this.jkM = (ScrollView) findViewById(R.id.person_change_scroll);
        this.jkO = (RelativeLayout) findViewById(R.id.person_sex);
        this.jkP = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mCloseView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.jlt);
        this.cKU = (ImageView) this.mCloseView.findViewById(R.id.widget_navi_back_button);
        this.cKU.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.jkL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.hDy = (TextView) this.jkL.findViewById(R.id.right_textview);
        this.hDy.setText(getPageContext().getString(R.string.save));
        am.setViewTextColor(this.hDy, R.color.navi_op_text, 1);
        this.jkL.setOnClickListener(this);
        this.jkO.setOnClickListener(this);
        this.jkQ = (LinearLayout) findViewById(R.id.intro_click);
        this.jkQ.setOnClickListener(this);
        this.jkQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.jkV = true;
                    return false;
                }
                return false;
            }
        });
        this.jkN = (TextView) findViewById(R.id.nick_name_show);
        this.jkN.setText(this.jkW.cwn().getNameShow());
        this.jli = findViewById(R.id.person_nickname);
        this.jli.setOnClickListener(this);
        this.jlj = findViewById(R.id.nick_name_more);
        cwf();
        this.jlg = (TextView) findViewById(R.id.user_name_show);
        this.jlf = findViewById(R.id.person_name);
        this.jlh = findViewById(R.id.user_name_more_icon);
        this.jlf.setOnClickListener(this);
        if (StringUtils.isNull(this.jkW.cwn().getName())) {
            this.jlg.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.jle = false;
            this.jlf.setClickable(true);
            this.jlh.setVisibility(0);
        } else {
            this.jlg.setText(this.jkW.cwn().getName());
            this.jle = true;
            this.jlf.setClickable(false);
            this.jlh.setVisibility(8);
        }
        this.jkR = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.jkS = (TextView) findViewById(R.id.intro_text_tip_num);
        this.jkT = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.jkU = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.exA = (TextView) findViewById(R.id.intro);
        this.exA.setVisibility(8);
        if (this.jkW.cwn().getIntro() != null && this.jkW.cwn().getIntro().length() > 0) {
            this.exA.setText(this.jkW.cwn().getIntro());
        } else {
            this.exA.setText(getPageContext().getString(R.string.add_intro));
        }
        this.fkj = (EditText) findViewById(R.id.edit);
        this.fkj.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.fkj.setHintTextColor(am.getColor(R.color.cp_cont_c));
        this.fkj.setCursorVisible(false);
        if (!aq.isEmpty(this.jkW.cwn().getIntro())) {
            this.fkj.setText(this.jkW.cwn().getIntro());
            this.jkS.setText(this.jkW.cwn().getIntro().length() + "");
        } else {
            this.jkS.setText("0");
        }
        this.jkR.setVisibility(0);
        this.fkj.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.cwd();
                }
            }
        });
        this.fkj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.jkV = true;
                    PersonChangeActivity.this.fkj.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.fkj.setOnClickListener(this);
        this.fkj.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.fkj.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.jkS.setText(String.valueOf(length));
                PersonChangeActivity.this.jkR.setVisibility(0);
                PersonChangeActivity.this.zR(0);
                PersonChangeActivity.this.cwh();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.fkj.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.fkj.getSelectionStart() - 1 > PersonChangeActivity.this.fkj.getSelectionEnd()) {
                        PersonChangeActivity.this.fkj.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.fkj.getSelectionStart() - 1, PersonChangeActivity.this.fkj.getSelectionEnd());
                        PersonChangeActivity.this.fkj.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.fkj.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.jkW.cwn().getIntro())) {
                    PersonChangeActivity.this.gVp = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(PersonChangeActivity.this.hDy, R.color.navi_op_text, 1);
                    } else {
                        am.setViewTextColor(PersonChangeActivity.this.hDy, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.jkW.cwn().getSex() == 1) {
            this.mSex = 1;
            this.jkP.setText(R.string.male);
        } else if (this.jkW.cwn().getSex() == 2) {
            this.mSex = 2;
            this.jkP.setText(R.string.female);
        } else {
            this.jkP.setText(R.string.change_sex);
        }
        this.jkZ = (ProgressBar) findViewById(R.id.image_progress);
        this.hVl = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hVl.sS(getPageContext().getString(R.string.confirm_giveup));
        this.hVl.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.cwi();
            }
        });
        this.hVl.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.jkW.cwn().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.jkK.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.jkW.cwn());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.jkW.cwn());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.cwl();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.hVl.b(getPageContext());
        this.jln = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.jlo = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.jkW.cwn().getAlaId() > 0) {
            this.jln.setVisibility(0);
            this.jlo.setText(this.jkW.cwn().getAlaId() + "");
        }
        this.jlp = (TextView) findViewById(R.id.person_forum_age_show);
        this.jlp.setText(getResources().getString(R.string.person_forum_age_suffix, this.jkW.cwn().getForumAge()));
        this.jlq = (RelativeLayout) findViewById(R.id.person_constellation);
        this.jlq.setOnClickListener(this);
        this.jlr = (TextView) findViewById(R.id.constellation_txt);
        this.jls = (TextView) findViewById(R.id.age_txt);
        if (this.jkW.cwn().getBirthdayTime() != 0) {
            this.jlr.setText(aq.l(new Date(this.jkW.cwn().getBirthdayTime() * 1000)));
        }
        if (this.jkW.cwn().getUserAge() > 0 && this.jkW.cwn().getBirthdayShowStatus() == 2) {
            this.jls.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.jkW.cwn().getUserAge())));
            this.jls.setVisibility(0);
        } else {
            this.jls.setVisibility(8);
        }
        this.jkM.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.jkM.scrollTo(0, 0);
            }
        });
    }

    private void cwf() {
        if (NickNameActivitySwitch.isOn() || this.jkW.cwn().getNickNameLeftDays() == 0) {
            this.jlj.setVisibility(0);
        } else {
            this.jlj.setVisibility(8);
        }
    }

    public void cwg() {
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
        bVar.aED();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwh() {
        int color;
        if (this.fkj.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = am.getColor(R.color.common_color_10159);
        } else {
            color = am.getColor(R.color.common_color_10077);
        }
        zS(color);
    }

    private void zS(int i) {
        this.jkS.setTextColor(i);
        this.jkT.setTextColor(i);
        this.jkU.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwi() {
        if (this.jkW != null && this.jkW.cwn() != null) {
            cwd();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.jkW.cwn().setIntro(this.fkj.getText().toString().replaceAll("\\s*", ""));
            this.jkW.cwn().setSex(this.mSex);
            if (this.jkY == null) {
                this.jkY = new b(this.jkW);
                this.jkY.setPriority(3);
                this.jkY.execute(new String[0]);
            }
        }
    }

    private void cwj() {
        if (this.jla == null) {
            this.jla = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.jla.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.jla != null && PersonChangeActivity.this.jla.isShowing()) {
                        PersonChangeActivity.this.jla.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.jkP.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.jkP.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.jkW.cwn().getSex()) {
                            PersonChangeActivity.this.gVp = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                am.setViewTextColor(PersonChangeActivity.this.hDy, R.color.navi_op_text, 1);
                            } else {
                                am.setViewTextColor(PersonChangeActivity.this.hDy, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.jla.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cwd();
            this.jlt.onClick(null);
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
                        if (longExtra != this.jkW.cwn().getBirthdayTime() || intExtra != this.jkW.cwn().getBirthdayShowStatus()) {
                            this.jkW.cwn().setBirthdayShowStatus(intExtra);
                            this.jkW.cwn().setBirthdayTime(longExtra);
                            this.jlb = true;
                            this.gVp = true;
                            Date date = new Date(longExtra * 1000);
                            this.jlr.setText(aq.l(date));
                            if (this.jkW.cwn().getBirthdayShowStatus() == 2) {
                                this.jls.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(n(date))));
                                this.jls.setVisibility(0);
                                return;
                            }
                            this.jls.setVisibility(8);
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
                    this.jkW.cwn().setPhotoChanged(true);
                    cwk();
                    this.gVp = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.hDy, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.hDy, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.jkW.cwn().setPhotoChanged(true);
                    if (intent != null) {
                        this.gjZ.setImageBitmap(null);
                        this.gjZ.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.gVp = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.hDy, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.hDy, R.color.cp_link_tip_a, 1);
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

    private void GO(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jlc = true;
            this.jkW.cwn().setPhotoChanged(true);
            this.jkW.cwn().setNameShow(str);
            this.jkW.cwn().setNickNameLeftDays(90);
            this.jkN.setText(str);
            cwf();
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

    private void cwk() {
        if (this.jkX != null) {
            this.jkX.cancel();
        }
        this.hwF = null;
        this.jkX = new a();
        this.jkX.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwl() {
        if (this.jkW != null && this.jkW.cwn() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.jkW.cwn()));
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
            PersonChangeActivity.this.jkZ.setVisibility(0);
            PersonChangeActivity.this.gjZ.setImageDrawable(null);
            PersonChangeActivity.this.hwF = null;
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
            PersonChangeActivity.this.jkX = null;
            PersonChangeActivity.this.jkZ.setVisibility(8);
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
            PersonChangeActivity.this.jkX = null;
            PersonChangeActivity.this.jkZ.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.hwF = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.hwF.drawImageTo(PersonChangeActivity.this.gjZ);
                com.baidu.tbadk.imageManager.c.aPR().a(PersonChangeActivity.this.jkW.cwn().getPortrait(), PersonChangeActivity.this.hwF, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwm() {
        Intent intent = new Intent();
        if (this.jkK.booleanValue()) {
            intent.putExtra("person_change_data", this.jkW.cwn());
        } else {
            intent.putExtra("data", this.jkW.cwn());
        }
        setResult(-1, intent);
        cwl();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private x cLF = null;
        private PersonChangeModel jkW;

        public b(PersonChangeModel personChangeModel) {
            this.jkW = null;
            this.jkW = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.jkY = null;
            if (this.cLF != null) {
                this.cLF.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.jkY = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.cLF != null) {
                if (this.cLF.aGg().aGI().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.cwm();
                } else {
                    PersonChangeActivity.this.showToast(this.cLF.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.gfz);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.jkW != null) {
                this.cLF = new x(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.cLF.addPostData("sex", String.valueOf(this.jkW.cwn().getSex()));
                this.cLF.addPostData("intro", this.jkW.cwn().getIntro());
                this.cLF.addPostData("birthday_time", String.valueOf(this.jkW.cwn().getBirthdayTime()));
                this.cLF.addPostData("birthday_show_status", String.valueOf(this.jkW.cwn().getBirthdayShowStatus()));
                this.cLF.postMultiNetData();
                if (this.cLF.aGg().aGI().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.cLS();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gpl && !TextUtils.isEmpty(this.jlm)) {
            GO(this.jlm);
            this.gpl = false;
            this.jlm = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GP(String str) {
        if (!StringUtils.isNull(str)) {
            this.jle = true;
            this.jlg.setText(str);
            this.jlf.setClickable(false);
            this.jlh.setVisibility(8);
        }
    }
}
