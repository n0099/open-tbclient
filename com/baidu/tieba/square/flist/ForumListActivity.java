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
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.s.f0.f;
import c.a.r0.j3.w;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HOT_LIST = 1;
    public static String I = "";
    public static final int INITIAL_ITEM_COUNT = 200;
    public static String J = "";
    public static String K = "";
    public static final String KEY_LEVEL_2_MENU_NAME = "level_2_menu_name";
    public static final String KEY_MENU_ID = "menu_id";
    public static final String KEY_MENU_NAME = "menu_name";
    public static final String KEY_MENU_TYPE = "menu_type";
    public static final String KEY_PARENT_MENU_ID = "parent_menu_id";
    public static final String KEY_PARENT_MENU_NAME = "parent_menu_name";
    public static String L = "";
    public static final int LOAD_MORE_COUNT = 50;
    public static final int RECOMMEND_LIST = 0;
    public static final int TYPE_FROM_FRS_int = 2;
    public static boolean isNeedRefreshOnBackFromBarDetail;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.g3.h.b A;
    public c.a.r0.g3.h.b B;
    public DirMenuModel C;
    public ForumListDetailModel D;
    public final ForumListDetailModel.b E;
    public final DirMenuModel.c F;
    public final AdapterView.OnItemClickListener G;
    public final f.g H;

    /* renamed from: e  reason: collision with root package name */
    public int f56891e;

    /* renamed from: f  reason: collision with root package name */
    public int f56892f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f56893g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f56894h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f56895i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f56896j;
    public Drawable k;
    public Drawable l;
    public int m;
    public c.a.r0.g3.h.c mViewHolder;
    public int n;
    public int o;
    public final LikeModel p;
    public boolean q;
    public int r;
    public ForumListModel.List recommend_list_left;
    public ForumListModel.List recommend_list_right;
    public boolean s;
    public int t;
    public int u;
    public boolean v;
    public boolean w;
    public ForumListModel.RequestParams x;
    public boolean y;
    public boolean z;

    /* loaded from: classes7.dex */
    public class a implements ForumListDetailModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f56897a;

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
            this.f56897a = forumListActivity;
        }

        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.b
        public void a(boolean z, int i2, ForumListModel forumListModel, String str, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), forumListModel, str, Boolean.valueOf(z2)}) == null) {
                if (!z && this.f56897a.A.a() == null) {
                    this.f56897a.showToast(str);
                    this.f56897a.mViewHolder.e();
                    this.f56897a.mViewHolder.d();
                    if (this.f56897a.x.menu_type == 2 && !z2) {
                        this.f56897a.finish();
                    }
                    this.f56897a.mViewHolder.A.setVisibility(8);
                } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                    if (this.f56897a.x.menu_type == 2 && !z2) {
                        ForumListActivity forumListActivity = this.f56897a;
                        forumListActivity.showToast(forumListActivity.getPageContext().getString(R.string.no_forum_data));
                        this.f56897a.finish();
                    } else {
                        this.f56897a.showToast(str);
                        this.f56897a.mViewHolder.d();
                        this.f56897a.x.recommend_type = this.f56897a.t;
                        this.f56897a.x.rn = this.f56897a.u;
                    }
                    this.f56897a.mViewHolder.A.setVisibility(8);
                } else {
                    this.f56897a.mViewHolder.A.setVisibility(8);
                    if (this.f56897a.s) {
                        ForumListActivity forumListActivity2 = this.f56897a;
                        forumListActivity2.mViewHolder.n.setText(forumListActivity2.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity3 = this.f56897a;
                        forumListActivity3.mViewHolder.o.setImageDrawable(forumListActivity3.k);
                        ForumListActivity forumListActivity4 = this.f56897a;
                        forumListActivity4.mViewHolder.q.setText(forumListActivity4.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity5 = this.f56897a;
                        forumListActivity5.mViewHolder.r.setImageDrawable(forumListActivity5.k);
                        this.f56897a.s = false;
                    }
                    ForumListActivity forumListActivity6 = this.f56897a;
                    forumListActivity6.mViewHolder.f18711g.setText(forumListActivity6.x.menu_name);
                    ForumListActivity forumListActivity7 = this.f56897a;
                    forumListActivity7.mViewHolder.f18710f.onChangeSkinType(forumListActivity7.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    ForumListActivity forumListActivity8 = this.f56897a;
                    forumListActivity8.mViewHolder.y.d(forumListActivity8.r);
                    int min = Math.min(forumListModel.recommend_list_left.forum_list.length, this.f56897a.recommend_list_left.forum_list.length);
                    int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, this.f56897a.recommend_list_right.forum_list.length);
                    System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.f56897a.recommend_list_left.forum_list, 0, min);
                    System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.f56897a.recommend_list_right.forum_list, 0, min2);
                    this.f56897a.A.e(min);
                    this.f56897a.A.j(this.f56897a.p);
                    this.f56897a.A.f(this.f56897a.recommend_list_left.forum_list);
                    this.f56897a.mViewHolder.f18713i.setSelection(0);
                    if (forumListModel.recommend_list_left.has_more == 1) {
                        this.f56897a.mViewHolder.f18706b.setVisibility(0);
                    } else {
                        this.f56897a.mViewHolder.f18706b.setVisibility(8);
                    }
                    this.f56897a.mViewHolder.k.setText(forumListModel.forum_class[0]);
                    this.f56897a.B.e(min2);
                    this.f56897a.B.j(this.f56897a.p);
                    this.f56897a.B.f(this.f56897a.recommend_list_right.forum_list);
                    this.f56897a.mViewHolder.f18714j.setSelection(0);
                    if (forumListModel.recommend_list_right.has_more == 1) {
                        this.f56897a.mViewHolder.f18707c.setVisibility(0);
                    } else {
                        this.f56897a.mViewHolder.f18707c.setVisibility(8);
                    }
                    this.f56897a.mViewHolder.l.setText(forumListModel.forum_class[1]);
                    this.f56897a.findViewById(R.id.item_root).setVisibility(0);
                    this.f56897a.mViewHolder.d();
                    if (this.f56897a.mViewHolder.y.getCount() > 0) {
                        this.f56897a.mViewHolder.z.setClickable(true);
                        ForumListActivity forumListActivity9 = this.f56897a;
                        forumListActivity9.mViewHolder.z.setOnClickListener(forumListActivity9);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DirMenuModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f56898a;

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
            this.f56898a = forumListActivity;
        }

        @Override // com.baidu.tieba.square.flist.DirMenuModel.c
        public void a(boolean z, int i2, c.a.r0.g3.j.d dVar, String str, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), dVar, str, Boolean.valueOf(z2)}) == null) {
                if (!z || i2 != 0) {
                    if (z2) {
                        return;
                    }
                    this.f56898a.mViewHolder.e();
                    return;
                }
                dVar.f18746e.add(0, dVar);
                c.a.r0.g3.h.a aVar = this.f56898a.mViewHolder.y;
                if (aVar != null) {
                    aVar.e(dVar);
                    ForumListActivity forumListActivity = this.f56898a;
                    forumListActivity.W(String.valueOf(forumListActivity.mViewHolder.f18711g.getText()));
                    ForumListActivity forumListActivity2 = this.f56898a;
                    forumListActivity2.mViewHolder.f18710f.onChangeSkinType(forumListActivity2.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    this.f56898a.mViewHolder.y.notifyDataSetChanged();
                }
                this.f56898a.mViewHolder.z.setClickable(true);
                ForumListActivity forumListActivity3 = this.f56898a;
                forumListActivity3.mViewHolder.z.setOnClickListener(forumListActivity3);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f56899e;

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
            this.f56899e = forumListActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j2)}) == null) {
                TiebaStatic.eventStat(this.f56899e.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
                ForumListActivity forumListActivity = this.f56899e;
                c.a.e.e.m.g.d(forumListActivity.mViewHolder.u, forumListActivity.getPageContext().getPageActivity());
                this.f56899e.r = i2;
                this.f56899e.mViewHolder.e();
                this.f56899e.mViewHolder.h();
                ArrayList<c.a.r0.g3.j.d> arrayList = this.f56899e.mViewHolder.y.c().f18746e;
                this.f56899e.T(arrayList.get(i2).f18743b, arrayList.get(i2).f18744c, arrayList.get(i2).f18742a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f56900e;

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
            this.f56900e = forumListActivity;
        }

        @Override // c.a.q0.s.f0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f56900e.A.c() || this.f56900e.B.c()) {
                return;
            }
            if (this.f56900e.v) {
                this.f56900e.x.recommend_type = 0;
                this.f56900e.x.rn = 200;
                this.f56900e.D.E(this.f56900e.x);
                this.f56900e.D.LoadData();
                this.f56900e.v = false;
            } else if (this.f56900e.mViewHolder.f18708d.getCurrentItem() == 0) {
                if (this.f56900e.y) {
                    this.f56900e.m = 50;
                } else {
                    this.f56900e.m = 200;
                }
                new j(this.f56900e, null).execute(new Void[0]);
            } else if (this.f56900e.mViewHolder.f18708d.getCurrentItem() == 1) {
                if (this.f56900e.z) {
                    this.f56900e.n = 50;
                } else {
                    this.f56900e.n = 200;
                }
                new i(this.f56900e, null).execute(new Void[0]);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f56901e;

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
            this.f56901e = forumListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f56901e.g();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f56902e;

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
            this.f56902e = forumListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f56902e.f();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends c.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumInfoData[] f56903a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f56904b;

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
            this.f56904b = forumListActivity;
            this.f56903a = forumInfoDataArr;
        }

        @Override // c.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.f56904b.p.getErrorCode() == 22) {
                    ForumListActivity forumListActivity = this.f56904b;
                    forumListActivity.showToast(forumListActivity.getPageContext().getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.f56904b.p.getErrorCode() != 0) {
                        ForumListActivity forumListActivity2 = this.f56904b;
                        forumListActivity2.showToast(forumListActivity2.p.getErrorString());
                    } else if (((w) obj).l() == 1) {
                        ForumListActivity forumListActivity3 = this.f56904b;
                        forumListActivity3.showToast(forumListActivity3.getPageContext().getString(R.string.attention_success));
                        if (this.f56904b.o == 0) {
                            this.f56904b.A.notifyDataSetChanged();
                            TbadkCoreApplication.getInst().addLikeForum(this.f56903a[this.f56904b.A.f18692f].forum_name);
                        } else if (this.f56904b.o == 1) {
                            this.f56904b.B.notifyDataSetChanged();
                            TbadkCoreApplication.getInst().addLikeForum(this.f56903a[this.f56904b.B.f18692f].forum_name);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f56905a;

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
            this.f56905a = forumListActivity;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f56905a.q ? 1 : 2 : invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i2)) == null) {
                if (i2 == 0) {
                    viewGroup.addView(this.f56905a.mViewHolder.f18713i);
                    return this.f56905a.mViewHolder.f18713i;
                } else if (i2 != 1) {
                    return null;
                } else {
                    viewGroup.addView(this.f56905a.mViewHolder.f18714j);
                    return this.f56905a.mViewHolder.f18714j;
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
        this.o = 0;
        this.p = new LikeModel(getPageContext());
        this.q = false;
        this.r = 0;
        this.s = false;
        this.t = 0;
        this.u = 200;
        this.v = true;
        this.w = true;
        this.y = false;
        this.z = false;
        this.E = new a(this);
        this.F = new b(this);
        this.G = new c(this);
        this.H = new d(this);
    }

    public static void startLevel2ForumListActivity(Context context, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65560, null, context, str, str2, str3, str4) == null) {
            Intent intent = new Intent(context, ForumListActivity.class);
            intent.putExtra("parent_menu_name", str);
            intent.putExtra("menu_type", str2);
            intent.putExtra("parent_menu_id", str3);
            intent.putExtra(KEY_LEVEL_2_MENU_NAME, str4);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    public static void updateForumInfo(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65563, null, str, str2, str3, str4) == null) {
            I = str;
            J = str2;
            K = str3;
            L = str4;
        }
    }

    public final BdListView R() {
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

    public final void S(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            if (k.isEmpty(str4)) {
                str4 = str;
            }
            this.mViewHolder.f18711g.setText(str4);
            this.mViewHolder.f18710f.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            ForumListModel.RequestParams requestParams = new ForumListModel.RequestParams();
            this.x = requestParams;
            requestParams.menu_id = c.a.e.e.m.b.e(str2, 0);
            ForumListModel.RequestParams requestParams2 = this.x;
            requestParams2.menu_name = str4;
            requestParams2.menu_type = c.a.e.e.m.b.e(str3, 0);
            this.x.parent_menu_id = c.a.e.e.m.b.e(str2, 0);
            ForumListModel.RequestParams requestParams3 = this.x;
            requestParams3.parent_menu_name = str;
            requestParams3.offset = 0;
            requestParams3.rn = 10;
            if (requestParams3.menu_id != 0) {
                this.mViewHolder.c();
                this.q = true;
                this.w = false;
                this.A.h(false);
                this.mViewHolder.f18708d.getAdapter().notifyDataSetChanged();
            } else {
                this.w = true;
                this.A.h(true);
                this.mViewHolder.g();
            }
            this.recommend_list_left = new ForumListModel.List();
            ForumListModel.List list = new ForumListModel.List();
            this.recommend_list_right = list;
            this.recommend_list_left.forum_list = new ForumInfoData[50];
            list.forum_list = new ForumInfoData[50];
            this.mViewHolder.s.a(this.H);
            this.mViewHolder.t.a(this.H);
            this.A.notifyDataSetChanged();
            this.B.notifyDataSetChanged();
            if (str3.equals("2")) {
                this.mViewHolder.e();
            } else {
                DirMenuModel dirMenuModel = new DirMenuModel(getPageContext(), str, str3, str2);
                this.C = dirMenuModel;
                dirMenuModel.E(this.F);
                this.C.LoadData();
            }
            ForumListDetailModel forumListDetailModel = new ForumListDetailModel(getPageContext(), this.x);
            this.D = forumListDetailModel;
            forumListDetailModel.D(this.E);
            this.mViewHolder.f18713i.startPullRefresh();
        }
    }

    public final void T(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
            this.x.menu_id = c.a.e.e.m.b.e(str2, 0);
            ForumListModel.RequestParams requestParams = this.x;
            requestParams.menu_name = str;
            requestParams.menu_type = c.a.e.e.m.b.e(str3, 0);
            this.x.parent_menu_id = c.a.e.e.m.b.e(getIntent().getStringExtra("parent_menu_id"), 0);
            this.x.parent_menu_name = getIntent().getStringExtra("parent_menu_name");
            ForumListModel.RequestParams requestParams2 = this.x;
            requestParams2.offset = 0;
            requestParams2.rn = 10;
            this.t = requestParams2.recommend_type;
            this.u = 10;
            requestParams2.recommend_type = 0;
            requestParams2.rn = 200;
            this.s = true;
            this.D.E(requestParams2);
            this.D.LoadData();
        }
    }

    public final View U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.mViewHolder.f18714j = R();
            this.mViewHolder.p.setOnClickListener(new f(this));
            return this.mViewHolder.f18714j;
        }
        return (View) invokeV.objValue;
    }

    public final View V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.mViewHolder.f18713i = R();
            this.mViewHolder.m.setOnClickListener(new e(this));
            return this.mViewHolder.f18713i;
        }
        return (View) invokeV.objValue;
    }

    public final void W(String str) {
        c.a.r0.g3.j.d c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (c2 = this.mViewHolder.y.c()) == null) {
            return;
        }
        ArrayList<c.a.r0.g3.j.d> arrayList = c2.f18746e;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (arrayList.get(i2).f18743b.equals(str)) {
                this.r = i2;
                this.mViewHolder.y.d(i2);
                return;
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.z) {
                int min = Math.min(this.B.getCount(), 200);
                this.n = 200;
                ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
                System.arraycopy(this.B.a(), 0, forumInfoDataArr, 0, min);
                this.B.e(min);
                this.B.f(forumInfoDataArr);
                this.z = false;
                this.mViewHolder.q.setText(getPageContext().getString(R.string.flist_expand_list));
                this.mViewHolder.r.setImageDrawable(this.k);
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
            if (this.y) {
                int min = Math.min(this.A.getCount(), 200);
                this.m = 200;
                ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
                System.arraycopy(this.A.a(), 0, forumInfoDataArr, 0, min);
                this.A.e(min);
                this.A.f(forumInfoDataArr);
                this.y = false;
                this.mViewHolder.n.setText(getPageContext().getString(R.string.flist_expand_list));
                this.mViewHolder.o.setImageDrawable(this.k);
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
            this.D.LoadData();
            if (this.o == 0) {
                a2 = this.A.a();
            } else {
                a2 = this.B.a();
            }
            this.p.setLoadDataCallBack(new g(this, a2));
            if (this.o == 0) {
                LikeModel likeModel = this.p;
                int i4 = this.A.f18692f;
                likeModel.L(a2[i4].forum_name, String.valueOf(a2[i4].forum_id));
                return;
            }
            LikeModel likeModel2 = this.p;
            int i5 = this.B.f18692f;
            likeModel2.L(a2[i5].forum_name, String.valueOf(a2[i5].forum_id));
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            getLayoutMode().k(i2 == 1);
            getLayoutMode().j(this.mViewHolder.f18705a);
            this.mViewHolder.f18710f.onChangeSkinType(getPageContext(), i2);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.A.d(true);
                this.B.d(true);
            } else {
                this.A.d(false);
                this.B.d(false);
            }
            this.A.notifyDataSetChanged();
            this.B.notifyDataSetChanged();
            PopupWindow popupWindow = this.mViewHolder.u;
            if (popupWindow != null) {
                popupWindow.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_allsproutpop_dropdown));
            }
            SkinManager.setBackgroundResource(this.mViewHolder.f18709e, R.drawable.bg_pop_most);
            this.f56891e = SkinManager.getColor(R.color.common_color_10243);
            this.f56892f = SkinManager.getColor(R.color.CAM_X0101);
            this.f56893g = SkinManager.getDrawable(R.drawable.btn_pop_most_left_n);
            this.f56894h = SkinManager.getDrawable(R.drawable.btn_pop_most_right_n);
            this.f56895i = SkinManager.getDrawable(R.drawable.btn_pop_most_left_s);
            this.f56896j = SkinManager.getDrawable(R.drawable.btn_pop_most_right_s);
            this.k = SkinManager.getDrawable(R.drawable.ico_downward);
            this.l = SkinManager.getDrawable(R.drawable.ico_upward);
            this.A.i(R.drawable.btn_add_end, R.drawable.btn_add);
            this.B.i(R.drawable.btn_add_end, R.drawable.btn_add);
            SkinManager.setBackgroundResource(this.mViewHolder.f18707c, R.drawable.bg_black_banner_down);
            SkinManager.setViewTextColor(this.mViewHolder.q, R.color.common_color_10243, 1);
            SkinManager.setBackgroundResource(this.mViewHolder.f18706b, R.drawable.bg_black_banner_down);
            SkinManager.setViewTextColor(this.mViewHolder.n, R.color.common_color_10243, 1);
            if (this.y) {
                SkinManager.setImageResource(this.mViewHolder.o, R.drawable.ico_upward);
            } else {
                SkinManager.setImageResource(this.mViewHolder.o, R.drawable.ico_downward);
            }
            if (this.z) {
                SkinManager.setImageResource(this.mViewHolder.r, R.drawable.ico_upward);
            } else {
                SkinManager.setImageResource(this.mViewHolder.r, R.drawable.ico_downward);
            }
            if (this.mViewHolder.f18708d.getCurrentItem() == 0) {
                this.mViewHolder.k.setTextColor(this.f56892f);
                this.mViewHolder.k.setBackgroundDrawable(this.f56895i);
                this.mViewHolder.l.setBackgroundDrawable(this.f56894h);
                this.mViewHolder.l.setTextColor(this.f56891e);
                return;
            }
            this.mViewHolder.l.setTextColor(this.f56892f);
            this.mViewHolder.l.setBackgroundDrawable(this.f56896j);
            this.mViewHolder.k.setBackgroundDrawable(this.f56893g);
            this.mViewHolder.k.setTextColor(this.f56891e);
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            int id = view.getId();
            if (id == R.id.tab_recommends) {
                this.mViewHolder.f18708d.setCurrentItem(0);
                this.o = 0;
                TiebaStatic.eventStat(view.getContext(), "recommend_list_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            } else if (id == R.id.tab_hot) {
                this.mViewHolder.f18708d.setCurrentItem(1);
                this.o = 1;
                TiebaStatic.eventStat(view.getContext(), "hot_list_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            } else if (id == R.id.title_menu) {
                this.mViewHolder.f(this.G);
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
            String stringExtra = getIntent().getStringExtra("parent_menu_name");
            String stringExtra2 = getIntent().getStringExtra(KEY_LEVEL_2_MENU_NAME);
            String stringExtra3 = getIntent().getStringExtra("parent_menu_id");
            String stringExtra4 = getIntent().getStringExtra("menu_type");
            c.a.r0.g3.h.c cVar = new c.a.r0.g3.h.c(this);
            this.mViewHolder = cVar;
            cVar.f18713i = (BdListView) V();
            this.mViewHolder.f18714j = (BdListView) U();
            this.mViewHolder.A.setVisibility(0);
            this.mViewHolder.z.setOnClickListener(null);
            this.mViewHolder.z.setClickable(false);
            this.mViewHolder.f18708d.setAdapter(new h(this));
            c.a.r0.g3.h.c cVar2 = this.mViewHolder;
            cVar2.f18713i.setPullRefresh(cVar2.s);
            c.a.r0.g3.h.c cVar3 = this.mViewHolder;
            cVar3.f18714j.setPullRefresh(cVar3.t);
            if (c.a.e.e.m.b.e(stringExtra3, 0) != 0) {
                g2 = l.g(getActivity(), R.dimen.ds98);
            } else {
                g2 = l.g(getActivity(), R.dimen.ds176);
            }
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + g2));
            this.mViewHolder.f18713i.addHeaderView(textView, 0);
            TextView textView2 = new TextView(getActivity());
            textView2.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + g2));
            this.mViewHolder.f18714j.addHeaderView(textView2, 0);
            c.a.r0.g3.h.b bVar = new c.a.r0.g3.h.b(getPageContext(), 0);
            this.A = bVar;
            this.mViewHolder.f18713i.setAdapter((ListAdapter) bVar);
            c.a.r0.g3.h.b bVar2 = new c.a.r0.g3.h.b(getPageContext(), 1);
            this.B = bVar2;
            this.mViewHolder.f18714j.setAdapter((ListAdapter) bVar2);
            S(stringExtra, stringExtra3, stringExtra4, stringExtra2);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            LikeModel likeModel = this.p;
            if (likeModel != null) {
                likeModel.I();
            }
            this.mViewHolder.f18708d.setAdapter(null);
            this.mViewHolder.f18714j.setAdapter((ListAdapter) null);
            this.mViewHolder.f18713i.setAdapter((ListAdapter) null);
            ListView listView = this.mViewHolder.x;
            if (listView != null) {
                listView.setAdapter((ListAdapter) null);
            }
            DirMenuModel dirMenuModel = this.C;
            if (dirMenuModel != null) {
                dirMenuModel.cancelLoadData();
            }
            ForumListDetailModel forumListDetailModel = this.D;
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
        if (!(interceptable == null || interceptable.invokeI(1048591, this, i2) == null) || this.q) {
            return;
        }
        if (i2 == 0) {
            this.A.k();
            this.A.notifyDataSetChanged();
            this.mViewHolder.k.setBackgroundDrawable(this.f56895i);
            this.mViewHolder.k.setTextColor(this.f56892f);
            this.mViewHolder.l.setBackgroundDrawable(this.f56894h);
            this.mViewHolder.l.setTextColor(this.f56891e);
        } else if (i2 == 1) {
            this.B.k();
            this.B.notifyDataSetChanged();
            this.mViewHolder.l.setBackgroundDrawable(this.f56896j);
            this.mViewHolder.l.setTextColor(this.f56892f);
            this.mViewHolder.k.setBackgroundDrawable(this.f56893g);
            this.mViewHolder.k.setTextColor(this.f56891e);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            if (isNeedRefreshOnBackFromBarDetail) {
                isNeedRefreshOnBackFromBarDetail = false;
                finish();
                startLevel2ForumListActivity(getPageContext().getPageActivity(), I, K, J, L);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                return;
            }
            c.a.r0.g3.h.b bVar = this.A;
            if (bVar != null) {
                bVar.k();
                this.A.notifyDataSetChanged();
            }
            c.a.r0.g3.h.b bVar2 = this.B;
            if (bVar2 != null) {
                bVar2.k();
                this.B.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i extends BdAsyncTask<Void, Void, ForumListModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f56906a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f56907b;

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
            this.f56907b = forumListActivity;
            this.f56906a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumListModel doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                try {
                    this.f56907b.x.recommend_type = 2;
                    this.f56907b.x.offset = 0;
                    this.f56907b.x.rn = this.f56907b.n;
                    return ForumListModel.new_fetch(this.f56907b.x);
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
                    int min = Math.min(list.forum_list.length, this.f56907b.recommend_list_right.forum_list.length);
                    System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.f56907b.recommend_list_right.forum_list, 0, min);
                    this.f56907b.B.e(min);
                    this.f56907b.B.f(this.f56907b.recommend_list_right.forum_list);
                    if (this.f56907b.n == 200) {
                        ForumListActivity forumListActivity = this.f56907b;
                        forumListActivity.mViewHolder.q.setText(forumListActivity.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity2 = this.f56907b;
                        forumListActivity2.mViewHolder.r.setImageDrawable(forumListActivity2.k);
                    } else {
                        ForumListActivity forumListActivity3 = this.f56907b;
                        forumListActivity3.mViewHolder.q.setText(forumListActivity3.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity forumListActivity4 = this.f56907b;
                        forumListActivity4.mViewHolder.r.setImageDrawable(forumListActivity4.l);
                        this.f56907b.z = true;
                    }
                } else {
                    ForumListActivity forumListActivity5 = this.f56907b;
                    forumListActivity5.showToast(forumListActivity5.getPageContext().getString(R.string.neterror));
                    if (!this.f56906a) {
                        if (this.f56907b.n == 200) {
                            ForumListActivity forumListActivity6 = this.f56907b;
                            forumListActivity6.mViewHolder.q.setText(forumListActivity6.getPageContext().getString(R.string.flist_expand_list));
                            ForumListActivity forumListActivity7 = this.f56907b;
                            forumListActivity7.mViewHolder.r.setImageDrawable(forumListActivity7.k);
                        } else {
                            ForumListActivity forumListActivity8 = this.f56907b;
                            forumListActivity8.mViewHolder.q.setText(forumListActivity8.getPageContext().getString(R.string.flist_collapse_list));
                            ForumListActivity forumListActivity9 = this.f56907b;
                            forumListActivity9.mViewHolder.r.setImageDrawable(forumListActivity9.l);
                        }
                    } else {
                        ForumListActivity forumListActivity10 = this.f56907b;
                        forumListActivity10.mViewHolder.q.setText(forumListActivity10.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity11 = this.f56907b;
                        forumListActivity11.mViewHolder.r.setImageDrawable(forumListActivity11.k);
                        this.f56907b.x.rn = 200;
                        this.f56907b.n = 200;
                    }
                }
                this.f56907b.mViewHolder.p.setEnabled(true);
                this.f56907b.mViewHolder.d();
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f56906a = z;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f56907b.mViewHolder.p.setEnabled(false);
                ForumListActivity forumListActivity = this.f56907b;
                forumListActivity.mViewHolder.q.setText(forumListActivity.getPageContext().getString(R.string.flist_loading));
            }
        }

        public /* synthetic */ i(ForumListActivity forumListActivity, a aVar) {
            this(forumListActivity);
        }
    }

    /* loaded from: classes7.dex */
    public class j extends BdAsyncTask<Void, Void, ForumListModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f56908a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ForumListActivity f56909b;

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
            this.f56909b = forumListActivity;
            this.f56908a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumListModel doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                try {
                    this.f56909b.x.recommend_type = 1;
                    this.f56909b.x.offset = 0;
                    this.f56909b.x.rn = this.f56909b.m;
                    return ForumListModel.new_fetch(this.f56909b.x);
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
                    int min = Math.min(list.forum_list.length, this.f56909b.recommend_list_left.forum_list.length);
                    System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.f56909b.recommend_list_left.forum_list, 0, min);
                    this.f56909b.A.e(min);
                    this.f56909b.A.f(this.f56909b.recommend_list_left.forum_list);
                    if (this.f56909b.m == 200) {
                        ForumListActivity forumListActivity = this.f56909b;
                        forumListActivity.mViewHolder.n.setText(forumListActivity.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity2 = this.f56909b;
                        forumListActivity2.mViewHolder.o.setImageDrawable(forumListActivity2.k);
                    } else {
                        ForumListActivity forumListActivity3 = this.f56909b;
                        forumListActivity3.mViewHolder.n.setText(forumListActivity3.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity forumListActivity4 = this.f56909b;
                        forumListActivity4.mViewHolder.o.setImageDrawable(forumListActivity4.l);
                        this.f56909b.y = true;
                    }
                } else {
                    ForumListActivity forumListActivity5 = this.f56909b;
                    forumListActivity5.showToast(forumListActivity5.getPageContext().getString(R.string.neterror));
                    if (!this.f56908a) {
                        if (this.f56909b.m == 200) {
                            ForumListActivity forumListActivity6 = this.f56909b;
                            forumListActivity6.mViewHolder.n.setText(forumListActivity6.getPageContext().getString(R.string.flist_expand_list));
                            ForumListActivity forumListActivity7 = this.f56909b;
                            forumListActivity7.mViewHolder.o.setImageDrawable(forumListActivity7.k);
                        } else {
                            ForumListActivity forumListActivity8 = this.f56909b;
                            forumListActivity8.mViewHolder.n.setText(forumListActivity8.getPageContext().getString(R.string.flist_collapse_list));
                            ForumListActivity forumListActivity9 = this.f56909b;
                            forumListActivity9.mViewHolder.o.setImageDrawable(forumListActivity9.l);
                        }
                    } else {
                        ForumListActivity forumListActivity10 = this.f56909b;
                        forumListActivity10.mViewHolder.n.setText(forumListActivity10.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity11 = this.f56909b;
                        forumListActivity11.mViewHolder.o.setImageDrawable(forumListActivity11.k);
                        this.f56909b.x.rn = 200;
                        this.f56909b.m = 200;
                    }
                }
                this.f56909b.mViewHolder.m.setEnabled(true);
                this.f56909b.mViewHolder.d();
            }
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f56908a = z;
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.f56909b.mViewHolder.m.setEnabled(false);
                ForumListActivity forumListActivity = this.f56909b;
                forumListActivity.mViewHolder.n.setText(forumListActivity.getPageContext().getString(R.string.flist_loading));
            }
        }

        public /* synthetic */ j(ForumListActivity forumListActivity, a aVar) {
            this(forumListActivity);
        }
    }
}
