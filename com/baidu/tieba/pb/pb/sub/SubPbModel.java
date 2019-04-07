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
    private AntiData bWR;
    private com.baidu.tieba.tbadkCore.d.b eDx;
    private j hAn;
    private PbFakeFloorModel.a hAq;
    private com.baidu.adp.framework.listener.a hAr;
    private String hCL;
    private boolean hCM;
    private String hCN;
    private String hCO;
    private String hCP;
    private String hCQ;
    private String hCR;
    private boolean hCS;
    private String hCT;
    private a hCU;
    private int hCV;
    private ArrayList<IconData> hCW;
    private AttentionHostData hCX;
    private boolean hCY;
    private ArrayList<j> hCZ;
    private SmallTailInfo hDa;
    private boolean hDb;
    private ArrayList<String> hDc;
    private ConcurrentHashMap<String, ImageUrlData> hDd;
    private boolean hDe;
    private boolean hDf;
    private SubPbRequestMessage hDg;
    private int hjG;
    private boolean hkH;
    private PbFakeFloorModel hqU;
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
            this.hCL = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.hCQ = intent.getStringExtra("from_forum_id");
            this.hCR = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.hCM = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.hCN = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.hCS = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.hCO = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hjG = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.hDa = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.hDa != null) {
                this.hDa.updateShowInfo();
            }
            this.bWR = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.hCW = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.hCY = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.hDd = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.hDd.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.hDc = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.hDe = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.hCP = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.hCL = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.hCQ = bundle.getString("from_forum_id");
            this.hCR = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.hCM = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.hCN = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.hCS = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.hCO = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hjG = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.hDa = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.hDa != null) {
                this.hDa.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.bWR = new AntiData();
                this.bWR.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.T(stringArrayList)) {
                this.hCW = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.hCW.add(iconData);
                    }
                }
            }
            this.hCY = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.hCP = bundle.getString("high_light_post_id");
        }
    }

    public void aa(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.hCL);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.hCM);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.hCN);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.hCO);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.hCS);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.hjG);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.hDa));
            if (this.bWR != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.bWR.toJsonString());
            }
            if (!v.T(this.hCW)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.hCW.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.hCQ);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.hCR);
            bundle.putString("high_light_post_id", this.hCP);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.hCL = null;
        this.postID = null;
        this.stType = null;
        this.hCM = false;
        this.hCN = null;
        this.hCO = null;
        this.hCP = null;
        this.pageFromType = 0;
        this.hCS = false;
        this.hkH = false;
        this.hjG = 0;
        this.hCT = null;
        this.mContext = null;
        this.hAn = null;
        this.hCU = null;
        this.hCV = 0;
        this.hCY = false;
        this.hCZ = null;
        this.isLoading = false;
        this.eDx = null;
        this.hDe = true;
        this.mOffset = 0;
        this.hqU = null;
        this.hAq = null;
        this.hDf = false;
        this.hAr = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.hCZ.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.hCZ.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.hCZ != null && SubPbModel.this.hCZ.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.hCZ.size() - 1; size >= 0; size--) {
                                j jVar2 = (j) SubPbModel.this.hCZ.get(size);
                                if (SubPbModel.this.hDb) {
                                    SubPbModel.this.hAn.c(jVar2, true);
                                } else {
                                    SubPbModel.this.hAn.b(jVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.hCZ.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.eDx == null) {
                        SubPbModel.this.eDx = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.eDx != null) {
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
                            SubPbModel.this.eDx.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.eDx = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.eDx = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.hCU != null) {
                                SubPbModel.this.hCU.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                jVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                jVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (jVar.bIz().errorno.intValue() != 0) {
                                if (SubPbModel.this.hCU != null) {
                                    SubPbModel.this.hCU.a(false, jVar.hkI.errorno.intValue(), jVar.hkI.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (jVar.WO() != null && jVar.WO().YO() != null) {
                                jVar.WO().YO().getUserId();
                                if (v.T(jVar.bIA().YO().getIconInfo()) && SubPbModel.this.hCW != null) {
                                    jVar.bIA().YO().setIconInfo(SubPbModel.this.hCW);
                                }
                            }
                            if (jVar.bIA() != null) {
                                SubPbModel.this.postID = jVar.bIA().getId();
                            }
                            if (jVar.WO() != null) {
                                SubPbModel.this.hCL = jVar.WO().getId();
                                SubPbModel.this.hkH = jVar.UY();
                                SubPbModel.this.hCT = jVar.WO().YX();
                            }
                            if (SubPbModel.this.hCT != null && SubPbModel.this.postID != null && SubPbModel.this.hCT.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.hkH = true;
                            }
                            if (SubPbModel.this.hDb) {
                                SubPbModel.this.f(jVar);
                            } else {
                                SubPbModel.this.e(jVar);
                            }
                            if (SubPbModel.this.hCU != null) {
                                SubPbModel.this.hCU.a(SubPbModel.this.bOC(), error, errorString, SubPbModel.this.hAn);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hCZ = new ArrayList<>();
        this.hAn = new j();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.hAr);
        registerListener(this.hAr);
    }

    public String bKO() {
        return this.hCL;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aml() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public j bOB() {
        return this.hAn;
    }

    public AntiData bbG() {
        return this.bWR;
    }

    public boolean bOC() {
        return (this.hAn == null || this.hAn.bIA() == null) ? false : true;
    }

    public void a(a aVar) {
        this.hCU = aVar;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hCL);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.hCL);
        markData.setFloor(postData.cep());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.hAr);
        if (this.hqU != null) {
            this.hqU.unRegisterListener();
        }
        aWW();
    }

    private void aWW() {
        if (this.eDx != null) {
            this.eDx.destory();
            this.eDx = null;
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

    public void Am(String str) {
        if (!TextUtils.isEmpty(str) && this.hAn != null && this.hAn.bIE() != null) {
            ArrayList<PostData> bIE = this.hAn.bIE();
            int size = bIE.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bIE.get(i).getId())) {
                    bIE.remove(i);
                    this.hCV++;
                    this.hAn.setTotalCount(this.hAn.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bOD() {
        int aur = this.hAn.aur();
        if (aur == 0) {
            return aur + 1;
        }
        if (this.mLoadType == 0) {
            return aur + 1;
        }
        if (this.mLoadType == 2 && this.hAn.bIE().size() != 0 && this.hAn.bIE().size() % this.hAn.getPageSize() == 0) {
            return aur + 1;
        }
        if (this.mLoadType == 3 && this.hDb) {
            return this.hAn.bIC() - 1;
        }
        if (this.mLoadType == 3 && aur > 0) {
            return this.hAn.bIB() - 1;
        }
        return aur;
    }

    private SubPbRequestMessage bNO() {
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
            intValue = bOD();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.hDb && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.hCL), j, j2, i, aO, aQ, f, this.stType, i2);
    }

    public boolean aor() {
        return wF(0);
    }

    public boolean bOE() {
        return wF(2);
    }

    public void bOF() {
        int pageSize;
        if (this.hCV > 0 && this.hAn != null && (pageSize = this.hAn.getPageSize()) > 0) {
            int aur = this.hAn.aur();
            for (int i = (((this.hCV + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.hDg = k(Integer.valueOf(aur - i));
                this.hDg.setTreatDelPage(true);
                sendMessage(this.hDg);
            }
        }
        this.hCV = 0;
    }

    public boolean bOG() {
        return wF(1);
    }

    public boolean wF(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.hCL == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bOF();
        this.mLoadType = i;
        this.hDg = bNO();
        sendMessage(this.hDg);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(j jVar) {
        ArrayList<PostData> bIE = jVar.bIE();
        if (bIE == null || bIE.size() == 0) {
            jVar.setCurrentPage(this.hAn.aur());
        }
        if (this.mLoadType == 1) {
            this.hAn = jVar;
        } else if (this.mLoadType == 2) {
            this.hAn.b(jVar, true);
        } else if (this.mLoadType == 3) {
            this.hAn.a(jVar, false);
        } else {
            this.hAn.b(jVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(j jVar) {
        if (this.mLoadType == 1) {
            this.hAn = jVar;
            this.hAn.bID();
        } else if (this.mLoadType == 2) {
            this.hAn.c(jVar, true);
        } else if (this.mLoadType == 3) {
            this.hAn.d(jVar, false);
        } else {
            this.hAn.a(jVar);
        }
    }

    public boolean bOe() {
        return this.hCM;
    }

    public boolean isMarked() {
        return this.hkH;
    }

    public boolean bOH() {
        return "hot_topic".equals(getStType());
    }

    public void on(boolean z) {
        this.hkH = z;
    }

    public int bIi() {
        return this.hjG;
    }

    public String bOI() {
        return this.hCT;
    }

    public void An(String str) {
        this.hCT = str;
    }

    public String bOJ() {
        return this.hCO;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData oO(String str) {
        if (this.hAn == null || this.hAn.bIG() == null || this.hAn.WO() == null || this.hAn.bIA() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.hAn.bIG().getName());
        writeData.setForumId(this.hAn.bIG().getId());
        writeData.setFromForumId(this.hCR);
        writeData.setFloor(this.hAn.bIA().getId());
        writeData.setType(2);
        writeData.setThreadId(this.hAn.WO().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean amk() {
        bOE();
        return true;
    }

    public boolean bOK() {
        return this.hDf;
    }

    public void oo(boolean z) {
        this.hDf = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.hAq = aVar;
    }

    public SmallTailInfo bOL() {
        return this.hDa;
    }

    public boolean bOM() {
        return this.hCY;
    }

    public ConcurrentHashMap<String, ImageUrlData> bON() {
        return this.hDd;
    }

    public ArrayList<String> bOO() {
        return this.hDc;
    }

    public boolean bOP() {
        return this.hDe;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.hCQ;
    }

    public AttentionHostData bOQ() {
        if (this.hCX == null) {
            this.hCX = new AttentionHostData();
            if (this.hAn != null && this.hAn.WO() != null && this.hAn.WO().YO() != null) {
                this.hCX.parserWithMetaData(this.hAn.WO().YO());
            }
        }
        return this.hCX;
    }

    public boolean bLD() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public String bKN() {
        return this.hCP;
    }
}
