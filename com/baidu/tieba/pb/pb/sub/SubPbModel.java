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
    private TbPageContext<?> cVh;
    private AntiData dme;
    private com.baidu.tieba.tbadkCore.d.b fWq;
    private int iBO;
    private boolean iCQ;
    private PbFakeFloorModel iGY;
    private l iTE;
    private PbFakeFloorModel.a iTH;
    private com.baidu.adp.framework.listener.a iTI;
    private String iVY;
    private boolean iVZ;
    private String iWa;
    private String iWb;
    private String iWc;
    private String iWd;
    private String iWe;
    private boolean iWf;
    private String iWg;
    private a iWh;
    private int iWi;
    private ArrayList<IconData> iWj;
    private AttentionHostData iWk;
    private boolean iWl;
    private ArrayList<l> iWm;
    private SmallTailInfo iWn;
    private boolean iWo;
    private ArrayList<String> iWp;
    private ConcurrentHashMap<String, ImageUrlData> iWq;
    private boolean iWr;
    private boolean iWs;
    private SubPbRequestMessage iWt;
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
            this.iVY = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.iWd = intent.getStringExtra("from_forum_id");
            this.iWe = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.iVZ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.iWa = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.iWf = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.iWb = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.iBO = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.iWn = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.iWn != null) {
                this.iWn.updateShowInfo();
            }
            this.dme = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.iWj = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.iWl = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.iWq = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.iWq.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.iWp = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.iWr = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.iWc = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.iVY = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.iWd = bundle.getString("from_forum_id");
            this.iWe = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.iVZ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.iWa = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.iWf = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.iWb = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.iBO = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.iWn = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.iWn != null) {
                this.iWn.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.dme = new AntiData();
                this.dme.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.isEmpty(stringArrayList)) {
                this.iWj = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.iWj.add(iconData);
                    }
                }
            }
            this.iWl = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.iWc = bundle.getString("high_light_post_id");
        }
    }

    public void au(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.iVY);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.iVZ);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.iWa);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.iWb);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.iWf);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.iBO);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.iWn));
            if (this.dme != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.dme.toJsonString());
            }
            if (!v.isEmpty(this.iWj)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.iWj.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.iWd);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.iWe);
            bundle.putString("high_light_post_id", this.iWc);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.iVY = null;
        this.postID = null;
        this.stType = null;
        this.iVZ = false;
        this.iWa = null;
        this.iWb = null;
        this.iWc = null;
        this.pageFromType = 0;
        this.iWf = false;
        this.iCQ = false;
        this.iBO = 0;
        this.iWg = null;
        this.cVh = null;
        this.iTE = null;
        this.iWh = null;
        this.iWi = 0;
        this.iWl = false;
        this.iWm = null;
        this.isLoading = false;
        this.fWq = null;
        this.iWr = true;
        this.mOffset = 0;
        this.iGY = null;
        this.iTH = null;
        this.iWs = false;
        this.iTI = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.cVh.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.iWm.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.iWm.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.iWm != null && SubPbModel.this.iWm.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.iWm.size() - 1; size >= 0; size--) {
                                l lVar2 = (l) SubPbModel.this.iWm.get(size);
                                if (SubPbModel.this.iWo) {
                                    SubPbModel.this.iTE.c(lVar2, true);
                                } else {
                                    SubPbModel.this.iTE.b(lVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.iWm.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.fWq == null) {
                        SubPbModel.this.fWq = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.fWq != null) {
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
                            SubPbModel.this.fWq.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.fWq = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.fWq = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.iWh != null) {
                                SubPbModel.this.iWh.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                lVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                lVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (lVar.cle().errorno.intValue() != 0) {
                                if (SubPbModel.this.iWh != null) {
                                    SubPbModel.this.iWh.a(false, lVar.iCR.errorno.intValue(), lVar.iCR.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (lVar.aAg() != null && lVar.aAg().aCo() != null) {
                                lVar.aAg().aCo().getUserId();
                                if (v.isEmpty(lVar.clf().aCo().getIconInfo()) && SubPbModel.this.iWj != null) {
                                    lVar.clf().aCo().setIconInfo(SubPbModel.this.iWj);
                                }
                            }
                            if (lVar.clf() != null) {
                                SubPbModel.this.postID = lVar.clf().getId();
                            }
                            if (lVar.aAg() != null) {
                                SubPbModel.this.iVY = lVar.aAg().getId();
                                SubPbModel.this.iCQ = lVar.ayL();
                                SubPbModel.this.iWg = lVar.aAg().aCx();
                            }
                            if (SubPbModel.this.iWg != null && SubPbModel.this.postID != null && SubPbModel.this.iWg.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.iCQ = true;
                            }
                            if (SubPbModel.this.iWo) {
                                SubPbModel.this.f(lVar);
                            } else {
                                SubPbModel.this.e(lVar);
                            }
                            if (SubPbModel.this.iWh != null) {
                                SubPbModel.this.iWh.a(SubPbModel.this.crP(), error, errorString, SubPbModel.this.iTE);
                            }
                        }
                    }
                }
            }
        };
        this.cVh = tbPageContext;
        this.iWm = new ArrayList<>();
        this.iTE = new l();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.iTI);
        registerListener(this.iTI);
    }

    public String cny() {
        return this.iVY;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aOO() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public l crO() {
        return this.iTE;
    }

    public AntiData bCY() {
        return this.dme;
    }

    public boolean crP() {
        return (this.iTE == null || this.iTE.clf() == null) ? false : true;
    }

    public void a(a aVar) {
        this.iWh = aVar;
    }

    public MarkData l(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iVY);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.iVY);
        markData.setFloor(postData.cLa());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.iTI);
        if (this.iGY != null) {
            this.iGY.unRegisterListener();
        }
        byT();
    }

    private void byT() {
        if (this.fWq != null) {
            this.fWq.destory();
            this.fWq = null;
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
        if (!TextUtils.isEmpty(str) && this.iTE != null && this.iTE.clj() != null) {
            ArrayList<PostData> clj = this.iTE.clj();
            int size = clj.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(clj.get(i).getId())) {
                    clj.remove(i);
                    this.iWi++;
                    this.iTE.setTotalCount(this.iTE.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int crQ() {
        int aVL = this.iTE.aVL();
        if (aVL == 0) {
            return aVL + 1;
        }
        if (this.mLoadType == 0) {
            return aVL + 1;
        }
        if (this.mLoadType == 2 && this.iTE.clj().size() != 0 && this.iTE.clj().size() % this.iTE.getPageSize() == 0) {
            return aVL + 1;
        }
        if (this.mLoadType == 3 && this.iWo) {
            return this.iTE.clh() - 1;
        }
        if (this.mLoadType == 3 && aVL > 0) {
            return this.iTE.clg() - 1;
        }
        return aVL;
    }

    private SubPbRequestMessage cqX() {
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
            intValue = crQ();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.iWo && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.cVh.getPageActivity(), Long.parseLong(this.iVY), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.iWd, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return zq(0);
    }

    public boolean crR() {
        return zq(2);
    }

    public void crS() {
        int pageSize;
        if (this.iWi > 0 && this.iTE != null && (pageSize = this.iTE.getPageSize()) > 0) {
            int aVL = this.iTE.aVL();
            for (int i = (((this.iWi + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.iWt = o(Integer.valueOf(aVL - i));
                this.iWt.setTreatDelPage(true);
                sendMessage(this.iWt);
            }
        }
        this.iWi = 0;
    }

    public boolean crT() {
        return zq(1);
    }

    public boolean zq(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.iVY == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        crS();
        this.mLoadType = i;
        this.iWt = cqX();
        sendMessage(this.iWt);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(l lVar) {
        ArrayList<PostData> clj = lVar.clj();
        if (clj == null || clj.size() == 0) {
            lVar.setCurrentPage(this.iTE.aVL());
        }
        if (this.mLoadType == 1) {
            this.iTE = lVar;
        } else if (this.mLoadType == 2) {
            this.iTE.b(lVar, true);
        } else if (this.mLoadType == 3) {
            this.iTE.a(lVar, false);
        } else {
            this.iTE.b(lVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(l lVar) {
        if (this.mLoadType == 1) {
            this.iTE = lVar;
            this.iTE.cli();
        } else if (this.mLoadType == 2) {
            this.iTE.c(lVar, true);
        } else if (this.mLoadType == 3) {
            this.iTE.d(lVar, false);
        } else {
            this.iTE.a(lVar);
        }
    }

    public boolean crp() {
        return this.iVZ;
    }

    public boolean crU() {
        return this.iCQ;
    }

    public boolean crV() {
        return "hot_topic".equals(getStType());
    }

    public void qM(boolean z) {
        this.iCQ = z;
    }

    public int ckG() {
        return this.iBO;
    }

    public String crW() {
        return this.iWg;
    }

    public void Gt(String str) {
        this.iWg = str;
    }

    public String crX() {
        return this.iWb;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData vi(String str) {
        if (this.iTE == null || this.iTE.aPm() == null || this.iTE.aAg() == null || this.iTE.clf() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.iTE.aPm().getName());
        writeData.setForumId(this.iTE.aPm().getId());
        writeData.setFromForumId(this.iWe);
        writeData.setFloor(this.iTE.clf().getId());
        writeData.setType(2);
        writeData.setThreadId(this.iTE.aAg().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aON() {
        crR();
        return true;
    }

    public boolean crY() {
        return this.iWs;
    }

    public void qN(boolean z) {
        this.iWs = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.iTH = aVar;
    }

    public SmallTailInfo crZ() {
        return this.iWn;
    }

    public boolean csa() {
        return this.iWl;
    }

    public ConcurrentHashMap<String, ImageUrlData> csb() {
        return this.iWq;
    }

    public ArrayList<String> csc() {
        return this.iWp;
    }

    public boolean csd() {
        return this.iWr;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.iWd;
    }

    public AttentionHostData cse() {
        if (this.iWk == null) {
            this.iWk = new AttentionHostData();
            if (this.iTE != null && this.iTE.aAg() != null && this.iTE.aAg().aCo() != null) {
                this.iWk.parserWithMetaData(this.iTE.aAg().aCo());
            }
        }
        return this.iWk;
    }

    public boolean cop() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public int csf() {
        return this.pageFromType;
    }

    public String cnx() {
        return this.iWc;
    }
}
