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
    private String cZP;
    private VideoFileInfo hoJ;
    private ImageFileInfo hoK;
    private List<ImageFileInfo> hoL;
    private final AlbumActivity how;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 10;
    private final List<com.baidu.tbadk.album.a> hoM = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.how = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.hoJ = videoFileInfo;
    }

    public VideoFileInfo bGH() {
        return this.hoJ;
    }

    public boolean bGI() {
        return !w.z(bGL());
    }

    public boolean bGJ() {
        return this.hoJ != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.hoJ == null || videoFileInfo == null || this.hoJ.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.hoK = imageFileInfo;
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

    public void bGK() {
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

    public List<ImageFileInfo> bGL() {
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

    public String bGM() {
        return this.cZP;
    }

    public void vD(String str) {
        this.cZP = str;
        vE(str);
    }

    private void vE(String str) {
        if (this.hoM != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.hoM) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.rQ() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.rQ()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.hoL = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> bGN() {
        return this.hoL;
    }

    public List<com.baidu.tbadk.album.a> bGO() {
        return this.hoM;
    }

    public List<MediaFileInfo> vF(String str) {
        if (this.hoM == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.hoM) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.rQ();
            }
        }
        return null;
    }

    public boolean JS() {
        return w.z(vF(com.baidu.tbadk.album.a.aap));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.aaO;
            ArrayList arrayList = new ArrayList();
            arrayList.add(dP(list));
            if (!w.z(gVar.aaP)) {
                arrayList.add(dQ(gVar.aaP));
            }
            if (!w.z(gVar.aaN)) {
                arrayList.addAll(gVar.aaN);
            }
            this.hoM.clear();
            this.hoM.addAll(arrayList);
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
        if (this.hoK == null || TextUtils.isEmpty(this.hoK.getFilePath())) {
            return 0;
        }
        if (this.hoL == null || this.hoL.size() == 0) {
            return 0;
        }
        int size = this.hoL.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.hoL.get(i);
            if (imageFileInfo != null && this.hoK.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a dP(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.cG(com.baidu.tbadk.album.a.aap);
        aVar.setName(this.how.getPageContext().getString(d.k.album_all_media));
        int y = w.y(list);
        aVar.p(list);
        aVar.cH(String.valueOf(y));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) w.c(list, y - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a dQ(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.cG(com.baidu.tbadk.album.a.aaq);
        aVar.setName(this.how.getPageContext().getString(d.k.album_all_video));
        int y = w.y(list);
        aVar.cH(String.valueOf(y));
        ArrayList arrayList = new ArrayList();
        if (!w.z(list)) {
            arrayList.addAll(list);
        }
        aVar.p(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) w.c(list, y - 1);
        if (videoFileInfo != null) {
            aVar.a(videoFileInfo);
        }
        return aVar;
    }
}
