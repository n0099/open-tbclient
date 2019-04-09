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
    private com.baidu.tbadk.coreExtra.view.c bWa;
    private View bue;
    private ImageView bug;
    private View hOP;
    private TextView hOQ;
    private View hOR;
    private View hOS;
    private View hOT;
    private View hOU;
    private com.baidu.tbadk.core.dialog.a hOV;
    private String hOW;
    private View hOv;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public final int hOt = 90;
    private Boolean hOu = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView gml = null;
    private LinearLayout eLp = null;
    private ScrollView hOw = null;
    private TextView hOx = null;
    private LinearLayout hOy = null;
    private TextView hOz = null;
    private LinearLayout hOA = null;
    private TextView dlN = null;
    private EditText mEdit = null;
    private LinearLayout hOB = null;
    private TextView hOC = null;
    private TextView hOD = null;
    private TextView hOE = null;
    private InputMethodManager mInputManager = null;
    private boolean hOF = false;
    private PersonChangeModel hOG = null;
    protected HeadImageView eUo = null;
    private com.baidu.adp.widget.ImageView.a gfs = null;
    private a hOH = null;
    private b hOI = null;
    private ProgressBar hOJ = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a eoU = null;
    private g hOK = null;
    private boolean hOL = false;
    private boolean fEs = false;
    private boolean hOM = false;
    private int mSex = 0;
    private final int hON = 500;
    private boolean hOO = false;
    private boolean eZt = false;
    private final View.OnClickListener hOX = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.hOG.bRs().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.hOL = true;
            }
            if (PersonChangeActivity.this.hOL) {
                PersonChangeActivity.this.eoU.aaW();
                return;
            }
            if (PersonChangeActivity.this.hOG != null && PersonChangeActivity.this.hOG.bRs().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.hOu.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.hOG.bRs());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.hOG.bRs());
                }
                PersonChangeActivity.this.bRq();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener fad = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.eZt = true;
                        PersonChangeActivity.this.hOW = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener hOY = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.hOG != null && PersonChangeActivity.this.hOG.bRs() != null && personChangeData != null) {
                    PersonChangeActivity.this.hOG.bRs().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.hOG.bRs().setMem(personChangeData.getMen());
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
            this.hOu = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.hOu = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.fad);
        registerListener(this.hOY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fad);
        if (this.hOH != null) {
            this.hOH.cancel();
        }
        if (this.hOI != null) {
            this.hOI.cancel();
        }
        if (this.hOJ != null) {
            this.hOJ.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        if (this.bWa != null) {
            this.bWa.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.eUo || view == this.hOU) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.adN();
            this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.Y(pageActivity)) {
                bRm();
            }
        } else if (view == this.hOv) {
            if (!this.fEs && !this.hOM) {
                finish();
            }
            if (this.hOu.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.fEs) {
                aRj();
            } else if (this.hOM) {
                bRr();
            }
        } else if (view == this.hOy) {
            bRo();
        } else if (view == this.hOA) {
            bRk();
        } else if (view == this.mEdit) {
            wZ(800);
        } else if (view == this.hOS) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(d.j.support_modify_nickname));
            } else if (ao.jK()) {
                bRi();
            } else {
                int nickNameLeftDays = this.hOG.bRs().getNickNameLeftDays();
                if (this.hOG.bRs().getMen() <= 0) {
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
        } else if (view == this.hOP) {
            if (this.hOG == null || this.hOG.bRs() == null || StringUtils.isNull(this.hOG.bRs().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void bRi() {
        if (this.hOV == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(d.h.person_nickname_act_dialog, (ViewGroup) null);
            this.hOV = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.hOV.az(inflate);
            this.hOV.a(d.j.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.bHH(), true)));
                    aVar.dismiss();
                }
            });
            this.hOV.b(d.j.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.hOV.b(getPageContext());
            al.j(inflate.findViewById(d.g.nickname_dialog_title), d.C0277d.cp_cont_b);
            al.j(inflate.findViewById(d.g.nickname_dialog_tip), d.C0277d.common_color_10122);
        }
        this.hOV.aaW();
    }

    private void i(AccountData accountData) {
        if (this.bWa == null) {
            this.bWa = new com.baidu.tbadk.coreExtra.view.c(this);
            this.bWa.a(new c.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.AG(accountData2.getAccount());
                    }
                }
            });
        }
        this.bWa.akj();
        this.bWa.setAccountData(accountData);
        this.bWa.akf();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.hOF = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.hOF) {
            bRj();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRj() {
        if (this.mEdit.getVisibility() == 0) {
            this.hOB.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.dlN.setText(replaceAll);
            } else {
                this.dlN.setText(getPageContext().getString(d.j.add_intro));
            }
            if (this.hOG.bRs().getIntro() == null || !this.hOG.bRs().getIntro().equals(replaceAll)) {
                this.hOL = true;
            }
            this.hOG.bRs().setIntro(replaceAll);
            this.dlN.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void bRk() {
        if (this.mEdit.getVisibility() != 0) {
            this.dlN.setVisibility(8);
            this.mEdit.setText(this.hOG.bRs().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            wZ(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wZ(int i) {
        this.hOw.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.hOw.fullScroll(130);
            }
        }, i);
    }

    private void ad(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.hOI != null) {
                    PersonChangeActivity.this.hOI.cancel();
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
        this.hOG = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.eLp);
        al.a(this.bug, d.f.icon_nav_close, d.f.icon_nav_close_w, d.f.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.eUo.refresh();
        al.j(this.hOQ, d.C0277d.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.hOG.bRs() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.hOG.bRs()));
        }
    }

    private void awj() {
        this.hOU = findViewById(d.g.photo_pop_icon);
        this.hOU.setOnClickListener(this);
        this.eUo = (HeadImageView) findViewById(d.g.photo);
        this.eUo.setOnClickListener(this);
        this.eUo.startLoad(o.mt(this.hOG.bRs().getPortrait()), 25, false);
        this.eLp = (LinearLayout) findViewById(d.g.parent);
        this.hOw = (ScrollView) findViewById(d.g.person_change_scroll);
        this.hOy = (LinearLayout) findViewById(d.g.person_sex);
        this.hOz = (TextView) findViewById(d.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.view_navigation_bar);
        this.bue = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, d.h.widget_nb_item_finish, this.hOX);
        this.bug = (ImageView) this.bue.findViewById(d.g.widget_navi_back_button);
        this.bug.setContentDescription(getPageContext().getPageActivity().getResources().getString(d.j.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(d.j.my_info));
        this.hOv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.gml = (TextView) this.hOv.findViewById(d.g.right_textview);
        this.gml.setText(getPageContext().getString(d.j.save));
        al.d(this.gml, d.C0277d.navi_op_text, 1);
        this.hOv.setOnClickListener(this);
        this.hOy.setOnClickListener(this);
        this.hOA = (LinearLayout) findViewById(d.g.intro_click);
        this.hOA.setOnClickListener(this);
        this.hOA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.hOF = true;
                    return false;
                }
                return false;
            }
        });
        this.hOx = (TextView) findViewById(d.g.nick_name_show);
        this.hOx.setText(this.hOG.bRs().getNameShow());
        this.hOS = findViewById(d.g.person_nickname);
        this.hOS.setOnClickListener(this);
        this.hOT = findViewById(d.g.nick_name_more);
        bRl();
        this.hOQ = (TextView) findViewById(d.g.user_name_show);
        this.hOP = findViewById(d.g.person_name);
        this.hOR = findViewById(d.g.user_name_more_icon);
        this.hOP.setOnClickListener(this);
        if (StringUtils.isNull(this.hOG.bRs().getName())) {
            this.hOQ.setText(getPageContext().getString(d.j.tip_empty_user_name));
            this.hOO = false;
            this.hOP.setClickable(true);
            this.hOR.setVisibility(0);
        } else {
            this.hOQ.setText(this.hOG.bRs().getName());
            this.hOO = true;
            this.hOP.setClickable(false);
            this.hOR.setVisibility(8);
        }
        this.dlN = (TextView) findViewById(d.g.intro);
        if (this.hOG.bRs().getIntro() != null && this.hOG.bRs().getIntro().length() > 0) {
            this.dlN.setText(this.hOG.bRs().getIntro());
        } else {
            this.dlN.setText(getPageContext().getString(d.j.add_intro));
        }
        this.mEdit = (EditText) findViewById(d.g.edit);
        this.mEdit.setText(this.hOG.bRs().getIntro());
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
                    PersonChangeActivity.this.hOF = true;
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
                PersonChangeActivity.this.hOC.setText(String.valueOf(length));
                PersonChangeActivity.this.hOB.setVisibility(0);
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.hOG.bRs().getIntro())) {
                    PersonChangeActivity.this.fEs = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.d(PersonChangeActivity.this.gml, d.C0277d.navi_op_text, 1);
                    } else {
                        al.d(PersonChangeActivity.this.gml, d.C0277d.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.hOG.bRs().getSex() == 1) {
            this.mSex = 1;
            this.hOz.setText(d.j.male);
        } else if (this.hOG.bRs().getSex() == 2) {
            this.mSex = 2;
            this.hOz.setText(d.j.female);
        } else {
            this.hOz.setText(d.j.change_sex);
        }
        this.hOB = (LinearLayout) findViewById(d.g.intro_text_tip);
        this.hOC = (TextView) findViewById(d.g.intro_text_tip_num);
        this.hOD = (TextView) findViewById(d.g.intro_text_tip_divider);
        this.hOE = (TextView) findViewById(d.g.intro_text_tip_limit);
        this.hOJ = (ProgressBar) findViewById(d.g.image_progress);
        this.eoU = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.eoU.lz(getPageContext().getString(d.j.confirm_giveup));
        this.eoU.a(getPageContext().getString(d.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.aRj();
            }
        });
        this.eoU.b(getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.hOG.bRs().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.hOu.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.hOG.bRs());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.hOG.bRs());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.bRq();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.eoU.b(getPageContext());
    }

    private void bRl() {
        if (ao.jK() || this.hOG.bRs().getNickNameLeftDays() == 0) {
            this.hOT.setVisibility(0);
        } else {
            this.hOT.setVisibility(8);
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
        this.hOC.setTextColor(i);
        this.hOD.setTextColor(i);
        this.hOE.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRj() {
        if (this.hOG != null && this.hOG.bRs() != null) {
            bRj();
            if (!j.kY()) {
                showToast(d.j.neterror);
                return;
            }
            this.hOG.bRs().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.hOG.bRs().setSex(this.mSex);
            if (this.hOI == null) {
                this.hOI = new b(this.hOG);
                this.hOI.setPriority(3);
                this.hOI.execute(new String[0]);
            }
        }
    }

    private void bRo() {
        if (this.hOK == null) {
            this.hOK = new g(getPageContext());
            final String string = getPageContext().getString(d.j.male);
            final String string2 = getPageContext().getString(d.j.female);
            this.hOK.a(getString(d.j.choose_sex), new String[]{string, string2}, new i.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.i.c
                public void a(i iVar, int i, View view) {
                    if (PersonChangeActivity.this.hOK != null && PersonChangeActivity.this.hOK.isShowing()) {
                        PersonChangeActivity.this.hOK.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.hOz.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.hOz.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.hOG.bRs().getSex()) {
                            PersonChangeActivity.this.fEs = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                al.d(PersonChangeActivity.this.gml, d.C0277d.navi_op_text, 1);
                            } else {
                                al.d(PersonChangeActivity.this.gml, d.C0277d.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.hOK.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bRj();
            this.hOX.onClick(null);
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
                    this.hOG.bRs().setPhotoChanged(true);
                    bRp();
                    this.fEs = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.d(this.gml, d.C0277d.navi_op_text, 1);
                        return;
                    } else {
                        al.d(this.gml, d.C0277d.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.hOG.bRs().setPhotoChanged(true);
                    if (intent != null) {
                        this.eUo.setImageBitmap(null);
                        this.eUo.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.fEs = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.d(this.gml, d.C0277d.navi_op_text, 1);
                        return;
                    } else {
                        al.d(this.gml, d.C0277d.cp_link_tip_a, 1);
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
            this.hOM = true;
            this.hOG.bRs().setPhotoChanged(true);
            this.hOG.bRs().setNameShow(str);
            this.hOG.bRs().setNickNameLeftDays(90);
            this.hOx.setText(str);
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
        if (this.hOH != null) {
            this.hOH.cancel();
        }
        this.gfs = null;
        this.hOH = new a();
        this.hOH.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRq() {
        if (this.hOG != null && this.hOG.bRs() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.hOG.bRs()));
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
            PersonChangeActivity.this.hOJ.setVisibility(0);
            PersonChangeActivity.this.eUo.setImageDrawable(null);
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
            PersonChangeActivity.this.hOH = null;
            PersonChangeActivity.this.hOJ.setVisibility(8);
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
            PersonChangeActivity.this.hOH = null;
            PersonChangeActivity.this.hOJ.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.gfs = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.gfs.a(PersonChangeActivity.this.eUo);
                com.baidu.tbadk.imageManager.c.anm().a(PersonChangeActivity.this.hOG.bRs().getPortrait(), PersonChangeActivity.this.gfs, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRr() {
        Intent intent = new Intent();
        if (this.hOu.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.hOG.bRs());
        } else {
            intent.putExtra("data", this.hOG.bRs());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.hOG.bRs());
        setResult(-1, intent);
        bRq();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel hOG;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.hOG = null;
            this.hOG = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.hOI = null;
            if (this.mNetWork != null) {
                this.mNetWork.ji();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.hOI = null;
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
            if (this.hOG != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.x(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.hOG.bRs().getSex()));
                this.mNetWork.x("intro", this.hOG.bRs().getIntro());
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
        if (this.eZt && !TextUtils.isEmpty(this.hOW)) {
            AF(this.hOW);
            this.eZt = false;
            this.hOW = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AG(String str) {
        if (!StringUtils.isNull(str)) {
            this.hOO = true;
            this.hOQ.setText(str);
            this.hOP.setClickable(false);
            this.hOR.setVisibility(8);
        }
    }
}
