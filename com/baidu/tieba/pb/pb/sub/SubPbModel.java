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
/* loaded from: classes2.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private TbPageContext<?> aQs;
    private com.baidu.tieba.tbadkCore.d.b dnn;
    private int fDL;
    private AntiData fEP;
    private boolean fEQ;
    private PbFakeFloorModel fLV;
    private m fVh;
    private PbFakeFloorModel.a fVk;
    private com.baidu.adp.framework.listener.a fVl;
    private boolean fXF;
    private String fXG;
    private String fXH;
    private String fXI;
    private boolean fXJ;
    private String fXK;
    private a fXL;
    private int fXM;
    private ArrayList<IconData> fXN;
    private boolean fXO;
    private ArrayList<m> fXP;
    private SmallTailInfo fXQ;
    private boolean fXR;
    private ArrayList<String> fXS;
    private ConcurrentHashMap<String, ImageUrlData> fXT;
    private boolean fXU;
    private boolean fXV;
    private SubPbRequestMessage fXW;
    private boolean isLoading;
    private int mLoadType;
    private int mOffset;
    public int pageFromType;
    private String postID;
    private String stType;
    private String threadID;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z, int i, String str, m mVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.fXI = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fXF = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fXG = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fXJ = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fXH = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fDL = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.fXQ = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.fXQ != null) {
                this.fXQ.updateShowInfo();
            }
            this.fEP = (AntiData) intent.getSerializableExtra("anti");
            this.fXN = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.fXO = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.fXT = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.fXT.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.fXS = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.fXU = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
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
            this.fXI = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fXF = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fXG = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fXJ = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fXH = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fDL = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.fXQ = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.fXQ != null) {
                this.fXQ.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.fEP = new AntiData();
                this.fEP.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.E(stringArrayList)) {
                this.fXN = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.fXN.add(iconData);
                    }
                }
            }
            this.fXO = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void x(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fXF);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.fXG);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.fXH);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.fXJ);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fDL);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.fXQ));
            if (this.fEP != null) {
                bundle.putSerializable("anti", this.fEP.toJsonString());
            }
            if (!v.E(this.fXN)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.fXN.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.fXI);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.fXF = false;
        this.fXG = null;
        this.fXH = null;
        this.pageFromType = 0;
        this.fXJ = false;
        this.fEQ = false;
        this.fDL = 0;
        this.fXK = null;
        this.aQs = null;
        this.fVh = null;
        this.fXL = null;
        this.fXM = 0;
        this.fXO = false;
        this.fXP = null;
        this.isLoading = false;
        this.dnn = null;
        this.fXU = true;
        this.mOffset = 0;
        this.fLV = null;
        this.fVk = null;
        this.fXV = false;
        this.fVl = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.aQs.getPageActivity().finish();
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
                    if (SubPbModel.this.fXP != null && SubPbModel.this.fXP.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.fXP.size() - 1; size >= 0; size--) {
                                m mVar2 = (m) SubPbModel.this.fXP.get(size);
                                if (SubPbModel.this.fXR) {
                                    SubPbModel.this.fVh.c(mVar2, true);
                                } else {
                                    SubPbModel.this.fVh.b(mVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.fXP.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.dnn == null) {
                        SubPbModel.this.dnn = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.dnn != null) {
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
                            SubPbModel.this.dnn.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.dnn = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.dnn = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.fXL != null) {
                                SubPbModel.this.fXL.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                mVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                mVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (mVar.aZx().errorno.intValue() != 0) {
                                if (SubPbModel.this.fXL != null) {
                                    SubPbModel.this.fXL.a(false, mVar.fER.errorno.intValue(), mVar.fER.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (mVar.VM() != null && mVar.VM().yT() != null) {
                                str = mVar.VM().yT().getUserId();
                                if (v.E(mVar.aZy().yT().getIconInfo()) && SubPbModel.this.fXN != null) {
                                    mVar.aZy().yT().setIconInfo(SubPbModel.this.fXN);
                                }
                            }
                            if (!SubPbModel.this.fXR) {
                                for (int i2 = 0; i2 < mVar.aZC().size(); i2++) {
                                    mVar.aZC().get(i2).b(SubPbModel.this.aQs, str.equals(mVar.aZC().get(i2).yT().getUserId()));
                                }
                            }
                            if (mVar.aZy() != null) {
                                SubPbModel.this.postID = mVar.aZy().getId();
                            }
                            if (mVar.VM() != null) {
                                SubPbModel.this.threadID = mVar.VM().getId();
                                SubPbModel.this.fEQ = mVar.vl();
                                SubPbModel.this.fXK = mVar.VM().zd();
                            }
                            if (SubPbModel.this.fXK != null && SubPbModel.this.postID != null && SubPbModel.this.fXK.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fEQ = true;
                            }
                            if (SubPbModel.this.fXR) {
                                SubPbModel.this.f(mVar);
                            } else {
                                SubPbModel.this.e(mVar);
                            }
                            if (SubPbModel.this.fXL != null) {
                                SubPbModel.this.fXL.a(SubPbModel.this.bfq(), error, errorString, SubPbModel.this.fVh);
                            }
                        }
                    }
                }
            }
        };
        this.aQs = tbPageContext;
        this.fXP = new ArrayList<>();
        this.fVh = new m();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.fVl);
        registerListener(this.fVl);
    }

    public String bbK() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String KQ() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public m bfp() {
        return this.fVh;
    }

    public AntiData aZG() {
        return this.fEP;
    }

    public boolean bfq() {
        return (this.fVh == null || this.fVh.aZy() == null) ? false : true;
    }

    public void a(a aVar) {
        this.fXL = aVar;
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
        markData.setFloor(postData.bvJ());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fVl);
        if (this.fLV != null) {
            this.fLV.unRegisterListener();
        }
        aqd();
    }

    private void aqd() {
        if (this.dnn != null) {
            this.dnn.destory();
            this.dnn = null;
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

    public void qD(String str) {
        if (!TextUtils.isEmpty(str) && this.fVh != null && this.fVh.aZC() != null) {
            ArrayList<PostData> aZC = this.fVh.aZC();
            int size = aZC.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aZC.get(i).getId())) {
                    aZC.remove(i);
                    this.fXM++;
                    this.fVh.setTotalCount(this.fVh.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bfr() {
        int RY = this.fVh.RY();
        if (RY == 0) {
            return RY + 1;
        }
        if (this.mLoadType == 0) {
            return RY + 1;
        }
        if (this.mLoadType == 2 && this.fVh.aZC().size() != 0 && this.fVh.aZC().size() % this.fVh.aZE() == 0) {
            return RY + 1;
        }
        if (this.mLoadType == 3 && this.fXR) {
            return this.fVh.aZA() - 1;
        }
        if (this.mLoadType == 3 && RY > 0) {
            return this.fVh.aZz() - 1;
        }
        return RY;
    }

    private SubPbRequestMessage beF() {
        this.isLoading = true;
        return i((Integer) null);
    }

    private SubPbRequestMessage i(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ao = l.ao(TbadkCoreApplication.getInst().getApp());
        int aq = l.aq(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = bfr();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.fXR && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.aQs.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, ao, aq, f, this.stType, i2);
    }

    public boolean MQ() {
        return ti(0);
    }

    public boolean bfs() {
        return ti(2);
    }

    public void bft() {
        int aZE;
        if (this.fXM > 0 && this.fVh != null && (aZE = this.fVh.aZE()) > 0) {
            int RY = this.fVh.RY();
            for (int i = (((this.fXM + aZE) - 1) / aZE) - 1; i >= 0; i--) {
                this.fXW = i(Integer.valueOf(RY - i));
                this.fXW.setTreatDelPage(true);
                sendMessage(this.fXW);
            }
        }
        this.fXM = 0;
    }

    public boolean bfu() {
        return ti(1);
    }

    public boolean ti(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bft();
        this.mLoadType = i;
        this.fXW = beF();
        sendMessage(this.fXW);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        ArrayList<PostData> aZC = mVar.aZC();
        if (aZC == null || aZC.size() == 0) {
            mVar.eW(this.fVh.RY());
        }
        if (this.mLoadType == 1) {
            this.fVh = mVar;
        } else if (this.mLoadType == 2) {
            this.fVh.b(mVar, true);
        } else if (this.mLoadType == 3) {
            this.fVh.a(mVar, false);
        } else {
            this.fVh.b(mVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(m mVar) {
        if (this.mLoadType == 1) {
            this.fVh = mVar;
            this.fVh.aZB();
        } else if (this.mLoadType == 2) {
            this.fVh.c(mVar, true);
        } else if (this.mLoadType == 3) {
            this.fVh.d(mVar, false);
        } else {
            this.fVh.a(mVar);
        }
    }

    public void g(m mVar) {
        String str;
        if (mVar.VM() == null || mVar.VM().yT() == null) {
            str = null;
        } else {
            str = mVar.VM().yT().getUserId();
        }
        if (!this.fXR) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= mVar.aZC().size()) {
                    break;
                }
                mVar.aZC().get(i2).b(this.aQs, str.equals(mVar.aZC().get(i2).yT().getUserId()));
                i = i2 + 1;
            }
        }
        this.fXP.add(mVar);
    }

    public boolean beT() {
        return this.fXF;
    }

    public boolean isMarked() {
        return this.fEQ;
    }

    public boolean bfv() {
        return "hot_topic".equals(getStType());
    }

    public void kZ(boolean z) {
        this.fEQ = z;
    }

    public int aYX() {
        return this.fDL;
    }

    public String bfw() {
        return this.fXK;
    }

    public void qE(String str) {
        this.fXK = str;
    }

    public String bfx() {
        return this.fXH;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gi(String str) {
        if (this.fVh == null || this.fVh.aZF() == null || this.fVh.VM() == null || this.fVh.aZy() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.fVh.aZF().getName());
        writeData.setForumId(this.fVh.aZF().getId());
        writeData.setFloor(this.fVh.aZy().getId());
        writeData.setType(2);
        writeData.setThreadId(this.fVh.VM().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean KP() {
        if (this.fXV) {
            bfz();
        } else {
            bfs();
        }
        return true;
    }

    public boolean bfy() {
        return this.fXV;
    }

    public void la(boolean z) {
        this.fXV = z;
    }

    private void bfz() {
        if (this.fLV == null) {
            this.fLV = new PbFakeFloorModel(this.aQs);
            this.fLV.setUniqueId(BdUniqueId.gen());
            this.fLV.d(this.fVh);
            this.fLV.setPostId(this.postID);
            this.fLV.a(this.fVk);
        }
        this.fLV.beE();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.fVk = aVar;
    }

    public SmallTailInfo bfA() {
        return this.fXQ;
    }

    public boolean bfB() {
        return this.fXO;
    }

    public ConcurrentHashMap<String, ImageUrlData> bfC() {
        return this.fXT;
    }

    public ArrayList<String> bfD() {
        return this.fXS;
    }

    public boolean bfE() {
        return this.fXU;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String bfF() {
        return this.fXI;
    }
}
