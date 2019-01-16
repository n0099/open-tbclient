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
    private BdListView OQ;
    private NoNetworkView bPl;
    private View exs;
    private LabelRecommendActivity fnC;
    private TextView fnD;
    private TextView fnE;
    private com.baidu.tieba.interestlabel.a.a fnF;
    private a fnG;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> fnH = new ArrayList();
    private View.OnClickListener fnI = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.fnH.contains(valueOf)) {
                    b.this.fnH.remove(valueOf);
                } else {
                    b.this.fnH.add(valueOf);
                }
                b.this.aYz();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.fnC = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.fnC.setContentView(e.h.activity_label_recommend);
        this.mRootView = (ViewGroup) this.fnC.findViewById(e.g.view_root);
        this.exs = this.fnC.findViewById(e.g.statebar_view);
        this.fnD = (TextView) this.fnC.findViewById(e.g.skip);
        this.bPl = (NoNetworkView) this.fnC.findViewById(e.g.view_no_network);
        this.fnE = (TextView) this.fnC.findViewById(e.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.exs.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        br(0, 0);
        this.OQ = (BdListView) this.fnC.findViewById(e.g.listview);
        this.fnF = new com.baidu.tieba.interestlabel.a.a(this.fnC.getPageContext().getPageActivity());
        this.fnF.setOnClickListener(this.fnI);
        this.fnG = new a(this.fnC.getPageContext().getPageActivity());
        this.OQ.addHeaderView(this.fnG.aYv());
        this.OQ.setAdapter((ListAdapter) this.fnF);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.h(this.fnD, e.d.cp_cont_d);
        al.h(this.fnE, e.f.color_sub_lable_selector);
        al.i(this.fnE, e.f.bule_bg_commen_label_button);
        this.bPl.onChangeSkinType(this.fnC.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void br(int i, int i2) {
        this.fnE.setEnabled(i > 0);
        this.fnE.setText(this.fnC.getString(e.j.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.fnE.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.fnD.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View aYx() {
        return this.fnD;
    }

    public View aYy() {
        return this.fnE;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.aYo() != null && bVar.aYp() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.aYp()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.aYp());
            this.fnG.setData(bVar.aYo());
            this.fnF.setData(this.mDataList);
            this.OQ.setVisibility(0);
            br(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYz() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.fnH.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.fnF.setData(this.mDataList);
        br(this.fnH.size(), this.mDataList.size());
    }

    public List<Integer> aYA() {
        ArrayList arrayList = new ArrayList(this.fnH);
        arrayList.add(0, Integer.valueOf(this.fnG.aYw()));
        return arrayList;
    }
}
