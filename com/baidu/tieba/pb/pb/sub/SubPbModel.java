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
    private p kBc;
    private PbFakeFloorModel.a kBf;
    private com.baidu.adp.framework.listener.a kBg;
    private String kDA;
    private String kDB;
    private boolean kDC;
    private String kDD;
    private a kDE;
    private int kDF;
    private ArrayList<IconData> kDG;
    private AttentionHostData kDH;
    private boolean kDI;
    private ArrayList<p> kDJ;
    private SmallTailInfo kDK;
    private boolean kDL;
    private ArrayList<String> kDM;
    private ConcurrentHashMap<String, ImageUrlData> kDN;
    private boolean kDO;
    private boolean kDP;
    private SubPbRequestMessage kDQ;
    private String kDw;
    private String kDx;
    private String kDy;
    private String kDz;
    private int khx;
    private boolean kiS;
    private PbFakeFloorModel knx;
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
            this.kDw = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.kDA = intent.getStringExtra("from_forum_id");
            this.kDB = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.elX = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.kDx = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.kDC = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.kDy = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.khx = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.kDK = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.kDK != null) {
                this.kDK.updateShowInfo();
            }
            this.epR = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.kDG = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.kDI = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.kDN = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.kDN.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.kDM = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.kDO = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.kDz = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.kDw = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.kDA = bundle.getString("from_forum_id");
            this.kDB = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.elX = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.kDx = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.kDC = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.kDy = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.khx = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.kDK = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.kDK != null) {
                this.kDK.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.epR = new AntiData();
                this.epR.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!x.isEmpty(stringArrayList)) {
                this.kDG = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.kDG.add(iconData);
                    }
                }
            }
            this.kDI = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.kDz = bundle.getString("high_light_post_id");
        }
    }

    public void aD(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.kDw);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.elX);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.kDx);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.kDy);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.kDC);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.khx);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.kDK));
            if (this.epR != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.epR.toJsonString());
            }
            if (!x.isEmpty(this.kDG)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.kDG.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.kDA);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.kDB);
            bundle.putString("high_light_post_id", this.kDz);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eRP = 0;
        this.kDw = null;
        this.postID = null;
        this.stType = null;
        this.elX = false;
        this.kDx = null;
        this.kDy = null;
        this.kDz = null;
        this.pageFromType = 0;
        this.kDC = false;
        this.kiS = false;
        this.khx = 0;
        this.kDD = null;
        this.dVN = null;
        this.kBc = null;
        this.kDE = null;
        this.kDF = 0;
        this.kDI = false;
        this.kDJ = null;
        this.isLoading = false;
        this.hli = null;
        this.kDO = true;
        this.mOffset = 0;
        this.knx = null;
        this.kBf = null;
        this.kDP = false;
        this.kBg = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.kDJ.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.kDJ.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.kDJ != null && SubPbModel.this.kDJ.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.kDJ.size() - 1; size >= 0; size--) {
                                p pVar2 = (p) SubPbModel.this.kDJ.get(size);
                                if (SubPbModel.this.kDL) {
                                    SubPbModel.this.kBc.c(pVar2, true);
                                } else {
                                    SubPbModel.this.kBc.b(pVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.kDJ.clear();
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
                            if (SubPbModel.this.kDE != null) {
                                SubPbModel.this.kDE.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                pVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                pVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (pVar.cLs().errorno.intValue() != 0) {
                                if (SubPbModel.this.kDE != null) {
                                    SubPbModel.this.kDE.a(false, pVar.kiT.errorno.intValue(), pVar.kiT.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (pVar.aTN() != null && pVar.aTN().aWl() != null) {
                                pVar.aTN().aWl().getUserId();
                                if (x.isEmpty(pVar.cLt().aWl().getIconInfo()) && SubPbModel.this.kDG != null) {
                                    pVar.cLt().aWl().setIconInfo(SubPbModel.this.kDG);
                                }
                            }
                            if (pVar.cLt() != null) {
                                SubPbModel.this.postID = pVar.cLt().getId();
                            }
                            if (pVar.aTN() != null) {
                                SubPbModel.this.kDw = pVar.aTN().getId();
                                SubPbModel.this.kiS = pVar.aSj();
                                SubPbModel.this.kDD = pVar.aTN().aWt();
                            }
                            if (SubPbModel.this.kDD != null && SubPbModel.this.postID != null && SubPbModel.this.kDD.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.kiS = true;
                            }
                            if (SubPbModel.this.kDL) {
                                SubPbModel.this.f(pVar);
                            } else {
                                SubPbModel.this.e(pVar);
                            }
                            if (SubPbModel.this.kDE != null) {
                                SubPbModel.this.kDE.a(SubPbModel.this.cSi(), error, errorString, SubPbModel.this.kBc);
                            }
                        }
                    }
                }
            }
        };
        this.dVN = tbPageContext;
        this.kDJ = new ArrayList<>();
        this.kBc = new p();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.kBg);
        registerListener(this.kBg);
    }

    public String cNL() {
        return this.kDw;
    }

    public String cNM() {
        return (StringUtils.isNull(this.kDw) || "0".equals(this.kDw)) ? this.oriUgcNid : this.kDw;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bjg() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public p cSh() {
        return this.kBc;
    }

    public AntiData cax() {
        return this.epR;
    }

    public boolean cSi() {
        return (this.kBc == null || this.kBc.cLt() == null) ? false : true;
    }

    public void a(a aVar) {
        this.kDE = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.kDw);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.kDw);
        markData.setFloor(postData.dlh());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.kBg);
        if (this.knx != null) {
            this.knx.unRegisterListener();
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
        if (!TextUtils.isEmpty(str) && this.kBc != null && this.kBc.cLx() != null) {
            ArrayList<PostData> cLx = this.kBc.cLx();
            int size = cLx.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(cLx.get(i).getId())) {
                    cLx.remove(i);
                    this.kDF++;
                    this.kBc.setTotalCount(this.kBc.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int cSj() {
        int bqF = this.kBc.bqF();
        if (bqF == 0) {
            return bqF + 1;
        }
        if (this.eRP == 0) {
            return bqF + 1;
        }
        if (this.eRP == 2 && this.kBc.cLx().size() != 0 && this.kBc.cLx().size() % this.kBc.getPageSize() == 0) {
            return bqF + 1;
        }
        if (this.eRP == 3 && this.kDL) {
            return this.kBc.cLv() - 1;
        }
        if (this.eRP == 3 && bqF > 0) {
            return this.kBc.cLu() - 1;
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
        if (this.kDL && this.eRP == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.dVN.getPageActivity(), Long.parseLong(this.kDw), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.kDA, 0L));
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
        if (this.kDF > 0 && this.kBc != null && (pageSize = this.kBc.getPageSize()) > 0) {
            int bqF = this.kBc.bqF();
            for (int i = (((this.kDF + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.kDQ = o(Integer.valueOf(bqF - i));
                this.kDQ.setTreatDelPage(true);
                sendMessage(this.kDQ);
            }
        }
        this.kDF = 0;
    }

    public boolean cSm() {
        return Co(1);
    }

    public boolean Co(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.kDw == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        cSl();
        this.eRP = i;
        this.kDQ = cRp();
        sendMessage(this.kDQ);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        ArrayList<PostData> cLx = pVar.cLx();
        if (cLx == null || cLx.size() == 0) {
            pVar.setCurrentPage(this.kBc.bqF());
        }
        if (this.eRP == 1) {
            this.kBc = pVar;
        } else if (this.eRP == 2) {
            this.kBc.b(pVar, true);
        } else if (this.eRP == 3) {
            this.kBc.a(pVar, false);
        } else {
            this.kBc.b(pVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(p pVar) {
        if (this.eRP == 1) {
            this.kBc = pVar;
            this.kBc.cLw();
        } else if (this.eRP == 2) {
            this.kBc.c(pVar, true);
        } else if (this.eRP == 3) {
            this.kBc.d(pVar, false);
        } else {
            this.kBc.a(pVar);
        }
    }

    public boolean cRH() {
        return this.elX;
    }

    public boolean cSn() {
        return this.kiS;
    }

    public boolean cSo() {
        return "hot_topic".equals(getStType());
    }

    public void to(boolean z) {
        this.kiS = z;
    }

    public int cKM() {
        return this.khx;
    }

    public String cSp() {
        return this.kDD;
    }

    public void Lh(String str) {
        this.kDD = str;
    }

    public String cSq() {
        return this.kDy;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData zE(String str) {
        if (this.kBc == null || this.kBc.bjG() == null || this.kBc.aTN() == null || this.kBc.cLt() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.kBc.bjG().getName());
        writeData.setForumId(this.kBc.bjG().getId());
        writeData.setFromForumId(this.kDB);
        writeData.setFloor(this.kBc.cLt().getId());
        writeData.setType(2);
        writeData.setThreadId(this.kBc.aTN().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bjf() {
        cSk();
        return true;
    }

    public boolean cSr() {
        return this.kDP;
    }

    public void tp(boolean z) {
        this.kDP = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.kBf = aVar;
    }

    public SmallTailInfo cSs() {
        return this.kDK;
    }

    public boolean cSt() {
        return this.kDI;
    }

    public ConcurrentHashMap<String, ImageUrlData> cSu() {
        return this.kDN;
    }

    public ArrayList<String> cSv() {
        return this.kDM;
    }

    public boolean cSw() {
        return this.kDO;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.kDA;
    }

    public AttentionHostData cSx() {
        if (this.kDH == null) {
            this.kDH = new AttentionHostData();
            if (this.kBc != null && this.kBc.aTN() != null && this.kBc.aTN().aWl() != null) {
                this.kDH.parserWithMetaData(this.kBc.aTN().aWl());
            }
        }
        return this.kDH;
    }

    public boolean cOD() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public int cSy() {
        return this.pageFromType;
    }

    public String cNK() {
        return this.kDz;
    }
}
