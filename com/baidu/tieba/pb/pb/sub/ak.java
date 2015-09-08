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
    private static BdAsyncTaskParallel chQ = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private com.baidu.tieba.tbadkCore.e.a aNf;
    private int aRr;
    private boolean axc;
    private int caV;
    private AntiData cbj;
    private boolean cbk;
    private boolean chJ;
    private String chK;
    private String chL;
    private boolean chM;
    private String chN;
    private a chO;
    private int chP;
    private ArrayList<com.baidu.tieba.pb.a.c> chR;
    private SmallTailInfo chS;
    private boolean chT;
    private SubPbRequestMessage chU;
    private com.baidu.adp.framework.listener.a chV;
    private com.baidu.tieba.pb.a.c cho;
    private TbPageContext<?> mContext;
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
        a2.setParallel(chQ);
        a3.setParallel(chQ);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.chJ = intent.getBooleanExtra("is_jump_from_pb", false);
            this.chK = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.chM = intent.getBooleanExtra("show_keyboard", false);
            this.chL = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.caV = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.chS = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.chS != null) {
                this.chS.updateShowInfo();
            }
            this.cbj = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.chJ = bundle.getBoolean("is_jump_from_pb", false);
            this.chK = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.chM = bundle.getBoolean("show_keyboard", false);
            this.chL = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.caV = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.chS = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.chS != null) {
                this.chS.updateShowInfo();
            }
            this.cbj = (AntiData) bundle.getSerializable(SubPbActivityConfig.KEY_ANTI);
        }
    }

    public void saveToBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean("is_jump_from_pb", this.chJ);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.chK);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.chL);
            bundle.putBoolean("show_keyboard", this.chM);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.caV);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.chS);
            bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.cbj);
        }
    }

    public ak(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aRr = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.chJ = false;
        this.chK = null;
        this.chL = null;
        this.chM = false;
        this.cbk = false;
        this.caV = 0;
        this.chN = null;
        this.mContext = null;
        this.cho = null;
        this.chO = null;
        this.chP = 0;
        this.chR = null;
        this.axc = false;
        this.aNf = null;
        this.chV = new al(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.mContext = tbPageContext;
        this.chR = new ArrayList<>();
        this.cho = new com.baidu.tieba.pb.a.c();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.chV);
        registerListener(this.chV);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public String By() {
        return this.postID;
    }

    public com.baidu.tieba.pb.a.c afD() {
        return this.cho;
    }

    public AntiData adj() {
        return this.cbj;
    }

    public boolean afE() {
        return (this.cho == null || this.cho.adb() == null) ? false : true;
    }

    public void a(a aVar) {
        this.chO = aVar;
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
        markData.setFloor(iVar.auj());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.chV);
        IG();
    }

    private void IG() {
        if (this.aNf != null) {
            this.aNf.destory();
            this.aNf = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int afF() {
        return this.aRr;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void jB(String str) {
        if (!TextUtils.isEmpty(str) && this.cho != null && this.cho.adf() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.i> adf = this.cho.adf();
            int size = adf.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(adf.get(i).getId())) {
                    adf.remove(i);
                    this.chP++;
                    this.cho.setTotalCount(this.cho.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int afG() {
        int currentPage = this.cho.getCurrentPage();
        if (currentPage == 0) {
            return currentPage + 1;
        }
        if (this.aRr == 0) {
            return currentPage + 1;
        }
        if (this.aRr == 2 && this.cho.adf().size() != 0 && this.cho.adf().size() % this.cho.adh() == 0) {
            return currentPage + 1;
        }
        if (this.aRr == 3 && this.chT) {
            return this.cho.add() - 1;
        }
        if (this.aRr == 3 && currentPage > 0) {
            return this.cho.adc() - 1;
        }
        return currentPage;
    }

    private SubPbRequestMessage afH() {
        this.axc = true;
        return d((Integer) null);
    }

    private SubPbRequestMessage d(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m411getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m411getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.aRr) {
            j = Long.parseLong(this.postID);
        } else {
            j2 = Long.parseLong(this.postID);
        }
        if (num == null) {
            intValue = afG();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.chT && this.aRr == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, K, L, f, this.stType, i2);
        subPbRequestMessage.setNetType(NetMessage.NetType.HTTP);
        subPbRequestMessage.setNetType(NetMessage.NetType.HTTP);
        return subPbRequestMessage;
    }

    public boolean Df() {
        return iO(0);
    }

    public boolean afI() {
        return iO(2);
    }

    public void afJ() {
        int adh;
        if (this.chP > 0 && this.cho != null && (adh = this.cho.adh()) > 0) {
            int currentPage = this.cho.getCurrentPage();
            for (int i = (((this.chP + adh) - 1) / adh) - 1; i >= 0; i--) {
                this.chU = d(Integer.valueOf(currentPage - i));
                this.chU.setTreatDelPage(true);
                sendMessage(this.chU);
            }
        }
        this.chP = 0;
    }

    public boolean afK() {
        return iO(1);
    }

    public boolean afL() {
        return iO(3);
    }

    public boolean iO(int i) {
        if (this.axc) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.axc = false;
            return false;
        }
        afJ();
        this.aRr = i;
        this.chU = afH();
        sendMessage(this.chU);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.a.c cVar) {
        ArrayList<com.baidu.tieba.tbadkCore.data.i> adf = cVar.adf();
        if (adf == null || adf.size() == 0) {
            cVar.setCurrentPage(this.cho.getCurrentPage());
        }
        if (this.aRr == 1) {
            this.cho = cVar;
        } else if (this.aRr == 2) {
            this.cho.b(cVar, true);
        } else if (this.aRr == 3) {
            this.cho.a(cVar, false);
        } else {
            this.cho.b(cVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.a.c cVar) {
        if (this.aRr == 1) {
            this.cho = cVar;
            this.cho.ade();
        } else if (this.aRr == 2) {
            this.cho.c(cVar, true);
        } else if (this.aRr == 3) {
            this.cho.d(cVar, false);
        } else {
            this.cho.a(cVar);
        }
    }

    public void e(com.baidu.tieba.pb.a.c cVar) {
        String str;
        if (cVar.adk() == null || cVar.adk().getAuthor() == null) {
            str = null;
        } else {
            str = cVar.adk().getAuthor().getUserId();
        }
        if (!this.chT) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= cVar.adf().size()) {
                    break;
                }
                cVar.adf().get(i2).a(this.mContext.getUniqueId(), str.equals(cVar.adf().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.chR.add(cVar);
    }

    public boolean afc() {
        return this.chJ;
    }

    public String afM() {
        return this.chK;
    }

    public boolean isMarked() {
        return this.cbk;
    }

    public void eN(boolean z) {
        this.cbk = z;
    }

    public int acU() {
        return this.caV;
    }

    public String afN() {
        return this.chN;
    }

    public void jC(String str) {
        this.chN = str;
    }

    public boolean afO() {
        return this.chM;
    }

    public String afP() {
        return this.chL;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public WriteData eQ(String str) {
        if (this.cho == null || this.cho.adi() == null || this.cho.adk() == null || this.cho.adb() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.cho.adi().getName());
        writeData.setForumId(this.cho.adi().getId());
        writeData.setFloor(this.cho.adb().getId());
        writeData.setType(2);
        writeData.setThreadId(this.cho.adk().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public boolean Bx() {
        return afI();
    }

    public void eO(boolean z) {
        this.chT = z;
    }

    public SmallTailInfo afQ() {
        return this.chS;
    }
}
