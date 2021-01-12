package com.baidu.tieba.pb.pb.main;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
/* loaded from: classes2.dex */
public class am {
    private TbPageContext eSJ;
    private boolean lPD;
    private bc lPE;

    public am(TbPageContext tbPageContext) {
        Uri uri;
        this.lPD = false;
        this.eSJ = tbPageContext;
        if (this.eSJ.getPageActivity() != null && this.eSJ.getPageActivity().getIntent() != null && (uri = (Uri) this.eSJ.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("tid");
            uri.getQueryParameter("eqid");
            this.lPE = new bc();
            this.lPE.tid = uri.getQueryParameter("tid");
            this.lPE.eMD = uri.getQueryParameter("eqid");
            if (!TextUtils.isEmpty(queryParameter) && com.baidu.adp.base.b.kC().getSize() <= 3) {
                this.lPD = true;
            }
        }
    }

    public void h(PbModel pbModel) {
        if (this.lPD && this.lPE != null && pbModel != null && pbModel.getPbData() != null && pbModel.getPbData().getForum() != null) {
            ForumData forum = pbModel.getPbData().getForum();
            this.lPE.firstDir = forum.getFirst_class();
            this.lPE.secondDir = forum.getSecond_class();
            TbSingleton.getInstance().setPbToHomeUpdateData(this.lPE);
            if (com.baidu.adp.base.b.kC().bo("MainTabActivity")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            } else {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
            }
        }
    }
}
