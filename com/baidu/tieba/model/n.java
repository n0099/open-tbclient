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
    private com.baidu.tieba.b.a aAE;
    private boolean axU;
    private long azR;
    private long azS;
    private long azT;
    private long azU;
    private com.baidu.tieba.data.o bos;
    private r bot;
    private Handler mUIHandler;

    public n(Context context) {
        super(context);
        this.bos = null;
        this.axU = true;
        this.bot = null;
        this.aAE = null;
        this.azR = 0L;
        this.azS = 0L;
        this.azT = 0L;
        this.azU = 0L;
        this.mUIHandler = null;
        setUniqueId(BdUniqueId.gen());
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    @Override // com.baidu.adp.base.e
    public BdUniqueId getUniqueId() {
        return this.unique_id;
    }

    public long EZ() {
        return this.azU;
    }

    public long Fa() {
        return this.azS;
    }

    public long Fb() {
        return this.azT;
    }

    public long Fc() {
        return this.azR;
    }

    public com.baidu.tieba.data.o Tm() {
        return this.bos;
    }

    public void c(com.baidu.tieba.data.o oVar) {
        this.bos = oVar;
    }

    public void a(r rVar) {
        this.bot = rVar;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        Tn();
        return true;
    }

    private void Tn() {
        if (this.aAE != null) {
            this.aAE.xY();
            this.aAE = null;
        }
    }

    public boolean dD(boolean z) {
        cancelLoadData();
        this.axU = z;
        forumRecommendRequestMessage forumrecommendrequestmessage = new forumRecommendRequestMessage();
        forumrecommendrequestmessage.set_like_forum(1);
        forumrecommendrequestmessage.set_topic(0);
        forumrecommendrequestmessage.set_recommend(0);
        this.azR = System.currentTimeMillis();
        if (this.aAE == null) {
            this.aAE = new com.baidu.tieba.b.a("forumrecommendStat");
        }
        sendMessage(forumrecommendrequestmessage);
        return true;
    }

    public boolean dE(boolean z) {
        this.axU = z;
        To();
        return true;
    }

    public void a(boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        q qVar = new q(this);
        boolean z3 = !z;
        if (this.aAE != null) {
            this.aAE.a(z2, z3, i, str, i2, j, j2);
            this.aAE = null;
        }
        this.bos.bp(false);
        if (z || !this.bos.isSuccess()) {
            if (str != null && str.length() > 0) {
                setErrorString(str);
                qVar.box = str;
            }
            qVar.type = 1;
            qVar.avc = false;
            qVar.boy = this.bos;
            this.bot.a(qVar);
            return;
        }
        qVar.type = 1;
        qVar.avc = true;
        qVar.boy = this.bos;
        this.bot.a(qVar);
    }

    public void a(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        a(forumrecommendsocketresponsemessage, forumrecommendsocketresponsemessage.hasError(), forumrecommendsocketresponsemessage.getError(), forumrecommendsocketresponsemessage.getErrorString(), false, forumrecommendsocketresponsemessage.getDownSize(), 0L, forumrecommendsocketresponsemessage.getCostTime());
    }

    public void a(forumRecommendHttpResponseMessage forumrecommendhttpresponsemessage) {
        a(forumrecommendhttpresponsemessage, forumrecommendhttpresponsemessage.hasError(), forumrecommendhttpresponsemessage.getError(), forumrecommendhttpresponsemessage.getErrorString(), true, forumrecommendhttpresponsemessage.getDownSize(), forumrecommendhttpresponsemessage.getCostTime(), 0L);
    }

    public void a(ResponsedMessage<?> responsedMessage, boolean z, int i, String str, boolean z2, int i2, long j, long j2) {
        if (z) {
            this.bos = null;
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
                this.bos = new com.baidu.tieba.data.o();
                this.bos.setTime(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bos.ea(forumrecommendhttpresponsemessage.GetMsignValid().intValue());
                this.bos.eq(forumrecommendhttpresponsemessage.GetMsignText());
                this.bos.eb(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                this.bos.setIsMem(forumrecommendhttpresponsemessage.GetIsMem().intValue());
                this.bos.dZ(forumrecommendhttpresponsemessage.GetIsLogin().intValue());
                this.bos.bp(false);
                com.baidu.tieba.data.z zVar = new com.baidu.tieba.data.z();
                zVar.setLevel(forumrecommendhttpresponsemessage.GetMsignLevel().intValue());
                zVar.A(forumrecommendhttpresponsemessage.GetLikeForum());
                this.bos.a(zVar);
                com.baidu.tieba.data.ap apVar = new com.baidu.tieba.data.ap();
                apVar.A(forumrecommendhttpresponsemessage.GetNewRecommend());
                this.bos.a(apVar);
                com.baidu.tieba.square.al alVar = new com.baidu.tieba.square.al();
                alVar.A(forumrecommendhttpresponsemessage.GetBanner());
                this.bos.a(alVar);
                this.bos.ab(true);
            } catch (Exception e) {
                this.bos.ab(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    public void b(forumRecommendSocketResponseMessage forumrecommendsocketresponsemessage) {
        if (forumrecommendsocketresponsemessage != null) {
            try {
                this.bos = new com.baidu.tieba.data.o();
                this.bos.setTime(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bos.ea(forumrecommendsocketresponsemessage.GetMsignValid().intValue());
                this.bos.eq(forumrecommendsocketresponsemessage.GetMsignText());
                this.bos.eb(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                this.bos.setIsMem(forumrecommendsocketresponsemessage.GetIsMem().intValue());
                this.bos.dZ(forumrecommendsocketresponsemessage.GetIsLogin().intValue());
                this.bos.bp(false);
                com.baidu.tieba.data.z zVar = new com.baidu.tieba.data.z();
                zVar.setLevel(forumrecommendsocketresponsemessage.GetMsignLevel().intValue());
                zVar.A(forumrecommendsocketresponsemessage.GetLikeForum());
                this.bos.a(zVar);
                com.baidu.tieba.data.ap apVar = new com.baidu.tieba.data.ap();
                apVar.A(forumrecommendsocketresponsemessage.GetNewRecommend());
                this.bos.a(apVar);
                com.baidu.tieba.square.al alVar = new com.baidu.tieba.square.al();
                alVar.A(forumrecommendsocketresponsemessage.GetBanner());
                this.bos.a(alVar);
                this.bos.ab(true);
            } catch (Exception e) {
                this.bos.ab(false);
                BdLog.e(e.getMessage());
            }
        }
    }

    private void To() {
        com.baidu.adp.lib.cache.t<byte[]> wO = wO();
        com.baidu.tieba.data.o oVar = new com.baidu.tieba.data.o();
        if (this.axU) {
            wO.a("forumRecommend_cache_key", new o(this, oVar));
        }
    }

    private com.baidu.adp.lib.cache.t<byte[]> wO() {
        return com.baidu.tbadk.core.a.a.kS().C("tb_forum_recommend", TbadkApplication.getCurrentAccountName());
    }
}
