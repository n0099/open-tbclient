package com.baidu.tieba.interestlabel.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.interestlabel.activity.LabelRecommendActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private BdListView US;
    private NoNetworkView fns;
    private LabelRecommendActivity jnt;
    private View jnu;
    private TextView jnv;
    private TextView jnw;
    private com.baidu.tieba.interestlabel.a.a jnx;
    private a jny;
    private View.OnClickListener mOnClickListener;
    private ViewGroup mRootView;
    private List<com.baidu.tieba.interestlabel.b.a> mDataList = new ArrayList();
    private List<Integer> jnz = new ArrayList();
    private View.OnClickListener jnA = new View.OnClickListener() { // from class: com.baidu.tieba.interestlabel.view.b.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() instanceof com.baidu.tieba.interestlabel.b.a) {
                Integer valueOf = Integer.valueOf(((com.baidu.tieba.interestlabel.b.a) view.getTag()).labelId);
                if (b.this.jnz.contains(valueOf)) {
                    b.this.jnz.remove(valueOf);
                } else {
                    b.this.jnz.add(valueOf);
                }
                b.this.cwD();
            }
        }
    };

    public b(LabelRecommendActivity labelRecommendActivity) {
        if (labelRecommendActivity != null) {
            this.jnt = labelRecommendActivity;
            initView();
        }
    }

    private void initView() {
        this.jnt.setContentView(R.layout.activity_label_recommend);
        this.mRootView = (ViewGroup) this.jnt.findViewById(R.id.view_root);
        this.jnu = this.jnt.findViewById(R.id.statebar_view);
        this.jnv = (TextView) this.jnt.findViewById(R.id.skip);
        this.fns = (NoNetworkView) this.jnt.findViewById(R.id.view_no_network);
        this.jnw = (TextView) this.jnt.findViewById(R.id.sub_label);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.jnu.getLayoutParams().height = UtilHelper.getStatusBarHeight();
        }
        cC(0, 0);
        this.US = (BdListView) this.jnt.findViewById(R.id.listview);
        this.jnx = new com.baidu.tieba.interestlabel.a.a(this.jnt.getPageContext().getPageActivity());
        this.jnx.setOnClickListener(this.jnA);
        this.jny = new a(this.jnt.getPageContext().getPageActivity());
        this.US.addHeaderView(this.jny.cwz());
        this.US.setAdapter((ListAdapter) this.jnx);
        onChangeSkinType();
    }

    private void onChangeSkinType() {
        an.setViewTextColor(this.jnv, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.jnw, (int) R.drawable.color_sub_lable_selector);
        an.setBackgroundResource(this.jnw, R.drawable.bule_bg_commen_label_button);
        this.fns.onChangeSkinType(this.jnt.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
    }

    private void cC(int i, int i2) {
        this.jnw.setEnabled(i > 0);
        this.jnw.setText(this.jnt.getString(R.string.start_tieba, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        this.jnw.setOnClickListener(i > 0 ? this.mOnClickListener : null);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
        this.jnv.setOnClickListener(onClickListener);
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View cwB() {
        return this.jnv;
    }

    public View cwC() {
        return this.jnw;
    }

    public void setData(com.baidu.tieba.interestlabel.b.b bVar) {
        if (bVar != null && bVar.cws() != null && bVar.cwt() != null) {
            for (com.baidu.tieba.interestlabel.b.a aVar : bVar.cwt()) {
                if (aVar != null) {
                    aVar.isFollow = false;
                }
            }
            this.mDataList.clear();
            this.mDataList.addAll(bVar.cwt());
            this.jny.setData(bVar.cws());
            this.jnx.setData(this.mDataList);
            this.US.setVisibility(0);
            cC(0, this.mDataList.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwD() {
        for (com.baidu.tieba.interestlabel.b.a aVar : this.mDataList) {
            if (aVar != null) {
                aVar.isFollow = this.jnz.contains(Integer.valueOf(aVar.labelId));
            }
        }
        this.jnx.setData(this.mDataList);
        cC(this.jnz.size(), this.mDataList.size());
    }

    public List<Integer> cwE() {
        ArrayList arrayList = new ArrayList(this.jnz);
        arrayList.add(0, Integer.valueOf(this.jny.cwA()));
        return arrayList;
    }
}
