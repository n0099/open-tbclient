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
import com.baidu.tbadk.p.am;
import com.baidu.tieba.e;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private com.baidu.tbadk.coreExtra.view.a aIC;
    private ImageView aiA;
    private View aiz;
    private com.baidu.tbadk.core.util.b.a buX;
    private View gmR;
    private TextView gmS;
    private View gmT;
    private View gmU;
    private View gmV;
    private View gmW;
    private com.baidu.tbadk.core.dialog.a gmX;
    private String gmY;
    private View gmy;
    public final int gmw = 90;
    private Boolean gmx = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView eKE = null;
    private LinearLayout dnj = null;
    private ScrollView gmz = null;
    private TextView gmA = null;
    private LinearLayout gmB = null;
    private TextView gmC = null;
    private LinearLayout gmD = null;
    private TextView bRu = null;
    private EditText mEdit = null;
    private LinearLayout gmE = null;
    private TextView gmF = null;
    private TextView gmG = null;
    private TextView gmH = null;
    private InputMethodManager mInputManager = null;
    private boolean gmI = false;
    private PersonChangeModel gmJ = null;
    protected HeadImageView dvZ = null;
    private com.baidu.adp.widget.ImageView.a eDO = null;
    private a gmK = null;
    private b gmL = null;
    private ProgressBar gmM = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a cTR = null;
    private com.baidu.tbadk.core.dialog.b gmN = null;
    private boolean glh = false;
    private boolean egu = false;
    private boolean gmO = false;
    private int mSex = 0;
    private final int gmP = 500;
    private boolean gmQ = false;
    private boolean dAU = false;
    private final View.OnClickListener gmZ = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.gmJ.bor().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.glh = true;
            }
            if (PersonChangeActivity.this.glh) {
                PersonChangeActivity.this.cTR.Au();
                return;
            }
            if (PersonChangeActivity.this.gmJ != null && PersonChangeActivity.this.gmJ.bor().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.gmx.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.gmJ.bor());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.gmJ.bor());
                }
                PersonChangeActivity.this.bop();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener dBC = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.dAU = true;
                        PersonChangeActivity.this.gmY = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener gna = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.gmJ != null && PersonChangeActivity.this.gmJ.bor() != null && personChangeData != null) {
                    PersonChangeActivity.this.gmJ.bor().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.gmJ.bor().setMem(personChangeData.getMen());
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
        D(bundle);
        Uz();
        if (bundle != null) {
            this.gmx = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.gmx = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.dBC);
        registerListener(this.gna);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dBC);
        if (this.gmK != null) {
            this.gmK.cancel();
        }
        if (this.gmL != null) {
            this.gmL.cancel();
        }
        if (this.gmM != null) {
            this.gmM.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        if (this.aIC != null) {
            this.aIC.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dvZ || view == this.gmW) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.buX == null) {
                this.buX = new com.baidu.tbadk.core.util.b.a();
            }
            this.buX.Di();
            this.buX.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.buX.z(pageActivity)) {
                bol();
            }
        } else if (view == this.gmy) {
            if (!this.egu && !this.gmO) {
                finish();
            }
            if (this.gmx.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.egu) {
                aoS();
            } else if (this.gmO) {
                boq();
            }
        } else if (view == this.gmB) {
            bon();
        } else if (view == this.gmD) {
            boj();
        } else if (view == this.mEdit) {
            sq(800);
        } else if (view == this.gmU) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(e.j.support_modify_nickname));
            } else if (am.jL()) {
                boh();
            } else {
                int nickNameLeftDays = this.gmJ.bor().getNickNameLeftDays();
                if (this.gmJ.bor().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.ej(String.format(getPageContext().getPageActivity().getString(e.j.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
                        aVar.a(e.j.open_now, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                if (j.kX()) {
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
                        aVar.b(getPageContext()).Au();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(e.j.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(e.j.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.gmR) {
            if (this.gmJ == null || this.gmJ.bor() == null || StringUtils.isNull(this.gmJ.bor().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void boh() {
        if (this.gmX == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.person_nickname_act_dialog, (ViewGroup) null);
            this.gmX = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.gmX.G(inflate);
            this.gmX.a(e.j.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.beD(), true)));
                    aVar.dismiss();
                }
            });
            this.gmX.b(e.j.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gmX.b(getPageContext());
            al.h(inflate.findViewById(e.g.nickname_dialog_title), e.d.cp_cont_b);
            al.h(inflate.findViewById(e.g.nickname_dialog_tip), e.d.common_color_10122);
        }
        this.gmX.Au();
    }

    private void i(AccountData accountData) {
        if (this.aIC == null) {
            this.aIC = new com.baidu.tbadk.coreExtra.view.a(this);
            this.aIC.a(new a.InterfaceC0131a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0131a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.te(accountData2.getAccount());
                    }
                }
            });
        }
        this.aIC.Je();
        this.aIC.setAccountData(accountData);
        this.aIC.Ja();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.gmI = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.gmI) {
            boi();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boi() {
        if (this.mEdit.getVisibility() == 0) {
            this.gmE.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.bRu.setText(replaceAll);
            } else {
                this.bRu.setText(getPageContext().getString(e.j.add_intro));
            }
            if (this.gmJ.bor().getIntro() == null || !this.gmJ.bor().getIntro().equals(replaceAll)) {
                this.glh = true;
            }
            this.gmJ.bor().setIntro(replaceAll);
            this.bRu.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void boj() {
        if (this.mEdit.getVisibility() != 0) {
            this.bRu.setVisibility(8);
            this.mEdit.setText(this.gmJ.bor().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            sq(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sq(int i) {
        this.gmz.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.gmz.fullScroll(130);
            }
        }, i);
    }

    private void D(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.gmL != null) {
                    PersonChangeActivity.this.gmL.cancel();
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
        this.gmJ = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.dnj);
        al.a(this.aiA, e.f.icon_nav_close, e.f.icon_nav_close_w, e.f.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dvZ.refresh();
        al.h(this.gmS, e.d.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.gmJ.bor() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.gmJ.bor()));
        }
    }

    private void Uz() {
        this.gmW = findViewById(e.g.photo_pop_icon);
        this.gmW.setOnClickListener(this);
        this.dvZ = (HeadImageView) findViewById(e.g.photo);
        this.dvZ.setOnClickListener(this);
        this.dvZ.startLoad(o.fc(this.gmJ.bor().getPortrait()), 25, false);
        this.dnj = (LinearLayout) findViewById(e.g.parent);
        this.gmz = (ScrollView) findViewById(e.g.person_change_scroll);
        this.gmB = (LinearLayout) findViewById(e.g.person_sex);
        this.gmC = (TextView) findViewById(e.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.aiz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.widget_nb_item_finish, this.gmZ);
        this.aiA = (ImageView) this.aiz.findViewById(e.g.widget_navi_back_button);
        this.aiA.setContentDescription(getPageContext().getPageActivity().getResources().getString(e.j.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.my_info));
        this.gmy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eKE = (TextView) this.gmy.findViewById(e.g.right_textview);
        this.eKE.setText(getPageContext().getString(e.j.save));
        al.c(this.eKE, e.d.navi_op_text, 1);
        this.gmy.setOnClickListener(this);
        this.gmB.setOnClickListener(this);
        this.gmD = (LinearLayout) findViewById(e.g.intro_click);
        this.gmD.setOnClickListener(this);
        this.gmD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.gmI = true;
                    return false;
                }
                return false;
            }
        });
        this.gmA = (TextView) findViewById(e.g.nick_name_show);
        this.gmA.setText(this.gmJ.bor().getNameShow());
        this.gmU = findViewById(e.g.person_nickname);
        this.gmU.setOnClickListener(this);
        this.gmV = findViewById(e.g.nick_name_more);
        bok();
        this.gmS = (TextView) findViewById(e.g.user_name_show);
        this.gmR = findViewById(e.g.person_name);
        this.gmT = findViewById(e.g.user_name_more_icon);
        this.gmR.setOnClickListener(this);
        if (StringUtils.isNull(this.gmJ.bor().getName())) {
            this.gmS.setText(getPageContext().getString(e.j.tip_empty_user_name));
            this.gmQ = false;
            this.gmR.setClickable(true);
            this.gmT.setVisibility(0);
        } else {
            this.gmS.setText(this.gmJ.bor().getName());
            this.gmQ = true;
            this.gmR.setClickable(false);
            this.gmT.setVisibility(8);
        }
        this.bRu = (TextView) findViewById(e.g.intro);
        if (this.gmJ.bor().getIntro() != null && this.gmJ.bor().getIntro().length() > 0) {
            this.bRu.setText(this.gmJ.bor().getIntro());
        } else {
            this.bRu.setText(getPageContext().getString(e.j.add_intro));
        }
        this.mEdit = (EditText) findViewById(e.g.edit);
        this.mEdit.setText(this.gmJ.bor().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.boi();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.gmI = true;
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
                PersonChangeActivity.this.gmF.setText(String.valueOf(length));
                PersonChangeActivity.this.gmE.setVisibility(0);
                PersonChangeActivity.this.sq(0);
                PersonChangeActivity.this.bom();
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.gmJ.bor().getIntro())) {
                    PersonChangeActivity.this.egu = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(PersonChangeActivity.this.eKE, e.d.navi_op_text, 1);
                    } else {
                        al.c(PersonChangeActivity.this.eKE, e.d.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.gmJ.bor().getSex() == 1) {
            this.mSex = 1;
            this.gmC.setText(e.j.male);
        } else if (this.gmJ.bor().getSex() == 2) {
            this.mSex = 2;
            this.gmC.setText(e.j.female);
        } else {
            this.gmC.setText(e.j.change_sex);
        }
        this.gmE = (LinearLayout) findViewById(e.g.intro_text_tip);
        this.gmF = (TextView) findViewById(e.g.intro_text_tip_num);
        this.gmG = (TextView) findViewById(e.g.intro_text_tip_divider);
        this.gmH = (TextView) findViewById(e.g.intro_text_tip_limit);
        this.gmM = (ProgressBar) findViewById(e.g.image_progress);
        this.cTR = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cTR.ej(getPageContext().getString(e.j.confirm_giveup));
        this.cTR.a(getPageContext().getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.aoS();
            }
        });
        this.cTR.b(getPageContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.gmJ.bor().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.gmx.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.gmJ.bor());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.gmJ.bor());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.bop();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.cTR.b(getPageContext());
    }

    private void bok() {
        if (am.jL() || this.gmJ.bor().getNickNameLeftDays() == 0) {
            this.gmV.setVisibility(0);
        } else {
            this.gmV.setVisibility(8);
        }
    }

    public void bol() {
        String[] strArr = {getPageContext().getString(e.j.change_photo), getPageContext().getString(e.j.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.cC(e.j.operation);
        bVar.a(strArr, new b.InterfaceC0124b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
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
        bVar.Ax();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bom() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = al.getColor(e.d.common_color_10159);
        } else {
            color = al.getColor(e.d.common_color_10077);
        }
        sr(color);
    }

    private void sr(int i) {
        this.gmF.setTextColor(i);
        this.gmG.setTextColor(i);
        this.gmH.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoS() {
        if (this.gmJ != null && this.gmJ.bor() != null) {
            boi();
            if (!j.kX()) {
                showToast(e.j.neterror);
                return;
            }
            this.gmJ.bor().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.gmJ.bor().setSex(this.mSex);
            if (this.gmL == null) {
                this.gmL = new b(this.gmJ);
                this.gmL.setPriority(3);
                this.gmL.execute(new String[0]);
            }
        }
    }

    private void bon() {
        if (this.gmN == null) {
            this.gmN = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            final String string = getPageContext().getString(e.j.male);
            final String string2 = getPageContext().getString(e.j.female);
            this.gmN.cC(e.j.choose_sex);
            this.gmN.a(new String[]{string, string2}, new b.InterfaceC0124b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0124b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        PersonChangeActivity.this.mSex = 1;
                        PersonChangeActivity.this.gmC.setText(string);
                    } else if (i == 1) {
                        PersonChangeActivity.this.mSex = 2;
                        PersonChangeActivity.this.gmC.setText(string2);
                    }
                    if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.gmJ.bor().getSex()) {
                        PersonChangeActivity.this.egu = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            al.c(PersonChangeActivity.this.eKE, e.d.navi_op_text, 1);
                        } else {
                            al.c(PersonChangeActivity.this.eKE, e.d.cp_link_tip_a, 1);
                        }
                    }
                }
            });
            this.gmN.d(getPageContext());
        }
        this.gmN.Ax();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boi();
            this.gmZ.onClick(null);
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
                    this.gmJ.bor().setPhotoChanged(true);
                    boo();
                    this.egu = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(this.eKE, e.d.navi_op_text, 1);
                        return;
                    } else {
                        al.c(this.eKE, e.d.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.gmJ.bor().setPhotoChanged(true);
                    if (intent != null) {
                        this.dvZ.setImageBitmap(null);
                        this.dvZ.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.egu = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(this.eKE, e.d.navi_op_text, 1);
                        return;
                    } else {
                        al.c(this.eKE, e.d.cp_link_tip_a, 1);
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

    private void td(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gmO = true;
            this.gmJ.bor().setPhotoChanged(true);
            this.gmJ.bor().setNameShow(str);
            this.gmJ.bor().setNickNameLeftDays(90);
            this.gmA.setText(str);
            bok();
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

    private void boo() {
        if (this.gmK != null) {
            this.gmK.cancel();
        }
        this.eDO = null;
        this.gmK = new a();
        this.gmK.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bop() {
        if (this.gmJ != null && this.gmJ.bor() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.gmJ.bor()));
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
            PersonChangeActivity.this.gmM.setVisibility(0);
            PersonChangeActivity.this.dvZ.setImageDrawable(null);
            PersonChangeActivity.this.eDO = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Bitmap doInBackground(Object... objArr) {
            return l.au(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.gmK = null;
            PersonChangeActivity.this.gmM.setVisibility(8);
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
            PersonChangeActivity.this.gmK = null;
            PersonChangeActivity.this.gmM.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.eDO = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.eDO.a(PersonChangeActivity.this.dvZ);
                com.baidu.tbadk.imageManager.c.Me().a(PersonChangeActivity.this.gmJ.bor().getPortrait(), PersonChangeActivity.this.eDO, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boq() {
        Intent intent = new Intent();
        if (this.gmx.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.gmJ.bor());
        } else {
            intent.putExtra("data", this.gmJ.bor());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.gmJ.bor());
        setResult(-1, intent);
        bop();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel gmJ;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.gmJ = null;
            this.gmJ = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.gmL = null;
            if (this.mNetWork != null) {
                this.mNetWork.ji();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.gmL = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.BY().CX().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(e.j.success));
                    PersonChangeActivity.this.boq();
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
            if (this.gmJ != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.x(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.gmJ.bor().getSex()));
                this.mNetWork.x("intro", this.gmJ.bor().getIntro());
                this.mNetWork.BD();
                if (this.mNetWork.BY().CX().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.bCQ();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dAU && !TextUtils.isEmpty(this.gmY)) {
            td(this.gmY);
            this.dAU = false;
            this.gmY = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void te(String str) {
        if (!StringUtils.isNull(str)) {
            this.gmQ = true;
            this.gmS.setText(str);
            this.gmR.setClickable(false);
            this.gmT.setVisibility(8);
        }
    }
}
