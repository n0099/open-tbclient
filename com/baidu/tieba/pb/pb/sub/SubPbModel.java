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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.data.n;
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
    private TbPageContext<?> dIF;
    private int eBL;
    private AntiData eaU;
    private com.baidu.tieba.tbadkCore.d.b gSP;
    private boolean isLoading;
    private int jFm;
    private boolean jGC;
    private PbFakeFloorModel jKZ;
    private n jYm;
    private PbFakeFloorModel.a jYp;
    private com.baidu.adp.framework.listener.a jYq;
    private String kaN;
    private boolean kaO;
    private String kaP;
    private String kaQ;
    private String kaR;
    private String kaS;
    private String kaT;
    private boolean kaU;
    private String kaV;
    private a kaW;
    private int kaX;
    private ArrayList<IconData> kaY;
    private AttentionHostData kaZ;
    private boolean kba;
    private ArrayList<n> kbb;
    private SmallTailInfo kbc;
    private boolean kbd;
    private ArrayList<String> kbe;
    private ConcurrentHashMap<String, ImageUrlData> kbf;
    private boolean kbg;
    private boolean kbh;
    private SubPbRequestMessage kbi;
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
        void a(boolean z, int i, String str, n nVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.kaN = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.kaS = intent.getStringExtra("from_forum_id");
            this.kaT = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.kaO = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.kaP = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.kaU = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.kaQ = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.jFm = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.kbc = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.kbc != null) {
                this.kbc.updateShowInfo();
            }
            this.eaU = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.kaY = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.kba = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.kbf = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.kbf.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.kbe = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.kbg = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.kaR = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.kaN = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.kaS = bundle.getString("from_forum_id");
            this.kaT = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.kaO = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.kaP = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.kaU = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.kaQ = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.jFm = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.kbc = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.kbc != null) {
                this.kbc.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.eaU = new AntiData();
                this.eaU.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.isEmpty(stringArrayList)) {
                this.kaY = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.kaY.add(iconData);
                    }
                }
            }
            this.kba = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.kaR = bundle.getString("high_light_post_id");
        }
    }

    public void aA(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.kaN);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.kaO);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.kaP);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.kaQ);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.kaU);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.jFm);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.kbc));
            if (this.eaU != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.eaU.toJsonString());
            }
            if (!v.isEmpty(this.kaY)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.kaY.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.kaS);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.kaT);
            bundle.putString("high_light_post_id", this.kaR);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eBL = 0;
        this.kaN = null;
        this.postID = null;
        this.stType = null;
        this.kaO = false;
        this.kaP = null;
        this.kaQ = null;
        this.kaR = null;
        this.pageFromType = 0;
        this.kaU = false;
        this.jGC = false;
        this.jFm = 0;
        this.kaV = null;
        this.dIF = null;
        this.jYm = null;
        this.kaW = null;
        this.kaX = 0;
        this.kba = false;
        this.kbb = null;
        this.isLoading = false;
        this.gSP = null;
        this.kbg = true;
        this.mOffset = 0;
        this.jKZ = null;
        this.jYp = null;
        this.kbh = false;
        this.jYq = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                boolean z;
                n nVar;
                long j2;
                long j3;
                long j4 = 0;
                if (SubPbModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    SubPbModel.this.isLoading = false;
                    if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                        SubPbModel.this.dIF.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.kbb.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.kbb.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.kbb != null && SubPbModel.this.kbb.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.kbb.size() - 1; size >= 0; size--) {
                                n nVar2 = (n) SubPbModel.this.kbb.get(size);
                                if (SubPbModel.this.kbd) {
                                    SubPbModel.this.jYm.c(nVar2, true);
                                } else {
                                    SubPbModel.this.jYm.b(nVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.kbb.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.gSP == null) {
                        SubPbModel.this.gSP = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.gSP != null) {
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
                            SubPbModel.this.gSP.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.gSP = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.gSP = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.kaW != null) {
                                SubPbModel.this.kaW.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                nVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                nVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (nVar.cDr().errorno.intValue() != 0) {
                                if (SubPbModel.this.kaW != null) {
                                    SubPbModel.this.kaW.a(false, nVar.jGD.errorno.intValue(), nVar.jGD.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (nVar.aOi() != null && nVar.aOi().aQx() != null) {
                                nVar.aOi().aQx().getUserId();
                                if (v.isEmpty(nVar.cDs().aQx().getIconInfo()) && SubPbModel.this.kaY != null) {
                                    nVar.cDs().aQx().setIconInfo(SubPbModel.this.kaY);
                                }
                            }
                            if (nVar.cDs() != null) {
                                SubPbModel.this.postID = nVar.cDs().getId();
                            }
                            if (nVar.aOi() != null) {
                                SubPbModel.this.kaN = nVar.aOi().getId();
                                SubPbModel.this.jGC = nVar.aML();
                                SubPbModel.this.kaV = nVar.aOi().aQG();
                            }
                            if (SubPbModel.this.kaV != null && SubPbModel.this.postID != null && SubPbModel.this.kaV.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.jGC = true;
                            }
                            if (SubPbModel.this.kbd) {
                                SubPbModel.this.f(nVar);
                            } else {
                                SubPbModel.this.e(nVar);
                            }
                            if (SubPbModel.this.kaW != null) {
                                SubPbModel.this.kaW.a(SubPbModel.this.cKd(), error, errorString, SubPbModel.this.jYm);
                            }
                        }
                    }
                }
            }
        };
        this.dIF = tbPageContext;
        this.kbb = new ArrayList<>();
        this.jYm = new n();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.jYq);
        registerListener(this.jYq);
    }

    public String cFJ() {
        return this.kaN;
    }

    public String cFK() {
        return (StringUtils.isNull(this.kaN) || "0".equals(this.kaN)) ? this.oriUgcNid : this.kaN;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bds() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public n cKc() {
        return this.jYm;
    }

    public AntiData bUc() {
        return this.eaU;
    }

    public boolean cKd() {
        return (this.jYm == null || this.jYm.cDs() == null) ? false : true;
    }

    public void a(a aVar) {
        this.kaW = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.kaN);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.kaN);
        markData.setFloor(postData.ddJ());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.jYq);
        if (this.jKZ != null) {
            this.jKZ.unRegisterListener();
        }
        bPw();
    }

    private void bPw() {
        if (this.gSP != null) {
            this.gSP.destory();
            this.gSP = null;
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

    public void JQ(String str) {
        if (!TextUtils.isEmpty(str) && this.jYm != null && this.jYm.cDw() != null) {
            ArrayList<PostData> cDw = this.jYm.cDw();
            int size = cDw.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(cDw.get(i).getId())) {
                    cDw.remove(i);
                    this.kaX++;
                    this.jYm.setTotalCount(this.jYm.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int cKe() {
        int bkl = this.jYm.bkl();
        if (bkl == 0) {
            return bkl + 1;
        }
        if (this.eBL == 0) {
            return bkl + 1;
        }
        if (this.eBL == 2 && this.jYm.cDw().size() != 0 && this.jYm.cDw().size() % this.jYm.getPageSize() == 0) {
            return bkl + 1;
        }
        if (this.eBL == 3 && this.kbd) {
            return this.jYm.cDu() - 1;
        }
        if (this.eBL == 3 && bkl > 0) {
            return this.jYm.cDt() - 1;
        }
        return bkl;
    }

    private SubPbRequestMessage cJk() {
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
        if (1 != this.eBL) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        }
        if (num == null) {
            intValue = cKe();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.kbd && this.eBL == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.dIF.getPageActivity(), Long.parseLong(this.kaN), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.kaS, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return AM(0);
    }

    public boolean cKf() {
        return AM(2);
    }

    public void cKg() {
        int pageSize;
        if (this.kaX > 0 && this.jYm != null && (pageSize = this.jYm.getPageSize()) > 0) {
            int bkl = this.jYm.bkl();
            for (int i = (((this.kaX + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.kbi = p(Integer.valueOf(bkl - i));
                this.kbi.setTreatDelPage(true);
                sendMessage(this.kbi);
            }
        }
        this.kaX = 0;
    }

    public boolean cKh() {
        return AM(1);
    }

    public boolean AM(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.kaN == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        cKg();
        this.eBL = i;
        this.kbi = cJk();
        sendMessage(this.kbi);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(n nVar) {
        ArrayList<PostData> cDw = nVar.cDw();
        if (cDw == null || cDw.size() == 0) {
            nVar.setCurrentPage(this.jYm.bkl());
        }
        if (this.eBL == 1) {
            this.jYm = nVar;
        } else if (this.eBL == 2) {
            this.jYm.b(nVar, true);
        } else if (this.eBL == 3) {
            this.jYm.a(nVar, false);
        } else {
            this.jYm.b(nVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(n nVar) {
        if (this.eBL == 1) {
            this.jYm = nVar;
            this.jYm.cDv();
        } else if (this.eBL == 2) {
            this.jYm.c(nVar, true);
        } else if (this.eBL == 3) {
            this.jYm.d(nVar, false);
        } else {
            this.jYm.a(nVar);
        }
    }

    public boolean cJC() {
        return this.kaO;
    }

    public boolean cKi() {
        return this.jGC;
    }

    public boolean cKj() {
        return "hot_topic".equals(getStType());
    }

    public void su(boolean z) {
        this.jGC = z;
    }

    public int cCN() {
        return this.jFm;
    }

    public String cKk() {
        return this.kaV;
    }

    public void JR(String str) {
        this.kaV = str;
    }

    public String cKl() {
        return this.kaQ;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData yf(String str) {
        if (this.jYm == null || this.jYm.bdQ() == null || this.jYm.aOi() == null || this.jYm.cDs() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.jYm.bdQ().getName());
        writeData.setForumId(this.jYm.bdQ().getId());
        writeData.setFromForumId(this.kaT);
        writeData.setFloor(this.jYm.cDs().getId());
        writeData.setType(2);
        writeData.setThreadId(this.jYm.aOi().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bdr() {
        cKf();
        return true;
    }

    public boolean cKm() {
        return this.kbh;
    }

    public void sv(boolean z) {
        this.kbh = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.jYp = aVar;
    }

    public SmallTailInfo cKn() {
        return this.kbc;
    }

    public boolean cKo() {
        return this.kba;
    }

    public ConcurrentHashMap<String, ImageUrlData> cKp() {
        return this.kbf;
    }

    public ArrayList<String> cKq() {
        return this.kbe;
    }

    public boolean cKr() {
        return this.kbg;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.kaS;
    }

    public AttentionHostData cKs() {
        if (this.kaZ == null) {
            this.kaZ = new AttentionHostData();
            if (this.jYm != null && this.jYm.aOi() != null && this.jYm.aOi().aQx() != null) {
                this.kaZ.parserWithMetaData(this.jYm.aOi().aQx());
            }
        }
        return this.kaZ;
    }

    public boolean cGB() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public int cKt() {
        return this.pageFromType;
    }

    public String cFI() {
        return this.kaR;
    }
}
