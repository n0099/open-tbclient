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
/* loaded from: classes16.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private AntiData eAp;
    private TbPageContext<?> efr;
    private boolean evW;
    private int fcA;
    private com.baidu.tieba.tbadkCore.d.b hyf;
    private boolean isLoading;
    private String jIK;
    private PbFakeFloorModel kCX;
    private p kQQ;
    private PbFakeFloorModel.a kQT;
    private com.baidu.adp.framework.listener.a kQU;
    private boolean kTA;
    private ArrayList<String> kTB;
    private ConcurrentHashMap<String, ImageUrlData> kTC;
    private boolean kTD;
    private boolean kTE;
    private SubPbRequestMessage kTF;
    private String kTl;
    private String kTm;
    private String kTn;
    private String kTo;
    private boolean kTp;
    private String kTq;
    private boolean kTr;
    private String kTs;
    private a kTt;
    private int kTu;
    private ArrayList<IconData> kTv;
    private AttentionHostData kTw;
    private boolean kTx;
    private ArrayList<p> kTy;
    private SmallTailInfo kTz;
    private int kwZ;
    private boolean kyt;
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
            this.kTl = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.jIK = intent.getStringExtra("from_forum_id");
            this.kTq = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.evW = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.kTm = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.kTr = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.kTn = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.kwZ = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.kTz = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.kTz != null) {
                this.kTz.updateShowInfo();
            }
            this.eAp = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.kTv = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.kTx = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.kTC = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.kTC.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.kTB = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.kTD = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.kTo = intent.getStringExtra("high_light_post_id");
            this.kTp = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.kTl = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.jIK = bundle.getString("from_forum_id");
            this.kTq = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.evW = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.kTm = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.kTr = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.kTn = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.kwZ = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.kTz = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.kTz != null) {
                this.kTz.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.eAp = new AntiData();
                this.eAp.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!y.isEmpty(stringArrayList)) {
                this.kTv = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.kTv.add(iconData);
                    }
                }
            }
            this.kTx = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.kTo = bundle.getString("high_light_post_id");
            this.kTp = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        }
    }

    public void aC(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.kTl);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.evW);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.kTm);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.kTn);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.kTr);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.kwZ);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.kTz));
            if (this.eAp != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.eAp.toJsonString());
            }
            if (!y.isEmpty(this.kTv)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.kTv.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.jIK);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.kTq);
            bundle.putString("high_light_post_id", this.kTo);
            bundle.putBoolean("high_light_post_id", this.kTp);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fcA = 0;
        this.kTl = null;
        this.postID = null;
        this.stType = null;
        this.evW = false;
        this.kTm = null;
        this.kTn = null;
        this.kTo = null;
        this.kTp = false;
        this.pageFromType = 0;
        this.kTr = false;
        this.kyt = false;
        this.kwZ = 0;
        this.kTs = null;
        this.efr = null;
        this.kQQ = null;
        this.kTt = null;
        this.kTu = 0;
        this.kTx = false;
        this.kTy = null;
        this.isLoading = false;
        this.hyf = null;
        this.kTD = true;
        this.mOffset = 0;
        this.kCX = null;
        this.kQT = null;
        this.kTE = false;
        this.kQU = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.efr.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.kTy.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.kTy.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.kTy != null && SubPbModel.this.kTy.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.kTy.size() - 1; size >= 0; size--) {
                                p pVar2 = (p) SubPbModel.this.kTy.get(size);
                                if (SubPbModel.this.kTA) {
                                    SubPbModel.this.kQQ.c(pVar2, true);
                                } else {
                                    SubPbModel.this.kQQ.b(pVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.kTy.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.hyf == null) {
                        SubPbModel.this.hyf = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.hyf != null) {
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
                            SubPbModel.this.hyf.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.hyf = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.hyf = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.kTt != null) {
                                SubPbModel.this.kTt.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                pVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                pVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (pVar.cWh().errorno.intValue() != 0) {
                                if (SubPbModel.this.kTt != null) {
                                    SubPbModel.this.kTt.a(false, pVar.kyu.errorno.intValue(), pVar.kyu.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (pVar.bce() != null && pVar.bce().beE() != null) {
                                pVar.bce().beE().getUserId();
                                if (y.isEmpty(pVar.cWi().beE().getIconInfo()) && SubPbModel.this.kTv != null) {
                                    pVar.cWi().beE().setIconInfo(SubPbModel.this.kTv);
                                }
                            }
                            if (pVar.cWi() != null) {
                                SubPbModel.this.postID = pVar.cWi().getId();
                            }
                            if (pVar.bce() != null) {
                                SubPbModel.this.kTl = pVar.bce().getId();
                                SubPbModel.this.kyt = pVar.baA();
                                SubPbModel.this.kTs = pVar.bce().beM();
                            }
                            if (SubPbModel.this.kTs != null && SubPbModel.this.postID != null && SubPbModel.this.kTs.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.kyt = true;
                            }
                            if (SubPbModel.this.kTA) {
                                SubPbModel.this.f(pVar);
                            } else {
                                SubPbModel.this.e(pVar);
                            }
                            if (SubPbModel.this.kTt != null) {
                                SubPbModel.this.kTt.a(SubPbModel.this.dcZ(), error, errorString, SubPbModel.this.kQQ);
                            }
                        }
                    }
                }
            }
        };
        this.efr = tbPageContext;
        this.kTy = new ArrayList<>();
        this.kQQ = new p();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.kQU);
        registerListener(this.kQU);
    }

    public String cYC() {
        return this.kTl;
    }

    public String cYD() {
        return (StringUtils.isNull(this.kTl) || "0".equals(this.kTl)) ? this.oriUgcNid : this.kTl;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String brT() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public p dcY() {
        return this.kQQ;
    }

    public AntiData ckU() {
        return this.eAp;
    }

    public boolean dcZ() {
        return (this.kQQ == null || this.kQQ.cWi() == null) ? false : true;
    }

    public void a(a aVar) {
        this.kTt = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.kTl);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.kTl);
        markData.setFloor(postData.dwK());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.kQU);
        if (this.kCX != null) {
            this.kCX.unRegisterListener();
        }
        cgf();
    }

    private void cgf() {
        if (this.hyf != null) {
            this.hyf.destory();
            this.hyf = null;
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

    public void Oa(String str) {
        if (!TextUtils.isEmpty(str) && this.kQQ != null && this.kQQ.cWm() != null) {
            ArrayList<PostData> cWm = this.kQQ.cWm();
            int size = cWm.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(cWm.get(i).getId())) {
                    cWm.remove(i);
                    this.kTu++;
                    this.kQQ.setTotalCount(this.kQQ.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int dda() {
        int bzE = this.kQQ.bzE();
        if (bzE == 0) {
            return bzE + 1;
        }
        if (this.fcA == 0) {
            return bzE + 1;
        }
        if (this.fcA == 2 && this.kQQ.cWm().size() != 0 && this.kQQ.cWm().size() % this.kQQ.getPageSize() == 0) {
            return bzE + 1;
        }
        if (this.fcA == 3 && this.kTA) {
            return this.kQQ.cWk() - 1;
        }
        if (this.fcA == 3 && bzE > 0) {
            return this.kQQ.cWj() - 1;
        }
        return bzE;
    }

    private SubPbRequestMessage dcg() {
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
        if (1 != this.fcA) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else if (!at.isEmpty(this.oriUgcNid)) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
            j2 = com.baidu.adp.lib.f.b.toLong(this.kTn, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.kTn, 0L);
        }
        if (num == null) {
            intValue = dda();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.kTA && this.fcA == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.efr.getPageActivity(), Long.parseLong(this.kTl), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.jIK, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return EI(0);
    }

    public boolean ddb() {
        return EI(2);
    }

    public void ddc() {
        int pageSize;
        if (this.kTu > 0 && this.kQQ != null && (pageSize = this.kQQ.getPageSize()) > 0) {
            int bzE = this.kQQ.bzE();
            for (int i = (((this.kTu + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.kTF = p(Integer.valueOf(bzE - i));
                this.kTF.setTreatDelPage(true);
                sendMessage(this.kTF);
            }
        }
        this.kTu = 0;
    }

    public boolean ddd() {
        return EI(1);
    }

    public boolean dde() {
        return EI(3);
    }

    public boolean EI(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.kTl == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        ddc();
        this.fcA = i;
        this.kTF = dcg();
        sendMessage(this.kTF);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        ArrayList<PostData> cWm = pVar.cWm();
        if (cWm == null || cWm.size() == 0) {
            pVar.setCurrentPage(this.kQQ.bzE());
        }
        if (this.fcA == 1) {
            this.kQQ = pVar;
        } else if (this.fcA == 2) {
            this.kQQ.b(pVar, true);
        } else if (this.fcA == 3) {
            this.kQQ.a(pVar, false);
        } else {
            this.kQQ.b(pVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(p pVar) {
        if (this.fcA == 1) {
            this.kQQ = pVar;
            this.kQQ.cWl();
        } else if (this.fcA == 2) {
            this.kQQ.c(pVar, true);
        } else if (this.fcA == 3) {
            this.kQQ.d(pVar, false);
        } else {
            this.kQQ.a(pVar);
        }
    }

    public boolean dcy() {
        return this.evW;
    }

    public boolean ddf() {
        return this.kyt;
    }

    public boolean ddg() {
        return "hot_topic".equals(getStType());
    }

    public void tZ(boolean z) {
        this.kyt = z;
    }

    public int cVB() {
        return this.kwZ;
    }

    public String ddh() {
        return this.kTs;
    }

    public void Ob(String str) {
        this.kTs = str;
    }

    public String ddi() {
        return this.kTn;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData BV(String str) {
        if (this.kQQ == null || this.kQQ.bst() == null || this.kQQ.bce() == null || this.kQQ.cWi() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.kQQ.bst().getName());
        writeData.setForumId(this.kQQ.bst().getId());
        writeData.setFromForumId(this.kTq);
        writeData.setFloor(this.kQQ.cWi().getId());
        writeData.setType(2);
        writeData.setThreadId(this.kQQ.bce().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean brS() {
        ddb();
        return true;
    }

    public boolean ddj() {
        return this.kTE;
    }

    public void ua(boolean z) {
        this.kTE = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.kQT = aVar;
    }

    public SmallTailInfo ddk() {
        return this.kTz;
    }

    public boolean ddl() {
        return this.kTx;
    }

    public ConcurrentHashMap<String, ImageUrlData> ddm() {
        return this.kTC;
    }

    public ArrayList<String> ddn() {
        return this.kTB;
    }

    public boolean ddo() {
        return this.kTD;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.jIK;
    }

    public AttentionHostData ddp() {
        if (this.kTw == null) {
            this.kTw = new AttentionHostData();
            if (this.kQQ != null && this.kQQ.bce() != null && this.kQQ.bce().beE() != null) {
                this.kTw.parserWithMetaData(this.kQQ.bce().beE());
            }
        }
        return this.kTw;
    }

    public int ddq() {
        return this.pageFromType;
    }

    public String cYB() {
        return this.kTo;
    }

    public boolean ddr() {
        return this.kTp;
    }
}
