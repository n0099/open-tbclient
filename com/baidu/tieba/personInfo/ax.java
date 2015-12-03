package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
import tbclient.PostInfoList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends CustomMessageListener {
    final /* synthetic */ aw cTj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ax(aw awVar, int i) {
        super(i);
        this.cTj = awVar;
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
        List list;
        com.baidu.adp.base.g gVar;
        List list2;
        com.baidu.adp.base.g gVar2;
        if (customResponsedMessage instanceof ResponsePersonInfoMessage) {
            ResponsePersonInfoMessage responsePersonInfoMessage = (ResponsePersonInfoMessage) customResponsedMessage;
            if (responsePersonInfoMessage.getUser() == null) {
                gVar2 = this.cTj.mLoadDataCallBack;
                gVar2.d(3);
                return;
            }
            userData = this.cTj.mUserData;
            if (userData == null) {
                this.cTj.mUserData = new UserData();
            }
            userData2 = this.cTj.mUserData;
            userData2.parserProtobuf(responsePersonInfoMessage.getUser());
            personTainInfo = this.cTj.cMB;
            if (personTainInfo == null) {
                this.cTj.cMB = new PersonTainInfo();
            }
            personTainInfo2 = this.cTj.cMB;
            personTainInfo2.parseProto(responsePersonInfoMessage.getTainfo());
            antiData = this.cTj.czB;
            if (antiData == null) {
                this.cTj.czB = new AntiData();
            }
            antiData2 = this.cTj.czB;
            antiData2.parserProtobuf(responsePersonInfoMessage.getAnti_stat());
            antiData3 = this.cTj.czB;
            userData3 = this.cTj.mUserData;
            antiData3.setUser_id(userData3.getUserId());
            antiData4 = this.cTj.czB;
            userData4 = this.cTj.mUserData;
            antiData4.setUser_name(userData4.getUserName());
            personUserGodInfo = this.cTj.cNE;
            if (personUserGodInfo == null) {
                this.cTj.cNE = new PersonUserGodInfo();
            }
            personUserGodInfo2 = this.cTj.cNE;
            personUserGodInfo2.parserProtobuf(responsePersonInfoMessage.getUserGodInfo());
            list = this.cTj.cME;
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
                    list2 = this.cTj.cME;
                    list2.add(personInfoPostList);
                    i = i2 + 1;
                }
            }
            this.cTj.apr();
            gVar = this.cTj.mLoadDataCallBack;
            gVar.d(2);
        }
    }
}
