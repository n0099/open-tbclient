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
public class df extends gi {
    private com.baidu.adp.lib.guide.d ewQ;
    private View ewR;
    private com.baidu.tieba.pb.a ewS;
    private long ewT;

    public df(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.ewR = null;
        this.ewS = null;
        this.ewT = 50L;
    }

    @Override // com.baidu.tieba.pb.pb.main.gi
    protected void a(e eVar) {
        this.ewR = this.mRootView.findViewById(r.g.pb_editor_tool_comment_graffiti_icon);
        aQf();
    }

    @Override // com.baidu.tieba.pb.pb.main.gi
    protected void onChangeSkinType(int i) {
        if (this.ewS != null) {
            this.ewS.changeSkinType(i);
        }
    }

    private void aQf() {
        CustomResponsedMessage runTask;
        if (this.aTb != null && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_QUICK_VOTE_VIEW, this.aTb.getPageContext().getPageActivity()), com.baidu.tieba.pb.a.class)) != null && runTask.getData() != null) {
            this.ewS = (com.baidu.tieba.pb.a) runTask.getData();
            ViewGroup viewGroup = (ViewGroup) this.aTb.findViewById(r.g.pb_comment_container);
            if (this.ewS != null && viewGroup != null) {
                viewGroup.addView(this.ewS, 0, new LinearLayout.LayoutParams(-1, -2));
            }
        }
    }

    public void aQg() {
        com.baidu.adp.lib.h.h.eG().postDelayed(new dg(this), this.ewT);
    }

    public void Da() {
        if (this.ewQ != null) {
            this.ewQ.dismiss();
            this.ewQ = null;
        }
    }

    public void cC(long j) {
        this.ewT = j;
    }

    public void c(com.baidu.tbadk.core.data.af afVar) {
        if (this.ewS != null) {
            this.ewS.b(afVar);
        }
    }

    public boolean aQh() {
        return this.ewS != null && this.ewS.getVisibility() == 0;
    }

    public void aQi() {
        if (this.ewS != null && this.ewR != null) {
            this.ewS.aib();
            this.ewR.setSelected(true);
        }
    }

    public void aQj() {
        if (this.ewS != null && this.ewR != null) {
            this.ewS.amW();
            this.ewR.setSelected(false);
        }
    }

    public View aQk() {
        return this.ewR;
    }
}
