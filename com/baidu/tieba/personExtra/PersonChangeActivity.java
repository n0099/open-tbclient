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
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
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
/* loaded from: classes11.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private ImageView cKS;
    private com.baidu.tbadk.coreExtra.view.c dly;
    private View jkR;
    private TextView jkS;
    private View jkT;
    private View jkU;
    private View jkV;
    private View jkW;
    private com.baidu.tbadk.core.dialog.a jkX;
    private String jkY;
    private LinearLayout jkZ;
    private View jkx;
    private TextView jla;
    private TextView jlb;
    private RelativeLayout jlc;
    private TextView jld;
    private TextView jle;
    private View mCloseView;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public final int jkv = 90;
    private Boolean jkw = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView hDk = null;
    private LinearLayout ges = null;
    private ScrollView jky = null;
    private TextView jkz = null;
    private RelativeLayout jkA = null;
    private TextView jkB = null;
    private LinearLayout jkC = null;
    private TextView exl = null;
    private EditText fjV = null;
    private LinearLayout jkD = null;
    private TextView jkE = null;
    private TextView jkF = null;
    private TextView jkG = null;
    private InputMethodManager mInputManager = null;
    private boolean jkH = false;
    private PersonChangeModel jkI = null;
    protected HeadImageView gjK = null;
    private com.baidu.adp.widget.ImageView.a hwr = null;
    private a jkJ = null;
    private b jkK = null;
    private ProgressBar jkL = null;
    private DialogInterface.OnCancelListener gfk = null;
    private com.baidu.tbadk.core.dialog.a hUX = null;
    private com.baidu.tbadk.core.dialog.i jkM = null;
    private boolean jkN = false;
    private boolean gVb = false;
    private boolean jkO = false;
    private int mSex = 0;
    private final int jkP = 500;
    private boolean jkQ = false;
    private boolean goW = false;
    private final View.OnClickListener jlf = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.jkI.cwk().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.jkN = true;
            }
            if (PersonChangeActivity.this.jkN) {
                PersonChangeActivity.this.hUX.aEA();
                return;
            }
            if (PersonChangeActivity.this.jkI != null && PersonChangeActivity.this.jkI.cwk().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.jkw.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.jkI.cwk());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.jkI.cwk());
                }
                PersonChangeActivity.this.cwi();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener gpF = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.goW = true;
                        PersonChangeActivity.this.jkY = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener jlg = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.jkI != null && PersonChangeActivity.this.jkI.cwk() != null && personChangeData != null) {
                    PersonChangeActivity.this.jkI.cwk().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.jkI.cwk().setMem(personChangeData.getMen());
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
        aXF();
        if (bundle != null) {
            this.jkw = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.jkw = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.gpF);
        registerListener(this.jlg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gpF);
        if (this.jkJ != null) {
            this.jkJ.cancel();
        }
        if (this.jkK != null) {
            this.jkK.cancel();
        }
        if (this.jkL != null) {
            this.jkL.setVisibility(8);
        }
        if (this.fjV != null) {
            this.fjV.addTextChangedListener(null);
        }
        if (this.dly != null) {
            this.dly.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gjK || view == this.jkW) {
            if (this.jkI != null && this.jkI.jlk != null && !this.jkI.jlk.canModifyAvatar()) {
                if (!StringUtils.isNull(this.jkI.jlk.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.jkI.jlk.getCantModifyAvatarDesc());
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
                cwd();
            }
        } else if (view == this.jkx) {
            if (!this.gVb && !this.jkO) {
                finish();
            }
            if (this.jkw.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.gVb) {
                cwf();
            } else if (this.jkO) {
                cwj();
            }
        } else if (view == this.jkA) {
            cwg();
        } else if (view == this.jkC) {
            cwb();
        } else if (view == this.fjV) {
            zR(800);
        } else if (view == this.jkU) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                cvZ();
            } else {
                int nickNameLeftDays = this.jkI.cwk().getNickNameLeftDays();
                if (this.jkI.cwk().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.sS(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).aEA();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.jkR) {
            if (this.jkI == null || this.jkI.cwk() == null || StringUtils.isNull(this.jkI.cwk().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.jlc) {
            PersonConstellationActivity.a(getActivity(), this.jkI.cwk().getBirthdayTime(), this.jkI.cwk().getBirthdayShowStatus());
        }
    }

    private void cvZ() {
        if (this.jkX == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.jkX = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.jkX.aO(inflate);
            this.jkX.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.ckb(), true)));
                    aVar.dismiss();
                }
            });
            this.jkX.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jkX.b(getPageContext());
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), (int) R.color.cp_cont_b);
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), (int) R.color.common_color_10122);
        }
        this.jkX.aEA();
    }

    private void i(AccountData accountData) {
        if (this.dly == null) {
            this.dly = new com.baidu.tbadk.coreExtra.view.c(this);
            this.dly.a(new c.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.GO(accountData2.getAccount());
                    }
                }
            });
        }
        this.dly.aML();
        this.dly.setAccountData(accountData);
        this.dly.aMH();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.jkH = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.jkH) {
            cwa();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwa() {
        if (this.fjV.getVisibility() == 0) {
            String replaceAll = this.fjV.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.exl.setText(replaceAll);
            } else {
                this.exl.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.jkI.cwk().getIntro() == null || !this.jkI.cwk().getIntro().equals(replaceAll)) {
                this.jkN = true;
            }
            this.jkI.cwk().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.fjV);
        }
    }

    private void cwb() {
        if (this.fjV.getVisibility() != 0) {
            this.exl.setVisibility(8);
            this.fjV.setText(this.jkI.cwk().getIntro());
            this.fjV.setSelection(this.fjV.getText().length());
            this.fjV.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.fjV);
            zR(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zR(int i) {
        this.jky.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.jky.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void ax(Bundle bundle) {
        this.gfk = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.jkK != null) {
                    PersonChangeActivity.this.jkK.cancel();
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
        this.jkI = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.ges);
        SvgManager.aGA().a(this.cKS, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gjK.refresh();
        am.setViewTextColor(this.jkS, (int) R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.jkI.cwk() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.jkI.cwk()));
        }
    }

    private void aXF() {
        this.jkW = findViewById(R.id.photo_pop_icon);
        this.jkW.setOnClickListener(this);
        this.gjK = (HeadImageView) findViewById(R.id.photo);
        this.gjK.setOnClickListener(this);
        this.gjK.startLoad(o.tn(this.jkI.cwk().getPortrait()), 25, false);
        this.ges = (LinearLayout) findViewById(R.id.parent);
        this.jky = (ScrollView) findViewById(R.id.person_change_scroll);
        this.jkA = (RelativeLayout) findViewById(R.id.person_sex);
        this.jkB = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mCloseView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.jlf);
        this.cKS = (ImageView) this.mCloseView.findViewById(R.id.widget_navi_back_button);
        this.cKS.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.jkx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.hDk = (TextView) this.jkx.findViewById(R.id.right_textview);
        this.hDk.setText(getPageContext().getString(R.string.save));
        am.setViewTextColor(this.hDk, R.color.navi_op_text, 1);
        this.jkx.setOnClickListener(this);
        this.jkA.setOnClickListener(this);
        this.jkC = (LinearLayout) findViewById(R.id.intro_click);
        this.jkC.setOnClickListener(this);
        this.jkC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.jkH = true;
                    return false;
                }
                return false;
            }
        });
        this.jkz = (TextView) findViewById(R.id.nick_name_show);
        this.jkz.setText(this.jkI.cwk().getNameShow());
        this.jkU = findViewById(R.id.person_nickname);
        this.jkU.setOnClickListener(this);
        this.jkV = findViewById(R.id.nick_name_more);
        cwc();
        this.jkS = (TextView) findViewById(R.id.user_name_show);
        this.jkR = findViewById(R.id.person_name);
        this.jkT = findViewById(R.id.user_name_more_icon);
        this.jkR.setOnClickListener(this);
        if (StringUtils.isNull(this.jkI.cwk().getName())) {
            this.jkS.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.jkQ = false;
            this.jkR.setClickable(true);
            this.jkT.setVisibility(0);
        } else {
            this.jkS.setText(this.jkI.cwk().getName());
            this.jkQ = true;
            this.jkR.setClickable(false);
            this.jkT.setVisibility(8);
        }
        this.jkD = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.jkE = (TextView) findViewById(R.id.intro_text_tip_num);
        this.jkF = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.jkG = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.exl = (TextView) findViewById(R.id.intro);
        this.exl.setVisibility(8);
        if (this.jkI.cwk().getIntro() != null && this.jkI.cwk().getIntro().length() > 0) {
            this.exl.setText(this.jkI.cwk().getIntro());
        } else {
            this.exl.setText(getPageContext().getString(R.string.add_intro));
        }
        this.fjV = (EditText) findViewById(R.id.edit);
        this.fjV.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.fjV.setHintTextColor(am.getColor(R.color.cp_cont_c));
        this.fjV.setCursorVisible(false);
        if (!aq.isEmpty(this.jkI.cwk().getIntro())) {
            this.fjV.setText(this.jkI.cwk().getIntro());
            this.jkE.setText(this.jkI.cwk().getIntro().length() + "");
        } else {
            this.jkE.setText("0");
        }
        this.jkD.setVisibility(0);
        this.fjV.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.cwa();
                }
            }
        });
        this.fjV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.jkH = true;
                    PersonChangeActivity.this.fjV.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.fjV.setOnClickListener(this);
        this.fjV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.fjV.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.jkE.setText(String.valueOf(length));
                PersonChangeActivity.this.jkD.setVisibility(0);
                PersonChangeActivity.this.zR(0);
                PersonChangeActivity.this.cwe();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.fjV.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.fjV.getSelectionStart() - 1 > PersonChangeActivity.this.fjV.getSelectionEnd()) {
                        PersonChangeActivity.this.fjV.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.fjV.getSelectionStart() - 1, PersonChangeActivity.this.fjV.getSelectionEnd());
                        PersonChangeActivity.this.fjV.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.fjV.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.jkI.cwk().getIntro())) {
                    PersonChangeActivity.this.gVb = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(PersonChangeActivity.this.hDk, R.color.navi_op_text, 1);
                    } else {
                        am.setViewTextColor(PersonChangeActivity.this.hDk, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.jkI.cwk().getSex() == 1) {
            this.mSex = 1;
            this.jkB.setText(R.string.male);
        } else if (this.jkI.cwk().getSex() == 2) {
            this.mSex = 2;
            this.jkB.setText(R.string.female);
        } else {
            this.jkB.setText(R.string.change_sex);
        }
        this.jkL = (ProgressBar) findViewById(R.id.image_progress);
        this.hUX = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hUX.sS(getPageContext().getString(R.string.confirm_giveup));
        this.hUX.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.cwf();
            }
        });
        this.hUX.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.jkI.cwk().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.jkw.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.jkI.cwk());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.jkI.cwk());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.cwi();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.hUX.b(getPageContext());
        this.jkZ = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.jla = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.jkI.cwk().getAlaId() > 0) {
            this.jkZ.setVisibility(0);
            this.jla.setText(this.jkI.cwk().getAlaId() + "");
        }
        this.jlb = (TextView) findViewById(R.id.person_forum_age_show);
        this.jlb.setText(getResources().getString(R.string.person_forum_age_suffix, this.jkI.cwk().getForumAge()));
        this.jlc = (RelativeLayout) findViewById(R.id.person_constellation);
        this.jlc.setOnClickListener(this);
        this.jld = (TextView) findViewById(R.id.constellation_txt);
        this.jle = (TextView) findViewById(R.id.age_txt);
        if (this.jkI.cwk().getBirthdayTime() != 0) {
            this.jld.setText(aq.l(new Date(this.jkI.cwk().getBirthdayTime() * 1000)));
        }
        if (this.jkI.cwk().getUserAge() > 0 && this.jkI.cwk().getBirthdayShowStatus() == 2) {
            this.jle.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.jkI.cwk().getUserAge())));
            this.jle.setVisibility(0);
        } else {
            this.jle.setVisibility(8);
        }
        this.jky.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.jky.scrollTo(0, 0);
            }
        });
    }

    private void cwc() {
        if (NickNameActivitySwitch.isOn() || this.jkI.cwk().getNickNameLeftDays() == 0) {
            this.jkV.setVisibility(0);
        } else {
            this.jkV.setVisibility(8);
        }
    }

    public void cwd() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.ka(R.string.operation);
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
        bVar.aEB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwe() {
        int color;
        if (this.fjV.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = am.getColor(R.color.common_color_10159);
        } else {
            color = am.getColor(R.color.common_color_10077);
        }
        zS(color);
    }

    private void zS(int i) {
        this.jkE.setTextColor(i);
        this.jkF.setTextColor(i);
        this.jkG.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwf() {
        if (this.jkI != null && this.jkI.cwk() != null) {
            cwa();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.jkI.cwk().setIntro(this.fjV.getText().toString().replaceAll("\\s*", ""));
            this.jkI.cwk().setSex(this.mSex);
            if (this.jkK == null) {
                this.jkK = new b(this.jkI);
                this.jkK.setPriority(3);
                this.jkK.execute(new String[0]);
            }
        }
    }

    private void cwg() {
        if (this.jkM == null) {
            this.jkM = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.jkM.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.jkM != null && PersonChangeActivity.this.jkM.isShowing()) {
                        PersonChangeActivity.this.jkM.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.jkB.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.jkB.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.jkI.cwk().getSex()) {
                            PersonChangeActivity.this.gVb = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                am.setViewTextColor(PersonChangeActivity.this.hDk, R.color.navi_op_text, 1);
                            } else {
                                am.setViewTextColor(PersonChangeActivity.this.hDk, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.jkM.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cwa();
            this.jlf.onClick(null);
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
                        if (longExtra != this.jkI.cwk().getBirthdayTime() || intExtra != this.jkI.cwk().getBirthdayShowStatus()) {
                            this.jkI.cwk().setBirthdayShowStatus(intExtra);
                            this.jkI.cwk().setBirthdayTime(longExtra);
                            this.jkN = true;
                            this.gVb = true;
                            Date date = new Date(longExtra * 1000);
                            this.jld.setText(aq.l(date));
                            if (this.jkI.cwk().getBirthdayShowStatus() == 2) {
                                this.jle.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(n(date))));
                                this.jle.setVisibility(0);
                                return;
                            }
                            this.jle.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            av(intent);
                            return;
                        } else {
                            ap(intent);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.jkI.cwk().setPhotoChanged(true);
                    cwh();
                    this.gVb = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.hDk, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.hDk, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.jkI.cwk().setPhotoChanged(true);
                    if (intent != null) {
                        this.gjK.setImageBitmap(null);
                        this.gjK.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.gVb = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.hDk, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.hDk, R.color.cp_link_tip_a, 1);
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

    private void GN(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.jkO = true;
            this.jkI.cwk().setPhotoChanged(true);
            this.jkI.cwk().setNameShow(str);
            this.jkI.cwk().setNickNameLeftDays(90);
            this.jkz.setText(str);
            cwc();
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

    private void av(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, RequestResponseCode.REQUEST_CAMERA_VIEW, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void cwh() {
        if (this.jkJ != null) {
            this.jkJ.cancel();
        }
        this.hwr = null;
        this.jkJ = new a();
        this.jkJ.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwi() {
        if (this.jkI != null && this.jkI.cwk() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.jkI.cwk()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.jkL.setVisibility(0);
            PersonChangeActivity.this.gjK.setImageDrawable(null);
            PersonChangeActivity.this.hwr = null;
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
            PersonChangeActivity.this.jkJ = null;
            PersonChangeActivity.this.jkL.setVisibility(8);
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
            PersonChangeActivity.this.jkJ = null;
            PersonChangeActivity.this.jkL.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.hwr = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.hwr.drawImageTo(PersonChangeActivity.this.gjK);
                com.baidu.tbadk.imageManager.c.aPO().a(PersonChangeActivity.this.jkI.cwk().getPortrait(), PersonChangeActivity.this.hwr, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwj() {
        Intent intent = new Intent();
        if (this.jkw.booleanValue()) {
            intent.putExtra("person_change_data", this.jkI.cwk());
        } else {
            intent.putExtra("data", this.jkI.cwk());
        }
        setResult(-1, intent);
        cwi();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private x cLD = null;
        private PersonChangeModel jkI;

        public b(PersonChangeModel personChangeModel) {
            this.jkI = null;
            this.jkI = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.jkK = null;
            if (this.cLD != null) {
                this.cLD.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.jkK = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.cLD != null) {
                if (this.cLD.aGe().aGG().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.cwj();
                } else {
                    PersonChangeActivity.this.showToast(this.cLD.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.gfk);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.jkI != null) {
                this.cLD = new x(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.cLD.addPostData("sex", String.valueOf(this.jkI.cwk().getSex()));
                this.cLD.addPostData("intro", this.jkI.cwk().getIntro());
                this.cLD.addPostData("birthday_time", String.valueOf(this.jkI.cwk().getBirthdayTime()));
                this.cLD.addPostData("birthday_show_status", String.valueOf(this.jkI.cwk().getBirthdayShowStatus()));
                this.cLD.postMultiNetData();
                if (this.cLD.aGe().aGG().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.cLP();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.goW && !TextUtils.isEmpty(this.jkY)) {
            GN(this.jkY);
            this.goW = false;
            this.jkY = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GO(String str) {
        if (!StringUtils.isNull(str)) {
            this.jkQ = true;
            this.jkS.setText(str);
            this.jkR.setClickable(false);
            this.jkT.setVisibility(8);
        }
    }
}
