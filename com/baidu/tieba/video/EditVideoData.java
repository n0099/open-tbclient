package com.baidu.tieba.video;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.o;
import java.io.File;
import java.io.Serializable;
/* loaded from: classes.dex */
public class EditVideoData extends OrmObject implements Serializable {
    public String coverPath;
    public String filterName;
    public String finalPath;
    public boolean isMute;
    public String musicId;
    public String musicPath;
    public String originPath;

    public boolean isLegal() {
        return (au.isEmpty(this.originPath) || au.isEmpty(this.coverPath)) ? false : true;
    }

    public void delete() {
        if (!au.equals(this.originPath, this.finalPath) && !au.isEmpty(this.finalPath)) {
            o.deleteFile(new File(this.finalPath));
        }
    }

    public void copy(EditVideoData editVideoData) {
        if (editVideoData != null) {
            this.originPath = editVideoData.originPath;
            this.coverPath = editVideoData.coverPath;
            this.musicPath = editVideoData.musicPath;
            this.musicId = editVideoData.musicId;
            this.isMute = editVideoData.isMute;
            this.filterName = editVideoData.filterName;
            this.finalPath = editVideoData.finalPath;
        }
    }
}
