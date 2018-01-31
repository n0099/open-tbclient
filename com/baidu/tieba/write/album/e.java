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
    private String duj;
    private VideoFileInfo hDA;
    private ImageFileInfo hDB;
    private List<ImageFileInfo> hDC;
    private final AlbumActivity hDn;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 10;
    private final List<com.baidu.tbadk.album.a> hDD = new ArrayList();

    public e(AlbumActivity albumActivity) {
        this.hDn = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.hDA = videoFileInfo;
    }

    public VideoFileInfo bFy() {
        return this.hDA;
    }

    public boolean bFz() {
        return !v.E(bFC());
    }

    public boolean bFA() {
        return this.hDA != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.hDA == null || videoFileInfo == null || this.hDA.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.hDB = imageFileInfo;
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

    public void bFB() {
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

    public List<ImageFileInfo> bFC() {
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

    public String bFD() {
        return this.duj;
    }

    public void uj(String str) {
        this.duj = str;
        uk(str);
    }

    private void uk(String str) {
        if (this.hDD != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.hDD) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.vd() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.vd()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.hDC = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> bFE() {
        return this.hDC;
    }

    public List<com.baidu.tbadk.album.a> bFF() {
        return this.hDD;
    }

    public List<MediaFileInfo> ul(String str) {
        if (this.hDD == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.hDD) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.vd();
            }
        }
        return null;
    }

    public boolean Ne() {
        return v.E(ul(com.baidu.tbadk.album.a.aFQ));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.aGp;
            ArrayList arrayList = new ArrayList();
            arrayList.add(dJ(list));
            if (!v.E(gVar.aGq)) {
                arrayList.add(dK(gVar.aGq));
            }
            if (!v.E(gVar.aGo)) {
                arrayList.addAll(gVar.aGo);
            }
            this.hDD.clear();
            this.hDD.addAll(arrayList);
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
        if (this.hDB == null || TextUtils.isEmpty(this.hDB.getFilePath())) {
            return 0;
        }
        if (this.hDC == null || this.hDC.size() == 0) {
            return 0;
        }
        int size = this.hDC.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.hDC.get(i);
            if (imageFileInfo != null && this.hDB.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a dJ(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.ch(com.baidu.tbadk.album.a.aFQ);
        aVar.setName(this.hDn.getPageContext().getString(d.j.album_all_media));
        int D = v.D(list);
        aVar.v(list);
        aVar.ci(String.valueOf(D));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.f(list, D - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a dK(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.ch(com.baidu.tbadk.album.a.aFR);
        aVar.setName(this.hDn.getPageContext().getString(d.j.album_all_video));
        int D = v.D(list);
        aVar.ci(String.valueOf(D));
        ArrayList arrayList = new ArrayList();
        if (!v.E(list)) {
            arrayList.addAll(list);
        }
        aVar.v(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) v.f(list, D - 1);
        if (videoFileInfo != null) {
            aVar.a(videoFileInfo);
        }
        return aVar;
    }
}
