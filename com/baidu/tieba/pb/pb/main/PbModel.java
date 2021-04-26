package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.i0.a.f;
import d.a.i0.r.q.a2;
import d.a.i0.r.q.z0;
import d.a.i0.t.n;
import d.a.j0.d2.h.p;
import d.a.j0.d2.h.s;
import d.a.j0.d2.k.e.c0;
import d.a.j0.d2.k.e.e0;
import d.a.j0.d2.k.e.k;
import d.a.j0.d2.k.e.m0;
import d.a.j0.d2.k.e.q;
import d.a.j0.d3.h0.o;
import d.a.j0.s2.w;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes3.dex */
public class PbModel extends DataModel {
    public static final String DB_KEY_HOST = "_host";
    public static final String DB_KEY_HOT = "_hot";
    public static final String DB_KEY_REVER = "_rev";
    public static final int MIN_NUM_SHOW_GO_BACK_ITEM = 3;
    public static final int UPDATE_TYPE_MARK = 4;
    public static final int UPDATE_TYPE_MORE = 1;
    public static final int UPDATE_TYPE_PREVIOUS = 2;
    public static final int UPDATE_TYPE_REDIRECTPAGE = 5;
    public static final int UPDATE_TYPE_REDIRECT_FLOOR = 7;
    public static final int UPDATE_TYPE_SINGLE_FLOOR = 8;
    public static final int UPDATE_TYPE_SPEC_FLOOR = 6;
    public static final int UPDATE_TYPE_UPDATE = 3;
    public static int UPGRADE_TO_PHOTO_LIVE;
    public boolean A;
    public PostData A0;
    public boolean B;
    public PostData B0;
    public boolean C;
    public int C0;
    public boolean D;
    public int D0;
    public boolean E;
    public boolean E0;
    public long F;
    public boolean G;
    public String H;
    public d.a.j0.d2.h.e I;
    public int J;
    public int K;
    public Rect K0;
    public boolean L;
    public int L0;
    public boolean M;
    public String M0;
    public boolean N;
    public o N0;
    public boolean O;
    public boolean O0;
    public String P;
    public String P0;
    public Context Q;
    public String Q0;
    public g R;
    public int R0;
    public String S;
    public String S0;
    public String T;
    public String T0;
    public String U;
    public String U0;
    public String V;
    public String V0;
    public int W;
    public String W0;
    public int X;
    public String X0;
    public boolean Y;
    public boolean Y0;
    public d.a.j0.d3.j0.b Z;
    public String Z0;
    public BaseFragmentActivity a0;
    public boolean a1;
    public boolean b0;
    public f.b b1;
    public boolean c0;
    public CustomMessageListener c1;
    public long d0;
    public d.a.c.c.g.a d1;

    /* renamed from: e  reason: collision with root package name */
    public String f19891e;
    public boolean e0;
    public CustomMessageListener e1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19892f;
    public boolean f0;
    public CustomMessageListener f1;

    /* renamed from: g  reason: collision with root package name */
    public String f19893g;
    public String g0;
    public PraiseData g1;

    /* renamed from: h  reason: collision with root package name */
    public String f19894h;
    public String h0;

    /* renamed from: i  reason: collision with root package name */
    public String f19895i;
    public long i0;
    public boolean isLoading;
    public String j;
    public boolean j0;
    public boolean k;
    public int k0;
    public boolean l;
    public boolean l0;
    public boolean m;
    public boolean m0;
    public String mStType;
    public boolean n;
    public int n0;
    public int o;
    public d.a.j0.d2.h.c o0;
    public int p;
    public final c0 p0;
    public boolean q;
    public final q q0;
    public int r;
    public final e0 r0;
    public int s;
    public String s0;
    public long t;
    public final CheckRealNameModel t0;
    public int u;
    public final AddExperiencedModel u0;
    public int v;
    public SuggestEmotionModel v0;
    public int w;
    public GetSugMatchWordsModel w0;
    public int x;
    public boolean x0;
    public boolean y;
    public int y0;
    public boolean z;
    public String z0;

    /* loaded from: classes3.dex */
    public class a implements f.b {
        public a() {
        }

        @Override // d.a.i0.a.f.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            if (hashMap == null) {
                return;
            }
            if (hashMap.get(d.a.i0.a.f.o) instanceof String) {
                PbModel.this.f19891e = (String) hashMap.get(d.a.i0.a.f.o);
            }
            if (hashMap.get(d.a.i0.a.f.p) instanceof String) {
                PbModel.this.P0 = (String) hashMap.get(d.a.i0.a.f.p);
            }
            if (hashMap.get(d.a.i0.a.f.q) instanceof String) {
                PbModel.this.Q0 = (String) hashMap.get(d.a.i0.a.f.q);
            }
            if (hashMap.get(d.a.i0.a.f.r) instanceof String) {
                PbModel.this.R0 = d.a.c.e.m.b.d((String) hashMap.get(d.a.i0.a.f.r), 0);
            }
            if (hashMap.get(d.a.i0.a.f.s) instanceof String) {
                PbModel.this.S0 = (String) hashMap.get(d.a.i0.a.f.s);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof SignData)) {
                return;
            }
            SignData signData = (SignData) customResponsedMessage.getData();
            if (PbModel.this.y0() == null || PbModel.this.y0().l() == null || PbModel.this.y0().l().getSignData() == null || !signData.forumId.equals(PbModel.this.y0().m())) {
                return;
            }
            PbModel.this.y0().l().getSignData().is_signed = signData.is_signed;
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.a.c.c.g.a {
        public c(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            boolean z2 = responsedMessage instanceof pbPageSocketResponseMessage;
            if ((z2 || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == PbModel.this.getUniqueId()) {
                if (responsedMessage.hasError() && responsedMessage.getError() != 4 && j.z()) {
                    PbModel.this.a0.showToast(responsedMessage.getErrorString());
                }
                if (z2) {
                    PbModel.this.u1((pbPageSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof pbPageHttpResponseMessage) {
                    PbModel.this.t1((pbPageHttpResponseMessage) responsedMessage);
                    z = true;
                } else {
                    z = false;
                }
                if (responsedMessage.getError() != 0) {
                    long j = z ? 0L : ((pbPageSocketResponseMessage) responsedMessage).sequenceID;
                    PbPageRequestMessage pbPageRequestMessage = (PbPageRequestMessage) responsedMessage.getOrginalMessage().getExtra();
                    long clientLogID = responsedMessage.getOrginalMessage().getClientLogID();
                    int cmd = responsedMessage.getOrginalMessage().getCmd();
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    Object[] objArr = new Object[6];
                    objArr[0] = "updateType";
                    objArr[1] = pbPageRequestMessage != null ? String.valueOf(pbPageRequestMessage.getUpdateType()) : null;
                    objArr[2] = "ThreadId";
                    objArr[3] = pbPageRequestMessage != null ? String.valueOf(pbPageRequestMessage.get_kz()) : null;
                    objArr[4] = "seq_id";
                    objArr[5] = Long.valueOf(j);
                    d.a.i0.r.z.a.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                }
                if (PbModel.this.b0 && PbModel.this.c0) {
                    return;
                }
                if (!PbModel.this.b0) {
                    PbModel.this.b0 = true;
                } else {
                    PbModel.this.c0 = true;
                }
                if (PbModel.this.R != null) {
                    PbModel.this.R.a(PbModel.this.A0(), z, responsedMessage, PbModel.this.e0, System.currentTimeMillis() - PbModel.this.d0);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            String valueOf = String.valueOf(customResponsedMessage.getData());
            d.a.j0.d2.h.e eVar = PbModel.this.I;
            if (eVar == null || eVar.h() == null || PbModel.this.I.h().h() == null || !PbModel.this.I.h().h().equals(valueOf)) {
                return;
            }
            PbModel.this.I.h().setIsLike(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Long)) {
                return;
            }
            String valueOf = String.valueOf(customResponsedMessage.getData());
            d.a.j0.d2.h.e eVar = PbModel.this.I;
            if (eVar == null || eVar.h() == null || PbModel.this.I.h().h() == null || !PbModel.this.I.h().h().equals(valueOf)) {
                return;
            }
            PbModel.this.I.h().setIsLike(true);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.d2.h.e f19901e;

        public f(d.a.j0.d2.h.e eVar) {
            this.f19901e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            PbModel.this.w1(this.f19901e, 3, false, 0, "", false, 0, 0L, 0L, true);
            PbModel.this.isLoading = false;
        }
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void b(d.a.j0.d2.h.e eVar);

        void c(boolean z, int i2, int i3, int i4, d.a.j0.d2.h.e eVar, String str, int i5);
    }

    static {
        int a2 = d.a.i0.t.e.a() / 30;
        UPGRADE_TO_PHOTO_LIVE = 1;
    }

    public PbModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        this.mStType = null;
        this.f19891e = null;
        this.f19892f = false;
        this.f19893g = null;
        this.f19894h = null;
        this.j = null;
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = true;
        this.o = 0;
        this.p = 0;
        this.q = false;
        this.r = 0;
        this.s = 0;
        this.t = 0L;
        this.u = 1;
        this.v = 1;
        this.w = 1;
        this.x = 1;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = 0L;
        this.G = false;
        this.H = null;
        this.I = null;
        this.isLoading = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = -1;
        this.X = -1;
        this.Z = null;
        this.b0 = false;
        this.c0 = false;
        this.g0 = null;
        this.h0 = null;
        this.i0 = 0L;
        this.j0 = false;
        this.k0 = -1;
        this.m0 = false;
        this.x0 = false;
        this.y0 = 0;
        this.L0 = 0;
        this.O0 = false;
        this.c1 = new b(2001222);
        this.d1 = new c(CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.e1 = new d(2001336);
        this.f1 = new e(2001335);
        this.g1 = null;
        registerListener(this.d1);
        registerListener(this.c1);
        registerListener(this.f1);
        registerListener(this.e1);
        d.a.j0.d2.h.e eVar = new d.a.j0.d2.h.e();
        this.I = eVar;
        eVar.k0(0);
        this.Q = baseFragmentActivity.getPageContext().getPageActivity();
        this.a0 = baseFragmentActivity;
        this.p0 = new c0(this, baseFragmentActivity);
        this.q0 = new q(this, this.a0);
        this.r0 = new e0(this, this.a0);
        this.t0 = new CheckRealNameModel(this.a0.getPageContext());
        this.v0 = new SuggestEmotionModel();
        this.u0 = new AddExperiencedModel(this.a0.getPageContext());
        this.b1 = new a();
    }

    public int A0() {
        return 1001;
    }

    public String A1(d.a.j0.d2.h.e eVar) {
        String str = null;
        if (eVar == null) {
            return null;
        }
        if (eVar.L() != null && eVar.L().T() != null) {
            str = eVar.L().T().getUserId();
        }
        return str == null ? "" : str;
    }

    public String B0() {
        return this.s0;
    }

    public final int B1(int i2) {
        if (i2 != 1) {
            return i2 != 3 ? -1 : 1;
        }
        return 2;
    }

    public String C0() {
        return this.M0;
    }

    public void C1(int i2) {
        this.u = i2;
        this.v = i2;
        this.w = i2;
    }

    public String D0() {
        return this.V0;
    }

    public void D1() {
        d.a.j0.d2.h.e eVar = this.I;
        if (eVar == null || ListUtils.isEmpty(eVar.D())) {
            return;
        }
        if (this.B0 != null) {
            this.I.D().remove(this.B0);
            this.B0 = null;
        }
        if (this.A0 != null) {
            this.I.D().remove(this.A0);
            this.A0 = null;
        }
    }

    public String E0() {
        return this.W0;
    }

    public void E1(Bundle bundle) {
        bundle.putString("thread_id", this.f19891e);
        bundle.putString("post_id", this.f19893g);
        bundle.putString("forum_id", this.f19894h);
        bundle.putString("from_forum_id", this.f19895i);
        bundle.putInt("key_start_from", this.y0);
        bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.k);
        bundle.putBoolean("host_only", this.l);
        bundle.putBoolean("squence", this.n);
        bundle.putInt("sort_type", this.o);
        bundle.putString("st_type", this.mStType);
        bundle.putString("locate", this.P);
        bundle.putInt("is_good", this.r);
        bundle.putInt("is_top", this.s);
        bundle.putLong("thread_time", this.t);
        bundle.putBoolean("from_mark", this.C);
        bundle.putBoolean("is_pb_key_need_post_id", this.E);
        bundle.putBoolean("is_sub_pb", this.z);
        bundle.putBoolean("is_ad", this.y);
        bundle.putBoolean("is_pv", this.G);
        bundle.putLong("msg_id", this.F);
        bundle.putString("extra_pb_cache_key", this.V);
        bundle.putInt("thread_type", this.K);
        bundle.putBoolean("is_from_thread_config", this.L);
        bundle.putBoolean("is_from_interview_live_config", this.M);
        bundle.putBoolean("is_from_my_god_config", this.N);
        bundle.putInt("extra_pb_is_attention_key", this.X);
        bundle.putInt("extra_pb_funs_count_key", this.W);
        bundle.putBoolean("from_frs", this.A);
        bundle.putBoolean("from_maintab", this.B);
        bundle.putBoolean("from_smart_frs", this.m0);
        bundle.putBoolean("from_hottopic", this.O);
        bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.E0);
        bundle.putString("high_light_post_id", this.j);
        bundle.putString("key_ori_ugc_nid", this.P0);
        bundle.putString("key_ori_ugc_tid", this.Q0);
        bundle.putInt("key_ori_ugc_type", this.R0);
        bundle.putString("key_ori_ugc_vid", this.S0);
        bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.T0);
        bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.U0);
        bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.V0);
        bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.W0);
    }

    public String F0() {
        return this.U0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:138:0x032f, code lost:
        if ((r11.w - 1) <= 0) goto L136;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0289 A[Catch: Exception -> 0x0496, TryCatch #0 {Exception -> 0x0496, blocks: (B:37:0x00e7, B:39:0x00eb, B:42:0x00f5, B:46:0x015c, B:48:0x016c, B:49:0x016f, B:51:0x017c, B:52:0x017f, B:54:0x0183, B:55:0x0188, B:57:0x018c, B:58:0x0191, B:60:0x0195, B:61:0x01a4, B:63:0x01a8, B:64:0x01ab, B:66:0x01af, B:67:0x01c7, B:71:0x01dd, B:73:0x01ea, B:74:0x01fc, B:75:0x020c, B:77:0x0213, B:79:0x0217, B:81:0x021b, B:85:0x022f, B:87:0x0236, B:89:0x023d, B:88:0x023a, B:82:0x021f, B:84:0x022c, B:90:0x0242, B:91:0x0256, B:92:0x0270, B:94:0x0274, B:97:0x0279, B:99:0x0280, B:101:0x0289, B:105:0x029d, B:107:0x02a1, B:108:0x02a4, B:102:0x028d, B:104:0x0294, B:98:0x027d, B:110:0x02ab, B:112:0x02b1, B:114:0x02b7, B:115:0x02c3, B:117:0x02cd, B:119:0x02d3, B:121:0x02d8, B:122:0x02e3, B:124:0x02e9, B:125:0x02f3, B:127:0x02f7, B:129:0x02ff, B:131:0x030c, B:132:0x030f, B:133:0x0314, B:135:0x031e, B:137:0x0322, B:144:0x0345, B:147:0x034b, B:174:0x03aa, B:150:0x0351, B:152:0x0357, B:153:0x035c, B:155:0x0360, B:157:0x0368, B:158:0x036b, B:161:0x0378, B:163:0x037c, B:164:0x0386, B:166:0x038a, B:168:0x0392, B:170:0x039f, B:171:0x03a3, B:173:0x03a7, B:140:0x0333, B:175:0x03ad, B:179:0x03db, B:181:0x03e6, B:183:0x03f3, B:185:0x03fd, B:187:0x0404, B:189:0x0408, B:191:0x040d, B:194:0x0412, B:196:0x0419, B:198:0x0435, B:199:0x043e, B:201:0x0445, B:203:0x044f, B:206:0x045c, B:207:0x0461, B:210:0x046d, B:211:0x0471, B:195:0x0416, B:186:0x0401, B:182:0x03ee, B:212:0x0493), top: B:217:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x028d A[Catch: Exception -> 0x0496, TryCatch #0 {Exception -> 0x0496, blocks: (B:37:0x00e7, B:39:0x00eb, B:42:0x00f5, B:46:0x015c, B:48:0x016c, B:49:0x016f, B:51:0x017c, B:52:0x017f, B:54:0x0183, B:55:0x0188, B:57:0x018c, B:58:0x0191, B:60:0x0195, B:61:0x01a4, B:63:0x01a8, B:64:0x01ab, B:66:0x01af, B:67:0x01c7, B:71:0x01dd, B:73:0x01ea, B:74:0x01fc, B:75:0x020c, B:77:0x0213, B:79:0x0217, B:81:0x021b, B:85:0x022f, B:87:0x0236, B:89:0x023d, B:88:0x023a, B:82:0x021f, B:84:0x022c, B:90:0x0242, B:91:0x0256, B:92:0x0270, B:94:0x0274, B:97:0x0279, B:99:0x0280, B:101:0x0289, B:105:0x029d, B:107:0x02a1, B:108:0x02a4, B:102:0x028d, B:104:0x0294, B:98:0x027d, B:110:0x02ab, B:112:0x02b1, B:114:0x02b7, B:115:0x02c3, B:117:0x02cd, B:119:0x02d3, B:121:0x02d8, B:122:0x02e3, B:124:0x02e9, B:125:0x02f3, B:127:0x02f7, B:129:0x02ff, B:131:0x030c, B:132:0x030f, B:133:0x0314, B:135:0x031e, B:137:0x0322, B:144:0x0345, B:147:0x034b, B:174:0x03aa, B:150:0x0351, B:152:0x0357, B:153:0x035c, B:155:0x0360, B:157:0x0368, B:158:0x036b, B:161:0x0378, B:163:0x037c, B:164:0x0386, B:166:0x038a, B:168:0x0392, B:170:0x039f, B:171:0x03a3, B:173:0x03a7, B:140:0x0333, B:175:0x03ad, B:179:0x03db, B:181:0x03e6, B:183:0x03f3, B:185:0x03fd, B:187:0x0404, B:189:0x0408, B:191:0x040d, B:194:0x0412, B:196:0x0419, B:198:0x0435, B:199:0x043e, B:201:0x0445, B:203:0x044f, B:206:0x045c, B:207:0x0461, B:210:0x046d, B:211:0x0471, B:195:0x0416, B:186:0x0401, B:182:0x03ee, B:212:0x0493), top: B:217:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02a1 A[Catch: Exception -> 0x0496, TryCatch #0 {Exception -> 0x0496, blocks: (B:37:0x00e7, B:39:0x00eb, B:42:0x00f5, B:46:0x015c, B:48:0x016c, B:49:0x016f, B:51:0x017c, B:52:0x017f, B:54:0x0183, B:55:0x0188, B:57:0x018c, B:58:0x0191, B:60:0x0195, B:61:0x01a4, B:63:0x01a8, B:64:0x01ab, B:66:0x01af, B:67:0x01c7, B:71:0x01dd, B:73:0x01ea, B:74:0x01fc, B:75:0x020c, B:77:0x0213, B:79:0x0217, B:81:0x021b, B:85:0x022f, B:87:0x0236, B:89:0x023d, B:88:0x023a, B:82:0x021f, B:84:0x022c, B:90:0x0242, B:91:0x0256, B:92:0x0270, B:94:0x0274, B:97:0x0279, B:99:0x0280, B:101:0x0289, B:105:0x029d, B:107:0x02a1, B:108:0x02a4, B:102:0x028d, B:104:0x0294, B:98:0x027d, B:110:0x02ab, B:112:0x02b1, B:114:0x02b7, B:115:0x02c3, B:117:0x02cd, B:119:0x02d3, B:121:0x02d8, B:122:0x02e3, B:124:0x02e9, B:125:0x02f3, B:127:0x02f7, B:129:0x02ff, B:131:0x030c, B:132:0x030f, B:133:0x0314, B:135:0x031e, B:137:0x0322, B:144:0x0345, B:147:0x034b, B:174:0x03aa, B:150:0x0351, B:152:0x0357, B:153:0x035c, B:155:0x0360, B:157:0x0368, B:158:0x036b, B:161:0x0378, B:163:0x037c, B:164:0x0386, B:166:0x038a, B:168:0x0392, B:170:0x039f, B:171:0x03a3, B:173:0x03a7, B:140:0x0333, B:175:0x03ad, B:179:0x03db, B:181:0x03e6, B:183:0x03f3, B:185:0x03fd, B:187:0x0404, B:189:0x0408, B:191:0x040d, B:194:0x0412, B:196:0x0419, B:198:0x0435, B:199:0x043e, B:201:0x0445, B:203:0x044f, B:206:0x045c, B:207:0x0461, B:210:0x046d, B:211:0x0471, B:195:0x0416, B:186:0x0401, B:182:0x03ee, B:212:0x0493), top: B:217:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0360 A[Catch: Exception -> 0x0496, TryCatch #0 {Exception -> 0x0496, blocks: (B:37:0x00e7, B:39:0x00eb, B:42:0x00f5, B:46:0x015c, B:48:0x016c, B:49:0x016f, B:51:0x017c, B:52:0x017f, B:54:0x0183, B:55:0x0188, B:57:0x018c, B:58:0x0191, B:60:0x0195, B:61:0x01a4, B:63:0x01a8, B:64:0x01ab, B:66:0x01af, B:67:0x01c7, B:71:0x01dd, B:73:0x01ea, B:74:0x01fc, B:75:0x020c, B:77:0x0213, B:79:0x0217, B:81:0x021b, B:85:0x022f, B:87:0x0236, B:89:0x023d, B:88:0x023a, B:82:0x021f, B:84:0x022c, B:90:0x0242, B:91:0x0256, B:92:0x0270, B:94:0x0274, B:97:0x0279, B:99:0x0280, B:101:0x0289, B:105:0x029d, B:107:0x02a1, B:108:0x02a4, B:102:0x028d, B:104:0x0294, B:98:0x027d, B:110:0x02ab, B:112:0x02b1, B:114:0x02b7, B:115:0x02c3, B:117:0x02cd, B:119:0x02d3, B:121:0x02d8, B:122:0x02e3, B:124:0x02e9, B:125:0x02f3, B:127:0x02f7, B:129:0x02ff, B:131:0x030c, B:132:0x030f, B:133:0x0314, B:135:0x031e, B:137:0x0322, B:144:0x0345, B:147:0x034b, B:174:0x03aa, B:150:0x0351, B:152:0x0357, B:153:0x035c, B:155:0x0360, B:157:0x0368, B:158:0x036b, B:161:0x0378, B:163:0x037c, B:164:0x0386, B:166:0x038a, B:168:0x0392, B:170:0x039f, B:171:0x03a3, B:173:0x03a7, B:140:0x0333, B:175:0x03ad, B:179:0x03db, B:181:0x03e6, B:183:0x03f3, B:185:0x03fd, B:187:0x0404, B:189:0x0408, B:191:0x040d, B:194:0x0412, B:196:0x0419, B:198:0x0435, B:199:0x043e, B:201:0x0445, B:203:0x044f, B:206:0x045c, B:207:0x0461, B:210:0x046d, B:211:0x0471, B:195:0x0416, B:186:0x0401, B:182:0x03ee, B:212:0x0493), top: B:217:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x037c A[Catch: Exception -> 0x0496, TryCatch #0 {Exception -> 0x0496, blocks: (B:37:0x00e7, B:39:0x00eb, B:42:0x00f5, B:46:0x015c, B:48:0x016c, B:49:0x016f, B:51:0x017c, B:52:0x017f, B:54:0x0183, B:55:0x0188, B:57:0x018c, B:58:0x0191, B:60:0x0195, B:61:0x01a4, B:63:0x01a8, B:64:0x01ab, B:66:0x01af, B:67:0x01c7, B:71:0x01dd, B:73:0x01ea, B:74:0x01fc, B:75:0x020c, B:77:0x0213, B:79:0x0217, B:81:0x021b, B:85:0x022f, B:87:0x0236, B:89:0x023d, B:88:0x023a, B:82:0x021f, B:84:0x022c, B:90:0x0242, B:91:0x0256, B:92:0x0270, B:94:0x0274, B:97:0x0279, B:99:0x0280, B:101:0x0289, B:105:0x029d, B:107:0x02a1, B:108:0x02a4, B:102:0x028d, B:104:0x0294, B:98:0x027d, B:110:0x02ab, B:112:0x02b1, B:114:0x02b7, B:115:0x02c3, B:117:0x02cd, B:119:0x02d3, B:121:0x02d8, B:122:0x02e3, B:124:0x02e9, B:125:0x02f3, B:127:0x02f7, B:129:0x02ff, B:131:0x030c, B:132:0x030f, B:133:0x0314, B:135:0x031e, B:137:0x0322, B:144:0x0345, B:147:0x034b, B:174:0x03aa, B:150:0x0351, B:152:0x0357, B:153:0x035c, B:155:0x0360, B:157:0x0368, B:158:0x036b, B:161:0x0378, B:163:0x037c, B:164:0x0386, B:166:0x038a, B:168:0x0392, B:170:0x039f, B:171:0x03a3, B:173:0x03a7, B:140:0x0333, B:175:0x03ad, B:179:0x03db, B:181:0x03e6, B:183:0x03f3, B:185:0x03fd, B:187:0x0404, B:189:0x0408, B:191:0x040d, B:194:0x0412, B:196:0x0419, B:198:0x0435, B:199:0x043e, B:201:0x0445, B:203:0x044f, B:206:0x045c, B:207:0x0461, B:210:0x046d, B:211:0x0471, B:195:0x0416, B:186:0x0401, B:182:0x03ee, B:212:0x0493), top: B:217:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03a7 A[Catch: Exception -> 0x0496, TryCatch #0 {Exception -> 0x0496, blocks: (B:37:0x00e7, B:39:0x00eb, B:42:0x00f5, B:46:0x015c, B:48:0x016c, B:49:0x016f, B:51:0x017c, B:52:0x017f, B:54:0x0183, B:55:0x0188, B:57:0x018c, B:58:0x0191, B:60:0x0195, B:61:0x01a4, B:63:0x01a8, B:64:0x01ab, B:66:0x01af, B:67:0x01c7, B:71:0x01dd, B:73:0x01ea, B:74:0x01fc, B:75:0x020c, B:77:0x0213, B:79:0x0217, B:81:0x021b, B:85:0x022f, B:87:0x0236, B:89:0x023d, B:88:0x023a, B:82:0x021f, B:84:0x022c, B:90:0x0242, B:91:0x0256, B:92:0x0270, B:94:0x0274, B:97:0x0279, B:99:0x0280, B:101:0x0289, B:105:0x029d, B:107:0x02a1, B:108:0x02a4, B:102:0x028d, B:104:0x0294, B:98:0x027d, B:110:0x02ab, B:112:0x02b1, B:114:0x02b7, B:115:0x02c3, B:117:0x02cd, B:119:0x02d3, B:121:0x02d8, B:122:0x02e3, B:124:0x02e9, B:125:0x02f3, B:127:0x02f7, B:129:0x02ff, B:131:0x030c, B:132:0x030f, B:133:0x0314, B:135:0x031e, B:137:0x0322, B:144:0x0345, B:147:0x034b, B:174:0x03aa, B:150:0x0351, B:152:0x0357, B:153:0x035c, B:155:0x0360, B:157:0x0368, B:158:0x036b, B:161:0x0378, B:163:0x037c, B:164:0x0386, B:166:0x038a, B:168:0x0392, B:170:0x039f, B:171:0x03a3, B:173:0x03a7, B:140:0x0333, B:175:0x03ad, B:179:0x03db, B:181:0x03e6, B:183:0x03f3, B:185:0x03fd, B:187:0x0404, B:189:0x0408, B:191:0x040d, B:194:0x0412, B:196:0x0419, B:198:0x0435, B:199:0x043e, B:201:0x0445, B:203:0x044f, B:206:0x045c, B:207:0x0461, B:210:0x046d, B:211:0x0471, B:195:0x0416, B:186:0x0401, B:182:0x03ee, B:212:0x0493), top: B:217:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0435 A[Catch: Exception -> 0x0496, TryCatch #0 {Exception -> 0x0496, blocks: (B:37:0x00e7, B:39:0x00eb, B:42:0x00f5, B:46:0x015c, B:48:0x016c, B:49:0x016f, B:51:0x017c, B:52:0x017f, B:54:0x0183, B:55:0x0188, B:57:0x018c, B:58:0x0191, B:60:0x0195, B:61:0x01a4, B:63:0x01a8, B:64:0x01ab, B:66:0x01af, B:67:0x01c7, B:71:0x01dd, B:73:0x01ea, B:74:0x01fc, B:75:0x020c, B:77:0x0213, B:79:0x0217, B:81:0x021b, B:85:0x022f, B:87:0x0236, B:89:0x023d, B:88:0x023a, B:82:0x021f, B:84:0x022c, B:90:0x0242, B:91:0x0256, B:92:0x0270, B:94:0x0274, B:97:0x0279, B:99:0x0280, B:101:0x0289, B:105:0x029d, B:107:0x02a1, B:108:0x02a4, B:102:0x028d, B:104:0x0294, B:98:0x027d, B:110:0x02ab, B:112:0x02b1, B:114:0x02b7, B:115:0x02c3, B:117:0x02cd, B:119:0x02d3, B:121:0x02d8, B:122:0x02e3, B:124:0x02e9, B:125:0x02f3, B:127:0x02f7, B:129:0x02ff, B:131:0x030c, B:132:0x030f, B:133:0x0314, B:135:0x031e, B:137:0x0322, B:144:0x0345, B:147:0x034b, B:174:0x03aa, B:150:0x0351, B:152:0x0357, B:153:0x035c, B:155:0x0360, B:157:0x0368, B:158:0x036b, B:161:0x0378, B:163:0x037c, B:164:0x0386, B:166:0x038a, B:168:0x0392, B:170:0x039f, B:171:0x03a3, B:173:0x03a7, B:140:0x0333, B:175:0x03ad, B:179:0x03db, B:181:0x03e6, B:183:0x03f3, B:185:0x03fd, B:187:0x0404, B:189:0x0408, B:191:0x040d, B:194:0x0412, B:196:0x0419, B:198:0x0435, B:199:0x043e, B:201:0x0445, B:203:0x044f, B:206:0x045c, B:207:0x0461, B:210:0x046d, B:211:0x0471, B:195:0x0416, B:186:0x0401, B:182:0x03ee, B:212:0x0493), top: B:217:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0445 A[Catch: Exception -> 0x0496, TryCatch #0 {Exception -> 0x0496, blocks: (B:37:0x00e7, B:39:0x00eb, B:42:0x00f5, B:46:0x015c, B:48:0x016c, B:49:0x016f, B:51:0x017c, B:52:0x017f, B:54:0x0183, B:55:0x0188, B:57:0x018c, B:58:0x0191, B:60:0x0195, B:61:0x01a4, B:63:0x01a8, B:64:0x01ab, B:66:0x01af, B:67:0x01c7, B:71:0x01dd, B:73:0x01ea, B:74:0x01fc, B:75:0x020c, B:77:0x0213, B:79:0x0217, B:81:0x021b, B:85:0x022f, B:87:0x0236, B:89:0x023d, B:88:0x023a, B:82:0x021f, B:84:0x022c, B:90:0x0242, B:91:0x0256, B:92:0x0270, B:94:0x0274, B:97:0x0279, B:99:0x0280, B:101:0x0289, B:105:0x029d, B:107:0x02a1, B:108:0x02a4, B:102:0x028d, B:104:0x0294, B:98:0x027d, B:110:0x02ab, B:112:0x02b1, B:114:0x02b7, B:115:0x02c3, B:117:0x02cd, B:119:0x02d3, B:121:0x02d8, B:122:0x02e3, B:124:0x02e9, B:125:0x02f3, B:127:0x02f7, B:129:0x02ff, B:131:0x030c, B:132:0x030f, B:133:0x0314, B:135:0x031e, B:137:0x0322, B:144:0x0345, B:147:0x034b, B:174:0x03aa, B:150:0x0351, B:152:0x0357, B:153:0x035c, B:155:0x0360, B:157:0x0368, B:158:0x036b, B:161:0x0378, B:163:0x037c, B:164:0x0386, B:166:0x038a, B:168:0x0392, B:170:0x039f, B:171:0x03a3, B:173:0x03a7, B:140:0x0333, B:175:0x03ad, B:179:0x03db, B:181:0x03e6, B:183:0x03f3, B:185:0x03fd, B:187:0x0404, B:189:0x0408, B:191:0x040d, B:194:0x0412, B:196:0x0419, B:198:0x0435, B:199:0x043e, B:201:0x0445, B:203:0x044f, B:206:0x045c, B:207:0x0461, B:210:0x046d, B:211:0x0471, B:195:0x0416, B:186:0x0401, B:182:0x03ee, B:212:0x0493), top: B:217:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0378 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean F1(int i2) {
        boolean z;
        int size;
        int i3;
        int i4;
        this.J = i2;
        int i5 = 0;
        if (this.isLoading) {
            return false;
        }
        this.isLoading = true;
        s1(i2);
        d.a.j0.d2.h.e f2 = m0.b().f();
        if (f2 != null && f2.L() != null) {
            f2.L().s3(0);
            this.n = m0.b().i();
            this.l = m0.b().a();
            this.q = m0.b().c();
            this.A0 = m0.b().g();
            this.B0 = m0.b().h();
            this.C0 = m0.b().d();
            this.K0 = m0.b().k();
            this.L0 = m0.b().j();
            boolean z2 = this.l;
            this.x0 = z2;
            if (z2 || this.C) {
                this.Y = false;
            }
            d.a.c.e.m.e.a().post(new f(f2));
            return false;
        }
        if (i2 == 4 && !this.f0) {
            G1(Y(), true, this.f19893g, 3);
        }
        if (i2 == 3 && !this.f0) {
            if (this.C) {
                G1(Y(), true, this.f19893g, 3);
            } else {
                G1(Y(), false, this.f19893g, 3);
            }
        }
        this.f0 = false;
        PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
        pbPageRequestMessage.setUpdateType(i2);
        pbPageRequestMessage.setIsReqAd(this.N0 == null ? 1 : 0);
        pbPageRequestMessage.setLastids(d.a.i0.u.a.o);
        if (this.l || this.C) {
            this.Y = false;
        }
        try {
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        if (this.f19891e != null && this.f19891e.length() != 0) {
            pbPageRequestMessage.set_kz(d.a.c.e.m.b.f(this.f19891e, 0L));
            pbPageRequestMessage.setFloorSortType(1);
            pbPageRequestMessage.setFloor_rn(4);
            pbPageRequestMessage.set_rn(15);
            pbPageRequestMessage.set_with_floor(1);
            pbPageRequestMessage.set_scr_w(Integer.valueOf(l.k(TbadkCoreApplication.getInst().getApp())));
            pbPageRequestMessage.set_scr_h(Integer.valueOf(l.i(TbadkCoreApplication.getInst().getApp())));
            pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
            pbPageRequestMessage.set_q_type(Integer.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1));
            pbPageRequestMessage.setSchemeUrl(this.X0);
            if (!this.n) {
                pbPageRequestMessage.set_r(1);
            }
            pbPageRequestMessage.set_r(Integer.valueOf(this.o));
            if (this.l) {
                pbPageRequestMessage.set_lz(1);
            }
            if (this.mStType != null) {
                pbPageRequestMessage.set_st_type(this.mStType);
            }
            if (this.P != null) {
                pbPageRequestMessage.setLocate(this.P);
            }
            if (this.G) {
                pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.F));
                pbPageRequestMessage.set_message_click("1");
            }
            if (this.Y) {
                pbPageRequestMessage.set_banner(1);
            }
            if (this.S != null) {
                pbPageRequestMessage.setOpType(this.S);
                pbPageRequestMessage.setOpUrl(this.T);
                pbPageRequestMessage.setOpStat(d.a.c.e.m.b.d(this.U, 0));
                pbPageRequestMessage.setOpMessageID(this.F);
            }
            pbPageRequestMessage.set_thread_type(Integer.valueOf(this.K));
            ArrayList<PostData> D = this.I.D();
            switch (i2) {
                case 1:
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_banner(0);
                    if (!this.C) {
                        if (this.o == 1) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.w - 1));
                            break;
                        } else {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.v + 1));
                            z = this.v >= this.x;
                        }
                        if (!this.C || z || this.D) {
                            if (D != null && D.size() > 0) {
                                size = D.size();
                                i3 = 1;
                                while (true) {
                                    i4 = size - i3;
                                    if (i4 >= 0) {
                                        PostData postData = D.get(i4);
                                        if (postData != null) {
                                            String E = postData.E();
                                            this.f19893g = E;
                                            if (StringUtils.isNull(E)) {
                                            }
                                        }
                                        i3++;
                                    }
                                }
                                if (this.o == 2) {
                                    pbPageRequestMessage.set_pn(Integer.valueOf(this.v + 1));
                                }
                            }
                            if (this.f19893g == null && this.f19893g.length() > 0) {
                                pbPageRequestMessage.set_pid(d.a.c.e.m.b.f(this.f19893g, 0L));
                                if (this.o == 2) {
                                    pbPageRequestMessage.set_pid(0L);
                                }
                            } else if (this.o == 1) {
                                pbPageRequestMessage.set_last(1);
                            }
                        }
                        L1(pbPageRequestMessage);
                        break;
                    }
                    if (!this.C) {
                    }
                    if (D != null) {
                        size = D.size();
                        i3 = 1;
                        while (true) {
                            i4 = size - i3;
                            if (i4 >= 0) {
                            }
                            i3++;
                        }
                        if (this.o == 2) {
                        }
                    }
                    if (this.f19893g == null) {
                    }
                    if (this.o == 1) {
                    }
                    L1(pbPageRequestMessage);
                case 2:
                    if (D != null && D.size() > 0 && D.get(0) != null) {
                        this.f19893g = D.get(0).E();
                    }
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_banner(0);
                    if (this.C) {
                        if (b1()) {
                            if (this.w - 1 > 0) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.w - 1));
                            }
                        } else if (this.v < this.x) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.v + 1));
                        }
                    }
                    if (this.f19893g != null && this.f19893g.length() > 0) {
                        pbPageRequestMessage.set_pid(d.a.c.e.m.b.f(this.f19893g, 0L));
                        if (this.o == 2) {
                            pbPageRequestMessage.set_pid(0L);
                        }
                    }
                    L1(pbPageRequestMessage);
                    break;
                case 3:
                    if (!this.C && !this.l) {
                        pbPageRequestMessage.set_banner(1);
                        pbPageRequestMessage.set_back(0);
                        if (!b1()) {
                            pbPageRequestMessage.set_pn(1);
                        } else {
                            pbPageRequestMessage.set_last(1);
                            if (this.x > 0) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.x));
                            }
                        }
                        if (this.C) {
                            pbPageRequestMessage.set_st_type("store_thread");
                        }
                        P1(pbPageRequestMessage);
                        break;
                    }
                    pbPageRequestMessage.set_banner(0);
                    pbPageRequestMessage.set_back(0);
                    if (!b1()) {
                    }
                    if (this.C) {
                    }
                    P1(pbPageRequestMessage);
                    break;
                case 4:
                    pbPageRequestMessage.set_st_type("store_thread");
                    pbPageRequestMessage.set_mark(1);
                    pbPageRequestMessage.set_pid(d.a.c.e.m.b.f(this.f19893g, 0L));
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_banner(0);
                    L1(pbPageRequestMessage);
                    break;
                case 5:
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.set_pn(Integer.valueOf(this.u));
                    pbPageRequestMessage.set_banner(0);
                    L1(pbPageRequestMessage);
                    break;
                case 6:
                    pbPageRequestMessage.set_mark(1);
                    if (this.o == 1 && this.x0 && !this.l) {
                        pbPageRequestMessage.set_pid(0L);
                    } else {
                        pbPageRequestMessage.set_pid(d.a.c.e.m.b.f(this.f19893g, 0L));
                        if (this.o == 2) {
                            pbPageRequestMessage.set_pid(0L);
                        }
                    }
                    pbPageRequestMessage.set_back(0);
                    if (this.l) {
                        pbPageRequestMessage.set_banner(0);
                    } else {
                        pbPageRequestMessage.set_banner(1);
                    }
                    L1(pbPageRequestMessage);
                    break;
                case 7:
                    pbPageRequestMessage.set_back(0);
                    pbPageRequestMessage.setIsJumpFloor(true);
                    pbPageRequestMessage.setJumpFloorNum(this.k0);
                    L1(pbPageRequestMessage);
                    break;
                case 8:
                    pbPageRequestMessage.set_pid(d.a.c.e.m.b.f(this.z0, 0L));
                    if (this.o == 1) {
                        pbPageRequestMessage.set_arround(1);
                        pbPageRequestMessage.set_back(1);
                        pbPageRequestMessage.set_pn(0);
                        pbPageRequestMessage.set_rn(2);
                        break;
                    }
                    break;
            }
            this.x0 = this.l;
            pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.C));
            pbPageRequestMessage.setCacheKey(Y());
            pbPageRequestMessage.setContext(this.Q);
            pbPageRequestMessage.setObjParam1(String.valueOf(this.y0));
            pbPageRequestMessage.setIsSubPostDataReverse(this.j0);
            pbPageRequestMessage.setFromSmartFrs(this.m0 ? 1 : 0);
            if (UtilHelper.isUgcThreadType(this.R0)) {
                pbPageRequestMessage.setForumId(String.valueOf(0));
            } else {
                pbPageRequestMessage.setForumId(this.f19894h);
            }
            pbPageRequestMessage.setNeedRepostRecommendForum(this.k);
            if (this.y0 == 7) {
                pbPageRequestMessage.setFrom_push(1);
            } else {
                pbPageRequestMessage.setFrom_push(0);
            }
            if (this.y0 != 7 && this.y0 != 5 && !this.a1) {
                pbPageRequestMessage.setSourceType(2);
                pbPageRequestMessage.setOriUgcNid(this.P0);
                pbPageRequestMessage.setOriUgcTid(this.Q0);
                pbPageRequestMessage.setOriUgcType(this.R0);
                pbPageRequestMessage.setOriUgcVid(this.S0);
                if (!StringUtils.isNull(this.Z0)) {
                    pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.Z0));
                }
                if (pbPageRequestMessage.getPn() != null) {
                    if (pbPageRequestMessage.getR().intValue() == 1) {
                        i5 = pbPageRequestMessage.getPn().intValue() == this.x ? -1 : P();
                    } else {
                        if (pbPageRequestMessage.getPn().intValue() != 1) {
                            i5 = P();
                        }
                    }
                }
                pbPageRequestMessage.setAfterAdThreadCount(i5);
                pbPageRequestMessage.setTag(this.unique_id);
                pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.f19891e);
                pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                sendMessage(pbPageRequestMessage);
                return true;
            }
            pbPageRequestMessage.setSourceType(1);
            pbPageRequestMessage.setOriUgcNid(this.P0);
            pbPageRequestMessage.setOriUgcTid(this.Q0);
            pbPageRequestMessage.setOriUgcType(this.R0);
            pbPageRequestMessage.setOriUgcVid(this.S0);
            if (!StringUtils.isNull(this.Z0)) {
            }
            if (pbPageRequestMessage.getPn() != null) {
            }
            pbPageRequestMessage.setAfterAdThreadCount(i5);
            pbPageRequestMessage.setTag(this.unique_id);
            pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.f19891e);
            pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
            sendMessage(pbPageRequestMessage);
            return true;
        }
        this.isLoading = false;
        return false;
    }

    public String G0() {
        return this.T0;
    }

    public final void G1(String str, boolean z, String str2, int i2) {
        PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = new PbPageReadLocalRequestMessage();
        pbPageReadLocalRequestMessage.setCacheKey(str);
        pbPageReadLocalRequestMessage.setContext(this.Q);
        pbPageReadLocalRequestMessage.setMarkCache(z);
        pbPageReadLocalRequestMessage.setPostId(str2);
        pbPageReadLocalRequestMessage.setUpdateType(i2);
        sendMessage(pbPageReadLocalRequestMessage);
    }

    public void H(z0 z0Var) {
        if (z0Var == null) {
            C1(1);
            return;
        }
        if (this.v < z0Var.a()) {
            this.v = z0Var.a();
        }
        if (this.w > z0Var.a()) {
            this.w = z0Var.a();
        }
        this.x = z0Var.h();
    }

    public int H0() {
        d.a.j0.d2.h.e eVar = this.I;
        if (eVar != null) {
            return eVar.I();
        }
        return 1;
    }

    public void H1(int i2, int i3) {
        this.C0 = i2;
        this.D0 = i3;
    }

    public final void I(d.a.j0.d2.h.e eVar) {
        if (eVar == null || eVar.x() == null || eVar.x().D0() == null || eVar.x().D0().goods == null || !eVar.x().I0() || eVar.x().D0().goods.goods_style == 1001) {
            return;
        }
        this.N0 = eVar.x();
    }

    public int I0() {
        return this.J;
    }

    public void I1(String str) {
        this.h0 = str;
    }

    public void J() {
        this.N0 = null;
    }

    public boolean J0() {
        return b1();
    }

    public void J1(int i2) {
        this.r = i2;
    }

    public void K(String str) {
        if ((!this.l || f1(TbadkCoreApplication.getCurrentAccount())) && this.I.D() != null) {
            this.I.w().l(1);
            if (this.I.w().b() == 0) {
                this.I.w().l(1);
            }
            this.z0 = str;
            F1(8);
        }
    }

    public int K0() {
        return this.o;
    }

    public void K1(int i2) {
        this.s = i2;
    }

    public void L(d.a.j0.d2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        if (this.N || this.L || this.M) {
            eVar = S1(eVar);
        }
        y1(eVar);
    }

    public int L0() {
        return this.o;
    }

    public final void L1(PbPageRequestMessage pbPageRequestMessage) {
        if (TextUtils.isEmpty(a0()) || w.p().b() == null) {
            return;
        }
        pbPageRequestMessage.setLoadCount(w.p().b().e(a0(), true) + 1);
        pbPageRequestMessage.setRefreshCount(w.p().b().d(a0(), true));
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        if (this.f19891e == null) {
            return false;
        }
        cancelLoadData();
        if (this.Z == null) {
            d.a.j0.d3.j0.b bVar = new d.a.j0.d3.j0.b("pbStat");
            this.Z = bVar;
            bVar.f();
        }
        boolean F1 = F1(3);
        if (this.S != null) {
            this.S = null;
            this.U = null;
            this.T = null;
        }
        return F1;
    }

    public d.a.j0.d2.h.e M(a2 a2Var) {
        d.a.j0.d2.h.e eVar = new d.a.j0.d2.h.e();
        eVar.k0(3);
        if (a2Var == null) {
            return null;
        }
        eVar.v0(a2Var);
        if (a2Var.h0() != null) {
            eVar.l0(a2Var.h0());
            ForumData l = eVar.l();
            l.setId(a2Var.h0().h());
            l.setName(a2Var.h0().g());
            l.setUser_level(a2Var.h0().b());
            l.setImage_url(a2Var.h0().a());
            l.setPost_num(a2Var.h0().f49301h);
            l.setMember_num(a2Var.h0().f49302i);
        } else {
            ForumData l2 = eVar.l();
            l2.setId(String.valueOf(a2Var.c0()));
            l2.setName(a2Var.i0());
        }
        PostData postData = new PostData();
        postData.i0(1);
        postData.w0(a2Var.Z());
        postData.g0(a2Var.T());
        MetaData T = a2Var.T();
        HashMap<String, MetaData> hashMap = new HashMap<>();
        hashMap.put(T.getUserId(), T);
        postData.y0(hashMap);
        postData.t0(TbRichTextView.T(this.Q, a2Var.e0(), O0(), false));
        eVar.m0(postData);
        eVar.D().add(postData);
        eVar.t0(new p(a2Var, null));
        eVar.m = true;
        eVar.p0(1);
        return eVar;
    }

    public boolean M0() {
        return b1();
    }

    public void M1(g gVar) {
        this.R = gVar;
    }

    public String N() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.f19891e);
        if (!this.E) {
            sb.append(this.f19893g);
        }
        sb.append(this.l);
        sb.append(this.n);
        sb.append(this.o);
        sb.append(this.mStType);
        sb.append(this.r);
        sb.append(this.s);
        sb.append(this.t);
        sb.append(this.A);
        sb.append(this.B);
        sb.append(this.C);
        sb.append(this.y);
        sb.append(this.z);
        sb.append(this.G);
        sb.append(this.F);
        sb.append(this.H);
        sb.append(this.K);
        sb.append(this.L);
        sb.append(this.M);
        sb.append(this.N);
        sb.append(this.P0);
        sb.append(this.Q0);
        sb.append(this.S0);
        sb.append(this.R0);
        String str = this.V;
        if (str != null) {
            sb.append(str);
        }
        return sb.toString();
    }

    public int N0() {
        return this.L0;
    }

    public void N1(int i2) {
        this.y0 = i2;
    }

    public AddExperiencedModel O() {
        return this.u0;
    }

    public String O0() {
        return this.f19891e;
    }

    public void O1(String str) {
        this.M0 = str;
    }

    public final int P() {
        int i2 = 0;
        if (y0().D() == null) {
            return 0;
        }
        ArrayList<PostData> D = y0().D();
        for (int size = D.size() - 1; size >= 0; size--) {
            PostData postData = D.get(size);
            if (!(postData instanceof o)) {
                i2++;
            } else if (postData.getType() != AdvertAppInfo.i4) {
                return i2;
            }
        }
        return D.size();
    }

    public String P0() {
        if (!StringUtils.isNull(this.f19891e) && !"0".equals(this.f19891e)) {
            return this.f19891e;
        }
        return this.P0;
    }

    public final void P1(PbPageRequestMessage pbPageRequestMessage) {
        if (TextUtils.isEmpty(a0()) || w.p().b() == null) {
            return;
        }
        pbPageRequestMessage.setRefreshCount(w.p().b().d(a0(), true) + 1);
        pbPageRequestMessage.setLoadCount(w.p().b().e(a0(), true));
    }

    public d.a.j0.d2.h.c Q() {
        return this.o0;
    }

    public PostData Q0() {
        return this.A0;
    }

    public void Q1(int i2) {
        d.a.j0.d2.h.e eVar = this.I;
        if (eVar != null) {
            eVar.u0(i2);
        }
    }

    public MarkData R(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        d.a.j0.d2.h.e eVar = this.I;
        if (eVar == null) {
            return null;
        }
        ArrayList<PostData> D = eVar.D();
        if (ListUtils.isEmpty(D)) {
            return null;
        }
        if (D.size() > 0 && i2 >= D.size()) {
            i2 = D.size() - 1;
        }
        return s0(D.get(i2));
    }

    public PostData R0() {
        return this.B0;
    }

    public boolean R1(int i2) {
        this.u = i2;
        if (i2 > this.I.w().h()) {
            this.u = this.I.w().h();
        }
        if (this.u < 1) {
            this.u = 1;
        }
        if (this.f19891e == null) {
            return false;
        }
        return F1(5);
    }

    public Rect S() {
        Rect rect = this.K0;
        this.K0 = null;
        return rect;
    }

    public String S0() {
        return this.f19893g;
    }

    public d.a.j0.d2.h.e S1(d.a.j0.d2.h.e eVar) {
        if (eVar == null) {
            return null;
        }
        a2 L = eVar.L();
        L.L3(this.r);
        L.M3(this.s);
        long j = this.t;
        if (j > 0) {
            L.Q3(j);
        }
        return eVar;
    }

    public BaijiahaoData T() {
        d.a.j0.d2.h.e eVar = this.I;
        if (eVar == null || eVar.L() == null) {
            return null;
        }
        return this.I.L().V();
    }

    public boolean T0() {
        d.a.j0.d2.h.e eVar = this.I;
        return (eVar == null || eVar.l() == null || this.I.L() == null) ? false : true;
    }

    public void T1(boolean z) {
        d.a.j0.d2.h.e eVar = this.I;
        if (eVar != null) {
            eVar.o0(z);
        }
    }

    public o U() {
        return this.N0;
    }

    public final boolean U0() {
        return (this.I.x() == null || this.I.x().D0() == null || this.I.x().D0().goods != null || this.I.x().D0().goods.goods_style == 1001) ? false : true;
    }

    public boolean U1() {
        if (b1() && this.I.w().b() == 0) {
            h1(true);
            return true;
        }
        return false;
    }

    public CheckRealNameModel V() {
        return this.t0;
    }

    public void V0() {
        k.b().d(Y(), this.C);
    }

    public boolean V1(String str) {
        this.l = !this.l;
        this.f19893g = str;
        TiebaStatic.log(new StatisticItem("pb_onlyowner_click").param("obj_source", 0));
        if (F1(6)) {
            return true;
        }
        this.l = !this.l;
        return false;
    }

    public q W() {
        return this.q0;
    }

    public boolean W0() {
        return this.l0;
    }

    public boolean W1(boolean z, String str) {
        if (this.l == z) {
            return false;
        }
        this.l = z;
        this.f19893g = str;
        if (this.o == 2) {
            this.f19893g = "";
        }
        if (z) {
            TiebaStatic.log(new StatisticItem("pb_onlyowner_click").param("obj_source", 1));
        }
        if (F1(6)) {
            return true;
        }
        this.l = !z;
        return false;
    }

    public MarkData X() {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.f19891e);
        markData.setPostId(this.I.t());
        markData.setTime(date.getTime());
        markData.setHostMode(this.l);
        markData.setSequence(Boolean.valueOf(b1()));
        markData.setId(this.f19891e);
        return markData;
    }

    public boolean X0() {
        return this.m0;
    }

    public boolean X1(int i2) {
        if (i2 == this.o) {
            return false;
        }
        if (i2 != 1) {
            d.a.i0.r.d0.b.j().v("key_pb_current_sort_type", i2);
        }
        boolean z = this.n;
        this.m = z;
        this.p = this.o;
        this.o = i2;
        this.n = !z;
        if (i2 == 2 && this.C) {
            this.f19893g = "0";
        }
        if (this.isLoading || !LoadData()) {
            this.n = !this.n;
            this.o = this.p;
            return false;
        }
        return true;
    }

    public final String Y() {
        String str = this.f19891e;
        String v0 = (str == null || str.equals("0")) ? v0() : this.f19891e;
        if (this.l) {
            v0 = v0 + DB_KEY_HOST;
        }
        int i2 = this.o;
        if (i2 == 1) {
            v0 = v0 + DB_KEY_REVER;
        } else if (i2 == 2) {
            v0 = v0 + DB_KEY_HOT;
        }
        if (TbadkCoreApplication.getCurrentAccount() != null) {
            return v0 + TbadkCoreApplication.getCurrentAccount();
        }
        return v0;
    }

    public boolean Y0() {
        return this.Y0;
    }

    public final void Y1(@NonNull d.a.j0.d2.h.e eVar) {
        d.a.j0.d2.h.e eVar2 = this.I;
        if (eVar2 != null) {
            eVar2.e().clear();
            this.I.e().addAll(eVar.e());
        }
    }

    public String Z() {
        return this.h0;
    }

    public boolean Z0() {
        return this.Y;
    }

    public void Z1(n nVar) {
        d.a.j0.d2.h.e eVar;
        if (nVar == null || (eVar = this.I) == null || eVar.D() == null || this.I.D().size() <= 0) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        int size = this.I.D().size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.I.D().get(i2) != null && this.I.D().get(i2).t() != null && currentAccount.equals(this.I.D().get(i2).t().getUserId()) && this.I.D().get(i2).t().getPendantData() != null) {
                this.I.D().get(i2).t().getPendantData().d(nVar.a());
                this.I.D().get(i2).t().getPendantData().e(nVar.b());
            }
        }
    }

    public String a0() {
        return this.H;
    }

    public boolean a1() {
        return this.O0 && d.a.j0.q0.l.b() != null && d.a.j0.q0.l.b().equals(this.f19891e) && d.a.j0.q0.l.a() != null;
    }

    public void a2(d.a.j0.d2.h.e eVar, ArrayList<PostData> arrayList) {
        String p0;
        if (arrayList == null || eVar.D() == null) {
            return;
        }
        PostData postData = (PostData) ListUtils.getItem(eVar.D(), 0);
        if (postData != null && (p0 = p0(arrayList)) != null && p0.equals(postData.E())) {
            eVar.D().remove(postData);
        }
        this.I.X = arrayList.size();
        arrayList.addAll(eVar.D());
    }

    public String b0() {
        return this.j;
    }

    public final boolean b1() {
        int i2 = this.o;
        return i2 == 0 || i2 == 2;
    }

    public final void b2(d.a.j0.d2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        eVar.x0(this.I.U());
        d.a.j0.d2.h.e eVar2 = this.I;
        if (!eVar2.V && eVar.V && eVar2.i() != null) {
            eVar.n0(this.I.i());
        }
        this.I = eVar;
        C1(eVar.w().a());
    }

    public MetaData c0() {
        d.a.j0.d2.h.e eVar = this.I;
        if (eVar == null || eVar.L() == null || this.I.L().T() == null) {
            return null;
        }
        return this.I.L().T();
    }

    public boolean c1() {
        return y0() != null && y0().g0();
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        this.isLoading = false;
        return true;
    }

    public boolean d0() {
        return this.l;
    }

    public boolean d1() {
        int i2 = this.y0;
        return i2 == 13 || i2 == 12 || i2 == 7 || i2 == 23 || i2 == 24;
    }

    public void destory() {
        cancelLoadData();
        MessageManager.getInstance().unRegisterListener(this.unique_id);
        SuggestEmotionModel suggestEmotionModel = this.v0;
        if (suggestEmotionModel != null) {
            suggestEmotionModel.cancelLoadData();
        }
        GetSugMatchWordsModel getSugMatchWordsModel = this.w0;
        if (getSugMatchWordsModel != null) {
            getSugMatchWordsModel.cancelLoadData();
        }
        d.a.j0.s2.h0.b.f().a("PB");
        o1();
    }

    public boolean e0() {
        return this.A;
    }

    public boolean e1() {
        return x0() == 3 || y0() == null || y0().L() == null || !y0().L().l2();
    }

    public boolean f0() {
        return this.O;
    }

    public boolean f1(String str) {
        if (y0() != null && y0().L() != null && y0().L().T() != null && !StringUtils.isNull(str)) {
            String userId = y0().L().T().getUserId();
            if (!StringUtils.isNull(userId) && userId.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean g0() {
        return "hot_topic".equals(this.mStType);
    }

    public void g1(ForumData forumData, SuggestEmotionModel.c cVar) {
        String str;
        String str2;
        str = "";
        if (forumData != null) {
            String id = !TextUtils.isEmpty(forumData.getId()) ? forumData.getId() : "";
            str2 = TextUtils.isEmpty(forumData.getName()) ? "" : forumData.getName();
            str = id;
        } else {
            str2 = "";
        }
        this.v0.v(str, str2, cVar);
    }

    public int getErrorNo() {
        return this.n0;
    }

    public String getForumId() {
        return this.f19894h;
    }

    public String getFromForumId() {
        return this.f19895i;
    }

    public boolean h0() {
        return this.B;
    }

    public boolean h1(boolean z) {
        d.a.j0.d2.h.e eVar;
        if (this.f19891e == null || (eVar = this.I) == null) {
            return false;
        }
        if (z || eVar.w().b() != 0) {
            return F1(1);
        }
        return false;
    }

    public boolean i0() {
        return this.C;
    }

    public void i1(d.a.j0.d2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f19891e = eVar.N();
        if (eVar.L() != null && eVar.L().V() != null) {
            BaijiahaoData V = eVar.L().V();
            this.P0 = V.oriUgcNid;
            this.Q0 = V.oriUgcTid;
            this.R0 = V.oriUgcType;
            this.S0 = V.oriUgcVid;
        } else {
            this.P0 = null;
            this.Q0 = null;
            this.R0 = 0;
            this.S0 = null;
        }
        this.f19893g = null;
        this.l = false;
        this.n = true;
        LoadData();
    }

    public void initWithBundle(Bundle bundle) {
        this.y0 = bundle.getInt("key_start_from", 0);
        this.f19891e = bundle.getString("thread_id");
        this.f19893g = bundle.getString("post_id");
        this.f19894h = bundle.getString("forum_id");
        this.f19895i = bundle.getString("from_forum_id");
        bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.k = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.l = bundle.getBoolean("host_only", false);
        this.n = bundle.getBoolean("squence", true);
        this.o = bundle.getInt("sort_type", 0);
        this.mStType = bundle.getString("st_type");
        this.P = bundle.getString("locate");
        this.r = bundle.getInt("is_good", 0);
        this.s = bundle.getInt("is_top", 0);
        this.t = bundle.getLong("thread_time");
        this.C = bundle.getBoolean("from_mark", false);
        this.E = bundle.getBoolean("is_pb_key_need_post_id", false);
        this.y = bundle.getBoolean("is_ad", false);
        this.z = bundle.getBoolean("is_sub_pb", false);
        this.G = bundle.getBoolean("is_pv", false);
        this.F = bundle.getLong("msg_id", 0L);
        this.H = bundle.getString("from_forum_name");
        this.V = bundle.getString("extra_pb_cache_key");
        this.L = bundle.getBoolean("is_from_thread_config", false);
        this.M = bundle.getBoolean("is_from_interview_live_config", false);
        this.N = bundle.getBoolean("is_from_my_god_config", false);
        this.X = bundle.getInt("extra_pb_is_attention_key", -1);
        this.W = bundle.getInt("extra_pb_funs_count_key", -1);
        this.A = bundle.getBoolean("from_frs", false);
        this.B = bundle.getBoolean("from_maintab", false);
        this.m0 = bundle.getBoolean("from_smart_frs", false);
        this.O = bundle.getBoolean("from_hottopic", false);
        this.E0 = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.j = bundle.getString("high_light_post_id");
        this.P0 = bundle.getString("key_ori_ugc_nid");
        this.Q0 = bundle.getString("key_ori_ugc_tid");
        this.R0 = bundle.getInt("key_ori_ugc_type", 0);
        this.Y0 = bundle.getBoolean("key_jump_to_comment_area", false);
        this.S0 = bundle.getString("key_ori_ugc_vid");
        this.Y = bundle.getInt("request_code", -1) == 18003;
        this.T0 = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
        this.U0 = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
        this.V0 = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
        this.W0 = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
    }

    public void initWithIntent(Intent intent) {
        if (intent == null) {
            return;
        }
        this.f19891e = intent.getStringExtra("thread_id");
        this.f19892f = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
        this.P0 = intent.getStringExtra("key_ori_ugc_nid");
        this.Q0 = intent.getStringExtra("key_ori_ugc_tid");
        this.R0 = intent.getIntExtra("key_ori_ugc_type", 0);
        this.S0 = intent.getStringExtra("key_ori_ugc_vid");
        this.Y0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
        this.Z0 = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        this.X0 = uri != null ? uri.toString() : null;
        this.a1 = false;
        if (d.a.i0.a.f.c(uri)) {
            this.a1 = true;
            d.a.i0.a.f.b().f(uri, this.b1);
        } else if (StringUtils.isNull(this.f19891e)) {
            this.a1 = true;
            this.p0.b(intent, this.b1);
            if (uri != null) {
                if (StringUtils.isNull(this.f19891e)) {
                    this.f19891e = uri.getQueryParameter("thread_id");
                }
                if (StringUtils.isNull(this.P0)) {
                    this.P0 = uri.getQueryParameter("key_ori_ugc_nid");
                }
                if (StringUtils.isNull(this.Q0)) {
                    this.Q0 = uri.getQueryParameter("key_ori_ugc_tid");
                }
                if (this.R0 == 0) {
                    this.R0 = d.a.c.e.m.b.d(uri.getQueryParameter("key_ori_ugc_type"), 0);
                }
                if (StringUtils.isNull(this.S0)) {
                    this.S0 = uri.getQueryParameter("key_ori_ugc_vid");
                }
            }
        }
        if (d.a.c.e.p.k.isEmpty(this.f19891e)) {
            this.f19891e = "0";
        }
        int intExtra = intent.getIntExtra("key_start_from", 0);
        this.y0 = intExtra;
        if (intExtra == 0) {
            this.y0 = this.p0.f52265a;
        }
        this.f19893g = intent.getStringExtra("post_id");
        this.f19894h = intent.getStringExtra("forum_id");
        this.f19895i = intent.getStringExtra("from_forum_id");
        intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.k = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.l = intent.getBooleanExtra("host_only", false);
        this.n = intent.getBooleanExtra("squence", true);
        int intExtra2 = intent.getIntExtra("sort_type", -1);
        this.o = intExtra2;
        if (intExtra2 < 0) {
            intExtra2 = d.a.i0.r.d0.b.j().k("key_pb_current_sort_type", 2);
        }
        this.o = intExtra2;
        this.f19893g = intExtra2 != 2 ? this.f19893g : "0";
        this.mStType = intent.getStringExtra("st_type");
        this.P = intent.getStringExtra("locate");
        this.r = intent.getIntExtra("is_good", 0);
        this.s = intent.getIntExtra("is_top", 0);
        this.t = intent.getLongExtra("thread_time", 0L);
        this.C = intent.getBooleanExtra("from_mark", false);
        this.D = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
        this.E = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.y = intent.getBooleanExtra("is_ad", false);
        this.z = intent.getBooleanExtra("is_sub_pb", false);
        this.G = intent.getBooleanExtra("is_pv", false);
        this.F = intent.getLongExtra("msg_id", 0L);
        this.H = intent.getStringExtra("from_forum_name");
        this.V = intent.getStringExtra("extra_pb_cache_key");
        this.S = intent.getStringExtra("op_type");
        this.T = intent.getStringExtra("op_url");
        this.U = intent.getStringExtra("op_stat");
        this.L = intent.getBooleanExtra("is_from_thread_config", false);
        this.M = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.N = intent.getBooleanExtra("is_from_my_god_config", false);
        this.X = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.W = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.A = intent.getBooleanExtra("from_frs", false);
        this.B = intent.getBooleanExtra("from_maintab", false);
        this.m0 = intent.getBooleanExtra("from_smart_frs", false);
        this.O = intent.getBooleanExtra("from_hottopic", false);
        this.s0 = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.E0 = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.j = intent.getStringExtra("high_light_post_id");
        this.O0 = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
        this.Y = intent.getIntExtra("request_code", -1) == 18003;
        this.T0 = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
        this.U0 = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
        this.V0 = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
        this.W0 = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
    }

    public boolean isPrivacy() {
        return this.f19892f;
    }

    public boolean isShareThread() {
        return this.E0;
    }

    public int j0() {
        return this.r;
    }

    public void j1(String str) {
        if (StringUtils.isNull(str)) {
            return;
        }
        this.f19891e = str;
        this.f19893g = null;
        this.l = false;
        this.n = true;
        LoadData();
    }

    public boolean k0() {
        d.a.j0.d2.h.e eVar = this.I;
        if (eVar == null) {
            return false;
        }
        return eVar.r();
    }

    public boolean k1() {
        if (this.f19891e == null || this.f19893g == null) {
            return false;
        }
        cancelMessage();
        if (this.C) {
            return F1(4);
        }
        return F1(6);
    }

    public boolean l0() {
        return this.q;
    }

    public boolean l1(boolean z) {
        d.a.j0.d2.h.e eVar;
        if (this.f19891e == null || (eVar = this.I) == null || ((!z && eVar.w().c() == 0) || this.I.D() == null || this.I.D().size() < 1)) {
            return false;
        }
        return F1(2);
    }

    public boolean m0() {
        return this.z;
    }

    public void m1(GetSugMatchWordsModel.b bVar) {
        if (bVar == null) {
            return;
        }
        if (this.w0 == null) {
            this.w0 = new GetSugMatchWordsModel(this.a0.getPageContext());
        }
        this.w0.u(bVar);
    }

    public int n0() {
        return this.s;
    }

    public boolean n1() {
        String str = this.f19893g;
        if (str != null && !str.equals("0") && this.f19893g.length() != 0) {
            return k1();
        }
        return LoadData();
    }

    public boolean o0() {
        d.a.j0.d2.h.e eVar = this.I;
        if (eVar == null) {
            return false;
        }
        return eVar.e0();
    }

    public final void o1() {
        d.a.j0.d3.j0.b bVar = this.Z;
        if (bVar != null) {
            bVar.a();
            this.Z = null;
        }
    }

    public final String p0(ArrayList<PostData> arrayList) {
        int count = ListUtils.getCount(arrayList);
        if (count <= 0) {
            return null;
        }
        for (int i2 = count - 1; i2 >= 0; i2--) {
            PostData postData = (PostData) ListUtils.getItem(arrayList, i2);
            if (postData != null && !StringUtils.isNull(postData.E())) {
                return postData.E();
            }
        }
        return null;
    }

    public void p1() {
        if (!"personalize_page".equals(this.mStType) || this.I == null || this.i0 == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        TiebaStatic.log(new StatisticItem("c10754").param("fid", this.I.m()).param("tid", this.f19891e).param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(currentTimeMillis - this.i0)).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
        this.i0 = 0L;
    }

    public int q0() {
        return this.D0;
    }

    public void q1() {
        if ("personalize_page".equals(this.mStType)) {
            this.i0 = System.currentTimeMillis() / 1000;
        }
    }

    public int r0() {
        return this.C0;
    }

    public void r1(d.a.j0.d2.h.e eVar, int i2, String str) {
        this.f0 = true;
        if (eVar == null || eVar.f52022h != null) {
            return;
        }
        b2(eVar);
        L(eVar);
        if (eVar.L() != null) {
            eVar.L().s3(0);
        }
        g gVar = this.R;
        if (gVar == null || eVar == null) {
            return;
        }
        gVar.c(true, 0, i2, 0, eVar, str, 0);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String s() {
        return this.g0;
    }

    public MarkData s0(PostData postData) {
        MarkData markData = new MarkData();
        Date date = new Date();
        markData.setAccount(TbadkCoreApplication.getCurrentAccount());
        markData.setThreadId(this.f19891e);
        markData.setPostId(postData.E());
        markData.setTime(date.getTime());
        markData.setHostMode(this.l);
        markData.setSequence(Boolean.valueOf(b1()));
        markData.setId(this.f19891e);
        markData.setFloor(postData.A());
        markData.setForumId(this.f19894h);
        if (postData instanceof o) {
            markData.setApp(((o) postData).H0());
        }
        return markData;
    }

    public void s1(int i2) {
        x1(i2);
        ArrayList<PostData> D = this.I.D();
        boolean z = false;
        this.e0 = false;
        if (i2 != 1) {
            if (i2 == 2) {
                while (D.size() + 30 > d.a.i0.t.e.a()) {
                    D.remove(D.size() - 1);
                    z = true;
                }
                if (z) {
                    this.I.w().l(1);
                    return;
                }
                return;
            }
            return;
        }
        boolean z2 = false;
        while (D.size() + 30 > d.a.i0.t.e.a()) {
            D.remove(0);
            z2 = true;
        }
        if (z2) {
            this.I.w().m(1);
            g gVar = this.R;
            if (gVar != null) {
                gVar.b(this.I);
            }
        }
        this.d0 = System.currentTimeMillis();
        this.e0 = true;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData t(String str) {
        d.a.j0.d2.h.e eVar = this.I;
        if (eVar == null || eVar.L() == null || this.I.l() == null) {
            return null;
        }
        WriteData writeData = new WriteData();
        if (this.I.L().l2()) {
            writeData.setForumId("0");
            writeData.setForumName("");
        } else {
            writeData.setForumId(this.I.l().getId());
            writeData.setForumName(this.I.l().getName());
        }
        writeData.setFromForumId(this.f19895i);
        writeData.sourceFrom = String.valueOf(this.y0);
        writeData.setThreadId(this.f19891e);
        writeData.setIsAd(this.y);
        if (str == null) {
            writeData.setType(1);
        } else {
            writeData.setType(2);
            writeData.setFloor(str);
            writeData.setFloorNum(0);
        }
        return writeData;
    }

    public String t0() {
        d.a.j0.d2.h.e eVar = this.I;
        if (eVar == null || !eVar.r()) {
            return null;
        }
        return this.I.t();
    }

    public void t1(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        int downSize = pbpagehttpresponsemessage.getDownSize();
        long costTime = pbpagehttpresponsemessage.getCostTime();
        if (pbpagehttpresponsemessage.getError() == 4) {
            this.o0 = pbpagehttpresponsemessage.getAppealInfo();
        }
        v1(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, downSize, costTime, 0L);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean u() {
        return n1();
    }

    public e0 u0() {
        return this.r0;
    }

    public void u1(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        int downSize = pbpagesocketresponsemessage.getDownSize();
        long costTime = pbpagesocketresponsemessage.getCostTime();
        if (pbpagesocketresponsemessage.getError() == 4) {
            this.o0 = pbpagesocketresponsemessage.getAppealInfo();
        }
        v1(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, downSize, 0L, costTime);
    }

    public final String v0() {
        String str = "";
        if (this.P0 != null) {
            str = "" + this.P0;
        }
        if (this.Q0 != null) {
            str = str + this.Q0;
        }
        String str2 = str + this.R0;
        if (this.S0 != null) {
            return str2 + this.S0;
        }
        return str2;
    }

    public void v1(d.a.j0.d2.h.e eVar, int i2, boolean z, int i3, String str, boolean z2, int i4, long j, long j2) {
        d.a.j0.d2.h.e eVar2;
        int i5;
        if (z) {
            i5 = i3;
            eVar2 = null;
        } else {
            eVar2 = eVar;
            i5 = i3;
        }
        this.n0 = i5;
        this.isLoading = false;
        if (eVar2 != null) {
            L(eVar2);
        }
        I(eVar2);
        o oVar = this.N0;
        if (oVar != null && oVar.I0()) {
            TiebaStatic.log(d.a.j0.c3.a.h("a005", "common_fill", true, 1));
        }
        w1(eVar2, i2, z, i3, str, z2, i4, j, j2, false);
    }

    public z0 w0() {
        d.a.j0.d2.h.e eVar = this.I;
        if (eVar == null) {
            return null;
        }
        return eVar.w();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void w1(d.a.j0.d2.h.e eVar, int i2, boolean z, int i3, String str, boolean z2, int i4, long j, long j2, boolean z3) {
        int i5;
        int i6;
        boolean z4 = !z;
        this.l0 = z3;
        d.a.j0.d3.j0.b bVar = this.Z;
        if (bVar != null && !z3) {
            bVar.b(z2, z4, i3, str, i4, j, j2);
            this.Z = null;
        }
        d.a.j0.d2.h.e eVar2 = this.I;
        if (eVar2 != null) {
            eVar2.Y = z3;
            eVar2.Z = i2;
        }
        if (z4 && !z3 && !TextUtils.isEmpty(a0()) && w.p().b() != null) {
            w.p().b().g(a0(), B1(I0()), true);
        }
        if (eVar != null && (this.u != 1 || i2 != 5 || eVar.D() == null || eVar.D().size() >= 1)) {
            this.m = this.n;
            if (i2 != 8) {
                this.p = this.o;
                this.o = eVar.f52021g;
            }
            List<PbSortType> list = eVar.f52020f;
            if (list != null && list.isEmpty()) {
                PbSortType.Builder builder = new PbSortType.Builder();
                builder.sort_name = this.a0.getResources().getString(R.string.default_sort);
                builder.sort_type = 0;
                ArrayList arrayList = new ArrayList();
                eVar.f52020f = arrayList;
                arrayList.add(builder.build(false));
                PbSortType.Builder builder2 = new PbSortType.Builder();
                builder2.sort_name = this.a0.getResources().getString(R.string.view_reverse);
                builder2.sort_type = 1;
                eVar.f52020f.add(builder2.build(false));
                int i7 = this.p;
                this.o = i7;
                eVar.f52021g = i7;
            }
            this.G = false;
            if (eVar.w() != null && (this.o != 2 || i2 != 8)) {
                H(eVar.w());
            }
            int i8 = this.x;
            if (i8 < 1) {
                i8 = 1;
            }
            this.x = i8;
            ArrayList<PostData> D = this.I.D();
            switch (i2) {
                case 1:
                    this.I.r0(eVar.w(), 1);
                    a2(eVar, D);
                    Y1(eVar);
                    i5 = 0;
                    break;
                case 2:
                    if (eVar.D() != null) {
                        i5 = eVar.D().size() + 1;
                        PostData postData = (PostData) ListUtils.getItem(D, 0);
                        PostData postData2 = (PostData) ListUtils.getItem(eVar.D(), ListUtils.getCount(eVar.D()) - 1);
                        if (postData != null && postData2 != null && postData.E().equals(postData2.E())) {
                            eVar.D().remove(postData2);
                            i5--;
                        }
                        D.addAll(0, eVar.D());
                    } else {
                        i5 = 0;
                    }
                    Y1(eVar);
                    this.I.r0(eVar.w(), 2);
                    break;
                case 3:
                    if (this.o == 1 && eVar.w() != null) {
                        eVar.w().k(eVar.w().h());
                    }
                    b2(eVar);
                    i5 = 0;
                    break;
                case 4:
                    b2(eVar);
                    i5 = 0;
                    break;
                case 5:
                    b2(eVar);
                    i5 = 0;
                    break;
                case 6:
                    b2(eVar);
                    i5 = 0;
                    break;
                case 7:
                    b2(eVar);
                    i5 = 0;
                    break;
                case 8:
                    if (eVar == null || ListUtils.isEmpty(eVar.D()) || this.I == null || (this.l && !A1(eVar).equals(eVar.D().get(0).t().getUserId()))) {
                        i6 = 0;
                    } else {
                        if (this.I.w().b() == 0) {
                            this.I.w().l(1);
                        }
                        D1();
                        this.A0 = eVar.D().get(0);
                        if (!b1() && !this.I.a0()) {
                            if (this.C0 - this.D0 >= 3) {
                                PostData postData3 = new PostData();
                                this.B0 = postData3;
                                postData3.D = false;
                                postData3.r0(53);
                                this.I.D().add(0, this.B0);
                            }
                            this.I.D().add(0, this.A0);
                            i6 = 0;
                        } else {
                            if (this.I.D().size() - this.C0 >= 3) {
                                PostData postData4 = new PostData();
                                this.B0 = postData4;
                                postData4.D = true;
                                postData4.r0(53);
                                this.I.D().add(this.B0);
                            }
                            this.I.D().add(this.A0);
                            i6 = this.I.D().size() - 1;
                        }
                        if (!StringHelper.isTaday(d.a.i0.r.d0.b.j().l("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                            this.A0.T = this.I.G();
                            d.a.i0.r.d0.b.j().w("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                        }
                    }
                    Y1(eVar);
                    i5 = i6;
                    break;
                default:
                    i5 = 0;
                    break;
            }
            d.a.j0.d2.h.e eVar3 = this.I;
            if (eVar3 != null && eVar3.L() != null) {
                PraiseData P0 = this.I.L().P0();
                if (this.g1 != null && !P0.isPriaseDataValid()) {
                    this.I.L().Y3(this.g1);
                } else {
                    PraiseData P02 = this.I.L().P0();
                    this.g1 = P02;
                    P02.setPostId(this.I.L().f0());
                }
                if (eVar.w() != null && eVar.w().a() == 1 && eVar.L() != null && eVar.L().E() != null && eVar.L().E().size() > 0) {
                    this.I.L().j3(eVar.L().E());
                }
                this.I.L().Z3(eVar.L().Z0());
                this.I.L().o3(eVar.L().P());
                this.I.L().s3(eVar.L().Y());
                if (this.K == 33) {
                    this.I.L().T().setHadConcerned(eVar.L().T().hadConcerned());
                }
                if (eVar != null && eVar.L() != null) {
                    this.I.L().x4(eVar.L().v0());
                }
            }
            d.a.j0.d2.h.e eVar4 = this.I;
            if (eVar4 != null && eVar4.R() != null && eVar.R() != null) {
                this.I.R().setBimg_end_time(eVar.R().getBimg_end_time());
                this.I.R().setBimg_url(eVar.R().getBimg_url());
            }
            if (eVar.w() != null && eVar.w().a() == 1 && eVar.T() != null) {
                this.I.w0(eVar.T());
            }
            if (this.l0) {
                if (this.I.L() != null && this.I.L().T() != null && this.I.D() != null && ListUtils.getItem(this.I.D(), 0) != null) {
                    PostData postData5 = (PostData) ListUtils.getItem(this.I.D(), 0);
                    MetaData T = this.I.L().T();
                    if (postData5.t() != null && postData5.t().getGodUserData() != null) {
                        int i9 = this.W;
                        if (i9 != -1) {
                            T.setFansNum(i9);
                            postData5.t().setFansNum(this.W);
                        }
                        if (this.X != -1) {
                            T.getGodUserData().setIsLike(this.X == 1);
                            postData5.t().getGodUserData().setIsLike(this.X == 1);
                            T.getGodUserData().setIsFromNetWork(false);
                            postData5.t().getGodUserData().setIsFromNetWork(false);
                        }
                    }
                }
                d.a.j0.d2.h.e eVar5 = this.I;
                eVar5.f52019e = -1;
                eVar5.f52018d = -1;
            }
            g gVar = this.R;
            if (gVar != null) {
                gVar.c(true, getErrorCode(), i2, i5, this.I, this.mErrorString, 1);
            }
        } else if (this.R != null) {
            this.n = this.m;
            if (i3 != 350006) {
                this.o = this.p;
            }
            this.R.c(false, i3, i2, 0, null, str, 1);
        }
        d.a.j0.d2.h.e eVar6 = this.I;
        if (eVar6 == null || eVar6.L() == null || this.I.l() == null || this.I.a0()) {
            return;
        }
        HistoryMessage historyMessage = new HistoryMessage();
        historyMessage.Activity = this.a0.getPageContext();
        historyMessage.threadId = y0().L().o0();
        if (this.E0 && y0().L().r1 != null) {
            historyMessage.threadName = y0().L().r1.f12797b;
        } else {
            historyMessage.threadName = y0().L().x1();
        }
        if (this.E0 && !e1()) {
            historyMessage.forumName = "";
        } else {
            historyMessage.forumName = y0().l().getName();
        }
        historyMessage.isHostOnly = d0();
        historyMessage.isSquence = M0();
        historyMessage.threadType = y0().L().s1();
        historyMessage.isShareThread = this.E0;
        MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
    }

    public int x0() {
        return this.y0;
    }

    public final void x1(int i2) {
        d.a.j0.d2.h.e eVar;
        if (i2 != 8) {
            this.z0 = "";
            if (this.A0 != null) {
                if (i2 == 1 && (eVar = this.I) != null && eVar.a0()) {
                    if (this.B0 != null) {
                        y0().D().remove(this.B0);
                    }
                } else if (i2 == 1 && !this.n && !ListUtils.isEmpty(y0().D())) {
                    y0().D().remove(this.A0);
                    if (this.B0 != null) {
                        y0().D().remove(this.B0);
                    }
                    y0().D().add(0, this.A0);
                } else {
                    y0().D().remove(this.A0);
                    if (this.B0 != null) {
                        y0().D().remove(this.B0);
                    }
                }
            }
            this.B0 = null;
        }
    }

    public d.a.j0.d2.h.e y0() {
        return this.I;
    }

    public void y1(d.a.j0.d2.h.e eVar) {
        if (eVar == null) {
            return;
        }
        String A1 = A1(eVar);
        for (int i2 = 0; i2 < eVar.D().size(); i2++) {
            PostData postData = eVar.D().get(i2);
            for (int i3 = 0; i3 < postData.M().size(); i3++) {
                postData.M().get(i3).z0(this.a0.getPageContext(), A1.equals(postData.M().get(i3).t().getUserId()));
            }
        }
        s Q = eVar.Q();
        if (Q == null || ListUtils.isEmpty(Q.f52071a)) {
            return;
        }
        for (PostData postData2 : Q.f52071a) {
            for (int i4 = 0; i4 < postData2.M().size(); i4++) {
                postData2.M().get(i4).z0(this.a0.getPageContext(), A1.equals(postData2.M().get(i4).t().getUserId()));
            }
        }
    }

    public d.a.j0.d2.h.e z0() {
        o oVar;
        d.a.j0.d2.h.e eVar = this.I;
        if (eVar == null) {
            return eVar;
        }
        if (!U0() && (oVar = this.N0) != null) {
            this.I.s0(oVar);
        }
        return this.I;
    }

    public void z1(d.a.j0.d2.h.e eVar, int i2) {
        if (eVar == null) {
            return;
        }
        String A1 = A1(eVar);
        s Q = eVar.Q();
        if (Q == null || ListUtils.isEmpty(Q.f52071a)) {
            return;
        }
        List<PostData> list = Q.f52071a;
        for (PostData postData : list.subList(i2, list.size())) {
            for (int i3 = 0; i3 < postData.M().size(); i3++) {
                postData.M().get(i3).z0(this.a0.getPageContext(), A1.equals(postData.M().get(i3).t().getUserId()));
            }
        }
    }
}
