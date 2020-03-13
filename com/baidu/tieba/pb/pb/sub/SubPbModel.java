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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.data.l;
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
    private TbPageContext<?> cVi;
    private AntiData dmr;
    private com.baidu.tieba.tbadkCore.d.b fWD;
    private int iCa;
    private boolean iDc;
    private PbFakeFloorModel iHk;
    private l iTQ;
    private PbFakeFloorModel.a iTT;
    private com.baidu.adp.framework.listener.a iTU;
    private boolean iWA;
    private ArrayList<String> iWB;
    private ConcurrentHashMap<String, ImageUrlData> iWC;
    private boolean iWD;
    private boolean iWE;
    private SubPbRequestMessage iWF;
    private String iWk;
    private boolean iWl;
    private String iWm;
    private String iWn;
    private String iWo;
    private String iWp;
    private String iWq;
    private boolean iWr;
    private String iWs;
    private a iWt;
    private int iWu;
    private ArrayList<IconData> iWv;
    private AttentionHostData iWw;
    private boolean iWx;
    private ArrayList<l> iWy;
    private SmallTailInfo iWz;
    private boolean isLoading;
    private int mLoadType;
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
        void a(boolean z, int i, String str, l lVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.iWk = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.iWp = intent.getStringExtra("from_forum_id");
            this.iWq = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.iWl = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.iWm = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.iWr = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.iWn = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.iCa = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.iWz = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.iWz != null) {
                this.iWz.updateShowInfo();
            }
            this.dmr = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.iWv = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.iWx = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.iWC = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.iWC.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.iWB = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.iWD = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.iWo = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.iWk = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.iWp = bundle.getString("from_forum_id");
            this.iWq = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.iWl = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.iWm = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.iWr = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.iWn = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.iCa = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.iWz = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.iWz != null) {
                this.iWz.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.dmr = new AntiData();
                this.dmr.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.isEmpty(stringArrayList)) {
                this.iWv = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.iWv.add(iconData);
                    }
                }
            }
            this.iWx = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.iWo = bundle.getString("high_light_post_id");
        }
    }

    public void au(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.iWk);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.iWl);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.iWm);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.iWn);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.iWr);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.iCa);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.iWz));
            if (this.dmr != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.dmr.toJsonString());
            }
            if (!v.isEmpty(this.iWv)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.iWv.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.iWp);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.iWq);
            bundle.putString("high_light_post_id", this.iWo);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.iWk = null;
        this.postID = null;
        this.stType = null;
        this.iWl = false;
        this.iWm = null;
        this.iWn = null;
        this.iWo = null;
        this.pageFromType = 0;
        this.iWr = false;
        this.iDc = false;
        this.iCa = 0;
        this.iWs = null;
        this.cVi = null;
        this.iTQ = null;
        this.iWt = null;
        this.iWu = 0;
        this.iWx = false;
        this.iWy = null;
        this.isLoading = false;
        this.fWD = null;
        this.iWD = true;
        this.mOffset = 0;
        this.iHk = null;
        this.iTT = null;
        this.iWE = false;
        this.iTU = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                boolean z;
                l lVar;
                long j2;
                long j3;
                long j4 = 0;
                if (SubPbModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    SubPbModel.this.isLoading = false;
                    if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                        SubPbModel.this.cVi.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.iWy.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.iWy.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.iWy != null && SubPbModel.this.iWy.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.iWy.size() - 1; size >= 0; size--) {
                                l lVar2 = (l) SubPbModel.this.iWy.get(size);
                                if (SubPbModel.this.iWA) {
                                    SubPbModel.this.iTQ.c(lVar2, true);
                                } else {
                                    SubPbModel.this.iTQ.b(lVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.iWy.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.fWD == null) {
                        SubPbModel.this.fWD = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.fWD != null) {
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
                            SubPbModel.this.fWD.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.fWD = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.fWD = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.iWt != null) {
                                SubPbModel.this.iWt.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                lVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                lVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (lVar.clf().errorno.intValue() != 0) {
                                if (SubPbModel.this.iWt != null) {
                                    SubPbModel.this.iWt.a(false, lVar.iDd.errorno.intValue(), lVar.iDd.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (lVar.aAg() != null && lVar.aAg().aCo() != null) {
                                lVar.aAg().aCo().getUserId();
                                if (v.isEmpty(lVar.clg().aCo().getIconInfo()) && SubPbModel.this.iWv != null) {
                                    lVar.clg().aCo().setIconInfo(SubPbModel.this.iWv);
                                }
                            }
                            if (lVar.clg() != null) {
                                SubPbModel.this.postID = lVar.clg().getId();
                            }
                            if (lVar.aAg() != null) {
                                SubPbModel.this.iWk = lVar.aAg().getId();
                                SubPbModel.this.iDc = lVar.ayL();
                                SubPbModel.this.iWs = lVar.aAg().aCx();
                            }
                            if (SubPbModel.this.iWs != null && SubPbModel.this.postID != null && SubPbModel.this.iWs.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.iDc = true;
                            }
                            if (SubPbModel.this.iWA) {
                                SubPbModel.this.f(lVar);
                            } else {
                                SubPbModel.this.e(lVar);
                            }
                            if (SubPbModel.this.iWt != null) {
                                SubPbModel.this.iWt.a(SubPbModel.this.crQ(), error, errorString, SubPbModel.this.iTQ);
                            }
                        }
                    }
                }
            }
        };
        this.cVi = tbPageContext;
        this.iWy = new ArrayList<>();
        this.iTQ = new l();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.iTU);
        registerListener(this.iTU);
    }

    public String cnz() {
        return this.iWk;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aOP() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public l crP() {
        return this.iTQ;
    }

    public AntiData bCZ() {
        return this.dmr;
    }

    public boolean crQ() {
        return (this.iTQ == null || this.iTQ.clg() == null) ? false : true;
    }

    public void a(a aVar) {
        this.iWt = aVar;
    }

    public MarkData l(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iWk);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.iWk);
        markData.setFloor(postData.cLb());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.iTU);
        if (this.iHk != null) {
            this.iHk.unRegisterListener();
        }
        byU();
    }

    private void byU() {
        if (this.fWD != null) {
            this.fWD.destory();
            this.fWD = null;
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

    public void Gt(String str) {
        if (!TextUtils.isEmpty(str) && this.iTQ != null && this.iTQ.clk() != null) {
            ArrayList<PostData> clk = this.iTQ.clk();
            int size = clk.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(clk.get(i).getId())) {
                    clk.remove(i);
                    this.iWu++;
                    this.iTQ.setTotalCount(this.iTQ.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int crR() {
        int aVM = this.iTQ.aVM();
        if (aVM == 0) {
            return aVM + 1;
        }
        if (this.mLoadType == 0) {
            return aVM + 1;
        }
        if (this.mLoadType == 2 && this.iTQ.clk().size() != 0 && this.iTQ.clk().size() % this.iTQ.getPageSize() == 0) {
            return aVM + 1;
        }
        if (this.mLoadType == 3 && this.iWA) {
            return this.iTQ.cli() - 1;
        }
        if (this.mLoadType == 3 && aVM > 0) {
            return this.iTQ.clh() - 1;
        }
        return aVM;
    }

    private SubPbRequestMessage cqY() {
        this.isLoading = true;
        return o(null);
    }

    private SubPbRequestMessage o(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        }
        if (num == null) {
            intValue = crR();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.iWA && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.cVi.getPageActivity(), Long.parseLong(this.iWk), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.iWp, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return zq(0);
    }

    public boolean crS() {
        return zq(2);
    }

    public void crT() {
        int pageSize;
        if (this.iWu > 0 && this.iTQ != null && (pageSize = this.iTQ.getPageSize()) > 0) {
            int aVM = this.iTQ.aVM();
            for (int i = (((this.iWu + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.iWF = o(Integer.valueOf(aVM - i));
                this.iWF.setTreatDelPage(true);
                sendMessage(this.iWF);
            }
        }
        this.iWu = 0;
    }

    public boolean crU() {
        return zq(1);
    }

    public boolean zq(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.iWk == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        crT();
        this.mLoadType = i;
        this.iWF = cqY();
        sendMessage(this.iWF);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(l lVar) {
        ArrayList<PostData> clk = lVar.clk();
        if (clk == null || clk.size() == 0) {
            lVar.setCurrentPage(this.iTQ.aVM());
        }
        if (this.mLoadType == 1) {
            this.iTQ = lVar;
        } else if (this.mLoadType == 2) {
            this.iTQ.b(lVar, true);
        } else if (this.mLoadType == 3) {
            this.iTQ.a(lVar, false);
        } else {
            this.iTQ.b(lVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(l lVar) {
        if (this.mLoadType == 1) {
            this.iTQ = lVar;
            this.iTQ.clj();
        } else if (this.mLoadType == 2) {
            this.iTQ.c(lVar, true);
        } else if (this.mLoadType == 3) {
            this.iTQ.d(lVar, false);
        } else {
            this.iTQ.a(lVar);
        }
    }

    public boolean crq() {
        return this.iWl;
    }

    public boolean crV() {
        return this.iDc;
    }

    public boolean crW() {
        return "hot_topic".equals(getStType());
    }

    public void qM(boolean z) {
        this.iDc = z;
    }

    public int ckH() {
        return this.iCa;
    }

    public String crX() {
        return this.iWs;
    }

    public void Gu(String str) {
        this.iWs = str;
    }

    public String crY() {
        return this.iWn;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData vj(String str) {
        if (this.iTQ == null || this.iTQ.aPn() == null || this.iTQ.aAg() == null || this.iTQ.clg() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.iTQ.aPn().getName());
        writeData.setForumId(this.iTQ.aPn().getId());
        writeData.setFromForumId(this.iWq);
        writeData.setFloor(this.iTQ.clg().getId());
        writeData.setType(2);
        writeData.setThreadId(this.iTQ.aAg().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aOO() {
        crS();
        return true;
    }

    public boolean crZ() {
        return this.iWE;
    }

    public void qN(boolean z) {
        this.iWE = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.iTT = aVar;
    }

    public SmallTailInfo csa() {
        return this.iWz;
    }

    public boolean csb() {
        return this.iWx;
    }

    public ConcurrentHashMap<String, ImageUrlData> csc() {
        return this.iWC;
    }

    public ArrayList<String> csd() {
        return this.iWB;
    }

    public boolean cse() {
        return this.iWD;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.iWp;
    }

    public AttentionHostData csf() {
        if (this.iWw == null) {
            this.iWw = new AttentionHostData();
            if (this.iTQ != null && this.iTQ.aAg() != null && this.iTQ.aAg().aCo() != null) {
                this.iWw.parserWithMetaData(this.iTQ.aAg().aCo());
            }
        }
        return this.iWw;
    }

    public boolean coq() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public int csg() {
        return this.pageFromType;
    }

    public String cny() {
        return this.iWo;
    }
}
