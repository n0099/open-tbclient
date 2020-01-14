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
/* loaded from: classes9.dex */
public class c {
    private BdListView jAa;
    private com.baidu.tbadk.core.dialog.a jAc;
    private PostSearchActivity jzQ;
    private View jzZ;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d jAb = null;
    private View azg = null;
    private boolean jAd = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.jzQ = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.jzZ = this.jzQ.findViewById(R.id.history_frame);
        this.jAa = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.jzQ.getActivity(), this.jAa, BdListViewHelper.HeadType.DEFAULT);
        this.jAb = new com.baidu.tieba.mainentrance.d(this.jzQ.getPageContext().getPageActivity(), null);
        this.jAb.oA(false);
        this.jAa.setAdapter((ListAdapter) this.jAb);
        this.azg = LayoutInflater.from(this.jzQ.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.jAa.addFooterView(this.azg);
        this.azg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.bTp();
            }
        });
        this.jAa.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").cp("fid", c.this.jzQ.mForumId).cp("uid", TbadkCoreApplication.getCurrentAccount()).cp("fname", c.this.jzQ.mForumName));
                String str = (String) c.this.jAa.getItemAtPosition(i + 1);
                c.this.jzQ.GY(str);
                c.this.jzQ.pO(str);
                PostSearchActivity unused = c.this.jzQ;
                TiebaStatic.log(new an("c12842").cp("obj_name", str).cp("obj_source", "3").cp("obj_type", "2").cp("fid", c.this.jzQ.mForumId));
            }
        });
        this.jAa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.jzQ.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTp() {
        if (this.jAc == null) {
            this.jAc = new com.baidu.tbadk.core.dialog.a(this.jzQ.getPageContext().getPageActivity()).sC(this.jzQ.getPageContext().getString(R.string.alert_clean_history)).a(this.jzQ.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.jzQ.czd().czq();
                    c.this.jAa.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.jzQ.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.jzQ.getPageContext());
        }
        this.jAc.aCp();
    }

    private void wi(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.jzQ.getPageContext().getPageActivity(), this.jzZ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.jzQ.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.kQ(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.jzQ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.jzQ.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cr(null, this.jzQ.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        wi(R.string.new_text_no_search_record);
    }

    public void czi() {
        this.jAa.setVisibility(8);
        wi(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.jAd = true;
        this.jzQ.showLoadingView(this.jzZ, false, this.jzQ.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.jAd = false;
        this.jzQ.hideLoadingView(this.jzZ);
    }

    public void aP(ArrayList<String> arrayList) {
        this.jzZ.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.jAa.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.jAa.setVisibility(0);
        this.jAb.setData(arrayList);
        this.jAb.notifyDataSetChanged();
    }

    public void czj() {
        this.jzZ.setVisibility(8);
    }

    public boolean czk() {
        return this.jzZ.getVisibility() == 0 && !this.jAd && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.q.a.a(this.jzQ.getPageContext(), this.azg);
        this.jAb.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.jzQ.getPageContext(), i);
        }
    }
}
