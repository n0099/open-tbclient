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
    private TextView bAm;
    private SubPbLoadPreviousView bAn;
    private View bAo;
    protected View bro;
    private NavigationBar mNavigationBar;

    public i(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        super(baseActivity, z, onClickListener, onClickListener2, onClickListener3, onClickListener4, onClickListener5);
        this.bAm = null;
        this.bAn = null;
        this.bAo = null;
        this.mNavigationBar = null;
        this.bro = null;
        this.bAn = (SubPbLoadPreviousView) this.bAq.findViewById(v.sub_pb_load_previous);
        this.mNavigationBar = (NavigationBar) this.Xi.findViewById(v.view_navigation_bar);
        this.bro = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bAm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getResources().getString(y.view_subject), onClickListener);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public boolean YS() {
        if (this.azA.isVisible()) {
            this.azA.Cc();
            this.azA.hide();
            this.bAw.setEnabled(true);
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
    protected void YT() {
        this.azA = (PbEditor) this.Xi.findViewById(v.sub_pb_editor);
        this.azA.au(true);
        this.azA.Cb();
        this.bAw.setEnabled(false);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void setOnActionListener(w wVar) {
        if (wVar != null) {
            this.azA.setOnActionListener(new k(this, wVar));
        }
    }

    public TextView YU() {
        return this.bAm;
    }

    private NavigationBar getNavigationBar() {
        this.mNavigationBar = (NavigationBar) this.Xi.findViewById(v.view_navigation_bar);
        return this.mNavigationBar;
    }

    private SubPbLoadPreviousView YV() {
        this.bAn = (SubPbLoadPreviousView) this.bAq.findViewById(v.sub_pb_load_previous);
        return this.bAn;
    }

    private View YW() {
        this.bAo = this.bAq.findViewById(v.sub_pb_load_previous_top);
        return this.bAo;
    }

    public void YX() {
        YV().XA();
        YW().setVisibility(0);
    }

    public void YY() {
        YV().YJ();
        YW().setVisibility(0);
    }

    public void YZ() {
        YV().hide();
        YW().setVisibility(8);
        this.bAq.setPadding(0, 0, 0, 0);
        ((h) this.bAr).eo(false);
    }

    public void Za() {
        YV().Ba();
        YV().setVisibility(0);
        this.bAq.setPadding(0, 0, 0, 0);
        ((h) this.bAr).eo(true);
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected void v(View.OnClickListener onClickListener) {
        this.bAr = new h(this.mActivity, onClickListener);
        this.bAr.u(this.bzK);
        this.vl.setAdapter((ListAdapter) this.bAr);
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getNavigationBar().onChangeSkinType(i);
        YV().changeSkinType(i);
        this.mActivity.getLayoutMode().h(YW());
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected void Ck() {
        this.Xi = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.new_sub_pb_reply_layout, null);
        this.bAq = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, com.baidu.tieba.w.new_sub_pb_reply_head, null);
        YV().setOnClickListener(this.aEF);
    }

    @Override // com.baidu.tieba.pb.sub.l
    protected int c(ar arVar) {
        if (arVar == null) {
            return 0;
        }
        int totalCount = arVar.getTotalCount() - (arVar.getCurrentPage() * arVar.Av());
        if (totalCount < 0) {
            totalCount = 0;
        }
        return totalCount;
    }

    @Override // com.baidu.tieba.pb.sub.l
    public void hc(String str) {
        h hVar;
        int gZ;
        if ((this.bAr instanceof h) && (gZ = (hVar = (h) this.bAr).gZ(str)) > -1) {
            this.vl.setSelection(gZ + 1);
            ak akVar = (ak) hVar.getItem(gZ);
            if (akVar != null) {
                String userName = akVar.getAuthor().getUserName();
                if (userName == null) {
                    userName = "";
                }
                this.azA.getEditText().setText(this.mActivity.getResources().getString(y.reply_sub_floor).replace("%s", userName));
                this.azA.getEditText().setSelection(this.azA.getEditText().getText().length());
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
