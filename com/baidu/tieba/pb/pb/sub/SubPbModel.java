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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private TbPageContext<?> dPv;
    private int eLu;
    private boolean efN;
    private AntiData ejE;
    private com.baidu.tieba.tbadkCore.d.b hfy;
    private boolean isLoading;
    private int jYW;
    private boolean kam;
    private PbFakeFloorModel keK;
    private n kse;
    private PbFakeFloorModel.a ksh;
    private com.baidu.adp.framework.listener.a ksi;
    private String kuE;
    private String kuF;
    private String kuG;
    private String kuH;
    private String kuI;
    private String kuJ;
    private boolean kuK;
    private String kuL;
    private a kuM;
    private int kuN;
    private ArrayList<IconData> kuO;
    private AttentionHostData kuP;
    private boolean kuQ;
    private ArrayList<n> kuR;
    private SmallTailInfo kuS;
    private boolean kuT;
    private ArrayList<String> kuU;
    private ConcurrentHashMap<String, ImageUrlData> kuV;
    private boolean kuW;
    private boolean kuX;
    private SubPbRequestMessage kuY;
    private int mOffset;
    private String oriUgcNid;
    private String oriUgcTid;
    private String oriUgcTopPid;
    private int oriUgcType;
    private String oriUgcVid;
    public int pageFromType;
    private String postID;
    private String stType;

    /* loaded from: classes9.dex */
    public interface a {
        void a(boolean z, int i, String str, n nVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.kuE = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.kuI = intent.getStringExtra("from_forum_id");
            this.kuJ = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.efN = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.kuF = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.kuK = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.kuG = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.jYW = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.kuS = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.kuS != null) {
                this.kuS.updateShowInfo();
            }
            this.ejE = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.kuO = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.kuQ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.kuV = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.kuV.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.kuU = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.kuW = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.kuH = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.kuE = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.kuI = bundle.getString("from_forum_id");
            this.kuJ = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.efN = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.kuF = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.kuK = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.kuG = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.jYW = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.kuS = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.kuS != null) {
                this.kuS.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.ejE = new AntiData();
                this.ejE.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!w.isEmpty(stringArrayList)) {
                this.kuO = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.kuO.add(iconData);
                    }
                }
            }
            this.kuQ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.kuH = bundle.getString("high_light_post_id");
        }
    }

    public void aC(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.kuE);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.efN);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.kuF);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.kuG);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.kuK);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.jYW);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.kuS));
            if (this.ejE != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.ejE.toJsonString());
            }
            if (!w.isEmpty(this.kuO)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.kuO.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.kuI);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.kuJ);
            bundle.putString("high_light_post_id", this.kuH);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eLu = 0;
        this.kuE = null;
        this.postID = null;
        this.stType = null;
        this.efN = false;
        this.kuF = null;
        this.kuG = null;
        this.kuH = null;
        this.pageFromType = 0;
        this.kuK = false;
        this.kam = false;
        this.jYW = 0;
        this.kuL = null;
        this.dPv = null;
        this.kse = null;
        this.kuM = null;
        this.kuN = 0;
        this.kuQ = false;
        this.kuR = null;
        this.isLoading = false;
        this.hfy = null;
        this.kuW = true;
        this.mOffset = 0;
        this.keK = null;
        this.ksh = null;
        this.kuX = false;
        this.ksi = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                boolean z;
                n nVar;
                long j2;
                long j3;
                long j4 = 0;
                if (SubPbModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    SubPbModel.this.isLoading = false;
                    if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                        SubPbModel.this.dPv.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.kuR.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.kuR.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.kuR != null && SubPbModel.this.kuR.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.kuR.size() - 1; size >= 0; size--) {
                                n nVar2 = (n) SubPbModel.this.kuR.get(size);
                                if (SubPbModel.this.kuT) {
                                    SubPbModel.this.kse.c(nVar2, true);
                                } else {
                                    SubPbModel.this.kse.b(nVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.kuR.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.hfy == null) {
                        SubPbModel.this.hfy = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.hfy != null) {
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
                            SubPbModel.this.hfy.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.hfy = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.hfy = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.kuM != null) {
                                SubPbModel.this.kuM.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                nVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                nVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (nVar.cHH().errorno.intValue() != 0) {
                                if (SubPbModel.this.kuM != null) {
                                    SubPbModel.this.kuM.a(false, nVar.kan.errorno.intValue(), nVar.kan.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (nVar.aPS() != null && nVar.aPS().aSp() != null) {
                                nVar.aPS().aSp().getUserId();
                                if (w.isEmpty(nVar.cHI().aSp().getIconInfo()) && SubPbModel.this.kuO != null) {
                                    nVar.cHI().aSp().setIconInfo(SubPbModel.this.kuO);
                                }
                            }
                            if (nVar.cHI() != null) {
                                SubPbModel.this.postID = nVar.cHI().getId();
                            }
                            if (nVar.aPS() != null) {
                                SubPbModel.this.kuE = nVar.aPS().getId();
                                SubPbModel.this.kam = nVar.aOo();
                                SubPbModel.this.kuL = nVar.aPS().aSx();
                            }
                            if (SubPbModel.this.kuL != null && SubPbModel.this.postID != null && SubPbModel.this.kuL.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.kam = true;
                            }
                            if (SubPbModel.this.kuT) {
                                SubPbModel.this.f(nVar);
                            } else {
                                SubPbModel.this.e(nVar);
                            }
                            if (SubPbModel.this.kuM != null) {
                                SubPbModel.this.kuM.a(SubPbModel.this.cOu(), error, errorString, SubPbModel.this.kse);
                            }
                        }
                    }
                }
            }
        };
        this.dPv = tbPageContext;
        this.kuR = new ArrayList<>();
        this.kse = new n();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.ksi);
        registerListener(this.ksi);
    }

    public String cJZ() {
        return this.kuE;
    }

    public String cKa() {
        return (StringUtils.isNull(this.kuE) || "0".equals(this.kuE)) ? this.oriUgcNid : this.kuE;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bfw() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public n cOt() {
        return this.kse;
    }

    public AntiData bXd() {
        return this.ejE;
    }

    public boolean cOu() {
        return (this.kse == null || this.kse.cHI() == null) ? false : true;
    }

    public void a(a aVar) {
        this.kuM = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.kuE);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.kuE);
        markData.setFloor(postData.dhY());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.ksi);
        if (this.keK != null) {
            this.keK.unRegisterListener();
        }
        bSz();
    }

    private void bSz() {
        if (this.hfy != null) {
            this.hfy.destory();
            this.hfy = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void Ks(String str) {
        if (!TextUtils.isEmpty(str) && this.kse != null && this.kse.cHM() != null) {
            ArrayList<PostData> cHM = this.kse.cHM();
            int size = cHM.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(cHM.get(i).getId())) {
                    cHM.remove(i);
                    this.kuN++;
                    this.kse.setTotalCount(this.kse.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int cOv() {
        int bmK = this.kse.bmK();
        if (bmK == 0) {
            return bmK + 1;
        }
        if (this.eLu == 0) {
            return bmK + 1;
        }
        if (this.eLu == 2 && this.kse.cHM().size() != 0 && this.kse.cHM().size() % this.kse.getPageSize() == 0) {
            return bmK + 1;
        }
        if (this.eLu == 3 && this.kuT) {
            return this.kse.cHK() - 1;
        }
        if (this.eLu == 3 && bmK > 0) {
            return this.kse.cHJ() - 1;
        }
        return bmK;
    }

    private SubPbRequestMessage cNB() {
        this.isLoading = true;
        return p(null);
    }

    private SubPbRequestMessage p(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.eLu) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        }
        if (num == null) {
            intValue = cOv();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.kuT && this.eLu == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.dPv.getPageActivity(), Long.parseLong(this.kuE), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.kuI, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return BO(0);
    }

    public boolean cOw() {
        return BO(2);
    }

    public void cOx() {
        int pageSize;
        if (this.kuN > 0 && this.kse != null && (pageSize = this.kse.getPageSize()) > 0) {
            int bmK = this.kse.bmK();
            for (int i = (((this.kuN + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.kuY = p(Integer.valueOf(bmK - i));
                this.kuY.setTreatDelPage(true);
                sendMessage(this.kuY);
            }
        }
        this.kuN = 0;
    }

    public boolean cOy() {
        return BO(1);
    }

    public boolean BO(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.kuE == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        cOx();
        this.eLu = i;
        this.kuY = cNB();
        sendMessage(this.kuY);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(n nVar) {
        ArrayList<PostData> cHM = nVar.cHM();
        if (cHM == null || cHM.size() == 0) {
            nVar.setCurrentPage(this.kse.bmK());
        }
        if (this.eLu == 1) {
            this.kse = nVar;
        } else if (this.eLu == 2) {
            this.kse.b(nVar, true);
        } else if (this.eLu == 3) {
            this.kse.a(nVar, false);
        } else {
            this.kse.b(nVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(n nVar) {
        if (this.eLu == 1) {
            this.kse = nVar;
            this.kse.cHL();
        } else if (this.eLu == 2) {
            this.kse.c(nVar, true);
        } else if (this.eLu == 3) {
            this.kse.d(nVar, false);
        } else {
            this.kse.a(nVar);
        }
    }

    public boolean cNT() {
        return this.efN;
    }

    public boolean cOz() {
        return this.kam;
    }

    public boolean cOA() {
        return "hot_topic".equals(getStType());
    }

    public void sI(boolean z) {
        this.kam = z;
    }

    public int cHc() {
        return this.jYW;
    }

    public String cOB() {
        return this.kuL;
    }

    public void Kt(String str) {
        this.kuL = str;
    }

    public String cOC() {
        return this.kuG;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData yy(String str) {
        if (this.kse == null || this.kse.bfV() == null || this.kse.aPS() == null || this.kse.cHI() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.kse.bfV().getName());
        writeData.setForumId(this.kse.bfV().getId());
        writeData.setFromForumId(this.kuJ);
        writeData.setFloor(this.kse.cHI().getId());
        writeData.setType(2);
        writeData.setThreadId(this.kse.aPS().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bfv() {
        cOw();
        return true;
    }

    public boolean cOD() {
        return this.kuX;
    }

    public void sJ(boolean z) {
        this.kuX = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.ksh = aVar;
    }

    public SmallTailInfo cOE() {
        return this.kuS;
    }

    public boolean cOF() {
        return this.kuQ;
    }

    public ConcurrentHashMap<String, ImageUrlData> cOG() {
        return this.kuV;
    }

    public ArrayList<String> cOH() {
        return this.kuU;
    }

    public boolean cOI() {
        return this.kuW;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.kuI;
    }

    public AttentionHostData cOJ() {
        if (this.kuP == null) {
            this.kuP = new AttentionHostData();
            if (this.kse != null && this.kse.aPS() != null && this.kse.aPS().aSp() != null) {
                this.kuP.parserWithMetaData(this.kse.aPS().aSp());
            }
        }
        return this.kuP;
    }

    public boolean cKR() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public int cOK() {
        return this.pageFromType;
    }

    public String cJY() {
        return this.kuH;
    }
}
