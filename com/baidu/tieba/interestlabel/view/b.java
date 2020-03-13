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
    private BdListView AG;
    private NoNetworkView elv;
    private LabelRecommendActivity hUY;
    private View hUZ;
    private TextView hVa;
    private TextView hVb;
    private com.baidu.tieba.interestlabel.a.a hVc;
    private a hVd;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> hVe = new ArrayList();
    private View.OnClickListener hVf = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.hVe.contains(valueOf)) {
                    b.this.hVe.remove(valueOf);
                } else {
                    b.this.hVe.add(valueOf);
                }
                b.this.cbj();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.hUY = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.hUY.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.hUY.findViewById(R.id.view_root);
        this.hUZ = this.hUY.findViewById(R.id.statebar_view);
        this.hVa = (TextView) this.hUY.findViewById(R.id.skip);
        this.elv = (NoNetworkView) this.hUY.findViewById(R.id.view_no_network);
        this.hVb = (TextView) this.hUY.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.hUZ.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        ck(0, 0);
        this.AG = (BdListView) this.hUY.findViewById(R.id.listview);
        this.hVc = new com.baidu.tieba.interestlabel.a.a(this.hUY.getPageContext().getPageActivity());
        this.hVc.setOnClickListener(this.hVf);
        this.hVd = new a(this.hUY.getPageContext().getPageActivity());
        this.AG.addHeaderView(this.hVd.cbf());
        this.AG.setAdapter((ListAdapter) this.hVc);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.hVa, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.hVb, (int) R.drawable.color_sub_lable_selector);
        am.setBackgroundResource(this.hVb, R.drawable.bule_bg_commen_label_button);
        this.elv.onChangeSkinType(this.hUY.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void ck(int i, int i2) {
        this.hVb.setEnabled(i > 0);
        this.hVb.setText(this.hUY.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.hVb.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.hVa.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View cbh() {
        return this.hVa;
    }

    public View cbi() {
        return this.hVb;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.caY() != null && bVar.caZ() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.caZ()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.caZ());
            this.hVd.setData(bVar.caY());
            this.hVc.setData(this.mDataList);
            this.AG.setVisibility(0);
            ck(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbj() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.hVe.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.hVc.setData(this.mDataList);
        ck(this.hVe.size(), this.mDataList.size());
    }

    public List<Integer> cbk() {
        ArrayList arrayList = new ArrayList(this.hVe);
        arrayList.add(0, Integer.valueOf(this.hVd.cbg()));
        return arrayList;
    }
}
