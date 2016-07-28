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
public class aw extends com.baidu.tbadk.editortools.d.a {
    private static BdAsyncTaskParallel ekC = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private TbPageContext<?> DQ;
    private boolean axe;
    private int bAH;
    private com.baidu.tieba.tbadkCore.d.b bwf;
    private AntiData dYA;
    private boolean dYB;
    private int dYa;
    private com.baidu.tieba.pb.data.m ejW;
    private ArrayList<IconData> ekA;
    private boolean ekB;
    private ArrayList<com.baidu.tieba.pb.data.m> ekD;
    private SmallTailInfo ekE;
    private boolean ekF;
    private ArrayList<String> ekG;
    private ConcurrentHashMap<String, ImageUrlData> ekH;
    private boolean ekI;
    private SubPbRequestMessage ekJ;
    private com.baidu.adp.framework.listener.a ekK;
    private boolean ekt;
    private String eku;
    private String ekv;
    private boolean ekw;
    private String ekx;
    private a eky;
    private int ekz;
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
        a2.setParallel(ekC);
        a3.setParallel(ekC);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.ekt = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eku = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.ekw = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.ekv = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.dYa = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.ekE = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.ekE != null) {
                this.ekE.updateShowInfo();
            }
            this.dYA = (AntiData) intent.getSerializableExtra("anti");
            this.ekA = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.ekB = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.ekH = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.ekH.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.ekG = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.ekI = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.ekt = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eku = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.ekw = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.ekv = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.dYa = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.ekE = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.ekE != null) {
                this.ekE.updateShowInfo();
            }
            this.dYA = (AntiData) bundle.getSerializable("anti");
            this.ekA = (ArrayList) bundle.getSerializable(SubPbActivityConfig.ICON_LIST);
            this.ekB = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void n(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.ekt);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.eku);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.ekv);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.ekw);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.dYa);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.ekE);
            bundle.putSerializable("anti", this.dYA);
            bundle.putSerializable(SubPbActivityConfig.ICON_LIST, this.ekA);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public aw(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bAH = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.ekt = false;
        this.eku = null;
        this.ekv = null;
        this.ekw = false;
        this.dYB = false;
        this.dYa = 0;
        this.ekx = null;
        this.DQ = null;
        this.ejW = null;
        this.eky = null;
        this.ekz = 0;
        this.ekB = false;
        this.ekD = null;
        this.axe = false;
        this.bwf = null;
        this.ekI = true;
        this.mOffset = 0;
        this.ekK = new ax(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.DQ = tbPageContext;
        this.ekD = new ArrayList<>();
        this.ejW = new com.baidu.tieba.pb.data.m();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.ekK);
        registerListener(this.ekK);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String BL() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.data.m aLS() {
        return this.ejW;
    }

    public AntiData getAntiData() {
        return this.dYA;
    }

    public boolean aLT() {
        return (this.ejW == null || this.ejW.aHp() == null) ? false : true;
    }

    public void a(a aVar) {
        this.eky = aVar;
    }

    public MarkData e(com.baidu.tieba.tbadkCore.data.s sVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(sVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(sVar.bfB());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.ekK);
        Td();
    }

    private void Td() {
        if (this.bwf != null) {
            this.bwf.destory();
            this.bwf = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int getLoadType() {
        return this.bAH;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void oA(String str) {
        if (!TextUtils.isEmpty(str) && this.ejW != null && this.ejW.aHt() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.s> aHt = this.ejW.aHt();
            int size = aHt.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aHt.get(i).getId())) {
                    aHt.remove(i);
                    this.ekz++;
                    this.ejW.setTotalCount(this.ejW.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aLU() {
        int lk = this.ejW.lk();
        if (lk == 0) {
            return lk + 1;
        }
        if (this.bAH == 0) {
            return lk + 1;
        }
        if (this.bAH == 2 && this.ejW.aHt().size() != 0 && this.ejW.aHt().size() % this.ejW.aHu() == 0) {
            return lk + 1;
        }
        if (this.bAH == 3 && this.ekF) {
            return this.ejW.aHr() - 1;
        }
        if (this.bAH == 3 && lk > 0) {
            return this.ejW.aHq() - 1;
        }
        return lk;
    }

    private SubPbRequestMessage aLV() {
        this.axe = true;
        return c((Integer) null);
    }

    private SubPbRequestMessage c(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.m10getInst().getApp().getResources().getDisplayMetrics().density;
        int A = com.baidu.adp.lib.util.k.A(TbadkCoreApplication.m10getInst().getApp());
        int B = com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m10getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.bAH) {
            j = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = aLU();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.ekF && this.bAH == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.DQ.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, A, B, f, this.stType, i2);
    }

    public boolean DG() {
        return nR(0);
    }

    public boolean aLW() {
        return nR(2);
    }

    public void aLX() {
        int aHu;
        if (this.ekz > 0 && this.ejW != null && (aHu = this.ejW.aHu()) > 0) {
            int lk = this.ejW.lk();
            for (int i = (((this.ekz + aHu) - 1) / aHu) - 1; i >= 0; i--) {
                this.ekJ = c(Integer.valueOf(lk - i));
                this.ekJ.setTreatDelPage(true);
                sendMessage(this.ekJ);
            }
        }
        this.ekz = 0;
    }

    public boolean aLY() {
        return nR(1);
    }

    public boolean aLZ() {
        return nR(3);
    }

    public boolean nR(int i) {
        if (this.axe) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.axe = false;
            return false;
        }
        aLX();
        this.bAH = i;
        this.ekJ = aLV();
        sendMessage(this.ekJ);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.data.m mVar) {
        ArrayList<com.baidu.tieba.tbadkCore.data.s> aHt = mVar.aHt();
        if (aHt == null || aHt.size() == 0) {
            mVar.aJ(this.ejW.lk());
        }
        if (this.bAH == 1) {
            this.ejW = mVar;
        } else if (this.bAH == 2) {
            this.ejW.b(mVar, true);
        } else if (this.bAH == 3) {
            this.ejW.a(mVar, false);
        } else {
            this.ejW.b(mVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.data.m mVar) {
        if (this.bAH == 1) {
            this.ejW = mVar;
            this.ejW.aHs();
        } else if (this.bAH == 2) {
            this.ejW.c(mVar, true);
        } else if (this.bAH == 3) {
            this.ejW.d(mVar, false);
        } else {
            this.ejW.a(mVar);
        }
    }

    public void e(com.baidu.tieba.pb.data.m mVar) {
        String str;
        if (mVar.Iw() == null || mVar.Iw().getAuthor() == null) {
            str = null;
        } else {
            str = mVar.Iw().getAuthor().getUserId();
        }
        if (!this.ekF) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mVar.aHt().size()) {
                    break;
                }
                mVar.aHt().get(i2).b(this.DQ, str.equals(mVar.aHt().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.ekD.add(mVar);
    }

    public boolean aLv() {
        return this.ekt;
    }

    public String aMa() {
        return this.eku;
    }

    public boolean isMarked() {
        return this.dYB;
    }

    public boolean aMb() {
        return HotTopicActivityConfig.ST_TYPE.equals(getStType());
    }

    public void hS(boolean z) {
        this.dYB = z;
    }

    public int aHf() {
        return this.dYa;
    }

    public String aMc() {
        return this.ekx;
    }

    public void oB(String str) {
        this.ekx = str;
    }

    public boolean aMd() {
        return this.ekw;
    }

    public String aMe() {
        return this.ekv;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fw(String str) {
        if (this.ejW == null || this.ejW.aHv() == null || this.ejW.Iw() == null || this.ejW.aHp() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.ejW.aHv().getName());
        writeData.setForumId(this.ejW.aHv().getId());
        writeData.setFloor(this.ejW.aHp().getId());
        writeData.setType(2);
        writeData.setThreadId(this.ejW.Iw().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public boolean BK() {
        return aLW();
    }

    public boolean aMf() {
        return this.ekF;
    }

    public void im(boolean z) {
        this.ekF = z;
    }

    public SmallTailInfo aMg() {
        return this.ekE;
    }

    public boolean aMh() {
        return this.ekB;
    }

    public ConcurrentHashMap<String, ImageUrlData> aMi() {
        return this.ekH;
    }

    public ArrayList<String> aMj() {
        return this.ekG;
    }

    public boolean aMk() {
        return this.ekI;
    }

    public int getOffset() {
        return this.mOffset;
    }
}
