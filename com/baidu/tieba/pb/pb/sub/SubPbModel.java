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
    private TbPageContext<?> eIc;
    private boolean eYv;
    private int fFU;
    private AntiData fcN;
    private com.baidu.tieba.tbadkCore.d.b imA;
    private boolean isLoading;
    private String kyF;
    private p lHf;
    private PbFakeFloorModel.a lHi;
    private com.baidu.adp.framework.listener.a lHj;
    private String lJB;
    private String lJC;
    private String lJD;
    private String lJE;
    private boolean lJF;
    private String lJG;
    private boolean lJH;
    private String lJI;
    private a lJJ;
    private int lJK;
    private ArrayList<IconData> lJL;
    private AttentionHostData lJM;
    private boolean lJN;
    private ArrayList<p> lJO;
    private SmallTailInfo lJP;
    private boolean lJQ;
    private ArrayList<String> lJR;
    private ConcurrentHashMap<String, ImageUrlData> lJS;
    private boolean lJT;
    private boolean lJU;
    private SubPbRequestMessage lJV;
    private boolean loB;
    private PbFakeFloorModel ltg;
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
            this.lJB = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.kyF = intent.getStringExtra("from_forum_id");
            this.lJG = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.eYv = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.lJC = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.lJH = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.lJD = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.lJP = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.lJP != null) {
                this.lJP.updateShowInfo();
            }
            this.fcN = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.lJL = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.lJN = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.lJS = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.lJS.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.lJR = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.lJT = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.lJE = intent.getStringExtra("high_light_post_id");
            this.lJF = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.lJB = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.kyF = bundle.getString("from_forum_id");
            this.lJG = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.eYv = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.lJC = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.lJH = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.lJD = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.lJP = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.lJP != null) {
                this.lJP.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.fcN = new AntiData();
                this.fcN.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!y.isEmpty(stringArrayList)) {
                this.lJL = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.lJL.add(iconData);
                    }
                }
            }
            this.lJN = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.lJE = bundle.getString("high_light_post_id");
            this.lJF = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        }
    }

    public void aC(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.lJB);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.eYv);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.lJC);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.lJD);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.lJH);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.userIdentity);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.lJP));
            if (this.fcN != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.fcN.toJsonString());
            }
            if (!y.isEmpty(this.lJL)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.lJL.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.kyF);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.lJG);
            bundle.putString("high_light_post_id", this.lJE);
            bundle.putBoolean("high_light_post_id", this.lJF);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fFU = 0;
        this.lJB = null;
        this.postID = null;
        this.stType = null;
        this.eYv = false;
        this.lJC = null;
        this.lJD = null;
        this.lJE = null;
        this.lJF = false;
        this.pageFromType = 0;
        this.lJH = false;
        this.loB = false;
        this.userIdentity = 0;
        this.lJI = null;
        this.eIc = null;
        this.lHf = null;
        this.lJJ = null;
        this.lJK = 0;
        this.lJN = false;
        this.lJO = null;
        this.isLoading = false;
        this.imA = null;
        this.lJT = true;
        this.mOffset = 0;
        this.ltg = null;
        this.lHi = null;
        this.lJU = false;
        this.lHj = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.eIc.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.lJO.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.lJO.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.lJO != null && SubPbModel.this.lJO.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.lJO.size() - 1; size >= 0; size--) {
                                p pVar2 = (p) SubPbModel.this.lJO.get(size);
                                if (SubPbModel.this.lJQ) {
                                    SubPbModel.this.lHf.c(pVar2, true);
                                } else {
                                    SubPbModel.this.lHf.b(pVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.lJO.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.imA == null) {
                        SubPbModel.this.imA = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.imA != null) {
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
                            SubPbModel.this.imA.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.imA = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.imA = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.lJJ != null) {
                                SubPbModel.this.lJJ.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                pVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                pVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (pVar.dje().errorno.intValue() != 0) {
                                if (SubPbModel.this.lJJ != null) {
                                    SubPbModel.this.lJJ.a(false, pVar.loC.errorno.intValue(), pVar.loC.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (pVar.bjZ() != null && pVar.bjZ().bmA() != null) {
                                pVar.bjZ().bmA().getUserId();
                                if (y.isEmpty(pVar.dja().bmA().getIconInfo()) && SubPbModel.this.lJL != null) {
                                    pVar.dja().bmA().setIconInfo(SubPbModel.this.lJL);
                                }
                            }
                            if (pVar.dja() != null) {
                                SubPbModel.this.postID = pVar.dja().getId();
                            }
                            if (pVar.bjZ() != null) {
                                SubPbModel.this.lJB = pVar.bjZ().getId();
                                SubPbModel.this.loB = pVar.biv();
                                SubPbModel.this.lJI = pVar.bjZ().bmI();
                            }
                            if (SubPbModel.this.lJI != null && SubPbModel.this.postID != null && SubPbModel.this.lJI.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.loB = true;
                            }
                            if (SubPbModel.this.lJQ) {
                                SubPbModel.this.f(pVar);
                            } else {
                                SubPbModel.this.e(pVar);
                            }
                            if (SubPbModel.this.lJJ != null) {
                                SubPbModel.this.lJJ.a(SubPbModel.this.dpW(), error, errorString, SubPbModel.this.lHf);
                            }
                        }
                    }
                }
            }
        };
        this.eIc = tbPageContext;
        this.lJO = new ArrayList<>();
        this.lHf = new p();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.lHj);
        registerListener(this.lHj);
    }

    public String dlx() {
        return this.lJB;
    }

    public String dly() {
        return (StringUtils.isNull(this.lJB) || "0".equals(this.lJB)) ? this.oriUgcNid : this.lJB;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bzZ() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public p dpV() {
        return this.lHf;
    }

    public AntiData cxn() {
        return this.fcN;
    }

    public boolean dpW() {
        return (this.lHf == null || this.lHf.dja() == null) ? false : true;
    }

    public void a(a aVar) {
        this.lJJ = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lJB);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.lJB);
        markData.setFloor(postData.dJZ());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.lHj);
        if (this.ltg != null) {
            this.ltg.unRegisterListener();
        }
        csA();
    }

    private void csA() {
        if (this.imA != null) {
            this.imA.destory();
            this.imA = null;
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

    public void Qf(String str) {
        if (!TextUtils.isEmpty(str) && this.lHf != null && this.lHf.dji() != null) {
            ArrayList<PostData> dji = this.lHf.dji();
            int size = dji.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(dji.get(i).getId())) {
                    dji.remove(i);
                    this.lJK++;
                    this.lHf.setTotalCount(this.lHf.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int dpX() {
        int bHR = this.lHf.bHR();
        if (bHR == 0) {
            return bHR + 1;
        }
        if (this.fFU == 0) {
            return bHR + 1;
        }
        if (this.fFU == 2 && this.lHf.dji().size() != 0 && this.lHf.dji().size() % this.lHf.getPageSize() == 0) {
            return bHR + 1;
        }
        if (this.fFU == 3 && this.lJQ) {
            return this.lHf.djg() - 1;
        }
        if (this.fFU == 3 && bHR > 0) {
            return this.lHf.djf() - 1;
        }
        return bHR;
    }

    private SubPbRequestMessage dpd() {
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
        if (1 != this.fFU) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else if (!at.isEmpty(this.oriUgcNid)) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
            j2 = com.baidu.adp.lib.f.b.toLong(this.lJD, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.lJD, 0L);
        }
        if (num == null) {
            intValue = dpX();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.lJQ && this.fFU == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.eIc.getPageActivity(), Long.parseLong(this.lJB), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.kyF, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return Gv(0);
    }

    public boolean dpY() {
        return Gv(2);
    }

    public void dpZ() {
        int pageSize;
        if (this.lJK > 0 && this.lHf != null && (pageSize = this.lHf.getPageSize()) > 0) {
            int bHR = this.lHf.bHR();
            for (int i = (((this.lJK + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.lJV = r(Integer.valueOf(bHR - i));
                this.lJV.setTreatDelPage(true);
                sendMessage(this.lJV);
            }
        }
        this.lJK = 0;
    }

    public boolean dqa() {
        return Gv(1);
    }

    public boolean dqb() {
        return Gv(3);
    }

    public boolean Gv(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.lJB == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        dpZ();
        this.fFU = i;
        this.lJV = dpd();
        sendMessage(this.lJV);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        ArrayList<PostData> dji = pVar.dji();
        if (dji == null || dji.size() == 0) {
            pVar.setCurrentPage(this.lHf.bHR());
        }
        if (this.fFU == 1) {
            this.lHf = pVar;
        } else if (this.fFU == 2) {
            this.lHf.b(pVar, true);
        } else if (this.fFU == 3) {
            this.lHf.a(pVar, false);
        } else {
            this.lHf.b(pVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(p pVar) {
        if (this.fFU == 1) {
            this.lHf = pVar;
            this.lHf.djh();
        } else if (this.fFU == 2) {
            this.lHf.c(pVar, true);
        } else if (this.fFU == 3) {
            this.lHf.d(pVar, false);
        } else {
            this.lHf.a(pVar);
        }
    }

    public boolean dpv() {
        return this.eYv;
    }

    public boolean dqc() {
        return this.loB;
    }

    public boolean dqd() {
        return "hot_topic".equals(getStType());
    }

    public void vo(boolean z) {
        this.loB = z;
    }

    public int diz() {
        return this.userIdentity;
    }

    public String dqe() {
        return this.lJI;
    }

    public void Qg(String str) {
        this.lJI = str;
    }

    public String dqf() {
        return this.lJD;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData DK(String str) {
        if (this.lHf == null || this.lHf.bAz() == null || this.lHf.bjZ() == null || this.lHf.dja() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.lHf.bAz().getName());
        writeData.setForumId(this.lHf.bAz().getId());
        writeData.setFromForumId(this.lJG);
        writeData.setFloor(this.lHf.dja().getId());
        writeData.setType(2);
        writeData.setThreadId(this.lHf.bjZ().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bzY() {
        dpY();
        return true;
    }

    public boolean dqg() {
        return this.lJU;
    }

    public void vp(boolean z) {
        this.lJU = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.lHi = aVar;
    }

    public SmallTailInfo dqh() {
        return this.lJP;
    }

    public boolean dqi() {
        return this.lJN;
    }

    public ConcurrentHashMap<String, ImageUrlData> dqj() {
        return this.lJS;
    }

    public ArrayList<String> dqk() {
        return this.lJR;
    }

    public boolean dql() {
        return this.lJT;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.kyF;
    }

    public AttentionHostData dqm() {
        if (this.lJM == null) {
            this.lJM = new AttentionHostData();
            if (this.lHf != null && this.lHf.bjZ() != null && this.lHf.bjZ().bmA() != null) {
                this.lJM.parserWithMetaData(this.lHf.bjZ().bmA());
            }
        }
        return this.lJM;
    }

    public int dqn() {
        return this.pageFromType;
    }

    public String dlw() {
        return this.lJE;
    }

    public boolean dqo() {
        return this.lJF;
    }
}
