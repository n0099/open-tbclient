package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes4.dex */
public class b implements a {
    private VideoEasterEggData jfd;
    private String mFrom;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void T(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra(IntentConfig.VIDEO_EASTER_EGG_DATA)) {
                this.jfd = (VideoEasterEggData) intent.getSerializableExtra(IntentConfig.VIDEO_EASTER_EGG_DATA);
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.jfd == null) {
            return null;
        }
        return this.jfd.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.jfd == null) {
            return null;
        }
        return this.jfd.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.jfd == null) {
            return null;
        }
        return this.jfd.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.jfd == null) {
            return null;
        }
        return this.jfd.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.jfd == null) {
            return null;
        }
        return this.jfd.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.jfd == null) {
            return null;
        }
        return this.jfd.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.jfd == null) {
            return null;
        }
        return this.jfd.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.jfd == null) {
            return null;
        }
        return this.jfd.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void w(BdUniqueId bdUniqueId) {
        if (!ap.isEmpty(getPopImageUrl())) {
            c.jB().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
