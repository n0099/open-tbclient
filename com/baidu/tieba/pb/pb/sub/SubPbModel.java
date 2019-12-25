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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private TbPageContext<?> cQU;
    private AntiData dhK;
    private com.baidu.tieba.tbadkCore.d.b fQM;
    private PbFakeFloorModel iBO;
    private m iOD;
    private PbFakeFloorModel.a iOG;
    private com.baidu.adp.framework.listener.a iOH;
    private String iQY;
    private boolean iQZ;
    private String iRa;
    private String iRb;
    private String iRc;
    private String iRd;
    private String iRe;
    private boolean iRf;
    private String iRg;
    private a iRh;
    private int iRi;
    private ArrayList<IconData> iRj;
    private AttentionHostData iRk;
    private boolean iRl;
    private ArrayList<m> iRm;
    private SmallTailInfo iRn;
    private boolean iRo;
    private ArrayList<String> iRp;
    private ConcurrentHashMap<String, ImageUrlData> iRq;
    private boolean iRr;
    private boolean iRs;
    private SubPbRequestMessage iRt;
    private boolean isLoading;
    private int iwq;
    private boolean ixr;
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

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, int i, String str, m mVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.iQY = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.iRd = intent.getStringExtra("from_forum_id");
            this.iRe = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.iQZ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.iRa = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.iRf = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.iRb = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.iwq = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.iRn = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.iRn != null) {
                this.iRn.updateShowInfo();
            }
            this.dhK = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.iRj = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.iRl = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.iRq = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.iRq.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.iRp = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.iRr = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.iRc = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.iQY = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.iRd = bundle.getString("from_forum_id");
            this.iRe = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.iQZ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.iRa = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.iRf = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.iRb = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.iwq = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.iRn = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.iRn != null) {
                this.iRn.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.dhK = new AntiData();
                this.dhK.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.isEmpty(stringArrayList)) {
                this.iRj = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.iRj.add(iconData);
                    }
                }
            }
            this.iRl = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.iRc = bundle.getString("high_light_post_id");
        }
    }

    public void au(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.iQY);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.iQZ);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.iRa);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.iRb);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.iRf);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.iwq);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.iRn));
            if (this.dhK != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.dhK.toJsonString());
            }
            if (!v.isEmpty(this.iRj)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.iRj.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.iRd);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.iRe);
            bundle.putString("high_light_post_id", this.iRc);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.iQY = null;
        this.postID = null;
        this.stType = null;
        this.iQZ = false;
        this.iRa = null;
        this.iRb = null;
        this.iRc = null;
        this.pageFromType = 0;
        this.iRf = false;
        this.ixr = false;
        this.iwq = 0;
        this.iRg = null;
        this.cQU = null;
        this.iOD = null;
        this.iRh = null;
        this.iRi = 0;
        this.iRl = false;
        this.iRm = null;
        this.isLoading = false;
        this.fQM = null;
        this.iRr = true;
        this.mOffset = 0;
        this.iBO = null;
        this.iOG = null;
        this.iRs = false;
        this.iOH = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                boolean z;
                m mVar;
                long j2;
                long j3;
                long j4 = 0;
                if (SubPbModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    SubPbModel.this.isLoading = false;
                    if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                        SubPbModel.this.cQU.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.iRm.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.iRm.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.iRm != null && SubPbModel.this.iRm.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.iRm.size() - 1; size >= 0; size--) {
                                m mVar2 = (m) SubPbModel.this.iRm.get(size);
                                if (SubPbModel.this.iRo) {
                                    SubPbModel.this.iOD.c(mVar2, true);
                                } else {
                                    SubPbModel.this.iOD.b(mVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.iRm.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.fQM == null) {
                        SubPbModel.this.fQM = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.fQM != null) {
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
                            SubPbModel.this.fQM.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.fQM = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.fQM = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.iRh != null) {
                                SubPbModel.this.iRh.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                mVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (mVar.ciw().errorno.intValue() != 0) {
                                if (SubPbModel.this.iRh != null) {
                                    SubPbModel.this.iRh.a(false, mVar.ixs.errorno.intValue(), mVar.ixs.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (mVar.axx() != null && mVar.axx().azE() != null) {
                                mVar.axx().azE().getUserId();
                                if (v.isEmpty(mVar.cix().azE().getIconInfo()) && SubPbModel.this.iRj != null) {
                                    mVar.cix().azE().setIconInfo(SubPbModel.this.iRj);
                                }
                            }
                            if (mVar.cix() != null) {
                                SubPbModel.this.postID = mVar.cix().getId();
                            }
                            if (mVar.axx() != null) {
                                SubPbModel.this.iQY = mVar.axx().getId();
                                SubPbModel.this.ixr = mVar.awd();
                                SubPbModel.this.iRg = mVar.axx().azN();
                            }
                            if (SubPbModel.this.iRg != null && SubPbModel.this.postID != null && SubPbModel.this.iRg.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.ixr = true;
                            }
                            if (SubPbModel.this.iRo) {
                                SubPbModel.this.f(mVar);
                            } else {
                                SubPbModel.this.e(mVar);
                            }
                            if (SubPbModel.this.iRh != null) {
                                SubPbModel.this.iRh.a(SubPbModel.this.cpo(), error, errorString, SubPbModel.this.iOD);
                            }
                        }
                    }
                }
            }
        };
        this.cQU = tbPageContext;
        this.iRm = new ArrayList<>();
        this.iOD = new m();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.iOH);
        registerListener(this.iOH);
    }

    public String ckU() {
        return this.iQY;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aLX() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public m cpn() {
        return this.iOD;
    }

    public AntiData bAs() {
        return this.dhK;
    }

    public boolean cpo() {
        return (this.iOD == null || this.iOD.cix() == null) ? false : true;
    }

    public void a(a aVar) {
        this.iRh = aVar;
    }

    public MarkData l(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iQY);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.iQY);
        markData.setFloor(postData.cIt());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.iOH);
        if (this.iBO != null) {
            this.iBO.unRegisterListener();
        }
        bwk();
    }

    private void bwk() {
        if (this.fQM != null) {
            this.fQM.destory();
            this.fQM = null;
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

    public void FT(String str) {
        if (!TextUtils.isEmpty(str) && this.iOD != null && this.iOD.ciB() != null) {
            ArrayList<PostData> ciB = this.iOD.ciB();
            int size = ciB.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(ciB.get(i).getId())) {
                    ciB.remove(i);
                    this.iRi++;
                    this.iOD.setTotalCount(this.iOD.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int cpp() {
        int aSY = this.iOD.aSY();
        if (aSY == 0) {
            return aSY + 1;
        }
        if (this.mLoadType == 0) {
            return aSY + 1;
        }
        if (this.mLoadType == 2 && this.iOD.ciB().size() != 0 && this.iOD.ciB().size() % this.iOD.getPageSize() == 0) {
            return aSY + 1;
        }
        if (this.mLoadType == 3 && this.iRo) {
            return this.iOD.ciz() - 1;
        }
        if (this.mLoadType == 3 && aSY > 0) {
            return this.iOD.ciy() - 1;
        }
        return aSY;
    }

    private SubPbRequestMessage cov() {
        this.isLoading = true;
        return o(null);
    }

    private SubPbRequestMessage o(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        }
        if (num == null) {
            intValue = cpp();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.iRo && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.cQU.getPageActivity(), Long.parseLong(this.iQY), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.iRd, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return zf(0);
    }

    public boolean cpq() {
        return zf(2);
    }

    public void cpr() {
        int pageSize;
        if (this.iRi > 0 && this.iOD != null && (pageSize = this.iOD.getPageSize()) > 0) {
            int aSY = this.iOD.aSY();
            for (int i = (((this.iRi + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.iRt = o(Integer.valueOf(aSY - i));
                this.iRt.setTreatDelPage(true);
                sendMessage(this.iRt);
            }
        }
        this.iRi = 0;
    }

    public boolean cps() {
        return zf(1);
    }

    public boolean zf(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.iQY == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        cpr();
        this.mLoadType = i;
        this.iRt = cov();
        sendMessage(this.iRt);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        ArrayList<PostData> ciB = mVar.ciB();
        if (ciB == null || ciB.size() == 0) {
            mVar.setCurrentPage(this.iOD.aSY());
        }
        if (this.mLoadType == 1) {
            this.iOD = mVar;
        } else if (this.mLoadType == 2) {
            this.iOD.b(mVar, true);
        } else if (this.mLoadType == 3) {
            this.iOD.a(mVar, false);
        } else {
            this.iOD.b(mVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(m mVar) {
        if (this.mLoadType == 1) {
            this.iOD = mVar;
            this.iOD.ciA();
        } else if (this.mLoadType == 2) {
            this.iOD.c(mVar, true);
        } else if (this.mLoadType == 3) {
            this.iOD.d(mVar, false);
        } else {
            this.iOD.a(mVar);
        }
    }

    public boolean coO() {
        return this.iQZ;
    }

    public boolean cpt() {
        return this.ixr;
    }

    public boolean cpu() {
        return "hot_topic".equals(getStType());
    }

    public void qy(boolean z) {
        this.ixr = z;
    }

    public int chW() {
        return this.iwq;
    }

    public String cpv() {
        return this.iRg;
    }

    public void FU(String str) {
        this.iRg = str;
    }

    public String cpw() {
        return this.iRb;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData uM(String str) {
        if (this.iOD == null || this.iOD.aMv() == null || this.iOD.axx() == null || this.iOD.cix() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.iOD.aMv().getName());
        writeData.setForumId(this.iOD.aMv().getId());
        writeData.setFromForumId(this.iRe);
        writeData.setFloor(this.iOD.cix().getId());
        writeData.setType(2);
        writeData.setThreadId(this.iOD.axx().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aLW() {
        cpq();
        return true;
    }

    public boolean cpx() {
        return this.iRs;
    }

    public void qz(boolean z) {
        this.iRs = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.iOG = aVar;
    }

    public SmallTailInfo cpy() {
        return this.iRn;
    }

    public boolean cpz() {
        return this.iRl;
    }

    public ConcurrentHashMap<String, ImageUrlData> cpA() {
        return this.iRq;
    }

    public ArrayList<String> cpB() {
        return this.iRp;
    }

    public boolean cpC() {
        return this.iRr;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.iRd;
    }

    public AttentionHostData cpD() {
        if (this.iRk == null) {
            this.iRk = new AttentionHostData();
            if (this.iOD != null && this.iOD.axx() != null && this.iOD.axx().azE() != null) {
                this.iRk.parserWithMetaData(this.iOD.axx().azE());
            }
        }
        return this.iRk;
    }

    public boolean clO() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public int cpE() {
        return this.pageFromType;
    }

    public String ckT() {
        return this.iRc;
    }
}
