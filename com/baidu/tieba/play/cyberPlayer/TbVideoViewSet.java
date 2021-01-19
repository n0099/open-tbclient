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
    private static TbVideoViewSet mzO = null;
    private LRULinkedHashMap<String, TbCyberVideoView> mzN = new LRULinkedHashMap<>();
    private boolean mzP;

    /* loaded from: classes.dex */
    public interface a {
        void dyn();

        void dyo();
    }

    private TbVideoViewSet() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbVideoViewSet.this.avY();
                }
            }
        });
    }

    public static TbVideoViewSet dym() {
        if (mzO == null) {
            synchronized (TbVideoViewSet.class) {
                if (mzO == null) {
                    mzO = new TbVideoViewSet();
                }
            }
        }
        return mzO;
    }

    public TbCyberVideoView PO(String str) {
        if (at.isEmpty(str) || !this.mzN.containsKey(str)) {
            return null;
        }
        return this.mzN.get(str);
    }

    public void a(TbCyberVideoView tbCyberVideoView, String str) {
        String str2;
        if (this.mzN.containsKey(str) && tbCyberVideoView != this.mzN.get(str)) {
            TbCyberVideoView tbCyberVideoView2 = this.mzN.get(str);
            if (tbCyberVideoView2 != null && tbCyberVideoView2.isPlaying()) {
                tbCyberVideoView2.stopPlayback();
            }
        } else if (this.mzN.containsValue(tbCyberVideoView)) {
            Iterator it = this.mzN.entrySet().iterator();
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
            if (!this.mzP && !at.isEmpty(str2)) {
                this.mzN.remove(str2);
            }
        }
        this.mzN.put(str, tbCyberVideoView);
    }

    public void PP(String str) {
        TbCyberVideoView tbCyberVideoView;
        if (!this.mzP && this.mzN.containsKey(str) && (tbCyberVideoView = (TbCyberVideoView) this.mzN.remove(str)) != null) {
            tbCyberVideoView.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avY() {
        Iterator it = this.mzN.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) entry.getValue();
                if (tbCyberVideoView != null) {
                    this.mzP = true;
                    tbCyberVideoView.stopPlayback();
                    this.mzP = false;
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
                TbVideoViewSet.this.mzP = true;
                value.dyj();
                value.stopPlayback();
                TbVideoViewSet.this.mzP = false;
            }
            return z;
        }
    }
}
