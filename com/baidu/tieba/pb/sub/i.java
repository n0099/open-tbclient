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
    private TextView bEn;
    private SubPbLoadPreviousView bEo;
    private View bEp;
    protected View buR;
    private NavigationBar mNavigationBar;

    public i(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        super(baseActivity, z, onClickListener, onClickListener2, onClickListener3, onClickListener4, onClickListener5);
        this.bEn = null;
        this.bEo = null;
        this.bEp = null;
        this.mNavigationBar = null;
        this.buR = null;
        this.bEo = (SubPbLoadPreviousView) this.bEr.findViewById(w.sub_pb_load_previous);
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(w.view_navigation_bar);
        this.buR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bEn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getResources().getString(z.view_subject), onClickListener);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public boolean Zp() {
        if (this.aBE.isVisible()) {
            this.aBE.afG();
            this.aBE.hide();
            this.bEx.setEnabled(true);
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
    protected void Zq() {
        this.aBE = (PbEditor) this.rootView.findViewById(w.sub_pb_editor);
        this.aBE.aI(true);
        this.aBE.afF();
        this.bEx.setEnabled(false);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.aBE.a(this.mActivity.getPageContext(), new k(this, wVar));
        }
    }

    public TextView Zr() {
        return this.bEn;
    }

    private NavigationBar getNavigationBar() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(w.view_navigation_bar);
        return this.mNavigationBar;
    }

    private SubPbLoadPreviousView Zs() {
        this.bEo = (SubPbLoadPreviousView) this.bEr.findViewById(w.sub_pb_load_previous);
        return this.bEo;
    }

    private View Zt() {
        this.bEp = this.bEr.findViewById(w.sub_pb_load_previous_top);
        return this.bEp;
    }

    public void Zu() {
        Zs().Ya();
        Zt().setVisibility(0);
    }

    public void Zv() {
        Zs().Zg();
        Zt().setVisibility(0);
    }

    public void Zw() {
        Zs().hide();
        Zt().setVisibility(8);
        this.bEr.setPadding(0, 0, 0, 0);
        ((h) this.bEs).dZ(false);
    }

    public void Zx() {
        Zs().yB();
        Zs().setVisibility(0);
        this.bEr.setPadding(0, 0, 0, 0);
        ((h) this.bEs).dZ(true);
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected void B(View.OnClickListener onClickListener) {
        this.bEs = new h(this.mActivity.getPageContext().getPageActivity(), onClickListener);
        this.bEs.A(this.bDI);
        this.mListView.setAdapter((ListAdapter) this.bEs);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getNavigationBar().onChangeSkinType(this.mActivity.getPageContext(), i);
        Zs().changeSkinType(i);
        this.mActivity.getLayoutMode().h(Zt());
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected void Zy() {
        this.rootView = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity.getPageContext().getPageActivity(), x.new_sub_pb_reply_layout, null);
        this.bEr = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity.getPageContext().getPageActivity(), x.new_sub_pb_reply_head, null);
        Zs().setOnClickListener(this.aGs);
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected int c(com.baidu.tieba.tbadkCore.b.o oVar) {
        if (oVar == null) {
            return 0;
        }
        int totalCount = oVar.getTotalCount() - (oVar.getCurrentPage() * oVar.ahf());
        if (totalCount < 0) {
            totalCount = 0;
        }
        return totalCount;
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void hB(String str) {
        h hVar;
        int hy;
        if ((this.bEs instanceof h) && (hy = (hVar = (h) this.bEs).hy(str)) > -1) {
            this.mListView.setSelection(hy + 1);
            com.baidu.tieba.tbadkCore.b.k kVar = (com.baidu.tieba.tbadkCore.b.k) hVar.getItem(hy);
            if (kVar != null) {
                String userName = kVar.getAuthor().getUserName();
                if (userName == null) {
                    userName = "";
                }
                this.aBE.getEditText().setText(this.mActivity.getResources().getString(z.reply_sub_floor).replace("%s", userName));
                this.aBE.getEditText().setSelection(this.aBE.getEditText().getText().length());
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
