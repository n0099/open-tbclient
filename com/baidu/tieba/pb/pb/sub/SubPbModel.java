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
/* loaded from: classes2.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private AntiData aET;
    private com.baidu.tieba.tbadkCore.d.b cZk;
    private int fAa;
    private boolean fBb;
    private PbFakeFloorModel fHw;
    private j fQO;
    private PbFakeFloorModel.a fQR;
    private com.baidu.adp.framework.listener.a fQS;
    private SmallTailInfo fTA;
    private boolean fTB;
    private ArrayList<String> fTC;
    private ConcurrentHashMap<String, ImageUrlData> fTD;
    private boolean fTE;
    private boolean fTF;
    private SubPbRequestMessage fTG;
    private String fTm;
    private boolean fTn;
    private String fTo;
    private String fTp;
    private String fTq;
    private String fTr;
    private boolean fTs;
    private String fTt;
    private a fTu;
    private int fTv;
    private ArrayList<IconData> fTw;
    private AttentionHostData fTx;
    private boolean fTy;
    private ArrayList<j> fTz;
    private boolean isLoading;
    private TbPageContext<?> mContext;
    private int mLoadType;
    private int mOffset;
    public int pageFromType;
    private String postID;
    private String stType;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z, int i, String str, j jVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.fTm = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.fTq = intent.getStringExtra("from_forum_id");
            this.fTr = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.fTn = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fTo = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fTs = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fTp = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fAa = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.fTA = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.fTA != null) {
                this.fTA.updateShowInfo();
            }
            this.aET = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.fTw = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.fTy = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.fTD = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.fTD.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.fTC = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.fTE = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.fTm = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.fTq = bundle.getString("from_forum_id");
            this.fTr = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.fTn = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fTo = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fTs = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fTp = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fAa = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.fTA = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.fTA != null) {
                this.fTA.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.aET = new AntiData();
                this.aET.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.z(stringArrayList)) {
                this.fTw = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.fTw.add(iconData);
                    }
                }
            }
            this.fTy = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void z(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.fTm);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fTn);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.fTo);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.fTp);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.fTs);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fAa);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.fTA));
            if (this.aET != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.aET.toJsonString());
            }
            if (!v.z(this.fTw)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.fTw.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.fTq);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.fTr);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.fTm = null;
        this.postID = null;
        this.stType = null;
        this.fTn = false;
        this.fTo = null;
        this.fTp = null;
        this.pageFromType = 0;
        this.fTs = false;
        this.fBb = false;
        this.fAa = 0;
        this.fTt = null;
        this.mContext = null;
        this.fQO = null;
        this.fTu = null;
        this.fTv = 0;
        this.fTy = false;
        this.fTz = null;
        this.isLoading = false;
        this.cZk = null;
        this.fTE = true;
        this.mOffset = 0;
        this.fHw = null;
        this.fQR = null;
        this.fTF = false;
        this.fQS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.fTz.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.fTz.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.fTz != null && SubPbModel.this.fTz.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.fTz.size() - 1; size >= 0; size--) {
                                j jVar2 = (j) SubPbModel.this.fTz.get(size);
                                if (SubPbModel.this.fTB) {
                                    SubPbModel.this.fQO.c(jVar2, true);
                                } else {
                                    SubPbModel.this.fQO.b(jVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.fTz.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.cZk == null) {
                        SubPbModel.this.cZk = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.cZk != null) {
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
                            SubPbModel.this.cZk.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.cZk = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.cZk = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.fTu != null) {
                                SubPbModel.this.fTu.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                jVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                jVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (jVar.bcp().errorno.intValue() != 0) {
                                if (SubPbModel.this.fTu != null) {
                                    SubPbModel.this.fTu.a(false, jVar.fBc.errorno.intValue(), jVar.fBc.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (jVar.UT() != null && jVar.UT().wm() != null) {
                                jVar.UT().wm().getUserId();
                                if (v.z(jVar.bcq().wm().getIconInfo()) && SubPbModel.this.fTw != null) {
                                    jVar.bcq().wm().setIconInfo(SubPbModel.this.fTw);
                                }
                            }
                            if (jVar.bcq() != null) {
                                SubPbModel.this.postID = jVar.bcq().getId();
                            }
                            if (jVar.UT() != null) {
                                SubPbModel.this.fTm = jVar.UT().getId();
                                SubPbModel.this.fBb = jVar.sR();
                                SubPbModel.this.fTt = jVar.UT().ww();
                            }
                            if (SubPbModel.this.fTt != null && SubPbModel.this.postID != null && SubPbModel.this.fTt.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fBb = true;
                            }
                            if (SubPbModel.this.fTB) {
                                SubPbModel.this.f(jVar);
                            } else {
                                SubPbModel.this.e(jVar);
                            }
                            if (SubPbModel.this.fTu != null) {
                                SubPbModel.this.fTu.a(SubPbModel.this.bio(), error, errorString, SubPbModel.this.fQO);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fTz = new ArrayList<>();
        this.fQO = new j();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.fQS);
        registerListener(this.fQS);
    }

    public String beD() {
        return this.fTm;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Je() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public j bin() {
        return this.fQO;
    }

    public AntiData avt() {
        return this.aET;
    }

    public boolean bio() {
        return (this.fQO == null || this.fQO.bcq() == null) ? false : true;
    }

    public void a(a aVar) {
        this.fTu = aVar;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fTm);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.fTm);
        markData.setFloor(postData.byM());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fQS);
        if (this.fHw != null) {
            this.fHw.unRegisterListener();
        }
        aqW();
    }

    private void aqW() {
        if (this.cZk != null) {
            this.cZk.destory();
            this.cZk = null;
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

    public void sm(String str) {
        if (!TextUtils.isEmpty(str) && this.fQO != null && this.fQO.bcu() != null) {
            ArrayList<PostData> bcu = this.fQO.bcu();
            int size = bcu.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bcu.get(i).getId())) {
                    bcu.remove(i);
                    this.fTv++;
                    this.fQO.setTotalCount(this.fQO.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bip() {
        int QP = this.fQO.QP();
        if (QP == 0) {
            return QP + 1;
        }
        if (this.mLoadType == 0) {
            return QP + 1;
        }
        if (this.mLoadType == 2 && this.fQO.bcu().size() != 0 && this.fQO.bcu().size() % this.fQO.bcw() == 0) {
            return QP + 1;
        }
        if (this.mLoadType == 3 && this.fTB) {
            return this.fQO.bcs() - 1;
        }
        if (this.mLoadType == 3 && QP > 0) {
            return this.fQO.bcr() - 1;
        }
        return QP;
    }

    private SubPbRequestMessage bhB() {
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
            intValue = bip();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.fTB && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.fTm), j, j2, i, aO, aQ, f, this.stType, i2);
    }

    public boolean Ll() {
        return ry(0);
    }

    public boolean biq() {
        return ry(2);
    }

    public void bir() {
        int bcw;
        if (this.fTv > 0 && this.fQO != null && (bcw = this.fQO.bcw()) > 0) {
            int QP = this.fQO.QP();
            for (int i = (((this.fTv + bcw) - 1) / bcw) - 1; i >= 0; i--) {
                this.fTG = p(Integer.valueOf(QP - i));
                this.fTG.setTreatDelPage(true);
                sendMessage(this.fTG);
            }
        }
        this.fTv = 0;
    }

    public boolean bis() {
        return ry(1);
    }

    public boolean ry(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.fTm == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bir();
        this.mLoadType = i;
        this.fTG = bhB();
        sendMessage(this.fTG);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(j jVar) {
        ArrayList<PostData> bcu = jVar.bcu();
        if (bcu == null || bcu.size() == 0) {
            jVar.cj(this.fQO.QP());
        }
        if (this.mLoadType == 1) {
            this.fQO = jVar;
        } else if (this.mLoadType == 2) {
            this.fQO.b(jVar, true);
        } else if (this.mLoadType == 3) {
            this.fQO.a(jVar, false);
        } else {
            this.fQO.b(jVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(j jVar) {
        if (this.mLoadType == 1) {
            this.fQO = jVar;
            this.fQO.bct();
        } else if (this.mLoadType == 2) {
            this.fQO.c(jVar, true);
        } else if (this.mLoadType == 3) {
            this.fQO.d(jVar, false);
        } else {
            this.fQO.a(jVar);
        }
    }

    public boolean bhS() {
        return this.fTn;
    }

    public boolean isMarked() {
        return this.fBb;
    }

    public boolean bit() {
        return "hot_topic".equals(getStType());
    }

    public void li(boolean z) {
        this.fBb = z;
    }

    public int bbV() {
        return this.fAa;
    }

    public String biu() {
        return this.fTt;
    }

    public void sn(String str) {
        this.fTt = str;
    }

    public String biv() {
        return this.fTp;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hd(String str) {
        if (this.fQO == null || this.fQO.bcx() == null || this.fQO.UT() == null || this.fQO.bcq() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.fQO.bcx().getName());
        writeData.setForumId(this.fQO.bcx().getId());
        writeData.setFromForumId(this.fTr);
        writeData.setFloor(this.fQO.bcq().getId());
        writeData.setType(2);
        writeData.setThreadId(this.fQO.UT().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Jd() {
        biq();
        return true;
    }

    public boolean biw() {
        return this.fTF;
    }

    public void lj(boolean z) {
        this.fTF = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.fQR = aVar;
    }

    public SmallTailInfo bix() {
        return this.fTA;
    }

    public boolean biy() {
        return this.fTy;
    }

    public ConcurrentHashMap<String, ImageUrlData> biz() {
        return this.fTD;
    }

    public ArrayList<String> biA() {
        return this.fTC;
    }

    public boolean biB() {
        return this.fTE;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.fTq;
    }

    public AttentionHostData biC() {
        if (this.fTx == null) {
            this.fTx = new AttentionHostData();
            if (this.fQO != null && this.fQO.UT() != null && this.fQO.UT().wm() != null) {
                this.fTx.parserWithMetaData(this.fQO.UT().wm());
            }
        }
        return this.fTx;
    }
}
