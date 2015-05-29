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
    final /* synthetic */ a cuy;
    private boolean cuw = false;
    com.baidu.tieba.tbadkCore.d.a cux = new com.baidu.tieba.tbadkCore.d.a();
    Bitmap ate = null;

    public b(a aVar) {
        this.cuy = aVar;
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
        str = this.cuy.cuq;
        boolean cJ = o.cJ(str);
        if (this.cuw) {
            return null;
        }
        bArr = this.cuy.cur;
        if (bArr != null) {
            bArr2 = this.cuy.cur;
            if (bArr2.length > 0) {
                bArr3 = this.cuy.cur;
                this.ate = com.baidu.tbadk.core.util.c.w(bArr3);
                if (this.ate != null) {
                    this.cuy.cup = o.a(TbConfig.IMAGE_RESIZED_FILE, this.ate, 80);
                    str6 = this.cuy.cup;
                    if (TextUtils.isEmpty(str6)) {
                        if (this.ate == null || this.ate.isRecycled()) {
                            return null;
                        }
                        this.ate.recycle();
                        return null;
                    }
                    a aVar = this.cuy;
                    str7 = this.cuy.cup;
                    a2 = aVar.a(str7, this.cux);
                    return a2;
                }
                return null;
            }
        }
        str2 = this.cuy.cuq;
        if (TextUtils.isEmpty(str2) || !cJ) {
            return null;
        }
        str3 = this.cuy.cuq;
        Uri parse = Uri.parse(str3);
        this.cuy.cup = o.c(TbadkCoreApplication.m411getInst().getApp(), parse);
        str4 = this.cuy.cup;
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        a aVar2 = this.cuy;
        str5 = this.cuy.cup;
        a = aVar2.a(str5, this.cux);
        return a;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        c cVar;
        c cVar2;
        this.cuw = true;
        if (this.cux != null) {
            this.cux.cancel();
        }
        cVar = this.cuy.cus;
        if (cVar != null) {
            cVar2 = this.cuy.cus;
            cVar2.a(null, true);
        }
        if (this.ate != null && !this.ate.isRecycled()) {
            this.ate.recycle();
        }
        super.cancel();
        this.cuy.cun = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ImageUploadResult imageUploadResult) {
        c cVar;
        c cVar2;
        super.onPostExecute(imageUploadResult);
        if (!this.cuw) {
            cVar = this.cuy.cus;
            if (cVar != null) {
                cVar2 = this.cuy.cus;
                cVar2.a(imageUploadResult, false);
            }
            if (this.ate != null && !this.ate.isRecycled()) {
                this.ate.recycle();
            }
        }
    }
}
