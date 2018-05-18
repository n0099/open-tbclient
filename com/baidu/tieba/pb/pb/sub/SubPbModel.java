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
    private com.baidu.tieba.tbadkCore.d.b cJG;
    private int fcW;
    private AntiData fdY;
    private boolean fdZ;
    private PbFakeFloorModel fkm;
    private k ftI;
    private PbFakeFloorModel.a ftL;
    private com.baidu.adp.framework.listener.a ftM;
    private String fwc;
    private boolean fwd;
    private String fwe;
    private String fwf;
    private String fwg;
    private boolean fwh;
    private String fwi;
    private a fwj;
    private int fwk;
    private ArrayList<IconData> fwl;
    private AttentionHostData fwm;
    private boolean fwn;
    private ArrayList<k> fwo;
    private SmallTailInfo fwp;
    private boolean fwq;
    private ArrayList<String> fwr;
    private ConcurrentHashMap<String, ImageUrlData> fws;
    private boolean fwt;
    private boolean fwu;
    private SubPbRequestMessage fwv;
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
            this.fwc = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.fwg = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fwd = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fwe = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fwh = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fwf = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fcW = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.fwp = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.fwp != null) {
                this.fwp.updateShowInfo();
            }
            this.fdY = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.fwl = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.fwn = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.fws = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.fws.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.fwr = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.fwt = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.fwc = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.fwg = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.fwd = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.fwe = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.fwh = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.fwf = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fcW = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.fwp = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.fwp != null) {
                this.fwp.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.fdY = new AntiData();
                this.fdY.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.w(stringArrayList)) {
                this.fwl = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.fwl.add(iconData);
                    }
                }
            }
            this.fwn = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void y(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.fwc);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.fwd);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.fwe);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.fwf);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.fwh);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fcW);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.fwp));
            if (this.fdY != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.fdY.toJsonString());
            }
            if (!v.w(this.fwl)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.fwl.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.fwg);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.fwc = null;
        this.postID = null;
        this.stType = null;
        this.fwd = false;
        this.fwe = null;
        this.fwf = null;
        this.pageFromType = 0;
        this.fwh = false;
        this.fdZ = false;
        this.fcW = 0;
        this.fwi = null;
        this.mContext = null;
        this.ftI = null;
        this.fwj = null;
        this.fwk = 0;
        this.fwn = false;
        this.fwo = null;
        this.isLoading = false;
        this.cJG = null;
        this.fwt = true;
        this.mOffset = 0;
        this.fkm = null;
        this.ftL = null;
        this.fwu = false;
        this.ftM = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                    if (SubPbModel.this.fwo != null && SubPbModel.this.fwo.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.fwo.size() - 1; size >= 0; size--) {
                                k kVar2 = (k) SubPbModel.this.fwo.get(size);
                                if (SubPbModel.this.fwq) {
                                    SubPbModel.this.ftI.c(kVar2, true);
                                } else {
                                    SubPbModel.this.ftI.b(kVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.fwo.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.cJG == null) {
                        SubPbModel.this.cJG = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.cJG != null) {
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
                            SubPbModel.this.cJG.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.cJG = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.cJG = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.fwj != null) {
                                SubPbModel.this.fwj.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                kVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (kVar.aWb().errorno.intValue() != 0) {
                                if (SubPbModel.this.fwj != null) {
                                    SubPbModel.this.fwj.a(false, kVar.fea.errorno.intValue(), kVar.fea.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (kVar.Pb() != null && kVar.Pb().rP() != null) {
                                str = kVar.Pb().rP().getUserId();
                                if (v.w(kVar.aWc().rP().getIconInfo()) && SubPbModel.this.fwl != null) {
                                    kVar.aWc().rP().setIconInfo(SubPbModel.this.fwl);
                                }
                            }
                            if (!SubPbModel.this.fwq) {
                                for (int i2 = 0; i2 < kVar.aWg().size(); i2++) {
                                    kVar.aWg().get(i2).b(SubPbModel.this.mContext, str.equals(kVar.aWg().get(i2).rP().getUserId()));
                                }
                            }
                            if (kVar.aWc() != null) {
                                SubPbModel.this.postID = kVar.aWc().getId();
                            }
                            if (kVar.Pb() != null) {
                                SubPbModel.this.fwc = kVar.Pb().getId();
                                SubPbModel.this.fdZ = kVar.oH();
                                SubPbModel.this.fwi = kVar.Pb().rY();
                            }
                            if (SubPbModel.this.fwi != null && SubPbModel.this.postID != null && SubPbModel.this.fwi.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fdZ = true;
                            }
                            if (SubPbModel.this.fwq) {
                                SubPbModel.this.f(kVar);
                            } else {
                                SubPbModel.this.e(kVar);
                            }
                            if (SubPbModel.this.fwj != null) {
                                SubPbModel.this.fwj.a(SubPbModel.this.bbP(), error, errorString, SubPbModel.this.ftI);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.fwo = new ArrayList<>();
        this.ftI = new k();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.ftM);
        registerListener(this.ftM);
    }

    public String aYj() {
        return this.fwc;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String DY() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public k bbO() {
        return this.ftI;
    }

    public AntiData aWk() {
        return this.fdY;
    }

    public boolean bbP() {
        return (this.ftI == null || this.ftI.aWc() == null) ? false : true;
    }

    public void a(a aVar) {
        this.fwj = aVar;
    }

    public MarkData g(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.fwc);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.fwc);
        markData.setFloor(postData.brX());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.ftM);
        if (this.fkm != null) {
            this.fkm.unRegisterListener();
        }
        alh();
    }

    private void alh() {
        if (this.cJG != null) {
            this.cJG.destory();
            this.cJG = null;
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

    public void qU(String str) {
        if (!TextUtils.isEmpty(str) && this.ftI != null && this.ftI.aWg() != null) {
            ArrayList<PostData> aWg = this.ftI.aWg();
            int size = aWg.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(aWg.get(i).getId())) {
                    aWg.remove(i);
                    this.fwk++;
                    this.ftI.setTotalCount(this.ftI.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bbQ() {
        int KY = this.ftI.KY();
        if (KY == 0) {
            return KY + 1;
        }
        if (this.mLoadType == 0) {
            return KY + 1;
        }
        if (this.mLoadType == 2 && this.ftI.aWg().size() != 0 && this.ftI.aWg().size() % this.ftI.aWi() == 0) {
            return KY + 1;
        }
        if (this.mLoadType == 3 && this.fwq) {
            return this.ftI.aWe() - 1;
        }
        if (this.mLoadType == 3 && KY > 0) {
            return this.ftI.aWd() - 1;
        }
        return KY;
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
        if (this.fwq && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.fwc), j, j2, i, af, ah, f, this.stType, i2);
    }

    public boolean FW() {
        return qI(0);
    }

    public boolean bbR() {
        return qI(2);
    }

    public void bbS() {
        int aWi;
        if (this.fwk > 0 && this.ftI != null && (aWi = this.ftI.aWi()) > 0) {
            int KY = this.ftI.KY();
            for (int i = (((this.fwk + aWi) - 1) / aWi) - 1; i >= 0; i--) {
                this.fwv = j(Integer.valueOf(KY - i));
                this.fwv.setTreatDelPage(true);
                sendMessage(this.fwv);
            }
        }
        this.fwk = 0;
    }

    public boolean bbT() {
        return qI(1);
    }

    public boolean qI(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.fwc == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bbS();
        this.mLoadType = i;
        this.fwv = bbc();
        sendMessage(this.fwv);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(k kVar) {
        ArrayList<PostData> aWg = kVar.aWg();
        if (aWg == null || aWg.size() == 0) {
            kVar.bV(this.ftI.KY());
        }
        if (this.mLoadType == 1) {
            this.ftI = kVar;
        } else if (this.mLoadType == 2) {
            this.ftI.b(kVar, true);
        } else if (this.mLoadType == 3) {
            this.ftI.a(kVar, false);
        } else {
            this.ftI.b(kVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (this.mLoadType == 1) {
            this.ftI = kVar;
            this.ftI.aWf();
        } else if (this.mLoadType == 2) {
            this.ftI.c(kVar, true);
        } else if (this.mLoadType == 3) {
            this.ftI.d(kVar, false);
        } else {
            this.ftI.a(kVar);
        }
    }

    public void g(k kVar) {
        String str;
        if (kVar.Pb() == null || kVar.Pb().rP() == null) {
            str = null;
        } else {
            str = kVar.Pb().rP().getUserId();
        }
        if (!this.fwq) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= kVar.aWg().size()) {
                    break;
                }
                kVar.aWg().get(i2).b(this.mContext, str.equals(kVar.aWg().get(i2).rP().getUserId()));
                i = i2 + 1;
            }
        }
        this.fwo.add(kVar);
    }

    public boolean bbs() {
        return this.fwd;
    }

    public boolean isMarked() {
        return this.fdZ;
    }

    public boolean bbU() {
        return "hot_topic".equals(getStType());
    }

    public void kK(boolean z) {
        this.fdZ = z;
    }

    public int aVE() {
        return this.fcW;
    }

    public String bbV() {
        return this.fwi;
    }

    public void qV(String str) {
        this.fwi = str;
    }

    public String bbW() {
        return this.fwf;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gi(String str) {
        if (this.ftI == null || this.ftI.aWj() == null || this.ftI.Pb() == null || this.ftI.aWc() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.ftI.aWj().getName());
        writeData.setForumId(this.ftI.aWj().getId());
        writeData.setFloor(this.ftI.aWc().getId());
        writeData.setType(2);
        writeData.setThreadId(this.ftI.Pb().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean DX() {
        if (this.fwu) {
            bbY();
        } else {
            bbR();
        }
        return true;
    }

    public boolean bbX() {
        return this.fwu;
    }

    public void kL(boolean z) {
        this.fwu = z;
    }

    private void bbY() {
        if (this.fkm == null) {
            this.fkm = new PbFakeFloorModel(this.mContext);
            this.fkm.setUniqueId(BdUniqueId.gen());
            this.fkm.d(this.ftI);
            this.fkm.setPostId(this.postID);
            this.fkm.a(this.ftL);
        }
        this.fkm.bbb();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.ftL = aVar;
    }

    public SmallTailInfo bbZ() {
        return this.fwp;
    }

    public boolean bca() {
        return this.fwn;
    }

    public ConcurrentHashMap<String, ImageUrlData> bcb() {
        return this.fws;
    }

    public ArrayList<String> bcc() {
        return this.fwr;
    }

    public boolean bcd() {
        return this.fwt;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String bce() {
        return this.fwg;
    }

    public AttentionHostData bcf() {
        if (this.fwm == null) {
            this.fwm = new AttentionHostData();
            if (this.ftI != null && this.ftI.Pb() != null && this.ftI.Pb().rP() != null) {
                this.fwm.parserWithMetaData(this.ftI.Pb().rP());
            }
        }
        return this.fwm;
    }
}
