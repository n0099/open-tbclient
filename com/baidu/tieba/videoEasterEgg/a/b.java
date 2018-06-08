package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes3.dex */
public class b implements a {
    private VideoEasterEggData hhg;
    private String mFrom;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void C(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra(IntentConfig.VIDEO_EASTER_EGG_DATA)) {
                this.hhg = (VideoEasterEggData) intent.getSerializableExtra(IntentConfig.VIDEO_EASTER_EGG_DATA);
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.hhg == null) {
            return null;
        }
        return this.hhg.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.hhg == null) {
            return null;
        }
        return this.hhg.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.hhg == null) {
            return null;
        }
        return this.hhg.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.hhg == null) {
            return null;
        }
        return this.hhg.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.hhg == null) {
            return null;
        }
        return this.hhg.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.hhg == null) {
            return null;
        }
        return this.hhg.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.hhg == null) {
            return null;
        }
        return this.hhg.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.hhg == null) {
            return null;
        }
        return this.hhg.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void s(BdUniqueId bdUniqueId) {
        if (!ao.isEmpty(getPopImageUrl())) {
            c.ig().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
