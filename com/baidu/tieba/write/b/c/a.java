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
    private b mPC;
    private e mPB = new e(true);
    private com.baidu.tbadk.img.b eOV = new com.baidu.tbadk.img.b();

    /* renamed from: com.baidu.tieba.write.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0829a {
        void cQu();
    }

    public void a(LinkedList<ImageFileInfo> linkedList, boolean z, InterfaceC0829a interfaceC0829a) {
        if (linkedList == null || linkedList.size() <= 0) {
            if (interfaceC0829a != null) {
                interfaceC0829a.cQu();
                return;
            }
            return;
        }
        this.isOriginalImg = z;
        if (this.mPC != null) {
            this.mPC.cancel();
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
            this.mPC = new b(linkedList, interfaceC0829a);
            this.mPC.execute(new String[0]);
        } else if (interfaceC0829a != null) {
            interfaceC0829a.cQu();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Void, Void> {
        LinkedList<ImageFileInfo> mPD;
        InterfaceC0829a mPE;

        public b(LinkedList<ImageFileInfo> linkedList, InterfaceC0829a interfaceC0829a) {
            this.mPD = linkedList;
            this.mPE = interfaceC0829a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            try {
                if (this.mPD != null) {
                    Iterator<ImageFileInfo> it = this.mPD.iterator();
                    while (it.hasNext()) {
                        ImageFileInfo next = it.next();
                        String j = a.this.j(next);
                        com.baidu.tieba.write.b.a.SF(j);
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
            if (this.mPE != null) {
                this.mPE.cQu();
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
        return this.mPB.c(imageFileInfo, this.isOriginalImg);
    }

    private String k(ImageFileInfo imageFileInfo) {
        Object a;
        Bitmap rawBitmap;
        int readPictureDegree;
        if (imageFileInfo == null || imageFileInfo.getImageType() != 1) {
            return null;
        }
        com.baidu.adp.widget.ImageView.a a2 = this.eOV.a(imageFileInfo, true);
        if (a2 != null) {
            rawBitmap = a2.getRawBitmap();
        } else {
            com.baidu.adp.lib.e.e ar = com.baidu.adp.lib.e.c.mM().ar(20);
            if (ar != null) {
                try {
                    a = ar.a(imageFileInfo.getFilePath(), imageFileInfo.toCachedKey(false), 0, 0, null, null, imageFileInfo.getFilePath(), false, null);
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
            return n.saveFileAsPic(e.eOU + "/", s.toMd5(imageFileInfo.toCachedKey(false)) + ".jpg", rawBitmap, 80, Bitmap.CompressFormat.JPEG);
        }
        return null;
    }
}
