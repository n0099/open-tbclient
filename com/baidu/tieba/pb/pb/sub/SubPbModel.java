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
    private com.baidu.tieba.tbadkCore.d.b eTs;
    private int hAZ;
    private boolean hCi;
    private PbFakeFloorModel hIz;
    private k hSm;
    private PbFakeFloorModel.a hSp;
    private com.baidu.adp.framework.listener.a hSq;
    private String hUM;
    private boolean hUN;
    private String hUO;
    private String hUP;
    private String hUQ;
    private String hUR;
    private String hUS;
    private boolean hUT;
    private String hUU;
    private a hUV;
    private int hUW;
    private ArrayList<IconData> hUX;
    private AttentionHostData hUY;
    private boolean hUZ;
    private ArrayList<k> hVa;
    private SmallTailInfo hVb;
    private boolean hVc;
    private ArrayList<String> hVd;
    private ConcurrentHashMap<String, ImageUrlData> hVe;
    private boolean hVf;
    private boolean hVg;
    private SubPbRequestMessage hVh;
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
            this.hUM = intent.getStringExtra("thread_id");
            this.postID = intent.getStringExtra("post_id");
            this.stType = intent.getStringExtra("st_type");
            this.hUR = intent.getStringExtra("from_forum_id");
            this.hUS = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.hUN = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.hUO = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.hUT = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.hUP = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hAZ = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            this.hVb = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
            if (this.hVb != null) {
                this.hVb.updateShowInfo();
            }
            this.ceN = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
            this.hUX = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
            this.hUZ = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
            if (bundleExtra != null) {
                ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
                this.hVe = new ConcurrentHashMap<>();
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!StringUtils.isNull(next)) {
                            this.hVe.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                        }
                    }
                }
                this.hVd = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
                this.hVf = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
                this.mOffset = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
            }
            this.hUQ = intent.getStringExtra("high_light_post_id");
        }
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle != null) {
            this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
            this.hUM = bundle.getString("thread_id");
            this.postID = bundle.getString("post_id");
            this.stType = bundle.getString("st_type");
            this.hUR = bundle.getString("from_forum_id");
            this.hUS = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
            this.hUN = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            this.hUO = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
            this.hUT = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
            this.hUP = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
            this.hAZ = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
            String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
            if (!StringUtils.isNull(string)) {
                this.hVb = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
            }
            if (this.hVb != null) {
                this.hVb.updateShowInfo();
            }
            String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
            if (!StringUtils.isNull(string2)) {
                this.ceN = new AntiData();
                this.ceN.parserJson(string2);
            }
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
            if (!v.aa(stringArrayList)) {
                this.hUX = new ArrayList<>();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                    if (iconData != null) {
                        this.hUX.add(iconData);
                    }
                }
            }
            this.hUZ = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            this.hUQ = bundle.getString("high_light_post_id");
        }
    }

    public void ab(Bundle bundle) {
        if (bundle != null) {
            bundle.putString("thread_id", this.hUM);
            bundle.putString("post_id", this.postID);
            bundle.putString("st_type", this.stType);
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.hUN);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.hUO);
            bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.hUP);
            bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.hUT);
            bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.hAZ);
            bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.hVb));
            if (this.ceN != null) {
                bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, this.ceN.toJsonString());
            }
            if (!v.aa(this.hUX)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<IconData> it = this.hUX.iterator();
                while (it.hasNext()) {
                    String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                    if (!StringUtils.isNull(jsonStrWithObject)) {
                        arrayList.add(jsonStrWithObject);
                    }
                }
                bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
            }
            bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
            bundle.putString("from_forum_id", this.hUR);
            bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.hUS);
            bundle.putString("high_light_post_id", this.hUQ);
        }
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mLoadType = 0;
        this.hUM = null;
        this.postID = null;
        this.stType = null;
        this.hUN = false;
        this.hUO = null;
        this.hUP = null;
        this.hUQ = null;
        this.pageFromType = 0;
        this.hUT = false;
        this.hCi = false;
        this.hAZ = 0;
        this.hUU = null;
        this.mContext = null;
        this.hSm = null;
        this.hUV = null;
        this.hUW = 0;
        this.hUZ = false;
        this.hVa = null;
        this.isLoading = false;
        this.eTs = null;
        this.hVf = true;
        this.mOffset = 0;
        this.hIz = null;
        this.hSp = null;
        this.hVg = false;
        this.hSq = new com.baidu.adp.framework.listener.a(CmdConfigHttp.SubPb_HTTP_CMD, 302002) { // from class: com.baidu.tieba.pb.pb.sub.SubPbModel.1
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
                                SubPbModel.this.hVa.add(subPbHttpResponseMessage.pbFloorData);
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
                                SubPbModel.this.hVa.add(subPbSocketResponseMessage.pbFloorData);
                                return;
                            }
                            return;
                        }
                    }
                    if (SubPbModel.this.hVa != null && SubPbModel.this.hVa.size() > 0) {
                        try {
                            for (int size = SubPbModel.this.hVa.size() - 1; size >= 0; size--) {
                                k kVar2 = (k) SubPbModel.this.hVa.get(size);
                                if (SubPbModel.this.hVc) {
                                    SubPbModel.this.hSm.c(kVar2, true);
                                } else {
                                    SubPbModel.this.hSm.b(kVar2, true);
                                }
                            }
                        } catch (Exception e) {
                            BdLog.detailException(e);
                        }
                        SubPbModel.this.hVa.clear();
                    }
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    if (SubPbModel.this.eTs == null) {
                        SubPbModel.this.eTs = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                    }
                    if (SubPbModel.this.eTs != null) {
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
                            SubPbModel.this.eTs.a(z, true, error, errorString, i, j3, j2);
                            SubPbModel.this.eTs = new com.baidu.tieba.tbadkCore.d.b("pbfloorStat");
                            SubPbModel.this.eTs = null;
                        }
                        if (responsedMessage == null || ((!(responsedMessage instanceof SubPbSocketResponseMessage) && !(responsedMessage instanceof SubPbHttpResponseMessage)) || responsedMessage.getError() != 0)) {
                            if (SubPbModel.this.hUV != null) {
                                SubPbModel.this.hUV.a(false, error, errorString, null);
                            }
                        } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                            if (responsedMessage instanceof SubPbHttpResponseMessage) {
                                kVar = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                            } else {
                                kVar = responsedMessage instanceof SubPbSocketResponseMessage ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : null;
                            }
                            if (kVar.bQq().errorno.intValue() != 0) {
                                if (SubPbModel.this.hUV != null) {
                                    SubPbModel.this.hUV.a(false, kVar.hCj.errorno.intValue(), kVar.hCj.errmsg, null);
                                    return;
                                }
                                return;
                            }
                            if (kVar.abv() != null && kVar.abv().adv() != null) {
                                kVar.abv().adv().getUserId();
                                if (v.aa(kVar.bQr().adv().getIconInfo()) && SubPbModel.this.hUX != null) {
                                    kVar.bQr().adv().setIconInfo(SubPbModel.this.hUX);
                                }
                            }
                            if (kVar.bQr() != null) {
                                SubPbModel.this.postID = kVar.bQr().getId();
                            }
                            if (kVar.abv() != null) {
                                SubPbModel.this.hUM = kVar.abv().getId();
                                SubPbModel.this.hCi = kVar.ZC();
                                SubPbModel.this.hUU = kVar.abv().adE();
                            }
                            if (SubPbModel.this.hUU != null && SubPbModel.this.postID != null && SubPbModel.this.hUU.equals(SubPbModel.this.postID)) {
                                SubPbModel.this.hCi = true;
                            }
                            if (SubPbModel.this.hVc) {
                                SubPbModel.this.f(kVar);
                            } else {
                                SubPbModel.this.e(kVar);
                            }
                            if (SubPbModel.this.hUV != null) {
                                SubPbModel.this.hUV.a(SubPbModel.this.bWv(), error, errorString, SubPbModel.this.hSm);
                            }
                        }
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.hVa = new ArrayList<>();
        this.hSm = new k();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.hSq);
        registerListener(this.hSq);
    }

    public String bSF() {
        return this.hUM;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String aro() {
        return this.postID;
    }

    public String getStType() {
        return this.stType;
    }

    public k bWu() {
        return this.hSm;
    }

    public AntiData biW() {
        return this.ceN;
    }

    public boolean bWv() {
        return (this.hSm == null || this.hSm.bQr() == null) ? false : true;
    }

    public void a(a aVar) {
        this.hUV = aVar;
    }

    public MarkData j(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.hUM);
        markData.setPostId(postData.getId());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.hUM);
        markData.setFloor(postData.cmu());
        return markData;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.hSq);
        if (this.hIz != null) {
            this.hIz.unRegisterListener();
        }
        bek();
    }

    private void bek() {
        if (this.eTs != null) {
            this.eTs.destory();
            this.eTs = null;
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
        if (!TextUtils.isEmpty(str) && this.hSm != null && this.hSm.bQv() != null) {
            ArrayList<PostData> bQv = this.hSm.bQv();
            int size = bQv.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(bQv.get(i).getId())) {
                    bQv.remove(i);
                    this.hUW++;
                    this.hSm.setTotalCount(this.hSm.getTotalCount() - 1);
                    return;
                }
            }
        }
    }

    protected int bWw() {
        int azw = this.hSm.azw();
        if (azw == 0) {
            return azw + 1;
        }
        if (this.mLoadType == 0) {
            return azw + 1;
        }
        if (this.mLoadType == 2 && this.hSm.bQv().size() != 0 && this.hSm.bQv().size() % this.hSm.getPageSize() == 0) {
            return azw + 1;
        }
        if (this.mLoadType == 3 && this.hVc) {
            return this.hSm.bQt() - 1;
        }
        if (this.mLoadType == 3 && azw > 0) {
            return this.hSm.bQs() - 1;
        }
        return azw;
    }

    private SubPbRequestMessage bVH() {
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
            intValue = bWw();
        } else {
            intValue = num.intValue();
        }
        int i2 = 0;
        if (this.hVc && this.mLoadType == 0) {
            i2 = 1;
            i = 1;
        } else {
            i = intValue;
        }
        return new SubPbRequestMessage(this.mContext.getPageActivity(), Long.parseLong(this.hUM), j, j2, i, af, ah, f, this.stType, i2);
    }

    public boolean atv() {
        return xL(0);
    }

    public boolean bWx() {
        return xL(2);
    }

    public void bWy() {
        int pageSize;
        if (this.hUW > 0 && this.hSm != null && (pageSize = this.hSm.getPageSize()) > 0) {
            int azw = this.hSm.azw();
            for (int i = (((this.hUW + pageSize) - 1) / pageSize) - 1; i >= 0; i--) {
                this.hVh = l(Integer.valueOf(azw - i));
                this.hVh.setTreatDelPage(true);
                sendMessage(this.hVh);
            }
        }
        this.hUW = 0;
    }

    public boolean bWz() {
        return xL(1);
    }

    public boolean xL(int i) {
        if (this.isLoading) {
            return false;
        }
        cancelMessage();
        if (this.hUM == null || this.postID == null) {
            this.isLoading = false;
            return false;
        }
        bWy();
        this.mLoadType = i;
        this.hVh = bVH();
        sendMessage(this.hVh);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(k kVar) {
        ArrayList<PostData> bQv = kVar.bQv();
        if (bQv == null || bQv.size() == 0) {
            kVar.setCurrentPage(this.hSm.azw());
        }
        if (this.mLoadType == 1) {
            this.hSm = kVar;
        } else if (this.mLoadType == 2) {
            this.hSm.b(kVar, true);
        } else if (this.mLoadType == 3) {
            this.hSm.a(kVar, false);
        } else {
            this.hSm.b(kVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(k kVar) {
        if (this.mLoadType == 1) {
            this.hSm = kVar;
            this.hSm.bQu();
        } else if (this.mLoadType == 2) {
            this.hSm.c(kVar, true);
        } else if (this.mLoadType == 3) {
            this.hSm.d(kVar, false);
        } else {
            this.hSm.a(kVar);
        }
    }

    public boolean bVX() {
        return this.hUN;
    }

    public boolean isMarked() {
        return this.hCi;
    }

    public boolean bWA() {
        return "hot_topic".equals(getStType());
    }

    public void pc(boolean z) {
        this.hCi = z;
    }

    public int bPU() {
        return this.hAZ;
    }

    public String bWB() {
        return this.hUU;
    }

    public void BD(String str) {
        this.hUU = str;
    }

    public String bWC() {
        return this.hUP;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData pW(String str) {
        if (this.hSm == null || this.hSm.bQx() == null || this.hSm.abv() == null || this.hSm.bQr() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.hSm.bQx().getName());
        writeData.setForumId(this.hSm.bQx().getId());
        writeData.setFromForumId(this.hUS);
        writeData.setFloor(this.hSm.bQr().getId());
        writeData.setType(2);
        writeData.setThreadId(this.hSm.abv().getId());
        writeData.setFloorNum(0);
        return writeData;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean arn() {
        bWx();
        return true;
    }

    public boolean bWD() {
        return this.hVg;
    }

    public void pd(boolean z) {
        this.hVg = z;
    }

    public void b(PbFakeFloorModel.a aVar) {
        this.hSp = aVar;
    }

    public SmallTailInfo bWE() {
        return this.hVb;
    }

    public boolean bWF() {
        return this.hUZ;
    }

    public ConcurrentHashMap<String, ImageUrlData> bWG() {
        return this.hVe;
    }

    public ArrayList<String> bWH() {
        return this.hVd;
    }

    public boolean bWI() {
        return this.hVf;
    }

    public int getOffset() {
        return this.mOffset;
    }

    public String getFromForumId() {
        return this.hUR;
    }

    public AttentionHostData bWJ() {
        if (this.hUY == null) {
            this.hUY = new AttentionHostData();
            if (this.hSm != null && this.hSm.abv() != null && this.hSm.abv().adv() != null) {
                this.hUY.parserWithMetaData(this.hSm.abv().adv());
            }
        }
        return this.hUY;
    }

    public boolean bTu() {
        return this.pageFromType == 13 || this.pageFromType == 12;
    }

    public String bSE() {
        return this.hUQ;
    }
}
