package com.baidu.tieba.personPolymeric.tab.model;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabHttpResMessage;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabRequestMessage;
import com.baidu.tieba.personPolymeric.tab.data.PersonCenterDynamicTabSocketResMessage;
import d.b.i0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
/* loaded from: classes3.dex */
public class PersonCenterDynamicTabModel extends BdBaseModel {

    /* renamed from: g  reason: collision with root package name */
    public b f20156g;
    public long i;
    public User j;
    public MetaData k;
    public final d.b.c.c.g.a m;

    /* renamed from: e  reason: collision with root package name */
    public long f20154e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f20155f = false;

    /* renamed from: h  reason: collision with root package name */
    public final List<a2> f20157h = new ArrayList();
    public BdUniqueId l = BdUniqueId.gen();

    /* loaded from: classes3.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            boolean z;
            if (responsedMessage == null || responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() != PersonCenterDynamicTabModel.this.l) {
                return;
            }
            List<a2> list = null;
            if (responsedMessage instanceof PersonCenterDynamicTabHttpResMessage) {
                PersonCenterDynamicTabHttpResMessage personCenterDynamicTabHttpResMessage = (PersonCenterDynamicTabHttpResMessage) responsedMessage;
                j = personCenterDynamicTabHttpResMessage.mCursor;
                z = personCenterDynamicTabHttpResMessage.mHasMore;
                list = personCenterDynamicTabHttpResMessage.mThreadDataList;
            } else if (responsedMessage instanceof PersonCenterDynamicTabSocketResMessage) {
                PersonCenterDynamicTabSocketResMessage personCenterDynamicTabSocketResMessage = (PersonCenterDynamicTabSocketResMessage) responsedMessage;
                j = personCenterDynamicTabSocketResMessage.mCursor;
                z = personCenterDynamicTabSocketResMessage.mHasMore;
                list = personCenterDynamicTabSocketResMessage.mThreadDataList;
            } else {
                j = 0;
                z = false;
            }
            if (responsedMessage.getError() != 0) {
                if (PersonCenterDynamicTabModel.this.f20156g != null) {
                    PersonCenterDynamicTabModel.this.f20156g.b(PersonCenterDynamicTabModel.this.f20154e == 0);
                    return;
                }
                return;
            }
            if (!ListUtils.isEmpty(list)) {
                PersonCenterDynamicTabModel.this.D(list);
                PersonCenterDynamicTabModel.this.f20157h.addAll(list);
            }
            PersonCenterDynamicTabModel.this.f20155f = z;
            if (PersonCenterDynamicTabModel.this.f20156g != null) {
                PersonCenterDynamicTabModel.this.f20156g.a(PersonCenterDynamicTabModel.this.f20157h, PersonCenterDynamicTabModel.this.f20155f, PersonCenterDynamicTabModel.this.f20154e == 0);
            }
            PersonCenterDynamicTabModel.this.f20154e = j;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(List<a2> list, boolean z, boolean z2);

        void b(boolean z);
    }

    public PersonCenterDynamicTabModel(TbPageContext tbPageContext, long j) {
        a aVar = new a(CmdConfigHttp.CMD_PERSON_CENTER_DYNAMIC_TAB, 309647);
        this.m = aVar;
        this.i = j;
        aVar.setTag(this.l);
        MessageManager.getInstance().registerListener(this.m);
    }

    public boolean A() {
        return this.f20155f;
    }

    public final void B(long j) {
        PersonCenterDynamicTabRequestMessage personCenterDynamicTabRequestMessage = new PersonCenterDynamicTabRequestMessage(this.i, j, 10);
        personCenterDynamicTabRequestMessage.setTag(this.l);
        MessageManager.getInstance().sendMessage(personCenterDynamicTabRequestMessage);
    }

    public void C() {
        B(this.f20154e);
    }

    public final void D(List<a2> list) {
        if (this.j == null || ListUtils.isEmpty(list)) {
            return;
        }
        for (a2 a2Var : list) {
            if (a2Var.T() != null) {
                a2Var.T().getNewGodData().parserProtobuf(this.j.new_god_data);
                a2Var.T().getBazhuGradeData().parserProtobuf(this.j.bazhu_grade);
                a2Var.T().setBaijiahaoInfo(this.j.baijiahao_info);
                if (this.k != null) {
                    a2Var.T().setPrivSetsData(this.k.getPrivSetsData());
                }
                a2Var.X2();
            }
        }
    }

    public void E() {
        this.f20154e = 0L;
        this.f20157h.clear();
        B(this.f20154e);
    }

    public void F(MetaData metaData) {
        this.k = metaData;
    }

    public void G(b bVar) {
        this.f20156g = bVar;
    }

    public void H(User user) {
        this.j = user;
        E();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        this.f20154e = 0L;
        this.f20155f = false;
        this.f20157h.clear();
        if (this.m != null) {
            MessageManager.getInstance().unRegisterListener(this.m);
        }
    }
}
