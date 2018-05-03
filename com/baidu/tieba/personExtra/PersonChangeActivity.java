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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.k;
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
    private View Tn;
    private ImageView To;
    private com.baidu.tbadk.core.util.b.a baD;
    private View fGP;
    private TextView fHh;
    private View fHi;
    private View fHj;
    private View fHk;
    private com.baidu.tbadk.core.dialog.a fHl;
    private String fHm;
    public final int fGN = 90;
    private Boolean fGO = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView eby = null;
    private LinearLayout cOh = null;
    private ScrollView fGQ = null;
    private TextView fGR = null;
    private LinearLayout fGS = null;
    private TextView fGT = null;
    private LinearLayout fGU = null;
    private TextView bsd = null;
    private EditText mEdit = null;
    private LinearLayout fGV = null;
    private TextView fGW = null;
    private TextView fGX = null;
    private TextView fGY = null;
    private InputMethodManager mInputManager = null;
    private boolean fGZ = false;
    private PersonChangeModel fHa = null;
    protected HeadImageView cTi = null;
    private com.baidu.adp.widget.ImageView.a dUF = null;
    private a fHb = null;
    private b fHc = null;
    private ProgressBar fHd = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a cvz = null;
    private com.baidu.tbadk.core.dialog.b fHe = null;
    private boolean fFz = false;
    private boolean dyT = false;
    private boolean fHf = false;
    private int mSex = 0;
    private final int fHg = 500;
    private boolean cXM = false;
    private final View.OnClickListener fHn = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (PersonChangeActivity.this.fHa.beJ().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.fFz = true;
            }
            if (PersonChangeActivity.this.fFz) {
                PersonChangeActivity.this.cvz.tD();
                return;
            }
            if (PersonChangeActivity.this.fHa != null && PersonChangeActivity.this.fHa.beJ().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.fGO.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.fHa.beJ());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.fHa.beJ());
                }
                PersonChangeActivity.this.beH();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener cYq = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.cXM = true;
                        PersonChangeActivity.this.fHm = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener fHo = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.fHa != null && PersonChangeActivity.this.fHa.beJ() != null && personChangeData != null) {
                    PersonChangeActivity.this.fHa.beJ().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.fHa.beJ().setMem(personChangeData.getMen());
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
        B(bundle);
        MJ();
        if (bundle != null) {
            this.fGO = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.fGO = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.cYq);
        registerListener(this.fHo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cYq);
        if (this.fHb != null) {
            this.fHb.cancel();
        }
        if (this.fHc != null) {
            this.fHc.cancel();
        }
        if (this.fHd != null) {
            this.fHd.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.cTi || view2 == this.fHk) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.baD == null) {
                this.baD = new com.baidu.tbadk.core.util.b.a();
            }
            this.baD.wu();
            this.baD.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.baD.v(pageActivity)) {
                beD();
            }
        } else if (view2 == this.fGP) {
            if (!this.dyT && !this.fHf) {
                finish();
            }
            if (this.fGO.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.dyT) {
                agb();
            } else if (this.fHf) {
                beI();
            }
        } else if (view2 == this.fGS) {
            beF();
        } else if (view2 == this.fGU) {
            beB();
        } else if (view2 == this.mEdit) {
            rf(800);
        } else if (view2 == this.fHi) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(d.k.support_modify_nickname));
            } else if (af.fz()) {
                bez();
            } else {
                int nickNameLeftDays = this.fHa.beJ().getNickNameLeftDays();
                if (this.fHa.beJ().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.dc(String.format(getPageContext().getPageActivity().getString(d.k.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
                        aVar.a(d.k.open_now, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                if (j.gP()) {
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
                        aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(getPageContext()).tD();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(d.k.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(d.k.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        }
    }

    private void bez() {
        if (this.fHl == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.person_nickname_act_dialog, (ViewGroup) null);
            this.fHl = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.fHl.w(inflate);
            this.fHl.a(d.k.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.aVa(), true)));
                    aVar.dismiss();
                }
            });
            this.fHl.b(d.k.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fHl.b(getPageContext());
            ak.h(inflate.findViewById(d.g.nickname_dialog_title), d.C0126d.cp_cont_b);
            ak.h(inflate.findViewById(d.g.nickname_dialog_tip), d.C0126d.common_color_10122);
        }
        this.fHl.tD();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.fGZ = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.fGZ) {
            beA();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beA() {
        if (this.mEdit.getVisibility() == 0) {
            this.fGV.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.bsd.setText(replaceAll);
            } else {
                this.bsd.setText(getPageContext().getString(d.k.add_intro));
            }
            if (this.fHa.beJ().getIntro() == null || !this.fHa.beJ().getIntro().equals(replaceAll)) {
                this.fFz = true;
            }
            this.fHa.beJ().setIntro(replaceAll);
            this.bsd.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void beB() {
        if (this.mEdit.getVisibility() != 0) {
            this.bsd.setVisibility(8);
            this.mEdit.setText(this.fHa.beJ().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            rf(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rf(int i) {
        this.fGQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.fGQ.fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
            }
        }, i);
    }

    private void B(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.fHc != null) {
                    PersonChangeActivity.this.fHc.cancel();
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
        this.fHa = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().u(this.cOh);
        ak.a(this.To, d.f.icon_nav_close, d.f.icon_nav_close_w, d.f.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cTi.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.fHa.beJ() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.fHa.beJ()));
        }
    }

    private void MJ() {
        this.fHk = findViewById(d.g.photo_pop_icon);
        this.fHk.setOnClickListener(this);
        this.cTi = (HeadImageView) findViewById(d.g.photo);
        this.cTi.setOnClickListener(this);
        this.cTi.startLoad(o.dU(this.fHa.beJ().getPortrait()), 25, false);
        this.cOh = (LinearLayout) findViewById(d.g.parent);
        this.fGQ = (ScrollView) findViewById(d.g.person_change_scroll);
        this.fGS = (LinearLayout) findViewById(d.g.person_sex);
        this.fGT = (TextView) findViewById(d.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.Tn = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.widget_nb_item_finish, this.fHn);
        this.To = (ImageView) this.Tn.findViewById(d.g.widget_navi_back_button);
        this.To.setContentDescription(getPageContext().getPageActivity().getResources().getString(d.k.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.k.my_info));
        this.fGP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, (View.OnClickListener) null);
        this.eby = (TextView) this.fGP.findViewById(d.g.right_textview);
        this.eby.setText(getPageContext().getString(d.k.save));
        ak.c(this.eby, d.C0126d.navi_op_text, 1);
        this.fGP.setOnClickListener(this);
        this.fGS.setOnClickListener(this);
        this.fGU = (LinearLayout) findViewById(d.g.intro_click);
        this.fGU.setOnClickListener(this);
        this.fGU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.fGZ = true;
                    return false;
                }
                return false;
            }
        });
        this.fGR = (TextView) findViewById(d.g.nick_name_show);
        this.fGR.setText(this.fHa.beJ().getNameShow());
        this.fHi = findViewById(d.g.person_nickname);
        this.fHi.setOnClickListener(this);
        this.fHj = findViewById(d.g.nick_name_more);
        beC();
        this.fHh = (TextView) findViewById(d.g.user_name_show);
        this.fHh.setText(this.fHa.beJ().getName());
        this.bsd = (TextView) findViewById(d.g.intro);
        if (this.fHa.beJ().getIntro() != null && this.fHa.beJ().getIntro().length() > 0) {
            this.bsd.setText(this.fHa.beJ().getIntro());
        } else {
            this.bsd.setText(getPageContext().getString(d.k.add_intro));
        }
        this.mEdit = (EditText) findViewById(d.g.edit);
        this.mEdit.setText(this.fHa.beJ().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.beA();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.fGZ = true;
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
                PersonChangeActivity.this.fGW.setText(String.valueOf(length));
                PersonChangeActivity.this.fGV.setVisibility(0);
                PersonChangeActivity.this.rf(0);
                PersonChangeActivity.this.beE();
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.fHa.beJ().getIntro())) {
                    PersonChangeActivity.this.dyT = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ak.c(PersonChangeActivity.this.eby, d.C0126d.navi_op_text, 1);
                    } else {
                        ak.c(PersonChangeActivity.this.eby, d.C0126d.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.fHa.beJ().getSex() == 1) {
            this.mSex = 1;
            this.fGT.setText(d.k.male);
        } else if (this.fHa.beJ().getSex() == 2) {
            this.mSex = 2;
            this.fGT.setText(d.k.female);
        } else {
            this.fGT.setText(d.k.change_sex);
        }
        this.fGV = (LinearLayout) findViewById(d.g.intro_text_tip);
        this.fGW = (TextView) findViewById(d.g.intro_text_tip_num);
        this.fGX = (TextView) findViewById(d.g.intro_text_tip_divider);
        this.fGY = (TextView) findViewById(d.g.intro_text_tip_limit);
        this.fHd = (ProgressBar) findViewById(d.g.image_progress);
        this.cvz = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cvz.dc(getPageContext().getString(d.k.confirm_giveup));
        this.cvz.a(getPageContext().getString(d.k.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.agb();
            }
        });
        this.cvz.b(getPageContext().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.fHa.beJ().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.fGO.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.fHa.beJ());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.fHa.beJ());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.beH();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.cvz.b(getPageContext());
    }

    private void beC() {
        if (af.fz() || this.fHa.beJ().getNickNameLeftDays() == 0) {
            this.fHj.setVisibility(0);
        } else {
            this.fHj.setVisibility(8);
        }
    }

    public void beD() {
        String[] strArr = {getPageContext().getString(d.k.change_photo), getPageContext().getString(d.k.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.cc(d.k.operation);
        bVar.a(strArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view2) {
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
        bVar.tG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beE() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = ak.getColor(d.C0126d.common_color_10159);
        } else {
            color = ak.getColor(d.C0126d.common_color_10077);
        }
        rg(color);
    }

    private void rg(int i) {
        this.fGW.setTextColor(i);
        this.fGX.setTextColor(i);
        this.fGY.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agb() {
        if (this.fHa != null && this.fHa.beJ() != null) {
            beA();
            if (!j.gP()) {
                showToast(d.k.neterror);
                return;
            }
            this.fHa.beJ().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.fHa.beJ().setSex(this.mSex);
            if (this.fHc == null) {
                this.fHc = new b(this.fHa);
                this.fHc.setPriority(3);
                this.fHc.execute(new String[0]);
            }
        }
    }

    private void beF() {
        if (this.fHe == null) {
            this.fHe = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            final String string = getPageContext().getString(d.k.male);
            final String string2 = getPageContext().getString(d.k.female);
            this.fHe.cc(d.k.choose_sex);
            this.fHe.a(new String[]{string, string2}, new b.InterfaceC0086b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                    bVar.dismiss();
                    if (i == 0) {
                        PersonChangeActivity.this.mSex = 1;
                        PersonChangeActivity.this.fGT.setText(string);
                    } else if (i == 1) {
                        PersonChangeActivity.this.mSex = 2;
                        PersonChangeActivity.this.fGT.setText(string2);
                    }
                    if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.fHa.beJ().getSex()) {
                        PersonChangeActivity.this.dyT = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            ak.c(PersonChangeActivity.this.eby, d.C0126d.navi_op_text, 1);
                        } else {
                            ak.c(PersonChangeActivity.this.eby, d.C0126d.cp_link_tip_a, 1);
                        }
                    }
                }
            });
            this.fHe.d(getPageContext());
        }
        this.fHe.tG();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            beA();
            this.fHn.onClick(null);
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
                    this.fHa.beJ().setPhotoChanged(true);
                    beG();
                    this.dyT = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ak.c(this.eby, d.C0126d.navi_op_text, 1);
                        return;
                    } else {
                        ak.c(this.eby, d.C0126d.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.fHa.beJ().setPhotoChanged(true);
                    if (intent != null) {
                        this.cTi.setImageBitmap(null);
                        this.cTi.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.dyT = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ak.c(this.eby, d.C0126d.navi_op_text, 1);
                        return;
                    } else {
                        ak.c(this.eby, d.C0126d.cp_link_tip_a, 1);
                        return;
                    }
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    aj.b(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    private void rh(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fHf = true;
            this.fHa.beJ().setPhotoChanged(true);
            this.fHa.beJ().setNameShow(str);
            this.fHa.beJ().setNickNameLeftDays(90);
            this.fGR.setText(str);
            beC();
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

    private void beG() {
        if (this.fHb != null) {
            this.fHb.cancel();
        }
        this.dUF = null;
        this.fHb = new a();
        this.fHb.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beH() {
        if (this.fHa != null && this.fHa.beJ() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.fHa.beJ()));
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
            PersonChangeActivity.this.fHd.setVisibility(0);
            PersonChangeActivity.this.cTi.setImageDrawable(null);
            PersonChangeActivity.this.dUF = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public Bitmap doInBackground(Object... objArr) {
            return k.Y(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.fHb = null;
            PersonChangeActivity.this.fHd.setVisibility(8);
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
            PersonChangeActivity.this.fHb = null;
            PersonChangeActivity.this.fHd.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.dUF = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.dUF.a(PersonChangeActivity.this.cTi);
                com.baidu.tbadk.imageManager.c.Fa().a(PersonChangeActivity.this.fHa.beJ().getPortrait(), PersonChangeActivity.this.dUF, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beI() {
        Intent intent = new Intent();
        if (this.fGO.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.fHa.beJ());
        } else {
            intent.putExtra("data", this.fHa.beJ());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.fHa.beJ());
        setResult(-1, intent);
        beH();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel fHa;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.fHa = null;
            this.fHa = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.fHc = null;
            if (this.mNetWork != null) {
                this.mNetWork.eW();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.fHc = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.vj().wj().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(d.k.success));
                    PersonChangeActivity.this.beI();
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
            if (this.fHa != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.n(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.fHa.beJ().getSex()));
                this.mNetWork.n("intro", this.fHa.beJ().getIntro());
                this.mNetWork.uO();
                if (this.mNetWork.vj().wj().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.bsM();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cXM && !TextUtils.isEmpty(this.fHm)) {
            rh(this.fHm);
            this.cXM = false;
            this.fHm = "";
        }
    }
}
