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
    private AntiData aBQ;
    private com.baidu.tieba.tbadkCore.d.b cTx;
    private k fJp;
    private PbFakeFloorModel.a fJs;
    private com.baidu.adp.framework.listener.a fJt;
    private String fLL;
    private boolean fLM;
    private String fLN;
    private String fLO;
    private String fLP;
    private String fLQ;
    private boolean fLR;
    private String fLS;
    private a fLT;
    private int fLU;
    private ArrayList<IconData> fLV;
    private AttentionHostData fLW;
    private boolean fLX;
    private ArrayList<k> fLY;
    private SmallTailInfo fLZ;
    private boolean fMa;
    private ArrayList<String> fMb;
    private ConcurrentHashMap<String, ImageUrlData> fMc;
    private boolean fMd;
    private boolean fMe;
    private SubPbRequestMessage fMf;
    private int fsx;
    private boolean ftz;
    private PbFakeFloorModel fzU;
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
            this.fLL = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.fLP = intent.getStringExtra("from_forum_id");
            this.fLQ = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.fLM = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fLN = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fLR = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fLO = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fsx = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.fLZ = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.fLZ != null) {
                this.fLZ.updateShowInfo();
            }
            this.aBQ = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.fLV = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.fLX = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.fMc = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.fMc.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.fMb = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.fMd = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.fLL = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.fLP = bundle.getString("from_forum_id");
            this.fLQ = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.fLM = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fLN = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fLR = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fLO = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fsx = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.fLZ = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.fLZ != null) {
                this.fLZ.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.aBQ = new AntiData();
                this.aBQ.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!w.z(stringArrayList)) {
                this.fLV = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.fLV.add(iconData);
                    }
                }
            }
            this.fLX = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void z(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.fLL);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fLM);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.fLN);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.fLO);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.fLR);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fsx);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.fLZ));
            if (this.aBQ != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.aBQ.toJsonString());
            }
            if (!w.z(this.fLV)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.fLV.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.fLP);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.fLQ);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.fLL = null;
        this.postID = null;
        this.stType = null;
        this.fLM = false;
        this.fLN = null;
        this.fLO = null;
        this.pageFromType = 0;
        this.fLR = false;
        this.ftz = false;
        this.fsx = 0;
        this.fLS = null;
        this.mContext = null;
        this.fJp = null;
        this.fLT = null;
        this.fLU = 0;
        this.fLX = false;
        this.fLY = null;
        this.isLoading = false;
        this.cTx = null;
        this.fMd = true;
        this.mOffset = 0;
        this.fzU = null;
        this.fJs = null;
        this.fMe = false;
        this.fJt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                    if (SubPbModel.this.fLY != null && SubPbModel.this.fLY.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.fLY.size() - 1; size >= 0; size--) {
                                k kVar2 = (k) SubPbModel.this.fLY.get(size);
                                if (SubPbModel.this.fMa) {
                                    SubPbModel.this.fJp.c(kVar2, true);
                                } else {
                                    SubPbModel.this.fJp.b(kVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.fLY.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.cTx == null) {
                        SubPbModel.this.cTx = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.cTx != null) {
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
                            SubPbModel.this.cTx.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.cTx = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.cTx = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.fLT != null) {
                                SubPbModel.this.fLT.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                kVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (kVar.aZY().errorno.intValue() != 0) {
                                if (SubPbModel.this.fLT != null) {
                                    SubPbModel.this.fLT.a(false, kVar.ftA.errorno.intValue(), kVar.ftA.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (kVar.Td() != null && kVar.Td().vk() != null) {
                                str = kVar.Td().vk().getUserId();
                                if (w.z(kVar.aZZ().vk().getIconInfo()) && SubPbModel.this.fLV != null) {
                                    kVar.aZZ().vk().setIconInfo(SubPbModel.this.fLV);
                                }
                            }
                            if (!SubPbModel.this.fMa) {
                                for (int i2 = 0; i2 < kVar.bad().size(); i2++) {
                                    kVar.bad().get(i2).b(SubPbModel.this.mContext, str.equals(kVar.bad().get(i2).vk().getUserId()));
                                }
                            }
                            if (kVar.aZZ() != null) {
                                SubPbModel.this.postID = kVar.aZZ().getId();
                            }
                            if (kVar.Td() != null) {
                                SubPbModel.this.fLL = kVar.Td().getId();
                                SubPbModel.this.ftz = kVar.rN();
                                SubPbModel.this.fLS = kVar.Td().vu();
                            }
                            if (SubPbModel.this.fLS != null && SubPbModel.this.postID != null && SubPbModel.this.fLS.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.ftz = true;
                            }
                            if (SubPbModel.this.fMa) {
                                SubPbModel.this.f(kVar);
                            } else {
                                SubPbModel.this.e(kVar);
                            }
                            if (SubPbModel.this.fLT != null) {
                                SubPbModel.this.fLT.a(SubPbModel.this.bfP(), error, errorString, SubPbModel.this.fJp);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fLY = new ArrayList<>();
        this.fJp = new k();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.fJt);
        registerListener(this.fJt);
    }

    public String bci() {
        return this.fLL;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String HO() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public k bfO() {
        return this.fJp;
    }

    public AntiData Ce() {
        return this.aBQ;
    }

    public boolean bfP() {
        return (this.fJp == null || this.fJp.aZZ() == null) ? false : true;
    }

    public void a(a aVar) {
        this.fLT = aVar;
    }

    public MarkData g(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fLL);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.fLL);
        markData.setFloor(postData.bwf());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fJt);
        if (this.fzU != null) {
            this.fzU.unRegisterListener();
        }
        aph();
    }

    private void aph() {
        if (this.cTx != null) {
            this.cTx.destory();
            this.cTx = null;
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

    public void rD(String str) {
        if (!TextUtils.isEmpty(str) && this.fJp != null && this.fJp.bad() != null) {
            ArrayList<PostData> bad = this.fJp.bad();
            int size = bad.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bad.get(i).getId())) {
                    bad.remove(i);
                    this.fLU++;
                    this.fJp.setTotalCount(this.fJp.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bfQ() {
        int OW = this.fJp.OW();
        if (OW == 0) {
            return OW + 1;
        }
        if (this.mLoadType == 0) {
            return OW + 1;
        }
        if (this.mLoadType == 2 && this.fJp.bad().size() != 0 && this.fJp.bad().size() % this.fJp.baf() == 0) {
            return OW + 1;
        }
        if (this.mLoadType == 3 && this.fMa) {
            return this.fJp.bab() - 1;
        }
        if (this.mLoadType == 3 && OW > 0) {
            return this.fJp.baa() - 1;
        }
        return OW;
    }

    private SubPbRequestMessage bfc() {
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
            intValue = bfQ();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.fMa && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.fLL), j, j2, i, ah, aj, f, this.stType, i2);
    }

    public boolean JR() {
        return qZ(0);
    }

    public boolean bfR() {
        return qZ(2);
    }

    public void bfS() {
        int baf;
        if (this.fLU > 0 && this.fJp != null && (baf = this.fJp.baf()) > 0) {
            int OW = this.fJp.OW();
            for (int i = (((this.fLU + baf) - 1) / baf) - 1; i >= 0; i--) {
                this.fMf = p(Integer.valueOf(OW - i));
                this.fMf.setTreatDelPage(true);
                sendMessage(this.fMf);
            }
        }
        this.fLU = 0;
    }

    public boolean bfT() {
        return qZ(1);
    }

    public boolean qZ(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.fLL == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bfS();
        this.mLoadType = i;
        this.fMf = bfc();
        sendMessage(this.fMf);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(k kVar) {
        ArrayList<PostData> bad = kVar.bad();
        if (bad == null || bad.size() == 0) {
            kVar.ca(this.fJp.OW());
        }
        if (this.mLoadType == 1) {
            this.fJp = kVar;
        } else if (this.mLoadType == 2) {
            this.fJp.b(kVar, true);
        } else if (this.mLoadType == 3) {
            this.fJp.a(kVar, false);
        } else {
            this.fJp.b(kVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (this.mLoadType == 1) {
            this.fJp = kVar;
            this.fJp.bac();
        } else if (this.mLoadType == 2) {
            this.fJp.c(kVar, true);
        } else if (this.mLoadType == 3) {
            this.fJp.d(kVar, false);
        } else {
            this.fJp.a(kVar);
        }
    }

    public void g(k kVar) {
        String str;
        if (kVar.Td() == null || kVar.Td().vk() == null) {
            str = null;
        } else {
            str = kVar.Td().vk().getUserId();
        }
        if (!this.fMa) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= kVar.bad().size()) {
                    break;
                }
                kVar.bad().get(i2).b(this.mContext, str.equals(kVar.bad().get(i2).vk().getUserId()));
                i = i2 + 1;
            }
        }
        this.fLY.add(kVar);
    }

    public boolean bft() {
        return this.fLM;
    }

    public boolean isMarked() {
        return this.ftz;
    }

    public boolean bfU() {
        return "hot_topic".equals(getStType());
    }

    public void kM(boolean z) {
        this.ftz = z;
    }

    public int aZz() {
        return this.fsx;
    }

    public String bfV() {
        return this.fLS;
    }

    public void rE(String str) {
        this.fLS = str;
    }

    public String bfW() {
        return this.fLO;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gH(String str) {
        if (this.fJp == null || this.fJp.bag() == null || this.fJp.Td() == null || this.fJp.aZZ() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.fJp.bag().getName());
        writeData.setForumId(this.fJp.bag().getId());
        writeData.setFromForumId(this.fLQ);
        writeData.setFloor(this.fJp.aZZ().getId());
        writeData.setType(2);
        writeData.setThreadId(this.fJp.Td().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean HN() {
        if (this.fMe) {
            bfY();
        } else {
            bfR();
        }
        return true;
    }

    public boolean bfX() {
        return this.fMe;
    }

    public void kN(boolean z) {
        this.fMe = z;
    }

    private void bfY() {
        if (this.fzU == null) {
            this.fzU = new PbFakeFloorModel(this.mContext);
            this.fzU.setUniqueId(BdUniqueId.gen());
            this.fzU.d(this.fJp);
            this.fzU.setPostId(this.postID);
            this.fzU.a(this.fJs);
        }
        this.fzU.bfb();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.fJs = aVar;
    }

    public SmallTailInfo bfZ() {
        return this.fLZ;
    }

    public boolean bga() {
        return this.fLX;
    }

    public ConcurrentHashMap<String, ImageUrlData> bgb() {
        return this.fMc;
    }

    public ArrayList<String> bgc() {
        return this.fMb;
    }

    public boolean bgd() {
        return this.fMd;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.fLP;
    }

    public AttentionHostData bge() {
        if (this.fLW == null) {
            this.fLW = new AttentionHostData();
            if (this.fJp != null && this.fJp.Td() != null && this.fJp.Td().vk() != null) {
                this.fLW.parserWithMetaData(this.fJp.Td().vk());
            }
        }
        return this.fLW;
    }
}
