package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class h {
    private com.baidu.tbadk.l.h gDQ;
    private NavigationBarShadowView kTg;
    private Context mContext;
    private d mOh;
    BdTypeListView mOx;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener mOi = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.gDQ != null) {
                    h.this.gDQ.dettachView(h.this.mRootView);
                    h.this.gDQ = null;
                }
                if (h.this.mOh != null) {
                    h.this.mOh.dBk();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.kTg.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.kTg.hide();
            }
        }
    };

    public BdTypeListView dBv() {
        return this.mOx;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.mOx = (BdTypeListView) view.findViewById(R.id.list);
        this.kTg = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.mOx.setOnScrollListener(this.mOnScrollListener);
    }

    public d dBw() {
        return this.mOh;
    }

    public void b(d dVar) {
        this.mOh = dVar;
    }

    public void aQ(String str, boolean z) {
        f.a(this.gDQ, this.mOi, this.mContext, this.mRootView, str, z);
        this.mOx.setVisibility(8);
    }
}
