package com.baidu.tieba.postsearch;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class c {
    private PostSearchActivity mHR;
    private View mHZ;
    private BdListView mIa;
    private com.baidu.tbadk.core.dialog.a mIc;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d mIb = null;
    private View bNO = null;
    private boolean mIe = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.mHR = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.mHZ = this.mHR.findViewById(R.id.history_frame);
        this.mIa = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.mHR.getActivity(), this.mIa, BdListViewHelper.HeadType.DEFAULT);
        this.mIb = new com.baidu.tieba.mainentrance.d(this.mHR.getPageContext().getPageActivity(), null);
        this.mIb.tF(false);
        this.mIa.setAdapter((ListAdapter) this.mIb);
        this.bNO = LayoutInflater.from(this.mHR.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.mIa.addFooterView(this.bNO);
        this.bNO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cYk();
            }
        });
        this.mIa.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new aq("c12403").dX("fid", c.this.mHR.mForumId).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("fname", c.this.mHR.mForumName));
                String str = (String) c.this.mIa.getItemAtPosition(i + 1);
                c.this.mHR.Rb(str);
                c.this.mHR.yI(str);
                PostSearchActivity unused = c.this.mHR;
                TiebaStatic.log(new aq("c12842").dX("obj_name", str).dX("obj_source", "3").dX("obj_type", "2").dX("fid", c.this.mHR.mForumId));
            }
        });
        this.mIa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.mHR.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYk() {
        if (this.mIc == null) {
            this.mIc = new com.baidu.tbadk.core.dialog.a(this.mHR.getPageContext().getPageActivity()).Bo(this.mHR.getPageContext().getString(R.string.alert_clean_history)).a(this.mHR.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.mHR.dDi().dDv();
                    c.this.mIa.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.mHR.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.mHR.getPageContext());
        }
        this.mIc.btY();
    }

    private void En(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mHR.getPageContext().getPageActivity(), this.mHZ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mHR.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.ra(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.mHR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.mHR.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, this.mHR.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        En(R.string.new_text_no_search_record);
    }

    public void dDn() {
        this.mIa.setVisibility(8);
        En(R.string.new_text_no_search_result);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.mIe = true;
        this.mHR.showLoadingView(this.mHZ, false, this.mHR.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.mIe = false;
        this.mHR.hideLoadingView(this.mHZ);
    }

    public void bh(ArrayList<String> arrayList) {
        this.mHZ.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.mIa.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.mIa.setVisibility(0);
        this.mIb.setData(arrayList);
        this.mIb.notifyDataSetChanged();
    }

    public void dDo() {
        this.mHZ.setVisibility(8);
    }

    public boolean dDp() {
        return this.mHZ.getVisibility() == 0 && !this.mIe && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.mHR.getPageContext(), this.bNO);
        this.mIb.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mHR.getPageContext(), i);
        }
    }
}
