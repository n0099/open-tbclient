package com.baidu.yuyinala.privatemessage.session.c;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.box.IMBoxManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.IMediaDeleteChatSessionListener;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.yuyinala.privatemessage.implugin.util.c;
import com.baidu.yuyinala.privatemessage.session.a;
import com.baidu.yuyinala.privatemessage.session.b;
import com.baidu.yuyinala.privatemessage.session.b.e;
import com.baidu.yuyinala.privatemessage.session.b.i;
import com.baidu.yuyinala.privatemessage.session.b.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class a extends com.baidu.yuyinala.privatemessage.model.a {
    private Handler mHandler;
    private boolean oIy;
    private volatile CopyOnWriteArrayList<com.baidu.yuyinala.privatemessage.session.b.a> oIx = new CopyOnWriteArrayList<>();
    private com.baidu.yuyinala.privatemessage.session.a oIz = new com.baidu.yuyinala.privatemessage.session.a(BdBaseApplication.getInst());

    @Override // com.baidu.yuyinala.privatemessage.model.a
    public synchronized List<com.baidu.yuyinala.privatemessage.session.b.a> getDataList() {
        return this.oIx;
    }

    @Override // com.baidu.yuyinala.privatemessage.model.a
    public void a(Context context, final b bVar, final int i) {
        if (!LoginManager.getInstance(context).isIMLogined() || BIMManager.getLoginType(context) != 1) {
            if (TbConfig.IM_LOG) {
                if (!LoginManager.getInstance(TbadkCoreApplication.getInst().getContext()).isIMLogined()) {
                    c.i("imlog", "@.@ IM 发送消息失败：IM 未登录");
                } else {
                    c.i("imlog", "@.@ IM 发送消息失败：非 uid 登录");
                }
            }
            if (bVar != null) {
                bVar.w("", -1, "Im 未登录");
                return;
            }
            return;
        }
        this.oIy = true;
        this.oIz.a(new a.InterfaceC0958a<ChatSession>() { // from class: com.baidu.yuyinala.privatemessage.session.c.a.1
            @Override // com.baidu.yuyinala.privatemessage.session.a.InterfaceC0958a
            public void a(a.b<ChatSession> bVar2) {
                a.this.oIy = false;
                if (bVar2 != null) {
                    a.this.oIx.clear();
                    a.this.oIx.addAll(a.this.gx(bVar2.getList()));
                    if (bVar != null) {
                        bVar.OD(i);
                    }
                } else if (bVar != null) {
                    bVar.w("", -1, "无消息");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.baidu.yuyinala.privatemessage.session.b.a> gx(List<ChatSession> list) {
        ChatSession chatSession;
        e eVar;
        ArrayList arrayList = new ArrayList();
        if (list.size() == 0) {
            return arrayList;
        }
        Collections.sort(list, new Comparator<ChatSession>() { // from class: com.baidu.yuyinala.privatemessage.session.c.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(ChatSession chatSession2, ChatSession chatSession3) {
                if (chatSession2 == null && chatSession3 == null) {
                    return 0;
                }
                if (chatSession2 == null) {
                    return 1;
                }
                if (chatSession3 == null) {
                    return -1;
                }
                return (int) (chatSession3.getLastMsgTime() - chatSession2.getLastMsgTime());
            }
        });
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size() || (chatSession = list.get(i2)) == null) {
                break;
            }
            if (a(chatSession)) {
                eVar = new i().aW(chatSession);
            } else {
                eVar = null;
            }
            if (eVar != null) {
                arrayList.add(eVar);
            }
            i = i2 + 1;
        }
        return arrayList;
    }

    private boolean a(ChatSession chatSession) {
        return chatSession != null && (chatSession.getChatType() == 0 || chatSession.getChatType() == 7);
    }

    @Override // com.baidu.yuyinala.privatemessage.model.a
    public void destroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.oIz != null) {
            this.oIz.destory();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.model.a
    public void a(Context context, j jVar, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener) {
        if (jVar != null) {
            if (jVar.isMediaRole) {
                BIMManager.mediaDeleteChatSession(context, jVar.oIt, jVar.oIs, null);
            } else {
                IMBoxManager.setMarkTop(context, jVar.oIt, 0, null);
                BIMManager.deleteMsgs(context, jVar.oIr, jVar.contacter, false);
            }
            if (iMediaDeleteChatSessionListener != null) {
                iMediaDeleteChatSessionListener.onMediaDeleteChatSessionResult(0, "success");
            }
        }
    }
}
