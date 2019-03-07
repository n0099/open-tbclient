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
    private j hAG;
    private PbFakeFloorModel.a hAJ;
    private com.baidu.adp.framework.listener.a hAK;
    private String hDe;
    private boolean hDf;
    private String hDg;
    private String hDh;
    private String hDi;
    private String hDj;
    private String hDk;
    private boolean hDl;
    private String hDm;
    private a hDn;
    private int hDo;
    private ArrayList<IconData> hDp;
    private AttentionHostData hDq;
    private boolean hDr;
    private ArrayList<j> hDs;
    private SmallTailInfo hDt;
    private boolean hDu;
    private ArrayList<String> hDv;
    private ConcurrentHashMap<String, ImageUrlData> hDw;
    private boolean hDx;
    private boolean hDy;
    private SubPbRequestMessage hDz;
    private int hjT;
    private boolean hkU;
    private PbFakeFloorModel hrn;
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
            this.hDe = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.hDj = intent.getStringExtra("from_forum_id");
            this.hDk = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.hDf = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.hDg = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.hDl = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.hDh = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hjT = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.hDt = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.hDt != null) {
                this.hDt.updateShowInfo();
            }
            this.bWO = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.hDp = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.hDr = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.hDw = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.hDw.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.hDv = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.hDx = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.hDi = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.hDe = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.hDj = bundle.getString("from_forum_id");
            this.hDk = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.hDf = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.hDg = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.hDl = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.hDh = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hjT = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.hDt = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.hDt != null) {
                this.hDt.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.bWO = new AntiData();
                this.bWO.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.T(stringArrayList)) {
                this.hDp = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.hDp.add(iconData);
                    }
                }
            }
            this.hDr = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.hDi = bundle.getString("high_light_post_id");
        }
    }

    public void aa(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.hDe);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.hDf);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.hDg);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.hDh);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.hDl);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.hjT);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.hDt));
            if (this.bWO != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.bWO.toJsonString());
            }
            if (!v.T(this.hDp)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.hDp.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.hDj);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.hDk);
            bundle.putString("high_light_post_id", this.hDi);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.hDe = null;
        this.postID = null;
        this.stType = null;
        this.hDf = false;
        this.hDg = null;
        this.hDh = null;
        this.hDi = null;
        this.pageFromType = 0;
        this.hDl = false;
        this.hkU = false;
        this.hjT = 0;
        this.hDm = null;
        this.mContext = null;
        this.hAG = null;
        this.hDn = null;
        this.hDo = 0;
        this.hDr = false;
        this.hDs = null;
        this.isLoading = false;
        this.eDQ = null;
        this.hDx = true;
        this.mOffset = 0;
        this.hrn = null;
        this.hAJ = null;
        this.hDy = false;
        this.hAK = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.hDs.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.hDs.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.hDs != null && SubPbModel.this.hDs.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.hDs.size() - 1; size >= 0; size--) {
                                j jVar2 = (j) SubPbModel.this.hDs.get(size);
                                if (SubPbModel.this.hDu) {
                                    SubPbModel.this.hAG.c(jVar2, true);
                                } else {
                                    SubPbModel.this.hAG.b(jVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.hDs.clear();
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
                            if (SubPbModel.this.hDn != null) {
                                SubPbModel.this.hDn.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                jVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                jVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (jVar.bIC().errorno.intValue() != 0) {
                                if (SubPbModel.this.hDn != null) {
                                    SubPbModel.this.hDn.a(false, jVar.hkV.errorno.intValue(), jVar.hkV.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (jVar.WR() != null && jVar.WR().YR() != null) {
                                jVar.WR().YR().getUserId();
                                if (v.T(jVar.bID().YR().getIconInfo()) && SubPbModel.this.hDp != null) {
                                    jVar.bID().YR().setIconInfo(SubPbModel.this.hDp);
                                }
                            }
                            if (jVar.bID() != null) {
                                SubPbModel.this.postID = jVar.bID().getId();
                            }
                            if (jVar.WR() != null) {
                                SubPbModel.this.hDe = jVar.WR().getId();
                                SubPbModel.this.hkU = jVar.Vb();
                                SubPbModel.this.hDm = jVar.WR().Za();
                            }
                            if (SubPbModel.this.hDm != null && SubPbModel.this.postID != null && SubPbModel.this.hDm.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.hkU = true;
                            }
                            if (SubPbModel.this.hDu) {
                                SubPbModel.this.f(jVar);
                            } else {
                                SubPbModel.this.e(jVar);
                            }
                            if (SubPbModel.this.hDn != null) {
                                SubPbModel.this.hDn.a(SubPbModel.this.bOE(), error, errorString, SubPbModel.this.hAG);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hDs = new ArrayList<>();
        this.hAG = new j();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.hAK);
        registerListener(this.hAK);
    }

    public String bKR() {
        return this.hDe;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String amp() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public j bOD() {
        return this.hAG;
    }

    public AntiData bbI() {
        return this.bWO;
    }

    public boolean bOE() {
        return (this.hAG == null || this.hAG.bID() == null) ? false : true;
    }

    public void a(a aVar) {
        this.hDn = aVar;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hDe);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.hDe);
        markData.setFloor(postData.ceq());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.hAK);
        if (this.hrn != null) {
            this.hrn.unRegisterListener();
        }
        aWY();
    }

    private void aWY() {
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

    public void Ao(String str) {
        if (!TextUtils.isEmpty(str) && this.hAG != null && this.hAG.bIH() != null) {
            ArrayList<PostData> bIH = this.hAG.bIH();
            int size = bIH.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bIH.get(i).getId())) {
                    bIH.remove(i);
                    this.hDo++;
                    this.hAG.setTotalCount(this.hAG.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bOF() {
        int auu = this.hAG.auu();
        if (auu == 0) {
            return auu + 1;
        }
        if (this.mLoadType == 0) {
            return auu + 1;
        }
        if (this.mLoadType == 2 && this.hAG.bIH().size() != 0 && this.hAG.bIH().size() % this.hAG.getPageSize() == 0) {
            return auu + 1;
        }
        if (this.mLoadType == 3 && this.hDu) {
            return this.hAG.bIF() - 1;
        }
        if (this.mLoadType == 3 && auu > 0) {
            return this.hAG.bIE() - 1;
        }
        return auu;
    }

    private SubPbRequestMessage bNQ() {
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
            intValue = bOF();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.hDu && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.hDe), j, j2, i, aO, aQ, f, this.stType, i2);
    }

    public boolean aov() {
        return wJ(0);
    }

    public boolean bOG() {
        return wJ(2);
    }

    public void bOH() {
        int pageSize;
        if (this.hDo > 0 && this.hAG != null && (pageSize = this.hAG.getPageSize()) > 0) {
            int auu = this.hAG.auu();
            for (int i = (((this.hDo + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.hDz = k(Integer.valueOf(auu - i));
                this.hDz.setTreatDelPage(true);
                sendMessage(this.hDz);
            }
        }
        this.hDo = 0;
    }

    public boolean bOI() {
        return wJ(1);
    }

    public boolean wJ(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.hDe == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bOH();
        this.mLoadType = i;
        this.hDz = bNQ();
        sendMessage(this.hDz);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(j jVar) {
        ArrayList<PostData> bIH = jVar.bIH();
        if (bIH == null || bIH.size() == 0) {
            jVar.setCurrentPage(this.hAG.auu());
        }
        if (this.mLoadType == 1) {
            this.hAG = jVar;
        } else if (this.mLoadType == 2) {
            this.hAG.b(jVar, true);
        } else if (this.mLoadType == 3) {
            this.hAG.a(jVar, false);
        } else {
            this.hAG.b(jVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(j jVar) {
        if (this.mLoadType == 1) {
            this.hAG = jVar;
            this.hAG.bIG();
        } else if (this.mLoadType == 2) {
            this.hAG.c(jVar, true);
        } else if (this.mLoadType == 3) {
            this.hAG.d(jVar, false);
        } else {
            this.hAG.a(jVar);
        }
    }

    public boolean bOg() {
        return this.hDf;
    }

    public boolean isMarked() {
        return this.hkU;
    }

    public boolean bOJ() {
        return "hot_topic".equals(getStType());
    }

    public void on(boolean z) {
        this.hkU = z;
    }

    public int bIl() {
        return this.hjT;
    }

    public String bOK() {
        return this.hDm;
    }

    public void Ap(String str) {
        this.hDm = str;
    }

    public String bOL() {
        return this.hDh;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData oN(String str) {
        if (this.hAG == null || this.hAG.bIJ() == null || this.hAG.WR() == null || this.hAG.bID() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.hAG.bIJ().getName());
        writeData.setForumId(this.hAG.bIJ().getId());
        writeData.setFromForumId(this.hDk);
        writeData.setFloor(this.hAG.bID().getId());
        writeData.setType(2);
        writeData.setThreadId(this.hAG.WR().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean amo() {
        bOG();
        return true;
    }

    public boolean bOM() {
        return this.hDy;
    }

    public void oo(boolean z) {
        this.hDy = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.hAJ = aVar;
    }

    public SmallTailInfo bON() {
        return this.hDt;
    }

    public boolean bOO() {
        return this.hDr;
    }

    public ConcurrentHashMap<String, ImageUrlData> bOP() {
        return this.hDw;
    }

    public ArrayList<String> bOQ() {
        return this.hDv;
    }

    public boolean bOR() {
        return this.hDx;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.hDj;
    }

    public AttentionHostData bOS() {
        if (this.hDq == null) {
            this.hDq = new AttentionHostData();
            if (this.hAG != null && this.hAG.WR() != null && this.hAG.WR().YR() != null) {
                this.hDq.parserWithMetaData(this.hAG.WR().YR());
            }
        }
        return this.hDq;
    }

    public boolean bLG() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public String bKQ() {
        return this.hDi;
    }
}
