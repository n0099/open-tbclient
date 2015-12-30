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
public class ao extends com.baidu.tbadk.editortools.d.a {
    private static BdAsyncTaskParallel cMd = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private com.baidu.tieba.tbadkCore.d.a aUT;
    private int aZJ;
    private boolean axY;
    private int cCR;
    private AntiData cDg;
    private boolean cDh;
    private com.baidu.tieba.pb.a.d cLA;
    private boolean cLV;
    private String cLW;
    private String cLX;
    private boolean cLY;
    private String cLZ;
    private a cMa;
    private int cMb;
    private boolean cMc;
    private ArrayList<com.baidu.tieba.pb.a.d> cMe;
    private SmallTailInfo cMf;
    private boolean cMg;
    private SubPbRequestMessage cMh;
    private com.baidu.adp.framework.listener.a cMi;
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
        a2.setParallel(cMd);
        a3.setParallel(cMd);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.cLV = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.cLW = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.cLY = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.cLX = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.cCR = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.cMf = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.cMf != null) {
                this.cMf.updateShowInfo();
            }
            this.cDg = (AntiData) intent.getSerializableExtra("anti");
            this.cMc = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.cLV = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.cLW = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.cLY = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.cLX = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.cCR = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.cMf = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.cMf != null) {
                this.cMf.updateShowInfo();
            }
            this.cDg = (AntiData) bundle.getSerializable("anti");
            this.cMc = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void saveToBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.cLV);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.cLW);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.cLX);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.cLY);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.cCR);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.cMf);
            bundle.putSerializable("anti", this.cDg);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public ao(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aZJ = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.cLV = false;
        this.cLW = null;
        this.cLX = null;
        this.cLY = false;
        this.cDh = false;
        this.cCR = 0;
        this.cLZ = null;
        this.mContext = null;
        this.cLA = null;
        this.cMa = null;
        this.cMb = 0;
        this.cMc = false;
        this.cMe = null;
        this.axY = false;
        this.aUT = null;
        this.cMi = new ap(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.mContext = tbPageContext;
        this.cMe = new ArrayList<>();
        this.cLA = new com.baidu.tieba.pb.a.d();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.cMi);
        registerListener(this.cMi);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String BJ() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.a.d anR() {
        return this.cLA;
    }

    public AntiData ala() {
        return this.cDg;
    }

    public boolean anS() {
        return (this.cLA == null || this.cLA.akS() == null) ? false : true;
    }

    public void a(a aVar) {
        this.cMa = aVar;
    }

    public MarkData d(com.baidu.tieba.tbadkCore.data.r rVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(rVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(rVar.aFq());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.cMi);
        Kz();
    }

    private void Kz() {
        if (this.aUT != null) {
            this.aUT.destory();
            this.aUT = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int getLoadType() {
        return this.aZJ;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void kN(String str) {
        if (!TextUtils.isEmpty(str) && this.cLA != null && this.cLA.akW() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.r> akW = this.cLA.akW();
            int size = akW.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(akW.get(i).getId())) {
                    akW.remove(i);
                    this.cMb++;
                    this.cLA.setTotalCount(this.cLA.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int anT() {
        int currentPage = this.cLA.getCurrentPage();
        if (currentPage == 0) {
            return currentPage + 1;
        }
        if (this.aZJ == 0) {
            return currentPage + 1;
        }
        if (this.aZJ == 2 && this.cLA.akW().size() != 0 && this.cLA.akW().size() % this.cLA.akY() == 0) {
            return currentPage + 1;
        }
        if (this.aZJ == 3 && this.cMg) {
            return this.cLA.akU() - 1;
        }
        if (this.aZJ == 3 && currentPage > 0) {
            return this.cLA.akT() - 1;
        }
        return currentPage;
    }

    private SubPbRequestMessage anU() {
        this.axY = true;
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
        if (1 != this.aZJ) {
            j = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = anT();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.cMg && this.aZJ == 0) {
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

    public boolean Dy() {
        return kD(0);
    }

    public boolean anV() {
        return kD(2);
    }

    public void anW() {
        int akY;
        if (this.cMb > 0 && this.cLA != null && (akY = this.cLA.akY()) > 0) {
            int currentPage = this.cLA.getCurrentPage();
            for (int i = (((this.cMb + akY) - 1) / akY) - 1; i >= 0; i--) {
                this.cMh = d(Integer.valueOf(currentPage - i));
                this.cMh.setTreatDelPage(true);
                sendMessage(this.cMh);
            }
        }
        this.cMb = 0;
    }

    public boolean anX() {
        return kD(1);
    }

    public boolean anY() {
        return kD(3);
    }

    public boolean kD(int i) {
        if (this.axY) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.axY = false;
            return false;
        }
        anW();
        this.aZJ = i;
        this.cMh = anU();
        sendMessage(this.cMh);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.a.d dVar) {
        ArrayList<com.baidu.tieba.tbadkCore.data.r> akW = dVar.akW();
        if (akW == null || akW.size() == 0) {
            dVar.setCurrentPage(this.cLA.getCurrentPage());
        }
        if (this.aZJ == 1) {
            this.cLA = dVar;
        } else if (this.aZJ == 2) {
            this.cLA.b(dVar, true);
        } else if (this.aZJ == 3) {
            this.cLA.a(dVar, false);
        } else {
            this.cLA.b(dVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.a.d dVar) {
        if (this.aZJ == 1) {
            this.cLA = dVar;
            this.cLA.akV();
        } else if (this.aZJ == 2) {
            this.cLA.c(dVar, true);
        } else if (this.aZJ == 3) {
            this.cLA.d(dVar, false);
        } else {
            this.cLA.a(dVar);
        }
    }

    public void e(com.baidu.tieba.pb.a.d dVar) {
        String str;
        if (dVar.Iv() == null || dVar.Iv().getAuthor() == null) {
            str = null;
        } else {
            str = dVar.Iv().getAuthor().getUserId();
        }
        if (!this.cMg) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= dVar.akW().size()) {
                    break;
                }
                dVar.akW().get(i2).a(this.mContext.getUniqueId(), str.equals(dVar.akW().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.cMe.add(dVar);
    }

    public boolean ans() {
        return this.cLV;
    }

    public String anZ() {
        return this.cLW;
    }

    public boolean isMarked() {
        return this.cDh;
    }

    public boolean aoa() {
        return HotTopicActivityConfig.ST_TYPE.equals(getStType());
    }

    public void fy(boolean z) {
        this.cDh = z;
    }

    public int akL() {
        return this.cCR;
    }

    public String aob() {
        return this.cLZ;
    }

    public void kO(String str) {
        this.cLZ = str;
    }

    public boolean aoc() {
        return this.cLY;
    }

    public String aod() {
        return this.cLX;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fp(String str) {
        if (this.cLA == null || this.cLA.akZ() == null || this.cLA.Iv() == null || this.cLA.akS() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.cLA.akZ().getName());
        writeData.setForumId(this.cLA.akZ().getId());
        writeData.setFloor(this.cLA.akS().getId());
        writeData.setType(2);
        writeData.setThreadId(this.cLA.Iv().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public boolean BI() {
        return anV();
    }

    public boolean isFromPhotoLive() {
        return this.cMg;
    }

    public void fz(boolean z) {
        this.cMg = z;
    }

    public SmallTailInfo aoe() {
        return this.cMf;
    }

    public boolean aof() {
        return this.cMc;
    }
}
