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
import c.a.q0.s.q.n2;
import c.a.q0.s.s.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoWorkListActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.VideoCategoryClassData;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.WorkAddTopicSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.write.write.work.model.WorkPublishViewModel;
import com.baidu.tieba.write.write.work.selectview.SelectBarView;
import com.baidu.tieba.write.write.work.selectview.SelectClassView;
import com.baidu.tieba.write.write.work.selectview.SelectPosView;
import com.baidu.tieba.write.write.work.selectview.SelectTagView;
import com.baidu.tieba.write.write.work.selectview.SelectTopicView;
import com.baidu.tieba.write.write.work.videoview.WorkPublishMixVideoView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\b¢\u0006\u0005\bÁ\u0001\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u0005J\r\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0014\u0010\u0005J!\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u0005J\u000f\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u0005J\u0017\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001e\u0010\u000fJ\u0019\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0014¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0003¢\u0006\u0004\b#\u0010\u0005J\u000f\u0010$\u001a\u00020\u0003H\u0002¢\u0006\u0004\b$\u0010\u0005J\u000f\u0010%\u001a\u00020\u0003H\u0002¢\u0006\u0004\b%\u0010\u0005J\u000f\u0010&\u001a\u00020\u0003H\u0002¢\u0006\u0004\b&\u0010\u0005J\r\u0010'\u001a\u00020\u0003¢\u0006\u0004\b'\u0010\u0005R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00106\u001a\u00020/8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b6\u00101\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\u0016\u00109\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010B\u001a\u00020;8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bB\u0010=\u001a\u0004\bC\u0010?\"\u0004\bD\u0010AR\"\u0010E\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010FR\u0016\u0010L\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010FR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020S8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010OR\u0016\u0010W\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010OR\u0016\u0010X\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010OR\u0016\u0010Y\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010OR\u0016\u0010Z\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010OR\u0016\u0010[\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010OR\u0016\u0010]\u001a\u00020\\8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b]\u0010^R\"\u0010`\u001a\u00020_8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0016\u0010f\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010OR\"\u0010g\u001a\u00020(8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bg\u0010*\u001a\u0004\bh\u0010,\"\u0004\bi\u0010.R\"\u0010j\u001a\u00020/8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bj\u00101\u001a\u0004\bk\u00103\"\u0004\bl\u00105R\"\u0010m\u001a\u00020/8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bm\u00101\u001a\u0004\bn\u00103\"\u0004\bo\u00105R\"\u0010q\u001a\u00020p8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\"\u0010x\u001a\u00020w8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u0019\u0010\u007f\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001c\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R*\u0010\u0085\u0001\u001a\u00030\u0084\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R*\u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R*\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R*\u0010\u009a\u0001\u001a\u00030\u0099\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001\"\u0006\b\u009e\u0001\u0010\u009f\u0001R*\u0010¡\u0001\u001a\u00030 \u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0006\b£\u0001\u0010¤\u0001\"\u0006\b¥\u0001\u0010¦\u0001R&\u0010§\u0001\u001a\u00020/8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b§\u0001\u00101\u001a\u0005\b¨\u0001\u00103\"\u0005\b©\u0001\u00105R&\u0010ª\u0001\u001a\u00020/8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\bª\u0001\u00101\u001a\u0005\b«\u0001\u00103\"\u0005\b¬\u0001\u00105R&\u0010\u00ad\u0001\u001a\u00020(8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b\u00ad\u0001\u0010*\u001a\u0005\b®\u0001\u0010,\"\u0005\b¯\u0001\u0010.R*\u0010±\u0001\u001a\u00030°\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b±\u0001\u0010²\u0001\u001a\u0006\b³\u0001\u0010´\u0001\"\u0006\bµ\u0001\u0010¶\u0001R*\u0010¸\u0001\u001a\u00030·\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b¸\u0001\u0010¹\u0001\u001a\u0006\bº\u0001\u0010»\u0001\"\u0006\b¼\u0001\u0010½\u0001R&\u0010¾\u0001\u001a\u00020w8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b¾\u0001\u0010y\u001a\u0005\b¿\u0001\u0010{\"\u0005\bÀ\u0001\u0010}¨\u0006Â\u0001"}, d2 = {"Lcom/baidu/tieba/write/write/work/WorkPublishActivity;", "Lc/a/r0/c4/u/p/c/a;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "", "clearDraft", "()V", "doPost", "getFormData", "getWriteData", "goToSelectLocationActivity", "initNav", "initUI", "", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", MissionEvent.MESSAGE_DESTROY, "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "onLocViewClickedInInitState", "onMixFail", "status", "onMixStateChanged", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "popupSaveDraftDialog", "prepareIntent", "processSaveDraft", "showLocPermissionDialog", "stopTask", "Landroid/view/View;", "contentBottomLine", "Landroid/view/View;", "getContentBottomLine", "()Landroid/view/View;", "setContentBottomLine", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "counterContent", "Landroid/widget/TextView;", "getCounterContent", "()Landroid/widget/TextView;", "setCounterContent", "(Landroid/widget/TextView;)V", "counterTitle", "getCounterTitle", "setCounterTitle", "draftType", "I", "Landroid/widget/EditText;", "edtContent", "Landroid/widget/EditText;", "getEdtContent", "()Landroid/widget/EditText;", "setEdtContent", "(Landroid/widget/EditText;)V", "edtTitle", "getEdtTitle", "setEdtTitle", "hasClickedTitle", "Z", "getHasClickedTitle", "()Z", "setHasClickedTitle", "(Z)V", "isDraftData", "isNeedCleanTag", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mCanChangeBarNameToastListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "Lcom/baidu/tieba/tbadkCore/location/LocationModel;", "mLocationModel", "Lcom/baidu/tieba/tbadkCore/location/LocationModel;", "Lcom/baidu/tieba/tbadkCore/location/LocationModel$OnLocationCallBack;", "mOnLocationCallBack", "Lcom/baidu/tieba/tbadkCore/location/LocationModel$OnLocationCallBack;", "mOnSelectClassListener", "mOnSelectLocationListener", "mOnSelectTagListener", "mOnSelectTopicListener", "mSelectForumListener", "mShowCanNotSelectTagToastListener", "Lcom/baidu/tieba/tbadkCore/writeModel/AsyncWriteHelper;", "mWriteModel", "Lcom/baidu/tieba/tbadkCore/writeModel/AsyncWriteHelper;", "Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;", "mixVideoView", "Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;", "getMixVideoView", "()Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;", "setMixVideoView", "(Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;)V", "muxerSuccListener", "navBack", "getNavBack", "setNavBack", "navCenterText", "getNavCenterText", "setNavCenterText", "navPost", "getNavPost", "setNavPost", "Lcom/baidu/tbadk/core/view/NavigationBar;", "navigationBar", "Lcom/baidu/tbadk/core/view/NavigationBar;", "getNavigationBar", "()Lcom/baidu/tbadk/core/view/NavigationBar;", "setNavigationBar", "(Lcom/baidu/tbadk/core/view/NavigationBar;)V", "Landroid/view/ViewGroup;", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "setRootView", "(Landroid/view/ViewGroup;)V", "Lcom/baidu/tbadk/core/dialog/PopupDialog;", "saveDraftDialog", "Lcom/baidu/tbadk/core/dialog/PopupDialog;", "Lcom/baidu/tbadk/core/view/SaveDraftDialogView;", "saveDraftDialogView", "Lcom/baidu/tbadk/core/view/SaveDraftDialogView;", "Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;", "selectBarView", "Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;", "getSelectBarView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;", "setSelectBarView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;)V", "Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;", "selectClassView", "Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;", "getSelectClassView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;", "setSelectClassView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;)V", "Lcom/baidu/tieba/write/write/work/selectview/SelectPosView;", "selectPosView", "Lcom/baidu/tieba/write/write/work/selectview/SelectPosView;", "getSelectPosView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectPosView;", "setSelectPosView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectPosView;)V", "Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;", "selectTagView", "Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;", "getSelectTagView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;", "setSelectTagView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;)V", "Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;", "selectTopicView", "Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;", "getSelectTopicView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;", "setSelectTopicView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;)V", "showContent", "getShowContent", "setShowContent", "showTitle", "getShowTitle", "setShowTitle", "titleBottomLine", "getTitleBottomLine", "setTitleBottomLine", "Landroid/widget/ImageView;", "titleSign", "Landroid/widget/ImageView;", "getTitleSign", "()Landroid/widget/ImageView;", "setTitleSign", "(Landroid/widget/ImageView;)V", "Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "viewModel", "Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "getViewModel", "()Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "setViewModel", "(Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;)V", "workPublishBg", "getWorkPublishBg", "setWorkPublishBg", "<init>", "write_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class WorkPublishActivity extends BaseFragmentActivity implements c.a.r0.c4.u.p.c.a {
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
    public boolean isNeedCleanTag;
    public final CustomMessageListener mCanChangeBarNameToastListener;
    public LocationModel mLocationModel;
    public final LocationModel.e mOnLocationCallBack;
    public final CustomMessageListener mOnSelectClassListener;
    public final CustomMessageListener mOnSelectLocationListener;
    public final CustomMessageListener mOnSelectTagListener;
    public final CustomMessageListener mOnSelectTopicListener;
    public final CustomMessageListener mSelectForumListener;
    public final CustomMessageListener mShowCanNotSelectTagToastListener;
    public c.a.r0.j3.r0.g mWriteModel;
    public WorkPublishMixVideoView mixVideoView;
    public final CustomMessageListener muxerSuccListener;
    public View navBack;
    public TextView navCenterText;
    public TextView navPost;
    public NavigationBar navigationBar;
    public ViewGroup rootView;
    public PopupDialog saveDraftDialog;
    public SaveDraftDialogView saveDraftDialogView;
    public SelectBarView selectBarView;
    public SelectClassView selectClassView;
    public SelectPosView selectPosView;
    public SelectTagView selectTagView;
    public SelectTopicView selectTopicView;
    public TextView showContent;
    public TextView showTitle;
    public View titleBottomLine;
    public ImageView titleSign;
    public WorkPublishViewModel viewModel;
    public ViewGroup workPublishBg;

    /* loaded from: classes7.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59153e;

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
            this.f59153e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f59153e.popupSaveDraftDialog();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class a0 implements a.e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final a0 f59154e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2120493573, "Lcom/baidu/tieba/write/write/work/WorkPublishActivity$a0;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2120493573, "Lcom/baidu/tieba/write/write/work/WorkPublishActivity$a0;");
                    return;
                }
            }
            f59154e = new a0();
        }

        public a0() {
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

        @Override // c.a.q0.s.s.a.e
        public final void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59155e;

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
            this.f59155e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f59155e.doPost();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c<T> implements Observer<ArrayList<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59156e;

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
            this.f59156e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(ArrayList<String> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                SelectTagView selectTagView = this.f59156e.getSelectTagView();
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                selectTagView.bindData(it);
                this.f59156e.getSelectClassView().setMIsSelectedTags(!it.isEmpty());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T> implements Observer<ArrayList<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59157e;

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
            this.f59157e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(ArrayList<String> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                SelectTopicView selectTopicView = this.f59157e.getSelectTopicView();
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                selectTopicView.bindData(it);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class e<T> implements Observer<ResponsedSelectLocation> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59158e;

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
            this.f59158e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(ResponsedSelectLocation responsedSelectLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedSelectLocation) == null) {
                this.f59158e.getSelectPosView().bindData(responsedSelectLocation);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class f<T> implements Observer<VideoInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59159e;

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
            this.f59159e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(VideoInfo videoInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, videoInfo) == null) || videoInfo == null) {
                return;
            }
            this.f59159e.getMixVideoView().setVideoInfo(videoInfo, false);
        }
    }

    /* loaded from: classes7.dex */
    public static final class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59160e;

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
            this.f59160e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f59160e.onLocViewClickedInInitState();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class h implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59161e;

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
            this.f59161e = workPublishActivity;
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
                TextView counterTitle = this.f59161e.getCounterTitle();
                counterTitle.setText("(" + String.valueOf(obj.length()) + "/80)");
                if (obj.length() == 80) {
                    this.f59161e.getCounterTitle().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.f59161e.getCounterTitle().setTextColor(SkinManager.getColor(R.color.CAM_X0105));
                }
                this.f59161e.getViewModel().updateTitle(obj);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class i implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59162e;

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
            this.f59162e = workPublishActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (z) {
                    this.f59162e.setHasClickedTitle(true);
                } else if (!this.f59162e.getHasClickedTitle() || this.f59162e.getViewModel().checkIsTitleLegal()) {
                } else {
                    new BdTopToast(this.f59162e).setIcon(false).setContent(this.f59162e.getString(R.string.work_publish_title_too_short)).show(this.f59162e.getRootView());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class j implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59163e;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
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
            this.f59163e = workPublishActivity;
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
                TextView counterContent = this.f59163e.getCounterContent();
                counterContent.setText("(" + String.valueOf(obj.length()) + "/300)");
                if (obj.length() == 300) {
                    this.f59163e.getCounterContent().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.f59163e.getCounterContent().setTextColor(SkinManager.getColor(R.color.CAM_X0105));
                }
                this.f59163e.getViewModel().getDesc().setValue(obj);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class k<T> implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59164e;

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
            this.f59164e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (Intrinsics.areEqual(this.f59164e.getViewModel().isLegal().getValue(), Boolean.FALSE)) {
                    this.f59164e.getNavPost().setAlpha(0.33f);
                    this.f59164e.getNavPost().setEnabled(false);
                    return;
                }
                this.f59164e.getNavPost().setAlpha(1.0f);
                this.f59164e.getNavPost().setEnabled(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class l<T> implements Observer<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59165e;

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
            this.f59165e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || str == null || str.equals(this.f59165e.getEdtTitle().getText().toString())) {
                return;
            }
            this.f59165e.getEdtTitle().setText(str);
        }
    }

    /* loaded from: classes7.dex */
    public static final class m<T> implements Observer<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59166e;

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
            this.f59166e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || str == null || str.equals(this.f59166e.getEdtContent().getText().toString())) {
                return;
            }
            this.f59166e.getEdtContent().setText(str);
        }
    }

    /* loaded from: classes7.dex */
    public static final class n<T> implements Observer<c.a.q0.u.i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59167e;

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
            this.f59167e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(c.a.q0.u.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f59167e.getSelectBarView().bindData(iVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class o<T> implements Observer<VideoCategoryClassData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59168e;

        public o(WorkPublishActivity workPublishActivity) {
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
            this.f59168e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(VideoCategoryClassData it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                this.f59168e.getSelectClassView().bindData(it);
                String firstClass = this.f59168e.getSelectTagView().getFirstClass();
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                if ((!Intrinsics.areEqual(firstClass, it.getFirstClass())) || (!Intrinsics.areEqual(this.f59168e.getSelectTagView().getSecondClass(), it.getSecondClass()))) {
                    SelectTagView selectTagView = this.f59168e.getSelectTagView();
                    String firstClass2 = it.getFirstClass();
                    Intrinsics.checkExpressionValueIsNotNull(firstClass2, "it.firstClass");
                    String secondClass = it.getSecondClass();
                    Intrinsics.checkExpressionValueIsNotNull(secondClass, "it.secondClass");
                    selectTagView.setClassData(firstClass2, secondClass);
                    if (this.f59168e.isNeedCleanTag) {
                        this.f59168e.getViewModel().getTagInfo().setValue(new ArrayList<>());
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class p extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59169a;

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
            this.f59169a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Boolean)) {
                Object data = customResponsedMessage.getData();
                if (data == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
                }
                if (((Boolean) data).booleanValue()) {
                    new BdTopToast(this.f59169a.getBaseContext()).setIcon(false).setContent(this.f59169a.getResources().getString(R.string.can_not_change_bar_name)).show(this.f59169a.getNavigationBar());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class q implements LocationModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59170a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public q(WorkPublishActivity workPublishActivity) {
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
            this.f59170a = workPublishActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f59170a.showToast(R.string.no_network_guide);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationData) == null) {
                if (!StringUtils.isNull(locationData.getFormatted_address())) {
                    this.f59170a.goToSelectLocationActivity();
                    return;
                }
                WorkPublishActivity workPublishActivity = this.f59170a;
                workPublishActivity.showToast(workPublishActivity.getString(R.string.location_fail));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                WorkPublishActivity workPublishActivity = this.f59170a;
                if (StringUtils.isNull(str)) {
                    str = this.f59170a.getString(R.string.location_fail);
                }
                workPublishActivity.showToast(str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class r extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59171a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(WorkPublishActivity workPublishActivity, int i2) {
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
            this.f59171a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof VideoCategoryClassData)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    this.f59171a.isNeedCleanTag = true;
                    this.f59171a.getViewModel().getClassInfo().setValue((VideoCategoryClassData) data);
                    this.f59171a.getViewModel().checkIsAllLegal();
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.tbadk.data.VideoCategoryClassData");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59172a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(WorkPublishActivity workPublishActivity, int i2) {
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
            this.f59172a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedSelectLocation)) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WorkPublishActivity.access$getMLocationModel$p(this.f59172a).M(false);
                    WorkPublishActivity.access$getMLocationModel$p(this.f59172a).L(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                } else {
                    WorkPublishActivity.access$getMLocationModel$p(this.f59172a).M(true);
                }
                this.f59172a.getViewModel().getPosInfo().setValue(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59173a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(WorkPublishActivity workPublishActivity, int i2) {
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
            this.f59173a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof ArrayList)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    this.f59173a.getViewModel().getTagInfo().setValue((ArrayList) data);
                    this.f59173a.getViewModel().checkIsAllLegal();
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59174a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(WorkPublishActivity workPublishActivity, int i2) {
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
            this.f59174a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof ArrayList)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    this.f59174a.getViewModel().getTopicInfo().setValue((ArrayList) data);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59175a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(WorkPublishActivity workPublishActivity, int i2) {
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
            this.f59175a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof c.a.q0.u.i)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    this.f59175a.getViewModel().getBarInfo().setValue((c.a.q0.u.i) data);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.tbadk.data.SelectForumData");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59176a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(WorkPublishActivity workPublishActivity, int i2) {
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
            this.f59176a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof Boolean)) {
                Object data = customResponsedMessage.getData();
                if (data == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
                }
                if (((Boolean) data).booleanValue()) {
                    new BdTopToast(this.f59176a.getBaseContext()).setIcon(false).setContent(this.f59176a.getResources().getString(R.string.can_not_select_tag)).show(this.f59176a.getNavigationBar());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59177a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public x(WorkPublishActivity workPublishActivity, int i2) {
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
            this.f59177a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof VideoInfo)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    this.f59177a.getViewModel().updateVideo((VideoInfo) data);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.tbadk.coreExtra.data.VideoInfo");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59178e;

        public y(WorkPublishActivity workPublishActivity) {
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
            this.f59178e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
                PopupDialog popupDialog = this.f59178e.saveDraftDialog;
                if (popupDialog == null) {
                    Intrinsics.throwNpe();
                }
                popupDialog.dismiss();
                Intrinsics.checkExpressionValueIsNotNull(v, "v");
                int id = v.getId();
                if (v.getTag(R.id.key_is_video_mix_finish) instanceof Boolean) {
                    Object tag = v.getTag(R.id.key_is_video_mix_finish);
                    if (tag != null) {
                        boolean booleanValue = ((Boolean) tag).booleanValue();
                        if (id == R.id.save_draft_dialog_not_save) {
                            if (booleanValue) {
                                TiebaStatic.log(new StatisticItem("c14260").param("obj_locate", 2));
                                this.f59178e.clearDraft();
                            }
                            this.f59178e.setResult(100);
                            this.f59178e.finish();
                            return;
                        } else if (id != R.id.save_draft_dialog_save) {
                            if (id == R.id.save_draft_dialog_cancle && booleanValue) {
                                TiebaStatic.log(new StatisticItem("c14260").param("obj_locate", 0));
                                return;
                            }
                            return;
                        } else if (booleanValue) {
                            TiebaStatic.log(new StatisticItem("c14260").param("obj_locate", 1));
                            this.f59178e.processSaveDraft();
                            this.f59178e.setResult(100);
                            this.f59178e.finish();
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

    /* loaded from: classes8.dex */
    public static final class z implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59179e;

        public z(WorkPublishActivity workPublishActivity) {
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
            this.f59179e = workPublishActivity;
        }

        @Override // c.a.q0.s.s.a.e
        public final void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!c.a.e.e.p.j.z()) {
                    this.f59179e.mOnLocationCallBack.a();
                } else {
                    WorkPublishActivity.access$getMLocationModel$p(this.f59179e).K();
                }
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
        this.isNeedCleanTag = true;
        this.muxerSuccListener = new x(this, 2921593);
        this.mSelectForumListener = new v(this, 2921505);
        this.mOnSelectClassListener = new r(this, 2921601);
        this.mOnSelectTagListener = new t(this, 2921604);
        this.mShowCanNotSelectTagToastListener = new w(this, 2921605);
        this.mCanChangeBarNameToastListener = new p(this, 2921621);
        this.mOnSelectTopicListener = new u(this, 2921602);
        this.mOnSelectLocationListener = new s(this, 2001226);
        this.mOnLocationCallBack = new q(this);
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
        if (interceptable == null || interceptable.invokeV(65547, this) == null) {
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel.clearDraft();
        }
    }

    private final void getFormData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            c.a.q0.u.i iVar = new c.a.q0.u.i();
            SelectBarView selectBarView = this.selectBarView;
            if (selectBarView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectBarView");
            }
            selectBarView.setMCanChangeBarName(getIntent().getBooleanExtra(WorkPublishActivityConfig.CAN_CHANGE_SELECT_BAR, true));
            iVar.f15029a = getIntent().getStringExtra("bar_id");
            iVar.f15031c = getIntent().getStringExtra("bar_name");
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel.setCanChangeBarName(getIntent().getBooleanExtra(WorkPublishActivityConfig.CAN_CHANGE_SELECT_BAR, true));
            WorkPublishViewModel workPublishViewModel2 = this.viewModel;
            if (workPublishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel2.setIntentBarInfo(iVar);
        }
    }

    private final void getWriteData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            c.a.q0.u.i iVar = new c.a.q0.u.i();
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel.getTitle().setValue(getIntent().getStringExtra("video_title"));
            WorkPublishViewModel workPublishViewModel2 = this.viewModel;
            if (workPublishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel2.getDesc().setValue(getIntent().getStringExtra(AlbumFloatActivityConfig.VIDEO_ABSTRACT));
            SelectBarView selectBarView = this.selectBarView;
            if (selectBarView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectBarView");
            }
            selectBarView.setMCanChangeBarName(getIntent().getBooleanExtra(AlbumFloatActivityConfig.CAN_CHANGE_BAR_NAME, true));
            iVar.f15029a = getIntent().getStringExtra("bar_id");
            iVar.f15031c = getIntent().getStringExtra("bar_name");
            WorkPublishViewModel workPublishViewModel3 = this.viewModel;
            if (workPublishViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel3.getBarInfo().setValue(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goToSelectLocationActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this)));
        }
    }

    private final void initNav() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
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
                c.a.q0.s.u.c.d(textView3).A(R.dimen.T_X08);
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
                    if (layoutParams3 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    }
                    ((LinearLayout.LayoutParams) layoutParams3).rightMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds30);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
    }

    private final void prepareIntent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            int intExtra = getIntent().getIntExtra(WorkPublishActivityConfig.PARAM_SHOW_DRAFT, 0);
            this.draftType = intExtra;
            if (intExtra == c.a.q0.s.m.c.f14024f.a()) {
                this.isDraftData = true;
                WorkPublishViewModel workPublishViewModel = this.viewModel;
                if (workPublishViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                workPublishViewModel.loadDraft();
                getFormData();
            } else if (this.draftType == c.a.q0.s.m.c.f14024f.b()) {
                Serializable serializableExtra = getIntent().getSerializableExtra(WorkPublishActivityConfig.PARAM_WRITE_DATA);
                if (serializableExtra instanceof WriteData) {
                    WorkPublishViewModel workPublishViewModel2 = this.viewModel;
                    if (workPublishViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    WriteData writeData = (WriteData) serializableExtra;
                    workPublishViewModel2.parseWriteData(writeData);
                    this.isDraftData = writeData.isWorkDraft();
                    this.isNeedCleanTag = false;
                }
            } else {
                this.isDraftData = false;
                Serializable serializableExtra2 = getIntent().getSerializableExtra(WorkPublishActivityConfig.PARAM_VIDEO_INFO);
                if (serializableExtra2 instanceof VideoInfo) {
                    WorkPublishViewModel workPublishViewModel3 = this.viewModel;
                    if (workPublishViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    workPublishViewModel3.updateVideo((VideoInfo) serializableExtra2);
                }
                getWriteData();
            }
            if (getIntent().getBooleanExtra(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921583));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processSaveDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel.saveDraft();
        }
    }

    private final void showLocPermissionDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(pageContext.getPageActivity());
            aVar.setMessageId(R.string.location_app_permission_prompt).setPositiveButton(R.string.isopen, new z(this)).setNegativeButton(R.string.cancel, a0.f59154e).create(getPageContext());
            aVar.show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0208  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void doPost() {
        boolean z2;
        WorkPublishViewModel workPublishViewModel;
        WorkPublishViewModel workPublishViewModel2;
        WorkPublishViewModel workPublishViewModel3;
        String a2;
        c.a.r0.j3.r0.g gVar;
        c.a.r0.j3.r0.g gVar2;
        c.a.r0.j3.r0.g i2;
        Iterator<String> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002016, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("name", OpenFlutter.ACTIVITY_VIDEO_WORK_LIST))));
            WriteData writeData = new WriteData();
            WorkPublishViewModel workPublishViewModel4 = this.viewModel;
            if (workPublishViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            writeData.setVideoInfo(workPublishViewModel4.getVideoInfo().getValue());
            WorkPublishViewModel workPublishViewModel5 = this.viewModel;
            if (workPublishViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            String value = workPublishViewModel5.getTitle().getValue();
            WorkPublishViewModel workPublishViewModel6 = this.viewModel;
            if (workPublishViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (workPublishViewModel6.getTopicInfo().getValue() != null) {
                WorkPublishViewModel workPublishViewModel7 = this.viewModel;
                if (workPublishViewModel7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                ArrayList<String> value2 = workPublishViewModel7.getTopicInfo().getValue();
                if (value2 == null) {
                    Intrinsics.throwNpe();
                }
                while (value2.iterator().hasNext()) {
                    value = value + '#' + it.next() + '#';
                }
            }
            writeData.setTitle(value);
            WorkPublishViewModel workPublishViewModel8 = this.viewModel;
            if (workPublishViewModel8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            writeData.setContent(workPublishViewModel8.getDesc().getValue());
            WorkPublishViewModel workPublishViewModel9 = this.viewModel;
            if (workPublishViewModel9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            c.a.q0.u.i value3 = workPublishViewModel9.getBarInfo().getValue();
            writeData.setForumId(value3 != null ? value3.f15029a : null);
            WorkPublishViewModel workPublishViewModel10 = this.viewModel;
            if (workPublishViewModel10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            c.a.q0.u.i value4 = workPublishViewModel10.getBarInfo().getValue();
            writeData.setForumName(value4 != null ? value4.f15031c : null);
            WorkPublishViewModel workPublishViewModel11 = this.viewModel;
            if (workPublishViewModel11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            boolean z3 = false;
            if (workPublishViewModel11.getPosInfo().getValue() != null) {
                c.a.r0.j3.n0.b a3 = c.a.r0.j3.n0.b.a();
                Intrinsics.checkExpressionValueIsNotNull(a3, "LocationInfo.getInstance()");
                if (!a3.d()) {
                    z2 = true;
                    writeData.setHasLocationData(z2);
                    writeData.setWork(true);
                    writeData.setWorkDraft(this.isDraftData);
                    VideoCategoryClassData videoCategoryClassData = new VideoCategoryClassData();
                    workPublishViewModel = this.viewModel;
                    if (workPublishViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    VideoCategoryClassData value5 = workPublishViewModel.getClassInfo().getValue();
                    videoCategoryClassData.setFirstClass(value5 == null ? value5.getFirstClass() : null);
                    workPublishViewModel2 = this.viewModel;
                    if (workPublishViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    VideoCategoryClassData value6 = workPublishViewModel2.getClassInfo().getValue();
                    videoCategoryClassData.setSecondClass(value6 != null ? value6.getSecondClass() : null);
                    workPublishViewModel3 = this.viewModel;
                    if (workPublishViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    if (workPublishViewModel3.getTagInfo().getValue() != null) {
                        WorkPublishViewModel workPublishViewModel12 = this.viewModel;
                        if (workPublishViewModel12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        }
                        videoCategoryClassData.setTags(workPublishViewModel12.getTagInfo().getValue());
                    }
                    writeData.setClassAndTagData(videoCategoryClassData);
                    a2 = c.a.q0.s.m.b.a();
                    if (!((a2 != null || a2.length() == 0) ? true : true)) {
                        String a4 = c.a.q0.s.m.b.a();
                        Intrinsics.checkExpressionValueIsNotNull(a4, "WorkPublishManager.getObjLocate()");
                        writeData.setStatisticFrom(Integer.parseInt(a4));
                    }
                    gVar = this.mWriteModel;
                    if (gVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                    }
                    gVar.C(writeData);
                    gVar2 = this.mWriteModel;
                    if (gVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                    }
                    gVar2.D();
                    i2 = c.a.r0.j3.r0.g.i();
                    Intrinsics.checkExpressionValueIsNotNull(i2, "AsyncWriteHelper.getInstance()");
                    if (i2.h() != null) {
                        c.a.r0.j3.r0.g i3 = c.a.r0.j3.r0.g.i();
                        Intrinsics.checkExpressionValueIsNotNull(i3, "AsyncWriteHelper.getInstance()");
                        if (i3.q()) {
                            n2 n2Var = new n2();
                            n2Var.f14271a = true;
                            c.a.r0.j3.r0.g i4 = c.a.r0.j3.r0.g.i();
                            Intrinsics.checkExpressionValueIsNotNull(i4, "AsyncWriteHelper.getInstance()");
                            n2Var.f14272b = i4.m();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921625, n2Var));
                        } else {
                            VideoWorkListActivityConfig videoWorkListActivityConfig = new VideoWorkListActivityConfig(this);
                            videoWorkListActivityConfig.addType("1");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoWorkListActivityConfig));
                        }
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921622, Boolean.TRUE));
                    }
                    setResult(100);
                    finish();
                }
            }
            z2 = false;
            writeData.setHasLocationData(z2);
            writeData.setWork(true);
            writeData.setWorkDraft(this.isDraftData);
            VideoCategoryClassData videoCategoryClassData2 = new VideoCategoryClassData();
            workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
            }
            VideoCategoryClassData value52 = workPublishViewModel.getClassInfo().getValue();
            videoCategoryClassData2.setFirstClass(value52 == null ? value52.getFirstClass() : null);
            workPublishViewModel2 = this.viewModel;
            if (workPublishViewModel2 == null) {
            }
            VideoCategoryClassData value62 = workPublishViewModel2.getClassInfo().getValue();
            videoCategoryClassData2.setSecondClass(value62 != null ? value62.getSecondClass() : null);
            workPublishViewModel3 = this.viewModel;
            if (workPublishViewModel3 == null) {
            }
            if (workPublishViewModel3.getTagInfo().getValue() != null) {
            }
            writeData.setClassAndTagData(videoCategoryClassData2);
            a2 = c.a.q0.s.m.b.a();
            if (!((a2 != null || a2.length() == 0) ? true : true)) {
            }
            gVar = this.mWriteModel;
            if (gVar == null) {
            }
            gVar.C(writeData);
            gVar2 = this.mWriteModel;
            if (gVar2 == null) {
            }
            gVar2.D();
            i2 = c.a.r0.j3.r0.g.i();
            Intrinsics.checkExpressionValueIsNotNull(i2, "AsyncWriteHelper.getInstance()");
            if (i2.h() != null) {
            }
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

    public final TextView getNavPost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            SelectBarView selectBarView = this.selectBarView;
            if (selectBarView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectBarView");
            }
            return selectBarView;
        }
        return (SelectBarView) invokeV.objValue;
    }

    public final SelectClassView getSelectClassView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SelectClassView selectClassView = this.selectClassView;
            if (selectClassView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectClassView");
            }
            return selectClassView;
        }
        return (SelectClassView) invokeV.objValue;
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

    public final SelectTagView getSelectTagView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            SelectTagView selectTagView = this.selectTagView;
            if (selectTagView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectTagView");
            }
            return selectTagView;
        }
        return (SelectTagView) invokeV.objValue;
    }

    public final SelectTopicView getSelectTopicView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            SelectTopicView selectTopicView = this.selectTopicView;
            if (selectTopicView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectTopicView");
            }
            return selectTopicView;
        }
        return (SelectTopicView) invokeV.objValue;
    }

    public final TextView getShowContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
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
            View findViewById7 = findViewById(R.id.select_class_view);
            Intrinsics.checkExpressionValueIsNotNull(findViewById7, "findViewById(R.id.select_class_view)");
            this.selectClassView = (SelectClassView) findViewById7;
            View findViewById8 = findViewById(R.id.select_topic_view);
            Intrinsics.checkExpressionValueIsNotNull(findViewById8, "findViewById(R.id.select_topic_view)");
            this.selectTopicView = (SelectTopicView) findViewById8;
            if (WorkAddTopicSwitch.isOn()) {
                SelectTopicView selectTopicView = this.selectTopicView;
                if (selectTopicView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectTopicView");
                }
                selectTopicView.setVisibility(0);
            } else {
                SelectTopicView selectTopicView2 = this.selectTopicView;
                if (selectTopicView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("selectTopicView");
                }
                selectTopicView2.setVisibility(8);
            }
            View findViewById9 = findViewById(R.id.select_tag_view);
            Intrinsics.checkExpressionValueIsNotNull(findViewById9, "findViewById(R.id.select_tag_view)");
            this.selectTagView = (SelectTagView) findViewById9;
            View findViewById10 = findViewById(R.id.select_pos_view);
            Intrinsics.checkExpressionValueIsNotNull(findViewById10, "findViewById(R.id.select_pos_view)");
            SelectPosView selectPosView = (SelectPosView) findViewById10;
            this.selectPosView = selectPosView;
            if (selectPosView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectPosView");
            }
            selectPosView.setOnClickListener(new g(this));
            View findViewById11 = findViewById(R.id.work_publish_show_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById11, "findViewById(R.id.work_publish_show_title)");
            this.showTitle = (TextView) findViewById11;
            View findViewById12 = findViewById(R.id.work_publish_show_content);
            Intrinsics.checkExpressionValueIsNotNull(findViewById12, "findViewById(R.id.work_publish_show_content)");
            this.showContent = (TextView) findViewById12;
            View findViewById13 = findViewById(R.id.work_publish_title_sign);
            Intrinsics.checkExpressionValueIsNotNull(findViewById13, "findViewById(R.id.work_publish_title_sign)");
            this.titleSign = (ImageView) findViewById13;
            View findViewById14 = findViewById(R.id.sep_line_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById14, "findViewById(R.id.sep_line_title)");
            this.titleBottomLine = findViewById14;
            View findViewById15 = findViewById(R.id.sep_line_content);
            Intrinsics.checkExpressionValueIsNotNull(findViewById15, "findViewById(R.id.sep_line_content)");
            this.contentBottomLine = findViewById15;
            View findViewById16 = findViewById(R.id.work_publish_title_counter);
            Intrinsics.checkExpressionValueIsNotNull(findViewById16, "findViewById(R.id.work_publish_title_counter)");
            this.counterTitle = (TextView) findViewById16;
            View findViewById17 = findViewById(R.id.work_publish_content_counter);
            Intrinsics.checkExpressionValueIsNotNull(findViewById17, "findViewById(R.id.work_publish_content_counter)");
            this.counterContent = (TextView) findViewById17;
            EditText editText = this.edtTitle;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            }
            editText.addTextChangedListener(new h(this));
            EditText editText2 = this.edtTitle;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            }
            editText2.setOnFocusChangeListener(new i(this));
            EditText editText3 = this.edtContent;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtContent");
            }
            editText3.addTextChangedListener(new j(this));
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel.isLegal().observe(this, new k(this));
            WorkPublishViewModel workPublishViewModel2 = this.viewModel;
            if (workPublishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel2.getTitle().observe(this, new l(this));
            WorkPublishViewModel workPublishViewModel3 = this.viewModel;
            if (workPublishViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel3.getDesc().observe(this, new m(this));
            WorkPublishViewModel workPublishViewModel4 = this.viewModel;
            if (workPublishViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel4.getBarInfo().observe(this, new n(this));
            WorkPublishViewModel workPublishViewModel5 = this.viewModel;
            if (workPublishViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel5.getClassInfo().observe(this, new o(this));
            WorkPublishViewModel workPublishViewModel6 = this.viewModel;
            if (workPublishViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel6.getTagInfo().observe(this, new c(this));
            WorkPublishViewModel workPublishViewModel7 = this.viewModel;
            if (workPublishViewModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel7.getTopicInfo().observe(this, new d(this));
            WorkPublishViewModel workPublishViewModel8 = this.viewModel;
            if (workPublishViewModel8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel8.getPosInfo().observe(this, new e(this));
            WorkPublishViewModel workPublishViewModel9 = this.viewModel;
            if (workPublishViewModel9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel9.getVideoInfo().observe(this, new f(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            ViewGroup viewGroup = this.workPublishBg;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("workPublishBg");
            }
            c.a.q0.s.u.c.d(viewGroup).f(R.color.CAM_X0201);
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
            c.a.q0.s.u.c d2 = c.a.q0.s.u.c.d(textView);
            d2.w(R.color.CAM_X0101);
            d2.o(R.string.J_X01);
            d2.f(R.color.CAM_X0302);
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (Intrinsics.areEqual(workPublishViewModel.isLegal().getValue(), Boolean.FALSE)) {
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
            ImageView imageView = this.titleSign;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleSign");
            }
            imageView.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_start, SkinManager.getColor(R.color.CAM_X0301), WebPManager.ResourceStateType.NORMAL));
            SelectBarView selectBarView = this.selectBarView;
            if (selectBarView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectBarView");
            }
            selectBarView.onChangeSkin();
            SelectPosView selectPosView = this.selectPosView;
            if (selectPosView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectPosView");
            }
            selectPosView.onChangeSkin();
            SelectClassView selectClassView = this.selectClassView;
            if (selectClassView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectClassView");
            }
            selectClassView.onChangeSkin();
            SelectTopicView selectTopicView = this.selectTopicView;
            if (selectTopicView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectTopicView");
            }
            selectTopicView.onChangeSkin();
            SelectTagView selectTagView = this.selectTagView;
            if (selectTagView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectTagView");
            }
            selectTagView.onChangeSkin();
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
            workPublishMixVideoView.onChangeSkin();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bundle) == null) {
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
            c.a.r0.j3.r0.g i2 = c.a.r0.j3.r0.g.i();
            Intrinsics.checkExpressionValueIsNotNull(i2, "AsyncWriteHelper.getInstance()");
            this.mWriteModel = i2;
            if (i2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
            }
            i2.o(this);
            initUI();
            registerListener(this.mSelectForumListener);
            registerListener(this.mOnSelectClassListener);
            registerListener(this.mOnSelectTopicListener);
            registerListener(this.mOnSelectLocationListener);
            registerListener(this.muxerSuccListener);
            registerListener(this.mOnSelectTagListener);
            registerListener(this.mShowCanNotSelectTagToastListener);
            registerListener(this.mCanChangeBarNameToastListener);
            prepareIntent();
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            if (workPublishViewModel.getVideoInfo().getValue() != null && !this.isDraftData) {
                StatisticItem statisticItem = new StatisticItem("c14311");
                WorkPublishViewModel workPublishViewModel2 = this.viewModel;
                if (workPublishViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                VideoInfo value = workPublishViewModel2.getVideoInfo().getValue();
                if (value == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(value, "viewModel.videoInfo.value!!");
                TiebaStatic.log(statisticItem.param("obj_source", value.getVideoSource()));
                return;
            }
            TiebaStatic.log(new StatisticItem("c14311").param("obj_source", 0));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            super.onDestroy();
            PopupDialog popupDialog = this.saveDraftDialog;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            this.saveDraftDialog = null;
            stopTask();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048604, this, i2, keyEvent)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            showToastWithDefaultIcon(getString(R.string.write_video_mix_fail), BdToast.DefaultIcon.FAILURE);
        }
    }

    @Override // c.a.r0.c4.u.p.c.a
    public void onMixStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel.updateMixStatus(i2);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, intent) == null) {
            super.onNewIntent(intent);
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra(WorkPublishActivityConfig.PARAM_VIDEO_INFO) : null;
            if (serializableExtra instanceof VideoInfo) {
                WorkPublishViewModel workPublishViewModel = this.viewModel;
                if (workPublishViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                workPublishViewModel.updateVideo((VideoInfo) serializableExtra);
            }
        }
    }

    public final void popupSaveDraftDialog() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (this.saveDraftDialogView == null) {
                this.saveDraftDialogView = new SaveDraftDialogView(this);
                y yVar = new y(this);
                SaveDraftDialogView saveDraftDialogView = this.saveDraftDialogView;
                if (saveDraftDialogView == null) {
                    Intrinsics.throwNpe();
                }
                saveDraftDialogView.setOnClickListener(yVar);
            }
            if (this.saveDraftDialog == null) {
                PopupDialog popupDialog = new PopupDialog(getPageContext());
                this.saveDraftDialog = popupDialog;
                if (popupDialog == null) {
                    Intrinsics.throwNpe();
                }
                popupDialog.setContentView(this.saveDraftDialogView);
            }
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            boolean checkIsVideoMixStatusLegal = workPublishViewModel.checkIsVideoMixStatusLegal();
            SaveDraftDialogView saveDraftDialogView2 = this.saveDraftDialogView;
            if (saveDraftDialogView2 == null) {
                Intrinsics.throwNpe();
            }
            saveDraftDialogView2.setButtonTag(R.id.key_is_video_mix_finish, Boolean.valueOf(checkIsVideoMixStatusLegal));
            SaveDraftDialogView saveDraftDialogView3 = this.saveDraftDialogView;
            if (saveDraftDialogView3 == null) {
                Intrinsics.throwNpe();
            }
            saveDraftDialogView3.setCancelVisible(checkIsVideoMixStatusLegal ? 0 : 8);
            SaveDraftDialogView saveDraftDialogView4 = this.saveDraftDialogView;
            if (saveDraftDialogView4 == null) {
                Intrinsics.throwNpe();
            }
            if (checkIsVideoMixStatusLegal) {
                i2 = R.string.write_save_draft_dialog_normal_title;
            } else {
                i2 = R.string.write_save_draft_failed_unfinish_zip_title;
            }
            saveDraftDialogView4.setText(getString(i2), null, getString(checkIsVideoMixStatusLegal ? R.string.save : R.string.write_save_draft_stay), getString(checkIsVideoMixStatusLegal ? R.string.not_save : R.string.write_save_draft_leave));
            PopupDialog popupDialog2 = this.saveDraftDialog;
            if (popupDialog2 == null) {
                Intrinsics.throwNpe();
            }
            popupDialog2.showDialog();
        }
    }

    public final void setContentBottomLine(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, view) == null) {
            this.contentBottomLine = view;
        }
    }

    public final void setCounterContent(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, textView) == null) {
            this.counterContent = textView;
        }
    }

    public final void setCounterTitle(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, textView) == null) {
            this.counterTitle = textView;
        }
    }

    public final void setEdtContent(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, editText) == null) {
            this.edtContent = editText;
        }
    }

    public final void setEdtTitle(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, editText) == null) {
            this.edtTitle = editText;
        }
    }

    public final void setHasClickedTitle(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048615, this, z2) == null) {
            this.hasClickedTitle = z2;
        }
    }

    public final void setMixVideoView(WorkPublishMixVideoView workPublishMixVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, workPublishMixVideoView) == null) {
            this.mixVideoView = workPublishMixVideoView;
        }
    }

    public final void setNavBack(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view) == null) {
            this.navBack = view;
        }
    }

    public final void setNavCenterText(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, textView) == null) {
            this.navCenterText = textView;
        }
    }

    public final void setNavPost(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, textView) == null) {
            this.navPost = textView;
        }
    }

    public final void setNavigationBar(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, navigationBar) == null) {
            this.navigationBar = navigationBar;
        }
    }

    public final void setRootView(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, viewGroup) == null) {
            this.rootView = viewGroup;
        }
    }

    public final void setSelectBarView(SelectBarView selectBarView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, selectBarView) == null) {
            this.selectBarView = selectBarView;
        }
    }

    public final void setSelectClassView(SelectClassView selectClassView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, selectClassView) == null) {
            this.selectClassView = selectClassView;
        }
    }

    public final void setSelectPosView(SelectPosView selectPosView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, selectPosView) == null) {
            this.selectPosView = selectPosView;
        }
    }

    public final void setSelectTagView(SelectTagView selectTagView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, selectTagView) == null) {
            this.selectTagView = selectTagView;
        }
    }

    public final void setSelectTopicView(SelectTopicView selectTopicView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, selectTopicView) == null) {
            this.selectTopicView = selectTopicView;
        }
    }

    public final void setShowContent(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, textView) == null) {
            this.showContent = textView;
        }
    }

    public final void setShowTitle(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, textView) == null) {
            this.showTitle = textView;
        }
    }

    public final void setTitleBottomLine(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, view) == null) {
            this.titleBottomLine = view;
        }
    }

    public final void setTitleSign(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, imageView) == null) {
            this.titleSign = imageView;
        }
    }

    public final void setViewModel(WorkPublishViewModel workPublishViewModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, workPublishViewModel) == null) {
            this.viewModel = workPublishViewModel;
        }
    }

    public final void setWorkPublishBg(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, viewGroup) == null) {
            this.workPublishBg = viewGroup;
        }
    }

    public final void stopTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            c.a.r0.j3.r0.g gVar = this.mWriteModel;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
            }
            if (gVar != null) {
                gVar.r();
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
                workPublishMixVideoView.onDestroy();
            }
        }
    }
}
