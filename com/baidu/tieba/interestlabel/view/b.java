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
    private BdListView WX;
    private NoNetworkView grf;
    private LabelRecommendActivity kPd;
    private View kPe;
    private TextView kPf;
    private TextView kPg;
    private com.baidu.tieba.interestlabel.a.a kPh;
    private a kPi;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> kPj = new ArrayList();
    private View.OnClickListener kPk = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.kPj.contains(valueOf)) {
                    b.this.kPj.remove(valueOf);
                } else {
                    b.this.kPj.add(valueOf);
                }
                b.this.dcZ();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.kPd = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.kPd.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.kPd.findViewById(R.id.view_root);
        this.kPe = this.kPd.findViewById(R.id.statebar_view);
        this.kPf = (TextView) this.kPd.findViewById(R.id.skip);
        this.grf = (NoNetworkView) this.kPd.findViewById(R.id.view_no_network);
        this.kPg = (TextView) this.kPd.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.kPe.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cZ(0, 0);
        this.WX = (BdListView) this.kPd.findViewById(R.id.listview);
        this.kPh = new com.baidu.tieba.interestlabel.a.a(this.kPd.getPageContext().getPageActivity());
        this.kPh.setOnClickListener(this.kPk);
        this.kPi = new a(this.kPd.getPageContext().getPageActivity());
        this.WX.addHeaderView(this.kPi.dcV());
        this.WX.setAdapter((ListAdapter) this.kPh);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.kPf, R.color.CAM_X0109);
        ap.setViewTextColor(this.kPg, R.drawable.color_sub_lable_selector);
        ap.setBackgroundResource(this.kPg, R.drawable.bule_bg_commen_label_button);
        this.grf.onChangeSkinType(this.kPd.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cZ(int i, int i2) {
        this.kPg.setEnabled(i > 0);
        this.kPg.setText(this.kPd.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.kPg.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.kPf.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View dcX() {
        return this.kPf;
    }

    public View dcY() {
        return this.kPg;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.dcO() != null && bVar.dcP() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.dcP()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.dcP());
            this.kPi.setData(bVar.dcO());
            this.kPh.setData(this.mDataList);
            this.WX.setVisibility(0);
            cZ(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcZ() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.kPj.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.kPh.setData(this.mDataList);
        cZ(this.kPj.size(), this.mDataList.size());
    }

    public List<Integer> dda() {
        ArrayList arrayList = new ArrayList(this.kPj);
        arrayList.add(0, Integer.valueOf(this.kPi.dcW()));
        return arrayList;
    }
}
