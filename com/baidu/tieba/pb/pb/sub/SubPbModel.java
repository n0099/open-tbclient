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
/* loaded from: classes21.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private AntiData eCu;
    private TbPageContext<?> ehG;
    private boolean eyb;
    private int ffs;
    private com.baidu.tieba.tbadkCore.d.b hFh;
    private boolean isLoading;
    private String jRm;
    private boolean kGQ;
    private PbFakeFloorModel kLv;
    private p kZs;
    private PbFakeFloorModel.a kZv;
    private com.baidu.adp.framework.listener.a kZw;
    private String lbP;
    private String lbQ;
    private String lbR;
    private String lbS;
    private boolean lbT;
    private String lbU;
    private boolean lbV;
    private String lbW;
    private a lbX;
    private int lbY;
    private ArrayList<IconData> lbZ;
    private AttentionHostData lca;
    private boolean lcb;
    private ArrayList<p> lcc;
    private SmallTailInfo lcd;
    private boolean lce;
    private ArrayList<String> lcf;
    private ConcurrentHashMap<String, ImageUrlData> lcg;
    private boolean lch;
    private boolean lci;
    private SubPbRequestMessage lcj;
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

    /* loaded from: classes21.dex */
    public interface a {
        void a(boolean z, int i, String str, p pVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.lbP = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.jRm = intent.getStringExtra("from_forum_id");
            this.lbU = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.eyb = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.lbQ = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.lbV = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.lbR = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.lcd = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.lcd != null) {
                this.lcd.updateShowInfo();
            }
            this.eCu = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.lbZ = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.lcb = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.lcg = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.lcg.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.lcf = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.lch = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.lbS = intent.getStringExtra("high_light_post_id");
            this.lbT = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.lbP = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.jRm = bundle.getString("from_forum_id");
            this.lbU = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.eyb = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.lbQ = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.lbV = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.lbR = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.lcd = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.lcd != null) {
                this.lcd.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.eCu = new AntiData();
                this.eCu.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!y.isEmpty(stringArrayList)) {
                this.lbZ = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.lbZ.add(iconData);
                    }
                }
            }
            this.lcb = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.lbS = bundle.getString("high_light_post_id");
            this.lbT = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        }
    }

    public void aC(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.lbP);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.eyb);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.lbQ);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.lbR);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.lbV);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.userIdentity);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.lcd));
            if (this.eCu != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.eCu.toJsonString());
            }
            if (!y.isEmpty(this.lbZ)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.lbZ.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.jRm);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.lbU);
            bundle.putString("high_light_post_id", this.lbS);
            bundle.putBoolean("high_light_post_id", this.lbT);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.ffs = 0;
        this.lbP = null;
        this.postID = null;
        this.stType = null;
        this.eyb = false;
        this.lbQ = null;
        this.lbR = null;
        this.lbS = null;
        this.lbT = false;
        this.pageFromType = 0;
        this.lbV = false;
        this.kGQ = false;
        this.userIdentity = 0;
        this.lbW = null;
        this.ehG = null;
        this.kZs = null;
        this.lbX = null;
        this.lbY = 0;
        this.lcb = false;
        this.lcc = null;
        this.isLoading = false;
        this.hFh = null;
        this.lch = true;
        this.mOffset = 0;
        this.kLv = null;
        this.kZv = null;
        this.lci = false;
        this.kZw = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.ehG.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.lcc.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.lcc.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.lcc != null && SubPbModel.this.lcc.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.lcc.size() - 1; size >= 0; size--) {
                                p pVar2 = (p) SubPbModel.this.lcc.get(size);
                                if (SubPbModel.this.lce) {
                                    SubPbModel.this.kZs.c(pVar2, true);
                                } else {
                                    SubPbModel.this.kZs.b(pVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.lcc.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.hFh == null) {
                        SubPbModel.this.hFh = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.hFh != null) {
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
                            SubPbModel.this.hFh.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.hFh = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.hFh = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.lbX != null) {
                                SubPbModel.this.lbX.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                pVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                pVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (pVar.cZL().errorno.intValue() != 0) {
                                if (SubPbModel.this.lbX != null) {
                                    SubPbModel.this.lbX.a(false, pVar.kGR.errorno.intValue(), pVar.kGR.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (pVar.bcY() != null && pVar.bcY().bfy() != null) {
                                pVar.bcY().bfy().getUserId();
                                if (y.isEmpty(pVar.cZH().bfy().getIconInfo()) && SubPbModel.this.lbZ != null) {
                                    pVar.cZH().bfy().setIconInfo(SubPbModel.this.lbZ);
                                }
                            }
                            if (pVar.cZH() != null) {
                                SubPbModel.this.postID = pVar.cZH().getId();
                            }
                            if (pVar.bcY() != null) {
                                SubPbModel.this.lbP = pVar.bcY().getId();
                                SubPbModel.this.kGQ = pVar.bbu();
                                SubPbModel.this.lbW = pVar.bcY().bfG();
                            }
                            if (SubPbModel.this.lbW != null && SubPbModel.this.postID != null && SubPbModel.this.lbW.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.kGQ = true;
                            }
                            if (SubPbModel.this.lce) {
                                SubPbModel.this.f(pVar);
                            } else {
                                SubPbModel.this.e(pVar);
                            }
                            if (SubPbModel.this.lbX != null) {
                                SubPbModel.this.lbX.a(SubPbModel.this.dgD(), error, errorString, SubPbModel.this.kZs);
                            }
                        }
                    }
                }
            }
        };
        this.ehG = tbPageContext;
        this.lcc = new ArrayList<>();
        this.kZs = new p();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.kZw);
        registerListener(this.kZw);
    }

    public String dcf() {
        return this.lbP;
    }

    public String dcg() {
        return (StringUtils.isNull(this.lbP) || "0".equals(this.lbP)) ? this.oriUgcNid : this.lbP;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bsX() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public p dgC() {
        return this.kZs;
    }

    public AntiData coh() {
        return this.eCu;
    }

    public boolean dgD() {
        return (this.kZs == null || this.kZs.cZH() == null) ? false : true;
    }

    public void a(a aVar) {
        this.lbX = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lbP);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.lbP);
        markData.setFloor(postData.dAD());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.kZw);
        if (this.kLv != null) {
            this.kLv.unRegisterListener();
        }
        cjw();
    }

    private void cjw() {
        if (this.hFh != null) {
            this.hFh.destory();
            this.hFh = null;
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

    public void OB(String str) {
        if (!TextUtils.isEmpty(str) && this.kZs != null && this.kZs.cZP() != null) {
            ArrayList<PostData> cZP = this.kZs.cZP();
            int size = cZP.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(cZP.get(i).getId())) {
                    cZP.remove(i);
                    this.lbY++;
                    this.kZs.setTotalCount(this.kZs.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int dgE() {
        int bAN = this.kZs.bAN();
        if (bAN == 0) {
            return bAN + 1;
        }
        if (this.ffs == 0) {
            return bAN + 1;
        }
        if (this.ffs == 2 && this.kZs.cZP().size() != 0 && this.kZs.cZP().size() % this.kZs.getPageSize() == 0) {
            return bAN + 1;
        }
        if (this.ffs == 3 && this.lce) {
            return this.kZs.cZN() - 1;
        }
        if (this.ffs == 3 && bAN > 0) {
            return this.kZs.cZM() - 1;
        }
        return bAN;
    }

    private SubPbRequestMessage dfK() {
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
        if (1 != this.ffs) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else if (!at.isEmpty(this.oriUgcNid)) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
            j2 = com.baidu.adp.lib.f.b.toLong(this.lbR, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.lbR, 0L);
        }
        if (num == null) {
            intValue = dgE();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.lce && this.ffs == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.ehG.getPageActivity(), Long.parseLong(this.lbP), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.jRm, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return Fj(0);
    }

    public boolean dgF() {
        return Fj(2);
    }

    public void dgG() {
        int pageSize;
        if (this.lbY > 0 && this.kZs != null && (pageSize = this.kZs.getPageSize()) > 0) {
            int bAN = this.kZs.bAN();
            for (int i = (((this.lbY + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.lcj = p(Integer.valueOf(bAN - i));
                this.lcj.setTreatDelPage(true);
                sendMessage(this.lcj);
            }
        }
        this.lbY = 0;
    }

    public boolean dgH() {
        return Fj(1);
    }

    public boolean dgI() {
        return Fj(3);
    }

    public boolean Fj(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.lbP == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        dgG();
        this.ffs = i;
        this.lcj = dfK();
        sendMessage(this.lcj);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        ArrayList<PostData> cZP = pVar.cZP();
        if (cZP == null || cZP.size() == 0) {
            pVar.setCurrentPage(this.kZs.bAN());
        }
        if (this.ffs == 1) {
            this.kZs = pVar;
        } else if (this.ffs == 2) {
            this.kZs.b(pVar, true);
        } else if (this.ffs == 3) {
            this.kZs.a(pVar, false);
        } else {
            this.kZs.b(pVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(p pVar) {
        if (this.ffs == 1) {
            this.kZs = pVar;
            this.kZs.cZO();
        } else if (this.ffs == 2) {
            this.kZs.c(pVar, true);
        } else if (this.ffs == 3) {
            this.kZs.d(pVar, false);
        } else {
            this.kZs.a(pVar);
        }
    }

    public boolean dgc() {
        return this.eyb;
    }

    public boolean dgJ() {
        return this.kGQ;
    }

    public boolean dgK() {
        return "hot_topic".equals(getStType());
    }

    public void uh(boolean z) {
        this.kGQ = z;
    }

    public int cZg() {
        return this.userIdentity;
    }

    public String dgL() {
        return this.lbW;
    }

    public void OC(String str) {
        this.lbW = str;
    }

    public String dgM() {
        return this.lbR;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData Cr(String str) {
        if (this.kZs == null || this.kZs.btx() == null || this.kZs.bcY() == null || this.kZs.cZH() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.kZs.btx().getName());
        writeData.setForumId(this.kZs.btx().getId());
        writeData.setFromForumId(this.lbU);
        writeData.setFloor(this.kZs.cZH().getId());
        writeData.setType(2);
        writeData.setThreadId(this.kZs.bcY().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bsW() {
        dgF();
        return true;
    }

    public boolean dgN() {
        return this.lci;
    }

    public void ui(boolean z) {
        this.lci = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.kZv = aVar;
    }

    public SmallTailInfo dgO() {
        return this.lcd;
    }

    public boolean dgP() {
        return this.lcb;
    }

    public ConcurrentHashMap<String, ImageUrlData> dgQ() {
        return this.lcg;
    }

    public ArrayList<String> dgR() {
        return this.lcf;
    }

    public boolean dgS() {
        return this.lch;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.jRm;
    }

    public AttentionHostData dgT() {
        if (this.lca == null) {
            this.lca = new AttentionHostData();
            if (this.kZs != null && this.kZs.bcY() != null && this.kZs.bcY().bfy() != null) {
                this.lca.parserWithMetaData(this.kZs.bcY().bfy());
            }
        }
        return this.lca;
    }

    public int dgU() {
        return this.pageFromType;
    }

    public String dce() {
        return this.lbS;
    }

    public boolean dgV() {
        return this.lbT;
    }
}
