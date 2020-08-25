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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class c {
    private PostSearchActivity lxn;
    private View lxv;
    private BdListView lxw;
    private com.baidu.tbadk.core.dialog.a lxy;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d lxx = null;
    private View bqe = null;
    private boolean lxz = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.lxn = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.lxv = this.lxn.findViewById(R.id.history_frame);
        this.lxw = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.lxn.getActivity(), this.lxw, BdListViewHelper.HeadType.DEFAULT);
        this.lxx = new com.baidu.tieba.mainentrance.d(this.lxn.getPageContext().getPageActivity(), null);
        this.lxx.rG(false);
        this.lxw.setAdapter((ListAdapter) this.lxx);
        this.bqe = LayoutInflater.from(this.lxn.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.lxw.addFooterView(this.bqe);
        this.bqe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cEW();
            }
        });
        this.lxw.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new aq("c12403").dD("fid", c.this.lxn.mForumId).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fname", c.this.lxn.mForumName));
                String str = (String) c.this.lxw.getItemAtPosition(i + 1);
                c.this.lxn.OM(str);
                c.this.lxn.wu(str);
                PostSearchActivity unused = c.this.lxn;
                TiebaStatic.log(new aq("c12842").dD("obj_name", str).dD("obj_source", "3").dD("obj_type", "2").dD("fid", c.this.lxn.mForumId));
            }
        });
        this.lxw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.lxn.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEW() {
        if (this.lxy == null) {
            this.lxy = new com.baidu.tbadk.core.dialog.a(this.lxn.getPageContext().getPageActivity()).zz(this.lxn.getPageContext().getString(R.string.alert_clean_history)).a(this.lxn.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.lxn.dlw().dlJ();
                    c.this.lxw.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.lxn.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.lxn.getPageContext());
        }
        this.lxy.bhg();
    }

    private void Bd(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.lxn.getPageContext().getPageActivity(), this.lxv, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.lxn.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.oK(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.lxn.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.lxn.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(null, this.lxn.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        Bd(R.string.new_text_no_search_record);
    }

    public void dlB() {
        this.lxw.setVisibility(8);
        Bd(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.lxz = true;
        this.lxn.showLoadingView(this.lxv, false, this.lxn.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.lxz = false;
        this.lxn.hideLoadingView(this.lxv);
    }

    public void aZ(ArrayList<String> arrayList) {
        this.lxv.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.lxw.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.lxw.setVisibility(0);
        this.lxx.setData(arrayList);
        this.lxx.notifyDataSetChanged();
    }

    public void dlC() {
        this.lxv.setVisibility(8);
    }

    public boolean dlD() {
        return this.lxv.getVisibility() == 0 && !this.lxz && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.lxn.getPageContext(), this.bqe);
        this.lxx.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.lxn.getPageContext(), i);
        }
    }
}
