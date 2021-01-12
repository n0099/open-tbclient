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
    private com.baidu.tbadk.l.h gzj;
    private NavigationBarShadowView kIN;
    private d mCI;
    BdTypeListView mCY;
    private Context mContext;
    private View mRootView;
    NoDataView mNoDataView = null;
    private View.OnClickListener mCJ = new View.OnClickListener() { // from class: com.baidu.tieba.post.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetworkAvailableForImmediately()) {
                if (h.this.gzj != null) {
                    h.this.gzj.dettachView(h.this.mRootView);
                    h.this.gzj = null;
                }
                if (h.this.mCI != null) {
                    h.this.mCI.dyL();
                }
            }
        }
    };
    private AbsListView.OnScrollListener mOnScrollListener = new AbsListView.OnScrollListener() { // from class: com.baidu.tieba.post.h.2
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                h.this.kIN.show();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 && (childAt = absListView.getChildAt(0)) != null && childAt.getTop() == 0) {
                h.this.kIN.hide();
            }
        }
    };

    public BdTypeListView dyW() {
        return this.mCY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        this.mCY = (BdTypeListView) view.findViewById(R.id.list);
        this.kIN = (NavigationBarShadowView) view.findViewById(R.id.navi_shadow_view_my_thread);
        this.mCY.setOnScrollListener(this.mOnScrollListener);
    }

    public d dyX() {
        return this.mCI;
    }

    public void b(d dVar) {
        this.mCI = dVar;
    }

    public void aR(String str, boolean z) {
        f.a(this.gzj, this.mCJ, this.mContext, this.mRootView, str, z);
        this.mCY.setVisibility(8);
    }
}
