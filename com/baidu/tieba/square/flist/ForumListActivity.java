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
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.az4;
import com.baidu.tieba.ch;
import com.baidu.tieba.lp8;
import com.baidu.tieba.lr8;
import com.baidu.tieba.mp8;
import com.baidu.tieba.np8;
import com.baidu.tieba.q9;
import com.baidu.tieba.sp8;
import com.baidu.tieba.square.data.ForumInfoData;
import com.baidu.tieba.square.flist.DirMenuModel;
import com.baidu.tieba.square.flist.ForumListDetailModel;
import com.baidu.tieba.square.flist.ForumListModel;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tq4;
import com.baidu.tieba.xg;
import com.baidu.tieba.xi;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ForumListActivity extends BaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean H = false;
    public static String I = "";
    public static String J = "";
    public static String K = "";
    public static String L = "";
    public transient /* synthetic */ FieldHolder $fh;
    public mp8 A;
    public DirMenuModel B;
    public ForumListDetailModel C;
    public final ForumListDetailModel.b D;
    public final DirMenuModel.c E;
    public final AdapterView.OnItemClickListener F;
    public final az4.g G;
    public int a;
    public int b;
    public Drawable c;
    public Drawable d;
    public Drawable e;
    public Drawable f;
    public Drawable g;
    public Drawable h;
    public int i;
    public int j;
    public ForumListModel.List k;
    public ForumListModel.List l;
    public int m;
    public final LikeModel n;
    public boolean o;
    public int p;
    public boolean q;
    public int r;
    public int s;
    public boolean t;
    public boolean u;
    public np8 v;
    public ForumListModel.RequestParams w;
    public boolean x;
    public boolean y;
    public mp8 z;

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

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements ForumListDetailModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumListActivity a;

        public a(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumListActivity;
        }

        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.b
        public void a(boolean z, int i, ForumListModel forumListModel, String str, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), forumListModel, str, Boolean.valueOf(z2)}) == null) {
                if (!z && this.a.z.a() == null) {
                    this.a.showToast(str);
                    this.a.v.e();
                    this.a.v.d();
                    if (this.a.w.menu_type == 2 && !z2) {
                        this.a.finish();
                    }
                    this.a.v.A.setVisibility(8);
                } else if (forumListModel != null && forumListModel.recommend_list_left != null && forumListModel.recommend_list_right != null && forumListModel.editor_recommend != null && forumListModel.forum_class != null) {
                    this.a.v.A.setVisibility(8);
                    if (this.a.q) {
                        ForumListActivity forumListActivity = this.a;
                        forumListActivity.v.n.setText(forumListActivity.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity2 = this.a;
                        forumListActivity2.v.o.setImageDrawable(forumListActivity2.g);
                        ForumListActivity forumListActivity3 = this.a;
                        forumListActivity3.v.q.setText(forumListActivity3.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity4 = this.a;
                        forumListActivity4.v.r.setImageDrawable(forumListActivity4.g);
                        this.a.q = false;
                    }
                    ForumListActivity forumListActivity5 = this.a;
                    forumListActivity5.v.g.setText(forumListActivity5.w.menu_name);
                    ForumListActivity forumListActivity6 = this.a;
                    forumListActivity6.v.f.onChangeSkinType(forumListActivity6.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                    ForumListActivity forumListActivity7 = this.a;
                    forumListActivity7.v.y.d(forumListActivity7.p);
                    int min = Math.min(forumListModel.recommend_list_left.forum_list.length, this.a.k.forum_list.length);
                    int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, this.a.l.forum_list.length);
                    System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.a.k.forum_list, 0, min);
                    System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.a.l.forum_list, 0, min2);
                    this.a.z.e(min);
                    this.a.z.j(this.a.n);
                    this.a.z.f(this.a.k.forum_list);
                    this.a.v.i.setSelection(0);
                    if (forumListModel.recommend_list_left.has_more == 1) {
                        this.a.v.b.setVisibility(0);
                    } else {
                        this.a.v.b.setVisibility(8);
                    }
                    this.a.v.k.setText(forumListModel.forum_class[0]);
                    this.a.A.e(min2);
                    this.a.A.j(this.a.n);
                    this.a.A.f(this.a.l.forum_list);
                    this.a.v.j.setSelection(0);
                    if (forumListModel.recommend_list_right.has_more == 1) {
                        this.a.v.c.setVisibility(0);
                    } else {
                        this.a.v.c.setVisibility(8);
                    }
                    this.a.v.l.setText(forumListModel.forum_class[1]);
                    this.a.findViewById(R.id.item_root).setVisibility(0);
                    this.a.v.d();
                    if (this.a.v.y.getCount() > 0) {
                        this.a.v.z.setClickable(true);
                        ForumListActivity forumListActivity8 = this.a;
                        forumListActivity8.v.z.setOnClickListener(forumListActivity8);
                    }
                } else {
                    if (this.a.w.menu_type == 2 && !z2) {
                        ForumListActivity forumListActivity9 = this.a;
                        forumListActivity9.showToast(forumListActivity9.getPageContext().getString(R.string.no_forum_data));
                        this.a.finish();
                    } else {
                        this.a.showToast(str);
                        this.a.v.d();
                        this.a.w.recommend_type = this.a.r;
                        this.a.w.rn = this.a.s;
                    }
                    this.a.v.A.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements DirMenuModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumListActivity a;

        public b(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumListActivity;
        }

        @Override // com.baidu.tieba.square.flist.DirMenuModel.c
        public void a(boolean z, int i, sp8 sp8Var, String str, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), sp8Var, str, Boolean.valueOf(z2)}) == null) {
                if (z && i == 0) {
                    sp8Var.e.add(0, sp8Var);
                    lp8 lp8Var = this.a.v.y;
                    if (lp8Var != null) {
                        lp8Var.e(sp8Var);
                        ForumListActivity forumListActivity = this.a;
                        forumListActivity.h2(String.valueOf(forumListActivity.v.g.getText()));
                        ForumListActivity forumListActivity2 = this.a;
                        forumListActivity2.v.f.onChangeSkinType(forumListActivity2.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                        this.a.v.y.notifyDataSetChanged();
                    }
                    this.a.v.z.setClickable(true);
                    ForumListActivity forumListActivity3 = this.a;
                    forumListActivity3.v.z.setOnClickListener(forumListActivity3);
                } else if (!z2) {
                    this.a.v.e();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumListActivity a;

        public c(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumListActivity;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
                ForumListActivity forumListActivity = this.a;
                ch.d(forumListActivity.v.u, forumListActivity.getPageContext().getPageActivity());
                this.a.p = i;
                this.a.v.e();
                this.a.v.h();
                ArrayList<sp8> arrayList = this.a.v.y.c().e;
                this.a.d2(arrayList.get(i).b, arrayList.get(i).c, arrayList.get(i).a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements az4.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumListActivity a;

        public d(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumListActivity;
        }

        @Override // com.baidu.tieba.az4.g
        public void e(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048576, this, z) == null) && !this.a.z.c() && !this.a.A.c()) {
                if (this.a.t) {
                    this.a.w.recommend_type = 0;
                    this.a.w.rn = 200;
                    this.a.C.O(this.a.w);
                    this.a.C.loadData();
                    this.a.t = false;
                } else if (this.a.v.d.getCurrentItem() == 0) {
                    if (this.a.x) {
                        this.a.i = 50;
                    } else {
                        this.a.i = 200;
                    }
                    new j(this.a, null).execute(new Void[0]);
                } else if (this.a.v.d.getCurrentItem() == 1) {
                    if (this.a.y) {
                        this.a.j = 50;
                    } else {
                        this.a.j = 200;
                    }
                    new i(this.a, null).execute(new Void[0]);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumListActivity a;

        public e(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.x1();
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumListActivity a;

        public f(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumListActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.v1();
        }
    }

    /* loaded from: classes6.dex */
    public class g extends q9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumInfoData[] a;
        public final /* synthetic */ ForumListActivity b;

        public g(ForumListActivity forumListActivity, ForumInfoData[] forumInfoDataArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity, forumInfoDataArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = forumListActivity;
            this.a = forumInfoDataArr;
        }

        @Override // com.baidu.tieba.q9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (this.b.n.getErrorCode() == 22) {
                    ForumListActivity forumListActivity = this.b;
                    forumListActivity.showToast(forumListActivity.getPageContext().getString(R.string.had_liked_forum));
                } else if (obj == null) {
                } else {
                    if (this.b.n.getErrorCode() != 0) {
                        ForumListActivity forumListActivity2 = this.b;
                        forumListActivity2.showToast(forumListActivity2.n.getErrorString());
                    } else if (((lr8) obj).m() == 1) {
                        if (this.b.m == 0) {
                            this.b.z.notifyDataSetChanged();
                            TbadkCoreApplication.getInst().addLikeForum(this.a[this.b.z.b].forum_name);
                        } else if (this.b.m == 1) {
                            this.b.A.notifyDataSetChanged();
                            TbadkCoreApplication.getInst().addLikeForum(this.a[this.b.A.b].forum_name);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumListActivity a;

        public h(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumListActivity;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i, obj) == null) {
                viewGroup.removeView((View) obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.o) {
                    return 1;
                }
                return 2;
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                if (i != 0) {
                    if (i != 1) {
                        return null;
                    }
                    viewGroup.addView(this.a.v.j);
                    return this.a.v.j;
                }
                viewGroup.addView(this.a.v.i);
                return this.a.v.i;
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, obj)) == null) {
                return view2.equals(obj);
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class i extends BdAsyncTask<Void, Void, ForumListModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ ForumListActivity b;

        public i(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = forumListActivity;
            this.a = false;
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.a = z;
            }
        }

        public /* synthetic */ i(ForumListActivity forumListActivity, a aVar) {
            this(forumListActivity);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumListModel doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                try {
                    this.b.w.recommend_type = 2;
                    this.b.w.offset = 0;
                    this.b.w.rn = this.b.j;
                    return ForumListModel.new_fetch(this.b.w);
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
                    int min = Math.min(list.forum_list.length, this.b.l.forum_list.length);
                    System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, this.b.l.forum_list, 0, min);
                    this.b.A.e(min);
                    this.b.A.f(this.b.l.forum_list);
                    if (this.b.j == 200) {
                        ForumListActivity forumListActivity = this.b;
                        forumListActivity.v.q.setText(forumListActivity.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity2 = this.b;
                        forumListActivity2.v.r.setImageDrawable(forumListActivity2.g);
                    } else {
                        ForumListActivity forumListActivity3 = this.b;
                        forumListActivity3.v.q.setText(forumListActivity3.getPageContext().getString(R.string.obfuscated_res_0x7f0f065c));
                        ForumListActivity forumListActivity4 = this.b;
                        forumListActivity4.v.r.setImageDrawable(forumListActivity4.h);
                        this.b.y = true;
                    }
                } else {
                    ForumListActivity forumListActivity5 = this.b;
                    forumListActivity5.showToast(forumListActivity5.getPageContext().getString(R.string.obfuscated_res_0x7f0f0cb8));
                    if (this.a) {
                        ForumListActivity forumListActivity6 = this.b;
                        forumListActivity6.v.q.setText(forumListActivity6.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity7 = this.b;
                        forumListActivity7.v.r.setImageDrawable(forumListActivity7.g);
                        this.b.w.rn = 200;
                        this.b.j = 200;
                    } else if (this.b.j == 200) {
                        ForumListActivity forumListActivity8 = this.b;
                        forumListActivity8.v.q.setText(forumListActivity8.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity9 = this.b;
                        forumListActivity9.v.r.setImageDrawable(forumListActivity9.g);
                    } else {
                        ForumListActivity forumListActivity10 = this.b;
                        forumListActivity10.v.q.setText(forumListActivity10.getPageContext().getString(R.string.obfuscated_res_0x7f0f065c));
                        ForumListActivity forumListActivity11 = this.b;
                        forumListActivity11.v.r.setImageDrawable(forumListActivity11.h);
                    }
                }
                this.b.v.p.setEnabled(true);
                this.b.v.d();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.b.v.p.setEnabled(false);
                ForumListActivity forumListActivity = this.b;
                forumListActivity.v.q.setText(forumListActivity.getPageContext().getString(R.string.flist_loading));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j extends BdAsyncTask<Void, Void, ForumListModel> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final /* synthetic */ ForumListActivity b;

        public j(ForumListActivity forumListActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumListActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = forumListActivity;
            this.a = false;
        }

        public void d(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.a = z;
            }
        }

        public /* synthetic */ j(ForumListActivity forumListActivity, a aVar) {
            this(forumListActivity);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumListModel doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                try {
                    this.b.w.recommend_type = 1;
                    this.b.w.offset = 0;
                    this.b.w.rn = this.b.i;
                    return ForumListModel.new_fetch(this.b.w);
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
                    int min = Math.min(list.forum_list.length, this.b.k.forum_list.length);
                    System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, this.b.k.forum_list, 0, min);
                    this.b.z.e(min);
                    this.b.z.f(this.b.k.forum_list);
                    if (this.b.i == 200) {
                        ForumListActivity forumListActivity = this.b;
                        forumListActivity.v.n.setText(forumListActivity.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity2 = this.b;
                        forumListActivity2.v.o.setImageDrawable(forumListActivity2.g);
                    } else {
                        ForumListActivity forumListActivity3 = this.b;
                        forumListActivity3.v.n.setText(forumListActivity3.getPageContext().getString(R.string.obfuscated_res_0x7f0f065c));
                        ForumListActivity forumListActivity4 = this.b;
                        forumListActivity4.v.o.setImageDrawable(forumListActivity4.h);
                        this.b.x = true;
                    }
                } else {
                    ForumListActivity forumListActivity5 = this.b;
                    forumListActivity5.showToast(forumListActivity5.getPageContext().getString(R.string.obfuscated_res_0x7f0f0cb8));
                    if (this.a) {
                        ForumListActivity forumListActivity6 = this.b;
                        forumListActivity6.v.n.setText(forumListActivity6.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity7 = this.b;
                        forumListActivity7.v.o.setImageDrawable(forumListActivity7.g);
                        this.b.w.rn = 200;
                        this.b.i = 200;
                    } else if (this.b.i == 200) {
                        ForumListActivity forumListActivity8 = this.b;
                        forumListActivity8.v.n.setText(forumListActivity8.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity9 = this.b;
                        forumListActivity9.v.o.setImageDrawable(forumListActivity9.g);
                    } else {
                        ForumListActivity forumListActivity10 = this.b;
                        forumListActivity10.v.n.setText(forumListActivity10.getPageContext().getString(R.string.obfuscated_res_0x7f0f065c));
                        ForumListActivity forumListActivity11 = this.b;
                        forumListActivity11.v.o.setImageDrawable(forumListActivity11.h);
                    }
                }
                this.b.v.m.setEnabled(true);
                this.b.v.d();
            }
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.b.v.m.setEnabled(false);
                ForumListActivity forumListActivity = this.b;
                forumListActivity.v.n.setText(forumListActivity.getPageContext().getString(R.string.flist_loading));
            }
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
        this.i = 200;
        this.j = 200;
        this.m = 0;
        this.n = new LikeModel(getPageContext());
        this.o = false;
        this.p = 0;
        this.q = false;
        this.r = 0;
        this.s = 200;
        this.t = true;
        this.u = true;
        this.x = false;
        this.y = false;
        this.D = new a(this);
        this.E = new b(this);
        this.F = new c(this);
        this.G = new d(this);
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.y) {
                int min = Math.min(this.A.getCount(), 200);
                this.j = 200;
                ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
                System.arraycopy(this.A.a(), 0, forumInfoDataArr, 0, min);
                this.A.e(min);
                this.A.f(forumInfoDataArr);
                this.y = false;
                this.v.q.setText(getPageContext().getString(R.string.flist_expand_list));
                this.v.r.setImageDrawable(this.g);
                return;
            }
            this.j = 50;
            i iVar = new i(this, null);
            iVar.d(true);
            iVar.execute(new Void[0]);
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.x) {
                int min = Math.min(this.z.getCount(), 200);
                this.i = 200;
                ForumInfoData[] forumInfoDataArr = new ForumInfoData[min];
                System.arraycopy(this.z.a(), 0, forumInfoDataArr, 0, min);
                this.z.e(min);
                this.z.f(forumInfoDataArr);
                this.x = false;
                this.v.n.setText(getPageContext().getString(R.string.flist_expand_list));
                this.v.o.setImageDrawable(this.g);
                return;
            }
            this.i = 50;
            j jVar = new j(this, null);
            jVar.d(true);
            jVar.execute(new Void[0]);
        }
    }

    public static void g2(Context context, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65565, null, context, str, str2, str3, str4) == null) {
            Intent intent = new Intent(context, ForumListActivity.class);
            intent.putExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME, str);
            intent.putExtra(ForumListActivityConfig.KEY_MENU_TYPE, str2);
            intent.putExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID, str3);
            intent.putExtra("level_2_menu_name", str4);
            if (!(context instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            context.startActivity(intent);
        }
    }

    public final BdListView b2() {
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onDestroy();
            LikeModel likeModel = this.n;
            if (likeModel != null) {
                likeModel.T();
            }
            this.v.d.setAdapter(null);
            this.v.j.setAdapter((ListAdapter) null);
            this.v.i.setAdapter((ListAdapter) null);
            ListView listView = this.v.x;
            if (listView != null) {
                listView.setAdapter((ListAdapter) null);
            }
            DirMenuModel dirMenuModel = this.B;
            if (dirMenuModel != null) {
                dirMenuModel.cancelLoadData();
            }
            ForumListDetailModel forumListDetailModel = this.C;
            if (forumListDetailModel != null) {
                forumListDetailModel.cancelLoadData();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onResume();
            if (H) {
                H = false;
                finish();
                g2(getPageContext().getPageActivity(), I, K, J, L);
                return;
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                mp8 mp8Var = this.z;
                if (mp8Var != null) {
                    mp8Var.k();
                    this.z.notifyDataSetChanged();
                }
                mp8 mp8Var2 = this.A;
                if (mp8Var2 != null) {
                    mp8Var2.k();
                    this.A.notifyDataSetChanged();
                }
            }
        }
    }

    public final void c2(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            if (xi.isEmpty(str4)) {
                str4 = str;
            }
            this.v.g.setText(str4);
            this.v.f.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            ForumListModel.RequestParams requestParams = new ForumListModel.RequestParams();
            this.w = requestParams;
            requestParams.menu_id = xg.e(str2, 0);
            ForumListModel.RequestParams requestParams2 = this.w;
            requestParams2.menu_name = str4;
            requestParams2.menu_type = xg.e(str3, 0);
            this.w.parent_menu_id = xg.e(str2, 0);
            ForumListModel.RequestParams requestParams3 = this.w;
            requestParams3.parent_menu_name = str;
            requestParams3.offset = 0;
            requestParams3.rn = 10;
            if (requestParams3.menu_id != 0) {
                this.v.c();
                this.o = true;
                this.u = false;
                this.z.h(false);
                this.v.d.getAdapter().notifyDataSetChanged();
            } else {
                this.u = true;
                this.z.h(true);
                this.v.g();
            }
            this.k = new ForumListModel.List();
            ForumListModel.List list = new ForumListModel.List();
            this.l = list;
            this.k.forum_list = new ForumInfoData[50];
            list.forum_list = new ForumInfoData[50];
            this.v.s.f(this.G);
            this.v.t.f(this.G);
            this.z.notifyDataSetChanged();
            this.A.notifyDataSetChanged();
            if (str3.equals("2")) {
                this.v.e();
            } else {
                DirMenuModel dirMenuModel = new DirMenuModel(getPageContext(), str, str3, str2);
                this.B = dirMenuModel;
                dirMenuModel.O(this.E);
                this.B.loadData();
            }
            ForumListDetailModel forumListDetailModel = new ForumListDetailModel(getPageContext(), this.w);
            this.C = forumListDetailModel;
            forumListDetailModel.N(this.D);
            this.v.i.F();
        }
    }

    public final void d2(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3) == null) {
            this.w.menu_id = xg.e(str2, 0);
            ForumListModel.RequestParams requestParams = this.w;
            requestParams.menu_name = str;
            requestParams.menu_type = xg.e(str3, 0);
            this.w.parent_menu_id = xg.e(getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID), 0);
            this.w.parent_menu_name = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
            ForumListModel.RequestParams requestParams2 = this.w;
            requestParams2.offset = 0;
            requestParams2.rn = 10;
            this.r = requestParams2.recommend_type;
            this.s = 10;
            requestParams2.recommend_type = 0;
            requestParams2.rn = 200;
            this.q = true;
            this.C.O(requestParams2);
            this.C.loadData();
        }
    }

    public final View e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.v.j = b2();
            this.v.p.setOnClickListener(new f(this));
            return this.v.j;
        }
        return (View) invokeV.objValue;
    }

    public final View f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            this.v.i = b2();
            this.v.m.setOnClickListener(new e(this));
            return this.v.i;
        }
        return (View) invokeV.objValue;
    }

    public final void h2(String str) {
        sp8 c2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || (c2 = this.v.y.c()) == null) {
            return;
        }
        ArrayList<sp8> arrayList = c2.e;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (arrayList.get(i2).b.equals(str)) {
                this.p = i2;
                this.v.y.d(i2);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        ForumInfoData[] a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) && i2 == 11002 && i3 == -1) {
            this.C.loadData();
            if (this.m == 0) {
                a2 = this.z.a();
            } else {
                a2 = this.A.a();
            }
            this.n.setLoadDataCallBack(new g(this, a2));
            if (this.m == 0) {
                LikeModel likeModel = this.n;
                int i4 = this.z.b;
                likeModel.X(a2[i4].forum_name, String.valueOf(a2[i4].forum_id));
                return;
            }
            LikeModel likeModel2 = this.n;
            int i5 = this.A.b;
            likeModel2.X(a2[i5].forum_name, String.valueOf(a2[i5].forum_id));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            tq4 layoutMode = getLayoutMode();
            if (i2 == 1) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.l(z);
            getLayoutMode().k(this.v.a);
            this.v.f.onChangeSkinType(getPageContext(), i2);
            if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                this.z.d(true);
                this.A.d(true);
            } else {
                this.z.d(false);
                this.A.d(false);
            }
            this.z.notifyDataSetChanged();
            this.A.notifyDataSetChanged();
            PopupWindow popupWindow = this.v.u;
            if (popupWindow != null) {
                popupWindow.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_allsproutpop_dropdown));
            }
            SkinManager.setBackgroundResource(this.v.e, R.drawable.bg_pop_most);
            this.a = SkinManager.getColor(R.color.common_color_10243);
            this.b = SkinManager.getColor(R.color.CAM_X0101);
            this.c = SkinManager.getDrawable(R.drawable.btn_pop_most_left_n);
            this.d = SkinManager.getDrawable(R.drawable.btn_pop_most_right_n);
            this.e = SkinManager.getDrawable(R.drawable.btn_pop_most_left_s);
            this.f = SkinManager.getDrawable(R.drawable.btn_pop_most_right_s);
            this.g = SkinManager.getDrawable(R.drawable.ico_downward);
            this.h = SkinManager.getDrawable(R.drawable.ico_upward);
            this.z.i(R.drawable.btn_add_end, R.drawable.btn_add);
            this.A.i(R.drawable.btn_add_end, R.drawable.btn_add);
            SkinManager.setBackgroundResource(this.v.c, R.drawable.bg_black_banner_down);
            SkinManager.setViewTextColor(this.v.q, R.color.common_color_10243, 1);
            SkinManager.setBackgroundResource(this.v.b, R.drawable.bg_black_banner_down);
            SkinManager.setViewTextColor(this.v.n, R.color.common_color_10243, 1);
            if (this.x) {
                SkinManager.setImageResource(this.v.o, R.drawable.ico_upward);
            } else {
                SkinManager.setImageResource(this.v.o, R.drawable.ico_downward);
            }
            if (this.y) {
                SkinManager.setImageResource(this.v.r, R.drawable.ico_upward);
            } else {
                SkinManager.setImageResource(this.v.r, R.drawable.ico_downward);
            }
            if (this.v.d.getCurrentItem() == 0) {
                this.v.k.setTextColor(this.b);
                this.v.k.setBackgroundDrawable(this.e);
                this.v.l.setBackgroundDrawable(this.d);
                this.v.l.setTextColor(this.a);
                return;
            }
            this.v.l.setTextColor(this.b);
            this.v.l.setBackgroundDrawable(this.f);
            this.v.k.setBackgroundDrawable(this.c);
            this.v.k.setTextColor(this.a);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f0920e3) {
                this.v.d.setCurrentItem(0);
                this.m = 0;
                TiebaStatic.eventStat(view2.getContext(), "recommend_list_click", "click", 1, new Object[0]);
            } else if (id == R.id.obfuscated_res_0x7f0920dc) {
                this.v.d.setCurrentItem(1);
                this.m = 1;
                TiebaStatic.eventStat(view2.getContext(), "hot_list_click", "click", 1, new Object[0]);
            } else if (id == R.id.obfuscated_res_0x7f0922f1) {
                this.v.f(this.F);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int g2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d02b9);
            String stringExtra = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
            String stringExtra2 = getIntent().getStringExtra("level_2_menu_name");
            String stringExtra3 = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID);
            String stringExtra4 = getIntent().getStringExtra(ForumListActivityConfig.KEY_MENU_TYPE);
            np8 np8Var = new np8(this);
            this.v = np8Var;
            np8Var.i = (BdListView) f2();
            this.v.j = (BdListView) e2();
            this.v.A.setVisibility(0);
            this.v.z.setOnClickListener(null);
            this.v.z.setClickable(false);
            this.v.d.setAdapter(new h(this));
            np8 np8Var2 = this.v;
            np8Var2.i.setPullRefresh(np8Var2.s);
            np8 np8Var3 = this.v;
            np8Var3.j.setPullRefresh(np8Var3.t);
            if (xg.e(stringExtra3, 0) != 0) {
                g2 = yi.g(getActivity(), R.dimen.obfuscated_res_0x7f070282);
            } else {
                g2 = yi.g(getActivity(), R.dimen.obfuscated_res_0x7f07025d);
            }
            TextView textView = new TextView(getActivity());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + g2));
            this.v.i.x(textView, 0);
            TextView textView2 = new TextView(getActivity());
            textView2.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + g2));
            this.v.j.x(textView2, 0);
            mp8 mp8Var = new mp8(getPageContext(), 0);
            this.z = mp8Var;
            this.v.i.setAdapter((ListAdapter) mp8Var);
            mp8 mp8Var2 = new mp8(getPageContext(), 1);
            this.A = mp8Var2;
            this.v.j.setAdapter((ListAdapter) mp8Var2);
            c2(stringExtra, stringExtra3, stringExtra4, stringExtra2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048589, this, i2) != null) || this.o) {
            return;
        }
        if (i2 == 0) {
            this.z.k();
            this.z.notifyDataSetChanged();
            this.v.k.setBackgroundDrawable(this.e);
            this.v.k.setTextColor(this.b);
            this.v.l.setBackgroundDrawable(this.d);
            this.v.l.setTextColor(this.a);
        } else if (i2 == 1) {
            this.A.k();
            this.A.notifyDataSetChanged();
            this.v.l.setBackgroundDrawable(this.f);
            this.v.l.setTextColor(this.b);
            this.v.k.setBackgroundDrawable(this.c);
            this.v.k.setTextColor(this.a);
        }
    }
}
