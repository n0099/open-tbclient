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
    private PostSearchActivity jAU;
    private View jBd;
    private BdListView jBe;
    private com.baidu.tbadk.core.dialog.a jBg;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d jBf = null;
    private View aDy = null;
    private boolean jBh = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.jAU = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.jBd = this.jAU.findViewById(R.id.history_frame);
        this.jBe = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.jAU.getActivity(), this.jBe, BdListViewHelper.HeadType.DEFAULT);
        this.jBf = new com.baidu.tieba.mainentrance.d(this.jAU.getPageContext().getPageActivity(), null);
        this.jBf.oC(false);
        this.jBe.setAdapter((ListAdapter) this.jBf);
        this.aDy = LayoutInflater.from(this.jAU.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.jBe.addFooterView(this.aDy);
        this.aDy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bUT();
            }
        });
        this.jBe.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").cy("fid", c.this.jAU.mForumId).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("fname", c.this.jAU.mForumName));
                String str = (String) c.this.jBe.getItemAtPosition(i + 1);
                c.this.jAU.Hn(str);
                c.this.jAU.qd(str);
                PostSearchActivity unused = c.this.jAU;
                TiebaStatic.log(new an("c12842").cy("obj_name", str).cy("obj_source", "3").cy("obj_type", "2").cy("fid", c.this.jAU.mForumId));
            }
        });
        this.jBe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.jAU.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUT() {
        if (this.jBg == null) {
            this.jBg = new com.baidu.tbadk.core.dialog.a(this.jAU.getPageContext().getPageActivity()).sS(this.jAU.getPageContext().getString(R.string.alert_clean_history)).a(this.jAU.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.jAU.cAB().cAO();
                    c.this.jBe.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.jAU.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.jAU.getPageContext());
        }
        this.jBg.aEC();
    }

    private void wo(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jAU.getPageContext().getPageActivity(), this.jBd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jAU.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lh(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.jAU.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.jAU.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cA(null, this.jAU.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        wo(R.string.new_text_no_search_record);
    }

    public void cAG() {
        this.jBe.setVisibility(8);
        wo(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.jBh = true;
        this.jAU.showLoadingView(this.jBd, false, this.jAU.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.jBh = false;
        this.jAU.hideLoadingView(this.jBd);
    }

    public void aO(ArrayList<String> arrayList) {
        this.jBd.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.jBe.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.jBe.setVisibility(0);
        this.jBf.setData(arrayList);
        this.jBf.notifyDataSetChanged();
    }

    public void cAH() {
        this.jBd.setVisibility(8);
    }

    public boolean cAI() {
        return this.jBd.getVisibility() == 0 && !this.jBh && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.q.a.a(this.jAU.getPageContext(), this.aDy);
        this.jBf.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jAU.getPageContext(), i);
        }
    }
}
