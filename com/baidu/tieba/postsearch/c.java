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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private PostSearchActivity gjK;
    private View gjT;
    private BdListView gjU;
    private com.baidu.tbadk.core.dialog.a gjW;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d gjV = null;
    private View cFr = null;
    private boolean gjX = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.gjK = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.gjT = this.gjK.findViewById(d.g.history_frame);
        this.gjU = (BdListView) this.mRootView.findViewById(d.g.history_list);
        BdListViewHelper.a(this.gjK.getActivity(), this.gjU, BdListViewHelper.HeadType.DEFAULT);
        this.gjV = new com.baidu.tieba.mainentrance.d(this.gjK.getPageContext().getPageActivity(), null);
        this.gjV.iy(false);
        this.gjU.setAdapter((ListAdapter) this.gjV);
        this.cFr = LayoutInflater.from(this.gjK.getPageContext().getPageActivity()).inflate(d.h.home_dialog_search_footer, (ViewGroup) null);
        this.gjU.addFooterView(this.cFr);
        this.cFr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aKh();
            }
        });
        this.gjU.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").af(ImageViewerConfig.FORUM_ID, c.this.gjK.mForumId).af("uid", TbadkCoreApplication.getCurrentAccount()).af(ImageViewerConfig.FORUM_NAME, c.this.gjK.mForumName));
                String str = (String) c.this.gjU.getItemAtPosition(i + 1);
                c.this.gjK.so(str);
                c.this.gjK.sp(str);
                PostSearchActivity unused = c.this.gjK;
                TiebaStatic.log(new an("c12842").af("obj_name", str).af(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").af("obj_type", "2").af(ImageViewerConfig.FORUM_ID, c.this.gjK.mForumId));
            }
        });
        this.gjU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.gjK.blK();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKh() {
        if (this.gjW == null) {
            this.gjW = new com.baidu.tbadk.core.dialog.a(this.gjK.getPageContext().getPageActivity()).dB(this.gjK.getPageContext().getString(d.j.alert_clean_history)).a(this.gjK.getPageContext().getString(d.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.gjK.blQ().bmd();
                    c.this.gjU.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.gjK.getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.gjK.getPageContext());
        }
        this.gjW.xf();
    }

    private void it(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gjK.getPageContext().getPageActivity(), this.gjT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(this.gjK.getActivity(), d.e.ds320)), NoDataViewFactory.d.du(d.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.gjK.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gjK.blK();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.du(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        it(d.j.text_no_search_record);
    }

    public void blV() {
        this.gjU.setVisibility(8);
        it(d.j.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.gjX = true;
        this.gjK.showLoadingView(this.gjT, false, this.gjK.getResources().getDimensionPixelSize(d.e.ds386));
    }

    public void hideLoadingView() {
        this.gjX = false;
        this.gjK.hideLoadingView(this.gjT);
    }

    public void au(ArrayList<String> arrayList) {
        this.gjT.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.gjU.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.gjU.setVisibility(0);
        this.gjV.setData(arrayList);
        this.gjV.notifyDataSetChanged();
    }

    public void blW() {
        this.gjT.setVisibility(8);
    }

    public boolean blX() {
        return this.gjT.getVisibility() == 0 && !this.gjX && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.o.a.a(this.gjK.getPageContext(), this.cFr);
        this.gjV.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gjK.getPageContext(), i);
        }
    }
}
