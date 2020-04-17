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
    private View kmH;
    private BdListView kmI;
    private com.baidu.tbadk.core.dialog.a kmK;
    private PostSearchActivity kmy;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d kmJ = null;
    private View aXv = null;
    private boolean kmL = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.kmy = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.kmH = this.kmy.findViewById(R.id.history_frame);
        this.kmI = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.kmy.getActivity(), this.kmI, BdListViewHelper.HeadType.DEFAULT);
        this.kmJ = new com.baidu.tieba.mainentrance.d(this.kmy.getPageContext().getPageActivity(), null);
        this.kmJ.pM(false);
        this.kmI.setAdapter((ListAdapter) this.kmJ);
        this.aXv = LayoutInflater.from(this.kmy.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.kmI.addFooterView(this.aXv);
        this.aXv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cfM();
            }
        });
        this.kmI.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").cI("fid", c.this.kmy.mForumId).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("fname", c.this.kmy.mForumName));
                String str = (String) c.this.kmI.getItemAtPosition(i + 1);
                c.this.kmy.IU(str);
                c.this.kmy.rp(str);
                PostSearchActivity unused = c.this.kmy;
                TiebaStatic.log(new an("c12842").cI("obj_name", str).cI("obj_source", "3").cI("obj_type", "2").cI("fid", c.this.kmy.mForumId));
            }
        });
        this.kmI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.kmy.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfM() {
        if (this.kmK == null) {
            this.kmK = new com.baidu.tbadk.core.dialog.a(this.kmy.getPageContext().getPageActivity()).uf(this.kmy.getPageContext().getString(R.string.alert_clean_history)).a(this.kmy.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.kmy.cLG().cLT();
                    c.this.kmI.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.kmy.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.kmy.getPageContext());
        }
        this.kmK.aMU();
    }

    private void wU(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kmy.getPageContext().getPageActivity(), this.kmH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.kmy.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lr(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.kmy.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.kmy.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cK(null, this.kmy.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        wU(R.string.new_text_no_search_record);
    }

    public void cLL() {
        this.kmI.setVisibility(8);
        wU(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.kmL = true;
        this.kmy.showLoadingView(this.kmH, false, this.kmy.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.kmL = false;
        this.kmy.hideLoadingView(this.kmH);
    }

    public void aQ(ArrayList<String> arrayList) {
        this.kmH.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.kmI.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.kmI.setVisibility(0);
        this.kmJ.setData(arrayList);
        this.kmJ.notifyDataSetChanged();
    }

    public void cLM() {
        this.kmH.setVisibility(8);
    }

    public boolean cLN() {
        return this.kmH.getVisibility() == 0 && !this.kmL && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.q.a.a(this.kmy.getPageContext(), this.aXv);
        this.kmJ.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kmy.getPageContext(), i);
        }
    }
}
