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
public class l {
    private TbPageContext ajh;
    public TextView exu;
    private int mSkinType = 3;
    private int exv = 0;
    private boolean exw = true;
    private CustomMessageListener exx = new m(this, CmdConfigCustom.CMD_PB_VIDEO_PALY_ADD_COUNT);

    public l(TbPageContext tbPageContext, View view) {
        this.ajh = tbPageContext;
        this.exu = (TextView) view.findViewById(w.h.pb_list_video_item_play_count);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        tbPageContext.registerListener(this.exx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar != null) {
            this.exv++;
            eVar.fx(this.exv);
        }
    }

    public void d(com.baidu.tbadk.widget.richText.e eVar) {
        if (this.exu != null && eVar != null) {
            if (eVar.Ij() < this.exv) {
                eVar.fx(this.exv);
            } else {
                this.exv = eVar.Ij();
            }
            this.exu.setText(au.t(this.exv));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.exu.setCompoundDrawablesWithIntrinsicBounds(w.g.icon_pb_video_num_gray, 0, 0, 0);
            this.exu.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.g(this.ajh.getPageActivity(), w.f.ds12));
            aq.c(this.exu, w.e.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }
}
