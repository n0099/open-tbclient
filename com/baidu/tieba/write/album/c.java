package com.baidu.tieba.write.album;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private String cXS;
    private final AlbumActivity hsG;
    private VideoFileInfo hsT;
    private ImageFileInfo hsU;
    private List<ImageFileInfo> hsV;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 10;
    private final List<com.baidu.tbadk.album.a> hsW = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.hsG = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.hsT = videoFileInfo;
    }

    public VideoFileInfo bHi() {
        return this.hsT;
    }

    public boolean bHj() {
        return !w.A(bHm());
    }

    public boolean bHk() {
        return this.hsT != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.hsT == null || videoFileInfo == null || this.hsT.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.hsU = imageFileInfo;
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

    public void bHl() {
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

    public List<ImageFileInfo> bHm() {
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

    public String bHn() {
        return this.cXS;
    }

    public void vz(String str) {
        this.cXS = str;
        vA(str);
    }

    private void vA(String str) {
        if (this.hsW != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.hsW) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.rQ() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.rQ()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.hsV = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> bHo() {
        return this.hsV;
    }

    public List<com.baidu.tbadk.album.a> bHp() {
        return this.hsW;
    }

    public List<MediaFileInfo> vB(String str) {
        if (this.hsW == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.hsW) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.rQ();
            }
        }
        return null;
    }

    public boolean Kk() {
        return w.A(vB(com.baidu.tbadk.album.a.aas));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.aaR;
            ArrayList arrayList = new ArrayList();
            arrayList.add(dS(list));
            if (!w.A(gVar.aaS)) {
                arrayList.add(dT(gVar.aaS));
            }
            if (!w.A(gVar.aaQ)) {
                arrayList.addAll(gVar.aaQ);
            }
            this.hsW.clear();
            this.hsW.addAll(arrayList);
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
        if (this.hsU == null || TextUtils.isEmpty(this.hsU.getFilePath())) {
            return 0;
        }
        if (this.hsV == null || this.hsV.size() == 0) {
            return 0;
        }
        int size = this.hsV.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.hsV.get(i);
            if (imageFileInfo != null && this.hsU.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a dS(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.cI(com.baidu.tbadk.album.a.aas);
        aVar.setName(this.hsG.getPageContext().getString(d.k.album_all_media));
        int z = w.z(list);
        aVar.p(list);
        aVar.cJ(String.valueOf(z));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) w.d(list, z - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a dT(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.cI(com.baidu.tbadk.album.a.aat);
        aVar.setName(this.hsG.getPageContext().getString(d.k.album_all_video));
        int z = w.z(list);
        aVar.cJ(String.valueOf(z));
        ArrayList arrayList = new ArrayList();
        if (!w.A(list)) {
            arrayList.addAll(list);
        }
        aVar.p(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) w.d(list, z - 1);
        if (videoFileInfo != null) {
            aVar.a(videoFileInfo);
        }
        return aVar;
    }
}
