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
    private PostSearchActivity gyB;
    private View gyK;
    private BdListView gyL;
    private com.baidu.tbadk.core.dialog.a gyN;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d gyM = null;
    private View cTy = null;
    private boolean gyO = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.gyB = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.gyK = this.gyB.findViewById(e.g.history_frame);
        this.gyL = (BdListView) this.mRootView.findViewById(e.g.history_list);
        BdListViewHelper.a(this.gyB.getActivity(), this.gyL, BdListViewHelper.HeadType.DEFAULT);
        this.gyM = new com.baidu.tieba.mainentrance.d(this.gyB.getPageContext().getPageActivity(), null);
        this.gyM.jo(false);
        this.gyL.setAdapter((ListAdapter) this.gyM);
        this.cTy = LayoutInflater.from(this.gyB.getPageContext().getPageActivity()).inflate(e.h.home_dialog_search_footer, (ViewGroup) null);
        this.gyL.addFooterView(this.cTy);
        this.cTy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aPI();
            }
        });
        this.gyL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new am("c12403").ax(ImageViewerConfig.FORUM_ID, c.this.gyB.mForumId).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax(ImageViewerConfig.FORUM_NAME, c.this.gyB.mForumName));
                String str = (String) c.this.gyL.getItemAtPosition(i + 1);
                c.this.gyB.tz(str);
                c.this.gyB.tA(str);
                PostSearchActivity unused = c.this.gyB;
                TiebaStatic.log(new am("c12842").ax("obj_name", str).ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").ax("obj_type", "2").ax(ImageViewerConfig.FORUM_ID, c.this.gyB.mForumId));
            }
        });
        this.gyL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.gyB.brC();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPI() {
        if (this.gyN == null) {
            this.gyN = new com.baidu.tbadk.core.dialog.a(this.gyB.getPageContext().getPageActivity()).ej(this.gyB.getPageContext().getString(e.j.alert_clean_history)).a(this.gyB.getPageContext().getString(e.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.gyB.brI().brV();
                    c.this.gyL.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.gyB.getPageContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.gyB.getPageContext());
        }
        this.gyN.Au();
    }

    private void jq(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gyB.getPageContext().getPageActivity(), this.gyK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.gyB.getActivity(), e.C0175e.ds320)), NoDataViewFactory.d.dO(e.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.gyB.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gyB.brC();
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
        this.gyL.setVisibility(8);
        jq(e.j.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.gyO = true;
        this.gyB.showLoadingView(this.gyK, false, this.gyB.getResources().getDimensionPixelSize(e.C0175e.ds386));
    }

    public void hideLoadingView() {
        this.gyO = false;
        this.gyB.hideLoadingView(this.gyK);
    }

    public void au(ArrayList<String> arrayList) {
        this.gyK.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.gyL.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.gyL.setVisibility(0);
        this.gyM.setData(arrayList);
        this.gyM.notifyDataSetChanged();
    }

    public void brO() {
        this.gyK.setVisibility(8);
    }

    public boolean brP() {
        return this.gyK.getVisibility() == 0 && !this.gyO && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.o.a.a(this.gyB.getPageContext(), this.cTy);
        this.gyM.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gyB.getPageContext(), i);
        }
    }
}
