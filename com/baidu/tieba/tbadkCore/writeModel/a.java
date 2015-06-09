package com.baidu.tieba.tbadkCore.writeModel;

import android.text.TextUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f {
    public static int cum = 10;
    private f cun;
    private b cuo;
    private WriteData cup;
    private String cuq;
    private String cur;
    private byte[] cus;
    private c cut;
    private d cuu;
    private e cuv;
    private boolean cuw;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cun = null;
        this.cuo = null;
        this.cup = null;
        this.cuq = null;
        this.cur = null;
        this.cus = null;
        this.cuu = null;
        this.cuv = null;
        this.cuw = false;
    }

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar.getPageContext());
        this.cun = null;
        this.cuo = null;
        this.cup = null;
        this.cuq = null;
        this.cur = null;
        this.cus = null;
        this.cuu = null;
        this.cuv = null;
        this.cuw = false;
    }

    public void fj(boolean z) {
        this.cuw = z;
    }

    public void a(e eVar) {
        this.cuv = eVar;
    }

    public void a(d dVar) {
        this.cuu = dVar;
    }

    public void c(WriteData writeData) {
        this.cup = writeData;
    }

    public WriteData JT() {
        return this.cup;
    }

    public boolean apI() {
        if (this.cup == null) {
            return false;
        }
        if (this.cun == null) {
            this.cun = new f(this);
            this.cun.execute(new Integer[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.cun != null && !this.cun.isCancelled()) {
            this.cun.cancel();
            return false;
        }
        return false;
    }

    public void apJ() {
        if (this.cuo != null && !this.cuo.isCancelled()) {
            this.cuo.cancel();
        }
    }

    public boolean apK() {
        if (this.cup == null) {
            return true;
        }
        int size = (!this.cup.getIsBaobao() || this.cup.getBaobaoImagesInfo() == null) ? 0 : this.cup.getBaobaoImagesInfo().size() + 0;
        if (this.cup.getWriteImagesInfo() != null) {
            size += this.cup.getWriteImagesInfo().size();
        }
        return size <= cum;
    }

    public void Jl() {
        if (this.cuo == null) {
            this.cuo = new b(this);
            this.cuo.execute(new Void[0]);
        }
    }

    public void c(byte[] bArr, String str) {
        this.cus = bArr;
        this.cur = str;
    }

    public void a(c cVar) {
        this.cut = cVar;
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
