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
    private AntiData aNL;
    private com.baidu.tieba.tbadkCore.d.b dph;
    private int fPR;
    private boolean fQS;
    private PbFakeFloorModel fXn;
    private j ggF;
    private PbFakeFloorModel.a ggI;
    private com.baidu.adp.framework.listener.a ggJ;
    private String gjb;
    private boolean gjc;
    private String gjd;
    private String gje;
    private String gjf;
    private String gjg;
    private boolean gjh;
    private String gji;
    private a gjj;
    private int gjk;
    private ArrayList<IconData> gjl;
    private AttentionHostData gjm;
    private boolean gjn;
    private ArrayList<j> gjo;
    private SmallTailInfo gjp;
    private boolean gjq;
    private ArrayList<String> gjr;
    private ConcurrentHashMap<String, ImageUrlData> gjs;
    private boolean gjt;
    private boolean gju;
    private SubPbRequestMessage gjv;
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
            this.gjb = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.gjf = intent.getStringExtra("from_forum_id");
            this.gjg = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.gjc = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.gjd = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.gjh = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.gje = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fPR = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.gjp = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.gjp != null) {
                this.gjp.updateShowInfo();
            }
            this.aNL = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.gjl = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.gjn = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.gjs = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.gjs.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.gjr = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.gjt = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.gjb = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.gjf = bundle.getString("from_forum_id");
            this.gjg = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.gjc = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.gjd = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.gjh = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.gje = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.fPR = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.gjp = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.gjp != null) {
                this.gjp.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.aNL = new AntiData();
                this.aNL.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.I(stringArrayList)) {
                this.gjl = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.gjl.add(iconData);
                    }
                }
            }
            this.gjn = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        }
    }

    public void G(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.gjb);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.gjc);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.gjd);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.gje);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.gjh);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.fPR);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.gjp));
            if (this.aNL != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.aNL.toJsonString());
            }
            if (!v.I(this.gjl)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.gjl.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.gjf);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.gjg);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.gjb = null;
        this.postID = null;
        this.stType = null;
        this.gjc = false;
        this.gjd = null;
        this.gje = null;
        this.pageFromType = 0;
        this.gjh = false;
        this.fQS = false;
        this.fPR = 0;
        this.gji = null;
        this.mContext = null;
        this.ggF = null;
        this.gjj = null;
        this.gjk = 0;
        this.gjn = false;
        this.gjo = null;
        this.isLoading = false;
        this.dph = null;
        this.gjt = true;
        this.mOffset = 0;
        this.fXn = null;
        this.ggI = null;
        this.gju = false;
        this.ggJ = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.gjo.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.gjo.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.gjo != null && SubPbModel.this.gjo.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.gjo.size() - 1; size >= 0; size--) {
                                j jVar2 = (j) SubPbModel.this.gjo.get(size);
                                if (SubPbModel.this.gjq) {
                                    SubPbModel.this.ggF.c(jVar2, true);
                                } else {
                                    SubPbModel.this.ggF.b(jVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.gjo.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.dph == null) {
                        SubPbModel.this.dph = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.dph != null) {
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
                            SubPbModel.this.dph.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.dph = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.dph = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.gjj != null) {
                                SubPbModel.this.gjj.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                jVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                jVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (jVar.bgP().errorno.intValue() != 0) {
                                if (SubPbModel.this.gjj != null) {
                                    SubPbModel.this.gjj.a(false, jVar.fQT.errorno.intValue(), jVar.fQT.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (jVar.ZR() != null && jVar.ZR().zG() != null) {
                                jVar.ZR().zG().getUserId();
                                if (v.I(jVar.bgQ().zG().getIconInfo()) && SubPbModel.this.gjl != null) {
                                    jVar.bgQ().zG().setIconInfo(SubPbModel.this.gjl);
                                }
                            }
                            if (jVar.bgQ() != null) {
                                SubPbModel.this.postID = jVar.bgQ().getId();
                            }
                            if (jVar.ZR() != null) {
                                SubPbModel.this.gjb = jVar.ZR().getId();
                                SubPbModel.this.fQS = jVar.wq();
                                SubPbModel.this.gji = jVar.ZR().zQ();
                            }
                            if (SubPbModel.this.gji != null && SubPbModel.this.postID != null && SubPbModel.this.gji.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.fQS = true;
                            }
                            if (SubPbModel.this.gjq) {
                                SubPbModel.this.f(jVar);
                            } else {
                                SubPbModel.this.e(jVar);
                            }
                            if (SubPbModel.this.gjj != null) {
                                SubPbModel.this.gjj.a(SubPbModel.this.bmO(), error, errorString, SubPbModel.this.ggF);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.gjo = new ArrayList<>();
        this.ggF = new j();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.ggJ);
        registerListener(this.ggJ);
    }

    public String bjd() {
        return this.gjb;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Ms() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public j bmN() {
        return this.ggF;
    }

    public AntiData azX() {
        return this.aNL;
    }

    public boolean bmO() {
        return (this.ggF == null || this.ggF.bgQ() == null) ? false : true;
    }

    public void a(a aVar) {
        this.gjj = aVar;
    }

    public MarkData h(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.gjb);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.gjb);
        markData.setFloor(postData.bDr());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.ggJ);
        if (this.fXn != null) {
            this.fXn.unRegisterListener();
        }
        avC();
    }

    private void avC() {
        if (this.dph != null) {
            this.dph.destory();
            this.dph = null;
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

    public void tq(String str) {
        if (!TextUtils.isEmpty(str) && this.ggF != null && this.ggF.bgU() != null) {
            ArrayList<PostData> bgU = this.ggF.bgU();
            int size = bgU.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bgU.get(i).getId())) {
                    bgU.remove(i);
                    this.gjk++;
                    this.ggF.setTotalCount(this.ggF.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bmP() {
        int TY = this.ggF.TY();
        if (TY == 0) {
            return TY + 1;
        }
        if (this.mLoadType == 0) {
            return TY + 1;
        }
        if (this.mLoadType == 2 && this.ggF.bgU().size() != 0 && this.ggF.bgU().size() % this.ggF.getPageSize() == 0) {
            return TY + 1;
        }
        if (this.mLoadType == 3 && this.gjq) {
            return this.ggF.bgS() - 1;
        }
        if (this.mLoadType == 3 && TY > 0) {
            return this.ggF.bgR() - 1;
        }
        return TY;
    }

    private SubPbRequestMessage bmc() {
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
            intValue = bmP();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.gjq && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.gjb), j, j2, i, aO, aQ, f, this.stType, i2);
    }

    public boolean Ow() {
        return sI(0);
    }

    public boolean bmQ() {
        return sI(2);
    }

    public void bmR() {
        int pageSize;
        if (this.gjk > 0 && this.ggF != null && (pageSize = this.ggF.getPageSize()) > 0) {
            int TY = this.ggF.TY();
            for (int i = (((this.gjk + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.gjv = p(Integer.valueOf(TY - i));
                this.gjv.setTreatDelPage(true);
                sendMessage(this.gjv);
            }
        }
        this.gjk = 0;
    }

    public boolean bmS() {
        return sI(1);
    }

    public boolean sI(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.gjb == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bmR();
        this.mLoadType = i;
        this.gjv = bmc();
        sendMessage(this.gjv);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(j jVar) {
        ArrayList<PostData> bgU = jVar.bgU();
        if (bgU == null || bgU.size() == 0) {
            jVar.setCurrentPage(this.ggF.TY());
        }
        if (this.mLoadType == 1) {
            this.ggF = jVar;
        } else if (this.mLoadType == 2) {
            this.ggF.b(jVar, true);
        } else if (this.mLoadType == 3) {
            this.ggF.a(jVar, false);
        } else {
            this.ggF.b(jVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(j jVar) {
        if (this.mLoadType == 1) {
            this.ggF = jVar;
            this.ggF.bgT();
        } else if (this.mLoadType == 2) {
            this.ggF.c(jVar, true);
        } else if (this.mLoadType == 3) {
            this.ggF.d(jVar, false);
        } else {
            this.ggF.a(jVar);
        }
    }

    public boolean bms() {
        return this.gjc;
    }

    public boolean isMarked() {
        return this.fQS;
    }

    public boolean bmT() {
        return "hot_topic".equals(getStType());
    }

    public void lN(boolean z) {
        this.fQS = z;
    }

    public int bgv() {
        return this.fPR;
    }

    public String bmU() {
        return this.gji;
    }

    public void tr(String str) {
        this.gji = str;
    }

    public String bmV() {
        return this.gje;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData hK(String str) {
        if (this.ggF == null || this.ggF.bgW() == null || this.ggF.ZR() == null || this.ggF.bgQ() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.ggF.bgW().getName());
        writeData.setForumId(this.ggF.bgW().getId());
        writeData.setFromForumId(this.gjg);
        writeData.setFloor(this.ggF.bgQ().getId());
        writeData.setType(2);
        writeData.setThreadId(this.ggF.ZR().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Mr() {
        bmQ();
        return true;
    }

    public boolean bmW() {
        return this.gju;
    }

    public void lO(boolean z) {
        this.gju = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.ggI = aVar;
    }

    public SmallTailInfo bmX() {
        return this.gjp;
    }

    public boolean bmY() {
        return this.gjn;
    }

    public ConcurrentHashMap<String, ImageUrlData> bmZ() {
        return this.gjs;
    }

    public ArrayList<String> bna() {
        return this.gjr;
    }

    public boolean bnb() {
        return this.gjt;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.gjf;
    }

    public AttentionHostData bnc() {
        if (this.gjm == null) {
            this.gjm = new AttentionHostData();
            if (this.ggF != null && this.ggF.ZR() != null && this.ggF.ZR().zG() != null) {
                this.gjm.parserWithMetaData(this.ggF.ZR().zG());
            }
        }
        return this.gjm;
    }
}
