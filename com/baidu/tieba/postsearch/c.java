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
    private PostSearchActivity iCR;
    private View iDa;
    private BdListView iDb;
    private com.baidu.tbadk.core.dialog.a iDd;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d iDc = null;
    private View arb = null;
    private boolean iDe = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.iCR = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.iDa = this.iCR.findViewById(R.id.history_frame);
        this.iDb = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.iCR.getActivity(), this.iDb, BdListViewHelper.HeadType.DEFAULT);
        this.iDc = new com.baidu.tieba.mainentrance.d(this.iCR.getPageContext().getPageActivity(), null);
        this.iDc.mZ(false);
        this.iDb.setAdapter((ListAdapter) this.iDc);
        this.arb = LayoutInflater.from(this.iCR.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.iDb.addFooterView(this.arb);
        this.arb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bAW();
            }
        });
        this.iDb.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").bS("fid", c.this.iCR.mForumId).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("fname", c.this.iCR.mForumName));
                String str = (String) c.this.iDb.getItemAtPosition(i + 1);
                c.this.iCR.Cc(str);
                c.this.iCR.kQ(str);
                PostSearchActivity unused = c.this.iCR;
                TiebaStatic.log(new an("c12842").bS("obj_name", str).bS("obj_source", "3").bS("obj_type", "2").bS("fid", c.this.iCR.mForumId));
            }
        });
        this.iDb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.iCR.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAW() {
        if (this.iDd == null) {
            this.iDd = new com.baidu.tbadk.core.dialog.a(this.iCR.getPageContext().getPageActivity()).nn(this.iCR.getPageContext().getString(R.string.alert_clean_history)).a(this.iCR.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.iCR.ced().ceq();
                    c.this.iDb.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.iCR.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.iCR.getPageContext());
        }
        this.iDd.akO();
    }

    private void uc(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.iCR.getPageContext().getPageActivity(), this.iDa, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.iCR.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.iL(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.iCR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.iCR.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.iL(i));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        uc(R.string.text_no_search_record);
    }

    public void cei() {
        this.iDb.setVisibility(8);
        uc(R.string.text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.iDe = true;
        this.iCR.showLoadingView(this.iDa, false, this.iCR.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.iDe = false;
        this.iCR.hideLoadingView(this.iDa);
    }

    public void aF(ArrayList<String> arrayList) {
        this.iDa.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.iDb.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.iDb.setVisibility(0);
        this.iDc.setData(arrayList);
        this.iDc.notifyDataSetChanged();
    }

    public void cej() {
        this.iDa.setVisibility(8);
    }

    public boolean cek() {
        return this.iDa.getVisibility() == 0 && !this.iDe && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.s.a.a(this.iCR.getPageContext(), this.arb);
        this.iDc.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.iCR.getPageContext(), i);
        }
    }
}
