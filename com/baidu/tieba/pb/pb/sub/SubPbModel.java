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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes4.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private AntiData bWO;
    private com.baidu.tieba.tbadkCore.d.b eDQ;
    private j hAH;
    private PbFakeFloorModel.a hAK;
    private com.baidu.adp.framework.listener.a hAL;
    private SubPbRequestMessage hDA;
    private String hDf;
    private boolean hDg;
    private String hDh;
    private String hDi;
    private String hDj;
    private String hDk;
    private String hDl;
    private boolean hDm;
    private String hDn;
    private a hDo;
    private int hDp;
    private ArrayList<IconData> hDq;
    private AttentionHostData hDr;
    private boolean hDs;
    private ArrayList<j> hDt;
    private SmallTailInfo hDu;
    private boolean hDv;
    private ArrayList<String> hDw;
    private ConcurrentHashMap<String, ImageUrlData> hDx;
    private boolean hDy;
    private boolean hDz;
    private int hjU;
    private boolean hkV;
    private PbFakeFloorModel hro;
    private boolean isLoading;
    private TbPageContext<?> mContext;
    private int mLoadType;
    private int mOffset;
    public int pageFromType;
    private String postID;
    private String stType;

    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z, int i, String str, j jVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.hDf = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.hDk = intent.getStringExtra("from_forum_id");
            this.hDl = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.hDg = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.hDh = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.hDm = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.hDi = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hjU = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.hDu = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.hDu != null) {
                this.hDu.updateShowInfo();
            }
            this.bWO = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.hDq = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.hDs = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.hDx = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.hDx.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.hDw = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.hDy = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.hDj = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.hDf = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.hDk = bundle.getString("from_forum_id");
            this.hDl = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.hDg = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.hDh = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.hDm = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.hDi = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hjU = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.hDu = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.hDu != null) {
                this.hDu.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.bWO = new AntiData();
                this.bWO.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.T(stringArrayList)) {
                this.hDq = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.hDq.add(iconData);
                    }
                }
            }
            this.hDs = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.hDj = bundle.getString("high_light_post_id");
        }
    }

    public void aa(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.hDf);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.hDg);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.hDh);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.hDi);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.hDm);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.hjU);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.hDu));
            if (this.bWO != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.bWO.toJsonString());
            }
            if (!v.T(this.hDq)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.hDq.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.hDk);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.hDl);
            bundle.putString("high_light_post_id", this.hDj);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.hDf = null;
        this.postID = null;
        this.stType = null;
        this.hDg = false;
        this.hDh = null;
        this.hDi = null;
        this.hDj = null;
        this.pageFromType = 0;
        this.hDm = false;
        this.hkV = false;
        this.hjU = 0;
        this.hDn = null;
        this.mContext = null;
        this.hAH = null;
        this.hDo = null;
        this.hDp = 0;
        this.hDs = false;
        this.hDt = null;
        this.isLoading = false;
        this.eDQ = null;
        this.hDy = true;
        this.mOffset = 0;
        this.hro = null;
        this.hAK = null;
        this.hDz = false;
        this.hAL = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                boolean z;
                j jVar;
                long j2;
                long j3;
                long j4 = 0;
                if (SubPbModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    SubPbModel.this.isLoading = false;
                    if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                        SubPbModel.this.mContext.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.hDt.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.hDt.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.hDt != null && SubPbModel.this.hDt.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.hDt.size() - 1; size >= 0; size--) {
                                j jVar2 = (j) SubPbModel.this.hDt.get(size);
                                if (SubPbModel.this.hDv) {
                                    SubPbModel.this.hAH.c(jVar2, true);
                                } else {
                                    SubPbModel.this.hAH.b(jVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.hDt.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.eDQ == null) {
                        SubPbModel.this.eDQ = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.eDQ != null) {
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
                            SubPbModel.this.eDQ.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.eDQ = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.eDQ = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.hDo != null) {
                                SubPbModel.this.hDo.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                jVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                jVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (jVar.bID().errorno.intValue() != 0) {
                                if (SubPbModel.this.hDo != null) {
                                    SubPbModel.this.hDo.a(false, jVar.hkW.errorno.intValue(), jVar.hkW.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (jVar.WR() != null && jVar.WR().YR() != null) {
                                jVar.WR().YR().getUserId();
                                if (v.T(jVar.bIE().YR().getIconInfo()) && SubPbModel.this.hDq != null) {
                                    jVar.bIE().YR().setIconInfo(SubPbModel.this.hDq);
                                }
                            }
                            if (jVar.bIE() != null) {
                                SubPbModel.this.postID = jVar.bIE().getId();
                            }
                            if (jVar.WR() != null) {
                                SubPbModel.this.hDf = jVar.WR().getId();
                                SubPbModel.this.hkV = jVar.Vb();
                                SubPbModel.this.hDn = jVar.WR().Za();
                            }
                            if (SubPbModel.this.hDn != null && SubPbModel.this.postID != null && SubPbModel.this.hDn.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.hkV = true;
                            }
                            if (SubPbModel.this.hDv) {
                                SubPbModel.this.f(jVar);
                            } else {
                                SubPbModel.this.e(jVar);
                            }
                            if (SubPbModel.this.hDo != null) {
                                SubPbModel.this.hDo.a(SubPbModel.this.bOF(), error, errorString, SubPbModel.this.hAH);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hDt = new ArrayList<>();
        this.hAH = new j();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.hAL);
        registerListener(this.hAL);
    }

    public String bKS() {
        return this.hDf;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String amp() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public j bOE() {
        return this.hAH;
    }

    public AntiData bbJ() {
        return this.bWO;
    }

    public boolean bOF() {
        return (this.hAH == null || this.hAH.bIE() == null) ? false : true;
    }

    public void a(a aVar) {
        this.hDo = aVar;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hDf);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.hDf);
        markData.setFloor(postData.cer());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.hAL);
        if (this.hro != null) {
            this.hro.unRegisterListener();
        }
        aWZ();
    }

    private void aWZ() {
        if (this.eDQ != null) {
            this.eDQ.destory();
            this.eDQ = null;
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

    public void Ap(String str) {
        if (!TextUtils.isEmpty(str) && this.hAH != null && this.hAH.bII() != null) {
            ArrayList<PostData> bII = this.hAH.bII();
            int size = bII.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bII.get(i).getId())) {
                    bII.remove(i);
                    this.hDp++;
                    this.hAH.setTotalCount(this.hAH.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bOG() {
        int auv = this.hAH.auv();
        if (auv == 0) {
            return auv + 1;
        }
        if (this.mLoadType == 0) {
            return auv + 1;
        }
        if (this.mLoadType == 2 && this.hAH.bII().size() != 0 && this.hAH.bII().size() % this.hAH.getPageSize() == 0) {
            return auv + 1;
        }
        if (this.mLoadType == 3 && this.hDv) {
            return this.hAH.bIG() - 1;
        }
        if (this.mLoadType == 3 && auv > 0) {
            return this.hAH.bIF() - 1;
        }
        return auv;
    }

    private SubPbRequestMessage bNR() {
        this.isLoading = true;
        return k((Integer) null);
    }

    private SubPbRequestMessage k(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int aO = l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = l.aQ(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.d(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.d(this.postID, 0L);
        }
        if (num == null) {
            intValue = bOG();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.hDv && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.hDf), j, j2, i, aO, aQ, f, this.stType, i2);
    }

    public boolean aov() {
        return wJ(0);
    }

    public boolean bOH() {
        return wJ(2);
    }

    public void bOI() {
        int pageSize;
        if (this.hDp > 0 && this.hAH != null && (pageSize = this.hAH.getPageSize()) > 0) {
            int auv = this.hAH.auv();
            for (int i = (((this.hDp + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.hDA = k(Integer.valueOf(auv - i));
                this.hDA.setTreatDelPage(true);
                sendMessage(this.hDA);
            }
        }
        this.hDp = 0;
    }

    public boolean bOJ() {
        return wJ(1);
    }

    public boolean wJ(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.hDf == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bOI();
        this.mLoadType = i;
        this.hDA = bNR();
        sendMessage(this.hDA);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(j jVar) {
        ArrayList<PostData> bII = jVar.bII();
        if (bII == null || bII.size() == 0) {
            jVar.setCurrentPage(this.hAH.auv());
        }
        if (this.mLoadType == 1) {
            this.hAH = jVar;
        } else if (this.mLoadType == 2) {
            this.hAH.b(jVar, true);
        } else if (this.mLoadType == 3) {
            this.hAH.a(jVar, false);
        } else {
            this.hAH.b(jVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(j jVar) {
        if (this.mLoadType == 1) {
            this.hAH = jVar;
            this.hAH.bIH();
        } else if (this.mLoadType == 2) {
            this.hAH.c(jVar, true);
        } else if (this.mLoadType == 3) {
            this.hAH.d(jVar, false);
        } else {
            this.hAH.a(jVar);
        }
    }

    public boolean bOh() {
        return this.hDg;
    }

    public boolean isMarked() {
        return this.hkV;
    }

    public boolean bOK() {
        return "hot_topic".equals(getStType());
    }

    public void on(boolean z) {
        this.hkV = z;
    }

    public int bIm() {
        return this.hjU;
    }

    public String bOL() {
        return this.hDn;
    }

    public void Aq(String str) {
        this.hDn = str;
    }

    public String bOM() {
        return this.hDi;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData oN(String str) {
        if (this.hAH == null || this.hAH.bIK() == null || this.hAH.WR() == null || this.hAH.bIE() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.hAH.bIK().getName());
        writeData.setForumId(this.hAH.bIK().getId());
        writeData.setFromForumId(this.hDl);
        writeData.setFloor(this.hAH.bIE().getId());
        writeData.setType(2);
        writeData.setThreadId(this.hAH.WR().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean amo() {
        bOH();
        return true;
    }

    public boolean bON() {
        return this.hDz;
    }

    public void oo(boolean z) {
        this.hDz = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.hAK = aVar;
    }

    public SmallTailInfo bOO() {
        return this.hDu;
    }

    public boolean bOP() {
        return this.hDs;
    }

    public ConcurrentHashMap<String, ImageUrlData> bOQ() {
        return this.hDx;
    }

    public ArrayList<String> bOR() {
        return this.hDw;
    }

    public boolean bOS() {
        return this.hDy;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.hDk;
    }

    public AttentionHostData bOT() {
        if (this.hDr == null) {
            this.hDr = new AttentionHostData();
            if (this.hAH != null && this.hAH.WR() != null && this.hAH.WR().YR() != null) {
                this.hDr.parserWithMetaData(this.hAH.WR().YR());
            }
        }
        return this.hDr;
    }

    public boolean bLH() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public String bKR() {
        return this.hDj;
    }
}
