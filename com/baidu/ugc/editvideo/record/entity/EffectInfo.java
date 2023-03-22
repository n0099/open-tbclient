package com.baidu.ugc.editvideo.record.entity;

import android.text.TextUtils;
import com.baidu.tieba.y4a;
import com.baidu.ugc.bean.MusicData;
import java.io.File;
import java.io.Serializable;
/* loaded from: classes7.dex */
public class EffectInfo implements Serializable {
    public String finalFilePath;
    public String iconPath;
    public String id;
    public boolean isLocal;
    public EffectMusicData music;
    public String name;
    public String resourceUrl;
    public int showSwitch;
    public String sign;
    public String sk;
    public TemplateInfo templateInfo;
    public String themeType;
    public String tips;
    public int type;
    public File unzipFile;
    public boolean isSelected = false;
    public int fixNum = 0;

    /* loaded from: classes7.dex */
    public static class EffectMusicData implements Serializable {
        public String cover;
        public String duration;
        public String id;
        public String localAssetsPath;
        public String musicFileName;
        public int musicType = 0;
        public String musicZipPath;
        public String name;
        public int progress;
        public String singer;
        public String sk;
    }

    public boolean isResourceLoaded() {
        File file = this.unzipFile;
        if (file != null && file.exists()) {
            return true;
        }
        return false;
    }

    public static boolean isCardTheme(EffectInfo effectInfo) {
        if (effectInfo == null || effectInfo.type != 1) {
            return false;
        }
        return true;
    }

    public static boolean isNormalTheme(EffectInfo effectInfo) {
        if (effectInfo == null || effectInfo.type != 0) {
            return false;
        }
        return true;
    }

    public static EffectInfo parse(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (EffectInfo) new y4a().b(str, EffectInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static EffectMusicData parseFrom(MusicData musicData) {
        EffectMusicData effectMusicData = new EffectMusicData();
        effectMusicData.duration = musicData.duration;
        effectMusicData.cover = musicData.icon;
        effectMusicData.id = musicData.id;
        effectMusicData.name = musicData.title;
        effectMusicData.singer = musicData.singer;
        effectMusicData.sk = musicData.sk;
        effectMusicData.localAssetsPath = musicData.localPath;
        effectMusicData.musicType = musicData.musicType;
        return effectMusicData;
    }

    public static String toJSON(EffectInfo effectInfo) {
        if (effectInfo == null) {
            return null;
        }
        try {
            return new y4a().a(effectInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EffectInfo)) {
            return false;
        }
        EffectInfo effectInfo = (EffectInfo) obj;
        String str = effectInfo.name;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        effectInfo.name = str;
        String str3 = effectInfo.themeType;
        if (str3 == null) {
            str3 = "";
        }
        effectInfo.themeType = str3;
        String str4 = this.name;
        if (str4 == null) {
            str4 = "";
        }
        this.name = str4;
        String str5 = this.themeType;
        if (str5 != null) {
            str2 = str5;
        }
        this.themeType = str2;
        if (!this.name.equals(effectInfo.name) || !this.themeType.equals(effectInfo.themeType)) {
            return false;
        }
        return true;
    }
}
