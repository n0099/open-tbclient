package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class di extends gj {
    private View eny;
    private com.baidu.tieba.pb.a enz;

    public di(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.eny = null;
        this.enz = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.gj
    protected void a(e eVar) {
        this.eny = this.mRootView.findViewById(w.h.pb_editor_tool_comment_graffiti_icon);
        aMv();
    }

    @Override // com.baidu.tieba.pb.pb.main.gj
    protected void onChangeSkinType(int i) {
        if (this.enz != null) {
            this.enz.changeSkinType(i);
        }
    }

    private void aMv() {
        CustomResponsedMessage runTask;
        if (this.bdG != null && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_QUICK_VOTE_VIEW, this.bdG.getPageContext().getPageActivity()), com.baidu.tieba.pb.a.class)) != null && runTask.getData() != null) {
            this.enz = (com.baidu.tieba.pb.a) runTask.getData();
            ViewGroup viewGroup = (ViewGroup) this.bdG.findViewById(w.h.pb_comment_container);
            if (this.enz != null && viewGroup != null) {
                viewGroup.addView(this.enz, 0, new LinearLayout.LayoutParams(-1, -2));
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.af afVar) {
        if (this.enz != null) {
            this.enz.a(afVar);
        }
    }

    public boolean aMw() {
        return this.enz != null && this.enz.getVisibility() == 0;
    }

    public void aMx() {
        if (this.enz != null && this.eny != null) {
            this.enz.afE();
            this.eny.setSelected(true);
        }
    }

    public void aMy() {
        if (this.enz != null && this.eny != null) {
            this.enz.aiI();
            this.eny.setSelected(false);
        }
    }

    public View aMz() {
        return this.eny;
    }
}
