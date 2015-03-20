package com.baidu.tieba.pb.pb.sub;

import android.os.Handler;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class i extends l {
    private TextView bNF;
    private SubPbLoadPreviousView bNG;
    private View bNH;
    protected View bNI;
    private NavigationBar mNavigationBar;

    public i(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        super(baseActivity, z, onClickListener, onClickListener2, onClickListener3, onClickListener4, onClickListener5);
        this.bNF = null;
        this.bNG = null;
        this.bNH = null;
        this.mNavigationBar = null;
        this.bNI = null;
        this.bNG = (SubPbLoadPreviousView) this.bNK.findViewById(com.baidu.tieba.v.sub_pb_load_previous);
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.bNI = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bNF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getResources().getString(y.view_subject), onClickListener);
    }

    @Override // com.baidu.tieba.pb.pb.sub.l
    public boolean abZ() {
        if (this.aIy.isVisible()) {
            this.aIy.alS();
            this.aIy.hide();
        } else {
            this.mActivity.finish();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.pb.pb.sub.l
    public void b(int i, View view) {
        new Handler().postDelayed(new j(this, i, view), 300L);
    }

    @Override // com.baidu.tieba.pb.pb.sub.l
    protected void aca() {
        this.aIy = (PbEditor) this.rootView.findViewById(com.baidu.tieba.v.sub_pb_editor);
        this.aIy.aQ(true);
        this.aIy.alR();
    }

    @Override // com.baidu.tieba.pb.pb.sub.l
    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        if (vVar != null) {
            this.aIy.a(this.mActivity.getPageContext(), new k(this, vVar));
        }
    }

    public TextView acb() {
        return this.bNF;
    }

    private NavigationBar getNavigationBar() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(com.baidu.tieba.v.view_navigation_bar);
        return this.mNavigationBar;
    }

    private SubPbLoadPreviousView acc() {
        this.bNG = (SubPbLoadPreviousView) this.bNK.findViewById(com.baidu.tieba.v.sub_pb_load_previous);
        return this.bNG;
    }

    private View acd() {
        this.bNH = this.bNK.findViewById(com.baidu.tieba.v.sub_pb_load_previous_top);
        return this.bNH;
    }

    public void ace() {
        acc().aaK();
        acd().setVisibility(0);
    }

    public void acf() {
        acc().abO();
        acd().setVisibility(0);
    }

    public void acg() {
        acc().hide();
        acd().setVisibility(8);
        this.bNK.setPadding(0, 0, 0, 0);
        ((h) this.bNL).ec(false);
    }

    public void ach() {
        acc().BZ();
        acc().setVisibility(0);
        this.bNK.setPadding(0, 0, 0, 0);
        ((h) this.bNL).ec(true);
    }

    @Override // com.baidu.tieba.pb.pb.sub.l
    protected void x(View.OnClickListener onClickListener) {
        this.bNL = new h(this.mActivity.getPageContext().getPageActivity(), onClickListener);
        this.bNL.w(this.bMZ);
        this.mListView.setAdapter((ListAdapter) this.bNL);
    }

    @Override // com.baidu.tieba.pb.pb.sub.l
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getNavigationBar().onChangeSkinType(this.mActivity.getPageContext(), i);
        acc().changeSkinType(i);
        this.mActivity.getLayoutMode().h(acd());
    }

    @Override // com.baidu.tieba.pb.pb.sub.l
    protected void aci() {
        this.rootView = com.baidu.adp.lib.g.b.hH().inflate(this.mActivity.getPageContext().getPageActivity(), w.new_sub_pb_reply_layout, null);
        this.bNK = com.baidu.adp.lib.g.b.hH().inflate(this.mActivity.getPageContext().getPageActivity(), w.new_sub_pb_reply_head, null);
        acc().setOnClickListener(this.aMP);
    }

    @Override // com.baidu.tieba.pb.pb.sub.l
    protected int c(com.baidu.tieba.pb.a.c cVar) {
        if (cVar == null) {
            return 0;
        }
        int totalCount = cVar.getTotalCount() - (cVar.getCurrentPage() * cVar.Za());
        if (totalCount < 0) {
            totalCount = 0;
        }
        return totalCount;
    }

    @Override // com.baidu.tieba.pb.pb.sub.l
    public void hP(String str) {
        h hVar;
        int hM;
        if ((this.bNL instanceof h) && (hM = (hVar = (h) this.bNL).hM(str)) > -1) {
            this.mListView.setSelection(hM + 1);
            com.baidu.tieba.tbadkCore.c.j jVar = (com.baidu.tieba.tbadkCore.c.j) hVar.getItem(hM);
            if (jVar != null) {
                String userName = jVar.getAuthor().getUserName();
                if (userName == null) {
                    userName = "";
                }
                this.aIy.getEditText().setText(this.mActivity.getResources().getString(y.reply_sub_floor).replace("%s", userName));
                this.aIy.getEditText().setSelection(this.aIy.getEditText().getText().length());
            }
            if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
                hVar.P(str, this.mActivity.getResources().getColor(com.baidu.tieba.s.c_393d47));
            } else {
                hVar.P(str, this.mActivity.getResources().getColor(com.baidu.tieba.s.c_fdfdf1));
            }
            this.mListView.invalidate();
        }
    }
}
