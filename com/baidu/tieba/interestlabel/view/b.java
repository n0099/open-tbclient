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
    private BdListView MS;
    private NoNetworkView dlX;
    private LabelRecommendActivity gUQ;
    private TextView gUR;
    private TextView gUS;
    private com.baidu.tieba.interestlabel.a.a gUT;
    private a gUU;
    private View gaD;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> gUV = new ArrayList();
    private View.OnClickListener gUW = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.gUV.contains(valueOf)) {
                    b.this.gUV.remove(valueOf);
                } else {
                    b.this.gUV.add(valueOf);
                }
                b.this.bGP();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.gUQ = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.gUQ.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.gUQ.findViewById(R.id.view_root);
        this.gaD = this.gUQ.findViewById(R.id.statebar_view);
        this.gUR = (TextView) this.gUQ.findViewById(R.id.skip);
        this.dlX = (NoNetworkView) this.gUQ.findViewById(R.id.view_no_network);
        this.gUS = (TextView) this.gUQ.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gaD.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bU(0, 0);
        this.MS = (BdListView) this.gUQ.findViewById(R.id.listview);
        this.gUT = new com.baidu.tieba.interestlabel.a.a(this.gUQ.getPageContext().getPageActivity());
        this.gUT.setOnClickListener(this.gUW);
        this.gUU = new a(this.gUQ.getPageContext().getPageActivity());
        this.MS.addHeaderView(this.gUU.bGL());
        this.MS.setAdapter((ListAdapter) this.gUT);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.j(this.gUR, R.color.cp_cont_d);
        al.j(this.gUS, R.drawable.color_sub_lable_selector);
        al.k(this.gUS, R.drawable.bule_bg_commen_label_button);
        this.dlX.onChangeSkinType(this.gUQ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bU(int i, int i2) {
        this.gUS.setEnabled(i > 0);
        this.gUS.setText(this.gUQ.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.gUS.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.gUR.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View bGN() {
        return this.gUR;
    }

    public View bGO() {
        return this.gUS;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.bGE() != null && bVar.bGF() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.bGF()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.bGF());
            this.gUU.setData(bVar.bGE());
            this.gUT.setData(this.mDataList);
            this.MS.setVisibility(0);
            bU(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGP() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.gUV.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.gUT.setData(this.mDataList);
        bU(this.gUV.size(), this.mDataList.size());
    }

    public List<Integer> bGQ() {
        ArrayList arrayList = new ArrayList(this.gUV);
        arrayList.add(0, Integer.valueOf(this.gUU.bGM()));
        return arrayList;
    }
}
