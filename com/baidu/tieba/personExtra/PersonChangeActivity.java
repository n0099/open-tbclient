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
    private View mnA;
    private View mnV;
    private TextView mnW;
    private View mnX;
    private View mnY;
    private View mnZ;
    private ImageView moa;
    private com.baidu.tbadk.core.dialog.a mob;
    private String moc;
    private LinearLayout mod;
    private TextView moe;
    private TextView mof;
    private RelativeLayout mog;
    private TextView moh;
    private TextView moi;
    public final int mny = 90;
    private Boolean mnz = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView kwL = null;
    private LinearLayout iIU = null;
    private ScrollView mnB = null;
    private TextView mnC = null;
    private RelativeLayout mnD = null;
    private TextView mnE = null;
    private LinearLayout mnF = null;
    private TextView gFz = null;
    private EditText mnG = null;
    private LinearLayout mnH = null;
    private TextView mnI = null;
    private TextView mnJ = null;
    private TextView mnK = null;
    private InputMethodManager mInputManager = null;
    private boolean mnL = false;
    private PersonChangeModel mnM = null;
    protected HeadImageView iOi = null;
    private com.baidu.adp.widget.ImageView.a koU = null;
    private a mnN = null;
    private b mnO = null;
    private ProgressBar mnP = null;
    private DialogInterface.OnCancelListener iJM = null;
    private com.baidu.tbadk.core.dialog.a kPo = null;
    private com.baidu.tbadk.core.dialog.i mnQ = null;
    private boolean mnR = false;
    private boolean jHo = false;
    private boolean mnS = false;
    private int mSex = 0;
    private final int mnT = 500;
    private boolean mnU = false;
    private boolean iTI = false;
    private final View.OnClickListener moj = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.mnM.dzA().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.mnR = true;
            }
            if (PersonChangeActivity.this.mnR) {
                PersonChangeActivity.this.kPo.brv();
                return;
            }
            if (PersonChangeActivity.this.mnM != null && PersonChangeActivity.this.mnM.dzA().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.mnz.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.mnM.dzA());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.mnM.dzA());
                }
                PersonChangeActivity.this.dzy();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener iUI = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.iTI = true;
                        PersonChangeActivity.this.moc = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener mok = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.mnM != null && PersonChangeActivity.this.mnM.dzA() != null && personChangeData != null) {
                    PersonChangeActivity.this.mnM.dzA().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.mnM.dzA().setMem(personChangeData.getMen());
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
        bLV();
        if (bundle != null) {
            this.mnz = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.mnz = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.iUI);
        registerListener(this.mok);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iUI);
        if (this.mnN != null) {
            this.mnN.cancel();
        }
        if (this.mnO != null) {
            this.mnO.cancel();
        }
        if (this.mnP != null) {
            this.mnP.setVisibility(8);
        }
        if (this.mnG != null) {
            this.mnG.addTextChangedListener(null);
        }
        if (this.fiF != null) {
            this.fiF.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iOi || view == this.moa) {
            if (this.mnM != null && this.mnM.mop != null && !this.mnM.mop.canModifyAvatar()) {
                if (!StringUtils.isNull(this.mnM.mop.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.mnM.mop.getCantModifyAvatarDesc());
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
                dzt();
            }
        } else if (view == this.mnA) {
            if (!this.jHo && !this.mnS) {
                finish();
            }
            if (this.mnz.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.jHo) {
                dzv();
            } else if (this.mnS) {
                dzz();
            }
        } else if (view == this.mnD) {
            dzw();
        } else if (view == this.mnF) {
            dzr();
        } else if (view == this.mnG) {
            Im(800);
        } else if (view == this.mnY) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                dzp();
            } else {
                int nickNameLeftDays = this.mnM.dzA().getNickNameLeftDays();
                if (this.mnM.dzA().getMen() <= 0) {
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
        } else if (view == this.mnV) {
            if (this.mnM == null || this.mnM.dzA() == null || StringUtils.isNull(this.mnM.dzA().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.mog) {
            PersonConstellationActivity.a(getActivity(), this.mnM.dzA().getBirthdayTime(), this.mnM.dzA().getBirthdayShowStatus());
        }
    }

    private void dzp() {
        if (this.mob == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.mob = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.mob.bi(inflate);
            this.mob.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.dmD(), true)));
                    aVar.dismiss();
                }
            });
            this.mob.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.mob.b(getPageContext());
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), (int) R.color.CAM_X0105);
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), (int) R.color.common_color_10122);
        }
        this.mob.brv();
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
        this.mnL = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.mnL) {
            dzq();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzq() {
        if (this.mnG.getVisibility() == 0) {
            String replaceAll = this.mnG.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.gFz.setText(replaceAll);
            } else {
                this.gFz.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.mnM.dzA().getIntro() == null || !this.mnM.dzA().getIntro().equals(replaceAll)) {
                this.mnR = true;
            }
            this.mnM.dzA().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.mnG);
        }
    }

    private void dzr() {
        if (this.mnG.getVisibility() != 0) {
            this.gFz.setVisibility(8);
            this.mnG.setText(this.mnM.dzA().getIntro());
            this.mnG.setSelection(this.mnG.getText().length());
            this.mnG.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mnG);
            Im(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Im(int i) {
        this.mnB.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.mnB.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aG(Bundle bundle) {
        this.iJM = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.mnO != null) {
                    PersonChangeActivity.this.mnO.cancel();
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
        this.mnM = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iIU);
        SvgManager.btW().a(this.eAB, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iOi.refresh();
        ap.setViewTextColor(this.mnW, (int) R.color.CAM_X0109);
        WebPManager.a(this.moa, (int) R.drawable.icon_mask_personalba_edit40, (WebPManager.ResourceStateType) null);
        ap.setViewTextColor(this.kwL, R.color.CAM_X0302, 1);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.mnM.dzA() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.mnM.dzA()));
        }
    }

    private void bLV() {
        this.moa = (ImageView) findViewById(R.id.photo_pop_icon);
        this.moa.setOnClickListener(this);
        this.iOi = (HeadImageView) findViewById(R.id.photo);
        this.iOi.setOnClickListener(this);
        this.iOi.startLoad(q.BR(this.mnM.dzA().getPortrait()), 25, false);
        this.iIU = (LinearLayout) findViewById(R.id.parent);
        this.mnB = (ScrollView) findViewById(R.id.person_change_scroll);
        this.mnD = (RelativeLayout) findViewById(R.id.person_sex);
        this.mnE = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.eAC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.moj);
        this.eAB = (ImageView) this.eAC.findViewById(R.id.widget_navi_back_button);
        this.eAB.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.mnA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kwL = (TextView) this.mnA.findViewById(R.id.right_textview);
        this.kwL.setText(getPageContext().getString(R.string.save));
        ap.setViewTextColor(this.kwL, R.color.navi_op_text, 1);
        this.mnA.setOnClickListener(this);
        this.mnD.setOnClickListener(this);
        this.mnF = (LinearLayout) findViewById(R.id.intro_click);
        this.mnF.setOnClickListener(this);
        this.mnF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.mnL = true;
                    return false;
                }
                return false;
            }
        });
        this.mnC = (TextView) findViewById(R.id.nick_name_show);
        this.mnC.setText(this.mnM.dzA().getNameShow());
        this.mnY = findViewById(R.id.person_nickname);
        this.mnY.setOnClickListener(this);
        this.mnZ = findViewById(R.id.nick_name_more);
        dzs();
        this.mnW = (TextView) findViewById(R.id.user_name_show);
        this.mnV = findViewById(R.id.person_name);
        this.mnX = findViewById(R.id.user_name_more_icon);
        this.mnV.setOnClickListener(this);
        if (StringUtils.isNull(this.mnM.dzA().getName())) {
            this.mnW.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.mnU = false;
            this.mnV.setClickable(true);
            this.mnX.setVisibility(0);
        } else {
            this.mnW.setText(this.mnM.dzA().getName());
            this.mnU = true;
            this.mnV.setClickable(false);
            this.mnX.setVisibility(8);
        }
        this.mnH = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.mnI = (TextView) findViewById(R.id.intro_text_tip_num);
        this.mnJ = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.mnK = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.gFz = (TextView) findViewById(R.id.intro);
        this.gFz.setVisibility(8);
        if (this.mnM.dzA().getIntro() != null && this.mnM.dzA().getIntro().length() > 0) {
            this.gFz.setText(this.mnM.dzA().getIntro());
        } else {
            this.gFz.setText(getPageContext().getString(R.string.add_intro));
        }
        this.mnG = (EditText) findViewById(R.id.edit);
        this.mnG.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.mnG.setHintTextColor(ap.getColor(R.color.CAM_X0108));
        this.mnG.setCursorVisible(false);
        if (!au.isEmpty(this.mnM.dzA().getIntro())) {
            this.mnG.setText(this.mnM.dzA().getIntro());
            this.mnI.setText(this.mnM.dzA().getIntro().length() + "");
        } else {
            this.mnI.setText("0");
        }
        this.mnH.setVisibility(0);
        this.mnG.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.dzq();
                }
            }
        });
        this.mnG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.mnL = true;
                    PersonChangeActivity.this.mnG.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.mnG.setOnClickListener(this);
        this.mnG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.mnG.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.mnI.setText(String.valueOf(length));
                PersonChangeActivity.this.mnH.setVisibility(0);
                PersonChangeActivity.this.Im(0);
                PersonChangeActivity.this.dzu();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.mnG.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.mnG.getSelectionStart() - 1 > PersonChangeActivity.this.mnG.getSelectionEnd()) {
                        PersonChangeActivity.this.mnG.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.mnG.getSelectionStart() - 1, PersonChangeActivity.this.mnG.getSelectionEnd());
                        PersonChangeActivity.this.mnG.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.mnG.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.mnM.dzA().getIntro())) {
                    PersonChangeActivity.this.jHo = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(PersonChangeActivity.this.kwL, R.color.navi_op_text, 1);
                    } else {
                        ap.setViewTextColor(PersonChangeActivity.this.kwL, R.color.CAM_X0302, 1);
                    }
                }
            }
        });
        if (this.mnM.dzA().getSex() == 1) {
            this.mSex = 1;
            this.mnE.setText(R.string.male);
        } else if (this.mnM.dzA().getSex() == 2) {
            this.mSex = 2;
            this.mnE.setText(R.string.female);
        } else {
            this.mnE.setText(R.string.change_sex);
        }
        this.mnP = (ProgressBar) findViewById(R.id.image_progress);
        this.kPo = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.kPo.Bq(getPageContext().getString(R.string.confirm_giveup));
        this.kPo.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.dzv();
            }
        });
        this.kPo.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.mnM.dzA().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.mnz.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.mnM.dzA());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.mnM.dzA());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.dzy();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.kPo.b(getPageContext());
        this.mod = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.moe = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.mnM.dzA().getAlaId() > 0) {
            this.mod.setVisibility(0);
            this.moe.setText(this.mnM.dzA().getAlaId() + "");
        }
        this.mof = (TextView) findViewById(R.id.person_forum_age_show);
        this.mof.setText(getResources().getString(R.string.person_forum_age_suffix, this.mnM.dzA().getForumAge()));
        this.mog = (RelativeLayout) findViewById(R.id.person_constellation);
        this.mog.setOnClickListener(this);
        this.moh = (TextView) findViewById(R.id.constellation_txt);
        this.moi = (TextView) findViewById(R.id.age_txt);
        if (this.mnM.dzA().getBirthdayTime() != 0) {
            this.moh.setText(au.p(new Date(this.mnM.dzA().getBirthdayTime() * 1000)));
        }
        if (this.mnM.dzA().getUserAge() > 0 && this.mnM.dzA().getBirthdayShowStatus() == 2) {
            this.moi.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.mnM.dzA().getUserAge())));
            this.moi.setVisibility(0);
        } else {
            this.moi.setVisibility(8);
        }
        this.mnB.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.mnB.scrollTo(0, 0);
            }
        });
    }

    private void dzs() {
        if (NickNameActivitySwitch.isOn() || this.mnM.dzA().getNickNameLeftDays() == 0) {
            this.mnZ.setVisibility(0);
        } else {
            this.mnZ.setVisibility(8);
        }
    }

    public void dzt() {
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
    public void dzu() {
        int color;
        if (this.mnG.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = ap.getColor(R.color.common_color_10159);
        } else {
            color = ap.getColor(R.color.common_color_10077);
        }
        In(color);
    }

    private void In(int i) {
        this.mnI.setTextColor(i);
        this.mnJ.setTextColor(i);
        this.mnK.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzv() {
        if (this.mnM != null && this.mnM.dzA() != null) {
            dzq();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.mnM.dzA().setIntro(this.mnG.getText().toString().replaceAll("\\s*", ""));
            this.mnM.dzA().setSex(this.mSex);
            if (this.mnO == null) {
                this.mnO = new b(this.mnM);
                this.mnO.setPriority(3);
                this.mnO.execute(new String[0]);
            }
        }
    }

    private void dzw() {
        if (this.mnQ == null) {
            this.mnQ = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.mnQ.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.mnQ != null && PersonChangeActivity.this.mnQ.isShowing()) {
                        PersonChangeActivity.this.mnQ.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.mnE.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.mnE.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.mnM.dzA().getSex()) {
                            PersonChangeActivity.this.jHo = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                ap.setViewTextColor(PersonChangeActivity.this.kwL, R.color.navi_op_text, 1);
                            } else {
                                ap.setViewTextColor(PersonChangeActivity.this.kwL, R.color.CAM_X0302, 1);
                            }
                        }
                    }
                }
            });
        }
        this.mnQ.RU();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            dzq();
            this.moj.onClick(null);
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
                        if (longExtra != this.mnM.dzA().getBirthdayTime() || intExtra != this.mnM.dzA().getBirthdayShowStatus()) {
                            this.mnM.dzA().setBirthdayShowStatus(intExtra);
                            this.mnM.dzA().setBirthdayTime(longExtra);
                            this.mnR = true;
                            this.jHo = true;
                            Date date = new Date(longExtra * 1000);
                            this.moh.setText(au.p(date));
                            if (this.mnM.dzA().getBirthdayShowStatus() == 2) {
                                this.moi.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(r(date))));
                                this.moi.setVisibility(0);
                                return;
                            }
                            this.moi.setVisibility(8);
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
                    this.mnM.dzA().setPhotoChanged(true);
                    dzx();
                    this.jHo = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.kwL, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.kwL, R.color.CAM_X0302, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.mnM.dzA().setPhotoChanged(true);
                    if (intent != null) {
                        this.iOi.setImageBitmap(null);
                        this.iOi.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.jHo = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.kwL, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.kwL, R.color.CAM_X0302, 1);
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
            this.mnS = true;
            this.mnM.dzA().setPhotoChanged(true);
            this.mnM.dzA().setNameShow(str);
            this.mnM.dzA().setNickNameLeftDays(90);
            this.mnC.setText(str);
            dzs();
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

    private void dzx() {
        if (this.mnN != null) {
            this.mnN.cancel();
        }
        this.koU = null;
        this.mnN = new a();
        this.mnN.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzy() {
        if (this.mnM != null && this.mnM.dzA() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.mnM.dzA()));
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
            PersonChangeActivity.this.mnP.setVisibility(0);
            PersonChangeActivity.this.iOi.setImageDrawable(null);
            PersonChangeActivity.this.koU = null;
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
            PersonChangeActivity.this.mnN = null;
            PersonChangeActivity.this.mnP.setVisibility(8);
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
            PersonChangeActivity.this.mnN = null;
            PersonChangeActivity.this.mnP.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.koU = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.koU.drawImageTo(PersonChangeActivity.this.iOi);
                com.baidu.tbadk.imageManager.c.bDV().a(PersonChangeActivity.this.mnM.dzA().getPortrait(), PersonChangeActivity.this.koU, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dzz() {
        Intent intent = new Intent();
        if (this.mnz.booleanValue()) {
            intent.putExtra("person_change_data", this.mnM.dzA());
        } else {
            intent.putExtra("data", this.mnM.dzA());
        }
        setResult(-1, intent);
        dzy();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private aa cfI = null;
        private PersonChangeModel mnM;

        public b(PersonChangeModel personChangeModel) {
            this.mnM = null;
            this.mnM = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.mnO = null;
            if (this.cfI != null) {
                this.cfI.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.mnO = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.cfI != null) {
                if (this.cfI.btv().buf().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.dzz();
                } else {
                    PersonChangeActivity.this.showToast(this.cfI.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.iJM);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.mnM != null) {
                this.cfI = new aa(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.cfI.addPostData("sex", String.valueOf(this.mnM.dzA().getSex()));
                this.cfI.addPostData("intro", this.mnM.dzA().getIntro());
                this.cfI.addPostData("birthday_time", String.valueOf(this.mnM.dzA().getBirthdayTime()));
                this.cfI.addPostData("birthday_show_status", String.valueOf(this.mnM.dzA().getBirthdayShowStatus()));
                this.cfI.postMultiNetData();
                if (this.cfI.btv().buf().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.dQe();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iTI && !TextUtils.isEmpty(this.moc)) {
            Rd(this.moc);
            this.iTI = false;
            this.moc = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Re(String str) {
        if (!StringUtils.isNull(str)) {
            this.mnU = true;
            this.mnW.setText(str);
            this.mnV.setClickable(false);
            this.mnX.setVisibility(8);
        }
    }
}
