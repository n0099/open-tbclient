package com.baidu.tieba.videoEasterEgg.a;

import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.f.c;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.data.VideoEasterEggData;
/* loaded from: classes3.dex */
public class b implements a {
    private VideoEasterEggData hDo;
    private String mFrom;

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void D(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getStringExtra("from");
            if (intent.hasExtra(IntentConfig.VIDEO_EASTER_EGG_DATA)) {
                this.hDo = (VideoEasterEggData) intent.getSerializableExtra(IntentConfig.VIDEO_EASTER_EGG_DATA);
            }
        }
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getID() {
        if (this.hDo == null) {
            return null;
        }
        return this.hDo.getActivityID();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getVideoUrl() {
        if (this.hDo == null) {
            return null;
        }
        return this.hDo.getVideoUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopText() {
        if (this.hDo == null) {
            return null;
        }
        return this.hDo.getPopText();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareTitle() {
        if (this.hDo == null) {
            return null;
        }
        return this.hDo.getShareTitle();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareContent() {
        if (this.hDo == null) {
            return null;
        }
        return this.hDo.getShareContent();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareUrl() {
        if (this.hDo == null) {
            return null;
        }
        return this.hDo.getShareUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getShareImageUrl() {
        if (this.hDo == null) {
            return null;
        }
        return this.hDo.getShareImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public String getPopImageUrl() {
        if (this.hDo == null) {
            return null;
        }
        return this.hDo.getPopImageUrl();
    }

    @Override // com.baidu.tieba.videoEasterEgg.a.a
    public void r(BdUniqueId bdUniqueId) {
        if (!ao.isEmpty(getPopImageUrl())) {
            c.jA().a(getPopImageUrl(), 10, null, bdUniqueId);
        }
    }
}
