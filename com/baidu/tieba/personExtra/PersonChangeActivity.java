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
    private View igQ;
    private View ihk;
    private TextView ihl;
    private View ihm;
    private View ihn;
    private View iho;
    private View ihp;
    private com.baidu.tbadk.core.dialog.a ihq;
    private String ihr;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public final int igO = 90;
    private Boolean igP = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView gDy = null;
    private LinearLayout fbx = null;
    private ScrollView igR = null;
    private TextView igS = null;
    private LinearLayout igT = null;
    private TextView igU = null;
    private LinearLayout igV = null;
    private TextView dwu = null;
    private EditText mEdit = null;
    private LinearLayout igW = null;
    private TextView igX = null;
    private TextView igY = null;
    private TextView igZ = null;
    private InputMethodManager mInputManager = null;
    private boolean iha = false;
    private PersonChangeModel ihb = null;
    protected HeadImageView fky = null;
    private com.baidu.adp.widget.ImageView.a gwE = null;
    private a ihc = null;
    private b ihd = null;
    private ProgressBar ihe = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a eEB = null;
    private com.baidu.tbadk.core.dialog.i ihf = null;
    private boolean ihg = false;
    private boolean fVp = false;
    private boolean ihh = false;
    private int mSex = 0;
    private final int ihi = 500;
    private boolean ihj = false;
    private boolean fpE = false;
    private final View.OnClickListener ihs = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.ihb.bZp().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.ihg = true;
            }
            if (PersonChangeActivity.this.ihg) {
                PersonChangeActivity.this.eEB.afG();
                return;
            }
            if (PersonChangeActivity.this.ihb != null && PersonChangeActivity.this.ihb.bZp().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.igP.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.ihb.bZp());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.ihb.bZp());
                }
                PersonChangeActivity.this.bZn();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener fqr = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.fpE = true;
                        PersonChangeActivity.this.ihr = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener iht = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.ihb != null && PersonChangeActivity.this.ihb.bZp() != null && personChangeData != null) {
                    PersonChangeActivity.this.ihb.bZp().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.ihb.bZp().setMem(personChangeData.getMen());
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
        aBp();
        if (bundle != null) {
            this.igP = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.igP = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.fqr);
        registerListener(this.iht);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fqr);
        if (this.ihc != null) {
            this.ihc.cancel();
        }
        if (this.ihd != null) {
            this.ihd.cancel();
        }
        if (this.ihe != null) {
            this.ihe.setVisibility(8);
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
        if (view == this.fky || view == this.ihp) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.aiM();
            this.mPermissionJudgement.e(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.aa(pageActivity)) {
                bZj();
            }
        } else if (view == this.igQ) {
            if (!this.fVp && !this.ihh) {
                finish();
            }
            if (this.igP.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.fVp) {
                aYs();
            } else if (this.ihh) {
                bZo();
            }
        } else if (view == this.igT) {
            bZl();
        } else if (view == this.igV) {
            bZh();
        } else if (view == this.mEdit) {
            yf(800);
        } else if (view == this.ihn) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (as.iE()) {
                bZf();
            } else {
                int nickNameLeftDays = this.ihb.bZp().getNickNameLeftDays();
                if (this.ihb.bZp().getMen() <= 0) {
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
        } else if (view == this.ihk) {
            if (this.ihb == null || this.ihb.bZp() == null || StringUtils.isNull(this.ihb.bZp().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void bZf() {
        if (this.ihq == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.ihq = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.ihq.aF(inflate);
            this.ihq.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.bPr(), true)));
                    aVar.dismiss();
                }
            });
            this.ihq.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ihq.b(getPageContext());
            al.j(inflate.findViewById(R.id.nickname_dialog_title), R.color.cp_cont_b);
            al.j(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.ihq.afG();
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
        this.iha = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.iha) {
            bZg();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZg() {
        if (this.mEdit.getVisibility() == 0) {
            this.igW.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.dwu.setText(replaceAll);
            } else {
                this.dwu.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.ihb.bZp().getIntro() == null || !this.ihb.bZp().getIntro().equals(replaceAll)) {
                this.ihg = true;
            }
            this.ihb.bZp().setIntro(replaceAll);
            this.dwu.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void bZh() {
        if (this.mEdit.getVisibility() != 0) {
            this.dwu.setVisibility(8);
            this.mEdit.setText(this.ihb.bZp().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            yf(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yf(int i) {
        this.igR.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.igR.fullScroll(130);
            }
        }, i);
    }

    private void ae(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.ihd != null) {
                    PersonChangeActivity.this.ihd.cancel();
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
        this.ihb = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.fbx);
        al.a(this.bBj, (int) R.drawable.icon_nav_close, (int) R.drawable.icon_nav_close_w, (int) R.drawable.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fky.refresh();
        al.j(this.ihl, R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.ihb.bZp() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.ihb.bZp()));
        }
    }

    private void aBp() {
        this.ihp = findViewById(R.id.photo_pop_icon);
        this.ihp.setOnClickListener(this);
        this.fky = (HeadImageView) findViewById(R.id.photo);
        this.fky.setOnClickListener(this);
        this.fky.startLoad(o.nB(this.ihb.bZp().getPortrait()), 25, false);
        this.fbx = (LinearLayout) findViewById(R.id.parent);
        this.igR = (ScrollView) findViewById(R.id.person_change_scroll);
        this.igT = (LinearLayout) findViewById(R.id.person_sex);
        this.igU = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bBi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.ihs);
        this.bBj = (ImageView) this.bBi.findViewById(R.id.widget_navi_back_button);
        this.bBj.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.igQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.gDy = (TextView) this.igQ.findViewById(R.id.right_textview);
        this.gDy.setText(getPageContext().getString(R.string.save));
        al.f(this.gDy, R.color.navi_op_text, 1);
        this.igQ.setOnClickListener(this);
        this.igT.setOnClickListener(this);
        this.igV = (LinearLayout) findViewById(R.id.intro_click);
        this.igV.setOnClickListener(this);
        this.igV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.iha = true;
                    return false;
                }
                return false;
            }
        });
        this.igS = (TextView) findViewById(R.id.nick_name_show);
        this.igS.setText(this.ihb.bZp().getNameShow());
        this.ihn = findViewById(R.id.person_nickname);
        this.ihn.setOnClickListener(this);
        this.iho = findViewById(R.id.nick_name_more);
        bZi();
        this.ihl = (TextView) findViewById(R.id.user_name_show);
        this.ihk = findViewById(R.id.person_name);
        this.ihm = findViewById(R.id.user_name_more_icon);
        this.ihk.setOnClickListener(this);
        if (StringUtils.isNull(this.ihb.bZp().getName())) {
            this.ihl.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.ihj = false;
            this.ihk.setClickable(true);
            this.ihm.setVisibility(0);
        } else {
            this.ihl.setText(this.ihb.bZp().getName());
            this.ihj = true;
            this.ihk.setClickable(false);
            this.ihm.setVisibility(8);
        }
        this.dwu = (TextView) findViewById(R.id.intro);
        if (this.ihb.bZp().getIntro() != null && this.ihb.bZp().getIntro().length() > 0) {
            this.dwu.setText(this.ihb.bZp().getIntro());
        } else {
            this.dwu.setText(getPageContext().getString(R.string.add_intro));
        }
        this.mEdit = (EditText) findViewById(R.id.edit);
        this.mEdit.setText(this.ihb.bZp().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.bZg();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.iha = true;
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
                PersonChangeActivity.this.igX.setText(String.valueOf(length));
                PersonChangeActivity.this.igW.setVisibility(0);
                PersonChangeActivity.this.yf(0);
                PersonChangeActivity.this.bZk();
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.ihb.bZp().getIntro())) {
                    PersonChangeActivity.this.fVp = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.f(PersonChangeActivity.this.gDy, R.color.navi_op_text, 1);
                    } else {
                        al.f(PersonChangeActivity.this.gDy, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.ihb.bZp().getSex() == 1) {
            this.mSex = 1;
            this.igU.setText(R.string.male);
        } else if (this.ihb.bZp().getSex() == 2) {
            this.mSex = 2;
            this.igU.setText(R.string.female);
        } else {
            this.igU.setText(R.string.change_sex);
        }
        this.igW = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.igX = (TextView) findViewById(R.id.intro_text_tip_num);
        this.igY = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.igZ = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.ihe = (ProgressBar) findViewById(R.id.image_progress);
        this.eEB = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.eEB.mE(getPageContext().getString(R.string.confirm_giveup));
        this.eEB.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.aYs();
            }
        });
        this.eEB.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.ihb.bZp().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.igP.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.ihb.bZp());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.ihb.bZp());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.bZn();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.eEB.b(getPageContext());
    }

    private void bZi() {
        if (as.iE() || this.ihb.bZp().getNickNameLeftDays() == 0) {
            this.iho.setVisibility(0);
        } else {
            this.iho.setVisibility(8);
        }
    }

    public void bZj() {
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
    public void bZk() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = al.getColor(R.color.common_color_10159);
        } else {
            color = al.getColor(R.color.common_color_10077);
        }
        yg(color);
    }

    private void yg(int i) {
        this.igX.setTextColor(i);
        this.igY.setTextColor(i);
        this.igZ.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYs() {
        if (this.ihb != null && this.ihb.bZp() != null) {
            bZg();
            if (!com.baidu.adp.lib.util.j.jS()) {
                showToast(R.string.neterror);
                return;
            }
            this.ihb.bZp().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.ihb.bZp().setSex(this.mSex);
            if (this.ihd == null) {
                this.ihd = new b(this.ihb);
                this.ihd.setPriority(3);
                this.ihd.execute(new String[0]);
            }
        }
    }

    private void bZl() {
        if (this.ihf == null) {
            this.ihf = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.ihf.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.ihf != null && PersonChangeActivity.this.ihf.isShowing()) {
                        PersonChangeActivity.this.ihf.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.igU.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.igU.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.ihb.bZp().getSex()) {
                            PersonChangeActivity.this.fVp = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                al.f(PersonChangeActivity.this.gDy, R.color.navi_op_text, 1);
                            } else {
                                al.f(PersonChangeActivity.this.gDy, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.ihf.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bZg();
            this.ihs.onClick(null);
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
                    this.ihb.bZp().setPhotoChanged(true);
                    bZm();
                    this.fVp = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.f(this.gDy, R.color.navi_op_text, 1);
                        return;
                    } else {
                        al.f(this.gDy, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.ihb.bZp().setPhotoChanged(true);
                    if (intent != null) {
                        this.fky.setImageBitmap(null);
                        this.fky.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.fVp = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.f(this.gDy, R.color.navi_op_text, 1);
                        return;
                    } else {
                        al.f(this.gDy, R.color.cp_link_tip_a, 1);
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
            this.ihh = true;
            this.ihb.bZp().setPhotoChanged(true);
            this.ihb.bZp().setNameShow(str);
            this.ihb.bZp().setNickNameLeftDays(90);
            this.igS.setText(str);
            bZi();
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

    private void bZm() {
        if (this.ihc != null) {
            this.ihc.cancel();
        }
        this.gwE = null;
        this.ihc = new a();
        this.ihc.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZn() {
        if (this.ihb != null && this.ihb.bZp() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.ihb.bZp()));
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
            PersonChangeActivity.this.ihe.setVisibility(0);
            PersonChangeActivity.this.fky.setImageDrawable(null);
            PersonChangeActivity.this.gwE = null;
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
            PersonChangeActivity.this.ihc = null;
            PersonChangeActivity.this.ihe.setVisibility(8);
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
            PersonChangeActivity.this.ihc = null;
            PersonChangeActivity.this.ihe.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.gwE = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.gwE.a(PersonChangeActivity.this.fky);
                com.baidu.tbadk.imageManager.c.asp().a(PersonChangeActivity.this.ihb.bZp().getPortrait(), PersonChangeActivity.this.gwE, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZo() {
        Intent intent = new Intent();
        if (this.igP.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.ihb.bZp());
        } else {
            intent.putExtra("data", this.ihb.bZp());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.ihb.bZp());
        setResult(-1, intent);
        bZn();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel ihb;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.ihb = null;
            this.ihb = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.ihd = null;
            if (this.mNetWork != null) {
                this.mNetWork.ia();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.ihd = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.bZo();
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
            if (this.ihb != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.ihb.bZp().getSex()));
                this.mNetWork.o("intro", this.ihb.bZp().getIntro());
                this.mNetWork.ahh();
                if (this.mNetWork.ahC().aiC().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.cni();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fpE && !TextUtils.isEmpty(this.ihr)) {
            BV(this.ihr);
            this.fpE = false;
            this.ihr = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BW(String str) {
        if (!StringUtils.isNull(str)) {
            this.ihj = true;
            this.ihl.setText(str);
            this.ihk.setClickable(false);
            this.ihm.setVisibility(8);
        }
    }
}
