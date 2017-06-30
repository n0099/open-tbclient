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
    private TbPageContext<?> aat;
    private com.baidu.tieba.tbadkCore.d.b bTD;
    private com.baidu.tieba.pb.data.n eGs;
    private PbFakeFloorModel.a eGv;
    private com.baidu.adp.framework.listener.a eGw;
    private boolean eIE;
    private String eIF;
    private String eIG;
    private String eIH;
    private boolean eII;
    private String eIJ;
    private a eIK;
    private int eIL;
    private ArrayList<IconData> eIM;
    private boolean eIN;
    private ArrayList<com.baidu.tieba.pb.data.n> eIO;
    private SmallTailInfo eIP;
    private boolean eIQ;
    private ArrayList<String> eIR;
    private ConcurrentHashMap<String, ImageUrlData> eIS;
    private boolean eIT;
    private boolean eIU;
    private SubPbRequestMessage eIV;
    private int eru;
    private AntiData esp;
    private boolean esq;
    private PbFakeFloorModel eyj;
    private boolean isLoading;
    private int mLoadType;
    private int mOffset;
    private String postID;
    private String stType;
    private String threadID;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, String str, com.baidu.tieba.pb.data.n nVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.eIH = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.eIE = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eIF = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eII = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eIG = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eru = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.eIP = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.eIP != null) {
                this.eIP.updateShowInfo();
            }
            this.esp = (AntiData) intent.getSerializableExtra("anti");
            this.eIM = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.eIN = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.eIS = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.eIS.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.eIR = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.eIT = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.eIH = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.eIE = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eIF = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eII = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eIG = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eru = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.eIP = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.eIP != null) {
                this.eIP.updateShowInfo();
            }
            this.esp = (AntiData) bundle.getSerializable("anti");
            this.eIM = (ArrayList) bundle.getSerializable(SubPbActivityConfig.ICON_LIST);
            this.eIN = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void p(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.eIE);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.eIF);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.eIG);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.eII);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.eru);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.eIP);
            bundle.putSerializable("anti", this.esp);
            bundle.putSerializable(SubPbActivityConfig.ICON_LIST, this.eIM);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.eIH);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.eIE = false;
        this.eIF = null;
        this.eIG = null;
        this.eII = false;
        this.esq = false;
        this.eru = 0;
        this.eIJ = null;
        this.aat = null;
        this.eGs = null;
        this.eIK = null;
        this.eIL = 0;
        this.eIN = false;
        this.eIO = null;
        this.isLoading = false;
        this.bTD = null;
        this.eIT = true;
        this.mOffset = 0;
        this.eyj = null;
        this.eGv = null;
        this.eIU = false;
        this.eGw = new bc(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.aat = tbPageContext;
        this.eIO = new ArrayList<>();
        this.eGs = new com.baidu.tieba.pb.data.n();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.eGw);
        registerListener(this.eGw);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Db() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.data.n aSm() {
        return this.eGs;
    }

    public AntiData azh() {
        return this.esp;
    }

    public boolean aSn() {
        return (this.eGs == null || this.eGs.aNd() == null) ? false : true;
    }

    public void a(a aVar) {
        this.eIK = aVar;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(postData.bmu());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.eGw);
        if (this.eyj != null) {
            this.eyj.unRegisterListener();
        }
        abd();
    }

    private void abd() {
        if (this.bTD != null) {
            this.bTD.destory();
            this.bTD = null;
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

    public void pf(String str) {
        if (!TextUtils.isEmpty(str) && this.eGs != null && this.eGs.aNh() != null) {
            ArrayList<PostData> aNh = this.eGs.aNh();
            int size = aNh.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aNh.get(i).getId())) {
                    aNh.remove(i);
                    this.eIL++;
                    this.eGs.setTotalCount(this.eGs.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aSo() {
        int Jo = this.eGs.Jo();
        if (Jo == 0) {
            return Jo + 1;
        }
        if (this.mLoadType == 0) {
            return Jo + 1;
        }
        if (this.mLoadType == 2 && this.eGs.aNh().size() != 0 && this.eGs.aNh().size() % this.eGs.aNi() == 0) {
            return Jo + 1;
        }
        if (this.mLoadType == 3 && this.eIQ) {
            return this.eGs.aNf() - 1;
        }
        if (this.mLoadType == 3 && Jo > 0) {
            return this.eGs.aNe() - 1;
        }
        return Jo;
    }

    private SubPbRequestMessage aRw() {
        this.isLoading = true;
        return g((Integer) null);
    }

    private SubPbRequestMessage g(Integer num) {
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
            intValue = aSo();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.eIQ && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.aat.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, af, ag, f, this.stType, i2);
    }

    public boolean EX() {
        return pm(0);
    }

    public boolean aSp() {
        return pm(2);
    }

    public void aSq() {
        int aNi;
        if (this.eIL > 0 && this.eGs != null && (aNi = this.eGs.aNi()) > 0) {
            int Jo = this.eGs.Jo();
            for (int i = (((this.eIL + aNi) - 1) / aNi) - 1; i >= 0; i--) {
                this.eIV = g(Integer.valueOf(Jo - i));
                this.eIV.setTreatDelPage(true);
                sendMessage(this.eIV);
            }
        }
        this.eIL = 0;
    }

    public boolean aSr() {
        return pm(1);
    }

    public boolean aSs() {
        return pm(3);
    }

    public boolean pm(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        aSq();
        this.mLoadType = i;
        this.eIV = aRw();
        sendMessage(this.eIV);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.pb.data.n nVar) {
        ArrayList<PostData> aNh = nVar.aNh();
        if (aNh == null || aNh.size() == 0) {
            nVar.bW(this.eGs.Jo());
        }
        if (this.mLoadType == 1) {
            this.eGs = nVar;
        } else if (this.mLoadType == 2) {
            this.eGs.b(nVar, true);
        } else if (this.mLoadType == 3) {
            this.eGs.a(nVar, false);
        } else {
            this.eGs.b(nVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.pb.data.n nVar) {
        if (this.mLoadType == 1) {
            this.eGs = nVar;
            this.eGs.aNg();
        } else if (this.mLoadType == 2) {
            this.eGs.c(nVar, true);
        } else if (this.mLoadType == 3) {
            this.eGs.d(nVar, false);
        } else {
            this.eGs.a(nVar);
        }
    }

    public void g(com.baidu.tieba.pb.data.n nVar) {
        String str;
        if (nVar.Mv() == null || nVar.Mv().getAuthor() == null) {
            str = null;
        } else {
            str = nVar.Mv().getAuthor().getUserId();
        }
        if (!this.eIQ) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= nVar.aNh().size()) {
                    break;
                }
                nVar.aNh().get(i2).a(this.aat, str.equals(nVar.aNh().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.eIO.add(nVar);
    }

    public boolean aRO() {
        return this.eIE;
    }

    public boolean isMarked() {
        return this.esq;
    }

    public boolean aSt() {
        return "hot_topic".equals(getStType());
    }

    public void je(boolean z) {
        this.esq = z;
    }

    public int aMG() {
        return this.eru;
    }

    public String aSu() {
        return this.eIJ;
    }

    public void pg(String str) {
        this.eIJ = str;
    }

    public boolean aSv() {
        return this.eII;
    }

    public String aSw() {
        return this.eIG;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fI(String str) {
        if (this.eGs == null || this.eGs.aNj() == null || this.eGs.Mv() == null || this.eGs.aNd() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.eGs.aNj().getName());
        writeData.setForumId(this.eGs.aNj().getId());
        writeData.setFloor(this.eGs.aNd().getId());
        writeData.setType(2);
        writeData.setThreadId(this.eGs.Mv().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Da() {
        if (this.eIU) {
            aSy();
        } else {
            aSp();
        }
        return true;
    }

    public boolean aSx() {
        return this.eIU;
    }

    public void jG(boolean z) {
        this.eIU = z;
    }

    private void aSy() {
        if (this.eyj == null) {
            this.eyj = new PbFakeFloorModel(this.aat);
            this.eyj.setUniqueId(BdUniqueId.gen());
            this.eyj.d(this.eGs);
            this.eyj.setPostId(this.postID);
            this.eyj.a(this.eGv);
        }
        this.eyj.aRv();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.eGv = aVar;
    }

    public boolean aSz() {
        return this.eIQ;
    }

    public void jH(boolean z) {
        this.eIQ = z;
    }

    public SmallTailInfo aSA() {
        return this.eIP;
    }

    public boolean aSB() {
        return this.eIN;
    }

    public ConcurrentHashMap<String, ImageUrlData> aSC() {
        return this.eIS;
    }

    public ArrayList<String> aSD() {
        return this.eIR;
    }

    public boolean aSE() {
        return this.eIT;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String aSF() {
        return this.eIH;
    }
}
