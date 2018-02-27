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
    private String dwP;
    private VideoFileInfo hEK;
    private ImageFileInfo hEL;
    private List<ImageFileInfo> hEM;
    private final AlbumActivity hEx;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 10;
    private final List<com.baidu.tbadk.album.a> hEN = new ArrayList();

    public e(AlbumActivity albumActivity) {
        this.hEx = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.hEK = videoFileInfo;
    }

    public VideoFileInfo bGl() {
        return this.hEK;
    }

    public boolean bGm() {
        return !v.E(bGp());
    }

    public boolean bGn() {
        return this.hEK != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.hEK == null || videoFileInfo == null || this.hEK.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void f(ImageFileInfo imageFileInfo) {
        this.hEL = imageFileInfo;
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

    public void bGo() {
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

    public List<ImageFileInfo> bGp() {
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

    public String bGq() {
        return this.dwP;
    }

    public void uq(String str) {
        this.dwP = str;
        ur(str);
    }

    private void ur(String str) {
        if (this.hEN != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.hEN) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.vP() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.vP()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.hEM = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> bGr() {
        return this.hEM;
    }

    public List<com.baidu.tbadk.album.a> bGs() {
        return this.hEN;
    }

    public List<MediaFileInfo> us(String str) {
        if (this.hEN == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.hEN) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.vP();
            }
        }
        return null;
    }

    public boolean NJ() {
        return v.E(us(com.baidu.tbadk.album.a.aGY));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.aHx;
            ArrayList arrayList = new ArrayList();
            arrayList.add(dP(list));
            if (!v.E(gVar.aHy)) {
                arrayList.add(dQ(gVar.aHy));
            }
            if (!v.E(gVar.aHw)) {
                arrayList.addAll(gVar.aHw);
            }
            this.hEN.clear();
            this.hEN.addAll(arrayList);
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
        if (this.hEL == null || TextUtils.isEmpty(this.hEL.getFilePath())) {
            return 0;
        }
        if (this.hEM == null || this.hEM.size() == 0) {
            return 0;
        }
        int size = this.hEM.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.hEM.get(i);
            if (imageFileInfo != null && this.hEL.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a dP(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.co(com.baidu.tbadk.album.a.aGY);
        aVar.setName(this.hEx.getPageContext().getString(d.j.album_all_media));
        int D = v.D(list);
        aVar.v(list);
        aVar.cp(String.valueOf(D));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.f(list, D - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a dQ(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.co(com.baidu.tbadk.album.a.aGZ);
        aVar.setName(this.hEx.getPageContext().getString(d.j.album_all_video));
        int D = v.D(list);
        aVar.cp(String.valueOf(D));
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
