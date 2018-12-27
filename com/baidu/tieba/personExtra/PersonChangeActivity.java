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
    private com.baidu.tbadk.coreExtra.view.a aMU;
    private View amO;
    private ImageView amP;
    private com.baidu.tbadk.core.util.b.a bzi;
    private View gxF;
    private View gxY;
    private TextView gxZ;
    private View gya;
    private View gyb;
    private View gyc;
    private View gyd;
    private com.baidu.tbadk.core.dialog.a gye;
    private String gyf;
    public final int gxD = 90;
    private Boolean gxE = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView eVD = null;
    private LinearLayout dxC = null;
    private ScrollView gxG = null;
    private TextView gxH = null;
    private LinearLayout gxI = null;
    private TextView gxJ = null;
    private LinearLayout gxK = null;
    private TextView bWa = null;
    private EditText mEdit = null;
    private LinearLayout gxL = null;
    private TextView gxM = null;
    private TextView gxN = null;
    private TextView gxO = null;
    private InputMethodManager mInputManager = null;
    private boolean gxP = false;
    private PersonChangeModel gxQ = null;
    protected HeadImageView dGE = null;
    private com.baidu.adp.widget.ImageView.a eOO = null;
    private a gxR = null;
    private b gxS = null;
    private ProgressBar gxT = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a dez = null;
    private com.baidu.tbadk.core.dialog.b gxU = null;
    private boolean gwo = false;
    private boolean erA = false;
    private boolean gxV = false;
    private int mSex = 0;
    private final int gxW = 500;
    private boolean gxX = false;
    private boolean dLy = false;
    private final View.OnClickListener gyg = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.gxQ.bqq().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.gwo = true;
            }
            if (PersonChangeActivity.this.gwo) {
                PersonChangeActivity.this.dez.BF();
                return;
            }
            if (PersonChangeActivity.this.gxQ != null && PersonChangeActivity.this.gxQ.bqq().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.gxE.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.gxQ.bqq());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.gxQ.bqq());
                }
                PersonChangeActivity.this.bqo();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener dMg = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.dLy = true;
                        PersonChangeActivity.this.gyf = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener gyh = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.gxQ != null && PersonChangeActivity.this.gxQ.bqq() != null && personChangeData != null) {
                    PersonChangeActivity.this.gxQ.bqq().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.gxQ.bqq().setMem(personChangeData.getMen());
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
        J(bundle);
        VQ();
        if (bundle != null) {
            this.gxE = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.gxE = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.dMg);
        registerListener(this.gyh);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dMg);
        if (this.gxR != null) {
            this.gxR.cancel();
        }
        if (this.gxS != null) {
            this.gxS.cancel();
        }
        if (this.gxT != null) {
            this.gxT.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        if (this.aMU != null) {
            this.aMU.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dGE || view == this.gyd) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.bzi == null) {
                this.bzi = new com.baidu.tbadk.core.util.b.a();
            }
            this.bzi.Et();
            this.bzi.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.bzi.A(pageActivity)) {
                bqk();
            }
        } else if (view == this.gxF) {
            if (!this.erA && !this.gxV) {
                finish();
            }
            if (this.gxE.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.erA) {
                aqW();
            } else if (this.gxV) {
                bqp();
            }
        } else if (view == this.gxI) {
            bqm();
        } else if (view == this.gxK) {
            bqi();
        } else if (view == this.mEdit) {
            tq(800);
        } else if (view == this.gyb) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(e.j.support_modify_nickname));
            } else if (an.jJ()) {
                bqg();
            } else {
                int nickNameLeftDays = this.gxQ.bqq().getNickNameLeftDays();
                if (this.gxQ.bqq().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.eB(String.format(getPageContext().getPageActivity().getString(e.j.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).BF();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(e.j.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(e.j.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.gxY) {
            if (this.gxQ == null || this.gxQ.bqq() == null || StringUtils.isNull(this.gxQ.bqq().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void bqg() {
        if (this.gye == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.person_nickname_act_dialog, (ViewGroup) null);
            this.gye = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.gye.G(inflate);
            this.gye.a(e.j.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.bgE(), true)));
                    aVar.dismiss();
                }
            });
            this.gye.b(e.j.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gye.b(getPageContext());
            al.h(inflate.findViewById(e.g.nickname_dialog_title), e.d.cp_cont_b);
            al.h(inflate.findViewById(e.g.nickname_dialog_tip), e.d.common_color_10122);
        }
        this.gye.BF();
    }

    private void i(AccountData accountData) {
        if (this.aMU == null) {
            this.aMU = new com.baidu.tbadk.coreExtra.view.a(this);
            this.aMU.a(new a.InterfaceC0165a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0165a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.tM(accountData2.getAccount());
                    }
                }
            });
        }
        this.aMU.Kv();
        this.aMU.setAccountData(accountData);
        this.aMU.Kr();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.gxP = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.gxP) {
            bqh();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqh() {
        if (this.mEdit.getVisibility() == 0) {
            this.gxL.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.bWa.setText(replaceAll);
            } else {
                this.bWa.setText(getPageContext().getString(e.j.add_intro));
            }
            if (this.gxQ.bqq().getIntro() == null || !this.gxQ.bqq().getIntro().equals(replaceAll)) {
                this.gwo = true;
            }
            this.gxQ.bqq().setIntro(replaceAll);
            this.bWa.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void bqi() {
        if (this.mEdit.getVisibility() != 0) {
            this.bWa.setVisibility(8);
            this.mEdit.setText(this.gxQ.bqq().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            tq(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq(int i) {
        this.gxG.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.gxG.fullScroll(130);
            }
        }, i);
    }

    private void J(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.gxS != null) {
                    PersonChangeActivity.this.gxS.cancel();
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
        this.gxQ = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.dxC);
        al.a(this.amP, e.f.icon_nav_close, e.f.icon_nav_close_w, e.f.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dGE.refresh();
        al.h(this.gxZ, e.d.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.gxQ.bqq() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.gxQ.bqq()));
        }
    }

    private void VQ() {
        this.gyd = findViewById(e.g.photo_pop_icon);
        this.gyd.setOnClickListener(this);
        this.dGE = (HeadImageView) findViewById(e.g.photo);
        this.dGE.setOnClickListener(this);
        this.dGE.startLoad(o.fu(this.gxQ.bqq().getPortrait()), 25, false);
        this.dxC = (LinearLayout) findViewById(e.g.parent);
        this.gxG = (ScrollView) findViewById(e.g.person_change_scroll);
        this.gxI = (LinearLayout) findViewById(e.g.person_sex);
        this.gxJ = (TextView) findViewById(e.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.amO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.widget_nb_item_finish, this.gyg);
        this.amP = (ImageView) this.amO.findViewById(e.g.widget_navi_back_button);
        this.amP.setContentDescription(getPageContext().getPageActivity().getResources().getString(e.j.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.my_info));
        this.gxF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eVD = (TextView) this.gxF.findViewById(e.g.right_textview);
        this.eVD.setText(getPageContext().getString(e.j.save));
        al.c(this.eVD, e.d.navi_op_text, 1);
        this.gxF.setOnClickListener(this);
        this.gxI.setOnClickListener(this);
        this.gxK = (LinearLayout) findViewById(e.g.intro_click);
        this.gxK.setOnClickListener(this);
        this.gxK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.gxP = true;
                    return false;
                }
                return false;
            }
        });
        this.gxH = (TextView) findViewById(e.g.nick_name_show);
        this.gxH.setText(this.gxQ.bqq().getNameShow());
        this.gyb = findViewById(e.g.person_nickname);
        this.gyb.setOnClickListener(this);
        this.gyc = findViewById(e.g.nick_name_more);
        bqj();
        this.gxZ = (TextView) findViewById(e.g.user_name_show);
        this.gxY = findViewById(e.g.person_name);
        this.gya = findViewById(e.g.user_name_more_icon);
        this.gxY.setOnClickListener(this);
        if (StringUtils.isNull(this.gxQ.bqq().getName())) {
            this.gxZ.setText(getPageContext().getString(e.j.tip_empty_user_name));
            this.gxX = false;
            this.gxY.setClickable(true);
            this.gya.setVisibility(0);
        } else {
            this.gxZ.setText(this.gxQ.bqq().getName());
            this.gxX = true;
            this.gxY.setClickable(false);
            this.gya.setVisibility(8);
        }
        this.bWa = (TextView) findViewById(e.g.intro);
        if (this.gxQ.bqq().getIntro() != null && this.gxQ.bqq().getIntro().length() > 0) {
            this.bWa.setText(this.gxQ.bqq().getIntro());
        } else {
            this.bWa.setText(getPageContext().getString(e.j.add_intro));
        }
        this.mEdit = (EditText) findViewById(e.g.edit);
        this.mEdit.setText(this.gxQ.bqq().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.bqh();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.gxP = true;
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
                PersonChangeActivity.this.gxM.setText(String.valueOf(length));
                PersonChangeActivity.this.gxL.setVisibility(0);
                PersonChangeActivity.this.tq(0);
                PersonChangeActivity.this.bql();
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.gxQ.bqq().getIntro())) {
                    PersonChangeActivity.this.erA = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(PersonChangeActivity.this.eVD, e.d.navi_op_text, 1);
                    } else {
                        al.c(PersonChangeActivity.this.eVD, e.d.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.gxQ.bqq().getSex() == 1) {
            this.mSex = 1;
            this.gxJ.setText(e.j.male);
        } else if (this.gxQ.bqq().getSex() == 2) {
            this.mSex = 2;
            this.gxJ.setText(e.j.female);
        } else {
            this.gxJ.setText(e.j.change_sex);
        }
        this.gxL = (LinearLayout) findViewById(e.g.intro_text_tip);
        this.gxM = (TextView) findViewById(e.g.intro_text_tip_num);
        this.gxN = (TextView) findViewById(e.g.intro_text_tip_divider);
        this.gxO = (TextView) findViewById(e.g.intro_text_tip_limit);
        this.gxT = (ProgressBar) findViewById(e.g.image_progress);
        this.dez = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.dez.eB(getPageContext().getString(e.j.confirm_giveup));
        this.dez.a(getPageContext().getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.aqW();
            }
        });
        this.dez.b(getPageContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.gxQ.bqq().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.gxE.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.gxQ.bqq());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.gxQ.bqq());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.bqo();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.dez.b(getPageContext());
    }

    private void bqj() {
        if (an.jJ() || this.gxQ.bqq().getNickNameLeftDays() == 0) {
            this.gyc.setVisibility(0);
        } else {
            this.gyc.setVisibility(8);
        }
    }

    public void bqk() {
        String[] strArr = {getPageContext().getString(e.j.change_photo), getPageContext().getString(e.j.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.de(e.j.operation);
        bVar.a(strArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
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
        bVar.BI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bql() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = al.getColor(e.d.common_color_10159);
        } else {
            color = al.getColor(e.d.common_color_10077);
        }
        tr(color);
    }

    private void tr(int i) {
        this.gxM.setTextColor(i);
        this.gxN.setTextColor(i);
        this.gxO.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqW() {
        if (this.gxQ != null && this.gxQ.bqq() != null) {
            bqh();
            if (!j.kV()) {
                showToast(e.j.neterror);
                return;
            }
            this.gxQ.bqq().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.gxQ.bqq().setSex(this.mSex);
            if (this.gxS == null) {
                this.gxS = new b(this.gxQ);
                this.gxS.setPriority(3);
                this.gxS.execute(new String[0]);
            }
        }
    }

    private void bqm() {
        if (this.gxU == null) {
            this.gxU = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            final String string = getPageContext().getString(e.j.male);
            final String string2 = getPageContext().getString(e.j.female);
            this.gxU.de(e.j.choose_sex);
            this.gxU.a(new String[]{string, string2}, new b.InterfaceC0158b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        PersonChangeActivity.this.mSex = 1;
                        PersonChangeActivity.this.gxJ.setText(string);
                    } else if (i == 1) {
                        PersonChangeActivity.this.mSex = 2;
                        PersonChangeActivity.this.gxJ.setText(string2);
                    }
                    if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.gxQ.bqq().getSex()) {
                        PersonChangeActivity.this.erA = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            al.c(PersonChangeActivity.this.eVD, e.d.navi_op_text, 1);
                        } else {
                            al.c(PersonChangeActivity.this.eVD, e.d.cp_link_tip_a, 1);
                        }
                    }
                }
            });
            this.gxU.d(getPageContext());
        }
        this.gxU.BI();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bqh();
            this.gyg.onClick(null);
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
                    this.gxQ.bqq().setPhotoChanged(true);
                    bqn();
                    this.erA = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(this.eVD, e.d.navi_op_text, 1);
                        return;
                    } else {
                        al.c(this.eVD, e.d.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.gxQ.bqq().setPhotoChanged(true);
                    if (intent != null) {
                        this.dGE.setImageBitmap(null);
                        this.dGE.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.erA = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(this.eVD, e.d.navi_op_text, 1);
                        return;
                    } else {
                        al.c(this.eVD, e.d.cp_link_tip_a, 1);
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

    private void tL(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gxV = true;
            this.gxQ.bqq().setPhotoChanged(true);
            this.gxQ.bqq().setNameShow(str);
            this.gxQ.bqq().setNickNameLeftDays(90);
            this.gxH.setText(str);
            bqj();
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

    private void bqn() {
        if (this.gxR != null) {
            this.gxR.cancel();
        }
        this.eOO = null;
        this.gxR = new a();
        this.gxR.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqo() {
        if (this.gxQ != null && this.gxQ.bqq() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.gxQ.bqq()));
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
            PersonChangeActivity.this.gxT.setVisibility(0);
            PersonChangeActivity.this.dGE.setImageDrawable(null);
            PersonChangeActivity.this.eOO = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public Bitmap doInBackground(Object... objArr) {
            return l.ax(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.gxR = null;
            PersonChangeActivity.this.gxT.setVisibility(8);
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
            PersonChangeActivity.this.gxR = null;
            PersonChangeActivity.this.gxT.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.eOO = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.eOO.a(PersonChangeActivity.this.dGE);
                com.baidu.tbadk.imageManager.c.Nv().a(PersonChangeActivity.this.gxQ.bqq().getPortrait(), PersonChangeActivity.this.eOO, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqp() {
        Intent intent = new Intent();
        if (this.gxE.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.gxQ.bqq());
        } else {
            intent.putExtra("data", this.gxQ.bqq());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.gxQ.bqq());
        setResult(-1, intent);
        bqo();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel gxQ;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.gxQ = null;
            this.gxQ = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.gxS = null;
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.gxS = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.Dj().Ei().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(e.j.success));
                    PersonChangeActivity.this.bqp();
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
            if (this.gxQ != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.x(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.gxQ.bqq().getSex()));
                this.mNetWork.x("intro", this.gxQ.bqq().getIntro());
                this.mNetWork.CO();
                if (this.mNetWork.Dj().Ei().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.bEX();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dLy && !TextUtils.isEmpty(this.gyf)) {
            tL(this.gyf);
            this.dLy = false;
            this.gyf = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tM(String str) {
        if (!StringUtils.isNull(str)) {
            this.gxX = true;
            this.gxZ.setText(str);
            this.gxY.setClickable(false);
            this.gya.setVisibility(8);
        }
    }
}
