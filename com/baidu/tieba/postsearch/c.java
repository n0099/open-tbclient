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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class c {
    private PostSearchActivity kmC;
    private View kmL;
    private BdListView kmM;
    private com.baidu.tbadk.core.dialog.a kmO;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d kmN = null;
    private View aXA = null;
    private boolean kmP = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.kmC = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.kmL = this.kmC.findViewById(R.id.history_frame);
        this.kmM = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.kmC.getActivity(), this.kmM, BdListViewHelper.HeadType.DEFAULT);
        this.kmN = new com.baidu.tieba.mainentrance.d(this.kmC.getPageContext().getPageActivity(), null);
        this.kmN.pM(false);
        this.kmM.setAdapter((ListAdapter) this.kmN);
        this.aXA = LayoutInflater.from(this.kmC.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.kmM.addFooterView(this.aXA);
        this.aXA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cfL();
            }
        });
        this.kmM.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").cI("fid", c.this.kmC.mForumId).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("fname", c.this.kmC.mForumName));
                String str = (String) c.this.kmM.getItemAtPosition(i + 1);
                c.this.kmC.IX(str);
                c.this.kmC.rp(str);
                PostSearchActivity unused = c.this.kmC;
                TiebaStatic.log(new an("c12842").cI("obj_name", str).cI("obj_source", "3").cI("obj_type", "2").cI("fid", c.this.kmC.mForumId));
            }
        });
        this.kmM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.kmC.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfL() {
        if (this.kmO == null) {
            this.kmO = new com.baidu.tbadk.core.dialog.a(this.kmC.getPageContext().getPageActivity()).ui(this.kmC.getPageContext().getString(R.string.alert_clean_history)).a(this.kmC.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.kmC.cLE().cLR();
                    c.this.kmM.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.kmC.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.kmC.getPageContext());
        }
        this.kmO.aMS();
    }

    private void wU(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kmC.getPageContext().getPageActivity(), this.kmL, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.kmC.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lr(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.kmC.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.kmC.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(null, this.kmC.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        wU(R.string.new_text_no_search_record);
    }

    public void cLJ() {
        this.kmM.setVisibility(8);
        wU(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.kmP = true;
        this.kmC.showLoadingView(this.kmL, false, this.kmC.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.kmP = false;
        this.kmC.hideLoadingView(this.kmL);
    }

    public void aQ(ArrayList<String> arrayList) {
        this.kmL.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.kmM.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.kmM.setVisibility(0);
        this.kmN.setData(arrayList);
        this.kmN.notifyDataSetChanged();
    }

    public void cLK() {
        this.kmL.setVisibility(8);
    }

    public boolean cLL() {
        return this.kmL.getVisibility() == 0 && !this.kmP && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.q.a.a(this.kmC.getPageContext(), this.aXA);
        this.kmN.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kmC.getPageContext(), i);
        }
    }
}
