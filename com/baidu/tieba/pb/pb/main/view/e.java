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
    public TextView eWy;
    private TbPageContext oV;
    private int mSkinType = 3;
    private int eWz = 0;
    private boolean eWA = true;
    private CustomMessageListener eWB = new CustomMessageListener(CmdConfigCustom.CMD_PB_VIDEO_PALY_ADD_COUNT) { // from class: com.baidu.tieba.pb.pb.main.view.e.1
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
        this.oV = tbPageContext;
        this.eWy = (TextView) view.findViewById(d.h.pb_list_video_item_play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        tbPageContext.registerListener(this.eWB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tbadk.widget.richText.e eVar) {
        if (eVar != null) {
            this.eWz++;
            eVar.fE(this.eWz);
        }
    }

    public void d(com.baidu.tbadk.widget.richText.e eVar) {
        if (this.eWy != null && eVar != null) {
            if (eVar.Ja() < this.eWz) {
                eVar.fE(this.eWz);
            } else {
                this.eWz = eVar.Ja();
            }
            this.eWy.setText(al.u(this.eWz));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.eWy.setCompoundDrawablesWithIntrinsicBounds(d.g.icon_pb_video_num_gray, 0, 0, 0);
            this.eWy.setCompoundDrawablePadding(k.g(this.oV.getPageActivity(), d.f.ds12));
            ai.c(this.eWy, d.e.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }
}
