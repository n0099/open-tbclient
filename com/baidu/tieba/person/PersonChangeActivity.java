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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    private View eeA;
    private Boolean eey = false;
    private final WriteImagesInfo eez = new WriteImagesInfo(1);
    private NavigationBar mNavigationBar = null;
    private TextView cPx = null;
    private LinearLayout byv = null;
    private ScrollView eeB = null;
    private TextView eeC = null;
    private LinearLayout eeD = null;
    private TextView eeE = null;
    private LinearLayout eeF = null;
    private TextView byo = null;
    private EditText eeG = null;
    private LinearLayout eeH = null;
    private TextView eeI = null;
    private TextView eeJ = null;
    private TextView eeK = null;
    private InputMethodManager mInputManager = null;
    private boolean eeL = false;
    private ax eeM = null;
    protected HeadImageView byJ = null;
    private com.baidu.adp.widget.a.a cJe = null;
    private a eeN = null;
    private b eeO = null;
    private ProgressBar eeP = null;
    private DialogInterface.OnCancelListener eeQ = null;
    private com.baidu.tbadk.core.dialog.a eeR = null;
    private com.baidu.tbadk.core.dialog.c eeS = null;
    private boolean edn = false;
    private boolean civ = false;
    private int mSex = 0;
    private final int eeT = 50;
    private final View.OnClickListener eeU = new ah(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(u.h.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        s(bundle);
        IW();
        if (bundle != null) {
            this.eey = Boolean.valueOf(bundle.getBoolean(PersonChangeActivityConfig.IS_FROM_PERSONINFO));
        } else {
            this.eey = Boolean.valueOf(getIntent().getBooleanExtra(PersonChangeActivityConfig.IS_FROM_PERSONINFO, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eeN != null) {
            this.eeN.cancel();
        }
        if (this.eeO != null) {
            this.eeO.cancel();
        }
        if (this.eeP != null) {
            this.eeP.setVisibility(8);
        }
        if (this.eeG != null) {
            this.eeG.addTextChangedListener(null);
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.eeL = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.eeL) {
            aKB();
        }
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKB() {
        if (this.eeG.getVisibility() == 0) {
            this.eeH.setVisibility(8);
            this.eeG.setVisibility(8);
            String replaceAll = this.eeG.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.byo.setText(replaceAll);
            } else {
                this.byo.setText(getPageContext().getString(u.j.add_intro));
            }
            if (this.eeM.aKK().getIntro() == null || !this.eeM.aKK().getIntro().equals(replaceAll)) {
                this.edn = true;
            }
            this.eeM.aKK().setIntro(replaceAll);
            this.byo.setVisibility(0);
            HidenSoftKeyPad(this.mInputManager, this.eeG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKC() {
        if (this.eeG.getVisibility() != 0) {
            this.byo.setVisibility(8);
            this.eeG.setText(this.eeM.aKK().getIntro());
            this.eeG.setVisibility(0);
            this.eeG.setSelection(this.eeG.getText().length());
            this.eeG.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.eeG);
            nQ(800);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nQ(int i) {
        this.eeB.postDelayed(new ap(this), i);
    }

    private void s(Bundle bundle) {
        PersonChangeData personChangeData;
        this.eeQ = new aq(this);
        if (bundle != null) {
            personChangeData = (PersonChangeData) bundle.getSerializable("data");
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.eeM = new ax(personChangeData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKD() {
        BitmapDrawable bitmapDrawable;
        if (this.mSex == 1) {
            bitmapDrawable = (BitmapDrawable) com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_pop_boy);
        } else {
            bitmapDrawable = this.mSex == 2 ? (BitmapDrawable) com.baidu.tbadk.core.util.av.getDrawable(u.f.icon_pop_girl) : null;
        }
        if (bitmapDrawable != null) {
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            this.eeE.setCompoundDrawables(null, null, bitmapDrawable, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().ad(i == 1);
        getLayoutMode().w(this.byv);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        this.byJ.refresh();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("data", this.eeM.aKK());
    }

    private void IW() {
        this.byJ = (HeadImageView) findViewById(u.g.photo);
        this.byJ.setIsRound(false);
        this.byJ.setAutoChangeStyle(true);
        this.byJ.setDrawBorder(false);
        this.byJ.setOnClickListener(new ar(this));
        this.byJ.c(com.baidu.tbadk.core.util.q.di(this.eeM.aKK().getPortrait()), 25, false);
        this.byv = (LinearLayout) findViewById(u.g.parent);
        this.eeB = (ScrollView) findViewById(u.g.person_change_scroll);
        this.eeD = (LinearLayout) findViewById(u.g.person_sex);
        this.eeE = (TextView) findViewById(u.g.sex_show);
        this.mNavigationBar = (NavigationBar) findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.eeU);
        this.mNavigationBar.setTitleText(getResources().getString(u.j.my_info));
        this.eeA = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.cPx = (TextView) this.eeA.findViewById(u.g.right_textview);
        this.cPx.setText(getPageContext().getString(u.j.save));
        com.baidu.tbadk.core.util.av.c(this.cPx, u.d.navi_op_text, 1);
        this.eeA.setOnClickListener(new as(this));
        this.eeD.setOnClickListener(new at(this));
        this.eeF = (LinearLayout) findViewById(u.g.intro_click);
        this.eeF.setOnClickListener(new au(this));
        this.eeF.setOnTouchListener(new av(this));
        this.eeC = (TextView) findViewById(u.g.nick_name_show);
        this.eeC.setText(this.eeM.aKK().getName());
        this.byo = (TextView) findViewById(u.g.intro);
        if (this.eeM.aKK().getIntro() != null && this.eeM.aKK().getIntro().length() > 0) {
            this.byo.setText(this.eeM.aKK().getIntro());
        } else {
            this.byo.setText(getPageContext().getString(u.j.add_intro));
        }
        this.eeG = (EditText) findViewById(u.g.edit);
        this.eeG.setText(this.eeM.aKK().getIntro());
        this.eeG.setOnFocusChangeListener(new aw(this));
        this.eeG.setOnTouchListener(new ai(this));
        this.eeG.setOnClickListener(new aj(this));
        this.eeG.addTextChangedListener(new ak(this));
        if (this.eeM.aKK().getSex() == 1) {
            this.mSex = 1;
            this.eeE.setText(u.j.man);
        } else if (this.eeM.aKK().getSex() == 2) {
            this.mSex = 2;
            this.eeE.setText(u.j.woman);
        } else {
            this.eeE.setText(u.j.change_sex);
        }
        this.eeH = (LinearLayout) findViewById(u.g.intro_text_tip);
        this.eeI = (TextView) findViewById(u.g.intro_text_tip_num);
        this.eeJ = (TextView) findViewById(u.g.intro_text_tip_divider);
        this.eeK = (TextView) findViewById(u.g.intro_text_tip_limit);
        aKD();
        this.eeP = (ProgressBar) findViewById(u.g.image_progress);
        this.eeR = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        this.eeR.cz(getPageContext().getString(u.j.confirm_giveup));
        this.eeR.a(getPageContext().getString(u.j.alert_yes_button), new al(this));
        this.eeR.b(getPageContext().getString(u.j.cancel), new am(this));
        this.eeR.b(getPageContext());
    }

    public void aKE() {
        String[] strArr = {getPageContext().getString(u.j.change_photo), getPageContext().getString(u.j.change_system_photo)};
        com.baidu.tbadk.core.dialog.c cVar = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
        cVar.bP(u.j.operation);
        cVar.a(strArr, new an(this));
        cVar.d(getPageContext());
        cVar.rW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKF() {
        int color;
        if (this.eeG.getText().toString().replaceAll("\\s*", "").length() >= 50) {
            color = com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10159);
        } else {
            color = com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10077);
        }
        nR(color);
    }

    private void nR(int i) {
        this.eeI.setTextColor(i);
        this.eeJ.setTextColor(i);
        this.eeK.setTextColor(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKG() {
        if (this.eeM != null && this.eeM.aKK() != null) {
            aKB();
            if (!com.baidu.adp.lib.util.i.fr()) {
                showToast(u.j.neterror);
                return;
            }
            this.eeM.aKK().setIntro(this.eeG.getText().toString().replaceAll("\\s*", ""));
            this.eeM.aKK().setSex(this.mSex);
            if (this.eeO == null) {
                this.eeO = new b(this.eeM);
                this.eeO.setPriority(3);
                this.eeO.execute(new String[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKH() {
        if (this.eeS == null) {
            this.eeS = new com.baidu.tbadk.core.dialog.c(getPageContext().getPageActivity());
            String string = getPageContext().getString(u.j.man);
            String string2 = getPageContext().getString(u.j.woman);
            this.eeS.bP(u.j.choose_sex);
            this.eeS.a(new String[]{string, string2}, new ao(this, string, string2));
            this.eeS.d(getPageContext());
        }
        this.eeS.rW();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            aKB();
            this.eeU.onClick(null);
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
                            r(intent);
                            return;
                        }
                    }
                    return;
                case 12009:
                case 12010:
                    this.eeM.aKK().setPhotoChanged(true);
                    aKI();
                    this.civ = true;
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
                        com.baidu.tbadk.core.util.av.c(this.cPx, u.d.navi_op_text, 1);
                        return;
                    } else {
                        com.baidu.tbadk.core.util.av.c(this.cPx, u.d.cp_link_tip_a, 1);
                        return;
                    }
                case 12014:
                    this.eeM.aKK().setPhotoChanged(true);
                    if (intent != null) {
                        this.byJ.setImageBitmap(null);
                        this.byJ.c(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                    }
                    this.civ = true;
                    if (TbadkCoreApplication.m9getInst().getSkinType() == 2) {
                        com.baidu.tbadk.core.util.av.c(this.cPx, u.d.navi_op_text, 1);
                        return;
                    } else {
                        com.baidu.tbadk.core.util.av.c(this.cPx, u.d.cp_link_tip_a, 1);
                        return;
                    }
                default:
                    return;
            }
        } else if (i2 == 0) {
            switch (i) {
                case 12010:
                    com.baidu.tbadk.core.util.au.c(getPageContext());
                    return;
                default:
                    return;
            }
        }
    }

    private void r(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.eez.parseJson(stringExtra);
            this.eez.updateQuality();
            if (this.eez.getChosedFiles() != null && this.eez.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.eez.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.eez.clear();
        }
    }

    private void f(Intent intent) {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void aKI() {
        if (this.eeN != null) {
            this.eeN.cancel();
        }
        this.cJe = null;
        this.eeN = new a(this, null);
        this.eeN.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKJ() {
        if (this.eeM != null && this.eeM.aKK() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_DATA_CHANGED, this.eeM.aKK()));
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
            PersonChangeActivity.this.eeP.setVisibility(0);
            PersonChangeActivity.this.byJ.setImageDrawable(null);
            PersonChangeActivity.this.cJe = null;
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: h */
        public Bitmap doInBackground(Object... objArr) {
            return com.baidu.tbadk.core.util.m.X(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.eeN = null;
            PersonChangeActivity.this.eeP.setVisibility(8);
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
            PersonChangeActivity.this.eeN = null;
            PersonChangeActivity.this.eeP.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.cJe = new com.baidu.adp.widget.a.a(bitmap, false, null);
                PersonChangeActivity.this.cJe.a(PersonChangeActivity.this.byJ);
                com.baidu.tbadk.imageManager.c.CQ().a(PersonChangeActivity.this.eeM.aKK().getPortrait(), PersonChangeActivity.this.cJe, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b extends BdAsyncTask<String, Integer, String> {
        private com.baidu.tbadk.core.util.ab LK = null;
        private ax eeM;

        public b(ax axVar) {
            this.eeM = null;
            this.eeM = axVar;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.eeO = null;
            if (this.LK != null) {
                this.LK.dm();
            }
            super.cancel(true);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: es */
        public void onPostExecute(String str) {
            PersonChangeActivity.this.eeO = null;
            PersonChangeActivity.this.closeLoadingDialog();
            if (this.LK != null) {
                if (this.LK.ty().uv().nU()) {
                    PersonChangeActivity.this.showToast(PersonChangeActivity.this.getPageContext().getString(u.j.success));
                    Intent intent = new Intent();
                    if (PersonChangeActivity.this.eey.booleanValue()) {
                        intent.putExtra(PersonChangeData.TAG_PERSON_INFO, this.eeM.aKK());
                    } else {
                        intent.putExtra("data", this.eeM.aKK());
                    }
                    TbadkCoreApplication.m9getInst().setPersonChangeData(this.eeM.aKK());
                    PersonChangeActivity.this.setResult(-1, intent);
                    PersonChangeActivity.this.aKJ();
                    PersonChangeActivity.this.finish();
                } else {
                    PersonChangeActivity.this.showToast(this.LK.getErrorString());
                }
            }
            super.onPostExecute(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.showLoadingDialog(PersonChangeActivity.this.getPageContext().getString(u.j.saving), PersonChangeActivity.this.eeQ);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: i */
        public String doInBackground(String... strArr) {
            if (this.eeM != null) {
                this.LK = new com.baidu.tbadk.core.util.ab(String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.PROFILE_MODIFY);
                this.LK.n(MyGiftListActivityConfig.USER_SEX, String.valueOf(this.eeM.aKK().getSex()));
                this.LK.n("intro", this.eeM.aKK().getIntro());
                this.LK.td();
                if (this.LK.ty().uv().nU()) {
                    com.baidu.tieba.tbadkCore.util.m.bde();
                }
            }
            return null;
        }
    }
}
