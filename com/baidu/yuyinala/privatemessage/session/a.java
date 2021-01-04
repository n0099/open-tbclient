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
import com.baidu.yuyinala.privatemessage.session.activity.ChatListActivity;
import com.baidu.yuyinala.privatemessage.session.b.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes11.dex */
public class a {
    private static HandlerThread pcB = new HandlerThread("ChatCoreDataLoader");
    private Context mContext;
    private Handler mSchedulerHandler = new Handler(pcB.getLooper());
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    private com.baidu.yuyinala.privatemessage.model.b pcC = new com.baidu.yuyinala.privatemessage.model.b();

    /* renamed from: com.baidu.yuyinala.privatemessage.session.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0951a<T> {
        void a(b<T> bVar);
    }

    static {
        pcB.start();
    }

    public void destory() {
        if (this.pcC != null) {
            this.pcC.destory();
        }
    }

    /* loaded from: classes11.dex */
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

    public void a(InterfaceC0951a<ChatSession> interfaceC0951a) {
        b(interfaceC0951a);
    }

    private void b(final InterfaceC0951a<ChatSession> interfaceC0951a) {
        final AtomicInteger atomicInteger = new AtomicInteger(2);
        final b bVar = new b();
        c(new InterfaceC0951a<ChatSession>() { // from class: com.baidu.yuyinala.privatemessage.session.a.1
            @Override // com.baidu.yuyinala.privatemessage.session.a.InterfaceC0951a
            public void a(b<ChatSession> bVar2) {
                bVar.mList.addAll(((b) bVar2).mList);
                if (atomicInteger.decrementAndGet() == 0) {
                    a.this.a(bVar, interfaceC0951a);
                }
            }
        });
        a(new InterfaceC0951a<ChatSession>() { // from class: com.baidu.yuyinala.privatemessage.session.a.2
            @Override // com.baidu.yuyinala.privatemessage.session.a.InterfaceC0951a
            public void a(b<ChatSession> bVar2) {
                for (ChatSession chatSession : ((b) bVar2).mList) {
                    chatSession.setLastMsgTime(chatSession.getLastMsgTime() / 1000);
                    bVar.mList.add(chatSession);
                }
                bVar.mHasMore = ((b) bVar2).mHasMore;
                if (atomicInteger.decrementAndGet() == 0) {
                    a.this.a(bVar, interfaceC0951a);
                }
            }
        }, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b<ChatSession> bVar, final InterfaceC0951a<ChatSession> interfaceC0951a) {
        Collections.sort(((b) bVar).mList, new Comparator<ChatSession>() { // from class: com.baidu.yuyinala.privatemessage.session.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(ChatSession chatSession, ChatSession chatSession2) {
                return (int) (chatSession2.getLastMsgTime() - chatSession.getLastMsgTime());
            }
        });
        if (bVar != null && ((b) bVar).mList != null) {
            this.pcC.a(gD(((b) bVar).mList), new b.a() { // from class: com.baidu.yuyinala.privatemessage.session.a.4
                @Override // com.baidu.yuyinala.privatemessage.model.b.a
                public void gC(List<f> list) {
                    a.I(bVar.mList, list);
                    if (interfaceC0951a != null) {
                        interfaceC0951a.a(bVar);
                    }
                }

                @Override // com.baidu.yuyinala.privatemessage.model.b.a
                public void onFail(int i, String str) {
                    if (interfaceC0951a != null) {
                        interfaceC0951a.a(bVar);
                    }
                }
            });
        } else if (interfaceC0951a != null) {
            interfaceC0951a.a(bVar);
        }
    }

    public static void I(List<ChatSession> list, List<f> list2) {
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

    public static String gD(List<ChatSession> list) {
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
    /* loaded from: classes11.dex */
    public class AnonymousClass5 implements Runnable {
        final /* synthetic */ InterfaceC0951a pcF;

        AnonymousClass5(InterfaceC0951a interfaceC0951a) {
            this.pcF = interfaceC0951a;
        }

        @Override // java.lang.Runnable
        public void run() {
            final AtomicInteger atomicInteger = new AtomicInteger(1);
            final b bVar = new b();
            a.this.a(BIMManager.CATEGORY.ALL, new InterfaceC0951a<ChatSession>() { // from class: com.baidu.yuyinala.privatemessage.session.a.5.1
                @Override // com.baidu.yuyinala.privatemessage.session.a.InterfaceC0951a
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
                                AnonymousClass5.this.pcF.a(bVar);
                            }
                        });
                    }
                }
            });
        }
    }

    private void c(InterfaceC0951a<ChatSession> interfaceC0951a) {
        this.mSchedulerHandler.post(new AnonymousClass5(interfaceC0951a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BIMManager.CATEGORY category, final InterfaceC0951a<ChatSession> interfaceC0951a) {
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
                                interfaceC0951a.a(bVar);
                                return;
                            }
                            bVar.mList = list;
                            interfaceC0951a.a(bVar);
                        }
                    });
                    return;
                }
                bVar.mList = list;
                interfaceC0951a.a(bVar);
            }
        });
    }

    private void a(final InterfaceC0951a<ChatSession> interfaceC0951a, long j) {
        BIMManager.mediaGetChatSessions(this.mContext, 0L, j, 10, new IMediaGetChatSessionListener() { // from class: com.baidu.yuyinala.privatemessage.session.a.7
            @Override // com.baidu.android.imsdk.chatmessage.IMediaGetChatSessionListener
            public void onMediaGetChatSessionResult(int i, int i2, boolean z, List<ChatSession> list) {
                final b bVar = new b();
                if (list == null) {
                    list = Collections.emptyList();
                }
                bVar.mList = list;
                bVar.mHasMore = z;
                Collections.sort(bVar.mList, new Comparator<ChatSession>() { // from class: com.baidu.yuyinala.privatemessage.session.a.7.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // java.util.Comparator
                    public int compare(ChatSession chatSession, ChatSession chatSession2) {
                        return (int) (chatSession2.getLastMsgTime() - chatSession.getLastMsgTime());
                    }
                });
                if (!bVar.mList.isEmpty()) {
                    ChatListActivity.pdf = ((ChatSession) bVar.mList.get(bVar.mList.size() - 1)).getLastMsgTime();
                }
                a.this.mMainHandler.post(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.session.a.7.2
                    @Override // java.lang.Runnable
                    public void run() {
                        interfaceC0951a.a(bVar);
                    }
                });
            }
        });
    }
}
