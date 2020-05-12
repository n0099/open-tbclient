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
/* loaded from: classes2.dex */
public class c {
    private List<ImageFileInfo> aWC;
    private String aWt;
    private final AlbumActivity lye;
    private VideoFileInfo lyl;
    private ImageFileInfo lym;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 9;
    private final List<com.baidu.tbadk.album.a> aWD = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.lye = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.lyl = videoFileInfo;
    }

    public VideoFileInfo dfs() {
        return this.lyl;
    }

    public boolean FH() {
        return !v.isEmpty(FK());
    }

    public boolean FI() {
        return this.lyl != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.lyl == null || videoFileInfo == null || this.lyl.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void h(ImageFileInfo imageFileInfo) {
        this.lym = imageFileInfo;
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

    public void FJ() {
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

    public List<ImageFileInfo> FK() {
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

    public String FM() {
        return this.aWt;
    }

    public void eS(String str) {
        this.aWt = str;
        eT(str);
    }

    private void eT(String str) {
        if (this.aWD != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.aWD) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.aWC = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> FN() {
        return this.aWC;
    }

    public List<com.baidu.tbadk.album.a> FO() {
        return this.aWD;
    }

    public List<MediaFileInfo> eU(String str) {
        if (this.aWD == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.aWD) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.getFileList();
            }
        }
        return null;
    }

    public boolean FP() {
        return v.isEmpty(eU(com.baidu.tbadk.album.a.ALBUM_ID_ALL));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.allList;
            ArrayList arrayList = new ArrayList();
            arrayList.add(eK(list));
            if (!v.isEmpty(gVar.videoFileList)) {
                arrayList.add(eL(gVar.videoFileList));
            }
            if (!v.isEmpty(gVar.albumList)) {
                arrayList.addAll(gVar.albumList);
            }
            this.aWD.clear();
            this.aWD.addAll(arrayList);
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
        if (this.lym == null || TextUtils.isEmpty(this.lym.getFilePath())) {
            return 0;
        }
        if (this.aWC == null || this.aWC.size() == 0) {
            return 0;
        }
        int size = this.aWC.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.aWC.get(i);
            if (imageFileInfo != null && this.lym.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a eK(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.setAlbumId(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        aVar.setName(this.lye.getPageContext().getString(R.string.album_all_media));
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

    public com.baidu.tbadk.album.a eL(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.setAlbumId(com.baidu.tbadk.album.a.ALBUM_ID_VIDEO);
        aVar.setName(this.lye.getPageContext().getString(R.string.album_all_video));
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
