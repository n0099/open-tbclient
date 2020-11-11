package com.baidu.tieba.pb.pb.main;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes22.dex */
public class aw {
    private TbPageContext eIc;
    private boolean lAP;
    private com.baidu.tbadk.core.data.ba lAQ;

    public aw(TbPageContext tbPageContext) {
        Uri uri;
        this.lAP = false;
        this.eIc = tbPageContext;
        if (this.eIc.getPageActivity() != null && this.eIc.getPageActivity().getIntent() != null && (uri = (Uri) this.eIc.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("tid");
            uri.getQueryParameter("eqid");
            this.lAQ = new com.baidu.tbadk.core.data.ba();
            this.lAQ.tid = uri.getQueryParameter("tid");
            this.lAQ.eCh = uri.getQueryParameter("eqid");
            if (!TextUtils.isEmpty(queryParameter) && com.baidu.adp.base.a.lg().getSize() <= 3) {
                this.lAP = true;
            }
        }
    }

    public void h(PbModel pbModel) {
        if (this.lAP && this.lAQ != null && pbModel != null && pbModel.getPbData() != null && pbModel.getPbData().getForum() != null) {
            ForumData forum = pbModel.getPbData().getForum();
            this.lAQ.firstDir = forum.getFirst_class();
            this.lAQ.secondDir = forum.getSecond_class();
            TbSingleton.getInstance().setPbToHomeUpdateData(this.lAQ);
            if (com.baidu.adp.base.a.lg().bq("MainTabActivity")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            } else {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
            }
        }
    }
}
