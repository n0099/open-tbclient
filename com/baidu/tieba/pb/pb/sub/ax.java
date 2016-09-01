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
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class ax extends com.baidu.tbadk.editortools.d.a {
    private static BdAsyncTaskParallel ewK = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private TbPageContext<?> Gd;
    private boolean aAl;
    private com.baidu.tieba.tbadkCore.d.b bHt;
    private int bMj;
    private AntiData ekE;
    private boolean ekF;
    private int eke;
    private boolean ewB;
    private String ewC;
    private String ewD;
    private boolean ewE;
    private String ewF;
    private a ewG;
    private int ewH;
    private ArrayList<IconData> ewI;
    private boolean ewJ;
    private ArrayList<com.baidu.tieba.pb.data.m> ewL;
    private SmallTailInfo ewM;
    private boolean ewN;
    private ArrayList<String> ewO;
    private ConcurrentHashMap<String, ImageUrlData> ewP;
    private boolean ewQ;
    private SubPbRequestMessage ewR;
    private com.baidu.adp.framework.listener.a ewS;
    private com.baidu.tieba.pb.data.m ewe;
    private int mOffset;
    private String postID;
    private String stType;
    private String threadID;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, String str, com.baidu.tieba.pb.data.m mVar);
    }

    static {
        com.baidu.tbadk.task.b a2 = com.baidu.tieba.tbadkCore.a.a.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a3 = com.baidu.tieba.tbadkCore.a.a.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a2.setParallel(ewK);
        a3.setParallel(ewK);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.ewB = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.ewC = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.ewE = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.ewD = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eke = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.ewM = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.ewM != null) {
                this.ewM.updateShowInfo();
            }
            this.ekE = (AntiData) intent.getSerializableExtra("anti");
            this.ewI = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.ewJ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.ewP = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.ewP.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.ewO = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.ewQ = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.ewB = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.ewC = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.ewE = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.ewD = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eke = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.ewM = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.ewM != null) {
                this.ewM.updateShowInfo();
            }
            this.ekE = (AntiData) bundle.getSerializable("anti");
            this.ewI = (ArrayList) bundle.getSerializable(SubPbActivityConfig.ICON_LIST);
            this.ewJ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void n(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.ewB);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.ewC);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.ewD);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.ewE);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.eke);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.ewM);
            bundle.putSerializable("anti", this.ekE);
            bundle.putSerializable(SubPbActivityConfig.ICON_LIST, this.ewI);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public ax(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bMj = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.ewB = false;
        this.ewC = null;
        this.ewD = null;
        this.ewE = false;
        this.ekF = false;
        this.eke = 0;
        this.ewF = null;
        this.Gd = null;
        this.ewe = null;
        this.ewG = null;
        this.ewH = 0;
        this.ewJ = false;
        this.ewL = null;
        this.aAl = false;
        this.bHt = null;
        this.ewQ = true;
        this.mOffset = 0;
        this.ewS = new ay(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.Gd = tbPageContext;
        this.ewL = new ArrayList<>();
        this.ewe = new com.baidu.tieba.pb.data.m();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.ewS);
        registerListener(this.ewS);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String Dg() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.data.m aQK() {
        return this.ewe;
    }

    public AntiData getAntiData() {
        return this.ekE;
    }

    public boolean aQL() {
        return (this.ewe == null || this.ewe.aMh() == null) ? false : true;
    }

    public void a(a aVar) {
        this.ewG = aVar;
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
        markData.setFloor(qVar.bjc());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.ewS);
        XO();
    }

    private void XO() {
        if (this.bHt != null) {
            this.bHt.destory();
            this.bHt = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int getLoadType() {
        return this.bMj;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void pk(String str) {
        if (!TextUtils.isEmpty(str) && this.ewe != null && this.ewe.aMl() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aMl = this.ewe.aMl();
            int size = aMl.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aMl.get(i).getId())) {
                    aMl.remove(i);
                    this.ewH++;
                    this.ewe.setTotalCount(this.ewe.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aQM() {
        int mf = this.ewe.mf();
        if (mf == 0) {
            return mf + 1;
        }
        if (this.bMj == 0) {
            return mf + 1;
        }
        if (this.bMj == 2 && this.ewe.aMl().size() != 0 && this.ewe.aMl().size() % this.ewe.aMm() == 0) {
            return mf + 1;
        }
        if (this.bMj == 3 && this.ewN) {
            return this.ewe.aMj() - 1;
        }
        if (this.bMj == 3 && mf > 0) {
            return this.ewe.aMi() - 1;
        }
        return mf;
    }

    private SubPbRequestMessage aQN() {
        this.aAl = true;
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
        if (1 != this.bMj) {
            j = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = aQM();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.ewN && this.bMj == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.Gd.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, K, L, f, this.stType, i2);
    }

    public boolean Fa() {
        return ov(0);
    }

    public boolean aQO() {
        return ov(2);
    }

    public void aQP() {
        int aMm;
        if (this.ewH > 0 && this.ewe != null && (aMm = this.ewe.aMm()) > 0) {
            int mf = this.ewe.mf();
            for (int i = (((this.ewH + aMm) - 1) / aMm) - 1; i >= 0; i--) {
                this.ewR = f(Integer.valueOf(mf - i));
                this.ewR.setTreatDelPage(true);
                sendMessage(this.ewR);
            }
        }
        this.ewH = 0;
    }

    public boolean aQQ() {
        return ov(1);
    }

    public boolean aQR() {
        return ov(3);
    }

    public boolean ov(int i) {
        if (this.aAl) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.aAl = false;
            return false;
        }
        aQP();
        this.bMj = i;
        this.ewR = aQN();
        sendMessage(this.ewR);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.data.m mVar) {
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aMl = mVar.aMl();
        if (aMl == null || aMl.size() == 0) {
            mVar.aW(this.ewe.mf());
        }
        if (this.bMj == 1) {
            this.ewe = mVar;
        } else if (this.bMj == 2) {
            this.ewe.b(mVar, true);
        } else if (this.bMj == 3) {
            this.ewe.a(mVar, false);
        } else {
            this.ewe.b(mVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.data.m mVar) {
        if (this.bMj == 1) {
            this.ewe = mVar;
            this.ewe.aMk();
        } else if (this.bMj == 2) {
            this.ewe.c(mVar, true);
        } else if (this.bMj == 3) {
            this.ewe.d(mVar, false);
        } else {
            this.ewe.a(mVar);
        }
    }

    public void e(com.baidu.tieba.pb.data.m mVar) {
        String str;
        if (mVar.Kw() == null || mVar.Kw().getAuthor() == null) {
            str = null;
        } else {
            str = mVar.Kw().getAuthor().getUserId();
        }
        if (!this.ewN) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mVar.aMl().size()) {
                    break;
                }
                mVar.aMl().get(i2).c(this.Gd, str.equals(mVar.aMl().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.ewL.add(mVar);
    }

    public boolean aQl() {
        return this.ewB;
    }

    public String aQS() {
        return this.ewC;
    }

    public boolean isMarked() {
        return this.ekF;
    }

    public boolean aQT() {
        return HotTopicActivityConfig.ST_TYPE.equals(getStType());
    }

    public void in(boolean z) {
        this.ekF = z;
    }

    public int aLX() {
        return this.eke;
    }

    public String aQU() {
        return this.ewF;
    }

    public void pl(String str) {
        this.ewF = str;
    }

    public boolean aQV() {
        return this.ewE;
    }

    public String aQW() {
        return this.ewD;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fz(String str) {
        if (this.ewe == null || this.ewe.aMn() == null || this.ewe.Kw() == null || this.ewe.aMh() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.ewe.aMn().getName());
        writeData.setForumId(this.ewe.aMn().getId());
        writeData.setFloor(this.ewe.aMh().getId());
        writeData.setType(2);
        writeData.setThreadId(this.ewe.Kw().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public boolean Df() {
        return aQO();
    }

    public boolean aQX() {
        return this.ewN;
    }

    public void iH(boolean z) {
        this.ewN = z;
    }

    public SmallTailInfo aQY() {
        return this.ewM;
    }

    public boolean aQZ() {
        return this.ewJ;
    }

    public ConcurrentHashMap<String, ImageUrlData> aRa() {
        return this.ewP;
    }

    public ArrayList<String> aRb() {
        return this.ewO;
    }

    public boolean aRc() {
        return this.ewQ;
    }

    public int getOffset() {
        return this.mOffset;
    }
}
