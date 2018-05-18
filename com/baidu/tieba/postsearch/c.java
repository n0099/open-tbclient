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
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private PostSearchActivity fTT;
    private View fUd;
    private BdListView fUe;
    private com.baidu.tbadk.core.dialog.a fUg;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d fUf = null;
    private View mFooterView = null;
    private boolean fUh = false;

    public c(PostSearchActivity postSearchActivity, View view2) {
        this.fTT = postSearchActivity;
        this.mRootView = view2;
        initView();
    }

    private void initView() {
        this.fUd = this.fTT.findViewById(d.g.history_frame);
        this.fUe = (BdListView) this.mRootView.findViewById(d.g.history_list);
        BdListViewHelper.a(this.fTT.getActivity(), this.fUe, BdListViewHelper.HeadType.DEFAULT);
        this.fUf = new com.baidu.tieba.mainentrance.d(this.fTT.getPageContext().getPageActivity(), null);
        this.fUf.ie(false);
        this.fUe.setAdapter((ListAdapter) this.fUf);
        this.mFooterView = LayoutInflater.from(this.fTT.getPageContext().getPageActivity()).inflate(d.i.home_dialog_search_footer, (ViewGroup) null);
        this.fUe.addFooterView(this.mFooterView);
        this.mFooterView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.aDE();
            }
        });
        this.fUe.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                TiebaStatic.log(new al("c12403").ac(ImageViewerConfig.FORUM_ID, c.this.fTT.mForumId).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_NAME, c.this.fTT.mForumName));
                String str = (String) c.this.fUe.getItemAtPosition(i + 1);
                c.this.fTT.rE(str);
                c.this.fTT.rF(str);
                PostSearchActivity unused = c.this.fTT;
                TiebaStatic.log(new al("c12842").ac("obj_name", str).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").ac("obj_type", "2").ac(ImageViewerConfig.FORUM_ID, c.this.fTT.mForumId));
            }
        });
        this.fUe.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.fTT.bhP();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDE() {
        if (this.fUg == null) {
            this.fUg = new com.baidu.tbadk.core.dialog.a(this.fTT.getPageContext().getPageActivity()).dc(this.fTT.getPageContext().getString(d.k.alert_clean_history)).a(this.fTT.getPageContext().getString(d.k.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.fTT.bhV().bii();
                    c.this.fUe.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.fTT.getPageContext().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.fTT.getPageContext());
        }
        this.fUg.tC();
    }

    private void ii(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fTT.getPageContext().getPageActivity(), this.fUd, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.fTT.getActivity(), d.e.ds320)), NoDataViewFactory.d.dp(d.k.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.fTT.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    c.this.fTT.bhP();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dp(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        ii(d.k.text_no_search_record);
    }

    public void bia() {
        this.fUe.setVisibility(8);
        ii(d.k.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.fUh = true;
        this.fTT.showLoadingView(this.fUd, false, this.fTT.getResources().getDimensionPixelSize(d.e.ds386));
    }

    public void Os() {
        this.fUh = false;
        this.fTT.hideLoadingView(this.fUd);
    }

    public void as(ArrayList<String> arrayList) {
        this.fUd.setVisibility(0);
        Os();
        if (arrayList == null || arrayList.size() == 0) {
            this.fUe.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.fUe.setVisibility(0);
        this.fUf.setData(arrayList);
        this.fUf.notifyDataSetChanged();
    }

    public void bib() {
        this.fUd.setVisibility(8);
    }

    public boolean bic() {
        return this.fUd.getVisibility() == 0 && !this.fUh && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.n.a.a(this.fTT.getPageContext(), this.mFooterView);
        this.fUf.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fTT.getPageContext(), i);
        }
    }
}
