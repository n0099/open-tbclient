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
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b {
    private BdListView MS;
    private NoNetworkView dlW;
    private LabelRecommendActivity gUN;
    private TextView gUO;
    private TextView gUP;
    private com.baidu.tieba.interestlabel.a.a gUQ;
    private a gUR;
    private View gaC;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> gUS = new ArrayList();
    private View.OnClickListener gUT = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.gUS.contains(valueOf)) {
                    b.this.gUS.remove(valueOf);
                } else {
                    b.this.gUS.add(valueOf);
                }
                b.this.bGM();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.gUN = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.gUN.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.gUN.findViewById(R.id.view_root);
        this.gaC = this.gUN.findViewById(R.id.statebar_view);
        this.gUO = (TextView) this.gUN.findViewById(R.id.skip);
        this.dlW = (NoNetworkView) this.gUN.findViewById(R.id.view_no_network);
        this.gUP = (TextView) this.gUN.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gaC.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bU(0, 0);
        this.MS = (BdListView) this.gUN.findViewById(R.id.listview);
        this.gUQ = new com.baidu.tieba.interestlabel.a.a(this.gUN.getPageContext().getPageActivity());
        this.gUQ.setOnClickListener(this.gUT);
        this.gUR = new a(this.gUN.getPageContext().getPageActivity());
        this.MS.addHeaderView(this.gUR.bGI());
        this.MS.setAdapter((ListAdapter) this.gUQ);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.j(this.gUO, R.color.cp_cont_d);
        al.j(this.gUP, R.drawable.color_sub_lable_selector);
        al.k(this.gUP, R.drawable.bule_bg_commen_label_button);
        this.dlW.onChangeSkinType(this.gUN.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bU(int i, int i2) {
        this.gUP.setEnabled(i > 0);
        this.gUP.setText(this.gUN.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.gUP.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.gUO.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View bGK() {
        return this.gUO;
    }

    public View bGL() {
        return this.gUP;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.bGB() != null && bVar.bGC() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.bGC()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.bGC());
            this.gUR.setData(bVar.bGB());
            this.gUQ.setData(this.mDataList);
            this.MS.setVisibility(0);
            bU(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGM() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.gUS.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.gUQ.setData(this.mDataList);
        bU(this.gUS.size(), this.mDataList.size());
    }

    public List<Integer> bGN() {
        ArrayList arrayList = new ArrayList(this.gUS);
        arrayList.add(0, Integer.valueOf(this.gUR.bGJ()));
        return arrayList;
    }
}
