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
import com.baidu.tbadk.p.am;
import com.baidu.tieba.e;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private com.baidu.tbadk.coreExtra.view.a aDY;
    private View adC;
    private ImageView adD;
    private com.baidu.tbadk.core.util.b.a bqO;
    private View geX;
    private View gfq;
    private TextView gfr;
    private View gfs;
    private View gft;
    private View gfu;
    private View gfv;
    private com.baidu.tbadk.core.dialog.a gfw;
    private String gfx;
    public final int geV = 90;
    private Boolean geW = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView eCV = null;
    private LinearLayout dfe = null;
    private ScrollView geY = null;
    private TextView geZ = null;
    private LinearLayout gfa = null;
    private TextView gfb = null;
    private LinearLayout gfc = null;
    private TextView bIR = null;
    private EditText mEdit = null;
    private LinearLayout gfd = null;
    private TextView gfe = null;
    private TextView gff = null;
    private TextView gfg = null;
    private InputMethodManager mInputManager = null;
    private boolean gfh = false;
    private PersonChangeModel gfi = null;
    protected HeadImageView dnW = null;
    private com.baidu.adp.widget.ImageView.a ewa = null;
    private a gfj = null;
    private b gfk = null;
    private ProgressBar gfl = null;
    private DialogInterface.OnCancelListener mDialogCancelListener = null;
    private com.baidu.tbadk.core.dialog.a cLy = null;
    private com.baidu.tbadk.core.dialog.b gfm = null;
    private boolean gdF = false;
    private boolean dYB = false;
    private boolean gfn = false;
    private int mSex = 0;
    private final int gfo = 500;
    private boolean gfp = false;
    private boolean dsT = false;
    private final View.OnClickListener gfy = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.gfi.blg().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.gdF = true;
            }
            if (PersonChangeActivity.this.gdF) {
                PersonChangeActivity.this.cLy.yl();
                return;
            }
            if (PersonChangeActivity.this.gfi != null && PersonChangeActivity.this.gfi.blg().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.geW.booleanValue()) {
                    intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.gfi.blg());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.gfi.blg());
                }
                PersonChangeActivity.this.ble();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener dtB = new CustomMessageListener(2921033) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.dsT = true;
                        PersonChangeActivity.this.gfx = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener gfz = new CustomMessageListener(2921061) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.gfi != null && PersonChangeActivity.this.gfi.blg() != null && personChangeData != null) {
                    PersonChangeActivity.this.gfi.blg().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.gfi.blg().setMem(personChangeData.getMen());
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
        C(bundle);
        SD();
        if (bundle != null) {
            this.geW = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.geW = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.dtB);
        registerListener(this.gfz);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.dtB);
        if (this.gfj != null) {
            this.gfj.cancel();
        }
        if (this.gfk != null) {
            this.gfk.cancel();
        }
        if (this.gfl != null) {
            this.gfl.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        if (this.aDY != null) {
            this.aDY.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.dnW || view == this.gfv) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.bqO == null) {
                this.bqO = new com.baidu.tbadk.core.util.b.a();
            }
            this.bqO.Bb();
            this.bqO.c(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.bqO.x(pageActivity)) {
                bla();
            }
        } else if (view == this.geX) {
            if (!this.dYB && !this.gfn) {
                finish();
            }
            if (this.geW.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.dYB) {
                alq();
            } else if (this.gfn) {
                blf();
            }
        } else if (view == this.gfa) {
            blc();
        } else if (view == this.gfc) {
            bkY();
        } else if (view == this.mEdit) {
            rT(800);
        } else if (view == this.gft) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(e.j.support_modify_nickname));
            } else if (am.jw()) {
                bkW();
            } else {
                int nickNameLeftDays = this.gfi.blg().getNickNameLeftDays();
                if (this.gfi.blg().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.dT(String.format(getPageContext().getPageActivity().getString(e.j.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
                        aVar.a(e.j.open_now, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                if (j.kK()) {
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
                        aVar.b(getPageContext()).yl();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(e.j.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(e.j.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.gfq) {
            if (this.gfi == null || this.gfi.blg() == null || StringUtils.isNull(this.gfi.blg().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void bkW() {
        if (this.gfw == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(e.h.person_nickname_act_dialog, (ViewGroup) null);
            this.gfw = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.gfw.G(inflate);
            this.gfw.a(e.j.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.bbr(), true)));
                    aVar.dismiss();
                }
            });
            this.gfw.b(e.j.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.gfw.b(getPageContext());
            al.h(inflate.findViewById(e.g.nickname_dialog_title), e.d.cp_cont_b);
            al.h(inflate.findViewById(e.g.nickname_dialog_tip), e.d.common_color_10122);
        }
        this.gfw.yl();
    }

    private void i(AccountData accountData) {
        if (this.aDY == null) {
            this.aDY = new com.baidu.tbadk.coreExtra.view.a(this);
            this.aDY.a(new a.InterfaceC0107a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.coreExtra.view.a.InterfaceC0107a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.sE(accountData2.getAccount());
                    }
                }
            });
        }
        this.aDY.Hd();
        this.aDY.setAccountData(accountData);
        this.aDY.GZ();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.gfh = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.gfh) {
            bkX();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkX() {
        if (this.mEdit.getVisibility() == 0) {
            this.gfd.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.bIR.setText(replaceAll);
            } else {
                this.bIR.setText(getPageContext().getString(e.j.add_intro));
            }
            if (this.gfi.blg().getIntro() == null || !this.gfi.blg().getIntro().equals(replaceAll)) {
                this.gdF = true;
            }
            this.gfi.blg().setIntro(replaceAll);
            this.bIR.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void bkY() {
        if (this.mEdit.getVisibility() != 0) {
            this.bIR.setVisibility(8);
            this.mEdit.setText(this.gfi.blg().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            rT(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rT(int i) {
        this.geY.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.geY.fullScroll(130);
            }
        }, i);
    }

    private void C(Bundle bundle) {
        this.mDialogCancelListener = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.gfk != null) {
                    PersonChangeActivity.this.gfk.cancel();
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
        this.gfi = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.dfe);
        al.a(this.adD, e.f.icon_nav_close, e.f.icon_nav_close_w, e.f.icon_nav_close, i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.dnW.refresh();
        al.h(this.gfr, e.d.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.gfi.blg() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.gfi.blg()));
        }
    }

    private void SD() {
        this.gfv = findViewById(e.g.photo_pop_icon);
        this.gfv.setOnClickListener(this);
        this.dnW = (HeadImageView) findViewById(e.g.photo);
        this.dnW.setOnClickListener(this);
        this.dnW.startLoad(o.eN(this.gfi.blg().getPortrait()), 25, false);
        this.dfe = (LinearLayout) findViewById(e.g.parent);
        this.geY = (ScrollView) findViewById(e.g.person_change_scroll);
        this.gfa = (LinearLayout) findViewById(e.g.person_sex);
        this.gfb = (TextView) findViewById(e.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(e.g.view_navigation_bar);
        this.adC = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, e.h.widget_nb_item_finish, this.gfy);
        this.adD = (ImageView) this.adC.findViewById(e.g.widget_navi_back_button);
        this.adD.setContentDescription(getPageContext().getPageActivity().getResources().getString(e.j.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(e.j.my_info));
        this.geX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eCV = (TextView) this.geX.findViewById(e.g.right_textview);
        this.eCV.setText(getPageContext().getString(e.j.save));
        al.c(this.eCV, e.d.navi_op_text, 1);
        this.geX.setOnClickListener(this);
        this.gfa.setOnClickListener(this);
        this.gfc = (LinearLayout) findViewById(e.g.intro_click);
        this.gfc.setOnClickListener(this);
        this.gfc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.gfh = true;
                    return false;
                }
                return false;
            }
        });
        this.geZ = (TextView) findViewById(e.g.nick_name_show);
        this.geZ.setText(this.gfi.blg().getNameShow());
        this.gft = findViewById(e.g.person_nickname);
        this.gft.setOnClickListener(this);
        this.gfu = findViewById(e.g.nick_name_more);
        bkZ();
        this.gfr = (TextView) findViewById(e.g.user_name_show);
        this.gfq = findViewById(e.g.person_name);
        this.gfs = findViewById(e.g.user_name_more_icon);
        this.gfq.setOnClickListener(this);
        if (StringUtils.isNull(this.gfi.blg().getName())) {
            this.gfr.setText(getPageContext().getString(e.j.tip_empty_user_name));
            this.gfp = false;
            this.gfq.setClickable(true);
            this.gfs.setVisibility(0);
        } else {
            this.gfr.setText(this.gfi.blg().getName());
            this.gfp = true;
            this.gfq.setClickable(false);
            this.gfs.setVisibility(8);
        }
        this.bIR = (TextView) findViewById(e.g.intro);
        if (this.gfi.blg().getIntro() != null && this.gfi.blg().getIntro().length() > 0) {
            this.bIR.setText(this.gfi.blg().getIntro());
        } else {
            this.bIR.setText(getPageContext().getString(e.j.add_intro));
        }
        this.mEdit = (EditText) findViewById(e.g.edit);
        this.mEdit.setText(this.gfi.blg().getIntro());
        this.mEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.bkX();
                }
            }
        });
        this.mEdit.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.gfh = true;
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
                PersonChangeActivity.this.gfe.setText(String.valueOf(length));
                PersonChangeActivity.this.gfd.setVisibility(0);
                PersonChangeActivity.this.rT(0);
                PersonChangeActivity.this.blb();
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
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.gfi.blg().getIntro())) {
                    PersonChangeActivity.this.dYB = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(PersonChangeActivity.this.eCV, e.d.navi_op_text, 1);
                    } else {
                        al.c(PersonChangeActivity.this.eCV, e.d.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.gfi.blg().getSex() == 1) {
            this.mSex = 1;
            this.gfb.setText(e.j.male);
        } else if (this.gfi.blg().getSex() == 2) {
            this.mSex = 2;
            this.gfb.setText(e.j.female);
        } else {
            this.gfb.setText(e.j.change_sex);
        }
        this.gfd = (LinearLayout) findViewById(e.g.intro_text_tip);
        this.gfe = (TextView) findViewById(e.g.intro_text_tip_num);
        this.gff = (TextView) findViewById(e.g.intro_text_tip_divider);
        this.gfg = (TextView) findViewById(e.g.intro_text_tip_limit);
        this.gfl = (ProgressBar) findViewById(e.g.image_progress);
        this.cLy = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cLy.dT(getPageContext().getString(e.j.confirm_giveup));
        this.cLy.a(getPageContext().getString(e.j.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.alq();
            }
        });
        this.cLy.b(getPageContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.gfi.blg().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.geW.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, PersonChangeActivity.this.gfi.blg());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.gfi.blg());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.ble();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.cLy.b(getPageContext());
    }

    private void bkZ() {
        if (am.jw() || this.gfi.blg().getNickNameLeftDays() == 0) {
            this.gfu.setVisibility(0);
        } else {
            this.gfu.setVisibility(8);
        }
    }

    public void bla() {
        String[] strArr = {getPageContext().getString(e.j.change_photo), getPageContext().getString(e.j.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.cs(e.j.operation);
        bVar.a(strArr, new b.InterfaceC0100b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
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
        bVar.yo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blb() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = al.getColor(e.d.common_color_10159);
        } else {
            color = al.getColor(e.d.common_color_10077);
        }
        rU(color);
    }

    private void rU(int i) {
        this.gfe.setTextColor(i);
        this.gff.setTextColor(i);
        this.gfg.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alq() {
        if (this.gfi != null && this.gfi.blg() != null) {
            bkX();
            if (!j.kK()) {
                showToast(e.j.neterror);
                return;
            }
            this.gfi.blg().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.gfi.blg().setSex(this.mSex);
            if (this.gfk == null) {
                this.gfk = new b(this.gfi);
                this.gfk.setPriority(3);
                this.gfk.execute(new String[0]);
            }
        }
    }

    private void blc() {
        if (this.gfm == null) {
            this.gfm = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
            final String string = getPageContext().getString(e.j.male);
            final String string2 = getPageContext().getString(e.j.female);
            this.gfm.cs(e.j.choose_sex);
            this.gfm.a(new String[]{string, string2}, new b.InterfaceC0100b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    if (i == 0) {
                        PersonChangeActivity.this.mSex = 1;
                        PersonChangeActivity.this.gfb.setText(string);
                    } else if (i == 1) {
                        PersonChangeActivity.this.mSex = 2;
                        PersonChangeActivity.this.gfb.setText(string2);
                    }
                    if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.gfi.blg().getSex()) {
                        PersonChangeActivity.this.dYB = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            al.c(PersonChangeActivity.this.eCV, e.d.navi_op_text, 1);
                        } else {
                            al.c(PersonChangeActivity.this.eCV, e.d.cp_link_tip_a, 1);
                        }
                    }
                }
            });
            this.gfm.d(getPageContext());
        }
        this.gfm.yo();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bkX();
            this.gfy.onClick(null);
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
                    this.gfi.blg().setPhotoChanged(true);
                    bld();
                    this.dYB = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(this.eCV, e.d.navi_op_text, 1);
                        return;
                    } else {
                        al.c(this.eCV, e.d.cp_link_tip_a, 1);
                        return;
                    }
                case IEventCenterService.EventId.EventMode.SAPIACCOUNT_GET_USERINFO /* 12014 */:
                    this.gfi.blg().setPhotoChanged(true);
                    if (intent != null) {
                        this.dnW.setImageBitmap(null);
                        this.dnW.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.dYB = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        al.c(this.eCV, e.d.navi_op_text, 1);
                        return;
                    } else {
                        al.c(this.eCV, e.d.cp_link_tip_a, 1);
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

    private void sD(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.gfn = true;
            this.gfi.blg().setPhotoChanged(true);
            this.gfi.blg().setNameShow(str);
            this.gfi.blg().setNickNameLeftDays(90);
            this.geZ.setText(str);
            bkZ();
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

    private void bld() {
        if (this.gfj != null) {
            this.gfj.cancel();
        }
        this.ewa = null;
        this.gfj = new a();
        this.gfj.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ble() {
        if (this.gfi != null && this.gfi.blg() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.gfi.blg()));
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
            PersonChangeActivity.this.gfl.setVisibility(0);
            PersonChangeActivity.this.dnW.setImageDrawable(null);
            PersonChangeActivity.this.ewa = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public Bitmap doInBackground(Object... objArr) {
            return l.ah(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.gfj = null;
            PersonChangeActivity.this.gfl.setVisibility(8);
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
            PersonChangeActivity.this.gfj = null;
            PersonChangeActivity.this.gfl.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.ewa = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.ewa.a(PersonChangeActivity.this.dnW);
                com.baidu.tbadk.imageManager.c.Kg().a(PersonChangeActivity.this.gfi.blg().getPortrait(), PersonChangeActivity.this.ewa, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blf() {
        Intent intent = new Intent();
        if (this.geW.booleanValue()) {
            intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.gfi.blg());
        } else {
            intent.putExtra("data", this.gfi.blg());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.gfi.blg());
        setResult(-1, intent);
        ble();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private PersonChangeModel gfi;
        private x mNetWork = null;

        public b(PersonChangeModel personChangeModel) {
            this.gfi = null;
            this.gfi = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.gfk = null;
            if (this.mNetWork != null) {
                this.mNetWork.iT();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.gfk = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.mNetWork != null) {
                if (this.mNetWork.zR().AQ().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(e.j.success));
                    PersonChangeActivity.this.blf();
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
            if (this.gfi != null) {
                this.mNetWork = new x(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.mNetWork.u(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.gfi.blg().getSex()));
                this.mNetWork.u("intro", this.gfi.blg().getIntro());
                this.mNetWork.zw();
                if (this.mNetWork.zR().AQ().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.bzB();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.dsT && !TextUtils.isEmpty(this.gfx)) {
            sD(this.gfx);
            this.dsT = false;
            this.gfx = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sE(String str) {
        if (!StringUtils.isNull(str)) {
            this.gfp = true;
            this.gfr.setText(str);
            this.gfq.setClickable(false);
            this.gfs.setVisibility(8);
        }
    }
}
