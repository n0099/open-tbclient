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
/* loaded from: classes18.dex */
public class c {
    private View lxG;
    private BdListView lxH;
    private com.baidu.tbadk.core.dialog.a lxJ;
    private PostSearchActivity lxy;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d lxI = null;
    private View bqh = null;
    private boolean lxK = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.lxy = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.lxG = this.lxy.findViewById(R.id.history_frame);
        this.lxH = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.lxy.getActivity(), this.lxH, BdListViewHelper.HeadType.DEFAULT);
        this.lxI = new com.baidu.tieba.mainentrance.d(this.lxy.getPageContext().getPageActivity(), null);
        this.lxI.rI(false);
        this.lxH.setAdapter((ListAdapter) this.lxI);
        this.bqh = LayoutInflater.from(this.lxy.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.lxH.addFooterView(this.bqh);
        this.bqh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cEX();
            }
        });
        this.lxH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new aq("c12403").dD("fid", c.this.lxy.mForumId).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("fname", c.this.lxy.mForumName));
                String str = (String) c.this.lxH.getItemAtPosition(i + 1);
                c.this.lxy.ON(str);
                c.this.lxy.wv(str);
                PostSearchActivity unused = c.this.lxy;
                TiebaStatic.log(new aq("c12842").dD("obj_name", str).dD("obj_source", "3").dD("obj_type", "2").dD("fid", c.this.lxy.mForumId));
            }
        });
        this.lxH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.lxy.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEX() {
        if (this.lxJ == null) {
            this.lxJ = new com.baidu.tbadk.core.dialog.a(this.lxy.getPageContext().getPageActivity()).zA(this.lxy.getPageContext().getString(R.string.alert_clean_history)).a(this.lxy.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.lxy.dlz().dlM();
                    c.this.lxH.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.lxy.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.lxy.getPageContext());
        }
        this.lxJ.bhg();
    }

    private void Bd(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.lxy.getPageContext().getPageActivity(), this.lxG, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.lxy.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.oK(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.lxy.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.lxy.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dE(null, this.lxy.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        Bd(R.string.new_text_no_search_record);
    }

    public void dlE() {
        this.lxH.setVisibility(8);
        Bd(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.lxK = true;
        this.lxy.showLoadingView(this.lxG, false, this.lxy.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.lxK = false;
        this.lxy.hideLoadingView(this.lxG);
    }

    public void aZ(ArrayList<String> arrayList) {
        this.lxG.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.lxH.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.lxH.setVisibility(0);
        this.lxI.setData(arrayList);
        this.lxI.notifyDataSetChanged();
    }

    public void dlF() {
        this.lxG.setVisibility(8);
    }

    public boolean dlG() {
        return this.lxG.getVisibility() == 0 && !this.lxK && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.lxy.getPageContext(), this.bqh);
        this.lxI.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.lxy.getPageContext(), i);
        }
    }
}
