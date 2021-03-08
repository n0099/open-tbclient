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
/* loaded from: classes7.dex */
public class b {
    private BdListView Yj;
    private NoNetworkView gCe;
    private com.baidu.tieba.interestlabel.a.a laA;
    private a laB;
    private LabelRecommendActivity law;
    private View lax;
    private TextView lay;
    private TextView laz;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> laC = new ArrayList();
    private View.OnClickListener laD = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.laC.contains(valueOf)) {
                    b.this.laC.remove(valueOf);
                } else {
                    b.this.laC.add(valueOf);
                }
                b.this.dbg();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.law = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.law.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.law.findViewById(R.id.view_root);
        this.lax = this.law.findViewById(R.id.statebar_view);
        this.lay = (TextView) this.law.findViewById(R.id.skip);
        this.gCe = (NoNetworkView) this.law.findViewById(R.id.view_no_network);
        this.laz = (TextView) this.law.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.lax.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cT(0, 0);
        this.Yj = (BdListView) this.law.findViewById(R.id.listview);
        this.laA = new com.baidu.tieba.interestlabel.a.a(this.law.getPageContext().getPageActivity());
        this.laA.setOnClickListener(this.laD);
        this.laB = new a(this.law.getPageContext().getPageActivity());
        this.Yj.addHeaderView(this.laB.dbc());
        this.Yj.setAdapter((ListAdapter) this.laA);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.lay, R.color.CAM_X0109);
        ap.setViewTextColor(this.laz, R.drawable.color_sub_lable_selector);
        ap.setBackgroundResource(this.laz, R.drawable.bule_bg_commen_label_button);
        this.gCe.onChangeSkinType(this.law.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cT(int i, int i2) {
        this.laz.setEnabled(i > 0);
        this.laz.setText(this.law.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.laz.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.lay.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View dbe() {
        return this.lay;
    }

    public View dbf() {
        return this.laz;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.daV() != null && bVar.daW() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.daW()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.daW());
            this.laB.setData(bVar.daV());
            this.laA.setData(this.mDataList);
            this.Yj.setVisibility(0);
            cT(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbg() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.laC.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.laA.setData(this.mDataList);
        cT(this.laC.size(), this.mDataList.size());
    }

    public List<Integer> dbh() {
        ArrayList arrayList = new ArrayList(this.laC);
        arrayList.add(0, Integer.valueOf(this.laB.dbd()));
        return arrayList;
    }
}
