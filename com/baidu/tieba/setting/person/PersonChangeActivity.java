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
    private View ccA;
    private Boolean ccz = false;
    private final WriteImagesInfo aHL = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView bhl = null;
    private LinearLayout axr = null;
    private ScrollView ccB = null;
    private TextView ccC = null;
    private LinearLayout ccD = null;
    private TextView ccE = null;
    private LinearLayout ccF = null;
    private TextView aHo = null;
    private EditText mEdit = null;
    private LinearLayout ccG = null;
    private TextView ccH = null;
    private TextView ccI = null;
    private TextView ccJ = null;
    private InputMethodManager mInputManager = null;
    private boolean ccK = false;
    private com.baidu.tbadk.coreExtra.c.f ccL = null;
    protected HeadImageView ccM = null;
    private com.baidu.adp.widget.a.a baZ = null;
    private p ccN = null;
    private q ccO = null;
    private ProgressBar avZ = null;
    private DialogInterface.OnCancelListener ccP = null;
    private com.baidu.tbadk.core.dialog.a ccQ = null;
    private com.baidu.tbadk.core.dialog.e ccR = null;
    private boolean bPo = false;
    private int mSex = 0;
    private final int ccS = 50;
    private final View.OnClickListener ccT = new a(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(w.person_change_activity);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        l(bundle);
        Ek();
        if (bundle != null) {
            this.ccz = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.ccz = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ccN != null) {
            this.ccN.cancel();
        }
        if (this.ccO != null) {
            this.ccO.cancel();
        }
        if (this.avZ != null) {
            this.avZ.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.ccK = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.ccK) {
            aij();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aij() {
        if (this.mEdit.getVisibility() == 0) {
            this.ccG.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.aHo.setText(replaceAll);
            } else {
                this.aHo.setText(getPageContext().getString(y.add_intro));
            }
            if (this.ccL.vX().getIntro() == null || !this.ccL.vX().getIntro().equals(replaceAll)) {
                this.bPo = true;
            }
            this.ccL.vX().setIntro(replaceAll);
            this.aHo.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aik() {
        if (this.mEdit.getVisibility() != 0) {
            this.aHo.setVisibility(8);
            this.mEdit.setText(this.ccL.vX().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            hZ(300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hZ(int i) {
        this.ccB.postDelayed(new h(this), i);
    }

    private void l(Bundle bundle) {
        PersonChangeData personChangeData;
        this.ccP = new i(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.ccL = new com.baidu.tbadk.coreExtra.c.f(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ail() {
        BitmapDrawable bitmapDrawable;
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) ba.getDrawable(u.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) ba.getDrawable(u.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.ccE.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().X(i == 1);
        getLayoutMode().h(this.axr);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.ccM.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.ccL.vX());
    }

    private void Ek() {
        this.ccM = (HeadImageView) findViewById(v.photo);
        this.ccM.setIsRound(false);
        this.ccM.setAutoChangeStyle(true);
        this.ccM.setDrawBorder(false);
        this.ccM.setOnClickListener(new j(this));
        this.baZ = com.baidu.tbadk.imageManager.e.zy().et(this.ccL.vX().getPortrait());
        this.ccM.c(this.ccL.vX().getPortrait(), 12, false);
        this.axr = (LinearLayout) findViewById(v.parent);
        this.ccB = (ScrollView) findViewById(v.person_change_scroll);
        this.ccD = (LinearLayout) findViewById(v.person_sex);
        this.ccE = (TextView) findViewById(v.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ccT);
        this.mNavigationBar.setTitleText(getResources().getString(y.my_info));
        this.ccA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.navigation_right_button_layout, (View.OnClickListener) null);
        this.bhl = (TextView) this.ccA.findViewById(v.right_textview);
        this.bhl.setText(getPageContext().getString(y.save));
        this.ccA.setEnabled(false);
        ba.b(this.bhl, s.navi_op_text, 1);
        this.ccA.setOnClickListener(new k(this));
        this.ccD.setOnClickListener(new l(this));
        this.ccF = (LinearLayout) findViewById(v.intro_click);
        this.ccF.setOnClickListener(new m(this));
        this.ccF.setOnTouchListener(new n(this));
        this.ccC = (TextView) findViewById(v.nick_name_show);
        this.ccC.setText(this.ccL.vX().getName());
        this.aHo = (TextView) findViewById(v.intro);
        if (this.ccL.vX().getIntro() != null && this.ccL.vX().getIntro().length() > 0) {
            this.aHo.setText(this.ccL.vX().getIntro());
        } else {
            this.aHo.setText(getPageContext().getString(y.add_intro));
        }
        this.mEdit = (EditText) findViewById(v.edit);
        this.mEdit.setText(this.ccL.vX().getIntro());
        this.mEdit.setOnFocusChangeListener(new o(this));
        this.mEdit.setOnTouchListener(new b(this));
        this.mEdit.setOnClickListener(new c(this));
        this.mEdit.addTextChangedListener(new d(this));
        if (this.ccL.vX().getSex() == 1) {
            this.mSex = 1;
            this.ccE.setText(y.man);
        } else if (this.ccL.vX().getSex() == 2) {
            this.mSex = 2;
            this.ccE.setText(y.woman);
        } else {
            this.ccE.setText(y.change_sex);
        }
        this.ccG = (LinearLayout) findViewById(v.intro_text_tip);
        this.ccH = (TextView) findViewById(v.intro_text_tip_num);
        this.ccI = (TextView) findViewById(v.intro_text_tip_divider);
        this.ccJ = (TextView) findViewById(v.intro_text_tip_limit);
        ail();
        this.avZ = (ProgressBar) findViewById(v.image_progress);
        this.ccQ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.ccQ.ca(getPageContext().getString(y.confirm_giveup));
        this.ccQ.a(getPageContext().getString(y.alert_yes_button), new e(this));
        this.ccQ.b(getPageContext().getString(y.cancel), new f(this));
        this.ccQ.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aim() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = ba.getColor(s.person_change_up_limit_text);
        } else {
            color = ba.getColor(s.person_change_not_up_limit_text);
        }
        ia(color);
    }

    private void ia(int i) {
        this.ccH.setTextColor(i);
        this.ccI.setTextColor(i);
        this.ccJ.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ain() {
        if (this.ccL != null && this.ccL.vX() != null) {
            aij();
            this.ccL.vX().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.ccL.vX().setSex(this.mSex);
            if (this.ccO == null) {
                this.ccO = new q(this, this.ccL);
                this.ccO.setPriority(3);
                this.ccO.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aio() {
        if (this.ccR == null) {
            this.ccR = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
            String string = getPageContext().getString(y.man);
            String string2 = getPageContext().getString(y.woman);
            this.ccR.by(y.choose_sex);
            this.ccR.a(new String[]{string, string2}, new g(this, string, string2));
            this.ccR.d(getPageContext());
        }
        this.ccR.rg();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aij();
            this.ccT.onClick(null);
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
                    this.ccL.vX().setPhotoChanged(true);
                    aip();
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
            this.aHL.parseJson(stringExtra);
            this.aHL.updateQuality();
            if (this.aHL.getChosedFiles() != null && this.aHL.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.aHL.getChosedFiles().get(0).getFilePath())));
            }
            this.aHL.clear();
        }
    }

    private void J(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj())));
    }

    private void aip() {
        if (this.ccN != null) {
            this.ccN.cancel();
        }
        this.baZ = null;
        this.ccN = new p(this, null);
        this.ccN.execute(new Object[0]);
    }
}
