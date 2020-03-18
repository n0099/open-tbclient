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
    private TbPageContext<?> cVv;
    private int dMZ;
    private AntiData dmE;
    private com.baidu.tieba.tbadkCore.d.b fXl;
    private int iDA;
    private boolean iED;
    private PbFakeFloorModel iIL;
    private l iVr;
    private PbFakeFloorModel.a iVu;
    private com.baidu.adp.framework.listener.a iVv;
    private String iXL;
    private boolean iXM;
    private String iXN;
    private String iXO;
    private String iXP;
    private String iXQ;
    private String iXR;
    private boolean iXS;
    private String iXT;
    private a iXU;
    private int iXV;
    private ArrayList<IconData> iXW;
    private AttentionHostData iXX;
    private boolean iXY;
    private ArrayList<l> iXZ;
    private SmallTailInfo iYa;
    private boolean iYb;
    private ArrayList<String> iYc;
    private ConcurrentHashMap<String, ImageUrlData> iYd;
    private boolean iYe;
    private boolean iYf;
    private SubPbRequestMessage iYg;
    private boolean isLoading;
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
            this.iXL = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.iXQ = intent.getStringExtra("from_forum_id");
            this.iXR = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.iXM = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.iXN = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.iXS = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.iXO = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.iDA = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.iYa = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.iYa != null) {
                this.iYa.updateShowInfo();
            }
            this.dmE = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.iXW = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.iXY = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.iYd = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.iYd.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.iYc = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.iYe = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.iXP = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.iXL = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.iXQ = bundle.getString("from_forum_id");
            this.iXR = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.iXM = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.iXN = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.iXS = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.iXO = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.iDA = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.iYa = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.iYa != null) {
                this.iYa.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.dmE = new AntiData();
                this.dmE.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.isEmpty(stringArrayList)) {
                this.iXW = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.iXW.add(iconData);
                    }
                }
            }
            this.iXY = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.iXP = bundle.getString("high_light_post_id");
        }
    }

    public void au(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.iXL);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.iXM);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.iXN);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.iXO);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.iXS);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.iDA);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.iYa));
            if (this.dmE != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.dmE.toJsonString());
            }
            if (!v.isEmpty(this.iXW)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.iXW.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.iXQ);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.iXR);
            bundle.putString("high_light_post_id", this.iXP);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.dMZ = 0;
        this.iXL = null;
        this.postID = null;
        this.stType = null;
        this.iXM = false;
        this.iXN = null;
        this.iXO = null;
        this.iXP = null;
        this.pageFromType = 0;
        this.iXS = false;
        this.iED = false;
        this.iDA = 0;
        this.iXT = null;
        this.cVv = null;
        this.iVr = null;
        this.iXU = null;
        this.iXV = 0;
        this.iXY = false;
        this.iXZ = null;
        this.isLoading = false;
        this.fXl = null;
        this.iYe = true;
        this.mOffset = 0;
        this.iIL = null;
        this.iVu = null;
        this.iYf = false;
        this.iVv = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.cVv.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.iXZ.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.iXZ.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.iXZ != null && SubPbModel.this.iXZ.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.iXZ.size() - 1; size >= 0; size--) {
                                l lVar2 = (l) SubPbModel.this.iXZ.get(size);
                                if (SubPbModel.this.iYb) {
                                    SubPbModel.this.iVr.c(lVar2, true);
                                } else {
                                    SubPbModel.this.iVr.b(lVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.iXZ.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.fXl == null) {
                        SubPbModel.this.fXl = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.fXl != null) {
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
                            SubPbModel.this.fXl.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.fXl = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.fXl = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.iXU != null) {
                                SubPbModel.this.iXU.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                lVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                lVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (lVar.clA().errorno.intValue() != 0) {
                                if (SubPbModel.this.iXU != null) {
                                    SubPbModel.this.iXU.a(false, lVar.iEE.errorno.intValue(), lVar.iEE.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (lVar.aAj() != null && lVar.aAj().aCr() != null) {
                                lVar.aAj().aCr().getUserId();
                                if (v.isEmpty(lVar.clB().aCr().getIconInfo()) && SubPbModel.this.iXW != null) {
                                    lVar.clB().aCr().setIconInfo(SubPbModel.this.iXW);
                                }
                            }
                            if (lVar.clB() != null) {
                                SubPbModel.this.postID = lVar.clB().getId();
                            }
                            if (lVar.aAj() != null) {
                                SubPbModel.this.iXL = lVar.aAj().getId();
                                SubPbModel.this.iED = lVar.ayO();
                                SubPbModel.this.iXT = lVar.aAj().aCA();
                            }
                            if (SubPbModel.this.iXT != null && SubPbModel.this.postID != null && SubPbModel.this.iXT.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.iED = true;
                            }
                            if (SubPbModel.this.iYb) {
                                SubPbModel.this.f(lVar);
                            } else {
                                SubPbModel.this.e(lVar);
                            }
                            if (SubPbModel.this.iXU != null) {
                                SubPbModel.this.iXU.a(SubPbModel.this.csl(), error, errorString, SubPbModel.this.iVr);
                            }
                        }
                    }
                }
            }
        };
        this.cVv = tbPageContext;
        this.iXZ = new ArrayList<>();
        this.iVr = new l();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.iVv);
        registerListener(this.iVv);
    }

    public String cnU() {
        return this.iXL;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aOT() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public l csk() {
        return this.iVr;
    }

    public AntiData bDg() {
        return this.dmE;
    }

    public boolean csl() {
        return (this.iVr == null || this.iVr.clB() == null) ? false : true;
    }

    public void a(a aVar) {
        this.iXU = aVar;
    }

    public MarkData l(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iXL);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.iXL);
        markData.setFloor(postData.cLv());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.iVv);
        if (this.iIL != null) {
            this.iIL.unRegisterListener();
        }
        bza();
    }

    private void bza() {
        if (this.fXl != null) {
            this.fXl.destory();
            this.fXl = null;
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

    public void Gs(String str) {
        if (!TextUtils.isEmpty(str) && this.iVr != null && this.iVr.clF() != null) {
            ArrayList<PostData> clF = this.iVr.clF();
            int size = clF.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(clF.get(i).getId())) {
                    clF.remove(i);
                    this.iXV++;
                    this.iVr.setTotalCount(this.iVr.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int csm() {
        int aVQ = this.iVr.aVQ();
        if (aVQ == 0) {
            return aVQ + 1;
        }
        if (this.dMZ == 0) {
            return aVQ + 1;
        }
        if (this.dMZ == 2 && this.iVr.clF().size() != 0 && this.iVr.clF().size() % this.iVr.getPageSize() == 0) {
            return aVQ + 1;
        }
        if (this.dMZ == 3 && this.iYb) {
            return this.iVr.clD() - 1;
        }
        if (this.dMZ == 3 && aVQ > 0) {
            return this.iVr.clC() - 1;
        }
        return aVQ;
    }

    private SubPbRequestMessage crt() {
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
        if (1 != this.dMZ) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        }
        if (num == null) {
            intValue = csm();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.iYb && this.dMZ == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.cVv.getPageActivity(), Long.parseLong(this.iXL), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.iXQ, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return zy(0);
    }

    public boolean csn() {
        return zy(2);
    }

    public void cso() {
        int pageSize;
        if (this.iXV > 0 && this.iVr != null && (pageSize = this.iVr.getPageSize()) > 0) {
            int aVQ = this.iVr.aVQ();
            for (int i = (((this.iXV + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.iYg = o(Integer.valueOf(aVQ - i));
                this.iYg.setTreatDelPage(true);
                sendMessage(this.iYg);
            }
        }
        this.iXV = 0;
    }

    public boolean csp() {
        return zy(1);
    }

    public boolean zy(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.iXL == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        cso();
        this.dMZ = i;
        this.iYg = crt();
        sendMessage(this.iYg);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(l lVar) {
        ArrayList<PostData> clF = lVar.clF();
        if (clF == null || clF.size() == 0) {
            lVar.setCurrentPage(this.iVr.aVQ());
        }
        if (this.dMZ == 1) {
            this.iVr = lVar;
        } else if (this.dMZ == 2) {
            this.iVr.b(lVar, true);
        } else if (this.dMZ == 3) {
            this.iVr.a(lVar, false);
        } else {
            this.iVr.b(lVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(l lVar) {
        if (this.dMZ == 1) {
            this.iVr = lVar;
            this.iVr.clE();
        } else if (this.dMZ == 2) {
            this.iVr.c(lVar, true);
        } else if (this.dMZ == 3) {
            this.iVr.d(lVar, false);
        } else {
            this.iVr.a(lVar);
        }
    }

    public boolean crL() {
        return this.iXM;
    }

    public boolean csq() {
        return this.iED;
    }

    public boolean csr() {
        return "hot_topic".equals(getStType());
    }

    public void qS(boolean z) {
        this.iED = z;
    }

    public int clb() {
        return this.iDA;
    }

    public String css() {
        return this.iXT;
    }

    public void Gt(String str) {
        this.iXT = str;
    }

    public String cst() {
        return this.iXO;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData vi(String str) {
        if (this.iVr == null || this.iVr.aPr() == null || this.iVr.aAj() == null || this.iVr.clB() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.iVr.aPr().getName());
        writeData.setForumId(this.iVr.aPr().getId());
        writeData.setFromForumId(this.iXR);
        writeData.setFloor(this.iVr.clB().getId());
        writeData.setType(2);
        writeData.setThreadId(this.iVr.aAj().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aOS() {
        csn();
        return true;
    }

    public boolean csu() {
        return this.iYf;
    }

    public void qT(boolean z) {
        this.iYf = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.iVu = aVar;
    }

    public SmallTailInfo csv() {
        return this.iYa;
    }

    public boolean csw() {
        return this.iXY;
    }

    public ConcurrentHashMap<String, ImageUrlData> csx() {
        return this.iYd;
    }

    public ArrayList<String> csy() {
        return this.iYc;
    }

    public boolean csz() {
        return this.iYe;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.iXQ;
    }

    public AttentionHostData csA() {
        if (this.iXX == null) {
            this.iXX = new AttentionHostData();
            if (this.iVr != null && this.iVr.aAj() != null && this.iVr.aAj().aCr() != null) {
                this.iXX.parserWithMetaData(this.iVr.aAj().aCr());
            }
        }
        return this.iXX;
    }

    public boolean coL() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public int csB() {
        return this.pageFromType;
    }

    public String cnT() {
        return this.iXP;
    }
}
