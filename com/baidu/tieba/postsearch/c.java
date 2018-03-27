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
    private PostSearchActivity gye;
    private View gyn;
    private BdListView gyo;
    private com.baidu.tbadk.core.dialog.a gyq;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d gyp = null;
    private View ddr = null;
    private boolean gyr = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.gye = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.gyn = this.gye.findViewById(d.g.history_frame);
        this.gyo = (BdListView) this.mRootView.findViewById(d.g.history_list);
        BdListViewHelper.a(this.gye.getActivity(), this.gyo, BdListViewHelper.HeadType.DEFAULT);
        this.gyp = new com.baidu.tieba.mainentrance.d(this.gye.getPageContext().getPageActivity(), null);
        this.gyp.iG(false);
        this.gyo.setAdapter((ListAdapter) this.gyp);
        this.ddr = LayoutInflater.from(this.gye.getPageContext().getPageActivity()).inflate(d.h.home_dialog_search_footer, (ViewGroup) null);
        this.gyo.addFooterView(this.ddr);
        this.ddr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aIJ();
            }
        });
        this.gyo.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new ak("c12403").ab(ImageViewerConfig.FORUM_ID, c.this.gye.mForumId).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_NAME, c.this.gye.mForumName));
                String str = (String) c.this.gyo.getItemAtPosition(i + 1);
                c.this.gye.rv(str);
                c.this.gye.rw(str);
                PostSearchActivity unused = c.this.gye;
                TiebaStatic.log(new ak("c12842").ab("obj_name", str).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").ab("obj_type", "2").ab(ImageViewerConfig.FORUM_ID, c.this.gye.mForumId));
            }
        });
        this.gyo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.gye.bmJ();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIJ() {
        if (this.gyq == null) {
            this.gyq = new com.baidu.tbadk.core.dialog.a(this.gye.getPageContext().getPageActivity()).dk(this.gye.getPageContext().getString(d.j.alert_clean_history)).a(this.gye.getPageContext().getString(d.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.gye.bmP().bnc();
                    c.this.gyo.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.gye.getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.gye.getPageContext());
        }
        this.gyq.AV();
    }

    private void lc(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gye.getPageContext().getPageActivity(), this.gyn, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(this.gye.getActivity(), d.e.ds320)), NoDataViewFactory.d.gp(d.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.gye.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gye.bmJ();
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
        this.gyo.setVisibility(8);
        lc(d.j.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void VU() {
        this.gyr = true;
        this.gye.showLoadingView(this.gyn, false, this.gye.getResources().getDimensionPixelSize(d.e.ds386));
    }

    public void VV() {
        this.gyr = false;
        this.gye.hideLoadingView(this.gyn);
    }

    public void ar(ArrayList<String> arrayList) {
        this.gyn.setVisibility(0);
        VV();
        if (arrayList == null || arrayList.size() == 0) {
            this.gyo.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.gyo.setVisibility(0);
        this.gyp.setData(arrayList);
        this.gyp.notifyDataSetChanged();
    }

    public void bmV() {
        this.gyn.setVisibility(8);
    }

    public boolean bmW() {
        return this.gyn.getVisibility() == 0 && !this.gyr && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.n.a.a(this.gye.getPageContext(), this.ddr);
        this.gyp.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gye.getPageContext(), i);
        }
    }
}
