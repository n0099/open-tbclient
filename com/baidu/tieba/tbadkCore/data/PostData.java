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
import com.baidu.tieba.Cdo;
import com.baidu.tieba.R;
import com.baidu.tieba.b45;
import com.baidu.tieba.bt4;
import com.baidu.tieba.cy4;
import com.baidu.tieba.dh;
import com.baidu.tieba.dj;
import com.baidu.tieba.dn8;
import com.baidu.tieba.fn8;
import com.baidu.tieba.hl5;
import com.baidu.tieba.hn8;
import com.baidu.tieba.in8;
import com.baidu.tieba.j45;
import com.baidu.tieba.m45;
import com.baidu.tieba.ml5;
import com.baidu.tieba.on;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.qo;
import com.baidu.tieba.tx4;
import com.baidu.tieba.w45;
import com.baidu.tieba.xt4;
import com.baidu.tieba.yg;
import com.baidu.tieba.ym8;
import com.baidu.tieba.z35;
import com.baidu.tieba.zg;
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
public class PostData implements PreLoadImageProvider, Cdo {
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
    public w45 D0;
    public ml5 E;
    public boolean E0;
    public TbRichTextVoiceInfo F;
    public FullLengthNovel F0;
    public ArrayList<b45> G;
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
    public ArrayList<hn8> h;
    public List<PbContent> h0;
    public ArrayList<hn8> i;
    public int i0;
    public int j;
    public Item j0;
    public ArrayList<PostData> k;
    public boolean l;
    public ArrayList<PostData> m;
    public TbRichText n;
    public PraiseData o;
    public SmallTailInfo p;
    public bt4 q;
    public int q0;
    public ym8 r;
    public z35 r0;
    public String s;
    public m45 s0;
    public String t;
    public List<CardLinkInfoData> t0;
    public HashMap<String, MetaData> u;
    public in8 u0;
    public b45 v;
    public long v0;
    public j45 w;
    public String w0;
    public boolean x;
    public boolean x0;
    public dn8 y;
    public int y0;
    public xt4 z;
    public int z0;

    /* loaded from: classes5.dex */
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (statisticItem = this.a.d0) == null) {
                return;
            }
            StatisticItem copy = statisticItem.copy();
            copy.delete("obj_locate");
            copy.param("obj_locate", 7);
            TiebaStatic.log(copy);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements qo.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IconData a;
        public final /* synthetic */ BdUniqueId b;
        public final /* synthetic */ PostData c;

        /* loaded from: classes5.dex */
        public class a extends yg<on> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ qo a;
            public final /* synthetic */ b b;

            public a(b bVar, qo qoVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, qoVar};
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
                this.a = qoVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.yg
            public void onLoaded(on onVar, String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(1048576, this, onVar, str, i) == null) {
                    super.onLoaded((a) onVar, str, i);
                    if (onVar == null || !onVar.w()) {
                        return;
                    }
                    this.a.a(this.b.c.h(onVar));
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

        @Override // com.baidu.tieba.qo.a
        public Drawable a(qo qoVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qoVar)) == null) {
                on onVar = (on) zg.h().n(this.a.getIcon(), 21, new Object[0]);
                if (onVar == null) {
                    zg.h().m(this.a.getIcon(), 21, new a(this, qoVar), this.b);
                }
                return this.c.h(onVar);
            }
            return (Drawable) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
        this.q = new bt4();
        this.r = new ym8();
        this.G = new ArrayList<>();
        this.N = 0;
        this.K = new AgreeData();
    }

    public PreLoadImageInfo A() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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

    public void A0(z35 z35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z35Var) == null) {
            this.r0 = z35Var;
        }
    }

    public String B() {
        InterceptResult invokeV;
        fn8 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            PreLoadImageInfo A = A();
            if (A != null && !StringUtils.isNull(A.imgUrl)) {
                return A.imgUrl;
            }
            dn8 dn8Var = this.y;
            if (dn8Var == null || (a2 = dn8Var.a()) == null || StringUtils.isNull(a2.a())) {
                return null;
            }
            return a2.a();
        }
        return (String) invokeV.objValue;
    }

    public void B0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, metaData) == null) {
            this.f = metaData;
        }
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d : invokeV.intValue;
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            try {
                if (this.n != null) {
                    ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(this.n.toString());
                    return;
                }
                if (this.i == null || this.i.size() == 0) {
                    h1();
                }
                ArrayList<hn8> arrayList = this.i;
                if (arrayList != null) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<hn8> it = arrayList.iterator();
                    while (it.hasNext()) {
                        hn8 next = it.next();
                        if (next.getType() == 0) {
                            if (next.j() != null) {
                                sb.append((CharSequence) next.j());
                            }
                        } else if (next.getType() == 3) {
                            if (next.g() != null) {
                                sb.append(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e9a));
                            }
                        } else if (next.getType() == 6) {
                            sb.append(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f159e));
                        } else if (next.getType() == 2) {
                            String j = TbFaceManager.i().j(next.i());
                            if (j != null) {
                                sb.append(PreferencesUtil.LEFT_MOUNT);
                                sb.append(j);
                                sb.append(PreferencesUtil.RIGHT_MOUNT);
                            }
                        } else if (next.getType() == 11 && !dj.isEmpty(next.f())) {
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

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.B : (String) invokeV.objValue;
    }

    public void D0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.d = i;
        }
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.A : invokeV.intValue;
    }

    public void E0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.v0 = j;
        }
    }

    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.W : (String) invokeV.objValue;
    }

    public void F0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.w0 = str;
        }
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.V : invokeV.intValue;
    }

    public void G0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.Y = z;
        }
    }

    public long H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.v0 : invokeV.longValue;
    }

    public void H0(bt4 bt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bt4Var) == null) {
            this.q = bt4Var;
        }
    }

    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.w0 : (String) invokeV.objValue;
    }

    public void I0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.A0 = z;
        }
    }

    public bt4 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.q : (bt4) invokeV.objValue;
    }

    public void J0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.b = str;
        }
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.A0 : invokeV.booleanValue;
    }

    public void K0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.J0 = i;
        }
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public void L0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.X = z;
        }
    }

    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.J0 : invokeV.intValue;
    }

    public void M0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.x = z;
        }
    }

    public Boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? Boolean.valueOf(this.x0) : (Boolean) invokeV.objValue;
    }

    public void N0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.T = z;
        }
    }

    public int O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.z0 : invokeV.intValue;
    }

    public void O0(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, bool) == null) {
            this.x0 = bool.booleanValue();
        }
    }

    public Item P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f0 : (Item) invokeV.objValue;
    }

    public void P0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.z0 = i;
        }
    }

    public List<HeadItem> Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.e0 : (List) invokeV.objValue;
    }

    public void Q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z) == null) {
            this.E0 = z;
        }
    }

    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.J : (String) invokeV.objValue;
    }

    public void R0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048611, this, z) == null) {
            this.l = z;
        }
    }

    public j45 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.w : (j45) invokeV.objValue;
    }

    public void S0(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, originalThreadInfo) == null) {
            this.U = originalThreadInfo;
        }
    }

    public m45 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.s0 : (m45) invokeV.objValue;
    }

    public void T0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048615, this, i) == null) {
            this.a = i;
        }
    }

    public OriginalThreadInfo U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.U : (OriginalThreadInfo) invokeV.objValue;
    }

    public void U0(PraiseData praiseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, praiseData) == null) {
            this.o = praiseData;
        }
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.y0 : invokeV.intValue;
    }

    public void V0(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, tbRichText) == null) {
            this.n = tbRichText;
        }
    }

    public TbRichText W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.n : (TbRichText) invokeV.objValue;
    }

    public void W0(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, bool) == null) {
            this.H0 = bool;
        }
    }

    public Boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.H0 : (Boolean) invokeV.objValue;
    }

    public void X0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048623, this, i) == null) {
            this.j = i;
        }
    }

    public SkinInfo Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.I : (SkinInfo) invokeV.objValue;
    }

    public void Y0(SmallTailInfo smallTailInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, smallTailInfo) == null) {
            this.p = smallTailInfo;
        }
    }

    public ArrayList<PostData> Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) ? this.k : (ArrayList) invokeV.objValue;
    }

    public void Z0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048627, this, j) == null) {
            this.e = j;
            StringHelper.getFormatTime(j);
        }
    }

    public int a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            if (Z() != null) {
                return Z().size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void a1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, str) == null) {
        }
    }

    public void b(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, postData) == null) || postData == null) {
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

    public int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.j : invokeV.intValue;
    }

    public void b1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048632, this, z) == null) {
            this.B0 = z;
        }
    }

    public void c(PostData postData) {
        ArrayList<PostData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048633, this, postData) == null) || postData == null || (arrayList = this.k) == null) {
            return;
        }
        arrayList.add(postData);
        f();
    }

    public SmallTailInfo c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.p : (SmallTailInfo) invokeV.objValue;
    }

    public void c1(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, hashMap) == null) {
            this.u = hashMap;
        }
    }

    public String d0() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> B;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
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

    public void d1(Post post) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, post) == null) {
            if (post.custom_figure != null) {
                VirtualImageCustomFigure virtualImageCustomFigure = new VirtualImageCustomFigure();
                this.C0 = virtualImageCustomFigure;
                virtualImageCustomFigure.parseProto(post.custom_figure);
            }
            if (post.custom_state != null) {
                w45 w45Var = new w45();
                this.D0 = w45Var;
                w45Var.c(post.custom_state);
            }
        }
    }

    public long e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.c : invokeV.longValue;
    }

    public void e1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048639, this, i) == null) {
            this.I0 = i;
        }
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.e : invokeV.longValue;
    }

    public boolean f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            OriginalThreadInfo originalThreadInfo = this.U;
            return originalThreadInfo != null && originalThreadInfo.H && this.v0 == originalThreadInfo.e;
        }
        return invokeV.booleanValue;
    }

    public final tx4 g(boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048643, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (z || z2) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.L_X01);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds26);
                int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds12);
                int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.tbds40);
                if (" 楼主".equals(str)) {
                    tx4 tx4Var = new tx4(dimenPixelSize, -1, R.color.CAM_X0302, dimenPixelSize3, R.color.CAM_X0302, dimenPixelSize4, dimenPixelSize5);
                    tx4Var.b(dimenPixelSize2);
                    tx4Var.f(false);
                    tx4Var.e(str);
                    return tx4Var;
                } else if (" 吧主".equals(str) || " 小吧主".equals(str) || " 品牌官".equals(str)) {
                    tx4 tx4Var2 = new tx4(dimenPixelSize, -1, R.color.CAM_X0302, dimenPixelSize3, R.color.CAM_X0101, dimenPixelSize4, dimenPixelSize5);
                    tx4Var2.b(dimenPixelSize2);
                    tx4Var2.a(0.7f);
                    tx4Var2.f(true);
                    tx4Var2.e(str);
                    return tx4Var2;
                } else {
                    return null;
                }
            }
            return null;
        }
        return (tx4) invokeCommon.objValue;
    }

    public HashMap<String, MetaData> g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.u : (HashMap) invokeV.objValue;
    }

    public void g1(TbPageContext tbPageContext, boolean z) {
        TbRichText tbRichText;
        String str;
        SpannableString spannableString;
        String str2;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048645, this, tbPageContext, z) == null) || this.Z || tbPageContext == null || (tbRichText = this.n) == null || tbRichText.B() == null) {
            return;
        }
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
        ArrayList<IconData> tShowInfoNew = s().getTShowInfoNew();
        if (tShowInfoNew != null) {
            Iterator<IconData> it = tShowInfoNew.iterator();
            while (it.hasNext()) {
                qo qoVar = new qo(new b(this, it.next(), uniqueId), 0, 1);
                qoVar.b(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                arrayList.add(qoVar);
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
            cy4 cy4Var = new cy4(bitmapDrawable);
            cy4Var.b(UtilHelper.getDimenPixelSize(R.dimen.obfuscated_res_0x7f0701d4));
            int size = arrayList.size() + this.f.getSealPrefix().length() + 1;
            spannableString.setSpan(cy4Var, size, size + 1, 17);
        }
        spannableString.setSpan(new c(str2, str3, this.G0), 0, spannableString.length(), 18);
        if (!StringUtils.isNull(str) && (z || ((metaData = this.f) != null && metaData.getIs_bawu() == 1))) {
            MetaData metaData4 = this.f;
            tx4 g = g(z, metaData4 != null && metaData4.getIs_bawu() == 1, str);
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
                int i4 = 0;
                while (true) {
                    if (i4 >= B.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (B.get(i4) != null && B.get(i4).getType() == 512) {
                        tbRichTextVoiceInfo = B.get(i4).P();
                        B.remove(i4);
                        break;
                    } else {
                        i4++;
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
            if (i == 40 || i == 50) {
                return P0;
            }
            if (i == 41) {
                return Q0;
            }
            if (i == 53) {
                return S0;
            }
            if (C() == 1) {
                return K0;
            }
            in8 in8Var = this.u0;
            if (in8Var != null && in8Var.h()) {
                return this.u0.i() ? AdvertAppInfo.G : AdvertAppInfo.I;
            } else if (this.B0) {
                return M0;
            } else {
                return L0;
            }
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public Drawable h(on onVar) {
        InterceptResult invokeL;
        Bitmap p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, onVar)) == null) {
            if (onVar == null || (p = onVar.p()) == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
            bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
            return bitmapDrawable;
        }
        return (Drawable) invokeL.objValue;
    }

    public String h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.H : (String) invokeV.objValue;
    }

    public void h1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048650, this) == null) || this.h == null) {
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
            hn8 hn8Var = this.h.get(i2);
            if (hn8.k(i, hn8Var.getType())) {
                this.i.get(size - 1).e(hn8Var.h());
            } else {
                if (hn8Var.getType() != 3 && hn8Var.getType() != 2 && hn8Var.getType() != 11) {
                    hn8 hn8Var2 = new hn8();
                    hn8Var2.l(0);
                    hn8Var2.e(hn8Var.h());
                    this.i.add(hn8Var2);
                    i = 0;
                    size++;
                }
                this.i.add(hn8Var);
                i = hn8Var.getType();
                size++;
            }
        }
    }

    public ml5 i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            ml5 ml5Var = this.E;
            if (ml5Var != null) {
                return ml5Var;
            }
            TbRichText tbRichText = this.n;
            if (tbRichText == null || ListUtils.getCount(tbRichText.B()) <= 0) {
                return null;
            }
            Iterator<TbRichTextData> it = this.n.B().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    ml5 O = next.O();
                    this.E = O;
                    return O;
                }
            }
            return null;
        }
        return (ml5) invokeV.objValue;
    }

    public void i1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048652, this) == null) && this.D == 0) {
            this.D = 1;
        }
    }

    public final void j(List<TbRichTextData> list, HeadItem headItem) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048653, this, list, headItem) == null) {
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
                spannableStringBuilder.append((CharSequence) hl5.q(i, true));
            }
            tbRichTextData.A(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public VirtualImageCustomFigure j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? this.C0 : (VirtualImageCustomFigure) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            this.j--;
        }
    }

    public w45 k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.D0 : (w45) invokeV.objValue;
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048657, this, str) == null) || this.m == null || StringUtils.isNull(str)) {
            return;
        }
        Iterator<PostData> it = this.m.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null && str.equals(next.L())) {
                this.m.remove(next);
                return;
            }
        }
    }

    public TbRichTextVoiceInfo l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = this.F;
            if (tbRichTextVoiceInfo != null) {
                return tbRichTextVoiceInfo;
            }
            TbRichText tbRichText = this.n;
            if (tbRichText == null || ListUtils.getCount(tbRichText.B()) <= 0) {
                return null;
            }
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
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public int m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.I0 : invokeV.intValue;
    }

    public String n() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> B;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
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
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0544) + PreferencesUtil.RIGHT_MOUNT);
                } else if (next.getType() == 512) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0b16) + PreferencesUtil.RIGHT_MOUNT);
                } else if (next.getType() == 32) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f155f) + PreferencesUtil.RIGHT_MOUNT);
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean n0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048661, this, z)) == null) {
            return a0() <= (z ? 2 : 4) && b0() > a0();
        }
        return invokeZ.booleanValue;
    }

    public z35 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.r0 : (z35) invokeV.objValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? b0() > 0 && Z() != null && Z().size() > 0 : invokeV.booleanValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) ? this.Y : invokeV.booleanValue;
    }

    public AgreeData q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.K : (AgreeData) invokeV.objValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.E0 : invokeV.booleanValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.K.agreeType : invokeV.intValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.X : invokeV.booleanValue;
    }

    public MetaData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.f : (MetaData) invokeV.objValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.x : invokeV.booleanValue;
    }

    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public void u0(SubPostList subPostList, boolean z, @Nullable ThreadData threadData, int i) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048673, this, new Object[]{subPostList, Boolean.valueOf(z), threadData, Integer.valueOf(i)}) == null) || subPostList == null) {
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
                W.J(dh.g(this.b, -1L));
            }
            this.q0 = subPostList.is_author_view.intValue();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public List<CardLinkInfoData> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.t0 : (List) invokeV.objValue;
    }

    public void v0(Post post) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, post) == null) {
            w0(post, null);
        }
    }

    public dn8 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.y : (dn8) invokeV.objValue;
    }

    public void w0(Post post, @Nullable ThreadData threadData) {
        int i;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048677, this, post, threadData) == null) || post == null) {
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
            boolean z = true;
            this.L = post.need_log.intValue() == 1;
            this.M = post.img_num_abtest.intValue() == 1;
            xt4 xt4Var = new xt4();
            this.z = xt4Var;
            xt4Var.j(post.from_forum);
            if (this.f.getUserId() == null || this.f.getUserId().length() <= 0 || this.f.getUserId().equals("0")) {
                this.f.parserProtobuf(post.author);
            }
            if (this.f != null) {
                this.H = this.f.getUserName() + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11cd);
                String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f04a4), Integer.valueOf(this.f.getLevel_id()));
            }
            post.is_ntitle.intValue();
            this.j = post.sub_post_number.intValue();
            this.y = new dn8(post.tpoint_post);
            List<PbContent> list = post.content;
            this.h0 = post.content;
            post.is_wonderful_post.intValue();
            this.a0 = post.is_top_agree_post.intValue() == 1;
            this.e0 = post.item_star;
            this.A = post.fold_comment_status.intValue();
            this.B = post.fold_comment_apply_url;
            if (post.item != null && post.item.item_id.longValue() != 0) {
                this.f0 = post.item;
            }
            if (this.f0 == null && post.outer_item != null && post.outer_item.item_id.longValue() > 0) {
                this.j0 = post.outer_item;
            }
            TbRichText W = TbRichTextView.W(list, String.valueOf(post.tid), true, this, threadData, C());
            this.n = W;
            if (W != null) {
                W.J(dh.g(this.b, -1L));
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
                            tbRichTextData.e0(hl5.q(i, false));
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
                        postData.c1(this.u);
                        postData.G0(this.Y);
                        postData.u0(subPostList, false, threadData, C());
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
                b45 b45Var = new b45();
                this.v = b45Var;
                b45Var.b(post.tail_info);
            }
            if (post.lbs_info != null) {
                j45 j45Var = new j45();
                this.w = j45Var;
                j45Var.c(post.lbs_info);
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
                    b45 b45Var2 = new b45();
                    b45Var2.b(post.ext_tails.get(i3));
                    this.G.add(b45Var2);
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
                z = false;
            }
            this.R = z;
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
                z35 z35Var = new z35();
                this.r0 = z35Var;
                z35Var.o(post.advertisement);
            }
            if (post.novel_info != null) {
                m45 m45Var = new m45();
                this.s0 = m45Var;
                m45Var.j(post.novel_info);
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

    public long x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.K.disAgreeNum : invokeV.longValue;
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048679, this) == null) {
            this.y0++;
        }
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.t : (String) invokeV.objValue;
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048681, this) == null) {
            this.y0--;
        }
    }

    public ArrayList<PostData> z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.m : (ArrayList) invokeV.objValue;
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048683, this) == null) {
            this.m.clear();
            this.m = null;
            this.l = false;
        }
    }
}
