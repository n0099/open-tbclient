package com.baidu.tieba.newfaceshop.facemake;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.FaceGroupMakeActivityConfig;
import com.baidu.tbadk.core.atomData.PickFaceTabActivityConfig;
import com.baidu.tbadk.core.atomData.SelectSingleForumActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.BazhuInfoData;
import com.baidu.tieba.R;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.tieba.newfaceshop.BarInformationModel;
import com.baidu.tieba.newfaceshop.facemake.FaceImageLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cr4;
import com.repackage.fd5;
import com.repackage.jo7;
import com.repackage.ko7;
import com.repackage.mi;
import com.repackage.oi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class FaceGroupMakeActivity extends BaseActivity implements jo7.c, BarInformationModel.b {
    public static /* synthetic */ Interceptable $ic;
    public static final int NO_FORUM_ID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isBarEmotion;
    public boolean isFromBazhu;
    public ImageView ivArrow;
    public Activity mActivity;
    public FaceData mAddIconData;
    public ArrayList<BazhuInfoData.BaInfo> mBarList;
    public LinearLayout mBazhuTitleLayout;
    public TextView mChooseBarTv;
    public BazhuInfoData.BaInfo mChoosedData;
    public ArrayList<FaceData> mChoosedImageList;
    public EditText mEditName;
    public jo7 mEmotionAdapter;
    public GridView mGridView;
    public FaceImageLayout mLayoutImage;
    public LinearLayout mLayoutRoot;
    public BarInformationModel mModel;
    public NavigationBar mNavigationBar;
    public NoNetworkView mNoNetView;
    public TextView mPublishTxtTv;
    public FaceGroupMakeTitleBar mTitleBar;
    public TextView mTvAddPicTip;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceGroupMakeActivity a;

        public a(FaceGroupMakeActivity faceGroupMakeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceGroupMakeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.onBack();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceGroupMakeActivity a;

        public b(FaceGroupMakeActivity faceGroupMakeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceGroupMakeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.mChoosedImageList == null) {
                return;
            }
            String trim = this.a.mEditName.getText().toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                if (this.a.mChoosedImageList.size() - 1 >= 8) {
                    if (this.a.mChoosedImageList.size() - 1 > 24) {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f05d1);
                        return;
                    } else if (mi.z()) {
                        if (this.a.isBarEmotion() && this.a.mChoosedData == null) {
                            this.a.showToast(R.string.obfuscated_res_0x7f0f08e0);
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(this.a.mChoosedImageList);
                        arrayList.remove(this.a.mAddIconData);
                        ko7.l().A(trim, arrayList, null, this.a.mChoosedData != null ? this.a.mChoosedData.forum_id : 0);
                        Intent intent = new Intent();
                        intent.putExtra("uploading", true);
                        this.a.setResult(-1, intent);
                        this.a.finish();
                        return;
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
                        return;
                    }
                }
                this.a.showToast(R.string.obfuscated_res_0x7f0f05dd);
                return;
            }
            this.a.showToast(R.string.obfuscated_res_0x7f0f05d3);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements FaceImageLayout.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceGroupMakeActivity a;

        public c(FaceGroupMakeActivity faceGroupMakeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceGroupMakeActivity;
        }

        @Override // com.baidu.tieba.newfaceshop.facemake.FaceImageLayout.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oi.w(this.a.mActivity, this.a.mEditName);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceGroupMakeActivity a;

        public d(FaceGroupMakeActivity faceGroupMakeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceGroupMakeActivity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mChooseBarTv.setMaxWidth(((this.a.mBazhuTitleLayout.getWidth() - this.a.mPublishTxtTv.getWidth()) - this.a.ivArrow.getWidth()) - oi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07029b));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceGroupMakeActivity a;

        public e(FaceGroupMakeActivity faceGroupMakeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceGroupMakeActivity;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
                ko7.l().i();
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements cr4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FaceGroupMakeActivity a;

        public f(FaceGroupMakeActivity faceGroupMakeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faceGroupMakeActivity;
        }

        @Override // com.repackage.cr4.e
        public void onClick(cr4 cr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cr4Var) == null) {
                cr4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ FaceGroupMakeActivity b;

        public g(FaceGroupMakeActivity faceGroupMakeActivity, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = faceGroupMakeActivity;
            this.a = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
                if (spanned == null || charSequence == null || (fd5.b(spanned.toString()) - (i4 - i3)) + fd5.b(charSequence.toString()) <= this.a) {
                    return charSequence;
                }
                this.b.showToast(R.string.obfuscated_res_0x7f0f0cf2);
                return "";
            }
            return (CharSequence) invokeCommon.objValue;
        }
    }

    public FaceGroupMakeActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isFromBazhu = false;
        this.isBarEmotion = false;
    }

    private void handleForumData(BazhuInfoData.BaInfo baInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, baInfo) == null) || baInfo == null || baInfo.forum_id <= 0 || TextUtils.isEmpty(baInfo.forum_name)) {
            return;
        }
        if (this.mChoosedData == null) {
            this.mChoosedData = new BazhuInfoData.BaInfo();
        }
        BazhuInfoData.BaInfo baInfo2 = this.mChoosedData;
        baInfo2.forum_id = baInfo.forum_id;
        String str = baInfo.forum_name;
        baInfo2.forum_name = str;
        this.mChooseBarTv.setText(str);
        if (ListUtils.isEmpty(this.mBarList)) {
            return;
        }
        Iterator<BazhuInfoData.BaInfo> it = this.mBarList.iterator();
        while (it.hasNext()) {
            BazhuInfoData.BaInfo next = it.next();
            if (baInfo.forum_id == next.forum_id) {
                next.isChecked = true;
            } else {
                next.isChecked = false;
            }
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            this.mLayoutRoot = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0911eb);
            this.mLayoutImage = (FaceImageLayout) findViewById(R.id.obfuscated_res_0x7f0911d6);
            this.mNavigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f091515);
            this.mTitleBar = new FaceGroupMakeTitleBar(this.mActivity);
            this.mTitleBar.setLayoutParams(new RelativeLayout.LayoutParams(oi.k(getPageContext().getPageActivity()), -1));
            this.mTitleBar.setCloseListener(new a(this));
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleBar, (View.OnClickListener) null);
            SkinManager.setBackgroundColor(this.mTitleBar, R.color.CAM_X0201);
            this.mNoNetView = (NoNetworkView) findViewById(R.id.obfuscated_res_0x7f0923ae);
            if (isBarEmotion()) {
                this.mTitleBar.setTitle(this.mActivity.getText(R.string.obfuscated_res_0x7f0f05d8).toString());
            } else {
                this.mTitleBar.setTitle(this.mActivity.getText(R.string.obfuscated_res_0x7f0f05d9).toString());
            }
            this.mTitleBar.setRightText(this.mActivity.getText(R.string.obfuscated_res_0x7f0f04e7).toString());
            this.mTitleBar.setRightListener(new b(this));
            EditText editText = (EditText) findViewById(R.id.obfuscated_res_0x7f09085c);
            this.mEditName = editText;
            editText.setFilters(new InputFilter[]{new g(this, 20)});
            this.mTvAddPicTip = (TextView) findViewById(R.id.obfuscated_res_0x7f092161);
            updateAddPicTip();
            this.mGridView = (GridView) findViewById(R.id.obfuscated_res_0x7f090cf7);
            jo7 jo7Var = new jo7(this.mChoosedImageList);
            this.mEmotionAdapter = jo7Var;
            jo7Var.f(this);
            this.mGridView.setAdapter((ListAdapter) this.mEmotionAdapter);
            this.mLayoutImage.setListener(new c(this));
            this.mBazhuTitleLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090327);
            this.mPublishTxtTv = (TextView) findViewById(R.id.obfuscated_res_0x7f0921e4);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f0921e3);
            this.mChooseBarTv = textView;
            textView.setOnClickListener(this);
            this.mBazhuTitleLayout.setVisibility(8);
            this.ivArrow = (ImageView) findViewById(R.id.obfuscated_res_0x7f090ff0);
            this.mBazhuTitleLayout.getViewTreeObserver().addOnGlobalLayoutListener(new d(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isBarEmotion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? this.isBarEmotion : invokeV.booleanValue;
    }

    private void loadBarData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (this.mModel == null) {
                this.mModel = new BarInformationModel(getPageContext());
            }
            this.mModel.y(this);
        }
    }

    private void loadDraft() {
        FaceGroupDraft k;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || (k = ko7.l().k()) == null) {
            return;
        }
        if (!TextUtils.isEmpty(k.getName())) {
            this.mEditName.setText(k.getName());
        }
        if (k.getList() == null || k.getList().isEmpty()) {
            return;
        }
        this.mChoosedImageList.addAll(k.getList());
        this.mEmotionAdapter.notifyDataSetChanged();
        updateAddPicTip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            ArrayList<FaceData> arrayList = this.mChoosedImageList;
            if ((arrayList != null && arrayList.size() > 1) || !TextUtils.isEmpty(this.mEditName.getText())) {
                cr4 cr4Var = new cr4(this.mActivity);
                cr4Var.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f05d7));
                cr4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f0421, new e(this));
                cr4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new f(this));
                cr4Var.create(getPageContext()).show();
                return;
            }
            finish();
        }
    }

    private void updateAddPicTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.mTvAddPicTip.setText(String.format(getText(R.string.obfuscated_res_0x7f0f05d2).toString(), Integer.valueOf(this.mChoosedImageList.size() - 1)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 4);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 4);
        }
    }

    public void getIntentData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.isFromBazhu = getIntent().getBooleanExtra(FaceGroupMakeActivityConfig.TYPE_MAKE_FOR_BAIZHU, false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Parcelable parcelableExtra;
        Serializable serializableExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 != -1) {
                return;
            }
            if (i == 25022) {
                if (intent == null || (serializableExtra = intent.getSerializableExtra(PickFaceTabActivityConfig.CHOOSED_LIST)) == null || !(serializableExtra instanceof List)) {
                    return;
                }
                this.mChoosedImageList.clear();
                this.mChoosedImageList.add(this.mAddIconData);
                this.mChoosedImageList.addAll((List) intent.getSerializableExtra(PickFaceTabActivityConfig.CHOOSED_LIST));
                this.mEmotionAdapter.notifyDataSetChanged();
                updateAddPicTip();
            } else if (i != 25025 || intent == null || (parcelableExtra = intent.getParcelableExtra(SelectSingleForumActivityConfig.KEY_OUTPUT_FORUM)) == null || !(parcelableExtra instanceof BazhuInfoData.BaInfo)) {
            } else {
                handleForumData((BazhuInfoData.BaInfo) parcelableExtra);
            }
        }
    }

    @Override // com.repackage.jo7.c
    public void onAdd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ArrayList<FaceData> arrayList = this.mChoosedImageList;
            if (arrayList != null && arrayList.size() - 1 >= 24) {
                showToast(R.string.obfuscated_res_0x7f0f05d1);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList<FaceData> arrayList3 = this.mChoosedImageList;
            if (arrayList3 != null) {
                arrayList2.addAll(arrayList3);
            }
            arrayList2.remove(this.mAddIconData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PickFaceTabActivityConfig(this.mActivity, 25022, arrayList2)));
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            onBack();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            getLayoutMode().k(i == 1);
            getLayoutMode().j(this.mLayoutRoot);
            SkinManager.setBackgroundResource(this.mLayoutRoot, R.color.CAM_X0201);
            this.mNoNetView.c(getPageContext(), i);
            SkinManager.setViewTextColor(this.mPublishTxtTv, (int) R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.mEditName, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.mTvAddPicTip, (int) R.color.CAM_X0109);
            if (i == 0) {
                this.mEditName.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
            } else {
                this.mEditName.setHintTextColor(getResources().getColor(R.color.CAM_X0110_1));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            super.onClick(view2);
            if (view2 != this.mChooseBarTv || ListUtils.isEmpty(this.mBarList)) {
                return;
            }
            SelectSingleForumActivityConfig selectSingleForumActivityConfig = new SelectSingleForumActivityConfig(getPageContext().getContext(), 25025);
            selectSingleForumActivityConfig.setForumList(this.mBarList);
            sendMessage(new CustomMessage(2002001, selectSingleForumActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        FaceGroupDraft k;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            getIntentData();
            this.mActivity = getPageContext().getPageActivity();
            setContentView(R.layout.obfuscated_res_0x7f0d028a);
            this.mChoosedImageList = new ArrayList<>();
            FaceData faceData = new FaceData();
            this.mAddIconData = faceData;
            faceData.type = 4;
            this.mChoosedImageList.add(faceData);
            if (this.isFromBazhu && ((k = ko7.l().k()) == null || k.getForumId() != 0)) {
                this.isBarEmotion = true;
            }
            initView();
            loadDraft();
            if (this.isBarEmotion) {
                loadBarData();
            }
        }
    }

    @Override // com.repackage.jo7.c
    public void onDel(FaceData faceData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, faceData) == null) || faceData == null) {
            return;
        }
        this.mChoosedImageList.remove(faceData);
        this.mEmotionAdapter.notifyDataSetChanged();
        updateAddPicTip();
    }

    @Override // com.baidu.tieba.newfaceshop.BarInformationModel.b
    public void success(BazhuInfoData bazhuInfoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bazhuInfoData) == null) {
            if (bazhuInfoData != null) {
                this.mBarList = bazhuInfoData.bazhu_info;
            }
            if (ListUtils.isEmpty(this.mBarList)) {
                return;
            }
            this.mBazhuTitleLayout.setVisibility(0);
            if (this.mBarList.size() == 1) {
                this.mChooseBarTv.setText(this.mBarList.get(0).forum_name);
                this.mChooseBarTv.setClickable(false);
                this.ivArrow.setVisibility(8);
                SkinManager.setViewTextColor(this.mChooseBarTv, (int) R.color.CAM_X0109);
                this.mChoosedData = this.mBarList.get(0);
                return;
            }
            this.mChooseBarTv.setClickable(true);
            this.mChooseBarTv.setText(R.string.obfuscated_res_0x7f0f05e1);
            SkinManager.setViewTextColor(this.mChooseBarTv, (int) R.color.CAM_X0304);
            FaceGroupDraft k = ko7.l().k();
            if (k == null || k.getForumId() == 0) {
                return;
            }
            Iterator<BazhuInfoData.BaInfo> it = this.mBarList.iterator();
            while (it.hasNext()) {
                BazhuInfoData.BaInfo next = it.next();
                if (next != null && next.forum_id == k.getForumId()) {
                    handleForumData(next);
                    return;
                }
            }
        }
    }
}
