package com.baidu.tieba;

import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.jza;
import com.baidu.tieba.l0b;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.n0b;
import com.baidu.tieba.write.webwrite.data.BizBase;
import com.baidu.tieba.write.webwrite.data.WrapListener;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
/* loaded from: classes6.dex */
public final class jza extends BizBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final EditorTools g;
    public nga h;

    /* loaded from: classes6.dex */
    public interface b {
        void a();

        void b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947901976, "Lcom/baidu/tieba/jza;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947901976, "Lcom/baidu/tieba/jza;");
        }
    }

    @Override // com.baidu.tieba.fya
    public cya[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (cya[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fya
    public WrapListener[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (WrapListener[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fya
    public dya[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (dya[]) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public static final class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext<?> a;
        public final /* synthetic */ WriteData b;
        public final /* synthetic */ jza c;

        public a(TbPageContext<?> tbPageContext, WriteData writeData, jza jzaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, writeData, jzaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tbPageContext;
            this.b = writeData;
            this.c = jzaVar;
        }

        @Override // com.baidu.tieba.jza.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    k0b.d(this.a.getPageActivity(), 2);
                    k0b.e(this.b);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.showToast((int) R.string.obfuscated_res_0x7f0f0e4f);
                    } else if (os5.a()) {
                    } else {
                        this.c.u();
                    }
                } catch (Exception e) {
                    TbLog hybridLog = HybridLog.getInstance();
                    hybridLog.e("PostDataBiz", "发布失败 " + e);
                }
            }
        }

        @Override // com.baidu.tieba.jza.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.c.w();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements l0b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<jza> a;

        public c(jza tool) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tool};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(tool, "tool");
            this.a = new WeakReference<>(tool);
        }

        public static final void b(jza tool, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65537, null, tool, z) == null) {
                Intrinsics.checkNotNullParameter(tool, "$tool");
                tool.t(z);
            }
        }

        @Override // com.baidu.tieba.l0b.b
        public void a(boolean z) {
            final jza jzaVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || (jzaVar = this.a.get()) == null) {
                return;
            }
            m0b.c(jzaVar.i().getPageActivity());
            if (m0b.f()) {
                return;
            }
            if (!z) {
                jzaVar.t(false);
            } else {
                new n0b(jzaVar.i().getPageActivity(), new n0b.f() { // from class: com.baidu.tieba.bza
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.n0b.f
                    public final void a(boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                            jza.c.b(jza.this, z2);
                        }
                    }
                }).j();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jza(TbPageContext<?> pageContext, TbWebView webView, WriteData writeData, xya writePageState, EditorTools editor) {
        super(pageContext, webView, writeData, writePageState);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, webView, writeData, writePageState, editor};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (TbWebView) objArr2[1], (WriteData) objArr2[2], (xya) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(writeData, "writeData");
        Intrinsics.checkNotNullParameter(writePageState, "writePageState");
        Intrinsics.checkNotNullParameter(editor, "editor");
        this.g = editor;
        nga l = nga.l();
        Intrinsics.checkNotNullExpressionValue(l, "getInstance()");
        this.h = l;
        writePageState.B(new a(pageContext, writeData, this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005c, code lost:
        if (kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r0, (java.lang.CharSequence) "#(url", false, 2, (java.lang.Object) null) != false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void s() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            w();
            if (k().getVoiceModel() == null && k().getWriteVoteData() == null && !ListUtils.isNotEmpty(k().getItemDatas())) {
                if (k().getContent() != null) {
                    String content = k().getContent();
                    Intrinsics.checkNotNullExpressionValue(content, "writeData.content");
                    if (!StringsKt__StringsKt.contains$default((CharSequence) content, (CharSequence) "#(commodity,commo_", false, 2, (Object) null)) {
                        String content2 = k().getContent();
                        Intrinsics.checkNotNullExpressionValue(content2, "writeData.content");
                    }
                }
                z = false;
                if (k().isQuestionThread() && m0b.d() && !z && m0b.e()) {
                    if (m0b.g()) {
                        m0b.h(i().getPageActivity());
                    }
                    l0b.c().g(k().getTitle(), k().getContent(), new c(this));
                    if (m0b.f()) {
                        t(false);
                        return;
                    }
                    return;
                }
                t(false);
            }
            z = true;
            if (k().isQuestionThread()) {
            }
            t(false);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (Intrinsics.areEqual("1", k().getCallFrom())) {
                k().setCanNoForum(true);
                k().setTransmitForumData("[]");
            } else if (Intrinsics.areEqual("2", k().getCallFrom())) {
                k().setCanNoForum(false);
            }
            this.g.D(new cd5(54, 15, null));
            this.g.D(new cd5(65, 15, null));
            if (k().getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteData k = k();
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            k.setShowCustomFigure(sharedPrefHelper.getBoolean("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), true));
            if (ff5.a()) {
                k().setShowBless(SharedPrefHelper.getInstance().getBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_write_add_bless_enable"), true));
            }
            s();
        }
    }

    public final void t(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.g.q();
            k().setVcode(null);
            nga ngaVar = this.h;
            WriteImagesInfo writeImagesInfo = k().getWriteImagesInfo();
            boolean z2 = false;
            if (writeImagesInfo != null) {
                i = writeImagesInfo.size();
            } else {
                i = 0;
            }
            if (i > 0) {
                z2 = true;
            }
            ngaVar.w(z2);
            this.h.z(k());
            if (!this.h.g()) {
                i().showToast((int) R.string.write_img_limit);
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                i().showToast((int) R.string.obfuscated_res_0x7f0f0e4f);
            } else {
                if (z) {
                    k().setQuestionThread(true);
                    k().setType(14);
                }
                v();
            }
        }
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h.A();
            exa.f(k());
            l().g().d();
            l().y(true);
            if (Intrinsics.areEqual("topic_detail", k().getFrom())) {
                l().c(-1);
            } else {
                l().c(100);
            }
        }
    }

    public final void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.h.f();
        }
    }
}
