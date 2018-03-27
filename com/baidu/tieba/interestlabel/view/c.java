package com.baidu.tieba.interestlabel.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private BdListView auZ;
    private NoNetworkView cba;
    private LabelRecommendActivity eXT;
    private TextView eXU;
    private TextView eXV;
    private com.baidu.tieba.interestlabel.a.a eXW;
    private b eXX;
    private View eiv;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> eXY = new ArrayList();
    private View.OnClickListener eXZ = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (c.this.eXY.contains(valueOf)) {
                    c.this.eXY.remove(valueOf);
                } else {
                    c.this.eXY.add(valueOf);
                }
                c.this.aOV();
            }
        }
    };

    public c(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.eXT = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.eXT.setContentView(d.h.activity_label_recommend);
        this.mRootView = (ViewGroup) this.eXT.findViewById(d.g.view_root);
        this.eiv = this.eXT.findViewById(d.g.statebar_view);
        this.eXU = (TextView) this.eXT.findViewById(d.g.skip);
        this.cba = (NoNetworkView) this.eXT.findViewById(d.g.view_no_network);
        this.eXV = (TextView) this.eXT.findViewById(d.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.eiv.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cg(0, 0);
        this.auZ = (BdListView) this.eXT.findViewById(d.g.listview);
        this.eXW = new com.baidu.tieba.interestlabel.a.a(this.eXT.getPageContext().getPageActivity());
        this.eXW.setOnClickListener(this.eXZ);
        this.eXX = new b(this.eXT.getPageContext().getPageActivity());
        this.auZ.addHeaderView(this.eXX.aOR());
        this.auZ.setAdapter((ListAdapter) this.eXW);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        aj.r(this.eXU, d.C0141d.cp_cont_d);
        aj.r(this.eXV, d.f.color_sub_lable_selector);
        aj.s(this.eXV, d.f.bule_bg_commen_label_button);
        this.cba.onChangeSkinType(this.eXT.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cg(int i, int i2) {
        this.eXV.setEnabled(i > 0);
        this.eXV.setText(this.eXT.getString(d.j.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.eXV.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.eXU.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View aOT() {
        return this.eXU;
    }

    public View aOU() {
        return this.eXV;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.aOK() != null && bVar.aOL() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.aOL()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.aOL());
            this.eXX.setData(bVar.aOK());
            this.eXW.setData(this.mDataList);
            this.auZ.setVisibility(0);
            cg(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOV() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.eXY.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.eXW.setData(this.mDataList);
        cg(this.eXY.size(), this.mDataList.size());
    }

    public List<Integer> aOW() {
        ArrayList arrayList = new ArrayList(this.eXY);
        arrayList.add(0, Integer.valueOf(this.eXX.aOS()));
        return arrayList;
    }
}
