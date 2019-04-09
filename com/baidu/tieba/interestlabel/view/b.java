package com.baidu.tieba.interestlabel.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    private BdListView Pj;
    private NoNetworkView dbr;
    private View fJE;
    private com.baidu.tieba.interestlabel.a.a gDA;
    private a gDB;
    private LabelRecommendActivity gDx;
    private TextView gDy;
    private TextView gDz;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> gDC = new ArrayList();
    private View.OnClickListener gDD = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.gDC.contains(valueOf)) {
                    b.this.gDC.remove(valueOf);
                } else {
                    b.this.gDC.add(valueOf);
                }
                b.this.bzc();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.gDx = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.gDx.setContentView(d.h.activity_label_recommend);
        this.mRootView = (ViewGroup) this.gDx.findViewById(d.g.view_root);
        this.fJE = this.gDx.findViewById(d.g.statebar_view);
        this.gDy = (TextView) this.gDx.findViewById(d.g.skip);
        this.dbr = (NoNetworkView) this.gDx.findViewById(d.g.view_no_network);
        this.gDz = (TextView) this.gDx.findViewById(d.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.fJE.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bN(0, 0);
        this.Pj = (BdListView) this.gDx.findViewById(d.g.listview);
        this.gDA = new com.baidu.tieba.interestlabel.a.a(this.gDx.getPageContext().getPageActivity());
        this.gDA.setOnClickListener(this.gDD);
        this.gDB = new a(this.gDx.getPageContext().getPageActivity());
        this.Pj.addHeaderView(this.gDB.byY());
        this.Pj.setAdapter((ListAdapter) this.gDA);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.j(this.gDy, d.C0277d.cp_cont_d);
        al.j(this.gDz, d.f.color_sub_lable_selector);
        al.k(this.gDz, d.f.bule_bg_commen_label_button);
        this.dbr.onChangeSkinType(this.gDx.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bN(int i, int i2) {
        this.gDz.setEnabled(i > 0);
        this.gDz.setText(this.gDx.getString(d.j.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.gDz.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.gDy.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View bza() {
        return this.gDy;
    }

    public View bzb() {
        return this.gDz;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.byR() != null && bVar.byS() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.byS()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.byS());
            this.gDB.setData(bVar.byR());
            this.gDA.setData(this.mDataList);
            this.Pj.setVisibility(0);
            bN(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzc() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.gDC.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.gDA.setData(this.mDataList);
        bN(this.gDC.size(), this.mDataList.size());
    }

    public List<Integer> bzd() {
        ArrayList arrayList = new ArrayList(this.gDC);
        arrayList.add(0, Integer.valueOf(this.gDB.byZ()));
        return arrayList;
    }
}
