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
    private NoNetworkView elh;
    private LabelRecommendActivity hUK;
    private View hUL;
    private TextView hUM;
    private TextView hUN;
    private com.baidu.tieba.interestlabel.a.a hUO;
    private a hUP;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> hUQ = new ArrayList();
    private View.OnClickListener hUR = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.hUQ.contains(valueOf)) {
                    b.this.hUQ.remove(valueOf);
                } else {
                    b.this.hUQ.add(valueOf);
                }
                b.this.cbg();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.hUK = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.hUK.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.hUK.findViewById(R.id.view_root);
        this.hUL = this.hUK.findViewById(R.id.statebar_view);
        this.hUM = (TextView) this.hUK.findViewById(R.id.skip);
        this.elh = (NoNetworkView) this.hUK.findViewById(R.id.view_no_network);
        this.hUN = (TextView) this.hUK.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.hUL.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        ck(0, 0);
        this.AG = (BdListView) this.hUK.findViewById(R.id.listview);
        this.hUO = new com.baidu.tieba.interestlabel.a.a(this.hUK.getPageContext().getPageActivity());
        this.hUO.setOnClickListener(this.hUR);
        this.hUP = new a(this.hUK.getPageContext().getPageActivity());
        this.AG.addHeaderView(this.hUP.cbc());
        this.AG.setAdapter((ListAdapter) this.hUO);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.hUM, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.hUN, (int) R.drawable.color_sub_lable_selector);
        am.setBackgroundResource(this.hUN, R.drawable.bule_bg_commen_label_button);
        this.elh.onChangeSkinType(this.hUK.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void ck(int i, int i2) {
        this.hUN.setEnabled(i > 0);
        this.hUN.setText(this.hUK.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.hUN.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.hUM.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View cbe() {
        return this.hUM;
    }

    public View cbf() {
        return this.hUN;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.caV() != null && bVar.caW() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.caW()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.caW());
            this.hUP.setData(bVar.caV());
            this.hUO.setData(this.mDataList);
            this.AG.setVisibility(0);
            ck(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbg() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.hUQ.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.hUO.setData(this.mDataList);
        ck(this.hUQ.size(), this.mDataList.size());
    }

    public List<Integer> cbh() {
        ArrayList arrayList = new ArrayList(this.hUQ);
        arrayList.add(0, Integer.valueOf(this.hUP.cbd()));
        return arrayList;
    }
}
