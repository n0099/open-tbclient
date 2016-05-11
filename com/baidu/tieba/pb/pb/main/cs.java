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
public class cs extends ft {
    private com.baidu.adp.lib.guide.d dkQ;
    private View dkR;
    private com.baidu.tieba.pb.a dkS;

    public cs(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.dkR = null;
        this.dkS = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.ft
    protected void a(e eVar) {
        this.dkR = this.mRootView.findViewById(t.g.pb_editor_tool_comment_graffiti_icon);
        axr();
    }

    @Override // com.baidu.tieba.pb.pb.main.ft
    protected void onChangeSkinType(int i) {
        if (this.dkS != null) {
            this.dkS.changeSkinType(i);
        }
    }

    private void axr() {
        CustomResponsedMessage runTask;
        if (this.bek != null && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_QUICK_VOTE_VIEW, this.bek.getPageContext().getPageActivity()), com.baidu.tieba.pb.a.class)) != null && runTask.getData() != null) {
            this.dkS = (com.baidu.tieba.pb.a) runTask.getData();
            ViewGroup viewGroup = (ViewGroup) this.bek.findViewById(t.g.pb_comment_container);
            if (this.dkS != null && viewGroup != null) {
                viewGroup.addView(this.dkS, 0, new LinearLayout.LayoutParams(-1, -2));
            }
        }
    }

    public void axs() {
        com.baidu.adp.lib.h.h.dL().postDelayed(new ct(this), 50L);
    }

    public void Bn() {
        if (this.dkQ != null) {
            this.dkQ.dismiss();
            this.dkQ = null;
        }
    }

    public void b(com.baidu.tbadk.core.data.v vVar) {
        if (this.dkS != null) {
            this.dkS.a(vVar);
        }
    }

    public boolean axt() {
        return this.dkS != null && this.dkS.getVisibility() == 0;
    }

    public void axu() {
        if (this.dkS != null && this.dkR != null) {
            this.dkS.Uq();
            this.dkR.setSelected(true);
        }
    }

    public void axv() {
        if (this.dkS != null && this.dkR != null) {
            this.dkS.YZ();
            this.dkR.setSelected(false);
        }
    }

    public View axw() {
        return this.dkR;
    }
}
