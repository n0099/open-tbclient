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
    private TbPageContext<?> aRR;
    private com.baidu.tieba.tbadkCore.d.b dqh;
    private int fHi;
    private AntiData fIm;
    private boolean fIn;
    private PbFakeFloorModel fPe;
    private k fYt;
    private PbFakeFloorModel.a fYw;
    private com.baidu.adp.framework.listener.a fYx;
    private boolean gaN;
    private String gaO;
    private String gaP;
    private String gaQ;
    private boolean gaR;
    private String gaS;
    private a gaT;
    private int gaU;
    private ArrayList<IconData> gaV;
    private boolean gaW;
    private ArrayList<k> gaX;
    private SmallTailInfo gaY;
    private boolean gaZ;
    private ArrayList<String> gba;
    private ConcurrentHashMap<String, ImageUrlData> gbb;
    private boolean gbc;
    private boolean gbd;
    private SubPbRequestMessage gbe;
    private boolean isLoading;
    private int mLoadType;
    private int mOffset;
    public int pageFromType;
    private String postID;
    private String stType;
    private String threadID;

    /* loaded from: classes2.dex */
    public interface a {
        void a(boolean z, int i, String str, k kVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.threadID = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.gaQ = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.gaN = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.gaO = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.gaR = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.gaP = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fHi = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.gaY = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.gaY != null) {
                this.gaY.updateShowInfo();
            }
            this.fIm = (AntiData) intent.getSerializableExtra("anti");
            this.gaV = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.gaW = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.gbb = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.gbb.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.gba = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.gbc = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.threadID = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.gaQ = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.gaN = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.gaO = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.gaR = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.gaP = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fHi = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.gaY = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.gaY != null) {
                this.gaY.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.fIm = new AntiData();
                this.fIm.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.E(stringArrayList)) {
                this.gaV = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.gaV.add(iconData);
                    }
                }
            }
            this.gaW = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void D(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.gaN);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.gaO);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.gaP);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.gaR);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fHi);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.gaY));
            if (this.fIm != null) {
                bundle.putSerializable("anti", this.fIm.toJsonString());
            }
            if (!v.E(this.gaV)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.gaV.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.gaQ);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.gaN = false;
        this.gaO = null;
        this.gaP = null;
        this.pageFromType = 0;
        this.gaR = false;
        this.fIn = false;
        this.fHi = 0;
        this.gaS = null;
        this.aRR = null;
        this.fYt = null;
        this.gaT = null;
        this.gaU = 0;
        this.gaW = false;
        this.gaX = null;
        this.isLoading = false;
        this.dqh = null;
        this.gbc = true;
        this.mOffset = 0;
        this.fPe = null;
        this.fYw = null;
        this.gbd = false;
        this.fYx = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.aRR.getPageActivity().finish();
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
                    if (SubPbModel.this.gaX != null && SubPbModel.this.gaX.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.gaX.size() - 1; size >= 0; size--) {
                                k kVar2 = (k) SubPbModel.this.gaX.get(size);
                                if (SubPbModel.this.gaZ) {
                                    SubPbModel.this.fYt.c(kVar2, true);
                                } else {
                                    SubPbModel.this.fYt.b(kVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.gaX.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.dqh == null) {
                        SubPbModel.this.dqh = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.dqh != null) {
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
                            SubPbModel.this.dqh.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.dqh = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.dqh = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.gaT != null) {
                                SubPbModel.this.gaT.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                kVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (kVar.bbc().errorno.intValue() != 0) {
                                if (SubPbModel.this.gaT != null) {
                                    SubPbModel.this.gaT.a(false, kVar.fIo.errorno.intValue(), kVar.fIo.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (kVar.WE() != null && kVar.WE().zn() != null) {
                                str = kVar.WE().zn().getUserId();
                                if (v.E(kVar.bbd().zn().getIconInfo()) && SubPbModel.this.gaV != null) {
                                    kVar.bbd().zn().setIconInfo(SubPbModel.this.gaV);
                                }
                            }
                            if (!SubPbModel.this.gaZ) {
                                for (int i2 = 0; i2 < kVar.bbh().size(); i2++) {
                                    kVar.bbh().get(i2).b(SubPbModel.this.aRR, str.equals(kVar.bbh().get(i2).zn().getUserId()));
                                }
                            }
                            if (kVar.bbd() != null) {
                                SubPbModel.this.postID = kVar.bbd().getId();
                            }
                            if (kVar.WE() != null) {
                                SubPbModel.this.threadID = kVar.WE().getId();
                                SubPbModel.this.fIn = kVar.vX();
                                SubPbModel.this.gaS = kVar.WE().zx();
                            }
                            if (SubPbModel.this.gaS != null && SubPbModel.this.postID != null && SubPbModel.this.gaS.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fIn = true;
                            }
                            if (SubPbModel.this.gaZ) {
                                SubPbModel.this.f(kVar);
                            } else {
                                SubPbModel.this.e(kVar);
                            }
                            if (SubPbModel.this.gaT != null) {
                                SubPbModel.this.gaT.a(SubPbModel.this.bgQ(), error, errorString, SubPbModel.this.fYt);
                            }
                        }
                    }
                }
            }
        };
        this.aRR = tbPageContext;
        this.gaX = new ArrayList<>();
        this.fYt = new k();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.fYx);
        registerListener(this.fYx);
    }

    public String bdm() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Lx() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public k bgP() {
        return this.fYt;
    }

    public AntiData bbl() {
        return this.fIm;
    }

    public boolean bgQ() {
        return (this.fYt == null || this.fYt.bbd() == null) ? false : true;
    }

    public void a(a aVar) {
        this.gaT = aVar;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.threadID);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.threadID);
        markData.setFloor(postData.bwU());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fYx);
        if (this.fPe != null) {
            this.fPe.unRegisterListener();
        }
        aqT();
    }

    private void aqT() {
        if (this.dqh != null) {
            this.dqh.destory();
            this.dqh = null;
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

    public void qL(String str) {
        if (!TextUtils.isEmpty(str) && this.fYt != null && this.fYt.bbh() != null) {
            ArrayList<PostData> bbh = this.fYt.bbh();
            int size = bbh.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bbh.get(i).getId())) {
                    bbh.remove(i);
                    this.gaU++;
                    this.fYt.setTotalCount(this.fYt.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bgR() {
        int SC = this.fYt.SC();
        if (SC == 0) {
            return SC + 1;
        }
        if (this.mLoadType == 0) {
            return SC + 1;
        }
        if (this.mLoadType == 2 && this.fYt.bbh().size() != 0 && this.fYt.bbh().size() % this.fYt.bbj() == 0) {
            return SC + 1;
        }
        if (this.mLoadType == 3 && this.gaZ) {
            return this.fYt.bbf() - 1;
        }
        if (this.mLoadType == 3 && SC > 0) {
            return this.fYt.bbe() - 1;
        }
        return SC;
    }

    private SubPbRequestMessage bgf() {
        this.isLoading = true;
        return i((Integer) null);
    }

    private SubPbRequestMessage i(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int ao = l.ao(TbadkCoreApplication.getInst().getApp());
        int aq = l.aq(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = bgR();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.gaZ && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.aRR.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, ao, aq, f, this.stType, i2);
    }

    public boolean Nw() {
        return tm(0);
    }

    public boolean bgS() {
        return tm(2);
    }

    public void bgT() {
        int bbj;
        if (this.gaU > 0 && this.fYt != null && (bbj = this.fYt.bbj()) > 0) {
            int SC = this.fYt.SC();
            for (int i = (((this.gaU + bbj) - 1) / bbj) - 1; i >= 0; i--) {
                this.gbe = i(Integer.valueOf(SC - i));
                this.gbe.setTreatDelPage(true);
                sendMessage(this.gbe);
            }
        }
        this.gaU = 0;
    }

    public boolean bgU() {
        return tm(1);
    }

    public boolean tm(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.threadID == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bgT();
        this.mLoadType = i;
        this.gbe = bgf();
        sendMessage(this.gbe);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(k kVar) {
        ArrayList<PostData> bbh = kVar.bbh();
        if (bbh == null || bbh.size() == 0) {
            kVar.eW(this.fYt.SC());
        }
        if (this.mLoadType == 1) {
            this.fYt = kVar;
        } else if (this.mLoadType == 2) {
            this.fYt.b(kVar, true);
        } else if (this.mLoadType == 3) {
            this.fYt.a(kVar, false);
        } else {
            this.fYt.b(kVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (this.mLoadType == 1) {
            this.fYt = kVar;
            this.fYt.bbg();
        } else if (this.mLoadType == 2) {
            this.fYt.c(kVar, true);
        } else if (this.mLoadType == 3) {
            this.fYt.d(kVar, false);
        } else {
            this.fYt.a(kVar);
        }
    }

    public void g(k kVar) {
        String str;
        if (kVar.WE() == null || kVar.WE().zn() == null) {
            str = null;
        } else {
            str = kVar.WE().zn().getUserId();
        }
        if (!this.gaZ) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= kVar.bbh().size()) {
                    break;
                }
                kVar.bbh().get(i2).b(this.aRR, str.equals(kVar.bbh().get(i2).zn().getUserId()));
                i = i2 + 1;
            }
        }
        this.gaX.add(kVar);
    }

    public boolean bgt() {
        return this.gaN;
    }

    public boolean isMarked() {
        return this.fIn;
    }

    public boolean bgV() {
        return "hot_topic".equals(getStType());
    }

    public void lh(boolean z) {
        this.fIn = z;
    }

    public int baG() {
        return this.fHi;
    }

    public String bgW() {
        return this.gaS;
    }

    public void qM(String str) {
        this.gaS = str;
    }

    public String bgX() {
        return this.gaP;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gr(String str) {
        if (this.fYt == null || this.fYt.bbk() == null || this.fYt.WE() == null || this.fYt.bbd() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.fYt.bbk().getName());
        writeData.setForumId(this.fYt.bbk().getId());
        writeData.setFloor(this.fYt.bbd().getId());
        writeData.setType(2);
        writeData.setThreadId(this.fYt.WE().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Lw() {
        if (this.gbd) {
            bgZ();
        } else {
            bgS();
        }
        return true;
    }

    public boolean bgY() {
        return this.gbd;
    }

    public void li(boolean z) {
        this.gbd = z;
    }

    private void bgZ() {
        if (this.fPe == null) {
            this.fPe = new PbFakeFloorModel(this.aRR);
            this.fPe.setUniqueId(BdUniqueId.gen());
            this.fPe.d(this.fYt);
            this.fPe.setPostId(this.postID);
            this.fPe.a(this.fYw);
        }
        this.fPe.bge();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.fYw = aVar;
    }

    public SmallTailInfo bha() {
        return this.gaY;
    }

    public boolean bhb() {
        return this.gaW;
    }

    public ConcurrentHashMap<String, ImageUrlData> bhc() {
        return this.gbb;
    }

    public ArrayList<String> bhd() {
        return this.gba;
    }

    public boolean bhe() {
        return this.gbc;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String bhf() {
        return this.gaQ;
    }
}
