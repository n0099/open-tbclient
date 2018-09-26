package com.baidu.tieba.write.album;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private String dgA;
    private final AlbumActivity hBK;
    private VideoFileInfo hBX;
    private ImageFileInfo hBY;
    private List<ImageFileInfo> hBZ;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 10;
    private final List<com.baidu.tbadk.album.a> hCa = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.hBK = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.hBX = videoFileInfo;
    }

    public VideoFileInfo bIN() {
        return this.hBX;
    }

    public boolean bIO() {
        return !v.z(bIR());
    }

    public boolean bIP() {
        return this.hBX != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.hBX == null || videoFileInfo == null || this.hBX.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.hBY = imageFileInfo;
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

    public void bIQ() {
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

    public List<ImageFileInfo> bIR() {
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

    public String bIS() {
        return this.dgA;
    }

    public void wn(String str) {
        this.dgA = str;
        wo(str);
    }

    private void wo(String str) {
        if (this.hCa != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.hCa) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.sF() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.sF()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.hBZ = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> bIT() {
        return this.hBZ;
    }

    public List<com.baidu.tbadk.album.a> bIU() {
        return this.hCa;
    }

    public List<MediaFileInfo> wp(String str) {
        if (this.hCa == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.hCa) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.sF();
            }
        }
        return null;
    }

    public boolean Lz() {
        return v.z(wp(com.baidu.tbadk.album.a.acz));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.acY;
            ArrayList arrayList = new ArrayList();
            arrayList.add(dP(list));
            if (!v.z(gVar.acZ)) {
                arrayList.add(dQ(gVar.acZ));
            }
            if (!v.z(gVar.acX)) {
                arrayList.addAll(gVar.acX);
            }
            this.hCa.clear();
            this.hCa.addAll(arrayList);
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
        if (this.hBY == null || TextUtils.isEmpty(this.hBY.getFilePath())) {
            return 0;
        }
        if (this.hBZ == null || this.hBZ.size() == 0) {
            return 0;
        }
        int size = this.hBZ.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.hBZ.get(i);
            if (imageFileInfo != null && this.hBY.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a dP(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.cW(com.baidu.tbadk.album.a.acz);
        aVar.setName(this.hBK.getPageContext().getString(e.j.album_all_media));
        int y = v.y(list);
        aVar.o(list);
        aVar.cX(String.valueOf(y));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.d(list, y - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a dQ(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.cW(com.baidu.tbadk.album.a.acA);
        aVar.setName(this.hBK.getPageContext().getString(e.j.album_all_video));
        int y = v.y(list);
        aVar.cX(String.valueOf(y));
        ArrayList arrayList = new ArrayList();
        if (!v.z(list)) {
            arrayList.addAll(list);
        }
        aVar.o(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) v.d(list, y - 1);
        if (videoFileInfo != null) {
            aVar.a(videoFileInfo);
        }
        return aVar;
    }
}
