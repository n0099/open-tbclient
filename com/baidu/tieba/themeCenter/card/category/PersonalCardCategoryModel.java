package com.baidu.tieba.themeCenter.card.category;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.j0.j3.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PersonalCardCategoryModel extends BdBaseModel<PersonalCardCategoryModel> {

    /* renamed from: e  reason: collision with root package name */
    public e f21952e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.j0.j3.g.a.a> f21953f;

    /* renamed from: i  reason: collision with root package name */
    public b f21956i;

    /* renamed from: g  reason: collision with root package name */
    public int f21954g = 1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21955h = true;
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
                        if (PersonalCardCategoryModel.this.f21953f == null) {
                            PersonalCardCategoryModel.this.f21953f = new ArrayList();
                        }
                        if (personalCardCategorySocktResponse.getCardCategoryList() != null) {
                            PersonalCardCategoryModel.this.f21953f.addAll(personalCardCategorySocktResponse.getCardCategoryList());
                        }
                        PersonalCardCategoryModel.this.f21952e = personalCardCategorySocktResponse.getRecommand();
                        PersonalCardCategoryModel.this.f21955h = personalCardCategorySocktResponse.isHasMore();
                    } else if (responsedMessage instanceof PersonalCardCategoryHttpResponse) {
                        PersonalCardCategoryHttpResponse personalCardCategoryHttpResponse = (PersonalCardCategoryHttpResponse) responsedMessage;
                        if (PersonalCardCategoryModel.this.f21953f == null) {
                            PersonalCardCategoryModel.this.f21953f = new ArrayList();
                        }
                        if (personalCardCategoryHttpResponse.getCardCategoryList() != null) {
                            PersonalCardCategoryModel.this.f21953f.addAll(personalCardCategoryHttpResponse.getCardCategoryList());
                        }
                        PersonalCardCategoryModel.this.f21952e = personalCardCategoryHttpResponse.getRecommand();
                        PersonalCardCategoryModel.this.f21955h = personalCardCategoryHttpResponse.isHasMore();
                    }
                    if (PersonalCardCategoryModel.this.f21956i != null) {
                        PersonalCardCategoryModel.this.f21956i.a(responsedMessage.getError(), responsedMessage.getErrorString(), PersonalCardCategoryModel.this.f21952e, PersonalCardCategoryModel.this.f21953f, PersonalCardCategoryModel.this.f21955h);
                        return;
                    }
                    return;
                }
                PersonalCardCategoryModel.s(PersonalCardCategoryModel.this);
                if (PersonalCardCategoryModel.this.f21956i != null) {
                    PersonalCardCategoryModel.this.f21956i.a(responsedMessage.getError(), responsedMessage.getErrorString(), PersonalCardCategoryModel.this.f21952e, PersonalCardCategoryModel.this.f21953f, PersonalCardCategoryModel.this.f21955h);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i2, String str, e eVar, List<d.a.j0.j3.g.a.a> list, boolean z);
    }

    public PersonalCardCategoryModel(PersonalCardCategoryActivity personalCardCategoryActivity) {
        d.a.j0.d3.d0.a.h(309331, PersonalCardCategorySocktResponse.class, false, false);
        d.a.j0.d3.d0.a.c(309331, CmdConfigHttp.CMD_GET_CARD_BY_CATEGORY, TbConfig.GET_PERSONAL_CARD_BY_CATEGORY, PersonalCardCategoryHttpResponse.class, false, false, false, false);
        registerListener(this.j);
    }

    public static /* synthetic */ int s(PersonalCardCategoryModel personalCardCategoryModel) {
        int i2 = personalCardCategoryModel.f21954g;
        personalCardCategoryModel.f21954g = i2 - 1;
        return i2;
    }

    public void A() {
        if (this.f21955h) {
            this.f21954g++;
            PersonalCardCategoryRequest personalCardCategoryRequest = new PersonalCardCategoryRequest();
            personalCardCategoryRequest.setPn(this.f21954g);
            sendMessage(personalCardCategoryRequest);
        }
    }

    public void B(long j, int i2) {
        C(j, i2);
        b bVar = this.f21956i;
        if (bVar != null) {
            bVar.a(0, null, this.f21952e, this.f21953f, this.f21955h);
        }
    }

    public void C(long j, int i2) {
        List<d.a.j0.j3.g.a.a> list = this.f21953f;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (d.a.j0.j3.g.a.a aVar : list) {
            if (aVar != null && aVar.a() != null && aVar.a().size() > 0) {
                for (d.a.j0.j3.a aVar2 : aVar.a()) {
                    if (aVar2 != null) {
                        if (aVar2.a() == j) {
                            if (i2 == 1) {
                                aVar2.s(1);
                            } else {
                                aVar2.s(0);
                            }
                        } else if (i2 == 1) {
                            aVar2.s(0);
                        } else if (aVar2.a() == d.a.j0.j3.a.k) {
                            aVar2.s(1);
                        }
                    }
                }
            }
        }
    }

    public void D(b bVar) {
        this.f21956i = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        PersonalCardCategoryRequest personalCardCategoryRequest = new PersonalCardCategoryRequest();
        this.f21954g = 1;
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
