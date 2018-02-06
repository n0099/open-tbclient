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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private PostSearchActivity gxZ;
    private View gyi;
    private BdListView gyj;
    private com.baidu.tbadk.core.dialog.a gyl;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d gyk = null;
    private View ddB = null;
    private boolean gym = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.gxZ = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.gyi = this.gxZ.findViewById(d.g.history_frame);
        this.gyj = (BdListView) this.mRootView.findViewById(d.g.history_list);
        BdListViewHelper.a(this.gxZ.getActivity(), this.gyj, BdListViewHelper.HeadType.DEFAULT);
        this.gyk = new com.baidu.tieba.mainentrance.d(this.gxZ.getPageContext().getPageActivity(), null);
        this.gyk.iB(false);
        this.gyj.setAdapter((ListAdapter) this.gyk);
        this.ddB = LayoutInflater.from(this.gxZ.getPageContext().getPageActivity()).inflate(d.h.home_dialog_search_footer, (ViewGroup) null);
        this.gyj.addFooterView(this.ddB);
        this.ddB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aIJ();
            }
        });
        this.gyj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new ak("c12403").ab(ImageViewerConfig.FORUM_ID, c.this.gxZ.mForumId).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_NAME, c.this.gxZ.mForumName));
                String str = (String) c.this.gyj.getItemAtPosition(i + 1);
                c.this.gxZ.rv(str);
                c.this.gxZ.rw(str);
                PostSearchActivity unused = c.this.gxZ;
                TiebaStatic.log(new ak("c12842").ab("obj_name", str).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").ab("obj_type", "2").ab(ImageViewerConfig.FORUM_ID, c.this.gxZ.mForumId));
            }
        });
        this.gyj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.gxZ.bmJ();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIJ() {
        if (this.gyl == null) {
            this.gyl = new com.baidu.tbadk.core.dialog.a(this.gxZ.getPageContext().getPageActivity()).dk(this.gxZ.getPageContext().getString(d.j.alert_clean_history)).a(this.gxZ.getPageContext().getString(d.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.gxZ.bmP().bnc();
                    c.this.gyj.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.gxZ.getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.gxZ.getPageContext());
        }
        this.gyl.AU();
    }

    private void lc(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gxZ.getPageContext().getPageActivity(), this.gyi, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(this.gxZ.getActivity(), d.e.ds320)), NoDataViewFactory.d.gp(d.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.gxZ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gxZ.bmJ();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.gp(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        lc(d.j.text_no_search_record);
    }

    public void bmU() {
        this.gyj.setVisibility(8);
        lc(d.j.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void VU() {
        this.gym = true;
        this.gxZ.showLoadingView(this.gyi, false, this.gxZ.getResources().getDimensionPixelSize(d.e.ds386));
    }

    public void VV() {
        this.gym = false;
        this.gxZ.hideLoadingView(this.gyi);
    }

    public void ar(ArrayList<String> arrayList) {
        this.gyi.setVisibility(0);
        VV();
        if (arrayList == null || arrayList.size() == 0) {
            this.gyj.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.gyj.setVisibility(0);
        this.gyk.setData(arrayList);
        this.gyk.notifyDataSetChanged();
    }

    public void bmV() {
        this.gyi.setVisibility(8);
    }

    public boolean bmW() {
        return this.gyi.getVisibility() == 0 && !this.gym && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.n.a.a(this.gxZ.getPageContext(), this.ddB);
        this.gyk.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gxZ.getPageContext(), i);
        }
    }
}
