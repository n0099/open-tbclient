package com.baidu.tieba.pb.pb.sub;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
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
import com.baidu.tieba.pb.pb.main.view.c;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class bc extends com.baidu.tbadk.editortools.e.a {
    private TbPageContext<?> Gf;
    private boolean aAG;
    private com.baidu.tieba.tbadkCore.d.b bKu;
    private int bPd;
    private com.baidu.adp.framework.listener.a bWB;
    private com.baidu.tieba.pb.data.n eDA;
    private c.a eDD;
    private a eFA;
    private int eFB;
    private ArrayList<IconData> eFC;
    private boolean eFD;
    private ArrayList<com.baidu.tieba.pb.data.n> eFE;
    private SmallTailInfo eFF;
    private boolean eFG;
    private ArrayList<String> eFH;
    private ConcurrentHashMap<String, ImageUrlData> eFI;
    private boolean eFJ;
    private boolean eFK;
    private SubPbRequestMessage eFL;
    private boolean eFv;
    private String eFw;
    private String eFx;
    private boolean eFy;
    private String eFz;
    private int erZ;
    private AntiData esD;
    private boolean esE;
    private com.baidu.tieba.pb.pb.main.view.c ewJ;
    private int mOffset;
    private String postID;
    private String stType;
    private String threadID;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, String str, com.baidu.tieba.pb.data.n nVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.eFv = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eFw = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eFy = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eFx = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.erZ = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.eFF = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.eFF != null) {
                this.eFF.updateShowInfo();
            }
            this.esD = (AntiData) intent.getSerializableExtra("anti");
            this.eFC = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.eFD = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.eFI = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.eFI.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.eFH = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.eFJ = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.eFv = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eFw = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eFy = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eFx = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.erZ = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.eFF = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.eFF != null) {
                this.eFF.updateShowInfo();
            }
            this.esD = (AntiData) bundle.getSerializable("anti");
            this.eFC = (ArrayList) bundle.getSerializable(SubPbActivityConfig.ICON_LIST);
            this.eFD = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void n(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.eFv);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.eFw);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.eFx);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.eFy);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.erZ);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.eFF);
            bundle.putSerializable("anti", this.esD);
            bundle.putSerializable(SubPbActivityConfig.ICON_LIST, this.eFC);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public bc(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bPd = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.eFv = false;
        this.eFw = null;
        this.eFx = null;
        this.eFy = false;
        this.esE = false;
        this.erZ = 0;
        this.eFz = null;
        this.Gf = null;
        this.eDA = null;
        this.eFA = null;
        this.eFB = 0;
        this.eFD = false;
        this.eFE = null;
        this.aAG = false;
        this.bKu = null;
        this.eFJ = true;
        this.mOffset = 0;
        this.ewJ = null;
        this.eDD = null;
        this.eFK = false;
        this.bWB = new bd(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.Gf = tbPageContext;
        this.eFE = new ArrayList<>();
        this.eDA = new com.baidu.tieba.pb.data.n();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.bWB);
        registerListener(this.bWB);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public String Do() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.data.n aTA() {
        return this.eDA;
    }

    public AntiData getAntiData() {
        return this.esD;
    }

    public boolean aTB() {
        return (this.eDA == null || this.eDA.aOG() == null) ? false : true;
    }

    public void a(a aVar) {
        this.eFA = aVar;
    }

    public MarkData f(com.baidu.tieba.tbadkCore.data.q qVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(qVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(qVar.bml());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.bWB);
        if (this.ewJ != null) {
            this.ewJ.unRegisterListener();
        }
        Zj();
    }

    private void Zj() {
        if (this.bKu != null) {
            this.bKu.destory();
            this.bKu = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int getLoadType() {
        return this.bPd;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void pN(String str) {
        if (!TextUtils.isEmpty(str) && this.eDA != null && this.eDA.aOK() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aOK = this.eDA.aOK();
            int size = aOK.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aOK.get(i).getId())) {
                    aOK.remove(i);
                    this.eFB++;
                    this.eDA.setTotalCount(this.eDA.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aTC() {
        int mi = this.eDA.mi();
        if (mi == 0) {
            return mi + 1;
        }
        if (this.bPd == 0) {
            return mi + 1;
        }
        if (this.bPd == 2 && this.eDA.aOK().size() != 0 && this.eDA.aOK().size() % this.eDA.aOL() == 0) {
            return mi + 1;
        }
        if (this.bPd == 3 && this.eFG) {
            return this.eDA.aOI() - 1;
        }
        if (this.bPd == 3 && mi > 0) {
            return this.eDA.aOH() - 1;
        }
        return mi;
    }

    private SubPbRequestMessage aSM() {
        this.aAG = true;
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
        if (1 != this.bPd) {
            j = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = aTC();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.eFG && this.bPd == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.Gf.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, K, L, f, this.stType, i2);
    }

    public boolean Ff() {
        return oS(0);
    }

    public boolean aTD() {
        return oS(2);
    }

    public void aTE() {
        int aOL;
        if (this.eFB > 0 && this.eDA != null && (aOL = this.eDA.aOL()) > 0) {
            int mi = this.eDA.mi();
            for (int i = (((this.eFB + aOL) - 1) / aOL) - 1; i >= 0; i--) {
                this.eFL = f(Integer.valueOf(mi - i));
                this.eFL.setTreatDelPage(true);
                sendMessage(this.eFL);
            }
        }
        this.eFB = 0;
    }

    public boolean aTF() {
        return oS(1);
    }

    public boolean aTG() {
        return oS(3);
    }

    public boolean oS(int i) {
        if (this.aAG) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.aAG = false;
            return false;
        }
        aTE();
        this.bPd = i;
        this.eFL = aSM();
        sendMessage(this.eFL);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.data.n nVar) {
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aOK = nVar.aOK();
        if (aOK == null || aOK.size() == 0) {
            nVar.aW(this.eDA.mi());
        }
        if (this.bPd == 1) {
            this.eDA = nVar;
        } else if (this.bPd == 2) {
            this.eDA.b(nVar, true);
        } else if (this.bPd == 3) {
            this.eDA.a(nVar, false);
        } else {
            this.eDA.b(nVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.pb.data.n nVar) {
        if (this.bPd == 1) {
            this.eDA = nVar;
            this.eDA.aOJ();
        } else if (this.bPd == 2) {
            this.eDA.c(nVar, true);
        } else if (this.bPd == 3) {
            this.eDA.d(nVar, false);
        } else {
            this.eDA.a(nVar);
        }
    }

    public void f(com.baidu.tieba.pb.data.n nVar) {
        String str;
        if (nVar.Jz() == null || nVar.Jz().getAuthor() == null) {
            str = null;
        } else {
            str = nVar.Jz().getAuthor().getUserId();
        }
        if (!this.eFG) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= nVar.aOK().size()) {
                    break;
                }
                nVar.aOK().get(i2).b(this.Gf, str.equals(nVar.aOK().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.eFE.add(nVar);
    }

    public boolean aTd() {
        return this.eFv;
    }

    public boolean isMarked() {
        return this.esE;
    }

    public boolean aTH() {
        return "hot_topic".equals(getStType());
    }

    public void iO(boolean z) {
        this.esE = z;
    }

    public int aOt() {
        return this.erZ;
    }

    public String aTI() {
        return this.eFz;
    }

    public void pO(String str) {
        this.eFz = str;
    }

    public boolean aTJ() {
        return this.eFy;
    }

    public String aTK() {
        return this.eFx;
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public WriteData fF(String str) {
        if (this.eDA == null || this.eDA.aOM() == null || this.eDA.Jz() == null || this.eDA.aOG() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.eDA.aOM().getName());
        writeData.setForumId(this.eDA.aOM().getId());
        writeData.setFloor(this.eDA.aOG().getId());
        writeData.setType(2);
        writeData.setThreadId(this.eDA.Jz().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public boolean Dn() {
        if (this.eFK) {
            aTM();
        } else {
            aTD();
        }
        return true;
    }

    public boolean aTL() {
        return this.eFK;
    }

    public void jj(boolean z) {
        this.eFK = z;
    }

    private void aTM() {
        if (this.ewJ == null) {
            this.ewJ = new com.baidu.tieba.pb.pb.main.view.c(this.Gf);
            this.ewJ.setUniqueId(BdUniqueId.gen());
            this.ewJ.c(this.eDA);
            this.ewJ.setPostId(this.postID);
            this.ewJ.a(this.eDD);
        }
        this.ewJ.aSL();
    }

    public void b(c.a aVar) {
        this.eDD = aVar;
    }

    public boolean aTN() {
        return this.eFG;
    }

    public void jk(boolean z) {
        this.eFG = z;
    }

    public SmallTailInfo aTO() {
        return this.eFF;
    }

    public boolean aTP() {
        return this.eFD;
    }

    public ConcurrentHashMap<String, ImageUrlData> aTQ() {
        return this.eFI;
    }

    public ArrayList<String> aTR() {
        return this.eFH;
    }

    public boolean aTS() {
        return this.eFJ;
    }

    public int getOffset() {
        return this.mOffset;
    }
}
