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
    private Boolean bHq = false;
    private WriteImagesInfo aqi = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView bfH = null;
    private LinearLayout mParent = null;
    private ScrollView bHr = null;
    private TextView bHs = null;
    private LinearLayout bHt = null;
    private TextView bHu = null;
    private LinearLayout bHv = null;
    private TextView ayT = null;
    private EditText mEdit = null;
    private LinearLayout bHw = null;
    private TextView bHx = null;
    private TextView bHy = null;
    private TextView bHz = null;
    private InputMethodManager mInputManager = null;
    private boolean bHA = false;
    private com.baidu.tbadk.coreExtra.c.f bHB = null;
    protected HeadImageView bHC = null;
    private com.baidu.adp.widget.a.a aWB = null;
    private ai bHD = null;
    private aj bHE = null;
    private ProgressBar anQ = null;
    private DialogInterface.OnCancelListener bHF = null;
    private Dialog bHG = null;
    private Dialog bHH = null;
    private boolean PE = false;
    private int mSex = 0;
    private final int bHI = 50;
    private View.OnClickListener bHJ = new t(this);

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
            this.bHq = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.bHq = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bHD != null) {
            this.bHD.cancel();
        }
        if (this.bHE != null) {
            this.bHE.cancel();
        }
        if (this.anQ != null) {
            this.anQ.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.bHA = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.bHA) {
            aaK();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaK() {
        if (this.mEdit.getVisibility() == 0) {
            this.bHw.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.ayT.setText(replaceAll);
            } else {
                this.ayT.setText(getPageContext().getString(com.baidu.tieba.z.add_intro));
            }
            if (this.bHB.sv().getIntro() == null || !this.bHB.sv().getIntro().equals(replaceAll)) {
                this.PE = true;
            }
            this.bHB.sv().setIntro(replaceAll);
            this.ayT.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaL() {
        if (this.mEdit.getVisibility() != 0) {
            this.ayT.setVisibility(8);
            this.mEdit.setText(this.bHB.sv().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            hp(300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hp(int i) {
        this.bHr.postDelayed(new aa(this), i);
    }

    private void h(Bundle bundle) {
        PersonChangeData personChangeData;
        this.bHF = new ab(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.bHB = new com.baidu.tbadk.coreExtra.c.f(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaM() {
        BitmapDrawable bitmapDrawable;
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.bc.getDrawable(com.baidu.tieba.v.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.bHu.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bHC.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.bHB.sv());
    }

    private void InitUI() {
        this.bHC = (HeadImageView) findViewById(com.baidu.tieba.w.photo);
        this.bHC.setIsRound(false);
        this.bHC.setAutoChangeStyle(true);
        this.bHC.setDrawBorder(false);
        this.bHC.setOnClickListener(new ac(this));
        this.aWB = com.baidu.tbadk.imageManager.e.vY().ej(this.bHB.sv().getPortrait());
        this.bHC.d(this.bHB.sv().getPortrait(), 12, false);
        this.mParent = (LinearLayout) findViewById(com.baidu.tieba.w.parent);
        this.bHr = (ScrollView) findViewById(com.baidu.tieba.w.person_change_scroll);
        this.bHt = (LinearLayout) findViewById(com.baidu.tieba.w.person_sex);
        this.bHu = (TextView) findViewById(com.baidu.tieba.w.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bHJ);
        this.mNavigationBar.setTitleText(getResources().getString(com.baidu.tieba.z.my_info));
        this.bfH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.z.save));
        this.bfH.setEnabled(false);
        this.bfH.setOnClickListener(new ad(this));
        this.bHt.setOnClickListener(new ae(this));
        this.bHv = (LinearLayout) findViewById(com.baidu.tieba.w.intro_click);
        this.bHv.setOnClickListener(new af(this));
        this.bHv.setOnTouchListener(new ag(this));
        this.bHs = (TextView) findViewById(com.baidu.tieba.w.nick_name_show);
        this.bHs.setText(this.bHB.sv().getName());
        this.ayT = (TextView) findViewById(com.baidu.tieba.w.intro);
        if (this.bHB.sv().getIntro() != null && this.bHB.sv().getIntro().length() > 0) {
            this.ayT.setText(this.bHB.sv().getIntro());
        } else {
            this.ayT.setText(getPageContext().getString(com.baidu.tieba.z.add_intro));
        }
        this.mEdit = (EditText) findViewById(com.baidu.tieba.w.edit);
        this.mEdit.setText(this.bHB.sv().getIntro());
        this.mEdit.setOnFocusChangeListener(new ah(this));
        this.mEdit.setOnTouchListener(new u(this));
        this.mEdit.setOnClickListener(new v(this));
        this.mEdit.addTextChangedListener(new w(this));
        if (this.bHB.sv().getSex() == 1) {
            this.mSex = 1;
            this.bHu.setText(com.baidu.tieba.z.man);
        } else if (this.bHB.sv().getSex() == 2) {
            this.mSex = 2;
            this.bHu.setText(com.baidu.tieba.z.woman);
        } else {
            this.bHu.setText(com.baidu.tieba.z.change_sex);
        }
        this.bHw = (LinearLayout) findViewById(com.baidu.tieba.w.intro_text_tip);
        this.bHx = (TextView) findViewById(com.baidu.tieba.w.intro_text_tip_num);
        this.bHy = (TextView) findViewById(com.baidu.tieba.w.intro_text_tip_divider);
        this.bHz = (TextView) findViewById(com.baidu.tieba.w.intro_text_tip_limit);
        aaM();
        this.anQ = (ProgressBar) findViewById(com.baidu.tieba.w.image_progress);
        AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
        builder.setMessage(getPageContext().getString(com.baidu.tieba.z.confirm_giveup));
        builder.setPositiveButton(getPageContext().getString(com.baidu.tieba.z.alert_yes_button), new x(this));
        builder.setNeutralButton(getPageContext().getString(com.baidu.tieba.z.cancel), new y(this));
        this.bHG = builder.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaN() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.person_change_up_limit_text);
        } else {
            color = com.baidu.tbadk.core.util.bc.getColor(com.baidu.tieba.t.person_change_not_up_limit_text);
        }
        hq(color);
    }

    private void hq(int i) {
        this.bHx.setTextColor(i);
        this.bHy.setTextColor(i);
        this.bHz.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaO() {
        if (this.bHB != null && this.bHB.sv() != null) {
            aaK();
            this.bHB.sv().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.bHB.sv().setSex(this.mSex);
            if (this.bHE == null) {
                this.bHE = new aj(this, this.bHB);
                this.bHE.setPriority(3);
                this.bHE.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aaP() {
        if (this.bHH == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
            String string = getPageContext().getString(com.baidu.tieba.z.man);
            String string2 = getPageContext().getString(com.baidu.tieba.z.woman);
            builder.setTitle(com.baidu.tieba.z.choose_sex);
            builder.setItems(new String[]{string, string2}, new z(this, string, string2));
            this.bHH = builder.create();
            this.bHH.setCanceledOnTouchOutside(true);
        }
        com.baidu.adp.lib.g.k.a(this.bHH, getPageContext());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aaK();
            this.bHJ.onClick(null);
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
                    this.bHB.sv().setPhotoChanged(true);
                    aaQ();
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
            this.aqi.parseJson(stringExtra);
            this.aqi.updateQuality();
            if (this.aqi.getChosedFiles() != null && this.aqi.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.aqi.getChosedFiles().get(0).getFilePath())));
            }
            this.aqi.clear();
        }
    }

    private void K(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj())));
    }

    private void aaQ() {
        if (this.bHD != null) {
            this.bHD.cancel();
        }
        this.aWB = null;
        this.bHD = new ai(this, null);
        this.bHD.execute(new Object[0]);
    }
}
