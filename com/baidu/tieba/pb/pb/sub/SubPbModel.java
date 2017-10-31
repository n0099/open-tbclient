package com.baidu.tieba.pb.pb.sub;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.data.m;
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
    private TbPageContext<?> abI;
    private com.baidu.tieba.tbadkCore.d.b ckI;
    private int eGj;
    private AntiData eHg;
    private boolean eHh;
    private PbFakeFloorModel eNI;
    private m eYb;
    private PbFakeFloorModel.a eYe;
    private com.baidu.adp.framework.listener.a eYf;
    private String faA;
    private a faB;
    private int faC;
    private ArrayList<IconData> faD;
    private boolean faE;
    private ArrayList<m> faF;
    private SmallTailInfo faG;
    private boolean faH;
    private ArrayList<String> faI;
    private ConcurrentHashMap<String, ImageUrlData> faJ;
    private boolean faK;
    private boolean faL;
    private SubPbRequestMessage faM;
    private boolean fav;
    private String faw;
    private String fax;
    private String fay;
    private boolean faz;
    private boolean isLoading;
    private int mLoadType;
    private int mOffset;
    private String postID;
    private String stType;
    private String threadID;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, String str, m mVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.fay = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fav = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.faw = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.faz = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fax = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eGj = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.faG = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.faG != null) {
                this.faG.updateShowInfo();
            }
            this.eHg = (AntiData) intent.getSerializableExtra("anti");
            this.faD = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.faE = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.faJ = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.faJ.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.faI = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.faK = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.fay = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fav = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.faw = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.faz = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fax = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eGj = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.faG = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.faG != null) {
                this.faG.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.eHg = new AntiData();
                this.eHg.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.v(stringArrayList)) {
                this.faD = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.faD.add(iconData);
                    }
                }
            }
            this.faE = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void t(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fav);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.faw);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.fax);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.faz);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.eGj);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.faG));
            if (this.eHg != null) {
                bundle.putSerializable("anti", this.eHg.toJsonString());
            }
            if (!v.v(this.faD)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.faD.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.fay);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.fav = false;
        this.faw = null;
        this.fax = null;
        this.faz = false;
        this.eHh = false;
        this.eGj = 0;
        this.faA = null;
        this.abI = null;
        this.eYb = null;
        this.faB = null;
        this.faC = 0;
        this.faE = false;
        this.faF = null;
        this.isLoading = false;
        this.ckI = null;
        this.faK = true;
        this.mOffset = 0;
        this.eNI = null;
        this.eYe = null;
        this.faL = false;
        this.eYf = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                boolean z;
                m mVar;
                long j2;
                long j3;
                long j4 = 0;
                String str = null;
                if (SubPbModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    SubPbModel.this.isLoading = false;
                    if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                        SubPbModel.this.abI.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.g(subPbHttpResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                        j = costTime;
                        z = true;
                    } else {
                        j = 0;
                        z = false;
                    }
                    if (responsedMessage instanceof SubPbSocketResponseMessage) {
                        j4 = responsedMessage.getCostTime();
                        SubPbSocketResponseMessage subPbSocketResponseMessage = (SubPbSocketResponseMessage) responsedMessage;
                        if (subPbSocketResponseMessage.isTreatDelPage()) {
                            if (!subPbSocketResponseMessage.hasError()) {
                                SubPbModel.this.g(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.faF != null && SubPbModel.this.faF.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.faF.size() - 1; size >= 0; size--) {
                                m mVar2 = (m) SubPbModel.this.faF.get(size);
                                if (SubPbModel.this.faH) {
                                    SubPbModel.this.eYb.c(mVar2, true);
                                } else {
                                    SubPbModel.this.eYb.b(mVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.faF.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.ckI == null) {
                        SubPbModel.this.ckI = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.ckI != null) {
                        if (error == 0) {
                            int i = -1;
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                i = ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                                j2 = j4;
                                j3 = responsedMessage.getCostTime();
                            } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                                i = ((SubPbSocketResponseMessage) responsedMessage).getDownSize();
                                j2 = responsedMessage.getCostTime();
                                j3 = j;
                            } else {
                                j2 = j4;
                                j3 = j;
                            }
                            SubPbModel.this.ckI.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.ckI = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.ckI = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.faB != null) {
                                SubPbModel.this.faB.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                mVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (mVar.aQx().errorno.intValue() != 0) {
                                if (SubPbModel.this.faB != null) {
                                    SubPbModel.this.faB.a(false, mVar.eHi.errorno.intValue(), mVar.eHi.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (mVar.Np() != null && mVar.Np().rt() != null) {
                                str = mVar.Np().rt().getUserId();
                                if (v.v(mVar.aQy().rt().getIconInfo()) && SubPbModel.this.faD != null) {
                                    mVar.aQy().rt().setIconInfo(SubPbModel.this.faD);
                                }
                            }
                            if (!SubPbModel.this.faH) {
                                for (int i2 = 0; i2 < mVar.aQC().size(); i2++) {
                                    mVar.aQC().get(i2).b(SubPbModel.this.abI, str.equals(mVar.aQC().get(i2).rt().getUserId()));
                                }
                            }
                            if (mVar.aQy() != null) {
                                SubPbModel.this.postID = mVar.aQy().getId();
                            }
                            if (mVar.Np() != null) {
                                SubPbModel.this.threadID = mVar.Np().getId();
                                SubPbModel.this.eHh = mVar.nC();
                                SubPbModel.this.faA = mVar.Np().rD();
                            }
                            if (SubPbModel.this.faA != null && SubPbModel.this.postID != null && SubPbModel.this.faA.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.eHh = true;
                            }
                            if (SubPbModel.this.faH) {
                                SubPbModel.this.f(mVar);
                            } else {
                                SubPbModel.this.e(mVar);
                            }
                            if (SubPbModel.this.faB != null) {
                                SubPbModel.this.faB.a(SubPbModel.this.aWC(), error, errorString, SubPbModel.this.eYb);
                            }
                        }
                    }
                }
            }
        };
        this.abI = tbPageContext;
        this.faF = new ArrayList<>();
        this.eYb = new m();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.eYf);
        registerListener(this.eYf);
    }

    public String aSz() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dc() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public m aWB() {
        return this.eYb;
    }

    public AntiData aEB() {
        return this.eHg;
    }

    public boolean aWC() {
        return (this.eYb == null || this.eYb.aQy() == null) ? false : true;
    }

    public void a(a aVar) {
        this.faB = aVar;
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
        markData.setFloor(postData.buu());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.eYf);
        if (this.eNI != null) {
            this.eNI.unRegisterListener();
        }
        afn();
    }

    private void afn() {
        if (this.ckI != null) {
            this.ckI.destory();
            this.ckI = null;
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

    public void pR(String str) {
        if (!TextUtils.isEmpty(str) && this.eYb != null && this.eYb.aQC() != null) {
            ArrayList<PostData> aQC = this.eYb.aQC();
            int size = aQC.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aQC.get(i).getId())) {
                    aQC.remove(i);
                    this.faC++;
                    this.eYb.setTotalCount(this.eYb.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aWD() {
        int Kb = this.eYb.Kb();
        if (Kb == 0) {
            return Kb + 1;
        }
        if (this.mLoadType == 0) {
            return Kb + 1;
        }
        if (this.mLoadType == 2 && this.eYb.aQC().size() != 0 && this.eYb.aQC().size() % this.eYb.aQE() == 0) {
            return Kb + 1;
        }
        if (this.mLoadType == 3 && this.faH) {
            return this.eYb.aQA() - 1;
        }
        if (this.mLoadType == 3 && Kb > 0) {
            return this.eYb.aQz() - 1;
        }
        return Kb;
    }

    private SubPbRequestMessage aVT() {
        this.isLoading = true;
        return h((Integer) null);
    }

    private SubPbRequestMessage h(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ac = l.ac(TbadkCoreApplication.getInst().getApp());
        int ae = l.ae(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = aWD();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.faH && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.abI.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, ac, ae, f, this.stType, i2);
    }

    public boolean Ff() {
        return qd(0);
    }

    public boolean aWE() {
        return qd(2);
    }

    public void aWF() {
        int aQE;
        if (this.faC > 0 && this.eYb != null && (aQE = this.eYb.aQE()) > 0) {
            int Kb = this.eYb.Kb();
            for (int i = (((this.faC + aQE) - 1) / aQE) - 1; i >= 0; i--) {
                this.faM = h(Integer.valueOf(Kb - i));
                this.faM.setTreatDelPage(true);
                sendMessage(this.faM);
            }
        }
        this.faC = 0;
    }

    public boolean aWG() {
        return qd(1);
    }

    public boolean aWH() {
        return qd(3);
    }

    public boolean qd(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        aWF();
        this.mLoadType = i;
        this.faM = aVT();
        sendMessage(this.faM);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        ArrayList<PostData> aQC = mVar.aQC();
        if (aQC == null || aQC.size() == 0) {
            mVar.bX(this.eYb.Kb());
        }
        if (this.mLoadType == 1) {
            this.eYb = mVar;
        } else if (this.mLoadType == 2) {
            this.eYb.b(mVar, true);
        } else if (this.mLoadType == 3) {
            this.eYb.a(mVar, false);
        } else {
            this.eYb.b(mVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(m mVar) {
        if (this.mLoadType == 1) {
            this.eYb = mVar;
            this.eYb.aQB();
        } else if (this.mLoadType == 2) {
            this.eYb.c(mVar, true);
        } else if (this.mLoadType == 3) {
            this.eYb.d(mVar, false);
        } else {
            this.eYb.a(mVar);
        }
    }

    public void g(m mVar) {
        String str;
        if (mVar.Np() == null || mVar.Np().rt() == null) {
            str = null;
        } else {
            str = mVar.Np().rt().getUserId();
        }
        if (!this.faH) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mVar.aQC().size()) {
                    break;
                }
                mVar.aQC().get(i2).b(this.abI, str.equals(mVar.aQC().get(i2).rt().getUserId()));
                i = i2 + 1;
            }
        }
        this.faF.add(mVar);
    }

    public boolean aWf() {
        return this.fav;
    }

    public boolean isMarked() {
        return this.eHh;
    }

    public boolean aWI() {
        return "hot_topic".equals(getStType());
    }

    public void jL(boolean z) {
        this.eHh = z;
    }

    public int aPZ() {
        return this.eGj;
    }

    public String aWJ() {
        return this.faA;
    }

    public void pS(String str) {
        this.faA = str;
    }

    public boolean aWK() {
        return this.faz;
    }

    public String aWL() {
        return this.fax;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fP(String str) {
        if (this.eYb == null || this.eYb.aQF() == null || this.eYb.Np() == null || this.eYb.aQy() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.eYb.aQF().getName());
        writeData.setForumId(this.eYb.aQF().getId());
        writeData.setFloor(this.eYb.aQy().getId());
        writeData.setType(2);
        writeData.setThreadId(this.eYb.Np().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Db() {
        if (this.faL) {
            aWN();
        } else {
            aWE();
        }
        return true;
    }

    public boolean aWM() {
        return this.faL;
    }

    public void jM(boolean z) {
        this.faL = z;
    }

    private void aWN() {
        if (this.eNI == null) {
            this.eNI = new PbFakeFloorModel(this.abI);
            this.eNI.setUniqueId(BdUniqueId.gen());
            this.eNI.d(this.eYb);
            this.eNI.setPostId(this.postID);
            this.eNI.a(this.eYe);
        }
        this.eNI.aVS();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.eYe = aVar;
    }

    public boolean aWO() {
        return this.faH;
    }

    public void jN(boolean z) {
        this.faH = z;
    }

    public SmallTailInfo aWP() {
        return this.faG;
    }

    public boolean aWQ() {
        return this.faE;
    }

    public ConcurrentHashMap<String, ImageUrlData> aWR() {
        return this.faJ;
    }

    public ArrayList<String> aWS() {
        return this.faI;
    }

    public boolean aWT() {
        return this.faK;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String aWU() {
        return this.fay;
    }
}
