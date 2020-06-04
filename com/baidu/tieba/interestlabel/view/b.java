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
/* loaded from: classes10.dex */
public class b {
    private BdListView Um;
    private NoNetworkView fci;
    private LabelRecommendActivity iWg;
    private View iWh;
    private TextView iWi;
    private TextView iWj;
    private com.baidu.tieba.interestlabel.a.a iWk;
    private a iWl;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> iWm = new ArrayList();
    private View.OnClickListener iWn = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.iWm.contains(valueOf)) {
                    b.this.iWm.remove(valueOf);
                } else {
                    b.this.iWm.add(valueOf);
                }
                b.this.csN();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.iWg = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.iWg.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.iWg.findViewById(R.id.view_root);
        this.iWh = this.iWg.findViewById(R.id.statebar_view);
        this.iWi = (TextView) this.iWg.findViewById(R.id.skip);
        this.fci = (NoNetworkView) this.iWg.findViewById(R.id.view_no_network);
        this.iWj = (TextView) this.iWg.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.iWh.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cw(0, 0);
        this.Um = (BdListView) this.iWg.findViewById(R.id.listview);
        this.iWk = new com.baidu.tieba.interestlabel.a.a(this.iWg.getPageContext().getPageActivity());
        this.iWk.setOnClickListener(this.iWn);
        this.iWl = new a(this.iWg.getPageContext().getPageActivity());
        this.Um.addHeaderView(this.iWl.csJ());
        this.Um.setAdapter((ListAdapter) this.iWk);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.iWi, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.iWj, (int) R.drawable.color_sub_lable_selector);
        am.setBackgroundResource(this.iWj, R.drawable.bule_bg_commen_label_button);
        this.fci.onChangeSkinType(this.iWg.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cw(int i, int i2) {
        this.iWj.setEnabled(i > 0);
        this.iWj.setText(this.iWg.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.iWj.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.iWi.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View csL() {
        return this.iWi;
    }

    public View csM() {
        return this.iWj;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.csC() != null && bVar.csD() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.csD()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.csD());
            this.iWl.setData(bVar.csC());
            this.iWk.setData(this.mDataList);
            this.Um.setVisibility(0);
            cw(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csN() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.iWm.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.iWk.setData(this.mDataList);
        cw(this.iWm.size(), this.mDataList.size());
    }

    public List<Integer> csO() {
        ArrayList arrayList = new ArrayList(this.iWm);
        arrayList.add(0, Integer.valueOf(this.iWl.csK()));
        return arrayList;
    }
}
