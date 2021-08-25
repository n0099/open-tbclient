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
import c.a.e.a.e;
import c.a.e.e.p.l;
import c.a.p0.s.f0.f;
import c.a.p0.s.f0.g;
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
/* loaded from: classes7.dex */
public class ForumRankActivity extends ProxyAdkBaseActivity<ForumRankActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f56758e;

    /* renamed from: f  reason: collision with root package name */
    public ForumRankModel f56759f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.q0.f3.h.b f56760g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f56761h;

    /* renamed from: i  reason: collision with root package name */
    public TbImageView f56762i;

    /* renamed from: j  reason: collision with root package name */
    public LikeModel f56763j;
    public LinearLayout k;
    public g l;
    public FrameLayout m;
    public String n;
    public boolean o;
    public final e p;
    public final ImageProvider q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumRankActivity f56764e;

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
            this.f56764e = forumRankActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f56764e.f56758e.removeFooterView(this.f56764e.k);
                this.f56764e.f56760g.e(100);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumRankActivity f56765e;

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
            this.f56765e = forumRankActivity;
        }

        @Override // c.a.p0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f56765e.f56759f.LoadData()) {
                return;
            }
            this.f56765e.f56758e.completePullRefreshPostDelayed(0L);
        }
    }

    /* loaded from: classes7.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumRankActivity f56766a;

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
            this.f56766a = forumRankActivity;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.f56766a.hideProgressBar();
                this.f56766a.f56758e.completePullRefreshPostDelayed(0L);
                if (obj == null || !(obj instanceof ForumRankData)) {
                    this.f56766a.f56758e.setVisibility(8);
                    ForumRankActivity forumRankActivity = this.f56766a;
                    forumRankActivity.showNetRefreshView(forumRankActivity.findViewById(R.id.root_view), this.f56766a.getResources().getString(R.string.recommend_pb_no_net_text), true);
                    this.f56766a.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                    this.f56766a.showToast(R.string.neterror);
                    return;
                }
                ForumRankData forumRankData = (ForumRankData) obj;
                if (forumRankData.error_code == 0) {
                    this.f56766a.f56758e.setVisibility(0);
                    String str = forumRankData.pic_url;
                    if (str != null && str.length() > 0) {
                        if (this.f56766a.o) {
                            this.f56766a.f56758e.addHeaderView(this.f56766a.f56762i, this.f56766a.q, false);
                            this.f56766a.o = false;
                        }
                        this.f56766a.f56762i.setVisibility(0);
                        this.f56766a.f56762i.setTag(forumRankData.pic_url);
                        ViewGroup.LayoutParams layoutParams = this.f56766a.f56762i.getLayoutParams();
                        layoutParams.width = -1;
                        layoutParams.height = (int) ((l.k(this.f56766a.getPageContext().getPageActivity()) * 15.0f) / 32.0f);
                        this.f56766a.n = forumRankData.pic_url;
                    }
                    this.f56766a.f56760g.f(forumRankData.forumsquare_list);
                    this.f56766a.f56760g.h(Boolean.valueOf(forumRankData.is_order != 0));
                    this.f56766a.f56761h.setTitleText(forumRankData.title);
                    ForumInfoData[] forumInfoDataArr = forumRankData.forumsquare_list;
                    if (forumInfoDataArr != null && forumInfoDataArr.length > 100 && this.f56766a.f56758e.getAdapter2().j() <= 0) {
                        this.f56766a.f56758e.addFooterView(this.f56766a.k);
                    }
                    ForumInfoData[] forumInfoDataArr2 = forumRankData.forumsquare_list;
                    if (forumInfoDataArr2 == null || forumInfoDataArr2.length == 0) {
                        this.f56766a.m.setVisibility(0);
                        return;
                    } else {
                        this.f56766a.m.setVisibility(8);
                        return;
                    }
                }
                this.f56766a.f56758e.setVisibility(8);
                ForumRankActivity forumRankActivity2 = this.f56766a;
                forumRankActivity2.showNetRefreshView(forumRankActivity2.findViewById(R.id.root_view), this.f56766a.getResources().getString(R.string.recommend_pb_no_net_text), true);
                this.f56766a.setNetRefreshLayoutMarginTopWhenIsNoNetworkViewDismiss(false);
                NewErrorData newErrorData = forumRankData.error;
                if (newErrorData != null) {
                    this.f56766a.showToast(newErrorData.usermsg);
                } else {
                    this.f56766a.showToast(R.string.neterror);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends AbstractImageProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumRankActivity f56767e;

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
            this.f56767e = forumRankActivity;
        }

        @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
        public ArrayList<String> getImageUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f56767e.n != null) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(this.f56767e.n);
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
        this.f56758e = null;
        this.f56759f = null;
        this.f56760g = null;
        this.f56761h = null;
        this.f56762i = null;
        this.f56763j = null;
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
            this.f56761h.onChangeSkinType(getPageContext(), i2);
            if (i2 != 1 && i2 != 4) {
                this.f56758e.setBackgroundColor(getResources().getColor(R.color.common_color_10163));
                this.f56760g.d(false);
            } else {
                this.f56758e.setBackgroundColor(getResources().getColor(R.color.common_color_10150));
                this.f56760g.d(true);
            }
            SkinManager.setFrsPBBgColor(findViewById(R.id.root_view), i2);
            this.l.D(i2);
            this.f56760g.i(R.drawable.btn_add_end, R.drawable.btn_add);
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (forumRankModel = this.f56759f) == null) {
            return;
        }
        forumRankModel.LoadData();
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
            this.f56759f.D(bundle);
        }
    }

    public final void t(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            if (bundle != null) {
                this.f56759f = new ForumRankModel(bundle);
            } else {
                this.f56759f = new ForumRankModel(getIntent());
            }
            this.o = true;
            this.f56759f.setLoadDataCallBack(this.p);
            c.a.q0.f3.h.b bVar = new c.a.q0.f3.h.b(getPageContext(), 0);
            this.f56760g = bVar;
            bVar.e(100);
            this.f56760g.h(Boolean.TRUE);
            this.f56760g.g(ForumDetailActivityConfig.FromType.BAR_RANK);
            this.f56758e.setAdapter((ListAdapter) this.f56760g);
            if (this.f56759f.LoadData()) {
                this.f56760g.e(100);
                showProgressBar();
            }
            LikeModel likeModel = new LikeModel(getPageContext());
            this.f56763j = likeModel;
            this.f56760g.j(likeModel);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            setContentView(R.layout.forum_rank_activity);
            TbImageView tbImageView = new TbImageView(getPageContext().getPageActivity());
            this.f56762i = tbImageView;
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.f56761h = navigationBar;
            navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f56761h.setTitleText("");
            this.f56758e = (BdListView) findViewById(R.id.list);
            this.f56762i.setLayoutParams(new AbsListView.LayoutParams(l.k(getPageContext().getPageActivity()), (int) (l.k(getPageContext().getPageActivity()) * 0.5d)));
            this.f56762i.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getPageContext().getPageActivity()).inflate(R.layout.forum_list_forum_footer, (ViewGroup) null);
            this.k = linearLayout;
            linearLayout.setOnClickListener(new a(this));
            g gVar = new g(getPageContext());
            this.l = gVar;
            this.f56758e.setPullRefresh(gVar);
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + l.g(getActivity(), R.dimen.ds98)));
            this.f56758e.addHeaderView(textView, 0);
            this.l.a(new b(this));
            this.m = (FrameLayout) findViewById(R.id.empty_textview_container);
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ForumInfoData[] a2 = this.f56760g.a();
            for (int i2 = 0; i2 < a2.length; i2++) {
                int hasLikeForum = TbadkCoreApplication.getInst().hasLikeForum(a2[i2].forum_name);
                if (hasLikeForum == 1) {
                    a2[i2].is_like = 1;
                } else if (hasLikeForum == -1) {
                    a2[i2].is_like = 0;
                }
            }
            this.f56760g.f(a2);
        }
    }
}
