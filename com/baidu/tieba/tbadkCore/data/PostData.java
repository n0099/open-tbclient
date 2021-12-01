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
import c.a.d.f.p.k;
import c.a.d.m.e.n;
import c.a.d.m.g;
import c.a.q0.f1.n.e;
import c.a.q0.f1.n.j;
import c.a.q0.s.q.d1;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.z1;
import c.a.q0.u.g;
import c.a.r0.t3.j0.i;
import c.a.r0.t3.j0.m;
import c.a.r0.t3.j0.o;
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
/* loaded from: classes11.dex */
public class PostData implements PreLoadImageProvider, n {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId A0;
    public static final BdUniqueId B0;
    public static final BdUniqueId C0;
    public static final BdUniqueId D0;
    public static final BdUniqueId E0;
    public static final BdUniqueId F0;
    public static boolean G0;
    public static final BdUniqueId y0;
    public static final BdUniqueId z0;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public i B;
    public z1 C;
    public int D;
    public String E;
    public boolean F;
    public int G;
    public j H;
    public TbRichTextVoiceInfo I;
    public ArrayList<c.a.q0.u.c> J;
    public String K;
    public SkinInfo L;
    public String M;
    public AgreeData N;
    public boolean O;
    public boolean P;
    public int Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public AlaLiveInfoCoreData V;
    public boolean W;
    public OriginalThreadInfo X;
    public int Y;
    public String Z;
    public boolean a0;
    public boolean b0;
    public boolean c0;
    public boolean d0;

    /* renamed from: e  reason: collision with root package name */
    public int f49260e;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public String f49261f;
    public int f0;

    /* renamed from: g  reason: collision with root package name */
    public long f49262g;
    public StatisticItem g0;

    /* renamed from: h  reason: collision with root package name */
    public int f49263h;
    public List<HeadItem> h0;

    /* renamed from: i  reason: collision with root package name */
    public long f49264i;
    public Item i0;

    /* renamed from: j  reason: collision with root package name */
    public MetaData f49265j;
    @Deprecated

    /* renamed from: k  reason: collision with root package name */
    public String f49266k;
    public boolean k0;
    public ArrayList<m> l;
    public ArrayList<m> m;
    public int n;
    public ArrayList<PostData> o;
    public boolean p;
    public ArrayList<PostData> q;
    public List<PbContent> q0;
    public TbRichText r;
    public int r0;
    public PraiseData s;
    public Item s0;
    public SmallTailInfo t;
    public int t0;
    public d1 u;
    public c.a.q0.u.a u0;
    public c.a.r0.t3.j0.c v;
    public o v0;
    public String w;
    public long w0;
    public HashMap<String, MetaData> x;
    public d x0;
    public c.a.q0.u.c y;
    public g z;

    /* loaded from: classes11.dex */
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

    /* loaded from: classes11.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (statisticItem = this.a.g0) == null) {
                return;
            }
            StatisticItem copy = statisticItem.copy();
            copy.delete("obj_locate");
            copy.param("obj_locate", 7);
            TiebaStatic.log(copy);
        }
    }

    /* loaded from: classes11.dex */
    public class b implements g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ IconData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BdUniqueId f49267b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PostData f49268c;

        /* loaded from: classes11.dex */
        public class a extends c.a.d.f.l.c<c.a.d.m.d.a> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.d.m.g a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f49269b;

            public a(b bVar, c.a.d.m.g gVar) {
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
                this.f49269b = bVar;
                this.a = gVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.a.d.f.l.c
            public void onLoaded(c.a.d.m.d.a aVar, String str, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLLI(1048576, this, aVar, str, i2) == null) {
                    super.onLoaded((a) aVar, str, i2);
                    if (aVar == null || !aVar.w()) {
                        return;
                    }
                    this.a.a(this.f49269b.f49268c.i(aVar));
                    this.f49269b.f49268c.r.isChanged = true;
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
            this.f49268c = postData;
            this.a = iconData;
            this.f49267b = bdUniqueId;
        }

        @Override // c.a.d.m.g.a
        public Drawable a(c.a.d.m.g gVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
                c.a.d.m.d.a aVar = (c.a.d.m.d.a) c.a.d.f.l.d.h().n(this.a.getIcon(), 21, new Object[0]);
                if (aVar == null) {
                    c.a.d.f.l.d.h().m(this.a.getIcon(), 21, new a(this, gVar), this.f49267b);
                }
                return this.f49268c.i(aVar);
            }
            return (Drawable) invokeL.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static class c extends ClickableSpan {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f49270e;

        /* renamed from: f  reason: collision with root package name */
        public String f49271f;

        /* renamed from: g  reason: collision with root package name */
        public d f49272g;

        public c(String str, String str2, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49270e = null;
            this.f49271f = null;
            this.f49270e = str;
            this.f49271f = str2;
            this.f49272g = dVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f49270e == null || this.f49271f == null) {
                return;
            }
            d dVar = this.f49272g;
            if (dVar != null) {
                dVar.onClick();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkCoreApplication.getInst(), this.f49271f, this.f49270e, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint) == null) {
                if (c.a.q0.b.d.L()) {
                    textPaint.setColor(SkinManager.getColor(R.color.CAM_X0318));
                } else {
                    textPaint.setColor(SkinManager.getColor(R.color.CAM_X0108));
                }
                textPaint.setUnderlineText(false);
                textPaint.setFakeBoldText(!c.a.q0.b.d.L());
            }
        }
    }

    /* loaded from: classes11.dex */
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
        y0 = BdUniqueId.gen();
        z0 = BdUniqueId.gen();
        A0 = BdUniqueId.gen();
        B0 = BdUniqueId.gen();
        C0 = BdUniqueId.gen();
        D0 = BdUniqueId.gen();
        BdUniqueId.gen();
        E0 = BdUniqueId.gen();
        F0 = BdUniqueId.gen();
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
        this.f49260e = 0;
        this.o = null;
        this.p = false;
        this.q = null;
        this.r = null;
        this.A = false;
        this.D = 0;
        this.G = 0;
        this.O = false;
        this.P = false;
        this.Q = 0;
        this.R = true;
        this.T = false;
        this.U = false;
        this.W = false;
        this.Y = 0;
        this.a0 = true;
        this.c0 = false;
        this.d0 = false;
        this.e0 = false;
        this.k0 = false;
        this.r0 = 4;
        this.x0 = new a(this);
        this.f49261f = null;
        this.f49263h = 0;
        this.f49264i = 0L;
        this.f49265j = new MetaData();
        this.l = new ArrayList<>();
        this.m = new ArrayList<>();
        this.n = 0;
        this.o = new ArrayList<>();
        this.s = new PraiseData();
        this.u = new d1();
        this.v = new c.a.r0.t3.j0.c();
        this.J = new ArrayList<>();
        this.Q = 0;
        this.N = new AgreeData();
    }

    public int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f49263h : invokeV.intValue;
    }

    public void A0(SmallTailInfo smallTailInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, smallTailInfo) == null) {
            this.t = smallTailInfo;
        }
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.E : (String) invokeV.objValue;
    }

    public void B0(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.f49264i = j2;
            StringHelper.getFormatTime(j2);
        }
    }

    public int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.D : invokeV.intValue;
    }

    public void C0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.Z : (String) invokeV.objValue;
    }

    public void D0(HashMap<String, MetaData> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hashMap) == null) {
            this.x = hashMap;
        }
    }

    public int E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.Y : invokeV.intValue;
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            OriginalThreadInfo originalThreadInfo = this.X;
            return originalThreadInfo != null && originalThreadInfo.G && this.w0 == originalThreadInfo.f40903e;
        }
        return invokeV.booleanValue;
    }

    public d1 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.u : (d1) invokeV.objValue;
    }

    public void F0(TbPageContext tbPageContext, boolean z) {
        TbRichText tbRichText;
        String str;
        SpannableString spannableString;
        String str2;
        String str3;
        TbRichTextVoiceInfo tbRichTextVoiceInfo;
        TbRichTextData tbRichTextData;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048587, this, tbPageContext, z) == null) || this.c0 || tbPageContext == null || (tbRichText = this.r) == null || tbRichText.y() == null) {
            return;
        }
        BdUniqueId uniqueId = tbPageContext.getUniqueId();
        if (z) {
            str = " 楼主";
        } else {
            MetaData metaData2 = this.f49265j;
            if (metaData2 != null && metaData2.getIs_bawu() == 1) {
                if (this.b0) {
                    str = " 品牌官";
                } else if ("manager".equals(this.f49265j.getBawu_type())) {
                    str = " 吧主";
                } else if (PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(this.f49265j.getBawu_type())) {
                    str = " 小吧主";
                } else if ("pri_content_assist".equals(this.f49265j.getBawu_type())) {
                    str = " 内容吧务";
                } else if ("pri_manage_assist".equals(this.f49265j.getBawu_type())) {
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
                c.a.d.m.g gVar = new c.a.d.m.g(new b(this, it.next(), uniqueId), 0, 1);
                gVar.b(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
                arrayList.add(gVar);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            sb.append(i2);
        }
        if (!StringUtils.isNull(this.f49265j.getSealPrefix())) {
            sb.append(" ");
            sb.append(this.f49265j.getSealPrefix());
        }
        if (sb.length() > 0) {
            sb.append(" ");
        }
        String sb2 = sb.toString();
        if (this.f49265j != null) {
            spannableString = new SpannableString(sb2 + this.f49265j.getName_show() + str + "：");
            str2 = this.f49265j.getUserName();
            str3 = this.f49265j.getUserId();
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
        MetaData metaData3 = this.f49265j;
        if (metaData3 != null && !StringUtils.isNull(metaData3.getSealPrefix())) {
            Bitmap bitmap = SkinManager.getBitmap(R.drawable.pic_smalldot_title);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
            if (bitmap != null) {
                bitmapDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            }
            c.a.q0.s.g0.j jVar = new c.a.q0.s.g0.j(bitmapDrawable);
            jVar.b(UtilHelper.getDimenPixelSize(R.dimen.ds2));
            int size = arrayList.size() + this.f49265j.getSealPrefix().length() + 1;
            spannableString.setSpan(jVar, size, size + 1, 17);
        }
        spannableString.setSpan(new c(str2, str3, this.x0), 0, spannableString.length(), 18);
        if (!StringUtils.isNull(str) && (z || ((metaData = this.f49265j) != null && metaData.getIs_bawu() == 1))) {
            MetaData metaData4 = this.f49265j;
            c.a.q0.s.g0.b h2 = h(z, metaData4 != null && metaData4.getIs_bawu() == 1, str);
            if (h2 != null) {
                MetaData metaData5 = this.f49265j;
                if (metaData5 != null) {
                    int length = metaData5.getName_show() != null ? this.f49265j.getName_show().length() : 0;
                    spannableString.setSpan(h2, sb2.length() + length + 1, sb2.length() + length + str.length(), 17);
                } else {
                    spannableString.setSpan(h2, sb2.length(), sb2.length() + str.length(), 17);
                }
            }
        }
        ArrayList<TbRichTextData> y = this.r.y();
        if (y != null && y.size() > 0) {
            TbRichTextData tbRichTextData2 = y.get(0);
            if (tbRichTextData2 != null && tbRichTextData2.G() != null) {
                if (this.W) {
                    int indexOf = tbRichTextData2.G().toString().indexOf("：");
                    if (indexOf > 0) {
                        tbRichTextData2.G().delete(0, indexOf + 1);
                    }
                    this.W = false;
                }
                tbRichTextData2.X(sb.length());
                tbRichTextData2.G().insert(0, (CharSequence) spannableString);
            } else {
                int i5 = 0;
                while (true) {
                    if (i5 >= y.size()) {
                        tbRichTextVoiceInfo = null;
                        break;
                    } else if (y.get(i5) != null && y.get(i5).getType() == 512) {
                        tbRichTextVoiceInfo = y.get(i5).M();
                        y.remove(i5);
                        break;
                    } else {
                        i5++;
                    }
                }
                if (tbRichTextVoiceInfo != null) {
                    tbRichTextData = new TbRichTextData(768);
                    tbRichTextData.a0(tbRichTextVoiceInfo);
                } else {
                    tbRichTextData = new TbRichTextData(1);
                }
                tbRichTextData.X(sb.length());
                tbRichTextData.x(spannableString);
                y.add(0, tbRichTextData);
            }
        }
        this.c0 = true;
    }

    public String G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f49261f : (String) invokeV.objValue;
    }

    public void G0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.l == null) {
            return;
        }
        int i2 = -1;
        int size = this.m.size();
        if (size > 0) {
            try {
                i2 = this.m.get(size - 1).getType();
            } catch (Exception e2) {
                BdLog.detailException(e2);
                return;
            }
        }
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            m mVar = this.l.get(i3);
            if (m.k(i2, mVar.getType())) {
                this.m.get(size - 1).e(mVar.h());
            } else {
                if (mVar.getType() != 3 && mVar.getType() != 2 && mVar.getType() != 11) {
                    m mVar2 = new m();
                    mVar2.l(0);
                    mVar2.e(mVar.h());
                    this.m.add(mVar2);
                    i2 = 0;
                    size++;
                }
                this.m.add(mVar);
                i2 = mVar.getType();
                size++;
            }
        }
    }

    public Item H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.i0 : (Item) invokeV.objValue;
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.G == 0) {
            this.G = 1;
        }
    }

    public List<HeadItem> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.h0 : (List) invokeV.objValue;
    }

    public String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.M : (String) invokeV.objValue;
    }

    public c.a.q0.u.g K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.z : (c.a.q0.u.g) invokeV.objValue;
    }

    public OriginalThreadInfo L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.X : (OriginalThreadInfo) invokeV.objValue;
    }

    public TbRichText M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.r : (TbRichText) invokeV.objValue;
    }

    public SkinInfo N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.L : (SkinInfo) invokeV.objValue;
    }

    public ArrayList<PostData> O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.o : (ArrayList) invokeV.objValue;
    }

    public int P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (O() != null) {
                return O().size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.n : invokeV.intValue;
    }

    public SmallTailInfo R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.t : (SmallTailInfo) invokeV.objValue;
    }

    public String S() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> y;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
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
                        sb.append(next.G().toString());
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

    public long T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f49262g : invokeV.longValue;
    }

    public long U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.f49264i : invokeV.longValue;
    }

    public HashMap<String, MetaData> V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.x : (HashMap) invokeV.objValue;
    }

    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.K : (String) invokeV.objValue;
    }

    public j X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            j jVar = this.H;
            if (jVar != null) {
                return jVar;
            }
            TbRichText tbRichText = this.r;
            if (tbRichText == null || ListUtils.getCount(tbRichText.y()) <= 0) {
                return null;
            }
            Iterator<TbRichTextData> it = this.r.y().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null && next.getType() == 32) {
                    j L = next.L();
                    this.H = L;
                    return L;
                }
            }
            return null;
        }
        return (j) invokeV.objValue;
    }

    public TbRichTextVoiceInfo Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = this.I;
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
                    TbRichTextVoiceInfo M = next.M();
                    this.I = M;
                    return M;
                }
            }
            return null;
        }
        return (TbRichTextVoiceInfo) invokeV.objValue;
    }

    public boolean Z(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048609, this, z)) == null) {
            return P() <= (z ? 2 : 4) && Q() > P();
        }
        return invokeZ.booleanValue;
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? Q() > 0 && O() != null && O().size() > 0 : invokeV.booleanValue;
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.b0 : invokeV.booleanValue;
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.a0 : invokeV.booleanValue;
    }

    public void d(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, postData) == null) || postData == null) {
            return;
        }
        if (this.q == null) {
            this.q = new ArrayList<>();
            int count = ListUtils.getCount(this.o);
            int i2 = this.r0;
            if (count > i2) {
                this.q.addAll(ListUtils.subList(this.o, 0, i2));
            } else {
                this.q.addAll(this.o);
            }
        }
        this.q.add(postData);
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public void e(PostData postData) {
        ArrayList<PostData> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, postData) == null) || postData == null || (arrayList = this.o) == null) {
            return;
        }
        arrayList.add(postData);
        g();
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public void f0(SubPostList subPostList, boolean z, @Nullable d2 d2Var, int i2) {
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048617, this, new Object[]{subPostList, Boolean.valueOf(z), d2Var, Integer.valueOf(i2)}) == null) || subPostList == null) {
            return;
        }
        try {
            this.f49261f = String.valueOf(subPostList.id);
            String str = subPostList.title;
            this.f49263h = subPostList.floor.intValue();
            long intValue = subPostList.time.intValue() * 1000;
            this.f49264i = intValue;
            StringHelper.getFormatTime(intValue);
            this.f49266k = String.valueOf(subPostList.author_id);
            subPostList.is_giftpost.intValue();
            this.N.postId = this.f49261f;
            this.N.parseProtobuf(subPostList.agree);
            MetaData metaData2 = new MetaData();
            metaData2.parserProtobuf(subPostList.author);
            if (this.f49266k != null && this.f49266k.length() > 0 && !this.f49266k.equals("0") && this.x != null && (metaData = this.x.get(this.f49266k)) != null) {
                this.f49265j = metaData;
            }
            if (this.f49265j.getUserId() == null || this.f49265j.getUserId().length() <= 0 || this.f49265j.getUserId().equals("0")) {
                this.f49265j = metaData2;
            }
            TbRichText parser = TbRichTextView.parser(subPostList.content, null, z, this, d2Var, i2);
            this.r = parser;
            if (parser != null) {
                parser.F(c.a.d.f.m.b.g(this.f49261f, -1L));
            }
            this.t0 = subPostList.is_author_view.intValue();
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            this.n++;
        }
    }

    public void g0(Post post) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, post) == null) {
            h0(post, null);
        }
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            TbRichText tbRichText = this.r;
            if (tbRichText == null || (y = tbRichText.y()) == null) {
                return null;
            }
            ArrayList<PreLoadImageInfo> arrayList = new ArrayList<>();
            Iterator<TbRichTextData> it = y.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 8 && next.C() != null) {
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
            if (this.f49265j == null) {
                return arrayList;
            }
            PreLoadImageInfo preLoadImageInfo4 = new PreLoadImageInfo();
            preLoadImageInfo4.imgUrl = this.f49265j.getPortrait();
            preLoadImageInfo4.procType = 12;
            arrayList.add(preLoadImageInfo4);
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            int i2 = this.f49260e;
            if (i2 == 52) {
                return E0;
            }
            if (i2 == 1) {
                return A0;
            }
            if (i2 == 36) {
                return B0;
            }
            if (i2 == 40 || i2 == 50) {
                return C0;
            }
            if (i2 == 41) {
                return D0;
            }
            if (i2 == 53) {
                return F0;
            }
            if (A() == 1) {
                return y0;
            }
            o oVar = this.v0;
            if (oVar == null || !oVar.f()) {
                return z0;
            }
            return this.v0.g() ? AdvertAppInfo.H4 : AdvertAppInfo.J4;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public final c.a.q0.s.g0.b h(boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048622, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            if (z || z2) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.L_X01);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds10);
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds26);
                int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds12);
                int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.tbds40);
                if (" 楼主".equals(str)) {
                    int i2 = R.color.CAM_X0302;
                    c.a.q0.s.g0.b bVar = new c.a.q0.s.g0.b(dimenPixelSize, -1, i2, dimenPixelSize3, i2, dimenPixelSize4, dimenPixelSize5);
                    bVar.b(dimenPixelSize2);
                    bVar.f(false);
                    bVar.e(str);
                    return bVar;
                } else if (" 吧主".equals(str) || " 小吧主".equals(str) || " 品牌官".equals(str)) {
                    c.a.q0.s.g0.b bVar2 = new c.a.q0.s.g0.b(dimenPixelSize, -1, R.color.CAM_X0302, dimenPixelSize3, R.color.CAM_X0101, dimenPixelSize4, dimenPixelSize5);
                    bVar2.b(dimenPixelSize2);
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
        return (c.a.q0.s.g0.b) invokeCommon.objValue;
    }

    public void h0(Post post, @Nullable d2 d2Var) {
        int i2;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048623, this, post, d2Var) == null) || post == null) {
            return;
        }
        try {
            this.f49261f = String.valueOf(post.id);
            this.f49262g = post.tid.longValue();
            String str = post.title;
            this.f49263h = post.floor.intValue();
            long intValue = post.time.intValue() * 1000;
            this.f49264i = intValue;
            StringHelper.getFormatTime(intValue);
            String str2 = post.time_ex;
            String valueOf = String.valueOf(post.author_id);
            this.f49266k = valueOf;
            if (valueOf != null && valueOf.length() > 0 && !this.f49266k.equals("0") && this.x != null && (metaData = this.x.get(this.f49266k)) != null) {
                this.f49265j = metaData;
            }
            this.O = post.need_log.intValue() == 1;
            this.P = post.img_num_abtest.intValue() == 1;
            z1 z1Var = new z1();
            this.C = z1Var;
            z1Var.f(post.from_forum);
            if (this.f49265j.getUserId() == null || this.f49265j.getUserId().length() <= 0 || this.f49265j.getUserId().equals("0")) {
                this.f49265j.parserProtobuf(post.author);
            }
            if (this.f49265j != null) {
                this.K = this.f49265j.getUserName() + TbadkCoreApplication.getInst().getResources().getString(R.string.somebodys_portrait);
                String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.degree_in_forum), Integer.valueOf(this.f49265j.getLevel_id()));
            }
            post.is_ntitle.intValue();
            this.n = post.sub_post_number.intValue();
            this.B = new i(post.tpoint_post);
            List<PbContent> list = post.content;
            this.q0 = post.content;
            post.is_wonderful_post.intValue();
            this.d0 = post.is_top_agree_post.intValue() == 1;
            this.h0 = post.item_star;
            this.D = post.fold_comment_status.intValue();
            this.E = post.fold_comment_apply_url;
            if (post.item != null && post.item.item_id.longValue() != 0) {
                this.i0 = post.item;
            }
            if (this.i0 == null && post.outer_item != null && post.outer_item.item_id.longValue() > 0) {
                this.s0 = post.outer_item;
            }
            TbRichText parser = TbRichTextView.parser(list, String.valueOf(post.tid), true, this, d2Var, A());
            this.r = parser;
            if (parser != null) {
                parser.F(c.a.d.f.m.b.g(this.f49261f, -1L));
                this.r.E(this.f49263h);
                if (this.f49265j != null) {
                    this.r.setAuthorId(this.f49265j.getUserId());
                }
                int count = ListUtils.getCount(this.h0);
                if (this.f49263h == 1 && count != 0 && this.h0 != null) {
                    ArrayList<TbRichTextData> y = this.r.y();
                    if (count == 1) {
                        TbRichTextData tbRichTextData = (TbRichTextData) ListUtils.getItem(y, 0);
                        if (tbRichTextData == null || tbRichTextData.getType() != 1) {
                            tbRichTextData = new TbRichTextData(1);
                            ListUtils.add(y, 0, tbRichTextData);
                        }
                        HeadItem headItem = (HeadItem) ListUtils.getItem(this.h0, 0);
                        if (headItem != null) {
                            try {
                                i2 = Integer.parseInt(headItem.content);
                            } catch (NumberFormatException unused) {
                                i2 = 0;
                            }
                            tbRichTextData.b0(e.q(i2, false));
                        }
                    } else {
                        for (int size = this.h0.size() - 1; size >= 0; size--) {
                            HeadItem headItem2 = this.h0.get(size);
                            if (headItem2 != null) {
                                k(y, headItem2);
                            }
                        }
                    }
                }
                if (this.f49263h == 1 && this.i0 != null) {
                    TbRichTextData tbRichTextData2 = new TbRichTextData(1281);
                    tbRichTextData2.P(new TbRichTextEvaluateItemInfo(this.i0));
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
                        postData.N.parseProtobuf(subPostList.agree);
                        postData.D0(this.x);
                        postData.o0(this.b0);
                        postData.f0(subPostList, false, d2Var, A());
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
                c.a.q0.u.c cVar = new c.a.q0.u.c();
                this.y = cVar;
                cVar.b(post.tail_info);
            }
            if (post.lbs_info != null) {
                c.a.q0.u.g gVar = new c.a.q0.u.g();
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
                        list3.add(new SmallTailInfo.SmallTailInfoContent(smallTailInfo2, signatureContent.text, signatureContent.type.intValue()));
                    }
                }
                this.t.updateShowInfo();
            }
            if (post.ext_tails != null) {
                for (int i4 = 0; i4 != post.ext_tails.size(); i4++) {
                    c.a.q0.u.c cVar2 = new c.a.q0.u.c();
                    cVar2.b(post.ext_tails.get(i4));
                    this.J.add(cVar2);
                }
            }
            this.L = post.skin_info;
            this.M = post.lego_card;
            TPointPost tPointPost = post.tpoint_post;
            if (post.agree != null) {
                this.N.postId = this.f49261f;
                this.N.parseProtobuf(post.agree);
            }
            this.U = post.is_post_visible.intValue() == 1;
            if (post.origin_thread_info != null && !StringUtils.isNull(post.origin_thread_info.tid)) {
                OriginalThreadInfo originalThreadInfo = new OriginalThreadInfo();
                this.X = originalThreadInfo;
                originalThreadInfo.l(post.origin_thread_info);
            } else {
                this.X = null;
            }
            this.Y = post.is_fold.intValue();
            this.Z = post.fold_tip;
            if (post.advertisement != null) {
                c.a.q0.u.a aVar = new c.a.q0.u.a();
                this.u0 = aVar;
                aVar.n(post.advertisement);
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }

    public Drawable i(c.a.d.m.d.a aVar) {
        InterceptResult invokeL;
        Bitmap p;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, aVar)) == null) {
            if (aVar == null || (p = aVar.p()) == null) {
                return null;
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(p);
            bitmapDrawable.setBounds(0, 0, TbConfig.getContentSizeOfLzl(), TbConfig.getContentSizeOfLzl());
            return bitmapDrawable;
        }
        return (Drawable) invokeL.objValue;
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            this.q.clear();
            this.q = null;
            this.p = false;
        }
    }

    public void j0(c.a.q0.u.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, aVar) == null) {
            this.u0 = aVar;
        }
    }

    public final void k(List<TbRichTextData> list, HeadItem headItem) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048627, this, list, headItem) == null) {
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
                spannableStringBuilder.append((CharSequence) e.q(i2, true));
            }
            tbRichTextData.x(spannableStringBuilder);
            ListUtils.add(list, 0, tbRichTextData);
        }
    }

    public void k0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, metaData) == null) {
            this.f49265j = metaData;
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.n--;
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            try {
                if (this.r != null) {
                    ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(this.r.toString());
                    return;
                }
                if (this.m == null || this.m.size() == 0) {
                    G0();
                }
                ArrayList<m> arrayList = this.m;
                if (arrayList != null) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<m> it = arrayList.iterator();
                    while (it.hasNext()) {
                        m next = it.next();
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
                            String f2 = TbFaceManager.e().f(next.i());
                            if (f2 != null) {
                                sb.append(PreferencesUtil.LEFT_MOUNT);
                                sb.append(f2);
                                sb.append(PreferencesUtil.RIGHT_MOUNT);
                            }
                        } else if (next.getType() == 11 && !k.isEmpty(next.f())) {
                            sb.append(PreferencesUtil.LEFT_MOUNT);
                            sb.append(next.f());
                            sb.append(PreferencesUtil.RIGHT_MOUNT);
                        }
                    }
                    ((ClipboardManager) TbadkCoreApplication.getInst().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setText(sb.toString());
                }
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            this.f49263h = i2;
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048632, this, str) == null) || this.q == null || StringUtils.isNull(str)) {
            return;
        }
        Iterator<PostData> it = this.q.iterator();
        while (it.hasNext()) {
            PostData next = it.next();
            if (next != null && str.equals(next.G())) {
                this.q.remove(next);
                return;
            }
        }
    }

    public void n0(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048633, this, j2) == null) {
            this.w0 = j2;
        }
    }

    public String o() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            TbRichText tbRichText = this.r;
            if (tbRichText == null || (y = tbRichText.y()) == null) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<TbRichTextData> it = y.iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next.getType() == 1) {
                    stringBuffer.append(next.G().toString());
                } else if (next.getType() == 17) {
                    String str = next.z().mGifInfo.mSharpText;
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

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.b0 = z;
        }
    }

    public c.a.q0.u.a p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.u0 : (c.a.q0.u.a) invokeV.objValue;
    }

    public void p0(d1 d1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, d1Var) == null) {
            this.u = d1Var;
        }
    }

    public AgreeData q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.N : (AgreeData) invokeV.objValue;
    }

    public void q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
            this.f49261f = str;
        }
    }

    public void r0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048640, this, z) == null) {
            this.a0 = z;
        }
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.N.agreeType : invokeV.intValue;
    }

    public void s0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z) == null) {
            this.A = z;
        }
    }

    public MetaData t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? this.f49265j : (MetaData) invokeV.objValue;
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048644, this, z) == null) {
            this.W = z;
        }
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.w : (String) invokeV.objValue;
    }

    public void u0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048646, this, z) == null) {
            this.p = z;
        }
    }

    public i v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.B : (i) invokeV.objValue;
    }

    public void v0(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, originalThreadInfo) == null) {
            this.X = originalThreadInfo;
        }
    }

    public long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.N.disAgreeNum : invokeV.longValue;
    }

    public void w0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i2) == null) {
            this.f49260e = i2;
        }
    }

    public ArrayList<PostData> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.q : (ArrayList) invokeV.objValue;
    }

    public void x0(PraiseData praiseData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, praiseData) == null) {
            this.s = praiseData;
        }
    }

    public PreLoadImageInfo y() {
        InterceptResult invokeV;
        ArrayList<TbRichTextData> y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
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
                    preLoadImageInfo2.width = next.F().memeInfo.width.intValue();
                    preLoadImageInfo2.height = next.F().memeInfo.height.intValue();
                    preLoadImageInfo2.imgUrl = next.F().memeInfo.pic_url;
                    preLoadImageInfo2.procType = 17;
                    return preLoadImageInfo2;
                }
            }
            return null;
        }
        return (PreLoadImageInfo) invokeV.objValue;
    }

    public void y0(TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, tbRichText) == null) {
            this.r = tbRichText;
        }
    }

    public String z() {
        InterceptResult invokeV;
        c.a.r0.t3.j0.k a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
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

    public void z0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048656, this, i2) == null) {
            this.n = i2;
        }
    }
}
