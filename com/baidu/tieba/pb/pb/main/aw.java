package com.baidu.tieba.pb.pb.main;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes21.dex */
public class aw {
    private TbPageContext eGu;
    private boolean lBh;
    private com.baidu.tbadk.core.data.bb lBi;

    public aw(TbPageContext tbPageContext) {
        Uri uri;
        this.lBh = false;
        this.eGu = tbPageContext;
        if (this.eGu.getPageActivity() != null && this.eGu.getPageActivity().getIntent() != null && (uri = (Uri) this.eGu.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("tid");
            uri.getQueryParameter("eqid");
            this.lBi = new com.baidu.tbadk.core.data.bb();
            this.lBi.tid = uri.getQueryParameter("tid");
            this.lBi.eAy = uri.getQueryParameter("eqid");
            if (!TextUtils.isEmpty(queryParameter) && com.baidu.adp.base.a.lg().getSize() <= 3) {
                this.lBh = true;
            }
        }
    }

    public void h(PbModel pbModel) {
        if (this.lBh && this.lBi != null && pbModel != null && pbModel.getPbData() != null && pbModel.getPbData().getForum() != null) {
            ForumData forum = pbModel.getPbData().getForum();
            this.lBi.firstDir = forum.getFirst_class();
            this.lBi.secondDir = forum.getSecond_class();
            TbSingleton.getInstance().setPbToHomeUpdateData(this.lBi);
            if (com.baidu.adp.base.a.lg().bq("MainTabActivity")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            } else {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
            }
        }
    }
}
