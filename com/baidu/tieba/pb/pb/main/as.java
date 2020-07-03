package com.baidu.tieba.pb.pb.main;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes9.dex */
public class as {
    private TbPageContext dPv;
    private boolean klR;
    private com.baidu.tbadk.core.data.ay klS;

    public as(TbPageContext tbPageContext) {
        Uri uri;
        this.klR = false;
        this.dPv = tbPageContext;
        if (this.dPv.getPageActivity() != null && this.dPv.getPageActivity().getIntent() != null && (uri = (Uri) this.dPv.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("tid");
            uri.getQueryParameter("eqid");
            this.klS = new com.baidu.tbadk.core.data.ay();
            this.klS.tid = uri.getQueryParameter("tid");
            this.klS.dJT = uri.getQueryParameter("eqid");
            if (!TextUtils.isEmpty(queryParameter) && com.baidu.adp.base.a.jC().getSize() <= 3) {
                this.klR = true;
            }
        }
    }

    public void h(PbModel pbModel) {
        if (this.klR && this.klS != null && pbModel != null && pbModel.getPbData() != null && pbModel.getPbData().getForum() != null) {
            ForumData forum = pbModel.getPbData().getForum();
            this.klS.firstDir = forum.getFirst_class();
            this.klS.secondDir = forum.getSecond_class();
            TbSingleton.getInstance().setPbToHomeUpdateData(this.klS);
            if (com.baidu.adp.base.a.jC().bj("MainTabActivity")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            } else {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
            }
        }
    }
}
