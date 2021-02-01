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
/* loaded from: classes8.dex */
public class b {
    private BdListView WO;
    private NoNetworkView gAh;
    private LabelRecommendActivity kYf;
    private View kYg;
    private TextView kYh;
    private TextView kYi;
    private com.baidu.tieba.interestlabel.a.a kYj;
    private a kYk;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> kYl = new ArrayList();
    private View.OnClickListener kYm = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.kYl.contains(valueOf)) {
                    b.this.kYl.remove(valueOf);
                } else {
                    b.this.kYl.add(valueOf);
                }
                b.this.daQ();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.kYf = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.kYf.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.kYf.findViewById(R.id.view_root);
        this.kYg = this.kYf.findViewById(R.id.statebar_view);
        this.kYh = (TextView) this.kYf.findViewById(R.id.skip);
        this.gAh = (NoNetworkView) this.kYf.findViewById(R.id.view_no_network);
        this.kYi = (TextView) this.kYf.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.kYg.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cS(0, 0);
        this.WO = (BdListView) this.kYf.findViewById(R.id.listview);
        this.kYj = new com.baidu.tieba.interestlabel.a.a(this.kYf.getPageContext().getPageActivity());
        this.kYj.setOnClickListener(this.kYm);
        this.kYk = new a(this.kYf.getPageContext().getPageActivity());
        this.WO.addHeaderView(this.kYk.daM());
        this.WO.setAdapter((ListAdapter) this.kYj);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.kYh, R.color.CAM_X0109);
        ap.setViewTextColor(this.kYi, R.drawable.color_sub_lable_selector);
        ap.setBackgroundResource(this.kYi, R.drawable.bule_bg_commen_label_button);
        this.gAh.onChangeSkinType(this.kYf.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cS(int i, int i2) {
        this.kYi.setEnabled(i > 0);
        this.kYi.setText(this.kYf.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.kYi.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.kYh.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View daO() {
        return this.kYh;
    }

    public View daP() {
        return this.kYi;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.daF() != null && bVar.daG() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.daG()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.daG());
            this.kYk.setData(bVar.daF());
            this.kYj.setData(this.mDataList);
            this.WO.setVisibility(0);
            cS(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daQ() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.kYl.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.kYj.setData(this.mDataList);
        cS(this.kYl.size(), this.mDataList.size());
    }

    public List<Integer> daR() {
        ArrayList arrayList = new ArrayList(this.kYl);
        arrayList.add(0, Integer.valueOf(this.kYk.daN()));
        return arrayList;
    }
}
