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
    private static BdAsyncTaskParallel bQw = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private com.baidu.tieba.tbadkCore.e.a aFs;
    private boolean aoe;
    private int bJI;
    private boolean bJV;
    private String bQm;
    private boolean bQn;
    private String bQo;
    private String bQp;
    private boolean bQq;
    private String bQr;
    private NewSubPbActivity bQs;
    private com.baidu.tieba.pb.a.c bQt;
    private am bQu;
    private int bQv;
    private ArrayList<com.baidu.tieba.pb.a.c> bQx;
    private SubPbRequestMessage bQy;
    private com.baidu.adp.framework.listener.a bQz;
    private int mLoadType;
    private String postID;
    private String stType;

    static {
        com.baidu.tbadk.task.b a = com.baidu.tieba.tbadkCore.a.a.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a2 = com.baidu.tieba.tbadkCore.a.a.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a.setParallel(bQw);
        a2.setParallel(bQw);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.bQm = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.bQn = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.bQo = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.bQq = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.bQp = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.bJI = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.bQm = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.bQn = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.bQo = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.bQq = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.bQp = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.bJI = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
        }
    }

    public void saveToBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.bQm);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.bQn);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.bQo);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.bQp);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.bQq);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.bJI);
        }
    }

    public ak(NewSubPbActivity newSubPbActivity) {
        super(newSubPbActivity.getPageContext());
        this.mLoadType = 0;
        this.bQm = null;
        this.postID = null;
        this.stType = null;
        this.bQn = false;
        this.bQo = null;
        this.bQp = null;
        this.bQq = false;
        this.bJV = false;
        this.bJI = 0;
        this.bQr = null;
        this.bQs = null;
        this.bQt = null;
        this.bQu = null;
        this.bQv = 0;
        this.bQx = null;
        this.aoe = false;
        this.aFs = null;
        this.bQz = new al(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.bQs = newSubPbActivity;
        this.bQx = new ArrayList<>();
        this.bQt = new com.baidu.tieba.pb.a.c();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.bQz);
        registerListener(this.bQz);
    }

    public String abo() {
        return this.bQm;
    }

    public String ZP() {
        return this.postID;
    }

    public com.baidu.tieba.pb.a.c adB() {
        return this.bQt;
    }

    public boolean adC() {
        return (this.bQt == null || this.bQt.aaA() == null) ? false : true;
    }

    public WriteData JS() {
        if (this.bQt == null || this.bQt.aaF() == null || this.bQt.aaH() == null || this.bQt.aaA() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.bQt.aaF().getName());
        writeData.setForumId(this.bQt.aaF().getId());
        writeData.setFloor(this.bQt.aaA().getId());
        writeData.setType(2);
        writeData.setThreadId(this.bQt.aaH().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    public void a(am amVar) {
        this.bQu = amVar;
    }

    public MarkData c(com.baidu.tieba.tbadkCore.data.j jVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.bQm);
        markData.setPostId(jVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.bQm);
        markData.setFloor(jVar.aoB());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.bQz);
        Ie();
    }

    private void Ie() {
        if (this.aFs != null) {
            this.aFs.destory();
            this.aFs = null;
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
        if (!TextUtils.isEmpty(str) && this.bQt != null && this.bQt.aaC() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.j> aaC = this.bQt.aaC();
            int size = aaC.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aaC.get(i).getId())) {
                    aaC.remove(i);
                    this.bQv++;
                    this.bQt.setTotalCount(this.bQt.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int adD() {
        int currentPage = this.bQt.getCurrentPage();
        if (currentPage == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 2 && this.bQt.aaC().size() % this.bQt.aaE() == 0) {
            return currentPage + 1;
        }
        if (this.mLoadType == 3 && currentPage > 0) {
            return this.bQt.aaB() - 1;
        }
        return currentPage;
    }

    private SubPbRequestMessage adE() {
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
            intValue = adD();
        } else {
            intValue = num.intValue();
        }
        return new SubPbRequestMessage(this.bQs.getPageContext().getPageActivity(), Long.parseLong(this.bQm), j, j2, intValue, M, N, f, this.stType);
    }

    public boolean BL() {
        return hI(0);
    }

    public boolean adF() {
        return hI(2);
    }

    public void adG() {
        int aaE;
        if (this.bQv > 0 && this.bQt != null && (aaE = this.bQt.aaE()) > 0) {
            int currentPage = this.bQt.getCurrentPage();
            for (int i = (((this.bQv + aaE) - 1) / aaE) - 1; i >= 0; i--) {
                this.bQy = d(Integer.valueOf(currentPage - i));
                this.bQy.setTreatDelPage(true);
                sendMessage(this.bQy);
            }
        }
        this.bQv = 0;
    }

    public boolean adH() {
        return hI(1);
    }

    public boolean hI(int i) {
        if (this.aoe) {
            return false;
        }
        cancelMessage();
        if (this.bQm == null || this.postID == null) {
            this.aoe = false;
            return false;
        }
        adG();
        this.mLoadType = i;
        this.bQy = adE();
        sendMessage(this.bQy);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(com.baidu.tieba.pb.a.c cVar) {
        String str;
        if (cVar.aaH() == null || cVar.aaH().getAuthor() == null) {
            str = null;
        } else {
            str = cVar.aaH().getAuthor().getUserId();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < cVar.aaC().size()) {
                cVar.aaC().get(i2).b(this.bQs.getPageContext(), str.equals(cVar.aaC().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            } else {
                this.bQx.add(cVar);
                return;
            }
        }
    }

    public boolean acP() {
        return this.bQn;
    }

    public String adI() {
        return this.bQo;
    }

    public boolean isMarked() {
        return this.bJV;
    }

    public void en(boolean z) {
        this.bJV = z;
    }

    public int aav() {
        return this.bJI;
    }

    public String adJ() {
        return this.bQr;
    }

    public void iz(String str) {
        this.bQr = str;
    }

    public boolean adK() {
        return this.bQq;
    }

    public String adL() {
        return this.bQp;
    }
}
