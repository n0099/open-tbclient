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
    private NoNetworkView bOA;
    private View ewI;
    private LabelRecommendActivity fmI;
    private TextView fmJ;
    private TextView fmK;
    private com.baidu.tieba.interestlabel.a.a fmL;
    private a fmM;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> fmN = new ArrayList();
    private View.OnClickListener fmO = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.fmN.contains(valueOf)) {
                    b.this.fmN.remove(valueOf);
                } else {
                    b.this.fmN.add(valueOf);
                }
                b.this.aXZ();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.fmI = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.fmI.setContentView(e.h.activity_label_recommend);
        this.mRootView = (ViewGroup) this.fmI.findViewById(e.g.view_root);
        this.ewI = this.fmI.findViewById(e.g.statebar_view);
        this.fmJ = (TextView) this.fmI.findViewById(e.g.skip);
        this.bOA = (NoNetworkView) this.fmI.findViewById(e.g.view_no_network);
        this.fmK = (TextView) this.fmI.findViewById(e.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.ewI.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        br(0, 0);
        this.OF = (BdListView) this.fmI.findViewById(e.g.listview);
        this.fmL = new com.baidu.tieba.interestlabel.a.a(this.fmI.getPageContext().getPageActivity());
        this.fmL.setOnClickListener(this.fmO);
        this.fmM = new a(this.fmI.getPageContext().getPageActivity());
        this.OF.addHeaderView(this.fmM.aXV());
        this.OF.setAdapter((ListAdapter) this.fmL);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.h(this.fmJ, e.d.cp_cont_d);
        al.h(this.fmK, e.f.color_sub_lable_selector);
        al.i(this.fmK, e.f.bule_bg_commen_label_button);
        this.bOA.onChangeSkinType(this.fmI.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void br(int i, int i2) {
        this.fmK.setEnabled(i > 0);
        this.fmK.setText(this.fmI.getString(e.j.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.fmK.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.fmJ.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View aXX() {
        return this.fmJ;
    }

    public View aXY() {
        return this.fmK;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.aXO() != null && bVar.aXP() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.aXP()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.aXP());
            this.fmM.setData(bVar.aXO());
            this.fmL.setData(this.mDataList);
            this.OF.setVisibility(0);
            br(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXZ() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.fmN.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.fmL.setData(this.mDataList);
        br(this.fmN.size(), this.mDataList.size());
    }

    public List<Integer> aYa() {
        ArrayList arrayList = new ArrayList(this.fmN);
        arrayList.add(0, Integer.valueOf(this.fmM.aXW()));
        return arrayList;
    }
}
