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
import com.baidu.tieba.f;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BdListView LO;
    private NoNetworkView bvB;
    private View dWr;
    private LabelRecommendActivity eMB;
    private TextView eMC;
    private TextView eMD;
    private com.baidu.tieba.interestlabel.a.a eME;
    private a eMF;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> eMG = new ArrayList();
    private View.OnClickListener eMH = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.eMG.contains(valueOf)) {
                    b.this.eMG.remove(valueOf);
                } else {
                    b.this.eMG.add(valueOf);
                }
                b.this.aQv();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.eMB = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.eMB.setContentView(f.h.activity_label_recommend);
        this.mRootView = (ViewGroup) this.eMB.findViewById(f.g.view_root);
        this.dWr = this.eMB.findViewById(f.g.statebar_view);
        this.eMC = (TextView) this.eMB.findViewById(f.g.skip);
        this.bvB = (NoNetworkView) this.eMB.findViewById(f.g.view_no_network);
        this.eMD = (TextView) this.eMB.findViewById(f.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dWr.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bj(0, 0);
        this.LO = (BdListView) this.eMB.findViewById(f.g.listview);
        this.eME = new com.baidu.tieba.interestlabel.a.a(this.eMB.getPageContext().getPageActivity());
        this.eME.setOnClickListener(this.eMH);
        this.eMF = new a(this.eMB.getPageContext().getPageActivity());
        this.LO.addHeaderView(this.eMF.aQr());
        this.LO.setAdapter((ListAdapter) this.eME);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.h(this.eMC, f.d.cp_cont_d);
        am.h(this.eMD, f.C0146f.color_sub_lable_selector);
        am.i(this.eMD, f.C0146f.bule_bg_commen_label_button);
        this.bvB.onChangeSkinType(this.eMB.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bj(int i, int i2) {
        this.eMD.setEnabled(i > 0);
        this.eMD.setText(this.eMB.getString(f.j.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.eMD.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.eMC.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View aQt() {
        return this.eMC;
    }

    public View aQu() {
        return this.eMD;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.aQk() != null && bVar.aQl() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.aQl()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.aQl());
            this.eMF.setData(bVar.aQk());
            this.eME.setData(this.mDataList);
            this.LO.setVisibility(0);
            bj(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQv() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.eMG.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.eME.setData(this.mDataList);
        bj(this.eMG.size(), this.mDataList.size());
    }

    public List<Integer> aQw() {
        ArrayList arrayList = new ArrayList(this.eMG);
        arrayList.add(0, Integer.valueOf(this.eMF.aQs()));
        return arrayList;
    }
}
