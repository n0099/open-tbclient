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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
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
    private ImageView evi;
    private View evj;
    private com.baidu.tbadk.coreExtra.view.b fbX;
    private View lZA;
    private com.baidu.tbadk.core.dialog.a lZB;
    private String lZC;
    private LinearLayout lZD;
    private TextView lZE;
    private TextView lZF;
    private RelativeLayout lZG;
    private TextView lZH;
    private TextView lZI;
    private View lZa;
    private View lZv;
    private TextView lZw;
    private View lZx;
    private View lZy;
    private View lZz;
    private PermissionJudgePolicy mPermissionJudgement;
    public final int lYY = 90;
    private Boolean lYZ = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView kiF = null;
    private LinearLayout ixn = null;
    private ScrollView lZb = null;
    private TextView lZc = null;
    private RelativeLayout lZd = null;
    private TextView lZe = null;
    private LinearLayout lZf = null;
    private TextView gxh = null;
    private EditText lZg = null;
    private LinearLayout lZh = null;
    private TextView lZi = null;
    private TextView lZj = null;
    private TextView lZk = null;
    private InputMethodManager mInputManager = null;
    private boolean lZl = false;
    private PersonChangeModel lZm = null;
    protected HeadImageView iCB = null;
    private com.baidu.adp.widget.ImageView.a kaG = null;
    private a lZn = null;
    private b lZo = null;
    private ProgressBar lZp = null;
    private DialogInterface.OnCancelListener iyf = null;
    private com.baidu.tbadk.core.dialog.a kBH = null;
    private com.baidu.tbadk.core.dialog.i lZq = null;
    private boolean lZr = false;
    private boolean jth = false;
    private boolean lZs = false;
    private int mSex = 0;
    private final int lZt = 500;
    private boolean lZu = false;
    private boolean iId = false;
    private final View.OnClickListener lZJ = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.lZm.duI().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.lZr = true;
            }
            if (PersonChangeActivity.this.lZr) {
                PersonChangeActivity.this.kBH.bpc();
                return;
            }
            if (PersonChangeActivity.this.lZm != null && PersonChangeActivity.this.lZm.duI().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.lYZ.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.lZm.duI());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.lZm.duI());
                }
                PersonChangeActivity.this.duG();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener iJc = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.iId = true;
                        PersonChangeActivity.this.lZC = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener lZK = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.lZm != null && PersonChangeActivity.this.lZm.duI() != null && personChangeData != null) {
                    PersonChangeActivity.this.lZm.duI().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.lZm.duI().setMem(personChangeData.getMen());
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
        aF(bundle);
        bIT();
        if (bundle != null) {
            this.lYZ = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.lYZ = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.iJc);
        registerListener(this.lZK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iJc);
        if (this.lZn != null) {
            this.lZn.cancel();
        }
        if (this.lZo != null) {
            this.lZo.cancel();
        }
        if (this.lZp != null) {
            this.lZp.setVisibility(8);
        }
        if (this.lZg != null) {
            this.lZg.addTextChangedListener(null);
        }
        if (this.fbX != null) {
            this.fbX.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iCB || view == this.lZA) {
            if (this.lZm != null && this.lZm.lZO != null && !this.lZm.lZO.canModifyAvatar()) {
                if (!StringUtils.isNull(this.lZm.lZO.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.lZm.lZO.getCantModifyAvatarDesc());
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
                duB();
            }
        } else if (view == this.lZa) {
            if (!this.jth && !this.lZs) {
                finish();
            }
            if (this.lYZ.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.jth) {
                duD();
            } else if (this.lZs) {
                duH();
            }
        } else if (view == this.lZd) {
            duE();
        } else if (view == this.lZf) {
            duz();
        } else if (view == this.lZg) {
            GX(800);
        } else if (view == this.lZy) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                dux();
            } else {
                int nickNameLeftDays = this.lZm.duI().getNickNameLeftDays();
                if (this.lZm.duI().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.Bo(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).bpc();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays + DlnaManager.DLNA_SUB_ERROR_NETWORK_UNREACHABLE)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.lZv) {
            if (this.lZm == null || this.lZm.duI() == null || StringUtils.isNull(this.lZm.duI().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.lZG) {
            PersonConstellationActivity.a(getActivity(), this.lZm.duI().getBirthdayTime(), this.lZm.duI().getBirthdayShowStatus());
        }
    }

    private void dux() {
        if (this.lZB == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.lZB = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.lZB.bf(inflate);
            this.lZB.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.dhU(), true)));
                    aVar.dismiss();
                }
            });
            this.lZB.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.lZB.b(getPageContext());
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), (int) R.color.cp_cont_b);
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), (int) R.color.common_color_10122);
        }
        this.lZB.bpc();
    }

    private void i(AccountData accountData) {
        if (this.fbX == null) {
            this.fbX = new com.baidu.tbadk.coreExtra.view.b(this);
            this.fbX.a(new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.QA(accountData2.getAccount());
                    }
                }
            });
        }
        this.fbX.bxR();
        this.fbX.setAccountData(accountData);
        this.fbX.bxN();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.lZl = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.lZl) {
            duy();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duy() {
        if (this.lZg.getVisibility() == 0) {
            String replaceAll = this.lZg.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.gxh.setText(replaceAll);
            } else {
                this.gxh.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.lZm.duI().getIntro() == null || !this.lZm.duI().getIntro().equals(replaceAll)) {
                this.lZr = true;
            }
            this.lZm.duI().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.lZg);
        }
    }

    private void duz() {
        if (this.lZg.getVisibility() != 0) {
            this.gxh.setVisibility(8);
            this.lZg.setText(this.lZm.duI().getIntro());
            this.lZg.setSelection(this.lZg.getText().length());
            this.lZg.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.lZg);
            GX(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GX(int i) {
        this.lZb.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.lZb.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aF(Bundle bundle) {
        this.iyf = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.lZo != null) {
                    PersonChangeActivity.this.lZo.cancel();
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
        this.lZm = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.ixn);
        SvgManager.brn().a(this.evi, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iCB.refresh();
        ap.setViewTextColor(this.lZw, (int) R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.lZm.duI() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.lZm.duI()));
        }
    }

    private void bIT() {
        this.lZA = findViewById(R.id.photo_pop_icon);
        this.lZA.setOnClickListener(this);
        this.iCB = (HeadImageView) findViewById(R.id.photo);
        this.iCB.setOnClickListener(this);
        this.iCB.startLoad(q.BL(this.lZm.duI().getPortrait()), 25, false);
        this.ixn = (LinearLayout) findViewById(R.id.parent);
        this.lZb = (ScrollView) findViewById(R.id.person_change_scroll);
        this.lZd = (RelativeLayout) findViewById(R.id.person_sex);
        this.lZe = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.evj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.lZJ);
        this.evi = (ImageView) this.evj.findViewById(R.id.widget_navi_back_button);
        this.evi.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.lZa = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kiF = (TextView) this.lZa.findViewById(R.id.right_textview);
        this.kiF.setText(getPageContext().getString(R.string.save));
        ap.setViewTextColor(this.kiF, R.color.navi_op_text, 1);
        this.lZa.setOnClickListener(this);
        this.lZd.setOnClickListener(this);
        this.lZf = (LinearLayout) findViewById(R.id.intro_click);
        this.lZf.setOnClickListener(this);
        this.lZf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.lZl = true;
                    return false;
                }
                return false;
            }
        });
        this.lZc = (TextView) findViewById(R.id.nick_name_show);
        this.lZc.setText(this.lZm.duI().getNameShow());
        this.lZy = findViewById(R.id.person_nickname);
        this.lZy.setOnClickListener(this);
        this.lZz = findViewById(R.id.nick_name_more);
        duA();
        this.lZw = (TextView) findViewById(R.id.user_name_show);
        this.lZv = findViewById(R.id.person_name);
        this.lZx = findViewById(R.id.user_name_more_icon);
        this.lZv.setOnClickListener(this);
        if (StringUtils.isNull(this.lZm.duI().getName())) {
            this.lZw.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.lZu = false;
            this.lZv.setClickable(true);
            this.lZx.setVisibility(0);
        } else {
            this.lZw.setText(this.lZm.duI().getName());
            this.lZu = true;
            this.lZv.setClickable(false);
            this.lZx.setVisibility(8);
        }
        this.lZh = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.lZi = (TextView) findViewById(R.id.intro_text_tip_num);
        this.lZj = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.lZk = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.gxh = (TextView) findViewById(R.id.intro);
        this.gxh.setVisibility(8);
        if (this.lZm.duI().getIntro() != null && this.lZm.duI().getIntro().length() > 0) {
            this.gxh.setText(this.lZm.duI().getIntro());
        } else {
            this.gxh.setText(getPageContext().getString(R.string.add_intro));
        }
        this.lZg = (EditText) findViewById(R.id.edit);
        this.lZg.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.lZg.setHintTextColor(ap.getColor(R.color.cp_cont_c));
        this.lZg.setCursorVisible(false);
        if (!at.isEmpty(this.lZm.duI().getIntro())) {
            this.lZg.setText(this.lZm.duI().getIntro());
            this.lZi.setText(this.lZm.duI().getIntro().length() + "");
        } else {
            this.lZi.setText("0");
        }
        this.lZh.setVisibility(0);
        this.lZg.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.duy();
                }
            }
        });
        this.lZg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.lZl = true;
                    PersonChangeActivity.this.lZg.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.lZg.setOnClickListener(this);
        this.lZg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.lZg.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.lZi.setText(String.valueOf(length));
                PersonChangeActivity.this.lZh.setVisibility(0);
                PersonChangeActivity.this.GX(0);
                PersonChangeActivity.this.duC();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.lZg.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.lZg.getSelectionStart() - 1 > PersonChangeActivity.this.lZg.getSelectionEnd()) {
                        PersonChangeActivity.this.lZg.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.lZg.getSelectionStart() - 1, PersonChangeActivity.this.lZg.getSelectionEnd());
                        PersonChangeActivity.this.lZg.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.lZg.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.lZm.duI().getIntro())) {
                    PersonChangeActivity.this.jth = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(PersonChangeActivity.this.kiF, R.color.navi_op_text, 1);
                    } else {
                        ap.setViewTextColor(PersonChangeActivity.this.kiF, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.lZm.duI().getSex() == 1) {
            this.mSex = 1;
            this.lZe.setText(R.string.male);
        } else if (this.lZm.duI().getSex() == 2) {
            this.mSex = 2;
            this.lZe.setText(R.string.female);
        } else {
            this.lZe.setText(R.string.change_sex);
        }
        this.lZp = (ProgressBar) findViewById(R.id.image_progress);
        this.kBH = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.kBH.Bo(getPageContext().getString(R.string.confirm_giveup));
        this.kBH.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.duD();
            }
        });
        this.kBH.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.lZm.duI().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.lYZ.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.lZm.duI());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.lZm.duI());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.duG();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.kBH.b(getPageContext());
        this.lZD = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.lZE = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.lZm.duI().getAlaId() > 0) {
            this.lZD.setVisibility(0);
            this.lZE.setText(this.lZm.duI().getAlaId() + "");
        }
        this.lZF = (TextView) findViewById(R.id.person_forum_age_show);
        this.lZF.setText(getResources().getString(R.string.person_forum_age_suffix, this.lZm.duI().getForumAge()));
        this.lZG = (RelativeLayout) findViewById(R.id.person_constellation);
        this.lZG.setOnClickListener(this);
        this.lZH = (TextView) findViewById(R.id.constellation_txt);
        this.lZI = (TextView) findViewById(R.id.age_txt);
        if (this.lZm.duI().getBirthdayTime() != 0) {
            this.lZH.setText(at.p(new Date(this.lZm.duI().getBirthdayTime() * 1000)));
        }
        if (this.lZm.duI().getUserAge() > 0 && this.lZm.duI().getBirthdayShowStatus() == 2) {
            this.lZI.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.lZm.duI().getUserAge())));
            this.lZI.setVisibility(0);
        } else {
            this.lZI.setVisibility(8);
        }
        this.lZb.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.lZb.scrollTo(0, 0);
            }
        });
    }

    private void duA() {
        if (NickNameActivitySwitch.isOn() || this.lZm.duI().getNickNameLeftDays() == 0) {
            this.lZz.setVisibility(0);
        } else {
            this.lZz.setVisibility(8);
        }
    }

    public void duB() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.oB(R.string.operation);
        bVar.a(strArr, new b.InterfaceC0576b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0576b
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
        bVar.bpe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duC() {
        int color;
        if (this.lZg.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = ap.getColor(R.color.common_color_10159);
        } else {
            color = ap.getColor(R.color.common_color_10077);
        }
        GY(color);
    }

    private void GY(int i) {
        this.lZi.setTextColor(i);
        this.lZj.setTextColor(i);
        this.lZk.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duD() {
        if (this.lZm != null && this.lZm.duI() != null) {
            duy();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.lZm.duI().setIntro(this.lZg.getText().toString().replaceAll("\\s*", ""));
            this.lZm.duI().setSex(this.mSex);
            if (this.lZo == null) {
                this.lZo = new b(this.lZm);
                this.lZo.setPriority(3);
                this.lZo.execute(new String[0]);
            }
        }
    }

    private void duE() {
        if (this.lZq == null) {
            this.lZq = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.lZq.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.lZq != null && PersonChangeActivity.this.lZq.isShowing()) {
                        PersonChangeActivity.this.lZq.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.lZe.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.lZe.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.lZm.duI().getSex()) {
                            PersonChangeActivity.this.jth = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                ap.setViewTextColor(PersonChangeActivity.this.kiF, R.color.navi_op_text, 1);
                            } else {
                                ap.setViewTextColor(PersonChangeActivity.this.kiF, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.lZq.Qj();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            duy();
            this.lZJ.onClick(null);
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
                        if (longExtra != this.lZm.duI().getBirthdayTime() || intExtra != this.lZm.duI().getBirthdayShowStatus()) {
                            this.lZm.duI().setBirthdayShowStatus(intExtra);
                            this.lZm.duI().setBirthdayTime(longExtra);
                            this.lZr = true;
                            this.jth = true;
                            Date date = new Date(longExtra * 1000);
                            this.lZH.setText(at.p(date));
                            if (this.lZm.duI().getBirthdayShowStatus() == 2) {
                                this.lZI.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(r(date))));
                                this.lZI.setVisibility(0);
                                return;
                            }
                            this.lZI.setVisibility(8);
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
                    this.lZm.duI().setPhotoChanged(true);
                    duF();
                    this.jth = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.kiF, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.kiF, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.lZm.duI().setPhotoChanged(true);
                    if (intent != null) {
                        this.iCB.setImageBitmap(null);
                        this.iCB.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.jth = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.kiF, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.kiF, R.color.cp_link_tip_a, 1);
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
            this.lZs = true;
            this.lZm.duI().setPhotoChanged(true);
            this.lZm.duI().setNameShow(str);
            this.lZm.duI().setNickNameLeftDays(90);
            this.lZc.setText(str);
            duA();
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

    private void duF() {
        if (this.lZn != null) {
            this.lZn.cancel();
        }
        this.kaG = null;
        this.lZn = new a();
        this.lZn.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duG() {
        if (this.lZm != null && this.lZm.duI() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.lZm.duI()));
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
            PersonChangeActivity.this.lZp.setVisibility(0);
            PersonChangeActivity.this.iCB.setImageDrawable(null);
            PersonChangeActivity.this.kaG = null;
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
            PersonChangeActivity.this.lZn = null;
            PersonChangeActivity.this.lZp.setVisibility(8);
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
            PersonChangeActivity.this.lZn = null;
            PersonChangeActivity.this.lZp.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.kaG = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.kaG.drawImageTo(PersonChangeActivity.this.iCB);
                com.baidu.tbadk.imageManager.c.bBd().a(PersonChangeActivity.this.lZm.duI().getPortrait(), PersonChangeActivity.this.kaG, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duH() {
        Intent intent = new Intent();
        if (this.lYZ.booleanValue()) {
            intent.putExtra("person_change_data", this.lZm.duI());
        } else {
            intent.putExtra("data", this.lZm.duI());
        }
        setResult(-1, intent);
        duG();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private aa caS = null;
        private PersonChangeModel lZm;

        public b(PersonChangeModel personChangeModel) {
            this.lZm = null;
            this.lZm = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.lZo = null;
            if (this.caS != null) {
                this.caS.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.lZo = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.caS != null) {
                if (this.caS.bqN().bru().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.duH();
                } else {
                    PersonChangeActivity.this.showToast(this.caS.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.iyf);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.lZm != null) {
                this.caS = new aa(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.caS.addPostData("sex", String.valueOf(this.lZm.duI().getSex()));
                this.caS.addPostData("intro", this.lZm.duI().getIntro());
                this.caS.addPostData("birthday_time", String.valueOf(this.lZm.duI().getBirthdayTime()));
                this.caS.addPostData("birthday_show_status", String.valueOf(this.lZm.duI().getBirthdayShowStatus()));
                this.caS.postMultiNetData();
                if (this.caS.bqN().bru().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.dKN();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iId && !TextUtils.isEmpty(this.lZC)) {
            Qz(this.lZC);
            this.iId = false;
            this.lZC = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QA(String str) {
        if (!StringUtils.isNull(str)) {
            this.lZu = true;
            this.lZw.setText(str);
            this.lZv.setClickable(false);
            this.lZx.setVisibility(8);
        }
    }
}
