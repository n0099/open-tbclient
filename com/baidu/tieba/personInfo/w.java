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
    final /* synthetic */ v bWH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(v vVar, int i) {
        super(i);
        this.bWH = vVar;
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
            userData = this.bWH.mUserData;
            if (userData == null) {
                this.bWH.mUserData = new UserData();
            }
            userData2 = this.bWH.mUserData;
            userData2.parserProtobuf(responsePersonInfoMessage.getUser());
            personTainInfo = this.bWH.bWD;
            if (personTainInfo == null) {
                this.bWH.bWD = new PersonTainInfo();
            }
            personTainInfo2 = this.bWH.bWD;
            personTainInfo2.parseProto(responsePersonInfoMessage.getTainfo());
            antiData = this.bWH.bJV;
            if (antiData == null) {
                this.bWH.bJV = new AntiData();
            }
            antiData2 = this.bWH.bJV;
            antiData2.parserProtobuf(responsePersonInfoMessage.getAnti_stat());
            antiData3 = this.bWH.bJV;
            userData3 = this.bWH.mUserData;
            antiData3.setUser_id(userData3.getUserId());
            antiData4 = this.bWH.bJV;
            userData4 = this.bWH.mUserData;
            antiData4.setUser_name(userData4.getUserName());
            list = this.bWH.bWC;
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
                    list2 = this.bWH.bWC;
                    list2.add(personInfoPostList);
                    i = i2 + 1;
                }
            }
            iVar = this.bWH.mLoadDataCallBack;
            iVar.c(true);
        }
    }
}
