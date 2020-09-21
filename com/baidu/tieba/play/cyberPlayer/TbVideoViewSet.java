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
    private static TbVideoViewSet lCW = null;
    private LRULinkedHashMap<String, TbCyberVideoView> lCV = new LRULinkedHashMap<>();
    private boolean lCX;

    /* loaded from: classes.dex */
    public interface a {
        void doc();

        void dod();
    }

    private TbVideoViewSet() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbVideoViewSet.this.aoT();
                }
            }
        });
    }

    public static TbVideoViewSet dob() {
        if (lCW == null) {
            synchronized (TbVideoViewSet.class) {
                if (lCW == null) {
                    lCW = new TbVideoViewSet();
                }
            }
        }
        return lCW;
    }

    public TbCyberVideoView Pi(String str) {
        if (at.isEmpty(str) || !this.lCV.containsKey(str)) {
            return null;
        }
        return this.lCV.get(str);
    }

    public void a(TbCyberVideoView tbCyberVideoView, String str) {
        String str2;
        if (this.lCV.containsKey(str) && tbCyberVideoView != this.lCV.get(str)) {
            TbCyberVideoView tbCyberVideoView2 = this.lCV.get(str);
            if (tbCyberVideoView2 != null && tbCyberVideoView2.isPlaying()) {
                tbCyberVideoView2.stopPlayback();
            }
        } else if (this.lCV.containsValue(tbCyberVideoView)) {
            Iterator it = this.lCV.entrySet().iterator();
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
            if (!this.lCX && !at.isEmpty(str2)) {
                this.lCV.remove(str2);
            }
        }
        this.lCV.put(str, tbCyberVideoView);
    }

    public void Pj(String str) {
        TbCyberVideoView tbCyberVideoView;
        if (!this.lCX && this.lCV.containsKey(str) && (tbCyberVideoView = (TbCyberVideoView) this.lCV.remove(str)) != null) {
            tbCyberVideoView.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoT() {
        Iterator it = this.lCV.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) entry.getValue();
                if (tbCyberVideoView != null) {
                    this.lCX = true;
                    tbCyberVideoView.stopPlayback();
                    this.lCX = false;
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
                TbVideoViewSet.this.lCX = true;
                value.dnY();
                value.stopPlayback();
                TbVideoViewSet.this.lCX = false;
            }
            return z;
        }
    }
}
