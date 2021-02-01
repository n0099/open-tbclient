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
    private int get;
    private String geu;
    private com.baidu.tieba.tbadkCore.d.b iLy;
    private boolean isLoading;
    private int isManager;
    private String kVe;
    private boolean lLF;
    private PbFakeFloorModel lQO;
    private int mOffset;
    private q mfg;
    private PbFakeFloorModel.a mfj;
    private com.baidu.adp.framework.listener.a mfk;
    private String mhD;
    private String mhE;
    private String mhF;
    private String mhG;
    private boolean mhH;
    private String mhI;
    private boolean mhJ;
    private String mhK;
    private a mhL;
    private int mhM;
    private ArrayList<IconData> mhN;
    private AttentionHostData mhO;
    private boolean mhP;
    private ArrayList<q> mhQ;
    private SmallTailInfo mhR;
    private boolean mhS;
    private ArrayList<String> mhT;
    private ConcurrentHashMap<String, ImageUrlData> mhU;
    private boolean mhV;
    private boolean mhW;
    private int mhX;
    private int mhY;
    private boolean mhZ;
    private SubPbRequestMessage mia;
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
            this.mhD = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.kVe = intent.getStringExtra("from_forum_id");
            this.mhI = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.fmq = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.mhE = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.mhJ = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.mhF = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.mhR = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.mhR != null) {
                this.mhR.updateShowInfo();
            }
            this.fqK = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.mhN = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.mhP = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.mhU = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.mhU.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.mhT = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.mhV = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.mhG = intent.getStringExtra("high_light_post_id");
            this.mhH = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
            this.get = intent.getIntExtra(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = intent.getIntExtra(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.mhX = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
            this.mhY = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
            this.geu = intent.getStringExtra(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
            this.userLevel = intent.getIntExtra(SubPbActivityConfig.KEY_USER_LEVEL, 0);
            this.mhZ = intent.getBooleanExtra(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.mhD = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.kVe = bundle.getString("from_forum_id");
            this.mhI = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.fmq = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.mhE = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.mhJ = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.mhF = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.mhR = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.mhR != null) {
                this.mhR.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.fqK = new AntiData();
                this.fqK.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!y.isEmpty(stringArrayList)) {
                this.mhN = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.mhN.add(iconData);
                    }
                }
            }
            this.mhP = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.mhG = bundle.getString("high_light_post_id");
            this.mhH = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
            this.get = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.get = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.mhX = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
            this.mhY = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
            this.geu = bundle.getString(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
            this.userLevel = bundle.getInt(SubPbActivityConfig.KEY_USER_LEVEL, 0);
            this.mhZ = bundle.getBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
        }
    }

    public void aD(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.mhD);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fmq);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.mhE);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.mhF);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.mhJ);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.userIdentity);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.mhR));
            if (this.fqK != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.fqK.toJsonString());
            }
            if (!y.isEmpty(this.mhN)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.mhN.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.kVe);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.mhI);
            bundle.putString("high_light_post_id", this.mhG);
            bundle.putBoolean("high_light_post_id", this.mhH);
            bundle.putBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, this.mhZ);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fUt = 0;
        this.mhD = null;
        this.postID = null;
        this.stType = null;
        this.fmq = false;
        this.mhE = null;
        this.mhF = null;
        this.mhG = null;
        this.mhH = false;
        this.pageFromType = 0;
        this.mhJ = false;
        this.lLF = false;
        this.userIdentity = 0;
        this.mhK = null;
        this.eUY = null;
        this.mfg = null;
        this.mhL = null;
        this.mhM = 0;
        this.mhP = false;
        this.mhQ = null;
        this.isLoading = false;
        this.iLy = null;
        this.mhV = true;
        this.mOffset = 0;
        this.lQO = null;
        this.mfj = null;
        this.mhW = false;
        this.mfk = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.mhQ.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.mhQ.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    long j4 = j3;
                    if (SubPbModel.this.mhQ != null && SubPbModel.this.mhQ.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.mhQ.size() - 1; size >= 0; size--) {
                                q qVar2 = (q) SubPbModel.this.mhQ.get(size);
                                if (SubPbModel.this.mhS) {
                                    SubPbModel.this.mfg.c(qVar2, true);
                                } else {
                                    SubPbModel.this.mfg.b(qVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.mhQ.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.iLy == null) {
                        SubPbModel.this.iLy = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.iLy != null) {
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
                            SubPbModel.this.iLy.a(z, true, error, errorString, i, j2, j4);
                            SubPbModel.this.iLy = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.iLy = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.mhL != null) {
                                SubPbModel.this.mhL.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                qVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                qVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (qVar.dlW().errorno.intValue() != 0) {
                                if (SubPbModel.this.mhL != null) {
                                    SubPbModel.this.mhL.a(false, qVar.lLG.errorno.intValue(), qVar.lLG.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (qVar.bln() != null && qVar.bln().bnQ() != null) {
                                qVar.bln().bnQ().getUserId();
                                if (y.isEmpty(qVar.dlR().bnQ().getIconInfo()) && SubPbModel.this.mhN != null) {
                                    qVar.dlR().bnQ().setIconInfo(SubPbModel.this.mhN);
                                }
                            }
                            if (qVar.dlR() != null) {
                                SubPbModel.this.postID = qVar.dlR().getId();
                            }
                            if (qVar.bln() != null) {
                                SubPbModel.this.mhD = qVar.bln().getId();
                                SubPbModel.this.lLF = qVar.bjZ();
                                SubPbModel.this.mhK = qVar.bln().bnY();
                            }
                            if (SubPbModel.this.mhK != null && SubPbModel.this.postID != null && SubPbModel.this.mhK.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.lLF = true;
                            }
                            if (SubPbModel.this.mhS) {
                                SubPbModel.this.f(qVar);
                            } else {
                                SubPbModel.this.e(qVar);
                            }
                            if (SubPbModel.this.mhL != null) {
                                SubPbModel.this.mhL.a(SubPbModel.this.dta(), error, errorString, SubPbModel.this.mfg);
                            }
                        }
                    }
                }
            }
        };
        this.eUY = tbPageContext;
        this.mhQ = new ArrayList<>();
        this.mfg = new q();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.mfk);
        registerListener(this.mfk);
    }

    public String dot() {
        return this.mhD;
    }

    public String dou() {
        return (StringUtils.isNull(this.mhD) || "0".equals(this.mhD)) ? this.oriUgcNid : this.mhD;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bBJ() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public q dsZ() {
        return this.mfg;
    }

    public AntiData cBs() {
        return this.fqK;
    }

    public boolean dta() {
        return (this.mfg == null || this.mfg.dlR() == null) ? false : true;
    }

    public void a(a aVar) {
        this.mhL = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.mhD);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.mhD);
        markData.setFloor(postData.dNx());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.mfk);
        if (this.lQO != null) {
            this.lQO.unRegisterListener();
        }
        cwH();
    }

    private void cwH() {
        if (this.iLy != null) {
            this.iLy.destory();
            this.iLy = null;
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

    public void PY(String str) {
        if (!TextUtils.isEmpty(str) && this.mfg != null && this.mfg.dma() != null) {
            ArrayList<PostData> dma = this.mfg.dma();
            int size = dma.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(dma.get(i).getId())) {
                    dma.remove(i);
                    this.mhM++;
                    this.mfg.setTotalCount(this.mfg.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int dtb() {
        int bJF = this.mfg.bJF();
        if (bJF == 0) {
            return bJF + 1;
        }
        if (this.fUt == 0) {
            return bJF + 1;
        }
        if (this.fUt == 2 && this.mfg.dma().size() != 0 && this.mfg.dma().size() % this.mfg.getPageSize() == 0) {
            return bJF + 1;
        }
        if (this.fUt == 3 && this.mhS) {
            return this.mfg.dlY() - 1;
        }
        if (this.fUt == 3 && bJF > 0) {
            return this.mfg.dlX() - 1;
        }
        return bJF;
    }

    private SubPbRequestMessage dsg() {
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
            j2 = com.baidu.adp.lib.f.b.toLong(this.mhF, 0L);
        } else if (!TextUtils.isEmpty(this.mhF)) {
            j2 = com.baidu.adp.lib.f.b.toLong(this.mhF, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        }
        if (num == null) {
            intValue = dtb();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.mhS && this.fUt == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.eUY.getPageActivity(), Long.parseLong(this.mhD), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.kVe, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return Gq(0);
    }

    public boolean dtc() {
        return Gq(2);
    }

    public void dtd() {
        int pageSize;
        if (this.mhM > 0 && this.mfg != null && (pageSize = this.mfg.getPageSize()) > 0) {
            int bJF = this.mfg.bJF();
            for (int i = (((this.mhM + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.mia = u(Integer.valueOf(bJF - i));
                this.mia.setTreatDelPage(true);
                sendMessage(this.mia);
            }
        }
        this.mhM = 0;
    }

    public boolean dte() {
        return Gq(1);
    }

    public boolean dtf() {
        return Gq(3);
    }

    public boolean Gq(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.mhD == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        dtd();
        this.fUt = i;
        this.mia = dsg();
        sendMessage(this.mia);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(q qVar) {
        ArrayList<PostData> dma = qVar.dma();
        if (dma == null || dma.size() == 0) {
            qVar.setCurrentPage(this.mfg.bJF());
        }
        if (this.fUt == 1) {
            this.mfg = qVar;
        } else if (this.fUt == 2) {
            this.mfg.b(qVar, true);
        } else if (this.fUt == 3) {
            this.mfg.a(qVar, false);
        } else {
            this.mfg.b(qVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(q qVar) {
        if (this.fUt == 1) {
            this.mfg = qVar;
            this.mfg.dlZ();
        } else if (this.fUt == 2) {
            this.mfg.c(qVar, true);
        } else if (this.fUt == 3) {
            this.mfg.d(qVar, false);
        } else {
            this.mfg.a(qVar);
        }
    }

    public boolean dsz() {
        return this.fmq;
    }

    public boolean dtg() {
        return this.lLF;
    }

    public boolean dth() {
        return "hot_topic".equals(getStType());
    }

    public void wh(boolean z) {
        this.lLF = z;
    }

    public int dlo() {
        return this.userIdentity;
    }

    public String dti() {
        return this.mhK;
    }

    public void PZ(String str) {
        this.mhK = str;
    }

    public String dtj() {
        return this.mhF;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData CT(String str) {
        if (this.mfg == null || this.mfg.bCk() == null || this.mfg.bln() == null || this.mfg.dlR() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.mfg.bCk().getName());
        writeData.setForumId(this.mfg.bCk().getId());
        writeData.setFromForumId(this.mhI);
        writeData.setFloor(this.mfg.dlR().getId());
        writeData.setType(2);
        writeData.setThreadId(this.mfg.bln().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bBI() {
        dtc();
        return true;
    }

    public boolean dtk() {
        return this.mhW;
    }

    public void wi(boolean z) {
        this.mhW = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.mfj = aVar;
    }

    public SmallTailInfo dtl() {
        return this.mhR;
    }

    public boolean dtm() {
        return this.mhP;
    }

    public ConcurrentHashMap<String, ImageUrlData> dtn() {
        return this.mhU;
    }

    public ArrayList<String> dto() {
        return this.mhT;
    }

    public boolean dtp() {
        return this.mhV;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.kVe;
    }

    public AttentionHostData dtq() {
        if (this.mhO == null) {
            this.mhO = new AttentionHostData();
            if (this.mfg != null && this.mfg.bln() != null && this.mfg.bln().bnQ() != null) {
                this.mhO.parserWithMetaData(this.mfg.bln().bnQ());
            }
        }
        return this.mhO;
    }

    public int dtr() {
        return this.pageFromType;
    }

    public String dos() {
        return this.mhG;
    }

    public boolean dts() {
        return this.mhH;
    }

    public int bKt() {
        return this.get;
    }

    public int getIsManager() {
        return this.isManager;
    }

    public int dtt() {
        return this.mhY;
    }

    public int dtu() {
        return this.mhX;
    }

    public String bKw() {
        return this.geu;
    }

    public int bKx() {
        return this.userLevel;
    }

    public boolean dtv() {
        return this.mhZ;
    }
}
