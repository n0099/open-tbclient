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
public class bg extends CustomMessageListener {
    final /* synthetic */ bf djH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(bf bfVar, int i) {
        super(i);
        this.djH = bfVar;
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
        bp bpVar;
        com.baidu.adp.base.g gVar2;
        if (customResponsedMessage instanceof ResponsePersonInfoMessage) {
            ResponsePersonInfoMessage responsePersonInfoMessage = (ResponsePersonInfoMessage) customResponsedMessage;
            if (responsePersonInfoMessage.getUser() == null) {
                gVar2 = this.djH.mLoadDataCallBack;
                gVar2.d(3);
                return;
            }
            userData = this.djH.mUserData;
            if (userData == null) {
                this.djH.mUserData = new UserData();
            }
            this.djH.djn = responsePersonInfoMessage.getUser();
            userData2 = this.djH.mUserData;
            userData2.parserProtobuf(responsePersonInfoMessage.getUser());
            personTainInfo = this.djH.daC;
            if (personTainInfo == null) {
                this.djH.daC = new PersonTainInfo();
            }
            personTainInfo2 = this.djH.daC;
            personTainInfo2.parseProto(responsePersonInfoMessage.getTainfo());
            antiData = this.djH.cJM;
            if (antiData == null) {
                this.djH.cJM = new AntiData();
            }
            antiData2 = this.djH.cJM;
            antiData2.parserProtobuf(responsePersonInfoMessage.getAnti_stat());
            antiData3 = this.djH.cJM;
            userData3 = this.djH.mUserData;
            antiData3.setUser_id(userData3.getUserId());
            antiData4 = this.djH.cJM;
            userData4 = this.djH.mUserData;
            antiData4.setUser_name(userData4.getUserName());
            personUserGodInfo = this.djH.dcd;
            if (personUserGodInfo == null) {
                this.djH.dcd = new PersonUserGodInfo();
            }
            personUserGodInfo2 = this.djH.dcd;
            personUserGodInfo2.parserProtobuf(responsePersonInfoMessage.getUserGodInfo());
            metaData = this.djH.dcp;
            if (metaData == null) {
                this.djH.dcp = new MetaData();
            }
            metaData2 = this.djH.dcp;
            metaData2.parserProtobuf(responsePersonInfoMessage.getUser());
            if (responsePersonInfoMessage.getUcCard() != null) {
                this.djH.djo = new bp();
                bpVar = this.djH.djo;
                bpVar.a(responsePersonInfoMessage.getUcCard());
            }
            list = this.djH.daF;
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
                    list2 = this.djH.daF;
                    list2.add(personInfoPostList);
                    i = i2 + 1;
                }
            }
            this.djH.avQ();
            gVar = this.djH.mLoadDataCallBack;
            gVar.d(2);
        }
    }
}
