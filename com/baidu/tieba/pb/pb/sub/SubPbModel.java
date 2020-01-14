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
    private String iUF;
    private boolean iUG;
    private String iUH;
    private String iUI;
    private String iUJ;
    private String iUK;
    private String iUL;
    private boolean iUM;
    private String iUN;
    private a iUO;
    private int iUP;
    private ArrayList<IconData> iUQ;
    private AttentionHostData iUR;
    private boolean iUS;
    private ArrayList<m> iUT;
    private SmallTailInfo iUU;
    private boolean iUV;
    private ArrayList<String> iUW;
    private ConcurrentHashMap<String, ImageUrlData> iUX;
    private boolean iUY;
    private boolean iUZ;
    private SubPbRequestMessage iVa;
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
            this.iUF = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.iUK = intent.getStringExtra("from_forum_id");
            this.iUL = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.iUG = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.iUH = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.iUM = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.iUI = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.izU = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.iUU = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.iUU != null) {
                this.iUU.updateShowInfo();
            }
            this.dhW = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.iUQ = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.iUS = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.iUX = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.iUX.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.iUW = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.iUY = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.iUJ = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.iUF = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.iUK = bundle.getString("from_forum_id");
            this.iUL = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.iUG = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.iUH = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.iUM = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.iUI = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.izU = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.iUU = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.iUU != null) {
                this.iUU.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.dhW = new AntiData();
                this.dhW.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.isEmpty(stringArrayList)) {
                this.iUQ = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.iUQ.add(iconData);
                    }
                }
            }
            this.iUS = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.iUJ = bundle.getString("high_light_post_id");
        }
    }

    public void au(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.iUF);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.iUG);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.iUH);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.iUI);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.iUM);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.izU);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.iUU));
            if (this.dhW != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.dhW.toJsonString());
            }
            if (!v.isEmpty(this.iUQ)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.iUQ.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.iUK);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.iUL);
            bundle.putString("high_light_post_id", this.iUJ);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.iUF = null;
        this.postID = null;
        this.stType = null;
        this.iUG = false;
        this.iUH = null;
        this.iUI = null;
        this.iUJ = null;
        this.pageFromType = 0;
        this.iUM = false;
        this.iAV = false;
        this.izU = 0;
        this.iUN = null;
        this.cRe = null;
        this.iSh = null;
        this.iUO = null;
        this.iUP = 0;
        this.iUS = false;
        this.iUT = null;
        this.isLoading = false;
        this.fTW = null;
        this.iUY = true;
        this.mOffset = 0;
        this.iFs = null;
        this.iSk = null;
        this.iUZ = false;
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
                                SubPbModel.this.iUT.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.iUT.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.iUT != null && SubPbModel.this.iUT.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.iUT.size() - 1; size >= 0; size--) {
                                m mVar2 = (m) SubPbModel.this.iUT.get(size);
                                if (SubPbModel.this.iUV) {
                                    SubPbModel.this.iSh.c(mVar2, true);
                                } else {
                                    SubPbModel.this.iSh.b(mVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.iUT.clear();
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
                            if (SubPbModel.this.iUO != null) {
                                SubPbModel.this.iUO.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                mVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (mVar.cjE().errorno.intValue() != 0) {
                                if (SubPbModel.this.iUO != null) {
                                    SubPbModel.this.iUO.a(false, mVar.iAW.errorno.intValue(), mVar.iAW.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (mVar.axQ() != null && mVar.axQ().azX() != null) {
                                mVar.axQ().azX().getUserId();
                                if (v.isEmpty(mVar.cjF().azX().getIconInfo()) && SubPbModel.this.iUQ != null) {
                                    mVar.cjF().azX().setIconInfo(SubPbModel.this.iUQ);
                                }
                            }
                            if (mVar.cjF() != null) {
                                SubPbModel.this.postID = mVar.cjF().getId();
                            }
                            if (mVar.axQ() != null) {
                                SubPbModel.this.iUF = mVar.axQ().getId();
                                SubPbModel.this.iAV = mVar.aww();
                                SubPbModel.this.iUN = mVar.axQ().aAg();
                            }
                            if (SubPbModel.this.iUN != null && SubPbModel.this.postID != null && SubPbModel.this.iUN.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.iAV = true;
                            }
                            if (SubPbModel.this.iUV) {
                                SubPbModel.this.f(mVar);
                            } else {
                                SubPbModel.this.e(mVar);
                            }
                            if (SubPbModel.this.iUO != null) {
                                SubPbModel.this.iUO.a(SubPbModel.this.cqw(), error, errorString, SubPbModel.this.iSh);
                            }
                        }
                    }
                }
            }
        };
        this.cRe = tbPageContext;
        this.iUT = new ArrayList<>();
        this.iSh = new m();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.iSl);
        registerListener(this.iSl);
    }

    public String cmc() {
        return this.iUF;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aMq() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public m cqv() {
        return this.iSh;
    }

    public AntiData bBu() {
        return this.dhW;
    }

    public boolean cqw() {
        return (this.iSh == null || this.iSh.cjF() == null) ? false : true;
    }

    public void a(a aVar) {
        this.iUO = aVar;
    }

    public MarkData l(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iUF);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.iUF);
        markData.setFloor(postData.cJz());
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
                    this.iUP++;
                    this.iSh.setTotalCount(this.iSh.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int cqx() {
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
        if (this.mLoadType == 3 && this.iUV) {
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
            intValue = cqx();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.iUV && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.cRe.getPageActivity(), Long.parseLong(this.iUF), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.iUK, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return zk(0);
    }

    public boolean cqy() {
        return zk(2);
    }

    public void cqz() {
        int pageSize;
        if (this.iUP > 0 && this.iSh != null && (pageSize = this.iSh.getPageSize()) > 0) {
            int aTs = this.iSh.aTs();
            for (int i = (((this.iUP + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.iVa = o(Integer.valueOf(aTs - i));
                this.iVa.setTreatDelPage(true);
                sendMessage(this.iVa);
            }
        }
        this.iUP = 0;
    }

    public boolean cqA() {
        return zk(1);
    }

    public boolean zk(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.iUF == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        cqz();
        this.mLoadType = i;
        this.iVa = cpC();
        sendMessage(this.iVa);
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
        return this.iUG;
    }

    public boolean cqB() {
        return this.iAV;
    }

    public boolean cqC() {
        return "hot_topic".equals(getStType());
    }

    public void qK(boolean z) {
        this.iAV = z;
    }

    public int cje() {
        return this.izU;
    }

    public String cqD() {
        return this.iUN;
    }

    public void Ge(String str) {
        this.iUN = str;
    }

    public String cqE() {
        return this.iUI;
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
        writeData.setFromForumId(this.iUL);
        writeData.setFloor(this.iSh.cjF().getId());
        writeData.setType(2);
        writeData.setThreadId(this.iSh.axQ().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aMp() {
        cqy();
        return true;
    }

    public boolean cqF() {
        return this.iUZ;
    }

    public void qL(boolean z) {
        this.iUZ = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.iSk = aVar;
    }

    public SmallTailInfo cqG() {
        return this.iUU;
    }

    public boolean cqH() {
        return this.iUS;
    }

    public ConcurrentHashMap<String, ImageUrlData> cqI() {
        return this.iUX;
    }

    public ArrayList<String> cqJ() {
        return this.iUW;
    }

    public boolean cqK() {
        return this.iUY;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.iUK;
    }

    public AttentionHostData cqL() {
        if (this.iUR == null) {
            this.iUR = new AttentionHostData();
            if (this.iSh != null && this.iSh.axQ() != null && this.iSh.axQ().azX() != null) {
                this.iUR.parserWithMetaData(this.iSh.axQ().azX());
            }
        }
        return this.iUR;
    }

    public boolean cmW() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public int cqM() {
        return this.pageFromType;
    }

    public String cmb() {
        return this.iUJ;
    }
}
