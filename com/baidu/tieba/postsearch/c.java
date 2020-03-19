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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class c {
    private View jCC;
    private BdListView jCD;
    private com.baidu.tbadk.core.dialog.a jCF;
    private PostSearchActivity jCt;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d jCE = null;
    private View aDM = null;
    private boolean jCG = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.jCt = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.jCC = this.jCt.findViewById(R.id.history_frame);
        this.jCD = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.jCt.getActivity(), this.jCD, BdListViewHelper.HeadType.DEFAULT);
        this.jCE = new com.baidu.tieba.mainentrance.d(this.jCt.getPageContext().getPageActivity(), null);
        this.jCE.oI(false);
        this.jCD.setAdapter((ListAdapter) this.jCE);
        this.aDM = LayoutInflater.from(this.jCt.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.jCD.addFooterView(this.aDM);
        this.aDM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bVl();
            }
        });
        this.jCD.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").cx("fid", c.this.jCt.mForumId).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("fname", c.this.jCt.mForumName));
                String str = (String) c.this.jCD.getItemAtPosition(i + 1);
                c.this.jCt.Hn(str);
                c.this.jCt.qc(str);
                PostSearchActivity unused = c.this.jCt;
                TiebaStatic.log(new an("c12842").cx("obj_name", str).cx("obj_source", "3").cx("obj_type", "2").cx("fid", c.this.jCt.mForumId));
            }
        });
        this.jCD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.jCt.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVl() {
        if (this.jCF == null) {
            this.jCF = new com.baidu.tbadk.core.dialog.a(this.jCt.getPageContext().getPageActivity()).sS(this.jCt.getPageContext().getString(R.string.alert_clean_history)).a(this.jCt.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.jCt.cAV().cBi();
                    c.this.jCD.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.jCt.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.jCt.getPageContext());
        }
        this.jCF.aEG();
    }

    private void ww(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jCt.getPageContext().getPageActivity(), this.jCC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jCt.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lh(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.jCt.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.jCt.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cz(null, this.jCt.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        ww(R.string.new_text_no_search_record);
    }

    public void cBa() {
        this.jCD.setVisibility(8);
        ww(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.jCG = true;
        this.jCt.showLoadingView(this.jCC, false, this.jCt.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.jCG = false;
        this.jCt.hideLoadingView(this.jCC);
    }

    public void aO(ArrayList<String> arrayList) {
        this.jCC.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.jCD.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.jCD.setVisibility(0);
        this.jCE.setData(arrayList);
        this.jCE.notifyDataSetChanged();
    }

    public void cBb() {
        this.jCC.setVisibility(8);
    }

    public boolean cBc() {
        return this.jCC.getVisibility() == 0 && !this.jCG && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.q.a.a(this.jCt.getPageContext(), this.aDM);
        this.jCE.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jCt.getPageContext(), i);
        }
    }
}
