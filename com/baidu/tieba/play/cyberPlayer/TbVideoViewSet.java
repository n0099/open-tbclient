package com.baidu.tieba.play.cyberPlayer;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import d.b.c.e.p.k;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class TbVideoViewSet {

    /* renamed from: c  reason: collision with root package name */
    public static TbVideoViewSet f20216c;

    /* renamed from: a  reason: collision with root package name */
    public LRULinkedHashMap<String, TbCyberVideoView> f20217a = new LRULinkedHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f20218b;

    /* loaded from: classes3.dex */
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
                TbVideoViewSet.this.f20218b = true;
                value.G();
                value.stopPlayback();
                TbVideoViewSet.this.f20218b = false;
            }
            return z;
        }
    }

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                TbVideoViewSet.this.c();
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void b();
    }

    public TbVideoViewSet() {
        MessageManager.getInstance().registerListener(new a(2001011));
    }

    public static TbVideoViewSet d() {
        if (f20216c == null) {
            synchronized (TbVideoViewSet.class) {
                if (f20216c == null) {
                    f20216c = new TbVideoViewSet();
                }
            }
        }
        return f20216c;
    }

    public final void c() {
        Iterator it = this.f20217a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) entry.getValue();
                if (tbCyberVideoView != null) {
                    this.f20218b = true;
                    tbCyberVideoView.stopPlayback();
                    this.f20218b = false;
                }
                it.remove();
            }
        }
    }

    public TbCyberVideoView e(String str) {
        if (k.isEmpty(str) || !this.f20217a.containsKey(str)) {
            return null;
        }
        return this.f20217a.get(str);
    }

    public void f(String str) {
        TbCyberVideoView remove;
        if (this.f20218b || !this.f20217a.containsKey(str) || (remove = this.f20217a.remove(str)) == null) {
            return;
        }
        remove.stopPlayback();
    }

    public void g(TbCyberVideoView tbCyberVideoView, String str) {
        if (this.f20217a.containsKey(str) && tbCyberVideoView != this.f20217a.get(str)) {
            TbCyberVideoView tbCyberVideoView2 = this.f20217a.get(str);
            if (tbCyberVideoView2 != null && tbCyberVideoView2.isPlaying()) {
                tbCyberVideoView2.stopPlayback();
            }
        } else if (this.f20217a.containsValue(tbCyberVideoView)) {
            String str2 = null;
            Iterator it = this.f20217a.entrySet().iterator();
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
            if (!this.f20218b && !k.isEmpty(str2)) {
                this.f20217a.remove(str2);
            }
        }
        this.f20217a.put(str, tbCyberVideoView);
    }
}
