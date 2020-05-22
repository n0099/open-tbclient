package com.baidu.tieba.livesdk.i;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.baidu.cyberplayer.sdk.BVideoView;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c implements com.baidu.live.liveroom.e.a {
    private static boolean mHasInit = false;
    private com.baidu.live.liveroom.e.c gcL;
    private BVideoView jey;
    private Uri mUri;

    public c() {
        cvb();
    }

    @Override // com.baidu.live.liveroom.e.a
    public void d(Context context, Uri uri) {
        cvb();
        this.jey = new BVideoView(context);
        HashMap hashMap = new HashMap();
        hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, SoUtils.SO_EVENT_ID_DEFAULT);
        hashMap.put(CyberPlayerManager.STAGE_INFO_TITLE, "tieba");
        this.jey.setExternalInfo(CyberPlayerManager.STR_STAGE_INFO, hashMap);
        this.mUri = uri;
    }

    @Override // com.baidu.live.liveroom.e.a
    public void a(com.baidu.live.liveroom.e.c cVar) {
        this.gcL = cVar;
        if (this.jey != null) {
            this.jey.setOnInfoListener(new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.livesdk.i.c.1
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
                public boolean onInfo(int i, int i2, Object obj) {
                    if (c.this.gcL != null) {
                        c.this.gcL.a(c.this, i, i2);
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void setDecodeMode(int i) {
        if (this.jey != null) {
            this.jey.setDecodeMode(i);
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void b(int i, JSONObject jSONObject) {
    }

    @Override // com.baidu.live.liveroom.e.a
    public View getPlayerView() {
        return this.jey;
    }

    @Override // com.baidu.live.liveroom.e.a
    public void cB(int i) {
        if (this.jey != null) {
            this.jey.setVisibility(i);
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void c(Uri uri) {
        this.mUri = uri;
        if (this.jey != null) {
            this.jey.setVideoURI(this.mUri);
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void setVideoScalingMode(int i) {
        if (this.jey != null) {
            this.jey.setVideoScalingMode(i);
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void start() {
        if (this.jey != null) {
            this.jey.start();
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void stop() {
        if (this.jey != null) {
            this.jey.stopPlayback();
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void release() {
        if (this.jey != null) {
            this.jey.stopPlayback();
            this.jey.reset();
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void b(int i, Map<String, String> map) {
        if (i == 1 && this.jey != null && map != null) {
            map.put("type", "20487");
            this.jey.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, map);
        }
    }

    public static synchronized void cvb() {
        synchronized (c.class) {
            if (!mHasInit) {
                mHasInit = true;
                if (!CyberPlayerManager.isCoreLoaded(1)) {
                    CyberPlayerManager.install(TbadkCoreApplication.getInst().getContext(), TbadkCoreApplication.getInst().getCuid(), null, 1, null, null, null);
                }
            }
        }
    }
}
