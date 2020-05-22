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
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private BdListView Um;
    private NoNetworkView fbX;
    private LabelRecommendActivity iVt;
    private View iVu;
    private TextView iVv;
    private TextView iVw;
    private com.baidu.tieba.interestlabel.a.a iVx;
    private a iVy;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> iVz = new ArrayList();
    private View.OnClickListener iVA = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.iVz.contains(valueOf)) {
                    b.this.iVz.remove(valueOf);
                } else {
                    b.this.iVz.add(valueOf);
                }
                b.this.csE();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.iVt = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.iVt.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.iVt.findViewById(R.id.view_root);
        this.iVu = this.iVt.findViewById(R.id.statebar_view);
        this.iVv = (TextView) this.iVt.findViewById(R.id.skip);
        this.fbX = (NoNetworkView) this.iVt.findViewById(R.id.view_no_network);
        this.iVw = (TextView) this.iVt.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.iVu.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cw(0, 0);
        this.Um = (BdListView) this.iVt.findViewById(R.id.listview);
        this.iVx = new com.baidu.tieba.interestlabel.a.a(this.iVt.getPageContext().getPageActivity());
        this.iVx.setOnClickListener(this.iVA);
        this.iVy = new a(this.iVt.getPageContext().getPageActivity());
        this.Um.addHeaderView(this.iVy.csA());
        this.Um.setAdapter((ListAdapter) this.iVx);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.iVv, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.iVw, (int) R.drawable.color_sub_lable_selector);
        am.setBackgroundResource(this.iVw, R.drawable.bule_bg_commen_label_button);
        this.fbX.onChangeSkinType(this.iVt.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cw(int i, int i2) {
        this.iVw.setEnabled(i > 0);
        this.iVw.setText(this.iVt.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.iVw.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.iVv.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View csC() {
        return this.iVv;
    }

    public View csD() {
        return this.iVw;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.cst() != null && bVar.csu() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.csu()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.csu());
            this.iVy.setData(bVar.cst());
            this.iVx.setData(this.mDataList);
            this.Um.setVisibility(0);
            cw(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csE() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.iVz.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.iVx.setData(this.mDataList);
        cw(this.iVz.size(), this.mDataList.size());
    }

    public List<Integer> csF() {
        ArrayList arrayList = new ArrayList(this.iVz);
        arrayList.add(0, Integer.valueOf(this.iVy.csB()));
        return arrayList;
    }
}
