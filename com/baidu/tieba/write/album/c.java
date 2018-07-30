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
    private String daJ;
    private final AlbumActivity htN;
    private VideoFileInfo hua;
    private ImageFileInfo hub;
    private List<ImageFileInfo> huc;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 10;
    private final List<com.baidu.tbadk.album.a> hud = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.htN = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.hua = videoFileInfo;
    }

    public VideoFileInfo bFT() {
        return this.hua;
    }

    public boolean bFU() {
        return !w.z(bFX());
    }

    public boolean bFV() {
        return this.hua != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.hua == null || videoFileInfo == null || this.hua.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.hub = imageFileInfo;
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

    public void bFW() {
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

    public List<ImageFileInfo> bFX() {
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

    public String bFY() {
        return this.daJ;
    }

    public void vA(String str) {
        this.daJ = str;
        vB(str);
    }

    private void vB(String str) {
        if (this.hud != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.hud) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.rB() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.rB()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.huc = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> bFZ() {
        return this.huc;
    }

    public List<com.baidu.tbadk.album.a> bGa() {
        return this.hud;
    }

    public List<MediaFileInfo> vC(String str) {
        if (this.hud == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.hud) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.rB();
            }
        }
        return null;
    }

    public boolean Kf() {
        return w.z(vC(com.baidu.tbadk.album.a.ZW));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.aav;
            ArrayList arrayList = new ArrayList();
            arrayList.add(dO(list));
            if (!w.z(gVar.aaw)) {
                arrayList.add(dP(gVar.aaw));
            }
            if (!w.z(gVar.aau)) {
                arrayList.addAll(gVar.aau);
            }
            this.hud.clear();
            this.hud.addAll(arrayList);
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
        if (this.hub == null || TextUtils.isEmpty(this.hub.getFilePath())) {
            return 0;
        }
        if (this.huc == null || this.huc.size() == 0) {
            return 0;
        }
        int size = this.huc.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.huc.get(i);
            if (imageFileInfo != null && this.hub.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a dO(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.cF(com.baidu.tbadk.album.a.ZW);
        aVar.setName(this.htN.getPageContext().getString(d.j.album_all_media));
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
        aVar.cF(com.baidu.tbadk.album.a.ZX);
        aVar.setName(this.htN.getPageContext().getString(d.j.album_all_video));
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
