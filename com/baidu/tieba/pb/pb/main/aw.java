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
    private TbPageContext eCn;
    private boolean luS;
    private com.baidu.tbadk.core.data.ba luT;

    public aw(TbPageContext tbPageContext) {
        Uri uri;
        this.luS = false;
        this.eCn = tbPageContext;
        if (this.eCn.getPageActivity() != null && this.eCn.getPageActivity().getIntent() != null && (uri = (Uri) this.eCn.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("tid");
            uri.getQueryParameter("eqid");
            this.luT = new com.baidu.tbadk.core.data.ba();
            this.luT.tid = uri.getQueryParameter("tid");
            this.luT.ewo = uri.getQueryParameter("eqid");
            if (!TextUtils.isEmpty(queryParameter) && com.baidu.adp.base.a.lg().getSize() <= 3) {
                this.luS = true;
            }
        }
    }

    public void h(PbModel pbModel) {
        if (this.luS && this.luT != null && pbModel != null && pbModel.getPbData() != null && pbModel.getPbData().getForum() != null) {
            ForumData forum = pbModel.getPbData().getForum();
            this.luT.firstDir = forum.getFirst_class();
            this.luT.secondDir = forum.getSecond_class();
            TbSingleton.getInstance().setPbToHomeUpdateData(this.luT);
            if (com.baidu.adp.base.a.lg().bq("MainTabActivity")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            } else {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
            }
        }
    }
}
