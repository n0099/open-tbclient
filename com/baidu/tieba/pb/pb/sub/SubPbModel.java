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
    private AntiData cga;
    private com.baidu.tieba.tbadkCore.d.b eYI;
    private int hIj;
    private boolean hJs;
    private PbFakeFloorModel hPL;
    private PbFakeFloorModel.a hZC;
    private com.baidu.adp.framework.listener.a hZD;
    private k hZz;
    private String ica;
    private boolean icb;
    private String icc;
    private String icd;
    private String ice;
    private String icf;
    private String icg;
    private boolean ich;
    private String ici;
    private a icj;
    private int ick;
    private ArrayList<IconData> icl;
    private AttentionHostData icm;
    private boolean icn;
    private ArrayList<k> ico;
    private SmallTailInfo icp;
    private boolean icq;
    private ArrayList<String> icr;
    private ConcurrentHashMap<String, ImageUrlData> ics;
    private boolean ict;
    private boolean icu;
    private SubPbRequestMessage icv;
    private boolean isLoading;
    private TbPageContext<?> mContext;
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
            this.ica = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.icf = intent.getStringExtra("from_forum_id");
            this.icg = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.icb = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.icc = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.ich = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.icd = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hIj = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.icp = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.icp != null) {
                this.icp.updateShowInfo();
            }
            this.cga = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.icl = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.icn = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.ics = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.ics.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.icr = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.ict = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.ice = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.ica = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.icf = bundle.getString("from_forum_id");
            this.icg = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.icb = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.icc = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.ich = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.icd = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hIj = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.icp = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.icp != null) {
                this.icp.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.cga = new AntiData();
                this.cga.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.aa(stringArrayList)) {
                this.icl = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.icl.add(iconData);
                    }
                }
            }
            this.icn = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.ice = bundle.getString("high_light_post_id");
        }
    }

    public void ab(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.ica);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.icb);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.icc);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.icd);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.ich);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.hIj);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.icp));
            if (this.cga != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.cga.toJsonString());
            }
            if (!v.aa(this.icl)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.icl.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.icf);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.icg);
            bundle.putString("high_light_post_id", this.ice);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.ica = null;
        this.postID = null;
        this.stType = null;
        this.icb = false;
        this.icc = null;
        this.icd = null;
        this.ice = null;
        this.pageFromType = 0;
        this.ich = false;
        this.hJs = false;
        this.hIj = 0;
        this.ici = null;
        this.mContext = null;
        this.hZz = null;
        this.icj = null;
        this.ick = 0;
        this.icn = false;
        this.ico = null;
        this.isLoading = false;
        this.eYI = null;
        this.ict = true;
        this.mOffset = 0;
        this.hPL = null;
        this.hZC = null;
        this.icu = false;
        this.hZD = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                        SubPbModel.this.mContext.getPageActivity().finish();
                    }
                    if (responsedMessage instanceof SubPbHttpResponseMessage) {
                        ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        long costTime = responsedMessage.getCostTime();
                        SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                        if (subPbHttpResponseMessage.isTreatDelPage()) {
                            if (!subPbHttpResponseMessage.hasError()) {
                                SubPbModel.this.ico.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.ico.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.ico != null && SubPbModel.this.ico.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.ico.size() - 1; size >= 0; size--) {
                                k kVar2 = (k) SubPbModel.this.ico.get(size);
                                if (SubPbModel.this.icq) {
                                    SubPbModel.this.hZz.c(kVar2, true);
                                } else {
                                    SubPbModel.this.hZz.b(kVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.ico.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.eYI == null) {
                        SubPbModel.this.eYI = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.eYI != null) {
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
                            SubPbModel.this.eYI.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.eYI = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.eYI = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.icj != null) {
                                SubPbModel.this.icj.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                kVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (kVar.bTt().errorno.intValue() != 0) {
                                if (SubPbModel.this.icj != null) {
                                    SubPbModel.this.icj.a(false, kVar.hJt.errorno.intValue(), kVar.hJt.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (kVar.acy() != null && kVar.acy().aey() != null) {
                                kVar.acy().aey().getUserId();
                                if (v.aa(kVar.bTu().aey().getIconInfo()) && SubPbModel.this.icl != null) {
                                    kVar.bTu().aey().setIconInfo(SubPbModel.this.icl);
                                }
                            }
                            if (kVar.bTu() != null) {
                                SubPbModel.this.postID = kVar.bTu().getId();
                            }
                            if (kVar.acy() != null) {
                                SubPbModel.this.ica = kVar.acy().getId();
                                SubPbModel.this.hJs = kVar.aaB();
                                SubPbModel.this.ici = kVar.acy().aeH();
                            }
                            if (SubPbModel.this.ici != null && SubPbModel.this.postID != null && SubPbModel.this.ici.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.hJs = true;
                            }
                            if (SubPbModel.this.icq) {
                                SubPbModel.this.f(kVar);
                            } else {
                                SubPbModel.this.e(kVar);
                            }
                            if (SubPbModel.this.icj != null) {
                                SubPbModel.this.icj.a(SubPbModel.this.bZE(), error, errorString, SubPbModel.this.hZz);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.ico = new ArrayList<>();
        this.hZz = new k();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.hZD);
        registerListener(this.hZD);
    }

    public String bVL() {
        return this.ica;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String asw() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public k bZD() {
        return this.hZz;
    }

    public AntiData bli() {
        return this.cga;
    }

    public boolean bZE() {
        return (this.hZz == null || this.hZz.bTu() == null) ? false : true;
    }

    public void a(a aVar) {
        this.icj = aVar;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.ica);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.ica);
        markData.setFloor(postData.cpL());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.hZD);
        if (this.hPL != null) {
            this.hPL.unRegisterListener();
        }
        bgt();
    }

    private void bgt() {
        if (this.eYI != null) {
            this.eYI.destory();
            this.eYI = null;
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

    public void Cr(String str) {
        if (!TextUtils.isEmpty(str) && this.hZz != null && this.hZz.bTy() != null) {
            ArrayList<PostData> bTy = this.hZz.bTy();
            int size = bTy.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bTy.get(i).getId())) {
                    bTy.remove(i);
                    this.ick++;
                    this.hZz.setTotalCount(this.hZz.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bZF() {
        int aAN = this.hZz.aAN();
        if (aAN == 0) {
            return aAN + 1;
        }
        if (this.mLoadType == 0) {
            return aAN + 1;
        }
        if (this.mLoadType == 2 && this.hZz.bTy().size() != 0 && this.hZz.bTy().size() % this.hZz.getPageSize() == 0) {
            return aAN + 1;
        }
        if (this.mLoadType == 3 && this.icq) {
            return this.hZz.bTw() - 1;
        }
        if (this.mLoadType == 3 && aAN > 0) {
            return this.hZz.bTv() - 1;
        }
        return aAN;
    }

    private SubPbRequestMessage bYQ() {
        this.isLoading = true;
        return l(null);
    }

    private SubPbRequestMessage l(Integer num) {
        int intValue;
        int i;
        float f = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int af = l.af(TbadkCoreApplication.getInst().getApp());
        int ah = l.ah(TbadkCoreApplication.getInst().getApp());
        long j = 0;
        long j2 = 0;
        if (1 != this.mLoadType) {
            j = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.c(this.postID, 0L);
        }
        if (num == null) {
            intValue = bZF();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.icq && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.ica), j, j2, i, af, ah, f, this.stType, i2);
    }

    public boolean auF() {
        return yr(0);
    }

    public boolean bZG() {
        return yr(2);
    }

    public void bZH() {
        int pageSize;
        if (this.ick > 0 && this.hZz != null && (pageSize = this.hZz.getPageSize()) > 0) {
            int aAN = this.hZz.aAN();
            for (int i = (((this.ick + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.icv = l(Integer.valueOf(aAN - i));
                this.icv.setTreatDelPage(true);
                sendMessage(this.icv);
            }
        }
        this.ick = 0;
    }

    public boolean bZI() {
        return yr(1);
    }

    public boolean yr(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.ica == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bZH();
        this.mLoadType = i;
        this.icv = bYQ();
        sendMessage(this.icv);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(k kVar) {
        ArrayList<PostData> bTy = kVar.bTy();
        if (bTy == null || bTy.size() == 0) {
            kVar.setCurrentPage(this.hZz.aAN());
        }
        if (this.mLoadType == 1) {
            this.hZz = kVar;
        } else if (this.mLoadType == 2) {
            this.hZz.b(kVar, true);
        } else if (this.mLoadType == 3) {
            this.hZz.a(kVar, false);
        } else {
            this.hZz.b(kVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (this.mLoadType == 1) {
            this.hZz = kVar;
            this.hZz.bTx();
        } else if (this.mLoadType == 2) {
            this.hZz.c(kVar, true);
        } else if (this.mLoadType == 3) {
            this.hZz.d(kVar, false);
        } else {
            this.hZz.a(kVar);
        }
    }

    public boolean bZg() {
        return this.icb;
    }

    public boolean bZJ() {
        return this.hJs;
    }

    public boolean bZK() {
        return "hot_topic".equals(getStType());
    }

    public void pr(boolean z) {
        this.hJs = z;
    }

    public int bSX() {
        return this.hIj;
    }

    public String bZL() {
        return this.ici;
    }

    public void Cs(String str) {
        this.ici = str;
    }

    public String bZM() {
        return this.icd;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData qm(String str) {
        if (this.hZz == null || this.hZz.bTA() == null || this.hZz.acy() == null || this.hZz.bTu() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.hZz.bTA().getName());
        writeData.setForumId(this.hZz.bTA().getId());
        writeData.setFromForumId(this.icg);
        writeData.setFloor(this.hZz.bTu().getId());
        writeData.setType(2);
        writeData.setThreadId(this.hZz.acy().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean asv() {
        bZG();
        return true;
    }

    public boolean bZN() {
        return this.icu;
    }

    public void ps(boolean z) {
        this.icu = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.hZC = aVar;
    }

    public SmallTailInfo bZO() {
        return this.icp;
    }

    public boolean bZP() {
        return this.icn;
    }

    public ConcurrentHashMap<String, ImageUrlData> bZQ() {
        return this.ics;
    }

    public ArrayList<String> bZR() {
        return this.icr;
    }

    public boolean bZS() {
        return this.ict;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.icf;
    }

    public AttentionHostData bZT() {
        if (this.icm == null) {
            this.icm = new AttentionHostData();
            if (this.hZz != null && this.hZz.acy() != null && this.hZz.acy().aey() != null) {
                this.icm.parserWithMetaData(this.hZz.acy().aey());
            }
        }
        return this.icm;
    }

    public boolean bWB() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public String bVK() {
        return this.ice;
    }
}
