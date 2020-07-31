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
    private static TbVideoViewSet ldy = null;
    private LRULinkedHashMap<String, TbCyberVideoView> ldx = new LRULinkedHashMap<>();
    private boolean ldz;

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
        if (ldy == null) {
            synchronized (TbVideoViewSet.class) {
                if (ldy == null) {
                    ldy = new TbVideoViewSet();
                }
            }
        }
        return ldy;
    }

    public TbCyberVideoView LN(String str) {
        if (as.isEmpty(str) || !this.ldx.containsKey(str)) {
            return null;
        }
        return this.ldx.get(str);
    }

    public void a(TbCyberVideoView tbCyberVideoView, String str) {
        String str2;
        if (this.ldx.containsKey(str) && tbCyberVideoView != this.ldx.get(str)) {
            TbCyberVideoView tbCyberVideoView2 = this.ldx.get(str);
            if (tbCyberVideoView2 != null && tbCyberVideoView2.isPlaying()) {
                tbCyberVideoView2.stopPlayback();
            }
        } else if (this.ldx.containsValue(tbCyberVideoView)) {
            Iterator it = this.ldx.entrySet().iterator();
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
            if (!this.ldz && !as.isEmpty(str2)) {
                this.ldx.remove(str2);
            }
        }
        this.ldx.put(str, tbCyberVideoView);
    }

    public void LO(String str) {
        TbCyberVideoView tbCyberVideoView;
        if (!this.ldz && this.ldx.containsKey(str) && (tbCyberVideoView = (TbCyberVideoView) this.ldx.remove(str)) != null) {
            tbCyberVideoView.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEB() {
        Iterator it = this.ldx.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) entry.getValue();
                if (tbCyberVideoView != null) {
                    this.ldz = true;
                    tbCyberVideoView.stopPlayback();
                    this.ldz = false;
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
                TbVideoViewSet.this.ldz = true;
                value.cZk();
                value.stopPlayback();
                TbVideoViewSet.this.ldz = false;
            }
            return z;
        }
    }
}
