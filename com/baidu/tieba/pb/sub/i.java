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
    private TextView bFX;
    private SubPbLoadPreviousView bFY;
    private View bFZ;
    protected View bwm;
    private NavigationBar mNavigationBar;

    public i(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        super(baseActivity, z, onClickListener, onClickListener2, onClickListener3, onClickListener4, onClickListener5);
        this.bFX = null;
        this.bFY = null;
        this.bFZ = null;
        this.mNavigationBar = null;
        this.bwm = null;
        this.bFY = (SubPbLoadPreviousView) this.bGb.findViewById(w.sub_pb_load_previous);
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(w.view_navigation_bar);
        this.bwm = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bFX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getResources().getString(z.view_subject), onClickListener);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public boolean ZP() {
        if (this.aCC.isVisible()) {
            this.aCC.agf();
            this.aCC.hide();
            this.bGh.setEnabled(true);
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
    protected void ZQ() {
        this.aCC = (PbEditor) this.rootView.findViewById(w.sub_pb_editor);
        this.aCC.aK(true);
        this.aCC.age();
        this.bGh.setEnabled(false);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.aCC.a(this.mActivity.getPageContext(), new k(this, wVar));
        }
    }

    public TextView ZR() {
        return this.bFX;
    }

    private NavigationBar getNavigationBar() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(w.view_navigation_bar);
        return this.mNavigationBar;
    }

    private SubPbLoadPreviousView ZS() {
        this.bFY = (SubPbLoadPreviousView) this.bGb.findViewById(w.sub_pb_load_previous);
        return this.bFY;
    }

    private View ZT() {
        this.bFZ = this.bGb.findViewById(w.sub_pb_load_previous_top);
        return this.bFZ;
    }

    public void ZU() {
        ZS().YA();
        ZT().setVisibility(0);
    }

    public void ZV() {
        ZS().ZG();
        ZT().setVisibility(0);
    }

    public void ZW() {
        ZS().hide();
        ZT().setVisibility(8);
        this.bGb.setPadding(0, 0, 0, 0);
        ((h) this.bGc).ef(false);
    }

    public void ZX() {
        ZS().yL();
        ZS().setVisibility(0);
        this.bGb.setPadding(0, 0, 0, 0);
        ((h) this.bGc).ef(true);
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected void C(View.OnClickListener onClickListener) {
        this.bGc = new h(this.mActivity.getPageContext().getPageActivity(), onClickListener);
        this.bGc.B(this.bFs);
        this.mListView.setAdapter((ListAdapter) this.bGc);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getNavigationBar().onChangeSkinType(this.mActivity.getPageContext(), i);
        this.mActivity.getLayoutMode().h(ZT());
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected void ZY() {
        this.rootView = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), x.new_sub_pb_reply_layout, null);
        this.bGb = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), x.new_sub_pb_reply_head, null);
        ZS().setOnClickListener(this.aHz);
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected int c(com.baidu.tieba.tbadkCore.b.o oVar) {
        if (oVar == null) {
            return 0;
        }
        int totalCount = oVar.getTotalCount() - (oVar.getCurrentPage() * oVar.ahF());
        if (totalCount < 0) {
            totalCount = 0;
        }
        return totalCount;
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void hF(String str) {
        h hVar;
        int hC;
        if ((this.bGc instanceof h) && (hC = (hVar = (h) this.bGc).hC(str)) > -1) {
            this.mListView.setSelection(hC + 1);
            com.baidu.tieba.tbadkCore.b.k kVar = (com.baidu.tieba.tbadkCore.b.k) hVar.getItem(hC);
            if (kVar != null) {
                String userName = kVar.getAuthor().getUserName();
                if (userName == null) {
                    userName = "";
                }
                this.aCC.getEditText().setText(this.mActivity.getResources().getString(z.reply_sub_floor).replace("%s", userName));
                this.aCC.getEditText().setSelection(this.aCC.getEditText().getText().length());
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
