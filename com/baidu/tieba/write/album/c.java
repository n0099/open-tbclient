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
    private String fhT;
    private final AlbumActivity jMV;
    private VideoFileInfo jNi;
    private ImageFileInfo jNj;
    private List<ImageFileInfo> jNk;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 9;
    private final List<com.baidu.tbadk.album.a> jNl = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.jMV = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.jNi = videoFileInfo;
    }

    public VideoFileInfo cAc() {
        return this.jNi;
    }

    public boolean cAd() {
        return !v.aa(cAg());
    }

    public boolean cAe() {
        return this.jNi != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.jNi == null || videoFileInfo == null || this.jNi.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void h(ImageFileInfo imageFileInfo) {
        this.jNj = imageFileInfo;
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

    public void cAf() {
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

    public List<ImageFileInfo> cAg() {
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

    public String cAh() {
        return this.fhT;
    }

    public void GF(String str) {
        this.fhT = str;
        GG(str);
    }

    private void GG(String str) {
        if (this.jNl != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.jNl) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.aap() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.aap()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.jNk = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> cAi() {
        return this.jNk;
    }

    public List<com.baidu.tbadk.album.a> cAj() {
        return this.jNl;
    }

    public List<MediaFileInfo> GH(String str) {
        if (this.jNl == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.jNl) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.aap();
            }
        }
        return null;
    }

    public boolean auR() {
        return v.aa(GH(com.baidu.tbadk.album.a.bAS));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.bBr;
            ArrayList arrayList = new ArrayList();
            arrayList.add(ew(list));
            if (!v.aa(gVar.bBs)) {
                arrayList.add(ex(gVar.bBs));
            }
            if (!v.aa(gVar.bBq)) {
                arrayList.addAll(gVar.bBq);
            }
            this.jNl.clear();
            this.jNl.addAll(arrayList);
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
        if (this.jNj == null || TextUtils.isEmpty(this.jNj.getFilePath())) {
            return 0;
        }
        if (this.jNk == null || this.jNk.size() == 0) {
            return 0;
        }
        int size = this.jNk.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.jNk.get(i);
            if (imageFileInfo != null && this.jNj.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a ew(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.lx(com.baidu.tbadk.album.a.bAS);
        aVar.setName(this.jMV.getPageContext().getString(R.string.album_all_media));
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

    public com.baidu.tbadk.album.a ex(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.lx(com.baidu.tbadk.album.a.bAT);
        aVar.setName(this.jMV.getPageContext().getString(R.string.album_all_video));
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
