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
    private TbPageContext ajU;
    public TextView euH;
    private int mSkinType = 3;
    private int euI = 0;
    private boolean euJ = true;
    private CustomMessageListener euK = new k(this, CmdConfigCustom.CMD_PB_VIDEO_PALY_ADD_COUNT);

    public j(TbPageContext tbPageContext, View view) {
        this.ajU = tbPageContext;
        this.euH = (TextView) view.findViewById(w.h.pb_list_video_item_play_count);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        tbPageContext.registerListener(this.euK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar != null) {
            this.euI++;
            eVar.fz(this.euI);
        }
    }

    public void d(com.baidu.tbadk.widget.richText.e eVar) {
        if (this.euH != null && eVar != null) {
            if (eVar.Ja() < this.euI) {
                eVar.fz(this.euI);
            } else {
                this.euI = eVar.Ja();
            }
            this.euH.setText(au.t(this.euI));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.euH.setCompoundDrawablesWithIntrinsicBounds(w.g.icon_pb_video_num_gray, 0, 0, 0);
            this.euH.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.g(this.ajU.getPageActivity(), w.f.ds12));
            aq.c(this.euH, w.e.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }
}
