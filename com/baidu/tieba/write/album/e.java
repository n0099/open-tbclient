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
    private String dtO;
    private final AlbumActivity hCT;
    private VideoFileInfo hDg;
    private ImageFileInfo hDh;
    private List<ImageFileInfo> hDi;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 10;
    private final List<com.baidu.tbadk.album.a> hDj = new ArrayList();

    public e(AlbumActivity albumActivity) {
        this.hCT = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.hDg = videoFileInfo;
    }

    public VideoFileInfo bFw() {
        return this.hDg;
    }

    public boolean bFx() {
        return !v.E(bFA());
    }

    public boolean bFy() {
        return this.hDg != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.hDg == null || videoFileInfo == null || this.hDg.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.hDh = imageFileInfo;
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

    public void bFz() {
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

    public List<ImageFileInfo> bFA() {
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

    public String bFB() {
        return this.dtO;
    }

    public void uc(String str) {
        this.dtO = str;
        ud(str);
    }

    private void ud(String str) {
        if (this.hDj != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.hDj) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.vc() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.vc()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.hDi = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> bFC() {
        return this.hDi;
    }

    public List<com.baidu.tbadk.album.a> bFD() {
        return this.hDj;
    }

    public List<MediaFileInfo> ue(String str) {
        if (this.hDj == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.hDj) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.vc();
            }
        }
        return null;
    }

    public boolean Nc() {
        return v.E(ue(com.baidu.tbadk.album.a.aFN));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.aGm;
            ArrayList arrayList = new ArrayList();
            arrayList.add(dJ(list));
            if (!v.E(gVar.aGn)) {
                arrayList.add(dK(gVar.aGn));
            }
            if (!v.E(gVar.aGl)) {
                arrayList.addAll(gVar.aGl);
            }
            this.hDj.clear();
            this.hDj.addAll(arrayList);
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
        if (this.hDh == null || TextUtils.isEmpty(this.hDh.getFilePath())) {
            return 0;
        }
        if (this.hDi == null || this.hDi.size() == 0) {
            return 0;
        }
        int size = this.hDi.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.hDi.get(i);
            if (imageFileInfo != null && this.hDh.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a dJ(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.ch(com.baidu.tbadk.album.a.aFN);
        aVar.setName(this.hCT.getPageContext().getString(d.j.album_all_media));
        int D = v.D(list);
        aVar.v(list);
        aVar.ci(String.valueOf(D));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.f(list, D - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a dK(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.ch(com.baidu.tbadk.album.a.aFO);
        aVar.setName(this.hCT.getPageContext().getString(d.j.album_all_video));
        int D = v.D(list);
        aVar.ci(String.valueOf(D));
        ArrayList arrayList = new ArrayList();
        if (!v.E(list)) {
            arrayList.addAll(list);
        }
        aVar.v(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) v.f(list, D - 1);
        if (videoFileInfo != null) {
            aVar.a(videoFileInfo);
        }
        return aVar;
    }
}
