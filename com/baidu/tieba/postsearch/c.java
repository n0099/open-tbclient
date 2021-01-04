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
    private PostSearchActivity mHS;
    private View mIa;
    private BdListView mIb;
    private com.baidu.tbadk.core.dialog.a mIe;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d mIc = null;
    private View bNO = null;
    private boolean mIf = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.mHS = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.mIa = this.mHS.findViewById(R.id.history_frame);
        this.mIb = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.mHS.getActivity(), this.mIb, BdListViewHelper.HeadType.DEFAULT);
        this.mIc = new com.baidu.tieba.mainentrance.d(this.mHS.getPageContext().getPageActivity(), null);
        this.mIc.tF(false);
        this.mIb.setAdapter((ListAdapter) this.mIc);
        this.bNO = LayoutInflater.from(this.mHS.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.mIb.addFooterView(this.bNO);
        this.bNO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cYj();
            }
        });
        this.mIb.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new aq("c12403").dX("fid", c.this.mHS.mForumId).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("fname", c.this.mHS.mForumName));
                String str = (String) c.this.mIb.getItemAtPosition(i + 1);
                c.this.mHS.Rc(str);
                c.this.mHS.yI(str);
                PostSearchActivity unused = c.this.mHS;
                TiebaStatic.log(new aq("c12842").dX("obj_name", str).dX("obj_source", "3").dX("obj_type", "2").dX("fid", c.this.mHS.mForumId));
            }
        });
        this.mIb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.mHS.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYj() {
        if (this.mIe == null) {
            this.mIe = new com.baidu.tbadk.core.dialog.a(this.mHS.getPageContext().getPageActivity()).Bp(this.mHS.getPageContext().getString(R.string.alert_clean_history)).a(this.mHS.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.mHS.dDh().dDu();
                    c.this.mIb.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.mHS.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.mHS.getPageContext());
        }
        this.mIe.btX();
    }

    private void En(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mHS.getPageContext().getPageActivity(), this.mIa, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mHS.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.ra(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.mHS.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.mHS.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dY(null, this.mHS.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        En(R.string.new_text_no_search_record);
    }

    public void dDm() {
        this.mIb.setVisibility(8);
        En(R.string.new_text_no_search_result);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.mIf = true;
        this.mHS.showLoadingView(this.mIa, false, this.mHS.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.mIf = false;
        this.mHS.hideLoadingView(this.mIa);
    }

    public void bh(ArrayList<String> arrayList) {
        this.mIa.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.mIb.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.mIb.setVisibility(0);
        this.mIc.setData(arrayList);
        this.mIc.notifyDataSetChanged();
    }

    public void dDn() {
        this.mIa.setVisibility(8);
    }

    public boolean dDo() {
        return this.mIa.getVisibility() == 0 && !this.mIf && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.mHS.getPageContext(), this.bNO);
        this.mIc.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mHS.getPageContext(), i);
        }
    }
}
