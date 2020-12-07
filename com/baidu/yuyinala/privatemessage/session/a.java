package com.baidu.yuyinala.privatemessage.session;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.chatmessage.IGetSessionListener;
import com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.yuyinala.privatemessage.model.b;
import com.baidu.yuyinala.privatemessage.session.b.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class a {
    private static HandlerThread oWD = new HandlerThread("ChatCoreDataLoader");
    private Context mContext;
    private Handler mSchedulerHandler = new Handler(oWD.getLooper());
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    private com.baidu.yuyinala.privatemessage.model.b oWE = new com.baidu.yuyinala.privatemessage.model.b();

    /* renamed from: com.baidu.yuyinala.privatemessage.session.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0975a<T> {
        void a(b<T> bVar);
    }

    static {
        oWD.start();
    }

    public void destory() {
        if (this.oWE != null) {
            this.oWE.destory();
        }
    }

    /* loaded from: classes4.dex */
    public static class b<T> {
        private List<T> mList = new ArrayList();
        private boolean mHasMore = false;

        public List<T> getList() {
            return this.mList;
        }
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0975a<ChatSession> interfaceC0975a) {
        b(interfaceC0975a);
    }

    private void b(final InterfaceC0975a<ChatSession> interfaceC0975a) {
        final AtomicInteger atomicInteger = new AtomicInteger(2);
        final b bVar = new b();
        c(new InterfaceC0975a<ChatSession>() { // from class: com.baidu.yuyinala.privatemessage.session.a.1
            @Override // com.baidu.yuyinala.privatemessage.session.a.InterfaceC0975a
            public void a(b<ChatSession> bVar2) {
                bVar.mList.addAll(((b) bVar2).mList);
                if (atomicInteger.decrementAndGet() == 0) {
                    a.this.a(bVar, interfaceC0975a);
                }
            }
        });
        a(new InterfaceC0975a<ChatSession>() { // from class: com.baidu.yuyinala.privatemessage.session.a.2
            @Override // com.baidu.yuyinala.privatemessage.session.a.InterfaceC0975a
            public void a(b<ChatSession> bVar2) {
                for (ChatSession chatSession : ((b) bVar2).mList) {
                    chatSession.setLastMsgTime(chatSession.getLastMsgTime() / 1000);
                    bVar.mList.add(chatSession);
                }
                bVar.mHasMore = ((b) bVar2).mHasMore;
                if (!bVar.mHasMore && atomicInteger.decrementAndGet() == 0) {
                    a.this.a(bVar, interfaceC0975a);
                }
            }
        }, 0L, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b<ChatSession> bVar, final InterfaceC0975a<ChatSession> interfaceC0975a) {
        Collections.sort(((b) bVar).mList, new Comparator<ChatSession>() { // from class: com.baidu.yuyinala.privatemessage.session.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(ChatSession chatSession, ChatSession chatSession2) {
                return (int) (chatSession2.getLastMsgTime() - chatSession.getLastMsgTime());
            }
        });
        if (bVar != null && ((b) bVar).mList != null) {
            this.oWE.a(gL(((b) bVar).mList), new b.a() { // from class: com.baidu.yuyinala.privatemessage.session.a.4
                @Override // com.baidu.yuyinala.privatemessage.model.b.a
                public void gK(List<f> list) {
                    a.this.F(bVar.mList, list);
                    if (interfaceC0975a != null) {
                        interfaceC0975a.a(bVar);
                    }
                }

                @Override // com.baidu.yuyinala.privatemessage.model.b.a
                public void onFail(int i, String str) {
                    if (interfaceC0975a != null) {
                        interfaceC0975a.a(bVar);
                    }
                }
            });
        } else if (interfaceC0975a != null) {
            interfaceC0975a.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(List<ChatSession> list, List<f> list2) {
        if (list != null && list2 != null) {
            for (ChatSession chatSession : list) {
                String encryptionUserId = ExtraParamsManager.getEncryptionUserId(String.valueOf(chatSession.getContacterId()));
                Iterator<f> it = list2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        f next = it.next();
                        if (TextUtils.equals(encryptionUserId, next.uk) && !TextUtils.isEmpty(next.bd_portrait)) {
                            chatSession.setIconUrl(next.bd_portrait);
                        }
                        if (TextUtils.equals(encryptionUserId, next.uk) && !TextUtils.isEmpty(next.user_nickname)) {
                            chatSession.setNickName(next.user_nickname);
                            break;
                        }
                    }
                }
            }
        }
    }

    private String gL(List<ChatSession> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                if (i2 > 0) {
                    sb.append(",");
                }
                sb.append(ExtraParamsManager.getEncryptionUserId(String.valueOf(list.get(i2).getContacterId())));
                i = i2 + 1;
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.yuyinala.privatemessage.session.a$5  reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass5 implements Runnable {
        final /* synthetic */ InterfaceC0975a oWH;

        AnonymousClass5(InterfaceC0975a interfaceC0975a) {
            this.oWH = interfaceC0975a;
        }

        @Override // java.lang.Runnable
        public void run() {
            final AtomicInteger atomicInteger = new AtomicInteger(1);
            final b bVar = new b();
            a.this.a(BIMManager.CATEGORY.ALL, new InterfaceC0975a<ChatSession>() { // from class: com.baidu.yuyinala.privatemessage.session.a.5.1
                @Override // com.baidu.yuyinala.privatemessage.session.a.InterfaceC0975a
                public void a(b<ChatSession> bVar2) {
                    for (ChatSession chatSession : ((b) bVar2).mList) {
                        if (chatSession.getContacterId() >= 0) {
                            bVar.mList.add(chatSession);
                        }
                    }
                    atomicInteger.decrementAndGet();
                    if (atomicInteger.get() == 0) {
                        a.this.mMainHandler.post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.a.5.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass5.this.oWH.a(bVar);
                            }
                        });
                    }
                }
            });
        }
    }

    private void c(InterfaceC0975a<ChatSession> interfaceC0975a) {
        this.mSchedulerHandler.post(new AnonymousClass5(interfaceC0975a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BIMManager.CATEGORY category, final InterfaceC0975a<ChatSession> interfaceC0975a) {
        final b bVar = new b();
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(3);
        arrayList.add(19);
        arrayList.add(23);
        arrayList.add(7);
        BIMManager.getChatSession(this.mContext, arrayList, new IGetSessionListener() { // from class: com.baidu.yuyinala.privatemessage.session.a.6
            @Override // com.baidu.android.imsdk.chatmessage.IGetSessionListener
            public void onGetSessionResult(final List<ChatSession> list) {
                if (list == null || list.isEmpty()) {
                    a.this.mSchedulerHandler.post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (list == null || list.isEmpty()) {
                                bVar.mList = Collections.emptyList();
                                interfaceC0975a.a(bVar);
                                return;
                            }
                            bVar.mList = list;
                            interfaceC0975a.a(bVar);
                        }
                    });
                    return;
                }
                bVar.mList = list;
                interfaceC0975a.a(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final InterfaceC0975a<ChatSession> interfaceC0975a, long j, boolean z) {
        if (z) {
            BIMManager.mediaGetChatSessions(this.mContext, 0L, j, 20, new IMediaGetChatSessionListener() { // from class: com.baidu.yuyinala.privatemessage.session.a.7
                @Override // com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener
                public void onMediaGetChatSessionResult(int i, int i2, final boolean z2, List<ChatSession> list) {
                    final b bVar = new b();
                    if (list == null) {
                        list = Collections.emptyList();
                    }
                    bVar.mList = list;
                    bVar.mHasMore = z2;
                    Collections.sort(bVar.mList, new Comparator<ChatSession>() { // from class: com.baidu.yuyinala.privatemessage.session.a.7.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        public int compare(ChatSession chatSession, ChatSession chatSession2) {
                            return (int) (chatSession2.getLastMsgTime() - chatSession.getLastMsgTime());
                        }
                    });
                    a.this.mMainHandler.post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.a.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            interfaceC0975a.a(bVar);
                            long j2 = 0;
                            if (!bVar.mList.isEmpty()) {
                                j2 = ((ChatSession) bVar.mList.get(bVar.mList.size() - 1)).getLastMsgTime();
                            }
                            a.this.a(interfaceC0975a, j2, z2);
                        }
                    });
                }
            });
        }
    }
}
