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
    private AntiData aJw;
    private com.baidu.tieba.tbadkCore.d.b dhz;
    private int fHD;
    private boolean fIE;
    private PbFakeFloorModel fOY;
    private j fYp;
    private PbFakeFloorModel.a fYs;
    private com.baidu.adp.framework.listener.a fYt;
    private String gaN;
    private boolean gaO;
    private String gaP;
    private String gaQ;
    private String gaR;
    private String gaS;
    private boolean gaT;
    private String gaU;
    private a gaV;
    private int gaW;
    private ArrayList<IconData> gaX;
    private AttentionHostData gaY;
    private boolean gaZ;
    private ArrayList<j> gba;
    private SmallTailInfo gbb;
    private boolean gbc;
    private ArrayList<String> gbd;
    private ConcurrentHashMap<String, ImageUrlData> gbe;
    private boolean gbf;
    private boolean gbg;
    private SubPbRequestMessage gbh;
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
            this.gaN = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.gaR = intent.getStringExtra("from_forum_id");
            this.gaS = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.gaO = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.gaP = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.gaT = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.gaQ = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fHD = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.gbb = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.gbb != null) {
                this.gbb.updateShowInfo();
            }
            this.aJw = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.gaX = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.gaZ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.gbe = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.gbe.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.gbd = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.gbf = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.gaN = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.gaR = bundle.getString("from_forum_id");
            this.gaS = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.gaO = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.gaP = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.gaT = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.gaQ = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fHD = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.gbb = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.gbb != null) {
                this.gbb.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.aJw = new AntiData();
                this.aJw.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.J(stringArrayList)) {
                this.gaX = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.gaX.add(iconData);
                    }
                }
            }
            this.gaZ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void A(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.gaN);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.gaO);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.gaP);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.gaQ);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.gaT);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fHD);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.gbb));
            if (this.aJw != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.aJw.toJsonString());
            }
            if (!v.J(this.gaX)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.gaX.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.gaR);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.gaS);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.gaN = null;
        this.postID = null;
        this.stType = null;
        this.gaO = false;
        this.gaP = null;
        this.gaQ = null;
        this.pageFromType = 0;
        this.gaT = false;
        this.fIE = false;
        this.fHD = 0;
        this.gaU = null;
        this.mContext = null;
        this.fYp = null;
        this.gaV = null;
        this.gaW = 0;
        this.gaZ = false;
        this.gba = null;
        this.isLoading = false;
        this.dhz = null;
        this.gbf = true;
        this.mOffset = 0;
        this.fOY = null;
        this.fYs = null;
        this.gbg = false;
        this.fYt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.gba.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.gba.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.gba != null && SubPbModel.this.gba.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.gba.size() - 1; size >= 0; size--) {
                                j jVar2 = (j) SubPbModel.this.gba.get(size);
                                if (SubPbModel.this.gbc) {
                                    SubPbModel.this.fYp.c(jVar2, true);
                                } else {
                                    SubPbModel.this.fYp.b(jVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.gba.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.dhz == null) {
                        SubPbModel.this.dhz = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.dhz != null) {
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
                            SubPbModel.this.dhz.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.dhz = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.dhz = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.gaV != null) {
                                SubPbModel.this.gaV.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                jVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                jVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (jVar.bfB().errorno.intValue() != 0) {
                                if (SubPbModel.this.gaV != null) {
                                    SubPbModel.this.gaV.a(false, jVar.fIF.errorno.intValue(), jVar.fIF.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (jVar.YB() != null && jVar.YB().yv() != null) {
                                jVar.YB().yv().getUserId();
                                if (v.J(jVar.bfC().yv().getIconInfo()) && SubPbModel.this.gaX != null) {
                                    jVar.bfC().yv().setIconInfo(SubPbModel.this.gaX);
                                }
                            }
                            if (jVar.bfC() != null) {
                                SubPbModel.this.postID = jVar.bfC().getId();
                            }
                            if (jVar.YB() != null) {
                                SubPbModel.this.gaN = jVar.YB().getId();
                                SubPbModel.this.fIE = jVar.vc();
                                SubPbModel.this.gaU = jVar.YB().yF();
                            }
                            if (SubPbModel.this.gaU != null && SubPbModel.this.postID != null && SubPbModel.this.gaU.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fIE = true;
                            }
                            if (SubPbModel.this.gbc) {
                                SubPbModel.this.f(jVar);
                            } else {
                                SubPbModel.this.e(jVar);
                            }
                            if (SubPbModel.this.gaV != null) {
                                SubPbModel.this.gaV.a(SubPbModel.this.blA(), error, errorString, SubPbModel.this.fYp);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.gba = new ArrayList<>();
        this.fYp = new j();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.fYt);
        registerListener(this.fYt);
    }

    public String bhP() {
        return this.gaN;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Lc() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public j blz() {
        return this.fYp;
    }

    public AntiData ayQ() {
        return this.aJw;
    }

    public boolean blA() {
        return (this.fYp == null || this.fYp.bfC() == null) ? false : true;
    }

    public void a(a aVar) {
        this.gaV = aVar;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.gaN);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.gaN);
        markData.setFloor(postData.bCb());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fYt);
        if (this.fOY != null) {
            this.fOY.unRegisterListener();
        }
        aut();
    }

    private void aut() {
        if (this.dhz != null) {
            this.dhz.destory();
            this.dhz = null;
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

    public void sN(String str) {
        if (!TextUtils.isEmpty(str) && this.fYp != null && this.fYp.bfG() != null) {
            ArrayList<PostData> bfG = this.fYp.bfG();
            int size = bfG.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bfG.get(i).getId())) {
                    bfG.remove(i);
                    this.gaW++;
                    this.fYp.setTotalCount(this.fYp.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int blB() {
        int SJ = this.fYp.SJ();
        if (SJ == 0) {
            return SJ + 1;
        }
        if (this.mLoadType == 0) {
            return SJ + 1;
        }
        if (this.mLoadType == 2 && this.fYp.bfG().size() != 0 && this.fYp.bfG().size() % this.fYp.bfI() == 0) {
            return SJ + 1;
        }
        if (this.mLoadType == 3 && this.gbc) {
            return this.fYp.bfE() - 1;
        }
        if (this.mLoadType == 3 && SJ > 0) {
            return this.fYp.bfD() - 1;
        }
        return SJ;
    }

    private SubPbRequestMessage bkN() {
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
            intValue = blB();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.gbc && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.gaN), j, j2, i, aO, aQ, f, this.stType, i2);
    }

    public boolean Nj() {
        return rV(0);
    }

    public boolean blC() {
        return rV(2);
    }

    public void blD() {
        int bfI;
        if (this.gaW > 0 && this.fYp != null && (bfI = this.fYp.bfI()) > 0) {
            int SJ = this.fYp.SJ();
            for (int i = (((this.gaW + bfI) - 1) / bfI) - 1; i >= 0; i--) {
                this.gbh = p(Integer.valueOf(SJ - i));
                this.gbh.setTreatDelPage(true);
                sendMessage(this.gbh);
            }
        }
        this.gaW = 0;
    }

    public boolean blE() {
        return rV(1);
    }

    public boolean rV(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.gaN == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        blD();
        this.mLoadType = i;
        this.gbh = bkN();
        sendMessage(this.gbh);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(j jVar) {
        ArrayList<PostData> bfG = jVar.bfG();
        if (bfG == null || bfG.size() == 0) {
            jVar.setCurrentPage(this.fYp.SJ());
        }
        if (this.mLoadType == 1) {
            this.fYp = jVar;
        } else if (this.mLoadType == 2) {
            this.fYp.b(jVar, true);
        } else if (this.mLoadType == 3) {
            this.fYp.a(jVar, false);
        } else {
            this.fYp.b(jVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(j jVar) {
        if (this.mLoadType == 1) {
            this.fYp = jVar;
            this.fYp.bfF();
        } else if (this.mLoadType == 2) {
            this.fYp.c(jVar, true);
        } else if (this.mLoadType == 3) {
            this.fYp.d(jVar, false);
        } else {
            this.fYp.a(jVar);
        }
    }

    public boolean ble() {
        return this.gaO;
    }

    public boolean isMarked() {
        return this.fIE;
    }

    public boolean blF() {
        return "hot_topic".equals(getStType());
    }

    public void lz(boolean z) {
        this.fIE = z;
    }

    public int bfh() {
        return this.fHD;
    }

    public String blG() {
        return this.gaU;
    }

    public void sO(String str) {
        this.gaU = str;
    }

    public String blH() {
        return this.gaQ;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hr(String str) {
        if (this.fYp == null || this.fYp.bfJ() == null || this.fYp.YB() == null || this.fYp.bfC() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.fYp.bfJ().getName());
        writeData.setForumId(this.fYp.bfJ().getId());
        writeData.setFromForumId(this.gaS);
        writeData.setFloor(this.fYp.bfC().getId());
        writeData.setType(2);
        writeData.setThreadId(this.fYp.YB().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Lb() {
        blC();
        return true;
    }

    public boolean blI() {
        return this.gbg;
    }

    public void lA(boolean z) {
        this.gbg = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.fYs = aVar;
    }

    public SmallTailInfo blJ() {
        return this.gbb;
    }

    public boolean blK() {
        return this.gaZ;
    }

    public ConcurrentHashMap<String, ImageUrlData> blL() {
        return this.gbe;
    }

    public ArrayList<String> blM() {
        return this.gbd;
    }

    public boolean blN() {
        return this.gbf;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.gaR;
    }

    public AttentionHostData blO() {
        if (this.gaY == null) {
            this.gaY = new AttentionHostData();
            if (this.fYp != null && this.fYp.YB() != null && this.fYp.YB().yv() != null) {
                this.gaY.parserWithMetaData(this.fYp.YB().yv());
            }
        }
        return this.gaY;
    }
}
