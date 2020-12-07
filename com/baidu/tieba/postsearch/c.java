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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes24.dex */
public class c {
    private View mCH;
    private BdListView mCI;
    private com.baidu.tbadk.core.dialog.a mCK;
    private PostSearchActivity mCz;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d mCJ = null;
    private View bJa = null;
    private boolean mCL = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.mCz = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.mCH = this.mCz.findViewById(R.id.history_frame);
        this.mCI = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.mCz.getActivity(), this.mCI, BdListViewHelper.HeadType.DEFAULT);
        this.mCJ = new com.baidu.tieba.mainentrance.d(this.mCz.getPageContext().getPageActivity(), null);
        this.mCJ.tD(false);
        this.mCI.setAdapter((ListAdapter) this.mCJ);
        this.bJa = LayoutInflater.from(this.mCz.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.mCI.addFooterView(this.bJa);
        this.bJa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cWM();
            }
        });
        this.mCI.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new ar("c12403").dY("fid", c.this.mCz.mForumId).dY("uid", TbadkCoreApplication.getCurrentAccount()).dY("fname", c.this.mCz.mForumName));
                String str = (String) c.this.mCI.getItemAtPosition(i + 1);
                c.this.mCz.Rw(str);
                c.this.mCz.yJ(str);
                PostSearchActivity unused = c.this.mCz;
                TiebaStatic.log(new ar("c12842").dY("obj_name", str).dY("obj_source", "3").dY("obj_type", "2").dY("fid", c.this.mCz.mForumId));
            }
        });
        this.mCI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.mCz.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWM() {
        if (this.mCK == null) {
            this.mCK = new com.baidu.tbadk.core.dialog.a(this.mCz.getPageContext().getPageActivity()).Bq(this.mCz.getPageContext().getString(R.string.alert_clean_history)).a(this.mCz.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.mCz.dDr().dDE();
                    c.this.mCI.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.mCz.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.mCz.getPageContext());
        }
        this.mCK.brv();
    }

    private void Ed(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mCz.getPageContext().getPageActivity(), this.mCH, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mCz.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.qP(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.mCz.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.mCz.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dZ(null, this.mCz.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        Ed(R.string.new_text_no_search_record);
    }

    public void dDw() {
        this.mCI.setVisibility(8);
        Ed(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.mCL = true;
        this.mCz.showLoadingView(this.mCH, false, this.mCz.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.mCL = false;
        this.mCz.hideLoadingView(this.mCH);
    }

    public void bh(ArrayList<String> arrayList) {
        this.mCH.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.mCI.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.mCI.setVisibility(0);
        this.mCJ.setData(arrayList);
        this.mCJ.notifyDataSetChanged();
    }

    public void dDx() {
        this.mCH.setVisibility(8);
    }

    public boolean dDy() {
        return this.mCH.getVisibility() == 0 && !this.mCL && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.mCz.getPageContext(), this.bJa);
        this.mCJ.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mCz.getPageContext(), i);
        }
    }
}
