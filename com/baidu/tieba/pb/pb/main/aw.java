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
    private TbPageContext efr;
    private boolean kKC;
    private com.baidu.tbadk.core.data.ba kKD;

    public aw(TbPageContext tbPageContext) {
        Uri uri;
        this.kKC = false;
        this.efr = tbPageContext;
        if (this.efr.getPageActivity() != null && this.efr.getPageActivity().getIntent() != null && (uri = (Uri) this.efr.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("tid");
            uri.getQueryParameter("eqid");
            this.kKD = new com.baidu.tbadk.core.data.ba();
            this.kKD.tid = uri.getQueryParameter("tid");
            this.kKD.dZC = uri.getQueryParameter("eqid");
            if (!TextUtils.isEmpty(queryParameter) && com.baidu.adp.base.a.lb().getSize() <= 3) {
                this.kKC = true;
            }
        }
    }

    public void h(PbModel pbModel) {
        if (this.kKC && this.kKD != null && pbModel != null && pbModel.getPbData() != null && pbModel.getPbData().getForum() != null) {
            ForumData forum = pbModel.getPbData().getForum();
            this.kKD.firstDir = forum.getFirst_class();
            this.kKD.secondDir = forum.getSecond_class();
            TbSingleton.getInstance().setPbToHomeUpdateData(this.kKD);
            if (com.baidu.adp.base.a.lb().bo("MainTabActivity")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            } else {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
            }
        }
    }
}
