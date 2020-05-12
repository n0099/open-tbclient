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
    private static TbVideoViewSet kiX = null;
    private LRULinkedHashMap<String, com.baidu.tieba.play.a.a> kiW = new LRULinkedHashMap<>();
    private boolean kiY;

    /* loaded from: classes.dex */
    public interface a {
        void cKv();

        void cKw();
    }

    private TbVideoViewSet() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbVideoViewSet.this.avZ();
                }
            }
        });
    }

    public static TbVideoViewSet cKu() {
        if (kiX == null) {
            synchronized (TbVideoViewSet.class) {
                if (kiX == null) {
                    kiX = new TbVideoViewSet();
                }
            }
        }
        return kiX;
    }

    public com.baidu.tieba.play.a.a IP(String str) {
        if (aq.isEmpty(str) || !this.kiW.containsKey(str)) {
            return null;
        }
        return this.kiW.get(str);
    }

    public void a(com.baidu.tieba.play.a.a aVar, String str) {
        String str2;
        if (this.kiW.containsKey(str) && aVar != this.kiW.get(str)) {
            com.baidu.tieba.play.a.a aVar2 = this.kiW.get(str);
            if (aVar2 != null && aVar2.isPlaying()) {
                aVar2.stopPlayback();
            }
        } else if (this.kiW.containsValue(aVar)) {
            Iterator it = this.kiW.entrySet().iterator();
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
            if (!this.kiY && !aq.isEmpty(str2)) {
                this.kiW.remove(str2);
            }
        }
        this.kiW.put(str, aVar);
    }

    public void IQ(String str) {
        com.baidu.tieba.play.a.a aVar;
        if (!this.kiY && this.kiW.containsKey(str) && (aVar = (com.baidu.tieba.play.a.a) this.kiW.remove(str)) != null) {
            aVar.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avZ() {
        Iterator it = this.kiW.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                if (!aq.isEmpty((String) entry.getKey())) {
                    s.aq(TbadkCoreApplication.getInst().getContext(), (String) entry.getKey());
                }
                com.baidu.tieba.play.a.a aVar = (com.baidu.tieba.play.a.a) entry.getValue();
                if (aVar != null) {
                    this.kiY = true;
                    aVar.stopPlayback();
                    this.kiY = false;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class LRULinkedHashMap<K extends String, V> extends LinkedHashMap<K, com.baidu.tieba.play.a.a> {
        public static final int MAX_PLAYERS = 3;
        private static final long serialVersionUID = 1;

        LRULinkedHashMap() {
            super(3, 0.75f, true);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, com.baidu.tieba.play.a.a> entry) {
            com.baidu.tieba.play.a.a value;
            boolean z = size() > 3;
            if (z && (value = entry.getValue()) != null) {
                TbVideoViewSet.this.kiY = true;
                value.cJO();
                value.stopPlayback();
                TbVideoViewSet.this.kiY = false;
            }
            return z;
        }
    }
}
