package com.baidu.tieba.themeCenter.card.category;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.n0.k3.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PersonalCardCategoryModel extends BdBaseModel<PersonalCardCategoryModel> {

    /* renamed from: e  reason: collision with root package name */
    public e f21203e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.n0.k3.g.a.a> f21204f;

    /* renamed from: i  reason: collision with root package name */
    public b f21207i;

    /* renamed from: g  reason: collision with root package name */
    public int f21205g = 1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21206h = true;
    public d.a.c.c.g.a j = new a(CmdConfigHttp.CMD_GET_CARD_BY_CATEGORY, 309331);

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof PersonalCardCategorySocktResponse;
            if (z || (responsedMessage instanceof PersonalCardCategoryHttpResponse)) {
                if (responsedMessage.getError() == 0) {
                    if (z) {
                        PersonalCardCategorySocktResponse personalCardCategorySocktResponse = (PersonalCardCategorySocktResponse) responsedMessage;
                        if (PersonalCardCategoryModel.this.f21204f == null) {
                            PersonalCardCategoryModel.this.f21204f = new ArrayList();
                        }
                        if (personalCardCategorySocktResponse.getCardCategoryList() != null) {
                            PersonalCardCategoryModel.this.f21204f.addAll(personalCardCategorySocktResponse.getCardCategoryList());
                        }
                        PersonalCardCategoryModel.this.f21203e = personalCardCategorySocktResponse.getRecommand();
                        PersonalCardCategoryModel.this.f21206h = personalCardCategorySocktResponse.isHasMore();
                    } else if (responsedMessage instanceof PersonalCardCategoryHttpResponse) {
                        PersonalCardCategoryHttpResponse personalCardCategoryHttpResponse = (PersonalCardCategoryHttpResponse) responsedMessage;
                        if (PersonalCardCategoryModel.this.f21204f == null) {
                            PersonalCardCategoryModel.this.f21204f = new ArrayList();
                        }
                        if (personalCardCategoryHttpResponse.getCardCategoryList() != null) {
                            PersonalCardCategoryModel.this.f21204f.addAll(personalCardCategoryHttpResponse.getCardCategoryList());
                        }
                        PersonalCardCategoryModel.this.f21203e = personalCardCategoryHttpResponse.getRecommand();
                        PersonalCardCategoryModel.this.f21206h = personalCardCategoryHttpResponse.isHasMore();
                    }
                    if (PersonalCardCategoryModel.this.f21207i != null) {
                        PersonalCardCategoryModel.this.f21207i.a(responsedMessage.getError(), responsedMessage.getErrorString(), PersonalCardCategoryModel.this.f21203e, PersonalCardCategoryModel.this.f21204f, PersonalCardCategoryModel.this.f21206h);
                        return;
                    }
                    return;
                }
                PersonalCardCategoryModel.w(PersonalCardCategoryModel.this);
                if (PersonalCardCategoryModel.this.f21207i != null) {
                    PersonalCardCategoryModel.this.f21207i.a(responsedMessage.getError(), responsedMessage.getErrorString(), PersonalCardCategoryModel.this.f21203e, PersonalCardCategoryModel.this.f21204f, PersonalCardCategoryModel.this.f21206h);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i2, String str, e eVar, List<d.a.n0.k3.g.a.a> list, boolean z);
    }

    public PersonalCardCategoryModel(PersonalCardCategoryActivity personalCardCategoryActivity) {
        d.a.n0.e3.d0.a.h(309331, PersonalCardCategorySocktResponse.class, false, false);
        d.a.n0.e3.d0.a.c(309331, CmdConfigHttp.CMD_GET_CARD_BY_CATEGORY, TbConfig.GET_PERSONAL_CARD_BY_CATEGORY, PersonalCardCategoryHttpResponse.class, false, false, false, false);
        registerListener(this.j);
    }

    public static /* synthetic */ int w(PersonalCardCategoryModel personalCardCategoryModel) {
        int i2 = personalCardCategoryModel.f21205g;
        personalCardCategoryModel.f21205g = i2 - 1;
        return i2;
    }

    public void E() {
        if (this.f21206h) {
            this.f21205g++;
            PersonalCardCategoryRequest personalCardCategoryRequest = new PersonalCardCategoryRequest();
            personalCardCategoryRequest.setPn(this.f21205g);
            sendMessage(personalCardCategoryRequest);
        }
    }

    public void F(long j, int i2) {
        G(j, i2);
        b bVar = this.f21207i;
        if (bVar != null) {
            bVar.a(0, null, this.f21203e, this.f21204f, this.f21206h);
        }
    }

    public void G(long j, int i2) {
        List<d.a.n0.k3.g.a.a> list = this.f21204f;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (d.a.n0.k3.g.a.a aVar : list) {
            if (aVar != null && aVar.a() != null && aVar.a().size() > 0) {
                for (d.a.n0.k3.a aVar2 : aVar.a()) {
                    if (aVar2 != null) {
                        if (aVar2.a() == j) {
                            if (i2 == 1) {
                                aVar2.s(1);
                            } else {
                                aVar2.s(0);
                            }
                        } else if (i2 == 1) {
                            aVar2.s(0);
                        } else if (aVar2.a() == d.a.n0.k3.a.k) {
                            aVar2.s(1);
                        }
                    }
                }
            }
        }
    }

    public void H(b bVar) {
        this.f21207i = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        PersonalCardCategoryRequest personalCardCategoryRequest = new PersonalCardCategoryRequest();
        this.f21205g = 1;
        personalCardCategoryRequest.setPn(1);
        sendMessage(personalCardCategoryRequest);
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.j);
    }
}
