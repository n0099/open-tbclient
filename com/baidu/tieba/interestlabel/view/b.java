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
    private NoNetworkView dbq;
    private View fJE;
    private a gDA;
    private LabelRecommendActivity gDw;
    private TextView gDx;
    private TextView gDy;
    private com.baidu.tieba.interestlabel.a.a gDz;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> gDB = new ArrayList();
    private View.OnClickListener gDC = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.gDB.contains(valueOf)) {
                    b.this.gDB.remove(valueOf);
                } else {
                    b.this.gDB.add(valueOf);
                }
                b.this.bzc();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.gDw = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.gDw.setContentView(d.h.activity_label_recommend);
        this.mRootView = (ViewGroup) this.gDw.findViewById(d.g.view_root);
        this.fJE = this.gDw.findViewById(d.g.statebar_view);
        this.gDx = (TextView) this.gDw.findViewById(d.g.skip);
        this.dbq = (NoNetworkView) this.gDw.findViewById(d.g.view_no_network);
        this.gDy = (TextView) this.gDw.findViewById(d.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.fJE.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bN(0, 0);
        this.Pj = (BdListView) this.gDw.findViewById(d.g.listview);
        this.gDz = new com.baidu.tieba.interestlabel.a.a(this.gDw.getPageContext().getPageActivity());
        this.gDz.setOnClickListener(this.gDC);
        this.gDA = new a(this.gDw.getPageContext().getPageActivity());
        this.Pj.addHeaderView(this.gDA.byY());
        this.Pj.setAdapter((ListAdapter) this.gDz);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.j(this.gDx, d.C0277d.cp_cont_d);
        al.j(this.gDy, d.f.color_sub_lable_selector);
        al.k(this.gDy, d.f.bule_bg_commen_label_button);
        this.dbq.onChangeSkinType(this.gDw.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bN(int i, int i2) {
        this.gDy.setEnabled(i > 0);
        this.gDy.setText(this.gDw.getString(d.j.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.gDy.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.gDx.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View bza() {
        return this.gDx;
    }

    public View bzb() {
        return this.gDy;
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
            this.gDA.setData(bVar.byR());
            this.gDz.setData(this.mDataList);
            this.Pj.setVisibility(0);
            bN(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzc() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.gDB.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.gDz.setData(this.mDataList);
        bN(this.gDB.size(), this.mDataList.size());
    }

    public List<Integer> bzd() {
        ArrayList arrayList = new ArrayList(this.gDB);
        arrayList.add(0, Integer.valueOf(this.gDA.byZ()));
        return arrayList;
    }
}
