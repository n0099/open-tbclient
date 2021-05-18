package com.baidu.tieba.personPolymeric.mode;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.person.ProfileHttpResponseMessage;
import com.baidu.tieba.person.ProfileRequestMessage;
import com.baidu.tieba.person.ProfileSocketResponseMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes5.dex */
public class PersonPolymericModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int RN = 20;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.i2.e.a f19933e;

    /* renamed from: f  reason: collision with root package name */
    public int f19934f;

    /* renamed from: g  reason: collision with root package name */
    public String f19935g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.k0.i2.h.b f19936h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.k0.i2.h.a f19937i;
    public boolean j;
    public d.a.c.c.g.a k;
    public CustomMessageListener l;
    public CustomMessageListener m;
    public CustomMessageListener n;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            boolean z = responsedMessage instanceof ProfileSocketResponseMessage;
            if ((z || (responsedMessage instanceof ProfileHttpResponseMessage)) && PersonPolymericModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                d.a.k0.f2.c cVar = z ? (ProfileSocketResponseMessage) responsedMessage : null;
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    cVar = (ProfileHttpResponseMessage) responsedMessage;
                }
                if (cVar.getErrorCode() == 0) {
                    PersonPolymericModel.this.f19933e.v(cVar);
                }
                d.a.k0.i2.b.d().n(System.currentTimeMillis() - d.a.k0.i2.b.d().e());
                if (responsedMessage.getError() == 0) {
                    PersonPolymericModel.this.f19936h.b(PersonPolymericModel.this.f19933e);
                } else {
                    PersonPolymericModel.this.f19936h.b(null);
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
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.a.k0.o3.a) && customResponsedMessage.getOrginalMessage().getTag() == PersonPolymericModel.this.unique_id) {
                d.a.k0.o3.a aVar = (d.a.k0.o3.a) customResponsedMessage.getData();
                DataRes dataRes = aVar.f58051a;
                if (aVar.f58053c != 0 || StringUtils.isNULL(dataRes.is_mute)) {
                    return;
                }
                if (dataRes.is_mute.equals("0")) {
                    PersonPolymericModel.this.f19934f = 0;
                    PersonPolymericModel.this.f19935g = dataRes.mute_confirm;
                    if (k.isEmpty(PersonPolymericModel.this.f19935g)) {
                        PersonPolymericModel.this.f19935g = "确定禁言？";
                    }
                } else if (dataRes.is_mute.equals("1")) {
                    PersonPolymericModel.this.f19934f = 1;
                }
                PersonPolymericModel.this.f19937i.a(0, PersonPolymericModel.this.f19934f, PersonPolymericModel.this.f19935g, aVar.f58053c, aVar.f58052b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || customResponsedMessage.getOrginalMessage().getTag() != PersonPolymericModel.this.unique_id) {
                return;
            }
            UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
            if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                PersonPolymericModel.this.f19934f = 1;
            }
            PersonPolymericModel.this.f19937i.a(1, PersonPolymericModel.this.f19934f, PersonPolymericModel.this.f19935g, userMuteAddResponseMessage.getMuteErrorCode(), userMuteAddResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || customResponsedMessage.getOrginalMessage().getTag() != PersonPolymericModel.this.unique_id) {
                return;
            }
            PersonPolymericModel.this.f19934f = 0;
            UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
            PersonPolymericModel.this.f19937i.a(2, PersonPolymericModel.this.f19934f, PersonPolymericModel.this.f19935g, userMuteDelResponseMessage.getMuteErrorCode(), userMuteDelResponseMessage.getMuteMessage());
        }
    }

    public PersonPolymericModel(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseFragmentActivity.getPageContext());
        this.f19934f = -1;
        this.f19935g = "";
        this.k = new a(CmdConfigHttp.PROFILE_HTTP_CMD, 303012);
        this.l = new b(2001426);
        this.m = new c(2001427);
        this.n = new d(2001428);
        setUniqueId(bdUniqueId);
        if (!z) {
            registerListener(this.l);
            registerListener(this.m);
            registerListener(this.n);
        }
        this.j = z;
        registerListener(this.k);
    }

    public d.a.k0.i2.e.a D() {
        return this.f19933e;
    }

    public void E(long j, String str) {
        if (j.A()) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                profileRequestMessage.set_uid(Long.valueOf(d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L)));
            }
            if (!this.j) {
                profileRequestMessage.set_friend_uid(Long.valueOf(j));
                profileRequestMessage.set_is_guest(1);
            }
            profileRequestMessage.set_friend_uid_portrait(str);
            profileRequestMessage.set_need_post_count(1);
            profileRequestMessage.set_pn(1);
            profileRequestMessage.set_rn(20);
            profileRequestMessage.set_has_plist(1);
            profileRequestMessage.set_from_db(false);
            profileRequestMessage.set_error_hint(true);
            profileRequestMessage.setSelf(true);
            profileRequestMessage.setTag(this.unique_id);
            profileRequestMessage.setIs_from_usercenter(1);
            profileRequestMessage.setPage(2);
            sendMessage(profileRequestMessage);
        }
    }

    public void F(long j) {
        if (j.A()) {
            long f2 = d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            if (j == f2 || !TbadkCoreApplication.isLogin()) {
                return;
            }
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = f2;
            userMuteCheckCustomMessage.userIdT = j;
            BdUniqueId bdUniqueId = this.unique_id;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            sendMessage(userMuteCheckCustomMessage);
        }
    }

    public void G() {
        this.f19933e.w();
    }

    public void H(d.a.k0.i2.h.b bVar) {
        this.f19936h = bVar;
    }

    public void I(d.a.k0.i2.h.a aVar) {
        this.f19937i = aVar;
    }

    public void J(d.a.k0.i2.e.a aVar) {
        this.f19933e = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return false;
    }

    public void destroy() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(getUniqueId());
    }
}
