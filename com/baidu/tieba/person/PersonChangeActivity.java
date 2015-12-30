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
    private View cOO;
    private Boolean cON = false;
    private final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView bUD = null;
    private LinearLayout aYz = null;
    private ScrollView cOP = null;
    private TextView cOQ = null;
    private LinearLayout cOR = null;
    private TextView cOS = null;
    private LinearLayout cOT = null;
    private TextView aZE = null;
    private EditText mEdit = null;
    private LinearLayout cOU = null;
    private TextView cOV = null;
    private TextView cOW = null;
    private TextView cOX = null;
    private InputMethodManager mInputManager = null;
    private boolean cOY = false;
    private av cOZ = null;
    protected HeadImageView aZU = null;
    private com.baidu.adp.widget.a.a bOB = null;
    private a cPa = null;
    private b cPb = null;
    private ProgressBar cPc = null;
    private DialogInterface.OnCancelListener cPd = null;
    private com.baidu.tbadk.core.dialog.a cPe = null;
    private com.baidu.tbadk.core.dialog.c cPf = null;
    private boolean cNE = false;
    private int mSex = 0;
    private final int cPg = 50;
    private final View.OnClickListener cPh = new af(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(n.h.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        h(bundle);
        GH();
        if (bundle != null) {
            this.cON = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.cON = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cPa != null) {
            this.cPa.cancel();
        }
        if (this.cPb != null) {
            this.cPb.cancel();
        }
        if (this.cPc != null) {
            this.cPc.setVisibility(8);
        }
        if (this.mEdit != null) {
            this.mEdit.addTextChangedListener(null);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.cOY = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.cOY) {
            aoM();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoM() {
        if (this.mEdit.getVisibility() == 0) {
            this.cOU.setVisibility(8);
            this.mEdit.setVisibility(8);
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.aZE.setText(replaceAll);
            } else {
                this.aZE.setText(getPageContext().getString(n.j.add_intro));
            }
            if (this.cOZ.aoU().getIntro() == null || !this.cOZ.aoU().getIntro().equals(replaceAll)) {
                this.cNE = true;
            }
            this.cOZ.aoU().setIntro(replaceAll);
            this.aZE.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoN() {
        if (this.mEdit.getVisibility() != 0) {
            this.aZE.setVisibility(8);
            this.mEdit.setText(this.cOZ.aoU().getIntro());
            this.mEdit.setVisibility(0);
            this.mEdit.setSelection(this.mEdit.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            kK(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kK(int i) {
        this.cOP.postDelayed(new an(this), i);
    }

    private void h(Bundle bundle) {
        PersonChangeData personChangeData;
        this.cPd = new ao(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.cOZ = new av(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoO() {
        BitmapDrawable bitmapDrawable;
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.as.getDrawable(n.f.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.cOS.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ac(i == 1);
        getLayoutMode().k(this.aYz);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.aZU.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.cOZ.aoU());
    }

    private void GH() {
        this.aZU = (HeadImageView) findViewById(n.g.photo);
        this.aZU.setIsRound(false);
        this.aZU.setAutoChangeStyle(true);
        this.aZU.setDrawBorder(false);
        this.aZU.setOnClickListener(new ap(this));
        this.aZU.d(com.baidu.tbadk.core.util.r.dm(this.cOZ.aoU().getPortrait()), 25, false);
        this.aYz = (LinearLayout) findViewById(n.g.parent);
        this.cOP = (ScrollView) findViewById(n.g.person_change_scroll);
        this.cOR = (LinearLayout) findViewById(n.g.person_sex);
        this.cOS = (TextView) findViewById(n.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cPh);
        this.mNavigationBar.setTitleText(getResources().getString(n.j.my_info));
        this.cOO = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.bUD = (TextView) this.cOO.findViewById(n.g.right_textview);
        this.bUD.setText(getPageContext().getString(n.j.save));
        this.cOO.setEnabled(false);
        com.baidu.tbadk.core.util.as.b(this.bUD, n.d.navi_op_text, 1);
        this.cOO.setOnClickListener(new aq(this));
        this.cOR.setOnClickListener(new ar(this));
        this.cOT = (LinearLayout) findViewById(n.g.intro_click);
        this.cOT.setOnClickListener(new as(this));
        this.cOT.setOnTouchListener(new at(this));
        this.cOQ = (TextView) findViewById(n.g.nick_name_show);
        this.cOQ.setText(this.cOZ.aoU().getName());
        this.aZE = (TextView) findViewById(n.g.intro);
        if (this.cOZ.aoU().getIntro() != null && this.cOZ.aoU().getIntro().length() > 0) {
            this.aZE.setText(this.cOZ.aoU().getIntro());
        } else {
            this.aZE.setText(getPageContext().getString(n.j.add_intro));
        }
        this.mEdit = (EditText) findViewById(n.g.edit);
        this.mEdit.setText(this.cOZ.aoU().getIntro());
        this.mEdit.setOnFocusChangeListener(new au(this));
        this.mEdit.setOnTouchListener(new ag(this));
        this.mEdit.setOnClickListener(new ah(this));
        this.mEdit.addTextChangedListener(new ai(this));
        if (this.cOZ.aoU().getSex() == 1) {
            this.mSex = 1;
            this.cOS.setText(n.j.man);
        } else if (this.cOZ.aoU().getSex() == 2) {
            this.mSex = 2;
            this.cOS.setText(n.j.woman);
        } else {
            this.cOS.setText(n.j.change_sex);
        }
        this.cOU = (LinearLayout) findViewById(n.g.intro_text_tip);
        this.cOV = (TextView) findViewById(n.g.intro_text_tip_num);
        this.cOW = (TextView) findViewById(n.g.intro_text_tip_divider);
        this.cOX = (TextView) findViewById(n.g.intro_text_tip_limit);
        aoO();
        this.cPc = (ProgressBar) findViewById(n.g.image_progress);
        this.cPe = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cPe.cF(getPageContext().getString(n.j.confirm_giveup));
        this.cPe.a(getPageContext().getString(n.j.alert_yes_button), new aj(this));
        this.cPe.b(getPageContext().getString(n.j.cancel), new ak(this));
        this.cPe.b(getPageContext());
    }

    public void aoP() {
        String[] strArr = {getPageContext().getString(n.j.change_photo), getPageContext().getString(n.j.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bJ(n.j.operation);
        cVar.a(strArr, new al(this));
        cVar.d(getPageContext());
        cVar.tj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoQ() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = com.baidu.tbadk.core.util.as.getColor(n.d.person_change_up_limit_text);
        } else {
            color = com.baidu.tbadk.core.util.as.getColor(n.d.person_change_not_up_limit_text);
        }
        kL(color);
    }

    private void kL(int i) {
        this.cOV.setTextColor(i);
        this.cOW.setTextColor(i);
        this.cOX.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoR() {
        if (this.cOZ != null && this.cOZ.aoU() != null) {
            aoM();
            if (!com.baidu.adp.lib.util.i.iQ()) {
                showToast(n.j.neterror);
                return;
            }
            this.cOZ.aoU().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
            this.cOZ.aoU().setSex(this.mSex);
            if (this.cPb == null) {
                this.cPb = new b(this.cOZ);
                this.cPb.setPriority(3);
                this.cPb.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoS() {
        if (this.cPf == null) {
            this.cPf = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            String string = getPageContext().getString(n.j.man);
            String string2 = getPageContext().getString(n.j.woman);
            this.cPf.bJ(n.j.choose_sex);
            this.cPf.a(new String[]{string, string2}, new am(this, string, string2));
            this.cPf.d(getPageContext());
        }
        this.cPf.tj();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aoM();
            this.cPh.onClick(null);
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
                            J(intent);
                            return;
                        } else {
                            getAlbumDataFromImage(intent);
                            return;
                        }
                    }
                    return;
                case 12009:
                case 12010:
                    this.cOZ.aoU().setPhotoChanged(true);
                    aoT();
                    return;
                case 12014:
                    this.cOZ.aoU().setPhotoChanged(true);
                    if (intent != null) {
                        this.aZU.setImageBitmap(null);
                        this.aZU.d(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
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

    private void J(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void aoT() {
        if (this.cPa != null) {
            this.cPa.cancel();
        }
        this.bOB = null;
        this.cPa = new a(this, null);
        this.cPa.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUpdateMessage() {
        if (this.cOZ != null && this.cOZ.aoU() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.cOZ.aoU()));
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
            PersonChangeActivity.this.cPc.setVisibility(0);
            PersonChangeActivity.this.aZU.setImageDrawable(null);
            PersonChangeActivity.this.bOB = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: j */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.n.W(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.cPa = null;
            PersonChangeActivity.this.cPc.setVisibility(8);
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
            PersonChangeActivity.this.cPa = null;
            PersonChangeActivity.this.cPc.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.bOB = new com.baidu.adp.widget.a.a(bitmap, false, null);
                PersonChangeActivity.this.bOB.a(PersonChangeActivity.this.aZU);
                com.baidu.tbadk.imageManager.c.CM().a(PersonChangeActivity.this.cOZ.aoU().getPortrait(), PersonChangeActivity.this.bOB, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private com.baidu.tbadk.core.util.ab Ua = null;
        private av cOZ;

        public b(av avVar) {
            this.cOZ = null;
            this.cOZ = avVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.cPb = null;
            if (this.Ua != null) {
                this.Ua.gL();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.cPb = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.Ua != null) {
                if (this.Ua.uw().vq().qO()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(n.j.success));
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.cON.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cOZ.aoU());
                    } else {
                        intent.putExtra("data", this.cOZ.aoU());
                    }
                    TbadkCoreApplication.m411getInst().setPersonChangeData(this.cOZ.aoU());
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.sendUpdateMessage();
                    PersonChangeActivity.this.finish();
                } else {
                    PersonChangeActivity.this.showToast(this.Ua.getErrorString());
                }
            }
            super.onPostExecute((b) str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(n.j.saving), PersonChangeActivity.this.cPd);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.cOZ != null) {
                this.Ua = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_MODIFY);
                this.Ua.o(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.cOZ.aoU().getSex()));
                this.Ua.o("intro", this.cOZ.aoU().getIntro());
                this.Ua.tY();
                if (this.Ua.uw().vq().qO()) {
                    com.baidu.tieba.tbadkCore.util.m.aGj();
                }
            }
            return null;
        }
    }
}
