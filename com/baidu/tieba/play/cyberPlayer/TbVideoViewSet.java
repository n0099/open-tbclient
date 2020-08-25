package com.baidu.tieba.play.cyberPlayer;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.at;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class TbVideoViewSet {
    private static TbVideoViewSet ltU = null;
    private LRULinkedHashMap<String, TbCyberVideoView> ltT = new LRULinkedHashMap<>();
    private boolean ltV;

    /* loaded from: classes2.dex */
    public interface a {
        void dks();

        void dkt();
    }

    private TbVideoViewSet() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbVideoViewSet.this.aoj();
                }
            }
        });
    }

    public static TbVideoViewSet dkr() {
        if (ltU == null) {
            synchronized (TbVideoViewSet.class) {
                if (ltU == null) {
                    ltU = new TbVideoViewSet();
                }
            }
        }
        return ltU;
    }

    public TbCyberVideoView OG(String str) {
        if (at.isEmpty(str) || !this.ltT.containsKey(str)) {
            return null;
        }
        return this.ltT.get(str);
    }

    public void a(TbCyberVideoView tbCyberVideoView, String str) {
        String str2;
        if (this.ltT.containsKey(str) && tbCyberVideoView != this.ltT.get(str)) {
            TbCyberVideoView tbCyberVideoView2 = this.ltT.get(str);
            if (tbCyberVideoView2 != null && tbCyberVideoView2.isPlaying()) {
                tbCyberVideoView2.stopPlayback();
            }
        } else if (this.ltT.containsValue(tbCyberVideoView)) {
            Iterator it = this.ltT.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str2 = null;
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (entry.getValue() == tbCyberVideoView) {
                    str2 = (String) entry.getKey();
                    break;
                }
            }
            if (!this.ltV && !at.isEmpty(str2)) {
                this.ltT.remove(str2);
            }
        }
        this.ltT.put(str, tbCyberVideoView);
    }

    public void OH(String str) {
        TbCyberVideoView tbCyberVideoView;
        if (!this.ltV && this.ltT.containsKey(str) && (tbCyberVideoView = (TbCyberVideoView) this.ltT.remove(str)) != null) {
            tbCyberVideoView.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoj() {
        Iterator it = this.ltT.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) entry.getValue();
                if (tbCyberVideoView != null) {
                    this.ltV = true;
                    tbCyberVideoView.stopPlayback();
                    this.ltV = false;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class LRULinkedHashMap<K extends String, V> extends LinkedHashMap<K, TbCyberVideoView> {
        public static final int MAX_PLAYERS = 3;
        private static final long serialVersionUID = 1;

        LRULinkedHashMap() {
            super(3, 0.75f, true);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, TbCyberVideoView> entry) {
            TbCyberVideoView value;
            boolean z = size() > 3;
            if (z && (value = entry.getValue()) != null) {
                TbVideoViewSet.this.ltV = true;
                value.dko();
                value.stopPlayback();
                TbVideoViewSet.this.ltV = false;
            }
            return z;
        }
    }
}
