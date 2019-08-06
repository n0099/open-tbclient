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
    private PostSearchActivity iCd;
    private View iCm;
    private BdListView iCn;
    private com.baidu.tbadk.core.dialog.a iCp;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d iCo = null;
    private View eve = null;
    private boolean iCq = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.iCd = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.iCm = this.iCd.findViewById(R.id.history_frame);
        this.iCn = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.iCd.getActivity(), this.iCn, BdListViewHelper.HeadType.DEFAULT);
        this.iCo = new com.baidu.tieba.mainentrance.d(this.iCd.getPageContext().getPageActivity(), null);
        this.iCo.nj(false);
        this.iCn.setAdapter((ListAdapter) this.iCo);
        this.eve = LayoutInflater.from(this.iCd.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.iCn.addFooterView(this.eve);
        this.eve.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bDx();
            }
        });
        this.iCn.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").bT("fid", c.this.iCd.mForumId).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT(ImageViewerConfig.FORUM_NAME, c.this.iCd.mForumName));
                String str = (String) c.this.iCn.getItemAtPosition(i + 1);
                c.this.iCd.Dk(str);
                c.this.iCd.km(str);
                PostSearchActivity unused = c.this.iCd;
                TiebaStatic.log(new an("c12842").bT("obj_name", str).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").bT("obj_type", "2").bT("fid", c.this.iCd.mForumId));
            }
        });
        this.iCn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.iCd.cgk();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDx() {
        if (this.iCp == null) {
            this.iCp = new com.baidu.tbadk.core.dialog.a(this.iCd.getPageContext().getPageActivity()).mO(this.iCd.getPageContext().getString(R.string.alert_clean_history)).a(this.iCd.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.iCd.cgq().cgD();
                    c.this.iCn.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.iCd.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.iCd.getPageContext());
        }
        this.iCp.agK();
    }

    private void oX(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iCd.getPageContext().getPageActivity(), this.iCm, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.iCd.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iN(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.iCd.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.iCd.cgk();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iN(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        oX(R.string.text_no_search_record);
    }

    public void cgv() {
        this.iCn.setVisibility(8);
        oX(R.string.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.iCq = true;
        this.iCd.showLoadingView(this.iCm, false, this.iCd.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.iCq = false;
        this.iCd.hideLoadingView(this.iCm);
    }

    public void aB(ArrayList<String> arrayList) {
        this.iCm.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.iCn.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.iCn.setVisibility(0);
        this.iCo.setData(arrayList);
        this.iCo.notifyDataSetChanged();
    }

    public void cgw() {
        this.iCm.setVisibility(8);
    }

    public boolean cgx() {
        return this.iCm.getVisibility() == 0 && !this.iCq && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.s.a.a(this.iCd.getPageContext(), this.eve);
        this.iCo.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.iCd.getPageContext(), i);
        }
    }
}
