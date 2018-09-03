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
import com.baidu.tieba.f;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private PostSearchActivity gjJ;
    private View gjS;
    private BdListView gjT;
    private com.baidu.tbadk.core.dialog.a gjV;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d gjU = null;
    private View cFo = null;
    private boolean gjW = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.gjJ = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.gjS = this.gjJ.findViewById(f.g.history_frame);
        this.gjT = (BdListView) this.mRootView.findViewById(f.g.history_list);
        BdListViewHelper.a(this.gjJ.getActivity(), this.gjT, BdListViewHelper.HeadType.DEFAULT);
        this.gjU = new com.baidu.tieba.mainentrance.d(this.gjJ.getPageContext().getPageActivity(), null);
        this.gjU.iy(false);
        this.gjT.setAdapter((ListAdapter) this.gjU);
        this.cFo = LayoutInflater.from(this.gjJ.getPageContext().getPageActivity()).inflate(f.h.home_dialog_search_footer, (ViewGroup) null);
        this.gjT.addFooterView(this.cFo);
        this.cFo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aKe();
            }
        });
        this.gjT.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").ae(ImageViewerConfig.FORUM_ID, c.this.gjJ.mForumId).ae("uid", TbadkCoreApplication.getCurrentAccount()).ae(ImageViewerConfig.FORUM_NAME, c.this.gjJ.mForumName));
                String str = (String) c.this.gjT.getItemAtPosition(i + 1);
                c.this.gjJ.ss(str);
                c.this.gjJ.st(str);
                PostSearchActivity unused = c.this.gjJ;
                TiebaStatic.log(new an("c12842").ae("obj_name", str).ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").ae("obj_type", "2").ae(ImageViewerConfig.FORUM_ID, c.this.gjJ.mForumId));
            }
        });
        this.gjT.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.gjJ.blH();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKe() {
        if (this.gjV == null) {
            this.gjV = new com.baidu.tbadk.core.dialog.a(this.gjJ.getPageContext().getPageActivity()).dB(this.gjJ.getPageContext().getString(f.j.alert_clean_history)).a(this.gjJ.getPageContext().getString(f.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.gjJ.blN().bma();
                    c.this.gjT.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.gjJ.getPageContext().getString(f.j.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.gjJ.getPageContext());
        }
        this.gjV.xe();
    }

    private void is(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gjJ.getPageContext().getPageActivity(), this.gjS, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.f(this.gjJ.getActivity(), f.e.ds320)), NoDataViewFactory.d.dt(f.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.gjJ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gjJ.blH();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dt(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        is(f.j.text_no_search_record);
    }

    public void blS() {
        this.gjT.setVisibility(8);
        is(f.j.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.gjW = true;
        this.gjJ.showLoadingView(this.gjS, false, this.gjJ.getResources().getDimensionPixelSize(f.e.ds386));
    }

    public void hideLoadingView() {
        this.gjW = false;
        this.gjJ.hideLoadingView(this.gjS);
    }

    public void au(ArrayList<String> arrayList) {
        this.gjS.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.gjT.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.gjT.setVisibility(0);
        this.gjU.setData(arrayList);
        this.gjU.notifyDataSetChanged();
    }

    public void blT() {
        this.gjS.setVisibility(8);
    }

    public boolean blU() {
        return this.gjS.getVisibility() == 0 && !this.gjW && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.o.a.a(this.gjJ.getPageContext(), this.cFo);
        this.gjU.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gjJ.getPageContext(), i);
        }
    }
}
