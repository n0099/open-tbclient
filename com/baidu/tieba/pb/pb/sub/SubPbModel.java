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
    private com.baidu.tieba.tbadkCore.d.b bZK;
    private int eFM;
    private AntiData eGH;
    private boolean eGI;
    private PbFakeFloorModel eMC;
    private n eWc;
    private PbFakeFloorModel.a eWf;
    private com.baidu.adp.framework.listener.a eWg;
    private ConcurrentHashMap<String, ImageUrlData> eYA;
    private boolean eYB;
    private boolean eYC;
    private SubPbRequestMessage eYD;
    private boolean eYm;
    private String eYn;
    private String eYo;
    private String eYp;
    private boolean eYq;
    private String eYr;
    private a eYs;
    private int eYt;
    private ArrayList<IconData> eYu;
    private boolean eYv;
    private ArrayList<n> eYw;
    private SmallTailInfo eYx;
    private boolean eYy;
    private ArrayList<String> eYz;
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
            this.eYp = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.eYm = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eYn = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eYq = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eYo = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eFM = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.eYx = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.eYx != null) {
                this.eYx.updateShowInfo();
            }
            this.eGH = (AntiData) intent.getSerializableExtra("anti");
            this.eYu = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.eYv = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.eYA = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.eYA.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.eYz = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.eYB = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.eYp = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.eYm = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.eYn = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.eYq = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.eYo = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.eFM = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.eYx = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.eYx != null) {
                this.eYx.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.eGH = new AntiData();
                this.eGH.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!u.v(stringArrayList)) {
                this.eYu = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.eYu.add(iconData);
                    }
                }
            }
            this.eYv = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void q(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.eYm);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.eYn);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.eYo);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.eYq);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.eFM);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.eYx));
            if (this.eGH != null) {
                bundle.putSerializable("anti", this.eGH.toJsonString());
            }
            if (!u.v(this.eYu)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.eYu.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.eYp);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.eYm = false;
        this.eYn = null;
        this.eYo = null;
        this.eYq = false;
        this.eGI = false;
        this.eFM = 0;
        this.eYr = null;
        this.acr = null;
        this.eWc = null;
        this.eYs = null;
        this.eYt = 0;
        this.eYv = false;
        this.eYw = null;
        this.isLoading = false;
        this.bZK = null;
        this.eYB = true;
        this.mOffset = 0;
        this.eMC = null;
        this.eWf = null;
        this.eYC = false;
        this.eWg = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                    if (SubPbModel.this.eYw != null && SubPbModel.this.eYw.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.eYw.size() - 1; size >= 0; size--) {
                                n nVar2 = (n) SubPbModel.this.eYw.get(size);
                                if (SubPbModel.this.eYy) {
                                    SubPbModel.this.eWc.c(nVar2, true);
                                } else {
                                    SubPbModel.this.eWc.b(nVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.eYw.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.bZK == null) {
                        SubPbModel.this.bZK = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.bZK != null) {
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
                            SubPbModel.this.bZK.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.bZK = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.bZK = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.eYs != null) {
                                SubPbModel.this.eYs.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                nVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                nVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (nVar.aQs().errorno.intValue() != 0) {
                                if (SubPbModel.this.eYs != null) {
                                    SubPbModel.this.eYs.a(false, nVar.eGJ.errorno.intValue(), nVar.eGJ.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (nVar.MF() != null && nVar.MF().getAuthor() != null) {
                                str = nVar.MF().getAuthor().getUserId();
                                if (u.v(nVar.aQt().getAuthor().getIconInfo()) && SubPbModel.this.eYu != null) {
                                    nVar.aQt().getAuthor().setIconInfo(SubPbModel.this.eYu);
                                }
                            }
                            if (!SubPbModel.this.eYy) {
                                for (int i2 = 0; i2 < nVar.aQx().size(); i2++) {
                                    nVar.aQx().get(i2).a(SubPbModel.this.acr, str.equals(nVar.aQx().get(i2).getAuthor().getUserId()));
                                }
                            }
                            if (nVar.aQt() != null) {
                                SubPbModel.this.postID = nVar.aQt().getId();
                            }
                            if (nVar.MF() != null) {
                                SubPbModel.this.threadID = nVar.MF().getId();
                                SubPbModel.this.eGI = nVar.nM();
                                SubPbModel.this.eYr = nVar.MF().rP();
                            }
                            if (SubPbModel.this.eYr != null && SubPbModel.this.postID != null && SubPbModel.this.eYr.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.eGI = true;
                            }
                            if (SubPbModel.this.eYy) {
                                SubPbModel.this.f(nVar);
                            } else {
                                SubPbModel.this.e(nVar);
                            }
                            if (SubPbModel.this.eYs != null) {
                                SubPbModel.this.eYs.a(SubPbModel.this.aVX(), error, errorString, SubPbModel.this.eWc);
                            }
                        }
                    }
                }
            }
        };
        this.acr = tbPageContext;
        this.eYw = new ArrayList<>();
        this.eWc = new n();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.eWg);
        registerListener(this.eWg);
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

    public n aVW() {
        return this.eWc;
    }

    public AntiData aBx() {
        return this.eGH;
    }

    public boolean aVX() {
        return (this.eWc == null || this.eWc.aQt() == null) ? false : true;
    }

    public void a(a aVar) {
        this.eYs = aVar;
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
        markData.setFloor(postData.bsZ());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.eWg);
        if (this.eMC != null) {
            this.eMC.unRegisterListener();
        }
        acl();
    }

    private void acl() {
        if (this.bZK != null) {
            this.bZK.destory();
            this.bZK = null;
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

    public void pQ(String str) {
        if (!TextUtils.isEmpty(str) && this.eWc != null && this.eWc.aQx() != null) {
            ArrayList<PostData> aQx = this.eWc.aQx();
            int size = aQx.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aQx.get(i).getId())) {
                    aQx.remove(i);
                    this.eYt++;
                    this.eWc.setTotalCount(this.eWc.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int aVY() {
        int JG = this.eWc.JG();
        if (JG == 0) {
            return JG + 1;
        }
        if (this.mLoadType == 0) {
            return JG + 1;
        }
        if (this.mLoadType == 2 && this.eWc.aQx().size() != 0 && this.eWc.aQx().size() % this.eWc.aQy() == 0) {
            return JG + 1;
        }
        if (this.mLoadType == 3 && this.eYy) {
            return this.eWc.aQv() - 1;
        }
        if (this.mLoadType == 3 && JG > 0) {
            return this.eWc.aQu() - 1;
        }
        return JG;
    }

    private SubPbRequestMessage aVg() {
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
            intValue = aVY();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.eYy && this.mLoadType == 0) {
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

    public boolean aVZ() {
        return pL(2);
    }

    public void aWa() {
        int aQy;
        if (this.eYt > 0 && this.eWc != null && (aQy = this.eWc.aQy()) > 0) {
            int JG = this.eWc.JG();
            for (int i = (((this.eYt + aQy) - 1) / aQy) - 1; i >= 0; i--) {
                this.eYD = g(Integer.valueOf(JG - i));
                this.eYD.setTreatDelPage(true);
                sendMessage(this.eYD);
            }
        }
        this.eYt = 0;
    }

    public boolean aWb() {
        return pL(1);
    }

    public boolean aWc() {
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
        aWa();
        this.mLoadType = i;
        this.eYD = aVg();
        sendMessage(this.eYD);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(n nVar) {
        ArrayList<PostData> aQx = nVar.aQx();
        if (aQx == null || aQx.size() == 0) {
            nVar.bX(this.eWc.JG());
        }
        if (this.mLoadType == 1) {
            this.eWc = nVar;
        } else if (this.mLoadType == 2) {
            this.eWc.b(nVar, true);
        } else if (this.mLoadType == 3) {
            this.eWc.a(nVar, false);
        } else {
            this.eWc.b(nVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(n nVar) {
        if (this.mLoadType == 1) {
            this.eWc = nVar;
            this.eWc.aQw();
        } else if (this.mLoadType == 2) {
            this.eWc.c(nVar, true);
        } else if (this.mLoadType == 3) {
            this.eWc.d(nVar, false);
        } else {
            this.eWc.a(nVar);
        }
    }

    public void g(n nVar) {
        String str;
        if (nVar.MF() == null || nVar.MF().getAuthor() == null) {
            str = null;
        } else {
            str = nVar.MF().getAuthor().getUserId();
        }
        if (!this.eYy) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= nVar.aQx().size()) {
                    break;
                }
                nVar.aQx().get(i2).a(this.acr, str.equals(nVar.aQx().get(i2).getAuthor().getUserId()));
                i = i2 + 1;
            }
        }
        this.eYw.add(nVar);
    }

    public boolean aVy() {
        return this.eYm;
    }

    public boolean isMarked() {
        return this.eGI;
    }

    public boolean aWd() {
        return "hot_topic".equals(getStType());
    }

    public void jB(boolean z) {
        this.eGI = z;
    }

    public int aPW() {
        return this.eFM;
    }

    public String aWe() {
        return this.eYr;
    }

    public void pR(String str) {
        this.eYr = str;
    }

    public boolean aWf() {
        return this.eYq;
    }

    public String aWg() {
        return this.eYo;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData fW(String str) {
        if (this.eWc == null || this.eWc.aQz() == null || this.eWc.MF() == null || this.eWc.aQt() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.setForumName(this.eWc.aQz().getName());
        writeData.setForumId(this.eWc.aQz().getId());
        writeData.setFloor(this.eWc.aQt().getId());
        writeData.setType(2);
        writeData.setThreadId(this.eWc.MF().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Du() {
        if (this.eYC) {
            aWi();
        } else {
            aVZ();
        }
        return true;
    }

    public boolean aWh() {
        return this.eYC;
    }

    public void ke(boolean z) {
        this.eYC = z;
    }

    private void aWi() {
        if (this.eMC == null) {
            this.eMC = new PbFakeFloorModel(this.acr);
            this.eMC.setUniqueId(BdUniqueId.gen());
            this.eMC.d(this.eWc);
            this.eMC.setPostId(this.postID);
            this.eMC.a(this.eWf);
        }
        this.eMC.aVf();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.eWf = aVar;
    }

    public boolean aWj() {
        return this.eYy;
    }

    public void kf(boolean z) {
        this.eYy = z;
    }

    public SmallTailInfo aWk() {
        return this.eYx;
    }

    public boolean aWl() {
        return this.eYv;
    }

    public ConcurrentHashMap<String, ImageUrlData> aWm() {
        return this.eYA;
    }

    public ArrayList<String> aWn() {
        return this.eYz;
    }

    public boolean aWo() {
        return this.eYB;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String aWp() {
        return this.eYp;
    }
}
