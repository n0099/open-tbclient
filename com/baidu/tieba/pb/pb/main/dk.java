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
public class dk extends gl {
    private View emY;
    private com.baidu.tieba.pb.a emZ;

    public dk(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.emY = null;
        this.emZ = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.gl
    protected void a(e eVar) {
        this.emY = this.mRootView.findViewById(w.h.pb_editor_tool_comment_graffiti_icon);
        aLm();
    }

    @Override // com.baidu.tieba.pb.pb.main.gl
    protected void onChangeSkinType(int i) {
        if (this.emZ != null) {
            this.emZ.changeSkinType(i);
        }
    }

    private void aLm() {
        CustomResponsedMessage runTask;
        if (this.bcF != null && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_QUICK_VOTE_VIEW, this.bcF.getPageContext().getPageActivity()), com.baidu.tieba.pb.a.class)) != null && runTask.getData() != null) {
            this.emZ = (com.baidu.tieba.pb.a) runTask.getData();
            ViewGroup viewGroup = (ViewGroup) this.bcF.findViewById(w.h.pb_comment_container);
            if (this.emZ != null && viewGroup != null) {
                viewGroup.addView(this.emZ, 0, new LinearLayout.LayoutParams(-1, -2));
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.ag agVar) {
        if (this.emZ != null) {
            this.emZ.a(agVar);
        }
    }

    public boolean aLn() {
        return this.emZ != null && this.emZ.getVisibility() == 0;
    }

    public void aLo() {
        if (this.emZ != null && this.emY != null) {
            this.emZ.aeJ();
            this.emY.setSelected(true);
        }
    }

    public void aLp() {
        if (this.emZ != null && this.emY != null) {
            this.emZ.ahN();
            this.emY.setSelected(false);
        }
    }

    public View aLq() {
        return this.emY;
    }
}
