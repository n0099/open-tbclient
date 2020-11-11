package com.baidu.yuyinala.privatemessage.session.b;

import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.live.adp.base.BdBaseApplication;
/* loaded from: classes4.dex */
public class i extends d {
    public e aV(Object obj) {
        if (obj == null || !(obj instanceof ChatSession)) {
            return null;
        }
        ChatSession chatSession = (ChatSession) obj;
        j jVar = new j();
        jVar.XI("usermessage");
        jVar.isGroup = false;
        jVar.oGN = chatSession.getCategory();
        jVar.iconUrl = chatSession.getIconUrl();
        jVar.name = chatSession.getNickName();
        if (TextUtils.isEmpty(jVar.name)) {
            jVar.name = chatSession.getName();
        }
        jVar.description = com.baidu.yuyinala.privatemessage.session.util.a.b(chatSession);
        jVar.time = chatSession.getLastMsgTime() * 1000;
        jVar.oGO = chatSession.getLastMsgTime();
        jVar.oGH = com.baidu.yuyinala.privatemessage.session.util.a.h(BdBaseApplication.getInst(), jVar.time);
        jVar.hasRead = chatSession.getNewMsgSum() <= 0;
        jVar.isMediaRole = chatSession.getSessionFrom() != 0;
        jVar.oGS = chatSession.getShield() != 0;
        jVar.oGP = chatSession.getContacterId();
        jVar.contacter = chatSession.getContacter();
        jVar.paid = chatSession.getPaid();
        try {
            jVar.oGR = com.baidu.yuyinala.privatemessage.session.util.a.hy(chatSession.getNewMsgSum());
        } catch (Exception e) {
        }
        jVar.oGI = 6;
        return jVar;
    }
}
