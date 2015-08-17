package com.baidu.tieba.pb.pb.sub;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class ak extends com.baidu.tbadk.editortools.c.a {
    private static BdAsyncTaskParallel cgT = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private TbPageContext<?> LS;
    private com.baidu.tieba.tbadkCore.e.a aMS;
    private int aRd;
    private boolean avu;
    private int cab;
    private AntiData cao;
    private boolean cap;
    private boolean cgM;
    private String cgN;
    private String cgO;
    private boolean cgP;
    private String cgQ;
    private a cgR;
    private int cgS;
    private ArrayList<com.baidu.tieba.pb.a.c> cgU;
    private SmallTailInfo cgV;
    private boolean cgW;
    private SubPbRequestMessage cgX;
    private com.baidu.adp.framework.listener.a cgY;
    private com.baidu.tieba.pb.a.c cgq;
    private String postID;
    private String stType;
    private String threadID;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, String str, com.baidu.tieba.pb.a.c cVar);
    }

    static {
        com.baidu.tbadk.task.b a2 = com.baidu.tieba.tbadkCore.a.a.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a3 = com.baidu.tieba.tbadkCore.a.a.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a2.setParallel(cgT);
        a3.setParallel(cgT);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.cgM = intent.getBooleanExtra("is_jump_from_pb", false);
            this.cgN = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.cgP = intent.getBooleanExtra("show_keyboard", false);
            this.cgO = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.cab = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.cgV = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            this.cao = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.cgM = bundle.getBoolean("is_jump_from_pb", false);
            this.cgN = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.cgP = bundle.getBoolean("show_keyboard", false);
            this.cgO = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.cab = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.cgV = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            this.cao = (AntiData) bundle.getSerializable(SubPbActivityConfig.KEY_ANTI);
        }
    }

    public void saveToBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean("is_jump_from_pb", this.cgM);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.cgN);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.cgO);
            bundle.putBoolean("show_keyboard", this.cgP);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.cab);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.cgV);
            bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.cao);
        }
    }

    public ak(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aRd = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.cgM = false;
        this.cgN = null;
        this.cgO = null;
        this.cgP = false;
        this.cap = false;
        this.cab = 0;
        this.cgQ = null;
        this.LS = null;
        this.cgq = null;
        this.cgR = null;
        this.cgS = 0;
        this.cgU = null;
        this.avu = false;
        this.aMS = null;
        this.cgY = new al(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.LS = tbPageContext;
        this.cgU = new ArrayList<>();
        this.cgq = new com.baidu.tieba.pb.a.c();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.cgY);
        registerListener(this.cgY);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public String Bl() {
        return this.postID;
    }

    public com.baidu.tieba.pb.a.c afo() {
        return this.cgq;
    }

    public AntiData acW() {
        return this.cao;
    }

    public boolean afp() {
        return (this.cgq == null || this.cgq.acQ() == null) ? false : true;
    }

    public void a(a aVar) {
        this.cgR = aVar;
    }

    public MarkData c(com.baidu.tieba.tbadkCore.data.i iVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(iVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(iVar.apV());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.cgY);
        IS();
    }

    private void IS() {
        if (this.aMS != null) {
            this.aMS.destory();
            this.aMS = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void jt(String str) {
        if (!TextUtils.isEmpty(str) && this.cgq != null && this.cgq.acS() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.i> acS = this.cgq.acS();
            int size = acS.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(acS.get(i).getId())) {
                    acS.remove(i);
                    this.cgS++;
                    this.cgq.setTotalCount(this.cgq.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int afq() {
        int currentPage = this.cgq.getCurrentPage();
        if (currentPage == 0) {
            return currentPage + 1;
        }
        if (this.aRd == 0) {
            return currentPage + 1;
        }
        if (this.aRd == 2 && this.cgq.acS().size() != 0 && this.cgq.acS().size() % this.cgq.acU() == 0) {
            return currentPage + 1;
        }
        if (this.aRd == 3 && currentPage > 0) {
            return this.cgq.acR() - 1;
        }
        return currentPage;
    }

    private SubPbRequestMessage afr() {
        this.avu = true;
        return d((Integer) null);
    }

    private SubPbRequestMessage d(Integer num) {
        long j;
        int intValue;
        long j2 = 0;
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
        if (1 != this.aRd) {
            j = Long.parseLong(this.postID);
        } else {
            j = 0;
            j2 = Long.parseLong(this.postID);
        }
        if (num == null) {
            intValue = afq();
        } else {
            intValue = num.intValue();
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.LS.getPageActivity(), Long.parseLong(this.threadID), j, j2, intValue, K, L, f, this.stType);
        subPbRequestMessage.setNetType(NetMessage.NetType.HTTP);
        return subPbRequestMessage;
    }

    public boolean CV() {
        return iC(0);
    }

    public boolean afs() {
        return iC(2);
    }

    public void aft() {
        int acU;
        if (this.cgS > 0 && this.cgq != null && (acU = this.cgq.acU()) > 0) {
            int currentPage = this.cgq.getCurrentPage();
            for (int i = (((this.cgS + acU) - 1) / acU) - 1; i >= 0; i--) {
                this.cgX = d(Integer.valueOf(currentPage - i));
                this.cgX.setTreatDelPage(true);
                sendMessage(this.cgX);
            }
        }
        this.cgS = 0;
    }

    public boolean afu() {
        return iC(1);
    }

    public boolean iC(int i) {
        if (this.avu) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.avu = false;
            return false;
        }
        aft();
        this.aRd = i;
        this.cgX = afr();
        sendMessage(this.cgX);
        return true;
    }

    public void b(com.baidu.tieba.pb.a.c cVar) {
        String str;
        if (cVar.acX() == null || cVar.acX().getAuthor() == null) {
            str = null;
        } else {
            str = cVar.acX().getAuthor().getUserId();
        }
        if (!this.cgW) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= cVar.acS().size()) {
                    break;
                }
                cVar.acS().get(i2).a(this.LS.getUniqueId(), str.equals(cVar.acS().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.cgU.add(cVar);
    }

    public boolean aeO() {
        return this.cgM;
    }

    public String afv() {
        return this.cgN;
    }

    public boolean isMarked() {
        return this.cap;
    }

    public void eF(boolean z) {
        this.cap = z;
    }

    public int acK() {
        return this.cab;
    }

    public String afw() {
        return this.cgQ;
    }

    public void ju(String str) {
        this.cgQ = str;
    }

    public boolean afx() {
        return this.cgP;
    }

    public String afy() {
        return this.cgO;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public WriteData eI(String str) {
        if (this.cgq == null || this.cgq.acV() == null || this.cgq.acX() == null || this.cgq.acQ() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.cgq.acV().getName());
        writeData.setForumId(this.cgq.acV().getId());
        writeData.setFloor(this.cgq.acQ().getId());
        writeData.setType(2);
        writeData.setThreadId(this.cgq.acX().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public boolean Bk() {
        return afs();
    }

    public SmallTailInfo afz() {
        return this.cgV;
    }
}
