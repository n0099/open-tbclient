package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
import tbclient.PostInfoList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends CustomMessageListener {
    final /* synthetic */ y ctS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(y yVar, int i) {
        super(i);
        this.ctS = yVar;
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
        com.baidu.adp.base.g gVar;
        List list2;
        if (customResponsedMessage instanceof ResponsePersonInfoMessage) {
            ResponsePersonInfoMessage responsePersonInfoMessage = (ResponsePersonInfoMessage) customResponsedMessage;
            userData = this.ctS.mUserData;
            if (userData == null) {
                this.ctS.mUserData = new UserData();
            }
            userData2 = this.ctS.mUserData;
            userData2.parserProtobuf(responsePersonInfoMessage.getUser());
            personTainInfo = this.ctS.ctO;
            if (personTainInfo == null) {
                this.ctS.ctO = new PersonTainInfo();
            }
            personTainInfo2 = this.ctS.ctO;
            personTainInfo2.parseProto(responsePersonInfoMessage.getTainfo());
            antiData = this.ctS.cgz;
            if (antiData == null) {
                this.ctS.cgz = new AntiData();
            }
            antiData2 = this.ctS.cgz;
            antiData2.parserProtobuf(responsePersonInfoMessage.getAnti_stat());
            antiData3 = this.ctS.cgz;
            userData3 = this.ctS.mUserData;
            antiData3.setUser_id(userData3.getUserId());
            antiData4 = this.ctS.cgz;
            userData4 = this.ctS.mUserData;
            antiData4.setUser_name(userData4.getUserName());
            list = this.ctS.ctN;
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
                    list2 = this.ctS.ctN;
                    list2.add(personInfoPostList);
                    i = i2 + 1;
                }
            }
            gVar = this.ctS.mLoadDataCallBack;
            gVar.d(true);
        }
    }
}
