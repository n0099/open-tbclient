package com.baidu.yuyinala.privatemessage.session.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.live.adp.base.BdBaseApplication;
/* loaded from: classes4.dex */
public class i extends d {
    public e aW(Object obj) {
        if (obj == null || !(obj instanceof ChatSession)) {
            return null;
        }
        ChatSession chatSession = (ChatSession) obj;
        j jVar = new j();
        jVar.Xt("usermessage");
        jVar.isGroup = false;
        jVar.oIr = chatSession.getCategory();
        jVar.iconUrl = chatSession.getIconUrl();
        jVar.name = chatSession.getNickName();
        if (TextUtils.isEmpty(jVar.name)) {
            jVar.name = chatSession.getName();
        }
        jVar.description = com.baidu.yuyinala.privatemessage.session.util.a.b(chatSession);
        jVar.time = chatSession.getLastMsgTime() * 1000;
        jVar.oIs = chatSession.getLastMsgTime();
        jVar.oIl = com.baidu.yuyinala.privatemessage.session.util.a.h(BdBaseApplication.getInst(), jVar.time);
        jVar.hasRead = chatSession.getNewMsgSum() <= 0;
        jVar.isMediaRole = chatSession.getSessionFrom() != 0;
        jVar.oIw = chatSession.getShield() != 0;
        jVar.oIt = chatSession.getContacterId();
        jVar.contacter = chatSession.getContacter();
        jVar.paid = chatSession.getPaid();
        try {
            jVar.oIv = com.baidu.yuyinala.privatemessage.session.util.a.hB(chatSession.getNewMsgSum());
        } catch (Exception e) {
        }
        jVar.oIm = 6;
        return jVar;
    }
}
