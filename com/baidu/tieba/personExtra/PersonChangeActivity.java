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
import com.baidu.tbadk.core.dialog.k;
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
import com.baidu.tbadk.t.as;
import com.baidu.tieba.R;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private ImageView bBj;
    private View bBk;
    private com.baidu.tbadk.coreExtra.view.c cdW;
    private View igU;
    private View iho;
    private TextView ihp;
    private View ihq;
    private View ihr;
    private View ihs;
    private View iht;
    private com.baidu.tbadk.core.dialog.a ihu;
    private String ihv;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public final int igS = 90;
    private Boolean igT = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView gDB = null;
    private LinearLayout fby = null;
    private ScrollView igV = null;
    private TextView igW = null;
    private LinearLayout igX = null;
    private TextView igY = null;
    private LinearLayout igZ = null;
    private TextView dwv = null;
    private EditText mEdit = null;
    private LinearLayout iha = null;
    private TextView ihb = null;
    private TextView ihc = null;
    private TextView ihd = null;
    private InputMethodManager mInputManager = null;
    private boolean ihe = false;
    private PersonChangeModel ihf = null;
    protected HeadImageView fkz = null;
    private com.baidu.adp.widget.ImageView.a gwH = null;
    private a ihg = null;
    private b ihh = null;
    private ProgressBar ihi = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a eEC = null;
    private com.baidu.tbadk.core.dialog.i ihj = null;
    private boolean ihk = false;
    private boolean fVs = false;
    private boolean ihl = false;
    private int mSex = 0;
    private final int ihm = 500;
    private boolean ihn = false;
    private boolean fpF = false;
    private final View.OnClickListener ihw = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.ihf.bZt().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.ihk = true;
            }
            if (PersonChangeActivity.this.ihk) {
                PersonChangeActivity.this.eEC.afG();
                return;
            }
            if (PersonChangeActivity.this.ihf != null && PersonChangeActivity.this.ihf.bZt().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.igT.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.ihf.bZt());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.ihf.bZt());
                }
                PersonChangeActivity.this.bZr();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener fqs = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.fpF = true;
                        PersonChangeActivity.this.ihv = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener ihx = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.ihf != null && PersonChangeActivity.this.ihf.bZt() != null && personChangeData != null) {
                    PersonChangeActivity.this.ihf.bZt().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.ihf.bZt().setMem(personChangeData.getMen());
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
        aBs();
        if (bundle != null) {
            this.igT = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.igT = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.fqs);
        registerListener(this.ihx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fqs);
        if (this.ihg != null) {
            this.ihg.cancel();
        }
        if (this.ihh != null) {
            this.ihh.cancel();
        }
        if (this.ihi != null) {
            this.ihi.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        if (this.cdW != null) {
            this.cdW.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fkz || view == this.iht) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.aiM();
            this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.aa(pageActivity)) {
                bZn();
            }
        } else if (view == this.igU) {
            if (!this.fVs && !this.ihl) {
                finish();
            }
            if (this.igT.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.fVs) {
                aYv();
            } else if (this.ihl) {
                bZs();
            }
        } else if (view == this.igX) {
            bZp();
        } else if (view == this.igZ) {
            bZl();
        } else if (view == this.mEdit) {
            yf(800);
        } else if (view == this.ihr) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (as.iE()) {
                bZj();
            } else {
                int nickNameLeftDays = this.ihf.bZt().getNickNameLeftDays();
                if (this.ihf.bZt().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.mD(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
                        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                if (com.baidu.adp.lib.util.j.jS()) {
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
                        aVar.b(getPageContext()).afG();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.iho) {
            if (this.ihf == null || this.ihf.bZt() == null || StringUtils.isNull(this.ihf.bZt().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void bZj() {
        if (this.ihu == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.ihu = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.ihu.aF(inflate);
            this.ihu.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.bPv(), true)));
                    aVar.dismiss();
                }
            });
            this.ihu.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ihu.b(getPageContext());
            al.j(inflate.findViewById(R.id.nickname_dialog_title), R.color.cp_cont_b);
            al.j(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.ihu.afG();
    }

    private void i(AccountData accountData) {
        if (this.cdW == null) {
            this.cdW = new com.baidu.tbadk.coreExtra.view.c(this);
            this.cdW.a(new c.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.BY(accountData2.getAccount());
                    }
                }
            });
        }
        this.cdW.apm();
        this.cdW.setAccountData(accountData);
        this.cdW.aph();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.ihe = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.ihe) {
            bZk();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZk() {
        if (this.mEdit.getVisibility() == 0) {
            this.iha.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.dwv.setText(replaceAll);
            } else {
                this.dwv.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.ihf.bZt().getIntro() == null || !this.ihf.bZt().getIntro().equals(replaceAll)) {
                this.ihk = true;
            }
            this.ihf.bZt().setIntro(replaceAll);
            this.dwv.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void bZl() {
        if (this.mEdit.getVisibility() != 0) {
            this.dwv.setVisibility(8);
            this.mEdit.setText(this.ihf.bZt().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            yf(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yf(int i) {
        this.igV.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.igV.fullScroll(130);
            }
        }, i);
    }

    private void ae(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.ihh != null) {
                    PersonChangeActivity.this.ihh.cancel();
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
        this.ihf = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.fby);
        al.a(this.bBj, (int) R.drawable.icon_nav_close, (int) R.drawable.icon_nav_close_w, (int) R.drawable.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fkz.refresh();
        al.j(this.ihp, R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.ihf.bZt() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.ihf.bZt()));
        }
    }

    private void aBs() {
        this.iht = findViewById(R.id.photo_pop_icon);
        this.iht.setOnClickListener(this);
        this.fkz = (HeadImageView) findViewById(R.id.photo);
        this.fkz.setOnClickListener(this);
        this.fkz.startLoad(o.nA(this.ihf.bZt().getPortrait()), 25, false);
        this.fby = (LinearLayout) findViewById(R.id.parent);
        this.igV = (ScrollView) findViewById(R.id.person_change_scroll);
        this.igX = (LinearLayout) findViewById(R.id.person_sex);
        this.igY = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bBk = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.ihw);
        this.bBj = (ImageView) this.bBk.findViewById(R.id.widget_navi_back_button);
        this.bBj.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.igU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.gDB = (TextView) this.igU.findViewById(R.id.right_textview);
        this.gDB.setText(getPageContext().getString(R.string.save));
        al.f(this.gDB, R.color.navi_op_text, 1);
        this.igU.setOnClickListener(this);
        this.igX.setOnClickListener(this);
        this.igZ = (LinearLayout) findViewById(R.id.intro_click);
        this.igZ.setOnClickListener(this);
        this.igZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.ihe = true;
                    return false;
                }
                return false;
            }
        });
        this.igW = (TextView) findViewById(R.id.nick_name_show);
        this.igW.setText(this.ihf.bZt().getNameShow());
        this.ihr = findViewById(R.id.person_nickname);
        this.ihr.setOnClickListener(this);
        this.ihs = findViewById(R.id.nick_name_more);
        bZm();
        this.ihp = (TextView) findViewById(R.id.user_name_show);
        this.iho = findViewById(R.id.person_name);
        this.ihq = findViewById(R.id.user_name_more_icon);
        this.iho.setOnClickListener(this);
        if (StringUtils.isNull(this.ihf.bZt().getName())) {
            this.ihp.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.ihn = false;
            this.iho.setClickable(true);
            this.ihq.setVisibility(0);
        } else {
            this.ihp.setText(this.ihf.bZt().getName());
            this.ihn = true;
            this.iho.setClickable(false);
            this.ihq.setVisibility(8);
        }
        this.dwv = (TextView) findViewById(R.id.intro);
        if (this.ihf.bZt().getIntro() != null && this.ihf.bZt().getIntro().length() > 0) {
            this.dwv.setText(this.ihf.bZt().getIntro());
        } else {
            this.dwv.setText(getPageContext().getString(R.string.add_intro));
        }
        this.mEdit = (EditText) findViewById(R.id.edit);
        this.mEdit.setText(this.ihf.bZt().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.bZk();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.ihe = true;
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
                PersonChangeActivity.this.ihb.setText(String.valueOf(length));
                PersonChangeActivity.this.iha.setVisibility(0);
                PersonChangeActivity.this.yf(0);
                PersonChangeActivity.this.bZo();
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.ihf.bZt().getIntro())) {
                    PersonChangeActivity.this.fVs = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.f(PersonChangeActivity.this.gDB, R.color.navi_op_text, 1);
                    } else {
                        al.f(PersonChangeActivity.this.gDB, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.ihf.bZt().getSex() == 1) {
            this.mSex = 1;
            this.igY.setText(R.string.male);
        } else if (this.ihf.bZt().getSex() == 2) {
            this.mSex = 2;
            this.igY.setText(R.string.female);
        } else {
            this.igY.setText(R.string.change_sex);
        }
        this.iha = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.ihb = (TextView) findViewById(R.id.intro_text_tip_num);
        this.ihc = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.ihd = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.ihi = (ProgressBar) findViewById(R.id.image_progress);
        this.eEC = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.eEC.mD(getPageContext().getString(R.string.confirm_giveup));
        this.eEC.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.aYv();
            }
        });
        this.eEC.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.ihf.bZt().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.igT.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.ihf.bZt());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.ihf.bZt());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.bZr();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.eEC.b(getPageContext());
    }

    private void bZm() {
        if (as.iE() || this.ihf.bZt().getNickNameLeftDays() == 0) {
            this.ihs.setVisibility(0);
        } else {
            this.ihs.setVisibility(8);
        }
    }

    public void bZn() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.hs(R.string.operation);
        bVar.a(strArr, new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // com.baidu.tbadk.core.dialog.b.a
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
        bVar.afJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZo() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = al.getColor(R.color.common_color_10159);
        } else {
            color = al.getColor(R.color.common_color_10077);
        }
        yg(color);
    }

    private void yg(int i) {
        this.ihb.setTextColor(i);
        this.ihc.setTextColor(i);
        this.ihd.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYv() {
        if (this.ihf != null && this.ihf.bZt() != null) {
            bZk();
            if (!com.baidu.adp.lib.util.j.jS()) {
                showToast(R.string.neterror);
                return;
            }
            this.ihf.bZt().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.ihf.bZt().setSex(this.mSex);
            if (this.ihh == null) {
                this.ihh = new b(this.ihf);
                this.ihh.setPriority(3);
                this.ihh.execute(new String[0]);
            }
        }
    }

    private void bZp() {
        if (this.ihj == null) {
            this.ihj = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.ihj.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.ihj != null && PersonChangeActivity.this.ihj.isShowing()) {
                        PersonChangeActivity.this.ihj.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.igY.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.igY.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.ihf.bZt().getSex()) {
                            PersonChangeActivity.this.fVs = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                al.f(PersonChangeActivity.this.gDB, R.color.navi_op_text, 1);
                            } else {
                                al.f(PersonChangeActivity.this.gDB, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.ihj.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bZk();
            this.ihw.onClick(null);
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
                            at(intent);
                            return;
                        } else {
                            am(intent);
                            return;
                        }
                    }
                    return;
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_DYNAMIC_PWD /* 12009 */:
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT /* 12010 */:
                    this.ihf.bZt().setPhotoChanged(true);
                    bZq();
                    this.fVs = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.f(this.gDB, R.color.navi_op_text, 1);
                        return;
                    } else {
                        al.f(this.gDB, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.ihf.bZt().setPhotoChanged(true);
                    if (intent != null) {
                        this.fkz.setImageBitmap(null);
                        this.fkz.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.fVs = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.f(this.gDB, R.color.navi_op_text, 1);
                        return;
                    } else {
                        al.f(this.gDB, R.color.cp_link_tip_a, 1);
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

    private void BX(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ihl = true;
            this.ihf.bZt().setPhotoChanged(true);
            this.ihf.bZt().setNameShow(str);
            this.ihf.bZt().setNickNameLeftDays(90);
            this.igW.setText(str);
            bZm();
        }
    }

    private void am(Intent intent) {
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

    private void at(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_LOGIN_PROXY_RESULT, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void bZq() {
        if (this.ihg != null) {
            this.ihg.cancel();
        }
        this.gwH = null;
        this.ihg = new a();
        this.ihg.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZr() {
        if (this.ihf != null && this.ihf.bZt() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.ihf.bZt()));
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
            PersonChangeActivity.this.ihi.setVisibility(0);
            PersonChangeActivity.this.fkz.setImageDrawable(null);
            PersonChangeActivity.this.gwH = null;
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
            PersonChangeActivity.this.ihg = null;
            PersonChangeActivity.this.ihi.setVisibility(8);
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
            PersonChangeActivity.this.ihg = null;
            PersonChangeActivity.this.ihi.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.gwH = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.gwH.a(PersonChangeActivity.this.fkz);
                com.baidu.tbadk.imageManager.c.asp().a(PersonChangeActivity.this.ihf.bZt().getPortrait(), PersonChangeActivity.this.gwH, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZs() {
        Intent intent = new Intent();
        if (this.igT.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.ihf.bZt());
        } else {
            intent.putExtra("data", this.ihf.bZt());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.ihf.bZt());
        setResult(-1, intent);
        bZr();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel ihf;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.ihf = null;
            this.ihf = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.ihh = null;
            if (this.mNetWork != null) {
                this.mNetWork.ia();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.ihh = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.bZs();
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
            if (this.ihf != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.ihf.bZt().getSex()));
                this.mNetWork.o("intro", this.ihf.bZt().getIntro());
                this.mNetWork.ahh();
                if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.cnl();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fpF && !TextUtils.isEmpty(this.ihv)) {
            BX(this.ihv);
            this.fpF = false;
            this.ihv = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BY(String str) {
        if (!StringUtils.isNull(str)) {
            this.ihn = true;
            this.ihp.setText(str);
            this.iho.setClickable(false);
            this.ihq.setVisibility(8);
        }
    }
}
