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
    private AntiData ceN;
    private com.baidu.tieba.tbadkCore.d.b eTt;
    private int hBc;
    private boolean hCl;
    private PbFakeFloorModel hIC;
    private k hSp;
    private PbFakeFloorModel.a hSs;
    private com.baidu.adp.framework.listener.a hSt;
    private String hUP;
    private boolean hUQ;
    private String hUR;
    private String hUS;
    private String hUT;
    private String hUU;
    private String hUV;
    private boolean hUW;
    private String hUX;
    private a hUY;
    private int hUZ;
    private ArrayList<IconData> hVa;
    private AttentionHostData hVb;
    private boolean hVc;
    private ArrayList<k> hVd;
    private SmallTailInfo hVe;
    private boolean hVf;
    private ArrayList<String> hVg;
    private ConcurrentHashMap<String, ImageUrlData> hVh;
    private boolean hVi;
    private boolean hVj;
    private SubPbRequestMessage hVk;
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
            this.hUP = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.hUU = intent.getStringExtra("from_forum_id");
            this.hUV = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.hUQ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.hUR = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.hUW = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.hUS = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hBc = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.hVe = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.hVe != null) {
                this.hVe.updateShowInfo();
            }
            this.ceN = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.hVa = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.hVc = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.hVh = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.hVh.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.hVg = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.hVi = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.hUT = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.hUP = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.hUU = bundle.getString("from_forum_id");
            this.hUV = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.hUQ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.hUR = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.hUW = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.hUS = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hBc = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.hVe = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.hVe != null) {
                this.hVe.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.ceN = new AntiData();
                this.ceN.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.aa(stringArrayList)) {
                this.hVa = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.hVa.add(iconData);
                    }
                }
            }
            this.hVc = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.hUT = bundle.getString("high_light_post_id");
        }
    }

    public void ab(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.hUP);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.hUQ);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.hUR);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.hUS);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.hUW);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.hBc);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.hVe));
            if (this.ceN != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.ceN.toJsonString());
            }
            if (!v.aa(this.hVa)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.hVa.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.hUU);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.hUV);
            bundle.putString("high_light_post_id", this.hUT);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.hUP = null;
        this.postID = null;
        this.stType = null;
        this.hUQ = false;
        this.hUR = null;
        this.hUS = null;
        this.hUT = null;
        this.pageFromType = 0;
        this.hUW = false;
        this.hCl = false;
        this.hBc = 0;
        this.hUX = null;
        this.mContext = null;
        this.hSp = null;
        this.hUY = null;
        this.hUZ = 0;
        this.hVc = false;
        this.hVd = null;
        this.isLoading = false;
        this.eTt = null;
        this.hVi = true;
        this.mOffset = 0;
        this.hIC = null;
        this.hSs = null;
        this.hVj = false;
        this.hSt = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.hVd.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.hVd.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.hVd != null && SubPbModel.this.hVd.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.hVd.size() - 1; size >= 0; size--) {
                                k kVar2 = (k) SubPbModel.this.hVd.get(size);
                                if (SubPbModel.this.hVf) {
                                    SubPbModel.this.hSp.c(kVar2, true);
                                } else {
                                    SubPbModel.this.hSp.b(kVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.hVd.clear();
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
                            if (SubPbModel.this.hUY != null) {
                                SubPbModel.this.hUY.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                kVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (kVar.bQt().errorno.intValue() != 0) {
                                if (SubPbModel.this.hUY != null) {
                                    SubPbModel.this.hUY.a(false, kVar.hCm.errorno.intValue(), kVar.hCm.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (kVar.abv() != null && kVar.abv().adv() != null) {
                                kVar.abv().adv().getUserId();
                                if (v.aa(kVar.bQu().adv().getIconInfo()) && SubPbModel.this.hVa != null) {
                                    kVar.bQu().adv().setIconInfo(SubPbModel.this.hVa);
                                }
                            }
                            if (kVar.bQu() != null) {
                                SubPbModel.this.postID = kVar.bQu().getId();
                            }
                            if (kVar.abv() != null) {
                                SubPbModel.this.hUP = kVar.abv().getId();
                                SubPbModel.this.hCl = kVar.ZC();
                                SubPbModel.this.hUX = kVar.abv().adE();
                            }
                            if (SubPbModel.this.hUX != null && SubPbModel.this.postID != null && SubPbModel.this.hUX.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.hCl = true;
                            }
                            if (SubPbModel.this.hVf) {
                                SubPbModel.this.f(kVar);
                            } else {
                                SubPbModel.this.e(kVar);
                            }
                            if (SubPbModel.this.hUY != null) {
                                SubPbModel.this.hUY.a(SubPbModel.this.bWy(), error, errorString, SubPbModel.this.hSp);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hVd = new ArrayList<>();
        this.hSp = new k();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.hSt);
        registerListener(this.hSt);
    }

    public String bSI() {
        return this.hUP;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aro() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public k bWx() {
        return this.hSp;
    }

    public AntiData biZ() {
        return this.ceN;
    }

    public boolean bWy() {
        return (this.hSp == null || this.hSp.bQu() == null) ? false : true;
    }

    public void a(a aVar) {
        this.hUY = aVar;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hUP);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.hUP);
        markData.setFloor(postData.cmw());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.hSt);
        if (this.hIC != null) {
            this.hIC.unRegisterListener();
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

    public void BC(String str) {
        if (!TextUtils.isEmpty(str) && this.hSp != null && this.hSp.bQy() != null) {
            ArrayList<PostData> bQy = this.hSp.bQy();
            int size = bQy.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bQy.get(i).getId())) {
                    bQy.remove(i);
                    this.hUZ++;
                    this.hSp.setTotalCount(this.hSp.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bWz() {
        int azx = this.hSp.azx();
        if (azx == 0) {
            return azx + 1;
        }
        if (this.mLoadType == 0) {
            return azx + 1;
        }
        if (this.mLoadType == 2 && this.hSp.bQy().size() != 0 && this.hSp.bQy().size() % this.hSp.getPageSize() == 0) {
            return azx + 1;
        }
        if (this.mLoadType == 3 && this.hVf) {
            return this.hSp.bQw() - 1;
        }
        if (this.mLoadType == 3 && azx > 0) {
            return this.hSp.bQv() - 1;
        }
        return azx;
    }

    private SubPbRequestMessage bVK() {
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
            intValue = bWz();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.hVf && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.hUP), j, j2, i, af, ah, f, this.stType, i2);
    }

    public boolean atv() {
        return xL(0);
    }

    public boolean bWA() {
        return xL(2);
    }

    public void bWB() {
        int pageSize;
        if (this.hUZ > 0 && this.hSp != null && (pageSize = this.hSp.getPageSize()) > 0) {
            int azx = this.hSp.azx();
            for (int i = (((this.hUZ + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.hVk = l(Integer.valueOf(azx - i));
                this.hVk.setTreatDelPage(true);
                sendMessage(this.hVk);
            }
        }
        this.hUZ = 0;
    }

    public boolean bWC() {
        return xL(1);
    }

    public boolean xL(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.hUP == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bWB();
        this.mLoadType = i;
        this.hVk = bVK();
        sendMessage(this.hVk);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(k kVar) {
        ArrayList<PostData> bQy = kVar.bQy();
        if (bQy == null || bQy.size() == 0) {
            kVar.setCurrentPage(this.hSp.azx());
        }
        if (this.mLoadType == 1) {
            this.hSp = kVar;
        } else if (this.mLoadType == 2) {
            this.hSp.b(kVar, true);
        } else if (this.mLoadType == 3) {
            this.hSp.a(kVar, false);
        } else {
            this.hSp.b(kVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (this.mLoadType == 1) {
            this.hSp = kVar;
            this.hSp.bQx();
        } else if (this.mLoadType == 2) {
            this.hSp.c(kVar, true);
        } else if (this.mLoadType == 3) {
            this.hSp.d(kVar, false);
        } else {
            this.hSp.a(kVar);
        }
    }

    public boolean bWa() {
        return this.hUQ;
    }

    public boolean isMarked() {
        return this.hCl;
    }

    public boolean bWD() {
        return "hot_topic".equals(getStType());
    }

    public void pc(boolean z) {
        this.hCl = z;
    }

    public int bPX() {
        return this.hBc;
    }

    public String bWE() {
        return this.hUX;
    }

    public void BD(String str) {
        this.hUX = str;
    }

    public String bWF() {
        return this.hUS;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData pW(String str) {
        if (this.hSp == null || this.hSp.bQA() == null || this.hSp.abv() == null || this.hSp.bQu() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.hSp.bQA().getName());
        writeData.setForumId(this.hSp.bQA().getId());
        writeData.setFromForumId(this.hUV);
        writeData.setFloor(this.hSp.bQu().getId());
        writeData.setType(2);
        writeData.setThreadId(this.hSp.abv().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean arn() {
        bWA();
        return true;
    }

    public boolean bWG() {
        return this.hVj;
    }

    public void pd(boolean z) {
        this.hVj = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.hSs = aVar;
    }

    public SmallTailInfo bWH() {
        return this.hVe;
    }

    public boolean bWI() {
        return this.hVc;
    }

    public ConcurrentHashMap<String, ImageUrlData> bWJ() {
        return this.hVh;
    }

    public ArrayList<String> bWK() {
        return this.hVg;
    }

    public boolean bWL() {
        return this.hVi;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.hUU;
    }

    public AttentionHostData bWM() {
        if (this.hVb == null) {
            this.hVb = new AttentionHostData();
            if (this.hSp != null && this.hSp.abv() != null && this.hSp.abv().adv() != null) {
                this.hVb.parserWithMetaData(this.hSp.abv().adv());
            }
        }
        return this.hVb;
    }

    public boolean bTx() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public String bSH() {
        return this.hUT;
    }
}
