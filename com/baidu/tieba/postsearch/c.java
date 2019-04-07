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
    private PostSearchActivity ibZ;
    private View ich;
    private BdListView ici;
    private com.baidu.tbadk.core.dialog.a ick;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d icj = null;
    private View eoA = null;
    private boolean icl = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.ibZ = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.ich = this.ibZ.findViewById(d.g.history_frame);
        this.ici = (BdListView) this.mRootView.findViewById(d.g.history_list);
        BdListViewHelper.a(this.ibZ.getActivity(), this.ici, BdListViewHelper.HeadType.DEFAULT);
        this.icj = new com.baidu.tieba.mainentrance.d(this.ibZ.getPageContext().getPageActivity(), null);
        this.icj.mf(false);
        this.ici.setAdapter((ListAdapter) this.icj);
        this.eoA = LayoutInflater.from(this.ibZ.getPageContext().getPageActivity()).inflate(d.h.home_dialog_search_footer, (ViewGroup) null);
        this.ici.addFooterView(this.eoA);
        this.eoA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bsM();
            }
        });
        this.ici.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new am("c12403").bJ(ImageViewerConfig.FORUM_ID, c.this.ibZ.mForumId).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_NAME, c.this.ibZ.mForumName));
                String str = (String) c.this.ici.getItemAtPosition(i + 1);
                c.this.ibZ.Bc(str);
                c.this.ibZ.jg(str);
                PostSearchActivity unused = c.this.ibZ;
                TiebaStatic.log(new am("c12842").bJ("obj_name", str).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").bJ("obj_type", "2").bJ(ImageViewerConfig.FORUM_ID, c.this.ibZ.mForumId));
            }
        });
        this.ici.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.ibZ.bUW();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsM() {
        if (this.ick == null) {
            this.ick = new com.baidu.tbadk.core.dialog.a(this.ibZ.getPageContext().getPageActivity()).lz(this.ibZ.getPageContext().getString(d.j.alert_clean_history)).a(this.ibZ.getPageContext().getString(d.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.ibZ.bVc().bVp();
                    c.this.ici.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.ibZ.getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.ibZ.getPageContext());
        }
        this.ick.aaW();
    }

    private void nQ(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ibZ.getPageContext().getPageActivity(), this.ich, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.ibZ.getActivity(), d.e.ds320)), NoDataViewFactory.d.hT(d.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.ibZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.ibZ.bUW();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.hT(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        nQ(d.j.text_no_search_record);
    }

    public void bVh() {
        this.ici.setVisibility(8);
        nQ(d.j.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.icl = true;
        this.ibZ.showLoadingView(this.ich, false, this.ibZ.getResources().getDimensionPixelSize(d.e.ds386));
    }

    public void hideLoadingView() {
        this.icl = false;
        this.ibZ.hideLoadingView(this.ich);
    }

    public void ax(ArrayList<String> arrayList) {
        this.ich.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.ici.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.ici.setVisibility(0);
        this.icj.setData(arrayList);
        this.icj.notifyDataSetChanged();
    }

    public void bVi() {
        this.ich.setVisibility(8);
    }

    public boolean bVj() {
        return this.ich.getVisibility() == 0 && !this.icl && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.ibZ.getPageContext(), this.eoA);
        this.icj.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ibZ.getPageContext(), i);
        }
    }
}
