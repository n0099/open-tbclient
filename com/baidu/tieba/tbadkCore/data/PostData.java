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
import com.baidu.tbadk.data.IconData;
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
import com.repackage.b05;
import com.repackage.cg5;
import com.repackage.co;
import com.repackage.cq4;
import com.repackage.e05;
import com.repackage.ep;
import com.repackage.fg;
import com.repackage.gg;
import com.repackage.kg;
import com.repackage.li;
import com.repackage.lu4;
import com.repackage.nj8;
import com.repackage.ro;
import com.repackage.tj8;
import com.repackage.tu4;
import com.repackage.vj8;
import com.repackage.vz4;
import com.repackage.xf5;
import com.repackage.xj8;
import com.repackage.xz4;
import com.repackage.yj8;
import com.repackage.yq4;
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
public class PostData implements PreLoadImageProvider, ro {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId A0;
    public static final BdUniqueId B0;
    public static final BdUniqueId C0;
    public static final BdUniqueId D0;
    public static boolean E0;
    public static final BdUniqueId w0;
    public static final BdUniqueId x0;
    public static final BdUniqueId y0;
    public static final BdUniqueId z0;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean B;
    public int C;
    public cg5 D;
    public TbRichTextVoiceInfo E;
    public ArrayList<xz4> F;
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
    public String b;
    public long c;
    public int d;
    public long e;
    public MetaData f;
    @Deprecated
    public String g;
    public boolean g0;
    public ArrayList<xj8> h;
    public int h0;
    public ArrayList<xj8> i;
    public StatisticItem i0;
    public int j;
    public List<HeadItem> j0;
    public ArrayList<PostData> k;
    public Item k0;
    public boolean l;
    public boolean l0;
    public ArrayList<PostData> m;
    public List<PbContent> m0;
    public TbRichText n;
    public int n0;
    public PraiseData o;
    public Item o0;
    public SmallTailInfo p;
    public int p0;
    public cq4 q;
    public vz4 q0;
    public nj8 r;
    public e05 r0;
    public String s;
    public yj8 s0;
    public HashMap<String, MetaData> t;
    public long t0;
    public xz4 u;
    public String u0;
    public b05 v;
    public d v0;
    public boolean w;
    public tj8 x;
    public yq4 y;
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (statisticItem = this.a.i0) == null) {
                return;
            }
            StatisticItem copy = statisticItem.copy();
            copy.delete("obj_locate");
            copy.param("obj_locate", 7);
            TiebaStatic.log(copy);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ep.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IconData a;
        public final /* synthetic */ BdUniqueId b;
        public final /* synthetic */ PostData c;

        /* loaded from: classes4.dex */
        public class a extends fg<co> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ep a;
            public final /* synthetic */ b b;

            public a(b bVar, ep epVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, epVar};
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
                this.a = epVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.repackage.fg
            public void onLoaded(co coVar, String str, int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(1048576, this, coVar, str, i) == null) {
                    super.onLoaded((a) coVar, str, i);
                    if (coVar == null || !coVar.w()) {
                        return;
                    }
                    this.a.a(this.b.c.i(coVar));
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

        @Override // com.repackage.ep.a
        public Drawable a(ep epVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, epVar)) == null) {
                co coVar = (co) gg.h().n(this.a.getIcon(), 21, new Object[0]);
                if (coVar == null) {
                    gg.h().m(this.a.getIcon(), 21, new a(this, epVar), this.b);
                }
                return this.c.i(coVar);
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
        w0 = BdUniqueId.gen();
        x0 = BdUniqueId.gen();
        y0 = BdUniqueId.gen();
        z0 = BdUniqueId.gen();
        A0 = BdUniqueId.gen();
        B0 = BdUniqueId.gen();
        BdUniqueId.gen();
        C0 = BdUniqueId.gen();
        D0 = BdUniqueId.gen();
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
        this.g0 = false;
        this.l0 = false;
        this.n0 = 4;
        this.v0 = new a(this);
        this.b = null;
        this.d = 0;
        this.e = 0L;
        this.f = new MetaData();
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.j = 0;
        this.k = new ArrayList<>();
        this.o = new PraiseData();
        this.q = new cq4();
        this.r = new nj8();
        this.F = new ArrayList<>();
        this.M = 0;
        this.J = new AgreeData();
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : invokeV.intValue;
    }

    public void A0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.a = i;
        }
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.A : (String) invokeV.objValue;
    }

    public void B0(PraiseData praiseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, praiseData) == null) {
            this.o = praiseData;
        }
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.z : invokeV.intValue;
    }

    public void C0(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, tbRichText) == null) {
            this.n = tbRichText;
        }
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.V : (String) invokeV.objValue;
    }

    public void D0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.j = i;
        }
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.U : invokeV.intValue;
    }

    public void E0(SmallTailInfo smallTailInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, smallTailInfo) == null) {
            this.p = smallTailInfo;
        }
    }

    public long F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.t0 : invokeV.longValue;
    }

    public void F0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.e = j;
            StringHelper.getFormatTime(j);
        }
    }

    public String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.u0 : (String) invokeV.objValue;
    }

    public void G0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
        }
    }

    public cq4 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.q : (cq4) invokeV.objValue;
    }

    public void H0(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, hashMap) == null) {
            this.t = hashMap;
        }
    }

    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            OriginalThreadInfo originalThreadInfo = this.T;
            return originalThreadInfo != null && originalThreadInfo.H && this.t0 == originalThreadInfo.e;
        }
        return invokeV.booleanValue;
    }

    public Item J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.k0 : (Item) invokeV.objValue;
    }

    public void J0(TbPageContext tbPageContext, boolean z) {
        TbRichText tbRichText;
        String str;
        SpannableString spannableString;
        String str2;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048595, this, tbPageContext, z) == null) || this.Y || tbPageContext == null || (tbRichText = this.n) == null || tbRichText.A() == null) {
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
                ep epVar = new ep(new b(this, it.next(), uniqueId), 0, 1);
                epVar.b(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                arrayList.add(epVar);
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
            tu4 tu4Var = new tu4(bitmapDrawable);
            tu4Var.b(UtilHelper.getDimenPixelSize(R.dimen.obfuscated_res_0x7f0701d4));
            int size = arrayList.size() + this.f.getSealPrefix().length() + 1;
            spannableString.setSpan(tu4Var, size, size + 1, 17);
        }
        spannableString.setSpan(new c(str2, str3, this.v0), 0, spannableString.length(), 18);
        if (!StringUtils.isNull(str) && (z || ((metaData = this.f) != null && metaData.getIs_bawu() == 1))) {
            MetaData metaData4 = this.f;
            lu4 g = g(z, metaData4 != null && metaData4.getIs_bawu() == 1, str);
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
        ArrayList<TbRichTextData> A = this.n.A();
        if (A != null && A.size() > 0) {
            TbRichTextData tbRichTextData2 = A.get(0);
            if (tbRichTextData2 != null && tbRichTextData2.I() != null) {
                if (this.S) {
                    int indexOf = tbRichTextData2.I().toString().indexOf("：");
                    if (indexOf > 0) {
                        tbRichTextData2.I().delete(0, indexOf + 1);
                    }
                    this.S = false;
                }
                tbRichTextData2.Z(sb.length());
                tbRichTextData2.I().insert(0, (CharSequence) spannableString);
            } else {
                int i4 = 0;
                while (true) {
                    if (i4 >= A.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (A.get(i4) != null && A.get(i4).getType() == 512) {
                        tbRichTextVoiceInfo = A.get(i4).O();
                        A.remove(i4);
                        break;
                    } else {
                        i4++;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.c0(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.Z(sb.length());
                tbRichTextData.z(spannableString);
                A.add(0, tbRichTextData);
            }
        }
        this.Y = true;
    }

    public List<HeadItem> K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.j0 : (List) invokeV.objValue;
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || this.h == null) {
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
            xj8 xj8Var = this.h.get(i2);
            if (xj8.k(i, xj8Var.getType())) {
                this.i.get(size - 1).e(xj8Var.h());
            } else {
                if (xj8Var.getType() != 3 && xj8Var.getType() != 2 && xj8Var.getType() != 11) {
                    xj8 xj8Var2 = new xj8();
                    xj8Var2.l(0);
                    xj8Var2.e(xj8Var.h());
                    this.i.add(xj8Var2);
                    i = 0;
                    size++;
                }
                this.i.add(xj8Var);
                i = xj8Var.getType();
                size++;
            }
        }
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.I : (String) invokeV.objValue;
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && this.C == 0) {
            this.C = 1;
        }
    }

    public b05 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.v : (b05) invokeV.objValue;
    }

    public e05 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.r0 : (e05) invokeV.objValue;
    }

    public OriginalThreadInfo O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.T : (OriginalThreadInfo) invokeV.objValue;
    }

    public TbRichText P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.n : (TbRichText) invokeV.objValue;
    }

    public SkinInfo Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.H : (SkinInfo) invokeV.objValue;
    }

    public ArrayList<PostData> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.k : (ArrayList) invokeV.objValue;
    }

    public int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (R() != null) {
                return R().size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.j : invokeV.intValue;
    }

    public SmallTailInfo U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.p : (SmallTailInfo) invokeV.objValue;
    }

    public String V() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> A;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (A = tbRichText.A()) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator<TbRichTextData> it = A.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    if (next.getType() == 1) {
                        if (next.I() != null) {
                            sb.append(next.I().toString());
                        }
                    } else if (next.getType() == 17) {
                        if (next.B() != null && next.B().mGifInfo != null && (str = next.B().mGifInfo.mSharpText) != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
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

    public long W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.c : invokeV.longValue;
    }

    public long X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.e : invokeV.longValue;
    }

    public HashMap<String, MetaData> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.t : (HashMap) invokeV.objValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.G : (String) invokeV.objValue;
    }

    public cg5 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            cg5 cg5Var = this.D;
            if (cg5Var != null) {
                return cg5Var;
            }
            TbRichText tbRichText = this.n;
            if (tbRichText == null || ListUtils.getCount(tbRichText.A()) <= 0) {
                return null;
            }
            Iterator<TbRichTextData> it = this.n.A().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    cg5 N = next.N();
                    this.D = N;
                    return N;
                }
            }
            return null;
        }
        return (cg5) invokeV.objValue;
    }

    public void b(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, postData) == null) || postData == null) {
            return;
        }
        if (this.m == null) {
            this.m = new ArrayList<>();
            int count = ListUtils.getCount(this.k);
            int i = this.n0;
            if (count > i) {
                this.m.addAll(ListUtils.subList(this.k, 0, i));
            } else {
                this.m.addAll(this.k);
            }
        }
        this.m.add(postData);
    }

    public TbRichTextVoiceInfo b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = this.E;
            if (tbRichTextVoiceInfo != null) {
                return tbRichTextVoiceInfo;
            }
            TbRichText tbRichText = this.n;
            if (tbRichText == null || ListUtils.getCount(tbRichText.A()) <= 0) {
                return null;
            }
            Iterator<TbRichTextData> it = this.n.A().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 512) {
                    TbRichTextVoiceInfo O = next.O();
                    this.E = O;
                    return O;
                }
            }
            return null;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public boolean c0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048617, this, z)) == null) {
            return S() <= (z ? 2 : 4) && T() > S();
        }
        return invokeZ.booleanValue;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? T() > 0 && R() != null && R().size() > 0 : invokeV.booleanValue;
    }

    public void e(PostData postData) {
        ArrayList<PostData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, postData) == null) || postData == null || (arrayList = this.k) == null) {
            return;
        }
        arrayList.add(postData);
        f();
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.X : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.j++;
        }
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.W : invokeV.booleanValue;
    }

    public final lu4 g(boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048623, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (z || z2) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.L_X01);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds26);
                int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds12);
                int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.tbds40);
                if (" 楼主".equals(str)) {
                    lu4 lu4Var = new lu4(dimenPixelSize, -1, R.color.CAM_X0302, dimenPixelSize3, R.color.CAM_X0302, dimenPixelSize4, dimenPixelSize5);
                    lu4Var.b(dimenPixelSize2);
                    lu4Var.f(false);
                    lu4Var.e(str);
                    return lu4Var;
                } else if (" 吧主".equals(str) || " 小吧主".equals(str) || " 品牌官".equals(str)) {
                    lu4 lu4Var2 = new lu4(dimenPixelSize, -1, R.color.CAM_X0302, dimenPixelSize3, R.color.CAM_X0101, dimenPixelSize4, dimenPixelSize5);
                    lu4Var2.b(dimenPixelSize2);
                    lu4Var2.a(0.7f);
                    lu4Var2.f(true);
                    lu4Var2.e(str);
                    return lu4Var2;
                } else {
                    return null;
                }
            }
            return null;
        }
        return (lu4) invokeCommon.objValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.w : invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> A;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (A = tbRichText.A()) == null) {
                return null;
            }
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            Iterator<TbRichTextData> it = A.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8 && next.E() != null) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.E().getWidth();
                    preLoadImageInfo.height = next.E().getHeight();
                    if (TbadkCoreApplication.getInst().isGifAutoPlay() && !next.E().G()) {
                        preLoadImageInfo.imgUrl = next.E().B();
                        preLoadImageInfo.procType = 38;
                    } else {
                        preLoadImageInfo.imgUrl = next.E().A();
                        preLoadImageInfo.procType = 17;
                    }
                    arrayList.add(preLoadImageInfo);
                } else if (next.B() != null) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.B().mGifInfo.mGifWidth;
                    preLoadImageInfo2.height = next.B().mGifInfo.mGifHeight;
                    preLoadImageInfo2.bigEmotion = next.B();
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

    @Override // com.repackage.ro
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            int i = this.a;
            if (i == 52) {
                return C0;
            }
            if (i == 1) {
                return y0;
            }
            if (i == 36) {
                return z0;
            }
            if (i == 40 || i == 50) {
                return A0;
            }
            if (i == 41) {
                return B0;
            }
            if (i == 53) {
                return D0;
            }
            if (A() == 1) {
                return w0;
            }
            yj8 yj8Var = this.s0;
            if (yj8Var == null || !yj8Var.f()) {
                return x0;
            }
            return this.s0.g() ? AdvertAppInfo.D : AdvertAppInfo.F;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public Drawable i(co coVar) {
        InterceptResult invokeL;
        Bitmap p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, coVar)) == null) {
            if (coVar == null || (p = coVar.p()) == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
            bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
            return bitmapDrawable;
        }
        return (Drawable) invokeL.objValue;
    }

    public void i0(SubPostList subPostList, boolean z, @Nullable ThreadData threadData, int i) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{subPostList, Boolean.valueOf(z), threadData, Integer.valueOf(i)}) == null) || subPostList == null) {
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
                W.I(kg.g(this.b, -1L));
            }
            this.p0 = subPostList.is_author_view.intValue();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public final void j(List<TbRichTextData> list, HeadItem headItem) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, list, headItem) == null) {
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
                spannableStringBuilder.append((CharSequence) xf5.q(i, true));
            }
            tbRichTextData.z(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public void j0(Post post) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, post) == null) {
            k0(post, null);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            this.j--;
        }
    }

    public void k0(Post post, @Nullable ThreadData threadData) {
        int i;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048633, this, post, threadData) == null) || post == null) {
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
            this.K = post.need_log.intValue() == 1;
            this.L = post.img_num_abtest.intValue() == 1;
            yq4 yq4Var = new yq4();
            this.y = yq4Var;
            yq4Var.j(post.from_forum);
            if (this.f.getUserId() == null || this.f.getUserId().length() <= 0 || this.f.getUserId().equals("0")) {
                this.f.parserProtobuf(post.author);
            }
            if (this.f != null) {
                this.G = this.f.getUserName() + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f11a9);
                String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0491), Integer.valueOf(this.f.getLevel_id()));
            }
            post.is_ntitle.intValue();
            this.j = post.sub_post_number.intValue();
            this.x = new tj8(post.tpoint_post);
            List<PbContent> list = post.content;
            this.m0 = post.content;
            post.is_wonderful_post.intValue();
            this.Z = post.is_top_agree_post.intValue() == 1;
            this.j0 = post.item_star;
            this.z = post.fold_comment_status.intValue();
            this.A = post.fold_comment_apply_url;
            if (post.item != null && post.item.item_id.longValue() != 0) {
                this.k0 = post.item;
            }
            if (this.k0 == null && post.outer_item != null && post.outer_item.item_id.longValue() > 0) {
                this.o0 = post.outer_item;
            }
            TbRichText W = TbRichTextView.W(list, String.valueOf(post.tid), true, this, threadData, A());
            this.n = W;
            if (W != null) {
                W.I(kg.g(this.b, -1L));
                this.n.H(this.d);
                if (this.f != null) {
                    this.n.setAuthorId(this.f.getUserId());
                }
                int count = ListUtils.getCount(this.j0);
                if (this.d == 1 && count != 0 && this.j0 != null) {
                    ArrayList<TbRichTextData> A = this.n.A();
                    if (count == 1) {
                        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(A, 0);
                        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
                            tbRichTextData = new TbRichTextData(1);
                            ListUtils.add(A, 0, tbRichTextData);
                        }
                        HeadItem headItem = (HeadItem) ListUtils.getItem(this.j0, 0);
                        if (headItem != null) {
                            try {
                                i = Integer.parseInt(headItem.content);
                            } catch (NumberFormatException unused) {
                                i = 0;
                            }
                            tbRichTextData.d0(xf5.q(i, false));
                        }
                    } else {
                        for (int size = this.j0.size() - 1; size >= 0; size--) {
                            HeadItem headItem2 = this.j0.get(size);
                            if (headItem2 != null) {
                                j(A, headItem2);
                            }
                        }
                    }
                }
                if (this.d == 1 && this.k0 != null) {
                    TbRichTextData tbRichTextData2 = new TbRichTextData(1281);
                    tbRichTextData2.R(new TbRichTextEvaluateItemInfo(this.k0));
                    ListUtils.add(this.n.A(), tbRichTextData2);
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
                        postData.H0(this.t);
                        postData.s0(this.X);
                        postData.i0(subPostList, false, threadData, A());
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
                xz4 xz4Var = new xz4();
                this.u = xz4Var;
                xz4Var.b(post.tail_info);
            }
            if (post.lbs_info != null) {
                b05 b05Var = new b05();
                this.v = b05Var;
                b05Var.c(post.lbs_info);
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
                    xz4 xz4Var2 = new xz4();
                    xz4Var2.b(post.ext_tails.get(i3));
                    this.F.add(xz4Var2);
                }
            }
            this.H = post.skin_info;
            this.I = post.lego_card;
            TPointPost tPointPost = post.tpoint_post;
            if (post.agree != null) {
                this.J.postId = this.b;
                this.J.parseProtobuf(post.agree);
            }
            this.Q = post.is_post_visible.intValue() == 1;
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
                vz4 vz4Var = new vz4();
                this.q0 = vz4Var;
                vz4Var.o(post.advertisement);
            }
            if (post.novel_info != null) {
                e05 e05Var = new e05();
                this.r0 = e05Var;
                e05Var.l(post.novel_info);
            }
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            this.m.clear();
            this.m = null;
            this.l = false;
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048635, this, str) == null) || this.m == null || StringUtils.isNull(str)) {
            return;
        }
        Iterator<PostData> it = this.m.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null && str.equals(next.I())) {
                this.m.remove(next);
                return;
            }
        }
    }

    public void m0(vz4 vz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, vz4Var) == null) {
            this.q0 = vz4Var;
        }
    }

    public String n() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> A;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (A = tbRichText.A()) == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<TbRichTextData> it = A.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 1) {
                    stringBuffer.append(next.I().toString());
                } else if (next.getType() == 17) {
                    String str = next.B().mGifInfo.mSharpText;
                    if (str != null && str.startsWith(SmallTailInfo.EMOTION_PREFIX) && str.endsWith(SmallTailInfo.EMOTION_SUFFIX)) {
                        String substring = str.substring(2, str.length() - 1);
                        stringBuffer.append(PreferencesUtil.LEFT_MOUNT + substring + PreferencesUtil.RIGHT_MOUNT);
                    }
                } else if (next.getType() == 8) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0528) + PreferencesUtil.RIGHT_MOUNT);
                } else if (next.getType() == 512) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0af2) + PreferencesUtil.RIGHT_MOUNT);
                } else if (next.getType() == 32) {
                    stringBuffer.append(PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f152a) + PreferencesUtil.RIGHT_MOUNT);
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }

    public void n0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, metaData) == null) {
            this.f = metaData;
        }
    }

    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            try {
                if (this.n != null) {
                    ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(this.n.toString());
                    return;
                }
                if (this.i == null || this.i.size() == 0) {
                    K0();
                }
                ArrayList<xj8> arrayList = this.i;
                if (arrayList != null) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<xj8> it = arrayList.iterator();
                    while (it.hasNext()) {
                        xj8 next = it.next();
                        if (next.getType() == 0) {
                            if (next.j() != null) {
                                sb.append((CharSequence) next.j());
                            }
                        } else if (next.getType() == 3) {
                            if (next.g() != null) {
                                sb.append(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e5e));
                            }
                        } else if (next.getType() == 6) {
                            sb.append(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f155f));
                        } else if (next.getType() == 2) {
                            String f = TbFaceManager.e().f(next.i());
                            if (f != null) {
                                sb.append(PreferencesUtil.LEFT_MOUNT);
                                sb.append(f);
                                sb.append(PreferencesUtil.RIGHT_MOUNT);
                            }
                        } else if (next.getType() == 11 && !li.isEmpty(next.f())) {
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

    public vz4 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.q0 : (vz4) invokeV.objValue;
    }

    public void p0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i) == null) {
            this.d = i;
        }
    }

    public AgreeData q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.J : (AgreeData) invokeV.objValue;
    }

    public void q0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048643, this, j) == null) {
            this.t0 = j;
        }
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.J.agreeType : invokeV.intValue;
    }

    public void r0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, str) == null) {
            this.u0 = str;
        }
    }

    public MetaData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.f : (MetaData) invokeV.objValue;
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.X = z;
        }
    }

    public void t0(cq4 cq4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, cq4Var) == null) {
            this.q = cq4Var;
        }
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.s : (String) invokeV.objValue;
    }

    public void u0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, str) == null) {
            this.b = str;
        }
    }

    public tj8 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.x : (tj8) invokeV.objValue;
    }

    public void v0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048652, this, z) == null) {
            this.W = z;
        }
    }

    public long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.J.disAgreeNum : invokeV.longValue;
    }

    public void w0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048654, this, z) == null) {
            this.w = z;
        }
    }

    public ArrayList<PostData> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.m : (ArrayList) invokeV.objValue;
    }

    public void x0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048656, this, z) == null) {
            this.S = z;
        }
    }

    public PreLoadImageInfo y() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> A;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            TbRichText tbRichText = this.n;
            if (tbRichText == null || (A = tbRichText.A()) == null) {
                return null;
            }
            Iterator<TbRichTextData> it = A.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8) {
                    PreLoadImageInfo preLoadImageInfo = new PreLoadImageInfo();
                    preLoadImageInfo.width = next.E().getWidth();
                    preLoadImageInfo.height = next.E().getHeight();
                    preLoadImageInfo.imgUrl = next.E().A();
                    preLoadImageInfo.procType = 17;
                    return preLoadImageInfo;
                } else if (next.getType() == 20) {
                    PreLoadImageInfo preLoadImageInfo2 = new PreLoadImageInfo();
                    preLoadImageInfo2.width = next.H().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.H().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.H().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return (PreLoadImageInfo) invokeV.objValue;
    }

    public void y0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048658, this, z) == null) {
            this.l = z;
        }
    }

    public String z() {
        InterceptResult invokeV;
        vj8 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            PreLoadImageInfo y = y();
            if (y != null && !StringUtils.isNull(y.imgUrl)) {
                return y.imgUrl;
            }
            tj8 tj8Var = this.x;
            if (tj8Var == null || (a2 = tj8Var.a()) == null || StringUtils.isNull(a2.c())) {
                return null;
            }
            return a2.c();
        }
        return (String) invokeV.objValue;
    }

    public void z0(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048660, this, originalThreadInfo) == null) {
            this.T = originalThreadInfo;
        }
    }
}
