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
    private String dpo;
    private List<ImageFileInfo> hNA;
    private final AlbumActivity hNl;
    private VideoFileInfo hNy;
    private ImageFileInfo hNz;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 10;
    private final List<com.baidu.tbadk.album.a> hNB = new ArrayList();

    public e(AlbumActivity albumActivity) {
        this.hNl = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.hNy = videoFileInfo;
    }

    public VideoFileInfo bLW() {
        return this.hNy;
    }

    public boolean bLX() {
        return !v.G(bMa());
    }

    public boolean bLY() {
        return this.hNy != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.hNy == null || videoFileInfo == null || this.hNy.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.hNz = imageFileInfo;
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

    public void bLZ() {
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

    public List<ImageFileInfo> bMa() {
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

    public String bMb() {
        return this.dpo;
    }

    public void uH(String str) {
        this.dpo = str;
        uI(str);
    }

    private void uI(String str) {
        if (this.hNB != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.hNB) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.vc() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.vc()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.hNA = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> bMc() {
        return this.hNA;
    }

    public List<com.baidu.tbadk.album.a> bMd() {
        return this.hNB;
    }

    public List<MediaFileInfo> uJ(String str) {
        if (this.hNB == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.hNB) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.vc();
            }
        }
        return null;
    }

    public boolean No() {
        return v.G(uJ(com.baidu.tbadk.album.a.aFO));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.aGn;
            ArrayList arrayList = new ArrayList();
            arrayList.add(ea(list));
            if (!v.G(gVar.aGo)) {
                arrayList.add(eb(gVar.aGo));
            }
            if (!v.G(gVar.aGm)) {
                arrayList.addAll(gVar.aGm);
            }
            this.hNB.clear();
            this.hNB.addAll(arrayList);
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
        if (this.hNz == null || TextUtils.isEmpty(this.hNz.getFilePath())) {
            return 0;
        }
        if (this.hNA == null || this.hNA.size() == 0) {
            return 0;
        }
        int size = this.hNA.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.hNA.get(i);
            if (imageFileInfo != null && this.hNz.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a ea(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.ch(com.baidu.tbadk.album.a.aFO);
        aVar.setName(this.hNl.getPageContext().getString(d.j.album_all_media));
        int F = v.F(list);
        aVar.v(list);
        aVar.ci(String.valueOf(F));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.f(list, F - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a eb(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.ch(com.baidu.tbadk.album.a.aFP);
        aVar.setName(this.hNl.getPageContext().getString(d.j.album_all_video));
        int F = v.F(list);
        aVar.ci(String.valueOf(F));
        ArrayList arrayList = new ArrayList();
        if (!v.G(list)) {
            arrayList.addAll(list);
        }
        aVar.v(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) v.f(list, F - 1);
        if (videoFileInfo != null) {
            aVar.a(videoFileInfo);
        }
        return aVar;
    }
}
