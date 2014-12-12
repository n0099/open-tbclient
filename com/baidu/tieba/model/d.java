package com.baidu.tieba.model;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.v;
import com.baidu.tieba.data.j;
import com.baidu.tieba.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.home.forumRecommendRequestMessage;
import com.baidu.tieba.home.forumRecommendSocketResponseMessage;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.f {
    private boolean aAj;
    private com.baidu.tieba.tbadkCore.d.a aCg;
    private com.baidu.tieba.data.e bsM;
    private h bsN;
    private long bsO;
    private long bsP;
    private long bsQ;
    private long bsR;
    private Handler mUIHandler;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.bsM = null;
        this.aAj = true;
        this.bsN = null;
        this.aCg = null;
        this.bsO = 0L;
        this.bsP = 0L;
        this.bsQ = 0L;
        this.bsR = 0L;
        this.mUIHandler = null;
        setUniqueId(BdUniqueId.gen());
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.base.f
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long TZ() {
        return this.bsR;
    }

    public long Ua() {
        return this.bsP;
    }

    public long Ub() {
        return this.bsQ;
    }

    public long Uc() {
        return this.bsO;
    }

    public com.baidu.tieba.data.e Ud() {
        return this.bsM;
    }

    public void c(com.baidu.tieba.data.e eVar) {
        this.bsM = eVar;
    }

    public void a(h hVar) {
        this.bsN = hVar;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        Ue();
        return true;
    }

    private void Ue() {
        if (this.aCg != null) {
            this.aCg.destory();
            this.aCg = null;
        }
    }

    public boolean dp(boolean z) {
        cancelLoadData();
        this.aAj = z;
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(1);
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(0);
        this.bsO = System.currentTimeMillis();
        if (this.aCg == null) {
            this.aCg = new com.baidu.tieba.tbadkCore.d.a("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean dq(boolean z) {
        this.aAj = z;
        Uf();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        g gVar = new g(this);
        boolean z3 = !z;
        if (this.aCg != null) {
            this.aCg.a(z2, z3, i, str, i2, j, j2);
            this.aCg = null;
        }
        this.bsM.bn(false);
        if (z || !this.bsM.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                gVar.bsV = str;
            }
            gVar.type = 1;
            gVar.ayu = false;
            gVar.bsW = this.bsM;
            this.bsN.a(gVar);
            return;
        }
        gVar.type = 1;
        gVar.ayu = true;
        gVar.bsW = this.bsM;
        this.bsN.a(gVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        a(forumrecommendsocketresponsemessage, forumrecommendsocketresponsemessage.hasError(), forumrecommendsocketresponsemessage.getError(), forumrecommendsocketresponsemessage.getErrorString(), false, forumrecommendsocketresponsemessage.getDownSize(), 0L, forumrecommendsocketresponsemessage.getCostTime());
    }

    public void a(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), forumrecommendhttpresponsemessage.getErrorString(), true, forumrecommendhttpresponsemessage.getDownSize(), forumrecommendhttpresponsemessage.getCostTime(), 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.bsM = null;
        }
        if (responsedMessage != null) {
            if (responsedMessage instanceof forumRecommendSocketResponseMessage) {
                b((forumRecommendSocketResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof forumRecommendHttpResponseMessage) {
                b((forumRecommendHttpResponseMessage) responsedMessage);
            }
        }
        a(z, i, str, z2, i2, j, j2);
    }

    public void b(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        if (forumrecommendhttpresponsemessage != null) {
            try {
                this.bsM = new com.baidu.tieba.data.e();
                this.bsM.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bsM.eo(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.bsM.eW(forumrecommendhttpresponsemessage.GetMsignText());
                this.bsM.ep(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.bsM.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.bsM.en(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bsM.bn(false);
                j jVar = new j();
                jVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                jVar.i(forumrecommendhttpresponsemessage.GetLikeForum());
                this.bsM.a(jVar);
                com.baidu.tieba.data.o oVar = new com.baidu.tieba.data.o();
                oVar.i(forumrecommendhttpresponsemessage.GetNewRecommend());
                this.bsM.a(oVar);
                com.baidu.tieba.data.n nVar = new com.baidu.tieba.data.n();
                nVar.F(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.bsM.a(nVar);
                v vVar = new v();
                vVar.i(forumrecommendhttpresponsemessage.GetBanner());
                this.bsM.a(vVar);
                this.bsM.as(true);
            } catch (Exception e) {
                this.bsM.as(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.bsM = new com.baidu.tieba.data.e();
                this.bsM.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bsM.eo(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.bsM.eW(forumrecommendsocketresponsemessage.GetMsignText());
                this.bsM.ep(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.bsM.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.bsM.en(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bsM.bn(false);
                j jVar = new j();
                jVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                jVar.i(forumrecommendsocketresponsemessage.GetLikeForum());
                this.bsM.a(jVar);
                com.baidu.tieba.data.o oVar = new com.baidu.tieba.data.o();
                oVar.i(forumrecommendsocketresponsemessage.GetNewRecommend());
                this.bsM.a(oVar);
                com.baidu.tieba.data.n nVar = new com.baidu.tieba.data.n();
                nVar.F(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.bsM.a(nVar);
                v vVar = new v();
                vVar.i(forumrecommendsocketresponsemessage.GetBanner());
                this.bsM.a(vVar);
                this.bsM.as(true);
            } catch (Exception e) {
                this.bsM.as(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void Uf() {
        com.baidu.adp.lib.cache.t<byte[]> Am = Am();
        com.baidu.tieba.data.e eVar = new com.baidu.tieba.data.e();
        if (this.aAj) {
            Am.a("forumRecommend_cache_key", new e(this, eVar));
        }
    }

    private com.baidu.adp.lib.cache.t<byte[]> Am() {
        return com.baidu.tbadk.core.a.a.nS().N("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
    }
}
