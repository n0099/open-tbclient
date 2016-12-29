package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class db extends gb {
    private View ebk;
    private com.baidu.tieba.pb.a ebl;

    public db(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.ebk = null;
        this.ebl = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.gb
    protected void a(e eVar) {
        this.ebk = this.mRootView.findViewById(r.g.pb_editor_tool_comment_graffiti_icon);
        aKd();
    }

    @Override // com.baidu.tieba.pb.pb.main.gb
    protected void onChangeSkinType(int i) {
        if (this.ebl != null) {
            this.ebl.changeSkinType(i);
        }
    }

    private void aKd() {
        CustomResponsedMessage runTask;
        if (this.aSs != null && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_QUICK_VOTE_VIEW, this.aSs.getPageContext().getPageActivity()), com.baidu.tieba.pb.a.class)) != null && runTask.getData() != null) {
            this.ebl = (com.baidu.tieba.pb.a) runTask.getData();
            ViewGroup viewGroup = (ViewGroup) this.aSs.findViewById(r.g.pb_comment_container);
            if (this.ebl != null && viewGroup != null) {
                viewGroup.addView(this.ebl, 0, new LinearLayout.LayoutParams(-1, -2));
            }
        }
    }

    public void c(com.baidu.tbadk.core.data.ae aeVar) {
        if (this.ebl != null) {
            this.ebl.b(aeVar);
        }
    }

    public boolean aKe() {
        return this.ebl != null && this.ebl.getVisibility() == 0;
    }

    public void aKf() {
        if (this.ebl != null && this.ebk != null) {
            this.ebl.acz();
            this.ebk.setSelected(true);
        }
    }

    public void aKg() {
        if (this.ebl != null && this.ebk != null) {
            this.ebl.ahw();
            this.ebk.setSelected(false);
        }
    }

    public View aKh() {
        return this.ebk;
    }
}
