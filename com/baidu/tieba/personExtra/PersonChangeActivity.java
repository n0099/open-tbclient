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
    private View msO;
    private View mtk;
    private TextView mtl;
    private View mtm;
    private View mtn;
    private View mto;
    private ImageView mtp;
    private com.baidu.tbadk.core.dialog.a mtq;
    private String mtr;
    private LinearLayout mts;
    private TextView mtt;
    private TextView mtu;
    private RelativeLayout mtv;
    private TextView mtw;
    private TextView mtx;
    public final int msL = 90;
    private Boolean msM = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView msN = null;
    private LinearLayout iVh = null;
    private ScrollView msP = null;
    private TextView msQ = null;
    private RelativeLayout msR = null;
    private TextView msS = null;
    private LinearLayout msT = null;
    private TextView gRm = null;
    private EditText msU = null;
    private LinearLayout msV = null;
    private TextView msW = null;
    private TextView msX = null;
    private TextView msY = null;
    private InputMethodManager mInputManager = null;
    private boolean msZ = false;
    private PersonChangeModel mta = null;
    protected HeadImageView jav = null;
    private com.baidu.adp.widget.ImageView.a mtb = null;
    private a mtc = null;
    private b mtd = null;
    private ProgressBar mte = null;
    private DialogInterface.OnCancelListener iVZ = null;
    private com.baidu.tbadk.core.dialog.a kUV = null;
    private com.baidu.tbadk.core.dialog.i mtf = null;
    private boolean mtg = false;
    private boolean jUI = false;
    private boolean mth = false;
    private int mSex = 0;
    private final int mti = 500;
    private boolean mtj = false;
    private boolean jfV = false;
    private final View.OnClickListener mty = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.mta.dzq().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.mtg = true;
            }
            if (PersonChangeActivity.this.mtg) {
                PersonChangeActivity.this.kUV.btX();
                return;
            }
            if (PersonChangeActivity.this.mta != null && PersonChangeActivity.this.mta.dzq().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.msM.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.mta.dzq());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.mta.dzq());
                }
                PersonChangeActivity.this.dzo();
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
                        PersonChangeActivity.this.mtr = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener mtz = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.mta != null && PersonChangeActivity.this.mta.dzq() != null && personChangeData != null) {
                    PersonChangeActivity.this.mta.dzq().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.mta.dzq().setMem(personChangeData.getMen());
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
        bOo();
        if (bundle != null) {
            this.msM = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.msM = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.jgW);
        registerListener(this.mtz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jgW);
        if (this.mtc != null) {
            this.mtc.cancel();
        }
        if (this.mtd != null) {
            this.mtd.cancel();
        }
        if (this.mte != null) {
            this.mte.setVisibility(8);
        }
        if (this.msU != null) {
            this.msU.addTextChangedListener(null);
        }
        if (this.fso != null) {
            this.fso.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jav || view == this.mtp) {
            if (this.mta != null && this.mta.mtD != null && !this.mta.mtD.canModifyAvatar()) {
                if (!StringUtils.isNull(this.mta.mtD.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.mta.mtD.getCantModifyAvatarDesc());
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
                dzj();
            }
        } else if (view == this.msO) {
            if (!this.jUI && !this.mth) {
                finish();
            }
            if (this.msM.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.jUI) {
                dzl();
            } else if (this.mth) {
                dzp();
            }
        } else if (view == this.msR) {
            dzm();
        } else if (view == this.msT) {
            dzh();
        } else if (view == this.msU) {
            Ig(800);
        } else if (view == this.mtn) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                dzf();
            } else {
                int nickNameLeftDays = this.mta.dzq().getNickNameLeftDays();
                if (this.mta.dzq().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.Bp(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).btX();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.mtk) {
            if (this.mta == null || this.mta.dzq() == null || StringUtils.isNull(this.mta.dzq().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.mtv) {
            PersonConstellationActivity.a(getActivity(), this.mta.dzq().getBirthdayTime(), this.mta.dzq().getBirthdayShowStatus());
        }
    }

    private void dzf() {
        if (this.mtq == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.mtq = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.mtq.br(inflate);
            this.mtq.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.dmo(), true)));
                    aVar.dismiss();
                }
            });
            this.mtq.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.mtq.b(getPageContext());
            ao.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), R.color.CAM_X0105);
            ao.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.mtq.btX();
    }

    private void i(AccountData accountData) {
        if (this.fso == null) {
            this.fso = new com.baidu.tbadk.coreExtra.view.b(this);
            this.fso.a(new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.QK(accountData2.getAccount());
                    }
                }
            });
        }
        this.fso.bDb();
        this.fso.setAccountData(accountData);
        this.fso.bCX();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.msZ = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.msZ) {
            dzg();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzg() {
        if (this.msU.getVisibility() == 0) {
            String replaceAll = this.msU.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.gRm.setText(replaceAll);
            } else {
                this.gRm.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.mta.dzq().getIntro() == null || !this.mta.dzq().getIntro().equals(replaceAll)) {
                this.mtg = true;
            }
            this.mta.dzq().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.msU);
        }
    }

    private void dzh() {
        if (this.msU.getVisibility() != 0) {
            this.gRm.setVisibility(8);
            this.msU.setText(this.mta.dzq().getIntro());
            this.msU.setSelection(this.msU.getText().length());
            this.msU.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.msU);
            Ig(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ig(int i) {
        this.msP.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.msP.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aG(Bundle bundle) {
        this.iVZ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.mtd != null) {
                    PersonChangeActivity.this.mtd.cancel();
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
        this.mta = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iVh);
        SvgManager.bwq().a(this.eKe, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jav.refresh();
        ao.setViewTextColor(this.mtl, R.color.CAM_X0109);
        WebPManager.a(this.mtp, R.drawable.icon_mask_personalba_edit40, (WebPManager.ResourceStateType) null);
        ao.setViewTextColor(this.msN, R.color.CAM_X0302, 1);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.mta.dzq() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.mta.dzq()));
        }
    }

    private void bOo() {
        this.mtp = (ImageView) findViewById(R.id.photo_pop_icon);
        this.mtp.setOnClickListener(this);
        this.jav = (HeadImageView) findViewById(R.id.photo);
        this.jav.setOnClickListener(this);
        this.jav.startLoad(q.BQ(this.mta.dzq().getPortrait()), 25, false);
        this.iVh = (LinearLayout) findViewById(R.id.parent);
        this.msP = (ScrollView) findViewById(R.id.person_change_scroll);
        this.msR = (RelativeLayout) findViewById(R.id.person_sex);
        this.msS = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.eKf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.mty);
        this.eKe = (ImageView) this.eKf.findViewById(R.id.widget_navi_back_button);
        this.eKe.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.msO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.msN = (TextView) this.msO.findViewById(R.id.right_textview);
        this.msN.setText(getPageContext().getString(R.string.save));
        ao.setViewTextColor(this.msN, R.color.navi_op_text, 1);
        this.msO.setOnClickListener(this);
        this.msR.setOnClickListener(this);
        this.msT = (LinearLayout) findViewById(R.id.intro_click);
        this.msT.setOnClickListener(this);
        this.msT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.msZ = true;
                    return false;
                }
                return false;
            }
        });
        this.msQ = (TextView) findViewById(R.id.nick_name_show);
        this.msQ.setText(this.mta.dzq().getNameShow());
        this.mtn = findViewById(R.id.person_nickname);
        this.mtn.setOnClickListener(this);
        this.mto = findViewById(R.id.nick_name_more);
        dzi();
        this.mtl = (TextView) findViewById(R.id.user_name_show);
        this.mtk = findViewById(R.id.person_name);
        this.mtm = findViewById(R.id.user_name_more_icon);
        this.mtk.setOnClickListener(this);
        if (StringUtils.isNull(this.mta.dzq().getName())) {
            this.mtl.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.mtj = false;
            this.mtk.setClickable(true);
            this.mtm.setVisibility(0);
        } else {
            this.mtl.setText(this.mta.dzq().getName());
            this.mtj = true;
            this.mtk.setClickable(false);
            this.mtm.setVisibility(8);
        }
        this.msV = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.msW = (TextView) findViewById(R.id.intro_text_tip_num);
        this.msX = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.msY = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.gRm = (TextView) findViewById(R.id.intro);
        this.gRm.setVisibility(8);
        if (this.mta.dzq().getIntro() != null && this.mta.dzq().getIntro().length() > 0) {
            this.gRm.setText(this.mta.dzq().getIntro());
        } else {
            this.gRm.setText(getPageContext().getString(R.string.add_intro));
        }
        this.msU = (EditText) findViewById(R.id.edit);
        this.msU.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.msU.setHintTextColor(ao.getColor(R.color.CAM_X0108));
        this.msU.setCursorVisible(false);
        if (!at.isEmpty(this.mta.dzq().getIntro())) {
            this.msU.setText(this.mta.dzq().getIntro());
            this.msW.setText(this.mta.dzq().getIntro().length() + "");
        } else {
            this.msW.setText("0");
        }
        this.msV.setVisibility(0);
        this.msU.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.dzg();
                }
            }
        });
        this.msU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.msZ = true;
                    PersonChangeActivity.this.msU.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.msU.setOnClickListener(this);
        this.msU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.msU.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.msW.setText(String.valueOf(length));
                PersonChangeActivity.this.msV.setVisibility(0);
                PersonChangeActivity.this.Ig(0);
                PersonChangeActivity.this.dzk();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.msU.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.msU.getSelectionStart() - 1 > PersonChangeActivity.this.msU.getSelectionEnd()) {
                        PersonChangeActivity.this.msU.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.msU.getSelectionStart() - 1, PersonChangeActivity.this.msU.getSelectionEnd());
                        PersonChangeActivity.this.msU.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.msU.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.mta.dzq().getIntro())) {
                    PersonChangeActivity.this.jUI = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ao.setViewTextColor(PersonChangeActivity.this.msN, R.color.navi_op_text, 1);
                    } else {
                        ao.setViewTextColor(PersonChangeActivity.this.msN, R.color.CAM_X0302, 1);
                    }
                }
            }
        });
        if (this.mta.dzq().getSex() == 1) {
            this.mSex = 1;
            this.msS.setText(R.string.male);
        } else if (this.mta.dzq().getSex() == 2) {
            this.mSex = 2;
            this.msS.setText(R.string.female);
        } else {
            this.msS.setText(R.string.change_sex);
        }
        this.mte = (ProgressBar) findViewById(R.id.image_progress);
        this.kUV = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.kUV.Bp(getPageContext().getString(R.string.confirm_giveup));
        this.kUV.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.dzl();
            }
        });
        this.kUV.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.mta.dzq().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.msM.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.mta.dzq());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.mta.dzq());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.dzo();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.kUV.b(getPageContext());
        this.mts = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.mtt = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.mta.dzq().getAlaId() > 0) {
            this.mts.setVisibility(0);
            this.mtt.setText(this.mta.dzq().getAlaId() + "");
        }
        this.mtu = (TextView) findViewById(R.id.person_forum_age_show);
        this.mtu.setText(getResources().getString(R.string.person_forum_age_suffix, this.mta.dzq().getForumAge()));
        this.mtv = (RelativeLayout) findViewById(R.id.person_constellation);
        this.mtv.setOnClickListener(this);
        this.mtw = (TextView) findViewById(R.id.constellation_txt);
        this.mtx = (TextView) findViewById(R.id.age_txt);
        if (this.mta.dzq().getBirthdayTime() != 0) {
            this.mtw.setText(at.p(new Date(this.mta.dzq().getBirthdayTime() * 1000)));
        }
        if (this.mta.dzq().getUserAge() > 0 && this.mta.dzq().getBirthdayShowStatus() == 2) {
            this.mtx.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.mta.dzq().getUserAge())));
            this.mtx.setVisibility(0);
        } else {
            this.mtx.setVisibility(8);
        }
        this.msP.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.msP.scrollTo(0, 0);
            }
        });
    }

    private void dzi() {
        if (NickNameActivitySwitch.isOn() || this.mta.dzq().getNickNameLeftDays() == 0) {
            this.mto.setVisibility(0);
        } else {
            this.mto.setVisibility(8);
        }
    }

    public void dzj() {
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
        bVar.btZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzk() {
        int color;
        if (this.msU.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = ao.getColor(R.color.common_color_10159);
        } else {
            color = ao.getColor(R.color.common_color_10077);
        }
        Ih(color);
    }

    private void Ih(int i) {
        this.msW.setTextColor(i);
        this.msX.setTextColor(i);
        this.msY.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzl() {
        if (this.mta != null && this.mta.dzq() != null) {
            dzg();
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.mta.dzq().setIntro(this.msU.getText().toString().replaceAll("\\s*", ""));
            this.mta.dzq().setSex(this.mSex);
            if (this.mtd == null) {
                this.mtd = new b(this.mta);
                this.mtd.setPriority(3);
                this.mtd.execute(new String[0]);
            }
        }
    }

    private void dzm() {
        if (this.mtf == null) {
            this.mtf = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.mtf.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.mtf != null && PersonChangeActivity.this.mtf.isShowing()) {
                        PersonChangeActivity.this.mtf.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.msS.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.msS.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.mta.dzq().getSex()) {
                            PersonChangeActivity.this.jUI = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                ao.setViewTextColor(PersonChangeActivity.this.msN, R.color.navi_op_text, 1);
                            } else {
                                ao.setViewTextColor(PersonChangeActivity.this.msN, R.color.CAM_X0302, 1);
                            }
                        }
                    }
                }
            });
        }
        this.mtf.SY();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            dzg();
            this.mty.onClick(null);
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
                        if (longExtra != this.mta.dzq().getBirthdayTime() || intExtra != this.mta.dzq().getBirthdayShowStatus()) {
                            this.mta.dzq().setBirthdayShowStatus(intExtra);
                            this.mta.dzq().setBirthdayTime(longExtra);
                            this.mtg = true;
                            this.jUI = true;
                            Date date = new Date(longExtra * 1000);
                            this.mtw.setText(at.p(date));
                            if (this.mta.dzq().getBirthdayShowStatus() == 2) {
                                this.mtx.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(r(date))));
                                this.mtx.setVisibility(0);
                                return;
                            }
                            this.mtx.setVisibility(8);
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
                    this.mta.dzq().setPhotoChanged(true);
                    dzn();
                    this.jUI = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ao.setViewTextColor(this.msN, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ao.setViewTextColor(this.msN, R.color.CAM_X0302, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.mta.dzq().setPhotoChanged(true);
                    if (intent != null) {
                        this.jav.setImageBitmap(null);
                        this.jav.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.jUI = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ao.setViewTextColor(this.msN, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ao.setViewTextColor(this.msN, R.color.CAM_X0302, 1);
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

    private void QJ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mth = true;
            this.mta.dzq().setPhotoChanged(true);
            this.mta.dzq().setNameShow(str);
            this.mta.dzq().setNickNameLeftDays(90);
            this.msQ.setText(str);
            dzi();
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

    private void dzn() {
        if (this.mtc != null) {
            this.mtc.cancel();
        }
        this.mtb = null;
        this.mtc = new a();
        this.mtc.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzo() {
        if (this.mta != null && this.mta.dzq() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.mta.dzq()));
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
            PersonChangeActivity.this.mte.setVisibility(0);
            PersonChangeActivity.this.jav.setImageDrawable(null);
            PersonChangeActivity.this.mtb = null;
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
            PersonChangeActivity.this.mtc = null;
            PersonChangeActivity.this.mte.setVisibility(8);
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
            PersonChangeActivity.this.mtc = null;
            PersonChangeActivity.this.mte.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.mtb = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.mtb.drawImageTo(PersonChangeActivity.this.jav);
                com.baidu.tbadk.imageManager.c.bGp().a(PersonChangeActivity.this.mta.dzq().getPortrait(), PersonChangeActivity.this.mtb, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzp() {
        Intent intent = new Intent();
        if (this.msM.booleanValue()) {
            intent.putExtra("person_change_data", this.mta.dzq());
        } else {
            intent.putExtra("data", this.mta.dzq());
        }
        setResult(-1, intent);
        dzo();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private z cmJ = null;
        private PersonChangeModel mta;

        public b(PersonChangeModel personChangeModel) {
            this.mta = null;
            this.mta = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.mtd = null;
            if (this.cmJ != null) {
                this.cmJ.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.mtd = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.cmJ != null) {
                if (this.cmJ.bvQ().bwA().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.dzp();
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
            if (this.mta != null) {
                this.cmJ = new z(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.cmJ.addPostData("sex", String.valueOf(this.mta.dzq().getSex()));
                this.cmJ.addPostData("intro", this.mta.dzq().getIntro());
                this.cmJ.addPostData("birthday_time", String.valueOf(this.mta.dzq().getBirthdayTime()));
                this.cmJ.addPostData("birthday_show_status", String.valueOf(this.mta.dzq().getBirthdayShowStatus()));
                this.cmJ.postMultiNetData();
                if (this.cmJ.bvQ().bwA().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.dQb();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jfV && !TextUtils.isEmpty(this.mtr)) {
            QJ(this.mtr);
            this.jfV = false;
            this.mtr = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QK(String str) {
        if (!StringUtils.isNull(str)) {
            this.mtj = true;
            this.mtl.setText(str);
            this.mtk.setClickable(false);
            this.mtm.setVisibility(8);
        }
    }
}
