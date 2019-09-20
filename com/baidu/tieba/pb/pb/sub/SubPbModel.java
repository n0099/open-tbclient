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
    private AntiData cgT;
    private com.baidu.tieba.tbadkCore.d.b fao;
    private int hKf;
    private boolean hLp;
    private PbFakeFloorModel hRI;
    private com.baidu.adp.framework.listener.a ibA;
    private k ibw;
    private PbFakeFloorModel.a ibz;
    private String iec;
    private boolean ied;
    private String iee;
    private String ief;
    private String ieg;
    private String ieh;
    private String iei;
    private boolean iej;
    private String iek;
    private a iel;
    private int iem;
    private ArrayList<IconData> ien;
    private AttentionHostData ieo;
    private boolean iep;
    private ArrayList<k> ieq;
    private SmallTailInfo ier;
    private boolean ies;
    private ArrayList<String> iet;
    private ConcurrentHashMap<String, ImageUrlData> ieu;
    private boolean iev;
    private boolean iew;
    private SubPbRequestMessage iex;
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
            this.iec = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.ieh = intent.getStringExtra("from_forum_id");
            this.iei = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.ied = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.iee = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.iej = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.ief = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hKf = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.ier = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.ier != null) {
                this.ier.updateShowInfo();
            }
            this.cgT = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.ien = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.iep = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.ieu = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.ieu.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.iet = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.iev = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.ieg = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.iec = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.ieh = bundle.getString("from_forum_id");
            this.iei = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.ied = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.iee = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.iej = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.ief = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hKf = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.ier = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.ier != null) {
                this.ier.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.cgT = new AntiData();
                this.cgT.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.aa(stringArrayList)) {
                this.ien = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.ien.add(iconData);
                    }
                }
            }
            this.iep = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.ieg = bundle.getString("high_light_post_id");
        }
    }

    public void ab(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.iec);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.ied);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.iee);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.ief);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.iej);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.hKf);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.ier));
            if (this.cgT != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.cgT.toJsonString());
            }
            if (!v.aa(this.ien)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.ien.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.ieh);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.iei);
            bundle.putString("high_light_post_id", this.ieg);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.iec = null;
        this.postID = null;
        this.stType = null;
        this.ied = false;
        this.iee = null;
        this.ief = null;
        this.ieg = null;
        this.pageFromType = 0;
        this.iej = false;
        this.hLp = false;
        this.hKf = 0;
        this.iek = null;
        this.mContext = null;
        this.ibw = null;
        this.iel = null;
        this.iem = 0;
        this.iep = false;
        this.ieq = null;
        this.isLoading = false;
        this.fao = null;
        this.iev = true;
        this.mOffset = 0;
        this.hRI = null;
        this.ibz = null;
        this.iew = false;
        this.ibA = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.ieq.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.ieq.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.ieq != null && SubPbModel.this.ieq.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.ieq.size() - 1; size >= 0; size--) {
                                k kVar2 = (k) SubPbModel.this.ieq.get(size);
                                if (SubPbModel.this.ies) {
                                    SubPbModel.this.ibw.c(kVar2, true);
                                } else {
                                    SubPbModel.this.ibw.b(kVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.ieq.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.fao == null) {
                        SubPbModel.this.fao = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.fao != null) {
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
                            SubPbModel.this.fao.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.fao = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.fao = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.iel != null) {
                                SubPbModel.this.iel.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                kVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (kVar.bUg().errorno.intValue() != 0) {
                                if (SubPbModel.this.iel != null) {
                                    SubPbModel.this.iel.a(false, kVar.hLq.errorno.intValue(), kVar.hLq.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (kVar.acC() != null && kVar.acC().aeC() != null) {
                                kVar.acC().aeC().getUserId();
                                if (v.aa(kVar.bUh().aeC().getIconInfo()) && SubPbModel.this.ien != null) {
                                    kVar.bUh().aeC().setIconInfo(SubPbModel.this.ien);
                                }
                            }
                            if (kVar.bUh() != null) {
                                SubPbModel.this.postID = kVar.bUh().getId();
                            }
                            if (kVar.acC() != null) {
                                SubPbModel.this.iec = kVar.acC().getId();
                                SubPbModel.this.hLp = kVar.aaF();
                                SubPbModel.this.iek = kVar.acC().aeL();
                            }
                            if (SubPbModel.this.iek != null && SubPbModel.this.postID != null && SubPbModel.this.iek.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.hLp = true;
                            }
                            if (SubPbModel.this.ies) {
                                SubPbModel.this.f(kVar);
                            } else {
                                SubPbModel.this.e(kVar);
                            }
                            if (SubPbModel.this.iel != null) {
                                SubPbModel.this.iel.a(SubPbModel.this.cas(), error, errorString, SubPbModel.this.ibw);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.ieq = new ArrayList<>();
        this.ibw = new k();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.ibA);
        registerListener(this.ibA);
    }

    public String bWy() {
        return this.iec;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String asI() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public k car() {
        return this.ibw;
    }

    public AntiData blT() {
        return this.cgT;
    }

    public boolean cas() {
        return (this.ibw == null || this.ibw.bUh() == null) ? false : true;
    }

    public void a(a aVar) {
        this.iel = aVar;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.iec);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.iec);
        markData.setFloor(postData.cqz());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.ibA);
        if (this.hRI != null) {
            this.hRI.unRegisterListener();
        }
        bgZ();
    }

    private void bgZ() {
        if (this.fao != null) {
            this.fao.destory();
            this.fao = null;
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

    public void CQ(String str) {
        if (!TextUtils.isEmpty(str) && this.ibw != null && this.ibw.bUl() != null) {
            ArrayList<PostData> bUl = this.ibw.bUl();
            int size = bUl.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bUl.get(i).getId())) {
                    bUl.remove(i);
                    this.iem++;
                    this.ibw.setTotalCount(this.ibw.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int cat() {
        int aBb = this.ibw.aBb();
        if (aBb == 0) {
            return aBb + 1;
        }
        if (this.mLoadType == 0) {
            return aBb + 1;
        }
        if (this.mLoadType == 2 && this.ibw.bUl().size() != 0 && this.ibw.bUl().size() % this.ibw.getPageSize() == 0) {
            return aBb + 1;
        }
        if (this.mLoadType == 3 && this.ies) {
            return this.ibw.bUj() - 1;
        }
        if (this.mLoadType == 3 && aBb > 0) {
            return this.ibw.bUi() - 1;
        }
        return aBb;
    }

    private SubPbRequestMessage bZD() {
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
            j = com.baidu.adp.lib.g.b.e(this.postID, 0L);
        } else {
            j2 = com.baidu.adp.lib.g.b.e(this.postID, 0L);
        }
        if (num == null) {
            intValue = cat();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.ies && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.iec), j, j2, i, af, ah, f, this.stType, i2);
    }

    public boolean auR() {
        return yu(0);
    }

    public boolean cau() {
        return yu(2);
    }

    public void cav() {
        int pageSize;
        if (this.iem > 0 && this.ibw != null && (pageSize = this.ibw.getPageSize()) > 0) {
            int aBb = this.ibw.aBb();
            for (int i = (((this.iem + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.iex = l(Integer.valueOf(aBb - i));
                this.iex.setTreatDelPage(true);
                sendMessage(this.iex);
            }
        }
        this.iem = 0;
    }

    public boolean caw() {
        return yu(1);
    }

    public boolean yu(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.iec == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        cav();
        this.mLoadType = i;
        this.iex = bZD();
        sendMessage(this.iex);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(k kVar) {
        ArrayList<PostData> bUl = kVar.bUl();
        if (bUl == null || bUl.size() == 0) {
            kVar.setCurrentPage(this.ibw.aBb());
        }
        if (this.mLoadType == 1) {
            this.ibw = kVar;
        } else if (this.mLoadType == 2) {
            this.ibw.b(kVar, true);
        } else if (this.mLoadType == 3) {
            this.ibw.a(kVar, false);
        } else {
            this.ibw.b(kVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (this.mLoadType == 1) {
            this.ibw = kVar;
            this.ibw.bUk();
        } else if (this.mLoadType == 2) {
            this.ibw.c(kVar, true);
        } else if (this.mLoadType == 3) {
            this.ibw.d(kVar, false);
        } else {
            this.ibw.a(kVar);
        }
    }

    public boolean bZU() {
        return this.ied;
    }

    public boolean cax() {
        return this.hLp;
    }

    public boolean cay() {
        return "hot_topic".equals(getStType());
    }

    public void pv(boolean z) {
        this.hLp = z;
    }

    public int bTK() {
        return this.hKf;
    }

    public String caz() {
        return this.iek;
    }

    public void CR(String str) {
        this.iek = str;
    }

    public String caA() {
        return this.ief;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData qx(String str) {
        if (this.ibw == null || this.ibw.bUn() == null || this.ibw.acC() == null || this.ibw.bUh() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.ibw.bUn().getName());
        writeData.setForumId(this.ibw.bUn().getId());
        writeData.setFromForumId(this.iei);
        writeData.setFloor(this.ibw.bUh().getId());
        writeData.setType(2);
        writeData.setThreadId(this.ibw.acC().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean asH() {
        cau();
        return true;
    }

    public boolean caB() {
        return this.iew;
    }

    public void pw(boolean z) {
        this.iew = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.ibz = aVar;
    }

    public SmallTailInfo caC() {
        return this.ier;
    }

    public boolean caD() {
        return this.iep;
    }

    public ConcurrentHashMap<String, ImageUrlData> caE() {
        return this.ieu;
    }

    public ArrayList<String> caF() {
        return this.iet;
    }

    public boolean caG() {
        return this.iev;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.ieh;
    }

    public AttentionHostData caH() {
        if (this.ieo == null) {
            this.ieo = new AttentionHostData();
            if (this.ibw != null && this.ibw.acC() != null && this.ibw.acC().aeC() != null) {
                this.ieo.parserWithMetaData(this.ibw.acC().aeC());
            }
        }
        return this.ieo;
    }

    public boolean bXo() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public String bWx() {
        return this.ieg;
    }
}
