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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes16.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private TbPageContext<?> dVN;
    private int eRP;
    private boolean elX;
    private AntiData epR;
    private com.baidu.tieba.tbadkCore.d.b hli;
    private boolean isLoading;
    private p kBe;
    private PbFakeFloorModel.a kBh;
    private com.baidu.adp.framework.listener.a kBi;
    private String kDA;
    private String kDB;
    private String kDC;
    private String kDD;
    private boolean kDE;
    private String kDF;
    private a kDG;
    private int kDH;
    private ArrayList<IconData> kDI;
    private AttentionHostData kDJ;
    private boolean kDK;
    private ArrayList<p> kDL;
    private SmallTailInfo kDM;
    private boolean kDN;
    private ArrayList<String> kDO;
    private ConcurrentHashMap<String, ImageUrlData> kDP;
    private boolean kDQ;
    private boolean kDR;
    private SubPbRequestMessage kDS;
    private String kDy;
    private String kDz;
    private int khz;
    private boolean kiU;
    private PbFakeFloorModel knz;
    private int mOffset;
    private String oriUgcNid;
    private String oriUgcTid;
    private String oriUgcTopPid;
    private int oriUgcType;
    private String oriUgcVid;
    public int pageFromType;
    private String postID;
    private String stType;

    /* loaded from: classes16.dex */
    public interface a {
        void a(boolean z, int i, String str, p pVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.kDy = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.kDC = intent.getStringExtra("from_forum_id");
            this.kDD = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.elX = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.kDz = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.kDE = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.kDA = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.khz = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.kDM = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.kDM != null) {
                this.kDM.updateShowInfo();
            }
            this.epR = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.kDI = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.kDK = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.kDP = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.kDP.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.kDO = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.kDQ = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.kDB = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.kDy = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.kDC = bundle.getString("from_forum_id");
            this.kDD = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.elX = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.kDz = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.kDE = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.kDA = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.khz = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.kDM = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.kDM != null) {
                this.kDM.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.epR = new AntiData();
                this.epR.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!x.isEmpty(stringArrayList)) {
                this.kDI = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.kDI.add(iconData);
                    }
                }
            }
            this.kDK = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.kDB = bundle.getString("high_light_post_id");
        }
    }

    public void aD(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.kDy);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.elX);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.kDz);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.kDA);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.kDE);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.khz);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.kDM));
            if (this.epR != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.epR.toJsonString());
            }
            if (!x.isEmpty(this.kDI)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.kDI.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.kDC);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.kDD);
            bundle.putString("high_light_post_id", this.kDB);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eRP = 0;
        this.kDy = null;
        this.postID = null;
        this.stType = null;
        this.elX = false;
        this.kDz = null;
        this.kDA = null;
        this.kDB = null;
        this.pageFromType = 0;
        this.kDE = false;
        this.kiU = false;
        this.khz = 0;
        this.kDF = null;
        this.dVN = null;
        this.kBe = null;
        this.kDG = null;
        this.kDH = 0;
        this.kDK = false;
        this.kDL = null;
        this.isLoading = false;
        this.hli = null;
        this.kDQ = true;
        this.mOffset = 0;
        this.knz = null;
        this.kBh = null;
        this.kDR = false;
        this.kBi = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                boolean z;
                p pVar;
                long j2;
                long j3;
                long j4 = 0;
                if (SubPbModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    SubPbModel.this.isLoading = false;
                    if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                        SubPbModel.this.dVN.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.kDL.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.kDL.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.kDL != null && SubPbModel.this.kDL.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.kDL.size() - 1; size >= 0; size--) {
                                p pVar2 = (p) SubPbModel.this.kDL.get(size);
                                if (SubPbModel.this.kDN) {
                                    SubPbModel.this.kBe.c(pVar2, true);
                                } else {
                                    SubPbModel.this.kBe.b(pVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.kDL.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.hli == null) {
                        SubPbModel.this.hli = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.hli != null) {
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
                            SubPbModel.this.hli.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.hli = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.hli = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.kDG != null) {
                                SubPbModel.this.kDG.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                pVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                pVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (pVar.cLs().errorno.intValue() != 0) {
                                if (SubPbModel.this.kDG != null) {
                                    SubPbModel.this.kDG.a(false, pVar.kiV.errorno.intValue(), pVar.kiV.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (pVar.aTN() != null && pVar.aTN().aWl() != null) {
                                pVar.aTN().aWl().getUserId();
                                if (x.isEmpty(pVar.cLt().aWl().getIconInfo()) && SubPbModel.this.kDI != null) {
                                    pVar.cLt().aWl().setIconInfo(SubPbModel.this.kDI);
                                }
                            }
                            if (pVar.cLt() != null) {
                                SubPbModel.this.postID = pVar.cLt().getId();
                            }
                            if (pVar.aTN() != null) {
                                SubPbModel.this.kDy = pVar.aTN().getId();
                                SubPbModel.this.kiU = pVar.aSj();
                                SubPbModel.this.kDF = pVar.aTN().aWt();
                            }
                            if (SubPbModel.this.kDF != null && SubPbModel.this.postID != null && SubPbModel.this.kDF.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.kiU = true;
                            }
                            if (SubPbModel.this.kDN) {
                                SubPbModel.this.f(pVar);
                            } else {
                                SubPbModel.this.e(pVar);
                            }
                            if (SubPbModel.this.kDG != null) {
                                SubPbModel.this.kDG.a(SubPbModel.this.cSi(), error, errorString, SubPbModel.this.kBe);
                            }
                        }
                    }
                }
            }
        };
        this.dVN = tbPageContext;
        this.kDL = new ArrayList<>();
        this.kBe = new p();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.kBi);
        registerListener(this.kBi);
    }

    public String cNL() {
        return this.kDy;
    }

    public String cNM() {
        return (StringUtils.isNull(this.kDy) || "0".equals(this.kDy)) ? this.oriUgcNid : this.kDy;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bjg() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public p cSh() {
        return this.kBe;
    }

    public AntiData cax() {
        return this.epR;
    }

    public boolean cSi() {
        return (this.kBe == null || this.kBe.cLt() == null) ? false : true;
    }

    public void a(a aVar) {
        this.kDG = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.kDy);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.kDy);
        markData.setFloor(postData.dli());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.kBi);
        if (this.knz != null) {
            this.knz.unRegisterListener();
        }
        bVR();
    }

    private void bVR() {
        if (this.hli != null) {
            this.hli.destory();
            this.hli = null;
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

    public void Lg(String str) {
        if (!TextUtils.isEmpty(str) && this.kBe != null && this.kBe.cLx() != null) {
            ArrayList<PostData> cLx = this.kBe.cLx();
            int size = cLx.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(cLx.get(i).getId())) {
                    cLx.remove(i);
                    this.kDH++;
                    this.kBe.setTotalCount(this.kBe.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int cSj() {
        int bqF = this.kBe.bqF();
        if (bqF == 0) {
            return bqF + 1;
        }
        if (this.eRP == 0) {
            return bqF + 1;
        }
        if (this.eRP == 2 && this.kBe.cLx().size() != 0 && this.kBe.cLx().size() % this.kBe.getPageSize() == 0) {
            return bqF + 1;
        }
        if (this.eRP == 3 && this.kDN) {
            return this.kBe.cLv() - 1;
        }
        if (this.eRP == 3 && bqF > 0) {
            return this.kBe.cLu() - 1;
        }
        return bqF;
    }

    private SubPbRequestMessage cRp() {
        this.isLoading = true;
        return o((Integer) null);
    }

    private SubPbRequestMessage o(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.eRP) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        }
        if (num == null) {
            intValue = cSj();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.kDN && this.eRP == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.dVN.getPageActivity(), Long.parseLong(this.kDy), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.kDC, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return Co(0);
    }

    public boolean cSk() {
        return Co(2);
    }

    public void cSl() {
        int pageSize;
        if (this.kDH > 0 && this.kBe != null && (pageSize = this.kBe.getPageSize()) > 0) {
            int bqF = this.kBe.bqF();
            for (int i = (((this.kDH + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.kDS = o(Integer.valueOf(bqF - i));
                this.kDS.setTreatDelPage(true);
                sendMessage(this.kDS);
            }
        }
        this.kDH = 0;
    }

    public boolean cSm() {
        return Co(1);
    }

    public boolean Co(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.kDy == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        cSl();
        this.eRP = i;
        this.kDS = cRp();
        sendMessage(this.kDS);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        ArrayList<PostData> cLx = pVar.cLx();
        if (cLx == null || cLx.size() == 0) {
            pVar.setCurrentPage(this.kBe.bqF());
        }
        if (this.eRP == 1) {
            this.kBe = pVar;
        } else if (this.eRP == 2) {
            this.kBe.b(pVar, true);
        } else if (this.eRP == 3) {
            this.kBe.a(pVar, false);
        } else {
            this.kBe.b(pVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(p pVar) {
        if (this.eRP == 1) {
            this.kBe = pVar;
            this.kBe.cLw();
        } else if (this.eRP == 2) {
            this.kBe.c(pVar, true);
        } else if (this.eRP == 3) {
            this.kBe.d(pVar, false);
        } else {
            this.kBe.a(pVar);
        }
    }

    public boolean cRH() {
        return this.elX;
    }

    public boolean cSn() {
        return this.kiU;
    }

    public boolean cSo() {
        return "hot_topic".equals(getStType());
    }

    public void to(boolean z) {
        this.kiU = z;
    }

    public int cKM() {
        return this.khz;
    }

    public String cSp() {
        return this.kDF;
    }

    public void Lh(String str) {
        this.kDF = str;
    }

    public String cSq() {
        return this.kDA;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData zE(String str) {
        if (this.kBe == null || this.kBe.bjG() == null || this.kBe.aTN() == null || this.kBe.cLt() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.kBe.bjG().getName());
        writeData.setForumId(this.kBe.bjG().getId());
        writeData.setFromForumId(this.kDD);
        writeData.setFloor(this.kBe.cLt().getId());
        writeData.setType(2);
        writeData.setThreadId(this.kBe.aTN().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bjf() {
        cSk();
        return true;
    }

    public boolean cSr() {
        return this.kDR;
    }

    public void tp(boolean z) {
        this.kDR = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.kBh = aVar;
    }

    public SmallTailInfo cSs() {
        return this.kDM;
    }

    public boolean cSt() {
        return this.kDK;
    }

    public ConcurrentHashMap<String, ImageUrlData> cSu() {
        return this.kDP;
    }

    public ArrayList<String> cSv() {
        return this.kDO;
    }

    public boolean cSw() {
        return this.kDQ;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.kDC;
    }

    public AttentionHostData cSx() {
        if (this.kDJ == null) {
            this.kDJ = new AttentionHostData();
            if (this.kBe != null && this.kBe.aTN() != null && this.kBe.aTN().aWl() != null) {
                this.kDJ.parserWithMetaData(this.kBe.aTN().aWl());
            }
        }
        return this.kDJ;
    }

    public boolean cOD() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public int cSy() {
        return this.pageFromType;
    }

    public String cNK() {
        return this.kDB;
    }
}
