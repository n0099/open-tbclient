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
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.qn;
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
import tbclient.SubPost;
import tbclient.SubPostList;
import tbclient.TPointPost;
/* loaded from: classes8.dex */
public class tha implements PreLoadImageProvider, cn {
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
    public d45 A;
    public String A0;
    public int B;
    public boolean B0;
    public String C;
    public int C0;
    public boolean D;
    public int D0;
    public int E;
    public boolean E0;
    public i26 F;
    public boolean F0;
    public TbRichTextVoiceInfo G;
    public VirtualImageCustomFigure G0;
    public ArrayList<eh5> H;
    public VirtualImageCustomState H0;
    public String I;
    public boolean I0;
    public SkinInfo J;
    public ThemeBubbleData J0;
    public String K;
    public FullLengthNovel K0;
    public AgreeData L;
    public rwa L0;
    public boolean M;
    public twa M0;
    public boolean N;
    public j45 N0;
    public int O;
    public NovelRecomCard O0;
    public boolean P;
    public CallRobotEntrance P0;
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
    public kha V;
    public Boolean V0;
    public boolean W;
    public OriginalThreadInfo X;
    public int Y;
    public String Z;
    public int a;
    public boolean a0;
    public String b;
    public boolean b0;
    public long c;
    public boolean c0;
    public int d;
    public boolean d0;
    public long e;
    public boolean e0;
    public MetaData f;
    public int f0;
    @Deprecated
    public String g;
    public StatisticItem g0;
    public ArrayList<qha> h;
    public List<HeadItem> h0;
    public ArrayList<qha> i;
    public Item i0;
    public int j;
    public boolean j0;
    public ArrayList<tha> k;
    public boolean l;
    public ArrayList<tha> m;
    public TbRichText n;
    public PraiseData o;
    public SmallTailInfo p;
    public g35 q;
    public hha r;
    public List<PbContent> r0;
    public String s;
    public int s0;
    public String t;
    public Item t0;
    public String u;
    public int u0;
    public HashMap<String, MetaData> v;
    public AdverSegmentData v0;
    public eh5 w;
    public rh5 w0;
    public oh5 x;
    public List<CardLinkInfoData> x0;
    public boolean y;
    public rha y0;
    public mha z;
    public long z0;

    /* loaded from: classes8.dex */
    public interface d {
        void onClick();
    }

    public void d1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
        }
    }

    public void t1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048685, this, str) == null) {
        }
    }

    public void x1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048697, this, i) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class b implements qn.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IconData a;
        public final /* synthetic */ BdUniqueId b;
        public final /* synthetic */ tha c;

        /* loaded from: classes8.dex */
        public class a extends BdResourceCallback<BdImage> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ qn a;
            public final /* synthetic */ b b;

            public a(b bVar, qn qnVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, qnVar};
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
                this.a = qnVar;
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

        public b(tha thaVar, IconData iconData, BdUniqueId bdUniqueId) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {thaVar, iconData, bdUniqueId};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = thaVar;
            this.a = iconData;
            this.b = bdUniqueId;
        }

        @Override // com.baidu.tieba.qn.a
        public Drawable a(qn qnVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qnVar)) == null) {
                BdImage bdImage = (BdImage) BdResourceLoader.getInstance().loadResourceFromMemery(this.a.getIcon(), 21, new Object[0]);
                if (bdImage == null) {
                    BdResourceLoader.getInstance().loadResource(this.a.getIcon(), 21, new a(this, qnVar), this.b);
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
        public final /* synthetic */ tha a;

        public a(tha thaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {thaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = thaVar;
        }

        @Override // com.baidu.tieba.tha.d
        public void onClick() {
            StatisticItem statisticItem;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (statisticItem = this.a.g0) != null) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948182588, "Lcom/baidu/tieba/tha;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948182588, "Lcom/baidu/tieba/tha;");
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

    public i26 u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            i26 i26Var = this.F;
            if (i26Var != null) {
                return i26Var;
            }
            TbRichText tbRichText = this.n;
            if (tbRichText != null && ListUtils.getCount(tbRichText.O()) > 0) {
                Iterator<TbRichTextData> it = this.n.O().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 32) {
                        i26 d0 = next.d0();
                        this.F = d0;
                        return d0;
                    }
                }
                return null;
            }
            return null;
        }
        return (i26) invokeV.objValue;
    }

    public TbRichTextVoiceInfo x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = this.G;
            if (tbRichTextVoiceInfo != null) {
                return tbRichTextVoiceInfo;
            }
            TbRichText tbRichText = this.n;
            if (tbRichText != null && ListUtils.getCount(tbRichText.O()) > 0) {
                Iterator<TbRichTextData> it = this.n.O().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 512) {
                        TbRichTextVoiceInfo e0 = next.e0();
                        this.G = e0;
                        return e0;
                    }
                }
                return null;
            }
            return null;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public tha() {
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
        this.W = false;
        this.Y = 0;
        this.a0 = true;
        this.c0 = false;
        this.d0 = false;
        this.e0 = false;
        this.j0 = false;
        this.s0 = 4;
        this.B0 = false;
        this.C0 = 0;
        this.E0 = false;
        this.F0 = false;
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
        this.q = new g35();
        this.r = new hha();
        this.H = new ArrayList<>();
        this.O = 0;
        this.L = new AgreeData();
        this.J0 = ThemeBubbleData.DEFAULT;
    }

    public void B1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048580, this) != null) || this.h == null) {
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
            qha qhaVar = this.h.get(i2);
            if (qha.k(i, qhaVar.getType())) {
                this.i.get(size - 1).e(qhaVar.h());
            } else {
                if (qhaVar.getType() != 3 && qhaVar.getType() != 2 && qhaVar.getType() != 11) {
                    qha qhaVar2 = new qha();
                    qhaVar2.l(0);
                    qhaVar2.e(qhaVar.h());
                    this.i.add(qhaVar2);
                    i = 0;
                    size++;
                }
                this.i.add(qhaVar);
                i = qhaVar.getType();
                size++;
            }
        }
    }

    public PreLoadImageInfo J() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (O = tbRichText.O()) == null) {
                return null;
            }
            Iterator<TbRichTextData> it = O.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.U().getWidth();
                    preLoadImageInfo.height = next.U().getHeight();
                    preLoadImageInfo.imgUrl = next.U().N();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.X().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.X().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.X().memeInfo.pic_url;
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
        ArrayList<TbRichTextData> O;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (O = tbRichText.O()) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<TbRichTextData> it = O.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    if (next.getType() == 1) {
                        if (next.Y() != null) {
                            sb.append(next.Y().toString());
                        }
                    } else if (next.getType() == 17) {
                        if (next.P() != null && next.P().mGifInfo != null && (str = next.P().mGifInfo.mSharpText) != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
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

    public boolean H0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048593, this, z)) == null) {
            if (!A0() && !z0(z)) {
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public void J0(Post post) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, post) == null) {
            K0(post, null);
        }
    }

    public void O0(AdverSegmentData adverSegmentData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, adverSegmentData) == null) {
            this.v0 = adverSegmentData;
        }
    }

    public void P0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, metaData) == null) {
            this.f = metaData;
        }
    }

    public void Q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            this.Q0 = str;
        }
    }

    public void R0(@NonNull kha khaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, khaVar) == null) {
            this.V = khaVar;
        }
    }

    public void T0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            this.S = i;
        }
    }

    public void U0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.T0 = i;
        }
    }

    public void W0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.d = i;
        }
    }

    public void X0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048624, this, j) == null) {
            this.z0 = j;
        }
    }

    public void Y0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.A0 = str;
        }
    }

    public void Z0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048628, this, z) == null) {
            this.b0 = z;
        }
    }

    public void a1(g35 g35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, g35Var) == null) {
            this.q = g35Var;
        }
    }

    public void b1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.E0 = z;
        }
    }

    public void c(tha thaVar) {
        ArrayList<tha> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, thaVar) == null) && thaVar != null && (arrayList = this.k) != null) {
            arrayList.add(thaVar);
            d();
        }
    }

    public void c1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.b = str;
        }
    }

    public void e1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.a0 = z;
        }
    }

    public Drawable f(BdImage bdImage) {
        InterceptResult invokeL;
        Bitmap rawBitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, bdImage)) == null) {
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
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            this.y = z;
        }
    }

    public void g1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048648, this, z) == null) {
            this.W = z;
        }
    }

    public void h1(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, bool) == null) {
            this.B0 = bool.booleanValue();
        }
    }

    public void i1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048656, this, i) == null) {
            this.D0 = i;
        }
    }

    public void j1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z) == null) {
            this.I0 = z;
        }
    }

    public void k1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048660, this, z) == null) {
            this.l = z;
        }
    }

    public void l1(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048663, this, originalThreadInfo) == null) {
            this.X = originalThreadInfo;
        }
    }

    public void m1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048666, this, i) == null) {
            this.a = i;
        }
    }

    public void n1(PraiseData praiseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, praiseData) == null) {
            this.o = praiseData;
        }
    }

    public void o1(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, tbRichText) == null) {
            this.n = tbRichText;
        }
    }

    public void p1(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, bool) == null) {
            this.V0 = bool;
        }
    }

    public void q1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048677, this, i) == null) {
            this.j = i;
        }
    }

    public void r1(SmallTailInfo smallTailInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, smallTailInfo) == null) {
            this.p = smallTailInfo;
        }
    }

    public void s1(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048682, this, j) == null) {
            this.e = j;
            StringHelper.getFormatTime(j);
        }
    }

    public void u1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048688, this, z) == null) {
            this.F0 = z;
        }
    }

    public void v1(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048691, this, hashMap) == null) {
            this.v = hashMap;
        }
    }

    public void w1(Post post) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048694, this, post) == null) {
            if (post.custom_figure != null) {
                VirtualImageCustomFigure virtualImageCustomFigure = new VirtualImageCustomFigure();
                this.G0 = virtualImageCustomFigure;
                virtualImageCustomFigure.parseProto(post.custom_figure);
            }
            if (post.custom_state != null) {
                VirtualImageCustomState virtualImageCustomState = new VirtualImageCustomState();
                this.H0 = virtualImageCustomState;
                virtualImageCustomState.parseProto(post.custom_state);
            }
        }
    }

    public boolean z0(boolean z) {
        InterceptResult invokeZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048702, this, z)) == null) {
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

    public boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (l0() > 0 && j0() != null && j0().size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public kha B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.V;
        }
        return (kha) invokeV.objValue;
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

    public mha C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.z;
        }
        return (mha) invokeV.objValue;
    }

    public boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b0;
        }
        return invokeV.booleanValue;
    }

    public void C1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.E == 0) {
            this.E = 1;
        }
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    public boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.I0;
        }
        return invokeV.booleanValue;
    }

    public ArrayList<tha> E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.m;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a0;
        }
        return invokeV.booleanValue;
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.T0;
        }
        return invokeV.intValue;
    }

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public rwa G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.L0;
        }
        return (rwa) invokeV.objValue;
    }

    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public twa H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.M0;
        }
        return (twa) invokeV.objValue;
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.C0++;
        }
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.C;
        }
        return (String) invokeV.objValue;
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            this.C0--;
        }
    }

    public int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.B;
        }
        return invokeV.intValue;
    }

    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.m.clear();
            this.m = null;
            this.l = false;
        }
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.Z;
        }
        return (String) invokeV.objValue;
    }

    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.Y;
        }
        return invokeV.intValue;
    }

    public long Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.z0;
        }
        return invokeV.longValue;
    }

    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.A0;
        }
        return (String) invokeV.objValue;
    }

    public g35 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.q;
        }
        return (g35) invokeV.objValue;
    }

    public boolean T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.E0;
        }
        return invokeV.booleanValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public Boolean V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return Boolean.valueOf(this.B0);
        }
        return (Boolean) invokeV.objValue;
    }

    public int W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.D0;
        }
        return invokeV.intValue;
    }

    public Item X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.i0;
        }
        return (Item) invokeV.objValue;
    }

    public List<HeadItem> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.h0;
        }
        return (List) invokeV.objValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.K;
        }
        return (String) invokeV.objValue;
    }

    public oh5 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.x;
        }
        return (oh5) invokeV.objValue;
    }

    public rh5 b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.w0;
        }
        return (rh5) invokeV.objValue;
    }

    public NovelRecomCard c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.O0;
        }
        return (NovelRecomCard) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            this.j++;
        }
    }

    public OriginalThreadInfo d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.X;
        }
        return (OriginalThreadInfo) invokeV.objValue;
    }

    public int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.C0;
        }
        return invokeV.intValue;
    }

    public TbRichText f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.n;
        }
        return (TbRichText) invokeV.objValue;
    }

    public String g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.u;
        }
        return (String) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048651, this) == null) {
            this.j--;
        }
    }

    public Boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.V0;
        }
        return (Boolean) invokeV.objValue;
    }

    public SkinInfo i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.J;
        }
        return (SkinInfo) invokeV.objValue;
    }

    public ArrayList<tha> j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.k;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.S;
        }
        return invokeV.intValue;
    }

    public int l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public SmallTailInfo m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.p;
        }
        return (SmallTailInfo) invokeV.objValue;
    }

    public AdverSegmentData o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.v0;
        }
        return (AdverSegmentData) invokeV.objValue;
    }

    public ThemeBubbleData o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.J0;
        }
        return (ThemeBubbleData) invokeV.objValue;
    }

    public AgreeData p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            return this.L;
        }
        return (AgreeData) invokeV.objValue;
    }

    public long p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.c;
        }
        return invokeV.longValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return this.L.agreeType;
        }
        return invokeV.intValue;
    }

    public long q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public j45 r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.N0;
        }
        return (j45) invokeV.objValue;
    }

    @Nullable
    public AigcFeedbackInfo s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.S0;
        }
        return (AigcFeedbackInfo) invokeV.objValue;
    }

    public HashMap<String, MetaData> s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.v;
        }
        return (HashMap) invokeV.objValue;
    }

    public MetaData t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return this.f;
        }
        return (MetaData) invokeV.objValue;
    }

    public String t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return this.I;
        }
        return (String) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    public VirtualImageCustomFigure v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            return this.G0;
        }
        return (VirtualImageCustomFigure) invokeV.objValue;
    }

    public List<BotReplyContent> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.R0;
        }
        return (List) invokeV.objValue;
    }

    public VirtualImageCustomState w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) {
            return this.H0;
        }
        return (VirtualImageCustomState) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            return this.Q0;
        }
        return (String) invokeV.objValue;
    }

    public CallRobotEntrance y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            return this.P0;
        }
        return (CallRobotEntrance) invokeV.objValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            AigcFeedbackInfo aigcFeedbackInfo = this.S0;
            if (aigcFeedbackInfo != null && !TextUtils.isEmpty(aigcFeedbackInfo.positive_text) && !TextUtils.isEmpty(this.S0.negative_text)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            OriginalThreadInfo originalThreadInfo = this.X;
            if (originalThreadInfo == null || !originalThreadInfo.H || this.z0 != originalThreadInfo.e) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public List<CardLinkInfoData> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            return this.x0;
        }
        return (List) invokeV.objValue;
    }

    public boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            j45 j45Var = this.N0;
            if (j45Var != null && j45Var.c()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void A1(TbPageContext tbPageContext, boolean z) {
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
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, z) == null) && !this.c0 && tbPageContext != null && (tbRichText = this.n) != null && tbRichText.O() != null) {
            BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                MetaData metaData2 = this.f;
                if (metaData2 != null && metaData2.getIs_bawu() == 1) {
                    if (this.b0) {
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
                    qn qnVar = new qn(new b(this, it.next(), uniqueId), 0, 1);
                    qnVar.b(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                    arrayList.add(qnVar);
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
                da5 da5Var = new da5(bitmapDrawable);
                da5Var.b(UtilHelper.getDimenPixelSize(R.dimen.obfuscated_res_0x7f0701d4));
                int size = arrayList.size() + this.f.getSealPrefix().length() + 1;
                spannableString.setSpan(da5Var, size, size + 1, 17);
            }
            spannableString.setSpan(new c(str2, str3, this.U0), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || ((metaData = this.f) != null && metaData.getIs_bawu() == 1))) {
                MetaData metaData4 = this.f;
                if (metaData4 != null && metaData4.getIs_bawu() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                u95 e = e(z, z2, str);
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
            ArrayList<TbRichTextData> O = this.n.O();
            if (O != null && O.size() > 0) {
                TbRichTextData tbRichTextData2 = O.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.Y() != null) {
                    if (this.W) {
                        int indexOf = tbRichTextData2.Y().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.Y().delete(0, indexOf + 1);
                        }
                        this.W = false;
                    }
                    tbRichTextData2.s0(sb.length());
                    tbRichTextData2.Y().insert(0, (CharSequence) spannableString);
                } else {
                    int i5 = 0;
                    while (true) {
                        if (i5 < O.size()) {
                            if (O.get(i5) != null && O.get(i5).getType() == 512) {
                                tbRichTextVoiceInfo = O.get(i5).e0();
                                O.remove(i5);
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
                        tbRichTextData.v0(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.s0(sb.length());
                    tbRichTextData.N(spannableString);
                    O.add(0, tbRichTextData);
                }
            }
            this.c0 = true;
        }
    }

    public void I0(SubPostList subPostList, boolean z, @Nullable ThreadData threadData, int i) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048594, this, new Object[]{subPostList, Boolean.valueOf(z), threadData, Integer.valueOf(i)}) != null) || subPostList == null) {
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
                b0.V(JavaTypesHelper.toLong(this.b, -1L));
            }
            this.u0 = subPostList.is_author_view.intValue();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public String K() {
        InterceptResult invokeV;
        oha a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            PreLoadImageInfo J = J();
            if (J != null && !StringUtils.isNull(J.imgUrl)) {
                return J.imgUrl;
            }
            mha mhaVar = this.z;
            if (mhaVar != null && (a2 = mhaVar.a()) != null && !StringUtils.isNull(a2.a())) {
                return a2.a();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void K0(Post post, @Nullable ThreadData threadData) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048598, this, post, threadData) != null) || post == null) {
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
            d45 d45Var = new d45();
            this.A = d45Var;
            d45Var.m(post.from_forum);
            if (this.f.getUserId() == null || this.f.getUserId().length() <= 0 || this.f.getUserId().equals("0")) {
                this.f.parserProtobuf(post.author);
            }
            if (this.f != null) {
                this.I = this.f.getUserName() + TbadkCoreApplication.getInst().getResources().getString(R.string.somebodys_portrait);
            }
            this.j = post.sub_post_number.intValue();
            this.z = new mha(post.tpoint_post);
            List<PbContent> list = post.content;
            this.r0 = post.content;
            post.is_wonderful_post.intValue();
            if (post.is_top_agree_post.intValue() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.d0 = z3;
            this.h0 = post.item_star;
            this.B = post.fold_comment_status.intValue();
            this.C = post.fold_comment_apply_url;
            if (post.item != null && post.item.item_id.longValue() != 0) {
                this.i0 = post.item;
            }
            if (this.i0 == null && post.outer_item != null && post.outer_item.item_id.longValue() > 0) {
                this.t0 = post.outer_item;
            }
            V0(post);
            this.N0 = j45.e(post);
            TbRichText b0 = TbRichTextView.b0(list, String.valueOf(this.c), true, this, threadData, L());
            this.n = b0;
            if (b0 != null) {
                b0.V(JavaTypesHelper.toLong(this.b, -1L));
                this.n.U(this.d);
                if (this.f != null) {
                    this.n.setAuthorId(this.f.getUserId());
                }
                int count = ListUtils.getCount(this.h0);
                if (this.d == 1 && count != 0 && this.h0 != null) {
                    ArrayList<TbRichTextData> O = this.n.O();
                    if (count == 1) {
                        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(O, 0);
                        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
                            tbRichTextData = new TbRichTextData(1);
                            ListUtils.add(O, 0, tbRichTextData);
                        }
                        HeadItem headItem = (HeadItem) ListUtils.getItem(this.h0, 0);
                        if (headItem != null) {
                            try {
                                i = Integer.parseInt(headItem.content);
                            } catch (NumberFormatException unused) {
                                i = 0;
                            }
                            tbRichTextData.w0(d26.s(i, false));
                        }
                    } else {
                        for (int size = this.h0.size() - 1; size >= 0; size--) {
                            HeadItem headItem2 = this.h0.get(size);
                            if (headItem2 != null) {
                                g(O, headItem2);
                            }
                        }
                    }
                }
                if (this.d == 1 && this.i0 != null) {
                    TbRichTextData tbRichTextData2 = new TbRichTextData(1281);
                    tbRichTextData2.h0(new TbRichTextEvaluateItemInfo(this.i0));
                    ListUtils.add(this.n.O(), tbRichTextData2);
                }
            }
            SubPost subPost = post.sub_post_list;
            if (subPost != null) {
                List<SubPostList> list2 = subPost.sub_post_list;
                if (list2.size() > 0) {
                    for (int i3 = 0; i3 < list2.size(); i3++) {
                        SubPostList subPostList = list2.get(i3);
                        tha thaVar = new tha();
                        thaVar.L.parseProtobuf(subPostList.agree);
                        thaVar.v1(this.v);
                        thaVar.Z0(this.b0);
                        thaVar.I0(subPostList, false, threadData, L());
                        this.k.add(thaVar);
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
                eh5 eh5Var = new eh5();
                this.w = eh5Var;
                eh5Var.b(post.tail_info);
            }
            if (post.lbs_info != null) {
                oh5 oh5Var = new oh5();
                this.x = oh5Var;
                oh5Var.c(post.lbs_info);
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
                        this.p.content.add(new SmallTailInfo.SmallTailInfoContent(new SmallTailInfo(), signatureContent.text, signatureContent.type.intValue()));
                    }
                }
                this.p.updateShowInfo();
            }
            if (post.ext_tails != null) {
                for (int i4 = 0; i4 != post.ext_tails.size(); i4++) {
                    eh5 eh5Var2 = new eh5();
                    eh5Var2.b(post.ext_tails.get(i4));
                    this.H.add(eh5Var2);
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
                this.X = originalThreadInfo;
                originalThreadInfo.o(post.origin_thread_info);
            } else {
                this.X = null;
            }
            this.Y = post.is_fold.intValue();
            this.Z = post.fold_tip;
            if (post.advertisement != null) {
                AdverSegmentData adverSegmentData = new AdverSegmentData();
                this.v0 = adverSegmentData;
                adverSegmentData.parse(post.advertisement);
            }
            if (post.novel_info != null) {
                rh5 rh5Var = new rh5();
                this.w0 = rh5Var;
                rh5Var.o(post.novel_info);
                if (!ListUtils.isEmpty(this.r0) && this.r0.get(0) != null) {
                    this.w0.p(this.r0.get(0).text);
                }
            }
            if (this.x0 == null) {
                this.x0 = new ArrayList();
            }
            if (post.card_link_info != null) {
                for (int i5 = 0; i5 < post.card_link_info.size(); i5++) {
                    CardLinkInfoData cardLinkInfoData = new CardLinkInfoData();
                    cardLinkInfoData.parse(post.card_link_info.get(i5));
                    this.x0.add(cardLinkInfoData);
                }
            }
            this.K0 = post.full_length_novel;
            if (post.bubble_info != null) {
                this.J0 = new ThemeBubbleData(post.bubble_info);
            }
            this.O0 = post.novel_recom_card;
            this.P0 = post.call_robot_entrance;
            String str2 = post.bot_reply_content;
            post.is_bot_reply.intValue();
            this.R0 = post.bot_reply_content_list;
            List<RobotSkill> list3 = post.robot_skill;
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

    public void S0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            try {
                if (this.n != null) {
                    ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(this.n.toString());
                    return;
                }
                if (this.i == null || this.i.size() == 0) {
                    B1();
                }
                ArrayList<qha> arrayList = this.i;
                if (arrayList != null) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<qha> it = arrayList.iterator();
                    while (it.hasNext()) {
                        qha next = it.next();
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
                        } else if (next.getType() == 11 && !ei.isEmpty(next.f())) {
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
        ArrayList<TbRichTextData> O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (O = tbRichText.O()) == null) {
                return null;
            }
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            Iterator<TbRichTextData> it = O.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8 && next.U() != null) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.U().getWidth();
                    preLoadImageInfo.height = next.U().getHeight();
                    if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.U().T()) {
                        preLoadImageInfo.imgUrl = next.U().O();
                        preLoadImageInfo.procType = 38;
                    } else {
                        preLoadImageInfo.imgUrl = next.U().N();
                        preLoadImageInfo.procType = 17;
                    }
                    arrayList.add(preLoadImageInfo);
                } else if (next.P() != null) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.P().mGifInfo.mGifWidth;
                    preLoadImageInfo2.height = next.P().mGifInfo.mGifHeight;
                    preLoadImageInfo2.bigEmotion = next.P();
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
        ArrayList<TbRichTextData> O;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (O = tbRichText.O()) == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<TbRichTextData> it = O.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 1) {
                    stringBuffer.append(next.Y().toString());
                } else if (next.getType() == 17) {
                    String str = next.P().mGifInfo.mSharpText;
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

    public final void V0(Post post) {
        FestivalTipData festivalTipData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048620, this, post) == null) && post != null && (festivalTipData = post.festival_tip_data) != null && !TextUtils.isEmpty(festivalTipData.text)) {
            this.L0 = rwa.a(post.festival_tip_data);
            FestivalTipData festivalTipData2 = post.festival_tip_data;
            if (festivalTipData2.background_color != null && festivalTipData2.font_color != null) {
                this.M0 = twa.a(festivalTipData2);
            }
        }
    }

    public void b(tha thaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048631, this, thaVar) != null) || thaVar == null) {
            return;
        }
        if (this.m == null) {
            this.m = new ArrayList<>();
            int count = ListUtils.getCount(this.k);
            int i = this.s0;
            if (count > i) {
                this.m.addAll(ListUtils.subList(this.k, 0, i));
            } else {
                this.m.addAll(this.k);
            }
        }
        this.m.add(thaVar);
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048654, this, str) == null) && this.m != null && !StringUtils.isNull(str)) {
            tha thaVar = null;
            Iterator<tha> it = this.m.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                tha next = it.next();
                if (next != null && str.equals(next.U())) {
                    thaVar = next;
                    break;
                }
            }
            if (thaVar != null) {
                this.m.remove(thaVar);
            }
        }
    }

    public final u95 e(boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048640, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (!z && !z2) {
                return null;
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.L_X01);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds26);
            int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds12);
            int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.tbds40);
            if (" 楼主".equals(str)) {
                u95 u95Var = new u95(dimenPixelSize, -1, R.color.CAM_X0302, dimenPixelSize3, R.color.CAM_X0302, dimenPixelSize4, dimenPixelSize5);
                u95Var.b(dimenPixelSize2);
                u95Var.f(false);
                u95Var.e(str);
                return u95Var;
            } else if (!" 吧主".equals(str) && !" 小吧主".equals(str) && !" 品牌官".equals(str)) {
                return null;
            } else {
                u95 u95Var2 = new u95(dimenPixelSize, -1, R.color.CAM_X0302, dimenPixelSize3, R.color.CAM_X0101, dimenPixelSize4, dimenPixelSize5);
                u95Var2.b(dimenPixelSize2);
                u95Var2.a(0.7f);
                u95Var2.f(true);
                u95Var2.e(str);
                return u95Var2;
            }
        }
        return (u95) invokeCommon.objValue;
    }

    public final void g(List<TbRichTextData> list, HeadItem headItem) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048646, this, list, headItem) == null) {
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
                spannableStringBuilder.append((CharSequence) d26.s(i, true));
            }
            tbRichTextData.N(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
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
                if (L() == 1) {
                    return W0;
                }
                rha rhaVar = this.y0;
                if (rhaVar != null && rhaVar.h()) {
                    if (this.y0.i()) {
                        return AdvertAppInfo.H;
                    }
                    return AdvertAppInfo.J;
                } else if (this.F0) {
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
