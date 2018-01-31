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
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class d {
    public TextView fVX;
    private TbPageContext mPageContext;
    private int mSkinType = 3;
    private int fVY = 0;
    private CustomMessageListener fVZ = new CustomMessageListener(CmdConfigCustom.CMD_PB_VIDEO_PALY_ADD_COUNT) { // from class: com.baidu.tieba.pb.pb.main.view.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f)) {
                f fVar = (f) customResponsedMessage.getData();
                d.this.c(fVar);
                d.this.d(fVar);
            }
        }
    };

    public d(TbPageContext tbPageContext, View view) {
        this.mPageContext = tbPageContext;
        this.fVX = (TextView) view.findViewById(d.g.pb_list_video_item_play_count);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        tbPageContext.registerListener(this.fVZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        if (fVar != null) {
            this.fVY++;
            fVar.jc(this.fVY);
        }
    }

    public void d(f fVar) {
        if (this.fVX != null && fVar != null) {
            if (fVar.Rs() < this.fVY) {
                fVar.jc(this.fVY);
            } else {
                this.fVY = fVar.Rs();
            }
            this.fVX.setText(am.C(this.fVY));
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.fVX.setCompoundDrawablesWithIntrinsicBounds(d.f.icon_pb_video_num_gray, 0, 0, 0);
            this.fVX.setCompoundDrawablePadding(l.s(this.mPageContext.getPageActivity(), d.e.ds12));
            aj.e(this.fVX, d.C0108d.cp_cont_c, 1);
        }
        this.mSkinType = i;
    }
}
