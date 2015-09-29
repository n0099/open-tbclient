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
    final /* synthetic */ y ctH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(y yVar, int i) {
        super(i);
        this.ctH = yVar;
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
            userData = this.ctH.mUserData;
            if (userData == null) {
                this.ctH.mUserData = new UserData();
            }
            userData2 = this.ctH.mUserData;
            userData2.parserProtobuf(responsePersonInfoMessage.getUser());
            personTainInfo = this.ctH.ctD;
            if (personTainInfo == null) {
                this.ctH.ctD = new PersonTainInfo();
            }
            personTainInfo2 = this.ctH.ctD;
            personTainInfo2.parseProto(responsePersonInfoMessage.getTainfo());
            antiData = this.ctH.cgo;
            if (antiData == null) {
                this.ctH.cgo = new AntiData();
            }
            antiData2 = this.ctH.cgo;
            antiData2.parserProtobuf(responsePersonInfoMessage.getAnti_stat());
            antiData3 = this.ctH.cgo;
            userData3 = this.ctH.mUserData;
            antiData3.setUser_id(userData3.getUserId());
            antiData4 = this.ctH.cgo;
            userData4 = this.ctH.mUserData;
            antiData4.setUser_name(userData4.getUserName());
            list = this.ctH.ctC;
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
                    list2 = this.ctH.ctC;
                    list2.add(personInfoPostList);
                    i = i2 + 1;
                }
            }
            gVar = this.ctH.mLoadDataCallBack;
            gVar.d(true);
        }
    }
}
