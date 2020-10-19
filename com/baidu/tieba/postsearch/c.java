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
    private PostSearchActivity lVD;
    private View lVL;
    private BdListView lVM;
    private com.baidu.tbadk.core.dialog.a lVO;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d lVN = null;
    private View bxe = null;
    private boolean lVP = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.lVD = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.lVL = this.lVD.findViewById(R.id.history_frame);
        this.lVM = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.lVD.getActivity(), this.lVM, BdListViewHelper.HeadType.DEFAULT);
        this.lVN = new com.baidu.tieba.mainentrance.d(this.lVD.getPageContext().getPageActivity(), null);
        this.lVN.sx(false);
        this.lVM.setAdapter((ListAdapter) this.lVN);
        this.bxe = LayoutInflater.from(this.lVD.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.lVM.addFooterView(this.bxe);
        this.bxe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cMm();
            }
        });
        this.lVM.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new aq("c12403").dK("fid", c.this.lVD.mForumId).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("fname", c.this.lVD.mForumName));
                String str = (String) c.this.lVM.getItemAtPosition(i + 1);
                c.this.lVD.Qd(str);
                c.this.lVD.xA(str);
                PostSearchActivity unused = c.this.lVD;
                TiebaStatic.log(new aq("c12842").dK("obj_name", str).dK("obj_source", "3").dK("obj_type", "2").dK("fid", c.this.lVD.mForumId));
            }
        });
        this.lVM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.lVD.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMm() {
        if (this.lVO == null) {
            this.lVO = new com.baidu.tbadk.core.dialog.a(this.lVD.getPageContext().getPageActivity()).AH(this.lVD.getPageContext().getString(R.string.alert_clean_history)).a(this.lVD.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.lVD.dsR().dte();
                    c.this.lVM.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.lVD.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.lVD.getPageContext());
        }
        this.lVO.bkJ();
    }

    private void Ck(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.lVD.getPageContext().getPageActivity(), this.lVL, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.lVD.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pv(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.lVD.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.lVD.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dL(null, this.lVD.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        Ck(R.string.new_text_no_search_record);
    }

    public void dsW() {
        this.lVM.setVisibility(8);
        Ck(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.lVP = true;
        this.lVD.showLoadingView(this.lVL, false, this.lVD.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.lVP = false;
        this.lVD.hideLoadingView(this.lVL);
    }

    public void bb(ArrayList<String> arrayList) {
        this.lVL.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.lVM.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.lVM.setVisibility(0);
        this.lVN.setData(arrayList);
        this.lVN.notifyDataSetChanged();
    }

    public void dsX() {
        this.lVL.setVisibility(8);
    }

    public boolean dsY() {
        return this.lVL.getVisibility() == 0 && !this.lVP && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.lVD.getPageContext(), this.bxe);
        this.lVN.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.lVD.getPageContext(), i);
        }
    }
}
