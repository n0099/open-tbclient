package com.baidu.tieba.write.album;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private String fcT;
    private final AlbumActivity jFP;
    private VideoFileInfo jGc;
    private ImageFileInfo jGd;
    private List<ImageFileInfo> jGe;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 9;
    private final List<com.baidu.tbadk.album.a> jGf = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.jFP = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.jGc = videoFileInfo;
    }

    public VideoFileInfo cxc() {
        return this.jGc;
    }

    public boolean cxd() {
        return !v.aa(cxg());
    }

    public boolean cxe() {
        return this.jGc != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.jGc == null || videoFileInfo == null || this.jGc.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void h(ImageFileInfo imageFileInfo) {
        this.jGd = imageFileInfo;
    }

    public void addChooseFile(ImageFileInfo imageFileInfo) {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.mWriteImagesInfo.addChooseFile(imageFileInfo);
    }

    public void delChooseFile(ImageFileInfo imageFileInfo) {
        if (this.mWriteImagesInfo != null) {
            this.mWriteImagesInfo.delChooseFile(imageFileInfo);
        }
    }

    public void cxf() {
        if (this.mWriteImagesInfo != null) {
            this.mWriteImagesInfo.clear();
        }
    }

    public boolean isAdded(ImageFileInfo imageFileInfo) {
        if (this.mWriteImagesInfo == null) {
            return false;
        }
        return this.mWriteImagesInfo.isAdded(imageFileInfo);
    }

    public List<ImageFileInfo> cxg() {
        if (this.mWriteImagesInfo != null) {
            return this.mWriteImagesInfo.getChosedFiles();
        }
        return null;
    }

    public WriteImagesInfo getWriteImagesInfo() {
        return this.mWriteImagesInfo;
    }

    public void setWriteImagesInfo(WriteImagesInfo writeImagesInfo) {
        this.mWriteImagesInfo = writeImagesInfo;
    }

    public String getLastAlbumId() {
        if (this.mWriteImagesInfo != null) {
            return this.mWriteImagesInfo.getLastAlbumId();
        }
        return null;
    }

    public void setLastAlbumId(String str) {
        if (this.mWriteImagesInfo == null) {
            this.mWriteImagesInfo = new WriteImagesInfo(this.maxImagesAllowed);
        }
        this.mWriteImagesInfo.setLastAlbumId(str);
    }

    public int getMaxImagesAllowed() {
        if (this.mWriteImagesInfo != null) {
            return this.mWriteImagesInfo.getMaxImagesAllowed();
        }
        return 0;
    }

    public String cxh() {
        return this.fcT;
    }

    public void FJ(String str) {
        this.fcT = str;
        FK(str);
    }

    private void FK(String str) {
        if (this.jGf != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.jGf) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.Zq() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.Zq()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.jGe = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> cxi() {
        return this.jGe;
    }

    public List<com.baidu.tbadk.album.a> cxj() {
        return this.jGf;
    }

    public List<MediaFileInfo> FL(String str) {
        if (this.jGf == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.jGf) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.Zq();
            }
        }
        return null;
    }

    public boolean atJ() {
        return v.aa(FL(com.baidu.tbadk.album.a.bzV));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.bAu;
            ArrayList arrayList = new ArrayList();
            arrayList.add(et(list));
            if (!v.aa(gVar.bAv)) {
                arrayList.add(eu(gVar.bAv));
            }
            if (!v.aa(gVar.bAt)) {
                arrayList.addAll(gVar.bAt);
            }
            this.jGf.clear();
            this.jGf.addAll(arrayList);
        }
    }

    public int size() {
        if (this.mWriteImagesInfo == null) {
            return 0;
        }
        return this.mWriteImagesInfo.size();
    }

    public void setOriginalImg(boolean z) {
        if (this.mWriteImagesInfo != null) {
            this.mWriteImagesInfo.setOriginalImg(z);
        }
    }

    public boolean isOriginalImg() {
        if (this.mWriteImagesInfo != null) {
            return this.mWriteImagesInfo.isOriginalImg();
        }
        return false;
    }

    public int getCurrentIndex() {
        if (this.jGd == null || TextUtils.isEmpty(this.jGd.getFilePath())) {
            return 0;
        }
        if (this.jGe == null || this.jGe.size() == 0) {
            return 0;
        }
        int size = this.jGe.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.jGe.get(i);
            if (imageFileInfo != null && this.jGd.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a et(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.lq(com.baidu.tbadk.album.a.bzV);
        aVar.setName(this.jFP.getPageContext().getString(R.string.album_all_media));
        int Z = v.Z(list);
        aVar.O(list);
        aVar.lr(String.valueOf(Z));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.c(list, Z - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a eu(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.lq(com.baidu.tbadk.album.a.bzW);
        aVar.setName(this.jFP.getPageContext().getString(R.string.album_all_video));
        int Z = v.Z(list);
        aVar.lr(String.valueOf(Z));
        ArrayList arrayList = new ArrayList();
        if (!v.aa(list)) {
            arrayList.addAll(list);
        }
        aVar.O(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) v.c(list, Z - 1);
        if (videoFileInfo != null) {
            aVar.a(videoFileInfo);
        }
        return aVar;
    }
}
