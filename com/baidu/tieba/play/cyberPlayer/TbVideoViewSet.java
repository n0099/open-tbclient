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
    private static TbVideoViewSet kiT = null;
    private LRULinkedHashMap<String, com.baidu.tieba.play.a.a> kiS = new LRULinkedHashMap<>();
    private boolean kiU;

    /* loaded from: classes.dex */
    public interface a {
        void cKx();

        void cKy();
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

    public static TbVideoViewSet cKw() {
        if (kiT == null) {
            synchronized (TbVideoViewSet.class) {
                if (kiT == null) {
                    kiT = new TbVideoViewSet();
                }
            }
        }
        return kiT;
    }

    public com.baidu.tieba.play.a.a IM(String str) {
        if (aq.isEmpty(str) || !this.kiS.containsKey(str)) {
            return null;
        }
        return this.kiS.get(str);
    }

    public void a(com.baidu.tieba.play.a.a aVar, String str) {
        String str2;
        if (this.kiS.containsKey(str) && aVar != this.kiS.get(str)) {
            com.baidu.tieba.play.a.a aVar2 = this.kiS.get(str);
            if (aVar2 != null && aVar2.isPlaying()) {
                aVar2.stopPlayback();
            }
        } else if (this.kiS.containsValue(aVar)) {
            Iterator it = this.kiS.entrySet().iterator();
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
            if (!this.kiU && !aq.isEmpty(str2)) {
                this.kiS.remove(str2);
            }
        }
        this.kiS.put(str, aVar);
    }

    public void IN(String str) {
        com.baidu.tieba.play.a.a aVar;
        if (!this.kiU && this.kiS.containsKey(str) && (aVar = (com.baidu.tieba.play.a.a) this.kiS.remove(str)) != null) {
            aVar.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avZ() {
        Iterator it = this.kiS.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                if (!aq.isEmpty((String) entry.getKey())) {
                    s.aC(TbadkCoreApplication.getInst().getContext(), (String) entry.getKey());
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
                TbVideoViewSet.this.kiU = true;
                value.cJQ();
                value.stopPlayback();
                TbVideoViewSet.this.kiU = false;
            }
            return z;
        }
    }
}
