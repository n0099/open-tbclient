package com.baidu.tieba.tbadkCore.writeModel;

import android.text.TextUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.f {
    public static int cqh = 10;
    private f cqi;
    private b cqj;
    private WriteData cqk;
    private String cql;
    private String cqm;
    private byte[] cqn;
    private c cqo;
    private d cqp;
    private e cqq;
    private boolean cqr;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cqi = null;
        this.cqj = null;
        this.cqk = null;
        this.cql = null;
        this.cqm = null;
        this.cqn = null;
        this.cqp = null;
        this.cqq = null;
        this.cqr = false;
    }

    public a(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar.getPageContext());
        this.cqi = null;
        this.cqj = null;
        this.cqk = null;
        this.cql = null;
        this.cqm = null;
        this.cqn = null;
        this.cqp = null;
        this.cqq = null;
        this.cqr = false;
    }

    public void eQ(boolean z) {
        this.cqr = z;
    }

    public void a(e eVar) {
        this.cqq = eVar;
    }

    public void a(d dVar) {
        this.cqp = dVar;
    }

    public void c(WriteData writeData) {
        this.cqk = writeData;
    }

    public WriteData IS() {
        return this.cqk;
    }

    public boolean anP() {
        if (this.cqk == null) {
            return false;
        }
        if (this.cqi == null) {
            this.cqi = new f(this);
            this.cqi.execute(new Integer[0]);
        }
        return true;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        if (this.cqi != null && !this.cqi.isCancelled()) {
            this.cqi.cancel();
            return false;
        }
        return false;
    }

    public void anQ() {
        if (this.cqj != null && !this.cqj.isCancelled()) {
            this.cqj.cancel();
        }
    }

    public boolean anR() {
        if (this.cqk == null) {
            return true;
        }
        int size = (!this.cqk.getIsBaobao() || this.cqk.getBaobaoImagesInfo() == null) ? 0 : this.cqk.getBaobaoImagesInfo().size() + 0;
        if (this.cqk.getWriteImagesInfo() != null) {
            size += this.cqk.getWriteImagesInfo().size();
        }
        return size <= cqh;
    }

    public void Ik() {
        if (this.cqj == null) {
            this.cqj = new b(this);
            this.cqj.execute(new Void[0]);
        }
    }

    public void c(byte[] bArr, String str) {
        this.cqn = bArr;
        this.cqm = str;
    }

    public void a(c cVar) {
        this.cqo = cVar;
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
