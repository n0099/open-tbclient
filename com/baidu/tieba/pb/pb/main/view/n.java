package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class n {
    private TbPageContext ajP;
    public TextView eGS;
    private int mSkinType = 3;
    private int eGT = 0;
    private boolean eGU = true;
    private CustomMessageListener eGV = new o(this, CmdConfigCustom.CMD_PB_VIDEO_PALY_ADD_COUNT);

    public n(TbPageContext tbPageContext, View view) {
        this.ajP = tbPageContext;
        this.eGS = (TextView) view.findViewById(w.h.pb_list_video_item_play_count);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        tbPageContext.registerListener(this.eGV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar != null) {
            this.eGT++;
            eVar.fz(this.eGT);
        }
    }

    public void d(com.baidu.tbadk.widget.richText.e eVar) {
        if (this.eGS != null && eVar != null) {
            if (eVar.IH() < this.eGT) {
                eVar.fz(this.eGT);
            } else {
                this.eGT = eVar.IH();
            }
            this.eGS.setText(aw.t(this.eGT));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.eGS.setCompoundDrawablesWithIntrinsicBounds(w.g.icon_pb_video_num_gray, 0, 0, 0);
            this.eGS.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds12));
            as.c(this.eGS, w.e.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }
}
