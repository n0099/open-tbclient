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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes21.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    private TbPageContext<?> eGu;
    private boolean eXC;
    private int fFv;
    private AntiData fbU;
    private com.baidu.tieba.tbadkCore.d.b ino;
    private boolean isLoading;
    private String kyU;
    private PbFakeFloorModel.a lHA;
    private com.baidu.adp.framework.listener.a lHB;
    private p lHx;
    private String lJT;
    private String lJU;
    private String lJV;
    private String lJW;
    private boolean lJX;
    private String lJY;
    private boolean lJZ;
    private String lKa;
    private a lKb;
    private int lKc;
    private ArrayList<IconData> lKd;
    private AttentionHostData lKe;
    private boolean lKf;
    private ArrayList<p> lKg;
    private SmallTailInfo lKh;
    private boolean lKi;
    private ArrayList<String> lKj;
    private ConcurrentHashMap<String, ImageUrlData> lKk;
    private boolean lKl;
    private boolean lKm;
    private SubPbRequestMessage lKn;
    private boolean loS;
    private PbFakeFloorModel ltx;
    private int mOffset;
    private String oriUgcNid;
    private String oriUgcTid;
    private String oriUgcTopPid;
    private int oriUgcType;
    private String oriUgcVid;
    public int pageFromType;
    private String postID;
    private String stType;
    private int userIdentity;

    /* loaded from: classes21.dex */
    public interface a {
        void a(boolean z, int i, String str, p pVar);
    }

    public void initWithIntent(Intent intent) {
        if (intent != null) {
            this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.lJT = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.kyU = intent.getStringExtra("from_forum_id");
            this.lJY = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.eXC = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.lJU = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.lJZ = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.lJV = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.lKh = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.lKh != null) {
                this.lKh.updateShowInfo();
            }
            this.fbU = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.lKd = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.lKf = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.oriUgcNid = intent.getStringExtra("key_ori_ugc_nid");
            this.oriUgcTid = intent.getStringExtra("key_ori_ugc_tid");
            this.oriUgcType = intent.getIntExtra("key_ori_ugc_type", 0);
            this.oriUgcVid = intent.getStringExtra("key_ori_ugc_vid");
            this.oriUgcTopPid = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.lKk = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.lKk.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.lKj = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.lKl = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.lJW = intent.getStringExtra("high_light_post_id");
            this.lJX = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.lJT = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.kyU = bundle.getString("from_forum_id");
            this.lJY = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.eXC = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.lJU = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.lJZ = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.lJV = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.userIdentity = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.lKh = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.lKh != null) {
                this.lKh.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.fbU = new AntiData();
                this.fbU.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!y.isEmpty(stringArrayList)) {
                this.lKd = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.lKd.add(iconData);
                    }
                }
            }
            this.lKf = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.lJW = bundle.getString("high_light_post_id");
            this.lJX = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        }
    }

    public void aC(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.lJT);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.eXC);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.lJU);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.lJV);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.lJZ);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.userIdentity);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.lKh));
            if (this.fbU != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.fbU.toJsonString());
            }
            if (!y.isEmpty(this.lKd)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.lKd.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.kyU);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.lJY);
            bundle.putString("high_light_post_id", this.lJW);
            bundle.putBoolean("high_light_post_id", this.lJX);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.fFv = 0;
        this.lJT = null;
        this.postID = null;
        this.stType = null;
        this.eXC = false;
        this.lJU = null;
        this.lJV = null;
        this.lJW = null;
        this.lJX = false;
        this.pageFromType = 0;
        this.lJZ = false;
        this.loS = false;
        this.userIdentity = 0;
        this.lKa = null;
        this.eGu = null;
        this.lHx = null;
        this.lKb = null;
        this.lKc = 0;
        this.lKf = false;
        this.lKg = null;
        this.isLoading = false;
        this.ino = null;
        this.lKl = true;
        this.mOffset = 0;
        this.ltx = null;
        this.lHA = null;
        this.lKm = false;
        this.lHB = new com.baidu.adp.framework.listener.a(1002100, CmdConfigSocket.CMD_SUBPB_FLOOR) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                long j;
                boolean z;
                p pVar;
                long j2;
                long j3;
                long j4 = 0;
                if (SubPbModel.this.unique_id == responsedMessage.getOrginalMessage().getTag()) {
                    SubPbModel.this.isLoading = false;
                    if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                        SubPbModel.this.eGu.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.lKg.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.lKg.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.lKg != null && SubPbModel.this.lKg.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.lKg.size() - 1; size >= 0; size--) {
                                p pVar2 = (p) SubPbModel.this.lKg.get(size);
                                if (SubPbModel.this.lKi) {
                                    SubPbModel.this.lHx.c(pVar2, true);
                                } else {
                                    SubPbModel.this.lHx.b(pVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.lKg.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.ino == null) {
                        SubPbModel.this.ino = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.ino != null) {
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
                            SubPbModel.this.ino.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.ino = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.ino = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.lKb != null) {
                                SubPbModel.this.lKb.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                pVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                pVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (pVar.diB().errorno.intValue() != 0) {
                                if (SubPbModel.this.lKb != null) {
                                    SubPbModel.this.lKb.a(false, pVar.loT.errorno.intValue(), pVar.loT.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (pVar.bjd() != null && pVar.bjd().blC() != null) {
                                pVar.bjd().blC().getUserId();
                                if (y.isEmpty(pVar.dix().blC().getIconInfo()) && SubPbModel.this.lKd != null) {
                                    pVar.dix().blC().setIconInfo(SubPbModel.this.lKd);
                                }
                            }
                            if (pVar.dix() != null) {
                                SubPbModel.this.postID = pVar.dix().getId();
                            }
                            if (pVar.bjd() != null) {
                                SubPbModel.this.lJT = pVar.bjd().getId();
                                SubPbModel.this.loS = pVar.bhP();
                                SubPbModel.this.lKa = pVar.bjd().blK();
                            }
                            if (SubPbModel.this.lKa != null && SubPbModel.this.postID != null && SubPbModel.this.lKa.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.loS = true;
                            }
                            if (SubPbModel.this.lKi) {
                                SubPbModel.this.f(pVar);
                            } else {
                                SubPbModel.this.e(pVar);
                            }
                            if (SubPbModel.this.lKb != null) {
                                SubPbModel.this.lKb.a(SubPbModel.this.dpw(), error, errorString, SubPbModel.this.lHx);
                            }
                        }
                    }
                }
            }
        };
        this.eGu = tbPageContext;
        this.lKg = new ArrayList<>();
        this.lHx = new p();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.lHB);
        registerListener(this.lHB);
    }

    public String dkU() {
        return this.lJT;
    }

    public String dkV() {
        return (StringUtils.isNull(this.lJT) || "0".equals(this.lJT)) ? this.oriUgcNid : this.lJT;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String bzp() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public p dpv() {
        return this.lHx;
    }

    public AntiData cwP() {
        return this.fbU;
    }

    public boolean dpw() {
        return (this.lHx == null || this.lHx.dix() == null) ? false : true;
    }

    public void a(a aVar) {
        this.lKb = aVar;
    }

    public MarkData o(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.lJT);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.lJT);
        markData.setFloor(postData.dJQ());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.lHB);
        if (this.ltx != null) {
            this.ltx.unRegisterListener();
        }
        csd();
    }

    private void csd() {
        if (this.ino != null) {
            this.ino.destory();
            this.ino = null;
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

    public void PB(String str) {
        if (!TextUtils.isEmpty(str) && this.lHx != null && this.lHx.diF() != null) {
            ArrayList<PostData> diF = this.lHx.diF();
            int size = diF.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(diF.get(i).getId())) {
                    diF.remove(i);
                    this.lKc++;
                    this.lHx.setTotalCount(this.lHx.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int dpx() {
        int bHk = this.lHx.bHk();
        if (bHk == 0) {
            return bHk + 1;
        }
        if (this.fFv == 0) {
            return bHk + 1;
        }
        if (this.fFv == 2 && this.lHx.diF().size() != 0 && this.lHx.diF().size() % this.lHx.getPageSize() == 0) {
            return bHk + 1;
        }
        if (this.fFv == 3 && this.lKi) {
            return this.lHx.diD() - 1;
        }
        if (this.fFv == 3 && bHk > 0) {
            return this.lHx.diC() - 1;
        }
        return bHk;
    }

    private SubPbRequestMessage doC() {
        this.isLoading = true;
        return r(null);
    }

    private SubPbRequestMessage r(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst().getApp());
        int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.fFv) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
        } else if (!au.isEmpty(this.oriUgcNid)) {
            j = com.baidu.adp.lib.f.b.toLong(this.postID, 0L);
            j2 = com.baidu.adp.lib.f.b.toLong(this.lJV, 0L);
        } else {
            j2 = com.baidu.adp.lib.f.b.toLong(this.lJV, 0L);
        }
        if (num == null) {
            intValue = dpx();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.lKi && this.fFv == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.eGu.getPageActivity(), Long.parseLong(this.lJT), j, j2, i, equipmentWidth, equipmentHeight, f, this.stType, i2);
        subPbRequestMessage.setOriUgcNid(this.oriUgcNid);
        subPbRequestMessage.setOriUgcTid(this.oriUgcTid);
        subPbRequestMessage.setOriUgcType(this.oriUgcType);
        subPbRequestMessage.setOriUgcVid(this.oriUgcVid);
        if (j2 != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.oriUgcTopPid);
        }
        subPbRequestMessage.setForumId(com.baidu.adp.lib.f.b.toLong(this.kyU, 0L));
        return subPbRequestMessage;
    }

    public boolean loadData() {
        return GT(0);
    }

    public boolean dpy() {
        return GT(2);
    }

    public void dpz() {
        int pageSize;
        if (this.lKc > 0 && this.lHx != null && (pageSize = this.lHx.getPageSize()) > 0) {
            int bHk = this.lHx.bHk();
            for (int i = (((this.lKc + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.lKn = r(Integer.valueOf(bHk - i));
                this.lKn.setTreatDelPage(true);
                sendMessage(this.lKn);
            }
        }
        this.lKc = 0;
    }

    public boolean dpA() {
        return GT(1);
    }

    public boolean dpB() {
        return GT(3);
    }

    public boolean GT(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.lJT == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        dpz();
        this.fFv = i;
        this.lKn = doC();
        sendMessage(this.lKn);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        ArrayList<PostData> diF = pVar.diF();
        if (diF == null || diF.size() == 0) {
            pVar.setCurrentPage(this.lHx.bHk());
        }
        if (this.fFv == 1) {
            this.lHx = pVar;
        } else if (this.fFv == 2) {
            this.lHx.b(pVar, true);
        } else if (this.fFv == 3) {
            this.lHx.a(pVar, false);
        } else {
            this.lHx.b(pVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(p pVar) {
        if (this.fFv == 1) {
            this.lHx = pVar;
            this.lHx.diE();
        } else if (this.fFv == 2) {
            this.lHx.c(pVar, true);
        } else if (this.fFv == 3) {
            this.lHx.d(pVar, false);
        } else {
            this.lHx.a(pVar);
        }
    }

    public boolean doV() {
        return this.eXC;
    }

    public boolean dpC() {
        return this.loS;
    }

    public boolean dpD() {
        return "hot_topic".equals(getStType());
    }

    public void vr(boolean z) {
        this.loS = z;
    }

    public int dhW() {
        return this.userIdentity;
    }

    public String dpE() {
        return this.lKa;
    }

    public void PC(String str) {
        this.lKa = str;
    }

    public String dpF() {
        return this.lJV;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData Dj(String str) {
        if (this.lHx == null || this.lHx.bzP() == null || this.lHx.bjd() == null || this.lHx.dix() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.lHx.bzP().getName());
        writeData.setForumId(this.lHx.bzP().getId());
        writeData.setFromForumId(this.lJY);
        writeData.setFloor(this.lHx.dix().getId());
        writeData.setType(2);
        writeData.setThreadId(this.lHx.bjd().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean bzo() {
        dpy();
        return true;
    }

    public boolean dpG() {
        return this.lKm;
    }

    public void vs(boolean z) {
        this.lKm = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.lHA = aVar;
    }

    public SmallTailInfo dpH() {
        return this.lKh;
    }

    public boolean dpI() {
        return this.lKf;
    }

    public ConcurrentHashMap<String, ImageUrlData> dpJ() {
        return this.lKk;
    }

    public ArrayList<String> dpK() {
        return this.lKj;
    }

    public boolean dpL() {
        return this.lKl;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.kyU;
    }

    public AttentionHostData dpM() {
        if (this.lKe == null) {
            this.lKe = new AttentionHostData();
            if (this.lHx != null && this.lHx.bjd() != null && this.lHx.bjd().blC() != null) {
                this.lKe.parserWithMetaData(this.lHx.bjd().blC());
            }
        }
        return this.lKe;
    }

    public int dpN() {
        return this.pageFromType;
    }

    public String dkT() {
        return this.lJW;
    }

    public boolean dpO() {
        return this.lJX;
    }
}
