package com.baidu.tieba.personExtra;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ChangeSystemPhotoActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.atomData.EditNickNameActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.kwai.video.player.PlayerPostEvent;
import d.b.h0.r.s.a;
import d.b.h0.r.s.b;
import d.b.h0.r.s.l;
import d.b.h0.s.i.b;
import java.util.Calendar;
import java.util.Date;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    public static final int DEFAULT_DAYS_THRESHOLD = 2000;
    public static final int FIRST_SCROLL_TO_BOTTOM_DELAY = 800;
    public static final String IS_FROM_PERSONINFO = "isFromPersonInfo";
    public static final String TAG_DATA = "data";
    public static final String TAG_PERSON_INFO = "person_change_data";
    public View editLayout;
    public TextView mAgeView;
    public LinearLayout mAlaIdLayout;
    public TextView mAlaIdView;
    public ImageView mBackIcon;
    public View mCloseView;
    public RelativeLayout mConstellationLayout;
    public TextView mConstellationView;
    public TextView mForumAgeView;
    public d.b.h0.s.i.b mInputUserNameDialog;
    public View mNameContainer;
    public d.b.h0.r.s.a mNickNameActivityDialog;
    public View mNickNameMore;
    public PermissionJudgePolicy mPermissionJudgement;
    public View mPersonNicknameLayout;
    public ImageView mPhotoCameraView;
    public String mTempNickName;
    public View mUserNameMoreIcon;
    public TextView mUserNameShow;
    public final int DEFAULT_NICKNAME_LEFT_DAYS = 90;
    public Boolean isFromPersonInfo = Boolean.FALSE;
    public final WriteImagesInfo mWriteImagesInfo = new WriteImagesInfo(1);
    public NavigationBar mNavigationBar = null;
    public TextView mSave = null;
    public LinearLayout mParent = null;
    public ScrollView mPersonChangeScroll = null;
    public TextView mNickNameShow = null;
    public RelativeLayout mSexLayout = null;
    public TextView mSexShow = null;
    public LinearLayout mIntroClick = null;
    public TextView mIntro = null;
    public EditText mEdit = null;
    public LinearLayout mIntroTextTip = null;
    public TextView mIntroTextTipNum = null;
    public TextView mIntroTextTipDivider = null;
    public TextView mIntroTextTipLimit = null;
    public InputMethodManager mInputManager = null;
    public boolean mClickOnEditor = false;
    public PersonChangeModel mModel = null;
    public HeadImageView mPhotoView = null;
    public d.b.c.j.d.a mPhoto = null;
    public t mImageTask = null;
    public u mModifyTask = null;
    public ProgressBar mImageProgressBar = null;
    public DialogInterface.OnCancelListener mDialogCancelListener = null;
    public d.b.h0.r.s.a mConfirmDialog = null;
    public d.b.h0.r.s.j mSexDialog = null;
    public boolean isEdited = false;
    public boolean isUpdate = false;
    public boolean isUpdateNickName = false;
    public int mSex = 0;
    public final int EDIT_MAX_LENGTH = 500;
    public boolean hasUserName = false;
    public boolean mHasModifyNickName = false;
    public final View.OnClickListener mBackClickListener = new h();
    public CustomMessageListener mModifyNicknameSucceedListener = new i(2921033);
    public CustomMessageListener mChangeLeftDayListener = new j(2921061);

    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                PersonChangeActivity.this.mClickOnEditor = true;
                PersonChangeActivity.this.mEdit.setCursorVisible(true);
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().replaceAll("\\s*", "").equals(PersonChangeActivity.this.mModel.s().getIntro())) {
                return;
            }
            PersonChangeActivity.this.isUpdate = true;
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                SkinManager.setViewTextColor(PersonChangeActivity.this.mSave, R.color.navi_op_text, 1);
            } else {
                SkinManager.setViewTextColor(PersonChangeActivity.this.mSave, R.color.CAM_X0302, 1);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Editable text = PersonChangeActivity.this.mEdit.getText();
            String replaceAll = text.toString().replaceAll("\\s*", "");
            int length = replaceAll.length();
            PersonChangeActivity.this.mIntroTextTipNum.setText(String.valueOf(length));
            PersonChangeActivity.this.mIntroTextTip.setVisibility(0);
            PersonChangeActivity.this.scrollToBottom(0);
            PersonChangeActivity.this.showIntroTextTip();
            if (length > 500) {
                PersonChangeActivity.this.showToast(R.string.over_limit_tip);
                if (PersonChangeActivity.this.mEdit.getSelectionStart() - 1 < 0 || PersonChangeActivity.this.mEdit.getSelectionStart() - 1 > PersonChangeActivity.this.mEdit.getSelectionEnd()) {
                    PersonChangeActivity.this.mEdit.setText(replaceAll.substring(0, 500));
                } else {
                    text.delete(PersonChangeActivity.this.mEdit.getSelectionStart() - 1, PersonChangeActivity.this.mEdit.getSelectionEnd());
                    PersonChangeActivity.this.mEdit.setText(charSequence);
                }
                int selectionEnd = Selection.getSelectionEnd(text);
                int length2 = text.length();
                if (selectionEnd > length2) {
                    selectionEnd = length2;
                }
                Selection.setSelection(PersonChangeActivity.this.mEdit.getText(), selectionEnd);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            PersonChangeActivity.this.saveProfile();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.e {
        public d() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
            if (PersonChangeActivity.this.mModel.s().getPhotoChanged()) {
                Intent intent = new Intent();
                if (!PersonChangeActivity.this.isFromPersonInfo.booleanValue()) {
                    intent.putExtra("data", PersonChangeActivity.this.mModel.s());
                } else {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.mModel.s());
                }
                PersonChangeActivity.this.setResult(-1, intent);
                PersonChangeActivity.this.sendUpdateMessage();
            }
            PersonChangeActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PersonChangeActivity.this.mPersonChangeScroll.scrollTo(0, 0);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements b.c {
        public f() {
        }

        @Override // d.b.h0.r.s.b.c
        public void a(d.b.h0.r.s.b bVar, int i, View view) {
            if (i == 0) {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) PersonChangeActivity.this.getPageContext().getPageActivity(), PersonChangeActivity.this.mWriteImagesInfo.toJsonString(), true);
                albumActivityConfig.setRequestCode(PlayerPostEvent.MEDIA_REP_CHANGE_END);
                albumActivityConfig.setResourceType(2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            } else if (i == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), 12014)));
            }
            bVar.e();
        }
    }

    /* loaded from: classes3.dex */
    public class g implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f20027e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f20028f;

        public g(String str, String str2) {
            this.f20027e = str;
            this.f20028f = str2;
        }

        @Override // d.b.h0.r.s.l.e
        public void onItemClick(d.b.h0.r.s.l lVar, int i, View view) {
            if (PersonChangeActivity.this.mSexDialog != null && PersonChangeActivity.this.mSexDialog.isShowing()) {
                PersonChangeActivity.this.mSexDialog.dismiss();
            }
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                if (this.f20027e.equals(textView.getText().toString())) {
                    PersonChangeActivity.this.mSex = 1;
                    PersonChangeActivity.this.mSexShow.setText(this.f20027e);
                } else if (this.f20028f.equals(textView.getText().toString())) {
                    PersonChangeActivity.this.mSex = 2;
                    PersonChangeActivity.this.mSexShow.setText(this.f20028f);
                }
                if (PersonChangeActivity.this.mSex != PersonChangeActivity.this.mModel.s().getSex()) {
                    PersonChangeActivity.this.isUpdate = true;
                    if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                        SkinManager.setViewTextColor(PersonChangeActivity.this.mSave, R.color.navi_op_text, 1);
                    } else {
                        SkinManager.setViewTextColor(PersonChangeActivity.this.mSave, R.color.CAM_X0302, 1);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements View.OnClickListener {
        public h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonChangeActivity.this.mModel.s().getSex() != PersonChangeActivity.this.mSex) {
                PersonChangeActivity.this.isEdited = true;
            }
            if (PersonChangeActivity.this.isEdited) {
                PersonChangeActivity.this.mConfirmDialog.show();
                return;
            }
            if (PersonChangeActivity.this.mModel != null && PersonChangeActivity.this.mModel.s().getPhotoChanged()) {
                Intent intent = new Intent();
                if (PersonChangeActivity.this.isFromPersonInfo.booleanValue()) {
                    intent.putExtra("person_change_data", PersonChangeActivity.this.mModel.s());
                } else {
                    intent.putExtra("data", PersonChangeActivity.this.mModel.s());
                }
                PersonChangeActivity.this.sendUpdateMessage();
                PersonChangeActivity.this.setResult(-1, intent);
            }
            PersonChangeActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class i extends CustomMessageListener {
        public i(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                String str = (String) data;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                PersonChangeActivity.this.mHasModifyNickName = true;
                PersonChangeActivity.this.mTempNickName = str;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j extends CustomMessageListener {
        public j(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PersonChangeData)) {
                return;
            }
            PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
            if (PersonChangeActivity.this.mModel == null || PersonChangeActivity.this.mModel.s() == null || personChangeData == null) {
                return;
            }
            PersonChangeActivity.this.mModel.s().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
            PersonChangeActivity.this.mModel.s().setMem(personChangeData.getMen());
        }
    }

    /* loaded from: classes3.dex */
    public class k implements a.e {
        public k() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (d.b.c.e.p.j.z()) {
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), 24);
                memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_MY_DATA, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                PersonChangeActivity.this.sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                TiebaStatic.log(TbadkCoreStatisticKey.MODIFY_NICK_ENTER_OPNEN_MEM_CLICK);
            } else {
                PersonChangeActivity.this.showToast(R.string.neterror);
            }
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class l implements a.e {
        public l() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class m implements a.e {
        public m() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(PersonChangeActivity.this.getPageContext().getPageActivity(), null, d.b.i0.d2.c.a(), true)));
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class n implements a.e {
        public n() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public class o implements b.e {
        public o() {
        }

        @Override // d.b.h0.s.i.b.e
        public void a(AccountData accountData) {
            if (accountData == null) {
                return;
            }
            PersonChangeActivity.this.resetUserName(accountData.getAccount());
        }
    }

    /* loaded from: classes3.dex */
    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PersonChangeActivity.this.mPersonChangeScroll.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
        }
    }

    /* loaded from: classes3.dex */
    public class q implements DialogInterface.OnCancelListener {
        public q() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            PersonChangeActivity.this.destroyWaitingDialog();
            if (PersonChangeActivity.this.mModifyTask != null) {
                PersonChangeActivity.this.mModifyTask.cancel();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class r implements View.OnTouchListener {
        public r() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                PersonChangeActivity.this.mClickOnEditor = true;
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class s implements View.OnFocusChangeListener {
        public s() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z) {
                return;
            }
            PersonChangeActivity.this.hideEditor();
        }
    }

    /* loaded from: classes3.dex */
    public class t extends BdAsyncTask<Object, Integer, Bitmap> {
        public t() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Object... objArr) {
            return FileHelper.getImage(null, TbConfig.PERSON_HEAD_FILE);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.mImageTask = null;
            PersonChangeActivity.this.mImageProgressBar.setVisibility(8);
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity.this.mImageProgressBar.setVisibility(0);
            PersonChangeActivity.this.mPhotoView.setImageDrawable(null);
            PersonChangeActivity.this.mPhoto = null;
            super.onPreExecute();
        }

        public /* synthetic */ t(PersonChangeActivity personChangeActivity, k kVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((t) bitmap);
            PersonChangeActivity.this.mImageTask = null;
            PersonChangeActivity.this.mImageProgressBar.setVisibility(8);
            if (bitmap != null) {
                PersonChangeActivity.this.mPhoto = new d.b.c.j.d.a(bitmap, false, (String) null);
                PersonChangeActivity.this.mPhoto.h(PersonChangeActivity.this.mPhotoView);
                d.b.h0.a0.c.k().c(PersonChangeActivity.this.mModel.s().getPortrait(), PersonChangeActivity.this.mPhoto, true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class u extends BdAsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public NetWork f20043a = null;

        /* renamed from: b  reason: collision with root package name */
        public PersonChangeModel f20044b;

        public u(PersonChangeModel personChangeModel) {
            this.f20044b = null;
            this.f20044b = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            PersonChangeActivity.this.mModifyTask = null;
            NetWork netWork = this.f20043a;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            PersonChangeActivity personChangeActivity = PersonChangeActivity.this;
            personChangeActivity.showLoadingDialog(personChangeActivity.getPageContext().getString(R.string.saving), PersonChangeActivity.this.mDialogCancelListener);
            super.onPreExecute();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            if (this.f20044b == null) {
                return null;
            }
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
            this.f20043a = netWork;
            netWork.addPostData("sex", String.valueOf(this.f20044b.s().getSex()));
            this.f20043a.addPostData("intro", this.f20044b.s().getIntro());
            this.f20043a.addPostData("birthday_time", String.valueOf(this.f20044b.s().getBirthdayTime()));
            this.f20043a.addPostData("birthday_show_status", String.valueOf(this.f20044b.s().getBirthdayShowStatus()));
            this.f20043a.postMultiNetData();
            if (this.f20043a.getNetContext().getResponse().isRequestSuccess()) {
                d.b.i0.d3.n0.a.j();
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            PersonChangeActivity.this.mModifyTask = null;
            PersonChangeActivity.this.closeLoadingDialog();
            NetWork netWork = this.f20043a;
            if (netWork != null) {
                if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                    PersonChangeActivity personChangeActivity = PersonChangeActivity.this;
                    personChangeActivity.showToast(personChangeActivity.getPageContext().getString(R.string.success));
                    PersonChangeActivity.this.setDataAndFinish();
                } else {
                    PersonChangeActivity.this.showToast(this.f20043a.getErrorString());
                }
            }
            super.onPostExecute((u) str);
        }
    }

    private void InitData(Bundle bundle) {
        PersonChangeData personChangeData;
        this.mDialogCancelListener = new q();
        if (bundle != null) {
            String string = bundle.getString("data");
            personChangeData = !StringUtils.isNull(string) ? (PersonChangeData) OrmObject.objectWithJsonStr(string, PersonChangeData.class) : null;
        } else {
            personChangeData = (PersonChangeData) getIntent().getSerializableExtra("data");
        }
        if (personChangeData == null) {
            personChangeData = new PersonChangeData();
        }
        this.mModel = new PersonChangeModel(personChangeData);
    }

    private void InitUI() {
        ImageView imageView = (ImageView) findViewById(R.id.photo_pop_icon);
        this.mPhotoCameraView = imageView;
        imageView.setOnClickListener(this);
        HeadImageView headImageView = (HeadImageView) findViewById(R.id.photo);
        this.mPhotoView = headImageView;
        headImageView.setOnClickListener(this);
        this.mPhotoView.W(HeadIconRefreshHelper.headPortraitFilter(this.mModel.s().getPortrait()), 25, false);
        this.mParent = (LinearLayout) findViewById(R.id.parent);
        this.mPersonChangeScroll = (ScrollView) findViewById(R.id.person_change_scroll);
        this.mSexLayout = (RelativeLayout) findViewById(R.id.person_sex);
        this.mSexShow = (TextView) findViewById(R.id.sex_show);
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar = navigationBar;
        View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.mBackClickListener);
        this.mCloseView = addCustomView;
        ImageView imageView2 = (ImageView) addCustomView.findViewById(R.id.widget_navi_back_button);
        this.mBackIcon = imageView2;
        imageView2.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
        this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
        View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.editLayout = addCustomView2;
        TextView textView = (TextView) addCustomView2.findViewById(R.id.right_textview);
        this.mSave = textView;
        textView.setText(getPageContext().getString(R.string.save));
        SkinManager.setViewTextColor(this.mSave, R.color.navi_op_text, 1);
        this.editLayout.setOnClickListener(this);
        this.mSexLayout.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.intro_click);
        this.mIntroClick = linearLayout;
        linearLayout.setOnClickListener(this);
        this.mIntroClick.setOnTouchListener(new r());
        TextView textView2 = (TextView) findViewById(R.id.nick_name_show);
        this.mNickNameShow = textView2;
        textView2.setText(this.mModel.s().getNameShow());
        View findViewById = findViewById(R.id.person_nickname);
        this.mPersonNicknameLayout = findViewById;
        findViewById.setOnClickListener(this);
        this.mNickNameMore = findViewById(R.id.nick_name_more);
        setNicknameMore();
        this.mUserNameShow = (TextView) findViewById(R.id.user_name_show);
        this.mNameContainer = findViewById(R.id.person_name);
        this.mUserNameMoreIcon = findViewById(R.id.user_name_more_icon);
        this.mNameContainer.setOnClickListener(this);
        if (StringUtils.isNull(this.mModel.s().getName())) {
            this.mUserNameShow.setText(getPageContext().getString(R.string.tip_empty_user_name));
            this.hasUserName = false;
            this.mNameContainer.setClickable(true);
            this.mUserNameMoreIcon.setVisibility(0);
        } else {
            this.mUserNameShow.setText(this.mModel.s().getName());
            this.hasUserName = true;
            this.mNameContainer.setClickable(false);
            this.mUserNameMoreIcon.setVisibility(8);
        }
        this.mIntroTextTip = (LinearLayout) findViewById(R.id.intro_text_tip);
        this.mIntroTextTipNum = (TextView) findViewById(R.id.intro_text_tip_num);
        this.mIntroTextTipDivider = (TextView) findViewById(R.id.intro_text_tip_divider);
        this.mIntroTextTipLimit = (TextView) findViewById(R.id.intro_text_tip_limit);
        TextView textView3 = (TextView) findViewById(R.id.intro);
        this.mIntro = textView3;
        textView3.setVisibility(8);
        if (this.mModel.s().getIntro() != null && this.mModel.s().getIntro().length() > 0) {
            this.mIntro.setText(this.mModel.s().getIntro());
        } else {
            this.mIntro.setText(getPageContext().getString(R.string.add_intro));
        }
        EditText editText = (EditText) findViewById(R.id.edit);
        this.mEdit = editText;
        editText.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
        this.mEdit.setHintTextColor(SkinManager.getColor(R.color.CAM_X0108));
        this.mEdit.setCursorVisible(false);
        if (!d.b.c.e.p.k.isEmpty(this.mModel.s().getIntro())) {
            this.mEdit.setText(this.mModel.s().getIntro());
            TextView textView4 = this.mIntroTextTipNum;
            textView4.setText(this.mModel.s().getIntro().length() + "");
        } else {
            this.mIntroTextTipNum.setText("0");
        }
        this.mIntroTextTip.setVisibility(0);
        this.mEdit.setOnFocusChangeListener(new s());
        this.mEdit.setOnTouchListener(new a());
        this.mEdit.setOnClickListener(this);
        this.mEdit.addTextChangedListener(new b());
        if (this.mModel.s().getSex() == 1) {
            this.mSex = 1;
            this.mSexShow.setText(R.string.male);
        } else if (this.mModel.s().getSex() == 2) {
            this.mSex = 2;
            this.mSexShow.setText(R.string.female);
        } else {
            this.mSexShow.setText(R.string.change_sex);
        }
        this.mImageProgressBar = (ProgressBar) findViewById(R.id.image_progress);
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getPageContext().getPageActivity());
        this.mConfirmDialog = aVar;
        aVar.setMessage(getPageContext().getString(R.string.confirm_giveup));
        this.mConfirmDialog.setPositiveButton(getPageContext().getString(R.string.alert_yes_button), new c());
        this.mConfirmDialog.setNegativeButton(getPageContext().getString(R.string.cancel), new d());
        this.mConfirmDialog.create(getPageContext());
        this.mAlaIdLayout = (LinearLayout) findViewById(R.id.person_ala_id_layout);
        this.mAlaIdView = (TextView) findViewById(R.id.person_ala_id_show);
        if (this.mModel.s().getAlaId() > 0) {
            this.mAlaIdLayout.setVisibility(0);
            TextView textView5 = this.mAlaIdView;
            textView5.setText(this.mModel.s().getAlaId() + "");
        }
        TextView textView6 = (TextView) findViewById(R.id.person_forum_age_show);
        this.mForumAgeView = textView6;
        textView6.setText(getResources().getString(R.string.person_forum_age_suffix, this.mModel.s().getForumAge()));
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.person_constellation);
        this.mConstellationLayout = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.mConstellationView = (TextView) findViewById(R.id.constellation_txt);
        this.mAgeView = (TextView) findViewById(R.id.age_txt);
        if (this.mModel.s().getBirthdayTime() != 0) {
            this.mConstellationView.setText(StringHelper.dateToConstellation(new Date(this.mModel.s().getBirthdayTime() * 1000)));
        }
        if (this.mModel.s().getUserAge() > 0 && this.mModel.s().getBirthdayShowStatus() == 2) {
            this.mAgeView.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.mModel.s().getUserAge())));
            this.mAgeView.setVisibility(0);
        } else {
            this.mAgeView.setVisibility(8);
        }
        this.mPersonChangeScroll.post(new e());
    }

    public static int getAgeByBirthday(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (calendar.before(date)) {
            return 0;
        }
        int i2 = calendar.get(1);
        int i3 = calendar.get(2) + 1;
        int i4 = calendar.get(5);
        calendar.setTime(date);
        int i5 = calendar.get(1);
        int i6 = calendar.get(2) + 1;
        int i7 = i2 - i5;
        return i3 <= i6 ? (i3 != i6 || i4 < calendar.get(5)) ? i7 - 1 : i7 : i7;
    }

    private void getAlbumDataFromCamera(Intent intent) {
        sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), PlayerPostEvent.MEDIA_REP_CHANGE_START, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
    }

    private void getAlbumDataFromImage(Intent intent) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.mWriteImagesInfo.parseJson(stringExtra);
            this.mWriteImagesInfo.updateQuality();
            if (this.mWriteImagesInfo.getChosedFiles() != null && this.mWriteImagesInfo.getChosedFiles().size() > 0) {
                sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) PlayerPostEvent.MEDIA_REP_CHANGE_END, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.mWriteImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
            }
            this.mWriteImagesInfo.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideEditor() {
        if (this.mEdit.getVisibility() == 0) {
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.mIntro.setText(replaceAll);
            } else {
                this.mIntro.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.mModel.s().getIntro() == null || !this.mModel.s().getIntro().equals(replaceAll)) {
                this.isEdited = true;
            }
            this.mModel.s().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void refreshHead() {
        t tVar = this.mImageTask;
        if (tVar != null) {
            tVar.cancel();
        }
        this.mPhoto = null;
        t tVar2 = new t(this, null);
        this.mImageTask = tVar2;
        tVar2.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetUserName(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.hasUserName = true;
        this.mUserNameShow.setText(str);
        this.mNameContainer.setClickable(false);
        this.mUserNameMoreIcon.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveProfile() {
        PersonChangeModel personChangeModel = this.mModel;
        if (personChangeModel == null || personChangeModel.s() == null) {
            return;
        }
        hideEditor();
        if (!d.b.c.e.p.j.z()) {
            showToast(R.string.neterror);
            return;
        }
        this.mModel.s().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
        this.mModel.s().setSex(this.mSex);
        if (this.mModifyTask == null) {
            u uVar = new u(this.mModel);
            this.mModifyTask = uVar;
            uVar.setPriority(3);
            this.mModifyTask.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToBottom(int i2) {
        this.mPersonChangeScroll.postDelayed(new p(), i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUpdateMessage() {
        PersonChangeModel personChangeModel = this.mModel;
        if (personChangeModel == null || personChangeModel.s() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.mModel.s()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataAndFinish() {
        Intent intent = new Intent();
        if (this.isFromPersonInfo.booleanValue()) {
            intent.putExtra("person_change_data", this.mModel.s());
        } else {
            intent.putExtra("data", this.mModel.s());
        }
        setResult(-1, intent);
        sendUpdateMessage();
        finish();
    }

    private void setIntroTextTipStyle(int i2) {
        this.mIntroTextTipNum.setTextColor(i2);
        this.mIntroTextTipDivider.setTextColor(i2);
        this.mIntroTextTipLimit.setTextColor(i2);
    }

    private void setNicknameMore() {
        if (!NickNameActivitySwitch.isOn() && this.mModel.s().getNickNameLeftDays() != 0) {
            this.mNickNameMore.setVisibility(8);
        } else {
            this.mNickNameMore.setVisibility(0);
        }
    }

    private void showEditor() {
        if (this.mEdit.getVisibility() != 0) {
            this.mIntro.setVisibility(8);
            this.mEdit.setText(this.mModel.s().getIntro());
            EditText editText = this.mEdit;
            editText.setSelection(editText.getText().length());
            this.mEdit.requestFocus();
            ShowSoftKeyPad(this.mInputManager, this.mEdit);
            scrollToBottom(800);
        }
    }

    private void showInputDialog(AccountData accountData) {
        if (this.mInputUserNameDialog == null) {
            d.b.h0.s.i.b bVar = new d.b.h0.s.i.b(this);
            this.mInputUserNameDialog = bVar;
            bVar.w(new o());
        }
        this.mInputUserNameDialog.p();
        this.mInputUserNameDialog.u(accountData);
        this.mInputUserNameDialog.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showIntroTextTip() {
        int color;
        if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
            color = SkinManager.getColor(R.color.common_color_10159);
        } else {
            color = SkinManager.getColor(R.color.common_color_10077);
        }
        setIntroTextTipStyle(color);
    }

    private void showNickNameActivityDialog() {
        if (this.mNickNameActivityDialog == null) {
            View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getPageContext().getPageActivity());
            this.mNickNameActivityDialog = aVar;
            aVar.setContentView(inflate);
            this.mNickNameActivityDialog.setPositiveButton(R.string.nick_name_confirm, new m());
            this.mNickNameActivityDialog.setNegativeButton(R.string.nick_name_cancel, new n());
            this.mNickNameActivityDialog.create(getPageContext());
            SkinManager.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), R.color.CAM_X0105);
            SkinManager.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
        }
        this.mNickNameActivityDialog.show();
    }

    private void showSexDialog() {
        if (this.mSexDialog == null) {
            this.mSexDialog = new d.b.h0.r.s.j(getPageContext());
            String string = getPageContext().getString(R.string.male);
            String string2 = getPageContext().getString(R.string.female);
            this.mSexDialog.i(getString(R.string.choose_sex), new String[]{string, string2}, new g(string, string2));
        }
        this.mSexDialog.l();
    }

    public static void startActivityForResult(Activity activity, int i2, PersonChangeData personChangeData, Boolean bool) {
        Intent intent = new Intent(activity, PersonChangeActivity.class);
        intent.putExtra("data", personChangeData);
        intent.putExtra("isFromPersonInfo", bool);
        activity.startActivityForResult(intent, i2);
    }

    private void updateNickName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.isUpdateNickName = true;
        this.mModel.s().setPhotoChanged(true);
        this.mModel.s().setNameShow(str);
        this.mModel.s().setNickNameLeftDays(90);
        this.mNickNameShow.setText(str);
        setNicknameMore();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.mClickOnEditor = false;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && !this.mClickOnEditor) {
            hideEditor();
        }
        return dispatchTouchEvent;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            if (i3 == 0 && i2 == 12010) {
                SelectImageHelper.takePhoto(getPageContext());
            }
        } else if (i2 == 1001) {
            if (intent != null) {
                long longExtra = intent.getLongExtra(PersonConstellationActivity.ACTIVITY_INTENT_BIRTHDAY, 0L);
                int intExtra = intent.getIntExtra(PersonConstellationActivity.ACTIVITY_INTENT_SHOW_STATUS, 0);
                if (longExtra == this.mModel.s().getBirthdayTime() && intExtra == this.mModel.s().getBirthdayShowStatus()) {
                    return;
                }
                this.mModel.s().setBirthdayShowStatus(intExtra);
                this.mModel.s().setBirthdayTime(longExtra);
                this.isEdited = true;
                this.isUpdate = true;
                Date date = new Date(longExtra * 1000);
                this.mConstellationView.setText(StringHelper.dateToConstellation(date));
                if (this.mModel.s().getBirthdayShowStatus() == 2) {
                    this.mAgeView.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(getAgeByBirthday(date))));
                    this.mAgeView.setVisibility(0);
                    return;
                }
                this.mAgeView.setVisibility(8);
            }
        } else if (i2 == 12002) {
            if (intent != null) {
                if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                    getAlbumDataFromCamera(intent);
                } else {
                    getAlbumDataFromImage(intent);
                }
            }
        } else if (i2 == 12014) {
            this.mModel.s().setPhotoChanged(true);
            if (intent != null) {
                this.mPhotoView.setImageBitmap(null);
                this.mPhotoView.W(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
            }
            this.isUpdate = true;
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                SkinManager.setViewTextColor(this.mSave, R.color.navi_op_text, 1);
            } else {
                SkinManager.setViewTextColor(this.mSave, R.color.CAM_X0302, 1);
            }
        } else if (i2 == 12009 || i2 == 12010) {
            this.mModel.s().setPhotoChanged(true);
            refreshHead();
            this.isUpdate = true;
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                SkinManager.setViewTextColor(this.mSave, R.color.navi_op_text, 1);
            } else {
                SkinManager.setViewTextColor(this.mSave, R.color.CAM_X0302, 1);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        getLayoutMode().k(i2 == 1);
        getLayoutMode().j(this.mParent);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mBackIcon, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
        this.mPhotoView.refresh();
        SkinManager.setViewTextColor(this.mUserNameShow, R.color.CAM_X0109);
        WebPManager.setMaskDrawable(this.mPhotoCameraView, R.drawable.icon_mask_personalba_edit40, null);
        SkinManager.setViewTextColor(this.mSave, R.color.CAM_X0302, 1);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        PersonChangeData personChangeData;
        super.onClick(view);
        if (view != this.mPhotoView && view != this.mPhotoCameraView) {
            if (view == this.editLayout) {
                if (!this.isUpdate && !this.isUpdateNickName) {
                    finish();
                }
                if (this.isFromPersonInfo.booleanValue()) {
                    TiebaStatic.log("c10100");
                } else {
                    TiebaStatic.log("c10101");
                }
                if (this.isUpdate) {
                    saveProfile();
                    return;
                } else if (this.isUpdateNickName) {
                    setDataAndFinish();
                    return;
                } else {
                    return;
                }
            } else if (view == this.mSexLayout) {
                showSexDialog();
                return;
            } else if (view == this.mIntroClick) {
                showEditor();
                return;
            } else if (view == this.mEdit) {
                scrollToBottom(800);
                return;
            } else if (view == this.mPersonNicknameLayout) {
                if (Build.VERSION.SDK_INT < 19) {
                    showToast(getPageContext().getPageActivity().getString(R.string.support_modify_nickname));
                    return;
                } else if (NickNameActivitySwitch.isOn()) {
                    showNickNameActivityDialog();
                    return;
                } else {
                    int nickNameLeftDays = this.mModel.s().getNickNameLeftDays();
                    if (this.mModel.s().getMen() > 0) {
                        if (nickNameLeftDays == 0) {
                            sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                            return;
                        } else {
                            showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays)));
                            return;
                        }
                    } else if (nickNameLeftDays == 0) {
                        sendMessage(new CustomMessage(2002001, new EditNickNameActivityConfig(getPageContext().getPageActivity(), 25020, 0, null)));
                        return;
                    } else if (nickNameLeftDays <= 0 || nickNameLeftDays > 2000) {
                        if (nickNameLeftDays > 2000) {
                            showToast(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_tips), Integer.valueOf(nickNameLeftDays - 2000)));
                            return;
                        }
                        return;
                    } else {
                        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getPageContext().getPageActivity());
                        aVar.setMessage(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
                        aVar.setPositiveButton(R.string.open_now, new k());
                        aVar.setNegativeButton(R.string.cancel, new l());
                        aVar.create(getPageContext()).show();
                        return;
                    }
                }
            } else if (view == this.mNameContainer) {
                PersonChangeModel personChangeModel = this.mModel;
                if (personChangeModel == null || personChangeModel.s() == null || StringUtils.isNull(this.mModel.s().getName())) {
                    showInputDialog(TbadkCoreApplication.getCurrentAccountInfo());
                    return;
                }
                return;
            } else if (view == this.mConstellationLayout) {
                PersonConstellationActivity.startPersonConstellationActivity(getActivity(), this.mModel.s().getBirthdayTime(), this.mModel.s().getBirthdayShowStatus());
                return;
            } else {
                return;
            }
        }
        PersonChangeModel personChangeModel2 = this.mModel;
        if (personChangeModel2 != null && (personChangeData = personChangeModel2.f20046e) != null && !personChangeData.canModifyAvatar()) {
            if (!StringUtils.isNull(this.mModel.f20046e.getCantModifyAvatarDesc())) {
                d.b.c.e.p.l.I(TbadkCoreApplication.getInst(), this.mModel.f20046e.getCantModifyAvatarDesc());
                return;
            } else {
                d.b.c.e.p.l.H(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
                return;
            }
        }
        Activity pageActivity = getPageContext().getPageActivity();
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
            return;
        }
        showHeadDialog();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.person_change_activity);
        adjustResizeForSoftInput();
        this.mInputManager = (InputMethodManager) getSystemService("input_method");
        InitData(bundle);
        InitUI();
        if (bundle != null) {
            this.isFromPersonInfo = Boolean.valueOf(bundle.getBoolean("isFromPersonInfo"));
        } else {
            this.isFromPersonInfo = Boolean.valueOf(getIntent().getBooleanExtra("isFromPersonInfo", false));
        }
        TiebaStatic.log("c12204");
        registerListener(this.mModifyNicknameSucceedListener);
        registerListener(this.mChangeLeftDayListener);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.mModifyNicknameSucceedListener);
        t tVar = this.mImageTask;
        if (tVar != null) {
            tVar.cancel();
        }
        u uVar = this.mModifyTask;
        if (uVar != null) {
            uVar.cancel();
        }
        ProgressBar progressBar = this.mImageProgressBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        EditText editText = this.mEdit;
        if (editText != null) {
            editText.addTextChangedListener(null);
        }
        d.b.h0.s.i.b bVar = this.mInputUserNameDialog;
        if (bVar != null) {
            bVar.s();
        }
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            hideEditor();
            this.mBackClickListener.onClick(null);
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.mHasModifyNickName || TextUtils.isEmpty(this.mTempNickName)) {
            return;
        }
        updateNickName(this.mTempNickName);
        this.mHasModifyNickName = false;
        this.mTempNickName = "";
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.mModel.s() != null) {
            bundle.putString("data", OrmObject.jsonStrWithObject(this.mModel.s()));
        }
    }

    public void showHeadDialog() {
        String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
        d.b.h0.r.s.b bVar = new d.b.h0.r.s.b(getPageContext().getPageActivity());
        bVar.k(R.string.operation);
        bVar.j(strArr, new f());
        bVar.c(getPageContext());
        bVar.m();
    }
}
