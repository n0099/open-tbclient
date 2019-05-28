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
    private View bBi;
    private ImageView bBj;
    private com.baidu.tbadk.coreExtra.view.c cdV;
    private View igT;
    private View ihn;
    private TextView iho;
    private View ihp;
    private View ihq;
    private View ihr;
    private View ihs;
    private com.baidu.tbadk.core.dialog.a iht;
    private String ihu;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public final int igR = 90;
    private Boolean igS = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView gDz = null;
    private LinearLayout fby = null;
    private ScrollView igU = null;
    private TextView igV = null;
    private LinearLayout igW = null;
    private TextView igX = null;
    private LinearLayout igY = null;
    private TextView dwv = null;
    private EditText mEdit = null;
    private LinearLayout igZ = null;
    private TextView iha = null;
    private TextView ihb = null;
    private TextView ihc = null;
    private InputMethodManager mInputManager = null;
    private boolean ihd = false;
    private PersonChangeModel ihe = null;
    protected HeadImageView fkz = null;
    private com.baidu.adp.widget.ImageView.a gwF = null;
    private a ihf = null;
    private b ihg = null;
    private ProgressBar ihh = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a eEC = null;
    private com.baidu.tbadk.core.dialog.i ihi = null;
    private boolean ihj = false;
    private boolean fVq = false;
    private boolean ihk = false;
    private int mSex = 0;
    private final int ihl = 500;
    private boolean ihm = false;
    private boolean fpF = false;
    private final View.OnClickListener ihv = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.ihe.bZs().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.ihj = true;
            }
            if (PersonChangeActivity.this.ihj) {
                PersonChangeActivity.this.eEC.afG();
                return;
            }
            if (PersonChangeActivity.this.ihe != null && PersonChangeActivity.this.ihe.bZs().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.igS.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.ihe.bZs());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.ihe.bZs());
                }
                PersonChangeActivity.this.bZq();
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
                        PersonChangeActivity.this.ihu = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener ihw = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.ihe != null && PersonChangeActivity.this.ihe.bZs() != null && personChangeData != null) {
                    PersonChangeActivity.this.ihe.bZs().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.ihe.bZs().setMem(personChangeData.getMen());
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
            this.igS = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.igS = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.fqs);
        registerListener(this.ihw);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fqs);
        if (this.ihf != null) {
            this.ihf.cancel();
        }
        if (this.ihg != null) {
            this.ihg.cancel();
        }
        if (this.ihh != null) {
            this.ihh.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        if (this.cdV != null) {
            this.cdV.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fkz || view == this.ihs) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.aiM();
            this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.aa(pageActivity)) {
                bZm();
            }
        } else if (view == this.igT) {
            if (!this.fVq && !this.ihk) {
                finish();
            }
            if (this.igS.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.fVq) {
                aYv();
            } else if (this.ihk) {
                bZr();
            }
        } else if (view == this.igW) {
            bZo();
        } else if (view == this.igY) {
            bZk();
        } else if (view == this.mEdit) {
            yf(800);
        } else if (view == this.ihq) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (as.iE()) {
                bZi();
            } else {
                int nickNameLeftDays = this.ihe.bZs().getNickNameLeftDays();
                if (this.ihe.bZs().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.mE(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
        } else if (view == this.ihn) {
            if (this.ihe == null || this.ihe.bZs() == null || StringUtils.isNull(this.ihe.bZs().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void bZi() {
        if (this.iht == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.iht = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.iht.aF(inflate);
            this.iht.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.bPu(), true)));
                    aVar.dismiss();
                }
            });
            this.iht.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.iht.b(getPageContext());
            al.j(inflate.findViewById(R.id.nickname_dialog_title), R.color.cp_cont_b);
            al.j(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.iht.afG();
    }

    private void i(AccountData accountData) {
        if (this.cdV == null) {
            this.cdV = new com.baidu.tbadk.coreExtra.view.c(this);
            this.cdV.a(new c.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.BW(accountData2.getAccount());
                    }
                }
            });
        }
        this.cdV.apm();
        this.cdV.setAccountData(accountData);
        this.cdV.aph();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.ihd = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.ihd) {
            bZj();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZj() {
        if (this.mEdit.getVisibility() == 0) {
            this.igZ.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.dwv.setText(replaceAll);
            } else {
                this.dwv.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.ihe.bZs().getIntro() == null || !this.ihe.bZs().getIntro().equals(replaceAll)) {
                this.ihj = true;
            }
            this.ihe.bZs().setIntro(replaceAll);
            this.dwv.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void bZk() {
        if (this.mEdit.getVisibility() != 0) {
            this.dwv.setVisibility(8);
            this.mEdit.setText(this.ihe.bZs().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            yf(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yf(int i) {
        this.igU.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.igU.fullScroll(130);
            }
        }, i);
    }

    private void ae(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.ihg != null) {
                    PersonChangeActivity.this.ihg.cancel();
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
        this.ihe = new PersonChangeModel(personChangeData);
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
        al.j(this.iho, R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.ihe.bZs() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.ihe.bZs()));
        }
    }

    private void aBs() {
        this.ihs = findViewById(R.id.photo_pop_icon);
        this.ihs.setOnClickListener(this);
        this.fkz = (HeadImageView) findViewById(R.id.photo);
        this.fkz.setOnClickListener(this);
        this.fkz.startLoad(o.nB(this.ihe.bZs().getPortrait()), 25, false);
        this.fby = (LinearLayout) findViewById(R.id.parent);
        this.igU = (ScrollView) findViewById(R.id.person_change_scroll);
        this.igW = (LinearLayout) findViewById(R.id.person_sex);
        this.igX = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bBi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.ihv);
        this.bBj = (ImageView) this.bBi.findViewById(R.id.widget_navi_back_button);
        this.bBj.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.igT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.gDz = (TextView) this.igT.findViewById(R.id.right_textview);
        this.gDz.setText(getPageContext().getString(R.string.save));
        al.f(this.gDz, R.color.navi_op_text, 1);
        this.igT.setOnClickListener(this);
        this.igW.setOnClickListener(this);
        this.igY = (LinearLayout) findViewById(R.id.intro_click);
        this.igY.setOnClickListener(this);
        this.igY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.ihd = true;
                    return false;
                }
                return false;
            }
        });
        this.igV = (TextView) findViewById(R.id.nick_name_show);
        this.igV.setText(this.ihe.bZs().getNameShow());
        this.ihq = findViewById(R.id.person_nickname);
        this.ihq.setOnClickListener(this);
        this.ihr = findViewById(R.id.nick_name_more);
        bZl();
        this.iho = (TextView) findViewById(R.id.user_name_show);
        this.ihn = findViewById(R.id.person_name);
        this.ihp = findViewById(R.id.user_name_more_icon);
        this.ihn.setOnClickListener(this);
        if (StringUtils.isNull(this.ihe.bZs().getName())) {
            this.iho.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.ihm = false;
            this.ihn.setClickable(true);
            this.ihp.setVisibility(0);
        } else {
            this.iho.setText(this.ihe.bZs().getName());
            this.ihm = true;
            this.ihn.setClickable(false);
            this.ihp.setVisibility(8);
        }
        this.dwv = (TextView) findViewById(R.id.intro);
        if (this.ihe.bZs().getIntro() != null && this.ihe.bZs().getIntro().length() > 0) {
            this.dwv.setText(this.ihe.bZs().getIntro());
        } else {
            this.dwv.setText(getPageContext().getString(R.string.add_intro));
        }
        this.mEdit = (EditText) findViewById(R.id.edit);
        this.mEdit.setText(this.ihe.bZs().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.bZj();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.ihd = true;
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
                PersonChangeActivity.this.iha.setText(String.valueOf(length));
                PersonChangeActivity.this.igZ.setVisibility(0);
                PersonChangeActivity.this.yf(0);
                PersonChangeActivity.this.bZn();
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.ihe.bZs().getIntro())) {
                    PersonChangeActivity.this.fVq = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.f(PersonChangeActivity.this.gDz, R.color.navi_op_text, 1);
                    } else {
                        al.f(PersonChangeActivity.this.gDz, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.ihe.bZs().getSex() == 1) {
            this.mSex = 1;
            this.igX.setText(R.string.male);
        } else if (this.ihe.bZs().getSex() == 2) {
            this.mSex = 2;
            this.igX.setText(R.string.female);
        } else {
            this.igX.setText(R.string.change_sex);
        }
        this.igZ = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.iha = (TextView) findViewById(R.id.intro_text_tip_num);
        this.ihb = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.ihc = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.ihh = (ProgressBar) findViewById(R.id.image_progress);
        this.eEC = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.eEC.mE(getPageContext().getString(R.string.confirm_giveup));
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
                if (PersonChangeActivity.this.ihe.bZs().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.igS.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.ihe.bZs());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.ihe.bZs());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.bZq();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.eEC.b(getPageContext());
    }

    private void bZl() {
        if (as.iE() || this.ihe.bZs().getNickNameLeftDays() == 0) {
            this.ihr.setVisibility(0);
        } else {
            this.ihr.setVisibility(8);
        }
    }

    public void bZm() {
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
    public void bZn() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = al.getColor(R.color.common_color_10159);
        } else {
            color = al.getColor(R.color.common_color_10077);
        }
        yg(color);
    }

    private void yg(int i) {
        this.iha.setTextColor(i);
        this.ihb.setTextColor(i);
        this.ihc.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYv() {
        if (this.ihe != null && this.ihe.bZs() != null) {
            bZj();
            if (!com.baidu.adp.lib.util.j.jS()) {
                showToast(R.string.neterror);
                return;
            }
            this.ihe.bZs().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.ihe.bZs().setSex(this.mSex);
            if (this.ihg == null) {
                this.ihg = new b(this.ihe);
                this.ihg.setPriority(3);
                this.ihg.execute(new String[0]);
            }
        }
    }

    private void bZo() {
        if (this.ihi == null) {
            this.ihi = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.ihi.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.ihi != null && PersonChangeActivity.this.ihi.isShowing()) {
                        PersonChangeActivity.this.ihi.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.igX.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.igX.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.ihe.bZs().getSex()) {
                            PersonChangeActivity.this.fVq = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                al.f(PersonChangeActivity.this.gDz, R.color.navi_op_text, 1);
                            } else {
                                al.f(PersonChangeActivity.this.gDz, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.ihi.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bZj();
            this.ihv.onClick(null);
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
                    this.ihe.bZs().setPhotoChanged(true);
                    bZp();
                    this.fVq = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.f(this.gDz, R.color.navi_op_text, 1);
                        return;
                    } else {
                        al.f(this.gDz, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.ihe.bZs().setPhotoChanged(true);
                    if (intent != null) {
                        this.fkz.setImageBitmap(null);
                        this.fkz.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.fVq = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.f(this.gDz, R.color.navi_op_text, 1);
                        return;
                    } else {
                        al.f(this.gDz, R.color.cp_link_tip_a, 1);
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

    private void BV(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ihk = true;
            this.ihe.bZs().setPhotoChanged(true);
            this.ihe.bZs().setNameShow(str);
            this.ihe.bZs().setNickNameLeftDays(90);
            this.igV.setText(str);
            bZl();
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

    private void bZp() {
        if (this.ihf != null) {
            this.ihf.cancel();
        }
        this.gwF = null;
        this.ihf = new a();
        this.ihf.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZq() {
        if (this.ihe != null && this.ihe.bZs() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.ihe.bZs()));
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
            PersonChangeActivity.this.ihh.setVisibility(0);
            PersonChangeActivity.this.fkz.setImageDrawable(null);
            PersonChangeActivity.this.gwF = null;
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
            PersonChangeActivity.this.ihf = null;
            PersonChangeActivity.this.ihh.setVisibility(8);
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
            PersonChangeActivity.this.ihf = null;
            PersonChangeActivity.this.ihh.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.gwF = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.gwF.a(PersonChangeActivity.this.fkz);
                com.baidu.tbadk.imageManager.c.asp().a(PersonChangeActivity.this.ihe.bZs().getPortrait(), PersonChangeActivity.this.gwF, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZr() {
        Intent intent = new Intent();
        if (this.igS.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.ihe.bZs());
        } else {
            intent.putExtra("data", this.ihe.bZs());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.ihe.bZs());
        setResult(-1, intent);
        bZq();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel ihe;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.ihe = null;
            this.ihe = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.ihg = null;
            if (this.mNetWork != null) {
                this.mNetWork.ia();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.ihg = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.bZr();
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
            if (this.ihe != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.ihe.bZs().getSex()));
                this.mNetWork.o("intro", this.ihe.bZs().getIntro());
                this.mNetWork.ahh();
                if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.cnk();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fpF && !TextUtils.isEmpty(this.ihu)) {
            BV(this.ihu);
            this.fpF = false;
            this.ihu = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BW(String str) {
        if (!StringUtils.isNull(str)) {
            this.ihm = true;
            this.iho.setText(str);
            this.ihn.setClickable(false);
            this.ihp.setVisibility(8);
        }
    }
}
