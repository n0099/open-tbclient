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
/* loaded from: classes3.dex */
public class c {
    private String bjq;
    private List<ImageFileInfo> bjz;
    private final com.baidu.adp.base.e mContext;
    private WriteImagesInfo mWriteImagesInfo;
    private VideoFileInfo muT;
    private ImageFileInfo muU;
    private int maxImagesAllowed = 9;
    private final List<com.baidu.tbadk.album.a> bjA = new ArrayList();

    public c(com.baidu.adp.base.e eVar) {
        this.mContext = eVar;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.muT = videoFileInfo;
    }

    public VideoFileInfo duz() {
        return this.muT;
    }

    public boolean IR() {
        return !x.isEmpty(IU());
    }

    public boolean IS() {
        return this.muT != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.muT == null || videoFileInfo == null || this.muT.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void d(ImageFileInfo imageFileInfo) {
        this.muU = imageFileInfo;
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

    public void IT() {
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

    public List<ImageFileInfo> IU() {
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

    public String IW() {
        return this.bjq;
    }

    public void fK(String str) {
        this.bjq = str;
        fL(str);
    }

    private void fL(String str) {
        if (this.bjA != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.bjA) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.bjz = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> IX() {
        return this.bjz;
    }

    public List<com.baidu.tbadk.album.a> IY() {
        return this.bjA;
    }

    public List<MediaFileInfo> fM(String str) {
        if (this.bjA == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.bjA) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.getFileList();
            }
        }
        return null;
    }

    public boolean IZ() {
        return x.isEmpty(fM(com.baidu.tbadk.album.a.ALBUM_ID_ALL));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.allList;
            ArrayList arrayList = new ArrayList();
            arrayList.add(fp(list));
            if (!x.isEmpty(gVar.videoFileList)) {
                arrayList.add(fq(gVar.videoFileList));
            }
            if (!x.isEmpty(gVar.albumList)) {
                arrayList.addAll(gVar.albumList);
            }
            this.bjA.clear();
            this.bjA.addAll(arrayList);
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
        if (this.muU == null || TextUtils.isEmpty(this.muU.getFilePath())) {
            return 0;
        }
        if (this.bjz == null || this.bjz.size() == 0) {
            return 0;
        }
        int size = this.bjz.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.bjz.get(i);
            if (imageFileInfo != null && this.muU.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a fp(List<MediaFileInfo> list) {
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

    public com.baidu.tbadk.album.a fq(List<VideoFileInfo> list) {
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
