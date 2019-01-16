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
    private PostSearchActivity gKO;
    private View gKX;
    private BdListView gKY;
    private com.baidu.tbadk.core.dialog.a gLa;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d gKZ = null;
    private View deS = null;
    private boolean gLb = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.gKO = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.gKX = this.gKO.findViewById(e.g.history_frame);
        this.gKY = (BdListView) this.mRootView.findViewById(e.g.history_list);
        BdListViewHelper.a(this.gKO.getActivity(), this.gKY, BdListViewHelper.HeadType.DEFAULT);
        this.gKZ = new com.baidu.tieba.mainentrance.d(this.gKO.getPageContext().getPageActivity(), null);
        this.gKZ.jE(false);
        this.gKY.setAdapter((ListAdapter) this.gKZ);
        this.deS = LayoutInflater.from(this.gKO.getPageContext().getPageActivity()).inflate(e.h.home_dialog_search_footer, (ViewGroup) null);
        this.gKY.addFooterView(this.deS);
        this.deS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aSk();
            }
        });
        this.gKY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new am("c12403").aB(ImageViewerConfig.FORUM_ID, c.this.gKO.mForumId).aB("uid", TbadkCoreApplication.getCurrentAccount()).aB(ImageViewerConfig.FORUM_NAME, c.this.gKO.mForumName));
                String str = (String) c.this.gKY.getItemAtPosition(i + 1);
                c.this.gKO.uz(str);
                c.this.gKO.startSearch(str);
                PostSearchActivity unused = c.this.gKO;
                TiebaStatic.log(new am("c12842").aB("obj_name", str).aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").aB("obj_type", "2").aB(ImageViewerConfig.FORUM_ID, c.this.gKO.mForumId));
            }
        });
        this.gKY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.gKO.bul();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSk() {
        if (this.gLa == null) {
            this.gLa = new com.baidu.tbadk.core.dialog.a(this.gKO.getPageContext().getPageActivity()).eK(this.gKO.getPageContext().getString(e.j.alert_clean_history)).a(this.gKO.getPageContext().getString(e.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.gKO.bur().buE();
                    c.this.gKY.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.gKO.getPageContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.gKO.getPageContext());
        }
        this.gLa.BS();
    }

    private void kf(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gKO.getPageContext().getPageActivity(), this.gKX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.gKO.getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.gKO.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gKO.bul();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        kf(e.j.text_no_search_record);
    }

    public void buw() {
        this.gKY.setVisibility(8);
        kf(e.j.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.gLb = true;
        this.gKO.showLoadingView(this.gKX, false, this.gKO.getResources().getDimensionPixelSize(e.C0210e.ds386));
    }

    public void hideLoadingView() {
        this.gLb = false;
        this.gKO.hideLoadingView(this.gKX);
    }

    public void at(ArrayList<String> arrayList) {
        this.gKX.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.gKY.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.gKY.setVisibility(0);
        this.gKZ.setData(arrayList);
        this.gKZ.notifyDataSetChanged();
    }

    public void bux() {
        this.gKX.setVisibility(8);
    }

    public boolean buy() {
        return this.gKX.getVisibility() == 0 && !this.gLb && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.o.a.a(this.gKO.getPageContext(), this.deS);
        this.gKZ.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gKO.getPageContext(), i);
        }
    }
}
