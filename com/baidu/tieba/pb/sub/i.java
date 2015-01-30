package com.baidu.tieba.pb.sub;

import android.os.Handler;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class i extends l {
    private TextView bFY;
    private SubPbLoadPreviousView bFZ;
    private View bGa;
    protected View bwn;
    private NavigationBar mNavigationBar;

    public i(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        super(baseActivity, z, onClickListener, onClickListener2, onClickListener3, onClickListener4, onClickListener5);
        this.bFY = null;
        this.bFZ = null;
        this.bGa = null;
        this.mNavigationBar = null;
        this.bwn = null;
        this.bFZ = (SubPbLoadPreviousView) this.bGc.findViewById(w.sub_pb_load_previous);
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(w.view_navigation_bar);
        this.bwn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bFY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getResources().getString(z.view_subject), onClickListener);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public boolean ZU() {
        if (this.aCF.isVisible()) {
            this.aCF.agk();
            this.aCF.hide();
            this.bGi.setEnabled(true);
        } else {
            this.mActivity.finish();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.sub.l
    public void b(int i, View view) {
        new Handler().postDelayed(new j(this, i, view), 300L);
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected void ZV() {
        this.aCF = (PbEditor) this.rootView.findViewById(w.sub_pb_editor);
        this.aCF.aK(true);
        this.aCF.agj();
        this.bGi.setEnabled(false);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.aCF.a(this.mActivity.getPageContext(), new k(this, wVar));
        }
    }

    public TextView ZW() {
        return this.bFY;
    }

    private NavigationBar getNavigationBar() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(w.view_navigation_bar);
        return this.mNavigationBar;
    }

    private SubPbLoadPreviousView ZX() {
        this.bFZ = (SubPbLoadPreviousView) this.bGc.findViewById(w.sub_pb_load_previous);
        return this.bFZ;
    }

    private View ZY() {
        this.bGa = this.bGc.findViewById(w.sub_pb_load_previous_top);
        return this.bGa;
    }

    public void ZZ() {
        ZX().YF();
        ZY().setVisibility(0);
    }

    public void aaa() {
        ZX().ZL();
        ZY().setVisibility(0);
    }

    public void aab() {
        ZX().hide();
        ZY().setVisibility(8);
        this.bGc.setPadding(0, 0, 0, 0);
        ((h) this.bGd).ef(false);
    }

    public void aac() {
        ZX().yR();
        ZX().setVisibility(0);
        this.bGc.setPadding(0, 0, 0, 0);
        ((h) this.bGd).ef(true);
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected void C(View.OnClickListener onClickListener) {
        this.bGd = new h(this.mActivity.getPageContext().getPageActivity(), onClickListener);
        this.bGd.B(this.bFt);
        this.mListView.setAdapter((ListAdapter) this.bGd);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getNavigationBar().onChangeSkinType(this.mActivity.getPageContext(), i);
        this.mActivity.getLayoutMode().h(ZY());
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected void aad() {
        this.rootView = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), x.new_sub_pb_reply_layout, null);
        this.bGc = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), x.new_sub_pb_reply_head, null);
        ZX().setOnClickListener(this.aHC);
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected int c(com.baidu.tieba.tbadkCore.b.o oVar) {
        if (oVar == null) {
            return 0;
        }
        int totalCount = oVar.getTotalCount() - (oVar.getCurrentPage() * oVar.ahK());
        if (totalCount < 0) {
            totalCount = 0;
        }
        return totalCount;
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void hI(String str) {
        h hVar;
        int hF;
        if ((this.bGd instanceof h) && (hF = (hVar = (h) this.bGd).hF(str)) > -1) {
            this.mListView.setSelection(hF + 1);
            com.baidu.tieba.tbadkCore.b.k kVar = (com.baidu.tieba.tbadkCore.b.k) hVar.getItem(hF);
            if (kVar != null) {
                String userName = kVar.getAuthor().getUserName();
                if (userName == null) {
                    userName = "";
                }
                this.aCF.getEditText().setText(this.mActivity.getResources().getString(z.reply_sub_floor).replace("%s", userName));
                this.aCF.getEditText().setSelection(this.aCF.getEditText().getText().length());
            }
            if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
                hVar.S(str, this.mActivity.getResources().getColor(t.c_393d47));
            } else {
                hVar.S(str, this.mActivity.getResources().getColor(t.c_fdfdf1));
            }
            this.mListView.invalidate();
        }
    }
}
