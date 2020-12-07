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
    private NoNetworkView grd;
    private LabelRecommendActivity kPb;
    private View kPc;
    private TextView kPd;
    private TextView kPe;
    private com.baidu.tieba.interestlabel.a.a kPf;
    private a kPg;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> kPh = new ArrayList();
    private View.OnClickListener kPi = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.kPh.contains(valueOf)) {
                    b.this.kPh.remove(valueOf);
                } else {
                    b.this.kPh.add(valueOf);
                }
                b.this.dcY();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.kPb = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.kPb.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.kPb.findViewById(R.id.view_root);
        this.kPc = this.kPb.findViewById(R.id.statebar_view);
        this.kPd = (TextView) this.kPb.findViewById(R.id.skip);
        this.grd = (NoNetworkView) this.kPb.findViewById(R.id.view_no_network);
        this.kPe = (TextView) this.kPb.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.kPc.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cZ(0, 0);
        this.WX = (BdListView) this.kPb.findViewById(R.id.listview);
        this.kPf = new com.baidu.tieba.interestlabel.a.a(this.kPb.getPageContext().getPageActivity());
        this.kPf.setOnClickListener(this.kPi);
        this.kPg = new a(this.kPb.getPageContext().getPageActivity());
        this.WX.addHeaderView(this.kPg.dcU());
        this.WX.setAdapter((ListAdapter) this.kPf);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.kPd, R.color.CAM_X0109);
        ap.setViewTextColor(this.kPe, R.drawable.color_sub_lable_selector);
        ap.setBackgroundResource(this.kPe, R.drawable.bule_bg_commen_label_button);
        this.grd.onChangeSkinType(this.kPb.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cZ(int i, int i2) {
        this.kPe.setEnabled(i > 0);
        this.kPe.setText(this.kPb.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.kPe.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.kPd.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View dcW() {
        return this.kPd;
    }

    public View dcX() {
        return this.kPe;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.dcN() != null && bVar.dcO() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.dcO()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.dcO());
            this.kPg.setData(bVar.dcN());
            this.kPf.setData(this.mDataList);
            this.WX.setVisibility(0);
            cZ(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcY() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.kPh.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.kPf.setData(this.mDataList);
        cZ(this.kPh.size(), this.mDataList.size());
    }

    public List<Integer> dcZ() {
        ArrayList arrayList = new ArrayList(this.kPh);
        arrayList.add(0, Integer.valueOf(this.kPg.dcV()));
        return arrayList;
    }
}
