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
    private TbPageContext<?> aaX;
    private com.baidu.tieba.tbadkCore.d.b bFk;
    private int efW;
    private AntiData egA;
    private boolean egB;
    private PbFakeFloorModel ela;
    private com.baidu.tieba.pb.data.j erT;
    private PbFakeFloorModel.a erW;
    private com.baidu.adp.framework.listener.a erX;
    private boolean etY;
    private String etZ;
    private String eua;
    private boolean eub;
    private String euc;
    private a eud;
    private int eue;
    private ArrayList<IconData> euf;
    private boolean eug;
    private ArrayList<com.baidu.tieba.pb.data.j> euh;
    private SmallTailInfo eui;
    private boolean euj;
    private ArrayList<String> euk;
    private ConcurrentHashMap<String, ImageUrlData> eul;
    private boolean eum;
    private boolean eun;
    private SubPbRequestMessage euo;
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
            this.etY = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.etZ = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eub = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eua = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.efW = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.eui = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.eui != null) {
                this.eui.updateShowInfo();
            }
            this.egA = (AntiData) intent.getSerializableExtra("anti");
            this.euf = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.eug = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.eul = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.eul.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.euk = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.eum = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.etY = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.etZ = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eub = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eua = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.efW = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.eui = (SmallTailInfo) bundle.getSerializable(SubPbActivityConfig.KEY_TAIL);
            if (this.eui != null) {
                this.eui.updateShowInfo();
            }
            this.egA = (AntiData) bundle.getSerializable("anti");
            this.euf = (ArrayList) bundle.getSerializable(SubPbActivityConfig.ICON_LIST);
            this.eug = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void p(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.etY);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.etZ);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.eua);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.eub);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.efW);
            bundle.putSerializable(SubPbActivityConfig.KEY_TAIL, this.eui);
            bundle.putSerializable("anti", this.egA);
            bundle.putSerializable(SubPbActivityConfig.ICON_LIST, this.euf);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.etY = false;
        this.etZ = null;
        this.eua = null;
        this.eub = false;
        this.egB = false;
        this.efW = 0;
        this.euc = null;
        this.aaX = null;
        this.erT = null;
        this.eud = null;
        this.eue = 0;
        this.eug = false;
        this.euh = null;
        this.isLoading = false;
        this.bFk = null;
        this.eum = true;
        this.mOffset = 0;
        this.ela = null;
        this.erW = null;
        this.eun = false;
        this.erX = new bc(this, CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.aaX = tbPageContext;
        this.euh = new ArrayList<>();
        this.erT = new com.baidu.tieba.pb.data.j();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.erX);
        registerListener(this.erX);
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

    public com.baidu.tieba.pb.data.j aON() {
        return this.erT;
    }

    public AntiData aws() {
        return this.egA;
    }

    public boolean aOO() {
        return (this.erT == null || this.erT.aJV() == null) ? false : true;
    }

    public void a(a aVar) {
        this.eud = aVar;
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
        markData.setFloor(postData.bio());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.erX);
        if (this.ela != null) {
            this.ela.unRegisterListener();
        }
        Wl();
    }

    private void Wl() {
        if (this.bFk != null) {
            this.bFk.destory();
            this.bFk = null;
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

    public void nQ(String str) {
        if (!TextUtils.isEmpty(str) && this.erT != null && this.erT.aJZ() != null) {
            ArrayList<PostData> aJZ = this.erT.aJZ();
            int size = aJZ.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aJZ.get(i).getId())) {
                    aJZ.remove(i);
                    this.eue++;
                    this.erT.setTotalCount(this.erT.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aOP() {
        int JG = this.erT.JG();
        if (JG == 0) {
            return JG + 1;
        }
        if (this.mLoadType == 0) {
            return JG + 1;
        }
        if (this.mLoadType == 2 && this.erT.aJZ().size() != 0 && this.erT.aJZ().size() % this.erT.aKa() == 0) {
            return JG + 1;
        }
        if (this.mLoadType == 3 && this.euj) {
            return this.erT.aJX() - 1;
        }
        if (this.mLoadType == 3 && JG > 0) {
            return this.erT.aJW() - 1;
        }
        return JG;
    }

    private SubPbRequestMessage aNW() {
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
            intValue = aOP();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.euj && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.aaX.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, af, ag, f, this.stType, i2);
    }

    public boolean FC() {
        return oz(0);
    }

    public boolean aOQ() {
        return oz(2);
    }

    public void aOR() {
        int aKa;
        if (this.eue > 0 && this.erT != null && (aKa = this.erT.aKa()) > 0) {
            int JG = this.erT.JG();
            for (int i = (((this.eue + aKa) - 1) / aKa) - 1; i >= 0; i--) {
                this.euo = c(Integer.valueOf(JG - i));
                this.euo.setTreatDelPage(true);
                sendMessage(this.euo);
            }
        }
        this.eue = 0;
    }

    public boolean aOS() {
        return oz(1);
    }

    public boolean aOT() {
        return oz(3);
    }

    public boolean oz(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        aOR();
        this.mLoadType = i;
        this.euo = aNW();
        sendMessage(this.euo);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.pb.data.j jVar) {
        ArrayList<PostData> aJZ = jVar.aJZ();
        if (aJZ == null || aJZ.size() == 0) {
            jVar.bX(this.erT.JG());
        }
        if (this.mLoadType == 1) {
            this.erT = jVar;
        } else if (this.mLoadType == 2) {
            this.erT.b(jVar, true);
        } else if (this.mLoadType == 3) {
            this.erT.a(jVar, false);
        } else {
            this.erT.b(jVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.pb.data.j jVar) {
        if (this.mLoadType == 1) {
            this.erT = jVar;
            this.erT.aJY();
        } else if (this.mLoadType == 2) {
            this.erT.c(jVar, true);
        } else if (this.mLoadType == 3) {
            this.erT.d(jVar, false);
        } else {
            this.erT.a(jVar);
        }
    }

    public void f(com.baidu.tieba.pb.data.j jVar) {
        String str;
        if (jVar.Kn() == null || jVar.Kn().getAuthor() == null) {
            str = null;
        } else {
            str = jVar.Kn().getAuthor().getUserId();
        }
        if (!this.euj) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jVar.aJZ().size()) {
                    break;
                }
                jVar.aJZ().get(i2).b(this.aaX, str.equals(jVar.aJZ().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.euh.add(jVar);
    }

    public boolean aOq() {
        return this.etY;
    }

    public boolean isMarked() {
        return this.egB;
    }

    public boolean aOU() {
        return "hot_topic".equals(getStType());
    }

    public void iE(boolean z) {
        this.egB = z;
    }

    public int aJH() {
        return this.efW;
    }

    public String aOV() {
        return this.euc;
    }

    public void nR(String str) {
        this.euc = str;
    }

    public boolean aOW() {
        return this.eub;
    }

    public String aOX() {
        return this.eua;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData ft(String str) {
        if (this.erT == null || this.erT.aKb() == null || this.erT.Kn() == null || this.erT.aJV() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.erT.aKb().getName());
        writeData.setForumId(this.erT.aKb().getId());
        writeData.setFloor(this.erT.aJV().getId());
        writeData.setType(2);
        writeData.setThreadId(this.erT.Kn().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean DI() {
        if (this.eun) {
            aOZ();
        } else {
            aOQ();
        }
        return true;
    }

    public boolean aOY() {
        return this.eun;
    }

    public void jb(boolean z) {
        this.eun = z;
    }

    private void aOZ() {
        if (this.ela == null) {
            this.ela = new PbFakeFloorModel(this.aaX);
            this.ela.setUniqueId(BdUniqueId.gen());
            this.ela.c(this.erT);
            this.ela.setPostId(this.postID);
            this.ela.a(this.erW);
        }
        this.ela.aNV();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.erW = aVar;
    }

    public boolean aPa() {
        return this.euj;
    }

    public void jc(boolean z) {
        this.euj = z;
    }

    public SmallTailInfo aPb() {
        return this.eui;
    }

    public boolean aPc() {
        return this.eug;
    }

    public ConcurrentHashMap<String, ImageUrlData> aPd() {
        return this.eul;
    }

    public ArrayList<String> aPe() {
        return this.euk;
    }

    public boolean aPf() {
        return this.eum;
    }

    public int getOffset() {
        return this.mOffset;
    }
}
