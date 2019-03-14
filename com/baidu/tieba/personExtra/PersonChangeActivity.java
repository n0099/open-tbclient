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
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.s.ao;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private com.baidu.tbadk.coreExtra.view.c bVX;
    private View bua;
    private ImageView bub;
    private View hOI;
    private View hPc;
    private TextView hPd;
    private View hPe;
    private View hPf;
    private View hPg;
    private View hPh;
    private com.baidu.tbadk.core.dialog.a hPi;
    private String hPj;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public final int hOG = 90;
    private Boolean hOH = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView gmx = null;
    private LinearLayout eLC = null;
    private ScrollView hOJ = null;
    private TextView hOK = null;
    private LinearLayout hOL = null;
    private TextView hOM = null;
    private LinearLayout hON = null;
    private TextView dlJ = null;
    private EditText mEdit = null;
    private LinearLayout hOO = null;
    private TextView hOP = null;
    private TextView hOQ = null;
    private TextView hOR = null;
    private InputMethodManager mInputManager = null;
    private boolean hOS = false;
    private PersonChangeModel hOT = null;
    protected HeadImageView eUB = null;
    private com.baidu.adp.widget.ImageView.a gfE = null;
    private a hOU = null;
    private b hOV = null;
    private ProgressBar hOW = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a eph = null;
    private g hOX = null;
    private boolean hOY = false;
    private boolean fEE = false;
    private boolean hOZ = false;
    private int mSex = 0;
    private final int hPa = 500;
    private boolean hPb = false;
    private boolean eZG = false;
    private final View.OnClickListener hPk = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.hOT.bRw().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.hOY = true;
            }
            if (PersonChangeActivity.this.hOY) {
                PersonChangeActivity.this.eph.aaZ();
                return;
            }
            if (PersonChangeActivity.this.hOT != null && PersonChangeActivity.this.hOT.bRw().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.hOH.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.hOT.bRw());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.hOT.bRw());
                }
                PersonChangeActivity.this.bRu();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener faq = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.eZG = true;
                        PersonChangeActivity.this.hPj = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener hPl = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.hOT != null && PersonChangeActivity.this.hOT.bRw() != null && personChangeData != null) {
                    PersonChangeActivity.this.hOT.bRw().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.hOT.bRw().setMem(personChangeData.getMen());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ad(bundle);
        awm();
        if (bundle != null) {
            this.hOH = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.hOH = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.faq);
        registerListener(this.hPl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.faq);
        if (this.hOU != null) {
            this.hOU.cancel();
        }
        if (this.hOV != null) {
            this.hOV.cancel();
        }
        if (this.hOW != null) {
            this.hOW.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        if (this.bVX != null) {
            this.bVX.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eUB || view == this.hPh) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.adQ();
            this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.Y(pageActivity)) {
                bRq();
            }
        } else if (view == this.hOI) {
            if (!this.fEE && !this.hOZ) {
                finish();
            }
            if (this.hOH.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.fEE) {
                aRl();
            } else if (this.hOZ) {
                bRv();
            }
        } else if (view == this.hOL) {
            bRs();
        } else if (view == this.hON) {
            bRo();
        } else if (view == this.mEdit) {
            xd(800);
        } else if (view == this.hPf) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(d.j.support_modify_nickname));
            } else if (ao.jK()) {
                bRm();
            } else {
                int nickNameLeftDays = this.hOT.bRw().getNickNameLeftDays();
                if (this.hOT.bRw().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.ly(String.format(getPageContext().getPageActivity().getString(d.j.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
                        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                if (j.kY()) {
                                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), 24);
                                    memberPayActivityConfig.setReferPageClickZone("my_data_V8.9", "pop_ups_opende_button_V8.9");
                                    PersonChangeActivity.this.sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                                    TiebaStatic.log("c12409");
                                } else {
                                    PersonChangeActivity.this.showToast(d.j.neterror);
                                }
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(getPageContext()).aaZ();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(d.j.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(d.j.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.hPc) {
            if (this.hOT == null || this.hOT.bRw() == null || StringUtils.isNull(this.hOT.bRw().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void bRm() {
        if (this.hPi == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.person_nickname_act_dialog, (ViewGroup) null);
            this.hPi = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.hPi.az(inflate);
            this.hPi.a(d.j.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.bHK(), true)));
                    aVar.dismiss();
                }
            });
            this.hPi.b(d.j.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hPi.b(getPageContext());
            al.j(inflate.findViewById(d.g.nickname_dialog_title), d.C0277d.cp_cont_b);
            al.j(inflate.findViewById(d.g.nickname_dialog_tip), d.C0277d.common_color_10122);
        }
        this.hPi.aaZ();
    }

    private void i(AccountData accountData) {
        if (this.bVX == null) {
            this.bVX = new com.baidu.tbadk.coreExtra.view.c(this);
            this.bVX.a(new c.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.AH(accountData2.getAccount());
                    }
                }
            });
        }
        this.bVX.akm();
        this.bVX.setAccountData(accountData);
        this.bVX.aki();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.hOS = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.hOS) {
            bRn();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRn() {
        if (this.mEdit.getVisibility() == 0) {
            this.hOO.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.dlJ.setText(replaceAll);
            } else {
                this.dlJ.setText(getPageContext().getString(d.j.add_intro));
            }
            if (this.hOT.bRw().getIntro() == null || !this.hOT.bRw().getIntro().equals(replaceAll)) {
                this.hOY = true;
            }
            this.hOT.bRw().setIntro(replaceAll);
            this.dlJ.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void bRo() {
        if (this.mEdit.getVisibility() != 0) {
            this.dlJ.setVisibility(8);
            this.mEdit.setText(this.hOT.bRw().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            xd(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xd(int i) {
        this.hOJ.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.hOJ.fullScroll(130);
            }
        }, i);
    }

    private void ad(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.hOV != null) {
                    PersonChangeActivity.this.hOV.cancel();
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
        this.hOT = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.eLC);
        al.a(this.bub, d.f.icon_nav_close, d.f.icon_nav_close_w, d.f.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eUB.refresh();
        al.j(this.hPd, d.C0277d.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.hOT.bRw() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.hOT.bRw()));
        }
    }

    private void awm() {
        this.hPh = findViewById(d.g.photo_pop_icon);
        this.hPh.setOnClickListener(this);
        this.eUB = (HeadImageView) findViewById(d.g.photo);
        this.eUB.setOnClickListener(this);
        this.eUB.startLoad(o.ms(this.hOT.bRw().getPortrait()), 25, false);
        this.eLC = (LinearLayout) findViewById(d.g.parent);
        this.hOJ = (ScrollView) findViewById(d.g.person_change_scroll);
        this.hOL = (LinearLayout) findViewById(d.g.person_sex);
        this.hOM = (TextView) findViewById(d.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.bua = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, this.hPk);
        this.bub = (ImageView) this.bua.findViewById(d.g.widget_navi_back_button);
        this.bub.setContentDescription(getPageContext().getPageActivity().getResources().getString(d.j.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.my_info));
        this.hOI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.gmx = (TextView) this.hOI.findViewById(d.g.right_textview);
        this.gmx.setText(getPageContext().getString(d.j.save));
        al.d(this.gmx, d.C0277d.navi_op_text, 1);
        this.hOI.setOnClickListener(this);
        this.hOL.setOnClickListener(this);
        this.hON = (LinearLayout) findViewById(d.g.intro_click);
        this.hON.setOnClickListener(this);
        this.hON.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.hOS = true;
                    return false;
                }
                return false;
            }
        });
        this.hOK = (TextView) findViewById(d.g.nick_name_show);
        this.hOK.setText(this.hOT.bRw().getNameShow());
        this.hPf = findViewById(d.g.person_nickname);
        this.hPf.setOnClickListener(this);
        this.hPg = findViewById(d.g.nick_name_more);
        bRp();
        this.hPd = (TextView) findViewById(d.g.user_name_show);
        this.hPc = findViewById(d.g.person_name);
        this.hPe = findViewById(d.g.user_name_more_icon);
        this.hPc.setOnClickListener(this);
        if (StringUtils.isNull(this.hOT.bRw().getName())) {
            this.hPd.setText(getPageContext().getString(d.j.tip_empty_user_name));
            this.hPb = false;
            this.hPc.setClickable(true);
            this.hPe.setVisibility(0);
        } else {
            this.hPd.setText(this.hOT.bRw().getName());
            this.hPb = true;
            this.hPc.setClickable(false);
            this.hPe.setVisibility(8);
        }
        this.dlJ = (TextView) findViewById(d.g.intro);
        if (this.hOT.bRw().getIntro() != null && this.hOT.bRw().getIntro().length() > 0) {
            this.dlJ.setText(this.hOT.bRw().getIntro());
        } else {
            this.dlJ.setText(getPageContext().getString(d.j.add_intro));
        }
        this.mEdit = (EditText) findViewById(d.g.edit);
        this.mEdit.setText(this.hOT.bRw().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.bRn();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.hOS = true;
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
                PersonChangeActivity.this.hOP.setText(String.valueOf(length));
                PersonChangeActivity.this.hOO.setVisibility(0);
                PersonChangeActivity.this.xd(0);
                PersonChangeActivity.this.bRr();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(d.j.over_limit_tip);
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.hOT.bRw().getIntro())) {
                    PersonChangeActivity.this.fEE = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.d(PersonChangeActivity.this.gmx, d.C0277d.navi_op_text, 1);
                    } else {
                        al.d(PersonChangeActivity.this.gmx, d.C0277d.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.hOT.bRw().getSex() == 1) {
            this.mSex = 1;
            this.hOM.setText(d.j.male);
        } else if (this.hOT.bRw().getSex() == 2) {
            this.mSex = 2;
            this.hOM.setText(d.j.female);
        } else {
            this.hOM.setText(d.j.change_sex);
        }
        this.hOO = (LinearLayout) findViewById(d.g.intro_text_tip);
        this.hOP = (TextView) findViewById(d.g.intro_text_tip_num);
        this.hOQ = (TextView) findViewById(d.g.intro_text_tip_divider);
        this.hOR = (TextView) findViewById(d.g.intro_text_tip_limit);
        this.hOW = (ProgressBar) findViewById(d.g.image_progress);
        this.eph = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.eph.ly(getPageContext().getString(d.j.confirm_giveup));
        this.eph.a(getPageContext().getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.aRl();
            }
        });
        this.eph.b(getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.hOT.bRw().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.hOH.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.hOT.bRw());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.hOT.bRw());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.bRu();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.eph.b(getPageContext());
    }

    private void bRp() {
        if (ao.jK() || this.hOT.bRw().getNickNameLeftDays() == 0) {
            this.hPg.setVisibility(0);
        } else {
            this.hPg.setVisibility(8);
        }
    }

    public void bRq() {
        String[] strArr = {getPageContext().getString(d.j.change_photo), getPageContext().getString(d.j.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.gG(d.j.operation);
        bVar.a(strArr, new b.InterfaceC0225b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
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
        bVar.abc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRr() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = al.getColor(d.C0277d.common_color_10159);
        } else {
            color = al.getColor(d.C0277d.common_color_10077);
        }
        xe(color);
    }

    private void xe(int i) {
        this.hOP.setTextColor(i);
        this.hOQ.setTextColor(i);
        this.hOR.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRl() {
        if (this.hOT != null && this.hOT.bRw() != null) {
            bRn();
            if (!j.kY()) {
                showToast(d.j.neterror);
                return;
            }
            this.hOT.bRw().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.hOT.bRw().setSex(this.mSex);
            if (this.hOV == null) {
                this.hOV = new b(this.hOT);
                this.hOV.setPriority(3);
                this.hOV.execute(new String[0]);
            }
        }
    }

    private void bRs() {
        if (this.hOX == null) {
            this.hOX = new g(getPageContext());
            final String string = getPageContext().getString(d.j.male);
            final String string2 = getPageContext().getString(d.j.female);
            this.hOX.a(getString(d.j.choose_sex), new String[]{string, string2}, new i.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.i.c
                public void a(i iVar, int i, View view) {
                    if (PersonChangeActivity.this.hOX != null && PersonChangeActivity.this.hOX.isShowing()) {
                        PersonChangeActivity.this.hOX.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.hOM.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.hOM.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.hOT.bRw().getSex()) {
                            PersonChangeActivity.this.fEE = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                al.d(PersonChangeActivity.this.gmx, d.C0277d.navi_op_text, 1);
                            } else {
                                al.d(PersonChangeActivity.this.gmx, d.C0277d.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.hOX.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bRn();
            this.hPk.onClick(null);
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
                            aq(intent);
                            return;
                        } else {
                            aj(intent);
                            return;
                        }
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.hOT.bRw().setPhotoChanged(true);
                    bRt();
                    this.fEE = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.d(this.gmx, d.C0277d.navi_op_text, 1);
                        return;
                    } else {
                        al.d(this.gmx, d.C0277d.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.hOT.bRw().setPhotoChanged(true);
                    if (intent != null) {
                        this.eUB.setImageBitmap(null);
                        this.eUB.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.fEE = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.d(this.gmx, d.C0277d.navi_op_text, 1);
                        return;
                    } else {
                        al.d(this.gmx, d.C0277d.cp_link_tip_a, 1);
                        return;
                    }
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    ak.c(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    private void AG(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hOZ = true;
            this.hOT.bRw().setPhotoChanged(true);
            this.hOT.bRw().setNameShow(str);
            this.hOT.bRw().setNickNameLeftDays(90);
            this.hOK.setText(str);
            bRp();
        }
    }

    private void aj(Intent intent) {
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

    private void aq(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void bRt() {
        if (this.hOU != null) {
            this.hOU.cancel();
        }
        this.gfE = null;
        this.hOU = new a();
        this.hOU.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRu() {
        if (this.hOT != null && this.hOT.bRw() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.hOT.bRw()));
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
            PersonChangeActivity.this.hOW.setVisibility(0);
            PersonChangeActivity.this.eUB.setImageDrawable(null);
            PersonChangeActivity.this.gfE = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public Bitmap doInBackground(Object... objArr) {
            return m.bF(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.hOU = null;
            PersonChangeActivity.this.hOW.setVisibility(8);
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
            PersonChangeActivity.this.hOU = null;
            PersonChangeActivity.this.hOW.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.gfE = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.gfE.a(PersonChangeActivity.this.eUB);
                com.baidu.tbadk.imageManager.c.anp().a(PersonChangeActivity.this.hOT.bRw().getPortrait(), PersonChangeActivity.this.gfE, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRv() {
        Intent intent = new Intent();
        if (this.hOH.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.hOT.bRw());
        } else {
            intent.putExtra("data", this.hOT.bRw());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.hOT.bRw());
        setResult(-1, intent);
        bRu();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel hOT;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.hOT = null;
            this.hOT = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.hOV = null;
            if (this.mNetWork != null) {
                this.mNetWork.ji();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.hOV = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.acH().adG().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(d.j.success));
                    PersonChangeActivity.this.bRv();
                } else {
                    PersonChangeActivity.this.showToast(this.mNetWork.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(d.j.saving), PersonChangeActivity.this.mDialogCancelListener);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.hOT != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.x(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.hOT.bRw().getSex()));
                this.mNetWork.x("intro", this.hOT.bRw().getIntro());
                this.mNetWork.acm();
                if (this.mNetWork.acH().adG().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.cfi();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.eZG && !TextUtils.isEmpty(this.hPj)) {
            AG(this.hPj);
            this.eZG = false;
            this.hPj = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AH(String str) {
        if (!StringUtils.isNull(str)) {
            this.hPb = true;
            this.hPd.setText(str);
            this.hPc.setClickable(false);
            this.hPe.setVisibility(8);
        }
    }
}
