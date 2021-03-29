package com.baidu.tieba.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.e.m.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ScrollItemView extends ListView {

    /* renamed from: e  reason: collision with root package name */
    public c f22183e;

    /* renamed from: f  reason: collision with root package name */
    public int f22184f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f22185g;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a().removeCallbacks(ScrollItemView.this.f22185g);
            if (ScrollItemView.this.getItemCount() > 0) {
                ScrollItemView scrollItemView = ScrollItemView.this;
                scrollItemView.smoothScrollToPositionFromTop(ScrollItemView.d(scrollItemView), 0, 300);
            }
            e.a().postDelayed(ScrollItemView.this.f22185g, 3000L);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AbsListView.OnScrollListener {
        public b() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0) {
                ScrollItemView scrollItemView = ScrollItemView.this;
                scrollItemView.setSelection(scrollItemView.f22184f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public List<String> f22188e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        public Context f22189f;

        public c(Context context) {
            this.f22189f = context;
        }

        public int a() {
            List<String> list = this.f22188e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public final String b(int i) {
            List<String> list = this.f22188e;
            if (list == null || i < 0) {
                return "";
            }
            return this.f22188e.get(i % list.size());
        }

        public void c(List<String> list) {
            this.f22188e.clear();
            this.f22188e.addAll(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ListUtils.isEmpty(this.f22188e) ? 0 : Integer.MAX_VALUE;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            if (view == null) {
                view = LayoutInflater.from(this.f22189f).inflate(R.layout.scroll_item_layout, viewGroup, false);
                dVar = new d(view);
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            dVar.f22191a.setText(b(ScrollItemView.this.f22184f));
            SkinManager.setViewTextColor(dVar.f22191a, R.color.CAM_X0109);
            return view;
        }
    }

    /* loaded from: classes5.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public TextView f22191a;

        public d(View view) {
            this.f22191a = (TextView) view.findViewById(R.id.item_text);
        }
    }

    public ScrollItemView(Context context) {
        super(context);
        this.f22184f = 0;
        this.f22185g = new a();
        e(context);
    }

    public static /* synthetic */ int d(ScrollItemView scrollItemView) {
        int i = scrollItemView.f22184f + 1;
        scrollItemView.f22184f = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getItemCount() {
        c cVar = this.f22183e;
        if (cVar == null) {
            return 0;
        }
        return cVar.a();
    }

    public final void e(Context context) {
        c cVar = new c(context);
        this.f22183e = cVar;
        setAdapter((ListAdapter) cVar);
        setOnScrollListener(new b());
        setClickable(false);
        setFocusable(false);
    }

    public final void f() {
        int floor = (int) Math.floor(getItemCount() * Math.random());
        this.f22184f = floor;
        smoothScrollToPosition(floor);
    }

    public void g() {
        e.a().postDelayed(this.f22185g, 3000L);
    }

    public void h() {
        e.a().removeCallbacks(this.f22185g);
        setSelection(this.f22184f);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    public void setData(List<String> list) {
        h();
        this.f22183e.c(list);
        f();
        g();
    }

    public ScrollItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22184f = 0;
        this.f22185g = new a();
        e(context);
    }

    public ScrollItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22184f = 0;
        this.f22185g = new a();
        e(context);
    }
}
