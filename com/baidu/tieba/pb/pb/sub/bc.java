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
    private boolean aAd;
    private com.baidu.adp.framework.listener.a bCL;
    private com.baidu.tieba.tbadkCore.d.b bqy;
    private int dWB;
    private AntiData dXb;
    private boolean dXc;
    private com.baidu.tieba.pb.pb.main.view.c ebe;
    private com.baidu.tieba.pb.data.j ehB;
    private c.a ehE;
    private a ejA;
    private int ejB;
    private ArrayList<IconData> ejC;
    private boolean ejD;
    private ArrayList<com.baidu.tieba.pb.data.j> ejE;
    private SmallTailInfo ejF;
    private boolean ejG;
    private ArrayList<String> ejH;
    private ConcurrentHashMap<String, ImageUrlData> ejI;
    private boolean ejJ;
    private boolean ejK;
    private SubPbRequestMessage ejL;
    private boolean ejv;
    private String ejw;
    private String ejx;
    private boolean ejy;
    private String ejz;
    private int mLoadType;
    private int mOffset;
    private String postID;
    private String stType;
    private String threadID;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, String str, com.baidu.tieba.pb.data.j jVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.ejv = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.ejw = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.ejy = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.ejx = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.dWB = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.ejF = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.ejF != null) {
                this.ejF.updateShowInfo();
            }
            this.dXb = (AntiData) intent.getSerializableExtra("anti");
            this.ejC = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.ejD = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.ejI = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.ejI.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.ejH = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.ejJ = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.ejv = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.ejw = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.ejy = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.ejx = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.dWB = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.ejF = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.ejF != null) {
                this.ejF.updateShowInfo();
            }
            this.dXb = (AntiData) bundle.getSerializable("anti");
            this.ejC = (ArrayList) bundle.getSerializable(SubPbActivityConfig.ICON_LIST);
            this.ejD = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void n(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.ejv);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.ejw);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.ejx);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.ejy);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.dWB);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.ejF);
            bundle.putSerializable("anti", this.dXb);
            bundle.putSerializable(SubPbActivityConfig.ICON_LIST, this.ejC);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public bc(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.ejv = false;
        this.ejw = null;
        this.ejx = null;
        this.ejy = false;
        this.dXc = false;
        this.dWB = 0;
        this.ejz = null;
        this.Gf = null;
        this.ehB = null;
        this.ejA = null;
        this.ejB = 0;
        this.ejD = false;
        this.ejE = null;
        this.aAd = false;
        this.bqy = null;
        this.ejJ = true;
        this.mOffset = 0;
        this.ebe = null;
        this.ehE = null;
        this.ejK = false;
        this.bCL = new bd(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.Gf = tbPageContext;
        this.ejE = new ArrayList<>();
        this.ehB = new com.baidu.tieba.pb.data.j();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.bCL);
        registerListener(this.bCL);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public String CX() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.data.j aNr() {
        return this.ehB;
    }

    public AntiData avW() {
        return this.dXb;
    }

    public boolean aNs() {
        return (this.ehB == null || this.ehB.aIF() == null) ? false : true;
    }

    public void a(a aVar) {
        this.ejA = aVar;
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
        markData.setFloor(qVar.bga());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.bCL);
        if (this.ebe != null) {
            this.ebe.unRegisterListener();
        }
        Tw();
    }

    private void Tw() {
        if (this.bqy != null) {
            this.bqy.destory();
            this.bqy = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int getLoadType() {
        return this.mLoadType;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void oo(String str) {
        if (!TextUtils.isEmpty(str) && this.ehB != null && this.ehB.aIJ() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.q> aIJ = this.ehB.aIJ();
            int size = aIJ.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aIJ.get(i).getId())) {
                    aIJ.remove(i);
                    this.ejB++;
                    this.ehB.setTotalCount(this.ehB.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aNt() {
        int mi = this.ehB.mi();
        if (mi == 0) {
            return mi + 1;
        }
        if (this.mLoadType == 0) {
            return mi + 1;
        }
        if (this.mLoadType == 2 && this.ehB.aIJ().size() != 0 && this.ehB.aIJ().size() % this.ehB.aIK() == 0) {
            return mi + 1;
        }
        if (this.mLoadType == 3 && this.ejG) {
            return this.ehB.aIH() - 1;
        }
        if (this.mLoadType == 3 && mi > 0) {
            return this.ehB.aIG() - 1;
        }
        return mi;
    }

    private SubPbRequestMessage aMD() {
        this.aAd = true;
        return f((Integer) null);
    }

    private SubPbRequestMessage f(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int I = com.baidu.adp.lib.util.k.I(TbadkCoreApplication.m9getInst().getApp());
        int J = com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = aNt();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.ejG && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.Gf.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, I, J, f, this.stType, i2);
    }

    public boolean EN() {
        return nU(0);
    }

    public boolean aNu() {
        return nU(2);
    }

    public void aNv() {
        int aIK;
        if (this.ejB > 0 && this.ehB != null && (aIK = this.ehB.aIK()) > 0) {
            int mi = this.ehB.mi();
            for (int i = (((this.ejB + aIK) - 1) / aIK) - 1; i >= 0; i--) {
                this.ejL = f(Integer.valueOf(mi - i));
                this.ejL.setTreatDelPage(true);
                sendMessage(this.ejL);
            }
        }
        this.ejB = 0;
    }

    public boolean aNw() {
        return nU(1);
    }

    public boolean aNx() {
        return nU(3);
    }

    public boolean nU(int i) {
        if (this.aAd) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.aAd = false;
            return false;
        }
        aNv();
        this.mLoadType = i;
        this.ejL = aMD();
        sendMessage(this.ejL);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.data.j jVar) {
        ArrayList<com.baidu.tieba.tbadkCore.data.q> aIJ = jVar.aIJ();
        if (aIJ == null || aIJ.size() == 0) {
            jVar.aX(this.ehB.mi());
        }
        if (this.mLoadType == 1) {
            this.ehB = jVar;
        } else if (this.mLoadType == 2) {
            this.ehB.b(jVar, true);
        } else if (this.mLoadType == 3) {
            this.ehB.a(jVar, false);
        } else {
            this.ehB.b(jVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.pb.data.j jVar) {
        if (this.mLoadType == 1) {
            this.ehB = jVar;
            this.ehB.aII();
        } else if (this.mLoadType == 2) {
            this.ehB.c(jVar, true);
        } else if (this.mLoadType == 3) {
            this.ehB.d(jVar, false);
        } else {
            this.ehB.a(jVar);
        }
    }

    public void f(com.baidu.tieba.pb.data.j jVar) {
        String str;
        if (jVar.IU() == null || jVar.IU().getAuthor() == null) {
            str = null;
        } else {
            str = jVar.IU().getAuthor().getUserId();
        }
        if (!this.ejG) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jVar.aIJ().size()) {
                    break;
                }
                jVar.aIJ().get(i2).b(this.Gf, str.equals(jVar.aIJ().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.ejE.add(jVar);
    }

    public boolean aMU() {
        return this.ejv;
    }

    public boolean isMarked() {
        return this.dXc;
    }

    public boolean aNy() {
        return "hot_topic".equals(getStType());
    }

    public void iA(boolean z) {
        this.dXc = z;
    }

    public int aIu() {
        return this.dWB;
    }

    public String aNz() {
        return this.ejz;
    }

    public void op(String str) {
        this.ejz = str;
    }

    public boolean aNA() {
        return this.ejy;
    }

    public String aNB() {
        return this.ejx;
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public WriteData fB(String str) {
        if (this.ehB == null || this.ehB.aIL() == null || this.ehB.IU() == null || this.ehB.aIF() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.ehB.aIL().getName());
        writeData.setForumId(this.ehB.aIL().getId());
        writeData.setFloor(this.ehB.aIF().getId());
        writeData.setType(2);
        writeData.setThreadId(this.ehB.IU().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.e.a
    public boolean CW() {
        if (this.ejK) {
            aND();
        } else {
            aNu();
        }
        return true;
    }

    public boolean aNC() {
        return this.ejK;
    }

    public void iU(boolean z) {
        this.ejK = z;
    }

    private void aND() {
        if (this.ebe == null) {
            this.ebe = new com.baidu.tieba.pb.pb.main.view.c(this.Gf);
            this.ebe.setUniqueId(BdUniqueId.gen());
            this.ebe.c(this.ehB);
            this.ebe.setPostId(this.postID);
            this.ebe.a(this.ehE);
        }
        this.ebe.aMC();
    }

    public void b(c.a aVar) {
        this.ehE = aVar;
    }

    public boolean aNE() {
        return this.ejG;
    }

    public void iV(boolean z) {
        this.ejG = z;
    }

    public SmallTailInfo aNF() {
        return this.ejF;
    }

    public boolean aNG() {
        return this.ejD;
    }

    public ConcurrentHashMap<String, ImageUrlData> aNH() {
        return this.ejI;
    }

    public ArrayList<String> aNI() {
        return this.ejH;
    }

    public boolean aNJ() {
        return this.ejJ;
    }

    public int getOffset() {
        return this.mOffset;
    }
}
