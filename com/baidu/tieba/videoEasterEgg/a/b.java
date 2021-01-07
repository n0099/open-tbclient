package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.e.d;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes2.dex */
public class b implements a {
    private String mFrom;
    private VideoEasterEggData nOV;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void M(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra("video_easter_egg_data")) {
                this.nOV = (VideoEasterEggData) intent.getSerializableExtra("video_easter_egg_data");
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.nOV == null) {
            return null;
        }
        return this.nOV.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.nOV == null) {
            return null;
        }
        return this.nOV.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.nOV == null) {
            return null;
        }
        return this.nOV.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.nOV == null) {
            return null;
        }
        return this.nOV.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.nOV == null) {
            return null;
        }
        return this.nOV.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.nOV == null) {
            return null;
        }
        return this.nOV.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.nOV == null) {
            return null;
        }
        return this.nOV.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.nOV == null) {
            return null;
        }
        return this.nOV.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void E(BdUniqueId bdUniqueId) {
        if (!at.isEmpty(getPopImageUrl())) {
            d.mx().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
