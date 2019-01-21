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
    private com.baidu.tbadk.coreExtra.view.a aNx;
    private View anr;
    private ImageView ans;
    private View gyK;
    private View gzd;
    private TextView gze;
    private View gzf;
    private View gzg;
    private View gzh;
    private View gzi;
    private com.baidu.tbadk.core.dialog.a gzj;
    private String gzk;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public final int gyI = 90;
    private Boolean gyJ = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView eWr = null;
    private LinearLayout dym = null;
    private ScrollView gyL = null;
    private TextView gyM = null;
    private LinearLayout gyN = null;
    private TextView gyO = null;
    private LinearLayout gyP = null;
    private TextView bWM = null;
    private EditText mEdit = null;
    private LinearLayout gyQ = null;
    private TextView gyR = null;
    private TextView gyS = null;
    private TextView gyT = null;
    private InputMethodManager mInputManager = null;
    private boolean gyU = false;
    private PersonChangeModel gyV = null;
    protected HeadImageView dHo = null;
    private com.baidu.adp.widget.ImageView.a ePB = null;
    private a gyW = null;
    private b gyX = null;
    private ProgressBar gyY = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a dfm = null;
    private com.baidu.tbadk.core.dialog.b gyZ = null;
    private boolean gxt = false;
    private boolean esh = false;
    private boolean gza = false;
    private int mSex = 0;
    private final int gzb = 500;
    private boolean gzc = false;
    private boolean dMi = false;
    private final View.OnClickListener gzl = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.gyV.bqZ().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.gxt = true;
            }
            if (PersonChangeActivity.this.gxt) {
                PersonChangeActivity.this.dfm.BS();
                return;
            }
            if (PersonChangeActivity.this.gyV != null && PersonChangeActivity.this.gyV.bqZ().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.gyJ.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.gyV.bqZ());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.gyV.bqZ());
                }
                PersonChangeActivity.this.bqX();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener dMQ = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.dMi = true;
                        PersonChangeActivity.this.gzk = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener gzm = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.gyV != null && PersonChangeActivity.this.gyV.bqZ() != null && personChangeData != null) {
                    PersonChangeActivity.this.gyV.bqZ().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.gyV.bqZ().setMem(personChangeData.getMen());
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
        Wm();
        if (bundle != null) {
            this.gyJ = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.gyJ = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.dMQ);
        registerListener(this.gzm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dMQ);
        if (this.gyW != null) {
            this.gyW.cancel();
        }
        if (this.gyX != null) {
            this.gyX.cancel();
        }
        if (this.gyY != null) {
            this.gyY.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        if (this.aNx != null) {
            this.aNx.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dHo || view == this.gzi) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.EG();
            this.mPermissionJudgement.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.B(pageActivity)) {
                bqT();
            }
        } else if (view == this.gyK) {
            if (!this.esh && !this.gza) {
                finish();
            }
            if (this.gyJ.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.esh) {
                aru();
            } else if (this.gza) {
                bqY();
            }
        } else if (view == this.gyN) {
            bqV();
        } else if (view == this.gyP) {
            bqR();
        } else if (view == this.mEdit) {
            tu(800);
        } else if (view == this.gzg) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(e.j.support_modify_nickname));
            } else if (an.jJ()) {
                bqP();
            } else {
                int nickNameLeftDays = this.gyV.bqZ().getNickNameLeftDays();
                if (this.gyV.bqZ().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.eK(String.format(getPageContext().getPageActivity().getString(e.j.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).BS();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(e.j.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(e.j.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.gzd) {
            if (this.gyV == null || this.gyV.bqZ() == null || StringUtils.isNull(this.gyV.bqZ().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void bqP() {
        if (this.gzj == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.person_nickname_act_dialog, (ViewGroup) null);
            this.gzj = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.gzj.G(inflate);
            this.gzj.a(e.j.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.bhi(), true)));
                    aVar.dismiss();
                }
            });
            this.gzj.b(e.j.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gzj.b(getPageContext());
            al.h(inflate.findViewById(e.g.nickname_dialog_title), e.d.cp_cont_b);
            al.h(inflate.findViewById(e.g.nickname_dialog_tip), e.d.common_color_10122);
        }
        this.gzj.BS();
    }

    private void i(AccountData accountData) {
        if (this.aNx == null) {
            this.aNx = new com.baidu.tbadk.coreExtra.view.a(this);
            this.aNx.a(new a.InterfaceC0165a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0165a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.uc(accountData2.getAccount());
                    }
                }
            });
        }
        this.aNx.KK();
        this.aNx.setAccountData(accountData);
        this.aNx.KG();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.gyU = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.gyU) {
            bqQ();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqQ() {
        if (this.mEdit.getVisibility() == 0) {
            this.gyQ.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.bWM.setText(replaceAll);
            } else {
                this.bWM.setText(getPageContext().getString(e.j.add_intro));
            }
            if (this.gyV.bqZ().getIntro() == null || !this.gyV.bqZ().getIntro().equals(replaceAll)) {
                this.gxt = true;
            }
            this.gyV.bqZ().setIntro(replaceAll);
            this.bWM.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void bqR() {
        if (this.mEdit.getVisibility() != 0) {
            this.bWM.setVisibility(8);
            this.mEdit.setText(this.gyV.bqZ().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            tu(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tu(int i) {
        this.gyL.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.gyL.fullScroll(130);
            }
        }, i);
    }

    private void J(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.gyX != null) {
                    PersonChangeActivity.this.gyX.cancel();
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
        this.gyV = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.dym);
        al.a(this.ans, e.f.icon_nav_close, e.f.icon_nav_close_w, e.f.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dHo.refresh();
        al.h(this.gze, e.d.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.gyV.bqZ() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.gyV.bqZ()));
        }
    }

    private void Wm() {
        this.gzi = findViewById(e.g.photo_pop_icon);
        this.gzi.setOnClickListener(this);
        this.dHo = (HeadImageView) findViewById(e.g.photo);
        this.dHo.setOnClickListener(this);
        this.dHo.startLoad(o.fH(this.gyV.bqZ().getPortrait()), 25, false);
        this.dym = (LinearLayout) findViewById(e.g.parent);
        this.gyL = (ScrollView) findViewById(e.g.person_change_scroll);
        this.gyN = (LinearLayout) findViewById(e.g.person_sex);
        this.gyO = (TextView) findViewById(e.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.anr = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.widget_nb_item_finish, this.gzl);
        this.ans = (ImageView) this.anr.findViewById(e.g.widget_navi_back_button);
        this.ans.setContentDescription(getPageContext().getPageActivity().getResources().getString(e.j.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.my_info));
        this.gyK = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eWr = (TextView) this.gyK.findViewById(e.g.right_textview);
        this.eWr.setText(getPageContext().getString(e.j.save));
        al.c(this.eWr, e.d.navi_op_text, 1);
        this.gyK.setOnClickListener(this);
        this.gyN.setOnClickListener(this);
        this.gyP = (LinearLayout) findViewById(e.g.intro_click);
        this.gyP.setOnClickListener(this);
        this.gyP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.gyU = true;
                    return false;
                }
                return false;
            }
        });
        this.gyM = (TextView) findViewById(e.g.nick_name_show);
        this.gyM.setText(this.gyV.bqZ().getNameShow());
        this.gzg = findViewById(e.g.person_nickname);
        this.gzg.setOnClickListener(this);
        this.gzh = findViewById(e.g.nick_name_more);
        bqS();
        this.gze = (TextView) findViewById(e.g.user_name_show);
        this.gzd = findViewById(e.g.person_name);
        this.gzf = findViewById(e.g.user_name_more_icon);
        this.gzd.setOnClickListener(this);
        if (StringUtils.isNull(this.gyV.bqZ().getName())) {
            this.gze.setText(getPageContext().getString(e.j.tip_empty_user_name));
            this.gzc = false;
            this.gzd.setClickable(true);
            this.gzf.setVisibility(0);
        } else {
            this.gze.setText(this.gyV.bqZ().getName());
            this.gzc = true;
            this.gzd.setClickable(false);
            this.gzf.setVisibility(8);
        }
        this.bWM = (TextView) findViewById(e.g.intro);
        if (this.gyV.bqZ().getIntro() != null && this.gyV.bqZ().getIntro().length() > 0) {
            this.bWM.setText(this.gyV.bqZ().getIntro());
        } else {
            this.bWM.setText(getPageContext().getString(e.j.add_intro));
        }
        this.mEdit = (EditText) findViewById(e.g.edit);
        this.mEdit.setText(this.gyV.bqZ().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.bqQ();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.gyU = true;
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
                PersonChangeActivity.this.gyR.setText(String.valueOf(length));
                PersonChangeActivity.this.gyQ.setVisibility(0);
                PersonChangeActivity.this.tu(0);
                PersonChangeActivity.this.bqU();
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.gyV.bqZ().getIntro())) {
                    PersonChangeActivity.this.esh = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(PersonChangeActivity.this.eWr, e.d.navi_op_text, 1);
                    } else {
                        al.c(PersonChangeActivity.this.eWr, e.d.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.gyV.bqZ().getSex() == 1) {
            this.mSex = 1;
            this.gyO.setText(e.j.male);
        } else if (this.gyV.bqZ().getSex() == 2) {
            this.mSex = 2;
            this.gyO.setText(e.j.female);
        } else {
            this.gyO.setText(e.j.change_sex);
        }
        this.gyQ = (LinearLayout) findViewById(e.g.intro_text_tip);
        this.gyR = (TextView) findViewById(e.g.intro_text_tip_num);
        this.gyS = (TextView) findViewById(e.g.intro_text_tip_divider);
        this.gyT = (TextView) findViewById(e.g.intro_text_tip_limit);
        this.gyY = (ProgressBar) findViewById(e.g.image_progress);
        this.dfm = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.dfm.eK(getPageContext().getString(e.j.confirm_giveup));
        this.dfm.a(getPageContext().getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.aru();
            }
        });
        this.dfm.b(getPageContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.gyV.bqZ().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.gyJ.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.gyV.bqZ());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.gyV.bqZ());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.bqX();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.dfm.b(getPageContext());
    }

    private void bqS() {
        if (an.jJ() || this.gyV.bqZ().getNickNameLeftDays() == 0) {
            this.gzh.setVisibility(0);
        } else {
            this.gzh.setVisibility(8);
        }
    }

    public void bqT() {
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
        bVar.BV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqU() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = al.getColor(e.d.common_color_10159);
        } else {
            color = al.getColor(e.d.common_color_10077);
        }
        tv(color);
    }

    private void tv(int i) {
        this.gyR.setTextColor(i);
        this.gyS.setTextColor(i);
        this.gyT.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aru() {
        if (this.gyV != null && this.gyV.bqZ() != null) {
            bqQ();
            if (!j.kV()) {
                showToast(e.j.neterror);
                return;
            }
            this.gyV.bqZ().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.gyV.bqZ().setSex(this.mSex);
            if (this.gyX == null) {
                this.gyX = new b(this.gyV);
                this.gyX.setPriority(3);
                this.gyX.execute(new String[0]);
            }
        }
    }

    private void bqV() {
        if (this.gyZ == null) {
            this.gyZ = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            final String string = getPageContext().getString(e.j.male);
            final String string2 = getPageContext().getString(e.j.female);
            this.gyZ.de(e.j.choose_sex);
            this.gyZ.a(new String[]{string, string2}, new b.InterfaceC0158b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        PersonChangeActivity.this.mSex = 1;
                        PersonChangeActivity.this.gyO.setText(string);
                    } else if (i == 1) {
                        PersonChangeActivity.this.mSex = 2;
                        PersonChangeActivity.this.gyO.setText(string2);
                    }
                    if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.gyV.bqZ().getSex()) {
                        PersonChangeActivity.this.esh = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            al.c(PersonChangeActivity.this.eWr, e.d.navi_op_text, 1);
                        } else {
                            al.c(PersonChangeActivity.this.eWr, e.d.cp_link_tip_a, 1);
                        }
                    }
                }
            });
            this.gyZ.d(getPageContext());
        }
        this.gyZ.BV();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bqQ();
            this.gzl.onClick(null);
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
                    this.gyV.bqZ().setPhotoChanged(true);
                    bqW();
                    this.esh = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(this.eWr, e.d.navi_op_text, 1);
                        return;
                    } else {
                        al.c(this.eWr, e.d.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.gyV.bqZ().setPhotoChanged(true);
                    if (intent != null) {
                        this.dHo.setImageBitmap(null);
                        this.dHo.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.esh = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(this.eWr, e.d.navi_op_text, 1);
                        return;
                    } else {
                        al.c(this.eWr, e.d.cp_link_tip_a, 1);
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

    private void ub(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gza = true;
            this.gyV.bqZ().setPhotoChanged(true);
            this.gyV.bqZ().setNameShow(str);
            this.gyV.bqZ().setNickNameLeftDays(90);
            this.gyM.setText(str);
            bqS();
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

    private void bqW() {
        if (this.gyW != null) {
            this.gyW.cancel();
        }
        this.ePB = null;
        this.gyW = new a();
        this.gyW.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqX() {
        if (this.gyV != null && this.gyV.bqZ() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.gyV.bqZ()));
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
            PersonChangeActivity.this.gyY.setVisibility(0);
            PersonChangeActivity.this.dHo.setImageDrawable(null);
            PersonChangeActivity.this.ePB = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: o */
        public Bitmap doInBackground(Object... objArr) {
            return l.ay(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.gyW = null;
            PersonChangeActivity.this.gyY.setVisibility(8);
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
            PersonChangeActivity.this.gyW = null;
            PersonChangeActivity.this.gyY.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.ePB = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.ePB.a(PersonChangeActivity.this.dHo);
                com.baidu.tbadk.imageManager.c.NM().a(PersonChangeActivity.this.gyV.bqZ().getPortrait(), PersonChangeActivity.this.ePB, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqY() {
        Intent intent = new Intent();
        if (this.gyJ.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.gyV.bqZ());
        } else {
            intent.putExtra("data", this.gyV.bqZ());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.gyV.bqZ());
        setResult(-1, intent);
        bqX();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel gyV;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.gyV = null;
            this.gyV = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.gyX = null;
            if (this.mNetWork != null) {
                this.mNetWork.jg();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.gyX = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.Dw().Ev().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(e.j.success));
                    PersonChangeActivity.this.bqY();
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
            if (this.gyV != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.x(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.gyV.bqZ().getSex()));
                this.mNetWork.x("intro", this.gyV.bqZ().getIntro());
                this.mNetWork.Db();
                if (this.mNetWork.Dw().Ev().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.bFG();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dMi && !TextUtils.isEmpty(this.gzk)) {
            ub(this.gzk);
            this.dMi = false;
            this.gzk = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc(String str) {
        if (!StringUtils.isNull(str)) {
            this.gzc = true;
            this.gze.setText(str);
            this.gzd.setClickable(false);
            this.gzf.setVisibility(8);
        }
    }
}
