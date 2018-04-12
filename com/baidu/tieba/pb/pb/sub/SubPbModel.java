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
    private com.baidu.tieba.tbadkCore.d.b cIA;
    private int fbS;
    private AntiData fcU;
    private boolean fcV;
    private PbFakeFloorModel fji;
    private k fsE;
    private PbFakeFloorModel.a fsH;
    private com.baidu.adp.framework.listener.a fsI;
    private String fuZ;
    private boolean fva;
    private String fvb;
    private String fvc;
    private String fvd;
    private boolean fve;
    private String fvf;
    private a fvg;
    private int fvh;
    private ArrayList<IconData> fvi;
    private AttentionHostData fvj;
    private boolean fvk;
    private ArrayList<k> fvl;
    private SmallTailInfo fvm;
    private boolean fvn;
    private ArrayList<String> fvo;
    private ConcurrentHashMap<String, ImageUrlData> fvp;
    private boolean fvq;
    private boolean fvr;
    private SubPbRequestMessage fvs;
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
            this.fuZ = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.fvd = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fva = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fvb = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fve = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fvc = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fbS = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.fvm = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.fvm != null) {
                this.fvm.updateShowInfo();
            }
            this.fcU = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.fvi = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.fvk = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.fvp = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.fvp.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.fvo = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.fvq = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.fuZ = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.fvd = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fva = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fvb = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fve = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fvc = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fbS = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.fvm = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.fvm != null) {
                this.fvm.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.fcU = new AntiData();
                this.fcU.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.w(stringArrayList)) {
                this.fvi = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.fvi.add(iconData);
                    }
                }
            }
            this.fvk = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void y(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.fuZ);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fva);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.fvb);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.fvc);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.fve);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fbS);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.fvm));
            if (this.fcU != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.fcU.toJsonString());
            }
            if (!v.w(this.fvi)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.fvi.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.fvd);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.fuZ = null;
        this.postID = null;
        this.stType = null;
        this.fva = false;
        this.fvb = null;
        this.fvc = null;
        this.pageFromType = 0;
        this.fve = false;
        this.fcV = false;
        this.fbS = 0;
        this.fvf = null;
        this.adf = null;
        this.fsE = null;
        this.fvg = null;
        this.fvh = 0;
        this.fvk = false;
        this.fvl = null;
        this.isLoading = false;
        this.cIA = null;
        this.fvq = true;
        this.mOffset = 0;
        this.fji = null;
        this.fsH = null;
        this.fvr = false;
        this.fsI = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                    if (SubPbModel.this.fvl != null && SubPbModel.this.fvl.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.fvl.size() - 1; size >= 0; size--) {
                                k kVar2 = (k) SubPbModel.this.fvl.get(size);
                                if (SubPbModel.this.fvn) {
                                    SubPbModel.this.fsE.c(kVar2, true);
                                } else {
                                    SubPbModel.this.fsE.b(kVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.fvl.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.cIA == null) {
                        SubPbModel.this.cIA = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.cIA != null) {
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
                            SubPbModel.this.cIA.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.cIA = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.cIA = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.fvg != null) {
                                SubPbModel.this.fvg.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                kVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (kVar.aWb().errorno.intValue() != 0) {
                                if (SubPbModel.this.fvg != null) {
                                    SubPbModel.this.fvg.a(false, kVar.fcW.errorno.intValue(), kVar.fcW.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (kVar.Pe() != null && kVar.Pe().rQ() != null) {
                                str = kVar.Pe().rQ().getUserId();
                                if (v.w(kVar.aWc().rQ().getIconInfo()) && SubPbModel.this.fvi != null) {
                                    kVar.aWc().rQ().setIconInfo(SubPbModel.this.fvi);
                                }
                            }
                            if (!SubPbModel.this.fvn) {
                                for (int i2 = 0; i2 < kVar.aWg().size(); i2++) {
                                    kVar.aWg().get(i2).b(SubPbModel.this.adf, str.equals(kVar.aWg().get(i2).rQ().getUserId()));
                                }
                            }
                            if (kVar.aWc() != null) {
                                SubPbModel.this.postID = kVar.aWc().getId();
                            }
                            if (kVar.Pe() != null) {
                                SubPbModel.this.fuZ = kVar.Pe().getId();
                                SubPbModel.this.fcV = kVar.oI();
                                SubPbModel.this.fvf = kVar.Pe().rZ();
                            }
                            if (SubPbModel.this.fvf != null && SubPbModel.this.postID != null && SubPbModel.this.fvf.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fcV = true;
                            }
                            if (SubPbModel.this.fvn) {
                                SubPbModel.this.f(kVar);
                            } else {
                                SubPbModel.this.e(kVar);
                            }
                            if (SubPbModel.this.fvg != null) {
                                SubPbModel.this.fvg.a(SubPbModel.this.bbP(), error, errorString, SubPbModel.this.fsE);
                            }
                        }
                    }
                }
            }
        };
        this.adf = tbPageContext;
        this.fvl = new ArrayList<>();
        this.fsE = new k();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.fsI);
        registerListener(this.fsI);
    }

    public String aYj() {
        return this.fuZ;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Ea() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public k bbO() {
        return this.fsE;
    }

    public AntiData aWk() {
        return this.fcU;
    }

    public boolean bbP() {
        return (this.fsE == null || this.fsE.aWc() == null) ? false : true;
    }

    public void a(a aVar) {
        this.fvg = aVar;
    }

    public MarkData g(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fuZ);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.fuZ);
        markData.setFloor(postData.brZ());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fsI);
        if (this.fji != null) {
            this.fji.unRegisterListener();
        }
        alh();
    }

    private void alh() {
        if (this.cIA != null) {
            this.cIA.destory();
            this.cIA = null;
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
        if (!TextUtils.isEmpty(str) && this.fsE != null && this.fsE.aWg() != null) {
            ArrayList<PostData> aWg = this.fsE.aWg();
            int size = aWg.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aWg.get(i).getId())) {
                    aWg.remove(i);
                    this.fvh++;
                    this.fsE.setTotalCount(this.fsE.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bbQ() {
        int La = this.fsE.La();
        if (La == 0) {
            return La + 1;
        }
        if (this.mLoadType == 0) {
            return La + 1;
        }
        if (this.mLoadType == 2 && this.fsE.aWg().size() != 0 && this.fsE.aWg().size() % this.fsE.aWi() == 0) {
            return La + 1;
        }
        if (this.mLoadType == 3 && this.fvn) {
            return this.fsE.aWe() - 1;
        }
        if (this.mLoadType == 3 && La > 0) {
            return this.fsE.aWd() - 1;
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
        if (this.fvn && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.adf.getPageActivity(), Long.parseLong(this.fuZ), j, j2, i, af, ah, f, this.stType, i2);
    }

    public boolean FY() {
        return qK(0);
    }

    public boolean bbR() {
        return qK(2);
    }

    public void bbS() {
        int aWi;
        if (this.fvh > 0 && this.fsE != null && (aWi = this.fsE.aWi()) > 0) {
            int La = this.fsE.La();
            for (int i = (((this.fvh + aWi) - 1) / aWi) - 1; i >= 0; i--) {
                this.fvs = j(Integer.valueOf(La - i));
                this.fvs.setTreatDelPage(true);
                sendMessage(this.fvs);
            }
        }
        this.fvh = 0;
    }

    public boolean bbT() {
        return qK(1);
    }

    public boolean qK(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.fuZ == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bbS();
        this.mLoadType = i;
        this.fvs = bbc();
        sendMessage(this.fvs);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(k kVar) {
        ArrayList<PostData> aWg = kVar.aWg();
        if (aWg == null || aWg.size() == 0) {
            kVar.bV(this.fsE.La());
        }
        if (this.mLoadType == 1) {
            this.fsE = kVar;
        } else if (this.mLoadType == 2) {
            this.fsE.b(kVar, true);
        } else if (this.mLoadType == 3) {
            this.fsE.a(kVar, false);
        } else {
            this.fsE.b(kVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (this.mLoadType == 1) {
            this.fsE = kVar;
            this.fsE.aWf();
        } else if (this.mLoadType == 2) {
            this.fsE.c(kVar, true);
        } else if (this.mLoadType == 3) {
            this.fsE.d(kVar, false);
        } else {
            this.fsE.a(kVar);
        }
    }

    public void g(k kVar) {
        String str;
        if (kVar.Pe() == null || kVar.Pe().rQ() == null) {
            str = null;
        } else {
            str = kVar.Pe().rQ().getUserId();
        }
        if (!this.fvn) {
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
        this.fvl.add(kVar);
    }

    public boolean bbs() {
        return this.fva;
    }

    public boolean isMarked() {
        return this.fcV;
    }

    public boolean bbU() {
        return "hot_topic".equals(getStType());
    }

    public void kJ(boolean z) {
        this.fcV = z;
    }

    public int aVE() {
        return this.fbS;
    }

    public String bbV() {
        return this.fvf;
    }

    public void qS(String str) {
        this.fvf = str;
    }

    public String bbW() {
        return this.fvc;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gi(String str) {
        if (this.fsE == null || this.fsE.aWj() == null || this.fsE.Pe() == null || this.fsE.aWc() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.fsE.aWj().getName());
        writeData.setForumId(this.fsE.aWj().getId());
        writeData.setFloor(this.fsE.aWc().getId());
        writeData.setType(2);
        writeData.setThreadId(this.fsE.Pe().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean DZ() {
        if (this.fvr) {
            bbY();
        } else {
            bbR();
        }
        return true;
    }

    public boolean bbX() {
        return this.fvr;
    }

    public void kK(boolean z) {
        this.fvr = z;
    }

    private void bbY() {
        if (this.fji == null) {
            this.fji = new PbFakeFloorModel(this.adf);
            this.fji.setUniqueId(BdUniqueId.gen());
            this.fji.d(this.fsE);
            this.fji.setPostId(this.postID);
            this.fji.a(this.fsH);
        }
        this.fji.bbb();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.fsH = aVar;
    }

    public SmallTailInfo bbZ() {
        return this.fvm;
    }

    public boolean bca() {
        return this.fvk;
    }

    public ConcurrentHashMap<String, ImageUrlData> bcb() {
        return this.fvp;
    }

    public ArrayList<String> bcc() {
        return this.fvo;
    }

    public boolean bcd() {
        return this.fvq;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String bce() {
        return this.fvd;
    }

    public AttentionHostData bcf() {
        if (this.fvj == null) {
            this.fvj = new AttentionHostData();
            if (this.fsE != null && this.fsE.Pe() != null && this.fsE.Pe().rQ() != null) {
                this.fvj.parserWithMetaData(this.fsE.Pe().rQ());
            }
        }
        return this.fvj;
    }
}
