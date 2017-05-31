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
    private TbPageContext<?> aas;
    private com.baidu.tieba.tbadkCore.d.b bNa;
    private int eix;
    private AntiData ejr;
    private boolean ejs;
    private PbFakeFloorModel epa;
    private com.baidu.tieba.pb.data.n ewW;
    private PbFakeFloorModel.a ewZ;
    private com.baidu.adp.framework.listener.a exa;
    private boolean ezi;
    private String ezj;
    private String ezk;
    private String ezl;
    private boolean ezm;
    private String ezn;
    private a ezo;
    private int ezp;
    private ArrayList<IconData> ezq;
    private boolean ezr;
    private ArrayList<com.baidu.tieba.pb.data.n> ezs;
    private SmallTailInfo ezt;
    private boolean ezu;
    private ArrayList<String> ezv;
    private ConcurrentHashMap<String, ImageUrlData> ezw;
    private boolean ezx;
    private boolean ezy;
    private SubPbRequestMessage ezz;
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
            this.ezl = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.ezi = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.ezj = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.ezm = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.ezk = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eix = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.ezt = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.ezt != null) {
                this.ezt.updateShowInfo();
            }
            this.ejr = (AntiData) intent.getSerializableExtra("anti");
            this.ezq = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.ezr = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.ezw = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.ezw.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.ezv = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.ezx = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.ezl = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.ezi = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.ezj = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.ezm = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.ezk = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eix = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.ezt = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.ezt != null) {
                this.ezt.updateShowInfo();
            }
            this.ejr = (AntiData) bundle.getSerializable("anti");
            this.ezq = (ArrayList) bundle.getSerializable(SubPbActivityConfig.ICON_LIST);
            this.ezr = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void p(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.ezi);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.ezj);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.ezk);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.ezm);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.eix);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.ezt);
            bundle.putSerializable("anti", this.ejr);
            bundle.putSerializable(SubPbActivityConfig.ICON_LIST, this.ezq);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.ezl);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.ezi = false;
        this.ezj = null;
        this.ezk = null;
        this.ezm = false;
        this.ejs = false;
        this.eix = 0;
        this.ezn = null;
        this.aas = null;
        this.ewW = null;
        this.ezo = null;
        this.ezp = 0;
        this.ezr = false;
        this.ezs = null;
        this.isLoading = false;
        this.bNa = null;
        this.ezx = true;
        this.mOffset = 0;
        this.epa = null;
        this.ewZ = null;
        this.ezy = false;
        this.exa = new bc(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.aas = tbPageContext;
        this.ezs = new ArrayList<>();
        this.ewW = new com.baidu.tieba.pb.data.n();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.exa);
        registerListener(this.exa);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String CH() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public com.baidu.tieba.pb.data.n aOn() {
        return this.ewW;
    }

    public AntiData avj() {
        return this.ejr;
    }

    public boolean aOo() {
        return (this.ewW == null || this.ewW.aJj() == null) ? false : true;
    }

    public void a(a aVar) {
        this.ezo = aVar;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(postData.big());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.exa);
        if (this.epa != null) {
            this.epa.unRegisterListener();
        }
        XF();
    }

    private void XF() {
        if (this.bNa != null) {
            this.bNa.destory();
            this.bNa = null;
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

    public void ol(String str) {
        if (!TextUtils.isEmpty(str) && this.ewW != null && this.ewW.aJn() != null) {
            ArrayList<PostData> aJn = this.ewW.aJn();
            int size = aJn.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aJn.get(i).getId())) {
                    aJn.remove(i);
                    this.ezp++;
                    this.ewW.setTotalCount(this.ewW.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aOp() {
        int IQ = this.ewW.IQ();
        if (IQ == 0) {
            return IQ + 1;
        }
        if (this.mLoadType == 0) {
            return IQ + 1;
        }
        if (this.mLoadType == 2 && this.ewW.aJn().size() != 0 && this.ewW.aJn().size() % this.ewW.aJo() == 0) {
            return IQ + 1;
        }
        if (this.mLoadType == 3 && this.ezu) {
            return this.ewW.aJl() - 1;
        }
        if (this.mLoadType == 3 && IQ > 0) {
            return this.ewW.aJk() - 1;
        }
        return IQ;
    }

    private SubPbRequestMessage aNw() {
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
            intValue = aOp();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.ezu && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.aas.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, af, ag, f, this.stType, i2);
    }

    public boolean EA() {
        return oT(0);
    }

    public boolean aOq() {
        return oT(2);
    }

    public void aOr() {
        int aJo;
        if (this.ezp > 0 && this.ewW != null && (aJo = this.ewW.aJo()) > 0) {
            int IQ = this.ewW.IQ();
            for (int i = (((this.ezp + aJo) - 1) / aJo) - 1; i >= 0; i--) {
                this.ezz = c(Integer.valueOf(IQ - i));
                this.ezz.setTreatDelPage(true);
                sendMessage(this.ezz);
            }
        }
        this.ezp = 0;
    }

    public boolean aOs() {
        return oT(1);
    }

    public boolean aOt() {
        return oT(3);
    }

    public boolean oT(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        aOr();
        this.mLoadType = i;
        this.ezz = aNw();
        sendMessage(this.ezz);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.pb.data.n nVar) {
        ArrayList<PostData> aJn = nVar.aJn();
        if (aJn == null || aJn.size() == 0) {
            nVar.bW(this.ewW.IQ());
        }
        if (this.mLoadType == 1) {
            this.ewW = nVar;
        } else if (this.mLoadType == 2) {
            this.ewW.b(nVar, true);
        } else if (this.mLoadType == 3) {
            this.ewW.a(nVar, false);
        } else {
            this.ewW.b(nVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.tieba.pb.data.n nVar) {
        if (this.mLoadType == 1) {
            this.ewW = nVar;
            this.ewW.aJm();
        } else if (this.mLoadType == 2) {
            this.ewW.c(nVar, true);
        } else if (this.mLoadType == 3) {
            this.ewW.d(nVar, false);
        } else {
            this.ewW.a(nVar);
        }
    }

    public void g(com.baidu.tieba.pb.data.n nVar) {
        String str;
        if (nVar.LH() == null || nVar.LH().getAuthor() == null) {
            str = null;
        } else {
            str = nVar.LH().getAuthor().getUserId();
        }
        if (!this.ezu) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= nVar.aJn().size()) {
                    break;
                }
                nVar.aJn().get(i2).a(this.aas, str.equals(nVar.aJn().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.ezs.add(nVar);
    }

    public boolean aNP() {
        return this.ezi;
    }

    public boolean isMarked() {
        return this.ejs;
    }

    public boolean aOu() {
        return "hot_topic".equals(getStType());
    }

    public void iI(boolean z) {
        this.ejs = z;
    }

    public int aIM() {
        return this.eix;
    }

    public String aOv() {
        return this.ezn;
    }

    public void om(String str) {
        this.ezn = str;
    }

    public boolean aOw() {
        return this.ezm;
    }

    public String aOx() {
        return this.ezk;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fo(String str) {
        if (this.ewW == null || this.ewW.aJp() == null || this.ewW.LH() == null || this.ewW.aJj() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.ewW.aJp().getName());
        writeData.setForumId(this.ewW.aJp().getId());
        writeData.setFloor(this.ewW.aJj().getId());
        writeData.setType(2);
        writeData.setThreadId(this.ewW.LH().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean CG() {
        if (this.ezy) {
            aOz();
        } else {
            aOq();
        }
        return true;
    }

    public boolean aOy() {
        return this.ezy;
    }

    public void ji(boolean z) {
        this.ezy = z;
    }

    private void aOz() {
        if (this.epa == null) {
            this.epa = new PbFakeFloorModel(this.aas);
            this.epa.setUniqueId(BdUniqueId.gen());
            this.epa.d(this.ewW);
            this.epa.setPostId(this.postID);
            this.epa.a(this.ewZ);
        }
        this.epa.aNv();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.ewZ = aVar;
    }

    public boolean aOA() {
        return this.ezu;
    }

    public void jj(boolean z) {
        this.ezu = z;
    }

    public SmallTailInfo aOB() {
        return this.ezt;
    }

    public boolean aOC() {
        return this.ezr;
    }

    public ConcurrentHashMap<String, ImageUrlData> aOD() {
        return this.ezw;
    }

    public ArrayList<String> aOE() {
        return this.ezv;
    }

    public boolean aOF() {
        return this.ezx;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String aOG() {
        return this.ezl;
    }
}
