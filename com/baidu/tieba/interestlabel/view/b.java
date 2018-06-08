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
import com.baidu.tieba.d;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BdListView LQ;
    private NoNetworkView btu;
    private View dPo;
    private LabelRecommendActivity eEW;
    private TextView eEX;
    private TextView eEY;
    private com.baidu.tieba.interestlabel.a.a eEZ;
    private a eFa;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> eFb = new ArrayList();
    private View.OnClickListener eFc = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.eFb.contains(valueOf)) {
                    b.this.eFb.remove(valueOf);
                } else {
                    b.this.eFb.add(valueOf);
                }
                b.this.aOS();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.eEW = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.eEW.setContentView(d.i.activity_label_recommend);
        this.mRootView = (ViewGroup) this.eEW.findViewById(d.g.view_root);
        this.dPo = this.eEW.findViewById(d.g.statebar_view);
        this.eEX = (TextView) this.eEW.findViewById(d.g.skip);
        this.btu = (NoNetworkView) this.eEW.findViewById(d.g.view_no_network);
        this.eEY = (TextView) this.eEW.findViewById(d.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dPo.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bi(0, 0);
        this.LQ = (BdListView) this.eEW.findViewById(d.g.listview);
        this.eEZ = new com.baidu.tieba.interestlabel.a.a(this.eEW.getPageContext().getPageActivity());
        this.eEZ.setOnClickListener(this.eFc);
        this.eFa = new a(this.eEW.getPageContext().getPageActivity());
        this.LQ.addHeaderView(this.eFa.aOO());
        this.LQ.setAdapter((ListAdapter) this.eEZ);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.h(this.eEX, d.C0141d.cp_cont_d);
        al.h(this.eEY, d.f.color_sub_lable_selector);
        al.i(this.eEY, d.f.bule_bg_commen_label_button);
        this.btu.onChangeSkinType(this.eEW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bi(int i, int i2) {
        this.eEY.setEnabled(i > 0);
        this.eEY.setText(this.eEW.getString(d.k.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.eEY.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.eEX.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View aOQ() {
        return this.eEX;
    }

    public View aOR() {
        return this.eEY;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.aOH() != null && bVar.aOI() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.aOI()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.aOI());
            this.eFa.setData(bVar.aOH());
            this.eEZ.setData(this.mDataList);
            this.LQ.setVisibility(0);
            bi(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOS() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.eFb.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.eEZ.setData(this.mDataList);
        bi(this.eFb.size(), this.mDataList.size());
    }

    public List<Integer> aOT() {
        ArrayList arrayList = new ArrayList(this.eFb);
        arrayList.add(0, Integer.valueOf(this.eFa.aOP()));
        return arrayList;
    }
}
