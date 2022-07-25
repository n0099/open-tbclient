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
import androidx.annotation.Nullable;
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
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextEvaluateItemInfo;
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
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.repackage.ao;
import com.repackage.ci8;
import com.repackage.cu4;
import com.repackage.e05;
import com.repackage.g05;
import com.repackage.hi8;
import com.repackage.ig;
import com.repackage.jg;
import com.repackage.ji8;
import com.repackage.ku4;
import com.repackage.li8;
import com.repackage.mi8;
import com.repackage.ng;
import com.repackage.nn;
import com.repackage.nq4;
import com.repackage.o05;
import com.repackage.oi;
import com.repackage.r05;
import com.repackage.rg5;
import com.repackage.rp4;
import com.repackage.wg5;
import com.repackage.ym;
import com.repackage.z05;
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
/* loaded from: classes4.dex */
public class PostData implements PreLoadImageProvider, nn {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId A0;
    public static final BdUniqueId B0;
    public static final BdUniqueId C0;
    public static final BdUniqueId D0;
    public static final BdUniqueId E0;
    public static final BdUniqueId F0;
    public static final BdUniqueId G0;
    public static boolean H0;
    public static final BdUniqueId z0;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean B;
    public int C;
    public wg5 D;
    public TbRichTextVoiceInfo E;
    public ArrayList<g05> F;
    public String G;
    public SkinInfo H;
    public String I;
    public AgreeData J;
    public boolean K;
    public boolean L;
    public int M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public AlaLiveInfoCoreData R;
    public boolean S;
    public OriginalThreadInfo T;
    public int U;
    public String V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public boolean Z;
    public int a;
    public boolean a0;
    public String b;
    public int b0;
    public long c;
    public StatisticItem c0;
    public int d;
    public List<HeadItem> d0;
    public long e;
    public Item e0;
    public MetaData f;
    public boolean f0;
    @Deprecated
    public String g;
    public List<PbContent> g0;
    public ArrayList<li8> h;
    public int h0;
    public ArrayList<li8> i;
    public Item i0;
    public int j;
    public int j0;
    public ArrayList<PostData> k;
    public boolean l;
    public ArrayList<PostData> m;
    public TbRichText n;
    public PraiseData o;
    public SmallTailInfo p;
    public rp4 q;
    public e05 q0;
    public ci8 r;
    public r05 r0;
    public String s;
    public List<CardLinkInfoData> s0;
    public HashMap<String, MetaData> t;
    public mi8 t0;
    public g05 u;
    public long u0;
    public o05 v;
    public String v0;
    public boolean w;
    public VirtualImageCustomFigure w0;
    public hi8 x;
    public z05 x0;
    public nq4 y;
    public d y0;
    public int z;

    /* loaded from: classes4.dex */
    public static class CustomForegroundColorSpan extends ForegroundColorSpan {
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

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (statisticItem = this.a.c0) == null) {
                return;
            }
            StatisticItem copy = statisticItem.copy();
            copy.delete("obj_locate");
            copy.param("obj_locate", 7);
            TiebaStatic.log(copy);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ao.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IconData a;
        public final /* synthetic */ BdUniqueId b;
        public final /* synthetic */ PostData c;

        /* loaded from: classes4.dex */
        public class a extends ig<ym> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ao a;
            public final /* synthetic */ b b;

            public a(b bVar, ao aoVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, aoVar};
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
                this.a = aoVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.ig
            public void onLoaded(ym ymVar, String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(1048576, this, ymVar, str, i) == null) {
                    super.onLoaded((a) ymVar, str, i);
                    if (ymVar == null || !ymVar.w()) {
                        return;
                    }
                    this.a.a(this.b.c.h(ymVar));
                    this.b.c.n.isChanged = true;
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

        @Override // com.repackage.ao.a
        public Drawable a(ao aoVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aoVar)) == null) {
                ym ymVar = (ym) jg.h().n(this.a.getIcon(), 21, new Object[0]);
                if (ymVar == null) {
                    jg.h().m(this.a.getIcon(), 21, new a(this, aoVar), this.b);
                }
                return this.c.h(ymVar);
            }
            return (Drawable) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a == null || this.b == null) {
                return;
            }
            d dVar = this.c;
            if (dVar != null) {
                dVar.onClick();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkCoreApplication.getInst(), this.b, this.a, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
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

    /* loaded from: classes4.dex */
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
        z0 = BdUniqueId.gen();
        A0 = BdUniqueId.gen();
        B0 = BdUniqueId.gen();
        C0 = BdUniqueId.gen();
        D0 = BdUniqueId.gen();
        E0 = BdUniqueId.gen();
        BdUniqueId.gen();
        F0 = BdUniqueId.gen();
        G0 = BdUniqueId.gen();
        BdUniqueId.gen();
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
        this.w = false;
        this.z = 0;
        this.C = 0;
        this.K = false;
        this.L = false;
        this.M = 0;
        this.N = true;
        this.P = false;
        this.Q = false;
        this.S = false;
        this.U = 0;
        this.W = true;
        this.Y = false;
        this.Z = false;
        this.a0 = false;
        this.f0 = false;
        this.h0 = 4;
        this.y0 = new a(this);
        this.b = null;
        this.d = 0;
        this.e = 0L;
        this.f = new MetaData();
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.j = 0;
        this.k = new ArrayList<>();
        this.o = new PraiseData();
        this.q = new rp4();
        this.r = new ci8();
        this.F = new ArrayList<>();
        this.M = 0;
        this.J = new AgreeData();
    }

    public String A() {
        InterceptResult invokeV;
        ji8 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            PreLoadImageInfo z = z();
            if (z != null && !StringUtils.isNull(z.imgUrl)) {
                return z.imgUrl;
            }
            hi8 hi8Var = this.x;
            if (hi8Var == null || (a2 = hi8Var.a()) == null || StringUtils.isNull(a2.c())) {
                return null;
            }
            return a2.c();
        }
        return (String) invokeV.objValue;
    }

    public void A0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.S = z;
        }
    }

    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : invokeV.intValue;
    }

    public void B0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.l = z;
        }
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    public void C0(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, originalThreadInfo) == null) {
            this.T = originalThreadInfo;
        }
    }

    public int D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.z : invokeV.intValue;
    }

    public void D0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a = i;
        }
    }

    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.V : (String) invokeV.objValue;
    }

    public void E0(PraiseData praiseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, praiseData) == null) {
            this.o = praiseData;
        }
    }

    public int F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.U : invokeV.intValue;
    }

    public void F0(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, tbRichText) == null) {
            this.n = tbRichText;
        }
    }

    public long G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.u0 : invokeV.longValue;
    }

    public void G0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.j = i;
        }
    }

    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.v0 : (String) invokeV.objValue;
    }

    public void H0(SmallTailInfo smallTailInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, smallTailInfo) == null) {
            this.p = smallTailInfo;
        }
    }

    public rp4 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.q : (rp4) invokeV.objValue;
    }

    public void I0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            this.e = j;
            StringHelper.getFormatTime(j);
        }
    }

    public String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public void J0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
        }
    }

    public Item K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.e0 : (Item) invokeV.objValue;
    }

    public void K0(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, hashMap) == null) {
            this.t = hashMap;
        }
    }

    public List<HeadItem> L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.d0 : (List) invokeV.objValue;
    }

    public void L0(Post post) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, post) == null) {
            if (post.custom_figure != null) {
                VirtualImageCustomFigure virtualImageCustomFigure = new VirtualImageCustomFigure();
                this.w0 = virtualImageCustomFigure;
                virtualImageCustomFigure.parseProto(post.custom_figure);
            }
            if (post.custom_state != null) {
                z05 z05Var = new z05();
                this.x0 = z05Var;
                z05Var.c(post.custom_state);
            }
        }
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.I : (String) invokeV.objValue;
    }

    public boolean M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            OriginalThreadInfo originalThreadInfo = this.T;
            return originalThreadInfo != null && originalThreadInfo.H && this.u0 == originalThreadInfo.e;
        }
        return invokeV.booleanValue;
    }

    public o05 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.v : (o05) invokeV.objValue;
    }

    public void N0(TbPageContext tbPageContext, boolean z) {
        TbRichText tbRichText;
        String str;
        SpannableString spannableString;
        String str2;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048603, this, tbPageContext, z) == null) || this.Y || tbPageContext == null || (tbRichText = this.n) == null || tbRichText.C() == null) {
            return;
        }
        BdUniqueId uniqueId = tbPageContext.getUniqueId();
        if (z) {
            str = " 楼主";
        } else {
            MetaData metaData2 = this.f;
            if (metaData2 != null && metaData2.getIs_bawu() == 1) {
                if (this.X) {
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
        ArrayList<IconData> tShowInfoNew = s().getTShowInfoNew();
        if (tShowInfoNew != null) {
            Iterator<IconData> it = tShowInfoNew.iterator();
            while (it.hasNext()) {
                ao aoVar = new ao(new b(this, it.next(), uniqueId), 0, 1);
                aoVar.b(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                arrayList.add(aoVar);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(i);
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
        int i2 = 0;
        while (i2 < arrayList.size()) {
            int i3 = i2 + 1;
            spannableString.setSpan(arrayList.get(i2), i2, i3, 17);
            i2 = i3;
        }
        MetaData metaData3 = this.f;
        if (metaData3 != null && !StringUtils.isNull(metaData3.getSealPrefix())) {
            Bitmap bitmap = SkinManager.getBitmap(R.drawable.pic_smalldot_title);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            if (bitmap != null) {
                bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            }
            ku4 ku4Var = new ku4(bitmapDrawable);
            ku4Var.b(UtilHelper.getDimenPixelSize(R.dimen.obfuscated_res_0x7f0701d4));
            int size = arrayList.size() + this.f.getSealPrefix().length() + 1;
            spannableString.setSpan(ku4Var, size, size + 1, 17);
        }
        spannableString.setSpan(new c(str2, str3, this.y0), 0, spannableString.length(), 18);
        if (!StringUtils.isNull(str) && (z || ((metaData = this.f) != null && metaData.getIs_bawu() == 1))) {
            MetaData metaData4 = this.f;
            cu4 g = g(z, metaData4 != null && metaData4.getIs_bawu() == 1, str);
            if (g != null) {
                MetaData metaData5 = this.f;
                if (metaData5 != null) {
                    int length = metaData5.getName_show() != null ? this.f.getName_show().length() : 0;
                    spannableString.setSpan(g, sb2.length() + length + 1, sb2.length() + length + str.length(), 17);
                } else {
                    spannableString.setSpan(g, sb2.length(), sb2.length() + str.length(), 17);
                }
            }
        }
        ArrayList<TbRichTextData> C = this.n.C();
        if (C != null && C.size() > 0) {
            TbRichTextData tbRichTextData2 = C.get(0);
            if (tbRichTextData2 != null && tbRichTextData2.K() != null) {
                if (this.S) {
                    int indexOf = tbRichTextData2.K().toString().indexOf("：");
                    if (indexOf > 0) {
                        tbRichTextData2.K().delete(0, indexOf + 1);
                    }
                    this.S = false;
                }
                tbRichTextData2.b0(sb.length());
                tbRichTextData2.K().insert(0, (CharSequence) spannableString);
            } else {
                int i4 = 0;
                while (true) {
                    if (i4 >= C.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (C.get(i4) != null && C.get(i4).getType() == 512) {
                        tbRichTextVoiceInfo = C.get(i4).Q();
                        C.remove(i4);
                        break;
                    } else {
                        i4++;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.e0(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.b0(sb.length());
                tbRichTextData.B(spannableString);
                C.add(0, tbRichTextData);
            }
        }
        this.Y = true;
    }

    public r05 O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.r0 : (r05) invokeV.objValue;
    }

    public void O0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || this.h == null) {
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
            li8 li8Var = this.h.get(i2);
            if (li8.k(i, li8Var.getType())) {
                this.i.get(size - 1).e(li8Var.h());
            } else {
                if (li8Var.getType() != 3 && li8Var.getType() != 2 && li8Var.getType() != 11) {
                    li8 li8Var2 = new li8();
                    li8Var2.l(0);
                    li8Var2.e(li8Var.h());
                    this.i.add(li8Var2);
                    i = 0;
                    size++;
                }
                this.i.add(li8Var);
                i = li8Var.getType();
                size++;
            }
        }
    }

    public OriginalThreadInfo P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.T : (OriginalThreadInfo) invokeV.objValue;
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && this.C == 0) {
            this.C = 1;
        }
    }

    public TbRichText Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.n : (TbRichText) invokeV.objValue;
    }

    public SkinInfo R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.H : (SkinInfo) invokeV.objValue;
    }

    public ArrayList<PostData> S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.k : (ArrayList) invokeV.objValue;
    }

    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            if (S() != null) {
                return S().size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.j : invokeV.intValue;
    }

    public SmallTailInfo V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.p : (SmallTailInfo) invokeV.objValue;
    }

    public String W() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> C;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (C = tbRichText.C()) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<TbRichTextData> it = C.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    if (next.getType() == 1) {
                        if (next.K() != null) {
                            sb.append(next.K().toString());
                        }
                    } else if (next.getType() == 17) {
                        if (next.D() != null && next.D().mGifInfo != null && (str = next.D().mGifInfo.mSharpText) != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
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

    public long X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.c : invokeV.longValue;
    }

    public long Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.e : invokeV.longValue;
    }

    public HashMap<String, MetaData> Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.t : (HashMap) invokeV.objValue;
    }

    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.G : (String) invokeV.objValue;
    }

    public void b(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, postData) == null) || postData == null) {
            return;
        }
        if (this.m == null) {
            this.m = new ArrayList<>();
            int count = ListUtils.getCount(this.k);
            int i = this.h0;
            if (count > i) {
                this.m.addAll(ListUtils.subList(this.k, 0, i));
            } else {
                this.m.addAll(this.k);
            }
        }
        this.m.add(postData);
    }

    public wg5 b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            wg5 wg5Var = this.D;
            if (wg5Var != null) {
                return wg5Var;
            }
            TbRichText tbRichText = this.n;
            if (tbRichText == null || ListUtils.getCount(tbRichText.C()) <= 0) {
                return null;
            }
            Iterator<TbRichTextData> it = this.n.C().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    wg5 P = next.P();
                    this.D = P;
                    return P;
                }
            }
            return null;
        }
        return (wg5) invokeV.objValue;
    }

    public void c(PostData postData) {
        ArrayList<PostData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, postData) == null) || postData == null || (arrayList = this.k) == null) {
            return;
        }
        arrayList.add(postData);
        d();
    }

    public VirtualImageCustomFigure c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.w0 : (VirtualImageCustomFigure) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.j++;
        }
    }

    public z05 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.x0 : (z05) invokeV.objValue;
    }

    public TbRichTextVoiceInfo e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = this.E;
            if (tbRichTextVoiceInfo != null) {
                return tbRichTextVoiceInfo;
            }
            TbRichText tbRichText = this.n;
            if (tbRichText == null || ListUtils.getCount(tbRichText.C()) <= 0) {
                return null;
            }
            Iterator<TbRichTextData> it = this.n.C().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    TbRichTextVoiceInfo Q = next.Q();
                    this.E = Q;
                    return Q;
                }
            }
            return null;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public boolean f0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048626, this, z)) == null) {
            return T() <= (z ? 2 : 4) && U() > T();
        }
        return invokeZ.booleanValue;
    }

    public final cu4 g(boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048627, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (z || z2) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.L_X01);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds26);
                int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds12);
                int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.tbds40);
                if (" 楼主".equals(str)) {
                    cu4 cu4Var = new cu4(dimenPixelSize, -1, R.color.CAM_X0302, dimenPixelSize3, R.color.CAM_X0302, dimenPixelSize4, dimenPixelSize5);
                    cu4Var.b(dimenPixelSize2);
                    cu4Var.f(false);
                    cu4Var.e(str);
                    return cu4Var;
                } else if (" 吧主".equals(str) || " 小吧主".equals(str) || " 品牌官".equals(str)) {
                    cu4 cu4Var2 = new cu4(dimenPixelSize, -1, R.color.CAM_X0302, dimenPixelSize3, R.color.CAM_X0101, dimenPixelSize4, dimenPixelSize5);
                    cu4Var2.b(dimenPixelSize2);
                    cu4Var2.a(0.7f);
                    cu4Var2.f(true);
                    cu4Var2.e(str);
                    return cu4Var2;
                } else {
                    return null;
                }
            }
            return null;
        }
        return (cu4) invokeCommon.objValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? U() > 0 && S() != null && S().size() > 0 : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (C = tbRichText.C()) == null) {
                return null;
            }
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            Iterator<TbRichTextData> it = C.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8 && next.G() != null) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.G().getWidth();
                    preLoadImageInfo.height = next.G().getHeight();
                    if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.G().J()) {
                        preLoadImageInfo.imgUrl = next.G().D();
                        preLoadImageInfo.procType = 38;
                    } else {
                        preLoadImageInfo.imgUrl = next.G().C();
                        preLoadImageInfo.procType = 17;
                    }
                    arrayList.add(preLoadImageInfo);
                } else if (next.D() != null) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.D().mGifInfo.mGifWidth;
                    preLoadImageInfo2.height = next.D().mGifInfo.mGifHeight;
                    preLoadImageInfo2.bigEmotion = next.D();
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

    @Override // com.repackage.nn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            int i = this.a;
            if (i == 52) {
                return F0;
            }
            if (i == 1) {
                return B0;
            }
            if (i == 36) {
                return C0;
            }
            if (i == 40 || i == 50) {
                return D0;
            }
            if (i == 41) {
                return E0;
            }
            if (i == 53) {
                return G0;
            }
            if (B() == 1) {
                return z0;
            }
            mi8 mi8Var = this.t0;
            if (mi8Var == null || !mi8Var.f()) {
                return A0;
            }
            return this.t0.g() ? AdvertAppInfo.D : AdvertAppInfo.F;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public Drawable h(ym ymVar) {
        InterceptResult invokeL;
        Bitmap p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, ymVar)) == null) {
            if (ymVar == null || (p = ymVar.p()) == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
            bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
            return bitmapDrawable;
        }
        return (Drawable) invokeL.objValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.X : invokeV.booleanValue;
    }

    public final void i(List<TbRichTextData> list, HeadItem headItem) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048633, this, list, headItem) == null) {
            TbRichTextData tbRichTextData = new TbRichTextData(1);
            StringBuilder sb = new StringBuilder();
            sb.append(headItem.name);
            sb.append(": ");
            sb.append(headItem.type.intValue() == 1 ? headItem.content : " ");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new SpannableString(sb.toString()));
            if (headItem.type.intValue() == 2) {
                try {
                    i = Integer.parseInt(headItem.content);
                } catch (NumberFormatException unused) {
                    i = 0;
                }
                spannableStringBuilder.append((CharSequence) rg5.q(i, true));
            }
            tbRichTextData.B(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.W : invokeV.booleanValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            this.j--;
        }
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048638, this, str) == null) || this.m == null || StringUtils.isNull(str)) {
            return;
        }
        Iterator<PostData> it = this.m.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null && str.equals(next.J())) {
                this.m.remove(next);
                return;
            }
        }
    }

    public void l0(SubPostList subPostList, boolean z, @Nullable ThreadData threadData, int i) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048639, this, new Object[]{subPostList, Boolean.valueOf(z), threadData, Integer.valueOf(i)}) == null) || subPostList == null) {
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
            this.J.postId = this.b;
            this.J.parseProtobuf(subPostList.agree);
            MetaData metaData2 = new MetaData();
            metaData2.parserProtobuf(subPostList.author);
            if (this.g != null && this.g.length() > 0 && !this.g.equals("0") && this.t != null && (metaData = this.t.get(this.g)) != null) {
                this.f = metaData;
            }
            if (this.f.getUserId() == null || this.f.getUserId().length() <= 0 || this.f.getUserId().equals("0")) {
                this.f = metaData2;
            }
            TbRichText W = TbRichTextView.W(subPostList.content, null, z, this, threadData, i);
            this.n = W;
            if (W != null) {
                W.K(ng.g(this.b, -1L));
            }
            this.j0 = subPostList.is_author_view.intValue();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public String m() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (C = tbRichText.C()) == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<TbRichTextData> it = C.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 1) {
                    stringBuffer.append(next.K().toString());
                } else if (next.getType() == 17) {
                    String str = next.D().mGifInfo.mSharpText;
                    if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                        String substring = str.substring(2, str.length() - 1);
                        stringBuffer.append(PreferencesUtil.LEFT_MOUNT + substring + PreferencesUtil.RIGHT_MOUNT);
                    }
                } else if (next.getType() == 8) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0529) + PreferencesUtil.RIGHT_MOUNT);
                } else if (next.getType() == 512) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ad8) + PreferencesUtil.RIGHT_MOUNT);
                } else if (next.getType() == 32) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f14f1) + PreferencesUtil.RIGHT_MOUNT);
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    public void m0(Post post) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, post) == null) {
            n0(post, null);
        }
    }

    public void n0(Post post, @Nullable ThreadData threadData) {
        int i;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048642, this, post, threadData) == null) || post == null) {
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
            if (valueOf != null && valueOf.length() > 0 && !this.g.equals("0") && this.t != null && (metaData = this.t.get(this.g)) != null) {
                this.f = metaData;
            }
            boolean z = true;
            this.K = post.need_log.intValue() == 1;
            this.L = post.img_num_abtest.intValue() == 1;
            nq4 nq4Var = new nq4();
            this.y = nq4Var;
            nq4Var.j(post.from_forum);
            if (this.f.getUserId() == null || this.f.getUserId().length() <= 0 || this.f.getUserId().equals("0")) {
                this.f.parserProtobuf(post.author);
            }
            if (this.f != null) {
                this.G = this.f.getUserName() + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1170);
                String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0492), Integer.valueOf(this.f.getLevel_id()));
            }
            post.is_ntitle.intValue();
            this.j = post.sub_post_number.intValue();
            this.x = new hi8(post.tpoint_post);
            List<PbContent> list = post.content;
            this.g0 = post.content;
            post.is_wonderful_post.intValue();
            this.Z = post.is_top_agree_post.intValue() == 1;
            this.d0 = post.item_star;
            this.z = post.fold_comment_status.intValue();
            this.A = post.fold_comment_apply_url;
            if (post.item != null && post.item.item_id.longValue() != 0) {
                this.e0 = post.item;
            }
            if (this.e0 == null && post.outer_item != null && post.outer_item.item_id.longValue() > 0) {
                this.i0 = post.outer_item;
            }
            TbRichText W = TbRichTextView.W(list, String.valueOf(post.tid), true, this, threadData, B());
            this.n = W;
            if (W != null) {
                W.K(ng.g(this.b, -1L));
                this.n.J(this.d);
                if (this.f != null) {
                    this.n.setAuthorId(this.f.getUserId());
                }
                int count = ListUtils.getCount(this.d0);
                if (this.d == 1 && count != 0 && this.d0 != null) {
                    ArrayList<TbRichTextData> C = this.n.C();
                    if (count == 1) {
                        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(C, 0);
                        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
                            tbRichTextData = new TbRichTextData(1);
                            ListUtils.add(C, 0, tbRichTextData);
                        }
                        HeadItem headItem = (HeadItem) ListUtils.getItem(this.d0, 0);
                        if (headItem != null) {
                            try {
                                i = Integer.parseInt(headItem.content);
                            } catch (NumberFormatException unused) {
                                i = 0;
                            }
                            tbRichTextData.f0(rg5.q(i, false));
                        }
                    } else {
                        for (int size = this.d0.size() - 1; size >= 0; size--) {
                            HeadItem headItem2 = this.d0.get(size);
                            if (headItem2 != null) {
                                i(C, headItem2);
                            }
                        }
                    }
                }
                if (this.d == 1 && this.e0 != null) {
                    TbRichTextData tbRichTextData2 = new TbRichTextData(1281);
                    tbRichTextData2.T(new TbRichTextEvaluateItemInfo(this.e0));
                    ListUtils.add(this.n.C(), tbRichTextData2);
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
                        postData.J.parseProtobuf(subPostList.agree);
                        postData.K0(this.t);
                        postData.v0(this.X);
                        postData.l0(subPostList, false, threadData, B());
                        this.k.add(postData);
                    }
                }
            }
            ActPost actPost = post.act_post;
            if (actPost != null) {
                this.r.a(actPost);
            }
            this.s = post.bimg_url;
            if (post.tail_info != null) {
                g05 g05Var = new g05();
                this.u = g05Var;
                g05Var.b(post.tail_info);
            }
            if (post.lbs_info != null) {
                o05 o05Var = new o05();
                this.v = o05Var;
                o05Var.c(post.lbs_info);
            }
            post.storecount.intValue();
            this.q.c(post.present);
            this.o.setUserMap(this.t);
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
                    g05 g05Var2 = new g05();
                    g05Var2.b(post.ext_tails.get(i3));
                    this.F.add(g05Var2);
                }
            }
            this.H = post.skin_info;
            this.I = post.lego_card;
            TPointPost tPointPost = post.tpoint_post;
            if (post.agree != null) {
                this.J.postId = this.b;
                this.J.parseProtobuf(post.agree);
            }
            if (post.is_post_visible.intValue() != 1) {
                z = false;
            }
            this.Q = z;
            if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.T = originalThreadInfo;
                originalThreadInfo.n(post.origin_thread_info);
            } else {
                this.T = null;
            }
            this.U = post.is_fold.intValue();
            this.V = post.fold_tip;
            if (post.advertisement != null) {
                e05 e05Var = new e05();
                this.q0 = e05Var;
                e05Var.o(post.advertisement);
            }
            if (post.novel_info != null) {
                r05 r05Var = new r05();
                this.r0 = r05Var;
                r05Var.j(post.novel_info);
                if (!ListUtils.isEmpty(this.g0) && this.g0.get(0) != null) {
                    this.r0.k(this.g0.get(0).text);
                }
            }
            if (this.s0 == null) {
                this.s0 = new ArrayList();
            }
            if (post.card_link_info != null) {
                for (int i4 = 0; i4 < post.card_link_info.size(); i4++) {
                    CardLinkInfoData cardLinkInfoData = new CardLinkInfoData();
                    cardLinkInfoData.parse(post.card_link_info.get(i4));
                    this.s0.add(cardLinkInfoData);
                }
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public e05 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.q0 : (e05) invokeV.objValue;
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048644, this) == null) {
            this.m.clear();
            this.m = null;
            this.l = false;
        }
    }

    public AgreeData p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.J : (AgreeData) invokeV.objValue;
    }

    public void p0(e05 e05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, e05Var) == null) {
            this.q0 = e05Var;
        }
    }

    public void q0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, metaData) == null) {
            this.f = metaData;
        }
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.J.agreeType : invokeV.intValue;
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            try {
                if (this.n != null) {
                    ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(this.n.toString());
                    return;
                }
                if (this.i == null || this.i.size() == 0) {
                    O0();
                }
                ArrayList<li8> arrayList = this.i;
                if (arrayList != null) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<li8> it = arrayList.iterator();
                    while (it.hasNext()) {
                        li8 next = it.next();
                        if (next.getType() == 0) {
                            if (next.j() != null) {
                                sb.append((CharSequence) next.j());
                            }
                        } else if (next.getType() == 3) {
                            if (next.g() != null) {
                                sb.append(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e4c));
                            }
                        } else if (next.getType() == 6) {
                            sb.append(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1530));
                        } else if (next.getType() == 2) {
                            String j = TbFaceManager.i().j(next.i());
                            if (j != null) {
                                sb.append(PreferencesUtil.LEFT_MOUNT);
                                sb.append(j);
                                sb.append(PreferencesUtil.RIGHT_MOUNT);
                            }
                        } else if (next.getType() == 11 && !oi.isEmpty(next.f())) {
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

    public MetaData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) ? this.f : (MetaData) invokeV.objValue;
    }

    public void s0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i) == null) {
            this.d = i;
        }
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public void t0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048653, this, j) == null) {
            this.u0 = j;
        }
    }

    public List<CardLinkInfoData> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.s0 : (List) invokeV.objValue;
    }

    public void u0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048655, this, str) == null) {
            this.v0 = str;
        }
    }

    public void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z) == null) {
            this.X = z;
        }
    }

    public hi8 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.x : (hi8) invokeV.objValue;
    }

    public void w0(rp4 rp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, rp4Var) == null) {
            this.q = rp4Var;
        }
    }

    public long x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.J.disAgreeNum : invokeV.longValue;
    }

    public void x0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, str) == null) {
            this.b = str;
        }
    }

    public ArrayList<PostData> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.m : (ArrayList) invokeV.objValue;
    }

    public void y0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z) == null) {
            this.W = z;
        }
    }

    public PreLoadImageInfo z() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (C = tbRichText.C()) == null) {
                return null;
            }
            Iterator<TbRichTextData> it = C.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.G().getWidth();
                    preLoadImageInfo.height = next.G().getHeight();
                    preLoadImageInfo.imgUrl = next.G().C();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.J().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.J().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.J().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return (PreLoadImageInfo) invokeV.objValue;
    }

    public void z0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048664, this, z) == null) {
            this.w = z;
        }
    }
}
