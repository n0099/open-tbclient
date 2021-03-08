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
/* loaded from: classes7.dex */
public class c {
    private NoDataView mNoDataView;
    private PostSearchActivity mOI;
    private View mOQ;
    private BdListView mOR;
    private com.baidu.tbadk.core.dialog.a mOT;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d mOS = null;
    private View bOm = null;
    private boolean mOU = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.mOI = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.mOQ = this.mOI.findViewById(R.id.history_frame);
        this.mOR = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.mOI.getActivity(), this.mOR, BdListViewHelper.HeadType.DEFAULT);
        this.mOS = new com.baidu.tieba.mainentrance.d(this.mOI.getPageContext().getPageActivity(), null);
        this.mOS.tO(false);
        this.mOR.setAdapter((ListAdapter) this.mOS);
        this.bOm = LayoutInflater.from(this.mOI.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.mOR.addFooterView(this.bOm);
        this.bOm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cWE();
            }
        });
        this.mOR.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new ar("c12403").dR("fid", c.this.mOI.mForumId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fname", c.this.mOI.mForumName));
                String str = (String) c.this.mOR.getItemAtPosition(i + 1);
                c.this.mOI.QS(str);
                c.this.mOI.xX(str);
                PostSearchActivity unused = c.this.mOI;
                TiebaStatic.log(new ar("c12842").dR("obj_name", str).dR("obj_source", "3").dR("obj_type", "2").dR("fid", c.this.mOI.mForumId));
            }
        });
        this.mOR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.mOI.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWE() {
        if (this.mOT == null) {
            this.mOT = new com.baidu.tbadk.core.dialog.a(this.mOI.getPageContext().getPageActivity()).AB(this.mOI.getPageContext().getString(R.string.alert_clean_history)).a(this.mOI.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.mOI.dBP().dCc();
                    c.this.mOR.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.mOI.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.mOI.getPageContext());
        }
        this.mOT.bqz();
    }

    private void Db(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mOI.getPageContext().getPageActivity(), this.mOQ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mOI.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pA(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.mOI.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.mOI.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, this.mOI.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        Db(R.string.new_text_no_search_record);
    }

    public void dBU() {
        this.mOR.setVisibility(8);
        Db(R.string.new_text_no_search_result);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.mOU = true;
        this.mOI.showLoadingView(this.mOQ, false, this.mOI.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.mOU = false;
        this.mOI.hideLoadingView(this.mOQ);
    }

    public void bb(ArrayList<String> arrayList) {
        this.mOQ.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.mOR.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.mOR.setVisibility(0);
        this.mOS.setData(arrayList);
        this.mOS.notifyDataSetChanged();
    }

    public void dBV() {
        this.mOQ.setVisibility(8);
    }

    public boolean dBW() {
        return this.mOQ.getVisibility() == 0 && !this.mOU && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.mOI.getPageContext(), this.bOm);
        this.mOS.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mOI.getPageContext(), i);
        }
    }
}
