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
    private TbPageContext eWx;
    private boolean maT;
    private be maU;

    public am(TbPageContext tbPageContext) {
        Uri uri;
        this.maT = false;
        this.eWx = tbPageContext;
        if (this.eWx.getPageActivity() != null && this.eWx.getPageActivity().getIntent() != null && (uri = (Uri) this.eWx.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("tid");
            uri.getQueryParameter("eqid");
            this.maU = new be();
            this.maU.tid = uri.getQueryParameter("tid");
            this.maU.eQq = uri.getQueryParameter("eqid");
            if (!TextUtils.isEmpty(queryParameter) && com.baidu.adp.base.b.kB().getSize() <= 3) {
                this.maT = true;
            }
        }
    }

    public void h(PbModel pbModel) {
        if (this.maT && this.maU != null && pbModel != null && pbModel.getPbData() != null && pbModel.getPbData().getForum() != null) {
            ForumData forum = pbModel.getPbData().getForum();
            this.maU.firstDir = forum.getFirst_class();
            this.maU.secondDir = forum.getSecond_class();
            TbSingleton.getInstance().setPbToHomeUpdateData(this.maU);
            if (com.baidu.adp.base.b.kB().bs("MainTabActivity")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            } else {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
            }
        }
    }
}
