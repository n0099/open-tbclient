package com.baidu.tieba.write.b.c;

import android.graphics.Bitmap;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.s;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.e;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class a {
    private boolean isOriginalImg;
    private b nHF;
    private e nHE = new e(true);
    private com.baidu.tbadk.img.b fsq = new com.baidu.tbadk.img.b();

    /* renamed from: com.baidu.tieba.write.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0874a {
        void ddu();
    }

    public void a(LinkedList<ImageFileInfo> linkedList, boolean z, InterfaceC0874a interfaceC0874a) {
        if (linkedList == null || linkedList.size() <= 0) {
            if (interfaceC0874a != null) {
                interfaceC0874a.ddu();
                return;
            }
            return;
        }
        this.isOriginalImg = z;
        if (this.nHF != null) {
            this.nHF.cancel();
        }
        LinkedList linkedList2 = new LinkedList();
        Iterator<ImageFileInfo> it = linkedList.iterator();
        while (it.hasNext()) {
            ImageFileInfo next = it.next();
            if (next.getImageType() == 1 || next.hasActionsWithoutResize()) {
                linkedList2.add(next);
            }
        }
        if (linkedList2.size() > 0) {
            this.nHF = new b(linkedList, interfaceC0874a);
            this.nHF.execute(new String[0]);
        } else if (interfaceC0874a != null) {
            interfaceC0874a.ddu();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Void, Void> {
        LinkedList<ImageFileInfo> nHG;
        InterfaceC0874a nHH;

        public b(LinkedList<ImageFileInfo> linkedList, InterfaceC0874a interfaceC0874a) {
            this.nHG = linkedList;
            this.nHH = interfaceC0874a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            try {
                if (this.nHG != null) {
                    Iterator<ImageFileInfo> it = this.nHG.iterator();
                    while (it.hasNext()) {
                        ImageFileInfo next = it.next();
                        String j = a.this.j(next);
                        com.baidu.tieba.write.b.a.UJ(j);
                        next.setFilePath(j);
                        next.setContentUriStr(null);
                    }
                }
            } catch (Exception e) {
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Void r2) {
            if (this.nHH != null) {
                this.nHH.ddu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null) {
            return null;
        }
        if (imageFileInfo.getImageType() == 1) {
            return k(imageFileInfo);
        }
        return this.nHE.c(imageFileInfo, this.isOriginalImg);
    }

    private String k(ImageFileInfo imageFileInfo) {
        Object a2;
        Bitmap rawBitmap;
        int readPictureDegree;
        if (imageFileInfo == null || imageFileInfo.getImageType() != 1) {
            return null;
        }
        com.baidu.adp.widget.ImageView.a a3 = this.fsq.a(imageFileInfo, true);
        if (a3 != null) {
            rawBitmap = a3.getRawBitmap();
        } else {
            com.baidu.adp.lib.e.e au = com.baidu.adp.lib.e.c.mS().au(20);
            if (au != null) {
                try {
                    a2 = au.a(imageFileInfo.getFilePath(), imageFileInfo.toCachedKey(false), 0, 0, null, null, imageFileInfo.getFilePath(), false, null);
                } catch (OutOfMemoryError e) {
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
                if (a2 instanceof com.baidu.adp.widget.ImageView.a) {
                    rawBitmap = ((com.baidu.adp.widget.ImageView.a) a2).getRawBitmap();
                    if (rawBitmap != null && (readPictureDegree = BitmapHelper.readPictureDegree(imageFileInfo.getFilePath())) != 0) {
                        rawBitmap = BitmapHelper.rotateBitmapBydegree(rawBitmap, readPictureDegree);
                    }
                }
            }
            rawBitmap = null;
            if (rawBitmap != null) {
                rawBitmap = BitmapHelper.rotateBitmapBydegree(rawBitmap, readPictureDegree);
            }
        }
        if (rawBitmap != null) {
            return n.saveFileAsPic(e.fsp + "/", s.toMd5(imageFileInfo.toCachedKey(false)) + ".jpg", rawBitmap, 80, Bitmap.CompressFormat.JPEG);
        }
        return null;
    }
}
