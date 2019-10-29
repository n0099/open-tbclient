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
    private NoNetworkView dwI;
    private View ghN;
    private LabelRecommendActivity hbS;
    private TextView hbT;
    private TextView hbU;
    private com.baidu.tieba.interestlabel.a.a hbV;
    private a hbW;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private BdListView yl;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> hbX = new ArrayList();
    private View.OnClickListener hbY = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.hbX.contains(valueOf)) {
                    b.this.hbX.remove(valueOf);
                } else {
                    b.this.hbX.add(valueOf);
                }
                b.this.bHi();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.hbS = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.hbS.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.hbS.findViewById(R.id.view_root);
        this.ghN = this.hbS.findViewById(R.id.statebar_view);
        this.hbT = (TextView) this.hbS.findViewById(R.id.skip);
        this.dwI = (NoNetworkView) this.hbS.findViewById(R.id.view_no_network);
        this.hbU = (TextView) this.hbS.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.ghN.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bT(0, 0);
        this.yl = (BdListView) this.hbS.findViewById(R.id.listview);
        this.hbV = new com.baidu.tieba.interestlabel.a.a(this.hbS.getPageContext().getPageActivity());
        this.hbV.setOnClickListener(this.hbY);
        this.hbW = new a(this.hbS.getPageContext().getPageActivity());
        this.yl.addHeaderView(this.hbW.bHe());
        this.yl.setAdapter((ListAdapter) this.hbV);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.hbT, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.hbU, (int) R.drawable.color_sub_lable_selector);
        am.setBackgroundResource(this.hbU, R.drawable.bule_bg_commen_label_button);
        this.dwI.onChangeSkinType(this.hbS.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bT(int i, int i2) {
        this.hbU.setEnabled(i > 0);
        this.hbU.setText(this.hbS.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.hbU.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.hbT.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View bHg() {
        return this.hbT;
    }

    public View bHh() {
        return this.hbU;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.bGX() != null && bVar.bGY() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.bGY()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.bGY());
            this.hbW.setData(bVar.bGX());
            this.hbV.setData(this.mDataList);
            this.yl.setVisibility(0);
            bT(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHi() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.hbX.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.hbV.setData(this.mDataList);
        bT(this.hbX.size(), this.mDataList.size());
    }

    public List<Integer> bHj() {
        ArrayList arrayList = new ArrayList(this.hbX);
        arrayList.add(0, Integer.valueOf(this.hbW.bHf()));
        return arrayList;
    }
}
