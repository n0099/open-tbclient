package com.baidu.tieba.interestlabel.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    private BdListView WT;
    private NoNetworkView gxx;
    private LabelRecommendActivity kQd;
    private View kQe;
    private TextView kQf;
    private TextView kQg;
    private com.baidu.tieba.interestlabel.a.a kQh;
    private a kQi;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> kQj = new ArrayList();
    private View.OnClickListener kQk = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.kQj.contains(valueOf)) {
                    b.this.kQj.remove(valueOf);
                } else {
                    b.this.kQj.add(valueOf);
                }
                b.this.cYS();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.kQd = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.kQd.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.kQd.findViewById(R.id.view_root);
        this.kQe = this.kQd.findViewById(R.id.statebar_view);
        this.kQf = (TextView) this.kQd.findViewById(R.id.skip);
        this.gxx = (NoNetworkView) this.kQd.findViewById(R.id.view_no_network);
        this.kQg = (TextView) this.kQd.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.kQe.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cV(0, 0);
        this.WT = (BdListView) this.kQd.findViewById(R.id.listview);
        this.kQh = new com.baidu.tieba.interestlabel.a.a(this.kQd.getPageContext().getPageActivity());
        this.kQh.setOnClickListener(this.kQk);
        this.kQi = new a(this.kQd.getPageContext().getPageActivity());
        this.WT.addHeaderView(this.kQi.cYO());
        this.WT.setAdapter((ListAdapter) this.kQh);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ao.setViewTextColor(this.kQf, R.color.CAM_X0109);
        ao.setViewTextColor(this.kQg, R.drawable.color_sub_lable_selector);
        ao.setBackgroundResource(this.kQg, R.drawable.bule_bg_commen_label_button);
        this.gxx.onChangeSkinType(this.kQd.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cV(int i, int i2) {
        this.kQg.setEnabled(i > 0);
        this.kQg.setText(this.kQd.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.kQg.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.kQf.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View cYQ() {
        return this.kQf;
    }

    public View cYR() {
        return this.kQg;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.cYH() != null && bVar.cYI() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.cYI()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.cYI());
            this.kQi.setData(bVar.cYH());
            this.kQh.setData(this.mDataList);
            this.WT.setVisibility(0);
            cV(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYS() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.kQj.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.kQh.setData(this.mDataList);
        cV(this.kQj.size(), this.mDataList.size());
    }

    public List<Integer> cYT() {
        ArrayList arrayList = new ArrayList(this.kQj);
        arrayList.add(0, Integer.valueOf(this.kQi.cYP()));
        return arrayList;
    }
}
