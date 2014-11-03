package com.baidu.tieba.pb.sub;

import android.os.Handler;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortool.w;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.data.ar;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.v;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class i extends l {
    private TextView bAA;
    private SubPbLoadPreviousView bAB;
    private View bAC;
    protected View brC;
    private NavigationBar mNavigationBar;

    public i(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        super(baseActivity, z, onClickListener, onClickListener2, onClickListener3, onClickListener4, onClickListener5);
        this.bAA = null;
        this.bAB = null;
        this.bAC = null;
        this.mNavigationBar = null;
        this.brC = null;
        this.bAB = (SubPbLoadPreviousView) this.bAE.findViewById(v.sub_pb_load_previous);
        this.mNavigationBar = (NavigationBar) this.Xm.findViewById(v.view_navigation_bar);
        this.brC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bAA = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getResources().getString(y.view_subject), onClickListener);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public boolean YV() {
        if (this.azJ.isVisible()) {
            this.azJ.Ce();
            this.azJ.hide();
            this.bAK.setEnabled(true);
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
    protected void YW() {
        this.azJ = (PbEditor) this.Xm.findViewById(v.sub_pb_editor);
        this.azJ.au(true);
        this.azJ.Cd();
        this.bAK.setEnabled(false);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void setOnActionListener(w wVar) {
        if (wVar != null) {
            this.azJ.setOnActionListener(new k(this, wVar));
        }
    }

    public TextView YX() {
        return this.bAA;
    }

    private NavigationBar getNavigationBar() {
        this.mNavigationBar = (NavigationBar) this.Xm.findViewById(v.view_navigation_bar);
        return this.mNavigationBar;
    }

    private SubPbLoadPreviousView YY() {
        this.bAB = (SubPbLoadPreviousView) this.bAE.findViewById(v.sub_pb_load_previous);
        return this.bAB;
    }

    private View YZ() {
        this.bAC = this.bAE.findViewById(v.sub_pb_load_previous_top);
        return this.bAC;
    }

    public void Za() {
        YY().XD();
        YZ().setVisibility(0);
    }

    public void Zb() {
        YY().YM();
        YZ().setVisibility(0);
    }

    public void Zc() {
        YY().hide();
        YZ().setVisibility(8);
        this.bAE.setPadding(0, 0, 0, 0);
        ((h) this.bAF).eo(false);
    }

    public void Zd() {
        YY().Bc();
        YY().setVisibility(0);
        this.bAE.setPadding(0, 0, 0, 0);
        ((h) this.bAF).eo(true);
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected void v(View.OnClickListener onClickListener) {
        this.bAF = new h(this.mActivity, onClickListener);
        this.bAF.u(this.bzY);
        this.vl.setAdapter((ListAdapter) this.bAF);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getNavigationBar().onChangeSkinType(i);
        YY().changeSkinType(i);
        this.mActivity.getLayoutMode().h(YZ());
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected void Cm() {
        this.Xm = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.new_sub_pb_reply_layout, null);
        this.bAE = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.new_sub_pb_reply_head, null);
        YY().setOnClickListener(this.aEP);
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected int c(ar arVar) {
        if (arVar == null) {
            return 0;
        }
        int totalCount = arVar.getTotalCount() - (arVar.getCurrentPage() * arVar.Ax());
        if (totalCount < 0) {
            totalCount = 0;
        }
        return totalCount;
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void hc(String str) {
        h hVar;
        int gZ;
        if ((this.bAF instanceof h) && (gZ = (hVar = (h) this.bAF).gZ(str)) > -1) {
            this.vl.setSelection(gZ + 1);
            ak akVar = (ak) hVar.getItem(gZ);
            if (akVar != null) {
                String userName = akVar.getAuthor().getUserName();
                if (userName == null) {
                    userName = "";
                }
                this.azJ.getEditText().setText(this.mActivity.getResources().getString(y.reply_sub_floor).replace("%s", userName));
                this.azJ.getEditText().setSelection(this.azJ.getEditText().getText().length());
            }
            if (TbadkApplication.m251getInst().getSkinType() == 1) {
                hVar.L(str, this.mActivity.getResources().getColor(com.baidu.tieba.s.c_393d47));
            } else {
                hVar.L(str, this.mActivity.getResources().getColor(com.baidu.tieba.s.c_fdfdf1));
            }
            this.vl.invalidate();
        }
    }
}
