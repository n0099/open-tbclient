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
    private AntiData ceO;
    private com.baidu.tieba.tbadkCore.d.b eTt;
    private int hBd;
    private boolean hCm;
    private PbFakeFloorModel hID;
    private k hSq;
    private PbFakeFloorModel.a hSt;
    private com.baidu.adp.framework.listener.a hSu;
    private String hUQ;
    private boolean hUR;
    private String hUS;
    private String hUT;
    private String hUU;
    private String hUV;
    private String hUW;
    private boolean hUX;
    private String hUY;
    private a hUZ;
    private int hVa;
    private ArrayList<IconData> hVb;
    private AttentionHostData hVc;
    private boolean hVd;
    private ArrayList<k> hVe;
    private SmallTailInfo hVf;
    private boolean hVg;
    private ArrayList<String> hVh;
    private ConcurrentHashMap<String, ImageUrlData> hVi;
    private boolean hVj;
    private boolean hVk;
    private SubPbRequestMessage hVl;
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
            this.hUQ = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.hUV = intent.getStringExtra("from_forum_id");
            this.hUW = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.hUR = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.hUS = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.hUX = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.hUT = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hBd = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.hVf = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.hVf != null) {
                this.hVf.updateShowInfo();
            }
            this.ceO = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.hVb = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.hVd = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.hVi = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.hVi.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.hVh = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.hVj = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.hUU = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.hUQ = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.hUV = bundle.getString("from_forum_id");
            this.hUW = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.hUR = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.hUS = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.hUX = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.hUT = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hBd = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.hVf = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.hVf != null) {
                this.hVf.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.ceO = new AntiData();
                this.ceO.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.aa(stringArrayList)) {
                this.hVb = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.hVb.add(iconData);
                    }
                }
            }
            this.hVd = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.hUU = bundle.getString("high_light_post_id");
        }
    }

    public void ab(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.hUQ);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.hUR);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.hUS);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.hUT);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.hUX);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.hBd);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.hVf));
            if (this.ceO != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.ceO.toJsonString());
            }
            if (!v.aa(this.hVb)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.hVb.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.hUV);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.hUW);
            bundle.putString("high_light_post_id", this.hUU);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.hUQ = null;
        this.postID = null;
        this.stType = null;
        this.hUR = false;
        this.hUS = null;
        this.hUT = null;
        this.hUU = null;
        this.pageFromType = 0;
        this.hUX = false;
        this.hCm = false;
        this.hBd = 0;
        this.hUY = null;
        this.mContext = null;
        this.hSq = null;
        this.hUZ = null;
        this.hVa = 0;
        this.hVd = false;
        this.hVe = null;
        this.isLoading = false;
        this.eTt = null;
        this.hVj = true;
        this.mOffset = 0;
        this.hID = null;
        this.hSt = null;
        this.hVk = false;
        this.hSu = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.hVe.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.hVe.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.hVe != null && SubPbModel.this.hVe.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.hVe.size() - 1; size >= 0; size--) {
                                k kVar2 = (k) SubPbModel.this.hVe.get(size);
                                if (SubPbModel.this.hVg) {
                                    SubPbModel.this.hSq.c(kVar2, true);
                                } else {
                                    SubPbModel.this.hSq.b(kVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.hVe.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.eTt == null) {
                        SubPbModel.this.eTt = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.eTt != null) {
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
                            SubPbModel.this.eTt.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.eTt = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.eTt = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.hUZ != null) {
                                SubPbModel.this.hUZ.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                kVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (kVar.bQu().errorno.intValue() != 0) {
                                if (SubPbModel.this.hUZ != null) {
                                    SubPbModel.this.hUZ.a(false, kVar.hCn.errorno.intValue(), kVar.hCn.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (kVar.abv() != null && kVar.abv().adv() != null) {
                                kVar.abv().adv().getUserId();
                                if (v.aa(kVar.bQv().adv().getIconInfo()) && SubPbModel.this.hVb != null) {
                                    kVar.bQv().adv().setIconInfo(SubPbModel.this.hVb);
                                }
                            }
                            if (kVar.bQv() != null) {
                                SubPbModel.this.postID = kVar.bQv().getId();
                            }
                            if (kVar.abv() != null) {
                                SubPbModel.this.hUQ = kVar.abv().getId();
                                SubPbModel.this.hCm = kVar.ZC();
                                SubPbModel.this.hUY = kVar.abv().adE();
                            }
                            if (SubPbModel.this.hUY != null && SubPbModel.this.postID != null && SubPbModel.this.hUY.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.hCm = true;
                            }
                            if (SubPbModel.this.hVg) {
                                SubPbModel.this.f(kVar);
                            } else {
                                SubPbModel.this.e(kVar);
                            }
                            if (SubPbModel.this.hUZ != null) {
                                SubPbModel.this.hUZ.a(SubPbModel.this.bWz(), error, errorString, SubPbModel.this.hSq);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hVe = new ArrayList<>();
        this.hSq = new k();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.hSu);
        registerListener(this.hSu);
    }

    public String bSJ() {
        return this.hUQ;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aro() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public k bWy() {
        return this.hSq;
    }

    public AntiData biZ() {
        return this.ceO;
    }

    public boolean bWz() {
        return (this.hSq == null || this.hSq.bQv() == null) ? false : true;
    }

    public void a(a aVar) {
        this.hUZ = aVar;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hUQ);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.hUQ);
        markData.setFloor(postData.cmx());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.hSu);
        if (this.hID != null) {
            this.hID.unRegisterListener();
        }
        ben();
    }

    private void ben() {
        if (this.eTt != null) {
            this.eTt.destory();
            this.eTt = null;
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

    public void BE(String str) {
        if (!TextUtils.isEmpty(str) && this.hSq != null && this.hSq.bQz() != null) {
            ArrayList<PostData> bQz = this.hSq.bQz();
            int size = bQz.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bQz.get(i).getId())) {
                    bQz.remove(i);
                    this.hVa++;
                    this.hSq.setTotalCount(this.hSq.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bWA() {
        int azx = this.hSq.azx();
        if (azx == 0) {
            return azx + 1;
        }
        if (this.mLoadType == 0) {
            return azx + 1;
        }
        if (this.mLoadType == 2 && this.hSq.bQz().size() != 0 && this.hSq.bQz().size() % this.hSq.getPageSize() == 0) {
            return azx + 1;
        }
        if (this.mLoadType == 3 && this.hVg) {
            return this.hSq.bQx() - 1;
        }
        if (this.mLoadType == 3 && azx > 0) {
            return this.hSq.bQw() - 1;
        }
        return azx;
    }

    private SubPbRequestMessage bVL() {
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
            intValue = bWA();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.hVg && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.hUQ), j, j2, i, af, ah, f, this.stType, i2);
    }

    public boolean atv() {
        return xL(0);
    }

    public boolean bWB() {
        return xL(2);
    }

    public void bWC() {
        int pageSize;
        if (this.hVa > 0 && this.hSq != null && (pageSize = this.hSq.getPageSize()) > 0) {
            int azx = this.hSq.azx();
            for (int i = (((this.hVa + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.hVl = l(Integer.valueOf(azx - i));
                this.hVl.setTreatDelPage(true);
                sendMessage(this.hVl);
            }
        }
        this.hVa = 0;
    }

    public boolean bWD() {
        return xL(1);
    }

    public boolean xL(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.hUQ == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bWC();
        this.mLoadType = i;
        this.hVl = bVL();
        sendMessage(this.hVl);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(k kVar) {
        ArrayList<PostData> bQz = kVar.bQz();
        if (bQz == null || bQz.size() == 0) {
            kVar.setCurrentPage(this.hSq.azx());
        }
        if (this.mLoadType == 1) {
            this.hSq = kVar;
        } else if (this.mLoadType == 2) {
            this.hSq.b(kVar, true);
        } else if (this.mLoadType == 3) {
            this.hSq.a(kVar, false);
        } else {
            this.hSq.b(kVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (this.mLoadType == 1) {
            this.hSq = kVar;
            this.hSq.bQy();
        } else if (this.mLoadType == 2) {
            this.hSq.c(kVar, true);
        } else if (this.mLoadType == 3) {
            this.hSq.d(kVar, false);
        } else {
            this.hSq.a(kVar);
        }
    }

    public boolean bWb() {
        return this.hUR;
    }

    public boolean isMarked() {
        return this.hCm;
    }

    public boolean bWE() {
        return "hot_topic".equals(getStType());
    }

    public void pd(boolean z) {
        this.hCm = z;
    }

    public int bPY() {
        return this.hBd;
    }

    public String bWF() {
        return this.hUY;
    }

    public void BF(String str) {
        this.hUY = str;
    }

    public String bWG() {
        return this.hUT;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData pV(String str) {
        if (this.hSq == null || this.hSq.bQB() == null || this.hSq.abv() == null || this.hSq.bQv() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.hSq.bQB().getName());
        writeData.setForumId(this.hSq.bQB().getId());
        writeData.setFromForumId(this.hUW);
        writeData.setFloor(this.hSq.bQv().getId());
        writeData.setType(2);
        writeData.setThreadId(this.hSq.abv().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean arn() {
        bWB();
        return true;
    }

    public boolean bWH() {
        return this.hVk;
    }

    public void pe(boolean z) {
        this.hVk = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.hSt = aVar;
    }

    public SmallTailInfo bWI() {
        return this.hVf;
    }

    public boolean bWJ() {
        return this.hVd;
    }

    public ConcurrentHashMap<String, ImageUrlData> bWK() {
        return this.hVi;
    }

    public ArrayList<String> bWL() {
        return this.hVh;
    }

    public boolean bWM() {
        return this.hVj;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.hUV;
    }

    public AttentionHostData bWN() {
        if (this.hVc == null) {
            this.hVc = new AttentionHostData();
            if (this.hSq != null && this.hSq.abv() != null && this.hSq.abv().adv() != null) {
                this.hVc.parserWithMetaData(this.hSq.abv().adv());
            }
        }
        return this.hVc;
    }

    public boolean bTy() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public String bSI() {
        return this.hUU;
    }
}
