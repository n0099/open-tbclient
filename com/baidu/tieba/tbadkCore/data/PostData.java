package com.baidu.tieba.tbadkCore.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import d.a.c.e.p.k;
import d.a.c.j.e.n;
import d.a.c.j.g;
import d.a.j0.b1.m.e;
import d.a.j0.r.q.b1;
import d.a.j0.r.q.w1;
import d.a.j0.t.g;
import d.a.k0.d3.h0.i;
import d.a.k0.d3.h0.l;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes5.dex */
public class PostData implements PreLoadImageProvider, n {
    public static final BdUniqueId o0 = BdUniqueId.gen();
    public static final BdUniqueId p0 = BdUniqueId.gen();
    public static final BdUniqueId q0 = BdUniqueId.gen();
    public static final BdUniqueId r0 = BdUniqueId.gen();
    public static final BdUniqueId s0 = BdUniqueId.gen();
    public static final BdUniqueId t0 = BdUniqueId.gen();
    public static final BdUniqueId u0;
    public static final BdUniqueId v0;
    public static boolean w0;
    public i B;
    public w1 C;
    public boolean D;
    public d.a.j0.b1.m.i F;
    public TbRichTextVoiceInfo G;
    public String I;
    public SkinInfo J;
    public String K;
    public int O;
    public boolean Q;
    public AlaLiveInfoCoreData T;
    public OriginalThreadInfo V;
    public String X;
    public boolean Z;
    public int d0;
    public StatisticItem e0;
    public List<HeadItem> f0;

    /* renamed from: g  reason: collision with root package name */
    public long f20856g;
    public Item g0;
    public List<PbContent> i0;
    @Deprecated
    public String k;
    public Item k0;
    public int l0;
    public d.a.j0.t.a m0;
    public ArrayList<PostData> o;
    public SmallTailInfo t;
    public String w;
    public HashMap<String, MetaData> x;
    public d.a.j0.t.c y;
    public g z;

    /* renamed from: e  reason: collision with root package name */
    public int f20854e = 0;
    public boolean p = false;
    public ArrayList<PostData> q = null;
    public TbRichText r = null;
    public boolean A = false;
    public int E = 0;
    public boolean M = false;
    public boolean N = false;
    public boolean P = true;
    public boolean R = false;
    public boolean S = false;
    public boolean U = false;
    public int W = 0;
    public boolean Y = true;
    public boolean a0 = false;
    public boolean b0 = false;
    public boolean c0 = false;
    public boolean h0 = false;
    public int j0 = 4;
    public d n0 = new a();

    /* renamed from: f  reason: collision with root package name */
    public String f20855f = null;

    /* renamed from: h  reason: collision with root package name */
    public int f20857h = 0;

    /* renamed from: i  reason: collision with root package name */
    public long f20858i = 0;
    public MetaData j = new MetaData();
    public ArrayList<l> l = new ArrayList<>();
    public ArrayList<l> m = new ArrayList<>();
    public int n = 0;
    public PraiseData s = new PraiseData();
    public b1 u = new b1();
    public d.a.k0.d3.h0.c v = new d.a.k0.d3.h0.c();
    public ArrayList<d.a.j0.t.c> H = new ArrayList<>();
    public AgreeData L = new AgreeData();

    /* loaded from: classes5.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        public int mColorId;

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(SkinManager.getColor(this.mColorId));
        }
    }

    /* loaded from: classes5.dex */
    public class a implements d {
        public a() {
        }

        @Override // com.baidu.tieba.tbadkCore.data.PostData.d
        public void onClick() {
            StatisticItem statisticItem = PostData.this.e0;
            if (statisticItem != null) {
                StatisticItem copy = statisticItem.copy();
                copy.delete("obj_locate");
                copy.param("obj_locate", 7);
                TiebaStatic.log(copy);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IconData f20860a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BdUniqueId f20861b;

        /* loaded from: classes5.dex */
        public class a extends d.a.c.e.l.c<d.a.c.j.d.a> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.a.c.j.g f20863a;

            public a(d.a.c.j.g gVar) {
                this.f20863a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.c.e.l.c
            public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
                super.onLoaded((a) aVar, str, i2);
                if (aVar == null || !aVar.w()) {
                    return;
                }
                this.f20863a.a(PostData.this.k(aVar));
                PostData.this.r.isChanged = true;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
            }
        }

        public b(IconData iconData, BdUniqueId bdUniqueId) {
            this.f20860a = iconData;
            this.f20861b = bdUniqueId;
        }

        @Override // d.a.c.j.g.a
        public Drawable a(d.a.c.j.g gVar) {
            d.a.c.j.d.a aVar = (d.a.c.j.d.a) d.a.c.e.l.d.h().n(this.f20860a.getIcon(), 21, new Object[0]);
            if (aVar == null) {
                d.a.c.e.l.d.h().m(this.f20860a.getIcon(), 21, new a(gVar), this.f20861b);
            }
            return PostData.this.k(aVar);
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends ClickableSpan {

        /* renamed from: e  reason: collision with root package name */
        public String f20865e;

        /* renamed from: f  reason: collision with root package name */
        public String f20866f;

        /* renamed from: g  reason: collision with root package name */
        public SoftReference<Context> f20867g;

        /* renamed from: h  reason: collision with root package name */
        public d f20868h;

        public c(Context context, String str, String str2, d dVar) {
            this.f20865e = null;
            this.f20866f = null;
            this.f20865e = str;
            this.f20866f = str2;
            this.f20867g = new SoftReference<>(context);
            this.f20868h = dVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            SoftReference<Context> softReference;
            if (this.f20865e == null || this.f20866f == null || (softReference = this.f20867g) == null || softReference.get() == null) {
                return;
            }
            d dVar = this.f20868h;
            if (dVar != null) {
                dVar.onClick();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f20867g.get(), this.f20866f, this.f20865e, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (d.a.j0.b.d.y()) {
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0318));
            } else {
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0108));
            }
            textPaint.setUnderlineText(false);
            textPaint.setFakeBoldText(!d.a.j0.b.d.y());
        }
    }

    /* loaded from: classes5.dex */
    public interface d {
        void onClick();
    }

    static {
        BdUniqueId.gen();
        u0 = BdUniqueId.gen();
        v0 = BdUniqueId.gen();
        BdUniqueId.gen();
    }

    public PostData() {
        this.o = null;
        this.O = 0;
        this.o = new ArrayList<>();
        this.O = 0;
    }

    public int A() {
        return this.f20857h;
    }

    public void A0(Context context) {
        if (this.l == null) {
            return;
        }
        int i2 = -1;
        int size = this.m.size();
        if (size > 0) {
            try {
                i2 = this.m.get(size - 1).j();
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return;
            }
        }
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            l lVar = this.l.get(i3);
            if (l.l(i2, lVar.j())) {
                this.m.get(size - 1).e(lVar.h(context));
            } else {
                if (lVar.j() != 3 && lVar.j() != 2 && lVar.j() != 11) {
                    l lVar2 = new l();
                    lVar2.m(0);
                    lVar2.e(lVar.h(context));
                    this.m.add(lVar2);
                    i2 = 0;
                    size++;
                }
                this.m.add(lVar);
                i2 = lVar.j();
                size++;
            }
        }
    }

    public String B() {
        return this.X;
    }

    public void B0() {
        if (this.E == 0) {
            this.E = 1;
        }
    }

    public int C() {
        return this.W;
    }

    public b1 D() {
        return this.u;
    }

    public String E() {
        return this.f20855f;
    }

    public Item F() {
        return this.g0;
    }

    public List<HeadItem> G() {
        return this.f0;
    }

    public String H() {
        return this.K;
    }

    public d.a.j0.t.g I() {
        return this.z;
    }

    public OriginalThreadInfo J() {
        return this.V;
    }

    public TbRichText K() {
        return this.r;
    }

    public SkinInfo L() {
        return this.J;
    }

    public ArrayList<PostData> M() {
        return this.o;
    }

    public int N() {
        return this.n;
    }

    public SmallTailInfo O() {
        return this.t;
    }

    public String P() {
        ArrayList<TbRichTextData> u;
        String str;
        TbRichText tbRichText = this.r;
        if (tbRichText == null || (u = tbRichText.u()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<TbRichTextData> it = u.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                if (next.getType() == 1) {
                    sb.append(next.A().toString());
                } else if (next.getType() == 17) {
                    if (next.u() != null && next.u().mGifInfo != null && (str = next.u().mGifInfo.mSharpText) != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                        String substring = str.substring(2, str.length() - 1);
                        sb.append("[" + substring + "]");
                    }
                } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                    sb.append(' ');
                }
            }
        }
        return sb.toString();
    }

    public long Q() {
        return this.f20856g;
    }

    public long R() {
        return this.f20858i;
    }

    public HashMap<String, MetaData> S() {
        return this.x;
    }

    public String T() {
        return this.I;
    }

    public d.a.j0.b1.m.i U() {
        d.a.j0.b1.m.i iVar = this.F;
        if (iVar != null) {
            return iVar;
        }
        TbRichText tbRichText = this.r;
        if (tbRichText == null || ListUtils.getCount(tbRichText.u()) <= 0) {
            return null;
        }
        Iterator<TbRichTextData> it = this.r.u().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 32) {
                d.a.j0.b1.m.i D = next.D();
                this.F = D;
                return D;
            }
        }
        return null;
    }

    public TbRichTextVoiceInfo V() {
        TbRichTextVoiceInfo tbRichTextVoiceInfo = this.G;
        if (tbRichTextVoiceInfo != null) {
            return tbRichTextVoiceInfo;
        }
        TbRichText tbRichText = this.r;
        if (tbRichText == null || ListUtils.getCount(tbRichText.u()) <= 0) {
            return null;
        }
        Iterator<TbRichTextData> it = this.r.u().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null && next.getType() == 512) {
                TbRichTextVoiceInfo E = next.E();
                this.G = E;
                return E;
            }
        }
        return null;
    }

    public boolean W() {
        return N() > 0 && M() != null && M().size() > 0;
    }

    public boolean X() {
        return this.Z;
    }

    public boolean Y() {
        return this.Y;
    }

    public boolean Z() {
        return this.A;
    }

    public boolean a0() {
        return this.p;
    }

    public void b0(Post post, Context context) {
        int i2;
        MetaData metaData;
        if (post == null) {
            return;
        }
        try {
            this.f20855f = String.valueOf(post.id);
            this.f20856g = post.tid.longValue();
            String str = post.title;
            this.f20857h = post.floor.intValue();
            long intValue = post.time.intValue() * 1000;
            this.f20858i = intValue;
            StringHelper.getFormatTime(intValue);
            String str2 = post.time_ex;
            String valueOf = String.valueOf(post.author_id);
            this.k = valueOf;
            if (valueOf != null && valueOf.length() > 0 && !this.k.equals("0") && this.x != null && (metaData = this.x.get(this.k)) != null) {
                this.j = metaData;
            }
            this.M = post.need_log.intValue() == 1;
            this.N = post.img_num_abtest.intValue() == 1;
            w1 w1Var = new w1();
            this.C = w1Var;
            w1Var.e(post.from_forum);
            if (this.j.getUserId() == null || this.j.getUserId().length() <= 0 || this.j.getUserId().equals("0")) {
                this.j.parserProtobuf(post.author);
            }
            if (this.j != null && context != null) {
                this.I = this.j.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.j.getLevel_id()));
            }
            post.is_ntitle.intValue();
            this.n = post.sub_post_number.intValue();
            this.B = new i(post.tpoint_post);
            List<PbContent> list = post.content;
            this.i0 = post.content;
            post.is_wonderful_post.intValue();
            this.b0 = post.is_top_agree_post.intValue() == 1;
            this.f0 = post.item_star;
            if (post.item != null && post.item.item_id.longValue() != 0) {
                this.g0 = post.item;
            }
            if (this.g0 == null && post.outer_item != null && post.outer_item.item_id.longValue() > 0 && d.a.j0.b.d.A()) {
                this.k0 = post.outer_item;
            }
            TbRichText T = TbRichTextView.T(context, list, String.valueOf(post.tid), true);
            this.r = T;
            if (T != null) {
                T.A(d.a.c.e.m.b.f(this.f20855f, -1L));
                this.r.z(this.f20857h);
                if (this.j != null) {
                    this.r.setAuthorId(this.j.getUserId());
                }
                int count = ListUtils.getCount(this.f0);
                if (this.f20857h == 1 && count != 0 && this.f0 != null) {
                    ArrayList<TbRichTextData> u = this.r.u();
                    if (count == 1) {
                        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(u, 0);
                        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
                            tbRichTextData = new TbRichTextData(1);
                            ListUtils.add(u, 0, tbRichTextData);
                        }
                        HeadItem headItem = (HeadItem) ListUtils.getItem(this.f0, 0);
                        if (headItem != null) {
                            try {
                                i2 = Integer.parseInt(headItem.content);
                            } catch (NumberFormatException unused) {
                                i2 = 0;
                            }
                            tbRichTextData.R(e.o(i2, false));
                        }
                    } else {
                        for (int size = this.f0.size() - 1; size >= 0; size--) {
                            HeadItem headItem2 = this.f0.get(size);
                            if (headItem2 != null) {
                                l(u, headItem2);
                            }
                        }
                    }
                }
                if (this.f20857h == 1 && this.g0 != null) {
                    TbRichTextData tbRichTextData2 = new TbRichTextData(1281);
                    tbRichTextData2.H(new TbRichTextEvaluateItemInfo(this.g0));
                    ListUtils.add(this.r.u(), tbRichTextData2);
                }
            }
            SubPost subPost = post.sub_post_list;
            if (subPost != null) {
                List<SubPostList> list2 = subPost.sub_post_list;
                if (list2.size() > 0) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        SubPostList subPostList = list2.get(i3);
                        PostData postData = new PostData();
                        subPostList.is_giftpost.intValue();
                        postData.L.parseProtobuf(subPostList.agree);
                        postData.y0(this.x);
                        postData.j0(this.Z);
                        postData.c0(subPostList, context);
                        this.o.add(postData);
                    }
                }
            }
            ActPost actPost = post.act_post;
            if (actPost != null) {
                this.v.a(actPost);
            }
            this.w = post.bimg_url;
            if (post.tail_info != null) {
                d.a.j0.t.c cVar = new d.a.j0.t.c();
                this.y = cVar;
                cVar.b(post.tail_info);
            }
            if (post.lbs_info != null) {
                d.a.j0.t.g gVar = new d.a.j0.t.g();
                this.z = gVar;
                gVar.c(post.lbs_info);
            }
            post.storecount.intValue();
            this.u.c(post.present);
            this.s.setUserMap(this.x);
            this.s.parserProtobuf(post.zan);
            if (post.signature != null) {
                SmallTailInfo smallTailInfo = new SmallTailInfo();
                this.t = smallTailInfo;
                smallTailInfo.id = post.signature.signature_id.intValue();
                this.t.color = post.signature.fontColor;
                if (post.signature.content != null && post.signature.content.size() != 0) {
                    this.t.content = new ArrayList();
                    for (SignatureContent signatureContent : post.signature.content) {
                        List<SmallTailInfo.SmallTailInfoContent> list3 = this.t.content;
                        SmallTailInfo smallTailInfo2 = new SmallTailInfo();
                        smallTailInfo2.getClass();
                        list3.add(new SmallTailInfo.SmallTailInfoContent(signatureContent.text, signatureContent.type.intValue()));
                    }
                }
                this.t.updateShowInfo();
            }
            if (post.ext_tails != null) {
                for (int i4 = 0; i4 != post.ext_tails.size(); i4++) {
                    d.a.j0.t.c cVar2 = new d.a.j0.t.c();
                    cVar2.b(post.ext_tails.get(i4));
                    this.H.add(cVar2);
                }
            }
            this.J = post.skin_info;
            this.K = post.lego_card;
            TPointPost tPointPost = post.tpoint_post;
            if (post.agree != null) {
                this.L.postId = this.f20855f;
                this.L.parseProtobuf(post.agree);
            }
            this.S = post.is_post_visible.intValue() == 1;
            if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.V = originalThreadInfo;
                originalThreadInfo.j(post.origin_thread_info);
            } else {
                this.V = null;
            }
            this.W = post.is_fold.intValue();
            this.X = post.fold_tip;
            if (post.advertisement != null) {
                d.a.j0.t.a aVar = new d.a.j0.t.a();
                this.m0 = aVar;
                aVar.h(post.advertisement);
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void c0(SubPostList subPostList, Context context) {
        d0(subPostList, context, false);
    }

    public void d0(SubPostList subPostList, Context context, boolean z) {
        MetaData metaData;
        if (subPostList == null) {
            return;
        }
        try {
            this.f20855f = String.valueOf(subPostList.id);
            String str = subPostList.title;
            this.f20857h = subPostList.floor.intValue();
            long intValue = subPostList.time.intValue() * 1000;
            this.f20858i = intValue;
            StringHelper.getFormatTime(intValue);
            this.k = String.valueOf(subPostList.author_id);
            subPostList.is_giftpost.intValue();
            this.L.postId = this.f20855f;
            this.L.parseProtobuf(subPostList.agree);
            MetaData metaData2 = new MetaData();
            metaData2.parserProtobuf(subPostList.author);
            if (this.k != null && this.k.length() > 0 && !this.k.equals("0") && this.x != null && (metaData = this.x.get(this.k)) != null) {
                this.j = metaData;
            }
            if (this.j.getUserId() == null || this.j.getUserId().length() <= 0 || this.j.getUserId().equals("0")) {
                this.j = metaData2;
            }
            TbRichText U = TbRichTextView.U(context, subPostList.content, z);
            this.r = U;
            if (U != null) {
                U.A(d.a.c.e.m.b.f(this.f20855f, -1L));
            }
            this.l0 = subPostList.is_author_view.intValue();
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void e(PostData postData) {
        if (postData == null) {
            return;
        }
        if (this.q == null) {
            this.q = new ArrayList<>();
            int count = ListUtils.getCount(this.o);
            int i2 = this.j0;
            if (count > i2) {
                this.q.addAll(ListUtils.subList(this.o, 0, i2));
            } else {
                this.q.addAll(this.o);
            }
        }
        this.q.add(postData);
    }

    public void e0() {
        this.q.clear();
        this.q = null;
        this.p = false;
    }

    public void f(PostData postData) {
        ArrayList<PostData> arrayList;
        if (postData == null || (arrayList = this.o) == null) {
            return;
        }
        arrayList.add(postData);
        h();
    }

    public void f0(d.a.j0.t.a aVar) {
        this.m0 = aVar;
    }

    public void g0(MetaData metaData) {
        this.j = metaData;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        ArrayList<TbRichTextData> u;
        TbRichText tbRichText = this.r;
        if (tbRichText == null || (u = tbRichText.u()) == null) {
            return null;
        }
        ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
        Iterator<TbRichTextData> it = u.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.x().getWidth();
                preLoadImageInfo.height = next.x().getHeight();
                if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.x().A()) {
                    preLoadImageInfo.imgUrl = next.x().v();
                    preLoadImageInfo.procType = 38;
                } else {
                    preLoadImageInfo.imgUrl = next.x().u();
                    preLoadImageInfo.procType = 17;
                }
                arrayList.add(preLoadImageInfo);
            } else if (next.u() != null) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.u().mGifInfo.mGifWidth;
                preLoadImageInfo2.height = next.u().mGifInfo.mGifHeight;
                preLoadImageInfo2.bigEmotion = next.u();
                preLoadImageInfo2.procType = 20;
                arrayList.add(preLoadImageInfo2);
            }
        }
        if (!TextUtils.isEmpty(this.w)) {
            PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
            preLoadImageInfo3.imgUrl = this.w;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.width = 105;
            preLoadImageInfo3.procType = 19;
            arrayList.add(preLoadImageInfo3);
        }
        if (this.j == null) {
            return arrayList;
        }
        PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
        preLoadImageInfo4.imgUrl = this.j.getPortrait();
        preLoadImageInfo4.procType = 12;
        arrayList.add(preLoadImageInfo4);
        return arrayList;
    }

    @Override // d.a.c.j.e.n
    public BdUniqueId getType() {
        int i2 = this.f20854e;
        if (i2 == 52) {
            return u0;
        }
        if (i2 == 1) {
            return q0;
        }
        if (i2 == 36) {
            return r0;
        }
        if (i2 == 40 || i2 == 50) {
            return s0;
        }
        if (i2 == 41) {
            return t0;
        }
        if (i2 == 53) {
            return v0;
        }
        if (A() == 1) {
            return o0;
        }
        return p0;
    }

    public void h() {
        this.n++;
    }

    public void h0(Context context) {
        try {
            if (this.r != null) {
                ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager.setText(this.r.toString());
                clipboardManager.getText();
                return;
            }
            if (this.m == null || this.m.size() == 0) {
                A0(context);
            }
            ArrayList<l> arrayList = this.m;
            if (arrayList != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<l> it = arrayList.iterator();
                while (it.hasNext()) {
                    l next = it.next();
                    if (next.j() == 0) {
                        if (next.k() != null) {
                            sb.append((CharSequence) next.k());
                        }
                    } else if (next.j() == 3) {
                        if (next.g() != null) {
                            sb.append(context.getString(R.string.pic_str));
                        }
                    } else if (next.j() == 6) {
                        sb.append(context.getString(R.string.voice_str));
                    } else if (next.j() == 2) {
                        String f2 = TbFaceManager.e().f(next.i());
                        if (f2 != null) {
                            sb.append("[");
                            sb.append(f2);
                            sb.append("]");
                        }
                    } else if (next.j() == 11 && !k.isEmpty(next.f())) {
                        sb.append("[");
                        sb.append(next.f());
                        sb.append("]");
                    }
                }
                ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService("clipboard");
                clipboardManager2.setText(sb.toString());
                clipboardManager2.getText();
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public final d.a.j0.r.f0.b i(boolean z, boolean z2, String str) {
        if (z || z2) {
            Context context = TbadkCoreApplication.getInst().getContext();
            int g2 = d.a.c.e.p.l.g(context, R.dimen.L_X01);
            int g3 = d.a.c.e.p.l.g(context, R.dimen.tbds10);
            int g4 = d.a.c.e.p.l.g(context, R.dimen.tbds26);
            int g5 = d.a.c.e.p.l.g(context, R.dimen.tbds12);
            int g6 = d.a.c.e.p.l.g(context, R.dimen.tbds40);
            if (" 楼主".equals(str)) {
                int i2 = R.color.CAM_X0302;
                d.a.j0.r.f0.b bVar = new d.a.j0.r.f0.b(g2, -1, i2, g4, i2, g5, g6);
                bVar.b(g3);
                bVar.f(false);
                bVar.e(str);
                return bVar;
            } else if (" 吧主".equals(str) || " 小吧主".equals(str) || " 品牌官".equals(str)) {
                d.a.j0.r.f0.b bVar2 = new d.a.j0.r.f0.b(g2, -1, R.color.CAM_X0302, g4, R.color.CAM_X0101, g5, g6);
                bVar2.b(g3);
                bVar2.a(0.7f);
                bVar2.f(true);
                bVar2.e(str);
                return bVar2;
            } else {
                return null;
            }
        }
        return null;
    }

    public void i0(int i2) {
        this.f20857h = i2;
    }

    public void j0(boolean z) {
        this.Z = z;
    }

    public Drawable k(d.a.c.j.d.a aVar) {
        Bitmap p;
        if (aVar == null || (p = aVar.p()) == null) {
            return null;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
        bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
        return bitmapDrawable;
    }

    public void k0(b1 b1Var) {
        this.u = b1Var;
    }

    public final void l(List<TbRichTextData> list, HeadItem headItem) {
        int i2;
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        StringBuilder sb = new StringBuilder();
        sb.append(headItem.name);
        sb.append(": ");
        sb.append(headItem.type.intValue() == 1 ? headItem.content : " ");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(sb.toString()));
        if (headItem.type.intValue() == 2) {
            try {
                i2 = Integer.parseInt(headItem.content);
            } catch (NumberFormatException unused) {
                i2 = 0;
            }
            spannableStringBuilder.append((CharSequence) e.o(i2, true));
        }
        tbRichTextData.s(spannableStringBuilder);
        ListUtils.add(list, 0, tbRichTextData);
    }

    public void l0(String str) {
        this.f20855f = str;
    }

    public void m() {
        this.n--;
    }

    public void m0(boolean z) {
        this.Y = z;
    }

    public void n0(boolean z) {
        this.A = z;
    }

    public void o(String str) {
        if (this.q == null || StringUtils.isNull(str)) {
            return;
        }
        Iterator<PostData> it = this.q.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null && str.equals(next.E())) {
                this.q.remove(next);
                return;
            }
        }
    }

    public void o0(boolean z) {
        this.U = z;
    }

    public String p(Context context) {
        ArrayList<TbRichTextData> u;
        TbRichText tbRichText = this.r;
        if (tbRichText == null || (u = tbRichText.u()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<TbRichTextData> it = u.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 1) {
                stringBuffer.append(next.A().toString());
            } else if (next.getType() == 17) {
                String str = next.u().mGifInfo.mSharpText;
                if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                    String substring = str.substring(2, str.length() - 1);
                    stringBuffer.append("[" + substring + "]");
                }
            } else if (next.getType() == 8) {
                stringBuffer.append("[" + context.getString(R.string.editor_image) + "]");
            } else if (next.getType() == 512) {
                stringBuffer.append("[" + context.getString(R.string.msglist_voice) + "]");
            } else if (next.getType() == 32) {
                stringBuffer.append("[" + context.getString(R.string.video_title_str) + "]");
            }
        }
        return stringBuffer.toString();
    }

    public void p0(boolean z) {
        this.p = z;
    }

    public d.a.j0.t.a q() {
        return this.m0;
    }

    public void q0(OriginalThreadInfo originalThreadInfo) {
        this.V = originalThreadInfo;
    }

    public AgreeData r() {
        return this.L;
    }

    public void r0(int i2) {
        this.f20854e = i2;
    }

    public int s() {
        return this.L.agreeType;
    }

    public void s0(PraiseData praiseData) {
        this.s = praiseData;
    }

    public MetaData t() {
        return this.j;
    }

    public void t0(TbRichText tbRichText) {
        this.r = tbRichText;
    }

    public String u() {
        return this.w;
    }

    public void u0(int i2) {
        this.n = i2;
    }

    public i v() {
        return this.B;
    }

    public void v0(SmallTailInfo smallTailInfo) {
        this.t = smallTailInfo;
    }

    public long w() {
        return this.L.disAgreeNum;
    }

    public void w0(long j) {
        this.f20858i = j;
        StringHelper.getFormatTime(j);
    }

    public ArrayList<PostData> x() {
        return this.q;
    }

    public void x0(String str) {
    }

    public PreLoadImageInfo y() {
        ArrayList<TbRichTextData> u;
        TbRichText tbRichText = this.r;
        if (tbRichText == null || (u = tbRichText.u()) == null) {
            return null;
        }
        Iterator<TbRichTextData> it = u.iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next.getType() == 8) {
                PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                preLoadImageInfo.width = next.x().getWidth();
                preLoadImageInfo.height = next.x().getHeight();
                preLoadImageInfo.imgUrl = next.x().u();
                preLoadImageInfo.procType = 17;
                return preLoadImageInfo;
            } else if (next.getType() == 20) {
                PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                preLoadImageInfo2.width = next.z().memeInfo.width.intValue();
                preLoadImageInfo2.height = next.z().memeInfo.height.intValue();
                preLoadImageInfo2.imgUrl = next.z().memeInfo.pic_url;
                preLoadImageInfo2.procType = 17;
                return preLoadImageInfo2;
            }
        }
        return null;
    }

    public void y0(HashMap<String, MetaData> hashMap) {
        this.x = hashMap;
    }

    public String z() {
        d.a.k0.d3.h0.k a2;
        PreLoadImageInfo y = y();
        if (y != null && !StringUtils.isNull(y.imgUrl)) {
            return y.imgUrl;
        }
        i iVar = this.B;
        if (iVar == null || (a2 = iVar.a()) == null || StringUtils.isNull(a2.c())) {
            return null;
        }
        return a2.c();
    }

    public void z0(TbPageContext tbPageContext, boolean z) {
        TbRichText tbRichText;
        String str;
        SpannableString spannableString;
        String str2;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        MetaData metaData;
        if (tbPageContext == null || (tbRichText = this.r) == null || tbRichText.u() == null) {
            return;
        }
        BdUniqueId uniqueId = tbPageContext.getUniqueId();
        if (z) {
            str = " 楼主";
        } else {
            MetaData metaData2 = this.j;
            if (metaData2 != null && metaData2.getIs_bawu() == 1) {
                if (this.Z) {
                    str = " 品牌官";
                } else if ("manager".equals(this.j.getBawu_type())) {
                    str = " 吧主";
                } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(this.j.getBawu_type())) {
                    str = " 小吧主";
                } else if ("pri_content_assist".equals(this.j.getBawu_type())) {
                    str = " 内容吧务";
                } else if ("pri_manage_assist".equals(this.j.getBawu_type())) {
                    str = " 管理吧务";
                }
            }
            str = "";
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<IconData> tShowInfoNew = t().getTShowInfoNew();
        if (tShowInfoNew != null) {
            Iterator<IconData> it = tShowInfoNew.iterator();
            while (it.hasNext()) {
                d.a.c.j.g gVar = new d.a.c.j.g(new b(it.next(), uniqueId), 0, 1);
                gVar.b(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                arrayList.add(gVar);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            sb.append(i2);
        }
        if (!StringUtils.isNull(this.j.getSealPrefix())) {
            sb.append(" ");
            sb.append(this.j.getSealPrefix());
        }
        if (sb.length() > 0) {
            sb.append(" ");
        }
        String sb2 = sb.toString();
        if (this.j != null) {
            spannableString = new SpannableString(sb2 + this.j.getName_show() + str + "：");
            str2 = this.j.getUserName();
            str3 = this.j.getUserId();
        } else {
            spannableString = new SpannableString(sb2 + str + "：");
            str2 = null;
            str3 = null;
        }
        int i3 = 0;
        while (i3 < arrayList.size()) {
            int i4 = i3 + 1;
            spannableString.setSpan(arrayList.get(i3), i3, i4, 17);
            i3 = i4;
        }
        if (!StringUtils.isNull(this.j.getSealPrefix())) {
            Bitmap bitmap = SkinManager.getBitmap(R.drawable.pic_smalldot_title);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            if (bitmap != null) {
                bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            }
            d.a.j0.r.f0.i iVar = new d.a.j0.r.f0.i(bitmapDrawable);
            iVar.b(d.a.c.e.p.l.g(tbPageContext.getPageActivity(), R.dimen.ds2));
            int size = arrayList.size() + this.j.getSealPrefix().length() + 1;
            spannableString.setSpan(iVar, size, size + 1, 17);
        }
        spannableString.setSpan(new c(tbPageContext.getPageActivity(), str2, str3, this.n0), 0, spannableString.length(), 18);
        if (!StringUtils.isNull(str) && (z || ((metaData = this.j) != null && metaData.getIs_bawu() == 1))) {
            MetaData metaData3 = this.j;
            d.a.j0.r.f0.b i5 = i(z, metaData3 != null && metaData3.getIs_bawu() == 1, str);
            if (i5 != null) {
                MetaData metaData4 = this.j;
                if (metaData4 != null) {
                    int length = metaData4.getName_show() != null ? this.j.getName_show().length() : 0;
                    spannableString.setSpan(i5, sb2.length() + length + 1, sb2.length() + length + str.length(), 17);
                } else {
                    spannableString.setSpan(i5, sb2.length(), sb2.length() + str.length(), 17);
                }
            }
        }
        ArrayList<TbRichTextData> u = this.r.u();
        if (u != null && u.size() > 0) {
            TbRichTextData tbRichTextData2 = u.get(0);
            if (tbRichTextData2 != null && tbRichTextData2.A() != null) {
                if (this.U) {
                    int indexOf = tbRichTextData2.A().toString().indexOf("：");
                    if (indexOf > 0) {
                        tbRichTextData2.A().delete(0, indexOf + 1);
                    }
                    this.U = false;
                }
                tbRichTextData2.O(sb.length());
                tbRichTextData2.A().insert(0, (CharSequence) spannableString);
            } else {
                int i6 = 0;
                while (true) {
                    if (i6 >= u.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (u.get(i6) != null && u.get(i6).getType() == 512) {
                        tbRichTextVoiceInfo = u.get(i6).E();
                        u.remove(i6);
                        break;
                    } else {
                        i6++;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.Q(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.O(sb.length());
                tbRichTextData.s(spannableString);
                u.add(0, tbRichTextData);
            }
        }
        this.a0 = true;
    }
}
