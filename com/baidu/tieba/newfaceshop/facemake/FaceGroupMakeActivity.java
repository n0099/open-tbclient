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
import c.a.d.f.p.j;
import c.a.d.f.p.l;
import c.a.q0.d1.m0;
import c.a.q0.s.s.a;
import c.a.r0.l2.g.d;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class FaceGroupMakeActivity extends BaseActivity implements d.c, BarInformationModel.b {
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
    public c.a.r0.l2.g.d mEmotionAdapter;
    public GridView mGridView;
    public FaceImageLayout mLayoutImage;
    public LinearLayout mLayoutRoot;
    public BarInformationModel mModel;
    public NavigationBar mNavigationBar;
    public NoNetworkView mNoNetView;
    public TextView mPublishTxtTv;
    public FaceGroupMakeTitleBar mTitleBar;
    public TextView mTvAddPicTip;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceGroupMakeActivity f47233e;

        public a(FaceGroupMakeActivity faceGroupMakeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47233e = faceGroupMakeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f47233e.onBack();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceGroupMakeActivity f47234e;

        public b(FaceGroupMakeActivity faceGroupMakeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47234e = faceGroupMakeActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f47234e.mChoosedImageList == null) {
                return;
            }
            String trim = this.f47234e.mEditName.getText().toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                if (this.f47234e.mChoosedImageList.size() - 1 >= 8) {
                    if (this.f47234e.mChoosedImageList.size() - 1 > 24) {
                        this.f47234e.showToast(R.string.face_group_add_pic_max);
                        return;
                    } else if (j.z()) {
                        if (this.f47234e.isBarEmotion() && this.f47234e.mChoosedData == null) {
                            this.f47234e.showToast(R.string.input_one_bar);
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(this.f47234e.mChoosedImageList);
                        arrayList.remove(this.f47234e.mAddIconData);
                        c.a.r0.l2.g.e.l().A(trim, arrayList, null, this.f47234e.mChoosedData != null ? this.f47234e.mChoosedData.forum_id : 0);
                        Intent intent = new Intent();
                        intent.putExtra("uploading", true);
                        this.f47234e.setResult(-1, intent);
                        this.f47234e.finish();
                        return;
                    } else {
                        this.f47234e.showToast(R.string.neterror);
                        return;
                    }
                }
                this.f47234e.showToast(R.string.face_group_pic_less_tip);
                return;
            }
            this.f47234e.showToast(R.string.face_group_empty_name_tip);
        }
    }

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                l.w(this.a.mActivity, this.a.mEditName);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceGroupMakeActivity f47235e;

        public d(FaceGroupMakeActivity faceGroupMakeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47235e = faceGroupMakeActivity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47235e.mChooseBarTv.setMaxWidth(((this.f47235e.mBazhuTitleLayout.getWidth() - this.f47235e.mPublishTxtTv.getWidth()) - this.f47235e.ivArrow.getWidth()) - l.f(this.f47235e.getPageContext().getPageActivity(), R.dimen.ds3));
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceGroupMakeActivity f47236e;

        public e(FaceGroupMakeActivity faceGroupMakeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47236e = faceGroupMakeActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
                c.a.r0.l2.g.e.l().i();
                this.f47236e.finish();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FaceGroupMakeActivity f47237e;

        public f(FaceGroupMakeActivity faceGroupMakeActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47237e = faceGroupMakeActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class g implements InputFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f47238e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ FaceGroupMakeActivity f47239f;

        public g(FaceGroupMakeActivity faceGroupMakeActivity, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faceGroupMakeActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47239f = faceGroupMakeActivity;
            this.f47238e = i2;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{charSequence, Integer.valueOf(i2), Integer.valueOf(i3), spanned, Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
                if (spanned == null || charSequence == null || (m0.b(spanned.toString()) - (i5 - i4)) + m0.b(charSequence.toString()) <= this.f47238e) {
                    return charSequence;
                }
                this.f47239f.showToast(R.string.package_add_name_max);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            this.mLayoutRoot = (LinearLayout) findViewById(R.id.layout_root);
            this.mLayoutImage = (FaceImageLayout) findViewById(R.id.layout_image);
            this.mNavigationBar = (NavigationBar) findViewById(R.id.navigation_bar);
            this.mTitleBar = new FaceGroupMakeTitleBar(this.mActivity);
            this.mTitleBar.setLayoutParams(new RelativeLayout.LayoutParams(l.k(getPageContext().getPageActivity()), -1));
            this.mTitleBar.setCloseListener(new a(this));
            this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mTitleBar, (View.OnClickListener) null);
            SkinManager.setBackgroundColor(this.mTitleBar, R.color.CAM_X0201);
            this.mNoNetView = (NoNetworkView) findViewById(R.id.view_no_network);
            if (isBarEmotion()) {
                this.mTitleBar.setTitle(this.mActivity.getText(R.string.face_group_make_for_bazhu).toString());
            } else {
                this.mTitleBar.setTitle(this.mActivity.getText(R.string.face_group_make_new).toString());
            }
            this.mTitleBar.setRightText(this.mActivity.getText(R.string.done).toString());
            this.mTitleBar.setRightListener(new b(this));
            EditText editText = (EditText) findViewById(R.id.edit_name);
            this.mEditName = editText;
            editText.setFilters(new InputFilter[]{new g(this, 20)});
            this.mTvAddPicTip = (TextView) findViewById(R.id.tv_add_pic_tip);
            updateAddPicTip();
            this.mGridView = (GridView) findViewById(R.id.grid_view);
            c.a.r0.l2.g.d dVar = new c.a.r0.l2.g.d(this.mChoosedImageList);
            this.mEmotionAdapter = dVar;
            dVar.f(this);
            this.mGridView.setAdapter((ListAdapter) this.mEmotionAdapter);
            this.mLayoutImage.setListener(new c(this));
            this.mBazhuTitleLayout = (LinearLayout) findViewById(R.id.bar_name_layout);
            this.mPublishTxtTv = (TextView) findViewById(R.id.tv_publish_to);
            TextView textView = (TextView) findViewById(R.id.tv_publish_bar_name);
            this.mChooseBarTv = textView;
            textView.setOnClickListener(this);
            this.mBazhuTitleLayout.setVisibility(8);
            this.ivArrow = (ImageView) findViewById(R.id.iv_right_arrow);
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
            this.mModel.w(this);
        }
    }

    private void loadDraft() {
        FaceGroupDraft k2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || (k2 = c.a.r0.l2.g.e.l().k()) == null) {
            return;
        }
        if (!TextUtils.isEmpty(k2.getName())) {
            this.mEditName.setText(k2.getName());
        }
        if (k2.getList() == null || k2.getList().isEmpty()) {
            return;
        }
        this.mChoosedImageList.addAll(k2.getList());
        this.mEmotionAdapter.notifyDataSetChanged();
        updateAddPicTip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBack() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            ArrayList<FaceData> arrayList = this.mChoosedImageList;
            if ((arrayList != null && arrayList.size() > 1) || !TextUtils.isEmpty(this.mEditName.getText())) {
                c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(this.mActivity);
                aVar.setMessage(getResources().getString(R.string.face_group_make_back_tip));
                aVar.setPositiveButton(R.string.confirm, new e(this));
                aVar.setNegativeButton(R.string.cancel, new f(this));
                aVar.create(getPageContext()).show();
                return;
            }
            finish();
        }
    }

    private void updateAddPicTip() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            this.mTvAddPicTip.setText(String.format(getText(R.string.face_group_add_pic_tip).toString(), Integer.valueOf(this.mChoosedImageList.size() - 1)));
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
    public void onActivityResult(int i2, int i3, Intent intent) {
        Parcelable parcelableExtra;
        Serializable serializableExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048579, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 != -1) {
                return;
            }
            if (i2 == 25022) {
                if (intent == null || (serializableExtra = intent.getSerializableExtra(PickFaceTabActivityConfig.CHOOSED_LIST)) == null || !(serializableExtra instanceof List)) {
                    return;
                }
                this.mChoosedImageList.clear();
                this.mChoosedImageList.add(this.mAddIconData);
                this.mChoosedImageList.addAll((List) intent.getSerializableExtra(PickFaceTabActivityConfig.CHOOSED_LIST));
                this.mEmotionAdapter.notifyDataSetChanged();
                updateAddPicTip();
            } else if (i2 != 25025 || intent == null || (parcelableExtra = intent.getParcelableExtra(SelectSingleForumActivityConfig.KEY_OUTPUT_FORUM)) == null || !(parcelableExtra instanceof BazhuInfoData.BaInfo)) {
            } else {
                handleForumData((BazhuInfoData.BaInfo) parcelableExtra);
            }
        }
    }

    @Override // c.a.r0.l2.g.d.c
    public void onAdd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ArrayList<FaceData> arrayList = this.mChoosedImageList;
            if (arrayList != null && arrayList.size() - 1 >= 24) {
                showToast(R.string.face_group_add_pic_max);
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
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i2);
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.mLayoutRoot);
            SkinManager.setBackgroundResource(this.mLayoutRoot, R.color.CAM_X0201);
            this.mNoNetView.onChangeSkinType(getPageContext(), i2);
            SkinManager.setViewTextColor(this.mPublishTxtTv, R.color.CAM_X0106);
            SkinManager.setViewTextColor(this.mEditName, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.mTvAddPicTip, R.color.CAM_X0109);
            if (i2 == 0) {
                this.mEditName.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
            } else {
                this.mEditName.setHintTextColor(getResources().getColor(R.color.CAM_X0110_1));
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view) == null) {
            super.onClick(view);
            if (view != this.mChooseBarTv || ListUtils.isEmpty(this.mBarList)) {
                return;
            }
            SelectSingleForumActivityConfig selectSingleForumActivityConfig = new SelectSingleForumActivityConfig(getPageContext().getContext(), 25025);
            selectSingleForumActivityConfig.setForumList(this.mBarList);
            sendMessage(new CustomMessage(2002001, selectSingleForumActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        FaceGroupDraft k2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onCreate(bundle);
            setSwipeBackEnabled(false);
            getIntentData();
            this.mActivity = getPageContext().getPageActivity();
            setContentView(R.layout.face_group_make_activity);
            this.mChoosedImageList = new ArrayList<>();
            FaceData faceData = new FaceData();
            this.mAddIconData = faceData;
            faceData.type = 4;
            this.mChoosedImageList.add(faceData);
            if (this.isFromBazhu && ((k2 = c.a.r0.l2.g.e.l().k()) == null || k2.getForumId() != 0)) {
                this.isBarEmotion = true;
            }
            initView();
            loadDraft();
            if (this.isBarEmotion) {
                loadBarData();
            }
        }
    }

    @Override // c.a.r0.l2.g.d.c
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
                SkinManager.setViewTextColor(this.mChooseBarTv, R.color.CAM_X0109);
                this.mChoosedData = this.mBarList.get(0);
                return;
            }
            this.mChooseBarTv.setClickable(true);
            this.mChooseBarTv.setText(R.string.face_make_choose_forum);
            SkinManager.setViewTextColor(this.mChooseBarTv, R.color.CAM_X0304);
            FaceGroupDraft k2 = c.a.r0.l2.g.e.l().k();
            if (k2 == null || k2.getForumId() == 0) {
                return;
            }
            Iterator<BazhuInfoData.BaInfo> it = this.mBarList.iterator();
            while (it.hasNext()) {
                BazhuInfoData.BaInfo next = it.next();
                if (next != null && next.forum_id == k2.getForumId()) {
                    handleForumData(next);
                    return;
                }
            }
        }
    }
}
