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
    private TbPageContext<?> cVg;
    private AntiData dmd;
    private com.baidu.tieba.tbadkCore.d.b fWo;
    private int iBM;
    private boolean iCO;
    private PbFakeFloorModel iGW;
    private l iTC;
    private PbFakeFloorModel.a iTF;
    private com.baidu.adp.framework.listener.a iTG;
    private String iVW;
    private boolean iVX;
    private String iVY;
    private String iVZ;
    private String iWa;
    private String iWb;
    private String iWc;
    private boolean iWd;
    private String iWe;
    private a iWf;
    private int iWg;
    private ArrayList<IconData> iWh;
    private AttentionHostData iWi;
    private boolean iWj;
    private ArrayList<l> iWk;
    private SmallTailInfo iWl;
    private boolean iWm;
    private ArrayList<String> iWn;
    private ConcurrentHashMap<String, ImageUrlData> iWo;
    private boolean iWp;
    private boolean iWq;
    private SubPbRequestMessage iWr;
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
            this.iVW = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.iWb = intent.getStringExtra("from_forum_id");
            this.iWc = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.iVX = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.iVY = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.iWd = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.iVZ = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.iBM = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.iWl = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.iWl != null) {
                this.iWl.updateShowInfo();
            }
            this.dmd = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.iWh = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.iWj = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.iWo = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.iWo.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.iWn = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.iWp = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.iWa = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.iVW = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.iWb = bundle.getString("from_forum_id");
            this.iWc = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.iVX = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.iVY = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.iWd = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.iVZ = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.iBM = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.iWl = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.iWl != null) {
                this.iWl.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.dmd = new AntiData();
                this.dmd.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.isEmpty(stringArrayList)) {
                this.iWh = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.iWh.add(iconData);
                    }
                }
            }
            this.iWj = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.iWa = bundle.getString("high_light_post_id");
        }
    }

    public void au(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.iVW);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.iVX);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.iVY);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.iVZ);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.iWd);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.iBM);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.iWl));
            if (this.dmd != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.dmd.toJsonString());
            }
            if (!v.isEmpty(this.iWh)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.iWh.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.iWb);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.iWc);
            bundle.putString("high_light_post_id", this.iWa);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.iVW = null;
        this.postID = null;
        this.stType = null;
        this.iVX = false;
        this.iVY = null;
        this.iVZ = null;
        this.iWa = null;
        this.pageFromType = 0;
        this.iWd = false;
        this.iCO = false;
        this.iBM = 0;
        this.iWe = null;
        this.cVg = null;
        this.iTC = null;
        this.iWf = null;
        this.iWg = 0;
        this.iWj = false;
        this.iWk = null;
        this.isLoading = false;
        this.fWo = null;
        this.iWp = true;
        this.mOffset = 0;
        this.iGW = null;
        this.iTF = null;
        this.iWq = false;
        this.iTG = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.cVg.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.iWk.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.iWk.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.iWk != null && SubPbModel.this.iWk.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.iWk.size() - 1; size >= 0; size--) {
                                l lVar2 = (l) SubPbModel.this.iWk.get(size);
                                if (SubPbModel.this.iWm) {
                                    SubPbModel.this.iTC.c(lVar2, true);
                                } else {
                                    SubPbModel.this.iTC.b(lVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.iWk.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.fWo == null) {
                        SubPbModel.this.fWo = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.fWo != null) {
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
                            SubPbModel.this.fWo.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.fWo = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.fWo = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.iWf != null) {
                                SubPbModel.this.iWf.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                lVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                lVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (lVar.clc().errorno.intValue() != 0) {
                                if (SubPbModel.this.iWf != null) {
                                    SubPbModel.this.iWf.a(false, lVar.iCP.errorno.intValue(), lVar.iCP.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (lVar.aAe() != null && lVar.aAe().aCm() != null) {
                                lVar.aAe().aCm().getUserId();
                                if (v.isEmpty(lVar.cld().aCm().getIconInfo()) && SubPbModel.this.iWh != null) {
                                    lVar.cld().aCm().setIconInfo(SubPbModel.this.iWh);
                                }
                            }
                            if (lVar.cld() != null) {
                                SubPbModel.this.postID = lVar.cld().getId();
                            }
                            if (lVar.aAe() != null) {
                                SubPbModel.this.iVW = lVar.aAe().getId();
                                SubPbModel.this.iCO = lVar.ayJ();
                                SubPbModel.this.iWe = lVar.aAe().aCv();
                            }
                            if (SubPbModel.this.iWe != null && SubPbModel.this.postID != null && SubPbModel.this.iWe.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.iCO = true;
                            }
                            if (SubPbModel.this.iWm) {
                                SubPbModel.this.f(lVar);
                            } else {
                                SubPbModel.this.e(lVar);
                            }
                            if (SubPbModel.this.iWf != null) {
                                SubPbModel.this.iWf.a(SubPbModel.this.crN(), error, errorString, SubPbModel.this.iTC);
                            }
                        }
                    }
                }
            }
        };
        this.cVg = tbPageContext;
        this.iWk = new ArrayList<>();
        this.iTC = new l();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.iTG);
        registerListener(this.iTG);
    }

    public String cnw() {
        return this.iVW;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aOM() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public l crM() {
        return this.iTC;
    }

    public AntiData bCW() {
        return this.dmd;
    }

    public boolean crN() {
        return (this.iTC == null || this.iTC.cld() == null) ? false : true;
    }

    public void a(a aVar) {
        this.iWf = aVar;
    }

    public MarkData l(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iVW);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.iVW);
        markData.setFloor(postData.cKY());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.iTG);
        if (this.iGW != null) {
            this.iGW.unRegisterListener();
        }
        byR();
    }

    private void byR() {
        if (this.fWo != null) {
            this.fWo.destory();
            this.fWo = null;
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
        if (!TextUtils.isEmpty(str) && this.iTC != null && this.iTC.clh() != null) {
            ArrayList<PostData> clh = this.iTC.clh();
            int size = clh.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(clh.get(i).getId())) {
                    clh.remove(i);
                    this.iWg++;
                    this.iTC.setTotalCount(this.iTC.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int crO() {
        int aVJ = this.iTC.aVJ();
        if (aVJ == 0) {
            return aVJ + 1;
        }
        if (this.mLoadType == 0) {
            return aVJ + 1;
        }
        if (this.mLoadType == 2 && this.iTC.clh().size() != 0 && this.iTC.clh().size() % this.iTC.getPageSize() == 0) {
            return aVJ + 1;
        }
        if (this.mLoadType == 3 && this.iWm) {
            return this.iTC.clf() - 1;
        }
        if (this.mLoadType == 3 && aVJ > 0) {
            return this.iTC.cle() - 1;
        }
        return aVJ;
    }

    private SubPbRequestMessage cqV() {
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
            intValue = crO();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.iWm && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.cVg.getPageActivity(), Long.parseLong(this.iVW), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.iWb, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return zq(0);
    }

    public boolean crP() {
        return zq(2);
    }

    public void crQ() {
        int pageSize;
        if (this.iWg > 0 && this.iTC != null && (pageSize = this.iTC.getPageSize()) > 0) {
            int aVJ = this.iTC.aVJ();
            for (int i = (((this.iWg + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.iWr = o(Integer.valueOf(aVJ - i));
                this.iWr.setTreatDelPage(true);
                sendMessage(this.iWr);
            }
        }
        this.iWg = 0;
    }

    public boolean crR() {
        return zq(1);
    }

    public boolean zq(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.iVW == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        crQ();
        this.mLoadType = i;
        this.iWr = cqV();
        sendMessage(this.iWr);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(l lVar) {
        ArrayList<PostData> clh = lVar.clh();
        if (clh == null || clh.size() == 0) {
            lVar.setCurrentPage(this.iTC.aVJ());
        }
        if (this.mLoadType == 1) {
            this.iTC = lVar;
        } else if (this.mLoadType == 2) {
            this.iTC.b(lVar, true);
        } else if (this.mLoadType == 3) {
            this.iTC.a(lVar, false);
        } else {
            this.iTC.b(lVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(l lVar) {
        if (this.mLoadType == 1) {
            this.iTC = lVar;
            this.iTC.clg();
        } else if (this.mLoadType == 2) {
            this.iTC.c(lVar, true);
        } else if (this.mLoadType == 3) {
            this.iTC.d(lVar, false);
        } else {
            this.iTC.a(lVar);
        }
    }

    public boolean crn() {
        return this.iVX;
    }

    public boolean crS() {
        return this.iCO;
    }

    public boolean crT() {
        return "hot_topic".equals(getStType());
    }

    public void qM(boolean z) {
        this.iCO = z;
    }

    public int ckE() {
        return this.iBM;
    }

    public String crU() {
        return this.iWe;
    }

    public void Gt(String str) {
        this.iWe = str;
    }

    public String crV() {
        return this.iVZ;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData vi(String str) {
        if (this.iTC == null || this.iTC.aPk() == null || this.iTC.aAe() == null || this.iTC.cld() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.iTC.aPk().getName());
        writeData.setForumId(this.iTC.aPk().getId());
        writeData.setFromForumId(this.iWc);
        writeData.setFloor(this.iTC.cld().getId());
        writeData.setType(2);
        writeData.setThreadId(this.iTC.aAe().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aOL() {
        crP();
        return true;
    }

    public boolean crW() {
        return this.iWq;
    }

    public void qN(boolean z) {
        this.iWq = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.iTF = aVar;
    }

    public SmallTailInfo crX() {
        return this.iWl;
    }

    public boolean crY() {
        return this.iWj;
    }

    public ConcurrentHashMap<String, ImageUrlData> crZ() {
        return this.iWo;
    }

    public ArrayList<String> csa() {
        return this.iWn;
    }

    public boolean csb() {
        return this.iWp;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.iWb;
    }

    public AttentionHostData csc() {
        if (this.iWi == null) {
            this.iWi = new AttentionHostData();
            if (this.iTC != null && this.iTC.aAe() != null && this.iTC.aAe().aCm() != null) {
                this.iWi.parserWithMetaData(this.iTC.aAe().aCm());
            }
        }
        return this.iWi;
    }

    public boolean con() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public int csd() {
        return this.pageFromType;
    }

    public String cnv() {
        return this.iWa;
    }
}
