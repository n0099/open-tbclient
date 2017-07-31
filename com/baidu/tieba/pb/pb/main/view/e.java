package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private TbPageContext alI;
    public TextView eUF;
    private int mSkinType = 3;
    private int eUG = 0;
    private boolean eUH = true;
    private CustomMessageListener eUI = new CustomMessageListener(CmdConfigCustom.CMD_PB_VIDEO_PALY_ADD_COUNT) { // from class: com.baidu.tieba.pb.pb.main.view.e.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.widget.richText.e)) {
                com.baidu.tbadk.widget.richText.e eVar = (com.baidu.tbadk.widget.richText.e) customResponsedMessage.getData();
                e.this.c(eVar);
                e.this.d(eVar);
            }
        }
    };

    public e(TbPageContext tbPageContext, View view) {
        this.alI = tbPageContext;
        this.eUF = (TextView) view.findViewById(d.h.pb_list_video_item_play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        tbPageContext.registerListener(this.eUI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar != null) {
            this.eUG++;
            eVar.fE(this.eUG);
        }
    }

    public void d(com.baidu.tbadk.widget.richText.e eVar) {
        if (this.eUF != null && eVar != null) {
            if (eVar.Ja() < this.eUG) {
                eVar.fE(this.eUG);
            } else {
                this.eUG = eVar.Ja();
            }
            this.eUF.setText(al.u(this.eUG));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.eUF.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_pb_video_num_gray, 0, 0, 0);
            this.eUF.setCompoundDrawablePadding(k.g(this.alI.getPageActivity(), d.f.ds12));
            ai.c(this.eUF, d.e.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }
}
