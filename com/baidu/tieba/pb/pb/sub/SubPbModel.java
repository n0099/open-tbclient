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
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.e2.h.r;
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
    public ArrayList<r> B;
    public boolean C;
    public d.a.o0.e3.j0.b D;
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
    public int R;
    public int S;
    public int T;
    public int U;
    public String V;
    public int W;
    public boolean X;
    public SubPbRequestMessage Y;
    public d.a.c.c.g.a Z;

    /* renamed from: e  reason: collision with root package name */
    public int f19485e;

    /* renamed from: f  reason: collision with root package name */
    public String f19486f;

    /* renamed from: g  reason: collision with root package name */
    public String f19487g;

    /* renamed from: h  reason: collision with root package name */
    public String f19488h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f19489i;
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
    public r u;
    public b v;
    public int w;
    public ArrayList<IconData> x;
    public AntiData y;
    public AttentionHostData z;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            boolean z;
            r rVar;
            String str;
            boolean z2;
            r rVar2;
            long j2;
            long j3;
            int i2;
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
                        r rVar3 = (r) SubPbModel.this.B.get(size);
                        if (SubPbModel.this.F) {
                            SubPbModel.this.u.t(rVar3, true);
                        } else {
                            SubPbModel.this.u.r(rVar3, true);
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
                SubPbModel.this.D = new d.a.o0.e3.j0.b("pbfloorStat");
            }
            if (SubPbModel.this.D != null) {
                if (error == 0) {
                    if (z3) {
                        i2 = ((SubPbHttpResponseMessage) responsedMessage).getDownSize();
                        j2 = j4;
                        j3 = responsedMessage.getCostTime();
                    } else if (z4) {
                        int downSize = ((SubPbSocketResponseMessage) responsedMessage).getDownSize();
                        j2 = responsedMessage.getCostTime();
                        j3 = j;
                        i2 = downSize;
                    } else {
                        j2 = j4;
                        j3 = j;
                        i2 = -1;
                    }
                    long j5 = i2;
                    rVar = null;
                    str = errorString;
                    z2 = z4;
                    SubPbModel.this.D.b(z, true, error, errorString, j5, j3, j2);
                    SubPbModel.this.D = new d.a.o0.e3.j0.b("pbfloorStat");
                    SubPbModel.this.D = null;
                } else {
                    rVar = null;
                    str = errorString;
                    z2 = z4;
                }
                if (responsedMessage == null || ((!z2 && !z3) || responsedMessage.getError() != 0)) {
                    String str2 = str;
                    if (SubPbModel.this.v != null) {
                        SubPbModel.this.v.a(false, error, str2, rVar);
                    }
                } else if (responsedMessage.getCmd() == 302002 || responsedMessage.getCmd() == 1002100) {
                    if (z3) {
                        rVar2 = ((SubPbHttpResponseMessage) responsedMessage).pbFloorData;
                    } else {
                        rVar2 = z2 ? ((SubPbSocketResponseMessage) responsedMessage).pbFloorData : rVar;
                    }
                    if (rVar2.c().errorno.intValue() != 0) {
                        if (SubPbModel.this.v != null) {
                            SubPbModel.this.v.a(false, rVar2.m.errorno.intValue(), rVar2.m.errmsg, rVar);
                            return;
                        }
                        return;
                    }
                    if (rVar2.l() != null && rVar2.l().T() != null) {
                        rVar2.l().T().getUserId();
                        if (ListUtils.isEmpty(rVar2.i().t().getIconInfo()) && SubPbModel.this.x != null) {
                            rVar2.i().t().setIconInfo(SubPbModel.this.x);
                        }
                    }
                    if (rVar2.i() != null) {
                        SubPbModel.this.f19487g = rVar2.i().E();
                    }
                    if (rVar2.l() != null) {
                        SubPbModel.this.f19486f = rVar2.l().o0();
                        SubPbModel.this.q = rVar2.f();
                        SubPbModel.this.s = rVar2.l().K0();
                    }
                    if (SubPbModel.this.s != null && SubPbModel.this.f19487g != null && SubPbModel.this.s.equals(SubPbModel.this.f19487g)) {
                        SubPbModel.this.q = true;
                    }
                    if (SubPbModel.this.F) {
                        SubPbModel.this.E0(rVar2);
                    } else {
                        SubPbModel.this.F0(rVar2);
                    }
                    if (SubPbModel.this.v != null) {
                        SubPbModel.this.v.a(SubPbModel.this.q0(), error, str, SubPbModel.this.u);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, int i2, String str, r rVar);
    }

    public SubPbModel(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.f19485e = 0;
        this.f19486f = null;
        this.f19487g = null;
        this.f19488h = null;
        this.f19489i = false;
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
        this.Z = new a(CmdConfigHttp.SubPb_HTTP_CMD, 302002);
        this.t = tbPageContext;
        this.B = new ArrayList<>();
        this.u = new r();
        setUniqueId(BdUniqueId.gen());
        MessageManager.getInstance().unRegisterListener(this.Z);
        registerListener(this.Z);
    }

    public boolean A0() {
        return C0(1);
    }

    public boolean B0() {
        return C0(3);
    }

    public boolean C0(int i2) {
        if (this.C) {
            return false;
        }
        cancelMessage();
        if (this.f19486f != null && this.f19487g != null) {
            T();
            this.f19485e = i2;
            SubPbRequestMessage R = R();
            this.Y = R;
            sendMessage(R);
            return true;
        }
        this.C = false;
        return false;
    }

    public final void D0() {
        d.a.o0.e3.j0.b bVar = this.D;
        if (bVar != null) {
            bVar.a();
            this.D = null;
        }
    }

    public final void E0(r rVar) {
        int i2 = this.f19485e;
        if (i2 == 1) {
            this.u = rVar;
            rVar.H();
        } else if (i2 == 2) {
            this.u.t(rVar, true);
        } else if (i2 == 3) {
            this.u.u(rVar, false);
        } else {
            this.u.s(rVar);
        }
    }

    public final void F0(r rVar) {
        ArrayList<PostData> k = rVar.k();
        if (k == null || k.size() == 0) {
            rVar.z(this.u.b());
        }
        int i2 = this.f19485e;
        if (i2 == 1) {
            this.u = rVar;
        } else if (i2 == 2) {
            this.u.r(rVar, true);
        } else if (i2 == 3) {
            this.u.v(rVar, false);
        } else {
            this.u.r(rVar, false);
        }
    }

    public int G0() {
        int i2;
        int j;
        int b2 = this.u.b();
        if (b2 == 0 || (i2 = this.f19485e) == 0 || (i2 == 2 && this.u.k().size() != 0 && this.u.k().size() % this.u.g() == 0)) {
            return b2 + 1;
        }
        if (this.f19485e == 3 && this.F) {
            j = this.u.h();
        } else if (this.f19485e != 3 || b2 <= 0) {
            return b2;
        } else {
            j = this.u.j();
        }
        return j - 1;
    }

    public void H0(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putString("thread_id", this.f19486f);
        bundle.putString("post_id", this.f19487g);
        bundle.putString("st_type", this.f19488h);
        bundle.putBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, this.f19489i);
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
        bundle.putBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, this.X);
    }

    public void I0(PbFakeFloorModel.b bVar) {
    }

    public void J0(boolean z) {
        this.L = z;
    }

    public void K0(boolean z) {
        this.q = z;
    }

    public void L0(String str) {
        this.s = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    public void M0(b bVar) {
        this.v = bVar;
    }

    public boolean N0() {
        return C0(2);
    }

    public final SubPbRequestMessage R() {
        this.C = true;
        return S(null);
    }

    public final SubPbRequestMessage S(Integer num) {
        long f2;
        long j;
        long j2;
        int intValue;
        int i2;
        int i3;
        float f3 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
        int k = l.k(TbadkCoreApplication.getInst().getApp());
        int i4 = l.i(TbadkCoreApplication.getInst().getApp());
        if (1 != this.f19485e) {
            j2 = d.a.c.e.m.b.f(this.f19487g, 0L);
            j = 0;
        } else if (!k.isEmpty(this.M)) {
            long f4 = d.a.c.e.m.b.f(this.f19487g, 0L);
            j = d.a.c.e.m.b.f(this.k, 0L);
            j2 = f4;
        } else {
            if (!TextUtils.isEmpty(this.k)) {
                f2 = d.a.c.e.m.b.f(this.k, 0L);
            } else {
                f2 = d.a.c.e.m.b.f(this.f19487g, 0L);
            }
            j = f2;
            j2 = 0;
        }
        if (num == null) {
            intValue = G0();
        } else {
            intValue = num.intValue();
        }
        if (this.F && this.f19485e == 0) {
            i2 = 1;
            i3 = 1;
        } else {
            i2 = intValue;
            i3 = 0;
        }
        SubPbRequestMessage subPbRequestMessage = new SubPbRequestMessage(this.t.getPageActivity(), Long.parseLong(this.f19486f), j2, j, i2, k, i4, f3, this.f19488h, i3);
        subPbRequestMessage.setOriUgcNid(this.M);
        subPbRequestMessage.setOriUgcTid(this.N);
        subPbRequestMessage.setOriUgcType(this.O);
        subPbRequestMessage.setOriUgcVid(this.P);
        if (j != 0) {
            subPbRequestMessage.setOriUgcTopPid(this.Q);
        }
        subPbRequestMessage.setForumId(d.a.c.e.m.b.f(this.n, 0L));
        return subPbRequestMessage;
    }

    public void T() {
        r rVar;
        int g2;
        if (this.w > 0 && (rVar = this.u) != null && (g2 = rVar.g()) > 0) {
            int i2 = ((this.w + g2) - 1) / g2;
            int b2 = this.u.b();
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                SubPbRequestMessage S = S(Integer.valueOf(b2 - i3));
                this.Y = S;
                S.setTreatDelPage(true);
                sendMessage(this.Y);
            }
        }
        this.w = 0;
    }

    public void U(String str) {
        r rVar;
        r rVar2;
        if (TextUtils.isEmpty(str) || (rVar = this.u) == null || rVar.k() == null) {
            return;
        }
        ArrayList<PostData> k = this.u.k();
        int size = k.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equals(k.get(i2).E())) {
                k.remove(i2);
                this.w++;
                this.u.F(rVar2.m() - 1);
                return;
            }
        }
    }

    public AntiData V() {
        return this.y;
    }

    public AttentionHostData W() {
        if (this.z == null) {
            this.z = new AttentionHostData();
            r rVar = this.u;
            if (rVar != null && rVar.l() != null && this.u.l().T() != null) {
                this.z.parserWithMetaData(this.u.l().T());
            }
        }
        return this.z;
    }

    public r X() {
        return this.u;
    }

    public int Y() {
        return this.U;
    }

    public int Z() {
        return this.T;
    }

    public String a0() {
        return this.V;
    }

    public int b0() {
        return this.R;
    }

    public String c0() {
        return this.l;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public int d0() {
        return this.S;
    }

    public void destory() {
        cancelMessage();
        MessageManager.getInstance().unRegisterListener(this.Z);
        PbFakeFloorModel pbFakeFloorModel = this.K;
        if (pbFakeFloorModel != null) {
            pbFakeFloorModel.unRegisterListener();
        }
        D0();
    }

    public MarkData e0(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.f19486f);
        markData.setPostId(postData.E());
        markData.setTime(date.getTime());
        markData.setHostMode(false);
        markData.setId(this.f19486f);
        markData.setFloor(postData.A());
        return markData;
    }

    public String f0() {
        return this.s;
    }

    public int g0() {
        return this.J;
    }

    public String getFromForumId() {
        return this.n;
    }

    public String getStType() {
        return this.f19488h;
    }

    public int h0() {
        return this.pageFromType;
    }

    public String i0() {
        return this.k;
    }

    public void initWithBundle(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.pageFromType = bundle.getInt(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
        this.f19486f = bundle.getString("thread_id");
        this.f19487g = bundle.getString("post_id");
        this.f19488h = bundle.getString("st_type");
        this.n = bundle.getString("from_forum_id");
        this.o = bundle.getString(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
        this.f19489i = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
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
        this.R = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.S = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.R = bundle.getInt(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.S = bundle.getInt(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.T = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
        this.U = bundle.getInt(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
        this.V = bundle.getString(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
        this.W = bundle.getInt(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        this.X = bundle.getBoolean(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
    }

    public void initWithIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        this.pageFromType = intent.getIntExtra(SubPbActivityConfig.KEY_PAGE_START_FROM, 0);
        this.f19486f = intent.getStringExtra("thread_id");
        this.f19487g = intent.getStringExtra("post_id");
        this.f19488h = intent.getStringExtra("st_type");
        this.n = intent.getStringExtra("from_forum_id");
        this.o = intent.getStringExtra(SubPbActivityConfig.KEY_FROM_FRS_FORUM_ID);
        this.f19489i = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
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
        this.R = intent.getIntExtra(SubPbActivityConfig.KEY_HAS_FORUM_RULE, 0);
        this.S = intent.getIntExtra(SubPbActivityConfig.KEY_IS_MANAGER, 0);
        this.T = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_GRAY_CALE_FORUM, 0);
        this.U = intent.getIntExtra(SubPbActivityConfig.KEY_DELETED_REASON_INFO_IS_IS_BOOM_GROW, 0);
        this.V = intent.getStringExtra(SubPbActivityConfig.KEY_FORUM_HEAD_URL);
        this.W = intent.getIntExtra(SubPbActivityConfig.KEY_USER_LEVEL, 0);
        this.X = intent.getBooleanExtra(SubPbActivityConfig.KEY_MAIN_POST_MASK_VISIBLE, false);
    }

    public SmallTailInfo j0() {
        return this.E;
    }

    public String k0() {
        return this.f19486f;
    }

    public String l0() {
        if (!StringUtils.isNull(this.f19486f) && !"0".equals(this.f19486f)) {
            return this.f19486f;
        }
        return this.M;
    }

    public ArrayList<String> m0() {
        return this.G;
    }

    public ConcurrentHashMap<String, ImageUrlData> n0() {
        return this.H;
    }

    public int o0() {
        return this.r;
    }

    public int p0() {
        return this.W;
    }

    public boolean q0() {
        r rVar = this.u;
        return (rVar == null || rVar.i() == null) ? false : true;
    }

    public boolean r0() {
        return this.I;
    }

    public boolean s0() {
        return "hot_topic".equals(getStType());
    }

    public boolean t0() {
        return this.f19489i;
    }

    public boolean u0() {
        return this.X;
    }

    public boolean v0() {
        return this.q;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String w() {
        return this.f19487g;
    }

    public boolean w0() {
        return this.L;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData x(String str) {
        r rVar = this.u;
        if (rVar == null || rVar.d() == null || this.u.l() == null || this.u.i() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        writeData.sourceFrom = String.valueOf(this.pageFromType);
        writeData.setForumName(this.u.d().getName());
        writeData.setForumId(this.u.d().getId());
        writeData.setFromForumId(this.o);
        writeData.setFloor(this.u.i().E());
        writeData.setType(2);
        writeData.setThreadId(this.u.l().o0());
        writeData.setFloorNum(0);
        return writeData;
    }

    public boolean x0() {
        return this.A;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean y() {
        N0();
        return true;
    }

    public boolean y0() {
        return this.m;
    }

    public boolean z0() {
        return C0(0);
    }
}
