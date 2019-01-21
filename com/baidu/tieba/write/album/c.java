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
    private String dzH;
    private ImageFileInfo hWA;
    private List<ImageFileInfo> hWB;
    private final AlbumActivity hWm;
    private VideoFileInfo hWz;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 10;
    private final List<com.baidu.tbadk.album.a> hWC = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.hWm = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.hWz = videoFileInfo;
    }

    public VideoFileInfo bPc() {
        return this.hWz;
    }

    public boolean bPd() {
        return !v.I(bPg());
    }

    public boolean bPe() {
        return this.hWz != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.hWz == null || videoFileInfo == null || this.hWz.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.hWA = imageFileInfo;
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

    public void bPf() {
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

    public List<ImageFileInfo> bPg() {
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

    public String bPh() {
        return this.dzH;
    }

    public void xP(String str) {
        this.dzH = str;
        xQ(str);
    }

    private void xQ(String str) {
        if (this.hWC != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.hWC) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.wl() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.wl()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.hWB = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> bPi() {
        return this.hWB;
    }

    public List<com.baidu.tbadk.album.a> bPj() {
        return this.hWC;
    }

    public List<MediaFileInfo> xR(String str) {
        if (this.hWC == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.hWC) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.wl();
            }
        }
        return null;
    }

    public boolean Pd() {
        return v.I(xR(com.baidu.tbadk.album.a.amh));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.amG;
            ArrayList arrayList = new ArrayList();
            arrayList.add(eh(list));
            if (!v.I(gVar.amH)) {
                arrayList.add(ei(gVar.amH));
            }
            if (!v.I(gVar.amF)) {
                arrayList.addAll(gVar.amF);
            }
            this.hWC.clear();
            this.hWC.addAll(arrayList);
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
        if (this.hWA == null || TextUtils.isEmpty(this.hWA.getFilePath())) {
            return 0;
        }
        if (this.hWB == null || this.hWB.size() == 0) {
            return 0;
        }
        int size = this.hWB.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.hWB.get(i);
            if (imageFileInfo != null && this.hWA.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a eh(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.dE(com.baidu.tbadk.album.a.amh);
        aVar.setName(this.hWm.getPageContext().getString(e.j.album_all_media));
        int H = v.H(list);
        aVar.x(list);
        aVar.dF(String.valueOf(H));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.d(list, H - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a ei(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.dE(com.baidu.tbadk.album.a.ami);
        aVar.setName(this.hWm.getPageContext().getString(e.j.album_all_video));
        int H = v.H(list);
        aVar.dF(String.valueOf(H));
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
