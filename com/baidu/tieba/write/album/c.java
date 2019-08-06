package com.baidu.tieba.write.album;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private String fiu;
    private final AlbumActivity jOc;
    private VideoFileInfo jOp;
    private ImageFileInfo jOq;
    private List<ImageFileInfo> jOr;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 9;
    private final List<com.baidu.tbadk.album.a> jOs = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.jOc = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.jOp = videoFileInfo;
    }

    public VideoFileInfo cAx() {
        return this.jOp;
    }

    public boolean cAy() {
        return !v.aa(cAB());
    }

    public boolean cAz() {
        return this.jOp != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.jOp == null || videoFileInfo == null || this.jOp.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void h(ImageFileInfo imageFileInfo) {
        this.jOq = imageFileInfo;
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

    public void cAA() {
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

    public List<ImageFileInfo> cAB() {
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

    public String cAC() {
        return this.fiu;
    }

    public void GG(String str) {
        this.fiu = str;
        GH(str);
    }

    private void GH(String str) {
        if (this.jOs != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.jOs) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.aap() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.aap()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.jOr = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> cAD() {
        return this.jOr;
    }

    public List<com.baidu.tbadk.album.a> cAE() {
        return this.jOs;
    }

    public List<MediaFileInfo> GI(String str) {
        if (this.jOs == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.jOs) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.aap();
            }
        }
        return null;
    }

    public boolean auT() {
        return v.aa(GI(com.baidu.tbadk.album.a.bAS));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.bBr;
            ArrayList arrayList = new ArrayList();
            arrayList.add(ev(list));
            if (!v.aa(gVar.bBs)) {
                arrayList.add(ew(gVar.bBs));
            }
            if (!v.aa(gVar.bBq)) {
                arrayList.addAll(gVar.bBq);
            }
            this.jOs.clear();
            this.jOs.addAll(arrayList);
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
        if (this.jOq == null || TextUtils.isEmpty(this.jOq.getFilePath())) {
            return 0;
        }
        if (this.jOr == null || this.jOr.size() == 0) {
            return 0;
        }
        int size = this.jOr.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.jOr.get(i);
            if (imageFileInfo != null && this.jOq.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a ev(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.lx(com.baidu.tbadk.album.a.bAS);
        aVar.setName(this.jOc.getPageContext().getString(R.string.album_all_media));
        int Z = v.Z(list);
        aVar.O(list);
        aVar.ly(String.valueOf(Z));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.c(list, Z - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a ew(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.lx(com.baidu.tbadk.album.a.bAT);
        aVar.setName(this.jOc.getPageContext().getString(R.string.album_all_video));
        int Z = v.Z(list);
        aVar.ly(String.valueOf(Z));
        ArrayList arrayList = new ArrayList();
        if (!v.aa(list)) {
            arrayList.addAll(list);
        }
        aVar.O(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) v.c(list, Z - 1);
        if (videoFileInfo != null) {
            aVar.a(videoFileInfo);
        }
        return aVar;
    }
}
