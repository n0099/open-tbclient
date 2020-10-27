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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
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
/* loaded from: classes22.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private TbPageContext<?> eCn;
    private boolean eSG;
    private AntiData eWX;
    private int fAe;
    private com.baidu.tieba.tbadkCore.d.b igC;
    private boolean isLoading;
    private String ksJ;
    private p lBj;
    private PbFakeFloorModel.a lBm;
    private com.baidu.adp.framework.listener.a lBn;
    private String lDF;
    private String lDG;
    private String lDH;
    private String lDI;
    private boolean lDJ;
    private String lDK;
    private boolean lDL;
    private String lDM;
    private a lDN;
    private int lDO;
    private ArrayList<IconData> lDP;
    private AttentionHostData lDQ;
    private boolean lDR;
    private ArrayList<p> lDS;
    private SmallTailInfo lDT;
    private boolean lDU;
    private ArrayList<String> lDV;
    private ConcurrentHashMap<String, ImageUrlData> lDW;
    private boolean lDX;
    private boolean lDY;
    private SubPbRequestMessage lDZ;
    private boolean liA;
    private PbFakeFloorModel lnf;
    private int mOffset;
    private String oriUgcNid;
    private String oriUgcTid;
    private String oriUgcTopPid;
    private int oriUgcType;
    private String oriUgcVid;
    public int pageFromType;
    private String postID;
    private String stType;
    private int userIdentity;

    /* loaded from: classes22.dex */
    public interface a {
        void a(boolean z, int i, String str, p pVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.lDF = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.ksJ = intent.getStringExtra("from_forum_id");
            this.lDK = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.eSG = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.lDG = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.lDL = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.lDH = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.lDT = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.lDT != null) {
                this.lDT.updateShowInfo();
            }
            this.eWX = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.lDP = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.lDR = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.lDW = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.lDW.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.lDV = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.lDX = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.lDI = intent.getStringExtra("high_light_post_id");
            this.lDJ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.lDF = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.ksJ = bundle.getString("from_forum_id");
            this.lDK = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.eSG = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.lDG = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.lDL = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.lDH = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.lDT = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.lDT != null) {
                this.lDT.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.eWX = new AntiData();
                this.eWX.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!y.isEmpty(stringArrayList)) {
                this.lDP = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.lDP.add(iconData);
                    }
                }
            }
            this.lDR = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.lDI = bundle.getString("high_light_post_id");
            this.lDJ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        }
    }

    public void aC(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.lDF);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.eSG);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.lDG);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.lDH);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.lDL);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.userIdentity);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.lDT));
            if (this.eWX != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.eWX.toJsonString());
            }
            if (!y.isEmpty(this.lDP)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.lDP.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.ksJ);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.lDK);
            bundle.putString("high_light_post_id", this.lDI);
            bundle.putBoolean("high_light_post_id", this.lDJ);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fAe = 0;
        this.lDF = null;
        this.postID = null;
        this.stType = null;
        this.eSG = false;
        this.lDG = null;
        this.lDH = null;
        this.lDI = null;
        this.lDJ = false;
        this.pageFromType = 0;
        this.lDL = false;
        this.liA = false;
        this.userIdentity = 0;
        this.lDM = null;
        this.eCn = null;
        this.lBj = null;
        this.lDN = null;
        this.lDO = 0;
        this.lDR = false;
        this.lDS = null;
        this.isLoading = false;
        this.igC = null;
        this.lDX = true;
        this.mOffset = 0;
        this.lnf = null;
        this.lBm = null;
        this.lDY = false;
        this.lBn = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.eCn.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.lDS.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.lDS.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.lDS != null && SubPbModel.this.lDS.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.lDS.size() - 1; size >= 0; size--) {
                                p pVar2 = (p) SubPbModel.this.lDS.get(size);
                                if (SubPbModel.this.lDU) {
                                    SubPbModel.this.lBj.c(pVar2, true);
                                } else {
                                    SubPbModel.this.lBj.b(pVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.lDS.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.igC == null) {
                        SubPbModel.this.igC = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.igC != null) {
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
                            SubPbModel.this.igC.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.igC = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.igC = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.lDN != null) {
                                SubPbModel.this.lDN.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                pVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                pVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (pVar.dgC().errorno.intValue() != 0) {
                                if (SubPbModel.this.lDN != null) {
                                    SubPbModel.this.lDN.a(false, pVar.liB.errorno.intValue(), pVar.liB.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (pVar.bhz() != null && pVar.bhz().bka() != null) {
                                pVar.bhz().bka().getUserId();
                                if (y.isEmpty(pVar.dgy().bka().getIconInfo()) && SubPbModel.this.lDP != null) {
                                    pVar.dgy().bka().setIconInfo(SubPbModel.this.lDP);
                                }
                            }
                            if (pVar.dgy() != null) {
                                SubPbModel.this.postID = pVar.dgy().getId();
                            }
                            if (pVar.bhz() != null) {
                                SubPbModel.this.lDF = pVar.bhz().getId();
                                SubPbModel.this.liA = pVar.bfV();
                                SubPbModel.this.lDM = pVar.bhz().bki();
                            }
                            if (SubPbModel.this.lDM != null && SubPbModel.this.postID != null && SubPbModel.this.lDM.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.liA = true;
                            }
                            if (SubPbModel.this.lDU) {
                                SubPbModel.this.f(pVar);
                            } else {
                                SubPbModel.this.e(pVar);
                            }
                            if (SubPbModel.this.lDN != null) {
                                SubPbModel.this.lDN.a(SubPbModel.this.dnu(), error, errorString, SubPbModel.this.lBj);
                            }
                        }
                    }
                }
            }
        };
        this.eCn = tbPageContext;
        this.lDS = new ArrayList<>();
        this.lBj = new p();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.lBn);
        registerListener(this.lBn);
    }

    public String diV() {
        return this.lDF;
    }

    public String diW() {
        return (StringUtils.isNull(this.lDF) || "0".equals(this.lDF)) ? this.oriUgcNid : this.lDF;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bxA() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public p dnt() {
        return this.lBj;
    }

    public AntiData cuM() {
        return this.eWX;
    }

    public boolean dnu() {
        return (this.lBj == null || this.lBj.dgy() == null) ? false : true;
    }

    public void a(a aVar) {
        this.lDN = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lDF);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.lDF);
        markData.setFloor(postData.dHx());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.lBn);
        if (this.lnf != null) {
            this.lnf.unRegisterListener();
        }
        cpZ();
    }

    private void cpZ() {
        if (this.igC != null) {
            this.igC.destory();
            this.igC = null;
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

    public void PO(String str) {
        if (!TextUtils.isEmpty(str) && this.lBj != null && this.lBj.dgG() != null) {
            ArrayList<PostData> dgG = this.lBj.dgG();
            int size = dgG.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(dgG.get(i).getId())) {
                    dgG.remove(i);
                    this.lDO++;
                    this.lBj.setTotalCount(this.lBj.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int dnv() {
        int bFs = this.lBj.bFs();
        if (bFs == 0) {
            return bFs + 1;
        }
        if (this.fAe == 0) {
            return bFs + 1;
        }
        if (this.fAe == 2 && this.lBj.dgG().size() != 0 && this.lBj.dgG().size() % this.lBj.getPageSize() == 0) {
            return bFs + 1;
        }
        if (this.fAe == 3 && this.lDU) {
            return this.lBj.dgE() - 1;
        }
        if (this.fAe == 3 && bFs > 0) {
            return this.lBj.dgD() - 1;
        }
        return bFs;
    }

    private SubPbRequestMessage dmA() {
        this.isLoading = true;
        return r(null);
    }

    private SubPbRequestMessage r(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.fAe) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else if (!at.isEmpty(this.oriUgcNid)) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
            j2 = com.baidu.adp.lib.f.b.toLong(this.lDH, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.lDH, 0L);
        }
        if (num == null) {
            intValue = dnv();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.lDU && this.fAe == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.eCn.getPageActivity(), Long.parseLong(this.lDF), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.ksJ, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return Gi(0);
    }

    public boolean dnw() {
        return Gi(2);
    }

    public void dnx() {
        int pageSize;
        if (this.lDO > 0 && this.lBj != null && (pageSize = this.lBj.getPageSize()) > 0) {
            int bFs = this.lBj.bFs();
            for (int i = (((this.lDO + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.lDZ = r(Integer.valueOf(bFs - i));
                this.lDZ.setTreatDelPage(true);
                sendMessage(this.lDZ);
            }
        }
        this.lDO = 0;
    }

    public boolean dny() {
        return Gi(1);
    }

    public boolean dnz() {
        return Gi(3);
    }

    public boolean Gi(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.lDF == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        dnx();
        this.fAe = i;
        this.lDZ = dmA();
        sendMessage(this.lDZ);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        ArrayList<PostData> dgG = pVar.dgG();
        if (dgG == null || dgG.size() == 0) {
            pVar.setCurrentPage(this.lBj.bFs());
        }
        if (this.fAe == 1) {
            this.lBj = pVar;
        } else if (this.fAe == 2) {
            this.lBj.b(pVar, true);
        } else if (this.fAe == 3) {
            this.lBj.a(pVar, false);
        } else {
            this.lBj.b(pVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(p pVar) {
        if (this.fAe == 1) {
            this.lBj = pVar;
            this.lBj.dgF();
        } else if (this.fAe == 2) {
            this.lBj.c(pVar, true);
        } else if (this.fAe == 3) {
            this.lBj.d(pVar, false);
        } else {
            this.lBj.a(pVar);
        }
    }

    public boolean dmS() {
        return this.eSG;
    }

    public boolean dnA() {
        return this.liA;
    }

    public boolean dnB() {
        return "hot_topic".equals(getStType());
    }

    public void vf(boolean z) {
        this.liA = z;
    }

    public int dfX() {
        return this.userIdentity;
    }

    public String dnC() {
        return this.lDM;
    }

    public void PP(String str) {
        this.lDM = str;
    }

    public String dnD() {
        return this.lDH;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData Dw(String str) {
        if (this.lBj == null || this.lBj.bya() == null || this.lBj.bhz() == null || this.lBj.dgy() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.lBj.bya().getName());
        writeData.setForumId(this.lBj.bya().getId());
        writeData.setFromForumId(this.lDK);
        writeData.setFloor(this.lBj.dgy().getId());
        writeData.setType(2);
        writeData.setThreadId(this.lBj.bhz().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bxz() {
        dnw();
        return true;
    }

    public boolean dnE() {
        return this.lDY;
    }

    public void vg(boolean z) {
        this.lDY = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.lBm = aVar;
    }

    public SmallTailInfo dnF() {
        return this.lDT;
    }

    public boolean dnG() {
        return this.lDR;
    }

    public ConcurrentHashMap<String, ImageUrlData> dnH() {
        return this.lDW;
    }

    public ArrayList<String> dnI() {
        return this.lDV;
    }

    public boolean dnJ() {
        return this.lDX;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.ksJ;
    }

    public AttentionHostData dnK() {
        if (this.lDQ == null) {
            this.lDQ = new AttentionHostData();
            if (this.lBj != null && this.lBj.bhz() != null && this.lBj.bhz().bka() != null) {
                this.lDQ.parserWithMetaData(this.lBj.bhz().bka());
            }
        }
        return this.lDQ;
    }

    public int dnL() {
        return this.pageFromType;
    }

    public String diU() {
        return this.lDI;
    }

    public boolean dnM() {
        return this.lDJ;
    }
}
