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
    private PostSearchActivity lgU;
    private View lhc;
    private BdListView lhd;
    private com.baidu.tbadk.core.dialog.a lhf;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d lhe = null;
    private View bkz = null;
    private boolean lhg = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.lgU = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.lhc = this.lgU.findViewById(R.id.history_frame);
        this.lhd = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.lgU.getActivity(), this.lhd, BdListViewHelper.HeadType.DEFAULT);
        this.lhe = new com.baidu.tieba.mainentrance.d(this.lgU.getPageContext().getPageActivity(), null);
        this.lhe.ra(false);
        this.lhd.setAdapter((ListAdapter) this.lhe);
        this.bkz = LayoutInflater.from(this.lgU.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.lhd.addFooterView(this.bkz);
        this.bkz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cuf();
            }
        });
        this.lhd.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new ap("c12403").dn("fid", c.this.lgU.mForumId).dn("uid", TbadkCoreApplication.getCurrentAccount()).dn("fname", c.this.lgU.mForumName));
                String str = (String) c.this.lhd.getItemAtPosition(i + 1);
                c.this.lgU.LT(str);
                c.this.lgU.ue(str);
                PostSearchActivity unused = c.this.lgU;
                TiebaStatic.log(new ap("c12842").dn("obj_name", str).dn("obj_source", "3").dn("obj_type", "2").dn("fid", c.this.lgU.mForumId));
            }
        });
        this.lhd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.lgU.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuf() {
        if (this.lhf == null) {
            this.lhf = new com.baidu.tbadk.core.dialog.a(this.lgU.getPageContext().getPageActivity()).xl(this.lgU.getPageContext().getString(R.string.alert_clean_history)).a(this.lgU.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.lgU.das().daF();
                    c.this.lhd.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.lgU.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.lgU.getPageContext());
        }
        this.lhf.aYL();
    }

    private void yK(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.lgU.getPageContext().getPageActivity(), this.lhc, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.lgU.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.mF(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.lgU.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.lgU.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.m31do(null, this.lgU.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        yK(R.string.new_text_no_search_record);
    }

    public void dax() {
        this.lhd.setVisibility(8);
        yK(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.lhg = true;
        this.lgU.showLoadingView(this.lhc, false, this.lgU.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.lhg = false;
        this.lgU.hideLoadingView(this.lhc);
    }

    public void aT(ArrayList<String> arrayList) {
        this.lhc.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.lhd.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.lhd.setVisibility(0);
        this.lhe.setData(arrayList);
        this.lhe.notifyDataSetChanged();
    }

    public void day() {
        this.lhc.setVisibility(8);
    }

    public boolean daz() {
        return this.lhc.getVisibility() == 0 && !this.lhg && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.lgU.getPageContext(), this.bkz);
        this.lhe.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.lgU.getPageContext(), i);
        }
    }
}
