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
    private View bSt;
    private Boolean bSs = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView bjR = null;
    private LinearLayout aIq = null;
    private ScrollView bSu = null;
    private TextView bSv = null;
    private LinearLayout bSw = null;
    private TextView bSx = null;
    private LinearLayout bSy = null;
    private TextView aJw = null;
    private EditText mEdit = null;
    private LinearLayout bSz = null;
    private TextView bSA = null;
    private TextView bSB = null;
    private TextView bSC = null;
    private InputMethodManager mInputManager = null;
    private boolean bSD = false;
    private com.baidu.tbadk.coreExtra.c.f bSE = null;
    protected HeadImageView bSF = null;
    private com.baidu.adp.widget.a.a bdE = null;
    private az bSG = null;
    private ba bSH = null;
    private ProgressBar axE = null;
    private DialogInterface.OnCancelListener bSI = null;
    private com.baidu.tbadk.core.dialog.a bSJ = null;
    private com.baidu.tbadk.core.dialog.e bSK = null;
    private boolean bRr = false;
    private int mSex = 0;
    private final int bSL = 50;
    private final View.OnClickListener bSM = new aj(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.r.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        k(bundle);
        EX();
        if (bundle != null) {
            this.bSs = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.bSs = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bSG != null) {
            this.bSG.cancel();
        }
        if (this.bSH != null) {
            this.bSH.cancel();
        }
        if (this.axE != null) {
            this.axE.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.bSD = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.bSD) {
            aep();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aep() {
        if (this.mEdit.getVisibility() == 0) {
            this.bSz.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.aJw.setText(replaceAll);
            } else {
                this.aJw.setText(getPageContext().getString(com.baidu.tieba.t.add_intro));
            }
            if (this.bSE.wH().getIntro() == null || !this.bSE.wH().getIntro().equals(replaceAll)) {
                this.bRr = true;
            }
            this.bSE.wH().setIntro(replaceAll);
            this.aJw.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeq() {
        if (this.mEdit.getVisibility() != 0) {
            this.aJw.setVisibility(8);
            this.mEdit.setText(this.bSE.wH().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            hQ(300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hQ(int i) {
        this.bSu.postDelayed(new ar(this), i);
    }

    private void k(Bundle bundle) {
        PersonChangeData personChangeData;
        this.bSI = new as(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.bSE = new com.baidu.tbadk.coreExtra.c.f(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aer() {
        BitmapDrawable bitmapDrawable;
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.ay.getDrawable(com.baidu.tieba.p.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.bSx.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().j(this.aIq);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bSF.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.bSE.wH());
    }

    private void EX() {
        this.bSF = (HeadImageView) findViewById(com.baidu.tieba.q.photo);
        this.bSF.setIsRound(false);
        this.bSF.setAutoChangeStyle(true);
        this.bSF.setDrawBorder(false);
        this.bSF.setOnClickListener(new at(this));
        this.bdE = com.baidu.tbadk.imageManager.e.Al().eK(this.bSE.wH().getPortrait());
        this.bSF.c(this.bSE.wH().getPortrait(), 25, false);
        this.aIq = (LinearLayout) findViewById(com.baidu.tieba.q.parent);
        this.bSu = (ScrollView) findViewById(com.baidu.tieba.q.person_change_scroll);
        this.bSw = (LinearLayout) findViewById(com.baidu.tieba.q.person_sex);
        this.bSx = (TextView) findViewById(com.baidu.tieba.q.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bSM);
        this.mNavigationBar.setTitleText(getResources().getString(com.baidu.tieba.t.my_info));
        this.bSt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.r.navigation_right_button_layout, (View.OnClickListener) null);
        this.bjR = (TextView) this.bSt.findViewById(com.baidu.tieba.q.right_textview);
        this.bjR.setText(getPageContext().getString(com.baidu.tieba.t.save));
        this.bSt.setEnabled(false);
        com.baidu.tbadk.core.util.ay.b(this.bjR, com.baidu.tieba.n.navi_op_text, 1);
        this.bSt.setOnClickListener(new au(this));
        this.bSw.setOnClickListener(new av(this));
        this.bSy = (LinearLayout) findViewById(com.baidu.tieba.q.intro_click);
        this.bSy.setOnClickListener(new aw(this));
        this.bSy.setOnTouchListener(new ax(this));
        this.bSv = (TextView) findViewById(com.baidu.tieba.q.nick_name_show);
        this.bSv.setText(this.bSE.wH().getName());
        this.aJw = (TextView) findViewById(com.baidu.tieba.q.intro);
        if (this.bSE.wH().getIntro() != null && this.bSE.wH().getIntro().length() > 0) {
            this.aJw.setText(this.bSE.wH().getIntro());
        } else {
            this.aJw.setText(getPageContext().getString(com.baidu.tieba.t.add_intro));
        }
        this.mEdit = (EditText) findViewById(com.baidu.tieba.q.edit);
        this.mEdit.setText(this.bSE.wH().getIntro());
        this.mEdit.setOnFocusChangeListener(new ay(this));
        this.mEdit.setOnTouchListener(new ak(this));
        this.mEdit.setOnClickListener(new al(this));
        this.mEdit.addTextChangedListener(new am(this));
        if (this.bSE.wH().getSex() == 1) {
            this.mSex = 1;
            this.bSx.setText(com.baidu.tieba.t.man);
        } else if (this.bSE.wH().getSex() == 2) {
            this.mSex = 2;
            this.bSx.setText(com.baidu.tieba.t.woman);
        } else {
            this.bSx.setText(com.baidu.tieba.t.change_sex);
        }
        this.bSz = (LinearLayout) findViewById(com.baidu.tieba.q.intro_text_tip);
        this.bSA = (TextView) findViewById(com.baidu.tieba.q.intro_text_tip_num);
        this.bSB = (TextView) findViewById(com.baidu.tieba.q.intro_text_tip_divider);
        this.bSC = (TextView) findViewById(com.baidu.tieba.q.intro_text_tip_limit);
        aer();
        this.axE = (ProgressBar) findViewById(com.baidu.tieba.q.image_progress);
        this.bSJ = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.bSJ.cn(getPageContext().getString(com.baidu.tieba.t.confirm_giveup));
        this.bSJ.a(getPageContext().getString(com.baidu.tieba.t.alert_yes_button), new an(this));
        this.bSJ.b(getPageContext().getString(com.baidu.tieba.t.cancel), new ao(this));
        this.bSJ.b(getPageContext());
    }

    public void aes() {
        String[] strArr = {getPageContext().getString(com.baidu.tieba.t.change_photo), getPageContext().getString(com.baidu.tieba.t.change_system_photo)};
        com.baidu.tbadk.core.dialog.e eVar = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
        eVar.bx(com.baidu.tieba.t.operation);
        eVar.a(strArr, new ap(this));
        eVar.d(getPageContext());
        eVar.rN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aet() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.person_change_up_limit_text);
        } else {
            color = com.baidu.tbadk.core.util.ay.getColor(com.baidu.tieba.n.person_change_not_up_limit_text);
        }
        hR(color);
    }

    private void hR(int i) {
        this.bSA.setTextColor(i);
        this.bSB.setTextColor(i);
        this.bSC.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeu() {
        if (this.bSE != null && this.bSE.wH() != null) {
            aep();
            this.bSE.wH().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.bSE.wH().setSex(this.mSex);
            if (this.bSH == null) {
                this.bSH = new ba(this, this.bSE);
                this.bSH.setPriority(3);
                this.bSH.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aev() {
        if (this.bSK == null) {
            this.bSK = new com.baidu.tbadk.core.dialog.e(getPageContext().getPageActivity());
            String string = getPageContext().getString(com.baidu.tieba.t.man);
            String string2 = getPageContext().getString(com.baidu.tieba.t.woman);
            this.bSK.bx(com.baidu.tieba.t.choose_sex);
            this.bSK.a(new String[]{string, string2}, new aq(this, string, string2));
            this.bSK.d(getPageContext());
        }
        this.bSK.rN();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aep();
            this.bSM.onClick(null);
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
                    this.bSE.wH().setPhotoChanged(true);
                    aew();
                    return;
                case 12014:
                    this.bSE.wH().setPhotoChanged(true);
                    if (intent != null) {
                        this.bSF.setImageBitmap(null);
                        this.bSF.c(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
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

    private void aew() {
        if (this.bSG != null) {
            this.bSG.cancel();
        }
        this.bdE = null;
        this.bSG = new az(this, null);
        this.bSG.execute(new Object[0]);
    }
}
