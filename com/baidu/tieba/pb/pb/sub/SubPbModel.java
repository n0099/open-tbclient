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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes2.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private TbPageContext<?> eXu;
    private int fWL;
    private boolean foH;
    private AntiData ftd;
    private int ggM;
    private String ggN;
    private com.baidu.tieba.tbadkCore.d.b iKw;
    private boolean isLoading;
    private int isManager;
    private String kRG;
    private boolean lHv;
    private PbFakeFloorModel lMy;
    private int mOffset;
    private p maI;
    private PbFakeFloorModel.a maL;
    private com.baidu.adp.framework.listener.a maM;
    private int mdA;
    private SubPbRequestMessage mdB;
    private String mdf;
    private String mdg;
    private String mdh;
    private String mdi;
    private boolean mdj;
    private String mdk;
    private boolean mdl;
    private String mdm;
    private a mdn;
    private int mdo;
    private ArrayList<IconData> mdp;
    private AttentionHostData mdq;
    private boolean mdr;
    private ArrayList<p> mds;
    private SmallTailInfo mdt;
    private boolean mdu;
    private ArrayList<String> mdv;
    private ConcurrentHashMap<String, ImageUrlData> mdw;
    private boolean mdx;
    private boolean mdy;
    private int mdz;
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
        void a(boolean z, int i, String str, p pVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.mdf = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.kRG = intent.getStringExtra("from_forum_id");
            this.mdk = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.foH = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.mdg = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.mdl = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.mdh = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.mdt = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.mdt != null) {
                this.mdt.updateShowInfo();
            }
            this.ftd = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.mdp = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.mdr = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.mdw = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.mdw.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.mdv = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.mdx = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.mdi = intent.getStringExtra("high_light_post_id");
            this.mdj = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
            this.ggM = intent.getIntExtra(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = intent.getIntExtra(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.mdz = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
            this.mdA = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
            this.ggN = intent.getStringExtra(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
            this.userLevel = intent.getIntExtra(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.mdf = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.kRG = bundle.getString("from_forum_id");
            this.mdk = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.foH = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.mdg = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.mdl = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.mdh = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.mdt = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.mdt != null) {
                this.mdt.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.ftd = new AntiData();
                this.ftd.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!x.isEmpty(stringArrayList)) {
                this.mdp = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.mdp.add(iconData);
                    }
                }
            }
            this.mdr = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.mdi = bundle.getString("high_light_post_id");
            this.mdj = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
            this.ggM = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.ggM = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.mdz = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
            this.mdA = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
            this.ggN = bundle.getString(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
            this.userLevel = bundle.getInt(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        }
    }

    public void aD(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.mdf);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.foH);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.mdg);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.mdh);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.mdl);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.userIdentity);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.mdt));
            if (this.ftd != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.ftd.toJsonString());
            }
            if (!x.isEmpty(this.mdp)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.mdp.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.kRG);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.mdk);
            bundle.putString("high_light_post_id", this.mdi);
            bundle.putBoolean("high_light_post_id", this.mdj);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fWL = 0;
        this.mdf = null;
        this.postID = null;
        this.stType = null;
        this.foH = false;
        this.mdg = null;
        this.mdh = null;
        this.mdi = null;
        this.mdj = false;
        this.pageFromType = 0;
        this.mdl = false;
        this.lHv = false;
        this.userIdentity = 0;
        this.mdm = null;
        this.eXu = null;
        this.maI = null;
        this.mdn = null;
        this.mdo = 0;
        this.mdr = false;
        this.mds = null;
        this.isLoading = false;
        this.iKw = null;
        this.mdx = true;
        this.mOffset = 0;
        this.lMy = null;
        this.maL = null;
        this.mdy = false;
        this.maM = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                boolean z;
                p pVar;
                long j2;
                long j3 = 0;
                if (SubPbModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    SubPbModel.this.isLoading = false;
                    if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                        SubPbModel.this.eXu.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.mds.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.mds.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    long j4 = j3;
                    if (SubPbModel.this.mds != null && SubPbModel.this.mds.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.mds.size() - 1; size >= 0; size--) {
                                p pVar2 = (p) SubPbModel.this.mds.get(size);
                                if (SubPbModel.this.mdu) {
                                    SubPbModel.this.maI.c(pVar2, true);
                                } else {
                                    SubPbModel.this.maI.b(pVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.mds.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.iKw == null) {
                        SubPbModel.this.iKw = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.iKw != null) {
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
                            SubPbModel.this.iKw.a(z, true, error, errorString, i, j2, j4);
                            SubPbModel.this.iKw = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.iKw = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.mdn != null) {
                                SubPbModel.this.mdn.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                pVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                pVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (pVar.dnC().errorno.intValue() != 0) {
                                if (SubPbModel.this.mdn != null) {
                                    SubPbModel.this.mdn.a(false, pVar.lHw.errorno.intValue(), pVar.lHw.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (pVar.boP() != null && pVar.boP().brr() != null) {
                                pVar.boP().brr().getUserId();
                                if (x.isEmpty(pVar.dny().brr().getIconInfo()) && SubPbModel.this.mdp != null) {
                                    pVar.dny().brr().setIconInfo(SubPbModel.this.mdp);
                                }
                            }
                            if (pVar.dny() != null) {
                                SubPbModel.this.postID = pVar.dny().getId();
                            }
                            if (pVar.boP() != null) {
                                SubPbModel.this.mdf = pVar.boP().getId();
                                SubPbModel.this.lHv = pVar.bny();
                                SubPbModel.this.mdm = pVar.boP().brz();
                            }
                            if (SubPbModel.this.mdm != null && SubPbModel.this.postID != null && SubPbModel.this.mdm.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.lHv = true;
                            }
                            if (SubPbModel.this.mdu) {
                                SubPbModel.this.f(pVar);
                            } else {
                                SubPbModel.this.e(pVar);
                            }
                            if (SubPbModel.this.mdn != null) {
                                SubPbModel.this.mdn.a(SubPbModel.this.duE(), error, errorString, SubPbModel.this.maI);
                            }
                        }
                    }
                }
            }
        };
        this.eXu = tbPageContext;
        this.mds = new ArrayList<>();
        this.maI = new p();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.maM);
        registerListener(this.maM);
    }

    public String dpX() {
        return this.mdf;
    }

    public String dpY() {
        return (StringUtils.isNull(this.mdf) || "0".equals(this.mdf)) ? this.oriUgcNid : this.mdf;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bFl() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public p duD() {
        return this.maI;
    }

    public AntiData cDZ() {
        return this.ftd;
    }

    public boolean duE() {
        return (this.maI == null || this.maI.dny() == null) ? false : true;
    }

    public void a(a aVar) {
        this.mdn = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.mdf);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.mdf);
        markData.setFloor(postData.dPe());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.maM);
        if (this.lMy != null) {
            this.lMy.unRegisterListener();
        }
        czn();
    }

    private void czn() {
        if (this.iKw != null) {
            this.iKw.destory();
            this.iKw = null;
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

    public void Qo(String str) {
        if (!TextUtils.isEmpty(str) && this.maI != null && this.maI.dnG() != null) {
            ArrayList<PostData> dnG = this.maI.dnG();
            int size = dnG.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(dnG.get(i).getId())) {
                    dnG.remove(i);
                    this.mdo++;
                    this.maI.setTotalCount(this.maI.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int duF() {
        int bNd = this.maI.bNd();
        if (bNd == 0) {
            return bNd + 1;
        }
        if (this.fWL == 0) {
            return bNd + 1;
        }
        if (this.fWL == 2 && this.maI.dnG().size() != 0 && this.maI.dnG().size() % this.maI.getPageSize() == 0) {
            return bNd + 1;
        }
        if (this.fWL == 3 && this.mdu) {
            return this.maI.dnE() - 1;
        }
        if (this.fWL == 3 && bNd > 0) {
            return this.maI.dnD() - 1;
        }
        return bNd;
    }

    private SubPbRequestMessage dtK() {
        this.isLoading = true;
        return t(null);
    }

    private SubPbRequestMessage t(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.fWL) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else if (!at.isEmpty(this.oriUgcNid)) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
            j2 = com.baidu.adp.lib.f.b.toLong(this.mdh, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.mdh, 0L);
        }
        if (num == null) {
            intValue = duF();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.mdu && this.fWL == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.eXu.getPageActivity(), Long.parseLong(this.mdf), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.kRG, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return HD(0);
    }

    public boolean duG() {
        return HD(2);
    }

    public void duH() {
        int pageSize;
        if (this.mdo > 0 && this.maI != null && (pageSize = this.maI.getPageSize()) > 0) {
            int bNd = this.maI.bNd();
            for (int i = (((this.mdo + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.mdB = t(Integer.valueOf(bNd - i));
                this.mdB.setTreatDelPage(true);
                sendMessage(this.mdB);
            }
        }
        this.mdo = 0;
    }

    public boolean duI() {
        return HD(1);
    }

    public boolean duJ() {
        return HD(3);
    }

    public boolean HD(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.mdf == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        duH();
        this.fWL = i;
        this.mdB = dtK();
        sendMessage(this.mdB);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        ArrayList<PostData> dnG = pVar.dnG();
        if (dnG == null || dnG.size() == 0) {
            pVar.setCurrentPage(this.maI.bNd());
        }
        if (this.fWL == 1) {
            this.maI = pVar;
        } else if (this.fWL == 2) {
            this.maI.b(pVar, true);
        } else if (this.fWL == 3) {
            this.maI.a(pVar, false);
        } else {
            this.maI.b(pVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(p pVar) {
        if (this.fWL == 1) {
            this.maI = pVar;
            this.maI.dnF();
        } else if (this.fWL == 2) {
            this.maI.c(pVar, true);
        } else if (this.fWL == 3) {
            this.maI.d(pVar, false);
        } else {
            this.maI.a(pVar);
        }
    }

    public boolean dud() {
        return this.foH;
    }

    public boolean duK() {
        return this.lHv;
    }

    public boolean duL() {
        return "hot_topic".equals(getStType());
    }

    public void vV(boolean z) {
        this.lHv = z;
    }

    public int dmU() {
        return this.userIdentity;
    }

    public String duM() {
        return this.mdm;
    }

    public void Qp(String str) {
        this.mdm = str;
    }

    public String duN() {
        return this.mdh;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData DN(String str) {
        if (this.maI == null || this.maI.bFL() == null || this.maI.boP() == null || this.maI.dny() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.maI.bFL().getName());
        writeData.setForumId(this.maI.bFL().getId());
        writeData.setFromForumId(this.mdk);
        writeData.setFloor(this.maI.dny().getId());
        writeData.setType(2);
        writeData.setThreadId(this.maI.boP().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bFk() {
        duG();
        return true;
    }

    public boolean duO() {
        return this.mdy;
    }

    public void vW(boolean z) {
        this.mdy = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.maL = aVar;
    }

    public SmallTailInfo duP() {
        return this.mdt;
    }

    public boolean duQ() {
        return this.mdr;
    }

    public ConcurrentHashMap<String, ImageUrlData> duR() {
        return this.mdw;
    }

    public ArrayList<String> duS() {
        return this.mdv;
    }

    public boolean duT() {
        return this.mdx;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.kRG;
    }

    public AttentionHostData duU() {
        if (this.mdq == null) {
            this.mdq = new AttentionHostData();
            if (this.maI != null && this.maI.boP() != null && this.maI.boP().brr() != null) {
                this.mdq.parserWithMetaData(this.maI.boP().brr());
            }
        }
        return this.mdq;
    }

    public int duV() {
        return this.pageFromType;
    }

    public String dpW() {
        return this.mdi;
    }

    public boolean duW() {
        return this.mdj;
    }

    public int bNR() {
        return this.ggM;
    }

    public int getIsManager() {
        return this.isManager;
    }

    public int duX() {
        return this.mdA;
    }

    public int duY() {
        return this.mdz;
    }

    public String bNU() {
        return this.ggN;
    }

    public int bNV() {
        return this.userLevel;
    }
}
