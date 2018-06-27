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
    private AntiData aBW;
    private com.baidu.tieba.tbadkCore.d.b cQK;
    private k fJa;
    private PbFakeFloorModel.a fJd;
    private com.baidu.adp.framework.listener.a fJe;
    private String fLA;
    private String fLB;
    private String fLC;
    private boolean fLD;
    private String fLE;
    private a fLF;
    private int fLG;
    private ArrayList<IconData> fLH;
    private AttentionHostData fLI;
    private boolean fLJ;
    private ArrayList<k> fLK;
    private SmallTailInfo fLL;
    private boolean fLM;
    private ArrayList<String> fLN;
    private ConcurrentHashMap<String, ImageUrlData> fLO;
    private boolean fLP;
    private boolean fLQ;
    private SubPbRequestMessage fLR;
    private String fLx;
    private boolean fLy;
    private String fLz;
    private int fsl;
    private boolean fto;
    private PbFakeFloorModel fzI;
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
            this.fLx = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.fLB = intent.getStringExtra("from_forum_id");
            this.fLC = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.fLy = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fLz = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fLD = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fLA = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fsl = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.fLL = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.fLL != null) {
                this.fLL.updateShowInfo();
            }
            this.aBW = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.fLH = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.fLJ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.fLO = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.fLO.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.fLN = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.fLP = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.fLx = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.fLB = bundle.getString("from_forum_id");
            this.fLC = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.fLy = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fLz = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fLD = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fLA = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fsl = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.fLL = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.fLL != null) {
                this.fLL.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.aBW = new AntiData();
                this.aBW.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!w.A(stringArrayList)) {
                this.fLH = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.fLH.add(iconData);
                    }
                }
            }
            this.fLJ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void z(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.fLx);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fLy);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.fLz);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.fLA);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.fLD);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fsl);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.fLL));
            if (this.aBW != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.aBW.toJsonString());
            }
            if (!w.A(this.fLH)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.fLH.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.fLB);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.fLC);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.fLx = null;
        this.postID = null;
        this.stType = null;
        this.fLy = false;
        this.fLz = null;
        this.fLA = null;
        this.pageFromType = 0;
        this.fLD = false;
        this.fto = false;
        this.fsl = 0;
        this.fLE = null;
        this.mContext = null;
        this.fJa = null;
        this.fLF = null;
        this.fLG = 0;
        this.fLJ = false;
        this.fLK = null;
        this.isLoading = false;
        this.cQK = null;
        this.fLP = true;
        this.mOffset = 0;
        this.fzI = null;
        this.fJd = null;
        this.fLQ = false;
        this.fJe = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                    if (SubPbModel.this.fLK != null && SubPbModel.this.fLK.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.fLK.size() - 1; size >= 0; size--) {
                                k kVar2 = (k) SubPbModel.this.fLK.get(size);
                                if (SubPbModel.this.fLM) {
                                    SubPbModel.this.fJa.c(kVar2, true);
                                } else {
                                    SubPbModel.this.fJa.b(kVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.fLK.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.cQK == null) {
                        SubPbModel.this.cQK = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.cQK != null) {
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
                            SubPbModel.this.cQK.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.cQK = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.cQK = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.fLF != null) {
                                SubPbModel.this.fLF.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                kVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (kVar.bbF().errorno.intValue() != 0) {
                                if (SubPbModel.this.fLF != null) {
                                    SubPbModel.this.fLF.a(false, kVar.ftp.errorno.intValue(), kVar.ftp.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (kVar.SV() != null && kVar.SV().vw() != null) {
                                str = kVar.SV().vw().getUserId();
                                if (w.A(kVar.bbG().vw().getIconInfo()) && SubPbModel.this.fLH != null) {
                                    kVar.bbG().vw().setIconInfo(SubPbModel.this.fLH);
                                }
                            }
                            if (!SubPbModel.this.fLM) {
                                for (int i2 = 0; i2 < kVar.bbK().size(); i2++) {
                                    kVar.bbK().get(i2).b(SubPbModel.this.mContext, str.equals(kVar.bbK().get(i2).vw().getUserId()));
                                }
                            }
                            if (kVar.bbG() != null) {
                                SubPbModel.this.postID = kVar.bbG().getId();
                            }
                            if (kVar.SV() != null) {
                                SubPbModel.this.fLx = kVar.SV().getId();
                                SubPbModel.this.fto = kVar.sc();
                                SubPbModel.this.fLE = kVar.SV().vF();
                            }
                            if (SubPbModel.this.fLE != null && SubPbModel.this.postID != null && SubPbModel.this.fLE.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fto = true;
                            }
                            if (SubPbModel.this.fLM) {
                                SubPbModel.this.f(kVar);
                            } else {
                                SubPbModel.this.e(kVar);
                            }
                            if (SubPbModel.this.fLF != null) {
                                SubPbModel.this.fLF.a(SubPbModel.this.bhw(), error, errorString, SubPbModel.this.fJa);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fLK = new ArrayList<>();
        this.fJa = new k();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.fJe);
        registerListener(this.fJe);
    }

    public String bdP() {
        return this.fLx;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String HT() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public k bhv() {
        return this.fJa;
    }

    public AntiData Cm() {
        return this.aBW;
    }

    public boolean bhw() {
        return (this.fJa == null || this.fJa.bbG() == null) ? false : true;
    }

    public void a(a aVar) {
        this.fLF = aVar;
    }

    public MarkData g(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fLx);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.fLx);
        markData.setFloor(postData.bxC());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fJe);
        if (this.fzI != null) {
            this.fzI.unRegisterListener();
        }
        aoH();
    }

    private void aoH() {
        if (this.cQK != null) {
            this.cQK.destory();
            this.cQK = null;
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

    public void rJ(String str) {
        if (!TextUtils.isEmpty(str) && this.fJa != null && this.fJa.bbK() != null) {
            ArrayList<PostData> bbK = this.fJa.bbK();
            int size = bbK.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bbK.get(i).getId())) {
                    bbK.remove(i);
                    this.fLG++;
                    this.fJa.setTotalCount(this.fJa.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bhx() {
        int OQ = this.fJa.OQ();
        if (OQ == 0) {
            return OQ + 1;
        }
        if (this.mLoadType == 0) {
            return OQ + 1;
        }
        if (this.mLoadType == 2 && this.fJa.bbK().size() != 0 && this.fJa.bbK().size() % this.fJa.bbM() == 0) {
            return OQ + 1;
        }
        if (this.mLoadType == 3 && this.fLM) {
            return this.fJa.bbI() - 1;
        }
        if (this.mLoadType == 3 && OQ > 0) {
            return this.fJa.bbH() - 1;
        }
        return OQ;
    }

    private SubPbRequestMessage bgJ() {
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
            intValue = bhx();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.fLM && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.fLx), j, j2, i, ah, aj, f, this.stType, i2);
    }

    public boolean JW() {
        return rc(0);
    }

    public boolean bhy() {
        return rc(2);
    }

    public void bhz() {
        int bbM;
        if (this.fLG > 0 && this.fJa != null && (bbM = this.fJa.bbM()) > 0) {
            int OQ = this.fJa.OQ();
            for (int i = (((this.fLG + bbM) - 1) / bbM) - 1; i >= 0; i--) {
                this.fLR = p(Integer.valueOf(OQ - i));
                this.fLR.setTreatDelPage(true);
                sendMessage(this.fLR);
            }
        }
        this.fLG = 0;
    }

    public boolean bhA() {
        return rc(1);
    }

    public boolean rc(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.fLx == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bhz();
        this.mLoadType = i;
        this.fLR = bgJ();
        sendMessage(this.fLR);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(k kVar) {
        ArrayList<PostData> bbK = kVar.bbK();
        if (bbK == null || bbK.size() == 0) {
            kVar.bY(this.fJa.OQ());
        }
        if (this.mLoadType == 1) {
            this.fJa = kVar;
        } else if (this.mLoadType == 2) {
            this.fJa.b(kVar, true);
        } else if (this.mLoadType == 3) {
            this.fJa.a(kVar, false);
        } else {
            this.fJa.b(kVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (this.mLoadType == 1) {
            this.fJa = kVar;
            this.fJa.bbJ();
        } else if (this.mLoadType == 2) {
            this.fJa.c(kVar, true);
        } else if (this.mLoadType == 3) {
            this.fJa.d(kVar, false);
        } else {
            this.fJa.a(kVar);
        }
    }

    public void g(k kVar) {
        String str;
        if (kVar.SV() == null || kVar.SV().vw() == null) {
            str = null;
        } else {
            str = kVar.SV().vw().getUserId();
        }
        if (!this.fLM) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= kVar.bbK().size()) {
                    break;
                }
                kVar.bbK().get(i2).b(this.mContext, str.equals(kVar.bbK().get(i2).vw().getUserId()));
                i = i2 + 1;
            }
        }
        this.fLK.add(kVar);
    }

    public boolean bha() {
        return this.fLy;
    }

    public boolean isMarked() {
        return this.fto;
    }

    public boolean bhB() {
        return "hot_topic".equals(getStType());
    }

    public void la(boolean z) {
        this.fto = z;
    }

    public int bbh() {
        return this.fsl;
    }

    public String bhC() {
        return this.fLE;
    }

    public void rK(String str) {
        this.fLE = str;
    }

    public String bhD() {
        return this.fLA;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gL(String str) {
        if (this.fJa == null || this.fJa.bbN() == null || this.fJa.SV() == null || this.fJa.bbG() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.fJa.bbN().getName());
        writeData.setForumId(this.fJa.bbN().getId());
        writeData.setFromForumId(this.fLC);
        writeData.setFloor(this.fJa.bbG().getId());
        writeData.setType(2);
        writeData.setThreadId(this.fJa.SV().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean HS() {
        if (this.fLQ) {
            bhF();
        } else {
            bhy();
        }
        return true;
    }

    public boolean bhE() {
        return this.fLQ;
    }

    public void lb(boolean z) {
        this.fLQ = z;
    }

    private void bhF() {
        if (this.fzI == null) {
            this.fzI = new PbFakeFloorModel(this.mContext);
            this.fzI.setUniqueId(BdUniqueId.gen());
            this.fzI.d(this.fJa);
            this.fzI.setPostId(this.postID);
            this.fzI.a(this.fJd);
        }
        this.fzI.bgI();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.fJd = aVar;
    }

    public SmallTailInfo bhG() {
        return this.fLL;
    }

    public boolean bhH() {
        return this.fLJ;
    }

    public ConcurrentHashMap<String, ImageUrlData> bhI() {
        return this.fLO;
    }

    public ArrayList<String> bhJ() {
        return this.fLN;
    }

    public boolean bhK() {
        return this.fLP;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.fLB;
    }

    public AttentionHostData bhL() {
        if (this.fLI == null) {
            this.fLI = new AttentionHostData();
            if (this.fJa != null && this.fJa.SV() != null && this.fJa.SV().vw() != null) {
                this.fLI.parserWithMetaData(this.fJa.SV().vw());
            }
        }
        return this.fLI;
    }
}
