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
    private NoNetworkView elL;
    private TextView hWA;
    private TextView hWB;
    private com.baidu.tieba.interestlabel.a.a hWC;
    private a hWD;
    private LabelRecommendActivity hWy;
    private View hWz;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> hWE = new ArrayList();
    private View.OnClickListener hWF = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.hWE.contains(valueOf)) {
                    b.this.hWE.remove(valueOf);
                } else {
                    b.this.hWE.add(valueOf);
                }
                b.this.cbC();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.hWy = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.hWy.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.hWy.findViewById(R.id.view_root);
        this.hWz = this.hWy.findViewById(R.id.statebar_view);
        this.hWA = (TextView) this.hWy.findViewById(R.id.skip);
        this.elL = (NoNetworkView) this.hWy.findViewById(R.id.view_no_network);
        this.hWB = (TextView) this.hWy.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.hWz.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cl(0, 0);
        this.AG = (BdListView) this.hWy.findViewById(R.id.listview);
        this.hWC = new com.baidu.tieba.interestlabel.a.a(this.hWy.getPageContext().getPageActivity());
        this.hWC.setOnClickListener(this.hWF);
        this.hWD = new a(this.hWy.getPageContext().getPageActivity());
        this.AG.addHeaderView(this.hWD.cby());
        this.AG.setAdapter((ListAdapter) this.hWC);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.hWA, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.hWB, (int) R.drawable.color_sub_lable_selector);
        am.setBackgroundResource(this.hWB, R.drawable.bule_bg_commen_label_button);
        this.elL.onChangeSkinType(this.hWy.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cl(int i, int i2) {
        this.hWB.setEnabled(i > 0);
        this.hWB.setText(this.hWy.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.hWB.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.hWA.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View cbA() {
        return this.hWA;
    }

    public View cbB() {
        return this.hWB;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.cbr() != null && bVar.cbs() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.cbs()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.cbs());
            this.hWD.setData(bVar.cbr());
            this.hWC.setData(this.mDataList);
            this.AG.setVisibility(0);
            cl(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbC() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.hWE.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.hWC.setData(this.mDataList);
        cl(this.hWE.size(), this.mDataList.size());
    }

    public List<Integer> cbD() {
        ArrayList arrayList = new ArrayList(this.hWE);
        arrayList.add(0, Integer.valueOf(this.hWD.cbz()));
        return arrayList;
    }
}
