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
/* loaded from: classes.dex */
public class TbVideoViewSet {
    private static TbVideoViewSet mkI = null;
    private LRULinkedHashMap<String, TbCyberVideoView> mkH = new LRULinkedHashMap<>();
    private boolean mkJ;

    /* loaded from: classes.dex */
    public interface a {
        void dxw();

        void dxx();
    }

    private TbVideoViewSet() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbVideoViewSet.this.awa();
                }
            }
        });
    }

    public static TbVideoViewSet dxv() {
        if (mkI == null) {
            synchronized (TbVideoViewSet.class) {
                if (mkI == null) {
                    mkI = new TbVideoViewSet();
                }
            }
        }
        return mkI;
    }

    public TbCyberVideoView QM(String str) {
        if (at.isEmpty(str) || !this.mkH.containsKey(str)) {
            return null;
        }
        return this.mkH.get(str);
    }

    public void a(TbCyberVideoView tbCyberVideoView, String str) {
        String str2;
        if (this.mkH.containsKey(str) && tbCyberVideoView != this.mkH.get(str)) {
            TbCyberVideoView tbCyberVideoView2 = this.mkH.get(str);
            if (tbCyberVideoView2 != null && tbCyberVideoView2.isPlaying()) {
                tbCyberVideoView2.stopPlayback();
            }
        } else if (this.mkH.containsValue(tbCyberVideoView)) {
            Iterator it = this.mkH.entrySet().iterator();
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
            if (!this.mkJ && !at.isEmpty(str2)) {
                this.mkH.remove(str2);
            }
        }
        this.mkH.put(str, tbCyberVideoView);
    }

    public void QN(String str) {
        TbCyberVideoView tbCyberVideoView;
        if (!this.mkJ && this.mkH.containsKey(str) && (tbCyberVideoView = (TbCyberVideoView) this.mkH.remove(str)) != null) {
            tbCyberVideoView.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awa() {
        Iterator it = this.mkH.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) entry.getValue();
                if (tbCyberVideoView != null) {
                    this.mkJ = true;
                    tbCyberVideoView.stopPlayback();
                    this.mkJ = false;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
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
                TbVideoViewSet.this.mkJ = true;
                value.dxs();
                value.stopPlayback();
                TbVideoViewSet.this.mkJ = false;
            }
            return z;
        }
    }
}
