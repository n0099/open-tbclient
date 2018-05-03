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
/* loaded from: classes3.dex */
public class c {
    private String cPD;
    private VideoFileInfo hbK;
    private ImageFileInfo hbL;
    private List<ImageFileInfo> hbM;
    private final AlbumActivity hbx;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 10;
    private final List<com.baidu.tbadk.album.a> hbN = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.hbx = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.hbK = videoFileInfo;
    }

    public VideoFileInfo bBD() {
        return this.hbK;
    }

    public boolean bBE() {
        return !v.w(bBH());
    }

    public boolean bBF() {
        return this.hbK != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.hbK == null || videoFileInfo == null || this.hbK.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.hbL = imageFileInfo;
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

    public void bBG() {
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

    public List<ImageFileInfo> bBH() {
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

    public String bBI() {
        return this.cPD;
    }

    public void uG(String str) {
        this.cPD = str;
        uH(str);
    }

    private void uH(String str) {
        if (this.hbN != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.hbN) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.ow() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.ow()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.hbM = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> bBJ() {
        return this.hbM;
    }

    public List<com.baidu.tbadk.album.a> bBK() {
        return this.hbN;
    }

    public List<MediaFileInfo> uI(String str) {
        if (this.hbN == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.hbN) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.ow();
            }
        }
        return null;
    }

    public boolean Gm() {
        return v.w(uI(com.baidu.tbadk.album.a.Sj));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.SJ;
            ArrayList arrayList = new ArrayList();
            arrayList.add(dG(list));
            if (!v.w(gVar.SK)) {
                arrayList.add(dH(gVar.SK));
            }
            if (!v.w(gVar.SH)) {
                arrayList.addAll(gVar.SH);
            }
            this.hbN.clear();
            this.hbN.addAll(arrayList);
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
        if (this.hbL == null || TextUtils.isEmpty(this.hbL.getFilePath())) {
            return 0;
        }
        if (this.hbM == null || this.hbM.size() == 0) {
            return 0;
        }
        int size = this.hbM.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.hbM.get(i);
            if (imageFileInfo != null && this.hbL.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a dG(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.cf(com.baidu.tbadk.album.a.Sj);
        aVar.setName(this.hbx.getPageContext().getString(d.k.album_all_media));
        int v = v.v(list);
        aVar.m(list);
        aVar.cg(String.valueOf(v));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.c(list, v - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a dH(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.cf(com.baidu.tbadk.album.a.Sk);
        aVar.setName(this.hbx.getPageContext().getString(d.k.album_all_video));
        int v = v.v(list);
        aVar.cg(String.valueOf(v));
        ArrayList arrayList = new ArrayList();
        if (!v.w(list)) {
            arrayList.addAll(list);
        }
        aVar.m(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) v.c(list, v - 1);
        if (videoFileInfo != null) {
            aVar.a(videoFileInfo);
        }
        return aVar;
    }
}
