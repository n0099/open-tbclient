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
    private View elD;
    private LabelRecommendActivity fbF;
    private TextView fbG;
    private TextView fbH;
    private com.baidu.tieba.interestlabel.a.a fbI;
    private a fbJ;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> fbK = new ArrayList();
    private View.OnClickListener fbL = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.fbK.contains(valueOf)) {
                    b.this.fbK.remove(valueOf);
                } else {
                    b.this.fbK.add(valueOf);
                }
                b.this.aVX();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.fbF = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.fbF.setContentView(e.h.activity_label_recommend);
        this.mRootView = (ViewGroup) this.fbF.findViewById(e.g.view_root);
        this.elD = this.fbF.findViewById(e.g.statebar_view);
        this.fbG = (TextView) this.fbF.findViewById(e.g.skip);
        this.bJX = (NoNetworkView) this.fbF.findViewById(e.g.view_no_network);
        this.fbH = (TextView) this.fbF.findViewById(e.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.elD.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bq(0, 0);
        this.OE = (BdListView) this.fbF.findViewById(e.g.listview);
        this.fbI = new com.baidu.tieba.interestlabel.a.a(this.fbF.getPageContext().getPageActivity());
        this.fbI.setOnClickListener(this.fbL);
        this.fbJ = new a(this.fbF.getPageContext().getPageActivity());
        this.OE.addHeaderView(this.fbJ.aVT());
        this.OE.setAdapter((ListAdapter) this.fbI);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.h(this.fbG, e.d.cp_cont_d);
        al.h(this.fbH, e.f.color_sub_lable_selector);
        al.i(this.fbH, e.f.bule_bg_commen_label_button);
        this.bJX.onChangeSkinType(this.fbF.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bq(int i, int i2) {
        this.fbH.setEnabled(i > 0);
        this.fbH.setText(this.fbF.getString(e.j.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.fbH.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.fbG.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View aVV() {
        return this.fbG;
    }

    public View aVW() {
        return this.fbH;
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
            this.fbJ.setData(bVar.aVM());
            this.fbI.setData(this.mDataList);
            this.OE.setVisibility(0);
            bq(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVX() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.fbK.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.fbI.setData(this.mDataList);
        bq(this.fbK.size(), this.mDataList.size());
    }

    public List<Integer> aVY() {
        ArrayList arrayList = new ArrayList(this.fbK);
        arrayList.add(0, Integer.valueOf(this.fbJ.aVU()));
        return arrayList;
    }
}
