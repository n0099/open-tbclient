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
    private static TbVideoViewSet mEy = null;
    private LRULinkedHashMap<String, TbCyberVideoView> mEx = new LRULinkedHashMap<>();
    private boolean mEz;

    /* loaded from: classes.dex */
    public interface a {
        void dCe();

        void dCf();
    }

    private TbVideoViewSet() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbVideoViewSet.this.azR();
                }
            }
        });
    }

    public static TbVideoViewSet dCd() {
        if (mEy == null) {
            synchronized (TbVideoViewSet.class) {
                if (mEy == null) {
                    mEy = new TbVideoViewSet();
                }
            }
        }
        return mEy;
    }

    public TbCyberVideoView QW(String str) {
        if (at.isEmpty(str) || !this.mEx.containsKey(str)) {
            return null;
        }
        return this.mEx.get(str);
    }

    public void a(TbCyberVideoView tbCyberVideoView, String str) {
        String str2;
        if (this.mEx.containsKey(str) && tbCyberVideoView != this.mEx.get(str)) {
            TbCyberVideoView tbCyberVideoView2 = this.mEx.get(str);
            if (tbCyberVideoView2 != null && tbCyberVideoView2.isPlaying()) {
                tbCyberVideoView2.stopPlayback();
            }
        } else if (this.mEx.containsValue(tbCyberVideoView)) {
            Iterator it = this.mEx.entrySet().iterator();
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
            if (!this.mEz && !at.isEmpty(str2)) {
                this.mEx.remove(str2);
            }
        }
        this.mEx.put(str, tbCyberVideoView);
    }

    public void QX(String str) {
        TbCyberVideoView tbCyberVideoView;
        if (!this.mEz && this.mEx.containsKey(str) && (tbCyberVideoView = (TbCyberVideoView) this.mEx.remove(str)) != null) {
            tbCyberVideoView.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azR() {
        Iterator it = this.mEx.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) entry.getValue();
                if (tbCyberVideoView != null) {
                    this.mEz = true;
                    tbCyberVideoView.stopPlayback();
                    this.mEz = false;
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
                TbVideoViewSet.this.mEz = true;
                value.dCa();
                value.stopPlayback();
                TbVideoViewSet.this.mEz = false;
            }
            return z;
        }
    }
}
