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
    private PostSearchActivity mic;
    private View mil;
    private BdListView mim;
    private com.baidu.tbadk.core.dialog.a mip;
    private com.baidu.tieba.mainentrance.d mio = null;
    private View bzs = null;
    private boolean miq = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.mic = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.mil = this.mic.findViewById(R.id.history_frame);
        this.mim = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.mic.getActivity(), this.mim, BdListViewHelper.HeadType.DEFAULT);
        this.mio = new com.baidu.tieba.mainentrance.d(this.mic.getPageContext().getPageActivity(), null);
        this.mio.sP(false);
        this.mim.setAdapter((ListAdapter) this.mio);
        this.bzs = LayoutInflater.from(this.mic.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.mim.addFooterView(this.bzs);
        this.bzs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cPt();
            }
        });
        this.mim.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new aq("c12403").dR("fid", c.this.mic.mForumId).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fname", c.this.mic.mForumName));
                String str = (String) c.this.mim.getItemAtPosition(i + 1);
                c.this.mic.QB(str);
                c.this.mic.xT(str);
                PostSearchActivity unused = c.this.mic;
                TiebaStatic.log(new aq("c12842").dR("obj_name", str).dR("obj_source", "3").dR("obj_type", "2").dR("fid", c.this.mic.mForumId));
            }
        });
        this.mim.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.mic.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPt() {
        if (this.mip == null) {
            this.mip = new com.baidu.tbadk.core.dialog.a(this.mic.getPageContext().getPageActivity()).Ba(this.mic.getPageContext().getString(R.string.alert_clean_history)).a(this.mic.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.mic.dvY().dwl();
                    c.this.mim.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.mic.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.mic.getPageContext());
        }
        this.mip.bmC();
    }

    private void CD(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.mic.getPageContext().getPageActivity(), this.mil, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.mic.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.pG(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.mic.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.mic.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dS(null, this.mic.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        CD(R.string.new_text_no_search_record);
    }

    public void dwd() {
        this.mim.setVisibility(8);
        CD(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.miq = true;
        this.mic.showLoadingView(this.mil, false, this.mic.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.miq = false;
        this.mic.hideLoadingView(this.mil);
    }

    public void be(ArrayList<String> arrayList) {
        this.mil.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.mim.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.mim.setVisibility(0);
        this.mio.setData(arrayList);
        this.mio.notifyDataSetChanged();
    }

    public void dwe() {
        this.mil.setVisibility(8);
    }

    public boolean dwf() {
        return this.mil.getVisibility() == 0 && !this.miq && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.r.a.a(this.mic.getPageContext(), this.bzs);
        this.mio.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.mic.getPageContext(), i);
        }
    }
}
