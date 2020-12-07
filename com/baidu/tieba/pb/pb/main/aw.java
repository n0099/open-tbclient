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
    private TbPageContext eNx;
    private boolean lOU;
    private com.baidu.tbadk.core.data.bc lOV;

    public aw(TbPageContext tbPageContext) {
        Uri uri;
        this.lOU = false;
        this.eNx = tbPageContext;
        if (this.eNx.getPageActivity() != null && this.eNx.getPageActivity().getIntent() != null && (uri = (Uri) this.eNx.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("tid");
            uri.getQueryParameter("eqid");
            this.lOV = new com.baidu.tbadk.core.data.bc();
            this.lOV.tid = uri.getQueryParameter("tid");
            this.lOV.eHx = uri.getQueryParameter("eqid");
            if (!TextUtils.isEmpty(queryParameter) && com.baidu.adp.base.a.lg().getSize() <= 3) {
                this.lOU = true;
            }
        }
    }

    public void h(PbModel pbModel) {
        if (this.lOU && this.lOV != null && pbModel != null && pbModel.getPbData() != null && pbModel.getPbData().getForum() != null) {
            ForumData forum = pbModel.getPbData().getForum();
            this.lOV.firstDir = forum.getFirst_class();
            this.lOV.secondDir = forum.getSecond_class();
            TbSingleton.getInstance().setPbToHomeUpdateData(this.lOV);
            if (com.baidu.adp.base.a.lg().bt("MainTabActivity")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            } else {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
            }
        }
    }
}
