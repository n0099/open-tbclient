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
/* loaded from: classes7.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private TbPageContext<?> cRe;
    private AntiData dhW;
    private com.baidu.tieba.tbadkCore.d.b fTW;
    private boolean iAV;
    private PbFakeFloorModel iFs;
    private m iSh;
    private PbFakeFloorModel.a iSk;
    private com.baidu.adp.framework.listener.a iSl;
    private String iUC;
    private boolean iUD;
    private String iUE;
    private String iUF;
    private String iUG;
    private String iUH;
    private String iUI;
    private boolean iUJ;
    private String iUK;
    private a iUL;
    private int iUM;
    private ArrayList<IconData> iUN;
    private AttentionHostData iUO;
    private boolean iUP;
    private ArrayList<m> iUQ;
    private SmallTailInfo iUR;
    private boolean iUS;
    private ArrayList<String> iUT;
    private ConcurrentHashMap<String, ImageUrlData> iUU;
    private boolean iUV;
    private boolean iUW;
    private SubPbRequestMessage iUX;
    private boolean isLoading;
    private int izU;
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

    /* loaded from: classes7.dex */
    public interface a {
        void a(boolean z, int i, String str, m mVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.iUC = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.iUH = intent.getStringExtra("from_forum_id");
            this.iUI = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.iUD = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.iUE = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.iUJ = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.iUF = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.izU = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.iUR = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.iUR != null) {
                this.iUR.updateShowInfo();
            }
            this.dhW = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.iUN = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.iUP = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.iUU = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.iUU.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.iUT = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.iUV = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.iUG = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.iUC = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.iUH = bundle.getString("from_forum_id");
            this.iUI = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.iUD = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.iUE = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.iUJ = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.iUF = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.izU = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.iUR = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.iUR != null) {
                this.iUR.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.dhW = new AntiData();
                this.dhW.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.isEmpty(stringArrayList)) {
                this.iUN = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.iUN.add(iconData);
                    }
                }
            }
            this.iUP = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.iUG = bundle.getString("high_light_post_id");
        }
    }

    public void au(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.iUC);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.iUD);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.iUE);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.iUF);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.iUJ);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.izU);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.iUR));
            if (this.dhW != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.dhW.toJsonString());
            }
            if (!v.isEmpty(this.iUN)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.iUN.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.iUH);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.iUI);
            bundle.putString("high_light_post_id", this.iUG);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.iUC = null;
        this.postID = null;
        this.stType = null;
        this.iUD = false;
        this.iUE = null;
        this.iUF = null;
        this.iUG = null;
        this.pageFromType = 0;
        this.iUJ = false;
        this.iAV = false;
        this.izU = 0;
        this.iUK = null;
        this.cRe = null;
        this.iSh = null;
        this.iUL = null;
        this.iUM = 0;
        this.iUP = false;
        this.iUQ = null;
        this.isLoading = false;
        this.fTW = null;
        this.iUV = true;
        this.mOffset = 0;
        this.iFs = null;
        this.iSk = null;
        this.iUW = false;
        this.iSl = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.cRe.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.iUQ.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.iUQ.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.iUQ != null && SubPbModel.this.iUQ.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.iUQ.size() - 1; size >= 0; size--) {
                                m mVar2 = (m) SubPbModel.this.iUQ.get(size);
                                if (SubPbModel.this.iUS) {
                                    SubPbModel.this.iSh.c(mVar2, true);
                                } else {
                                    SubPbModel.this.iSh.b(mVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.iUQ.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.fTW == null) {
                        SubPbModel.this.fTW = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.fTW != null) {
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
                            SubPbModel.this.fTW.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.fTW = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.fTW = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.iUL != null) {
                                SubPbModel.this.iUL.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                mVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (mVar.cjE().errorno.intValue() != 0) {
                                if (SubPbModel.this.iUL != null) {
                                    SubPbModel.this.iUL.a(false, mVar.iAW.errorno.intValue(), mVar.iAW.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (mVar.axQ() != null && mVar.axQ().azX() != null) {
                                mVar.axQ().azX().getUserId();
                                if (v.isEmpty(mVar.cjF().azX().getIconInfo()) && SubPbModel.this.iUN != null) {
                                    mVar.cjF().azX().setIconInfo(SubPbModel.this.iUN);
                                }
                            }
                            if (mVar.cjF() != null) {
                                SubPbModel.this.postID = mVar.cjF().getId();
                            }
                            if (mVar.axQ() != null) {
                                SubPbModel.this.iUC = mVar.axQ().getId();
                                SubPbModel.this.iAV = mVar.aww();
                                SubPbModel.this.iUK = mVar.axQ().aAg();
                            }
                            if (SubPbModel.this.iUK != null && SubPbModel.this.postID != null && SubPbModel.this.iUK.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.iAV = true;
                            }
                            if (SubPbModel.this.iUS) {
                                SubPbModel.this.f(mVar);
                            } else {
                                SubPbModel.this.e(mVar);
                            }
                            if (SubPbModel.this.iUL != null) {
                                SubPbModel.this.iUL.a(SubPbModel.this.cqv(), error, errorString, SubPbModel.this.iSh);
                            }
                        }
                    }
                }
            }
        };
        this.cRe = tbPageContext;
        this.iUQ = new ArrayList<>();
        this.iSh = new m();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.iSl);
        registerListener(this.iSl);
    }

    public String cmc() {
        return this.iUC;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aMq() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public m cqu() {
        return this.iSh;
    }

    public AntiData bBu() {
        return this.dhW;
    }

    public boolean cqv() {
        return (this.iSh == null || this.iSh.cjF() == null) ? false : true;
    }

    public void a(a aVar) {
        this.iUL = aVar;
    }

    public MarkData l(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iUC);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.iUC);
        markData.setFloor(postData.cJx());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.iSl);
        if (this.iFs != null) {
            this.iFs.unRegisterListener();
        }
        bxm();
    }

    private void bxm() {
        if (this.fTW != null) {
            this.fTW.destory();
            this.fTW = null;
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

    public void Gd(String str) {
        if (!TextUtils.isEmpty(str) && this.iSh != null && this.iSh.cjJ() != null) {
            ArrayList<PostData> cjJ = this.iSh.cjJ();
            int size = cjJ.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(cjJ.get(i).getId())) {
                    cjJ.remove(i);
                    this.iUM++;
                    this.iSh.setTotalCount(this.iSh.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int cqw() {
        int aTs = this.iSh.aTs();
        if (aTs == 0) {
            return aTs + 1;
        }
        if (this.mLoadType == 0) {
            return aTs + 1;
        }
        if (this.mLoadType == 2 && this.iSh.cjJ().size() != 0 && this.iSh.cjJ().size() % this.iSh.getPageSize() == 0) {
            return aTs + 1;
        }
        if (this.mLoadType == 3 && this.iUS) {
            return this.iSh.cjH() - 1;
        }
        if (this.mLoadType == 3 && aTs > 0) {
            return this.iSh.cjG() - 1;
        }
        return aTs;
    }

    private SubPbRequestMessage cpC() {
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
            intValue = cqw();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.iUS && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.cRe.getPageActivity(), Long.parseLong(this.iUC), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.iUH, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return zk(0);
    }

    public boolean cqx() {
        return zk(2);
    }

    public void cqy() {
        int pageSize;
        if (this.iUM > 0 && this.iSh != null && (pageSize = this.iSh.getPageSize()) > 0) {
            int aTs = this.iSh.aTs();
            for (int i = (((this.iUM + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.iUX = o(Integer.valueOf(aTs - i));
                this.iUX.setTreatDelPage(true);
                sendMessage(this.iUX);
            }
        }
        this.iUM = 0;
    }

    public boolean cqz() {
        return zk(1);
    }

    public boolean zk(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.iUC == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        cqy();
        this.mLoadType = i;
        this.iUX = cpC();
        sendMessage(this.iUX);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        ArrayList<PostData> cjJ = mVar.cjJ();
        if (cjJ == null || cjJ.size() == 0) {
            mVar.setCurrentPage(this.iSh.aTs());
        }
        if (this.mLoadType == 1) {
            this.iSh = mVar;
        } else if (this.mLoadType == 2) {
            this.iSh.b(mVar, true);
        } else if (this.mLoadType == 3) {
            this.iSh.a(mVar, false);
        } else {
            this.iSh.b(mVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(m mVar) {
        if (this.mLoadType == 1) {
            this.iSh = mVar;
            this.iSh.cjI();
        } else if (this.mLoadType == 2) {
            this.iSh.c(mVar, true);
        } else if (this.mLoadType == 3) {
            this.iSh.d(mVar, false);
        } else {
            this.iSh.a(mVar);
        }
    }

    public boolean cpV() {
        return this.iUD;
    }

    public boolean cqA() {
        return this.iAV;
    }

    public boolean cqB() {
        return "hot_topic".equals(getStType());
    }

    public void qK(boolean z) {
        this.iAV = z;
    }

    public int cje() {
        return this.izU;
    }

    public String cqC() {
        return this.iUK;
    }

    public void Ge(String str) {
        this.iUK = str;
    }

    public String cqD() {
        return this.iUF;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData uR(String str) {
        if (this.iSh == null || this.iSh.aMO() == null || this.iSh.axQ() == null || this.iSh.cjF() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.iSh.aMO().getName());
        writeData.setForumId(this.iSh.aMO().getId());
        writeData.setFromForumId(this.iUI);
        writeData.setFloor(this.iSh.cjF().getId());
        writeData.setType(2);
        writeData.setThreadId(this.iSh.axQ().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aMp() {
        cqx();
        return true;
    }

    public boolean cqE() {
        return this.iUW;
    }

    public void qL(boolean z) {
        this.iUW = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.iSk = aVar;
    }

    public SmallTailInfo cqF() {
        return this.iUR;
    }

    public boolean cqG() {
        return this.iUP;
    }

    public ConcurrentHashMap<String, ImageUrlData> cqH() {
        return this.iUU;
    }

    public ArrayList<String> cqI() {
        return this.iUT;
    }

    public boolean cqJ() {
        return this.iUV;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.iUH;
    }

    public AttentionHostData cqK() {
        if (this.iUO == null) {
            this.iUO = new AttentionHostData();
            if (this.iSh != null && this.iSh.axQ() != null && this.iSh.axQ().azX() != null) {
                this.iUO.parserWithMetaData(this.iSh.axQ().azX());
            }
        }
        return this.iUO;
    }

    public boolean cmW() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public int cqL() {
        return this.pageFromType;
    }

    public String cmb() {
        return this.iUG;
    }
}
