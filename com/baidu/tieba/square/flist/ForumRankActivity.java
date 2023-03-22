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
import com.baidu.tieba.c99;
import com.baidu.tieba.hi;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.v35;
import com.baidu.tieba.w35;
import com.baidu.tieba.z8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ForumRankActivity extends BaseActivity<ForumRankActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdListView a;
    public ForumRankModel b;
    public c99 c;
    public NavigationBar d;
    public TbImageView e;
    public LikeModel f;
    public LinearLayout g;
    public w35 h;
    public FrameLayout i;
    public String j;
    public boolean k;
    public final z8 l;
    public final ImageProvider m;

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class b implements v35.g {
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

        @Override // com.baidu.tieba.v35.g
        public void f(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && !this.a.b.loadData()) {
                this.a.a.z(0L);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends z8 {
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

        @Override // com.baidu.tieba.z8
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.hideProgressBar();
                this.a.a.z(0L);
                boolean z = true;
                if (obj != null && (obj instanceof ForumRankData)) {
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
                            layoutParams.height = (int) ((hi.l(this.a.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                            this.a.j = forumRankData.pic_url;
                        }
                        this.a.c.f(forumRankData.forumsquare_list);
                        c99 c99Var = this.a.c;
                        if (forumRankData.is_order == 0) {
                            z = false;
                        }
                        c99Var.h(Boolean.valueOf(z));
                        this.a.d.setTitleText(forumRankData.title);
                        ForumInfoData[] forumInfoDataArr = forumRankData.forumsquare_list;
                        if (forumInfoDataArr != null && forumInfoDataArr.length > 100 && this.a.a.getAdapter2().l() <= 0) {
                            this.a.a.addFooterView(this.a.g);
                        }
                        ForumInfoData[] forumInfoDataArr2 = forumRankData.forumsquare_list;
                        if (forumInfoDataArr2 != null && forumInfoDataArr2.length != 0) {
                            this.a.i.setVisibility(8);
                            return;
                        } else {
                            this.a.i.setVisibility(0);
                            return;
                        }
                    }
                    this.a.a.setVisibility(8);
                    ForumRankActivity forumRankActivity = this.a;
                    forumRankActivity.showNetRefreshView(forumRankActivity.findViewById(R.id.obfuscated_res_0x7f091e45), this.a.getResources().getString(R.string.recommend_pb_no_net_text), true);
                    this.a.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                    NewErrorData newErrorData = forumRankData.error;
                    if (newErrorData != null) {
                        this.a.showToast(newErrorData.usermsg);
                        return;
                    } else {
                        this.a.showToast(R.string.obfuscated_res_0x7f0f0d1f);
                        return;
                    }
                }
                this.a.a.setVisibility(8);
                ForumRankActivity forumRankActivity2 = this.a;
                forumRankActivity2.showNetRefreshView(forumRankActivity2.findViewById(R.id.obfuscated_res_0x7f091e45), this.a.getResources().getString(R.string.recommend_pb_no_net_text), true);
                this.a.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                this.a.showToast(R.string.obfuscated_res_0x7f0f0d1f);
            }
        }
    }

    /* loaded from: classes6.dex */
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
        this.k = false;
        this.l = new c(this);
        this.m = new d(this);
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onCreate(bundle);
            O1();
            N1(bundle);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.b.Y(bundle);
        }
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
            c99 c99Var = new c99(getPageContext(), 0);
            this.c = c99Var;
            c99Var.e(100);
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

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.d.onChangeSkinType(getPageContext(), i);
            if (i == 4) {
                this.a.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
                this.c.d(true);
            } else {
                this.a.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
                this.c.d(false);
            }
            SkinManager.setFrsPBBgColor(findViewById(R.id.obfuscated_res_0x7f091e45), i);
            this.h.H(i);
            this.c.i(R.drawable.btn_add_end, R.drawable.btn_add);
            SkinManager.setBackgroundResource(this.g, R.drawable.bg_black_banner_down);
        }
    }

    public final void O1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d02d7);
            TbImageView tbImageView = new TbImageView(getPageContext().getPageActivity());
            this.e = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.d = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d.setTitleText("");
            this.a = (BdListView) findViewById(R.id.obfuscated_res_0x7f091490);
            this.e.setLayoutParams(new AbsListView.LayoutParams(hi.l(getPageContext().getPageActivity()), (int) (hi.l(getPageContext().getPageActivity()) * 0.5d)));
            this.e.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
            this.g = linearLayout;
            linearLayout.setOnClickListener(new a(this));
            w35 w35Var = new w35(getPageContext());
            this.h = w35Var;
            this.a.setPullRefresh(w35Var);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + hi.g(getActivity(), R.dimen.obfuscated_res_0x7f070282)));
            this.a.w(textView, 0);
            this.h.f(new b(this));
            this.i = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f0909a0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        ForumRankModel forumRankModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (forumRankModel = this.b) != null) {
            forumRankModel.loadData();
            hideNetRefreshView(findViewById(R.id.obfuscated_res_0x7f091e45));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onResume();
            P1();
        }
    }
}
