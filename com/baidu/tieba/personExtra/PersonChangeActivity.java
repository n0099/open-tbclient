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
    private com.baidu.tbadk.coreExtra.view.b eWi;
    private ImageView epp;
    private View epq;
    private TextView lTA;
    private View lTB;
    private View lTC;
    private View lTD;
    private View lTE;
    private com.baidu.tbadk.core.dialog.a lTF;
    private String lTG;
    private LinearLayout lTH;
    private TextView lTI;
    private TextView lTJ;
    private RelativeLayout lTK;
    private TextView lTL;
    private TextView lTM;
    private View lTe;
    private View lTz;
    private PermissionJudgePolicy mPermissionJudgement;
    public final int lTc = 90;
    private Boolean lTd = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView kcH = null;
    private LinearLayout irq = null;
    private ScrollView lTf = null;
    private TextView lTg = null;
    private RelativeLayout lTh = null;
    private TextView lTi = null;
    private LinearLayout lTj = null;
    private TextView grt = null;
    private EditText lTk = null;
    private LinearLayout lTl = null;
    private TextView lTm = null;
    private TextView lTn = null;
    private TextView lTo = null;
    private InputMethodManager mInputManager = null;
    private boolean lTp = false;
    private PersonChangeModel lTq = null;
    protected HeadImageView iwE = null;
    private com.baidu.adp.widget.ImageView.a jUJ = null;
    private a lTr = null;
    private b lTs = null;
    private ProgressBar lTt = null;
    private DialogInterface.OnCancelListener isi = null;
    private com.baidu.tbadk.core.dialog.a kvM = null;
    private com.baidu.tbadk.core.dialog.i lTu = null;
    private boolean lTv = false;
    private boolean jnk = false;
    private boolean lTw = false;
    private int mSex = 0;
    private final int lTx = 500;
    private boolean lTy = false;
    private boolean iCg = false;
    private final View.OnClickListener lTN = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.lTq.dsg().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.lTv = true;
            }
            if (PersonChangeActivity.this.lTv) {
                PersonChangeActivity.this.kvM.bmC();
                return;
            }
            if (PersonChangeActivity.this.lTq != null && PersonChangeActivity.this.lTq.dsg().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.lTd.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.lTq.dsg());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.lTq.dsg());
                }
                PersonChangeActivity.this.dse();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener iDf = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.iCg = true;
                        PersonChangeActivity.this.lTG = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener lTO = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.lTq != null && PersonChangeActivity.this.lTq.dsg() != null && personChangeData != null) {
                    PersonChangeActivity.this.lTq.dsg().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.lTq.dsg().setMem(personChangeData.getMen());
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
        bGu();
        if (bundle != null) {
            this.lTd = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.lTd = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.iDf);
        registerListener(this.lTO);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iDf);
        if (this.lTr != null) {
            this.lTr.cancel();
        }
        if (this.lTs != null) {
            this.lTs.cancel();
        }
        if (this.lTt != null) {
            this.lTt.setVisibility(8);
        }
        if (this.lTk != null) {
            this.lTk.addTextChangedListener(null);
        }
        if (this.eWi != null) {
            this.eWi.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iwE || view == this.lTE) {
            if (this.lTq != null && this.lTq.lTS != null && !this.lTq.lTS.canModifyAvatar()) {
                if (!StringUtils.isNull(this.lTq.lTS.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.lTq.lTS.getCantModifyAvatarDesc());
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
                drZ();
            }
        } else if (view == this.lTe) {
            if (!this.jnk && !this.lTw) {
                finish();
            }
            if (this.lTd.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.jnk) {
                dsb();
            } else if (this.lTw) {
                dsf();
            }
        } else if (view == this.lTh) {
            dsc();
        } else if (view == this.lTj) {
            drX();
        } else if (view == this.lTk) {
            GK(800);
        } else if (view == this.lTC) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                drV();
            } else {
                int nickNameLeftDays = this.lTq.dsg().getNickNameLeftDays();
                if (this.lTq.dsg().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.Ba(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).bmC();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays + DlnaManager.DLNA_SUB_ERROR_NETWORK_UNREACHABLE)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.lTz) {
            if (this.lTq == null || this.lTq.dsg() == null || StringUtils.isNull(this.lTq.dsg().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.lTK) {
            PersonConstellationActivity.a(getActivity(), this.lTq.dsg().getBirthdayTime(), this.lTq.dsg().getBirthdayShowStatus());
        }
    }

    private void drV() {
        if (this.lTF == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.lTF = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.lTF.bb(inflate);
            this.lTF.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.dfs(), true)));
                    aVar.dismiss();
                }
            });
            this.lTF.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.lTF.b(getPageContext());
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), R.color.cp_cont_b);
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.lTF.bmC();
    }

    private void i(AccountData accountData) {
        if (this.eWi == null) {
            this.eWi = new com.baidu.tbadk.coreExtra.view.b(this);
            this.eWi.a(new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.Qj(accountData2.getAccount());
                    }
                }
            });
        }
        this.eWi.bvs();
        this.eWi.setAccountData(accountData);
        this.eWi.bvo();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.lTp = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.lTp) {
            drW();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drW() {
        if (this.lTk.getVisibility() == 0) {
            String replaceAll = this.lTk.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.grt.setText(replaceAll);
            } else {
                this.grt.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.lTq.dsg().getIntro() == null || !this.lTq.dsg().getIntro().equals(replaceAll)) {
                this.lTv = true;
            }
            this.lTq.dsg().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.lTk);
        }
    }

    private void drX() {
        if (this.lTk.getVisibility() != 0) {
            this.grt.setVisibility(8);
            this.lTk.setText(this.lTq.dsg().getIntro());
            this.lTk.setSelection(this.lTk.getText().length());
            this.lTk.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.lTk);
            GK(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GK(int i) {
        this.lTf.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.lTf.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aF(Bundle bundle) {
        this.isi = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.lTs != null) {
                    PersonChangeActivity.this.lTs.cancel();
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
        this.lTq = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.irq);
        SvgManager.boN().a(this.epp, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iwE.refresh();
        ap.setViewTextColor(this.lTA, R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.lTq.dsg() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.lTq.dsg()));
        }
    }

    private void bGu() {
        this.lTE = findViewById(R.id.photo_pop_icon);
        this.lTE.setOnClickListener(this);
        this.iwE = (HeadImageView) findViewById(R.id.photo);
        this.iwE.setOnClickListener(this);
        this.iwE.startLoad(q.Bx(this.lTq.dsg().getPortrait()), 25, false);
        this.irq = (LinearLayout) findViewById(R.id.parent);
        this.lTf = (ScrollView) findViewById(R.id.person_change_scroll);
        this.lTh = (RelativeLayout) findViewById(R.id.person_sex);
        this.lTi = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.epq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.lTN);
        this.epp = (ImageView) this.epq.findViewById(R.id.widget_navi_back_button);
        this.epp.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.lTe = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kcH = (TextView) this.lTe.findViewById(R.id.right_textview);
        this.kcH.setText(getPageContext().getString(R.string.save));
        ap.setViewTextColor(this.kcH, R.color.navi_op_text, 1);
        this.lTe.setOnClickListener(this);
        this.lTh.setOnClickListener(this);
        this.lTj = (LinearLayout) findViewById(R.id.intro_click);
        this.lTj.setOnClickListener(this);
        this.lTj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.lTp = true;
                    return false;
                }
                return false;
            }
        });
        this.lTg = (TextView) findViewById(R.id.nick_name_show);
        this.lTg.setText(this.lTq.dsg().getNameShow());
        this.lTC = findViewById(R.id.person_nickname);
        this.lTC.setOnClickListener(this);
        this.lTD = findViewById(R.id.nick_name_more);
        drY();
        this.lTA = (TextView) findViewById(R.id.user_name_show);
        this.lTz = findViewById(R.id.person_name);
        this.lTB = findViewById(R.id.user_name_more_icon);
        this.lTz.setOnClickListener(this);
        if (StringUtils.isNull(this.lTq.dsg().getName())) {
            this.lTA.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.lTy = false;
            this.lTz.setClickable(true);
            this.lTB.setVisibility(0);
        } else {
            this.lTA.setText(this.lTq.dsg().getName());
            this.lTy = true;
            this.lTz.setClickable(false);
            this.lTB.setVisibility(8);
        }
        this.lTl = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.lTm = (TextView) findViewById(R.id.intro_text_tip_num);
        this.lTn = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.lTo = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.grt = (TextView) findViewById(R.id.intro);
        this.grt.setVisibility(8);
        if (this.lTq.dsg().getIntro() != null && this.lTq.dsg().getIntro().length() > 0) {
            this.grt.setText(this.lTq.dsg().getIntro());
        } else {
            this.grt.setText(getPageContext().getString(R.string.add_intro));
        }
        this.lTk = (EditText) findViewById(R.id.edit);
        this.lTk.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.lTk.setHintTextColor(ap.getColor(R.color.cp_cont_c));
        this.lTk.setCursorVisible(false);
        if (!at.isEmpty(this.lTq.dsg().getIntro())) {
            this.lTk.setText(this.lTq.dsg().getIntro());
            this.lTm.setText(this.lTq.dsg().getIntro().length() + "");
        } else {
            this.lTm.setText("0");
        }
        this.lTl.setVisibility(0);
        this.lTk.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.drW();
                }
            }
        });
        this.lTk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.lTp = true;
                    PersonChangeActivity.this.lTk.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.lTk.setOnClickListener(this);
        this.lTk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.lTk.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.lTm.setText(String.valueOf(length));
                PersonChangeActivity.this.lTl.setVisibility(0);
                PersonChangeActivity.this.GK(0);
                PersonChangeActivity.this.dsa();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.lTk.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.lTk.getSelectionStart() - 1 > PersonChangeActivity.this.lTk.getSelectionEnd()) {
                        PersonChangeActivity.this.lTk.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.lTk.getSelectionStart() - 1, PersonChangeActivity.this.lTk.getSelectionEnd());
                        PersonChangeActivity.this.lTk.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.lTk.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.lTq.dsg().getIntro())) {
                    PersonChangeActivity.this.jnk = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(PersonChangeActivity.this.kcH, R.color.navi_op_text, 1);
                    } else {
                        ap.setViewTextColor(PersonChangeActivity.this.kcH, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.lTq.dsg().getSex() == 1) {
            this.mSex = 1;
            this.lTi.setText(R.string.male);
        } else if (this.lTq.dsg().getSex() == 2) {
            this.mSex = 2;
            this.lTi.setText(R.string.female);
        } else {
            this.lTi.setText(R.string.change_sex);
        }
        this.lTt = (ProgressBar) findViewById(R.id.image_progress);
        this.kvM = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.kvM.Ba(getPageContext().getString(R.string.confirm_giveup));
        this.kvM.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.dsb();
            }
        });
        this.kvM.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.lTq.dsg().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.lTd.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.lTq.dsg());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.lTq.dsg());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.dse();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.kvM.b(getPageContext());
        this.lTH = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.lTI = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.lTq.dsg().getAlaId() > 0) {
            this.lTH.setVisibility(0);
            this.lTI.setText(this.lTq.dsg().getAlaId() + "");
        }
        this.lTJ = (TextView) findViewById(R.id.person_forum_age_show);
        this.lTJ.setText(getResources().getString(R.string.person_forum_age_suffix, this.lTq.dsg().getForumAge()));
        this.lTK = (RelativeLayout) findViewById(R.id.person_constellation);
        this.lTK.setOnClickListener(this);
        this.lTL = (TextView) findViewById(R.id.constellation_txt);
        this.lTM = (TextView) findViewById(R.id.age_txt);
        if (this.lTq.dsg().getBirthdayTime() != 0) {
            this.lTL.setText(at.p(new Date(this.lTq.dsg().getBirthdayTime() * 1000)));
        }
        if (this.lTq.dsg().getUserAge() > 0 && this.lTq.dsg().getBirthdayShowStatus() == 2) {
            this.lTM.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.lTq.dsg().getUserAge())));
            this.lTM.setVisibility(0);
        } else {
            this.lTM.setVisibility(8);
        }
        this.lTf.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.lTf.scrollTo(0, 0);
            }
        });
    }

    private void drY() {
        if (NickNameActivitySwitch.isOn() || this.lTq.dsg().getNickNameLeftDays() == 0) {
            this.lTD.setVisibility(0);
        } else {
            this.lTD.setVisibility(8);
        }
    }

    public void drZ() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.or(R.string.operation);
        bVar.a(strArr, new b.InterfaceC0564b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
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
        bVar.bmE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsa() {
        int color;
        if (this.lTk.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = ap.getColor(R.color.common_color_10159);
        } else {
            color = ap.getColor(R.color.common_color_10077);
        }
        GL(color);
    }

    private void GL(int i) {
        this.lTm.setTextColor(i);
        this.lTn.setTextColor(i);
        this.lTo.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsb() {
        if (this.lTq != null && this.lTq.dsg() != null) {
            drW();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.lTq.dsg().setIntro(this.lTk.getText().toString().replaceAll("\\s*", ""));
            this.lTq.dsg().setSex(this.mSex);
            if (this.lTs == null) {
                this.lTs = new b(this.lTq);
                this.lTs.setPriority(3);
                this.lTs.execute(new String[0]);
            }
        }
    }

    private void dsc() {
        if (this.lTu == null) {
            this.lTu = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.lTu.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.lTu != null && PersonChangeActivity.this.lTu.isShowing()) {
                        PersonChangeActivity.this.lTu.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.lTi.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.lTi.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.lTq.dsg().getSex()) {
                            PersonChangeActivity.this.jnk = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                ap.setViewTextColor(PersonChangeActivity.this.kcH, R.color.navi_op_text, 1);
                            } else {
                                ap.setViewTextColor(PersonChangeActivity.this.kcH, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.lTu.PJ();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            drW();
            this.lTN.onClick(null);
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
                        if (longExtra != this.lTq.dsg().getBirthdayTime() || intExtra != this.lTq.dsg().getBirthdayShowStatus()) {
                            this.lTq.dsg().setBirthdayShowStatus(intExtra);
                            this.lTq.dsg().setBirthdayTime(longExtra);
                            this.lTv = true;
                            this.jnk = true;
                            Date date = new Date(longExtra * 1000);
                            this.lTL.setText(at.p(date));
                            if (this.lTq.dsg().getBirthdayShowStatus() == 2) {
                                this.lTM.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(r(date))));
                                this.lTM.setVisibility(0);
                                return;
                            }
                            this.lTM.setVisibility(8);
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
                    this.lTq.dsg().setPhotoChanged(true);
                    dsd();
                    this.jnk = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.kcH, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.kcH, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.lTq.dsg().setPhotoChanged(true);
                    if (intent != null) {
                        this.iwE.setImageBitmap(null);
                        this.iwE.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.jnk = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.kcH, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.kcH, R.color.cp_link_tip_a, 1);
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

    private void Qi(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.lTw = true;
            this.lTq.dsg().setPhotoChanged(true);
            this.lTq.dsg().setNameShow(str);
            this.lTq.dsg().setNickNameLeftDays(90);
            this.lTg.setText(str);
            drY();
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

    private void dsd() {
        if (this.lTr != null) {
            this.lTr.cancel();
        }
        this.jUJ = null;
        this.lTr = new a();
        this.lTr.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dse() {
        if (this.lTq != null && this.lTq.dsg() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.lTq.dsg()));
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
            PersonChangeActivity.this.lTt.setVisibility(0);
            PersonChangeActivity.this.iwE.setImageDrawable(null);
            PersonChangeActivity.this.jUJ = null;
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
            PersonChangeActivity.this.lTr = null;
            PersonChangeActivity.this.lTt.setVisibility(8);
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
            PersonChangeActivity.this.lTr = null;
            PersonChangeActivity.this.lTt.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.jUJ = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.jUJ.drawImageTo(PersonChangeActivity.this.iwE);
                com.baidu.tbadk.imageManager.c.byE().a(PersonChangeActivity.this.lTq.dsg().getPortrait(), PersonChangeActivity.this.jUJ, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dsf() {
        Intent intent = new Intent();
        if (this.lTd.booleanValue()) {
            intent.putExtra("person_change_data", this.lTq.dsg());
        } else {
            intent.putExtra("data", this.lTq.dsg());
        }
        setResult(-1, intent);
        dse();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes24.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private aa bVi = null;
        private PersonChangeModel lTq;

        public b(PersonChangeModel personChangeModel) {
            this.lTq = null;
            this.lTq = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.lTs = null;
            if (this.bVi != null) {
                this.bVi.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.lTs = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.bVi != null) {
                if (this.bVi.bon().boU().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.dsf();
                } else {
                    PersonChangeActivity.this.showToast(this.bVi.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.isi);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.lTq != null) {
                this.bVi = new aa(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.bVi.addPostData("sex", String.valueOf(this.lTq.dsg().getSex()));
                this.bVi.addPostData("intro", this.lTq.dsg().getIntro());
                this.bVi.addPostData("birthday_time", String.valueOf(this.lTq.dsg().getBirthdayTime()));
                this.bVi.addPostData("birthday_show_status", String.valueOf(this.lTq.dsg().getBirthdayShowStatus()));
                this.bVi.postMultiNetData();
                if (this.bVi.bon().boU().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.dIl();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iCg && !TextUtils.isEmpty(this.lTG)) {
            Qi(this.lTG);
            this.iCg = false;
            this.lTG = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qj(String str) {
        if (!StringUtils.isNull(str)) {
            this.lTy = true;
            this.lTA.setText(str);
            this.lTz.setClickable(false);
            this.lTB.setVisibility(8);
        }
    }
}
