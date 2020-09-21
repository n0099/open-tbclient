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
    private b mZM;
    private e mZL = new e(true);
    private com.baidu.tbadk.img.b eRQ = new com.baidu.tbadk.img.b();

    /* renamed from: com.baidu.tieba.write.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0826a {
        void cUb();
    }

    public void a(LinkedList<ImageFileInfo> linkedList, boolean z, InterfaceC0826a interfaceC0826a) {
        if (linkedList == null || linkedList.size() <= 0) {
            if (interfaceC0826a != null) {
                interfaceC0826a.cUb();
                return;
            }
            return;
        }
        this.isOriginalImg = z;
        if (this.mZM != null) {
            this.mZM.cancel();
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
            this.mZM = new b(linkedList, interfaceC0826a);
            this.mZM.execute(new String[0]);
        } else if (interfaceC0826a != null) {
            interfaceC0826a.cUb();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Void, Void> {
        LinkedList<ImageFileInfo> mZN;
        InterfaceC0826a mZO;

        public b(LinkedList<ImageFileInfo> linkedList, InterfaceC0826a interfaceC0826a) {
            this.mZN = linkedList;
            this.mZO = interfaceC0826a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            try {
                if (this.mZN != null) {
                    Iterator<ImageFileInfo> it = this.mZN.iterator();
                    while (it.hasNext()) {
                        ImageFileInfo next = it.next();
                        String j = a.this.j(next);
                        com.baidu.tieba.write.b.a.Tf(j);
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
            if (this.mZO != null) {
                this.mZO.cUb();
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
        return this.mZL.c(imageFileInfo, this.isOriginalImg);
    }

    private String k(ImageFileInfo imageFileInfo) {
        Object a;
        Bitmap rawBitmap;
        int readPictureDegree;
        if (imageFileInfo == null || imageFileInfo.getImageType() != 1) {
            return null;
        }
        com.baidu.adp.widget.ImageView.a a2 = this.eRQ.a(imageFileInfo, true);
        if (a2 != null) {
            rawBitmap = a2.getRawBitmap();
        } else {
            com.baidu.adp.lib.e.e au = com.baidu.adp.lib.e.c.mR().au(20);
            if (au != null) {
                try {
                    a = au.a(imageFileInfo.getFilePath(), imageFileInfo.toCachedKey(false), 0, 0, null, null, imageFileInfo.getFilePath(), false, null);
                } catch (OutOfMemoryError e) {
                    BdBaseApplication.getInst().onAppMemoryLow();
                }
                if (a instanceof com.baidu.adp.widget.ImageView.a) {
                    rawBitmap = ((com.baidu.adp.widget.ImageView.a) a).getRawBitmap();
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
            return n.saveFileAsPic(e.eRP + "/", s.toMd5(imageFileInfo.toCachedKey(false)) + ".jpg", rawBitmap, 80, Bitmap.CompressFormat.JPEG);
        }
        return null;
    }
}
