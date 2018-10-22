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
    private PostSearchActivity gyC;
    private View gyL;
    private BdListView gyM;
    private com.baidu.tbadk.core.dialog.a gyO;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d gyN = null;
    private View cTy = null;
    private boolean gyP = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.gyC = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.gyL = this.gyC.findViewById(e.g.history_frame);
        this.gyM = (BdListView) this.mRootView.findViewById(e.g.history_list);
        BdListViewHelper.a(this.gyC.getActivity(), this.gyM, BdListViewHelper.HeadType.DEFAULT);
        this.gyN = new com.baidu.tieba.mainentrance.d(this.gyC.getPageContext().getPageActivity(), null);
        this.gyN.jo(false);
        this.gyM.setAdapter((ListAdapter) this.gyN);
        this.cTy = LayoutInflater.from(this.gyC.getPageContext().getPageActivity()).inflate(e.h.home_dialog_search_footer, (ViewGroup) null);
        this.gyM.addFooterView(this.cTy);
        this.cTy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aPI();
            }
        });
        this.gyM.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new am("c12403").ax(ImageViewerConfig.FORUM_ID, c.this.gyC.mForumId).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax(ImageViewerConfig.FORUM_NAME, c.this.gyC.mForumName));
                String str = (String) c.this.gyM.getItemAtPosition(i + 1);
                c.this.gyC.tz(str);
                c.this.gyC.tA(str);
                PostSearchActivity unused = c.this.gyC;
                TiebaStatic.log(new am("c12842").ax("obj_name", str).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").ax("obj_type", "2").ax(ImageViewerConfig.FORUM_ID, c.this.gyC.mForumId));
            }
        });
        this.gyM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.gyC.brC();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPI() {
        if (this.gyO == null) {
            this.gyO = new com.baidu.tbadk.core.dialog.a(this.gyC.getPageContext().getPageActivity()).ej(this.gyC.getPageContext().getString(e.j.alert_clean_history)).a(this.gyC.getPageContext().getString(e.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.gyC.brI().brV();
                    c.this.gyM.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.gyC.getPageContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.gyC.getPageContext());
        }
        this.gyO.Au();
    }

    private void jq(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gyC.getPageContext().getPageActivity(), this.gyL, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.gyC.getActivity(), e.C0175e.ds320)), NoDataViewFactory.d.dO(e.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.gyC.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gyC.brC();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dO(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        jq(e.j.text_no_search_record);
    }

    public void brN() {
        this.gyM.setVisibility(8);
        jq(e.j.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.gyP = true;
        this.gyC.showLoadingView(this.gyL, false, this.gyC.getResources().getDimensionPixelSize(e.C0175e.ds386));
    }

    public void hideLoadingView() {
        this.gyP = false;
        this.gyC.hideLoadingView(this.gyL);
    }

    public void au(ArrayList<String> arrayList) {
        this.gyL.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.gyM.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.gyM.setVisibility(0);
        this.gyN.setData(arrayList);
        this.gyN.notifyDataSetChanged();
    }

    public void brO() {
        this.gyL.setVisibility(8);
    }

    public boolean brP() {
        return this.gyL.getVisibility() == 0 && !this.gyP && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.o.a.a(this.gyC.getPageContext(), this.cTy);
        this.gyN.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gyC.getPageContext(), i);
        }
    }
}
