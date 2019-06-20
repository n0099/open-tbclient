package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes4.dex */
public class b implements a {
    private VideoEasterEggData jyb;
    private String mFrom;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void W(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra(IntentConfig.VIDEO_EASTER_EGG_DATA)) {
                this.jyb = (VideoEasterEggData) intent.getSerializableExtra(IntentConfig.VIDEO_EASTER_EGG_DATA);
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.jyb == null) {
            return null;
        }
        return this.jyb.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.jyb == null) {
            return null;
        }
        return this.jyb.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.jyb == null) {
            return null;
        }
        return this.jyb.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.jyb == null) {
            return null;
        }
        return this.jyb.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.jyb == null) {
            return null;
        }
        return this.jyb.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.jyb == null) {
            return null;
        }
        return this.jyb.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.jyb == null) {
            return null;
        }
        return this.jyb.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.jyb == null) {
            return null;
        }
        return this.jyb.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void y(BdUniqueId bdUniqueId) {
        if (!ap.isEmpty(getPopImageUrl())) {
            c.iv().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
