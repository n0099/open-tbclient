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
/* loaded from: classes9.dex */
public class c {
    private PostSearchActivity jzL;
    private View jzU;
    private BdListView jzV;
    private com.baidu.tbadk.core.dialog.a jzX;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d jzW = null;
    private View azg = null;
    private boolean jzY = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.jzL = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.jzU = this.jzL.findViewById(R.id.history_frame);
        this.jzV = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.jzL.getActivity(), this.jzV, BdListViewHelper.HeadType.DEFAULT);
        this.jzW = new com.baidu.tieba.mainentrance.d(this.jzL.getPageContext().getPageActivity(), null);
        this.jzW.oA(false);
        this.jzV.setAdapter((ListAdapter) this.jzW);
        this.azg = LayoutInflater.from(this.jzL.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.jzV.addFooterView(this.azg);
        this.azg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bTp();
            }
        });
        this.jzV.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").cp("fid", c.this.jzL.mForumId).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("fname", c.this.jzL.mForumName));
                String str = (String) c.this.jzV.getItemAtPosition(i + 1);
                c.this.jzL.GY(str);
                c.this.jzL.pO(str);
                PostSearchActivity unused = c.this.jzL;
                TiebaStatic.log(new an("c12842").cp("obj_name", str).cp("obj_source", "3").cp("obj_type", "2").cp("fid", c.this.jzL.mForumId));
            }
        });
        this.jzV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.jzL.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTp() {
        if (this.jzX == null) {
            this.jzX = new com.baidu.tbadk.core.dialog.a(this.jzL.getPageContext().getPageActivity()).sC(this.jzL.getPageContext().getString(R.string.alert_clean_history)).a(this.jzL.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.jzL.czb().czo();
                    c.this.jzV.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.jzL.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.jzL.getPageContext());
        }
        this.jzX.aCp();
    }

    private void wi(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jzL.getPageContext().getPageActivity(), this.jzU, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jzL.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.kQ(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.jzL.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.jzL.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cr(null, this.jzL.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        wi(R.string.new_text_no_search_record);
    }

    public void czg() {
        this.jzV.setVisibility(8);
        wi(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.jzY = true;
        this.jzL.showLoadingView(this.jzU, false, this.jzL.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.jzY = false;
        this.jzL.hideLoadingView(this.jzU);
    }

    public void aP(ArrayList<String> arrayList) {
        this.jzU.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.jzV.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.jzV.setVisibility(0);
        this.jzW.setData(arrayList);
        this.jzW.notifyDataSetChanged();
    }

    public void czh() {
        this.jzU.setVisibility(8);
    }

    public boolean czi() {
        return this.jzU.getVisibility() == 0 && !this.jzY && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.q.a.a(this.jzL.getPageContext(), this.azg);
        this.jzW.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jzL.getPageContext(), i);
        }
    }
}
