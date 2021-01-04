package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class h {
    private com.baidu.tbadk.l.h gDQ;
    private NavigationBarShadowView kNs;
    private Context mContext;
    BdTypeListView mHH;
    private d mHr;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener mHs = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.gDQ != null) {
                    h.this.gDQ.dettachView(h.this.mRootView);
                    h.this.gDQ = null;
                }
                if (h.this.mHr != null) {
                    h.this.mHr.dCC();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.kNs.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.kNs.hide();
            }
        }
    };

    public BdTypeListView dCN() {
        return this.mHH;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.mHH = (BdTypeListView) view.findViewById(R.id.list);
        this.kNs = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.mHH.setOnScrollListener(this.mOnScrollListener);
    }

    public d dCO() {
        return this.mHr;
    }

    public void b(d dVar) {
        this.mHr = dVar;
    }

    public void aR(String str, boolean z) {
        f.a(this.gDQ, this.mHs, this.mContext, this.mRootView, str, z);
        this.mHH.setVisibility(8);
    }
}
