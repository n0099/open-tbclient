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
    private TbPageContext etO;
    private boolean lip;
    private com.baidu.tbadk.core.data.ba liq;

    public aw(TbPageContext tbPageContext) {
        Uri uri;
        this.lip = false;
        this.etO = tbPageContext;
        if (this.etO.getPageActivity() != null && this.etO.getPageActivity().getIntent() != null && (uri = (Uri) this.etO.getPageActivity().getIntent().getParcelableExtra(IntentConfig.KEY_URI)) != null) {
            String queryParameter = uri.getQueryParameter("tid");
            uri.getQueryParameter("eqid");
            this.liq = new com.baidu.tbadk.core.data.ba();
            this.liq.tid = uri.getQueryParameter("tid");
            this.liq.enQ = uri.getQueryParameter("eqid");
            if (!TextUtils.isEmpty(queryParameter) && com.baidu.adp.base.a.lg().getSize() <= 3) {
                this.lip = true;
            }
        }
    }

    public void h(PbModel pbModel) {
        if (this.lip && this.liq != null && pbModel != null && pbModel.getPbData() != null && pbModel.getPbData().getForum() != null) {
            ForumData forum = pbModel.getPbData().getForum();
            this.liq.firstDir = forum.getFirst_class();
            this.liq.secondDir = forum.getSecond_class();
            TbSingleton.getInstance().setPbToHomeUpdateData(this.liq);
            if (com.baidu.adp.base.a.lg().bq("MainTabActivity")) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921455));
            } else {
                TbSingleton.getInstance().setForceRefreshHomeRecommend(true);
            }
        }
    }
}
