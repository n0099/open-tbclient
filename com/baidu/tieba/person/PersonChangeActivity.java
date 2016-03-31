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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private View dsM;
    private Boolean dsK = false;
    private final WriteImagesInfo dsL = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView cjl = null;
    private LinearLayout bfy = null;
    private ScrollView dsN = null;
    private TextView dsO = null;
    private LinearLayout dsP = null;
    private TextView dsQ = null;
    private LinearLayout dsR = null;
    private TextView bgE = null;
    private EditText dsS = null;
    private LinearLayout dsT = null;
    private TextView dsU = null;
    private TextView dsV = null;
    private TextView dsW = null;
    private InputMethodManager mInputManager = null;
    private boolean dsX = false;
    private av dsY = null;
    protected HeadImageView bgU = null;
    private com.baidu.adp.widget.a.a cdd = null;
    private a dsZ = null;
    private b dta = null;
    private ProgressBar dtb = null;
    private DialogInterface.OnCancelListener dtc = null;
    private com.baidu.tbadk.core.dialog.a dtd = null;
    private com.baidu.tbadk.core.dialog.c dte = null;
    private boolean drA = false;
    private int mSex = 0;
    private final int dtf = 50;
    private final View.OnClickListener dtg = new af(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        q(bundle);
        JE();
        if (bundle != null) {
            this.dsK = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.dsK = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dsZ != null) {
            this.dsZ.cancel();
        }
        if (this.dta != null) {
            this.dta.cancel();
        }
        if (this.dtb != null) {
            this.dtb.setVisibility(8);
        }
        if (this.dsS != null) {
            this.dsS.addTextChangedListener(null);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.dsX = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.dsX) {
            aBk();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBk() {
        if (this.dsS.getVisibility() == 0) {
            this.dsT.setVisibility(8);
            this.dsS.setVisibility(8);
            String replaceAll = this.dsS.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.bgE.setText(replaceAll);
            } else {
                this.bgE.setText(getPageContext().getString(t.j.add_intro));
            }
            if (this.dsY.aBt().getIntro() == null || !this.dsY.aBt().getIntro().equals(replaceAll)) {
                this.drA = true;
            }
            this.dsY.aBt().setIntro(replaceAll);
            this.bgE.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.dsS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBl() {
        if (this.dsS.getVisibility() != 0) {
            this.bgE.setVisibility(8);
            this.dsS.setText(this.dsY.aBt().getIntro());
            this.dsS.setVisibility(0);
            this.dsS.setSelection(this.dsS.getText().length());
            this.dsS.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.dsS);
            mz(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mz(int i) {
        this.dsN.postDelayed(new an(this), i);
    }

    private void q(Bundle bundle) {
        PersonChangeData personChangeData;
        this.dtc = new ao(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.dsY = new av(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBm() {
        BitmapDrawable bitmapDrawable;
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.dsQ.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ab(i == 1);
        getLayoutMode().x(this.bfy);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bgU.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.dsY.aBt());
    }

    private void JE() {
        this.bgU = (HeadImageView) findViewById(t.g.photo);
        this.bgU.setIsRound(false);
        this.bgU.setAutoChangeStyle(true);
        this.bgU.setDrawBorder(false);
        this.bgU.setOnClickListener(new ap(this));
        this.bgU.c(com.baidu.tbadk.core.util.q.dm(this.dsY.aBt().getPortrait()), 25, false);
        this.bfy = (LinearLayout) findViewById(t.g.parent);
        this.dsN = (ScrollView) findViewById(t.g.person_change_scroll);
        this.dsP = (LinearLayout) findViewById(t.g.person_sex);
        this.dsQ = (TextView) findViewById(t.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dtg);
        this.mNavigationBar.setTitleText(getResources().getString(t.j.my_info));
        this.dsM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.cjl = (TextView) this.dsM.findViewById(t.g.right_textview);
        this.cjl.setText(getPageContext().getString(t.j.save));
        this.dsM.setEnabled(false);
        com.baidu.tbadk.core.util.at.b(this.cjl, t.d.navi_op_text, 1);
        this.dsM.setOnClickListener(new aq(this));
        this.dsP.setOnClickListener(new ar(this));
        this.dsR = (LinearLayout) findViewById(t.g.intro_click);
        this.dsR.setOnClickListener(new as(this));
        this.dsR.setOnTouchListener(new at(this));
        this.dsO = (TextView) findViewById(t.g.nick_name_show);
        this.dsO.setText(this.dsY.aBt().getName());
        this.bgE = (TextView) findViewById(t.g.intro);
        if (this.dsY.aBt().getIntro() != null && this.dsY.aBt().getIntro().length() > 0) {
            this.bgE.setText(this.dsY.aBt().getIntro());
        } else {
            this.bgE.setText(getPageContext().getString(t.j.add_intro));
        }
        this.dsS = (EditText) findViewById(t.g.edit);
        this.dsS.setText(this.dsY.aBt().getIntro());
        this.dsS.setOnFocusChangeListener(new au(this));
        this.dsS.setOnTouchListener(new ag(this));
        this.dsS.setOnClickListener(new ah(this));
        this.dsS.addTextChangedListener(new ai(this));
        if (this.dsY.aBt().getSex() == 1) {
            this.mSex = 1;
            this.dsQ.setText(t.j.man);
        } else if (this.dsY.aBt().getSex() == 2) {
            this.mSex = 2;
            this.dsQ.setText(t.j.woman);
        } else {
            this.dsQ.setText(t.j.change_sex);
        }
        this.dsT = (LinearLayout) findViewById(t.g.intro_text_tip);
        this.dsU = (TextView) findViewById(t.g.intro_text_tip_num);
        this.dsV = (TextView) findViewById(t.g.intro_text_tip_divider);
        this.dsW = (TextView) findViewById(t.g.intro_text_tip_limit);
        aBm();
        this.dtb = (ProgressBar) findViewById(t.g.image_progress);
        this.dtd = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.dtd.cC(getPageContext().getString(t.j.confirm_giveup));
        this.dtd.a(getPageContext().getString(t.j.alert_yes_button), new aj(this));
        this.dtd.b(getPageContext().getString(t.j.cancel), new ak(this));
        this.dtd.b(getPageContext());
    }

    public void aBn() {
        String[] strArr = {getPageContext().getString(t.j.change_photo), getPageContext().getString(t.j.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.cd(t.j.operation);
        cVar.a(strArr, new al(this));
        cVar.d(getPageContext());
        cVar.us();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBo() {
        int color;
        if (this.dsS.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = com.baidu.tbadk.core.util.at.getColor(t.d.person_change_up_limit_text);
        } else {
            color = com.baidu.tbadk.core.util.at.getColor(t.d.person_change_not_up_limit_text);
        }
        mA(color);
    }

    private void mA(int i) {
        this.dsU.setTextColor(i);
        this.dsV.setTextColor(i);
        this.dsW.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBp() {
        if (this.dsY != null && this.dsY.aBt() != null) {
            aBk();
            if (!com.baidu.adp.lib.util.i.jf()) {
                showToast(t.j.neterror);
                return;
            }
            this.dsY.aBt().setIntro(this.dsS.getText().toString().replaceAll("\\s*", ""));
            this.dsY.aBt().setSex(this.mSex);
            if (this.dta == null) {
                this.dta = new b(this.dsY);
                this.dta.setPriority(3);
                this.dta.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBq() {
        if (this.dte == null) {
            this.dte = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            String string = getPageContext().getString(t.j.man);
            String string2 = getPageContext().getString(t.j.woman);
            this.dte.cd(t.j.choose_sex);
            this.dte.a(new String[]{string, string2}, new am(this, string, string2));
            this.dte.d(getPageContext());
        }
        this.dte.us();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aBk();
            this.dtg.onClick(null);
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
                            f(intent);
                            return;
                        } else {
                            o(intent);
                            return;
                        }
                    }
                    return;
                case 12009:
                case 12010:
                    this.dsY.aBt().setPhotoChanged(true);
                    aBr();
                    return;
                case 12014:
                    this.dsY.aBt().setPhotoChanged(true);
                    if (intent != null) {
                        this.bgU.setImageBitmap(null);
                        this.bgU.c(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12010:
                    com.baidu.tbadk.core.util.as.c(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    private void o(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.dsL.parseJson(stringExtra);
            this.dsL.updateQuality();
            if (this.dsL.getChosedFiles() != null && this.dsL.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.dsL.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.dsL.clear();
        }
    }

    private void f(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void aBr() {
        if (this.dsZ != null) {
            this.dsZ.cancel();
        }
        this.cdd = null;
        this.dsZ = new a(this, null);
        this.dsZ.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBs() {
        if (this.dsY != null && this.dsY.aBt() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.dsY.aBt()));
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
            PersonChangeActivity.this.dtb.setVisibility(0);
            PersonChangeActivity.this.bgU.setImageDrawable(null);
            PersonChangeActivity.this.cdd = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.m.Y(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.dsZ = null;
            PersonChangeActivity.this.dtb.setVisibility(8);
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
            PersonChangeActivity.this.dsZ = null;
            PersonChangeActivity.this.dtb.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.cdd = new com.baidu.adp.widget.a.a(bitmap, false, null);
                PersonChangeActivity.this.cdd.a(PersonChangeActivity.this.bgU);
                com.baidu.tbadk.imageManager.c.EO().a(PersonChangeActivity.this.dsY.aBt().getPortrait(), PersonChangeActivity.this.cdd, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private com.baidu.tbadk.core.util.ab QV = null;
        private av dsY;

        public b(av avVar) {
            this.dsY = null;
            this.dsY = avVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.dta = null;
            if (this.QV != null) {
                this.QV.gX();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: er */
        public void onPostExecute(String str) {
            PersonChangeActivity.this.dta = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.QV != null) {
                if (this.QV.vU().wP().qC()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(t.j.success));
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.dsK.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.dsY.aBt());
                    } else {
                        intent.putExtra("data", this.dsY.aBt());
                    }
                    TbadkCoreApplication.m411getInst().setPersonChangeData(this.dsY.aBt());
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.aBs();
                    PersonChangeActivity.this.finish();
                } else {
                    PersonChangeActivity.this.showToast(this.QV.getErrorString());
                }
            }
            super.onPostExecute(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(t.j.saving), PersonChangeActivity.this.dtc);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public String doInBackground(String... strArr) {
            if (this.dsY != null) {
                this.QV = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_MODIFY);
                this.QV.p(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.dsY.aBt().getSex()));
                this.QV.p("intro", this.dsY.aBt().getIntro());
                this.QV.vz();
                if (this.QV.vU().wP().qC()) {
                    com.baidu.tieba.tbadkCore.util.m.aUp();
                }
            }
            return null;
        }
    }
}
