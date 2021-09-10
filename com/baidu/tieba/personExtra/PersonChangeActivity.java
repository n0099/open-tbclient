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
import androidx.core.view.InputDeviceCompat;
import c.a.q0.s.s.a;
import c.a.q0.s.s.b;
import c.a.q0.s.s.i;
import c.a.q0.t.i.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.HeadIconRefreshHelper;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.SelectImageHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
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
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Calendar;
import java.util.Date;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes7.dex */
public class PersonChangeActivity extends BaseActivity<PersonChangeActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_DAYS_THRESHOLD = 2000;
    public static final int FIRST_SCROLL_TO_BOTTOM_DELAY = 800;
    public static final String IS_FROM_PERSONINFO = "isFromPersonInfo";
    public static final String TAG_DATA = "data";
    public static final String TAG_PERSON_INFO = "person_change_data";
    public transient /* synthetic */ FieldHolder $fh;
    public final int DEFAULT_NICKNAME_LEFT_DAYS;
    public final int EDIT_MAX_LENGTH;
    public View editLayout;
    public boolean hasUserName;
    public boolean isEdited;
    public Boolean isFromPersonInfo;
    public boolean isUpdate;
    public boolean isUpdateNickName;
    public TextView mAgeView;
    public LinearLayout mAlaIdLayout;
    public TextView mAlaIdNameView;
    public TextView mAlaIdView;
    public final View.OnClickListener mBackClickListener;
    public ImageView mBackIcon;
    public CustomMessageListener mChangeLeftDayListener;
    public boolean mClickOnEditor;
    public LinearLayout mClientNumberMain;
    public TextView mClientid;
    public TextView mClientidShow;
    public View mCloseView;
    public c.a.q0.s.s.a mConfirmDialog;
    public RelativeLayout mConstellationLayout;
    public TextView mConstellationView;
    public ImageView mCopyClientid;
    public DialogInterface.OnCancelListener mDialogCancelListener;
    public EditText mEdit;
    public TextView mForumAgeView;
    public boolean mHasModifyNickName;
    public ProgressBar mImageProgressBar;
    public t mImageTask;
    public InputMethodManager mInputManager;
    public c.a.q0.t.i.b mInputUserNameDialog;
    public TextView mIntro;
    public LinearLayout mIntroClick;
    public LinearLayout mIntroTextTip;
    public TextView mIntroTextTipDivider;
    public TextView mIntroTextTipLimit;
    public TextView mIntroTextTipNum;
    public PersonChangeModel mModel;
    public CustomMessageListener mModifyNicknameSucceedListener;
    public u mModifyTask;
    public View mNameContainer;
    public NavigationBar mNavigationBar;
    public c.a.q0.s.s.a mNickNameActivityDialog;
    public View mNickNameMore;
    public TextView mNickNameShow;
    public LinearLayout mParent;
    public PermissionJudgePolicy mPermissionJudgement;
    public ScrollView mPersonChangeScroll;
    public View mPersonNicknameLayout;
    public c.a.e.l.d.a mPhoto;
    public ImageView mPhotoCameraView;
    public HeadImageView mPhotoView;
    public View mRootView;
    public TextView mSave;
    public int mSex;
    public PopupDialog mSexDialog;
    public RelativeLayout mSexLayout;
    public TextView mSexShow;
    public String mTempNickName;
    public View mUserNameMoreIcon;
    public TextView mUserNameShow;
    public final WriteImagesInfo mWriteImagesInfo;
    public TextView tvForumAbs;
    public TextView tvForumAge;

    /* loaded from: classes7.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55899e;

        public a(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55899e = personChangeActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f55899e.mClickOnEditor = true;
                    this.f55899e.mEdit.setCursorVisible(true);
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55900e;

        public b(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55900e = personChangeActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || editable.toString().replaceAll("\\s*", "").equals(this.f55900e.mModel.w().getIntro())) {
                return;
            }
            this.f55900e.isUpdate = true;
            if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                SkinManager.setViewTextColor(this.f55900e.mSave, R.color.navi_op_text, 1);
            } else {
                SkinManager.setViewTextColor(this.f55900e.mSave, R.color.CAM_X0302, 1);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                Editable text = this.f55900e.mEdit.getText();
                String replaceAll = text.toString().replaceAll("\\s*", "");
                int length = replaceAll.length();
                this.f55900e.mIntroTextTipNum.setText(String.valueOf(length));
                this.f55900e.mIntroTextTip.setVisibility(0);
                this.f55900e.scrollToBottom(0);
                this.f55900e.showIntroTextTip();
                if (length > 500) {
                    this.f55900e.showToast(R.string.over_limit_tip);
                    if (this.f55900e.mEdit.getSelectionStart() - 1 < 0 || this.f55900e.mEdit.getSelectionStart() - 1 > this.f55900e.mEdit.getSelectionEnd()) {
                        this.f55900e.mEdit.setText(replaceAll.substring(0, 500));
                    } else {
                        text.delete(this.f55900e.mEdit.getSelectionStart() - 1, this.f55900e.mEdit.getSelectionEnd());
                        this.f55900e.mEdit.setText(charSequence);
                    }
                    int selectionEnd = Selection.getSelectionEnd(text);
                    int length2 = text.length();
                    if (selectionEnd > length2) {
                        selectionEnd = length2;
                    }
                    Selection.setSelection(this.f55900e.mEdit.getText(), selectionEnd);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55901e;

        public c(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55901e = personChangeActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                this.f55901e.saveProfile();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55902e;

        public d(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55902e = personChangeActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                if (this.f55902e.mModel.w().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (!this.f55902e.isFromPersonInfo.booleanValue()) {
                        intent.putExtra("data", this.f55902e.mModel.w());
                    } else {
                        intent.putExtra("person_change_data", this.f55902e.mModel.w());
                    }
                    this.f55902e.setResult(-1, intent);
                    this.f55902e.sendUpdateMessage();
                }
                this.f55902e.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55903e;

        public e(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55903e = personChangeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55903e.mPersonChangeScroll.scrollTo(0, 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55904a;

        public f(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55904a = personChangeActivity;
        }

        @Override // c.a.q0.s.s.b.c
        public void a(c.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (i2 == 0) {
                    AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.f55904a.getPageContext().getPageActivity(), this.f55904a.mWriteImagesInfo.toJsonString(), true);
                    albumActivityConfig.setRequestCode(12002);
                    albumActivityConfig.setResourceType(2);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
                } else if (i2 == 1) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ChangeSystemPhotoActivityConfig(this.f55904a.getPageContext().getPageActivity(), 12014)));
                }
                bVar.e();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements i.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f55905e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f55906f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55907g;

        public g(PersonChangeActivity personChangeActivity, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55907g = personChangeActivity;
            this.f55905e = str;
            this.f55906f = str2;
        }

        @Override // c.a.q0.s.s.i.e
        public void onItemClick(c.a.q0.s.s.i iVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, iVar, i2, view) == null) {
                if (this.f55907g.mSexDialog != null && this.f55907g.mSexDialog.isShowing()) {
                    this.f55907g.mSexDialog.dismiss();
                }
                if (view instanceof TextView) {
                    TextView textView = (TextView) view;
                    if (this.f55905e.equals(textView.getText().toString())) {
                        this.f55907g.mSex = 1;
                        this.f55907g.mSexShow.setText(this.f55905e);
                    } else if (this.f55906f.equals(textView.getText().toString())) {
                        this.f55907g.mSex = 2;
                        this.f55907g.mSexShow.setText(this.f55906f);
                    }
                    if (this.f55907g.mSex != this.f55907g.mModel.w().getSex()) {
                        this.f55907g.isUpdate = true;
                        if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                            SkinManager.setViewTextColor(this.f55907g.mSave, R.color.navi_op_text, 1);
                        } else {
                            SkinManager.setViewTextColor(this.f55907g.mSave, R.color.CAM_X0302, 1);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55908e;

        public h(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55908e = personChangeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f55908e.mModel.w().getSex() != this.f55908e.mSex) {
                    this.f55908e.isEdited = true;
                }
                if (this.f55908e.isEdited) {
                    this.f55908e.mConfirmDialog.show();
                    return;
                }
                if (this.f55908e.mModel != null && this.f55908e.mModel.w().getPhotoChanged()) {
                    Intent intent = new Intent();
                    if (this.f55908e.isFromPersonInfo.booleanValue()) {
                        intent.putExtra("person_change_data", this.f55908e.mModel.w());
                    } else {
                        intent.putExtra("data", this.f55908e.mModel.w());
                    }
                    this.f55908e.sendUpdateMessage();
                    this.f55908e.setResult(-1, intent);
                }
                this.f55908e.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55909a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(PersonChangeActivity personChangeActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55909a = personChangeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                String str = (String) data;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f55909a.mHasModifyNickName = true;
                this.f55909a.mTempNickName = str;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55910a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(PersonChangeActivity personChangeActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55910a = personChangeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof PersonChangeData)) {
                PersonChangeData personChangeData = (PersonChangeData) customResponsedMessage.getData();
                if (this.f55910a.mModel == null || this.f55910a.mModel.w() == null || personChangeData == null) {
                    return;
                }
                this.f55910a.mModel.w().setNickNameLeftDays(personChangeData.getNickNameLeftDays());
                this.f55910a.mModel.w().setMem(personChangeData.getMen());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55911e;

        public k(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55911e = personChangeActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (c.a.e.e.p.j.z()) {
                    MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(this.f55911e.getPageContext().getPageActivity(), 24);
                    memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_MY_DATA, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
                    this.f55911e.sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
                    TiebaStatic.log(TbadkCoreStatisticKey.MODIFY_NICK_ENTER_OPNEN_MEM_CLICK);
                } else {
                    this.f55911e.showToast(R.string.neterror);
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class l implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55912e;

        public l(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55912e = personChangeActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class m implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55913e;

        public m(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55913e = personChangeActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.f55913e.getPageContext().getPageActivity(), null, c.a.r0.j2.c.a(), true)));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class n implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55914e;

        public n(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55914e = personChangeActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class o implements b.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55915a;

        public o(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55915a = personChangeActivity;
        }

        @Override // c.a.q0.t.i.b.e
        public void a(AccountData accountData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, accountData) == null) || accountData == null) {
                return;
            }
            this.f55915a.resetUserName(accountData.getAccount());
        }
    }

    /* loaded from: classes7.dex */
    public class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55916e;

        public p(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55916e = personChangeActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55916e.mPersonChangeScroll.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class q implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55917e;

        public q(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55917e = personChangeActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f55917e.destroyWaitingDialog();
                if (this.f55917e.mModifyTask != null) {
                    this.f55917e.mModifyTask.cancel();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class r implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55918e;

        public r(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55918e = personChangeActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (motionEvent.getAction() == 1) {
                    this.f55918e.mClickOnEditor = true;
                    return false;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class s implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55919e;

        public s(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55919e = personChangeActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) || z) {
                return;
            }
            this.f55919e.hideEditor();
        }
    }

    /* loaded from: classes7.dex */
    public class t extends BdAsyncTask<Object, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55920a;

        public t(PersonChangeActivity personChangeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55920a = personChangeActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Object... objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, objArr)) == null) ? FileHelper.getImage(null, TbConfig.PERSON_HEAD_FILE) : (Bitmap) invokeL.objValue;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f55920a.mImageTask = null;
                this.f55920a.mImageProgressBar.setVisibility(8);
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                super.onCancelled();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f55920a.mImageProgressBar.setVisibility(0);
                this.f55920a.mPhotoView.setImageDrawable(null);
                this.f55920a.mPhoto = null;
                super.onPreExecute();
            }
        }

        public /* synthetic */ t(PersonChangeActivity personChangeActivity, k kVar) {
            this(personChangeActivity);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, bitmap) == null) {
                super.onPostExecute((t) bitmap);
                this.f55920a.mImageTask = null;
                this.f55920a.mImageProgressBar.setVisibility(8);
                if (bitmap != null) {
                    this.f55920a.mPhoto = new c.a.e.l.d.a(bitmap, false, (String) null);
                    this.f55920a.mPhoto.h(this.f55920a.mPhotoView);
                    c.a.q0.c0.c.k().c(this.f55920a.mModel.w().getPortrait(), this.f55920a.mPhoto, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class u extends BdAsyncTask<String, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public NetWork f55921a;

        /* renamed from: b  reason: collision with root package name */
        public PersonChangeModel f55922b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PersonChangeActivity f55923c;

        public u(PersonChangeActivity personChangeActivity, PersonChangeModel personChangeModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personChangeActivity, personChangeModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55923c = personChangeActivity;
            this.f55921a = null;
            this.f55922b = null;
            this.f55922b = personChangeModel;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55923c.mModifyTask = null;
                NetWork netWork = this.f55921a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                }
                super.cancel(true);
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                PersonChangeActivity personChangeActivity = this.f55923c;
                personChangeActivity.showLoadingDialog(personChangeActivity.getPageContext().getString(R.string.saving), this.f55923c.mDialogCancelListener);
                super.onPreExecute();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
                if (this.f55922b == null) {
                    return null;
                }
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.PROFILE_MODIFY);
                this.f55921a = netWork;
                netWork.addPostData("sex", String.valueOf(this.f55922b.w().getSex()));
                this.f55921a.addPostData("intro", this.f55922b.w().getIntro());
                this.f55921a.addPostData("birthday_time", String.valueOf(this.f55922b.w().getBirthdayTime()));
                this.f55921a.addPostData("birthday_show_status", String.valueOf(this.f55922b.w().getBirthdayShowStatus()));
                this.f55921a.postMultiNetData();
                if (this.f55921a.getNetContext().getResponse().isRequestSuccess()) {
                    c.a.r0.j3.o0.a.j();
                }
                return null;
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.f55923c.mModifyTask = null;
                this.f55923c.closeLoadingDialog();
                NetWork netWork = this.f55921a;
                if (netWork != null) {
                    if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                        PersonChangeActivity personChangeActivity = this.f55923c;
                        personChangeActivity.showToast(personChangeActivity.getPageContext().getString(R.string.success));
                        this.f55923c.setDataAndFinish();
                    } else {
                        this.f55923c.showToast(this.f55921a.getErrorString());
                    }
                }
                super.onPostExecute((u) str);
            }
        }
    }

    public PersonChangeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.DEFAULT_NICKNAME_LEFT_DAYS = 90;
        this.isFromPersonInfo = Boolean.FALSE;
        this.mWriteImagesInfo = new WriteImagesInfo(1);
        this.mNavigationBar = null;
        this.mSave = null;
        this.mParent = null;
        this.mPersonChangeScroll = null;
        this.mSexLayout = null;
        this.mIntroClick = null;
        this.mEdit = null;
        this.mIntroTextTip = null;
        this.mInputManager = null;
        this.mClickOnEditor = false;
        this.mModel = null;
        this.mPhotoView = null;
        this.mPhoto = null;
        this.mImageTask = null;
        this.mModifyTask = null;
        this.mImageProgressBar = null;
        this.mDialogCancelListener = null;
        this.mConfirmDialog = null;
        this.mSexDialog = null;
        this.isEdited = false;
        this.isUpdate = false;
        this.isUpdateNickName = false;
        this.mSex = 0;
        this.EDIT_MAX_LENGTH = 500;
        this.hasUserName = false;
        this.mHasModifyNickName = false;
        this.mBackClickListener = new h(this);
        this.mModifyNicknameSucceedListener = new i(this, 2921033);
        this.mChangeLeftDayListener = new j(this, 2921061);
    }

    private void InitData(Bundle bundle) {
        PersonChangeData personChangeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, bundle) == null) {
            this.mDialogCancelListener = new q(this);
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
    }

    private void InitUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mPhotoCameraView = (ImageView) findViewById(R.id.photo_pop_icon);
            this.mRootView = findViewById(R.id.main_parent);
            this.mPhotoCameraView.setOnClickListener(this);
            HeadImageView headImageView = (HeadImageView) findViewById(R.id.photo);
            this.mPhotoView = headImageView;
            headImageView.setOnClickListener(this);
            this.mPhotoView.startLoad(HeadIconRefreshHelper.headPortraitFilter(this.mModel.w().getPortrait()), 25, false);
            this.mParent = (LinearLayout) findViewById(R.id.parent);
            this.mPersonChangeScroll = (ScrollView) findViewById(R.id.person_change_scroll);
            this.mSexLayout = (RelativeLayout) findViewById(R.id.person_sex);
            this.mSexShow = (TextView) findViewById(R.id.sex_show);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.mNavigationBar = navigationBar;
            View addCustomView = navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.widget_nb_item_finish, this.mBackClickListener);
            this.mCloseView = addCustomView;
            ImageView imageView = (ImageView) addCustomView.findViewById(R.id.widget_navi_back_button);
            this.mBackIcon = imageView;
            imageView.setContentDescription(getPageContext().getPageActivity().getResources().getString(R.string.close));
            this.mNavigationBar.setCenterTextTitle(getResources().getString(R.string.my_info));
            View addCustomView2 = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
            this.editLayout = addCustomView2;
            this.mSave = (TextView) addCustomView2.findViewById(R.id.right_textview);
            this.tvForumAbs = (TextView) findViewById(R.id.tv_forum_abs);
            this.tvForumAge = (TextView) findViewById(R.id.tv_forum_age);
            this.mSave.setText(getPageContext().getString(R.string.save));
            SkinManager.setViewTextColor(this.mSave, R.color.navi_op_text, 1);
            this.editLayout.setOnClickListener(this);
            this.mSexLayout.setOnClickListener(this);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.intro_click);
            this.mIntroClick = linearLayout;
            linearLayout.setOnClickListener(this);
            this.mIntroClick.setOnTouchListener(new r(this));
            TextView textView = (TextView) findViewById(R.id.nick_name_show);
            this.mNickNameShow = textView;
            textView.setText(this.mModel.w().getNameShow());
            this.mClientid = (TextView) findViewById(R.id.person_clientid);
            this.mClientNumberMain = (LinearLayout) findViewById(R.id.person_client_number);
            this.mClientidShow = (TextView) findViewById(R.id.person_tclient_show);
            this.mCopyClientid = (ImageView) findViewById(R.id.person_client_copy);
            PersonChangeModel personChangeModel = this.mModel;
            if (personChangeModel != null && personChangeModel.w() != null && !TextUtils.isEmpty(this.mModel.w().getmTiebaId())) {
                this.mClientidShow.setText(this.mModel.w().getmTiebaId());
            } else {
                this.mClientNumberMain.setVisibility(8);
            }
            this.mClientNumberMain.setOnClickListener(this);
            View findViewById = findViewById(R.id.person_nickname);
            this.mPersonNicknameLayout = findViewById;
            findViewById.setOnClickListener(this);
            this.mNickNameMore = findViewById(R.id.nick_name_more);
            setNicknameMore();
            this.mUserNameShow = (TextView) findViewById(R.id.user_name_show);
            this.mNameContainer = findViewById(R.id.person_name);
            this.mUserNameMoreIcon = findViewById(R.id.user_name_more_icon);
            this.mNameContainer.setOnClickListener(this);
            if (StringUtils.isNull(this.mModel.w().getName())) {
                this.mUserNameShow.setText(getPageContext().getString(R.string.tip_empty_user_name));
                this.hasUserName = false;
                this.mNameContainer.setClickable(true);
                this.mUserNameMoreIcon.setVisibility(0);
            } else {
                this.mUserNameShow.setText(this.mModel.w().getName());
                this.hasUserName = true;
                this.mNameContainer.setClickable(false);
                this.mUserNameMoreIcon.setVisibility(8);
            }
            this.mIntroTextTip = (LinearLayout) findViewById(R.id.intro_text_tip);
            this.mIntroTextTipNum = (TextView) findViewById(R.id.intro_text_tip_num);
            this.mIntroTextTipDivider = (TextView) findViewById(R.id.intro_text_tip_divider);
            this.mIntroTextTipLimit = (TextView) findViewById(R.id.intro_text_tip_limit);
            TextView textView2 = (TextView) findViewById(R.id.intro);
            this.mIntro = textView2;
            textView2.setVisibility(8);
            if (this.mModel.w().getIntro() != null && this.mModel.w().getIntro().length() > 0) {
                this.mIntro.setText(this.mModel.w().getIntro());
            } else {
                this.mIntro.setText(getPageContext().getString(R.string.add_intro));
            }
            EditText editText = (EditText) findViewById(R.id.edit);
            this.mEdit = editText;
            editText.setHint(getResources().getString(R.string.person_default_sign, "o(〃'▽'〃)o"));
            this.mEdit.setHintTextColor(SkinManager.getColor(R.color.CAM_X0108));
            this.mEdit.setCursorVisible(false);
            if (!c.a.e.e.p.k.isEmpty(this.mModel.w().getIntro())) {
                this.mEdit.setText(this.mModel.w().getIntro());
                TextView textView3 = this.mIntroTextTipNum;
                textView3.setText(this.mModel.w().getIntro().length() + "");
            } else {
                this.mIntroTextTipNum.setText("0");
            }
            this.mIntroTextTip.setVisibility(0);
            this.mEdit.setOnFocusChangeListener(new s(this));
            this.mEdit.setOnTouchListener(new a(this));
            this.mEdit.setOnClickListener(this);
            this.mEdit.addTextChangedListener(new b(this));
            if (this.mModel.w().getSex() == 1) {
                this.mSex = 1;
                this.mSexShow.setText(R.string.male);
            } else if (this.mModel.w().getSex() == 2) {
                this.mSex = 2;
                this.mSexShow.setText(R.string.female);
            } else {
                this.mSexShow.setText(R.string.change_sex);
            }
            this.mImageProgressBar = (ProgressBar) findViewById(R.id.image_progress);
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getPageContext().getPageActivity());
            this.mConfirmDialog = aVar;
            aVar.setMessage(getPageContext().getString(R.string.confirm_giveup));
            this.mConfirmDialog.setPositiveButton(getPageContext().getString(R.string.alert_yes_button), new c(this));
            this.mConfirmDialog.setNegativeButton(getPageContext().getString(R.string.cancel), new d(this));
            this.mConfirmDialog.create(getPageContext());
            this.mAlaIdLayout = (LinearLayout) findViewById(R.id.person_ala_id_layout);
            this.mAlaIdView = (TextView) findViewById(R.id.person_ala_id_show);
            this.mAlaIdNameView = (TextView) findViewById(R.id.person_ala_id_name);
            if (this.mModel.w().getAlaId() > 0) {
                this.mAlaIdLayout.setVisibility(0);
                TextView textView4 = this.mAlaIdView;
                textView4.setText(this.mModel.w().getAlaId() + "");
            }
            TextView textView5 = (TextView) findViewById(R.id.person_forum_age_show);
            this.mForumAgeView = textView5;
            textView5.setText(getResources().getString(R.string.person_forum_age_suffix, this.mModel.w().getForumAge()));
            RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.person_constellation);
            this.mConstellationLayout = relativeLayout;
            relativeLayout.setOnClickListener(this);
            this.mConstellationView = (TextView) findViewById(R.id.constellation_txt);
            this.mAgeView = (TextView) findViewById(R.id.age_txt);
            if (this.mModel.w().getBirthdayTime() != 0) {
                this.mConstellationView.setText(StringHelper.dateToConstellation(new Date(this.mModel.w().getBirthdayTime() * 1000)));
            }
            if (this.mModel.w().getUserAge() > 0 && this.mModel.w().getBirthdayShowStatus() == 2) {
                this.mAgeView.setText(getResources().getString(R.string.person_information_header_age, Integer.valueOf(this.mModel.w().getUserAge())));
                this.mAgeView.setVisibility(0);
            } else {
                this.mAgeView.setVisibility(8);
            }
            this.mPersonChangeScroll.post(new e(this));
        }
    }

    public static int getAgeByBirthday(Date date) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, date)) == null) {
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
        return invokeL.intValue;
    }

    private void getAlbumDataFromCamera(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, this, intent) == null) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, 12010, null, TbadkCoreApplication.getCurrentAccountObj(), 1.0f)));
        }
    }

    private void getAlbumDataFromImage(Intent intent) {
        String stringExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65574, this, intent) == null) || (stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT)) == null) {
            return;
        }
        this.mWriteImagesInfo.parseJson(stringExtra);
        this.mWriteImagesInfo.updateQuality();
        if (this.mWriteImagesInfo.getChosedFiles() != null && this.mWriteImagesInfo.getChosedFiles().size() > 0) {
            sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, 12009, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), 0, this.mWriteImagesInfo.getChosedFiles().get(0).getFilePath(), 1.0f)));
        }
        this.mWriteImagesInfo.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideEditor() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65575, this) == null) && this.mEdit.getVisibility() == 0) {
            String replaceAll = this.mEdit.getText().toString().replaceAll("\\s*", "");
            if (replaceAll.length() > 0) {
                this.mIntro.setText(replaceAll);
            } else {
                this.mIntro.setText(getPageContext().getString(R.string.add_intro));
            }
            if (this.mModel.w().getIntro() == null || !this.mModel.w().getIntro().equals(replaceAll)) {
                this.isEdited = true;
            }
            this.mModel.w().setIntro(replaceAll);
            HidenSoftKeyPad(this.mInputManager, this.mEdit);
        }
    }

    private void refreshHead() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            t tVar = this.mImageTask;
            if (tVar != null) {
                tVar.cancel();
            }
            this.mPhoto = null;
            t tVar2 = new t(this, null);
            this.mImageTask = tVar2;
            tVar2.execute(new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetUserName(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65577, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.hasUserName = true;
        this.mUserNameShow.setText(str);
        this.mNameContainer.setClickable(false);
        this.mUserNameMoreIcon.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveProfile() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65578, this) == null) || (personChangeModel = this.mModel) == null || personChangeModel.w() == null) {
            return;
        }
        hideEditor();
        if (!c.a.e.e.p.j.z()) {
            showToast(R.string.neterror);
            return;
        }
        this.mModel.w().setIntro(this.mEdit.getText().toString().replaceAll("\\s*", ""));
        this.mModel.w().setSex(this.mSex);
        if (this.mModifyTask == null) {
            u uVar = new u(this, this.mModel);
            this.mModifyTask = uVar;
            uVar.setPriority(3);
            this.mModifyTask.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToBottom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65579, this, i2) == null) {
            this.mPersonChangeScroll.postDelayed(new p(this), i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUpdateMessage() {
        PersonChangeModel personChangeModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65580, this) == null) || (personChangeModel = this.mModel) == null || personChangeModel.w() == null) {
            return;
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001380, this.mModel.w()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataAndFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            Intent intent = new Intent();
            if (this.isFromPersonInfo.booleanValue()) {
                intent.putExtra("person_change_data", this.mModel.w());
            } else {
                intent.putExtra("data", this.mModel.w());
            }
            setResult(-1, intent);
            sendUpdateMessage();
            finish();
        }
    }

    private void setIntroTextTipStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65582, this, i2) == null) {
            this.mIntroTextTipNum.setTextColor(i2);
            this.mIntroTextTipDivider.setTextColor(i2);
            this.mIntroTextTipLimit.setTextColor(i2);
        }
    }

    private void setNicknameMore() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            if (!NickNameActivitySwitch.isOn() && this.mModel.w().getNickNameLeftDays() != 0) {
                this.mNickNameMore.setVisibility(8);
            } else {
                this.mNickNameMore.setVisibility(0);
            }
        }
    }

    private void showEditor() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65584, this) == null) || this.mEdit.getVisibility() == 0) {
            return;
        }
        this.mIntro.setVisibility(8);
        this.mEdit.setText(this.mModel.w().getIntro());
        EditText editText = this.mEdit;
        editText.setSelection(editText.getText().length());
        this.mEdit.requestFocus();
        ShowSoftKeyPad(this.mInputManager, this.mEdit);
        scrollToBottom(800);
    }

    private void showInputDialog(AccountData accountData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65585, this, accountData) == null) {
            if (this.mInputUserNameDialog == null) {
                c.a.q0.t.i.b bVar = new c.a.q0.t.i.b(this);
                this.mInputUserNameDialog = bVar;
                bVar.w(new o(this));
            }
            this.mInputUserNameDialog.p();
            this.mInputUserNameDialog.u(accountData);
            this.mInputUserNameDialog.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showIntroTextTip() {
        int color;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65586, this) == null) {
            if (this.mEdit.getText().toString().replaceAll("\\s*", "").length() >= 500) {
                color = SkinManager.getColor(R.color.common_color_10159);
            } else {
                color = SkinManager.getColor(R.color.common_color_10077);
            }
            setIntroTextTipStyle(color);
        }
    }

    private void showNickNameActivityDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65587, this) == null) {
            if (this.mNickNameActivityDialog == null) {
                View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.person_nickname_act_dialog, (ViewGroup) null);
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getPageContext().getPageActivity());
                this.mNickNameActivityDialog = aVar;
                aVar.setContentView(inflate);
                this.mNickNameActivityDialog.setPositiveButton(R.string.nick_name_confirm, new m(this));
                this.mNickNameActivityDialog.setNegativeButton(R.string.nick_name_cancel, new n(this));
                this.mNickNameActivityDialog.create(getPageContext());
                SkinManager.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_title), R.color.CAM_X0105);
                SkinManager.setViewTextColor(inflate.findViewById(R.id.nickname_dialog_tip), R.color.common_color_10122);
            }
            this.mNickNameActivityDialog.show();
        }
    }

    private void showSexDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65588, this) == null) {
            if (this.mSexDialog == null) {
                this.mSexDialog = new PopupDialog(getPageContext());
                String string = getPageContext().getString(R.string.male);
                String string2 = getPageContext().getString(R.string.female);
                this.mSexDialog.setDefaultContentView(getString(R.string.choose_sex), new String[]{string, string2}, new g(this, string, string2));
            }
            this.mSexDialog.showDialog();
        }
    }

    public static void startActivityForResult(Activity activity, int i2, PersonChangeData personChangeData, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65589, null, activity, i2, personChangeData, bool) == null) {
            Intent intent = new Intent(activity, PersonChangeActivity.class);
            intent.putExtra("data", personChangeData);
            intent.putExtra("isFromPersonInfo", bool);
            activity.startActivityForResult(intent, i2);
        }
    }

    private void updateNickName(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65590, this, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.isUpdateNickName = true;
        this.mModel.w().setPhotoChanged(true);
        this.mModel.w().setNameShow(str);
        this.mModel.w().setNickNameLeftDays(90);
        this.mNickNameShow.setText(str);
        setNicknameMore();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
            this.mClickOnEditor = false;
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (motionEvent.getAction() == 1 && !this.mClickOnEditor) {
                hideEditor();
            }
            return dispatchTouchEvent;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 != -1) {
                if (i3 == 0 && i2 == 12010) {
                    SelectImageHelper.takePhoto(getPageContext());
                }
            } else if (i2 == 1001) {
                if (intent != null) {
                    long longExtra = intent.getLongExtra(PersonConstellationActivity.ACTIVITY_INTENT_BIRTHDAY, 0L);
                    int intExtra = intent.getIntExtra(PersonConstellationActivity.ACTIVITY_INTENT_SHOW_STATUS, 0);
                    if (longExtra == this.mModel.w().getBirthdayTime() && intExtra == this.mModel.w().getBirthdayShowStatus()) {
                        return;
                    }
                    this.mModel.w().setBirthdayShowStatus(intExtra);
                    this.mModel.w().setBirthdayTime(longExtra);
                    this.isEdited = true;
                    this.isUpdate = true;
                    Date date = new Date(longExtra * 1000);
                    this.mConstellationView.setText(StringHelper.dateToConstellation(date));
                    if (this.mModel.w().getBirthdayShowStatus() == 2) {
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
                this.mModel.w().setPhotoChanged(true);
                if (intent != null) {
                    this.mPhotoView.setImageBitmap(null);
                    this.mPhotoView.startLoad(intent.getStringExtra(ChangeSystemPhotoActivityConfig.NEW_PHOTO_URL), 10, false);
                }
                this.isUpdate = true;
                if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                    SkinManager.setViewTextColor(this.mSave, R.color.navi_op_text, 1);
                } else {
                    SkinManager.setViewTextColor(this.mSave, R.color.CAM_X0302, 1);
                }
            } else if (i2 == 12009 || i2 == 12010) {
                this.mModel.w().setPhotoChanged(true);
                refreshHead();
                this.isUpdate = true;
                if (TbadkCoreApplication.getInst().getSkinType() == 2) {
                    SkinManager.setViewTextColor(this.mSave, R.color.navi_op_text, 1);
                } else {
                    SkinManager.setViewTextColor(this.mSave, R.color.CAM_X0302, 1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.mParent);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mBackIcon, R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            this.mPhotoView.refresh();
            SkinManager.setViewTextColor(this.mUserNameShow, R.color.CAM_X0109);
            WebPManager.setMaskDrawable(this.mPhotoCameraView, R.drawable.icon_mask_personalba_edit40, null);
            WebPManager.setPureDrawable(this.mCopyClientid, R.drawable.icon_pure_wo_recommend_copy18, R.color.CAM_X0108, null);
            SkinManager.setViewTextColor(this.mSave, R.color.CAM_X0302, 1);
            c.a.q0.s.u.c.d(this.mClientid).w(R.color.CAM_X0108);
            c.a.q0.s.u.c.d(this.mClientidShow).w(R.color.CAM_X0108);
            c.a.q0.s.u.c.d(this.tvForumAbs).w(R.color.CAM_X0109);
            c.a.q0.s.u.c.d(this.tvForumAge).w(R.color.CAM_X0109);
            c.a.q0.s.u.c.d(this.mAlaIdNameView).w(R.color.CAM_X0109);
            c.a.q0.s.u.c.d(this.mAlaIdView).w(R.color.CAM_X0109);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        PersonChangeData personChangeData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
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
                        int nickNameLeftDays = this.mModel.w().getNickNameLeftDays();
                        if (this.mModel.w().getMen() > 0) {
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
                            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(getPageContext().getPageActivity());
                            aVar.setMessage(String.format(getPageContext().getPageActivity().getString(R.string.modify_nickname_no_first_welfare), Integer.valueOf(nickNameLeftDays)));
                            aVar.setPositiveButton(R.string.open_now, new k(this));
                            aVar.setNegativeButton(R.string.cancel, new l(this));
                            aVar.create(getPageContext()).show();
                            return;
                        }
                    }
                } else if (view == this.mNameContainer) {
                    PersonChangeModel personChangeModel = this.mModel;
                    if (personChangeModel == null || personChangeModel.w() == null || StringUtils.isNull(this.mModel.w().getName())) {
                        showInputDialog(TbadkCoreApplication.getCurrentAccountInfo());
                        return;
                    }
                    return;
                } else if (view == this.mConstellationLayout) {
                    PersonConstellationActivity.startPersonConstellationActivity(getActivity(), this.mModel.w().getBirthdayTime(), this.mModel.w().getBirthdayShowStatus());
                    return;
                } else if (view != this.mClientNumberMain || this.mClientidShow == null || this.mUserNameShow == null) {
                    return;
                } else {
                    c.a.e.e.p.a.a(String.format(getResources().getString(R.string.to_share_tieba_id), TbadkCoreApplication.getCurrentAccountNameShow(), this.mClientidShow.getText().toString()));
                    new BdTopToast(this, 3000).setIcon(true).setContent(getResources().getString(R.string.copy_success)).show((ViewGroup) this.mRootView);
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COPY_CLIENT_NUMBER_CLICK).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_param1", this.mClientidShow.getText().toString()).param("obj_locate", 2));
                    return;
                }
            }
            PersonChangeModel personChangeModel2 = this.mModel;
            if (personChangeModel2 != null && (personChangeData = personChangeModel2.f55924e) != null && !personChangeData.canModifyAvatar()) {
                if (!StringUtils.isNull(this.mModel.f55924e.getCantModifyAvatarDesc())) {
                    c.a.e.e.p.l.J(TbadkCoreApplication.getInst(), this.mModel.f55924e.getCantModifyAvatarDesc());
                    return;
                } else {
                    c.a.e.e.p.l.I(TbadkCoreApplication.getInst(), R.string.person_cant_edit_avatar_default_tip);
                    return;
                }
            }
            Activity pageActivity = getPageContext().getPageActivity();
            if (this.mPermissionJudgement == null) {
                this.mPermissionJudgement = new PermissionJudgePolicy();
            }
            this.mPermissionJudgement.clearRequestPermissionList();
            this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
            if (this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                return;
            }
            showHeadDialog();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
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
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
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
            c.a.q0.t.i.b bVar = this.mInputUserNameDialog;
            if (bVar != null) {
                bVar.s();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                hideEditor();
                this.mBackClickListener.onClick(null);
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            if (!this.mHasModifyNickName || TextUtils.isEmpty(this.mTempNickName)) {
                return;
            }
            updateNickName(this.mTempNickName);
            this.mHasModifyNickName = false;
            this.mTempNickName = "";
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (this.mModel.w() != null) {
                bundle.putString("data", OrmObject.jsonStrWithObject(this.mModel.w()));
            }
        }
    }

    public void showHeadDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String[] strArr = {getPageContext().getString(R.string.change_photo), getPageContext().getString(R.string.change_system_photo)};
            c.a.q0.s.s.b bVar = new c.a.q0.s.s.b(getPageContext().getPageActivity());
            bVar.k(R.string.operation);
            bVar.j(strArr, new f(this));
            bVar.c(getPageContext());
            bVar.m();
        }
    }
}
