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
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    private BdListView MR;
    private NoNetworkView dlX;
    private LabelRecommendActivity gUS;
    private TextView gUT;
    private TextView gUU;
    private com.baidu.tieba.interestlabel.a.a gUV;
    private a gUW;
    private View gaF;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> gUX = new ArrayList();
    private View.OnClickListener gUY = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.gUX.contains(valueOf)) {
                    b.this.gUX.remove(valueOf);
                } else {
                    b.this.gUX.add(valueOf);
                }
                b.this.bGQ();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.gUS = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.gUS.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.gUS.findViewById(R.id.view_root);
        this.gaF = this.gUS.findViewById(R.id.statebar_view);
        this.gUT = (TextView) this.gUS.findViewById(R.id.skip);
        this.dlX = (NoNetworkView) this.gUS.findViewById(R.id.view_no_network);
        this.gUU = (TextView) this.gUS.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gaF.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bU(0, 0);
        this.MR = (BdListView) this.gUS.findViewById(R.id.listview);
        this.gUV = new com.baidu.tieba.interestlabel.a.a(this.gUS.getPageContext().getPageActivity());
        this.gUV.setOnClickListener(this.gUY);
        this.gUW = new a(this.gUS.getPageContext().getPageActivity());
        this.MR.addHeaderView(this.gUW.bGM());
        this.MR.setAdapter((ListAdapter) this.gUV);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.j(this.gUT, R.color.cp_cont_d);
        al.j(this.gUU, R.drawable.color_sub_lable_selector);
        al.k(this.gUU, R.drawable.bule_bg_commen_label_button);
        this.dlX.onChangeSkinType(this.gUS.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bU(int i, int i2) {
        this.gUU.setEnabled(i > 0);
        this.gUU.setText(this.gUS.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.gUU.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.gUT.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View bGO() {
        return this.gUT;
    }

    public View bGP() {
        return this.gUU;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.bGF() != null && bVar.bGG() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.bGG()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.bGG());
            this.gUW.setData(bVar.bGF());
            this.gUV.setData(this.mDataList);
            this.MR.setVisibility(0);
            bU(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGQ() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.gUX.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.gUV.setData(this.mDataList);
        bU(this.gUX.size(), this.mDataList.size());
    }

    public List<Integer> bGR() {
        ArrayList arrayList = new ArrayList(this.gUX);
        arrayList.add(0, Integer.valueOf(this.gUW.bGN()));
        return arrayList;
    }
}
