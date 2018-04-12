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
    private BdListView FL;
    private NoNetworkView bla;
    private View dDb;
    private LabelRecommendActivity esA;
    private TextView esB;
    private TextView esC;
    private com.baidu.tieba.interestlabel.a.a esD;
    private a esE;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> esF = new ArrayList();
    private View.OnClickListener esG = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view2.getTag()).labelId);
                if (b.this.esF.contains(valueOf)) {
                    b.this.esF.remove(valueOf);
                } else {
                    b.this.esF.add(valueOf);
                }
                b.this.aJX();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.esA = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.esA.setContentView(d.i.activity_label_recommend);
        this.mRootView = (ViewGroup) this.esA.findViewById(d.g.view_root);
        this.dDb = this.esA.findViewById(d.g.statebar_view);
        this.esB = (TextView) this.esA.findViewById(d.g.skip);
        this.bla = (NoNetworkView) this.esA.findViewById(d.g.view_no_network);
        this.esC = (TextView) this.esA.findViewById(d.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dDb.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bh(0, 0);
        this.FL = (BdListView) this.esA.findViewById(d.g.listview);
        this.esD = new com.baidu.tieba.interestlabel.a.a(this.esA.getPageContext().getPageActivity());
        this.esD.setOnClickListener(this.esG);
        this.esE = new a(this.esA.getPageContext().getPageActivity());
        this.FL.addHeaderView(this.esE.aJT());
        this.FL.setAdapter((ListAdapter) this.esD);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ak.h(this.esB, d.C0126d.cp_cont_d);
        ak.h(this.esC, d.f.color_sub_lable_selector);
        ak.i(this.esC, d.f.bule_bg_commen_label_button);
        this.bla.onChangeSkinType(this.esA.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bh(int i, int i2) {
        this.esC.setEnabled(i > 0);
        this.esC.setText(this.esA.getString(d.k.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.esC.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.esB.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View aJV() {
        return this.esB;
    }

    public View aJW() {
        return this.esC;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.aJM() != null && bVar.aJN() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.aJN()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.aJN());
            this.esE.setData(bVar.aJM());
            this.esD.setData(this.mDataList);
            this.FL.setVisibility(0);
            bh(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJX() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.esF.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.esD.setData(this.mDataList);
        bh(this.esF.size(), this.mDataList.size());
    }

    public List<Integer> aJY() {
        ArrayList arrayList = new ArrayList(this.esF);
        arrayList.add(0, Integer.valueOf(this.esE.aJU()));
        return arrayList;
    }
}
