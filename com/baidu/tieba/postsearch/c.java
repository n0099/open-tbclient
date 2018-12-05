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
    private PostSearchActivity gGT;
    private View gHc;
    private BdListView gHd;
    private com.baidu.tbadk.core.dialog.a gHf;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d gHe = null;
    private View dbn = null;
    private boolean gHg = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.gGT = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.gHc = this.gGT.findViewById(e.g.history_frame);
        this.gHd = (BdListView) this.mRootView.findViewById(e.g.history_list);
        BdListViewHelper.a(this.gGT.getActivity(), this.gHd, BdListViewHelper.HeadType.DEFAULT);
        this.gHe = new com.baidu.tieba.mainentrance.d(this.gGT.getPageContext().getPageActivity(), null);
        this.gHe.jB(false);
        this.gHd.setAdapter((ListAdapter) this.gHe);
        this.dbn = LayoutInflater.from(this.gGT.getPageContext().getPageActivity()).inflate(e.h.home_dialog_search_footer, (ViewGroup) null);
        this.gHd.addFooterView(this.dbn);
        this.dbn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aQX();
            }
        });
        this.gHd.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new am("c12403").aA(ImageViewerConfig.FORUM_ID, c.this.gGT.mForumId).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA(ImageViewerConfig.FORUM_NAME, c.this.gGT.mForumName));
                String str = (String) c.this.gHd.getItemAtPosition(i + 1);
                c.this.gGT.ug(str);
                c.this.gGT.startSearch(str);
                PostSearchActivity unused = c.this.gGT;
                TiebaStatic.log(new am("c12842").aA("obj_name", str).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").aA("obj_type", "2").aA(ImageViewerConfig.FORUM_ID, c.this.gGT.mForumId));
            }
        });
        this.gHd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.gGT.bsR();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQX() {
        if (this.gHf == null) {
            this.gHf = new com.baidu.tbadk.core.dialog.a(this.gGT.getPageContext().getPageActivity()).eB(this.gGT.getPageContext().getString(e.j.alert_clean_history)).a(this.gGT.getPageContext().getString(e.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.gGT.bsX().btk();
                    c.this.gHd.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.gGT.getPageContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.gGT.getPageContext());
        }
        this.gHf.BF();
    }

    private void jX(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gGT.getPageContext().getPageActivity(), this.gHc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.gGT.getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.gGT.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gGT.bsR();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        jX(e.j.text_no_search_record);
    }

    public void btc() {
        this.gHd.setVisibility(8);
        jX(e.j.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.gHg = true;
        this.gGT.showLoadingView(this.gHc, false, this.gGT.getResources().getDimensionPixelSize(e.C0210e.ds386));
    }

    public void hideLoadingView() {
        this.gHg = false;
        this.gGT.hideLoadingView(this.gHc);
    }

    public void at(ArrayList<String> arrayList) {
        this.gHc.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.gHd.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.gHd.setVisibility(0);
        this.gHe.setData(arrayList);
        this.gHe.notifyDataSetChanged();
    }

    public void btd() {
        this.gHc.setVisibility(8);
    }

    public boolean bte() {
        return this.gHc.getVisibility() == 0 && !this.gHg && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.o.a.a(this.gGT.getPageContext(), this.dbn);
        this.gHe.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gGT.getPageContext(), i);
        }
    }
}
