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
    private View Tj;
    private ImageView Tk;
    private com.baidu.tbadk.core.util.b.a baE;
    private View fHV;
    private TextView fIn;
    private View fIo;
    private View fIp;
    private View fIq;
    private com.baidu.tbadk.core.dialog.a fIr;
    private String fIs;
    public final int fHT = 90;
    private Boolean fHU = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView ecF = null;
    private LinearLayout cPo = null;
    private ScrollView fHW = null;
    private TextView fHX = null;
    private LinearLayout fHY = null;
    private TextView fHZ = null;
    private LinearLayout fIa = null;
    private TextView bss = null;
    private EditText mEdit = null;
    private LinearLayout fIb = null;
    private TextView fIc = null;
    private TextView fId = null;
    private TextView fIe = null;
    private InputMethodManager mInputManager = null;
    private boolean fIf = false;
    private PersonChangeModel fIg = null;
    protected HeadImageView cUp = null;
    private com.baidu.adp.widget.ImageView.a dVM = null;
    private a fIh = null;
    private b fIi = null;
    private ProgressBar fIj = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a cwI = null;
    private com.baidu.tbadk.core.dialog.b fIk = null;
    private boolean fGF = false;
    private boolean dAa = false;
    private boolean fIl = false;
    private int mSex = 0;
    private final int fIm = 500;
    private boolean cYT = false;
    private final View.OnClickListener fIt = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (PersonChangeActivity.this.fIg.beJ().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.fGF = true;
            }
            if (PersonChangeActivity.this.fGF) {
                PersonChangeActivity.this.cwI.tC();
                return;
            }
            if (PersonChangeActivity.this.fIg != null && PersonChangeActivity.this.fIg.beJ().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.fHU.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.fIg.beJ());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.fIg.beJ());
                }
                PersonChangeActivity.this.beH();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener cZx = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.cYT = true;
                        PersonChangeActivity.this.fIs = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener fIu = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.fIg != null && PersonChangeActivity.this.fIg.beJ() != null && personChangeData != null) {
                    PersonChangeActivity.this.fIg.beJ().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.fIg.beJ().setMem(personChangeData.getMen());
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
        MH();
        if (bundle != null) {
            this.fHU = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.fHU = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.cZx);
        registerListener(this.fIu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.cZx);
        if (this.fIh != null) {
            this.fIh.cancel();
        }
        if (this.fIi != null) {
            this.fIi.cancel();
        }
        if (this.fIj != null) {
            this.fIj.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (view2 == this.cUp || view2 == this.fIq) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.baE == null) {
                this.baE = new com.baidu.tbadk.core.util.b.a();
            }
            this.baE.wt();
            this.baE.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.baE.v(pageActivity)) {
                beD();
            }
        } else if (view2 == this.fHV) {
            if (!this.dAa && !this.fIl) {
                finish();
            }
            if (this.fHU.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.dAa) {
                agb();
            } else if (this.fIl) {
                beI();
            }
        } else if (view2 == this.fHY) {
            beF();
        } else if (view2 == this.fIa) {
            beB();
        } else if (view2 == this.mEdit) {
            re(800);
        } else if (view2 == this.fIo) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(d.k.support_modify_nickname));
            } else if (af.fz()) {
                bez();
            } else {
                int nickNameLeftDays = this.fIg.beJ().getNickNameLeftDays();
                if (this.fIg.beJ().getMen() <= 0) {
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
                        aVar.b(getPageContext()).tC();
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
        if (this.fIr == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.i.person_nickname_act_dialog, (ViewGroup) null);
            this.fIr = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.fIr.w(inflate);
            this.fIr.a(d.k.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.aVa(), true)));
                    aVar.dismiss();
                }
            });
            this.fIr.b(d.k.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fIr.b(getPageContext());
            ak.h(inflate.findViewById(d.g.nickname_dialog_title), d.C0126d.cp_cont_b);
            ak.h(inflate.findViewById(d.g.nickname_dialog_tip), d.C0126d.common_color_10122);
        }
        this.fIr.tC();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.fIf = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.fIf) {
            beA();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beA() {
        if (this.mEdit.getVisibility() == 0) {
            this.fIb.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.bss.setText(replaceAll);
            } else {
                this.bss.setText(getPageContext().getString(d.k.add_intro));
            }
            if (this.fIg.beJ().getIntro() == null || !this.fIg.beJ().getIntro().equals(replaceAll)) {
                this.fGF = true;
            }
            this.fIg.beJ().setIntro(replaceAll);
            this.bss.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void beB() {
        if (this.mEdit.getVisibility() != 0) {
            this.bss.setVisibility(8);
            this.mEdit.setText(this.fIg.beJ().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            re(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void re(int i) {
        this.fHW.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.fHW.fullScroll(TransportMediator.KEYCODE_MEDIA_RECORD);
            }
        }, i);
    }

    private void B(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.fIi != null) {
                    PersonChangeActivity.this.fIi.cancel();
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
        this.fIg = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().u(this.cPo);
        ak.a(this.Tk, d.f.icon_nav_close, d.f.icon_nav_close_w, d.f.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.cUp.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.fIg.beJ() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.fIg.beJ()));
        }
    }

    private void MH() {
        this.fIq = findViewById(d.g.photo_pop_icon);
        this.fIq.setOnClickListener(this);
        this.cUp = (HeadImageView) findViewById(d.g.photo);
        this.cUp.setOnClickListener(this);
        this.cUp.startLoad(o.dU(this.fIg.beJ().getPortrait()), 25, false);
        this.cPo = (LinearLayout) findViewById(d.g.parent);
        this.fHW = (ScrollView) findViewById(d.g.person_change_scroll);
        this.fHY = (LinearLayout) findViewById(d.g.person_sex);
        this.fHZ = (TextView) findViewById(d.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.Tj = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.i.widget_nb_item_finish, this.fIt);
        this.Tk = (ImageView) this.Tj.findViewById(d.g.widget_navi_back_button);
        this.Tk.setContentDescription(getPageContext().getPageActivity().getResources().getString(d.k.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.k.my_info));
        this.fHV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, (View.OnClickListener) null);
        this.ecF = (TextView) this.fHV.findViewById(d.g.right_textview);
        this.ecF.setText(getPageContext().getString(d.k.save));
        ak.c(this.ecF, d.C0126d.navi_op_text, 1);
        this.fHV.setOnClickListener(this);
        this.fHY.setOnClickListener(this);
        this.fIa = (LinearLayout) findViewById(d.g.intro_click);
        this.fIa.setOnClickListener(this);
        this.fIa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.fIf = true;
                    return false;
                }
                return false;
            }
        });
        this.fHX = (TextView) findViewById(d.g.nick_name_show);
        this.fHX.setText(this.fIg.beJ().getNameShow());
        this.fIo = findViewById(d.g.person_nickname);
        this.fIo.setOnClickListener(this);
        this.fIp = findViewById(d.g.nick_name_more);
        beC();
        this.fIn = (TextView) findViewById(d.g.user_name_show);
        this.fIn.setText(this.fIg.beJ().getName());
        this.bss = (TextView) findViewById(d.g.intro);
        if (this.fIg.beJ().getIntro() != null && this.fIg.beJ().getIntro().length() > 0) {
            this.bss.setText(this.fIg.beJ().getIntro());
        } else {
            this.bss.setText(getPageContext().getString(d.k.add_intro));
        }
        this.mEdit = (EditText) findViewById(d.g.edit);
        this.mEdit.setText(this.fIg.beJ().getIntro());
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
                    PersonChangeActivity.this.fIf = true;
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
                PersonChangeActivity.this.fIc.setText(String.valueOf(length));
                PersonChangeActivity.this.fIb.setVisibility(0);
                PersonChangeActivity.this.re(0);
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.fIg.beJ().getIntro())) {
                    PersonChangeActivity.this.dAa = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ak.c(PersonChangeActivity.this.ecF, d.C0126d.navi_op_text, 1);
                    } else {
                        ak.c(PersonChangeActivity.this.ecF, d.C0126d.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.fIg.beJ().getSex() == 1) {
            this.mSex = 1;
            this.fHZ.setText(d.k.male);
        } else if (this.fIg.beJ().getSex() == 2) {
            this.mSex = 2;
            this.fHZ.setText(d.k.female);
        } else {
            this.fHZ.setText(d.k.change_sex);
        }
        this.fIb = (LinearLayout) findViewById(d.g.intro_text_tip);
        this.fIc = (TextView) findViewById(d.g.intro_text_tip_num);
        this.fId = (TextView) findViewById(d.g.intro_text_tip_divider);
        this.fIe = (TextView) findViewById(d.g.intro_text_tip_limit);
        this.fIj = (ProgressBar) findViewById(d.g.image_progress);
        this.cwI = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cwI.dc(getPageContext().getString(d.k.confirm_giveup));
        this.cwI.a(getPageContext().getString(d.k.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.agb();
            }
        });
        this.cwI.b(getPageContext().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.fIg.beJ().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.fHU.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.fIg.beJ());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.fIg.beJ());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.beH();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.cwI.b(getPageContext());
    }

    private void beC() {
        if (af.fz() || this.fIg.beJ().getNickNameLeftDays() == 0) {
            this.fIp.setVisibility(0);
        } else {
            this.fIp.setVisibility(8);
        }
    }

    public void beD() {
        String[] strArr = {getPageContext().getString(d.k.change_photo), getPageContext().getString(d.k.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.cd(d.k.operation);
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
        bVar.tF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beE() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = ak.getColor(d.C0126d.common_color_10159);
        } else {
            color = ak.getColor(d.C0126d.common_color_10077);
        }
        rf(color);
    }

    private void rf(int i) {
        this.fIc.setTextColor(i);
        this.fId.setTextColor(i);
        this.fIe.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agb() {
        if (this.fIg != null && this.fIg.beJ() != null) {
            beA();
            if (!j.gP()) {
                showToast(d.k.neterror);
                return;
            }
            this.fIg.beJ().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.fIg.beJ().setSex(this.mSex);
            if (this.fIi == null) {
                this.fIi = new b(this.fIg);
                this.fIi.setPriority(3);
                this.fIi.execute(new String[0]);
            }
        }
    }

    private void beF() {
        if (this.fIk == null) {
            this.fIk = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            final String string = getPageContext().getString(d.k.male);
            final String string2 = getPageContext().getString(d.k.female);
            this.fIk.cd(d.k.choose_sex);
            this.fIk.a(new String[]{string, string2}, new b.InterfaceC0086b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                    bVar.dismiss();
                    if (i == 0) {
                        PersonChangeActivity.this.mSex = 1;
                        PersonChangeActivity.this.fHZ.setText(string);
                    } else if (i == 1) {
                        PersonChangeActivity.this.mSex = 2;
                        PersonChangeActivity.this.fHZ.setText(string2);
                    }
                    if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.fIg.beJ().getSex()) {
                        PersonChangeActivity.this.dAa = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            ak.c(PersonChangeActivity.this.ecF, d.C0126d.navi_op_text, 1);
                        } else {
                            ak.c(PersonChangeActivity.this.ecF, d.C0126d.cp_link_tip_a, 1);
                        }
                    }
                }
            });
            this.fIk.d(getPageContext());
        }
        this.fIk.tF();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            beA();
            this.fIt.onClick(null);
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
                    this.fIg.beJ().setPhotoChanged(true);
                    beG();
                    this.dAa = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ak.c(this.ecF, d.C0126d.navi_op_text, 1);
                        return;
                    } else {
                        ak.c(this.ecF, d.C0126d.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.fIg.beJ().setPhotoChanged(true);
                    if (intent != null) {
                        this.cUp.setImageBitmap(null);
                        this.cUp.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.dAa = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ak.c(this.ecF, d.C0126d.navi_op_text, 1);
                        return;
                    } else {
                        ak.c(this.ecF, d.C0126d.cp_link_tip_a, 1);
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

    private void rk(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fIl = true;
            this.fIg.beJ().setPhotoChanged(true);
            this.fIg.beJ().setNameShow(str);
            this.fIg.beJ().setNickNameLeftDays(90);
            this.fHX.setText(str);
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
        if (this.fIh != null) {
            this.fIh.cancel();
        }
        this.dVM = null;
        this.fIh = new a();
        this.fIh.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beH() {
        if (this.fIg != null && this.fIg.beJ() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.fIg.beJ()));
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
            PersonChangeActivity.this.fIj.setVisibility(0);
            PersonChangeActivity.this.cUp.setImageDrawable(null);
            PersonChangeActivity.this.dVM = null;
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
            PersonChangeActivity.this.fIh = null;
            PersonChangeActivity.this.fIj.setVisibility(8);
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
            PersonChangeActivity.this.fIh = null;
            PersonChangeActivity.this.fIj.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.dVM = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.dVM.a(PersonChangeActivity.this.cUp);
                com.baidu.tbadk.imageManager.c.EY().a(PersonChangeActivity.this.fIg.beJ().getPortrait(), PersonChangeActivity.this.dVM, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beI() {
        Intent intent = new Intent();
        if (this.fHU.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.fIg.beJ());
        } else {
            intent.putExtra("data", this.fIg.beJ());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.fIg.beJ());
        setResult(-1, intent);
        beH();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel fIg;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.fIg = null;
            this.fIg = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.fIi = null;
            if (this.mNetWork != null) {
                this.mNetWork.eW();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.fIi = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.vi().wi().isRequestSuccess()) {
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
            if (this.fIg != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.n(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.fIg.beJ().getSex()));
                this.mNetWork.n("intro", this.fIg.beJ().getIntro());
                this.mNetWork.uN();
                if (this.mNetWork.vi().wi().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.bsK();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.cYT && !TextUtils.isEmpty(this.fIs)) {
            rk(this.fIs);
            this.cYT = false;
            this.fIs = "";
        }
    }
}
