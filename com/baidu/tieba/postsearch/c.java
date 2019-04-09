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
    private PostSearchActivity ica;
    private View ici;
    private BdListView icj;
    private com.baidu.tbadk.core.dialog.a icl;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d ick = null;
    private View eoB = null;
    private boolean icm = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.ica = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.ici = this.ica.findViewById(d.g.history_frame);
        this.icj = (BdListView) this.mRootView.findViewById(d.g.history_list);
        BdListViewHelper.a(this.ica.getActivity(), this.icj, BdListViewHelper.HeadType.DEFAULT);
        this.ick = new com.baidu.tieba.mainentrance.d(this.ica.getPageContext().getPageActivity(), null);
        this.ick.mf(false);
        this.icj.setAdapter((ListAdapter) this.ick);
        this.eoB = LayoutInflater.from(this.ica.getPageContext().getPageActivity()).inflate(d.h.home_dialog_search_footer, (ViewGroup) null);
        this.icj.addFooterView(this.eoB);
        this.eoB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bsM();
            }
        });
        this.icj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new am("c12403").bJ(ImageViewerConfig.FORUM_ID, c.this.ica.mForumId).bJ("uid", TbadkCoreApplication.getCurrentAccount()).bJ(ImageViewerConfig.FORUM_NAME, c.this.ica.mForumName));
                String str = (String) c.this.icj.getItemAtPosition(i + 1);
                c.this.ica.Bc(str);
                c.this.ica.jg(str);
                PostSearchActivity unused = c.this.ica;
                TiebaStatic.log(new am("c12842").bJ("obj_name", str).bJ(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").bJ("obj_type", "2").bJ(ImageViewerConfig.FORUM_ID, c.this.ica.mForumId));
            }
        });
        this.icj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.ica.bUW();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsM() {
        if (this.icl == null) {
            this.icl = new com.baidu.tbadk.core.dialog.a(this.ica.getPageContext().getPageActivity()).lz(this.ica.getPageContext().getString(d.j.alert_clean_history)).a(this.ica.getPageContext().getString(d.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.ica.bVc().bVp();
                    c.this.icj.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.ica.getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.ica.getPageContext());
        }
        this.icl.aaW();
    }

    private void nQ(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.ica.getPageContext().getPageActivity(), this.ici, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.ica.getActivity(), d.e.ds320)), NoDataViewFactory.d.hT(d.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.ica.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.ica.bUW();
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
        this.icj.setVisibility(8);
        nQ(d.j.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.icm = true;
        this.ica.showLoadingView(this.ici, false, this.ica.getResources().getDimensionPixelSize(d.e.ds386));
    }

    public void hideLoadingView() {
        this.icm = false;
        this.ica.hideLoadingView(this.ici);
    }

    public void ax(ArrayList<String> arrayList) {
        this.ici.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.icj.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.icj.setVisibility(0);
        this.ick.setData(arrayList);
        this.ick.notifyDataSetChanged();
    }

    public void bVi() {
        this.ici.setVisibility(8);
    }

    public boolean bVj() {
        return this.ici.getVisibility() == 0 && !this.icm && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.ica.getPageContext(), this.eoB);
        this.ick.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.ica.getPageContext(), i);
        }
    }
}
