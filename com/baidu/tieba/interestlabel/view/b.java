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
/* loaded from: classes8.dex */
public class b {
    private BdListView WO;
    private NoNetworkView gAv;
    private LabelRecommendActivity kYt;
    private View kYu;
    private TextView kYv;
    private TextView kYw;
    private com.baidu.tieba.interestlabel.a.a kYx;
    private a kYy;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> kYz = new ArrayList();
    private View.OnClickListener kYA = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.kYz.contains(valueOf)) {
                    b.this.kYz.remove(valueOf);
                } else {
                    b.this.kYz.add(valueOf);
                }
                b.this.daX();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.kYt = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.kYt.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.kYt.findViewById(R.id.view_root);
        this.kYu = this.kYt.findViewById(R.id.statebar_view);
        this.kYv = (TextView) this.kYt.findViewById(R.id.skip);
        this.gAv = (NoNetworkView) this.kYt.findViewById(R.id.view_no_network);
        this.kYw = (TextView) this.kYt.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.kYu.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cT(0, 0);
        this.WO = (BdListView) this.kYt.findViewById(R.id.listview);
        this.kYx = new com.baidu.tieba.interestlabel.a.a(this.kYt.getPageContext().getPageActivity());
        this.kYx.setOnClickListener(this.kYA);
        this.kYy = new a(this.kYt.getPageContext().getPageActivity());
        this.WO.addHeaderView(this.kYy.daT());
        this.WO.setAdapter((ListAdapter) this.kYx);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ap.setViewTextColor(this.kYv, R.color.CAM_X0109);
        ap.setViewTextColor(this.kYw, R.drawable.color_sub_lable_selector);
        ap.setBackgroundResource(this.kYw, R.drawable.bule_bg_commen_label_button);
        this.gAv.onChangeSkinType(this.kYt.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cT(int i, int i2) {
        this.kYw.setEnabled(i > 0);
        this.kYw.setText(this.kYt.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.kYw.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.kYv.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View daV() {
        return this.kYv;
    }

    public View daW() {
        return this.kYw;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.daM() != null && bVar.daN() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.daN()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.daN());
            this.kYy.setData(bVar.daM());
            this.kYx.setData(this.mDataList);
            this.WO.setVisibility(0);
            cT(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daX() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.kYz.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.kYx.setData(this.mDataList);
        cT(this.kYz.size(), this.mDataList.size());
    }

    public List<Integer> daY() {
        ArrayList arrayList = new ArrayList(this.kYz);
        arrayList.add(0, Integer.valueOf(this.kYy.daU()));
        return arrayList;
    }
}
