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
    private PostSearchActivity jAG;
    private View jAP;
    private BdListView jAQ;
    private com.baidu.tbadk.core.dialog.a jAS;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d jAR = null;
    private View aDw = null;
    private boolean jAT = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.jAG = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.jAP = this.jAG.findViewById(R.id.history_frame);
        this.jAQ = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.jAG.getActivity(), this.jAQ, BdListViewHelper.HeadType.DEFAULT);
        this.jAR = new com.baidu.tieba.mainentrance.d(this.jAG.getPageContext().getPageActivity(), null);
        this.jAR.oC(false);
        this.jAQ.setAdapter((ListAdapter) this.jAR);
        this.aDw = LayoutInflater.from(this.jAG.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.jAQ.addFooterView(this.aDw);
        this.aDw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bUQ();
            }
        });
        this.jAQ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").cy("fid", c.this.jAG.mForumId).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fname", c.this.jAG.mForumName));
                String str = (String) c.this.jAQ.getItemAtPosition(i + 1);
                c.this.jAG.Hm(str);
                c.this.jAG.qd(str);
                PostSearchActivity unused = c.this.jAG;
                TiebaStatic.log(new an("c12842").cy("obj_name", str).cy("obj_source", "3").cy("obj_type", "2").cy("fid", c.this.jAG.mForumId));
            }
        });
        this.jAQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.jAG.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUQ() {
        if (this.jAS == null) {
            this.jAS = new com.baidu.tbadk.core.dialog.a(this.jAG.getPageContext().getPageActivity()).sS(this.jAG.getPageContext().getString(R.string.alert_clean_history)).a(this.jAG.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.jAG.cAy().cAL();
                    c.this.jAQ.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.jAG.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.jAG.getPageContext());
        }
        this.jAS.aEA();
    }

    private void wo(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jAG.getPageContext().getPageActivity(), this.jAP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jAG.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lh(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.jAG.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.jAG.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cA(null, this.jAG.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        wo(R.string.new_text_no_search_record);
    }

    public void cAD() {
        this.jAQ.setVisibility(8);
        wo(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.jAT = true;
        this.jAG.showLoadingView(this.jAP, false, this.jAG.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.jAT = false;
        this.jAG.hideLoadingView(this.jAP);
    }

    public void aO(ArrayList<String> arrayList) {
        this.jAP.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.jAQ.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.jAQ.setVisibility(0);
        this.jAR.setData(arrayList);
        this.jAR.notifyDataSetChanged();
    }

    public void cAE() {
        this.jAP.setVisibility(8);
    }

    public boolean cAF() {
        return this.jAP.getVisibility() == 0 && !this.jAT && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.q.a.a(this.jAG.getPageContext(), this.aDw);
        this.jAR.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jAG.getPageContext(), i);
        }
    }
}
