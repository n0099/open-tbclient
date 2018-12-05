package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes3.dex */
public class b implements a {
    private VideoEasterEggData hKA;
    private String mFrom;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void D(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra(IntentConfig.VIDEO_EASTER_EGG_DATA)) {
                this.hKA = (VideoEasterEggData) intent.getSerializableExtra(IntentConfig.VIDEO_EASTER_EGG_DATA);
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.hKA == null) {
            return null;
        }
        return this.hKA.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.hKA == null) {
            return null;
        }
        return this.hKA.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.hKA == null) {
            return null;
        }
        return this.hKA.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.hKA == null) {
            return null;
        }
        return this.hKA.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.hKA == null) {
            return null;
        }
        return this.hKA.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.hKA == null) {
            return null;
        }
        return this.hKA.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.hKA == null) {
            return null;
        }
        return this.hKA.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.hKA == null) {
            return null;
        }
        return this.hKA.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void r(BdUniqueId bdUniqueId) {
        if (!ao.isEmpty(getPopImageUrl())) {
            c.jA().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
