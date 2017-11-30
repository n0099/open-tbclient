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
    private String cAz;
    private VideoFileInfo hcI;
    private ImageFileInfo hcJ;
    private List<ImageFileInfo> hcK;
    private final AlbumActivity hcu;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 10;
    private final List<com.baidu.tbadk.album.a> hcL = new ArrayList();

    public e(AlbumActivity albumActivity) {
        this.hcu = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.hcI = videoFileInfo;
    }

    public VideoFileInfo bFC() {
        return this.hcI;
    }

    public boolean bFD() {
        return !v.w(bFG());
    }

    public boolean bFE() {
        return this.hcI != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.hcI == null || videoFileInfo == null || this.hcI.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.hcJ = imageFileInfo;
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

    public void bFF() {
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

    public List<ImageFileInfo> bFG() {
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

    public String bFH() {
        return this.cAz;
    }

    public void uz(String str) {
        this.cAz = str;
        uA(str);
    }

    private void uA(String str) {
        if (this.hcL != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.hcL) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.nC() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.nC()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.hcK = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> bFI() {
        return this.hcK;
    }

    public List<com.baidu.tbadk.album.a> bFJ() {
        return this.hcL;
    }

    public List<MediaFileInfo> uB(String str) {
        if (this.hcL == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.hcL) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.nC();
            }
        }
        return null;
    }

    public boolean FO() {
        return v.w(uB(com.baidu.tbadk.album.a.Ri));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.RI;
            ArrayList arrayList = new ArrayList();
            arrayList.add(dV(list));
            if (!v.w(gVar.RJ)) {
                arrayList.add(dW(gVar.RJ));
            }
            if (!v.w(gVar.RH)) {
                arrayList.addAll(gVar.RH);
            }
            this.hcL.clear();
            this.hcL.addAll(arrayList);
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
        if (this.hcJ == null || TextUtils.isEmpty(this.hcJ.getFilePath())) {
            return 0;
        }
        if (this.hcK == null || this.hcK.size() == 0) {
            return 0;
        }
        int size = this.hcK.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.hcK.get(i);
            if (imageFileInfo != null && this.hcJ.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a dV(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.ca(com.baidu.tbadk.album.a.Ri);
        aVar.setName(this.hcu.getPageContext().getString(d.j.album_all_media));
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

    public com.baidu.tbadk.album.a dW(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.ca(com.baidu.tbadk.album.a.Rj);
        aVar.setName(this.hcu.getPageContext().getString(d.j.album_all_video));
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
