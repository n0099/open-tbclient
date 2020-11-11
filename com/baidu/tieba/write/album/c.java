package com.baidu.tieba.write.album;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.album.MediaFileInfo;
import com.baidu.tbadk.album.VideoFileInfo;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private List<ImageFileInfo> bED;
    private String bEu;
    private final com.baidu.adp.base.e mContext;
    private WriteImagesInfo mWriteImagesInfo;
    private VideoFileInfo nFr;
    private ImageFileInfo nFs;
    private int maxImagesAllowed = 9;
    private final List<com.baidu.tbadk.album.a> bEE = new ArrayList();

    public c(com.baidu.adp.base.e eVar) {
        this.mContext = eVar;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.nFr = videoFileInfo;
    }

    public VideoFileInfo dTt() {
        return this.nFr;
    }

    public boolean TV() {
        return !y.isEmpty(TY());
    }

    public boolean TW() {
        return this.nFr != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.nFr == null || videoFileInfo == null || this.nFr.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.nFs = imageFileInfo;
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

    public void TX() {
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

    public List<ImageFileInfo> TY() {
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

    public String Ua() {
        return this.bEu;
    }

    public void iv(String str) {
        this.bEu = str;
        iw(str);
    }

    private void iw(String str) {
        if (this.bEE != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.bEE) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.bED = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> Ub() {
        return this.bED;
    }

    public List<com.baidu.tbadk.album.a> Uc() {
        return this.bEE;
    }

    public List<MediaFileInfo> ix(String str) {
        if (this.bEE == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.bEE) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.getFileList();
            }
        }
        return null;
    }

    public boolean bBW() {
        return y.isEmpty(ix(com.baidu.tbadk.album.a.ALBUM_ID_ALL));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.allList;
            ArrayList arrayList = new ArrayList();
            arrayList.add(fZ(list));
            if (!y.isEmpty(gVar.videoFileList)) {
                arrayList.add(ga(gVar.videoFileList));
            }
            if (!y.isEmpty(gVar.albumList)) {
                arrayList.addAll(gVar.albumList);
            }
            this.bEE.clear();
            this.bEE.addAll(arrayList);
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
        if (this.nFs == null || TextUtils.isEmpty(this.nFs.getFilePath())) {
            return 0;
        }
        if (this.bED == null || this.bED.size() == 0) {
            return 0;
        }
        int size = this.bED.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.bED.get(i);
            if (imageFileInfo != null && this.nFs.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a fZ(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.setAlbumId(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        aVar.setName(this.mContext.getString(R.string.album_all_media));
        int count = y.getCount(list);
        aVar.setFileList(list);
        aVar.setCount(String.valueOf(count));
        MediaFileInfo mediaFileInfo = (MediaFileInfo) y.getItem(list, count - 1);
        if (mediaFileInfo instanceof ImageFileInfo) {
            aVar.a((ImageFileInfo) mediaFileInfo);
        } else if (mediaFileInfo instanceof VideoFileInfo) {
            aVar.a((VideoFileInfo) mediaFileInfo);
        }
        return aVar;
    }

    public com.baidu.tbadk.album.a ga(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.setAlbumId(com.baidu.tbadk.album.a.ALBUM_ID_VIDEO);
        aVar.setName(this.mContext.getString(R.string.album_all_video));
        int count = y.getCount(list);
        aVar.setCount(String.valueOf(count));
        ArrayList arrayList = new ArrayList();
        if (!y.isEmpty(list)) {
            arrayList.addAll(list);
        }
        aVar.setFileList(arrayList);
        VideoFileInfo videoFileInfo = (VideoFileInfo) y.getItem(list, count - 1);
        if (videoFileInfo != null) {
            aVar.a(videoFileInfo);
        }
        return aVar;
    }
}
