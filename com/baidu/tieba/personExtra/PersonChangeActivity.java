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
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.t.as;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private ImageView bCD;
    private View bCE;
    private com.baidu.tbadk.coreExtra.view.c cfZ;
    private View iqJ;
    private TextView iqK;
    private View iqL;
    private View iqM;
    private View iqN;
    private View iqO;
    private com.baidu.tbadk.core.dialog.a iqP;
    private String iqQ;
    private View iqp;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    public final int iqn = 90;
    private Boolean iqo = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView gMv = null;
    private LinearLayout fiN = null;
    private ScrollView iqq = null;
    private TextView iqr = null;
    private LinearLayout iqs = null;
    private TextView iqt = null;
    private LinearLayout iqu = null;
    private TextView dBl = null;
    private EditText mEdit = null;
    private LinearLayout iqv = null;
    private TextView iqw = null;
    private TextView iqx = null;
    private TextView iqy = null;
    private InputMethodManager mInputManager = null;
    private boolean iqz = false;
    private PersonChangeModel iqA = null;
    protected HeadImageView frK = null;
    private com.baidu.adp.widget.ImageView.a gFB = null;
    private a iqB = null;
    private b iqC = null;
    private ProgressBar iqD = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a eLo = null;
    private com.baidu.tbadk.core.dialog.i iqE = null;
    private boolean iqF = false;
    private boolean gcW = false;
    private boolean iqG = false;
    private int mSex = 0;
    private final int iqH = 500;
    private boolean iqI = false;
    private boolean fwP = false;
    private final View.OnClickListener iqR = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.iqA.cdo().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.iqF = true;
            }
            if (PersonChangeActivity.this.iqF) {
                PersonChangeActivity.this.eLo.agO();
                return;
            }
            if (PersonChangeActivity.this.iqA != null && PersonChangeActivity.this.iqA.cdo().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.iqo.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.iqA.cdo());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.iqA.cdo());
                }
                PersonChangeActivity.this.cdm();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener fxC = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.fwP = true;
                        PersonChangeActivity.this.iqQ = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener iqS = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.iqA != null && PersonChangeActivity.this.iqA.cdo() != null && personChangeData != null) {
                    PersonChangeActivity.this.iqA.cdo().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.iqA.cdo().setMem(personChangeData.getMen());
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
        ae(bundle);
        aCX();
        if (bundle != null) {
            this.iqo = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.iqo = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.fxC);
        registerListener(this.iqS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fxC);
        if (this.iqB != null) {
            this.iqB.cancel();
        }
        if (this.iqC != null) {
            this.iqC.cancel();
        }
        if (this.iqD != null) {
            this.iqD.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        if (this.cfZ != null) {
            this.cfZ.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.frK || view == this.iqO) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgement.ake();
            this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.ad(pageActivity)) {
                cdi();
            }
        } else if (view == this.iqp) {
            if (!this.gcW && !this.iqG) {
                finish();
            }
            if (this.iqo.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.gcW) {
                bba();
            } else if (this.iqG) {
                cdn();
            }
        } else if (view == this.iqs) {
            cdk();
        } else if (view == this.iqu) {
            cdg();
        } else if (view == this.mEdit) {
            yP(CyberPlayerManager.MEDIA_INFO_BAD_INTERLEAVING);
        } else if (view == this.iqM) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (as.iN()) {
                cde();
            } else {
                int nickNameLeftDays = this.iqA.cdo().getNickNameLeftDays();
                if (this.iqA.cdo().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.mQ(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
                        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                if (com.baidu.adp.lib.util.j.kc()) {
                                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), 24);
                                    memberPayActivityConfig.setReferPageClickZone("my_data_V8.9", "pop_ups_opende_button_V8.9");
                                    PersonChangeActivity.this.sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                                    TiebaStatic.log("c12409");
                                } else {
                                    PersonChangeActivity.this.showToast(R.string.neterror);
                                }
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(getPageContext()).agO();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.iqJ) {
            if (this.iqA == null || this.iqA.cdo() == null || StringUtils.isNull(this.iqA.cdo().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void cde() {
        if (this.iqP == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.iqP = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.iqP.aH(inflate);
            this.iqP.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.bTh(), true)));
                    aVar.dismiss();
                }
            });
            this.iqP.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.iqP.b(getPageContext());
            am.j(inflate.findViewById(R.id.nickname_dialog_title), R.color.cp_cont_b);
            am.j(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.iqP.agO();
    }

    private void i(AccountData accountData) {
        if (this.cfZ == null) {
            this.cfZ = new com.baidu.tbadk.coreExtra.view.c(this);
            this.cfZ.a(new c.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.Dl(accountData2.getAccount());
                    }
                }
            });
        }
        this.cfZ.aqF();
        this.cfZ.setAccountData(accountData);
        this.cfZ.aqB();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.iqz = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.iqz) {
            cdf();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdf() {
        if (this.mEdit.getVisibility() == 0) {
            this.iqv.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.dBl.setText(replaceAll);
            } else {
                this.dBl.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.iqA.cdo().getIntro() == null || !this.iqA.cdo().getIntro().equals(replaceAll)) {
                this.iqF = true;
            }
            this.iqA.cdo().setIntro(replaceAll);
            this.dBl.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void cdg() {
        if (this.mEdit.getVisibility() != 0) {
            this.dBl.setVisibility(8);
            this.mEdit.setText(this.iqA.cdo().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            yP(CyberPlayerManager.MEDIA_INFO_BAD_INTERLEAVING);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yP(int i) {
        this.iqq.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.iqq.fullScroll(130);
            }
        }, i);
    }

    private void ae(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.iqC != null) {
                    PersonChangeActivity.this.iqC.cancel();
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
        this.iqA = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.fiN);
        SvgManager.ajv().a(this.bCD, R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.frK.refresh();
        am.j(this.iqK, R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.iqA.cdo() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.iqA.cdo()));
        }
    }

    private void aCX() {
        this.iqO = findViewById(R.id.photo_pop_icon);
        this.iqO.setOnClickListener(this);
        this.frK = (HeadImageView) findViewById(R.id.photo);
        this.frK.setOnClickListener(this);
        this.frK.startLoad(o.nO(this.iqA.cdo().getPortrait()), 25, false);
        this.fiN = (LinearLayout) findViewById(R.id.parent);
        this.iqq = (ScrollView) findViewById(R.id.person_change_scroll);
        this.iqs = (LinearLayout) findViewById(R.id.person_sex);
        this.iqt = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bCE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.iqR);
        this.bCD = (ImageView) this.bCE.findViewById(R.id.widget_navi_back_button);
        this.bCD.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.iqp = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.gMv = (TextView) this.iqp.findViewById(R.id.right_textview);
        this.gMv.setText(getPageContext().getString(R.string.save));
        am.f(this.gMv, R.color.navi_op_text, 1);
        this.iqp.setOnClickListener(this);
        this.iqs.setOnClickListener(this);
        this.iqu = (LinearLayout) findViewById(R.id.intro_click);
        this.iqu.setOnClickListener(this);
        this.iqu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.iqz = true;
                    return false;
                }
                return false;
            }
        });
        this.iqr = (TextView) findViewById(R.id.nick_name_show);
        this.iqr.setText(this.iqA.cdo().getNameShow());
        this.iqM = findViewById(R.id.person_nickname);
        this.iqM.setOnClickListener(this);
        this.iqN = findViewById(R.id.nick_name_more);
        cdh();
        this.iqK = (TextView) findViewById(R.id.user_name_show);
        this.iqJ = findViewById(R.id.person_name);
        this.iqL = findViewById(R.id.user_name_more_icon);
        this.iqJ.setOnClickListener(this);
        if (StringUtils.isNull(this.iqA.cdo().getName())) {
            this.iqK.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.iqI = false;
            this.iqJ.setClickable(true);
            this.iqL.setVisibility(0);
        } else {
            this.iqK.setText(this.iqA.cdo().getName());
            this.iqI = true;
            this.iqJ.setClickable(false);
            this.iqL.setVisibility(8);
        }
        this.dBl = (TextView) findViewById(R.id.intro);
        if (this.iqA.cdo().getIntro() != null && this.iqA.cdo().getIntro().length() > 0) {
            this.dBl.setText(this.iqA.cdo().getIntro());
        } else {
            this.dBl.setText(getPageContext().getString(R.string.add_intro));
        }
        this.mEdit = (EditText) findViewById(R.id.edit);
        this.mEdit.setText(this.iqA.cdo().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.cdf();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.iqz = true;
                    return false;
                }
                return false;
            }
        });
        this.mEdit.setOnClickListener(this);
        this.mEdit.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.mEdit.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.iqw.setText(String.valueOf(length));
                PersonChangeActivity.this.iqv.setVisibility(0);
                PersonChangeActivity.this.yP(0);
                PersonChangeActivity.this.cdj();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.mEdit.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.mEdit.getSelectionStart() - 1 > PersonChangeActivity.this.mEdit.getSelectionEnd()) {
                        PersonChangeActivity.this.mEdit.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.mEdit.getSelectionStart() - 1, PersonChangeActivity.this.mEdit.getSelectionEnd());
                        PersonChangeActivity.this.mEdit.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.mEdit.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.iqA.cdo().getIntro())) {
                    PersonChangeActivity.this.gcW = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.f(PersonChangeActivity.this.gMv, R.color.navi_op_text, 1);
                    } else {
                        am.f(PersonChangeActivity.this.gMv, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.iqA.cdo().getSex() == 1) {
            this.mSex = 1;
            this.iqt.setText(R.string.male);
        } else if (this.iqA.cdo().getSex() == 2) {
            this.mSex = 2;
            this.iqt.setText(R.string.female);
        } else {
            this.iqt.setText(R.string.change_sex);
        }
        this.iqv = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.iqw = (TextView) findViewById(R.id.intro_text_tip_num);
        this.iqx = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.iqy = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.iqD = (ProgressBar) findViewById(R.id.image_progress);
        this.eLo = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.eLo.mQ(getPageContext().getString(R.string.confirm_giveup));
        this.eLo.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.bba();
            }
        });
        this.eLo.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.iqA.cdo().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.iqo.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.iqA.cdo());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.iqA.cdo());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.cdm();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.eLo.b(getPageContext());
    }

    private void cdh() {
        if (as.iN() || this.iqA.cdo().getNickNameLeftDays() == 0) {
            this.iqN.setVisibility(0);
        } else {
            this.iqN.setVisibility(8);
        }
    }

    public void cdi() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.hz(R.string.operation);
        bVar.a(strArr, new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                if (i == 0) {
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) PersonChangeActivity.this.getPageContext().getPageActivity(), PersonChangeActivity.this.mWriteImagesInfo.toJsonString(), true);
                    albumActivityConfig.setRequestCode(12002);
                    albumActivityConfig.setResourceType(2);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                } else if (i == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), 12014)));
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext());
        bVar.agR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdj() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = am.getColor(R.color.common_color_10159);
        } else {
            color = am.getColor(R.color.common_color_10077);
        }
        yQ(color);
    }

    private void yQ(int i) {
        this.iqw.setTextColor(i);
        this.iqx.setTextColor(i);
        this.iqy.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bba() {
        if (this.iqA != null && this.iqA.cdo() != null) {
            cdf();
            if (!com.baidu.adp.lib.util.j.kc()) {
                showToast(R.string.neterror);
                return;
            }
            this.iqA.cdo().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.iqA.cdo().setSex(this.mSex);
            if (this.iqC == null) {
                this.iqC = new b(this.iqA);
                this.iqC.setPriority(3);
                this.iqC.execute(new String[0]);
            }
        }
    }

    private void cdk() {
        if (this.iqE == null) {
            this.iqE = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.iqE.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.iqE != null && PersonChangeActivity.this.iqE.isShowing()) {
                        PersonChangeActivity.this.iqE.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.iqt.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.iqt.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.iqA.cdo().getSex()) {
                            PersonChangeActivity.this.gcW = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                am.f(PersonChangeActivity.this.gMv, R.color.navi_op_text, 1);
                            } else {
                                am.f(PersonChangeActivity.this.gMv, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.iqE.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cdf();
            this.iqR.onClick(null);
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
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            av(intent);
                            return;
                        } else {
                            ao(intent);
                            return;
                        }
                    }
                    return;
                case 12009:
                case 12010:
                    this.iqA.cdo().setPhotoChanged(true);
                    cdl();
                    this.gcW = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.f(this.gMv, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.f(this.gMv, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case 12014:
                    this.iqA.cdo().setPhotoChanged(true);
                    if (intent != null) {
                        this.frK.setImageBitmap(null);
                        this.frK.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.gcW = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.f(this.gMv, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.f(this.gMv, R.color.cp_link_tip_a, 1);
                        return;
                    }
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12010:
                    al.c(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    private void Dk(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.iqG = true;
            this.iqA.cdo().setPhotoChanged(true);
            this.iqA.cdo().setNameShow(str);
            this.iqA.cdo().setNickNameLeftDays(90);
            this.iqr.setText(str);
            cdh();
        }
    }

    private void ao(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
            if (this.mWriteImagesInfo.getChosedFiles() != null && this.mWriteImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.mWriteImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.mWriteImagesInfo.clear();
        }
    }

    private void av(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), SapiGIDEvent.TIME_FREQ, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void cdl() {
        if (this.iqB != null) {
            this.iqB.cancel();
        }
        this.gFB = null;
        this.iqB = new a();
        this.iqB.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdm() {
        if (this.iqA != null && this.iqA.cdo() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.iqA.cdo()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.iqD.setVisibility(0);
            PersonChangeActivity.this.frK.setImageDrawable(null);
            PersonChangeActivity.this.gFB = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public Bitmap doInBackground(Object... objArr) {
            return m.bP(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.iqB = null;
            PersonChangeActivity.this.iqD.setVisibility(8);
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
            PersonChangeActivity.this.iqB = null;
            PersonChangeActivity.this.iqD.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.gFB = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.gFB.a(PersonChangeActivity.this.frK);
                com.baidu.tbadk.imageManager.c.atK().a(PersonChangeActivity.this.iqA.cdo().getPortrait(), PersonChangeActivity.this.gFB, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdn() {
        Intent intent = new Intent();
        if (this.iqo.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.iqA.cdo());
        } else {
            intent.putExtra("data", this.iqA.cdo());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.iqA.cdo());
        setResult(-1, intent);
        cdm();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel iqA;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.iqA = null;
            this.iqA = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.iqC = null;
            if (this.mNetWork != null) {
                this.mNetWork.ik();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.iqC = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.aiK().ajN().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.cdn();
                } else {
                    PersonChangeActivity.this.showToast(this.mNetWork.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.mDialogCancelListener);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.iqA != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.iqA.cdo().getSex()));
                this.mNetWork.o("intro", this.iqA.cdo().getIntro());
                this.mNetWork.aip();
                if (this.mNetWork.aiK().ajN().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.cro();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fwP && !TextUtils.isEmpty(this.iqQ)) {
            Dk(this.iqQ);
            this.fwP = false;
            this.iqQ = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dl(String str) {
        if (!StringUtils.isNull(str)) {
            this.iqI = true;
            this.iqK.setText(str);
            this.iqJ.setClickable(false);
            this.iqL.setVisibility(8);
        }
    }
}
