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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class c {
    private PostSearchActivity kZB;
    private View kZK;
    private BdListView kZL;
    private com.baidu.tbadk.core.dialog.a kZN;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d kZM = null;
    private View bkf = null;
    private boolean kZO = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.kZB = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.kZK = this.kZB.findViewById(R.id.history_frame);
        this.kZL = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.kZB.getActivity(), this.kZL, BdListViewHelper.HeadType.DEFAULT);
        this.kZM = new com.baidu.tieba.mainentrance.d(this.kZB.getPageContext().getPageActivity(), null);
        this.kZM.qt(false);
        this.kZL.setAdapter((ListAdapter) this.kZM);
        this.bkf = LayoutInflater.from(this.kZB.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.kZL.addFooterView(this.bkf);
        this.bkf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cqh();
            }
        });
        this.kZL.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new ao("c12403").dk("fid", c.this.kZB.mForumId).dk("uid", TbadkCoreApplication.getCurrentAccount()).dk("fname", c.this.kZB.mForumName));
                String str = (String) c.this.kZL.getItemAtPosition(i + 1);
                c.this.kZB.Ll(str);
                c.this.kZB.tb(str);
                PostSearchActivity unused = c.this.kZB;
                TiebaStatic.log(new ao("c12842").dk("obj_name", str).dk("obj_source", "3").dk("obj_type", "2").dk("fid", c.this.kZB.mForumId));
            }
        });
        this.kZL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.kZB.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqh() {
        if (this.kZN == null) {
            this.kZN = new com.baidu.tbadk.core.dialog.a(this.kZB.getPageContext().getPageActivity()).we(this.kZB.getPageContext().getString(R.string.alert_clean_history)).a(this.kZB.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.kZB.cXl().cXy();
                    c.this.kZL.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.kZB.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.kZB.getPageContext());
        }
        this.kZN.aUN();
    }

    private void ym(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kZB.getPageContext().getPageActivity(), this.kZK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.kZB.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.mm(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.kZB.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.kZB.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dm(null, this.kZB.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        ym(R.string.new_text_no_search_record);
    }

    public void cXq() {
        this.kZL.setVisibility(8);
        ym(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.kZO = true;
        this.kZB.showLoadingView(this.kZK, false, this.kZB.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.kZO = false;
        this.kZB.hideLoadingView(this.kZK);
    }

    public void aS(ArrayList<String> arrayList) {
        this.kZK.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.kZL.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.kZL.setVisibility(0);
        this.kZM.setData(arrayList);
        this.kZM.notifyDataSetChanged();
    }

    public void cXr() {
        this.kZK.setVisibility(8);
    }

    public boolean cXs() {
        return this.kZK.getVisibility() == 0 && !this.kZO && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.kZB.getPageContext(), this.bkf);
        this.kZM.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kZB.getPageContext(), i);
        }
    }
}
