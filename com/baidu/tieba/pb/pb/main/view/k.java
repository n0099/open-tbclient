package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.richText.n;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class k {
    private TbPageContext GO;
    public TextView bKs;
    private com.baidu.tieba.pb.data.f dXl;
    private int mSkinType = 3;
    private int bKH = 0;
    private boolean dXr = true;
    private CustomMessageListener ehP = new l(this, CmdConfigCustom.CMD_PB_VIDEO_PALY_ADD_COUNT);

    public k(TbPageContext tbPageContext, View view) {
        this.GO = tbPageContext;
        this.bKs = (TextView) view.findViewById(r.g.pb_list_video_item_play_count);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        tbPageContext.registerListener(this.ehP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(n nVar) {
        if (nVar != null) {
            this.bKH++;
            nVar.fB(this.bKH);
        }
    }

    public void d(n nVar) {
        if (this.bKs != null && nVar != null) {
            if (nVar.Ij() < this.bKH) {
                nVar.fB(this.bKH);
            } else {
                this.bKH = nVar.Ij();
            }
            this.bKs.setText(av.v(this.bKH));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.bKs.setCompoundDrawablesWithIntrinsicBounds(r.f.icon_pb_video_num_gray, 0, 0, 0);
            this.bKs.setCompoundDrawablePadding(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds12));
            ar.c(this.bKs, r.d.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }

    public void b(com.baidu.tieba.pb.data.f fVar) {
        this.dXl = fVar;
    }
}
