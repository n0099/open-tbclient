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
    private BdListView Ua;
    private NoNetworkView ePq;
    private a iGA;
    private LabelRecommendActivity iGv;
    private View iGw;
    private TextView iGx;
    private TextView iGy;
    private com.baidu.tieba.interestlabel.a.a iGz;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> iGB = new ArrayList();
    private View.OnClickListener iGC = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.iGB.contains(valueOf)) {
                    b.this.iGB.remove(valueOf);
                } else {
                    b.this.iGB.add(valueOf);
                }
                b.this.cmc();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.iGv = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.iGv.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.iGv.findViewById(R.id.view_root);
        this.iGw = this.iGv.findViewById(R.id.statebar_view);
        this.iGx = (TextView) this.iGv.findViewById(R.id.skip);
        this.ePq = (NoNetworkView) this.iGv.findViewById(R.id.view_no_network);
        this.iGy = (TextView) this.iGv.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.iGw.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cr(0, 0);
        this.Ua = (BdListView) this.iGv.findViewById(R.id.listview);
        this.iGz = new com.baidu.tieba.interestlabel.a.a(this.iGv.getPageContext().getPageActivity());
        this.iGz.setOnClickListener(this.iGC);
        this.iGA = new a(this.iGv.getPageContext().getPageActivity());
        this.Ua.addHeaderView(this.iGA.clY());
        this.Ua.setAdapter((ListAdapter) this.iGz);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.iGx, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.iGy, (int) R.drawable.color_sub_lable_selector);
        am.setBackgroundResource(this.iGy, R.drawable.bule_bg_commen_label_button);
        this.ePq.onChangeSkinType(this.iGv.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cr(int i, int i2) {
        this.iGy.setEnabled(i > 0);
        this.iGy.setText(this.iGv.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.iGy.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.iGx.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View cma() {
        return this.iGx;
    }

    public View cmb() {
        return this.iGy;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.clR() != null && bVar.clS() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.clS()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.clS());
            this.iGA.setData(bVar.clR());
            this.iGz.setData(this.mDataList);
            this.Ua.setVisibility(0);
            cr(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmc() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.iGB.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.iGz.setData(this.mDataList);
        cr(this.iGB.size(), this.mDataList.size());
    }

    public List<Integer> cmd() {
        ArrayList arrayList = new ArrayList(this.iGB);
        arrayList.add(0, Integer.valueOf(this.iGA.clZ()));
        return arrayList;
    }
}
