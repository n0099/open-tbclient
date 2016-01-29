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
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class ao extends com.baidu.tbadk.editortools.d.a {
    private static BdAsyncTaskParallel cUL = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private TbPageContext<?> MR;
    private com.baidu.tieba.tbadkCore.d.b aXf;
    private boolean ayQ;
    private int bbY;
    private AntiData cJM;
    private boolean cJN;
    private int cJx;
    private boolean cUD;
    private String cUE;
    private String cUF;
    private boolean cUG;
    private String cUH;
    private a cUI;
    private int cUJ;
    private boolean cUK;
    private ArrayList<com.baidu.tieba.pb.a.d> cUM;
    private SmallTailInfo cUN;
    private boolean cUO;
    private ArrayList<String> cUP;
    private ConcurrentHashMap<String, ImageUrlData> cUQ;
    private boolean cUR;
    private SubPbRequestMessage cUS;
    private com.baidu.adp.framework.listener.a cUT;
    private com.baidu.tieba.pb.a.d cUj;
    private int mOffset;
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
        a2.setParallel(cUL);
        a3.setParallel(cUL);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.cUD = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.cUE = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.cUG = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.cUF = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.cJx = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.cUN = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.cUN != null) {
                this.cUN.updateShowInfo();
            }
            this.cJM = (AntiData) intent.getSerializableExtra("anti");
            this.cUK = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.cUQ = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.cUQ.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.cUP = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.cUR = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.cUD = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.cUE = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.cUG = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.cUF = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.cJx = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.cUN = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.cUN != null) {
                this.cUN.updateShowInfo();
            }
            this.cJM = (AntiData) bundle.getSerializable("anti");
            this.cUK = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void m(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.cUD);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.cUE);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.cUF);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.cUG);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.cJx);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.cUN);
            bundle.putSerializable("anti", this.cJM);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public ao(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bbY = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.cUD = false;
        this.cUE = null;
        this.cUF = null;
        this.cUG = false;
        this.cJN = false;
        this.cJx = 0;
        this.cUH = null;
        this.MR = null;
        this.cUj = null;
        this.cUI = null;
        this.cUJ = 0;
        this.cUK = false;
        this.cUM = null;
        this.ayQ = false;
        this.aXf = null;
        this.cUR = true;
        this.mOffset = 0;
        this.cUT = new ap(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.MR = tbPageContext;
        this.cUM = new ArrayList<>();
        this.cUj = new com.baidu.tieba.pb.a.d();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.cUT);
        registerListener(this.cUT);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String CZ() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.a.d asw() {
        return this.cUj;
    }

    public AntiData ajb() {
        return this.cJM;
    }

    public boolean asx() {
        return (this.cUj == null || this.cUj.aoQ() == null) ? false : true;
    }

    public void a(a aVar) {
        this.cUI = aVar;
    }

    public MarkData e(com.baidu.tieba.tbadkCore.data.r rVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(rVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(rVar.aMw());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.cUT);
        Mq();
    }

    private void Mq() {
        if (this.aXf != null) {
            this.aXf.destory();
            this.aXf = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int getLoadType() {
        return this.bbY;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void kU(String str) {
        if (!TextUtils.isEmpty(str) && this.cUj != null && this.cUj.aoU() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.r> aoU = this.cUj.aoU();
            int size = aoU.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aoU.get(i).getId())) {
                    aoU.remove(i);
                    this.cUJ++;
                    this.cUj.setTotalCount(this.cUj.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int asy() {
        int pf = this.cUj.pf();
        if (pf == 0) {
            return pf + 1;
        }
        if (this.bbY == 0) {
            return pf + 1;
        }
        if (this.bbY == 2 && this.cUj.aoU().size() != 0 && this.cUj.aoU().size() % this.cUj.aoW() == 0) {
            return pf + 1;
        }
        if (this.bbY == 3 && this.cUO) {
            return this.cUj.aoS() - 1;
        }
        if (this.bbY == 3 && pf > 0) {
            return this.cUj.aoR() - 1;
        }
        return pf;
    }

    private SubPbRequestMessage asz() {
        this.ayQ = true;
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
        if (1 != this.bbY) {
            j = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = asy();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.cUO && this.bbY == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.MR.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, K, L, f, this.stType, i2);
    }

    public boolean ET() {
        return lh(0);
    }

    public boolean asA() {
        return lh(2);
    }

    public void asB() {
        int aoW;
        if (this.cUJ > 0 && this.cUj != null && (aoW = this.cUj.aoW()) > 0) {
            int pf = this.cUj.pf();
            for (int i = (((this.cUJ + aoW) - 1) / aoW) - 1; i >= 0; i--) {
                this.cUS = d(Integer.valueOf(pf - i));
                this.cUS.setTreatDelPage(true);
                sendMessage(this.cUS);
            }
        }
        this.cUJ = 0;
    }

    public boolean asC() {
        return lh(1);
    }

    public boolean asD() {
        return lh(3);
    }

    public boolean lh(int i) {
        if (this.ayQ) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.ayQ = false;
            return false;
        }
        asB();
        this.bbY = i;
        this.cUS = asz();
        sendMessage(this.cUS);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.a.d dVar) {
        ArrayList<com.baidu.tieba.tbadkCore.data.r> aoU = dVar.aoU();
        if (aoU == null || aoU.size() == 0) {
            dVar.setCurrentPage(this.cUj.pf());
        }
        if (this.bbY == 1) {
            this.cUj = dVar;
        } else if (this.bbY == 2) {
            this.cUj.b(dVar, true);
        } else if (this.bbY == 3) {
            this.cUj.a(dVar, false);
        } else {
            this.cUj.b(dVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.a.d dVar) {
        if (this.bbY == 1) {
            this.cUj = dVar;
            this.cUj.aoT();
        } else if (this.bbY == 2) {
            this.cUj.c(dVar, true);
        } else if (this.bbY == 3) {
            this.cUj.d(dVar, false);
        } else {
            this.cUj.a(dVar);
        }
    }

    public void e(com.baidu.tieba.pb.a.d dVar) {
        String str;
        if (dVar.Ki() == null || dVar.Ki().getAuthor() == null) {
            str = null;
        } else {
            str = dVar.Ki().getAuthor().getUserId();
        }
        if (!this.cUO) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dVar.aoU().size()) {
                    break;
                }
                dVar.aoU().get(i2).a(this.MR.getUniqueId(), str.equals(dVar.aoU().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.cUM.add(dVar);
    }

    public boolean arS() {
        return this.cUD;
    }

    public String asE() {
        return this.cUE;
    }

    public boolean isMarked() {
        return this.cJN;
    }

    public boolean asF() {
        return HotTopicActivityConfig.ST_TYPE.equals(getStType());
    }

    public void fA(boolean z) {
        this.cJN = z;
    }

    public int aoJ() {
        return this.cJx;
    }

    public String asG() {
        return this.cUH;
    }

    public void kV(String str) {
        this.cUH = str;
    }

    public boolean asH() {
        return this.cUG;
    }

    public String asI() {
        return this.cUF;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fn(String str) {
        if (this.cUj == null || this.cUj.aoX() == null || this.cUj.Ki() == null || this.cUj.aoQ() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.cUj.aoX().getName());
        writeData.setForumId(this.cUj.aoX().getId());
        writeData.setFloor(this.cUj.aoQ().getId());
        writeData.setType(2);
        writeData.setThreadId(this.cUj.Ki().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public boolean CY() {
        return asA();
    }

    public boolean asJ() {
        return this.cUO;
    }

    public void fN(boolean z) {
        this.cUO = z;
    }

    public SmallTailInfo asK() {
        return this.cUN;
    }

    public boolean asL() {
        return this.cUK;
    }

    public ConcurrentHashMap<String, ImageUrlData> asM() {
        return this.cUQ;
    }

    public ArrayList<String> asN() {
        return this.cUP;
    }

    public boolean asO() {
        return this.cUR;
    }

    public int getOffset() {
        return this.mOffset;
    }
}
