package com.baidu.tieba.model;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.home.forumRecommendHttpResponseMessage;
import com.baidu.tieba.home.forumRecommendRequestMessage;
import com.baidu.tieba.home.forumRecommendSocketResponseMessage;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.base.e {
    private com.baidu.tieba.b.a aAO;
    private long aAa;
    private long aAb;
    private long aAc;
    private long aAd;
    private boolean ayd;
    private com.baidu.tieba.data.o boG;
    private r boH;
    private Handler mUIHandler;

    public n(Context context) {
        super(context);
        this.boG = null;
        this.ayd = true;
        this.boH = null;
        this.aAO = null;
        this.aAa = 0L;
        this.aAb = 0L;
        this.aAc = 0L;
        this.aAd = 0L;
        this.mUIHandler = null;
        setUniqueId(BdUniqueId.gen());
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.base.e
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long Fb() {
        return this.aAd;
    }

    public long Fc() {
        return this.aAb;
    }

    public long Fd() {
        return this.aAc;
    }

    public long Fe() {
        return this.aAa;
    }

    public com.baidu.tieba.data.o Tp() {
        return this.boG;
    }

    public void c(com.baidu.tieba.data.o oVar) {
        this.boG = oVar;
    }

    public void a(r rVar) {
        this.boH = rVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        Tq();
        return true;
    }

    private void Tq() {
        if (this.aAO != null) {
            this.aAO.ya();
            this.aAO = null;
        }
    }

    public boolean dD(boolean z) {
        cancelLoadData();
        this.ayd = z;
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(1);
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(0);
        this.aAa = System.currentTimeMillis();
        if (this.aAO == null) {
            this.aAO = new com.baidu.tieba.b.a("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean dE(boolean z) {
        this.ayd = z;
        Tr();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        q qVar = new q(this);
        boolean z3 = !z;
        if (this.aAO != null) {
            this.aAO.a(z2, z3, i, str, i2, j, j2);
            this.aAO = null;
        }
        this.boG.bp(false);
        if (z || !this.boG.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                qVar.boL = str;
            }
            qVar.type = 1;
            qVar.avl = false;
            qVar.boM = this.boG;
            this.boH.a(qVar);
            return;
        }
        qVar.type = 1;
        qVar.avl = true;
        qVar.boM = this.boG;
        this.boH.a(qVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        a(forumrecommendsocketresponsemessage, forumrecommendsocketresponsemessage.hasError(), forumrecommendsocketresponsemessage.getError(), forumrecommendsocketresponsemessage.getErrorString(), false, forumrecommendsocketresponsemessage.getDownSize(), 0L, forumrecommendsocketresponsemessage.getCostTime());
    }

    public void a(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), forumrecommendhttpresponsemessage.getErrorString(), true, forumrecommendhttpresponsemessage.getDownSize(), forumrecommendhttpresponsemessage.getCostTime(), 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.boG = null;
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
                this.boG = new com.baidu.tieba.data.o();
                this.boG.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.boG.ea(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.boG.eq(forumrecommendhttpresponsemessage.GetMsignText());
                this.boG.eb(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.boG.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.boG.dZ(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.boG.bp(false);
                com.baidu.tieba.data.z zVar = new com.baidu.tieba.data.z();
                zVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                zVar.A(forumrecommendhttpresponsemessage.GetLikeForum());
                this.boG.a(zVar);
                com.baidu.tieba.data.ap apVar = new com.baidu.tieba.data.ap();
                apVar.A(forumrecommendhttpresponsemessage.GetNewRecommend());
                this.boG.a(apVar);
                com.baidu.tieba.square.al alVar = new com.baidu.tieba.square.al();
                alVar.A(forumrecommendhttpresponsemessage.GetBanner());
                this.boG.a(alVar);
                this.boG.ab(true);
            } catch (Exception e) {
                this.boG.ab(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.boG = new com.baidu.tieba.data.o();
                this.boG.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.boG.ea(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.boG.eq(forumrecommendsocketresponsemessage.GetMsignText());
                this.boG.eb(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.boG.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.boG.dZ(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.boG.bp(false);
                com.baidu.tieba.data.z zVar = new com.baidu.tieba.data.z();
                zVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                zVar.A(forumrecommendsocketresponsemessage.GetLikeForum());
                this.boG.a(zVar);
                com.baidu.tieba.data.ap apVar = new com.baidu.tieba.data.ap();
                apVar.A(forumrecommendsocketresponsemessage.GetNewRecommend());
                this.boG.a(apVar);
                com.baidu.tieba.square.al alVar = new com.baidu.tieba.square.al();
                alVar.A(forumrecommendsocketresponsemessage.GetBanner());
                this.boG.a(alVar);
                this.boG.ab(true);
            } catch (Exception e) {
                this.boG.ab(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void Tr() {
        com.baidu.adp.lib.cache.t<byte[]> wQ = wQ();
        com.baidu.tieba.data.o oVar = new com.baidu.tieba.data.o();
        if (this.ayd) {
            wQ.a("forumRecommend_cache_key", new o(this, oVar));
        }
    }

    private com.baidu.adp.lib.cache.t<byte[]> wQ() {
        return com.baidu.tbadk.core.a.a.kS().C("tb_forum_recommend", TbadkApplication.getCurrentAccountName());
    }
}
