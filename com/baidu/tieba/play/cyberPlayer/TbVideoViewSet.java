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
    private static TbVideoViewSet mIZ = null;
    private LRULinkedHashMap<String, TbCyberVideoView> mIY = new LRULinkedHashMap<>();
    private boolean mJa;

    /* loaded from: classes.dex */
    public interface a {
        void dAv();

        void dAw();
    }

    private TbVideoViewSet() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbVideoViewSet.this.aww();
                }
            }
        });
    }

    public static TbVideoViewSet dAu() {
        if (mIZ == null) {
            synchronized (TbVideoViewSet.class) {
                if (mIZ == null) {
                    mIZ = new TbVideoViewSet();
                }
            }
        }
        return mIZ;
    }

    public TbCyberVideoView QF(String str) {
        if (au.isEmpty(str) || !this.mIY.containsKey(str)) {
            return null;
        }
        return this.mIY.get(str);
    }

    public void a(TbCyberVideoView tbCyberVideoView, String str) {
        String str2;
        if (this.mIY.containsKey(str) && tbCyberVideoView != this.mIY.get(str)) {
            TbCyberVideoView tbCyberVideoView2 = this.mIY.get(str);
            if (tbCyberVideoView2 != null && tbCyberVideoView2.isPlaying()) {
                tbCyberVideoView2.stopPlayback();
            }
        } else if (this.mIY.containsValue(tbCyberVideoView)) {
            Iterator it = this.mIY.entrySet().iterator();
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
            if (!this.mJa && !au.isEmpty(str2)) {
                this.mIY.remove(str2);
            }
        }
        this.mIY.put(str, tbCyberVideoView);
    }

    public void QG(String str) {
        TbCyberVideoView tbCyberVideoView;
        if (!this.mJa && this.mIY.containsKey(str) && (tbCyberVideoView = (TbCyberVideoView) this.mIY.remove(str)) != null) {
            tbCyberVideoView.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aww() {
        Iterator it = this.mIY.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) entry.getValue();
                if (tbCyberVideoView != null) {
                    this.mJa = true;
                    tbCyberVideoView.stopPlayback();
                    this.mJa = false;
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
                TbVideoViewSet.this.mJa = true;
                value.dAr();
                value.stopPlayback();
                TbVideoViewSet.this.mJa = false;
            }
            return z;
        }
    }
}
