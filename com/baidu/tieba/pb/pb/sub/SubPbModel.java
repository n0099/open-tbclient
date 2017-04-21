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
import com.baidu.tieba.tbadkCore.data.PostData;
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
    private TbPageContext<?> aaY;
    private com.baidu.tieba.tbadkCore.d.b bHB;
    private AntiData eiQ;
    private boolean eiR;
    private int eim;
    private PbFakeFloorModel ens;
    private com.baidu.tieba.pb.data.j eul;
    private PbFakeFloorModel.a euo;
    private com.baidu.adp.framework.listener.a eup;
    private ArrayList<String> ewA;
    private ConcurrentHashMap<String, ImageUrlData> ewB;
    private boolean ewC;
    private boolean ewD;
    private SubPbRequestMessage ewE;
    private boolean ewo;
    private String ewp;
    private String ewq;
    private boolean ewr;
    private String ews;
    private a ewt;
    private int ewu;
    private ArrayList<IconData> ewv;
    private boolean eww;
    private ArrayList<com.baidu.tieba.pb.data.j> ewx;
    private SmallTailInfo ewy;
    private boolean ewz;
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
            this.ewo = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.ewp = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.ewr = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.ewq = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eim = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.ewy = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.ewy != null) {
                this.ewy.updateShowInfo();
            }
            this.eiQ = (AntiData) intent.getSerializableExtra("anti");
            this.ewv = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.eww = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.ewB = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.ewB.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.ewA = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.ewC = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.ewo = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.ewp = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.ewr = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.ewq = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eim = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.ewy = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.ewy != null) {
                this.ewy.updateShowInfo();
            }
            this.eiQ = (AntiData) bundle.getSerializable("anti");
            this.ewv = (ArrayList) bundle.getSerializable(SubPbActivityConfig.ICON_LIST);
            this.eww = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void p(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.ewo);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.ewp);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.ewq);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.ewr);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.eim);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.ewy);
            bundle.putSerializable("anti", this.eiQ);
            bundle.putSerializable(SubPbActivityConfig.ICON_LIST, this.ewv);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.ewo = false;
        this.ewp = null;
        this.ewq = null;
        this.ewr = false;
        this.eiR = false;
        this.eim = 0;
        this.ews = null;
        this.aaY = null;
        this.eul = null;
        this.ewt = null;
        this.ewu = 0;
        this.eww = false;
        this.ewx = null;
        this.isLoading = false;
        this.bHB = null;
        this.ewC = true;
        this.mOffset = 0;
        this.ens = null;
        this.euo = null;
        this.ewD = false;
        this.eup = new bc(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.aaY = tbPageContext;
        this.ewx = new ArrayList<>();
        this.eul = new com.baidu.tieba.pb.data.j();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.eup);
        registerListener(this.eup);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String DJ() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.data.j aPO() {
        return this.eul;
    }

    public AntiData axt() {
        return this.eiQ;
    }

    public boolean aPP() {
        return (this.eul == null || this.eul.aKW() == null) ? false : true;
    }

    public void a(a aVar) {
        this.ewt = aVar;
    }

    public MarkData e(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(postData.bjp());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.eup);
        if (this.ens != null) {
            this.ens.unRegisterListener();
        }
        Xm();
    }

    private void Xm() {
        if (this.bHB != null) {
            this.bHB.destory();
            this.bHB = null;
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

    public void nR(String str) {
        if (!TextUtils.isEmpty(str) && this.eul != null && this.eul.aLa() != null) {
            ArrayList<PostData> aLa = this.eul.aLa();
            int size = aLa.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aLa.get(i).getId())) {
                    aLa.remove(i);
                    this.ewu++;
                    this.eul.setTotalCount(this.eul.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aPQ() {
        int JG = this.eul.JG();
        if (JG == 0) {
            return JG + 1;
        }
        if (this.mLoadType == 0) {
            return JG + 1;
        }
        if (this.mLoadType == 2 && this.eul.aLa().size() != 0 && this.eul.aLa().size() % this.eul.aLb() == 0) {
            return JG + 1;
        }
        if (this.mLoadType == 3 && this.ewz) {
            return this.eul.aKY() - 1;
        }
        if (this.mLoadType == 3 && JG > 0) {
            return this.eul.aKX() - 1;
        }
        return JG;
    }

    private SubPbRequestMessage aOX() {
        this.isLoading = true;
        return c((Integer) null);
    }

    private SubPbRequestMessage c(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int af = com.baidu.adp.lib.util.k.af(TbadkCoreApplication.m9getInst().getApp());
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = aPQ();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.ewz && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.aaY.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, af, ag, f, this.stType, i2);
    }

    public boolean FC() {
        return oF(0);
    }

    public boolean aPR() {
        return oF(2);
    }

    public void aPS() {
        int aLb;
        if (this.ewu > 0 && this.eul != null && (aLb = this.eul.aLb()) > 0) {
            int JG = this.eul.JG();
            for (int i = (((this.ewu + aLb) - 1) / aLb) - 1; i >= 0; i--) {
                this.ewE = c(Integer.valueOf(JG - i));
                this.ewE.setTreatDelPage(true);
                sendMessage(this.ewE);
            }
        }
        this.ewu = 0;
    }

    public boolean aPT() {
        return oF(1);
    }

    public boolean aPU() {
        return oF(3);
    }

    public boolean oF(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        aPS();
        this.mLoadType = i;
        this.ewE = aOX();
        sendMessage(this.ewE);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.data.j jVar) {
        ArrayList<PostData> aLa = jVar.aLa();
        if (aLa == null || aLa.size() == 0) {
            jVar.bX(this.eul.JG());
        }
        if (this.mLoadType == 1) {
            this.eul = jVar;
        } else if (this.mLoadType == 2) {
            this.eul.b(jVar, true);
        } else if (this.mLoadType == 3) {
            this.eul.a(jVar, false);
        } else {
            this.eul.b(jVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.pb.data.j jVar) {
        if (this.mLoadType == 1) {
            this.eul = jVar;
            this.eul.aKZ();
        } else if (this.mLoadType == 2) {
            this.eul.c(jVar, true);
        } else if (this.mLoadType == 3) {
            this.eul.d(jVar, false);
        } else {
            this.eul.a(jVar);
        }
    }

    public void f(com.baidu.tieba.pb.data.j jVar) {
        String str;
        if (jVar.Kn() == null || jVar.Kn().getAuthor() == null) {
            str = null;
        } else {
            str = jVar.Kn().getAuthor().getUserId();
        }
        if (!this.ewz) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jVar.aLa().size()) {
                    break;
                }
                jVar.aLa().get(i2).b(this.aaY, str.equals(jVar.aLa().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.ewx.add(jVar);
    }

    public boolean aPr() {
        return this.ewo;
    }

    public boolean isMarked() {
        return this.eiR;
    }

    public boolean aPV() {
        return "hot_topic".equals(getStType());
    }

    public void iO(boolean z) {
        this.eiR = z;
    }

    public int aKI() {
        return this.eim;
    }

    public String aPW() {
        return this.ews;
    }

    public void nS(String str) {
        this.ews = str;
    }

    public boolean aPX() {
        return this.ewr;
    }

    public String aPY() {
        return this.ewq;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData ft(String str) {
        if (this.eul == null || this.eul.aLc() == null || this.eul.Kn() == null || this.eul.aKW() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.eul.aLc().getName());
        writeData.setForumId(this.eul.aLc().getId());
        writeData.setFloor(this.eul.aKW().getId());
        writeData.setType(2);
        writeData.setThreadId(this.eul.Kn().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean DI() {
        if (this.ewD) {
            aQa();
        } else {
            aPR();
        }
        return true;
    }

    public boolean aPZ() {
        return this.ewD;
    }

    public void jl(boolean z) {
        this.ewD = z;
    }

    private void aQa() {
        if (this.ens == null) {
            this.ens = new PbFakeFloorModel(this.aaY);
            this.ens.setUniqueId(BdUniqueId.gen());
            this.ens.c(this.eul);
            this.ens.setPostId(this.postID);
            this.ens.a(this.euo);
        }
        this.ens.aOW();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.euo = aVar;
    }

    public boolean aQb() {
        return this.ewz;
    }

    public void jm(boolean z) {
        this.ewz = z;
    }

    public SmallTailInfo aQc() {
        return this.ewy;
    }

    public boolean aQd() {
        return this.eww;
    }

    public ConcurrentHashMap<String, ImageUrlData> aQe() {
        return this.ewB;
    }

    public ArrayList<String> aQf() {
        return this.ewA;
    }

    public boolean aQg() {
        return this.ewC;
    }

    public int getOffset() {
        return this.mOffset;
    }
}
