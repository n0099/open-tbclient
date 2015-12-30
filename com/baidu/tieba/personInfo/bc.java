package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
import tbclient.PostInfoList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc extends CustomMessageListener {
    final /* synthetic */ bb cXV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bc(bb bbVar, int i) {
        super(i);
        this.cXV = bbVar;
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
                gVar2 = this.cXV.mLoadDataCallBack;
                gVar2.d(3);
                return;
            }
            userData = this.cXV.mUserData;
            if (userData == null) {
                this.cXV.mUserData = new UserData();
            }
            userData2 = this.cXV.mUserData;
            userData2.parserProtobuf(responsePersonInfoMessage.getUser());
            personTainInfo = this.cXV.cQV;
            if (personTainInfo == null) {
                this.cXV.cQV = new PersonTainInfo();
            }
            personTainInfo2 = this.cXV.cQV;
            personTainInfo2.parseProto(responsePersonInfoMessage.getTainfo());
            antiData = this.cXV.cDg;
            if (antiData == null) {
                this.cXV.cDg = new AntiData();
            }
            antiData2 = this.cXV.cDg;
            antiData2.parserProtobuf(responsePersonInfoMessage.getAnti_stat());
            antiData3 = this.cXV.cDg;
            userData3 = this.cXV.mUserData;
            antiData3.setUser_id(userData3.getUserId());
            antiData4 = this.cXV.cDg;
            userData4 = this.cXV.mUserData;
            antiData4.setUser_name(userData4.getUserName());
            personUserGodInfo = this.cXV.cSk;
            if (personUserGodInfo == null) {
                this.cXV.cSk = new PersonUserGodInfo();
            }
            personUserGodInfo2 = this.cXV.cSk;
            personUserGodInfo2.parserProtobuf(responsePersonInfoMessage.getUserGodInfo());
            list = this.cXV.cQY;
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
                    list2 = this.cXV.cQY;
                    list2.add(personInfoPostList);
                    i = i2 + 1;
                }
            }
            this.cXV.aqG();
            gVar = this.cXV.mLoadDataCallBack;
            gVar.d(2);
        }
    }
}
