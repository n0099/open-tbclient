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
    private AntiData dMD;
    private TbPageContext<?> duK;
    private int emV;
    private com.baidu.tieba.tbadkCore.d.b gDV;
    private boolean isLoading;
    private l jFF;
    private PbFakeFloorModel.a jFI;
    private com.baidu.adp.framework.listener.a jFJ;
    private String jHX;
    private boolean jHY;
    private String jHZ;
    private String jIa;
    private String jIb;
    private String jIc;
    private String jId;
    private boolean jIe;
    private String jIf;
    private a jIg;
    private int jIh;
    private ArrayList<IconData> jIi;
    private AttentionHostData jIj;
    private boolean jIk;
    private ArrayList<l> jIl;
    private SmallTailInfo jIm;
    private boolean jIn;
    private ArrayList<String> jIo;
    private ConcurrentHashMap<String, ImageUrlData> jIp;
    private boolean jIq;
    private boolean jIr;
    private SubPbRequestMessage jIs;
    private int jnK;
    private boolean joN;
    private PbFakeFloorModel jsW;
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
            this.jHX = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.jIc = intent.getStringExtra("from_forum_id");
            this.jId = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.jHY = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.jHZ = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.jIe = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.jIa = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.jnK = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.jIm = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.jIm != null) {
                this.jIm.updateShowInfo();
            }
            this.dMD = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.jIi = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.jIk = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.jIp = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.jIp.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.jIo = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.jIq = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.jIb = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.jHX = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.jIc = bundle.getString("from_forum_id");
            this.jId = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.jHY = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.jHZ = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.jIe = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.jIa = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.jnK = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.jIm = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.jIm != null) {
                this.jIm.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.dMD = new AntiData();
                this.dMD.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.isEmpty(stringArrayList)) {
                this.jIi = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.jIi.add(iconData);
                    }
                }
            }
            this.jIk = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.jIb = bundle.getString("high_light_post_id");
        }
    }

    public void au(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.jHX);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.jHY);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.jHZ);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.jIa);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.jIe);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.jnK);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.jIm));
            if (this.dMD != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.dMD.toJsonString());
            }
            if (!v.isEmpty(this.jIi)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.jIi.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.jIc);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.jId);
            bundle.putString("high_light_post_id", this.jIb);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.emV = 0;
        this.jHX = null;
        this.postID = null;
        this.stType = null;
        this.jHY = false;
        this.jHZ = null;
        this.jIa = null;
        this.jIb = null;
        this.pageFromType = 0;
        this.jIe = false;
        this.joN = false;
        this.jnK = 0;
        this.jIf = null;
        this.duK = null;
        this.jFF = null;
        this.jIg = null;
        this.jIh = 0;
        this.jIk = false;
        this.jIl = null;
        this.isLoading = false;
        this.gDV = null;
        this.jIq = true;
        this.mOffset = 0;
        this.jsW = null;
        this.jFI = null;
        this.jIr = false;
        this.jFJ = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.duK.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.jIl.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.jIl.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.jIl != null && SubPbModel.this.jIl.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.jIl.size() - 1; size >= 0; size--) {
                                l lVar2 = (l) SubPbModel.this.jIl.get(size);
                                if (SubPbModel.this.jIn) {
                                    SubPbModel.this.jFF.c(lVar2, true);
                                } else {
                                    SubPbModel.this.jFF.b(lVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.jIl.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.gDV == null) {
                        SubPbModel.this.gDV = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.gDV != null) {
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
                            SubPbModel.this.gDV.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.gDV = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.gDV = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.jIg != null) {
                                SubPbModel.this.jIg.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                lVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                lVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (lVar.cwd().errorno.intValue() != 0) {
                                if (SubPbModel.this.jIg != null) {
                                    SubPbModel.this.jIg.a(false, lVar.joO.errorno.intValue(), lVar.joO.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (lVar.aIu() != null && lVar.aIu().aKC() != null) {
                                lVar.aIu().aKC().getUserId();
                                if (v.isEmpty(lVar.cwe().aKC().getIconInfo()) && SubPbModel.this.jIi != null) {
                                    lVar.cwe().aKC().setIconInfo(SubPbModel.this.jIi);
                                }
                            }
                            if (lVar.cwe() != null) {
                                SubPbModel.this.postID = lVar.cwe().getId();
                            }
                            if (lVar.aIu() != null) {
                                SubPbModel.this.jHX = lVar.aIu().getId();
                                SubPbModel.this.joN = lVar.aGX();
                                SubPbModel.this.jIf = lVar.aIu().aKL();
                            }
                            if (SubPbModel.this.jIf != null && SubPbModel.this.postID != null && SubPbModel.this.jIf.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.joN = true;
                            }
                            if (SubPbModel.this.jIn) {
                                SubPbModel.this.f(lVar);
                            } else {
                                SubPbModel.this.e(lVar);
                            }
                            if (SubPbModel.this.jIg != null) {
                                SubPbModel.this.jIg.a(SubPbModel.this.cCO(), error, errorString, SubPbModel.this.jFF);
                            }
                        }
                    }
                }
            }
        };
        this.duK = tbPageContext;
        this.jIl = new ArrayList<>();
        this.jFF = new l();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.jFJ);
        registerListener(this.jFJ);
    }

    public String cyx() {
        return this.jHX;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aXi() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public l cCN() {
        return this.jFF;
    }

    public AntiData bNE() {
        return this.dMD;
    }

    public boolean cCO() {
        return (this.jFF == null || this.jFF.cwe() == null) ? false : true;
    }

    public void a(a aVar) {
        this.jIg = aVar;
    }

    public MarkData l(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.jHX);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.jHX);
        markData.setFloor(postData.cWo());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.jFJ);
        if (this.jsW != null) {
            this.jsW.unRegisterListener();
        }
        bJa();
    }

    private void bJa() {
        if (this.gDV != null) {
            this.gDV.destory();
            this.gDV = null;
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

    public void Id(String str) {
        if (!TextUtils.isEmpty(str) && this.jFF != null && this.jFF.cwi() != null) {
            ArrayList<PostData> cwi = this.jFF.cwi();
            int size = cwi.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(cwi.get(i).getId())) {
                    cwi.remove(i);
                    this.jIh++;
                    this.jFF.setTotalCount(this.jFF.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int cCP() {
        int bdY = this.jFF.bdY();
        if (bdY == 0) {
            return bdY + 1;
        }
        if (this.emV == 0) {
            return bdY + 1;
        }
        if (this.emV == 2 && this.jFF.cwi().size() != 0 && this.jFF.cwi().size() % this.jFF.getPageSize() == 0) {
            return bdY + 1;
        }
        if (this.emV == 3 && this.jIn) {
            return this.jFF.cwg() - 1;
        }
        if (this.emV == 3 && bdY > 0) {
            return this.jFF.cwf() - 1;
        }
        return bdY;
    }

    private SubPbRequestMessage cBW() {
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
        if (1 != this.emV) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        }
        if (num == null) {
            intValue = cCP();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.jIn && this.emV == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.duK.getPageActivity(), Long.parseLong(this.jHX), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.jIc, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return zZ(0);
    }

    public boolean cCQ() {
        return zZ(2);
    }

    public void cCR() {
        int pageSize;
        if (this.jIh > 0 && this.jFF != null && (pageSize = this.jFF.getPageSize()) > 0) {
            int bdY = this.jFF.bdY();
            for (int i = (((this.jIh + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.jIs = o(Integer.valueOf(bdY - i));
                this.jIs.setTreatDelPage(true);
                sendMessage(this.jIs);
            }
        }
        this.jIh = 0;
    }

    public boolean cCS() {
        return zZ(1);
    }

    public boolean zZ(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.jHX == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        cCR();
        this.emV = i;
        this.jIs = cBW();
        sendMessage(this.jIs);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(l lVar) {
        ArrayList<PostData> cwi = lVar.cwi();
        if (cwi == null || cwi.size() == 0) {
            lVar.setCurrentPage(this.jFF.bdY());
        }
        if (this.emV == 1) {
            this.jFF = lVar;
        } else if (this.emV == 2) {
            this.jFF.b(lVar, true);
        } else if (this.emV == 3) {
            this.jFF.a(lVar, false);
        } else {
            this.jFF.b(lVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(l lVar) {
        if (this.emV == 1) {
            this.jFF = lVar;
            this.jFF.cwh();
        } else if (this.emV == 2) {
            this.jFF.c(lVar, true);
        } else if (this.emV == 3) {
            this.jFF.d(lVar, false);
        } else {
            this.jFF.a(lVar);
        }
    }

    public boolean cCo() {
        return this.jHY;
    }

    public boolean cCT() {
        return this.joN;
    }

    public boolean cCU() {
        return "hot_topic".equals(getStType());
    }

    public void rW(boolean z) {
        this.joN = z;
    }

    public int cvD() {
        return this.jnK;
    }

    public String cCV() {
        return this.jIf;
    }

    public void Ie(String str) {
        this.jIf = str;
    }

    public String cCW() {
        return this.jIa;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData wz(String str) {
        if (this.jFF == null || this.jFF.aXG() == null || this.jFF.aIu() == null || this.jFF.cwe() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.jFF.aXG().getName());
        writeData.setForumId(this.jFF.aXG().getId());
        writeData.setFromForumId(this.jId);
        writeData.setFloor(this.jFF.cwe().getId());
        writeData.setType(2);
        writeData.setThreadId(this.jFF.aIu().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aXh() {
        cCQ();
        return true;
    }

    public boolean cCX() {
        return this.jIr;
    }

    public void rX(boolean z) {
        this.jIr = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.jFI = aVar;
    }

    public SmallTailInfo cCY() {
        return this.jIm;
    }

    public boolean cCZ() {
        return this.jIk;
    }

    public ConcurrentHashMap<String, ImageUrlData> cDa() {
        return this.jIp;
    }

    public ArrayList<String> cDb() {
        return this.jIo;
    }

    public boolean cDc() {
        return this.jIq;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.jIc;
    }

    public AttentionHostData cDd() {
        if (this.jIj == null) {
            this.jIj = new AttentionHostData();
            if (this.jFF != null && this.jFF.aIu() != null && this.jFF.aIu().aKC() != null) {
                this.jIj.parserWithMetaData(this.jFF.aIu().aKC());
            }
        }
        return this.jIj;
    }

    public boolean czo() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public int cDe() {
        return this.pageFromType;
    }

    public String cyw() {
        return this.jIb;
    }
}
