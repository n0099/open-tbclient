package com.baidu.tieba.write.album;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e {
    private String cAH;
    private List<ImageFileInfo> hfA;
    private final AlbumActivity hfk;
    private VideoFileInfo hfy;
    private ImageFileInfo hfz;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 10;
    private final List<com.baidu.tbadk.album.a> hfB = new ArrayList();

    public e(AlbumActivity albumActivity) {
        this.hfk = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.hfy = videoFileInfo;
    }

    public VideoFileInfo bGo() {
        return this.hfy;
    }

    public boolean bGp() {
        return !v.w(bGs());
    }

    public boolean bGq() {
        return this.hfy != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.hfy == null || videoFileInfo == null || this.hfy.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.hfz = imageFileInfo;
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

    public void bGr() {
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

    public List<ImageFileInfo> bGs() {
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

    public String bGt() {
        return this.cAH;
    }

    public void uE(String str) {
        this.cAH = str;
        uF(str);
    }

    private void uF(String str) {
        if (this.hfB != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.hfB) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.nz() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.nz()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.hfA = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> bGu() {
        return this.hfA;
    }

    public List<com.baidu.tbadk.album.a> bGv() {
        return this.hfB;
    }

    public List<MediaFileInfo> uG(String str) {
        if (this.hfB == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.hfB) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.nz();
            }
        }
        return null;
    }

    public boolean FP() {
        return v.w(uG(com.baidu.tbadk.album.a.Rg));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.RF;
            ArrayList arrayList = new ArrayList();
            arrayList.add(dU(list));
            if (!v.w(gVar.RG)) {
                arrayList.add(dV(gVar.RG));
            }
            if (!v.w(gVar.RE)) {
                arrayList.addAll(gVar.RE);
            }
            this.hfB.clear();
            this.hfB.addAll(arrayList);
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
        if (this.hfz == null || TextUtils.isEmpty(this.hfz.getFilePath())) {
            return 0;
        }
        if (this.hfA == null || this.hfA.size() == 0) {
            return 0;
        }
        int size = this.hfA.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.hfA.get(i);
            if (imageFileInfo != null && this.hfz.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a dU(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.ca(com.baidu.tbadk.album.a.Rg);
        aVar.setName(this.hfk.getPageContext().getString(d.j.album_all_media));
        int v = v.v(list);
        aVar.l(list);
        aVar.cb(String.valueOf(v));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.c(list, v - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a dV(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.ca(com.baidu.tbadk.album.a.Rh);
        aVar.setName(this.hfk.getPageContext().getString(d.j.album_all_video));
        int v = v.v(list);
        aVar.cb(String.valueOf(v));
        ArrayList arrayList = new ArrayList();
        if (!v.w(list)) {
            arrayList.addAll(list);
        }
        aVar.l(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) v.c(list, v - 1);
        if (videoFileInfo != null) {
            aVar.a(videoFileInfo);
        }
        return aVar;
    }
}
