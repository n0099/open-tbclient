package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import java.util.List;
import tbclient.PostInfoList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends CustomMessageListener {
    final /* synthetic */ bf dEh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bg(bf bfVar, int i) {
        super(i);
        this.dEh = bfVar;
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
        MetaData metaData;
        MetaData metaData2;
        List list;
        com.baidu.adp.base.g gVar;
        List list2;
        bp bpVar;
        com.baidu.adp.base.g gVar2;
        if (customResponsedMessage instanceof ResponsePersonInfoMessage) {
            ResponsePersonInfoMessage responsePersonInfoMessage = (ResponsePersonInfoMessage) customResponsedMessage;
            if (responsePersonInfoMessage.getUser() == null) {
                gVar2 = this.dEh.mLoadDataCallBack;
                gVar2.d(3);
                return;
            }
            userData = this.dEh.mUserData;
            if (userData == null) {
                this.dEh.mUserData = new UserData();
            }
            this.dEh.dDN = responsePersonInfoMessage.getUser();
            userData2 = this.dEh.mUserData;
            userData2.parserProtobuf(responsePersonInfoMessage.getUser());
            personTainInfo = this.dEh.dve;
            if (personTainInfo == null) {
                this.dEh.dve = new PersonTainInfo();
            }
            personTainInfo2 = this.dEh.dve;
            personTainInfo2.parseProto(responsePersonInfoMessage.getTainfo());
            antiData = this.dEh.ddd;
            if (antiData == null) {
                this.dEh.ddd = new AntiData();
            }
            antiData2 = this.dEh.ddd;
            antiData2.parserProtobuf(responsePersonInfoMessage.getAnti_stat());
            antiData3 = this.dEh.ddd;
            userData3 = this.dEh.mUserData;
            antiData3.setUser_id(userData3.getUserId());
            antiData4 = this.dEh.ddd;
            userData4 = this.dEh.mUserData;
            antiData4.setUser_name(userData4.getUserName());
            personUserGodInfo = this.dEh.dwG;
            if (personUserGodInfo == null) {
                this.dEh.dwG = new PersonUserGodInfo();
            }
            personUserGodInfo2 = this.dEh.dwG;
            personUserGodInfo2.parserProtobuf(responsePersonInfoMessage.getUserGodInfo());
            metaData = this.dEh.dwS;
            if (metaData == null) {
                this.dEh.dwS = new MetaData();
            }
            metaData2 = this.dEh.dwS;
            metaData2.parserProtobuf(responsePersonInfoMessage.getUser());
            if (responsePersonInfoMessage.getUcCard() != null) {
                this.dEh.dDO = new bp();
                bpVar = this.dEh.dDO;
                bpVar.a(responsePersonInfoMessage.getUcCard());
            }
            list = this.dEh.dvh;
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
                    list2 = this.dEh.dvh;
                    list2.add(personInfoPostList);
                    i = i2 + 1;
                }
            }
            this.dEh.aDv();
            gVar = this.dEh.mLoadDataCallBack;
            gVar.d(2);
        }
    }
}
