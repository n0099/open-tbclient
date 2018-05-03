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
    private View dCY;
    private com.baidu.tieba.interestlabel.a.a esA;
    private a esB;
    private LabelRecommendActivity esx;
    private TextView esy;
    private TextView esz;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> esC = new ArrayList();
    private View.OnClickListener esD = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (view2.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view2.getTag()).labelId);
                if (b.this.esC.contains(valueOf)) {
                    b.this.esC.remove(valueOf);
                } else {
                    b.this.esC.add(valueOf);
                }
                b.this.aJX();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.esx = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.esx.setContentView(d.i.activity_label_recommend);
        this.mRootView = (ViewGroup) this.esx.findViewById(d.g.view_root);
        this.dCY = this.esx.findViewById(d.g.statebar_view);
        this.esy = (TextView) this.esx.findViewById(d.g.skip);
        this.bla = (NoNetworkView) this.esx.findViewById(d.g.view_no_network);
        this.esz = (TextView) this.esx.findViewById(d.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dCY.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bg(0, 0);
        this.FL = (BdListView) this.esx.findViewById(d.g.listview);
        this.esA = new com.baidu.tieba.interestlabel.a.a(this.esx.getPageContext().getPageActivity());
        this.esA.setOnClickListener(this.esD);
        this.esB = new a(this.esx.getPageContext().getPageActivity());
        this.FL.addHeaderView(this.esB.aJT());
        this.FL.setAdapter((ListAdapter) this.esA);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ak.h(this.esy, d.C0126d.cp_cont_d);
        ak.h(this.esz, d.f.color_sub_lable_selector);
        ak.i(this.esz, d.f.bule_bg_commen_label_button);
        this.bla.onChangeSkinType(this.esx.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bg(int i, int i2) {
        this.esz.setEnabled(i > 0);
        this.esz.setText(this.esx.getString(d.k.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.esz.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.esy.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View aJV() {
        return this.esy;
    }

    public View aJW() {
        return this.esz;
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
            this.esB.setData(bVar.aJM());
            this.esA.setData(this.mDataList);
            this.FL.setVisibility(0);
            bg(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJX() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.esC.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.esA.setData(this.mDataList);
        bg(this.esC.size(), this.mDataList.size());
    }

    public List<Integer> aJY() {
        ArrayList arrayList = new ArrayList(this.esC);
        arrayList.add(0, Integer.valueOf(this.esB.aJU()));
        return arrayList;
    }
}
