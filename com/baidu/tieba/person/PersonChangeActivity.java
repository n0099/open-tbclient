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
    private View cpx;
    private Boolean cpw = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView bBl = null;
    private LinearLayout aPc = null;
    private ScrollView cpy = null;
    private TextView cpz = null;
    private LinearLayout cpA = null;
    private TextView cpB = null;
    private LinearLayout cpC = null;
    private TextView aQi = null;
    private EditText mEdit = null;
    private LinearLayout cpD = null;
    private TextView cpE = null;
    private TextView cpF = null;
    private TextView cpG = null;
    private InputMethodManager mInputManager = null;
    private boolean cpH = false;
    private au cpI = null;
    protected HeadImageView aQx = null;
    private com.baidu.adp.widget.a.a bvf = null;
    private a cpJ = null;
    private b cpK = null;
    private ProgressBar cpL = null;
    private DialogInterface.OnCancelListener cpM = null;
    private com.baidu.tbadk.core.dialog.a cpN = null;
    private com.baidu.tbadk.core.dialog.c cpO = null;

    /* renamed from: com  reason: collision with root package name */
    private boolean f128com = false;
    private int mSex = 0;
    private final int cpP = 50;
    private final View.OnClickListener cpQ = new ae(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.g.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        k(bundle);
        FS();
        if (bundle != null) {
            this.cpw = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.cpw = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cpJ != null) {
            this.cpJ.cancel();
        }
        if (this.cpK != null) {
            this.cpK.cancel();
        }
        if (this.cpL != null) {
            this.cpL.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.cpH = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.cpH) {
            aiw();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiw() {
        if (this.mEdit.getVisibility() == 0) {
            this.cpD.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.aQi.setText(replaceAll);
            } else {
                this.aQi.setText(getPageContext().getString(i.h.add_intro));
            }
            if (this.cpI.aiE().getIntro() == null || !this.cpI.aiE().getIntro().equals(replaceAll)) {
                this.f128com = true;
            }
            this.cpI.aiE().setIntro(replaceAll);
            this.aQi.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aix() {
        if (this.mEdit.getVisibility() != 0) {
            this.aQi.setVisibility(8);
            this.mEdit.setText(this.cpI.aiE().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            jf(300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jf(int i) {
        this.cpy.postDelayed(new am(this), i);
    }

    private void k(Bundle bundle) {
        PersonChangeData personChangeData;
        this.cpM = new an(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.cpI = new au(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiy() {
        BitmapDrawable bitmapDrawable;
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.am.getDrawable(i.e.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.cpB.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().k(this.aPc);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aQx.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.cpI.aiE());
    }

    private void FS() {
        this.aQx = (HeadImageView) findViewById(i.f.photo);
        this.aQx.setIsRound(false);
        this.aQx.setAutoChangeStyle(true);
        this.aQx.setDrawBorder(false);
        this.aQx.setOnClickListener(new ao(this));
        this.bvf = com.baidu.tbadk.imageManager.c.Cf().fn(this.cpI.aiE().getPortrait());
        this.aQx.d(this.cpI.aiE().getPortrait(), 25, false);
        this.aPc = (LinearLayout) findViewById(i.f.parent);
        this.cpy = (ScrollView) findViewById(i.f.person_change_scroll);
        this.cpA = (LinearLayout) findViewById(i.f.person_sex);
        this.cpB = (TextView) findViewById(i.f.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cpQ);
        this.mNavigationBar.setTitleText(getResources().getString(i.h.my_info));
        this.cpx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null);
        this.bBl = (TextView) this.cpx.findViewById(i.f.right_textview);
        this.bBl.setText(getPageContext().getString(i.h.save));
        this.cpx.setEnabled(false);
        com.baidu.tbadk.core.util.am.b(this.bBl, i.c.navi_op_text, 1);
        this.cpx.setOnClickListener(new ap(this));
        this.cpA.setOnClickListener(new aq(this));
        this.cpC = (LinearLayout) findViewById(i.f.intro_click);
        this.cpC.setOnClickListener(new ar(this));
        this.cpC.setOnTouchListener(new as(this));
        this.cpz = (TextView) findViewById(i.f.nick_name_show);
        this.cpz.setText(this.cpI.aiE().getName());
        this.aQi = (TextView) findViewById(i.f.intro);
        if (this.cpI.aiE().getIntro() != null && this.cpI.aiE().getIntro().length() > 0) {
            this.aQi.setText(this.cpI.aiE().getIntro());
        } else {
            this.aQi.setText(getPageContext().getString(i.h.add_intro));
        }
        this.mEdit = (EditText) findViewById(i.f.edit);
        this.mEdit.setText(this.cpI.aiE().getIntro());
        this.mEdit.setOnFocusChangeListener(new at(this));
        this.mEdit.setOnTouchListener(new af(this));
        this.mEdit.setOnClickListener(new ag(this));
        this.mEdit.addTextChangedListener(new ah(this));
        if (this.cpI.aiE().getSex() == 1) {
            this.mSex = 1;
            this.cpB.setText(i.h.man);
        } else if (this.cpI.aiE().getSex() == 2) {
            this.mSex = 2;
            this.cpB.setText(i.h.woman);
        } else {
            this.cpB.setText(i.h.change_sex);
        }
        this.cpD = (LinearLayout) findViewById(i.f.intro_text_tip);
        this.cpE = (TextView) findViewById(i.f.intro_text_tip_num);
        this.cpF = (TextView) findViewById(i.f.intro_text_tip_divider);
        this.cpG = (TextView) findViewById(i.f.intro_text_tip_limit);
        aiy();
        this.cpL = (ProgressBar) findViewById(i.f.image_progress);
        this.cpN = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cpN.ct(getPageContext().getString(i.h.confirm_giveup));
        this.cpN.a(getPageContext().getString(i.h.alert_yes_button), new ai(this));
        this.cpN.b(getPageContext().getString(i.h.cancel), new aj(this));
        this.cpN.b(getPageContext());
    }

    public void aiz() {
        String[] strArr = {getPageContext().getString(i.h.change_photo), getPageContext().getString(i.h.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bI(i.h.operation);
        cVar.a(strArr, new ak(this));
        cVar.d(getPageContext());
        cVar.sU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiA() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = com.baidu.tbadk.core.util.am.getColor(i.c.person_change_up_limit_text);
        } else {
            color = com.baidu.tbadk.core.util.am.getColor(i.c.person_change_not_up_limit_text);
        }
        jg(color);
    }

    private void jg(int i) {
        this.cpE.setTextColor(i);
        this.cpF.setTextColor(i);
        this.cpG.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiB() {
        if (this.cpI != null && this.cpI.aiE() != null) {
            aiw();
            this.cpI.aiE().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.cpI.aiE().setSex(this.mSex);
            if (this.cpK == null) {
                this.cpK = new b(this.cpI);
                this.cpK.setPriority(3);
                this.cpK.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiC() {
        if (this.cpO == null) {
            this.cpO = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            String string = getPageContext().getString(i.h.man);
            String string2 = getPageContext().getString(i.h.woman);
            this.cpO.bI(i.h.choose_sex);
            this.cpO.a(new String[]{string, string2}, new al(this, string, string2));
            this.cpO.d(getPageContext());
        }
        this.cpO.sU();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aiw();
            this.cpQ.onClick(null);
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
                    this.cpI.aiE().setPhotoChanged(true);
                    aiD();
                    return;
                case 12014:
                    this.cpI.aiE().setPhotoChanged(true);
                    if (intent != null) {
                        this.aQx.setImageBitmap(null);
                        this.aQx.d(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12010:
                    com.baidu.tbadk.core.util.al.c(getPageContext());
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

    private void aiD() {
        if (this.cpJ != null) {
            this.cpJ.cancel();
        }
        this.bvf = null;
        this.cpJ = new a(this, null);
        this.cpJ.execute(new Object[0]);
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
            PersonChangeActivity.this.cpL.setVisibility(0);
            PersonChangeActivity.this.aQx.setImageDrawable(null);
            PersonChangeActivity.this.bvf = null;
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
            PersonChangeActivity.this.cpJ = null;
            PersonChangeActivity.this.cpL.setVisibility(8);
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
            PersonChangeActivity.this.cpJ = null;
            PersonChangeActivity.this.cpL.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.bvf = new com.baidu.adp.widget.a.a(bitmap, false, null);
                PersonChangeActivity.this.bvf.a(PersonChangeActivity.this.aQx);
                com.baidu.tbadk.imageManager.c.Cf().b(PersonChangeActivity.this.cpI.aiE().getPortrait(), PersonChangeActivity.this.bvf, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private com.baidu.tbadk.core.util.w Th = null;
        private au cpI;

        public b(au auVar) {
            this.cpI = null;
            this.cpI = auVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.cpK = null;
            if (this.Th != null) {
                this.Th.gJ();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.cpK = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.Th != null) {
                if (this.Th.uh().uY().qV()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(i.h.success));
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.cpw.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cpI.aiE());
                    } else {
                        intent.putExtra("data", this.cpI.aiE());
                    }
                    TbadkCoreApplication.m411getInst().setPersonChangeData(this.cpI.aiE());
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.finish();
                } else {
                    PersonChangeActivity.this.showToast(this.Th.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(i.h.saving), PersonChangeActivity.this.cpM);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.cpI != null) {
                this.Th = new com.baidu.tbadk.core.util.w(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_MODIFY);
                this.Th.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.cpI.aiE().getSex()));
                this.Th.o("intro", this.cpI.aiE().getIntro());
                this.Th.tJ();
                if (this.Th.uh().uY().qV()) {
                    com.baidu.tieba.tbadkCore.util.m.axr();
                }
            }
            return null;
        }
    }
}
