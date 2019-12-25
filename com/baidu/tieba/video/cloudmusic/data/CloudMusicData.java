package com.baidu.tieba.video.cloudmusic.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes7.dex */
public class CloudMusicData extends OrmObject {
    public List<MusicTagList> music_tag_list;
    public List<TagList> tag_list;

    /* loaded from: classes7.dex */
    public static class TagList extends OrmObject {
        public int id;
        public String name;
    }

    /* loaded from: classes7.dex */
    public static class MusicTagList extends OrmObject implements Serializable {
        private static final long serialVersionUID = 1;
        public List<MusicList> music_list;
        public Page page;
        public int tag_id;

        /* loaded from: classes7.dex */
        public static class Page extends OrmObject implements Serializable {
            private static final long serialVersionUID = 2;
            public int has_more;
            public int pn;
        }

        /* loaded from: classes7.dex */
        public static class MusicList extends OrmObject implements Serializable {
            private static final long serialVersionUID = 3;
            public String author;
            public int duration;
            public String image;
            public boolean isLoading = false;
            public int music_id;
            public String name;
            public String resource;

            public boolean equals(Object obj) {
                boolean z = true;
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                MusicList musicList = (MusicList) obj;
                if (this.duration == musicList.duration && this.music_id == musicList.music_id) {
                    if (this.name != null) {
                        if (!this.name.equals(musicList.name)) {
                            return false;
                        }
                    } else if (musicList.name != null) {
                        return false;
                    }
                    if (this.image != null) {
                        if (!this.image.equals(musicList.image)) {
                            return false;
                        }
                    } else if (musicList.image != null) {
                        return false;
                    }
                    if (this.resource != null) {
                        if (!this.resource.equals(musicList.resource)) {
                            return false;
                        }
                    } else if (musicList.resource != null) {
                        return false;
                    }
                    if (this.author != null) {
                        z = this.author.equals(musicList.author);
                    } else if (musicList.author != null) {
                        z = false;
                    }
                    return z;
                }
                return false;
            }

            public int hashCode() {
                return (((((((this.resource != null ? this.resource.hashCode() : 0) + (((this.image != null ? this.image.hashCode() : 0) + ((this.name != null ? this.name.hashCode() : 0) * 31)) * 31)) * 31) + (this.author != null ? this.author.hashCode() : 0)) * 31) + this.duration) * 31) + this.music_id;
            }
        }
    }
}
