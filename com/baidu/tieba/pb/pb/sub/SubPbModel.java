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
    private AntiData aOq;
    private com.baidu.tieba.tbadkCore.d.b dsH;
    private int fTH;
    private boolean fUI;
    private PbFakeFloorModel gbd;
    private j gkC;
    private PbFakeFloorModel.a gkF;
    private com.baidu.adp.framework.listener.a gkG;
    private String gmW;
    private boolean gmX;
    private String gmY;
    private String gmZ;
    private String gna;
    private String gnb;
    private boolean gnc;
    private String gnd;
    private a gne;
    private int gnf;
    private ArrayList<IconData> gng;
    private AttentionHostData gnh;
    private boolean gni;
    private ArrayList<j> gnj;
    private SmallTailInfo gnk;
    private boolean gnl;
    private ArrayList<String> gnm;
    private ConcurrentHashMap<String, ImageUrlData> gnn;
    private boolean gno;
    private boolean gnp;
    private SubPbRequestMessage gnq;
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
            this.gmW = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.gna = intent.getStringExtra("from_forum_id");
            this.gnb = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.gmX = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.gmY = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.gnc = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.gmZ = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fTH = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.gnk = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.gnk != null) {
                this.gnk.updateShowInfo();
            }
            this.aOq = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.gng = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.gni = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.gnn = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.gnn.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.gnm = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.gno = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.gmW = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.gna = bundle.getString("from_forum_id");
            this.gnb = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.gmX = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.gmY = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.gnc = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.gmZ = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fTH = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.gnk = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.gnk != null) {
                this.gnk.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.aOq = new AntiData();
                this.aOq.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.I(stringArrayList)) {
                this.gng = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.gng.add(iconData);
                    }
                }
            }
            this.gni = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void G(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.gmW);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.gmX);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.gmY);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.gmZ);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.gnc);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fTH);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.gnk));
            if (this.aOq != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.aOq.toJsonString());
            }
            if (!v.I(this.gng)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.gng.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.gna);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.gnb);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.gmW = null;
        this.postID = null;
        this.stType = null;
        this.gmX = false;
        this.gmY = null;
        this.gmZ = null;
        this.pageFromType = 0;
        this.gnc = false;
        this.fUI = false;
        this.fTH = 0;
        this.gnd = null;
        this.mContext = null;
        this.gkC = null;
        this.gne = null;
        this.gnf = 0;
        this.gni = false;
        this.gnj = null;
        this.isLoading = false;
        this.dsH = null;
        this.gno = true;
        this.mOffset = 0;
        this.gbd = null;
        this.gkF = null;
        this.gnp = false;
        this.gkG = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.gnj.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.gnj.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.gnj != null && SubPbModel.this.gnj.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.gnj.size() - 1; size >= 0; size--) {
                                j jVar2 = (j) SubPbModel.this.gnj.get(size);
                                if (SubPbModel.this.gnl) {
                                    SubPbModel.this.gkC.c(jVar2, true);
                                } else {
                                    SubPbModel.this.gkC.b(jVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.gnj.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.dsH == null) {
                        SubPbModel.this.dsH = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.dsH != null) {
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
                            SubPbModel.this.dsH.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.dsH = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.dsH = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.gne != null) {
                                SubPbModel.this.gne.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                jVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                jVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (jVar.bif().errorno.intValue() != 0) {
                                if (SubPbModel.this.gne != null) {
                                    SubPbModel.this.gne.a(false, jVar.fUJ.errorno.intValue(), jVar.fUJ.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (jVar.aaq() != null && jVar.aaq().zT() != null) {
                                jVar.aaq().zT().getUserId();
                                if (v.I(jVar.big().zT().getIconInfo()) && SubPbModel.this.gng != null) {
                                    jVar.big().zT().setIconInfo(SubPbModel.this.gng);
                                }
                            }
                            if (jVar.big() != null) {
                                SubPbModel.this.postID = jVar.big().getId();
                            }
                            if (jVar.aaq() != null) {
                                SubPbModel.this.gmW = jVar.aaq().getId();
                                SubPbModel.this.fUI = jVar.wx();
                                SubPbModel.this.gnd = jVar.aaq().Ad();
                            }
                            if (SubPbModel.this.gnd != null && SubPbModel.this.postID != null && SubPbModel.this.gnd.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fUI = true;
                            }
                            if (SubPbModel.this.gnl) {
                                SubPbModel.this.f(jVar);
                            } else {
                                SubPbModel.this.e(jVar);
                            }
                            if (SubPbModel.this.gne != null) {
                                SubPbModel.this.gne.a(SubPbModel.this.boi(), error, errorString, SubPbModel.this.gkC);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.gnj = new ArrayList<>();
        this.gkC = new j();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.gkG);
        registerListener(this.gkG);
    }

    public String bkt() {
        return this.gmW;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String MK() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public j boh() {
        return this.gkC;
    }

    public AntiData aBj() {
        return this.aOq;
    }

    public boolean boi() {
        return (this.gkC == null || this.gkC.big() == null) ? false : true;
    }

    public void a(a aVar) {
        this.gne = aVar;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.gmW);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.gmW);
        markData.setFloor(postData.bES());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.gkG);
        if (this.gbd != null) {
            this.gbd.unRegisterListener();
        }
        awO();
    }

    private void awO() {
        if (this.dsH != null) {
            this.dsH.destory();
            this.dsH = null;
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
        if (!TextUtils.isEmpty(str) && this.gkC != null && this.gkC.bik() != null) {
            ArrayList<PostData> bik = this.gkC.bik();
            int size = bik.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bik.get(i).getId())) {
                    bik.remove(i);
                    this.gnf++;
                    this.gkC.setTotalCount(this.gkC.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int boj() {
        int Uw = this.gkC.Uw();
        if (Uw == 0) {
            return Uw + 1;
        }
        if (this.mLoadType == 0) {
            return Uw + 1;
        }
        if (this.mLoadType == 2 && this.gkC.bik().size() != 0 && this.gkC.bik().size() % this.gkC.getPageSize() == 0) {
            return Uw + 1;
        }
        if (this.mLoadType == 3 && this.gnl) {
            return this.gkC.bii() - 1;
        }
        if (this.mLoadType == 3 && Uw > 0) {
            return this.gkC.bih() - 1;
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
        if (this.gnl && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.gmW), j, j2, i, aO, aQ, f, this.stType, i2);
    }

    public boolean OP() {
        return sZ(0);
    }

    public boolean bok() {
        return sZ(2);
    }

    public void bol() {
        int pageSize;
        if (this.gnf > 0 && this.gkC != null && (pageSize = this.gkC.getPageSize()) > 0) {
            int Uw = this.gkC.Uw();
            for (int i = (((this.gnf + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.gnq = p(Integer.valueOf(Uw - i));
                this.gnq.setTreatDelPage(true);
                sendMessage(this.gnq);
            }
        }
        this.gnf = 0;
    }

    public boolean bom() {
        return sZ(1);
    }

    public boolean sZ(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.gmW == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bol();
        this.mLoadType = i;
        this.gnq = bnw();
        sendMessage(this.gnq);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(j jVar) {
        ArrayList<PostData> bik = jVar.bik();
        if (bik == null || bik.size() == 0) {
            jVar.setCurrentPage(this.gkC.Uw());
        }
        if (this.mLoadType == 1) {
            this.gkC = jVar;
        } else if (this.mLoadType == 2) {
            this.gkC.b(jVar, true);
        } else if (this.mLoadType == 3) {
            this.gkC.a(jVar, false);
        } else {
            this.gkC.b(jVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(j jVar) {
        if (this.mLoadType == 1) {
            this.gkC = jVar;
            this.gkC.bij();
        } else if (this.mLoadType == 2) {
            this.gkC.c(jVar, true);
        } else if (this.mLoadType == 3) {
            this.gkC.d(jVar, false);
        } else {
            this.gkC.a(jVar);
        }
    }

    public boolean bnM() {
        return this.gmX;
    }

    public boolean isMarked() {
        return this.fUI;
    }

    public boolean bon() {
        return "hot_topic".equals(getStType());
    }

    public void lQ(boolean z) {
        this.fUI = z;
    }

    public int bhL() {
        return this.fTH;
    }

    public String boo() {
        return this.gnd;
    }

    public void tK(String str) {
        this.gnd = str;
    }

    public String bop() {
        return this.gmZ;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hZ(String str) {
        if (this.gkC == null || this.gkC.bim() == null || this.gkC.aaq() == null || this.gkC.big() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.gkC.bim().getName());
        writeData.setForumId(this.gkC.bim().getId());
        writeData.setFromForumId(this.gnb);
        writeData.setFloor(this.gkC.big().getId());
        writeData.setType(2);
        writeData.setThreadId(this.gkC.aaq().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean MJ() {
        bok();
        return true;
    }

    public boolean boq() {
        return this.gnp;
    }

    public void lR(boolean z) {
        this.gnp = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.gkF = aVar;
    }

    public SmallTailInfo bor() {
        return this.gnk;
    }

    public boolean bos() {
        return this.gni;
    }

    public ConcurrentHashMap<String, ImageUrlData> bot() {
        return this.gnn;
    }

    public ArrayList<String> bou() {
        return this.gnm;
    }

    public boolean bov() {
        return this.gno;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.gna;
    }

    public AttentionHostData bow() {
        if (this.gnh == null) {
            this.gnh = new AttentionHostData();
            if (this.gkC != null && this.gkC.aaq() != null && this.gkC.aaq().zT() != null) {
                this.gnh.parserWithMetaData(this.gkC.aaq().zT());
            }
        }
        return this.gnh;
    }
}
