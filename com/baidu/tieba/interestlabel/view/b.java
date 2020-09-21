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
    private BdListView VG;
    private NoNetworkView fHl;
    private LabelRecommendActivity jUc;
    private View jUd;
    private TextView jUe;
    private TextView jUf;
    private com.baidu.tieba.interestlabel.a.a jUg;
    private a jUh;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> jUi = new ArrayList();
    private View.OnClickListener jUj = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.jUi.contains(valueOf)) {
                    b.this.jUi.remove(valueOf);
                } else {
                    b.this.jUi.add(valueOf);
                }
                b.this.cPb();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.jUc = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.jUc.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.jUc.findViewById(R.id.view_root);
        this.jUd = this.jUc.findViewById(R.id.statebar_view);
        this.jUe = (TextView) this.jUc.findViewById(R.id.skip);
        this.fHl = (NoNetworkView) this.jUc.findViewById(R.id.view_no_network);
        this.jUf = (TextView) this.jUc.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.jUd.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cQ(0, 0);
        this.VG = (BdListView) this.jUc.findViewById(R.id.listview);
        this.jUg = new com.baidu.tieba.interestlabel.a.a(this.jUc.getPageContext().getPageActivity());
        this.jUg.setOnClickListener(this.jUj);
        this.jUh = new a(this.jUc.getPageContext().getPageActivity());
        this.VG.addHeaderView(this.jUh.cOX());
        this.VG.setAdapter((ListAdapter) this.jUg);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.jUe, R.color.cp_cont_d);
        ap.setViewTextColor(this.jUf, R.drawable.color_sub_lable_selector);
        ap.setBackgroundResource(this.jUf, R.drawable.bule_bg_commen_label_button);
        this.fHl.onChangeSkinType(this.jUc.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cQ(int i, int i2) {
        this.jUf.setEnabled(i > 0);
        this.jUf.setText(this.jUc.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.jUf.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.jUe.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View cOZ() {
        return this.jUe;
    }

    public View cPa() {
        return this.jUf;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.cOQ() != null && bVar.cOR() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.cOR()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.cOR());
            this.jUh.setData(bVar.cOQ());
            this.jUg.setData(this.mDataList);
            this.VG.setVisibility(0);
            cQ(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPb() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.jUi.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.jUg.setData(this.mDataList);
        cQ(this.jUi.size(), this.mDataList.size());
    }

    public List<Integer> cPc() {
        ArrayList arrayList = new ArrayList(this.jUi);
        arrayList.add(0, Integer.valueOf(this.jUh.cOY()));
        return arrayList;
    }
}
