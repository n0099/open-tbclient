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
    private static TbVideoViewSet jxv = null;
    private LRULinkedHashMap<String, com.baidu.tieba.play.a.a> jxu = new LRULinkedHashMap<>();
    private boolean jxw;

    /* loaded from: classes.dex */
    public interface a {
        void czx();

        void czy();
    }

    private TbVideoViewSet() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbVideoViewSet.this.anJ();
                }
            }
        });
    }

    public static TbVideoViewSet czw() {
        if (jxv == null) {
            synchronized (TbVideoViewSet.class) {
                if (jxv == null) {
                    jxv = new TbVideoViewSet();
                }
            }
        }
        return jxv;
    }

    public com.baidu.tieba.play.a.a Hf(String str) {
        if (aq.isEmpty(str) || !this.jxu.containsKey(str)) {
            return null;
        }
        return this.jxu.get(str);
    }

    public void a(com.baidu.tieba.play.a.a aVar, String str) {
        String str2;
        if (this.jxu.containsKey(str) && aVar != this.jxu.get(str)) {
            com.baidu.tieba.play.a.a aVar2 = this.jxu.get(str);
            if (aVar2 != null && aVar2.isPlaying()) {
                aVar.stopPlayback();
            }
        } else if (this.jxu.containsValue(aVar)) {
            Iterator it = this.jxu.entrySet().iterator();
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
            if (!this.jxw && !aq.isEmpty(str2)) {
                this.jxu.remove(str2);
            }
        }
        this.jxu.put(str, aVar);
    }

    public void Hg(String str) {
        com.baidu.tieba.play.a.a aVar;
        if (!this.jxw && this.jxu.containsKey(str) && (aVar = (com.baidu.tieba.play.a.a) this.jxu.remove(str)) != null) {
            aVar.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anJ() {
        Iterator it = this.jxu.entrySet().iterator();
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
                TbVideoViewSet.this.jxw = true;
                value.cyS();
                value.stopPlayback();
                TbVideoViewSet.this.jxw = false;
            }
            return z;
        }
    }
}
