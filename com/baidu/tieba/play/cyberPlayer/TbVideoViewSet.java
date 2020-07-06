package com.baidu.tieba.play.cyberPlayer;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.play.s;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class TbVideoViewSet {
    private static TbVideoViewSet kVW = null;
    private LRULinkedHashMap<String, com.baidu.tieba.play.a.a> kVV = new LRULinkedHashMap<>();
    private boolean kVX;

    /* loaded from: classes.dex */
    public interface a {
        void cWc();

        void cWd();
    }

    private TbVideoViewSet() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbVideoViewSet.this.aAW();
                }
            }
        });
    }

    public static TbVideoViewSet cWb() {
        if (kVW == null) {
            synchronized (TbVideoViewSet.class) {
                if (kVW == null) {
                    kVW = new TbVideoViewSet();
                }
            }
        }
        return kVW;
    }

    public com.baidu.tieba.play.a.a Ld(String str) {
        if (ar.isEmpty(str) || !this.kVV.containsKey(str)) {
            return null;
        }
        return this.kVV.get(str);
    }

    public void a(com.baidu.tieba.play.a.a aVar, String str) {
        String str2;
        if (this.kVV.containsKey(str) && aVar != this.kVV.get(str)) {
            com.baidu.tieba.play.a.a aVar2 = this.kVV.get(str);
            if (aVar2 != null && aVar2.isPlaying()) {
                aVar2.stopPlayback();
            }
        } else if (this.kVV.containsValue(aVar)) {
            Iterator it = this.kVV.entrySet().iterator();
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
            if (!this.kVX && !ar.isEmpty(str2)) {
                this.kVV.remove(str2);
            }
        }
        this.kVV.put(str, aVar);
    }

    public void Le(String str) {
        com.baidu.tieba.play.a.a aVar;
        if (!this.kVX && this.kVV.containsKey(str) && (aVar = (com.baidu.tieba.play.a.a) this.kVV.remove(str)) != null) {
            aVar.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAW() {
        Iterator it = this.kVV.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                if (!ar.isEmpty((String) entry.getKey())) {
                    s.ar(TbadkCoreApplication.getInst().getContext(), (String) entry.getKey());
                }
                com.baidu.tieba.play.a.a aVar = (com.baidu.tieba.play.a.a) entry.getValue();
                if (aVar != null) {
                    this.kVX = true;
                    aVar.stopPlayback();
                    this.kVX = false;
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
                TbVideoViewSet.this.kVX = true;
                value.cVv();
                value.stopPlayback();
                TbVideoViewSet.this.kVX = false;
            }
            return z;
        }
    }
}
