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
    final /* synthetic */ v bGg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(v vVar, int i) {
        super(i);
        this.bGg = vVar;
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
        List list;
        com.baidu.adp.base.h hVar;
        List list2;
        if (customResponsedMessage instanceof ResponsePersonInfoMessage) {
            ResponsePersonInfoMessage responsePersonInfoMessage = (ResponsePersonInfoMessage) customResponsedMessage;
            userData = this.bGg.mUserData;
            if (userData == null) {
                this.bGg.mUserData = new UserData();
            }
            userData2 = this.bGg.mUserData;
            userData2.parserProtobuf(responsePersonInfoMessage.getUser());
            personTainInfo = this.bGg.bGc;
            if (personTainInfo == null) {
                this.bGg.bGc = new PersonTainInfo();
            }
            personTainInfo2 = this.bGg.bGc;
            personTainInfo2.parseProto(responsePersonInfoMessage.getTainfo());
            antiData = this.bGg.amA;
            if (antiData == null) {
                this.bGg.amA = new AntiData();
            }
            antiData2 = this.bGg.amA;
            antiData2.parserProtobuf(responsePersonInfoMessage.getAnti_stat());
            list = this.bGg.bGb;
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
                    list2 = this.bGg.bGb;
                    list2.add(personInfoPostList);
                    i = i2 + 1;
                }
            }
            hVar = this.bGg.mLoadDataCallBack;
            hVar.a(true);
        }
    }
}
