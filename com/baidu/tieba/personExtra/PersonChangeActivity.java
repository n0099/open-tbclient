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
/* loaded from: classes7.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private ImageView eJa;
    private View eJb;
    private com.baidu.tbadk.coreExtra.view.b frx;
    private ImageView mAa;
    private com.baidu.tbadk.core.dialog.a mAb;
    private String mAc;
    private LinearLayout mAd;
    private TextView mAe;
    private TextView mAf;
    private RelativeLayout mAg;
    private TextView mAh;
    private TextView mAi;
    private PermissionJudgePolicy mPermissionJudgement;
    private View mzV;
    private TextView mzW;
    private View mzX;
    private View mzY;
    private View mzZ;
    private View mzz;
    public final int mzw = 90;
    private Boolean mzx = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView mzy = null;
    private LinearLayout iYe = null;
    private ScrollView mzA = null;
    private TextView mzB = null;
    private RelativeLayout mzC = null;
    private TextView mzD = null;
    private LinearLayout mzE = null;
    private TextView gRj = null;
    private EditText mzF = null;
    private LinearLayout mzG = null;
    private TextView mzH = null;
    private TextView mzI = null;
    private TextView mzJ = null;
    private InputMethodManager mInputManager = null;
    private boolean mzK = false;
    private PersonChangeModel mzL = null;
    protected HeadImageView jds = null;
    private com.baidu.adp.widget.ImageView.a mzM = null;
    private a mzN = null;
    private b mzO = null;
    private ProgressBar mzP = null;
    private DialogInterface.OnCancelListener iYW = null;
    private com.baidu.tbadk.core.dialog.a laJ = null;
    private com.baidu.tbadk.core.dialog.i mzQ = null;
    private boolean mzR = false;
    private boolean jZV = false;
    private boolean mzS = false;
    private int mSex = 0;
    private final int mzT = 500;
    private boolean mzU = false;
    private boolean jiS = false;
    private final View.OnClickListener mAj = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.mzL.dxY().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.mzR = true;
            }
            if (PersonChangeActivity.this.mzR) {
                PersonChangeActivity.this.laJ.bqz();
                return;
            }
            if (PersonChangeActivity.this.mzL != null && PersonChangeActivity.this.mzL.dxY().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.mzx.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.mzL.dxY());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.mzL.dxY());
                }
                PersonChangeActivity.this.dxW();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener jjT = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.jiS = true;
                        PersonChangeActivity.this.mAc = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener mAk = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.mzL != null && PersonChangeActivity.this.mzL.dxY() != null && personChangeData != null) {
                    PersonChangeActivity.this.mzL.dxY().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.mzL.dxY().setMem(personChangeData.getMen());
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
        bLa();
        if (bundle != null) {
            this.mzx = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.mzx = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.jjT);
        registerListener(this.mAk);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jjT);
        if (this.mzN != null) {
            this.mzN.cancel();
        }
        if (this.mzO != null) {
            this.mzO.cancel();
        }
        if (this.mzP != null) {
            this.mzP.setVisibility(8);
        }
        if (this.mzF != null) {
            this.mzF.addTextChangedListener(null);
        }
        if (this.frx != null) {
            this.frx.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.jds || view == this.mAa) {
            if (this.mzL != null && this.mzL.mAo != null && !this.mzL.mAo.canModifyAvatar()) {
                if (!StringUtils.isNull(this.mzL.mAo.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.mzL.mAo.getCantModifyAvatarDesc());
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
                dxR();
            }
        } else if (view == this.mzz) {
            if (!this.jZV && !this.mzS) {
                finish();
            }
            if (this.mzx.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.jZV) {
                dxT();
            } else if (this.mzS) {
                dxX();
            }
        } else if (view == this.mzC) {
            dxU();
        } else if (view == this.mzE) {
            dxP();
        } else if (view == this.mzF) {
            GU(800);
        } else if (view == this.mzY) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                dxN();
            } else {
                int nickNameLeftDays = this.mzL.dxY().getNickNameLeftDays();
                if (this.mzL.dxY().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.AB(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).bqz();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.mzV) {
            if (this.mzL == null || this.mzL.dxY() == null || StringUtils.isNull(this.mzL.dxY().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.mAg) {
            PersonConstellationActivity.a(getActivity(), this.mzL.dxY().getBirthdayTime(), this.mzL.dxY().getBirthdayShowStatus());
        }
    }

    private void dxN() {
        if (this.mAb == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.mAb = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.mAb.bn(inflate);
            this.mAb.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.dkZ(), true)));
                    aVar.dismiss();
                }
            });
            this.mAb.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.mAb.b(getPageContext());
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), R.color.CAM_X0105);
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.mAb.bqz();
    }

    private void i(AccountData accountData) {
        if (this.frx == null) {
            this.frx = new com.baidu.tbadk.coreExtra.view.b(this);
            this.frx.a(new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.QA(accountData2.getAccount());
                    }
                }
            });
        }
        this.frx.bzD();
        this.frx.setAccountData(accountData);
        this.frx.bzz();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.mzK = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.mzK) {
            dxO();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxO() {
        if (this.mzF.getVisibility() == 0) {
            String replaceAll = this.mzF.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.gRj.setText(replaceAll);
            } else {
                this.gRj.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.mzL.dxY().getIntro() == null || !this.mzL.dxY().getIntro().equals(replaceAll)) {
                this.mzR = true;
            }
            this.mzL.dxY().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.mzF);
        }
    }

    private void dxP() {
        if (this.mzF.getVisibility() != 0) {
            this.gRj.setVisibility(8);
            this.mzF.setText(this.mzL.dxY().getIntro());
            this.mzF.setSelection(this.mzF.getText().length());
            this.mzF.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mzF);
            GU(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU(int i) {
        this.mzA.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.mzA.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aG(Bundle bundle) {
        this.iYW = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.mzO != null) {
                    PersonChangeActivity.this.mzO.cancel();
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
        this.mzL = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iYe);
        SvgManager.bsU().a(this.eJa, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.jds.refresh();
        ap.setViewTextColor(this.mzW, R.color.CAM_X0109);
        WebPManager.a(this.mAa, R.drawable.icon_mask_personalba_edit40, (WebPManager.ResourceStateType) null);
        ap.setViewTextColor(this.mzy, R.color.CAM_X0302, 1);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.mzL.dxY() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.mzL.dxY()));
        }
    }

    private void bLa() {
        this.mAa = (ImageView) findViewById(R.id.photo_pop_icon);
        this.mAa.setOnClickListener(this);
        this.jds = (HeadImageView) findViewById(R.id.photo);
        this.jds.setOnClickListener(this);
        this.jds.startLoad(r.Bc(this.mzL.dxY().getPortrait()), 25, false);
        this.iYe = (LinearLayout) findViewById(R.id.parent);
        this.mzA = (ScrollView) findViewById(R.id.person_change_scroll);
        this.mzC = (RelativeLayout) findViewById(R.id.person_sex);
        this.mzD = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.eJb = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.mAj);
        this.eJa = (ImageView) this.eJb.findViewById(R.id.widget_navi_back_button);
        this.eJa.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.mzz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.mzy = (TextView) this.mzz.findViewById(R.id.right_textview);
        this.mzy.setText(getPageContext().getString(R.string.save));
        ap.setViewTextColor(this.mzy, R.color.navi_op_text, 1);
        this.mzz.setOnClickListener(this);
        this.mzC.setOnClickListener(this);
        this.mzE = (LinearLayout) findViewById(R.id.intro_click);
        this.mzE.setOnClickListener(this);
        this.mzE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.mzK = true;
                    return false;
                }
                return false;
            }
        });
        this.mzB = (TextView) findViewById(R.id.nick_name_show);
        this.mzB.setText(this.mzL.dxY().getNameShow());
        this.mzY = findViewById(R.id.person_nickname);
        this.mzY.setOnClickListener(this);
        this.mzZ = findViewById(R.id.nick_name_more);
        dxQ();
        this.mzW = (TextView) findViewById(R.id.user_name_show);
        this.mzV = findViewById(R.id.person_name);
        this.mzX = findViewById(R.id.user_name_more_icon);
        this.mzV.setOnClickListener(this);
        if (StringUtils.isNull(this.mzL.dxY().getName())) {
            this.mzW.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.mzU = false;
            this.mzV.setClickable(true);
            this.mzX.setVisibility(0);
        } else {
            this.mzW.setText(this.mzL.dxY().getName());
            this.mzU = true;
            this.mzV.setClickable(false);
            this.mzX.setVisibility(8);
        }
        this.mzG = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.mzH = (TextView) findViewById(R.id.intro_text_tip_num);
        this.mzI = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.mzJ = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.gRj = (TextView) findViewById(R.id.intro);
        this.gRj.setVisibility(8);
        if (this.mzL.dxY().getIntro() != null && this.mzL.dxY().getIntro().length() > 0) {
            this.gRj.setText(this.mzL.dxY().getIntro());
        } else {
            this.gRj.setText(getPageContext().getString(R.string.add_intro));
        }
        this.mzF = (EditText) findViewById(R.id.edit);
        this.mzF.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.mzF.setHintTextColor(ap.getColor(R.color.CAM_X0108));
        this.mzF.setCursorVisible(false);
        if (!au.isEmpty(this.mzL.dxY().getIntro())) {
            this.mzF.setText(this.mzL.dxY().getIntro());
            this.mzH.setText(this.mzL.dxY().getIntro().length() + "");
        } else {
            this.mzH.setText("0");
        }
        this.mzG.setVisibility(0);
        this.mzF.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.dxO();
                }
            }
        });
        this.mzF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.mzK = true;
                    PersonChangeActivity.this.mzF.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.mzF.setOnClickListener(this);
        this.mzF.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.mzF.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.mzH.setText(String.valueOf(length));
                PersonChangeActivity.this.mzG.setVisibility(0);
                PersonChangeActivity.this.GU(0);
                PersonChangeActivity.this.dxS();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.mzF.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.mzF.getSelectionStart() - 1 > PersonChangeActivity.this.mzF.getSelectionEnd()) {
                        PersonChangeActivity.this.mzF.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.mzF.getSelectionStart() - 1, PersonChangeActivity.this.mzF.getSelectionEnd());
                        PersonChangeActivity.this.mzF.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.mzF.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.mzL.dxY().getIntro())) {
                    PersonChangeActivity.this.jZV = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(PersonChangeActivity.this.mzy, R.color.navi_op_text, 1);
                    } else {
                        ap.setViewTextColor(PersonChangeActivity.this.mzy, R.color.CAM_X0302, 1);
                    }
                }
            }
        });
        if (this.mzL.dxY().getSex() == 1) {
            this.mSex = 1;
            this.mzD.setText(R.string.male);
        } else if (this.mzL.dxY().getSex() == 2) {
            this.mSex = 2;
            this.mzD.setText(R.string.female);
        } else {
            this.mzD.setText(R.string.change_sex);
        }
        this.mzP = (ProgressBar) findViewById(R.id.image_progress);
        this.laJ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.laJ.AB(getPageContext().getString(R.string.confirm_giveup));
        this.laJ.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.dxT();
            }
        });
        this.laJ.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.mzL.dxY().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.mzx.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.mzL.dxY());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.mzL.dxY());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.dxW();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.laJ.b(getPageContext());
        this.mAd = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.mAe = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.mzL.dxY().getAlaId() > 0) {
            this.mAd.setVisibility(0);
            this.mAe.setText(this.mzL.dxY().getAlaId() + "");
        }
        this.mAf = (TextView) findViewById(R.id.person_forum_age_show);
        this.mAf.setText(getResources().getString(R.string.person_forum_age_suffix, this.mzL.dxY().getForumAge()));
        this.mAg = (RelativeLayout) findViewById(R.id.person_constellation);
        this.mAg.setOnClickListener(this);
        this.mAh = (TextView) findViewById(R.id.constellation_txt);
        this.mAi = (TextView) findViewById(R.id.age_txt);
        if (this.mzL.dxY().getBirthdayTime() != 0) {
            this.mAh.setText(au.p(new Date(this.mzL.dxY().getBirthdayTime() * 1000)));
        }
        if (this.mzL.dxY().getUserAge() > 0 && this.mzL.dxY().getBirthdayShowStatus() == 2) {
            this.mAi.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.mzL.dxY().getUserAge())));
            this.mAi.setVisibility(0);
        } else {
            this.mAi.setVisibility(8);
        }
        this.mzA.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.mzA.scrollTo(0, 0);
            }
        });
    }

    private void dxQ() {
        if (NickNameActivitySwitch.isOn() || this.mzL.dxY().getNickNameLeftDays() == 0) {
            this.mzZ.setVisibility(0);
        } else {
            this.mzZ.setVisibility(8);
        }
    }

    public void dxR() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.nD(R.string.operation);
        bVar.a(strArr, new b.InterfaceC0564b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
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
        bVar.bqB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxS() {
        int color;
        if (this.mzF.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = ap.getColor(R.color.common_color_10159);
        } else {
            color = ap.getColor(R.color.common_color_10077);
        }
        GV(color);
    }

    private void GV(int i) {
        this.mzH.setTextColor(i);
        this.mzI.setTextColor(i);
        this.mzJ.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxT() {
        if (this.mzL != null && this.mzL.dxY() != null) {
            dxO();
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.mzL.dxY().setIntro(this.mzF.getText().toString().replaceAll("\\s*", ""));
            this.mzL.dxY().setSex(this.mSex);
            if (this.mzO == null) {
                this.mzO = new b(this.mzL);
                this.mzO.setPriority(3);
                this.mzO.execute(new String[0]);
            }
        }
    }

    private void dxU() {
        if (this.mzQ == null) {
            this.mzQ = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.mzQ.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.mzQ != null && PersonChangeActivity.this.mzQ.isShowing()) {
                        PersonChangeActivity.this.mzQ.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.mzD.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.mzD.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.mzL.dxY().getSex()) {
                            PersonChangeActivity.this.jZV = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                ap.setViewTextColor(PersonChangeActivity.this.mzy, R.color.navi_op_text, 1);
                            } else {
                                ap.setViewTextColor(PersonChangeActivity.this.mzy, R.color.CAM_X0302, 1);
                            }
                        }
                    }
                }
            });
        }
        this.mzQ.QH();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            dxO();
            this.mAj.onClick(null);
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
                        if (longExtra != this.mzL.dxY().getBirthdayTime() || intExtra != this.mzL.dxY().getBirthdayShowStatus()) {
                            this.mzL.dxY().setBirthdayShowStatus(intExtra);
                            this.mzL.dxY().setBirthdayTime(longExtra);
                            this.mzR = true;
                            this.jZV = true;
                            Date date = new Date(longExtra * 1000);
                            this.mAh.setText(au.p(date));
                            if (this.mzL.dxY().getBirthdayShowStatus() == 2) {
                                this.mAi.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(r(date))));
                                this.mAi.setVisibility(0);
                                return;
                            }
                            this.mAi.setVisibility(8);
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
                    this.mzL.dxY().setPhotoChanged(true);
                    dxV();
                    this.jZV = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.mzy, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.mzy, R.color.CAM_X0302, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.mzL.dxY().setPhotoChanged(true);
                    if (intent != null) {
                        this.jds.setImageBitmap(null);
                        this.jds.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.jZV = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.mzy, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.mzy, R.color.CAM_X0302, 1);
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

    private void Qz(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mzS = true;
            this.mzL.dxY().setPhotoChanged(true);
            this.mzL.dxY().setNameShow(str);
            this.mzL.dxY().setNickNameLeftDays(90);
            this.mzB.setText(str);
            dxQ();
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

    private void dxV() {
        if (this.mzN != null) {
            this.mzN.cancel();
        }
        this.mzM = null;
        this.mzN = new a();
        this.mzN.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxW() {
        if (this.mzL != null && this.mzL.dxY() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.mzL.dxY()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.mzP.setVisibility(0);
            PersonChangeActivity.this.jds.setImageDrawable(null);
            PersonChangeActivity.this.mzM = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public Bitmap doInBackground(Object... objArr) {
            return o.getImage(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.mzN = null;
            PersonChangeActivity.this.mzP.setVisibility(8);
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
            PersonChangeActivity.this.mzN = null;
            PersonChangeActivity.this.mzP.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.mzM = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.mzM.drawImageTo(PersonChangeActivity.this.jds);
                com.baidu.tbadk.imageManager.c.bCS().a(PersonChangeActivity.this.mzL.dxY().getPortrait(), PersonChangeActivity.this.mzM, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dxX() {
        Intent intent = new Intent();
        if (this.mzx.booleanValue()) {
            intent.putExtra("person_change_data", this.mzL.dxY());
        } else {
            intent.putExtra("data", this.mzL.dxY());
        }
        setResult(-1, intent);
        dxW();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private aa cnM = null;
        private PersonChangeModel mzL;

        public b(PersonChangeModel personChangeModel) {
            this.mzL = null;
            this.mzL = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.mzO = null;
            if (this.cnM != null) {
                this.cnM.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.mzO = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.cnM != null) {
                if (this.cnM.bsu().bte().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.dxX();
                } else {
                    PersonChangeActivity.this.showToast(this.cnM.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.iYW);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.mzL != null) {
                this.cnM = new aa(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.cnM.addPostData("sex", String.valueOf(this.mzL.dxY().getSex()));
                this.cnM.addPostData("intro", this.mzL.dxY().getIntro());
                this.cnM.addPostData("birthday_time", String.valueOf(this.mzL.dxY().getBirthdayTime()));
                this.cnM.addPostData("birthday_show_status", String.valueOf(this.mzL.dxY().getBirthdayShowStatus()));
                this.cnM.postMultiNetData();
                if (this.cnM.bsu().bte().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.dOM();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jiS && !TextUtils.isEmpty(this.mAc)) {
            Qz(this.mAc);
            this.jiS = false;
            this.mAc = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QA(String str) {
        if (!StringUtils.isNull(str)) {
            this.mzU = true;
            this.mzW.setText(str);
            this.mzV.setClickable(false);
            this.mzX.setVisibility(8);
        }
    }
}
