package com.baidu.tieba.interestlabel.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private BdListView auY;
    private NoNetworkView caX;
    private LabelRecommendActivity eXF;
    private TextView eXG;
    private TextView eXH;
    private com.baidu.tieba.interestlabel.a.a eXI;
    private b eXJ;
    private View eif;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> eXK = new ArrayList();
    private View.OnClickListener eXL = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (c.this.eXK.contains(valueOf)) {
                    c.this.eXK.remove(valueOf);
                } else {
                    c.this.eXK.add(valueOf);
                }
                c.this.aOU();
            }
        }
    };

    public c(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.eXF = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.eXF.setContentView(d.h.activity_label_recommend);
        this.mRootView = (ViewGroup) this.eXF.findViewById(d.g.view_root);
        this.eif = this.eXF.findViewById(d.g.statebar_view);
        this.eXG = (TextView) this.eXF.findViewById(d.g.skip);
        this.caX = (NoNetworkView) this.eXF.findViewById(d.g.view_no_network);
        this.eXH = (TextView) this.eXF.findViewById(d.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.eif.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cg(0, 0);
        this.auY = (BdListView) this.eXF.findViewById(d.g.listview);
        this.eXI = new com.baidu.tieba.interestlabel.a.a(this.eXF.getPageContext().getPageActivity());
        this.eXI.setOnClickListener(this.eXL);
        this.eXJ = new b(this.eXF.getPageContext().getPageActivity());
        this.auY.addHeaderView(this.eXJ.aOQ());
        this.auY.setAdapter((ListAdapter) this.eXI);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        aj.r(this.eXG, d.C0141d.cp_cont_d);
        aj.r(this.eXH, d.f.color_sub_lable_selector);
        aj.s(this.eXH, d.f.bule_bg_commen_label_button);
        this.caX.onChangeSkinType(this.eXF.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cg(int i, int i2) {
        this.eXH.setEnabled(i > 0);
        this.eXH.setText(this.eXF.getString(d.j.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.eXH.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.eXG.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View aOS() {
        return this.eXG;
    }

    public View aOT() {
        return this.eXH;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.aOJ() != null && bVar.aOK() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.aOK()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.aOK());
            this.eXJ.setData(bVar.aOJ());
            this.eXI.setData(this.mDataList);
            this.auY.setVisibility(0);
            cg(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOU() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.eXK.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.eXI.setData(this.mDataList);
        cg(this.eXK.size(), this.mDataList.size());
    }

    public List<Integer> aOV() {
        ArrayList arrayList = new ArrayList(this.eXK);
        arrayList.add(0, Integer.valueOf(this.eXJ.aOR()));
        return arrayList;
    }
}
