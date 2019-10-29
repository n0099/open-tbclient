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
    private ImageView bUY;
    private View bUZ;
    private com.baidu.tbadk.coreExtra.view.c cul;
    private View ioO;
    private View ipj;
    private TextView ipk;
    private View ipl;
    private View ipm;
    private View ipn;
    private View ipo;
    private com.baidu.tbadk.core.dialog.a ipp;
    private String ipq;
    private com.baidu.tbadk.core.util.c.a mPermissionJudgement;
    public final int ioM = 90;
    private Boolean ioN = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView gKv = null;
    private LinearLayout flz = null;
    private ScrollView ioP = null;
    private TextView ioQ = null;
    private LinearLayout ioR = null;
    private TextView ioS = null;
    private LinearLayout ioT = null;
    private TextView dGE = null;
    private EditText ioU = null;
    private LinearLayout ioV = null;
    private TextView ioW = null;
    private TextView ioX = null;
    private TextView ioY = null;
    private InputMethodManager mInputManager = null;
    private boolean ioZ = false;
    private PersonChangeModel ipa = null;
    protected HeadImageView fqU = null;
    private com.baidu.adp.widget.ImageView.a gDB = null;
    private a ipb = null;
    private b ipc = null;
    private ProgressBar ipd = null;
    private DialogInterface.OnCancelListener fms = null;
    private com.baidu.tbadk.core.dialog.a eTU = null;
    private com.baidu.tbadk.core.dialog.i ipe = null;
    private boolean ipf = false;
    private boolean gcu = false;
    private boolean ipg = false;
    private int mSex = 0;
    private final int iph = 500;
    private boolean ipi = false;
    private boolean fwc = false;
    private final View.OnClickListener ipr = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.ipa.cap().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.ipf = true;
            }
            if (PersonChangeActivity.this.ipf) {
                PersonChangeActivity.this.eTU.akO();
                return;
            }
            if (PersonChangeActivity.this.ipa != null && PersonChangeActivity.this.ipa.cap().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.ioN.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.ipa.cap());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.ipa.cap());
                }
                PersonChangeActivity.this.can();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener fwQ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.fwc = true;
                        PersonChangeActivity.this.ipq = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener ips = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.ipa != null && PersonChangeActivity.this.ipa.cap() != null && personChangeData != null) {
                    PersonChangeActivity.this.ipa.cap().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.ipa.cap().setMem(personChangeData.getMen());
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
        aDg();
        if (bundle != null) {
            this.ioN = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.ioN = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.fwQ);
        registerListener(this.ips);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fwQ);
        if (this.ipb != null) {
            this.ipb.cancel();
        }
        if (this.ipc != null) {
            this.ipc.cancel();
        }
        if (this.ipd != null) {
            this.ipd.setVisibility(8);
        }
        if (this.ioU != null) {
            this.ioU.addTextChangedListener(null);
        }
        if (this.cul != null) {
            this.cul.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.fqU || view == this.ipo) {
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.c.a();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                caj();
            }
        } else if (view == this.ioO) {
            if (!this.gcu && !this.ipg) {
                finish();
            }
            if (this.ioN.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.gcu) {
                bbc();
            } else if (this.ipg) {
                cao();
            }
        } else if (view == this.ioR) {
            cal();
        } else if (view == this.ioT) {
            cah();
        } else if (view == this.ioU) {
            xu(800);
        } else if (view == this.ipm) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (as.isOn()) {
                caf();
            } else {
                int nickNameLeftDays = this.ipa.cap().getNickNameLeftDays();
                if (this.ipa.cap().getMen() <= 0) {
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
                        aVar.b(getPageContext()).akO();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.ipj) {
            if (this.ipa == null || this.ipa.cap() == null || StringUtils.isNull(this.ipa.cap().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        }
    }

    private void caf() {
        if (this.ipp == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.ipp = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.ipp.aM(inflate);
            this.ipp.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.bQg(), true)));
                    aVar.dismiss();
                }
            });
            this.ipp.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.ipp.b(getPageContext());
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), (int) R.color.cp_cont_b);
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), (int) R.color.common_color_10122);
        }
        this.ipp.akO();
    }

    private void i(AccountData accountData) {
        if (this.cul == null) {
            this.cul = new com.baidu.tbadk.coreExtra.view.c(this);
            this.cul.a(new c.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.BE(accountData2.getAccount());
                    }
                }
            });
        }
        this.cul.asz();
        this.cul.setAccountData(accountData);
        this.cul.asv();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.ioZ = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.ioZ) {
            cag();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cag() {
        if (this.ioU.getVisibility() == 0) {
            this.ioV.setVisibility(8);
            this.ioU.setVisibility(8);
            String replaceAll = this.ioU.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.dGE.setText(replaceAll);
            } else {
                this.dGE.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.ipa.cap().getIntro() == null || !this.ipa.cap().getIntro().equals(replaceAll)) {
                this.ipf = true;
            }
            this.ipa.cap().setIntro(replaceAll);
            this.dGE.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.ioU);
        }
    }

    private void cah() {
        if (this.ioU.getVisibility() != 0) {
            this.dGE.setVisibility(8);
            this.ioU.setText(this.ipa.cap().getIntro());
            this.ioU.setVisibility(0);
            this.ioU.setSelection(this.ioU.getText().length());
            this.ioU.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.ioU);
            xu(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xu(int i) {
        this.ioP.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.ioP.fullScroll(130);
            }
        }, i);
    }

    private void ad(Bundle bundle) {
        this.fms = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.ipc != null) {
                    PersonChangeActivity.this.ipc.cancel();
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
        this.ipa = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.flz);
        SvgManager.amN().a(this.bUY, R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.fqU.refresh();
        am.setViewTextColor(this.ipk, (int) R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.ipa.cap() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.ipa.cap()));
        }
    }

    private void aDg() {
        this.ipo = findViewById(R.id.photo_pop_icon);
        this.ipo.setOnClickListener(this);
        this.fqU = (HeadImageView) findViewById(R.id.photo);
        this.fqU.setOnClickListener(this);
        this.fqU.startLoad(o.nK(this.ipa.cap().getPortrait()), 25, false);
        this.flz = (LinearLayout) findViewById(R.id.parent);
        this.ioP = (ScrollView) findViewById(R.id.person_change_scroll);
        this.ioR = (LinearLayout) findViewById(R.id.person_sex);
        this.ioS = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.bUZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.ipr);
        this.bUY = (ImageView) this.bUZ.findViewById(R.id.widget_navi_back_button);
        this.bUY.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.ioO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.gKv = (TextView) this.ioO.findViewById(R.id.right_textview);
        this.gKv.setText(getPageContext().getString(R.string.save));
        am.setViewTextColor(this.gKv, R.color.navi_op_text, 1);
        this.ioO.setOnClickListener(this);
        this.ioR.setOnClickListener(this);
        this.ioT = (LinearLayout) findViewById(R.id.intro_click);
        this.ioT.setOnClickListener(this);
        this.ioT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.ioZ = true;
                    return false;
                }
                return false;
            }
        });
        this.ioQ = (TextView) findViewById(R.id.nick_name_show);
        this.ioQ.setText(this.ipa.cap().getNameShow());
        this.ipm = findViewById(R.id.person_nickname);
        this.ipm.setOnClickListener(this);
        this.ipn = findViewById(R.id.nick_name_more);
        cai();
        this.ipk = (TextView) findViewById(R.id.user_name_show);
        this.ipj = findViewById(R.id.person_name);
        this.ipl = findViewById(R.id.user_name_more_icon);
        this.ipj.setOnClickListener(this);
        if (StringUtils.isNull(this.ipa.cap().getName())) {
            this.ipk.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.ipi = false;
            this.ipj.setClickable(true);
            this.ipl.setVisibility(0);
        } else {
            this.ipk.setText(this.ipa.cap().getName());
            this.ipi = true;
            this.ipj.setClickable(false);
            this.ipl.setVisibility(8);
        }
        this.dGE = (TextView) findViewById(R.id.intro);
        if (this.ipa.cap().getIntro() != null && this.ipa.cap().getIntro().length() > 0) {
            this.dGE.setText(this.ipa.cap().getIntro());
        } else {
            this.dGE.setText(getPageContext().getString(R.string.add_intro));
        }
        this.ioU = (EditText) findViewById(R.id.edit);
        this.ioU.setText(this.ipa.cap().getIntro());
        this.ioU.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.cag();
                }
            }
        });
        this.ioU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.ioZ = true;
                    return false;
                }
                return false;
            }
        });
        this.ioU.setOnClickListener(this);
        this.ioU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.ioU.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.ioW.setText(String.valueOf(length));
                PersonChangeActivity.this.ioV.setVisibility(0);
                PersonChangeActivity.this.xu(0);
                PersonChangeActivity.this.cak();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.ioU.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.ioU.getSelectionStart() - 1 > PersonChangeActivity.this.ioU.getSelectionEnd()) {
                        PersonChangeActivity.this.ioU.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.ioU.getSelectionStart() - 1, PersonChangeActivity.this.ioU.getSelectionEnd());
                        PersonChangeActivity.this.ioU.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.ioU.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.ipa.cap().getIntro())) {
                    PersonChangeActivity.this.gcu = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(PersonChangeActivity.this.gKv, R.color.navi_op_text, 1);
                    } else {
                        am.setViewTextColor(PersonChangeActivity.this.gKv, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.ipa.cap().getSex() == 1) {
            this.mSex = 1;
            this.ioS.setText(R.string.male);
        } else if (this.ipa.cap().getSex() == 2) {
            this.mSex = 2;
            this.ioS.setText(R.string.female);
        } else {
            this.ioS.setText(R.string.change_sex);
        }
        this.ioV = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.ioW = (TextView) findViewById(R.id.intro_text_tip_num);
        this.ioX = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.ioY = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.ipd = (ProgressBar) findViewById(R.id.image_progress);
        this.eTU = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.eTU.nn(getPageContext().getString(R.string.confirm_giveup));
        this.eTU.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.bbc();
            }
        });
        this.eTU.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.ipa.cap().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.ioN.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.ipa.cap());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.ipa.cap());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.can();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.eTU.b(getPageContext());
    }

    private void cai() {
        if (as.isOn() || this.ipa.cap().getNickNameLeftDays() == 0) {
            this.ipn.setVisibility(0);
        } else {
            this.ipn.setVisibility(8);
        }
    }

    public void caj() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.hY(R.string.operation);
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
        bVar.akP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cak() {
        int color;
        if (this.ioU.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = am.getColor(R.color.common_color_10159);
        } else {
            color = am.getColor(R.color.common_color_10077);
        }
        xv(color);
    }

    private void xv(int i) {
        this.ioW.setTextColor(i);
        this.ioX.setTextColor(i);
        this.ioY.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbc() {
        if (this.ipa != null && this.ipa.cap() != null) {
            cag();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.ipa.cap().setIntro(this.ioU.getText().toString().replaceAll("\\s*", ""));
            this.ipa.cap().setSex(this.mSex);
            if (this.ipc == null) {
                this.ipc = new b(this.ipa);
                this.ipc.setPriority(3);
                this.ipc.execute(new String[0]);
            }
        }
    }

    private void cal() {
        if (this.ipe == null) {
            this.ipe = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.ipe.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.ipe != null && PersonChangeActivity.this.ipe.isShowing()) {
                        PersonChangeActivity.this.ipe.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.ioS.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.ioS.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.ipa.cap().getSex()) {
                            PersonChangeActivity.this.gcu = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                am.setViewTextColor(PersonChangeActivity.this.gKv, R.color.navi_op_text, 1);
                            } else {
                                am.setViewTextColor(PersonChangeActivity.this.gKv, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.ipe.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cag();
            this.ipr.onClick(null);
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
                    this.ipa.cap().setPhotoChanged(true);
                    cam();
                    this.gcu = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.gKv, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.gKv, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.ipa.cap().setPhotoChanged(true);
                    if (intent != null) {
                        this.fqU.setImageBitmap(null);
                        this.fqU.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.gcu = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.gKv, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.gKv, R.color.cp_link_tip_a, 1);
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
            this.ipg = true;
            this.ipa.cap().setPhotoChanged(true);
            this.ipa.cap().setNameShow(str);
            this.ipa.cap().setNickNameLeftDays(90);
            this.ioQ.setText(str);
            cai();
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

    private void cam() {
        if (this.ipb != null) {
            this.ipb.cancel();
        }
        this.gDB = null;
        this.ipb = new a();
        this.ipb.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void can() {
        if (this.ipa != null && this.ipa.cap() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.ipa.cap()));
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
            PersonChangeActivity.this.ipd.setVisibility(0);
            PersonChangeActivity.this.fqU.setImageDrawable(null);
            PersonChangeActivity.this.gDB = null;
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
            PersonChangeActivity.this.ipb = null;
            PersonChangeActivity.this.ipd.setVisibility(8);
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
            PersonChangeActivity.this.ipb = null;
            PersonChangeActivity.this.ipd.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.gDB = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.gDB.drawImageTo(PersonChangeActivity.this.fqU);
                com.baidu.tbadk.imageManager.c.avu().a(PersonChangeActivity.this.ipa.cap().getPortrait(), PersonChangeActivity.this.gDB, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cao() {
        Intent intent = new Intent();
        if (this.ioN.booleanValue()) {
            intent.putExtra("person_change_data", this.ipa.cap());
        } else {
            intent.putExtra("data", this.ipa.cap());
        }
        TbadkCoreApplication.getInst().setPersonChangeData(this.ipa.cap());
        setResult(-1, intent);
        can();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private x bVP = null;
        private PersonChangeModel ipa;

        public b(PersonChangeModel personChangeModel) {
            this.ipa = null;
            this.ipa = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.ipc = null;
            if (this.bVP != null) {
                this.bVP.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.ipc = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.bVP != null) {
                if (this.bVP.amr().amS().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.cao();
                } else {
                    PersonChangeActivity.this.showToast(this.bVP.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.fms);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.ipa != null) {
                this.bVP = new x(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.bVP.addPostData("sex", String.valueOf(this.ipa.cap().getSex()));
                this.bVP.addPostData("intro", this.ipa.cap().getIntro());
                this.bVP.postMultiNetData();
                if (this.bVP.amr().amS().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.cph();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fwc && !TextUtils.isEmpty(this.ipq)) {
            BD(this.ipq);
            this.fwc = false;
            this.ipq = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BE(String str) {
        if (!StringUtils.isNull(str)) {
            this.ipi = true;
            this.ipk.setText(str);
            this.ipj.setClickable(false);
            this.ipl.setVisibility(8);
        }
    }
}
