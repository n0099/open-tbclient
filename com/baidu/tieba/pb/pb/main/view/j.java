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
    private TbPageContext ajT;
    public TextView esp;
    private int mSkinType = 3;
    private int esq = 0;
    private boolean esr = true;
    private CustomMessageListener ess = new k(this, CmdConfigCustom.CMD_PB_VIDEO_PALY_ADD_COUNT);

    public j(TbPageContext tbPageContext, View view) {
        this.ajT = tbPageContext;
        this.esp = (TextView) view.findViewById(w.h.pb_list_video_item_play_count);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        tbPageContext.registerListener(this.ess);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar != null) {
            this.esq++;
            eVar.fz(this.esq);
        }
    }

    public void d(com.baidu.tbadk.widget.richText.e eVar) {
        if (this.esp != null && eVar != null) {
            if (eVar.Ja() < this.esq) {
                eVar.fz(this.esq);
            } else {
                this.esq = eVar.Ja();
            }
            this.esp.setText(au.t(this.esq));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.esp.setCompoundDrawablesWithIntrinsicBounds(w.g.icon_pb_video_num_gray, 0, 0, 0);
            this.esp.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds12));
            aq.c(this.esp, w.e.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }
}
