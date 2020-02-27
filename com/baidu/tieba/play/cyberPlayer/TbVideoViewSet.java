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
    private static TbVideoViewSet jxh = null;
    private LRULinkedHashMap<String, com.baidu.tieba.play.a.a> jxg = new LRULinkedHashMap<>();
    private boolean jxi;

    /* loaded from: classes.dex */
    public interface a {
        void czu();

        void czv();
    }

    private TbVideoViewSet() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbVideoViewSet.this.anH();
                }
            }
        });
    }

    public static TbVideoViewSet czt() {
        if (jxh == null) {
            synchronized (TbVideoViewSet.class) {
                if (jxh == null) {
                    jxh = new TbVideoViewSet();
                }
            }
        }
        return jxh;
    }

    public com.baidu.tieba.play.a.a He(String str) {
        if (aq.isEmpty(str) || !this.jxg.containsKey(str)) {
            return null;
        }
        return this.jxg.get(str);
    }

    public void a(com.baidu.tieba.play.a.a aVar, String str) {
        String str2;
        if (this.jxg.containsKey(str) && aVar != this.jxg.get(str)) {
            com.baidu.tieba.play.a.a aVar2 = this.jxg.get(str);
            if (aVar2 != null && aVar2.isPlaying()) {
                aVar.stopPlayback();
            }
        } else if (this.jxg.containsValue(aVar)) {
            Iterator it = this.jxg.entrySet().iterator();
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
            if (!this.jxi && !aq.isEmpty(str2)) {
                this.jxg.remove(str2);
            }
        }
        this.jxg.put(str, aVar);
    }

    public void Hf(String str) {
        com.baidu.tieba.play.a.a aVar;
        if (!this.jxi && this.jxg.containsKey(str) && (aVar = (com.baidu.tieba.play.a.a) this.jxg.remove(str)) != null) {
            aVar.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anH() {
        Iterator it = this.jxg.entrySet().iterator();
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
                TbVideoViewSet.this.jxi = true;
                value.cyP();
                value.stopPlayback();
                TbVideoViewSet.this.jxi = false;
            }
            return z;
        }
    }
}
