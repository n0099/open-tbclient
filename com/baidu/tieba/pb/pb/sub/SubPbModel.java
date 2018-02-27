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
    private TbPageContext<?> aRG;
    private com.baidu.tieba.tbadkCore.d.b dpV;
    private int fGX;
    private AntiData fIb;
    private boolean fIc;
    private PbFakeFloorModel fOT;
    private k fYi;
    private PbFakeFloorModel.a fYl;
    private com.baidu.adp.framework.listener.a fYm;
    private boolean gaC;
    private String gaD;
    private String gaE;
    private String gaF;
    private boolean gaG;
    private String gaH;
    private a gaI;
    private int gaJ;
    private ArrayList<IconData> gaK;
    private boolean gaL;
    private ArrayList<k> gaM;
    private SmallTailInfo gaN;
    private boolean gaO;
    private ArrayList<String> gaP;
    private ConcurrentHashMap<String, ImageUrlData> gaQ;
    private boolean gaR;
    private boolean gaS;
    private SubPbRequestMessage gaT;
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
            this.gaF = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.gaC = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.gaD = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.gaG = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.gaE = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fGX = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.gaN = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.gaN != null) {
                this.gaN.updateShowInfo();
            }
            this.fIb = (AntiData) intent.getSerializableExtra("anti");
            this.gaK = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.gaL = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.gaQ = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.gaQ.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.gaP = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.gaR = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
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
            this.gaF = bundle.getString(SubPbActivityConfig.KEY_FROM_FORUM_ID);
            this.gaC = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.gaD = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.gaG = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.gaE = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fGX = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.gaN = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.gaN != null) {
                this.gaN.updateShowInfo();
            }
            String string2 = bundle.getString("anti");
            if (!StringUtils.isNull(string2)) {
                this.fIb = new AntiData();
                this.fIb.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.E(stringArrayList)) {
                this.gaK = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.gaK.add(iconData);
                    }
                }
            }
            this.gaL = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void D(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.threadID);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.gaC);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.gaD);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.gaE);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.gaG);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fGX);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.gaN));
            if (this.fIb != null) {
                bundle.putSerializable("anti", this.fIb.toJsonString());
            }
            if (!v.E(this.gaK)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.gaK.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FORUM_ID, this.gaF);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.threadID = null;
        this.postID = null;
        this.stType = null;
        this.gaC = false;
        this.gaD = null;
        this.gaE = null;
        this.pageFromType = 0;
        this.gaG = false;
        this.fIc = false;
        this.fGX = 0;
        this.gaH = null;
        this.aRG = null;
        this.fYi = null;
        this.gaI = null;
        this.gaJ = 0;
        this.gaL = false;
        this.gaM = null;
        this.isLoading = false;
        this.dpV = null;
        this.gaR = true;
        this.mOffset = 0;
        this.fOT = null;
        this.fYl = null;
        this.gaS = false;
        this.fYm = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.aRG.getPageActivity().finish();
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
                    if (SubPbModel.this.gaM != null && SubPbModel.this.gaM.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.gaM.size() - 1; size >= 0; size--) {
                                k kVar2 = (k) SubPbModel.this.gaM.get(size);
                                if (SubPbModel.this.gaO) {
                                    SubPbModel.this.fYi.c(kVar2, true);
                                } else {
                                    SubPbModel.this.fYi.b(kVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.gaM.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.dpV == null) {
                        SubPbModel.this.dpV = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.dpV != null) {
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
                            SubPbModel.this.dpV.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.dpV = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.dpV = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.gaI != null) {
                                SubPbModel.this.gaI.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                kVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (kVar.bbb().errorno.intValue() != 0) {
                                if (SubPbModel.this.gaI != null) {
                                    SubPbModel.this.gaI.a(false, kVar.fId.errorno.intValue(), kVar.fId.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (kVar.WD() != null && kVar.WD().zn() != null) {
                                str = kVar.WD().zn().getUserId();
                                if (v.E(kVar.bbc().zn().getIconInfo()) && SubPbModel.this.gaK != null) {
                                    kVar.bbc().zn().setIconInfo(SubPbModel.this.gaK);
                                }
                            }
                            if (!SubPbModel.this.gaO) {
                                for (int i2 = 0; i2 < kVar.bbg().size(); i2++) {
                                    kVar.bbg().get(i2).b(SubPbModel.this.aRG, str.equals(kVar.bbg().get(i2).zn().getUserId()));
                                }
                            }
                            if (kVar.bbc() != null) {
                                SubPbModel.this.postID = kVar.bbc().getId();
                            }
                            if (kVar.WD() != null) {
                                SubPbModel.this.threadID = kVar.WD().getId();
                                SubPbModel.this.fIc = kVar.vX();
                                SubPbModel.this.gaH = kVar.WD().zx();
                            }
                            if (SubPbModel.this.gaH != null && SubPbModel.this.postID != null && SubPbModel.this.gaH.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fIc = true;
                            }
                            if (SubPbModel.this.gaO) {
                                SubPbModel.this.f(kVar);
                            } else {
                                SubPbModel.this.e(kVar);
                            }
                            if (SubPbModel.this.gaI != null) {
                                SubPbModel.this.gaI.a(SubPbModel.this.bgP(), error, errorString, SubPbModel.this.fYi);
                            }
                        }
                    }
                }
            }
        };
        this.aRG = tbPageContext;
        this.gaM = new ArrayList<>();
        this.fYi = new k();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.fYm);
        registerListener(this.fYm);
    }

    public String bdl() {
        return this.threadID;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Lw() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public k bgO() {
        return this.fYi;
    }

    public AntiData bbk() {
        return this.fIb;
    }

    public boolean bgP() {
        return (this.fYi == null || this.fYi.bbc() == null) ? false : true;
    }

    public void a(a aVar) {
        this.gaI = aVar;
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
        markData.setFloor(postData.bwT());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fYm);
        if (this.fOT != null) {
            this.fOT.unRegisterListener();
        }
        aqS();
    }

    private void aqS() {
        if (this.dpV != null) {
            this.dpV.destory();
            this.dpV = null;
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
        if (!TextUtils.isEmpty(str) && this.fYi != null && this.fYi.bbg() != null) {
            ArrayList<PostData> bbg = this.fYi.bbg();
            int size = bbg.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bbg.get(i).getId())) {
                    bbg.remove(i);
                    this.gaJ++;
                    this.fYi.setTotalCount(this.fYi.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bgQ() {
        int SB = this.fYi.SB();
        if (SB == 0) {
            return SB + 1;
        }
        if (this.mLoadType == 0) {
            return SB + 1;
        }
        if (this.mLoadType == 2 && this.fYi.bbg().size() != 0 && this.fYi.bbg().size() % this.fYi.bbi() == 0) {
            return SB + 1;
        }
        if (this.mLoadType == 3 && this.gaO) {
            return this.fYi.bbe() - 1;
        }
        if (this.mLoadType == 3 && SB > 0) {
            return this.fYi.bbd() - 1;
        }
        return SB;
    }

    private SubPbRequestMessage bge() {
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
            intValue = bgQ();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.gaO && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.aRG.getPageActivity(), Long.parseLong(this.threadID), j, j2, i, ao, aq, f, this.stType, i2);
    }

    public boolean Nv() {
        return tn(0);
    }

    public boolean bgR() {
        return tn(2);
    }

    public void bgS() {
        int bbi;
        if (this.gaJ > 0 && this.fYi != null && (bbi = this.fYi.bbi()) > 0) {
            int SB = this.fYi.SB();
            for (int i = (((this.gaJ + bbi) - 1) / bbi) - 1; i >= 0; i--) {
                this.gaT = i(Integer.valueOf(SB - i));
                this.gaT.setTreatDelPage(true);
                sendMessage(this.gaT);
            }
        }
        this.gaJ = 0;
    }

    public boolean bgT() {
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
        bgS();
        this.mLoadType = i;
        this.gaT = bge();
        sendMessage(this.gaT);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(k kVar) {
        ArrayList<PostData> bbg = kVar.bbg();
        if (bbg == null || bbg.size() == 0) {
            kVar.eW(this.fYi.SB());
        }
        if (this.mLoadType == 1) {
            this.fYi = kVar;
        } else if (this.mLoadType == 2) {
            this.fYi.b(kVar, true);
        } else if (this.mLoadType == 3) {
            this.fYi.a(kVar, false);
        } else {
            this.fYi.b(kVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (this.mLoadType == 1) {
            this.fYi = kVar;
            this.fYi.bbf();
        } else if (this.mLoadType == 2) {
            this.fYi.c(kVar, true);
        } else if (this.mLoadType == 3) {
            this.fYi.d(kVar, false);
        } else {
            this.fYi.a(kVar);
        }
    }

    public void g(k kVar) {
        String str;
        if (kVar.WD() == null || kVar.WD().zn() == null) {
            str = null;
        } else {
            str = kVar.WD().zn().getUserId();
        }
        if (!this.gaO) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= kVar.bbg().size()) {
                    break;
                }
                kVar.bbg().get(i2).b(this.aRG, str.equals(kVar.bbg().get(i2).zn().getUserId()));
                i = i2 + 1;
            }
        }
        this.gaM.add(kVar);
    }

    public boolean bgs() {
        return this.gaC;
    }

    public boolean isMarked() {
        return this.fIc;
    }

    public boolean bgU() {
        return "hot_topic".equals(getStType());
    }

    public void lh(boolean z) {
        this.fIc = z;
    }

    public int baF() {
        return this.fGX;
    }

    public String bgV() {
        return this.gaH;
    }

    public void qM(String str) {
        this.gaH = str;
    }

    public String bgW() {
        return this.gaE;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData gr(String str) {
        if (this.fYi == null || this.fYi.bbj() == null || this.fYi.WD() == null || this.fYi.bbc() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.fYi.bbj().getName());
        writeData.setForumId(this.fYi.bbj().getId());
        writeData.setFloor(this.fYi.bbc().getId());
        writeData.setType(2);
        writeData.setThreadId(this.fYi.WD().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Lv() {
        if (this.gaS) {
            bgY();
        } else {
            bgR();
        }
        return true;
    }

    public boolean bgX() {
        return this.gaS;
    }

    public void li(boolean z) {
        this.gaS = z;
    }

    private void bgY() {
        if (this.fOT == null) {
            this.fOT = new PbFakeFloorModel(this.aRG);
            this.fOT.setUniqueId(BdUniqueId.gen());
            this.fOT.d(this.fYi);
            this.fOT.setPostId(this.postID);
            this.fOT.a(this.fYl);
        }
        this.fOT.bgd();
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.fYl = aVar;
    }

    public SmallTailInfo bgZ() {
        return this.gaN;
    }

    public boolean bha() {
        return this.gaL;
    }

    public ConcurrentHashMap<String, ImageUrlData> bhb() {
        return this.gaQ;
    }

    public ArrayList<String> bhc() {
        return this.gaP;
    }

    public boolean bhd() {
        return this.gaR;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String bhe() {
        return this.gaF;
    }
}
