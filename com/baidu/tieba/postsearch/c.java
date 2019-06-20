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
    private PostSearchActivity iuI;
    private View iuR;
    private BdListView iuS;
    private com.baidu.tbadk.core.dialog.a iuU;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d iuT = null;
    private View epZ = null;
    private boolean iuV = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.iuI = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.iuR = this.iuI.findViewById(R.id.history_frame);
        this.iuS = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.iuI.getActivity(), this.iuS, BdListViewHelper.HeadType.DEFAULT);
        this.iuT = new com.baidu.tieba.mainentrance.d(this.iuI.getPageContext().getPageActivity(), null);
        this.iuT.mV(false);
        this.iuS.setAdapter((ListAdapter) this.iuT);
        this.epZ = LayoutInflater.from(this.iuI.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.iuS.addFooterView(this.epZ);
        this.epZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bAC();
            }
        });
        this.iuS.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new am("c12403").bT("fid", c.this.iuI.mForumId).bT("uid", TbadkCoreApplication.getCurrentAccount()).bT(ImageViewerConfig.FORUM_NAME, c.this.iuI.mForumName));
                String str = (String) c.this.iuS.getItemAtPosition(i + 1);
                c.this.iuI.Cw(str);
                c.this.iuI.ke(str);
                PostSearchActivity unused = c.this.iuI;
                TiebaStatic.log(new am("c12842").bT("obj_name", str).bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").bT("obj_type", "2").bT("fid", c.this.iuI.mForumId));
            }
        });
        this.iuS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.iuI.cdb();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAC() {
        if (this.iuU == null) {
            this.iuU = new com.baidu.tbadk.core.dialog.a(this.iuI.getPageContext().getPageActivity()).mD(this.iuI.getPageContext().getString(R.string.alert_clean_history)).a(this.iuI.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.iuI.cdh().cdu();
                    c.this.iuS.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.iuI.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.iuI.getPageContext());
        }
        this.iuU.afG();
    }

    private void oH(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iuI.getPageContext().getPageActivity(), this.iuR, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.g(this.iuI.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iH(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.iuI.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.iuI.cdb();
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

    public void cdm() {
        this.iuS.setVisibility(8);
        oH(R.string.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.iuV = true;
        this.iuI.showLoadingView(this.iuR, false, this.iuI.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.iuV = false;
        this.iuI.hideLoadingView(this.iuR);
    }

    public void aB(ArrayList<String> arrayList) {
        this.iuR.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.iuS.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.iuS.setVisibility(0);
        this.iuT.setData(arrayList);
        this.iuT.notifyDataSetChanged();
    }

    public void cdn() {
        this.iuR.setVisibility(8);
    }

    public boolean cdo() {
        return this.iuR.getVisibility() == 0 && !this.iuV && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.s.a.a(this.iuI.getPageContext(), this.epZ);
        this.iuT.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.iuI.getPageContext(), i);
        }
    }
}
