package com.baidu.tieba.person;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private View cre;
    private Boolean crd = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView bBR = null;
    private LinearLayout aPv = null;
    private ScrollView crf = null;
    private TextView crg = null;
    private LinearLayout crh = null;
    private TextView cri = null;
    private LinearLayout crj = null;
    private TextView aQB = null;
    private EditText mEdit = null;
    private LinearLayout crk = null;
    private TextView crl = null;
    private TextView crm = null;
    private TextView crn = null;
    private InputMethodManager mInputManager = null;
    private boolean cro = false;
    private au crp = null;
    protected HeadImageView aQQ = null;
    private com.baidu.adp.widget.a.a bvO = null;
    private a crq = null;
    private b crr = null;
    private ProgressBar crs = null;
    private DialogInterface.OnCancelListener crt = null;
    private com.baidu.tbadk.core.dialog.a cru = null;
    private com.baidu.tbadk.core.dialog.c crv = null;
    private boolean cpT = false;
    private int mSex = 0;
    private final int crw = 50;
    private final View.OnClickListener crx = new ae(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        k(bundle);
        FL();
        if (bundle != null) {
            this.crd = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.crd = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.crq != null) {
            this.crq.cancel();
        }
        if (this.crr != null) {
            this.crr.cancel();
        }
        if (this.crs != null) {
            this.crs.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.cro = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.cro) {
            aiY();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiY() {
        if (this.mEdit.getVisibility() == 0) {
            this.crk.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.aQB.setText(replaceAll);
            } else {
                this.aQB.setText(getPageContext().getString(i.h.add_intro));
            }
            if (this.crp.ajg().getIntro() == null || !this.crp.ajg().getIntro().equals(replaceAll)) {
                this.cpT = true;
            }
            this.crp.ajg().setIntro(replaceAll);
            this.aQB.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiZ() {
        if (this.mEdit.getVisibility() != 0) {
            this.aQB.setVisibility(8);
            this.mEdit.setText(this.crp.ajg().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            jt(300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jt(int i) {
        this.crf.postDelayed(new am(this), i);
    }

    private void k(Bundle bundle) {
        PersonChangeData personChangeData;
        this.crt = new an(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.crp = new au(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aja() {
        BitmapDrawable bitmapDrawable;
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.cri.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.aPv);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aQQ.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.crp.ajg());
    }

    private void FL() {
        this.aQQ = (HeadImageView) findViewById(i.f.photo);
        this.aQQ.setIsRound(false);
        this.aQQ.setAutoChangeStyle(true);
        this.aQQ.setDrawBorder(false);
        this.aQQ.setOnClickListener(new ao(this));
        this.bvO = com.baidu.tbadk.imageManager.c.BV().fp(this.crp.ajg().getPortrait());
        this.aQQ.d(this.crp.ajg().getPortrait(), 25, false);
        this.aPv = (LinearLayout) findViewById(i.f.parent);
        this.crf = (ScrollView) findViewById(i.f.person_change_scroll);
        this.crh = (LinearLayout) findViewById(i.f.person_sex);
        this.cri = (TextView) findViewById(i.f.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.crx);
        this.mNavigationBar.setTitleText(getResources().getString(i.h.my_info));
        this.cre = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null);
        this.bBR = (TextView) this.cre.findViewById(i.f.right_textview);
        this.bBR.setText(getPageContext().getString(i.h.save));
        this.cre.setEnabled(false);
        com.baidu.tbadk.core.util.an.b(this.bBR, i.c.navi_op_text, 1);
        this.cre.setOnClickListener(new ap(this));
        this.crh.setOnClickListener(new aq(this));
        this.crj = (LinearLayout) findViewById(i.f.intro_click);
        this.crj.setOnClickListener(new ar(this));
        this.crj.setOnTouchListener(new as(this));
        this.crg = (TextView) findViewById(i.f.nick_name_show);
        this.crg.setText(this.crp.ajg().getName());
        this.aQB = (TextView) findViewById(i.f.intro);
        if (this.crp.ajg().getIntro() != null && this.crp.ajg().getIntro().length() > 0) {
            this.aQB.setText(this.crp.ajg().getIntro());
        } else {
            this.aQB.setText(getPageContext().getString(i.h.add_intro));
        }
        this.mEdit = (EditText) findViewById(i.f.edit);
        this.mEdit.setText(this.crp.ajg().getIntro());
        this.mEdit.setOnFocusChangeListener(new at(this));
        this.mEdit.setOnTouchListener(new af(this));
        this.mEdit.setOnClickListener(new ag(this));
        this.mEdit.addTextChangedListener(new ah(this));
        if (this.crp.ajg().getSex() == 1) {
            this.mSex = 1;
            this.cri.setText(i.h.man);
        } else if (this.crp.ajg().getSex() == 2) {
            this.mSex = 2;
            this.cri.setText(i.h.woman);
        } else {
            this.cri.setText(i.h.change_sex);
        }
        this.crk = (LinearLayout) findViewById(i.f.intro_text_tip);
        this.crl = (TextView) findViewById(i.f.intro_text_tip_num);
        this.crm = (TextView) findViewById(i.f.intro_text_tip_divider);
        this.crn = (TextView) findViewById(i.f.intro_text_tip_limit);
        aja();
        this.crs = (ProgressBar) findViewById(i.f.image_progress);
        this.cru = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cru.cu(getPageContext().getString(i.h.confirm_giveup));
        this.cru.a(getPageContext().getString(i.h.alert_yes_button), new ai(this));
        this.cru.b(getPageContext().getString(i.h.cancel), new aj(this));
        this.cru.b(getPageContext());
    }

    public void ajb() {
        String[] strArr = {getPageContext().getString(i.h.change_photo), getPageContext().getString(i.h.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bI(i.h.operation);
        cVar.a(strArr, new ak(this));
        cVar.d(getPageContext());
        cVar.sU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajc() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = com.baidu.tbadk.core.util.an.getColor(i.c.person_change_up_limit_text);
        } else {
            color = com.baidu.tbadk.core.util.an.getColor(i.c.person_change_not_up_limit_text);
        }
        ju(color);
    }

    private void ju(int i) {
        this.crl.setTextColor(i);
        this.crm.setTextColor(i);
        this.crn.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajd() {
        if (this.crp != null && this.crp.ajg() != null) {
            aiY();
            this.crp.ajg().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.crp.ajg().setSex(this.mSex);
            if (this.crr == null) {
                this.crr = new b(this.crp);
                this.crr.setPriority(3);
                this.crr.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aje() {
        if (this.crv == null) {
            this.crv = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            String string = getPageContext().getString(i.h.man);
            String string2 = getPageContext().getString(i.h.woman);
            this.crv.bI(i.h.choose_sex);
            this.crv.a(new String[]{string, string2}, new al(this, string, string2));
            this.crv.d(getPageContext());
        }
        this.crv.sU();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aiY();
            this.crx.onClick(null);
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
                            getAlbumDataFromImage(intent);
                            return;
                        }
                    }
                    return;
                case 12009:
                case 12010:
                    this.crp.ajg().setPhotoChanged(true);
                    ajf();
                    return;
                case 12014:
                    this.crp.ajg().setPhotoChanged(true);
                    if (intent != null) {
                        this.aQQ.setImageBitmap(null);
                        this.aQQ.d(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12010:
                    com.baidu.tbadk.core.util.am.c(getPageContext());
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
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.mWriteImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.mWriteImagesInfo.clear();
        }
    }

    private void K(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void ajf() {
        if (this.crq != null) {
            this.crq.cancel();
        }
        this.bvO = null;
        this.crq = new a(this, null);
        this.crq.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends BdAsyncTask<Object, Integer, Bitmap> {
        private a() {
        }

        /* synthetic */ a(PersonChangeActivity personChangeActivity, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.crs.setVisibility(0);
            PersonChangeActivity.this.aQQ.setImageDrawable(null);
            PersonChangeActivity.this.bvO = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.n.aa(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.crq = null;
            PersonChangeActivity.this.crs.setVisibility(8);
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
            PersonChangeActivity.this.crq = null;
            PersonChangeActivity.this.crs.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.bvO = new com.baidu.adp.widget.a.a(bitmap, false, null);
                PersonChangeActivity.this.bvO.a(PersonChangeActivity.this.aQQ);
                com.baidu.tbadk.imageManager.c.BV().a(PersonChangeActivity.this.crp.ajg().getPortrait(), PersonChangeActivity.this.bvO, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private com.baidu.tbadk.core.util.w Tj = null;
        private au crp;

        public b(au auVar) {
            this.crp = null;
            this.crp = auVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.crr = null;
            if (this.Tj != null) {
                this.Tj.gJ();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.crr = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.Tj != null) {
                if (this.Tj.uh().va().qT()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(i.h.success));
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.crd.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.crp.ajg());
                    } else {
                        intent.putExtra("data", this.crp.ajg());
                    }
                    TbadkCoreApplication.m411getInst().setPersonChangeData(this.crp.ajg());
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.finish();
                } else {
                    PersonChangeActivity.this.showToast(this.Tj.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(i.h.saving), PersonChangeActivity.this.crt);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.crp != null) {
                this.Tj = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_MODIFY);
                this.Tj.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.crp.ajg().getSex()));
                this.Tj.o("intro", this.crp.ajg().getIntro());
                this.Tj.tJ();
                if (this.Tj.uh().va().qT()) {
                    com.baidu.tieba.tbadkCore.util.m.ayG();
                }
            }
            return null;
        }
    }
}
