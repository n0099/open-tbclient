package com.baidu.tieba.interestlabel.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    private BdListView Ni;
    private NoNetworkView dnM;
    private View ggx;
    private LabelRecommendActivity hbV;
    private TextView hbW;
    private TextView hbX;
    private com.baidu.tieba.interestlabel.a.a hbY;
    private a hbZ;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> hca = new ArrayList();
    private View.OnClickListener hcb = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).bFM);
                if (b.this.hca.contains(valueOf)) {
                    b.this.hca.remove(valueOf);
                } else {
                    b.this.hca.add(valueOf);
                }
                b.this.bJL();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.hbV = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.hbV.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.hbV.findViewById(R.id.view_root);
        this.ggx = this.hbV.findViewById(R.id.statebar_view);
        this.hbW = (TextView) this.hbV.findViewById(R.id.skip);
        this.dnM = (NoNetworkView) this.hbV.findViewById(R.id.view_no_network);
        this.hbX = (TextView) this.hbV.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.ggx.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        ca(0, 0);
        this.Ni = (BdListView) this.hbV.findViewById(R.id.listview);
        this.hbY = new com.baidu.tieba.interestlabel.a.a(this.hbV.getPageContext().getPageActivity());
        this.hbY.setOnClickListener(this.hcb);
        this.hbZ = new a(this.hbV.getPageContext().getPageActivity());
        this.Ni.addHeaderView(this.hbZ.bJH());
        this.Ni.setAdapter((ListAdapter) this.hbY);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.j(this.hbW, R.color.cp_cont_d);
        am.j(this.hbX, R.drawable.color_sub_lable_selector);
        am.k(this.hbX, R.drawable.bule_bg_commen_label_button);
        this.dnM.onChangeSkinType(this.hbV.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void ca(int i, int i2) {
        this.hbX.setEnabled(i > 0);
        this.hbX.setText(this.hbV.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.hbX.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.hbW.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View bJJ() {
        return this.hbW;
    }

    public View bJK() {
        return this.hbX;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.bJA() != null && bVar.bJB() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.bJB()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.bJB());
            this.hbZ.setData(bVar.bJA());
            this.hbY.setData(this.mDataList);
            this.Ni.setVisibility(0);
            ca(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJL() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.hca.contains(Integer.valueOf(aVar.bFM));
            }
        }
        this.hbY.setData(this.mDataList);
        ca(this.hca.size(), this.mDataList.size());
    }

    public List<Integer> bJM() {
        ArrayList arrayList = new ArrayList(this.hca);
        arrayList.add(0, Integer.valueOf(this.hbZ.bJI()));
        return arrayList;
    }
}
