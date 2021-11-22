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
import b.a.e.a.e;
import b.a.e.f.p.l;
import b.a.q0.s.g0.f;
import b.a.q0.s.g0.g;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ProxyAdkBaseActivity;
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
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class ForumRankActivity extends ProxyAdkBaseActivity<ForumRankActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f54980e;

    /* renamed from: f  reason: collision with root package name */
    public ForumRankModel f54981f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.r0.j3.h.b f54982g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f54983h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f54984i;
    public LikeModel j;
    public LinearLayout k;
    public g l;
    public FrameLayout m;
    public String n;
    public boolean o;
    public final e p;
    public final ImageProvider q;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumRankActivity f54985e;

        public a(ForumRankActivity forumRankActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRankActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54985e = forumRankActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f54985e.f54980e.removeFooterView(this.f54985e.k);
                this.f54985e.f54982g.e(100);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumRankActivity f54986e;

        public b(ForumRankActivity forumRankActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRankActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54986e = forumRankActivity;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f54986e.f54981f.loadData()) {
                return;
            }
            this.f54986e.f54980e.completePullRefreshPostDelayed(0L);
        }
    }

    /* loaded from: classes9.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumRankActivity f54987a;

        public c(ForumRankActivity forumRankActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRankActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54987a = forumRankActivity;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.f54987a.hideProgressBar();
                this.f54987a.f54980e.completePullRefreshPostDelayed(0L);
                if (obj == null || !(obj instanceof ForumRankData)) {
                    this.f54987a.f54980e.setVisibility(8);
                    ForumRankActivity forumRankActivity = this.f54987a;
                    forumRankActivity.showNetRefreshView(forumRankActivity.findViewById(R.id.root_view), this.f54987a.getResources().getString(R.string.recommend_pb_no_net_text), true);
                    this.f54987a.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                    this.f54987a.showToast(R.string.neterror);
                    return;
                }
                ForumRankData forumRankData = (ForumRankData) obj;
                if (forumRankData.error_code == 0) {
                    this.f54987a.f54980e.setVisibility(0);
                    String str = forumRankData.pic_url;
                    if (str != null && str.length() > 0) {
                        if (this.f54987a.o) {
                            this.f54987a.f54980e.addHeaderView(this.f54987a.f54984i, this.f54987a.q, false);
                            this.f54987a.o = false;
                        }
                        this.f54987a.f54984i.setVisibility(0);
                        this.f54987a.f54984i.setTag(forumRankData.pic_url);
                        ViewGroup.LayoutParams layoutParams = this.f54987a.f54984i.getLayoutParams();
                        layoutParams.width = -1;
                        layoutParams.height = (int) ((l.k(this.f54987a.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                        this.f54987a.n = forumRankData.pic_url;
                    }
                    this.f54987a.f54982g.f(forumRankData.forumsquare_list);
                    this.f54987a.f54982g.h(Boolean.valueOf(forumRankData.is_order != 0));
                    this.f54987a.f54983h.setTitleText(forumRankData.title);
                    ForumInfoData[] forumInfoDataArr = forumRankData.forumsquare_list;
                    if (forumInfoDataArr != null && forumInfoDataArr.length > 100 && this.f54987a.f54980e.getAdapter2().j() <= 0) {
                        this.f54987a.f54980e.addFooterView(this.f54987a.k);
                    }
                    ForumInfoData[] forumInfoDataArr2 = forumRankData.forumsquare_list;
                    if (forumInfoDataArr2 == null || forumInfoDataArr2.length == 0) {
                        this.f54987a.m.setVisibility(0);
                        return;
                    } else {
                        this.f54987a.m.setVisibility(8);
                        return;
                    }
                }
                this.f54987a.f54980e.setVisibility(8);
                ForumRankActivity forumRankActivity2 = this.f54987a;
                forumRankActivity2.showNetRefreshView(forumRankActivity2.findViewById(R.id.root_view), this.f54987a.getResources().getString(R.string.recommend_pb_no_net_text), true);
                this.f54987a.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                NewErrorData newErrorData = forumRankData.error;
                if (newErrorData != null) {
                    this.f54987a.showToast(newErrorData.usermsg);
                } else {
                    this.f54987a.showToast(R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends AbstractImageProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumRankActivity f54988e;

        public d(ForumRankActivity forumRankActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRankActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f54988e = forumRankActivity;
        }

        @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
        public ArrayList<String> getImageUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f54988e.n != null) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(this.f54988e.n);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54980e = null;
        this.f54981f = null;
        this.f54982g = null;
        this.f54983h = null;
        this.f54984i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = false;
        this.p = new c(this);
        this.q = new d(this);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f54983h.onChangeSkinType(getPageContext(), i2);
            if (i2 != 1 && i2 != 4) {
                this.f54980e.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
                this.f54982g.d(false);
            } else {
                this.f54980e.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
                this.f54982g.d(true);
            }
            SkinManager.setFrsPBBgColor(findViewById(R.id.root_view), i2);
            this.l.C(i2);
            this.f54982g.i(R.drawable.btn_add_end, R.drawable.btn_add);
            SkinManager.setBackgroundResource(this.k, R.drawable.bg_black_banner_down);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            u();
            t(bundle);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onNetRefreshButtonClicked() {
        ForumRankModel forumRankModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (forumRankModel = this.f54981f) == null) {
            return;
        }
        forumRankModel.loadData();
        hideNetRefreshView(findViewById(R.id.root_view));
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
            v();
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.f54981f.D(bundle);
        }
    }

    public final void t(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            if (bundle != null) {
                this.f54981f = new ForumRankModel(bundle);
            } else {
                this.f54981f = new ForumRankModel(getIntent());
            }
            this.o = true;
            this.f54981f.setLoadDataCallBack(this.p);
            b.a.r0.j3.h.b bVar = new b.a.r0.j3.h.b(getPageContext(), 0);
            this.f54982g = bVar;
            bVar.e(100);
            this.f54982g.h(Boolean.TRUE);
            this.f54982g.g(ForumDetailActivityConfig.FromType.BAR_RANK);
            this.f54980e.setAdapter((ListAdapter) this.f54982g);
            if (this.f54981f.loadData()) {
                this.f54982g.e(100);
                showProgressBar();
            }
            LikeModel likeModel = new LikeModel(getPageContext());
            this.j = likeModel;
            this.f54982g.j(likeModel);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setContentView(R.layout.forum_rank_activity);
            TbImageView tbImageView = new TbImageView(getPageContext().getPageActivity());
            this.f54984i = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.f54983h = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f54983h.setTitleText("");
            this.f54980e = (BdListView) findViewById(R.id.list);
            this.f54984i.setLayoutParams(new AbsListView.LayoutParams(l.k(getPageContext().getPageActivity()), (int) (l.k(getPageContext().getPageActivity()) * 0.5d)));
            this.f54984i.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
            this.k = linearLayout;
            linearLayout.setOnClickListener(new a(this));
            g gVar = new g(getPageContext());
            this.l = gVar;
            this.f54980e.setPullRefresh(gVar);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds98)));
            this.f54980e.addHeaderView(textView, 0);
            this.l.a(new b(this));
            this.m = (FrameLayout) findViewById(R.id.empty_textview_container);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ForumInfoData[] a2 = this.f54982g.a();
            for (int i2 = 0; i2 < a2.length; i2++) {
                int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(a2[i2].forum_name);
                if (hasLikeForum == 1) {
                    a2[i2].is_like = 1;
                } else if (hasLikeForum == -1) {
                    a2[i2].is_like = 0;
                }
            }
            this.f54982g.f(a2);
        }
    }
}
