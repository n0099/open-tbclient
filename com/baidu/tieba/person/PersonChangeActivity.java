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
    private Boolean bCe = false;
    private AlertDialog ayP = null;
    private int mSkinType = -1;
    private WriteImagesInfo aib = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView bCf = null;
    private LinearLayout mParent = null;
    private ScrollView bCg = null;
    private TextView bCh = null;
    private LinearLayout bCi = null;
    private TextView bCj = null;
    private LinearLayout bCk = null;
    private TextView auM = null;
    private EditText bCl = null;
    private LinearLayout bCm = null;
    private TextView bCn = null;
    private TextView bCo = null;
    private TextView bCp = null;
    private InputMethodManager mInputManager = null;
    private boolean bCq = false;
    private com.baidu.tieba.model.au bCr = null;
    protected HeadImageView bCs = null;
    private com.baidu.adp.widget.a.a aTH = null;
    private aq bCt = null;
    private ar bCu = null;
    private ProgressBar afH = null;
    private DialogInterface.OnCancelListener bCv = null;
    private Dialog bCw = null;
    private Dialog bCx = null;
    private boolean JV = false;
    private int mSex = 0;
    private final int bCy = 50;
    private View.OnClickListener bCz = new aa(this);

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
            this.bCe = Boolean.valueOf(bundle.getBoolean("isFromPersonInfo"));
        } else {
            this.bCe = Boolean.valueOf(getIntent().getBooleanExtra("isFromPersonInfo", false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.bCt != null) {
            this.bCt.cancel();
        }
        if (this.bCu != null) {
            this.bCu.cancel();
        }
        if (this.afH != null) {
            this.afH.setVisibility(8);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.bCq = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.bCq) {
            ZT();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZT() {
        if (this.bCl.getVisibility() == 0) {
            this.bCm.setVisibility(8);
            this.bCl.setVisibility(8);
            String replaceAll = this.bCl.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.auM.setText(replaceAll);
            } else {
                this.auM.setText(getString(com.baidu.tieba.y.add_intro));
            }
            if (this.bCr.TW().getIntro() == null || !this.bCr.TW().getIntro().equals(replaceAll)) {
                this.JV = true;
            }
            this.bCr.TW().setIntro(replaceAll);
            this.auM.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.bCl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZU() {
        if (this.bCl.getVisibility() != 0) {
            this.auM.setVisibility(8);
            this.bCl.setText(this.bCr.TW().getIntro());
            this.bCl.setVisibility(0);
            this.bCl.setSelection(this.bCl.getText().length());
            this.bCl.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.bCl);
            gX(TbConfig.READ_IMAGE_CACHE_TIMEOUT_WIFI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gX(int i) {
        this.bCg.postDelayed(new ai(this), i);
    }

    private void a(Bundle bundle) {
        PersonChangeData personChangeData;
        this.bCv = new aj(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.bCr = new com.baidu.tieba.model.au(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZV() {
        BitmapDrawable bitmapDrawable;
        TbadkApplication.m251getInst().getSkinType();
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.bCj.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().L(i == 1);
        getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(i);
        this.bCs.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.bCr.TW());
    }

    private void iT() {
        this.mSkinType = TbadkApplication.m251getInst().getSkinType();
        String[] strArr = {getString(com.baidu.tieba.y.take_photo), getString(com.baidu.tieba.y.album)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(com.baidu.tieba.y.operation));
        builder.setItems(strArr, new ak(this));
        if (this.ayP == null) {
            this.ayP = builder.create();
        }
        this.bCs = (HeadImageView) findViewById(com.baidu.tieba.v.photo);
        this.bCs.setIsRound(false);
        this.bCs.setAutoChangeStyle(true);
        this.bCs.setDrawBorder(false);
        this.bCs.setOnClickListener(new al(this));
        this.aTH = com.baidu.tbadk.imageManager.e.si().ds(this.bCr.TW().getPortrait());
        this.bCs.c(this.bCr.TW().getPortrait(), 12, false);
        this.mParent = (LinearLayout) findViewById(com.baidu.tieba.v.parent);
        this.bCg = (ScrollView) findViewById(com.baidu.tieba.v.person_change_scroll);
        this.bCi = (LinearLayout) findViewById(com.baidu.tieba.v.person_sex);
        this.bCj = (TextView) findViewById(com.baidu.tieba.v.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.bCz);
        this.mNavigationBar.setTitleText(getResources().getString(com.baidu.tieba.y.my_info));
        this.bCf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.y.save));
        this.bCf.setEnabled(false);
        this.bCf.setOnClickListener(new am(this));
        this.bCi.setOnClickListener(new an(this));
        this.bCk = (LinearLayout) findViewById(com.baidu.tieba.v.intro_click);
        this.bCk.setOnClickListener(new ao(this));
        this.bCk.setOnTouchListener(new ap(this));
        this.bCh = (TextView) findViewById(com.baidu.tieba.v.nick_name_show);
        this.bCh.setText(this.bCr.TW().getName());
        this.auM = (TextView) findViewById(com.baidu.tieba.v.intro);
        if (this.bCr.TW().getIntro() != null && this.bCr.TW().getIntro().length() > 0) {
            this.auM.setText(this.bCr.TW().getIntro());
        } else {
            this.auM.setText(getString(com.baidu.tieba.y.add_intro));
        }
        this.bCl = (EditText) findViewById(com.baidu.tieba.v.edit);
        this.bCl.setText(this.bCr.TW().getIntro());
        this.bCl.setOnFocusChangeListener(new ab(this));
        this.bCl.setOnTouchListener(new ac(this));
        this.bCl.setOnClickListener(new ad(this));
        this.bCl.addTextChangedListener(new ae(this));
        if (this.bCr.TW().getSex() == 1) {
            this.mSex = 1;
            this.bCj.setText(com.baidu.tieba.y.man);
        } else if (this.bCr.TW().getSex() == 2) {
            this.mSex = 2;
            this.bCj.setText(com.baidu.tieba.y.woman);
        } else {
            this.bCj.setText(com.baidu.tieba.y.change_sex);
        }
        this.bCm = (LinearLayout) findViewById(com.baidu.tieba.v.intro_text_tip);
        this.bCn = (TextView) findViewById(com.baidu.tieba.v.intro_text_tip_num);
        this.bCo = (TextView) findViewById(com.baidu.tieba.v.intro_text_tip_divider);
        this.bCp = (TextView) findViewById(com.baidu.tieba.v.intro_text_tip_limit);
        ZV();
        this.afH = (ProgressBar) findViewById(com.baidu.tieba.v.image_progress);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setMessage(getString(com.baidu.tieba.y.confirm_giveup));
        builder2.setPositiveButton(getString(com.baidu.tieba.y.alert_yes_button), new af(this));
        builder2.setNeutralButton(getString(com.baidu.tieba.y.cancel), new ag(this));
        this.bCw = builder2.create();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZW() {
        int color;
        if (this.bCl.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.person_change_up_limit_text);
        } else {
            color = com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.person_change_not_up_limit_text);
        }
        gY(color);
    }

    private void gY(int i) {
        this.bCn.setTextColor(i);
        this.bCo.setTextColor(i);
        this.bCp.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZX() {
        if (this.bCr != null && this.bCr.TW() != null) {
            ZT();
            this.bCr.TW().setIntro(this.bCl.getText().toString().replaceAll("\\s*", ""));
            this.bCr.TW().setSex(this.mSex);
            if (this.bCu == null) {
                this.bCu = new ar(this, this.bCr);
                this.bCu.setPriority(3);
                this.bCu.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ZY() {
        if (this.bCx == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String string = getString(com.baidu.tieba.y.man);
            String string2 = getString(com.baidu.tieba.y.woman);
            builder.setTitle(com.baidu.tieba.y.choose_sex);
            builder.setItems(new String[]{string, string2}, new ah(this, string, string2));
            this.bCx = builder.create();
            this.bCx.setCanceledOnTouchOutside(true);
        }
        com.baidu.adp.lib.g.j.a(this.bCx, this);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            ZT();
            this.bCz.onClick(null);
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
                        this.aib.parseJson(stringExtra);
                        this.aib.updateQuality();
                        if (this.aib.getChosedFiles() != null && this.aib.getChosedFiles().size() > 0) {
                            EditHeadActivity.a(this, 12002, 12009, intent.getData(), TbadkApplication.getCurrentAccountObj(), 0, this.aib.getChosedFiles().get(0).getFilePath());
                        }
                        this.aib.clear();
                        return;
                    }
                    return;
                case 12009:
                case 12010:
                    this.bCr.TW().setPhotoChanged(true);
                    ZZ();
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

    private void ZZ() {
        if (this.bCt != null) {
            this.bCt.cancel();
        }
        this.aTH = null;
        this.bCt = new aq(this, null);
        this.bCt.execute(new Object[0]);
    }
}
