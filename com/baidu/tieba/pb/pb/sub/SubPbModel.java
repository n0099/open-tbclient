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
    private AntiData bWP;
    private com.baidu.tieba.tbadkCore.d.b eDM;
    private j hAB;
    private PbFakeFloorModel.a hAE;
    private com.baidu.adp.framework.listener.a hAF;
    private String hCZ;
    private boolean hDa;
    private String hDb;
    private String hDc;
    private String hDd;
    private String hDe;
    private String hDf;
    private boolean hDg;
    private String hDh;
    private a hDi;
    private int hDj;
    private ArrayList<IconData> hDk;
    private AttentionHostData hDl;
    private boolean hDm;
    private ArrayList<j> hDn;
    private SmallTailInfo hDo;
    private boolean hDp;
    private ArrayList<String> hDq;
    private ConcurrentHashMap<String, ImageUrlData> hDr;
    private boolean hDs;
    private boolean hDt;
    private SubPbRequestMessage hDu;
    private int hjT;
    private boolean hkU;
    private PbFakeFloorModel hrh;
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
            this.hCZ = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.hDe = intent.getStringExtra("from_forum_id");
            this.hDf = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.hDa = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.hDb = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.hDg = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.hDc = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hjT = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.hDo = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.hDo != null) {
                this.hDo.updateShowInfo();
            }
            this.bWP = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.hDk = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.hDm = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.hDr = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.hDr.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.hDq = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.hDs = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.hDd = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.hCZ = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.hDe = bundle.getString("from_forum_id");
            this.hDf = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.hDa = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.hDb = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.hDg = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.hDc = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hjT = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.hDo = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.hDo != null) {
                this.hDo.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.bWP = new AntiData();
                this.bWP.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.T(stringArrayList)) {
                this.hDk = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.hDk.add(iconData);
                    }
                }
            }
            this.hDm = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.hDd = bundle.getString("high_light_post_id");
        }
    }

    public void aa(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.hCZ);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.hDa);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.hDb);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.hDc);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.hDg);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.hjT);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.hDo));
            if (this.bWP != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.bWP.toJsonString());
            }
            if (!v.T(this.hDk)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.hDk.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.hDe);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.hDf);
            bundle.putString("high_light_post_id", this.hDd);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.hCZ = null;
        this.postID = null;
        this.stType = null;
        this.hDa = false;
        this.hDb = null;
        this.hDc = null;
        this.hDd = null;
        this.pageFromType = 0;
        this.hDg = false;
        this.hkU = false;
        this.hjT = 0;
        this.hDh = null;
        this.mContext = null;
        this.hAB = null;
        this.hDi = null;
        this.hDj = 0;
        this.hDm = false;
        this.hDn = null;
        this.isLoading = false;
        this.eDM = null;
        this.hDs = true;
        this.mOffset = 0;
        this.hrh = null;
        this.hAE = null;
        this.hDt = false;
        this.hAF = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.hDn.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.hDn.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.hDn != null && SubPbModel.this.hDn.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.hDn.size() - 1; size >= 0; size--) {
                                j jVar2 = (j) SubPbModel.this.hDn.get(size);
                                if (SubPbModel.this.hDp) {
                                    SubPbModel.this.hAB.c(jVar2, true);
                                } else {
                                    SubPbModel.this.hAB.b(jVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.hDn.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.eDM == null) {
                        SubPbModel.this.eDM = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.eDM != null) {
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
                            SubPbModel.this.eDM.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.eDM = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.eDM = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.hDi != null) {
                                SubPbModel.this.hDi.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                jVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                jVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (jVar.bIC().errorno.intValue() != 0) {
                                if (SubPbModel.this.hDi != null) {
                                    SubPbModel.this.hDi.a(false, jVar.hkV.errorno.intValue(), jVar.hkV.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (jVar.WR() != null && jVar.WR().YR() != null) {
                                jVar.WR().YR().getUserId();
                                if (v.T(jVar.bID().YR().getIconInfo()) && SubPbModel.this.hDk != null) {
                                    jVar.bID().YR().setIconInfo(SubPbModel.this.hDk);
                                }
                            }
                            if (jVar.bID() != null) {
                                SubPbModel.this.postID = jVar.bID().getId();
                            }
                            if (jVar.WR() != null) {
                                SubPbModel.this.hCZ = jVar.WR().getId();
                                SubPbModel.this.hkU = jVar.Vb();
                                SubPbModel.this.hDh = jVar.WR().Za();
                            }
                            if (SubPbModel.this.hDh != null && SubPbModel.this.postID != null && SubPbModel.this.hDh.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.hkU = true;
                            }
                            if (SubPbModel.this.hDp) {
                                SubPbModel.this.f(jVar);
                            } else {
                                SubPbModel.this.e(jVar);
                            }
                            if (SubPbModel.this.hDi != null) {
                                SubPbModel.this.hDi.a(SubPbModel.this.bOF(), error, errorString, SubPbModel.this.hAB);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hDn = new ArrayList<>();
        this.hAB = new j();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.hAF);
        registerListener(this.hAF);
    }

    public String bKR() {
        return this.hCZ;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String amo() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public j bOE() {
        return this.hAB;
    }

    public AntiData bbI() {
        return this.bWP;
    }

    public boolean bOF() {
        return (this.hAB == null || this.hAB.bID() == null) ? false : true;
    }

    public void a(a aVar) {
        this.hDi = aVar;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hCZ);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.hCZ);
        markData.setFloor(postData.cet());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.hAF);
        if (this.hrh != null) {
            this.hrh.unRegisterListener();
        }
        aWY();
    }

    private void aWY() {
        if (this.eDM != null) {
            this.eDM.destory();
            this.eDM = null;
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

    public void An(String str) {
        if (!TextUtils.isEmpty(str) && this.hAB != null && this.hAB.bIH() != null) {
            ArrayList<PostData> bIH = this.hAB.bIH();
            int size = bIH.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bIH.get(i).getId())) {
                    bIH.remove(i);
                    this.hDj++;
                    this.hAB.setTotalCount(this.hAB.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bOG() {
        int auu = this.hAB.auu();
        if (auu == 0) {
            return auu + 1;
        }
        if (this.mLoadType == 0) {
            return auu + 1;
        }
        if (this.mLoadType == 2 && this.hAB.bIH().size() != 0 && this.hAB.bIH().size() % this.hAB.getPageSize() == 0) {
            return auu + 1;
        }
        if (this.mLoadType == 3 && this.hDp) {
            return this.hAB.bIF() - 1;
        }
        if (this.mLoadType == 3 && auu > 0) {
            return this.hAB.bIE() - 1;
        }
        return auu;
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
        if (this.hDp && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.hCZ), j, j2, i, aO, aQ, f, this.stType, i2);
    }

    public boolean aou() {
        return wJ(0);
    }

    public boolean bOH() {
        return wJ(2);
    }

    public void bOI() {
        int pageSize;
        if (this.hDj > 0 && this.hAB != null && (pageSize = this.hAB.getPageSize()) > 0) {
            int auu = this.hAB.auu();
            for (int i = (((this.hDj + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.hDu = k(Integer.valueOf(auu - i));
                this.hDu.setTreatDelPage(true);
                sendMessage(this.hDu);
            }
        }
        this.hDj = 0;
    }

    public boolean bOJ() {
        return wJ(1);
    }

    public boolean wJ(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.hCZ == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bOI();
        this.mLoadType = i;
        this.hDu = bNR();
        sendMessage(this.hDu);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(j jVar) {
        ArrayList<PostData> bIH = jVar.bIH();
        if (bIH == null || bIH.size() == 0) {
            jVar.setCurrentPage(this.hAB.auu());
        }
        if (this.mLoadType == 1) {
            this.hAB = jVar;
        } else if (this.mLoadType == 2) {
            this.hAB.b(jVar, true);
        } else if (this.mLoadType == 3) {
            this.hAB.a(jVar, false);
        } else {
            this.hAB.b(jVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(j jVar) {
        if (this.mLoadType == 1) {
            this.hAB = jVar;
            this.hAB.bIG();
        } else if (this.mLoadType == 2) {
            this.hAB.c(jVar, true);
        } else if (this.mLoadType == 3) {
            this.hAB.d(jVar, false);
        } else {
            this.hAB.a(jVar);
        }
    }

    public boolean bOh() {
        return this.hDa;
    }

    public boolean isMarked() {
        return this.hkU;
    }

    public boolean bOK() {
        return "hot_topic".equals(getStType());
    }

    public void on(boolean z) {
        this.hkU = z;
    }

    public int bIl() {
        return this.hjT;
    }

    public String bOL() {
        return this.hDh;
    }

    public void Ao(String str) {
        this.hDh = str;
    }

    public String bOM() {
        return this.hDc;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData oN(String str) {
        if (this.hAB == null || this.hAB.bIJ() == null || this.hAB.WR() == null || this.hAB.bID() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.hAB.bIJ().getName());
        writeData.setForumId(this.hAB.bIJ().getId());
        writeData.setFromForumId(this.hDf);
        writeData.setFloor(this.hAB.bID().getId());
        writeData.setType(2);
        writeData.setThreadId(this.hAB.WR().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean amn() {
        bOH();
        return true;
    }

    public boolean bON() {
        return this.hDt;
    }

    public void oo(boolean z) {
        this.hDt = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.hAE = aVar;
    }

    public SmallTailInfo bOO() {
        return this.hDo;
    }

    public boolean bOP() {
        return this.hDm;
    }

    public ConcurrentHashMap<String, ImageUrlData> bOQ() {
        return this.hDr;
    }

    public ArrayList<String> bOR() {
        return this.hDq;
    }

    public boolean bOS() {
        return this.hDs;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.hDe;
    }

    public AttentionHostData bOT() {
        if (this.hDl == null) {
            this.hDl = new AttentionHostData();
            if (this.hAB != null && this.hAB.WR() != null && this.hAB.WR().YR() != null) {
                this.hDl.parserWithMetaData(this.hAB.WR().YR());
            }
        }
        return this.hDl;
    }

    public boolean bLG() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public String bKQ() {
        return this.hDd;
    }
}
