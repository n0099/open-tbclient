package com.baidu.tieba.play.cyberPlayer;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import d.a.c.e.p.k;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class TbVideoViewSet {

    /* renamed from: c  reason: collision with root package name */
    public static TbVideoViewSet f20113c;

    /* renamed from: a  reason: collision with root package name */
    public LRULinkedHashMap<String, TbCyberVideoView> f20114a = new LRULinkedHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f20115b;

    /* loaded from: classes5.dex */
    public class LRULinkedHashMap<K extends String, V> extends LinkedHashMap<K, TbCyberVideoView> {
        public static final int MAX_PLAYERS = 3;
        public static final long serialVersionUID = 1;

        public LRULinkedHashMap() {
            super(3, 0.75f, true);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, TbCyberVideoView> entry) {
            TbCyberVideoView value;
            boolean z = size() > 3;
            if (z && (value = entry.getValue()) != null) {
                TbVideoViewSet.this.f20115b = true;
                value.G();
                value.stopPlayback();
                TbVideoViewSet.this.f20115b = false;
            }
            return z;
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                TbVideoViewSet.this.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a();

        void b();
    }

    public TbVideoViewSet() {
        MessageManager.getInstance().registerListener(new a(2001011));
    }

    public static TbVideoViewSet d() {
        if (f20113c == null) {
            synchronized (TbVideoViewSet.class) {
                if (f20113c == null) {
                    f20113c = new TbVideoViewSet();
                }
            }
        }
        return f20113c;
    }

    public final void c() {
        Iterator it = this.f20114a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) entry.getValue();
                if (tbCyberVideoView != null) {
                    this.f20115b = true;
                    tbCyberVideoView.stopPlayback();
                    this.f20115b = false;
                }
                it.remove();
            }
        }
    }

    public TbCyberVideoView e(String str) {
        if (k.isEmpty(str) || !this.f20114a.containsKey(str)) {
            return null;
        }
        return this.f20114a.get(str);
    }

    public void f(String str) {
        TbCyberVideoView remove;
        if (this.f20115b || !this.f20114a.containsKey(str) || (remove = this.f20114a.remove(str)) == null) {
            return;
        }
        remove.stopPlayback();
    }

    public void g(TbCyberVideoView tbCyberVideoView, String str) {
        if (this.f20114a.containsKey(str) && tbCyberVideoView != this.f20114a.get(str)) {
            TbCyberVideoView tbCyberVideoView2 = this.f20114a.get(str);
            if (tbCyberVideoView2 != null && tbCyberVideoView2.isPlaying()) {
                tbCyberVideoView2.stopPlayback();
            }
        } else if (this.f20114a.containsValue(tbCyberVideoView)) {
            String str2 = null;
            Iterator it = this.f20114a.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (entry.getValue() == tbCyberVideoView) {
                    str2 = (String) entry.getKey();
                    break;
                }
            }
            if (!this.f20115b && !k.isEmpty(str2)) {
                this.f20114a.remove(str2);
            }
        }
        this.f20114a.put(str, tbCyberVideoView);
    }
}
