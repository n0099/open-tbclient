package com.baidu.tieba.model;

import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.w;
import com.baidu.tieba.data.j;
import com.baidu.tieba.data.o;
import com.baidu.tieba.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.home.forumRecommendRequestMessage;
import com.baidu.tieba.home.forumRecommendSocketResponseMessage;
/* loaded from: classes.dex */
public class d extends com.baidu.adp.base.f {
    private boolean aBi;
    private com.baidu.tieba.tbadkCore.d.a aDe;
    private com.baidu.tieba.data.e buj;
    private h buk;
    private long bul;
    private long bum;
    private long bun;
    private long buo;
    private Handler mUIHandler;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.buj = null;
        this.aBi = true;
        this.buk = null;
        this.aDe = null;
        this.bul = 0L;
        this.bum = 0L;
        this.bun = 0L;
        this.buo = 0L;
        this.mUIHandler = null;
        setUniqueId(BdUniqueId.gen());
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.base.f
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long Us() {
        return this.buo;
    }

    public long Ut() {
        return this.bum;
    }

    public long Uu() {
        return this.bun;
    }

    public long Uv() {
        return this.bul;
    }

    public com.baidu.tieba.data.e JC() {
        return this.buj;
    }

    public void c(com.baidu.tieba.data.e eVar) {
        this.buj = eVar;
    }

    public void a(h hVar) {
        this.buk = hVar;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        Uw();
        return true;
    }

    private void Uw() {
        if (this.aDe != null) {
            this.aDe.destory();
            this.aDe = null;
        }
    }

    public boolean du(boolean z) {
        cancelLoadData();
        this.aBi = z;
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(1);
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(0);
        this.bul = System.currentTimeMillis();
        if (this.aDe == null) {
            this.aDe = new com.baidu.tieba.tbadkCore.d.a("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean dv(boolean z) {
        this.aBi = z;
        Ux();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        g gVar = new g(this);
        boolean z3 = !z;
        if (this.aDe != null) {
            this.aDe.a(z2, z3, i, str, i2, j, j2);
            this.aDe = null;
        }
        this.buj.bq(false);
        if (z || !this.buj.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                gVar.bus = str;
            }
            gVar.type = 1;
            gVar.azr = false;
            gVar.but = this.buj;
            this.buk.a(gVar);
            return;
        }
        gVar.type = 1;
        gVar.azr = true;
        gVar.but = this.buj;
        this.buk.a(gVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        a(forumrecommendsocketresponsemessage, forumrecommendsocketresponsemessage.hasError(), forumrecommendsocketresponsemessage.getError(), forumrecommendsocketresponsemessage.getErrorString(), false, forumrecommendsocketresponsemessage.getDownSize(), 0L, forumrecommendsocketresponsemessage.getCostTime());
    }

    public void a(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), forumrecommendhttpresponsemessage.getErrorString(), true, forumrecommendhttpresponsemessage.getDownSize(), forumrecommendhttpresponsemessage.getCostTime(), 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.buj = null;
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
                this.buj = new com.baidu.tieba.data.e();
                this.buj.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.buj.eu(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.buj.eY(forumrecommendhttpresponsemessage.GetMsignText());
                this.buj.ev(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.buj.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.buj.et(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.buj.bq(false);
                j jVar = new j();
                jVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                jVar.i(forumrecommendhttpresponsemessage.GetLikeForum());
                this.buj.a(jVar);
                o oVar = new o();
                oVar.i(forumrecommendhttpresponsemessage.GetNewRecommend());
                this.buj.a(oVar);
                com.baidu.tieba.data.n nVar = new com.baidu.tieba.data.n();
                nVar.H(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.buj.a(nVar);
                w wVar = new w();
                wVar.i(forumrecommendhttpresponsemessage.GetBanner());
                this.buj.a(wVar);
                this.buj.au(true);
            } catch (Exception e) {
                this.buj.au(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.buj = new com.baidu.tieba.data.e();
                this.buj.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.buj.eu(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.buj.eY(forumrecommendsocketresponsemessage.GetMsignText());
                this.buj.ev(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.buj.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.buj.et(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.buj.bq(false);
                j jVar = new j();
                jVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                jVar.i(forumrecommendsocketresponsemessage.GetLikeForum());
                this.buj.a(jVar);
                o oVar = new o();
                oVar.i(forumrecommendsocketresponsemessage.GetNewRecommend());
                this.buj.a(oVar);
                com.baidu.tieba.data.n nVar = new com.baidu.tieba.data.n();
                nVar.H(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.buj.a(nVar);
                w wVar = new w();
                wVar.i(forumrecommendsocketresponsemessage.GetBanner());
                this.buj.a(wVar);
                this.buj.au(true);
            } catch (Exception e) {
                this.buj.au(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void Ux() {
        com.baidu.adp.lib.cache.t<byte[]> AE = AE();
        com.baidu.tieba.data.e eVar = new com.baidu.tieba.data.e();
        if (this.aBi) {
            AE.a("forumRecommend_cache_key", new e(this, eVar));
        }
    }

    private com.baidu.adp.lib.cache.t<byte[]> AE() {
        return com.baidu.tbadk.core.a.a.nO().Q("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
    }
}
