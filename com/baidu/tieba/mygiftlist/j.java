package com.baidu.tieba.mygiftlist;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.e {
    private String aok;
    private boolean boM;
    private boolean btl;
    private boolean mHasMore;
    private int mPageNum;
    private long mUid;

    /* JADX INFO: Access modifiers changed from: protected */
    public j(Context context, String str) {
        super(context);
        this.btl = false;
        this.mUid = 0L;
        this.boM = true;
        this.aok = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        sendMessage();
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    private MyGiftListRequestMessage b(int i, long j) {
        MyGiftListRequestMessage myGiftListRequestMessage = new MyGiftListRequestMessage();
        if (i < 1) {
            i = 1;
        }
        myGiftListRequestMessage.setPageNum(i);
        myGiftListRequestMessage.setUid(j);
        myGiftListRequestMessage.setStType(this.aok);
        return myGiftListRequestMessage;
    }

    private void gT(String str) {
        if (str != null && str.length() > 0 && !str.equals("0") && !str.startsWith("-")) {
            if (TbadkApplication.getCurrentAccount() != null && TbadkApplication.getCurrentAccount().equals(str)) {
                setIsSelf(true);
            } else {
                setIsSelf(false);
            }
        }
    }

    public long getUid() {
        return this.mUid;
    }

    public void setUid(long j) {
        this.mUid = j;
        gT(String.valueOf(this.mUid));
    }

    public void setIsSelf(boolean z) {
        this.boM = z;
    }

    public boolean getIsSelf() {
        return this.boM;
    }

    public void sendMessage() {
        MyGiftListRequestMessage b;
        if (this.boM) {
            this.mUid = 0L;
        }
        if (!this.btl) {
            b = b(1, this.mUid);
        } else {
            b = b(this.mPageNum, this.mUid);
        }
        sendMessage(b);
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public int getPageNum() {
        return this.mPageNum;
    }

    public void setPageNum(int i) {
        this.mPageNum = i;
    }

    public void dR(boolean z) {
        this.btl = z;
    }

    public boolean VH() {
        return this.btl;
    }
}
