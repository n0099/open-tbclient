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
    private boolean eKk;
    private AntiData eOB;
    private TbPageContext<?> etO;
    private int frH;
    private com.baidu.tieba.tbadkCore.d.b hUc;
    private boolean isLoading;
    private boolean kWb;
    private String kgl;
    private PbFakeFloorModel laH;
    private p loK;
    private PbFakeFloorModel.a loN;
    private com.baidu.adp.framework.listener.a loO;
    private SubPbRequestMessage lrA;
    private String lrg;
    private String lrh;
    private String lri;
    private String lrj;
    private boolean lrk;
    private String lrl;
    private boolean lrm;
    private String lrn;
    private a lro;
    private int lrp;
    private ArrayList<IconData> lrq;
    private AttentionHostData lrr;
    private boolean lrs;
    private ArrayList<p> lrt;
    private SmallTailInfo lru;
    private boolean lrv;
    private ArrayList<String> lrw;
    private ConcurrentHashMap<String, ImageUrlData> lrx;
    private boolean lry;
    private boolean lrz;
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
            this.lrg = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.kgl = intent.getStringExtra("from_forum_id");
            this.lrl = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.eKk = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.lrh = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.lrm = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.lri = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.lru = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.lru != null) {
                this.lru.updateShowInfo();
            }
            this.eOB = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.lrq = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.lrs = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.lrx = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.lrx.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.lrw = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.lry = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.lrj = intent.getStringExtra("high_light_post_id");
            this.lrk = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.lrg = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.kgl = bundle.getString("from_forum_id");
            this.lrl = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.eKk = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.lrh = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.lrm = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.lri = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.lru = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.lru != null) {
                this.lru.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.eOB = new AntiData();
                this.eOB.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!y.isEmpty(stringArrayList)) {
                this.lrq = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.lrq.add(iconData);
                    }
                }
            }
            this.lrs = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.lrj = bundle.getString("high_light_post_id");
            this.lrk = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        }
    }

    public void aC(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.lrg);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.eKk);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.lrh);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.lri);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.lrm);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.userIdentity);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.lru));
            if (this.eOB != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.eOB.toJsonString());
            }
            if (!y.isEmpty(this.lrq)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.lrq.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.kgl);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.lrl);
            bundle.putString("high_light_post_id", this.lrj);
            bundle.putBoolean("high_light_post_id", this.lrk);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.frH = 0;
        this.lrg = null;
        this.postID = null;
        this.stType = null;
        this.eKk = false;
        this.lrh = null;
        this.lri = null;
        this.lrj = null;
        this.lrk = false;
        this.pageFromType = 0;
        this.lrm = false;
        this.kWb = false;
        this.userIdentity = 0;
        this.lrn = null;
        this.etO = null;
        this.loK = null;
        this.lro = null;
        this.lrp = 0;
        this.lrs = false;
        this.lrt = null;
        this.isLoading = false;
        this.hUc = null;
        this.lry = true;
        this.mOffset = 0;
        this.laH = null;
        this.loN = null;
        this.lrz = false;
        this.loO = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.etO.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.lrt.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.lrt.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.lrt != null && SubPbModel.this.lrt.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.lrt.size() - 1; size >= 0; size--) {
                                p pVar2 = (p) SubPbModel.this.lrt.get(size);
                                if (SubPbModel.this.lrv) {
                                    SubPbModel.this.loK.c(pVar2, true);
                                } else {
                                    SubPbModel.this.loK.b(pVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.lrt.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.hUc == null) {
                        SubPbModel.this.hUc = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.hUc != null) {
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
                            SubPbModel.this.hUc.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.hUc = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.hUc = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.lro != null) {
                                SubPbModel.this.lro.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                pVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                pVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (pVar.ddu().errorno.intValue() != 0) {
                                if (SubPbModel.this.lro != null) {
                                    SubPbModel.this.lro.a(false, pVar.kWc.errorno.intValue(), pVar.kWc.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (pVar.bfG() != null && pVar.bfG().bih() != null) {
                                pVar.bfG().bih().getUserId();
                                if (y.isEmpty(pVar.ddq().bih().getIconInfo()) && SubPbModel.this.lrq != null) {
                                    pVar.ddq().bih().setIconInfo(SubPbModel.this.lrq);
                                }
                            }
                            if (pVar.ddq() != null) {
                                SubPbModel.this.postID = pVar.ddq().getId();
                            }
                            if (pVar.bfG() != null) {
                                SubPbModel.this.lrg = pVar.bfG().getId();
                                SubPbModel.this.kWb = pVar.bec();
                                SubPbModel.this.lrn = pVar.bfG().bip();
                            }
                            if (SubPbModel.this.lrn != null && SubPbModel.this.postID != null && SubPbModel.this.lrn.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.kWb = true;
                            }
                            if (SubPbModel.this.lrv) {
                                SubPbModel.this.f(pVar);
                            } else {
                                SubPbModel.this.e(pVar);
                            }
                            if (SubPbModel.this.lro != null) {
                                SubPbModel.this.lro.a(SubPbModel.this.dkm(), error, errorString, SubPbModel.this.loK);
                            }
                        }
                    }
                }
            }
        };
        this.etO = tbPageContext;
        this.lrt = new ArrayList<>();
        this.loK = new p();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.loO);
        registerListener(this.loO);
    }

    public String dfO() {
        return this.lrg;
    }

    public String dfP() {
        return (StringUtils.isNull(this.lrg) || "0".equals(this.lrg)) ? this.oriUgcNid : this.lrg;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bvH() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public p dkl() {
        return this.loK;
    }

    public AntiData crF() {
        return this.eOB;
    }

    public boolean dkm() {
        return (this.loK == null || this.loK.ddq() == null) ? false : true;
    }

    public void a(a aVar) {
        this.lro = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lrg);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.lrg);
        markData.setFloor(postData.dEp());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.loO);
        if (this.laH != null) {
            this.laH.unRegisterListener();
        }
        cmS();
    }

    private void cmS() {
        if (this.hUc != null) {
            this.hUc.destory();
            this.hUc = null;
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

    public void Pq(String str) {
        if (!TextUtils.isEmpty(str) && this.loK != null && this.loK.ddy() != null) {
            ArrayList<PostData> ddy = this.loK.ddy();
            int size = ddy.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(ddy.get(i).getId())) {
                    ddy.remove(i);
                    this.lrp++;
                    this.loK.setTotalCount(this.loK.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int dkn() {
        int bDz = this.loK.bDz();
        if (bDz == 0) {
            return bDz + 1;
        }
        if (this.frH == 0) {
            return bDz + 1;
        }
        if (this.frH == 2 && this.loK.ddy().size() != 0 && this.loK.ddy().size() % this.loK.getPageSize() == 0) {
            return bDz + 1;
        }
        if (this.frH == 3 && this.lrv) {
            return this.loK.ddw() - 1;
        }
        if (this.frH == 3 && bDz > 0) {
            return this.loK.ddv() - 1;
        }
        return bDz;
    }

    private SubPbRequestMessage djt() {
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
        if (1 != this.frH) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else if (!at.isEmpty(this.oriUgcNid)) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
            j2 = com.baidu.adp.lib.f.b.toLong(this.lri, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.lri, 0L);
        }
        if (num == null) {
            intValue = dkn();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.lrv && this.frH == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.etO.getPageActivity(), Long.parseLong(this.lrg), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.kgl, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return FP(0);
    }

    public boolean dko() {
        return FP(2);
    }

    public void dkp() {
        int pageSize;
        if (this.lrp > 0 && this.loK != null && (pageSize = this.loK.getPageSize()) > 0) {
            int bDz = this.loK.bDz();
            for (int i = (((this.lrp + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.lrA = r(Integer.valueOf(bDz - i));
                this.lrA.setTreatDelPage(true);
                sendMessage(this.lrA);
            }
        }
        this.lrp = 0;
    }

    public boolean dkq() {
        return FP(1);
    }

    public boolean dkr() {
        return FP(3);
    }

    public boolean FP(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.lrg == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        dkp();
        this.frH = i;
        this.lrA = djt();
        sendMessage(this.lrA);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        ArrayList<PostData> ddy = pVar.ddy();
        if (ddy == null || ddy.size() == 0) {
            pVar.setCurrentPage(this.loK.bDz());
        }
        if (this.frH == 1) {
            this.loK = pVar;
        } else if (this.frH == 2) {
            this.loK.b(pVar, true);
        } else if (this.frH == 3) {
            this.loK.a(pVar, false);
        } else {
            this.loK.b(pVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(p pVar) {
        if (this.frH == 1) {
            this.loK = pVar;
            this.loK.ddx();
        } else if (this.frH == 2) {
            this.loK.c(pVar, true);
        } else if (this.frH == 3) {
            this.loK.d(pVar, false);
        } else {
            this.loK.a(pVar);
        }
    }

    public boolean djL() {
        return this.eKk;
    }

    public boolean dks() {
        return this.kWb;
    }

    public boolean dkt() {
        return "hot_topic".equals(getStType());
    }

    public void uO(boolean z) {
        this.kWb = z;
    }

    public int dcP() {
        return this.userIdentity;
    }

    public String dku() {
        return this.lrn;
    }

    public void Pr(String str) {
        this.lrn = str;
    }

    public String dkv() {
        return this.lri;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData Dd(String str) {
        if (this.loK == null || this.loK.bwh() == null || this.loK.bfG() == null || this.loK.ddq() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.loK.bwh().getName());
        writeData.setForumId(this.loK.bwh().getId());
        writeData.setFromForumId(this.lrl);
        writeData.setFloor(this.loK.ddq().getId());
        writeData.setType(2);
        writeData.setThreadId(this.loK.bfG().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bvG() {
        dko();
        return true;
    }

    public boolean dkw() {
        return this.lrz;
    }

    public void uP(boolean z) {
        this.lrz = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.loN = aVar;
    }

    public SmallTailInfo dkx() {
        return this.lru;
    }

    public boolean dky() {
        return this.lrs;
    }

    public ConcurrentHashMap<String, ImageUrlData> dkz() {
        return this.lrx;
    }

    public ArrayList<String> dkA() {
        return this.lrw;
    }

    public boolean dkB() {
        return this.lry;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.kgl;
    }

    public AttentionHostData dkC() {
        if (this.lrr == null) {
            this.lrr = new AttentionHostData();
            if (this.loK != null && this.loK.bfG() != null && this.loK.bfG().bih() != null) {
                this.lrr.parserWithMetaData(this.loK.bfG().bih());
            }
        }
        return this.lrr;
    }

    public int dkD() {
        return this.pageFromType;
    }

    public String dfN() {
        return this.lrj;
    }

    public boolean dkE() {
        return this.lrk;
    }
}
