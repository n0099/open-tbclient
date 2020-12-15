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
import com.baidu.cyberplayer.sdk.dlna.DlnaManager;
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
    private ImageView eAB;
    private View eAC;
    private com.baidu.tbadk.coreExtra.view.b fiF;
    private PermissionJudgePolicy mPermissionJudgement;
    private View mnC;
    private View mnX;
    private TextView mnY;
    private View mnZ;
    private View moa;
    private View mob;
    private ImageView moc;
    private com.baidu.tbadk.core.dialog.a mod;
    private String moe;
    private LinearLayout mof;
    private TextView mog;
    private TextView moh;
    private RelativeLayout moi;
    private TextView moj;
    private TextView mok;
    public final int mnA = 90;
    private Boolean mnB = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView kwN = null;
    private LinearLayout iIW = null;
    private ScrollView mnD = null;
    private TextView mnE = null;
    private RelativeLayout mnF = null;
    private TextView mnG = null;
    private LinearLayout mnH = null;
    private TextView gFB = null;
    private EditText mnI = null;
    private LinearLayout mnJ = null;
    private TextView mnK = null;
    private TextView mnL = null;
    private TextView mnM = null;
    private InputMethodManager mInputManager = null;
    private boolean mnN = false;
    private PersonChangeModel mnO = null;
    protected HeadImageView iOk = null;
    private com.baidu.adp.widget.ImageView.a koW = null;
    private a mnP = null;
    private b mnQ = null;
    private ProgressBar mnR = null;
    private DialogInterface.OnCancelListener iJO = null;
    private com.baidu.tbadk.core.dialog.a kPq = null;
    private com.baidu.tbadk.core.dialog.i mnS = null;
    private boolean mnT = false;
    private boolean jHq = false;
    private boolean mnU = false;
    private int mSex = 0;
    private final int mnV = 500;
    private boolean mnW = false;
    private boolean iTK = false;
    private final View.OnClickListener mol = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.mnO.dzB().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.mnT = true;
            }
            if (PersonChangeActivity.this.mnT) {
                PersonChangeActivity.this.kPq.brv();
                return;
            }
            if (PersonChangeActivity.this.mnO != null && PersonChangeActivity.this.mnO.dzB().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.mnB.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.mnO.dzB());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.mnO.dzB());
                }
                PersonChangeActivity.this.dzz();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener iUK = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.iTK = true;
                        PersonChangeActivity.this.moe = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener mom = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.mnO != null && PersonChangeActivity.this.mnO.dzB() != null && personChangeData != null) {
                    PersonChangeActivity.this.mnO.dzB().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.mnO.dzB().setMem(personChangeData.getMen());
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
        bLW();
        if (bundle != null) {
            this.mnB = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.mnB = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.iUK);
        registerListener(this.mom);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iUK);
        if (this.mnP != null) {
            this.mnP.cancel();
        }
        if (this.mnQ != null) {
            this.mnQ.cancel();
        }
        if (this.mnR != null) {
            this.mnR.setVisibility(8);
        }
        if (this.mnI != null) {
            this.mnI.addTextChangedListener(null);
        }
        if (this.fiF != null) {
            this.fiF.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iOk || view == this.moc) {
            if (this.mnO != null && this.mnO.mor != null && !this.mnO.mor.canModifyAvatar()) {
                if (!StringUtils.isNull(this.mnO.mor.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.mnO.mor.getCantModifyAvatarDesc());
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
                dzu();
            }
        } else if (view == this.mnC) {
            if (!this.jHq && !this.mnU) {
                finish();
            }
            if (this.mnB.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.jHq) {
                dzw();
            } else if (this.mnU) {
                dzA();
            }
        } else if (view == this.mnF) {
            dzx();
        } else if (view == this.mnH) {
            dzs();
        } else if (view == this.mnI) {
            Im(800);
        } else if (view == this.moa) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                dzq();
            } else {
                int nickNameLeftDays = this.mnO.dzB().getNickNameLeftDays();
                if (this.mnO.dzB().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.Bq(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).brv();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays + DlnaManager.DLNA_SUB_ERROR_NETWORK_UNREACHABLE)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.mnX) {
            if (this.mnO == null || this.mnO.dzB() == null || StringUtils.isNull(this.mnO.dzB().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.moi) {
            PersonConstellationActivity.a(getActivity(), this.mnO.dzB().getBirthdayTime(), this.mnO.dzB().getBirthdayShowStatus());
        }
    }

    private void dzq() {
        if (this.mod == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.mod = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.mod.bi(inflate);
            this.mod.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.dmE(), true)));
                    aVar.dismiss();
                }
            });
            this.mod.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.mod.b(getPageContext());
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), (int) R.color.CAM_X0105);
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), (int) R.color.common_color_10122);
        }
        this.mod.brv();
    }

    private void i(AccountData accountData) {
        if (this.fiF == null) {
            this.fiF = new com.baidu.tbadk.coreExtra.view.b(this);
            this.fiF.a(new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.Re(accountData2.getAccount());
                    }
                }
            });
        }
        this.fiF.bAH();
        this.fiF.setAccountData(accountData);
        this.fiF.bAD();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.mnN = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.mnN) {
            dzr();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzr() {
        if (this.mnI.getVisibility() == 0) {
            String replaceAll = this.mnI.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.gFB.setText(replaceAll);
            } else {
                this.gFB.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.mnO.dzB().getIntro() == null || !this.mnO.dzB().getIntro().equals(replaceAll)) {
                this.mnT = true;
            }
            this.mnO.dzB().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.mnI);
        }
    }

    private void dzs() {
        if (this.mnI.getVisibility() != 0) {
            this.gFB.setVisibility(8);
            this.mnI.setText(this.mnO.dzB().getIntro());
            this.mnI.setSelection(this.mnI.getText().length());
            this.mnI.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mnI);
            Im(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Im(int i) {
        this.mnD.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.mnD.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aG(Bundle bundle) {
        this.iJO = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.mnQ != null) {
                    PersonChangeActivity.this.mnQ.cancel();
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
        this.mnO = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iIW);
        SvgManager.btW().a(this.eAB, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iOk.refresh();
        ap.setViewTextColor(this.mnY, (int) R.color.CAM_X0109);
        WebPManager.a(this.moc, (int) R.drawable.icon_mask_personalba_edit40, (WebPManager.ResourceStateType) null);
        ap.setViewTextColor(this.kwN, R.color.CAM_X0302, 1);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.mnO.dzB() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.mnO.dzB()));
        }
    }

    private void bLW() {
        this.moc = (ImageView) findViewById(R.id.photo_pop_icon);
        this.moc.setOnClickListener(this);
        this.iOk = (HeadImageView) findViewById(R.id.photo);
        this.iOk.setOnClickListener(this);
        this.iOk.startLoad(q.BR(this.mnO.dzB().getPortrait()), 25, false);
        this.iIW = (LinearLayout) findViewById(R.id.parent);
        this.mnD = (ScrollView) findViewById(R.id.person_change_scroll);
        this.mnF = (RelativeLayout) findViewById(R.id.person_sex);
        this.mnG = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.eAC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.mol);
        this.eAB = (ImageView) this.eAC.findViewById(R.id.widget_navi_back_button);
        this.eAB.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.mnC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kwN = (TextView) this.mnC.findViewById(R.id.right_textview);
        this.kwN.setText(getPageContext().getString(R.string.save));
        ap.setViewTextColor(this.kwN, R.color.navi_op_text, 1);
        this.mnC.setOnClickListener(this);
        this.mnF.setOnClickListener(this);
        this.mnH = (LinearLayout) findViewById(R.id.intro_click);
        this.mnH.setOnClickListener(this);
        this.mnH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.mnN = true;
                    return false;
                }
                return false;
            }
        });
        this.mnE = (TextView) findViewById(R.id.nick_name_show);
        this.mnE.setText(this.mnO.dzB().getNameShow());
        this.moa = findViewById(R.id.person_nickname);
        this.moa.setOnClickListener(this);
        this.mob = findViewById(R.id.nick_name_more);
        dzt();
        this.mnY = (TextView) findViewById(R.id.user_name_show);
        this.mnX = findViewById(R.id.person_name);
        this.mnZ = findViewById(R.id.user_name_more_icon);
        this.mnX.setOnClickListener(this);
        if (StringUtils.isNull(this.mnO.dzB().getName())) {
            this.mnY.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.mnW = false;
            this.mnX.setClickable(true);
            this.mnZ.setVisibility(0);
        } else {
            this.mnY.setText(this.mnO.dzB().getName());
            this.mnW = true;
            this.mnX.setClickable(false);
            this.mnZ.setVisibility(8);
        }
        this.mnJ = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.mnK = (TextView) findViewById(R.id.intro_text_tip_num);
        this.mnL = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.mnM = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.gFB = (TextView) findViewById(R.id.intro);
        this.gFB.setVisibility(8);
        if (this.mnO.dzB().getIntro() != null && this.mnO.dzB().getIntro().length() > 0) {
            this.gFB.setText(this.mnO.dzB().getIntro());
        } else {
            this.gFB.setText(getPageContext().getString(R.string.add_intro));
        }
        this.mnI = (EditText) findViewById(R.id.edit);
        this.mnI.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.mnI.setHintTextColor(ap.getColor(R.color.CAM_X0108));
        this.mnI.setCursorVisible(false);
        if (!au.isEmpty(this.mnO.dzB().getIntro())) {
            this.mnI.setText(this.mnO.dzB().getIntro());
            this.mnK.setText(this.mnO.dzB().getIntro().length() + "");
        } else {
            this.mnK.setText("0");
        }
        this.mnJ.setVisibility(0);
        this.mnI.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.dzr();
                }
            }
        });
        this.mnI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.mnN = true;
                    PersonChangeActivity.this.mnI.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.mnI.setOnClickListener(this);
        this.mnI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.mnI.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.mnK.setText(String.valueOf(length));
                PersonChangeActivity.this.mnJ.setVisibility(0);
                PersonChangeActivity.this.Im(0);
                PersonChangeActivity.this.dzv();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.mnI.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.mnI.getSelectionStart() - 1 > PersonChangeActivity.this.mnI.getSelectionEnd()) {
                        PersonChangeActivity.this.mnI.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.mnI.getSelectionStart() - 1, PersonChangeActivity.this.mnI.getSelectionEnd());
                        PersonChangeActivity.this.mnI.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.mnI.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.mnO.dzB().getIntro())) {
                    PersonChangeActivity.this.jHq = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(PersonChangeActivity.this.kwN, R.color.navi_op_text, 1);
                    } else {
                        ap.setViewTextColor(PersonChangeActivity.this.kwN, R.color.CAM_X0302, 1);
                    }
                }
            }
        });
        if (this.mnO.dzB().getSex() == 1) {
            this.mSex = 1;
            this.mnG.setText(R.string.male);
        } else if (this.mnO.dzB().getSex() == 2) {
            this.mSex = 2;
            this.mnG.setText(R.string.female);
        } else {
            this.mnG.setText(R.string.change_sex);
        }
        this.mnR = (ProgressBar) findViewById(R.id.image_progress);
        this.kPq = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.kPq.Bq(getPageContext().getString(R.string.confirm_giveup));
        this.kPq.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.dzw();
            }
        });
        this.kPq.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.mnO.dzB().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.mnB.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.mnO.dzB());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.mnO.dzB());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.dzz();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.kPq.b(getPageContext());
        this.mof = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.mog = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.mnO.dzB().getAlaId() > 0) {
            this.mof.setVisibility(0);
            this.mog.setText(this.mnO.dzB().getAlaId() + "");
        }
        this.moh = (TextView) findViewById(R.id.person_forum_age_show);
        this.moh.setText(getResources().getString(R.string.person_forum_age_suffix, this.mnO.dzB().getForumAge()));
        this.moi = (RelativeLayout) findViewById(R.id.person_constellation);
        this.moi.setOnClickListener(this);
        this.moj = (TextView) findViewById(R.id.constellation_txt);
        this.mok = (TextView) findViewById(R.id.age_txt);
        if (this.mnO.dzB().getBirthdayTime() != 0) {
            this.moj.setText(au.p(new Date(this.mnO.dzB().getBirthdayTime() * 1000)));
        }
        if (this.mnO.dzB().getUserAge() > 0 && this.mnO.dzB().getBirthdayShowStatus() == 2) {
            this.mok.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.mnO.dzB().getUserAge())));
            this.mok.setVisibility(0);
        } else {
            this.mok.setVisibility(8);
        }
        this.mnD.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.mnD.scrollTo(0, 0);
            }
        });
    }

    private void dzt() {
        if (NickNameActivitySwitch.isOn() || this.mnO.dzB().getNickNameLeftDays() == 0) {
            this.mob.setVisibility(0);
        } else {
            this.mob.setVisibility(8);
        }
    }

    public void dzu() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.oV(R.string.operation);
        bVar.a(strArr, new b.InterfaceC0586b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
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
        bVar.brx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzv() {
        int color;
        if (this.mnI.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = ap.getColor(R.color.common_color_10159);
        } else {
            color = ap.getColor(R.color.common_color_10077);
        }
        In(color);
    }

    private void In(int i) {
        this.mnK.setTextColor(i);
        this.mnL.setTextColor(i);
        this.mnM.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzw() {
        if (this.mnO != null && this.mnO.dzB() != null) {
            dzr();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.mnO.dzB().setIntro(this.mnI.getText().toString().replaceAll("\\s*", ""));
            this.mnO.dzB().setSex(this.mSex);
            if (this.mnQ == null) {
                this.mnQ = new b(this.mnO);
                this.mnQ.setPriority(3);
                this.mnQ.execute(new String[0]);
            }
        }
    }

    private void dzx() {
        if (this.mnS == null) {
            this.mnS = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.mnS.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.mnS != null && PersonChangeActivity.this.mnS.isShowing()) {
                        PersonChangeActivity.this.mnS.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.mnG.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.mnG.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.mnO.dzB().getSex()) {
                            PersonChangeActivity.this.jHq = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                ap.setViewTextColor(PersonChangeActivity.this.kwN, R.color.navi_op_text, 1);
                            } else {
                                ap.setViewTextColor(PersonChangeActivity.this.kwN, R.color.CAM_X0302, 1);
                            }
                        }
                    }
                }
            });
        }
        this.mnS.RU();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            dzr();
            this.mol.onClick(null);
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
                        if (longExtra != this.mnO.dzB().getBirthdayTime() || intExtra != this.mnO.dzB().getBirthdayShowStatus()) {
                            this.mnO.dzB().setBirthdayShowStatus(intExtra);
                            this.mnO.dzB().setBirthdayTime(longExtra);
                            this.mnT = true;
                            this.jHq = true;
                            Date date = new Date(longExtra * 1000);
                            this.moj.setText(au.p(date));
                            if (this.mnO.dzB().getBirthdayShowStatus() == 2) {
                                this.mok.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(r(date))));
                                this.mok.setVisibility(0);
                                return;
                            }
                            this.mok.setVisibility(8);
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
                    this.mnO.dzB().setPhotoChanged(true);
                    dzy();
                    this.jHq = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.kwN, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.kwN, R.color.CAM_X0302, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.mnO.dzB().setPhotoChanged(true);
                    if (intent != null) {
                        this.iOk.setImageBitmap(null);
                        this.iOk.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.jHq = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.kwN, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.kwN, R.color.CAM_X0302, 1);
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

    private void Rd(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mnU = true;
            this.mnO.dzB().setPhotoChanged(true);
            this.mnO.dzB().setNameShow(str);
            this.mnO.dzB().setNickNameLeftDays(90);
            this.mnE.setText(str);
            dzt();
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

    private void dzy() {
        if (this.mnP != null) {
            this.mnP.cancel();
        }
        this.koW = null;
        this.mnP = new a();
        this.mnP.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzz() {
        if (this.mnO != null && this.mnO.dzB() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.mnO.dzB()));
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
            PersonChangeActivity.this.mnR.setVisibility(0);
            PersonChangeActivity.this.iOk.setImageDrawable(null);
            PersonChangeActivity.this.koW = null;
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
            PersonChangeActivity.this.mnP = null;
            PersonChangeActivity.this.mnR.setVisibility(8);
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
            PersonChangeActivity.this.mnP = null;
            PersonChangeActivity.this.mnR.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.koW = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.koW.drawImageTo(PersonChangeActivity.this.iOk);
                com.baidu.tbadk.imageManager.c.bDV().a(PersonChangeActivity.this.mnO.dzB().getPortrait(), PersonChangeActivity.this.koW, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzA() {
        Intent intent = new Intent();
        if (this.mnB.booleanValue()) {
            intent.putExtra("person_change_data", this.mnO.dzB());
        } else {
            intent.putExtra("data", this.mnO.dzB());
        }
        setResult(-1, intent);
        dzz();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private aa cfI = null;
        private PersonChangeModel mnO;

        public b(PersonChangeModel personChangeModel) {
            this.mnO = null;
            this.mnO = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.mnQ = null;
            if (this.cfI != null) {
                this.cfI.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.mnQ = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.cfI != null) {
                if (this.cfI.btv().buf().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.dzA();
                } else {
                    PersonChangeActivity.this.showToast(this.cfI.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.iJO);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.mnO != null) {
                this.cfI = new aa(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.cfI.addPostData("sex", String.valueOf(this.mnO.dzB().getSex()));
                this.cfI.addPostData("intro", this.mnO.dzB().getIntro());
                this.cfI.addPostData("birthday_time", String.valueOf(this.mnO.dzB().getBirthdayTime()));
                this.cfI.addPostData("birthday_show_status", String.valueOf(this.mnO.dzB().getBirthdayShowStatus()));
                this.cfI.postMultiNetData();
                if (this.cfI.btv().buf().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.dQf();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iTK && !TextUtils.isEmpty(this.moe)) {
            Rd(this.moe);
            this.iTK = false;
            this.moe = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Re(String str) {
        if (!StringUtils.isNull(str)) {
            this.mnW = true;
            this.mnY.setText(str);
            this.mnX.setClickable(false);
            this.mnZ.setVisibility(8);
        }
    }
}
