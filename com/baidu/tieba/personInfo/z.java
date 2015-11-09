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
    final /* synthetic */ y cvo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(y yVar, int i) {
        super(i);
        this.cvo = yVar;
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
            userData = this.cvo.mUserData;
            if (userData == null) {
                this.cvo.mUserData = new UserData();
            }
            userData2 = this.cvo.mUserData;
            userData2.parserProtobuf(responsePersonInfoMessage.getUser());
            personTainInfo = this.cvo.cvk;
            if (personTainInfo == null) {
                this.cvo.cvk = new PersonTainInfo();
            }
            personTainInfo2 = this.cvo.cvk;
            personTainInfo2.parseProto(responsePersonInfoMessage.getTainfo());
            antiData = this.cvo.che;
            if (antiData == null) {
                this.cvo.che = new AntiData();
            }
            antiData2 = this.cvo.che;
            antiData2.parserProtobuf(responsePersonInfoMessage.getAnti_stat());
            antiData3 = this.cvo.che;
            userData3 = this.cvo.mUserData;
            antiData3.setUser_id(userData3.getUserId());
            antiData4 = this.cvo.che;
            userData4 = this.cvo.mUserData;
            antiData4.setUser_name(userData4.getUserName());
            list = this.cvo.cvj;
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
                    list2 = this.cvo.cvj;
                    list2.add(personInfoPostList);
                    i = i2 + 1;
                }
            }
            gVar = this.cvo.mLoadDataCallBack;
            gVar.d(true);
        }
    }
}
