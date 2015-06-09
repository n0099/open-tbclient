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
    final /* synthetic */ a cuz;
    private boolean cux = false;
    com.baidu.tieba.tbadkCore.d.a cuy = new com.baidu.tieba.tbadkCore.d.a();
    Bitmap ate = null;

    public b(a aVar) {
        this.cuz = aVar;
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
        str = this.cuz.cur;
        boolean cJ = o.cJ(str);
        if (this.cux) {
            return null;
        }
        bArr = this.cuz.cus;
        if (bArr != null) {
            bArr2 = this.cuz.cus;
            if (bArr2.length > 0) {
                bArr3 = this.cuz.cus;
                this.ate = com.baidu.tbadk.core.util.c.w(bArr3);
                if (this.ate != null) {
                    this.cuz.cuq = o.a(TbConfig.IMAGE_RESIZED_FILE, this.ate, 80);
                    str6 = this.cuz.cuq;
                    if (TextUtils.isEmpty(str6)) {
                        if (this.ate == null || this.ate.isRecycled()) {
                            return null;
                        }
                        this.ate.recycle();
                        return null;
                    }
                    a aVar = this.cuz;
                    str7 = this.cuz.cuq;
                    a2 = aVar.a(str7, this.cuy);
                    return a2;
                }
                return null;
            }
        }
        str2 = this.cuz.cur;
        if (TextUtils.isEmpty(str2) || !cJ) {
            return null;
        }
        str3 = this.cuz.cur;
        Uri parse = Uri.parse(str3);
        this.cuz.cuq = o.c(TbadkCoreApplication.m411getInst().getApp(), parse);
        str4 = this.cuz.cuq;
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        a aVar2 = this.cuz;
        str5 = this.cuz.cuq;
        a = aVar2.a(str5, this.cuy);
        return a;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        c cVar;
        c cVar2;
        this.cux = true;
        if (this.cuy != null) {
            this.cuy.cancel();
        }
        cVar = this.cuz.cut;
        if (cVar != null) {
            cVar2 = this.cuz.cut;
            cVar2.a(null, true);
        }
        if (this.ate != null && !this.ate.isRecycled()) {
            this.ate.recycle();
        }
        super.cancel();
        this.cuz.cuo = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ImageUploadResult imageUploadResult) {
        c cVar;
        c cVar2;
        super.onPostExecute(imageUploadResult);
        if (!this.cux) {
            cVar = this.cuz.cut;
            if (cVar != null) {
                cVar2 = this.cuz.cut;
                cVar2.a(imageUploadResult, false);
            }
            if (this.ate != null && !this.ate.isRecycled()) {
                this.ate.recycle();
            }
        }
    }
}
