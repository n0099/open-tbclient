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
/* loaded from: classes17.dex */
public class b {
    private BdListView Vo;
    private NoNetworkView fDV;
    private LabelRecommendActivity jLu;
    private View jLv;
    private TextView jLw;
    private TextView jLx;
    private com.baidu.tieba.interestlabel.a.a jLy;
    private a jLz;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> jLA = new ArrayList();
    private View.OnClickListener jLB = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.jLA.contains(valueOf)) {
                    b.this.jLA.remove(valueOf);
                } else {
                    b.this.jLA.add(valueOf);
                }
                b.this.cLu();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.jLu = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.jLu.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.jLu.findViewById(R.id.view_root);
        this.jLv = this.jLu.findViewById(R.id.statebar_view);
        this.jLw = (TextView) this.jLu.findViewById(R.id.skip);
        this.fDV = (NoNetworkView) this.jLu.findViewById(R.id.view_no_network);
        this.jLx = (TextView) this.jLu.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.jLv.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cN(0, 0);
        this.Vo = (BdListView) this.jLu.findViewById(R.id.listview);
        this.jLy = new com.baidu.tieba.interestlabel.a.a(this.jLu.getPageContext().getPageActivity());
        this.jLy.setOnClickListener(this.jLB);
        this.jLz = new a(this.jLu.getPageContext().getPageActivity());
        this.Vo.addHeaderView(this.jLz.cLq());
        this.Vo.setAdapter((ListAdapter) this.jLy);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.jLw, R.color.cp_cont_d);
        ap.setViewTextColor(this.jLx, R.drawable.color_sub_lable_selector);
        ap.setBackgroundResource(this.jLx, R.drawable.bule_bg_commen_label_button);
        this.fDV.onChangeSkinType(this.jLu.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cN(int i, int i2) {
        this.jLx.setEnabled(i > 0);
        this.jLx.setText(this.jLu.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.jLx.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.jLw.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View cLs() {
        return this.jLw;
    }

    public View cLt() {
        return this.jLx;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.cLj() != null && bVar.cLk() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.cLk()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.cLk());
            this.jLz.setData(bVar.cLj());
            this.jLy.setData(this.mDataList);
            this.Vo.setVisibility(0);
            cN(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLu() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.jLA.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.jLy.setData(this.mDataList);
        cN(this.jLA.size(), this.mDataList.size());
    }

    public List<Integer> cLv() {
        ArrayList arrayList = new ArrayList(this.jLA);
        arrayList.add(0, Integer.valueOf(this.jLz.cLr()));
        return arrayList;
    }
}
