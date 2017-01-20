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
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private TbPageContext<?> Fp;
    private com.baidu.tieba.tbadkCore.d.b byl;
    private AntiData efX;
    private boolean efY;
    private int efu;
    private PbFakeFloorModel ejW;
    private com.baidu.tieba.pb.data.j eqJ;
    private PbFakeFloorModel.a eqM;
    private com.baidu.adp.framework.listener.a eqN;
    private boolean esF;
    private String esG;
    private String esH;
    private boolean esI;
    private String esJ;
    private a esK;
    private int esL;
    private ArrayList<IconData> esM;
    private boolean esN;
    private ArrayList<com.baidu.tieba.pb.data.j> esO;
    private SmallTailInfo esP;
    private boolean esQ;
    private ArrayList<String> esR;
    private ConcurrentHashMap<String, ImageUrlData> esS;
    private boolean esT;
    private boolean esU;
    private SubPbRequestMessage esV;
    private boolean isLoading;
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
            this.esF = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.esG = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.esI = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.esH = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.efu = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.esP = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.esP != null) {
                this.esP.updateShowInfo();
            }
            this.efX = (AntiData) intent.getSerializableExtra("anti");
            this.esM = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.esN = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.esS = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.esS.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.esR = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.esT = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.esF = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.esG = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.esI = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.esH = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.efu = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.esP = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.esP != null) {
                this.esP.updateShowInfo();
            }
            this.efX = (AntiData) bundle.getSerializable("anti");
            this.esM = (ArrayList) bundle.getSerializable(SubPbActivityConfig.ICON_LIST);
            this.esN = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void o(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.esF);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.esG);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.esH);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.esI);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.efu);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.esP);
            bundle.putSerializable("anti", this.efX);
            bundle.putSerializable(SubPbActivityConfig.ICON_LIST, this.esM);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.esF = false;
        this.esG = null;
        this.esH = null;
        this.esI = false;
        this.efY = false;
        this.efu = 0;
        this.esJ = null;
        this.Fp = null;
        this.eqJ = null;
        this.esK = null;
        this.esL = 0;
        this.esN = false;
        this.esO = null;
        this.isLoading = false;
        this.byl = null;
        this.esT = true;
        this.mOffset = 0;
        this.ejW = null;
        this.eqM = null;
        this.esU = false;
        this.eqN = new bc(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.Fp = tbPageContext;
        this.esO = new ArrayList<>();
        this.eqJ = new com.baidu.tieba.pb.data.j();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.eqN);
        registerListener(this.eqN);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String CS() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.data.j aPn() {
        return this.eqJ;
    }

    public AntiData axd() {
        return this.efX;
    }

    public boolean aPo() {
        return (this.eqJ == null || this.eqJ.aKw() == null) ? false : true;
    }

    public void a(a aVar) {
        this.esK = aVar;
    }

    public MarkData e(com.baidu.tieba.tbadkCore.data.p pVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(pVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(pVar.bhQ());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.eqN);
        if (this.ejW != null) {
            this.ejW.unRegisterListener();
        }
        UP();
    }

    private void UP() {
        if (this.byl != null) {
            this.byl.destory();
            this.byl = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    public int getLoadType() {
        return this.mLoadType;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void oE(String str) {
        if (!TextUtils.isEmpty(str) && this.eqJ != null && this.eqJ.aKA() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.p> aKA = this.eqJ.aKA();
            int size = aKA.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aKA.get(i).getId())) {
                    aKA.remove(i);
                    this.esL++;
                    this.eqJ.setTotalCount(this.eqJ.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aPp() {
        int ma = this.eqJ.ma();
        if (ma == 0) {
            return ma + 1;
        }
        if (this.mLoadType == 0) {
            return ma + 1;
        }
        if (this.mLoadType == 2 && this.eqJ.aKA().size() != 0 && this.eqJ.aKA().size() % this.eqJ.aKB() == 0) {
            return ma + 1;
        }
        if (this.mLoadType == 3 && this.esQ) {
            return this.eqJ.aKy() - 1;
        }
        if (this.mLoadType == 3 && ma > 0) {
            return this.eqJ.aKx() - 1;
        }
        return ma;
    }

    private SubPbRequestMessage aOv() {
        this.isLoading = true;
        return c((Integer) null);
    }

    private SubPbRequestMessage c(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int I = com.baidu.adp.lib.util.k.I(TbadkCoreApplication.m9getInst().getApp());
        int J = com.baidu.adp.lib.util.k.J(TbadkCoreApplication.m9getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = aPp();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.esQ && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.Fp.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, I, J, f, this.stType, i2);
    }

    public boolean EH() {
        return oL(0);
    }

    public boolean aPq() {
        return oL(2);
    }

    public void aPr() {
        int aKB;
        if (this.esL > 0 && this.eqJ != null && (aKB = this.eqJ.aKB()) > 0) {
            int ma = this.eqJ.ma();
            for (int i = (((this.esL + aKB) - 1) / aKB) - 1; i >= 0; i--) {
                this.esV = c(Integer.valueOf(ma - i));
                this.esV.setTreatDelPage(true);
                sendMessage(this.esV);
            }
        }
        this.esL = 0;
    }

    public boolean aPs() {
        return oL(1);
    }

    public boolean aPt() {
        return oL(3);
    }

    public boolean oL(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        aPr();
        this.mLoadType = i;
        this.esV = aOv();
        sendMessage(this.esV);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.data.j jVar) {
        ArrayList<com.baidu.tieba.tbadkCore.data.p> aKA = jVar.aKA();
        if (aKA == null || aKA.size() == 0) {
            jVar.aW(this.eqJ.ma());
        }
        if (this.mLoadType == 1) {
            this.eqJ = jVar;
        } else if (this.mLoadType == 2) {
            this.eqJ.b(jVar, true);
        } else if (this.mLoadType == 3) {
            this.eqJ.a(jVar, false);
        } else {
            this.eqJ.b(jVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.pb.data.j jVar) {
        if (this.mLoadType == 1) {
            this.eqJ = jVar;
            this.eqJ.aKz();
        } else if (this.mLoadType == 2) {
            this.eqJ.c(jVar, true);
        } else if (this.mLoadType == 3) {
            this.eqJ.d(jVar, false);
        } else {
            this.eqJ.a(jVar);
        }
    }

    public void f(com.baidu.tieba.pb.data.j jVar) {
        String str;
        if (jVar.Ji() == null || jVar.Ji().getAuthor() == null) {
            str = null;
        } else {
            str = jVar.Ji().getAuthor().getUserId();
        }
        if (!this.esQ) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jVar.aKA().size()) {
                    break;
                }
                jVar.aKA().get(i2).b(this.Fp, str.equals(jVar.aKA().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.esO.add(jVar);
    }

    public boolean aOQ() {
        return this.esF;
    }

    public boolean isMarked() {
        return this.efY;
    }

    public boolean aPu() {
        return "hot_topic".equals(getStType());
    }

    public void iK(boolean z) {
        this.efY = z;
    }

    public int aKj() {
        return this.efu;
    }

    public String aPv() {
        return this.esJ;
    }

    public void oF(String str) {
        this.esJ = str;
    }

    public boolean aPw() {
        return this.esI;
    }

    public String aPx() {
        return this.esH;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fy(String str) {
        if (this.eqJ == null || this.eqJ.aKC() == null || this.eqJ.Ji() == null || this.eqJ.aKw() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.eqJ.aKC().getName());
        writeData.setForumId(this.eqJ.aKC().getId());
        writeData.setFloor(this.eqJ.aKw().getId());
        writeData.setType(2);
        writeData.setThreadId(this.eqJ.Ji().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean CR() {
        if (this.esU) {
            aPz();
        } else {
            aPq();
        }
        return true;
    }

    public boolean aPy() {
        return this.esU;
    }

    public void jg(boolean z) {
        this.esU = z;
    }

    private void aPz() {
        if (this.ejW == null) {
            this.ejW = new PbFakeFloorModel(this.Fp);
            this.ejW.setUniqueId(BdUniqueId.gen());
            this.ejW.c(this.eqJ);
            this.ejW.setPostId(this.postID);
            this.ejW.a(this.eqM);
        }
        this.ejW.aOu();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.eqM = aVar;
    }

    public boolean aPA() {
        return this.esQ;
    }

    public void jh(boolean z) {
        this.esQ = z;
    }

    public SmallTailInfo aPB() {
        return this.esP;
    }

    public boolean aPC() {
        return this.esN;
    }

    public ConcurrentHashMap<String, ImageUrlData> aPD() {
        return this.esS;
    }

    public ArrayList<String> aPE() {
        return this.esR;
    }

    public boolean aPF() {
        return this.esT;
    }

    public int getOffset() {
        return this.mOffset;
    }
}
