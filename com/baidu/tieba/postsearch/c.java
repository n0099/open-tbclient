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
    private PostSearchActivity gKP;
    private View gKY;
    private BdListView gKZ;
    private com.baidu.tbadk.core.dialog.a gLb;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d gLa = null;
    private View deT = null;
    private boolean gLc = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.gKP = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.gKY = this.gKP.findViewById(e.g.history_frame);
        this.gKZ = (BdListView) this.mRootView.findViewById(e.g.history_list);
        BdListViewHelper.a(this.gKP.getActivity(), this.gKZ, BdListViewHelper.HeadType.DEFAULT);
        this.gLa = new com.baidu.tieba.mainentrance.d(this.gKP.getPageContext().getPageActivity(), null);
        this.gLa.jE(false);
        this.gKZ.setAdapter((ListAdapter) this.gLa);
        this.deT = LayoutInflater.from(this.gKP.getPageContext().getPageActivity()).inflate(e.h.home_dialog_search_footer, (ViewGroup) null);
        this.gKZ.addFooterView(this.deT);
        this.deT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aSk();
            }
        });
        this.gKZ.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new am("c12403").aB(ImageViewerConfig.FORUM_ID, c.this.gKP.mForumId).aB("uid", TbadkCoreApplication.getCurrentAccount()).aB(ImageViewerConfig.FORUM_NAME, c.this.gKP.mForumName));
                String str = (String) c.this.gKZ.getItemAtPosition(i + 1);
                c.this.gKP.uz(str);
                c.this.gKP.startSearch(str);
                PostSearchActivity unused = c.this.gKP;
                TiebaStatic.log(new am("c12842").aB("obj_name", str).aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").aB("obj_type", "2").aB(ImageViewerConfig.FORUM_ID, c.this.gKP.mForumId));
            }
        });
        this.gKZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.gKP.bul();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSk() {
        if (this.gLb == null) {
            this.gLb = new com.baidu.tbadk.core.dialog.a(this.gKP.getPageContext().getPageActivity()).eK(this.gKP.getPageContext().getString(e.j.alert_clean_history)).a(this.gKP.getPageContext().getString(e.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.gKP.bur().buE();
                    c.this.gKZ.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.gKP.getPageContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.gKP.getPageContext());
        }
        this.gLb.BS();
    }

    private void kf(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gKP.getPageContext().getPageActivity(), this.gKY, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.gKP.getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.gKP.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gKP.bul();
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
        this.gKZ.setVisibility(8);
        kf(e.j.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.gLc = true;
        this.gKP.showLoadingView(this.gKY, false, this.gKP.getResources().getDimensionPixelSize(e.C0210e.ds386));
    }

    public void hideLoadingView() {
        this.gLc = false;
        this.gKP.hideLoadingView(this.gKY);
    }

    public void at(ArrayList<String> arrayList) {
        this.gKY.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.gKZ.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.gKZ.setVisibility(0);
        this.gLa.setData(arrayList);
        this.gLa.notifyDataSetChanged();
    }

    public void bux() {
        this.gKY.setVisibility(8);
    }

    public boolean buy() {
        return this.gKY.getVisibility() == 0 && !this.gLc && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.o.a.a(this.gKP.getPageContext(), this.deT);
        this.gLa.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gKP.getPageContext(), i);
        }
    }
}
