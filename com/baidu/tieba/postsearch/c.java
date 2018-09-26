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
    private PostSearchActivity grb;
    private View grk;
    private BdListView grl;
    private com.baidu.tbadk.core.dialog.a grn;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d grm = null;
    private View cLf = null;
    private boolean gro = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.grb = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.grk = this.grb.findViewById(e.g.history_frame);
        this.grl = (BdListView) this.mRootView.findViewById(e.g.history_list);
        BdListViewHelper.a(this.grb.getActivity(), this.grl, BdListViewHelper.HeadType.DEFAULT);
        this.grm = new com.baidu.tieba.mainentrance.d(this.grb.getPageContext().getPageActivity(), null);
        this.grm.iW(false);
        this.grl.setAdapter((ListAdapter) this.grm);
        this.cLf = LayoutInflater.from(this.grb.getPageContext().getPageActivity()).inflate(e.h.home_dialog_search_footer, (ViewGroup) null);
        this.grl.addFooterView(this.cLf);
        this.cLf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aMt();
            }
        });
        this.grl.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new am("c12403").al(ImageViewerConfig.FORUM_ID, c.this.grb.mForumId).al("uid", TbadkCoreApplication.getCurrentAccount()).al(ImageViewerConfig.FORUM_NAME, c.this.grb.mForumName));
                String str = (String) c.this.grl.getItemAtPosition(i + 1);
                c.this.grb.sZ(str);
                c.this.grb.ta(str);
                PostSearchActivity unused = c.this.grb;
                TiebaStatic.log(new am("c12842").al("obj_name", str).al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").al("obj_type", "2").al(ImageViewerConfig.FORUM_ID, c.this.grb.mForumId));
            }
        });
        this.grl.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.grb.bon();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMt() {
        if (this.grn == null) {
            this.grn = new com.baidu.tbadk.core.dialog.a(this.grb.getPageContext().getPageActivity()).dT(this.grb.getPageContext().getString(e.j.alert_clean_history)).a(this.grb.getPageContext().getString(e.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.grb.bot().boG();
                    c.this.grl.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.grb.getPageContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.grb.getPageContext());
        }
        this.grn.yl();
    }

    private void iR(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.grb.getPageContext().getPageActivity(), this.grk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.grb.getActivity(), e.C0141e.ds320)), NoDataViewFactory.d.dE(e.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.grb.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.grb.bon();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        iR(e.j.text_no_search_record);
    }

    public void boy() {
        this.grl.setVisibility(8);
        iR(e.j.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.gro = true;
        this.grb.showLoadingView(this.grk, false, this.grb.getResources().getDimensionPixelSize(e.C0141e.ds386));
    }

    public void hideLoadingView() {
        this.gro = false;
        this.grb.hideLoadingView(this.grk);
    }

    public void au(ArrayList<String> arrayList) {
        this.grk.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.grl.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.grl.setVisibility(0);
        this.grm.setData(arrayList);
        this.grm.notifyDataSetChanged();
    }

    public void boz() {
        this.grk.setVisibility(8);
    }

    public boolean boA() {
        return this.grk.getVisibility() == 0 && !this.gro && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.o.a.a(this.grb.getPageContext(), this.cLf);
        this.grm.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.grb.getPageContext(), i);
        }
    }
}
