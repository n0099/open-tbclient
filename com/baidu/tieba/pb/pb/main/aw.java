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
    private boolean kuO;
    private com.baidu.tbadk.core.data.az kuP;

    public aw(TbPageContext tbPageContext) {
        Uri uri;
        this.kuO = false;
        this.dVN = tbPageContext;
        if (this.dVN.getPageActivity() != null && this.dVN.getPageActivity().getIntent() != null && (uri = (Uri) this.dVN.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("tid");
            uri.getQueryParameter("eqid");
            this.kuP = new com.baidu.tbadk.core.data.az();
            this.kuP.tid = uri.getQueryParameter("tid");
            this.kuP.dQf = uri.getQueryParameter("eqid");
            if (!TextUtils.isEmpty(queryParameter) && com.baidu.adp.base.a.jC().getSize() <= 3) {
                this.kuO = true;
            }
        }
    }

    public void h(PbModel pbModel) {
        if (this.kuO && this.kuP != null && pbModel != null && pbModel.getPbData() != null && pbModel.getPbData().getForum() != null) {
            ForumData forum = pbModel.getPbData().getForum();
            this.kuP.firstDir = forum.getFirst_class();
            this.kuP.secondDir = forum.getSecond_class();
            TbSingleton.getInstance().setPbToHomeUpdateData(this.kuP);
            if (com.baidu.adp.base.a.jC().bj("MainTabActivity")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            } else {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
            }
        }
    }
}
