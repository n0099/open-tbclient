package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
import tbclient.PostInfoList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends CustomMessageListener {
    final /* synthetic */ v bTZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(v vVar, int i) {
        super(i);
        this.bTZ = vVar;
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
        List list;
        com.baidu.adp.base.i iVar;
        List list2;
        if (customResponsedMessage instanceof ResponsePersonInfoMessage) {
            ResponsePersonInfoMessage responsePersonInfoMessage = (ResponsePersonInfoMessage) customResponsedMessage;
            userData = this.bTZ.mUserData;
            if (userData == null) {
                this.bTZ.mUserData = new UserData();
            }
            userData2 = this.bTZ.mUserData;
            userData2.parserProtobuf(responsePersonInfoMessage.getUser());
            personTainInfo = this.bTZ.bTV;
            if (personTainInfo == null) {
                this.bTZ.bTV = new PersonTainInfo();
            }
            personTainInfo2 = this.bTZ.bTV;
            personTainInfo2.parseProto(responsePersonInfoMessage.getTainfo());
            antiData = this.bTZ.bHF;
            if (antiData == null) {
                this.bTZ.bHF = new AntiData();
            }
            antiData2 = this.bTZ.bHF;
            antiData2.parserProtobuf(responsePersonInfoMessage.getAnti_stat());
            antiData3 = this.bTZ.bHF;
            userData3 = this.bTZ.mUserData;
            antiData3.setUser_id(userData3.getUserId());
            antiData4 = this.bTZ.bHF;
            userData4 = this.bTZ.mUserData;
            antiData4.setUser_name(userData4.getUserName());
            list = this.bTZ.bTU;
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
                    list2 = this.bTZ.bTU;
                    list2.add(personInfoPostList);
                    i = i2 + 1;
                }
            }
            iVar = this.bTZ.mLoadDataCallBack;
            iVar.c(true);
        }
    }
}
