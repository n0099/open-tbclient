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
    private View cYk;
    private Boolean cYi = false;
    private final WriteImagesInfo cYj = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView bYI = null;
    private LinearLayout baO = null;
    private ScrollView cYl = null;
    private TextView cYm = null;
    private LinearLayout cYn = null;
    private TextView cYo = null;
    private LinearLayout cYp = null;
    private TextView bbT = null;
    private EditText cYq = null;
    private LinearLayout cYr = null;
    private TextView cYs = null;
    private TextView cYt = null;
    private TextView cYu = null;
    private InputMethodManager mInputManager = null;
    private boolean cYv = false;
    private av cYw = null;
    protected HeadImageView bcj = null;
    private com.baidu.adp.widget.a.a bSA = null;
    private a cYx = null;
    private b cYy = null;
    private ProgressBar cYz = null;
    private DialogInterface.OnCancelListener cYA = null;
    private com.baidu.tbadk.core.dialog.a cYB = null;
    private com.baidu.tbadk.core.dialog.c cYC = null;
    private boolean cWY = false;
    private int mSex = 0;
    private final int cYD = 50;
    private final View.OnClickListener cYE = new af(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        o(bundle);
        Ii();
        if (bundle != null) {
            this.cYi = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.cYi = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.cYx != null) {
            this.cYx.cancel();
        }
        if (this.cYy != null) {
            this.cYy.cancel();
        }
        if (this.cYz != null) {
            this.cYz.setVisibility(8);
        }
        if (this.cYq != null) {
            this.cYq.addTextChangedListener(null);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.cYv = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.cYv) {
            atE();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atE() {
        if (this.cYq.getVisibility() == 0) {
            this.cYr.setVisibility(8);
            this.cYq.setVisibility(8);
            String replaceAll = this.cYq.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.bbT.setText(replaceAll);
            } else {
                this.bbT.setText(getPageContext().getString(t.j.add_intro));
            }
            if (this.cYw.atN().getIntro() == null || !this.cYw.atN().getIntro().equals(replaceAll)) {
                this.cWY = true;
            }
            this.cYw.atN().setIntro(replaceAll);
            this.bbT.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.cYq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atF() {
        if (this.cYq.getVisibility() != 0) {
            this.bbT.setVisibility(8);
            this.cYq.setText(this.cYw.atN().getIntro());
            this.cYq.setVisibility(0);
            this.cYq.setSelection(this.cYq.getText().length());
            this.cYq.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.cYq);
            lq(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lq(int i) {
        this.cYl.postDelayed(new an(this), i);
    }

    private void o(Bundle bundle) {
        PersonChangeData personChangeData;
        this.cYA = new ao(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.cYw = new av(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atG() {
        BitmapDrawable bitmapDrawable;
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.ar.getDrawable(t.f.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.cYo.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ac(i == 1);
        getLayoutMode().x(this.baO);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bcj.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.cYw.atN());
    }

    private void Ii() {
        this.bcj = (HeadImageView) findViewById(t.g.photo);
        this.bcj.setIsRound(false);
        this.bcj.setAutoChangeStyle(true);
        this.bcj.setDrawBorder(false);
        this.bcj.setOnClickListener(new ap(this));
        this.bcj.d(com.baidu.tbadk.core.util.q.dj(this.cYw.atN().getPortrait()), 25, false);
        this.baO = (LinearLayout) findViewById(t.g.parent);
        this.cYl = (ScrollView) findViewById(t.g.person_change_scroll);
        this.cYn = (LinearLayout) findViewById(t.g.person_sex);
        this.cYo = (TextView) findViewById(t.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cYE);
        this.mNavigationBar.setTitleText(getResources().getString(t.j.my_info));
        this.cYk = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.bYI = (TextView) this.cYk.findViewById(t.g.right_textview);
        this.bYI.setText(getPageContext().getString(t.j.save));
        this.cYk.setEnabled(false);
        com.baidu.tbadk.core.util.ar.b(this.bYI, t.d.navi_op_text, 1);
        this.cYk.setOnClickListener(new aq(this));
        this.cYn.setOnClickListener(new ar(this));
        this.cYp = (LinearLayout) findViewById(t.g.intro_click);
        this.cYp.setOnClickListener(new as(this));
        this.cYp.setOnTouchListener(new at(this));
        this.cYm = (TextView) findViewById(t.g.nick_name_show);
        this.cYm.setText(this.cYw.atN().getName());
        this.bbT = (TextView) findViewById(t.g.intro);
        if (this.cYw.atN().getIntro() != null && this.cYw.atN().getIntro().length() > 0) {
            this.bbT.setText(this.cYw.atN().getIntro());
        } else {
            this.bbT.setText(getPageContext().getString(t.j.add_intro));
        }
        this.cYq = (EditText) findViewById(t.g.edit);
        this.cYq.setText(this.cYw.atN().getIntro());
        this.cYq.setOnFocusChangeListener(new au(this));
        this.cYq.setOnTouchListener(new ag(this));
        this.cYq.setOnClickListener(new ah(this));
        this.cYq.addTextChangedListener(new ai(this));
        if (this.cYw.atN().getSex() == 1) {
            this.mSex = 1;
            this.cYo.setText(t.j.man);
        } else if (this.cYw.atN().getSex() == 2) {
            this.mSex = 2;
            this.cYo.setText(t.j.woman);
        } else {
            this.cYo.setText(t.j.change_sex);
        }
        this.cYr = (LinearLayout) findViewById(t.g.intro_text_tip);
        this.cYs = (TextView) findViewById(t.g.intro_text_tip_num);
        this.cYt = (TextView) findViewById(t.g.intro_text_tip_divider);
        this.cYu = (TextView) findViewById(t.g.intro_text_tip_limit);
        atG();
        this.cYz = (ProgressBar) findViewById(t.g.image_progress);
        this.cYB = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.cYB.cE(getPageContext().getString(t.j.confirm_giveup));
        this.cYB.a(getPageContext().getString(t.j.alert_yes_button), new aj(this));
        this.cYB.b(getPageContext().getString(t.j.cancel), new ak(this));
        this.cYB.b(getPageContext());
    }

    public void atH() {
        String[] strArr = {getPageContext().getString(t.j.change_photo), getPageContext().getString(t.j.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.cb(t.j.operation);
        cVar.a(strArr, new al(this));
        cVar.d(getPageContext());
        cVar.un();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atI() {
        int color;
        if (this.cYq.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = com.baidu.tbadk.core.util.ar.getColor(t.d.person_change_up_limit_text);
        } else {
            color = com.baidu.tbadk.core.util.ar.getColor(t.d.person_change_not_up_limit_text);
        }
        lr(color);
    }

    private void lr(int i) {
        this.cYs.setTextColor(i);
        this.cYt.setTextColor(i);
        this.cYu.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atJ() {
        if (this.cYw != null && this.cYw.atN() != null) {
            atE();
            if (!com.baidu.adp.lib.util.i.iZ()) {
                showToast(t.j.neterror);
                return;
            }
            this.cYw.atN().setIntro(this.cYq.getText().toString().replaceAll("\\s*", ""));
            this.cYw.atN().setSex(this.mSex);
            if (this.cYy == null) {
                this.cYy = new b(this.cYw);
                this.cYy.setPriority(3);
                this.cYy.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atK() {
        if (this.cYC == null) {
            this.cYC = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            String string = getPageContext().getString(t.j.man);
            String string2 = getPageContext().getString(t.j.woman);
            this.cYC.cb(t.j.choose_sex);
            this.cYC.a(new String[]{string, string2}, new am(this, string, string2));
            this.cYC.d(getPageContext());
        }
        this.cYC.un();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            atE();
            this.cYE.onClick(null);
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
                            R(intent);
                            return;
                        }
                    }
                    return;
                case 12009:
                case 12010:
                    this.cYw.atN().setPhotoChanged(true);
                    atL();
                    return;
                case 12014:
                    this.cYw.atN().setPhotoChanged(true);
                    if (intent != null) {
                        this.bcj.setImageBitmap(null);
                        this.bcj.d(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12010:
                    com.baidu.tbadk.core.util.aq.c(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    private void R(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.cYj.parseJson(stringExtra);
            this.cYj.updateQuality();
            if (this.cYj.getChosedFiles() != null && this.cYj.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.cYj.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.cYj.clear();
        }
    }

    private void J(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void atL() {
        if (this.cYx != null) {
            this.cYx.cancel();
        }
        this.bSA = null;
        this.cYx = new a(this, null);
        this.cYx.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atM() {
        if (this.cYw != null && this.cYw.atN() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.cYw.atN()));
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
            PersonChangeActivity.this.cYz.setVisibility(0);
            PersonChangeActivity.this.bcj.setImageDrawable(null);
            PersonChangeActivity.this.bSA = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: g */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.m.W(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.cYx = null;
            PersonChangeActivity.this.cYz.setVisibility(8);
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
            PersonChangeActivity.this.cYx = null;
            PersonChangeActivity.this.cYz.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.bSA = new com.baidu.adp.widget.a.a(bitmap, false, null);
                PersonChangeActivity.this.bSA.a(PersonChangeActivity.this.bcj);
                com.baidu.tbadk.imageManager.c.Ed().a(PersonChangeActivity.this.cYw.atN().getPortrait(), PersonChangeActivity.this.bSA, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private com.baidu.tbadk.core.util.aa Ty = null;
        private av cYw;

        public b(av avVar) {
            this.cYw = null;
            this.cYw = avVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.cYy = null;
            if (this.Ty != null) {
                this.Ty.gT();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: ek */
        public void onPostExecute(String str) {
            PersonChangeActivity.this.cYy = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.Ty != null) {
                if (this.Ty.vB().ww().rl()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(t.j.success));
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.cYi.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.cYw.atN());
                    } else {
                        intent.putExtra("data", this.cYw.atN());
                    }
                    TbadkCoreApplication.m411getInst().setPersonChangeData(this.cYw.atN());
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.atM();
                    PersonChangeActivity.this.finish();
                } else {
                    PersonChangeActivity.this.showToast(this.Ty.getErrorString());
                }
            }
            super.onPostExecute(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(t.j.saving), PersonChangeActivity.this.cYA);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public String doInBackground(String... strArr) {
            if (this.cYw != null) {
                this.Ty = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_MODIFY);
                this.Ty.p(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.cYw.atN().getSex()));
                this.Ty.p("intro", this.cYw.atN().getIntro());
                this.Ty.vc();
                if (this.Ty.vB().ww().rl()) {
                    com.baidu.tieba.tbadkCore.util.m.aNo();
                }
            }
            return null;
        }
    }
}
