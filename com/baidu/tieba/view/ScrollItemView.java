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
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ScrollItemView extends ListView {
    private int mCurrentPosition;
    private a nUL;
    private Runnable nUM;

    static /* synthetic */ int c(ScrollItemView scrollItemView) {
        int i = scrollItemView.mCurrentPosition + 1;
        scrollItemView.mCurrentPosition = i;
        return i;
    }

    public ScrollItemView(Context context) {
        super(context);
        this.mCurrentPosition = 0;
        this.nUM = new Runnable() { // from class: com.baidu.tieba.view.ScrollItemView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mB().removeCallbacks(ScrollItemView.this.nUM);
                if (ScrollItemView.this.getItemCount() > 0) {
                    ScrollItemView.this.smoothScrollToPositionFromTop(ScrollItemView.c(ScrollItemView.this), 0, 300);
                }
                com.baidu.adp.lib.f.e.mB().postDelayed(ScrollItemView.this.nUM, IMConnection.RETRY_DELAY_TIMES);
            }
        };
        init(context);
    }

    public ScrollItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentPosition = 0;
        this.nUM = new Runnable() { // from class: com.baidu.tieba.view.ScrollItemView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mB().removeCallbacks(ScrollItemView.this.nUM);
                if (ScrollItemView.this.getItemCount() > 0) {
                    ScrollItemView.this.smoothScrollToPositionFromTop(ScrollItemView.c(ScrollItemView.this), 0, 300);
                }
                com.baidu.adp.lib.f.e.mB().postDelayed(ScrollItemView.this.nUM, IMConnection.RETRY_DELAY_TIMES);
            }
        };
        init(context);
    }

    public ScrollItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentPosition = 0;
        this.nUM = new Runnable() { // from class: com.baidu.tieba.view.ScrollItemView.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.lib.f.e.mB().removeCallbacks(ScrollItemView.this.nUM);
                if (ScrollItemView.this.getItemCount() > 0) {
                    ScrollItemView.this.smoothScrollToPositionFromTop(ScrollItemView.c(ScrollItemView.this), 0, 300);
                }
                com.baidu.adp.lib.f.e.mB().postDelayed(ScrollItemView.this.nUM, IMConnection.RETRY_DELAY_TIMES);
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.nUL = new a(context);
        setAdapter((ListAdapter) this.nUL);
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
        if (this.nUL == null) {
            return 0;
        }
        return this.nUL.getDataSize();
    }

    public void setData(List<String> list) {
        stopScroll();
        this.nUL.setData(list);
        dXJ();
        cHO();
    }

    private void dXJ() {
        this.mCurrentPosition = (int) Math.floor(getItemCount() * Math.random());
        smoothScrollToPosition(this.mCurrentPosition);
    }

    public void stopScroll() {
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.nUM);
        setSelection(this.mCurrentPosition);
    }

    public void cHO() {
        com.baidu.adp.lib.f.e.mB().postDelayed(this.nUM, IMConnection.RETRY_DELAY_TIMES);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopScroll();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        cHO();
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
            if (x.isEmpty(this.mData)) {
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

        private String Ml(int i) {
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
                view = LayoutInflater.from(this.mContext).inflate(R.layout.scroll_item_layout, viewGroup, false);
                bVar = new b(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.gyp.setText(Ml(ScrollItemView.this.mCurrentPosition));
            ao.setViewTextColor(bVar.gyp, R.color.CAM_X0109);
            return view;
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView gyp;

        public b(View view) {
            this.gyp = (TextView) view.findViewById(R.id.item_text);
        }
    }
}
