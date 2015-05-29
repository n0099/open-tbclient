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
    final /* synthetic */ v bWG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(v vVar, int i) {
        super(i);
        this.bWG = vVar;
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
            userData = this.bWG.mUserData;
            if (userData == null) {
                this.bWG.mUserData = new UserData();
            }
            userData2 = this.bWG.mUserData;
            userData2.parserProtobuf(responsePersonInfoMessage.getUser());
            personTainInfo = this.bWG.bWC;
            if (personTainInfo == null) {
                this.bWG.bWC = new PersonTainInfo();
            }
            personTainInfo2 = this.bWG.bWC;
            personTainInfo2.parseProto(responsePersonInfoMessage.getTainfo());
            antiData = this.bWG.bJU;
            if (antiData == null) {
                this.bWG.bJU = new AntiData();
            }
            antiData2 = this.bWG.bJU;
            antiData2.parserProtobuf(responsePersonInfoMessage.getAnti_stat());
            antiData3 = this.bWG.bJU;
            userData3 = this.bWG.mUserData;
            antiData3.setUser_id(userData3.getUserId());
            antiData4 = this.bWG.bJU;
            userData4 = this.bWG.mUserData;
            antiData4.setUser_name(userData4.getUserName());
            list = this.bWG.bWB;
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
                    list2 = this.bWG.bWB;
                    list2.add(personInfoPostList);
                    i = i2 + 1;
                }
            }
            iVar = this.bWG.mLoadDataCallBack;
            iVar.c(true);
        }
    }
}
