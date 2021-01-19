package com.baidu.yuyinala.privatemessage.session.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.live.adp.base.BdBaseApplication;
/* loaded from: classes10.dex */
public class i extends d {
    public e aW(Object obj) {
        if (obj == null || !(obj instanceof ChatSession)) {
            return null;
        }
        ChatSession chatSession = (ChatSession) obj;
        j jVar = new j();
        jVar.Xq("usermessage");
        jVar.isGroup = false;
        jVar.oZe = chatSession.getCategory();
        jVar.iconUrl = chatSession.getIconUrl();
        jVar.name = chatSession.getNickName();
        if (TextUtils.isEmpty(jVar.name)) {
            jVar.name = chatSession.getName();
        }
        jVar.description = com.baidu.yuyinala.privatemessage.session.util.a.b(chatSession);
        jVar.time = chatSession.getLastMsgTime() * 1000;
        jVar.oZf = chatSession.getLastMsgTime();
        jVar.oYY = com.baidu.yuyinala.privatemessage.session.util.a.k(BdBaseApplication.getInst(), jVar.time);
        jVar.hasRead = chatSession.getNewMsgSum() <= 0;
        jVar.isMediaRole = chatSession.getSessionFrom() != 0;
        jVar.oZj = chatSession.getShield() != 0;
        jVar.oZg = chatSession.getContacterId();
        jVar.contacter = chatSession.getContacter();
        jVar.paid = chatSession.getPaid();
        try {
            jVar.oZi = com.baidu.yuyinala.privatemessage.session.util.a.ia(chatSession.getNewMsgSum());
        } catch (Exception e) {
        }
        jVar.oYZ = 6;
        return jVar;
    }
}
