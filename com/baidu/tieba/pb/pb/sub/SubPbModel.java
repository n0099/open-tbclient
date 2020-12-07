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
    private int fXe;
    private String fXf;
    private boolean feZ;
    private AntiData fju;
    private boolean isLoading;
    private int isManager;
    private com.baidu.tieba.tbadkCore.d.b iyh;
    private String kMm;
    private boolean lCo;
    private PbFakeFloorModel lHi;
    private p lVs;
    private PbFakeFloorModel.a lVv;
    private com.baidu.adp.framework.listener.a lVw;
    private String lXO;
    private String lXP;
    private String lXQ;
    private String lXR;
    private boolean lXS;
    private String lXT;
    private boolean lXU;
    private String lXV;
    private a lXW;
    private int lXX;
    private ArrayList<IconData> lXY;
    private AttentionHostData lXZ;
    private boolean lYa;
    private ArrayList<p> lYb;
    private SmallTailInfo lYc;
    private boolean lYd;
    private ArrayList<String> lYe;
    private ConcurrentHashMap<String, ImageUrlData> lYf;
    private boolean lYg;
    private boolean lYh;
    private int lYi;
    private int lYj;
    private SubPbRequestMessage lYk;
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
            this.lXO = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.kMm = intent.getStringExtra("from_forum_id");
            this.lXT = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.feZ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.lXP = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.lXU = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.lXQ = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.lYc = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.lYc != null) {
                this.lYc.updateShowInfo();
            }
            this.fju = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.lXY = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.lYa = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.lYf = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.lYf.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.lYe = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.lYg = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.lXR = intent.getStringExtra("high_light_post_id");
            this.lXS = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
            this.fXe = intent.getIntExtra(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = intent.getIntExtra(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.lYi = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
            this.lYj = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
            this.fXf = intent.getStringExtra(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
            this.userLevel = intent.getIntExtra(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.lXO = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.kMm = bundle.getString("from_forum_id");
            this.lXT = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.feZ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.lXP = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.lXU = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.lXQ = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.lYc = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.lYc != null) {
                this.lYc.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.fju = new AntiData();
                this.fju.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!y.isEmpty(stringArrayList)) {
                this.lXY = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.lXY.add(iconData);
                    }
                }
            }
            this.lYa = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.lXR = bundle.getString("high_light_post_id");
            this.lXS = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
            this.fXe = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.fXe = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.lYi = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
            this.lYj = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
            this.fXf = bundle.getString(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
            this.userLevel = bundle.getInt(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        }
    }

    public void aD(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.lXO);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.feZ);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.lXP);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.lXQ);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.lXU);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.userIdentity);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.lYc));
            if (this.fju != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.fju.toJsonString());
            }
            if (!y.isEmpty(this.lXY)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.lXY.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.kMm);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.lXT);
            bundle.putString("high_light_post_id", this.lXR);
            bundle.putBoolean("high_light_post_id", this.lXS);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fNh = 0;
        this.lXO = null;
        this.postID = null;
        this.stType = null;
        this.feZ = false;
        this.lXP = null;
        this.lXQ = null;
        this.lXR = null;
        this.lXS = false;
        this.pageFromType = 0;
        this.lXU = false;
        this.lCo = false;
        this.userIdentity = 0;
        this.lXV = null;
        this.eNx = null;
        this.lVs = null;
        this.lXW = null;
        this.lXX = 0;
        this.lYa = false;
        this.lYb = null;
        this.isLoading = false;
        this.iyh = null;
        this.lYg = true;
        this.mOffset = 0;
        this.lHi = null;
        this.lVv = null;
        this.lYh = false;
        this.lVw = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.lYb.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.lYb.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.lYb != null && SubPbModel.this.lYb.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.lYb.size() - 1; size >= 0; size--) {
                                p pVar2 = (p) SubPbModel.this.lYb.get(size);
                                if (SubPbModel.this.lYd) {
                                    SubPbModel.this.lVs.c(pVar2, true);
                                } else {
                                    SubPbModel.this.lVs.b(pVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.lYb.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.iyh == null) {
                        SubPbModel.this.iyh = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.iyh != null) {
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
                            SubPbModel.this.iyh.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.iyh = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.iyh = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.lXW != null) {
                                SubPbModel.this.lXW.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                pVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                pVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (pVar.dnQ().errorno.intValue() != 0) {
                                if (SubPbModel.this.lXW != null) {
                                    SubPbModel.this.lXW.a(false, pVar.lCp.errorno.intValue(), pVar.lCp.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (pVar.bmn() != null && pVar.bmn().boP() != null) {
                                pVar.bmn().boP().getUserId();
                                if (y.isEmpty(pVar.dnM().boP().getIconInfo()) && SubPbModel.this.lXY != null) {
                                    pVar.dnM().boP().setIconInfo(SubPbModel.this.lXY);
                                }
                            }
                            if (pVar.dnM() != null) {
                                SubPbModel.this.postID = pVar.dnM().getId();
                            }
                            if (pVar.bmn() != null) {
                                SubPbModel.this.lXO = pVar.bmn().getId();
                                SubPbModel.this.lCo = pVar.bkY();
                                SubPbModel.this.lXV = pVar.bmn().boX();
                            }
                            if (SubPbModel.this.lXV != null && SubPbModel.this.postID != null && SubPbModel.this.lXV.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.lCo = true;
                            }
                            if (SubPbModel.this.lYd) {
                                SubPbModel.this.f(pVar);
                            } else {
                                SubPbModel.this.e(pVar);
                            }
                            if (SubPbModel.this.lXW != null) {
                                SubPbModel.this.lXW.a(SubPbModel.this.duN(), error, errorString, SubPbModel.this.lVs);
                            }
                        }
                    }
                }
            }
        };
        this.eNx = tbPageContext;
        this.lYb = new ArrayList<>();
        this.lVs = new p();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.lVw);
        registerListener(this.lVw);
    }

    public String dqj() {
        return this.lXO;
    }

    public String dqk() {
        return (StringUtils.isNull(this.lXO) || "0".equals(this.lXO)) ? this.oriUgcNid : this.lXO;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bCP() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public p duM() {
        return this.lVs;
    }

    public AntiData cBe() {
        return this.fju;
    }

    public boolean duN() {
        return (this.lVs == null || this.lVs.dnM() == null) ? false : true;
    }

    public void a(a aVar) {
        this.lXW = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lXO);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.lXO);
        markData.setFloor(postData.dPg());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.lVw);
        if (this.lHi != null) {
            this.lHi.unRegisterListener();
        }
        cws();
    }

    private void cws() {
        if (this.iyh != null) {
            this.iyh.destory();
            this.iyh = null;
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
        if (!TextUtils.isEmpty(str) && this.lVs != null && this.lVs.dnU() != null) {
            ArrayList<PostData> dnU = this.lVs.dnU();
            int size = dnU.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(dnU.get(i).getId())) {
                    dnU.remove(i);
                    this.lXX++;
                    this.lVs.setTotalCount(this.lVs.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int duO() {
        int bKK = this.lVs.bKK();
        if (bKK == 0) {
            return bKK + 1;
        }
        if (this.fNh == 0) {
            return bKK + 1;
        }
        if (this.fNh == 2 && this.lVs.dnU().size() != 0 && this.lVs.dnU().size() % this.lVs.getPageSize() == 0) {
            return bKK + 1;
        }
        if (this.fNh == 3 && this.lYd) {
            return this.lVs.dnS() - 1;
        }
        if (this.fNh == 3 && bKK > 0) {
            return this.lVs.dnR() - 1;
        }
        return bKK;
    }

    private SubPbRequestMessage dtT() {
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
            j2 = com.baidu.adp.lib.f.b.toLong(this.lXQ, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.lXQ, 0L);
        }
        if (num == null) {
            intValue = duO();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.lYd && this.fNh == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.eNx.getPageActivity(), Long.parseLong(this.lXO), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.kMm, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return HK(0);
    }

    public boolean duP() {
        return HK(2);
    }

    public void duQ() {
        int pageSize;
        if (this.lXX > 0 && this.lVs != null && (pageSize = this.lVs.getPageSize()) > 0) {
            int bKK = this.lVs.bKK();
            for (int i = (((this.lXX + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.lYk = r(Integer.valueOf(bKK - i));
                this.lYk.setTreatDelPage(true);
                sendMessage(this.lYk);
            }
        }
        this.lXX = 0;
    }

    public boolean duR() {
        return HK(1);
    }

    public boolean duS() {
        return HK(3);
    }

    public boolean HK(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.lXO == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        duQ();
        this.fNh = i;
        this.lYk = dtT();
        sendMessage(this.lYk);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        ArrayList<PostData> dnU = pVar.dnU();
        if (dnU == null || dnU.size() == 0) {
            pVar.setCurrentPage(this.lVs.bKK());
        }
        if (this.fNh == 1) {
            this.lVs = pVar;
        } else if (this.fNh == 2) {
            this.lVs.b(pVar, true);
        } else if (this.fNh == 3) {
            this.lVs.a(pVar, false);
        } else {
            this.lVs.b(pVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(p pVar) {
        if (this.fNh == 1) {
            this.lVs = pVar;
            this.lVs.dnT();
        } else if (this.fNh == 2) {
            this.lVs.c(pVar, true);
        } else if (this.fNh == 3) {
            this.lVs.d(pVar, false);
        } else {
            this.lVs.a(pVar);
        }
    }

    public boolean dum() {
        return this.feZ;
    }

    public boolean duT() {
        return this.lCo;
    }

    public boolean duU() {
        return "hot_topic".equals(getStType());
    }

    public void vU(boolean z) {
        this.lCo = z;
    }

    public int dni() {
        return this.userIdentity;
    }

    public String duV() {
        return this.lXV;
    }

    public void QK(String str) {
        this.lXV = str;
    }

    public String duW() {
        return this.lXQ;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData DR(String str) {
        if (this.lVs == null || this.lVs.bDp() == null || this.lVs.bmn() == null || this.lVs.dnM() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.lVs.bDp().getName());
        writeData.setForumId(this.lVs.bDp().getId());
        writeData.setFromForumId(this.lXT);
        writeData.setFloor(this.lVs.dnM().getId());
        writeData.setType(2);
        writeData.setThreadId(this.lVs.bmn().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bCO() {
        duP();
        return true;
    }

    public boolean duX() {
        return this.lYh;
    }

    public void vV(boolean z) {
        this.lYh = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.lVv = aVar;
    }

    public SmallTailInfo duY() {
        return this.lYc;
    }

    public boolean duZ() {
        return this.lYa;
    }

    public ConcurrentHashMap<String, ImageUrlData> dva() {
        return this.lYf;
    }

    public ArrayList<String> dvb() {
        return this.lYe;
    }

    public boolean dvc() {
        return this.lYg;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.kMm;
    }

    public AttentionHostData dvd() {
        if (this.lXZ == null) {
            this.lXZ = new AttentionHostData();
            if (this.lVs != null && this.lVs.bmn() != null && this.lVs.bmn().boP() != null) {
                this.lXZ.parserWithMetaData(this.lVs.bmn().boP());
            }
        }
        return this.lXZ;
    }

    public int dve() {
        return this.pageFromType;
    }

    public String dqi() {
        return this.lXR;
    }

    public boolean dvf() {
        return this.lXS;
    }

    public int bLx() {
        return this.fXe;
    }

    public int getIsManager() {
        return this.isManager;
    }

    public int dvg() {
        return this.lYj;
    }

    public int dvh() {
        return this.lYi;
    }

    public String bLA() {
        return this.fXf;
    }

    public int bLB() {
        return this.userLevel;
    }
}
