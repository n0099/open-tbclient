package com.baidu.tieba.person;

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
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.WriteImagesInfo;
/* loaded from: classes.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private View bSu;
    private Boolean bSt = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView bjS = null;
    private LinearLayout aIr = null;
    private ScrollView bSv = null;
    private TextView bSw = null;
    private LinearLayout bSx = null;
    private TextView bSy = null;
    private LinearLayout bSz = null;
    private TextView aJx = null;
    private EditText mEdit = null;
    private LinearLayout bSA = null;
    private TextView bSB = null;
    private TextView bSC = null;
    private TextView bSD = null;
    private InputMethodManager mInputManager = null;
    private boolean bSE = false;
    private com.baidu.tbadk.coreExtra.c.f bSF = null;
    protected HeadImageView bSG = null;
    private com.baidu.adp.widget.a.a bdF = null;
    private az bSH = null;
    private ba bSI = null;
    private ProgressBar axF = null;
    private DialogInterface.OnCancelListener bSJ = null;
    private com.baidu.tbadk.core.dialog.a bSK = null;
    private com.baidu.tbadk.core.dialog.e bSL = null;
    private boolean bRs = false;
    private int mSex = 0;
    private final int bSM = 50;
    private final View.OnClickListener bSN = new aj(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.r.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        k(bundle);
        EY();
        if (bundle != null) {
            this.bSt = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.bSt = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bSH != null) {
            this.bSH.cancel();
        }
        if (this.bSI != null) {
            this.bSI.cancel();
        }
        if (this.axF != null) {
            this.axF.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.bSE = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.bSE) {
            aeq();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeq() {
        if (this.mEdit.getVisibility() == 0) {
            this.bSA.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.aJx.setText(replaceAll);
            } else {
                this.aJx.setText(getPageContext().getString(com.baidu.tieba.t.add_intro));
            }
            if (this.bSF.wI().getIntro() == null || !this.bSF.wI().getIntro().equals(replaceAll)) {
                this.bRs = true;
            }
            this.bSF.wI().setIntro(replaceAll);
            this.aJx.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aer() {
        if (this.mEdit.getVisibility() != 0) {
            this.aJx.setVisibility(8);
            this.mEdit.setText(this.bSF.wI().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            hQ(300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hQ(int i) {
        this.bSv.postDelayed(new ar(this), i);
    }

    private void k(Bundle bundle) {
        PersonChangeData personChangeData;
        this.bSJ = new as(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.bSF = new com.baidu.tbadk.coreExtra.c.f(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aes() {
        BitmapDrawable bitmapDrawable;
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.bSy.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(this.aIr);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bSG.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.bSF.wI());
    }

    private void EY() {
        this.bSG = (HeadImageView) findViewById(com.baidu.tieba.q.photo);
        this.bSG.setIsRound(false);
        this.bSG.setAutoChangeStyle(true);
        this.bSG.setDrawBorder(false);
        this.bSG.setOnClickListener(new at(this));
        this.bdF = com.baidu.tbadk.imageManager.e.Am().eK(this.bSF.wI().getPortrait());
        this.bSG.c(this.bSF.wI().getPortrait(), 25, false);
        this.aIr = (LinearLayout) findViewById(com.baidu.tieba.q.parent);
        this.bSv = (ScrollView) findViewById(com.baidu.tieba.q.person_change_scroll);
        this.bSx = (LinearLayout) findViewById(com.baidu.tieba.q.person_sex);
        this.bSy = (TextView) findViewById(com.baidu.tieba.q.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bSN);
        this.mNavigationBar.setTitleText(getResources().getString(com.baidu.tieba.t.my_info));
        this.bSu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.navigation_right_button_layout, (View.OnClickListener) null);
        this.bjS = (TextView) this.bSu.findViewById(com.baidu.tieba.q.right_textview);
        this.bjS.setText(getPageContext().getString(com.baidu.tieba.t.save));
        this.bSu.setEnabled(false);
        com.baidu.tbadk.core.util.ay.b(this.bjS, com.baidu.tieba.n.navi_op_text, 1);
        this.bSu.setOnClickListener(new au(this));
        this.bSx.setOnClickListener(new av(this));
        this.bSz = (LinearLayout) findViewById(com.baidu.tieba.q.intro_click);
        this.bSz.setOnClickListener(new aw(this));
        this.bSz.setOnTouchListener(new ax(this));
        this.bSw = (TextView) findViewById(com.baidu.tieba.q.nick_name_show);
        this.bSw.setText(this.bSF.wI().getName());
        this.aJx = (TextView) findViewById(com.baidu.tieba.q.intro);
        if (this.bSF.wI().getIntro() != null && this.bSF.wI().getIntro().length() > 0) {
            this.aJx.setText(this.bSF.wI().getIntro());
        } else {
            this.aJx.setText(getPageContext().getString(com.baidu.tieba.t.add_intro));
        }
        this.mEdit = (EditText) findViewById(com.baidu.tieba.q.edit);
        this.mEdit.setText(this.bSF.wI().getIntro());
        this.mEdit.setOnFocusChangeListener(new ay(this));
        this.mEdit.setOnTouchListener(new ak(this));
        this.mEdit.setOnClickListener(new al(this));
        this.mEdit.addTextChangedListener(new am(this));
        if (this.bSF.wI().getSex() == 1) {
            this.mSex = 1;
            this.bSy.setText(com.baidu.tieba.t.man);
        } else if (this.bSF.wI().getSex() == 2) {
            this.mSex = 2;
            this.bSy.setText(com.baidu.tieba.t.woman);
        } else {
            this.bSy.setText(com.baidu.tieba.t.change_sex);
        }
        this.bSA = (LinearLayout) findViewById(com.baidu.tieba.q.intro_text_tip);
        this.bSB = (TextView) findViewById(com.baidu.tieba.q.intro_text_tip_num);
        this.bSC = (TextView) findViewById(com.baidu.tieba.q.intro_text_tip_divider);
        this.bSD = (TextView) findViewById(com.baidu.tieba.q.intro_text_tip_limit);
        aes();
        this.axF = (ProgressBar) findViewById(com.baidu.tieba.q.image_progress);
        this.bSK = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.bSK.cn(getPageContext().getString(com.baidu.tieba.t.confirm_giveup));
        this.bSK.a(getPageContext().getString(com.baidu.tieba.t.alert_yes_button), new an(this));
        this.bSK.b(getPageContext().getString(com.baidu.tieba.t.cancel), new ao(this));
        this.bSK.b(getPageContext());
    }

    public void aet() {
        String[] strArr = {getPageContext().getString(com.baidu.tieba.t.change_photo), getPageContext().getString(com.baidu.tieba.t.change_system_photo)};
        com.baidu.tbadk.core.dialog.e eVar = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        eVar.bx(com.baidu.tieba.t.operation);
        eVar.a(strArr, new ap(this));
        eVar.d(getPageContext());
        eVar.rN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeu() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.person_change_up_limit_text);
        } else {
            color = com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.person_change_not_up_limit_text);
        }
        hR(color);
    }

    private void hR(int i) {
        this.bSB.setTextColor(i);
        this.bSC.setTextColor(i);
        this.bSD.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aev() {
        if (this.bSF != null && this.bSF.wI() != null) {
            aeq();
            this.bSF.wI().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.bSF.wI().setSex(this.mSex);
            if (this.bSI == null) {
                this.bSI = new ba(this, this.bSF);
                this.bSI.setPriority(3);
                this.bSI.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aew() {
        if (this.bSL == null) {
            this.bSL = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
            String string = getPageContext().getString(com.baidu.tieba.t.man);
            String string2 = getPageContext().getString(com.baidu.tieba.t.woman);
            this.bSL.bx(com.baidu.tieba.t.choose_sex);
            this.bSL.a(new String[]{string, string2}, new aq(this, string, string2));
            this.bSL.d(getPageContext());
        }
        this.bSL.rN();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aeq();
            this.bSN.onClick(null);
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
                            I(intent);
                            return;
                        } else {
                            getAlbumDataFromImage(intent);
                            return;
                        }
                    }
                    return;
                case 12009:
                case 12010:
                    this.bSF.wI().setPhotoChanged(true);
                    aex();
                    return;
                case 12014:
                    this.bSF.wI().setPhotoChanged(true);
                    if (intent != null) {
                        this.bSG.setImageBitmap(null);
                        this.bSG.c(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12010:
                    com.baidu.tbadk.core.util.ax.b(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    private void getAlbumDataFromImage(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
            if (this.mWriteImagesInfo.getChosedFiles() != null && this.mWriteImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.mWriteImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.mWriteImagesInfo.clear();
        }
    }

    private void I(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void aex() {
        if (this.bSH != null) {
            this.bSH.cancel();
        }
        this.bdF = null;
        this.bSH = new az(this, null);
        this.bSH.execute(new Object[0]);
    }
}
