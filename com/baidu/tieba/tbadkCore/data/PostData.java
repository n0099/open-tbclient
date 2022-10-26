package com.baidu.tieba.tbadkCore.data;

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
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.baidu.tieba.R;
import com.baidu.tieba.ah;
import com.baidu.tieba.dt4;
import com.baidu.tieba.eh;
import com.baidu.tieba.ej;
import com.baidu.tieba.eo;
import com.baidu.tieba.f45;
import com.baidu.tieba.fn8;
import com.baidu.tieba.h45;
import com.baidu.tieba.iy4;
import com.baidu.tieba.kn8;
import com.baidu.tieba.mn8;
import com.baidu.tieba.ol5;
import com.baidu.tieba.on8;
import com.baidu.tieba.p45;
import com.baidu.tieba.pn;
import com.baidu.tieba.pn8;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.ro;
import com.baidu.tieba.s45;
import com.baidu.tieba.tl5;
import com.baidu.tieba.zg;
import com.baidu.tieba.zt4;
import com.baidu.tieba.zx4;
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
import tbclient.FullLengthNovel;
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
public class PostData implements PreLoadImageProvider, eo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId K0;
    public static final BdUniqueId L0;
    public static final BdUniqueId M0;
    public static final BdUniqueId N0;
    public static final BdUniqueId O0;
    public static final BdUniqueId P0;
    public static final BdUniqueId Q0;
    public static final BdUniqueId R0;
    public static final BdUniqueId S0;
    public static boolean T0;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean A0;
    public String B;
    public boolean B0;
    public boolean C;
    public VirtualImageCustomFigure C0;
    public int D;
    public VirtualImageCustomState D0;
    public tl5 E;
    public boolean E0;
    public TbRichTextVoiceInfo F;
    public FullLengthNovel F0;
    public ArrayList<h45> G;
    public d G0;
    public String H;
    public Boolean H0;
    public SkinInfo I;
    public int I0;
    public String J;
    public int J0;
    public AgreeData K;
    public boolean L;
    public boolean M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public AlaLiveInfoCoreData S;
    public boolean T;
    public OriginalThreadInfo U;
    public int V;
    public String W;
    public boolean X;
    public boolean Y;
    public boolean Z;
    public int a;
    public boolean a0;
    public String b;
    public boolean b0;
    public long c;
    public int c0;
    public int d;
    public StatisticItem d0;
    public long e;
    public List<HeadItem> e0;
    public MetaData f;
    public Item f0;
    @Deprecated
    public String g;
    public boolean g0;
    public ArrayList<on8> h;
    public List<PbContent> h0;
    public ArrayList<on8> i;
    public int i0;
    public int j;
    public Item j0;
    public ArrayList<PostData> k;
    public boolean l;
    public ArrayList<PostData> m;
    public TbRichText n;
    public PraiseData o;
    public SmallTailInfo p;
    public dt4 q;
    public int q0;
    public fn8 r;
    public f45 r0;
    public String s;
    public s45 s0;
    public String t;
    public List<CardLinkInfoData> t0;
    public HashMap<String, MetaData> u;
    public pn8 u0;
    public h45 v;
    public long v0;
    public p45 w;
    public String w0;
    public boolean x;
    public boolean x0;
    public kn8 y;
    public int y0;
    public zt4 z;
    public int z0;

    /* loaded from: classes5.dex */
    public interface d {
        void onClick();
    }

    public void b1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, str) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ro.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IconData a;
        public final /* synthetic */ BdUniqueId b;
        public final /* synthetic */ PostData c;

        /* loaded from: classes5.dex */
        public class a extends zg {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ro a;
            public final /* synthetic */ b b;

            public a(b bVar, ro roVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, roVar};
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
                this.a = roVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.zg
            public void onLoaded(pn pnVar, String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(1048576, this, pnVar, str, i) == null) {
                    super.onLoaded((a) pnVar, str, i);
                    if (pnVar != null && pnVar.w()) {
                        this.a.a(this.b.c.h(pnVar));
                        this.b.c.n.isChanged = true;
                        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2004005));
                    }
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = postData;
            this.a = iconData;
            this.b = bdUniqueId;
        }

        @Override // com.baidu.tieba.ro.a
        public Drawable a(ro roVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, roVar)) == null) {
                pn pnVar = (pn) ah.h().n(this.a.getIcon(), 21, new Object[0]);
                if (pnVar == null) {
                    ah.h().m(this.a.getIcon(), 21, new a(this, roVar), this.b);
                }
                return this.c.h(pnVar);
            }
            return (Drawable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class CustomForegroundColorSpan extends ForegroundColorSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mColorId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomForegroundColorSpan(int i) {
            super(SkinManager.getColor(i));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mColorId = i;
        }

        @Override // android.text.style.ForegroundColorSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, textPaint) == null) {
                textPaint.setColor(SkinManager.getColor(this.mColorId));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostData a;

        public a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = postData;
        }

        @Override // com.baidu.tieba.tbadkCore.data.PostData.d
        public void onClick() {
            StatisticItem statisticItem;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (statisticItem = this.a.d0) != null) {
                StatisticItem copy = statisticItem.copy();
                copy.delete("obj_locate");
                copy.param("obj_locate", 7);
                TiebaStatic.log(copy);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends ClickableSpan {
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
                if (UbsABTestHelper.isPBPlanA()) {
                    textPaint.setColor(SkinManager.getColor(R.color.CAM_X0318));
                } else {
                    textPaint.setColor(SkinManager.getColor(R.color.CAM_X0108));
                }
                textPaint.setUnderlineText(false);
                textPaint.setFakeBoldText(!UbsABTestHelper.isPBPlanA());
            }
        }
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
        K0 = BdUniqueId.gen();
        L0 = BdUniqueId.gen();
        M0 = BdUniqueId.gen();
        N0 = BdUniqueId.gen();
        O0 = BdUniqueId.gen();
        P0 = BdUniqueId.gen();
        Q0 = BdUniqueId.gen();
        BdUniqueId.gen();
        R0 = BdUniqueId.gen();
        S0 = BdUniqueId.gen();
        BdUniqueId.gen();
    }

    public tl5 j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            tl5 tl5Var = this.E;
            if (tl5Var != null) {
                return tl5Var;
            }
            TbRichText tbRichText = this.n;
            if (tbRichText != null && ListUtils.getCount(tbRichText.B()) > 0) {
                Iterator<TbRichTextData> it = this.n.B().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 32) {
                        tl5 O = next.O();
                        this.E = O;
                        return O;
                    }
                }
                return null;
            }
            return null;
        }
        return (tl5) invokeV.objValue;
    }

    public TbRichTextVoiceInfo m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = this.F;
            if (tbRichTextVoiceInfo != null) {
                return tbRichTextVoiceInfo;
            }
            TbRichText tbRichText = this.n;
            if (tbRichText != null && ListUtils.getCount(tbRichText.B()) > 0) {
                Iterator<TbRichTextData> it = this.n.B().iterator();
                while (it.hasNext()) {
                    TbRichTextData next = it.next();
                    if (next != null && next.getType() == 512) {
                        TbRichTextVoiceInfo P = next.P();
                        this.F = P;
                        return P;
                    }
                }
                return null;
            }
            return null;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public PostData() {
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
        this.x = false;
        this.A = 0;
        this.D = 0;
        this.L = false;
        this.M = false;
        this.N = 0;
        this.O = true;
        this.Q = false;
        this.R = false;
        this.T = false;
        this.V = 0;
        this.X = true;
        this.Z = false;
        this.a0 = false;
        this.b0 = false;
        this.g0 = false;
        this.i0 = 4;
        this.x0 = false;
        this.y0 = 0;
        this.A0 = false;
        this.B0 = false;
        this.G0 = new a(this);
        this.b = null;
        this.d = 0;
        this.e = 0L;
        this.f = new MetaData();
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.j = 0;
        this.k = new ArrayList<>();
        this.o = new PraiseData();
        this.q = new dt4();
        this.r = new fn8();
        this.G = new ArrayList<>();
        this.N = 0;
        this.K = new AgreeData();
    }

    public PreLoadImageInfo B() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (B = tbRichText.B()) == null) {
                return null;
            }
            Iterator<TbRichTextData> it = B.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.F().getWidth();
                    preLoadImageInfo.height = next.F().getHeight();
                    preLoadImageInfo.imgUrl = next.F().B();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.I().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.I().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.I().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return (PreLoadImageInfo) invokeV.objValue;
    }

    public String e0() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> B;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (B = tbRichText.B()) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<TbRichTextData> it = B.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    if (next.getType() == 1) {
                        if (next.J() != null) {
                            sb.append(next.J().toString());
                        }
                    } else if (next.getType() == 17) {
                        if (next.C() != null && next.C().mGifInfo != null && (str = next.C().mGifInfo.mSharpText) != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
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

    public void i1() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048652, this) != null) || this.h == null) {
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
            on8 on8Var = this.h.get(i2);
            if (on8.k(i, on8Var.getType())) {
                this.i.get(size - 1).e(on8Var.h());
            } else {
                if (on8Var.getType() != 3 && on8Var.getType() != 2 && on8Var.getType() != 11) {
                    on8 on8Var2 = new on8();
                    on8Var2.l(0);
                    on8Var2.e(on8Var.h());
                    this.i.add(on8Var2);
                    i = 0;
                    size++;
                }
                this.i.add(on8Var);
                i = on8Var.getType();
                size++;
            }
        }
    }

    public void B0(f45 f45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, f45Var) == null) {
            this.r0 = f45Var;
        }
    }

    public void C0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, metaData) == null) {
            this.f = metaData;
        }
    }

    public void E0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.d = i;
        }
    }

    public void F0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.v0 = j;
        }
    }

    public void G0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.w0 = str;
        }
    }

    public void H0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.Y = z;
        }
    }

    public void I0(dt4 dt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, dt4Var) == null) {
            this.q = dt4Var;
        }
    }

    public void J0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.A0 = z;
        }
    }

    public void K0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.b = str;
        }
    }

    public void L0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.J0 = i;
        }
    }

    public void M0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.X = z;
        }
    }

    public void N0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.x = z;
        }
    }

    public void O0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.T = z;
        }
    }

    public void P0(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, bool) == null) {
            this.x0 = bool.booleanValue();
        }
    }

    public void Q0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.z0 = i;
        }
    }

    public void R0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.E0 = z;
        }
    }

    public void S0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.l = z;
        }
    }

    public void T0(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, originalThreadInfo) == null) {
            this.U = originalThreadInfo;
        }
    }

    public void U0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.a = i;
        }
    }

    public void V0(PraiseData praiseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, praiseData) == null) {
            this.o = praiseData;
        }
    }

    public void W0(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, tbRichText) == null) {
            this.n = tbRichText;
        }
    }

    public void X0(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, bool) == null) {
            this.H0 = bool;
        }
    }

    public void Y0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            this.j = i;
        }
    }

    public void Z0(SmallTailInfo smallTailInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, smallTailInfo) == null) {
            this.p = smallTailInfo;
        }
    }

    public void a1(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048629, this, j) == null) {
            this.e = j;
            StringHelper.getFormatTime(j);
        }
    }

    public void c(PostData postData) {
        ArrayList<PostData> arrayList;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048633, this, postData) == null) && postData != null && (arrayList = this.k) != null) {
            arrayList.add(postData);
            f();
        }
    }

    public void c1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.B0 = z;
        }
    }

    public void d1(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, hashMap) == null) {
            this.u = hashMap;
        }
    }

    public void e1(Post post) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, post) == null) {
            if (post.custom_figure != null) {
                VirtualImageCustomFigure virtualImageCustomFigure = new VirtualImageCustomFigure();
                this.C0 = virtualImageCustomFigure;
                virtualImageCustomFigure.parseProto(post.custom_figure);
            }
            if (post.custom_state != null) {
                VirtualImageCustomState virtualImageCustomState = new VirtualImageCustomState();
                this.D0 = virtualImageCustomState;
                virtualImageCustomState.parseProto(post.custom_state);
            }
        }
    }

    public void f1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i) == null) {
            this.I0 = i;
        }
    }

    public Drawable h(pn pnVar) {
        InterceptResult invokeL;
        Bitmap p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, pnVar)) == null) {
            if (pnVar == null || (p = pnVar.p()) == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
            bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
            return bitmapDrawable;
        }
        return (Drawable) invokeL.objValue;
    }

    public boolean o0(boolean z) {
        InterceptResult invokeZ;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048664, this, z)) == null) {
            if (z) {
                i = 2;
            } else {
                i = 4;
            }
            if (b0() <= i && c0() > b0()) {
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void w0(Post post) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048678, this, post) == null) {
            x0(post, null);
        }
    }

    public ArrayList<PostData> A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.m;
        }
        return (ArrayList) invokeV.objValue;
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.m.clear();
            this.m = null;
            this.l = false;
        }
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.B;
        }
        return (String) invokeV.objValue;
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.A;
        }
        return invokeV.intValue;
    }

    public String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.W;
        }
        return (String) invokeV.objValue;
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.V;
        }
        return invokeV.intValue;
    }

    public long I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.v0;
        }
        return invokeV.longValue;
    }

    public String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.w0;
        }
        return (String) invokeV.objValue;
    }

    public dt4 K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.q;
        }
        return (dt4) invokeV.objValue;
    }

    public boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.A0;
        }
        return invokeV.booleanValue;
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.J0;
        }
        return invokeV.intValue;
    }

    public Boolean O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return Boolean.valueOf(this.x0);
        }
        return (Boolean) invokeV.objValue;
    }

    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.z0;
        }
        return invokeV.intValue;
    }

    public Item Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.f0;
        }
        return (Item) invokeV.objValue;
    }

    public List<HeadItem> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.e0;
        }
        return (List) invokeV.objValue;
    }

    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.J;
        }
        return (String) invokeV.objValue;
    }

    public p45 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.w;
        }
        return (p45) invokeV.objValue;
    }

    public s45 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.s0;
        }
        return (s45) invokeV.objValue;
    }

    public OriginalThreadInfo V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.U;
        }
        return (OriginalThreadInfo) invokeV.objValue;
    }

    public int W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.y0;
        }
        return invokeV.intValue;
    }

    public TbRichText X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.n;
        }
        return (TbRichText) invokeV.objValue;
    }

    public Boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.H0;
        }
        return (Boolean) invokeV.objValue;
    }

    public SkinInfo Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.I;
        }
        return (SkinInfo) invokeV.objValue;
    }

    public ArrayList<PostData> a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.k;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            if (a0() != null) {
                return a0().size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public SmallTailInfo d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.p;
        }
        return (SmallTailInfo) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            this.j++;
        }
    }

    public long f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.c;
        }
        return invokeV.longValue;
    }

    public long g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            OriginalThreadInfo originalThreadInfo = this.U;
            if (originalThreadInfo == null || !originalThreadInfo.H || this.v0 != originalThreadInfo.e) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public HashMap<String, MetaData> h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.u;
        }
        return (HashMap) invokeV.objValue;
    }

    public String i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.H;
        }
        return (String) invokeV.objValue;
    }

    public void j1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048655, this) == null) && this.D == 0) {
            this.D = 1;
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            this.j--;
        }
    }

    public VirtualImageCustomFigure k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.C0;
        }
        return (VirtualImageCustomFigure) invokeV.objValue;
    }

    public VirtualImageCustomState l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.D0;
        }
        return (VirtualImageCustomState) invokeV.objValue;
    }

    public int n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.I0;
        }
        return invokeV.intValue;
    }

    public f45 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return this.r0;
        }
        return (f45) invokeV.objValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            if (c0() > 0 && a0() != null && a0().size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public AgreeData q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.K;
        }
        return (AgreeData) invokeV.objValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return this.Y;
        }
        return invokeV.booleanValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.K.agreeType;
        }
        return invokeV.intValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.E0;
        }
        return invokeV.booleanValue;
    }

    public MetaData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.f;
        }
        return (MetaData) invokeV.objValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.X;
        }
        return invokeV.booleanValue;
    }

    public String t() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            if ((TextUtils.isEmpty(this.g) || this.g.equals("0")) && (metaData = this.f) != null) {
                return metaData.getUserId();
            }
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.x;
        }
        return invokeV.booleanValue;
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    public List<CardLinkInfoData> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            return this.t0;
        }
        return (List) invokeV.objValue;
    }

    public kn8 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            return this.y;
        }
        return (kn8) invokeV.objValue;
    }

    public long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.K.disAgreeNum;
        }
        return invokeV.longValue;
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048682, this) == null) {
            this.y0++;
        }
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048684, this) == null) {
            this.y0--;
        }
    }

    public String C() {
        InterceptResult invokeV;
        mn8 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PreLoadImageInfo B = B();
            if (B != null && !StringUtils.isNull(B.imgUrl)) {
                return B.imgUrl;
            }
            kn8 kn8Var = this.y;
            if (kn8Var != null && (a2 = kn8Var.a()) != null && !StringUtils.isNull(a2.a())) {
                return a2.a();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                if (this.n != null) {
                    ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(this.n.toString());
                    return;
                }
                if (this.i == null || this.i.size() == 0) {
                    i1();
                }
                ArrayList<on8> arrayList = this.i;
                if (arrayList != null) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<on8> it = arrayList.iterator();
                    while (it.hasNext()) {
                        on8 next = it.next();
                        if (next.getType() == 0) {
                            if (next.j() != null) {
                                sb.append((CharSequence) next.j());
                            }
                        } else if (next.getType() == 3) {
                            if (next.g() != null) {
                                sb.append(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0eac));
                            }
                        } else if (next.getType() == 6) {
                            sb.append(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f15b8));
                        } else if (next.getType() == 2) {
                            String j = TbFaceManager.i().j(next.i());
                            if (j != null) {
                                sb.append(PreferencesUtil.LEFT_MOUNT);
                                sb.append(j);
                                sb.append(PreferencesUtil.RIGHT_MOUNT);
                            }
                        } else if (next.getType() == 11 && !ej.isEmpty(next.f())) {
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
        ArrayList<TbRichTextData> B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (B = tbRichText.B()) == null) {
                return null;
            }
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            Iterator<TbRichTextData> it = B.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8 && next.F() != null) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.F().getWidth();
                    preLoadImageInfo.height = next.F().getHeight();
                    if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.F().I()) {
                        preLoadImageInfo.imgUrl = next.F().C();
                        preLoadImageInfo.procType = 38;
                    } else {
                        preLoadImageInfo.imgUrl = next.F().B();
                        preLoadImageInfo.procType = 17;
                    }
                    arrayList.add(preLoadImageInfo);
                } else if (next.C() != null) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.C().mGifInfo.mGifWidth;
                    preLoadImageInfo2.height = next.C().mGifInfo.mGifHeight;
                    preLoadImageInfo2.bigEmotion = next.C();
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
        ArrayList<TbRichTextData> B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (B = tbRichText.B()) == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<TbRichTextData> it = B.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 1) {
                    stringBuffer.append(next.J().toString());
                } else if (next.getType() == 17) {
                    String str = next.C().mGifInfo.mSharpText;
                    if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                        String substring = str.substring(2, str.length() - 1);
                        stringBuffer.append(PreferencesUtil.LEFT_MOUNT + substring + PreferencesUtil.RIGHT_MOUNT);
                    }
                } else if (next.getType() == 8) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f054c) + PreferencesUtil.RIGHT_MOUNT);
                } else if (next.getType() == 512) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b25) + PreferencesUtil.RIGHT_MOUNT);
                } else if (next.getType() == 32) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1579) + PreferencesUtil.RIGHT_MOUNT);
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    public void b(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048630, this, postData) != null) || postData == null) {
            return;
        }
        if (this.m == null) {
            this.m = new ArrayList<>();
            int count = ListUtils.getCount(this.k);
            int i = this.i0;
            if (count > i) {
                this.m.addAll(ListUtils.subList(this.k, 0, i));
            } else {
                this.m.addAll(this.k);
            }
        }
        this.m.add(postData);
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048658, this, str) == null) && this.m != null && !StringUtils.isNull(str)) {
            Iterator<PostData> it = this.m.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && str.equals(next.M())) {
                    this.m.remove(next);
                    return;
                }
            }
        }
    }

    public final zx4 g(boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048643, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (!z && !z2) {
                return null;
            }
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.L_X01);
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds26);
            int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds12);
            int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.tbds40);
            if (" 楼主".equals(str)) {
                zx4 zx4Var = new zx4(dimenPixelSize, -1, R.color.CAM_X0302, dimenPixelSize3, R.color.CAM_X0302, dimenPixelSize4, dimenPixelSize5);
                zx4Var.b(dimenPixelSize2);
                zx4Var.f(false);
                zx4Var.e(str);
                return zx4Var;
            } else if (!" 吧主".equals(str) && !" 小吧主".equals(str) && !" 品牌官".equals(str)) {
                return null;
            } else {
                zx4 zx4Var2 = new zx4(dimenPixelSize, -1, R.color.CAM_X0302, dimenPixelSize3, R.color.CAM_X0101, dimenPixelSize4, dimenPixelSize5);
                zx4Var2.b(dimenPixelSize2);
                zx4Var2.a(0.7f);
                zx4Var2.f(true);
                zx4Var2.e(str);
                return zx4Var2;
            }
        }
        return (zx4) invokeCommon.objValue;
    }

    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            int i = this.a;
            if (i == 52) {
                return R0;
            }
            if (i == 1) {
                return N0;
            }
            if (i == 36) {
                return O0;
            }
            if (i != 40 && i != 50) {
                if (i == 41) {
                    return Q0;
                }
                if (i == 53) {
                    return S0;
                }
                if (D() == 1) {
                    return K0;
                }
                pn8 pn8Var = this.u0;
                if (pn8Var != null && pn8Var.h()) {
                    if (this.u0.i()) {
                        return AdvertAppInfo.G;
                    }
                    return AdvertAppInfo.I;
                } else if (this.B0) {
                    return M0;
                } else {
                    return L0;
                }
            }
            return P0;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void h1(TbPageContext tbPageContext, boolean z) {
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
        if ((interceptable == null || interceptable.invokeLZ(1048650, this, tbPageContext, z) == null) && !this.Z && tbPageContext != null && (tbRichText = this.n) != null && tbRichText.B() != null) {
            BdUniqueId uniqueId = tbPageContext.getUniqueId();
            if (z) {
                str = " 楼主";
            } else {
                MetaData metaData2 = this.f;
                if (metaData2 != null && metaData2.getIs_bawu() == 1) {
                    if (this.Y) {
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
            ArrayList tShowInfoNew = s().getTShowInfoNew();
            if (tShowInfoNew != null) {
                Iterator it = tShowInfoNew.iterator();
                while (it.hasNext()) {
                    ro roVar = new ro(new b(this, (IconData) it.next(), uniqueId), 0, 1);
                    roVar.b(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                    arrayList.add(roVar);
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
                iy4 iy4Var = new iy4(bitmapDrawable);
                iy4Var.b(UtilHelper.getDimenPixelSize(R.dimen.obfuscated_res_0x7f0701d4));
                int size = arrayList.size() + this.f.getSealPrefix().length() + 1;
                spannableString.setSpan(iy4Var, size, size + 1, 17);
            }
            spannableString.setSpan(new c(str2, str3, this.G0), 0, spannableString.length(), 18);
            if (!StringUtils.isNull(str) && (z || ((metaData = this.f) != null && metaData.getIs_bawu() == 1))) {
                MetaData metaData4 = this.f;
                if (metaData4 != null && metaData4.getIs_bawu() == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zx4 g = g(z, z2, str);
                if (g != null) {
                    MetaData metaData5 = this.f;
                    if (metaData5 != null) {
                        if (metaData5.getName_show() != null) {
                            i = this.f.getName_show().length();
                        } else {
                            i = 0;
                        }
                        spannableString.setSpan(g, sb2.length() + i + 1, sb2.length() + i + str.length(), 17);
                    } else {
                        spannableString.setSpan(g, sb2.length(), sb2.length() + str.length(), 17);
                    }
                }
            }
            ArrayList<TbRichTextData> B = this.n.B();
            if (B != null && B.size() > 0) {
                TbRichTextData tbRichTextData2 = B.get(0);
                if (tbRichTextData2 != null && tbRichTextData2.J() != null) {
                    if (this.T) {
                        int indexOf = tbRichTextData2.J().toString().indexOf("：");
                        if (indexOf > 0) {
                            tbRichTextData2.J().delete(0, indexOf + 1);
                        }
                        this.T = false;
                    }
                    tbRichTextData2.a0(sb.length());
                    tbRichTextData2.J().insert(0, (CharSequence) spannableString);
                } else {
                    int i5 = 0;
                    while (true) {
                        if (i5 < B.size()) {
                            if (B.get(i5) != null && B.get(i5).getType() == 512) {
                                tbRichTextVoiceInfo = B.get(i5).P();
                                B.remove(i5);
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
                        tbRichTextData.d0(tbRichTextVoiceInfo);
                    } else {
                        tbRichTextData = new TbRichTextData(1);
                    }
                    tbRichTextData.a0(sb.length());
                    tbRichTextData.A(spannableString);
                    B.add(0, tbRichTextData);
                }
            }
            this.Z = true;
        }
    }

    public final void j(List<TbRichTextData> list, HeadItem headItem) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048653, this, list, headItem) == null) {
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
                spannableStringBuilder.append((CharSequence) ol5.q(i, true));
            }
            tbRichTextData.A(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public void v0(SubPostList subPostList, boolean z, ThreadData threadData, int i) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048676, this, new Object[]{subPostList, Boolean.valueOf(z), threadData, Integer.valueOf(i)}) != null) || subPostList == null) {
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
            subPostList.is_giftpost.intValue();
            this.K.postId = this.b;
            this.K.parseProtobuf(subPostList.agree);
            MetaData metaData2 = new MetaData();
            metaData2.parserProtobuf(subPostList.author);
            if (this.g != null && this.g.length() > 0 && !this.g.equals("0") && this.u != null && (metaData = this.u.get(this.g)) != null) {
                this.f = metaData;
            }
            if (this.f.getUserId() == null || this.f.getUserId().length() <= 0 || this.f.getUserId().equals("0")) {
                this.f = metaData2;
            }
            TbRichText W = TbRichTextView.W(subPostList.content, null, z, this, threadData, i);
            this.n = W;
            if (W != null) {
                W.J(eh.g(this.b, -1L));
            }
            this.q0 = subPostList.is_author_view.intValue();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void x0(Post post, ThreadData threadData) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048680, this, post, threadData) != null) || post == null) {
            return;
        }
        try {
            this.b = String.valueOf(post.id);
            this.c = post.tid.longValue();
            String str = post.title;
            this.d = post.floor.intValue();
            long intValue = post.time.intValue() * 1000;
            this.e = intValue;
            StringHelper.getFormatTime(intValue);
            String str2 = post.time_ex;
            String valueOf = String.valueOf(post.author_id);
            this.g = valueOf;
            if (valueOf != null && valueOf.length() > 0 && !this.g.equals("0") && this.u != null && (metaData = this.u.get(this.g)) != null) {
                this.f = metaData;
            }
            boolean z4 = true;
            if (post.need_log.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.L = z;
            if (post.img_num_abtest.intValue() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.M = z2;
            zt4 zt4Var = new zt4();
            this.z = zt4Var;
            zt4Var.i(post.from_forum);
            if (this.f.getUserId() == null || this.f.getUserId().length() <= 0 || this.f.getUserId().equals("0")) {
                this.f.parserProtobuf(post.author);
            }
            if (this.f != null) {
                this.H = this.f.getUserName() + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11e1);
                String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04ac), Integer.valueOf(this.f.getLevel_id()));
            }
            post.is_ntitle.intValue();
            this.j = post.sub_post_number.intValue();
            this.y = new kn8(post.tpoint_post);
            List<PbContent> list = post.content;
            this.h0 = post.content;
            post.is_wonderful_post.intValue();
            if (post.is_top_agree_post.intValue() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.a0 = z3;
            this.e0 = post.item_star;
            this.A = post.fold_comment_status.intValue();
            this.B = post.fold_comment_apply_url;
            if (post.item != null && post.item.item_id.longValue() != 0) {
                this.f0 = post.item;
            }
            if (this.f0 == null && post.outer_item != null && post.outer_item.item_id.longValue() > 0) {
                this.j0 = post.outer_item;
            }
            TbRichText W = TbRichTextView.W(list, String.valueOf(post.tid), true, this, threadData, D());
            this.n = W;
            if (W != null) {
                W.J(eh.g(this.b, -1L));
                this.n.I(this.d);
                if (this.f != null) {
                    this.n.setAuthorId(this.f.getUserId());
                }
                int count = ListUtils.getCount(this.e0);
                if (this.d == 1 && count != 0 && this.e0 != null) {
                    ArrayList<TbRichTextData> B = this.n.B();
                    if (count == 1) {
                        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(B, 0);
                        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
                            tbRichTextData = new TbRichTextData(1);
                            ListUtils.add(B, 0, tbRichTextData);
                        }
                        HeadItem headItem = (HeadItem) ListUtils.getItem(this.e0, 0);
                        if (headItem != null) {
                            try {
                                i = Integer.parseInt(headItem.content);
                            } catch (NumberFormatException unused) {
                                i = 0;
                            }
                            tbRichTextData.e0(ol5.q(i, false));
                        }
                    } else {
                        for (int size = this.e0.size() - 1; size >= 0; size--) {
                            HeadItem headItem2 = this.e0.get(size);
                            if (headItem2 != null) {
                                j(B, headItem2);
                            }
                        }
                    }
                }
                if (this.d == 1 && this.f0 != null) {
                    TbRichTextData tbRichTextData2 = new TbRichTextData(1281);
                    tbRichTextData2.S(new TbRichTextEvaluateItemInfo(this.f0));
                    ListUtils.add(this.n.B(), tbRichTextData2);
                }
            }
            SubPost subPost = post.sub_post_list;
            if (subPost != null) {
                List<SubPostList> list2 = subPost.sub_post_list;
                if (list2.size() > 0) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        SubPostList subPostList = list2.get(i2);
                        PostData postData = new PostData();
                        subPostList.is_giftpost.intValue();
                        postData.K.parseProtobuf(subPostList.agree);
                        postData.d1(this.u);
                        postData.H0(this.Y);
                        postData.v0(subPostList, false, threadData, D());
                        this.k.add(postData);
                    }
                }
            }
            ActPost actPost = post.act_post;
            if (actPost != null) {
                this.r.a(actPost);
            }
            this.s = post.bimg_url;
            this.t = post.dynamic_url;
            if (post.tail_info != null) {
                h45 h45Var = new h45();
                this.v = h45Var;
                h45Var.b(post.tail_info);
            }
            if (post.lbs_info != null) {
                p45 p45Var = new p45();
                this.w = p45Var;
                p45Var.c(post.lbs_info);
            }
            post.storecount.intValue();
            this.q.c(post.present);
            this.o.setUserMap(this.u);
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
                    h45 h45Var2 = new h45();
                    h45Var2.b(post.ext_tails.get(i3));
                    this.G.add(h45Var2);
                }
            }
            this.I = post.skin_info;
            this.J = post.lego_card;
            TPointPost tPointPost = post.tpoint_post;
            if (post.agree != null) {
                this.K.postId = this.b;
                this.K.parseProtobuf(post.agree);
            }
            if (post.is_post_visible.intValue() != 1) {
                z4 = false;
            }
            this.R = z4;
            if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.U = originalThreadInfo;
                originalThreadInfo.o(post.origin_thread_info);
            } else {
                this.U = null;
            }
            this.V = post.is_fold.intValue();
            this.W = post.fold_tip;
            if (post.advertisement != null) {
                f45 f45Var = new f45();
                this.r0 = f45Var;
                f45Var.o(post.advertisement);
            }
            if (post.novel_info != null) {
                s45 s45Var = new s45();
                this.s0 = s45Var;
                s45Var.j(post.novel_info);
                if (!ListUtils.isEmpty(this.h0) && this.h0.get(0) != null) {
                    this.s0.k(this.h0.get(0).text);
                }
            }
            if (this.t0 == null) {
                this.t0 = new ArrayList();
            }
            if (post.card_link_info != null) {
                for (int i4 = 0; i4 < post.card_link_info.size(); i4++) {
                    CardLinkInfoData cardLinkInfoData = new CardLinkInfoData();
                    cardLinkInfoData.parse(post.card_link_info.get(i4));
                    this.t0.add(cardLinkInfoData);
                }
            }
            this.F0 = post.full_length_novel;
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}
