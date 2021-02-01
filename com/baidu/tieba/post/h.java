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
    private com.baidu.tbadk.l.h gBT;
    private NavigationBarShadowView kQQ;
    private Context mContext;
    private d mLQ;
    BdTypeListView mMg;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener mLR = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.gBT != null) {
                    h.this.gBT.dettachView(h.this.mRootView);
                    h.this.gBT = null;
                }
                if (h.this.mLQ != null) {
                    h.this.mLQ.dAV();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.kQQ.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.kQQ.hide();
            }
        }
    };

    public BdTypeListView dBg() {
        return this.mMg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.mMg = (BdTypeListView) view.findViewById(R.id.list);
        this.kQQ = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.mMg.setOnScrollListener(this.mOnScrollListener);
    }

    public d dBh() {
        return this.mLQ;
    }

    public void b(d dVar) {
        this.mLQ = dVar;
    }

    public void aQ(String str, boolean z) {
        f.a(this.gBT, this.mLR, this.mContext, this.mRootView, str, z);
        this.mMg.setVisibility(8);
    }
}
