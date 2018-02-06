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
    private View aIf;
    private ImageView aIg;
    private com.baidu.tbadk.core.util.b.a bQQ;
    private TextView gmI;
    private View gmJ;
    private View gmK;
    private View gmL;
    private com.baidu.tbadk.core.dialog.a gmM;
    private String gmN;
    private View gmq;
    public final int gmo = 90;
    private Boolean gmp = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView eGR = null;
    private LinearLayout dvF = null;
    private ScrollView gmr = null;
    private TextView gms = null;
    private LinearLayout gmt = null;
    private TextView gmu = null;
    private LinearLayout gmv = null;
    private TextView cij = null;
    private EditText mEdit = null;
    private LinearLayout gmw = null;
    private TextView gmx = null;
    private TextView gmy = null;
    private TextView gmz = null;
    private InputMethodManager mInputManager = null;
    private boolean gmA = false;
    private PersonChangeModel gmB = null;
    protected HeadImageView dAI = null;
    private com.baidu.adp.widget.a.a eAa = null;
    private a gmC = null;
    private b gmD = null;
    private ProgressBar gmE = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a ddU = null;
    private com.baidu.tbadk.core.dialog.b gmF = null;
    private boolean gla = false;
    private boolean eem = false;
    private boolean gmG = false;
    private int mSex = 0;
    private final int gmH = 500;
    private boolean dFc = false;
    private final View.OnClickListener gmO = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.gmB.bjH().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.gla = true;
            }
            if (PersonChangeActivity.this.gla) {
                PersonChangeActivity.this.ddU.AU();
                return;
            }
            if (PersonChangeActivity.this.gmB != null && PersonChangeActivity.this.gmB.bjH().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.gmp.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.gmB.bjH());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.gmB.bjH());
                }
                PersonChangeActivity.this.bjF();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener dFG = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.dFc = true;
                        PersonChangeActivity.this.gmN = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener gmP = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.gmB != null && PersonChangeActivity.this.gmB.bjH() != null && personChangeData != null) {
                    PersonChangeActivity.this.gmB.bjH().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.gmB.bjH().setMem(personChangeData.getMen());
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
            this.gmp = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.gmp = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.dFG);
        registerListener(this.gmP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dFG);
        if (this.gmC != null) {
            this.gmC.cancel();
        }
        if (this.gmD != null) {
            this.gmD.cancel();
        }
        if (this.gmE != null) {
            this.gmE.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dAI || view == this.gmL) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.bQQ == null) {
                this.bQQ = new com.baidu.tbadk.core.util.b.a();
            }
            this.bQQ.DI();
            this.bQQ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.bQQ.v(pageActivity)) {
                bjB();
            }
        } else if (view == this.gmq) {
            if (!this.eem && !this.gmG) {
                finish();
            }
            if (this.gmp.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.eem) {
                amb();
            } else if (this.gmG) {
                bjG();
            }
        } else if (view == this.gmt) {
            bjD();
        } else if (view == this.gmv) {
            bjz();
        } else if (view == this.mEdit) {
            tI(800);
        } else if (view == this.gmJ) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(d.j.support_modify_nickname));
            } else if (af.nv()) {
                bjx();
            } else {
                int nickNameLeftDays = this.gmB.bjH().getNickNameLeftDays();
                if (this.gmB.bjH().getMen() <= 0) {
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
                        aVar.b(getPageContext()).AU();
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
        if (this.gmM == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.person_nickname_act_dialog, (ViewGroup) null);
            this.gmM = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.gmM.aO(inflate);
            this.gmM.a(d.j.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.bab(), true)));
                    aVar.dismiss();
                }
            });
            this.gmM.b(d.j.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gmM.b(getPageContext());
            aj.r(inflate.findViewById(d.g.nickname_dialog_title), d.C0140d.cp_cont_b);
            aj.r(inflate.findViewById(d.g.nickname_dialog_tip), d.C0140d.common_color_10122);
        }
        this.gmM.AU();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.gmA = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.gmA) {
            bjy();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjy() {
        if (this.mEdit.getVisibility() == 0) {
            this.gmw.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.cij.setText(replaceAll);
            } else {
                this.cij.setText(getPageContext().getString(d.j.add_intro));
            }
            if (this.gmB.bjH().getIntro() == null || !this.gmB.bjH().getIntro().equals(replaceAll)) {
                this.gla = true;
            }
            this.gmB.bjH().setIntro(replaceAll);
            this.cij.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void bjz() {
        if (this.mEdit.getVisibility() != 0) {
            this.cij.setVisibility(8);
            this.mEdit.setText(this.gmB.bjH().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            tI(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tI(int i) {
        this.gmr.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.gmr.fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
            }
        }, i);
    }

    private void G(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.gmD != null) {
                    PersonChangeActivity.this.gmD.cancel();
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
        this.gmB = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.dvF);
        aj.a(this.aIg, d.f.icon_nav_close, d.f.icon_nav_close_w, d.f.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dAI.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.gmB.bjH() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.gmB.bjH()));
        }
    }

    private void Ui() {
        this.gmL = findViewById(d.g.photo_pop_icon);
        this.gmL.setOnClickListener(this);
        this.dAI = (HeadImageView) findViewById(d.g.photo);
        this.dAI.setOnClickListener(this);
        this.dAI.startLoad(o.ec(this.gmB.bjH().getPortrait()), 25, false);
        this.dvF = (LinearLayout) findViewById(d.g.parent);
        this.gmr = (ScrollView) findViewById(d.g.person_change_scroll);
        this.gmt = (LinearLayout) findViewById(d.g.person_sex);
        this.gmu = (TextView) findViewById(d.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.aIf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, this.gmO);
        this.aIg = (ImageView) this.aIf.findViewById(d.g.widget_navi_back_button);
        this.aIg.setContentDescription(getPageContext().getPageActivity().getResources().getString(d.j.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.my_info));
        this.gmq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eGR = (TextView) this.gmq.findViewById(d.g.right_textview);
        this.eGR.setText(getPageContext().getString(d.j.save));
        aj.e(this.eGR, d.C0140d.navi_op_text, 1);
        this.gmq.setOnClickListener(this);
        this.gmt.setOnClickListener(this);
        this.gmv = (LinearLayout) findViewById(d.g.intro_click);
        this.gmv.setOnClickListener(this);
        this.gmv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.gmA = true;
                    return false;
                }
                return false;
            }
        });
        this.gms = (TextView) findViewById(d.g.nick_name_show);
        this.gms.setText(this.gmB.bjH().getNameShow());
        this.gmJ = findViewById(d.g.person_nickname);
        this.gmJ.setOnClickListener(this);
        this.gmK = findViewById(d.g.nick_name_more);
        bjA();
        this.gmI = (TextView) findViewById(d.g.user_name_show);
        this.gmI.setText(this.gmB.bjH().getName());
        this.cij = (TextView) findViewById(d.g.intro);
        if (this.gmB.bjH().getIntro() != null && this.gmB.bjH().getIntro().length() > 0) {
            this.cij.setText(this.gmB.bjH().getIntro());
        } else {
            this.cij.setText(getPageContext().getString(d.j.add_intro));
        }
        this.mEdit = (EditText) findViewById(d.g.edit);
        this.mEdit.setText(this.gmB.bjH().getIntro());
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
                    PersonChangeActivity.this.gmA = true;
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
                PersonChangeActivity.this.gmx.setText(String.valueOf(length));
                PersonChangeActivity.this.gmw.setVisibility(0);
                PersonChangeActivity.this.tI(0);
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.gmB.bjH().getIntro())) {
                    PersonChangeActivity.this.eem = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        aj.e(PersonChangeActivity.this.eGR, d.C0140d.navi_op_text, 1);
                    } else {
                        aj.e(PersonChangeActivity.this.eGR, d.C0140d.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.gmB.bjH().getSex() == 1) {
            this.mSex = 1;
            this.gmu.setText(d.j.male);
        } else if (this.gmB.bjH().getSex() == 2) {
            this.mSex = 2;
            this.gmu.setText(d.j.female);
        } else {
            this.gmu.setText(d.j.change_sex);
        }
        this.gmw = (LinearLayout) findViewById(d.g.intro_text_tip);
        this.gmx = (TextView) findViewById(d.g.intro_text_tip_num);
        this.gmy = (TextView) findViewById(d.g.intro_text_tip_divider);
        this.gmz = (TextView) findViewById(d.g.intro_text_tip_limit);
        this.gmE = (ProgressBar) findViewById(d.g.image_progress);
        this.ddU = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.ddU.dk(getPageContext().getString(d.j.confirm_giveup));
        this.ddU.a(getPageContext().getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.amb();
            }
        });
        this.ddU.b(getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.gmB.bjH().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.gmp.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.gmB.bjH());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.gmB.bjH());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.bjF();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.ddU.b(getPageContext());
    }

    private void bjA() {
        if (af.nv() || this.gmB.bjH().getNickNameLeftDays() == 0) {
            this.gmK.setVisibility(0);
        } else {
            this.gmK.setVisibility(8);
        }
    }

    public void bjB() {
        String[] strArr = {getPageContext().getString(d.j.change_photo), getPageContext().getString(d.j.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.fe(d.j.operation);
        bVar.a(strArr, new b.InterfaceC0096b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
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
        bVar.AX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjC() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = aj.getColor(d.C0140d.common_color_10159);
        } else {
            color = aj.getColor(d.C0140d.common_color_10077);
        }
        tJ(color);
    }

    private void tJ(int i) {
        this.gmx.setTextColor(i);
        this.gmy.setTextColor(i);
        this.gmz.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void amb() {
        if (this.gmB != null && this.gmB.bjH() != null) {
            bjy();
            if (!com.baidu.adp.lib.util.j.oJ()) {
                showToast(d.j.neterror);
                return;
            }
            this.gmB.bjH().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.gmB.bjH().setSex(this.mSex);
            if (this.gmD == null) {
                this.gmD = new b(this.gmB);
                this.gmD.setPriority(3);
                this.gmD.execute(new String[0]);
            }
        }
    }

    private void bjD() {
        if (this.gmF == null) {
            this.gmF = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            final String string = getPageContext().getString(d.j.male);
            final String string2 = getPageContext().getString(d.j.female);
            this.gmF.fe(d.j.choose_sex);
            this.gmF.a(new String[]{string, string2}, new b.InterfaceC0096b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        PersonChangeActivity.this.mSex = 1;
                        PersonChangeActivity.this.gmu.setText(string);
                    } else if (i == 1) {
                        PersonChangeActivity.this.mSex = 2;
                        PersonChangeActivity.this.gmu.setText(string2);
                    }
                    if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.gmB.bjH().getSex()) {
                        PersonChangeActivity.this.eem = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            aj.e(PersonChangeActivity.this.eGR, d.C0140d.navi_op_text, 1);
                        } else {
                            aj.e(PersonChangeActivity.this.eGR, d.C0140d.cp_link_tip_a, 1);
                        }
                    }
                }
            });
            this.gmF.d(getPageContext());
        }
        this.gmF.AX();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bjy();
            this.gmO.onClick(null);
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
                    this.gmB.bjH().setPhotoChanged(true);
                    bjE();
                    this.eem = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        aj.e(this.eGR, d.C0140d.navi_op_text, 1);
                        return;
                    } else {
                        aj.e(this.eGR, d.C0140d.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.gmB.bjH().setPhotoChanged(true);
                    if (intent != null) {
                        this.dAI.setImageBitmap(null);
                        this.dAI.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.eem = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        aj.e(this.eGR, d.C0140d.navi_op_text, 1);
                        return;
                    } else {
                        aj.e(this.eGR, d.C0140d.cp_link_tip_a, 1);
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
            this.gmG = true;
            this.gmB.bjH().setPhotoChanged(true);
            this.gmB.bjH().setNameShow(str);
            this.gmB.bjH().setNickNameLeftDays(90);
            this.gms.setText(str);
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
        if (this.gmC != null) {
            this.gmC.cancel();
        }
        this.eAa = null;
        this.gmC = new a();
        this.gmC.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjF() {
        if (this.gmB != null && this.gmB.bjH() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.gmB.bjH()));
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
            PersonChangeActivity.this.gmE.setVisibility(0);
            PersonChangeActivity.this.dAI.setImageDrawable(null);
            PersonChangeActivity.this.eAa = null;
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
            PersonChangeActivity.this.gmC = null;
            PersonChangeActivity.this.gmE.setVisibility(8);
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
            PersonChangeActivity.this.gmC = null;
            PersonChangeActivity.this.gmE.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.eAa = new com.baidu.adp.widget.a.a(bitmap, false, (String) null);
                PersonChangeActivity.this.eAa.a(PersonChangeActivity.this.dAI);
                com.baidu.tbadk.imageManager.c.Mx().a(PersonChangeActivity.this.gmB.bjH().getPortrait(), PersonChangeActivity.this.eAa, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjG() {
        Intent intent = new Intent();
        if (this.gmp.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.gmB.bjH());
        } else {
            intent.putExtra("data", this.gmB.bjH());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.gmB.bjH());
        setResult(-1, intent);
        bjF();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel gmB;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.gmB = null;
            this.gmB = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.gmD = null;
            if (this.mNetWork != null) {
                this.mNetWork.mS();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.gmD = null;
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
            if (this.gmB != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.n(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.gmB.bjH().getSex()));
                this.mNetWork.n("intro", this.gmB.bjH().getIntro());
                this.mNetWork.Ce();
                if (this.mNetWork.Cz().Dx().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.bxI();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dFc && !TextUtils.isEmpty(this.gmN)) {
            rb(this.gmN);
            this.dFc = false;
            this.gmN = "";
        }
    }
}
