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
    private ImageView bCf;
    private View bCg;
    private com.baidu.tbadk.coreExtra.view.c ceZ;
    private View inG;
    private TextView inH;
    private View inI;
    private View inJ;
    private View inK;
    private View inL;
    private com.baidu.tbadk.core.dialog.a inM;
    private String inN;
    private View inl;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public final int inj = 90;
    private Boolean ink = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView gJL = null;
    private LinearLayout fgy = null;
    private ScrollView inm = null;
    private TextView inn = null;
    private LinearLayout ino = null;
    private TextView inp = null;
    private LinearLayout inq = null;
    private TextView dzt = null;
    private EditText mEdit = null;
    private LinearLayout inr = null;

    /* renamed from: int  reason: not valid java name */
    private TextView f0int = null;
    private TextView inu = null;
    private TextView inv = null;
    private InputMethodManager mInputManager = null;
    private boolean inw = false;
    private PersonChangeModel inx = null;
    protected HeadImageView fpx = null;
    private com.baidu.adp.widget.ImageView.a gCS = null;
    private a iny = null;
    private b inz = null;
    private ProgressBar inA = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a eJy = null;
    private com.baidu.tbadk.core.dialog.i inB = null;
    private boolean inC = false;
    private boolean gap = false;
    private boolean inD = false;
    private int mSex = 0;
    private final int inE = 500;
    private boolean inF = false;
    private boolean fuD = false;
    private final View.OnClickListener inO = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.inx.cci().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.inC = true;
            }
            if (PersonChangeActivity.this.inC) {
                PersonChangeActivity.this.eJy.agI();
                return;
            }
            if (PersonChangeActivity.this.inx != null && PersonChangeActivity.this.inx.cci().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.ink.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.inx.cci());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.inx.cci());
                }
                PersonChangeActivity.this.ccg();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener fvq = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.fuD = true;
                        PersonChangeActivity.this.inN = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener inP = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.inx != null && PersonChangeActivity.this.inx.cci() != null && personChangeData != null) {
                    PersonChangeActivity.this.inx.cci().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.inx.cci().setMem(personChangeData.getMen());
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
        aCH();
        if (bundle != null) {
            this.ink = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.ink = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.fvq);
        registerListener(this.inP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fvq);
        if (this.iny != null) {
            this.iny.cancel();
        }
        if (this.inz != null) {
            this.inz.cancel();
        }
        if (this.inA != null) {
            this.inA.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        if (this.ceZ != null) {
            this.ceZ.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fpx || view == this.inL) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.ajQ();
            this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.ad(pageActivity)) {
                ccc();
            }
        } else if (view == this.inl) {
            if (!this.gap && !this.inD) {
                finish();
            }
            if (this.ink.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.gap) {
                bau();
            } else if (this.inD) {
                cch();
            }
        } else if (view == this.ino) {
            cce();
        } else if (view == this.inq) {
            cca();
        } else if (view == this.mEdit) {
            yK(800);
        } else if (view == this.inJ) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (as.iN()) {
                cbY();
            } else {
                int nickNameLeftDays = this.inx.cci().getNickNameLeftDays();
                if (this.inx.cci().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.mO(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).agI();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.inG) {
            if (this.inx == null || this.inx.cci() == null || StringUtils.isNull(this.inx.cci().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void cbY() {
        if (this.inM == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.inM = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.inM.aH(inflate);
            this.inM.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.bSg(), true)));
                    aVar.dismiss();
                }
            });
            this.inM.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.inM.b(getPageContext());
            am.j(inflate.findViewById(R.id.nickname_dialog_title), R.color.cp_cont_b);
            am.j(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.inM.agI();
    }

    private void i(AccountData accountData) {
        if (this.ceZ == null) {
            this.ceZ = new com.baidu.tbadk.coreExtra.view.c(this);
            this.ceZ.a(new c.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.CL(accountData2.getAccount());
                    }
                }
            });
        }
        this.ceZ.aqr();
        this.ceZ.setAccountData(accountData);
        this.ceZ.aqn();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.inw = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.inw) {
            cbZ();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbZ() {
        if (this.mEdit.getVisibility() == 0) {
            this.inr.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.dzt.setText(replaceAll);
            } else {
                this.dzt.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.inx.cci().getIntro() == null || !this.inx.cci().getIntro().equals(replaceAll)) {
                this.inC = true;
            }
            this.inx.cci().setIntro(replaceAll);
            this.dzt.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void cca() {
        if (this.mEdit.getVisibility() != 0) {
            this.dzt.setVisibility(8);
            this.mEdit.setText(this.inx.cci().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            yK(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yK(int i) {
        this.inm.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.inm.fullScroll(130);
            }
        }, i);
    }

    private void ae(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.inz != null) {
                    PersonChangeActivity.this.inz.cancel();
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
        this.inx = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.fgy);
        am.a(this.bCf, (int) R.drawable.icon_nav_close, (int) R.drawable.icon_nav_close_w, (int) R.drawable.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fpx.refresh();
        am.j(this.inH, R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.inx.cci() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.inx.cci()));
        }
    }

    private void aCH() {
        this.inL = findViewById(R.id.photo_pop_icon);
        this.inL.setOnClickListener(this);
        this.fpx = (HeadImageView) findViewById(R.id.photo);
        this.fpx.setOnClickListener(this);
        this.fpx.startLoad(o.nM(this.inx.cci().getPortrait()), 25, false);
        this.fgy = (LinearLayout) findViewById(R.id.parent);
        this.inm = (ScrollView) findViewById(R.id.person_change_scroll);
        this.ino = (LinearLayout) findViewById(R.id.person_sex);
        this.inp = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bCg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.inO);
        this.bCf = (ImageView) this.bCg.findViewById(R.id.widget_navi_back_button);
        this.bCf.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.inl = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.gJL = (TextView) this.inl.findViewById(R.id.right_textview);
        this.gJL.setText(getPageContext().getString(R.string.save));
        am.f(this.gJL, R.color.navi_op_text, 1);
        this.inl.setOnClickListener(this);
        this.ino.setOnClickListener(this);
        this.inq = (LinearLayout) findViewById(R.id.intro_click);
        this.inq.setOnClickListener(this);
        this.inq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.inw = true;
                    return false;
                }
                return false;
            }
        });
        this.inn = (TextView) findViewById(R.id.nick_name_show);
        this.inn.setText(this.inx.cci().getNameShow());
        this.inJ = findViewById(R.id.person_nickname);
        this.inJ.setOnClickListener(this);
        this.inK = findViewById(R.id.nick_name_more);
        ccb();
        this.inH = (TextView) findViewById(R.id.user_name_show);
        this.inG = findViewById(R.id.person_name);
        this.inI = findViewById(R.id.user_name_more_icon);
        this.inG.setOnClickListener(this);
        if (StringUtils.isNull(this.inx.cci().getName())) {
            this.inH.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.inF = false;
            this.inG.setClickable(true);
            this.inI.setVisibility(0);
        } else {
            this.inH.setText(this.inx.cci().getName());
            this.inF = true;
            this.inG.setClickable(false);
            this.inI.setVisibility(8);
        }
        this.dzt = (TextView) findViewById(R.id.intro);
        if (this.inx.cci().getIntro() != null && this.inx.cci().getIntro().length() > 0) {
            this.dzt.setText(this.inx.cci().getIntro());
        } else {
            this.dzt.setText(getPageContext().getString(R.string.add_intro));
        }
        this.mEdit = (EditText) findViewById(R.id.edit);
        this.mEdit.setText(this.inx.cci().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.cbZ();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.inw = true;
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
                PersonChangeActivity.this.f0int.setText(String.valueOf(length));
                PersonChangeActivity.this.inr.setVisibility(0);
                PersonChangeActivity.this.yK(0);
                PersonChangeActivity.this.ccd();
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.inx.cci().getIntro())) {
                    PersonChangeActivity.this.gap = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.f(PersonChangeActivity.this.gJL, R.color.navi_op_text, 1);
                    } else {
                        am.f(PersonChangeActivity.this.gJL, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.inx.cci().getSex() == 1) {
            this.mSex = 1;
            this.inp.setText(R.string.male);
        } else if (this.inx.cci().getSex() == 2) {
            this.mSex = 2;
            this.inp.setText(R.string.female);
        } else {
            this.inp.setText(R.string.change_sex);
        }
        this.inr = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.f0int = (TextView) findViewById(R.id.intro_text_tip_num);
        this.inu = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.inv = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.inA = (ProgressBar) findViewById(R.id.image_progress);
        this.eJy = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.eJy.mO(getPageContext().getString(R.string.confirm_giveup));
        this.eJy.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.bau();
            }
        });
        this.eJy.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.inx.cci().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.ink.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.inx.cci());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.inx.cci());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.ccg();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.eJy.b(getPageContext());
    }

    private void ccb() {
        if (as.iN() || this.inx.cci().getNickNameLeftDays() == 0) {
            this.inK.setVisibility(0);
        } else {
            this.inK.setVisibility(8);
        }
    }

    public void ccc() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.hy(R.string.operation);
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
        bVar.agL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccd() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = am.getColor(R.color.common_color_10159);
        } else {
            color = am.getColor(R.color.common_color_10077);
        }
        yL(color);
    }

    private void yL(int i) {
        this.f0int.setTextColor(i);
        this.inu.setTextColor(i);
        this.inv.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bau() {
        if (this.inx != null && this.inx.cci() != null) {
            cbZ();
            if (!com.baidu.adp.lib.util.j.kc()) {
                showToast(R.string.neterror);
                return;
            }
            this.inx.cci().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.inx.cci().setSex(this.mSex);
            if (this.inz == null) {
                this.inz = new b(this.inx);
                this.inz.setPriority(3);
                this.inz.execute(new String[0]);
            }
        }
    }

    private void cce() {
        if (this.inB == null) {
            this.inB = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.inB.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.inB != null && PersonChangeActivity.this.inB.isShowing()) {
                        PersonChangeActivity.this.inB.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.inp.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.inp.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.inx.cci().getSex()) {
                            PersonChangeActivity.this.gap = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                am.f(PersonChangeActivity.this.gJL, R.color.navi_op_text, 1);
                            } else {
                                am.f(PersonChangeActivity.this.gJL, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.inB.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cbZ();
            this.inO.onClick(null);
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
                            at(intent);
                            return;
                        } else {
                            am(intent);
                            return;
                        }
                    }
                    return;
                case 12009:
                case 12010:
                    this.inx.cci().setPhotoChanged(true);
                    ccf();
                    this.gap = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.f(this.gJL, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.f(this.gJL, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case 12014:
                    this.inx.cci().setPhotoChanged(true);
                    if (intent != null) {
                        this.fpx.setImageBitmap(null);
                        this.fpx.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.gap = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.f(this.gJL, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.f(this.gJL, R.color.cp_link_tip_a, 1);
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

    private void CK(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.inD = true;
            this.inx.cci().setPhotoChanged(true);
            this.inx.cci().setNameShow(str);
            this.inx.cci().setNickNameLeftDays(90);
            this.inn.setText(str);
            ccb();
        }
    }

    private void am(Intent intent) {
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

    private void at(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), SapiGIDEvent.TIME_FREQ, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void ccf() {
        if (this.iny != null) {
            this.iny.cancel();
        }
        this.gCS = null;
        this.iny = new a();
        this.iny.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccg() {
        if (this.inx != null && this.inx.cci() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.inx.cci()));
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
            PersonChangeActivity.this.inA.setVisibility(0);
            PersonChangeActivity.this.fpx.setImageDrawable(null);
            PersonChangeActivity.this.gCS = null;
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
            PersonChangeActivity.this.iny = null;
            PersonChangeActivity.this.inA.setVisibility(8);
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
            PersonChangeActivity.this.iny = null;
            PersonChangeActivity.this.inA.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.gCS = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.gCS.a(PersonChangeActivity.this.fpx);
                com.baidu.tbadk.imageManager.c.atw().a(PersonChangeActivity.this.inx.cci().getPortrait(), PersonChangeActivity.this.gCS, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cch() {
        Intent intent = new Intent();
        if (this.ink.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.inx.cci());
        } else {
            intent.putExtra("data", this.inx.cci());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.inx.cci());
        setResult(-1, intent);
        ccg();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel inx;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.inx = null;
            this.inx = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.inz = null;
            if (this.mNetWork != null) {
                this.mNetWork.ik();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.inz = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.aiE().ajF().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.cch();
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
            if (this.inx != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.inx.cci().getSex()));
                this.mNetWork.o("intro", this.inx.cci().getIntro());
                this.mNetWork.aij();
                if (this.mNetWork.aiE().ajF().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.cqe();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fuD && !TextUtils.isEmpty(this.inN)) {
            CK(this.inN);
            this.fuD = false;
            this.inN = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CL(String str) {
        if (!StringUtils.isNull(str)) {
            this.inF = true;
            this.inH.setText(str);
            this.inG.setClickable(false);
            this.inI.setVisibility(8);
        }
    }
}
