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
public class ap extends com.baidu.tbadk.editortools.d.a {
    private static BdAsyncTaskParallel drp = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private TbPageContext<?> Do;
    private com.baidu.tieba.tbadkCore.d.b aXX;
    private boolean avz;
    private int bcy;
    private String cxH;
    private int dff;
    private AntiData dfx;
    private boolean dfy;
    private com.baidu.tieba.pb.data.h dqL;
    private boolean drg;
    private String drh;
    private String dri;
    private boolean drj;
    private String drk;
    private a drl;
    private int drm;
    private ArrayList<IconData> drn;
    private boolean dro;
    private ArrayList<com.baidu.tieba.pb.data.h> drq;
    private SmallTailInfo drr;
    private boolean drs;
    private ArrayList<String> drt;
    private ConcurrentHashMap<String, ImageUrlData> dru;
    private boolean drv;
    private SubPbRequestMessage drw;
    private com.baidu.adp.framework.listener.a drx;
    private int mOffset;
    private String postID;
    private String stType;
    private String threadID;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, String str, com.baidu.tieba.pb.data.h hVar);
    }

    static {
        com.baidu.tbadk.task.b a2 = com.baidu.tieba.tbadkCore.a.a.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a3 = com.baidu.tieba.tbadkCore.a.a.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a2.setParallel(drp);
        a3.setParallel(drp);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.drg = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.drh = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.drj = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.dri = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.dff = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.drr = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.drr != null) {
                this.drr.updateShowInfo();
            }
            this.dfx = (AntiData) intent.getSerializableExtra("anti");
            this.drn = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.dro = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.dru = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.dru.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.drt = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.drv = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.drg = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.drh = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.drj = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.dri = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.dff = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.drr = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.drr != null) {
                this.drr.updateShowInfo();
            }
            this.dfx = (AntiData) bundle.getSerializable("anti");
            this.drn = (ArrayList) bundle.getSerializable(SubPbActivityConfig.ICON_LIST);
            this.dro = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void p(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.drg);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.drh);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.dri);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.drj);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.dff);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.drr);
            bundle.putSerializable("anti", this.dfx);
            bundle.putSerializable(SubPbActivityConfig.ICON_LIST, this.drn);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public ap(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bcy = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.drg = false;
        this.drh = null;
        this.cxH = null;
        this.dri = null;
        this.drj = false;
        this.dfy = false;
        this.dff = 0;
        this.drk = null;
        this.Do = null;
        this.dqL = null;
        this.drl = null;
        this.drm = 0;
        this.dro = false;
        this.drq = null;
        this.avz = false;
        this.aXX = null;
        this.drv = true;
        this.mOffset = 0;
        this.drx = new aq(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.Do = tbPageContext;
        this.drq = new ArrayList<>();
        this.dqL = new com.baidu.tieba.pb.data.h();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.drx);
        registerListener(this.drx);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String BC() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.data.h aAq() {
        return this.dqL;
    }

    public AntiData getAntiData() {
        return this.dfx;
    }

    public boolean aAr() {
        return (this.dqL == null || this.dqL.avR() == null) ? false : true;
    }

    public void a(a aVar) {
        this.drl = aVar;
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
        markData.setFloor(sVar.aTY());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.drx);
        MT();
    }

    private void MT() {
        if (this.aXX != null) {
            this.aXX.destory();
            this.aXX = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int getLoadType() {
        return this.bcy;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void mm(String str) {
        if (!TextUtils.isEmpty(str) && this.dqL != null && this.dqL.avV() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.s> avV = this.dqL.avV();
            int size = avV.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(avV.get(i).getId())) {
                    avV.remove(i);
                    this.drm++;
                    this.dqL.setTotalCount(this.dqL.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aAs() {
        int lk = this.dqL.lk();
        if (lk == 0) {
            return lk + 1;
        }
        if (this.bcy == 0) {
            return lk + 1;
        }
        if (this.bcy == 2 && this.dqL.avV().size() != 0 && this.dqL.avV().size() % this.dqL.avX() == 0) {
            return lk + 1;
        }
        if (this.bcy == 3 && this.drs) {
            return this.dqL.avT() - 1;
        }
        if (this.bcy == 3 && lk > 0) {
            return this.dqL.avS() - 1;
        }
        return lk;
    }

    private SubPbRequestMessage aAt() {
        this.avz = true;
        return c((Integer) null);
    }

    private SubPbRequestMessage c(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.m11getInst().getApp().getResources().getDisplayMetrics().density;
        int B = com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m11getInst().getApp());
        int C = com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m11getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.bcy) {
            j = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = aAs();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.drs && this.bcy == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.Do.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, B, C, f, this.stType, i2);
    }

    public boolean Dz() {
        return ma(0);
    }

    public boolean aAu() {
        return ma(2);
    }

    public void aAv() {
        int avX;
        if (this.drm > 0 && this.dqL != null && (avX = this.dqL.avX()) > 0) {
            int lk = this.dqL.lk();
            for (int i = (((this.drm + avX) - 1) / avX) - 1; i >= 0; i--) {
                this.drw = c(Integer.valueOf(lk - i));
                this.drw.setTreatDelPage(true);
                sendMessage(this.drw);
            }
        }
        this.drm = 0;
    }

    public boolean aAw() {
        return ma(1);
    }

    public boolean aAx() {
        return ma(3);
    }

    public boolean ma(int i) {
        if (this.avz) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.avz = false;
            return false;
        }
        aAv();
        this.bcy = i;
        this.drw = aAt();
        sendMessage(this.drw);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.data.h hVar) {
        ArrayList<com.baidu.tieba.tbadkCore.data.s> avV = hVar.avV();
        if (avV == null || avV.size() == 0) {
            hVar.aF(this.dqL.lk());
        }
        if (this.bcy == 1) {
            this.dqL = hVar;
        } else if (this.bcy == 2) {
            this.dqL.b(hVar, true);
        } else if (this.bcy == 3) {
            this.dqL.a(hVar, false);
        } else {
            this.dqL.b(hVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.data.h hVar) {
        if (this.bcy == 1) {
            this.dqL = hVar;
            this.dqL.avU();
        } else if (this.bcy == 2) {
            this.dqL.c(hVar, true);
        } else if (this.bcy == 3) {
            this.dqL.d(hVar, false);
        } else {
            this.dqL.a(hVar);
        }
    }

    public void e(com.baidu.tieba.pb.data.h hVar) {
        String str;
        if (hVar.Kn() == null || hVar.Kn().getAuthor() == null) {
            str = null;
        } else {
            str = hVar.Kn().getAuthor().getUserId();
        }
        if (!this.drs) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= hVar.avV().size()) {
                    break;
                }
                hVar.avV().get(i2).b(this.Do, str.equals(hVar.avV().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.drq.add(hVar);
    }

    public boolean aAy() {
        return this.drg;
    }

    public String aAz() {
        return this.drh;
    }

    public boolean isMarked() {
        return this.dfy;
    }

    public boolean aAA() {
        return HotTopicActivityConfig.ST_TYPE.equals(getStType());
    }

    public void gN(boolean z) {
        this.dfy = z;
    }

    public int avK() {
        return this.dff;
    }

    public String aAB() {
        return this.drk;
    }

    public void mn(String str) {
        this.drk = str;
    }

    public boolean aAC() {
        return this.drj;
    }

    public String aAD() {
        return this.dri;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fs(String str) {
        if (this.dqL == null || this.dqL.avY() == null || this.dqL.Kn() == null || this.dqL.avR() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.dqL.avY().getName());
        writeData.setForumId(this.dqL.avY().getId());
        writeData.setFloor(this.dqL.avR().getId());
        writeData.setType(2);
        writeData.setThreadId(this.dqL.Kn().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public boolean BB() {
        return aAu();
    }

    public boolean aAE() {
        return this.drs;
    }

    public void hg(boolean z) {
        this.drs = z;
    }

    public SmallTailInfo aAF() {
        return this.drr;
    }

    public boolean aAG() {
        return this.dro;
    }

    public ConcurrentHashMap<String, ImageUrlData> aAH() {
        return this.dru;
    }

    public ArrayList<String> aAI() {
        return this.drt;
    }

    public boolean aAJ() {
        return this.drv;
    }

    public int getOffset() {
        return this.mOffset;
    }
}
