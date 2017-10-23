package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.richText.e;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class d {
    public TextView ePW;
    private TbPageContext mH;
    private int mSkinType = 3;
    private int ePX = 0;
    private CustomMessageListener ePY = new CustomMessageListener(CmdConfigCustom.CMD_PB_VIDEO_PALY_ADD_COUNT) { // from class: com.baidu.tieba.pb.pb.main.view.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                e eVar = (e) customResponsedMessage.getData();
                d.this.c(eVar);
                d.this.d(eVar);
            }
        }
    };

    public d(TbPageContext tbPageContext, View view) {
        this.mH = tbPageContext;
        this.ePW = (TextView) view.findViewById(d.h.pb_list_video_item_play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        tbPageContext.registerListener(this.ePY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e eVar) {
        if (eVar != null) {
            this.ePX++;
            eVar.fR(this.ePX);
        }
    }

    public void d(e eVar) {
        if (this.ePW != null && eVar != null) {
            if (eVar.Jl() < this.ePX) {
                eVar.fR(this.ePX);
            } else {
                this.ePX = eVar.Jl();
            }
            this.ePW.setText(am.u(this.ePX));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.ePW.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_pb_video_num_gray, 0, 0, 0);
            this.ePW.setCompoundDrawablePadding(l.f(this.mH.getPageActivity(), d.f.ds12));
            aj.c(this.ePW, d.e.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }
}
