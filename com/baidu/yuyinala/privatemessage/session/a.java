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
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public class a {
    private static HandlerThread oFT = new HandlerThread("ChatCoreDataLoader");
    private Context mContext;
    private Handler mSchedulerHandler = new Handler(oFT.getLooper());
    private Handler mMainHandler = new Handler(Looper.getMainLooper());
    private com.baidu.yuyinala.privatemessage.model.b oFU = new com.baidu.yuyinala.privatemessage.model.b();

    /* renamed from: com.baidu.yuyinala.privatemessage.session.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0955a<T> {
        void a(b<T> bVar);
    }

    static {
        oFT.start();
    }

    public void destory() {
        if (this.oFU != null) {
            this.oFU.destory();
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

    public void a(InterfaceC0955a<ChatSession> interfaceC0955a) {
        b(interfaceC0955a);
    }

    private void b(final InterfaceC0955a<ChatSession> interfaceC0955a) {
        final AtomicInteger atomicInteger = new AtomicInteger(2);
        final b bVar = new b();
        c(new InterfaceC0955a<ChatSession>() { // from class: com.baidu.yuyinala.privatemessage.session.a.1
            @Override // com.baidu.yuyinala.privatemessage.session.a.InterfaceC0955a
            public void a(b<ChatSession> bVar2) {
                bVar.mList.addAll(((b) bVar2).mList);
                if (atomicInteger.decrementAndGet() == 0) {
                    a.this.a(bVar, interfaceC0955a);
                }
            }
        });
        a(new InterfaceC0955a<ChatSession>() { // from class: com.baidu.yuyinala.privatemessage.session.a.2
            @Override // com.baidu.yuyinala.privatemessage.session.a.InterfaceC0955a
            public void a(b<ChatSession> bVar2) {
                for (ChatSession chatSession : ((b) bVar2).mList) {
                    chatSession.setLastMsgTime(chatSession.getLastMsgTime() / 1000);
                    bVar.mList.add(chatSession);
                }
                bVar.mHasMore = ((b) bVar2).mHasMore;
                if (!bVar.mHasMore && atomicInteger.decrementAndGet() == 0) {
                    a.this.a(bVar, interfaceC0955a);
                }
            }
        }, 0L, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b<ChatSession> bVar, final InterfaceC0955a<ChatSession> interfaceC0955a) {
        Collections.sort(((b) bVar).mList, new Comparator<ChatSession>() { // from class: com.baidu.yuyinala.privatemessage.session.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            public int compare(ChatSession chatSession, ChatSession chatSession2) {
                return (int) (chatSession2.getLastMsgTime() - chatSession.getLastMsgTime());
            }
        });
        if (bVar != null && ((b) bVar).mList != null) {
            this.oFU.a(gw(((b) bVar).mList), new b.a() { // from class: com.baidu.yuyinala.privatemessage.session.a.4
                @Override // com.baidu.yuyinala.privatemessage.model.b.a
                public void gv(List<f> list) {
                    a.this.F(bVar.mList, list);
                    if (interfaceC0955a != null) {
                        interfaceC0955a.a(bVar);
                    }
                }

                @Override // com.baidu.yuyinala.privatemessage.model.b.a
                public void onFail(int i, String str) {
                    if (interfaceC0955a != null) {
                        interfaceC0955a.a(bVar);
                    }
                }
            });
        } else if (interfaceC0955a != null) {
            interfaceC0955a.a(bVar);
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

    private String gw(List<ChatSession> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.size()) {
                    break;
                }
                if (i2 > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
        final /* synthetic */ InterfaceC0955a oFX;

        AnonymousClass5(InterfaceC0955a interfaceC0955a) {
            this.oFX = interfaceC0955a;
        }

        @Override // java.lang.Runnable
        public void run() {
            final AtomicInteger atomicInteger = new AtomicInteger(1);
            final b bVar = new b();
            a.this.a(BIMManager.CATEGORY.ALL, new InterfaceC0955a<ChatSession>() { // from class: com.baidu.yuyinala.privatemessage.session.a.5.1
                @Override // com.baidu.yuyinala.privatemessage.session.a.InterfaceC0955a
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
                                AnonymousClass5.this.oFX.a(bVar);
                            }
                        });
                    }
                }
            });
        }
    }

    private void c(InterfaceC0955a<ChatSession> interfaceC0955a) {
        this.mSchedulerHandler.post(new AnonymousClass5(interfaceC0955a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BIMManager.CATEGORY category, final InterfaceC0955a<ChatSession> interfaceC0955a) {
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
                                interfaceC0955a.a(bVar);
                                return;
                            }
                            bVar.mList = list;
                            interfaceC0955a.a(bVar);
                        }
                    });
                    return;
                }
                bVar.mList = list;
                interfaceC0955a.a(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final InterfaceC0955a<ChatSession> interfaceC0955a, long j, boolean z) {
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
                            interfaceC0955a.a(bVar);
                            long j2 = 0;
                            if (!bVar.mList.isEmpty()) {
                                j2 = ((ChatSession) bVar.mList.get(bVar.mList.size() - 1)).getLastMsgTime();
                            }
                            a.this.a(interfaceC0955a, j2, z2);
                        }
                    });
                }
            });
        }
    }
}
