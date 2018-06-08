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
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.view.a;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.o.ah;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private com.baidu.tbadk.coreExtra.view.a aAl;
    private View abr;
    private ImageView abt;
    private com.baidu.tbadk.core.util.b.a biP;
    private View fTH;
    private TextView fTI;
    private View fTJ;
    private View fTK;
    private View fTL;
    private View fTM;
    private com.baidu.tbadk.core.dialog.a fTN;
    private String fTO;
    private View fTo;
    public final int fTm = 90;
    private Boolean fTn = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView enT = null;
    private LinearLayout cYt = null;
    private ScrollView fTp = null;
    private TextView fTq = null;
    private LinearLayout fTr = null;
    private TextView fTs = null;
    private LinearLayout fTt = null;
    private TextView bAx = null;
    private EditText mEdit = null;
    private LinearLayout fTu = null;
    private TextView fTv = null;
    private TextView fTw = null;
    private TextView fTx = null;
    private InputMethodManager mInputManager = null;
    private boolean fTy = false;
    private PersonChangeModel fTz = null;
    protected HeadImageView ddy = null;
    private com.baidu.adp.widget.ImageView.a egZ = null;
    private a fTA = null;
    private b fTB = null;
    private ProgressBar fTC = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a cFl = null;
    private com.baidu.tbadk.core.dialog.b fTD = null;
    private boolean fRY = false;
    private boolean dLk = false;
    private boolean fTE = false;
    private int mSex = 0;
    private final int fTF = 500;
    private boolean fTG = false;
    private boolean dik = false;
    private final View.OnClickListener fTP = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.fTz.bjJ().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.fRY = true;
            }
            if (PersonChangeActivity.this.fRY) {
                PersonChangeActivity.this.cFl.xa();
                return;
            }
            if (PersonChangeActivity.this.fTz != null && PersonChangeActivity.this.fTz.bjJ().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.fTn.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.fTz.bjJ());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.fTz.bjJ());
                }
                PersonChangeActivity.this.bjH();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener diO = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.dik = true;
                        PersonChangeActivity.this.fTO = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener fTQ = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.fTz != null && PersonChangeActivity.this.fTz.bjJ() != null && personChangeData != null) {
                    PersonChangeActivity.this.fTz.bjJ().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.fTz.bjJ().setMem(personChangeData.getMen());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.i.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        C(bundle);
        Qg();
        if (bundle != null) {
            this.fTn = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.fTn = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.diO);
        registerListener(this.fTQ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.diO);
        if (this.fTA != null) {
            this.fTA.cancel();
        }
        if (this.fTB != null) {
            this.fTB.cancel();
        }
        if (this.fTC != null) {
            this.fTC.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        if (this.aAl != null) {
            this.aAl.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ddy || view == this.fTM) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.biP == null) {
                this.biP = new com.baidu.tbadk.core.util.b.a();
            }
            this.biP.zU();
            this.biP.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.biP.u(pageActivity)) {
                bjD();
            }
        } else if (view == this.fTo) {
            if (!this.dLk && !this.fTE) {
                finish();
            }
            if (this.fTn.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.dLk) {
                ajJ();
            } else if (this.fTE) {
                bjI();
            }
        } else if (view == this.fTr) {
            bjF();
        } else if (view == this.fTt) {
            bjB();
        } else if (view == this.mEdit) {
            rq(800);
        } else if (view == this.fTK) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(d.k.support_modify_nickname));
            } else if (ah.ip()) {
                bjz();
            } else {
                int nickNameLeftDays = this.fTz.bjJ().getNickNameLeftDays();
                if (this.fTz.bjJ().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.dB(String.format(getPageContext().getPageActivity().getString(d.k.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
                        aVar.a(d.k.open_now, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                if (j.jD()) {
                                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), 24);
                                    memberPayActivityConfig.setReferPageClickZone("my_data_V8.9", "pop_ups_opende_button_V8.9");
                                    PersonChangeActivity.this.sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                                    TiebaStatic.log("c12409");
                                } else {
                                    PersonChangeActivity.this.showToast(d.k.neterror);
                                }
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(getPageContext()).xa();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(d.k.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(d.k.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.fTH) {
            if (this.fTz == null || this.fTz.bjJ() == null || StringUtils.isNull(this.fTz.bjJ().getName())) {
                j(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void bjz() {
        if (this.fTN == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.person_nickname_act_dialog, (ViewGroup) null);
            this.fTN = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.fTN.w(inflate);
            this.fTN.a(d.k.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.aZW(), true)));
                    aVar.dismiss();
                }
            });
            this.fTN.b(d.k.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fTN.b(getPageContext());
            al.h(inflate.findViewById(d.g.nickname_dialog_title), d.C0141d.cp_cont_b);
            al.h(inflate.findViewById(d.g.nickname_dialog_tip), d.C0141d.common_color_10122);
        }
        this.fTN.xa();
    }

    private void j(AccountData accountData) {
        if (this.aAl == null) {
            this.aAl = new com.baidu.tbadk.coreExtra.view.a(getPageContext());
            this.aAl.a(new a.InterfaceC0109a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0109a
                public void f(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.sb(accountData2.getAccount());
                    }
                }
            });
        }
        this.aAl.Fz();
        this.aAl.i(accountData);
        this.aAl.Fv();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.fTy = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.fTy) {
            bjA();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjA() {
        if (this.mEdit.getVisibility() == 0) {
            this.fTu.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.bAx.setText(replaceAll);
            } else {
                this.bAx.setText(getPageContext().getString(d.k.add_intro));
            }
            if (this.fTz.bjJ().getIntro() == null || !this.fTz.bjJ().getIntro().equals(replaceAll)) {
                this.fRY = true;
            }
            this.fTz.bjJ().setIntro(replaceAll);
            this.bAx.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void bjB() {
        if (this.mEdit.getVisibility() != 0) {
            this.bAx.setVisibility(8);
            this.mEdit.setText(this.fTz.bjJ().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            rq(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rq(int i) {
        this.fTp.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.fTp.fullScroll(130);
            }
        }, i);
    }

    private void C(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.fTB != null) {
                    PersonChangeActivity.this.fTB.cancel();
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
        this.fTz = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.cYt);
        al.a(this.abt, d.f.icon_nav_close, d.f.icon_nav_close_w, d.f.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ddy.refresh();
        al.h(this.fTI, d.C0141d.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.fTz.bjJ() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.fTz.bjJ()));
        }
    }

    private void Qg() {
        this.fTM = findViewById(d.g.photo_pop_icon);
        this.fTM.setOnClickListener(this);
        this.ddy = (HeadImageView) findViewById(d.g.photo);
        this.ddy.setOnClickListener(this);
        this.ddy.startLoad(p.eu(this.fTz.bjJ().getPortrait()), 25, false);
        this.cYt = (LinearLayout) findViewById(d.g.parent);
        this.fTp = (ScrollView) findViewById(d.g.person_change_scroll);
        this.fTr = (LinearLayout) findViewById(d.g.person_sex);
        this.fTs = (TextView) findViewById(d.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.abr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.widget_nb_item_finish, this.fTP);
        this.abt = (ImageView) this.abr.findViewById(d.g.widget_navi_back_button);
        this.abt.setContentDescription(getPageContext().getPageActivity().getResources().getString(d.k.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.k.my_info));
        this.fTo = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, (View.OnClickListener) null);
        this.enT = (TextView) this.fTo.findViewById(d.g.right_textview);
        this.enT.setText(getPageContext().getString(d.k.save));
        al.c(this.enT, d.C0141d.navi_op_text, 1);
        this.fTo.setOnClickListener(this);
        this.fTr.setOnClickListener(this);
        this.fTt = (LinearLayout) findViewById(d.g.intro_click);
        this.fTt.setOnClickListener(this);
        this.fTt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.fTy = true;
                    return false;
                }
                return false;
            }
        });
        this.fTq = (TextView) findViewById(d.g.nick_name_show);
        this.fTq.setText(this.fTz.bjJ().getNameShow());
        this.fTK = findViewById(d.g.person_nickname);
        this.fTK.setOnClickListener(this);
        this.fTL = findViewById(d.g.nick_name_more);
        bjC();
        this.fTI = (TextView) findViewById(d.g.user_name_show);
        this.fTH = findViewById(d.g.person_name);
        this.fTJ = findViewById(d.g.user_name_more_icon);
        this.fTH.setOnClickListener(this);
        if (StringUtils.isNull(this.fTz.bjJ().getName())) {
            this.fTI.setText(getPageContext().getString(d.k.tip_empty_user_name));
            this.fTG = false;
            this.fTH.setClickable(true);
            this.fTJ.setVisibility(0);
        } else {
            this.fTI.setText(this.fTz.bjJ().getName());
            this.fTG = true;
            this.fTH.setClickable(false);
            this.fTJ.setVisibility(8);
        }
        this.bAx = (TextView) findViewById(d.g.intro);
        if (this.fTz.bjJ().getIntro() != null && this.fTz.bjJ().getIntro().length() > 0) {
            this.bAx.setText(this.fTz.bjJ().getIntro());
        } else {
            this.bAx.setText(getPageContext().getString(d.k.add_intro));
        }
        this.mEdit = (EditText) findViewById(d.g.edit);
        this.mEdit.setText(this.fTz.bjJ().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.bjA();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.fTy = true;
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
                PersonChangeActivity.this.fTv.setText(String.valueOf(length));
                PersonChangeActivity.this.fTu.setVisibility(0);
                PersonChangeActivity.this.rq(0);
                PersonChangeActivity.this.bjE();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(d.k.over_limit_tip);
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.fTz.bjJ().getIntro())) {
                    PersonChangeActivity.this.dLk = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(PersonChangeActivity.this.enT, d.C0141d.navi_op_text, 1);
                    } else {
                        al.c(PersonChangeActivity.this.enT, d.C0141d.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.fTz.bjJ().getSex() == 1) {
            this.mSex = 1;
            this.fTs.setText(d.k.male);
        } else if (this.fTz.bjJ().getSex() == 2) {
            this.mSex = 2;
            this.fTs.setText(d.k.female);
        } else {
            this.fTs.setText(d.k.change_sex);
        }
        this.fTu = (LinearLayout) findViewById(d.g.intro_text_tip);
        this.fTv = (TextView) findViewById(d.g.intro_text_tip_num);
        this.fTw = (TextView) findViewById(d.g.intro_text_tip_divider);
        this.fTx = (TextView) findViewById(d.g.intro_text_tip_limit);
        this.fTC = (ProgressBar) findViewById(d.g.image_progress);
        this.cFl = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cFl.dB(getPageContext().getString(d.k.confirm_giveup));
        this.cFl.a(getPageContext().getString(d.k.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.ajJ();
            }
        });
        this.cFl.b(getPageContext().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.fTz.bjJ().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.fTn.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.fTz.bjJ());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.fTz.bjJ());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.bjH();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.cFl.b(getPageContext());
    }

    private void bjC() {
        if (ah.ip() || this.fTz.bjJ().getNickNameLeftDays() == 0) {
            this.fTL.setVisibility(0);
        } else {
            this.fTL.setVisibility(8);
        }
    }

    public void bjD() {
        String[] strArr = {getPageContext().getString(d.k.change_photo), getPageContext().getString(d.k.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.cf(d.k.operation);
        bVar.a(strArr, new b.InterfaceC0103b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                if (i == 0) {
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) PersonChangeActivity.this.getPageContext().getPageActivity(), PersonChangeActivity.this.mWriteImagesInfo.toJsonString(), true);
                    albumActivityConfig.setRequestCode(IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK);
                    albumActivityConfig.setResourceType(2);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                } else if (i == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO)));
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext());
        bVar.xd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjE() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = al.getColor(d.C0141d.common_color_10159);
        } else {
            color = al.getColor(d.C0141d.common_color_10077);
        }
        rr(color);
    }

    private void rr(int i) {
        this.fTv.setTextColor(i);
        this.fTw.setTextColor(i);
        this.fTx.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajJ() {
        if (this.fTz != null && this.fTz.bjJ() != null) {
            bjA();
            if (!j.jD()) {
                showToast(d.k.neterror);
                return;
            }
            this.fTz.bjJ().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.fTz.bjJ().setSex(this.mSex);
            if (this.fTB == null) {
                this.fTB = new b(this.fTz);
                this.fTB.setPriority(3);
                this.fTB.execute(new String[0]);
            }
        }
    }

    private void bjF() {
        if (this.fTD == null) {
            this.fTD = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            final String string = getPageContext().getString(d.k.male);
            final String string2 = getPageContext().getString(d.k.female);
            this.fTD.cf(d.k.choose_sex);
            this.fTD.a(new String[]{string, string2}, new b.InterfaceC0103b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0103b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        PersonChangeActivity.this.mSex = 1;
                        PersonChangeActivity.this.fTs.setText(string);
                    } else if (i == 1) {
                        PersonChangeActivity.this.mSex = 2;
                        PersonChangeActivity.this.fTs.setText(string2);
                    }
                    if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.fTz.bjJ().getSex()) {
                        PersonChangeActivity.this.dLk = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            al.c(PersonChangeActivity.this.enT, d.C0141d.navi_op_text, 1);
                        } else {
                            al.c(PersonChangeActivity.this.enT, d.C0141d.cp_link_tip_a, 1);
                        }
                    }
                }
            });
            this.fTD.d(getPageContext());
        }
        this.fTD.xd();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bjA();
            this.fTP.onClick(null);
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
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            V(intent);
                            return;
                        } else {
                            O(intent);
                            return;
                        }
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.fTz.bjJ().setPhotoChanged(true);
                    bjG();
                    this.dLk = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(this.enT, d.C0141d.navi_op_text, 1);
                        return;
                    } else {
                        al.c(this.enT, d.C0141d.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.fTz.bjJ().setPhotoChanged(true);
                    if (intent != null) {
                        this.ddy.setImageBitmap(null);
                        this.ddy.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.dLk = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(this.enT, d.C0141d.navi_op_text, 1);
                        return;
                    } else {
                        al.c(this.enT, d.C0141d.cp_link_tip_a, 1);
                        return;
                    }
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    ak.b(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    private void sa(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fTE = true;
            this.fTz.bjJ().setPhotoChanged(true);
            this.fTz.bjJ().setNameShow(str);
            this.fTz.bjJ().setNickNameLeftDays(90);
            this.fTq.setText(str);
            bjC();
        }
    }

    private void O(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
            if (this.mWriteImagesInfo.getChosedFiles() != null && this.mWriteImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.mWriteImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.mWriteImagesInfo.clear();
        }
    }

    private void V(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void bjG() {
        if (this.fTA != null) {
            this.fTA.cancel();
        }
        this.egZ = null;
        this.fTA = new a();
        this.fTA.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjH() {
        if (this.fTz != null && this.fTz.bjJ() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.fTz.bjJ()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.fTC.setVisibility(0);
            PersonChangeActivity.this.ddy.setImageDrawable(null);
            PersonChangeActivity.this.egZ = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public Bitmap doInBackground(Object... objArr) {
            return l.ab(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.fTA = null;
            PersonChangeActivity.this.fTC.setVisibility(8);
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
            PersonChangeActivity.this.fTA = null;
            PersonChangeActivity.this.fTC.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.egZ = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.egZ.a(PersonChangeActivity.this.ddy);
                com.baidu.tbadk.imageManager.c.ID().a(PersonChangeActivity.this.fTz.bjJ().getPortrait(), PersonChangeActivity.this.egZ, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjI() {
        Intent intent = new Intent();
        if (this.fTn.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.fTz.bjJ());
        } else {
            intent.putExtra("data", this.fTz.bjJ());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.fTz.bjJ());
        setResult(-1, intent);
        bjH();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel fTz;
        private y mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.fTz = null;
            this.fTz = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.fTB = null;
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.fTB = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.yJ().zJ().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(d.k.success));
                    PersonChangeActivity.this.bjI();
                } else {
                    PersonChangeActivity.this.showToast(this.mNetWork.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(d.k.saving), PersonChangeActivity.this.mDialogCancelListener);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (this.fTz != null) {
                this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.fTz.bjJ().getSex()));
                this.mNetWork.o("intro", this.fTz.bjJ().getIntro());
                this.mNetWork.yo();
                if (this.mNetWork.yJ().zJ().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.bxP();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dik && !TextUtils.isEmpty(this.fTO)) {
            sa(this.fTO);
            this.dik = false;
            this.fTO = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sb(String str) {
        if (!StringUtils.isNull(str)) {
            this.fTG = true;
            this.fTI.setText(str);
            this.fTH.setClickable(false);
            this.fTJ.setVisibility(8);
        }
    }
}
