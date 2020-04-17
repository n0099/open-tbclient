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
    private com.baidu.live.liveroom.e.c fOB;
    private BVideoView iPt;
    private Uri mUri;

    public c() {
        coB();
    }

    @Override // com.baidu.live.liveroom.e.a
    public void d(Context context, Uri uri) {
        coB();
        this.iPt = new BVideoView(context);
        HashMap hashMap = new HashMap();
        hashMap.put(CyberPlayerManager.STAGE_INFO_TYPE, SoUtils.SO_EVENT_ID_DEFAULT);
        hashMap.put(CyberPlayerManager.STAGE_INFO_TITLE, "tieba");
        this.iPt.setExternalInfo(CyberPlayerManager.STR_STAGE_INFO, hashMap);
        this.mUri = uri;
    }

    @Override // com.baidu.live.liveroom.e.a
    public void a(com.baidu.live.liveroom.e.c cVar) {
        this.fOB = cVar;
        if (this.iPt != null) {
            this.iPt.setOnInfoListener(new CyberPlayerManager.OnInfoListener() { // from class: com.baidu.tieba.livesdk.i.c.1
                @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
                public boolean onInfo(int i, int i2, Object obj) {
                    if (c.this.fOB != null) {
                        c.this.fOB.a(c.this, i, i2);
                        return false;
                    }
                    return false;
                }
            });
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void setDecodeMode(int i) {
        if (this.iPt != null) {
            this.iPt.setDecodeMode(i);
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void b(int i, JSONObject jSONObject) {
    }

    @Override // com.baidu.live.liveroom.e.a
    public View getPlayerView() {
        return this.iPt;
    }

    @Override // com.baidu.live.liveroom.e.a
    public void cu(int i) {
        if (this.iPt != null) {
            this.iPt.setVisibility(i);
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void c(Uri uri) {
        this.mUri = uri;
        if (this.iPt != null) {
            this.iPt.setVideoURI(this.mUri);
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void setVideoScalingMode(int i) {
        if (this.iPt != null) {
            this.iPt.setVideoScalingMode(i);
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void start() {
        if (this.iPt != null) {
            this.iPt.start();
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void stop() {
        if (this.iPt != null) {
            this.iPt.stopPlayback();
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void release() {
        if (this.iPt != null) {
            this.iPt.stopPlayback();
            this.iPt.reset();
        }
    }

    @Override // com.baidu.live.liveroom.e.a
    public void b(int i, Map<String, String> map) {
        if (i == 1 && this.iPt != null && map != null) {
            map.put("type", "20487");
            this.iPt.setExternalInfo(CyberPlayerManager.STR_STATISTICS_INFO, map);
        }
    }

    public static synchronized void coB() {
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
