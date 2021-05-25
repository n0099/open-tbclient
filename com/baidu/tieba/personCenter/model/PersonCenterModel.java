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
    public f f19667e;

    /* renamed from: f  reason: collision with root package name */
    public c f19668f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f19669g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f19670h;

    /* renamed from: i  reason: collision with root package name */
    public CustomMessageListener f19671i;
    public boolean mIsDataLoaded;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {

        /* renamed from: com.baidu.tieba.personCenter.model.PersonCenterModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0208a implements MessageQueue.IdleHandler {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ResponsedMessage f19673a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f19674b;

            public C0208a(ResponsedMessage responsedMessage, long j) {
                this.f19673a = responsedMessage;
                this.f19674b = j;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                PersonCenterModel.this.x(true, this.f19673a, this.f19674b);
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
                    PersonCenterModel.this.f19668f.onFail(responsedMessage.getError(), responsedMessage.getErrorString());
                } else {
                    PersonCenterModel personCenterModel = PersonCenterModel.this;
                    personCenterModel.mIsDataLoaded = true;
                    personCenterModel.f19668f.a(PersonCenterModel.this.f19667e);
                }
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    Looper.myQueue().addIdleHandler(new C0208a(responsedMessage, System.currentTimeMillis()));
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
            PersonCenterModel.this.y((PersonChangeData) customResponsedMessage.getData());
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
        this.f19669g = false;
        this.f19670h = new a(CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.f19671i = new b(2001380);
        setUniqueId(bdUniqueId);
        registerListener(this.f19671i);
        registerListener(this.f19670h);
    }

    public void A() {
        this.f19667e = new f();
    }

    public void B(c cVar) {
        this.f19668f = cVar;
    }

    public void C(boolean z) {
        this.f19669g = z;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        cancelLoadData();
        z(TbadkCoreApplication.getCurrentAccountId());
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public f w() {
        return this.f19667e;
    }

    public void x(boolean z, ResponsedMessage<?> responsedMessage, long j) {
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

    public final void y(PersonChangeData personChangeData) {
        f fVar;
        if (personChangeData == null || (fVar = this.f19667e) == null || fVar.p() == null || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        A();
        z(d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
    }

    public void z(long j) {
        if (!j.A()) {
            this.f19668f.onFail(-1, null);
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
            if (this.f19669g) {
                profileRequestMessage.setIs_from_usercenter(1);
            } else {
                profileRequestMessage.setIs_from_usercenter(0);
            }
            profileRequestMessage.setPage(1);
            f fVar = new f();
            this.f19667e = fVar;
            profileRequestMessage.setPersonCenterData(fVar);
            sendMessage(profileRequestMessage);
        }
    }
}
