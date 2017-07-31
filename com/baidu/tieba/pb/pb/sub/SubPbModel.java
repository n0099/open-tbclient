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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.data.n;
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
    private TbPageContext<?> acp;
    private com.baidu.tieba.tbadkCore.d.b bYX;
    private int eDQ;
    private AntiData eEL;
    private boolean eEM;
    private PbFakeFloorModel eKG;
    private n eUh;
    private PbFakeFloorModel.a eUk;
    private com.baidu.adp.framework.listener.a eUl;
    private boolean eWA;
    private ArrayList<n> eWB;
    private SmallTailInfo eWC;
    private boolean eWD;
    private ArrayList<String> eWE;
    private ConcurrentHashMap<String, ImageUrlData> eWF;
    private boolean eWG;
    private boolean eWH;
    private SubPbRequestMessage eWI;
    private boolean eWr;
    private String eWs;
    private String eWt;
    private String eWu;
    private boolean eWv;
    private String eWw;
    private a eWx;
    private int eWy;
    private ArrayList<IconData> eWz;
    private boolean isLoading;
    private int mLoadType;
    private int mOffset;
    private String postID;
    private String stType;
    private String threadID;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z, int i, String str, n nVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.eWu = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.eWr = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eWs = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eWv = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eWt = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eDQ = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.eWC = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.eWC != null) {
                this.eWC.updateShowInfo();
            }
            this.eEL = (AntiData) intent.getSerializableExtra("anti");
            this.eWz = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.eWA = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.eWF = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.eWF.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.eWE = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.eWG = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.eWu = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.eWr = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eWs = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eWv = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eWt = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eDQ = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.eWC = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.eWC != null) {
                this.eWC.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.eEL = new AntiData();
                this.eEL.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!u.v(stringArrayList)) {
                this.eWz = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.eWz.add(iconData);
                    }
                }
            }
            this.eWA = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void r(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.eWr);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.eWs);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.eWt);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.eWv);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.eDQ);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.eWC));
            if (this.eEL != null) {
                bundle.putSerializable("anti", this.eEL.toJsonString());
            }
            if (!u.v(this.eWz)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.eWz.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.eWu);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.eWr = false;
        this.eWs = null;
        this.eWt = null;
        this.eWv = false;
        this.eEM = false;
        this.eDQ = 0;
        this.eWw = null;
        this.acp = null;
        this.eUh = null;
        this.eWx = null;
        this.eWy = 0;
        this.eWA = false;
        this.eWB = null;
        this.isLoading = false;
        this.bYX = null;
        this.eWG = true;
        this.mOffset = 0;
        this.eKG = null;
        this.eUk = null;
        this.eWH = false;
        this.eUl = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                boolean z;
                n nVar;
                long j2;
                long j3;
                long j4 = 0;
                String str = null;
                if (SubPbModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    SubPbModel.this.isLoading = false;
                    if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                        SubPbModel.this.acp.getPageActivity().finish();
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
                        ((SubPbSocketResponseMessage) responsedMessage).getDownSize();
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
                    if (SubPbModel.this.eWB != null && SubPbModel.this.eWB.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.eWB.size() - 1; size >= 0; size--) {
                                n nVar2 = (n) SubPbModel.this.eWB.get(size);
                                if (SubPbModel.this.eWD) {
                                    SubPbModel.this.eUh.c(nVar2, true);
                                } else {
                                    SubPbModel.this.eUh.b(nVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.eWB.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.bYX == null) {
                        SubPbModel.this.bYX = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.bYX != null) {
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
                            SubPbModel.this.bYX.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.bYX = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.bYX = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.eWx != null) {
                                SubPbModel.this.eWx.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                nVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                nVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (nVar.aPQ().errorno.intValue() != 0) {
                                if (SubPbModel.this.eWx != null) {
                                    SubPbModel.this.eWx.a(false, nVar.eEN.errorno.intValue(), nVar.eEN.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (nVar.MF() != null && nVar.MF().getAuthor() != null) {
                                str = nVar.MF().getAuthor().getUserId();
                                if (u.v(nVar.aPR().getAuthor().getIconInfo()) && SubPbModel.this.eWz != null) {
                                    nVar.aPR().getAuthor().setIconInfo(SubPbModel.this.eWz);
                                }
                            }
                            if (!SubPbModel.this.eWD) {
                                for (int i2 = 0; i2 < nVar.aPV().size(); i2++) {
                                    nVar.aPV().get(i2).a(SubPbModel.this.acp, str.equals(nVar.aPV().get(i2).getAuthor().getUserId()));
                                }
                            }
                            if (nVar.aPR() != null) {
                                SubPbModel.this.postID = nVar.aPR().getId();
                            }
                            if (nVar.MF() != null) {
                                SubPbModel.this.threadID = nVar.MF().getId();
                                SubPbModel.this.eEM = nVar.nL();
                                SubPbModel.this.eWw = nVar.MF().rO();
                            }
                            if (SubPbModel.this.eWw != null && SubPbModel.this.postID != null && SubPbModel.this.eWw.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.eEM = true;
                            }
                            if (SubPbModel.this.eWD) {
                                SubPbModel.this.f(nVar);
                            } else {
                                SubPbModel.this.e(nVar);
                            }
                            if (SubPbModel.this.eWx != null) {
                                SubPbModel.this.eWx.a(SubPbModel.this.aVv(), error, errorString, SubPbModel.this.eUh);
                            }
                        }
                    }
                }
            }
        };
        this.acp = tbPageContext;
        this.eWB = new ArrayList<>();
        this.eUh = new n();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.eUl);
        registerListener(this.eUl);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dv() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public n aVu() {
        return this.eUh;
    }

    public AntiData aAV() {
        return this.eEL;
    }

    public boolean aVv() {
        return (this.eUh == null || this.eUh.aPR() == null) ? false : true;
    }

    public void a(a aVar) {
        this.eWx = aVar;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(postData.bsy());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.eUl);
        if (this.eKG != null) {
            this.eKG.unRegisterListener();
        }
        abU();
    }

    private void abU() {
        if (this.bYX != null) {
            this.bYX.destory();
            this.bYX = null;
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

    public void pJ(String str) {
        if (!TextUtils.isEmpty(str) && this.eUh != null && this.eUh.aPV() != null) {
            ArrayList<PostData> aPV = this.eUh.aPV();
            int size = aPV.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aPV.get(i).getId())) {
                    aPV.remove(i);
                    this.eWy++;
                    this.eUh.setTotalCount(this.eUh.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aVw() {
        int JG = this.eUh.JG();
        if (JG == 0) {
            return JG + 1;
        }
        if (this.mLoadType == 0) {
            return JG + 1;
        }
        if (this.mLoadType == 2 && this.eUh.aPV().size() != 0 && this.eUh.aPV().size() % this.eUh.aPW() == 0) {
            return JG + 1;
        }
        if (this.mLoadType == 3 && this.eWD) {
            return this.eUh.aPT() - 1;
        }
        if (this.mLoadType == 3 && JG > 0) {
            return this.eUh.aPS() - 1;
        }
        return JG;
    }

    private SubPbRequestMessage aUE() {
        this.isLoading = true;
        return g((Integer) null);
    }

    private SubPbRequestMessage g(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ag = k.ag(TbadkCoreApplication.getInst().getApp());
        int ah = k.ah(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.d(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.d(this.postID, 0L);
        }
        if (num == null) {
            intValue = aVw();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.eWD && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.acp.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, ag, ah, f, this.stType, i2);
    }

    public boolean Fw() {
        return pB(0);
    }

    public boolean aVx() {
        return pB(2);
    }

    public void aVy() {
        int aPW;
        if (this.eWy > 0 && this.eUh != null && (aPW = this.eUh.aPW()) > 0) {
            int JG = this.eUh.JG();
            for (int i = (((this.eWy + aPW) - 1) / aPW) - 1; i >= 0; i--) {
                this.eWI = g(Integer.valueOf(JG - i));
                this.eWI.setTreatDelPage(true);
                sendMessage(this.eWI);
            }
        }
        this.eWy = 0;
    }

    public boolean aVz() {
        return pB(1);
    }

    public boolean aVA() {
        return pB(3);
    }

    public boolean pB(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        aVy();
        this.mLoadType = i;
        this.eWI = aUE();
        sendMessage(this.eWI);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(n nVar) {
        ArrayList<PostData> aPV = nVar.aPV();
        if (aPV == null || aPV.size() == 0) {
            nVar.bX(this.eUh.JG());
        }
        if (this.mLoadType == 1) {
            this.eUh = nVar;
        } else if (this.mLoadType == 2) {
            this.eUh.b(nVar, true);
        } else if (this.mLoadType == 3) {
            this.eUh.a(nVar, false);
        } else {
            this.eUh.b(nVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(n nVar) {
        if (this.mLoadType == 1) {
            this.eUh = nVar;
            this.eUh.aPU();
        } else if (this.mLoadType == 2) {
            this.eUh.c(nVar, true);
        } else if (this.mLoadType == 3) {
            this.eUh.d(nVar, false);
        } else {
            this.eUh.a(nVar);
        }
    }

    public void g(n nVar) {
        String str;
        if (nVar.MF() == null || nVar.MF().getAuthor() == null) {
            str = null;
        } else {
            str = nVar.MF().getAuthor().getUserId();
        }
        if (!this.eWD) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= nVar.aPV().size()) {
                    break;
                }
                nVar.aPV().get(i2).a(this.acp, str.equals(nVar.aPV().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.eWB.add(nVar);
    }

    public boolean aUW() {
        return this.eWr;
    }

    public boolean isMarked() {
        return this.eEM;
    }

    public boolean aVB() {
        return "hot_topic".equals(getStType());
    }

    public void jy(boolean z) {
        this.eEM = z;
    }

    public int aPu() {
        return this.eDQ;
    }

    public String aVC() {
        return this.eWw;
    }

    public void pK(String str) {
        this.eWw = str;
    }

    public boolean aVD() {
        return this.eWv;
    }

    public String aVE() {
        return this.eWt;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fS(String str) {
        if (this.eUh == null || this.eUh.aPX() == null || this.eUh.MF() == null || this.eUh.aPR() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.eUh.aPX().getName());
        writeData.setForumId(this.eUh.aPX().getId());
        writeData.setFloor(this.eUh.aPR().getId());
        writeData.setType(2);
        writeData.setThreadId(this.eUh.MF().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Du() {
        if (this.eWH) {
            aVG();
        } else {
            aVx();
        }
        return true;
    }

    public boolean aVF() {
        return this.eWH;
    }

    public void kb(boolean z) {
        this.eWH = z;
    }

    private void aVG() {
        if (this.eKG == null) {
            this.eKG = new PbFakeFloorModel(this.acp);
            this.eKG.setUniqueId(BdUniqueId.gen());
            this.eKG.d(this.eUh);
            this.eKG.setPostId(this.postID);
            this.eKG.a(this.eUk);
        }
        this.eKG.aUD();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.eUk = aVar;
    }

    public boolean aVH() {
        return this.eWD;
    }

    public void kc(boolean z) {
        this.eWD = z;
    }

    public SmallTailInfo aVI() {
        return this.eWC;
    }

    public boolean aVJ() {
        return this.eWA;
    }

    public ConcurrentHashMap<String, ImageUrlData> aVK() {
        return this.eWF;
    }

    public ArrayList<String> aVL() {
        return this.eWE;
    }

    public boolean aVM() {
        return this.eWG;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String aVN() {
        return this.eWu;
    }
}
