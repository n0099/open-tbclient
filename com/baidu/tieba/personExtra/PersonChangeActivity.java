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
/* loaded from: classes23.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private ImageView dUP;
    private View dUQ;
    private com.baidu.tbadk.coreExtra.view.b eBF;
    private View lrQ;
    private TextView lrR;
    private View lrS;
    private View lrT;
    private View lrU;
    private View lrV;
    private com.baidu.tbadk.core.dialog.a lrW;
    private String lrX;
    private LinearLayout lrY;
    private TextView lrZ;
    private View lrv;
    private TextView lsa;
    private RelativeLayout lsb;
    private TextView lsc;
    private TextView lsd;
    private PermissionJudgePolicy mPermissionJudgement;
    public final int lrt = 90;
    private Boolean lru = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView jBl = null;
    private LinearLayout hPT = null;
    private ScrollView lrw = null;
    private TextView lrx = null;
    private RelativeLayout lry = null;
    private TextView lrz = null;
    private LinearLayout lrA = null;
    private TextView fUX = null;
    private EditText lrB = null;
    private LinearLayout lrC = null;
    private TextView lrD = null;
    private TextView lrE = null;
    private TextView lrF = null;
    private InputMethodManager mInputManager = null;
    private boolean lrG = false;
    private PersonChangeModel lrH = null;
    protected HeadImageView hVh = null;
    private com.baidu.adp.widget.ImageView.a jtn = null;
    private a lrI = null;
    private b lrJ = null;
    private ProgressBar lrK = null;
    private DialogInterface.OnCancelListener hQL = null;
    private com.baidu.tbadk.core.dialog.a jUp = null;
    private com.baidu.tbadk.core.dialog.i lrL = null;
    private boolean lrM = false;
    private boolean iLX = false;
    private boolean lrN = false;
    private int mSex = 0;
    private final int lrO = 500;
    private boolean lrP = false;
    private boolean iaJ = false;
    private final View.OnClickListener lse = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.lrH.dlp().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.lrM = true;
            }
            if (PersonChangeActivity.this.lrM) {
                PersonChangeActivity.this.jUp.bia();
                return;
            }
            if (PersonChangeActivity.this.lrH != null && PersonChangeActivity.this.lrH.dlp().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.lru.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.lrH.dlp());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.lrH.dlp());
                }
                PersonChangeActivity.this.dln();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener ibI = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.iaJ = true;
                        PersonChangeActivity.this.lrX = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener lsf = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.lrH != null && PersonChangeActivity.this.lrH.dlp() != null && personChangeData != null) {
                    PersonChangeActivity.this.lrH.dlp().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.lrH.dlp().setMem(personChangeData.getMen());
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
        bBP();
        if (bundle != null) {
            this.lru = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.lru = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.ibI);
        registerListener(this.lsf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.ibI);
        if (this.lrI != null) {
            this.lrI.cancel();
        }
        if (this.lrJ != null) {
            this.lrJ.cancel();
        }
        if (this.lrK != null) {
            this.lrK.setVisibility(8);
        }
        if (this.lrB != null) {
            this.lrB.addTextChangedListener(null);
        }
        if (this.eBF != null) {
            this.eBF.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.hVh || view == this.lrV) {
            if (this.lrH != null && this.lrH.lsj != null && !this.lrH.lsj.canModifyAvatar()) {
                if (!StringUtils.isNull(this.lrH.lsj.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.lrH.lsj.getCantModifyAvatarDesc());
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
                dli();
            }
        } else if (view == this.lrv) {
            if (!this.iLX && !this.lrN) {
                finish();
            }
            if (this.lru.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.iLX) {
                dlk();
            } else if (this.lrN) {
                dlo();
            }
        } else if (view == this.lry) {
            dll();
        } else if (view == this.lrA) {
            dlg();
        } else if (view == this.lrB) {
            FL(800);
        } else if (view == this.lrT) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                dle();
            } else {
                int nickNameLeftDays = this.lrH.dlp().getNickNameLeftDays();
                if (this.lrH.dlp().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.zV(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).bia();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.lrQ) {
            if (this.lrH == null || this.lrH.dlp() == null || StringUtils.isNull(this.lrH.dlp().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.lsb) {
            PersonConstellationActivity.a(getActivity(), this.lrH.dlp().getBirthdayTime(), this.lrH.dlp().getBirthdayShowStatus());
        }
    }

    private void dle() {
        if (this.lrW == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.lrW = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.lrW.aZ(inflate);
            this.lrW.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.cYB(), true)));
                    aVar.dismiss();
                }
            });
            this.lrW.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.lrW.b(getPageContext());
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), (int) R.color.cp_cont_b);
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), (int) R.color.common_color_10122);
        }
        this.lrW.bia();
    }

    private void i(AccountData accountData) {
        if (this.eBF == null) {
            this.eBF = new com.baidu.tbadk.coreExtra.view.b(this);
            this.eBF.a(new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.OW(accountData2.getAccount());
                    }
                }
            });
        }
        this.eBF.bqP();
        this.eBF.setAccountData(accountData);
        this.eBF.bqL();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.lrG = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.lrG) {
            dlf();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlf() {
        if (this.lrB.getVisibility() == 0) {
            String replaceAll = this.lrB.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.fUX.setText(replaceAll);
            } else {
                this.fUX.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.lrH.dlp().getIntro() == null || !this.lrH.dlp().getIntro().equals(replaceAll)) {
                this.lrM = true;
            }
            this.lrH.dlp().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.lrB);
        }
    }

    private void dlg() {
        if (this.lrB.getVisibility() != 0) {
            this.fUX.setVisibility(8);
            this.lrB.setText(this.lrH.dlp().getIntro());
            this.lrB.setSelection(this.lrB.getText().length());
            this.lrB.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.lrB);
            FL(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FL(int i) {
        this.lrw.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.lrw.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aF(Bundle bundle) {
        this.hQL = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.lrJ != null) {
                    PersonChangeActivity.this.lrJ.cancel();
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
        this.lrH = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.hPT);
        SvgManager.bkl().a(this.dUP, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.hVh.refresh();
        ap.setViewTextColor(this.lrR, (int) R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.lrH.dlp() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.lrH.dlp()));
        }
    }

    private void bBP() {
        this.lrV = findViewById(R.id.photo_pop_icon);
        this.lrV.setOnClickListener(this);
        this.hVh = (HeadImageView) findViewById(R.id.photo);
        this.hVh.setOnClickListener(this);
        this.hVh.startLoad(q.As(this.lrH.dlp().getPortrait()), 25, false);
        this.hPT = (LinearLayout) findViewById(R.id.parent);
        this.lrw = (ScrollView) findViewById(R.id.person_change_scroll);
        this.lry = (RelativeLayout) findViewById(R.id.person_sex);
        this.lrz = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.dUQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.lse);
        this.dUP = (ImageView) this.dUQ.findViewById(R.id.widget_navi_back_button);
        this.dUP.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.lrv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.jBl = (TextView) this.lrv.findViewById(R.id.right_textview);
        this.jBl.setText(getPageContext().getString(R.string.save));
        ap.setViewTextColor(this.jBl, R.color.navi_op_text, 1);
        this.lrv.setOnClickListener(this);
        this.lry.setOnClickListener(this);
        this.lrA = (LinearLayout) findViewById(R.id.intro_click);
        this.lrA.setOnClickListener(this);
        this.lrA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.lrG = true;
                    return false;
                }
                return false;
            }
        });
        this.lrx = (TextView) findViewById(R.id.nick_name_show);
        this.lrx.setText(this.lrH.dlp().getNameShow());
        this.lrT = findViewById(R.id.person_nickname);
        this.lrT.setOnClickListener(this);
        this.lrU = findViewById(R.id.nick_name_more);
        dlh();
        this.lrR = (TextView) findViewById(R.id.user_name_show);
        this.lrQ = findViewById(R.id.person_name);
        this.lrS = findViewById(R.id.user_name_more_icon);
        this.lrQ.setOnClickListener(this);
        if (StringUtils.isNull(this.lrH.dlp().getName())) {
            this.lrR.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.lrP = false;
            this.lrQ.setClickable(true);
            this.lrS.setVisibility(0);
        } else {
            this.lrR.setText(this.lrH.dlp().getName());
            this.lrP = true;
            this.lrQ.setClickable(false);
            this.lrS.setVisibility(8);
        }
        this.lrC = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.lrD = (TextView) findViewById(R.id.intro_text_tip_num);
        this.lrE = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.lrF = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.fUX = (TextView) findViewById(R.id.intro);
        this.fUX.setVisibility(8);
        if (this.lrH.dlp().getIntro() != null && this.lrH.dlp().getIntro().length() > 0) {
            this.fUX.setText(this.lrH.dlp().getIntro());
        } else {
            this.fUX.setText(getPageContext().getString(R.string.add_intro));
        }
        this.lrB = (EditText) findViewById(R.id.edit);
        this.lrB.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.lrB.setHintTextColor(ap.getColor(R.color.cp_cont_c));
        this.lrB.setCursorVisible(false);
        if (!at.isEmpty(this.lrH.dlp().getIntro())) {
            this.lrB.setText(this.lrH.dlp().getIntro());
            this.lrD.setText(this.lrH.dlp().getIntro().length() + "");
        } else {
            this.lrD.setText("0");
        }
        this.lrC.setVisibility(0);
        this.lrB.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.dlf();
                }
            }
        });
        this.lrB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.lrG = true;
                    PersonChangeActivity.this.lrB.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.lrB.setOnClickListener(this);
        this.lrB.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.lrB.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.lrD.setText(String.valueOf(length));
                PersonChangeActivity.this.lrC.setVisibility(0);
                PersonChangeActivity.this.FL(0);
                PersonChangeActivity.this.dlj();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.lrB.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.lrB.getSelectionStart() - 1 > PersonChangeActivity.this.lrB.getSelectionEnd()) {
                        PersonChangeActivity.this.lrB.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.lrB.getSelectionStart() - 1, PersonChangeActivity.this.lrB.getSelectionEnd());
                        PersonChangeActivity.this.lrB.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.lrB.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.lrH.dlp().getIntro())) {
                    PersonChangeActivity.this.iLX = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(PersonChangeActivity.this.jBl, R.color.navi_op_text, 1);
                    } else {
                        ap.setViewTextColor(PersonChangeActivity.this.jBl, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.lrH.dlp().getSex() == 1) {
            this.mSex = 1;
            this.lrz.setText(R.string.male);
        } else if (this.lrH.dlp().getSex() == 2) {
            this.mSex = 2;
            this.lrz.setText(R.string.female);
        } else {
            this.lrz.setText(R.string.change_sex);
        }
        this.lrK = (ProgressBar) findViewById(R.id.image_progress);
        this.jUp = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.jUp.zV(getPageContext().getString(R.string.confirm_giveup));
        this.jUp.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.dlk();
            }
        });
        this.jUp.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.lrH.dlp().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.lru.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.lrH.dlp());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.lrH.dlp());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.dln();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.jUp.b(getPageContext());
        this.lrY = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.lrZ = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.lrH.dlp().getAlaId() > 0) {
            this.lrY.setVisibility(0);
            this.lrZ.setText(this.lrH.dlp().getAlaId() + "");
        }
        this.lsa = (TextView) findViewById(R.id.person_forum_age_show);
        this.lsa.setText(getResources().getString(R.string.person_forum_age_suffix, this.lrH.dlp().getForumAge()));
        this.lsb = (RelativeLayout) findViewById(R.id.person_constellation);
        this.lsb.setOnClickListener(this);
        this.lsc = (TextView) findViewById(R.id.constellation_txt);
        this.lsd = (TextView) findViewById(R.id.age_txt);
        if (this.lrH.dlp().getBirthdayTime() != 0) {
            this.lsc.setText(at.p(new Date(this.lrH.dlp().getBirthdayTime() * 1000)));
        }
        if (this.lrH.dlp().getUserAge() > 0 && this.lrH.dlp().getBirthdayShowStatus() == 2) {
            this.lsd.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.lrH.dlp().getUserAge())));
            this.lsd.setVisibility(0);
        } else {
            this.lsd.setVisibility(8);
        }
        this.lrw.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.lrw.scrollTo(0, 0);
            }
        });
    }

    private void dlh() {
        if (NickNameActivitySwitch.isOn() || this.lrH.dlp().getNickNameLeftDays() == 0) {
            this.lrU.setVisibility(0);
        } else {
            this.lrU.setVisibility(8);
        }
    }

    public void dli() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.nJ(R.string.operation);
        bVar.a(strArr, new b.InterfaceC0533b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0533b
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
        bVar.bic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlj() {
        int color;
        if (this.lrB.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = ap.getColor(R.color.common_color_10159);
        } else {
            color = ap.getColor(R.color.common_color_10077);
        }
        FM(color);
    }

    private void FM(int i) {
        this.lrD.setTextColor(i);
        this.lrE.setTextColor(i);
        this.lrF.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlk() {
        if (this.lrH != null && this.lrH.dlp() != null) {
            dlf();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.lrH.dlp().setIntro(this.lrB.getText().toString().replaceAll("\\s*", ""));
            this.lrH.dlp().setSex(this.mSex);
            if (this.lrJ == null) {
                this.lrJ = new b(this.lrH);
                this.lrJ.setPriority(3);
                this.lrJ.execute(new String[0]);
            }
        }
    }

    private void dll() {
        if (this.lrL == null) {
            this.lrL = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.lrL.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.lrL != null && PersonChangeActivity.this.lrL.isShowing()) {
                        PersonChangeActivity.this.lrL.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.lrz.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.lrz.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.lrH.dlp().getSex()) {
                            PersonChangeActivity.this.iLX = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                ap.setViewTextColor(PersonChangeActivity.this.jBl, R.color.navi_op_text, 1);
                            } else {
                                ap.setViewTextColor(PersonChangeActivity.this.jBl, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.lrL.NY();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            dlf();
            this.lse.onClick(null);
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
                        if (longExtra != this.lrH.dlp().getBirthdayTime() || intExtra != this.lrH.dlp().getBirthdayShowStatus()) {
                            this.lrH.dlp().setBirthdayShowStatus(intExtra);
                            this.lrH.dlp().setBirthdayTime(longExtra);
                            this.lrM = true;
                            this.iLX = true;
                            Date date = new Date(longExtra * 1000);
                            this.lsc.setText(at.p(date));
                            if (this.lrH.dlp().getBirthdayShowStatus() == 2) {
                                this.lsd.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(r(date))));
                                this.lsd.setVisibility(0);
                                return;
                            }
                            this.lsd.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ai(intent);
                            return;
                        } else {
                            aa(intent);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.lrH.dlp().setPhotoChanged(true);
                    dlm();
                    this.iLX = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.jBl, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.jBl, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.lrH.dlp().setPhotoChanged(true);
                    if (intent != null) {
                        this.hVh.setImageBitmap(null);
                        this.hVh.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.iLX = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.jBl, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.jBl, R.color.cp_link_tip_a, 1);
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

    private void OV(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.lrN = true;
            this.lrH.dlp().setPhotoChanged(true);
            this.lrH.dlp().setNameShow(str);
            this.lrH.dlp().setNickNameLeftDays(90);
            this.lrx.setText(str);
            dlh();
        }
    }

    private void aa(Intent intent) {
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

    private void ai(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_CAMERA, RequestResponseCode.REQUEST_CAMERA_VIEW, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void dlm() {
        if (this.lrI != null) {
            this.lrI.cancel();
        }
        this.jtn = null;
        this.lrI = new a();
        this.lrI.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dln() {
        if (this.lrH != null && this.lrH.dlp() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.lrH.dlp()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.lrK.setVisibility(0);
            PersonChangeActivity.this.hVh.setImageDrawable(null);
            PersonChangeActivity.this.jtn = null;
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
            PersonChangeActivity.this.lrI = null;
            PersonChangeActivity.this.lrK.setVisibility(8);
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
            PersonChangeActivity.this.lrI = null;
            PersonChangeActivity.this.lrK.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.jtn = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.jtn.drawImageTo(PersonChangeActivity.this.hVh);
                com.baidu.tbadk.imageManager.c.bub().a(PersonChangeActivity.this.lrH.dlp().getPortrait(), PersonChangeActivity.this.jtn, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlo() {
        Intent intent = new Intent();
        if (this.lru.booleanValue()) {
            intent.putExtra("person_change_data", this.lrH.dlp());
        } else {
            intent.putExtra("data", this.lrH.dlp());
        }
        setResult(-1, intent);
        dln();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private aa bGb = null;
        private PersonChangeModel lrH;

        public b(PersonChangeModel personChangeModel) {
            this.lrH = null;
            this.lrH = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.lrJ = null;
            if (this.bGb != null) {
                this.bGb.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.lrJ = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.bGb != null) {
                if (this.bGb.bjL().bkr().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.dlo();
                } else {
                    PersonChangeActivity.this.showToast(this.bGb.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.hQL);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.lrH != null) {
                this.bGb = new aa(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.bGb.addPostData("sex", String.valueOf(this.lrH.dlp().getSex()));
                this.bGb.addPostData("intro", this.lrH.dlp().getIntro());
                this.bGb.addPostData("birthday_time", String.valueOf(this.lrH.dlp().getBirthdayTime()));
                this.bGb.addPostData("birthday_show_status", String.valueOf(this.lrH.dlp().getBirthdayShowStatus()));
                this.bGb.postMultiNetData();
                if (this.bGb.bjL().bkr().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.dBr();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iaJ && !TextUtils.isEmpty(this.lrX)) {
            OV(this.lrX);
            this.iaJ = false;
            this.lrX = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OW(String str) {
        if (!StringUtils.isNull(str)) {
            this.lrP = true;
            this.lrR.setText(str);
            this.lrQ.setClickable(false);
            this.lrS.setVisibility(8);
        }
    }
}
