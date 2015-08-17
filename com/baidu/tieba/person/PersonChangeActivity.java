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
    private View cja;
    private Boolean ciZ = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView bxC = null;
    private LinearLayout aPS = null;
    private ScrollView cjb = null;
    private TextView cjc = null;
    private LinearLayout cjd = null;
    private TextView cje = null;
    private LinearLayout cjf = null;
    private TextView aQY = null;
    private EditText mEdit = null;
    private LinearLayout cjg = null;
    private TextView cjh = null;
    private TextView cji = null;
    private TextView cjj = null;
    private InputMethodManager mInputManager = null;
    private boolean cjk = false;
    private com.baidu.tbadk.coreExtra.c.d cjl = null;
    protected HeadImageView aRn = null;
    private com.baidu.adp.widget.a.a brv = null;
    private a cjm = null;
    private b cjn = null;
    private ProgressBar aEW = null;
    private DialogInterface.OnCancelListener cjo = null;
    private com.baidu.tbadk.core.dialog.a cjp = null;
    private com.baidu.tbadk.core.dialog.c cjq = null;
    private boolean chV = false;
    private int mSex = 0;
    private final int cjr = 50;
    private final View.OnClickListener cjs = new ae(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        j(bundle);
        FO();
        if (bundle != null) {
            this.ciZ = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.ciZ = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cjm != null) {
            this.cjm.cancel();
        }
        if (this.cjn != null) {
            this.cjn.cancel();
        }
        if (this.aEW != null) {
            this.aEW.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.cjk = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.cjk) {
            agh();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agh() {
        if (this.mEdit.getVisibility() == 0) {
            this.cjg.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.aQY.setText(replaceAll);
            } else {
                this.aQY.setText(getPageContext().getString(i.C0057i.add_intro));
            }
            if (this.cjl.xR().getIntro() == null || !this.cjl.xR().getIntro().equals(replaceAll)) {
                this.chV = true;
            }
            this.cjl.xR().setIntro(replaceAll);
            this.aQY.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agi() {
        if (this.mEdit.getVisibility() != 0) {
            this.aQY.setVisibility(8);
            this.mEdit.setText(this.cjl.xR().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            iJ(300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iJ(int i) {
        this.cjb.postDelayed(new am(this), i);
    }

    private void j(Bundle bundle) {
        PersonChangeData personChangeData;
        this.cjo = new an(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.cjl = new com.baidu.tbadk.coreExtra.c.d(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agj() {
        BitmapDrawable bitmapDrawable;
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.al.getDrawable(i.e.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.cje.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.aPS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aRn.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.cjl.xR());
    }

    private void FO() {
        this.aRn = (HeadImageView) findViewById(i.f.photo);
        this.aRn.setIsRound(false);
        this.aRn.setAutoChangeStyle(true);
        this.aRn.setDrawBorder(false);
        this.aRn.setOnClickListener(new ao(this));
        this.brv = com.baidu.tbadk.imageManager.c.Ce().fa(this.cjl.xR().getPortrait());
        this.aRn.d(this.cjl.xR().getPortrait(), 25, false);
        this.aPS = (LinearLayout) findViewById(i.f.parent);
        this.cjb = (ScrollView) findViewById(i.f.person_change_scroll);
        this.cjd = (LinearLayout) findViewById(i.f.person_sex);
        this.cje = (TextView) findViewById(i.f.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cjs);
        this.mNavigationBar.setTitleText(getResources().getString(i.C0057i.my_info));
        this.cja = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null);
        this.bxC = (TextView) this.cja.findViewById(i.f.right_textview);
        this.bxC.setText(getPageContext().getString(i.C0057i.save));
        this.cja.setEnabled(false);
        com.baidu.tbadk.core.util.al.b(this.bxC, i.c.navi_op_text, 1);
        this.cja.setOnClickListener(new ap(this));
        this.cjd.setOnClickListener(new aq(this));
        this.cjf = (LinearLayout) findViewById(i.f.intro_click);
        this.cjf.setOnClickListener(new ar(this));
        this.cjf.setOnTouchListener(new as(this));
        this.cjc = (TextView) findViewById(i.f.nick_name_show);
        this.cjc.setText(this.cjl.xR().getName());
        this.aQY = (TextView) findViewById(i.f.intro);
        if (this.cjl.xR().getIntro() != null && this.cjl.xR().getIntro().length() > 0) {
            this.aQY.setText(this.cjl.xR().getIntro());
        } else {
            this.aQY.setText(getPageContext().getString(i.C0057i.add_intro));
        }
        this.mEdit = (EditText) findViewById(i.f.edit);
        this.mEdit.setText(this.cjl.xR().getIntro());
        this.mEdit.setOnFocusChangeListener(new at(this));
        this.mEdit.setOnTouchListener(new af(this));
        this.mEdit.setOnClickListener(new ag(this));
        this.mEdit.addTextChangedListener(new ah(this));
        if (this.cjl.xR().getSex() == 1) {
            this.mSex = 1;
            this.cje.setText(i.C0057i.man);
        } else if (this.cjl.xR().getSex() == 2) {
            this.mSex = 2;
            this.cje.setText(i.C0057i.woman);
        } else {
            this.cje.setText(i.C0057i.change_sex);
        }
        this.cjg = (LinearLayout) findViewById(i.f.intro_text_tip);
        this.cjh = (TextView) findViewById(i.f.intro_text_tip_num);
        this.cji = (TextView) findViewById(i.f.intro_text_tip_divider);
        this.cjj = (TextView) findViewById(i.f.intro_text_tip_limit);
        agj();
        this.aEW = (ProgressBar) findViewById(i.f.image_progress);
        this.cjp = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cjp.cn(getPageContext().getString(i.C0057i.confirm_giveup));
        this.cjp.a(getPageContext().getString(i.C0057i.alert_yes_button), new ai(this));
        this.cjp.b(getPageContext().getString(i.C0057i.cancel), new aj(this));
        this.cjp.b(getPageContext());
    }

    public void agk() {
        String[] strArr = {getPageContext().getString(i.C0057i.change_photo), getPageContext().getString(i.C0057i.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bF(i.C0057i.operation);
        cVar.a(strArr, new ak(this));
        cVar.d(getPageContext());
        cVar.sS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agl() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = com.baidu.tbadk.core.util.al.getColor(i.c.person_change_up_limit_text);
        } else {
            color = com.baidu.tbadk.core.util.al.getColor(i.c.person_change_not_up_limit_text);
        }
        iK(color);
    }

    private void iK(int i) {
        this.cjh.setTextColor(i);
        this.cji.setTextColor(i);
        this.cjj.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agm() {
        if (this.cjl != null && this.cjl.xR() != null) {
            agh();
            this.cjl.xR().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.cjl.xR().setSex(this.mSex);
            if (this.cjn == null) {
                this.cjn = new b(this.cjl);
                this.cjn.setPriority(3);
                this.cjn.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agn() {
        if (this.cjq == null) {
            this.cjq = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            String string = getPageContext().getString(i.C0057i.man);
            String string2 = getPageContext().getString(i.C0057i.woman);
            this.cjq.bF(i.C0057i.choose_sex);
            this.cjq.a(new String[]{string, string2}, new al(this, string, string2));
            this.cjq.d(getPageContext());
        }
        this.cjq.sS();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            agh();
            this.cjs.onClick(null);
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
                    this.cjl.xR().setPhotoChanged(true);
                    ago();
                    return;
                case 12014:
                    this.cjl.xR().setPhotoChanged(true);
                    if (intent != null) {
                        this.aRn.setImageBitmap(null);
                        this.aRn.d(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
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

    private void ago() {
        if (this.cjm != null) {
            this.cjm.cancel();
        }
        this.brv = null;
        this.cjm = new a(this, null);
        this.cjm.execute(new Object[0]);
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
            PersonChangeActivity.this.aEW.setVisibility(0);
            PersonChangeActivity.this.aRn.setImageDrawable(null);
            PersonChangeActivity.this.brv = null;
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
            PersonChangeActivity.this.cjm = null;
            PersonChangeActivity.this.aEW.setVisibility(8);
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
            PersonChangeActivity.this.cjm = null;
            PersonChangeActivity.this.aEW.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.brv = new com.baidu.adp.widget.a.a(bitmap, false, null);
                PersonChangeActivity.this.brv.a(PersonChangeActivity.this.aRn);
                com.baidu.tbadk.imageManager.c.Ce().b(PersonChangeActivity.this.cjl.xR().getPortrait(), PersonChangeActivity.this.brv, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private com.baidu.tbadk.core.util.v Tu = null;
        private com.baidu.tbadk.coreExtra.c.d cjl;

        public b(com.baidu.tbadk.coreExtra.c.d dVar) {
            this.cjl = null;
            this.cjl = dVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.cjn = null;
            if (this.Tu != null) {
                this.Tu.gM();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.cjn = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.Tu != null) {
                if (this.Tu.ue().uW().rb()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(i.C0057i.success));
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.ciZ.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cjl.xR());
                    } else {
                        intent.putExtra("data", this.cjl.xR());
                    }
                    TbadkCoreApplication.m411getInst().setPersonChangeData(this.cjl.xR());
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.finish();
                } else {
                    PersonChangeActivity.this.showToast(this.Tu.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(i.C0057i.saving), PersonChangeActivity.this.cjo);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.cjl != null) {
                this.Tu = new com.baidu.tbadk.core.util.v(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_MODIFY);
                this.Tu.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.cjl.xR().getSex()));
                this.Tu.o("intro", this.cjl.xR().getIntro());
                this.Tu.tG();
                if (this.Tu.ue().uW().rb()) {
                    com.baidu.tieba.tbadkCore.util.k.aqQ();
                }
            }
            return null;
        }
    }
}
