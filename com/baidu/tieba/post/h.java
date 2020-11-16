package com.baidu.tieba.post;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.view.NavigationBarShadowView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class h {
    private com.baidu.tbadk.k.h gkG;
    private NavigationBarShadowView kuN;
    private Context mContext;
    private View mRootView;
    private d mnU;
    BdTypeListView moj;
    NoDataView mNoDataView = null;
    private View.OnClickListener khK = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.gkG != null) {
                    h.this.gkG.dettachView(h.this.mRootView);
                    h.this.gkG = null;
                }
                if (h.this.mnU != null) {
                    h.this.mnU.dxv();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.kuN.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.kuN.hide();
            }
        }
    };

    public BdTypeListView dxG() {
        return this.moj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.moj = (BdTypeListView) view.findViewById(R.id.list);
        this.kuN = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.moj.setOnScrollListener(this.mOnScrollListener);
    }

    public d dxH() {
        return this.mnU;
    }

    public void b(d dVar) {
        this.mnU = dVar;
    }

    public void aQ(String str, boolean z) {
        f.a(this.gkG, this.khK, this.mContext, this.mRootView, str, z);
        this.moj.setVisibility(8);
    }
}
