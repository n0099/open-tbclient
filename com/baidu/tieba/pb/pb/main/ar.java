package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes2.dex */
public class ar extends com.baidu.tbadk.core.view.userLike.c {
    private String aWq;
    public boolean fEs;
    private int fEt;
    private int fEu;
    public boolean isBigV;
    private TbPageContext mPageContext;

    public ar(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.fEs = false;
        this.isBigV = false;
        this.fEt = 0;
        this.fEt = i;
        this.mPageContext = tbPageContext;
        if (this.fEt == 1) {
            super.setFromType("4");
        } else if (this.fEt == 3) {
            super.setFromType("5");
        } else {
            super.setFromType("0");
        }
    }

    public void setTid(String str) {
        this.aWq = str;
    }

    public void qM(int i) {
        this.fEu = i;
    }

    private int bdw() {
        String fromPageKey = UtilHelper.getFromPageKey(this.mPageContext);
        if (fromPageKey == null) {
            return 3;
        }
        if (fromPageKey.equals("a038")) {
            return 1;
        }
        if (fromPageKey.equals("a002")) {
            return 2;
        }
        if (fromPageKey.equals("a006")) {
            return 3;
        }
        if (fromPageKey.equals("a011")) {
            return 4;
        }
        if (fromPageKey.equals("a033")) {
            return 5;
        }
        if (fromPageKey.equals("a010")) {
            return 6;
        }
        return 7;
    }

    @Override // com.baidu.tbadk.core.view.userLike.c, android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 3;
        int i2 = 2;
        if (view != null && view.getAlpha() >= 0.4d) {
            String userId = this.azv != null ? this.azv.getUserId() : "";
            TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12408").r(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, bdw()).ae(VideoPlayActivityConfig.OBJ_ID, userId).ae("tid", this.aWq));
            if (this.fEt != 1) {
                i = this.fEt == 3 ? 2 : 0;
            }
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c12507");
            anVar.r("obj_locate", i);
            anVar.ae(VideoPlayActivityConfig.OBJ_ID, userId);
            anVar.ae("tid", this.aWq);
            anVar.r("obj_param1", this.fEu);
            if (!com.baidu.tbadk.core.util.ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
            }
            TiebaStatic.log(anVar);
            super.onClick(view);
            if (this.fEs && this.azv != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c11924").ae(VideoPlayActivityConfig.OBJ_ID, this.azv.getUserId()));
            }
            if (this.isBigV && this.azv != null) {
                if (this.fEt == 1) {
                    i2 = 1;
                } else if (this.fEt != 2) {
                    i2 = 0;
                }
                TiebaStatic.log(new com.baidu.tbadk.core.util.an("c12150").r("obj_locate", i2).ae(VideoPlayActivityConfig.OBJ_ID, this.azv.getUserId()));
            }
        }
    }
}
