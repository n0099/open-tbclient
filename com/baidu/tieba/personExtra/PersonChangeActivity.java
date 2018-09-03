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
import com.baidu.tbadk.p.aj;
import com.baidu.tieba.f;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private com.baidu.tbadk.coreExtra.view.a aAU;
    private View aaY;
    private ImageView aaZ;
    private com.baidu.tbadk.core.util.b.a bkZ;
    private View fXH;
    private View fYa;
    private TextView fYb;
    private View fYc;
    private View fYd;
    private View fYe;
    private View fYf;
    private com.baidu.tbadk.core.dialog.a fYg;
    private String fYh;
    public final int fXF = 90;
    private Boolean fXG = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView evC = null;
    private LinearLayout cZh = null;
    private ScrollView fXI = null;
    private TextView fXJ = null;
    private LinearLayout fXK = null;
    private TextView fXL = null;
    private LinearLayout fXM = null;
    private TextView bDc = null;
    private EditText mEdit = null;
    private LinearLayout fXN = null;
    private TextView fXO = null;
    private TextView fXP = null;
    private TextView fXQ = null;
    private InputMethodManager mInputManager = null;
    private boolean fXR = false;
    private PersonChangeModel fXS = null;
    protected HeadImageView die = null;
    private com.baidu.adp.widget.ImageView.a eoH = null;
    private a fXT = null;
    private b fXU = null;
    private ProgressBar fXV = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a cFH = null;
    private com.baidu.tbadk.core.dialog.b fXW = null;
    private boolean fWq = false;
    private boolean dRj = false;
    private boolean fXX = false;
    private int mSex = 0;
    private final int fXY = 500;
    private boolean fXZ = false;
    private boolean dmW = false;
    private final View.OnClickListener fYi = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.fXS.biF().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.fWq = true;
            }
            if (PersonChangeActivity.this.fWq) {
                PersonChangeActivity.this.cFH.xe();
                return;
            }
            if (PersonChangeActivity.this.fXS != null && PersonChangeActivity.this.fXS.biF().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.fXG.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.fXS.biF());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.fXS.biF());
                }
                PersonChangeActivity.this.biD();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener dnD = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.dmW = true;
                        PersonChangeActivity.this.fYh = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener fYj = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.fXS != null && PersonChangeActivity.this.fXS.biF() != null && personChangeData != null) {
                    PersonChangeActivity.this.fXS.biF().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.fXS.biF().setMem(personChangeData.getMen());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(f.h.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        C(bundle);
        QP();
        if (bundle != null) {
            this.fXG = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.fXG = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.dnD);
        registerListener(this.fYj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dnD);
        if (this.fXT != null) {
            this.fXT.cancel();
        }
        if (this.fXU != null) {
            this.fXU.cancel();
        }
        if (this.fXV != null) {
            this.fXV.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        if (this.aAU != null) {
            this.aAU.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.die || view == this.fYf) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.bkZ == null) {
                this.bkZ = new com.baidu.tbadk.core.util.b.a();
            }
            this.bkZ.zW();
            this.bkZ.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.bkZ.u(pageActivity)) {
                biz();
            }
        } else if (view == this.fXH) {
            if (!this.dRj && !this.fXX) {
                finish();
            }
            if (this.fXG.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.dRj) {
                ajF();
            } else if (this.fXX) {
                biE();
            }
        } else if (view == this.fXK) {
            biB();
        } else if (view == this.fXM) {
            bix();
        } else if (view == this.mEdit) {
            rw(800);
        } else if (view == this.fYd) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(f.j.support_modify_nickname));
            } else if (aj.iq()) {
                biv();
            } else {
                int nickNameLeftDays = this.fXS.biF().getNickNameLeftDays();
                if (this.fXS.biF().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.dB(String.format(getPageContext().getPageActivity().getString(f.j.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
                        aVar.a(f.j.open_now, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                if (j.jE()) {
                                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), 24);
                                    memberPayActivityConfig.setReferPageClickZone("my_data_V8.9", "pop_ups_opende_button_V8.9");
                                    PersonChangeActivity.this.sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                                    TiebaStatic.log("c12409");
                                } else {
                                    PersonChangeActivity.this.showToast(f.j.neterror);
                                }
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(getPageContext()).xe();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(f.j.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(f.j.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.fYa) {
            if (this.fXS == null || this.fXS.biF() == null || StringUtils.isNull(this.fXS.biF().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void biv() {
        if (this.fYg == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(f.h.person_nickname_act_dialog, (ViewGroup) null);
            this.fYg = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.fYg.w(inflate);
            this.fYg.a(f.j.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.aYQ(), true)));
                    aVar.dismiss();
                }
            });
            this.fYg.b(f.j.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.fYg.b(getPageContext());
            am.h(inflate.findViewById(f.g.nickname_dialog_title), f.d.cp_cont_b);
            am.h(inflate.findViewById(f.g.nickname_dialog_tip), f.d.common_color_10122);
        }
        this.fYg.xe();
    }

    private void i(AccountData accountData) {
        if (this.aAU == null) {
            this.aAU = new com.baidu.tbadk.coreExtra.view.a(this);
            this.aAU.a(new a.InterfaceC0107a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0107a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.rX(accountData2.getAccount());
                    }
                }
            });
        }
        this.aAU.FN();
        this.aAU.setAccountData(accountData);
        this.aAU.FJ();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.fXR = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.fXR) {
            biw();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biw() {
        if (this.mEdit.getVisibility() == 0) {
            this.fXN.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.bDc.setText(replaceAll);
            } else {
                this.bDc.setText(getPageContext().getString(f.j.add_intro));
            }
            if (this.fXS.biF().getIntro() == null || !this.fXS.biF().getIntro().equals(replaceAll)) {
                this.fWq = true;
            }
            this.fXS.biF().setIntro(replaceAll);
            this.bDc.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void bix() {
        if (this.mEdit.getVisibility() != 0) {
            this.bDc.setVisibility(8);
            this.mEdit.setText(this.fXS.biF().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            rw(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rw(int i) {
        this.fXI.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.fXI.fullScroll(130);
            }
        }, i);
    }

    private void C(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.fXU != null) {
                    PersonChangeActivity.this.fXU.cancel();
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
        this.fXS = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.cZh);
        am.a(this.aaZ, f.C0146f.icon_nav_close, f.C0146f.icon_nav_close_w, f.C0146f.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.die.refresh();
        am.h(this.fYb, f.d.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.fXS.biF() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.fXS.biF()));
        }
    }

    private void QP() {
        this.fYf = findViewById(f.g.photo_pop_icon);
        this.fYf.setOnClickListener(this);
        this.die = (HeadImageView) findViewById(f.g.photo);
        this.die.setOnClickListener(this);
        this.die.startLoad(p.ev(this.fXS.biF().getPortrait()), 25, false);
        this.cZh = (LinearLayout) findViewById(f.g.parent);
        this.fXI = (ScrollView) findViewById(f.g.person_change_scroll);
        this.fXK = (LinearLayout) findViewById(f.g.person_sex);
        this.fXL = (TextView) findViewById(f.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(f.g.view_navigation_bar);
        this.aaY = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, f.h.widget_nb_item_finish, this.fYi);
        this.aaZ = (ImageView) this.aaY.findViewById(f.g.widget_navi_back_button);
        this.aaZ.setContentDescription(getPageContext().getPageActivity().getResources().getString(f.j.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(f.j.my_info));
        this.fXH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, f.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.evC = (TextView) this.fXH.findViewById(f.g.right_textview);
        this.evC.setText(getPageContext().getString(f.j.save));
        am.c(this.evC, f.d.navi_op_text, 1);
        this.fXH.setOnClickListener(this);
        this.fXK.setOnClickListener(this);
        this.fXM = (LinearLayout) findViewById(f.g.intro_click);
        this.fXM.setOnClickListener(this);
        this.fXM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.fXR = true;
                    return false;
                }
                return false;
            }
        });
        this.fXJ = (TextView) findViewById(f.g.nick_name_show);
        this.fXJ.setText(this.fXS.biF().getNameShow());
        this.fYd = findViewById(f.g.person_nickname);
        this.fYd.setOnClickListener(this);
        this.fYe = findViewById(f.g.nick_name_more);
        biy();
        this.fYb = (TextView) findViewById(f.g.user_name_show);
        this.fYa = findViewById(f.g.person_name);
        this.fYc = findViewById(f.g.user_name_more_icon);
        this.fYa.setOnClickListener(this);
        if (StringUtils.isNull(this.fXS.biF().getName())) {
            this.fYb.setText(getPageContext().getString(f.j.tip_empty_user_name));
            this.fXZ = false;
            this.fYa.setClickable(true);
            this.fYc.setVisibility(0);
        } else {
            this.fYb.setText(this.fXS.biF().getName());
            this.fXZ = true;
            this.fYa.setClickable(false);
            this.fYc.setVisibility(8);
        }
        this.bDc = (TextView) findViewById(f.g.intro);
        if (this.fXS.biF().getIntro() != null && this.fXS.biF().getIntro().length() > 0) {
            this.bDc.setText(this.fXS.biF().getIntro());
        } else {
            this.bDc.setText(getPageContext().getString(f.j.add_intro));
        }
        this.mEdit = (EditText) findViewById(f.g.edit);
        this.mEdit.setText(this.fXS.biF().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.biw();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.fXR = true;
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
                PersonChangeActivity.this.fXO.setText(String.valueOf(length));
                PersonChangeActivity.this.fXN.setVisibility(0);
                PersonChangeActivity.this.rw(0);
                PersonChangeActivity.this.biA();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(f.j.over_limit_tip);
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.fXS.biF().getIntro())) {
                    PersonChangeActivity.this.dRj = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.c(PersonChangeActivity.this.evC, f.d.navi_op_text, 1);
                    } else {
                        am.c(PersonChangeActivity.this.evC, f.d.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.fXS.biF().getSex() == 1) {
            this.mSex = 1;
            this.fXL.setText(f.j.male);
        } else if (this.fXS.biF().getSex() == 2) {
            this.mSex = 2;
            this.fXL.setText(f.j.female);
        } else {
            this.fXL.setText(f.j.change_sex);
        }
        this.fXN = (LinearLayout) findViewById(f.g.intro_text_tip);
        this.fXO = (TextView) findViewById(f.g.intro_text_tip_num);
        this.fXP = (TextView) findViewById(f.g.intro_text_tip_divider);
        this.fXQ = (TextView) findViewById(f.g.intro_text_tip_limit);
        this.fXV = (ProgressBar) findViewById(f.g.image_progress);
        this.cFH = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cFH.dB(getPageContext().getString(f.j.confirm_giveup));
        this.cFH.a(getPageContext().getString(f.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.ajF();
            }
        });
        this.cFH.b(getPageContext().getString(f.j.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.fXS.biF().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.fXG.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.fXS.biF());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.fXS.biF());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.biD();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.cFH.b(getPageContext());
    }

    private void biy() {
        if (aj.iq() || this.fXS.biF().getNickNameLeftDays() == 0) {
            this.fYe.setVisibility(0);
        } else {
            this.fYe.setVisibility(8);
        }
    }

    public void biz() {
        String[] strArr = {getPageContext().getString(f.j.change_photo), getPageContext().getString(f.j.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.ci(f.j.operation);
        bVar.a(strArr, new b.InterfaceC0101b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
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
        bVar.xh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biA() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = am.getColor(f.d.common_color_10159);
        } else {
            color = am.getColor(f.d.common_color_10077);
        }
        rx(color);
    }

    private void rx(int i) {
        this.fXO.setTextColor(i);
        this.fXP.setTextColor(i);
        this.fXQ.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajF() {
        if (this.fXS != null && this.fXS.biF() != null) {
            biw();
            if (!j.jE()) {
                showToast(f.j.neterror);
                return;
            }
            this.fXS.biF().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.fXS.biF().setSex(this.mSex);
            if (this.fXU == null) {
                this.fXU = new b(this.fXS);
                this.fXU.setPriority(3);
                this.fXU.execute(new String[0]);
            }
        }
    }

    private void biB() {
        if (this.fXW == null) {
            this.fXW = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            final String string = getPageContext().getString(f.j.male);
            final String string2 = getPageContext().getString(f.j.female);
            this.fXW.ci(f.j.choose_sex);
            this.fXW.a(new String[]{string, string2}, new b.InterfaceC0101b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0101b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        PersonChangeActivity.this.mSex = 1;
                        PersonChangeActivity.this.fXL.setText(string);
                    } else if (i == 1) {
                        PersonChangeActivity.this.mSex = 2;
                        PersonChangeActivity.this.fXL.setText(string2);
                    }
                    if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.fXS.biF().getSex()) {
                        PersonChangeActivity.this.dRj = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            am.c(PersonChangeActivity.this.evC, f.d.navi_op_text, 1);
                        } else {
                            am.c(PersonChangeActivity.this.evC, f.d.cp_link_tip_a, 1);
                        }
                    }
                }
            });
            this.fXW.d(getPageContext());
        }
        this.fXW.xh();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            biw();
            this.fYi.onClick(null);
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
                    this.fXS.biF().setPhotoChanged(true);
                    biC();
                    this.dRj = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.c(this.evC, f.d.navi_op_text, 1);
                        return;
                    } else {
                        am.c(this.evC, f.d.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.fXS.biF().setPhotoChanged(true);
                    if (intent != null) {
                        this.die.setImageBitmap(null);
                        this.die.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.dRj = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.c(this.evC, f.d.navi_op_text, 1);
                        return;
                    } else {
                        am.c(this.evC, f.d.cp_link_tip_a, 1);
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

    private void rW(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fXX = true;
            this.fXS.biF().setPhotoChanged(true);
            this.fXS.biF().setNameShow(str);
            this.fXS.biF().setNickNameLeftDays(90);
            this.fXJ.setText(str);
            biy();
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

    private void biC() {
        if (this.fXT != null) {
            this.fXT.cancel();
        }
        this.eoH = null;
        this.fXT = new a();
        this.fXT.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biD() {
        if (this.fXS != null && this.fXS.biF() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.fXS.biF()));
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
            PersonChangeActivity.this.fXV.setVisibility(0);
            PersonChangeActivity.this.die.setImageDrawable(null);
            PersonChangeActivity.this.eoH = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Bitmap doInBackground(Object... objArr) {
            return l.aa(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.fXT = null;
            PersonChangeActivity.this.fXV.setVisibility(8);
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
            PersonChangeActivity.this.fXT = null;
            PersonChangeActivity.this.fXV.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.eoH = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.eoH.a(PersonChangeActivity.this.die);
                com.baidu.tbadk.imageManager.c.IQ().a(PersonChangeActivity.this.fXS.biF().getPortrait(), PersonChangeActivity.this.eoH, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biE() {
        Intent intent = new Intent();
        if (this.fXG.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.fXS.biF());
        } else {
            intent.putExtra("data", this.fXS.biF());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.fXS.biF());
        setResult(-1, intent);
        biD();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel fXS;
        private y mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.fXS = null;
            this.fXS = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.fXU = null;
            if (this.mNetWork != null) {
                this.mNetWork.hN();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.fXU = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.yM().zL().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(f.j.success));
                    PersonChangeActivity.this.biE();
                } else {
                    PersonChangeActivity.this.showToast(this.mNetWork.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(f.j.saving), PersonChangeActivity.this.mDialogCancelListener);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.fXS != null) {
                this.mNetWork = new y(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.fXS.biF().getSex()));
                this.mNetWork.o("intro", this.fXS.biF().getIntro());
                this.mNetWork.yr();
                if (this.mNetWork.yM().zL().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.bwX();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dmW && !TextUtils.isEmpty(this.fYh)) {
            rW(this.fYh);
            this.dmW = false;
            this.fYh = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rX(String str) {
        if (!StringUtils.isNull(str)) {
            this.fXZ = true;
            this.fYb.setText(str);
            this.fYa.setClickable(false);
            this.fYc.setVisibility(8);
        }
    }
}
