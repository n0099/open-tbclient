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
/* loaded from: classes8.dex */
public class c {
    private PostSearchActivity jwj;
    private View jws;
    private BdListView jwt;
    private com.baidu.tbadk.core.dialog.a jwv;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d jwu = null;
    private View ayx = null;
    private boolean jww = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.jwj = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.jws = this.jwj.findViewById(R.id.history_frame);
        this.jwt = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.jwj.getActivity(), this.jwt, BdListViewHelper.HeadType.DEFAULT);
        this.jwu = new com.baidu.tieba.mainentrance.d(this.jwj.getPageContext().getPageActivity(), null);
        this.jwu.oo(false);
        this.jwt.setAdapter((ListAdapter) this.jwu);
        this.ayx = LayoutInflater.from(this.jwj.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.jwt.addFooterView(this.ayx);
        this.ayx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bSg();
            }
        });
        this.jwt.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").cp("fid", c.this.jwj.mForumId).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("fname", c.this.jwj.mForumName));
                String str = (String) c.this.jwt.getItemAtPosition(i + 1);
                c.this.jwj.GO(str);
                c.this.jwj.pL(str);
                PostSearchActivity unused = c.this.jwj;
                TiebaStatic.log(new an("c12842").cp("obj_name", str).cp("obj_source", "3").cp("obj_type", "2").cp("fid", c.this.jwj.mForumId));
            }
        });
        this.jwt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.jwj.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSg() {
        if (this.jwv == null) {
            this.jwv = new com.baidu.tbadk.core.dialog.a(this.jwj.getPageContext().getPageActivity()).sz(this.jwj.getPageContext().getString(R.string.alert_clean_history)).a(this.jwj.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.jwj.cxU().cyh();
                    c.this.jwt.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.jwj.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.jwj.getPageContext());
        }
        this.jwv.aBW();
    }

    private void wd(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jwj.getPageContext().getPageActivity(), this.jws, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jwj.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.kQ(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.jwj.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.jwj.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cr(null, this.jwj.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        wd(R.string.new_text_no_search_record);
    }

    public void cxZ() {
        this.jwt.setVisibility(8);
        wd(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.jww = true;
        this.jwj.showLoadingView(this.jws, false, this.jwj.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.jww = false;
        this.jwj.hideLoadingView(this.jws);
    }

    public void aP(ArrayList<String> arrayList) {
        this.jws.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.jwt.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.jwt.setVisibility(0);
        this.jwu.setData(arrayList);
        this.jwu.notifyDataSetChanged();
    }

    public void cya() {
        this.jws.setVisibility(8);
    }

    public boolean cyb() {
        return this.jws.getVisibility() == 0 && !this.jww && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.q.a.a(this.jwj.getPageContext(), this.ayx);
        this.jwu.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jwj.getPageContext(), i);
        }
    }
}
