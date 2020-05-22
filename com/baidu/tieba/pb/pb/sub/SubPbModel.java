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
    private int eBA;
    private AntiData eaU;
    private com.baidu.tieba.tbadkCore.d.b gSE;
    private boolean isLoading;
    private int jEg;
    private boolean jFw;
    private PbFakeFloorModel jJT;
    private n jXg;
    private PbFakeFloorModel.a jXj;
    private com.baidu.adp.framework.listener.a jXk;
    private String jZG;
    private boolean jZH;
    private String jZI;
    private String jZJ;
    private String jZK;
    private String jZL;
    private String jZM;
    private boolean jZN;
    private String jZO;
    private a jZP;
    private int jZQ;
    private ArrayList<IconData> jZR;
    private AttentionHostData jZS;
    private boolean jZT;
    private ArrayList<n> jZU;
    private SmallTailInfo jZV;
    private boolean jZW;
    private ArrayList<String> jZX;
    private ConcurrentHashMap<String, ImageUrlData> jZY;
    private boolean jZZ;
    private boolean kaa;
    private SubPbRequestMessage kab;
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
            this.jZG = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.jZL = intent.getStringExtra("from_forum_id");
            this.jZM = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.jZH = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.jZI = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.jZN = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.jZJ = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.jEg = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.jZV = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.jZV != null) {
                this.jZV.updateShowInfo();
            }
            this.eaU = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.jZR = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.jZT = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.jZY = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.jZY.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.jZX = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.jZZ = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.jZK = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.jZG = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.jZL = bundle.getString("from_forum_id");
            this.jZM = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.jZH = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.jZI = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.jZN = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.jZJ = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.jEg = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.jZV = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.jZV != null) {
                this.jZV.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.eaU = new AntiData();
                this.eaU.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.isEmpty(stringArrayList)) {
                this.jZR = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.jZR.add(iconData);
                    }
                }
            }
            this.jZT = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.jZK = bundle.getString("high_light_post_id");
        }
    }

    public void aA(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.jZG);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.jZH);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.jZI);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.jZJ);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.jZN);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.jEg);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.jZV));
            if (this.eaU != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.eaU.toJsonString());
            }
            if (!v.isEmpty(this.jZR)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.jZR.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.jZL);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.jZM);
            bundle.putString("high_light_post_id", this.jZK);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.eBA = 0;
        this.jZG = null;
        this.postID = null;
        this.stType = null;
        this.jZH = false;
        this.jZI = null;
        this.jZJ = null;
        this.jZK = null;
        this.pageFromType = 0;
        this.jZN = false;
        this.jFw = false;
        this.jEg = 0;
        this.jZO = null;
        this.dIF = null;
        this.jXg = null;
        this.jZP = null;
        this.jZQ = 0;
        this.jZT = false;
        this.jZU = null;
        this.isLoading = false;
        this.gSE = null;
        this.jZZ = true;
        this.mOffset = 0;
        this.jJT = null;
        this.jXj = null;
        this.kaa = false;
        this.jXk = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.jZU.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.jZU.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.jZU != null && SubPbModel.this.jZU.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.jZU.size() - 1; size >= 0; size--) {
                                n nVar2 = (n) SubPbModel.this.jZU.get(size);
                                if (SubPbModel.this.jZW) {
                                    SubPbModel.this.jXg.c(nVar2, true);
                                } else {
                                    SubPbModel.this.jXg.b(nVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.jZU.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.gSE == null) {
                        SubPbModel.this.gSE = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.gSE != null) {
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
                            SubPbModel.this.gSE.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.gSE = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.gSE = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.jZP != null) {
                                SubPbModel.this.jZP.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                nVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                nVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (nVar.cDb().errorno.intValue() != 0) {
                                if (SubPbModel.this.jZP != null) {
                                    SubPbModel.this.jZP.a(false, nVar.jFx.errorno.intValue(), nVar.jFx.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (nVar.aOi() != null && nVar.aOi().aQx() != null) {
                                nVar.aOi().aQx().getUserId();
                                if (v.isEmpty(nVar.cDc().aQx().getIconInfo()) && SubPbModel.this.jZR != null) {
                                    nVar.cDc().aQx().setIconInfo(SubPbModel.this.jZR);
                                }
                            }
                            if (nVar.cDc() != null) {
                                SubPbModel.this.postID = nVar.cDc().getId();
                            }
                            if (nVar.aOi() != null) {
                                SubPbModel.this.jZG = nVar.aOi().getId();
                                SubPbModel.this.jFw = nVar.aML();
                                SubPbModel.this.jZO = nVar.aOi().aQG();
                            }
                            if (SubPbModel.this.jZO != null && SubPbModel.this.postID != null && SubPbModel.this.jZO.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.jFw = true;
                            }
                            if (SubPbModel.this.jZW) {
                                SubPbModel.this.f(nVar);
                            } else {
                                SubPbModel.this.e(nVar);
                            }
                            if (SubPbModel.this.jZP != null) {
                                SubPbModel.this.jZP.a(SubPbModel.this.cJN(), error, errorString, SubPbModel.this.jXg);
                            }
                        }
                    }
                }
            }
        };
        this.dIF = tbPageContext;
        this.jZU = new ArrayList<>();
        this.jXg = new n();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.jXk);
        registerListener(this.jXk);
    }

    public String cFt() {
        return this.jZG;
    }

    public String cFu() {
        return (StringUtils.isNull(this.jZG) || "0".equals(this.jZG)) ? this.oriUgcNid : this.jZG;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bdr() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public n cJM() {
        return this.jXg;
    }

    public AntiData bUa() {
        return this.eaU;
    }

    public boolean cJN() {
        return (this.jXg == null || this.jXg.cDc() == null) ? false : true;
    }

    public void a(a aVar) {
        this.jZP = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.jZG);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.jZG);
        markData.setFloor(postData.ddu());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.jXk);
        if (this.jJT != null) {
            this.jJT.unRegisterListener();
        }
        bPu();
    }

    private void bPu() {
        if (this.gSE != null) {
            this.gSE.destory();
            this.gSE = null;
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

    public void JP(String str) {
        if (!TextUtils.isEmpty(str) && this.jXg != null && this.jXg.cDg() != null) {
            ArrayList<PostData> cDg = this.jXg.cDg();
            int size = cDg.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(cDg.get(i).getId())) {
                    cDg.remove(i);
                    this.jZQ++;
                    this.jXg.setTotalCount(this.jXg.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int cJO() {
        int bkj = this.jXg.bkj();
        if (bkj == 0) {
            return bkj + 1;
        }
        if (this.eBA == 0) {
            return bkj + 1;
        }
        if (this.eBA == 2 && this.jXg.cDg().size() != 0 && this.jXg.cDg().size() % this.jXg.getPageSize() == 0) {
            return bkj + 1;
        }
        if (this.eBA == 3 && this.jZW) {
            return this.jXg.cDe() - 1;
        }
        if (this.eBA == 3 && bkj > 0) {
            return this.jXg.cDd() - 1;
        }
        return bkj;
    }

    private SubPbRequestMessage cIU() {
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
        if (1 != this.eBA) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        }
        if (num == null) {
            intValue = cJO();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.jZW && this.eBA == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.dIF.getPageActivity(), Long.parseLong(this.jZG), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.jZL, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return AK(0);
    }

    public boolean cJP() {
        return AK(2);
    }

    public void cJQ() {
        int pageSize;
        if (this.jZQ > 0 && this.jXg != null && (pageSize = this.jXg.getPageSize()) > 0) {
            int bkj = this.jXg.bkj();
            for (int i = (((this.jZQ + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.kab = p(Integer.valueOf(bkj - i));
                this.kab.setTreatDelPage(true);
                sendMessage(this.kab);
            }
        }
        this.jZQ = 0;
    }

    public boolean cJR() {
        return AK(1);
    }

    public boolean AK(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.jZG == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        cJQ();
        this.eBA = i;
        this.kab = cIU();
        sendMessage(this.kab);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(n nVar) {
        ArrayList<PostData> cDg = nVar.cDg();
        if (cDg == null || cDg.size() == 0) {
            nVar.setCurrentPage(this.jXg.bkj());
        }
        if (this.eBA == 1) {
            this.jXg = nVar;
        } else if (this.eBA == 2) {
            this.jXg.b(nVar, true);
        } else if (this.eBA == 3) {
            this.jXg.a(nVar, false);
        } else {
            this.jXg.b(nVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(n nVar) {
        if (this.eBA == 1) {
            this.jXg = nVar;
            this.jXg.cDf();
        } else if (this.eBA == 2) {
            this.jXg.c(nVar, true);
        } else if (this.eBA == 3) {
            this.jXg.d(nVar, false);
        } else {
            this.jXg.a(nVar);
        }
    }

    public boolean cJm() {
        return this.jZH;
    }

    public boolean cJS() {
        return this.jFw;
    }

    public boolean cJT() {
        return "hot_topic".equals(getStType());
    }

    public void su(boolean z) {
        this.jFw = z;
    }

    public int cCx() {
        return this.jEg;
    }

    public String cJU() {
        return this.jZO;
    }

    public void JQ(String str) {
        this.jZO = str;
    }

    public String cJV() {
        return this.jZJ;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData yf(String str) {
        if (this.jXg == null || this.jXg.bdP() == null || this.jXg.aOi() == null || this.jXg.cDc() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.jXg.bdP().getName());
        writeData.setForumId(this.jXg.bdP().getId());
        writeData.setFromForumId(this.jZM);
        writeData.setFloor(this.jXg.cDc().getId());
        writeData.setType(2);
        writeData.setThreadId(this.jXg.aOi().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bdq() {
        cJP();
        return true;
    }

    public boolean cJW() {
        return this.kaa;
    }

    public void sv(boolean z) {
        this.kaa = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.jXj = aVar;
    }

    public SmallTailInfo cJX() {
        return this.jZV;
    }

    public boolean cJY() {
        return this.jZT;
    }

    public ConcurrentHashMap<String, ImageUrlData> cJZ() {
        return this.jZY;
    }

    public ArrayList<String> cKa() {
        return this.jZX;
    }

    public boolean cKb() {
        return this.jZZ;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.jZL;
    }

    public AttentionHostData cKc() {
        if (this.jZS == null) {
            this.jZS = new AttentionHostData();
            if (this.jXg != null && this.jXg.aOi() != null && this.jXg.aOi().aQx() != null) {
                this.jZS.parserWithMetaData(this.jXg.aOi().aQx());
            }
        }
        return this.jZS;
    }

    public boolean cGl() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public int cKd() {
        return this.pageFromType;
    }

    public String cFs() {
        return this.jZK;
    }
}
