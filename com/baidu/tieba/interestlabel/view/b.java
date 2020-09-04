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
    private NoNetworkView fDZ;
    private LabelRecommendActivity jLA;
    private View jLB;
    private TextView jLC;
    private TextView jLD;
    private com.baidu.tieba.interestlabel.a.a jLE;
    private a jLF;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> jLG = new ArrayList();
    private View.OnClickListener jLH = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.jLG.contains(valueOf)) {
                    b.this.jLG.remove(valueOf);
                } else {
                    b.this.jLG.add(valueOf);
                }
                b.this.cLv();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.jLA = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.jLA.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.jLA.findViewById(R.id.view_root);
        this.jLB = this.jLA.findViewById(R.id.statebar_view);
        this.jLC = (TextView) this.jLA.findViewById(R.id.skip);
        this.fDZ = (NoNetworkView) this.jLA.findViewById(R.id.view_no_network);
        this.jLD = (TextView) this.jLA.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.jLB.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cN(0, 0);
        this.Vo = (BdListView) this.jLA.findViewById(R.id.listview);
        this.jLE = new com.baidu.tieba.interestlabel.a.a(this.jLA.getPageContext().getPageActivity());
        this.jLE.setOnClickListener(this.jLH);
        this.jLF = new a(this.jLA.getPageContext().getPageActivity());
        this.Vo.addHeaderView(this.jLF.cLr());
        this.Vo.setAdapter((ListAdapter) this.jLE);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.jLC, R.color.cp_cont_d);
        ap.setViewTextColor(this.jLD, R.drawable.color_sub_lable_selector);
        ap.setBackgroundResource(this.jLD, R.drawable.bule_bg_commen_label_button);
        this.fDZ.onChangeSkinType(this.jLA.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cN(int i, int i2) {
        this.jLD.setEnabled(i > 0);
        this.jLD.setText(this.jLA.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.jLD.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.jLC.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View cLt() {
        return this.jLC;
    }

    public View cLu() {
        return this.jLD;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.cLk() != null && bVar.cLl() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.cLl()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.cLl());
            this.jLF.setData(bVar.cLk());
            this.jLE.setData(this.mDataList);
            this.Vo.setVisibility(0);
            cN(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLv() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.jLG.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.jLE.setData(this.mDataList);
        cN(this.jLG.size(), this.mDataList.size());
    }

    public List<Integer> cLw() {
        ArrayList arrayList = new ArrayList(this.jLG);
        arrayList.add(0, Integer.valueOf(this.jLF.cLs()));
        return arrayList;
    }
}
