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
    final /* synthetic */ v bGu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(v vVar, int i) {
        super(i);
        this.bGu = vVar;
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
            userData = this.bGu.mUserData;
            if (userData == null) {
                this.bGu.mUserData = new UserData();
            }
            userData2 = this.bGu.mUserData;
            userData2.parserProtobuf(responsePersonInfoMessage.getUser());
            personTainInfo = this.bGu.bGq;
            if (personTainInfo == null) {
                this.bGu.bGq = new PersonTainInfo();
            }
            personTainInfo2 = this.bGu.bGq;
            personTainInfo2.parseProto(responsePersonInfoMessage.getTainfo());
            antiData = this.bGu.amJ;
            if (antiData == null) {
                this.bGu.amJ = new AntiData();
            }
            antiData2 = this.bGu.amJ;
            antiData2.parserProtobuf(responsePersonInfoMessage.getAnti_stat());
            list = this.bGu.bGp;
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
                    list2 = this.bGu.bGp;
                    list2.add(personInfoPostList);
                    i = i2 + 1;
                }
            }
            hVar = this.bGu.mLoadDataCallBack;
            hVar.a(true);
        }
    }
}
