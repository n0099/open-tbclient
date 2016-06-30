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
    private static BdAsyncTaskParallel dYa = new BdAsyncTaskParallel(BdAsyncTaskParallel.BdAsyncTaskParallelType.SERIAL, BdUniqueId.gen());
    private TbPageContext<?> Dp;
    private boolean awp;
    private com.baidu.tieba.tbadkCore.d.b btR;
    private int byt;
    private int dLR;
    private AntiData dMq;
    private boolean dMr;
    private boolean dXR;
    private String dXS;
    private String dXT;
    private boolean dXU;
    private String dXV;
    private a dXW;
    private int dXX;
    private ArrayList<IconData> dXY;
    private boolean dXZ;
    private com.baidu.tieba.pb.data.m dXu;
    private ArrayList<com.baidu.tieba.pb.data.m> dYb;
    private SmallTailInfo dYc;
    private boolean dYd;
    private ArrayList<String> dYe;
    private ConcurrentHashMap<String, ImageUrlData> dYf;
    private boolean dYg;
    private SubPbRequestMessage dYh;
    private com.baidu.adp.framework.listener.a dYi;
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
        a2.setParallel(dYa);
        a3.setParallel(dYa);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.dXR = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.dXS = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.dXU = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.dXT = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.dLR = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.dYc = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.dYc != null) {
                this.dYc.updateShowInfo();
            }
            this.dMq = (AntiData) intent.getSerializableExtra("anti");
            this.dXY = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.dXZ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.dYf = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.dYf.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.dYe = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.dYg = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.dXR = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.dXS = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.dXU = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.dXT = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.dLR = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.dYc = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.dYc != null) {
                this.dYc.updateShowInfo();
            }
            this.dMq = (AntiData) bundle.getSerializable("anti");
            this.dXY = (ArrayList) bundle.getSerializable(SubPbActivityConfig.ICON_LIST);
            this.dXZ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void q(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.dXR);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.dXS);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.dXT);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.dXU);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.dLR);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.dYc);
            bundle.putSerializable("anti", this.dMq);
            bundle.putSerializable(SubPbActivityConfig.ICON_LIST, this.dXY);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public aw(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.byt = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.dXR = false;
        this.dXS = null;
        this.dXT = null;
        this.dXU = false;
        this.dMr = false;
        this.dLR = 0;
        this.dXV = null;
        this.Dp = null;
        this.dXu = null;
        this.dXW = null;
        this.dXX = 0;
        this.dXZ = false;
        this.dYb = null;
        this.awp = false;
        this.btR = null;
        this.dYg = true;
        this.mOffset = 0;
        this.dYi = new ax(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.Dp = tbPageContext;
        this.dYb = new ArrayList<>();
        this.dXu = new com.baidu.tieba.pb.data.m();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.dYi);
        registerListener(this.dYi);
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

    public com.baidu.tieba.pb.data.m aIH() {
        return this.dXu;
    }

    public AntiData getAntiData() {
        return this.dMq;
    }

    public boolean aII() {
        return (this.dXu == null || this.dXu.aEe() == null) ? false : true;
    }

    public void a(a aVar) {
        this.dXW = aVar;
    }

    public MarkData d(com.baidu.tieba.tbadkCore.data.s sVar) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(sVar.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(sVar.bcm());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.dYi);
        Sv();
    }

    private void Sv() {
        if (this.btR != null) {
            this.btR.destory();
            this.btR = null;
        }
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    public int getLoadType() {
        return this.byt;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void nN(String str) {
        if (!TextUtils.isEmpty(str) && this.dXu != null && this.dXu.aEi() != null) {
            ArrayList<com.baidu.tieba.tbadkCore.data.s> aEi = this.dXu.aEi();
            int size = aEi.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aEi.get(i).getId())) {
                    aEi.remove(i);
                    this.dXX++;
                    this.dXu.setTotalCount(this.dXu.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aIJ() {
        int lo = this.dXu.lo();
        if (lo == 0) {
            return lo + 1;
        }
        if (this.byt == 0) {
            return lo + 1;
        }
        if (this.byt == 2 && this.dXu.aEi().size() != 0 && this.dXu.aEi().size() % this.dXu.aEk() == 0) {
            return lo + 1;
        }
        if (this.byt == 3 && this.dYd) {
            return this.dXu.aEg() - 1;
        }
        if (this.byt == 3 && lo > 0) {
            return this.dXu.aEf() - 1;
        }
        return lo;
    }

    private SubPbRequestMessage aIK() {
        this.awp = true;
        return c((Integer) null);
    }

    private SubPbRequestMessage c(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int A = com.baidu.adp.lib.util.k.A(TbadkCoreApplication.m9getInst().getApp());
        int B = com.baidu.adp.lib.util.k.B(TbadkCoreApplication.m9getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.byt) {
            j = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.h.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = aIJ();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.dYd && this.byt == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.Dp.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, A, B, f, this.stType, i2);
    }

    public boolean DH() {
        return nz(0);
    }

    public boolean aIL() {
        return nz(2);
    }

    public void aIM() {
        int aEk;
        if (this.dXX > 0 && this.dXu != null && (aEk = this.dXu.aEk()) > 0) {
            int lo = this.dXu.lo();
            for (int i = (((this.dXX + aEk) - 1) / aEk) - 1; i >= 0; i--) {
                this.dYh = c(Integer.valueOf(lo - i));
                this.dYh.setTreatDelPage(true);
                sendMessage(this.dYh);
            }
        }
        this.dXX = 0;
    }

    public boolean aIN() {
        return nz(1);
    }

    public boolean aIO() {
        return nz(3);
    }

    public boolean nz(int i) {
        if (this.awp) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.awp = false;
            return false;
        }
        aIM();
        this.byt = i;
        this.dYh = aIK();
        sendMessage(this.dYh);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.pb.data.m mVar) {
        ArrayList<com.baidu.tieba.tbadkCore.data.s> aEi = mVar.aEi();
        if (aEi == null || aEi.size() == 0) {
            mVar.aG(this.dXu.lo());
        }
        if (this.byt == 1) {
            this.dXu = mVar;
        } else if (this.byt == 2) {
            this.dXu.b(mVar, true);
        } else if (this.byt == 3) {
            this.dXu.a(mVar, false);
        } else {
            this.dXu.b(mVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.data.m mVar) {
        if (this.byt == 1) {
            this.dXu = mVar;
            this.dXu.aEh();
        } else if (this.byt == 2) {
            this.dXu.c(mVar, true);
        } else if (this.byt == 3) {
            this.dXu.d(mVar, false);
        } else {
            this.dXu.a(mVar);
        }
    }

    public void e(com.baidu.tieba.pb.data.m mVar) {
        String str;
        if (mVar.Ix() == null || mVar.Ix().getAuthor() == null) {
            str = null;
        } else {
            str = mVar.Ix().getAuthor().getUserId();
        }
        if (!this.dYd) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mVar.aEi().size()) {
                    break;
                }
                mVar.aEi().get(i2).b(this.Dp, str.equals(mVar.aEi().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.dYb.add(mVar);
    }

    public boolean aIk() {
        return this.dXR;
    }

    public String aIP() {
        return this.dXS;
    }

    public boolean isMarked() {
        return this.dMr;
    }

    public boolean aIQ() {
        return HotTopicActivityConfig.ST_TYPE.equals(getStType());
    }

    public void hG(boolean z) {
        this.dMr = z;
    }

    public int aDU() {
        return this.dLR;
    }

    public String aIR() {
        return this.dXV;
    }

    public void nO(String str) {
        this.dXV = str;
    }

    public boolean aIS() {
        return this.dXU;
    }

    public String aIT() {
        return this.dXT;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public WriteData fy(String str) {
        if (this.dXu == null || this.dXu.aEl() == null || this.dXu.Ix() == null || this.dXu.aEe() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.dXu.aEl().getName());
        writeData.setForumId(this.dXu.aEl().getId());
        writeData.setFloor(this.dXu.aEe().getId());
        writeData.setType(2);
        writeData.setThreadId(this.dXu.Ix().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.d.a
    public boolean BK() {
        return aIL();
    }

    public boolean aIU() {
        return this.dYd;
    }

    public void ia(boolean z) {
        this.dYd = z;
    }

    public SmallTailInfo aIV() {
        return this.dYc;
    }

    public boolean aIW() {
        return this.dXZ;
    }

    public ConcurrentHashMap<String, ImageUrlData> aIX() {
        return this.dYf;
    }

    public ArrayList<String> aIY() {
        return this.dYe;
    }

    public boolean aIZ() {
        return this.dYg;
    }

    public int getOffset() {
        return this.mOffset;
    }
}
