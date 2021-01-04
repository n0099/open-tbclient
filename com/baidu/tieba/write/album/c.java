package com.baidu.tieba.write.album;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class c {
    private String bMF;
    private List<ImageFileInfo> bMO;
    private final com.baidu.adp.base.f mContext;
    private WriteImagesInfo mWriteImagesInfo;
    private VideoFileInfo nYv;
    private ImageFileInfo nYw;
    private int maxImagesAllowed = 9;
    private final List<com.baidu.tbadk.album.a> bMP = new ArrayList();

    public c(com.baidu.adp.base.f fVar) {
        this.mContext = fVar;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.nYv = videoFileInfo;
    }

    public VideoFileInfo dYq() {
        return this.nYv;
    }

    public boolean WO() {
        return !x.isEmpty(WR());
    }

    public boolean WP() {
        return this.nYv != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.nYv == null || videoFileInfo == null || this.nYv.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.nYw = imageFileInfo;
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

    public void WQ() {
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

    public List<ImageFileInfo> WR() {
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

    public String WT() {
        return this.bMF;
    }

    public void iI(String str) {
        this.bMF = str;
        iJ(str);
    }

    private void iJ(String str) {
        if (this.bMP != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.bMP) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.bMO = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> WU() {
        return this.bMO;
    }

    public List<com.baidu.tbadk.album.a> WV() {
        return this.bMP;
    }

    public List<MediaFileInfo> iK(String str) {
        if (this.bMP == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.bMP) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.getFileList();
            }
        }
        return null;
    }

    public boolean isDataEmpty() {
        return x.isEmpty(iK(com.baidu.tbadk.album.a.ALBUM_ID_ALL));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.allList;
            ArrayList arrayList = new ArrayList();
            arrayList.add(gh(list));
            if (!x.isEmpty(gVar.videoFileList)) {
                arrayList.add(gi(gVar.videoFileList));
            }
            if (!x.isEmpty(gVar.albumList)) {
                arrayList.addAll(gVar.albumList);
            }
            this.bMP.clear();
            this.bMP.addAll(arrayList);
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
        if (this.nYw == null || TextUtils.isEmpty(this.nYw.getFilePath())) {
            return 0;
        }
        if (this.bMO == null || this.bMO.size() == 0) {
            return 0;
        }
        int size = this.bMO.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.bMO.get(i);
            if (imageFileInfo != null && this.nYw.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a gh(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.setAlbumId(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        aVar.setName(this.mContext.getString(R.string.album_all_media));
        int count = x.getCount(list);
        aVar.setFileList(list);
        aVar.setCount(String.valueOf(count));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) x.getItem(list, count - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a gi(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.setAlbumId(com.baidu.tbadk.album.a.ALBUM_ID_VIDEO);
        aVar.setName(this.mContext.getString(R.string.album_all_video));
        int count = x.getCount(list);
        aVar.setCount(String.valueOf(count));
        ArrayList arrayList = new ArrayList();
        if (!x.isEmpty(list)) {
            arrayList.addAll(list);
        }
        aVar.setFileList(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) x.getItem(list, count - 1);
        if (videoFileInfo != null) {
            aVar.a(videoFileInfo);
        }
        return aVar;
    }
}
