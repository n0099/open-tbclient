package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes3.dex */
public class b implements a {
    private VideoEasterEggData hmC;
    private String mFrom;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void C(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra(IntentConfig.VIDEO_EASTER_EGG_DATA)) {
                this.hmC = (VideoEasterEggData) intent.getSerializableExtra(IntentConfig.VIDEO_EASTER_EGG_DATA);
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.hmC == null) {
            return null;
        }
        return this.hmC.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.hmC == null) {
            return null;
        }
        return this.hmC.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.hmC == null) {
            return null;
        }
        return this.hmC.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.hmC == null) {
            return null;
        }
        return this.hmC.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.hmC == null) {
            return null;
        }
        return this.hmC.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.hmC == null) {
            return null;
        }
        return this.hmC.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.hmC == null) {
            return null;
        }
        return this.hmC.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.hmC == null) {
            return null;
        }
        return this.hmC.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void s(BdUniqueId bdUniqueId) {
        if (!ap.isEmpty(getPopImageUrl())) {
            c.ih().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
