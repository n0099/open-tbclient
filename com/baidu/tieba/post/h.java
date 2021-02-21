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
    private com.baidu.tbadk.l.h gCh;
    private NavigationBarShadowView kRe;
    private Context mContext;
    private d mMf;
    BdTypeListView mMv;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener mMg = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.gCh != null) {
                    h.this.gCh.dettachView(h.this.mRootView);
                    h.this.gCh = null;
                }
                if (h.this.mMf != null) {
                    h.this.mMf.dBc();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.kRe.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.kRe.hide();
            }
        }
    };

    public BdTypeListView dBn() {
        return this.mMv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.mMv = (BdTypeListView) view.findViewById(R.id.list);
        this.kRe = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.mMv.setOnScrollListener(this.mOnScrollListener);
    }

    public d dBo() {
        return this.mMf;
    }

    public void b(d dVar) {
        this.mMf = dVar;
    }

    public void aQ(String str, boolean z) {
        f.a(this.gCh, this.mMg, this.mContext, this.mRootView, str, z);
        this.mMv.setVisibility(8);
    }
}
