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
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
/* loaded from: classes.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private TbPageContext<?> acd;
    private com.baidu.tieba.tbadkCore.d.b ctH;
    private int eOm;
    private AntiData ePl;
    private boolean ePm;
    private PbFakeFloorModel eWe;
    private m ffn;
    private PbFakeFloorModel.a ffq;
    private com.baidu.adp.framework.listener.a ffr;
    private boolean fhJ;
    private String fhK;
    private String fhL;
    private String fhM;
    private boolean fhN;
    private String fhO;
    private a fhP;
    private int fhQ;
    private ArrayList<IconData> fhR;
    private boolean fhS;
    private ArrayList<m> fhT;
    private SmallTailInfo fhU;
    private boolean fhV;
    private ArrayList<String> fhW;
    private ConcurrentHashMap<String, ImageUrlData> fhX;
    private boolean fhY;
    private boolean fhZ;
    private SubPbRequestMessage fia;
    private boolean isLoading;
    private int mLoadType;
    private int mOffset;
    public int pageFromType;
    private String postID;
    private String stType;
    private String threadID;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, String str, m mVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.fhM = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fhJ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fhK = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fhN = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fhL = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eOm = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.fhU = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.fhU != null) {
                this.fhU.updateShowInfo();
            }
            this.ePl = (AntiData) intent.getSerializableExtra("anti");
            this.fhR = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.fhS = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.fhX = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.fhX.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.fhW = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.fhY = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.fhM = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fhJ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fhK = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fhN = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fhL = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eOm = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.fhU = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.fhU != null) {
                this.fhU.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.ePl = new AntiData();
                this.ePl.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.w(stringArrayList)) {
                this.fhR = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.fhR.add(iconData);
                    }
                }
            }
            this.fhS = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void u(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fhJ);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.fhK);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.fhL);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.fhN);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.eOm);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.fhU));
            if (this.ePl != null) {
                bundle.putSerializable("anti", this.ePl.toJsonString());
            }
            if (!v.w(this.fhR)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.fhR.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.fhM);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.fhJ = false;
        this.fhK = null;
        this.fhL = null;
        this.pageFromType = 0;
        this.fhN = false;
        this.ePm = false;
        this.eOm = 0;
        this.fhO = null;
        this.acd = null;
        this.ffn = null;
        this.fhP = null;
        this.fhQ = 0;
        this.fhS = false;
        this.fhT = null;
        this.isLoading = false;
        this.ctH = null;
        this.fhY = true;
        this.mOffset = 0;
        this.eWe = null;
        this.ffq = null;
        this.fhZ = false;
        this.ffr = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                boolean z;
                m mVar;
                long j2;
                long j3;
                long j4 = 0;
                String str = null;
                if (SubPbModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    SubPbModel.this.isLoading = false;
                    if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                        SubPbModel.this.acd.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.g(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.g(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.fhT != null && SubPbModel.this.fhT.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.fhT.size() - 1; size >= 0; size--) {
                                m mVar2 = (m) SubPbModel.this.fhT.get(size);
                                if (SubPbModel.this.fhV) {
                                    SubPbModel.this.ffn.c(mVar2, true);
                                } else {
                                    SubPbModel.this.ffn.b(mVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.fhT.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.ctH == null) {
                        SubPbModel.this.ctH = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.ctH != null) {
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
                            SubPbModel.this.ctH.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.ctH = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.ctH = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.fhP != null) {
                                SubPbModel.this.fhP.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                mVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (mVar.aRS().errorno.intValue() != 0) {
                                if (SubPbModel.this.fhP != null) {
                                    SubPbModel.this.fhP.a(false, mVar.ePn.errorno.intValue(), mVar.ePn.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (mVar.Ox() != null && mVar.Ox().rx() != null) {
                                str = mVar.Ox().rx().getUserId();
                                if (v.w(mVar.aRT().rx().getIconInfo()) && SubPbModel.this.fhR != null) {
                                    mVar.aRT().rx().setIconInfo(SubPbModel.this.fhR);
                                }
                            }
                            if (!SubPbModel.this.fhV) {
                                for (int i2 = 0; i2 < mVar.aRX().size(); i2++) {
                                    mVar.aRX().get(i2).b(SubPbModel.this.acd, str.equals(mVar.aRX().get(i2).rx().getUserId()));
                                }
                            }
                            if (mVar.aRT() != null) {
                                SubPbModel.this.postID = mVar.aRT().getId();
                            }
                            if (mVar.Ox() != null) {
                                SubPbModel.this.threadID = mVar.Ox().getId();
                                SubPbModel.this.ePm = mVar.nJ();
                                SubPbModel.this.fhO = mVar.Ox().rH();
                            }
                            if (SubPbModel.this.fhO != null && SubPbModel.this.postID != null && SubPbModel.this.fhO.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.ePm = true;
                            }
                            if (SubPbModel.this.fhV) {
                                SubPbModel.this.f(mVar);
                            } else {
                                SubPbModel.this.e(mVar);
                            }
                            if (SubPbModel.this.fhP != null) {
                                SubPbModel.this.fhP.a(SubPbModel.this.aXJ(), error, errorString, SubPbModel.this.ffn);
                            }
                        }
                    }
                }
            }
        };
        this.acd = tbPageContext;
        this.fhT = new ArrayList<>();
        this.ffn = new m();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.ffr);
        registerListener(this.ffr);
    }

    public String aUe() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dx() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public m aXI() {
        return this.ffn;
    }

    public AntiData aSb() {
        return this.ePl;
    }

    public boolean aXJ() {
        return (this.ffn == null || this.ffn.aRT() == null) ? false : true;
    }

    public void a(a aVar) {
        this.fhP = aVar;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(postData.bwo());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.ffr);
        if (this.eWe != null) {
            this.eWe.unRegisterListener();
        }
        ahn();
    }

    private void ahn() {
        if (this.ctH != null) {
            this.ctH.destory();
            this.ctH = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    public int getLoadType() {
        return this.mLoadType;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void qi(String str) {
        if (!TextUtils.isEmpty(str) && this.ffn != null && this.ffn.aRX() != null) {
            ArrayList<PostData> aRX = this.ffn.aRX();
            int size = aRX.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aRX.get(i).getId())) {
                    aRX.remove(i);
                    this.fhQ++;
                    this.ffn.setTotalCount(this.ffn.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aXK() {
        int KJ = this.ffn.KJ();
        if (KJ == 0) {
            return KJ + 1;
        }
        if (this.mLoadType == 0) {
            return KJ + 1;
        }
        if (this.mLoadType == 2 && this.ffn.aRX().size() != 0 && this.ffn.aRX().size() % this.ffn.aRZ() == 0) {
            return KJ + 1;
        }
        if (this.mLoadType == 3 && this.fhV) {
            return this.ffn.aRV() - 1;
        }
        if (this.mLoadType == 3 && KJ > 0) {
            return this.ffn.aRU() - 1;
        }
        return KJ;
    }

    private SubPbRequestMessage aXa() {
        this.isLoading = true;
        return i((Integer) null);
    }

    private SubPbRequestMessage i(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ac = l.ac(TbadkCoreApplication.getInst().getApp());
        int ae = l.ae(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = aXK();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.fhV && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.acd.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, ac, ae, f, this.stType, i2);
    }

    public boolean Fy() {
        return qp(0);
    }

    public boolean aXL() {
        return qp(2);
    }

    public void aXM() {
        int aRZ;
        if (this.fhQ > 0 && this.ffn != null && (aRZ = this.ffn.aRZ()) > 0) {
            int KJ = this.ffn.KJ();
            for (int i = (((this.fhQ + aRZ) - 1) / aRZ) - 1; i >= 0; i--) {
                this.fia = i(Integer.valueOf(KJ - i));
                this.fia.setTreatDelPage(true);
                sendMessage(this.fia);
            }
        }
        this.fhQ = 0;
    }

    public boolean aXN() {
        return qp(1);
    }

    public boolean aXO() {
        return qp(3);
    }

    public boolean qp(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        aXM();
        this.mLoadType = i;
        this.fia = aXa();
        sendMessage(this.fia);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        ArrayList<PostData> aRX = mVar.aRX();
        if (aRX == null || aRX.size() == 0) {
            mVar.bY(this.ffn.KJ());
        }
        if (this.mLoadType == 1) {
            this.ffn = mVar;
        } else if (this.mLoadType == 2) {
            this.ffn.b(mVar, true);
        } else if (this.mLoadType == 3) {
            this.ffn.a(mVar, false);
        } else {
            this.ffn.b(mVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(m mVar) {
        if (this.mLoadType == 1) {
            this.ffn = mVar;
            this.ffn.aRW();
        } else if (this.mLoadType == 2) {
            this.ffn.c(mVar, true);
        } else if (this.mLoadType == 3) {
            this.ffn.d(mVar, false);
        } else {
            this.ffn.a(mVar);
        }
    }

    public void g(m mVar) {
        String str;
        if (mVar.Ox() == null || mVar.Ox().rx() == null) {
            str = null;
        } else {
            str = mVar.Ox().rx().getUserId();
        }
        if (!this.fhV) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mVar.aRX().size()) {
                    break;
                }
                mVar.aRX().get(i2).b(this.acd, str.equals(mVar.aRX().get(i2).rx().getUserId()));
                i = i2 + 1;
            }
        }
        this.fhT.add(mVar);
    }

    public boolean aXm() {
        return this.fhJ;
    }

    public boolean isMarked() {
        return this.ePm;
    }

    public boolean aXP() {
        return "hot_topic".equals(getStType());
    }

    public void kp(boolean z) {
        this.ePm = z;
    }

    public int aRs() {
        return this.eOm;
    }

    public String aXQ() {
        return this.fhO;
    }

    public void qj(String str) {
        this.fhO = str;
    }

    public boolean aXR() {
        return this.fhN;
    }

    public String aXS() {
        return this.fhL;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fT(String str) {
        if (this.ffn == null || this.ffn.aSa() == null || this.ffn.Ox() == null || this.ffn.aRT() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.ffn.aSa().getName());
        writeData.setForumId(this.ffn.aSa().getId());
        writeData.setFloor(this.ffn.aRT().getId());
        writeData.setType(2);
        writeData.setThreadId(this.ffn.Ox().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dw() {
        if (this.fhZ) {
            aXU();
        } else {
            aXL();
        }
        return true;
    }

    public boolean aXT() {
        return this.fhZ;
    }

    public void kq(boolean z) {
        this.fhZ = z;
    }

    private void aXU() {
        if (this.eWe == null) {
            this.eWe = new PbFakeFloorModel(this.acd);
            this.eWe.setUniqueId(BdUniqueId.gen());
            this.eWe.d(this.ffn);
            this.eWe.setPostId(this.postID);
            this.eWe.a(this.ffq);
        }
        this.eWe.aWZ();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.ffq = aVar;
    }

    public boolean aXV() {
        return this.fhV;
    }

    public void kr(boolean z) {
        this.fhV = z;
    }

    public SmallTailInfo aXW() {
        return this.fhU;
    }

    public boolean aXX() {
        return this.fhS;
    }

    public ConcurrentHashMap<String, ImageUrlData> aXY() {
        return this.fhX;
    }

    public ArrayList<String> aXZ() {
        return this.fhW;
    }

    public boolean aYa() {
        return this.fhY;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String aYb() {
        return this.fhM;
    }
}
