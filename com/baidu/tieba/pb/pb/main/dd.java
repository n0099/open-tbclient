package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class dd extends gf {
    private com.baidu.adp.lib.guide.d epb;
    private View epc;
    private com.baidu.tieba.pb.a epd;

    public dd(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.epc = null;
        this.epd = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.gf
    protected void a(e eVar) {
        this.epc = this.mRootView.findViewById(t.g.pb_editor_tool_comment_graffiti_icon);
        aNE();
    }

    @Override // com.baidu.tieba.pb.pb.main.gf
    protected void onChangeSkinType(int i) {
        if (this.epd != null) {
            this.epd.changeSkinType(i);
        }
    }

    private void aNE() {
        CustomResponsedMessage runTask;
        if (this.aPR != null && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_QUICK_VOTE_VIEW, this.aPR.getPageContext().getPageActivity()), com.baidu.tieba.pb.a.class)) != null && runTask.getData() != null) {
            this.epd = (com.baidu.tieba.pb.a) runTask.getData();
            ViewGroup viewGroup = (ViewGroup) this.aPR.findViewById(t.g.pb_comment_container);
            if (this.epd != null && viewGroup != null) {
                viewGroup.addView(this.epd, 0, new LinearLayout.LayoutParams(-1, -2));
            }
        }
    }

    public void aNF() {
        com.baidu.adp.lib.h.h.eG().postDelayed(new de(this), 50L);
    }

    public void CS() {
        if (this.epb != null) {
            this.epb.dismiss();
            this.epb = null;
        }
    }

    public void c(com.baidu.tbadk.core.data.ab abVar) {
        if (this.epd != null) {
            this.epd.b(abVar);
        }
    }

    public boolean aNG() {
        return this.epd != null && this.epd.getVisibility() == 0;
    }

    public void aNH() {
        if (this.epd != null && this.epc != null) {
            this.epd.afS();
            this.epc.setSelected(true);
        }
    }

    public void aNI() {
        if (this.epd != null && this.epc != null) {
            this.epd.akN();
            this.epc.setSelected(false);
        }
    }

    public View aNJ() {
        return this.epc;
    }
}
