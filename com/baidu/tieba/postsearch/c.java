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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private PostSearchActivity gjj;
    private View gjs;
    private BdListView gjt;
    private com.baidu.tbadk.core.dialog.a gjv;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d gju = null;
    private View mFooterView = null;
    private boolean gjw = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.gjj = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.gjs = this.gjj.findViewById(d.g.history_frame);
        this.gjt = (BdListView) this.mRootView.findViewById(d.g.history_list);
        BdListViewHelper.a(this.gjj.getActivity(), this.gjt, BdListViewHelper.HeadType.DEFAULT);
        this.gju = new com.baidu.tieba.mainentrance.d(this.gjj.getPageContext().getPageActivity(), null);
        this.gju.iu(false);
        this.gjt.setAdapter((ListAdapter) this.gju);
        this.mFooterView = LayoutInflater.from(this.gjj.getPageContext().getPageActivity()).inflate(d.i.home_dialog_search_footer, (ViewGroup) null);
        this.gjt.addFooterView(this.mFooterView);
        this.mFooterView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aJg();
            }
        });
        this.gjt.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").ah(ImageViewerConfig.FORUM_ID, c.this.gjj.mForumId).ah("uid", TbadkCoreApplication.getCurrentAccount()).ah(ImageViewerConfig.FORUM_NAME, c.this.gjj.mForumName));
                String str = (String) c.this.gjt.getItemAtPosition(i + 1);
                c.this.gjj.sv(str);
                c.this.gjj.sw(str);
                PostSearchActivity unused = c.this.gjj;
                TiebaStatic.log(new an("c12842").ah("obj_name", str).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").ah("obj_type", "2").ah(ImageViewerConfig.FORUM_ID, c.this.gjj.mForumId));
            }
        });
        this.gjt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.gjj.bnr();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJg() {
        if (this.gjv == null) {
            this.gjv = new com.baidu.tbadk.core.dialog.a(this.gjj.getPageContext().getPageActivity()).dE(this.gjj.getPageContext().getString(d.k.alert_clean_history)).a(this.gjj.getPageContext().getString(d.k.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.gjj.bnx().bnK();
                    c.this.gjt.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.gjj.getPageContext().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.gjj.getPageContext());
        }
        this.gjv.xn();
    }

    private void il(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gjj.getPageContext().getPageActivity(), this.gjs, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.gjj.getActivity(), d.e.ds320)), NoDataViewFactory.d.ds(d.k.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.gjj.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gjj.bnr();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.ds(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        il(d.k.text_no_search_record);
    }

    public void bnC() {
        this.gjt.setVisibility(8);
        il(d.k.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.gjw = true;
        this.gjj.showLoadingView(this.gjs, false, this.gjj.getResources().getDimensionPixelSize(d.e.ds386));
    }

    public void hideLoadingView() {
        this.gjw = false;
        this.gjj.hideLoadingView(this.gjs);
    }

    public void aw(ArrayList<String> arrayList) {
        this.gjs.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.gjt.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.gjt.setVisibility(0);
        this.gju.setData(arrayList);
        this.gju.notifyDataSetChanged();
    }

    public void bnD() {
        this.gjs.setVisibility(8);
    }

    public boolean bnE() {
        return this.gjs.getVisibility() == 0 && !this.gjw && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.n.a.a(this.gjj.getPageContext(), this.mFooterView);
        this.gju.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gjj.getPageContext(), i);
        }
    }
}
