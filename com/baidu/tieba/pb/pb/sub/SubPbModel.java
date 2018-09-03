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
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.data.k;
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
    private AntiData aBN;
    private com.baidu.tieba.tbadkCore.d.b cTt;
    private k fJi;
    private PbFakeFloorModel.a fJl;
    private com.baidu.adp.framework.listener.a fJm;
    private String fLE;
    private boolean fLF;
    private String fLG;
    private String fLH;
    private String fLI;
    private String fLJ;
    private boolean fLK;
    private String fLL;
    private a fLM;
    private int fLN;
    private ArrayList<IconData> fLO;
    private AttentionHostData fLP;
    private boolean fLQ;
    private ArrayList<k> fLR;
    private SmallTailInfo fLS;
    private boolean fLT;
    private ArrayList<String> fLU;
    private ConcurrentHashMap<String, ImageUrlData> fLV;
    private boolean fLW;
    private boolean fLX;
    private SubPbRequestMessage fLY;
    private int fsq;
    private boolean fts;
    private PbFakeFloorModel fzN;
    private boolean isLoading;
    private TbPageContext<?> mContext;
    private int mLoadType;
    private int mOffset;
    public int pageFromType;
    private String postID;
    private String stType;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z, int i, String str, k kVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.fLE = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.fLI = intent.getStringExtra("from_forum_id");
            this.fLJ = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.fLF = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fLG = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fLK = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fLH = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fsq = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.fLS = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.fLS != null) {
                this.fLS.updateShowInfo();
            }
            this.aBN = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.fLO = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.fLQ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.fLV = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.fLV.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.fLU = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.fLW = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.fLE = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.fLI = bundle.getString("from_forum_id");
            this.fLJ = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.fLF = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fLG = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fLK = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fLH = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fsq = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.fLS = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.fLS != null) {
                this.fLS.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.aBN = new AntiData();
                this.aBN.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!w.z(stringArrayList)) {
                this.fLO = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.fLO.add(iconData);
                    }
                }
            }
            this.fLQ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void z(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.fLE);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fLF);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.fLG);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.fLH);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.fLK);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fsq);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.fLS));
            if (this.aBN != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.aBN.toJsonString());
            }
            if (!w.z(this.fLO)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.fLO.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.fLI);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.fLJ);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.fLE = null;
        this.postID = null;
        this.stType = null;
        this.fLF = false;
        this.fLG = null;
        this.fLH = null;
        this.pageFromType = 0;
        this.fLK = false;
        this.fts = false;
        this.fsq = 0;
        this.fLL = null;
        this.mContext = null;
        this.fJi = null;
        this.fLM = null;
        this.fLN = 0;
        this.fLQ = false;
        this.fLR = null;
        this.isLoading = false;
        this.cTt = null;
        this.fLW = true;
        this.mOffset = 0;
        this.fzN = null;
        this.fJl = null;
        this.fLX = false;
        this.fJm = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                boolean z;
                k kVar;
                long j2;
                long j3;
                long j4 = 0;
                String str = null;
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
                    if (SubPbModel.this.fLR != null && SubPbModel.this.fLR.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.fLR.size() - 1; size >= 0; size--) {
                                k kVar2 = (k) SubPbModel.this.fLR.get(size);
                                if (SubPbModel.this.fLT) {
                                    SubPbModel.this.fJi.c(kVar2, true);
                                } else {
                                    SubPbModel.this.fJi.b(kVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.fLR.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.cTt == null) {
                        SubPbModel.this.cTt = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.cTt != null) {
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
                            SubPbModel.this.cTt.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.cTt = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.cTt = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.fLM != null) {
                                SubPbModel.this.fLM.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                kVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (kVar.aZT().errorno.intValue() != 0) {
                                if (SubPbModel.this.fLM != null) {
                                    SubPbModel.this.fLM.a(false, kVar.ftt.errorno.intValue(), kVar.ftt.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (kVar.Tg() != null && kVar.Tg().vj() != null) {
                                str = kVar.Tg().vj().getUserId();
                                if (w.z(kVar.aZU().vj().getIconInfo()) && SubPbModel.this.fLO != null) {
                                    kVar.aZU().vj().setIconInfo(SubPbModel.this.fLO);
                                }
                            }
                            if (!SubPbModel.this.fLT) {
                                for (int i2 = 0; i2 < kVar.aZY().size(); i2++) {
                                    kVar.aZY().get(i2).b(SubPbModel.this.mContext, str.equals(kVar.aZY().get(i2).vj().getUserId()));
                                }
                            }
                            if (kVar.aZU() != null) {
                                SubPbModel.this.postID = kVar.aZU().getId();
                            }
                            if (kVar.Tg() != null) {
                                SubPbModel.this.fLE = kVar.Tg().getId();
                                SubPbModel.this.fts = kVar.rL();
                                SubPbModel.this.fLL = kVar.Tg().vt();
                            }
                            if (SubPbModel.this.fLL != null && SubPbModel.this.postID != null && SubPbModel.this.fLL.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fts = true;
                            }
                            if (SubPbModel.this.fLT) {
                                SubPbModel.this.f(kVar);
                            } else {
                                SubPbModel.this.e(kVar);
                            }
                            if (SubPbModel.this.fLM != null) {
                                SubPbModel.this.fLM.a(SubPbModel.this.bfK(), error, errorString, SubPbModel.this.fJi);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fLR = new ArrayList<>();
        this.fJi = new k();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.fJm);
        registerListener(this.fJm);
    }

    public String bcd() {
        return this.fLE;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String HO() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public k bfJ() {
        return this.fJi;
    }

    public AntiData Cb() {
        return this.aBN;
    }

    public boolean bfK() {
        return (this.fJi == null || this.fJi.aZU() == null) ? false : true;
    }

    public void a(a aVar) {
        this.fLM = aVar;
    }

    public MarkData g(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fLE);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.fLE);
        markData.setFloor(postData.bwg());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fJm);
        if (this.fzN != null) {
            this.fzN.unRegisterListener();
        }
        aph();
    }

    private void aph() {
        if (this.cTt != null) {
            this.cTt.destory();
            this.cTt = null;
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

    public void rG(String str) {
        if (!TextUtils.isEmpty(str) && this.fJi != null && this.fJi.aZY() != null) {
            ArrayList<PostData> aZY = this.fJi.aZY();
            int size = aZY.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aZY.get(i).getId())) {
                    aZY.remove(i);
                    this.fLN++;
                    this.fJi.setTotalCount(this.fJi.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bfL() {
        int OV = this.fJi.OV();
        if (OV == 0) {
            return OV + 1;
        }
        if (this.mLoadType == 0) {
            return OV + 1;
        }
        if (this.mLoadType == 2 && this.fJi.aZY().size() != 0 && this.fJi.aZY().size() % this.fJi.baa() == 0) {
            return OV + 1;
        }
        if (this.mLoadType == 3 && this.fLT) {
            return this.fJi.aZW() - 1;
        }
        if (this.mLoadType == 3 && OV > 0) {
            return this.fJi.aZV() - 1;
        }
        return OV;
    }

    private SubPbRequestMessage beX() {
        this.isLoading = true;
        return p(null);
    }

    private SubPbRequestMessage p(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ah = l.ah(TbadkCoreApplication.getInst().getApp());
        int aj = l.aj(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = bfL();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.fLT && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.fLE), j, j2, i, ah, aj, f, this.stType, i2);
    }

    public boolean JV() {
        return qZ(0);
    }

    public boolean bfM() {
        return qZ(2);
    }

    public void bfN() {
        int baa;
        if (this.fLN > 0 && this.fJi != null && (baa = this.fJi.baa()) > 0) {
            int OV = this.fJi.OV();
            for (int i = (((this.fLN + baa) - 1) / baa) - 1; i >= 0; i--) {
                this.fLY = p(Integer.valueOf(OV - i));
                this.fLY.setTreatDelPage(true);
                sendMessage(this.fLY);
            }
        }
        this.fLN = 0;
    }

    public boolean bfO() {
        return qZ(1);
    }

    public boolean qZ(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.fLE == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bfN();
        this.mLoadType = i;
        this.fLY = beX();
        sendMessage(this.fLY);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(k kVar) {
        ArrayList<PostData> aZY = kVar.aZY();
        if (aZY == null || aZY.size() == 0) {
            kVar.ca(this.fJi.OV());
        }
        if (this.mLoadType == 1) {
            this.fJi = kVar;
        } else if (this.mLoadType == 2) {
            this.fJi.b(kVar, true);
        } else if (this.mLoadType == 3) {
            this.fJi.a(kVar, false);
        } else {
            this.fJi.b(kVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (this.mLoadType == 1) {
            this.fJi = kVar;
            this.fJi.aZX();
        } else if (this.mLoadType == 2) {
            this.fJi.c(kVar, true);
        } else if (this.mLoadType == 3) {
            this.fJi.d(kVar, false);
        } else {
            this.fJi.a(kVar);
        }
    }

    public void g(k kVar) {
        String str;
        if (kVar.Tg() == null || kVar.Tg().vj() == null) {
            str = null;
        } else {
            str = kVar.Tg().vj().getUserId();
        }
        if (!this.fLT) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= kVar.aZY().size()) {
                    break;
                }
                kVar.aZY().get(i2).b(this.mContext, str.equals(kVar.aZY().get(i2).vj().getUserId()));
                i = i2 + 1;
            }
        }
        this.fLR.add(kVar);
    }

    public boolean bfo() {
        return this.fLF;
    }

    public boolean isMarked() {
        return this.fts;
    }

    public boolean bfP() {
        return "hot_topic".equals(getStType());
    }

    public void kM(boolean z) {
        this.fts = z;
    }

    public int aZu() {
        return this.fsq;
    }

    public String bfQ() {
        return this.fLL;
    }

    public void rH(String str) {
        this.fLL = str;
    }

    public String bfR() {
        return this.fLH;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gH(String str) {
        if (this.fJi == null || this.fJi.bab() == null || this.fJi.Tg() == null || this.fJi.aZU() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.fJi.bab().getName());
        writeData.setForumId(this.fJi.bab().getId());
        writeData.setFromForumId(this.fLJ);
        writeData.setFloor(this.fJi.aZU().getId());
        writeData.setType(2);
        writeData.setThreadId(this.fJi.Tg().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean HN() {
        if (this.fLX) {
            bfT();
        } else {
            bfM();
        }
        return true;
    }

    public boolean bfS() {
        return this.fLX;
    }

    public void kN(boolean z) {
        this.fLX = z;
    }

    private void bfT() {
        if (this.fzN == null) {
            this.fzN = new PbFakeFloorModel(this.mContext);
            this.fzN.setUniqueId(BdUniqueId.gen());
            this.fzN.d(this.fJi);
            this.fzN.setPostId(this.postID);
            this.fzN.a(this.fJl);
        }
        this.fzN.beW();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.fJl = aVar;
    }

    public SmallTailInfo bfU() {
        return this.fLS;
    }

    public boolean bfV() {
        return this.fLQ;
    }

    public ConcurrentHashMap<String, ImageUrlData> bfW() {
        return this.fLV;
    }

    public ArrayList<String> bfX() {
        return this.fLU;
    }

    public boolean bfY() {
        return this.fLW;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.fLI;
    }

    public AttentionHostData bfZ() {
        if (this.fLP == null) {
            this.fLP = new AttentionHostData();
            if (this.fJi != null && this.fJi.Tg() != null && this.fJi.Tg().vj() != null) {
                this.fLP.parserWithMetaData(this.fJi.Tg().vj());
            }
        }
        return this.fLP;
    }
}
