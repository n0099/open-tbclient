package com.baidu.tieba.write.write.work;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoWorkListActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.s.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\b¢\u0006\u0005\b§\u0001\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0012\u0010\u0005J!\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0005J\u0017\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\rJ\u0019\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0003¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\"\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\"\u0010\u0005J\u000f\u0010#\u001a\u00020\u0003H\u0002¢\u0006\u0004\b#\u0010\u0005J\u000f\u0010$\u001a\u00020\u0003H\u0002¢\u0006\u0004\b$\u0010\u0005J\r\u0010%\u001a\u00020\u0003¢\u0006\u0004\b%\u0010\u0005R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b4\u0010/\u001a\u0004\b5\u00101\"\u0004\b6\u00103R\u0016\u00107\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010@\u001a\u0002098\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b@\u0010;\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?R\"\u0010C\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010DR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010RR\u0016\u0010U\u001a\u00020T8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bU\u0010VR\"\u0010X\u001a\u00020W8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u0016\u0010^\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010RR\"\u0010_\u001a\u00020&8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b_\u0010(\u001a\u0004\b`\u0010*\"\u0004\ba\u0010,R\"\u0010b\u001a\u00020-8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bb\u0010/\u001a\u0004\bc\u00101\"\u0004\bd\u00103R\"\u0010f\u001a\u00020e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010l\u001a\u00020-8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bl\u0010/\u001a\u0004\bm\u00101\"\u0004\bn\u00103R\"\u0010p\u001a\u00020o8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\"\u0010w\u001a\u00020v8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u0018\u0010~\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR\u001c\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R*\u0010\u0084\u0001\u001a\u00030\u0083\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R*\u0010\u008b\u0001\u001a\u00030\u008a\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R&\u0010\u0091\u0001\u001a\u00020-8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b\u0091\u0001\u0010/\u001a\u0005\b\u0092\u0001\u00101\"\u0005\b\u0093\u0001\u00103R&\u0010\u0094\u0001\u001a\u00020-8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b\u0094\u0001\u0010/\u001a\u0005\b\u0095\u0001\u00101\"\u0005\b\u0096\u0001\u00103R&\u0010\u0097\u0001\u001a\u00020&8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b\u0097\u0001\u0010(\u001a\u0005\b\u0098\u0001\u0010*\"\u0005\b\u0099\u0001\u0010,R&\u0010\u009a\u0001\u001a\u00020e8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b\u009a\u0001\u0010g\u001a\u0005\b\u009b\u0001\u0010i\"\u0005\b\u009c\u0001\u0010kR*\u0010\u009e\u0001\u001a\u00030\u009d\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u009e\u0001\u0010\u009f\u0001\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R&\u0010¤\u0001\u001a\u00020v8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b¤\u0001\u0010x\u001a\u0005\b¥\u0001\u0010z\"\u0005\b¦\u0001\u0010|¨\u0006¨\u0001"}, d2 = {"Lcom/baidu/tieba/write/write/work/WorkPublishActivity;", "Ld/a/p0/a4/u/q/a;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "", "clearDraft", "()V", "doPost", "goToSelectLocationActivity", "initNav", "initUI", "", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/os/Bundle;", "savedInstanceState", MissionEvent.MESSAGE_CREATE, "(Landroid/os/Bundle;)V", MissionEvent.MESSAGE_DESTROY, "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "onLocViewClickedInInitState", "onMixFail", "status", "onMixStateChanged", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "popupSaveDraftDialog", "prepareIntent", "processSaveDraft", "showLocPermissionDialog", "stopTask", "Landroid/view/View;", "contentBottomLine", "Landroid/view/View;", "getContentBottomLine", "()Landroid/view/View;", "setContentBottomLine", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "counterContent", "Landroid/widget/TextView;", "getCounterContent", "()Landroid/widget/TextView;", "setCounterContent", "(Landroid/widget/TextView;)V", "counterTitle", "getCounterTitle", "setCounterTitle", "draftType", "I", "Landroid/widget/EditText;", "edtContent", "Landroid/widget/EditText;", "getEdtContent", "()Landroid/widget/EditText;", "setEdtContent", "(Landroid/widget/EditText;)V", "edtTitle", "getEdtTitle", "setEdtTitle", "hasClickedTitle", "Z", "getHasClickedTitle", "()Z", "setHasClickedTitle", "(Z)V", "isDraftData", "Lcom/baidu/tieba/tbadkCore/location/LocationModel;", "mLocationModel", "Lcom/baidu/tieba/tbadkCore/location/LocationModel;", "Lcom/baidu/tieba/tbadkCore/location/LocationModel$OnLocationCallBack;", "mOnLocationCallBack", "Lcom/baidu/tieba/tbadkCore/location/LocationModel$OnLocationCallBack;", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mOnSelectLocationListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mSelectForumListener", "Lcom/baidu/tieba/tbadkCore/writeModel/AsyncWriteHelper;", "mWriteModel", "Lcom/baidu/tieba/tbadkCore/writeModel/AsyncWriteHelper;", "Lcom/baidu/tieba/write/write/work/WorkPublishMixVideoView;", "mixVideoView", "Lcom/baidu/tieba/write/write/work/WorkPublishMixVideoView;", "getMixVideoView", "()Lcom/baidu/tieba/write/write/work/WorkPublishMixVideoView;", "setMixVideoView", "(Lcom/baidu/tieba/write/write/work/WorkPublishMixVideoView;)V", "muxerSuccListener", "navBack", "getNavBack", "setNavBack", "navCenterText", "getNavCenterText", "setNavCenterText", "Landroid/widget/ImageView;", "navCenterTip", "Landroid/widget/ImageView;", "getNavCenterTip", "()Landroid/widget/ImageView;", "setNavCenterTip", "(Landroid/widget/ImageView;)V", "navPost", "getNavPost", "setNavPost", "Lcom/baidu/tbadk/core/view/NavigationBar;", "navigationBar", "Lcom/baidu/tbadk/core/view/NavigationBar;", "getNavigationBar", "()Lcom/baidu/tbadk/core/view/NavigationBar;", "setNavigationBar", "(Lcom/baidu/tbadk/core/view/NavigationBar;)V", "Landroid/view/ViewGroup;", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "setRootView", "(Landroid/view/ViewGroup;)V", "Lcom/baidu/tbadk/core/dialog/PopupDialog;", "saveDraftDialog", "Lcom/baidu/tbadk/core/dialog/PopupDialog;", "Lcom/baidu/tbadk/core/view/SaveDraftDialogView;", "saveDraftDialogView", "Lcom/baidu/tbadk/core/view/SaveDraftDialogView;", "Lcom/baidu/tieba/write/write/work/SelectBarView;", "selectBarView", "Lcom/baidu/tieba/write/write/work/SelectBarView;", "getSelectBarView", "()Lcom/baidu/tieba/write/write/work/SelectBarView;", "setSelectBarView", "(Lcom/baidu/tieba/write/write/work/SelectBarView;)V", "Lcom/baidu/tieba/write/write/work/SelectPosView;", "selectPosView", "Lcom/baidu/tieba/write/write/work/SelectPosView;", "getSelectPosView", "()Lcom/baidu/tieba/write/write/work/SelectPosView;", "setSelectPosView", "(Lcom/baidu/tieba/write/write/work/SelectPosView;)V", "showContent", "getShowContent", "setShowContent", "showTitle", "getShowTitle", "setShowTitle", "titleBottomLine", "getTitleBottomLine", "setTitleBottomLine", "titleSign", "getTitleSign", "setTitleSign", "Lcom/baidu/tieba/write/write/work/WorkPublishViewModel;", "viewModel", "Lcom/baidu/tieba/write/write/work/WorkPublishViewModel;", "getViewModel", "()Lcom/baidu/tieba/write/write/work/WorkPublishViewModel;", "setViewModel", "(Lcom/baidu/tieba/write/write/work/WorkPublishViewModel;)V", "workPublishBg", "getWorkPublishBg", "setWorkPublishBg", "<init>", "write_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class WorkPublishActivity extends BaseFragmentActivity implements d.a.p0.a4.u.q.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View contentBottomLine;
    public TextView counterContent;
    public TextView counterTitle;
    public int draftType;
    public EditText edtContent;
    public EditText edtTitle;
    public boolean hasClickedTitle;
    public boolean isDraftData;
    public LocationModel mLocationModel;
    public final LocationModel.e mOnLocationCallBack;
    public final CustomMessageListener mOnSelectLocationListener;
    public final CustomMessageListener mSelectForumListener;
    public d.a.p0.h3.q0.a mWriteModel;
    public WorkPublishMixVideoView mixVideoView;
    public final CustomMessageListener muxerSuccListener;
    public View navBack;
    public TextView navCenterText;
    public ImageView navCenterTip;
    public TextView navPost;
    public NavigationBar navigationBar;
    public ViewGroup rootView;
    public d.a.o0.r.s.j saveDraftDialog;
    public SaveDraftDialogView saveDraftDialogView;
    public SelectBarView selectBarView;
    public SelectPosView selectPosView;
    public TextView showContent;
    public TextView showTitle;
    public View titleBottomLine;
    public ImageView titleSign;
    public WorkPublishViewModel viewModel;
    public ViewGroup workPublishBg;

    /* loaded from: classes4.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22954e;

        public a(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22954e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22954e.popupSaveDraftDialog();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22955e;

        public b(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22955e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22955e.doPost();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22956e;

        public c(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22956e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.o0.l.a.u(true, this.f22956e.getBaseContext(), this.f22956e.getString(R.string.work_publish_webview_introduce), TbConfig.URL_WORKS_INFO);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class d<T> implements Observer<VideoInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22957e;

        public d(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22957e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(VideoInfo videoInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, videoInfo) == null) || videoInfo == null) {
                return;
            }
            this.f22957e.getMixVideoView().setVideoInfo(videoInfo, false);
        }
    }

    /* loaded from: classes4.dex */
    public static final class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22958e;

        public e(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22958e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f22958e.onLocViewClickedInInitState();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class f implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22959e;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public f(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22959e = workPublishActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                String obj = charSequence.toString();
                TextView counterTitle = this.f22959e.getCounterTitle();
                counterTitle.setText("(" + String.valueOf(obj.length()) + "/31)");
                if (obj.length() == 31) {
                    this.f22959e.getCounterTitle().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.f22959e.getCounterTitle().setTextColor(SkinManager.getColor(R.color.CAM_X0105));
                }
                this.f22959e.getViewModel().r(obj);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class g implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22960e;

        public g(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22960e = workPublishActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (z) {
                    this.f22960e.setHasClickedTitle(true);
                } else if (!this.f22960e.getHasClickedTitle() || this.f22960e.getViewModel().b()) {
                } else {
                    BdTopToast bdTopToast = new BdTopToast(this.f22960e);
                    bdTopToast.i(false);
                    bdTopToast.h(this.f22960e.getString(R.string.work_publish_title_too_short));
                    bdTopToast.j(this.f22960e.getRootView());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class h implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22961e;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public h(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22961e = workPublishActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                String obj = charSequence.toString();
                TextView counterContent = this.f22961e.getCounterContent();
                counterContent.setText("(" + String.valueOf(obj.length()) + "/300)");
                if (obj.length() == 300) {
                    this.f22961e.getCounterContent().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.f22961e.getCounterContent().setTextColor(SkinManager.getColor(R.color.CAM_X0105));
                }
                this.f22961e.getViewModel().h().setValue(obj);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class i<T> implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22962e;

        public i(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22962e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (Intrinsics.areEqual(this.f22962e.getViewModel().l().getValue(), Boolean.FALSE)) {
                    this.f22962e.getNavPost().setAlpha(0.33f);
                    this.f22962e.getNavPost().setEnabled(false);
                    return;
                }
                this.f22962e.getNavPost().setAlpha(1.0f);
                this.f22962e.getNavPost().setEnabled(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class j<T> implements Observer<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22963e;

        public j(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22963e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || str.equals(this.f22963e.getEdtTitle().getText().toString())) {
                return;
            }
            this.f22963e.getEdtTitle().setText(str);
        }
    }

    /* loaded from: classes4.dex */
    public static final class k<T> implements Observer<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22964e;

        public k(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22964e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || str == null || str.equals(this.f22964e.getEdtContent().getText().toString())) {
                return;
            }
            this.f22964e.getEdtContent().setText(str);
        }
    }

    /* loaded from: classes4.dex */
    public static final class l<T> implements Observer<d.a.o0.t.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22965e;

        public l(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22965e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(d.a.o0.t.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f22965e.getSelectBarView().a(jVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class m<T> implements Observer<ResponsedSelectLocation> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22966e;

        public m(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22966e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(ResponsedSelectLocation responsedSelectLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedSelectLocation) == null) {
                this.f22966e.getSelectPosView().d(responsedSelectLocation);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class n implements LocationModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22967a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public n(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22967a = workPublishActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f22967a.showToast(R.string.no_network_guide);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationData) == null) {
                if (!StringUtils.isNull(locationData.getFormatted_address())) {
                    this.f22967a.goToSelectLocationActivity();
                    return;
                }
                WorkPublishActivity workPublishActivity = this.f22967a;
                workPublishActivity.showToast(workPublishActivity.getString(R.string.location_fail));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                WorkPublishActivity workPublishActivity = this.f22967a;
                if (StringUtils.isNull(str)) {
                    str = this.f22967a.getString(R.string.location_fail);
                }
                workPublishActivity.showToast(str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class o extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22968a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(WorkPublishActivity workPublishActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity, Integer.valueOf(i2)};
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
            this.f22968a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedSelectLocation)) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WorkPublishActivity.access$getMLocationModel$p(this.f22968a).M(false);
                    WorkPublishActivity.access$getMLocationModel$p(this.f22968a).L(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                } else {
                    WorkPublishActivity.access$getMLocationModel$p(this.f22968a).M(true);
                }
                this.f22968a.getViewModel().i().setValue(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22969a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(WorkPublishActivity workPublishActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity, Integer.valueOf(i2)};
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
            this.f22969a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof d.a.o0.t.j)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    this.f22969a.getViewModel().g().setValue((d.a.o0.t.j) data);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.tbadk.data.SelectForumData");
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class q extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22970a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(WorkPublishActivity workPublishActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity, Integer.valueOf(i2)};
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
            this.f22970a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof VideoInfo)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    this.f22970a.getViewModel().s((VideoInfo) data);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.tbadk.coreExtra.data.VideoInfo");
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class r implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22971e;

        public r(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22971e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
                d.a.o0.r.s.j jVar = this.f22971e.saveDraftDialog;
                if (jVar == null) {
                    Intrinsics.throwNpe();
                }
                jVar.dismiss();
                Intrinsics.checkExpressionValueIsNotNull(v, "v");
                int id = v.getId();
                if (v.getTag(R.id.key_is_video_mix_finish) instanceof Boolean) {
                    Object tag = v.getTag(R.id.key_is_video_mix_finish);
                    if (tag != null) {
                        boolean booleanValue = ((Boolean) tag).booleanValue();
                        if (id == R.id.save_draft_dialog_not_save) {
                            if (booleanValue) {
                                this.f22971e.clearDraft();
                            }
                            this.f22971e.setResult(100);
                            this.f22971e.finish();
                            return;
                        } else if (id == R.id.save_draft_dialog_save && booleanValue) {
                            this.f22971e.processSaveDraft();
                            this.f22971e.setResult(100);
                            this.f22971e.finish();
                            return;
                        } else {
                            return;
                        }
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class s implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f22972e;

        public s(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f22972e = workPublishActivity;
        }

        @Override // d.a.o0.r.s.a.e
        public final void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!d.a.c.e.p.j.z()) {
                    this.f22972e.mOnLocationCallBack.a();
                } else {
                    WorkPublishActivity.access$getMLocationModel$p(this.f22972e).K();
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class t implements a.e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final t f22973e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1592424270, "Lcom/baidu/tieba/write/write/work/WorkPublishActivity$t;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1592424270, "Lcom/baidu/tieba/write/write/work/WorkPublishActivity$t;");
                    return;
                }
            }
            f22973e = new t();
        }

        public t() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // d.a.o0.r.s.a.e
        public final void onClick(d.a.o0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    public WorkPublishActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.muxerSuccListener = new q(this, 2921593);
        this.mSelectForumListener = new p(this, 2921505);
        this.mOnSelectLocationListener = new o(this, 2001226);
        this.mOnLocationCallBack = new n(this);
    }

    public static final /* synthetic */ LocationModel access$getMLocationModel$p(WorkPublishActivity workPublishActivity) {
        LocationModel locationModel = workPublishActivity.mLocationModel;
        if (locationModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
        }
        return locationModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goToSelectLocationActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this)));
        }
    }

    private final void initNav() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            View findViewById = findViewById(R.id.view_navigation_bar);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.view_navigation_bar)");
            NavigationBar navigationBar = (NavigationBar) findViewById;
            this.navigationBar = navigationBar;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
            }
            navigationBar.showBottomLine();
            NavigationBar navigationBar2 = this.navigationBar;
            if (navigationBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
            }
            View addSystemImageButton = navigationBar2.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            Intrinsics.checkExpressionValueIsNotNull(addSystemImageButton, "navigationBar.addSystemI…ype.BACK_BUTTON\n        )");
            this.navBack = addSystemImageButton;
            if (addSystemImageButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navBack");
            }
            addSystemImageButton.setOnClickListener(new a(this));
            NavigationBar navigationBar3 = this.navigationBar;
            if (navigationBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
            }
            TextView addTextButton = navigationBar3.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.home_publish));
            Intrinsics.checkExpressionValueIsNotNull(addTextButton, "navigationBar.addTextBut…g.home_publish)\n        )");
            this.navPost = addTextButton;
            if (addTextButton == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navPost");
            }
            addTextButton.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds130);
            TextView textView = this.navPost;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navPost");
            }
            textView.getLayoutParams().height = UtilHelper.getDimenPixelSize(R.dimen.tbds75);
            TextView textView2 = this.navPost;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navPost");
            }
            ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
            if (layoutParams != null) {
                ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
                TextView textView3 = this.navPost;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navPost");
                }
                d.a.o0.r.u.c.d(textView3).x(R.dimen.T_X08);
                TextView textView4 = this.navPost;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navPost");
                }
                textView4.setOnClickListener(new b(this));
                NavigationBar navigationBar4 = this.navigationBar;
                if (navigationBar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                }
                TextView centerTextTitle = navigationBar4.setCenterTextTitle(getString(R.string.work_publish));
                Intrinsics.checkExpressionValueIsNotNull(centerTextTitle, "navigationBar.setCenterT…g(R.string.work_publish))");
                this.navCenterText = centerTextTitle;
                if (centerTextTitle == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navCenterText");
                }
                ViewGroup.LayoutParams layoutParams2 = centerTextTitle.getLayoutParams();
                if (layoutParams2 != null) {
                    ((LinearLayout.LayoutParams) layoutParams2).leftMargin = 0;
                    TextView textView5 = this.navCenterText;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("navCenterText");
                    }
                    ViewGroup.LayoutParams layoutParams3 = textView5.getLayoutParams();
                    if (layoutParams3 != null) {
                        ((LinearLayout.LayoutParams) layoutParams3).rightMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds30);
                        NavigationBar navigationBar5 = this.navigationBar;
                        if (navigationBar5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
                        }
                        View centerImgBox = navigationBar5.getCenterImgBox();
                        if (centerImgBox != null) {
                            ImageView imageView = (ImageView) centerImgBox;
                            this.navCenterTip = imageView;
                            if (imageView == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("navCenterTip");
                            }
                            imageView.getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds44);
                            ImageView imageView2 = this.navCenterTip;
                            if (imageView2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("navCenterTip");
                            }
                            imageView2.getLayoutParams().height = UtilHelper.getDimenPixelSize(R.dimen.tbds44);
                            ImageView imageView3 = this.navCenterTip;
                            if (imageView3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("navCenterTip");
                            }
                            imageView3.setOnClickListener(new c(this));
                            ImageView imageView4 = this.navCenterTip;
                            if (imageView4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("navCenterTip");
                            }
                            imageView4.setVisibility(0);
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
    }

    private final void prepareIntent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            int intExtra = getIntent().getIntExtra(WorkPublishActivityConfig.PARAM_SHOW_DRAFT, 0);
            this.draftType = intExtra;
            if (intExtra == d.a.o0.r.m.c.f52515c.a()) {
                this.isDraftData = true;
                WorkPublishViewModel workPublishViewModel = this.viewModel;
                if (workPublishViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                workPublishViewModel.m();
            } else if (this.draftType == d.a.o0.r.m.c.f52515c.b()) {
                Serializable serializableExtra = getIntent().getSerializableExtra(WorkPublishActivityConfig.PARAM_WRITE_DATA);
                if (serializableExtra instanceof WriteData) {
                    WorkPublishViewModel workPublishViewModel2 = this.viewModel;
                    if (workPublishViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    WriteData writeData = (WriteData) serializableExtra;
                    workPublishViewModel2.o(writeData);
                    this.isDraftData = writeData.isWorkDraft();
                }
            } else {
                this.isDraftData = false;
                Serializable serializableExtra2 = getIntent().getSerializableExtra(WorkPublishActivityConfig.PARAM_VIDEO_INFO);
                if (serializableExtra2 instanceof VideoInfo) {
                    WorkPublishViewModel workPublishViewModel3 = this.viewModel;
                    if (workPublishViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    workPublishViewModel3.s((VideoInfo) serializableExtra2);
                }
            }
            if (getIntent().getBooleanExtra(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921583));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processSaveDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel.p();
        }
    }

    private final void showLocPermissionDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            d.a.o0.r.s.a aVar = new d.a.o0.r.s.a(pageContext.getPageActivity());
            aVar.setMessageId(R.string.location_app_permission_prompt).setPositiveButton(R.string.isopen, new s(this)).setNegativeButton(R.string.cancel, t.f22973e).create(getPageContext());
            aVar.show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void doPost() {
        boolean z;
        String b2;
        d.a.p0.h3.q0.a aVar;
        d.a.p0.h3.q0.a aVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002016, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("name", OpenFlutter.ACTIVITY_VIDEO_WORK_LIST))));
            WriteData writeData = new WriteData();
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            writeData.setVideoInfo(workPublishViewModel.k().getValue());
            WorkPublishViewModel workPublishViewModel2 = this.viewModel;
            if (workPublishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            writeData.setTitle(workPublishViewModel2.j().getValue());
            WorkPublishViewModel workPublishViewModel3 = this.viewModel;
            if (workPublishViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            writeData.setContent(workPublishViewModel3.h().getValue());
            WorkPublishViewModel workPublishViewModel4 = this.viewModel;
            if (workPublishViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            d.a.o0.t.j value = workPublishViewModel4.g().getValue();
            writeData.setForumId(value != null ? value.f53429a : null);
            WorkPublishViewModel workPublishViewModel5 = this.viewModel;
            if (workPublishViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            d.a.o0.t.j value2 = workPublishViewModel5.g().getValue();
            writeData.setForumName(value2 != null ? value2.f53431c : null);
            WorkPublishViewModel workPublishViewModel6 = this.viewModel;
            if (workPublishViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            boolean z2 = false;
            if (workPublishViewModel6.i().getValue() != null) {
                d.a.p0.h3.m0.b a2 = d.a.p0.h3.m0.b.a();
                Intrinsics.checkExpressionValueIsNotNull(a2, "LocationInfo.getInstance()");
                if (!a2.d()) {
                    z = true;
                    writeData.setHasLocationData(z);
                    writeData.setWork(true);
                    writeData.setWorkDraft(this.isDraftData);
                    b2 = d.a.o0.r.m.b.b();
                    if (!((b2 != null || b2.length() == 0) ? true : true)) {
                        String b3 = d.a.o0.r.m.b.b();
                        Intrinsics.checkExpressionValueIsNotNull(b3, "WorkPublishManager.getObjLocate()");
                        writeData.setStatisticFrom(Integer.parseInt(b3));
                    }
                    aVar = this.mWriteModel;
                    if (aVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                    }
                    aVar.w(writeData);
                    aVar2 = this.mWriteModel;
                    if (aVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                    }
                    aVar2.x();
                    VideoWorkListActivityConfig videoWorkListActivityConfig = new VideoWorkListActivityConfig(this);
                    videoWorkListActivityConfig.addType("1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoWorkListActivityConfig));
                    setResult(100);
                    finish();
                }
            }
            z = false;
            writeData.setHasLocationData(z);
            writeData.setWork(true);
            writeData.setWorkDraft(this.isDraftData);
            b2 = d.a.o0.r.m.b.b();
            if (!((b2 != null || b2.length() == 0) ? true : true)) {
            }
            aVar = this.mWriteModel;
            if (aVar == null) {
            }
            aVar.w(writeData);
            aVar2 = this.mWriteModel;
            if (aVar2 == null) {
            }
            aVar2.x();
            VideoWorkListActivityConfig videoWorkListActivityConfig2 = new VideoWorkListActivityConfig(this);
            videoWorkListActivityConfig2.addType("1");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoWorkListActivityConfig2));
            setResult(100);
            finish();
        }
    }

    public final View getContentBottomLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view = this.contentBottomLine;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentBottomLine");
            }
            return view;
        }
        return (View) invokeV.objValue;
    }

    public final TextView getCounterContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TextView textView = this.counterContent;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("counterContent");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getCounterTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TextView textView = this.counterTitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("counterTitle");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final EditText getEdtContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            EditText editText = this.edtContent;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtContent");
            }
            return editText;
        }
        return (EditText) invokeV.objValue;
    }

    public final EditText getEdtTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            EditText editText = this.edtTitle;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            }
            return editText;
        }
        return (EditText) invokeV.objValue;
    }

    public final boolean getHasClickedTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.hasClickedTitle : invokeV.booleanValue;
    }

    public final WorkPublishMixVideoView getMixVideoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            WorkPublishMixVideoView workPublishMixVideoView = this.mixVideoView;
            if (workPublishMixVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixVideoView");
            }
            return workPublishMixVideoView;
        }
        return (WorkPublishMixVideoView) invokeV.objValue;
    }

    public final View getNavBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            View view = this.navBack;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navBack");
            }
            return view;
        }
        return (View) invokeV.objValue;
    }

    public final TextView getNavCenterText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            TextView textView = this.navCenterText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navCenterText");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final ImageView getNavCenterTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ImageView imageView = this.navCenterTip;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navCenterTip");
            }
            return imageView;
        }
        return (ImageView) invokeV.objValue;
    }

    public final TextView getNavPost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            TextView textView = this.navPost;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navPost");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final NavigationBar getNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            NavigationBar navigationBar = this.navigationBar;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
            }
            return navigationBar;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public final ViewGroup getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ViewGroup viewGroup = this.rootView;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootView");
            }
            return viewGroup;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final SelectBarView getSelectBarView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SelectBarView selectBarView = this.selectBarView;
            if (selectBarView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectBarView");
            }
            return selectBarView;
        }
        return (SelectBarView) invokeV.objValue;
    }

    public final SelectPosView getSelectPosView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SelectPosView selectPosView = this.selectPosView;
            if (selectPosView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectPosView");
            }
            return selectPosView;
        }
        return (SelectPosView) invokeV.objValue;
    }

    public final TextView getShowContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            TextView textView = this.showContent;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showContent");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getShowTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            TextView textView = this.showTitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showTitle");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final View getTitleBottomLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            View view = this.titleBottomLine;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBottomLine");
            }
            return view;
        }
        return (View) invokeV.objValue;
    }

    public final ImageView getTitleSign() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            ImageView imageView = this.titleSign;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleSign");
            }
            return imageView;
        }
        return (ImageView) invokeV.objValue;
    }

    public final WorkPublishViewModel getViewModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            return workPublishViewModel;
        }
        return (WorkPublishViewModel) invokeV.objValue;
    }

    public final ViewGroup getWorkPublishBg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            ViewGroup viewGroup = this.workPublishBg;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("workPublishBg");
            }
            return viewGroup;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            initNav();
            View findViewById = findViewById(16908290);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(android.R.id.content)");
            this.rootView = (ViewGroup) findViewById;
            View findViewById2 = findViewById(R.id.videoView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.videoView)");
            WorkPublishMixVideoView workPublishMixVideoView = (WorkPublishMixVideoView) findViewById2;
            this.mixVideoView = workPublishMixVideoView;
            if (workPublishMixVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixVideoView");
            }
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            workPublishMixVideoView.setPageContext(pageContext);
            WorkPublishMixVideoView workPublishMixVideoView2 = this.mixVideoView;
            if (workPublishMixVideoView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixVideoView");
            }
            workPublishMixVideoView2.setIWorkVideoMixListener(this);
            View findViewById3 = findViewById(R.id.work_publish_edtTitle);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.work_publish_edtTitle)");
            this.edtTitle = (EditText) findViewById3;
            View findViewById4 = findViewById(R.id.work_publish_bg);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById(R.id.work_publish_bg)");
            this.workPublishBg = (ViewGroup) findViewById4;
            View findViewById5 = findViewById(R.id.work_publish_edtContent);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "findViewById(R.id.work_publish_edtContent)");
            this.edtContent = (EditText) findViewById5;
            View findViewById6 = findViewById(R.id.select_bar_view);
            Intrinsics.checkExpressionValueIsNotNull(findViewById6, "findViewById(R.id.select_bar_view)");
            this.selectBarView = (SelectBarView) findViewById6;
            View findViewById7 = findViewById(R.id.select_pos_view);
            Intrinsics.checkExpressionValueIsNotNull(findViewById7, "findViewById(R.id.select_pos_view)");
            SelectPosView selectPosView = (SelectPosView) findViewById7;
            this.selectPosView = selectPosView;
            if (selectPosView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectPosView");
            }
            selectPosView.setOnClickListener(new e(this));
            View findViewById8 = findViewById(R.id.work_publish_show_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById8, "findViewById(R.id.work_publish_show_title)");
            this.showTitle = (TextView) findViewById8;
            View findViewById9 = findViewById(R.id.work_publish_show_content);
            Intrinsics.checkExpressionValueIsNotNull(findViewById9, "findViewById(R.id.work_publish_show_content)");
            this.showContent = (TextView) findViewById9;
            View findViewById10 = findViewById(R.id.work_publish_title_sign);
            Intrinsics.checkExpressionValueIsNotNull(findViewById10, "findViewById(R.id.work_publish_title_sign)");
            this.titleSign = (ImageView) findViewById10;
            View findViewById11 = findViewById(R.id.sep_line_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById11, "findViewById(R.id.sep_line_title)");
            this.titleBottomLine = findViewById11;
            View findViewById12 = findViewById(R.id.sep_line_content);
            Intrinsics.checkExpressionValueIsNotNull(findViewById12, "findViewById(R.id.sep_line_content)");
            this.contentBottomLine = findViewById12;
            View findViewById13 = findViewById(R.id.work_publish_title_counter);
            Intrinsics.checkExpressionValueIsNotNull(findViewById13, "findViewById(R.id.work_publish_title_counter)");
            this.counterTitle = (TextView) findViewById13;
            View findViewById14 = findViewById(R.id.work_publish_content_counter);
            Intrinsics.checkExpressionValueIsNotNull(findViewById14, "findViewById(R.id.work_publish_content_counter)");
            this.counterContent = (TextView) findViewById14;
            EditText editText = this.edtTitle;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            }
            editText.addTextChangedListener(new f(this));
            EditText editText2 = this.edtTitle;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            }
            editText2.setOnFocusChangeListener(new g(this));
            EditText editText3 = this.edtContent;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtContent");
            }
            editText3.addTextChangedListener(new h(this));
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel.l().observe(this, new i(this));
            WorkPublishViewModel workPublishViewModel2 = this.viewModel;
            if (workPublishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel2.j().observe(this, new j(this));
            WorkPublishViewModel workPublishViewModel3 = this.viewModel;
            if (workPublishViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel3.h().observe(this, new k(this));
            WorkPublishViewModel workPublishViewModel4 = this.viewModel;
            if (workPublishViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel4.g().observe(this, new l(this));
            WorkPublishViewModel workPublishViewModel5 = this.viewModel;
            if (workPublishViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel5.i().observe(this, new m(this));
            WorkPublishViewModel workPublishViewModel6 = this.viewModel;
            if (workPublishViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel6.k().observe(this, new d(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            ViewGroup viewGroup = this.workPublishBg;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("workPublishBg");
            }
            d.a.o0.r.u.c.d(viewGroup).f(R.color.CAM_X0201);
            NavigationBar navigationBar = this.navigationBar;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
            }
            navigationBar.onChangeSkinType(getPageContext(), i2);
            NavigationBar navigationBar2 = this.navigationBar;
            if (navigationBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
            }
            navigationBar2.getBackImageView().setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_close40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            TextView textView = this.navPost;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navPost");
            }
            d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(textView);
            d2.t(R.color.CAM_X0101);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0302);
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (Intrinsics.areEqual(workPublishViewModel.l().getValue(), Boolean.FALSE)) {
                TextView textView2 = this.navPost;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navPost");
                }
                textView2.setAlpha(0.33f);
                TextView textView3 = this.navPost;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navPost");
                }
                textView3.setEnabled(false);
            } else {
                TextView textView4 = this.navPost;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navPost");
                }
                textView4.setAlpha(1.0f);
                TextView textView5 = this.navPost;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navPost");
                }
                textView5.setEnabled(true);
            }
            TextView textView6 = this.navCenterText;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navCenterText");
            }
            textView6.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            ImageView imageView = this.navCenterTip;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navCenterTip");
            }
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_creation_question16, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL));
            TextView textView7 = this.showTitle;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showTitle");
            }
            SkinManager.setViewTextColor(textView7, R.color.CAM_X0105);
            TextView textView8 = this.showContent;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showContent");
            }
            SkinManager.setViewTextColor(textView8, R.color.CAM_X0105);
            ImageView imageView2 = this.titleSign;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleSign");
            }
            imageView2.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_start, SkinManager.getColor(R.color.CAM_X0301), WebPManager.ResourceStateType.NORMAL));
            SelectBarView selectBarView = this.selectBarView;
            if (selectBarView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectBarView");
            }
            selectBarView.c();
            SelectPosView selectPosView = this.selectPosView;
            if (selectPosView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectPosView");
            }
            selectPosView.c();
            EditText editText = this.edtTitle;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            }
            editText.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            EditText editText2 = this.edtContent;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtContent");
            }
            editText2.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            TextView textView9 = this.counterContent;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("counterContent");
            }
            textView9.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            TextView textView10 = this.counterTitle;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("counterTitle");
            }
            textView10.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            EditText editText3 = this.edtTitle;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            }
            editText3.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            EditText editText4 = this.edtContent;
            if (editText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtContent");
            }
            editText4.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            View view = this.titleBottomLine;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBottomLine");
            }
            SkinManager.setBackgroundColor(view, R.color.CAM_X0210);
            View view2 = this.contentBottomLine;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentBottomLine");
            }
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0210);
            WorkPublishMixVideoView workPublishMixVideoView = this.mixVideoView;
            if (workPublishMixVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixVideoView");
            }
            workPublishMixVideoView.f();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.activity_work_publish);
            setSwipeBackEnabled(false);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            ViewModel viewModel = new ViewModelProvider(this).get(WorkPublishViewModel.class);
            Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProvider(this).…ishViewModel::class.java)");
            this.viewModel = (WorkPublishViewModel) viewModel;
            LocationModel locationModel = new LocationModel(getPageContext());
            this.mLocationModel = locationModel;
            if (locationModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
            }
            locationModel.N(this.mOnLocationCallBack);
            d.a.p0.h3.q0.a g2 = d.a.p0.h3.q0.a.g();
            Intrinsics.checkExpressionValueIsNotNull(g2, "AsyncWriteHelper.getInstance()");
            this.mWriteModel = g2;
            if (g2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
            }
            g2.l(this);
            initUI();
            registerListener(this.mSelectForumListener);
            registerListener(this.mOnSelectLocationListener);
            registerListener(this.muxerSuccListener);
            prepareIntent();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDestroy();
            d.a.o0.r.s.j jVar = this.saveDraftDialog;
            if (jVar != null) {
                jVar.dismiss();
            }
            this.saveDraftDialog = null;
            stopTask();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                popupSaveDraftDialog();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void onLocViewClickedInInitState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            if (!UtilHelper.isSystemLocationProviderEnabled(pageContext.getPageActivity())) {
                showToast(R.string.location_system_permission_prompt);
                return;
            }
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            Intrinsics.checkExpressionValueIsNotNull(inst, "TbadkCoreApplication.getInst()");
            if (!inst.getLocationShared()) {
                showLocPermissionDialog();
                return;
            }
            LocationModel locationModel = this.mLocationModel;
            if (locationModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
            }
            if (locationModel.D()) {
                goToSelectLocationActivity();
                return;
            }
            LocationModel locationModel2 = this.mLocationModel;
            if (locationModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
            }
            locationModel2.M(false);
            LocationModel locationModel3 = this.mLocationModel;
            if (locationModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
            }
            locationModel3.I();
        }
    }

    public void onMixFail() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            showToastWithDefaultIcon(getString(R.string.write_video_mix_fail), BdToast.DefaultIcon.FAILURE);
        }
    }

    @Override // d.a.p0.a4.u.q.a
    public void onMixStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel.q(i2);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, intent) == null) {
            super.onNewIntent(intent);
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra(WorkPublishActivityConfig.PARAM_VIDEO_INFO) : null;
            if (serializableExtra instanceof VideoInfo) {
                WorkPublishViewModel workPublishViewModel = this.viewModel;
                if (workPublishViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                workPublishViewModel.s((VideoInfo) serializableExtra);
            }
        }
    }

    public final void popupSaveDraftDialog() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            if (this.saveDraftDialogView == null) {
                this.saveDraftDialogView = new SaveDraftDialogView(this);
                r rVar = new r(this);
                SaveDraftDialogView saveDraftDialogView = this.saveDraftDialogView;
                if (saveDraftDialogView == null) {
                    Intrinsics.throwNpe();
                }
                saveDraftDialogView.setOnClickListener(rVar);
            }
            if (this.saveDraftDialog == null) {
                d.a.o0.r.s.j jVar = new d.a.o0.r.s.j(getPageContext());
                this.saveDraftDialog = jVar;
                if (jVar == null) {
                    Intrinsics.throwNpe();
                }
                jVar.setContentView(this.saveDraftDialogView);
            }
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            boolean d2 = workPublishViewModel.d();
            SaveDraftDialogView saveDraftDialogView2 = this.saveDraftDialogView;
            if (saveDraftDialogView2 == null) {
                Intrinsics.throwNpe();
            }
            saveDraftDialogView2.setButtonTag(R.id.key_is_video_mix_finish, Boolean.valueOf(d2));
            SaveDraftDialogView saveDraftDialogView3 = this.saveDraftDialogView;
            if (saveDraftDialogView3 == null) {
                Intrinsics.throwNpe();
            }
            saveDraftDialogView3.setCancelVisible(d2 ? 0 : 8);
            SaveDraftDialogView saveDraftDialogView4 = this.saveDraftDialogView;
            if (saveDraftDialogView4 == null) {
                Intrinsics.throwNpe();
            }
            if (d2) {
                i2 = R.string.write_save_draft_dialog_normal_title;
            } else {
                i2 = R.string.write_save_draft_failed_unfinish_zip_title;
            }
            saveDraftDialogView4.setText(getString(i2), null, getString(d2 ? R.string.save : R.string.write_save_draft_stay), getString(d2 ? R.string.not_save : R.string.write_save_draft_leave));
            d.a.o0.r.s.j jVar2 = this.saveDraftDialog;
            if (jVar2 == null) {
                Intrinsics.throwNpe();
            }
            jVar2.l();
        }
    }

    public final void setContentBottomLine(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, view) == null) {
            this.contentBottomLine = view;
        }
    }

    public final void setCounterContent(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, textView) == null) {
            this.counterContent = textView;
        }
    }

    public final void setCounterTitle(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, textView) == null) {
            this.counterTitle = textView;
        }
    }

    public final void setEdtContent(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, editText) == null) {
            this.edtContent = editText;
        }
    }

    public final void setEdtTitle(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, editText) == null) {
            this.edtTitle = editText;
        }
    }

    public final void setHasClickedTitle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048613, this, z) == null) {
            this.hasClickedTitle = z;
        }
    }

    public final void setMixVideoView(WorkPublishMixVideoView workPublishMixVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, workPublishMixVideoView) == null) {
            this.mixVideoView = workPublishMixVideoView;
        }
    }

    public final void setNavBack(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, view) == null) {
            this.navBack = view;
        }
    }

    public final void setNavCenterText(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, textView) == null) {
            this.navCenterText = textView;
        }
    }

    public final void setNavCenterTip(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, imageView) == null) {
            this.navCenterTip = imageView;
        }
    }

    public final void setNavPost(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, textView) == null) {
            this.navPost = textView;
        }
    }

    public final void setNavigationBar(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, navigationBar) == null) {
            this.navigationBar = navigationBar;
        }
    }

    public final void setRootView(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, viewGroup) == null) {
            this.rootView = viewGroup;
        }
    }

    public final void setSelectBarView(SelectBarView selectBarView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, selectBarView) == null) {
            this.selectBarView = selectBarView;
        }
    }

    public final void setSelectPosView(SelectPosView selectPosView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, selectPosView) == null) {
            this.selectPosView = selectPosView;
        }
    }

    public final void setShowContent(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, textView) == null) {
            this.showContent = textView;
        }
    }

    public final void setShowTitle(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, textView) == null) {
            this.showTitle = textView;
        }
    }

    public final void setTitleBottomLine(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, view) == null) {
            this.titleBottomLine = view;
        }
    }

    public final void setTitleSign(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, imageView) == null) {
            this.titleSign = imageView;
        }
    }

    public final void setViewModel(WorkPublishViewModel workPublishViewModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, workPublishViewModel) == null) {
            this.viewModel = workPublishViewModel;
        }
    }

    public final void setWorkPublishBg(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, viewGroup) == null) {
            this.workPublishBg = viewGroup;
        }
    }

    public final void stopTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            d.a.p0.h3.q0.a aVar = this.mWriteModel;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
            }
            if (aVar != null) {
                aVar.n();
            }
            LocationModel locationModel = this.mLocationModel;
            if (locationModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
            }
            if (locationModel != null) {
                locationModel.cancelLoadData();
            }
            WorkPublishMixVideoView workPublishMixVideoView = this.mixVideoView;
            if (workPublishMixVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixVideoView");
            }
            if (workPublishMixVideoView != null) {
                workPublishMixVideoView.g();
            }
        }
    }
}
