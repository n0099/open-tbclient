package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class h {
    private com.baidu.tbadk.k.h fdL;
    private NavigationBarShadowView iPD;
    private d kFf;
    BdTypeListView kFu;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener iCJ = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.fdL != null) {
                    h.this.fdL.dettachView(h.this.mRootView);
                    h.this.fdL = null;
                }
                if (h.this.kFf != null) {
                    h.this.kFf.cSp();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.iPD.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.iPD.hide();
            }
        }
    };

    public BdTypeListView cSA() {
        return this.kFu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.kFu = (BdTypeListView) view.findViewById(R.id.list);
        this.iPD = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.kFu.setOnScrollListener(this.mOnScrollListener);
    }

    public d cSB() {
        return this.kFf;
    }

    public void b(d dVar) {
        this.kFf = dVar;
    }

    public void aG(String str, boolean z) {
        f.a(this.fdL, this.iCJ, this.mContext, this.mRootView, str, z);
        this.kFu.setVisibility(8);
    }
}
