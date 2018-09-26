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
    private BdListView Op;
    private NoNetworkView bBq;
    private LabelRecommendActivity eTW;
    private TextView eTX;
    private TextView eTY;
    private com.baidu.tieba.interestlabel.a.a eTZ;
    private a eUa;
    private View edJ;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> eUb = new ArrayList();
    private View.OnClickListener eUc = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.eUb.contains(valueOf)) {
                    b.this.eUb.remove(valueOf);
                } else {
                    b.this.eUb.add(valueOf);
                }
                b.this.aSJ();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.eTW = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.eTW.setContentView(e.h.activity_label_recommend);
        this.mRootView = (ViewGroup) this.eTW.findViewById(e.g.view_root);
        this.edJ = this.eTW.findViewById(e.g.statebar_view);
        this.eTX = (TextView) this.eTW.findViewById(e.g.skip);
        this.bBq = (NoNetworkView) this.eTW.findViewById(e.g.view_no_network);
        this.eTY = (TextView) this.eTW.findViewById(e.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.edJ.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bn(0, 0);
        this.Op = (BdListView) this.eTW.findViewById(e.g.listview);
        this.eTZ = new com.baidu.tieba.interestlabel.a.a(this.eTW.getPageContext().getPageActivity());
        this.eTZ.setOnClickListener(this.eUc);
        this.eUa = new a(this.eTW.getPageContext().getPageActivity());
        this.Op.addHeaderView(this.eUa.aSF());
        this.Op.setAdapter((ListAdapter) this.eTZ);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.h(this.eTX, e.d.cp_cont_d);
        al.h(this.eTY, e.f.color_sub_lable_selector);
        al.i(this.eTY, e.f.bule_bg_commen_label_button);
        this.bBq.onChangeSkinType(this.eTW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bn(int i, int i2) {
        this.eTY.setEnabled(i > 0);
        this.eTY.setText(this.eTW.getString(e.j.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.eTY.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.eTX.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View aSH() {
        return this.eTX;
    }

    public View aSI() {
        return this.eTY;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.aSy() != null && bVar.aSz() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.aSz()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.aSz());
            this.eUa.setData(bVar.aSy());
            this.eTZ.setData(this.mDataList);
            this.Op.setVisibility(0);
            bn(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSJ() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.eUb.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.eTZ.setData(this.mDataList);
        bn(this.eUb.size(), this.mDataList.size());
    }

    public List<Integer> aSK() {
        ArrayList arrayList = new ArrayList(this.eUb);
        arrayList.add(0, Integer.valueOf(this.eUa.aSG()));
        return arrayList;
    }
}
