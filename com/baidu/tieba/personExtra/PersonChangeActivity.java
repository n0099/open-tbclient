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
    private View aHU;
    private ImageView aHV;
    private com.baidu.tbadk.core.util.b.a bQD;
    private View gmA;
    private com.baidu.tbadk.core.dialog.a gmB;
    private String gmC;
    private View gmf;
    private TextView gmx;
    private View gmy;
    private View gmz;
    public final int gmd = 90;
    private Boolean gme = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView eGF = null;
    private LinearLayout dvt = null;
    private ScrollView gmg = null;
    private TextView gmh = null;
    private LinearLayout gmi = null;
    private TextView gmj = null;
    private LinearLayout gmk = null;
    private TextView chW = null;
    private EditText mEdit = null;
    private LinearLayout gml = null;
    private TextView gmm = null;
    private TextView gmn = null;
    private TextView gmo = null;
    private InputMethodManager mInputManager = null;
    private boolean gmp = false;
    private PersonChangeModel gmq = null;
    protected HeadImageView dAw = null;
    private com.baidu.adp.widget.a.a ezO = null;
    private a gmr = null;
    private b gms = null;
    private ProgressBar gmt = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a ddI = null;
    private com.baidu.tbadk.core.dialog.b gmu = null;
    private boolean gkP = false;
    private boolean eea = false;
    private boolean gmv = false;
    private int mSex = 0;
    private final int gmw = 500;
    private boolean dEQ = false;
    private final View.OnClickListener gmD = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.gmq.bjG().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.gkP = true;
            }
            if (PersonChangeActivity.this.gkP) {
                PersonChangeActivity.this.ddI.AU();
                return;
            }
            if (PersonChangeActivity.this.gmq != null && PersonChangeActivity.this.gmq.bjG().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.gme.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.gmq.bjG());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.gmq.bjG());
                }
                PersonChangeActivity.this.bjE();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener dFu = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.dEQ = true;
                        PersonChangeActivity.this.gmC = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener gmE = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.gmq != null && PersonChangeActivity.this.gmq.bjG() != null && personChangeData != null) {
                    PersonChangeActivity.this.gmq.bjG().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.gmq.bjG().setMem(personChangeData.getMen());
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
        Uh();
        if (bundle != null) {
            this.gme = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.gme = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.dFu);
        registerListener(this.gmE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dFu);
        if (this.gmr != null) {
            this.gmr.cancel();
        }
        if (this.gms != null) {
            this.gms.cancel();
        }
        if (this.gmt != null) {
            this.gmt.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dAw || view == this.gmA) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.bQD == null) {
                this.bQD = new com.baidu.tbadk.core.util.b.a();
            }
            this.bQD.DH();
            this.bQD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.bQD.v(pageActivity)) {
                bjA();
            }
        } else if (view == this.gmf) {
            if (!this.eea && !this.gmv) {
                finish();
            }
            if (this.gme.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.eea) {
                ama();
            } else if (this.gmv) {
                bjF();
            }
        } else if (view == this.gmi) {
            bjC();
        } else if (view == this.gmk) {
            bjy();
        } else if (view == this.mEdit) {
            tJ(800);
        } else if (view == this.gmy) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(d.j.support_modify_nickname));
            } else if (af.nv()) {
                bjw();
            } else {
                int nickNameLeftDays = this.gmq.bjG().getNickNameLeftDays();
                if (this.gmq.bjG().getMen() <= 0) {
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

    private void bjw() {
        if (this.gmB == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.person_nickname_act_dialog, (ViewGroup) null);
            this.gmB = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.gmB.aO(inflate);
            this.gmB.a(d.j.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.baa(), true)));
                    aVar.dismiss();
                }
            });
            this.gmB.b(d.j.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gmB.b(getPageContext());
            aj.r(inflate.findViewById(d.g.nickname_dialog_title), d.C0141d.cp_cont_b);
            aj.r(inflate.findViewById(d.g.nickname_dialog_tip), d.C0141d.common_color_10122);
        }
        this.gmB.AU();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.gmp = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.gmp) {
            bjx();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjx() {
        if (this.mEdit.getVisibility() == 0) {
            this.gml.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.chW.setText(replaceAll);
            } else {
                this.chW.setText(getPageContext().getString(d.j.add_intro));
            }
            if (this.gmq.bjG().getIntro() == null || !this.gmq.bjG().getIntro().equals(replaceAll)) {
                this.gkP = true;
            }
            this.gmq.bjG().setIntro(replaceAll);
            this.chW.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void bjy() {
        if (this.mEdit.getVisibility() != 0) {
            this.chW.setVisibility(8);
            this.mEdit.setText(this.gmq.bjG().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            tJ(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tJ(int i) {
        this.gmg.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.gmg.fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
            }
        }, i);
    }

    private void G(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.gms != null) {
                    PersonChangeActivity.this.gms.cancel();
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
        this.gmq = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().aQ(i == 1);
        getLayoutMode().aM(this.dvt);
        aj.a(this.aHV, d.f.icon_nav_close, d.f.icon_nav_close_w, d.f.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dAw.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.gmq.bjG() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.gmq.bjG()));
        }
    }

    private void Uh() {
        this.gmA = findViewById(d.g.photo_pop_icon);
        this.gmA.setOnClickListener(this);
        this.dAw = (HeadImageView) findViewById(d.g.photo);
        this.dAw.setOnClickListener(this);
        this.dAw.startLoad(o.ec(this.gmq.bjG().getPortrait()), 25, false);
        this.dvt = (LinearLayout) findViewById(d.g.parent);
        this.gmg = (ScrollView) findViewById(d.g.person_change_scroll);
        this.gmi = (LinearLayout) findViewById(d.g.person_sex);
        this.gmj = (TextView) findViewById(d.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.aHU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, this.gmD);
        this.aHV = (ImageView) this.aHU.findViewById(d.g.widget_navi_back_button);
        this.aHV.setContentDescription(getPageContext().getPageActivity().getResources().getString(d.j.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.my_info));
        this.gmf = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eGF = (TextView) this.gmf.findViewById(d.g.right_textview);
        this.eGF.setText(getPageContext().getString(d.j.save));
        aj.e(this.eGF, d.C0141d.navi_op_text, 1);
        this.gmf.setOnClickListener(this);
        this.gmi.setOnClickListener(this);
        this.gmk = (LinearLayout) findViewById(d.g.intro_click);
        this.gmk.setOnClickListener(this);
        this.gmk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.gmp = true;
                    return false;
                }
                return false;
            }
        });
        this.gmh = (TextView) findViewById(d.g.nick_name_show);
        this.gmh.setText(this.gmq.bjG().getNameShow());
        this.gmy = findViewById(d.g.person_nickname);
        this.gmy.setOnClickListener(this);
        this.gmz = findViewById(d.g.nick_name_more);
        bjz();
        this.gmx = (TextView) findViewById(d.g.user_name_show);
        this.gmx.setText(this.gmq.bjG().getName());
        this.chW = (TextView) findViewById(d.g.intro);
        if (this.gmq.bjG().getIntro() != null && this.gmq.bjG().getIntro().length() > 0) {
            this.chW.setText(this.gmq.bjG().getIntro());
        } else {
            this.chW.setText(getPageContext().getString(d.j.add_intro));
        }
        this.mEdit = (EditText) findViewById(d.g.edit);
        this.mEdit.setText(this.gmq.bjG().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.bjx();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.gmp = true;
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
                PersonChangeActivity.this.gmm.setText(String.valueOf(length));
                PersonChangeActivity.this.gml.setVisibility(0);
                PersonChangeActivity.this.tJ(0);
                PersonChangeActivity.this.bjB();
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.gmq.bjG().getIntro())) {
                    PersonChangeActivity.this.eea = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        aj.e(PersonChangeActivity.this.eGF, d.C0141d.navi_op_text, 1);
                    } else {
                        aj.e(PersonChangeActivity.this.eGF, d.C0141d.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.gmq.bjG().getSex() == 1) {
            this.mSex = 1;
            this.gmj.setText(d.j.male);
        } else if (this.gmq.bjG().getSex() == 2) {
            this.mSex = 2;
            this.gmj.setText(d.j.female);
        } else {
            this.gmj.setText(d.j.change_sex);
        }
        this.gml = (LinearLayout) findViewById(d.g.intro_text_tip);
        this.gmm = (TextView) findViewById(d.g.intro_text_tip_num);
        this.gmn = (TextView) findViewById(d.g.intro_text_tip_divider);
        this.gmo = (TextView) findViewById(d.g.intro_text_tip_limit);
        this.gmt = (ProgressBar) findViewById(d.g.image_progress);
        this.ddI = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.ddI.dk(getPageContext().getString(d.j.confirm_giveup));
        this.ddI.a(getPageContext().getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.ama();
            }
        });
        this.ddI.b(getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.gmq.bjG().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.gme.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.gmq.bjG());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.gmq.bjG());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.bjE();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.ddI.b(getPageContext());
    }

    private void bjz() {
        if (af.nv() || this.gmq.bjG().getNickNameLeftDays() == 0) {
            this.gmz.setVisibility(0);
        } else {
            this.gmz.setVisibility(8);
        }
    }

    public void bjA() {
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
        bVar.AX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjB() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = aj.getColor(d.C0141d.common_color_10159);
        } else {
            color = aj.getColor(d.C0141d.common_color_10077);
        }
        tK(color);
    }

    private void tK(int i) {
        this.gmm.setTextColor(i);
        this.gmn.setTextColor(i);
        this.gmo.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ama() {
        if (this.gmq != null && this.gmq.bjG() != null) {
            bjx();
            if (!com.baidu.adp.lib.util.j.oJ()) {
                showToast(d.j.neterror);
                return;
            }
            this.gmq.bjG().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.gmq.bjG().setSex(this.mSex);
            if (this.gms == null) {
                this.gms = new b(this.gmq);
                this.gms.setPriority(3);
                this.gms.execute(new String[0]);
            }
        }
    }

    private void bjC() {
        if (this.gmu == null) {
            this.gmu = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            final String string = getPageContext().getString(d.j.male);
            final String string2 = getPageContext().getString(d.j.female);
            this.gmu.fe(d.j.choose_sex);
            this.gmu.a(new String[]{string, string2}, new b.InterfaceC0097b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        PersonChangeActivity.this.mSex = 1;
                        PersonChangeActivity.this.gmj.setText(string);
                    } else if (i == 1) {
                        PersonChangeActivity.this.mSex = 2;
                        PersonChangeActivity.this.gmj.setText(string2);
                    }
                    if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.gmq.bjG().getSex()) {
                        PersonChangeActivity.this.eea = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            aj.e(PersonChangeActivity.this.eGF, d.C0141d.navi_op_text, 1);
                        } else {
                            aj.e(PersonChangeActivity.this.eGF, d.C0141d.cp_link_tip_a, 1);
                        }
                    }
                }
            });
            this.gmu.d(getPageContext());
        }
        this.gmu.AX();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bjx();
            this.gmD.onClick(null);
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
                    this.gmq.bjG().setPhotoChanged(true);
                    bjD();
                    this.eea = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        aj.e(this.eGF, d.C0141d.navi_op_text, 1);
                        return;
                    } else {
                        aj.e(this.eGF, d.C0141d.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.gmq.bjG().setPhotoChanged(true);
                    if (intent != null) {
                        this.dAw.setImageBitmap(null);
                        this.dAw.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.eea = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        aj.e(this.eGF, d.C0141d.navi_op_text, 1);
                        return;
                    } else {
                        aj.e(this.eGF, d.C0141d.cp_link_tip_a, 1);
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
            this.gmv = true;
            this.gmq.bjG().setPhotoChanged(true);
            this.gmq.bjG().setNameShow(str);
            this.gmq.bjG().setNickNameLeftDays(90);
            this.gmh.setText(str);
            bjz();
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

    private void bjD() {
        if (this.gmr != null) {
            this.gmr.cancel();
        }
        this.ezO = null;
        this.gmr = new a();
        this.gmr.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjE() {
        if (this.gmq != null && this.gmq.bjG() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.gmq.bjG()));
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
            PersonChangeActivity.this.gmt.setVisibility(0);
            PersonChangeActivity.this.dAw.setImageDrawable(null);
            PersonChangeActivity.this.ezO = null;
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
            PersonChangeActivity.this.gmr = null;
            PersonChangeActivity.this.gmt.setVisibility(8);
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
            PersonChangeActivity.this.gmr = null;
            PersonChangeActivity.this.gmt.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.ezO = new com.baidu.adp.widget.a.a(bitmap, false, (String) null);
                PersonChangeActivity.this.ezO.a(PersonChangeActivity.this.dAw);
                com.baidu.tbadk.imageManager.c.Mw().a(PersonChangeActivity.this.gmq.bjG().getPortrait(), PersonChangeActivity.this.ezO, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjF() {
        Intent intent = new Intent();
        if (this.gme.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.gmq.bjG());
        } else {
            intent.putExtra("data", this.gmq.bjG());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.gmq.bjG());
        setResult(-1, intent);
        bjE();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel gmq;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.gmq = null;
            this.gmq = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.gms = null;
            if (this.mNetWork != null) {
                this.mNetWork.mS();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.gms = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.Cy().Dw().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(d.j.success));
                    PersonChangeActivity.this.bjF();
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
            if (this.gmq != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.n(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.gmq.bjG().getSex()));
                this.mNetWork.n("intro", this.gmq.bjG().getIntro());
                this.mNetWork.Cd();
                if (this.mNetWork.Cy().Dw().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.bxH();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dEQ && !TextUtils.isEmpty(this.gmC)) {
            rb(this.gmC);
            this.dEQ = false;
            this.gmC = "";
        }
    }
}
