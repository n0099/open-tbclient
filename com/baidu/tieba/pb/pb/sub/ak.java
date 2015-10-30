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
    private static BdAsyncTaskParallel cny = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private com.baidu.tieba.tbadkCore.e.a aMl;
    private int aQy;
    private boolean avC;
    private boolean cgA;
    private int cgk;
    private AntiData cgz;
    private com.baidu.tieba.pb.a.c cmV;
    private SmallTailInfo cnA;
    private boolean cnB;
    private SubPbRequestMessage cnC;
    private com.baidu.adp.framework.listener.a cnD;
    private boolean cnq;
    private String cnr;
    private String cns;
    private boolean cnt;
    private String cnu;
    private a cnv;
    private int cnw;
    private boolean cnx;
    private ArrayList<com.baidu.tieba.pb.a.c> cnz;
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
        a2.setParallel(cny);
        a3.setParallel(cny);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.cnq = intent.getBooleanExtra("is_jump_from_pb", false);
            this.cnr = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.cnt = intent.getBooleanExtra("show_keyboard", false);
            this.cns = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.cgk = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.cnA = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.cnA != null) {
                this.cnA.updateShowInfo();
            }
            this.cgz = (AntiData) intent.getSerializableExtra("anti");
            this.cnx = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.cnq = bundle.getBoolean("is_jump_from_pb", false);
            this.cnr = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.cnt = bundle.getBoolean("show_keyboard", false);
            this.cns = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.cgk = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.cnA = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.cnA != null) {
                this.cnA.updateShowInfo();
            }
            this.cgz = (AntiData) bundle.getSerializable("anti");
            this.cnx = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void saveToBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean("is_jump_from_pb", this.cnq);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.cnr);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.cns);
            bundle.putBoolean("show_keyboard", this.cnt);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.cgk);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.cnA);
            bundle.putSerializable("anti", this.cgz);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public ak(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aQy = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.cnq = false;
        this.cnr = null;
        this.cns = null;
        this.cnt = false;
        this.cgA = false;
        this.cgk = 0;
        this.cnu = null;
        this.mContext = null;
        this.cmV = null;
        this.cnv = null;
        this.cnw = 0;
        this.cnx = false;
        this.cnz = null;
        this.avC = false;
        this.aMl = null;
        this.cnD = new al(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.mContext = tbPageContext;
        this.cnz = new ArrayList<>();
        this.cmV = new com.baidu.tieba.pb.a.c();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.cnD);
        registerListener(this.cnD);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public String Bi() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.a.c ahw() {
        return this.cmV;
    }

    public AntiData afd() {
        return this.cgz;
    }

    public boolean ahx() {
        return (this.cmV == null || this.cmV.aeV() == null) ? false : true;
    }

    public void a(a aVar) {
        this.cnv = aVar;
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
        markData.setFloor(kVar.awE());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.cnD);
        Iy();
    }

    private void Iy() {
        if (this.aMl != null) {
            this.aMl.destory();
            this.aMl = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int ahy() {
        return this.aQy;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void jW(String str) {
        if (!TextUtils.isEmpty(str) && this.cmV != null && this.cmV.aeZ() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.k> aeZ = this.cmV.aeZ();
            int size = aeZ.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aeZ.get(i).getId())) {
                    aeZ.remove(i);
                    this.cnw++;
                    this.cmV.setTotalCount(this.cmV.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int ahz() {
        int currentPage = this.cmV.getCurrentPage();
        if (currentPage == 0) {
            return currentPage + 1;
        }
        if (this.aQy == 0) {
            return currentPage + 1;
        }
        if (this.aQy == 2 && this.cmV.aeZ().size() != 0 && this.cmV.aeZ().size() % this.cmV.afb() == 0) {
            return currentPage + 1;
        }
        if (this.aQy == 3 && this.cnB) {
            return this.cmV.aeX() - 1;
        }
        if (this.aQy == 3 && currentPage > 0) {
            return this.cmV.aeW() - 1;
        }
        return currentPage;
    }

    private SubPbRequestMessage ahA() {
        this.avC = true;
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
        if (1 != this.aQy) {
            j = Long.parseLong(this.postID);
        } else {
            j2 = Long.parseLong(this.postID);
        }
        if (num == null) {
            intValue = ahz();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.cnB && this.aQy == 0) {
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

    public boolean CP() {
        return iY(0);
    }

    public boolean ahB() {
        return iY(2);
    }

    public void ahC() {
        int afb;
        if (this.cnw > 0 && this.cmV != null && (afb = this.cmV.afb()) > 0) {
            int currentPage = this.cmV.getCurrentPage();
            for (int i = (((this.cnw + afb) - 1) / afb) - 1; i >= 0; i--) {
                this.cnC = d(Integer.valueOf(currentPage - i));
                this.cnC.setTreatDelPage(true);
                sendMessage(this.cnC);
            }
        }
        this.cnw = 0;
    }

    public boolean ahD() {
        return iY(1);
    }

    public boolean ahE() {
        return iY(3);
    }

    public boolean iY(int i) {
        if (this.avC) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.avC = false;
            return false;
        }
        ahC();
        this.aQy = i;
        this.cnC = ahA();
        sendMessage(this.cnC);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.a.c cVar) {
        ArrayList<com.baidu.tieba.tbadkCore.data.k> aeZ = cVar.aeZ();
        if (aeZ == null || aeZ.size() == 0) {
            cVar.setCurrentPage(this.cmV.getCurrentPage());
        }
        if (this.aQy == 1) {
            this.cmV = cVar;
        } else if (this.aQy == 2) {
            this.cmV.b(cVar, true);
        } else if (this.aQy == 3) {
            this.cmV.a(cVar, false);
        } else {
            this.cmV.b(cVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.a.c cVar) {
        if (this.aQy == 1) {
            this.cmV = cVar;
            this.cmV.aeY();
        } else if (this.aQy == 2) {
            this.cmV.c(cVar, true);
        } else if (this.aQy == 3) {
            this.cmV.d(cVar, false);
        } else {
            this.cmV.a(cVar);
        }
    }

    public void e(com.baidu.tieba.pb.a.c cVar) {
        String str;
        if (cVar.afe() == null || cVar.afe().getAuthor() == null) {
            str = null;
        } else {
            str = cVar.afe().getAuthor().getUserId();
        }
        if (!this.cnB) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= cVar.aeZ().size()) {
                    break;
                }
                cVar.aeZ().get(i2).a(this.mContext.getUniqueId(), str.equals(cVar.aeZ().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.cnz.add(cVar);
    }

    public boolean agX() {
        return this.cnq;
    }

    public String ahF() {
        return this.cnr;
    }

    public boolean isMarked() {
        return this.cgA;
    }

    public boolean ahG() {
        return HotTopicActivityConfig.ST_TYPE.equals(getStType());
    }

    public void eS(boolean z) {
        this.cgA = z;
    }

    public int aeO() {
        return this.cgk;
    }

    public String ahH() {
        return this.cnu;
    }

    public void jX(String str) {
        this.cnu = str;
    }

    public boolean ahI() {
        return this.cnt;
    }

    public String ahJ() {
        return this.cns;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public WriteData eV(String str) {
        if (this.cmV == null || this.cmV.afc() == null || this.cmV.afe() == null || this.cmV.aeV() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.cmV.afc().getName());
        writeData.setForumId(this.cmV.afc().getId());
        writeData.setFloor(this.cmV.aeV().getId());
        writeData.setType(2);
        writeData.setThreadId(this.cmV.afe().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.c.a
    public boolean Bh() {
        return ahB();
    }

    public void eT(boolean z) {
        this.cnB = z;
    }

    public SmallTailInfo ahK() {
        return this.cnA;
    }

    public boolean ahL() {
        return this.cnx;
    }
}
