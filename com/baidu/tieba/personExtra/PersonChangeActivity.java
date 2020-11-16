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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.q;
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
/* loaded from: classes23.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private View etA;
    private ImageView etz;
    private com.baidu.tbadk.coreExtra.view.b fbf;
    private View lZN;
    private TextView lZO;
    private View lZP;
    private View lZQ;
    private View lZR;
    private ImageView lZS;
    private com.baidu.tbadk.core.dialog.a lZT;
    private String lZU;
    private LinearLayout lZV;
    private TextView lZW;
    private TextView lZX;
    private RelativeLayout lZY;
    private TextView lZZ;
    private View lZs;
    private PermissionJudgePolicy mPermissionJudgement;
    private TextView maa;
    public final int lZq = 90;
    private Boolean lZr = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView kjp = null;
    private LinearLayout iyc = null;
    private ScrollView lZt = null;
    private TextView lZu = null;
    private RelativeLayout lZv = null;
    private TextView lZw = null;
    private LinearLayout lZx = null;
    private TextView gwO = null;
    private EditText lZy = null;
    private LinearLayout lZz = null;
    private TextView lZA = null;
    private TextView lZB = null;
    private TextView lZC = null;
    private InputMethodManager mInputManager = null;
    private boolean lZD = false;
    private PersonChangeModel lZE = null;
    protected HeadImageView iDq = null;
    private com.baidu.adp.widget.ImageView.a kbq = null;
    private a lZF = null;
    private b lZG = null;
    private ProgressBar lZH = null;
    private DialogInterface.OnCancelListener iyU = null;
    private com.baidu.tbadk.core.dialog.a kBW = null;
    private com.baidu.tbadk.core.dialog.i lZI = null;
    private boolean lZJ = false;
    private boolean jtO = false;
    private boolean lZK = false;
    private int mSex = 0;
    private final int lZL = 500;
    private boolean lZM = false;
    private boolean iIR = false;
    private final View.OnClickListener mab = new View.OnClickListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.lZE.dui().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.lZJ = true;
            }
            if (PersonChangeActivity.this.lZJ) {
                PersonChangeActivity.this.kBW.bog();
                return;
            }
            if (PersonChangeActivity.this.lZE != null && PersonChangeActivity.this.lZE.dui().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.lZr.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.lZE.dui());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.lZE.dui());
                }
                PersonChangeActivity.this.dug();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    };
    private CustomMessageListener iJQ = new CustomMessageListener(CmdConfigCustom.CMD_MODIFY_NICKNAME_SUCCEED) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str)) {
                        PersonChangeActivity.this.iIR = true;
                        PersonChangeActivity.this.lZU = str;
                    }
                }
            }
        }
    };
    private CustomMessageListener mad = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_PERSON_CHANGE_MEMBER) { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (PersonChangeActivity.this.lZE != null && PersonChangeActivity.this.lZE.dui() != null && personChangeData != null) {
                    PersonChangeActivity.this.lZE.dui().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                    PersonChangeActivity.this.lZE.dui().setMem(personChangeData.getMen());
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
        aF(bundle);
        bIn();
        if (bundle != null) {
            this.lZr = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.lZr = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.iJQ);
        registerListener(this.mad);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iJQ);
        if (this.lZF != null) {
            this.lZF.cancel();
        }
        if (this.lZG != null) {
            this.lZG.cancel();
        }
        if (this.lZH != null) {
            this.lZH.setVisibility(8);
        }
        if (this.lZy != null) {
            this.lZy.addTextChangedListener(null);
        }
        if (this.fbf != null) {
            this.fbf.onDestroy();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (view == this.iDq || view == this.lZS) {
            if (this.lZE != null && this.lZE.mah != null && !this.lZE.mah.canModifyAvatar()) {
                if (!StringUtils.isNull(this.lZE.mah.getCantModifyAvatarDesc())) {
                    l.showLongToast(TbadkCoreApplication.getInst(), this.lZE.mah.getCantModifyAvatarDesc());
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
                dub();
            }
        } else if (view == this.lZs) {
            if (!this.jtO && !this.lZK) {
                finish();
            }
            if (this.lZr.booleanValue()) {
                TiebaStatic.log("c10100");
            } else {
                TiebaStatic.log("c10101");
            }
            if (this.jtO) {
                dud();
            } else if (this.lZK) {
                duh();
            }
        } else if (view == this.lZv) {
            due();
        } else if (view == this.lZx) {
            dtZ();
        } else if (view == this.lZy) {
            Hv(800);
        } else if (view == this.lZQ) {
            if (Build.VERSION.SDK_INT < 19) {
                showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
            } else if (NickNameActivitySwitch.isOn()) {
                dtX();
            } else {
                int nickNameLeftDays = this.lZE.dui().getNickNameLeftDays();
                if (this.lZE.dui().getMen() <= 0) {
                    if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                    } else if (nickNameLeftDays > 0 && nickNameLeftDays <= 2000) {
                        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                        aVar.AJ(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
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
                        aVar.b(getPageContext()).bog();
                    } else if (nickNameLeftDays > 2000) {
                        showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                    }
                } else if (nickNameLeftDays == 0) {
                    sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditNickNameActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_MODIFY_NICKNAME, 0, null)));
                } else {
                    showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                }
            }
        } else if (view == this.lZN) {
            if (this.lZE == null || this.lZE.dui() == null || StringUtils.isNull(this.lZE.dui().getName())) {
                i(TbadkCoreApplication.getCurrentAccountInfo());
            }
        } else if (view == this.lZY) {
            PersonConstellationActivity.a(getActivity(), this.lZE.dui().getBirthdayTime(), this.lZE.dui().getBirthdayShowStatus());
        }
    }

    private void dtX() {
        if (this.lZT == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            this.lZT = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.lZT.bg(inflate);
            this.lZT.a(R.string.nick_name_confirm, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.13
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, com.baidu.tieba.pb.c.dhr(), true)));
                    aVar.dismiss();
                }
            });
            this.lZT.b(R.string.nick_name_cancel, new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.14
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.lZT.b(getPageContext());
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), R.color.CAM_X0105);
            ap.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.lZT.bog();
    }

    private void i(AccountData accountData) {
        if (this.fbf == null) {
            this.fbf = new com.baidu.tbadk.coreExtra.view.b(this);
            this.fbf.a(new b.a() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.15
                @Override // com.baidu.tbadk.coreExtra.view.b.a
                public void g(AccountData accountData2) {
                    if (accountData2 != null) {
                        PersonChangeActivity.this.PV(accountData2.getAccount());
                    }
                }
            });
        }
        this.fbf.bxh();
        this.fbf.setAccountData(accountData);
        this.fbf.bxd();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.lZD = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.lZD) {
            dtY();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dtY() {
        if (this.lZy.getVisibility() == 0) {
            String replaceAll = this.lZy.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.gwO.setText(replaceAll);
            } else {
                this.gwO.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.lZE.dui().getIntro() == null || !this.lZE.dui().getIntro().equals(replaceAll)) {
                this.lZJ = true;
            }
            this.lZE.dui().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.lZy);
        }
    }

    private void dtZ() {
        if (this.lZy.getVisibility() != 0) {
            this.gwO.setVisibility(8);
            this.lZy.setText(this.lZE.dui().getIntro());
            this.lZy.setSelection(this.lZy.getText().length());
            this.lZy.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.lZy);
            Hv(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hv(int i) {
        this.lZt.postDelayed(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.16
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.lZt.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }, i);
    }

    private void aF(Bundle bundle) {
        this.iyU = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.17
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                PersonChangeActivity.this.destroyWaitingDialog();
                if (PersonChangeActivity.this.lZG != null) {
                    PersonChangeActivity.this.lZG.cancel();
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
        this.lZE = new PersonChangeModel(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        getLayoutMode().onModeChanged(this.iyc);
        SvgManager.bqB().a(this.etz, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.iDq.refresh();
        ap.setViewTextColor(this.lZO, R.color.CAM_X0109);
        WebPManager.a(this.lZS, R.drawable.icon_mask_personalba_edit40, (WebPManager.ResourceStateType) null);
        ap.setViewTextColor(this.kjp, R.color.CAM_X0302, 1);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.lZE.dui() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.lZE.dui()));
        }
    }

    private void bIn() {
        this.lZS = (ImageView) findViewById(R.id.photo_pop_icon);
        this.lZS.setOnClickListener(this);
        this.iDq = (HeadImageView) findViewById(R.id.photo);
        this.iDq.setOnClickListener(this);
        this.iDq.startLoad(q.Bk(this.lZE.dui().getPortrait()), 25, false);
        this.iyc = (LinearLayout) findViewById(R.id.parent);
        this.lZt = (ScrollView) findViewById(R.id.person_change_scroll);
        this.lZv = (RelativeLayout) findViewById(R.id.person_sex);
        this.lZw = (TextView) findViewById(R.id.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.etA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.mab);
        this.etz = (ImageView) this.etA.findViewById(R.id.widget_navi_back_button);
        this.etz.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        this.lZs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kjp = (TextView) this.lZs.findViewById(R.id.right_textview);
        this.kjp.setText(getPageContext().getString(R.string.save));
        ap.setViewTextColor(this.kjp, R.color.navi_op_text, 1);
        this.lZs.setOnClickListener(this);
        this.lZv.setOnClickListener(this);
        this.lZx = (LinearLayout) findViewById(R.id.intro_click);
        this.lZx.setOnClickListener(this);
        this.lZx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.lZD = true;
                    return false;
                }
                return false;
            }
        });
        this.lZu = (TextView) findViewById(R.id.nick_name_show);
        this.lZu.setText(this.lZE.dui().getNameShow());
        this.lZQ = findViewById(R.id.person_nickname);
        this.lZQ.setOnClickListener(this);
        this.lZR = findViewById(R.id.nick_name_more);
        dua();
        this.lZO = (TextView) findViewById(R.id.user_name_show);
        this.lZN = findViewById(R.id.person_name);
        this.lZP = findViewById(R.id.user_name_more_icon);
        this.lZN.setOnClickListener(this);
        if (StringUtils.isNull(this.lZE.dui().getName())) {
            this.lZO.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.lZM = false;
            this.lZN.setClickable(true);
            this.lZP.setVisibility(0);
        } else {
            this.lZO.setText(this.lZE.dui().getName());
            this.lZM = true;
            this.lZN.setClickable(false);
            this.lZP.setVisibility(8);
        }
        this.lZz = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.lZA = (TextView) findViewById(R.id.intro_text_tip_num);
        this.lZB = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.lZC = (TextView) findViewById(R.id.intro_text_tip_limit);
        this.gwO = (TextView) findViewById(R.id.intro);
        this.gwO.setVisibility(8);
        if (this.lZE.dui().getIntro() != null && this.lZE.dui().getIntro().length() > 0) {
            this.gwO.setText(this.lZE.dui().getIntro());
        } else {
            this.gwO.setText(getPageContext().getString(R.string.add_intro));
        }
        this.lZy = (EditText) findViewById(R.id.edit);
        this.lZy.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.lZy.setHintTextColor(ap.getColor(R.color.CAM_X0108));
        this.lZy.setCursorVisible(false);
        if (!au.isEmpty(this.lZE.dui().getIntro())) {
            this.lZy.setText(this.lZE.dui().getIntro());
            this.lZA.setText(this.lZE.dui().getIntro().length() + "");
        } else {
            this.lZA.setText("0");
        }
        this.lZz.setVisibility(0);
        this.lZy.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.19
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    PersonChangeActivity.this.dtY();
                }
            }
        });
        this.lZy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PersonChangeActivity.this.lZD = true;
                    PersonChangeActivity.this.lZy.setCursorVisible(true);
                    return false;
                }
                return false;
            }
        });
        this.lZy.setOnClickListener(this);
        this.lZy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Editable text = PersonChangeActivity.this.lZy.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                PersonChangeActivity.this.lZA.setText(String.valueOf(length));
                PersonChangeActivity.this.lZz.setVisibility(0);
                PersonChangeActivity.this.Hv(0);
                PersonChangeActivity.this.duc();
                if (length > 500) {
                    PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                    if (PersonChangeActivity.this.lZy.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.lZy.getSelectionStart() - 1 > PersonChangeActivity.this.lZy.getSelectionEnd()) {
                        PersonChangeActivity.this.lZy.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(PersonChangeActivity.this.lZy.getSelectionStart() - 1, PersonChangeActivity.this.lZy.getSelectionEnd());
                        PersonChangeActivity.this.lZy.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd <= length2) {
                        length2 = selectionEnd;
                    }
                    Selection.setSelection(PersonChangeActivity.this.lZy.getText(), length2);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.lZE.dui().getIntro())) {
                    PersonChangeActivity.this.jtO = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(PersonChangeActivity.this.kjp, R.color.navi_op_text, 1);
                    } else {
                        ap.setViewTextColor(PersonChangeActivity.this.kjp, R.color.CAM_X0302, 1);
                    }
                }
            }
        });
        if (this.lZE.dui().getSex() == 1) {
            this.mSex = 1;
            this.lZw.setText(R.string.male);
        } else if (this.lZE.dui().getSex() == 2) {
            this.mSex = 2;
            this.lZw.setText(R.string.female);
        } else {
            this.lZw.setText(R.string.change_sex);
        }
        this.lZH = (ProgressBar) findViewById(R.id.image_progress);
        this.kBW = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.kBW.AJ(getPageContext().getString(R.string.confirm_giveup));
        this.kBW.a(getPageContext().getString(R.string.alert_yes_button), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                PersonChangeActivity.this.dud();
            }
        });
        this.kBW.b(getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.5
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
                if (PersonChangeActivity.this.lZE.dui().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.lZr.booleanValue()) {
                        intent.putExtra("person_change_data", PersonChangeActivity.this.lZE.dui());
                    } else {
                        intent.putExtra("data", PersonChangeActivity.this.lZE.dui());
                    }
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.dug();
                }
                PersonChangeActivity.this.finish();
            }
        });
        this.kBW.b(getPageContext());
        this.lZV = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.lZW = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.lZE.dui().getAlaId() > 0) {
            this.lZV.setVisibility(0);
            this.lZW.setText(this.lZE.dui().getAlaId() + "");
        }
        this.lZX = (TextView) findViewById(R.id.person_forum_age_show);
        this.lZX.setText(getResources().getString(R.string.person_forum_age_suffix, this.lZE.dui().getForumAge()));
        this.lZY = (RelativeLayout) findViewById(R.id.person_constellation);
        this.lZY.setOnClickListener(this);
        this.lZZ = (TextView) findViewById(R.id.constellation_txt);
        this.maa = (TextView) findViewById(R.id.age_txt);
        if (this.lZE.dui().getBirthdayTime() != 0) {
            this.lZZ.setText(au.p(new Date(this.lZE.dui().getBirthdayTime() * 1000)));
        }
        if (this.lZE.dui().getUserAge() > 0 && this.lZE.dui().getBirthdayShowStatus() == 2) {
            this.maa.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.lZE.dui().getUserAge())));
            this.maa.setVisibility(0);
        } else {
            this.maa.setVisibility(8);
        }
        this.lZt.post(new Runnable() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                PersonChangeActivity.this.lZt.scrollTo(0, 0);
            }
        });
    }

    private void dua() {
        if (NickNameActivitySwitch.isOn() || this.lZE.dui().getNickNameLeftDays() == 0) {
            this.lZR.setVisibility(0);
        } else {
            this.lZR.setVisibility(8);
        }
    }

    public void dub() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(getPageContext().getPageActivity());
        bVar.ox(R.string.operation);
        bVar.a(strArr, new b.InterfaceC0574b() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.7
            @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0574b
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
        bVar.boi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duc() {
        int color;
        if (this.lZy.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = ap.getColor(R.color.common_color_10159);
        } else {
            color = ap.getColor(R.color.common_color_10077);
        }
        Hw(color);
    }

    private void Hw(int i) {
        this.lZA.setTextColor(i);
        this.lZB.setTextColor(i);
        this.lZC.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dud() {
        if (this.lZE != null && this.lZE.dui() != null) {
            dtY();
            if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                showToast(R.string.neterror);
                return;
            }
            this.lZE.dui().setIntro(this.lZy.getText().toString().replaceAll("\\s*", ""));
            this.lZE.dui().setSex(this.mSex);
            if (this.lZG == null) {
                this.lZG = new b(this.lZE);
                this.lZG.setPriority(3);
                this.lZG.execute(new String[0]);
            }
        }
    }

    private void due() {
        if (this.lZI == null) {
            this.lZI = new com.baidu.tbadk.core.dialog.i(getPageContext());
            final String string = getPageContext().getString(R.string.male);
            final String string2 = getPageContext().getString(R.string.female);
            this.lZI.a(getString(R.string.choose_sex), new String[]{string, string2}, new k.c() { // from class: com.baidu.tieba.personExtra.PersonChangeActivity.8
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i, View view) {
                    if (PersonChangeActivity.this.lZI != null && PersonChangeActivity.this.lZI.isShowing()) {
                        PersonChangeActivity.this.lZI.dismiss();
                    }
                    if (view instanceof TextView) {
                        if (string.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 1;
                            PersonChangeActivity.this.lZw.setText(string);
                        } else if (string2.equals(((TextView) view).getText().toString())) {
                            PersonChangeActivity.this.mSex = 2;
                            PersonChangeActivity.this.lZw.setText(string2);
                        }
                        if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.lZE.dui().getSex()) {
                            PersonChangeActivity.this.jtO = true;
                            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                                ap.setViewTextColor(PersonChangeActivity.this.kjp, R.color.navi_op_text, 1);
                            } else {
                                ap.setViewTextColor(PersonChangeActivity.this.kjp, R.color.CAM_X0302, 1);
                            }
                        }
                    }
                }
            });
        }
        this.lZI.PA();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            dtY();
            this.mab.onClick(null);
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
                        if (longExtra != this.lZE.dui().getBirthdayTime() || intExtra != this.lZE.dui().getBirthdayShowStatus()) {
                            this.lZE.dui().setBirthdayShowStatus(intExtra);
                            this.lZE.dui().setBirthdayTime(longExtra);
                            this.lZJ = true;
                            this.jtO = true;
                            Date date = new Date(longExtra * 1000);
                            this.lZZ.setText(au.p(date));
                            if (this.lZE.dui().getBirthdayShowStatus() == 2) {
                                this.maa.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(r(date))));
                                this.maa.setVisibility(0);
                                return;
                            }
                            this.maa.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE /* 12002 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            ag(intent);
                            return;
                        } else {
                            Y(intent);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW /* 12009 */:
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    this.lZE.dui().setPhotoChanged(true);
                    duf();
                    this.jtO = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.kjp, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.kjp, R.color.CAM_X0302, 1);
                        return;
                    }
                case RequestResponseCode.REQUEST_SYSTEM_PHOTO_LIST /* 12014 */:
                    this.lZE.dui().setPhotoChanged(true);
                    if (intent != null) {
                        this.iDq.setImageBitmap(null);
                        this.iDq.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.jtO = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        ap.setViewTextColor(this.kjp, R.color.navi_op_text, 1);
                        return;
                    } else {
                        ap.setViewTextColor(this.kjp, R.color.CAM_X0302, 1);
                        return;
                    }
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case RequestResponseCode.REQUEST_CAMERA_VIEW /* 12010 */:
                    ao.g(getPageContext());
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

    private void PU(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.lZK = true;
            this.lZE.dui().setPhotoChanged(true);
            this.lZE.dui().setNameShow(str);
            this.lZE.dui().setNickNameLeftDays(90);
            this.lZu.setText(str);
            dua();
        }
    }

    private void Y(Intent intent) {
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

    private void ag(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.REQUEST_CAMERA, RequestResponseCode.REQUEST_CAMERA_VIEW, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void duf() {
        if (this.lZF != null) {
            this.lZF.cancel();
        }
        this.kbq = null;
        this.lZF = new a();
        this.lZF.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dug() {
        if (this.lZE != null && this.lZE.dui() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.lZE.dui()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.lZH.setVisibility(0);
            PersonChangeActivity.this.iDq.setImageDrawable(null);
            PersonChangeActivity.this.kbq = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public Bitmap doInBackground(Object... objArr) {
            return n.getImage(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.lZF = null;
            PersonChangeActivity.this.lZH.setVisibility(8);
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
            PersonChangeActivity.this.lZF = null;
            PersonChangeActivity.this.lZH.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.kbq = new com.baidu.adp.widget.ImageView.a(bitmap, false, (String) null);
                PersonChangeActivity.this.kbq.drawImageTo(PersonChangeActivity.this.iDq);
                com.baidu.tbadk.imageManager.c.bAt().a(PersonChangeActivity.this.lZE.dui().getPortrait(), PersonChangeActivity.this.kbq, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duh() {
        Intent intent = new Intent();
        if (this.lZr.booleanValue()) {
            intent.putExtra("person_change_data", this.lZE.dui());
        } else {
            intent.putExtra("data", this.lZE.dui());
        }
        setResult(-1, intent);
        dug();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private aa bZh = null;
        private PersonChangeModel lZE;

        public b(PersonChangeModel personChangeModel) {
            this.lZE = null;
            this.lZE = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.lZG = null;
            if (this.bZh != null) {
                this.bZh.cancelNetConnect();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.lZG = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.bZh != null) {
                if (this.bZh.bqa().bqI().isRequestSuccess()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.duh();
                } else {
                    PersonChangeActivity.this.showToast(this.bZh.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(R.string.saving), PersonChangeActivity.this.iyU);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.lZE != null) {
                this.bZh = new aa(TbConfig.SERVER_ADDRESS + "c/c/profile/modify");
                this.bZh.addPostData("sex", String.valueOf(this.lZE.dui().getSex()));
                this.bZh.addPostData("intro", this.lZE.dui().getIntro());
                this.bZh.addPostData("birthday_time", String.valueOf(this.lZE.dui().getBirthdayTime()));
                this.bZh.addPostData("birthday_show_status", String.valueOf(this.lZE.dui().getBirthdayShowStatus()));
                this.bZh.postMultiNetData();
                if (this.bZh.bqa().bqI().isRequestSuccess()) {
                    com.baidu.tieba.tbadkCore.util.a.dKM();
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iIR && !TextUtils.isEmpty(this.lZU)) {
            PU(this.lZU);
            this.iIR = false;
            this.lZU = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PV(String str) {
        if (!StringUtils.isNull(str)) {
            this.lZM = true;
            this.lZO.setText(str);
            this.lZN.setClickable(false);
            this.lZP.setVisibility(8);
        }
    }
}
