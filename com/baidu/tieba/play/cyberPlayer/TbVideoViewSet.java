package com.baidu.tieba.play.cyberPlayer;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.play.s;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class TbVideoViewSet {
    private static TbVideoViewSet jwq = null;
    private LRULinkedHashMap<String, com.baidu.tieba.play.a.a> jwp = new LRULinkedHashMap<>();
    private boolean jwr;

    /* loaded from: classes.dex */
    public interface a {
        void cya();

        void cyb();
    }

    private TbVideoViewSet() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbVideoViewSet.this.alu();
                }
            }
        });
    }

    public static TbVideoViewSet cxZ() {
        if (jwq == null) {
            synchronized (TbVideoViewSet.class) {
                if (jwq == null) {
                    jwq = new TbVideoViewSet();
                }
            }
        }
        return jwq;
    }

    public com.baidu.tieba.play.a.a GQ(String str) {
        if (aq.isEmpty(str) || !this.jwp.containsKey(str)) {
            return null;
        }
        return this.jwp.get(str);
    }

    public void a(com.baidu.tieba.play.a.a aVar, String str) {
        String str2;
        if (this.jwp.containsKey(str) && aVar != this.jwp.get(str)) {
            com.baidu.tieba.play.a.a aVar2 = this.jwp.get(str);
            if (aVar2 != null && aVar2.isPlaying()) {
                aVar.stopPlayback();
            }
        } else if (this.jwp.containsValue(aVar)) {
            Iterator it = this.jwp.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str2 = null;
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (entry.getValue() == aVar) {
                    str2 = (String) entry.getKey();
                    break;
                }
            }
            if (!this.jwr && !aq.isEmpty(str2)) {
                this.jwp.remove(str2);
            }
        }
        this.jwp.put(str, aVar);
    }

    public void GR(String str) {
        com.baidu.tieba.play.a.a aVar;
        if (!this.jwr && this.jwp.containsKey(str) && (aVar = (com.baidu.tieba.play.a.a) this.jwp.remove(str)) != null) {
            aVar.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alu() {
        Iterator it = this.jwp.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                if (!aq.isEmpty((String) entry.getKey())) {
                    s.aI(TbadkCoreApplication.getInst().getContext(), (String) entry.getKey());
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class LRULinkedHashMap<K extends String, V> extends LinkedHashMap<K, com.baidu.tieba.play.a.a> {
        public static final int MAX_PLAYERS = 2;
        private static final long serialVersionUID = 1;

        LRULinkedHashMap() {
            super(2, 0.75f, true);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, com.baidu.tieba.play.a.a> entry) {
            com.baidu.tieba.play.a.a value;
            boolean z = size() > 2;
            if (z && (value = entry.getValue()) != null) {
                TbVideoViewSet.this.jwr = true;
                value.cxv();
                value.stopPlayback();
                TbVideoViewSet.this.jwr = false;
            }
            return z;
        }
    }
}
