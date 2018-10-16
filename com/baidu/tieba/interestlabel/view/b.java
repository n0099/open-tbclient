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
import com.baidu.tieba.e;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BdListView OE;
    private NoNetworkView bJX;
    private View elC;
    private LabelRecommendActivity fbE;
    private TextView fbF;
    private TextView fbG;
    private com.baidu.tieba.interestlabel.a.a fbH;
    private a fbI;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> fbJ = new ArrayList();
    private View.OnClickListener fbK = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.fbJ.contains(valueOf)) {
                    b.this.fbJ.remove(valueOf);
                } else {
                    b.this.fbJ.add(valueOf);
                }
                b.this.aVX();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.fbE = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.fbE.setContentView(e.h.activity_label_recommend);
        this.mRootView = (ViewGroup) this.fbE.findViewById(e.g.view_root);
        this.elC = this.fbE.findViewById(e.g.statebar_view);
        this.fbF = (TextView) this.fbE.findViewById(e.g.skip);
        this.bJX = (NoNetworkView) this.fbE.findViewById(e.g.view_no_network);
        this.fbG = (TextView) this.fbE.findViewById(e.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.elC.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bq(0, 0);
        this.OE = (BdListView) this.fbE.findViewById(e.g.listview);
        this.fbH = new com.baidu.tieba.interestlabel.a.a(this.fbE.getPageContext().getPageActivity());
        this.fbH.setOnClickListener(this.fbK);
        this.fbI = new a(this.fbE.getPageContext().getPageActivity());
        this.OE.addHeaderView(this.fbI.aVT());
        this.OE.setAdapter((ListAdapter) this.fbH);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.h(this.fbF, e.d.cp_cont_d);
        al.h(this.fbG, e.f.color_sub_lable_selector);
        al.i(this.fbG, e.f.bule_bg_commen_label_button);
        this.bJX.onChangeSkinType(this.fbE.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bq(int i, int i2) {
        this.fbG.setEnabled(i > 0);
        this.fbG.setText(this.fbE.getString(e.j.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.fbG.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.fbF.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View aVV() {
        return this.fbF;
    }

    public View aVW() {
        return this.fbG;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.aVM() != null && bVar.aVN() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.aVN()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.aVN());
            this.fbI.setData(bVar.aVM());
            this.fbH.setData(this.mDataList);
            this.OE.setVisibility(0);
            bq(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVX() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.fbJ.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.fbH.setData(this.mDataList);
        bq(this.fbJ.size(), this.mDataList.size());
    }

    public List<Integer> aVY() {
        ArrayList arrayList = new ArrayList(this.fbJ);
        arrayList.add(0, Integer.valueOf(this.fbI.aVU()));
        return arrayList;
    }
}
