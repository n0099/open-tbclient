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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private PostSearchActivity gAd;
    private View gAm;
    private BdListView gAn;
    private com.baidu.tbadk.core.dialog.a gAp;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d gAo = null;
    private View cUE = null;
    private boolean gAq = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.gAd = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.gAm = this.gAd.findViewById(e.g.history_frame);
        this.gAn = (BdListView) this.mRootView.findViewById(e.g.history_list);
        BdListViewHelper.a(this.gAd.getActivity(), this.gAn, BdListViewHelper.HeadType.DEFAULT);
        this.gAo = new com.baidu.tieba.mainentrance.d(this.gAd.getPageContext().getPageActivity(), null);
        this.gAo.jy(false);
        this.gAn.setAdapter((ListAdapter) this.gAo);
        this.cUE = LayoutInflater.from(this.gAd.getPageContext().getPageActivity()).inflate(e.h.home_dialog_search_footer, (ViewGroup) null);
        this.gAn.addFooterView(this.cUE);
        this.cUE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aPf();
            }
        });
        this.gAn.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new am("c12403").ax(ImageViewerConfig.FORUM_ID, c.this.gAd.mForumId).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax(ImageViewerConfig.FORUM_NAME, c.this.gAd.mForumName));
                String str = (String) c.this.gAn.getItemAtPosition(i + 1);
                c.this.gAd.tE(str);
                c.this.gAd.startSearch(str);
                PostSearchActivity unused = c.this.gAd;
                TiebaStatic.log(new am("c12842").ax("obj_name", str).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").ax("obj_type", "2").ax(ImageViewerConfig.FORUM_ID, c.this.gAd.mForumId));
            }
        });
        this.gAn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.gAd.bqY();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPf() {
        if (this.gAp == null) {
            this.gAp = new com.baidu.tbadk.core.dialog.a(this.gAd.getPageContext().getPageActivity()).ej(this.gAd.getPageContext().getString(e.j.alert_clean_history)).a(this.gAd.getPageContext().getString(e.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.gAd.bre().brr();
                    c.this.gAn.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.gAd.getPageContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.gAd.getPageContext());
        }
        this.gAp.AB();
    }

    private void jJ(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gAd.getPageContext().getPageActivity(), this.gAm, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.gAd.getActivity(), e.C0200e.ds320)), NoDataViewFactory.d.ec(e.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.gAd.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gAd.bqY();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.ec(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        jJ(e.j.text_no_search_record);
    }

    public void brj() {
        this.gAn.setVisibility(8);
        jJ(e.j.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.gAq = true;
        this.gAd.showLoadingView(this.gAm, false, this.gAd.getResources().getDimensionPixelSize(e.C0200e.ds386));
    }

    public void hideLoadingView() {
        this.gAq = false;
        this.gAd.hideLoadingView(this.gAm);
    }

    public void at(ArrayList<String> arrayList) {
        this.gAm.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.gAn.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.gAn.setVisibility(0);
        this.gAo.setData(arrayList);
        this.gAo.notifyDataSetChanged();
    }

    public void brk() {
        this.gAm.setVisibility(8);
    }

    public boolean brl() {
        return this.gAm.getVisibility() == 0 && !this.gAq && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.o.a.a(this.gAd.getPageContext(), this.cUE);
        this.gAo.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gAd.getPageContext(), i);
        }
    }
}
