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
    private View cjU;
    private Boolean cjT = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView byj = null;
    private LinearLayout aQg = null;
    private ScrollView cjV = null;
    private TextView cjW = null;
    private LinearLayout cjX = null;
    private TextView cjY = null;
    private LinearLayout cjZ = null;
    private TextView aRm = null;
    private EditText mEdit = null;
    private LinearLayout cka = null;
    private TextView ckb = null;
    private TextView ckc = null;
    private TextView ckd = null;
    private InputMethodManager mInputManager = null;
    private boolean cke = false;
    private com.baidu.tbadk.coreExtra.c.d ckf = null;
    protected HeadImageView aRB = null;
    private com.baidu.adp.widget.a.a bsb = null;
    private a ckg = null;
    private b ckh = null;
    private ProgressBar cki = null;
    private DialogInterface.OnCancelListener ckj = null;
    private com.baidu.tbadk.core.dialog.a ckk = null;
    private com.baidu.tbadk.core.dialog.c ckl = null;
    private boolean ciQ = false;
    private int mSex = 0;
    private final int ckm = 50;
    private final View.OnClickListener ckn = new ae(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        j(bundle);
        FY();
        if (bundle != null) {
            this.cjT = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.cjT = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.ckg != null) {
            this.ckg.cancel();
        }
        if (this.ckh != null) {
            this.ckh.cancel();
        }
        if (this.cki != null) {
            this.cki.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.cke = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.cke) {
            agx();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agx() {
        if (this.mEdit.getVisibility() == 0) {
            this.cka.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.aRm.setText(replaceAll);
            } else {
                this.aRm.setText(getPageContext().getString(i.h.add_intro));
            }
            if (this.ckf.xY().getIntro() == null || !this.ckf.xY().getIntro().equals(replaceAll)) {
                this.ciQ = true;
            }
            this.ckf.xY().setIntro(replaceAll);
            this.aRm.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agy() {
        if (this.mEdit.getVisibility() != 0) {
            this.aRm.setVisibility(8);
            this.mEdit.setText(this.ckf.xY().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            iV(300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iV(int i) {
        this.cjV.postDelayed(new am(this), i);
    }

    private void j(Bundle bundle) {
        PersonChangeData personChangeData;
        this.ckj = new an(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.ckf = new com.baidu.tbadk.coreExtra.c.d(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agz() {
        BitmapDrawable bitmapDrawable;
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.cjY.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.aQg);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aRB.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.ckf.xY());
    }

    private void FY() {
        this.aRB = (HeadImageView) findViewById(i.f.photo);
        this.aRB.setIsRound(false);
        this.aRB.setAutoChangeStyle(true);
        this.aRB.setDrawBorder(false);
        this.aRB.setOnClickListener(new ao(this));
        this.bsb = com.baidu.tbadk.imageManager.c.Cs().fi(this.ckf.xY().getPortrait());
        this.aRB.d(this.ckf.xY().getPortrait(), 25, false);
        this.aQg = (LinearLayout) findViewById(i.f.parent);
        this.cjV = (ScrollView) findViewById(i.f.person_change_scroll);
        this.cjX = (LinearLayout) findViewById(i.f.person_sex);
        this.cjY = (TextView) findViewById(i.f.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ckn);
        this.mNavigationBar.setTitleText(getResources().getString(i.h.my_info));
        this.cjU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null);
        this.byj = (TextView) this.cjU.findViewById(i.f.right_textview);
        this.byj.setText(getPageContext().getString(i.h.save));
        this.cjU.setEnabled(false);
        com.baidu.tbadk.core.util.al.b(this.byj, i.c.navi_op_text, 1);
        this.cjU.setOnClickListener(new ap(this));
        this.cjX.setOnClickListener(new aq(this));
        this.cjZ = (LinearLayout) findViewById(i.f.intro_click);
        this.cjZ.setOnClickListener(new ar(this));
        this.cjZ.setOnTouchListener(new as(this));
        this.cjW = (TextView) findViewById(i.f.nick_name_show);
        this.cjW.setText(this.ckf.xY().getName());
        this.aRm = (TextView) findViewById(i.f.intro);
        if (this.ckf.xY().getIntro() != null && this.ckf.xY().getIntro().length() > 0) {
            this.aRm.setText(this.ckf.xY().getIntro());
        } else {
            this.aRm.setText(getPageContext().getString(i.h.add_intro));
        }
        this.mEdit = (EditText) findViewById(i.f.edit);
        this.mEdit.setText(this.ckf.xY().getIntro());
        this.mEdit.setOnFocusChangeListener(new at(this));
        this.mEdit.setOnTouchListener(new af(this));
        this.mEdit.setOnClickListener(new ag(this));
        this.mEdit.addTextChangedListener(new ah(this));
        if (this.ckf.xY().getSex() == 1) {
            this.mSex = 1;
            this.cjY.setText(i.h.man);
        } else if (this.ckf.xY().getSex() == 2) {
            this.mSex = 2;
            this.cjY.setText(i.h.woman);
        } else {
            this.cjY.setText(i.h.change_sex);
        }
        this.cka = (LinearLayout) findViewById(i.f.intro_text_tip);
        this.ckb = (TextView) findViewById(i.f.intro_text_tip_num);
        this.ckc = (TextView) findViewById(i.f.intro_text_tip_divider);
        this.ckd = (TextView) findViewById(i.f.intro_text_tip_limit);
        agz();
        this.cki = (ProgressBar) findViewById(i.f.image_progress);
        this.ckk = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.ckk.ct(getPageContext().getString(i.h.confirm_giveup));
        this.ckk.a(getPageContext().getString(i.h.alert_yes_button), new ai(this));
        this.ckk.b(getPageContext().getString(i.h.cancel), new aj(this));
        this.ckk.b(getPageContext());
    }

    public void agA() {
        String[] strArr = {getPageContext().getString(i.h.change_photo), getPageContext().getString(i.h.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bI(i.h.operation);
        cVar.a(strArr, new ak(this));
        cVar.d(getPageContext());
        cVar.sX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agB() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = com.baidu.tbadk.core.util.al.getColor(i.c.person_change_up_limit_text);
        } else {
            color = com.baidu.tbadk.core.util.al.getColor(i.c.person_change_not_up_limit_text);
        }
        iW(color);
    }

    private void iW(int i) {
        this.ckb.setTextColor(i);
        this.ckc.setTextColor(i);
        this.ckd.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agC() {
        if (this.ckf != null && this.ckf.xY() != null) {
            agx();
            this.ckf.xY().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.ckf.xY().setSex(this.mSex);
            if (this.ckh == null) {
                this.ckh = new b(this.ckf);
                this.ckh.setPriority(3);
                this.ckh.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agD() {
        if (this.ckl == null) {
            this.ckl = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            String string = getPageContext().getString(i.h.man);
            String string2 = getPageContext().getString(i.h.woman);
            this.ckl.bI(i.h.choose_sex);
            this.ckl.a(new String[]{string, string2}, new al(this, string, string2));
            this.ckl.d(getPageContext());
        }
        this.ckl.sX();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            agx();
            this.ckn.onClick(null);
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
                            L(intent);
                            return;
                        } else {
                            getAlbumDataFromImage(intent);
                            return;
                        }
                    }
                    return;
                case 12009:
                case 12010:
                    this.ckf.xY().setPhotoChanged(true);
                    agE();
                    return;
                case 12014:
                    this.ckf.xY().setPhotoChanged(true);
                    if (intent != null) {
                        this.aRB.setImageBitmap(null);
                        this.aRB.d(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12010:
                    com.baidu.tbadk.core.util.ak.c(getPageContext());
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

    private void L(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void agE() {
        if (this.ckg != null) {
            this.ckg.cancel();
        }
        this.bsb = null;
        this.ckg = new a(this, null);
        this.ckg.execute(new Object[0]);
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
            PersonChangeActivity.this.cki.setVisibility(0);
            PersonChangeActivity.this.aRB.setImageDrawable(null);
            PersonChangeActivity.this.bsb = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.n.ab(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.ckg = null;
            PersonChangeActivity.this.cki.setVisibility(8);
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
            PersonChangeActivity.this.ckg = null;
            PersonChangeActivity.this.cki.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.bsb = new com.baidu.adp.widget.a.a(bitmap, false, null);
                PersonChangeActivity.this.bsb.a(PersonChangeActivity.this.aRB);
                com.baidu.tbadk.imageManager.c.Cs().b(PersonChangeActivity.this.ckf.xY().getPortrait(), PersonChangeActivity.this.bsb, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private com.baidu.tbadk.core.util.v Tv = null;
        private com.baidu.tbadk.coreExtra.c.d ckf;

        public b(com.baidu.tbadk.coreExtra.c.d dVar) {
            this.ckf = null;
            this.ckf = dVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.ckh = null;
            if (this.Tv != null) {
                this.Tv.gJ();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.ckh = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.Tv != null) {
                if (this.Tv.uj().va().qZ()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(i.h.success));
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.cjT.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.ckf.xY());
                    } else {
                        intent.putExtra("data", this.ckf.xY());
                    }
                    TbadkCoreApplication.m411getInst().setPersonChangeData(this.ckf.xY());
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.finish();
                } else {
                    PersonChangeActivity.this.showToast(this.Tv.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(i.h.saving), PersonChangeActivity.this.ckj);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.ckf != null) {
                this.Tv = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_MODIFY);
                this.Tv.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.ckf.xY().getSex()));
                this.Tv.o("intro", this.ckf.xY().getIntro());
                this.Tv.tL();
                if (this.Tv.uj().va().qZ()) {
                    com.baidu.tieba.tbadkCore.util.k.ave();
                }
            }
            return null;
        }
    }
}
