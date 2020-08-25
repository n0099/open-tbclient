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
    private AntiData eAl;
    private TbPageContext<?> efn;
    private boolean evS;
    private int fcw;
    private com.baidu.tieba.tbadkCore.d.b hxZ;
    private boolean isLoading;
    private String jIE;
    private PbFakeFloorModel kCQ;
    private p kQJ;
    private PbFakeFloorModel.a kQM;
    private com.baidu.adp.framework.listener.a kQN;
    private String kTe;
    private String kTf;
    private String kTg;
    private String kTh;
    private boolean kTi;
    private String kTj;
    private boolean kTk;
    private String kTl;
    private a kTm;
    private int kTn;
    private ArrayList<IconData> kTo;
    private AttentionHostData kTp;
    private boolean kTq;
    private ArrayList<p> kTr;
    private SmallTailInfo kTs;
    private boolean kTt;
    private ArrayList<String> kTu;
    private ConcurrentHashMap<String, ImageUrlData> kTv;
    private boolean kTw;
    private boolean kTx;
    private SubPbRequestMessage kTy;
    private int kwS;
    private boolean kym;
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
            this.kTe = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.jIE = intent.getStringExtra("from_forum_id");
            this.kTj = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.evS = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.kTf = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.kTk = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.kTg = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.kwS = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.kTs = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.kTs != null) {
                this.kTs.updateShowInfo();
            }
            this.eAl = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.kTo = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.kTq = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.kTv = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.kTv.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.kTu = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.kTw = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.kTh = intent.getStringExtra("high_light_post_id");
            this.kTi = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.kTe = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.jIE = bundle.getString("from_forum_id");
            this.kTj = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.evS = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.kTf = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.kTk = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.kTg = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.kwS = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.kTs = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.kTs != null) {
                this.kTs.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.eAl = new AntiData();
                this.eAl.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!y.isEmpty(stringArrayList)) {
                this.kTo = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.kTo.add(iconData);
                    }
                }
            }
            this.kTq = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.kTh = bundle.getString("high_light_post_id");
            this.kTi = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        }
    }

    public void aC(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.kTe);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.evS);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.kTf);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.kTg);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.kTk);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.kwS);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.kTs));
            if (this.eAl != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.eAl.toJsonString());
            }
            if (!y.isEmpty(this.kTo)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.kTo.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.jIE);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.kTj);
            bundle.putString("high_light_post_id", this.kTh);
            bundle.putBoolean("high_light_post_id", this.kTi);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fcw = 0;
        this.kTe = null;
        this.postID = null;
        this.stType = null;
        this.evS = false;
        this.kTf = null;
        this.kTg = null;
        this.kTh = null;
        this.kTi = false;
        this.pageFromType = 0;
        this.kTk = false;
        this.kym = false;
        this.kwS = 0;
        this.kTl = null;
        this.efn = null;
        this.kQJ = null;
        this.kTm = null;
        this.kTn = 0;
        this.kTq = false;
        this.kTr = null;
        this.isLoading = false;
        this.hxZ = null;
        this.kTw = true;
        this.mOffset = 0;
        this.kCQ = null;
        this.kQM = null;
        this.kTx = false;
        this.kQN = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.efn.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.kTr.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.kTr.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.kTr != null && SubPbModel.this.kTr.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.kTr.size() - 1; size >= 0; size--) {
                                p pVar2 = (p) SubPbModel.this.kTr.get(size);
                                if (SubPbModel.this.kTt) {
                                    SubPbModel.this.kQJ.c(pVar2, true);
                                } else {
                                    SubPbModel.this.kQJ.b(pVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.kTr.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.hxZ == null) {
                        SubPbModel.this.hxZ = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.hxZ != null) {
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
                            SubPbModel.this.hxZ.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.hxZ = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.hxZ = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.kTm != null) {
                                SubPbModel.this.kTm.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                pVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                pVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (pVar.cWg().errorno.intValue() != 0) {
                                if (SubPbModel.this.kTm != null) {
                                    SubPbModel.this.kTm.a(false, pVar.kyn.errorno.intValue(), pVar.kyn.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (pVar.bce() != null && pVar.bce().beE() != null) {
                                pVar.bce().beE().getUserId();
                                if (y.isEmpty(pVar.cWh().beE().getIconInfo()) && SubPbModel.this.kTo != null) {
                                    pVar.cWh().beE().setIconInfo(SubPbModel.this.kTo);
                                }
                            }
                            if (pVar.cWh() != null) {
                                SubPbModel.this.postID = pVar.cWh().getId();
                            }
                            if (pVar.bce() != null) {
                                SubPbModel.this.kTe = pVar.bce().getId();
                                SubPbModel.this.kym = pVar.baA();
                                SubPbModel.this.kTl = pVar.bce().beM();
                            }
                            if (SubPbModel.this.kTl != null && SubPbModel.this.postID != null && SubPbModel.this.kTl.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.kym = true;
                            }
                            if (SubPbModel.this.kTt) {
                                SubPbModel.this.f(pVar);
                            } else {
                                SubPbModel.this.e(pVar);
                            }
                            if (SubPbModel.this.kTm != null) {
                                SubPbModel.this.kTm.a(SubPbModel.this.dcY(), error, errorString, SubPbModel.this.kQJ);
                            }
                        }
                    }
                }
            }
        };
        this.efn = tbPageContext;
        this.kTr = new ArrayList<>();
        this.kQJ = new p();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.kQN);
        registerListener(this.kQN);
    }

    public String cYB() {
        return this.kTe;
    }

    public String cYC() {
        return (StringUtils.isNull(this.kTe) || "0".equals(this.kTe)) ? this.oriUgcNid : this.kTe;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String brS() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public p dcX() {
        return this.kQJ;
    }

    public AntiData ckT() {
        return this.eAl;
    }

    public boolean dcY() {
        return (this.kQJ == null || this.kQJ.cWh() == null) ? false : true;
    }

    public void a(a aVar) {
        this.kTm = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.kTe);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.kTe);
        markData.setFloor(postData.dwF());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.kQN);
        if (this.kCQ != null) {
            this.kCQ.unRegisterListener();
        }
        cge();
    }

    private void cge() {
        if (this.hxZ != null) {
            this.hxZ.destory();
            this.hxZ = null;
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

    public void NZ(String str) {
        if (!TextUtils.isEmpty(str) && this.kQJ != null && this.kQJ.cWl() != null) {
            ArrayList<PostData> cWl = this.kQJ.cWl();
            int size = cWl.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(cWl.get(i).getId())) {
                    cWl.remove(i);
                    this.kTn++;
                    this.kQJ.setTotalCount(this.kQJ.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int dcZ() {
        int bzD = this.kQJ.bzD();
        if (bzD == 0) {
            return bzD + 1;
        }
        if (this.fcw == 0) {
            return bzD + 1;
        }
        if (this.fcw == 2 && this.kQJ.cWl().size() != 0 && this.kQJ.cWl().size() % this.kQJ.getPageSize() == 0) {
            return bzD + 1;
        }
        if (this.fcw == 3 && this.kTt) {
            return this.kQJ.cWj() - 1;
        }
        if (this.fcw == 3 && bzD > 0) {
            return this.kQJ.cWi() - 1;
        }
        return bzD;
    }

    private SubPbRequestMessage dcf() {
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
        if (1 != this.fcw) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else if (!at.isEmpty(this.oriUgcNid)) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
            j2 = com.baidu.adp.lib.f.b.toLong(this.kTg, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.kTg, 0L);
        }
        if (num == null) {
            intValue = dcZ();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.kTt && this.fcw == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.efn.getPageActivity(), Long.parseLong(this.kTe), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.jIE, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return EI(0);
    }

    public boolean dda() {
        return EI(2);
    }

    public void ddb() {
        int pageSize;
        if (this.kTn > 0 && this.kQJ != null && (pageSize = this.kQJ.getPageSize()) > 0) {
            int bzD = this.kQJ.bzD();
            for (int i = (((this.kTn + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.kTy = p(Integer.valueOf(bzD - i));
                this.kTy.setTreatDelPage(true);
                sendMessage(this.kTy);
            }
        }
        this.kTn = 0;
    }

    public boolean ddc() {
        return EI(1);
    }

    public boolean ddd() {
        return EI(3);
    }

    public boolean EI(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.kTe == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        ddb();
        this.fcw = i;
        this.kTy = dcf();
        sendMessage(this.kTy);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        ArrayList<PostData> cWl = pVar.cWl();
        if (cWl == null || cWl.size() == 0) {
            pVar.setCurrentPage(this.kQJ.bzD());
        }
        if (this.fcw == 1) {
            this.kQJ = pVar;
        } else if (this.fcw == 2) {
            this.kQJ.b(pVar, true);
        } else if (this.fcw == 3) {
            this.kQJ.a(pVar, false);
        } else {
            this.kQJ.b(pVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(p pVar) {
        if (this.fcw == 1) {
            this.kQJ = pVar;
            this.kQJ.cWk();
        } else if (this.fcw == 2) {
            this.kQJ.c(pVar, true);
        } else if (this.fcw == 3) {
            this.kQJ.d(pVar, false);
        } else {
            this.kQJ.a(pVar);
        }
    }

    public boolean dcx() {
        return this.evS;
    }

    public boolean dde() {
        return this.kym;
    }

    public boolean ddf() {
        return "hot_topic".equals(getStType());
    }

    public void tX(boolean z) {
        this.kym = z;
    }

    public int cVA() {
        return this.kwS;
    }

    public String ddg() {
        return this.kTl;
    }

    public void Oa(String str) {
        this.kTl = str;
    }

    public String ddh() {
        return this.kTg;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData BU(String str) {
        if (this.kQJ == null || this.kQJ.bss() == null || this.kQJ.bce() == null || this.kQJ.cWh() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.kQJ.bss().getName());
        writeData.setForumId(this.kQJ.bss().getId());
        writeData.setFromForumId(this.kTj);
        writeData.setFloor(this.kQJ.cWh().getId());
        writeData.setType(2);
        writeData.setThreadId(this.kQJ.bce().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean brR() {
        dda();
        return true;
    }

    public boolean ddi() {
        return this.kTx;
    }

    public void tY(boolean z) {
        this.kTx = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.kQM = aVar;
    }

    public SmallTailInfo ddj() {
        return this.kTs;
    }

    public boolean ddk() {
        return this.kTq;
    }

    public ConcurrentHashMap<String, ImageUrlData> ddl() {
        return this.kTv;
    }

    public ArrayList<String> ddm() {
        return this.kTu;
    }

    public boolean ddn() {
        return this.kTw;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.jIE;
    }

    public AttentionHostData ddo() {
        if (this.kTp == null) {
            this.kTp = new AttentionHostData();
            if (this.kQJ != null && this.kQJ.bce() != null && this.kQJ.bce().beE() != null) {
                this.kTp.parserWithMetaData(this.kQJ.bce().beE());
            }
        }
        return this.kTp;
    }

    public int ddp() {
        return this.pageFromType;
    }

    public String cYA() {
        return this.kTh;
    }

    public boolean ddq() {
        return this.kTi;
    }
}
