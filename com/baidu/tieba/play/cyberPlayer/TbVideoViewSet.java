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
    private static TbVideoViewSet mzg = null;
    private LRULinkedHashMap<String, TbCyberVideoView> mzf = new LRULinkedHashMap<>();
    private boolean mzh;

    /* loaded from: classes.dex */
    public interface a {
        void dCo();

        void dCp();
    }

    private TbVideoViewSet() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.play.cyberPlayer.TbVideoViewSet.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    TbVideoViewSet.this.ayA();
                }
            }
        });
    }

    public static TbVideoViewSet dCn() {
        if (mzg == null) {
            synchronized (TbVideoViewSet.class) {
                if (mzg == null) {
                    mzg = new TbVideoViewSet();
                }
            }
        }
        return mzg;
    }

    public TbCyberVideoView Rq(String str) {
        if (au.isEmpty(str) || !this.mzf.containsKey(str)) {
            return null;
        }
        return this.mzf.get(str);
    }

    public void a(TbCyberVideoView tbCyberVideoView, String str) {
        String str2;
        if (this.mzf.containsKey(str) && tbCyberVideoView != this.mzf.get(str)) {
            TbCyberVideoView tbCyberVideoView2 = this.mzf.get(str);
            if (tbCyberVideoView2 != null && tbCyberVideoView2.isPlaying()) {
                tbCyberVideoView2.stopPlayback();
            }
        } else if (this.mzf.containsValue(tbCyberVideoView)) {
            Iterator it = this.mzf.entrySet().iterator();
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
            if (!this.mzh && !au.isEmpty(str2)) {
                this.mzf.remove(str2);
            }
        }
        this.mzf.put(str, tbCyberVideoView);
    }

    public void Rr(String str) {
        TbCyberVideoView tbCyberVideoView;
        if (!this.mzh && this.mzf.containsKey(str) && (tbCyberVideoView = (TbCyberVideoView) this.mzf.remove(str)) != null) {
            tbCyberVideoView.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayA() {
        Iterator it = this.mzf.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) entry.getValue();
                if (tbCyberVideoView != null) {
                    this.mzh = true;
                    tbCyberVideoView.stopPlayback();
                    this.mzh = false;
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
                TbVideoViewSet.this.mzh = true;
                value.dCk();
                value.stopPlayback();
                TbVideoViewSet.this.mzh = false;
            }
            return z;
        }
    }
}
