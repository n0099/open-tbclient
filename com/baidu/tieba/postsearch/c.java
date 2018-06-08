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
/* loaded from: classes3.dex */
public class c {
    private PostSearchActivity gfi;
    private View gfs;
    private BdListView gft;
    private com.baidu.tbadk.core.dialog.a gfv;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d gfu = null;
    private View mFooterView = null;
    private boolean gfw = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.gfi = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.gfs = this.gfi.findViewById(d.g.history_frame);
        this.gft = (BdListView) this.mRootView.findViewById(d.g.history_list);
        BdListViewHelper.a(this.gfi.getActivity(), this.gft, BdListViewHelper.HeadType.DEFAULT);
        this.gfu = new com.baidu.tieba.mainentrance.d(this.gfi.getPageContext().getPageActivity(), null);
        this.gfu.ik(false);
        this.gft.setAdapter((ListAdapter) this.gfu);
        this.mFooterView = LayoutInflater.from(this.gfi.getPageContext().getPageActivity()).inflate(d.i.home_dialog_search_footer, (ViewGroup) null);
        this.gft.addFooterView(this.mFooterView);
        this.mFooterView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aIz();
            }
        });
        this.gft.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new am("c12403").ah(ImageViewerConfig.FORUM_ID, c.this.gfi.mForumId).ah("uid", TbadkCoreApplication.getCurrentAccount()).ah(ImageViewerConfig.FORUM_NAME, c.this.gfi.mForumName));
                String str = (String) c.this.gft.getItemAtPosition(i + 1);
                c.this.gfi.sw(str);
                c.this.gfi.sx(str);
                PostSearchActivity unused = c.this.gfi;
                TiebaStatic.log(new am("c12842").ah("obj_name", str).ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").ah("obj_type", "2").ah(ImageViewerConfig.FORUM_ID, c.this.gfi.mForumId));
            }
        });
        this.gft.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.gfi.bmN();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIz() {
        if (this.gfv == null) {
            this.gfv = new com.baidu.tbadk.core.dialog.a(this.gfi.getPageContext().getPageActivity()).dB(this.gfi.getPageContext().getString(d.k.alert_clean_history)).a(this.gfi.getPageContext().getString(d.k.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.gfi.bmT().bng();
                    c.this.gft.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.gfi.getPageContext().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.gfi.getPageContext());
        }
        this.gfv.xa();
    }

    private void ij(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gfi.getPageContext().getPageActivity(), this.gfs, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.gfi.getActivity(), d.e.ds320)), NoDataViewFactory.d.dr(d.k.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.gfi.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gfi.bmN();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dr(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        ij(d.k.text_no_search_record);
    }

    public void bmY() {
        this.gft.setVisibility(8);
        ij(d.k.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.gfw = true;
        this.gfi.showLoadingView(this.gfs, false, this.gfi.getResources().getDimensionPixelSize(d.e.ds386));
    }

    public void hideLoadingView() {
        this.gfw = false;
        this.gfi.hideLoadingView(this.gfs);
    }

    public void as(ArrayList<String> arrayList) {
        this.gfs.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.gft.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.gft.setVisibility(0);
        this.gfu.setData(arrayList);
        this.gfu.notifyDataSetChanged();
    }

    public void bmZ() {
        this.gfs.setVisibility(8);
    }

    public boolean bna() {
        return this.gfs.getVisibility() == 0 && !this.gfw && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.n.a.a(this.gfi.getPageContext(), this.mFooterView);
        this.gfu.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gfi.getPageContext(), i);
        }
    }
}
