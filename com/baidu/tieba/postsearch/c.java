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
/* loaded from: classes23.dex */
public class c {
    private com.baidu.tbadk.core.dialog.a lGA;
    private PostSearchActivity lGp;
    private View lGx;
    private BdListView lGy;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d lGz = null;
    private View btr = null;
    private boolean lGB = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.lGp = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.lGx = this.lGp.findViewById(R.id.history_frame);
        this.lGy = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.lGp.getActivity(), this.lGy, BdListViewHelper.HeadType.DEFAULT);
        this.lGz = new com.baidu.tieba.mainentrance.d(this.lGp.getPageContext().getPageActivity(), null);
        this.lGz.rQ(false);
        this.lGy.setAdapter((ListAdapter) this.lGz);
        this.btr = LayoutInflater.from(this.lGp.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.lGy.addFooterView(this.btr);
        this.btr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cID();
            }
        });
        this.lGy.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new aq("c12403").dF("fid", c.this.lGp.mForumId).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("fname", c.this.lGp.mForumName));
                String str = (String) c.this.lGy.getItemAtPosition(i + 1);
                c.this.lGp.Po(str);
                c.this.lGp.wO(str);
                PostSearchActivity unused = c.this.lGp;
                TiebaStatic.log(new aq("c12842").dF("obj_name", str).dF("obj_source", "3").dF("obj_type", "2").dF("fid", c.this.lGp.mForumId));
            }
        });
        this.lGy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.lGp.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cID() {
        if (this.lGA == null) {
            this.lGA = new com.baidu.tbadk.core.dialog.a(this.lGp.getPageContext().getPageActivity()).zV(this.lGp.getPageContext().getString(R.string.alert_clean_history)).a(this.lGp.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.lGp.dpg().dpt();
                    c.this.lGy.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.lGp.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.lGp.getPageContext());
        }
        this.lGA.bia();
    }

    private void BE(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.lGp.getPageContext().getPageActivity(), this.lGx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.lGp.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.oW(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.lGp.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.lGp.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dG(null, this.lGp.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        BE(R.string.new_text_no_search_record);
    }

    public void dpl() {
        this.lGy.setVisibility(8);
        BE(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.lGB = true;
        this.lGp.showLoadingView(this.lGx, false, this.lGp.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.lGB = false;
        this.lGp.hideLoadingView(this.lGx);
    }

    public void bb(ArrayList<String> arrayList) {
        this.lGx.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.lGy.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.lGy.setVisibility(0);
        this.lGz.setData(arrayList);
        this.lGz.notifyDataSetChanged();
    }

    public void dpm() {
        this.lGx.setVisibility(8);
    }

    public boolean dpn() {
        return this.lGx.getVisibility() == 0 && !this.lGB && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.lGp.getPageContext(), this.btr);
        this.lGz.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.lGp.getPageContext(), i);
        }
    }
}
