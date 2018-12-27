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
/* loaded from: classes6.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private AntiData aNN;
    private com.baidu.tieba.tbadkCore.d.b drX;
    private int fSJ;
    private boolean fTK;
    private PbFakeFloorModel gaf;
    private PbFakeFloorModel.a gjB;
    private com.baidu.adp.framework.listener.a gjC;
    private j gjy;
    private String glS;
    private boolean glT;
    private String glU;
    private String glV;
    private String glW;
    private String glX;
    private boolean glY;
    private String glZ;
    private a gma;
    private int gmb;
    private ArrayList<IconData> gmc;
    private AttentionHostData gmd;
    private boolean gme;
    private ArrayList<j> gmf;
    private SmallTailInfo gmg;
    private boolean gmh;
    private ArrayList<String> gmi;
    private ConcurrentHashMap<String, ImageUrlData> gmj;
    private boolean gmk;
    private boolean gml;
    private SubPbRequestMessage gmm;
    private boolean isLoading;
    private TbPageContext<?> mContext;
    private int mLoadType;
    private int mOffset;
    public int pageFromType;
    private String postID;
    private String stType;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, int i, String str, j jVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.glS = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.glW = intent.getStringExtra("from_forum_id");
            this.glX = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.glT = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.glU = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.glY = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.glV = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fSJ = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.gmg = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.gmg != null) {
                this.gmg.updateShowInfo();
            }
            this.aNN = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.gmc = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.gme = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.gmj = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.gmj.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.gmi = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.gmk = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.glS = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.glW = bundle.getString("from_forum_id");
            this.glX = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.glT = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.glU = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.glY = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.glV = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fSJ = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.gmg = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.gmg != null) {
                this.gmg.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.aNN = new AntiData();
                this.aNN.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.I(stringArrayList)) {
                this.gmc = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.gmc.add(iconData);
                    }
                }
            }
            this.gme = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void G(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.glS);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.glT);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.glU);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.glV);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.glY);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fSJ);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.gmg));
            if (this.aNN != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.aNN.toJsonString());
            }
            if (!v.I(this.gmc)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.gmc.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.glW);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.glX);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.glS = null;
        this.postID = null;
        this.stType = null;
        this.glT = false;
        this.glU = null;
        this.glV = null;
        this.pageFromType = 0;
        this.glY = false;
        this.fTK = false;
        this.fSJ = 0;
        this.glZ = null;
        this.mContext = null;
        this.gjy = null;
        this.gma = null;
        this.gmb = 0;
        this.gme = false;
        this.gmf = null;
        this.isLoading = false;
        this.drX = null;
        this.gmk = true;
        this.mOffset = 0;
        this.gaf = null;
        this.gjB = null;
        this.gml = false;
        this.gjC = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.gmf.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.gmf.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.gmf != null && SubPbModel.this.gmf.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.gmf.size() - 1; size >= 0; size--) {
                                j jVar2 = (j) SubPbModel.this.gmf.get(size);
                                if (SubPbModel.this.gmh) {
                                    SubPbModel.this.gjy.c(jVar2, true);
                                } else {
                                    SubPbModel.this.gjy.b(jVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.gmf.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.drX == null) {
                        SubPbModel.this.drX = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.drX != null) {
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
                            SubPbModel.this.drX.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.drX = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.drX = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.gma != null) {
                                SubPbModel.this.gma.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                jVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                jVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (jVar.bhB().errorno.intValue() != 0) {
                                if (SubPbModel.this.gma != null) {
                                    SubPbModel.this.gma.a(false, jVar.fTL.errorno.intValue(), jVar.fTL.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (jVar.ZT() != null && jVar.ZT().zG() != null) {
                                jVar.ZT().zG().getUserId();
                                if (v.I(jVar.bhC().zG().getIconInfo()) && SubPbModel.this.gmc != null) {
                                    jVar.bhC().zG().setIconInfo(SubPbModel.this.gmc);
                                }
                            }
                            if (jVar.bhC() != null) {
                                SubPbModel.this.postID = jVar.bhC().getId();
                            }
                            if (jVar.ZT() != null) {
                                SubPbModel.this.glS = jVar.ZT().getId();
                                SubPbModel.this.fTK = jVar.wq();
                                SubPbModel.this.glZ = jVar.ZT().zQ();
                            }
                            if (SubPbModel.this.glZ != null && SubPbModel.this.postID != null && SubPbModel.this.glZ.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fTK = true;
                            }
                            if (SubPbModel.this.gmh) {
                                SubPbModel.this.f(jVar);
                            } else {
                                SubPbModel.this.e(jVar);
                            }
                            if (SubPbModel.this.gma != null) {
                                SubPbModel.this.gma.a(SubPbModel.this.bnA(), error, errorString, SubPbModel.this.gjy);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.gmf = new ArrayList<>();
        this.gjy = new j();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.gjC);
        registerListener(this.gjC);
    }

    public String bjP() {
        return this.glS;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Mt() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public j bnz() {
        return this.gjy;
    }

    public AntiData aAM() {
        return this.aNN;
    }

    public boolean bnA() {
        return (this.gjy == null || this.gjy.bhC() == null) ? false : true;
    }

    public void a(a aVar) {
        this.gma = aVar;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.glS);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.glS);
        markData.setFloor(postData.bEj());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.gjC);
        if (this.gaf != null) {
            this.gaf.unRegisterListener();
        }
        awr();
    }

    private void awr() {
        if (this.drX != null) {
            this.drX.destory();
            this.drX = null;
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

    public void tt(String str) {
        if (!TextUtils.isEmpty(str) && this.gjy != null && this.gjy.bhG() != null) {
            ArrayList<PostData> bhG = this.gjy.bhG();
            int size = bhG.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bhG.get(i).getId())) {
                    bhG.remove(i);
                    this.gmb++;
                    this.gjy.setTotalCount(this.gjy.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bnB() {
        int Ua = this.gjy.Ua();
        if (Ua == 0) {
            return Ua + 1;
        }
        if (this.mLoadType == 0) {
            return Ua + 1;
        }
        if (this.mLoadType == 2 && this.gjy.bhG().size() != 0 && this.gjy.bhG().size() % this.gjy.getPageSize() == 0) {
            return Ua + 1;
        }
        if (this.mLoadType == 3 && this.gmh) {
            return this.gjy.bhE() - 1;
        }
        if (this.mLoadType == 3 && Ua > 0) {
            return this.gjy.bhD() - 1;
        }
        return Ua;
    }

    private SubPbRequestMessage bmO() {
        this.isLoading = true;
        return p(null);
    }

    private SubPbRequestMessage p(Integer num) {
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
            intValue = bnB();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.gmh && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.glS), j, j2, i, aO, aQ, f, this.stType, i2);
    }

    public boolean Ox() {
        return sV(0);
    }

    public boolean bnC() {
        return sV(2);
    }

    public void bnD() {
        int pageSize;
        if (this.gmb > 0 && this.gjy != null && (pageSize = this.gjy.getPageSize()) > 0) {
            int Ua = this.gjy.Ua();
            for (int i = (((this.gmb + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.gmm = p(Integer.valueOf(Ua - i));
                this.gmm.setTreatDelPage(true);
                sendMessage(this.gmm);
            }
        }
        this.gmb = 0;
    }

    public boolean bnE() {
        return sV(1);
    }

    public boolean sV(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.glS == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bnD();
        this.mLoadType = i;
        this.gmm = bmO();
        sendMessage(this.gmm);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(j jVar) {
        ArrayList<PostData> bhG = jVar.bhG();
        if (bhG == null || bhG.size() == 0) {
            jVar.setCurrentPage(this.gjy.Ua());
        }
        if (this.mLoadType == 1) {
            this.gjy = jVar;
        } else if (this.mLoadType == 2) {
            this.gjy.b(jVar, true);
        } else if (this.mLoadType == 3) {
            this.gjy.a(jVar, false);
        } else {
            this.gjy.b(jVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(j jVar) {
        if (this.mLoadType == 1) {
            this.gjy = jVar;
            this.gjy.bhF();
        } else if (this.mLoadType == 2) {
            this.gjy.c(jVar, true);
        } else if (this.mLoadType == 3) {
            this.gjy.d(jVar, false);
        } else {
            this.gjy.a(jVar);
        }
    }

    public boolean bne() {
        return this.glT;
    }

    public boolean isMarked() {
        return this.fTK;
    }

    public boolean bnF() {
        return "hot_topic".equals(getStType());
    }

    public void lQ(boolean z) {
        this.fTK = z;
    }

    public int bhh() {
        return this.fSJ;
    }

    public String bnG() {
        return this.glZ;
    }

    public void tu(String str) {
        this.glZ = str;
    }

    public String bnH() {
        return this.glV;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hL(String str) {
        if (this.gjy == null || this.gjy.bhI() == null || this.gjy.ZT() == null || this.gjy.bhC() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.gjy.bhI().getName());
        writeData.setForumId(this.gjy.bhI().getId());
        writeData.setFromForumId(this.glX);
        writeData.setFloor(this.gjy.bhC().getId());
        writeData.setType(2);
        writeData.setThreadId(this.gjy.ZT().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Ms() {
        bnC();
        return true;
    }

    public boolean bnI() {
        return this.gml;
    }

    public void lR(boolean z) {
        this.gml = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.gjB = aVar;
    }

    public SmallTailInfo bnJ() {
        return this.gmg;
    }

    public boolean bnK() {
        return this.gme;
    }

    public ConcurrentHashMap<String, ImageUrlData> bnL() {
        return this.gmj;
    }

    public ArrayList<String> bnM() {
        return this.gmi;
    }

    public boolean bnN() {
        return this.gmk;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.glW;
    }

    public AttentionHostData bnO() {
        if (this.gmd == null) {
            this.gmd = new AttentionHostData();
            if (this.gjy != null && this.gjy.ZT() != null && this.gjy.ZT().zG() != null) {
                this.gmd.parserWithMetaData(this.gjy.ZT().zG());
            }
        }
        return this.gmd;
    }
}
