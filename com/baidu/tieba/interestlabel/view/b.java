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
    private BdListView LO;
    private NoNetworkView bvz;
    private View dWv;
    private LabelRecommendActivity eMG;
    private TextView eMH;
    private TextView eMI;
    private com.baidu.tieba.interestlabel.a.a eMJ;
    private a eMK;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> eML = new ArrayList();
    private View.OnClickListener eMM = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.eML.contains(valueOf)) {
                    b.this.eML.remove(valueOf);
                } else {
                    b.this.eML.add(valueOf);
                }
                b.this.aQy();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.eMG = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.eMG.setContentView(d.h.activity_label_recommend);
        this.mRootView = (ViewGroup) this.eMG.findViewById(d.g.view_root);
        this.dWv = this.eMG.findViewById(d.g.statebar_view);
        this.eMH = (TextView) this.eMG.findViewById(d.g.skip);
        this.bvz = (NoNetworkView) this.eMG.findViewById(d.g.view_no_network);
        this.eMI = (TextView) this.eMG.findViewById(d.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.dWv.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bj(0, 0);
        this.LO = (BdListView) this.eMG.findViewById(d.g.listview);
        this.eMJ = new com.baidu.tieba.interestlabel.a.a(this.eMG.getPageContext().getPageActivity());
        this.eMJ.setOnClickListener(this.eMM);
        this.eMK = new a(this.eMG.getPageContext().getPageActivity());
        this.LO.addHeaderView(this.eMK.aQu());
        this.LO.setAdapter((ListAdapter) this.eMJ);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.h(this.eMH, d.C0140d.cp_cont_d);
        am.h(this.eMI, d.f.color_sub_lable_selector);
        am.i(this.eMI, d.f.bule_bg_commen_label_button);
        this.bvz.onChangeSkinType(this.eMG.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bj(int i, int i2) {
        this.eMI.setEnabled(i > 0);
        this.eMI.setText(this.eMG.getString(d.j.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.eMI.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.eMH.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View aQw() {
        return this.eMH;
    }

    public View aQx() {
        return this.eMI;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.aQn() != null && bVar.aQo() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.aQo()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.aQo());
            this.eMK.setData(bVar.aQn());
            this.eMJ.setData(this.mDataList);
            this.LO.setVisibility(0);
            bj(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQy() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.eML.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.eMJ.setData(this.mDataList);
        bj(this.eML.size(), this.mDataList.size());
    }

    public List<Integer> aQz() {
        ArrayList arrayList = new ArrayList(this.eML);
        arrayList.add(0, Integer.valueOf(this.eMK.aQv()));
        return arrayList;
    }
}
