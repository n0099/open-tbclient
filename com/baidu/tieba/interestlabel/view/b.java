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
    private NoNetworkView bPm;
    private View exu;
    private LabelRecommendActivity fnD;
    private TextView fnE;
    private TextView fnF;
    private com.baidu.tieba.interestlabel.a.a fnG;
    private a fnH;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> fnI = new ArrayList();
    private View.OnClickListener fnJ = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.fnI.contains(valueOf)) {
                    b.this.fnI.remove(valueOf);
                } else {
                    b.this.fnI.add(valueOf);
                }
                b.this.aYz();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.fnD = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.fnD.setContentView(e.h.activity_label_recommend);
        this.mRootView = (ViewGroup) this.fnD.findViewById(e.g.view_root);
        this.exu = this.fnD.findViewById(e.g.statebar_view);
        this.fnE = (TextView) this.fnD.findViewById(e.g.skip);
        this.bPm = (NoNetworkView) this.fnD.findViewById(e.g.view_no_network);
        this.fnF = (TextView) this.fnD.findViewById(e.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.exu.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        br(0, 0);
        this.OQ = (BdListView) this.fnD.findViewById(e.g.listview);
        this.fnG = new com.baidu.tieba.interestlabel.a.a(this.fnD.getPageContext().getPageActivity());
        this.fnG.setOnClickListener(this.fnJ);
        this.fnH = new a(this.fnD.getPageContext().getPageActivity());
        this.OQ.addHeaderView(this.fnH.aYv());
        this.OQ.setAdapter((ListAdapter) this.fnG);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.h(this.fnE, e.d.cp_cont_d);
        al.h(this.fnF, e.f.color_sub_lable_selector);
        al.i(this.fnF, e.f.bule_bg_commen_label_button);
        this.bPm.onChangeSkinType(this.fnD.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void br(int i, int i2) {
        this.fnF.setEnabled(i > 0);
        this.fnF.setText(this.fnD.getString(e.j.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.fnF.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.fnE.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View aYx() {
        return this.fnE;
    }

    public View aYy() {
        return this.fnF;
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
            this.fnH.setData(bVar.aYo());
            this.fnG.setData(this.mDataList);
            this.OQ.setVisibility(0);
            br(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYz() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.fnI.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.fnG.setData(this.mDataList);
        br(this.fnI.size(), this.mDataList.size());
    }

    public List<Integer> aYA() {
        ArrayList arrayList = new ArrayList(this.fnI);
        arrayList.add(0, Integer.valueOf(this.fnH.aYw()));
        return arrayList;
    }
}
