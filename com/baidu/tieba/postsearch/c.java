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
/* loaded from: classes23.dex */
public class c {
    private NoDataView mNoDataView;
    private View mRootView;
    private View moD;
    private BdListView moE;
    private com.baidu.tbadk.core.dialog.a moG;
    private PostSearchActivity mov;
    private com.baidu.tieba.mainentrance.d moF = null;
    private View bDS = null;
    private boolean moH = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.mov = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.moD = this.mov.findViewById(R.id.history_frame);
        this.moE = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.mov.getActivity(), this.moE, BdListViewHelper.HeadType.DEFAULT);
        this.moF = new com.baidu.tieba.mainentrance.d(this.mov.getPageContext().getPageActivity(), null);
        this.moF.tb(false);
        this.moE.setAdapter((ListAdapter) this.moF);
        this.bDS = LayoutInflater.from(this.mov.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.moE.addFooterView(this.bDS);
        this.bDS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cRA();
            }
        });
        this.moE.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new ar("c12403").dR("fid", c.this.mov.mForumId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fname", c.this.mov.mForumName));
                String str = (String) c.this.moE.getItemAtPosition(i + 1);
                c.this.mov.Qn(str);
                c.this.mov.yc(str);
                PostSearchActivity unused = c.this.mov;
                TiebaStatic.log(new ar("c12842").dR("obj_name", str).dR("obj_source", "3").dR("obj_type", "2").dR("fid", c.this.mov.mForumId));
            }
        });
        this.moE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.mov.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cRA() {
        if (this.moG == null) {
            this.moG = new com.baidu.tbadk.core.dialog.a(this.mov.getPageContext().getPageActivity()).AJ(this.mov.getPageContext().getString(R.string.alert_clean_history)).a(this.mov.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.mov.dya().dyn();
                    c.this.moE.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.mov.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.mov.getPageContext());
        }
        this.moG.bog();
    }

    private void Do(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mov.getPageContext().getPageActivity(), this.moD, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mov.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.qo(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.mov.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.mov.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, this.mov.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        Do(R.string.new_text_no_search_record);
    }

    public void dyf() {
        this.moE.setVisibility(8);
        Do(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.moH = true;
        this.mov.showLoadingView(this.moD, false, this.mov.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.moH = false;
        this.mov.hideLoadingView(this.moD);
    }

    public void bf(ArrayList<String> arrayList) {
        this.moD.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.moE.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.moE.setVisibility(0);
        this.moF.setData(arrayList);
        this.moF.notifyDataSetChanged();
    }

    public void dyg() {
        this.moD.setVisibility(8);
    }

    public boolean dyh() {
        return this.moD.getVisibility() == 0 && !this.moH && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.mov.getPageContext(), this.bDS);
        this.moF.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mov.getPageContext(), i);
        }
    }
}
