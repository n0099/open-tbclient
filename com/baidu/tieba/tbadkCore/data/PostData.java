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
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.e.l.e.n;
import c.a.e.l.g;
import c.a.p0.s.f0.j;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.d1;
import c.a.p0.s.q.y1;
import c.a.p0.u.f;
import c.a.q0.i3.i0.i;
import c.a.q0.i3.i0.m;
import c.a.q0.i3.i0.o;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
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
import com.baidu.tbadk.widget.richText.TbRichTextHelper;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class PostData implements PreLoadImageProvider, n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId A0;
    public static final BdUniqueId B0;
    public static boolean C0;
    public static final BdUniqueId u0;
    public static final BdUniqueId v0;
    public static final BdUniqueId w0;
    public static final BdUniqueId x0;
    public static final BdUniqueId y0;
    public static final BdUniqueId z0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public i B;
    public y1 C;
    public boolean D;
    public int E;
    public c.a.p0.d1.m.i F;
    public TbRichTextVoiceInfo G;
    public ArrayList<c.a.p0.u.c> H;
    public String I;
    public SkinInfo J;
    public String K;
    public AgreeData L;
    public boolean M;
    public boolean N;
    public int O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public AlaLiveInfoCoreData T;
    public boolean U;
    public OriginalThreadInfo V;
    public int W;
    public String X;
    public boolean Y;
    public boolean Z;
    public boolean a0;
    public boolean b0;
    public boolean c0;

    /* renamed from: e  reason: collision with root package name */
    public int f56909e;

    /* renamed from: f  reason: collision with root package name */
    public String f56910f;

    /* renamed from: g  reason: collision with root package name */
    public long f56911g;

    /* renamed from: h  reason: collision with root package name */
    public int f56912h;

    /* renamed from: i  reason: collision with root package name */
    public long f56913i;
    public int i0;

    /* renamed from: j  reason: collision with root package name */
    public MetaData f56914j;
    public StatisticItem j0;
    @Deprecated
    public String k;
    public List<HeadItem> k0;
    public ArrayList<m> l;
    public Item l0;
    public ArrayList<m> m;
    public boolean m0;
    public int n;
    public List<PbContent> n0;
    public ArrayList<PostData> o;
    public int o0;
    public boolean p;
    public Item p0;
    public ArrayList<PostData> q;
    public int q0;
    public TbRichText r;
    public c.a.p0.u.a r0;
    public PraiseData s;
    public o s0;
    public SmallTailInfo t;
    public d t0;
    public d1 u;
    public c.a.q0.i3.i0.c v;
    public String w;
    public HashMap<String, MetaData> x;
    public c.a.p0.u.c y;
    public f z;

    /* loaded from: classes7.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mColorId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomForegroundColorSpan(int i2) {
            super(SkinManager.getColor(i2));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mColorId = i2;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, textPaint) == null) {
                textPaint.setColor(SkinManager.getColor(this.mColorId));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PostData f56915a;

        public a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56915a = postData;
        }

        @Override // com.baidu.tieba.tbadkCore.data.PostData.d
        public void onClick() {
            StatisticItem statisticItem;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (statisticItem = this.f56915a.j0) == null) {
                return;
            }
            StatisticItem copy = statisticItem.copy();
            copy.delete("obj_locate");
            copy.param("obj_locate", 7);
            TiebaStatic.log(copy);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IconData f56916a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BdUniqueId f56917b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PostData f56918c;

        /* loaded from: classes7.dex */
        public class a extends c.a.e.e.l.c<c.a.e.l.d.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f56919a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f56920b;

            public a(b bVar, g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f56920b = bVar;
                this.f56919a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.e.e.l.c
            public void onLoaded(c.a.e.l.d.a aVar, String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                    super.onLoaded((a) aVar, str, i2);
                    if (aVar == null || !aVar.w()) {
                        return;
                    }
                    this.f56919a.a(this.f56920b.f56918c.i(aVar));
                    this.f56920b.f56918c.r.isChanged = true;
                    MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
                }
            }
        }

        public b(PostData postData, IconData iconData, BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postData, iconData, bdUniqueId};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56918c = postData;
            this.f56916a = iconData;
            this.f56917b = bdUniqueId;
        }

        @Override // c.a.e.l.g.a
        public Drawable a(g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
                c.a.e.l.d.a aVar = (c.a.e.l.d.a) c.a.e.e.l.d.h().n(this.f56916a.getIcon(), 21, new Object[0]);
                if (aVar == null) {
                    c.a.e.e.l.d.h().m(this.f56916a.getIcon(), 21, new a(this, gVar), this.f56917b);
                }
                return this.f56918c.i(aVar);
            }
            return (Drawable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f56921e;

        /* renamed from: f  reason: collision with root package name */
        public String f56922f;

        /* renamed from: g  reason: collision with root package name */
        public SoftReference<Context> f56923g;

        /* renamed from: h  reason: collision with root package name */
        public d f56924h;

        public c(Context context, String str, String str2, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, str, str2, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56921e = null;
            this.f56922f = null;
            this.f56921e = str;
            this.f56922f = str2;
            this.f56923g = new SoftReference<>(context);
            this.f56924h = dVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            SoftReference<Context> softReference;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f56921e == null || this.f56922f == null || (softReference = this.f56923g) == null || softReference.get() == null) {
                return;
            }
            d dVar = this.f56924h;
            if (dVar != null) {
                dVar.onClick();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f56923g.get(), this.f56922f, this.f56921e, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                if (c.a.p0.b.d.N()) {
                    textPaint.setColor(SkinManager.getColor(R.color.CAM_X0318));
                } else {
                    textPaint.setColor(SkinManager.getColor(R.color.CAM_X0108));
                }
                textPaint.setUnderlineText(false);
                textPaint.setFakeBoldText(!c.a.p0.b.d.N());
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        void onClick();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1543768272, "Lcom/baidu/tieba/tbadkCore/data/PostData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1543768272, "Lcom/baidu/tieba/tbadkCore/data/PostData;");
                return;
            }
        }
        u0 = BdUniqueId.gen();
        v0 = BdUniqueId.gen();
        w0 = BdUniqueId.gen();
        x0 = BdUniqueId.gen();
        y0 = BdUniqueId.gen();
        z0 = BdUniqueId.gen();
        BdUniqueId.gen();
        A0 = BdUniqueId.gen();
        B0 = BdUniqueId.gen();
        BdUniqueId.gen();
    }

    public PostData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f56909e = 0;
        this.o = null;
        this.p = false;
        this.q = null;
        this.r = null;
        this.A = false;
        this.E = 0;
        this.M = false;
        this.N = false;
        this.O = 0;
        this.P = true;
        this.R = false;
        this.S = false;
        this.U = false;
        this.W = 0;
        this.Y = true;
        this.a0 = false;
        this.b0 = false;
        this.c0 = false;
        this.m0 = false;
        this.o0 = 4;
        this.t0 = new a(this);
        this.f56910f = null;
        this.f56912h = 0;
        this.f56913i = 0L;
        this.f56914j = new MetaData();
        this.l = new ArrayList<>();
        this.m = new ArrayList<>();
        this.n = 0;
        this.o = new ArrayList<>();
        this.s = new PraiseData();
        this.u = new d1();
        this.v = new c.a.q0.i3.i0.c();
        this.H = new ArrayList<>();
        this.O = 0;
        this.L = new AgreeData();
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56912h : invokeV.intValue;
    }

    public void A0(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) || this.l == null) {
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
            m mVar = this.l.get(i3);
            if (m.l(i2, mVar.j())) {
                this.m.get(size - 1).e(mVar.h(context));
            } else {
                if (mVar.j() != 3 && mVar.j() != 2 && mVar.j() != 11) {
                    m mVar2 = new m();
                    mVar2.m(0);
                    mVar2.e(mVar.h(context));
                    this.m.add(mVar2);
                    i2 = 0;
                    size++;
                }
                this.m.add(mVar);
                i2 = mVar.j();
                size++;
            }
        }
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.X : (String) invokeV.objValue;
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.E == 0) {
            this.E = 1;
        }
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.W : invokeV.intValue;
    }

    public d1 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.u : (d1) invokeV.objValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f56910f : (String) invokeV.objValue;
    }

    public Item F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l0 : (Item) invokeV.objValue;
    }

    public List<HeadItem> G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.k0 : (List) invokeV.objValue;
    }

    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.K : (String) invokeV.objValue;
    }

    public f I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.z : (f) invokeV.objValue;
    }

    public OriginalThreadInfo J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.V : (OriginalThreadInfo) invokeV.objValue;
    }

    public TbRichText K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.r : (TbRichText) invokeV.objValue;
    }

    public SkinInfo L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.J : (SkinInfo) invokeV.objValue;
    }

    public ArrayList<PostData> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.o : (ArrayList) invokeV.objValue;
    }

    public int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.n : invokeV.intValue;
    }

    public SmallTailInfo O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.t : (SmallTailInfo) invokeV.objValue;
    }

    public String P() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> y;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            TbRichText tbRichText = this.r;
            if (tbRichText == null || (y = tbRichText.y()) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<TbRichTextData> it = y.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    if (next.getType() == 1) {
                        sb.append(next.F().toString());
                    } else if (next.getType() == 17) {
                        if (next.z() != null && next.z().mGifInfo != null && (str = next.z().mGifInfo.mSharpText) != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                            String substring = str.substring(2, str.length() - 1);
                            sb.append(PreferencesUtil.LEFT_MOUNT + substring + PreferencesUtil.RIGHT_MOUNT);
                        }
                    } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                        sb.append(' ');
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public long Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f56911g : invokeV.longValue;
    }

    public long R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f56913i : invokeV.longValue;
    }

    public HashMap<String, MetaData> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.x : (HashMap) invokeV.objValue;
    }

    public String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.I : (String) invokeV.objValue;
    }

    public c.a.p0.d1.m.i U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            c.a.p0.d1.m.i iVar = this.F;
            if (iVar != null) {
                return iVar;
            }
            TbRichText tbRichText = this.r;
            if (tbRichText == null || ListUtils.getCount(tbRichText.y()) <= 0) {
                return null;
            }
            Iterator<TbRichTextData> it = this.r.y().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    c.a.p0.d1.m.i K = next.K();
                    this.F = K;
                    return K;
                }
            }
            return null;
        }
        return (c.a.p0.d1.m.i) invokeV.objValue;
    }

    public TbRichTextVoiceInfo V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = this.G;
            if (tbRichTextVoiceInfo != null) {
                return tbRichTextVoiceInfo;
            }
            TbRichText tbRichText = this.r;
            if (tbRichText == null || ListUtils.getCount(tbRichText.y()) <= 0) {
                return null;
            }
            Iterator<TbRichTextData> it = this.r.y().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    TbRichTextVoiceInfo L = next.L();
                    this.G = L;
                    return L;
                }
            }
            return null;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? N() > 0 && M() != null && M().size() > 0 : invokeV.booleanValue;
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.Z : invokeV.booleanValue;
    }

    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.Y : invokeV.booleanValue;
    }

    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public void b0(SubPostList subPostList, Context context, boolean z, @Nullable c2 c2Var, int i2) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{subPostList, context, Boolean.valueOf(z), c2Var, Integer.valueOf(i2)}) == null) || subPostList == null) {
            return;
        }
        try {
            this.f56910f = String.valueOf(subPostList.id);
            String str = subPostList.title;
            this.f56912h = subPostList.floor.intValue();
            long intValue = subPostList.time.intValue() * 1000;
            this.f56913i = intValue;
            StringHelper.getFormatTime(intValue);
            this.k = String.valueOf(subPostList.author_id);
            subPostList.is_giftpost.intValue();
            this.L.postId = this.f56910f;
            this.L.parseProtobuf(subPostList.agree);
            MetaData metaData2 = new MetaData();
            metaData2.parserProtobuf(subPostList.author);
            if (this.k != null && this.k.length() > 0 && !this.k.equals("0") && this.x != null && (metaData = this.x.get(this.k)) != null) {
                this.f56914j = metaData;
            }
            if (this.f56914j.getUserId() == null || this.f56914j.getUserId().length() <= 0 || this.f56914j.getUserId().equals("0")) {
                this.f56914j = metaData2;
            }
            TbRichText parser = TbRichTextView.parser(context, subPostList.content, null, z, this, c2Var, i2);
            this.r = parser;
            if (parser != null) {
                parser.F(c.a.e.e.m.b.f(this.f56910f, -1L));
            }
            this.q0 = subPostList.is_author_view.intValue();
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void c(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048606, this, postData) == null) || postData == null) {
            return;
        }
        if (this.q == null) {
            this.q = new ArrayList<>();
            int count = ListUtils.getCount(this.o);
            int i2 = this.o0;
            if (count > i2) {
                this.q.addAll(ListUtils.subList(this.o, 0, i2));
            } else {
                this.q.addAll(this.o);
            }
        }
        this.q.add(postData);
    }

    public void c0(Post post, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, post, context) == null) {
            d0(post, context, null);
        }
    }

    public void d(PostData postData) {
        ArrayList<PostData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048608, this, postData) == null) || postData == null || (arrayList = this.o) == null) {
            return;
        }
        arrayList.add(postData);
        g();
    }

    public void d0(Post post, Context context, @Nullable c2 c2Var) {
        int i2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048609, this, post, context, c2Var) == null) || post == null) {
            return;
        }
        try {
            this.f56910f = String.valueOf(post.id);
            this.f56911g = post.tid.longValue();
            String str = post.title;
            this.f56912h = post.floor.intValue();
            long intValue = post.time.intValue() * 1000;
            this.f56913i = intValue;
            StringHelper.getFormatTime(intValue);
            String str2 = post.time_ex;
            String valueOf = String.valueOf(post.author_id);
            this.k = valueOf;
            if (valueOf != null && valueOf.length() > 0 && !this.k.equals("0") && this.x != null && (metaData = this.x.get(this.k)) != null) {
                this.f56914j = metaData;
            }
            this.M = post.need_log.intValue() == 1;
            this.N = post.img_num_abtest.intValue() == 1;
            y1 y1Var = new y1();
            this.C = y1Var;
            y1Var.f(post.from_forum);
            if (this.f56914j.getUserId() == null || this.f56914j.getUserId().length() <= 0 || this.f56914j.getUserId().equals("0")) {
                this.f56914j.parserProtobuf(post.author);
            }
            if (this.f56914j != null && context != null) {
                this.I = this.f56914j.getUserName() + context.getResources().getString(R.string.somebodys_portrait);
                String.format(TbadkCoreApplication.getInst().getString(R.string.degree_in_forum), Integer.valueOf(this.f56914j.getLevel_id()));
            }
            post.is_ntitle.intValue();
            this.n = post.sub_post_number.intValue();
            this.B = new i(post.tpoint_post);
            List<PbContent> list = post.content;
            this.n0 = post.content;
            post.is_wonderful_post.intValue();
            this.b0 = post.is_top_agree_post.intValue() == 1;
            this.k0 = post.item_star;
            if (post.item != null && post.item.item_id.longValue() != 0) {
                this.l0 = post.item;
            }
            if (this.l0 == null && post.outer_item != null && post.outer_item.item_id.longValue() > 0 && c.a.p0.b.d.T()) {
                this.p0 = post.outer_item;
            }
            TbRichText parser = TbRichTextView.parser(context, list, String.valueOf(post.tid), true, this, c2Var, A());
            this.r = parser;
            if (parser != null) {
                parser.F(c.a.e.e.m.b.f(this.f56910f, -1L));
                this.r.E(this.f56912h);
                if (this.f56914j != null) {
                    this.r.setAuthorId(this.f56914j.getUserId());
                }
                int count = ListUtils.getCount(this.k0);
                if (this.f56912h == 1 && count != 0 && this.k0 != null) {
                    ArrayList<TbRichTextData> y = this.r.y();
                    if (count == 1) {
                        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(y, 0);
                        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
                            tbRichTextData = new TbRichTextData(1);
                            ListUtils.add(y, 0, tbRichTextData);
                        }
                        HeadItem headItem = (HeadItem) ListUtils.getItem(this.k0, 0);
                        if (headItem != null) {
                            try {
                                i2 = Integer.parseInt(headItem.content);
                            } catch (NumberFormatException unused) {
                                i2 = 0;
                            }
                            tbRichTextData.Z(TbRichTextHelper.q(i2, false));
                        }
                    } else {
                        for (int size = this.k0.size() - 1; size >= 0; size--) {
                            HeadItem headItem2 = this.k0.get(size);
                            if (headItem2 != null) {
                                k(y, headItem2);
                            }
                        }
                    }
                }
                if (this.f56912h == 1 && this.l0 != null) {
                    TbRichTextData tbRichTextData2 = new TbRichTextData(1281);
                    tbRichTextData2.O(new TbRichTextEvaluateItemInfo(this.l0));
                    ListUtils.add(this.r.y(), tbRichTextData2);
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
                        postData.b0(subPostList, context, false, c2Var, A());
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
                c.a.p0.u.c cVar = new c.a.p0.u.c();
                this.y = cVar;
                cVar.b(post.tail_info);
            }
            if (post.lbs_info != null) {
                f fVar = new f();
                this.z = fVar;
                fVar.c(post.lbs_info);
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
                        list3.add(new SmallTailInfo.SmallTailInfoContent(smallTailInfo2, signatureContent.text, signatureContent.type.intValue()));
                    }
                }
                this.t.updateShowInfo();
            }
            if (post.ext_tails != null) {
                for (int i4 = 0; i4 != post.ext_tails.size(); i4++) {
                    c.a.p0.u.c cVar2 = new c.a.p0.u.c();
                    cVar2.b(post.ext_tails.get(i4));
                    this.H.add(cVar2);
                }
            }
            this.J = post.skin_info;
            this.K = post.lego_card;
            TPointPost tPointPost = post.tpoint_post;
            if (post.agree != null) {
                this.L.postId = this.f56910f;
                this.L.parseProtobuf(post.agree);
            }
            this.S = post.is_post_visible.intValue() == 1;
            if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.V = originalThreadInfo;
                originalThreadInfo.l(post.origin_thread_info);
            } else {
                this.V = null;
            }
            this.W = post.is_fold.intValue();
            this.X = post.fold_tip;
            if (post.advertisement != null) {
                c.a.p0.u.a aVar = new c.a.p0.u.a();
                this.r0 = aVar;
                aVar.k(post.advertisement);
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.q.clear();
            this.q = null;
            this.p = false;
        }
    }

    public void f0(c.a.p0.u.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, aVar) == null) {
            this.r0 = aVar;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.n++;
        }
    }

    public void g0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, metaData) == null) {
            this.f56914j = metaData;
        }
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            TbRichText tbRichText = this.r;
            if (tbRichText == null || (y = tbRichText.y()) == null) {
                return null;
            }
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            Iterator<TbRichTextData> it = y.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.C().getWidth();
                    preLoadImageInfo.height = next.C().getHeight();
                    if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.C().E()) {
                        preLoadImageInfo.imgUrl = next.C().z();
                        preLoadImageInfo.procType = 38;
                    } else {
                        preLoadImageInfo.imgUrl = next.C().y();
                        preLoadImageInfo.procType = 17;
                    }
                    arrayList.add(preLoadImageInfo);
                } else if (next.z() != null) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.z().mGifInfo.mGifWidth;
                    preLoadImageInfo2.height = next.z().mGifInfo.mGifHeight;
                    preLoadImageInfo2.bigEmotion = next.z();
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
            if (this.f56914j == null) {
                return arrayList;
            }
            PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
            preLoadImageInfo4.imgUrl = this.f56914j.getPortrait();
            preLoadImageInfo4.procType = 12;
            arrayList.add(preLoadImageInfo4);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            int i2 = this.f56909e;
            if (i2 == 52) {
                return A0;
            }
            if (i2 == 1) {
                return w0;
            }
            if (i2 == 36) {
                return x0;
            }
            if (i2 == 40 || i2 == 50) {
                return y0;
            }
            if (i2 == 41) {
                return z0;
            }
            if (i2 == 53) {
                return B0;
            }
            if (A() == 1) {
                return u0;
            }
            o oVar = this.s0;
            if (oVar == null || !oVar.f()) {
                return v0;
            }
            return this.s0.g() ? AdvertAppInfo.x4 : AdvertAppInfo.z4;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final c.a.p0.s.f0.b h(boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048616, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (z || z2) {
                Context context = TbadkCoreApplication.getInst().getContext();
                int g2 = l.g(context, R.dimen.L_X01);
                int g3 = l.g(context, R.dimen.tbds10);
                int g4 = l.g(context, R.dimen.tbds26);
                int g5 = l.g(context, R.dimen.tbds12);
                int g6 = l.g(context, R.dimen.tbds40);
                if (" 楼主".equals(str)) {
                    int i2 = R.color.CAM_X0302;
                    c.a.p0.s.f0.b bVar = new c.a.p0.s.f0.b(g2, -1, i2, g4, i2, g5, g6);
                    bVar.b(g3);
                    bVar.f(false);
                    bVar.e(str);
                    return bVar;
                } else if (" 吧主".equals(str) || " 小吧主".equals(str) || " 品牌官".equals(str)) {
                    c.a.p0.s.f0.b bVar2 = new c.a.p0.s.f0.b(g2, -1, R.color.CAM_X0302, g4, R.color.CAM_X0101, g5, g6);
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
        return (c.a.p0.s.f0.b) invokeCommon.objValue;
    }

    public void h0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, context) == null) {
            try {
                if (this.r != null) {
                    ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
                    clipboardManager.setText(this.r.toString());
                    clipboardManager.getText();
                    return;
                }
                if (this.m == null || this.m.size() == 0) {
                    A0(context);
                }
                ArrayList<m> arrayList = this.m;
                if (arrayList != null) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<m> it = arrayList.iterator();
                    while (it.hasNext()) {
                        m next = it.next();
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
                                sb.append(PreferencesUtil.LEFT_MOUNT);
                                sb.append(f2);
                                sb.append(PreferencesUtil.RIGHT_MOUNT);
                            }
                        } else if (next.j() == 11 && !k.isEmpty(next.f())) {
                            sb.append(PreferencesUtil.LEFT_MOUNT);
                            sb.append(next.f());
                            sb.append(PreferencesUtil.RIGHT_MOUNT);
                        }
                    }
                    ClipboardManager clipboardManager2 = (ClipboardManager) context.getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD);
                    clipboardManager2.setText(sb.toString());
                    clipboardManager2.getText();
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public Drawable i(c.a.e.l.d.a aVar) {
        InterceptResult invokeL;
        Bitmap p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, aVar)) == null) {
            if (aVar == null || (p = aVar.p()) == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
            bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
            return bitmapDrawable;
        }
        return (Drawable) invokeL.objValue;
    }

    public void i0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.f56912h = i2;
        }
    }

    public void j0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.Z = z;
        }
    }

    public final void k(List<TbRichTextData> list, HeadItem headItem) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048621, this, list, headItem) == null) {
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
                spannableStringBuilder.append((CharSequence) TbRichTextHelper.q(i2, true));
            }
            tbRichTextData.x(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public void k0(d1 d1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, d1Var) == null) {
            this.u = d1Var;
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.n--;
        }
    }

    public void l0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, str) == null) {
            this.f56910f = str;
        }
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z) == null) {
            this.Y = z;
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, str) == null) || this.q == null || StringUtils.isNull(str)) {
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

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.A = z;
        }
    }

    public String o(Context context) {
        InterceptResult invokeL;
        ArrayList<TbRichTextData> y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, context)) == null) {
            TbRichText tbRichText = this.r;
            if (tbRichText == null || (y = tbRichText.y()) == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<TbRichTextData> it = y.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 1) {
                    stringBuffer.append(next.F().toString());
                } else if (next.getType() == 17) {
                    String str = next.z().mGifInfo.mSharpText;
                    if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                        String substring = str.substring(2, str.length() - 1);
                        stringBuffer.append(PreferencesUtil.LEFT_MOUNT + substring + PreferencesUtil.RIGHT_MOUNT);
                    }
                } else if (next.getType() == 8) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + context.getString(R.string.editor_image) + PreferencesUtil.RIGHT_MOUNT);
                } else if (next.getType() == 512) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + context.getString(R.string.msglist_voice) + PreferencesUtil.RIGHT_MOUNT);
                } else if (next.getType() == 32) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + context.getString(R.string.video_title_str) + PreferencesUtil.RIGHT_MOUNT);
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.U = z;
        }
    }

    public c.a.p0.u.a p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.r0 : (c.a.p0.u.a) invokeV.objValue;
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048631, this, z) == null) {
            this.p = z;
        }
    }

    public AgreeData q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.L : (AgreeData) invokeV.objValue;
    }

    public void q0(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, originalThreadInfo) == null) {
            this.V = originalThreadInfo;
        }
    }

    public void r0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
            this.f56909e = i2;
        }
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.L.agreeType : invokeV.intValue;
    }

    public void s0(PraiseData praiseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, praiseData) == null) {
            this.s = praiseData;
        }
    }

    public MetaData t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.f56914j : (MetaData) invokeV.objValue;
    }

    public void t0(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, tbRichText) == null) {
            this.r = tbRichText;
        }
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    public void u0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            this.n = i2;
        }
    }

    public i v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.B : (i) invokeV.objValue;
    }

    public void v0(SmallTailInfo smallTailInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, smallTailInfo) == null) {
            this.t = smallTailInfo;
        }
    }

    public long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.L.disAgreeNum : invokeV.longValue;
    }

    public void w0(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048644, this, j2) == null) {
            this.f56913i = j2;
            StringHelper.getFormatTime(j2);
        }
    }

    public ArrayList<PostData> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.q : (ArrayList) invokeV.objValue;
    }

    public void x0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, str) == null) {
        }
    }

    public PreLoadImageInfo y() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            TbRichText tbRichText = this.r;
            if (tbRichText == null || (y = tbRichText.y()) == null) {
                return null;
            }
            Iterator<TbRichTextData> it = y.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.C().getWidth();
                    preLoadImageInfo.height = next.C().getHeight();
                    preLoadImageInfo.imgUrl = next.C().y();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.E().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.E().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.E().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return (PreLoadImageInfo) invokeV.objValue;
    }

    public void y0(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, hashMap) == null) {
            this.x = hashMap;
        }
    }

    public String z() {
        InterceptResult invokeV;
        c.a.q0.i3.i0.k a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
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
        return (String) invokeV.objValue;
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
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048650, this, tbPageContext, z) == null) || tbPageContext == null || (tbRichText = this.r) == null || tbRichText.y() == null) {
            return;
        }
        BdUniqueId uniqueId = tbPageContext.getUniqueId();
        if (z) {
            str = " 楼主";
        } else {
            MetaData metaData2 = this.f56914j;
            if (metaData2 != null && metaData2.getIs_bawu() == 1) {
                if (this.Z) {
                    str = " 品牌官";
                } else if ("manager".equals(this.f56914j.getBawu_type())) {
                    str = " 吧主";
                } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(this.f56914j.getBawu_type())) {
                    str = " 小吧主";
                } else if ("pri_content_assist".equals(this.f56914j.getBawu_type())) {
                    str = " 内容吧务";
                } else if ("pri_manage_assist".equals(this.f56914j.getBawu_type())) {
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
                g gVar = new g(new b(this, it.next(), uniqueId), 0, 1);
                gVar.b(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                arrayList.add(gVar);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            sb.append(i2);
        }
        if (!StringUtils.isNull(this.f56914j.getSealPrefix())) {
            sb.append(" ");
            sb.append(this.f56914j.getSealPrefix());
        }
        if (sb.length() > 0) {
            sb.append(" ");
        }
        String sb2 = sb.toString();
        if (this.f56914j != null) {
            spannableString = new SpannableString(sb2 + this.f56914j.getName_show() + str + "：");
            str2 = this.f56914j.getUserName();
            str3 = this.f56914j.getUserId();
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
        if (!StringUtils.isNull(this.f56914j.getSealPrefix())) {
            Bitmap bitmap = SkinManager.getBitmap(R.drawable.pic_smalldot_title);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            if (bitmap != null) {
                bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            }
            j jVar = new j(bitmapDrawable);
            jVar.b(l.g(tbPageContext.getPageActivity(), R.dimen.ds2));
            int size = arrayList.size() + this.f56914j.getSealPrefix().length() + 1;
            spannableString.setSpan(jVar, size, size + 1, 17);
        }
        spannableString.setSpan(new c(tbPageContext.getPageActivity(), str2, str3, this.t0), 0, spannableString.length(), 18);
        if (!StringUtils.isNull(str) && (z || ((metaData = this.f56914j) != null && metaData.getIs_bawu() == 1))) {
            MetaData metaData3 = this.f56914j;
            c.a.p0.s.f0.b h2 = h(z, metaData3 != null && metaData3.getIs_bawu() == 1, str);
            if (h2 != null) {
                MetaData metaData4 = this.f56914j;
                if (metaData4 != null) {
                    int length = metaData4.getName_show() != null ? this.f56914j.getName_show().length() : 0;
                    spannableString.setSpan(h2, sb2.length() + length + 1, sb2.length() + length + str.length(), 17);
                } else {
                    spannableString.setSpan(h2, sb2.length(), sb2.length() + str.length(), 17);
                }
            }
        }
        ArrayList<TbRichTextData> y = this.r.y();
        if (y != null && y.size() > 0) {
            TbRichTextData tbRichTextData2 = y.get(0);
            if (tbRichTextData2 != null && tbRichTextData2.F() != null) {
                if (this.U) {
                    int indexOf = tbRichTextData2.F().toString().indexOf("：");
                    if (indexOf > 0) {
                        tbRichTextData2.F().delete(0, indexOf + 1);
                    }
                    this.U = false;
                }
                tbRichTextData2.V(sb.length());
                tbRichTextData2.F().insert(0, (CharSequence) spannableString);
            } else {
                int i5 = 0;
                while (true) {
                    if (i5 >= y.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (y.get(i5) != null && y.get(i5).getType() == 512) {
                        tbRichTextVoiceInfo = y.get(i5).L();
                        y.remove(i5);
                        break;
                    } else {
                        i5++;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.Y(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.V(sb.length());
                tbRichTextData.x(spannableString);
                y.add(0, tbRichTextData);
            }
        }
        this.a0 = true;
    }
}
