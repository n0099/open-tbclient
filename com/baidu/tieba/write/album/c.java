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
/* loaded from: classes3.dex */
public class c {
    private String eMX;
    private final AlbumActivity jmX;
    private VideoFileInfo jnk;
    private ImageFileInfo jnl;
    private List<ImageFileInfo> jnm;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 9;
    private final List<com.baidu.tbadk.album.a> jnn = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.jmX = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.jnk = videoFileInfo;
    }

    public VideoFileInfo coW() {
        return this.jnk;
    }

    public boolean coX() {
        return !v.T(cpa());
    }

    public boolean coY() {
        return this.jnk != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.jnk == null || videoFileInfo == null || this.jnk.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void g(ImageFileInfo imageFileInfo) {
        this.jnl = imageFileInfo;
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

    public void coZ() {
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

    public List<ImageFileInfo> cpa() {
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

    public String cpb() {
        return this.eMX;
    }

    public void Eo(String str) {
        this.eMX = str;
        Ep(str);
    }

    private void Ep(String str) {
        if (this.jnn != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.jnn) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.UP() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.UP()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.jnm = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> cpc() {
        return this.jnm;
    }

    public List<com.baidu.tbadk.album.a> cpd() {
        return this.jnn;
    }

    public List<MediaFileInfo> Eq(String str) {
        if (this.jnn == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.jnn) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.UP();
            }
        }
        return null;
    }

    public boolean aoI() {
        return v.T(Eq(com.baidu.tbadk.album.a.bsO));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.bto;
            ArrayList arrayList = new ArrayList();
            arrayList.add(em(list));
            if (!v.T(gVar.btp)) {
                arrayList.add(en(gVar.btp));
            }
            if (!v.T(gVar.btm)) {
                arrayList.addAll(gVar.btm);
            }
            this.jnn.clear();
            this.jnn.addAll(arrayList);
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
        if (this.jnl == null || TextUtils.isEmpty(this.jnl.getFilePath())) {
            return 0;
        }
        if (this.jnm == null || this.jnm.size() == 0) {
            return 0;
        }
        int size = this.jnm.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.jnm.get(i);
            if (imageFileInfo != null && this.jnl.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a em(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.km(com.baidu.tbadk.album.a.bsO);
        aVar.setName(this.jmX.getPageContext().getString(d.j.album_all_media));
        int S = v.S(list);
        aVar.H(list);
        aVar.kn(String.valueOf(S));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.c(list, S - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a en(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.km(com.baidu.tbadk.album.a.bsP);
        aVar.setName(this.jmX.getPageContext().getString(d.j.album_all_video));
        int S = v.S(list);
        aVar.kn(String.valueOf(S));
        ArrayList arrayList = new ArrayList();
        if (!v.T(list)) {
            arrayList.addAll(list);
        }
        aVar.H(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) v.c(list, S - 1);
        if (videoFileInfo != null) {
            aVar.a(videoFileInfo);
        }
        return aVar;
    }
}
