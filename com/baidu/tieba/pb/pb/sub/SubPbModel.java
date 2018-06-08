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
    private com.baidu.tieba.tbadkCore.d.b cSM;
    private k fEZ;
    private PbFakeFloorModel.a fFc;
    private com.baidu.adp.framework.listener.a fFd;
    private String fHA;
    private boolean fHB;
    private String fHC;
    private a fHD;
    private int fHE;
    private ArrayList<IconData> fHF;
    private AttentionHostData fHG;
    private boolean fHH;
    private ArrayList<k> fHI;
    private SmallTailInfo fHJ;
    private boolean fHK;
    private ArrayList<String> fHL;
    private ConcurrentHashMap<String, ImageUrlData> fHM;
    private boolean fHN;
    private boolean fHO;
    private SubPbRequestMessage fHP;
    private String fHw;
    private boolean fHx;
    private String fHy;
    private String fHz;

    /* renamed from: for  reason: not valid java name */
    private int f1for;
    private AntiData fpv;
    private boolean fpw;
    private PbFakeFloorModel fvH;
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
            this.fHw = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.fHA = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fHx = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fHy = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fHB = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fHz = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.f1for = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.fHJ = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.fHJ != null) {
                this.fHJ.updateShowInfo();
            }
            this.fpv = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.fHF = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.fHH = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.fHM = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.fHM.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.fHL = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.fHN = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.fHw = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.fHA = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fHx = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fHy = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fHB = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fHz = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.f1for = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.fHJ = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.fHJ != null) {
                this.fHJ.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.fpv = new AntiData();
                this.fpv.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!w.z(stringArrayList)) {
                this.fHF = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.fHF.add(iconData);
                    }
                }
            }
            this.fHH = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void z(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.fHw);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fHx);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.fHy);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.fHz);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.fHB);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.f1for);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.fHJ));
            if (this.fpv != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.fpv.toJsonString());
            }
            if (!w.z(this.fHF)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.fHF.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.fHA);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.fHw = null;
        this.postID = null;
        this.stType = null;
        this.fHx = false;
        this.fHy = null;
        this.fHz = null;
        this.pageFromType = 0;
        this.fHB = false;
        this.fpw = false;
        this.f1for = 0;
        this.fHC = null;
        this.mContext = null;
        this.fEZ = null;
        this.fHD = null;
        this.fHE = 0;
        this.fHH = false;
        this.fHI = null;
        this.isLoading = false;
        this.cSM = null;
        this.fHN = true;
        this.mOffset = 0;
        this.fvH = null;
        this.fFc = null;
        this.fHO = false;
        this.fFd = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                    if (SubPbModel.this.fHI != null && SubPbModel.this.fHI.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.fHI.size() - 1; size >= 0; size--) {
                                k kVar2 = (k) SubPbModel.this.fHI.get(size);
                                if (SubPbModel.this.fHK) {
                                    SubPbModel.this.fEZ.c(kVar2, true);
                                } else {
                                    SubPbModel.this.fEZ.b(kVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.fHI.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.cSM == null) {
                        SubPbModel.this.cSM = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.cSM != null) {
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
                            SubPbModel.this.cSM.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.cSM = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.cSM = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.fHD != null) {
                                SubPbModel.this.fHD.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                kVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (kVar.baX().errorno.intValue() != 0) {
                                if (SubPbModel.this.fHD != null) {
                                    SubPbModel.this.fHD.a(false, kVar.fpx.errorno.intValue(), kVar.fpx.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (kVar.Sz() != null && kVar.Sz().vm() != null) {
                                str = kVar.Sz().vm().getUserId();
                                if (w.z(kVar.baY().vm().getIconInfo()) && SubPbModel.this.fHF != null) {
                                    kVar.baY().vm().setIconInfo(SubPbModel.this.fHF);
                                }
                            }
                            if (!SubPbModel.this.fHK) {
                                for (int i2 = 0; i2 < kVar.bbc().size(); i2++) {
                                    kVar.bbc().get(i2).b(SubPbModel.this.mContext, str.equals(kVar.bbc().get(i2).vm().getUserId()));
                                }
                            }
                            if (kVar.baY() != null) {
                                SubPbModel.this.postID = kVar.baY().getId();
                            }
                            if (kVar.Sz() != null) {
                                SubPbModel.this.fHw = kVar.Sz().getId();
                                SubPbModel.this.fpw = kVar.sc();
                                SubPbModel.this.fHC = kVar.Sz().vv();
                            }
                            if (SubPbModel.this.fHC != null && SubPbModel.this.postID != null && SubPbModel.this.fHC.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fpw = true;
                            }
                            if (SubPbModel.this.fHK) {
                                SubPbModel.this.f(kVar);
                            } else {
                                SubPbModel.this.e(kVar);
                            }
                            if (SubPbModel.this.fHD != null) {
                                SubPbModel.this.fHD.a(SubPbModel.this.bgP(), error, errorString, SubPbModel.this.fEZ);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fHI = new ArrayList<>();
        this.fEZ = new k();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.fFd);
        registerListener(this.fFd);
    }

    public String bdh() {
        return this.fHw;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String HB() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public k bgO() {
        return this.fEZ;
    }

    public AntiData bbg() {
        return this.fpv;
    }

    public boolean bgP() {
        return (this.fEZ == null || this.fEZ.baY() == null) ? false : true;
    }

    public void a(a aVar) {
        this.fHD = aVar;
    }

    public MarkData g(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fHw);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.fHw);
        markData.setFloor(postData.bwZ());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fFd);
        if (this.fvH != null) {
            this.fvH.unRegisterListener();
        }
        apn();
    }

    private void apn() {
        if (this.cSM != null) {
            this.cSM.destory();
            this.cSM = null;
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

    public void rK(String str) {
        if (!TextUtils.isEmpty(str) && this.fEZ != null && this.fEZ.bbc() != null) {
            ArrayList<PostData> bbc = this.fEZ.bbc();
            int size = bbc.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bbc.get(i).getId())) {
                    bbc.remove(i);
                    this.fHE++;
                    this.fEZ.setTotalCount(this.fEZ.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bgQ() {
        int Ox = this.fEZ.Ox();
        if (Ox == 0) {
            return Ox + 1;
        }
        if (this.mLoadType == 0) {
            return Ox + 1;
        }
        if (this.mLoadType == 2 && this.fEZ.bbc().size() != 0 && this.fEZ.bbc().size() % this.fEZ.bbe() == 0) {
            return Ox + 1;
        }
        if (this.mLoadType == 3 && this.fHK) {
            return this.fEZ.bba() - 1;
        }
        if (this.mLoadType == 3 && Ox > 0) {
            return this.fEZ.baZ() - 1;
        }
        return Ox;
    }

    private SubPbRequestMessage bgb() {
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
            intValue = bgQ();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.fHK && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.fHw), j, j2, i, ah, aj, f, this.stType, i2);
    }

    public boolean JE() {
        return qU(0);
    }

    public boolean bgR() {
        return qU(2);
    }

    public void bgS() {
        int bbe;
        if (this.fHE > 0 && this.fEZ != null && (bbe = this.fEZ.bbe()) > 0) {
            int Ox = this.fEZ.Ox();
            for (int i = (((this.fHE + bbe) - 1) / bbe) - 1; i >= 0; i--) {
                this.fHP = p(Integer.valueOf(Ox - i));
                this.fHP.setTreatDelPage(true);
                sendMessage(this.fHP);
            }
        }
        this.fHE = 0;
    }

    public boolean bgT() {
        return qU(1);
    }

    public boolean qU(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.fHw == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bgS();
        this.mLoadType = i;
        this.fHP = bgb();
        sendMessage(this.fHP);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(k kVar) {
        ArrayList<PostData> bbc = kVar.bbc();
        if (bbc == null || bbc.size() == 0) {
            kVar.bX(this.fEZ.Ox());
        }
        if (this.mLoadType == 1) {
            this.fEZ = kVar;
        } else if (this.mLoadType == 2) {
            this.fEZ.b(kVar, true);
        } else if (this.mLoadType == 3) {
            this.fEZ.a(kVar, false);
        } else {
            this.fEZ.b(kVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (this.mLoadType == 1) {
            this.fEZ = kVar;
            this.fEZ.bbb();
        } else if (this.mLoadType == 2) {
            this.fEZ.c(kVar, true);
        } else if (this.mLoadType == 3) {
            this.fEZ.d(kVar, false);
        } else {
            this.fEZ.a(kVar);
        }
    }

    public void g(k kVar) {
        String str;
        if (kVar.Sz() == null || kVar.Sz().vm() == null) {
            str = null;
        } else {
            str = kVar.Sz().vm().getUserId();
        }
        if (!this.fHK) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= kVar.bbc().size()) {
                    break;
                }
                kVar.bbc().get(i2).b(this.mContext, str.equals(kVar.bbc().get(i2).vm().getUserId()));
                i = i2 + 1;
            }
        }
        this.fHI.add(kVar);
    }

    public boolean bgs() {
        return this.fHx;
    }

    public boolean isMarked() {
        return this.fpw;
    }

    public boolean bgU() {
        return "hot_topic".equals(getStType());
    }

    public void kQ(boolean z) {
        this.fpw = z;
    }

    public int baA() {
        return this.f1for;
    }

    public String bgV() {
        return this.fHC;
    }

    public void rL(String str) {
        this.fHC = str;
    }

    public String bgW() {
        return this.fHz;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gH(String str) {
        if (this.fEZ == null || this.fEZ.bbf() == null || this.fEZ.Sz() == null || this.fEZ.baY() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.fEZ.bbf().getName());
        writeData.setForumId(this.fEZ.bbf().getId());
        writeData.setFloor(this.fEZ.baY().getId());
        writeData.setType(2);
        writeData.setThreadId(this.fEZ.Sz().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean HA() {
        if (this.fHO) {
            bgY();
        } else {
            bgR();
        }
        return true;
    }

    public boolean bgX() {
        return this.fHO;
    }

    public void kR(boolean z) {
        this.fHO = z;
    }

    private void bgY() {
        if (this.fvH == null) {
            this.fvH = new PbFakeFloorModel(this.mContext);
            this.fvH.setUniqueId(BdUniqueId.gen());
            this.fvH.d(this.fEZ);
            this.fvH.setPostId(this.postID);
            this.fvH.a(this.fFc);
        }
        this.fvH.bga();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.fFc = aVar;
    }

    public SmallTailInfo bgZ() {
        return this.fHJ;
    }

    public boolean bha() {
        return this.fHH;
    }

    public ConcurrentHashMap<String, ImageUrlData> bhb() {
        return this.fHM;
    }

    public ArrayList<String> bhc() {
        return this.fHL;
    }

    public boolean bhd() {
        return this.fHN;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String bhe() {
        return this.fHA;
    }

    public AttentionHostData bhf() {
        if (this.fHG == null) {
            this.fHG = new AttentionHostData();
            if (this.fEZ != null && this.fEZ.Sz() != null && this.fEZ.Sz().vm() != null) {
                this.fHG.parserWithMetaData(this.fEZ.Sz().vm());
            }
        }
        return this.fHG;
    }
}
