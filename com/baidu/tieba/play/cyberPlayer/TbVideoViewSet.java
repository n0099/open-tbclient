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
    private static TbVideoViewSet mzi = null;
    private LRULinkedHashMap<String, TbCyberVideoView> mzh = new LRULinkedHashMap<>();
    private boolean mzj;

    /* loaded from: classes.dex */
    public interface a {
        void dCp();

        void dCq();
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

    public static TbVideoViewSet dCo() {
        if (mzi == null) {
            synchronized (TbVideoViewSet.class) {
                if (mzi == null) {
                    mzi = new TbVideoViewSet();
                }
            }
        }
        return mzi;
    }

    public TbCyberVideoView Rq(String str) {
        if (au.isEmpty(str) || !this.mzh.containsKey(str)) {
            return null;
        }
        return this.mzh.get(str);
    }

    public void a(TbCyberVideoView tbCyberVideoView, String str) {
        String str2;
        if (this.mzh.containsKey(str) && tbCyberVideoView != this.mzh.get(str)) {
            TbCyberVideoView tbCyberVideoView2 = this.mzh.get(str);
            if (tbCyberVideoView2 != null && tbCyberVideoView2.isPlaying()) {
                tbCyberVideoView2.stopPlayback();
            }
        } else if (this.mzh.containsValue(tbCyberVideoView)) {
            Iterator it = this.mzh.entrySet().iterator();
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
            if (!this.mzj && !au.isEmpty(str2)) {
                this.mzh.remove(str2);
            }
        }
        this.mzh.put(str, tbCyberVideoView);
    }

    public void Rr(String str) {
        TbCyberVideoView tbCyberVideoView;
        if (!this.mzj && this.mzh.containsKey(str) && (tbCyberVideoView = (TbCyberVideoView) this.mzh.remove(str)) != null) {
            tbCyberVideoView.stopPlayback();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayA() {
        Iterator it = this.mzh.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry != null) {
                TbCyberVideoView tbCyberVideoView = (TbCyberVideoView) entry.getValue();
                if (tbCyberVideoView != null) {
                    this.mzj = true;
                    tbCyberVideoView.stopPlayback();
                    this.mzj = false;
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
                TbVideoViewSet.this.mzj = true;
                value.dCl();
                value.stopPlayback();
                TbVideoViewSet.this.mzj = false;
            }
            return z;
        }
    }
}
