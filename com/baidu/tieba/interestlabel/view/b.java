package com.baidu.tieba.interestlabel.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.e;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private BdListView OF;
    private NoNetworkView bKI;
    private View emW;
    private LabelRecommendActivity fcZ;
    private TextView fda;
    private TextView fdb;
    private com.baidu.tieba.interestlabel.a.a fdc;
    private a fdd;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> fde = new ArrayList();
    private View.OnClickListener fdf = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.fde.contains(valueOf)) {
                    b.this.fde.remove(valueOf);
                } else {
                    b.this.fde.add(valueOf);
                }
                b.this.aVu();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.fcZ = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.fcZ.setContentView(e.h.activity_label_recommend);
        this.mRootView = (ViewGroup) this.fcZ.findViewById(e.g.view_root);
        this.emW = this.fcZ.findViewById(e.g.statebar_view);
        this.fda = (TextView) this.fcZ.findViewById(e.g.skip);
        this.bKI = (NoNetworkView) this.fcZ.findViewById(e.g.view_no_network);
        this.fdb = (TextView) this.fcZ.findViewById(e.g.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.emW.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        bs(0, 0);
        this.OF = (BdListView) this.fcZ.findViewById(e.g.listview);
        this.fdc = new com.baidu.tieba.interestlabel.a.a(this.fcZ.getPageContext().getPageActivity());
        this.fdc.setOnClickListener(this.fdf);
        this.fdd = new a(this.fcZ.getPageContext().getPageActivity());
        this.OF.addHeaderView(this.fdd.aVq());
        this.OF.setAdapter((ListAdapter) this.fdc);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        al.h(this.fda, e.d.cp_cont_d);
        al.h(this.fdb, e.f.color_sub_lable_selector);
        al.i(this.fdb, e.f.bule_bg_commen_label_button);
        this.bKI.onChangeSkinType(this.fcZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void bs(int i, int i2) {
        this.fdb.setEnabled(i > 0);
        this.fdb.setText(this.fcZ.getString(e.j.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.fdb.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.fda.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View aVs() {
        return this.fda;
    }

    public View aVt() {
        return this.fdb;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.aVj() != null && bVar.aVk() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.aVk()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.aVk());
            this.fdd.setData(bVar.aVj());
            this.fdc.setData(this.mDataList);
            this.OF.setVisibility(0);
            bs(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVu() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.fde.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.fdc.setData(this.mDataList);
        bs(this.fde.size(), this.mDataList.size());
    }

    public List<Integer> aVv() {
        ArrayList arrayList = new ArrayList(this.fde);
        arrayList.add(0, Integer.valueOf(this.fdd.aVr()));
        return arrayList;
    }
}
