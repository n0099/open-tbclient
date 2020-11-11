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
    private NoNetworkView gjn;
    private LabelRecommendActivity kBu;
    private View kBv;
    private TextView kBw;
    private TextView kBx;
    private com.baidu.tieba.interestlabel.a.a kBy;
    private a kBz;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> kBA = new ArrayList();
    private View.OnClickListener kBB = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.kBA.contains(valueOf)) {
                    b.this.kBA.remove(valueOf);
                } else {
                    b.this.kBA.add(valueOf);
                }
                b.this.cYr();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.kBu = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.kBu.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.kBu.findViewById(R.id.view_root);
        this.kBv = this.kBu.findViewById(R.id.statebar_view);
        this.kBw = (TextView) this.kBu.findViewById(R.id.skip);
        this.gjn = (NoNetworkView) this.kBu.findViewById(R.id.view_no_network);
        this.kBx = (TextView) this.kBu.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.kBv.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cU(0, 0);
        this.VY = (BdListView) this.kBu.findViewById(R.id.listview);
        this.kBy = new com.baidu.tieba.interestlabel.a.a(this.kBu.getPageContext().getPageActivity());
        this.kBy.setOnClickListener(this.kBB);
        this.kBz = new a(this.kBu.getPageContext().getPageActivity());
        this.VY.addHeaderView(this.kBz.cYn());
        this.VY.setAdapter((ListAdapter) this.kBy);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.kBw, R.color.cp_cont_d);
        ap.setViewTextColor(this.kBx, R.drawable.color_sub_lable_selector);
        ap.setBackgroundResource(this.kBx, R.drawable.bule_bg_commen_label_button);
        this.gjn.onChangeSkinType(this.kBu.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cU(int i, int i2) {
        this.kBx.setEnabled(i > 0);
        this.kBx.setText(this.kBu.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.kBx.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.kBw.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View cYp() {
        return this.kBw;
    }

    public View cYq() {
        return this.kBx;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.cYg() != null && bVar.cYh() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.cYh()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.cYh());
            this.kBz.setData(bVar.cYg());
            this.kBy.setData(this.mDataList);
            this.VY.setVisibility(0);
            cU(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYr() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.kBA.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.kBy.setData(this.mDataList);
        cU(this.kBA.size(), this.mDataList.size());
    }

    public List<Integer> cYs() {
        ArrayList arrayList = new ArrayList(this.kBA);
        arrayList.add(0, Integer.valueOf(this.kBz.cYo()));
        return arrayList;
    }
}
