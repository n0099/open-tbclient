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
    private boolean aBl;
    private com.baidu.tieba.tbadkCore.d.a aDh;
    private com.baidu.tieba.data.e buk;
    private h bul;
    private long bum;
    private long bun;
    private long buo;
    private long bup;
    private Handler mUIHandler;

    public d(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.buk = null;
        this.aBl = true;
        this.bul = null;
        this.aDh = null;
        this.bum = 0L;
        this.bun = 0L;
        this.buo = 0L;
        this.bup = 0L;
        this.mUIHandler = null;
        setUniqueId(BdUniqueId.gen());
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.base.f
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long Ux() {
        return this.bup;
    }

    public long Uy() {
        return this.bun;
    }

    public long Uz() {
        return this.buo;
    }

    public long UA() {
        return this.bum;
    }

    public com.baidu.tieba.data.e JH() {
        return this.buk;
    }

    public void c(com.baidu.tieba.data.e eVar) {
        this.buk = eVar;
    }

    public void a(h hVar) {
        this.bul = hVar;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        UB();
        return true;
    }

    private void UB() {
        if (this.aDh != null) {
            this.aDh.destory();
            this.aDh = null;
        }
    }

    public boolean du(boolean z) {
        cancelLoadData();
        this.aBl = z;
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(1);
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(0);
        this.bum = System.currentTimeMillis();
        if (this.aDh == null) {
            this.aDh = new com.baidu.tieba.tbadkCore.d.a("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean dv(boolean z) {
        this.aBl = z;
        UC();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        g gVar = new g(this);
        boolean z3 = !z;
        if (this.aDh != null) {
            this.aDh.a(z2, z3, i, str, i2, j, j2);
            this.aDh = null;
        }
        this.buk.bq(false);
        if (z || !this.buk.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                gVar.but = str;
            }
            gVar.type = 1;
            gVar.azu = false;
            gVar.buu = this.buk;
            this.bul.a(gVar);
            return;
        }
        gVar.type = 1;
        gVar.azu = true;
        gVar.buu = this.buk;
        this.bul.a(gVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        a(forumrecommendsocketresponsemessage, forumrecommendsocketresponsemessage.hasError(), forumrecommendsocketresponsemessage.getError(), forumrecommendsocketresponsemessage.getErrorString(), false, forumrecommendsocketresponsemessage.getDownSize(), 0L, forumrecommendsocketresponsemessage.getCostTime());
    }

    public void a(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), forumrecommendhttpresponsemessage.getErrorString(), true, forumrecommendhttpresponsemessage.getDownSize(), forumrecommendhttpresponsemessage.getCostTime(), 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.buk = null;
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
                this.buk = new com.baidu.tieba.data.e();
                this.buk.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.buk.eu(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.buk.fb(forumrecommendhttpresponsemessage.GetMsignText());
                this.buk.ev(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.buk.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.buk.et(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.buk.bq(false);
                j jVar = new j();
                jVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                jVar.i(forumrecommendhttpresponsemessage.GetLikeForum());
                this.buk.a(jVar);
                o oVar = new o();
                oVar.i(forumrecommendhttpresponsemessage.GetNewRecommend());
                this.buk.a(oVar);
                com.baidu.tieba.data.n nVar = new com.baidu.tieba.data.n();
                nVar.H(forumrecommendhttpresponsemessage.GetRecommendForumInfoList());
                this.buk.a(nVar);
                w wVar = new w();
                wVar.i(forumrecommendhttpresponsemessage.GetBanner());
                this.buk.a(wVar);
                this.buk.au(true);
            } catch (Exception e) {
                this.buk.au(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.buk = new com.baidu.tieba.data.e();
                this.buk.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.buk.eu(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.buk.fb(forumrecommendsocketresponsemessage.GetMsignText());
                this.buk.ev(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.buk.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.buk.et(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.buk.bq(false);
                j jVar = new j();
                jVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                jVar.i(forumrecommendsocketresponsemessage.GetLikeForum());
                this.buk.a(jVar);
                o oVar = new o();
                oVar.i(forumrecommendsocketresponsemessage.GetNewRecommend());
                this.buk.a(oVar);
                com.baidu.tieba.data.n nVar = new com.baidu.tieba.data.n();
                nVar.H(forumrecommendsocketresponsemessage.GetRecommendForumInfoList());
                this.buk.a(nVar);
                w wVar = new w();
                wVar.i(forumrecommendsocketresponsemessage.GetBanner());
                this.buk.a(wVar);
                this.buk.au(true);
            } catch (Exception e) {
                this.buk.au(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void UC() {
        com.baidu.adp.lib.cache.t<byte[]> AK = AK();
        com.baidu.tieba.data.e eVar = new com.baidu.tieba.data.e();
        if (this.aBl) {
            AK.a("forumRecommend_cache_key", new e(this, eVar));
        }
    }

    private com.baidu.adp.lib.cache.t<byte[]> AK() {
        return com.baidu.tbadk.core.a.a.nV().Q("tb_forum_recommend", TbadkCoreApplication.getCurrentAccountName());
    }
}
