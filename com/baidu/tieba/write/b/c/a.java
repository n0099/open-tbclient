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
    private b nXo;
    private e nXn = new e(true);
    private com.baidu.tbadk.img.b fzm = new com.baidu.tbadk.img.b();

    /* renamed from: com.baidu.tieba.write.b.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0893a {
        void die();
    }

    public void a(LinkedList<ImageFileInfo> linkedList, boolean z, InterfaceC0893a interfaceC0893a) {
        if (linkedList == null || linkedList.size() <= 0) {
            if (interfaceC0893a != null) {
                interfaceC0893a.die();
                return;
            }
            return;
        }
        this.isOriginalImg = z;
        if (this.nXo != null) {
            this.nXo.cancel();
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
            this.nXo = new b(linkedList, interfaceC0893a);
            this.nXo.execute(new String[0]);
        } else if (interfaceC0893a != null) {
            interfaceC0893a.die();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends BdAsyncTask<String, Void, Void> {
        LinkedList<ImageFileInfo> nXp;
        InterfaceC0893a nXq;

        public b(LinkedList<ImageFileInfo> linkedList, InterfaceC0893a interfaceC0893a) {
            this.nXp = linkedList;
            this.nXq = interfaceC0893a;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            try {
                if (this.nXp != null) {
                    Iterator<ImageFileInfo> it = this.nXp.iterator();
                    while (it.hasNext()) {
                        ImageFileInfo next = it.next();
                        String j = a.this.j(next);
                        com.baidu.tieba.write.b.a.VJ(j);
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
            if (this.nXq != null) {
                this.nXq.die();
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
        return this.nXn.c(imageFileInfo, this.isOriginalImg);
    }

    private String k(ImageFileInfo imageFileInfo) {
        Object a2;
        Bitmap rawBitmap;
        int readPictureDegree;
        if (imageFileInfo == null || imageFileInfo.getImageType() != 1) {
            return null;
        }
        com.baidu.adp.widget.ImageView.a a3 = this.fzm.a(imageFileInfo, true);
        if (a3 != null) {
            rawBitmap = a3.getRawBitmap();
        } else {
            com.baidu.adp.lib.e.e ax = com.baidu.adp.lib.e.c.mS().ax(20);
            if (ax != null) {
                try {
                    a2 = ax.a(imageFileInfo.getFilePath(), imageFileInfo.toCachedKey(false), 0, 0, null, null, imageFileInfo.getFilePath(), false, null);
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
            return n.saveFileAsPic(e.fzl + "/", s.toMd5(imageFileInfo.toCachedKey(false)) + ".jpg", rawBitmap, 80, Bitmap.CompressFormat.JPEG);
        }
        return null;
    }
}
