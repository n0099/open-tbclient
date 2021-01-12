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
import com.baidu.adp.lib.util.j;
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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.q;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.coreExtra.view.b;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import java.util.Calendar;
import java.util.Date;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private ImageView eFt;
    private View eFu;
    private com.baidu.tbadk.coreExtra.view.b fnD;
    private PermissionJudgePolicy mPermissionJudgement;
    private View moE;
    private TextView moF;
    private View moG;
    private View moH;
    private View moI;
    private ImageView moJ;
    private com.baidu.tbadk.core.dialog.a moK;
    private String moL;
    private LinearLayout moM;
    private TextView moN;
    private TextView moO;
    private RelativeLayout moP;
    private TextView moQ;
    private TextView moR;
    private View moh;
    public final int moe = 90;
    private Boolean mof = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView mog = null;
    private LinearLayout iQA = null;
    private ScrollView moi = null;
    private TextView moj = null;
    private RelativeLayout mok = null;
    private TextView mol = null;
    private LinearLayout mom = null;
    private TextView gMG = null;
    private EditText moo = null;
    private LinearLayout mop = null;
    private TextView moq = null;
    private TextView mor = null;
    private TextView mos = null;
    private InputMethodManager mInputManager = null;
    private boolean mot = false;
    private PersonChangeModel mou = null;
    protected HeadImageView iVO = null;
    private com.baidu.adp.widget.ImageView.a mov = null;
    private a mow = null;
    private b mox = null;
    private ProgressBar moy = null;
    private DialogInterface.OnCancelListener iRs = null;
    private com.baidu.tbadk.core.dialog.a kQq = null;
    private com.baidu.tbadk.core.dialog.i moz = null;
    private boolean moA = false;
    private boolean jQd = false;
    private boolean moB = false;
    private int mSex = 0;
    private final int moC = 500;
    private boolean moD = false;
    private boolean jbo = false;
    private final View.OnClickListener moS = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.mou.dvz().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.moA = true;
            }
            if (PersonChangeActivity.this.moA) {
                PersonChangeActivity.this.kQq.bqe();
                return;
            }
            if (PersonChangeActivity.this.mou != null && PersonChangeActivity.this.mou.dvz().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.mof.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.mou.dvz());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.mou.dvz());
                }
                PersonChangeActivity.this.dvx();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener jcp = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.jbo = true;
                        PersonChangeActivity.this.moL = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener moT = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.mou != null && PersonChangeActivity.this.mou.dvz() != null && personChangeData != null) {
                    PersonChangeActivity.this.mou.dvz().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.mou.dvz().setMem(personChangeData.getMen());
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
        aG(bundle);
        bKx();
        if (bundle != null) {
            this.mof = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.mof = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.jcp);
        registerListener(this.moT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jcp);
        if (this.mow != null) {
            this.mow.cancel();
        }
        if (this.mox != null) {
            this.mox.cancel();
        }
        if (this.moy != null) {
            this.moy.setVisibility(8);
        }
        if (this.moo != null) {
            this.moo.addTextChangedListener(null);
        }
        if (this.fnD != null) {
            this.fnD.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iVO || view == this.moJ) {
            if (this.mou != null && this.mou.moX != null && !this.mou.moX.canModifyAvatar()) {
                if (!StringUtils.isNull(this.mou.moX.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.mou.moX.getCantModifyAvatarDesc());
                    return;
                } else {
                    l.showLongToast(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
                    return;
                }
            }
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (!this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                dvs();
            }
        } else if (view == this.moh) {
            if (!this.jQd && !this.moB) {
                finish();
            }
            if (this.mof.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.jQd) {
                dvu();
            } else if (this.moB) {
                dvy();
            }
        } else if (view == this.mok) {
            dvv();
        } else if (view == this.mom) {
            dvq();
        } else if (view == this.moo) {
            Gz(800);
        } else if (view == this.moH) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                dvo();
            } else {
                int nickNameLeftDays = this.mou.dvz().getNickNameLeftDays();
                if (this.mou.dvz().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.Ad(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
                        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.1
                            @Override // com.baidu.tbadk.core.dialog.a.b
                            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                                if (j.isNetWorkAvailable()) {
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
                        aVar.b(getPageContext()).bqe();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.moE) {
            if (this.mou == null || this.mou.dvz() == null || StringUtils.isNull(this.mou.dvz().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.moP) {
            PersonConstellationActivity.a(getActivity(), this.mou.dvz().getBirthdayTime(), this.mou.dvz().getBirthdayShowStatus());
        }
    }

    private void dvo() {
        if (this.moK == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.moK = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.moK.br(inflate);
            this.moK.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.dix(), true)));
                    aVar.dismiss();
                }
            });
            this.moK.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.moK.b(getPageContext());
            ao.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), R.color.CAM_X0105);
            ao.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.moK.bqe();
    }

    private void i(AccountData accountData) {
        if (this.fnD == null) {
            this.fnD = new com.baidu.tbadk.coreExtra.view.b(this);
            this.fnD.a(new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.PB(accountData2.getAccount());
                    }
                }
            });
        }
        this.fnD.bzi();
        this.fnD.setAccountData(accountData);
        this.fnD.bze();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.mot = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.mot) {
            dvp();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvp() {
        if (this.moo.getVisibility() == 0) {
            String replaceAll = this.moo.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.gMG.setText(replaceAll);
            } else {
                this.gMG.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.mou.dvz().getIntro() == null || !this.mou.dvz().getIntro().equals(replaceAll)) {
                this.moA = true;
            }
            this.mou.dvz().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.moo);
        }
    }

    private void dvq() {
        if (this.moo.getVisibility() != 0) {
            this.gMG.setVisibility(8);
            this.moo.setText(this.mou.dvz().getIntro());
            this.moo.setSelection(this.moo.getText().length());
            this.moo.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.moo);
            Gz(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gz(int i) {
        this.moi.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.moi.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aG(Bundle bundle) {
        this.iRs = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.mox != null) {
                    PersonChangeActivity.this.mox.cancel();
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
        this.mou = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iQA);
        SvgManager.bsx().a(this.eFt, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iVO.refresh();
        ao.setViewTextColor(this.moF, R.color.CAM_X0109);
        WebPManager.a(this.moJ, R.drawable.icon_mask_personalba_edit40, (WebPManager.ResourceStateType) null);
        ao.setViewTextColor(this.mog, R.color.CAM_X0302, 1);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.mou.dvz() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.mou.dvz()));
        }
    }

    private void bKx() {
        this.moJ = (ImageView) findViewById(R.id.photo_pop_icon);
        this.moJ.setOnClickListener(this);
        this.iVO = (HeadImageView) findViewById(R.id.photo);
        this.iVO.setOnClickListener(this);
        this.iVO.startLoad(q.AE(this.mou.dvz().getPortrait()), 25, false);
        this.iQA = (LinearLayout) findViewById(R.id.parent);
        this.moi = (ScrollView) findViewById(R.id.person_change_scroll);
        this.mok = (RelativeLayout) findViewById(R.id.person_sex);
        this.mol = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.eFu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.moS);
        this.eFt = (ImageView) this.eFu.findViewById(R.id.widget_navi_back_button);
        this.eFt.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.moh = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.mog = (TextView) this.moh.findViewById(R.id.right_textview);
        this.mog.setText(getPageContext().getString(R.string.save));
        ao.setViewTextColor(this.mog, R.color.navi_op_text, 1);
        this.moh.setOnClickListener(this);
        this.mok.setOnClickListener(this);
        this.mom = (LinearLayout) findViewById(R.id.intro_click);
        this.mom.setOnClickListener(this);
        this.mom.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.mot = true;
                    return false;
                }
                return false;
            }
        });
        this.moj = (TextView) findViewById(R.id.nick_name_show);
        this.moj.setText(this.mou.dvz().getNameShow());
        this.moH = findViewById(R.id.person_nickname);
        this.moH.setOnClickListener(this);
        this.moI = findViewById(R.id.nick_name_more);
        dvr();
        this.moF = (TextView) findViewById(R.id.user_name_show);
        this.moE = findViewById(R.id.person_name);
        this.moG = findViewById(R.id.user_name_more_icon);
        this.moE.setOnClickListener(this);
        if (StringUtils.isNull(this.mou.dvz().getName())) {
            this.moF.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.moD = false;
            this.moE.setClickable(true);
            this.moG.setVisibility(0);
        } else {
            this.moF.setText(this.mou.dvz().getName());
            this.moD = true;
            this.moE.setClickable(false);
            this.moG.setVisibility(8);
        }
        this.mop = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.moq = (TextView) findViewById(R.id.intro_text_tip_num);
        this.mor = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.mos = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.gMG = (TextView) findViewById(R.id.intro);
        this.gMG.setVisibility(8);
        if (this.mou.dvz().getIntro() != null && this.mou.dvz().getIntro().length() > 0) {
            this.gMG.setText(this.mou.dvz().getIntro());
        } else {
            this.gMG.setText(getPageContext().getString(R.string.add_intro));
        }
        this.moo = (EditText) findViewById(R.id.edit);
        this.moo.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.moo.setHintTextColor(ao.getColor(R.color.CAM_X0108));
        this.moo.setCursorVisible(false);
        if (!at.isEmpty(this.mou.dvz().getIntro())) {
            this.moo.setText(this.mou.dvz().getIntro());
            this.moq.setText(this.mou.dvz().getIntro().length() + "");
        } else {
            this.moq.setText("0");
        }
        this.mop.setVisibility(0);
        this.moo.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.dvp();
                }
            }
        });
        this.moo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.mot = true;
                    PersonChangeActivity.this.moo.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.moo.setOnClickListener(this);
        this.moo.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.moo.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.moq.setText(String.valueOf(length));
                PersonChangeActivity.this.mop.setVisibility(0);
                PersonChangeActivity.this.Gz(0);
                PersonChangeActivity.this.dvt();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.moo.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.moo.getSelectionStart() - 1 > PersonChangeActivity.this.moo.getSelectionEnd()) {
                        PersonChangeActivity.this.moo.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.moo.getSelectionStart() - 1, PersonChangeActivity.this.moo.getSelectionEnd());
                        PersonChangeActivity.this.moo.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.moo.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.mou.dvz().getIntro())) {
                    PersonChangeActivity.this.jQd = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ao.setViewTextColor(PersonChangeActivity.this.mog, R.color.navi_op_text, 1);
                    } else {
                        ao.setViewTextColor(PersonChangeActivity.this.mog, R.color.CAM_X0302, 1);
                    }
                }
            }
        });
        if (this.mou.dvz().getSex() == 1) {
            this.mSex = 1;
            this.mol.setText(R.string.male);
        } else if (this.mou.dvz().getSex() == 2) {
            this.mSex = 2;
            this.mol.setText(R.string.female);
        } else {
            this.mol.setText(R.string.change_sex);
        }
        this.moy = (ProgressBar) findViewById(R.id.image_progress);
        this.kQq = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.kQq.Ad(getPageContext().getString(R.string.confirm_giveup));
        this.kQq.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.dvu();
            }
        });
        this.kQq.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.mou.dvz().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.mof.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.mou.dvz());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.mou.dvz());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.dvx();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.kQq.b(getPageContext());
        this.moM = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.moN = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.mou.dvz().getAlaId() > 0) {
            this.moM.setVisibility(0);
            this.moN.setText(this.mou.dvz().getAlaId() + "");
        }
        this.moO = (TextView) findViewById(R.id.person_forum_age_show);
        this.moO.setText(getResources().getString(R.string.person_forum_age_suffix, this.mou.dvz().getForumAge()));
        this.moP = (RelativeLayout) findViewById(R.id.person_constellation);
        this.moP.setOnClickListener(this);
        this.moQ = (TextView) findViewById(R.id.constellation_txt);
        this.moR = (TextView) findViewById(R.id.age_txt);
        if (this.mou.dvz().getBirthdayTime() != 0) {
            this.moQ.setText(at.p(new Date(this.mou.dvz().getBirthdayTime() * 1000)));
        }
        if (this.mou.dvz().getUserAge() > 0 && this.mou.dvz().getBirthdayShowStatus() == 2) {
            this.moR.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.mou.dvz().getUserAge())));
            this.moR.setVisibility(0);
        } else {
            this.moR.setVisibility(8);
        }
        this.moi.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.moi.scrollTo(0, 0);
            }
        });
    }

    private void dvr() {
        if (NickNameActivitySwitch.isOn() || this.mou.dvz().getNickNameLeftDays() == 0) {
            this.moI.setVisibility(0);
        } else {
            this.moI.setVisibility(8);
        }
    }

    public void dvs() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.nz(R.string.operation);
        bVar.a(strArr, new b.InterfaceC0561b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0561b
            public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                if (i == 0) {
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) PersonChangeActivity.this.getPageContext().getPageActivity(), PersonChangeActivity.this.mWriteImagesInfo.toJsonString(), true);
                    albumActivityConfig.setRequestCode(12002);
                    albumActivityConfig.setResourceType(2);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, albumActivityConfig));
                } else if (i == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChangeSystemPhotoActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST)));
                }
                bVar2.dismiss();
            }
        });
        bVar.d(getPageContext());
        bVar.bqg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvt() {
        int color;
        if (this.moo.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = ao.getColor(R.color.common_color_10159);
        } else {
            color = ao.getColor(R.color.common_color_10077);
        }
        GA(color);
    }

    private void GA(int i) {
        this.moq.setTextColor(i);
        this.mor.setTextColor(i);
        this.mos.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvu() {
        if (this.mou != null && this.mou.dvz() != null) {
            dvp();
            if (!j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.mou.dvz().setIntro(this.moo.getText().toString().replaceAll("\\s*", ""));
            this.mou.dvz().setSex(this.mSex);
            if (this.mox == null) {
                this.mox = new b(this.mou);
                this.mox.setPriority(3);
                this.mox.execute(new String[0]);
            }
        }
    }

    private void dvv() {
        if (this.moz == null) {
            this.moz = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.moz.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.moz != null && PersonChangeActivity.this.moz.isShowing()) {
                        PersonChangeActivity.this.moz.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.mol.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.mol.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.mou.dvz().getSex()) {
                            PersonChangeActivity.this.jQd = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                ao.setViewTextColor(PersonChangeActivity.this.mog, R.color.navi_op_text, 1);
                            } else {
                                ao.setViewTextColor(PersonChangeActivity.this.mog, R.color.CAM_X0302, 1);
                            }
                        }
                    }
                }
            });
        }
        this.moz.Pd();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            dvp();
            this.moS.onClick(null);
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
                        if (longExtra != this.mou.dvz().getBirthdayTime() || intExtra != this.mou.dvz().getBirthdayShowStatus()) {
                            this.mou.dvz().setBirthdayShowStatus(intExtra);
                            this.mou.dvz().setBirthdayTime(longExtra);
                            this.moA = true;
                            this.jQd = true;
                            Date date = new Date(longExtra * 1000);
                            this.moQ.setText(at.p(date));
                            if (this.mou.dvz().getBirthdayShowStatus() == 2) {
                                this.moR.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(r(date))));
                                this.moR.setVisibility(0);
                                return;
                            }
                            this.moR.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ag(intent);
                            return;
                        } else {
                            af(intent);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.mou.dvz().setPhotoChanged(true);
                    dvw();
                    this.jQd = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ao.setViewTextColor(this.mog, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ao.setViewTextColor(this.mog, R.color.CAM_X0302, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.mou.dvz().setPhotoChanged(true);
                    if (intent != null) {
                        this.iVO.setImageBitmap(null);
                        this.iVO.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.jQd = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ao.setViewTextColor(this.mog, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ao.setViewTextColor(this.mog, R.color.CAM_X0302, 1);
                        return;
                    }
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    an.g(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    public static int r(Date date) {
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

    private void PA(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.moB = true;
            this.mou.dvz().setPhotoChanged(true);
            this.mou.dvz().setNameShow(str);
            this.mou.dvz().setNickNameLeftDays(90);
            this.moj.setText(str);
            dvr();
        }
    }

    private void af(Intent intent) {
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
            if (this.mWriteImagesInfo.getChosedFiles() != null && this.mWriteImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.mWriteImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.mWriteImagesInfo.clear();
        }
    }

    private void ag(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, RequestResponseCode.REQUEST_CAMERA_VIEW, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void dvw() {
        if (this.mow != null) {
            this.mow.cancel();
        }
        this.mov = null;
        this.mow = new a();
        this.mow.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvx() {
        if (this.mou != null && this.mou.dvz() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.mou.dvz()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.moy.setVisibility(0);
            PersonChangeActivity.this.iVO.setImageDrawable(null);
            PersonChangeActivity.this.mov = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public Bitmap doInBackground(Object... objArr) {
            return n.getImage(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.mow = null;
            PersonChangeActivity.this.moy.setVisibility(8);
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
            PersonChangeActivity.this.mow = null;
            PersonChangeActivity.this.moy.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.mov = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.mov.drawImageTo(PersonChangeActivity.this.iVO);
                com.baidu.tbadk.imageManager.c.bCx().a(PersonChangeActivity.this.mou.dvz().getPortrait(), PersonChangeActivity.this.mov, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dvy() {
        Intent intent = new Intent();
        if (this.mof.booleanValue()) {
            intent.putExtra("person_change_data", this.mou.dvz());
        } else {
            intent.putExtra("data", this.mou.dvz());
        }
        setResult(-1, intent);
        dvx();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private z chV = null;
        private PersonChangeModel mou;

        public b(PersonChangeModel personChangeModel) {
            this.mou = null;
            this.mou = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.mox = null;
            if (this.chV != null) {
                this.chV.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.mox = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.chV != null) {
                if (this.chV.brX().bsH().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.dvy();
                } else {
                    PersonChangeActivity.this.showToast(this.chV.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.iRs);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.mou != null) {
                this.chV = new z(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.chV.addPostData("sex", String.valueOf(this.mou.dvz().getSex()));
                this.chV.addPostData("intro", this.mou.dvz().getIntro());
                this.chV.addPostData("birthday_time", String.valueOf(this.mou.dvz().getBirthdayTime()));
                this.chV.addPostData("birthday_show_status", String.valueOf(this.mou.dvz().getBirthdayShowStatus()));
                this.chV.postMultiNetData();
                if (this.chV.brX().bsH().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.dMk();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jbo && !TextUtils.isEmpty(this.moL)) {
            PA(this.moL);
            this.jbo = false;
            this.moL = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PB(String str) {
        if (!StringUtils.isNull(str)) {
            this.moD = true;
            this.moF.setText(str);
            this.moE.setClickable(false);
            this.moG.setVisibility(8);
        }
    }
}
