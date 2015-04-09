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
    private TextView bNV;
    private SubPbLoadPreviousView bNW;
    private View bNX;
    protected View bNY;
    private NavigationBar mNavigationBar;

    public i(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        super(baseActivity, z, onClickListener, onClickListener2, onClickListener3, onClickListener4, onClickListener5);
        this.bNV = null;
        this.bNW = null;
        this.bNX = null;
        this.mNavigationBar = null;
        this.bNY = null;
        this.bNW = (SubPbLoadPreviousView) this.bOa.findViewById(com.baidu.tieba.v.sub_pb_load_previous);
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.bNY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bNV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, baseActivity.getResources().getString(y.view_subject), onClickListener);
    }

    @Override // com.baidu.tieba.pb.pb.sub.l
    public boolean aco() {
        if (this.aIG.isVisible()) {
            this.aIG.amh();
            this.aIG.hide();
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
    protected void acp() {
        this.aIG = (PbEditor) this.rootView.findViewById(com.baidu.tieba.v.sub_pb_editor);
        this.aIG.aQ(true);
        this.aIG.amg();
    }

    @Override // com.baidu.tieba.pb.pb.sub.l
    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        if (vVar != null) {
            this.aIG.a(this.mActivity.getPageContext(), new k(this, vVar));
        }
    }

    public TextView acq() {
        return this.bNV;
    }

    private NavigationBar getNavigationBar() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(com.baidu.tieba.v.view_navigation_bar);
        return this.mNavigationBar;
    }

    private SubPbLoadPreviousView acr() {
        this.bNW = (SubPbLoadPreviousView) this.bOa.findViewById(com.baidu.tieba.v.sub_pb_load_previous);
        return this.bNW;
    }

    private View acs() {
        this.bNX = this.bOa.findViewById(com.baidu.tieba.v.sub_pb_load_previous_top);
        return this.bNX;
    }

    public void act() {
        acr().aaX();
        acs().setVisibility(0);
    }

    public void acu() {
        acr().acd();
        acs().setVisibility(0);
    }

    public void acv() {
        acr().hide();
        acs().setVisibility(8);
        this.bOa.setPadding(0, 0, 0, 0);
        ((h) this.bOb).ea(false);
    }

    public void acw() {
        acr().Cf();
        acr().setVisibility(0);
        this.bOa.setPadding(0, 0, 0, 0);
        ((h) this.bOb).ea(true);
    }

    @Override // com.baidu.tieba.pb.pb.sub.l
    protected void y(View.OnClickListener onClickListener) {
        this.bOb = new h(this.mActivity.getPageContext().getPageActivity(), onClickListener);
        this.bOb.x(this.bNp);
        this.mListView.setAdapter((ListAdapter) this.bOb);
    }

    @Override // com.baidu.tieba.pb.pb.sub.l
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getNavigationBar().onChangeSkinType(this.mActivity.getPageContext(), i);
        acr().changeSkinType(i);
        this.mActivity.getLayoutMode().h(acs());
    }

    @Override // com.baidu.tieba.pb.pb.sub.l
    protected void acx() {
        this.rootView = com.baidu.adp.lib.g.b.hH().inflate(this.mActivity.getPageContext().getPageActivity(), w.new_sub_pb_reply_layout, null);
        this.bOa = com.baidu.adp.lib.g.b.hH().inflate(this.mActivity.getPageContext().getPageActivity(), w.new_sub_pb_reply_head, null);
        acr().setOnClickListener(this.aNa);
    }

    @Override // com.baidu.tieba.pb.pb.sub.l
    protected int c(com.baidu.tieba.pb.a.c cVar) {
        if (cVar == null) {
            return 0;
        }
        int totalCount = cVar.getTotalCount() - (cVar.getCurrentPage() * cVar.Zn());
        if (totalCount < 0) {
            totalCount = 0;
        }
        return totalCount;
    }

    @Override // com.baidu.tieba.pb.pb.sub.l
    public void hS(String str) {
        h hVar;
        int hP;
        if ((this.bOb instanceof h) && (hP = (hVar = (h) this.bOb).hP(str)) > -1) {
            this.mListView.setSelection(hP + 1);
            com.baidu.tieba.tbadkCore.c.j jVar = (com.baidu.tieba.tbadkCore.c.j) hVar.getItem(hP);
            if (jVar != null) {
                String userName = jVar.getAuthor().getUserName();
                if (userName == null) {
                    userName = "";
                }
                this.aIG.getEditText().setText(this.mActivity.getResources().getString(y.reply_sub_floor).replace("%s", userName));
                this.aIG.getEditText().setSelection(this.aIG.getEditText().getText().length());
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
