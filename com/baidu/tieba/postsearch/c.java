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
/* loaded from: classes24.dex */
public class c {
    private NoDataView mNoDataView;
    private View mRootView;
    private PostSearchActivity moa;
    private View moi;
    private BdListView moj;
    private com.baidu.tbadk.core.dialog.a mol;
    private com.baidu.tieba.mainentrance.d mok = null;
    private View bFD = null;
    private boolean mom = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.moa = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.moi = this.moa.findViewById(R.id.history_frame);
        this.moj = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.moa.getActivity(), this.moj, BdListViewHelper.HeadType.DEFAULT);
        this.mok = new com.baidu.tieba.mainentrance.d(this.moa.getPageContext().getPageActivity(), null);
        this.mok.sY(false);
        this.moj.setAdapter((ListAdapter) this.mok);
        this.bFD = LayoutInflater.from(this.moa.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.moj.addFooterView(this.bFD);
        this.bFD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cRU();
            }
        });
        this.moj.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new aq("c12403").dR("fid", c.this.moa.mForumId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fname", c.this.moa.mForumName));
                String str = (String) c.this.moj.getItemAtPosition(i + 1);
                c.this.moa.QS(str);
                c.this.moa.yh(str);
                PostSearchActivity unused = c.this.moa;
                TiebaStatic.log(new aq("c12842").dR("obj_name", str).dR("obj_source", "3").dR("obj_type", "2").dR("fid", c.this.moa.mForumId));
            }
        });
        this.moj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.moa.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRU() {
        if (this.mol == null) {
            this.mol = new com.baidu.tbadk.core.dialog.a(this.moa.getPageContext().getPageActivity()).Bo(this.moa.getPageContext().getString(R.string.alert_clean_history)).a(this.moa.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.moa.dyA().dyN();
                    c.this.moj.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.moa.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.moa.getPageContext());
        }
        this.mol.bpc();
    }

    private void CQ(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.moa.getPageContext().getPageActivity(), this.moi, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.moa.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pQ(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.moa.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.moa.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, this.moa.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        CQ(R.string.new_text_no_search_record);
    }

    public void dyF() {
        this.moj.setVisibility(8);
        CQ(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.mom = true;
        this.moa.showLoadingView(this.moi, false, this.moa.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.mom = false;
        this.moa.hideLoadingView(this.moi);
    }

    public void be(ArrayList<String> arrayList) {
        this.moi.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.moj.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.moj.setVisibility(0);
        this.mok.setData(arrayList);
        this.mok.notifyDataSetChanged();
    }

    public void dyG() {
        this.moi.setVisibility(8);
    }

    public boolean dyH() {
        return this.moi.getVisibility() == 0 && !this.mom && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.moa.getPageContext(), this.bFD);
        this.mok.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.moa.getPageContext(), i);
        }
    }
}
