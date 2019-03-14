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
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c {
    private PostSearchActivity icn;
    private View icv;
    private BdListView icw;
    private com.baidu.tbadk.core.dialog.a icy;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d icx = null;
    private View eoO = null;
    private boolean icz = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.icn = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.icv = this.icn.findViewById(d.g.history_frame);
        this.icw = (BdListView) this.mRootView.findViewById(d.g.history_list);
        BdListViewHelper.a(this.icn.getActivity(), this.icw, BdListViewHelper.HeadType.DEFAULT);
        this.icx = new com.baidu.tieba.mainentrance.d(this.icn.getPageContext().getPageActivity(), null);
        this.icx.mf(false);
        this.icw.setAdapter((ListAdapter) this.icx);
        this.eoO = LayoutInflater.from(this.icn.getPageContext().getPageActivity()).inflate(d.h.home_dialog_search_footer, (ViewGroup) null);
        this.icw.addFooterView(this.eoO);
        this.eoO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bsP();
            }
        });
        this.icw.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new am("c12403").bJ(ImageViewerConfig.FORUM_ID, c.this.icn.mForumId).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_NAME, c.this.icn.mForumName));
                String str = (String) c.this.icw.getItemAtPosition(i + 1);
                c.this.icn.Bd(str);
                c.this.icn.jf(str);
                PostSearchActivity unused = c.this.icn;
                TiebaStatic.log(new am("c12842").bJ("obj_name", str).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").bJ("obj_type", "2").bJ(ImageViewerConfig.FORUM_ID, c.this.icn.mForumId));
            }
        });
        this.icw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.icn.bVa();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsP() {
        if (this.icy == null) {
            this.icy = new com.baidu.tbadk.core.dialog.a(this.icn.getPageContext().getPageActivity()).ly(this.icn.getPageContext().getString(d.j.alert_clean_history)).a(this.icn.getPageContext().getString(d.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.icn.bVg().bVt();
                    c.this.icw.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.icn.getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.icn.getPageContext());
        }
        this.icy.aaZ();
    }

    private void nS(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.icn.getPageContext().getPageActivity(), this.icv, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.icn.getActivity(), d.e.ds320)), NoDataViewFactory.d.hU(d.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.icn.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.icn.bVa();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.hU(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        nS(d.j.text_no_search_record);
    }

    public void bVl() {
        this.icw.setVisibility(8);
        nS(d.j.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.icz = true;
        this.icn.showLoadingView(this.icv, false, this.icn.getResources().getDimensionPixelSize(d.e.ds386));
    }

    public void hideLoadingView() {
        this.icz = false;
        this.icn.hideLoadingView(this.icv);
    }

    public void ax(ArrayList<String> arrayList) {
        this.icv.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.icw.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.icw.setVisibility(0);
        this.icx.setData(arrayList);
        this.icx.notifyDataSetChanged();
    }

    public void bVm() {
        this.icv.setVisibility(8);
    }

    public boolean bVn() {
        return this.icv.getVisibility() == 0 && !this.icz && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.icn.getPageContext(), this.eoO);
        this.icx.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.icn.getPageContext(), i);
        }
    }
}
