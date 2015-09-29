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
public class ak extends com.baidu.tbadk.editortools.c.a {
    private static BdAsyncTaskParallel cnn = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private com.baidu.tieba.tbadkCore.e.a aMa;
    private int aQn;
    private boolean avB;
    private int cfZ;
    private AntiData cgo;
    private boolean cgp;
    private com.baidu.tieba.pb.a.c cmK;
    private boolean cnf;
    private String cng;
    private String cnh;
    private boolean cni;
    private String cnj;
    private a cnk;
    private int cnl;
    private boolean cnm;
    private ArrayList<com.baidu.tieba.pb.a.c> cno;
    private SmallTailInfo cnp;
    private boolean cnq;
    private SubPbRequestMessage cnr;
    private com.baidu.adp.framework.listener.a cns;
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
        a2.setParallel(cnn);
        a3.setParallel(cnn);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.cnf = intent.getBooleanExtra("is_jump_from_pb", false);
            this.cng = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.cni = intent.getBooleanExtra("show_keyboard", false);
            this.cnh = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.cfZ = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.cnp = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.cnp != null) {
                this.cnp.updateShowInfo();
            }
            this.cgo = (AntiData) intent.getSerializableExtra("anti");
            this.cnm = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.cnf = bundle.getBoolean("is_jump_from_pb", false);
            this.cng = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.cni = bundle.getBoolean("show_keyboard", false);
            this.cnh = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.cfZ = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.cnp = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.cnp != null) {
                this.cnp.updateShowInfo();
            }
            this.cgo = (AntiData) bundle.getSerializable("anti");
            this.cnm = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void saveToBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean("is_jump_from_pb", this.cnf);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.cng);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.cnh);
            bundle.putBoolean("show_keyboard", this.cni);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.cfZ);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.cnp);
            bundle.putSerializable("anti", this.cgo);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public ak(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aQn = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.cnf = false;
        this.cng = null;
        this.cnh = null;
        this.cni = false;
        this.cgp = false;
        this.cfZ = 0;
        this.cnj = null;
        this.mContext = null;
        this.cmK = null;
        this.cnk = null;
        this.cnl = 0;
        this.cnm = false;
        this.cno = null;
        this.avB = false;
        this.aMa = null;
        this.cns = new al(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.mContext = tbPageContext;
        this.cno = new ArrayList<>();
        this.cmK = new com.baidu.tieba.pb.a.c();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.cns);
        registerListener(this.cns);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public String Bl() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.a.c ahA() {
        return this.cmK;
    }

    public AntiData afh() {
        return this.cgo;
    }

    public boolean ahB() {
        return (this.cmK == null || this.cmK.aeZ() == null) ? false : true;
    }

    public void a(a aVar) {
        this.cnk = aVar;
    }

    public MarkData d(com.baidu.tieba.tbadkCore.data.k kVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(kVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(kVar.awy());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.cns);
        IC();
    }

    private void IC() {
        if (this.aMa != null) {
            this.aMa.destory();
            this.aMa = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int ahC() {
        return this.aQn;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void jW(String str) {
        if (!TextUtils.isEmpty(str) && this.cmK != null && this.cmK.afd() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.k> afd = this.cmK.afd();
            int size = afd.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(afd.get(i).getId())) {
                    afd.remove(i);
                    this.cnl++;
                    this.cmK.setTotalCount(this.cmK.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int ahD() {
        int currentPage = this.cmK.getCurrentPage();
        if (currentPage == 0) {
            return currentPage + 1;
        }
        if (this.aQn == 0) {
            return currentPage + 1;
        }
        if (this.aQn == 2 && this.cmK.afd().size() != 0 && this.cmK.afd().size() % this.cmK.aff() == 0) {
            return currentPage + 1;
        }
        if (this.aQn == 3 && this.cnq) {
            return this.cmK.afb() - 1;
        }
        if (this.aQn == 3 && currentPage > 0) {
            return this.cmK.afa() - 1;
        }
        return currentPage;
    }

    private SubPbRequestMessage ahE() {
        this.avB = true;
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
        if (1 != this.aQn) {
            j = Long.parseLong(this.postID);
        } else {
            j2 = Long.parseLong(this.postID);
        }
        if (num == null) {
            intValue = ahD();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.cnq && this.aQn == 0) {
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

    public boolean CS() {
        return iY(0);
    }

    public boolean ahF() {
        return iY(2);
    }

    public void ahG() {
        int aff;
        if (this.cnl > 0 && this.cmK != null && (aff = this.cmK.aff()) > 0) {
            int currentPage = this.cmK.getCurrentPage();
            for (int i = (((this.cnl + aff) - 1) / aff) - 1; i >= 0; i--) {
                this.cnr = d(Integer.valueOf(currentPage - i));
                this.cnr.setTreatDelPage(true);
                sendMessage(this.cnr);
            }
        }
        this.cnl = 0;
    }

    public boolean ahH() {
        return iY(1);
    }

    public boolean ahI() {
        return iY(3);
    }

    public boolean iY(int i) {
        if (this.avB) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.avB = false;
            return false;
        }
        ahG();
        this.aQn = i;
        this.cnr = ahE();
        sendMessage(this.cnr);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.a.c cVar) {
        ArrayList<com.baidu.tieba.tbadkCore.data.k> afd = cVar.afd();
        if (afd == null || afd.size() == 0) {
            cVar.setCurrentPage(this.cmK.getCurrentPage());
        }
        if (this.aQn == 1) {
            this.cmK = cVar;
        } else if (this.aQn == 2) {
            this.cmK.b(cVar, true);
        } else if (this.aQn == 3) {
            this.cmK.a(cVar, false);
        } else {
            this.cmK.b(cVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.a.c cVar) {
        if (this.aQn == 1) {
            this.cmK = cVar;
            this.cmK.afc();
        } else if (this.aQn == 2) {
            this.cmK.c(cVar, true);
        } else if (this.aQn == 3) {
            this.cmK.d(cVar, false);
        } else {
            this.cmK.a(cVar);
        }
    }

    public void e(com.baidu.tieba.pb.a.c cVar) {
        String str;
        if (cVar.afi() == null || cVar.afi().getAuthor() == null) {
            str = null;
        } else {
            str = cVar.afi().getAuthor().getUserId();
        }
        if (!this.cnq) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= cVar.afd().size()) {
                    break;
                }
                cVar.afd().get(i2).a(this.mContext.getUniqueId(), str.equals(cVar.afd().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.cno.add(cVar);
    }

    public boolean ahb() {
        return this.cnf;
    }

    public String ahJ() {
        return this.cng;
    }

    public boolean isMarked() {
        return this.cgp;
    }

    public boolean ahK() {
        return HotTopicActivityConfig.ST_TYPE.equals(getStType());
    }

    public void eS(boolean z) {
        this.cgp = z;
    }

    public int aeS() {
        return this.cfZ;
    }

    public String ahL() {
        return this.cnj;
    }

    public void jX(String str) {
        this.cnj = str;
    }

    public boolean ahM() {
        return this.cni;
    }

    public String ahN() {
        return this.cnh;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public WriteData eV(String str) {
        if (this.cmK == null || this.cmK.afg() == null || this.cmK.afi() == null || this.cmK.aeZ() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.cmK.afg().getName());
        writeData.setForumId(this.cmK.afg().getId());
        writeData.setFloor(this.cmK.aeZ().getId());
        writeData.setType(2);
        writeData.setThreadId(this.cmK.afi().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public boolean Bk() {
        return ahF();
    }

    public void eT(boolean z) {
        this.cnq = z;
    }

    public SmallTailInfo ahO() {
        return this.cnp;
    }

    public boolean ahP() {
        return this.cnm;
    }
}
