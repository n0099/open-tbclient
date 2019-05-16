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
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c {
    private PostSearchActivity iuE;
    private View iuN;
    private BdListView iuO;
    private com.baidu.tbadk.core.dialog.a iuQ;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d iuP = null;
    private View epY = null;
    private boolean iuR = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.iuE = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.iuN = this.iuE.findViewById(R.id.history_frame);
        this.iuO = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.iuE.getActivity(), this.iuO, BdListViewHelper.HeadType.DEFAULT);
        this.iuP = new com.baidu.tieba.mainentrance.d(this.iuE.getPageContext().getPageActivity(), null);
        this.iuP.mU(false);
        this.iuO.setAdapter((ListAdapter) this.iuP);
        this.epY = LayoutInflater.from(this.iuE.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.iuO.addFooterView(this.epY);
        this.epY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bAy();
            }
        });
        this.iuO.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new am("c12403").bT("fid", c.this.iuE.mForumId).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT(ImageViewerConfig.FORUM_NAME, c.this.iuE.mForumName));
                String str = (String) c.this.iuO.getItemAtPosition(i + 1);
                c.this.iuE.Cu(str);
                c.this.iuE.kf(str);
                PostSearchActivity unused = c.this.iuE;
                TiebaStatic.log(new am("c12842").bT("obj_name", str).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").bT("obj_type", "2").bT("fid", c.this.iuE.mForumId));
            }
        });
        this.iuO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.iuE.ccX();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAy() {
        if (this.iuQ == null) {
            this.iuQ = new com.baidu.tbadk.core.dialog.a(this.iuE.getPageContext().getPageActivity()).mE(this.iuE.getPageContext().getString(R.string.alert_clean_history)).a(this.iuE.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.iuE.cdd().cdq();
                    c.this.iuO.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.iuE.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.iuE.getPageContext());
        }
        this.iuQ.afG();
    }

    private void oH(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iuE.getPageContext().getPageActivity(), this.iuN, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.iuE.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iH(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.iuE.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.iuE.ccX();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iH(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        oH(R.string.text_no_search_record);
    }

    public void cdi() {
        this.iuO.setVisibility(8);
        oH(R.string.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.iuR = true;
        this.iuE.showLoadingView(this.iuN, false, this.iuE.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.iuR = false;
        this.iuE.hideLoadingView(this.iuN);
    }

    public void aB(ArrayList<String> arrayList) {
        this.iuN.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.iuO.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.iuO.setVisibility(0);
        this.iuP.setData(arrayList);
        this.iuP.notifyDataSetChanged();
    }

    public void cdj() {
        this.iuN.setVisibility(8);
    }

    public boolean cdk() {
        return this.iuN.getVisibility() == 0 && !this.iuR && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.s.a.a(this.iuE.getPageContext(), this.epY);
        this.iuP.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.iuE.getPageContext(), i);
        }
    }
}
