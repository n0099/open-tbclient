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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private View cKy;
    private Boolean cKx = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView bQX = null;
    private LinearLayout aUy = null;
    private ScrollView cKz = null;
    private TextView cKA = null;
    private LinearLayout cKB = null;
    private TextView cKC = null;
    private LinearLayout cKD = null;
    private TextView aVE = null;
    private EditText mEdit = null;
    private LinearLayout cKE = null;
    private TextView cKF = null;
    private TextView cKG = null;
    private TextView cKH = null;
    private InputMethodManager mInputManager = null;
    private boolean cKI = false;
    private av cKJ = null;
    protected HeadImageView aVU = null;
    private com.baidu.adp.widget.a.a bKU = null;
    private a cKK = null;
    private b cKL = null;
    private ProgressBar cKM = null;
    private DialogInterface.OnCancelListener cKN = null;
    private com.baidu.tbadk.core.dialog.a cKO = null;
    private com.baidu.tbadk.core.dialog.c cKP = null;
    private boolean cJo = false;
    private int mSex = 0;
    private final int cKQ = 50;
    private final View.OnClickListener cKR = new af(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.g.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        l(bundle);
        GS();
        if (bundle != null) {
            this.cKx = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.cKx = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cKK != null) {
            this.cKK.cancel();
        }
        if (this.cKL != null) {
            this.cKL.cancel();
        }
        if (this.cKM != null) {
            this.cKM.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.cKI = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.cKI) {
            anB();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anB() {
        if (this.mEdit.getVisibility() == 0) {
            this.cKE.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.aVE.setText(replaceAll);
            } else {
                this.aVE.setText(getPageContext().getString(n.i.add_intro));
            }
            if (this.cKJ.anJ().getIntro() == null || !this.cKJ.anJ().getIntro().equals(replaceAll)) {
                this.cJo = true;
            }
            this.cKJ.anJ().setIntro(replaceAll);
            this.aVE.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anC() {
        if (this.mEdit.getVisibility() != 0) {
            this.aVE.setVisibility(8);
            this.mEdit.setText(this.cKJ.anJ().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            kn(300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kn(int i) {
        this.cKz.postDelayed(new an(this), i);
    }

    private void l(Bundle bundle) {
        PersonChangeData personChangeData;
        this.cKN = new ao(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.cKJ = new av(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anD() {
        BitmapDrawable bitmapDrawable;
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.as.getDrawable(n.e.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.cKC.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().af(i == 1);
        getLayoutMode().k(this.aUy);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aVU.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.cKJ.anJ());
    }

    private void GS() {
        this.aVU = (HeadImageView) findViewById(n.f.photo);
        this.aVU.setIsRound(false);
        this.aVU.setAutoChangeStyle(true);
        this.aVU.setDrawBorder(false);
        this.aVU.setOnClickListener(new ap(this));
        this.bKU = com.baidu.tbadk.imageManager.c.CX().fE(this.cKJ.anJ().getPortrait());
        this.aVU.d(this.cKJ.anJ().getPortrait(), 25, false);
        this.aUy = (LinearLayout) findViewById(n.f.parent);
        this.cKz = (ScrollView) findViewById(n.f.person_change_scroll);
        this.cKB = (LinearLayout) findViewById(n.f.person_sex);
        this.cKC = (TextView) findViewById(n.f.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cKR);
        this.mNavigationBar.setTitleText(getResources().getString(n.i.my_info));
        this.cKy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.navigation_right_button_layout, (View.OnClickListener) null);
        this.bQX = (TextView) this.cKy.findViewById(n.f.right_textview);
        this.bQX.setText(getPageContext().getString(n.i.save));
        this.cKy.setEnabled(false);
        com.baidu.tbadk.core.util.as.b(this.bQX, n.c.navi_op_text, 1);
        this.cKy.setOnClickListener(new aq(this));
        this.cKB.setOnClickListener(new ar(this));
        this.cKD = (LinearLayout) findViewById(n.f.intro_click);
        this.cKD.setOnClickListener(new as(this));
        this.cKD.setOnTouchListener(new at(this));
        this.cKA = (TextView) findViewById(n.f.nick_name_show);
        this.cKA.setText(this.cKJ.anJ().getName());
        this.aVE = (TextView) findViewById(n.f.intro);
        if (this.cKJ.anJ().getIntro() != null && this.cKJ.anJ().getIntro().length() > 0) {
            this.aVE.setText(this.cKJ.anJ().getIntro());
        } else {
            this.aVE.setText(getPageContext().getString(n.i.add_intro));
        }
        this.mEdit = (EditText) findViewById(n.f.edit);
        this.mEdit.setText(this.cKJ.anJ().getIntro());
        this.mEdit.setOnFocusChangeListener(new au(this));
        this.mEdit.setOnTouchListener(new ag(this));
        this.mEdit.setOnClickListener(new ah(this));
        this.mEdit.addTextChangedListener(new ai(this));
        if (this.cKJ.anJ().getSex() == 1) {
            this.mSex = 1;
            this.cKC.setText(n.i.man);
        } else if (this.cKJ.anJ().getSex() == 2) {
            this.mSex = 2;
            this.cKC.setText(n.i.woman);
        } else {
            this.cKC.setText(n.i.change_sex);
        }
        this.cKE = (LinearLayout) findViewById(n.f.intro_text_tip);
        this.cKF = (TextView) findViewById(n.f.intro_text_tip_num);
        this.cKG = (TextView) findViewById(n.f.intro_text_tip_divider);
        this.cKH = (TextView) findViewById(n.f.intro_text_tip_limit);
        anD();
        this.cKM = (ProgressBar) findViewById(n.f.image_progress);
        this.cKO = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cKO.cC(getPageContext().getString(n.i.confirm_giveup));
        this.cKO.a(getPageContext().getString(n.i.alert_yes_button), new aj(this));
        this.cKO.b(getPageContext().getString(n.i.cancel), new ak(this));
        this.cKO.b(getPageContext());
    }

    public void anE() {
        String[] strArr = {getPageContext().getString(n.i.change_photo), getPageContext().getString(n.i.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bQ(n.i.operation);
        cVar.a(strArr, new al(this));
        cVar.d(getPageContext());
        cVar.tz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anF() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = com.baidu.tbadk.core.util.as.getColor(n.c.person_change_up_limit_text);
        } else {
            color = com.baidu.tbadk.core.util.as.getColor(n.c.person_change_not_up_limit_text);
        }
        ko(color);
    }

    private void ko(int i) {
        this.cKF.setTextColor(i);
        this.cKG.setTextColor(i);
        this.cKH.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anG() {
        if (this.cKJ != null && this.cKJ.anJ() != null) {
            anB();
            if (!com.baidu.adp.lib.util.i.iP()) {
                showToast(n.i.neterror);
                return;
            }
            this.cKJ.anJ().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.cKJ.anJ().setSex(this.mSex);
            if (this.cKL == null) {
                this.cKL = new b(this.cKJ);
                this.cKL.setPriority(3);
                this.cKL.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anH() {
        if (this.cKP == null) {
            this.cKP = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            String string = getPageContext().getString(n.i.man);
            String string2 = getPageContext().getString(n.i.woman);
            this.cKP.bQ(n.i.choose_sex);
            this.cKP.a(new String[]{string, string2}, new am(this, string, string2));
            this.cKP.d(getPageContext());
        }
        this.cKP.tz();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            anB();
            this.cKR.onClick(null);
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
                    this.cKJ.anJ().setPhotoChanged(true);
                    anI();
                    return;
                case 12014:
                    this.cKJ.anJ().setPhotoChanged(true);
                    if (intent != null) {
                        this.aVU.setImageBitmap(null);
                        this.aVU.d(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12010:
                    com.baidu.tbadk.core.util.ar.c(getPageContext());
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

    private void anI() {
        if (this.cKK != null) {
            this.cKK.cancel();
        }
        this.bKU = null;
        this.cKK = new a(this, null);
        this.cKK.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUpdateMessage() {
        if (this.cKJ != null && this.cKJ.anJ() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.cKJ.anJ()));
        }
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
            PersonChangeActivity.this.cKM.setVisibility(0);
            PersonChangeActivity.this.aVU.setImageDrawable(null);
            PersonChangeActivity.this.bKU = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.n.X(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.cKK = null;
            PersonChangeActivity.this.cKM.setVisibility(8);
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
            PersonChangeActivity.this.cKK = null;
            PersonChangeActivity.this.cKM.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.bKU = new com.baidu.adp.widget.a.a(bitmap, false, null);
                PersonChangeActivity.this.bKU.a(PersonChangeActivity.this.aVU);
                com.baidu.tbadk.imageManager.c.CX().a(PersonChangeActivity.this.cKJ.anJ().getPortrait(), PersonChangeActivity.this.bKU, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private com.baidu.tbadk.core.util.ab Ty = null;
        private av cKJ;

        public b(av avVar) {
            this.cKJ = null;
            this.cKJ = avVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.cKL = null;
            if (this.Ty != null) {
                this.Ty.gL();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.cKL = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.Ty != null) {
                if (this.Ty.uM().vG().rf()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(n.i.success));
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.cKx.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cKJ.anJ());
                    } else {
                        intent.putExtra("data", this.cKJ.anJ());
                    }
                    TbadkCoreApplication.m411getInst().setPersonChangeData(this.cKJ.anJ());
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.sendUpdateMessage();
                    PersonChangeActivity.this.finish();
                } else {
                    PersonChangeActivity.this.showToast(this.Ty.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(n.i.saving), PersonChangeActivity.this.cKN);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.cKJ != null) {
                this.Ty = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_MODIFY);
                this.Ty.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.cKJ.anJ().getSex()));
                this.Ty.o("intro", this.cKJ.anJ().getIntro());
                this.Ty.uo();
                if (this.Ty.uM().vG().rf()) {
                    com.baidu.tieba.tbadkCore.util.m.aDW();
                }
            }
            return null;
        }
    }
}
