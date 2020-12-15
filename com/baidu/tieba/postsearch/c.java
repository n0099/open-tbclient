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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class c {
    private PostSearchActivity mCB;
    private View mCJ;
    private BdListView mCK;
    private com.baidu.tbadk.core.dialog.a mCM;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d mCL = null;
    private View bJa = null;
    private boolean mCN = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.mCB = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.mCJ = this.mCB.findViewById(R.id.history_frame);
        this.mCK = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.mCB.getActivity(), this.mCK, BdListViewHelper.HeadType.DEFAULT);
        this.mCL = new com.baidu.tieba.mainentrance.d(this.mCB.getPageContext().getPageActivity(), null);
        this.mCL.tD(false);
        this.mCK.setAdapter((ListAdapter) this.mCL);
        this.bJa = LayoutInflater.from(this.mCB.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.mCK.addFooterView(this.bJa);
        this.bJa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cWN();
            }
        });
        this.mCK.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new ar("c12403").dY("fid", c.this.mCB.mForumId).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fname", c.this.mCB.mForumName));
                String str = (String) c.this.mCK.getItemAtPosition(i + 1);
                c.this.mCB.Rw(str);
                c.this.mCB.yJ(str);
                PostSearchActivity unused = c.this.mCB;
                TiebaStatic.log(new ar("c12842").dY("obj_name", str).dY("obj_source", "3").dY("obj_type", "2").dY("fid", c.this.mCB.mForumId));
            }
        });
        this.mCK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.mCB.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWN() {
        if (this.mCM == null) {
            this.mCM = new com.baidu.tbadk.core.dialog.a(this.mCB.getPageContext().getPageActivity()).Bq(this.mCB.getPageContext().getString(R.string.alert_clean_history)).a(this.mCB.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.mCB.dDs().dDF();
                    c.this.mCK.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.mCB.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.mCB.getPageContext());
        }
        this.mCM.brv();
    }

    private void Ed(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mCB.getPageContext().getPageActivity(), this.mCJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mCB.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.qP(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.mCB.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.mCB.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, this.mCB.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        Ed(R.string.new_text_no_search_record);
    }

    public void dDx() {
        this.mCK.setVisibility(8);
        Ed(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.mCN = true;
        this.mCB.showLoadingView(this.mCJ, false, this.mCB.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.mCN = false;
        this.mCB.hideLoadingView(this.mCJ);
    }

    public void bh(ArrayList<String> arrayList) {
        this.mCJ.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.mCK.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.mCK.setVisibility(0);
        this.mCL.setData(arrayList);
        this.mCL.notifyDataSetChanged();
    }

    public void dDy() {
        this.mCJ.setVisibility(8);
    }

    public boolean dDz() {
        return this.mCJ.getVisibility() == 0 && !this.mCN && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.mCB.getPageContext(), this.bJa);
        this.mCL.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mCB.getPageContext(), i);
        }
    }
}
