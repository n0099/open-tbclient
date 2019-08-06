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
import com.baidu.sapi2.utils.SapiGIDEvent;
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
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.t.as;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private ImageView bCf;
    private View bCg;
    private com.baidu.tbadk.coreExtra.view.c cfg;
    private View ioK;
    private TextView ioL;
    private View ioM;
    private View ioN;
    private View ioO;
    private View ioP;
    private com.baidu.tbadk.core.dialog.a ioQ;
    private String ioR;
    private View ioq;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public final int ioo = 90;
    private Boolean iop = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView gKD = null;
    private LinearLayout fgY = null;
    private ScrollView ior = null;
    private TextView ios = null;
    private LinearLayout iot = null;
    private TextView iou = null;
    private LinearLayout iov = null;
    private TextView dzA = null;
    private EditText mEdit = null;
    private LinearLayout iow = null;
    private TextView iox = null;
    private TextView ioy = null;
    private TextView ioz = null;
    private InputMethodManager mInputManager = null;
    private boolean ioA = false;
    private PersonChangeModel ioB = null;
    protected HeadImageView fpW = null;
    private com.baidu.adp.widget.ImageView.a gDK = null;
    private a ioC = null;
    private b ioD = null;
    private ProgressBar ioE = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a eJF = null;
    private com.baidu.tbadk.core.dialog.i ioF = null;
    private boolean ioG = false;
    private boolean gbf = false;
    private boolean ioH = false;
    private int mSex = 0;
    private final int ioI = 500;
    private boolean ioJ = false;
    private boolean fvc = false;
    private final View.OnClickListener ioS = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.ioB.ccA().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.ioG = true;
            }
            if (PersonChangeActivity.this.ioG) {
                PersonChangeActivity.this.eJF.agK();
                return;
            }
            if (PersonChangeActivity.this.ioB != null && PersonChangeActivity.this.ioB.ccA().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.iop.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.ioB.ccA());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.ioB.ccA());
                }
                PersonChangeActivity.this.ccy();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener fvP = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.fvc = true;
                        PersonChangeActivity.this.ioR = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener ioT = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.ioB != null && PersonChangeActivity.this.ioB.ccA() != null && personChangeData != null) {
                    PersonChangeActivity.this.ioB.ccA().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.ioB.ccA().setMem(personChangeData.getMen());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        ae(bundle);
        aCJ();
        if (bundle != null) {
            this.iop = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.iop = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.fvP);
        registerListener(this.ioT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fvP);
        if (this.ioC != null) {
            this.ioC.cancel();
        }
        if (this.ioD != null) {
            this.ioD.cancel();
        }
        if (this.ioE != null) {
            this.ioE.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        if (this.cfg != null) {
            this.cfg.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fpW || view == this.ioP) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.ajS();
            this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.ad(pageActivity)) {
                ccu();
            }
        } else if (view == this.ioq) {
            if (!this.gbf && !this.ioH) {
                finish();
            }
            if (this.iop.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.gbf) {
                baw();
            } else if (this.ioH) {
                ccz();
            }
        } else if (view == this.iot) {
            ccw();
        } else if (view == this.iov) {
            ccs();
        } else if (view == this.mEdit) {
            yM(800);
        } else if (view == this.ioN) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (as.iN()) {
                ccq();
            } else {
                int nickNameLeftDays = this.ioB.ccA().getNickNameLeftDays();
                if (this.ioB.ccA().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.mO(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
                        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                if (com.baidu.adp.lib.util.j.kc()) {
                                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), 24);
                                    memberPayActivityConfig.setReferPageClickZone("my_data_V8.9", "pop_ups_opende_button_V8.9");
                                    PersonChangeActivity.this.sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                                    TiebaStatic.log("c12409");
                                } else {
                                    PersonChangeActivity.this.showToast(R.string.neterror);
                                }
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(getPageContext()).agK();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.ioK) {
            if (this.ioB == null || this.ioB.ccA() == null || StringUtils.isNull(this.ioB.ccA().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void ccq() {
        if (this.ioQ == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.ioQ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.ioQ.aH(inflate);
            this.ioQ.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.bSu(), true)));
                    aVar.dismiss();
                }
            });
            this.ioQ.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ioQ.b(getPageContext());
            am.j(inflate.findViewById(R.id.nickname_dialog_title), R.color.cp_cont_b);
            am.j(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.ioQ.agK();
    }

    private void i(AccountData accountData) {
        if (this.cfg == null) {
            this.cfg = new com.baidu.tbadk.coreExtra.view.c(this);
            this.cfg.a(new c.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.CM(accountData2.getAccount());
                    }
                }
            });
        }
        this.cfg.aqt();
        this.cfg.setAccountData(accountData);
        this.cfg.aqp();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.ioA = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.ioA) {
            ccr();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccr() {
        if (this.mEdit.getVisibility() == 0) {
            this.iow.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.dzA.setText(replaceAll);
            } else {
                this.dzA.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.ioB.ccA().getIntro() == null || !this.ioB.ccA().getIntro().equals(replaceAll)) {
                this.ioG = true;
            }
            this.ioB.ccA().setIntro(replaceAll);
            this.dzA.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void ccs() {
        if (this.mEdit.getVisibility() != 0) {
            this.dzA.setVisibility(8);
            this.mEdit.setText(this.ioB.ccA().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            yM(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yM(int i) {
        this.ior.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.ior.fullScroll(130);
            }
        }, i);
    }

    private void ae(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.ioD != null) {
                    PersonChangeActivity.this.ioD.cancel();
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
        this.ioB = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.fgY);
        am.a(this.bCf, (int) R.drawable.icon_nav_close, (int) R.drawable.icon_nav_close_w, (int) R.drawable.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fpW.refresh();
        am.j(this.ioL, R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.ioB.ccA() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.ioB.ccA()));
        }
    }

    private void aCJ() {
        this.ioP = findViewById(R.id.photo_pop_icon);
        this.ioP.setOnClickListener(this);
        this.fpW = (HeadImageView) findViewById(R.id.photo);
        this.fpW.setOnClickListener(this);
        this.fpW.startLoad(o.nM(this.ioB.ccA().getPortrait()), 25, false);
        this.fgY = (LinearLayout) findViewById(R.id.parent);
        this.ior = (ScrollView) findViewById(R.id.person_change_scroll);
        this.iot = (LinearLayout) findViewById(R.id.person_sex);
        this.iou = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bCg = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.ioS);
        this.bCf = (ImageView) this.bCg.findViewById(R.id.widget_navi_back_button);
        this.bCf.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.ioq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.gKD = (TextView) this.ioq.findViewById(R.id.right_textview);
        this.gKD.setText(getPageContext().getString(R.string.save));
        am.f(this.gKD, R.color.navi_op_text, 1);
        this.ioq.setOnClickListener(this);
        this.iot.setOnClickListener(this);
        this.iov = (LinearLayout) findViewById(R.id.intro_click);
        this.iov.setOnClickListener(this);
        this.iov.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.ioA = true;
                    return false;
                }
                return false;
            }
        });
        this.ios = (TextView) findViewById(R.id.nick_name_show);
        this.ios.setText(this.ioB.ccA().getNameShow());
        this.ioN = findViewById(R.id.person_nickname);
        this.ioN.setOnClickListener(this);
        this.ioO = findViewById(R.id.nick_name_more);
        cct();
        this.ioL = (TextView) findViewById(R.id.user_name_show);
        this.ioK = findViewById(R.id.person_name);
        this.ioM = findViewById(R.id.user_name_more_icon);
        this.ioK.setOnClickListener(this);
        if (StringUtils.isNull(this.ioB.ccA().getName())) {
            this.ioL.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.ioJ = false;
            this.ioK.setClickable(true);
            this.ioM.setVisibility(0);
        } else {
            this.ioL.setText(this.ioB.ccA().getName());
            this.ioJ = true;
            this.ioK.setClickable(false);
            this.ioM.setVisibility(8);
        }
        this.dzA = (TextView) findViewById(R.id.intro);
        if (this.ioB.ccA().getIntro() != null && this.ioB.ccA().getIntro().length() > 0) {
            this.dzA.setText(this.ioB.ccA().getIntro());
        } else {
            this.dzA.setText(getPageContext().getString(R.string.add_intro));
        }
        this.mEdit = (EditText) findViewById(R.id.edit);
        this.mEdit.setText(this.ioB.ccA().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.ccr();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.ioA = true;
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
                PersonChangeActivity.this.iox.setText(String.valueOf(length));
                PersonChangeActivity.this.iow.setVisibility(0);
                PersonChangeActivity.this.yM(0);
                PersonChangeActivity.this.ccv();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.ioB.ccA().getIntro())) {
                    PersonChangeActivity.this.gbf = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.f(PersonChangeActivity.this.gKD, R.color.navi_op_text, 1);
                    } else {
                        am.f(PersonChangeActivity.this.gKD, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.ioB.ccA().getSex() == 1) {
            this.mSex = 1;
            this.iou.setText(R.string.male);
        } else if (this.ioB.ccA().getSex() == 2) {
            this.mSex = 2;
            this.iou.setText(R.string.female);
        } else {
            this.iou.setText(R.string.change_sex);
        }
        this.iow = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.iox = (TextView) findViewById(R.id.intro_text_tip_num);
        this.ioy = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.ioz = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.ioE = (ProgressBar) findViewById(R.id.image_progress);
        this.eJF = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.eJF.mO(getPageContext().getString(R.string.confirm_giveup));
        this.eJF.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.baw();
            }
        });
        this.eJF.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.ioB.ccA().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.iop.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.ioB.ccA());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.ioB.ccA());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.ccy();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.eJF.b(getPageContext());
    }

    private void cct() {
        if (as.iN() || this.ioB.ccA().getNickNameLeftDays() == 0) {
            this.ioO.setVisibility(0);
        } else {
            this.ioO.setVisibility(8);
        }
    }

    public void ccu() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.hy(R.string.operation);
        bVar.a(strArr, new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                if (i == 0) {
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) PersonChangeActivity.this.getPageContext().getPageActivity(), PersonChangeActivity.this.mWriteImagesInfo.toJsonString(), true);
                    albumActivityConfig.setRequestCode(12002);
                    albumActivityConfig.setResourceType(2);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                } else if (i == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), 12014)));
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext());
        bVar.agN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccv() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = am.getColor(R.color.common_color_10159);
        } else {
            color = am.getColor(R.color.common_color_10077);
        }
        yN(color);
    }

    private void yN(int i) {
        this.iox.setTextColor(i);
        this.ioy.setTextColor(i);
        this.ioz.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baw() {
        if (this.ioB != null && this.ioB.ccA() != null) {
            ccr();
            if (!com.baidu.adp.lib.util.j.kc()) {
                showToast(R.string.neterror);
                return;
            }
            this.ioB.ccA().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.ioB.ccA().setSex(this.mSex);
            if (this.ioD == null) {
                this.ioD = new b(this.ioB);
                this.ioD.setPriority(3);
                this.ioD.execute(new String[0]);
            }
        }
    }

    private void ccw() {
        if (this.ioF == null) {
            this.ioF = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.ioF.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.ioF != null && PersonChangeActivity.this.ioF.isShowing()) {
                        PersonChangeActivity.this.ioF.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.iou.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.iou.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.ioB.ccA().getSex()) {
                            PersonChangeActivity.this.gbf = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                am.f(PersonChangeActivity.this.gKD, R.color.navi_op_text, 1);
                            } else {
                                am.f(PersonChangeActivity.this.gKD, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.ioF.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            ccr();
            this.ioS.onClick(null);
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
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            av(intent);
                            return;
                        } else {
                            ao(intent);
                            return;
                        }
                    }
                    return;
                case 12009:
                case 12010:
                    this.ioB.ccA().setPhotoChanged(true);
                    ccx();
                    this.gbf = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.f(this.gKD, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.f(this.gKD, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case 12014:
                    this.ioB.ccA().setPhotoChanged(true);
                    if (intent != null) {
                        this.fpW.setImageBitmap(null);
                        this.fpW.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.gbf = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.f(this.gKD, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.f(this.gKD, R.color.cp_link_tip_a, 1);
                        return;
                    }
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12010:
                    al.c(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    private void CL(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ioH = true;
            this.ioB.ccA().setPhotoChanged(true);
            this.ioB.ccA().setNameShow(str);
            this.ioB.ccA().setNickNameLeftDays(90);
            this.ios.setText(str);
            cct();
        }
    }

    private void ao(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
            if (this.mWriteImagesInfo.getChosedFiles() != null && this.mWriteImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.mWriteImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.mWriteImagesInfo.clear();
        }
    }

    private void av(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), SapiGIDEvent.TIME_FREQ, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void ccx() {
        if (this.ioC != null) {
            this.ioC.cancel();
        }
        this.gDK = null;
        this.ioC = new a();
        this.ioC.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccy() {
        if (this.ioB != null && this.ioB.ccA() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.ioB.ccA()));
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
            PersonChangeActivity.this.ioE.setVisibility(0);
            PersonChangeActivity.this.fpW.setImageDrawable(null);
            PersonChangeActivity.this.gDK = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public Bitmap doInBackground(Object... objArr) {
            return m.bP(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.ioC = null;
            PersonChangeActivity.this.ioE.setVisibility(8);
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
            PersonChangeActivity.this.ioC = null;
            PersonChangeActivity.this.ioE.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.gDK = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.gDK.a(PersonChangeActivity.this.fpW);
                com.baidu.tbadk.imageManager.c.aty().a(PersonChangeActivity.this.ioB.ccA().getPortrait(), PersonChangeActivity.this.gDK, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccz() {
        Intent intent = new Intent();
        if (this.iop.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.ioB.ccA());
        } else {
            intent.putExtra("data", this.ioB.ccA());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.ioB.ccA());
        setResult(-1, intent);
        ccy();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel ioB;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.ioB = null;
            this.ioB = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.ioD = null;
            if (this.mNetWork != null) {
                this.mNetWork.ik();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.ioD = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.aiG().ajH().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.ccz();
                } else {
                    PersonChangeActivity.this.showToast(this.mNetWork.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.mDialogCancelListener);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.ioB != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.ioB.ccA().getSex()));
                this.mNetWork.o("intro", this.ioB.ccA().getIntro());
                this.mNetWork.ail();
                if (this.mNetWork.aiG().ajH().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.cqA();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fvc && !TextUtils.isEmpty(this.ioR)) {
            CL(this.ioR);
            this.fvc = false;
            this.ioR = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CM(String str) {
        if (!StringUtils.isNull(str)) {
            this.ioJ = true;
            this.ioL.setText(str);
            this.ioK.setClickable(false);
            this.ioM.setVisibility(8);
        }
    }
}
