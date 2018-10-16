package com.baidu.tieba.write.album;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private String doG;
    private final AlbumActivity hIX;
    private VideoFileInfo hJk;
    private ImageFileInfo hJl;
    private List<ImageFileInfo> hJm;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 10;
    private final List<com.baidu.tbadk.album.a> hJn = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.hIX = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.hJk = videoFileInfo;
    }

    public VideoFileInfo bLZ() {
        return this.hJk;
    }

    public boolean bMa() {
        return !v.J(bMd());
    }

    public boolean bMb() {
        return this.hJk != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.hJk == null || videoFileInfo == null || this.hJk.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.hJl = imageFileInfo;
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

    public void bMc() {
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

    public List<ImageFileInfo> bMd() {
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

    public String bMe() {
        return this.doG;
    }

    public void wO(String str) {
        this.doG = str;
        wP(str);
    }

    private void wP(String str) {
        if (this.hJn != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.hJn) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.uQ() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.uQ()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.hJm = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> bMf() {
        return this.hJm;
    }

    public List<com.baidu.tbadk.album.a> bMg() {
        return this.hJn;
    }

    public List<MediaFileInfo> wQ(String str) {
        if (this.hJn == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.hJn) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.uQ();
            }
        }
        return null;
    }

    public boolean Nx() {
        return v.J(wQ(com.baidu.tbadk.album.a.ahy));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.ahX;
            ArrayList arrayList = new ArrayList();
            arrayList.add(ed(list));
            if (!v.J(gVar.ahY)) {
                arrayList.add(ee(gVar.ahY));
            }
            if (!v.J(gVar.ahW)) {
                arrayList.addAll(gVar.ahW);
            }
            this.hJn.clear();
            this.hJn.addAll(arrayList);
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
        if (this.hJl == null || TextUtils.isEmpty(this.hJl.getFilePath())) {
            return 0;
        }
        if (this.hJm == null || this.hJm.size() == 0) {
            return 0;
        }
        int size = this.hJm.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.hJm.get(i);
            if (imageFileInfo != null && this.hJl.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a ed(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.dn(com.baidu.tbadk.album.a.ahy);
        aVar.setName(this.hIX.getPageContext().getString(e.j.album_all_media));
        int I = v.I(list);
        aVar.y(list);
        aVar.m15do(String.valueOf(I));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.d(list, I - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a ee(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.dn(com.baidu.tbadk.album.a.ahz);
        aVar.setName(this.hIX.getPageContext().getString(e.j.album_all_video));
        int I = v.I(list);
        aVar.m15do(String.valueOf(I));
        ArrayList arrayList = new ArrayList();
        if (!v.J(list)) {
            arrayList.addAll(list);
        }
        aVar.y(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) v.d(list, I - 1);
        if (videoFileInfo != null) {
            aVar.a(videoFileInfo);
        }
        return aVar;
    }
}
