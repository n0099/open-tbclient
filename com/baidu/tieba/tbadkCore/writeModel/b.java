package com.baidu.tieba.tbadkCore.writeModel;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.img.ImageUploadResult;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends BdAsyncTask<Void, Void, ImageUploadResult> {
    final /* synthetic */ a cqe;
    private boolean cqc = false;
    com.baidu.tieba.tbadkCore.d.a cqd = new com.baidu.tieba.tbadkCore.d.a();
    Bitmap art = null;

    public b(a aVar) {
        this.cqe = aVar;
        setPriority(3);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: j */
    public ImageUploadResult doInBackground(Void... voidArr) {
        String str;
        byte[] bArr;
        String str2;
        String str3;
        String str4;
        String str5;
        ImageUploadResult a;
        byte[] bArr2;
        byte[] bArr3;
        String str6;
        String str7;
        ImageUploadResult a2;
        str = this.cqe.cpW;
        boolean cu = o.cu(str);
        if (this.cqc) {
            return null;
        }
        bArr = this.cqe.cpX;
        if (bArr != null) {
            bArr2 = this.cqe.cpX;
            if (bArr2.length > 0) {
                bArr3 = this.cqe.cpX;
                this.art = com.baidu.tbadk.core.util.c.w(bArr3);
                if (this.art != null) {
                    this.cqe.cpV = o.a(TbConfig.IMAGE_RESIZED_FILE, this.art, 80);
                    str6 = this.cqe.cpV;
                    if (TextUtils.isEmpty(str6)) {
                        if (this.art == null || this.art.isRecycled()) {
                            return null;
                        }
                        this.art.recycle();
                        return null;
                    }
                    a aVar = this.cqe;
                    str7 = this.cqe.cpV;
                    a2 = aVar.a(str7, this.cqd);
                    return a2;
                }
                return null;
            }
        }
        str2 = this.cqe.cpW;
        if (TextUtils.isEmpty(str2) || !cu) {
            return null;
        }
        str3 = this.cqe.cpW;
        Uri parse = Uri.parse(str3);
        this.cqe.cpV = o.c(TbadkCoreApplication.m411getInst().getApp(), parse);
        str4 = this.cqe.cpV;
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        a aVar2 = this.cqe;
        str5 = this.cqe.cpV;
        a = aVar2.a(str5, this.cqd);
        return a;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        c cVar;
        c cVar2;
        this.cqc = true;
        if (this.cqd != null) {
            this.cqd.cancel();
        }
        cVar = this.cqe.cpY;
        if (cVar != null) {
            cVar2 = this.cqe.cpY;
            cVar2.a(null, true);
        }
        if (this.art != null && !this.art.isRecycled()) {
            this.art.recycle();
        }
        super.cancel();
        this.cqe.cpT = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ImageUploadResult imageUploadResult) {
        c cVar;
        c cVar2;
        super.onPostExecute(imageUploadResult);
        if (!this.cqc) {
            cVar = this.cqe.cpY;
            if (cVar != null) {
                cVar2 = this.cqe.cpY;
                cVar2.a(imageUploadResult, false);
            }
            if (this.art != null && !this.art.isRecycled()) {
                this.art.recycle();
            }
        }
    }
}
