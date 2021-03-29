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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
import d.b.i0.c2.h.q;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class SubPbModel extends DataModel {
    public static final int UPDATE_TYPE_AUTO = 2;
    public static final int UPDATE_TYPE_MOTION = 1;
    public static final int UPDATE_TYPE_NORMAL = 0;
    public static final int UPDATE_TYPE_PREVIOUS = 3;
    public boolean A;
    public ArrayList<q> B;
    public boolean C;
    public d.b.i0.c3.j0.b D;
    public SmallTailInfo E;
    public boolean F;
    public ArrayList<String> G;
    public ConcurrentHashMap<String, ImageUrlData> H;
    public boolean I;
    public int J;
    public PbFakeFloorModel K;
    public boolean L;
    public String M;
    public String N;
    public int O;
    public String P;
    public String Q;
    public boolean R;
    public SubPbRequestMessage S;
    public d.b.b.c.g.a T;

    /* renamed from: e  reason: collision with root package name */
    public int f19943e;

    /* renamed from: f  reason: collision with root package name */
    public String f19944f;

    /* renamed from: g  reason: collision with root package name */
    public String f19945g;

    /* renamed from: h  reason: collision with root package name */
    public String f19946h;
    public boolean i;
    public String j;
    public String k;
    public String l;
    public boolean m;
    public String n;
    public String o;
    public boolean p;
    public int pageFromType;
    public boolean q;
    public int r;
    public String s;
    public TbPageContext<?> t;
    public q u;
    public b v;
    public int w;
    public ArrayList<IconData> x;
    public AntiData y;
    public AttentionHostData z;

    /* loaded from: classes5.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            boolean z;
            q qVar;
            String str;
            boolean z2;
            q qVar2;
            long j2;
            long j3;
            int i;
            if (SubPbModel.this.unique_id != responsedMessage.getOrginalMessage().getTag()) {
                return;
            }
            SubPbModel.this.C = false;
            if (responsedMessage.hasError() && responsedMessage.getError() == 4) {
                SubPbModel.this.t.getPageActivity().finish();
            }
            boolean z3 = responsedMessage instanceof SubPbHttpResponseMessage;
            long j4 = 0;
            if (z3) {
                SubPbHttpResponseMessage subPbHttpResponseMessage = (SubPbHttpResponseMessage) responsedMessage;
                subPbHttpResponseMessage.getDownSize();
                j = responsedMessage.getCostTime();
                if (subPbHttpResponseMessage.isTreatDelPage()) {
                    if (subPbHttpResponseMessage.hasError()) {
                        return;
                    }
                    SubPbModel.this.B.add(subPbHttpResponseMessage.pbFloorData);
                    return;
                }
                z = true;
            } else {
                j = 0;
                z = false;
            }
            boolean z4 = responsedMessage instanceof SubPbSocketResponseMessage;
            if (z4) {
                j4 = responsedMessage.getCostTime();
                SubPbSocketResponseMessage subPbSocketResponseMessage = (SubPbSocketResponseMessage) responsedMessage;
                if (subPbSocketResponseMessage.isTreatDelPage()) {
                    if (subPbSocketResponseMessage.hasError()) {
                        return;
                    }
                    SubPbModel.this.B.add(subPbSocketResponseMessage.pbFloorData);
                    return;
                }
            }
            if (SubPbModel.this.B != null && SubPbModel.this.B.size() > 0) {
                try {
                    for (int size = SubPbModel.this.B.size() - 1; size >= 0; size--) {
                        q qVar3 = (q) SubPbModel.this.B.get(size);
                        if (SubPbModel.this.F) {
                            SubPbModel.this.u.t(qVar3, true);
                        } else {
                            SubPbModel.this.u.r(qVar3, true);
                        }
                    }
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
                SubPbModel.this.B.clear();
            }
            int error = responsedMessage.getError();
            String errorString = responsedMessage.getErrorString();
            if (SubPbModel.this.D == null) {
                SubPbModel.this.D = new d.b.i0.c3.j0.b("pbfloorStat");
            }
            if (SubPbModel.this.D != null) {
                if (error == 0) {
                    if (z3) {
                        i = ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        j2 = j4;
                        j3 = responsedMessage.getCostTime();
                    } else if (z4) {
                        int downSize = ((SubPbSocketResponseMessage) responsedMessage).getDownSize();
                        j2 = responsedMessage.getCostTime();
                        j3 = j;
                        i = downSize;
                    } else {
                        j2 = j4;
                        j3 = j;
                        i = -1;
                    }
                    long j5 = i;
                    qVar = null;
                    str = errorString;
                    z2 = z4;
                    SubPbModel.this.D.b(z, true, error, errorString, j5, j3, j2);
                    SubPbModel.this.D = new d.b.i0.c3.j0.b("pbfloorStat");
                    SubPbModel.this.D = null;
                } else {
                    qVar = null;
                    str = errorString;
                    z2 = z4;
                }
                if (responsedMessage == null || ((!z2 && !z3) || responsedMessage.getError() != 0)) {
                    String str2 = str;
                    if (SubPbModel.this.v != null) {
                        SubPbModel.this.v.a(false, error, str2, qVar);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (z3) {
                        qVar2 = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        qVar2 = z2 ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : qVar;
                    }
                    if (qVar2.c().errorno.intValue() != 0) {
                        if (SubPbModel.this.v != null) {
                            SubPbModel.this.v.a(false, qVar2.m.errorno.intValue(), qVar2.m.errmsg, qVar);
                            return;
                        }
                        return;
                    }
                    if (qVar2.l() != null && qVar2.l().T() != null) {
                        qVar2.l().T().getUserId();
                        if (ListUtils.isEmpty(qVar2.i().s().getIconInfo()) && SubPbModel.this.x != null) {
                            qVar2.i().s().setIconInfo(SubPbModel.this.x);
                        }
                    }
                    if (qVar2.i() != null) {
                        SubPbModel.this.f19945g = qVar2.i().D();
                    }
                    if (qVar2.l() != null) {
                        SubPbModel.this.f19944f = qVar2.l().o0();
                        SubPbModel.this.q = qVar2.f();
                        SubPbModel.this.s = qVar2.l().J0();
                    }
                    if (SubPbModel.this.s != null && SubPbModel.this.f19945g != null && SubPbModel.this.s.equals(SubPbModel.this.f19945g)) {
                        SubPbModel.this.q = true;
                    }
                    if (SubPbModel.this.F) {
                        SubPbModel.this.u0(qVar2);
                    } else {
                        SubPbModel.this.v0(qVar2);
                    }
                    if (SubPbModel.this.v != null) {
                        SubPbModel.this.v.a(SubPbModel.this.g0(), error, str, SubPbModel.this.u);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, int i, String str, q qVar);
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.f19943e = 0;
        this.f19944f = null;
        this.f19945g = null;
        this.f19946h = null;
        this.i = false;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = false;
        this.pageFromType = 0;
        this.p = false;
        this.q = false;
        this.r = 0;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = 0;
        this.A = false;
        this.B = null;
        this.C = false;
        this.D = null;
        this.I = true;
        this.J = 0;
        this.K = null;
        this.L = false;
        this.T = new a(CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.t = tbPageContext;
        this.B = new ArrayList<>();
        this.u = new q();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.T);
        registerListener(this.T);
    }

    public void A0(boolean z) {
        this.q = z;
    }

    public void B0(String str) {
        this.s = str;
    }

    public void C0(b bVar) {
        this.v = bVar;
    }

    public boolean D0() {
        return s0(2);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public final SubPbRequestMessage N() {
        this.C = true;
        return O(null);
    }

    public final SubPbRequestMessage O(Integer num) {
        long f2;
        long j;
        long j2;
        int intValue;
        int i;
        int i2;
        float f3 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int k = l.k(TbadkCoreApplication.getInst().getApp());
        int i3 = l.i(TbadkCoreApplication.getInst().getApp());
        if (1 != this.f19943e) {
            j2 = d.b.b.e.m.b.f(this.f19945g, 0L);
            j = 0;
        } else if (!k.isEmpty(this.M)) {
            long f4 = d.b.b.e.m.b.f(this.f19945g, 0L);
            j = d.b.b.e.m.b.f(this.k, 0L);
            j2 = f4;
        } else {
            if (!TextUtils.isEmpty(this.k)) {
                f2 = d.b.b.e.m.b.f(this.k, 0L);
            } else {
                f2 = d.b.b.e.m.b.f(this.f19945g, 0L);
            }
            j = f2;
            j2 = 0;
        }
        if (num == null) {
            intValue = w0();
        } else {
            intValue = num.intValue();
        }
        if (this.F && this.f19943e == 0) {
            i = 1;
            i2 = 1;
        } else {
            i = intValue;
            i2 = 0;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.t.getPageActivity(), Long.parseLong(this.f19944f), j2, j, i, k, i3, f3, this.f19946h, i2);
        subPbRequestMessage.setOriUgcNid(this.M);
        subPbRequestMessage.setOriUgcTid(this.N);
        subPbRequestMessage.setOriUgcType(this.O);
        subPbRequestMessage.setOriUgcVid(this.P);
        if (j != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.Q);
        }
        subPbRequestMessage.setForumId(d.b.b.e.m.b.f(this.n, 0L));
        return subPbRequestMessage;
    }

    public void P() {
        q qVar;
        int g2;
        if (this.w > 0 && (qVar = this.u) != null && (g2 = qVar.g()) > 0) {
            int i = ((this.w + g2) - 1) / g2;
            int b2 = this.u.b();
            for (int i2 = i - 1; i2 >= 0; i2--) {
                SubPbRequestMessage O = O(Integer.valueOf(b2 - i2));
                this.S = O;
                O.setTreatDelPage(true);
                sendMessage(this.S);
            }
        }
        this.w = 0;
    }

    public void Q(String str) {
        q qVar;
        q qVar2;
        if (TextUtils.isEmpty(str) || (qVar = this.u) == null || qVar.k() == null) {
            return;
        }
        ArrayList<PostData> k = this.u.k();
        int size = k.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(k.get(i).D())) {
                k.remove(i);
                this.w++;
                this.u.F(qVar2.m() - 1);
                return;
            }
        }
    }

    public AntiData R() {
        return this.y;
    }

    public AttentionHostData S() {
        if (this.z == null) {
            this.z = new AttentionHostData();
            q qVar = this.u;
            if (qVar != null && qVar.l() != null && this.u.l().T() != null) {
                this.z.parserWithMetaData(this.u.l().T());
            }
        }
        return this.z;
    }

    public q T() {
        return this.u;
    }

    public String U() {
        return this.l;
    }

    public MarkData V(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.f19944f);
        markData.setPostId(postData.D());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.f19944f);
        markData.setFloor(postData.z());
        return markData;
    }

    public String W() {
        return this.s;
    }

    public int X() {
        return this.J;
    }

    public int Y() {
        return this.pageFromType;
    }

    public String Z() {
        return this.k;
    }

    public SmallTailInfo a0() {
        return this.E;
    }

    public String b0() {
        return this.f19944f;
    }

    public String c0() {
        if (!StringUtils.isNull(this.f19944f) && !"0".equals(this.f19944f)) {
            return this.f19944f;
        }
        return this.M;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public ArrayList<String> d0() {
        return this.G;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.T);
        PbFakeFloorModel pbFakeFloorModel = this.K;
        if (pbFakeFloorModel != null) {
            pbFakeFloorModel.unRegisterListener();
        }
        t0();
    }

    public ConcurrentHashMap<String, ImageUrlData> e0() {
        return this.H;
    }

    public int f0() {
        return this.r;
    }

    public boolean g0() {
        q qVar = this.u;
        return (qVar == null || qVar.i() == null) ? false : true;
    }

    public String getFromForumId() {
        return this.n;
    }

    public String getStType() {
        return this.f19946h;
    }

    public boolean h0() {
        return this.I;
    }

    public boolean i0() {
        return "hot_topic".equals(getStType());
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
        this.f19944f = bundle.getString("thread_id");
        this.f19945g = bundle.getString("post_id");
        this.f19946h = bundle.getString("st_type");
        this.n = bundle.getString("from_forum_id");
        this.o = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
        this.i = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        this.j = bundle.getString(SubPbActivityConfig.KEY_REPLAY_NAME);
        this.p = bundle.getBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
        this.k = bundle.getString(SubPbActivityConfig.KEY_REPLAY_POST_ID);
        this.r = bundle.getInt(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
        String string = bundle.getString(SubPbActivityConfig.KEY_TAIL);
        if (!StringUtils.isNull(string)) {
            this.E = (SmallTailInfo) OrmObject.objectWithJsonStr(string, SmallTailInfo.class);
        }
        SmallTailInfo smallTailInfo = this.E;
        if (smallTailInfo != null) {
            smallTailInfo.updateShowInfo();
        }
        String string2 = bundle.getString(SubPbActivityConfig.KEY_ANTI);
        if (!StringUtils.isNull(string2)) {
            AntiData antiData = new AntiData();
            this.y = antiData;
            antiData.parserJson(string2);
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList(SubPbActivityConfig.ICON_LIST);
        if (!ListUtils.isEmpty(stringArrayList)) {
            this.x = new ArrayList<>();
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                IconData iconData = (IconData) OrmObject.objectWithJsonStr(it.next(), IconData.class);
                if (iconData != null) {
                    this.x.add(iconData);
                }
            }
        }
        this.A = bundle.getBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        this.l = bundle.getString("high_light_post_id");
        this.m = bundle.getBoolean(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
        bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
        bundle.getString(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
        bundle.getInt(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        this.R = bundle.getBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
    }

    public void initWithIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
        this.f19944f = intent.getStringExtra("thread_id");
        this.f19945g = intent.getStringExtra("post_id");
        this.f19946h = intent.getStringExtra("st_type");
        this.n = intent.getStringExtra("from_forum_id");
        this.o = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
        this.i = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
        this.j = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_NAME);
        this.p = intent.getBooleanExtra(SubPbActivityConfig.KEY_SHOW_KEYBOARD, false);
        this.k = intent.getStringExtra(SubPbActivityConfig.KEY_REPLAY_POST_ID);
        this.r = intent.getIntExtra(SubPbActivityConfig.KEY_USER_IDENTITY, 0);
        SmallTailInfo smallTailInfo = (SmallTailInfo) intent.getSerializableExtra(SubPbActivityConfig.KEY_TAIL);
        this.E = smallTailInfo;
        if (smallTailInfo != null) {
            smallTailInfo.updateShowInfo();
        }
        this.y = (AntiData) intent.getSerializableExtra(SubPbActivityConfig.KEY_ANTI);
        this.x = (ArrayList) intent.getSerializableExtra(SubPbActivityConfig.ICON_LIST);
        this.A = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        this.M = intent.getStringExtra("key_ori_ugc_nid");
        this.N = intent.getStringExtra("key_ori_ugc_tid");
        this.O = intent.getIntExtra("key_ori_ugc_type", 0);
        this.P = intent.getStringExtra("key_ori_ugc_vid");
        this.Q = intent.getStringExtra(SubPbActivityConfig.KEY_ORI_UGC_TOP_PID);
        Bundle bundleExtra = intent.getBundleExtra(SubPbActivityConfig.KEY_IMG_URLS);
        if (bundleExtra != null) {
            ArrayList<String> stringArrayList = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_URL);
            this.H = new ConcurrentHashMap<>();
            if (stringArrayList != null) {
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!StringUtils.isNull(next)) {
                        this.H.put(next, (ImageUrlData) bundleExtra.getSerializable(next));
                    }
                }
            }
            this.G = bundleExtra.getStringArrayList(SubPbActivityConfig.SUB_KEY_IMG_SRC);
            this.I = bundleExtra.getBoolean(SubPbActivityConfig.SUB_KEY_IMG_CDN, true);
            this.J = bundleExtra.getInt(SubPbActivityConfig.SUB_KEY_IMG_OFFSET, 0);
        }
        this.l = intent.getStringExtra("high_light_post_id");
        this.m = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_USE_SPID, false);
        intent.getIntExtra(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        intent.getIntExtra(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
        intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
        intent.getStringExtra(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
        intent.getIntExtra(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        this.R = intent.getBooleanExtra(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
    }

    public boolean j0() {
        return this.i;
    }

    public boolean k0() {
        return this.R;
    }

    public boolean l0() {
        return this.q;
    }

    public boolean m0() {
        return this.L;
    }

    public boolean n0() {
        return this.A;
    }

    public boolean o0() {
        return this.m;
    }

    public boolean p0() {
        return s0(0);
    }

    public boolean q0() {
        return s0(1);
    }

    public boolean r0() {
        return s0(3);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String s() {
        return this.f19945g;
    }

    public boolean s0(int i) {
        if (this.C) {
            return false;
        }
        cancelMessage();
        if (this.f19944f != null && this.f19945g != null) {
            P();
            this.f19943e = i;
            SubPbRequestMessage N = N();
            this.S = N;
            sendMessage(N);
            return true;
        }
        this.C = false;
        return false;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData t(String str) {
        q qVar = this.u;
        if (qVar == null || qVar.d() == null || this.u.l() == null || this.u.i() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.u.d().getName());
        writeData.setForumId(this.u.d().getId());
        writeData.setFromForumId(this.o);
        writeData.setFloor(this.u.i().D());
        writeData.setType(2);
        writeData.setThreadId(this.u.l().o0());
        writeData.setFloorNum(0);
        return writeData;
    }

    public final void t0() {
        d.b.i0.c3.j0.b bVar = this.D;
        if (bVar != null) {
            bVar.a();
            this.D = null;
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean u() {
        D0();
        return true;
    }

    public final void u0(q qVar) {
        int i = this.f19943e;
        if (i == 1) {
            this.u = qVar;
            qVar.H();
        } else if (i == 2) {
            this.u.t(qVar, true);
        } else if (i == 3) {
            this.u.u(qVar, false);
        } else {
            this.u.s(qVar);
        }
    }

    public final void v0(q qVar) {
        ArrayList<PostData> k = qVar.k();
        if (k == null || k.size() == 0) {
            qVar.z(this.u.b());
        }
        int i = this.f19943e;
        if (i == 1) {
            this.u = qVar;
        } else if (i == 2) {
            this.u.r(qVar, true);
        } else if (i == 3) {
            this.u.v(qVar, false);
        } else {
            this.u.r(qVar, false);
        }
    }

    public int w0() {
        int i;
        int j;
        int b2 = this.u.b();
        if (b2 == 0 || (i = this.f19943e) == 0 || (i == 2 && this.u.k().size() != 0 && this.u.k().size() % this.u.g() == 0)) {
            return b2 + 1;
        }
        if (this.f19943e == 3 && this.F) {
            j = this.u.h();
        } else if (this.f19943e != 3 || b2 <= 0) {
            return b2;
        } else {
            j = this.u.j();
        }
        return j - 1;
    }

    public void x0(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putString("thread_id", this.f19944f);
        bundle.putString("post_id", this.f19945g);
        bundle.putString("st_type", this.f19946h);
        bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.i);
        bundle.putString(SubPbActivityConfig.KEY_REPLAY_NAME, this.j);
        bundle.putString(SubPbActivityConfig.KEY_REPLAY_POST_ID, this.k);
        bundle.putBoolean(SubPbActivityConfig.KEY_SHOW_KEYBOARD, this.p);
        bundle.putInt(SubPbActivityConfig.KEY_USER_IDENTITY, this.r);
        bundle.putString(SubPbActivityConfig.KEY_TAIL, OrmObject.jsonStrWithObject(this.E));
        AntiData antiData = this.y;
        if (antiData != null) {
            bundle.putSerializable(SubPbActivityConfig.KEY_ANTI, antiData.toJsonString());
        }
        if (!ListUtils.isEmpty(this.x)) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<IconData> it = this.x.iterator();
            while (it.hasNext()) {
                String jsonStrWithObject = OrmObject.jsonStrWithObject(it.next());
                if (!StringUtils.isNull(jsonStrWithObject)) {
                    arrayList.add(jsonStrWithObject);
                }
            }
            bundle.putStringArrayList(SubPbActivityConfig.ICON_LIST, arrayList);
        }
        bundle.putBoolean(SubPbActivityConfig.KEY_IS_SHOW_GO_TO_SUBJECT, false);
        bundle.putString("from_forum_id", this.n);
        bundle.putString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID, this.o);
        bundle.putString("high_light_post_id", this.l);
        bundle.putBoolean("high_light_post_id", this.m);
        bundle.putBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, this.R);
    }

    public void y0(PbFakeFloorModel.b bVar) {
    }

    public void z0(boolean z) {
        this.L = z;
    }
}
