package com.baidu.tieba.interestlabel.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.e;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BdListView OF;
    private NoNetworkView bOx;
    private View etS;
    private LabelRecommendActivity fjR;
    private TextView fjS;
    private TextView fjT;
    private com.baidu.tieba.interestlabel.a.a fjU;
    private a fjV;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> fjW = new ArrayList();
    private View.OnClickListener fjX = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.fjW.contains(valueOf)) {
                    b.this.fjW.remove(valueOf);
                } else {
                    b.this.fjW.add(valueOf);
                }
                b.this.aXm();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.fjR = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.fjR.setContentView(e.h.activity_label_recommend);
        this.mRootView = (ViewGroup) this.fjR.findViewById(e.g.view_root);
        this.etS = this.fjR.findViewById(e.g.statebar_view);
        this.fjS = (TextView) this.fjR.findViewById(e.g.skip);
        this.bOx = (NoNetworkView) this.fjR.findViewById(e.g.view_no_network);
        this.fjT = (TextView) this.fjR.findViewById(e.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.etS.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bq(0, 0);
        this.OF = (BdListView) this.fjR.findViewById(e.g.listview);
        this.fjU = new com.baidu.tieba.interestlabel.a.a(this.fjR.getPageContext().getPageActivity());
        this.fjU.setOnClickListener(this.fjX);
        this.fjV = new a(this.fjR.getPageContext().getPageActivity());
        this.OF.addHeaderView(this.fjV.aXi());
        this.OF.setAdapter((ListAdapter) this.fjU);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.h(this.fjS, e.d.cp_cont_d);
        al.h(this.fjT, e.f.color_sub_lable_selector);
        al.i(this.fjT, e.f.bule_bg_commen_label_button);
        this.bOx.onChangeSkinType(this.fjR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bq(int i, int i2) {
        this.fjT.setEnabled(i > 0);
        this.fjT.setText(this.fjR.getString(e.j.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.fjT.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.fjS.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View aXk() {
        return this.fjS;
    }

    public View aXl() {
        return this.fjT;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.aXb() != null && bVar.aXc() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.aXc()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.aXc());
            this.fjV.setData(bVar.aXb());
            this.fjU.setData(this.mDataList);
            this.OF.setVisibility(0);
            bq(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXm() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.fjW.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.fjU.setData(this.mDataList);
        bq(this.fjW.size(), this.mDataList.size());
    }

    public List<Integer> aXn() {
        ArrayList arrayList = new ArrayList(this.fjW);
        arrayList.add(0, Integer.valueOf(this.fjV.aXj()));
        return arrayList;
    }
}
