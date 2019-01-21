package com.baidu.tieba.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ScrollItemView extends ListView {
    private a hSq;
    private Runnable hSr;
    private int mCurrentPosition;

    static /* synthetic */ int c(ScrollItemView scrollItemView) {
        int i = scrollItemView.mCurrentPosition + 1;
        scrollItemView.mCurrentPosition = i;
        return i;
    }

    public ScrollItemView(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.hSr = new Runnable() { // from class: com.baidu.tieba.view.ScrollItemView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(ScrollItemView.this.hSr);
                if (ScrollItemView.this.getItemCount() > 0) {
                    ScrollItemView.this.smoothScrollToPositionFromTop(ScrollItemView.c(ScrollItemView.this), 0, 300);
                }
                com.baidu.adp.lib.g.e.jG().postDelayed(ScrollItemView.this.hSr, 3000L);
            }
        };
        init(context);
    }

    public ScrollItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentPosition = 0;
        this.hSr = new Runnable() { // from class: com.baidu.tieba.view.ScrollItemView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(ScrollItemView.this.hSr);
                if (ScrollItemView.this.getItemCount() > 0) {
                    ScrollItemView.this.smoothScrollToPositionFromTop(ScrollItemView.c(ScrollItemView.this), 0, 300);
                }
                com.baidu.adp.lib.g.e.jG().postDelayed(ScrollItemView.this.hSr, 3000L);
            }
        };
        init(context);
    }

    public ScrollItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentPosition = 0;
        this.hSr = new Runnable() { // from class: com.baidu.tieba.view.ScrollItemView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(ScrollItemView.this.hSr);
                if (ScrollItemView.this.getItemCount() > 0) {
                    ScrollItemView.this.smoothScrollToPositionFromTop(ScrollItemView.c(ScrollItemView.this), 0, 300);
                }
                com.baidu.adp.lib.g.e.jG().postDelayed(ScrollItemView.this.hSr, 3000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.hSq = new a(context);
        setAdapter((ListAdapter) this.hSq);
        setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.view.ScrollItemView.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    ScrollItemView.this.setSelection(ScrollItemView.this.mCurrentPosition);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        setClickable(false);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getItemCount() {
        if (this.hSq == null) {
            return 0;
        }
        return this.hSq.getDataSize();
    }

    public void setData(List<String> list) {
        stopScroll();
        this.hSq.setData(list);
        bNA();
        aJo();
    }

    private void bNA() {
        this.mCurrentPosition = (int) Math.floor(getItemCount() * Math.random());
        smoothScrollToPosition(this.mCurrentPosition);
    }

    public void stopScroll() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hSr);
        setSelection(this.mCurrentPosition);
    }

    public void aJo() {
        com.baidu.adp.lib.g.e.jG().postDelayed(this.hSr, 3000L);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopScroll();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aJo();
    }

    public void onDestroy() {
        stopScroll();
    }

    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        private Context mContext;
        private List<String> mData = new ArrayList();

        public a(Context context) {
            this.mContext = context;
        }

        public void setData(List<String> list) {
            this.mData.clear();
            this.mData.addAll(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (v.I(this.mData)) {
                return 0;
            }
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }

        public int getDataSize() {
            if (this.mData == null) {
                return 0;
            }
            return this.mData.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        private String xf(int i) {
            if (this.mData == null || i < 0) {
                return "";
            }
            return this.mData.get(i % this.mData.size());
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(e.h.scroll_item_layout, viewGroup, false);
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.czk.setText(xf(ScrollItemView.this.mCurrentPosition));
            al.h(bVar.czk, e.d.cp_cont_d);
            return view;
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView czk;

        public b(View view) {
            this.czk = (TextView) view.findViewById(e.g.item_text);
        }
    }
}
