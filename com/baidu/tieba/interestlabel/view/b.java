package com.baidu.tieba.interestlabel.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class b {
    private BdListView VX;
    private NoNetworkView fTu;
    private LabelRecommendActivity kjc;
    private View kjd;
    private TextView kje;
    private TextView kjf;
    private com.baidu.tieba.interestlabel.a.a kjg;
    private a kjh;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> kji = new ArrayList();
    private View.OnClickListener kjj = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.kji.contains(valueOf)) {
                    b.this.kji.remove(valueOf);
                } else {
                    b.this.kji.add(valueOf);
                }
                b.this.cSJ();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.kjc = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.kjc.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.kjc.findViewById(R.id.view_root);
        this.kjd = this.kjc.findViewById(R.id.statebar_view);
        this.kje = (TextView) this.kjc.findViewById(R.id.skip);
        this.fTu = (NoNetworkView) this.kjc.findViewById(R.id.view_no_network);
        this.kjf = (TextView) this.kjc.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.kjd.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cQ(0, 0);
        this.VX = (BdListView) this.kjc.findViewById(R.id.listview);
        this.kjg = new com.baidu.tieba.interestlabel.a.a(this.kjc.getPageContext().getPageActivity());
        this.kjg.setOnClickListener(this.kjj);
        this.kjh = new a(this.kjc.getPageContext().getPageActivity());
        this.VX.addHeaderView(this.kjh.cSF());
        this.VX.setAdapter((ListAdapter) this.kjg);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.kje, R.color.cp_cont_d);
        ap.setViewTextColor(this.kjf, R.drawable.color_sub_lable_selector);
        ap.setBackgroundResource(this.kjf, R.drawable.bule_bg_commen_label_button);
        this.fTu.onChangeSkinType(this.kjc.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cQ(int i, int i2) {
        this.kjf.setEnabled(i > 0);
        this.kjf.setText(this.kjc.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.kjf.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.kje.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View cSH() {
        return this.kje;
    }

    public View cSI() {
        return this.kjf;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.cSy() != null && bVar.cSz() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.cSz()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.cSz());
            this.kjh.setData(bVar.cSy());
            this.kjg.setData(this.mDataList);
            this.VX.setVisibility(0);
            cQ(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSJ() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.kji.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.kjg.setData(this.mDataList);
        cQ(this.kji.size(), this.mDataList.size());
    }

    public List<Integer> cSK() {
        ArrayList arrayList = new ArrayList(this.kji);
        arrayList.add(0, Integer.valueOf(this.kjh.cSG()));
        return arrayList;
    }
}
