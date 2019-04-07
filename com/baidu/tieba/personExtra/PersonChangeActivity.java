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
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.s.ao;
import com.baidu.tieba.d;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private com.baidu.tbadk.coreExtra.view.c bVZ;
    private View bud;
    private ImageView bue;
    private View hOO;
    private TextView hOP;
    private View hOQ;
    private View hOR;
    private View hOS;
    private View hOT;
    private com.baidu.tbadk.core.dialog.a hOU;
    private String hOV;
    private View hOu;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public final int hOs = 90;
    private Boolean hOt = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView gmk = null;
    private LinearLayout eLo = null;
    private ScrollView hOv = null;
    private TextView hOw = null;
    private LinearLayout hOx = null;
    private TextView hOy = null;
    private LinearLayout hOz = null;
    private TextView dlM = null;
    private EditText mEdit = null;
    private LinearLayout hOA = null;
    private TextView hOB = null;
    private TextView hOC = null;
    private TextView hOD = null;
    private InputMethodManager mInputManager = null;
    private boolean hOE = false;
    private PersonChangeModel hOF = null;
    protected HeadImageView eUn = null;
    private com.baidu.adp.widget.ImageView.a gfs = null;
    private a hOG = null;
    private b hOH = null;
    private ProgressBar hOI = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a eoT = null;
    private g hOJ = null;
    private boolean hOK = false;
    private boolean fEs = false;
    private boolean hOL = false;
    private int mSex = 0;
    private final int hOM = 500;
    private boolean hON = false;
    private boolean eZs = false;
    private final View.OnClickListener hOW = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.hOF.bRs().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.hOK = true;
            }
            if (PersonChangeActivity.this.hOK) {
                PersonChangeActivity.this.eoT.aaW();
                return;
            }
            if (PersonChangeActivity.this.hOF != null && PersonChangeActivity.this.hOF.bRs().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.hOt.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.hOF.bRs());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.hOF.bRs());
                }
                PersonChangeActivity.this.bRq();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener fac = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.eZs = true;
                        PersonChangeActivity.this.hOV = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener hOX = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.hOF != null && PersonChangeActivity.this.hOF.bRs() != null && personChangeData != null) {
                    PersonChangeActivity.this.hOF.bRs().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.hOF.bRs().setMem(personChangeData.getMen());
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
        ad(bundle);
        awj();
        if (bundle != null) {
            this.hOt = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.hOt = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.fac);
        registerListener(this.hOX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fac);
        if (this.hOG != null) {
            this.hOG.cancel();
        }
        if (this.hOH != null) {
            this.hOH.cancel();
        }
        if (this.hOI != null) {
            this.hOI.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        if (this.bVZ != null) {
            this.bVZ.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eUn || view == this.hOT) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.adN();
            this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.Y(pageActivity)) {
                bRm();
            }
        } else if (view == this.hOu) {
            if (!this.fEs && !this.hOL) {
                finish();
            }
            if (this.hOt.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.fEs) {
                aRj();
            } else if (this.hOL) {
                bRr();
            }
        } else if (view == this.hOx) {
            bRo();
        } else if (view == this.hOz) {
            bRk();
        } else if (view == this.mEdit) {
            wZ(800);
        } else if (view == this.hOR) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(d.j.support_modify_nickname));
            } else if (ao.jK()) {
                bRi();
            } else {
                int nickNameLeftDays = this.hOF.bRs().getNickNameLeftDays();
                if (this.hOF.bRs().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.lz(String.format(getPageContext().getPageActivity().getString(d.j.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
                        aVar.a(d.j.open_now, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                if (j.kY()) {
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
                        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(getPageContext()).aaW();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(d.j.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(d.j.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.hOO) {
            if (this.hOF == null || this.hOF.bRs() == null || StringUtils.isNull(this.hOF.bRs().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void bRi() {
        if (this.hOU == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.person_nickname_act_dialog, (ViewGroup) null);
            this.hOU = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.hOU.az(inflate);
            this.hOU.a(d.j.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.bHH(), true)));
                    aVar.dismiss();
                }
            });
            this.hOU.b(d.j.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hOU.b(getPageContext());
            al.j(inflate.findViewById(d.g.nickname_dialog_title), d.C0277d.cp_cont_b);
            al.j(inflate.findViewById(d.g.nickname_dialog_tip), d.C0277d.common_color_10122);
        }
        this.hOU.aaW();
    }

    private void i(AccountData accountData) {
        if (this.bVZ == null) {
            this.bVZ = new com.baidu.tbadk.coreExtra.view.c(this);
            this.bVZ.a(new c.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.AG(accountData2.getAccount());
                    }
                }
            });
        }
        this.bVZ.akj();
        this.bVZ.setAccountData(accountData);
        this.bVZ.akf();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.hOE = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.hOE) {
            bRj();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRj() {
        if (this.mEdit.getVisibility() == 0) {
            this.hOA.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.dlM.setText(replaceAll);
            } else {
                this.dlM.setText(getPageContext().getString(d.j.add_intro));
            }
            if (this.hOF.bRs().getIntro() == null || !this.hOF.bRs().getIntro().equals(replaceAll)) {
                this.hOK = true;
            }
            this.hOF.bRs().setIntro(replaceAll);
            this.dlM.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void bRk() {
        if (this.mEdit.getVisibility() != 0) {
            this.dlM.setVisibility(8);
            this.mEdit.setText(this.hOF.bRs().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            wZ(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wZ(int i) {
        this.hOv.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.hOv.fullScroll(130);
            }
        }, i);
    }

    private void ad(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.hOH != null) {
                    PersonChangeActivity.this.hOH.cancel();
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
        this.hOF = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.eLo);
        al.a(this.bue, d.f.icon_nav_close, d.f.icon_nav_close_w, d.f.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eUn.refresh();
        al.j(this.hOP, d.C0277d.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.hOF.bRs() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.hOF.bRs()));
        }
    }

    private void awj() {
        this.hOT = findViewById(d.g.photo_pop_icon);
        this.hOT.setOnClickListener(this);
        this.eUn = (HeadImageView) findViewById(d.g.photo);
        this.eUn.setOnClickListener(this);
        this.eUn.startLoad(o.mt(this.hOF.bRs().getPortrait()), 25, false);
        this.eLo = (LinearLayout) findViewById(d.g.parent);
        this.hOv = (ScrollView) findViewById(d.g.person_change_scroll);
        this.hOx = (LinearLayout) findViewById(d.g.person_sex);
        this.hOy = (TextView) findViewById(d.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.bud = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, this.hOW);
        this.bue = (ImageView) this.bud.findViewById(d.g.widget_navi_back_button);
        this.bue.setContentDescription(getPageContext().getPageActivity().getResources().getString(d.j.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.my_info));
        this.hOu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.gmk = (TextView) this.hOu.findViewById(d.g.right_textview);
        this.gmk.setText(getPageContext().getString(d.j.save));
        al.d(this.gmk, d.C0277d.navi_op_text, 1);
        this.hOu.setOnClickListener(this);
        this.hOx.setOnClickListener(this);
        this.hOz = (LinearLayout) findViewById(d.g.intro_click);
        this.hOz.setOnClickListener(this);
        this.hOz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.hOE = true;
                    return false;
                }
                return false;
            }
        });
        this.hOw = (TextView) findViewById(d.g.nick_name_show);
        this.hOw.setText(this.hOF.bRs().getNameShow());
        this.hOR = findViewById(d.g.person_nickname);
        this.hOR.setOnClickListener(this);
        this.hOS = findViewById(d.g.nick_name_more);
        bRl();
        this.hOP = (TextView) findViewById(d.g.user_name_show);
        this.hOO = findViewById(d.g.person_name);
        this.hOQ = findViewById(d.g.user_name_more_icon);
        this.hOO.setOnClickListener(this);
        if (StringUtils.isNull(this.hOF.bRs().getName())) {
            this.hOP.setText(getPageContext().getString(d.j.tip_empty_user_name));
            this.hON = false;
            this.hOO.setClickable(true);
            this.hOQ.setVisibility(0);
        } else {
            this.hOP.setText(this.hOF.bRs().getName());
            this.hON = true;
            this.hOO.setClickable(false);
            this.hOQ.setVisibility(8);
        }
        this.dlM = (TextView) findViewById(d.g.intro);
        if (this.hOF.bRs().getIntro() != null && this.hOF.bRs().getIntro().length() > 0) {
            this.dlM.setText(this.hOF.bRs().getIntro());
        } else {
            this.dlM.setText(getPageContext().getString(d.j.add_intro));
        }
        this.mEdit = (EditText) findViewById(d.g.edit);
        this.mEdit.setText(this.hOF.bRs().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.bRj();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.hOE = true;
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
                PersonChangeActivity.this.hOB.setText(String.valueOf(length));
                PersonChangeActivity.this.hOA.setVisibility(0);
                PersonChangeActivity.this.wZ(0);
                PersonChangeActivity.this.bRn();
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.hOF.bRs().getIntro())) {
                    PersonChangeActivity.this.fEs = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.d(PersonChangeActivity.this.gmk, d.C0277d.navi_op_text, 1);
                    } else {
                        al.d(PersonChangeActivity.this.gmk, d.C0277d.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.hOF.bRs().getSex() == 1) {
            this.mSex = 1;
            this.hOy.setText(d.j.male);
        } else if (this.hOF.bRs().getSex() == 2) {
            this.mSex = 2;
            this.hOy.setText(d.j.female);
        } else {
            this.hOy.setText(d.j.change_sex);
        }
        this.hOA = (LinearLayout) findViewById(d.g.intro_text_tip);
        this.hOB = (TextView) findViewById(d.g.intro_text_tip_num);
        this.hOC = (TextView) findViewById(d.g.intro_text_tip_divider);
        this.hOD = (TextView) findViewById(d.g.intro_text_tip_limit);
        this.hOI = (ProgressBar) findViewById(d.g.image_progress);
        this.eoT = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.eoT.lz(getPageContext().getString(d.j.confirm_giveup));
        this.eoT.a(getPageContext().getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.aRj();
            }
        });
        this.eoT.b(getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.hOF.bRs().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.hOt.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.hOF.bRs());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.hOF.bRs());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.bRq();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.eoT.b(getPageContext());
    }

    private void bRl() {
        if (ao.jK() || this.hOF.bRs().getNickNameLeftDays() == 0) {
            this.hOS.setVisibility(0);
        } else {
            this.hOS.setVisibility(8);
        }
    }

    public void bRm() {
        String[] strArr = {getPageContext().getString(d.j.change_photo), getPageContext().getString(d.j.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.gF(d.j.operation);
        bVar.a(strArr, new b.InterfaceC0225b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
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
        bVar.aaZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRn() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = al.getColor(d.C0277d.common_color_10159);
        } else {
            color = al.getColor(d.C0277d.common_color_10077);
        }
        xa(color);
    }

    private void xa(int i) {
        this.hOB.setTextColor(i);
        this.hOC.setTextColor(i);
        this.hOD.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRj() {
        if (this.hOF != null && this.hOF.bRs() != null) {
            bRj();
            if (!j.kY()) {
                showToast(d.j.neterror);
                return;
            }
            this.hOF.bRs().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.hOF.bRs().setSex(this.mSex);
            if (this.hOH == null) {
                this.hOH = new b(this.hOF);
                this.hOH.setPriority(3);
                this.hOH.execute(new String[0]);
            }
        }
    }

    private void bRo() {
        if (this.hOJ == null) {
            this.hOJ = new g(getPageContext());
            final String string = getPageContext().getString(d.j.male);
            final String string2 = getPageContext().getString(d.j.female);
            this.hOJ.a(getString(d.j.choose_sex), new String[]{string, string2}, new i.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.i.c
                public void a(i iVar, int i, View view) {
                    if (PersonChangeActivity.this.hOJ != null && PersonChangeActivity.this.hOJ.isShowing()) {
                        PersonChangeActivity.this.hOJ.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.hOy.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.hOy.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.hOF.bRs().getSex()) {
                            PersonChangeActivity.this.fEs = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                al.d(PersonChangeActivity.this.gmk, d.C0277d.navi_op_text, 1);
                            } else {
                                al.d(PersonChangeActivity.this.gmk, d.C0277d.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.hOJ.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bRj();
            this.hOW.onClick(null);
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
                            aq(intent);
                            return;
                        } else {
                            aj(intent);
                            return;
                        }
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.hOF.bRs().setPhotoChanged(true);
                    bRp();
                    this.fEs = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.d(this.gmk, d.C0277d.navi_op_text, 1);
                        return;
                    } else {
                        al.d(this.gmk, d.C0277d.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.hOF.bRs().setPhotoChanged(true);
                    if (intent != null) {
                        this.eUn.setImageBitmap(null);
                        this.eUn.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.fEs = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.d(this.gmk, d.C0277d.navi_op_text, 1);
                        return;
                    } else {
                        al.d(this.gmk, d.C0277d.cp_link_tip_a, 1);
                        return;
                    }
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    ak.c(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    private void AF(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hOL = true;
            this.hOF.bRs().setPhotoChanged(true);
            this.hOF.bRs().setNameShow(str);
            this.hOF.bRs().setNickNameLeftDays(90);
            this.hOw.setText(str);
            bRl();
        }
    }

    private void aj(Intent intent) {
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

    private void aq(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void bRp() {
        if (this.hOG != null) {
            this.hOG.cancel();
        }
        this.gfs = null;
        this.hOG = new a();
        this.hOG.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRq() {
        if (this.hOF != null && this.hOF.bRs() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.hOF.bRs()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.hOI.setVisibility(0);
            PersonChangeActivity.this.eUn.setImageDrawable(null);
            PersonChangeActivity.this.gfs = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public Bitmap doInBackground(Object... objArr) {
            return m.bF(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.hOG = null;
            PersonChangeActivity.this.hOI.setVisibility(8);
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
            PersonChangeActivity.this.hOG = null;
            PersonChangeActivity.this.hOI.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.gfs = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.gfs.a(PersonChangeActivity.this.eUn);
                com.baidu.tbadk.imageManager.c.anm().a(PersonChangeActivity.this.hOF.bRs().getPortrait(), PersonChangeActivity.this.gfs, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRr() {
        Intent intent = new Intent();
        if (this.hOt.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.hOF.bRs());
        } else {
            intent.putExtra("data", this.hOF.bRs());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.hOF.bRs());
        setResult(-1, intent);
        bRq();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel hOF;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.hOF = null;
            this.hOF = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.hOH = null;
            if (this.mNetWork != null) {
                this.mNetWork.ji();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.hOH = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.acE().adD().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(d.j.success));
                    PersonChangeActivity.this.bRr();
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
        public String doInBackground(String... strArr) {
            if (this.hOF != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.x(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.hOF.bRs().getSex()));
                this.mNetWork.x("intro", this.hOF.bRs().getIntro());
                this.mNetWork.acj();
                if (this.mNetWork.acE().adD().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.cfe();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.eZs && !TextUtils.isEmpty(this.hOV)) {
            AF(this.hOV);
            this.eZs = false;
            this.hOV = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AG(String str) {
        if (!StringUtils.isNull(str)) {
            this.hON = true;
            this.hOP.setText(str);
            this.hOO.setClickable(false);
            this.hOQ.setVisibility(8);
        }
    }
}
