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
public class dj extends gl {
    private View ekc;
    private com.baidu.tieba.pb.a ekd;

    public dj(BaseActivity baseActivity, View view) {
        super(baseActivity, view);
        this.ekc = null;
        this.ekd = null;
    }

    @Override // com.baidu.tieba.pb.pb.main.gl
    protected void a(e eVar) {
        this.ekc = this.mRootView.findViewById(r.h.pb_editor_tool_comment_graffiti_icon);
        aLQ();
    }

    @Override // com.baidu.tieba.pb.pb.main.gl
    protected void onChangeSkinType(int i) {
        if (this.ekd != null) {
            this.ekd.changeSkinType(i);
        }
    }

    private void aLQ() {
        CustomResponsedMessage runTask;
        if (this.aWr != null && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GRAFFITI_QUICK_VOTE_VIEW, this.aWr.getPageContext().getPageActivity()), com.baidu.tieba.pb.a.class)) != null && runTask.getData() != null) {
            this.ekd = (com.baidu.tieba.pb.a) runTask.getData();
            ViewGroup viewGroup = (ViewGroup) this.aWr.findViewById(r.h.pb_comment_container);
            if (this.ekd != null && viewGroup != null) {
                viewGroup.addView(this.ekd, 0, new LinearLayout.LayoutParams(-1, -2));
            }
        }
    }

    public void b(com.baidu.tbadk.core.data.af afVar) {
        if (this.ekd != null) {
            this.ekd.a(afVar);
        }
    }

    public boolean aLR() {
        return this.ekd != null && this.ekd.getVisibility() == 0;
    }

    public void aLS() {
        if (this.ekd != null && this.ekc != null) {
            this.ekd.adJ();
            this.ekc.setSelected(true);
        }
    }

    public void aLT() {
        if (this.ekd != null && this.ekc != null) {
            this.ekd.aiB();
            this.ekc.setSelected(false);
        }
    }

    public View aLU() {
        return this.ekc;
    }
}
