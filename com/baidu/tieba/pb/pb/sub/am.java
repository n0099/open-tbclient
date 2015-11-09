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
public class am extends com.baidu.tbadk.editortools.c.a {
    private static BdAsyncTaskParallel coP = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private com.baidu.tieba.tbadkCore.e.a aMt;
    private int aQG;
    private boolean auq;
    private int cgP;
    private AntiData che;
    private boolean chf;
    private boolean coH;
    private String coI;
    private String coJ;
    private boolean coK;
    private String coL;
    private a coM;
    private int coN;
    private boolean coO;
    private ArrayList<com.baidu.tieba.pb.a.d> coQ;
    private SmallTailInfo coR;
    private boolean coS;
    private SubPbRequestMessage coT;
    private com.baidu.adp.framework.listener.a coU;

    /* renamed from: com  reason: collision with root package name */
    private com.baidu.tieba.pb.a.d f127com;
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
        a2.setParallel(coP);
        a3.setParallel(coP);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.coH = intent.getBooleanExtra("is_jump_from_pb", false);
            this.coI = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.coK = intent.getBooleanExtra("show_keyboard", false);
            this.coJ = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.cgP = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.coR = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.coR != null) {
                this.coR.updateShowInfo();
            }
            this.che = (AntiData) intent.getSerializableExtra("anti");
            this.coO = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.coH = bundle.getBoolean("is_jump_from_pb", false);
            this.coI = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.coK = bundle.getBoolean("show_keyboard", false);
            this.coJ = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.cgP = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.coR = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.coR != null) {
                this.coR.updateShowInfo();
            }
            this.che = (AntiData) bundle.getSerializable("anti");
            this.coO = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void saveToBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean("is_jump_from_pb", this.coH);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.coI);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.coJ);
            bundle.putBoolean("show_keyboard", this.coK);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.cgP);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.coR);
            bundle.putSerializable("anti", this.che);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public am(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aQG = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.coH = false;
        this.coI = null;
        this.coJ = null;
        this.coK = false;
        this.chf = false;
        this.cgP = 0;
        this.coL = null;
        this.mContext = null;
        this.f127com = null;
        this.coM = null;
        this.coN = 0;
        this.coO = false;
        this.coQ = null;
        this.auq = false;
        this.aMt = null;
        this.coU = new an(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.mContext = tbPageContext;
        this.coQ = new ArrayList<>();
        this.f127com = new com.baidu.tieba.pb.a.d();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.coU);
        registerListener(this.coU);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public String AV() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.a.d aic() {
        return this.f127com;
    }

    public AntiData afA() {
        return this.che;
    }

    public boolean aid() {
        return (this.f127com == null || this.f127com.afs() == null) ? false : true;
    }

    public void a(a aVar) {
        this.coM = aVar;
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
        markData.setFloor(oVar.axt());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.coU);
        IO();
    }

    private void IO() {
        if (this.aMt != null) {
            this.aMt.destory();
            this.aMt = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int aie() {
        return this.aQG;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void jZ(String str) {
        if (!TextUtils.isEmpty(str) && this.f127com != null && this.f127com.afw() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.o> afw = this.f127com.afw();
            int size = afw.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(afw.get(i).getId())) {
                    afw.remove(i);
                    this.coN++;
                    this.f127com.setTotalCount(this.f127com.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aif() {
        int currentPage = this.f127com.getCurrentPage();
        if (currentPage == 0) {
            return currentPage + 1;
        }
        if (this.aQG == 0) {
            return currentPage + 1;
        }
        if (this.aQG == 2 && this.f127com.afw().size() != 0 && this.f127com.afw().size() % this.f127com.afy() == 0) {
            return currentPage + 1;
        }
        if (this.aQG == 3 && this.coS) {
            return this.f127com.afu() - 1;
        }
        if (this.aQG == 3 && currentPage > 0) {
            return this.f127com.aft() - 1;
        }
        return currentPage;
    }

    private SubPbRequestMessage aig() {
        this.auq = true;
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
        if (1 != this.aQG) {
            j = Long.parseLong(this.postID);
        } else {
            j2 = Long.parseLong(this.postID);
        }
        if (num == null) {
            intValue = aif();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.coS && this.aQG == 0) {
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

    public boolean CI() {
        return jm(0);
    }

    public boolean aih() {
        return jm(2);
    }

    public void aii() {
        int afy;
        if (this.coN > 0 && this.f127com != null && (afy = this.f127com.afy()) > 0) {
            int currentPage = this.f127com.getCurrentPage();
            for (int i = (((this.coN + afy) - 1) / afy) - 1; i >= 0; i--) {
                this.coT = d(Integer.valueOf(currentPage - i));
                this.coT.setTreatDelPage(true);
                sendMessage(this.coT);
            }
        }
        this.coN = 0;
    }

    public boolean aij() {
        return jm(1);
    }

    public boolean aik() {
        return jm(3);
    }

    public boolean jm(int i) {
        if (this.auq) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.auq = false;
            return false;
        }
        aii();
        this.aQG = i;
        this.coT = aig();
        sendMessage(this.coT);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.a.d dVar) {
        ArrayList<com.baidu.tieba.tbadkCore.data.o> afw = dVar.afw();
        if (afw == null || afw.size() == 0) {
            dVar.setCurrentPage(this.f127com.getCurrentPage());
        }
        if (this.aQG == 1) {
            this.f127com = dVar;
        } else if (this.aQG == 2) {
            this.f127com.b(dVar, true);
        } else if (this.aQG == 3) {
            this.f127com.a(dVar, false);
        } else {
            this.f127com.b(dVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.a.d dVar) {
        if (this.aQG == 1) {
            this.f127com = dVar;
            this.f127com.afv();
        } else if (this.aQG == 2) {
            this.f127com.c(dVar, true);
        } else if (this.aQG == 3) {
            this.f127com.d(dVar, false);
        } else {
            this.f127com.a(dVar);
        }
    }

    public void e(com.baidu.tieba.pb.a.d dVar) {
        String str;
        if (dVar.afB() == null || dVar.afB().getAuthor() == null) {
            str = null;
        } else {
            str = dVar.afB().getAuthor().getUserId();
        }
        if (!this.coS) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dVar.afw().size()) {
                    break;
                }
                dVar.afw().get(i2).a(this.mContext.getUniqueId(), str.equals(dVar.afw().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.coQ.add(dVar);
    }

    public boolean ahD() {
        return this.coH;
    }

    public String ail() {
        return this.coI;
    }

    public boolean isMarked() {
        return this.chf;
    }

    public boolean aim() {
        return HotTopicActivityConfig.ST_TYPE.equals(getStType());
    }

    public void eV(boolean z) {
        this.chf = z;
    }

    public int afl() {
        return this.cgP;
    }

    public String ain() {
        return this.coL;
    }

    public void ka(String str) {
        this.coL = str;
    }

    public boolean aio() {
        return this.coK;
    }

    public String aip() {
        return this.coJ;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public WriteData eW(String str) {
        if (this.f127com == null || this.f127com.afz() == null || this.f127com.afB() == null || this.f127com.afs() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.f127com.afz().getName());
        writeData.setForumId(this.f127com.afz().getId());
        writeData.setFloor(this.f127com.afs().getId());
        writeData.setType(2);
        writeData.setThreadId(this.f127com.afB().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public boolean AU() {
        return aih();
    }

    public void eW(boolean z) {
        this.coS = z;
    }

    public SmallTailInfo aiq() {
        return this.coR;
    }

    public boolean air() {
        return this.coO;
    }
}
