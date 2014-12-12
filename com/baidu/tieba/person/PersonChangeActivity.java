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
    private Boolean bFG = false;
    private AlertDialog aAR = null;
    private WriteImagesInfo apq = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView ben = null;
    private LinearLayout mParent = null;
    private ScrollView bFH = null;
    private TextView bFI = null;
    private LinearLayout bFJ = null;
    private TextView bFK = null;
    private LinearLayout bFL = null;
    private TextView axW = null;
    private EditText mEdit = null;
    private LinearLayout bFM = null;
    private TextView bFN = null;
    private TextView bFO = null;
    private TextView bFP = null;
    private InputMethodManager mInputManager = null;
    private boolean bFQ = false;
    private com.baidu.tbadk.coreExtra.c.f bFR = null;
    protected HeadImageView bFS = null;
    private com.baidu.adp.widget.a.a aVj = null;
    private aj bFT = null;
    private ak bFU = null;
    private ProgressBar amY = null;
    private DialogInterface.OnCancelListener bFV = null;
    private Dialog bFW = null;
    private Dialog bFX = null;
    private boolean Pg = false;
    private int mSex = 0;
    private final int bFY = 50;
    private View.OnClickListener bFZ = new t(this);

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
            this.bFG = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.bFG = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bFT != null) {
            this.bFT.cancel();
        }
        if (this.bFU != null) {
            this.bFU.cancel();
        }
        if (this.amY != null) {
            this.amY.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.bFQ = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.bFQ) {
            aak();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aak() {
        if (this.mEdit.getVisibility() == 0) {
            this.bFM.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.axW.setText(replaceAll);
            } else {
                this.axW.setText(getPageContext().getString(com.baidu.tieba.z.add_intro));
            }
            if (this.bFR.sl().getIntro() == null || !this.bFR.sl().getIntro().equals(replaceAll)) {
                this.Pg = true;
            }
            this.bFR.sl().setIntro(replaceAll);
            this.axW.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aal() {
        if (this.mEdit.getVisibility() != 0) {
            this.axW.setVisibility(8);
            this.mEdit.setText(this.bFR.sl().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            hg(300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hg(int i) {
        this.bFH.postDelayed(new ab(this), i);
    }

    private void h(Bundle bundle) {
        PersonChangeData personChangeData;
        this.bFV = new ac(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.bFR = new com.baidu.tbadk.coreExtra.c.f(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aam() {
        BitmapDrawable bitmapDrawable;
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.ax.getDrawable(com.baidu.tieba.v.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.bFK.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bFS.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.bFR.sl());
    }

    private void InitUI() {
        String[] strArr = {getPageContext().getString(com.baidu.tieba.z.take_photo), getPageContext().getString(com.baidu.tieba.z.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
        builder.setTitle(getPageContext().getString(com.baidu.tieba.z.operation));
        builder.setItems(strArr, new ad(this));
        if (this.aAR == null) {
            this.aAR = builder.create();
        }
        this.bFS = (HeadImageView) findViewById(com.baidu.tieba.w.photo);
        this.bFS.setIsRound(false);
        this.bFS.setAutoChangeStyle(true);
        this.bFS.setDrawBorder(false);
        this.bFS.setOnClickListener(new ae(this));
        this.aVj = com.baidu.tbadk.imageManager.e.vL().em(this.bFR.sl().getPortrait());
        this.bFS.d(this.bFR.sl().getPortrait(), 12, false);
        this.mParent = (LinearLayout) findViewById(com.baidu.tieba.w.parent);
        this.bFH = (ScrollView) findViewById(com.baidu.tieba.w.person_change_scroll);
        this.bFJ = (LinearLayout) findViewById(com.baidu.tieba.w.person_sex);
        this.bFK = (TextView) findViewById(com.baidu.tieba.w.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bFZ);
        this.mNavigationBar.setTitleText(getResources().getString(com.baidu.tieba.z.my_info));
        this.ben = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(com.baidu.tieba.z.save));
        this.ben.setEnabled(false);
        this.ben.setOnClickListener(new af(this));
        this.bFJ.setOnClickListener(new ag(this));
        this.bFL = (LinearLayout) findViewById(com.baidu.tieba.w.intro_click);
        this.bFL.setOnClickListener(new ah(this));
        this.bFL.setOnTouchListener(new ai(this));
        this.bFI = (TextView) findViewById(com.baidu.tieba.w.nick_name_show);
        this.bFI.setText(this.bFR.sl().getName());
        this.axW = (TextView) findViewById(com.baidu.tieba.w.intro);
        if (this.bFR.sl().getIntro() != null && this.bFR.sl().getIntro().length() > 0) {
            this.axW.setText(this.bFR.sl().getIntro());
        } else {
            this.axW.setText(getPageContext().getString(com.baidu.tieba.z.add_intro));
        }
        this.mEdit = (EditText) findViewById(com.baidu.tieba.w.edit);
        this.mEdit.setText(this.bFR.sl().getIntro());
        this.mEdit.setOnFocusChangeListener(new u(this));
        this.mEdit.setOnTouchListener(new v(this));
        this.mEdit.setOnClickListener(new w(this));
        this.mEdit.addTextChangedListener(new x(this));
        if (this.bFR.sl().getSex() == 1) {
            this.mSex = 1;
            this.bFK.setText(com.baidu.tieba.z.man);
        } else if (this.bFR.sl().getSex() == 2) {
            this.mSex = 2;
            this.bFK.setText(com.baidu.tieba.z.woman);
        } else {
            this.bFK.setText(com.baidu.tieba.z.change_sex);
        }
        this.bFM = (LinearLayout) findViewById(com.baidu.tieba.w.intro_text_tip);
        this.bFN = (TextView) findViewById(com.baidu.tieba.w.intro_text_tip_num);
        this.bFO = (TextView) findViewById(com.baidu.tieba.w.intro_text_tip_divider);
        this.bFP = (TextView) findViewById(com.baidu.tieba.w.intro_text_tip_limit);
        aam();
        this.amY = (ProgressBar) findViewById(com.baidu.tieba.w.image_progress);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(getPageContext().getPageActivity());
        builder2.setMessage(getPageContext().getString(com.baidu.tieba.z.confirm_giveup));
        builder2.setPositiveButton(getPageContext().getString(com.baidu.tieba.z.alert_yes_button), new y(this));
        builder2.setNeutralButton(getPageContext().getString(com.baidu.tieba.z.cancel), new z(this));
        this.bFW = builder2.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aan() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.person_change_up_limit_text);
        } else {
            color = com.baidu.tbadk.core.util.ax.getColor(com.baidu.tieba.t.person_change_not_up_limit_text);
        }
        hh(color);
    }

    private void hh(int i) {
        this.bFN.setTextColor(i);
        this.bFO.setTextColor(i);
        this.bFP.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aao() {
        if (this.bFR != null && this.bFR.sl() != null) {
            aak();
            this.bFR.sl().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.bFR.sl().setSex(this.mSex);
            if (this.bFU == null) {
                this.bFU = new ak(this, this.bFR);
                this.bFU.setPriority(3);
                this.bFU.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aap() {
        if (this.bFX == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getPageContext().getPageActivity());
            String string = getPageContext().getString(com.baidu.tieba.z.man);
            String string2 = getPageContext().getString(com.baidu.tieba.z.woman);
            builder.setTitle(com.baidu.tieba.z.choose_sex);
            builder.setItems(new String[]{string, string2}, new aa(this, string, string2));
            this.bFX = builder.create();
            this.bFX.setCanceledOnTouchOutside(true);
        }
        com.baidu.adp.lib.g.k.a(this.bFX, getPageContext());
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aak();
            this.bFZ.onClick(null);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 12001:
                    sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj())));
                    return;
                case 12002:
                    if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
                        this.apq.parseJson(stringExtra);
                        this.apq.updateQuality();
                        if (this.apq.getChosedFiles() != null && this.apq.getChosedFiles().size() > 0) {
                            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.apq.getChosedFiles().get(0).getFilePath())));
                        }
                        this.apq.clear();
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    this.bFR.sl().setPhotoChanged(true);
                    aaq();
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12010:
                    com.baidu.tbadk.core.util.aw.a(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    private void aaq() {
        if (this.bFT != null) {
            this.bFT.cancel();
        }
        this.aVj = null;
        this.bFT = new aj(this, null);
        this.bFT.execute(new Object[0]);
    }
}
