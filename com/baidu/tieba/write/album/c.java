package com.baidu.tieba.write.album;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private String daF;
    private final AlbumActivity htP;
    private VideoFileInfo huc;
    private ImageFileInfo hud;
    private List<ImageFileInfo> hue;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 10;
    private final List<com.baidu.tbadk.album.a> huf = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.htP = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.huc = videoFileInfo;
    }

    public VideoFileInfo bFX() {
        return this.huc;
    }

    public boolean bFY() {
        return !w.z(bGb());
    }

    public boolean bFZ() {
        return this.huc != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.huc == null || videoFileInfo == null || this.huc.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.hud = imageFileInfo;
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

    public void bGa() {
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

    public List<ImageFileInfo> bGb() {
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

    public String bGc() {
        return this.daF;
    }

    public void vE(String str) {
        this.daF = str;
        vF(str);
    }

    private void vF(String str) {
        if (this.huf != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.huf) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.rz() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.rz()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.hue = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> bGd() {
        return this.hue;
    }

    public List<com.baidu.tbadk.album.a> bGe() {
        return this.huf;
    }

    public List<MediaFileInfo> vG(String str) {
        if (this.huf == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.huf) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.rz();
            }
        }
        return null;
    }

    public boolean Kj() {
        return w.z(vG(com.baidu.tbadk.album.a.ZX));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.aaw;
            ArrayList arrayList = new ArrayList();
            arrayList.add(dO(list));
            if (!w.z(gVar.aax)) {
                arrayList.add(dP(gVar.aax));
            }
            if (!w.z(gVar.aav)) {
                arrayList.addAll(gVar.aav);
            }
            this.huf.clear();
            this.huf.addAll(arrayList);
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
        if (this.hud == null || TextUtils.isEmpty(this.hud.getFilePath())) {
            return 0;
        }
        if (this.hue == null || this.hue.size() == 0) {
            return 0;
        }
        int size = this.hue.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.hue.get(i);
            if (imageFileInfo != null && this.hud.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a dO(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.cF(com.baidu.tbadk.album.a.ZX);
        aVar.setName(this.htP.getPageContext().getString(f.j.album_all_media));
        int y = w.y(list);
        aVar.o(list);
        aVar.cG(String.valueOf(y));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) w.d(list, y - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a dP(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.cF(com.baidu.tbadk.album.a.ZY);
        aVar.setName(this.htP.getPageContext().getString(f.j.album_all_video));
        int y = w.y(list);
        aVar.cG(String.valueOf(y));
        ArrayList arrayList = new ArrayList();
        if (!w.z(list)) {
            arrayList.addAll(list);
        }
        aVar.o(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) w.d(list, y - 1);
        if (videoFileInfo != null) {
            aVar.a(videoFileInfo);
        }
        return aVar;
    }
}
