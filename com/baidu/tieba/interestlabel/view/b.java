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
import com.baidu.tieba.d;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BdListView LS;
    private NoNetworkView buT;
    private View dSF;
    private LabelRecommendActivity eIM;
    private TextView eIN;
    private TextView eIO;
    private com.baidu.tieba.interestlabel.a.a eIP;
    private a eIQ;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> eIR = new ArrayList();
    private View.OnClickListener eIS = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.eIR.contains(valueOf)) {
                    b.this.eIR.remove(valueOf);
                } else {
                    b.this.eIR.add(valueOf);
                }
                b.this.aPy();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.eIM = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.eIM.setContentView(d.i.activity_label_recommend);
        this.mRootView = (ViewGroup) this.eIM.findViewById(d.g.view_root);
        this.dSF = this.eIM.findViewById(d.g.statebar_view);
        this.eIN = (TextView) this.eIM.findViewById(d.g.skip);
        this.buT = (NoNetworkView) this.eIM.findViewById(d.g.view_no_network);
        this.eIO = (TextView) this.eIM.findViewById(d.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dSF.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bh(0, 0);
        this.LS = (BdListView) this.eIM.findViewById(d.g.listview);
        this.eIP = new com.baidu.tieba.interestlabel.a.a(this.eIM.getPageContext().getPageActivity());
        this.eIP.setOnClickListener(this.eIS);
        this.eIQ = new a(this.eIM.getPageContext().getPageActivity());
        this.LS.addHeaderView(this.eIQ.aPu());
        this.LS.setAdapter((ListAdapter) this.eIP);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.h(this.eIN, d.C0142d.cp_cont_d);
        am.h(this.eIO, d.f.color_sub_lable_selector);
        am.i(this.eIO, d.f.bule_bg_commen_label_button);
        this.buT.onChangeSkinType(this.eIM.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bh(int i, int i2) {
        this.eIO.setEnabled(i > 0);
        this.eIO.setText(this.eIM.getString(d.k.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.eIO.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.eIN.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View aPw() {
        return this.eIN;
    }

    public View aPx() {
        return this.eIO;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.aPn() != null && bVar.aPo() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.aPo()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.aPo());
            this.eIQ.setData(bVar.aPn());
            this.eIP.setData(this.mDataList);
            this.LS.setVisibility(0);
            bh(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPy() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.eIR.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.eIP.setData(this.mDataList);
        bh(this.eIR.size(), this.mDataList.size());
    }

    public List<Integer> aPz() {
        ArrayList arrayList = new ArrayList(this.eIR);
        arrayList.add(0, Integer.valueOf(this.eIQ.aPv()));
        return arrayList;
    }
}
