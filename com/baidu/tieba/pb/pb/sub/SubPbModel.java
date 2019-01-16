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
import com.baidu.tieba.pb.data.j;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private AntiData aOp;
    private com.baidu.tieba.tbadkCore.d.b dsG;
    private int fTG;
    private boolean fUH;
    private PbFakeFloorModel gbc;
    private j gkB;
    private PbFakeFloorModel.a gkE;
    private com.baidu.adp.framework.listener.a gkF;
    private String gmV;
    private boolean gmW;
    private String gmX;
    private String gmY;
    private String gmZ;
    private String gna;
    private boolean gnb;
    private String gnc;
    private a gnd;
    private int gne;
    private ArrayList<IconData> gnf;
    private AttentionHostData gng;
    private boolean gnh;
    private ArrayList<j> gni;
    private SmallTailInfo gnj;
    private boolean gnk;
    private ArrayList<String> gnl;
    private ConcurrentHashMap<String, ImageUrlData> gnm;
    private boolean gnn;
    private boolean gno;
    private SubPbRequestMessage gnp;
    private boolean isLoading;
    private TbPageContext<?> mContext;
    private int mLoadType;
    private int mOffset;
    public int pageFromType;
    private String postID;
    private String stType;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, int i, String str, j jVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.gmV = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.gmZ = intent.getStringExtra("from_forum_id");
            this.gna = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.gmW = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.gmX = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.gnb = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.gmY = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fTG = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.gnj = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.gnj != null) {
                this.gnj.updateShowInfo();
            }
            this.aOp = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.gnf = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.gnh = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.gnm = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.gnm.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.gnl = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.gnn = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.gmV = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.gmZ = bundle.getString("from_forum_id");
            this.gna = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.gmW = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.gmX = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.gnb = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.gmY = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fTG = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.gnj = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.gnj != null) {
                this.gnj.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.aOp = new AntiData();
                this.aOp.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.I(stringArrayList)) {
                this.gnf = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.gnf.add(iconData);
                    }
                }
            }
            this.gnh = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void G(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.gmV);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.gmW);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.gmX);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.gmY);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.gnb);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fTG);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.gnj));
            if (this.aOp != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.aOp.toJsonString());
            }
            if (!v.I(this.gnf)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.gnf.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.gmZ);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.gna);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.gmV = null;
        this.postID = null;
        this.stType = null;
        this.gmW = false;
        this.gmX = null;
        this.gmY = null;
        this.pageFromType = 0;
        this.gnb = false;
        this.fUH = false;
        this.fTG = 0;
        this.gnc = null;
        this.mContext = null;
        this.gkB = null;
        this.gnd = null;
        this.gne = 0;
        this.gnh = false;
        this.gni = null;
        this.isLoading = false;
        this.dsG = null;
        this.gnn = true;
        this.mOffset = 0;
        this.gbc = null;
        this.gkE = null;
        this.gno = false;
        this.gkF = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                boolean z;
                j jVar;
                long j2;
                long j3;
                long j4 = 0;
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
                                SubPbModel.this.gni.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.gni.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.gni != null && SubPbModel.this.gni.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.gni.size() - 1; size >= 0; size--) {
                                j jVar2 = (j) SubPbModel.this.gni.get(size);
                                if (SubPbModel.this.gnk) {
                                    SubPbModel.this.gkB.c(jVar2, true);
                                } else {
                                    SubPbModel.this.gkB.b(jVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.gni.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.dsG == null) {
                        SubPbModel.this.dsG = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.dsG != null) {
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
                            SubPbModel.this.dsG.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.dsG = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.dsG = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.gnd != null) {
                                SubPbModel.this.gnd.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                jVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                jVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (jVar.bif().errorno.intValue() != 0) {
                                if (SubPbModel.this.gnd != null) {
                                    SubPbModel.this.gnd.a(false, jVar.fUI.errorno.intValue(), jVar.fUI.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (jVar.aaq() != null && jVar.aaq().zT() != null) {
                                jVar.aaq().zT().getUserId();
                                if (v.I(jVar.big().zT().getIconInfo()) && SubPbModel.this.gnf != null) {
                                    jVar.big().zT().setIconInfo(SubPbModel.this.gnf);
                                }
                            }
                            if (jVar.big() != null) {
                                SubPbModel.this.postID = jVar.big().getId();
                            }
                            if (jVar.aaq() != null) {
                                SubPbModel.this.gmV = jVar.aaq().getId();
                                SubPbModel.this.fUH = jVar.wx();
                                SubPbModel.this.gnc = jVar.aaq().Ad();
                            }
                            if (SubPbModel.this.gnc != null && SubPbModel.this.postID != null && SubPbModel.this.gnc.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fUH = true;
                            }
                            if (SubPbModel.this.gnk) {
                                SubPbModel.this.f(jVar);
                            } else {
                                SubPbModel.this.e(jVar);
                            }
                            if (SubPbModel.this.gnd != null) {
                                SubPbModel.this.gnd.a(SubPbModel.this.boi(), error, errorString, SubPbModel.this.gkB);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.gni = new ArrayList<>();
        this.gkB = new j();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.gkF);
        registerListener(this.gkF);
    }

    public String bkt() {
        return this.gmV;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String MK() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public j boh() {
        return this.gkB;
    }

    public AntiData aBj() {
        return this.aOp;
    }

    public boolean boi() {
        return (this.gkB == null || this.gkB.big() == null) ? false : true;
    }

    public void a(a aVar) {
        this.gnd = aVar;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.gmV);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.gmV);
        markData.setFloor(postData.bES());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.gkF);
        if (this.gbc != null) {
            this.gbc.unRegisterListener();
        }
        awO();
    }

    private void awO() {
        if (this.dsG != null) {
            this.dsG.destory();
            this.dsG = null;
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

    public void tJ(String str) {
        if (!TextUtils.isEmpty(str) && this.gkB != null && this.gkB.bik() != null) {
            ArrayList<PostData> bik = this.gkB.bik();
            int size = bik.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bik.get(i).getId())) {
                    bik.remove(i);
                    this.gne++;
                    this.gkB.setTotalCount(this.gkB.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int boj() {
        int Uw = this.gkB.Uw();
        if (Uw == 0) {
            return Uw + 1;
        }
        if (this.mLoadType == 0) {
            return Uw + 1;
        }
        if (this.mLoadType == 2 && this.gkB.bik().size() != 0 && this.gkB.bik().size() % this.gkB.getPageSize() == 0) {
            return Uw + 1;
        }
        if (this.mLoadType == 3 && this.gnk) {
            return this.gkB.bii() - 1;
        }
        if (this.mLoadType == 3 && Uw > 0) {
            return this.gkB.bih() - 1;
        }
        return Uw;
    }

    private SubPbRequestMessage bnw() {
        this.isLoading = true;
        return p(null);
    }

    private SubPbRequestMessage p(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int aO = l.aO(TbadkCoreApplication.getInst().getApp());
        int aQ = l.aQ(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.d(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.d(this.postID, 0L);
        }
        if (num == null) {
            intValue = boj();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.gnk && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.gmV), j, j2, i, aO, aQ, f, this.stType, i2);
    }

    public boolean OP() {
        return sZ(0);
    }

    public boolean bok() {
        return sZ(2);
    }

    public void bol() {
        int pageSize;
        if (this.gne > 0 && this.gkB != null && (pageSize = this.gkB.getPageSize()) > 0) {
            int Uw = this.gkB.Uw();
            for (int i = (((this.gne + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.gnp = p(Integer.valueOf(Uw - i));
                this.gnp.setTreatDelPage(true);
                sendMessage(this.gnp);
            }
        }
        this.gne = 0;
    }

    public boolean bom() {
        return sZ(1);
    }

    public boolean sZ(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.gmV == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bol();
        this.mLoadType = i;
        this.gnp = bnw();
        sendMessage(this.gnp);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(j jVar) {
        ArrayList<PostData> bik = jVar.bik();
        if (bik == null || bik.size() == 0) {
            jVar.setCurrentPage(this.gkB.Uw());
        }
        if (this.mLoadType == 1) {
            this.gkB = jVar;
        } else if (this.mLoadType == 2) {
            this.gkB.b(jVar, true);
        } else if (this.mLoadType == 3) {
            this.gkB.a(jVar, false);
        } else {
            this.gkB.b(jVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(j jVar) {
        if (this.mLoadType == 1) {
            this.gkB = jVar;
            this.gkB.bij();
        } else if (this.mLoadType == 2) {
            this.gkB.c(jVar, true);
        } else if (this.mLoadType == 3) {
            this.gkB.d(jVar, false);
        } else {
            this.gkB.a(jVar);
        }
    }

    public boolean bnM() {
        return this.gmW;
    }

    public boolean isMarked() {
        return this.fUH;
    }

    public boolean bon() {
        return "hot_topic".equals(getStType());
    }

    public void lQ(boolean z) {
        this.fUH = z;
    }

    public int bhL() {
        return this.fTG;
    }

    public String boo() {
        return this.gnc;
    }

    public void tK(String str) {
        this.gnc = str;
    }

    public String bop() {
        return this.gmY;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hZ(String str) {
        if (this.gkB == null || this.gkB.bim() == null || this.gkB.aaq() == null || this.gkB.big() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.gkB.bim().getName());
        writeData.setForumId(this.gkB.bim().getId());
        writeData.setFromForumId(this.gna);
        writeData.setFloor(this.gkB.big().getId());
        writeData.setType(2);
        writeData.setThreadId(this.gkB.aaq().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean MJ() {
        bok();
        return true;
    }

    public boolean boq() {
        return this.gno;
    }

    public void lR(boolean z) {
        this.gno = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.gkE = aVar;
    }

    public SmallTailInfo bor() {
        return this.gnj;
    }

    public boolean bos() {
        return this.gnh;
    }

    public ConcurrentHashMap<String, ImageUrlData> bot() {
        return this.gnm;
    }

    public ArrayList<String> bou() {
        return this.gnl;
    }

    public boolean bov() {
        return this.gnn;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.gmZ;
    }

    public AttentionHostData bow() {
        if (this.gng == null) {
            this.gng = new AttentionHostData();
            if (this.gkB != null && this.gkB.aaq() != null && this.gkB.aaq().zT() != null) {
                this.gng.parserWithMetaData(this.gkB.aaq().zT());
            }
        }
        return this.gng;
    }
}
