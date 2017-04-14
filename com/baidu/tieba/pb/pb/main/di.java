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
    private View elg;
    private com.baidu.tieba.pb.a elh;

    public di(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.elg = null;
        this.elh = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.gj
    protected void a(e eVar) {
        this.elg = this.mRootView.findViewById(w.h.pb_editor_tool_comment_graffiti_icon);
        aLu();
    }

    @Override // com.baidu.tieba.pb.pb.main.gj
    protected void onChangeSkinType(int i) {
        if (this.elh != null) {
            this.elh.changeSkinType(i);
        }
    }

    private void aLu() {
        CustomResponsedMessage runTask;
        if (this.bcy != null && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_QUICK_VOTE_VIEW, this.bcy.getPageContext().getPageActivity()), com.baidu.tieba.pb.a.class)) != null && runTask.getData() != null) {
            this.elh = (com.baidu.tieba.pb.a) runTask.getData();
            ViewGroup viewGroup = (ViewGroup) this.bcy.findViewById(w.h.pb_comment_container);
            if (this.elh != null && viewGroup != null) {
                viewGroup.addView(this.elh, 0, new LinearLayout.LayoutParams(-1, -2));
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.af afVar) {
        if (this.elh != null) {
            this.elh.a(afVar);
        }
    }

    public boolean aLv() {
        return this.elh != null && this.elh.getVisibility() == 0;
    }

    public void aLw() {
        if (this.elh != null && this.elg != null) {
            this.elh.aeD();
            this.elg.setSelected(true);
        }
    }

    public void aLx() {
        if (this.elh != null && this.elg != null) {
            this.elh.ahH();
            this.elg.setSelected(false);
        }
    }

    public View aLy() {
        return this.elg;
    }
}
