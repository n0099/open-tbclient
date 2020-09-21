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
    private TbPageContext ehG;
    private boolean kTc;
    private com.baidu.tbadk.core.data.ba kTd;

    public aw(TbPageContext tbPageContext) {
        Uri uri;
        this.kTc = false;
        this.ehG = tbPageContext;
        if (this.ehG.getPageActivity() != null && this.ehG.getPageActivity().getIntent() != null && (uri = (Uri) this.ehG.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("tid");
            uri.getQueryParameter("eqid");
            this.kTd = new com.baidu.tbadk.core.data.ba();
            this.kTd.tid = uri.getQueryParameter("tid");
            this.kTd.ebM = uri.getQueryParameter("eqid");
            if (!TextUtils.isEmpty(queryParameter) && com.baidu.adp.base.a.lf().getSize() <= 3) {
                this.kTc = true;
            }
        }
    }

    public void h(PbModel pbModel) {
        if (this.kTc && this.kTd != null && pbModel != null && pbModel.getPbData() != null && pbModel.getPbData().getForum() != null) {
            ForumData forum = pbModel.getPbData().getForum();
            this.kTd.firstDir = forum.getFirst_class();
            this.kTd.secondDir = forum.getSecond_class();
            TbSingleton.getInstance().setPbToHomeUpdateData(this.kTd);
            if (com.baidu.adp.base.a.lf().bq("MainTabActivity")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            } else {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
            }
        }
    }
}
