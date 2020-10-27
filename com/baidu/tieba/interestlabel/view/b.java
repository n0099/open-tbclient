package com.baidu.tieba.interestlabel.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class b {
    private BdListView VY;
    private NoNetworkView gdx;
    private View kvA;
    private TextView kvB;
    private TextView kvC;
    private com.baidu.tieba.interestlabel.a.a kvD;
    private a kvE;
    private LabelRecommendActivity kvz;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> kvF = new ArrayList();
    private View.OnClickListener kvG = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.kvF.contains(valueOf)) {
                    b.this.kvF.remove(valueOf);
                } else {
                    b.this.kvF.add(valueOf);
                }
                b.this.cVQ();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.kvz = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.kvz.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.kvz.findViewById(R.id.view_root);
        this.kvA = this.kvz.findViewById(R.id.statebar_view);
        this.kvB = (TextView) this.kvz.findViewById(R.id.skip);
        this.gdx = (NoNetworkView) this.kvz.findViewById(R.id.view_no_network);
        this.kvC = (TextView) this.kvz.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.kvA.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cS(0, 0);
        this.VY = (BdListView) this.kvz.findViewById(R.id.listview);
        this.kvD = new com.baidu.tieba.interestlabel.a.a(this.kvz.getPageContext().getPageActivity());
        this.kvD.setOnClickListener(this.kvG);
        this.kvE = new a(this.kvz.getPageContext().getPageActivity());
        this.VY.addHeaderView(this.kvE.cVM());
        this.VY.setAdapter((ListAdapter) this.kvD);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.kvB, R.color.cp_cont_d);
        ap.setViewTextColor(this.kvC, R.drawable.color_sub_lable_selector);
        ap.setBackgroundResource(this.kvC, R.drawable.bule_bg_commen_label_button);
        this.gdx.onChangeSkinType(this.kvz.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cS(int i, int i2) {
        this.kvC.setEnabled(i > 0);
        this.kvC.setText(this.kvz.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.kvC.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.kvB.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View cVO() {
        return this.kvB;
    }

    public View cVP() {
        return this.kvC;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.cVF() != null && bVar.cVG() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.cVG()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.cVG());
            this.kvE.setData(bVar.cVF());
            this.kvD.setData(this.mDataList);
            this.VY.setVisibility(0);
            cS(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVQ() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.kvF.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.kvD.setData(this.mDataList);
        cS(this.kvF.size(), this.mDataList.size());
    }

    public List<Integer> cVR() {
        ArrayList arrayList = new ArrayList(this.kvF);
        arrayList.add(0, Integer.valueOf(this.kvE.cVN()));
        return arrayList;
    }
}
