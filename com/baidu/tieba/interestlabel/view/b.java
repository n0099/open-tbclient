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
    private BdListView Ni;
    private NoNetworkView dnF;
    private View gfH;
    private LabelRecommendActivity hbd;
    private TextView hbe;
    private TextView hbf;
    private com.baidu.tieba.interestlabel.a.a hbg;
    private a hbh;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> hbi = new ArrayList();
    private View.OnClickListener hbj = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).bFL);
                if (b.this.hbi.contains(valueOf)) {
                    b.this.hbi.remove(valueOf);
                } else {
                    b.this.hbi.add(valueOf);
                }
                b.this.bJx();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.hbd = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.hbd.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.hbd.findViewById(R.id.view_root);
        this.gfH = this.hbd.findViewById(R.id.statebar_view);
        this.hbe = (TextView) this.hbd.findViewById(R.id.skip);
        this.dnF = (NoNetworkView) this.hbd.findViewById(R.id.view_no_network);
        this.hbf = (TextView) this.hbd.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.gfH.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        ca(0, 0);
        this.Ni = (BdListView) this.hbd.findViewById(R.id.listview);
        this.hbg = new com.baidu.tieba.interestlabel.a.a(this.hbd.getPageContext().getPageActivity());
        this.hbg.setOnClickListener(this.hbj);
        this.hbh = new a(this.hbd.getPageContext().getPageActivity());
        this.Ni.addHeaderView(this.hbh.bJt());
        this.Ni.setAdapter((ListAdapter) this.hbg);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.j(this.hbe, R.color.cp_cont_d);
        am.j(this.hbf, R.drawable.color_sub_lable_selector);
        am.k(this.hbf, R.drawable.bule_bg_commen_label_button);
        this.dnF.onChangeSkinType(this.hbd.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void ca(int i, int i2) {
        this.hbf.setEnabled(i > 0);
        this.hbf.setText(this.hbd.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.hbf.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.hbe.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View bJv() {
        return this.hbe;
    }

    public View bJw() {
        return this.hbf;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.bJm() != null && bVar.bJn() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.bJn()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.bJn());
            this.hbh.setData(bVar.bJm());
            this.hbg.setData(this.mDataList);
            this.Ni.setVisibility(0);
            ca(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJx() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.hbi.contains(Integer.valueOf(aVar.bFL));
            }
        }
        this.hbg.setData(this.mDataList);
        ca(this.hbi.size(), this.mDataList.size());
    }

    public List<Integer> bJy() {
        ArrayList arrayList = new ArrayList(this.hbi);
        arrayList.add(0, Integer.valueOf(this.hbh.bJu()));
        return arrayList;
    }
}
