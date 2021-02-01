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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.r;
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
    private View eHA;
    private ImageView eHz;
    private com.baidu.tbadk.coreExtra.view.b fpW;
    private PermissionJudgePolicy mPermissionJudgement;
    private View mxE;
    private TextView mxF;
    private View mxG;
    private View mxH;
    private View mxI;
    private ImageView mxJ;
    private com.baidu.tbadk.core.dialog.a mxK;
    private String mxL;
    private LinearLayout mxM;
    private TextView mxN;
    private TextView mxO;
    private RelativeLayout mxP;
    private TextView mxQ;
    private TextView mxR;
    private View mxi;
    public final int mxf = 90;
    private Boolean mxg = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView mxh = null;
    private LinearLayout iWh = null;
    private ScrollView mxj = null;
    private TextView mxk = null;
    private RelativeLayout mxl = null;
    private TextView mxm = null;
    private LinearLayout mxn = null;
    private TextView gPm = null;
    private EditText mxo = null;
    private LinearLayout mxp = null;
    private TextView mxq = null;
    private TextView mxr = null;
    private TextView mxs = null;
    private InputMethodManager mInputManager = null;
    private boolean mxt = false;
    private PersonChangeModel mxu = null;
    protected HeadImageView jbv = null;
    private com.baidu.adp.widget.ImageView.a mxv = null;
    private a mxw = null;
    private b mxx = null;
    private ProgressBar mxy = null;
    private DialogInterface.OnCancelListener iWZ = null;
    private com.baidu.tbadk.core.dialog.a kYs = null;
    private com.baidu.tbadk.core.dialog.i mxz = null;
    private boolean mxA = false;
    private boolean jXF = false;
    private boolean mxB = false;
    private int mSex = 0;
    private final int mxC = 500;
    private boolean mxD = false;
    private boolean jgU = false;
    private final View.OnClickListener mxS = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.mxu.dxI().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.mxA = true;
            }
            if (PersonChangeActivity.this.mxA) {
                PersonChangeActivity.this.kYs.bqx();
                return;
            }
            if (PersonChangeActivity.this.mxu != null && PersonChangeActivity.this.mxu.dxI().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.mxg.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.mxu.dxI());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.mxu.dxI());
                }
                PersonChangeActivity.this.dxG();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener jhV = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.jgU = true;
                        PersonChangeActivity.this.mxL = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener mxT = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.mxu != null && PersonChangeActivity.this.mxu.dxI() != null && personChangeData != null) {
                    PersonChangeActivity.this.mxu.dxI().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.mxu.dxI().setMem(personChangeData.getMen());
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
        bKR();
        if (bundle != null) {
            this.mxg = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.mxg = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.jhV);
        registerListener(this.mxT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jhV);
        if (this.mxw != null) {
            this.mxw.cancel();
        }
        if (this.mxx != null) {
            this.mxx.cancel();
        }
        if (this.mxy != null) {
            this.mxy.setVisibility(8);
        }
        if (this.mxo != null) {
            this.mxo.addTextChangedListener(null);
        }
        if (this.fpW != null) {
            this.fpW.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jbv || view == this.mxJ) {
            if (this.mxu != null && this.mxu.mxX != null && !this.mxu.mxX.canModifyAvatar()) {
                if (!StringUtils.isNull(this.mxu.mxX.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.mxu.mxX.getCantModifyAvatarDesc());
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
                dxB();
            }
        } else if (view == this.mxi) {
            if (!this.jXF && !this.mxB) {
                finish();
            }
            if (this.mxg.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.jXF) {
                dxD();
            } else if (this.mxB) {
                dxH();
            }
        } else if (view == this.mxl) {
            dxE();
        } else if (view == this.mxn) {
            dxz();
        } else if (view == this.mxo) {
            GR(800);
        } else if (view == this.mxH) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                dxx();
            } else {
                int nickNameLeftDays = this.mxu.dxI().getNickNameLeftDays();
                if (this.mxu.dxI().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.Au(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).bqx();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.mxE) {
            if (this.mxu == null || this.mxu.dxI() == null || StringUtils.isNull(this.mxu.dxI().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.mxP) {
            PersonConstellationActivity.a(getActivity(), this.mxu.dxI().getBirthdayTime(), this.mxu.dxI().getBirthdayShowStatus());
        }
    }

    private void dxx() {
        if (this.mxK == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.mxK = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.mxK.bn(inflate);
            this.mxK.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.dkJ(), true)));
                    aVar.dismiss();
                }
            });
            this.mxK.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.mxK.b(getPageContext());
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), R.color.CAM_X0105);
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.mxK.bqx();
    }

    private void i(AccountData accountData) {
        if (this.fpW == null) {
            this.fpW = new com.baidu.tbadk.coreExtra.view.b(this);
            this.fpW.a(new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.Qt(accountData2.getAccount());
                    }
                }
            });
        }
        this.fpW.bzA();
        this.fpW.setAccountData(accountData);
        this.fpW.bzw();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.mxt = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.mxt) {
            dxy();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxy() {
        if (this.mxo.getVisibility() == 0) {
            String replaceAll = this.mxo.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.gPm.setText(replaceAll);
            } else {
                this.gPm.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.mxu.dxI().getIntro() == null || !this.mxu.dxI().getIntro().equals(replaceAll)) {
                this.mxA = true;
            }
            this.mxu.dxI().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.mxo);
        }
    }

    private void dxz() {
        if (this.mxo.getVisibility() != 0) {
            this.gPm.setVisibility(8);
            this.mxo.setText(this.mxu.dxI().getIntro());
            this.mxo.setSelection(this.mxo.getText().length());
            this.mxo.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mxo);
            GR(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GR(int i) {
        this.mxj.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.mxj.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aG(Bundle bundle) {
        this.iWZ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.mxx != null) {
                    PersonChangeActivity.this.mxx.cancel();
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
        this.mxu = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iWh);
        SvgManager.bsR().a(this.eHz, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jbv.refresh();
        ap.setViewTextColor(this.mxF, R.color.CAM_X0109);
        WebPManager.a(this.mxJ, R.drawable.icon_mask_personalba_edit40, (WebPManager.ResourceStateType) null);
        ap.setViewTextColor(this.mxh, R.color.CAM_X0302, 1);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.mxu.dxI() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.mxu.dxI()));
        }
    }

    private void bKR() {
        this.mxJ = (ImageView) findViewById(R.id.photo_pop_icon);
        this.mxJ.setOnClickListener(this);
        this.jbv = (HeadImageView) findViewById(R.id.photo);
        this.jbv.setOnClickListener(this);
        this.jbv.startLoad(r.AV(this.mxu.dxI().getPortrait()), 25, false);
        this.iWh = (LinearLayout) findViewById(R.id.parent);
        this.mxj = (ScrollView) findViewById(R.id.person_change_scroll);
        this.mxl = (RelativeLayout) findViewById(R.id.person_sex);
        this.mxm = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.eHA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.mxS);
        this.eHz = (ImageView) this.eHA.findViewById(R.id.widget_navi_back_button);
        this.eHz.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.mxi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.mxh = (TextView) this.mxi.findViewById(R.id.right_textview);
        this.mxh.setText(getPageContext().getString(R.string.save));
        ap.setViewTextColor(this.mxh, R.color.navi_op_text, 1);
        this.mxi.setOnClickListener(this);
        this.mxl.setOnClickListener(this);
        this.mxn = (LinearLayout) findViewById(R.id.intro_click);
        this.mxn.setOnClickListener(this);
        this.mxn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.mxt = true;
                    return false;
                }
                return false;
            }
        });
        this.mxk = (TextView) findViewById(R.id.nick_name_show);
        this.mxk.setText(this.mxu.dxI().getNameShow());
        this.mxH = findViewById(R.id.person_nickname);
        this.mxH.setOnClickListener(this);
        this.mxI = findViewById(R.id.nick_name_more);
        dxA();
        this.mxF = (TextView) findViewById(R.id.user_name_show);
        this.mxE = findViewById(R.id.person_name);
        this.mxG = findViewById(R.id.user_name_more_icon);
        this.mxE.setOnClickListener(this);
        if (StringUtils.isNull(this.mxu.dxI().getName())) {
            this.mxF.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.mxD = false;
            this.mxE.setClickable(true);
            this.mxG.setVisibility(0);
        } else {
            this.mxF.setText(this.mxu.dxI().getName());
            this.mxD = true;
            this.mxE.setClickable(false);
            this.mxG.setVisibility(8);
        }
        this.mxp = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.mxq = (TextView) findViewById(R.id.intro_text_tip_num);
        this.mxr = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.mxs = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.gPm = (TextView) findViewById(R.id.intro);
        this.gPm.setVisibility(8);
        if (this.mxu.dxI().getIntro() != null && this.mxu.dxI().getIntro().length() > 0) {
            this.gPm.setText(this.mxu.dxI().getIntro());
        } else {
            this.gPm.setText(getPageContext().getString(R.string.add_intro));
        }
        this.mxo = (EditText) findViewById(R.id.edit);
        this.mxo.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.mxo.setHintTextColor(ap.getColor(R.color.CAM_X0108));
        this.mxo.setCursorVisible(false);
        if (!au.isEmpty(this.mxu.dxI().getIntro())) {
            this.mxo.setText(this.mxu.dxI().getIntro());
            this.mxq.setText(this.mxu.dxI().getIntro().length() + "");
        } else {
            this.mxq.setText("0");
        }
        this.mxp.setVisibility(0);
        this.mxo.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.dxy();
                }
            }
        });
        this.mxo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.mxt = true;
                    PersonChangeActivity.this.mxo.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.mxo.setOnClickListener(this);
        this.mxo.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.mxo.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.mxq.setText(String.valueOf(length));
                PersonChangeActivity.this.mxp.setVisibility(0);
                PersonChangeActivity.this.GR(0);
                PersonChangeActivity.this.dxC();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.mxo.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.mxo.getSelectionStart() - 1 > PersonChangeActivity.this.mxo.getSelectionEnd()) {
                        PersonChangeActivity.this.mxo.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.mxo.getSelectionStart() - 1, PersonChangeActivity.this.mxo.getSelectionEnd());
                        PersonChangeActivity.this.mxo.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.mxo.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.mxu.dxI().getIntro())) {
                    PersonChangeActivity.this.jXF = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(PersonChangeActivity.this.mxh, R.color.navi_op_text, 1);
                    } else {
                        ap.setViewTextColor(PersonChangeActivity.this.mxh, R.color.CAM_X0302, 1);
                    }
                }
            }
        });
        if (this.mxu.dxI().getSex() == 1) {
            this.mSex = 1;
            this.mxm.setText(R.string.male);
        } else if (this.mxu.dxI().getSex() == 2) {
            this.mSex = 2;
            this.mxm.setText(R.string.female);
        } else {
            this.mxm.setText(R.string.change_sex);
        }
        this.mxy = (ProgressBar) findViewById(R.id.image_progress);
        this.kYs = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.kYs.Au(getPageContext().getString(R.string.confirm_giveup));
        this.kYs.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.dxD();
            }
        });
        this.kYs.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.mxu.dxI().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.mxg.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.mxu.dxI());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.mxu.dxI());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.dxG();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.kYs.b(getPageContext());
        this.mxM = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.mxN = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.mxu.dxI().getAlaId() > 0) {
            this.mxM.setVisibility(0);
            this.mxN.setText(this.mxu.dxI().getAlaId() + "");
        }
        this.mxO = (TextView) findViewById(R.id.person_forum_age_show);
        this.mxO.setText(getResources().getString(R.string.person_forum_age_suffix, this.mxu.dxI().getForumAge()));
        this.mxP = (RelativeLayout) findViewById(R.id.person_constellation);
        this.mxP.setOnClickListener(this);
        this.mxQ = (TextView) findViewById(R.id.constellation_txt);
        this.mxR = (TextView) findViewById(R.id.age_txt);
        if (this.mxu.dxI().getBirthdayTime() != 0) {
            this.mxQ.setText(au.p(new Date(this.mxu.dxI().getBirthdayTime() * 1000)));
        }
        if (this.mxu.dxI().getUserAge() > 0 && this.mxu.dxI().getBirthdayShowStatus() == 2) {
            this.mxR.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.mxu.dxI().getUserAge())));
            this.mxR.setVisibility(0);
        } else {
            this.mxR.setVisibility(8);
        }
        this.mxj.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.mxj.scrollTo(0, 0);
            }
        });
    }

    private void dxA() {
        if (NickNameActivitySwitch.isOn() || this.mxu.dxI().getNickNameLeftDays() == 0) {
            this.mxI.setVisibility(0);
        } else {
            this.mxI.setVisibility(8);
        }
    }

    public void dxB() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.nC(R.string.operation);
        bVar.a(strArr, new b.InterfaceC0558b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0558b
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
        bVar.bqz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxC() {
        int color;
        if (this.mxo.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = ap.getColor(R.color.common_color_10159);
        } else {
            color = ap.getColor(R.color.common_color_10077);
        }
        GS(color);
    }

    private void GS(int i) {
        this.mxq.setTextColor(i);
        this.mxr.setTextColor(i);
        this.mxs.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxD() {
        if (this.mxu != null && this.mxu.dxI() != null) {
            dxy();
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.mxu.dxI().setIntro(this.mxo.getText().toString().replaceAll("\\s*", ""));
            this.mxu.dxI().setSex(this.mSex);
            if (this.mxx == null) {
                this.mxx = new b(this.mxu);
                this.mxx.setPriority(3);
                this.mxx.execute(new String[0]);
            }
        }
    }

    private void dxE() {
        if (this.mxz == null) {
            this.mxz = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.mxz.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.mxz != null && PersonChangeActivity.this.mxz.isShowing()) {
                        PersonChangeActivity.this.mxz.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.mxm.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.mxm.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.mxu.dxI().getSex()) {
                            PersonChangeActivity.this.jXF = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                ap.setViewTextColor(PersonChangeActivity.this.mxh, R.color.navi_op_text, 1);
                            } else {
                                ap.setViewTextColor(PersonChangeActivity.this.mxh, R.color.CAM_X0302, 1);
                            }
                        }
                    }
                }
            });
        }
        this.mxz.QE();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            dxy();
            this.mxS.onClick(null);
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
                        if (longExtra != this.mxu.dxI().getBirthdayTime() || intExtra != this.mxu.dxI().getBirthdayShowStatus()) {
                            this.mxu.dxI().setBirthdayShowStatus(intExtra);
                            this.mxu.dxI().setBirthdayTime(longExtra);
                            this.mxA = true;
                            this.jXF = true;
                            Date date = new Date(longExtra * 1000);
                            this.mxQ.setText(au.p(date));
                            if (this.mxu.dxI().getBirthdayShowStatus() == 2) {
                                this.mxR.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(r(date))));
                                this.mxR.setVisibility(0);
                                return;
                            }
                            this.mxR.setVisibility(8);
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
                    this.mxu.dxI().setPhotoChanged(true);
                    dxF();
                    this.jXF = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.mxh, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.mxh, R.color.CAM_X0302, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.mxu.dxI().setPhotoChanged(true);
                    if (intent != null) {
                        this.jbv.setImageBitmap(null);
                        this.jbv.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.jXF = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.mxh, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.mxh, R.color.CAM_X0302, 1);
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

    private void Qs(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mxB = true;
            this.mxu.dxI().setPhotoChanged(true);
            this.mxu.dxI().setNameShow(str);
            this.mxu.dxI().setNickNameLeftDays(90);
            this.mxk.setText(str);
            dxA();
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

    private void dxF() {
        if (this.mxw != null) {
            this.mxw.cancel();
        }
        this.mxv = null;
        this.mxw = new a();
        this.mxw.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxG() {
        if (this.mxu != null && this.mxu.dxI() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.mxu.dxI()));
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
            PersonChangeActivity.this.mxy.setVisibility(0);
            PersonChangeActivity.this.jbv.setImageDrawable(null);
            PersonChangeActivity.this.mxv = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public Bitmap doInBackground(Object... objArr) {
            return o.getImage(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.mxw = null;
            PersonChangeActivity.this.mxy.setVisibility(8);
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
            PersonChangeActivity.this.mxw = null;
            PersonChangeActivity.this.mxy.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.mxv = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.mxv.drawImageTo(PersonChangeActivity.this.jbv);
                com.baidu.tbadk.imageManager.c.bCP().a(PersonChangeActivity.this.mxu.dxI().getPortrait(), PersonChangeActivity.this.mxv, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxH() {
        Intent intent = new Intent();
        if (this.mxg.booleanValue()) {
            intent.putExtra("person_change_data", this.mxu.dxI());
        } else {
            intent.putExtra("data", this.mxu.dxI());
        }
        setResult(-1, intent);
        dxG();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private aa cml = null;
        private PersonChangeModel mxu;

        public b(PersonChangeModel personChangeModel) {
            this.mxu = null;
            this.mxu = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.mxx = null;
            if (this.cml != null) {
                this.cml.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.mxx = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.cml != null) {
                if (this.cml.bsr().btb().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.dxH();
                } else {
                    PersonChangeActivity.this.showToast(this.cml.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.iWZ);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.mxu != null) {
                this.cml = new aa(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.cml.addPostData("sex", String.valueOf(this.mxu.dxI().getSex()));
                this.cml.addPostData("intro", this.mxu.dxI().getIntro());
                this.cml.addPostData("birthday_time", String.valueOf(this.mxu.dxI().getBirthdayTime()));
                this.cml.addPostData("birthday_show_status", String.valueOf(this.mxu.dxI().getBirthdayShowStatus()));
                this.cml.postMultiNetData();
                if (this.cml.bsr().btb().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.dOv();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jgU && !TextUtils.isEmpty(this.mxL)) {
            Qs(this.mxL);
            this.jgU = false;
            this.mxL = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qt(String str) {
        if (!StringUtils.isNull(str)) {
            this.mxD = true;
            this.mxF.setText(str);
            this.mxE.setClickable(false);
            this.mxG.setVisibility(8);
        }
    }
}
