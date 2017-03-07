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
    private TbPageContext<?> aaI;
    private com.baidu.tieba.tbadkCore.d.b bFr;
    private int ehP;
    private AntiData eit;
    private boolean eiu;
    private PbFakeFloorModel emS;
    private com.baidu.tieba.pb.data.j etQ;
    private PbFakeFloorModel.a etT;
    private com.baidu.adp.framework.listener.a etU;
    private boolean evT;
    private String evU;
    private String evV;
    private boolean evW;
    private String evX;
    private a evY;
    private int evZ;
    private ArrayList<IconData> ewa;
    private boolean ewb;
    private ArrayList<com.baidu.tieba.pb.data.j> ewc;
    private SmallTailInfo ewd;
    private boolean ewe;
    private ArrayList<String> ewf;
    private ConcurrentHashMap<String, ImageUrlData> ewg;
    private boolean ewh;
    private boolean ewi;
    private SubPbRequestMessage ewj;
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
            this.evT = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.evU = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.evW = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.evV = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.ehP = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.ewd = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.ewd != null) {
                this.ewd.updateShowInfo();
            }
            this.eit = (AntiData) intent.getSerializableExtra("anti");
            this.ewa = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.ewb = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.ewg = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.ewg.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.ewf = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.ewh = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.evT = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.evU = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.evW = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.evV = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.ehP = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.ewd = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.ewd != null) {
                this.ewd.updateShowInfo();
            }
            this.eit = (AntiData) bundle.getSerializable("anti");
            this.ewa = (ArrayList) bundle.getSerializable(SubPbActivityConfig.ICON_LIST);
            this.ewb = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void o(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.evT);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.evU);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.evV);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.evW);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.ehP);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.ewd);
            bundle.putSerializable("anti", this.eit);
            bundle.putSerializable(SubPbActivityConfig.ICON_LIST, this.ewa);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.evT = false;
        this.evU = null;
        this.evV = null;
        this.evW = false;
        this.eiu = false;
        this.ehP = 0;
        this.evX = null;
        this.aaI = null;
        this.etQ = null;
        this.evY = null;
        this.evZ = 0;
        this.ewb = false;
        this.ewc = null;
        this.isLoading = false;
        this.bFr = null;
        this.ewh = true;
        this.mOffset = 0;
        this.emS = null;
        this.etT = null;
        this.ewi = false;
        this.etU = new bc(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.aaI = tbPageContext;
        this.ewc = new ArrayList<>();
        this.etQ = new com.baidu.tieba.pb.data.j();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.etU);
        registerListener(this.etU);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dl() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.data.j aOE() {
        return this.etQ;
    }

    public AntiData awz() {
        return this.eit;
    }

    public boolean aOF() {
        return (this.etQ == null || this.etQ.aJO() == null) ? false : true;
    }

    public void a(a aVar) {
        this.evY = aVar;
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
        markData.setFloor(postData.bhD());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.etU);
        if (this.emS != null) {
            this.emS.unRegisterListener();
        }
        VN();
    }

    private void VN() {
        if (this.bFr != null) {
            this.bFr.destory();
            this.bFr = null;
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

    public void nM(String str) {
        if (!TextUtils.isEmpty(str) && this.etQ != null && this.etQ.aJS() != null) {
            ArrayList<PostData> aJS = this.etQ.aJS();
            int size = aJS.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aJS.get(i).getId())) {
                    aJS.remove(i);
                    this.evZ++;
                    this.etQ.setTotalCount(this.etQ.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aOG() {
        int Jg = this.etQ.Jg();
        if (Jg == 0) {
            return Jg + 1;
        }
        if (this.mLoadType == 0) {
            return Jg + 1;
        }
        if (this.mLoadType == 2 && this.etQ.aJS().size() != 0 && this.etQ.aJS().size() % this.etQ.aJT() == 0) {
            return Jg + 1;
        }
        if (this.mLoadType == 3 && this.ewe) {
            return this.etQ.aJQ() - 1;
        }
        if (this.mLoadType == 3 && Jg > 0) {
            return this.etQ.aJP() - 1;
        }
        return Jg;
    }

    private SubPbRequestMessage aNN() {
        this.isLoading = true;
        return c((Integer) null);
    }

    private SubPbRequestMessage c(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.m9getInst().getApp().getResources().getDisplayMetrics().density;
        int ag = com.baidu.adp.lib.util.k.ag(TbadkCoreApplication.m9getInst().getApp());
        int ah = com.baidu.adp.lib.util.k.ah(TbadkCoreApplication.m9getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = aOG();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.ewe && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.aaI.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, ag, ah, f, this.stType, i2);
    }

    public boolean Fe() {
        return oB(0);
    }

    public boolean aOH() {
        return oB(2);
    }

    public void aOI() {
        int aJT;
        if (this.evZ > 0 && this.etQ != null && (aJT = this.etQ.aJT()) > 0) {
            int Jg = this.etQ.Jg();
            for (int i = (((this.evZ + aJT) - 1) / aJT) - 1; i >= 0; i--) {
                this.ewj = c(Integer.valueOf(Jg - i));
                this.ewj.setTreatDelPage(true);
                sendMessage(this.ewj);
            }
        }
        this.evZ = 0;
    }

    public boolean aOJ() {
        return oB(1);
    }

    public boolean aOK() {
        return oB(3);
    }

    public boolean oB(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        aOI();
        this.mLoadType = i;
        this.ewj = aNN();
        sendMessage(this.ewj);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.data.j jVar) {
        ArrayList<PostData> aJS = jVar.aJS();
        if (aJS == null || aJS.size() == 0) {
            jVar.bU(this.etQ.Jg());
        }
        if (this.mLoadType == 1) {
            this.etQ = jVar;
        } else if (this.mLoadType == 2) {
            this.etQ.b(jVar, true);
        } else if (this.mLoadType == 3) {
            this.etQ.a(jVar, false);
        } else {
            this.etQ.b(jVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.pb.data.j jVar) {
        if (this.mLoadType == 1) {
            this.etQ = jVar;
            this.etQ.aJR();
        } else if (this.mLoadType == 2) {
            this.etQ.c(jVar, true);
        } else if (this.mLoadType == 3) {
            this.etQ.d(jVar, false);
        } else {
            this.etQ.a(jVar);
        }
    }

    public void f(com.baidu.tieba.pb.data.j jVar) {
        String str;
        if (jVar.JN() == null || jVar.JN().getAuthor() == null) {
            str = null;
        } else {
            str = jVar.JN().getAuthor().getUserId();
        }
        if (!this.ewe) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jVar.aJS().size()) {
                    break;
                }
                jVar.aJS().get(i2).b(this.aaI, str.equals(jVar.aJS().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.ewc.add(jVar);
    }

    public boolean aOh() {
        return this.evT;
    }

    public boolean isMarked() {
        return this.eiu;
    }

    public boolean aOL() {
        return "hot_topic".equals(getStType());
    }

    public void iF(boolean z) {
        this.eiu = z;
    }

    public int aJA() {
        return this.ehP;
    }

    public String aOM() {
        return this.evX;
    }

    public void nN(String str) {
        this.evX = str;
    }

    public boolean aON() {
        return this.evW;
    }

    public String aOO() {
        return this.evV;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fn(String str) {
        if (this.etQ == null || this.etQ.aJU() == null || this.etQ.JN() == null || this.etQ.aJO() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.etQ.aJU().getName());
        writeData.setForumId(this.etQ.aJU().getId());
        writeData.setFloor(this.etQ.aJO().getId());
        writeData.setType(2);
        writeData.setThreadId(this.etQ.JN().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dk() {
        if (this.ewi) {
            aOQ();
        } else {
            aOH();
        }
        return true;
    }

    public boolean aOP() {
        return this.ewi;
    }

    public void jc(boolean z) {
        this.ewi = z;
    }

    private void aOQ() {
        if (this.emS == null) {
            this.emS = new PbFakeFloorModel(this.aaI);
            this.emS.setUniqueId(BdUniqueId.gen());
            this.emS.c(this.etQ);
            this.emS.setPostId(this.postID);
            this.emS.a(this.etT);
        }
        this.emS.aNM();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.etT = aVar;
    }

    public boolean aOR() {
        return this.ewe;
    }

    public void jd(boolean z) {
        this.ewe = z;
    }

    public SmallTailInfo aOS() {
        return this.ewd;
    }

    public boolean aOT() {
        return this.ewb;
    }

    public ConcurrentHashMap<String, ImageUrlData> aOU() {
        return this.ewg;
    }

    public ArrayList<String> aOV() {
        return this.ewf;
    }

    public boolean aOW() {
        return this.ewh;
    }

    public int getOffset() {
        return this.mOffset;
    }
}
