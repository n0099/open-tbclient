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
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.ListView.BdListView;
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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.i0.r.f0.f;
import d.a.j0.d3.w;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ForumListActivity extends ProxyAdkBaseActivity<ForumListActivity> implements ViewPager.OnPageChangeListener {
    public static boolean L = false;
    public static String M = "";
    public static String N = "";
    public static String O = "";
    public static String P = "";
    public ForumListModel.RequestParams A;
    public d.a.j0.a3.h.b D;
    public d.a.j0.a3.h.b E;
    public DirMenuModel F;
    public ForumListDetailModel G;

    /* renamed from: e  reason: collision with root package name */
    public int f21450e;

    /* renamed from: f  reason: collision with root package name */
    public int f21451f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f21452g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f21453h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f21454i;
    public Drawable j;
    public Drawable k;
    public Drawable l;
    public ForumListModel.List o;
    public ForumListModel.List p;
    public d.a.j0.a3.h.c z;
    public int m = 200;
    public int n = 200;
    public int q = 0;
    public final LikeModel r = new LikeModel(getPageContext());
    public boolean s = false;
    public int t = 0;
    public boolean u = false;
    public int v = 0;
    public int w = 200;
    public boolean x = true;
    public boolean y = true;
    public boolean B = false;
    public boolean C = false;
    public final ForumListDetailModel.b H = new a();
    public final DirMenuModel.c I = new b();
    public final AdapterView.OnItemClickListener J = new c();
    public final f.g K = new d();

    /* loaded from: classes5.dex */
    public class a implements ForumListDetailModel.b {
        public a() {
        }

        @Override // com.baidu.tieba.square.flist.ForumListDetailModel.b
        public void a(boolean z, int i2, ForumListModel forumListModel, String str, boolean z2) {
            if (!z && ForumListActivity.this.D.a() == null) {
                ForumListActivity.this.showToast(str);
                ForumListActivity.this.z.e();
                ForumListActivity.this.z.d();
                if (ForumListActivity.this.A.menu_type == 2 && !z2) {
                    ForumListActivity.this.finish();
                }
                ForumListActivity.this.z.A.setVisibility(8);
            } else if (forumListModel == null || forumListModel.recommend_list_left == null || forumListModel.recommend_list_right == null || forumListModel.editor_recommend == null || forumListModel.forum_class == null) {
                if (ForumListActivity.this.A.menu_type == 2 && !z2) {
                    ForumListActivity forumListActivity = ForumListActivity.this;
                    forumListActivity.showToast(forumListActivity.getPageContext().getString(R.string.no_forum_data));
                    ForumListActivity.this.finish();
                } else {
                    ForumListActivity.this.showToast(str);
                    ForumListActivity.this.z.d();
                    ForumListActivity.this.A.recommend_type = ForumListActivity.this.v;
                    ForumListActivity.this.A.rn = ForumListActivity.this.w;
                }
                ForumListActivity.this.z.A.setVisibility(8);
            } else {
                ForumListActivity.this.z.A.setVisibility(8);
                if (ForumListActivity.this.u) {
                    ForumListActivity forumListActivity2 = ForumListActivity.this;
                    forumListActivity2.z.n.setText(forumListActivity2.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity forumListActivity3 = ForumListActivity.this;
                    forumListActivity3.z.o.setImageDrawable(forumListActivity3.k);
                    ForumListActivity forumListActivity4 = ForumListActivity.this;
                    forumListActivity4.z.q.setText(forumListActivity4.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity forumListActivity5 = ForumListActivity.this;
                    forumListActivity5.z.r.setImageDrawable(forumListActivity5.k);
                    ForumListActivity.this.u = false;
                }
                ForumListActivity forumListActivity6 = ForumListActivity.this;
                forumListActivity6.z.f51289g.setText(forumListActivity6.A.menu_name);
                ForumListActivity forumListActivity7 = ForumListActivity.this;
                forumListActivity7.z.f51288f.onChangeSkinType(forumListActivity7.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity forumListActivity8 = ForumListActivity.this;
                forumListActivity8.z.y.d(forumListActivity8.t);
                int min = Math.min(forumListModel.recommend_list_left.forum_list.length, ForumListActivity.this.o.forum_list.length);
                int min2 = Math.min(forumListModel.recommend_list_right.forum_list.length, ForumListActivity.this.p.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.o.forum_list, 0, min);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.p.forum_list, 0, min2);
                ForumListActivity.this.D.e(min);
                ForumListActivity.this.D.j(ForumListActivity.this.r);
                ForumListActivity.this.D.f(ForumListActivity.this.o.forum_list);
                ForumListActivity.this.z.f51291i.setSelection(0);
                if (forumListModel.recommend_list_left.has_more == 1) {
                    ForumListActivity.this.z.f51284b.setVisibility(0);
                } else {
                    ForumListActivity.this.z.f51284b.setVisibility(8);
                }
                ForumListActivity.this.z.k.setText(forumListModel.forum_class[0]);
                ForumListActivity.this.E.e(min2);
                ForumListActivity.this.E.j(ForumListActivity.this.r);
                ForumListActivity.this.E.f(ForumListActivity.this.p.forum_list);
                ForumListActivity.this.z.j.setSelection(0);
                if (forumListModel.recommend_list_right.has_more == 1) {
                    ForumListActivity.this.z.f51285c.setVisibility(0);
                } else {
                    ForumListActivity.this.z.f51285c.setVisibility(8);
                }
                ForumListActivity.this.z.l.setText(forumListModel.forum_class[1]);
                ForumListActivity.this.findViewById(R.id.item_root).setVisibility(0);
                ForumListActivity.this.z.d();
                if (ForumListActivity.this.z.y.getCount() > 0) {
                    ForumListActivity.this.z.z.setClickable(true);
                    ForumListActivity forumListActivity9 = ForumListActivity.this;
                    forumListActivity9.z.z.setOnClickListener(forumListActivity9);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DirMenuModel.c {
        public b() {
        }

        @Override // com.baidu.tieba.square.flist.DirMenuModel.c
        public void a(boolean z, int i2, d.a.j0.a3.j.d dVar, String str, boolean z2) {
            if (!z || i2 != 0) {
                if (z2) {
                    return;
                }
                ForumListActivity.this.z.e();
                return;
            }
            dVar.f51322e.add(0, dVar);
            d.a.j0.a3.h.a aVar = ForumListActivity.this.z.y;
            if (aVar != null) {
                aVar.e(dVar);
                ForumListActivity forumListActivity = ForumListActivity.this;
                forumListActivity.T(String.valueOf(forumListActivity.z.f51289g.getText()));
                ForumListActivity forumListActivity2 = ForumListActivity.this;
                forumListActivity2.z.f51288f.onChangeSkinType(forumListActivity2.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
                ForumListActivity.this.z.y.notifyDataSetChanged();
            }
            ForumListActivity.this.z.z.setClickable(true);
            ForumListActivity forumListActivity3 = ForumListActivity.this;
            forumListActivity3.z.z.setOnClickListener(forumListActivity3);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements AdapterView.OnItemClickListener {
        public c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            TiebaStatic.eventStat(ForumListActivity.this.getPageContext().getPageActivity(), "forumlist_catalog", "catalogclick", 1, new Object[0]);
            ForumListActivity forumListActivity = ForumListActivity.this;
            d.a.c.e.m.g.d(forumListActivity.z.u, forumListActivity.getPageContext().getPageActivity());
            ForumListActivity.this.t = i2;
            ForumListActivity.this.z.e();
            ForumListActivity.this.z.h();
            ArrayList<d.a.j0.a3.j.d> arrayList = ForumListActivity.this.z.y.c().f51322e;
            ForumListActivity.this.P(arrayList.get(i2).f51319b, arrayList.get(i2).f51320c, arrayList.get(i2).f51318a);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements f.g {
        public d() {
        }

        @Override // d.a.i0.r.f0.f.g
        public void onListPullRefresh(boolean z) {
            if (ForumListActivity.this.D.c() || ForumListActivity.this.E.c()) {
                return;
            }
            if (ForumListActivity.this.x) {
                ForumListActivity.this.A.recommend_type = 0;
                ForumListActivity.this.A.rn = 200;
                ForumListActivity.this.G.A(ForumListActivity.this.A);
                ForumListActivity.this.G.LoadData();
                ForumListActivity.this.x = false;
            } else if (ForumListActivity.this.z.f51286d.getCurrentItem() == 0) {
                if (ForumListActivity.this.B) {
                    ForumListActivity.this.m = 50;
                } else {
                    ForumListActivity.this.m = 200;
                }
                new j(ForumListActivity.this, null).execute(new Void[0]);
            } else if (ForumListActivity.this.z.f51286d.getCurrentItem() == 1) {
                if (ForumListActivity.this.C) {
                    ForumListActivity.this.n = 50;
                } else {
                    ForumListActivity.this.n = 200;
                }
                new i(ForumListActivity.this, null).execute(new Void[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ForumListActivity.this.g();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ForumListActivity.this.f();
        }
    }

    /* loaded from: classes5.dex */
    public class g extends d.a.c.a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumInfoData[] f21461a;

        public g(ForumInfoData[] forumInfoDataArr) {
            this.f21461a = forumInfoDataArr;
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (ForumListActivity.this.r.getErrorCode() == 22) {
                ForumListActivity forumListActivity = ForumListActivity.this;
                forumListActivity.showToast(forumListActivity.getPageContext().getString(R.string.had_liked_forum));
            } else if (obj == null) {
            } else {
                if (ForumListActivity.this.r.getErrorCode() != 0) {
                    ForumListActivity forumListActivity2 = ForumListActivity.this;
                    forumListActivity2.showToast(forumListActivity2.r.getErrorString());
                } else if (((w) obj).l() == 1) {
                    ForumListActivity forumListActivity3 = ForumListActivity.this;
                    forumListActivity3.showToast(forumListActivity3.getPageContext().getString(R.string.attention_success));
                    if (ForumListActivity.this.q == 0) {
                        ForumListActivity.this.D.notifyDataSetChanged();
                        TbadkCoreApplication.getInst().addLikeForum(this.f21461a[ForumListActivity.this.D.f51271f].forum_name);
                    } else if (ForumListActivity.this.q == 1) {
                        ForumListActivity.this.E.notifyDataSetChanged();
                        TbadkCoreApplication.getInst().addLikeForum(this.f21461a[ForumListActivity.this.E.f51271f].forum_name);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h extends PagerAdapter {
        public h() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ForumListActivity.this.s ? 1 : 2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                viewGroup.addView(ForumListActivity.this.z.f51291i);
                return ForumListActivity.this.z.f51291i;
            } else if (i2 != 1) {
                return null;
            } else {
                viewGroup.addView(ForumListActivity.this.z.j);
                return ForumListActivity.this.z.j;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view.equals(obj);
        }
    }

    public static void S(Context context, String str, String str2, String str3, String str4) {
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

    public final BdListView N() {
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

    public final void O(String str, String str2, String str3, String str4) {
        if (k.isEmpty(str4)) {
            str4 = str;
        }
        this.z.f51289g.setText(str4);
        this.z.f51288f.onChangeSkinType(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
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
            this.z.f51286d.getAdapter().notifyDataSetChanged();
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
            dirMenuModel.A(this.I);
            this.F.LoadData();
        }
        ForumListDetailModel forumListDetailModel = new ForumListDetailModel(getPageContext(), this.A);
        this.G = forumListDetailModel;
        forumListDetailModel.z(this.H);
        this.z.f51291i.F();
    }

    public final void P(String str, String str2, String str3) {
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
        this.G.A(requestParams2);
        this.G.LoadData();
    }

    public final View Q() {
        this.z.j = N();
        this.z.p.setOnClickListener(new f());
        return this.z.j;
    }

    public final View R() {
        this.z.f51291i = N();
        this.z.m.setOnClickListener(new e());
        return this.z.f51291i;
    }

    public final void T(String str) {
        d.a.j0.a3.j.d c2 = this.z.y.c();
        if (c2 == null) {
            return;
        }
        ArrayList<d.a.j0.a3.j.d> arrayList = c2.f51322e;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (arrayList.get(i2).f51319b.equals(str)) {
                this.t = i2;
                this.z.y.d(i2);
                return;
            }
        }
    }

    public final void f() {
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

    public final void g() {
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

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        ForumInfoData[] a2;
        if (i2 == 11002 && i3 == -1) {
            this.G.LoadData();
            if (this.q == 0) {
                a2 = this.D.a();
            } else {
                a2 = this.E.a();
            }
            this.r.setLoadDataCallBack(new g(a2));
            if (this.q == 0) {
                LikeModel likeModel = this.r;
                int i4 = this.D.f51271f;
                likeModel.H(a2[i4].forum_name, String.valueOf(a2[i4].forum_id));
                return;
            }
            LikeModel likeModel2 = this.r;
            int i5 = this.E.f51271f;
            likeModel2.H(a2[i5].forum_name, String.valueOf(a2[i5].forum_id));
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    @SuppressLint({"ResourceAsColor"})
    public void onChangeSkinType(int i2) {
        getLayoutMode().k(i2 == 1);
        getLayoutMode().j(this.z.f51283a);
        this.z.f51288f.onChangeSkinType(getPageContext(), i2);
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
        SkinManager.setBackgroundResource(this.z.f51287e, R.drawable.bg_pop_most);
        this.f21450e = SkinManager.getColor(R.color.common_color_10243);
        this.f21451f = SkinManager.getColor(R.color.CAM_X0101);
        this.f21452g = SkinManager.getDrawable(R.drawable.btn_pop_most_left_n);
        this.f21453h = SkinManager.getDrawable(R.drawable.btn_pop_most_right_n);
        this.f21454i = SkinManager.getDrawable(R.drawable.btn_pop_most_left_s);
        this.j = SkinManager.getDrawable(R.drawable.btn_pop_most_right_s);
        this.k = SkinManager.getDrawable(R.drawable.ico_downward);
        this.l = SkinManager.getDrawable(R.drawable.ico_upward);
        this.D.i(R.drawable.btn_add_end, R.drawable.btn_add);
        this.E.i(R.drawable.btn_add_end, R.drawable.btn_add);
        SkinManager.setBackgroundResource(this.z.f51285c, R.drawable.bg_black_banner_down);
        SkinManager.setViewTextColor(this.z.q, R.color.common_color_10243, 1);
        SkinManager.setBackgroundResource(this.z.f51284b, R.drawable.bg_black_banner_down);
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
        if (this.z.f51286d.getCurrentItem() == 0) {
            this.z.k.setTextColor(this.f21451f);
            this.z.k.setBackgroundDrawable(this.f21454i);
            this.z.l.setBackgroundDrawable(this.f21453h);
            this.z.l.setTextColor(this.f21450e);
            return;
        }
        this.z.l.setTextColor(this.f21451f);
        this.z.l.setBackgroundDrawable(this.j);
        this.z.k.setBackgroundDrawable(this.f21452g);
        this.z.k.setTextColor(this.f21450e);
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tab_recommends) {
            this.z.f51286d.setCurrentItem(0);
            this.q = 0;
            TiebaStatic.eventStat(view.getContext(), "recommend_list_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        } else if (id == R.id.tab_hot) {
            this.z.f51286d.setCurrentItem(1);
            this.q = 1;
            TiebaStatic.eventStat(view.getContext(), "hot_list_click", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
        } else if (id == R.id.title_menu) {
            this.z.f(this.J);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        int g2;
        super.onCreate(bundle);
        setContentView(R.layout.forum_list_activity);
        String stringExtra = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_NAME);
        String stringExtra2 = getIntent().getStringExtra("level_2_menu_name");
        String stringExtra3 = getIntent().getStringExtra(ForumListActivityConfig.KEY_PARENT_MENU_ID);
        String stringExtra4 = getIntent().getStringExtra(ForumListActivityConfig.KEY_MENU_TYPE);
        d.a.j0.a3.h.c cVar = new d.a.j0.a3.h.c(this);
        this.z = cVar;
        cVar.f51291i = (BdListView) R();
        this.z.j = (BdListView) Q();
        this.z.A.setVisibility(0);
        this.z.z.setOnClickListener(null);
        this.z.z.setClickable(false);
        this.z.f51286d.setAdapter(new h());
        d.a.j0.a3.h.c cVar2 = this.z;
        cVar2.f51291i.setPullRefresh(cVar2.s);
        d.a.j0.a3.h.c cVar3 = this.z;
        cVar3.j.setPullRefresh(cVar3.t);
        if (d.a.c.e.m.b.d(stringExtra3, 0) != 0) {
            g2 = l.g(getActivity(), R.dimen.ds98);
        } else {
            g2 = l.g(getActivity(), R.dimen.ds176);
        }
        TextView textView = new TextView(getActivity());
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + g2));
        this.z.f51291i.x(textView, 0);
        TextView textView2 = new TextView(getActivity());
        textView2.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + g2));
        this.z.j.x(textView2, 0);
        d.a.j0.a3.h.b bVar = new d.a.j0.a3.h.b(getPageContext(), 0);
        this.D = bVar;
        this.z.f51291i.setAdapter((ListAdapter) bVar);
        d.a.j0.a3.h.b bVar2 = new d.a.j0.a3.h.b(getPageContext(), 1);
        this.E = bVar2;
        this.z.j.setAdapter((ListAdapter) bVar2);
        O(stringExtra, stringExtra3, stringExtra4, stringExtra2);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        LikeModel likeModel = this.r;
        if (likeModel != null) {
            likeModel.E();
        }
        this.z.f51286d.setAdapter(null);
        this.z.j.setAdapter((ListAdapter) null);
        this.z.f51291i.setAdapter((ListAdapter) null);
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

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        if (this.s) {
            return;
        }
        if (i2 == 0) {
            this.D.k();
            this.D.notifyDataSetChanged();
            this.z.k.setBackgroundDrawable(this.f21454i);
            this.z.k.setTextColor(this.f21451f);
            this.z.l.setBackgroundDrawable(this.f21453h);
            this.z.l.setTextColor(this.f21450e);
        } else if (i2 == 1) {
            this.E.k();
            this.E.notifyDataSetChanged();
            this.z.l.setBackgroundDrawable(this.j);
            this.z.l.setTextColor(this.f21451f);
            this.z.k.setBackgroundDrawable(this.f21452g);
            this.z.k.setTextColor(this.f21450e);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onResume() {
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
        d.a.j0.a3.h.b bVar = this.D;
        if (bVar != null) {
            bVar.k();
            this.D.notifyDataSetChanged();
        }
        d.a.j0.a3.h.b bVar2 = this.E;
        if (bVar2 != null) {
            bVar2.k();
            this.E.notifyDataSetChanged();
        }
    }

    /* loaded from: classes5.dex */
    public class i extends BdAsyncTask<Void, Void, ForumListModel> {

        /* renamed from: a  reason: collision with root package name */
        public boolean f21464a;

        public i() {
            this.f21464a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.A.recommend_type = 2;
                ForumListActivity.this.A.offset = 0;
                ForumListActivity.this.A.rn = ForumListActivity.this.n;
                return ForumListModel.new_fetch(ForumListActivity.this.A);
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForumListModel forumListModel) {
            ForumListModel.List list;
            if (forumListModel != null && (list = forumListModel.recommend_list_right) != null) {
                int min = Math.min(list.forum_list.length, ForumListActivity.this.p.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_right.forum_list, 0, ForumListActivity.this.p.forum_list, 0, min);
                ForumListActivity.this.E.e(min);
                ForumListActivity.this.E.f(ForumListActivity.this.p.forum_list);
                if (ForumListActivity.this.n == 200) {
                    ForumListActivity forumListActivity = ForumListActivity.this;
                    forumListActivity.z.q.setText(forumListActivity.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity forumListActivity2 = ForumListActivity.this;
                    forumListActivity2.z.r.setImageDrawable(forumListActivity2.k);
                } else {
                    ForumListActivity forumListActivity3 = ForumListActivity.this;
                    forumListActivity3.z.q.setText(forumListActivity3.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity forumListActivity4 = ForumListActivity.this;
                    forumListActivity4.z.r.setImageDrawable(forumListActivity4.l);
                    ForumListActivity.this.C = true;
                }
            } else {
                ForumListActivity forumListActivity5 = ForumListActivity.this;
                forumListActivity5.showToast(forumListActivity5.getPageContext().getString(R.string.neterror));
                if (!this.f21464a) {
                    if (ForumListActivity.this.n == 200) {
                        ForumListActivity forumListActivity6 = ForumListActivity.this;
                        forumListActivity6.z.q.setText(forumListActivity6.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity7 = ForumListActivity.this;
                        forumListActivity7.z.r.setImageDrawable(forumListActivity7.k);
                    } else {
                        ForumListActivity forumListActivity8 = ForumListActivity.this;
                        forumListActivity8.z.q.setText(forumListActivity8.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity forumListActivity9 = ForumListActivity.this;
                        forumListActivity9.z.r.setImageDrawable(forumListActivity9.l);
                    }
                } else {
                    ForumListActivity forumListActivity10 = ForumListActivity.this;
                    forumListActivity10.z.q.setText(forumListActivity10.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity forumListActivity11 = ForumListActivity.this;
                    forumListActivity11.z.r.setImageDrawable(forumListActivity11.k);
                    ForumListActivity.this.A.rn = 200;
                    ForumListActivity.this.n = 200;
                }
            }
            ForumListActivity.this.z.p.setEnabled(true);
            ForumListActivity.this.z.d();
        }

        public void d(boolean z) {
            this.f21464a = z;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.z.p.setEnabled(false);
            ForumListActivity forumListActivity = ForumListActivity.this;
            forumListActivity.z.q.setText(forumListActivity.getPageContext().getString(R.string.flist_loading));
        }

        public /* synthetic */ i(ForumListActivity forumListActivity, a aVar) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public class j extends BdAsyncTask<Void, Void, ForumListModel> {

        /* renamed from: a  reason: collision with root package name */
        public boolean f21466a;

        public j() {
            this.f21466a = false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ForumListModel doInBackground(Void... voidArr) {
            try {
                ForumListActivity.this.A.recommend_type = 1;
                ForumListActivity.this.A.offset = 0;
                ForumListActivity.this.A.rn = ForumListActivity.this.m;
                return ForumListModel.new_fetch(ForumListActivity.this.A);
            } catch (Exception unused) {
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ForumListModel forumListModel) {
            ForumListModel.List list;
            if (forumListModel != null && (list = forumListModel.recommend_list_left) != null) {
                int min = Math.min(list.forum_list.length, ForumListActivity.this.o.forum_list.length);
                System.arraycopy(forumListModel.recommend_list_left.forum_list, 0, ForumListActivity.this.o.forum_list, 0, min);
                ForumListActivity.this.D.e(min);
                ForumListActivity.this.D.f(ForumListActivity.this.o.forum_list);
                if (ForumListActivity.this.m == 200) {
                    ForumListActivity forumListActivity = ForumListActivity.this;
                    forumListActivity.z.n.setText(forumListActivity.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity forumListActivity2 = ForumListActivity.this;
                    forumListActivity2.z.o.setImageDrawable(forumListActivity2.k);
                } else {
                    ForumListActivity forumListActivity3 = ForumListActivity.this;
                    forumListActivity3.z.n.setText(forumListActivity3.getPageContext().getString(R.string.flist_collapse_list));
                    ForumListActivity forumListActivity4 = ForumListActivity.this;
                    forumListActivity4.z.o.setImageDrawable(forumListActivity4.l);
                    ForumListActivity.this.B = true;
                }
            } else {
                ForumListActivity forumListActivity5 = ForumListActivity.this;
                forumListActivity5.showToast(forumListActivity5.getPageContext().getString(R.string.neterror));
                if (!this.f21466a) {
                    if (ForumListActivity.this.m == 200) {
                        ForumListActivity forumListActivity6 = ForumListActivity.this;
                        forumListActivity6.z.n.setText(forumListActivity6.getPageContext().getString(R.string.flist_expand_list));
                        ForumListActivity forumListActivity7 = ForumListActivity.this;
                        forumListActivity7.z.o.setImageDrawable(forumListActivity7.k);
                    } else {
                        ForumListActivity forumListActivity8 = ForumListActivity.this;
                        forumListActivity8.z.n.setText(forumListActivity8.getPageContext().getString(R.string.flist_collapse_list));
                        ForumListActivity forumListActivity9 = ForumListActivity.this;
                        forumListActivity9.z.o.setImageDrawable(forumListActivity9.l);
                    }
                } else {
                    ForumListActivity forumListActivity10 = ForumListActivity.this;
                    forumListActivity10.z.n.setText(forumListActivity10.getPageContext().getString(R.string.flist_expand_list));
                    ForumListActivity forumListActivity11 = ForumListActivity.this;
                    forumListActivity11.z.o.setImageDrawable(forumListActivity11.k);
                    ForumListActivity.this.A.rn = 200;
                    ForumListActivity.this.m = 200;
                }
            }
            ForumListActivity.this.z.m.setEnabled(true);
            ForumListActivity.this.z.d();
        }

        public void d(boolean z) {
            this.f21466a = z;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPreExecute() {
            ForumListActivity.this.z.m.setEnabled(false);
            ForumListActivity forumListActivity = ForumListActivity.this;
            forumListActivity.z.n.setText(forumListActivity.getPageContext().getString(R.string.flist_loading));
        }

        public /* synthetic */ j(ForumListActivity forumListActivity, a aVar) {
            this();
        }
    }
}
