package com.baidu.tieba.pb.pb.sub;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class ax extends com.baidu.tbadk.editortools.e.a {
    private static BdAsyncTaskParallel eyS = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private TbPageContext<?> Gd;
    private boolean azO;
    private com.baidu.tieba.tbadkCore.d.b bHA;
    private int bMk;
    private AntiData emG;
    private boolean emH;
    private int emc;
    private boolean eyJ;
    private String eyK;
    private String eyL;
    private boolean eyM;
    private String eyN;
    private a eyO;
    private int eyP;
    private ArrayList<IconData> eyQ;
    private boolean eyR;
    private ArrayList<com.baidu.tieba.pb.data.n> eyT;
    private SmallTailInfo eyU;
    private boolean eyV;
    private ArrayList<String> eyW;
    private ConcurrentHashMap<String, ImageUrlData> eyX;
    private boolean eyY;
    private SubPbRequestMessage eyZ;
    private com.baidu.tieba.pb.data.n eyl;
    private com.baidu.adp.framework.listener.a eza;
    private int mOffset;
    private String postID;
    private String stType;
    private String threadID;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, String str, com.baidu.tieba.pb.data.n nVar);
    }

    static {
        com.baidu.tbadk.task.b a2 = com.baidu.tieba.tbadkCore.a.a.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a3 = com.baidu.tieba.tbadkCore.a.a.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a2.setParallel(eyS);
        a3.setParallel(eyS);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.eyJ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eyK = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eyM = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eyL = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.emc = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.eyU = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.eyU != null) {
                this.eyU.updateShowInfo();
            }
            this.emG = (AntiData) intent.getSerializableExtra("anti");
            this.eyQ = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.eyR = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.eyX = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.eyX.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.eyW = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.eyY = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.eyJ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eyK = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eyM = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eyL = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.emc = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.eyU = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.eyU != null) {
                this.eyU.updateShowInfo();
            }
            this.emG = (AntiData) bundle.getSerializable("anti");
            this.eyQ = (ArrayList) bundle.getSerializable(SubPbActivityConfig.ICON_LIST);
            this.eyR = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void n(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.eyJ);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.eyK);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.eyL);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.eyM);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.emc);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.eyU);
            bundle.putSerializable("anti", this.emG);
            bundle.putSerializable(SubPbActivityConfig.ICON_LIST, this.eyQ);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public ax(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bMk = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.eyJ = false;
        this.eyK = null;
        this.eyL = null;
        this.eyM = false;
        this.emH = false;
        this.emc = 0;
        this.eyN = null;
        this.Gd = null;
        this.eyl = null;
        this.eyO = null;
        this.eyP = 0;
        this.eyR = false;
        this.eyT = null;
        this.azO = false;
        this.bHA = null;
        this.eyY = true;
        this.mOffset = 0;
        this.eza = new ay(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.Gd = tbPageContext;
        this.eyT = new ArrayList<>();
        this.eyl = new com.baidu.tieba.pb.data.n();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.eza);
        registerListener(this.eza);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public String Dg() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.data.n aRs() {
        return this.eyl;
    }

    public AntiData getAntiData() {
        return this.emG;
    }

    public boolean aRt() {
        return (this.eyl == null || this.eyl.aMN() == null) ? false : true;
    }

    public void a(a aVar) {
        this.eyO = aVar;
    }

    public MarkData e(com.baidu.tieba.tbadkCore.data.q qVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(qVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(qVar.bjO());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.eza);
        Yh();
    }

    private void Yh() {
        if (this.bHA != null) {
            this.bHA.destory();
            this.bHA = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int getLoadType() {
        return this.bMk;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void pA(String str) {
        if (!TextUtils.isEmpty(str) && this.eyl != null && this.eyl.aMR() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aMR = this.eyl.aMR();
            int size = aMR.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aMR.get(i).getId())) {
                    aMR.remove(i);
                    this.eyP++;
                    this.eyl.setTotalCount(this.eyl.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aRu() {
        int mf = this.eyl.mf();
        if (mf == 0) {
            return mf + 1;
        }
        if (this.bMk == 0) {
            return mf + 1;
        }
        if (this.bMk == 2 && this.eyl.aMR().size() != 0 && this.eyl.aMR().size() % this.eyl.aMS() == 0) {
            return mf + 1;
        }
        if (this.bMk == 3 && this.eyV) {
            return this.eyl.aMP() - 1;
        }
        if (this.bMk == 3 && mf > 0) {
            return this.eyl.aMO() - 1;
        }
        return mf;
    }

    private SubPbRequestMessage aRv() {
        this.azO = true;
        return f((Integer) null);
    }

    private SubPbRequestMessage f(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int K = com.baidu.adp.lib.util.k.K(TbadkCoreApplication.m9getInst().getApp());
        int L = com.baidu.adp.lib.util.k.L(TbadkCoreApplication.m9getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.bMk) {
            j = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = aRu();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.eyV && this.bMk == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.Gd.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, K, L, f, this.stType, i2);
    }

    public boolean Fa() {
        return oF(0);
    }

    public boolean aRw() {
        return oF(2);
    }

    public void aRx() {
        int aMS;
        if (this.eyP > 0 && this.eyl != null && (aMS = this.eyl.aMS()) > 0) {
            int mf = this.eyl.mf();
            for (int i = (((this.eyP + aMS) - 1) / aMS) - 1; i >= 0; i--) {
                this.eyZ = f(Integer.valueOf(mf - i));
                this.eyZ.setTreatDelPage(true);
                sendMessage(this.eyZ);
            }
        }
        this.eyP = 0;
    }

    public boolean aRy() {
        return oF(1);
    }

    public boolean aRz() {
        return oF(3);
    }

    public boolean oF(int i) {
        if (this.azO) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.azO = false;
            return false;
        }
        aRx();
        this.bMk = i;
        this.eyZ = aRv();
        sendMessage(this.eyZ);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.data.n nVar) {
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aMR = nVar.aMR();
        if (aMR == null || aMR.size() == 0) {
            nVar.aW(this.eyl.mf());
        }
        if (this.bMk == 1) {
            this.eyl = nVar;
        } else if (this.bMk == 2) {
            this.eyl.b(nVar, true);
        } else if (this.bMk == 3) {
            this.eyl.a(nVar, false);
        } else {
            this.eyl.b(nVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.data.n nVar) {
        if (this.bMk == 1) {
            this.eyl = nVar;
            this.eyl.aMQ();
        } else if (this.bMk == 2) {
            this.eyl.c(nVar, true);
        } else if (this.bMk == 3) {
            this.eyl.d(nVar, false);
        } else {
            this.eyl.a(nVar);
        }
    }

    public void e(com.baidu.tieba.pb.data.n nVar) {
        String str;
        if (nVar.Jv() == null || nVar.Jv().getAuthor() == null) {
            str = null;
        } else {
            str = nVar.Jv().getAuthor().getUserId();
        }
        if (!this.eyV) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= nVar.aMR().size()) {
                    break;
                }
                nVar.aMR().get(i2).c(this.Gd, str.equals(nVar.aMR().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.eyT.add(nVar);
    }

    public boolean aQU() {
        return this.eyJ;
    }

    public String aRA() {
        return this.eyK;
    }

    public boolean isMarked() {
        return this.emH;
    }

    public boolean aRB() {
        return "hot_topic".equals(getStType());
    }

    public void iq(boolean z) {
        this.emH = z;
    }

    public int aMz() {
        return this.emc;
    }

    public String aRC() {
        return this.eyN;
    }

    public void pB(String str) {
        this.eyN = str;
    }

    public boolean aRD() {
        return this.eyM;
    }

    public String aRE() {
        return this.eyL;
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public WriteData fC(String str) {
        if (this.eyl == null || this.eyl.aMT() == null || this.eyl.Jv() == null || this.eyl.aMN() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.eyl.aMT().getName());
        writeData.setForumId(this.eyl.aMT().getId());
        writeData.setFloor(this.eyl.aMN().getId());
        writeData.setType(2);
        writeData.setThreadId(this.eyl.Jv().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public boolean Df() {
        return aRw();
    }

    public boolean aRF() {
        return this.eyV;
    }

    public void iK(boolean z) {
        this.eyV = z;
    }

    public SmallTailInfo aRG() {
        return this.eyU;
    }

    public boolean aRH() {
        return this.eyR;
    }

    public ConcurrentHashMap<String, ImageUrlData> aRI() {
        return this.eyX;
    }

    public ArrayList<String> aRJ() {
        return this.eyW;
    }

    public boolean aRK() {
        return this.eyY;
    }

    public int getOffset() {
        return this.mOffset;
    }
}
