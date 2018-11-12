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
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.view.a;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.p.an;
import com.baidu.tieba.e;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private com.baidu.tbadk.coreExtra.view.a aJs;
    private View ajm;
    private ImageView ajn;
    private com.baidu.tbadk.core.util.b.a bvI;
    private View gnY;
    private View gor;
    private TextView gos;
    private View got;
    private View gou;
    private View gov;
    private View gow;
    private com.baidu.tbadk.core.dialog.a gox;
    private String goy;
    public final int gnW = 90;
    private Boolean gnX = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView eLX = null;
    private LinearLayout dop = null;
    private ScrollView gnZ = null;
    private TextView goa = null;
    private LinearLayout gob = null;
    private TextView goc = null;
    private LinearLayout god = null;
    private TextView bSg = null;
    private EditText mEdit = null;
    private LinearLayout goe = null;
    private TextView gof = null;
    private TextView gog = null;
    private TextView goh = null;
    private InputMethodManager mInputManager = null;
    private boolean goi = false;
    private PersonChangeModel goj = null;
    protected HeadImageView dxr = null;
    private com.baidu.adp.widget.ImageView.a eFi = null;
    private a gok = null;
    private b gol = null;
    private ProgressBar gom = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a cUX = null;
    private com.baidu.tbadk.core.dialog.b gon = null;
    private boolean gmH = false;
    private boolean ehP = false;
    private boolean goo = false;
    private int mSex = 0;
    private final int gop = 500;
    private boolean goq = false;
    private boolean dCl = false;
    private final View.OnClickListener goz = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.goj.bnM().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.gmH = true;
            }
            if (PersonChangeActivity.this.gmH) {
                PersonChangeActivity.this.cUX.AB();
                return;
            }
            if (PersonChangeActivity.this.goj != null && PersonChangeActivity.this.goj.bnM().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.gnX.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.goj.bnM());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.goj.bnM());
                }
                PersonChangeActivity.this.bnK();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener dCT = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.dCl = true;
                        PersonChangeActivity.this.goy = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener goA = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.goj != null && PersonChangeActivity.this.goj.bnM() != null && personChangeData != null) {
                    PersonChangeActivity.this.goj.bnM().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.goj.bnM().setMem(personChangeData.getMen());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.h.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        G(bundle);
        UI();
        if (bundle != null) {
            this.gnX = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.gnX = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.dCT);
        registerListener(this.goA);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dCT);
        if (this.gok != null) {
            this.gok.cancel();
        }
        if (this.gol != null) {
            this.gol.cancel();
        }
        if (this.gom != null) {
            this.gom.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        if (this.aJs != null) {
            this.aJs.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dxr || view == this.gow) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.bvI == null) {
                this.bvI = new com.baidu.tbadk.core.util.b.a();
            }
            this.bvI.Dp();
            this.bvI.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.bvI.A(pageActivity)) {
                bnG();
            }
        } else if (view == this.gnY) {
            if (!this.ehP && !this.goo) {
                finish();
            }
            if (this.gnX.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.ehP) {
                aou();
            } else if (this.goo) {
                bnL();
            }
        } else if (view == this.gob) {
            bnI();
        } else if (view == this.god) {
            bnE();
        } else if (view == this.mEdit) {
            sJ(800);
        } else if (view == this.gou) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(e.j.support_modify_nickname));
            } else if (an.jJ()) {
                bnC();
            } else {
                int nickNameLeftDays = this.goj.bnM().getNickNameLeftDays();
                if (this.goj.bnM().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.ej(String.format(getPageContext().getPageActivity().getString(e.j.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
                        aVar.a(e.j.open_now, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                if (j.kV()) {
                                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), 24);
                                    memberPayActivityConfig.setReferPageClickZone("my_data_V8.9", "pop_ups_opende_button_V8.9");
                                    PersonChangeActivity.this.sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                                    TiebaStatic.log("c12409");
                                } else {
                                    PersonChangeActivity.this.showToast(e.j.neterror);
                                }
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(getPageContext()).AB();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(e.j.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(e.j.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.gor) {
            if (this.goj == null || this.goj.bnM() == null || StringUtils.isNull(this.goj.bnM().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void bnC() {
        if (this.gox == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.person_nickname_act_dialog, (ViewGroup) null);
            this.gox = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.gox.G(inflate);
            this.gox.a(e.j.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.bec(), true)));
                    aVar.dismiss();
                }
            });
            this.gox.b(e.j.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gox.b(getPageContext());
            al.h(inflate.findViewById(e.g.nickname_dialog_title), e.d.cp_cont_b);
            al.h(inflate.findViewById(e.g.nickname_dialog_tip), e.d.common_color_10122);
        }
        this.gox.AB();
    }

    private void i(AccountData accountData) {
        if (this.aJs == null) {
            this.aJs = new com.baidu.tbadk.coreExtra.view.a(this);
            this.aJs.a(new a.InterfaceC0155a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0155a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.th(accountData2.getAccount());
                    }
                }
            });
        }
        this.aJs.Jq();
        this.aJs.setAccountData(accountData);
        this.aJs.Jm();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.goi = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.goi) {
            bnD();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnD() {
        if (this.mEdit.getVisibility() == 0) {
            this.goe.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.bSg.setText(replaceAll);
            } else {
                this.bSg.setText(getPageContext().getString(e.j.add_intro));
            }
            if (this.goj.bnM().getIntro() == null || !this.goj.bnM().getIntro().equals(replaceAll)) {
                this.gmH = true;
            }
            this.goj.bnM().setIntro(replaceAll);
            this.bSg.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void bnE() {
        if (this.mEdit.getVisibility() != 0) {
            this.bSg.setVisibility(8);
            this.mEdit.setText(this.goj.bnM().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            sJ(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sJ(int i) {
        this.gnZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.gnZ.fullScroll(130);
            }
        }, i);
    }

    private void G(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.gol != null) {
                    PersonChangeActivity.this.gol.cancel();
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
        this.goj = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.dop);
        al.a(this.ajn, e.f.icon_nav_close, e.f.icon_nav_close_w, e.f.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dxr.refresh();
        al.h(this.gos, e.d.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.goj.bnM() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.goj.bnM()));
        }
    }

    private void UI() {
        this.gow = findViewById(e.g.photo_pop_icon);
        this.gow.setOnClickListener(this);
        this.dxr = (HeadImageView) findViewById(e.g.photo);
        this.dxr.setOnClickListener(this);
        this.dxr.startLoad(o.fc(this.goj.bnM().getPortrait()), 25, false);
        this.dop = (LinearLayout) findViewById(e.g.parent);
        this.gnZ = (ScrollView) findViewById(e.g.person_change_scroll);
        this.gob = (LinearLayout) findViewById(e.g.person_sex);
        this.goc = (TextView) findViewById(e.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.ajm = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.widget_nb_item_finish, this.goz);
        this.ajn = (ImageView) this.ajm.findViewById(e.g.widget_navi_back_button);
        this.ajn.setContentDescription(getPageContext().getPageActivity().getResources().getString(e.j.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.my_info));
        this.gnY = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eLX = (TextView) this.gnY.findViewById(e.g.right_textview);
        this.eLX.setText(getPageContext().getString(e.j.save));
        al.c(this.eLX, e.d.navi_op_text, 1);
        this.gnY.setOnClickListener(this);
        this.gob.setOnClickListener(this);
        this.god = (LinearLayout) findViewById(e.g.intro_click);
        this.god.setOnClickListener(this);
        this.god.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.goi = true;
                    return false;
                }
                return false;
            }
        });
        this.goa = (TextView) findViewById(e.g.nick_name_show);
        this.goa.setText(this.goj.bnM().getNameShow());
        this.gou = findViewById(e.g.person_nickname);
        this.gou.setOnClickListener(this);
        this.gov = findViewById(e.g.nick_name_more);
        bnF();
        this.gos = (TextView) findViewById(e.g.user_name_show);
        this.gor = findViewById(e.g.person_name);
        this.got = findViewById(e.g.user_name_more_icon);
        this.gor.setOnClickListener(this);
        if (StringUtils.isNull(this.goj.bnM().getName())) {
            this.gos.setText(getPageContext().getString(e.j.tip_empty_user_name));
            this.goq = false;
            this.gor.setClickable(true);
            this.got.setVisibility(0);
        } else {
            this.gos.setText(this.goj.bnM().getName());
            this.goq = true;
            this.gor.setClickable(false);
            this.got.setVisibility(8);
        }
        this.bSg = (TextView) findViewById(e.g.intro);
        if (this.goj.bnM().getIntro() != null && this.goj.bnM().getIntro().length() > 0) {
            this.bSg.setText(this.goj.bnM().getIntro());
        } else {
            this.bSg.setText(getPageContext().getString(e.j.add_intro));
        }
        this.mEdit = (EditText) findViewById(e.g.edit);
        this.mEdit.setText(this.goj.bnM().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.bnD();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.goi = true;
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
                PersonChangeActivity.this.gof.setText(String.valueOf(length));
                PersonChangeActivity.this.goe.setVisibility(0);
                PersonChangeActivity.this.sJ(0);
                PersonChangeActivity.this.bnH();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(e.j.over_limit_tip);
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.goj.bnM().getIntro())) {
                    PersonChangeActivity.this.ehP = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(PersonChangeActivity.this.eLX, e.d.navi_op_text, 1);
                    } else {
                        al.c(PersonChangeActivity.this.eLX, e.d.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.goj.bnM().getSex() == 1) {
            this.mSex = 1;
            this.goc.setText(e.j.male);
        } else if (this.goj.bnM().getSex() == 2) {
            this.mSex = 2;
            this.goc.setText(e.j.female);
        } else {
            this.goc.setText(e.j.change_sex);
        }
        this.goe = (LinearLayout) findViewById(e.g.intro_text_tip);
        this.gof = (TextView) findViewById(e.g.intro_text_tip_num);
        this.gog = (TextView) findViewById(e.g.intro_text_tip_divider);
        this.goh = (TextView) findViewById(e.g.intro_text_tip_limit);
        this.gom = (ProgressBar) findViewById(e.g.image_progress);
        this.cUX = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cUX.ej(getPageContext().getString(e.j.confirm_giveup));
        this.cUX.a(getPageContext().getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.aou();
            }
        });
        this.cUX.b(getPageContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.goj.bnM().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.gnX.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.goj.bnM());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.goj.bnM());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.bnK();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.cUX.b(getPageContext());
    }

    private void bnF() {
        if (an.jJ() || this.goj.bnM().getNickNameLeftDays() == 0) {
            this.gov.setVisibility(0);
        } else {
            this.gov.setVisibility(8);
        }
    }

    public void bnG() {
        String[] strArr = {getPageContext().getString(e.j.change_photo), getPageContext().getString(e.j.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.cQ(e.j.operation);
        bVar.a(strArr, new b.InterfaceC0148b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
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
        bVar.AE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnH() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = al.getColor(e.d.common_color_10159);
        } else {
            color = al.getColor(e.d.common_color_10077);
        }
        sK(color);
    }

    private void sK(int i) {
        this.gof.setTextColor(i);
        this.gog.setTextColor(i);
        this.goh.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aou() {
        if (this.goj != null && this.goj.bnM() != null) {
            bnD();
            if (!j.kV()) {
                showToast(e.j.neterror);
                return;
            }
            this.goj.bnM().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.goj.bnM().setSex(this.mSex);
            if (this.gol == null) {
                this.gol = new b(this.goj);
                this.gol.setPriority(3);
                this.gol.execute(new String[0]);
            }
        }
    }

    private void bnI() {
        if (this.gon == null) {
            this.gon = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            final String string = getPageContext().getString(e.j.male);
            final String string2 = getPageContext().getString(e.j.female);
            this.gon.cQ(e.j.choose_sex);
            this.gon.a(new String[]{string, string2}, new b.InterfaceC0148b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0148b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        PersonChangeActivity.this.mSex = 1;
                        PersonChangeActivity.this.goc.setText(string);
                    } else if (i == 1) {
                        PersonChangeActivity.this.mSex = 2;
                        PersonChangeActivity.this.goc.setText(string2);
                    }
                    if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.goj.bnM().getSex()) {
                        PersonChangeActivity.this.ehP = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            al.c(PersonChangeActivity.this.eLX, e.d.navi_op_text, 1);
                        } else {
                            al.c(PersonChangeActivity.this.eLX, e.d.cp_link_tip_a, 1);
                        }
                    }
                }
            });
            this.gon.d(getPageContext());
        }
        this.gon.AE();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bnD();
            this.goz.onClick(null);
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
                            Z(intent);
                            return;
                        } else {
                            S(intent);
                            return;
                        }
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.goj.bnM().setPhotoChanged(true);
                    bnJ();
                    this.ehP = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(this.eLX, e.d.navi_op_text, 1);
                        return;
                    } else {
                        al.c(this.eLX, e.d.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.goj.bnM().setPhotoChanged(true);
                    if (intent != null) {
                        this.dxr.setImageBitmap(null);
                        this.dxr.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.ehP = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(this.eLX, e.d.navi_op_text, 1);
                        return;
                    } else {
                        al.c(this.eLX, e.d.cp_link_tip_a, 1);
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

    private void tg(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.goo = true;
            this.goj.bnM().setPhotoChanged(true);
            this.goj.bnM().setNameShow(str);
            this.goj.bnM().setNickNameLeftDays(90);
            this.goa.setText(str);
            bnF();
        }
    }

    private void S(Intent intent) {
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

    private void Z(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void bnJ() {
        if (this.gok != null) {
            this.gok.cancel();
        }
        this.eFi = null;
        this.gok = new a();
        this.gok.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnK() {
        if (this.goj != null && this.goj.bnM() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.goj.bnM()));
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
            PersonChangeActivity.this.gom.setVisibility(0);
            PersonChangeActivity.this.dxr.setImageDrawable(null);
            PersonChangeActivity.this.eFi = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public Bitmap doInBackground(Object... objArr) {
            return l.au(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.gok = null;
            PersonChangeActivity.this.gom.setVisibility(8);
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
            PersonChangeActivity.this.gok = null;
            PersonChangeActivity.this.gom.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.eFi = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.eFi.a(PersonChangeActivity.this.dxr);
                com.baidu.tbadk.imageManager.c.Mq().a(PersonChangeActivity.this.goj.bnM().getPortrait(), PersonChangeActivity.this.eFi, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnL() {
        Intent intent = new Intent();
        if (this.gnX.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.goj.bnM());
        } else {
            intent.putExtra("data", this.goj.bnM());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.goj.bnM());
        setResult(-1, intent);
        bnK();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel goj;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.goj = null;
            this.goj = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.gol = null;
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.gol = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.Cf().De().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(e.j.success));
                    PersonChangeActivity.this.bnL();
                } else {
                    PersonChangeActivity.this.showToast(this.mNetWork.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(e.j.saving), PersonChangeActivity.this.mDialogCancelListener);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.goj != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.x(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.goj.bnM().getSex()));
                this.mNetWork.x("intro", this.goj.bnM().getIntro());
                this.mNetWork.BK();
                if (this.mNetWork.Cf().De().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.bCl();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dCl && !TextUtils.isEmpty(this.goy)) {
            tg(this.goy);
            this.dCl = false;
            this.goy = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(String str) {
        if (!StringUtils.isNull(str)) {
            this.goq = true;
            this.gos.setText(str);
            this.gor.setClickable(false);
            this.got.setVisibility(8);
        }
    }
}
