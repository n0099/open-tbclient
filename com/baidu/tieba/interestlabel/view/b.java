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
    private NoNetworkView eli;
    private LabelRecommendActivity hUM;
    private View hUN;
    private TextView hUO;
    private TextView hUP;
    private com.baidu.tieba.interestlabel.a.a hUQ;
    private a hUR;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> hUS = new ArrayList();
    private View.OnClickListener hUT = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.hUS.contains(valueOf)) {
                    b.this.hUS.remove(valueOf);
                } else {
                    b.this.hUS.add(valueOf);
                }
                b.this.cbi();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.hUM = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.hUM.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.hUM.findViewById(R.id.view_root);
        this.hUN = this.hUM.findViewById(R.id.statebar_view);
        this.hUO = (TextView) this.hUM.findViewById(R.id.skip);
        this.eli = (NoNetworkView) this.hUM.findViewById(R.id.view_no_network);
        this.hUP = (TextView) this.hUM.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.hUN.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        ck(0, 0);
        this.AG = (BdListView) this.hUM.findViewById(R.id.listview);
        this.hUQ = new com.baidu.tieba.interestlabel.a.a(this.hUM.getPageContext().getPageActivity());
        this.hUQ.setOnClickListener(this.hUT);
        this.hUR = new a(this.hUM.getPageContext().getPageActivity());
        this.AG.addHeaderView(this.hUR.cbe());
        this.AG.setAdapter((ListAdapter) this.hUQ);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        am.setViewTextColor(this.hUO, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.hUP, (int) R.drawable.color_sub_lable_selector);
        am.setBackgroundResource(this.hUP, R.drawable.bule_bg_commen_label_button);
        this.eli.onChangeSkinType(this.hUM.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void ck(int i, int i2) {
        this.hUP.setEnabled(i > 0);
        this.hUP.setText(this.hUM.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.hUP.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.hUO.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View cbg() {
        return this.hUO;
    }

    public View cbh() {
        return this.hUP;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.caX() != null && bVar.caY() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.caY()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.caY());
            this.hUR.setData(bVar.caX());
            this.hUQ.setData(this.mDataList);
            this.AG.setVisibility(0);
            ck(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbi() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.hUS.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.hUQ.setData(this.mDataList);
        ck(this.hUS.size(), this.mDataList.size());
    }

    public List<Integer> cbj() {
        ArrayList arrayList = new ArrayList(this.hUS);
        arrayList.add(0, Integer.valueOf(this.hUR.cbf()));
        return arrayList;
    }
}
