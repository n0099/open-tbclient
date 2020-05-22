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
/* loaded from: classes11.dex */
public class c {
    private View kEG;
    private BdListView kEH;
    private com.baidu.tbadk.core.dialog.a kEJ;
    private PostSearchActivity kEx;
    private NoDataView mNoDataView;
    private View mRootView;
    private com.baidu.tieba.mainentrance.d kEI = null;
    private View beU = null;
    private boolean kEK = false;

    public c(PostSearchActivity postSearchActivity, View view) {
        this.kEx = postSearchActivity;
        this.mRootView = view;
        initView();
    }

    private void initView() {
        this.kEG = this.kEx.findViewById(R.id.history_frame);
        this.kEH = (BdListView) this.mRootView.findViewById(R.id.history_list);
        BdListViewHelper.a(this.kEx.getActivity(), this.kEH, BdListViewHelper.HeadType.DEFAULT);
        this.kEI = new com.baidu.tieba.mainentrance.d(this.kEx.getPageContext().getPageActivity(), null);
        this.kEI.qj(false);
        this.kEH.setAdapter((ListAdapter) this.kEI);
        this.beU = LayoutInflater.from(this.kEx.getPageContext().getPageActivity()).inflate(R.layout.home_dialog_search_footer, (ViewGroup) null);
        this.kEH.addFooterView(this.beU);
        this.beU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.postsearch.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cmi();
            }
        });
        this.kEH.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.postsearch.c.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                TiebaStatic.log(new an("c12403").dh("fid", c.this.kEx.mForumId).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("fname", c.this.kEx.mForumName));
                String str = (String) c.this.kEH.getItemAtPosition(i + 1);
                c.this.kEx.KJ(str);
                c.this.kEx.sT(str);
                PostSearchActivity unused = c.this.kEx;
                TiebaStatic.log(new an("c12842").dh("obj_name", str).dh("obj_source", "3").dh("obj_type", "2").dh("fid", c.this.kEx.mForumId));
            }
        });
        this.kEH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                c.this.kEx.hideSoftKeyPad();
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmi() {
        if (this.kEJ == null) {
            this.kEJ = new com.baidu.tbadk.core.dialog.a(this.kEx.getPageContext().getPageActivity()).vO(this.kEx.getPageContext().getString(R.string.alert_clean_history)).a(this.kEx.getPageContext().getString(R.string.clear_all_text), new a.b() { // from class: com.baidu.tieba.postsearch.c.5
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                    c.this.kEx.cSE().cSR();
                    c.this.kEH.setVisibility(8);
                    c.this.showNoDataView();
                }
            }).b(this.kEx.getPageContext().getString(R.string.cancel), new a.b() { // from class: com.baidu.tieba.postsearch.c.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            }).b(this.kEx.getPageContext());
        }
        this.kEJ.aST();
    }

    private void xA(int i) {
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.kEx.getPageContext().getPageActivity(), this.kEG, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, l.getDimens(this.kEx.getActivity(), R.dimen.ds320)), NoDataViewFactory.d.lT(R.string.text_no_search_record), null);
            this.mNoDataView.onChangeSkinType(this.kEx.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.mNoDataView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.postsearch.c.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    c.this.kEx.hideSoftKeyPad();
                    return false;
                }
            });
        }
        this.mNoDataView.setTextOption(NoDataViewFactory.d.dj(null, this.kEx.getResources().getString(i)));
        this.mNoDataView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoDataView() {
        xA(R.string.new_text_no_search_record);
    }

    public void cSJ() {
        this.kEH.setVisibility(8);
        xA(R.string.new_text_no_search_result);
    }

    private void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void showLoadingView() {
        this.kEK = true;
        this.kEx.showLoadingView(this.kEG, false, this.kEx.getResources().getDimensionPixelSize(R.dimen.ds386));
    }

    public void hideLoadingView() {
        this.kEK = false;
        this.kEx.hideLoadingView(this.kEG);
    }

    public void aR(ArrayList<String> arrayList) {
        this.kEG.setVisibility(0);
        hideLoadingView();
        if (arrayList == null || arrayList.size() == 0) {
            this.kEH.setVisibility(8);
            showNoDataView();
            return;
        }
        hideNoDataView();
        this.kEH.setVisibility(0);
        this.kEI.setData(arrayList);
        this.kEI.notifyDataSetChanged();
    }

    public void cSK() {
        this.kEG.setVisibility(8);
    }

    public boolean cSL() {
        return this.kEG.getVisibility() == 0 && !this.kEK && (this.mNoDataView == null || 8 == this.mNoDataView.getVisibility());
    }

    public void onChangeSkinType(int i) {
        com.baidu.tbadk.q.a.a(this.kEx.getPageContext(), this.beU);
        this.kEI.notifyDataSetChanged();
        if (this.mNoDataView != null) {
            this.mNoDataView.onChangeSkinType(this.kEx.getPageContext(), i);
        }
    }
}
