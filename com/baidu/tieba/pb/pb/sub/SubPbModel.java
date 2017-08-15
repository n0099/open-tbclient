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
    private TbPageContext<?> acr;
    private com.baidu.tieba.tbadkCore.d.b bZJ;
    private int eFK;
    private AntiData eGF;
    private boolean eGG;
    private PbFakeFloorModel eMA;
    private n eWa;
    private PbFakeFloorModel.a eWd;
    private com.baidu.adp.framework.listener.a eWe;
    private boolean eYA;
    private SubPbRequestMessage eYB;
    private boolean eYk;
    private String eYl;
    private String eYm;
    private String eYn;
    private boolean eYo;
    private String eYp;
    private a eYq;
    private int eYr;
    private ArrayList<IconData> eYs;
    private boolean eYt;
    private ArrayList<n> eYu;
    private SmallTailInfo eYv;
    private boolean eYw;
    private ArrayList<String> eYx;
    private ConcurrentHashMap<String, ImageUrlData> eYy;
    private boolean eYz;
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
            this.eYn = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.eYk = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eYl = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eYo = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eYm = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eFK = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.eYv = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.eYv != null) {
                this.eYv.updateShowInfo();
            }
            this.eGF = (AntiData) intent.getSerializableExtra("anti");
            this.eYs = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.eYt = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.eYy = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.eYy.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.eYx = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.eYz = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.eYn = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.eYk = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eYl = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eYo = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eYm = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eFK = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.eYv = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.eYv != null) {
                this.eYv.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.eGF = new AntiData();
                this.eGF.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!u.v(stringArrayList)) {
                this.eYs = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.eYs.add(iconData);
                    }
                }
            }
            this.eYt = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void r(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.eYk);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.eYl);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.eYm);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.eYo);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.eFK);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.eYv));
            if (this.eGF != null) {
                bundle.putSerializable("anti", this.eGF.toJsonString());
            }
            if (!u.v(this.eYs)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.eYs.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.eYn);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.eYk = false;
        this.eYl = null;
        this.eYm = null;
        this.eYo = false;
        this.eGG = false;
        this.eFK = 0;
        this.eYp = null;
        this.acr = null;
        this.eWa = null;
        this.eYq = null;
        this.eYr = 0;
        this.eYt = false;
        this.eYu = null;
        this.isLoading = false;
        this.bZJ = null;
        this.eYz = true;
        this.mOffset = 0;
        this.eMA = null;
        this.eWd = null;
        this.eYA = false;
        this.eWe = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.acr.getPageActivity().finish();
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
                    if (SubPbModel.this.eYu != null && SubPbModel.this.eYu.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.eYu.size() - 1; size >= 0; size--) {
                                n nVar2 = (n) SubPbModel.this.eYu.get(size);
                                if (SubPbModel.this.eYw) {
                                    SubPbModel.this.eWa.c(nVar2, true);
                                } else {
                                    SubPbModel.this.eWa.b(nVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.eYu.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.bZJ == null) {
                        SubPbModel.this.bZJ = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.bZJ != null) {
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
                            SubPbModel.this.bZJ.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.bZJ = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.bZJ = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.eYq != null) {
                                SubPbModel.this.eYq.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                nVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                nVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (nVar.aQx().errorno.intValue() != 0) {
                                if (SubPbModel.this.eYq != null) {
                                    SubPbModel.this.eYq.a(false, nVar.eGH.errorno.intValue(), nVar.eGH.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (nVar.MF() != null && nVar.MF().getAuthor() != null) {
                                str = nVar.MF().getAuthor().getUserId();
                                if (u.v(nVar.aQy().getAuthor().getIconInfo()) && SubPbModel.this.eYs != null) {
                                    nVar.aQy().getAuthor().setIconInfo(SubPbModel.this.eYs);
                                }
                            }
                            if (!SubPbModel.this.eYw) {
                                for (int i2 = 0; i2 < nVar.aQC().size(); i2++) {
                                    nVar.aQC().get(i2).a(SubPbModel.this.acr, str.equals(nVar.aQC().get(i2).getAuthor().getUserId()));
                                }
                            }
                            if (nVar.aQy() != null) {
                                SubPbModel.this.postID = nVar.aQy().getId();
                            }
                            if (nVar.MF() != null) {
                                SubPbModel.this.threadID = nVar.MF().getId();
                                SubPbModel.this.eGG = nVar.nL();
                                SubPbModel.this.eYp = nVar.MF().rO();
                            }
                            if (SubPbModel.this.eYp != null && SubPbModel.this.postID != null && SubPbModel.this.eYp.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.eGG = true;
                            }
                            if (SubPbModel.this.eYw) {
                                SubPbModel.this.f(nVar);
                            } else {
                                SubPbModel.this.e(nVar);
                            }
                            if (SubPbModel.this.eYq != null) {
                                SubPbModel.this.eYq.a(SubPbModel.this.aWc(), error, errorString, SubPbModel.this.eWa);
                            }
                        }
                    }
                }
            }
        };
        this.acr = tbPageContext;
        this.eYu = new ArrayList<>();
        this.eWa = new n();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.eWe);
        registerListener(this.eWe);
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

    public n aWb() {
        return this.eWa;
    }

    public AntiData aBC() {
        return this.eGF;
    }

    public boolean aWc() {
        return (this.eWa == null || this.eWa.aQy() == null) ? false : true;
    }

    public void a(a aVar) {
        this.eYq = aVar;
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
        markData.setFloor(postData.btg());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.eWe);
        if (this.eMA != null) {
            this.eMA.unRegisterListener();
        }
        acp();
    }

    private void acp() {
        if (this.bZJ != null) {
            this.bZJ.destory();
            this.bZJ = null;
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

    public void pL(String str) {
        if (!TextUtils.isEmpty(str) && this.eWa != null && this.eWa.aQC() != null) {
            ArrayList<PostData> aQC = this.eWa.aQC();
            int size = aQC.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aQC.get(i).getId())) {
                    aQC.remove(i);
                    this.eYr++;
                    this.eWa.setTotalCount(this.eWa.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aWd() {
        int JG = this.eWa.JG();
        if (JG == 0) {
            return JG + 1;
        }
        if (this.mLoadType == 0) {
            return JG + 1;
        }
        if (this.mLoadType == 2 && this.eWa.aQC().size() != 0 && this.eWa.aQC().size() % this.eWa.aQD() == 0) {
            return JG + 1;
        }
        if (this.mLoadType == 3 && this.eYw) {
            return this.eWa.aQA() - 1;
        }
        if (this.mLoadType == 3 && JG > 0) {
            return this.eWa.aQz() - 1;
        }
        return JG;
    }

    private SubPbRequestMessage aVl() {
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
            intValue = aWd();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.eYw && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.acr.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, ag, ah, f, this.stType, i2);
    }

    public boolean Fw() {
        return pL(0);
    }

    public boolean aWe() {
        return pL(2);
    }

    public void aWf() {
        int aQD;
        if (this.eYr > 0 && this.eWa != null && (aQD = this.eWa.aQD()) > 0) {
            int JG = this.eWa.JG();
            for (int i = (((this.eYr + aQD) - 1) / aQD) - 1; i >= 0; i--) {
                this.eYB = g(Integer.valueOf(JG - i));
                this.eYB.setTreatDelPage(true);
                sendMessage(this.eYB);
            }
        }
        this.eYr = 0;
    }

    public boolean aWg() {
        return pL(1);
    }

    public boolean aWh() {
        return pL(3);
    }

    public boolean pL(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        aWf();
        this.mLoadType = i;
        this.eYB = aVl();
        sendMessage(this.eYB);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(n nVar) {
        ArrayList<PostData> aQC = nVar.aQC();
        if (aQC == null || aQC.size() == 0) {
            nVar.bX(this.eWa.JG());
        }
        if (this.mLoadType == 1) {
            this.eWa = nVar;
        } else if (this.mLoadType == 2) {
            this.eWa.b(nVar, true);
        } else if (this.mLoadType == 3) {
            this.eWa.a(nVar, false);
        } else {
            this.eWa.b(nVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(n nVar) {
        if (this.mLoadType == 1) {
            this.eWa = nVar;
            this.eWa.aQB();
        } else if (this.mLoadType == 2) {
            this.eWa.c(nVar, true);
        } else if (this.mLoadType == 3) {
            this.eWa.d(nVar, false);
        } else {
            this.eWa.a(nVar);
        }
    }

    public void g(n nVar) {
        String str;
        if (nVar.MF() == null || nVar.MF().getAuthor() == null) {
            str = null;
        } else {
            str = nVar.MF().getAuthor().getUserId();
        }
        if (!this.eYw) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= nVar.aQC().size()) {
                    break;
                }
                nVar.aQC().get(i2).a(this.acr, str.equals(nVar.aQC().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.eYu.add(nVar);
    }

    public boolean aVD() {
        return this.eYk;
    }

    public boolean isMarked() {
        return this.eGG;
    }

    public boolean aWi() {
        return "hot_topic".equals(getStType());
    }

    public void jB(boolean z) {
        this.eGG = z;
    }

    public int aQb() {
        return this.eFK;
    }

    public String aWj() {
        return this.eYp;
    }

    public void pM(String str) {
        this.eYp = str;
    }

    public boolean aWk() {
        return this.eYo;
    }

    public String aWl() {
        return this.eYm;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fS(String str) {
        if (this.eWa == null || this.eWa.aQE() == null || this.eWa.MF() == null || this.eWa.aQy() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.eWa.aQE().getName());
        writeData.setForumId(this.eWa.aQE().getId());
        writeData.setFloor(this.eWa.aQy().getId());
        writeData.setType(2);
        writeData.setThreadId(this.eWa.MF().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Du() {
        if (this.eYA) {
            aWn();
        } else {
            aWe();
        }
        return true;
    }

    public boolean aWm() {
        return this.eYA;
    }

    public void ke(boolean z) {
        this.eYA = z;
    }

    private void aWn() {
        if (this.eMA == null) {
            this.eMA = new PbFakeFloorModel(this.acr);
            this.eMA.setUniqueId(BdUniqueId.gen());
            this.eMA.d(this.eWa);
            this.eMA.setPostId(this.postID);
            this.eMA.a(this.eWd);
        }
        this.eMA.aVk();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.eWd = aVar;
    }

    public boolean aWo() {
        return this.eYw;
    }

    public void kf(boolean z) {
        this.eYw = z;
    }

    public SmallTailInfo aWp() {
        return this.eYv;
    }

    public boolean aWq() {
        return this.eYt;
    }

    public ConcurrentHashMap<String, ImageUrlData> aWr() {
        return this.eYy;
    }

    public ArrayList<String> aWs() {
        return this.eYx;
    }

    public boolean aWt() {
        return this.eYz;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String aWu() {
        return this.eYn;
    }
}
