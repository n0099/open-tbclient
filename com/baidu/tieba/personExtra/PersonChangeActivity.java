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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.MemberPayStatistic;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.SvgManager;
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
    private ImageView bUh;
    private View bUi;
    private com.baidu.tbadk.coreExtra.view.c ctu;
    private View inX;
    private View ios;
    private TextView iot;
    private View iou;
    private View iov;
    private View iow;
    private View iox;
    private com.baidu.tbadk.core.dialog.a ioy;
    private String ioz;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    public final int inV = 90;
    private Boolean inW = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView gJE = null;
    private LinearLayout fkI = null;
    private ScrollView inY = null;
    private TextView inZ = null;
    private LinearLayout ioa = null;
    private TextView iob = null;
    private LinearLayout ioc = null;
    private TextView dFN = null;
    private EditText iod = null;
    private LinearLayout ioe = null;
    private TextView iof = null;
    private TextView iog = null;
    private TextView ioh = null;
    private InputMethodManager mInputManager = null;
    private boolean ioi = false;
    private PersonChangeModel ioj = null;
    protected HeadImageView fqd = null;
    private com.baidu.adp.widget.ImageView.a gCK = null;
    private a iok = null;
    private b iol = null;
    private ProgressBar iom = null;
    private DialogInterface.OnCancelListener flB = null;
    private com.baidu.tbadk.core.dialog.a eTd = null;
    private com.baidu.tbadk.core.dialog.i ion = null;
    private boolean ioo = false;
    private boolean gbD = false;
    private boolean iop = false;
    private int mSex = 0;
    private final int ioq = 500;
    private boolean ior = false;
    private boolean fvl = false;
    private final View.OnClickListener ioA = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.ioj.can().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.ioo = true;
            }
            if (PersonChangeActivity.this.ioo) {
                PersonChangeActivity.this.eTd.akM();
                return;
            }
            if (PersonChangeActivity.this.ioj != null && PersonChangeActivity.this.ioj.can().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.inW.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.ioj.can());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.ioj.can());
                }
                PersonChangeActivity.this.cal();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener fvZ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.fvl = true;
                        PersonChangeActivity.this.ioz = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener ioB = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.ioj != null && PersonChangeActivity.this.ioj.can() != null && personChangeData != null) {
                    PersonChangeActivity.this.ioj.can().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.ioj.can().setMem(personChangeData.getMen());
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
        ad(bundle);
        aDe();
        if (bundle != null) {
            this.inW = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.inW = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.fvZ);
        registerListener(this.ioB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fvZ);
        if (this.iok != null) {
            this.iok.cancel();
        }
        if (this.iol != null) {
            this.iol.cancel();
        }
        if (this.iom != null) {
            this.iom.setVisibility(8);
        }
        if (this.iod != null) {
            this.iod.addTextChangedListener(null);
        }
        if (this.ctu != null) {
            this.ctu.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fqd || view == this.iox) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                cah();
            }
        } else if (view == this.inX) {
            if (!this.gbD && !this.iop) {
                finish();
            }
            if (this.inW.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.gbD) {
                bba();
            } else if (this.iop) {
                cam();
            }
        } else if (view == this.ioa) {
            caj();
        } else if (view == this.ioc) {
            caf();
        } else if (view == this.iod) {
            xt(800);
        } else if (view == this.iov) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (as.isOn()) {
                cad();
            } else {
                int nickNameLeftDays = this.ioj.can().getNickNameLeftDays();
                if (this.ioj.can().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.nn(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
                        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), 24);
                                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_MY_DATA, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                                    PersonChangeActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
                                    TiebaStatic.log(TbadkCoreStatisticKey.MODIFY_NICK_ENTER_OPNEN_MEM_CLICK);
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
                        aVar.b(getPageContext()).akM();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.ios) {
            if (this.ioj == null || this.ioj.can() == null || StringUtils.isNull(this.ioj.can().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void cad() {
        if (this.ioy == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.ioy = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.ioy.aM(inflate);
            this.ioy.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.bQe(), true)));
                    aVar.dismiss();
                }
            });
            this.ioy.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ioy.b(getPageContext());
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), (int) R.color.cp_cont_b);
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), (int) R.color.common_color_10122);
        }
        this.ioy.akM();
    }

    private void i(AccountData accountData) {
        if (this.ctu == null) {
            this.ctu = new com.baidu.tbadk.coreExtra.view.c(this);
            this.ctu.a(new c.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.BE(accountData2.getAccount());
                    }
                }
            });
        }
        this.ctu.asx();
        this.ctu.setAccountData(accountData);
        this.ctu.ast();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.ioi = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.ioi) {
            cae();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cae() {
        if (this.iod.getVisibility() == 0) {
            this.ioe.setVisibility(8);
            this.iod.setVisibility(8);
            String replaceAll = this.iod.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.dFN.setText(replaceAll);
            } else {
                this.dFN.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.ioj.can().getIntro() == null || !this.ioj.can().getIntro().equals(replaceAll)) {
                this.ioo = true;
            }
            this.ioj.can().setIntro(replaceAll);
            this.dFN.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.iod);
        }
    }

    private void caf() {
        if (this.iod.getVisibility() != 0) {
            this.dFN.setVisibility(8);
            this.iod.setText(this.ioj.can().getIntro());
            this.iod.setVisibility(0);
            this.iod.setSelection(this.iod.getText().length());
            this.iod.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.iod);
            xt(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xt(int i) {
        this.inY.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.inY.fullScroll(130);
            }
        }, i);
    }

    private void ad(Bundle bundle) {
        this.flB = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.iol != null) {
                    PersonChangeActivity.this.iol.cancel();
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
        this.ioj = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.fkI);
        SvgManager.amL().a(this.bUh, R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fqd.refresh();
        am.setViewTextColor(this.iot, (int) R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.ioj.can() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.ioj.can()));
        }
    }

    private void aDe() {
        this.iox = findViewById(R.id.photo_pop_icon);
        this.iox.setOnClickListener(this);
        this.fqd = (HeadImageView) findViewById(R.id.photo);
        this.fqd.setOnClickListener(this);
        this.fqd.startLoad(o.nK(this.ioj.can().getPortrait()), 25, false);
        this.fkI = (LinearLayout) findViewById(R.id.parent);
        this.inY = (ScrollView) findViewById(R.id.person_change_scroll);
        this.ioa = (LinearLayout) findViewById(R.id.person_sex);
        this.iob = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bUi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.ioA);
        this.bUh = (ImageView) this.bUi.findViewById(R.id.widget_navi_back_button);
        this.bUh.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.inX = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.gJE = (TextView) this.inX.findViewById(R.id.right_textview);
        this.gJE.setText(getPageContext().getString(R.string.save));
        am.setViewTextColor(this.gJE, R.color.navi_op_text, 1);
        this.inX.setOnClickListener(this);
        this.ioa.setOnClickListener(this);
        this.ioc = (LinearLayout) findViewById(R.id.intro_click);
        this.ioc.setOnClickListener(this);
        this.ioc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.ioi = true;
                    return false;
                }
                return false;
            }
        });
        this.inZ = (TextView) findViewById(R.id.nick_name_show);
        this.inZ.setText(this.ioj.can().getNameShow());
        this.iov = findViewById(R.id.person_nickname);
        this.iov.setOnClickListener(this);
        this.iow = findViewById(R.id.nick_name_more);
        cag();
        this.iot = (TextView) findViewById(R.id.user_name_show);
        this.ios = findViewById(R.id.person_name);
        this.iou = findViewById(R.id.user_name_more_icon);
        this.ios.setOnClickListener(this);
        if (StringUtils.isNull(this.ioj.can().getName())) {
            this.iot.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.ior = false;
            this.ios.setClickable(true);
            this.iou.setVisibility(0);
        } else {
            this.iot.setText(this.ioj.can().getName());
            this.ior = true;
            this.ios.setClickable(false);
            this.iou.setVisibility(8);
        }
        this.dFN = (TextView) findViewById(R.id.intro);
        if (this.ioj.can().getIntro() != null && this.ioj.can().getIntro().length() > 0) {
            this.dFN.setText(this.ioj.can().getIntro());
        } else {
            this.dFN.setText(getPageContext().getString(R.string.add_intro));
        }
        this.iod = (EditText) findViewById(R.id.edit);
        this.iod.setText(this.ioj.can().getIntro());
        this.iod.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.cae();
                }
            }
        });
        this.iod.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.ioi = true;
                    return false;
                }
                return false;
            }
        });
        this.iod.setOnClickListener(this);
        this.iod.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.iod.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.iof.setText(String.valueOf(length));
                PersonChangeActivity.this.ioe.setVisibility(0);
                PersonChangeActivity.this.xt(0);
                PersonChangeActivity.this.cai();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.iod.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.iod.getSelectionStart() - 1 > PersonChangeActivity.this.iod.getSelectionEnd()) {
                        PersonChangeActivity.this.iod.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.iod.getSelectionStart() - 1, PersonChangeActivity.this.iod.getSelectionEnd());
                        PersonChangeActivity.this.iod.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.iod.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.ioj.can().getIntro())) {
                    PersonChangeActivity.this.gbD = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(PersonChangeActivity.this.gJE, R.color.navi_op_text, 1);
                    } else {
                        am.setViewTextColor(PersonChangeActivity.this.gJE, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.ioj.can().getSex() == 1) {
            this.mSex = 1;
            this.iob.setText(R.string.male);
        } else if (this.ioj.can().getSex() == 2) {
            this.mSex = 2;
            this.iob.setText(R.string.female);
        } else {
            this.iob.setText(R.string.change_sex);
        }
        this.ioe = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.iof = (TextView) findViewById(R.id.intro_text_tip_num);
        this.iog = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.ioh = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.iom = (ProgressBar) findViewById(R.id.image_progress);
        this.eTd = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.eTd.nn(getPageContext().getString(R.string.confirm_giveup));
        this.eTd.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.bba();
            }
        });
        this.eTd.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.ioj.can().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.inW.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.ioj.can());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.ioj.can());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.cal();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.eTd.b(getPageContext());
    }

    private void cag() {
        if (as.isOn() || this.ioj.can().getNickNameLeftDays() == 0) {
            this.iow.setVisibility(0);
        } else {
            this.iow.setVisibility(8);
        }
    }

    public void cah() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.hX(R.string.operation);
        bVar.a(strArr, new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // com.baidu.tbadk.core.dialog.b.a
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                if (i == 0) {
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) PersonChangeActivity.this.getPageContext().getPageActivity(), PersonChangeActivity.this.mWriteImagesInfo.toJsonString(), true);
                    albumActivityConfig.setRequestCode(RequestResponseCode.REQUEST_ALBUM_IMAGE);
                    albumActivityConfig.setResourceType(2);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                } else if (i == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST)));
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext());
        bVar.akN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cai() {
        int color;
        if (this.iod.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = am.getColor(R.color.common_color_10159);
        } else {
            color = am.getColor(R.color.common_color_10077);
        }
        xu(color);
    }

    private void xu(int i) {
        this.iof.setTextColor(i);
        this.iog.setTextColor(i);
        this.ioh.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bba() {
        if (this.ioj != null && this.ioj.can() != null) {
            cae();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.ioj.can().setIntro(this.iod.getText().toString().replaceAll("\\s*", ""));
            this.ioj.can().setSex(this.mSex);
            if (this.iol == null) {
                this.iol = new b(this.ioj);
                this.iol.setPriority(3);
                this.iol.execute(new String[0]);
            }
        }
    }

    private void caj() {
        if (this.ion == null) {
            this.ion = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.ion.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.ion != null && PersonChangeActivity.this.ion.isShowing()) {
                        PersonChangeActivity.this.ion.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.iob.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.iob.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.ioj.can().getSex()) {
                            PersonChangeActivity.this.gbD = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                am.setViewTextColor(PersonChangeActivity.this.gJE, R.color.navi_op_text, 1);
                            } else {
                                am.setViewTextColor(PersonChangeActivity.this.gJE, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.ion.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cae();
            this.ioA.onClick(null);
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
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            aD(intent);
                            return;
                        } else {
                            aw(intent);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.ioj.can().setPhotoChanged(true);
                    cak();
                    this.gbD = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.gJE, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.gJE, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.ioj.can().setPhotoChanged(true);
                    if (intent != null) {
                        this.fqd.setImageBitmap(null);
                        this.fqd.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.gbD = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.gJE, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.gJE, R.color.cp_link_tip_a, 1);
                        return;
                    }
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    al.c(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    private void BD(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.iop = true;
            this.ioj.can().setPhotoChanged(true);
            this.ioj.can().setNameShow(str);
            this.ioj.can().setNickNameLeftDays(90);
            this.inZ.setText(str);
            cag();
        }
    }

    private void aw(Intent intent) {
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
            if (this.mWriteImagesInfo.getChosedFiles() != null && this.mWriteImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.mWriteImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.mWriteImagesInfo.clear();
        }
    }

    private void aD(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, RequestResponseCode.REQUEST_CAMERA_VIEW, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void cak() {
        if (this.iok != null) {
            this.iok.cancel();
        }
        this.gCK = null;
        this.iok = new a();
        this.iok.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cal() {
        if (this.ioj != null && this.ioj.can() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.ioj.can()));
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
            PersonChangeActivity.this.iom.setVisibility(0);
            PersonChangeActivity.this.fqd.setImageDrawable(null);
            PersonChangeActivity.this.gCK = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: f */
        public Bitmap doInBackground(Object... objArr) {
            return m.getImage(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.iok = null;
            PersonChangeActivity.this.iom.setVisibility(8);
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
            PersonChangeActivity.this.iok = null;
            PersonChangeActivity.this.iom.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.gCK = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.gCK.drawImageTo(PersonChangeActivity.this.fqd);
                com.baidu.tbadk.imageManager.c.avs().a(PersonChangeActivity.this.ioj.can().getPortrait(), PersonChangeActivity.this.gCK, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cam() {
        Intent intent = new Intent();
        if (this.inW.booleanValue()) {
            intent.putExtra("person_change_data", this.ioj.can());
        } else {
            intent.putExtra("data", this.ioj.can());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.ioj.can());
        setResult(-1, intent);
        cal();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private x bUY = null;
        private PersonChangeModel ioj;

        public b(PersonChangeModel personChangeModel) {
            this.ioj = null;
            this.ioj = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.iol = null;
            if (this.bUY != null) {
                this.bUY.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.iol = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.bUY != null) {
                if (this.bUY.amp().amQ().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.cam();
                } else {
                    PersonChangeActivity.this.showToast(this.bUY.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.flB);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.ioj != null) {
                this.bUY = new x(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.bUY.addPostData("sex", String.valueOf(this.ioj.can().getSex()));
                this.bUY.addPostData("intro", this.ioj.can().getIntro());
                this.bUY.postMultiNetData();
                if (this.bUY.amp().amQ().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.cpf();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fvl && !TextUtils.isEmpty(this.ioz)) {
            BD(this.ioz);
            this.fvl = false;
            this.ioz = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BE(String str) {
        if (!StringUtils.isNull(str)) {
            this.ior = true;
            this.iot.setText(str);
            this.ios.setClickable(false);
            this.iou.setVisibility(8);
        }
    }
}
