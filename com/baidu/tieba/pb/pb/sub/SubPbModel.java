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
    private TbPageContext<?> eWx;
    private int fVT;
    private boolean fnP;
    private AntiData fsl;
    private int ggb;
    private String ggc;
    private com.baidu.tieba.tbadkCore.d.b iNv;
    private boolean isLoading;
    private int isManager;
    private String kXu;
    private boolean lNW;
    private PbFakeFloorModel lTf;
    private int mOffset;
    private PbFakeFloorModel.a mhA;
    private com.baidu.adp.framework.listener.a mhB;
    private q mhx;
    private String mjW;
    private String mjX;
    private String mjY;
    private String mjZ;
    private boolean mka;
    private String mkb;
    private boolean mkc;
    private String mkd;
    private a mke;
    private int mkf;
    private ArrayList<IconData> mkg;
    private AttentionHostData mkh;
    private boolean mki;
    private ArrayList<q> mkj;
    private SmallTailInfo mkk;
    private boolean mkl;
    private ArrayList<String> mkm;
    private ConcurrentHashMap<String, ImageUrlData> mkn;
    private boolean mko;
    private boolean mkp;
    private int mkq;
    private int mkr;
    private boolean mks;
    private SubPbRequestMessage mkt;
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
            this.mjW = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.kXu = intent.getStringExtra("from_forum_id");
            this.mkb = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.fnP = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.mjX = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.mkc = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.mjY = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.mkk = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.mkk != null) {
                this.mkk.updateShowInfo();
            }
            this.fsl = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.mkg = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.mki = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.mkn = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.mkn.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.mkm = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.mko = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.mjZ = intent.getStringExtra("high_light_post_id");
            this.mka = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
            this.ggb = intent.getIntExtra(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = intent.getIntExtra(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.mkq = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
            this.mkr = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
            this.ggc = intent.getStringExtra(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
            this.userLevel = intent.getIntExtra(SubPbActivityConfig.KEY_USER_LEVEL, 0);
            this.mks = intent.getBooleanExtra(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.mjW = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.kXu = bundle.getString("from_forum_id");
            this.mkb = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.fnP = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.mjX = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.mkc = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.mjY = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.mkk = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.mkk != null) {
                this.mkk.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.fsl = new AntiData();
                this.fsl.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!y.isEmpty(stringArrayList)) {
                this.mkg = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.mkg.add(iconData);
                    }
                }
            }
            this.mki = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.mjZ = bundle.getString("high_light_post_id");
            this.mka = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
            this.ggb = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.ggb = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
            this.isManager = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
            this.mkq = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
            this.mkr = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
            this.ggc = bundle.getString(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
            this.userLevel = bundle.getInt(SubPbActivityConfig.KEY_USER_LEVEL, 0);
            this.mks = bundle.getBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
        }
    }

    public void aD(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.mjW);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fnP);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.mjX);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.mjY);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.mkc);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.userIdentity);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.mkk));
            if (this.fsl != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.fsl.toJsonString());
            }
            if (!y.isEmpty(this.mkg)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.mkg.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.kXu);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.mkb);
            bundle.putString("high_light_post_id", this.mjZ);
            bundle.putBoolean("high_light_post_id", this.mka);
            bundle.putBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, this.mks);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fVT = 0;
        this.mjW = null;
        this.postID = null;
        this.stType = null;
        this.fnP = false;
        this.mjX = null;
        this.mjY = null;
        this.mjZ = null;
        this.mka = false;
        this.pageFromType = 0;
        this.mkc = false;
        this.lNW = false;
        this.userIdentity = 0;
        this.mkd = null;
        this.eWx = null;
        this.mhx = null;
        this.mke = null;
        this.mkf = 0;
        this.mki = false;
        this.mkj = null;
        this.isLoading = false;
        this.iNv = null;
        this.mko = true;
        this.mOffset = 0;
        this.lTf = null;
        this.mhA = null;
        this.mkp = false;
        this.mhB = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.eWx.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.mkj.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.mkj.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    long j4 = j3;
                    if (SubPbModel.this.mkj != null && SubPbModel.this.mkj.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.mkj.size() - 1; size >= 0; size--) {
                                q qVar2 = (q) SubPbModel.this.mkj.get(size);
                                if (SubPbModel.this.mkl) {
                                    SubPbModel.this.mhx.c(qVar2, true);
                                } else {
                                    SubPbModel.this.mhx.b(qVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.mkj.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.iNv == null) {
                        SubPbModel.this.iNv = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.iNv != null) {
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
                            SubPbModel.this.iNv.a(z, true, error, errorString, i, j2, j4);
                            SubPbModel.this.iNv = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.iNv = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.mke != null) {
                                SubPbModel.this.mke.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                qVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                qVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (qVar.dmm().errorno.intValue() != 0) {
                                if (SubPbModel.this.mke != null) {
                                    SubPbModel.this.mke.a(false, qVar.lNX.errorno.intValue(), qVar.lNX.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (qVar.blp() != null && qVar.blp().bnS() != null) {
                                qVar.blp().bnS().getUserId();
                                if (y.isEmpty(qVar.dmh().bnS().getIconInfo()) && SubPbModel.this.mkg != null) {
                                    qVar.dmh().bnS().setIconInfo(SubPbModel.this.mkg);
                                }
                            }
                            if (qVar.dmh() != null) {
                                SubPbModel.this.postID = qVar.dmh().getId();
                            }
                            if (qVar.blp() != null) {
                                SubPbModel.this.mjW = qVar.blp().getId();
                                SubPbModel.this.lNW = qVar.bkb();
                                SubPbModel.this.mkd = qVar.blp().boa();
                            }
                            if (SubPbModel.this.mkd != null && SubPbModel.this.postID != null && SubPbModel.this.mkd.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.lNW = true;
                            }
                            if (SubPbModel.this.mkl) {
                                SubPbModel.this.f(qVar);
                            } else {
                                SubPbModel.this.e(qVar);
                            }
                            if (SubPbModel.this.mke != null) {
                                SubPbModel.this.mke.a(SubPbModel.this.dtq(), error, errorString, SubPbModel.this.mhx);
                            }
                        }
                    }
                }
            }
        };
        this.eWx = tbPageContext;
        this.mkj = new ArrayList<>();
        this.mhx = new q();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.mhB);
        registerListener(this.mhB);
    }

    public String doJ() {
        return this.mjW;
    }

    public String doK() {
        return (StringUtils.isNull(this.mjW) || "0".equals(this.mjW)) ? this.oriUgcNid : this.mjW;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bBM() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public q dtp() {
        return this.mhx;
    }

    public AntiData cBF() {
        return this.fsl;
    }

    public boolean dtq() {
        return (this.mhx == null || this.mhx.dmh() == null) ? false : true;
    }

    public void a(a aVar) {
        this.mke = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.mjW);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.mjW);
        markData.setFloor(postData.dNO());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.mhB);
        if (this.lTf != null) {
            this.lTf.unRegisterListener();
        }
        cwU();
    }

    private void cwU() {
        if (this.iNv != null) {
            this.iNv.destory();
            this.iNv = null;
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

    public void Qf(String str) {
        if (!TextUtils.isEmpty(str) && this.mhx != null && this.mhx.dmq() != null) {
            ArrayList<PostData> dmq = this.mhx.dmq();
            int size = dmq.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(dmq.get(i).getId())) {
                    dmq.remove(i);
                    this.mkf++;
                    this.mhx.setTotalCount(this.mhx.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int dtr() {
        int bJO = this.mhx.bJO();
        if (bJO == 0) {
            return bJO + 1;
        }
        if (this.fVT == 0) {
            return bJO + 1;
        }
        if (this.fVT == 2 && this.mhx.dmq().size() != 0 && this.mhx.dmq().size() % this.mhx.getPageSize() == 0) {
            return bJO + 1;
        }
        if (this.fVT == 3 && this.mkl) {
            return this.mhx.dmo() - 1;
        }
        if (this.fVT == 3 && bJO > 0) {
            return this.mhx.dmn() - 1;
        }
        return bJO;
    }

    private SubPbRequestMessage dsw() {
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
        if (1 != this.fVT) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else if (!au.isEmpty(this.oriUgcNid)) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
            j2 = com.baidu.adp.lib.f.b.toLong(this.mjY, 0L);
        } else if (!TextUtils.isEmpty(this.mjY)) {
            j2 = com.baidu.adp.lib.f.b.toLong(this.mjY, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        }
        if (num == null) {
            intValue = dtr();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.mkl && this.fVT == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.eWx.getPageActivity(), Long.parseLong(this.mjW), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.kXu, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return Gt(0);
    }

    public boolean dts() {
        return Gt(2);
    }

    public void dtt() {
        int pageSize;
        if (this.mkf > 0 && this.mhx != null && (pageSize = this.mhx.getPageSize()) > 0) {
            int bJO = this.mhx.bJO();
            for (int i = (((this.mkf + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.mkt = u(Integer.valueOf(bJO - i));
                this.mkt.setTreatDelPage(true);
                sendMessage(this.mkt);
            }
        }
        this.mkf = 0;
    }

    public boolean dtu() {
        return Gt(1);
    }

    public boolean dtv() {
        return Gt(3);
    }

    public boolean Gt(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.mjW == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        dtt();
        this.fVT = i;
        this.mkt = dsw();
        sendMessage(this.mkt);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(q qVar) {
        ArrayList<PostData> dmq = qVar.dmq();
        if (dmq == null || dmq.size() == 0) {
            qVar.setCurrentPage(this.mhx.bJO());
        }
        if (this.fVT == 1) {
            this.mhx = qVar;
        } else if (this.fVT == 2) {
            this.mhx.b(qVar, true);
        } else if (this.fVT == 3) {
            this.mhx.a(qVar, false);
        } else {
            this.mhx.b(qVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(q qVar) {
        if (this.fVT == 1) {
            this.mhx = qVar;
            this.mhx.dmp();
        } else if (this.fVT == 2) {
            this.mhx.c(qVar, true);
        } else if (this.fVT == 3) {
            this.mhx.d(qVar, false);
        } else {
            this.mhx.a(qVar);
        }
    }

    public boolean dsP() {
        return this.fnP;
    }

    public boolean dtw() {
        return this.lNW;
    }

    public boolean dtx() {
        return "hot_topic".equals(getStType());
    }

    public void wh(boolean z) {
        this.lNW = z;
    }

    public int dlE() {
        return this.userIdentity;
    }

    public String dty() {
        return this.mkd;
    }

    public void Qg(String str) {
        this.mkd = str;
    }

    public String dtz() {
        return this.mjY;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData CY(String str) {
        if (this.mhx == null || this.mhx.bCn() == null || this.mhx.blp() == null || this.mhx.dmh() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.mhx.bCn().getName());
        writeData.setForumId(this.mhx.bCn().getId());
        writeData.setFromForumId(this.mkb);
        writeData.setFloor(this.mhx.dmh().getId());
        writeData.setType(2);
        writeData.setThreadId(this.mhx.blp().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bBL() {
        dts();
        return true;
    }

    public boolean dtA() {
        return this.mkp;
    }

    public void wi(boolean z) {
        this.mkp = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.mhA = aVar;
    }

    public SmallTailInfo dtB() {
        return this.mkk;
    }

    public boolean dtC() {
        return this.mki;
    }

    public ConcurrentHashMap<String, ImageUrlData> dtD() {
        return this.mkn;
    }

    public ArrayList<String> dtE() {
        return this.mkm;
    }

    public boolean dtF() {
        return this.mko;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.kXu;
    }

    public AttentionHostData dtG() {
        if (this.mkh == null) {
            this.mkh = new AttentionHostData();
            if (this.mhx != null && this.mhx.blp() != null && this.mhx.blp().bnS() != null) {
                this.mkh.parserWithMetaData(this.mhx.blp().bnS());
            }
        }
        return this.mkh;
    }

    public int dtH() {
        return this.pageFromType;
    }

    public String doI() {
        return this.mjZ;
    }

    public boolean dtI() {
        return this.mka;
    }

    public int bKC() {
        return this.ggb;
    }

    public int getIsManager() {
        return this.isManager;
    }

    public int dtJ() {
        return this.mkr;
    }

    public int dtK() {
        return this.mkq;
    }

    public String bKF() {
        return this.ggc;
    }

    public int bKG() {
        return this.userLevel;
    }

    public boolean dtL() {
        return this.mks;
    }
}
