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
public class dc extends ga {
    private com.baidu.adp.lib.guide.d dQH;
    private View dQI;
    private com.baidu.tieba.pb.a dQJ;

    public dc(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.dQI = null;
        this.dQJ = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ga
    protected void a(e eVar) {
        this.dQI = this.mRootView.findViewById(u.g.pb_editor_tool_comment_graffiti_icon);
        aFC();
    }

    @Override // com.baidu.tieba.pb.pb.main.ga
    protected void onChangeSkinType(int i) {
        if (this.dQJ != null) {
            this.dQJ.changeSkinType(i);
        }
    }

    private void aFC() {
        CustomResponsedMessage runTask;
        if (this.bkc != null && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_QUICK_VOTE_VIEW, this.bkc.getPageContext().getPageActivity()), com.baidu.tieba.pb.a.class)) != null && runTask.getData() != null) {
            this.dQJ = (com.baidu.tieba.pb.a) runTask.getData();
            ViewGroup viewGroup = (ViewGroup) this.bkc.findViewById(u.g.pb_comment_container);
            if (this.dQJ != null && viewGroup != null) {
                viewGroup.addView(this.dQJ, 0, new LinearLayout.LayoutParams(-1, -2));
            }
        }
    }

    public void aFD() {
        com.baidu.adp.lib.h.h.dM().postDelayed(new dd(this), 50L);
    }

    public void Bx() {
        if (this.dQH != null) {
            this.dQH.dismiss();
            this.dQH = null;
        }
    }

    public void c(com.baidu.tbadk.core.data.x xVar) {
        if (this.dQJ != null) {
            this.dQJ.b(xVar);
        }
    }

    public boolean aFE() {
        return this.dQJ != null && this.dQJ.getVisibility() == 0;
    }

    public void aFF() {
        if (this.dQJ != null && this.dQI != null) {
            this.dQJ.aaF();
            this.dQI.setSelected(true);
        }
    }

    public void aFG() {
        if (this.dQJ != null && this.dQI != null) {
            this.dQJ.afz();
            this.dQI.setSelected(false);
        }
    }

    public View aFH() {
        return this.dQI;
    }
}
