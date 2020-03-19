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
    private static TbVideoViewSet jyU = null;
    private LRULinkedHashMap<String, com.baidu.tieba.play.a.a> jyT = new LRULinkedHashMap<>();
    private boolean jyV;

    /* loaded from: classes.dex */
    public interface a {
        void czQ();

        void czR();
    }

    private TbVideoViewSet() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbVideoViewSet.this.anM();
                }
            }
        });
    }

    public static TbVideoViewSet czP() {
        if (jyU == null) {
            synchronized (TbVideoViewSet.class) {
                if (jyU == null) {
                    jyU = new TbVideoViewSet();
                }
            }
        }
        return jyU;
    }

    public com.baidu.tieba.play.a.a Hf(String str) {
        if (aq.isEmpty(str) || !this.jyT.containsKey(str)) {
            return null;
        }
        return this.jyT.get(str);
    }

    public void a(com.baidu.tieba.play.a.a aVar, String str) {
        String str2;
        if (this.jyT.containsKey(str) && aVar != this.jyT.get(str)) {
            com.baidu.tieba.play.a.a aVar2 = this.jyT.get(str);
            if (aVar2 != null && aVar2.isPlaying()) {
                aVar.stopPlayback();
            }
        } else if (this.jyT.containsValue(aVar)) {
            Iterator it = this.jyT.entrySet().iterator();
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
            if (!this.jyV && !aq.isEmpty(str2)) {
                this.jyT.remove(str2);
            }
        }
        this.jyT.put(str, aVar);
    }

    public void Hg(String str) {
        com.baidu.tieba.play.a.a aVar;
        if (!this.jyV && this.jyT.containsKey(str) && (aVar = (com.baidu.tieba.play.a.a) this.jyT.remove(str)) != null) {
            aVar.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anM() {
        Iterator it = this.jyT.entrySet().iterator();
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
                TbVideoViewSet.this.jyV = true;
                value.czl();
                value.stopPlayback();
                TbVideoViewSet.this.jyV = false;
            }
            return z;
        }
    }
}
