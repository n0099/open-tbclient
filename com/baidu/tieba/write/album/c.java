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
    private String apU;
    private List<ImageFileInfo> aqd;
    private final AlbumActivity jOC;
    private VideoFileInfo jOJ;
    private ImageFileInfo jOK;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 9;
    private final List<com.baidu.tbadk.album.a> aqe = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.jOC = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.jOJ = videoFileInfo;
    }

    public VideoFileInfo cyh() {
        return this.jOJ;
    }

    public boolean vV() {
        return !v.isEmpty(vY());
    }

    public boolean vW() {
        return this.jOJ != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.jOJ == null || videoFileInfo == null || this.jOJ.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void h(ImageFileInfo imageFileInfo) {
        this.jOK = imageFileInfo;
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

    public void vX() {
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

    public List<ImageFileInfo> vY() {
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

    public String wa() {
        return this.apU;
    }

    public void cQ(String str) {
        this.apU = str;
        cR(str);
    }

    private void cR(String str) {
        if (this.aqe != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.aqe) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.aqd = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> wb() {
        return this.aqd;
    }

    public List<com.baidu.tbadk.album.a> wc() {
        return this.aqe;
    }

    public List<MediaFileInfo> cS(String str) {
        if (this.aqe == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.aqe) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.getFileList();
            }
        }
        return null;
    }

    public boolean wd() {
        return v.isEmpty(cS(com.baidu.tbadk.album.a.ALBUM_ID_ALL));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.allList;
            ArrayList arrayList = new ArrayList();
            arrayList.add(eI(list));
            if (!v.isEmpty(gVar.videoFileList)) {
                arrayList.add(eJ(gVar.videoFileList));
            }
            if (!v.isEmpty(gVar.albumList)) {
                arrayList.addAll(gVar.albumList);
            }
            this.aqe.clear();
            this.aqe.addAll(arrayList);
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
        if (this.jOK == null || TextUtils.isEmpty(this.jOK.getFilePath())) {
            return 0;
        }
        if (this.aqd == null || this.aqd.size() == 0) {
            return 0;
        }
        int size = this.aqd.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.aqd.get(i);
            if (imageFileInfo != null && this.jOK.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a eI(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.setAlbumId(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        aVar.setName(this.jOC.getPageContext().getString(R.string.album_all_media));
        int count = v.getCount(list);
        aVar.setFileList(list);
        aVar.setCount(String.valueOf(count));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) v.getItem(list, count - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a eJ(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.setAlbumId(com.baidu.tbadk.album.a.ALBUM_ID_VIDEO);
        aVar.setName(this.jOC.getPageContext().getString(R.string.album_all_video));
        int count = v.getCount(list);
        aVar.setCount(String.valueOf(count));
        ArrayList arrayList = new ArrayList();
        if (!v.isEmpty(list)) {
            arrayList.addAll(list);
        }
        aVar.setFileList(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) v.getItem(list, count - 1);
        if (videoFileInfo != null) {
            aVar.a(videoFileInfo);
        }
        return aVar;
    }
}
