package com.baidu.tieba.write.webwrite.hybirdlistener.draft;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.browser.TbWebView;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.c4b;
import com.baidu.tieba.cja;
import com.baidu.tieba.f55;
import com.baidu.tieba.h3b;
import com.baidu.tieba.h55;
import com.baidu.tieba.i3b;
import com.baidu.tieba.j55;
import com.baidu.tieba.jg;
import com.baidu.tieba.l3b;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.write.webwrite.data.BizBase;
import com.baidu.tieba.write.webwrite.data.WrapListener;
import com.baidu.tieba.write.webwrite.hybirdlistener.draft.BaseDraftBiz;
import com.baidu.tieba.x4b;
import com.baidu.tieba.ym6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u0000 02\u00020\u00012\u00020\u00022\u00020\u0003:\u000201B)\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0002\u0010\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\tJ\b\u0010\u001d\u001a\u00020\u0012H\u0002J\u0015\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0012H&J\b\u0010\"\u001a\u00020\u0012H\u0016J\u0012\u0010#\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010\tH\u0016J\u0015\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0012H&J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u001aH\u0002J\b\u0010+\u001a\u00020\u0012H\u0002J\u0018\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020.2\u0006\u0010\u001c\u001a\u00020/H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/baidu/tieba/write/webwrite/hybirdlistener/draft/BaseDraftBiz;", "Lcom/baidu/tieba/tbadkCore/PostDraftHelper$IDraftCallback;", "Lcom/baidu/tieba/write/webwrite/data/BizBase;", "Lcom/baidu/tieba/write/webwrite/data/Clean;", "pageContext", "Lcom/baidu/tbadk/TbPageContext;", "webView", "Lcom/baidu/tieba/browser/TbWebView;", "writeData", "Lcom/baidu/tbadk/coreExtra/data/WriteData;", "writePageState", "Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;", "(Lcom/baidu/tbadk/TbPageContext;Lcom/baidu/tieba/browser/TbWebView;Lcom/baidu/tbadk/coreExtra/data/WriteData;Lcom/baidu/tieba/write/webwrite/fragment/WritePageState;)V", "saveDraftDialog", "Lcom/baidu/tbadk/core/dialog/PopupDialog;", "saveDraftDialogView", "Lcom/baidu/tbadk/core/view/SaveDraftDialogView;", "clearDraftData", "", "editorActionHandlers", "", "Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActionHandler;", "getFid", "", "handleDraft", "", "canPost", "data", "jumpEvaluate", "keyListeners", "Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "()[Lcom/baidu/tieba/write/webwrite/data/WrapListener;", "loadDraftData", MissionEvent.MESSAGE_DESTROY, "onDraftLoaded", "draftData", "requestCodeHandlers", "Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "()[Lcom/baidu/tieba/write/webwrite/data/ActivityRequestCodeHandler;", "saveDraftData", "showDraftSaveDialog", "isEvaluateClick", "showNanSavePopup", "startEvaluate", "id", "", "", "Companion", "IDraftListener", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class BaseDraftBiz extends BizBase implements cja.h, l3b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SaveDraftDialogView g;
    public h55 h;

    /* loaded from: classes8.dex */
    public interface b {
        void b();

        void c();

        void d();

        boolean e(boolean z, WriteData writeData);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1173711713, "Lcom/baidu/tieba/write/webwrite/hybirdlistener/draft/BaseDraftBiz;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1173711713, "Lcom/baidu/tieba/write/webwrite/hybirdlistener/draft/BaseDraftBiz;");
        }
    }

    @Override // com.baidu.tieba.k3b
    public WrapListener[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (WrapListener[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k3b
    public i3b[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (i3b[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l3b
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public abstract void w();

    public abstract void x();

    /* loaded from: classes8.dex */
    public static final class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseDraftBiz a;
        public final /* synthetic */ c4b b;

        public a(BaseDraftBiz baseDraftBiz, c4b c4bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {baseDraftBiz, c4bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = baseDraftBiz;
            this.b = c4bVar;
        }

        @Override // com.baidu.tieba.write.webwrite.hybirdlistener.draft.BaseDraftBiz.b
        public boolean e(boolean z, WriteData data) {
            InterceptResult invokeZL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZL = interceptable.invokeZL(1048579, this, z, data)) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                try {
                    return this.a.u(z, data);
                } catch (Exception e) {
                    TbLog hybridLog = HybridLog.getInstance();
                    hybridLog.e("BaseDraftBiz", "处理草稿失败 " + e);
                    return false;
                }
            }
            return invokeZL.booleanValue;
        }

        @Override // com.baidu.tieba.write.webwrite.hybirdlistener.draft.BaseDraftBiz.b
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.q()) {
                this.a.s();
            }
        }

        @Override // com.baidu.tieba.write.webwrite.hybirdlistener.draft.BaseDraftBiz.b
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.w();
            }
        }

        @Override // com.baidu.tieba.write.webwrite.hybirdlistener.draft.BaseDraftBiz.b
        public void d() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.b.q()) {
                this.a.x();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDraftBiz(TbPageContext<?> pageContext, TbWebView webView, WriteData writeData, c4b writePageState) {
        super(pageContext, webView, writeData, writePageState);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pageContext, webView, writeData, writePageState};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (TbWebView) objArr2[1], (WriteData) objArr2[2], (c4b) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(writeData, "writeData");
        Intrinsics.checkNotNullParameter(writePageState, "writePageState");
        writePageState.u(new a(this, writePageState));
    }

    public static final void B(f55 quitConfirm, BaseDraftBiz this$0, h55 popupDialog, j55 j55Var, int i, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{quitConfirm, this$0, popupDialog, j55Var, Integer.valueOf(i), view2}) == null) {
            Intrinsics.checkNotNullParameter(quitConfirm, "$quitConfirm");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(popupDialog, "$popupDialog");
            if (i == quitConfirm.e()) {
                this$0.s();
                popupDialog.dismiss();
                c4b.d(this$0.l(), 0, 1, null);
            }
        }
    }

    public static final void C(h55 popupDialog) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, popupDialog) == null) {
            Intrinsics.checkNotNullParameter(popupDialog, "$popupDialog");
            popupDialog.dismiss();
        }
    }

    @Override // com.baidu.tieba.cja.h
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) {
            if (writeData != null) {
                x4b.a.d(k(), writeData);
            }
            l().n().h();
        }
    }

    public static final void z(BaseDraftBiz this$0, boolean z, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{this$0, Boolean.valueOf(z), view2}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (view2 == null) {
                return;
            }
            int id = view2.getId();
            if (id == R.id.save_draft_dialog_not_save) {
                this$0.s();
                if (z) {
                    this$0.v();
                }
                c4b.d(this$0.l(), 0, 1, null);
            } else if (id == R.id.save_draft_dialog_save) {
                ym6.a().i(this$0.j(), "writePageNa.saveDraft", new JSONObject());
                if (z) {
                    this$0.v();
                }
            }
            h55 h55Var = this$0.h;
            Intrinsics.checkNotNull(h55Var);
            h55Var.dismiss();
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            final h55 h55Var = new h55(i());
            j55 j55Var = new j55(i().getPageActivity());
            j55Var.t(i().getString(R.string.obfuscated_res_0x7f0f0eb8));
            ArrayList arrayList = new ArrayList();
            final f55 f55Var = new f55(i().getString(R.string.obfuscated_res_0x7f0f0eb7), j55Var);
            f55Var.r(R.color.CAM_X0107);
            arrayList.add(f55Var);
            j55.f fVar = new j55.f() { // from class: com.baidu.tieba.q4b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.j55.f
                public final void G0(j55 j55Var2, int i, View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, j55Var2, i, view2) == null) {
                        BaseDraftBiz.B(f55.this, this, h55Var, j55Var2, i, view2);
                    }
                }
            };
            j55.c cVar = new j55.c() { // from class: com.baidu.tieba.r4b
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.j55.c
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        BaseDraftBiz.C(h55.this);
                    }
                }
            };
            j55Var.l(arrayList);
            j55Var.q(fVar);
            j55Var.o(cVar);
            h55Var.setCanceledOnTouchOutside(true);
            h55Var.h(j55Var);
            jg.i(h55Var, i().getPageActivity());
        }
    }

    public final void D(int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, obj) == null) {
            if (!l().e()) {
                v();
                c4b.d(l(), 0, 1, null);
                return;
            }
            y(true);
        }
    }

    @Override // com.baidu.tieba.k3b
    public h3b[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new h3b[]{n(69, new BaseDraftBiz$editorActionHandlers$1(this))} : (h3b[]) invokeV.objValue;
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            l().b();
        }
    }

    public final String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (TextUtils.isEmpty(k().getForumId())) {
                return "0";
            }
            String forumId = k().getForumId();
            Intrinsics.checkNotNullExpressionValue(forumId, "writeData.forumId");
            return forumId;
        }
        return (String) invokeV.objValue;
    }

    public final boolean u(boolean z, WriteData data) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048585, this, z, data)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (!l().q()) {
                return false;
            }
            if (!z && ListUtils.isEmpty(data.getItemDatas())) {
                return false;
            }
            if (!data.isSaveDraft()) {
                s();
                return false;
            } else if (Intrinsics.areEqual(l().k(), "1")) {
                A();
                return true;
            } else {
                y(false);
                return true;
            }
        }
        return invokeZL.booleanValue;
    }

    public final void v() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        l().y(true);
        WriteActivityConfig.newInstance(i().getPageActivity()).setType(9).setForumId(t()).setForumName(k().getForumName()).setEnableAudio(k().isVoiceEnable()).setAudioMsg(k().getDisableAudioMessage()).setCanGoods(false).setPrefixData(k().getPrefixData()).setPrivateThread(k().getPrivateThread()).setForumDir(k().getFirstDir(), k().getSecondDir()).setFrsTabInfo(k().getFrsTabInfoData()).setCallFrom(k().getCallFrom()).setStatisticFrom(k().getStatisticFrom()).setIsEvaluate(true).setScoreItemInfo(k().getIntentItemInfo()).setStarCount(k().getIntentStarCount()).setFrom(k().getFrom()).send();
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED);
        if (Intrinsics.areEqual("main_tab", k().getFrom())) {
            i = 8;
        } else {
            i = 2;
        }
        statisticItem.param("obj_locate", i);
        statisticItem.param("obj_type", 6);
        TiebaStatic.log(statisticItem);
    }

    public final void y(final boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && i().getPageActivity() != null && !i().getPageActivity().isFinishing()) {
            if (this.g == null) {
                this.g = new SaveDraftDialogView(i().getPageActivity());
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.s4b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            BaseDraftBiz.z(BaseDraftBiz.this, z, view2);
                        }
                    }
                };
                SaveDraftDialogView saveDraftDialogView = this.g;
                Intrinsics.checkNotNull(saveDraftDialogView);
                saveDraftDialogView.setOnClickListener(onClickListener);
            }
            if (this.h == null) {
                h55 h55Var = new h55(i());
                this.h = h55Var;
                Intrinsics.checkNotNull(h55Var);
                SaveDraftDialogView saveDraftDialogView2 = this.g;
                Intrinsics.checkNotNull(saveDraftDialogView2);
                h55Var.setContentView(saveDraftDialogView2);
            }
            SaveDraftDialogView saveDraftDialogView3 = this.g;
            Intrinsics.checkNotNull(saveDraftDialogView3);
            saveDraftDialogView3.setText(i().getString(R.string.write_save_draft_dialog_normal_title), i().getString(R.string.obfuscated_res_0x7f0f12f2));
            h55 h55Var2 = this.h;
            Intrinsics.checkNotNull(h55Var2);
            h55Var2.l();
        }
    }
}
