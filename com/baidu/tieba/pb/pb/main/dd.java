package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class dd extends ge {
    private com.baidu.adp.lib.guide.d ecW;
    private View ecX;
    private com.baidu.tieba.pb.a ecY;

    public dd(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.ecX = null;
        this.ecY = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ge
    protected void a(e eVar) {
        this.ecX = this.mRootView.findViewById(u.g.pb_editor_tool_comment_graffiti_icon);
        aIN();
    }

    @Override // com.baidu.tieba.pb.pb.main.ge
    protected void onChangeSkinType(int i) {
        if (this.ecY != null) {
            this.ecY.changeSkinType(i);
        }
    }

    private void aIN() {
        CustomResponsedMessage runTask;
        if (this.bem != null && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_QUICK_VOTE_VIEW, this.bem.getPageContext().getPageActivity()), com.baidu.tieba.pb.a.class)) != null && runTask.getData() != null) {
            this.ecY = (com.baidu.tieba.pb.a) runTask.getData();
            ViewGroup viewGroup = (ViewGroup) this.bem.findViewById(u.g.pb_comment_container);
            if (this.ecY != null && viewGroup != null) {
                viewGroup.addView(this.ecY, 0, new LinearLayout.LayoutParams(-1, -2));
            }
        }
    }

    public void aIO() {
        com.baidu.adp.lib.h.h.dL().postDelayed(new de(this), 50L);
    }

    public void Bx() {
        if (this.ecW != null) {
            this.ecW.dismiss();
            this.ecW = null;
        }
    }

    public void c(com.baidu.tbadk.core.data.aa aaVar) {
        if (this.ecY != null) {
            this.ecY.b(aaVar);
        }
    }

    public boolean aIP() {
        return this.ecY != null && this.ecY.getVisibility() == 0;
    }

    public void aIQ() {
        if (this.ecY != null && this.ecX != null) {
            this.ecY.abh();
            this.ecX.setSelected(true);
        }
    }

    public void aIR() {
        if (this.ecY != null && this.ecX != null) {
            this.ecY.agc();
            this.ecX.setSelected(false);
        }
    }

    public View aIS() {
        return this.ecX;
    }
}
