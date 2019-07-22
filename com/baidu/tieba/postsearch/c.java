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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c {
    private PostSearchActivity iAZ;
    private View iBi;
    private BdListView iBj;
    private com.baidu.tbadk.core.dialog.a iBl;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d iBk = null;
    private View euX = null;
    private boolean iBm = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.iAZ = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.iBi = this.iAZ.findViewById(R.id.history_frame);
        this.iBj = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.iAZ.getActivity(), this.iBj, BdListViewHelper.HeadType.DEFAULT);
        this.iBk = new com.baidu.tieba.mainentrance.d(this.iAZ.getPageContext().getPageActivity(), null);
        this.iBk.nj(false);
        this.iBj.setAdapter((ListAdapter) this.iBk);
        this.euX = LayoutInflater.from(this.iAZ.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.iBj.addFooterView(this.euX);
        this.euX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bDj();
            }
        });
        this.iBj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").bT("fid", c.this.iAZ.mForumId).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT(ImageViewerConfig.FORUM_NAME, c.this.iAZ.mForumName));
                String str = (String) c.this.iBj.getItemAtPosition(i + 1);
                c.this.iAZ.Dj(str);
                c.this.iAZ.km(str);
                PostSearchActivity unused = c.this.iAZ;
                TiebaStatic.log(new an("c12842").bT("obj_name", str).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").bT("obj_type", "2").bT("fid", c.this.iAZ.mForumId));
            }
        });
        this.iBj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.iAZ.cfS();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDj() {
        if (this.iBl == null) {
            this.iBl = new com.baidu.tbadk.core.dialog.a(this.iAZ.getPageContext().getPageActivity()).mO(this.iAZ.getPageContext().getString(R.string.alert_clean_history)).a(this.iAZ.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.iAZ.cfY().cgl();
                    c.this.iBj.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.iAZ.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.iAZ.getPageContext());
        }
        this.iBl.agI();
    }

    private void oW(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iAZ.getPageContext().getPageActivity(), this.iBi, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.iAZ.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iN(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.iAZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.iAZ.cfS();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        oW(R.string.text_no_search_record);
    }

    public void cgd() {
        this.iBj.setVisibility(8);
        oW(R.string.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.iBm = true;
        this.iAZ.showLoadingView(this.iBi, false, this.iAZ.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.iBm = false;
        this.iAZ.hideLoadingView(this.iBi);
    }

    public void aB(ArrayList<String> arrayList) {
        this.iBi.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.iBj.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.iBj.setVisibility(0);
        this.iBk.setData(arrayList);
        this.iBk.notifyDataSetChanged();
    }

    public void cge() {
        this.iBi.setVisibility(8);
    }

    public boolean cgf() {
        return this.iBi.getVisibility() == 0 && !this.iBm && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.s.a.a(this.iAZ.getPageContext(), this.euX);
        this.iBk.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.iAZ.getPageContext(), i);
        }
    }
}
