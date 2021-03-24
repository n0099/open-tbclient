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
    public c f22182e;

    /* renamed from: f  reason: collision with root package name */
    public int f22183f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f22184g;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a().removeCallbacks(ScrollItemView.this.f22184g);
            if (ScrollItemView.this.getItemCount() > 0) {
                ScrollItemView scrollItemView = ScrollItemView.this;
                scrollItemView.smoothScrollToPositionFromTop(ScrollItemView.d(scrollItemView), 0, 300);
            }
            e.a().postDelayed(ScrollItemView.this.f22184g, 3000L);
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
                scrollItemView.setSelection(scrollItemView.f22183f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public List<String> f22187e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        public Context f22188f;

        public c(Context context) {
            this.f22188f = context;
        }

        public int a() {
            List<String> list = this.f22187e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public final String b(int i) {
            List<String> list = this.f22187e;
            if (list == null || i < 0) {
                return "";
            }
            return this.f22187e.get(i % list.size());
        }

        public void c(List<String> list) {
            this.f22187e.clear();
            this.f22187e.addAll(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ListUtils.isEmpty(this.f22187e) ? 0 : Integer.MAX_VALUE;
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
                view = LayoutInflater.from(this.f22188f).inflate(R.layout.scroll_item_layout, viewGroup, false);
                dVar = new d(view);
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            dVar.f22190a.setText(b(ScrollItemView.this.f22183f));
            SkinManager.setViewTextColor(dVar.f22190a, R.color.CAM_X0109);
            return view;
        }
    }

    /* loaded from: classes5.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public TextView f22190a;

        public d(View view) {
            this.f22190a = (TextView) view.findViewById(R.id.item_text);
        }
    }

    public ScrollItemView(Context context) {
        super(context);
        this.f22183f = 0;
        this.f22184g = new a();
        e(context);
    }

    public static /* synthetic */ int d(ScrollItemView scrollItemView) {
        int i = scrollItemView.f22183f + 1;
        scrollItemView.f22183f = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getItemCount() {
        c cVar = this.f22182e;
        if (cVar == null) {
            return 0;
        }
        return cVar.a();
    }

    public final void e(Context context) {
        c cVar = new c(context);
        this.f22182e = cVar;
        setAdapter((ListAdapter) cVar);
        setOnScrollListener(new b());
        setClickable(false);
        setFocusable(false);
    }

    public final void f() {
        double itemCount = getItemCount();
        double random = Math.random();
        Double.isNaN(itemCount);
        int floor = (int) Math.floor(itemCount * random);
        this.f22183f = floor;
        smoothScrollToPosition(floor);
    }

    public void g() {
        e.a().postDelayed(this.f22184g, 3000L);
    }

    public void h() {
        e.a().removeCallbacks(this.f22184g);
        setSelection(this.f22183f);
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
        this.f22182e.c(list);
        f();
        g();
    }

    public ScrollItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22183f = 0;
        this.f22184g = new a();
        e(context);
    }

    public ScrollItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22183f = 0;
        this.f22184g = new a();
        e(context);
    }
}
