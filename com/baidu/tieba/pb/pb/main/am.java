package com.baidu.tieba.pb.pb.main;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class am {
    private TbPageContext eUY;
    private boolean lYO;
    private be lYP;

    public am(TbPageContext tbPageContext) {
        Uri uri;
        this.lYO = false;
        this.eUY = tbPageContext;
        if (this.eUY.getPageActivity() != null && this.eUY.getPageActivity().getIntent() != null && (uri = (Uri) this.eUY.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("tid");
            uri.getQueryParameter("eqid");
            this.lYP = new be();
            this.lYP.tid = uri.getQueryParameter("tid");
            this.lYP.eOP = uri.getQueryParameter("eqid");
            if (!TextUtils.isEmpty(queryParameter) && com.baidu.adp.base.b.kB().getSize() <= 3) {
                this.lYO = true;
            }
        }
    }

    public void h(PbModel pbModel) {
        if (this.lYO && this.lYP != null && pbModel != null && pbModel.getPbData() != null && pbModel.getPbData().getForum() != null) {
            ForumData forum = pbModel.getPbData().getForum();
            this.lYP.firstDir = forum.getFirst_class();
            this.lYP.secondDir = forum.getSecond_class();
            TbSingleton.getInstance().setPbToHomeUpdateData(this.lYP);
            if (com.baidu.adp.base.b.kB().bo("MainTabActivity")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            } else {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
            }
        }
    }
}
