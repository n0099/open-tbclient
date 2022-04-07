package com.baidu.tieba.square.flist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.data.NewErrorData;
import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tbadk.core.util.ImageProvider;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a9;
import com.repackage.du4;
import com.repackage.eu4;
import com.repackage.fh8;
import com.repackage.oi;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ForumRankActivity extends BaseActivity<ForumRankActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FORUM_MAX_NUM = 100;
    public static final int FORUM_NUM = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public fh8 mAdapter;
    public final a9 mCallback;
    public final ImageProvider mHeadImageProvider;
    public TbImageView mImage;
    public String mImageUrl;
    public boolean mIsFirst;
    public LikeModel mLikeModel;
    public BdListView mListView;
    public ForumRankModel mModel;
    public NavigationBar mNavigationBar;
    public FrameLayout mNoDataView;
    public eu4 mPullView;
    public LinearLayout mRecommendListFooter;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumRankActivity a;

        public a(ForumRankActivity forumRankActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRankActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumRankActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.mListView.removeFooterView(this.a.mRecommendListFooter);
                this.a.mAdapter.e(100);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements du4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumRankActivity a;

        public b(ForumRankActivity forumRankActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRankActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumRankActivity;
        }

        @Override // com.repackage.du4.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.mModel.loadData()) {
                return;
            }
            this.a.mListView.A(0L);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumRankActivity a;

        public c(ForumRankActivity forumRankActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRankActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumRankActivity;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.hideProgressBar();
                this.a.mListView.A(0L);
                if (obj == null || !(obj instanceof ForumRankData)) {
                    this.a.mListView.setVisibility(8);
                    ForumRankActivity forumRankActivity = this.a;
                    forumRankActivity.showNetRefreshView(forumRankActivity.findViewById(R.id.obfuscated_res_0x7f091add), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f5c), true);
                    this.a.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                    return;
                }
                ForumRankData forumRankData = (ForumRankData) obj;
                if (forumRankData.error_code == 0) {
                    this.a.mListView.setVisibility(0);
                    String str = forumRankData.pic_url;
                    if (str != null && str.length() > 0) {
                        if (this.a.mIsFirst) {
                            this.a.mListView.addHeaderView(this.a.mImage, this.a.mHeadImageProvider, false);
                            this.a.mIsFirst = false;
                        }
                        this.a.mImage.setVisibility(0);
                        this.a.mImage.setTag(forumRankData.pic_url);
                        ViewGroup.LayoutParams layoutParams = this.a.mImage.getLayoutParams();
                        layoutParams.width = -1;
                        layoutParams.height = (int) ((oi.k(this.a.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                        this.a.mImageUrl = forumRankData.pic_url;
                    }
                    this.a.mAdapter.f(forumRankData.forumsquare_list);
                    this.a.mAdapter.h(Boolean.valueOf(forumRankData.is_order != 0));
                    this.a.mNavigationBar.setTitleText(forumRankData.title);
                    ForumInfoData[] forumInfoDataArr = forumRankData.forumsquare_list;
                    if (forumInfoDataArr != null && forumInfoDataArr.length > 100 && this.a.mListView.getAdapter2().l() <= 0) {
                        this.a.mListView.addFooterView(this.a.mRecommendListFooter);
                    }
                    ForumInfoData[] forumInfoDataArr2 = forumRankData.forumsquare_list;
                    if (forumInfoDataArr2 == null || forumInfoDataArr2.length == 0) {
                        this.a.mNoDataView.setVisibility(0);
                        return;
                    } else {
                        this.a.mNoDataView.setVisibility(8);
                        return;
                    }
                }
                this.a.mListView.setVisibility(8);
                ForumRankActivity forumRankActivity2 = this.a;
                forumRankActivity2.showNetRefreshView(forumRankActivity2.findViewById(R.id.obfuscated_res_0x7f091add), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0f5c), true);
                this.a.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                NewErrorData newErrorData = forumRankData.error;
                if (newErrorData != null) {
                    this.a.showToast(newErrorData.usermsg);
                } else {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c18);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends AbstractImageProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumRankActivity a;

        public d(ForumRankActivity forumRankActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRankActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumRankActivity;
        }

        @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
        public ArrayList<String> getImageUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.mImageUrl != null) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(this.a.mImageUrl);
                    return arrayList;
                }
                return null;
            }
            return (ArrayList) invokeV.objValue;
        }
    }

    public ForumRankActivity() {
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
        this.mListView = null;
        this.mModel = null;
        this.mAdapter = null;
        this.mNavigationBar = null;
        this.mImage = null;
        this.mLikeModel = null;
        this.mRecommendListFooter = null;
        this.mPullView = null;
        this.mNoDataView = null;
        this.mImageUrl = null;
        this.mIsFirst = false;
        this.mCallback = new c(this);
        this.mHeadImageProvider = new d(this);
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, bundle) == null) {
            if (bundle != null) {
                this.mModel = new ForumRankModel(bundle);
            } else {
                this.mModel = new ForumRankModel(getIntent());
            }
            this.mIsFirst = true;
            this.mModel.setLoadDataCallBack(this.mCallback);
            fh8 fh8Var = new fh8(getPageContext(), 0);
            this.mAdapter = fh8Var;
            fh8Var.e(100);
            this.mAdapter.h(Boolean.TRUE);
            this.mAdapter.g(ForumDetailActivityConfig.FromType.BAR_RANK);
            this.mListView.setAdapter((ListAdapter) this.mAdapter);
            if (this.mModel.loadData()) {
                this.mAdapter.e(100);
                showProgressBar();
            }
            LikeModel likeModel = new LikeModel(getPageContext());
            this.mLikeModel = likeModel;
            this.mAdapter.j(likeModel);
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d02c3);
            TbImageView tbImageView = new TbImageView(getPageContext().getPageActivity());
            this.mImage = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923ab);
            this.mNavigationBar = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.mNavigationBar.setTitleText("");
            this.mListView = (BdListView) findViewById(R.id.obfuscated_res_0x7f09126c);
            this.mImage.setLayoutParams(new AbsListView.LayoutParams(oi.k(getPageContext().getPageActivity()), (int) (oi.k(getPageContext().getPageActivity()) * 0.5d)));
            this.mImage.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02bc, (ViewGroup) null);
            this.mRecommendListFooter = linearLayout;
            linearLayout.setOnClickListener(new a(this));
            eu4 eu4Var = new eu4(getPageContext());
            this.mPullView = eu4Var;
            this.mListView.setPullRefresh(eu4Var);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + oi.f(getActivity(), R.dimen.obfuscated_res_0x7f070282)));
            this.mListView.x(textView, 0);
            this.mPullView.f(new b(this));
            this.mNoDataView = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0908c8);
        }
    }

    private void updateLike() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            ForumInfoData[] a2 = this.mAdapter.a();
            for (int i = 0; i < a2.length; i++) {
                int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(a2[i].forum_name);
                if (hasLikeForum == 1) {
                    a2[i].is_like = 1;
                } else if (hasLikeForum == -1) {
                    a2[i].is_like = 0;
                }
            }
            this.mAdapter.f(a2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            if (i != 1 && i != 4) {
                this.mListView.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
                this.mAdapter.d(false);
            } else {
                this.mListView.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
                this.mAdapter.d(true);
            }
            SkinManager.setFrsPBBgColor(findViewById(R.id.obfuscated_res_0x7f091add), i);
            this.mPullView.H(i);
            this.mAdapter.i(R.drawable.btn_add_end, R.drawable.btn_add);
            SkinManager.setBackgroundResource(this.mRecommendListFooter, R.drawable.bg_black_banner_down);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            initUI();
            initData(bundle);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        ForumRankModel forumRankModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (forumRankModel = this.mModel) == null) {
            return;
        }
        forumRankModel.loadData();
        hideNetRefreshView(findViewById(R.id.obfuscated_res_0x7f091add));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
            updateLike();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.mModel.F(bundle);
        }
    }
}
