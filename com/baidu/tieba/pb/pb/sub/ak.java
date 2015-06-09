package com.baidu.tieba.pb.pb.sub;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.base.f<NewSubPbActivity> {
    private static BdAsyncTaskParallel bQx = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private com.baidu.tieba.tbadkCore.e.a aFt;
    private boolean aoe;
    private int bJJ;
    private boolean bJW;
    private com.baidu.adp.framework.listener.a bQA;
    private String bQn;
    private boolean bQo;
    private String bQp;
    private String bQq;
    private boolean bQr;
    private String bQs;
    private NewSubPbActivity bQt;
    private com.baidu.tieba.pb.a.c bQu;
    private am bQv;
    private int bQw;
    private ArrayList<com.baidu.tieba.pb.a.c> bQy;
    private SubPbRequestMessage bQz;
    private int mLoadType;
    private String postID;
    private String stType;

    static {
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a2 = com.baidu.tieba.tbadkCore.a.a.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a.setParallel(bQx);
        a2.setParallel(bQx);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.bQn = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.bQo = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.bQp = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.bQr = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.bQq = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.bJJ = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.bQn = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.bQo = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.bQp = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.bQr = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.bQq = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.bJJ = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
        }
    }

    public void saveToBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.bQn);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.bQo);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.bQp);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.bQq);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.bQr);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.bJJ);
        }
    }

    public ak(NewSubPbActivity newSubPbActivity) {
        super(newSubPbActivity.getPageContext());
        this.mLoadType = 0;
        this.bQn = null;
        this.postID = null;
        this.stType = null;
        this.bQo = false;
        this.bQp = null;
        this.bQq = null;
        this.bQr = false;
        this.bJW = false;
        this.bJJ = 0;
        this.bQs = null;
        this.bQt = null;
        this.bQu = null;
        this.bQv = null;
        this.bQw = 0;
        this.bQy = null;
        this.aoe = false;
        this.aFt = null;
        this.bQA = new al(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.bQt = newSubPbActivity;
        this.bQy = new ArrayList<>();
        this.bQu = new com.baidu.tieba.pb.a.c();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.bQA);
        registerListener(this.bQA);
    }

    public String abp() {
        return this.bQn;
    }

    public String ZQ() {
        return this.postID;
    }

    public com.baidu.tieba.pb.a.c adC() {
        return this.bQu;
    }

    public boolean adD() {
        return (this.bQu == null || this.bQu.aaB() == null) ? false : true;
    }

    public WriteData JT() {
        if (this.bQu == null || this.bQu.aaG() == null || this.bQu.aaI() == null || this.bQu.aaB() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.bQu.aaG().getName());
        writeData.setForumId(this.bQu.aaG().getId());
        writeData.setFloor(this.bQu.aaB().getId());
        writeData.setType(2);
        writeData.setThreadId(this.bQu.aaI().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void a(am amVar) {
        this.bQv = amVar;
    }

    public MarkData c(com.baidu.tieba.tbadkCore.data.j jVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.bQn);
        markData.setPostId(jVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.bQn);
        markData.setFloor(jVar.aoC());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.bQA);
        If();
    }

    private void If() {
        if (this.aFt != null) {
            this.aFt.destory();
            this.aFt = null;
        }
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void iy(String str) {
        if (!TextUtils.isEmpty(str) && this.bQu != null && this.bQu.aaD() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aaD = this.bQu.aaD();
            int size = aaD.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aaD.get(i).getId())) {
                    aaD.remove(i);
                    this.bQw++;
                    this.bQu.setTotalCount(this.bQu.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int adE() {
        int currentPage = this.bQu.getCurrentPage();
        if (currentPage == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 2 && this.bQu.aaD().size() % this.bQu.aaF() == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 3 && currentPage > 0) {
            return this.bQu.aaC() - 1;
        }
        return currentPage;
    }

    private SubPbRequestMessage adF() {
        this.aoe = true;
        return d((Integer) null);
    }

    private SubPbRequestMessage d(Integer num) {
        long j;
        int intValue;
        long j2 = 0;
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int M = com.baidu.adp.lib.util.n.M(TbadkCoreApplication.m411getInst().getApp());
        int N = com.baidu.adp.lib.util.n.N(TbadkCoreApplication.m411getInst().getApp());
        if (1 != this.mLoadType) {
            j = Long.parseLong(this.postID);
        } else {
            j = 0;
            j2 = Long.parseLong(this.postID);
        }
        if (num == null) {
            intValue = adE();
        } else {
            intValue = num.intValue();
        }
        return new SubPbRequestMessage(this.bQt.getPageContext().getPageActivity(), Long.parseLong(this.bQn), j, j2, intValue, M, N, f, this.stType);
    }

    public boolean BM() {
        return hI(0);
    }

    public boolean adG() {
        return hI(2);
    }

    public void adH() {
        int aaF;
        if (this.bQw > 0 && this.bQu != null && (aaF = this.bQu.aaF()) > 0) {
            int currentPage = this.bQu.getCurrentPage();
            for (int i = (((this.bQw + aaF) - 1) / aaF) - 1; i >= 0; i--) {
                this.bQz = d(Integer.valueOf(currentPage - i));
                this.bQz.setTreatDelPage(true);
                sendMessage(this.bQz);
            }
        }
        this.bQw = 0;
    }

    public boolean adI() {
        return hI(1);
    }

    public boolean hI(int i) {
        if (this.aoe) {
            return false;
        }
        cancelMessage();
        if (this.bQn == null || this.postID == null) {
            this.aoe = false;
            return false;
        }
        adH();
        this.mLoadType = i;
        this.bQz = adF();
        sendMessage(this.bQz);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(com.baidu.tieba.pb.a.c cVar) {
        String str;
        if (cVar.aaI() == null || cVar.aaI().getAuthor() == null) {
            str = null;
        } else {
            str = cVar.aaI().getAuthor().getUserId();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < cVar.aaD().size()) {
                cVar.aaD().get(i2).b(this.bQt.getPageContext(), str.equals(cVar.aaD().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            } else {
                this.bQy.add(cVar);
                return;
            }
        }
    }

    public boolean acQ() {
        return this.bQo;
    }

    public String adJ() {
        return this.bQp;
    }

    public boolean isMarked() {
        return this.bJW;
    }

    public void en(boolean z) {
        this.bJW = z;
    }

    public int aaw() {
        return this.bJJ;
    }

    public String adK() {
        return this.bQs;
    }

    public void iz(String str) {
        this.bQs = str;
    }

    public boolean adL() {
        return this.bQr;
    }

    public String adM() {
        return this.bQq;
    }
}
