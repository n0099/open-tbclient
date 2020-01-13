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
/* loaded from: classes8.dex */
public class b {
    private BdListView Ao;
    private NoNetworkView ehd;
    private LabelRecommendActivity hSM;
    private View hSN;
    private TextView hSO;
    private TextView hSP;
    private com.baidu.tieba.interestlabel.a.a hSQ;
    private a hSR;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> hSS = new ArrayList();
    private View.OnClickListener hST = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.hSS.contains(valueOf)) {
                    b.this.hSS.remove(valueOf);
                } else {
                    b.this.hSS.add(valueOf);
                }
                b.this.bZF();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.hSM = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.hSM.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.hSM.findViewById(R.id.view_root);
        this.hSN = this.hSM.findViewById(R.id.statebar_view);
        this.hSO = (TextView) this.hSM.findViewById(R.id.skip);
        this.ehd = (NoNetworkView) this.hSM.findViewById(R.id.view_no_network);
        this.hSP = (TextView) this.hSM.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.hSN.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cj(0, 0);
        this.Ao = (BdListView) this.hSM.findViewById(R.id.listview);
        this.hSQ = new com.baidu.tieba.interestlabel.a.a(this.hSM.getPageContext().getPageActivity());
        this.hSQ.setOnClickListener(this.hST);
        this.hSR = new a(this.hSM.getPageContext().getPageActivity());
        this.Ao.addHeaderView(this.hSR.bZB());
        this.Ao.setAdapter((ListAdapter) this.hSQ);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.hSO, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.hSP, (int) R.drawable.color_sub_lable_selector);
        am.setBackgroundResource(this.hSP, R.drawable.bule_bg_commen_label_button);
        this.ehd.onChangeSkinType(this.hSM.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cj(int i, int i2) {
        this.hSP.setEnabled(i > 0);
        this.hSP.setText(this.hSM.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.hSP.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.hSO.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View bZD() {
        return this.hSO;
    }

    public View bZE() {
        return this.hSP;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.bZu() != null && bVar.bZv() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.bZv()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.bZv());
            this.hSR.setData(bVar.bZu());
            this.hSQ.setData(this.mDataList);
            this.Ao.setVisibility(0);
            cj(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZF() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.hSS.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.hSQ.setData(this.mDataList);
        cj(this.hSS.size(), this.mDataList.size());
    }

    public List<Integer> bZG() {
        ArrayList arrayList = new ArrayList(this.hSS);
        arrayList.add(0, Integer.valueOf(this.hSR.bZC()));
        return arrayList;
    }
}
