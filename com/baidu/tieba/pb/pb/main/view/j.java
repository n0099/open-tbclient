package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class j {
    private TbPageContext FY;
    public TextView bQL;
    private int mSkinType = 3;
    private int bRa = 0;
    private boolean eqY = true;
    private CustomMessageListener eqZ = new k(this, CmdConfigCustom.CMD_PB_VIDEO_PALY_ADD_COUNT);

    public j(TbPageContext tbPageContext, View view) {
        this.FY = tbPageContext;
        this.bQL = (TextView) view.findViewById(r.h.pb_list_video_item_play_count);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        tbPageContext.registerListener(this.eqZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar != null) {
            this.bRa++;
            eVar.fC(this.bRa);
        }
    }

    public void d(com.baidu.tbadk.widget.richText.e eVar) {
        if (this.bQL != null && eVar != null) {
            if (eVar.Ib() < this.bRa) {
                eVar.fC(this.bRa);
            } else {
                this.bRa = eVar.Ib();
            }
            this.bQL.setText(at.u(this.bRa));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.bQL.setCompoundDrawablesWithIntrinsicBounds(r.g.icon_pb_video_num_gray, 0, 0, 0);
            this.bQL.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds12));
            ap.c(this.bQL, r.e.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }
}
