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
/* loaded from: classes5.dex */
public class b {
    private NoNetworkView dvR;
    private View ggW;
    private LabelRecommendActivity hbb;
    private TextView hbc;
    private TextView hbd;
    private com.baidu.tieba.interestlabel.a.a hbe;
    private a hbf;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private BdListView xL;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> hbg = new ArrayList();
    private View.OnClickListener hbh = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.hbg.contains(valueOf)) {
                    b.this.hbg.remove(valueOf);
                } else {
                    b.this.hbg.add(valueOf);
                }
                b.this.bHg();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.hbb = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.hbb.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.hbb.findViewById(R.id.view_root);
        this.ggW = this.hbb.findViewById(R.id.statebar_view);
        this.hbc = (TextView) this.hbb.findViewById(R.id.skip);
        this.dvR = (NoNetworkView) this.hbb.findViewById(R.id.view_no_network);
        this.hbd = (TextView) this.hbb.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.ggW.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bR(0, 0);
        this.xL = (BdListView) this.hbb.findViewById(R.id.listview);
        this.hbe = new com.baidu.tieba.interestlabel.a.a(this.hbb.getPageContext().getPageActivity());
        this.hbe.setOnClickListener(this.hbh);
        this.hbf = new a(this.hbb.getPageContext().getPageActivity());
        this.xL.addHeaderView(this.hbf.bHc());
        this.xL.setAdapter((ListAdapter) this.hbe);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.hbc, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.hbd, (int) R.drawable.color_sub_lable_selector);
        am.setBackgroundResource(this.hbd, R.drawable.bule_bg_commen_label_button);
        this.dvR.onChangeSkinType(this.hbb.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bR(int i, int i2) {
        this.hbd.setEnabled(i > 0);
        this.hbd.setText(this.hbb.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.hbd.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.hbc.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View bHe() {
        return this.hbc;
    }

    public View bHf() {
        return this.hbd;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.bGV() != null && bVar.bGW() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.bGW()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.bGW());
            this.hbf.setData(bVar.bGV());
            this.hbe.setData(this.mDataList);
            this.xL.setVisibility(0);
            bR(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHg() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.hbg.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.hbe.setData(this.mDataList);
        bR(this.hbg.size(), this.mDataList.size());
    }

    public List<Integer> bHh() {
        ArrayList arrayList = new ArrayList(this.hbg);
        arrayList.add(0, Integer.valueOf(this.hbf.bHd()));
        return arrayList;
    }
}
