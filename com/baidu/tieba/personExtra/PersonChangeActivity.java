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
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.view.c;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import java.util.Calendar;
import java.util.Date;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private ImageView cGP;
    private com.baidu.tbadk.coreExtra.view.c dhs;
    private View jjE;
    private View jjY;
    private TextView jjZ;
    private View jka;
    private View jkb;
    private View jkc;
    private View jkd;
    private com.baidu.tbadk.core.dialog.a jke;
    private String jkf;
    private LinearLayout jkg;
    private TextView jkh;
    private TextView jki;
    private RelativeLayout jkj;
    private TextView jkk;
    private TextView jkl;
    private View mCloseView;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public final int jjC = 90;
    private Boolean jjD = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView hBl = null;
    private LinearLayout gcq = null;
    private ScrollView jjF = null;
    private TextView jjG = null;
    private RelativeLayout jjH = null;
    private TextView jjI = null;
    private LinearLayout jjJ = null;
    private TextView etb = null;
    private EditText fgP = null;
    private LinearLayout jjK = null;
    private TextView jjL = null;
    private TextView jjM = null;
    private TextView jjN = null;
    private InputMethodManager mInputManager = null;
    private boolean jjO = false;
    private PersonChangeModel jjP = null;
    protected HeadImageView ghJ = null;
    private com.baidu.adp.widget.ImageView.a hus = null;
    private a jjQ = null;
    private b jjR = null;
    private ProgressBar jjS = null;
    private DialogInterface.OnCancelListener gdj = null;
    private com.baidu.tbadk.core.dialog.a hSZ = null;
    private com.baidu.tbadk.core.dialog.i jjT = null;
    private boolean jjU = false;
    private boolean gTb = false;
    private boolean jjV = false;
    private int mSex = 0;
    private final int jjW = 500;
    private boolean jjX = false;
    private boolean gmV = false;
    private final View.OnClickListener jkm = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.jjP.cuR().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.jjU = true;
            }
            if (PersonChangeActivity.this.jjU) {
                PersonChangeActivity.this.hSZ.aCp();
                return;
            }
            if (PersonChangeActivity.this.jjP != null && PersonChangeActivity.this.jjP.cuR().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.jjD.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.jjP.cuR());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.jjP.cuR());
                }
                PersonChangeActivity.this.cuP();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener gnE = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.gmV = true;
                        PersonChangeActivity.this.jkf = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener jkn = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.jjP != null && PersonChangeActivity.this.jjP.cuR() != null && personChangeData != null) {
                    PersonChangeActivity.this.jjP.cuR().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.jjP.cuR().setMem(personChangeData.getMen());
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
        ax(bundle);
        aVq();
        if (bundle != null) {
            this.jjD = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.jjD = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.gnE);
        registerListener(this.jkn);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gnE);
        if (this.jjQ != null) {
            this.jjQ.cancel();
        }
        if (this.jjR != null) {
            this.jjR.cancel();
        }
        if (this.jjS != null) {
            this.jjS.setVisibility(8);
        }
        if (this.fgP != null) {
            this.fgP.addTextChangedListener(null);
        }
        if (this.dhs != null) {
            this.dhs.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.ghJ || view == this.jkd) {
            if (this.jjP != null && this.jjP.jkr != null && !this.jjP.jkr.canModifyAvatar()) {
                if (!StringUtils.isNull(this.jjP.jkr.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.jjP.jkr.getCantModifyAvatarDesc());
                    return;
                } else {
                    l.showLongToast(TbadkCoreApplication.getInst(), (int) R.string.person_cant_edit_avatar_default_tip);
                    return;
                }
            }
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new com.baidu.tbadk.core.util.b.a();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                cuK();
            }
        } else if (view == this.jjE) {
            if (!this.gTb && !this.jjV) {
                finish();
            }
            if (this.jjD.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.gTb) {
                cuM();
            } else if (this.jjV) {
                cuQ();
            }
        } else if (view == this.jjH) {
            cuN();
        } else if (view == this.jjJ) {
            cuI();
        } else if (view == this.fgP) {
            zK(800);
        } else if (view == this.jkb) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                cuG();
            } else {
                int nickNameLeftDays = this.jjP.cuR().getNickNameLeftDays();
                if (this.jjP.cuR().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.sC(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.12
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                aVar2.dismiss();
                            }
                        });
                        aVar.b(getPageContext()).aCp();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.jjY) {
            if (this.jjP == null || this.jjP.cuR() == null || StringUtils.isNull(this.jjP.cuR().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.jkj) {
            PersonConstellationActivity.a(getActivity(), this.jjP.cuR().getBirthdayTime(), this.jjP.cuR().getBirthdayShowStatus());
        }
    }

    private void cuG() {
        if (this.jke == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.jke = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.jke.aO(inflate);
            this.jke.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.d.cix(), true)));
                    aVar.dismiss();
                }
            });
            this.jke.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jke.b(getPageContext());
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), (int) R.color.cp_cont_b);
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), (int) R.color.common_color_10122);
        }
        this.jke.aCp();
    }

    private void i(AccountData accountData) {
        if (this.dhs == null) {
            this.dhs = new com.baidu.tbadk.coreExtra.view.c(this);
            this.dhs.a(new c.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.GA(accountData2.getAccount());
                    }
                }
            });
        }
        this.dhs.aKp();
        this.dhs.setAccountData(accountData);
        this.dhs.aKl();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.jjO = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.jjO) {
            cuH();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuH() {
        if (this.fgP.getVisibility() == 0) {
            String replaceAll = this.fgP.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.etb.setText(replaceAll);
            } else {
                this.etb.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.jjP.cuR().getIntro() == null || !this.jjP.cuR().getIntro().equals(replaceAll)) {
                this.jjU = true;
            }
            this.jjP.cuR().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.fgP);
        }
    }

    private void cuI() {
        if (this.fgP.getVisibility() != 0) {
            this.etb.setVisibility(8);
            this.fgP.setText(this.jjP.cuR().getIntro());
            this.fgP.setSelection(this.fgP.getText().length());
            this.fgP.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.fgP);
            zK(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zK(int i) {
        this.jjF.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.jjF.fullScroll(130);
            }
        }, i);
    }

    private void ax(Bundle bundle) {
        this.gdj = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.jjR != null) {
                    PersonChangeActivity.this.jjR.cancel();
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
        this.jjP = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.gcq);
        SvgManager.aEp().a(this.cGP, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ghJ.refresh();
        am.setViewTextColor(this.jjZ, (int) R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.jjP.cuR() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.jjP.cuR()));
        }
    }

    private void aVq() {
        this.jkd = findViewById(R.id.photo_pop_icon);
        this.jkd.setOnClickListener(this);
        this.ghJ = (HeadImageView) findViewById(R.id.photo);
        this.ghJ.setOnClickListener(this);
        this.ghJ.startLoad(o.sX(this.jjP.cuR().getPortrait()), 25, false);
        this.gcq = (LinearLayout) findViewById(R.id.parent);
        this.jjF = (ScrollView) findViewById(R.id.person_change_scroll);
        this.jjH = (RelativeLayout) findViewById(R.id.person_sex);
        this.jjI = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mCloseView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.jkm);
        this.cGP = (ImageView) this.mCloseView.findViewById(R.id.widget_navi_back_button);
        this.cGP.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.jjE = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.hBl = (TextView) this.jjE.findViewById(R.id.right_textview);
        this.hBl.setText(getPageContext().getString(R.string.save));
        am.setViewTextColor(this.hBl, R.color.navi_op_text, 1);
        this.jjE.setOnClickListener(this);
        this.jjH.setOnClickListener(this);
        this.jjJ = (LinearLayout) findViewById(R.id.intro_click);
        this.jjJ.setOnClickListener(this);
        this.jjJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.jjO = true;
                    return false;
                }
                return false;
            }
        });
        this.jjG = (TextView) findViewById(R.id.nick_name_show);
        this.jjG.setText(this.jjP.cuR().getNameShow());
        this.jkb = findViewById(R.id.person_nickname);
        this.jkb.setOnClickListener(this);
        this.jkc = findViewById(R.id.nick_name_more);
        cuJ();
        this.jjZ = (TextView) findViewById(R.id.user_name_show);
        this.jjY = findViewById(R.id.person_name);
        this.jka = findViewById(R.id.user_name_more_icon);
        this.jjY.setOnClickListener(this);
        if (StringUtils.isNull(this.jjP.cuR().getName())) {
            this.jjZ.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.jjX = false;
            this.jjY.setClickable(true);
            this.jka.setVisibility(0);
        } else {
            this.jjZ.setText(this.jjP.cuR().getName());
            this.jjX = true;
            this.jjY.setClickable(false);
            this.jka.setVisibility(8);
        }
        this.jjK = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.jjL = (TextView) findViewById(R.id.intro_text_tip_num);
        this.jjM = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.jjN = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.etb = (TextView) findViewById(R.id.intro);
        this.etb.setVisibility(8);
        if (this.jjP.cuR().getIntro() != null && this.jjP.cuR().getIntro().length() > 0) {
            this.etb.setText(this.jjP.cuR().getIntro());
        } else {
            this.etb.setText(getPageContext().getString(R.string.add_intro));
        }
        this.fgP = (EditText) findViewById(R.id.edit);
        this.fgP.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.fgP.setHintTextColor(am.getColor(R.color.cp_cont_c));
        this.fgP.setCursorVisible(false);
        if (!aq.isEmpty(this.jjP.cuR().getIntro())) {
            this.fgP.setText(this.jjP.cuR().getIntro());
            this.jjL.setText(this.jjP.cuR().getIntro().length() + "");
        } else {
            this.jjL.setText("0");
        }
        this.jjK.setVisibility(0);
        this.fgP.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.cuH();
                }
            }
        });
        this.fgP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.jjO = true;
                    PersonChangeActivity.this.fgP.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.fgP.setOnClickListener(this);
        this.fgP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.fgP.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.jjL.setText(String.valueOf(length));
                PersonChangeActivity.this.jjK.setVisibility(0);
                PersonChangeActivity.this.zK(0);
                PersonChangeActivity.this.cuL();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.fgP.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.fgP.getSelectionStart() - 1 > PersonChangeActivity.this.fgP.getSelectionEnd()) {
                        PersonChangeActivity.this.fgP.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.fgP.getSelectionStart() - 1, PersonChangeActivity.this.fgP.getSelectionEnd());
                        PersonChangeActivity.this.fgP.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.fgP.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.jjP.cuR().getIntro())) {
                    PersonChangeActivity.this.gTb = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(PersonChangeActivity.this.hBl, R.color.navi_op_text, 1);
                    } else {
                        am.setViewTextColor(PersonChangeActivity.this.hBl, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.jjP.cuR().getSex() == 1) {
            this.mSex = 1;
            this.jjI.setText(R.string.male);
        } else if (this.jjP.cuR().getSex() == 2) {
            this.mSex = 2;
            this.jjI.setText(R.string.female);
        } else {
            this.jjI.setText(R.string.change_sex);
        }
        this.jjS = (ProgressBar) findViewById(R.id.image_progress);
        this.hSZ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hSZ.sC(getPageContext().getString(R.string.confirm_giveup));
        this.hSZ.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.cuM();
            }
        });
        this.hSZ.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.jjP.cuR().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.jjD.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.jjP.cuR());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.jjP.cuR());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.cuP();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.hSZ.b(getPageContext());
        this.jkg = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.jkh = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.jjP.cuR().getAlaId() > 0) {
            this.jkg.setVisibility(0);
            this.jkh.setText(this.jjP.cuR().getAlaId() + "");
        }
        this.jki = (TextView) findViewById(R.id.person_forum_age_show);
        this.jki.setText(getResources().getString(R.string.person_forum_age_suffix, this.jjP.cuR().getForumAge()));
        this.jkj = (RelativeLayout) findViewById(R.id.person_constellation);
        this.jkj.setOnClickListener(this);
        this.jkk = (TextView) findViewById(R.id.constellation_txt);
        this.jkl = (TextView) findViewById(R.id.age_txt);
        if (this.jjP.cuR().getBirthdayTime() != 0) {
            this.jkk.setText(aq.l(new Date(this.jjP.cuR().getBirthdayTime() * 1000)));
        }
        if (this.jjP.cuR().getUserAge() > 0 && this.jjP.cuR().getBirthdayShowStatus() == 2) {
            this.jkl.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.jjP.cuR().getUserAge())));
            this.jkl.setVisibility(0);
        } else {
            this.jkl.setVisibility(8);
        }
        this.jjF.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.jjF.scrollTo(0, 0);
            }
        });
    }

    private void cuJ() {
        if (NickNameActivitySwitch.isOn() || this.jjP.cuR().getNickNameLeftDays() == 0) {
            this.jkc.setVisibility(0);
        } else {
            this.jkc.setVisibility(8);
        }
    }

    public void cuK() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.jJ(R.string.operation);
        bVar.a(strArr, new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
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
        bVar.aCq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuL() {
        int color;
        if (this.fgP.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = am.getColor(R.color.common_color_10159);
        } else {
            color = am.getColor(R.color.common_color_10077);
        }
        zL(color);
    }

    private void zL(int i) {
        this.jjL.setTextColor(i);
        this.jjM.setTextColor(i);
        this.jjN.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuM() {
        if (this.jjP != null && this.jjP.cuR() != null) {
            cuH();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.jjP.cuR().setIntro(this.fgP.getText().toString().replaceAll("\\s*", ""));
            this.jjP.cuR().setSex(this.mSex);
            if (this.jjR == null) {
                this.jjR = new b(this.jjP);
                this.jjR.setPriority(3);
                this.jjR.execute(new String[0]);
            }
        }
    }

    private void cuN() {
        if (this.jjT == null) {
            this.jjT = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.jjT.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.jjT != null && PersonChangeActivity.this.jjT.isShowing()) {
                        PersonChangeActivity.this.jjT.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.jjI.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.jjI.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.jjP.cuR().getSex()) {
                            PersonChangeActivity.this.gTb = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                am.setViewTextColor(PersonChangeActivity.this.hBl, R.color.navi_op_text, 1);
                            } else {
                                am.setViewTextColor(PersonChangeActivity.this.hBl, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.jjT.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cuH();
            this.jkm.onClick(null);
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
                case 1001:
                    if (intent != null) {
                        long longExtra = intent.getLongExtra("constellation_birthday", 0L);
                        int intExtra = intent.getIntExtra("constellation_show_status", 0);
                        if (longExtra != this.jjP.cuR().getBirthdayTime() || intExtra != this.jjP.cuR().getBirthdayShowStatus()) {
                            this.jjP.cuR().setBirthdayShowStatus(intExtra);
                            this.jjP.cuR().setBirthdayTime(longExtra);
                            this.jjU = true;
                            this.gTb = true;
                            Date date = new Date(longExtra * 1000);
                            this.jkk.setText(aq.l(date));
                            if (this.jjP.cuR().getBirthdayShowStatus() == 2) {
                                this.jkl.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(n(date))));
                                this.jkl.setVisibility(0);
                                return;
                            }
                            this.jkl.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            aw(intent);
                            return;
                        } else {
                            ap(intent);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.jjP.cuR().setPhotoChanged(true);
                    cuO();
                    this.gTb = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.hBl, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.hBl, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.jjP.cuR().setPhotoChanged(true);
                    if (intent != null) {
                        this.ghJ.setImageBitmap(null);
                        this.ghJ.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.gTb = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.hBl, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.hBl, R.color.cp_link_tip_a, 1);
                        return;
                    }
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    al.e(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    public static int n(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (calendar.before(date)) {
            return 0;
        }
        int i = calendar.get(1);
        int i2 = calendar.get(2) + 1;
        int i3 = calendar.get(5);
        calendar.setTime(date);
        int i4 = calendar.get(1);
        int i5 = calendar.get(2) + 1;
        int i6 = calendar.get(5);
        int i7 = i - i4;
        if (i2 <= i5) {
            if (i2 == i5) {
                if (i3 < i6) {
                    return i7 - 1;
                }
                return i7;
            }
            return i7 - 1;
        }
        return i7;
    }

    private void Gz(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jjV = true;
            this.jjP.cuR().setPhotoChanged(true);
            this.jjP.cuR().setNameShow(str);
            this.jjP.cuR().setNickNameLeftDays(90);
            this.jjG.setText(str);
            cuJ();
        }
    }

    private void ap(Intent intent) {
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

    private void aw(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, RequestResponseCode.REQUEST_CAMERA_VIEW, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void cuO() {
        if (this.jjQ != null) {
            this.jjQ.cancel();
        }
        this.hus = null;
        this.jjQ = new a();
        this.jjQ.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuP() {
        if (this.jjP != null && this.jjP.cuR() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.jjP.cuR()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.jjS.setVisibility(0);
            PersonChangeActivity.this.ghJ.setImageDrawable(null);
            PersonChangeActivity.this.hus = null;
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
            PersonChangeActivity.this.jjQ = null;
            PersonChangeActivity.this.jjS.setVisibility(8);
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
            PersonChangeActivity.this.jjQ = null;
            PersonChangeActivity.this.jjS.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.hus = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.hus.drawImageTo(PersonChangeActivity.this.ghJ);
                com.baidu.tbadk.imageManager.c.aNs().a(PersonChangeActivity.this.jjP.cuR().getPortrait(), PersonChangeActivity.this.hus, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuQ() {
        Intent intent = new Intent();
        if (this.jjD.booleanValue()) {
            intent.putExtra("person_change_data", this.jjP.cuR());
        } else {
            intent.putExtra("data", this.jjP.cuR());
        }
        setResult(-1, intent);
        cuP();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private x cHA = null;
        private PersonChangeModel jjP;

        public b(PersonChangeModel personChangeModel) {
            this.jjP = null;
            this.jjP = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.jjR = null;
            if (this.cHA != null) {
                this.cHA.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.jjR = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.cHA != null) {
                if (this.cHA.aDU().aEv().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.cuQ();
                } else {
                    PersonChangeActivity.this.showToast(this.cHA.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.gdj);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.jjP != null) {
                this.cHA = new x(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.cHA.addPostData("sex", String.valueOf(this.jjP.cuR().getSex()));
                this.cHA.addPostData("intro", this.jjP.cuR().getIntro());
                this.cHA.addPostData("birthday_time", String.valueOf(this.jjP.cuR().getBirthdayTime()));
                this.cHA.addPostData("birthday_show_status", String.valueOf(this.jjP.cuR().getBirthdayShowStatus()));
                this.cHA.postMultiNetData();
                if (this.cHA.aDU().aEv().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.cKr();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.gmV && !TextUtils.isEmpty(this.jkf)) {
            Gz(this.jkf);
            this.gmV = false;
            this.jkf = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GA(String str) {
        if (!StringUtils.isNull(str)) {
            this.jjX = true;
            this.jjZ.setText(str);
            this.jjY.setClickable(false);
            this.jka.setVisibility(8);
        }
    }
}
