package com.baidu.tieba.tbadkCore.writeModel;

import android.text.TextUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f {
    public static int cpR = 10;
    private f cpS;
    private b cpT;
    private WriteData cpU;
    private String cpV;
    private String cpW;
    private byte[] cpX;
    private c cpY;
    private d cpZ;
    private e cqa;
    private boolean cqb;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cpS = null;
        this.cpT = null;
        this.cpU = null;
        this.cpV = null;
        this.cpW = null;
        this.cpX = null;
        this.cpZ = null;
        this.cqa = null;
        this.cqb = false;
    }

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar.getPageContext());
        this.cpS = null;
        this.cpT = null;
        this.cpU = null;
        this.cpV = null;
        this.cpW = null;
        this.cpX = null;
        this.cpZ = null;
        this.cqa = null;
        this.cqb = false;
    }

    public void eS(boolean z) {
        this.cqb = z;
    }

    public void a(e eVar) {
        this.cqa = eVar;
    }

    public void a(d dVar) {
        this.cpZ = dVar;
    }

    public void c(WriteData writeData) {
        this.cpU = writeData;
    }

    public WriteData IM() {
        return this.cpU;
    }

    public boolean anA() {
        if (this.cpU == null) {
            return false;
        }
        if (this.cpS == null) {
            this.cpS = new f(this);
            this.cpS.execute(new Integer[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.cpS != null && !this.cpS.isCancelled()) {
            this.cpS.cancel();
            return false;
        }
        return false;
    }

    public void anB() {
        if (this.cpT != null && !this.cpT.isCancelled()) {
            this.cpT.cancel();
        }
    }

    public boolean anC() {
        if (this.cpU == null) {
            return true;
        }
        int size = (!this.cpU.getIsBaobao() || this.cpU.getBaobaoImagesInfo() == null) ? 0 : this.cpU.getBaobaoImagesInfo().size() + 0;
        if (this.cpU.getWriteImagesInfo() != null) {
            size += this.cpU.getWriteImagesInfo().size();
        }
        return size <= cpR;
    }

    public void Ie() {
        if (this.cpT == null) {
            this.cpT = new b(this);
            this.cpT.execute(new Void[0]);
        }
    }

    public void c(byte[] bArr, String str) {
        this.cpX = bArr;
        this.cpW = str;
    }

    public void a(c cVar) {
        this.cpY = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageUploadResult a(String str, com.baidu.tieba.tbadkCore.d.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return null;
        }
        ImageFileInfo imageFileInfo = new ImageFileInfo();
        imageFileInfo.setFilePath(str);
        imageFileInfo.clearAllActions();
        imageFileInfo.addPersistAction(com.baidu.tbadk.img.effect.d.x(be.sY().te(), be.sY().te()));
        return aVar.b(imageFileInfo);
    }
}
