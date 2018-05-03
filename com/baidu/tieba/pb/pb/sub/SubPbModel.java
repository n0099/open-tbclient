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
import com.baidu.tbadk.core.util.v;
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
    private TbPageContext<?> adf;
    private com.baidu.tieba.tbadkCore.d.b cIx;
    private int fbP;
    private AntiData fcR;
    private boolean fcS;
    private PbFakeFloorModel fjf;
    private k fsB;
    private PbFakeFloorModel.a fsE;
    private com.baidu.adp.framework.listener.a fsF;
    private String fuW;
    private boolean fuX;
    private String fuY;
    private String fuZ;
    private String fva;
    private boolean fvb;
    private String fvc;
    private a fvd;
    private int fve;
    private ArrayList<IconData> fvf;
    private AttentionHostData fvg;
    private boolean fvh;
    private ArrayList<k> fvi;
    private SmallTailInfo fvj;
    private boolean fvk;
    private ArrayList<String> fvl;
    private ConcurrentHashMap<String, ImageUrlData> fvm;
    private boolean fvn;
    private boolean fvo;
    private SubPbRequestMessage fvp;
    private boolean isLoading;
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
            this.fuW = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.fva = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fuX = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fuY = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fvb = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fuZ = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fbP = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.fvj = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.fvj != null) {
                this.fvj.updateShowInfo();
            }
            this.fcR = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.fvf = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.fvh = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.fvm = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.fvm.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.fvl = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.fvn = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.fuW = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.fva = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fuX = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fuY = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fvb = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fuZ = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fbP = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.fvj = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.fvj != null) {
                this.fvj.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.fcR = new AntiData();
                this.fcR.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.w(stringArrayList)) {
                this.fvf = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.fvf.add(iconData);
                    }
                }
            }
            this.fvh = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void y(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.fuW);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fuX);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.fuY);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.fuZ);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.fvb);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fbP);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.fvj));
            if (this.fcR != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.fcR.toJsonString());
            }
            if (!v.w(this.fvf)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.fvf.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.fva);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.fuW = null;
        this.postID = null;
        this.stType = null;
        this.fuX = false;
        this.fuY = null;
        this.fuZ = null;
        this.pageFromType = 0;
        this.fvb = false;
        this.fcS = false;
        this.fbP = 0;
        this.fvc = null;
        this.adf = null;
        this.fsB = null;
        this.fvd = null;
        this.fve = 0;
        this.fvh = false;
        this.fvi = null;
        this.isLoading = false;
        this.cIx = null;
        this.fvn = true;
        this.mOffset = 0;
        this.fjf = null;
        this.fsE = null;
        this.fvo = false;
        this.fsF = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.adf.getPageActivity().finish();
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
                    if (SubPbModel.this.fvi != null && SubPbModel.this.fvi.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.fvi.size() - 1; size >= 0; size--) {
                                k kVar2 = (k) SubPbModel.this.fvi.get(size);
                                if (SubPbModel.this.fvk) {
                                    SubPbModel.this.fsB.c(kVar2, true);
                                } else {
                                    SubPbModel.this.fsB.b(kVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.fvi.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.cIx == null) {
                        SubPbModel.this.cIx = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.cIx != null) {
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
                            SubPbModel.this.cIx.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.cIx = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.cIx = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.fvd != null) {
                                SubPbModel.this.fvd.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                kVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (kVar.aWb().errorno.intValue() != 0) {
                                if (SubPbModel.this.fvd != null) {
                                    SubPbModel.this.fvd.a(false, kVar.fcT.errorno.intValue(), kVar.fcT.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (kVar.Pe() != null && kVar.Pe().rQ() != null) {
                                str = kVar.Pe().rQ().getUserId();
                                if (v.w(kVar.aWc().rQ().getIconInfo()) && SubPbModel.this.fvf != null) {
                                    kVar.aWc().rQ().setIconInfo(SubPbModel.this.fvf);
                                }
                            }
                            if (!SubPbModel.this.fvk) {
                                for (int i2 = 0; i2 < kVar.aWg().size(); i2++) {
                                    kVar.aWg().get(i2).b(SubPbModel.this.adf, str.equals(kVar.aWg().get(i2).rQ().getUserId()));
                                }
                            }
                            if (kVar.aWc() != null) {
                                SubPbModel.this.postID = kVar.aWc().getId();
                            }
                            if (kVar.Pe() != null) {
                                SubPbModel.this.fuW = kVar.Pe().getId();
                                SubPbModel.this.fcS = kVar.oI();
                                SubPbModel.this.fvc = kVar.Pe().rZ();
                            }
                            if (SubPbModel.this.fvc != null && SubPbModel.this.postID != null && SubPbModel.this.fvc.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fcS = true;
                            }
                            if (SubPbModel.this.fvk) {
                                SubPbModel.this.f(kVar);
                            } else {
                                SubPbModel.this.e(kVar);
                            }
                            if (SubPbModel.this.fvd != null) {
                                SubPbModel.this.fvd.a(SubPbModel.this.bbP(), error, errorString, SubPbModel.this.fsB);
                            }
                        }
                    }
                }
            }
        };
        this.adf = tbPageContext;
        this.fvi = new ArrayList<>();
        this.fsB = new k();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.fsF);
        registerListener(this.fsF);
    }

    public String aYj() {
        return this.fuW;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Ea() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public k bbO() {
        return this.fsB;
    }

    public AntiData aWk() {
        return this.fcR;
    }

    public boolean bbP() {
        return (this.fsB == null || this.fsB.aWc() == null) ? false : true;
    }

    public void a(a aVar) {
        this.fvd = aVar;
    }

    public MarkData g(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fuW);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.fuW);
        markData.setFloor(postData.brZ());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fsF);
        if (this.fjf != null) {
            this.fjf.unRegisterListener();
        }
        alh();
    }

    private void alh() {
        if (this.cIx != null) {
            this.cIx.destory();
            this.cIx = null;
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

    public void qR(String str) {
        if (!TextUtils.isEmpty(str) && this.fsB != null && this.fsB.aWg() != null) {
            ArrayList<PostData> aWg = this.fsB.aWg();
            int size = aWg.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aWg.get(i).getId())) {
                    aWg.remove(i);
                    this.fve++;
                    this.fsB.setTotalCount(this.fsB.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bbQ() {
        int La = this.fsB.La();
        if (La == 0) {
            return La + 1;
        }
        if (this.mLoadType == 0) {
            return La + 1;
        }
        if (this.mLoadType == 2 && this.fsB.aWg().size() != 0 && this.fsB.aWg().size() % this.fsB.aWi() == 0) {
            return La + 1;
        }
        if (this.mLoadType == 3 && this.fvk) {
            return this.fsB.aWe() - 1;
        }
        if (this.mLoadType == 3 && La > 0) {
            return this.fsB.aWd() - 1;
        }
        return La;
    }

    private SubPbRequestMessage bbc() {
        this.isLoading = true;
        return j((Integer) null);
    }

    private SubPbRequestMessage j(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int af = l.af(TbadkCoreApplication.getInst().getApp());
        int ah = l.ah(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = bbQ();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.fvk && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.adf.getPageActivity(), Long.parseLong(this.fuW), j, j2, i, af, ah, f, this.stType, i2);
    }

    public boolean FY() {
        return qJ(0);
    }

    public boolean bbR() {
        return qJ(2);
    }

    public void bbS() {
        int aWi;
        if (this.fve > 0 && this.fsB != null && (aWi = this.fsB.aWi()) > 0) {
            int La = this.fsB.La();
            for (int i = (((this.fve + aWi) - 1) / aWi) - 1; i >= 0; i--) {
                this.fvp = j(Integer.valueOf(La - i));
                this.fvp.setTreatDelPage(true);
                sendMessage(this.fvp);
            }
        }
        this.fve = 0;
    }

    public boolean bbT() {
        return qJ(1);
    }

    public boolean qJ(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.fuW == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bbS();
        this.mLoadType = i;
        this.fvp = bbc();
        sendMessage(this.fvp);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(k kVar) {
        ArrayList<PostData> aWg = kVar.aWg();
        if (aWg == null || aWg.size() == 0) {
            kVar.bU(this.fsB.La());
        }
        if (this.mLoadType == 1) {
            this.fsB = kVar;
        } else if (this.mLoadType == 2) {
            this.fsB.b(kVar, true);
        } else if (this.mLoadType == 3) {
            this.fsB.a(kVar, false);
        } else {
            this.fsB.b(kVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (this.mLoadType == 1) {
            this.fsB = kVar;
            this.fsB.aWf();
        } else if (this.mLoadType == 2) {
            this.fsB.c(kVar, true);
        } else if (this.mLoadType == 3) {
            this.fsB.d(kVar, false);
        } else {
            this.fsB.a(kVar);
        }
    }

    public void g(k kVar) {
        String str;
        if (kVar.Pe() == null || kVar.Pe().rQ() == null) {
            str = null;
        } else {
            str = kVar.Pe().rQ().getUserId();
        }
        if (!this.fvk) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= kVar.aWg().size()) {
                    break;
                }
                kVar.aWg().get(i2).b(this.adf, str.equals(kVar.aWg().get(i2).rQ().getUserId()));
                i = i2 + 1;
            }
        }
        this.fvi.add(kVar);
    }

    public boolean bbs() {
        return this.fuX;
    }

    public boolean isMarked() {
        return this.fcS;
    }

    public boolean bbU() {
        return "hot_topic".equals(getStType());
    }

    public void kJ(boolean z) {
        this.fcS = z;
    }

    public int aVE() {
        return this.fbP;
    }

    public String bbV() {
        return this.fvc;
    }

    public void qS(String str) {
        this.fvc = str;
    }

    public String bbW() {
        return this.fuZ;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gi(String str) {
        if (this.fsB == null || this.fsB.aWj() == null || this.fsB.Pe() == null || this.fsB.aWc() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.fsB.aWj().getName());
        writeData.setForumId(this.fsB.aWj().getId());
        writeData.setFloor(this.fsB.aWc().getId());
        writeData.setType(2);
        writeData.setThreadId(this.fsB.Pe().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean DZ() {
        if (this.fvo) {
            bbY();
        } else {
            bbR();
        }
        return true;
    }

    public boolean bbX() {
        return this.fvo;
    }

    public void kK(boolean z) {
        this.fvo = z;
    }

    private void bbY() {
        if (this.fjf == null) {
            this.fjf = new PbFakeFloorModel(this.adf);
            this.fjf.setUniqueId(BdUniqueId.gen());
            this.fjf.d(this.fsB);
            this.fjf.setPostId(this.postID);
            this.fjf.a(this.fsE);
        }
        this.fjf.bbb();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.fsE = aVar;
    }

    public SmallTailInfo bbZ() {
        return this.fvj;
    }

    public boolean bca() {
        return this.fvh;
    }

    public ConcurrentHashMap<String, ImageUrlData> bcb() {
        return this.fvm;
    }

    public ArrayList<String> bcc() {
        return this.fvl;
    }

    public boolean bcd() {
        return this.fvn;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String bce() {
        return this.fva;
    }

    public AttentionHostData bcf() {
        if (this.fvg == null) {
            this.fvg = new AttentionHostData();
            if (this.fsB != null && this.fsB.Pe() != null && this.fsB.Pe().rQ() != null) {
                this.fvg.parserWithMetaData(this.fsB.Pe().rQ());
            }
        }
        return this.fvg;
    }
}
