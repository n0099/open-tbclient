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
    private int fHC;
    private boolean fID;
    private PbFakeFloorModel fOX;
    private j fYo;
    private PbFakeFloorModel.a fYr;
    private com.baidu.adp.framework.listener.a fYs;
    private String gaM;
    private boolean gaN;
    private String gaO;
    private String gaP;
    private String gaQ;
    private String gaR;
    private boolean gaS;
    private String gaT;
    private a gaU;
    private int gaV;
    private ArrayList<IconData> gaW;
    private AttentionHostData gaX;
    private boolean gaY;
    private ArrayList<j> gaZ;
    private SmallTailInfo gba;
    private boolean gbb;
    private ArrayList<String> gbc;
    private ConcurrentHashMap<String, ImageUrlData> gbd;
    private boolean gbe;
    private boolean gbf;
    private SubPbRequestMessage gbg;
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
            this.gaM = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.gaQ = intent.getStringExtra("from_forum_id");
            this.gaR = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.gaN = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.gaO = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.gaS = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.gaP = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fHC = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.gba = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.gba != null) {
                this.gba.updateShowInfo();
            }
            this.aJw = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.gaW = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.gaY = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.gbd = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.gbd.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.gbc = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.gbe = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.gaM = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.gaQ = bundle.getString("from_forum_id");
            this.gaR = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.gaN = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.gaO = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.gaS = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.gaP = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fHC = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.gba = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.gba != null) {
                this.gba.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.aJw = new AntiData();
                this.aJw.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.J(stringArrayList)) {
                this.gaW = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.gaW.add(iconData);
                    }
                }
            }
            this.gaY = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void A(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.gaM);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.gaN);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.gaO);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.gaP);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.gaS);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fHC);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.gba));
            if (this.aJw != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.aJw.toJsonString());
            }
            if (!v.J(this.gaW)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.gaW.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.gaQ);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.gaR);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.gaM = null;
        this.postID = null;
        this.stType = null;
        this.gaN = false;
        this.gaO = null;
        this.gaP = null;
        this.pageFromType = 0;
        this.gaS = false;
        this.fID = false;
        this.fHC = 0;
        this.gaT = null;
        this.mContext = null;
        this.fYo = null;
        this.gaU = null;
        this.gaV = 0;
        this.gaY = false;
        this.gaZ = null;
        this.isLoading = false;
        this.dhz = null;
        this.gbe = true;
        this.mOffset = 0;
        this.fOX = null;
        this.fYr = null;
        this.gbf = false;
        this.fYs = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.gaZ.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.gaZ.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.gaZ != null && SubPbModel.this.gaZ.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.gaZ.size() - 1; size >= 0; size--) {
                                j jVar2 = (j) SubPbModel.this.gaZ.get(size);
                                if (SubPbModel.this.gbb) {
                                    SubPbModel.this.fYo.c(jVar2, true);
                                } else {
                                    SubPbModel.this.fYo.b(jVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.gaZ.clear();
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
                            if (SubPbModel.this.gaU != null) {
                                SubPbModel.this.gaU.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                jVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                jVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (jVar.bfB().errorno.intValue() != 0) {
                                if (SubPbModel.this.gaU != null) {
                                    SubPbModel.this.gaU.a(false, jVar.fIE.errorno.intValue(), jVar.fIE.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (jVar.YA() != null && jVar.YA().yv() != null) {
                                jVar.YA().yv().getUserId();
                                if (v.J(jVar.bfC().yv().getIconInfo()) && SubPbModel.this.gaW != null) {
                                    jVar.bfC().yv().setIconInfo(SubPbModel.this.gaW);
                                }
                            }
                            if (jVar.bfC() != null) {
                                SubPbModel.this.postID = jVar.bfC().getId();
                            }
                            if (jVar.YA() != null) {
                                SubPbModel.this.gaM = jVar.YA().getId();
                                SubPbModel.this.fID = jVar.vc();
                                SubPbModel.this.gaT = jVar.YA().yF();
                            }
                            if (SubPbModel.this.gaT != null && SubPbModel.this.postID != null && SubPbModel.this.gaT.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fID = true;
                            }
                            if (SubPbModel.this.gbb) {
                                SubPbModel.this.f(jVar);
                            } else {
                                SubPbModel.this.e(jVar);
                            }
                            if (SubPbModel.this.gaU != null) {
                                SubPbModel.this.gaU.a(SubPbModel.this.blA(), error, errorString, SubPbModel.this.fYo);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.gaZ = new ArrayList<>();
        this.fYo = new j();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.fYs);
        registerListener(this.fYs);
    }

    public String bhP() {
        return this.gaM;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Lc() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public j blz() {
        return this.fYo;
    }

    public AntiData ayP() {
        return this.aJw;
    }

    public boolean blA() {
        return (this.fYo == null || this.fYo.bfC() == null) ? false : true;
    }

    public void a(a aVar) {
        this.gaU = aVar;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.gaM);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.gaM);
        markData.setFloor(postData.bCb());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.fYs);
        if (this.fOX != null) {
            this.fOX.unRegisterListener();
        }
        aus();
    }

    private void aus() {
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
        if (!TextUtils.isEmpty(str) && this.fYo != null && this.fYo.bfG() != null) {
            ArrayList<PostData> bfG = this.fYo.bfG();
            int size = bfG.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bfG.get(i).getId())) {
                    bfG.remove(i);
                    this.gaV++;
                    this.fYo.setTotalCount(this.fYo.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int blB() {
        int SJ = this.fYo.SJ();
        if (SJ == 0) {
            return SJ + 1;
        }
        if (this.mLoadType == 0) {
            return SJ + 1;
        }
        if (this.mLoadType == 2 && this.fYo.bfG().size() != 0 && this.fYo.bfG().size() % this.fYo.bfI() == 0) {
            return SJ + 1;
        }
        if (this.mLoadType == 3 && this.gbb) {
            return this.fYo.bfE() - 1;
        }
        if (this.mLoadType == 3 && SJ > 0) {
            return this.fYo.bfD() - 1;
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
        if (this.gbb && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.gaM), j, j2, i, aO, aQ, f, this.stType, i2);
    }

    public boolean Nj() {
        return rV(0);
    }

    public boolean blC() {
        return rV(2);
    }

    public void blD() {
        int bfI;
        if (this.gaV > 0 && this.fYo != null && (bfI = this.fYo.bfI()) > 0) {
            int SJ = this.fYo.SJ();
            for (int i = (((this.gaV + bfI) - 1) / bfI) - 1; i >= 0; i--) {
                this.gbg = p(Integer.valueOf(SJ - i));
                this.gbg.setTreatDelPage(true);
                sendMessage(this.gbg);
            }
        }
        this.gaV = 0;
    }

    public boolean blE() {
        return rV(1);
    }

    public boolean rV(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.gaM == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        blD();
        this.mLoadType = i;
        this.gbg = bkN();
        sendMessage(this.gbg);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(j jVar) {
        ArrayList<PostData> bfG = jVar.bfG();
        if (bfG == null || bfG.size() == 0) {
            jVar.setCurrentPage(this.fYo.SJ());
        }
        if (this.mLoadType == 1) {
            this.fYo = jVar;
        } else if (this.mLoadType == 2) {
            this.fYo.b(jVar, true);
        } else if (this.mLoadType == 3) {
            this.fYo.a(jVar, false);
        } else {
            this.fYo.b(jVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(j jVar) {
        if (this.mLoadType == 1) {
            this.fYo = jVar;
            this.fYo.bfF();
        } else if (this.mLoadType == 2) {
            this.fYo.c(jVar, true);
        } else if (this.mLoadType == 3) {
            this.fYo.d(jVar, false);
        } else {
            this.fYo.a(jVar);
        }
    }

    public boolean ble() {
        return this.gaN;
    }

    public boolean isMarked() {
        return this.fID;
    }

    public boolean blF() {
        return "hot_topic".equals(getStType());
    }

    public void lz(boolean z) {
        this.fID = z;
    }

    public int bfh() {
        return this.fHC;
    }

    public String blG() {
        return this.gaT;
    }

    public void sO(String str) {
        this.gaT = str;
    }

    public String blH() {
        return this.gaP;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hr(String str) {
        if (this.fYo == null || this.fYo.bfJ() == null || this.fYo.YA() == null || this.fYo.bfC() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.fYo.bfJ().getName());
        writeData.setForumId(this.fYo.bfJ().getId());
        writeData.setFromForumId(this.gaR);
        writeData.setFloor(this.fYo.bfC().getId());
        writeData.setType(2);
        writeData.setThreadId(this.fYo.YA().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Lb() {
        blC();
        return true;
    }

    public boolean blI() {
        return this.gbf;
    }

    public void lA(boolean z) {
        this.gbf = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.fYr = aVar;
    }

    public SmallTailInfo blJ() {
        return this.gba;
    }

    public boolean blK() {
        return this.gaY;
    }

    public ConcurrentHashMap<String, ImageUrlData> blL() {
        return this.gbd;
    }

    public ArrayList<String> blM() {
        return this.gbc;
    }

    public boolean blN() {
        return this.gbe;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.gaQ;
    }

    public AttentionHostData blO() {
        if (this.gaX == null) {
            this.gaX = new AttentionHostData();
            if (this.fYo != null && this.fYo.YA() != null && this.fYo.YA().yv() != null) {
                this.gaX.parserWithMetaData(this.fYo.YA().yv());
            }
        }
        return this.gaX;
    }
}
