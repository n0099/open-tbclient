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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes18.dex */
public class c {
    private PostSearchActivity lgS;
    private View lha;
    private BdListView lhb;
    private com.baidu.tbadk.core.dialog.a lhd;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d lhc = null;
    private View bkz = null;
    private boolean lhe = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.lgS = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.lha = this.lgS.findViewById(R.id.history_frame);
        this.lhb = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.lgS.getActivity(), this.lhb, BdListViewHelper.HeadType.DEFAULT);
        this.lhc = new com.baidu.tieba.mainentrance.d(this.lgS.getPageContext().getPageActivity(), null);
        this.lhc.ra(false);
        this.lhb.setAdapter((ListAdapter) this.lhc);
        this.bkz = LayoutInflater.from(this.lgS.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.lhb.addFooterView(this.bkz);
        this.bkz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cuf();
            }
        });
        this.lhb.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new ap("c12403").dn("fid", c.this.lgS.mForumId).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("fname", c.this.lgS.mForumName));
                String str = (String) c.this.lhb.getItemAtPosition(i + 1);
                c.this.lgS.LT(str);
                c.this.lgS.ue(str);
                PostSearchActivity unused = c.this.lgS;
                TiebaStatic.log(new ap("c12842").dn("obj_name", str).dn("obj_source", "3").dn("obj_type", "2").dn("fid", c.this.lgS.mForumId));
            }
        });
        this.lhb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.lgS.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuf() {
        if (this.lhd == null) {
            this.lhd = new com.baidu.tbadk.core.dialog.a(this.lgS.getPageContext().getPageActivity()).xl(this.lgS.getPageContext().getString(R.string.alert_clean_history)).a(this.lgS.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.lgS.das().daF();
                    c.this.lhb.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.lgS.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.lgS.getPageContext());
        }
        this.lhd.aYL();
    }

    private void yK(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.lgS.getPageContext().getPageActivity(), this.lha, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.lgS.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.mF(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.lgS.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.lgS.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.m31do(null, this.lgS.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        yK(R.string.new_text_no_search_record);
    }

    public void dax() {
        this.lhb.setVisibility(8);
        yK(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.lhe = true;
        this.lgS.showLoadingView(this.lha, false, this.lgS.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.lhe = false;
        this.lgS.hideLoadingView(this.lha);
    }

    public void aT(ArrayList<String> arrayList) {
        this.lha.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.lhb.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.lhb.setVisibility(0);
        this.lhc.setData(arrayList);
        this.lhc.notifyDataSetChanged();
    }

    public void day() {
        this.lha.setVisibility(8);
    }

    public boolean daz() {
        return this.lha.getVisibility() == 0 && !this.lhe && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.lgS.getPageContext(), this.bkz);
        this.lhc.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.lgS.getPageContext(), i);
        }
    }
}
