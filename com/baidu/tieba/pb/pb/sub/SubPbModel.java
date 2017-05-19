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
    private com.baidu.tieba.tbadkCore.d.b bHm;
    private AntiData edR;
    private boolean edS;
    private int eda;
    private PbFakeFloorModel ejo;
    private com.baidu.tieba.pb.data.l epO;
    private PbFakeFloorModel.a epR;
    private com.baidu.adp.framework.listener.a epS;
    private boolean erW;
    private String erX;
    private String erY;
    private String erZ;
    private boolean esa;
    private String esb;
    private a esc;
    private int esd;
    private ArrayList<IconData> ese;
    private boolean esf;
    private ArrayList<com.baidu.tieba.pb.data.l> esg;
    private SmallTailInfo esh;
    private boolean esi;
    private ArrayList<String> esj;
    private ConcurrentHashMap<String, ImageUrlData> esk;
    private boolean esl;
    private boolean esm;
    private SubPbRequestMessage esn;
    private boolean isLoading;
    private int mLoadType;
    private int mOffset;
    private String postID;
    private String stType;
    private String threadID;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, String str, com.baidu.tieba.pb.data.l lVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.erZ = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.erW = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.erX = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.esa = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.erY = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eda = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.esh = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.esh != null) {
                this.esh.updateShowInfo();
            }
            this.edR = (AntiData) intent.getSerializableExtra("anti");
            this.ese = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.esf = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.esk = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.esk.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.esj = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.esl = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.erZ = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.erW = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.erX = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.esa = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.erY = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eda = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.esh = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.esh != null) {
                this.esh.updateShowInfo();
            }
            this.edR = (AntiData) bundle.getSerializable("anti");
            this.ese = (ArrayList) bundle.getSerializable(SubPbActivityConfig.ICON_LIST);
            this.esf = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void p(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.erW);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.erX);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.erY);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.esa);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.eda);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.esh);
            bundle.putSerializable("anti", this.edR);
            bundle.putSerializable(SubPbActivityConfig.ICON_LIST, this.ese);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.erZ);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.erW = false;
        this.erX = null;
        this.erY = null;
        this.esa = false;
        this.edS = false;
        this.eda = 0;
        this.esb = null;
        this.aat = null;
        this.epO = null;
        this.esc = null;
        this.esd = 0;
        this.esf = false;
        this.esg = null;
        this.isLoading = false;
        this.bHm = null;
        this.esl = true;
        this.mOffset = 0;
        this.ejo = null;
        this.epR = null;
        this.esm = false;
        this.epS = new bc(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.aat = tbPageContext;
        this.esg = new ArrayList<>();
        this.epO = new com.baidu.tieba.pb.data.l();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.epS);
        registerListener(this.epS);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String CN() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.data.l aNe() {
        return this.epO;
    }

    public AntiData aup() {
        return this.edR;
    }

    public boolean aNf() {
        return (this.epO == null || this.epO.aIr() == null) ? false : true;
    }

    public void a(a aVar) {
        this.esc = aVar;
    }

    public MarkData g(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(postData.bgM());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.epS);
        if (this.ejo != null) {
            this.ejo.unRegisterListener();
        }
        WC();
    }

    private void WC() {
        if (this.bHm != null) {
            this.bHm.destory();
            this.bHm = null;
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

    public void nX(String str) {
        if (!TextUtils.isEmpty(str) && this.epO != null && this.epO.aIv() != null) {
            ArrayList<PostData> aIv = this.epO.aIv();
            int size = aIv.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aIv.get(i).getId())) {
                    aIv.remove(i);
                    this.esd++;
                    this.epO.setTotalCount(this.epO.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aNg() {
        int IU = this.epO.IU();
        if (IU == 0) {
            return IU + 1;
        }
        if (this.mLoadType == 0) {
            return IU + 1;
        }
        if (this.mLoadType == 2 && this.epO.aIv().size() != 0 && this.epO.aIv().size() % this.epO.aIw() == 0) {
            return IU + 1;
        }
        if (this.mLoadType == 3 && this.esi) {
            return this.epO.aIt() - 1;
        }
        if (this.mLoadType == 3 && IU > 0) {
            return this.epO.aIs() - 1;
        }
        return IU;
    }

    private SubPbRequestMessage aMm() {
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
            intValue = aNg();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.esi && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.aat.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, af, ag, f, this.stType, i2);
    }

    public boolean EG() {
        return ov(0);
    }

    public boolean aNh() {
        return ov(2);
    }

    public void aNi() {
        int aIw;
        if (this.esd > 0 && this.epO != null && (aIw = this.epO.aIw()) > 0) {
            int IU = this.epO.IU();
            for (int i = (((this.esd + aIw) - 1) / aIw) - 1; i >= 0; i--) {
                this.esn = c(Integer.valueOf(IU - i));
                this.esn.setTreatDelPage(true);
                sendMessage(this.esn);
            }
        }
        this.esd = 0;
    }

    public boolean aNj() {
        return ov(1);
    }

    public boolean aNk() {
        return ov(3);
    }

    public boolean ov(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        aNi();
        this.mLoadType = i;
        this.esn = aMm();
        sendMessage(this.esn);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.pb.data.l lVar) {
        ArrayList<PostData> aIv = lVar.aIv();
        if (aIv == null || aIv.size() == 0) {
            lVar.bV(this.epO.IU());
        }
        if (this.mLoadType == 1) {
            this.epO = lVar;
        } else if (this.mLoadType == 2) {
            this.epO.b(lVar, true);
        } else if (this.mLoadType == 3) {
            this.epO.a(lVar, false);
        } else {
            this.epO.b(lVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.pb.data.l lVar) {
        if (this.mLoadType == 1) {
            this.epO = lVar;
            this.epO.aIu();
        } else if (this.mLoadType == 2) {
            this.epO.c(lVar, true);
        } else if (this.mLoadType == 3) {
            this.epO.d(lVar, false);
        } else {
            this.epO.a(lVar);
        }
    }

    public void g(com.baidu.tieba.pb.data.l lVar) {
        String str;
        if (lVar.JB() == null || lVar.JB().getAuthor() == null) {
            str = null;
        } else {
            str = lVar.JB().getAuthor().getUserId();
        }
        if (!this.esi) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= lVar.aIv().size()) {
                    break;
                }
                lVar.aIv().get(i2).a(this.aat, str.equals(lVar.aIv().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.esg.add(lVar);
    }

    public boolean aMG() {
        return this.erW;
    }

    public boolean isMarked() {
        return this.edS;
    }

    public boolean aNl() {
        return "hot_topic".equals(getStType());
    }

    public void is(boolean z) {
        this.edS = z;
    }

    public int aHR() {
        return this.eda;
    }

    public String aNm() {
        return this.esb;
    }

    public void nY(String str) {
        this.esb = str;
    }

    public boolean aNn() {
        return this.esa;
    }

    public String aNo() {
        return this.erY;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fq(String str) {
        if (this.epO == null || this.epO.aIx() == null || this.epO.JB() == null || this.epO.aIr() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.epO.aIx().getName());
        writeData.setForumId(this.epO.aIx().getId());
        writeData.setFloor(this.epO.aIr().getId());
        writeData.setType(2);
        writeData.setThreadId(this.epO.JB().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean CM() {
        if (this.esm) {
            aNq();
        } else {
            aNh();
        }
        return true;
    }

    public boolean aNp() {
        return this.esm;
    }

    public void iQ(boolean z) {
        this.esm = z;
    }

    private void aNq() {
        if (this.ejo == null) {
            this.ejo = new PbFakeFloorModel(this.aat);
            this.ejo.setUniqueId(BdUniqueId.gen());
            this.ejo.d(this.epO);
            this.ejo.setPostId(this.postID);
            this.ejo.a(this.epR);
        }
        this.ejo.aMl();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.epR = aVar;
    }

    public boolean aNr() {
        return this.esi;
    }

    public void iR(boolean z) {
        this.esi = z;
    }

    public SmallTailInfo aNs() {
        return this.esh;
    }

    public boolean aNt() {
        return this.esf;
    }

    public ConcurrentHashMap<String, ImageUrlData> aNu() {
        return this.esk;
    }

    public ArrayList<String> aNv() {
        return this.esj;
    }

    public boolean aNw() {
        return this.esl;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String aNx() {
        return this.erZ;
    }
}
