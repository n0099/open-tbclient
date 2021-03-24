package com.baidu.tieba.video;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StringHelper;
import d.b.b.e.p.k;
import java.io.File;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class EditVideoData extends OrmObject implements Serializable {
    public String coverPath;
    public String filterName;
    public String finalPath;
    public boolean isMute;
    public String musicId;
    public String musicPath;
    public String originPath;

    public void copy(EditVideoData editVideoData) {
        if (editVideoData == null) {
            return;
        }
        this.originPath = editVideoData.originPath;
        this.coverPath = editVideoData.coverPath;
        this.musicPath = editVideoData.musicPath;
        this.musicId = editVideoData.musicId;
        this.isMute = editVideoData.isMute;
        this.filterName = editVideoData.filterName;
        this.finalPath = editVideoData.finalPath;
    }

    public void delete() {
        if (StringHelper.equals(this.originPath, this.finalPath) || k.isEmpty(this.finalPath)) {
            return;
        }
        FileHelper.deleteFile(new File(this.finalPath));
    }

    public boolean isLegal() {
        return (k.isEmpty(this.originPath) || k.isEmpty(this.coverPath)) ? false : true;
    }
}
