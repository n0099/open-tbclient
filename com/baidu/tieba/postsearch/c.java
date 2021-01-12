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
/* loaded from: classes7.dex */
public class c {
    private PostSearchActivity mDk;
    private View mDs;
    private BdListView mDt;
    private com.baidu.tbadk.core.dialog.a mDv;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d mDu = null;
    private View bJc = null;
    private boolean mDw = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.mDk = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.mDs = this.mDk.findViewById(R.id.history_frame);
        this.mDt = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.mDk.getActivity(), this.mDt, BdListViewHelper.HeadType.DEFAULT);
        this.mDu = new com.baidu.tieba.mainentrance.d(this.mDk.getPageContext().getPageActivity(), null);
        this.mDu.tB(false);
        this.mDt.setAdapter((ListAdapter) this.mDu);
        this.bJc = LayoutInflater.from(this.mDk.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.mDt.addFooterView(this.bJc);
        this.bJc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cUs();
            }
        });
        this.mDt.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new aq("c12403").dW("fid", c.this.mDk.mForumId).dW("uid", TbadkCoreApplication.getCurrentAccount()).dW("fname", c.this.mDk.mForumName));
                String str = (String) c.this.mDt.getItemAtPosition(i + 1);
                c.this.mDk.PT(str);
                c.this.mDk.xx(str);
                PostSearchActivity unused = c.this.mDk;
                TiebaStatic.log(new aq("c12842").dW("obj_name", str).dW("obj_source", "3").dW("obj_type", "2").dW("fid", c.this.mDk.mForumId));
            }
        });
        this.mDt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.mDk.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUs() {
        if (this.mDv == null) {
            this.mDv = new com.baidu.tbadk.core.dialog.a(this.mDk.getPageContext().getPageActivity()).Ad(this.mDk.getPageContext().getString(R.string.alert_clean_history)).a(this.mDk.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.mDk.dzq().dzD();
                    c.this.mDt.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.mDk.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.mDk.getPageContext());
        }
        this.mDv.bqe();
    }

    private void CH(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mDk.getPageContext().getPageActivity(), this.mDs, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mDk.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pu(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.mDk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.mDk.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dX(null, this.mDk.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        CH(R.string.new_text_no_search_record);
    }

    public void dzv() {
        this.mDt.setVisibility(8);
        CH(R.string.new_text_no_search_result);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.mDw = true;
        this.mDk.showLoadingView(this.mDs, false, this.mDk.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.mDw = false;
        this.mDk.hideLoadingView(this.mDs);
    }

    public void bc(ArrayList<String> arrayList) {
        this.mDs.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.mDt.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.mDt.setVisibility(0);
        this.mDu.setData(arrayList);
        this.mDu.notifyDataSetChanged();
    }

    public void dzw() {
        this.mDs.setVisibility(8);
    }

    public boolean dzx() {
        return this.mDs.getVisibility() == 0 && !this.mDw && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.mDk.getPageContext(), this.bJc);
        this.mDu.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mDk.getPageContext(), i);
        }
    }
}
