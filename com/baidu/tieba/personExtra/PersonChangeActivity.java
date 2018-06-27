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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.p;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.view.a;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.o.ai;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private com.baidu.tbadk.coreExtra.view.a aBd;
    private View abv;
    private ImageView abw;
    private com.baidu.tbadk.core.util.b.a bkp;
    private View fXJ;
    private TextView fXK;
    private View fXL;
    private View fXM;
    private View fXN;
    private View fXO;
    private com.baidu.tbadk.core.dialog.a fXP;
    private String fXQ;
    private View fXq;
    public final int fXo = 90;
    private Boolean fXp = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView erO = null;
    private LinearLayout cWw = null;
    private ScrollView fXr = null;
    private TextView fXs = null;
    private LinearLayout fXt = null;
    private TextView fXu = null;
    private LinearLayout fXv = null;
    private TextView bCu = null;
    private EditText mEdit = null;
    private LinearLayout fXw = null;
    private TextView fXx = null;
    private TextView fXy = null;
    private TextView fXz = null;
    private InputMethodManager mInputManager = null;
    private boolean fXA = false;
    private PersonChangeModel fXB = null;
    protected HeadImageView dfq = null;
    private com.baidu.adp.widget.ImageView.a ekS = null;
    private a fXC = null;
    private b fXD = null;
    private ProgressBar fXE = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a cDe = null;
    private com.baidu.tbadk.core.dialog.b fXF = null;
    private boolean fWa = false;
    private boolean dOB = false;
    private boolean fXG = false;
    private int mSex = 0;
    private final int fXH = 500;
    private boolean fXI = false;
    private boolean dki = false;
    private final View.OnClickListener fXR = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.fXB.bkp().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.fWa = true;
            }
            if (PersonChangeActivity.this.fWa) {
                PersonChangeActivity.this.cDe.xn();
                return;
            }
            if (PersonChangeActivity.this.fXB != null && PersonChangeActivity.this.fXB.bkp().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.fXp.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.fXB.bkp());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.fXB.bkp());
                }
                PersonChangeActivity.this.bkn();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener dkP = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.dki = true;
                        PersonChangeActivity.this.fXQ = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener fXS = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.fXB != null && PersonChangeActivity.this.fXB.bkp() != null && personChangeData != null) {
                    PersonChangeActivity.this.fXB.bkp().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.fXB.bkp().setMem(personChangeData.getMen());
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
        QD();
        if (bundle != null) {
            this.fXp = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.fXp = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.dkP);
        registerListener(this.fXS);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dkP);
        if (this.fXC != null) {
            this.fXC.cancel();
        }
        if (this.fXD != null) {
            this.fXD.cancel();
        }
        if (this.fXE != null) {
            this.fXE.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        if (this.aBd != null) {
            this.aBd.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dfq || view == this.fXO) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.bkp == null) {
                this.bkp = new com.baidu.tbadk.core.util.b.a();
            }
            this.bkp.Aj();
            this.bkp.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.bkp.u(pageActivity)) {
                bkj();
            }
        } else if (view == this.fXq) {
            if (!this.dOB && !this.fXG) {
                finish();
            }
            if (this.fXp.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.dOB) {
                ajd();
            } else if (this.fXG) {
                bko();
            }
        } else if (view == this.fXt) {
            bkl();
        } else if (view == this.fXv) {
            bkh();
        } else if (view == this.mEdit) {
            rz(800);
        } else if (view == this.fXM) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(d.k.support_modify_nickname));
            } else if (ai.ip()) {
                bkf();
            } else {
                int nickNameLeftDays = this.fXB.bkp().getNickNameLeftDays();
                if (this.fXB.bkp().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.dE(String.format(getPageContext().getPageActivity().getString(d.k.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).xn();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(d.k.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(d.k.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.fXJ) {
            if (this.fXB == null || this.fXB.bkp() == null || StringUtils.isNull(this.fXB.bkp().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void bkf() {
        if (this.fXP == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.person_nickname_act_dialog, (ViewGroup) null);
            this.fXP = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.fXP.w(inflate);
            this.fXP.a(d.k.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.baD(), true)));
                    aVar.dismiss();
                }
            });
            this.fXP.b(d.k.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fXP.b(getPageContext());
            am.h(inflate.findViewById(d.g.nickname_dialog_title), d.C0142d.cp_cont_b);
            am.h(inflate.findViewById(d.g.nickname_dialog_tip), d.C0142d.common_color_10122);
        }
        this.fXP.xn();
    }

    private void i(AccountData accountData) {
        if (this.aBd == null) {
            this.aBd = new com.baidu.tbadk.coreExtra.view.a(this);
            this.aBd.a(new a.InterfaceC0110a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0110a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.sa(accountData2.getAccount());
                    }
                }
            });
        }
        this.aBd.FR();
        this.aBd.setAccountData(accountData);
        this.aBd.FN();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.fXA = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.fXA) {
            bkg();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkg() {
        if (this.mEdit.getVisibility() == 0) {
            this.fXw.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.bCu.setText(replaceAll);
            } else {
                this.bCu.setText(getPageContext().getString(d.k.add_intro));
            }
            if (this.fXB.bkp().getIntro() == null || !this.fXB.bkp().getIntro().equals(replaceAll)) {
                this.fWa = true;
            }
            this.fXB.bkp().setIntro(replaceAll);
            this.bCu.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void bkh() {
        if (this.mEdit.getVisibility() != 0) {
            this.bCu.setVisibility(8);
            this.mEdit.setText(this.fXB.bkp().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            rz(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rz(int i) {
        this.fXr.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.fXr.fullScroll(130);
            }
        }, i);
    }

    private void C(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.fXD != null) {
                    PersonChangeActivity.this.fXD.cancel();
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
        this.fXB = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.cWw);
        am.a(this.abw, d.f.icon_nav_close, d.f.icon_nav_close_w, d.f.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dfq.refresh();
        am.h(this.fXK, d.C0142d.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.fXB.bkp() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.fXB.bkp()));
        }
    }

    private void QD() {
        this.fXO = findViewById(d.g.photo_pop_icon);
        this.fXO.setOnClickListener(this);
        this.dfq = (HeadImageView) findViewById(d.g.photo);
        this.dfq.setOnClickListener(this);
        this.dfq.startLoad(p.ex(this.fXB.bkp().getPortrait()), 25, false);
        this.cWw = (LinearLayout) findViewById(d.g.parent);
        this.fXr = (ScrollView) findViewById(d.g.person_change_scroll);
        this.fXt = (LinearLayout) findViewById(d.g.person_sex);
        this.fXu = (TextView) findViewById(d.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.abv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.widget_nb_item_finish, this.fXR);
        this.abw = (ImageView) this.abv.findViewById(d.g.widget_navi_back_button);
        this.abw.setContentDescription(getPageContext().getPageActivity().getResources().getString(d.k.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.k.my_info));
        this.fXq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, (View.OnClickListener) null);
        this.erO = (TextView) this.fXq.findViewById(d.g.right_textview);
        this.erO.setText(getPageContext().getString(d.k.save));
        am.c(this.erO, d.C0142d.navi_op_text, 1);
        this.fXq.setOnClickListener(this);
        this.fXt.setOnClickListener(this);
        this.fXv = (LinearLayout) findViewById(d.g.intro_click);
        this.fXv.setOnClickListener(this);
        this.fXv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.fXA = true;
                    return false;
                }
                return false;
            }
        });
        this.fXs = (TextView) findViewById(d.g.nick_name_show);
        this.fXs.setText(this.fXB.bkp().getNameShow());
        this.fXM = findViewById(d.g.person_nickname);
        this.fXM.setOnClickListener(this);
        this.fXN = findViewById(d.g.nick_name_more);
        bki();
        this.fXK = (TextView) findViewById(d.g.user_name_show);
        this.fXJ = findViewById(d.g.person_name);
        this.fXL = findViewById(d.g.user_name_more_icon);
        this.fXJ.setOnClickListener(this);
        if (StringUtils.isNull(this.fXB.bkp().getName())) {
            this.fXK.setText(getPageContext().getString(d.k.tip_empty_user_name));
            this.fXI = false;
            this.fXJ.setClickable(true);
            this.fXL.setVisibility(0);
        } else {
            this.fXK.setText(this.fXB.bkp().getName());
            this.fXI = true;
            this.fXJ.setClickable(false);
            this.fXL.setVisibility(8);
        }
        this.bCu = (TextView) findViewById(d.g.intro);
        if (this.fXB.bkp().getIntro() != null && this.fXB.bkp().getIntro().length() > 0) {
            this.bCu.setText(this.fXB.bkp().getIntro());
        } else {
            this.bCu.setText(getPageContext().getString(d.k.add_intro));
        }
        this.mEdit = (EditText) findViewById(d.g.edit);
        this.mEdit.setText(this.fXB.bkp().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.bkg();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.fXA = true;
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
                PersonChangeActivity.this.fXx.setText(String.valueOf(length));
                PersonChangeActivity.this.fXw.setVisibility(0);
                PersonChangeActivity.this.rz(0);
                PersonChangeActivity.this.bkk();
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.fXB.bkp().getIntro())) {
                    PersonChangeActivity.this.dOB = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.c(PersonChangeActivity.this.erO, d.C0142d.navi_op_text, 1);
                    } else {
                        am.c(PersonChangeActivity.this.erO, d.C0142d.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.fXB.bkp().getSex() == 1) {
            this.mSex = 1;
            this.fXu.setText(d.k.male);
        } else if (this.fXB.bkp().getSex() == 2) {
            this.mSex = 2;
            this.fXu.setText(d.k.female);
        } else {
            this.fXu.setText(d.k.change_sex);
        }
        this.fXw = (LinearLayout) findViewById(d.g.intro_text_tip);
        this.fXx = (TextView) findViewById(d.g.intro_text_tip_num);
        this.fXy = (TextView) findViewById(d.g.intro_text_tip_divider);
        this.fXz = (TextView) findViewById(d.g.intro_text_tip_limit);
        this.fXE = (ProgressBar) findViewById(d.g.image_progress);
        this.cDe = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cDe.dE(getPageContext().getString(d.k.confirm_giveup));
        this.cDe.a(getPageContext().getString(d.k.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.ajd();
            }
        });
        this.cDe.b(getPageContext().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.fXB.bkp().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.fXp.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.fXB.bkp());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.fXB.bkp());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.bkn();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.cDe.b(getPageContext());
    }

    private void bki() {
        if (ai.ip() || this.fXB.bkp().getNickNameLeftDays() == 0) {
            this.fXN.setVisibility(0);
        } else {
            this.fXN.setVisibility(8);
        }
    }

    public void bkj() {
        String[] strArr = {getPageContext().getString(d.k.change_photo), getPageContext().getString(d.k.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.cg(d.k.operation);
        bVar.a(strArr, new b.InterfaceC0104b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
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
        bVar.xq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkk() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = am.getColor(d.C0142d.common_color_10159);
        } else {
            color = am.getColor(d.C0142d.common_color_10077);
        }
        rA(color);
    }

    private void rA(int i) {
        this.fXx.setTextColor(i);
        this.fXy.setTextColor(i);
        this.fXz.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajd() {
        if (this.fXB != null && this.fXB.bkp() != null) {
            bkg();
            if (!j.jD()) {
                showToast(d.k.neterror);
                return;
            }
            this.fXB.bkp().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.fXB.bkp().setSex(this.mSex);
            if (this.fXD == null) {
                this.fXD = new b(this.fXB);
                this.fXD.setPriority(3);
                this.fXD.execute(new String[0]);
            }
        }
    }

    private void bkl() {
        if (this.fXF == null) {
            this.fXF = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            final String string = getPageContext().getString(d.k.male);
            final String string2 = getPageContext().getString(d.k.female);
            this.fXF.cg(d.k.choose_sex);
            this.fXF.a(new String[]{string, string2}, new b.InterfaceC0104b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        PersonChangeActivity.this.mSex = 1;
                        PersonChangeActivity.this.fXu.setText(string);
                    } else if (i == 1) {
                        PersonChangeActivity.this.mSex = 2;
                        PersonChangeActivity.this.fXu.setText(string2);
                    }
                    if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.fXB.bkp().getSex()) {
                        PersonChangeActivity.this.dOB = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            am.c(PersonChangeActivity.this.erO, d.C0142d.navi_op_text, 1);
                        } else {
                            am.c(PersonChangeActivity.this.erO, d.C0142d.cp_link_tip_a, 1);
                        }
                    }
                }
            });
            this.fXF.d(getPageContext());
        }
        this.fXF.xq();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bkg();
            this.fXR.onClick(null);
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
                    this.fXB.bkp().setPhotoChanged(true);
                    bkm();
                    this.dOB = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.c(this.erO, d.C0142d.navi_op_text, 1);
                        return;
                    } else {
                        am.c(this.erO, d.C0142d.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.fXB.bkp().setPhotoChanged(true);
                    if (intent != null) {
                        this.dfq.setImageBitmap(null);
                        this.dfq.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.dOB = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.c(this.erO, d.C0142d.navi_op_text, 1);
                        return;
                    } else {
                        am.c(this.erO, d.C0142d.cp_link_tip_a, 1);
                        return;
                    }
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    al.b(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    private void rZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fXG = true;
            this.fXB.bkp().setPhotoChanged(true);
            this.fXB.bkp().setNameShow(str);
            this.fXB.bkp().setNickNameLeftDays(90);
            this.fXs.setText(str);
            bki();
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
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void bkm() {
        if (this.fXC != null) {
            this.fXC.cancel();
        }
        this.ekS = null;
        this.fXC = new a();
        this.fXC.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkn() {
        if (this.fXB != null && this.fXB.bkp() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.fXB.bkp()));
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
            PersonChangeActivity.this.fXE.setVisibility(0);
            PersonChangeActivity.this.dfq.setImageDrawable(null);
            PersonChangeActivity.this.ekS = null;
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
            PersonChangeActivity.this.fXC = null;
            PersonChangeActivity.this.fXE.setVisibility(8);
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
            PersonChangeActivity.this.fXC = null;
            PersonChangeActivity.this.fXE.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.ekS = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.ekS.a(PersonChangeActivity.this.dfq);
                com.baidu.tbadk.imageManager.c.IV().a(PersonChangeActivity.this.fXB.bkp().getPortrait(), PersonChangeActivity.this.ekS, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bko() {
        Intent intent = new Intent();
        if (this.fXp.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.fXB.bkp());
        } else {
            intent.putExtra("data", this.fXB.bkp());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.fXB.bkp());
        setResult(-1, intent);
        bkn();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel fXB;
        private y mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.fXB = null;
            this.fXB = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.fXD = null;
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.fXD = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.yX().zY().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(d.k.success));
                    PersonChangeActivity.this.bko();
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
            if (this.fXB != null) {
                this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.fXB.bkp().getSex()));
                this.mNetWork.o("intro", this.fXB.bkp().getIntro());
                this.mNetWork.yC();
                if (this.mNetWork.yX().zY().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.byt();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dki && !TextUtils.isEmpty(this.fXQ)) {
            rZ(this.fXQ);
            this.dki = false;
            this.fXQ = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sa(String str) {
        if (!StringUtils.isNull(str)) {
            this.fXI = true;
            this.fXK.setText(str);
            this.fXJ.setClickable(false);
            this.fXL.setVisibility(8);
        }
    }
}
