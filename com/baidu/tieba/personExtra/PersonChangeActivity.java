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
    private ImageView cKT;
    private com.baidu.tbadk.coreExtra.view.c dlz;
    private View jkT;
    private TextView jkU;
    private View jkV;
    private View jkW;
    private View jkX;
    private View jkY;
    private com.baidu.tbadk.core.dialog.a jkZ;
    private View jkz;
    private String jla;
    private LinearLayout jlb;
    private TextView jlc;
    private TextView jld;
    private RelativeLayout jle;
    private TextView jlf;
    private TextView jlg;
    private View mCloseView;
    private com.baidu.tbadk.core.util.b.a mPermissionJudgement;
    public final int jkx = 90;
    private Boolean jky = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView hDm = null;
    private LinearLayout geu = null;
    private ScrollView jkA = null;
    private TextView jkB = null;
    private RelativeLayout jkC = null;
    private TextView jkD = null;
    private LinearLayout jkE = null;
    private TextView exm = null;
    private EditText fjW = null;
    private LinearLayout jkF = null;
    private TextView jkG = null;
    private TextView jkH = null;
    private TextView jkI = null;
    private InputMethodManager mInputManager = null;
    private boolean jkJ = false;
    private PersonChangeModel jkK = null;
    protected HeadImageView gjM = null;
    private com.baidu.adp.widget.ImageView.a hwt = null;
    private a jkL = null;
    private b jkM = null;
    private ProgressBar jkN = null;
    private DialogInterface.OnCancelListener gfm = null;
    private com.baidu.tbadk.core.dialog.a hUZ = null;
    private com.baidu.tbadk.core.dialog.i jkO = null;
    private boolean jkP = false;
    private boolean gVd = false;
    private boolean jkQ = false;
    private int mSex = 0;
    private final int jkR = 500;
    private boolean jkS = false;
    private boolean goY = false;
    private final View.OnClickListener jlh = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.jkK.cwm().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.jkP = true;
            }
            if (PersonChangeActivity.this.jkP) {
                PersonChangeActivity.this.hUZ.aEC();
                return;
            }
            if (PersonChangeActivity.this.jkK != null && PersonChangeActivity.this.jkK.cwm().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.jky.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.jkK.cwm());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.jkK.cwm());
                }
                PersonChangeActivity.this.cwk();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener gpH = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.goY = true;
                        PersonChangeActivity.this.jla = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener jli = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.jkK != null && PersonChangeActivity.this.jkK.cwm() != null && personChangeData != null) {
                    PersonChangeActivity.this.jkK.cwm().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.jkK.cwm().setMem(personChangeData.getMen());
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
        aXH();
        if (bundle != null) {
            this.jky = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.jky = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.gpH);
        registerListener(this.jli);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gpH);
        if (this.jkL != null) {
            this.jkL.cancel();
        }
        if (this.jkM != null) {
            this.jkM.cancel();
        }
        if (this.jkN != null) {
            this.jkN.setVisibility(8);
        }
        if (this.fjW != null) {
            this.fjW.addTextChangedListener(null);
        }
        if (this.dlz != null) {
            this.dlz.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.gjM || view == this.jkY) {
            if (this.jkK != null && this.jkK.jlm != null && !this.jkK.jlm.canModifyAvatar()) {
                if (!StringUtils.isNull(this.jkK.jlm.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.jkK.jlm.getCantModifyAvatarDesc());
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
                cwf();
            }
        } else if (view == this.jkz) {
            if (!this.gVd && !this.jkQ) {
                finish();
            }
            if (this.jky.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.gVd) {
                cwh();
            } else if (this.jkQ) {
                cwl();
            }
        } else if (view == this.jkC) {
            cwi();
        } else if (view == this.jkE) {
            cwd();
        } else if (view == this.fjW) {
            zR(800);
        } else if (view == this.jkW) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                cwb();
            } else {
                int nickNameLeftDays = this.jkK.cwm().getNickNameLeftDays();
                if (this.jkK.cwm().getMen() <= 0) {
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
                        aVar.b(getPageContext()).aEC();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.jkT) {
            if (this.jkK == null || this.jkK.cwm() == null || StringUtils.isNull(this.jkK.cwm().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.jle) {
            PersonConstellationActivity.a(getActivity(), this.jkK.cwm().getBirthdayTime(), this.jkK.cwm().getBirthdayShowStatus());
        }
    }

    private void cwb() {
        if (this.jkZ == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.jkZ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.jkZ.aO(inflate);
            this.jkZ.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.ckd(), true)));
                    aVar.dismiss();
                }
            });
            this.jkZ.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.jkZ.b(getPageContext());
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), (int) R.color.cp_cont_b);
            am.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), (int) R.color.common_color_10122);
        }
        this.jkZ.aEC();
    }

    private void i(AccountData accountData) {
        if (this.dlz == null) {
            this.dlz = new com.baidu.tbadk.coreExtra.view.c(this);
            this.dlz.a(new c.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.c.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.GO(accountData2.getAccount());
                    }
                }
            });
        }
        this.dlz.aMN();
        this.dlz.setAccountData(accountData);
        this.dlz.aMJ();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.jkJ = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.jkJ) {
            cwc();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwc() {
        if (this.fjW.getVisibility() == 0) {
            String replaceAll = this.fjW.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.exm.setText(replaceAll);
            } else {
                this.exm.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.jkK.cwm().getIntro() == null || !this.jkK.cwm().getIntro().equals(replaceAll)) {
                this.jkP = true;
            }
            this.jkK.cwm().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.fjW);
        }
    }

    private void cwd() {
        if (this.fjW.getVisibility() != 0) {
            this.exm.setVisibility(8);
            this.fjW.setText(this.jkK.cwm().getIntro());
            this.fjW.setSelection(this.fjW.getText().length());
            this.fjW.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.fjW);
            zR(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zR(int i) {
        this.jkA.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.jkA.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void ax(Bundle bundle) {
        this.gfm = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.jkM != null) {
                    PersonChangeActivity.this.jkM.cancel();
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
        this.jkK = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.geu);
        SvgManager.aGC().a(this.cKT, R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.gjM.refresh();
        am.setViewTextColor(this.jkU, (int) R.color.cp_cont_d);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.jkK.cwm() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.jkK.cwm()));
        }
    }

    private void aXH() {
        this.jkY = findViewById(R.id.photo_pop_icon);
        this.jkY.setOnClickListener(this);
        this.gjM = (HeadImageView) findViewById(R.id.photo);
        this.gjM.setOnClickListener(this);
        this.gjM.startLoad(o.tn(this.jkK.cwm().getPortrait()), 25, false);
        this.geu = (LinearLayout) findViewById(R.id.parent);
        this.jkA = (ScrollView) findViewById(R.id.person_change_scroll);
        this.jkC = (RelativeLayout) findViewById(R.id.person_sex);
        this.jkD = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mCloseView = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.jlh);
        this.cKT = (ImageView) this.mCloseView.findViewById(R.id.widget_navi_back_button);
        this.cKT.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.jkz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.hDm = (TextView) this.jkz.findViewById(R.id.right_textview);
        this.hDm.setText(getPageContext().getString(R.string.save));
        am.setViewTextColor(this.hDm, R.color.navi_op_text, 1);
        this.jkz.setOnClickListener(this);
        this.jkC.setOnClickListener(this);
        this.jkE = (LinearLayout) findViewById(R.id.intro_click);
        this.jkE.setOnClickListener(this);
        this.jkE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.jkJ = true;
                    return false;
                }
                return false;
            }
        });
        this.jkB = (TextView) findViewById(R.id.nick_name_show);
        this.jkB.setText(this.jkK.cwm().getNameShow());
        this.jkW = findViewById(R.id.person_nickname);
        this.jkW.setOnClickListener(this);
        this.jkX = findViewById(R.id.nick_name_more);
        cwe();
        this.jkU = (TextView) findViewById(R.id.user_name_show);
        this.jkT = findViewById(R.id.person_name);
        this.jkV = findViewById(R.id.user_name_more_icon);
        this.jkT.setOnClickListener(this);
        if (StringUtils.isNull(this.jkK.cwm().getName())) {
            this.jkU.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.jkS = false;
            this.jkT.setClickable(true);
            this.jkV.setVisibility(0);
        } else {
            this.jkU.setText(this.jkK.cwm().getName());
            this.jkS = true;
            this.jkT.setClickable(false);
            this.jkV.setVisibility(8);
        }
        this.jkF = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.jkG = (TextView) findViewById(R.id.intro_text_tip_num);
        this.jkH = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.jkI = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.exm = (TextView) findViewById(R.id.intro);
        this.exm.setVisibility(8);
        if (this.jkK.cwm().getIntro() != null && this.jkK.cwm().getIntro().length() > 0) {
            this.exm.setText(this.jkK.cwm().getIntro());
        } else {
            this.exm.setText(getPageContext().getString(R.string.add_intro));
        }
        this.fjW = (EditText) findViewById(R.id.edit);
        this.fjW.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.fjW.setHintTextColor(am.getColor(R.color.cp_cont_c));
        this.fjW.setCursorVisible(false);
        if (!aq.isEmpty(this.jkK.cwm().getIntro())) {
            this.fjW.setText(this.jkK.cwm().getIntro());
            this.jkG.setText(this.jkK.cwm().getIntro().length() + "");
        } else {
            this.jkG.setText("0");
        }
        this.jkF.setVisibility(0);
        this.fjW.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.cwc();
                }
            }
        });
        this.fjW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.jkJ = true;
                    PersonChangeActivity.this.fjW.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.fjW.setOnClickListener(this);
        this.fjW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.fjW.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.jkG.setText(String.valueOf(length));
                PersonChangeActivity.this.jkF.setVisibility(0);
                PersonChangeActivity.this.zR(0);
                PersonChangeActivity.this.cwg();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.fjW.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.fjW.getSelectionStart() - 1 > PersonChangeActivity.this.fjW.getSelectionEnd()) {
                        PersonChangeActivity.this.fjW.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.fjW.getSelectionStart() - 1, PersonChangeActivity.this.fjW.getSelectionEnd());
                        PersonChangeActivity.this.fjW.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.fjW.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.jkK.cwm().getIntro())) {
                    PersonChangeActivity.this.gVd = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(PersonChangeActivity.this.hDm, R.color.navi_op_text, 1);
                    } else {
                        am.setViewTextColor(PersonChangeActivity.this.hDm, R.color.cp_link_tip_a, 1);
                    }
                }
            }
        });
        if (this.jkK.cwm().getSex() == 1) {
            this.mSex = 1;
            this.jkD.setText(R.string.male);
        } else if (this.jkK.cwm().getSex() == 2) {
            this.mSex = 2;
            this.jkD.setText(R.string.female);
        } else {
            this.jkD.setText(R.string.change_sex);
        }
        this.jkN = (ProgressBar) findViewById(R.id.image_progress);
        this.hUZ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.hUZ.sS(getPageContext().getString(R.string.confirm_giveup));
        this.hUZ.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.cwh();
            }
        });
        this.hUZ.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.jkK.cwm().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.jky.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.jkK.cwm());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.jkK.cwm());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.cwk();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.hUZ.b(getPageContext());
        this.jlb = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.jlc = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.jkK.cwm().getAlaId() > 0) {
            this.jlb.setVisibility(0);
            this.jlc.setText(this.jkK.cwm().getAlaId() + "");
        }
        this.jld = (TextView) findViewById(R.id.person_forum_age_show);
        this.jld.setText(getResources().getString(R.string.person_forum_age_suffix, this.jkK.cwm().getForumAge()));
        this.jle = (RelativeLayout) findViewById(R.id.person_constellation);
        this.jle.setOnClickListener(this);
        this.jlf = (TextView) findViewById(R.id.constellation_txt);
        this.jlg = (TextView) findViewById(R.id.age_txt);
        if (this.jkK.cwm().getBirthdayTime() != 0) {
            this.jlf.setText(aq.l(new Date(this.jkK.cwm().getBirthdayTime() * 1000)));
        }
        if (this.jkK.cwm().getUserAge() > 0 && this.jkK.cwm().getBirthdayShowStatus() == 2) {
            this.jlg.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.jkK.cwm().getUserAge())));
            this.jlg.setVisibility(0);
        } else {
            this.jlg.setVisibility(8);
        }
        this.jkA.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.jkA.scrollTo(0, 0);
            }
        });
    }

    private void cwe() {
        if (NickNameActivitySwitch.isOn() || this.jkK.cwm().getNickNameLeftDays() == 0) {
            this.jkX.setVisibility(0);
        } else {
            this.jkX.setVisibility(8);
        }
    }

    public void cwf() {
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
        bVar.aED();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwg() {
        int color;
        if (this.fjW.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = am.getColor(R.color.common_color_10159);
        } else {
            color = am.getColor(R.color.common_color_10077);
        }
        zS(color);
    }

    private void zS(int i) {
        this.jkG.setTextColor(i);
        this.jkH.setTextColor(i);
        this.jkI.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwh() {
        if (this.jkK != null && this.jkK.cwm() != null) {
            cwc();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.jkK.cwm().setIntro(this.fjW.getText().toString().replaceAll("\\s*", ""));
            this.jkK.cwm().setSex(this.mSex);
            if (this.jkM == null) {
                this.jkM = new b(this.jkK);
                this.jkM.setPriority(3);
                this.jkM.execute(new String[0]);
            }
        }
    }

    private void cwi() {
        if (this.jkO == null) {
            this.jkO = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.jkO.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.jkO != null && PersonChangeActivity.this.jkO.isShowing()) {
                        PersonChangeActivity.this.jkO.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.jkD.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.jkD.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.jkK.cwm().getSex()) {
                            PersonChangeActivity.this.gVd = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                am.setViewTextColor(PersonChangeActivity.this.hDm, R.color.navi_op_text, 1);
                            } else {
                                am.setViewTextColor(PersonChangeActivity.this.hDm, R.color.cp_link_tip_a, 1);
                            }
                        }
                    }
                }
            });
        }
        this.jkO.showDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            cwc();
            this.jlh.onClick(null);
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
                        if (longExtra != this.jkK.cwm().getBirthdayTime() || intExtra != this.jkK.cwm().getBirthdayShowStatus()) {
                            this.jkK.cwm().setBirthdayShowStatus(intExtra);
                            this.jkK.cwm().setBirthdayTime(longExtra);
                            this.jkP = true;
                            this.gVd = true;
                            Date date = new Date(longExtra * 1000);
                            this.jlf.setText(aq.l(date));
                            if (this.jkK.cwm().getBirthdayShowStatus() == 2) {
                                this.jlg.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(n(date))));
                                this.jlg.setVisibility(0);
                                return;
                            }
                            this.jlg.setVisibility(8);
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
                    this.jkK.cwm().setPhotoChanged(true);
                    cwj();
                    this.gVd = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.hDm, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.hDm, R.color.cp_link_tip_a, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.jkK.cwm().setPhotoChanged(true);
                    if (intent != null) {
                        this.gjM.setImageBitmap(null);
                        this.gjM.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.gVd = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        am.setViewTextColor(this.hDm, R.color.navi_op_text, 1);
                        return;
                    } else {
                        am.setViewTextColor(this.hDm, R.color.cp_link_tip_a, 1);
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
            this.jkQ = true;
            this.jkK.cwm().setPhotoChanged(true);
            this.jkK.cwm().setNameShow(str);
            this.jkK.cwm().setNickNameLeftDays(90);
            this.jkB.setText(str);
            cwe();
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

    private void cwj() {
        if (this.jkL != null) {
            this.jkL.cancel();
        }
        this.hwt = null;
        this.jkL = new a();
        this.jkL.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwk() {
        if (this.jkK != null && this.jkK.cwm() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.jkK.cwm()));
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
            PersonChangeActivity.this.jkN.setVisibility(0);
            PersonChangeActivity.this.gjM.setImageDrawable(null);
            PersonChangeActivity.this.hwt = null;
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
            PersonChangeActivity.this.jkL = null;
            PersonChangeActivity.this.jkN.setVisibility(8);
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
            PersonChangeActivity.this.jkL = null;
            PersonChangeActivity.this.jkN.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.hwt = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.hwt.drawImageTo(PersonChangeActivity.this.gjM);
                com.baidu.tbadk.imageManager.c.aPQ().a(PersonChangeActivity.this.jkK.cwm().getPortrait(), PersonChangeActivity.this.hwt, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwl() {
        Intent intent = new Intent();
        if (this.jky.booleanValue()) {
            intent.putExtra("person_change_data", this.jkK.cwm());
        } else {
            intent.putExtra("data", this.jkK.cwm());
        }
        setResult(-1, intent);
        cwk();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private x cLE = null;
        private PersonChangeModel jkK;

        public b(PersonChangeModel personChangeModel) {
            this.jkK = null;
            this.jkK = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.jkM = null;
            if (this.cLE != null) {
                this.cLE.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.jkM = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.cLE != null) {
                if (this.cLE.aGg().aGI().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.cwl();
                } else {
                    PersonChangeActivity.this.showToast(this.cLE.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.gfm);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.jkK != null) {
                this.cLE = new x(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.cLE.addPostData("sex", String.valueOf(this.jkK.cwm().getSex()));
                this.cLE.addPostData("intro", this.jkK.cwm().getIntro());
                this.cLE.addPostData("birthday_time", String.valueOf(this.jkK.cwm().getBirthdayTime()));
                this.cLE.addPostData("birthday_show_status", String.valueOf(this.jkK.cwm().getBirthdayShowStatus()));
                this.cLE.postMultiNetData();
                if (this.cLE.aGg().aGI().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.cLR();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.goY && !TextUtils.isEmpty(this.jla)) {
            GN(this.jla);
            this.goY = false;
            this.jla = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GO(String str) {
        if (!StringUtils.isNull(str)) {
            this.jkS = true;
            this.jkU.setText(str);
            this.jkT.setClickable(false);
            this.jkV.setVisibility(8);
        }
    }
}
