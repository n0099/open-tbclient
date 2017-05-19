package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class j {
    private TbPageContext ajr;
    public TextView eqk;
    private int mSkinType = 3;
    private int eql = 0;
    private boolean eqm = true;
    private CustomMessageListener eqn = new k(this, CmdConfigCustom.CMD_PB_VIDEO_PALY_ADD_COUNT);

    public j(TbPageContext tbPageContext, View view) {
        this.ajr = tbPageContext;
        this.eqk = (TextView) view.findViewById(w.h.pb_list_video_item_play_count);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        tbPageContext.registerListener(this.eqn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar != null) {
            this.eql++;
            eVar.fw(this.eql);
        }
    }

    public void d(com.baidu.tbadk.widget.richText.e eVar) {
        if (this.eqk != null && eVar != null) {
            if (eVar.Io() < this.eql) {
                eVar.fw(this.eql);
            } else {
                this.eql = eVar.Io();
            }
            this.eqk.setText(au.t(this.eql));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.eqk.setCompoundDrawablesWithIntrinsicBounds(w.g.icon_pb_video_num_gray, 0, 0, 0);
            this.eqk.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds12));
            aq.c(this.eqk, w.e.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }
}
