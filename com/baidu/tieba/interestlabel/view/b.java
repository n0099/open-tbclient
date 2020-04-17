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
    private BdListView TX;
    private NoNetworkView ePl;
    private LabelRecommendActivity iGp;
    private View iGq;
    private TextView iGr;
    private TextView iGs;
    private com.baidu.tieba.interestlabel.a.a iGt;
    private a iGu;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> iGv = new ArrayList();
    private View.OnClickListener iGw = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.iGv.contains(valueOf)) {
                    b.this.iGv.remove(valueOf);
                } else {
                    b.this.iGv.add(valueOf);
                }
                b.this.cmd();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.iGp = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.iGp.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.iGp.findViewById(R.id.view_root);
        this.iGq = this.iGp.findViewById(R.id.statebar_view);
        this.iGr = (TextView) this.iGp.findViewById(R.id.skip);
        this.ePl = (NoNetworkView) this.iGp.findViewById(R.id.view_no_network);
        this.iGs = (TextView) this.iGp.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.iGq.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cr(0, 0);
        this.TX = (BdListView) this.iGp.findViewById(R.id.listview);
        this.iGt = new com.baidu.tieba.interestlabel.a.a(this.iGp.getPageContext().getPageActivity());
        this.iGt.setOnClickListener(this.iGw);
        this.iGu = new a(this.iGp.getPageContext().getPageActivity());
        this.TX.addHeaderView(this.iGu.clZ());
        this.TX.setAdapter((ListAdapter) this.iGt);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.iGr, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.iGs, (int) R.drawable.color_sub_lable_selector);
        am.setBackgroundResource(this.iGs, R.drawable.bule_bg_commen_label_button);
        this.ePl.onChangeSkinType(this.iGp.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cr(int i, int i2) {
        this.iGs.setEnabled(i > 0);
        this.iGs.setText(this.iGp.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.iGs.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.iGr.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View cmb() {
        return this.iGr;
    }

    public View cmc() {
        return this.iGs;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.clS() != null && bVar.clT() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.clT()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.clT());
            this.iGu.setData(bVar.clS());
            this.iGt.setData(this.mDataList);
            this.TX.setVisibility(0);
            cr(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmd() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.iGv.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.iGt.setData(this.mDataList);
        cr(this.iGv.size(), this.mDataList.size());
    }

    public List<Integer> cme() {
        ArrayList arrayList = new ArrayList(this.iGv);
        arrayList.add(0, Integer.valueOf(this.iGu.cma()));
        return arrayList;
    }
}
