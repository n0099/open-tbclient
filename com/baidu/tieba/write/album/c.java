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
    private String cQK;
    private final AlbumActivity hcB;
    private VideoFileInfo hcO;
    private ImageFileInfo hcP;
    private List<ImageFileInfo> hcQ;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 10;
    private final List<com.baidu.tbadk.album.a> hcR = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.hcB = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.hcO = videoFileInfo;
    }

    public VideoFileInfo bBB() {
        return this.hcO;
    }

    public boolean bBC() {
        return !v.w(bBF());
    }

    public boolean bBD() {
        return this.hcO != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.hcO == null || videoFileInfo == null || this.hcO.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.hcP = imageFileInfo;
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

    public void bBE() {
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

    public List<ImageFileInfo> bBF() {
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

    public String bBG() {
        return this.cQK;
    }

    public void uJ(String str) {
        this.cQK = str;
        uK(str);
    }

    private void uK(String str) {
        if (this.hcR != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.hcR) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.ov() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.ov()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.hcQ = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> bBH() {
        return this.hcQ;
    }

    public List<com.baidu.tbadk.album.a> bBI() {
        return this.hcR;
    }

    public List<MediaFileInfo> uL(String str) {
        if (this.hcR == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.hcR) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.ov();
            }
        }
        return null;
    }

    public boolean Gk() {
        return v.w(uL(com.baidu.tbadk.album.a.Sf));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.SE;
            ArrayList arrayList = new ArrayList();
            arrayList.add(dJ(list));
            if (!v.w(gVar.SF)) {
                arrayList.add(dK(gVar.SF));
            }
            if (!v.w(gVar.SD)) {
                arrayList.addAll(gVar.SD);
            }
            this.hcR.clear();
            this.hcR.addAll(arrayList);
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
        if (this.hcP == null || TextUtils.isEmpty(this.hcP.getFilePath())) {
            return 0;
        }
        if (this.hcQ == null || this.hcQ.size() == 0) {
            return 0;
        }
        int size = this.hcQ.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.hcQ.get(i);
            if (imageFileInfo != null && this.hcP.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a dJ(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.cf(com.baidu.tbadk.album.a.Sf);
        aVar.setName(this.hcB.getPageContext().getString(d.k.album_all_media));
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

    public com.baidu.tbadk.album.a dK(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.cf(com.baidu.tbadk.album.a.Sg);
        aVar.setName(this.hcB.getPageContext().getString(d.k.album_all_video));
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
