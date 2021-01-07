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
import com.baidu.adp.lib.util.j;
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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
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
/* loaded from: classes8.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private ImageView eKe;
    private View eKf;
    private com.baidu.tbadk.coreExtra.view.b fso;
    private PermissionJudgePolicy mPermissionJudgement;
    private View msN;
    private View mtj;
    private TextView mtk;
    private View mtl;
    private View mtm;
    private View mtn;
    private ImageView mto;
    private com.baidu.tbadk.core.dialog.a mtp;
    private String mtq;
    private LinearLayout mtr;
    private TextView mts;
    private TextView mtt;
    private RelativeLayout mtu;
    private TextView mtv;
    private TextView mtw;
    public final int msK = 90;
    private Boolean msL = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView msM = null;
    private LinearLayout iVh = null;
    private ScrollView msO = null;
    private TextView msP = null;
    private RelativeLayout msQ = null;
    private TextView msR = null;
    private LinearLayout msS = null;
    private TextView gRm = null;
    private EditText msT = null;
    private LinearLayout msU = null;
    private TextView msV = null;
    private TextView msW = null;
    private TextView msX = null;
    private InputMethodManager mInputManager = null;
    private boolean msY = false;
    private PersonChangeModel msZ = null;
    protected HeadImageView jav = null;
    private com.baidu.adp.widget.ImageView.a mta = null;
    private a mtb = null;
    private b mtc = null;
    private ProgressBar mtd = null;
    private DialogInterface.OnCancelListener iVZ = null;
    private com.baidu.tbadk.core.dialog.a kUV = null;
    private com.baidu.tbadk.core.dialog.i mte = null;
    private boolean mtf = false;
    private boolean jUI = false;
    private boolean mtg = false;
    private int mSex = 0;
    private final int mth = 500;
    private boolean mti = false;
    private boolean jfV = false;
    private final View.OnClickListener mtx = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.msZ.dzr().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.mtf = true;
            }
            if (PersonChangeActivity.this.mtf) {
                PersonChangeActivity.this.kUV.btY();
                return;
            }
            if (PersonChangeActivity.this.msZ != null && PersonChangeActivity.this.msZ.dzr().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.msL.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.msZ.dzr());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.msZ.dzr());
                }
                PersonChangeActivity.this.dzp();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener jgW = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.jfV = true;
                        PersonChangeActivity.this.mtq = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener mty = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.msZ != null && PersonChangeActivity.this.msZ.dzr() != null && personChangeData != null) {
                    PersonChangeActivity.this.msZ.dzr().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.msZ.dzr().setMem(personChangeData.getMen());
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
        bOp();
        if (bundle != null) {
            this.msL = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.msL = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.jgW);
        registerListener(this.mty);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jgW);
        if (this.mtb != null) {
            this.mtb.cancel();
        }
        if (this.mtc != null) {
            this.mtc.cancel();
        }
        if (this.mtd != null) {
            this.mtd.setVisibility(8);
        }
        if (this.msT != null) {
            this.msT.addTextChangedListener(null);
        }
        if (this.fso != null) {
            this.fso.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jav || view == this.mto) {
            if (this.msZ != null && this.msZ.mtC != null && !this.msZ.mtC.canModifyAvatar()) {
                if (!StringUtils.isNull(this.msZ.mtC.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.msZ.mtC.getCantModifyAvatarDesc());
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
                dzk();
            }
        } else if (view == this.msN) {
            if (!this.jUI && !this.mtg) {
                finish();
            }
            if (this.msL.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.jUI) {
                dzm();
            } else if (this.mtg) {
                dzq();
            }
        } else if (view == this.msQ) {
            dzn();
        } else if (view == this.msS) {
            dzi();
        } else if (view == this.msT) {
            Ig(800);
        } else if (view == this.mtm) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                dzg();
            } else {
                int nickNameLeftDays = this.msZ.dzr().getNickNameLeftDays();
                if (this.msZ.dzr().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.Bo(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
                        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                if (j.isNetWorkAvailable()) {
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
                        aVar.b(getPageContext()).btY();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.mtj) {
            if (this.msZ == null || this.msZ.dzr() == null || StringUtils.isNull(this.msZ.dzr().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.mtu) {
            PersonConstellationActivity.a(getActivity(), this.msZ.dzr().getBirthdayTime(), this.msZ.dzr().getBirthdayShowStatus());
        }
    }

    private void dzg() {
        if (this.mtp == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.mtp = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.mtp.br(inflate);
            this.mtp.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.dmp(), true)));
                    aVar.dismiss();
                }
            });
            this.mtp.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.mtp.b(getPageContext());
            ao.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), R.color.CAM_X0105);
            ao.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.mtp.btY();
    }

    private void i(AccountData accountData) {
        if (this.fso == null) {
            this.fso = new com.baidu.tbadk.coreExtra.view.b(this);
            this.fso.a(new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.QJ(accountData2.getAccount());
                    }
                }
            });
        }
        this.fso.bDc();
        this.fso.setAccountData(accountData);
        this.fso.bCY();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.msY = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.msY) {
            dzh();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzh() {
        if (this.msT.getVisibility() == 0) {
            String replaceAll = this.msT.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.gRm.setText(replaceAll);
            } else {
                this.gRm.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.msZ.dzr().getIntro() == null || !this.msZ.dzr().getIntro().equals(replaceAll)) {
                this.mtf = true;
            }
            this.msZ.dzr().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.msT);
        }
    }

    private void dzi() {
        if (this.msT.getVisibility() != 0) {
            this.gRm.setVisibility(8);
            this.msT.setText(this.msZ.dzr().getIntro());
            this.msT.setSelection(this.msT.getText().length());
            this.msT.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.msT);
            Ig(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ig(int i) {
        this.msO.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.msO.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aG(Bundle bundle) {
        this.iVZ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.mtc != null) {
                    PersonChangeActivity.this.mtc.cancel();
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
        this.msZ = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iVh);
        SvgManager.bwr().a(this.eKe, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jav.refresh();
        ao.setViewTextColor(this.mtk, R.color.CAM_X0109);
        WebPManager.a(this.mto, R.drawable.icon_mask_personalba_edit40, (WebPManager.ResourceStateType) null);
        ao.setViewTextColor(this.msM, R.color.CAM_X0302, 1);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.msZ.dzr() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.msZ.dzr()));
        }
    }

    private void bOp() {
        this.mto = (ImageView) findViewById(R.id.photo_pop_icon);
        this.mto.setOnClickListener(this);
        this.jav = (HeadImageView) findViewById(R.id.photo);
        this.jav.setOnClickListener(this);
        this.jav.startLoad(q.BP(this.msZ.dzr().getPortrait()), 25, false);
        this.iVh = (LinearLayout) findViewById(R.id.parent);
        this.msO = (ScrollView) findViewById(R.id.person_change_scroll);
        this.msQ = (RelativeLayout) findViewById(R.id.person_sex);
        this.msR = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.eKf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.mtx);
        this.eKe = (ImageView) this.eKf.findViewById(R.id.widget_navi_back_button);
        this.eKe.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.msN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.msM = (TextView) this.msN.findViewById(R.id.right_textview);
        this.msM.setText(getPageContext().getString(R.string.save));
        ao.setViewTextColor(this.msM, R.color.navi_op_text, 1);
        this.msN.setOnClickListener(this);
        this.msQ.setOnClickListener(this);
        this.msS = (LinearLayout) findViewById(R.id.intro_click);
        this.msS.setOnClickListener(this);
        this.msS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.msY = true;
                    return false;
                }
                return false;
            }
        });
        this.msP = (TextView) findViewById(R.id.nick_name_show);
        this.msP.setText(this.msZ.dzr().getNameShow());
        this.mtm = findViewById(R.id.person_nickname);
        this.mtm.setOnClickListener(this);
        this.mtn = findViewById(R.id.nick_name_more);
        dzj();
        this.mtk = (TextView) findViewById(R.id.user_name_show);
        this.mtj = findViewById(R.id.person_name);
        this.mtl = findViewById(R.id.user_name_more_icon);
        this.mtj.setOnClickListener(this);
        if (StringUtils.isNull(this.msZ.dzr().getName())) {
            this.mtk.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.mti = false;
            this.mtj.setClickable(true);
            this.mtl.setVisibility(0);
        } else {
            this.mtk.setText(this.msZ.dzr().getName());
            this.mti = true;
            this.mtj.setClickable(false);
            this.mtl.setVisibility(8);
        }
        this.msU = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.msV = (TextView) findViewById(R.id.intro_text_tip_num);
        this.msW = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.msX = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.gRm = (TextView) findViewById(R.id.intro);
        this.gRm.setVisibility(8);
        if (this.msZ.dzr().getIntro() != null && this.msZ.dzr().getIntro().length() > 0) {
            this.gRm.setText(this.msZ.dzr().getIntro());
        } else {
            this.gRm.setText(getPageContext().getString(R.string.add_intro));
        }
        this.msT = (EditText) findViewById(R.id.edit);
        this.msT.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.msT.setHintTextColor(ao.getColor(R.color.CAM_X0108));
        this.msT.setCursorVisible(false);
        if (!at.isEmpty(this.msZ.dzr().getIntro())) {
            this.msT.setText(this.msZ.dzr().getIntro());
            this.msV.setText(this.msZ.dzr().getIntro().length() + "");
        } else {
            this.msV.setText("0");
        }
        this.msU.setVisibility(0);
        this.msT.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.dzh();
                }
            }
        });
        this.msT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.msY = true;
                    PersonChangeActivity.this.msT.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.msT.setOnClickListener(this);
        this.msT.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.msT.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.msV.setText(String.valueOf(length));
                PersonChangeActivity.this.msU.setVisibility(0);
                PersonChangeActivity.this.Ig(0);
                PersonChangeActivity.this.dzl();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.msT.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.msT.getSelectionStart() - 1 > PersonChangeActivity.this.msT.getSelectionEnd()) {
                        PersonChangeActivity.this.msT.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.msT.getSelectionStart() - 1, PersonChangeActivity.this.msT.getSelectionEnd());
                        PersonChangeActivity.this.msT.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.msT.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.msZ.dzr().getIntro())) {
                    PersonChangeActivity.this.jUI = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ao.setViewTextColor(PersonChangeActivity.this.msM, R.color.navi_op_text, 1);
                    } else {
                        ao.setViewTextColor(PersonChangeActivity.this.msM, R.color.CAM_X0302, 1);
                    }
                }
            }
        });
        if (this.msZ.dzr().getSex() == 1) {
            this.mSex = 1;
            this.msR.setText(R.string.male);
        } else if (this.msZ.dzr().getSex() == 2) {
            this.mSex = 2;
            this.msR.setText(R.string.female);
        } else {
            this.msR.setText(R.string.change_sex);
        }
        this.mtd = (ProgressBar) findViewById(R.id.image_progress);
        this.kUV = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.kUV.Bo(getPageContext().getString(R.string.confirm_giveup));
        this.kUV.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.dzm();
            }
        });
        this.kUV.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.msZ.dzr().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.msL.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.msZ.dzr());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.msZ.dzr());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.dzp();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.kUV.b(getPageContext());
        this.mtr = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.mts = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.msZ.dzr().getAlaId() > 0) {
            this.mtr.setVisibility(0);
            this.mts.setText(this.msZ.dzr().getAlaId() + "");
        }
        this.mtt = (TextView) findViewById(R.id.person_forum_age_show);
        this.mtt.setText(getResources().getString(R.string.person_forum_age_suffix, this.msZ.dzr().getForumAge()));
        this.mtu = (RelativeLayout) findViewById(R.id.person_constellation);
        this.mtu.setOnClickListener(this);
        this.mtv = (TextView) findViewById(R.id.constellation_txt);
        this.mtw = (TextView) findViewById(R.id.age_txt);
        if (this.msZ.dzr().getBirthdayTime() != 0) {
            this.mtv.setText(at.p(new Date(this.msZ.dzr().getBirthdayTime() * 1000)));
        }
        if (this.msZ.dzr().getUserAge() > 0 && this.msZ.dzr().getBirthdayShowStatus() == 2) {
            this.mtw.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.msZ.dzr().getUserAge())));
            this.mtw.setVisibility(0);
        } else {
            this.mtw.setVisibility(8);
        }
        this.msO.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.msO.scrollTo(0, 0);
            }
        });
    }

    private void dzj() {
        if (NickNameActivitySwitch.isOn() || this.msZ.dzr().getNickNameLeftDays() == 0) {
            this.mtn.setVisibility(0);
        } else {
            this.mtn.setVisibility(8);
        }
    }

    public void dzk() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.pf(R.string.operation);
        bVar.a(strArr, new b.InterfaceC0578b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0578b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                if (i == 0) {
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) PersonChangeActivity.this.getPageContext().getPageActivity(), PersonChangeActivity.this.mWriteImagesInfo.toJsonString(), true);
                    albumActivityConfig.setRequestCode(12002);
                    albumActivityConfig.setResourceType(2);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                } else if (i == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST)));
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext());
        bVar.bua();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzl() {
        int color;
        if (this.msT.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = ao.getColor(R.color.common_color_10159);
        } else {
            color = ao.getColor(R.color.common_color_10077);
        }
        Ih(color);
    }

    private void Ih(int i) {
        this.msV.setTextColor(i);
        this.msW.setTextColor(i);
        this.msX.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzm() {
        if (this.msZ != null && this.msZ.dzr() != null) {
            dzh();
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.msZ.dzr().setIntro(this.msT.getText().toString().replaceAll("\\s*", ""));
            this.msZ.dzr().setSex(this.mSex);
            if (this.mtc == null) {
                this.mtc = new b(this.msZ);
                this.mtc.setPriority(3);
                this.mtc.execute(new String[0]);
            }
        }
    }

    private void dzn() {
        if (this.mte == null) {
            this.mte = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.mte.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.mte != null && PersonChangeActivity.this.mte.isShowing()) {
                        PersonChangeActivity.this.mte.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.msR.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.msR.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.msZ.dzr().getSex()) {
                            PersonChangeActivity.this.jUI = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                ao.setViewTextColor(PersonChangeActivity.this.msM, R.color.navi_op_text, 1);
                            } else {
                                ao.setViewTextColor(PersonChangeActivity.this.msM, R.color.CAM_X0302, 1);
                            }
                        }
                    }
                }
            });
        }
        this.mte.SY();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            dzh();
            this.mtx.onClick(null);
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
                        if (longExtra != this.msZ.dzr().getBirthdayTime() || intExtra != this.msZ.dzr().getBirthdayShowStatus()) {
                            this.msZ.dzr().setBirthdayShowStatus(intExtra);
                            this.msZ.dzr().setBirthdayTime(longExtra);
                            this.mtf = true;
                            this.jUI = true;
                            Date date = new Date(longExtra * 1000);
                            this.mtv.setText(at.p(date));
                            if (this.msZ.dzr().getBirthdayShowStatus() == 2) {
                                this.mtw.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(r(date))));
                                this.mtw.setVisibility(0);
                                return;
                            }
                            this.mtw.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ag(intent);
                            return;
                        } else {
                            af(intent);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.msZ.dzr().setPhotoChanged(true);
                    dzo();
                    this.jUI = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ao.setViewTextColor(this.msM, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ao.setViewTextColor(this.msM, R.color.CAM_X0302, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.msZ.dzr().setPhotoChanged(true);
                    if (intent != null) {
                        this.jav.setImageBitmap(null);
                        this.jav.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.jUI = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ao.setViewTextColor(this.msM, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ao.setViewTextColor(this.msM, R.color.CAM_X0302, 1);
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

    private void QI(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mtg = true;
            this.msZ.dzr().setPhotoChanged(true);
            this.msZ.dzr().setNameShow(str);
            this.msZ.dzr().setNickNameLeftDays(90);
            this.msP.setText(str);
            dzj();
        }
    }

    private void af(Intent intent) {
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
            if (this.mWriteImagesInfo.getChosedFiles() != null && this.mWriteImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.mWriteImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.mWriteImagesInfo.clear();
        }
    }

    private void ag(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, RequestResponseCode.REQUEST_CAMERA_VIEW, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void dzo() {
        if (this.mtb != null) {
            this.mtb.cancel();
        }
        this.mta = null;
        this.mtb = new a();
        this.mtb.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzp() {
        if (this.msZ != null && this.msZ.dzr() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.msZ.dzr()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.mtd.setVisibility(0);
            PersonChangeActivity.this.jav.setImageDrawable(null);
            PersonChangeActivity.this.mta = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public Bitmap doInBackground(Object... objArr) {
            return n.getImage(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.mtb = null;
            PersonChangeActivity.this.mtd.setVisibility(8);
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
            PersonChangeActivity.this.mtb = null;
            PersonChangeActivity.this.mtd.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.mta = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.mta.drawImageTo(PersonChangeActivity.this.jav);
                com.baidu.tbadk.imageManager.c.bGq().a(PersonChangeActivity.this.msZ.dzr().getPortrait(), PersonChangeActivity.this.mta, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzq() {
        Intent intent = new Intent();
        if (this.msL.booleanValue()) {
            intent.putExtra("person_change_data", this.msZ.dzr());
        } else {
            intent.putExtra("data", this.msZ.dzr());
        }
        setResult(-1, intent);
        dzp();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private z cmJ = null;
        private PersonChangeModel msZ;

        public b(PersonChangeModel personChangeModel) {
            this.msZ = null;
            this.msZ = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.mtc = null;
            if (this.cmJ != null) {
                this.cmJ.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.mtc = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.cmJ != null) {
                if (this.cmJ.bvR().bwB().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.dzq();
                } else {
                    PersonChangeActivity.this.showToast(this.cmJ.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.iVZ);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.msZ != null) {
                this.cmJ = new z(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.cmJ.addPostData("sex", String.valueOf(this.msZ.dzr().getSex()));
                this.cmJ.addPostData("intro", this.msZ.dzr().getIntro());
                this.cmJ.addPostData("birthday_time", String.valueOf(this.msZ.dzr().getBirthdayTime()));
                this.cmJ.addPostData("birthday_show_status", String.valueOf(this.msZ.dzr().getBirthdayShowStatus()));
                this.cmJ.postMultiNetData();
                if (this.cmJ.bvR().bwB().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.dQc();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jfV && !TextUtils.isEmpty(this.mtq)) {
            QI(this.mtq);
            this.jfV = false;
            this.mtq = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QJ(String str) {
        if (!StringUtils.isNull(str)) {
            this.mti = true;
            this.mtk.setText(str);
            this.mtj.setClickable(false);
            this.mtl.setVisibility(8);
        }
    }
}
