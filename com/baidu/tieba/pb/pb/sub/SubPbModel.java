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
    private AntiData dMz;
    private TbPageContext<?> duG;
    private int emQ;
    private com.baidu.tieba.tbadkCore.d.b gDP;
    private boolean isLoading;
    private l jFB;
    private PbFakeFloorModel.a jFE;
    private com.baidu.adp.framework.listener.a jFF;
    private String jHT;
    private boolean jHU;
    private String jHV;
    private String jHW;
    private String jHX;
    private String jHY;
    private String jHZ;
    private boolean jIa;
    private String jIb;
    private a jIc;
    private int jId;
    private ArrayList<IconData> jIe;
    private AttentionHostData jIf;
    private boolean jIg;
    private ArrayList<l> jIh;
    private SmallTailInfo jIi;
    private boolean jIj;
    private ArrayList<String> jIk;
    private ConcurrentHashMap<String, ImageUrlData> jIl;
    private boolean jIm;
    private boolean jIn;
    private SubPbRequestMessage jIo;
    private int jnG;
    private boolean joJ;
    private PbFakeFloorModel jsS;
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
            this.jHT = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.jHY = intent.getStringExtra("from_forum_id");
            this.jHZ = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.jHU = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.jHV = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.jIa = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.jHW = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.jnG = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.jIi = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.jIi != null) {
                this.jIi.updateShowInfo();
            }
            this.dMz = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.jIe = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.jIg = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.jIl = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.jIl.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.jIk = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.jIm = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.jHX = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.jHT = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.jHY = bundle.getString("from_forum_id");
            this.jHZ = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.jHU = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.jHV = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.jIa = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.jHW = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.jnG = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.jIi = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.jIi != null) {
                this.jIi.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.dMz = new AntiData();
                this.dMz.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.isEmpty(stringArrayList)) {
                this.jIe = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.jIe.add(iconData);
                    }
                }
            }
            this.jIg = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.jHX = bundle.getString("high_light_post_id");
        }
    }

    public void au(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.jHT);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.jHU);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.jHV);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.jHW);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.jIa);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.jnG);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.jIi));
            if (this.dMz != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.dMz.toJsonString());
            }
            if (!v.isEmpty(this.jIe)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.jIe.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.jHY);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.jHZ);
            bundle.putString("high_light_post_id", this.jHX);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.emQ = 0;
        this.jHT = null;
        this.postID = null;
        this.stType = null;
        this.jHU = false;
        this.jHV = null;
        this.jHW = null;
        this.jHX = null;
        this.pageFromType = 0;
        this.jIa = false;
        this.joJ = false;
        this.jnG = 0;
        this.jIb = null;
        this.duG = null;
        this.jFB = null;
        this.jIc = null;
        this.jId = 0;
        this.jIg = false;
        this.jIh = null;
        this.isLoading = false;
        this.gDP = null;
        this.jIm = true;
        this.mOffset = 0;
        this.jsS = null;
        this.jFE = null;
        this.jIn = false;
        this.jFF = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.duG.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.jIh.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.jIh.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.jIh != null && SubPbModel.this.jIh.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.jIh.size() - 1; size >= 0; size--) {
                                l lVar2 = (l) SubPbModel.this.jIh.get(size);
                                if (SubPbModel.this.jIj) {
                                    SubPbModel.this.jFB.c(lVar2, true);
                                } else {
                                    SubPbModel.this.jFB.b(lVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.jIh.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.gDP == null) {
                        SubPbModel.this.gDP = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.gDP != null) {
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
                            SubPbModel.this.gDP.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.gDP = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.gDP = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.jIc != null) {
                                SubPbModel.this.jIc.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                lVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                lVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (lVar.cwg().errorno.intValue() != 0) {
                                if (SubPbModel.this.jIc != null) {
                                    SubPbModel.this.jIc.a(false, lVar.joK.errorno.intValue(), lVar.joK.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (lVar.aIw() != null && lVar.aIw().aKE() != null) {
                                lVar.aIw().aKE().getUserId();
                                if (v.isEmpty(lVar.cwh().aKE().getIconInfo()) && SubPbModel.this.jIe != null) {
                                    lVar.cwh().aKE().setIconInfo(SubPbModel.this.jIe);
                                }
                            }
                            if (lVar.cwh() != null) {
                                SubPbModel.this.postID = lVar.cwh().getId();
                            }
                            if (lVar.aIw() != null) {
                                SubPbModel.this.jHT = lVar.aIw().getId();
                                SubPbModel.this.joJ = lVar.aGZ();
                                SubPbModel.this.jIb = lVar.aIw().aKN();
                            }
                            if (SubPbModel.this.jIb != null && SubPbModel.this.postID != null && SubPbModel.this.jIb.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.joJ = true;
                            }
                            if (SubPbModel.this.jIj) {
                                SubPbModel.this.f(lVar);
                            } else {
                                SubPbModel.this.e(lVar);
                            }
                            if (SubPbModel.this.jIc != null) {
                                SubPbModel.this.jIc.a(SubPbModel.this.cCR(), error, errorString, SubPbModel.this.jFB);
                            }
                        }
                    }
                }
            }
        };
        this.duG = tbPageContext;
        this.jIh = new ArrayList<>();
        this.jFB = new l();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.jFF);
        registerListener(this.jFF);
    }

    public String cyA() {
        return this.jHT;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aXk() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public l cCQ() {
        return this.jFB;
    }

    public AntiData bNG() {
        return this.dMz;
    }

    public boolean cCR() {
        return (this.jFB == null || this.jFB.cwh() == null) ? false : true;
    }

    public void a(a aVar) {
        this.jIc = aVar;
    }

    public MarkData l(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.jHT);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.jHT);
        markData.setFloor(postData.cWr());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.jFF);
        if (this.jsS != null) {
            this.jsS.unRegisterListener();
        }
        bJc();
    }

    private void bJc() {
        if (this.gDP != null) {
            this.gDP.destory();
            this.gDP = null;
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

    public void Ia(String str) {
        if (!TextUtils.isEmpty(str) && this.jFB != null && this.jFB.cwl() != null) {
            ArrayList<PostData> cwl = this.jFB.cwl();
            int size = cwl.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(cwl.get(i).getId())) {
                    cwl.remove(i);
                    this.jId++;
                    this.jFB.setTotalCount(this.jFB.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int cCS() {
        int bea = this.jFB.bea();
        if (bea == 0) {
            return bea + 1;
        }
        if (this.emQ == 0) {
            return bea + 1;
        }
        if (this.emQ == 2 && this.jFB.cwl().size() != 0 && this.jFB.cwl().size() % this.jFB.getPageSize() == 0) {
            return bea + 1;
        }
        if (this.emQ == 3 && this.jIj) {
            return this.jFB.cwj() - 1;
        }
        if (this.emQ == 3 && bea > 0) {
            return this.jFB.cwi() - 1;
        }
        return bea;
    }

    private SubPbRequestMessage cBZ() {
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
        if (1 != this.emQ) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        }
        if (num == null) {
            intValue = cCS();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.jIj && this.emQ == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.duG.getPageActivity(), Long.parseLong(this.jHT), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.jHY, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return zZ(0);
    }

    public boolean cCT() {
        return zZ(2);
    }

    public void cCU() {
        int pageSize;
        if (this.jId > 0 && this.jFB != null && (pageSize = this.jFB.getPageSize()) > 0) {
            int bea = this.jFB.bea();
            for (int i = (((this.jId + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.jIo = o(Integer.valueOf(bea - i));
                this.jIo.setTreatDelPage(true);
                sendMessage(this.jIo);
            }
        }
        this.jId = 0;
    }

    public boolean cCV() {
        return zZ(1);
    }

    public boolean zZ(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.jHT == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        cCU();
        this.emQ = i;
        this.jIo = cBZ();
        sendMessage(this.jIo);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(l lVar) {
        ArrayList<PostData> cwl = lVar.cwl();
        if (cwl == null || cwl.size() == 0) {
            lVar.setCurrentPage(this.jFB.bea());
        }
        if (this.emQ == 1) {
            this.jFB = lVar;
        } else if (this.emQ == 2) {
            this.jFB.b(lVar, true);
        } else if (this.emQ == 3) {
            this.jFB.a(lVar, false);
        } else {
            this.jFB.b(lVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(l lVar) {
        if (this.emQ == 1) {
            this.jFB = lVar;
            this.jFB.cwk();
        } else if (this.emQ == 2) {
            this.jFB.c(lVar, true);
        } else if (this.emQ == 3) {
            this.jFB.d(lVar, false);
        } else {
            this.jFB.a(lVar);
        }
    }

    public boolean cCr() {
        return this.jHU;
    }

    public boolean cCW() {
        return this.joJ;
    }

    public boolean cCX() {
        return "hot_topic".equals(getStType());
    }

    public void rW(boolean z) {
        this.joJ = z;
    }

    public int cvG() {
        return this.jnG;
    }

    public String cCY() {
        return this.jIb;
    }

    public void Ib(String str) {
        this.jIb = str;
    }

    public String cCZ() {
        return this.jHW;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData ww(String str) {
        if (this.jFB == null || this.jFB.aXI() == null || this.jFB.aIw() == null || this.jFB.cwh() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.jFB.aXI().getName());
        writeData.setForumId(this.jFB.aXI().getId());
        writeData.setFromForumId(this.jHZ);
        writeData.setFloor(this.jFB.cwh().getId());
        writeData.setType(2);
        writeData.setThreadId(this.jFB.aIw().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aXj() {
        cCT();
        return true;
    }

    public boolean cDa() {
        return this.jIn;
    }

    public void rX(boolean z) {
        this.jIn = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.jFE = aVar;
    }

    public SmallTailInfo cDb() {
        return this.jIi;
    }

    public boolean cDc() {
        return this.jIg;
    }

    public ConcurrentHashMap<String, ImageUrlData> cDd() {
        return this.jIl;
    }

    public ArrayList<String> cDe() {
        return this.jIk;
    }

    public boolean cDf() {
        return this.jIm;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.jHY;
    }

    public AttentionHostData cDg() {
        if (this.jIf == null) {
            this.jIf = new AttentionHostData();
            if (this.jFB != null && this.jFB.aIw() != null && this.jFB.aIw().aKE() != null) {
                this.jIf.parserWithMetaData(this.jFB.aIw().aKE());
            }
        }
        return this.jIf;
    }

    public boolean czr() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public int cDh() {
        return this.pageFromType;
    }

    public String cyz() {
        return this.jHX;
    }
}
