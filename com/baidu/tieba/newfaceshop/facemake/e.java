package com.baidu.tieba.newfaceshop.facemake;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.img.GetEmotionInfosModel;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.FaceData;
import com.baidu.tieba.faceshop.EmotionGroupData;
import com.baidu.tieba.faceshop.ab;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public class e {
    private static volatile e lBd;
    private boolean lBf;
    private FaceGroupDraft lBg;
    private Handler mUIHandler = new Handler(Looper.getMainLooper());
    private BlockingQueue<com.baidu.tbadk.img.f> lBe = new LinkedBlockingQueue(4);

    /* loaded from: classes9.dex */
    public interface a {
        void b(com.baidu.tieba.newfaceshop.b.b bVar);

        void onFail(String str);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void onFail();

        void onSuccess();
    }

    /* loaded from: classes9.dex */
    public interface c {
        void l(String str, List<FaceData> list);

        void onFail(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public interface d {
        void b(ImageUploadResult imageUploadResult);
    }

    public static e diD() {
        if (lBd == null) {
            synchronized (e.class) {
                if (lBd == null) {
                    lBd = new e();
                }
            }
        }
        return lBd;
    }

    private e() {
    }

    private void eZ(List<FaceData> list) {
        if (list != null && !list.isEmpty()) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (FaceData faceData : list) {
                if (faceData != null) {
                    switch (faceData.type) {
                        case 1:
                            i2++;
                            break;
                        case 2:
                            i3++;
                            break;
                        case 3:
                            i++;
                            break;
                    }
                    i = i;
                }
            }
            ar arVar = new ar(TbadkCoreStatisticKey.FACESHOP_UPLOAD_SOURCE);
            arVar.ap("obj_source", 3);
            arVar.ap("obj_type", i3);
            TiebaStatic.log(arVar);
            ar arVar2 = new ar(TbadkCoreStatisticKey.FACESHOP_UPLOAD_SOURCE);
            arVar2.ap("obj_source", 2);
            arVar2.ap("obj_type", i2);
            TiebaStatic.log(arVar2);
            ar arVar3 = new ar(TbadkCoreStatisticKey.FACESHOP_UPLOAD_SOURCE);
            arVar3.ap("obj_source", 1);
            arVar3.ap("obj_type", i);
            TiebaStatic.log(arVar3);
        }
    }

    public void a(String str, List<FaceData> list, c cVar, int i) {
        this.lBf = true;
        b(str, list, i);
        if (TextUtils.isEmpty(str)) {
            a(cVar, "name empty");
        } else if (list == null) {
            a(cVar, "list empty");
        } else {
            eZ(list);
            com.baidu.tieba.newfaceshop.a.dij().execute(new AnonymousClass1(list, cVar, str, i));
        }
    }

    /* renamed from: com.baidu.tieba.newfaceshop.facemake.e$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ List dGx;
        List<FaceData> lBh = new CopyOnWriteArrayList();
        List<String> lBi = new ArrayList();
        Map<String, Integer> lBj = new HashMap();
        List<FaceData> lBk = new CopyOnWriteArrayList();
        final /* synthetic */ c lBl;
        final /* synthetic */ int lBm;
        final /* synthetic */ String val$name;

        AnonymousClass1(List list, c cVar, String str, int i) {
            this.dGx = list;
            this.lBl = cVar;
            this.val$name = str;
            this.lBm = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            EmotionImageData emotionImageData;
            for (int i = 0; i < this.dGx.size(); i++) {
                FaceData faceData = (FaceData) this.dGx.get(i);
                faceData.index = i;
                if (faceData.type == 2) {
                    EmotionImageData emotionImageData2 = faceData.emotionImageData;
                    if (emotionImageData2 != null) {
                        if (!TextUtils.isEmpty(emotionImageData2.getPicId())) {
                            faceData.pid = emotionImageData2.getPicId();
                            faceData.width = emotionImageData2.getWidth();
                            faceData.height = emotionImageData2.getHeight();
                            this.lBh.add(faceData);
                        } else {
                            this.lBi.add(faceData.emotionImageData.getPicUrl());
                            this.lBj.put(faceData.emotionImageData.getPicUrl(), Integer.valueOf(faceData.index));
                        }
                    }
                } else if (faceData.type == 3) {
                    this.lBk.add(faceData);
                } else if (faceData.type == 1 && (emotionImageData = faceData.emotionImageData) != null) {
                    faceData.pid = emotionImageData.getPicId();
                    faceData.width = emotionImageData.getWidth();
                    faceData.height = emotionImageData.getHeight();
                    this.lBh.add(faceData);
                }
            }
            if (this.lBk.size() > 0) {
                final AtomicInteger atomicInteger = new AtomicInteger(this.lBk.size());
                final com.baidu.tieba.newfaceshop.facemake.a aVar = new com.baidu.tieba.newfaceshop.facemake.a(true);
                for (int i2 = 0; i2 < Math.min(this.lBk.size(), 4); i2++) {
                    e.this.lBe.offer(new com.baidu.tbadk.img.f("face group"));
                }
                for (int i3 = 0; i3 < this.lBk.size() && aVar.getResult(); i3++) {
                    final FaceData faceData2 = this.lBk.get(i3);
                    e.this.a(faceData2.imageFileInfo, new d() { // from class: com.baidu.tieba.newfaceshop.facemake.e.1.1
                        @Override // com.baidu.tieba.newfaceshop.facemake.e.d
                        public void b(ImageUploadResult imageUploadResult) {
                            if (aVar.getResult()) {
                                if (imageUploadResult != null && imageUploadResult.error_code == 0) {
                                    faceData2.pid = String.valueOf(imageUploadResult.picId);
                                    faceData2.width = imageUploadResult.picInfo.bigPic.width;
                                    faceData2.height = imageUploadResult.picInfo.bigPic.height;
                                    AnonymousClass1.this.lBh.add(faceData2);
                                    if (atomicInteger.decrementAndGet() == 0) {
                                        AnonymousClass1.this.diG();
                                    }
                                } else if (aVar.getResult()) {
                                    aVar.ut(false);
                                    e.this.a(AnonymousClass1.this.lBl, "failed to upload image");
                                }
                            }
                        }
                    });
                }
                return;
            }
            diG();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void diG() {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.facemake.e.1.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AnonymousClass1.this.lBi.size() > 0) {
                        new GetEmotionInfosModel().a(AnonymousClass1.this.lBi, new GetEmotionInfosModel.a() { // from class: com.baidu.tieba.newfaceshop.facemake.e.1.2.1
                            @Override // com.baidu.tbadk.img.GetEmotionInfosModel.a
                            public void aj(List<com.baidu.tbadk.img.c> list) {
                                for (com.baidu.tbadk.img.c cVar : list) {
                                    if (cVar != null) {
                                        FaceData faceData = new FaceData();
                                        faceData.type = 2;
                                        faceData.index = AnonymousClass1.this.lBj.get(cVar.eGz).intValue();
                                        faceData.pid = cVar.picId;
                                        faceData.width = cVar.width;
                                        faceData.height = cVar.height;
                                        EmotionImageData emotionImageData = new EmotionImageData();
                                        emotionImageData.setPicId(cVar.picId);
                                        emotionImageData.setThumbUrl(cVar.thumbnail);
                                        emotionImageData.setPicUrl(cVar.picUrl);
                                        emotionImageData.setWidth(cVar.width);
                                        emotionImageData.setHeight(cVar.height);
                                        faceData.emotionImageData = emotionImageData;
                                        AnonymousClass1.this.lBh.add(faceData);
                                    }
                                }
                                new UploadFaceGroupModel().b(AnonymousClass1.this.val$name, AnonymousClass1.this.lBh, AnonymousClass1.this.lBl, AnonymousClass1.this.lBm);
                            }

                            @Override // com.baidu.tbadk.img.GetEmotionInfosModel.a
                            public void onFail(int i, String str) {
                                e.this.a(AnonymousClass1.this.lBl, "get pid fail");
                            }
                        });
                    } else {
                        new UploadFaceGroupModel().b(AnonymousClass1.this.val$name, AnonymousClass1.this.lBh, AnonymousClass1.this.lBl, AnonymousClass1.this.lBm);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final ImageFileInfo imageFileInfo, final d dVar) {
        com.baidu.tieba.newfaceshop.a.dij().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.facemake.e.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String filePath = imageFileInfo.getFilePath();
                    if (imageFileInfo.isGif()) {
                        com.baidu.tbadk.img.f fVar = (com.baidu.tbadk.img.f) e.this.lBe.poll(10L, TimeUnit.SECONDS);
                        if (fVar != null) {
                            a(dVar, fVar.f(filePath, true, false));
                            e.this.a(fVar);
                        } else {
                            a(dVar, null);
                        }
                    } else {
                        Bitmap c2 = com.baidu.tieba.newfaceshop.facemake.b.c(imageFileInfo);
                        if (c2 == null) {
                            dVar.b(null);
                        } else {
                            String saveFileToSDOrMemory = e.saveFileToSDOrMemory("face_" + Math.abs(filePath.hashCode()), c2, 60);
                            c2.recycle();
                            if (!TextUtils.isEmpty(saveFileToSDOrMemory)) {
                                com.baidu.tbadk.img.f fVar2 = (com.baidu.tbadk.img.f) e.this.lBe.poll(10L, TimeUnit.SECONDS);
                                if (fVar2 != null) {
                                    ImageUploadResult f = fVar2.f(saveFileToSDOrMemory, false, false);
                                    o.deleteFile(new File(saveFileToSDOrMemory));
                                    a(dVar, f);
                                    e.this.a(fVar2);
                                } else {
                                    a(dVar, null);
                                }
                            } else {
                                a(dVar, null);
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            private void a(d dVar2, ImageUploadResult imageUploadResult) {
                if (dVar2 != null) {
                    dVar2.b(imageUploadResult);
                }
            }
        });
    }

    public static String saveFileToSDOrMemory(String str, Bitmap bitmap, int i) {
        if (bitmap == null) {
            return null;
        }
        File cacheDir = TbadkCoreApplication.getInst().getCacheDir();
        if (cacheDir.exists() && !cacheDir.isDirectory()) {
            cacheDir.delete();
        }
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        File file = new File(cacheDir, str);
        try {
            if ((!file.exists() || file.delete()) && file.createNewFile()) {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file.getAbsolutePath();
            }
            return null;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            TiebaStatic.file(e, k.join("FileHelper", ".", "saveFileToSDOrMemory", " ", file.getAbsolutePath()));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.img.f fVar) {
        this.lBe.offer(fVar);
    }

    public void a(String str, final List<FaceData> list, final b bVar) {
        final String str2 = com.baidu.tieba.newfaceshop.c.lAf + str + "/";
        new File(str2).mkdirs();
        final com.baidu.tieba.newfaceshop.b.a aVar = new com.baidu.tieba.newfaceshop.b.a();
        aVar.authorId = TbadkCoreApplication.getCurrentAccount();
        aVar.authorName = TbadkCoreApplication.getCurrentAccountName();
        aVar.id = str;
        aVar.createTime = String.valueOf(System.currentTimeMillis());
        final CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        final com.baidu.tieba.newfaceshop.facemake.a aVar2 = new com.baidu.tieba.newfaceshop.facemake.a(true);
        a aVar3 = new a() { // from class: com.baidu.tieba.newfaceshop.facemake.e.3
            @Override // com.baidu.tieba.newfaceshop.facemake.e.a
            public void b(com.baidu.tieba.newfaceshop.b.b bVar2) {
                if (aVar2.getResult()) {
                    copyOnWriteArrayList.add(bVar2);
                    if (copyOnWriteArrayList.size() == list.size()) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(copyOnWriteArrayList);
                        Collections.sort(arrayList);
                        aVar.pics = arrayList;
                        if (e.this.fQ(str2 + ((com.baidu.tieba.newfaceshop.b.b) arrayList.get(0)).lAy, str2)) {
                            e.this.a(aVar, bVar);
                        } else {
                            onFail("face group:fail to create panel");
                        }
                    }
                }
            }

            @Override // com.baidu.tieba.newfaceshop.facemake.e.a
            public void onFail(String str3) {
                if (aVar2.getResult()) {
                    aVar2.ut(false);
                    e.this.a(bVar, false);
                    if (!TextUtils.isEmpty(str3)) {
                        BdLog.e(str3);
                    }
                }
            }
        };
        for (FaceData faceData : list) {
            if (aVar2.getResult()) {
                if (faceData.type == 3) {
                    a(faceData, str2, aVar3);
                } else if (faceData.type == 1) {
                    b(faceData, str2, aVar3);
                } else if (faceData.type == 2) {
                    c(faceData, str2, aVar3);
                } else {
                    aVar3.onFail("facegroup:un support type in list");
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.newfaceshop.b.a aVar, b bVar) {
        int a2 = com.baidu.tieba.faceshop.a.cyo().a(aVar);
        if (a2 == 0) {
            BdLog.e("no valid emotion");
            a(bVar, false);
            return;
        }
        EmotionGroupData emotionGroupData = new EmotionGroupData();
        emotionGroupData.setGroupId(aVar.id);
        emotionGroupData.setEmotionsCount(a2);
        emotionGroupData.setHeight(aVar.pics.get(0).height);
        emotionGroupData.setWidth(aVar.pics.get(0).width);
        emotionGroupData.setDownloadTime(System.currentTimeMillis());
        emotionGroupData.setGroupName(aVar.name);
        emotionGroupData.setStatus(1);
        com.baidu.tieba.faceshop.i.cyE().a(emotionGroupData);
        com.baidu.tieba.faceshop.i.cyE().a(TbadkCoreApplication.getCurrentAccount(), emotionGroupData);
        a(bVar, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fQ(String str, String str2) {
        Bitmap OR = com.baidu.tieba.newfaceshop.facemake.b.OR(str);
        if (OR == null) {
            BdLog.e("cover bitmap null");
            return false;
        } else if (TextUtils.isEmpty(com.baidu.tieba.newfaceshop.b.saveFileAsPNG(str2, "panel.png", OR, 60))) {
            BdLog.e("fail to save Panel");
            return false;
        } else if (TextUtils.isEmpty(com.baidu.tieba.newfaceshop.b.saveFileAsPNG(str2, "panel_momo.png", OR, 60))) {
            BdLog.e("fail to save PanelMomo");
            return false;
        } else {
            return true;
        }
    }

    private void a(final FaceData faceData, final String str, final a aVar) {
        com.baidu.tieba.newfaceshop.a.dij().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.facemake.e.4
            @Override // java.lang.Runnable
            public void run() {
                Bitmap resizeBitmap;
                ImageFileInfo imageFileInfo = faceData.imageFileInfo;
                String filePath = imageFileInfo.getFilePath();
                String substring = filePath.substring(filePath.lastIndexOf("/") + 1);
                if (TextUtils.isEmpty(substring)) {
                    substring = TbadkCoreApplication.getCurrentAccount() + System.currentTimeMillis() + ".jpg";
                }
                String str2 = "t_" + substring;
                if (o.copyFile(filePath, str + substring)) {
                    Bitmap c2 = com.baidu.tieba.newfaceshop.facemake.b.c(imageFileInfo);
                    if (c2 == null) {
                        aVar.onFail("face group: fail to get origin bitmap when install album emotion");
                        return;
                    }
                    if (!imageFileInfo.isGif() && (resizeBitmap = BitmapHelper.resizeBitmap(c2, 240, 240, false)) != null) {
                        com.baidu.tieba.newfaceshop.b.saveFileAsPNG(str, substring, resizeBitmap, 100);
                        if (resizeBitmap != c2) {
                            resizeBitmap.recycle();
                        }
                    }
                    Bitmap resizeBitmap2 = BitmapHelper.resizeBitmap(c2, 150, 150, false);
                    if (resizeBitmap2 == null) {
                        aVar.onFail("face group: fail to create small file when install album emotion");
                        return;
                    }
                    com.baidu.tieba.newfaceshop.b.saveFileAsPNG(str, str2, resizeBitmap2, 100);
                    if (resizeBitmap2 != c2) {
                        resizeBitmap2.recycle();
                    }
                    c2.recycle();
                    com.baidu.tieba.newfaceshop.b.b bVar = new com.baidu.tieba.newfaceshop.b.b();
                    bVar.index = faceData.index;
                    bVar.id = faceData.pid;
                    bVar.name = substring;
                    bVar.lAy = str2;
                    bVar.width = faceData.width;
                    bVar.height = faceData.height;
                    aVar.b(bVar);
                    return;
                }
                aVar.onFail("face group: fail to copy file when install album emotion");
            }
        });
    }

    private void b(final FaceData faceData, final String str, final a aVar) {
        com.baidu.tieba.newfaceshop.a.dij().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.facemake.e.5
            @Override // java.lang.Runnable
            public void run() {
                EmotionImageData emotionImageData = faceData.emotionImageData;
                String str2 = TbadkCoreApplication.getCurrentAccount() + System.currentTimeMillis();
                String str3 = "t_" + str2;
                String aN = ab.aN(faceData.pid, true);
                String aN2 = ab.aN(faceData.pid, false);
                if (!o.copyFile(aN, str + str2)) {
                    aVar.onFail("face group: fail to copy big file when install collect emotion");
                } else if (!o.copyFile(aN2, str + str3)) {
                    aVar.onFail("face group: fail to copy small file when install collect emotion");
                } else {
                    com.baidu.tieba.newfaceshop.b.b bVar = new com.baidu.tieba.newfaceshop.b.b();
                    bVar.index = faceData.index;
                    bVar.id = faceData.pid;
                    bVar.name = str2;
                    bVar.lAy = str3;
                    bVar.width = faceData.width;
                    bVar.height = faceData.height;
                    aVar.b(bVar);
                }
            }
        });
    }

    private void c(final FaceData faceData, final String str, final a aVar) {
        com.baidu.tieba.newfaceshop.a.dij().execute(new Runnable() { // from class: com.baidu.tieba.newfaceshop.facemake.e.6
            @Override // java.lang.Runnable
            public void run() {
                EmotionImageData emotionImageData = faceData.emotionImageData;
                String substring = emotionImageData.getPicUrl().substring(emotionImageData.getPicUrl().lastIndexOf(IStringUtil.WINDOWS_FOLDER_SEPARATOR) + 1);
                String str2 = "t_" + substring;
                com.baidu.tbadk.core.util.b.i iVar = new com.baidu.tbadk.core.util.b.i();
                byte[] aw = iVar.aw(emotionImageData.getPicUrl(), false);
                if (aw != null && iVar.bti()) {
                    e.this.d(str, substring, aw);
                    byte[] aw2 = iVar.aw(emotionImageData.getThumbUrl(), false);
                    if (aw2 != null && iVar.bti()) {
                        e.this.d(str, str2, aw2);
                        com.baidu.tieba.newfaceshop.b.b bVar = new com.baidu.tieba.newfaceshop.b.b();
                        bVar.index = faceData.index;
                        bVar.id = faceData.pid;
                        bVar.name = substring;
                        bVar.lAy = str2;
                        bVar.width = faceData.width;
                        bVar.height = faceData.height;
                        aVar.b(bVar);
                        return;
                    }
                    aVar.onFail("face group: fail to download small file when install search emotion");
                    return;
                }
                aVar.onFail("face group: fail to download big file when install search emotion");
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [655=5, 656=5, 658=5, 659=5] */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String d(String str, String str2, byte[] bArr) {
        FileOutputStream fileOutputStream;
        File file = new File(str + str2);
        String parent = file.getParent();
        if (!StringUtils.isNull(parent)) {
            File file2 = new File(parent);
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            if (file.exists() && !file.delete()) {
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                        return null;
                    } catch (Throwable th) {
                        BdLog.e(th.getMessage());
                        return null;
                    }
                }
                return null;
            } else if (!file.createNewFile()) {
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                        return null;
                    } catch (Throwable th2) {
                        BdLog.e(th2.getMessage());
                        return null;
                    }
                }
                return null;
            } else {
                fileOutputStream = new FileOutputStream(file);
                try {
                    try {
                        fileOutputStream.write(bArr, 0, bArr.length);
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        FileOutputStream fileOutputStream3 = null;
                        String path = file.getPath();
                        if (0 != 0) {
                            try {
                                fileOutputStream3.close();
                            } catch (Throwable th3) {
                                BdLog.e(th3.getMessage());
                            }
                        }
                        return path;
                    } catch (IOException e) {
                        e = e;
                        BdLog.e(e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return null;
                            } catch (Throwable th4) {
                                BdLog.e(th4.getMessage());
                                return null;
                            }
                        }
                        return null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th6) {
                            BdLog.e(th6.getMessage());
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream = null;
        } catch (Throwable th7) {
            th = th7;
            fileOutputStream = null;
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final b bVar, final boolean z) {
        this.mUIHandler.post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.facemake.e.7
            @Override // java.lang.Runnable
            public void run() {
                if (bVar != null) {
                    if (z) {
                        bVar.onSuccess();
                    } else {
                        bVar.onFail();
                    }
                }
                if (z) {
                    com.baidu.tieba.newfaceshop.d.dip().diq();
                    MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_RELOAD_EMOTION_GROUPS, (Class) null);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("upload_result", new Boolean(true));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPLOAD_FACE_GROUP_FINISH, hashMap));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final c cVar, final String str) {
        this.mUIHandler.post(new Runnable() { // from class: com.baidu.tieba.newfaceshop.facemake.e.8
            @Override // java.lang.Runnable
            public void run() {
                if (cVar != null) {
                    cVar.onFail(str);
                }
                if (str != null) {
                    BdLog.e("face group:" + str);
                }
                e.this.D(false, null);
            }
        });
    }

    public void b(String str, List<FaceData> list, int i) {
        this.lBg = new FaceGroupDraft();
        this.lBg.setName(str);
        this.lBg.setList(list);
        this.lBg.setForumId(i);
    }

    public void dix() {
        this.lBg = null;
        com.baidu.tieba.newfaceshop.facemake.c.dix();
    }

    public FaceGroupDraft diE() {
        if (this.lBg == null) {
            this.lBg = com.baidu.tieba.newfaceshop.facemake.c.diw();
        }
        return this.lBg;
    }

    public boolean diF() {
        return this.lBf;
    }

    public void D(boolean z, String str) {
        if (this.lBf) {
            this.lBf = false;
        }
        if (z) {
            dix();
            return;
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("upload_result", new Boolean(false));
        if (!TextUtils.isEmpty(str)) {
            hashMap.put("upload_msg", str);
            if (this.lBg != null) {
                this.lBg.setFailMsg(str);
            }
        }
        com.baidu.tieba.newfaceshop.facemake.c.a(this.lBg);
        this.mUIHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.newfaceshop.facemake.e.9
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPLOAD_FACE_GROUP_FINISH, hashMap));
            }
        }, 1000L);
    }
}
