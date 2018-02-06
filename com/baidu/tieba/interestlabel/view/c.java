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
    private BdListView avh;
    private NoNetworkView cbj;
    private LabelRecommendActivity eXR;
    private TextView eXS;
    private TextView eXT;
    private com.baidu.tieba.interestlabel.a.a eXU;
    private b eXV;
    private View eir;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> eXW = new ArrayList();
    private View.OnClickListener eXX = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.c.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (c.this.eXW.contains(valueOf)) {
                    c.this.eXW.remove(valueOf);
                } else {
                    c.this.eXW.add(valueOf);
                }
                c.this.aOV();
            }
        }
    };

    public c(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.eXR = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.eXR.setContentView(d.h.activity_label_recommend);
        this.mRootView = (ViewGroup) this.eXR.findViewById(d.g.view_root);
        this.eir = this.eXR.findViewById(d.g.statebar_view);
        this.eXS = (TextView) this.eXR.findViewById(d.g.skip);
        this.cbj = (NoNetworkView) this.eXR.findViewById(d.g.view_no_network);
        this.eXT = (TextView) this.eXR.findViewById(d.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.eir.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cg(0, 0);
        this.avh = (BdListView) this.eXR.findViewById(d.g.listview);
        this.eXU = new com.baidu.tieba.interestlabel.a.a(this.eXR.getPageContext().getPageActivity());
        this.eXU.setOnClickListener(this.eXX);
        this.eXV = new b(this.eXR.getPageContext().getPageActivity());
        this.avh.addHeaderView(this.eXV.aOR());
        this.avh.setAdapter((ListAdapter) this.eXU);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        aj.r(this.eXS, d.C0140d.cp_cont_d);
        aj.r(this.eXT, d.f.color_sub_lable_selector);
        aj.s(this.eXT, d.f.bule_bg_commen_label_button);
        this.cbj.onChangeSkinType(this.eXR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cg(int i, int i2) {
        this.eXT.setEnabled(i > 0);
        this.eXT.setText(this.eXR.getString(d.j.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.eXT.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.eXS.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View aOT() {
        return this.eXS;
    }

    public View aOU() {
        return this.eXT;
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
            this.eXV.setData(bVar.aOK());
            this.eXU.setData(this.mDataList);
            this.avh.setVisibility(0);
            cg(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOV() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.eXW.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.eXU.setData(this.mDataList);
        cg(this.eXW.size(), this.mDataList.size());
    }

    public List<Integer> aOW() {
        ArrayList arrayList = new ArrayList(this.eXW);
        arrayList.add(0, Integer.valueOf(this.eXV.aOS()));
        return arrayList;
    }
}
