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
    private String dyX;
    private final AlbumActivity hVe;
    private VideoFileInfo hVr;
    private ImageFileInfo hVs;
    private List<ImageFileInfo> hVt;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 10;
    private final List<com.baidu.tbadk.album.a> hVu = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.hVe = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.hVr = videoFileInfo;
    }

    public VideoFileInfo bOu() {
        return this.hVr;
    }

    public boolean bOv() {
        return !v.I(bOy());
    }

    public boolean bOw() {
        return this.hVr != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.hVr == null || videoFileInfo == null || this.hVr.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.hVs = imageFileInfo;
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

    public void bOx() {
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

    public List<ImageFileInfo> bOy() {
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

    public String bOz() {
        return this.dyX;
    }

    public void xz(String str) {
        this.dyX = str;
        xA(str);
    }

    private void xA(String str) {
        if (this.hVu != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.hVu) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.we() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.we()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.hVt = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> bOA() {
        return this.hVt;
    }

    public List<com.baidu.tbadk.album.a> bOB() {
        return this.hVu;
    }

    public List<MediaFileInfo> xB(String str) {
        if (this.hVu == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.hVu) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.we();
            }
        }
        return null;
    }

    public boolean OL() {
        return v.I(xB(com.baidu.tbadk.album.a.alN));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.amm;
            ArrayList arrayList = new ArrayList();
            arrayList.add(eg(list));
            if (!v.I(gVar.amn)) {
                arrayList.add(eh(gVar.amn));
            }
            if (!v.I(gVar.aml)) {
                arrayList.addAll(gVar.aml);
            }
            this.hVu.clear();
            this.hVu.addAll(arrayList);
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
        if (this.hVs == null || TextUtils.isEmpty(this.hVs.getFilePath())) {
            return 0;
        }
        if (this.hVt == null || this.hVt.size() == 0) {
            return 0;
        }
        int size = this.hVt.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.hVt.get(i);
            if (imageFileInfo != null && this.hVs.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a eg(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.dC(com.baidu.tbadk.album.a.alN);
        aVar.setName(this.hVe.getPageContext().getString(e.j.album_all_media));
        int H = v.H(list);
        aVar.x(list);
        aVar.dD(String.valueOf(H));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.d(list, H - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a eh(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.dC(com.baidu.tbadk.album.a.alO);
        aVar.setName(this.hVe.getPageContext().getString(e.j.album_all_video));
        int H = v.H(list);
        aVar.dD(String.valueOf(H));
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
