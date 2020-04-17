package com.baidu.tieba.write.upload;

import java.io.Serializable;
/* loaded from: classes.dex */
public class VideoUploadData extends BaseUploadData implements Serializable {
    public VideoInfo videos;

    /* loaded from: classes.dex */
    public static class VideoInfo implements Serializable {
        public String authorUK;
        public String bgSound;
        public String bgSoundRec;
        public String controls;
        public String coverUrl;
        public String duration;
        public String height;
        public String mediaId;
        public String musicName;
        public String size;
        public int soundSrc;
        public String sourceKey;
        public String source_url;
        public String videoFirstFrame;
        public String videoProductionType;
        public String width;
    }
}
