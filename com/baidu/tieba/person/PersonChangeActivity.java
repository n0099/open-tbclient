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
    private View dwi;
    private Boolean dwg = false;
    private final WriteImagesInfo dwh = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView ckh = null;
    private LinearLayout bcA = null;
    private ScrollView dwj = null;
    private TextView dwk = null;
    private LinearLayout dwl = null;
    private TextView dwm = null;
    private LinearLayout dwn = null;
    private TextView bct = null;
    private EditText dwo = null;
    private LinearLayout dwp = null;
    private TextView dwq = null;
    private TextView dwr = null;
    private TextView dws = null;
    private InputMethodManager mInputManager = null;
    private boolean dwt = false;
    private aw dwu = null;
    protected HeadImageView bcK = null;
    private com.baidu.adp.widget.a.a cdI = null;
    private a dwv = null;
    private b dww = null;
    private ProgressBar dwx = null;
    private DialogInterface.OnCancelListener dwy = null;
    private com.baidu.tbadk.core.dialog.a dwz = null;
    private com.baidu.tbadk.core.dialog.c dwA = null;
    private boolean duV = false;
    private boolean bKq = false;
    private int mSex = 0;
    private final int dwB = 50;
    private final View.OnClickListener dwC = new ag(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.h.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        r(bundle);
        HX();
        if (bundle != null) {
            this.dwg = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.dwg = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.dwv != null) {
            this.dwv.cancel();
        }
        if (this.dww != null) {
            this.dww.cancel();
        }
        if (this.dwx != null) {
            this.dwx.setVisibility(8);
        }
        if (this.dwo != null) {
            this.dwo.addTextChangedListener(null);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.dwt = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.dwt) {
            aBJ();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBJ() {
        if (this.dwo.getVisibility() == 0) {
            this.dwp.setVisibility(8);
            this.dwo.setVisibility(8);
            String replaceAll = this.dwo.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.bct.setText(replaceAll);
            } else {
                this.bct.setText(getPageContext().getString(t.j.add_intro));
            }
            if (this.dwu.aBS().getIntro() == null || !this.dwu.aBS().getIntro().equals(replaceAll)) {
                this.duV = true;
            }
            this.dwu.aBS().setIntro(replaceAll);
            this.bct.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.dwo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBK() {
        if (this.dwo.getVisibility() != 0) {
            this.bct.setVisibility(8);
            this.dwo.setText(this.dwu.aBS().getIntro());
            this.dwo.setVisibility(0);
            this.dwo.setSelection(this.dwo.getText().length());
            this.dwo.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.dwo);
            mp(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mp(int i) {
        this.dwj.postDelayed(new ao(this), i);
    }

    private void r(Bundle bundle) {
        PersonChangeData personChangeData;
        this.dwy = new ap(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.dwu = new aw(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBL() {
        BitmapDrawable bitmapDrawable;
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.at.getDrawable(t.f.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.dwm.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ae(i == 1);
        getLayoutMode().x(this.bcA);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.bcK.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.dwu.aBS());
    }

    private void HX() {
        this.bcK = (HeadImageView) findViewById(t.g.photo);
        this.bcK.setIsRound(false);
        this.bcK.setAutoChangeStyle(true);
        this.bcK.setDrawBorder(false);
        this.bcK.setOnClickListener(new aq(this));
        this.bcK.c(com.baidu.tbadk.core.util.q.dk(this.dwu.aBS().getPortrait()), 25, false);
        this.bcA = (LinearLayout) findViewById(t.g.parent);
        this.dwj = (ScrollView) findViewById(t.g.person_change_scroll);
        this.dwl = (LinearLayout) findViewById(t.g.person_sex);
        this.dwm = (TextView) findViewById(t.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dwC);
        this.mNavigationBar.setTitleText(getResources().getString(t.j.my_info));
        this.dwi = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.ckh = (TextView) this.dwi.findViewById(t.g.right_textview);
        this.ckh.setText(getPageContext().getString(t.j.save));
        com.baidu.tbadk.core.util.at.c(this.ckh, t.d.navi_op_text, 1);
        this.dwi.setOnClickListener(new ar(this));
        this.dwl.setOnClickListener(new as(this));
        this.dwn = (LinearLayout) findViewById(t.g.intro_click);
        this.dwn.setOnClickListener(new at(this));
        this.dwn.setOnTouchListener(new au(this));
        this.dwk = (TextView) findViewById(t.g.nick_name_show);
        this.dwk.setText(this.dwu.aBS().getName());
        this.bct = (TextView) findViewById(t.g.intro);
        if (this.dwu.aBS().getIntro() != null && this.dwu.aBS().getIntro().length() > 0) {
            this.bct.setText(this.dwu.aBS().getIntro());
        } else {
            this.bct.setText(getPageContext().getString(t.j.add_intro));
        }
        this.dwo = (EditText) findViewById(t.g.edit);
        this.dwo.setText(this.dwu.aBS().getIntro());
        this.dwo.setOnFocusChangeListener(new av(this));
        this.dwo.setOnTouchListener(new ah(this));
        this.dwo.setOnClickListener(new ai(this));
        this.dwo.addTextChangedListener(new aj(this));
        if (this.dwu.aBS().getSex() == 1) {
            this.mSex = 1;
            this.dwm.setText(t.j.man);
        } else if (this.dwu.aBS().getSex() == 2) {
            this.mSex = 2;
            this.dwm.setText(t.j.woman);
        } else {
            this.dwm.setText(t.j.change_sex);
        }
        this.dwp = (LinearLayout) findViewById(t.g.intro_text_tip);
        this.dwq = (TextView) findViewById(t.g.intro_text_tip_num);
        this.dwr = (TextView) findViewById(t.g.intro_text_tip_divider);
        this.dws = (TextView) findViewById(t.g.intro_text_tip_limit);
        aBL();
        this.dwx = (ProgressBar) findViewById(t.g.image_progress);
        this.dwz = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.dwz.cA(getPageContext().getString(t.j.confirm_giveup));
        this.dwz.a(getPageContext().getString(t.j.alert_yes_button), new ak(this));
        this.dwz.b(getPageContext().getString(t.j.cancel), new al(this));
        this.dwz.b(getPageContext());
    }

    public void aBM() {
        String[] strArr = {getPageContext().getString(t.j.change_photo), getPageContext().getString(t.j.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bO(t.j.operation);
        cVar.a(strArr, new am(this));
        cVar.d(getPageContext());
        cVar.rY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBN() {
        int color;
        if (this.dwo.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = com.baidu.tbadk.core.util.at.getColor(t.d.person_change_up_limit_text);
        } else {
            color = com.baidu.tbadk.core.util.at.getColor(t.d.person_change_not_up_limit_text);
        }
        mq(color);
    }

    private void mq(int i) {
        this.dwq.setTextColor(i);
        this.dwr.setTextColor(i);
        this.dws.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBO() {
        if (this.dwu != null && this.dwu.aBS() != null) {
            aBJ();
            if (!com.baidu.adp.lib.util.i.fq()) {
                showToast(t.j.neterror);
                return;
            }
            this.dwu.aBS().setIntro(this.dwo.getText().toString().replaceAll("\\s*", ""));
            this.dwu.aBS().setSex(this.mSex);
            if (this.dww == null) {
                this.dww = new b(this.dwu);
                this.dww.setPriority(3);
                this.dww.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBP() {
        if (this.dwA == null) {
            this.dwA = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            String string = getPageContext().getString(t.j.man);
            String string2 = getPageContext().getString(t.j.woman);
            this.dwA.bO(t.j.choose_sex);
            this.dwA.a(new String[]{string, string2}, new an(this, string, string2));
            this.dwA.d(getPageContext());
        }
        this.dwA.rY();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aBJ();
            this.dwC.onClick(null);
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
                            p(intent);
                            return;
                        }
                    }
                    return;
                case 12009:
                case 12010:
                    this.dwu.aBS().setPhotoChanged(true);
                    aBQ();
                    this.bKq = true;
                    if (TbadkCoreApplication.m11getInst().getSkinType() == 2) {
                        com.baidu.tbadk.core.util.at.c(this.ckh, t.d.navi_op_text, 1);
                        return;
                    } else {
                        com.baidu.tbadk.core.util.at.c(this.ckh, t.d.cp_link_tip_a, 1);
                        return;
                    }
                case 12014:
                    this.dwu.aBS().setPhotoChanged(true);
                    if (intent != null) {
                        this.bcK.setImageBitmap(null);
                        this.bcK.c(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.bKq = true;
                    if (TbadkCoreApplication.m11getInst().getSkinType() == 2) {
                        com.baidu.tbadk.core.util.at.c(this.ckh, t.d.navi_op_text, 1);
                        return;
                    } else {
                        com.baidu.tbadk.core.util.at.c(this.ckh, t.d.cp_link_tip_a, 1);
                        return;
                    }
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

    private void p(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.dwh.parseJson(stringExtra);
            this.dwh.updateQuality();
            if (this.dwh.getChosedFiles() != null && this.dwh.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.dwh.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.dwh.clear();
        }
    }

    private void f(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void aBQ() {
        if (this.dwv != null) {
            this.dwv.cancel();
        }
        this.cdI = null;
        this.dwv = new a(this, null);
        this.dwv.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBR() {
        if (this.dwu != null && this.dwu.aBS() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.dwu.aBS()));
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
            PersonChangeActivity.this.dwx.setVisibility(0);
            PersonChangeActivity.this.bcK.setImageDrawable(null);
            PersonChangeActivity.this.cdI = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.m.Y(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.dwv = null;
            PersonChangeActivity.this.dwx.setVisibility(8);
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
            PersonChangeActivity.this.dwv = null;
            PersonChangeActivity.this.dwx.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.cdI = new com.baidu.adp.widget.a.a(bitmap, false, null);
                PersonChangeActivity.this.cdI.a(PersonChangeActivity.this.bcK);
                com.baidu.tbadk.imageManager.c.CI().a(PersonChangeActivity.this.dwu.aBS().getPortrait(), PersonChangeActivity.this.cdI, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private com.baidu.tbadk.core.util.ab LL = null;
        private aw dwu;

        public b(aw awVar) {
            this.dwu = null;
            this.dwu = awVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.dww = null;
            if (this.LL != null) {
                this.LL.dl();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: eo */
        public void onPostExecute(String str) {
            PersonChangeActivity.this.dww = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.LL != null) {
                if (this.LL.tB().uw().nZ()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(t.j.success));
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.dwg.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.dwu.aBS());
                    } else {
                        intent.putExtra("data", this.dwu.aBS());
                    }
                    TbadkCoreApplication.m11getInst().setPersonChangeData(this.dwu.aBS());
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.aBR();
                    PersonChangeActivity.this.finish();
                } else {
                    PersonChangeActivity.this.showToast(this.LL.getErrorString());
                }
            }
            super.onPostExecute(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(t.j.saving), PersonChangeActivity.this.dwy);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (this.dwu != null) {
                this.LL = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_MODIFY);
                this.LL.n(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.dwu.aBS().getSex()));
                this.LL.n("intro", this.dwu.aBS().getIntro());
                this.LL.tg();
                if (this.LL.tB().uw().nZ()) {
                    com.baidu.tieba.tbadkCore.util.m.aUQ();
                }
            }
            return null;
        }
    }
}
