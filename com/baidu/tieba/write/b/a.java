package com.baidu.tieba.write.b;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.MediaUtils;
import com.baidu.searchbox.ugc.utils.UgcUriUtils;
import com.baidu.searchbox.upload.provider.UploadProviderManager;
import com.baidu.searchbox.upload.provider.listener.UploadImageListener;
import com.baidu.searchbox.upload.provider.listener.UploadVideoListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tbadk.img.e;
import com.baidu.tieba.tbadkCore.c.a;
import com.baidu.tieba.write.b.c.a;
import com.baidu.tieba.write.b.c.b;
import com.baidu.tieba.write.upload.BaseUploadData;
import com.baidu.tieba.write.upload.VideoUploadData;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class a {
    private static com.baidu.tieba.write.b.c.a mwP;
    private static CopyOnWriteArrayList<String> mwQ = new CopyOnWriteArrayList<>();

    /* renamed from: com.baidu.tieba.write.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0775a {
        void a(BaseUploadData baseUploadData);

        void onError();
    }

    static {
        b.dvd().init();
    }

    public static void a(final WriteData writeData, final InterfaceC0775a interfaceC0775a) {
        if (writeData == null || writeData.mDynamicImageTextData == null) {
            if (interfaceC0775a != null) {
                interfaceC0775a.onError();
                return;
            }
            return;
        }
        writeData.mDynamicImageTextData.inputText = writeData.getContent();
        final WriteImagesInfo writeImagesInfo = writeData.getWriteImagesInfo();
        if (writeImagesInfo == null || writeImagesInfo.getChosedFiles() == null || writeImagesInfo.getChosedFiles().size() <= 0) {
            if (interfaceC0775a != null) {
                interfaceC0775a.a(writeData.mDynamicImageTextData);
                return;
            }
            return;
        }
        if (mwP == null) {
            mwP = new com.baidu.tieba.write.b.c.a();
        }
        final LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
        mwP.a(chosedFiles, writeImagesInfo.isOriginalImg(), new a.InterfaceC0776a() { // from class: com.baidu.tieba.write.b.a.1
            @Override // com.baidu.tieba.write.b.c.a.InterfaceC0776a
            public void cFF() {
                ArrayList arrayList = new ArrayList();
                Iterator it = chosedFiles.iterator();
                while (it.hasNext()) {
                    ImageFileInfo imageFileInfo = (ImageFileInfo) it.next();
                    if (TextUtils.isEmpty(imageFileInfo.getContentUriStr())) {
                        arrayList.add(imageFileInfo.getFilePath());
                    }
                }
                if (arrayList.size() <= 0) {
                    ArrayList<String> chosedUriStr = writeImagesInfo.getChosedUriStr();
                    if (chosedUriStr != null && chosedUriStr.size() > 0) {
                        writeData.mDynamicImageTextData.imagePaths = chosedUriStr;
                    }
                    if (interfaceC0775a != null) {
                        interfaceC0775a.a(writeData.mDynamicImageTextData);
                        return;
                    }
                    return;
                }
                String[] strArr = new String[arrayList.size()];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < arrayList.size()) {
                        strArr[i2] = (String) arrayList.get(i2);
                        i = i2 + 1;
                    } else {
                        n.a(strArr, new n.b() { // from class: com.baidu.tieba.write.b.a.1.1
                            @Override // com.baidu.tbadk.core.util.n.b
                            public void D(HashMap<String, String> hashMap) {
                                if (hashMap != null) {
                                    Iterator it2 = chosedFiles.iterator();
                                    while (it2.hasNext()) {
                                        ImageFileInfo imageFileInfo2 = (ImageFileInfo) it2.next();
                                        if (TextUtils.isEmpty(imageFileInfo2.getContentUriStr())) {
                                            imageFileInfo2.setContentUriStr(hashMap.get(imageFileInfo2.getFilePath()));
                                        }
                                    }
                                    ArrayList<String> chosedUriStr2 = writeImagesInfo.getChosedUriStr();
                                    if (chosedUriStr2 != null && chosedUriStr2.size() > 0) {
                                        writeData.mDynamicImageTextData.imagePaths = chosedUriStr2;
                                    }
                                }
                                if (interfaceC0775a != null) {
                                    interfaceC0775a.a(writeData.mDynamicImageTextData);
                                }
                            }
                        });
                        return;
                    }
                }
            }
        });
    }

    public static void a(final WriteData writeData, final InterfaceC0775a interfaceC0775a, final a.InterfaceC0754a interfaceC0754a) {
        if (writeData == null || writeData.mDynamicVideoData == null || writeData.getVideoInfo() == null) {
            if (interfaceC0775a != null) {
                interfaceC0775a.onError();
                return;
            }
            return;
        }
        writeData.mDynamicVideoData.inputText = writeData.getTitle();
        final VideoInfo videoInfo = writeData.getVideoInfo();
        String thumbUriStr = videoInfo.getThumbUriStr();
        String videoUriStr = videoInfo.getVideoUriStr();
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(videoInfo.getThumbPath()) || TextUtils.isEmpty(videoInfo.getVideoPath())) {
            if (interfaceC0775a != null) {
                interfaceC0775a.onError();
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(thumbUriStr)) {
            arrayList.add(videoInfo.getThumbPath());
        }
        if (TextUtils.isEmpty(videoUriStr)) {
            arrayList.add(videoInfo.getVideoPath());
        }
        if (arrayList.size() > 0) {
            String[] strArr = new String[arrayList.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    strArr[i2] = (String) arrayList.get(i2);
                    i = i2 + 1;
                } else {
                    n.a(strArr, new n.b() { // from class: com.baidu.tieba.write.b.a.2
                        @Override // com.baidu.tbadk.core.util.n.b
                        public void D(HashMap<String, String> hashMap) {
                            if (hashMap != null) {
                                VideoInfo.this.setThumbUriStr(hashMap.get(VideoInfo.this.getThumbPath()));
                                VideoInfo.this.setVideoUriStr(hashMap.get(VideoInfo.this.getVideoPath()));
                            }
                            if (!TextUtils.isEmpty(VideoInfo.this.getThumbUriStr()) && !TextUtils.isEmpty(VideoInfo.this.getVideoUriStr())) {
                                a.b(writeData, interfaceC0775a, interfaceC0754a);
                            } else if (interfaceC0775a != null) {
                                interfaceC0775a.onError();
                            }
                        }
                    });
                    return;
                }
            }
        } else {
            b(writeData, interfaceC0775a, interfaceC0754a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final WriteData writeData, final InterfaceC0775a interfaceC0775a, final a.InterfaceC0754a interfaceC0754a) {
        UploadProviderManager.getUploadProvider().upLoadImage(writeData.getVideoInfo().getThumbUriStr(), new UploadImageListener() { // from class: com.baidu.tieba.write.b.a.3
            @Override // com.baidu.searchbox.upload.provider.listener.UploadImageListener
            public void uploadSuccess(String str, int i, int i2, long j) {
                WriteData.this.mDynamicVideoData.videos = new VideoUploadData.VideoInfo();
                WriteData.this.mDynamicVideoData.videos.coverUrl = str;
                WriteData.this.mDynamicVideoData.videos.videoFirstFrame = str;
                a.c(WriteData.this, interfaceC0775a, interfaceC0754a);
            }

            @Override // com.baidu.searchbox.upload.provider.listener.UploadImageListener
            public void uploadFail() {
                if (interfaceC0775a != null) {
                    interfaceC0775a.onError();
                }
            }

            @Override // com.baidu.searchbox.upload.provider.listener.UploadImageListener
            public void uploadProgress(float f) {
                if (interfaceC0754a != null) {
                    interfaceC0754a.Fv((int) (100.0f * f * 0.1f));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final WriteData writeData, final InterfaceC0775a interfaceC0775a, final a.InterfaceC0754a interfaceC0754a) {
        if (interfaceC0754a != null) {
            interfaceC0754a.Fv(10);
        }
        UploadProviderManager.getUploadProvider().uploadVideo(writeData.getVideoInfo().getVideoUriStr(), new UploadVideoListener() { // from class: com.baidu.tieba.write.b.a.4
            @Override // com.baidu.searchbox.upload.provider.listener.UploadVideoListener
            public void uploadSuccess(String str, String str2, String str3) {
                WriteData.this.mDynamicVideoData.videos.mediaId = str;
                WriteData.this.mDynamicVideoData.videos.sourceKey = str2;
                a.a(str3, WriteData.this, interfaceC0775a);
            }

            @Override // com.baidu.searchbox.upload.provider.listener.UploadVideoListener
            public void uploadFail(String str) {
                if (interfaceC0775a != null) {
                    interfaceC0775a.onError();
                }
            }

            @Override // com.baidu.searchbox.upload.provider.listener.UploadVideoListener
            public void uploadProgress(int i) {
                if (interfaceC0754a != null) {
                    interfaceC0754a.Fv((int) (10.0f + (i * 0.9f)));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, WriteData writeData, InterfaceC0775a interfaceC0775a) {
        MediaMetadataRetriever mediaMetadataRetriever = getMediaMetadataRetriever(str);
        if (mediaMetadataRetriever == null) {
            if (interfaceC0775a != null) {
                interfaceC0775a.onError();
                return;
            }
            return;
        }
        int i = com.baidu.adp.lib.f.b.toInt(mediaMetadataRetriever.extractMetadata(9), 0);
        if (i > 0) {
            i /= 1000;
        } else if (writeData.getVideoInfo() != null) {
            i = writeData.getVideoInfo().getVideoDuration();
        }
        String extractMetadata = mediaMetadataRetriever.extractMetadata(19);
        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
        String valueOf = String.valueOf(MediaUtils.getMediaSize(str));
        writeData.mDynamicVideoData.videos.duration = String.valueOf(i);
        writeData.mDynamicVideoData.videos.width = extractMetadata2;
        writeData.mDynamicVideoData.videos.height = extractMetadata;
        writeData.mDynamicVideoData.videos.size = valueOf;
        if (interfaceC0775a != null) {
            interfaceC0775a.a(writeData.mDynamicVideoData);
        }
    }

    public static MediaMetadataRetriever getMediaMetadataRetriever(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uri = UgcUriUtils.getUri(str);
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(TbadkCoreApplication.getInst(), uri);
        return mediaMetadataRetriever;
    }

    public static void PH(String str) {
        mwQ.add(str);
    }

    public static void duU() {
        try {
            if (mwQ != null && mwQ.size() > 0) {
                mwQ.clear();
                n.deleteFileOrDir(new File(e.eEt));
                TbadkCoreApplication.getInst().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE"));
            }
        } catch (Exception e) {
        }
    }
}
