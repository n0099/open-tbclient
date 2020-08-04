package com.baidu.tieba.pb.pb.main;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes16.dex */
public class aw {
    private TbPageContext dVN;
    private boolean kuQ;
    private com.baidu.tbadk.core.data.az kuR;

    public aw(TbPageContext tbPageContext) {
        Uri uri;
        this.kuQ = false;
        this.dVN = tbPageContext;
        if (this.dVN.getPageActivity() != null && this.dVN.getPageActivity().getIntent() != null && (uri = (Uri) this.dVN.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("tid");
            uri.getQueryParameter("eqid");
            this.kuR = new com.baidu.tbadk.core.data.az();
            this.kuR.tid = uri.getQueryParameter("tid");
            this.kuR.dQf = uri.getQueryParameter("eqid");
            if (!TextUtils.isEmpty(queryParameter) && com.baidu.adp.base.a.jC().getSize() <= 3) {
                this.kuQ = true;
            }
        }
    }

    public void h(PbModel pbModel) {
        if (this.kuQ && this.kuR != null && pbModel != null && pbModel.getPbData() != null && pbModel.getPbData().getForum() != null) {
            ForumData forum = pbModel.getPbData().getForum();
            this.kuR.firstDir = forum.getFirst_class();
            this.kuR.secondDir = forum.getSecond_class();
            TbSingleton.getInstance().setPbToHomeUpdateData(this.kuR);
            if (com.baidu.adp.base.a.jC().bj("MainTabActivity")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            } else {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
            }
        }
    }
}
