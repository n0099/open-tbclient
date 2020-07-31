package com.baidu.tieba.interestlabel.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes17.dex */
public class b {
    private BdListView UL;
    private NoNetworkView fsB;
    private LabelRecommendActivity jvX;
    private View jvY;
    private TextView jvZ;
    private TextView jwa;
    private com.baidu.tieba.interestlabel.a.a jwb;
    private a jwc;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> jwd = new ArrayList();
    private View.OnClickListener jwe = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.jwd.contains(valueOf)) {
                    b.this.jwd.remove(valueOf);
                } else {
                    b.this.jwd.add(valueOf);
                }
                b.this.cAC();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.jvX = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.jvX.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.jvX.findViewById(R.id.view_root);
        this.jvY = this.jvX.findViewById(R.id.statebar_view);
        this.jvZ = (TextView) this.jvX.findViewById(R.id.skip);
        this.fsB = (NoNetworkView) this.jvX.findViewById(R.id.view_no_network);
        this.jwa = (TextView) this.jvX.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.jvY.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cF(0, 0);
        this.UL = (BdListView) this.jvX.findViewById(R.id.listview);
        this.jwb = new com.baidu.tieba.interestlabel.a.a(this.jvX.getPageContext().getPageActivity());
        this.jwb.setOnClickListener(this.jwe);
        this.jwc = new a(this.jvX.getPageContext().getPageActivity());
        this.UL.addHeaderView(this.jwc.cAy());
        this.UL.setAdapter((ListAdapter) this.jwb);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ao.setViewTextColor(this.jvZ, R.color.cp_cont_d);
        ao.setViewTextColor(this.jwa, R.drawable.color_sub_lable_selector);
        ao.setBackgroundResource(this.jwa, R.drawable.bule_bg_commen_label_button);
        this.fsB.onChangeSkinType(this.jvX.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cF(int i, int i2) {
        this.jwa.setEnabled(i > 0);
        this.jwa.setText(this.jvX.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.jwa.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.jvZ.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View cAA() {
        return this.jvZ;
    }

    public View cAB() {
        return this.jwa;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.cAr() != null && bVar.cAs() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.cAs()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.cAs());
            this.jwc.setData(bVar.cAr());
            this.jwb.setData(this.mDataList);
            this.UL.setVisibility(0);
            cF(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAC() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.jwd.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.jwb.setData(this.mDataList);
        cF(this.jwd.size(), this.mDataList.size());
    }

    public List<Integer> cAD() {
        ArrayList arrayList = new ArrayList(this.jwd);
        arrayList.add(0, Integer.valueOf(this.jwc.cAz()));
        return arrayList;
    }
}
