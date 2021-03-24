package com.baidu.tieba.video.cloudmusic.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes5.dex */
public class CloudMusicData extends OrmObject {
    public List<MusicTagList> music_tag_list;
    public List<TagList> tag_list;

    /* loaded from: classes5.dex */
    public static class MusicTagList extends OrmObject implements Serializable {
        public static final long serialVersionUID = 1;
        public List<MusicList> music_list;
        public Page page;
        public int tag_id;

        /* loaded from: classes5.dex */
        public static class MusicList extends OrmObject implements Serializable {
            public static final long serialVersionUID = 3;
            public String author;
            public int duration;
            public String image;
            public boolean isLoading = false;
            public int music_id;
            public String name;
            public String resource;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || MusicList.class != obj.getClass()) {
                    return false;
                }
                MusicList musicList = (MusicList) obj;
                if (this.duration == musicList.duration && this.music_id == musicList.music_id) {
                    String str = this.name;
                    if (str == null ? musicList.name == null : str.equals(musicList.name)) {
                        String str2 = this.image;
                        if (str2 == null ? musicList.image == null : str2.equals(musicList.image)) {
                            String str3 = this.resource;
                            if (str3 == null ? musicList.resource == null : str3.equals(musicList.resource)) {
                                String str4 = this.author;
                                String str5 = musicList.author;
                                return str4 != null ? str4.equals(str5) : str5 == null;
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }

            public int hashCode() {
                String str = this.name;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.image;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                String str3 = this.resource;
                int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
                String str4 = this.author;
                return ((((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.duration) * 31) + this.music_id;
            }
        }

        /* loaded from: classes5.dex */
        public static class Page extends OrmObject implements Serializable {
            public static final long serialVersionUID = 2;
            public int has_more;
            public int pn;
        }
    }

    /* loaded from: classes5.dex */
    public static class TagList extends OrmObject {
        public int id;
        public String name;
    }
}
