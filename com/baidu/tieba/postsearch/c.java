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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class c {
    private PostSearchActivity fSN;
    private View fSX;
    private BdListView fSY;
    private com.baidu.tbadk.core.dialog.a fTa;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d fSZ = null;
    private View mFooterView = null;
    private boolean fTb = false;

    public c(PostSearchActivity postSearchActivity, View view2) {
        this.fSN = postSearchActivity;
        this.mRootView = view2;
        initView();
    }

    private void initView() {
        this.fSX = this.fSN.findViewById(d.g.history_frame);
        this.fSY = (BdListView) this.mRootView.findViewById(d.g.history_list);
        BdListViewHelper.a(this.fSN.getActivity(), this.fSY, BdListViewHelper.HeadType.DEFAULT);
        this.fSZ = new com.baidu.tieba.mainentrance.d(this.fSN.getPageContext().getPageActivity(), null);
        this.fSZ.id(false);
        this.fSY.setAdapter((ListAdapter) this.fSZ);
        this.mFooterView = LayoutInflater.from(this.fSN.getPageContext().getPageActivity()).inflate(d.i.home_dialog_search_footer, (ViewGroup) null);
        this.fSY.addFooterView(this.mFooterView);
        this.mFooterView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                c.this.aDG();
            }
        });
        this.fSY.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                TiebaStatic.log(new al("c12403").ac(ImageViewerConfig.FORUM_ID, c.this.fSN.mForumId).ac("uid", TbadkCoreApplication.getCurrentAccount()).ac(ImageViewerConfig.FORUM_NAME, c.this.fSN.mForumName));
                String str = (String) c.this.fSY.getItemAtPosition(i + 1);
                c.this.fSN.rB(str);
                c.this.fSN.rC(str);
                PostSearchActivity unused = c.this.fSN;
                TiebaStatic.log(new al("c12842").ac("obj_name", str).ac(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "3").ac("obj_type", "2").ac(ImageViewerConfig.FORUM_ID, c.this.fSN.mForumId));
            }
        });
        this.fSY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                c.this.fSN.bhP();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDG() {
        if (this.fTa == null) {
            this.fTa = new com.baidu.tbadk.core.dialog.a(this.fSN.getPageContext().getPageActivity()).dc(this.fSN.getPageContext().getString(d.k.alert_clean_history)).a(this.fSN.getPageContext().getString(d.k.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.fSN.bhV().bii();
                    c.this.fSY.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.fSN.getPageContext().getString(d.k.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.fSN.getPageContext());
        }
        this.fTa.tD();
    }

    private void ij(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.fSN.getPageContext().getPageActivity(), this.fSX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.e(this.fSN.getActivity(), d.e.ds320)), NoDataViewFactory.d.m16do(d.k.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.fSN.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    c.this.fSN.bhP();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.m16do(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        ij(d.k.text_no_search_record);
    }

    public void bia() {
        this.fSY.setVisibility(8);
        ij(d.k.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.fTb = true;
        this.fSN.showLoadingView(this.fSX, false, this.fSN.getResources().getDimensionPixelSize(d.e.ds386));
    }

    public void Ou() {
        this.fTb = false;
        this.fSN.hideLoadingView(this.fSX);
    }

    public void as(ArrayList<String> arrayList) {
        this.fSX.setVisibility(0);
        Ou();
        if (arrayList == null || arrayList.size() == 0) {
            this.fSY.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.fSY.setVisibility(0);
        this.fSZ.setData(arrayList);
        this.fSZ.notifyDataSetChanged();
    }

    public void bib() {
        this.fSX.setVisibility(8);
    }

    public boolean bic() {
        return this.fSX.getVisibility() == 0 && !this.fTb && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.n.a.a(this.fSN.getPageContext(), this.mFooterView);
        this.fSZ.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.fSN.getPageContext(), i);
        }
    }
}
