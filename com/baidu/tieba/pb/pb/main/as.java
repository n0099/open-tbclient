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
    private TbPageContext dIF;
    private boolean jSb;
    private com.baidu.tbadk.core.data.at jSc;

    public as(TbPageContext tbPageContext) {
        Uri uri;
        this.jSb = false;
        this.dIF = tbPageContext;
        if (this.dIF.getPageActivity() != null && this.dIF.getPageActivity().getIntent() != null && (uri = (Uri) this.dIF.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("tid");
            uri.getQueryParameter("eqid");
            this.jSc = new com.baidu.tbadk.core.data.at();
            this.jSc.tid = uri.getQueryParameter("tid");
            this.jSc.dDx = uri.getQueryParameter("eqid");
            if (!TextUtils.isEmpty(queryParameter) && com.baidu.adp.base.a.jm().getSize() <= 3) {
                this.jSb = true;
            }
        }
    }

    public void h(PbModel pbModel) {
        if (this.jSb && this.jSc != null && pbModel != null && pbModel.getPbData() != null && pbModel.getPbData().getForum() != null) {
            ForumData forum = pbModel.getPbData().getForum();
            this.jSc.firstDir = forum.getFirst_class();
            this.jSc.secondDir = forum.getSecond_class();
            TbSingleton.getInstance().setPbToHomeUpdateData(this.jSc);
            if (com.baidu.adp.base.a.jm().bi("MainTabActivity")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            } else {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
            }
        }
    }
}
