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
    private PostSearchActivity gxO;
    private View gxX;
    private BdListView gxY;
    private com.baidu.tbadk.core.dialog.a gya;
    private com.baidu.tbadk.core.view.h mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d gxZ = null;
    private View ddo = null;
    private boolean gyb = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.gxO = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.gxX = this.gxO.findViewById(d.g.history_frame);
        this.gxY = (BdListView) this.mRootView.findViewById(d.g.history_list);
        BdListViewHelper.a(this.gxO.getActivity(), this.gxY, BdListViewHelper.HeadType.DEFAULT);
        this.gxZ = new com.baidu.tieba.mainentrance.d(this.gxO.getPageContext().getPageActivity(), null);
        this.gxZ.iB(false);
        this.gxY.setAdapter((ListAdapter) this.gxZ);
        this.ddo = LayoutInflater.from(this.gxO.getPageContext().getPageActivity()).inflate(d.h.home_dialog_search_footer, (ViewGroup) null);
        this.gxY.addFooterView(this.ddo);
        this.ddo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.aII();
            }
        });
        this.gxY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new ak("c12403").ab(ImageViewerConfig.FORUM_ID, c.this.gxO.mForumId).ab("uid", TbadkCoreApplication.getCurrentAccount()).ab(ImageViewerConfig.FORUM_NAME, c.this.gxO.mForumName));
                String str = (String) c.this.gxY.getItemAtPosition(i + 1);
                c.this.gxO.rv(str);
                c.this.gxO.rw(str);
                PostSearchActivity unused = c.this.gxO;
                TiebaStatic.log(new ak("c12842").ab("obj_name", str).ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").ab("obj_type", "2").ab(ImageViewerConfig.FORUM_ID, c.this.gxO.mForumId));
            }
        });
        this.gxY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.gxO.bmI();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aII() {
        if (this.gya == null) {
            this.gya = new com.baidu.tbadk.core.dialog.a(this.gxO.getPageContext().getPageActivity()).dk(this.gxO.getPageContext().getString(d.j.alert_clean_history)).a(this.gxO.getPageContext().getString(d.j.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.gxO.bmO().bnb();
                    c.this.gxY.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.gxO.getPageContext().getString(d.j.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.gxO.getPageContext());
        }
        this.gya.AU();
    }

    private void lc(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.gxO.getPageContext().getPageActivity(), this.gxX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.t(this.gxO.getActivity(), d.e.ds320)), NoDataViewFactory.d.gp(d.j.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.gxO.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.gxO.bmI();
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

    public void bmT() {
        this.gxY.setVisibility(8);
        lc(d.j.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void VT() {
        this.gyb = true;
        this.gxO.showLoadingView(this.gxX, false, this.gxO.getResources().getDimensionPixelSize(d.e.ds386));
    }

    public void VU() {
        this.gyb = false;
        this.gxO.hideLoadingView(this.gxX);
    }

    public void ar(ArrayList<String> arrayList) {
        this.gxX.setVisibility(0);
        VU();
        if (arrayList == null || arrayList.size() == 0) {
            this.gxY.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.gxY.setVisibility(0);
        this.gxZ.setData(arrayList);
        this.gxZ.notifyDataSetChanged();
    }

    public void bmU() {
        this.gxX.setVisibility(8);
    }

    public boolean bmV() {
        return this.gxX.getVisibility() == 0 && !this.gyb && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.n.a.a(this.gxO.getPageContext(), this.ddo);
        this.gxZ.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.gxO.getPageContext(), i);
        }
    }
}
