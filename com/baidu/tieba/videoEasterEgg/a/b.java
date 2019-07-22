package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes4.dex */
public class b implements a {
    private VideoEasterEggData jEk;
    private String mFrom;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void W(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra(IntentConfig.VIDEO_EASTER_EGG_DATA)) {
                this.jEk = (VideoEasterEggData) intent.getSerializableExtra(IntentConfig.VIDEO_EASTER_EGG_DATA);
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.jEk == null) {
            return null;
        }
        return this.jEk.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.jEk == null) {
            return null;
        }
        return this.jEk.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.jEk == null) {
            return null;
        }
        return this.jEk.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.jEk == null) {
            return null;
        }
        return this.jEk.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.jEk == null) {
            return null;
        }
        return this.jEk.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.jEk == null) {
            return null;
        }
        return this.jEk.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.jEk == null) {
            return null;
        }
        return this.jEk.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.jEk == null) {
            return null;
        }
        return this.jEk.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void y(BdUniqueId bdUniqueId) {
        if (!aq.isEmpty(getPopImageUrl())) {
            c.iE().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
