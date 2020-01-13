package com.baidu.tieba.video.editvideo.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
/* loaded from: classes8.dex */
public class MusicData extends OrmObject {
    public static final int TYPE_CLOUD = 2;
    public static final int TYPE_MUSIC = 0;
    public static final int TYPE_NORMAL = 1;
    public String duration;
    public int editMusicType;
    public String id;
    public String img;
    public String name;
    public String resource;
    public String seq;
    public String status;
    public String type;

    public MusicData() {
        this.editMusicType = 0;
    }

    public MusicData(String str, int i, String str2) {
        this.editMusicType = 0;
        this.id = str;
        this.editMusicType = i;
        this.name = str2;
    }
}
