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
    private PostSearchActivity iuH;
    private View iuQ;
    private BdListView iuR;
    private com.baidu.tbadk.core.dialog.a iuT;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d iuS = null;
    private View epZ = null;
    private boolean iuU = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.iuH = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.iuQ = this.iuH.findViewById(R.id.history_frame);
        this.iuR = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.iuH.getActivity(), this.iuR, BdListViewHelper.HeadType.DEFAULT);
        this.iuS = new com.baidu.tieba.mainentrance.d(this.iuH.getPageContext().getPageActivity(), null);
        this.iuS.mU(false);
        this.iuR.setAdapter((ListAdapter) this.iuS);
        this.epZ = LayoutInflater.from(this.iuH.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.iuR.addFooterView(this.epZ);
        this.epZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bAB();
            }
        });
        this.iuR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new am("c12403").bT("fid", c.this.iuH.mForumId).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT(ImageViewerConfig.FORUM_NAME, c.this.iuH.mForumName));
                String str = (String) c.this.iuR.getItemAtPosition(i + 1);
                c.this.iuH.Cu(str);
                c.this.iuH.kf(str);
                PostSearchActivity unused = c.this.iuH;
                TiebaStatic.log(new am("c12842").bT("obj_name", str).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").bT("obj_type", "2").bT("fid", c.this.iuH.mForumId));
            }
        });
        this.iuR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.iuH.cda();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAB() {
        if (this.iuT == null) {
            this.iuT = new com.baidu.tbadk.core.dialog.a(this.iuH.getPageContext().getPageActivity()).mE(this.iuH.getPageContext().getString(R.string.alert_clean_history)).a(this.iuH.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.iuH.cdg().cdt();
                    c.this.iuR.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.iuH.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.iuH.getPageContext());
        }
        this.iuT.afG();
    }

    private void oH(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iuH.getPageContext().getPageActivity(), this.iuQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.iuH.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iH(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.iuH.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.iuH.cda();
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

    public void cdl() {
        this.iuR.setVisibility(8);
        oH(R.string.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.iuU = true;
        this.iuH.showLoadingView(this.iuQ, false, this.iuH.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.iuU = false;
        this.iuH.hideLoadingView(this.iuQ);
    }

    public void aB(ArrayList<String> arrayList) {
        this.iuQ.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.iuR.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.iuR.setVisibility(0);
        this.iuS.setData(arrayList);
        this.iuS.notifyDataSetChanged();
    }

    public void cdm() {
        this.iuQ.setVisibility(8);
    }

    public boolean cdn() {
        return this.iuQ.getVisibility() == 0 && !this.iuU && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.s.a.a(this.iuH.getPageContext(), this.epZ);
        this.iuS.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.iuH.getPageContext(), i);
        }
    }
}
