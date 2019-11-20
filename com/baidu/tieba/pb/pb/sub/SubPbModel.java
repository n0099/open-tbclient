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
    private TbPageContext<?> ceu;
    private AntiData cua;
    private com.baidu.tieba.tbadkCore.d.b fci;
    private int hHT;
    private boolean hJe;
    private PbFakeFloorModel hPw;
    private k hZm;
    private PbFakeFloorModel.a hZp;
    private com.baidu.adp.framework.listener.a hZq;
    private String ibQ;
    private boolean ibR;
    private String ibS;
    private String ibT;
    private String ibU;
    private String ibV;
    private String ibW;
    private boolean ibX;
    private String ibY;
    private a ibZ;
    private int ica;
    private ArrayList<IconData> icb;
    private AttentionHostData icc;
    private boolean icd;
    private ArrayList<k> ice;
    private SmallTailInfo icf;
    private boolean icg;
    private ArrayList<String> ich;
    private ConcurrentHashMap<String, ImageUrlData> ici;
    private boolean icj;
    private boolean ick;
    private SubPbRequestMessage icl;
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
            this.ibQ = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.ibV = intent.getStringExtra("from_forum_id");
            this.ibW = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.ibR = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.ibS = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.ibX = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.ibT = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hHT = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.icf = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.icf != null) {
                this.icf.updateShowInfo();
            }
            this.cua = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.icb = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.icd = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.ici = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.ici.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.ich = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.icj = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.ibU = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.ibQ = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.ibV = bundle.getString("from_forum_id");
            this.ibW = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.ibR = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.ibS = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.ibX = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.ibT = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hHT = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.icf = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.icf != null) {
                this.icf.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.cua = new AntiData();
                this.cua.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.isEmpty(stringArrayList)) {
                this.icb = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.icb.add(iconData);
                    }
                }
            }
            this.icd = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.ibU = bundle.getString("high_light_post_id");
        }
    }

    public void aa(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.ibQ);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.ibR);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.ibS);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.ibT);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.ibX);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.hHT);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.icf));
            if (this.cua != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.cua.toJsonString());
            }
            if (!v.isEmpty(this.icb)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.icb.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.ibV);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.ibW);
            bundle.putString("high_light_post_id", this.ibU);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.ibQ = null;
        this.postID = null;
        this.stType = null;
        this.ibR = false;
        this.ibS = null;
        this.ibT = null;
        this.ibU = null;
        this.pageFromType = 0;
        this.ibX = false;
        this.hJe = false;
        this.hHT = 0;
        this.ibY = null;
        this.ceu = null;
        this.hZm = null;
        this.ibZ = null;
        this.ica = 0;
        this.icd = false;
        this.ice = null;
        this.isLoading = false;
        this.fci = null;
        this.icj = true;
        this.mOffset = 0;
        this.hPw = null;
        this.hZp = null;
        this.ick = false;
        this.hZq = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.ceu.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.ice.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.ice.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.ice != null && SubPbModel.this.ice.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.ice.size() - 1; size >= 0; size--) {
                                k kVar2 = (k) SubPbModel.this.ice.get(size);
                                if (SubPbModel.this.icg) {
                                    SubPbModel.this.hZm.c(kVar2, true);
                                } else {
                                    SubPbModel.this.hZm.b(kVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.ice.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.fci == null) {
                        SubPbModel.this.fci = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.fci != null) {
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
                            SubPbModel.this.fci.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.fci = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.fci = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.ibZ != null) {
                                SubPbModel.this.ibZ.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                kVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (kVar.bRf().errorno.intValue() != 0) {
                                if (SubPbModel.this.ibZ != null) {
                                    SubPbModel.this.ibZ.a(false, kVar.hJf.errorno.intValue(), kVar.hJf.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (kVar.agG() != null && kVar.agG().aiE() != null) {
                                kVar.agG().aiE().getUserId();
                                if (v.isEmpty(kVar.bRg().aiE().getIconInfo()) && SubPbModel.this.icb != null) {
                                    kVar.bRg().aiE().setIconInfo(SubPbModel.this.icb);
                                }
                            }
                            if (kVar.bRg() != null) {
                                SubPbModel.this.postID = kVar.bRg().getId();
                            }
                            if (kVar.agG() != null) {
                                SubPbModel.this.ibQ = kVar.agG().getId();
                                SubPbModel.this.hJe = kVar.afk();
                                SubPbModel.this.ibY = kVar.agG().aiN();
                            }
                            if (SubPbModel.this.ibY != null && SubPbModel.this.postID != null && SubPbModel.this.ibY.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.hJe = true;
                            }
                            if (SubPbModel.this.icg) {
                                SubPbModel.this.f(kVar);
                            } else {
                                SubPbModel.this.e(kVar);
                            }
                            if (SubPbModel.this.ibZ != null) {
                                SubPbModel.this.ibZ.a(SubPbModel.this.bXt(), error, errorString, SubPbModel.this.hZm);
                            }
                        }
                    }
                }
            }
        };
        this.ceu = tbPageContext;
        this.ice = new ArrayList<>();
        this.hZm = new k();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.hZq);
        registerListener(this.hZq);
    }

    public String bTy() {
        return this.ibQ;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aus() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public k bXs() {
        return this.hZm;
    }

    public AntiData biX() {
        return this.cua;
    }

    public boolean bXt() {
        return (this.hZm == null || this.hZm.bRg() == null) ? false : true;
    }

    public void a(a aVar) {
        this.ibZ = aVar;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.ibQ);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.ibQ);
        markData.setFloor(postData.con());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.hZq);
        if (this.hPw != null) {
            this.hPw.unRegisterListener();
        }
        beQ();
    }

    private void beQ() {
        if (this.fci != null) {
            this.fci.destory();
            this.fci = null;
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
        if (!TextUtils.isEmpty(str) && this.hZm != null && this.hZm.bRk() != null) {
            ArrayList<PostData> bRk = this.hZm.bRk();
            int size = bRk.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bRk.get(i).getId())) {
                    bRk.remove(i);
                    this.ica++;
                    this.hZm.setTotalCount(this.hZm.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bXu() {
        int aBk = this.hZm.aBk();
        if (aBk == 0) {
            return aBk + 1;
        }
        if (this.mLoadType == 0) {
            return aBk + 1;
        }
        if (this.mLoadType == 2 && this.hZm.bRk().size() != 0 && this.hZm.bRk().size() % this.hZm.getPageSize() == 0) {
            return aBk + 1;
        }
        if (this.mLoadType == 3 && this.icg) {
            return this.hZm.bRi() - 1;
        }
        if (this.mLoadType == 3 && aBk > 0) {
            return this.hZm.bRh() - 1;
        }
        return aBk;
    }

    private SubPbRequestMessage bWD() {
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
            intValue = bXu();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.icg && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.ceu.getPageActivity(), Long.parseLong(this.ibQ), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
    }

    public boolean loadData() {
        return wZ(0);
    }

    public boolean bXv() {
        return wZ(2);
    }

    public void bXw() {
        int pageSize;
        if (this.ica > 0 && this.hZm != null && (pageSize = this.hZm.getPageSize()) > 0) {
            int aBk = this.hZm.aBk();
            for (int i = (((this.ica + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.icl = i(Integer.valueOf(aBk - i));
                this.icl.setTreatDelPage(true);
                sendMessage(this.icl);
            }
        }
        this.ica = 0;
    }

    public boolean bXx() {
        return wZ(1);
    }

    public boolean wZ(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.ibQ == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bXw();
        this.mLoadType = i;
        this.icl = bWD();
        sendMessage(this.icl);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(k kVar) {
        ArrayList<PostData> bRk = kVar.bRk();
        if (bRk == null || bRk.size() == 0) {
            kVar.setCurrentPage(this.hZm.aBk());
        }
        if (this.mLoadType == 1) {
            this.hZm = kVar;
        } else if (this.mLoadType == 2) {
            this.hZm.b(kVar, true);
        } else if (this.mLoadType == 3) {
            this.hZm.a(kVar, false);
        } else {
            this.hZm.b(kVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (this.mLoadType == 1) {
            this.hZm = kVar;
            this.hZm.bRj();
        } else if (this.mLoadType == 2) {
            this.hZm.c(kVar, true);
        } else if (this.mLoadType == 3) {
            this.hZm.d(kVar, false);
        } else {
            this.hZm.a(kVar);
        }
    }

    public boolean bWU() {
        return this.ibR;
    }

    public boolean bXy() {
        return this.hJe;
    }

    public boolean bXz() {
        return "hot_topic".equals(getStType());
    }

    public void pe(boolean z) {
        this.hJe = z;
    }

    public int bQJ() {
        return this.hHT;
    }

    public String bXA() {
        return this.ibY;
    }

    public void Bk(String str) {
        this.ibY = str;
    }

    public String bXB() {
        return this.ibT;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData pG(String str) {
        if (this.hZm == null || this.hZm.bRm() == null || this.hZm.agG() == null || this.hZm.bRg() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.hZm.bRm().getName());
        writeData.setForumId(this.hZm.bRm().getId());
        writeData.setFromForumId(this.ibW);
        writeData.setFloor(this.hZm.bRg().getId());
        writeData.setType(2);
        writeData.setThreadId(this.hZm.agG().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean aur() {
        bXv();
        return true;
    }

    public boolean bXC() {
        return this.ick;
    }

    public void pf(boolean z) {
        this.ick = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.hZp = aVar;
    }

    public SmallTailInfo bXD() {
        return this.icf;
    }

    public boolean bXE() {
        return this.icd;
    }

    public ConcurrentHashMap<String, ImageUrlData> bXF() {
        return this.ici;
    }

    public ArrayList<String> bXG() {
        return this.ich;
    }

    public boolean bXH() {
        return this.icj;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.ibV;
    }

    public AttentionHostData bXI() {
        if (this.icc == null) {
            this.icc = new AttentionHostData();
            if (this.hZm != null && this.hZm.agG() != null && this.hZm.agG().aiE() != null) {
                this.icc.parserWithMetaData(this.hZm.agG().aiE());
            }
        }
        return this.icc;
    }

    public boolean bUo() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public String bTx() {
        return this.ibU;
    }
}
