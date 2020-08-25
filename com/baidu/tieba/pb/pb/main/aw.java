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
    private TbPageContext efn;
    private boolean kKv;
    private com.baidu.tbadk.core.data.ba kKw;

    public aw(TbPageContext tbPageContext) {
        Uri uri;
        this.kKv = false;
        this.efn = tbPageContext;
        if (this.efn.getPageActivity() != null && this.efn.getPageActivity().getIntent() != null && (uri = (Uri) this.efn.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("tid");
            uri.getQueryParameter("eqid");
            this.kKw = new com.baidu.tbadk.core.data.ba();
            this.kKw.tid = uri.getQueryParameter("tid");
            this.kKw.dZy = uri.getQueryParameter("eqid");
            if (!TextUtils.isEmpty(queryParameter) && com.baidu.adp.base.a.lb().getSize() <= 3) {
                this.kKv = true;
            }
        }
    }

    public void h(PbModel pbModel) {
        if (this.kKv && this.kKw != null && pbModel != null && pbModel.getPbData() != null && pbModel.getPbData().getForum() != null) {
            ForumData forum = pbModel.getPbData().getForum();
            this.kKw.firstDir = forum.getFirst_class();
            this.kKw.secondDir = forum.getSecond_class();
            TbSingleton.getInstance().setPbToHomeUpdateData(this.kKw);
            if (com.baidu.adp.base.a.lb().bo("MainTabActivity")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            } else {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
            }
        }
    }
}
