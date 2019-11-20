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
/* loaded from: classes6.dex */
public class c {
    private PostSearchActivity iCa;
    private View iCj;
    private BdListView iCk;
    private com.baidu.tbadk.core.dialog.a iCm;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d iCl = null;
    private View aqJ = null;
    private boolean iCn = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.iCa = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.iCj = this.iCa.findViewById(R.id.history_frame);
        this.iCk = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.iCa.getActivity(), this.iCk, BdListViewHelper.HeadType.DEFAULT);
        this.iCl = new com.baidu.tieba.mainentrance.d(this.iCa.getPageContext().getPageActivity(), null);
        this.iCl.mZ(false);
        this.iCk.setAdapter((ListAdapter) this.iCl);
        this.aqJ = LayoutInflater.from(this.iCa.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.iCk.addFooterView(this.aqJ);
        this.aqJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bAU();
            }
        });
        this.iCk.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").bS("fid", c.this.iCa.mForumId).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("fname", c.this.iCa.mForumName));
                String str = (String) c.this.iCk.getItemAtPosition(i + 1);
                c.this.iCa.Cc(str);
                c.this.iCa.kQ(str);
                PostSearchActivity unused = c.this.iCa;
                TiebaStatic.log(new an("c12842").bS("obj_name", str).bS("obj_source", "3").bS("obj_type", "2").bS("fid", c.this.iCa.mForumId));
            }
        });
        this.iCk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.iCa.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAU() {
        if (this.iCm == null) {
            this.iCm = new com.baidu.tbadk.core.dialog.a(this.iCa.getPageContext().getPageActivity()).nn(this.iCa.getPageContext().getString(R.string.alert_clean_history)).a(this.iCa.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.iCa.ceb().ceo();
                    c.this.iCk.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.iCa.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.iCa.getPageContext());
        }
        this.iCm.akM();
    }

    private void ub(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iCa.getPageContext().getPageActivity(), this.iCj, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.iCa.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iK(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.iCa.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.iCa.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iK(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        ub(R.string.text_no_search_record);
    }

    public void ceg() {
        this.iCk.setVisibility(8);
        ub(R.string.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.iCn = true;
        this.iCa.showLoadingView(this.iCj, false, this.iCa.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.iCn = false;
        this.iCa.hideLoadingView(this.iCj);
    }

    public void aF(ArrayList<String> arrayList) {
        this.iCj.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.iCk.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.iCk.setVisibility(0);
        this.iCl.setData(arrayList);
        this.iCl.notifyDataSetChanged();
    }

    public void ceh() {
        this.iCj.setVisibility(8);
    }

    public boolean cei() {
        return this.iCj.getVisibility() == 0 && !this.iCn && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.s.a.a(this.iCa.getPageContext(), this.aqJ);
        this.iCl.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.iCa.getPageContext(), i);
        }
    }
}
