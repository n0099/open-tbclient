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
    private TbPageContext eXu;
    private boolean lUi;
    private bc lUj;

    public am(TbPageContext tbPageContext) {
        Uri uri;
        this.lUi = false;
        this.eXu = tbPageContext;
        if (this.eXu.getPageActivity() != null && this.eXu.getPageActivity().getIntent() != null && (uri = (Uri) this.eXu.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("tid");
            uri.getQueryParameter("eqid");
            this.lUj = new bc();
            this.lUj.tid = uri.getQueryParameter("tid");
            this.lUj.eRo = uri.getQueryParameter("eqid");
            if (!TextUtils.isEmpty(queryParameter) && com.baidu.adp.base.b.kC().getSize() <= 3) {
                this.lUi = true;
            }
        }
    }

    public void h(PbModel pbModel) {
        if (this.lUi && this.lUj != null && pbModel != null && pbModel.getPbData() != null && pbModel.getPbData().getForum() != null) {
            ForumData forum = pbModel.getPbData().getForum();
            this.lUj.firstDir = forum.getFirst_class();
            this.lUj.secondDir = forum.getSecond_class();
            TbSingleton.getInstance().setPbToHomeUpdateData(this.lUj);
            if (com.baidu.adp.base.b.kC().bo("MainTabActivity")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            } else {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
            }
        }
    }
}
