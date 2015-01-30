package com.baidu.tieba.person;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private Boolean bHr = false;
    private WriteImagesInfo aql = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView bfI = null;
    private LinearLayout mParent = null;
    private ScrollView bHs = null;
    private TextView bHt = null;
    private LinearLayout bHu = null;
    private TextView bHv = null;
    private LinearLayout bHw = null;
    private TextView ayW = null;
    private EditText mEdit = null;
    private LinearLayout bHx = null;
    private TextView bHy = null;
    private TextView bHz = null;
    private TextView bHA = null;
    private InputMethodManager mInputManager = null;
    private boolean bHB = false;
    private com.baidu.tbadk.coreExtra.c.f bHC = null;
    protected HeadImageView bHD = null;
    private com.baidu.adp.widget.a.a aWC = null;
    private ai bHE = null;
    private aj bHF = null;
    private ProgressBar anT = null;
    private DialogInterface.OnCancelListener bHG = null;
    private Dialog bHH = null;
    private Dialog bHI = null;
    private boolean PH = false;
    private int mSex = 0;
    private final int bHJ = 50;
    private View.OnClickListener bHK = new t(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(PersonChangeActivityConfig.class, PersonChangeActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.x.person_change_activity);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        h(bundle);
        InitUI();
        if (bundle != null) {
            this.bHr = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.bHr = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bHE != null) {
            this.bHE.cancel();
        }
        if (this.bHF != null) {
            this.bHF.cancel();
        }
        if (this.anT != null) {
            this.anT.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.bHB = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.bHB) {
            aaP();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaP() {
        if (this.mEdit.getVisibility() == 0) {
            this.bHx.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.ayW.setText(replaceAll);
            } else {
                this.ayW.setText(getPageContext().getString(com.baidu.tieba.z.add_intro));
            }
            if (this.bHC.sB().getIntro() == null || !this.bHC.sB().getIntro().equals(replaceAll)) {
                this.PH = true;
            }
            this.bHC.sB().setIntro(replaceAll);
            this.ayW.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaQ() {
        if (this.mEdit.getVisibility() != 0) {
            this.ayW.setVisibility(8);
            this.mEdit.setText(this.bHC.sB().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            hp(300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hp(int i) {
        this.bHs.postDelayed(new aa(this), i);
    }

    private void h(Bundle bundle) {
        PersonChangeData personChangeData;
        this.bHG = new ab(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.bHC = new com.baidu.tbadk.coreExtra.c.f(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaR() {
        BitmapDrawable bitmapDrawable;
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.bHv.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bHD.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.bHC.sB());
    }

    private void InitUI() {
        this.bHD = (HeadImageView) findViewById(com.baidu.tieba.w.photo);
        this.bHD.setIsRound(false);
        this.bHD.setAutoChangeStyle(true);
        this.bHD.setDrawBorder(false);
        this.bHD.setOnClickListener(new ac(this));
        this.aWC = com.baidu.tbadk.imageManager.e.we().em(this.bHC.sB().getPortrait());
        this.bHD.d(this.bHC.sB().getPortrait(), 12, false);
        this.mParent = (LinearLayout) findViewById(com.baidu.tieba.w.parent);
        this.bHs = (ScrollView) findViewById(com.baidu.tieba.w.person_change_scroll);
        this.bHu = (LinearLayout) findViewById(com.baidu.tieba.w.person_sex);
        this.bHv = (TextView) findViewById(com.baidu.tieba.w.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bHK);
        this.mNavigationBar.setTitleText(getResources().getString(com.baidu.tieba.z.my_info));
        this.bfI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.z.save));
        this.bfI.setEnabled(false);
        this.bfI.setOnClickListener(new ad(this));
        this.bHu.setOnClickListener(new ae(this));
        this.bHw = (LinearLayout) findViewById(com.baidu.tieba.w.intro_click);
        this.bHw.setOnClickListener(new af(this));
        this.bHw.setOnTouchListener(new ag(this));
        this.bHt = (TextView) findViewById(com.baidu.tieba.w.nick_name_show);
        this.bHt.setText(this.bHC.sB().getName());
        this.ayW = (TextView) findViewById(com.baidu.tieba.w.intro);
        if (this.bHC.sB().getIntro() != null && this.bHC.sB().getIntro().length() > 0) {
            this.ayW.setText(this.bHC.sB().getIntro());
        } else {
            this.ayW.setText(getPageContext().getString(com.baidu.tieba.z.add_intro));
        }
        this.mEdit = (EditText) findViewById(com.baidu.tieba.w.edit);
        this.mEdit.setText(this.bHC.sB().getIntro());
        this.mEdit.setOnFocusChangeListener(new ah(this));
        this.mEdit.setOnTouchListener(new u(this));
        this.mEdit.setOnClickListener(new v(this));
        this.mEdit.addTextChangedListener(new w(this));
        if (this.bHC.sB().getSex() == 1) {
            this.mSex = 1;
            this.bHv.setText(com.baidu.tieba.z.man);
        } else if (this.bHC.sB().getSex() == 2) {
            this.mSex = 2;
            this.bHv.setText(com.baidu.tieba.z.woman);
        } else {
            this.bHv.setText(com.baidu.tieba.z.change_sex);
        }
        this.bHx = (LinearLayout) findViewById(com.baidu.tieba.w.intro_text_tip);
        this.bHy = (TextView) findViewById(com.baidu.tieba.w.intro_text_tip_num);
        this.bHz = (TextView) findViewById(com.baidu.tieba.w.intro_text_tip_divider);
        this.bHA = (TextView) findViewById(com.baidu.tieba.w.intro_text_tip_limit);
        aaR();
        this.anT = (ProgressBar) findViewById(com.baidu.tieba.w.image_progress);
        AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
        builder.setMessage(getPageContext().getString(com.baidu.tieba.z.confirm_giveup));
        builder.setPositiveButton(getPageContext().getString(com.baidu.tieba.z.alert_yes_button), new x(this));
        builder.setNeutralButton(getPageContext().getString(com.baidu.tieba.z.cancel), new y(this));
        this.bHH = builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaS() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.person_change_up_limit_text);
        } else {
            color = com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.person_change_not_up_limit_text);
        }
        hq(color);
    }

    private void hq(int i) {
        this.bHy.setTextColor(i);
        this.bHz.setTextColor(i);
        this.bHA.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaT() {
        if (this.bHC != null && this.bHC.sB() != null) {
            aaP();
            this.bHC.sB().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.bHC.sB().setSex(this.mSex);
            if (this.bHF == null) {
                this.bHF = new aj(this, this.bHC);
                this.bHF.setPriority(3);
                this.bHF.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaU() {
        if (this.bHI == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
            String string = getPageContext().getString(com.baidu.tieba.z.man);
            String string2 = getPageContext().getString(com.baidu.tieba.z.woman);
            builder.setTitle(com.baidu.tieba.z.choose_sex);
            builder.setItems(new String[]{string, string2}, new z(this, string, string2));
            this.bHI = builder.create();
            this.bHI.setCanceledOnTouchOutside(true);
        }
        com.baidu.adp.lib.g.k.a(this.bHI, getPageContext());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aaP();
            this.bHK.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12002:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            K(intent);
                            return;
                        } else {
                            U(intent);
                            return;
                        }
                    }
                    return;
                case 12009:
                case 12010:
                    this.bHC.sB().setPhotoChanged(true);
                    aaV();
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12010:
                    com.baidu.tbadk.core.util.bb.a(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    private void U(Intent intent) {
        String stringExtra;
        if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
            this.aql.parseJson(stringExtra);
            this.aql.updateQuality();
            if (this.aql.getChosedFiles() != null && this.aql.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.aql.getChosedFiles().get(0).getFilePath())));
            }
            this.aql.clear();
        }
    }

    private void K(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj())));
    }

    private void aaV() {
        if (this.bHE != null) {
            this.bHE.cancel();
        }
        this.aWC = null;
        this.bHE = new ai(this, null);
        this.bHE.execute(new Object[0]);
    }
}
