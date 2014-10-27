package com.baidu.tieba.person;

import android.app.Activity;
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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.act.EditHeadActivity;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.data.PersonChangeData;
/* loaded from: classes.dex */
public class PersonChangeActivity extends BaseActivity {
    private Boolean bBQ = false;
    private AlertDialog ayG = null;
    private int mSkinType = -1;
    private WriteImagesInfo ahS = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView bBR = null;
    private LinearLayout mParent = null;
    private ScrollView bBS = null;
    private TextView bBT = null;
    private LinearLayout bBU = null;
    private TextView bBV = null;
    private LinearLayout bBW = null;
    private TextView auD = null;
    private EditText bBX = null;
    private LinearLayout bBY = null;
    private TextView bBZ = null;
    private TextView bCa = null;
    private TextView bCb = null;
    private InputMethodManager mInputManager = null;
    private boolean bCc = false;
    private com.baidu.tieba.model.au bCd = null;
    protected HeadImageView bCe = null;
    private com.baidu.adp.widget.a.a aTt = null;
    private aq bCf = null;
    private ar bCg = null;
    private ProgressBar afz = null;
    private DialogInterface.OnCancelListener bCh = null;
    private Dialog bCi = null;
    private Dialog bCj = null;
    private boolean JU = false;
    private int mSex = 0;
    private final int bCk = 50;
    private View.OnClickListener bCl = new aa(this);

    public static void a(Activity activity, int i, PersonChangeData personChangeData, Boolean bool) {
        Intent intent = new Intent(activity, PersonChangeActivity.class);
        intent.putExtra("data", personChangeData);
        intent.putExtra("isFromPersonInfo", bool);
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.w.person_change_activity);
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        a(bundle);
        iT();
        if (bundle != null) {
            this.bBQ = Boolean.valueOf(bundle.getBoolean("isFromPersonInfo"));
        } else {
            this.bBQ = Boolean.valueOf(getIntent().getBooleanExtra("isFromPersonInfo", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bCf != null) {
            this.bCf.cancel();
        }
        if (this.bCg != null) {
            this.bCg.cancel();
        }
        if (this.afz != null) {
            this.afz.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.bCc = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.bCc) {
            ZR();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZR() {
        if (this.bBX.getVisibility() == 0) {
            this.bBY.setVisibility(8);
            this.bBX.setVisibility(8);
            String replaceAll = this.bBX.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.auD.setText(replaceAll);
            } else {
                this.auD.setText(getString(com.baidu.tieba.y.add_intro));
            }
            if (this.bCd.TT().getIntro() == null || !this.bCd.TT().getIntro().equals(replaceAll)) {
                this.JU = true;
            }
            this.bCd.TT().setIntro(replaceAll);
            this.auD.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.bBX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZS() {
        if (this.bBX.getVisibility() != 0) {
            this.auD.setVisibility(8);
            this.bBX.setText(this.bCd.TT().getIntro());
            this.bBX.setVisibility(0);
            this.bBX.setSelection(this.bBX.getText().length());
            this.bBX.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.bBX);
            gX(TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gX(int i) {
        this.bBS.postDelayed(new ai(this), i);
    }

    private void a(Bundle bundle) {
        PersonChangeData personChangeData;
        this.bCh = new aj(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.bCd = new com.baidu.tieba.model.au(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZT() {
        BitmapDrawable bitmapDrawable;
        TbadkApplication.m251getInst().getSkinType();
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.bBV.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(i);
        this.bCe.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.bCd.TT());
    }

    private void iT() {
        this.mSkinType = TbadkApplication.m251getInst().getSkinType();
        String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(com.baidu.tieba.y.operation));
        builder.setItems(strArr, new ak(this));
        if (this.ayG == null) {
            this.ayG = builder.create();
        }
        this.bCe = (HeadImageView) findViewById(com.baidu.tieba.v.photo);
        this.bCe.setIsRound(false);
        this.bCe.setAutoChangeStyle(true);
        this.bCe.setDrawBorder(false);
        this.bCe.setOnClickListener(new al(this));
        this.aTt = com.baidu.tbadk.imageManager.e.sg().ds(this.bCd.TT().getPortrait());
        this.bCe.c(this.bCd.TT().getPortrait(), 12, false);
        this.mParent = (LinearLayout) findViewById(com.baidu.tieba.v.parent);
        this.bBS = (ScrollView) findViewById(com.baidu.tieba.v.person_change_scroll);
        this.bBU = (LinearLayout) findViewById(com.baidu.tieba.v.person_sex);
        this.bBV = (TextView) findViewById(com.baidu.tieba.v.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bCl);
        this.mNavigationBar.setTitleText(getResources().getString(com.baidu.tieba.y.my_info));
        this.bBR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.y.save));
        this.bBR.setEnabled(false);
        this.bBR.setOnClickListener(new am(this));
        this.bBU.setOnClickListener(new an(this));
        this.bBW = (LinearLayout) findViewById(com.baidu.tieba.v.intro_click);
        this.bBW.setOnClickListener(new ao(this));
        this.bBW.setOnTouchListener(new ap(this));
        this.bBT = (TextView) findViewById(com.baidu.tieba.v.nick_name_show);
        this.bBT.setText(this.bCd.TT().getName());
        this.auD = (TextView) findViewById(com.baidu.tieba.v.intro);
        if (this.bCd.TT().getIntro() != null && this.bCd.TT().getIntro().length() > 0) {
            this.auD.setText(this.bCd.TT().getIntro());
        } else {
            this.auD.setText(getString(com.baidu.tieba.y.add_intro));
        }
        this.bBX = (EditText) findViewById(com.baidu.tieba.v.edit);
        this.bBX.setText(this.bCd.TT().getIntro());
        this.bBX.setOnFocusChangeListener(new ab(this));
        this.bBX.setOnTouchListener(new ac(this));
        this.bBX.setOnClickListener(new ad(this));
        this.bBX.addTextChangedListener(new ae(this));
        if (this.bCd.TT().getSex() == 1) {
            this.mSex = 1;
            this.bBV.setText(com.baidu.tieba.y.man);
        } else if (this.bCd.TT().getSex() == 2) {
            this.mSex = 2;
            this.bBV.setText(com.baidu.tieba.y.woman);
        } else {
            this.bBV.setText(com.baidu.tieba.y.change_sex);
        }
        this.bBY = (LinearLayout) findViewById(com.baidu.tieba.v.intro_text_tip);
        this.bBZ = (TextView) findViewById(com.baidu.tieba.v.intro_text_tip_num);
        this.bCa = (TextView) findViewById(com.baidu.tieba.v.intro_text_tip_divider);
        this.bCb = (TextView) findViewById(com.baidu.tieba.v.intro_text_tip_limit);
        ZT();
        this.afz = (ProgressBar) findViewById(com.baidu.tieba.v.image_progress);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage(getString(com.baidu.tieba.y.confirm_giveup));
        builder2.setPositiveButton(getString(com.baidu.tieba.y.alert_yes_button), new af(this));
        builder2.setNeutralButton(getString(com.baidu.tieba.y.cancel), new ag(this));
        this.bCi = builder2.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZU() {
        int color;
        if (this.bBX.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.person_change_up_limit_text);
        } else {
            color = com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.person_change_not_up_limit_text);
        }
        gY(color);
    }

    private void gY(int i) {
        this.bBZ.setTextColor(i);
        this.bCa.setTextColor(i);
        this.bCb.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZV() {
        if (this.bCd != null && this.bCd.TT() != null) {
            ZR();
            this.bCd.TT().setIntro(this.bBX.getText().toString().replaceAll("\\s*", ""));
            this.bCd.TT().setSex(this.mSex);
            if (this.bCg == null) {
                this.bCg = new ar(this, this.bCd);
                this.bCg.setPriority(3);
                this.bCg.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZW() {
        if (this.bCj == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String string = getString(com.baidu.tieba.y.man);
            String string2 = getString(com.baidu.tieba.y.woman);
            builder.setTitle(com.baidu.tieba.y.choose_sex);
            builder.setItems(new String[]{string, string2}, new ah(this, string, string2));
            this.bCj = builder.create();
            this.bCj.setCanceledOnTouchOutside(true);
        }
        com.baidu.adp.lib.g.j.a(this.bCj, this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            ZR();
            this.bCl.onClick(null);
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
                    EditHeadActivity.a(this, 12001, 12010, null, TbadkApplication.getCurrentAccountObj());
                    return;
                case 12002:
                    if (intent != null && (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) != null) {
                        this.ahS.parseJson(stringExtra);
                        this.ahS.updateQuality();
                        if (this.ahS.getChosedFiles() != null && this.ahS.getChosedFiles().size() > 0) {
                            EditHeadActivity.a(this, 12002, 12009, intent.getData(), TbadkApplication.getCurrentAccountObj(), 0, this.ahS.getChosedFiles().get(0).getFilePath());
                        }
                        this.ahS.clear();
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    this.bCd.TT().setPhotoChanged(true);
                    ZX();
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12010:
                    com.baidu.tbadk.core.util.av.h(this);
                    return;
                default:
                    return;
            }
        }
    }

    private void ZX() {
        if (this.bCf != null) {
            this.bCf.cancel();
        }
        this.aTt = null;
        this.bCf = new aq(this, null);
        this.bCf.execute(new Object[0]);
    }
}
