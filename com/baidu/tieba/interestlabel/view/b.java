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
    private LabelRecommendActivity jvZ;
    private View jwa;
    private TextView jwb;
    private TextView jwc;
    private com.baidu.tieba.interestlabel.a.a jwd;
    private a jwe;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> jwf = new ArrayList();
    private View.OnClickListener jwg = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.jwf.contains(valueOf)) {
                    b.this.jwf.remove(valueOf);
                } else {
                    b.this.jwf.add(valueOf);
                }
                b.this.cAC();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.jvZ = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.jvZ.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.jvZ.findViewById(R.id.view_root);
        this.jwa = this.jvZ.findViewById(R.id.statebar_view);
        this.jwb = (TextView) this.jvZ.findViewById(R.id.skip);
        this.fsB = (NoNetworkView) this.jvZ.findViewById(R.id.view_no_network);
        this.jwc = (TextView) this.jvZ.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.jwa.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cF(0, 0);
        this.UL = (BdListView) this.jvZ.findViewById(R.id.listview);
        this.jwd = new com.baidu.tieba.interestlabel.a.a(this.jvZ.getPageContext().getPageActivity());
        this.jwd.setOnClickListener(this.jwg);
        this.jwe = new a(this.jvZ.getPageContext().getPageActivity());
        this.UL.addHeaderView(this.jwe.cAy());
        this.UL.setAdapter((ListAdapter) this.jwd);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ao.setViewTextColor(this.jwb, R.color.cp_cont_d);
        ao.setViewTextColor(this.jwc, R.drawable.color_sub_lable_selector);
        ao.setBackgroundResource(this.jwc, R.drawable.bule_bg_commen_label_button);
        this.fsB.onChangeSkinType(this.jvZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cF(int i, int i2) {
        this.jwc.setEnabled(i > 0);
        this.jwc.setText(this.jvZ.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.jwc.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.jwb.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View cAA() {
        return this.jwb;
    }

    public View cAB() {
        return this.jwc;
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
            this.jwe.setData(bVar.cAr());
            this.jwd.setData(this.mDataList);
            this.UL.setVisibility(0);
            cF(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAC() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.jwf.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.jwd.setData(this.mDataList);
        cF(this.jwf.size(), this.mDataList.size());
    }

    public List<Integer> cAD() {
        ArrayList arrayList = new ArrayList(this.jwf);
        arrayList.add(0, Integer.valueOf(this.jwe.cAz()));
        return arrayList;
    }
}
