package com.baidu.ugc.editvideo.record.source.multimedia;

import android.text.TextUtils;
import com.baidu.minivideo.effect.core.vlogedit.MediaAEffectConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaSegment;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrack;
import com.baidu.minivideo.effect.core.vlogedit.MediaTrackConfig;
import com.baidu.minivideo.effect.core.vlogedit.MediaTransitionConfig;
import com.baidu.tieba.cab;
import com.baidu.tieba.n9b;
import com.baidu.tieba.xg0;
import com.baidu.ugc.editvideo.record.entity.TemplateInfo;
import com.baidu.ugc.editvideo.record.source.multimedia.utils.MultiDataSourceUtil;
import com.baidu.ugc.utils.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public class VlogPkgManager {
    public static VlogPkgManager mManager;
    public Map<String, TemplateInfo> mTemplateInfoMap = new HashMap();
    public Map<String, MediaTransitionConfig> mMediaTransitionConfigMap = new HashMap();
    public Map<String, MediaAEffectConfig> mMediaAEffectConfigMap = new HashMap();

    public static VlogPkgManager getInstance() {
        if (mManager == null) {
            synchronized (VlogPkgManager.class) {
                if (mManager == null) {
                    mManager = new VlogPkgManager();
                }
            }
        }
        return mManager;
    }

    public TemplateInfo getTemplateInfoByKey(String str) {
        if (cab.a(str) || this.mTemplateInfoMap.get(str) == null) {
            return null;
        }
        return this.mTemplateInfoMap.get(str);
    }

    public List<MediaSegment> getTrackConfigSegmentData(MediaTrackConfig mediaTrackConfig) {
        if (mediaTrackConfig == null || n9b.e(mediaTrackConfig.mediaTracks) || !TextUtils.equals(mediaTrackConfig.importType, MediaTrackConfig.AE_IMPORT_TEMPLATE)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MediaTrack mediaTrack : mediaTrackConfig.mediaTracks) {
            if (xg0.m(mediaTrack, "input") || xg0.m(mediaTrack, "multi_input")) {
                if (n9b.e(mediaTrack.mediaSegments)) {
                    return null;
                }
                for (MediaSegment mediaSegment : mediaTrack.mediaSegments) {
                    if (mediaSegment != null && !TextUtils.equals(mediaSegment.type, MediaSegment.SEG_TYPE_INPUT_HEADER) && !TextUtils.equals(mediaSegment.type, MediaSegment.SEG_TYPE_INPUT_FOOTER)) {
                        arrayList.add(mediaSegment);
                    }
                }
            } else if (!n9b.e(mediaTrack.mediaSegments)) {
                for (MediaSegment mediaSegment2 : mediaTrack.mediaSegments) {
                    if (mediaSegment2 != null && ("input".equals(mediaSegment2.type) || "multi_input".equals(mediaSegment2.type))) {
                        arrayList.add(mediaSegment2);
                    }
                }
            }
        }
        return arrayList;
    }

    public MediaAEffectConfig loadMediaAEffectConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.mMediaAEffectConfigMap.get(str) != null) {
            return this.mMediaAEffectConfigMap.get(str);
        }
        MediaAEffectConfig loadMediaAEffectConfig = MultiDataSourceUtil.loadMediaAEffectConfig(str);
        this.mMediaAEffectConfigMap.put(str, loadMediaAEffectConfig);
        return loadMediaAEffectConfig;
    }

    public TemplateInfo loadTemplateInfo(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            if (!FileUtils.isExists(str + "/theme_config.json")) {
                File[] listFiles = file.listFiles();
                int length = listFiles.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        str = "";
                        break;
                    }
                    File file2 = listFiles[i];
                    if (file2.isDirectory()) {
                        if (FileUtils.isExists(file2.getAbsolutePath() + "/theme_config.json")) {
                            str = file2.getAbsolutePath();
                            break;
                        }
                    }
                    i++;
                }
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            TemplateInfo templateInfoByKey = getTemplateInfoByKey(str);
            if (templateInfoByKey == null && !TextUtils.isEmpty(str)) {
                TemplateInfo templateInfo = TemplateInfo.getTemplateInfo(str);
                this.mTemplateInfoMap.put(str, templateInfo);
                return templateInfo;
            }
            return templateInfoByKey;
        }
        return null;
    }

    public MediaTransitionConfig loadTransitionConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.mMediaTransitionConfigMap.get(str) != null) {
            return this.mMediaTransitionConfigMap.get(str);
        }
        MediaTransitionConfig loadMediaTransitionConfig = MultiDataSourceUtil.loadMediaTransitionConfig(str);
        this.mMediaTransitionConfigMap.put(str, loadMediaTransitionConfig);
        return loadMediaTransitionConfig;
    }

    public void release() {
        this.mTemplateInfoMap.clear();
        this.mTemplateInfoMap = null;
        this.mMediaTransitionConfigMap.clear();
        this.mMediaTransitionConfigMap = null;
        this.mMediaAEffectConfigMap.clear();
        this.mMediaAEffectConfigMap = null;
    }
}
