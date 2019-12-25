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
/* loaded from: classes7.dex */
public class b {
    private BdListView Ak;
    private NoNetworkView egT;
    private View gUt;
    private LabelRecommendActivity hPj;
    private TextView hPk;
    private TextView hPl;
    private com.baidu.tieba.interestlabel.a.a hPm;
    private a hPn;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> hPo = new ArrayList();
    private View.OnClickListener hPp = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.hPo.contains(valueOf)) {
                    b.this.hPo.remove(valueOf);
                } else {
                    b.this.hPo.add(valueOf);
                }
                b.this.bYw();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.hPj = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.hPj.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.hPj.findViewById(R.id.view_root);
        this.gUt = this.hPj.findViewById(R.id.statebar_view);
        this.hPk = (TextView) this.hPj.findViewById(R.id.skip);
        this.egT = (NoNetworkView) this.hPj.findViewById(R.id.view_no_network);
        this.hPl = (TextView) this.hPj.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gUt.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        ck(0, 0);
        this.Ak = (BdListView) this.hPj.findViewById(R.id.listview);
        this.hPm = new com.baidu.tieba.interestlabel.a.a(this.hPj.getPageContext().getPageActivity());
        this.hPm.setOnClickListener(this.hPp);
        this.hPn = new a(this.hPj.getPageContext().getPageActivity());
        this.Ak.addHeaderView(this.hPn.bYs());
        this.Ak.setAdapter((ListAdapter) this.hPm);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.hPk, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.hPl, (int) R.drawable.color_sub_lable_selector);
        am.setBackgroundResource(this.hPl, R.drawable.bule_bg_commen_label_button);
        this.egT.onChangeSkinType(this.hPj.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void ck(int i, int i2) {
        this.hPl.setEnabled(i > 0);
        this.hPl.setText(this.hPj.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.hPl.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.hPk.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View bYu() {
        return this.hPk;
    }

    public View bYv() {
        return this.hPl;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.bYl() != null && bVar.bYm() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.bYm()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.bYm());
            this.hPn.setData(bVar.bYl());
            this.hPm.setData(this.mDataList);
            this.Ak.setVisibility(0);
            ck(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYw() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.hPo.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.hPm.setData(this.mDataList);
        ck(this.hPo.size(), this.mDataList.size());
    }

    public List<Integer> bYx() {
        ArrayList arrayList = new ArrayList(this.hPo);
        arrayList.add(0, Integer.valueOf(this.hPn.bYt()));
        return arrayList;
    }
}
