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
    private String dpK;
    private final AlbumActivity hKI;
    private VideoFileInfo hKV;
    private ImageFileInfo hKW;
    private List<ImageFileInfo> hKX;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 10;
    private final List<com.baidu.tbadk.album.a> hKY = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.hKI = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.hKV = videoFileInfo;
    }

    public VideoFileInfo bLy() {
        return this.hKV;
    }

    public boolean bLz() {
        return !v.I(bLC());
    }

    public boolean bLA() {
        return this.hKV != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.hKV == null || videoFileInfo == null || this.hKV.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.hKW = imageFileInfo;
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

    public void bLB() {
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

    public List<ImageFileInfo> bLC() {
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

    public String bLD() {
        return this.dpK;
    }

    public void wT(String str) {
        this.dpK = str;
        wU(str);
    }

    private void wU(String str) {
        if (this.hKY != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.hKY) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.va() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.va()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.hKX = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> bLE() {
        return this.hKX;
    }

    public List<com.baidu.tbadk.album.a> bLF() {
        return this.hKY;
    }

    public List<MediaFileInfo> wV(String str) {
        if (this.hKY == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.hKY) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.va();
            }
        }
        return null;
    }

    public boolean NG() {
        return v.I(wV(com.baidu.tbadk.album.a.ail));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.aiK;
            ArrayList arrayList = new ArrayList();
            arrayList.add(eb(list));
            if (!v.I(gVar.aiL)) {
                arrayList.add(ec(gVar.aiL));
            }
            if (!v.I(gVar.aiJ)) {
                arrayList.addAll(gVar.aiJ);
            }
            this.hKY.clear();
            this.hKY.addAll(arrayList);
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
        if (this.hKW == null || TextUtils.isEmpty(this.hKW.getFilePath())) {
            return 0;
        }
        if (this.hKX == null || this.hKX.size() == 0) {
            return 0;
        }
        int size = this.hKX.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.hKX.get(i);
            if (imageFileInfo != null && this.hKW.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a eb(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.dn(com.baidu.tbadk.album.a.ail);
        aVar.setName(this.hKI.getPageContext().getString(e.j.album_all_media));
        int H = v.H(list);
        aVar.x(list);
        aVar.m14do(String.valueOf(H));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.d(list, H - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a ec(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.dn(com.baidu.tbadk.album.a.aim);
        aVar.setName(this.hKI.getPageContext().getString(e.j.album_all_video));
        int H = v.H(list);
        aVar.m14do(String.valueOf(H));
        ArrayList arrayList = new ArrayList();
        if (!v.I(list)) {
            arrayList.addAll(list);
        }
        aVar.x(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) v.d(list, H - 1);
        if (videoFileInfo != null) {
            aVar.a(videoFileInfo);
        }
        return aVar;
    }
}
