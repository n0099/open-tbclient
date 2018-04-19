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
    private PostSearchActivity fSQ;
    private View fTa;
    private BdListView fTb;
    private com.baidu.tbadk.core.dialog.a fTd;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d fTc = null;
    private View mFooterView = null;
    private boolean fTe = false;

    public c(PostSearchActivity postSearchActivity, View view2) {
        this.fSQ = postSearchActivity;
        this.mRootView = view2;
        initView();
    }

    private void initView() {
        this.fTa = this.fSQ.findViewById(d.g.history_frame);
        this.fTb = (BdListView) this.mRootView.findViewById(d.g.history_list);
        BdListViewHelper.a(this.fSQ.getActivity(), this.fTb, BdListViewHelper.HeadType.DEFAULT);
        this.fTc = new com.baidu.tieba.mainentrance.d(this.fSQ.getPageContext().getPageActivity(), null);
        this.fTc.id(false);
        this.fTb.setAdapter((ListAdapter) this.fTc);
        this.mFooterView = LayoutInflater.from(this.fSQ.getPageContext().getPageActivity()).inflate(d.i.home_dialog_search_footer, (ViewGroup) null);
        this.fTb.addFooterView(this.mFooterView);
        this.mFooterView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.aDG();
            }
        });
        this.fTb.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                TiebaStatic.log(new al("c12403").ac(ImageViewerConfig.FORUM_ID, c.this.fSQ.mForumId).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_NAME, c.this.fSQ.mForumName));
                String str = (String) c.this.fTb.getItemAtPosition(i + 1);
                c.this.fSQ.rB(str);
                c.this.fSQ.rC(str);
                PostSearchActivity unused = c.this.fSQ;
                TiebaStatic.log(new al("c12842").ac("obj_name", str).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").ac("obj_type", "2").ac(ImageViewerConfig.FORUM_ID, c.this.fSQ.mForumId));
            }
        });
        this.fTb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.fSQ.bhP();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDG() {
        if (this.fTd == null) {
            this.fTd = new com.baidu.tbadk.core.dialog.a(this.fSQ.getPageContext().getPageActivity()).dc(this.fSQ.getPageContext().getString(d.k.alert_clean_history)).a(this.fSQ.getPageContext().getString(d.k.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.fSQ.bhV().bii();
                    c.this.fTb.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.fSQ.getPageContext().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.fSQ.getPageContext());
        }
        this.fTd.tD();
    }

    private void ij(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fSQ.getPageContext().getPageActivity(), this.fTa, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.fSQ.getActivity(), d.e.ds320)), NoDataViewFactory.d.m16do(d.k.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.fSQ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    c.this.fSQ.bhP();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.m16do(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        ij(d.k.text_no_search_record);
    }

    public void bia() {
        this.fTb.setVisibility(8);
        ij(d.k.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.fTe = true;
        this.fSQ.showLoadingView(this.fTa, false, this.fSQ.getResources().getDimensionPixelSize(d.e.ds386));
    }

    public void Ou() {
        this.fTe = false;
        this.fSQ.hideLoadingView(this.fTa);
    }

    public void as(ArrayList<String> arrayList) {
        this.fTa.setVisibility(0);
        Ou();
        if (arrayList == null || arrayList.size() == 0) {
            this.fTb.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.fTb.setVisibility(0);
        this.fTc.setData(arrayList);
        this.fTc.notifyDataSetChanged();
    }

    public void bib() {
        this.fTa.setVisibility(8);
    }

    public boolean bic() {
        return this.fTa.getVisibility() == 0 && !this.fTe && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.n.a.a(this.fSQ.getPageContext(), this.mFooterView);
        this.fTc.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fSQ.getPageContext(), i);
        }
    }
}
