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
    private com.baidu.tbadk.k.h ehM;
    private NavigationBarShadowView hIX;
    private d jvJ;
    BdTypeListView jvY;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener hwe = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.ehM != null) {
                    h.this.ehM.dettachView(h.this.mRootView);
                    h.this.ehM = null;
                }
                if (h.this.jvJ != null) {
                    h.this.jvJ.cxq();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.hIX.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.hIX.hide();
            }
        }
    };

    public BdTypeListView cxA() {
        return this.jvY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.jvY = (BdTypeListView) view.findViewById(R.id.list);
        this.hIX = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.jvY.setOnScrollListener(this.mOnScrollListener);
    }

    public d cxB() {
        return this.jvJ;
    }

    public void b(d dVar) {
        this.jvJ = dVar;
    }

    public void an(String str, boolean z) {
        f.a(this.ehM, this.hwe, this.mContext, this.mRootView, str, z);
        this.jvY.setVisibility(8);
    }
}
