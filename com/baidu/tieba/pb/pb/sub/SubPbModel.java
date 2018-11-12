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
    private AntiData aKm;
    private com.baidu.tieba.tbadkCore.d.b diE;
    private int fJb;
    private boolean fKc;
    private PbFakeFloorModel fQx;
    private j fZO;
    private PbFakeFloorModel.a fZR;
    private com.baidu.adp.framework.listener.a fZS;
    private ConcurrentHashMap<String, ImageUrlData> gcA;
    private boolean gcB;
    private boolean gcC;
    private SubPbRequestMessage gcD;
    private String gcj;
    private boolean gck;
    private String gcl;
    private String gcm;
    private String gcn;
    private String gco;
    private boolean gcp;
    private String gcq;
    private a gcr;
    private int gcs;
    private ArrayList<IconData> gct;
    private AttentionHostData gcu;
    private boolean gcv;
    private ArrayList<j> gcw;
    private SmallTailInfo gcx;
    private boolean gcy;
    private ArrayList<String> gcz;
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
            this.gcj = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.gcn = intent.getStringExtra("from_forum_id");
            this.gco = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.gck = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.gcl = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.gcp = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.gcm = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fJb = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.gcx = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.gcx != null) {
                this.gcx.updateShowInfo();
            }
            this.aKm = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.gct = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.gcv = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.gcA = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.gcA.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.gcz = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.gcB = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.gcj = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.gcn = bundle.getString("from_forum_id");
            this.gco = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.gck = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.gcl = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.gcp = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.gcm = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fJb = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.gcx = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.gcx != null) {
                this.gcx.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.aKm = new AntiData();
                this.aKm.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.I(stringArrayList)) {
                this.gct = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.gct.add(iconData);
                    }
                }
            }
            this.gcv = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void D(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.gcj);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.gck);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.gcl);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.gcm);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.gcp);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fJb);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.gcx));
            if (this.aKm != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.aKm.toJsonString());
            }
            if (!v.I(this.gct)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.gct.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.gcn);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.gco);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.gcj = null;
        this.postID = null;
        this.stType = null;
        this.gck = false;
        this.gcl = null;
        this.gcm = null;
        this.pageFromType = 0;
        this.gcp = false;
        this.fKc = false;
        this.fJb = 0;
        this.gcq = null;
        this.mContext = null;
        this.fZO = null;
        this.gcr = null;
        this.gcs = 0;
        this.gcv = false;
        this.gcw = null;
        this.isLoading = false;
        this.diE = null;
        this.gcB = true;
        this.mOffset = 0;
        this.fQx = null;
        this.fZR = null;
        this.gcC = false;
        this.fZS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.gcw.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.gcw.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.gcw != null && SubPbModel.this.gcw.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.gcw.size() - 1; size >= 0; size--) {
                                j jVar2 = (j) SubPbModel.this.gcw.get(size);
                                if (SubPbModel.this.gcy) {
                                    SubPbModel.this.fZO.c(jVar2, true);
                                } else {
                                    SubPbModel.this.fZO.b(jVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.gcw.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.diE == null) {
                        SubPbModel.this.diE = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.diE != null) {
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
                            SubPbModel.this.diE.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.diE = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.diE = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.gcr != null) {
                                SubPbModel.this.gcr.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                jVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                jVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (jVar.beZ().errorno.intValue() != 0) {
                                if (SubPbModel.this.gcr != null) {
                                    SubPbModel.this.gcr.a(false, jVar.fKd.errorno.intValue(), jVar.fKd.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (jVar.YL() != null && jVar.YL().yC() != null) {
                                jVar.YL().yC().getUserId();
                                if (v.I(jVar.bfa().yC().getIconInfo()) && SubPbModel.this.gct != null) {
                                    jVar.bfa().yC().setIconInfo(SubPbModel.this.gct);
                                }
                            }
                            if (jVar.bfa() != null) {
                                SubPbModel.this.postID = jVar.bfa().getId();
                            }
                            if (jVar.YL() != null) {
                                SubPbModel.this.gcj = jVar.YL().getId();
                                SubPbModel.this.fKc = jVar.vm();
                                SubPbModel.this.gcq = jVar.YL().yM();
                            }
                            if (SubPbModel.this.gcq != null && SubPbModel.this.postID != null && SubPbModel.this.gcq.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fKc = true;
                            }
                            if (SubPbModel.this.gcy) {
                                SubPbModel.this.f(jVar);
                            } else {
                                SubPbModel.this.e(jVar);
                            }
                            if (SubPbModel.this.gcr != null) {
                                SubPbModel.this.gcr.a(SubPbModel.this.bkW(), error, errorString, SubPbModel.this.fZO);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.gcw = new ArrayList<>();
        this.fZO = new j();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.fZS);
        registerListener(this.fZS);
    }

    public String bhm() {
        return this.gcj;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Lo() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public j bkV() {
        return this.fZO;
    }

    public AntiData ayn() {
        return this.aKm;
    }

    public boolean bkW() {
        return (this.fZO == null || this.fZO.bfa() == null) ? false : true;
    }

    public void a(a aVar) {
        this.gcr = aVar;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.gcj);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.gcj);
        markData.setFloor(postData.bBx());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fZS);
        if (this.fQx != null) {
            this.fQx.unRegisterListener();
        }
        atR();
    }

    private void atR() {
        if (this.diE != null) {
            this.diE.destory();
            this.diE = null;
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

    public void sO(String str) {
        if (!TextUtils.isEmpty(str) && this.fZO != null && this.fZO.bfe() != null) {
            ArrayList<PostData> bfe = this.fZO.bfe();
            int size = bfe.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bfe.get(i).getId())) {
                    bfe.remove(i);
                    this.gcs++;
                    this.fZO.setTotalCount(this.fZO.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bkX() {
        int SS = this.fZO.SS();
        if (SS == 0) {
            return SS + 1;
        }
        if (this.mLoadType == 0) {
            return SS + 1;
        }
        if (this.mLoadType == 2 && this.fZO.bfe().size() != 0 && this.fZO.bfe().size() % this.fZO.getPageSize() == 0) {
            return SS + 1;
        }
        if (this.mLoadType == 3 && this.gcy) {
            return this.fZO.bfc() - 1;
        }
        if (this.mLoadType == 3 && SS > 0) {
            return this.fZO.bfb() - 1;
        }
        return SS;
    }

    private SubPbRequestMessage bkk() {
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
            intValue = bkX();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.gcy && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.gcj), j, j2, i, aO, aQ, f, this.stType, i2);
    }

    public boolean Ns() {
        return so(0);
    }

    public boolean bkY() {
        return so(2);
    }

    public void bkZ() {
        int pageSize;
        if (this.gcs > 0 && this.fZO != null && (pageSize = this.fZO.getPageSize()) > 0) {
            int SS = this.fZO.SS();
            for (int i = (((this.gcs + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.gcD = p(Integer.valueOf(SS - i));
                this.gcD.setTreatDelPage(true);
                sendMessage(this.gcD);
            }
        }
        this.gcs = 0;
    }

    public boolean bla() {
        return so(1);
    }

    public boolean so(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.gcj == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bkZ();
        this.mLoadType = i;
        this.gcD = bkk();
        sendMessage(this.gcD);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(j jVar) {
        ArrayList<PostData> bfe = jVar.bfe();
        if (bfe == null || bfe.size() == 0) {
            jVar.setCurrentPage(this.fZO.SS());
        }
        if (this.mLoadType == 1) {
            this.fZO = jVar;
        } else if (this.mLoadType == 2) {
            this.fZO.b(jVar, true);
        } else if (this.mLoadType == 3) {
            this.fZO.a(jVar, false);
        } else {
            this.fZO.b(jVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(j jVar) {
        if (this.mLoadType == 1) {
            this.fZO = jVar;
            this.fZO.bfd();
        } else if (this.mLoadType == 2) {
            this.fZO.c(jVar, true);
        } else if (this.mLoadType == 3) {
            this.fZO.d(jVar, false);
        } else {
            this.fZO.a(jVar);
        }
    }

    public boolean bkA() {
        return this.gck;
    }

    public boolean isMarked() {
        return this.fKc;
    }

    public boolean blb() {
        return "hot_topic".equals(getStType());
    }

    public void lK(boolean z) {
        this.fKc = z;
    }

    public int beF() {
        return this.fJb;
    }

    public String blc() {
        return this.gcq;
    }

    public void sP(String str) {
        this.gcq = str;
    }

    public String bld() {
        return this.gcm;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hs(String str) {
        if (this.fZO == null || this.fZO.bfg() == null || this.fZO.YL() == null || this.fZO.bfa() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.fZO.bfg().getName());
        writeData.setForumId(this.fZO.bfg().getId());
        writeData.setFromForumId(this.gco);
        writeData.setFloor(this.fZO.bfa().getId());
        writeData.setType(2);
        writeData.setThreadId(this.fZO.YL().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Ln() {
        bkY();
        return true;
    }

    public boolean ble() {
        return this.gcC;
    }

    public void lL(boolean z) {
        this.gcC = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.fZR = aVar;
    }

    public SmallTailInfo blf() {
        return this.gcx;
    }

    public boolean blg() {
        return this.gcv;
    }

    public ConcurrentHashMap<String, ImageUrlData> blh() {
        return this.gcA;
    }

    public ArrayList<String> bli() {
        return this.gcz;
    }

    public boolean blj() {
        return this.gcB;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.gcn;
    }

    public AttentionHostData blk() {
        if (this.gcu == null) {
            this.gcu = new AttentionHostData();
            if (this.fZO != null && this.fZO.YL() != null && this.fZO.YL().yC() != null) {
                this.gcu.parserWithMetaData(this.fZO.YL().yC());
            }
        }
        return this.gcu;
    }
}
