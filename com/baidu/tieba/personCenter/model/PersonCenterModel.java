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
import d.b.b.e.p.j;
import d.b.h0.m0.h;
import d.b.h0.m0.k;
import d.b.i0.f2.e.f;
/* loaded from: classes5.dex */
public class PersonCenterModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int REQUEST_NO_NETWORK = -1;

    /* renamed from: e  reason: collision with root package name */
    public f f20251e;

    /* renamed from: f  reason: collision with root package name */
    public c f20252f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20253g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.b.c.g.a f20254h;
    public CustomMessageListener i;
    public boolean mIsDataLoaded;

    /* loaded from: classes5.dex */
    public class a extends d.b.b.c.g.a {

        /* renamed from: com.baidu.tieba.personCenter.model.PersonCenterModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0219a implements MessageQueue.IdleHandler {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ResponsedMessage f20256a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f20257b;

            public C0219a(ResponsedMessage responsedMessage, long j) {
                this.f20256a = responsedMessage;
                this.f20257b = j;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                PersonCenterModel.this.x(true, this.f20256a, this.f20257b);
                return false;
            }
        }

        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            if (((responsedMessage instanceof ProfileSocketResponseMessage) || (responsedMessage instanceof ProfileHttpResponseMessage)) && PersonCenterModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                if (responsedMessage.getError() != 0) {
                    PersonCenterModel.this.f20252f.onFail(responsedMessage.getError(), responsedMessage.getErrorString());
                } else {
                    PersonCenterModel personCenterModel = PersonCenterModel.this;
                    personCenterModel.mIsDataLoaded = true;
                    personCenterModel.f20252f.a(PersonCenterModel.this.f20251e);
                }
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    Looper.myQueue().addIdleHandler(new C0219a(responsedMessage, System.currentTimeMillis()));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
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

        void onFail(int i, String str);
    }

    public PersonCenterModel(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.mIsDataLoaded = false;
        this.f20253g = false;
        this.f20254h = new a(CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.i = new b(2001380);
        setUniqueId(bdUniqueId);
        registerListener(this.i);
        registerListener(this.f20254h);
    }

    public void A() {
        this.f20251e = new f();
    }

    public void B(c cVar) {
        this.f20252f = cVar;
    }

    public void C(boolean z) {
        this.f20253g = z;
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
        return this.f20251e;
    }

    public void x(boolean z, ResponsedMessage<?> responsedMessage, long j) {
        if (!k.d().g() || d.b.i0.f2.a.d().b() <= 0) {
            return;
        }
        long f2 = d.b.i0.f2.a.d().f();
        long b2 = d.b.i0.f2.a.d().b();
        long c2 = d.b.i0.f2.a.d().c();
        long j2 = f2 + b2;
        long a2 = d.b.i0.f2.a.d().a();
        if (a2 > 0 && j > a2) {
            j2 = j - a2;
        }
        new h(1008, z, responsedMessage, 0L, b2, c2, false, 0L, 0L, j2).c();
        d.b.i0.f2.a.d().h(0L);
    }

    public final void y(PersonChangeData personChangeData) {
        f fVar;
        if (personChangeData == null || (fVar = this.f20251e) == null || fVar.p() == null || TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        A();
        z(d.b.b.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
    }

    public void z(long j) {
        if (!j.A()) {
            this.f20252f.onFail(-1, null);
        } else if (TbadkCoreApplication.getCurrentAccount() == null) {
        } else {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            profileRequestMessage.set_uid(Long.valueOf(d.b.b.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L)));
            profileRequestMessage.set_need_post_count(1);
            profileRequestMessage.set_pn(1);
            profileRequestMessage.set_rn(1);
            profileRequestMessage.set_has_plist(1);
            profileRequestMessage.set_from_db(false);
            profileRequestMessage.set_error_hint(true);
            profileRequestMessage.setSelf(true);
            profileRequestMessage.setTag(this.unique_id);
            if (this.f20253g) {
                profileRequestMessage.setIs_from_usercenter(1);
            } else {
                profileRequestMessage.setIs_from_usercenter(0);
            }
            profileRequestMessage.setPage(1);
            f fVar = new f();
            this.f20251e = fVar;
            profileRequestMessage.setPersonCenterData(fVar);
            sendMessage(profileRequestMessage);
        }
    }
}
