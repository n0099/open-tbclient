package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.e.c;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes16.dex */
public class b implements a {
    private String mFrom;
    private VideoEasterEggData mmw;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void J(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra("video_easter_egg_data")) {
                this.mmw = (VideoEasterEggData) intent.getSerializableExtra("video_easter_egg_data");
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.mmw == null) {
            return null;
        }
        return this.mmw.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.mmw == null) {
            return null;
        }
        return this.mmw.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.mmw == null) {
            return null;
        }
        return this.mmw.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.mmw == null) {
            return null;
        }
        return this.mmw.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.mmw == null) {
            return null;
        }
        return this.mmw.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.mmw == null) {
            return null;
        }
        return this.mmw.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.mmw == null) {
            return null;
        }
        return this.mmw.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.mmw == null) {
            return null;
        }
        return this.mmw.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void E(BdUniqueId bdUniqueId) {
        if (!as.isEmpty(getPopImageUrl())) {
            c.ln().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
