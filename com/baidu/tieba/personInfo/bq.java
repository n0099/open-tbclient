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
public class bq extends CustomMessageListener {
    final /* synthetic */ bp eqy;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bq(bp bpVar, int i) {
        super(i);
        this.eqy = bpVar;
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
        com.baidu.tieba.person.bs bsVar;
        com.baidu.adp.base.g gVar2;
        if (customResponsedMessage instanceof ResponsePersonInfoMessage) {
            ResponsePersonInfoMessage responsePersonInfoMessage = (ResponsePersonInfoMessage) customResponsedMessage;
            if (responsePersonInfoMessage.getUser() == null) {
                gVar2 = this.eqy.mLoadDataCallBack;
                gVar2.d(3);
                return;
            }
            userData = this.eqy.mUserData;
            if (userData == null) {
                this.eqy.mUserData = new UserData();
            }
            this.eqy.eqd = responsePersonInfoMessage.getUser();
            userData2 = this.eqy.mUserData;
            userData2.parserProtobuf(responsePersonInfoMessage.getUser());
            personTainInfo = this.eqy.egw;
            if (personTainInfo == null) {
                this.eqy.egw = new PersonTainInfo();
            }
            personTainInfo2 = this.eqy.egw;
            personTainInfo2.parseProto(responsePersonInfoMessage.getTainfo());
            antiData = this.eqy.dMq;
            if (antiData == null) {
                this.eqy.dMq = new AntiData();
            }
            antiData2 = this.eqy.dMq;
            antiData2.parserProtobuf(responsePersonInfoMessage.getAnti_stat());
            antiData3 = this.eqy.dMq;
            userData3 = this.eqy.mUserData;
            antiData3.setUser_id(userData3.getUserId());
            antiData4 = this.eqy.dMq;
            userData4 = this.eqy.mUserData;
            antiData4.setUser_name(userData4.getUserName());
            personUserGodInfo = this.eqy.eip;
            if (personUserGodInfo == null) {
                this.eqy.eip = new PersonUserGodInfo();
            }
            personUserGodInfo2 = this.eqy.eip;
            personUserGodInfo2.parserProtobuf(responsePersonInfoMessage.getUserGodInfo());
            metaData = this.eqy.eiE;
            if (metaData == null) {
                this.eqy.eiE = new MetaData();
            }
            metaData2 = this.eqy.eiE;
            metaData2.parserProtobuf(responsePersonInfoMessage.getUser());
            if (responsePersonInfoMessage.ucCard != null) {
                this.eqy.ucCardData = new com.baidu.tieba.person.bs();
                bsVar = this.eqy.ucCardData;
                bsVar.a(responsePersonInfoMessage.ucCard);
            }
            list = this.eqy.egz;
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
                    list2 = this.eqy.egz;
                    list2.add(personInfoPostList);
                    i = i2 + 1;
                }
            }
            this.eqy.aMP();
            gVar = this.eqy.mLoadDataCallBack;
            gVar.d(2);
        }
    }
}
