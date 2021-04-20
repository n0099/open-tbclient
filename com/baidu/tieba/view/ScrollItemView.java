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
import d.b.c.e.m.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class ScrollItemView extends ListView {

    /* renamed from: e  reason: collision with root package name */
    public c f21868e;

    /* renamed from: f  reason: collision with root package name */
    public int f21869f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f21870g;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.a().removeCallbacks(ScrollItemView.this.f21870g);
            if (ScrollItemView.this.getItemCount() > 0) {
                ScrollItemView scrollItemView = ScrollItemView.this;
                scrollItemView.smoothScrollToPositionFromTop(ScrollItemView.d(scrollItemView), 0, 300);
            }
            e.a().postDelayed(ScrollItemView.this.f21870g, 3000L);
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
                scrollItemView.setSelection(scrollItemView.f21869f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends BaseAdapter {

        /* renamed from: e  reason: collision with root package name */
        public List<String> f21873e = new ArrayList();

        /* renamed from: f  reason: collision with root package name */
        public Context f21874f;

        public c(Context context) {
            this.f21874f = context;
        }

        public int a() {
            List<String> list = this.f21873e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public final String b(int i) {
            List<String> list = this.f21873e;
            if (list == null || i < 0) {
                return "";
            }
            return this.f21873e.get(i % list.size());
        }

        public void c(List<String> list) {
            this.f21873e.clear();
            this.f21873e.addAll(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ListUtils.isEmpty(this.f21873e) ? 0 : Integer.MAX_VALUE;
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
                view = LayoutInflater.from(this.f21874f).inflate(R.layout.scroll_item_layout, viewGroup, false);
                dVar = new d(view);
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            dVar.f21876a.setText(b(ScrollItemView.this.f21869f));
            SkinManager.setViewTextColor(dVar.f21876a, R.color.CAM_X0109);
            return view;
        }
    }

    /* loaded from: classes5.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        public TextView f21876a;

        public d(View view) {
            this.f21876a = (TextView) view.findViewById(R.id.item_text);
        }
    }

    public ScrollItemView(Context context) {
        super(context);
        this.f21869f = 0;
        this.f21870g = new a();
        e(context);
    }

    public static /* synthetic */ int d(ScrollItemView scrollItemView) {
        int i = scrollItemView.f21869f + 1;
        scrollItemView.f21869f = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getItemCount() {
        c cVar = this.f21868e;
        if (cVar == null) {
            return 0;
        }
        return cVar.a();
    }

    public final void e(Context context) {
        c cVar = new c(context);
        this.f21868e = cVar;
        setAdapter((ListAdapter) cVar);
        setOnScrollListener(new b());
        setClickable(false);
        setFocusable(false);
    }

    public final void f() {
        int floor = (int) Math.floor(getItemCount() * Math.random());
        this.f21869f = floor;
        smoothScrollToPosition(floor);
    }

    public void g() {
        e.a().postDelayed(this.f21870g, 3000L);
    }

    public void h() {
        e.a().removeCallbacks(this.f21870g);
        setSelection(this.f21869f);
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
        this.f21868e.c(list);
        f();
        g();
    }

    public ScrollItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21869f = 0;
        this.f21870g = new a();
        e(context);
    }

    public ScrollItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21869f = 0;
        this.f21870g = new a();
        e(context);
    }
}
