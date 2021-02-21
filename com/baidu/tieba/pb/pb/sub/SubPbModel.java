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
import com.baidu.tieba.pb.data.q;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private TbPageContext<?> eUY;
    private int fUt;
    private boolean fmq;
    private AntiData fqK;
    private int gey;
    private String gez;
    private com.baidu.tieba.tbadkCore.d.b iLM;
    private boolean isLoading;
    private int isManager;
    private String kVs;
    private boolean lLU;
    private PbFakeFloorModel lRd;
    private int mOffset;
    private q mfv;
    private PbFakeFloorModel.a mfy;
    private com.baidu.adp.framework.listener.a mfz;
    private String mhS;
    private String mhT;
    private String mhU;
    private String mhV;
    private boolean mhW;
    private String mhX;
    private boolean mhY;
    private String mhZ;
    private a mia;
    private int mib;
    private ArrayList<IconData> mic;
    private AttentionHostData mie;
    private boolean mif;
    private ArrayList<q> mig;
    private SmallTailInfo mih;
    private boolean mii;
    private ArrayList<String> mij;
    private ConcurrentHashMap<String, ImageUrlData> mik;
    private boolean mil;
    private boolean mim;
    private int mio;
    private int mip;
    private boolean miq;
    private SubPbRequestMessage mir;
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

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z, int i, String str, q qVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.mhS = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.kVs = intent.getStringExtra("from_forum_id");
            this.mhX = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.fmq = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.mhT = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.mhY = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.mhU = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.mih = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.mih != null) {
                this.mih.updateShowInfo();
            }
            this.fqK = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.mic = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.mif = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.mik = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.mik.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.mij = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.mil = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.mhV = intent.getStringExtra("high_light_post_id");
            this.mhW = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
            this.gey = intent.getIntExtra(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = intent.getIntExtra(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.mio = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
            this.mip = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
            this.gez = intent.getStringExtra(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
            this.userLevel = intent.getIntExtra(SubPbActivityConfig.KEY_USER_LEVEL, 0);
            this.miq = intent.getBooleanExtra(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.mhS = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.kVs = bundle.getString("from_forum_id");
            this.mhX = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.fmq = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.mhT = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.mhY = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.mhU = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.mih = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.mih != null) {
                this.mih.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.fqK = new AntiData();
                this.fqK.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!y.isEmpty(stringArrayList)) {
                this.mic = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.mic.add(iconData);
                    }
                }
            }
            this.mif = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.mhV = bundle.getString("high_light_post_id");
            this.mhW = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
            this.gey = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.gey = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.mio = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
            this.mip = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
            this.gez = bundle.getString(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
            this.userLevel = bundle.getInt(SubPbActivityConfig.KEY_USER_LEVEL, 0);
            this.miq = bundle.getBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
        }
    }

    public void aD(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.mhS);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fmq);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.mhT);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.mhU);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.mhY);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.userIdentity);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.mih));
            if (this.fqK != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.fqK.toJsonString());
            }
            if (!y.isEmpty(this.mic)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.mic.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.kVs);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.mhX);
            bundle.putString("high_light_post_id", this.mhV);
            bundle.putBoolean("high_light_post_id", this.mhW);
            bundle.putBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, this.miq);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fUt = 0;
        this.mhS = null;
        this.postID = null;
        this.stType = null;
        this.fmq = false;
        this.mhT = null;
        this.mhU = null;
        this.mhV = null;
        this.mhW = false;
        this.pageFromType = 0;
        this.mhY = false;
        this.lLU = false;
        this.userIdentity = 0;
        this.mhZ = null;
        this.eUY = null;
        this.mfv = null;
        this.mia = null;
        this.mib = 0;
        this.mif = false;
        this.mig = null;
        this.isLoading = false;
        this.iLM = null;
        this.mil = true;
        this.mOffset = 0;
        this.lRd = null;
        this.mfy = null;
        this.mim = false;
        this.mfz = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                boolean z;
                q qVar;
                long j2;
                long j3 = 0;
                if (SubPbModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    SubPbModel.this.isLoading = false;
                    if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                        SubPbModel.this.eUY.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.mig.add(subPbHttpResponseMessage.pbFloorData);
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
                        j3 = responsedMessage.getCostTime();
                        SubPbSocketResponseMessage subPbSocketResponseMessage = (SubPbSocketResponseMessage) responsedMessage;
                        if (subPbSocketResponseMessage.isTreatDelPage()) {
                            if (!subPbSocketResponseMessage.hasError()) {
                                SubPbModel.this.mig.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    long j4 = j3;
                    if (SubPbModel.this.mig != null && SubPbModel.this.mig.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.mig.size() - 1; size >= 0; size--) {
                                q qVar2 = (q) SubPbModel.this.mig.get(size);
                                if (SubPbModel.this.mii) {
                                    SubPbModel.this.mfv.c(qVar2, true);
                                } else {
                                    SubPbModel.this.mfv.b(qVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.mig.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.iLM == null) {
                        SubPbModel.this.iLM = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.iLM != null) {
                        if (error == 0) {
                            int i = -1;
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                i = ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                                j2 = responsedMessage.getCostTime();
                            } else if (responsedMessage instanceof SubPbSocketResponseMessage) {
                                i = ((SubPbSocketResponseMessage) responsedMessage).getDownSize();
                                j4 = responsedMessage.getCostTime();
                                j2 = j;
                            } else {
                                j2 = j;
                            }
                            SubPbModel.this.iLM.a(z, true, error, errorString, i, j2, j4);
                            SubPbModel.this.iLM = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.iLM = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.mia != null) {
                                SubPbModel.this.mia.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                qVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                qVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (qVar.dmd().errorno.intValue() != 0) {
                                if (SubPbModel.this.mia != null) {
                                    SubPbModel.this.mia.a(false, qVar.lLV.errorno.intValue(), qVar.lLV.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (qVar.bln() != null && qVar.bln().bnQ() != null) {
                                qVar.bln().bnQ().getUserId();
                                if (y.isEmpty(qVar.dlY().bnQ().getIconInfo()) && SubPbModel.this.mic != null) {
                                    qVar.dlY().bnQ().setIconInfo(SubPbModel.this.mic);
                                }
                            }
                            if (qVar.dlY() != null) {
                                SubPbModel.this.postID = qVar.dlY().getId();
                            }
                            if (qVar.bln() != null) {
                                SubPbModel.this.mhS = qVar.bln().getId();
                                SubPbModel.this.lLU = qVar.bjZ();
                                SubPbModel.this.mhZ = qVar.bln().bnY();
                            }
                            if (SubPbModel.this.mhZ != null && SubPbModel.this.postID != null && SubPbModel.this.mhZ.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.lLU = true;
                            }
                            if (SubPbModel.this.mii) {
                                SubPbModel.this.f(qVar);
                            } else {
                                SubPbModel.this.e(qVar);
                            }
                            if (SubPbModel.this.mia != null) {
                                SubPbModel.this.mia.a(SubPbModel.this.dth(), error, errorString, SubPbModel.this.mfv);
                            }
                        }
                    }
                }
            }
        };
        this.eUY = tbPageContext;
        this.mig = new ArrayList<>();
        this.mfv = new q();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.mfz);
        registerListener(this.mfz);
    }

    public String doA() {
        return this.mhS;
    }

    public String doB() {
        return (StringUtils.isNull(this.mhS) || "0".equals(this.mhS)) ? this.oriUgcNid : this.mhS;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bBJ() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public q dtg() {
        return this.mfv;
    }

    public AntiData cBz() {
        return this.fqK;
    }

    public boolean dth() {
        return (this.mfv == null || this.mfv.dlY() == null) ? false : true;
    }

    public void a(a aVar) {
        this.mia = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.mhS);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.mhS);
        markData.setFloor(postData.dNF());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.mfz);
        if (this.lRd != null) {
            this.lRd.unRegisterListener();
        }
        cwO();
    }

    private void cwO() {
        if (this.iLM != null) {
            this.iLM.destory();
            this.iLM = null;
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

    public void PZ(String str) {
        if (!TextUtils.isEmpty(str) && this.mfv != null && this.mfv.dmh() != null) {
            ArrayList<PostData> dmh = this.mfv.dmh();
            int size = dmh.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(dmh.get(i).getId())) {
                    dmh.remove(i);
                    this.mib++;
                    this.mfv.setTotalCount(this.mfv.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int dti() {
        int bJK = this.mfv.bJK();
        if (bJK == 0) {
            return bJK + 1;
        }
        if (this.fUt == 0) {
            return bJK + 1;
        }
        if (this.fUt == 2 && this.mfv.dmh().size() != 0 && this.mfv.dmh().size() % this.mfv.getPageSize() == 0) {
            return bJK + 1;
        }
        if (this.fUt == 3 && this.mii) {
            return this.mfv.dmf() - 1;
        }
        if (this.fUt == 3 && bJK > 0) {
            return this.mfv.dme() - 1;
        }
        return bJK;
    }

    private SubPbRequestMessage dsn() {
        this.isLoading = true;
        return u(null);
    }

    private SubPbRequestMessage u(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.fUt) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else if (!au.isEmpty(this.oriUgcNid)) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
            j2 = com.baidu.adp.lib.f.b.toLong(this.mhU, 0L);
        } else if (!TextUtils.isEmpty(this.mhU)) {
            j2 = com.baidu.adp.lib.f.b.toLong(this.mhU, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        }
        if (num == null) {
            intValue = dti();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.mii && this.fUt == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.eUY.getPageActivity(), Long.parseLong(this.mhS), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.kVs, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return Gq(0);
    }

    public boolean dtj() {
        return Gq(2);
    }

    public void dtk() {
        int pageSize;
        if (this.mib > 0 && this.mfv != null && (pageSize = this.mfv.getPageSize()) > 0) {
            int bJK = this.mfv.bJK();
            for (int i = (((this.mib + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.mir = u(Integer.valueOf(bJK - i));
                this.mir.setTreatDelPage(true);
                sendMessage(this.mir);
            }
        }
        this.mib = 0;
    }

    public boolean dtl() {
        return Gq(1);
    }

    public boolean dtm() {
        return Gq(3);
    }

    public boolean Gq(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.mhS == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        dtk();
        this.fUt = i;
        this.mir = dsn();
        sendMessage(this.mir);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(q qVar) {
        ArrayList<PostData> dmh = qVar.dmh();
        if (dmh == null || dmh.size() == 0) {
            qVar.setCurrentPage(this.mfv.bJK());
        }
        if (this.fUt == 1) {
            this.mfv = qVar;
        } else if (this.fUt == 2) {
            this.mfv.b(qVar, true);
        } else if (this.fUt == 3) {
            this.mfv.a(qVar, false);
        } else {
            this.mfv.b(qVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(q qVar) {
        if (this.fUt == 1) {
            this.mfv = qVar;
            this.mfv.dmg();
        } else if (this.fUt == 2) {
            this.mfv.c(qVar, true);
        } else if (this.fUt == 3) {
            this.mfv.d(qVar, false);
        } else {
            this.mfv.a(qVar);
        }
    }

    public boolean dsG() {
        return this.fmq;
    }

    public boolean dtn() {
        return this.lLU;
    }

    public boolean dto() {
        return "hot_topic".equals(getStType());
    }

    public void wh(boolean z) {
        this.lLU = z;
    }

    public int dlv() {
        return this.userIdentity;
    }

    public String dtp() {
        return this.mhZ;
    }

    public void Qa(String str) {
        this.mhZ = str;
    }

    public String dtq() {
        return this.mhU;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData CR(String str) {
        if (this.mfv == null || this.mfv.bCk() == null || this.mfv.bln() == null || this.mfv.dlY() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.mfv.bCk().getName());
        writeData.setForumId(this.mfv.bCk().getId());
        writeData.setFromForumId(this.mhX);
        writeData.setFloor(this.mfv.dlY().getId());
        writeData.setType(2);
        writeData.setThreadId(this.mfv.bln().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bBI() {
        dtj();
        return true;
    }

    public boolean dtr() {
        return this.mim;
    }

    public void wi(boolean z) {
        this.mim = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.mfy = aVar;
    }

    public SmallTailInfo dts() {
        return this.mih;
    }

    public boolean dtt() {
        return this.mif;
    }

    public ConcurrentHashMap<String, ImageUrlData> dtu() {
        return this.mik;
    }

    public ArrayList<String> dtv() {
        return this.mij;
    }

    public boolean dtw() {
        return this.mil;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.kVs;
    }

    public AttentionHostData dtx() {
        if (this.mie == null) {
            this.mie = new AttentionHostData();
            if (this.mfv != null && this.mfv.bln() != null && this.mfv.bln().bnQ() != null) {
                this.mie.parserWithMetaData(this.mfv.bln().bnQ());
            }
        }
        return this.mie;
    }

    public int dty() {
        return this.pageFromType;
    }

    public String doz() {
        return this.mhV;
    }

    public boolean dtz() {
        return this.mhW;
    }

    public int bKy() {
        return this.gey;
    }

    public int getIsManager() {
        return this.isManager;
    }

    public int dtA() {
        return this.mip;
    }

    public int dtB() {
        return this.mio;
    }

    public String bKB() {
        return this.gez;
    }

    public int bKC() {
        return this.userLevel;
    }

    public boolean dtC() {
        return this.miq;
    }
}
