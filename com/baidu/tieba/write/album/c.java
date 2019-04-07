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
    private String eMJ;
    private final AlbumActivity jmL;
    private VideoFileInfo jmY;
    private ImageFileInfo jmZ;
    private List<ImageFileInfo> jna;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 9;
    private final List<com.baidu.tbadk.album.a> jnb = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.jmL = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.jmY = videoFileInfo;
    }

    public VideoFileInfo coU() {
        return this.jmY;
    }

    public boolean coV() {
        return !v.T(coY());
    }

    public boolean coW() {
        return this.jmY != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.jmY == null || videoFileInfo == null || this.jmY.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void g(ImageFileInfo imageFileInfo) {
        this.jmZ = imageFileInfo;
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

    public void coX() {
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

    public List<ImageFileInfo> coY() {
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

    public String coZ() {
        return this.eMJ;
    }

    public void En(String str) {
        this.eMJ = str;
        Eo(str);
    }

    private void Eo(String str) {
        if (this.jnb != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.jnb) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.UM() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.UM()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.jna = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> cpa() {
        return this.jna;
    }

    public List<com.baidu.tbadk.album.a> cpb() {
        return this.jnb;
    }

    public List<MediaFileInfo> Ep(String str) {
        if (this.jnb == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.jnb) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.UM();
            }
        }
        return null;
    }

    public boolean aoF() {
        return v.T(Ep(com.baidu.tbadk.album.a.bsR));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.btr;
            ArrayList arrayList = new ArrayList();
            arrayList.add(ej(list));
            if (!v.T(gVar.bts)) {
                arrayList.add(ek(gVar.bts));
            }
            if (!v.T(gVar.btq)) {
                arrayList.addAll(gVar.btq);
            }
            this.jnb.clear();
            this.jnb.addAll(arrayList);
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
        if (this.jmZ == null || TextUtils.isEmpty(this.jmZ.getFilePath())) {
            return 0;
        }
        if (this.jna == null || this.jna.size() == 0) {
            return 0;
        }
        int size = this.jna.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.jna.get(i);
            if (imageFileInfo != null && this.jmZ.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a ej(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.kn(com.baidu.tbadk.album.a.bsR);
        aVar.setName(this.jmL.getPageContext().getString(d.j.album_all_media));
        int S = v.S(list);
        aVar.H(list);
        aVar.ko(String.valueOf(S));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.c(list, S - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a ek(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.kn(com.baidu.tbadk.album.a.bsS);
        aVar.setName(this.jmL.getPageContext().getString(d.j.album_all_video));
        int S = v.S(list);
        aVar.ko(String.valueOf(S));
        ArrayList arrayList = new ArrayList();
        if (!v.T(list)) {
            arrayList.addAll(list);
        }
        aVar.H(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) v.c(list, S - 1);
        if (videoFileInfo != null) {
            aVar.a(videoFileInfo);
        }
        return aVar;
    }
}
