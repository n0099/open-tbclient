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
    private TbPageContext<?> aaS;
    private com.baidu.tieba.tbadkCore.d.b bXR;
    private int eCD;
    private AntiData eDy;
    private boolean eDz;
    private PbFakeFloorModel eJt;
    private n eSU;
    private PbFakeFloorModel.a eSX;
    private com.baidu.adp.framework.listener.a eSY;
    private boolean eVe;
    private String eVf;
    private String eVg;
    private String eVh;
    private boolean eVi;
    private String eVj;
    private a eVk;
    private int eVl;
    private ArrayList<IconData> eVm;
    private boolean eVn;
    private ArrayList<n> eVo;
    private SmallTailInfo eVp;
    private boolean eVq;
    private ArrayList<String> eVr;
    private ConcurrentHashMap<String, ImageUrlData> eVs;
    private boolean eVt;
    private boolean eVu;
    private SubPbRequestMessage eVv;
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
            this.eVh = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.eVe = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eVf = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eVi = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eVg = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eCD = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.eVp = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.eVp != null) {
                this.eVp.updateShowInfo();
            }
            this.eDy = (AntiData) intent.getSerializableExtra("anti");
            this.eVm = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.eVn = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.eVs = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.eVs.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.eVr = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.eVt = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.eVh = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.eVe = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eVf = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eVi = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eVg = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eCD = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.eVp = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.eVp != null) {
                this.eVp.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.eDy = new AntiData();
                this.eDy.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!u.v(stringArrayList)) {
                this.eVm = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.eVm.add(iconData);
                    }
                }
            }
            this.eVn = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void r(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.eVe);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.eVf);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.eVg);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.eVi);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.eCD);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.eVp));
            if (this.eDy != null) {
                bundle.putSerializable("anti", this.eDy.toJsonString());
            }
            if (!u.v(this.eVm)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.eVm.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.eVh);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.eVe = false;
        this.eVf = null;
        this.eVg = null;
        this.eVi = false;
        this.eDz = false;
        this.eCD = 0;
        this.eVj = null;
        this.aaS = null;
        this.eSU = null;
        this.eVk = null;
        this.eVl = 0;
        this.eVn = false;
        this.eVo = null;
        this.isLoading = false;
        this.bXR = null;
        this.eVt = true;
        this.mOffset = 0;
        this.eJt = null;
        this.eSX = null;
        this.eVu = false;
        this.eSY = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.aaS.getPageActivity().finish();
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
                    if (SubPbModel.this.eVo != null && SubPbModel.this.eVo.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.eVo.size() - 1; size >= 0; size--) {
                                n nVar2 = (n) SubPbModel.this.eVo.get(size);
                                if (SubPbModel.this.eVq) {
                                    SubPbModel.this.eSU.c(nVar2, true);
                                } else {
                                    SubPbModel.this.eSU.b(nVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.eVo.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.bXR == null) {
                        SubPbModel.this.bXR = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.bXR != null) {
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
                            SubPbModel.this.bXR.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.bXR = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.bXR = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.eVk != null) {
                                SubPbModel.this.eVk.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                nVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                nVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (nVar.aPF().errorno.intValue() != 0) {
                                if (SubPbModel.this.eVk != null) {
                                    SubPbModel.this.eVk.a(false, nVar.eDA.errorno.intValue(), nVar.eDA.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (nVar.MA() != null && nVar.MA().getAuthor() != null) {
                                str = nVar.MA().getAuthor().getUserId();
                                if (u.v(nVar.aPG().getAuthor().getIconInfo()) && SubPbModel.this.eVm != null) {
                                    nVar.aPG().getAuthor().setIconInfo(SubPbModel.this.eVm);
                                }
                            }
                            if (!SubPbModel.this.eVq) {
                                for (int i2 = 0; i2 < nVar.aPK().size(); i2++) {
                                    nVar.aPK().get(i2).a(SubPbModel.this.aaS, str.equals(nVar.aPK().get(i2).getAuthor().getUserId()));
                                }
                            }
                            if (nVar.aPG() != null) {
                                SubPbModel.this.postID = nVar.aPG().getId();
                            }
                            if (nVar.MA() != null) {
                                SubPbModel.this.threadID = nVar.MA().getId();
                                SubPbModel.this.eDz = nVar.nB();
                                SubPbModel.this.eVj = nVar.MA().rE();
                            }
                            if (SubPbModel.this.eVj != null && SubPbModel.this.postID != null && SubPbModel.this.eVj.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.eDz = true;
                            }
                            if (SubPbModel.this.eVq) {
                                SubPbModel.this.f(nVar);
                            } else {
                                SubPbModel.this.e(nVar);
                            }
                            if (SubPbModel.this.eVk != null) {
                                SubPbModel.this.eVk.a(SubPbModel.this.aVk(), error, errorString, SubPbModel.this.eSU);
                            }
                        }
                    }
                }
            }
        };
        this.aaS = tbPageContext;
        this.eVo = new ArrayList<>();
        this.eSU = new n();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.eSY);
        registerListener(this.eSY);
    }

    public String getThreadID() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Dn() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public n aVj() {
        return this.eSU;
    }

    public AntiData aAK() {
        return this.eDy;
    }

    public boolean aVk() {
        return (this.eSU == null || this.eSU.aPG() == null) ? false : true;
    }

    public void a(a aVar) {
        this.eVk = aVar;
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
        markData.setFloor(postData.bsr());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.eSY);
        if (this.eJt != null) {
            this.eJt.unRegisterListener();
        }
        abP();
    }

    private void abP() {
        if (this.bXR != null) {
            this.bXR.destory();
            this.bXR = null;
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

    public void pE(String str) {
        if (!TextUtils.isEmpty(str) && this.eSU != null && this.eSU.aPK() != null) {
            ArrayList<PostData> aPK = this.eSU.aPK();
            int size = aPK.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aPK.get(i).getId())) {
                    aPK.remove(i);
                    this.eVl++;
                    this.eSU.setTotalCount(this.eSU.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aVl() {
        int JA = this.eSU.JA();
        if (JA == 0) {
            return JA + 1;
        }
        if (this.mLoadType == 0) {
            return JA + 1;
        }
        if (this.mLoadType == 2 && this.eSU.aPK().size() != 0 && this.eSU.aPK().size() % this.eSU.aPL() == 0) {
            return JA + 1;
        }
        if (this.mLoadType == 3 && this.eVq) {
            return this.eSU.aPI() - 1;
        }
        if (this.mLoadType == 3 && JA > 0) {
            return this.eSU.aPH() - 1;
        }
        return JA;
    }

    private SubPbRequestMessage aUt() {
        this.isLoading = true;
        return g((Integer) null);
    }

    private SubPbRequestMessage g(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int af = k.af(TbadkCoreApplication.getInst().getApp());
        int ag = k.ag(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = aVl();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.eVq && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.aaS.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, af, ag, f, this.stType, i2);
    }

    public boolean Fo() {
        return pB(0);
    }

    public boolean aVm() {
        return pB(2);
    }

    public void aVn() {
        int aPL;
        if (this.eVl > 0 && this.eSU != null && (aPL = this.eSU.aPL()) > 0) {
            int JA = this.eSU.JA();
            for (int i = (((this.eVl + aPL) - 1) / aPL) - 1; i >= 0; i--) {
                this.eVv = g(Integer.valueOf(JA - i));
                this.eVv.setTreatDelPage(true);
                sendMessage(this.eVv);
            }
        }
        this.eVl = 0;
    }

    public boolean aVo() {
        return pB(1);
    }

    public boolean aVp() {
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
        aVn();
        this.mLoadType = i;
        this.eVv = aUt();
        sendMessage(this.eVv);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(n nVar) {
        ArrayList<PostData> aPK = nVar.aPK();
        if (aPK == null || aPK.size() == 0) {
            nVar.bV(this.eSU.JA());
        }
        if (this.mLoadType == 1) {
            this.eSU = nVar;
        } else if (this.mLoadType == 2) {
            this.eSU.b(nVar, true);
        } else if (this.mLoadType == 3) {
            this.eSU.a(nVar, false);
        } else {
            this.eSU.b(nVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(n nVar) {
        if (this.mLoadType == 1) {
            this.eSU = nVar;
            this.eSU.aPJ();
        } else if (this.mLoadType == 2) {
            this.eSU.c(nVar, true);
        } else if (this.mLoadType == 3) {
            this.eSU.d(nVar, false);
        } else {
            this.eSU.a(nVar);
        }
    }

    public void g(n nVar) {
        String str;
        if (nVar.MA() == null || nVar.MA().getAuthor() == null) {
            str = null;
        } else {
            str = nVar.MA().getAuthor().getUserId();
        }
        if (!this.eVq) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= nVar.aPK().size()) {
                    break;
                }
                nVar.aPK().get(i2).a(this.aaS, str.equals(nVar.aPK().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.eVo.add(nVar);
    }

    public boolean aUL() {
        return this.eVe;
    }

    public boolean isMarked() {
        return this.eDz;
    }

    public boolean aVq() {
        return "hot_topic".equals(getStType());
    }

    public void jy(boolean z) {
        this.eDz = z;
    }

    public int aPj() {
        return this.eCD;
    }

    public String aVr() {
        return this.eVj;
    }

    public void pF(String str) {
        this.eVj = str;
    }

    public boolean aVs() {
        return this.eVi;
    }

    public String aVt() {
        return this.eVg;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fM(String str) {
        if (this.eSU == null || this.eSU.aPM() == null || this.eSU.MA() == null || this.eSU.aPG() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.eSU.aPM().getName());
        writeData.setForumId(this.eSU.aPM().getId());
        writeData.setFloor(this.eSU.aPG().getId());
        writeData.setType(2);
        writeData.setThreadId(this.eSU.MA().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Dm() {
        if (this.eVu) {
            aVv();
        } else {
            aVm();
        }
        return true;
    }

    public boolean aVu() {
        return this.eVu;
    }

    public void kb(boolean z) {
        this.eVu = z;
    }

    private void aVv() {
        if (this.eJt == null) {
            this.eJt = new PbFakeFloorModel(this.aaS);
            this.eJt.setUniqueId(BdUniqueId.gen());
            this.eJt.d(this.eSU);
            this.eJt.setPostId(this.postID);
            this.eJt.a(this.eSX);
        }
        this.eJt.aUs();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.eSX = aVar;
    }

    public boolean aVw() {
        return this.eVq;
    }

    public void kc(boolean z) {
        this.eVq = z;
    }

    public SmallTailInfo aVx() {
        return this.eVp;
    }

    public boolean aVy() {
        return this.eVn;
    }

    public ConcurrentHashMap<String, ImageUrlData> aVz() {
        return this.eVs;
    }

    public ArrayList<String> aVA() {
        return this.eVr;
    }

    public boolean aVB() {
        return this.eVt;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String aVC() {
        return this.eVh;
    }
}
