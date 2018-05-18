package com.baidu.tieba.interestlabel.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BdListView FH;
    private NoNetworkView blp;
    private View dEe;
    private LabelRecommendActivity etG;
    private TextView etH;
    private TextView etI;
    private com.baidu.tieba.interestlabel.a.a etJ;
    private a etK;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> etL = new ArrayList();
    private View.OnClickListener etM = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view2.getTag()).labelId);
                if (b.this.etL.contains(valueOf)) {
                    b.this.etL.remove(valueOf);
                } else {
                    b.this.etL.add(valueOf);
                }
                b.this.aJW();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.etG = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.etG.setContentView(d.i.activity_label_recommend);
        this.mRootView = (ViewGroup) this.etG.findViewById(d.g.view_root);
        this.dEe = this.etG.findViewById(d.g.statebar_view);
        this.etH = (TextView) this.etG.findViewById(d.g.skip);
        this.blp = (NoNetworkView) this.etG.findViewById(d.g.view_no_network);
        this.etI = (TextView) this.etG.findViewById(d.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dEe.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bg(0, 0);
        this.FH = (BdListView) this.etG.findViewById(d.g.listview);
        this.etJ = new com.baidu.tieba.interestlabel.a.a(this.etG.getPageContext().getPageActivity());
        this.etJ.setOnClickListener(this.etM);
        this.etK = new a(this.etG.getPageContext().getPageActivity());
        this.FH.addHeaderView(this.etK.aJS());
        this.FH.setAdapter((ListAdapter) this.etJ);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ak.h(this.etH, d.C0126d.cp_cont_d);
        ak.h(this.etI, d.f.color_sub_lable_selector);
        ak.i(this.etI, d.f.bule_bg_commen_label_button);
        this.blp.onChangeSkinType(this.etG.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bg(int i, int i2) {
        this.etI.setEnabled(i > 0);
        this.etI.setText(this.etG.getString(d.k.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.etI.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.etH.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View aJU() {
        return this.etH;
    }

    public View aJV() {
        return this.etI;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.aJL() != null && bVar.aJM() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.aJM()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.aJM());
            this.etK.setData(bVar.aJL());
            this.etJ.setData(this.mDataList);
            this.FH.setVisibility(0);
            bg(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJW() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.etL.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.etJ.setData(this.mDataList);
        bg(this.etL.size(), this.mDataList.size());
    }

    public List<Integer> aJX() {
        ArrayList arrayList = new ArrayList(this.etL);
        arrayList.add(0, Integer.valueOf(this.etK.aJT()));
        return arrayList;
    }
}
