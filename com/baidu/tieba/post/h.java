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
    private com.baidu.tbadk.k.h fdA;
    private NavigationBarShadowView iOQ;
    private d kDX;
    BdTypeListView kEm;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener iBW = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.fdA != null) {
                    h.this.fdA.dettachView(h.this.mRootView);
                    h.this.fdA = null;
                }
                if (h.this.kDX != null) {
                    h.this.kDX.cRZ();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.iOQ.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.iOQ.hide();
            }
        }
    };

    public BdTypeListView cSk() {
        return this.kEm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.kEm = (BdTypeListView) view.findViewById(R.id.list);
        this.iOQ = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.kEm.setOnScrollListener(this.mOnScrollListener);
    }

    public d cSl() {
        return this.kDX;
    }

    public void b(d dVar) {
        this.kDX = dVar;
    }

    public void aG(String str, boolean z) {
        f.a(this.fdA, this.iBW, this.mContext, this.mRootView, str, z);
        this.kEm.setVisibility(8);
    }
}
