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
    private View iEE;
    private BdListView iEF;
    private com.baidu.tbadk.core.dialog.a iEH;
    private PostSearchActivity iEv;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d iEG = null;
    private View ewO = null;
    private boolean iEI = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.iEv = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.iEE = this.iEv.findViewById(R.id.history_frame);
        this.iEF = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.iEv.getActivity(), this.iEF, BdListViewHelper.HeadType.DEFAULT);
        this.iEG = new com.baidu.tieba.mainentrance.d(this.iEv.getPageContext().getPageActivity(), null);
        this.iEG.nm(false);
        this.iEF.setAdapter((ListAdapter) this.iEG);
        this.ewO = LayoutInflater.from(this.iEv.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.iEF.addFooterView(this.ewO);
        this.ewO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bEl();
            }
        });
        this.iEF.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").bT("fid", c.this.iEv.mForumId).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT(ImageViewerConfig.FORUM_NAME, c.this.iEv.mForumName));
                String str = (String) c.this.iEF.getItemAtPosition(i + 1);
                c.this.iEv.DJ(str);
                c.this.iEv.ko(str);
                PostSearchActivity unused = c.this.iEv;
                TiebaStatic.log(new an("c12842").bT("obj_name", str).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").bT("obj_type", "2").bT("fid", c.this.iEv.mForumId));
            }
        });
        this.iEF.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.iEv.cgY();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEl() {
        if (this.iEH == null) {
            this.iEH = new com.baidu.tbadk.core.dialog.a(this.iEv.getPageContext().getPageActivity()).mQ(this.iEv.getPageContext().getString(R.string.alert_clean_history)).a(this.iEv.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.iEv.che().chr();
                    c.this.iEF.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.iEv.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.iEv.getPageContext());
        }
        this.iEH.agO();
    }

    private void pb(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iEv.getPageContext().getPageActivity(), this.iEE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.iEv.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iQ(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.iEv.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.iEv.cgY();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iQ(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        pb(R.string.text_no_search_record);
    }

    public void chj() {
        this.iEF.setVisibility(8);
        pb(R.string.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.iEI = true;
        this.iEv.showLoadingView(this.iEE, false, this.iEv.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.iEI = false;
        this.iEv.hideLoadingView(this.iEE);
    }

    public void aB(ArrayList<String> arrayList) {
        this.iEE.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.iEF.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.iEF.setVisibility(0);
        this.iEG.setData(arrayList);
        this.iEG.notifyDataSetChanged();
    }

    public void chk() {
        this.iEE.setVisibility(8);
    }

    public boolean chl() {
        return this.iEE.getVisibility() == 0 && !this.iEI && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.s.a.a(this.iEv.getPageContext(), this.ewO);
        this.iEG.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.iEv.getPageContext(), i);
        }
    }
}
