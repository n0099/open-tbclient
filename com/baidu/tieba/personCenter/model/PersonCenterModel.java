package com.baidu.tieba.personCenter.model;

import android.os.Looper;
import android.os.MessageQueue;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.PersonChangeData;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import d.a.c.e.p.j;
import d.a.m0.m0.h;
import d.a.m0.m0.k;
import d.a.n0.h2.e.f;
/* loaded from: classes5.dex */
public class PersonCenterModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int REQUEST_NO_NETWORK = -1;

    /* renamed from: e  reason: collision with root package name */
    public f f19744e;

    /* renamed from: f  reason: collision with root package name */
    public c f19745f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19746g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f19747h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f19748i;
    public boolean mIsDataLoaded;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {

        /* renamed from: com.baidu.tieba.personCenter.model.PersonCenterModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0210a implements MessageQueue.IdleHandler {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ResponsedMessage f19750a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f19751b;

            public C0210a(ResponsedMessage responsedMessage, long j) {
                this.f19750a = responsedMessage;
                this.f19751b = j;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                PersonCenterModel.this.B(true, this.f19750a, this.f19751b);
                return false;
            }
        }

        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) && PersonCenterModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage.getError() != 0) {
                    PersonCenterModel.this.f19745f.onFail(responsedMessage.getError(), responsedMessage.getErrorString());
                } else {
                    PersonCenterModel personCenterModel = PersonCenterModel.this;
                    personCenterModel.mIsDataLoaded = true;
                    personCenterModel.f19745f.a(PersonCenterModel.this.f19744e);
                }
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    Looper.myQueue().addIdleHandler(new C0210a(responsedMessage, System.currentTimeMillis()));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof PersonChangeData)) {
                return;
            }
            PersonCenterModel.this.C((PersonChangeData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(f fVar);

        void onFail(int i2, String str);
    }

    public PersonCenterModel(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mIsDataLoaded = false;
        this.f19746g = false;
        this.f19747h = new a(CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.f19748i = new b(2001380);
        setUniqueId(bdUniqueId);
        registerListener(this.f19748i);
        registerListener(this.f19747h);
    }

    public f A() {
        return this.f19744e;
    }

    public void B(boolean z, ResponsedMessage<?> responsedMessage, long j) {
        if (!k.d().g() || d.a.n0.h2.a.d().b() <= 0) {
            return;
        }
        long f2 = d.a.n0.h2.a.d().f();
        long b2 = d.a.n0.h2.a.d().b();
        long c2 = d.a.n0.h2.a.d().c();
        long j2 = f2 + b2;
        long a2 = d.a.n0.h2.a.d().a();
        if (a2 > 0 && j > a2) {
            j2 = j - a2;
        }
        new h(1008, z, responsedMessage, 0L, b2, c2, false, 0L, 0L, j2).c();
        d.a.n0.h2.a.d().h(0L);
    }

    public final void C(PersonChangeData personChangeData) {
        f fVar;
        if (personChangeData == null || (fVar = this.f19744e) == null || fVar.p() == null || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        E();
        D(d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
    }

    public void D(long j) {
        if (!j.A()) {
            this.f19745f.onFail(-1, null);
        } else if (TbadkCoreApplication.getCurrentAccount() == null) {
        } else {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            profileRequestMessage.set_uid(Long.valueOf(d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L)));
            profileRequestMessage.set_need_post_count(1);
            profileRequestMessage.set_pn(1);
            profileRequestMessage.set_rn(1);
            profileRequestMessage.set_has_plist(1);
            profileRequestMessage.set_from_db(false);
            profileRequestMessage.set_error_hint(true);
            profileRequestMessage.setSelf(true);
            profileRequestMessage.setTag(this.unique_id);
            if (this.f19746g) {
                profileRequestMessage.setIs_from_usercenter(1);
            } else {
                profileRequestMessage.setIs_from_usercenter(0);
            }
            profileRequestMessage.setPage(1);
            f fVar = new f();
            this.f19744e = fVar;
            profileRequestMessage.setPersonCenterData(fVar);
            sendMessage(profileRequestMessage);
        }
    }

    public void E() {
        this.f19744e = new f();
    }

    public void F(c cVar) {
        this.f19745f = cVar;
    }

    public void G(boolean z) {
        this.f19746g = z;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        cancelLoadData();
        D(TbadkCoreApplication.getCurrentAccountId());
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }
}
