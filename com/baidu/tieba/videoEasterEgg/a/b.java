package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes4.dex */
public class b implements a {
    private VideoEasterEggData jfo;
    private String mFrom;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void T(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra(IntentConfig.VIDEO_EASTER_EGG_DATA)) {
                this.jfo = (VideoEasterEggData) intent.getSerializableExtra(IntentConfig.VIDEO_EASTER_EGG_DATA);
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.jfo == null) {
            return null;
        }
        return this.jfo.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.jfo == null) {
            return null;
        }
        return this.jfo.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.jfo == null) {
            return null;
        }
        return this.jfo.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.jfo == null) {
            return null;
        }
        return this.jfo.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.jfo == null) {
            return null;
        }
        return this.jfo.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.jfo == null) {
            return null;
        }
        return this.jfo.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.jfo == null) {
            return null;
        }
        return this.jfo.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.jfo == null) {
            return null;
        }
        return this.jfo.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void w(BdUniqueId bdUniqueId) {
        if (!ap.isEmpty(getPopImageUrl())) {
            c.jB().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
