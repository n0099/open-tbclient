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
    private PostSearchActivity gJK;
    private View gJT;
    private BdListView gJU;
    private com.baidu.tbadk.core.dialog.a gJW;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d gJV = null;
    private View def = null;
    private boolean gJX = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.gJK = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.gJT = this.gJK.findViewById(e.g.history_frame);
        this.gJU = (BdListView) this.mRootView.findViewById(e.g.history_list);
        BdListViewHelper.a(this.gJK.getActivity(), this.gJU, BdListViewHelper.HeadType.DEFAULT);
        this.gJV = new com.baidu.tieba.mainentrance.d(this.gJK.getPageContext().getPageActivity(), null);
        this.gJV.jE(false);
        this.gJU.setAdapter((ListAdapter) this.gJV);
        this.def = LayoutInflater.from(this.gJK.getPageContext().getPageActivity()).inflate(e.h.home_dialog_search_footer, (ViewGroup) null);
        this.gJU.addFooterView(this.def);
        this.def.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aRK();
            }
        });
        this.gJU.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new am("c12403").aA(ImageViewerConfig.FORUM_ID, c.this.gJK.mForumId).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA(ImageViewerConfig.FORUM_NAME, c.this.gJK.mForumName));
                String str = (String) c.this.gJU.getItemAtPosition(i + 1);
                c.this.gJK.uj(str);
                c.this.gJK.startSearch(str);
                PostSearchActivity unused = c.this.gJK;
                TiebaStatic.log(new am("c12842").aA("obj_name", str).aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").aA("obj_type", "2").aA(ImageViewerConfig.FORUM_ID, c.this.gJK.mForumId));
            }
        });
        this.gJU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.gJK.btC();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRK() {
        if (this.gJW == null) {
            this.gJW = new com.baidu.tbadk.core.dialog.a(this.gJK.getPageContext().getPageActivity()).eB(this.gJK.getPageContext().getString(e.j.alert_clean_history)).a(this.gJK.getPageContext().getString(e.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.gJK.btI().btV();
                    c.this.gJU.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.gJK.getPageContext().getString(e.j.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.gJK.getPageContext());
        }
        this.gJW.BF();
    }

    private void kf(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gJK.getPageContext().getPageActivity(), this.gJT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.h(this.gJK.getActivity(), e.C0210e.ds320)), NoDataViewFactory.d.eq(e.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.gJK.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gJK.btC();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.eq(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        kf(e.j.text_no_search_record);
    }

    public void btN() {
        this.gJU.setVisibility(8);
        kf(e.j.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.gJX = true;
        this.gJK.showLoadingView(this.gJT, false, this.gJK.getResources().getDimensionPixelSize(e.C0210e.ds386));
    }

    public void hideLoadingView() {
        this.gJX = false;
        this.gJK.hideLoadingView(this.gJT);
    }

    public void at(ArrayList<String> arrayList) {
        this.gJT.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.gJU.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.gJU.setVisibility(0);
        this.gJV.setData(arrayList);
        this.gJV.notifyDataSetChanged();
    }

    public void btO() {
        this.gJT.setVisibility(8);
    }

    public boolean btP() {
        return this.gJT.getVisibility() == 0 && !this.gJX && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.o.a.a(this.gJK.getPageContext(), this.def);
        this.gJV.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gJK.getPageContext(), i);
        }
    }
}
