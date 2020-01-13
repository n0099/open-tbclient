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
/* loaded from: classes11.dex */
public class c {
    private String ayb;
    private List<ImageFileInfo> ayk;
    private final AlbumActivity kMa;
    private VideoFileInfo kMh;
    private ImageFileInfo kMi;
    private WriteImagesInfo mWriteImagesInfo;
    private int maxImagesAllowed = 9;
    private final List<com.baidu.tbadk.album.a> ayl = new ArrayList();

    public c(AlbumActivity albumActivity) {
        this.kMa = albumActivity;
    }

    public void a(VideoFileInfo videoFileInfo) {
        this.kMh = videoFileInfo;
    }

    public VideoFileInfo cTk() {
        return this.kMh;
    }

    public boolean yk() {
        return !v.isEmpty(yn());
    }

    public boolean yl() {
        return this.kMh != null;
    }

    public boolean b(VideoFileInfo videoFileInfo) {
        return (this.kMh == null || videoFileInfo == null || this.kMh.videoId != videoFileInfo.videoId) ? false : true;
    }

    public void h(ImageFileInfo imageFileInfo) {
        this.kMi = imageFileInfo;
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

    public void ym() {
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

    public List<ImageFileInfo> yn() {
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

    public String yp() {
        return this.ayb;
    }

    public void dL(String str) {
        this.ayb = str;
        dM(str);
    }

    private void dM(String str) {
        if (this.ayl != null && !StringUtils.isNull(str)) {
            for (com.baidu.tbadk.album.a aVar : this.ayl) {
                if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                    ArrayList arrayList = new ArrayList();
                    if (aVar.getFileList() != null) {
                        for (MediaFileInfo mediaFileInfo : aVar.getFileList()) {
                            if (mediaFileInfo instanceof ImageFileInfo) {
                                arrayList.add((ImageFileInfo) mediaFileInfo);
                            }
                        }
                    }
                    this.ayk = arrayList;
                }
            }
        }
    }

    public List<ImageFileInfo> yq() {
        return this.ayk;
    }

    public List<com.baidu.tbadk.album.a> yr() {
        return this.ayl;
    }

    public List<MediaFileInfo> dN(String str) {
        if (this.ayl == null || StringUtils.isNull(str)) {
            return null;
        }
        for (com.baidu.tbadk.album.a aVar : this.ayl) {
            if (aVar != null && TextUtils.equals(str, aVar.getAlbumId())) {
                return aVar.getFileList();
            }
        }
        return null;
    }

    public boolean ys() {
        return v.isEmpty(dN(com.baidu.tbadk.album.a.ALBUM_ID_ALL));
    }

    public void c(com.baidu.tbadk.album.g gVar) {
        if (gVar != null) {
            List<MediaFileInfo> list = gVar.allList;
            ArrayList arrayList = new ArrayList();
            arrayList.add(eA(list));
            if (!v.isEmpty(gVar.videoFileList)) {
                arrayList.add(eB(gVar.videoFileList));
            }
            if (!v.isEmpty(gVar.albumList)) {
                arrayList.addAll(gVar.albumList);
            }
            this.ayl.clear();
            this.ayl.addAll(arrayList);
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
        if (this.kMi == null || TextUtils.isEmpty(this.kMi.getFilePath())) {
            return 0;
        }
        if (this.ayk == null || this.ayk.size() == 0) {
            return 0;
        }
        int size = this.ayk.size();
        for (int i = 0; i < size; i++) {
            ImageFileInfo imageFileInfo = this.ayk.get(i);
            if (imageFileInfo != null && this.kMi.getFilePath().equals(imageFileInfo.getFilePath())) {
                return i;
            }
        }
        return 0;
    }

    public com.baidu.tbadk.album.a eA(List<MediaFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.setAlbumId(com.baidu.tbadk.album.a.ALBUM_ID_ALL);
        aVar.setName(this.kMa.getPageContext().getString(R.string.album_all_media));
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

    public com.baidu.tbadk.album.a eB(List<VideoFileInfo> list) {
        com.baidu.tbadk.album.a aVar = new com.baidu.tbadk.album.a();
        aVar.setAlbumId(com.baidu.tbadk.album.a.ALBUM_ID_VIDEO);
        aVar.setName(this.kMa.getPageContext().getString(R.string.album_all_video));
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
