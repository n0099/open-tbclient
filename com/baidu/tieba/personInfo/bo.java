package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
import tbclient.PostInfoList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends CustomMessageListener {
    final /* synthetic */ bn eCj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo(bn bnVar, int i) {
        super(i);
        this.eCj = bnVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        UserData userData;
        UserData userData2;
        PersonTainInfo personTainInfo;
        PersonTainInfo personTainInfo2;
        AntiData antiData;
        AntiData antiData2;
        AntiData antiData3;
        UserData userData3;
        AntiData antiData4;
        UserData userData4;
        PersonUserGodInfo personUserGodInfo;
        PersonUserGodInfo personUserGodInfo2;
        MetaData metaData;
        MetaData metaData2;
        List list;
        com.baidu.adp.base.g gVar;
        List list2;
        b bVar;
        com.baidu.tieba.person.f fVar;
        com.baidu.adp.base.g gVar2;
        if (customResponsedMessage instanceof ResponsePersonInfoMessage) {
            ResponsePersonInfoMessage responsePersonInfoMessage = (ResponsePersonInfoMessage) customResponsedMessage;
            if (responsePersonInfoMessage.getUser() == null) {
                gVar2 = this.eCj.mLoadDataCallBack;
                gVar2.g(3);
                return;
            }
            userData = this.eCj.mUserData;
            if (userData == null) {
                this.eCj.mUserData = new UserData();
            }
            this.eCj.eBO = responsePersonInfoMessage.getUser();
            userData2 = this.eCj.mUserData;
            userData2.parserProtobuf(responsePersonInfoMessage.getUser());
            personTainInfo = this.eCj.eqv;
            if (personTainInfo == null) {
                this.eCj.eqv = new PersonTainInfo();
            }
            personTainInfo2 = this.eCj.eqv;
            personTainInfo2.parseProto(responsePersonInfoMessage.getTainfo());
            antiData = this.eCj.dYA;
            if (antiData == null) {
                this.eCj.dYA = new AntiData();
            }
            antiData2 = this.eCj.dYA;
            antiData2.parserProtobuf(responsePersonInfoMessage.getAnti_stat());
            antiData3 = this.eCj.dYA;
            userData3 = this.eCj.mUserData;
            antiData3.setUser_id(userData3.getUserId());
            antiData4 = this.eCj.dYA;
            userData4 = this.eCj.mUserData;
            antiData4.setUser_name(userData4.getUserName());
            personUserGodInfo = this.eCj.est;
            if (personUserGodInfo == null) {
                this.eCj.est = new PersonUserGodInfo();
            }
            personUserGodInfo2 = this.eCj.est;
            personUserGodInfo2.parserProtobuf(responsePersonInfoMessage.getUserGodInfo());
            metaData = this.eCj.esI;
            if (metaData == null) {
                this.eCj.esI = new MetaData();
            }
            metaData2 = this.eCj.esI;
            metaData2.parserProtobuf(responsePersonInfoMessage.getUser());
            if (responsePersonInfoMessage.ucCard != null) {
                this.eCj.ucCardData = new com.baidu.tieba.person.f();
                fVar = this.eCj.ucCardData;
                fVar.a(responsePersonInfoMessage.ucCard);
            }
            if (responsePersonInfoMessage.bookrack != null) {
                this.eCj.eBN = new b();
                bVar = this.eCj.eBN;
                bVar.a(responsePersonInfoMessage.bookrack);
            }
            list = this.eCj.eqy;
            list.clear();
            List<PostInfoList> post_list = responsePersonInfoMessage.getPost_list();
            if (post_list != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= post_list.size()) {
                        break;
                    }
                    PersonInfoPostList personInfoPostList = new PersonInfoPostList();
                    personInfoPostList.parseProto(post_list.get(i2));
                    list2 = this.eCj.eqy;
                    list2.add(personInfoPostList);
                    i = i2 + 1;
                }
            }
            this.eCj.aPS();
            gVar = this.eCj.mLoadDataCallBack;
            gVar.g(2);
        }
    }
}
