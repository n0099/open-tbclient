package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.resourceLoader.BdResourceCallback;
import com.baidu.adp.lib.resourceLoader.BdResourceLoader;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.adp.widget.ImageView.BdImage;
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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.data.AdverSegmentData;
import com.baidu.tbadk.data.CardLinkInfoData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.data.VirtualImageCustomState;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.cj;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.ThemeBubbleData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tbclient.ActPost;
import tbclient.AigcFeedbackInfo;
import tbclient.BotReplyContent;
import tbclient.CallRobotEntrance;
import tbclient.FestivalTipData;
import tbclient.FullLengthNovel;
import tbclient.HeadItem;
import tbclient.Item;
import tbclient.NovelRecomCard;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.RobotSkill;
import tbclient.SignatureContent;
import tbclient.SkinInfo;
import tbclient.SpriteMemeInfo;
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes8.dex */
public class ura implements PreLoadImageProvider, oi {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId W0;
    public static final BdUniqueId X0;
    public static final BdUniqueId Y0;
    public static final BdUniqueId Z0;
    public static final BdUniqueId a1;
    public static final BdUniqueId b1;
    public static final BdUniqueId c1;
    public static final BdUniqueId d1;
    public static final BdUniqueId e1;
    public static boolean f1;
    public transient /* synthetic */ FieldHolder $fh;
    public dz4 A;
    public long A0;
    public int B;
    public String B0;
    public String C;
    public boolean C0;
    public boolean D;
    public int D0;
    public int E;
    public int E0;
    public my5 F;
    public boolean F0;
    public TbRichTextVoiceInfo G;
    public boolean G0;
    public ArrayList<ic5> H;
    public VirtualImageCustomFigure H0;
    public String I;
    public VirtualImageCustomState I0;
    public SkinInfo J;
    public boolean J0;
    public String K;
    public ThemeBubbleData K0;
    public AgreeData L;
    public FullLengthNovel L0;
    public boolean M;
    public c6b M0;
    public boolean N;
    public e6b N0;
    public int O;
    public jz4 O0;
    public boolean P;
    public NovelRecomCard P0;
    public boolean Q;
    public String Q0;
    public boolean R;
    public List<BotReplyContent> R0;
    public int S;
    @Nullable
    public AigcFeedbackInfo S0;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1164T;
    public int T0;
    public AlaLiveInfoCoreData U;
    public d U0;
    @Nullable
    public lra V;
    public Boolean V0;
    @Nullable
    public SpriteMemeInfo W;
    public boolean X;
    public OriginalThreadInfo Y;
    public int Z;
    public int a;
    public String a0;
    public String b;
    public boolean b0;
    public long c;
    public boolean c0;
    public int d;
    public boolean d0;
    public long e;
    public boolean e0;
    public MetaData f;
    public boolean f0;
    @Deprecated
    public String g;
    public int g0;
    public ArrayList<rra> h;
    public StatisticItem h0;
    public ArrayList<rra> i;
    public List<HeadItem> i0;
    public int j;
    public Item j0;
    public ArrayList<ura> k;
    public boolean l;
    public ArrayList<ura> m;
    public TbRichText n;
    public PraiseData o;
    public SmallTailInfo p;
    public gy4 q;
    public ira r;
    public boolean r0;
    public String s;
    public List<PbContent> s0;
    public String t;
    public int t0;
    public String u;
    public Item u0;
    public HashMap<String, MetaData> v;
    public int v0;
    public ic5 w;
    public AdverSegmentData w0;
    public sc5 x;
    public vc5 x0;
    public boolean y;
    public List<CardLinkInfoData> y0;
    public nra z;
    public sra z0;

    /* loaded from: classes8.dex */
    public interface d {
        void onClick();
    }

    public void e1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
        }
    }

    public void v1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, str) == null) {
        }
    }

    public void z1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048705, this, i) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class b implements cj.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IconData a;
        public final /* synthetic */ BdUniqueId b;
        public final /* synthetic */ ura c;

        /* loaded from: classes8.dex */
        public class a extends BdResourceCallback<BdImage> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ cj a;
            public final /* synthetic */ b b;

            public a(b bVar, cj cjVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cjVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = cjVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.resourceLoader.BdResourceCallback
            public void onLoaded(BdImage bdImage, String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(1048576, this, bdImage, str, i) == null) {
                    super.onLoaded((a) bdImage, str, i);
                    if (bdImage != null && bdImage.isValidNow()) {
                        this.a.a(this.b.c.f(bdImage));
                        this.b.c.n.isChanged = true;
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
                    }
                }
            }
        }

        public b(ura uraVar, IconData iconData, BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uraVar, iconData, bdUniqueId};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = uraVar;
            this.a = iconData;
            this.b = bdUniqueId;
        }

        @Override // com.baidu.tieba.cj.a
        public Drawable a(cj cjVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cjVar)) == null) {
                BdImage bdImage = (BdImage) BdResourceLoader.getInstance().loadResourceFromMemery(this.a.getIcon(), 21, new Object[0]);
                if (bdImage == null) {
                    BdResourceLoader.getInstance().loadResource(this.a.getIcon(), 21, new a(this, cjVar), this.b);
                }
                return this.c.f(bdImage);
            }
            return (Drawable) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ura a;

        public a(ura uraVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uraVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uraVar;
        }

        @Override // com.baidu.tieba.ura.d
        public void onClick() {
            StatisticItem statisticItem;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (statisticItem = this.a.h0) != null) {
                StatisticItem copy = statisticItem.copy();
                copy.delete("obj_locate");
                copy.param("obj_locate", 7);
                TiebaStatic.log(copy);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public String c;
        public d d;

        public c(String str, String str2, @Nullable String str3, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.b = null;
            this.c = null;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = dVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (ju9.a(this.c)) {
                    d dVar = this.d;
                    if (dVar != null) {
                        dVar.onClick();
                    }
                    TbLog defaultLog = DefaultLog.getInstance();
                    defaultLog.i("TargetSchemeInterceptHelper", "jump targetScheme: " + this.c);
                } else if (this.a != null && this.b != null) {
                    d dVar2 = this.d;
                    if (dVar2 != null) {
                        dVar2.onClick();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkCoreApplication.getInst(), this.b, this.a, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                }
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                textPaint.setColor(SkinManager.getColor(R.color.CAM_X0108));
                textPaint.setUnderlineText(false);
                textPaint.setFakeBoldText(true);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948221989, "Lcom/baidu/tieba/ura;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948221989, "Lcom/baidu/tieba/ura;");
                return;
            }
        }
        W0 = BdUniqueId.gen();
        X0 = BdUniqueId.gen();
        Y0 = BdUniqueId.gen();
        Z0 = BdUniqueId.gen();
        a1 = BdUniqueId.gen();
        b1 = BdUniqueId.gen();
        c1 = BdUniqueId.gen();
        d1 = BdUniqueId.gen();
        e1 = BdUniqueId.gen();
    }

    public my5 u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            my5 my5Var = this.F;
            if (my5Var != null) {
                return my5Var;
            }
            TbRichText tbRichText = this.n;
            if (tbRichText != null && ListUtils.getCount(tbRichText.Q()) > 0) {
                Iterator<TbRichTextData> it = this.n.Q().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 32) {
                        my5 f0 = next.f0();
                        this.F = f0;
                        return f0;
                    }
                }
                return null;
            }
            return null;
        }
        return (my5) invokeV.objValue;
    }

    public TbRichTextVoiceInfo x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = this.G;
            if (tbRichTextVoiceInfo != null) {
                return tbRichTextVoiceInfo;
            }
            TbRichText tbRichText = this.n;
            if (tbRichText != null && ListUtils.getCount(tbRichText.Q()) > 0) {
                Iterator<TbRichTextData> it = this.n.Q().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 512) {
                        TbRichTextVoiceInfo g0 = next.g0();
                        this.G = g0;
                        return g0;
                    }
                }
                return null;
            }
            return null;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public ura() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.k = null;
        this.l = false;
        this.m = null;
        this.n = null;
        this.y = false;
        this.B = 0;
        this.E = 0;
        this.M = false;
        this.N = false;
        this.O = 0;
        this.P = true;
        this.R = false;
        this.f1164T = false;
        this.X = false;
        this.Z = 0;
        this.b0 = true;
        this.d0 = false;
        this.e0 = false;
        this.f0 = false;
        this.r0 = false;
        this.t0 = 4;
        this.C0 = false;
        this.D0 = 0;
        this.F0 = false;
        this.G0 = false;
        this.T0 = 0;
        this.U0 = new a(this);
        this.b = null;
        this.d = 0;
        this.e = 0L;
        this.f = new MetaData();
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.j = 0;
        this.k = new ArrayList<>();
        this.o = new PraiseData();
        this.q = new gy4();
        this.r = new ira();
        this.H = new ArrayList<>();
        this.O = 0;
        this.L = new AgreeData();
        this.K0 = ThemeBubbleData.DEFAULT;
    }

    public void D1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || this.h == null) {
            return;
        }
        int i = -1;
        int size = this.i.size();
        if (size > 0) {
            try {
                i = this.i.get(size - 1).j();
            } catch (Exception e) {
                BdLog.detailException(e);
                return;
            }
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            rra rraVar = this.h.get(i2);
            if (rra.l(i, rraVar.j())) {
                this.i.get(size - 1).e(rraVar.h());
            } else {
                if (rraVar.j() != 3 && rraVar.j() != 2 && rraVar.j() != 11) {
                    rra rraVar2 = new rra();
                    rraVar2.m(0);
                    rraVar2.e(rraVar.h());
                    this.i.add(rraVar2);
                    i = 0;
                    size++;
                }
                this.i.add(rraVar);
                i = rraVar.j();
                size++;
            }
        }
    }

    public PreLoadImageInfo H() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (Q = tbRichText.Q()) == null) {
                return null;
            }
            Iterator<TbRichTextData> it = Q.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.W().getWidth();
                    preLoadImageInfo.height = next.W().getHeight();
                    preLoadImageInfo.imgUrl = next.W().Q();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.Z().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.Z().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.Z().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return (PreLoadImageInfo) invokeV.objValue;
    }

    public String n0() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> Q;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (Q = tbRichText.Q()) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<TbRichTextData> it = Q.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    if (next.getType() == 1) {
                        if (next.a0() != null) {
                            sb.append(next.a0().toString());
                        }
                    } else if (next.getType() == 17) {
                        if (next.R() != null && next.R().mGifInfo != null && (str = next.R().mGifInfo.mSharpText) != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                            String substring = str.substring(2, str.length() - 1);
                            sb.append(PreferencesUtil.LEFT_MOUNT + substring + PreferencesUtil.RIGHT_MOUNT);
                        }
                    } else if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                        sb.append(WebvttCueParser.CHAR_SPACE);
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean I0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z)) == null) {
            if (!A0() && !z0(z)) {
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public void K0(Post post) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, post) == null) {
            L0(post, null);
        }
    }

    public void P0(AdverSegmentData adverSegmentData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, adverSegmentData) == null) {
            this.w0 = adverSegmentData;
        }
    }

    public void Q0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, metaData) == null) {
            this.f = metaData;
        }
    }

    public void R0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            this.Q0 = str;
        }
    }

    public void S0(@NonNull lra lraVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, lraVar) == null) {
            this.V = lraVar;
        }
    }

    public void U0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048620, this, i) == null) {
            this.S = i;
        }
    }

    public void V0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.T0 = i;
        }
    }

    public void X0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i) == null) {
            this.d = i;
        }
    }

    public void Y0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048628, this, j) == null) {
            this.A0 = j;
        }
    }

    public void Z0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            this.B0 = str;
        }
    }

    public void a1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.c0 = z;
        }
    }

    public void b1(gy4 gy4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, gy4Var) == null) {
            this.q = gy4Var;
        }
    }

    public void c(ura uraVar) {
        ArrayList<ura> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, uraVar) == null) && uraVar != null && (arrayList = this.k) != null) {
            arrayList.add(uraVar);
            d();
        }
    }

    public void c1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z) == null) {
            this.F0 = z;
        }
    }

    public void d1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            this.b = str;
        }
    }

    public Drawable f(BdImage bdImage) {
        InterceptResult invokeL;
        Bitmap rawBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048645, this, bdImage)) == null) {
            if (bdImage == null || (rawBitmap = bdImage.getRawBitmap()) == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(rawBitmap);
            bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
            return bitmapDrawable;
        }
        return (Drawable) invokeL.objValue;
    }

    public void f1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.b0 = z;
        }
    }

    public void g1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z) == null) {
            this.y = z;
        }
    }

    public void h1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048655, this, z) == null) {
            this.X = z;
        }
    }

    public void i1(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, bool) == null) {
            this.C0 = bool.booleanValue();
        }
    }

    public void j1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048660, this, i) == null) {
            this.E0 = i;
        }
    }

    public void k1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z) == null) {
            this.J0 = z;
        }
    }

    public void l1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048665, this, z) == null) {
            this.l = z;
        }
    }

    public void m1(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, originalThreadInfo) == null) {
            this.Y = originalThreadInfo;
        }
    }

    public void n1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048670, this, i) == null) {
            this.a = i;
        }
    }

    public void o1(PraiseData praiseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, praiseData) == null) {
            this.o = praiseData;
        }
    }

    public void p1(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, tbRichText) == null) {
            this.n = tbRichText;
        }
    }

    public void q1(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, bool) == null) {
            this.V0 = bool;
        }
    }

    public void r1(SpriteMemeInfo spriteMemeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, spriteMemeInfo) == null) {
            this.W = spriteMemeInfo;
        }
    }

    public void s1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048684, this, i) == null) {
            this.j = i;
        }
    }

    public void t1(SmallTailInfo smallTailInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, smallTailInfo) == null) {
            this.p = smallTailInfo;
        }
    }

    public void u1(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048690, this, j) == null) {
            this.e = j;
            StringHelper.getFormatTime(j);
        }
    }

    public void w1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048696, this, z) == null) {
            this.G0 = z;
        }
    }

    public void x1(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048699, this, hashMap) == null) {
            this.v = hashMap;
        }
    }

    public void y1(Post post) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048702, this, post) == null) {
            if (post.custom_figure != null) {
                VirtualImageCustomFigure virtualImageCustomFigure = new VirtualImageCustomFigure();
                this.H0 = virtualImageCustomFigure;
                virtualImageCustomFigure.parseProto(post.custom_figure);
            }
            if (post.custom_state != null) {
                VirtualImageCustomState virtualImageCustomState = new VirtualImageCustomState();
                this.I0 = virtualImageCustomState;
                virtualImageCustomState.parseProto(post.custom_state);
            }
        }
    }

    public boolean z0(boolean z) {
        InterceptResult invokeZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048704, this, z)) == null) {
            if (z) {
                i = 2;
            } else {
                i = 4;
            }
            if (k0() <= i && l0() > k0()) {
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public nra A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.z;
        }
        return (nra) invokeV.objValue;
    }

    public boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (l0() > 0 && j0() != null && j0().size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            OriginalThreadInfo originalThreadInfo = this.Y;
            if (originalThreadInfo == null || !originalThreadInfo.H || this.A0 != originalThreadInfo.e) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i = this.S;
            if (i != 0 && i != 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            jz4 jz4Var = this.O0;
            if (jz4Var != null && jz4Var.c()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    public boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c0;
        }
        return invokeV.booleanValue;
    }

    public ArrayList<ura> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.m;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.J0;
        }
        return invokeV.booleanValue;
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.T0;
        }
        return invokeV.intValue;
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b0;
        }
        return invokeV.booleanValue;
    }

    public void E1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.E == 0) {
            this.E = 1;
        }
    }

    public c6b F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.M0;
        }
        return (c6b) invokeV.objValue;
    }

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public e6b G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.N0;
        }
        return (e6b) invokeV.objValue;
    }

    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.C;
        }
        return (String) invokeV.objValue;
    }

    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.B;
        }
        return invokeV.intValue;
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.D0++;
        }
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.a0;
        }
        return (String) invokeV.objValue;
    }

    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.D0--;
        }
    }

    public int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.Z;
        }
        return invokeV.intValue;
    }

    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.m.clear();
            this.m = null;
            this.l = false;
        }
    }

    public long P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.A0;
        }
        return invokeV.longValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.B0;
        }
        return (String) invokeV.objValue;
    }

    public gy4 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.q;
        }
        return (gy4) invokeV.objValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.F0;
        }
        return invokeV.booleanValue;
    }

    public String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public Boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return Boolean.valueOf(this.C0);
        }
        return (Boolean) invokeV.objValue;
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.E0;
        }
        return invokeV.intValue;
    }

    public Item W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.j0;
        }
        return (Item) invokeV.objValue;
    }

    public List<HeadItem> X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.i0;
        }
        return (List) invokeV.objValue;
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.K;
        }
        return (String) invokeV.objValue;
    }

    public sc5 Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.x;
        }
        return (sc5) invokeV.objValue;
    }

    public vc5 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.x0;
        }
        return (vc5) invokeV.objValue;
    }

    public NovelRecomCard b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.P0;
        }
        return (NovelRecomCard) invokeV.objValue;
    }

    public OriginalThreadInfo c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.Y;
        }
        return (OriginalThreadInfo) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            this.j++;
        }
    }

    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.D0;
        }
        return invokeV.intValue;
    }

    public TbRichText e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.n;
        }
        return (TbRichText) invokeV.objValue;
    }

    public String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.u;
        }
        return (String) invokeV.objValue;
    }

    public Boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.V0;
        }
        return (Boolean) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048653, this) == null) {
            this.j--;
        }
    }

    public SkinInfo h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.J;
        }
        return (SkinInfo) invokeV.objValue;
    }

    @Nullable
    public SpriteMemeInfo i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.W;
        }
        return (SpriteMemeInfo) invokeV.objValue;
    }

    public ArrayList<ura> j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.k;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            if (j0() != null) {
                return j0().size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return this.S;
        }
        return invokeV.intValue;
    }

    public int l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public SmallTailInfo m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.p;
        }
        return (SmallTailInfo) invokeV.objValue;
    }

    public AdverSegmentData o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.w0;
        }
        return (AdverSegmentData) invokeV.objValue;
    }

    public ThemeBubbleData o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            return this.K0;
        }
        return (ThemeBubbleData) invokeV.objValue;
    }

    public AgreeData p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.L;
        }
        return (AgreeData) invokeV.objValue;
    }

    public long p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return this.c;
        }
        return invokeV.longValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            return this.L.agreeType;
        }
        return invokeV.intValue;
    }

    public long q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public jz4 r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.O0;
        }
        return (jz4) invokeV.objValue;
    }

    @Nullable
    public AigcFeedbackInfo s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            return this.S0;
        }
        return (AigcFeedbackInfo) invokeV.objValue;
    }

    public HashMap<String, MetaData> s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return this.v;
        }
        return (HashMap) invokeV.objValue;
    }

    public MetaData t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.f;
        }
        return (MetaData) invokeV.objValue;
    }

    public String t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            return this.I;
        }
        return (String) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            if ((TextUtils.isEmpty(this.g) || this.g.equals("0")) && (metaData = this.f) != null) {
                return metaData.getUserId();
            }
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    public VirtualImageCustomFigure v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.H0;
        }
        return (VirtualImageCustomFigure) invokeV.objValue;
    }

    public List<BotReplyContent> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            return this.R0;
        }
        return (List) invokeV.objValue;
    }

    public VirtualImageCustomState w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            return this.I0;
        }
        return (VirtualImageCustomState) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            return this.Q0;
        }
        return (String) invokeV.objValue;
    }

    public List<CardLinkInfoData> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            return this.y0;
        }
        return (List) invokeV.objValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            AigcFeedbackInfo aigcFeedbackInfo = this.S0;
            if (aigcFeedbackInfo != null && !TextUtils.isEmpty(aigcFeedbackInfo.positive_text) && !TextUtils.isEmpty(this.S0.negative_text)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public lra z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            return this.V;
        }
        return (lra) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x01c2, code lost:
        if (r3.getIs_bawu() == 1) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void C1(TbPageContext tbPageContext, boolean z) {
        TbRichText tbRichText;
        String str;
        SpannableString spannableString;
        String str2;
        String str3;
        String str4;
        boolean z2;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        int i;
        boolean z3;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048583, this, tbPageContext, z) == null) && !this.d0 && tbPageContext != null && (tbRichText = this.n) != null && tbRichText.Q() != null) {
            BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                MetaData metaData = this.f;
                if (metaData != null && metaData.getIs_bawu() == 1) {
                    if (this.c0) {
                        str = " 品牌官";
                    } else if ("manager".equals(this.f.getBawu_type())) {
                        str = " 吧主";
                    } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(this.f.getBawu_type())) {
                        str = " 小吧主";
                    } else if ("pri_content_assist".equals(this.f.getBawu_type())) {
                        str = " 内容吧务";
                    } else if ("pri_manage_assist".equals(this.f.getBawu_type())) {
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
                    cj cjVar = new cj(new b(this, it.next(), uniqueId), 0, 1);
                    cjVar.b(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                    arrayList.add(cjVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                sb.append(i3);
            }
            if (!StringUtils.isNull(this.f.getSealPrefix())) {
                sb.append(" ");
                sb.append(this.f.getSealPrefix());
            }
            if (sb.length() > 0) {
                sb.append(" ");
            }
            String sb2 = sb.toString();
            if (this.f != null) {
                spannableString = new SpannableString(sb2 + this.f.getName_show() + str + "：");
                str2 = this.f.getUserName();
                str3 = this.f.getUserId();
                str4 = this.f.getTargetScheme();
            } else {
                spannableString = new SpannableString(sb2 + str + "：");
                str2 = null;
                str3 = null;
                str4 = null;
            }
            int i4 = 0;
            while (i4 < arrayList.size()) {
                int i5 = i4 + 1;
                spannableString.setSpan(arrayList.get(i4), i4, i5, 17);
                i4 = i5;
            }
            MetaData metaData2 = this.f;
            if (metaData2 != null && !StringUtils.isNull(metaData2.getSealPrefix())) {
                Bitmap bitmap = SkinManager.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                j55 j55Var = new j55(bitmapDrawable);
                j55Var.b(UtilHelper.getDimenPixelSize(R.dimen.obfuscated_res_0x7f0701d4));
                int size = arrayList.size() + this.f.getSealPrefix().length() + 1;
                spannableString.setSpan(j55Var, size, size + 1, 17);
            }
            spannableString.setSpan(new c(str2, str3, str4, this.U0), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str)) {
                if (!z) {
                    MetaData metaData3 = this.f;
                    if (metaData3 != null) {
                        i = 1;
                    }
                } else {
                    i = 1;
                }
                MetaData metaData4 = this.f;
                if (metaData4 != null && metaData4.getIs_bawu() == i) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                a55 e = e(z, z3, str);
                if (e != null) {
                    MetaData metaData5 = this.f;
                    if (metaData5 != null) {
                        if (metaData5.getName_show() != null) {
                            i2 = this.f.getName_show().length();
                        } else {
                            i2 = 0;
                        }
                        spannableString.setSpan(e, sb2.length() + i2 + 1, sb2.length() + i2 + str.length(), 17);
                    } else {
                        spannableString.setSpan(e, sb2.length(), sb2.length() + str.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> Q = this.n.Q();
            if (Q != null && Q.size() > 0) {
                TbRichTextData tbRichTextData2 = Q.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.a0() != null) {
                    if (this.X) {
                        int indexOf = tbRichTextData2.a0().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.a0().delete(0, indexOf + 1);
                        }
                        this.X = false;
                    }
                    tbRichTextData2.u0(sb.length());
                    tbRichTextData2.a0().insert(0, (CharSequence) spannableString);
                } else {
                    int i6 = 0;
                    while (true) {
                        if (i6 < Q.size()) {
                            if (Q.get(i6) != null && Q.get(i6).getType() == 512) {
                                tbRichTextVoiceInfo = Q.get(i6).g0();
                                Q.remove(i6);
                                break;
                            }
                            i6++;
                        } else {
                            tbRichTextVoiceInfo = null;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.x0(tbRichTextVoiceInfo);
                        z2 = true;
                    } else {
                        z2 = true;
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.u0(sb.length());
                    tbRichTextData.P(spannableString);
                    Q.add(0, tbRichTextData);
                    this.d0 = z2;
                }
            }
            z2 = true;
            this.d0 = z2;
        }
    }

    public boolean H0() {
        InterceptResult invokeV;
        SpriteMemeInfo spriteMemeInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (x0() == null && (spriteMemeInfo = this.W) != null && spriteMemeInfo.meme_id.longValue() > 0 && !TextUtils.isEmpty(this.W.use_same_text) && !TextUtils.isEmpty(this.W.use_same_guide)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String I() {
        InterceptResult invokeV;
        pra a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            PreLoadImageInfo H = H();
            if (H != null && !StringUtils.isNull(H.imgUrl)) {
                return H.imgUrl;
            }
            nra nraVar = this.z;
            if (nraVar != null && (a2 = nraVar.a()) != null && !StringUtils.isNull(a2.a())) {
                return a2.a();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void J0(SubPostList subPostList, boolean z, @Nullable ThreadData threadData, int i) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048599, this, new Object[]{subPostList, Boolean.valueOf(z), threadData, Integer.valueOf(i)}) != null) || subPostList == null) {
            return;
        }
        try {
            this.b = String.valueOf(subPostList.id);
            String str = subPostList.title;
            this.d = subPostList.floor.intValue();
            long intValue = subPostList.time.intValue() * 1000;
            this.e = intValue;
            StringHelper.getFormatTime(intValue);
            this.g = String.valueOf(subPostList.author_id);
            this.L.postId = this.b;
            this.L.parseProtobuf(subPostList.agree);
            MetaData metaData2 = new MetaData();
            metaData2.parserProtobuf(subPostList.author);
            if (this.g != null && this.g.length() > 0 && !this.g.equals("0") && this.v != null && (metaData = this.v.get(this.g)) != null) {
                this.f = metaData;
            }
            if (this.f.getUserId() == null || this.f.getUserId().length() <= 0 || this.f.getUserId().equals("0")) {
                this.f = metaData2;
            }
            TbRichText b0 = TbRichTextView.b0(subPostList.content, null, z, this, threadData, i);
            this.n = b0;
            if (b0 != null) {
                b0.X(JavaTypesHelper.toLong(this.b, -1L));
            }
            this.v0 = subPostList.is_author_view.intValue();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void L0(Post post, @Nullable ThreadData threadData) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048602, this, post, threadData) != null) || post == null) {
            return;
        }
        try {
            this.b = String.valueOf(post.id);
            long longValue = post.tid.longValue();
            this.c = longValue;
            if (longValue == 0 && threadData != null) {
                this.c = JavaTypesHelper.toLong(threadData.getTid(), 0L);
            }
            String str = post.title;
            this.d = post.floor.intValue();
            long intValue = post.time.intValue() * 1000;
            this.e = intValue;
            StringHelper.getFormatTime(intValue);
            String valueOf = String.valueOf(post.author_id);
            this.g = valueOf;
            if (valueOf != null && valueOf.length() > 0 && !this.g.equals("0") && this.v != null && (metaData = this.v.get(this.g)) != null) {
                this.f = metaData;
            }
            int i2 = 0;
            if (post.need_log.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.M = z;
            if (post.img_num_abtest.intValue() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.N = z2;
            dz4 dz4Var = new dz4();
            this.A = dz4Var;
            dz4Var.m(post.from_forum);
            if (this.f.getUserId() == null || this.f.getUserId().length() <= 0 || this.f.getUserId().equals("0")) {
                this.f.parserProtobuf(post.author);
            }
            if (this.f != null) {
                this.I = this.f.getUserName() + TbadkCoreApplication.getInst().getResources().getString(R.string.somebodys_portrait);
            }
            this.j = post.sub_post_number.intValue();
            this.z = new nra(post.tpoint_post);
            List<PbContent> list = post.content;
            this.s0 = post.content;
            post.is_wonderful_post.intValue();
            if (post.is_top_agree_post.intValue() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.e0 = z3;
            this.i0 = post.item_star;
            this.B = post.fold_comment_status.intValue();
            this.C = post.fold_comment_apply_url;
            if (post.item != null && post.item.item_id.longValue() != 0) {
                this.j0 = post.item;
            }
            if (this.j0 == null && post.outer_item != null && post.outer_item.item_id.longValue() > 0) {
                this.u0 = post.outer_item;
            }
            W0(post);
            this.O0 = jz4.e(post);
            TbRichText b0 = TbRichTextView.b0(list, String.valueOf(this.c), true, this, threadData, J());
            this.n = b0;
            if (b0 != null) {
                b0.X(JavaTypesHelper.toLong(this.b, -1L));
                this.n.W(this.d);
                if (this.f != null) {
                    this.n.setAuthorId(this.f.getUserId());
                }
                int count = ListUtils.getCount(this.i0);
                if (this.d == 1 && count != 0 && this.i0 != null) {
                    ArrayList<TbRichTextData> Q = this.n.Q();
                    if (count == 1) {
                        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(Q, 0);
                        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
                            tbRichTextData = new TbRichTextData(1);
                            ListUtils.add(Q, 0, tbRichTextData);
                        }
                        HeadItem headItem = (HeadItem) ListUtils.getItem(this.i0, 0);
                        if (headItem != null) {
                            try {
                                i = Integer.parseInt(headItem.content);
                            } catch (NumberFormatException unused) {
                                i = 0;
                            }
                            tbRichTextData.y0(hy5.s(i, false));
                        }
                    } else {
                        for (int size = this.i0.size() - 1; size >= 0; size--) {
                            HeadItem headItem2 = this.i0.get(size);
                            if (headItem2 != null) {
                                g(Q, headItem2);
                            }
                        }
                    }
                }
                if (this.d == 1 && this.j0 != null) {
                    TbRichTextData tbRichTextData2 = new TbRichTextData(1281);
                    tbRichTextData2.j0(new TbRichTextEvaluateItemInfo(this.j0));
                    ListUtils.add(this.n.Q(), tbRichTextData2);
                }
            }
            SubPost subPost = post.sub_post_list;
            if (subPost != null) {
                List<SubPostList> list2 = subPost.sub_post_list;
                if (list2.size() > 0) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        SubPostList subPostList = list2.get(i3);
                        ura uraVar = new ura();
                        uraVar.L.parseProtobuf(subPostList.agree);
                        uraVar.x1(this.v);
                        uraVar.a1(this.c0);
                        uraVar.J0(subPostList, false, threadData, J());
                        this.k.add(uraVar);
                    }
                }
            }
            ActPost actPost = post.act_post;
            if (actPost != null) {
                this.r.a(actPost);
            }
            this.s = post.bimg_url;
            this.t = post.dynamic_url;
            this.u = post.rumor_source_img;
            if (post.tail_info != null) {
                ic5 ic5Var = new ic5();
                this.w = ic5Var;
                ic5Var.b(post.tail_info);
            }
            if (post.lbs_info != null) {
                sc5 sc5Var = new sc5();
                this.x = sc5Var;
                sc5Var.c(post.lbs_info);
            }
            this.q.c(post.present);
            this.o.setUserMap(this.v);
            this.o.parserProtobuf(post.zan);
            if (post.signature != null) {
                SmallTailInfo smallTailInfo = new SmallTailInfo();
                this.p = smallTailInfo;
                smallTailInfo.id = post.signature.signature_id.intValue();
                this.p.color = post.signature.fontColor;
                if (post.signature.content != null && post.signature.content.size() != 0) {
                    this.p.content = new ArrayList();
                    for (SignatureContent signatureContent : post.signature.content) {
                        List<SmallTailInfo.SmallTailInfoContent> list3 = this.p.content;
                        SmallTailInfo smallTailInfo2 = new SmallTailInfo();
                        smallTailInfo2.getClass();
                        list3.add(new SmallTailInfo.SmallTailInfoContent(smallTailInfo2, signatureContent.text, signatureContent.type.intValue()));
                    }
                }
                this.p.updateShowInfo();
            }
            if (post.ext_tails != null) {
                for (int i4 = 0; i4 != post.ext_tails.size(); i4++) {
                    ic5 ic5Var2 = new ic5();
                    ic5Var2.b(post.ext_tails.get(i4));
                    this.H.add(ic5Var2);
                }
            }
            this.J = post.skin_info;
            this.K = post.lego_card;
            TPointPost tPointPost = post.tpoint_post;
            if (post.agree != null) {
                this.L.postId = this.b;
                this.L.parseProtobuf(post.agree);
            }
            if (post.is_post_visible.intValue() == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.f1164T = z4;
            if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.Y = originalThreadInfo;
                originalThreadInfo.o(post.origin_thread_info);
            } else {
                this.Y = null;
            }
            this.Z = post.is_fold.intValue();
            this.a0 = post.fold_tip;
            if (post.advertisement != null) {
                AdverSegmentData adverSegmentData = new AdverSegmentData();
                this.w0 = adverSegmentData;
                adverSegmentData.parse(post.advertisement);
            }
            if (post.novel_info != null) {
                vc5 vc5Var = new vc5();
                this.x0 = vc5Var;
                vc5Var.o(post.novel_info);
                if (!ListUtils.isEmpty(this.s0) && this.s0.get(0) != null) {
                    this.x0.p(this.s0.get(0).text);
                }
            }
            if (this.y0 == null) {
                this.y0 = new ArrayList();
            }
            if (post.card_link_info != null) {
                for (int i5 = 0; i5 < post.card_link_info.size(); i5++) {
                    CardLinkInfoData cardLinkInfoData = new CardLinkInfoData();
                    cardLinkInfoData.parse(post.card_link_info.get(i5));
                    this.y0.add(cardLinkInfoData);
                }
            }
            this.L0 = post.full_length_novel;
            if (post.bubble_info != null) {
                this.K0 = new ThemeBubbleData(post.bubble_info);
            }
            this.P0 = post.novel_recom_card;
            CallRobotEntrance callRobotEntrance = post.call_robot_entrance;
            String str2 = post.bot_reply_content;
            post.is_bot_reply.intValue();
            this.R0 = post.bot_reply_content_list;
            List<RobotSkill> list4 = post.robot_skill;
            this.S0 = post.aigc_feedback_info;
            if (post.aigc_feedback_info != null) {
                if (post.aigc_feedback_info.feedback_fold.intValue() == 1) {
                    i2 = 2;
                }
                this.T0 = i2;
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void T0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            try {
                if (this.n != null) {
                    ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(this.n.toString());
                    return;
                }
                if (this.i == null || this.i.size() == 0) {
                    D1();
                }
                ArrayList<rra> arrayList = this.i;
                if (arrayList != null) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<rra> it = arrayList.iterator();
                    while (it.hasNext()) {
                        rra next = it.next();
                        if (next.j() == 0) {
                            if (next.k() != null) {
                                sb.append((CharSequence) next.k());
                            }
                        } else if (next.j() == 3) {
                            if (next.g() != null) {
                                sb.append(TbadkCoreApplication.getInst().getResources().getString(R.string.pic_str));
                            }
                        } else if (next.j() == 6) {
                            sb.append(TbadkCoreApplication.getInst().getResources().getString(R.string.voice_str));
                        } else if (next.j() == 2) {
                            String j = TbFaceManager.i().j(next.i());
                            if (j != null) {
                                sb.append(PreferencesUtil.LEFT_MOUNT);
                                sb.append(j);
                                sb.append(PreferencesUtil.RIGHT_MOUNT);
                            }
                        } else if (next.j() == 11 && !qd.isEmpty(next.f())) {
                            sb.append(PreferencesUtil.LEFT_MOUNT);
                            sb.append(next.f());
                            sb.append(PreferencesUtil.RIGHT_MOUNT);
                        }
                    }
                    ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(sb.toString());
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (Q = tbRichText.Q()) == null) {
                return null;
            }
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            Iterator<TbRichTextData> it = Q.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8 && next.W() != null) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.W().getWidth();
                    preLoadImageInfo.height = next.W().getHeight();
                    if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.W().X()) {
                        preLoadImageInfo.imgUrl = next.W().R();
                        preLoadImageInfo.procType = 38;
                    } else {
                        preLoadImageInfo.imgUrl = next.W().Q();
                        preLoadImageInfo.procType = 17;
                    }
                    arrayList.add(preLoadImageInfo);
                } else if (next.R() != null) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.R().mGifInfo.mGifWidth;
                    preLoadImageInfo2.height = next.R().mGifInfo.mGifHeight;
                    preLoadImageInfo2.bigEmotion = next.R();
                    preLoadImageInfo2.procType = 20;
                    arrayList.add(preLoadImageInfo2);
                }
            }
            if (!TextUtils.isEmpty(this.s)) {
                PreLoadImageInfo preLoadImageInfo3 = new PreLoadImageInfo();
                preLoadImageInfo3.imgUrl = this.s;
                preLoadImageInfo3.width = 105;
                preLoadImageInfo3.width = 105;
                preLoadImageInfo3.procType = 19;
                arrayList.add(preLoadImageInfo3);
            }
            if (this.f == null) {
                return arrayList;
            }
            PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
            preLoadImageInfo4.imgUrl = this.f.getPortrait();
            preLoadImageInfo4.procType = 12;
            arrayList.add(preLoadImageInfo4);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> Q;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (Q = tbRichText.Q()) == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<TbRichTextData> it = Q.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 1) {
                    stringBuffer.append(next.a0().toString());
                } else if (next.getType() == 17) {
                    String str = next.R().mGifInfo.mSharpText;
                    if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                        String substring = str.substring(2, str.length() - 1);
                        stringBuffer.append(PreferencesUtil.LEFT_MOUNT + substring + PreferencesUtil.RIGHT_MOUNT);
                    }
                } else if (next.getType() == 8) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.editor_image) + PreferencesUtil.RIGHT_MOUNT);
                } else if (next.getType() == 512) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.msglist_voice) + PreferencesUtil.RIGHT_MOUNT);
                } else if (next.getType() == 32) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.video_title_str) + PreferencesUtil.RIGHT_MOUNT);
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void W0(Post post) {
        FestivalTipData festivalTipData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048624, this, post) == null) && post != null && (festivalTipData = post.festival_tip_data) != null && !TextUtils.isEmpty(festivalTipData.text)) {
            this.M0 = c6b.a(post.festival_tip_data);
            FestivalTipData festivalTipData2 = post.festival_tip_data;
            if (festivalTipData2.background_color != null && festivalTipData2.font_color != null) {
                this.N0 = e6b.a(festivalTipData2);
            }
        }
    }

    public void b(ura uraVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048633, this, uraVar) != null) || uraVar == null) {
            return;
        }
        if (this.m == null) {
            this.m = new ArrayList<>();
            int count = ListUtils.getCount(this.k);
            int i = this.t0;
            if (count > i) {
                this.m.addAll(ListUtils.subList(this.k, 0, i));
            } else {
                this.m.addAll(this.k);
            }
        }
        this.m.add(uraVar);
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048656, this, str) == null) && this.m != null && !StringUtils.isNull(str)) {
            ura uraVar = null;
            Iterator<ura> it = this.m.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ura next = it.next();
                if (next != null && str.equals(next.T())) {
                    uraVar = next;
                    break;
                }
            }
            if (uraVar != null) {
                this.m.remove(uraVar);
            }
        }
    }

    public final a55 e(boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048642, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (!z && !z2) {
                return null;
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.L_X01);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds26);
            int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds12);
            int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.tbds40);
            if (" 楼主".equals(str)) {
                a55 a55Var = new a55(dimenPixelSize, -1, (int) R.color.CAM_X0302, dimenPixelSize3, (int) R.color.CAM_X0302, dimenPixelSize4, dimenPixelSize5);
                a55Var.b(dimenPixelSize2);
                a55Var.f(false);
                a55Var.e(str);
                return a55Var;
            } else if (!" 吧主".equals(str) && !" 小吧主".equals(str) && !" 品牌官".equals(str)) {
                return null;
            } else {
                a55 a55Var2 = new a55(dimenPixelSize, -1, (int) R.color.CAM_X0302, dimenPixelSize3, (int) R.color.CAM_X0101, dimenPixelSize4, dimenPixelSize5);
                a55Var2.b(dimenPixelSize2);
                a55Var2.a(0.7f);
                a55Var2.f(true);
                a55Var2.e(str);
                return a55Var2;
            }
        }
        return (a55) invokeCommon.objValue;
    }

    public final void g(List<TbRichTextData> list, HeadItem headItem) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048648, this, list, headItem) == null) {
            TbRichTextData tbRichTextData = new TbRichTextData(1);
            StringBuilder sb = new StringBuilder();
            sb.append(headItem.name);
            sb.append(": ");
            if (headItem.type.intValue() == 1) {
                str = headItem.content;
            } else {
                str = " ";
            }
            sb.append(str);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(sb.toString()));
            if (headItem.type.intValue() == 2) {
                try {
                    i = Integer.parseInt(headItem.content);
                } catch (NumberFormatException unused) {
                    i = 0;
                }
                spannableStringBuilder.append((CharSequence) hy5.s(i, true));
            }
            tbRichTextData.P(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            int i = this.a;
            if (i == 52) {
                return d1;
            }
            if (i == 1) {
                return Z0;
            }
            if (i == 36) {
                return a1;
            }
            if (i != 40 && i != 50) {
                if (i == 41) {
                    return c1;
                }
                if (i == 53) {
                    return e1;
                }
                if (J() == 1) {
                    return W0;
                }
                sra sraVar = this.z0;
                if (sraVar != null && sraVar.h()) {
                    if (this.z0.i()) {
                        return AdvertAppInfo.I;
                    }
                    return AdvertAppInfo.K;
                } else if (this.G0) {
                    return Y0;
                } else {
                    return X0;
                }
            }
            return b1;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
