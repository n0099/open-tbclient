package com.baidu.tieba.themeCenter.card.category;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tieba.themeCenter.dressCenter.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class PersonalCardCategoryModel extends BdBaseModel<PersonalCardCategoryModel> {
    private int currentPage = 1;
    private boolean hasMore = true;
    private com.baidu.adp.framework.listener.a lkm = new com.baidu.adp.framework.listener.a(1003093, CmdConfigSocket.CMD_GET_CARD_BY_CATEGORY) { // from class: com.baidu.tieba.themeCenter.card.category.PersonalCardCategoryModel.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof PersonalCardCategorySocktResponse) || (responsedMessage instanceof PersonalCardCategoryHttpResponse)) {
                    if (responsedMessage.getError() != 0) {
                        PersonalCardCategoryModel.a(PersonalCardCategoryModel.this);
                        if (PersonalCardCategoryModel.this.nDa != null) {
                            PersonalCardCategoryModel.this.nDa.a(responsedMessage.getError(), responsedMessage.getErrorString(), PersonalCardCategoryModel.this.mRecommand, PersonalCardCategoryModel.this.mCardCategoryList, PersonalCardCategoryModel.this.hasMore);
                            return;
                        }
                        return;
                    }
                    if (responsedMessage instanceof PersonalCardCategorySocktResponse) {
                        PersonalCardCategorySocktResponse personalCardCategorySocktResponse = (PersonalCardCategorySocktResponse) responsedMessage;
                        if (PersonalCardCategoryModel.this.mCardCategoryList == null) {
                            PersonalCardCategoryModel.this.mCardCategoryList = new ArrayList();
                        }
                        if (personalCardCategorySocktResponse.getCardCategoryList() != null) {
                            PersonalCardCategoryModel.this.mCardCategoryList.addAll(personalCardCategorySocktResponse.getCardCategoryList());
                        }
                        PersonalCardCategoryModel.this.mRecommand = personalCardCategorySocktResponse.getRecommand();
                        PersonalCardCategoryModel.this.hasMore = personalCardCategorySocktResponse.isHasMore();
                    } else if (responsedMessage instanceof PersonalCardCategoryHttpResponse) {
                        PersonalCardCategoryHttpResponse personalCardCategoryHttpResponse = (PersonalCardCategoryHttpResponse) responsedMessage;
                        if (PersonalCardCategoryModel.this.mCardCategoryList == null) {
                            PersonalCardCategoryModel.this.mCardCategoryList = new ArrayList();
                        }
                        if (personalCardCategoryHttpResponse.getCardCategoryList() != null) {
                            PersonalCardCategoryModel.this.mCardCategoryList.addAll(personalCardCategoryHttpResponse.getCardCategoryList());
                        }
                        PersonalCardCategoryModel.this.mRecommand = personalCardCategoryHttpResponse.getRecommand();
                        PersonalCardCategoryModel.this.hasMore = personalCardCategoryHttpResponse.isHasMore();
                    }
                    if (PersonalCardCategoryModel.this.nDa != null) {
                        PersonalCardCategoryModel.this.nDa.a(responsedMessage.getError(), responsedMessage.getErrorString(), PersonalCardCategoryModel.this.mRecommand, PersonalCardCategoryModel.this.mCardCategoryList, PersonalCardCategoryModel.this.hasMore);
                    }
                }
            }
        }
    };
    private List<com.baidu.tieba.themeCenter.card.category.a> mCardCategoryList;
    private e mRecommand;
    private a nDa;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, String str, e eVar, List<com.baidu.tieba.themeCenter.card.category.a> list, boolean z);
    }

    static /* synthetic */ int a(PersonalCardCategoryModel personalCardCategoryModel) {
        int i = personalCardCategoryModel.currentPage;
        personalCardCategoryModel.currentPage = i - 1;
        return i;
    }

    public PersonalCardCategoryModel(PersonalCardCategoryActivity personalCardCategoryActivity) {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_CARD_BY_CATEGORY, PersonalCardCategorySocktResponse.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_CARD_BY_CATEGORY, 1003093, TbConfig.GET_PERSONAL_CARD_BY_CATEGORY, PersonalCardCategoryHttpResponse.class, false, false, false, false);
        registerListener(this.lkm);
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.lkm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        PersonalCardCategoryRequest personalCardCategoryRequest = new PersonalCardCategoryRequest();
        this.currentPage = 1;
        personalCardCategoryRequest.setPn(this.currentPage);
        sendMessage(personalCardCategoryRequest);
        return false;
    }

    public void dSQ() {
        if (this.hasMore) {
            this.currentPage++;
            PersonalCardCategoryRequest personalCardCategoryRequest = new PersonalCardCategoryRequest();
            personalCardCategoryRequest.setPn(this.currentPage);
            sendMessage(personalCardCategoryRequest);
        }
    }

    public void J(long j, int i) {
        K(j, i);
        if (this.nDa != null) {
            this.nDa.a(0, null, this.mRecommand, this.mCardCategoryList, this.hasMore);
        }
    }

    public void K(long j, int i) {
        List<com.baidu.tieba.themeCenter.card.category.a> list = this.mCardCategoryList;
        if (list != null && list.size() > 0) {
            for (com.baidu.tieba.themeCenter.card.category.a aVar : list) {
                if (aVar != null && aVar.dSP() != null && aVar.dSP().size() > 0) {
                    for (com.baidu.tieba.themeCenter.a aVar2 : aVar.dSP()) {
                        if (aVar2 != null) {
                            if (aVar2.getCardId() == j) {
                                if (i == 1) {
                                    aVar2.Lq(1);
                                } else {
                                    aVar2.Lq(0);
                                }
                            } else if (i == 1) {
                                aVar2.Lq(0);
                            } else if (aVar2.getCardId() == com.baidu.tieba.themeCenter.a.nAi) {
                                aVar2.Lq(1);
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(a aVar) {
        this.nDa = aVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
