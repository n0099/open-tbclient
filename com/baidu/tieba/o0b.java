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
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.o0b;
import com.baidu.tieba.q1b;
import com.baidu.tieba.s1b;
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
/* loaded from: classes7.dex */
public final class o0b extends BizBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final EditorTools g;
    public xha h;

    /* loaded from: classes7.dex */
    public interface b {
        void a();

        void b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947979848, "Lcom/baidu/tieba/o0b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947979848, "Lcom/baidu/tieba/o0b;");
        }
    }

    @Override // com.baidu.tieba.mza
    public jza[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (jza[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mza
    public WrapListener[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (WrapListener[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.mza
    public kza[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (kza[]) invokeV.objValue;
    }

    /* loaded from: classes7.dex */
    public static final class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TbPageContext<?> a;
        public final /* synthetic */ WriteData b;
        public final /* synthetic */ o0b c;

        public a(TbPageContext<?> tbPageContext, WriteData writeData, o0b o0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tbPageContext, writeData, o0bVar};
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
            this.c = o0bVar;
        }

        @Override // com.baidu.tieba.o0b.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    p1b.d(this.a.getPageActivity(), 1);
                    p1b.e(this.b);
                    if (!BdNetTypeUtil.isNetWorkAvailable()) {
                        this.a.showToast((int) R.string.obfuscated_res_0x7f0f0e29);
                    } else if (jx5.a()) {
                    } else {
                        this.c.u();
                    }
                } catch (Exception e) {
                    TbLog hybridLog = HybridLog.getInstance();
                    hybridLog.e("PostDataBiz", "发布失败 " + e);
                }
            }
        }

        @Override // com.baidu.tieba.o0b.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.c.w();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements q1b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<o0b> a;

        public c(o0b tool) {
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

        public static final void b(o0b tool, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(65537, null, tool, z) == null) {
                Intrinsics.checkNotNullParameter(tool, "$tool");
                tool.t(z);
            }
        }

        @Override // com.baidu.tieba.q1b.b
        public void a(boolean z) {
            final o0b o0bVar;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(1048576, this, z) != null) || (o0bVar = this.a.get()) == null) {
                return;
            }
            r1b.c(o0bVar.i().getPageActivity());
            if (r1b.f()) {
                return;
            }
            if (!z) {
                o0bVar.t(false);
            } else {
                new s1b(o0bVar.i().getPageActivity(), new s1b.f() { // from class: com.baidu.tieba.g0b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.s1b.f
                    public final void a(boolean z2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                            o0b.c.b(o0b.this, z2);
                        }
                    }
                }).j();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0b(TbPageContext<?> pageContext, TbWebView webView, WriteData writeData, c0b writePageState, EditorTools editor) {
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
                super((TbPageContext) objArr2[0], (TbWebView) objArr2[1], (WriteData) objArr2[2], (c0b) objArr2[3]);
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
        xha k = xha.k();
        Intrinsics.checkNotNullExpressionValue(k, "getInstance()");
        this.h = k;
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
                if (k().isQuestionThread() && r1b.d() && !z && r1b.e()) {
                    if (r1b.g()) {
                        r1b.h(i().getPageActivity());
                    }
                    q1b.c().g(k().getTitle(), k().getContent(), new c(this));
                    if (r1b.f()) {
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
            this.g.D(new zh5(54, 15, null));
            this.g.D(new zh5(65, 15, null));
            if (k().getVideoInfo() != null) {
                TiebaStatic.log("c10063");
            }
            WriteData k = k();
            SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
            k.setShowCustomFigure(sharedPrefHelper.getBoolean("key_write_virtual_image_enable" + TbadkCoreApplication.getCurrentAccount(), true));
            if (ck5.a()) {
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
            xha xhaVar = this.h;
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
            xhaVar.v(z2);
            this.h.y(k());
            if (!this.h.f()) {
                i().showToast((int) R.string.write_img_limit);
            } else if (!BdNetTypeUtil.isNetWorkAvailable()) {
                i().showToast((int) R.string.obfuscated_res_0x7f0f0e29);
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
            this.h.z();
            mya.f(k());
            l().g().c();
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
            this.h.e();
        }
    }
}
