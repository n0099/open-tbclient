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
    private AntiData bWS;
    private com.baidu.tieba.tbadkCore.d.b eDy;
    private j hAo;
    private PbFakeFloorModel.a hAr;
    private com.baidu.adp.framework.listener.a hAs;
    private String hCM;
    private boolean hCN;
    private String hCO;
    private String hCP;
    private String hCQ;
    private String hCR;
    private String hCS;
    private boolean hCT;
    private String hCU;
    private a hCV;
    private int hCW;
    private ArrayList<IconData> hCX;
    private AttentionHostData hCY;
    private boolean hCZ;
    private ArrayList<j> hDa;
    private SmallTailInfo hDb;
    private boolean hDc;
    private ArrayList<String> hDd;
    private ConcurrentHashMap<String, ImageUrlData> hDe;
    private boolean hDf;
    private boolean hDg;
    private SubPbRequestMessage hDh;
    private int hjH;
    private boolean hkI;
    private PbFakeFloorModel hqV;
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
            this.hCM = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.hCR = intent.getStringExtra("from_forum_id");
            this.hCS = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.hCN = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.hCO = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.hCT = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.hCP = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hjH = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.hDb = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.hDb != null) {
                this.hDb.updateShowInfo();
            }
            this.bWS = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.hCX = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.hCZ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.hDe = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.hDe.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.hDd = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.hDf = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.hCQ = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.hCM = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.hCR = bundle.getString("from_forum_id");
            this.hCS = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.hCN = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.hCO = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.hCT = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.hCP = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hjH = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.hDb = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.hDb != null) {
                this.hDb.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.bWS = new AntiData();
                this.bWS.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.T(stringArrayList)) {
                this.hCX = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.hCX.add(iconData);
                    }
                }
            }
            this.hCZ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.hCQ = bundle.getString("high_light_post_id");
        }
    }

    public void aa(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.hCM);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.hCN);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.hCO);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.hCP);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.hCT);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.hjH);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.hDb));
            if (this.bWS != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.bWS.toJsonString());
            }
            if (!v.T(this.hCX)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.hCX.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.hCR);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.hCS);
            bundle.putString("high_light_post_id", this.hCQ);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.hCM = null;
        this.postID = null;
        this.stType = null;
        this.hCN = false;
        this.hCO = null;
        this.hCP = null;
        this.hCQ = null;
        this.pageFromType = 0;
        this.hCT = false;
        this.hkI = false;
        this.hjH = 0;
        this.hCU = null;
        this.mContext = null;
        this.hAo = null;
        this.hCV = null;
        this.hCW = 0;
        this.hCZ = false;
        this.hDa = null;
        this.isLoading = false;
        this.eDy = null;
        this.hDf = true;
        this.mOffset = 0;
        this.hqV = null;
        this.hAr = null;
        this.hDg = false;
        this.hAs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.hDa.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.hDa.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.hDa != null && SubPbModel.this.hDa.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.hDa.size() - 1; size >= 0; size--) {
                                j jVar2 = (j) SubPbModel.this.hDa.get(size);
                                if (SubPbModel.this.hDc) {
                                    SubPbModel.this.hAo.c(jVar2, true);
                                } else {
                                    SubPbModel.this.hAo.b(jVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.hDa.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.eDy == null) {
                        SubPbModel.this.eDy = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.eDy != null) {
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
                            SubPbModel.this.eDy.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.eDy = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.eDy = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.hCV != null) {
                                SubPbModel.this.hCV.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                jVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                jVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (jVar.bIz().errorno.intValue() != 0) {
                                if (SubPbModel.this.hCV != null) {
                                    SubPbModel.this.hCV.a(false, jVar.hkJ.errorno.intValue(), jVar.hkJ.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (jVar.WO() != null && jVar.WO().YO() != null) {
                                jVar.WO().YO().getUserId();
                                if (v.T(jVar.bIA().YO().getIconInfo()) && SubPbModel.this.hCX != null) {
                                    jVar.bIA().YO().setIconInfo(SubPbModel.this.hCX);
                                }
                            }
                            if (jVar.bIA() != null) {
                                SubPbModel.this.postID = jVar.bIA().getId();
                            }
                            if (jVar.WO() != null) {
                                SubPbModel.this.hCM = jVar.WO().getId();
                                SubPbModel.this.hkI = jVar.UY();
                                SubPbModel.this.hCU = jVar.WO().YX();
                            }
                            if (SubPbModel.this.hCU != null && SubPbModel.this.postID != null && SubPbModel.this.hCU.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.hkI = true;
                            }
                            if (SubPbModel.this.hDc) {
                                SubPbModel.this.f(jVar);
                            } else {
                                SubPbModel.this.e(jVar);
                            }
                            if (SubPbModel.this.hCV != null) {
                                SubPbModel.this.hCV.a(SubPbModel.this.bOC(), error, errorString, SubPbModel.this.hAo);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hDa = new ArrayList<>();
        this.hAo = new j();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.hAs);
        registerListener(this.hAs);
    }

    public String bKO() {
        return this.hCM;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aml() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public j bOB() {
        return this.hAo;
    }

    public AntiData bbG() {
        return this.bWS;
    }

    public boolean bOC() {
        return (this.hAo == null || this.hAo.bIA() == null) ? false : true;
    }

    public void a(a aVar) {
        this.hCV = aVar;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hCM);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.hCM);
        markData.setFloor(postData.cep());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.hAs);
        if (this.hqV != null) {
            this.hqV.unRegisterListener();
        }
        aWW();
    }

    private void aWW() {
        if (this.eDy != null) {
            this.eDy.destory();
            this.eDy = null;
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
        if (!TextUtils.isEmpty(str) && this.hAo != null && this.hAo.bIE() != null) {
            ArrayList<PostData> bIE = this.hAo.bIE();
            int size = bIE.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bIE.get(i).getId())) {
                    bIE.remove(i);
                    this.hCW++;
                    this.hAo.setTotalCount(this.hAo.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bOD() {
        int aur = this.hAo.aur();
        if (aur == 0) {
            return aur + 1;
        }
        if (this.mLoadType == 0) {
            return aur + 1;
        }
        if (this.mLoadType == 2 && this.hAo.bIE().size() != 0 && this.hAo.bIE().size() % this.hAo.getPageSize() == 0) {
            return aur + 1;
        }
        if (this.mLoadType == 3 && this.hDc) {
            return this.hAo.bIC() - 1;
        }
        if (this.mLoadType == 3 && aur > 0) {
            return this.hAo.bIB() - 1;
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
        if (this.hDc && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.hCM), j, j2, i, aO, aQ, f, this.stType, i2);
    }

    public boolean aor() {
        return wF(0);
    }

    public boolean bOE() {
        return wF(2);
    }

    public void bOF() {
        int pageSize;
        if (this.hCW > 0 && this.hAo != null && (pageSize = this.hAo.getPageSize()) > 0) {
            int aur = this.hAo.aur();
            for (int i = (((this.hCW + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.hDh = k(Integer.valueOf(aur - i));
                this.hDh.setTreatDelPage(true);
                sendMessage(this.hDh);
            }
        }
        this.hCW = 0;
    }

    public boolean bOG() {
        return wF(1);
    }

    public boolean wF(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.hCM == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bOF();
        this.mLoadType = i;
        this.hDh = bNO();
        sendMessage(this.hDh);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(j jVar) {
        ArrayList<PostData> bIE = jVar.bIE();
        if (bIE == null || bIE.size() == 0) {
            jVar.setCurrentPage(this.hAo.aur());
        }
        if (this.mLoadType == 1) {
            this.hAo = jVar;
        } else if (this.mLoadType == 2) {
            this.hAo.b(jVar, true);
        } else if (this.mLoadType == 3) {
            this.hAo.a(jVar, false);
        } else {
            this.hAo.b(jVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(j jVar) {
        if (this.mLoadType == 1) {
            this.hAo = jVar;
            this.hAo.bID();
        } else if (this.mLoadType == 2) {
            this.hAo.c(jVar, true);
        } else if (this.mLoadType == 3) {
            this.hAo.d(jVar, false);
        } else {
            this.hAo.a(jVar);
        }
    }

    public boolean bOe() {
        return this.hCN;
    }

    public boolean isMarked() {
        return this.hkI;
    }

    public boolean bOH() {
        return "hot_topic".equals(getStType());
    }

    public void on(boolean z) {
        this.hkI = z;
    }

    public int bIi() {
        return this.hjH;
    }

    public String bOI() {
        return this.hCU;
    }

    public void An(String str) {
        this.hCU = str;
    }

    public String bOJ() {
        return this.hCP;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData oO(String str) {
        if (this.hAo == null || this.hAo.bIG() == null || this.hAo.WO() == null || this.hAo.bIA() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.hAo.bIG().getName());
        writeData.setForumId(this.hAo.bIG().getId());
        writeData.setFromForumId(this.hCS);
        writeData.setFloor(this.hAo.bIA().getId());
        writeData.setType(2);
        writeData.setThreadId(this.hAo.WO().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean amk() {
        bOE();
        return true;
    }

    public boolean bOK() {
        return this.hDg;
    }

    public void oo(boolean z) {
        this.hDg = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.hAr = aVar;
    }

    public SmallTailInfo bOL() {
        return this.hDb;
    }

    public boolean bOM() {
        return this.hCZ;
    }

    public ConcurrentHashMap<String, ImageUrlData> bON() {
        return this.hDe;
    }

    public ArrayList<String> bOO() {
        return this.hDd;
    }

    public boolean bOP() {
        return this.hDf;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.hCR;
    }

    public AttentionHostData bOQ() {
        if (this.hCY == null) {
            this.hCY = new AttentionHostData();
            if (this.hAo != null && this.hAo.WO() != null && this.hAo.WO().YO() != null) {
                this.hCY.parserWithMetaData(this.hAo.WO().YO());
            }
        }
        return this.hCY;
    }

    public boolean bLD() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public String bKN() {
        return this.hCQ;
    }
}
