package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.richText.o;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class k {
    private TbPageContext GO;
    public TextView ceJ;
    private com.baidu.tieba.pb.data.h esP;
    private int mSkinType = 3;
    private int ceY = 0;
    private boolean esV = true;
    private CustomMessageListener eDP = new l(this, CmdConfigCustom.CMD_PB_VIDEO_PALY_ADD_COUNT);

    public k(TbPageContext tbPageContext, View view) {
        this.GO = tbPageContext;
        this.ceJ = (TextView) view.findViewById(r.g.pb_list_video_item_play_count);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        tbPageContext.registerListener(this.eDP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(o oVar) {
        if (oVar != null) {
            this.ceY++;
            oVar.fC(this.ceY);
        }
    }

    public void d(o oVar) {
        if (this.ceJ != null && oVar != null) {
            if (oVar.IO() < this.ceY) {
                oVar.fC(this.ceY);
            } else {
                this.ceY = oVar.IO();
            }
            this.ceJ.setText(ax.v(this.ceY));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.ceJ.setCompoundDrawablesWithIntrinsicBounds(r.f.icon_pb_video_num_gray, 0, 0, 0);
            this.ceJ.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds12));
            at.c(this.ceJ, r.d.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    public void b(com.baidu.tieba.pb.data.h hVar) {
        this.esP = hVar;
    }
}
