package com.baidu.tieba.play.cyberPlayer;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.as;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class TbVideoViewSet {
    private static TbVideoViewSet ldA = null;
    private boolean ldB;
    private LRULinkedHashMap<String, TbCyberVideoView> ldz = new LRULinkedHashMap<>();

    /* loaded from: classes.dex */
    public interface a {
        void cZo();

        void cZp();
    }

    private TbVideoViewSet() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbVideoViewSet.this.aEB();
                }
            }
        });
    }

    public static TbVideoViewSet cZn() {
        if (ldA == null) {
            synchronized (TbVideoViewSet.class) {
                if (ldA == null) {
                    ldA = new TbVideoViewSet();
                }
            }
        }
        return ldA;
    }

    public TbCyberVideoView LN(String str) {
        if (as.isEmpty(str) || !this.ldz.containsKey(str)) {
            return null;
        }
        return this.ldz.get(str);
    }

    public void a(TbCyberVideoView tbCyberVideoView, String str) {
        String str2;
        if (this.ldz.containsKey(str) && tbCyberVideoView != this.ldz.get(str)) {
            TbCyberVideoView tbCyberVideoView2 = this.ldz.get(str);
            if (tbCyberVideoView2 != null && tbCyberVideoView2.isPlaying()) {
                tbCyberVideoView2.stopPlayback();
            }
        } else if (this.ldz.containsValue(tbCyberVideoView)) {
            Iterator it = this.ldz.entrySet().iterator();
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
            if (!this.ldB && !as.isEmpty(str2)) {
                this.ldz.remove(str2);
            }
        }
        this.ldz.put(str, tbCyberVideoView);
    }

    public void LO(String str) {
        TbCyberVideoView tbCyberVideoView;
        if (!this.ldB && this.ldz.containsKey(str) && (tbCyberVideoView = (TbCyberVideoView) this.ldz.remove(str)) != null) {
            tbCyberVideoView.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEB() {
        Iterator it = this.ldz.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) entry.getValue();
                if (tbCyberVideoView != null) {
                    this.ldB = true;
                    tbCyberVideoView.stopPlayback();
                    this.ldB = false;
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
                TbVideoViewSet.this.ldB = true;
                value.cZk();
                value.stopPlayback();
                TbVideoViewSet.this.ldB = false;
            }
            return z;
        }
    }
}
