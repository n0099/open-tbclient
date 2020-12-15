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
    private boolean lOW;
    private com.baidu.tbadk.core.data.bc lOX;

    public aw(TbPageContext tbPageContext) {
        Uri uri;
        this.lOW = false;
        this.eNx = tbPageContext;
        if (this.eNx.getPageActivity() != null && this.eNx.getPageActivity().getIntent() != null && (uri = (Uri) this.eNx.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("tid");
            uri.getQueryParameter("eqid");
            this.lOX = new com.baidu.tbadk.core.data.bc();
            this.lOX.tid = uri.getQueryParameter("tid");
            this.lOX.eHx = uri.getQueryParameter("eqid");
            if (!TextUtils.isEmpty(queryParameter) && com.baidu.adp.base.a.lg().getSize() <= 3) {
                this.lOW = true;
            }
        }
    }

    public void h(PbModel pbModel) {
        if (this.lOW && this.lOX != null && pbModel != null && pbModel.getPbData() != null && pbModel.getPbData().getForum() != null) {
            ForumData forum = pbModel.getPbData().getForum();
            this.lOX.firstDir = forum.getFirst_class();
            this.lOX.secondDir = forum.getSecond_class();
            TbSingleton.getInstance().setPbToHomeUpdateData(this.lOX);
            if (com.baidu.adp.base.a.lg().bt("MainTabActivity")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            } else {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
            }
        }
    }
}
