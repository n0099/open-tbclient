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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.SmallTailInfo;
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
/* loaded from: classes4.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private TbPageContext<?> cfl;
    private AntiData cuS;
    private com.baidu.tieba.tbadkCore.d.b fcZ;
    private int hIK;
    private boolean hJV;
    private PbFakeFloorModel hQn;
    private k iad;
    private PbFakeFloorModel.a iag;
    private com.baidu.adp.framework.listener.a iah;
    private String icH;
    private boolean icI;
    private String icJ;
    private String icK;
    private String icL;
    private String icM;
    private String icN;
    private boolean icO;
    private String icP;
    private a icQ;
    private int icR;
    private ArrayList<IconData> icS;
    private AttentionHostData icT;
    private boolean icU;
    private ArrayList<k> icV;
    private SmallTailInfo icW;
    private boolean icX;
    private ArrayList<String> icY;
    private ConcurrentHashMap<String, ImageUrlData> icZ;
    private boolean ida;
    private boolean idb;
    private SubPbRequestMessage idc;
    private boolean isLoading;
    private int mLoadType;
    private int mOffset;
    public int pageFromType;
    private String postID;
    private String stType;

    /* loaded from: classes4.dex */
    public interface a {
        void a(boolean z, int i, String str, k kVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.icH = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.icM = intent.getStringExtra("from_forum_id");
            this.icN = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.icI = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.icJ = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.icO = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.icK = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hIK = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.icW = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.icW != null) {
                this.icW.updateShowInfo();
            }
            this.cuS = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.icS = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.icU = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.icZ = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.icZ.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.icY = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.ida = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.icL = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.icH = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.icM = bundle.getString("from_forum_id");
            this.icN = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.icI = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.icJ = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.icO = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.icK = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hIK = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.icW = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.icW != null) {
                this.icW.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.cuS = new AntiData();
                this.cuS.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.isEmpty(stringArrayList)) {
                this.icS = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.icS.add(iconData);
                    }
                }
            }
            this.icU = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.icL = bundle.getString("high_light_post_id");
        }
    }

    public void aa(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.icH);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.icI);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.icJ);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.icK);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.icO);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.hIK);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.icW));
            if (this.cuS != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.cuS.toJsonString());
            }
            if (!v.isEmpty(this.icS)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.icS.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.icM);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.icN);
            bundle.putString("high_light_post_id", this.icL);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.icH = null;
        this.postID = null;
        this.stType = null;
        this.icI = false;
        this.icJ = null;
        this.icK = null;
        this.icL = null;
        this.pageFromType = 0;
        this.icO = false;
        this.hJV = false;
        this.hIK = 0;
        this.icP = null;
        this.cfl = null;
        this.iad = null;
        this.icQ = null;
        this.icR = 0;
        this.icU = false;
        this.icV = null;
        this.isLoading = false;
        this.fcZ = null;
        this.ida = true;
        this.mOffset = 0;
        this.hQn = null;
        this.iag = null;
        this.idb = false;
        this.iah = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                boolean z;
                k kVar;
                long j2;
                long j3;
                long j4 = 0;
                if (SubPbModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    SubPbModel.this.isLoading = false;
                    if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                        SubPbModel.this.cfl.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.icV.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.icV.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.icV != null && SubPbModel.this.icV.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.icV.size() - 1; size >= 0; size--) {
                                k kVar2 = (k) SubPbModel.this.icV.get(size);
                                if (SubPbModel.this.icX) {
                                    SubPbModel.this.iad.c(kVar2, true);
                                } else {
                                    SubPbModel.this.iad.b(kVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.icV.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.fcZ == null) {
                        SubPbModel.this.fcZ = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.fcZ != null) {
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
                            SubPbModel.this.fcZ.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.fcZ = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.fcZ = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.icQ != null) {
                                SubPbModel.this.icQ.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                kVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (kVar.bRh().errorno.intValue() != 0) {
                                if (SubPbModel.this.icQ != null) {
                                    SubPbModel.this.icQ.a(false, kVar.hJW.errorno.intValue(), kVar.hJW.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (kVar.agI() != null && kVar.agI().aiG() != null) {
                                kVar.agI().aiG().getUserId();
                                if (v.isEmpty(kVar.bRi().aiG().getIconInfo()) && SubPbModel.this.icS != null) {
                                    kVar.bRi().aiG().setIconInfo(SubPbModel.this.icS);
                                }
                            }
                            if (kVar.bRi() != null) {
                                SubPbModel.this.postID = kVar.bRi().getId();
                            }
                            if (kVar.agI() != null) {
                                SubPbModel.this.icH = kVar.agI().getId();
                                SubPbModel.this.hJV = kVar.afm();
                                SubPbModel.this.icP = kVar.agI().aiP();
                            }
                            if (SubPbModel.this.icP != null && SubPbModel.this.postID != null && SubPbModel.this.icP.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.hJV = true;
                            }
                            if (SubPbModel.this.icX) {
                                SubPbModel.this.f(kVar);
                            } else {
                                SubPbModel.this.e(kVar);
                            }
                            if (SubPbModel.this.icQ != null) {
                                SubPbModel.this.icQ.a(SubPbModel.this.bXv(), error, errorString, SubPbModel.this.iad);
                            }
                        }
                    }
                }
            }
        };
        this.cfl = tbPageContext;
        this.icV = new ArrayList<>();
        this.iad = new k();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.iah);
        registerListener(this.iah);
    }

    public String bTA() {
        return this.icH;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String auu() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public k bXu() {
        return this.iad;
    }

    public AntiData biZ() {
        return this.cuS;
    }

    public boolean bXv() {
        return (this.iad == null || this.iad.bRi() == null) ? false : true;
    }

    public void a(a aVar) {
        this.icQ = aVar;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.icH);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.icH);
        markData.setFloor(postData.cop());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.iah);
        if (this.hQn != null) {
            this.hQn.unRegisterListener();
        }
        beS();
    }

    private void beS() {
        if (this.fcZ != null) {
            this.fcZ.destory();
            this.fcZ = null;
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

    public void Bj(String str) {
        if (!TextUtils.isEmpty(str) && this.iad != null && this.iad.bRm() != null) {
            ArrayList<PostData> bRm = this.iad.bRm();
            int size = bRm.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bRm.get(i).getId())) {
                    bRm.remove(i);
                    this.icR++;
                    this.iad.setTotalCount(this.iad.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bXw() {
        int aBm = this.iad.aBm();
        if (aBm == 0) {
            return aBm + 1;
        }
        if (this.mLoadType == 0) {
            return aBm + 1;
        }
        if (this.mLoadType == 2 && this.iad.bRm().size() != 0 && this.iad.bRm().size() % this.iad.getPageSize() == 0) {
            return aBm + 1;
        }
        if (this.mLoadType == 3 && this.icX) {
            return this.iad.bRk() - 1;
        }
        if (this.mLoadType == 3 && aBm > 0) {
            return this.iad.bRj() - 1;
        }
        return aBm;
    }

    private SubPbRequestMessage bWF() {
        this.isLoading = true;
        return i((Integer) null);
    }

    private SubPbRequestMessage i(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.toLong(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.toLong(this.postID, 0L);
        }
        if (num == null) {
            intValue = bXw();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.icX && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.cfl.getPageActivity(), Long.parseLong(this.icH), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
    }

    public boolean loadData() {
        return xa(0);
    }

    public boolean bXx() {
        return xa(2);
    }

    public void bXy() {
        int pageSize;
        if (this.icR > 0 && this.iad != null && (pageSize = this.iad.getPageSize()) > 0) {
            int aBm = this.iad.aBm();
            for (int i = (((this.icR + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.idc = i(Integer.valueOf(aBm - i));
                this.idc.setTreatDelPage(true);
                sendMessage(this.idc);
            }
        }
        this.icR = 0;
    }

    public boolean bXz() {
        return xa(1);
    }

    public boolean xa(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.icH == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bXy();
        this.mLoadType = i;
        this.idc = bWF();
        sendMessage(this.idc);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(k kVar) {
        ArrayList<PostData> bRm = kVar.bRm();
        if (bRm == null || bRm.size() == 0) {
            kVar.setCurrentPage(this.iad.aBm());
        }
        if (this.mLoadType == 1) {
            this.iad = kVar;
        } else if (this.mLoadType == 2) {
            this.iad.b(kVar, true);
        } else if (this.mLoadType == 3) {
            this.iad.a(kVar, false);
        } else {
            this.iad.b(kVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (this.mLoadType == 1) {
            this.iad = kVar;
            this.iad.bRl();
        } else if (this.mLoadType == 2) {
            this.iad.c(kVar, true);
        } else if (this.mLoadType == 3) {
            this.iad.d(kVar, false);
        } else {
            this.iad.a(kVar);
        }
    }

    public boolean bWW() {
        return this.icI;
    }

    public boolean bXA() {
        return this.hJV;
    }

    public boolean bXB() {
        return "hot_topic".equals(getStType());
    }

    public void pe(boolean z) {
        this.hJV = z;
    }

    public int bQL() {
        return this.hIK;
    }

    public String bXC() {
        return this.icP;
    }

    public void Bk(String str) {
        this.icP = str;
    }

    public String bXD() {
        return this.icK;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData pG(String str) {
        if (this.iad == null || this.iad.bRo() == null || this.iad.agI() == null || this.iad.bRi() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.iad.bRo().getName());
        writeData.setForumId(this.iad.bRo().getId());
        writeData.setFromForumId(this.icN);
        writeData.setFloor(this.iad.bRi().getId());
        writeData.setType(2);
        writeData.setThreadId(this.iad.agI().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aut() {
        bXx();
        return true;
    }

    public boolean bXE() {
        return this.idb;
    }

    public void pf(boolean z) {
        this.idb = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.iag = aVar;
    }

    public SmallTailInfo bXF() {
        return this.icW;
    }

    public boolean bXG() {
        return this.icU;
    }

    public ConcurrentHashMap<String, ImageUrlData> bXH() {
        return this.icZ;
    }

    public ArrayList<String> bXI() {
        return this.icY;
    }

    public boolean bXJ() {
        return this.ida;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.icM;
    }

    public AttentionHostData bXK() {
        if (this.icT == null) {
            this.icT = new AttentionHostData();
            if (this.iad != null && this.iad.agI() != null && this.iad.agI().aiG() != null) {
                this.icT.parserWithMetaData(this.iad.agI().aiG());
            }
        }
        return this.icT;
    }

    public boolean bUq() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public String bTz() {
        return this.icL;
    }
}
