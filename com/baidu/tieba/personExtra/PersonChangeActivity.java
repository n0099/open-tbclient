package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.TransportMediator;
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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.o.af;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private View aHV;
    private ImageView aHW;
    private com.baidu.tbadk.core.util.b.a bQG;
    private TextView gmN;
    private View gmO;
    private View gmP;
    private View gmQ;
    private com.baidu.tbadk.core.dialog.a gmR;
    private String gmS;
    private View gmv;
    public final int gmt = 90;
    private Boolean gmu = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView eGV = null;
    private LinearLayout dvw = null;
    private ScrollView gmw = null;
    private TextView gmx = null;
    private LinearLayout gmy = null;
    private TextView gmz = null;
    private LinearLayout gmA = null;
    private TextView chZ = null;
    private EditText mEdit = null;
    private LinearLayout gmB = null;
    private TextView gmC = null;
    private TextView gmD = null;
    private TextView gmE = null;
    private InputMethodManager mInputManager = null;
    private boolean gmF = false;
    private PersonChangeModel gmG = null;
    protected HeadImageView dAz = null;
    private com.baidu.adp.widget.a.a eAe = null;
    private a gmH = null;
    private b gmI = null;
    private ProgressBar gmJ = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a ddL = null;
    private com.baidu.tbadk.core.dialog.b gmK = null;
    private boolean glf = false;
    private boolean eeq = false;
    private boolean gmL = false;
    private int mSex = 0;
    private final int gmM = 500;
    private boolean dET = false;
    private final View.OnClickListener gmT = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.gmG.bjH().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.glf = true;
            }
            if (PersonChangeActivity.this.glf) {
                PersonChangeActivity.this.ddL.AV();
                return;
            }
            if (PersonChangeActivity.this.gmG != null && PersonChangeActivity.this.gmG.bjH().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.gmu.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.gmG.bjH());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.gmG.bjH());
                }
                PersonChangeActivity.this.bjF();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener dFy = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.dET = true;
                        PersonChangeActivity.this.gmS = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener gmU = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.gmG != null && PersonChangeActivity.this.gmG.bjH() != null && personChangeData != null) {
                    PersonChangeActivity.this.gmG.bjH().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.gmG.bjH().setMem(personChangeData.getMen());
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
        G(bundle);
        Ui();
        if (bundle != null) {
            this.gmu = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.gmu = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.dFy);
        registerListener(this.gmU);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dFy);
        if (this.gmH != null) {
            this.gmH.cancel();
        }
        if (this.gmI != null) {
            this.gmI.cancel();
        }
        if (this.gmJ != null) {
            this.gmJ.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dAz || view == this.gmQ) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.bQG == null) {
                this.bQG = new com.baidu.tbadk.core.util.b.a();
            }
            this.bQG.DI();
            this.bQG.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.bQG.v(pageActivity)) {
                bjB();
            }
        } else if (view == this.gmv) {
            if (!this.eeq && !this.gmL) {
                finish();
            }
            if (this.gmu.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.eeq) {
                amb();
            } else if (this.gmL) {
                bjG();
            }
        } else if (view == this.gmy) {
            bjD();
        } else if (view == this.gmA) {
            bjz();
        } else if (view == this.mEdit) {
            tJ(800);
        } else if (view == this.gmO) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(d.j.support_modify_nickname));
            } else if (af.nv()) {
                bjx();
            } else {
                int nickNameLeftDays = this.gmG.bjH().getNickNameLeftDays();
                if (this.gmG.bjH().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.dk(String.format(getPageContext().getPageActivity().getString(d.j.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
                        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                if (com.baidu.adp.lib.util.j.oJ()) {
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
                        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(getPageContext()).AV();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(d.j.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(d.j.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        }
    }

    private void bjx() {
        if (this.gmR == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.person_nickname_act_dialog, (ViewGroup) null);
            this.gmR = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.gmR.aO(inflate);
            this.gmR.a(d.j.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.bab(), true)));
                    aVar.dismiss();
                }
            });
            this.gmR.b(d.j.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gmR.b(getPageContext());
            aj.r(inflate.findViewById(d.g.nickname_dialog_title), d.C0141d.cp_cont_b);
            aj.r(inflate.findViewById(d.g.nickname_dialog_tip), d.C0141d.common_color_10122);
        }
        this.gmR.AV();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.gmF = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.gmF) {
            bjy();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjy() {
        if (this.mEdit.getVisibility() == 0) {
            this.gmB.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.chZ.setText(replaceAll);
            } else {
                this.chZ.setText(getPageContext().getString(d.j.add_intro));
            }
            if (this.gmG.bjH().getIntro() == null || !this.gmG.bjH().getIntro().equals(replaceAll)) {
                this.glf = true;
            }
            this.gmG.bjH().setIntro(replaceAll);
            this.chZ.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void bjz() {
        if (this.mEdit.getVisibility() != 0) {
            this.chZ.setVisibility(8);
            this.mEdit.setText(this.gmG.bjH().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            tJ(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ(int i) {
        this.gmw.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.gmw.fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
            }
        }, i);
    }

    private void G(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.gmI != null) {
                    PersonChangeActivity.this.gmI.cancel();
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
        this.gmG = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.dvw);
        aj.a(this.aHW, d.f.icon_nav_close, d.f.icon_nav_close_w, d.f.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dAz.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.gmG.bjH() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.gmG.bjH()));
        }
    }

    private void Ui() {
        this.gmQ = findViewById(d.g.photo_pop_icon);
        this.gmQ.setOnClickListener(this);
        this.dAz = (HeadImageView) findViewById(d.g.photo);
        this.dAz.setOnClickListener(this);
        this.dAz.startLoad(o.ec(this.gmG.bjH().getPortrait()), 25, false);
        this.dvw = (LinearLayout) findViewById(d.g.parent);
        this.gmw = (ScrollView) findViewById(d.g.person_change_scroll);
        this.gmy = (LinearLayout) findViewById(d.g.person_sex);
        this.gmz = (TextView) findViewById(d.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.aHV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, this.gmT);
        this.aHW = (ImageView) this.aHV.findViewById(d.g.widget_navi_back_button);
        this.aHW.setContentDescription(getPageContext().getPageActivity().getResources().getString(d.j.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.my_info));
        this.gmv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eGV = (TextView) this.gmv.findViewById(d.g.right_textview);
        this.eGV.setText(getPageContext().getString(d.j.save));
        aj.e(this.eGV, d.C0141d.navi_op_text, 1);
        this.gmv.setOnClickListener(this);
        this.gmy.setOnClickListener(this);
        this.gmA = (LinearLayout) findViewById(d.g.intro_click);
        this.gmA.setOnClickListener(this);
        this.gmA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.gmF = true;
                    return false;
                }
                return false;
            }
        });
        this.gmx = (TextView) findViewById(d.g.nick_name_show);
        this.gmx.setText(this.gmG.bjH().getNameShow());
        this.gmO = findViewById(d.g.person_nickname);
        this.gmO.setOnClickListener(this);
        this.gmP = findViewById(d.g.nick_name_more);
        bjA();
        this.gmN = (TextView) findViewById(d.g.user_name_show);
        this.gmN.setText(this.gmG.bjH().getName());
        this.chZ = (TextView) findViewById(d.g.intro);
        if (this.gmG.bjH().getIntro() != null && this.gmG.bjH().getIntro().length() > 0) {
            this.chZ.setText(this.gmG.bjH().getIntro());
        } else {
            this.chZ.setText(getPageContext().getString(d.j.add_intro));
        }
        this.mEdit = (EditText) findViewById(d.g.edit);
        this.mEdit.setText(this.gmG.bjH().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.bjy();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.gmF = true;
                    return false;
                }
                return false;
            }
        });
        this.mEdit.setOnClickListener(this);
        this.mEdit.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.mEdit.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.gmC.setText(String.valueOf(length));
                PersonChangeActivity.this.gmB.setVisibility(0);
                PersonChangeActivity.this.tJ(0);
                PersonChangeActivity.this.bjC();
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.gmG.bjH().getIntro())) {
                    PersonChangeActivity.this.eeq = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        aj.e(PersonChangeActivity.this.eGV, d.C0141d.navi_op_text, 1);
                    } else {
                        aj.e(PersonChangeActivity.this.eGV, d.C0141d.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.gmG.bjH().getSex() == 1) {
            this.mSex = 1;
            this.gmz.setText(d.j.male);
        } else if (this.gmG.bjH().getSex() == 2) {
            this.mSex = 2;
            this.gmz.setText(d.j.female);
        } else {
            this.gmz.setText(d.j.change_sex);
        }
        this.gmB = (LinearLayout) findViewById(d.g.intro_text_tip);
        this.gmC = (TextView) findViewById(d.g.intro_text_tip_num);
        this.gmD = (TextView) findViewById(d.g.intro_text_tip_divider);
        this.gmE = (TextView) findViewById(d.g.intro_text_tip_limit);
        this.gmJ = (ProgressBar) findViewById(d.g.image_progress);
        this.ddL = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.ddL.dk(getPageContext().getString(d.j.confirm_giveup));
        this.ddL.a(getPageContext().getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.amb();
            }
        });
        this.ddL.b(getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.gmG.bjH().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.gmu.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.gmG.bjH());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.gmG.bjH());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.bjF();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.ddL.b(getPageContext());
    }

    private void bjA() {
        if (af.nv() || this.gmG.bjH().getNickNameLeftDays() == 0) {
            this.gmP.setVisibility(0);
        } else {
            this.gmP.setVisibility(8);
        }
    }

    public void bjB() {
        String[] strArr = {getPageContext().getString(d.j.change_photo), getPageContext().getString(d.j.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.fe(d.j.operation);
        bVar.a(strArr, new b.InterfaceC0097b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
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
        bVar.AY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjC() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = aj.getColor(d.C0141d.common_color_10159);
        } else {
            color = aj.getColor(d.C0141d.common_color_10077);
        }
        tK(color);
    }

    private void tK(int i) {
        this.gmC.setTextColor(i);
        this.gmD.setTextColor(i);
        this.gmE.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amb() {
        if (this.gmG != null && this.gmG.bjH() != null) {
            bjy();
            if (!com.baidu.adp.lib.util.j.oJ()) {
                showToast(d.j.neterror);
                return;
            }
            this.gmG.bjH().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.gmG.bjH().setSex(this.mSex);
            if (this.gmI == null) {
                this.gmI = new b(this.gmG);
                this.gmI.setPriority(3);
                this.gmI.execute(new String[0]);
            }
        }
    }

    private void bjD() {
        if (this.gmK == null) {
            this.gmK = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            final String string = getPageContext().getString(d.j.male);
            final String string2 = getPageContext().getString(d.j.female);
            this.gmK.fe(d.j.choose_sex);
            this.gmK.a(new String[]{string, string2}, new b.InterfaceC0097b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        PersonChangeActivity.this.mSex = 1;
                        PersonChangeActivity.this.gmz.setText(string);
                    } else if (i == 1) {
                        PersonChangeActivity.this.mSex = 2;
                        PersonChangeActivity.this.gmz.setText(string2);
                    }
                    if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.gmG.bjH().getSex()) {
                        PersonChangeActivity.this.eeq = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            aj.e(PersonChangeActivity.this.eGV, d.C0141d.navi_op_text, 1);
                        } else {
                            aj.e(PersonChangeActivity.this.eGV, d.C0141d.cp_link_tip_a, 1);
                        }
                    }
                }
            });
            this.gmK.d(getPageContext());
        }
        this.gmK.AY();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bjy();
            this.gmT.onClick(null);
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
                            W(intent);
                            return;
                        } else {
                            P(intent);
                            return;
                        }
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.gmG.bjH().setPhotoChanged(true);
                    bjE();
                    this.eeq = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        aj.e(this.eGV, d.C0141d.navi_op_text, 1);
                        return;
                    } else {
                        aj.e(this.eGV, d.C0141d.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.gmG.bjH().setPhotoChanged(true);
                    if (intent != null) {
                        this.dAz.setImageBitmap(null);
                        this.dAz.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.eeq = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        aj.e(this.eGV, d.C0141d.navi_op_text, 1);
                        return;
                    } else {
                        aj.e(this.eGV, d.C0141d.cp_link_tip_a, 1);
                        return;
                    }
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    ai.b(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    private void rb(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gmL = true;
            this.gmG.bjH().setPhotoChanged(true);
            this.gmG.bjH().setNameShow(str);
            this.gmG.bjH().setNickNameLeftDays(90);
            this.gmx.setText(str);
            bjA();
        }
    }

    private void P(Intent intent) {
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

    private void W(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), IEventCenterService.EventId.EventMode.SAPIACCOUNT_DYNAMICPWD_LOGIN, IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void bjE() {
        if (this.gmH != null) {
            this.gmH.cancel();
        }
        this.eAe = null;
        this.gmH = new a();
        this.gmH.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjF() {
        if (this.gmG != null && this.gmG.bjH() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.gmG.bjH()));
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
            PersonChangeActivity.this.gmJ.setVisibility(0);
            PersonChangeActivity.this.dAz.setImageDrawable(null);
            PersonChangeActivity.this.eAe = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: q */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.k.X(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.gmH = null;
            PersonChangeActivity.this.gmJ.setVisibility(8);
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
            PersonChangeActivity.this.gmH = null;
            PersonChangeActivity.this.gmJ.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.eAe = new com.baidu.adp.widget.a.a(bitmap, false, (String) null);
                PersonChangeActivity.this.eAe.a(PersonChangeActivity.this.dAz);
                com.baidu.tbadk.imageManager.c.Mx().a(PersonChangeActivity.this.gmG.bjH().getPortrait(), PersonChangeActivity.this.eAe, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjG() {
        Intent intent = new Intent();
        if (this.gmu.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.gmG.bjH());
        } else {
            intent.putExtra("data", this.gmG.bjH());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.gmG.bjH());
        setResult(-1, intent);
        bjF();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel gmG;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.gmG = null;
            this.gmG = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.gmI = null;
            if (this.mNetWork != null) {
                this.mNetWork.mS();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.gmI = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.Cz().Dx().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(d.j.success));
                    PersonChangeActivity.this.bjG();
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
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (this.gmG != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.n(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.gmG.bjH().getSex()));
                this.mNetWork.n("intro", this.gmG.bjH().getIntro());
                this.mNetWork.Ce();
                if (this.mNetWork.Cz().Dx().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.bxM();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dET && !TextUtils.isEmpty(this.gmS)) {
            rb(this.gmS);
            this.dET = false;
            this.gmS = "";
        }
    }
}
