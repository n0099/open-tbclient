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
import d.b.b.e.p.j;
import d.b.b.e.p.k;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes5.dex */
public class PersonPolymericModel extends BdBaseModel<BaseFragmentActivity> {
    public static final int RN = 20;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.h2.e.a f20431e;

    /* renamed from: f  reason: collision with root package name */
    public int f20432f;

    /* renamed from: g  reason: collision with root package name */
    public String f20433g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.h2.h.b f20434h;
    public d.b.i0.h2.h.a i;
    public boolean j;
    public d.b.b.c.g.a k;
    public CustomMessageListener l;
    public CustomMessageListener m;
    public CustomMessageListener n;

    /* loaded from: classes5.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null) {
                return;
            }
            boolean z = responsedMessage instanceof ProfileSocketResponseMessage;
            if ((z || (responsedMessage instanceof ProfileHttpResponseMessage)) && PersonPolymericModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                d.b.i0.e2.c cVar = z ? (ProfileSocketResponseMessage) responsedMessage : null;
                if (responsedMessage instanceof ProfileHttpResponseMessage) {
                    cVar = (ProfileHttpResponseMessage) responsedMessage;
                }
                if (cVar.getErrorCode() == 0) {
                    PersonPolymericModel.this.f20431e.v(cVar);
                }
                d.b.i0.h2.b.d().n(System.currentTimeMillis() - d.b.i0.h2.b.d().e());
                if (responsedMessage.getError() == 0) {
                    PersonPolymericModel.this.f20434h.b(PersonPolymericModel.this.f20431e);
                } else {
                    PersonPolymericModel.this.f20434h.b(null);
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
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof d.b.i0.n3.a) && customResponsedMessage.getOrginalMessage().getTag() == PersonPolymericModel.this.unique_id) {
                d.b.i0.n3.a aVar = (d.b.i0.n3.a) customResponsedMessage.getData();
                DataRes dataRes = aVar.f57157a;
                if (aVar.f57159c != 0 || StringUtils.isNULL(dataRes.is_mute)) {
                    return;
                }
                if (dataRes.is_mute.equals("0")) {
                    PersonPolymericModel.this.f20432f = 0;
                    PersonPolymericModel.this.f20433g = dataRes.mute_confirm;
                    if (k.isEmpty(PersonPolymericModel.this.f20433g)) {
                        PersonPolymericModel.this.f20433g = "确定禁言？";
                    }
                } else if (dataRes.is_mute.equals("1")) {
                    PersonPolymericModel.this.f20432f = 1;
                }
                PersonPolymericModel.this.i.a(0, PersonPolymericModel.this.f20432f, PersonPolymericModel.this.f20433g, aVar.f57159c, aVar.f57158b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || customResponsedMessage.getOrginalMessage().getTag() != PersonPolymericModel.this.unique_id) {
                return;
            }
            UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
            if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                PersonPolymericModel.this.f20432f = 1;
            }
            PersonPolymericModel.this.i.a(1, PersonPolymericModel.this.f20432f, PersonPolymericModel.this.f20433g, userMuteAddResponseMessage.getMuteErrorCode(), userMuteAddResponseMessage.getErrorString());
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getOrginalMessage() == null || customResponsedMessage.getOrginalMessage().getTag() != PersonPolymericModel.this.unique_id) {
                return;
            }
            PersonPolymericModel.this.f20432f = 0;
            UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
            PersonPolymericModel.this.i.a(2, PersonPolymericModel.this.f20432f, PersonPolymericModel.this.f20433g, userMuteDelResponseMessage.getMuteErrorCode(), userMuteDelResponseMessage.getMuteMessage());
        }
    }

    public PersonPolymericModel(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, boolean z) {
        super(baseFragmentActivity.getPageContext());
        this.f20432f = -1;
        this.f20433g = "";
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

    public d.b.i0.h2.e.a D() {
        return this.f20431e;
    }

    public void E(long j, String str) {
        if (j.A()) {
            ProfileRequestMessage profileRequestMessage = new ProfileRequestMessage();
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                profileRequestMessage.set_uid(Long.valueOf(d.b.b.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L)));
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
            long f2 = d.b.b.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
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
        this.f20431e.w();
    }

    public void H(d.b.i0.h2.h.b bVar) {
        this.f20434h = bVar;
    }

    public void I(d.b.i0.h2.h.a aVar) {
        this.i = aVar;
    }

    public void J(d.b.i0.h2.e.a aVar) {
        this.f20431e = aVar;
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
