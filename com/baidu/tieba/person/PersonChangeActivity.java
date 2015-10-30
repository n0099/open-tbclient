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
    private View cpI;
    private Boolean cpH = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView bBw = null;
    private LinearLayout aPn = null;
    private ScrollView cpJ = null;
    private TextView cpK = null;
    private LinearLayout cpL = null;
    private TextView cpM = null;
    private LinearLayout cpN = null;
    private TextView aQt = null;
    private EditText mEdit = null;
    private LinearLayout cpO = null;
    private TextView cpP = null;
    private TextView cpQ = null;
    private TextView cpR = null;
    private InputMethodManager mInputManager = null;
    private boolean cpS = false;
    private au cpT = null;
    protected HeadImageView aQI = null;
    private com.baidu.adp.widget.a.a bvq = null;
    private a cpU = null;
    private b cpV = null;
    private ProgressBar cpW = null;
    private DialogInterface.OnCancelListener cpX = null;
    private com.baidu.tbadk.core.dialog.a cpY = null;
    private com.baidu.tbadk.core.dialog.c cpZ = null;
    private boolean cox = false;
    private int mSex = 0;
    private final int cqa = 50;
    private final View.OnClickListener cqb = new ae(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        k(bundle);
        FO();
        if (bundle != null) {
            this.cpH = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.cpH = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cpU != null) {
            this.cpU.cancel();
        }
        if (this.cpV != null) {
            this.cpV.cancel();
        }
        if (this.cpW != null) {
            this.cpW.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.cpS = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.cpS) {
            ais();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ais() {
        if (this.mEdit.getVisibility() == 0) {
            this.cpO.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.aQt.setText(replaceAll);
            } else {
                this.aQt.setText(getPageContext().getString(i.h.add_intro));
            }
            if (this.cpT.aiA().getIntro() == null || !this.cpT.aiA().getIntro().equals(replaceAll)) {
                this.cox = true;
            }
            this.cpT.aiA().setIntro(replaceAll);
            this.aQt.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ait() {
        if (this.mEdit.getVisibility() != 0) {
            this.aQt.setVisibility(8);
            this.mEdit.setText(this.cpT.aiA().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            jf(300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jf(int i) {
        this.cpJ.postDelayed(new am(this), i);
    }

    private void k(Bundle bundle) {
        PersonChangeData personChangeData;
        this.cpX = new an(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.cpT = new au(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiu() {
        BitmapDrawable bitmapDrawable;
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.cpM.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.aPn);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aQI.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.cpT.aiA());
    }

    private void FO() {
        this.aQI = (HeadImageView) findViewById(i.f.photo);
        this.aQI.setIsRound(false);
        this.aQI.setAutoChangeStyle(true);
        this.aQI.setDrawBorder(false);
        this.aQI.setOnClickListener(new ao(this));
        this.bvq = com.baidu.tbadk.imageManager.c.Cc().fn(this.cpT.aiA().getPortrait());
        this.aQI.d(this.cpT.aiA().getPortrait(), 25, false);
        this.aPn = (LinearLayout) findViewById(i.f.parent);
        this.cpJ = (ScrollView) findViewById(i.f.person_change_scroll);
        this.cpL = (LinearLayout) findViewById(i.f.person_sex);
        this.cpM = (TextView) findViewById(i.f.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cqb);
        this.mNavigationBar.setTitleText(getResources().getString(i.h.my_info));
        this.cpI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null);
        this.bBw = (TextView) this.cpI.findViewById(i.f.right_textview);
        this.bBw.setText(getPageContext().getString(i.h.save));
        this.cpI.setEnabled(false);
        com.baidu.tbadk.core.util.an.b(this.bBw, i.c.navi_op_text, 1);
        this.cpI.setOnClickListener(new ap(this));
        this.cpL.setOnClickListener(new aq(this));
        this.cpN = (LinearLayout) findViewById(i.f.intro_click);
        this.cpN.setOnClickListener(new ar(this));
        this.cpN.setOnTouchListener(new as(this));
        this.cpK = (TextView) findViewById(i.f.nick_name_show);
        this.cpK.setText(this.cpT.aiA().getName());
        this.aQt = (TextView) findViewById(i.f.intro);
        if (this.cpT.aiA().getIntro() != null && this.cpT.aiA().getIntro().length() > 0) {
            this.aQt.setText(this.cpT.aiA().getIntro());
        } else {
            this.aQt.setText(getPageContext().getString(i.h.add_intro));
        }
        this.mEdit = (EditText) findViewById(i.f.edit);
        this.mEdit.setText(this.cpT.aiA().getIntro());
        this.mEdit.setOnFocusChangeListener(new at(this));
        this.mEdit.setOnTouchListener(new af(this));
        this.mEdit.setOnClickListener(new ag(this));
        this.mEdit.addTextChangedListener(new ah(this));
        if (this.cpT.aiA().getSex() == 1) {
            this.mSex = 1;
            this.cpM.setText(i.h.man);
        } else if (this.cpT.aiA().getSex() == 2) {
            this.mSex = 2;
            this.cpM.setText(i.h.woman);
        } else {
            this.cpM.setText(i.h.change_sex);
        }
        this.cpO = (LinearLayout) findViewById(i.f.intro_text_tip);
        this.cpP = (TextView) findViewById(i.f.intro_text_tip_num);
        this.cpQ = (TextView) findViewById(i.f.intro_text_tip_divider);
        this.cpR = (TextView) findViewById(i.f.intro_text_tip_limit);
        aiu();
        this.cpW = (ProgressBar) findViewById(i.f.image_progress);
        this.cpY = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cpY.cu(getPageContext().getString(i.h.confirm_giveup));
        this.cpY.a(getPageContext().getString(i.h.alert_yes_button), new ai(this));
        this.cpY.b(getPageContext().getString(i.h.cancel), new aj(this));
        this.cpY.b(getPageContext());
    }

    public void aiv() {
        String[] strArr = {getPageContext().getString(i.h.change_photo), getPageContext().getString(i.h.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bI(i.h.operation);
        cVar.a(strArr, new ak(this));
        cVar.d(getPageContext());
        cVar.sR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiw() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = com.baidu.tbadk.core.util.an.getColor(i.c.person_change_up_limit_text);
        } else {
            color = com.baidu.tbadk.core.util.an.getColor(i.c.person_change_not_up_limit_text);
        }
        jg(color);
    }

    private void jg(int i) {
        this.cpP.setTextColor(i);
        this.cpQ.setTextColor(i);
        this.cpR.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aix() {
        if (this.cpT != null && this.cpT.aiA() != null) {
            ais();
            this.cpT.aiA().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.cpT.aiA().setSex(this.mSex);
            if (this.cpV == null) {
                this.cpV = new b(this.cpT);
                this.cpV.setPriority(3);
                this.cpV.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiy() {
        if (this.cpZ == null) {
            this.cpZ = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            String string = getPageContext().getString(i.h.man);
            String string2 = getPageContext().getString(i.h.woman);
            this.cpZ.bI(i.h.choose_sex);
            this.cpZ.a(new String[]{string, string2}, new al(this, string, string2));
            this.cpZ.d(getPageContext());
        }
        this.cpZ.sR();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            ais();
            this.cqb.onClick(null);
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
                    this.cpT.aiA().setPhotoChanged(true);
                    aiz();
                    return;
                case 12014:
                    this.cpT.aiA().setPhotoChanged(true);
                    if (intent != null) {
                        this.aQI.setImageBitmap(null);
                        this.aQI.d(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
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

    private void aiz() {
        if (this.cpU != null) {
            this.cpU.cancel();
        }
        this.bvq = null;
        this.cpU = new a(this, null);
        this.cpU.execute(new Object[0]);
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
            PersonChangeActivity.this.cpW.setVisibility(0);
            PersonChangeActivity.this.aQI.setImageDrawable(null);
            PersonChangeActivity.this.bvq = null;
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
            PersonChangeActivity.this.cpU = null;
            PersonChangeActivity.this.cpW.setVisibility(8);
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
            PersonChangeActivity.this.cpU = null;
            PersonChangeActivity.this.cpW.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.bvq = new com.baidu.adp.widget.a.a(bitmap, false, null);
                PersonChangeActivity.this.bvq.a(PersonChangeActivity.this.aQI);
                com.baidu.tbadk.imageManager.c.Cc().b(PersonChangeActivity.this.cpT.aiA().getPortrait(), PersonChangeActivity.this.bvq, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private com.baidu.tbadk.core.util.w Ti = null;
        private au cpT;

        public b(au auVar) {
            this.cpT = null;
            this.cpT = auVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.cpV = null;
            if (this.Ti != null) {
                this.Ti.gJ();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.cpV = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.Ti != null) {
                if (this.Ti.ue().uW().qS()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(i.h.success));
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.cpH.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cpT.aiA());
                    } else {
                        intent.putExtra("data", this.cpT.aiA());
                    }
                    TbadkCoreApplication.m411getInst().setPersonChangeData(this.cpT.aiA());
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.finish();
                } else {
                    PersonChangeActivity.this.showToast(this.Ti.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(i.h.saving), PersonChangeActivity.this.cpX);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.cpT != null) {
                this.Ti = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_MODIFY);
                this.Ti.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.cpT.aiA().getSex()));
                this.Ti.o("intro", this.cpT.aiA().getIntro());
                this.Ti.tG();
                if (this.Ti.ue().uW().qS()) {
                    com.baidu.tieba.tbadkCore.util.m.axx();
                }
            }
            return null;
        }
    }
}
