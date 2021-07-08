package com.baidu.tieba.square.flist;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.square.flist.DirMenuModel;
import com.baidu.tieba.square.flist.ForumListDetailModel;
import com.baidu.tieba.square.flist.ForumListModel;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.r.f0.f;
import d.a.p0.h3.w;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean L = false;
    public static String M = "";
    public static String N = "";
    public static String O = "";
    public static String P = "";
    public transient /* synthetic */ FieldHolder $fh;
    public ForumListModel.RequestParams A;
    public boolean B;
    public boolean C;
    public d.a.p0.e3.h.b D;
    public d.a.p0.e3.h.b E;
    public DirMenuModel F;
    public ForumListDetailModel G;
    public final ForumListDetailModel.b H;
    public final DirMenuModel.c I;
    public final AdapterView.OnItemClickListener J;
    public final f.g K;

    /* renamed from: e  reason: collision with root package name */
    public int f20968e;

    /* renamed from: f  reason: collision with root package name */
    public int f20969f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f20970g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f20971h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f20972i;
    public Drawable j;
    public Drawable k;
    public Drawable l;
    public int m;
    public int n;
    public ForumListModel.List o;
    public ForumListModel.List p;
    public int q;
    public final LikeModel r;
    public boolean s;
    public int t;
    public boolean u;
    public int v;
    public int w;
    public boolean x;
    public boolean y;
    public d.a.p0.e3.h.c z;

    /* loaded from: classes4.dex */
    public class a implements ForumListDetailModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f20973a;

        public a(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20973a = forumListActivity;
        }

        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.b
        public void a(boolean z, int i2, ForumListModel forumListModel, String str, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), forumListModel, str, Boolean.valueOf(z2)}) == null) {
                if (!z && this.f20973a.D.a() == null) {
                    this.f20973a.showToast(str);
                    this.f20973a.z.e();
                    this.f20973a.z.d();
                    if (this.f20973a.A.menu_type == 2 && !z2) {
                        this.f20973a.finish();
                    }
                    this.f20973a.z.A.setVisibility(8);
                } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                    if (this.f20973a.A.menu_type == 2 && !z2) {
                        ForumListActivity forumListActivity = this.f20973a;
                        forumListActivity.showToast(forumListActivity.getPageContext().getString(R.string.no_forum_data));
                        this.f20973a.finish();
                    } else {
                        this.f20973a.showToast(str);
                        this.f20973a.z.d();
                        this.f20973a.A.recommend_type = this.f20973a.v;
                        this.f20973a.A.rn = this.f20973a.w;
                    }
                    this.f20973a.z.A.setVisibility(8);
                } else {
                    this.f20973a.z.A.setVisibility(8);
                    if (this.f20973a.u) {
                        ForumListActivity forumListActivity2 = this.f20973a;
                        forumListActivity2.z.n.setText(forumListActivity2.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity3 = this.f20973a;
                        forumListActivity3.z.o.setImageDrawable(forumListActivity3.k);
                        ForumListActivity forumListActivity4 = this.f20973a;
                        forumListActivity4.z.q.setText(forumListActivity4.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity5 = this.f20973a;
                        forumListActivity5.z.r.setImageDrawable(forumListActivity5.k);
                        this.f20973a.u = false;
                    }
                    ForumListActivity forumListActivity6 = this.f20973a;
                    forumListActivity6.z.f55982g.setText(forumListActivity6.A.menu_name);
                    ForumListActivity forumListActivity7 = this.f20973a;
                    forumListActivity7.z.f55981f.onChangeSkinType(forumListActivity7.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    ForumListActivity forumListActivity8 = this.f20973a;
                    forumListActivity8.z.y.d(forumListActivity8.t);
                    int min = Math.min(forumListModel.recommend_list_left.forum_list.length, this.f20973a.o.forum_list.length);
                    int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, this.f20973a.p.forum_list.length);
                    System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.f20973a.o.forum_list, 0, min);
                    System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.f20973a.p.forum_list, 0, min2);
                    this.f20973a.D.e(min);
                    this.f20973a.D.j(this.f20973a.r);
                    this.f20973a.D.f(this.f20973a.o.forum_list);
                    this.f20973a.z.f55984i.setSelection(0);
                    if (forumListModel.recommend_list_left.has_more == 1) {
                        this.f20973a.z.f55977b.setVisibility(0);
                    } else {
                        this.f20973a.z.f55977b.setVisibility(8);
                    }
                    this.f20973a.z.k.setText(forumListModel.forum_class[0]);
                    this.f20973a.E.e(min2);
                    this.f20973a.E.j(this.f20973a.r);
                    this.f20973a.E.f(this.f20973a.p.forum_list);
                    this.f20973a.z.j.setSelection(0);
                    if (forumListModel.recommend_list_right.has_more == 1) {
                        this.f20973a.z.f55978c.setVisibility(0);
                    } else {
                        this.f20973a.z.f55978c.setVisibility(8);
                    }
                    this.f20973a.z.l.setText(forumListModel.forum_class[1]);
                    this.f20973a.findViewById(R.id.item_root).setVisibility(0);
                    this.f20973a.z.d();
                    if (this.f20973a.z.y.getCount() > 0) {
                        this.f20973a.z.z.setClickable(true);
                        ForumListActivity forumListActivity9 = this.f20973a;
                        forumListActivity9.z.z.setOnClickListener(forumListActivity9);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DirMenuModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f20974a;

        public b(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20974a = forumListActivity;
        }

        @Override // com.baidu.tieba.square.flist.DirMenuModel.c
        public void a(boolean z, int i2, d.a.p0.e3.j.d dVar, String str, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), dVar, str, Boolean.valueOf(z2)}) == null) {
                if (!z || i2 != 0) {
                    if (z2) {
                        return;
                    }
                    this.f20974a.z.e();
                    return;
                }
                dVar.f56015e.add(0, dVar);
                d.a.p0.e3.h.a aVar = this.f20974a.z.y;
                if (aVar != null) {
                    aVar.e(dVar);
                    ForumListActivity forumListActivity = this.f20974a;
                    forumListActivity.T(String.valueOf(forumListActivity.z.f55982g.getText()));
                    ForumListActivity forumListActivity2 = this.f20974a;
                    forumListActivity2.z.f55981f.onChangeSkinType(forumListActivity2.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    this.f20974a.z.y.notifyDataSetChanged();
                }
                this.f20974a.z.z.setClickable(true);
                ForumListActivity forumListActivity3 = this.f20974a;
                forumListActivity3.z.z.setOnClickListener(forumListActivity3);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f20975e;

        public c(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20975e = forumListActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                TiebaStatic.eventStat(this.f20975e.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
                ForumListActivity forumListActivity = this.f20975e;
                d.a.c.e.m.g.d(forumListActivity.z.u, forumListActivity.getPageContext().getPageActivity());
                this.f20975e.t = i2;
                this.f20975e.z.e();
                this.f20975e.z.h();
                ArrayList<d.a.p0.e3.j.d> arrayList = this.f20975e.z.y.c().f56015e;
                this.f20975e.P(arrayList.get(i2).f56012b, arrayList.get(i2).f56013c, arrayList.get(i2).f56011a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f20976e;

        public d(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20976e = forumListActivity;
        }

        @Override // d.a.o0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f20976e.D.c() || this.f20976e.E.c()) {
                return;
            }
            if (this.f20976e.x) {
                this.f20976e.A.recommend_type = 0;
                this.f20976e.A.rn = 200;
                this.f20976e.G.E(this.f20976e.A);
                this.f20976e.G.LoadData();
                this.f20976e.x = false;
            } else if (this.f20976e.z.f55979d.getCurrentItem() == 0) {
                if (this.f20976e.B) {
                    this.f20976e.m = 50;
                } else {
                    this.f20976e.m = 200;
                }
                new j(this.f20976e, null).execute(new Void[0]);
            } else if (this.f20976e.z.f55979d.getCurrentItem() == 1) {
                if (this.f20976e.C) {
                    this.f20976e.n = 50;
                } else {
                    this.f20976e.n = 200;
                }
                new i(this.f20976e, null).execute(new Void[0]);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f20977e;

        public e(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20977e = forumListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20977e.g();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f20978e;

        public f(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20978e = forumListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f20978e.f();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g extends d.a.c.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumInfoData[] f20979a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f20980b;

        public g(ForumListActivity forumListActivity, ForumInfoData[] forumInfoDataArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity, forumInfoDataArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20980b = forumListActivity;
            this.f20979a = forumInfoDataArr;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f20980b.r.getErrorCode() == 22) {
                    ForumListActivity forumListActivity = this.f20980b;
                    forumListActivity.showToast(forumListActivity.getPageContext().getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.f20980b.r.getErrorCode() != 0) {
                        ForumListActivity forumListActivity2 = this.f20980b;
                        forumListActivity2.showToast(forumListActivity2.r.getErrorString());
                    } else if (((w) obj).l() == 1) {
                        ForumListActivity forumListActivity3 = this.f20980b;
                        forumListActivity3.showToast(forumListActivity3.getPageContext().getString(R.string.attention_success));
                        if (this.f20980b.q == 0) {
                            this.f20980b.D.notifyDataSetChanged();
                            TbadkCoreApplication.getInst().addLikeForum(this.f20979a[this.f20980b.D.f55964f].forum_name);
                        } else if (this.f20980b.q == 1) {
                            this.f20980b.E.notifyDataSetChanged();
                            TbadkCoreApplication.getInst().addLikeForum(this.f20979a[this.f20980b.E.f55964f].forum_name);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f20981a;

        public h(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20981a = forumListActivity;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i2, obj) == null) {
                viewGroup.removeView((View) obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f20981a.s ? 1 : 2 : invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) {
                if (i2 == 0) {
                    viewGroup.addView(this.f20981a.z.f55984i);
                    return this.f20981a.z.f55984i;
                } else if (i2 != 1) {
                    return null;
                } else {
                    viewGroup.addView(this.f20981a.z.j);
                    return this.f20981a.z.j;
                }
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, obj)) == null) ? view.equals(obj) : invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-213183588, "Lcom/baidu/tieba/square/flist/ForumListActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-213183588, "Lcom/baidu/tieba/square/flist/ForumListActivity;");
        }
    }

    public ForumListActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = 200;
        this.n = 200;
        this.q = 0;
        this.r = new LikeModel(getPageContext());
        this.s = false;
        this.t = 0;
        this.u = false;
        this.v = 0;
        this.w = 200;
        this.x = true;
        this.y = true;
        this.B = false;
        this.C = false;
        this.H = new a(this);
        this.I = new b(this);
        this.J = new c(this);
        this.K = new d(this);
    }

    public static void S(Context context, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65548, null, context, str, str2, str3, str4) == null) {
            Intent intent = new Intent(context, ForumListActivity.class);
            intent.putExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME, str);
            intent.putExtra(ForumListActivityConfig.KEY_MENU_TYPE, str2);
            intent.putExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID, str3);
            intent.putExtra("level_2_menu_name", str4);
            if (!(context instanceof Activity)) {
                intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            }
            context.startActivity(intent);
        }
    }

    public final BdListView N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdListView bdListView = new BdListView(getPageContext().getPageActivity());
            bdListView.setScrollingCacheEnabled(false);
            bdListView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            bdListView.setCacheColorHint(0);
            bdListView.setSelector(17170445);
            bdListView.setDivider(new ColorDrawable(0));
            bdListView.setDividerHeight(0);
            bdListView.setFooterDividersEnabled(false);
            bdListView.setHorizontalFadingEdgeEnabled(false);
            bdListView.setVerticalFadingEdgeEnabled(false);
            return bdListView;
        }
        return (BdListView) invokeV.objValue;
    }

    public final void O(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            if (k.isEmpty(str4)) {
                str4 = str;
            }
            this.z.f55982g.setText(str4);
            this.z.f55981f.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            ForumListModel.RequestParams requestParams = new ForumListModel.RequestParams();
            this.A = requestParams;
            requestParams.menu_id = d.a.c.e.m.b.d(str2, 0);
            ForumListModel.RequestParams requestParams2 = this.A;
            requestParams2.menu_name = str4;
            requestParams2.menu_type = d.a.c.e.m.b.d(str3, 0);
            this.A.parent_menu_id = d.a.c.e.m.b.d(str2, 0);
            ForumListModel.RequestParams requestParams3 = this.A;
            requestParams3.parent_menu_name = str;
            requestParams3.offset = 0;
            requestParams3.rn = 10;
            if (requestParams3.menu_id != 0) {
                this.z.c();
                this.s = true;
                this.y = false;
                this.D.h(false);
                this.z.f55979d.getAdapter().notifyDataSetChanged();
            } else {
                this.y = true;
                this.D.h(true);
                this.z.g();
            }
            this.o = new ForumListModel.List();
            ForumListModel.List list = new ForumListModel.List();
            this.p = list;
            this.o.forum_list = new ForumInfoData[50];
            list.forum_list = new ForumInfoData[50];
            this.z.s.a(this.K);
            this.z.t.a(this.K);
            this.D.notifyDataSetChanged();
            this.E.notifyDataSetChanged();
            if (str3.equals("2")) {
                this.z.e();
            } else {
                DirMenuModel dirMenuModel = new DirMenuModel(getPageContext(), str, str3, str2);
                this.F = dirMenuModel;
                dirMenuModel.E(this.I);
                this.F.LoadData();
            }
            ForumListDetailModel forumListDetailModel = new ForumListDetailModel(getPageContext(), this.A);
            this.G = forumListDetailModel;
            forumListDetailModel.D(this.H);
            this.z.f55984i.F();
        }
    }

    public final void P(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
            this.A.menu_id = d.a.c.e.m.b.d(str2, 0);
            ForumListModel.RequestParams requestParams = this.A;
            requestParams.menu_name = str;
            requestParams.menu_type = d.a.c.e.m.b.d(str3, 0);
            this.A.parent_menu_id = d.a.c.e.m.b.d(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
            this.A.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
            ForumListModel.RequestParams requestParams2 = this.A;
            requestParams2.offset = 0;
            requestParams2.rn = 10;
            this.v = requestParams2.recommend_type;
            this.w = 10;
            requestParams2.recommend_type = 0;
            requestParams2.rn = 200;
            this.u = true;
            this.G.E(requestParams2);
            this.G.LoadData();
        }
    }

    public final View Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.z.j = N();
            this.z.p.setOnClickListener(new f(this));
            return this.z.j;
        }
        return (View) invokeV.objValue;
    }

    public final View R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.z.f55984i = N();
            this.z.m.setOnClickListener(new e(this));
            return this.z.f55984i;
        }
        return (View) invokeV.objValue;
    }

    public final void T(String str) {
        d.a.p0.e3.j.d c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (c2 = this.z.y.c()) == null) {
            return;
        }
        ArrayList<d.a.p0.e3.j.d> arrayList = c2.f56015e;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (arrayList.get(i2).f56012b.equals(str)) {
                this.t = i2;
                this.z.y.d(i2);
                return;
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.C) {
                int min = Math.min(this.E.getCount(), 200);
                this.n = 200;
                ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
                System.arraycopy(this.E.a(), 0, forumInfoDataArr, 0, min);
                this.E.e(min);
                this.E.f(forumInfoDataArr);
                this.C = false;
                this.z.q.setText(getPageContext().getString(R.string.flist_expand_list));
                this.z.r.setImageDrawable(this.k);
                return;
            }
            this.n = 50;
            i iVar = new i(this, null);
            iVar.d(true);
            iVar.execute(new Void[0]);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (this.B) {
                int min = Math.min(this.D.getCount(), 200);
                this.m = 200;
                ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
                System.arraycopy(this.D.a(), 0, forumInfoDataArr, 0, min);
                this.D.e(min);
                this.D.f(forumInfoDataArr);
                this.B = false;
                this.z.n.setText(getPageContext().getString(R.string.flist_expand_list));
                this.z.o.setImageDrawable(this.k);
                return;
            }
            this.m = 50;
            j jVar = new j(this, null);
            jVar.d(true);
            jVar.execute(new Void[0]);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        ForumInfoData[] a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3, intent) == null) && i2 == 11002 && i3 == -1) {
            this.G.LoadData();
            if (this.q == 0) {
                a2 = this.D.a();
            } else {
                a2 = this.E.a();
            }
            this.r.setLoadDataCallBack(new g(this, a2));
            if (this.q == 0) {
                LikeModel likeModel = this.r;
                int i4 = this.D.f55964f;
                likeModel.L(a2[i4].forum_name, String.valueOf(a2[i4].forum_id));
                return;
            }
            LikeModel likeModel2 = this.r;
            int i5 = this.E.f55964f;
            likeModel2.L(a2[i5].forum_name, String.valueOf(a2[i5].forum_id));
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.z.f55976a);
            this.z.f55981f.onChangeSkinType(getPageContext(), i2);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.D.d(true);
                this.E.d(true);
            } else {
                this.D.d(false);
                this.E.d(false);
            }
            this.D.notifyDataSetChanged();
            this.E.notifyDataSetChanged();
            PopupWindow popupWindow = this.z.u;
            if (popupWindow != null) {
                popupWindow.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_allsproutpop_dropdown));
            }
            SkinManager.setBackgroundResource(this.z.f55980e, R.drawable.bg_pop_most);
            this.f20968e = SkinManager.getColor(R.color.common_color_10243);
            this.f20969f = SkinManager.getColor(R.color.CAM_X0101);
            this.f20970g = SkinManager.getDrawable(R.drawable.btn_pop_most_left_n);
            this.f20971h = SkinManager.getDrawable(R.drawable.btn_pop_most_right_n);
            this.f20972i = SkinManager.getDrawable(R.drawable.btn_pop_most_left_s);
            this.j = SkinManager.getDrawable(R.drawable.btn_pop_most_right_s);
            this.k = SkinManager.getDrawable(R.drawable.ico_downward);
            this.l = SkinManager.getDrawable(R.drawable.ico_upward);
            this.D.i(R.drawable.btn_add_end, R.drawable.btn_add);
            this.E.i(R.drawable.btn_add_end, R.drawable.btn_add);
            SkinManager.setBackgroundResource(this.z.f55978c, R.drawable.bg_black_banner_down);
            SkinManager.setViewTextColor(this.z.q, R.color.common_color_10243, 1);
            SkinManager.setBackgroundResource(this.z.f55977b, R.drawable.bg_black_banner_down);
            SkinManager.setViewTextColor(this.z.n, R.color.common_color_10243, 1);
            if (this.B) {
                SkinManager.setImageResource(this.z.o, R.drawable.ico_upward);
            } else {
                SkinManager.setImageResource(this.z.o, R.drawable.ico_downward);
            }
            if (this.C) {
                SkinManager.setImageResource(this.z.r, R.drawable.ico_upward);
            } else {
                SkinManager.setImageResource(this.z.r, R.drawable.ico_downward);
            }
            if (this.z.f55979d.getCurrentItem() == 0) {
                this.z.k.setTextColor(this.f20969f);
                this.z.k.setBackgroundDrawable(this.f20972i);
                this.z.l.setBackgroundDrawable(this.f20971h);
                this.z.l.setTextColor(this.f20968e);
                return;
            }
            this.z.l.setTextColor(this.f20969f);
            this.z.l.setBackgroundDrawable(this.j);
            this.z.k.setBackgroundDrawable(this.f20970g);
            this.z.k.setTextColor(this.f20968e);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            int id = view.getId();
            if (id == R.id.tab_recommends) {
                this.z.f55979d.setCurrentItem(0);
                this.q = 0;
                TiebaStatic.eventStat(view.getContext(), "recommend_list_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            } else if (id == R.id.tab_hot) {
                this.z.f55979d.setCurrentItem(1);
                this.q = 1;
                TiebaStatic.eventStat(view.getContext(), "hot_list_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            } else if (id == R.id.title_menu) {
                this.z.f(this.J);
            }
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        int g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.forum_list_activity);
            String stringExtra = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
            String stringExtra2 = getIntent().getStringExtra("level_2_menu_name");
            String stringExtra3 = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID);
            String stringExtra4 = getIntent().getStringExtra(ForumListActivityConfig.KEY_MENU_TYPE);
            d.a.p0.e3.h.c cVar = new d.a.p0.e3.h.c(this);
            this.z = cVar;
            cVar.f55984i = (BdListView) R();
            this.z.j = (BdListView) Q();
            this.z.A.setVisibility(0);
            this.z.z.setOnClickListener(null);
            this.z.z.setClickable(false);
            this.z.f55979d.setAdapter(new h(this));
            d.a.p0.e3.h.c cVar2 = this.z;
            cVar2.f55984i.setPullRefresh(cVar2.s);
            d.a.p0.e3.h.c cVar3 = this.z;
            cVar3.j.setPullRefresh(cVar3.t);
            if (d.a.c.e.m.b.d(stringExtra3, 0) != 0) {
                g2 = l.g(getActivity(), R.dimen.ds98);
            } else {
                g2 = l.g(getActivity(), R.dimen.ds176);
            }
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + g2));
            this.z.f55984i.x(textView, 0);
            TextView textView2 = new TextView(getActivity());
            textView2.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + g2));
            this.z.j.x(textView2, 0);
            d.a.p0.e3.h.b bVar = new d.a.p0.e3.h.b(getPageContext(), 0);
            this.D = bVar;
            this.z.f55984i.setAdapter((ListAdapter) bVar);
            d.a.p0.e3.h.b bVar2 = new d.a.p0.e3.h.b(getPageContext(), 1);
            this.E = bVar2;
            this.z.j.setAdapter((ListAdapter) bVar2);
            O(stringExtra, stringExtra3, stringExtra4, stringExtra2);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            LikeModel likeModel = this.r;
            if (likeModel != null) {
                likeModel.I();
            }
            this.z.f55979d.setAdapter(null);
            this.z.j.setAdapter((ListAdapter) null);
            this.z.f55984i.setAdapter((ListAdapter) null);
            ListView listView = this.z.x;
            if (listView != null) {
                listView.setAdapter((ListAdapter) null);
            }
            DirMenuModel dirMenuModel = this.F;
            if (dirMenuModel != null) {
                dirMenuModel.cancelLoadData();
            }
            ForumListDetailModel forumListDetailModel = this.G;
            if (forumListDetailModel != null) {
                forumListDetailModel.cancelLoadData();
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || this.s) {
            return;
        }
        if (i2 == 0) {
            this.D.k();
            this.D.notifyDataSetChanged();
            this.z.k.setBackgroundDrawable(this.f20972i);
            this.z.k.setTextColor(this.f20969f);
            this.z.l.setBackgroundDrawable(this.f20971h);
            this.z.l.setTextColor(this.f20968e);
        } else if (i2 == 1) {
            this.E.k();
            this.E.notifyDataSetChanged();
            this.z.l.setBackgroundDrawable(this.j);
            this.z.l.setTextColor(this.f20969f);
            this.z.k.setBackgroundDrawable(this.f20970g);
            this.z.k.setTextColor(this.f20968e);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            if (L) {
                L = false;
                finish();
                S(getPageContext().getPageActivity(), M, O, N, P);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                return;
            }
            d.a.p0.e3.h.b bVar = this.D;
            if (bVar != null) {
                bVar.k();
                this.D.notifyDataSetChanged();
            }
            d.a.p0.e3.h.b bVar2 = this.E;
            if (bVar2 != null) {
                bVar2.k();
                this.E.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i extends BdAsyncTask<Void, Void, ForumListModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f20982a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f20983b;

        public i(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20983b = forumListActivity;
            this.f20982a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumListModel doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                try {
                    this.f20983b.A.recommend_type = 2;
                    this.f20983b.A.offset = 0;
                    this.f20983b.A.rn = this.f20983b.n;
                    return ForumListModel.new_fetch(this.f20983b.A);
                } catch (Exception unused) {
                    return null;
                }
            }
            return (ForumListModel) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForumListModel forumListModel) {
            ForumListModel.List list;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumListModel) == null) {
                if (forumListModel != null && (list = forumListModel.recommend_list_right) != null) {
                    int min = Math.min(list.forum_list.length, this.f20983b.p.forum_list.length);
                    System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.f20983b.p.forum_list, 0, min);
                    this.f20983b.E.e(min);
                    this.f20983b.E.f(this.f20983b.p.forum_list);
                    if (this.f20983b.n == 200) {
                        ForumListActivity forumListActivity = this.f20983b;
                        forumListActivity.z.q.setText(forumListActivity.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity2 = this.f20983b;
                        forumListActivity2.z.r.setImageDrawable(forumListActivity2.k);
                    } else {
                        ForumListActivity forumListActivity3 = this.f20983b;
                        forumListActivity3.z.q.setText(forumListActivity3.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity forumListActivity4 = this.f20983b;
                        forumListActivity4.z.r.setImageDrawable(forumListActivity4.l);
                        this.f20983b.C = true;
                    }
                } else {
                    ForumListActivity forumListActivity5 = this.f20983b;
                    forumListActivity5.showToast(forumListActivity5.getPageContext().getString(R.string.neterror));
                    if (!this.f20982a) {
                        if (this.f20983b.n == 200) {
                            ForumListActivity forumListActivity6 = this.f20983b;
                            forumListActivity6.z.q.setText(forumListActivity6.getPageContext().getString(R.string.flist_expand_list));
                            ForumListActivity forumListActivity7 = this.f20983b;
                            forumListActivity7.z.r.setImageDrawable(forumListActivity7.k);
                        } else {
                            ForumListActivity forumListActivity8 = this.f20983b;
                            forumListActivity8.z.q.setText(forumListActivity8.getPageContext().getString(R.string.flist_collapse_list));
                            ForumListActivity forumListActivity9 = this.f20983b;
                            forumListActivity9.z.r.setImageDrawable(forumListActivity9.l);
                        }
                    } else {
                        ForumListActivity forumListActivity10 = this.f20983b;
                        forumListActivity10.z.q.setText(forumListActivity10.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity11 = this.f20983b;
                        forumListActivity11.z.r.setImageDrawable(forumListActivity11.k);
                        this.f20983b.A.rn = 200;
                        this.f20983b.n = 200;
                    }
                }
                this.f20983b.z.p.setEnabled(true);
                this.f20983b.z.d();
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f20982a = z;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f20983b.z.p.setEnabled(false);
                ForumListActivity forumListActivity = this.f20983b;
                forumListActivity.z.q.setText(forumListActivity.getPageContext().getString(R.string.flist_loading));
            }
        }

        public /* synthetic */ i(ForumListActivity forumListActivity, a aVar) {
            this(forumListActivity);
        }
    }

    /* loaded from: classes4.dex */
    public class j extends BdAsyncTask<Void, Void, ForumListModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f20984a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f20985b;

        public j(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20985b = forumListActivity;
            this.f20984a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumListModel doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                try {
                    this.f20985b.A.recommend_type = 1;
                    this.f20985b.A.offset = 0;
                    this.f20985b.A.rn = this.f20985b.m;
                    return ForumListModel.new_fetch(this.f20985b.A);
                } catch (Exception unused) {
                    return null;
                }
            }
            return (ForumListModel) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForumListModel forumListModel) {
            ForumListModel.List list;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, forumListModel) == null) {
                if (forumListModel != null && (list = forumListModel.recommend_list_left) != null) {
                    int min = Math.min(list.forum_list.length, this.f20985b.o.forum_list.length);
                    System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.f20985b.o.forum_list, 0, min);
                    this.f20985b.D.e(min);
                    this.f20985b.D.f(this.f20985b.o.forum_list);
                    if (this.f20985b.m == 200) {
                        ForumListActivity forumListActivity = this.f20985b;
                        forumListActivity.z.n.setText(forumListActivity.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity2 = this.f20985b;
                        forumListActivity2.z.o.setImageDrawable(forumListActivity2.k);
                    } else {
                        ForumListActivity forumListActivity3 = this.f20985b;
                        forumListActivity3.z.n.setText(forumListActivity3.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity forumListActivity4 = this.f20985b;
                        forumListActivity4.z.o.setImageDrawable(forumListActivity4.l);
                        this.f20985b.B = true;
                    }
                } else {
                    ForumListActivity forumListActivity5 = this.f20985b;
                    forumListActivity5.showToast(forumListActivity5.getPageContext().getString(R.string.neterror));
                    if (!this.f20984a) {
                        if (this.f20985b.m == 200) {
                            ForumListActivity forumListActivity6 = this.f20985b;
                            forumListActivity6.z.n.setText(forumListActivity6.getPageContext().getString(R.string.flist_expand_list));
                            ForumListActivity forumListActivity7 = this.f20985b;
                            forumListActivity7.z.o.setImageDrawable(forumListActivity7.k);
                        } else {
                            ForumListActivity forumListActivity8 = this.f20985b;
                            forumListActivity8.z.n.setText(forumListActivity8.getPageContext().getString(R.string.flist_collapse_list));
                            ForumListActivity forumListActivity9 = this.f20985b;
                            forumListActivity9.z.o.setImageDrawable(forumListActivity9.l);
                        }
                    } else {
                        ForumListActivity forumListActivity10 = this.f20985b;
                        forumListActivity10.z.n.setText(forumListActivity10.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity11 = this.f20985b;
                        forumListActivity11.z.o.setImageDrawable(forumListActivity11.k);
                        this.f20985b.A.rn = 200;
                        this.f20985b.m = 200;
                    }
                }
                this.f20985b.z.m.setEnabled(true);
                this.f20985b.z.d();
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f20984a = z;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f20985b.z.m.setEnabled(false);
                ForumListActivity forumListActivity = this.f20985b;
                forumListActivity.z.n.setText(forumListActivity.getPageContext().getString(R.string.flist_loading));
            }
        }

        public /* synthetic */ j(ForumListActivity forumListActivity, a aVar) {
            this(forumListActivity);
        }
    }
}
