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
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class ap extends com.baidu.tbadk.editortools.d.a {
    private static BdAsyncTaskParallel dpG = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private TbPageContext<?> MX;
    private boolean azx;
    private com.baidu.tieba.tbadkCore.d.b bbO;
    private int bgJ;
    private String cwK;
    private int dcL;
    private AntiData ddd;
    private boolean dde;
    private String dpA;
    private boolean dpB;
    private String dpC;
    private a dpD;
    private int dpE;
    private boolean dpF;
    private ArrayList<com.baidu.tieba.pb.data.g> dpH;
    private SmallTailInfo dpI;
    private boolean dpJ;
    private ArrayList<String> dpK;
    private ConcurrentHashMap<String, ImageUrlData> dpL;
    private boolean dpM;
    private SubPbRequestMessage dpN;
    private com.baidu.adp.framework.listener.a dpO;
    private com.baidu.tieba.pb.data.g dpd;
    private boolean dpy;
    private String dpz;
    private int mOffset;
    private String postID;
    private String stType;
    private String threadID;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, String str, com.baidu.tieba.pb.data.g gVar);
    }

    static {
        com.baidu.tbadk.task.b a2 = com.baidu.tieba.tbadkCore.a.a.a(302002, SubPbSocketResponseMessage.class, false, false);
        TbHttpMessageTask a3 = com.baidu.tieba.tbadkCore.a.a.a(302002, CmdConfigHttp.SubPb_HTTP_CMD, "c/f/pb/floor", SubPbHttpResponseMessage.class, false, false, false, false);
        a2.setParallel(dpG);
        a3.setParallel(dpG);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.dpy = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.dpz = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.dpB = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.dpA = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.dcL = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.dpI = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.dpI != null) {
                this.dpI.updateShowInfo();
            }
            this.ddd = (AntiData) intent.getSerializableExtra("anti");
            this.dpF = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.dpL = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.dpL.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.dpK = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.dpM = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.dpy = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.dpz = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.dpB = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.dpA = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.dcL = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.dpI = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.dpI != null) {
                this.dpI.updateShowInfo();
            }
            this.ddd = (AntiData) bundle.getSerializable("anti");
            this.dpF = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void o(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.dpy);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.dpz);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.dpA);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.dpB);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.dcL);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.dpI);
            bundle.putSerializable("anti", this.ddd);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public ap(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.bgJ = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.dpy = false;
        this.dpz = null;
        this.cwK = null;
        this.dpA = null;
        this.dpB = false;
        this.dde = false;
        this.dcL = 0;
        this.dpC = null;
        this.MX = null;
        this.dpd = null;
        this.dpD = null;
        this.dpE = 0;
        this.dpF = false;
        this.dpH = null;
        this.azx = false;
        this.bbO = null;
        this.dpM = true;
        this.mOffset = 0;
        this.dpO = new aq(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.MX = tbPageContext;
        this.dpH = new ArrayList<>();
        this.dpd = new com.baidu.tieba.pb.data.g();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.dpO);
        registerListener(this.dpO);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public String DH() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.data.g aAg() {
        return this.dpd;
    }

    public AntiData amu() {
        return this.ddd;
    }

    public boolean aAh() {
        return (this.dpd == null || this.dpd.avI() == null) ? false : true;
    }

    public void a(a aVar) {
        this.dpD = aVar;
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
        markData.setFloor(sVar.aTs());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.dpO);
        Oe();
    }

    private void Oe() {
        if (this.bbO != null) {
            this.bbO.destory();
            this.bbO = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int getLoadType() {
        return this.bgJ;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void mi(String str) {
        if (!TextUtils.isEmpty(str) && this.dpd != null && this.dpd.avM() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.s> avM = this.dpd.avM();
            int size = avM.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(avM.get(i).getId())) {
                    avM.remove(i);
                    this.dpE++;
                    this.dpd.setTotalCount(this.dpd.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aAi() {
        int oX = this.dpd.oX();
        if (oX == 0) {
            return oX + 1;
        }
        if (this.bgJ == 0) {
            return oX + 1;
        }
        if (this.bgJ == 2 && this.dpd.avM().size() != 0 && this.dpd.avM().size() % this.dpd.avO() == 0) {
            return oX + 1;
        }
        if (this.bgJ == 3 && this.dpJ) {
            return this.dpd.avK() - 1;
        }
        if (this.bgJ == 3 && oX > 0) {
            return this.dpd.avJ() - 1;
        }
        return oX;
    }

    private SubPbRequestMessage aAj() {
        this.azx = true;
        return c((Integer) null);
    }

    private SubPbRequestMessage c(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.m411getInst().getApp().getResources().getDisplayMetrics().density;
        int B = com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m411getInst().getApp());
        int C = com.baidu.adp.lib.util.k.C(TbadkCoreApplication.m411getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.bgJ) {
            j = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = aAi();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.dpJ && this.bgJ == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.MX.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, B, C, f, this.stType, i2);
    }

    public boolean FG() {
        return mq(0);
    }

    public boolean aAk() {
        return mq(2);
    }

    public void aAl() {
        int avO;
        if (this.dpE > 0 && this.dpd != null && (avO = this.dpd.avO()) > 0) {
            int oX = this.dpd.oX();
            for (int i = (((this.dpE + avO) - 1) / avO) - 1; i >= 0; i--) {
                this.dpN = c(Integer.valueOf(oX - i));
                this.dpN.setTreatDelPage(true);
                sendMessage(this.dpN);
            }
        }
        this.dpE = 0;
    }

    public boolean aAm() {
        return mq(1);
    }

    public boolean aAn() {
        return mq(3);
    }

    public boolean mq(int i) {
        if (this.azx) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.azx = false;
            return false;
        }
        aAl();
        this.bgJ = i;
        this.dpN = aAj();
        sendMessage(this.dpN);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.data.g gVar) {
        ArrayList<com.baidu.tieba.tbadkCore.data.s> avM = gVar.avM();
        if (avM == null || avM.size() == 0) {
            gVar.aS(this.dpd.oX());
        }
        if (this.bgJ == 1) {
            this.dpd = gVar;
        } else if (this.bgJ == 2) {
            this.dpd.b(gVar, true);
        } else if (this.bgJ == 3) {
            this.dpd.a(gVar, false);
        } else {
            this.dpd.b(gVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.data.g gVar) {
        if (this.bgJ == 1) {
            this.dpd = gVar;
            this.dpd.avL();
        } else if (this.bgJ == 2) {
            this.dpd.c(gVar, true);
        } else if (this.bgJ == 3) {
            this.dpd.d(gVar, false);
        } else {
            this.dpd.a(gVar);
        }
    }

    public void e(com.baidu.tieba.pb.data.g gVar) {
        String str;
        if (gVar.LC() == null || gVar.LC().getAuthor() == null) {
            str = null;
        } else {
            str = gVar.LC().getAuthor().getUserId();
        }
        if (!this.dpJ) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= gVar.avM().size()) {
                    break;
                }
                gVar.avM().get(i2).b(this.MX, str.equals(gVar.avM().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.dpH.add(gVar);
    }

    public boolean azB() {
        return this.dpy;
    }

    public String aAo() {
        return this.dpz;
    }

    public boolean isMarked() {
        return this.dde;
    }

    public boolean aAp() {
        return HotTopicActivityConfig.ST_TYPE.equals(getStType());
    }

    public void gk(boolean z) {
        this.dde = z;
    }

    public int avB() {
        return this.dcL;
    }

    public String aAq() {
        return this.dpC;
    }

    public void mj(String str) {
        this.dpC = str;
    }

    public boolean aAr() {
        return this.dpB;
    }

    public String aAs() {
        return this.dpA;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fv(String str) {
        if (this.dpd == null || this.dpd.avP() == null || this.dpd.LC() == null || this.dpd.avI() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.dpd.avP().getName());
        writeData.setForumId(this.dpd.avP().getId());
        writeData.setFloor(this.dpd.avI().getId());
        writeData.setType(2);
        writeData.setThreadId(this.dpd.LC().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public boolean DG() {
        return aAk();
    }

    public boolean aAt() {
        return this.dpJ;
    }

    public void gB(boolean z) {
        this.dpJ = z;
    }

    public SmallTailInfo aAu() {
        return this.dpI;
    }

    public boolean aAv() {
        return this.dpF;
    }

    public ConcurrentHashMap<String, ImageUrlData> aAw() {
        return this.dpL;
    }

    public ArrayList<String> aAx() {
        return this.dpK;
    }

    public boolean aAy() {
        return this.dpM;
    }

    public int getOffset() {
        return this.mOffset;
    }
}
