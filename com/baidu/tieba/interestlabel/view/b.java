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
/* loaded from: classes8.dex */
public class b {
    private BdListView WV;
    private NoNetworkView gCe;
    private LabelRecommendActivity kUI;
    private View kUJ;
    private TextView kUK;
    private TextView kUL;
    private com.baidu.tieba.interestlabel.a.a kUM;
    private a kUN;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> kUO = new ArrayList();
    private View.OnClickListener kUP = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.kUO.contains(valueOf)) {
                    b.this.kUO.remove(valueOf);
                } else {
                    b.this.kUO.add(valueOf);
                }
                b.this.dcJ();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.kUI = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.kUI.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.kUI.findViewById(R.id.view_root);
        this.kUJ = this.kUI.findViewById(R.id.statebar_view);
        this.kUK = (TextView) this.kUI.findViewById(R.id.skip);
        this.gCe = (NoNetworkView) this.kUI.findViewById(R.id.view_no_network);
        this.kUL = (TextView) this.kUI.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.kUJ.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cV(0, 0);
        this.WV = (BdListView) this.kUI.findViewById(R.id.listview);
        this.kUM = new com.baidu.tieba.interestlabel.a.a(this.kUI.getPageContext().getPageActivity());
        this.kUM.setOnClickListener(this.kUP);
        this.kUN = new a(this.kUI.getPageContext().getPageActivity());
        this.WV.addHeaderView(this.kUN.dcF());
        this.WV.setAdapter((ListAdapter) this.kUM);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        ao.setViewTextColor(this.kUK, R.color.CAM_X0109);
        ao.setViewTextColor(this.kUL, R.drawable.color_sub_lable_selector);
        ao.setBackgroundResource(this.kUL, R.drawable.bule_bg_commen_label_button);
        this.gCe.onChangeSkinType(this.kUI.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cV(int i, int i2) {
        this.kUL.setEnabled(i > 0);
        this.kUL.setText(this.kUI.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.kUL.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.kUK.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View dcH() {
        return this.kUK;
    }

    public View dcI() {
        return this.kUL;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.dcy() != null && bVar.dcz() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.dcz()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.dcz());
            this.kUN.setData(bVar.dcy());
            this.kUM.setData(this.mDataList);
            this.WV.setVisibility(0);
            cV(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dcJ() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.kUO.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.kUM.setData(this.mDataList);
        cV(this.kUO.size(), this.mDataList.size());
    }

    public List<Integer> dcK() {
        ArrayList arrayList = new ArrayList(this.kUO);
        arrayList.add(0, Integer.valueOf(this.kUN.dcG()));
        return arrayList;
    }
}
