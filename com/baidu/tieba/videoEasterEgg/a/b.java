package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes3.dex */
public class b implements a {
    private VideoEasterEggData hNL;
    private String mFrom;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void D(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra(IntentConfig.VIDEO_EASTER_EGG_DATA)) {
                this.hNL = (VideoEasterEggData) intent.getSerializableExtra(IntentConfig.VIDEO_EASTER_EGG_DATA);
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.hNL == null) {
            return null;
        }
        return this.hNL.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.hNL == null) {
            return null;
        }
        return this.hNL.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.hNL == null) {
            return null;
        }
        return this.hNL.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.hNL == null) {
            return null;
        }
        return this.hNL.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.hNL == null) {
            return null;
        }
        return this.hNL.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.hNL == null) {
            return null;
        }
        return this.hNL.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.hNL == null) {
            return null;
        }
        return this.hNL.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.hNL == null) {
            return null;
        }
        return this.hNL.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void v(BdUniqueId bdUniqueId) {
        if (!ao.isEmpty(getPopImageUrl())) {
            c.jA().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
