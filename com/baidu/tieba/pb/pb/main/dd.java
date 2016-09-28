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
public class dd extends gf {
    private com.baidu.adp.lib.guide.d eqZ;
    private View era;
    private com.baidu.tieba.pb.a erb;

    public dd(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.era = null;
        this.erb = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.gf
    protected void a(e eVar) {
        this.era = this.mRootView.findViewById(r.g.pb_editor_tool_comment_graffiti_icon);
        aOm();
    }

    @Override // com.baidu.tieba.pb.pb.main.gf
    protected void onChangeSkinType(int i) {
        if (this.erb != null) {
            this.erb.changeSkinType(i);
        }
    }

    private void aOm() {
        CustomResponsedMessage runTask;
        if (this.aRd != null && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_QUICK_VOTE_VIEW, this.aRd.getPageContext().getPageActivity()), com.baidu.tieba.pb.a.class)) != null && runTask.getData() != null) {
            this.erb = (com.baidu.tieba.pb.a) runTask.getData();
            ViewGroup viewGroup = (ViewGroup) this.aRd.findViewById(r.g.pb_comment_container);
            if (this.erb != null && viewGroup != null) {
                viewGroup.addView(this.erb, 0, new LinearLayout.LayoutParams(-1, -2));
            }
        }
    }

    public void aOn() {
        com.baidu.adp.lib.h.h.eG().postDelayed(new de(this), 50L);
    }

    public void CS() {
        if (this.eqZ != null) {
            this.eqZ.dismiss();
            this.eqZ = null;
        }
    }

    public void c(com.baidu.tbadk.core.data.ad adVar) {
        if (this.erb != null) {
            this.erb.b(adVar);
        }
    }

    public boolean aOo() {
        return this.erb != null && this.erb.getVisibility() == 0;
    }

    public void aOp() {
        if (this.erb != null && this.era != null) {
            this.erb.agg();
            this.era.setSelected(true);
        }
    }

    public void aOq() {
        if (this.erb != null && this.era != null) {
            this.erb.alb();
            this.era.setSelected(false);
        }
    }

    public View aOr() {
        return this.era;
    }
}
