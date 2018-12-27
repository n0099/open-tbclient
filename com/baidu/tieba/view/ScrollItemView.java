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
    private a hRi;
    private Runnable hRj;
    private int mCurrentPosition;

    static /* synthetic */ int c(ScrollItemView scrollItemView) {
        int i = scrollItemView.mCurrentPosition + 1;
        scrollItemView.mCurrentPosition = i;
        return i;
    }

    public ScrollItemView(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.hRj = new Runnable() { // from class: com.baidu.tieba.view.ScrollItemView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(ScrollItemView.this.hRj);
                if (ScrollItemView.this.getItemCount() > 0) {
                    ScrollItemView.this.smoothScrollToPositionFromTop(ScrollItemView.c(ScrollItemView.this), 0, 300);
                }
                com.baidu.adp.lib.g.e.jG().postDelayed(ScrollItemView.this.hRj, 3000L);
            }
        };
        init(context);
    }

    public ScrollItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentPosition = 0;
        this.hRj = new Runnable() { // from class: com.baidu.tieba.view.ScrollItemView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(ScrollItemView.this.hRj);
                if (ScrollItemView.this.getItemCount() > 0) {
                    ScrollItemView.this.smoothScrollToPositionFromTop(ScrollItemView.c(ScrollItemView.this), 0, 300);
                }
                com.baidu.adp.lib.g.e.jG().postDelayed(ScrollItemView.this.hRj, 3000L);
            }
        };
        init(context);
    }

    public ScrollItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentPosition = 0;
        this.hRj = new Runnable() { // from class: com.baidu.tieba.view.ScrollItemView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.g.e.jG().removeCallbacks(ScrollItemView.this.hRj);
                if (ScrollItemView.this.getItemCount() > 0) {
                    ScrollItemView.this.smoothScrollToPositionFromTop(ScrollItemView.c(ScrollItemView.this), 0, 300);
                }
                com.baidu.adp.lib.g.e.jG().postDelayed(ScrollItemView.this.hRj, 3000L);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.hRi = new a(context);
        setAdapter((ListAdapter) this.hRi);
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
        if (this.hRi == null) {
            return 0;
        }
        return this.hRi.getDataSize();
    }

    public void setData(List<String> list) {
        stopScroll();
        this.hRi.setData(list);
        bMS();
        aIQ();
    }

    private void bMS() {
        this.mCurrentPosition = (int) Math.floor(getItemCount() * Math.random());
        smoothScrollToPosition(this.mCurrentPosition);
    }

    public void stopScroll() {
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.hRj);
        setSelection(this.mCurrentPosition);
    }

    public void aIQ() {
        com.baidu.adp.lib.g.e.jG().postDelayed(this.hRj, 3000L);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopScroll();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        aIQ();
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

        private String xd(int i) {
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
            bVar.cyy.setText(xd(ScrollItemView.this.mCurrentPosition));
            al.h(bVar.cyy, e.d.cp_cont_d);
            return view;
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView cyy;

        public b(View view) {
            this.cyy = (TextView) view.findViewById(e.g.item_text);
        }
    }
}
