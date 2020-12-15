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
import com.baidu.tbadk.core.util.au;
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
/* loaded from: classes22.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private TbPageContext<?> eNx;
    private int fNh;
    private int fXg;
    private String fXh;
    private boolean feZ;
    private AntiData fju;
    private boolean isLoading;
    private int isManager;
    private com.baidu.tieba.tbadkCore.d.b iyj;
    private String kMo;
    private boolean lCq;
    private PbFakeFloorModel lHk;
    private p lVu;
    private PbFakeFloorModel.a lVx;
    private com.baidu.adp.framework.listener.a lVy;
    private String lXQ;
    private String lXR;
    private String lXS;
    private String lXT;
    private boolean lXU;
    private String lXV;
    private boolean lXW;
    private String lXX;
    private a lXY;
    private int lXZ;
    private ArrayList<IconData> lYa;
    private AttentionHostData lYb;
    private boolean lYc;
    private ArrayList<p> lYd;
    private SmallTailInfo lYe;
    private boolean lYf;
    private ArrayList<String> lYg;
    private ConcurrentHashMap<String, ImageUrlData> lYh;
    private boolean lYi;
    private boolean lYj;
    private int lYk;
    private int lYl;
    private SubPbRequestMessage lYm;
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
    private int userLevel;

    /* loaded from: classes22.dex */
    public interface a {
        void a(boolean z, int i, String str, p pVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.lXQ = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.kMo = intent.getStringExtra("from_forum_id");
            this.lXV = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.feZ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.lXR = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.lXW = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.lXS = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.lYe = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.lYe != null) {
                this.lYe.updateShowInfo();
            }
            this.fju = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.lYa = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.lYc = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.lYh = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.lYh.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.lYg = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.lYi = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.lXT = intent.getStringExtra("high_light_post_id");
            this.lXU = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
            this.fXg = intent.getIntExtra(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = intent.getIntExtra(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.lYk = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
            this.lYl = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
            this.fXh = intent.getStringExtra(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
            this.userLevel = intent.getIntExtra(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.lXQ = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.kMo = bundle.getString("from_forum_id");
            this.lXV = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.feZ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.lXR = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.lXW = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.lXS = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.lYe = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.lYe != null) {
                this.lYe.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.fju = new AntiData();
                this.fju.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!y.isEmpty(stringArrayList)) {
                this.lYa = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.lYa.add(iconData);
                    }
                }
            }
            this.lYc = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.lXT = bundle.getString("high_light_post_id");
            this.lXU = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
            this.fXg = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.fXg = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.lYk = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
            this.lYl = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
            this.fXh = bundle.getString(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
            this.userLevel = bundle.getInt(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        }
    }

    public void aD(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.lXQ);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.feZ);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.lXR);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.lXS);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.lXW);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.userIdentity);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.lYe));
            if (this.fju != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.fju.toJsonString());
            }
            if (!y.isEmpty(this.lYa)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.lYa.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.kMo);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.lXV);
            bundle.putString("high_light_post_id", this.lXT);
            bundle.putBoolean("high_light_post_id", this.lXU);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fNh = 0;
        this.lXQ = null;
        this.postID = null;
        this.stType = null;
        this.feZ = false;
        this.lXR = null;
        this.lXS = null;
        this.lXT = null;
        this.lXU = false;
        this.pageFromType = 0;
        this.lXW = false;
        this.lCq = false;
        this.userIdentity = 0;
        this.lXX = null;
        this.eNx = null;
        this.lVu = null;
        this.lXY = null;
        this.lXZ = 0;
        this.lYc = false;
        this.lYd = null;
        this.isLoading = false;
        this.iyj = null;
        this.lYi = true;
        this.mOffset = 0;
        this.lHk = null;
        this.lVx = null;
        this.lYj = false;
        this.lVy = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.eNx.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.lYd.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.lYd.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.lYd != null && SubPbModel.this.lYd.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.lYd.size() - 1; size >= 0; size--) {
                                p pVar2 = (p) SubPbModel.this.lYd.get(size);
                                if (SubPbModel.this.lYf) {
                                    SubPbModel.this.lVu.c(pVar2, true);
                                } else {
                                    SubPbModel.this.lVu.b(pVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.lYd.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.iyj == null) {
                        SubPbModel.this.iyj = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.iyj != null) {
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
                            SubPbModel.this.iyj.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.iyj = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.iyj = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.lXY != null) {
                                SubPbModel.this.lXY.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                pVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                pVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (pVar.dnR().errorno.intValue() != 0) {
                                if (SubPbModel.this.lXY != null) {
                                    SubPbModel.this.lXY.a(false, pVar.lCr.errorno.intValue(), pVar.lCr.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (pVar.bmn() != null && pVar.bmn().boP() != null) {
                                pVar.bmn().boP().getUserId();
                                if (y.isEmpty(pVar.dnN().boP().getIconInfo()) && SubPbModel.this.lYa != null) {
                                    pVar.dnN().boP().setIconInfo(SubPbModel.this.lYa);
                                }
                            }
                            if (pVar.dnN() != null) {
                                SubPbModel.this.postID = pVar.dnN().getId();
                            }
                            if (pVar.bmn() != null) {
                                SubPbModel.this.lXQ = pVar.bmn().getId();
                                SubPbModel.this.lCq = pVar.bkY();
                                SubPbModel.this.lXX = pVar.bmn().boX();
                            }
                            if (SubPbModel.this.lXX != null && SubPbModel.this.postID != null && SubPbModel.this.lXX.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.lCq = true;
                            }
                            if (SubPbModel.this.lYf) {
                                SubPbModel.this.f(pVar);
                            } else {
                                SubPbModel.this.e(pVar);
                            }
                            if (SubPbModel.this.lXY != null) {
                                SubPbModel.this.lXY.a(SubPbModel.this.duO(), error, errorString, SubPbModel.this.lVu);
                            }
                        }
                    }
                }
            }
        };
        this.eNx = tbPageContext;
        this.lYd = new ArrayList<>();
        this.lVu = new p();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.lVy);
        registerListener(this.lVy);
    }

    public String dqk() {
        return this.lXQ;
    }

    public String dql() {
        return (StringUtils.isNull(this.lXQ) || "0".equals(this.lXQ)) ? this.oriUgcNid : this.lXQ;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bCP() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public p duN() {
        return this.lVu;
    }

    public AntiData cBf() {
        return this.fju;
    }

    public boolean duO() {
        return (this.lVu == null || this.lVu.dnN() == null) ? false : true;
    }

    public void a(a aVar) {
        this.lXY = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lXQ);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.lXQ);
        markData.setFloor(postData.dPh());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.lVy);
        if (this.lHk != null) {
            this.lHk.unRegisterListener();
        }
        cwt();
    }

    private void cwt() {
        if (this.iyj != null) {
            this.iyj.destory();
            this.iyj = null;
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

    public void QJ(String str) {
        if (!TextUtils.isEmpty(str) && this.lVu != null && this.lVu.dnV() != null) {
            ArrayList<PostData> dnV = this.lVu.dnV();
            int size = dnV.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(dnV.get(i).getId())) {
                    dnV.remove(i);
                    this.lXZ++;
                    this.lVu.setTotalCount(this.lVu.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int duP() {
        int bKK = this.lVu.bKK();
        if (bKK == 0) {
            return bKK + 1;
        }
        if (this.fNh == 0) {
            return bKK + 1;
        }
        if (this.fNh == 2 && this.lVu.dnV().size() != 0 && this.lVu.dnV().size() % this.lVu.getPageSize() == 0) {
            return bKK + 1;
        }
        if (this.fNh == 3 && this.lYf) {
            return this.lVu.dnT() - 1;
        }
        if (this.fNh == 3 && bKK > 0) {
            return this.lVu.dnS() - 1;
        }
        return bKK;
    }

    private SubPbRequestMessage dtU() {
        this.isLoading = true;
        return r(null);
    }

    private SubPbRequestMessage r(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.fNh) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else if (!au.isEmpty(this.oriUgcNid)) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
            j2 = com.baidu.adp.lib.f.b.toLong(this.lXS, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.lXS, 0L);
        }
        if (num == null) {
            intValue = duP();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.lYf && this.fNh == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.eNx.getPageActivity(), Long.parseLong(this.lXQ), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.kMo, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return HK(0);
    }

    public boolean duQ() {
        return HK(2);
    }

    public void duR() {
        int pageSize;
        if (this.lXZ > 0 && this.lVu != null && (pageSize = this.lVu.getPageSize()) > 0) {
            int bKK = this.lVu.bKK();
            for (int i = (((this.lXZ + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.lYm = r(Integer.valueOf(bKK - i));
                this.lYm.setTreatDelPage(true);
                sendMessage(this.lYm);
            }
        }
        this.lXZ = 0;
    }

    public boolean duS() {
        return HK(1);
    }

    public boolean duT() {
        return HK(3);
    }

    public boolean HK(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.lXQ == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        duR();
        this.fNh = i;
        this.lYm = dtU();
        sendMessage(this.lYm);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        ArrayList<PostData> dnV = pVar.dnV();
        if (dnV == null || dnV.size() == 0) {
            pVar.setCurrentPage(this.lVu.bKK());
        }
        if (this.fNh == 1) {
            this.lVu = pVar;
        } else if (this.fNh == 2) {
            this.lVu.b(pVar, true);
        } else if (this.fNh == 3) {
            this.lVu.a(pVar, false);
        } else {
            this.lVu.b(pVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(p pVar) {
        if (this.fNh == 1) {
            this.lVu = pVar;
            this.lVu.dnU();
        } else if (this.fNh == 2) {
            this.lVu.c(pVar, true);
        } else if (this.fNh == 3) {
            this.lVu.d(pVar, false);
        } else {
            this.lVu.a(pVar);
        }
    }

    public boolean dun() {
        return this.feZ;
    }

    public boolean duU() {
        return this.lCq;
    }

    public boolean duV() {
        return "hot_topic".equals(getStType());
    }

    public void vU(boolean z) {
        this.lCq = z;
    }

    public int dnj() {
        return this.userIdentity;
    }

    public String duW() {
        return this.lXX;
    }

    public void QK(String str) {
        this.lXX = str;
    }

    public String duX() {
        return this.lXS;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData DR(String str) {
        if (this.lVu == null || this.lVu.bDp() == null || this.lVu.bmn() == null || this.lVu.dnN() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.lVu.bDp().getName());
        writeData.setForumId(this.lVu.bDp().getId());
        writeData.setFromForumId(this.lXV);
        writeData.setFloor(this.lVu.dnN().getId());
        writeData.setType(2);
        writeData.setThreadId(this.lVu.bmn().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bCO() {
        duQ();
        return true;
    }

    public boolean duY() {
        return this.lYj;
    }

    public void vV(boolean z) {
        this.lYj = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.lVx = aVar;
    }

    public SmallTailInfo duZ() {
        return this.lYe;
    }

    public boolean dva() {
        return this.lYc;
    }

    public ConcurrentHashMap<String, ImageUrlData> dvb() {
        return this.lYh;
    }

    public ArrayList<String> dvc() {
        return this.lYg;
    }

    public boolean dvd() {
        return this.lYi;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.kMo;
    }

    public AttentionHostData dve() {
        if (this.lYb == null) {
            this.lYb = new AttentionHostData();
            if (this.lVu != null && this.lVu.bmn() != null && this.lVu.bmn().boP() != null) {
                this.lYb.parserWithMetaData(this.lVu.bmn().boP());
            }
        }
        return this.lYb;
    }

    public int dvf() {
        return this.pageFromType;
    }

    public String dqj() {
        return this.lXT;
    }

    public boolean dvg() {
        return this.lXU;
    }

    public int bLy() {
        return this.fXg;
    }

    public int getIsManager() {
        return this.isManager;
    }

    public int dvh() {
        return this.lYl;
    }

    public int dvi() {
        return this.lYk;
    }

    public String bLB() {
        return this.fXh;
    }

    public int bLC() {
        return this.userLevel;
    }
}
