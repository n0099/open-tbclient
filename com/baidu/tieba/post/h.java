package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes24.dex */
public class h {
    private com.baidu.tbadk.l.h gsR;
    private NavigationBarShadowView kIj;
    private d mCa;
    private Context mContext;
    BdTypeListView mCp;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener kvj = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.gsR != null) {
                    h.this.gsR.dettachView(h.this.mRootView);
                    h.this.gsR = null;
                }
                if (h.this.mCa != null) {
                    h.this.mCa.dCN();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.kIj.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.kIj.hide();
            }
        }
    };

    public BdTypeListView dCY() {
        return this.mCp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.mCp = (BdTypeListView) view.findViewById(R.id.list);
        this.kIj = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.mCp.setOnScrollListener(this.mOnScrollListener);
    }

    public d dCZ() {
        return this.mCa;
    }

    public void b(d dVar) {
        this.mCa = dVar;
    }

    public void aR(String str, boolean z) {
        f.a(this.gsR, this.kvj, this.mContext, this.mRootView, str, z);
        this.mCp.setVisibility(8);
    }
}
