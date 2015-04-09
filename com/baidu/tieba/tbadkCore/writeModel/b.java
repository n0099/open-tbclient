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
    final /* synthetic */ a cqu;
    private boolean cqs = false;
    com.baidu.tieba.tbadkCore.d.a cqt = new com.baidu.tieba.tbadkCore.d.a();
    Bitmap arB = null;

    public b(a aVar) {
        this.cqu = aVar;
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
        str = this.cqu.cqm;
        boolean cu = o.cu(str);
        if (this.cqs) {
            return null;
        }
        bArr = this.cqu.cqn;
        if (bArr != null) {
            bArr2 = this.cqu.cqn;
            if (bArr2.length > 0) {
                bArr3 = this.cqu.cqn;
                this.arB = com.baidu.tbadk.core.util.c.w(bArr3);
                if (this.arB != null) {
                    this.cqu.cql = o.a(TbConfig.IMAGE_RESIZED_FILE, this.arB, 80);
                    str6 = this.cqu.cql;
                    if (TextUtils.isEmpty(str6)) {
                        if (this.arB == null || this.arB.isRecycled()) {
                            return null;
                        }
                        this.arB.recycle();
                        return null;
                    }
                    a aVar = this.cqu;
                    str7 = this.cqu.cql;
                    a2 = aVar.a(str7, this.cqt);
                    return a2;
                }
                return null;
            }
        }
        str2 = this.cqu.cqm;
        if (TextUtils.isEmpty(str2) || !cu) {
            return null;
        }
        str3 = this.cqu.cqm;
        Uri parse = Uri.parse(str3);
        this.cqu.cql = o.c(TbadkCoreApplication.m411getInst().getApp(), parse);
        str4 = this.cqu.cql;
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        a aVar2 = this.cqu;
        str5 = this.cqu.cql;
        a = aVar2.a(str5, this.cqt);
        return a;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        c cVar;
        c cVar2;
        this.cqs = true;
        if (this.cqt != null) {
            this.cqt.cancel();
        }
        cVar = this.cqu.cqo;
        if (cVar != null) {
            cVar2 = this.cqu.cqo;
            cVar2.a(null, true);
        }
        if (this.arB != null && !this.arB.isRecycled()) {
            this.arB.recycle();
        }
        super.cancel();
        this.cqu.cqj = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(ImageUploadResult imageUploadResult) {
        c cVar;
        c cVar2;
        super.onPostExecute(imageUploadResult);
        if (!this.cqs) {
            cVar = this.cqu.cqo;
            if (cVar != null) {
                cVar2 = this.cqu.cqo;
                cVar2.a(imageUploadResult, false);
            }
            if (this.arB != null && !this.arB.isRecycled()) {
                this.arB.recycle();
            }
        }
    }
}
