package com.baidu.tieba.themeCenter.card.category;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.i0.i3.h.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class PersonalCardCategoryModel extends BdBaseModel<PersonalCardCategoryModel> {

    /* renamed from: e  reason: collision with root package name */
    public e f21646e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.i0.i3.g.a.a> f21647f;
    public b i;

    /* renamed from: g  reason: collision with root package name */
    public int f21648g = 1;

    /* renamed from: h  reason: collision with root package name */
    public boolean f21649h = true;
    public d.b.b.c.g.a j = new a(CmdConfigHttp.CMD_GET_CARD_BY_CATEGORY, 309331);

    /* loaded from: classes5.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof PersonalCardCategorySocktResponse;
            if (z || (responsedMessage instanceof PersonalCardCategoryHttpResponse)) {
                if (responsedMessage.getError() == 0) {
                    if (z) {
                        PersonalCardCategorySocktResponse personalCardCategorySocktResponse = (PersonalCardCategorySocktResponse) responsedMessage;
                        if (PersonalCardCategoryModel.this.f21647f == null) {
                            PersonalCardCategoryModel.this.f21647f = new ArrayList();
                        }
                        if (personalCardCategorySocktResponse.getCardCategoryList() != null) {
                            PersonalCardCategoryModel.this.f21647f.addAll(personalCardCategorySocktResponse.getCardCategoryList());
                        }
                        PersonalCardCategoryModel.this.f21646e = personalCardCategorySocktResponse.getRecommand();
                        PersonalCardCategoryModel.this.f21649h = personalCardCategorySocktResponse.isHasMore();
                    } else if (responsedMessage instanceof PersonalCardCategoryHttpResponse) {
                        PersonalCardCategoryHttpResponse personalCardCategoryHttpResponse = (PersonalCardCategoryHttpResponse) responsedMessage;
                        if (PersonalCardCategoryModel.this.f21647f == null) {
                            PersonalCardCategoryModel.this.f21647f = new ArrayList();
                        }
                        if (personalCardCategoryHttpResponse.getCardCategoryList() != null) {
                            PersonalCardCategoryModel.this.f21647f.addAll(personalCardCategoryHttpResponse.getCardCategoryList());
                        }
                        PersonalCardCategoryModel.this.f21646e = personalCardCategoryHttpResponse.getRecommand();
                        PersonalCardCategoryModel.this.f21649h = personalCardCategoryHttpResponse.isHasMore();
                    }
                    if (PersonalCardCategoryModel.this.i != null) {
                        PersonalCardCategoryModel.this.i.a(responsedMessage.getError(), responsedMessage.getErrorString(), PersonalCardCategoryModel.this.f21646e, PersonalCardCategoryModel.this.f21647f, PersonalCardCategoryModel.this.f21649h);
                        return;
                    }
                    return;
                }
                PersonalCardCategoryModel.s(PersonalCardCategoryModel.this);
                if (PersonalCardCategoryModel.this.i != null) {
                    PersonalCardCategoryModel.this.i.a(responsedMessage.getError(), responsedMessage.getErrorString(), PersonalCardCategoryModel.this.f21646e, PersonalCardCategoryModel.this.f21647f, PersonalCardCategoryModel.this.f21649h);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(int i, String str, e eVar, List<d.b.i0.i3.g.a.a> list, boolean z);
    }

    public PersonalCardCategoryModel(PersonalCardCategoryActivity personalCardCategoryActivity) {
        d.b.i0.c3.d0.a.h(309331, PersonalCardCategorySocktResponse.class, false, false);
        d.b.i0.c3.d0.a.c(309331, CmdConfigHttp.CMD_GET_CARD_BY_CATEGORY, TbConfig.GET_PERSONAL_CARD_BY_CATEGORY, PersonalCardCategoryHttpResponse.class, false, false, false, false);
        registerListener(this.j);
    }

    public static /* synthetic */ int s(PersonalCardCategoryModel personalCardCategoryModel) {
        int i = personalCardCategoryModel.f21648g;
        personalCardCategoryModel.f21648g = i - 1;
        return i;
    }

    public void A() {
        if (this.f21649h) {
            this.f21648g++;
            PersonalCardCategoryRequest personalCardCategoryRequest = new PersonalCardCategoryRequest();
            personalCardCategoryRequest.setPn(this.f21648g);
            sendMessage(personalCardCategoryRequest);
        }
    }

    public void B(long j, int i) {
        C(j, i);
        b bVar = this.i;
        if (bVar != null) {
            bVar.a(0, null, this.f21646e, this.f21647f, this.f21649h);
        }
    }

    public void C(long j, int i) {
        List<d.b.i0.i3.g.a.a> list = this.f21647f;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (d.b.i0.i3.g.a.a aVar : list) {
            if (aVar != null && aVar.a() != null && aVar.a().size() > 0) {
                for (d.b.i0.i3.a aVar2 : aVar.a()) {
                    if (aVar2 != null) {
                        if (aVar2.a() == j) {
                            if (i == 1) {
                                aVar2.s(1);
                            } else {
                                aVar2.s(0);
                            }
                        } else if (i == 1) {
                            aVar2.s(0);
                        } else if (aVar2.a() == d.b.i0.i3.a.k) {
                            aVar2.s(1);
                        }
                    }
                }
            }
        }
    }

    public void D(b bVar) {
        this.i = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        PersonalCardCategoryRequest personalCardCategoryRequest = new PersonalCardCategoryRequest();
        this.f21648g = 1;
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
