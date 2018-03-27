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
    private TbPageContext<?> aRI;
    private com.baidu.tieba.tbadkCore.d.b dpY;
    private int fHn;
    private AntiData fIr;
    private boolean fIs;
    private PbFakeFloorModel fPj;
    private PbFakeFloorModel.a fYB;
    private com.baidu.adp.framework.listener.a fYC;
    private k fYy;
    private boolean gaS;
    private String gaT;
    private String gaU;
    private String gaV;
    private boolean gaW;
    private String gaX;
    private a gaY;
    private int gaZ;
    private ArrayList<IconData> gba;
    private boolean gbb;
    private ArrayList<k> gbc;
    private SmallTailInfo gbd;
    private boolean gbe;
    private ArrayList<String> gbf;
    private ConcurrentHashMap<String, ImageUrlData> gbg;
    private boolean gbh;
    private boolean gbi;
    private SubPbRequestMessage gbj;
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
            this.gaV = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.gaS = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.gaT = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.gaW = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.gaU = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fHn = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.gbd = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.gbd != null) {
                this.gbd.updateShowInfo();
            }
            this.fIr = (AntiData) intent.getSerializableExtra("anti");
            this.gba = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.gbb = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.gbg = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.gbg.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.gbf = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.gbh = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
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
            this.gaV = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.gaS = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.gaT = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.gaW = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.gaU = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fHn = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.gbd = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.gbd != null) {
                this.gbd.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.fIr = new AntiData();
                this.fIr.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.E(stringArrayList)) {
                this.gba = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.gba.add(iconData);
                    }
                }
            }
            this.gbb = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void D(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.gaS);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.gaT);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.gaU);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.gaW);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fHn);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.gbd));
            if (this.fIr != null) {
                bundle.putSerializable("anti", this.fIr.toJsonString());
            }
            if (!v.E(this.gba)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.gba.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.gaV);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.gaS = false;
        this.gaT = null;
        this.gaU = null;
        this.pageFromType = 0;
        this.gaW = false;
        this.fIs = false;
        this.fHn = 0;
        this.gaX = null;
        this.aRI = null;
        this.fYy = null;
        this.gaY = null;
        this.gaZ = 0;
        this.gbb = false;
        this.gbc = null;
        this.isLoading = false;
        this.dpY = null;
        this.gbh = true;
        this.mOffset = 0;
        this.fPj = null;
        this.fYB = null;
        this.gbi = false;
        this.fYC = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.aRI.getPageActivity().finish();
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
                    if (SubPbModel.this.gbc != null && SubPbModel.this.gbc.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.gbc.size() - 1; size >= 0; size--) {
                                k kVar2 = (k) SubPbModel.this.gbc.get(size);
                                if (SubPbModel.this.gbe) {
                                    SubPbModel.this.fYy.c(kVar2, true);
                                } else {
                                    SubPbModel.this.fYy.b(kVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.gbc.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.dpY == null) {
                        SubPbModel.this.dpY = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.dpY != null) {
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
                            SubPbModel.this.dpY.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.dpY = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.dpY = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.gaY != null) {
                                SubPbModel.this.gaY.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                kVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (kVar.bbc().errorno.intValue() != 0) {
                                if (SubPbModel.this.gaY != null) {
                                    SubPbModel.this.gaY.a(false, kVar.fIt.errorno.intValue(), kVar.fIt.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (kVar.WE() != null && kVar.WE().zn() != null) {
                                str = kVar.WE().zn().getUserId();
                                if (v.E(kVar.bbd().zn().getIconInfo()) && SubPbModel.this.gba != null) {
                                    kVar.bbd().zn().setIconInfo(SubPbModel.this.gba);
                                }
                            }
                            if (!SubPbModel.this.gbe) {
                                for (int i2 = 0; i2 < kVar.bbh().size(); i2++) {
                                    kVar.bbh().get(i2).b(SubPbModel.this.aRI, str.equals(kVar.bbh().get(i2).zn().getUserId()));
                                }
                            }
                            if (kVar.bbd() != null) {
                                SubPbModel.this.postID = kVar.bbd().getId();
                            }
                            if (kVar.WE() != null) {
                                SubPbModel.this.threadID = kVar.WE().getId();
                                SubPbModel.this.fIs = kVar.vX();
                                SubPbModel.this.gaX = kVar.WE().zx();
                            }
                            if (SubPbModel.this.gaX != null && SubPbModel.this.postID != null && SubPbModel.this.gaX.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fIs = true;
                            }
                            if (SubPbModel.this.gbe) {
                                SubPbModel.this.f(kVar);
                            } else {
                                SubPbModel.this.e(kVar);
                            }
                            if (SubPbModel.this.gaY != null) {
                                SubPbModel.this.gaY.a(SubPbModel.this.bgQ(), error, errorString, SubPbModel.this.fYy);
                            }
                        }
                    }
                }
            }
        };
        this.aRI = tbPageContext;
        this.gbc = new ArrayList<>();
        this.fYy = new k();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.fYC);
        registerListener(this.fYC);
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
        return this.fYy;
    }

    public AntiData bbl() {
        return this.fIr;
    }

    public boolean bgQ() {
        return (this.fYy == null || this.fYy.bbd() == null) ? false : true;
    }

    public void a(a aVar) {
        this.gaY = aVar;
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
        markData.setFloor(postData.bwY());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fYC);
        if (this.fPj != null) {
            this.fPj.unRegisterListener();
        }
        aqT();
    }

    private void aqT() {
        if (this.dpY != null) {
            this.dpY.destory();
            this.dpY = null;
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
        if (!TextUtils.isEmpty(str) && this.fYy != null && this.fYy.bbh() != null) {
            ArrayList<PostData> bbh = this.fYy.bbh();
            int size = bbh.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bbh.get(i).getId())) {
                    bbh.remove(i);
                    this.gaZ++;
                    this.fYy.setTotalCount(this.fYy.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bgR() {
        int SC = this.fYy.SC();
        if (SC == 0) {
            return SC + 1;
        }
        if (this.mLoadType == 0) {
            return SC + 1;
        }
        if (this.mLoadType == 2 && this.fYy.bbh().size() != 0 && this.fYy.bbh().size() % this.fYy.bbj() == 0) {
            return SC + 1;
        }
        if (this.mLoadType == 3 && this.gbe) {
            return this.fYy.bbf() - 1;
        }
        if (this.mLoadType == 3 && SC > 0) {
            return this.fYy.bbe() - 1;
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
        if (this.gbe && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.aRI.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, ao, aq, f, this.stType, i2);
    }

    public boolean Nw() {
        return tn(0);
    }

    public boolean bgS() {
        return tn(2);
    }

    public void bgT() {
        int bbj;
        if (this.gaZ > 0 && this.fYy != null && (bbj = this.fYy.bbj()) > 0) {
            int SC = this.fYy.SC();
            for (int i = (((this.gaZ + bbj) - 1) / bbj) - 1; i >= 0; i--) {
                this.gbj = i(Integer.valueOf(SC - i));
                this.gbj.setTreatDelPage(true);
                sendMessage(this.gbj);
            }
        }
        this.gaZ = 0;
    }

    public boolean bgU() {
        return tn(1);
    }

    public boolean tn(int i) {
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
        this.gbj = bgf();
        sendMessage(this.gbj);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(k kVar) {
        ArrayList<PostData> bbh = kVar.bbh();
        if (bbh == null || bbh.size() == 0) {
            kVar.eW(this.fYy.SC());
        }
        if (this.mLoadType == 1) {
            this.fYy = kVar;
        } else if (this.mLoadType == 2) {
            this.fYy.b(kVar, true);
        } else if (this.mLoadType == 3) {
            this.fYy.a(kVar, false);
        } else {
            this.fYy.b(kVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (this.mLoadType == 1) {
            this.fYy = kVar;
            this.fYy.bbg();
        } else if (this.mLoadType == 2) {
            this.fYy.c(kVar, true);
        } else if (this.mLoadType == 3) {
            this.fYy.d(kVar, false);
        } else {
            this.fYy.a(kVar);
        }
    }

    public void g(k kVar) {
        String str;
        if (kVar.WE() == null || kVar.WE().zn() == null) {
            str = null;
        } else {
            str = kVar.WE().zn().getUserId();
        }
        if (!this.gbe) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= kVar.bbh().size()) {
                    break;
                }
                kVar.bbh().get(i2).b(this.aRI, str.equals(kVar.bbh().get(i2).zn().getUserId()));
                i = i2 + 1;
            }
        }
        this.gbc.add(kVar);
    }

    public boolean bgt() {
        return this.gaS;
    }

    public boolean isMarked() {
        return this.fIs;
    }

    public boolean bgV() {
        return "hot_topic".equals(getStType());
    }

    public void lm(boolean z) {
        this.fIs = z;
    }

    public int baG() {
        return this.fHn;
    }

    public String bgW() {
        return this.gaX;
    }

    public void qM(String str) {
        this.gaX = str;
    }

    public String bgX() {
        return this.gaU;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gr(String str) {
        if (this.fYy == null || this.fYy.bbk() == null || this.fYy.WE() == null || this.fYy.bbd() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.fYy.bbk().getName());
        writeData.setForumId(this.fYy.bbk().getId());
        writeData.setFloor(this.fYy.bbd().getId());
        writeData.setType(2);
        writeData.setThreadId(this.fYy.WE().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Lw() {
        if (this.gbi) {
            bgZ();
        } else {
            bgS();
        }
        return true;
    }

    public boolean bgY() {
        return this.gbi;
    }

    public void ln(boolean z) {
        this.gbi = z;
    }

    private void bgZ() {
        if (this.fPj == null) {
            this.fPj = new PbFakeFloorModel(this.aRI);
            this.fPj.setUniqueId(BdUniqueId.gen());
            this.fPj.d(this.fYy);
            this.fPj.setPostId(this.postID);
            this.fPj.a(this.fYB);
        }
        this.fPj.bge();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.fYB = aVar;
    }

    public SmallTailInfo bha() {
        return this.gbd;
    }

    public boolean bhb() {
        return this.gbb;
    }

    public ConcurrentHashMap<String, ImageUrlData> bhc() {
        return this.gbg;
    }

    public ArrayList<String> bhd() {
        return this.gbf;
    }

    public boolean bhe() {
        return this.gbh;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String bhf() {
        return this.gaV;
    }
}
