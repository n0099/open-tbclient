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
public class bh extends CustomMessageListener {
    final /* synthetic */ bg dHt;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh(bg bgVar, int i) {
        super(i);
        this.dHt = bgVar;
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
        bq bqVar;
        com.baidu.adp.base.g gVar2;
        if (customResponsedMessage instanceof ResponsePersonInfoMessage) {
            ResponsePersonInfoMessage responsePersonInfoMessage = (ResponsePersonInfoMessage) customResponsedMessage;
            if (responsePersonInfoMessage.getUser() == null) {
                gVar2 = this.dHt.mLoadDataCallBack;
                gVar2.d(3);
                return;
            }
            userData = this.dHt.mUserData;
            if (userData == null) {
                this.dHt.mUserData = new UserData();
            }
            this.dHt.dGY = responsePersonInfoMessage.getUser();
            userData2 = this.dHt.mUserData;
            userData2.parserProtobuf(responsePersonInfoMessage.getUser());
            personTainInfo = this.dHt.dya;
            if (personTainInfo == null) {
                this.dHt.dya = new PersonTainInfo();
            }
            personTainInfo2 = this.dHt.dya;
            personTainInfo2.parseProto(responsePersonInfoMessage.getTainfo());
            antiData = this.dHt.dfx;
            if (antiData == null) {
                this.dHt.dfx = new AntiData();
            }
            antiData2 = this.dHt.dfx;
            antiData2.parserProtobuf(responsePersonInfoMessage.getAnti_stat());
            antiData3 = this.dHt.dfx;
            userData3 = this.dHt.mUserData;
            antiData3.setUser_id(userData3.getUserId());
            antiData4 = this.dHt.dfx;
            userData4 = this.dHt.mUserData;
            antiData4.setUser_name(userData4.getUserName());
            personUserGodInfo = this.dHt.dzL;
            if (personUserGodInfo == null) {
                this.dHt.dzL = new PersonUserGodInfo();
            }
            personUserGodInfo2 = this.dHt.dzL;
            personUserGodInfo2.parserProtobuf(responsePersonInfoMessage.getUserGodInfo());
            metaData = this.dHt.dzX;
            if (metaData == null) {
                this.dHt.dzX = new MetaData();
            }
            metaData2 = this.dHt.dzX;
            metaData2.parserProtobuf(responsePersonInfoMessage.getUser());
            if (responsePersonInfoMessage.getUcCard() != null) {
                this.dHt.dGZ = new bq();
                bqVar = this.dHt.dGZ;
                bqVar.a(responsePersonInfoMessage.getUcCard());
            }
            list = this.dHt.dyd;
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
                    list2 = this.dHt.dyd;
                    list2.add(personInfoPostList);
                    i = i2 + 1;
                }
            }
            this.dHt.aDU();
            gVar = this.dHt.mLoadDataCallBack;
            gVar.d(2);
        }
    }
}
