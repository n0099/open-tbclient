package com.baidu.tieba.play.cyberPlayer;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.au;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class TbVideoViewSet {
    private static TbVideoViewSet mlc = null;
    private LRULinkedHashMap<String, TbCyberVideoView> mlb = new LRULinkedHashMap<>();
    private boolean mld;

    /* loaded from: classes.dex */
    public interface a {
        void dwW();

        void dwX();
    }

    private TbVideoViewSet() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbVideoViewSet.this.avs();
                }
            }
        });
    }

    public static TbVideoViewSet dwV() {
        if (mlc == null) {
            synchronized (TbVideoViewSet.class) {
                if (mlc == null) {
                    mlc = new TbVideoViewSet();
                }
            }
        }
        return mlc;
    }

    public TbCyberVideoView Qh(String str) {
        if (au.isEmpty(str) || !this.mlb.containsKey(str)) {
            return null;
        }
        return this.mlb.get(str);
    }

    public void a(TbCyberVideoView tbCyberVideoView, String str) {
        String str2;
        if (this.mlb.containsKey(str) && tbCyberVideoView != this.mlb.get(str)) {
            TbCyberVideoView tbCyberVideoView2 = this.mlb.get(str);
            if (tbCyberVideoView2 != null && tbCyberVideoView2.isPlaying()) {
                tbCyberVideoView2.stopPlayback();
            }
        } else if (this.mlb.containsValue(tbCyberVideoView)) {
            Iterator it = this.mlb.entrySet().iterator();
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
            if (!this.mld && !au.isEmpty(str2)) {
                this.mlb.remove(str2);
            }
        }
        this.mlb.put(str, tbCyberVideoView);
    }

    public void Qi(String str) {
        TbCyberVideoView tbCyberVideoView;
        if (!this.mld && this.mlb.containsKey(str) && (tbCyberVideoView = (TbCyberVideoView) this.mlb.remove(str)) != null) {
            tbCyberVideoView.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avs() {
        Iterator it = this.mlb.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) entry.getValue();
                if (tbCyberVideoView != null) {
                    this.mld = true;
                    tbCyberVideoView.stopPlayback();
                    this.mld = false;
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
                TbVideoViewSet.this.mld = true;
                value.dwS();
                value.stopPlayback();
                TbVideoViewSet.this.mld = false;
            }
            return z;
        }
    }
}
