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
import com.baidu.tieba.mn;
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
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes7.dex */
public class rba implements PreLoadImageProvider, ym {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId V0;
    public static final BdUniqueId W0;
    public static final BdUniqueId X0;
    public static final BdUniqueId Y0;
    public static final BdUniqueId Z0;
    public static final BdUniqueId a1;
    public static final BdUniqueId b1;
    public static final BdUniqueId c1;
    public static final BdUniqueId d1;
    public static boolean e1;
    public transient /* synthetic */ FieldHolder $fh;
    public s35 A;
    public boolean A0;
    public int B;
    public int B0;
    public String C;
    public int C0;
    public boolean D;
    public boolean D0;
    public int E;
    public boolean E0;
    public t06 F;
    public VirtualImageCustomFigure F0;
    public TbRichTextVoiceInfo G;
    public VirtualImageCustomState G0;
    public ArrayList<eg5> H;
    public boolean H0;
    public String I;
    public ThemeBubbleData I0;
    public SkinInfo J;
    public FullLengthNovel J0;
    public String K;
    public kqa K0;
    public AgreeData L;
    public mqa L0;
    public boolean M;
    public y35 M0;
    public boolean N;
    public NovelRecomCard N0;
    public int O;
    public CallRobotEntrance O0;
    public boolean P;
    public String P0;
    public boolean Q;
    public List<BotReplyContent> Q0;
    public boolean R;
    public d R0;
    public int S;
    public Boolean S0;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1156T;
    public int T0;
    public AlaLiveInfoCoreData U;
    public int U0;
    public boolean V;
    public OriginalThreadInfo W;
    public int X;
    public String Y;
    public boolean Z;
    public int a;
    public boolean a0;
    public String b;
    public boolean b0;
    public long c;
    public boolean c0;
    public int d;
    public boolean d0;
    public long e;
    public int e0;
    public MetaData f;
    public StatisticItem f0;
    @Deprecated
    public String g;
    public List<HeadItem> g0;
    public ArrayList<oba> h;
    public Item h0;
    public ArrayList<oba> i;
    public boolean i0;
    public int j;
    public List<PbContent> j0;
    public ArrayList<rba> k;
    public boolean l;
    public ArrayList<rba> m;
    public TbRichText n;
    public PraiseData o;
    public SmallTailInfo p;
    public v25 q;
    public gba r;
    public int r0;
    public String s;
    public Item s0;
    public String t;
    public int t0;
    public String u;
    public AdverSegmentData u0;
    public HashMap<String, MetaData> v;
    public rg5 v0;
    public eg5 w;
    public List<CardLinkInfoData> w0;
    public og5 x;
    public pba x0;
    public boolean y;
    public long y0;
    public kba z;
    public String z0;

    /* loaded from: classes7.dex */
    public interface d {
        void onClick();
    }

    public void p1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, str) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public class b implements mn.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IconData a;
        public final /* synthetic */ BdUniqueId b;
        public final /* synthetic */ rba c;

        /* loaded from: classes7.dex */
        public class a extends BdResourceCallback<BdImage> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ mn a;
            public final /* synthetic */ b b;

            public a(b bVar, mn mnVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, mnVar};
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
                this.a = mnVar;
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

        public b(rba rbaVar, IconData iconData, BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rbaVar, iconData, bdUniqueId};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = rbaVar;
            this.a = iconData;
            this.b = bdUniqueId;
        }

        @Override // com.baidu.tieba.mn.a
        public Drawable a(mn mnVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, mnVar)) == null) {
                BdImage bdImage = (BdImage) BdResourceLoader.getInstance().loadResourceFromMemery(this.a.getIcon(), 21, new Object[0]);
                if (bdImage == null) {
                    BdResourceLoader.getInstance().loadResource(this.a.getIcon(), 21, new a(this, mnVar), this.b);
                }
                return this.c.f(bdImage);
            }
            return (Drawable) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rba a;

        public a(rba rbaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rbaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rbaVar;
        }

        @Override // com.baidu.tieba.rba.d
        public void onClick() {
            StatisticItem statisticItem;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (statisticItem = this.a.f0) != null) {
                StatisticItem copy = statisticItem.copy();
                copy.delete("obj_locate");
                copy.param("obj_locate", 7);
                TiebaStatic.log(copy);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public d c;

        public c(String str, String str2, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, dVar};
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
            this.a = str;
            this.b = str2;
            this.c = dVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null && this.b != null) {
                d dVar = this.c;
                if (dVar != null) {
                    dVar.onClick();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkCoreApplication.getInst(), this.b, this.a, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948117240, "Lcom/baidu/tieba/rba;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948117240, "Lcom/baidu/tieba/rba;");
                return;
            }
        }
        V0 = BdUniqueId.gen();
        W0 = BdUniqueId.gen();
        X0 = BdUniqueId.gen();
        Y0 = BdUniqueId.gen();
        Z0 = BdUniqueId.gen();
        a1 = BdUniqueId.gen();
        b1 = BdUniqueId.gen();
        c1 = BdUniqueId.gen();
        d1 = BdUniqueId.gen();
    }

    public t06 t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            t06 t06Var = this.F;
            if (t06Var != null) {
                return t06Var;
            }
            TbRichText tbRichText = this.n;
            if (tbRichText != null && ListUtils.getCount(tbRichText.P()) > 0) {
                Iterator<TbRichTextData> it = this.n.P().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 32) {
                        t06 e0 = next.e0();
                        this.F = e0;
                        return e0;
                    }
                }
                return null;
            }
            return null;
        }
        return (t06) invokeV.objValue;
    }

    public TbRichTextVoiceInfo w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = this.G;
            if (tbRichTextVoiceInfo != null) {
                return tbRichTextVoiceInfo;
            }
            TbRichText tbRichText = this.n;
            if (tbRichText != null && ListUtils.getCount(tbRichText.P()) > 0) {
                Iterator<TbRichTextData> it = this.n.P().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 512) {
                        TbRichTextVoiceInfo f0 = next.f0();
                        this.G = f0;
                        return f0;
                    }
                }
                return null;
            }
            return null;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public rba() {
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
        this.f1156T = false;
        this.V = false;
        this.X = 0;
        this.Z = true;
        this.b0 = false;
        this.c0 = false;
        this.d0 = false;
        this.i0 = false;
        this.r0 = 4;
        this.A0 = false;
        this.B0 = 0;
        this.D0 = false;
        this.E0 = false;
        this.R0 = new a(this);
        this.b = null;
        this.d = 0;
        this.e = 0L;
        this.f = new MetaData();
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.j = 0;
        this.k = new ArrayList<>();
        this.o = new PraiseData();
        this.q = new v25();
        this.r = new gba();
        this.H = new ArrayList<>();
        this.O = 0;
        this.L = new AgreeData();
        this.I0 = ThemeBubbleData.DEFAULT;
    }

    public PreLoadImageInfo G() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (P = tbRichText.P()) == null) {
                return null;
            }
            Iterator<TbRichTextData> it = P.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.V().getWidth();
                    preLoadImageInfo.height = next.V().getHeight();
                    preLoadImageInfo.imgUrl = next.V().O();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.Y().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.Y().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.Y().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return (PreLoadImageInfo) invokeV.objValue;
    }

    public String m0() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> P;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (P = tbRichText.P()) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<TbRichTextData> it = P.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    if (next.getType() == 1) {
                        if (next.Z() != null) {
                            sb.append(next.Z().toString());
                        }
                    } else if (next.getType() == 17) {
                        if (next.Q() != null && next.Q().mGifInfo != null && (str = next.Q().mGifInfo.mSharpText) != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
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

    public void x1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048694, this) != null) || this.h == null) {
            return;
        }
        int i = -1;
        int size = this.i.size();
        if (size > 0) {
            try {
                i = this.i.get(size - 1).getType();
            } catch (Exception e) {
                BdLog.detailException(e);
                return;
            }
        }
        for (int i2 = 0; i2 < this.h.size(); i2++) {
            oba obaVar = this.h.get(i2);
            if (oba.k(i, obaVar.getType())) {
                this.i.get(size - 1).e(obaVar.h());
            } else {
                if (obaVar.getType() != 3 && obaVar.getType() != 2 && obaVar.getType() != 11) {
                    oba obaVar2 = new oba();
                    obaVar2.l(0);
                    obaVar2.e(obaVar.h());
                    this.i.add(obaVar2);
                    i = 0;
                    size++;
                }
                this.i.add(obaVar);
                i = obaVar.getType();
                size++;
            }
        }
    }

    public void H0(Post post) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, post) == null) {
            I0(post, null);
        }
    }

    public void M0(AdverSegmentData adverSegmentData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, adverSegmentData) == null) {
            this.u0 = adverSegmentData;
        }
    }

    public void N0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, metaData) == null) {
            this.f = metaData;
        }
    }

    public void O0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.P0 = str;
        }
    }

    public void Q0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.S = i;
        }
    }

    public void S0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.d = i;
        }
    }

    public void T0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048613, this, j) == null) {
            this.y0 = j;
        }
    }

    public void U0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.z0 = str;
        }
    }

    public void V0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.a0 = z;
        }
    }

    public void W0(v25 v25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, v25Var) == null) {
            this.q = v25Var;
        }
    }

    public void X0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.D0 = z;
        }
    }

    public void Y0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
            this.b = str;
        }
    }

    public void Z0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.U0 = i;
        }
    }

    public void a1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048627, this, z) == null) {
            this.Z = z;
        }
    }

    public void b1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z) == null) {
            this.y = z;
        }
    }

    public void c(rba rbaVar) {
        ArrayList<rba> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048631, this, rbaVar) == null) && rbaVar != null && (arrayList = this.k) != null) {
            arrayList.add(rbaVar);
            d();
        }
    }

    public void c1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.V = z;
        }
    }

    public void d1(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, bool) == null) {
            this.A0 = bool.booleanValue();
        }
    }

    public void e1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            this.C0 = i;
        }
    }

    public Drawable f(BdImage bdImage) {
        InterceptResult invokeL;
        Bitmap rawBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, bdImage)) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.H0 = z;
        }
    }

    public void g1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            this.l = z;
        }
    }

    public void h1(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, originalThreadInfo) == null) {
            this.W = originalThreadInfo;
        }
    }

    public void i1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048653, this, i) == null) {
            this.a = i;
        }
    }

    public void j1(PraiseData praiseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, praiseData) == null) {
            this.o = praiseData;
        }
    }

    public void k1(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, tbRichText) == null) {
            this.n = tbRichText;
        }
    }

    public void l1(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, bool) == null) {
            this.S0 = bool;
        }
    }

    public void m1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048663, this, i) == null) {
            this.j = i;
        }
    }

    public void n1(SmallTailInfo smallTailInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, smallTailInfo) == null) {
            this.p = smallTailInfo;
        }
    }

    public void o1(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048669, this, j) == null) {
            this.e = j;
            StringHelper.getFormatTime(j);
        }
    }

    public void q1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048674, this, z) == null) {
            this.E0 = z;
        }
    }

    public void r1(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048677, this, hashMap) == null) {
            this.v = hashMap;
        }
    }

    public void s1(Post post) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, post) == null) {
            if (post.custom_figure != null) {
                VirtualImageCustomFigure virtualImageCustomFigure = new VirtualImageCustomFigure();
                this.F0 = virtualImageCustomFigure;
                virtualImageCustomFigure.parseProto(post.custom_figure);
            }
            if (post.custom_state != null) {
                VirtualImageCustomState virtualImageCustomState = new VirtualImageCustomState();
                this.G0 = virtualImageCustomState;
                virtualImageCustomState.parseProto(post.custom_state);
            }
        }
    }

    public void t1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048682, this, i) == null) {
            this.T0 = i;
        }
    }

    public boolean y0(boolean z) {
        InterceptResult invokeZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048696, this, z)) == null) {
            if (z) {
                i = 2;
            } else {
                i = 4;
            }
            if (j0() <= i && k0() > j0()) {
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public long A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.L.disAgreeNum;
        }
        return invokeV.longValue;
    }

    public boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i = this.S;
            if (i != 0 && i != 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a0;
        }
        return invokeV.booleanValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    public boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.H0;
        }
        return invokeV.booleanValue;
    }

    public ArrayList<rba> D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.m;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.Z;
        }
        return invokeV.booleanValue;
    }

    public kqa E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.K0;
        }
        return (kqa) invokeV.objValue;
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public mqa F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.L0;
        }
        return (mqa) invokeV.objValue;
    }

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public void J0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.B0++;
        }
    }

    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.C;
        }
        return (String) invokeV.objValue;
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.B0--;
        }
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.B;
        }
        return invokeV.intValue;
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.m.clear();
            this.m = null;
            this.l = false;
        }
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.Y;
        }
        return (String) invokeV.objValue;
    }

    public int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.X;
        }
        return invokeV.intValue;
    }

    public long O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.y0;
        }
        return invokeV.longValue;
    }

    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.z0;
        }
        return (String) invokeV.objValue;
    }

    public v25 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.q;
        }
        return (v25) invokeV.objValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.D0;
        }
        return invokeV.booleanValue;
    }

    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.U0;
        }
        return invokeV.intValue;
    }

    public Boolean U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return Boolean.valueOf(this.A0);
        }
        return (Boolean) invokeV.objValue;
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.C0;
        }
        return invokeV.intValue;
    }

    public Item W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.h0;
        }
        return (Item) invokeV.objValue;
    }

    public List<HeadItem> X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.g0;
        }
        return (List) invokeV.objValue;
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.K;
        }
        return (String) invokeV.objValue;
    }

    public og5 Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.x;
        }
        return (og5) invokeV.objValue;
    }

    public rg5 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.v0;
        }
        return (rg5) invokeV.objValue;
    }

    public NovelRecomCard b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.N0;
        }
        return (NovelRecomCard) invokeV.objValue;
    }

    public OriginalThreadInfo c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.W;
        }
        return (OriginalThreadInfo) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.j++;
        }
    }

    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.B0;
        }
        return invokeV.intValue;
    }

    public TbRichText e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.n;
        }
        return (TbRichText) invokeV.objValue;
    }

    public String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.u;
        }
        return (String) invokeV.objValue;
    }

    public Boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.S0;
        }
        return (Boolean) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048648, this) == null) {
            this.j--;
        }
    }

    public SkinInfo h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.J;
        }
        return (SkinInfo) invokeV.objValue;
    }

    public ArrayList<rba> i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.k;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            if (i0() != null) {
                return i0().size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.S;
        }
        return invokeV.intValue;
    }

    public SmallTailInfo l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.p;
        }
        return (SmallTailInfo) invokeV.objValue;
    }

    public AdverSegmentData n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return this.u0;
        }
        return (AdverSegmentData) invokeV.objValue;
    }

    public ThemeBubbleData n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.I0;
        }
        return (ThemeBubbleData) invokeV.objValue;
    }

    public AgreeData o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return this.L;
        }
        return (AgreeData) invokeV.objValue;
    }

    public long o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.c;
        }
        return invokeV.longValue;
    }

    public long p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            return this.L.agreeType;
        }
        return invokeV.intValue;
    }

    public y35 q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.M0;
        }
        return (y35) invokeV.objValue;
    }

    public MetaData r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return this.f;
        }
        return (MetaData) invokeV.objValue;
    }

    public HashMap<String, MetaData> r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            return this.v;
        }
        return (HashMap) invokeV.objValue;
    }

    public String s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.I;
        }
        return (String) invokeV.objValue;
    }

    public String t() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            if ((TextUtils.isEmpty(this.g) || this.g.equals("0")) && (metaData = this.f) != null) {
                return metaData.getUserId();
            }
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    public VirtualImageCustomFigure u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return this.F0;
        }
        return (VirtualImageCustomFigure) invokeV.objValue;
    }

    public boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            OriginalThreadInfo originalThreadInfo = this.W;
            if (originalThreadInfo == null || !originalThreadInfo.H || this.y0 != originalThreadInfo.e) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public List<BotReplyContent> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            return this.Q0;
        }
        return (List) invokeV.objValue;
    }

    public VirtualImageCustomState v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            return this.G0;
        }
        return (VirtualImageCustomState) invokeV.objValue;
    }

    public boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            y35 y35Var = this.M0;
            if (y35Var != null && y35Var.c()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return this.P0;
        }
        return (String) invokeV.objValue;
    }

    public CallRobotEntrance x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.O0;
        }
        return (CallRobotEntrance) invokeV.objValue;
    }

    public int x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            return this.T0;
        }
        return invokeV.intValue;
    }

    public List<CardLinkInfoData> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            return this.w0;
        }
        return (List) invokeV.objValue;
    }

    public void y1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048697, this) == null) && this.E == 0) {
            this.E = 1;
        }
    }

    public kba z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            return this.z;
        }
        return (kba) invokeV.objValue;
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            if (k0() > 0 && i0() != null && i0().size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void G0(SubPostList subPostList, boolean z, @Nullable ThreadData threadData, int i) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048588, this, new Object[]{subPostList, Boolean.valueOf(z), threadData, Integer.valueOf(i)}) != null) || subPostList == null) {
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
                b0.W(JavaTypesHelper.toLong(this.b, -1L));
            }
            this.t0 = subPostList.is_author_view.intValue();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public String H() {
        InterceptResult invokeV;
        mba a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            PreLoadImageInfo G = G();
            if (G != null && !StringUtils.isNull(G.imgUrl)) {
                return G.imgUrl;
            }
            kba kbaVar = this.z;
            if (kbaVar != null && (a2 = kbaVar.a()) != null && !StringUtils.isNull(a2.a())) {
                return a2.a();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void I0(Post post, @Nullable ThreadData threadData) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048592, this, post, threadData) != null) || post == null) {
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
            boolean z4 = true;
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
            s35 s35Var = new s35();
            this.A = s35Var;
            s35Var.l(post.from_forum);
            if (this.f.getUserId() == null || this.f.getUserId().length() <= 0 || this.f.getUserId().equals("0")) {
                this.f.parserProtobuf(post.author);
            }
            if (this.f != null) {
                this.I = this.f.getUserName() + TbadkCoreApplication.getInst().getResources().getString(R.string.somebodys_portrait);
            }
            this.j = post.sub_post_number.intValue();
            this.z = new kba(post.tpoint_post);
            List<PbContent> list = post.content;
            this.j0 = post.content;
            post.is_wonderful_post.intValue();
            if (post.is_top_agree_post.intValue() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.c0 = z3;
            this.g0 = post.item_star;
            this.B = post.fold_comment_status.intValue();
            this.C = post.fold_comment_apply_url;
            if (post.item != null && post.item.item_id.longValue() != 0) {
                this.h0 = post.item;
            }
            if (this.h0 == null && post.outer_item != null && post.outer_item.item_id.longValue() > 0) {
                this.s0 = post.outer_item;
            }
            R0(post);
            this.M0 = y35.e(post);
            TbRichText b0 = TbRichTextView.b0(list, String.valueOf(this.c), true, this, threadData, I());
            this.n = b0;
            if (b0 != null) {
                b0.W(JavaTypesHelper.toLong(this.b, -1L));
                this.n.V(this.d);
                if (this.f != null) {
                    this.n.setAuthorId(this.f.getUserId());
                }
                int count = ListUtils.getCount(this.g0);
                if (this.d == 1 && count != 0 && this.g0 != null) {
                    ArrayList<TbRichTextData> P = this.n.P();
                    if (count == 1) {
                        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(P, 0);
                        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
                            tbRichTextData = new TbRichTextData(1);
                            ListUtils.add(P, 0, tbRichTextData);
                        }
                        HeadItem headItem = (HeadItem) ListUtils.getItem(this.g0, 0);
                        if (headItem != null) {
                            try {
                                i = Integer.parseInt(headItem.content);
                            } catch (NumberFormatException unused) {
                                i = 0;
                            }
                            tbRichTextData.x0(o06.s(i, false));
                        }
                    } else {
                        for (int size = this.g0.size() - 1; size >= 0; size--) {
                            HeadItem headItem2 = this.g0.get(size);
                            if (headItem2 != null) {
                                g(P, headItem2);
                            }
                        }
                    }
                }
                if (this.d == 1 && this.h0 != null) {
                    TbRichTextData tbRichTextData2 = new TbRichTextData(1281);
                    tbRichTextData2.i0(new TbRichTextEvaluateItemInfo(this.h0));
                    ListUtils.add(this.n.P(), tbRichTextData2);
                }
            }
            SubPost subPost = post.sub_post_list;
            if (subPost != null) {
                List<SubPostList> list2 = subPost.sub_post_list;
                if (list2.size() > 0) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        SubPostList subPostList = list2.get(i2);
                        rba rbaVar = new rba();
                        rbaVar.L.parseProtobuf(subPostList.agree);
                        rbaVar.r1(this.v);
                        rbaVar.V0(this.a0);
                        rbaVar.G0(subPostList, false, threadData, I());
                        this.k.add(rbaVar);
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
                eg5 eg5Var = new eg5();
                this.w = eg5Var;
                eg5Var.b(post.tail_info);
            }
            if (post.lbs_info != null) {
                og5 og5Var = new og5();
                this.x = og5Var;
                og5Var.c(post.lbs_info);
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
                for (int i3 = 0; i3 != post.ext_tails.size(); i3++) {
                    eg5 eg5Var2 = new eg5();
                    eg5Var2.b(post.ext_tails.get(i3));
                    this.H.add(eg5Var2);
                }
            }
            this.J = post.skin_info;
            this.K = post.lego_card;
            TPointPost tPointPost = post.tpoint_post;
            if (post.agree != null) {
                this.L.postId = this.b;
                this.L.parseProtobuf(post.agree);
            }
            if (post.is_post_visible.intValue() != 1) {
                z4 = false;
            }
            this.f1156T = z4;
            if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.W = originalThreadInfo;
                originalThreadInfo.o(post.origin_thread_info);
            } else {
                this.W = null;
            }
            this.X = post.is_fold.intValue();
            this.Y = post.fold_tip;
            if (post.advertisement != null) {
                AdverSegmentData adverSegmentData = new AdverSegmentData();
                this.u0 = adverSegmentData;
                adverSegmentData.parse(post.advertisement);
            }
            if (post.novel_info != null) {
                rg5 rg5Var = new rg5();
                this.v0 = rg5Var;
                rg5Var.o(post.novel_info);
                if (!ListUtils.isEmpty(this.j0) && this.j0.get(0) != null) {
                    this.v0.p(this.j0.get(0).text);
                }
            }
            if (this.w0 == null) {
                this.w0 = new ArrayList();
            }
            if (post.card_link_info != null) {
                for (int i4 = 0; i4 < post.card_link_info.size(); i4++) {
                    CardLinkInfoData cardLinkInfoData = new CardLinkInfoData();
                    cardLinkInfoData.parse(post.card_link_info.get(i4));
                    this.w0.add(cardLinkInfoData);
                }
            }
            this.J0 = post.full_length_novel;
            if (post.bubble_info != null) {
                this.I0 = new ThemeBubbleData(post.bubble_info);
            }
            this.N0 = post.novel_recom_card;
            this.O0 = post.call_robot_entrance;
            String str2 = post.bot_reply_content;
            post.is_bot_reply.intValue();
            this.Q0 = post.bot_reply_content_list;
            List<RobotSkill> list4 = post.robot_skill;
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            try {
                if (this.n != null) {
                    ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(this.n.toString());
                    return;
                }
                if (this.i == null || this.i.size() == 0) {
                    x1();
                }
                ArrayList<oba> arrayList = this.i;
                if (arrayList != null) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<oba> it = arrayList.iterator();
                    while (it.hasNext()) {
                        oba next = it.next();
                        if (next.getType() == 0) {
                            if (next.j() != null) {
                                sb.append((CharSequence) next.j());
                            }
                        } else if (next.getType() == 3) {
                            if (next.g() != null) {
                                sb.append(TbadkCoreApplication.getInst().getResources().getString(R.string.pic_str));
                            }
                        } else if (next.getType() == 6) {
                            sb.append(TbadkCoreApplication.getInst().getResources().getString(R.string.voice_str));
                        } else if (next.getType() == 2) {
                            String j = TbFaceManager.i().j(next.i());
                            if (j != null) {
                                sb.append(PreferencesUtil.LEFT_MOUNT);
                                sb.append(j);
                                sb.append(PreferencesUtil.RIGHT_MOUNT);
                            }
                        } else if (next.getType() == 11 && !bi.isEmpty(next.f())) {
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
        ArrayList<TbRichTextData> P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (P = tbRichText.P()) == null) {
                return null;
            }
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            Iterator<TbRichTextData> it = P.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8 && next.V() != null) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.V().getWidth();
                    preLoadImageInfo.height = next.V().getHeight();
                    if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.V().U()) {
                        preLoadImageInfo.imgUrl = next.V().P();
                        preLoadImageInfo.procType = 38;
                    } else {
                        preLoadImageInfo.imgUrl = next.V().O();
                        preLoadImageInfo.procType = 17;
                    }
                    arrayList.add(preLoadImageInfo);
                } else if (next.Q() != null) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.Q().mGifInfo.mGifWidth;
                    preLoadImageInfo2.height = next.Q().mGifInfo.mGifHeight;
                    preLoadImageInfo2.bigEmotion = next.Q();
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

    public String m() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> P;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (P = tbRichText.P()) == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<TbRichTextData> it = P.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 1) {
                    stringBuffer.append(next.Z().toString());
                } else if (next.getType() == 17) {
                    String str = next.Q().mGifInfo.mSharpText;
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

    public final void R0(Post post) {
        FestivalTipData festivalTipData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048609, this, post) == null) && post != null && (festivalTipData = post.festival_tip_data) != null && !TextUtils.isEmpty(festivalTipData.text)) {
            this.K0 = kqa.a(post.festival_tip_data);
            FestivalTipData festivalTipData2 = post.festival_tip_data;
            if (festivalTipData2.background_color != null && festivalTipData2.font_color != null) {
                this.L0 = mqa.a(festivalTipData2);
            }
        }
    }

    public void b(rba rbaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048628, this, rbaVar) != null) || rbaVar == null) {
            return;
        }
        if (this.m == null) {
            this.m = new ArrayList<>();
            int count = ListUtils.getCount(this.k);
            int i = this.r0;
            if (count > i) {
                this.m.addAll(ListUtils.subList(this.k, 0, i));
            } else {
                this.m.addAll(this.k);
            }
        }
        this.m.add(rbaVar);
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048651, this, str) == null) && this.m != null && !StringUtils.isNull(str)) {
            rba rbaVar = null;
            Iterator<rba> it = this.m.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                rba next = it.next();
                if (next != null && str.equals(next.S())) {
                    rbaVar = next;
                    break;
                }
            }
            if (rbaVar != null) {
                this.m.remove(rbaVar);
            }
        }
    }

    public final d95 e(boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048637, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (!z && !z2) {
                return null;
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.L_X01);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds26);
            int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds12);
            int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.tbds40);
            if (" 楼主".equals(str)) {
                d95 d95Var = new d95(dimenPixelSize, -1, R.color.CAM_X0302, dimenPixelSize3, R.color.CAM_X0302, dimenPixelSize4, dimenPixelSize5);
                d95Var.b(dimenPixelSize2);
                d95Var.f(false);
                d95Var.e(str);
                return d95Var;
            } else if (!" 吧主".equals(str) && !" 小吧主".equals(str) && !" 品牌官".equals(str)) {
                return null;
            } else {
                d95 d95Var2 = new d95(dimenPixelSize, -1, R.color.CAM_X0302, dimenPixelSize3, R.color.CAM_X0101, dimenPixelSize4, dimenPixelSize5);
                d95Var2.b(dimenPixelSize2);
                d95Var2.a(0.7f);
                d95Var2.f(true);
                d95Var2.e(str);
                return d95Var2;
            }
        }
        return (d95) invokeCommon.objValue;
    }

    public final void g(List<TbRichTextData> list, HeadItem headItem) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048643, this, list, headItem) == null) {
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
                spannableStringBuilder.append((CharSequence) o06.s(i, true));
            }
            tbRichTextData.O(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            int i = this.a;
            if (i == 52) {
                return c1;
            }
            if (i == 1) {
                return Y0;
            }
            if (i == 36) {
                return Z0;
            }
            if (i != 40 && i != 50) {
                if (i == 41) {
                    return b1;
                }
                if (i == 53) {
                    return d1;
                }
                if (I() == 1) {
                    return V0;
                }
                pba pbaVar = this.x0;
                if (pbaVar != null && pbaVar.h()) {
                    if (this.x0.i()) {
                        return AdvertAppInfo.H;
                    }
                    return AdvertAppInfo.J;
                } else if (this.E0) {
                    return X0;
                } else {
                    return W0;
                }
            }
            return a1;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void w1(TbPageContext tbPageContext, boolean z) {
        TbRichText tbRichText;
        String str;
        SpannableString spannableString;
        String str2;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        boolean z2;
        int i;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048691, this, tbPageContext, z) == null) && !this.b0 && tbPageContext != null && (tbRichText = this.n) != null && tbRichText.P() != null) {
            BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                MetaData metaData2 = this.f;
                if (metaData2 != null && metaData2.getIs_bawu() == 1) {
                    if (this.a0) {
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
            ArrayList<IconData> tShowInfoNew = r().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator<IconData> it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    mn mnVar = new mn(new b(this, it.next(), uniqueId), 0, 1);
                    mnVar.b(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                    arrayList.add(mnVar);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sb.append(i2);
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
            MetaData metaData3 = this.f;
            if (metaData3 != null && !StringUtils.isNull(metaData3.getSealPrefix())) {
                Bitmap bitmap = SkinManager.getBitmap(R.drawable.pic_smalldot_title);
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                if (bitmap != null) {
                    bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
                }
                m95 m95Var = new m95(bitmapDrawable);
                m95Var.b(UtilHelper.getDimenPixelSize(R.dimen.obfuscated_res_0x7f0701d4));
                int size = arrayList.size() + this.f.getSealPrefix().length() + 1;
                spannableString.setSpan(m95Var, size, size + 1, 17);
            }
            spannableString.setSpan(new c(str2, str3, this.R0), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || ((metaData = this.f) != null && metaData.getIs_bawu() == 1))) {
                MetaData metaData4 = this.f;
                if (metaData4 != null && metaData4.getIs_bawu() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                d95 e = e(z, z2, str);
                if (e != null) {
                    MetaData metaData5 = this.f;
                    if (metaData5 != null) {
                        if (metaData5.getName_show() != null) {
                            i = this.f.getName_show().length();
                        } else {
                            i = 0;
                        }
                        spannableString.setSpan(e, sb2.length() + i + 1, sb2.length() + i + str.length(), 17);
                    } else {
                        spannableString.setSpan(e, sb2.length(), sb2.length() + str.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> P = this.n.P();
            if (P != null && P.size() > 0) {
                TbRichTextData tbRichTextData2 = P.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.Z() != null) {
                    if (this.V) {
                        int indexOf = tbRichTextData2.Z().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.Z().delete(0, indexOf + 1);
                        }
                        this.V = false;
                    }
                    tbRichTextData2.t0(sb.length());
                    tbRichTextData2.Z().insert(0, (CharSequence) spannableString);
                } else {
                    int i5 = 0;
                    while (true) {
                        if (i5 < P.size()) {
                            if (P.get(i5) != null && P.get(i5).getType() == 512) {
                                tbRichTextVoiceInfo = P.get(i5).f0();
                                P.remove(i5);
                                break;
                            }
                            i5++;
                        } else {
                            tbRichTextVoiceInfo = null;
                            break;
                        }
                    }
                    if (tbRichTextVoiceInfo != null) {
                        tbRichTextData = new TbRichTextData(768);
                        tbRichTextData.w0(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.t0(sb.length());
                    tbRichTextData.O(spannableString);
                    P.add(0, tbRichTextData);
                }
            }
            this.b0 = true;
        }
    }
}
