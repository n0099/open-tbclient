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
    private PostSearchActivity jAI;
    private View jAR;
    private BdListView jAS;
    private com.baidu.tbadk.core.dialog.a jAU;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d jAT = null;
    private View aDx = null;
    private boolean jAV = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.jAI = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.jAR = this.jAI.findViewById(R.id.history_frame);
        this.jAS = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.jAI.getActivity(), this.jAS, BdListViewHelper.HeadType.DEFAULT);
        this.jAT = new com.baidu.tieba.mainentrance.d(this.jAI.getPageContext().getPageActivity(), null);
        this.jAT.oC(false);
        this.jAS.setAdapter((ListAdapter) this.jAT);
        this.aDx = LayoutInflater.from(this.jAI.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.jAS.addFooterView(this.aDx);
        this.aDx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bUS();
            }
        });
        this.jAS.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").cy("fid", c.this.jAI.mForumId).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fname", c.this.jAI.mForumName));
                String str = (String) c.this.jAS.getItemAtPosition(i + 1);
                c.this.jAI.Hm(str);
                c.this.jAI.qd(str);
                PostSearchActivity unused = c.this.jAI;
                TiebaStatic.log(new an("c12842").cy("obj_name", str).cy("obj_source", "3").cy("obj_type", "2").cy("fid", c.this.jAI.mForumId));
            }
        });
        this.jAS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.jAI.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUS() {
        if (this.jAU == null) {
            this.jAU = new com.baidu.tbadk.core.dialog.a(this.jAI.getPageContext().getPageActivity()).sS(this.jAI.getPageContext().getString(R.string.alert_clean_history)).a(this.jAI.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.jAI.cAA().cAN();
                    c.this.jAS.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.jAI.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.jAI.getPageContext());
        }
        this.jAU.aEC();
    }

    private void wo(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jAI.getPageContext().getPageActivity(), this.jAR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jAI.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lh(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.jAI.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.jAI.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cA(null, this.jAI.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        wo(R.string.new_text_no_search_record);
    }

    public void cAF() {
        this.jAS.setVisibility(8);
        wo(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.jAV = true;
        this.jAI.showLoadingView(this.jAR, false, this.jAI.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.jAV = false;
        this.jAI.hideLoadingView(this.jAR);
    }

    public void aO(ArrayList<String> arrayList) {
        this.jAR.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.jAS.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.jAS.setVisibility(0);
        this.jAT.setData(arrayList);
        this.jAT.notifyDataSetChanged();
    }

    public void cAG() {
        this.jAR.setVisibility(8);
    }

    public boolean cAH() {
        return this.jAR.getVisibility() == 0 && !this.jAV && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.q.a.a(this.jAI.getPageContext(), this.aDx);
        this.jAT.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jAI.getPageContext(), i);
        }
    }
}
