package com.baidu.tieba.tbadkCore.writeModel;

import android.text.TextUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f {
    public static int cul = 10;
    private f cum;
    private b cun;
    private WriteData cuo;
    private String cup;
    private String cuq;
    private byte[] cur;
    private c cus;
    private d cut;
    private e cuu;
    private boolean cuv;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cum = null;
        this.cun = null;
        this.cuo = null;
        this.cup = null;
        this.cuq = null;
        this.cur = null;
        this.cut = null;
        this.cuu = null;
        this.cuv = false;
    }

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar.getPageContext());
        this.cum = null;
        this.cun = null;
        this.cuo = null;
        this.cup = null;
        this.cuq = null;
        this.cur = null;
        this.cut = null;
        this.cuu = null;
        this.cuv = false;
    }

    public void fj(boolean z) {
        this.cuv = z;
    }

    public void a(e eVar) {
        this.cuu = eVar;
    }

    public void a(d dVar) {
        this.cut = dVar;
    }

    public void c(WriteData writeData) {
        this.cuo = writeData;
    }

    public WriteData JS() {
        return this.cuo;
    }

    public boolean apH() {
        if (this.cuo == null) {
            return false;
        }
        if (this.cum == null) {
            this.cum = new f(this);
            this.cum.execute(new Integer[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.cum != null && !this.cum.isCancelled()) {
            this.cum.cancel();
            return false;
        }
        return false;
    }

    public void apI() {
        if (this.cun != null && !this.cun.isCancelled()) {
            this.cun.cancel();
        }
    }

    public boolean apJ() {
        if (this.cuo == null) {
            return true;
        }
        int size = (!this.cuo.getIsBaobao() || this.cuo.getBaobaoImagesInfo() == null) ? 0 : this.cuo.getBaobaoImagesInfo().size() + 0;
        if (this.cuo.getWriteImagesInfo() != null) {
            size += this.cuo.getWriteImagesInfo().size();
        }
        return size <= cul;
    }

    public void Jk() {
        if (this.cun == null) {
            this.cun = new b(this);
            this.cun.execute(new Void[0]);
        }
    }

    public void c(byte[] bArr, String str) {
        this.cur = bArr;
        this.cuq = str;
    }

    public void a(c cVar) {
        this.cus = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.d.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.y(bc.tB().tH(), bc.tB().tH()));
        return aVar.b(imageFileInfo);
    }
}
