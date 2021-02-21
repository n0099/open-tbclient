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
    private View mxT;
    private TextView mxU;
    private View mxV;
    private View mxW;
    private View mxX;
    private ImageView mxY;
    private com.baidu.tbadk.core.dialog.a mxZ;
    private View mxx;
    private String mya;
    private LinearLayout myb;
    private TextView myc;
    private TextView myd;
    private RelativeLayout mye;
    private TextView myf;
    private TextView myg;
    public final int mxu = 90;
    private Boolean mxv = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView mxw = null;
    private LinearLayout iWv = null;
    private ScrollView mxy = null;
    private TextView mxz = null;
    private RelativeLayout mxA = null;
    private TextView mxB = null;
    private LinearLayout mxC = null;
    private TextView gPA = null;
    private EditText mxD = null;
    private LinearLayout mxE = null;
    private TextView mxF = null;
    private TextView mxG = null;
    private TextView mxH = null;
    private InputMethodManager mInputManager = null;
    private boolean mxI = false;
    private PersonChangeModel mxJ = null;
    protected HeadImageView jbJ = null;
    private com.baidu.adp.widget.ImageView.a mxK = null;
    private a mxL = null;
    private b mxM = null;
    private ProgressBar mxN = null;
    private DialogInterface.OnCancelListener iXn = null;
    private com.baidu.tbadk.core.dialog.a kYG = null;
    private com.baidu.tbadk.core.dialog.i mxO = null;
    private boolean mxP = false;
    private boolean jXT = false;
    private boolean mxQ = false;
    private int mSex = 0;
    private final int mxR = 500;
    private boolean mxS = false;
    private boolean jhi = false;
    private final View.OnClickListener myh = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.mxJ.dxP().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.mxP = true;
            }
            if (PersonChangeActivity.this.mxP) {
                PersonChangeActivity.this.kYG.bqx();
                return;
            }
            if (PersonChangeActivity.this.mxJ != null && PersonChangeActivity.this.mxJ.dxP().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.mxv.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.mxJ.dxP());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.mxJ.dxP());
                }
                PersonChangeActivity.this.dxN();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener jik = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.jhi = true;
                        PersonChangeActivity.this.mya = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener myi = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.mxJ != null && PersonChangeActivity.this.mxJ.dxP() != null && personChangeData != null) {
                    PersonChangeActivity.this.mxJ.dxP().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.mxJ.dxP().setMem(personChangeData.getMen());
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
        bKW();
        if (bundle != null) {
            this.mxv = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.mxv = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.jik);
        registerListener(this.myi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jik);
        if (this.mxL != null) {
            this.mxL.cancel();
        }
        if (this.mxM != null) {
            this.mxM.cancel();
        }
        if (this.mxN != null) {
            this.mxN.setVisibility(8);
        }
        if (this.mxD != null) {
            this.mxD.addTextChangedListener(null);
        }
        if (this.fpW != null) {
            this.fpW.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jbJ || view == this.mxY) {
            if (this.mxJ != null && this.mxJ.mym != null && !this.mxJ.mym.canModifyAvatar()) {
                if (!StringUtils.isNull(this.mxJ.mym.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.mxJ.mym.getCantModifyAvatarDesc());
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
                dxI();
            }
        } else if (view == this.mxx) {
            if (!this.jXT && !this.mxQ) {
                finish();
            }
            if (this.mxv.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.jXT) {
                dxK();
            } else if (this.mxQ) {
                dxO();
            }
        } else if (view == this.mxA) {
            dxL();
        } else if (view == this.mxC) {
            dxG();
        } else if (view == this.mxD) {
            GR(800);
        } else if (view == this.mxW) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                dxE();
            } else {
                int nickNameLeftDays = this.mxJ.dxP().getNickNameLeftDays();
                if (this.mxJ.dxP().getMen() <= 0) {
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
        } else if (view == this.mxT) {
            if (this.mxJ == null || this.mxJ.dxP() == null || StringUtils.isNull(this.mxJ.dxP().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.mye) {
            PersonConstellationActivity.a(getActivity(), this.mxJ.dxP().getBirthdayTime(), this.mxJ.dxP().getBirthdayShowStatus());
        }
    }

    private void dxE() {
        if (this.mxZ == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.mxZ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.mxZ.bn(inflate);
            this.mxZ.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.dkQ(), true)));
                    aVar.dismiss();
                }
            });
            this.mxZ.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.mxZ.b(getPageContext());
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), R.color.CAM_X0105);
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.mxZ.bqx();
    }

    private void i(AccountData accountData) {
        if (this.fpW == null) {
            this.fpW = new com.baidu.tbadk.coreExtra.view.b(this);
            this.fpW.a(new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.Qu(accountData2.getAccount());
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
        this.mxI = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.mxI) {
            dxF();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxF() {
        if (this.mxD.getVisibility() == 0) {
            String replaceAll = this.mxD.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.gPA.setText(replaceAll);
            } else {
                this.gPA.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.mxJ.dxP().getIntro() == null || !this.mxJ.dxP().getIntro().equals(replaceAll)) {
                this.mxP = true;
            }
            this.mxJ.dxP().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.mxD);
        }
    }

    private void dxG() {
        if (this.mxD.getVisibility() != 0) {
            this.gPA.setVisibility(8);
            this.mxD.setText(this.mxJ.dxP().getIntro());
            this.mxD.setSelection(this.mxD.getText().length());
            this.mxD.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mxD);
            GR(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GR(int i) {
        this.mxy.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.mxy.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aG(Bundle bundle) {
        this.iXn = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.mxM != null) {
                    PersonChangeActivity.this.mxM.cancel();
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
        this.mxJ = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iWv);
        SvgManager.bsR().a(this.eHz, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jbJ.refresh();
        ap.setViewTextColor(this.mxU, R.color.CAM_X0109);
        WebPManager.a(this.mxY, R.drawable.icon_mask_personalba_edit40, (WebPManager.ResourceStateType) null);
        ap.setViewTextColor(this.mxw, R.color.CAM_X0302, 1);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.mxJ.dxP() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.mxJ.dxP()));
        }
    }

    private void bKW() {
        this.mxY = (ImageView) findViewById(R.id.photo_pop_icon);
        this.mxY.setOnClickListener(this);
        this.jbJ = (HeadImageView) findViewById(R.id.photo);
        this.jbJ.setOnClickListener(this);
        this.jbJ.startLoad(r.AV(this.mxJ.dxP().getPortrait()), 25, false);
        this.iWv = (LinearLayout) findViewById(R.id.parent);
        this.mxy = (ScrollView) findViewById(R.id.person_change_scroll);
        this.mxA = (RelativeLayout) findViewById(R.id.person_sex);
        this.mxB = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.eHA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.myh);
        this.eHz = (ImageView) this.eHA.findViewById(R.id.widget_navi_back_button);
        this.eHz.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.mxx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.mxw = (TextView) this.mxx.findViewById(R.id.right_textview);
        this.mxw.setText(getPageContext().getString(R.string.save));
        ap.setViewTextColor(this.mxw, R.color.navi_op_text, 1);
        this.mxx.setOnClickListener(this);
        this.mxA.setOnClickListener(this);
        this.mxC = (LinearLayout) findViewById(R.id.intro_click);
        this.mxC.setOnClickListener(this);
        this.mxC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.mxI = true;
                    return false;
                }
                return false;
            }
        });
        this.mxz = (TextView) findViewById(R.id.nick_name_show);
        this.mxz.setText(this.mxJ.dxP().getNameShow());
        this.mxW = findViewById(R.id.person_nickname);
        this.mxW.setOnClickListener(this);
        this.mxX = findViewById(R.id.nick_name_more);
        dxH();
        this.mxU = (TextView) findViewById(R.id.user_name_show);
        this.mxT = findViewById(R.id.person_name);
        this.mxV = findViewById(R.id.user_name_more_icon);
        this.mxT.setOnClickListener(this);
        if (StringUtils.isNull(this.mxJ.dxP().getName())) {
            this.mxU.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.mxS = false;
            this.mxT.setClickable(true);
            this.mxV.setVisibility(0);
        } else {
            this.mxU.setText(this.mxJ.dxP().getName());
            this.mxS = true;
            this.mxT.setClickable(false);
            this.mxV.setVisibility(8);
        }
        this.mxE = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.mxF = (TextView) findViewById(R.id.intro_text_tip_num);
        this.mxG = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.mxH = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.gPA = (TextView) findViewById(R.id.intro);
        this.gPA.setVisibility(8);
        if (this.mxJ.dxP().getIntro() != null && this.mxJ.dxP().getIntro().length() > 0) {
            this.gPA.setText(this.mxJ.dxP().getIntro());
        } else {
            this.gPA.setText(getPageContext().getString(R.string.add_intro));
        }
        this.mxD = (EditText) findViewById(R.id.edit);
        this.mxD.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.mxD.setHintTextColor(ap.getColor(R.color.CAM_X0108));
        this.mxD.setCursorVisible(false);
        if (!au.isEmpty(this.mxJ.dxP().getIntro())) {
            this.mxD.setText(this.mxJ.dxP().getIntro());
            this.mxF.setText(this.mxJ.dxP().getIntro().length() + "");
        } else {
            this.mxF.setText("0");
        }
        this.mxE.setVisibility(0);
        this.mxD.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.dxF();
                }
            }
        });
        this.mxD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.mxI = true;
                    PersonChangeActivity.this.mxD.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.mxD.setOnClickListener(this);
        this.mxD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.mxD.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.mxF.setText(String.valueOf(length));
                PersonChangeActivity.this.mxE.setVisibility(0);
                PersonChangeActivity.this.GR(0);
                PersonChangeActivity.this.dxJ();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.mxD.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.mxD.getSelectionStart() - 1 > PersonChangeActivity.this.mxD.getSelectionEnd()) {
                        PersonChangeActivity.this.mxD.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.mxD.getSelectionStart() - 1, PersonChangeActivity.this.mxD.getSelectionEnd());
                        PersonChangeActivity.this.mxD.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.mxD.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.mxJ.dxP().getIntro())) {
                    PersonChangeActivity.this.jXT = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(PersonChangeActivity.this.mxw, R.color.navi_op_text, 1);
                    } else {
                        ap.setViewTextColor(PersonChangeActivity.this.mxw, R.color.CAM_X0302, 1);
                    }
                }
            }
        });
        if (this.mxJ.dxP().getSex() == 1) {
            this.mSex = 1;
            this.mxB.setText(R.string.male);
        } else if (this.mxJ.dxP().getSex() == 2) {
            this.mSex = 2;
            this.mxB.setText(R.string.female);
        } else {
            this.mxB.setText(R.string.change_sex);
        }
        this.mxN = (ProgressBar) findViewById(R.id.image_progress);
        this.kYG = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.kYG.Au(getPageContext().getString(R.string.confirm_giveup));
        this.kYG.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.dxK();
            }
        });
        this.kYG.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.mxJ.dxP().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.mxv.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.mxJ.dxP());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.mxJ.dxP());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.dxN();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.kYG.b(getPageContext());
        this.myb = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.myc = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.mxJ.dxP().getAlaId() > 0) {
            this.myb.setVisibility(0);
            this.myc.setText(this.mxJ.dxP().getAlaId() + "");
        }
        this.myd = (TextView) findViewById(R.id.person_forum_age_show);
        this.myd.setText(getResources().getString(R.string.person_forum_age_suffix, this.mxJ.dxP().getForumAge()));
        this.mye = (RelativeLayout) findViewById(R.id.person_constellation);
        this.mye.setOnClickListener(this);
        this.myf = (TextView) findViewById(R.id.constellation_txt);
        this.myg = (TextView) findViewById(R.id.age_txt);
        if (this.mxJ.dxP().getBirthdayTime() != 0) {
            this.myf.setText(au.p(new Date(this.mxJ.dxP().getBirthdayTime() * 1000)));
        }
        if (this.mxJ.dxP().getUserAge() > 0 && this.mxJ.dxP().getBirthdayShowStatus() == 2) {
            this.myg.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.mxJ.dxP().getUserAge())));
            this.myg.setVisibility(0);
        } else {
            this.myg.setVisibility(8);
        }
        this.mxy.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.mxy.scrollTo(0, 0);
            }
        });
    }

    private void dxH() {
        if (NickNameActivitySwitch.isOn() || this.mxJ.dxP().getNickNameLeftDays() == 0) {
            this.mxX.setVisibility(0);
        } else {
            this.mxX.setVisibility(8);
        }
    }

    public void dxI() {
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
    public void dxJ() {
        int color;
        if (this.mxD.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = ap.getColor(R.color.common_color_10159);
        } else {
            color = ap.getColor(R.color.common_color_10077);
        }
        GS(color);
    }

    private void GS(int i) {
        this.mxF.setTextColor(i);
        this.mxG.setTextColor(i);
        this.mxH.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxK() {
        if (this.mxJ != null && this.mxJ.dxP() != null) {
            dxF();
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.mxJ.dxP().setIntro(this.mxD.getText().toString().replaceAll("\\s*", ""));
            this.mxJ.dxP().setSex(this.mSex);
            if (this.mxM == null) {
                this.mxM = new b(this.mxJ);
                this.mxM.setPriority(3);
                this.mxM.execute(new String[0]);
            }
        }
    }

    private void dxL() {
        if (this.mxO == null) {
            this.mxO = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.mxO.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.mxO != null && PersonChangeActivity.this.mxO.isShowing()) {
                        PersonChangeActivity.this.mxO.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.mxB.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.mxB.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.mxJ.dxP().getSex()) {
                            PersonChangeActivity.this.jXT = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                ap.setViewTextColor(PersonChangeActivity.this.mxw, R.color.navi_op_text, 1);
                            } else {
                                ap.setViewTextColor(PersonChangeActivity.this.mxw, R.color.CAM_X0302, 1);
                            }
                        }
                    }
                }
            });
        }
        this.mxO.QE();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            dxF();
            this.myh.onClick(null);
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
                        if (longExtra != this.mxJ.dxP().getBirthdayTime() || intExtra != this.mxJ.dxP().getBirthdayShowStatus()) {
                            this.mxJ.dxP().setBirthdayShowStatus(intExtra);
                            this.mxJ.dxP().setBirthdayTime(longExtra);
                            this.mxP = true;
                            this.jXT = true;
                            Date date = new Date(longExtra * 1000);
                            this.myf.setText(au.p(date));
                            if (this.mxJ.dxP().getBirthdayShowStatus() == 2) {
                                this.myg.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(r(date))));
                                this.myg.setVisibility(0);
                                return;
                            }
                            this.myg.setVisibility(8);
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
                    this.mxJ.dxP().setPhotoChanged(true);
                    dxM();
                    this.jXT = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.mxw, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.mxw, R.color.CAM_X0302, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.mxJ.dxP().setPhotoChanged(true);
                    if (intent != null) {
                        this.jbJ.setImageBitmap(null);
                        this.jbJ.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.jXT = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.mxw, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.mxw, R.color.CAM_X0302, 1);
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

    private void Qt(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mxQ = true;
            this.mxJ.dxP().setPhotoChanged(true);
            this.mxJ.dxP().setNameShow(str);
            this.mxJ.dxP().setNickNameLeftDays(90);
            this.mxz.setText(str);
            dxH();
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

    private void dxM() {
        if (this.mxL != null) {
            this.mxL.cancel();
        }
        this.mxK = null;
        this.mxL = new a();
        this.mxL.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxN() {
        if (this.mxJ != null && this.mxJ.dxP() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.mxJ.dxP()));
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
            PersonChangeActivity.this.mxN.setVisibility(0);
            PersonChangeActivity.this.jbJ.setImageDrawable(null);
            PersonChangeActivity.this.mxK = null;
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
            PersonChangeActivity.this.mxL = null;
            PersonChangeActivity.this.mxN.setVisibility(8);
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
            PersonChangeActivity.this.mxL = null;
            PersonChangeActivity.this.mxN.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.mxK = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.mxK.drawImageTo(PersonChangeActivity.this.jbJ);
                com.baidu.tbadk.imageManager.c.bCP().a(PersonChangeActivity.this.mxJ.dxP().getPortrait(), PersonChangeActivity.this.mxK, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxO() {
        Intent intent = new Intent();
        if (this.mxv.booleanValue()) {
            intent.putExtra("person_change_data", this.mxJ.dxP());
        } else {
            intent.putExtra("data", this.mxJ.dxP());
        }
        setResult(-1, intent);
        dxN();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private aa cml = null;
        private PersonChangeModel mxJ;

        public b(PersonChangeModel personChangeModel) {
            this.mxJ = null;
            this.mxJ = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.mxM = null;
            if (this.cml != null) {
                this.cml.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.mxM = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.cml != null) {
                if (this.cml.bsr().btb().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.dxO();
                } else {
                    PersonChangeActivity.this.showToast(this.cml.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.iXn);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.mxJ != null) {
                this.cml = new aa(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.cml.addPostData("sex", String.valueOf(this.mxJ.dxP().getSex()));
                this.cml.addPostData("intro", this.mxJ.dxP().getIntro());
                this.cml.addPostData("birthday_time", String.valueOf(this.mxJ.dxP().getBirthdayTime()));
                this.cml.addPostData("birthday_show_status", String.valueOf(this.mxJ.dxP().getBirthdayShowStatus()));
                this.cml.postMultiNetData();
                if (this.cml.bsr().btb().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.dOD();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jhi && !TextUtils.isEmpty(this.mya)) {
            Qt(this.mya);
            this.jhi = false;
            this.mya = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qu(String str) {
        if (!StringUtils.isNull(str)) {
            this.mxS = true;
            this.mxU.setText(str);
            this.mxT.setClickable(false);
            this.mxV.setVisibility(8);
        }
    }
}
