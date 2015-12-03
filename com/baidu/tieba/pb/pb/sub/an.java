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
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class an extends com.baidu.tbadk.editortools.d.a {
    private static BdAsyncTaskParallel cIb = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private com.baidu.tieba.tbadkCore.d.a aRc;
    private int aVJ;
    private boolean awu;
    private boolean cHT;
    private String cHU;
    private String cHV;
    private boolean cHW;
    private String cHX;
    private a cHY;
    private int cHZ;
    private com.baidu.tieba.pb.a.d cHy;
    private boolean cIa;
    private ArrayList<com.baidu.tieba.pb.a.d> cIc;
    private SmallTailInfo cId;
    private boolean cIe;
    private SubPbRequestMessage cIf;
    private com.baidu.adp.framework.listener.a cIg;
    private AntiData czB;
    private boolean czC;
    private int czm;
    private TbPageContext<?> mContext;
    private String postID;
    private String stType;
    private String threadID;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, String str, com.baidu.tieba.pb.a.d dVar);
    }

    static {
        com.baidu.tbadk.task.b a2 = com.baidu.tieba.tbadkCore.a.a.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a3 = com.baidu.tieba.tbadkCore.a.a.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a2.setParallel(cIb);
        a3.setParallel(cIb);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.cHT = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.cHU = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.cHW = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.cHV = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.czm = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.cId = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.cId != null) {
                this.cId.updateShowInfo();
            }
            this.czB = (AntiData) intent.getSerializableExtra("anti");
            this.cIa = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.cHT = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.cHU = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.cHW = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.cHV = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.czm = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.cId = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.cId != null) {
                this.cId.updateShowInfo();
            }
            this.czB = (AntiData) bundle.getSerializable("anti");
            this.cIa = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void saveToBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.cHT);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.cHU);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.cHV);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.cHW);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.czm);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.cId);
            bundle.putSerializable("anti", this.czB);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public an(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aVJ = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.cHT = false;
        this.cHU = null;
        this.cHV = null;
        this.cHW = false;
        this.czC = false;
        this.czm = 0;
        this.cHX = null;
        this.mContext = null;
        this.cHy = null;
        this.cHY = null;
        this.cHZ = 0;
        this.cIa = false;
        this.cIc = null;
        this.awu = false;
        this.aRc = null;
        this.cIg = new ao(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.mContext = tbPageContext;
        this.cIc = new ArrayList<>();
        this.cHy = new com.baidu.tieba.pb.a.d();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.cIg);
        registerListener(this.cIg);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String BU() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.a.d amF() {
        return this.cHy;
    }

    public AntiData ajS() {
        return this.czB;
    }

    public boolean amG() {
        return (this.cHy == null || this.cHy.ajK() == null) ? false : true;
    }

    public void a(a aVar) {
        this.cHY = aVar;
    }

    public MarkData d(com.baidu.tieba.tbadkCore.data.o oVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(oVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(oVar.aDd());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.cIg);
        Kg();
    }

    private void Kg() {
        if (this.aRc != null) {
            this.aRc.destory();
            this.aRc = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int amH() {
        return this.aVJ;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void kQ(String str) {
        if (!TextUtils.isEmpty(str) && this.cHy != null && this.cHy.ajO() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.o> ajO = this.cHy.ajO();
            int size = ajO.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(ajO.get(i).getId())) {
                    ajO.remove(i);
                    this.cHZ++;
                    this.cHy.setTotalCount(this.cHy.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int amI() {
        int currentPage = this.cHy.getCurrentPage();
        if (currentPage == 0) {
            return currentPage + 1;
        }
        if (this.aVJ == 0) {
            return currentPage + 1;
        }
        if (this.aVJ == 2 && this.cHy.ajO().size() != 0 && this.cHy.ajO().size() % this.cHy.ajQ() == 0) {
            return currentPage + 1;
        }
        if (this.aVJ == 3 && this.cIe) {
            return this.cHy.ajM() - 1;
        }
        if (this.aVJ == 3 && currentPage > 0) {
            return this.cHy.ajL() - 1;
        }
        return currentPage;
    }

    private SubPbRequestMessage amJ() {
        this.awu = true;
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
        if (1 != this.aVJ) {
            j = Long.parseLong(this.postID);
        } else {
            j2 = Long.parseLong(this.postID);
        }
        if (num == null) {
            intValue = amI();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.cIe && this.aVJ == 0) {
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

    public boolean DJ() {
        return kg(0);
    }

    public boolean amK() {
        return kg(2);
    }

    public void amL() {
        int ajQ;
        if (this.cHZ > 0 && this.cHy != null && (ajQ = this.cHy.ajQ()) > 0) {
            int currentPage = this.cHy.getCurrentPage();
            for (int i = (((this.cHZ + ajQ) - 1) / ajQ) - 1; i >= 0; i--) {
                this.cIf = d(Integer.valueOf(currentPage - i));
                this.cIf.setTreatDelPage(true);
                sendMessage(this.cIf);
            }
        }
        this.cHZ = 0;
    }

    public boolean amM() {
        return kg(1);
    }

    public boolean amN() {
        return kg(3);
    }

    public boolean kg(int i) {
        if (this.awu) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.awu = false;
            return false;
        }
        amL();
        this.aVJ = i;
        this.cIf = amJ();
        sendMessage(this.cIf);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.a.d dVar) {
        ArrayList<com.baidu.tieba.tbadkCore.data.o> ajO = dVar.ajO();
        if (ajO == null || ajO.size() == 0) {
            dVar.setCurrentPage(this.cHy.getCurrentPage());
        }
        if (this.aVJ == 1) {
            this.cHy = dVar;
        } else if (this.aVJ == 2) {
            this.cHy.b(dVar, true);
        } else if (this.aVJ == 3) {
            this.cHy.a(dVar, false);
        } else {
            this.cHy.b(dVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.a.d dVar) {
        if (this.aVJ == 1) {
            this.cHy = dVar;
            this.cHy.ajN();
        } else if (this.aVJ == 2) {
            this.cHy.c(dVar, true);
        } else if (this.aVJ == 3) {
            this.cHy.d(dVar, false);
        } else {
            this.cHy.a(dVar);
        }
    }

    public void e(com.baidu.tieba.pb.a.d dVar) {
        String str;
        if (dVar.ajT() == null || dVar.ajT().getAuthor() == null) {
            str = null;
        } else {
            str = dVar.ajT().getAuthor().getUserId();
        }
        if (!this.cIe) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dVar.ajO().size()) {
                    break;
                }
                dVar.ajO().get(i2).a(this.mContext.getUniqueId(), str.equals(dVar.ajO().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.cIc.add(dVar);
    }

    public boolean amg() {
        return this.cHT;
    }

    public String amO() {
        return this.cHU;
    }

    public boolean isMarked() {
        return this.czC;
    }

    public boolean amP() {
        return HotTopicActivityConfig.ST_TYPE.equals(getStType());
    }

    public void fz(boolean z) {
        this.czC = z;
    }

    public int ajD() {
        return this.czm;
    }

    public String amQ() {
        return this.cHX;
    }

    public void kR(String str) {
        this.cHX = str;
    }

    public boolean amR() {
        return this.cHW;
    }

    public String amS() {
        return this.cHV;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fl(String str) {
        if (this.cHy == null || this.cHy.ajR() == null || this.cHy.ajT() == null || this.cHy.ajK() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.cHy.ajR().getName());
        writeData.setForumId(this.cHy.ajR().getId());
        writeData.setFloor(this.cHy.ajK().getId());
        writeData.setType(2);
        writeData.setThreadId(this.cHy.ajT().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public boolean BT() {
        return amK();
    }

    public boolean isFromPhotoLive() {
        return this.cIe;
    }

    public void fA(boolean z) {
        this.cIe = z;
    }

    public SmallTailInfo amT() {
        return this.cId;
    }

    public boolean amU() {
        return this.cIa;
    }
}
