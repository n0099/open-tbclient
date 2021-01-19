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
/* loaded from: classes2.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private TbPageContext<?> eSJ;
    private int fSe;
    private boolean fjY;
    private AntiData fos;
    private int gcd;
    private String gce;
    private com.baidu.tieba.tbadkCore.d.b iFP;
    private boolean isLoading;
    private int isManager;
    private String kNb;
    private boolean lCQ;
    private PbFakeFloorModel lHU;
    private p lWb;
    private PbFakeFloorModel.a lWe;
    private com.baidu.adp.framework.listener.a lWf;
    private String lYA;
    private String lYB;
    private boolean lYC;
    private String lYD;
    private boolean lYE;
    private String lYF;
    private a lYG;
    private int lYH;
    private ArrayList<IconData> lYI;
    private AttentionHostData lYJ;
    private boolean lYK;
    private ArrayList<p> lYL;
    private SmallTailInfo lYM;
    private boolean lYN;
    private ArrayList<String> lYO;
    private ConcurrentHashMap<String, ImageUrlData> lYP;
    private boolean lYQ;
    private boolean lYR;
    private int lYS;
    private int lYT;
    private SubPbRequestMessage lYU;
    private String lYy;
    private String lYz;
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
    private int userLevel;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z, int i, String str, p pVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.lYy = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.kNb = intent.getStringExtra("from_forum_id");
            this.lYD = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.fjY = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.lYz = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.lYE = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.lYA = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.lYM = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.lYM != null) {
                this.lYM.updateShowInfo();
            }
            this.fos = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.lYI = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.lYK = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.lYP = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.lYP.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.lYO = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.lYQ = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.lYB = intent.getStringExtra("high_light_post_id");
            this.lYC = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
            this.gcd = intent.getIntExtra(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = intent.getIntExtra(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.lYS = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
            this.lYT = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
            this.gce = intent.getStringExtra(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
            this.userLevel = intent.getIntExtra(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.lYy = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.kNb = bundle.getString("from_forum_id");
            this.lYD = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.fjY = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.lYz = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.lYE = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.lYA = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.lYM = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.lYM != null) {
                this.lYM.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.fos = new AntiData();
                this.fos.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!x.isEmpty(stringArrayList)) {
                this.lYI = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.lYI.add(iconData);
                    }
                }
            }
            this.lYK = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.lYB = bundle.getString("high_light_post_id");
            this.lYC = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
            this.gcd = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.gcd = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.lYS = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
            this.lYT = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
            this.gce = bundle.getString(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
            this.userLevel = bundle.getInt(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        }
    }

    public void aD(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.lYy);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fjY);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.lYz);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.lYA);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.lYE);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.userIdentity);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.lYM));
            if (this.fos != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.fos.toJsonString());
            }
            if (!x.isEmpty(this.lYI)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.lYI.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.kNb);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.lYD);
            bundle.putString("high_light_post_id", this.lYB);
            bundle.putBoolean("high_light_post_id", this.lYC);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fSe = 0;
        this.lYy = null;
        this.postID = null;
        this.stType = null;
        this.fjY = false;
        this.lYz = null;
        this.lYA = null;
        this.lYB = null;
        this.lYC = false;
        this.pageFromType = 0;
        this.lYE = false;
        this.lCQ = false;
        this.userIdentity = 0;
        this.lYF = null;
        this.eSJ = null;
        this.lWb = null;
        this.lYG = null;
        this.lYH = 0;
        this.lYK = false;
        this.lYL = null;
        this.isLoading = false;
        this.iFP = null;
        this.lYQ = true;
        this.mOffset = 0;
        this.lHU = null;
        this.lWe = null;
        this.lYR = false;
        this.lWf = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                boolean z;
                p pVar;
                long j2;
                long j3 = 0;
                if (SubPbModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    SubPbModel.this.isLoading = false;
                    if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                        SubPbModel.this.eSJ.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.lYL.add(subPbHttpResponseMessage.pbFloorData);
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
                        j3 = responsedMessage.getCostTime();
                        SubPbSocketResponseMessage subPbSocketResponseMessage = (SubPbSocketResponseMessage) responsedMessage;
                        if (subPbSocketResponseMessage.isTreatDelPage()) {
                            if (!subPbSocketResponseMessage.hasError()) {
                                SubPbModel.this.lYL.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    long j4 = j3;
                    if (SubPbModel.this.lYL != null && SubPbModel.this.lYL.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.lYL.size() - 1; size >= 0; size--) {
                                p pVar2 = (p) SubPbModel.this.lYL.get(size);
                                if (SubPbModel.this.lYN) {
                                    SubPbModel.this.lWb.c(pVar2, true);
                                } else {
                                    SubPbModel.this.lWb.b(pVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.lYL.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.iFP == null) {
                        SubPbModel.this.iFP = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.iFP != null) {
                        if (error == 0) {
                            int i = -1;
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                i = ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                                j2 = responsedMessage.getCostTime();
                            } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                                i = ((SubPbSocketResponseMessage) responsedMessage).getDownSize();
                                j4 = responsedMessage.getCostTime();
                                j2 = j;
                            } else {
                                j2 = j;
                            }
                            SubPbModel.this.iFP.a(z, true, error, errorString, i, j2, j4);
                            SubPbModel.this.iFP = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.iFP = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.lYG != null) {
                                SubPbModel.this.lYG.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                pVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                pVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (pVar.djJ().errorno.intValue() != 0) {
                                if (SubPbModel.this.lYG != null) {
                                    SubPbModel.this.lYG.a(false, pVar.lCR.errorno.intValue(), pVar.lCR.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (pVar.bkV() != null && pVar.bkV().bnx() != null) {
                                pVar.bkV().bnx().getUserId();
                                if (x.isEmpty(pVar.djF().bnx().getIconInfo()) && SubPbModel.this.lYI != null) {
                                    pVar.djF().bnx().setIconInfo(SubPbModel.this.lYI);
                                }
                            }
                            if (pVar.djF() != null) {
                                SubPbModel.this.postID = pVar.djF().getId();
                            }
                            if (pVar.bkV() != null) {
                                SubPbModel.this.lYy = pVar.bkV().getId();
                                SubPbModel.this.lCQ = pVar.bjE();
                                SubPbModel.this.lYF = pVar.bkV().bnF();
                            }
                            if (SubPbModel.this.lYF != null && SubPbModel.this.postID != null && SubPbModel.this.lYF.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.lCQ = true;
                            }
                            if (SubPbModel.this.lYN) {
                                SubPbModel.this.f(pVar);
                            } else {
                                SubPbModel.this.e(pVar);
                            }
                            if (SubPbModel.this.lYG != null) {
                                SubPbModel.this.lYG.a(SubPbModel.this.dqM(), error, errorString, SubPbModel.this.lWb);
                            }
                        }
                    }
                }
            }
        };
        this.eSJ = tbPageContext;
        this.lYL = new ArrayList<>();
        this.lWb = new p();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.lWf);
        registerListener(this.lWf);
    }

    public String dme() {
        return this.lYy;
    }

    public String dmf() {
        return (StringUtils.isNull(this.lYy) || "0".equals(this.lYy)) ? this.oriUgcNid : this.lYy;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bBr() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public p dqL() {
        return this.lWb;
    }

    public AntiData cAh() {
        return this.fos;
    }

    public boolean dqM() {
        return (this.lWb == null || this.lWb.djF() == null) ? false : true;
    }

    public void a(a aVar) {
        this.lYG = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lYy);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.lYy);
        markData.setFloor(postData.dLm());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.lWf);
        if (this.lHU != null) {
            this.lHU.unRegisterListener();
        }
        cvv();
    }

    private void cvv() {
        if (this.iFP != null) {
            this.iFP.destory();
            this.iFP = null;
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

    public void Ph(String str) {
        if (!TextUtils.isEmpty(str) && this.lWb != null && this.lWb.djN() != null) {
            ArrayList<PostData> djN = this.lWb.djN();
            int size = djN.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(djN.get(i).getId())) {
                    djN.remove(i);
                    this.lYH++;
                    this.lWb.setTotalCount(this.lWb.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int dqN() {
        int bJl = this.lWb.bJl();
        if (bJl == 0) {
            return bJl + 1;
        }
        if (this.fSe == 0) {
            return bJl + 1;
        }
        if (this.fSe == 2 && this.lWb.djN().size() != 0 && this.lWb.djN().size() % this.lWb.getPageSize() == 0) {
            return bJl + 1;
        }
        if (this.fSe == 3 && this.lYN) {
            return this.lWb.djL() - 1;
        }
        if (this.fSe == 3 && bJl > 0) {
            return this.lWb.djK() - 1;
        }
        return bJl;
    }

    private SubPbRequestMessage dpS() {
        this.isLoading = true;
        return t(null);
    }

    private SubPbRequestMessage t(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.fSe) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else if (!at.isEmpty(this.oriUgcNid)) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
            j2 = com.baidu.adp.lib.f.b.toLong(this.lYA, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.lYA, 0L);
        }
        if (num == null) {
            intValue = dqN();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.lYN && this.fSe == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.eSJ.getPageActivity(), Long.parseLong(this.lYy), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.kNb, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return FX(0);
    }

    public boolean dqO() {
        return FX(2);
    }

    public void dqP() {
        int pageSize;
        if (this.lYH > 0 && this.lWb != null && (pageSize = this.lWb.getPageSize()) > 0) {
            int bJl = this.lWb.bJl();
            for (int i = (((this.lYH + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.lYU = t(Integer.valueOf(bJl - i));
                this.lYU.setTreatDelPage(true);
                sendMessage(this.lYU);
            }
        }
        this.lYH = 0;
    }

    public boolean dqQ() {
        return FX(1);
    }

    public boolean dqR() {
        return FX(3);
    }

    public boolean FX(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.lYy == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        dqP();
        this.fSe = i;
        this.lYU = dpS();
        sendMessage(this.lYU);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        ArrayList<PostData> djN = pVar.djN();
        if (djN == null || djN.size() == 0) {
            pVar.setCurrentPage(this.lWb.bJl());
        }
        if (this.fSe == 1) {
            this.lWb = pVar;
        } else if (this.fSe == 2) {
            this.lWb.b(pVar, true);
        } else if (this.fSe == 3) {
            this.lWb.a(pVar, false);
        } else {
            this.lWb.b(pVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(p pVar) {
        if (this.fSe == 1) {
            this.lWb = pVar;
            this.lWb.djM();
        } else if (this.fSe == 2) {
            this.lWb.c(pVar, true);
        } else if (this.fSe == 3) {
            this.lWb.d(pVar, false);
        } else {
            this.lWb.a(pVar);
        }
    }

    public boolean dql() {
        return this.fjY;
    }

    public boolean dqS() {
        return this.lCQ;
    }

    public boolean dqT() {
        return "hot_topic".equals(getStType());
    }

    public void vR(boolean z) {
        this.lCQ = z;
    }

    public int djc() {
        return this.userIdentity;
    }

    public String dqU() {
        return this.lYF;
    }

    public void Pi(String str) {
        this.lYF = str;
    }

    public String dqV() {
        return this.lYA;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData CC(String str) {
        if (this.lWb == null || this.lWb.bBS() == null || this.lWb.bkV() == null || this.lWb.djF() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.lWb.bBS().getName());
        writeData.setForumId(this.lWb.bBS().getId());
        writeData.setFromForumId(this.lYD);
        writeData.setFloor(this.lWb.djF().getId());
        writeData.setType(2);
        writeData.setThreadId(this.lWb.bkV().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bBq() {
        dqO();
        return true;
    }

    public boolean dqW() {
        return this.lYR;
    }

    public void vS(boolean z) {
        this.lYR = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.lWe = aVar;
    }

    public SmallTailInfo dqX() {
        return this.lYM;
    }

    public boolean dqY() {
        return this.lYK;
    }

    public ConcurrentHashMap<String, ImageUrlData> dqZ() {
        return this.lYP;
    }

    public ArrayList<String> dra() {
        return this.lYO;
    }

    public boolean drb() {
        return this.lYQ;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.kNb;
    }

    public AttentionHostData drc() {
        if (this.lYJ == null) {
            this.lYJ = new AttentionHostData();
            if (this.lWb != null && this.lWb.bkV() != null && this.lWb.bkV().bnx() != null) {
                this.lYJ.parserWithMetaData(this.lWb.bkV().bnx());
            }
        }
        return this.lYJ;
    }

    public int drd() {
        return this.pageFromType;
    }

    public String dmd() {
        return this.lYB;
    }

    public boolean dre() {
        return this.lYC;
    }

    public int bJZ() {
        return this.gcd;
    }

    public int getIsManager() {
        return this.isManager;
    }

    public int drf() {
        return this.lYT;
    }

    public int drg() {
        return this.lYS;
    }

    public String bKc() {
        return this.gce;
    }

    public int bKd() {
        return this.userLevel;
    }
}
