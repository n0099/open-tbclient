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
    private TbPageContext ajF;
    public TextView bXT;
    private int mSkinType = 3;
    private int bYi = 0;
    private boolean eum = true;
    private CustomMessageListener eun = new k(this, CmdConfigCustom.CMD_PB_VIDEO_PALY_ADD_COUNT);

    public j(TbPageContext tbPageContext, View view) {
        this.ajF = tbPageContext;
        this.bXT = (TextView) view.findViewById(w.h.pb_list_video_item_play_count);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        tbPageContext.registerListener(this.eun);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar != null) {
            this.bYi++;
            eVar.fw(this.bYi);
        }
    }

    public void d(com.baidu.tbadk.widget.richText.e eVar) {
        if (this.bXT != null && eVar != null) {
            if (eVar.IB() < this.bYi) {
                eVar.fw(this.bYi);
            } else {
                this.bYi = eVar.IB();
            }
            this.bXT.setText(au.t(this.bYi));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.bXT.setCompoundDrawablesWithIntrinsicBounds(w.g.icon_pb_video_num_gray, 0, 0, 0);
            this.bXT.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds12));
            aq.c(this.bXT, w.e.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }
}
