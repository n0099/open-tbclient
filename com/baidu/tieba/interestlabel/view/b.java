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
    private BdListView Nj;
    private NoNetworkView dpy;
    private View giq;
    private LabelRecommendActivity hdP;
    private TextView hdQ;
    private TextView hdR;
    private com.baidu.tieba.interestlabel.a.a hdS;
    private a hdT;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> hdU = new ArrayList();
    private View.OnClickListener hdV = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).bGk);
                if (b.this.hdU.contains(valueOf)) {
                    b.this.hdU.remove(valueOf);
                } else {
                    b.this.hdU.add(valueOf);
                }
                b.this.bKy();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.hdP = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.hdP.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.hdP.findViewById(R.id.view_root);
        this.giq = this.hdP.findViewById(R.id.statebar_view);
        this.hdQ = (TextView) this.hdP.findViewById(R.id.skip);
        this.dpy = (NoNetworkView) this.hdP.findViewById(R.id.view_no_network);
        this.hdR = (TextView) this.hdP.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.giq.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        ca(0, 0);
        this.Nj = (BdListView) this.hdP.findViewById(R.id.listview);
        this.hdS = new com.baidu.tieba.interestlabel.a.a(this.hdP.getPageContext().getPageActivity());
        this.hdS.setOnClickListener(this.hdV);
        this.hdT = new a(this.hdP.getPageContext().getPageActivity());
        this.Nj.addHeaderView(this.hdT.bKu());
        this.Nj.setAdapter((ListAdapter) this.hdS);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.j(this.hdQ, R.color.cp_cont_d);
        am.j(this.hdR, R.drawable.color_sub_lable_selector);
        am.k(this.hdR, R.drawable.bule_bg_commen_label_button);
        this.dpy.onChangeSkinType(this.hdP.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void ca(int i, int i2) {
        this.hdR.setEnabled(i > 0);
        this.hdR.setText(this.hdP.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.hdR.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.hdQ.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View bKw() {
        return this.hdQ;
    }

    public View bKx() {
        return this.hdR;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.bKn() != null && bVar.bKo() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.bKo()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.bKo());
            this.hdT.setData(bVar.bKn());
            this.hdS.setData(this.mDataList);
            this.Nj.setVisibility(0);
            ca(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKy() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.hdU.contains(Integer.valueOf(aVar.bGk));
            }
        }
        this.hdS.setData(this.mDataList);
        ca(this.hdU.size(), this.mDataList.size());
    }

    public List<Integer> bKz() {
        ArrayList arrayList = new ArrayList(this.hdU);
        arrayList.add(0, Integer.valueOf(this.hdT.bKv()));
        return arrayList;
    }
}
