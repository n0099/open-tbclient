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
    private boolean lHw;
    private PbFakeFloorModel lMz;
    private int mOffset;
    private p maJ;
    private PbFakeFloorModel.a maM;
    private com.baidu.adp.framework.listener.a maN;
    private int mdA;
    private int mdB;
    private SubPbRequestMessage mdC;
    private String mdg;
    private String mdh;
    private String mdi;
    private String mdj;
    private boolean mdk;
    private String mdl;
    private boolean mdm;
    private String mdn;
    private a mdo;
    private int mdp;
    private ArrayList<IconData> mdq;
    private AttentionHostData mdr;
    private boolean mds;
    private ArrayList<p> mdt;
    private SmallTailInfo mdu;
    private boolean mdv;
    private ArrayList<String> mdw;
    private ConcurrentHashMap<String, ImageUrlData> mdx;
    private boolean mdy;
    private boolean mdz;
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
            this.mdg = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.kRG = intent.getStringExtra("from_forum_id");
            this.mdl = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.foH = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.mdh = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.mdm = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.mdi = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.mdu = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.mdu != null) {
                this.mdu.updateShowInfo();
            }
            this.ftd = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.mdq = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.mds = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.mdx = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.mdx.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.mdw = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.mdy = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.mdj = intent.getStringExtra("high_light_post_id");
            this.mdk = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
            this.ggM = intent.getIntExtra(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = intent.getIntExtra(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.mdA = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
            this.mdB = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
            this.ggN = intent.getStringExtra(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
            this.userLevel = intent.getIntExtra(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.mdg = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.kRG = bundle.getString("from_forum_id");
            this.mdl = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.foH = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.mdh = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.mdm = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.mdi = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.mdu = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.mdu != null) {
                this.mdu.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.ftd = new AntiData();
                this.ftd.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!x.isEmpty(stringArrayList)) {
                this.mdq = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.mdq.add(iconData);
                    }
                }
            }
            this.mds = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.mdj = bundle.getString("high_light_post_id");
            this.mdk = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
            this.ggM = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.ggM = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.mdA = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
            this.mdB = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
            this.ggN = bundle.getString(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
            this.userLevel = bundle.getInt(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        }
    }

    public void aD(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.mdg);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.foH);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.mdh);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.mdi);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.mdm);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.userIdentity);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.mdu));
            if (this.ftd != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.ftd.toJsonString());
            }
            if (!x.isEmpty(this.mdq)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.mdq.iterator();
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
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.mdl);
            bundle.putString("high_light_post_id", this.mdj);
            bundle.putBoolean("high_light_post_id", this.mdk);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fWL = 0;
        this.mdg = null;
        this.postID = null;
        this.stType = null;
        this.foH = false;
        this.mdh = null;
        this.mdi = null;
        this.mdj = null;
        this.mdk = false;
        this.pageFromType = 0;
        this.mdm = false;
        this.lHw = false;
        this.userIdentity = 0;
        this.mdn = null;
        this.eXu = null;
        this.maJ = null;
        this.mdo = null;
        this.mdp = 0;
        this.mds = false;
        this.mdt = null;
        this.isLoading = false;
        this.iKw = null;
        this.mdy = true;
        this.mOffset = 0;
        this.lMz = null;
        this.maM = null;
        this.mdz = false;
        this.maN = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.mdt.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.mdt.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    long j4 = j3;
                    if (SubPbModel.this.mdt != null && SubPbModel.this.mdt.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.mdt.size() - 1; size >= 0; size--) {
                                p pVar2 = (p) SubPbModel.this.mdt.get(size);
                                if (SubPbModel.this.mdv) {
                                    SubPbModel.this.maJ.c(pVar2, true);
                                } else {
                                    SubPbModel.this.maJ.b(pVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.mdt.clear();
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
                            if (SubPbModel.this.mdo != null) {
                                SubPbModel.this.mdo.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                pVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                pVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (pVar.dnB().errorno.intValue() != 0) {
                                if (SubPbModel.this.mdo != null) {
                                    SubPbModel.this.mdo.a(false, pVar.lHx.errorno.intValue(), pVar.lHx.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (pVar.boO() != null && pVar.boO().brq() != null) {
                                pVar.boO().brq().getUserId();
                                if (x.isEmpty(pVar.dnx().brq().getIconInfo()) && SubPbModel.this.mdq != null) {
                                    pVar.dnx().brq().setIconInfo(SubPbModel.this.mdq);
                                }
                            }
                            if (pVar.dnx() != null) {
                                SubPbModel.this.postID = pVar.dnx().getId();
                            }
                            if (pVar.boO() != null) {
                                SubPbModel.this.mdg = pVar.boO().getId();
                                SubPbModel.this.lHw = pVar.bnx();
                                SubPbModel.this.mdn = pVar.boO().bry();
                            }
                            if (SubPbModel.this.mdn != null && SubPbModel.this.postID != null && SubPbModel.this.mdn.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.lHw = true;
                            }
                            if (SubPbModel.this.mdv) {
                                SubPbModel.this.f(pVar);
                            } else {
                                SubPbModel.this.e(pVar);
                            }
                            if (SubPbModel.this.mdo != null) {
                                SubPbModel.this.mdo.a(SubPbModel.this.duD(), error, errorString, SubPbModel.this.maJ);
                            }
                        }
                    }
                }
            }
        };
        this.eXu = tbPageContext;
        this.mdt = new ArrayList<>();
        this.maJ = new p();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.maN);
        registerListener(this.maN);
    }

    public String dpW() {
        return this.mdg;
    }

    public String dpX() {
        return (StringUtils.isNull(this.mdg) || "0".equals(this.mdg)) ? this.oriUgcNid : this.mdg;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bFk() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public p duC() {
        return this.maJ;
    }

    public AntiData cDY() {
        return this.ftd;
    }

    public boolean duD() {
        return (this.maJ == null || this.maJ.dnx() == null) ? false : true;
    }

    public void a(a aVar) {
        this.mdo = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.mdg);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.mdg);
        markData.setFloor(postData.dPd());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.maN);
        if (this.lMz != null) {
            this.lMz.unRegisterListener();
        }
        czm();
    }

    private void czm() {
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

    public void Qp(String str) {
        if (!TextUtils.isEmpty(str) && this.maJ != null && this.maJ.dnF() != null) {
            ArrayList<PostData> dnF = this.maJ.dnF();
            int size = dnF.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(dnF.get(i).getId())) {
                    dnF.remove(i);
                    this.mdp++;
                    this.maJ.setTotalCount(this.maJ.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int duE() {
        int bNc = this.maJ.bNc();
        if (bNc == 0) {
            return bNc + 1;
        }
        if (this.fWL == 0) {
            return bNc + 1;
        }
        if (this.fWL == 2 && this.maJ.dnF().size() != 0 && this.maJ.dnF().size() % this.maJ.getPageSize() == 0) {
            return bNc + 1;
        }
        if (this.fWL == 3 && this.mdv) {
            return this.maJ.dnD() - 1;
        }
        if (this.fWL == 3 && bNc > 0) {
            return this.maJ.dnC() - 1;
        }
        return bNc;
    }

    private SubPbRequestMessage dtJ() {
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
            j2 = com.baidu.adp.lib.f.b.toLong(this.mdi, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.mdi, 0L);
        }
        if (num == null) {
            intValue = duE();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.mdv && this.fWL == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.eXu.getPageActivity(), Long.parseLong(this.mdg), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
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

    public boolean duF() {
        return HD(2);
    }

    public void duG() {
        int pageSize;
        if (this.mdp > 0 && this.maJ != null && (pageSize = this.maJ.getPageSize()) > 0) {
            int bNc = this.maJ.bNc();
            for (int i = (((this.mdp + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.mdC = t(Integer.valueOf(bNc - i));
                this.mdC.setTreatDelPage(true);
                sendMessage(this.mdC);
            }
        }
        this.mdp = 0;
    }

    public boolean duH() {
        return HD(1);
    }

    public boolean duI() {
        return HD(3);
    }

    public boolean HD(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.mdg == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        duG();
        this.fWL = i;
        this.mdC = dtJ();
        sendMessage(this.mdC);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        ArrayList<PostData> dnF = pVar.dnF();
        if (dnF == null || dnF.size() == 0) {
            pVar.setCurrentPage(this.maJ.bNc());
        }
        if (this.fWL == 1) {
            this.maJ = pVar;
        } else if (this.fWL == 2) {
            this.maJ.b(pVar, true);
        } else if (this.fWL == 3) {
            this.maJ.a(pVar, false);
        } else {
            this.maJ.b(pVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(p pVar) {
        if (this.fWL == 1) {
            this.maJ = pVar;
            this.maJ.dnE();
        } else if (this.fWL == 2) {
            this.maJ.c(pVar, true);
        } else if (this.fWL == 3) {
            this.maJ.d(pVar, false);
        } else {
            this.maJ.a(pVar);
        }
    }

    public boolean duc() {
        return this.foH;
    }

    public boolean duJ() {
        return this.lHw;
    }

    public boolean duK() {
        return "hot_topic".equals(getStType());
    }

    public void vV(boolean z) {
        this.lHw = z;
    }

    public int dmT() {
        return this.userIdentity;
    }

    public String duL() {
        return this.mdn;
    }

    public void Qq(String str) {
        this.mdn = str;
    }

    public String duM() {
        return this.mdi;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData DO(String str) {
        if (this.maJ == null || this.maJ.bFK() == null || this.maJ.boO() == null || this.maJ.dnx() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.maJ.bFK().getName());
        writeData.setForumId(this.maJ.bFK().getId());
        writeData.setFromForumId(this.mdl);
        writeData.setFloor(this.maJ.dnx().getId());
        writeData.setType(2);
        writeData.setThreadId(this.maJ.boO().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bFj() {
        duF();
        return true;
    }

    public boolean duN() {
        return this.mdz;
    }

    public void vW(boolean z) {
        this.mdz = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.maM = aVar;
    }

    public SmallTailInfo duO() {
        return this.mdu;
    }

    public boolean duP() {
        return this.mds;
    }

    public ConcurrentHashMap<String, ImageUrlData> duQ() {
        return this.mdx;
    }

    public ArrayList<String> duR() {
        return this.mdw;
    }

    public boolean duS() {
        return this.mdy;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.kRG;
    }

    public AttentionHostData duT() {
        if (this.mdr == null) {
            this.mdr = new AttentionHostData();
            if (this.maJ != null && this.maJ.boO() != null && this.maJ.boO().brq() != null) {
                this.mdr.parserWithMetaData(this.maJ.boO().brq());
            }
        }
        return this.mdr;
    }

    public int duU() {
        return this.pageFromType;
    }

    public String dpV() {
        return this.mdj;
    }

    public boolean duV() {
        return this.mdk;
    }

    public int bNQ() {
        return this.ggM;
    }

    public int getIsManager() {
        return this.isManager;
    }

    public int duW() {
        return this.mdB;
    }

    public int duX() {
        return this.mdA;
    }

    public String bNT() {
        return this.ggN;
    }

    public int bNU() {
        return this.userLevel;
    }
}
