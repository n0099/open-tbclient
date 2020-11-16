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
/* loaded from: classes22.dex */
public class b {
    private BdListView Wa;
    private NoNetworkView giU;
    private LabelRecommendActivity kBJ;
    private View kBK;
    private TextView kBL;
    private TextView kBM;
    private com.baidu.tieba.interestlabel.a.a kBN;
    private a kBO;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> kBP = new ArrayList();
    private View.OnClickListener kBQ = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.kBP.contains(valueOf)) {
                    b.this.kBP.remove(valueOf);
                } else {
                    b.this.kBP.add(valueOf);
                }
                b.this.cXN();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.kBJ = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.kBJ.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.kBJ.findViewById(R.id.view_root);
        this.kBK = this.kBJ.findViewById(R.id.statebar_view);
        this.kBL = (TextView) this.kBJ.findViewById(R.id.skip);
        this.giU = (NoNetworkView) this.kBJ.findViewById(R.id.view_no_network);
        this.kBM = (TextView) this.kBJ.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.kBK.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cU(0, 0);
        this.Wa = (BdListView) this.kBJ.findViewById(R.id.listview);
        this.kBN = new com.baidu.tieba.interestlabel.a.a(this.kBJ.getPageContext().getPageActivity());
        this.kBN.setOnClickListener(this.kBQ);
        this.kBO = new a(this.kBJ.getPageContext().getPageActivity());
        this.Wa.addHeaderView(this.kBO.cXJ());
        this.Wa.setAdapter((ListAdapter) this.kBN);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.kBL, R.color.CAM_X0109);
        ap.setViewTextColor(this.kBM, R.drawable.color_sub_lable_selector);
        ap.setBackgroundResource(this.kBM, R.drawable.bule_bg_commen_label_button);
        this.giU.onChangeSkinType(this.kBJ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cU(int i, int i2) {
        this.kBM.setEnabled(i > 0);
        this.kBM.setText(this.kBJ.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.kBM.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.kBL.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View cXL() {
        return this.kBL;
    }

    public View cXM() {
        return this.kBM;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.cXC() != null && bVar.cXD() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.cXD()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.cXD());
            this.kBO.setData(bVar.cXC());
            this.kBN.setData(this.mDataList);
            this.Wa.setVisibility(0);
            cU(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXN() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.kBP.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.kBN.setData(this.mDataList);
        cU(this.kBP.size(), this.mDataList.size());
    }

    public List<Integer> cXO() {
        ArrayList arrayList = new ArrayList(this.kBP);
        arrayList.add(0, Integer.valueOf(this.kBO.cXK()));
        return arrayList;
    }
}
