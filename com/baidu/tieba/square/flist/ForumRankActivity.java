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
import com.baidu.tieba.bv4;
import com.baidu.tieba.c9;
import com.baidu.tieba.cv4;
import com.baidu.tieba.ei8;
import com.baidu.tieba.ri;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ForumRankActivity extends BaseActivity<ForumRankActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;
    public ForumRankModel b;
    public ei8 c;
    public NavigationBar d;
    public TbImageView e;
    public LikeModel f;
    public LinearLayout g;
    public cv4 h;
    public FrameLayout i;
    public String j;
    public boolean k;
    public final c9 l;
    public final ImageProvider m;

    /* loaded from: classes5.dex */
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
                this.a.a.removeFooterView(this.a.g);
                this.a.c.e(100);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements bv4.g {
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

        @Override // com.baidu.tieba.bv4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.b.loadData()) {
                return;
            }
            this.a.a.A(0L);
        }
    }

    /* loaded from: classes5.dex */
    public class c extends c9 {
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

        @Override // com.baidu.tieba.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.hideProgressBar();
                this.a.a.A(0L);
                if (obj == null || !(obj instanceof ForumRankData)) {
                    this.a.a.setVisibility(8);
                    ForumRankActivity forumRankActivity = this.a;
                    forumRankActivity.showNetRefreshView(forumRankActivity.findViewById(R.id.obfuscated_res_0x7f091c33), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fb0), true);
                    this.a.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c40);
                    return;
                }
                ForumRankData forumRankData = (ForumRankData) obj;
                if (forumRankData.error_code == 0) {
                    this.a.a.setVisibility(0);
                    String str = forumRankData.pic_url;
                    if (str != null && str.length() > 0) {
                        if (this.a.k) {
                            this.a.a.addHeaderView(this.a.e, this.a.m, false);
                            this.a.k = false;
                        }
                        this.a.e.setVisibility(0);
                        this.a.e.setTag(forumRankData.pic_url);
                        ViewGroup.LayoutParams layoutParams = this.a.e.getLayoutParams();
                        layoutParams.width = -1;
                        layoutParams.height = (int) ((ri.k(this.a.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                        this.a.j = forumRankData.pic_url;
                    }
                    this.a.c.f(forumRankData.forumsquare_list);
                    this.a.c.h(Boolean.valueOf(forumRankData.is_order != 0));
                    this.a.d.setTitleText(forumRankData.title);
                    ForumInfoData[] forumInfoDataArr = forumRankData.forumsquare_list;
                    if (forumInfoDataArr != null && forumInfoDataArr.length > 100 && this.a.a.getAdapter2().l() <= 0) {
                        this.a.a.addFooterView(this.a.g);
                    }
                    ForumInfoData[] forumInfoDataArr2 = forumRankData.forumsquare_list;
                    if (forumInfoDataArr2 == null || forumInfoDataArr2.length == 0) {
                        this.a.i.setVisibility(0);
                        return;
                    } else {
                        this.a.i.setVisibility(8);
                        return;
                    }
                }
                this.a.a.setVisibility(8);
                ForumRankActivity forumRankActivity2 = this.a;
                forumRankActivity2.showNetRefreshView(forumRankActivity2.findViewById(R.id.obfuscated_res_0x7f091c33), this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0fb0), true);
                this.a.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                NewErrorData newErrorData = forumRankData.error;
                if (newErrorData != null) {
                    this.a.showToast(newErrorData.usermsg);
                } else {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c40);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                if (this.a.j != null) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(this.a.j);
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
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = false;
        this.l = new c(this);
        this.m = new d(this);
    }

    public final void N1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            if (bundle != null) {
                this.b = new ForumRankModel(bundle);
            } else {
                this.b = new ForumRankModel(getIntent());
            }
            this.k = true;
            this.b.setLoadDataCallBack(this.l);
            ei8 ei8Var = new ei8(getPageContext(), 0);
            this.c = ei8Var;
            ei8Var.e(100);
            this.c.h(Boolean.TRUE);
            this.c.g(ForumDetailActivityConfig.FromType.BAR_RANK);
            this.a.setAdapter((ListAdapter) this.c);
            if (this.b.loadData()) {
                this.c.e(100);
                showProgressBar();
            }
            LikeModel likeModel = new LikeModel(getPageContext());
            this.f = likeModel;
            this.c.j(likeModel);
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d02b8);
            TbImageView tbImageView = new TbImageView(getPageContext().getPageActivity());
            this.e = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f092566);
            this.d = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d.setTitleText("");
            this.a = (BdListView) findViewById(R.id.obfuscated_res_0x7f09130a);
            this.e.setLayoutParams(new AbsListView.LayoutParams(ri.k(getPageContext().getPageActivity()), (int) (ri.k(getPageContext().getPageActivity()) * 0.5d)));
            this.e.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02b1, (ViewGroup) null);
            this.g = linearLayout;
            linearLayout.setOnClickListener(new a(this));
            cv4 cv4Var = new cv4(getPageContext());
            this.h = cv4Var;
            this.a.setPullRefresh(cv4Var);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + ri.f(getActivity(), R.dimen.obfuscated_res_0x7f070282)));
            this.a.x(textView, 0);
            this.h.f(new b(this));
            this.i = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0908cf);
        }
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ForumInfoData[] a2 = this.c.a();
            for (int i = 0; i < a2.length; i++) {
                int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(a2[i].forum_name);
                if (hasLikeForum == 1) {
                    a2[i].is_like = 1;
                } else if (hasLikeForum == -1) {
                    a2[i].is_like = 0;
                }
            }
            this.c.f(a2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.d.onChangeSkinType(getPageContext(), i);
            if (i != 1 && i != 4) {
                this.a.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
                this.c.d(false);
            } else {
                this.a.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
                this.c.d(true);
            }
            SkinManager.setFrsPBBgColor(findViewById(R.id.obfuscated_res_0x7f091c33), i);
            this.h.H(i);
            this.c.i(R.drawable.btn_add_end, R.drawable.btn_add);
            SkinManager.setBackgroundResource(this.g, R.drawable.bg_black_banner_down);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            O1();
            N1(bundle);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        ForumRankModel forumRankModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (forumRankModel = this.b) == null) {
            return;
        }
        forumRankModel.loadData();
        hideNetRefreshView(findViewById(R.id.obfuscated_res_0x7f091c33));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            P1();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.b.G(bundle);
        }
    }
}
