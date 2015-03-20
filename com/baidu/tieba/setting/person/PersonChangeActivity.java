package com.baidu.tieba.setting.person;

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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private View ccl;
    private Boolean cck = false;
    private final WriteImagesInfo aHD = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView bgV = null;
    private LinearLayout axj = null;
    private ScrollView ccm = null;
    private TextView ccn = null;
    private LinearLayout cco = null;
    private TextView ccp = null;
    private LinearLayout ccq = null;
    private TextView aHg = null;
    private EditText mEdit = null;
    private LinearLayout ccr = null;
    private TextView ccs = null;
    private TextView cct = null;
    private TextView ccu = null;
    private InputMethodManager mInputManager = null;
    private boolean ccv = false;
    private com.baidu.tbadk.coreExtra.c.f ccw = null;
    protected HeadImageView ccx = null;
    private com.baidu.adp.widget.a.a baJ = null;
    private p ccy = null;
    private q ccz = null;
    private ProgressBar avR = null;
    private DialogInterface.OnCancelListener ccA = null;
    private com.baidu.tbadk.core.dialog.a ccB = null;
    private com.baidu.tbadk.core.dialog.e ccC = null;
    private boolean bOY = false;
    private int mSex = 0;
    private final int ccD = 50;
    private final View.OnClickListener ccE = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.person_change_activity);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        l(bundle);
        Ee();
        if (bundle != null) {
            this.cck = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.cck = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ccy != null) {
            this.ccy.cancel();
        }
        if (this.ccz != null) {
            this.ccz.cancel();
        }
        if (this.avR != null) {
            this.avR.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.ccv = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.ccv) {
            ahU();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahU() {
        if (this.mEdit.getVisibility() == 0) {
            this.ccr.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.aHg.setText(replaceAll);
            } else {
                this.aHg.setText(getPageContext().getString(y.add_intro));
            }
            if (this.ccw.vR().getIntro() == null || !this.ccw.vR().getIntro().equals(replaceAll)) {
                this.bOY = true;
            }
            this.ccw.vR().setIntro(replaceAll);
            this.aHg.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahV() {
        if (this.mEdit.getVisibility() != 0) {
            this.aHg.setVisibility(8);
            this.mEdit.setText(this.ccw.vR().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            hW(300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hW(int i) {
        this.ccm.postDelayed(new h(this), i);
    }

    private void l(Bundle bundle) {
        PersonChangeData personChangeData;
        this.ccA = new i(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.ccw = new com.baidu.tbadk.coreExtra.c.f(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahW() {
        BitmapDrawable bitmapDrawable;
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) ba.getDrawable(u.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) ba.getDrawable(u.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.ccp.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.axj);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ccx.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.ccw.vR());
    }

    private void Ee() {
        this.ccx = (HeadImageView) findViewById(v.photo);
        this.ccx.setIsRound(false);
        this.ccx.setAutoChangeStyle(true);
        this.ccx.setDrawBorder(false);
        this.ccx.setOnClickListener(new j(this));
        this.baJ = com.baidu.tbadk.imageManager.e.zs().eq(this.ccw.vR().getPortrait());
        this.ccx.c(this.ccw.vR().getPortrait(), 12, false);
        this.axj = (LinearLayout) findViewById(v.parent);
        this.ccm = (ScrollView) findViewById(v.person_change_scroll);
        this.cco = (LinearLayout) findViewById(v.person_sex);
        this.ccp = (TextView) findViewById(v.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ccE);
        this.mNavigationBar.setTitleText(getResources().getString(y.my_info));
        this.ccl = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.navigation_right_button_layout, (View.OnClickListener) null);
        this.bgV = (TextView) this.ccl.findViewById(v.right_textview);
        this.bgV.setText(getPageContext().getString(y.save));
        this.ccl.setEnabled(false);
        ba.b(this.bgV, s.navi_op_text, 1);
        this.ccl.setOnClickListener(new k(this));
        this.cco.setOnClickListener(new l(this));
        this.ccq = (LinearLayout) findViewById(v.intro_click);
        this.ccq.setOnClickListener(new m(this));
        this.ccq.setOnTouchListener(new n(this));
        this.ccn = (TextView) findViewById(v.nick_name_show);
        this.ccn.setText(this.ccw.vR().getName());
        this.aHg = (TextView) findViewById(v.intro);
        if (this.ccw.vR().getIntro() != null && this.ccw.vR().getIntro().length() > 0) {
            this.aHg.setText(this.ccw.vR().getIntro());
        } else {
            this.aHg.setText(getPageContext().getString(y.add_intro));
        }
        this.mEdit = (EditText) findViewById(v.edit);
        this.mEdit.setText(this.ccw.vR().getIntro());
        this.mEdit.setOnFocusChangeListener(new o(this));
        this.mEdit.setOnTouchListener(new b(this));
        this.mEdit.setOnClickListener(new c(this));
        this.mEdit.addTextChangedListener(new d(this));
        if (this.ccw.vR().getSex() == 1) {
            this.mSex = 1;
            this.ccp.setText(y.man);
        } else if (this.ccw.vR().getSex() == 2) {
            this.mSex = 2;
            this.ccp.setText(y.woman);
        } else {
            this.ccp.setText(y.change_sex);
        }
        this.ccr = (LinearLayout) findViewById(v.intro_text_tip);
        this.ccs = (TextView) findViewById(v.intro_text_tip_num);
        this.cct = (TextView) findViewById(v.intro_text_tip_divider);
        this.ccu = (TextView) findViewById(v.intro_text_tip_limit);
        ahW();
        this.avR = (ProgressBar) findViewById(v.image_progress);
        this.ccB = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.ccB.ca(getPageContext().getString(y.confirm_giveup));
        this.ccB.a(getPageContext().getString(y.alert_yes_button), new e(this));
        this.ccB.b(getPageContext().getString(y.cancel), new f(this));
        this.ccB.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahX() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = ba.getColor(s.person_change_up_limit_text);
        } else {
            color = ba.getColor(s.person_change_not_up_limit_text);
        }
        hX(color);
    }

    private void hX(int i) {
        this.ccs.setTextColor(i);
        this.cct.setTextColor(i);
        this.ccu.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahY() {
        if (this.ccw != null && this.ccw.vR() != null) {
            ahU();
            this.ccw.vR().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.ccw.vR().setSex(this.mSex);
            if (this.ccz == null) {
                this.ccz = new q(this, this.ccw);
                this.ccz.setPriority(3);
                this.ccz.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ahZ() {
        if (this.ccC == null) {
            this.ccC = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
            String string = getPageContext().getString(y.man);
            String string2 = getPageContext().getString(y.woman);
            this.ccC.by(y.choose_sex);
            this.ccC.a(new String[]{string, string2}, new g(this, string, string2));
            this.ccC.d(getPageContext());
        }
        this.ccC.rg();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            ahU();
            this.ccE.onClick(null);
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
                            J(intent);
                            return;
                        } else {
                            I(intent);
                            return;
                        }
                    }
                    return;
                case 12009:
                case 12010:
                    this.ccw.vR().setPhotoChanged(true);
                    aia();
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12010:
                    az.d(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    private void I(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.aHD.parseJson(stringExtra);
            this.aHD.updateQuality();
            if (this.aHD.getChosedFiles() != null && this.aHD.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.aHD.getChosedFiles().get(0).getFilePath())));
            }
            this.aHD.clear();
        }
    }

    private void J(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj())));
    }

    private void aia() {
        if (this.ccy != null) {
            this.ccy.cancel();
        }
        this.baJ = null;
        this.ccy = new p(this, null);
        this.ccy.execute(new Object[0]);
    }
}
