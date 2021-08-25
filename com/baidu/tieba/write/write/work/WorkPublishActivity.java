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
import c.a.p0.s.s.a;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\b¢\u0006\u0005\bÀ\u0001\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0012\u0010\u0005J!\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0005J\u0017\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001c\u0010\rJ\u0019\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0003¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\"\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\"\u0010\u0005J\u000f\u0010#\u001a\u00020\u0003H\u0002¢\u0006\u0004\b#\u0010\u0005J\u000f\u0010$\u001a\u00020\u0003H\u0002¢\u0006\u0004\b$\u0010\u0005J\r\u0010%\u001a\u00020\u0003¢\u0006\u0004\b%\u0010\u0005R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b4\u0010/\u001a\u0004\b5\u00101\"\u0004\b6\u00103R\u0016\u00107\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010@\u001a\u0002098\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b@\u0010;\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?R\"\u0010C\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010DR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010RR\u0016\u0010T\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bT\u0010RR\u0016\u0010U\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010RR\u0016\u0010V\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010RR\u0016\u0010W\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010RR\u0016\u0010Y\u001a\u00020X8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bY\u0010ZR\"\u0010\\\u001a\u00020[8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020P8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010RR\"\u0010c\u001a\u00020&8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bc\u0010(\u001a\u0004\bd\u0010*\"\u0004\be\u0010,R\"\u0010f\u001a\u00020-8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bf\u0010/\u001a\u0004\bg\u00101\"\u0004\bh\u00103R\"\u0010j\u001a\u00020i8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010p\u001a\u00020-8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bp\u0010/\u001a\u0004\bq\u00101\"\u0004\br\u00103R\"\u0010t\u001a\u00020s8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR#\u0010{\u001a\u00020z8\u0006@\u0006X\u0086.¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u001c\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001c\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R*\u0010\u0088\u0001\u001a\u00030\u0087\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R*\u0010\u008f\u0001\u001a\u00030\u008e\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R*\u0010\u0096\u0001\u001a\u00030\u0095\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R*\u0010\u009d\u0001\u001a\u00030\u009c\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R*\u0010¤\u0001\u001a\u00030£\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b¤\u0001\u0010¥\u0001\u001a\u0006\b¦\u0001\u0010§\u0001\"\u0006\b¨\u0001\u0010©\u0001R&\u0010ª\u0001\u001a\u00020-8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\bª\u0001\u0010/\u001a\u0005\b«\u0001\u00101\"\u0005\b¬\u0001\u00103R&\u0010\u00ad\u0001\u001a\u00020-8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b\u00ad\u0001\u0010/\u001a\u0005\b®\u0001\u00101\"\u0005\b¯\u0001\u00103R&\u0010°\u0001\u001a\u00020&8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b°\u0001\u0010(\u001a\u0005\b±\u0001\u0010*\"\u0005\b²\u0001\u0010,R&\u0010³\u0001\u001a\u00020i8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b³\u0001\u0010k\u001a\u0005\b´\u0001\u0010m\"\u0005\bµ\u0001\u0010oR*\u0010·\u0001\u001a\u00030¶\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b·\u0001\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R'\u0010½\u0001\u001a\u00020z8\u0006@\u0006X\u0086.¢\u0006\u0016\n\u0005\b½\u0001\u0010|\u001a\u0005\b¾\u0001\u0010~\"\u0006\b¿\u0001\u0010\u0080\u0001¨\u0006Á\u0001"}, d2 = {"Lcom/baidu/tieba/write/write/work/WorkPublishActivity;", "Lc/a/q0/b4/u/q/b/a;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "", "clearDraft", "()V", "doPost", "goToSelectLocationActivity", "initNav", "initUI", "", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "(I)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", MissionEvent.MESSAGE_DESTROY, "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "onLocViewClickedInInitState", "onMixFail", "status", "onMixStateChanged", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "popupSaveDraftDialog", "prepareIntent", "processSaveDraft", "showLocPermissionDialog", "stopTask", "Landroid/view/View;", "contentBottomLine", "Landroid/view/View;", "getContentBottomLine", "()Landroid/view/View;", "setContentBottomLine", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "counterContent", "Landroid/widget/TextView;", "getCounterContent", "()Landroid/widget/TextView;", "setCounterContent", "(Landroid/widget/TextView;)V", "counterTitle", "getCounterTitle", "setCounterTitle", "draftType", "I", "Landroid/widget/EditText;", "edtContent", "Landroid/widget/EditText;", "getEdtContent", "()Landroid/widget/EditText;", "setEdtContent", "(Landroid/widget/EditText;)V", "edtTitle", "getEdtTitle", "setEdtTitle", "hasClickedTitle", "Z", "getHasClickedTitle", "()Z", "setHasClickedTitle", "(Z)V", "isDraftData", "Lcom/baidu/tieba/tbadkCore/location/LocationModel;", "mLocationModel", "Lcom/baidu/tieba/tbadkCore/location/LocationModel;", "Lcom/baidu/tieba/tbadkCore/location/LocationModel$OnLocationCallBack;", "mOnLocationCallBack", "Lcom/baidu/tieba/tbadkCore/location/LocationModel$OnLocationCallBack;", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mOnSelectClassListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mOnSelectLocationListener", "mOnSelectTagListener", "mOnSelectTopicListener", "mSelectForumListener", "mShowCanNotSelectTagToastListener", "Lcom/baidu/tieba/tbadkCore/writeModel/AsyncWriteHelper;", "mWriteModel", "Lcom/baidu/tieba/tbadkCore/writeModel/AsyncWriteHelper;", "Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;", "mixVideoView", "Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;", "getMixVideoView", "()Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;", "setMixVideoView", "(Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;)V", "muxerSuccListener", "navBack", "getNavBack", "setNavBack", "navCenterText", "getNavCenterText", "setNavCenterText", "Landroid/widget/ImageView;", "navCenterTip", "Landroid/widget/ImageView;", "getNavCenterTip", "()Landroid/widget/ImageView;", "setNavCenterTip", "(Landroid/widget/ImageView;)V", "navPost", "getNavPost", "setNavPost", "Lcom/baidu/tbadk/core/view/NavigationBar;", "navigationBar", "Lcom/baidu/tbadk/core/view/NavigationBar;", "getNavigationBar", "()Lcom/baidu/tbadk/core/view/NavigationBar;", "setNavigationBar", "(Lcom/baidu/tbadk/core/view/NavigationBar;)V", "Landroid/view/ViewGroup;", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "setRootView", "(Landroid/view/ViewGroup;)V", "Lcom/baidu/tbadk/core/dialog/PopupDialog;", "saveDraftDialog", "Lcom/baidu/tbadk/core/dialog/PopupDialog;", "Lcom/baidu/tbadk/core/view/SaveDraftDialogView;", "saveDraftDialogView", "Lcom/baidu/tbadk/core/view/SaveDraftDialogView;", "Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;", "selectBarView", "Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;", "getSelectBarView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;", "setSelectBarView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;)V", "Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;", "selectClassView", "Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;", "getSelectClassView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;", "setSelectClassView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;)V", "Lcom/baidu/tieba/write/write/work/selectview/SelectPosView;", "selectPosView", "Lcom/baidu/tieba/write/write/work/selectview/SelectPosView;", "getSelectPosView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectPosView;", "setSelectPosView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectPosView;)V", "Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;", "selectTagView", "Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;", "getSelectTagView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;", "setSelectTagView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;)V", "Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;", "selectTopicView", "Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;", "getSelectTopicView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;", "setSelectTopicView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;)V", "showContent", "getShowContent", "setShowContent", "showTitle", "getShowTitle", "setShowTitle", "titleBottomLine", "getTitleBottomLine", "setTitleBottomLine", "titleSign", "getTitleSign", "setTitleSign", "Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "viewModel", "Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "getViewModel", "()Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "setViewModel", "(Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;)V", "workPublishBg", "getWorkPublishBg", "setWorkPublishBg", "<init>", "write_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class WorkPublishActivity extends BaseFragmentActivity implements c.a.q0.b4.u.q.b.a {
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
    public final CustomMessageListener mOnSelectClassListener;
    public final CustomMessageListener mOnSelectLocationListener;
    public final CustomMessageListener mOnSelectTagListener;
    public final CustomMessageListener mOnSelectTopicListener;
    public final CustomMessageListener mSelectForumListener;
    public final CustomMessageListener mShowCanNotSelectTagToastListener;
    public c.a.q0.i3.r0.g mWriteModel;
    public WorkPublishMixVideoView mixVideoView;
    public final CustomMessageListener muxerSuccListener;
    public View navBack;
    public TextView navCenterText;
    public ImageView navCenterTip;
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
        public final /* synthetic */ WorkPublishActivity f58976e;

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
            this.f58976e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f58976e.popupSaveDraftDialog();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class a0 implements a.e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final a0 f58977e;
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
            f58977e = new a0();
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

        @Override // c.a.p0.s.s.a.e
        public final void onClick(c.a.p0.s.s.a aVar) {
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
        public final /* synthetic */ WorkPublishActivity f58978e;

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
            this.f58978e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f58978e.doPost();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f58979e;

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
            this.f58979e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.p0.m.a.v(true, this.f58979e.getBaseContext(), this.f58979e.getString(R.string.work_publish_webview_introduce), TbConfig.URL_WORKS_INFO);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d<T> implements Observer<ArrayList<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f58980e;

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
            this.f58980e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(ArrayList<String> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                SelectTagView selectTagView = this.f58980e.getSelectTagView();
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                selectTagView.bindData(it);
                this.f58980e.getSelectClassView().setMIsSelectedTags(!it.isEmpty());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class e<T> implements Observer<ArrayList<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f58981e;

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
            this.f58981e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(ArrayList<String> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                SelectTopicView selectTopicView = this.f58981e.getSelectTopicView();
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                selectTopicView.bindData(it);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class f<T> implements Observer<ResponsedSelectLocation> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f58982e;

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
            this.f58982e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(ResponsedSelectLocation responsedSelectLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedSelectLocation) == null) {
                this.f58982e.getSelectPosView().bindData(responsedSelectLocation);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class g<T> implements Observer<VideoInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f58983e;

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
            this.f58983e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(VideoInfo videoInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, videoInfo) == null) || videoInfo == null) {
                return;
            }
            this.f58983e.getMixVideoView().setVideoInfo(videoInfo, false);
        }
    }

    /* loaded from: classes7.dex */
    public static final class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f58984e;

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
            this.f58984e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f58984e.onLocViewClickedInInitState();
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class i implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f58985e;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
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
            this.f58985e = workPublishActivity;
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
                TextView counterTitle = this.f58985e.getCounterTitle();
                counterTitle.setText("(" + String.valueOf(obj.length()) + "/31)");
                if (obj.length() == 31) {
                    this.f58985e.getCounterTitle().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.f58985e.getCounterTitle().setTextColor(SkinManager.getColor(R.color.CAM_X0105));
                }
                this.f58985e.getViewModel().updateTitle(obj);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class j implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f58986e;

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
            this.f58986e = workPublishActivity;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (z) {
                    this.f58986e.setHasClickedTitle(true);
                } else if (!this.f58986e.getHasClickedTitle() || this.f58986e.getViewModel().checkIsTitleLegal()) {
                } else {
                    new BdTopToast(this.f58986e).setIcon(false).setContent(this.f58986e.getString(R.string.work_publish_title_too_short)).show(this.f58986e.getRootView());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class k implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f58987e;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
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
            this.f58987e = workPublishActivity;
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
                TextView counterContent = this.f58987e.getCounterContent();
                counterContent.setText("(" + String.valueOf(obj.length()) + "/300)");
                if (obj.length() == 300) {
                    this.f58987e.getCounterContent().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
                } else {
                    this.f58987e.getCounterContent().setTextColor(SkinManager.getColor(R.color.CAM_X0105));
                }
                this.f58987e.getViewModel().getDesc().setValue(obj);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class l<T> implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f58988e;

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
            this.f58988e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (Intrinsics.areEqual(this.f58988e.getViewModel().isLegal().getValue(), Boolean.FALSE)) {
                    this.f58988e.getNavPost().setAlpha(0.33f);
                    this.f58988e.getNavPost().setEnabled(false);
                    return;
                }
                this.f58988e.getNavPost().setAlpha(1.0f);
                this.f58988e.getNavPost().setEnabled(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class m<T> implements Observer<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f58989e;

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
            this.f58989e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || str.equals(this.f58989e.getEdtTitle().getText().toString())) {
                return;
            }
            this.f58989e.getEdtTitle().setText(str);
        }
    }

    /* loaded from: classes7.dex */
    public static final class n<T> implements Observer<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f58990e;

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
            this.f58990e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || str == null || str.equals(this.f58990e.getEdtContent().getText().toString())) {
                return;
            }
            this.f58990e.getEdtContent().setText(str);
        }
    }

    /* loaded from: classes7.dex */
    public static final class o<T> implements Observer<c.a.p0.u.i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f58991e;

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
            this.f58991e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(c.a.p0.u.i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                this.f58991e.getSelectBarView().bindData(iVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class p<T> implements Observer<c.a.p0.u.n> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f58992e;

        public p(WorkPublishActivity workPublishActivity) {
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
            this.f58992e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(c.a.p0.u.n it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                this.f58992e.getSelectClassView().bindData(it);
                String firstClass = this.f58992e.getSelectTagView().getFirstClass();
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                if ((!Intrinsics.areEqual(firstClass, it.a())) || (!Intrinsics.areEqual(this.f58992e.getSelectTagView().getSecondClass(), it.b()))) {
                    SelectTagView selectTagView = this.f58992e.getSelectTagView();
                    String a2 = it.a();
                    Intrinsics.checkExpressionValueIsNotNull(a2, "it.firstClass");
                    String b2 = it.b();
                    Intrinsics.checkExpressionValueIsNotNull(b2, "it.secondClass");
                    selectTagView.setClassData(a2, b2);
                    this.f58992e.getViewModel().getTagInfo().setValue(new ArrayList<>());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class q implements LocationModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f58993a;

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
            this.f58993a = workPublishActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f58993a.showToast(R.string.no_network_guide);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationData) == null) {
                if (!StringUtils.isNull(locationData.getFormatted_address())) {
                    this.f58993a.goToSelectLocationActivity();
                    return;
                }
                WorkPublishActivity workPublishActivity = this.f58993a;
                workPublishActivity.showToast(workPublishActivity.getString(R.string.location_fail));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                WorkPublishActivity workPublishActivity = this.f58993a;
                if (StringUtils.isNull(str)) {
                    str = this.f58993a.getString(R.string.location_fail);
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
        public final /* synthetic */ WorkPublishActivity f58994a;

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
            this.f58994a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof c.a.p0.u.n)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    this.f58994a.getViewModel().getClassInfo().setValue((c.a.p0.u.n) data);
                    this.f58994a.getViewModel().checkIsAllLegal();
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
        public final /* synthetic */ WorkPublishActivity f58995a;

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
            this.f58995a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedSelectLocation)) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WorkPublishActivity.access$getMLocationModel$p(this.f58995a).M(false);
                    WorkPublishActivity.access$getMLocationModel$p(this.f58995a).L(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                } else {
                    WorkPublishActivity.access$getMLocationModel$p(this.f58995a).M(true);
                }
                this.f58995a.getViewModel().getPosInfo().setValue(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f58996a;

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
            this.f58996a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof ArrayList)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    this.f58996a.getViewModel().getTagInfo().setValue((ArrayList) data);
                    this.f58996a.getViewModel().checkIsAllLegal();
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
        public final /* synthetic */ WorkPublishActivity f58997a;

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
            this.f58997a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof ArrayList)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    this.f58997a.getViewModel().getTopicInfo().setValue((ArrayList) data);
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
        public final /* synthetic */ WorkPublishActivity f58998a;

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
            this.f58998a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof c.a.p0.u.i)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    this.f58998a.getViewModel().getBarInfo().setValue((c.a.p0.u.i) data);
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
        public final /* synthetic */ WorkPublishActivity f58999a;

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
            this.f58999a = workPublishActivity;
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
                    new BdTopToast(this.f58999a.getBaseContext()).setIcon(false).setContent(this.f58999a.getResources().getString(R.string.can_not_select_tag)).show(this.f58999a.getNavigationBar());
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59000a;

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
            this.f59000a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof VideoInfo)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    this.f59000a.getViewModel().updateVideo((VideoInfo) data);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.tbadk.coreExtra.data.VideoInfo");
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class y implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59001e;

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
            this.f59001e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
                PopupDialog popupDialog = this.f59001e.saveDraftDialog;
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
                                this.f59001e.clearDraft();
                            }
                            this.f59001e.setResult(100);
                            this.f59001e.finish();
                            return;
                        } else if (id != R.id.save_draft_dialog_save) {
                            if (id == R.id.save_draft_dialog_cancle && booleanValue) {
                                TiebaStatic.log(new StatisticItem("c14260").param("obj_locate", 0));
                                return;
                            }
                            return;
                        } else if (booleanValue) {
                            TiebaStatic.log(new StatisticItem("c14260").param("obj_locate", 1));
                            this.f59001e.processSaveDraft();
                            this.f59001e.setResult(100);
                            this.f59001e.finish();
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

    /* loaded from: classes7.dex */
    public static final class z implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f59002e;

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
            this.f59002e = workPublishActivity;
        }

        @Override // c.a.p0.s.s.a.e
        public final void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!c.a.e.e.p.j.z()) {
                    this.f59002e.mOnLocationCallBack.a();
                } else {
                    WorkPublishActivity.access$getMLocationModel$p(this.f59002e).K();
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
        this.muxerSuccListener = new x(this, 2921593);
        this.mSelectForumListener = new v(this, 2921505);
        this.mOnSelectClassListener = new r(this, 2921601);
        this.mOnSelectTagListener = new t(this, 2921604);
        this.mShowCanNotSelectTagToastListener = new w(this, 2921605);
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
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel.clearDraft();
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
                c.a.p0.s.u.c.d(textView3).y(R.dimen.T_X08);
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
            if (intExtra == c.a.p0.s.m.c.f14071c.a()) {
                this.isDraftData = true;
                WorkPublishViewModel workPublishViewModel = this.viewModel;
                if (workPublishViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                workPublishViewModel.loadDraft();
            } else if (this.draftType == c.a.p0.s.m.c.f14071c.b()) {
                Serializable serializableExtra = getIntent().getSerializableExtra(WorkPublishActivityConfig.PARAM_WRITE_DATA);
                if (serializableExtra instanceof WriteData) {
                    WorkPublishViewModel workPublishViewModel2 = this.viewModel;
                    if (workPublishViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    WriteData writeData = (WriteData) serializableExtra;
                    workPublishViewModel2.parseWriteData(writeData);
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
                    workPublishViewModel3.updateVideo((VideoInfo) serializableExtra2);
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
            workPublishViewModel.saveDraft();
        }
    }

    private final void showLocPermissionDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(pageContext.getPageActivity());
            aVar.setMessageId(R.string.location_app_permission_prompt).setPositiveButton(R.string.isopen, new z(this)).setNegativeButton(R.string.cancel, a0.f58977e).create(getPageContext());
            aVar.show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0197  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void doPost() {
        boolean z2;
        WorkPublishViewModel workPublishViewModel;
        WorkPublishViewModel workPublishViewModel2;
        WorkPublishViewModel workPublishViewModel3;
        String b2;
        c.a.q0.i3.r0.g gVar;
        c.a.q0.i3.r0.g gVar2;
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
            c.a.p0.u.i value3 = workPublishViewModel9.getBarInfo().getValue();
            writeData.setForumId(value3 != null ? value3.f15024a : null);
            WorkPublishViewModel workPublishViewModel10 = this.viewModel;
            if (workPublishViewModel10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            c.a.p0.u.i value4 = workPublishViewModel10.getBarInfo().getValue();
            writeData.setForumName(value4 != null ? value4.f15026c : null);
            WorkPublishViewModel workPublishViewModel11 = this.viewModel;
            if (workPublishViewModel11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            boolean z3 = false;
            if (workPublishViewModel11.getPosInfo().getValue() != null) {
                c.a.q0.i3.n0.b a2 = c.a.q0.i3.n0.b.a();
                Intrinsics.checkExpressionValueIsNotNull(a2, "LocationInfo.getInstance()");
                if (!a2.d()) {
                    z2 = true;
                    writeData.setHasLocationData(z2);
                    writeData.setWork(true);
                    writeData.setWorkDraft(this.isDraftData);
                    c.a.p0.u.n nVar = new c.a.p0.u.n();
                    workPublishViewModel = this.viewModel;
                    if (workPublishViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    c.a.p0.u.n value5 = workPublishViewModel.getClassInfo().getValue();
                    nVar.d(value5 == null ? value5.a() : null);
                    workPublishViewModel2 = this.viewModel;
                    if (workPublishViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    c.a.p0.u.n value6 = workPublishViewModel2.getClassInfo().getValue();
                    nVar.e(value6 != null ? value6.b() : null);
                    workPublishViewModel3 = this.viewModel;
                    if (workPublishViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    nVar.f(workPublishViewModel3.getTagInfo().getValue());
                    writeData.setClassAndTagData(nVar);
                    b2 = c.a.p0.s.m.b.b();
                    if (!((b2 != null || b2.length() == 0) ? true : true)) {
                        String b3 = c.a.p0.s.m.b.b();
                        Intrinsics.checkExpressionValueIsNotNull(b3, "WorkPublishManager.getObjLocate()");
                        writeData.setStatisticFrom(Integer.parseInt(b3));
                    }
                    gVar = this.mWriteModel;
                    if (gVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                    }
                    gVar.w(writeData);
                    gVar2 = this.mWriteModel;
                    if (gVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                    }
                    gVar2.x();
                    VideoWorkListActivityConfig videoWorkListActivityConfig = new VideoWorkListActivityConfig(this);
                    videoWorkListActivityConfig.addType("1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoWorkListActivityConfig));
                    setResult(100);
                    finish();
                }
            }
            z2 = false;
            writeData.setHasLocationData(z2);
            writeData.setWork(true);
            writeData.setWorkDraft(this.isDraftData);
            c.a.p0.u.n nVar2 = new c.a.p0.u.n();
            workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
            }
            c.a.p0.u.n value52 = workPublishViewModel.getClassInfo().getValue();
            nVar2.d(value52 == null ? value52.a() : null);
            workPublishViewModel2 = this.viewModel;
            if (workPublishViewModel2 == null) {
            }
            c.a.p0.u.n value62 = workPublishViewModel2.getClassInfo().getValue();
            nVar2.e(value62 != null ? value62.b() : null);
            workPublishViewModel3 = this.viewModel;
            if (workPublishViewModel3 == null) {
            }
            nVar2.f(workPublishViewModel3.getTagInfo().getValue());
            writeData.setClassAndTagData(nVar2);
            b2 = c.a.p0.s.m.b.b();
            if (!((b2 != null || b2.length() == 0) ? true : true)) {
            }
            gVar = this.mWriteModel;
            if (gVar == null) {
            }
            gVar.w(writeData);
            gVar2 = this.mWriteModel;
            if (gVar2 == null) {
            }
            gVar2.x();
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

    public final SelectClassView getSelectClassView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
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
            selectPosView.setOnClickListener(new h(this));
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
            editText.addTextChangedListener(new i(this));
            EditText editText2 = this.edtTitle;
            if (editText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            }
            editText2.setOnFocusChangeListener(new j(this));
            EditText editText3 = this.edtContent;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtContent");
            }
            editText3.addTextChangedListener(new k(this));
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel.isLegal().observe(this, new l(this));
            WorkPublishViewModel workPublishViewModel2 = this.viewModel;
            if (workPublishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel2.getTitle().observe(this, new m(this));
            WorkPublishViewModel workPublishViewModel3 = this.viewModel;
            if (workPublishViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel3.getDesc().observe(this, new n(this));
            WorkPublishViewModel workPublishViewModel4 = this.viewModel;
            if (workPublishViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel4.getBarInfo().observe(this, new o(this));
            WorkPublishViewModel workPublishViewModel5 = this.viewModel;
            if (workPublishViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel5.getClassInfo().observe(this, new p(this));
            WorkPublishViewModel workPublishViewModel6 = this.viewModel;
            if (workPublishViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel6.getTagInfo().observe(this, new d(this));
            WorkPublishViewModel workPublishViewModel7 = this.viewModel;
            if (workPublishViewModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel7.getTopicInfo().observe(this, new e(this));
            WorkPublishViewModel workPublishViewModel8 = this.viewModel;
            if (workPublishViewModel8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel8.getPosInfo().observe(this, new f(this));
            WorkPublishViewModel workPublishViewModel9 = this.viewModel;
            if (workPublishViewModel9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel9.getVideoInfo().observe(this, new g(this));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            ViewGroup viewGroup = this.workPublishBg;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("workPublishBg");
            }
            c.a.p0.s.u.c.d(viewGroup).f(R.color.CAM_X0201);
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
            c.a.p0.s.u.c d2 = c.a.p0.s.u.c.d(textView);
            d2.u(R.color.CAM_X0101);
            d2.n(R.string.J_X01);
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
        if (interceptable == null || interceptable.invokeL(1048603, this, bundle) == null) {
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
            c.a.q0.i3.r0.g g2 = c.a.q0.i3.r0.g.g();
            Intrinsics.checkExpressionValueIsNotNull(g2, "AsyncWriteHelper.getInstance()");
            this.mWriteModel = g2;
            if (g2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
            }
            g2.l(this);
            initUI();
            registerListener(this.mSelectForumListener);
            registerListener(this.mOnSelectClassListener);
            registerListener(this.mOnSelectTopicListener);
            registerListener(this.mOnSelectLocationListener);
            registerListener(this.muxerSuccListener);
            registerListener(this.mOnSelectTagListener);
            registerListener(this.mShowCanNotSelectTagToastListener);
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
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
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
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048605, this, i2, keyEvent)) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            showToastWithDefaultIcon(getString(R.string.write_video_mix_fail), BdToast.DefaultIcon.FAILURE);
        }
    }

    @Override // c.a.q0.b4.u.q.b.a
    public void onMixStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048609, this, intent) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048611, this, view) == null) {
            this.contentBottomLine = view;
        }
    }

    public final void setCounterContent(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, textView) == null) {
            this.counterContent = textView;
        }
    }

    public final void setCounterTitle(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, textView) == null) {
            this.counterTitle = textView;
        }
    }

    public final void setEdtContent(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, editText) == null) {
            this.edtContent = editText;
        }
    }

    public final void setEdtTitle(EditText editText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, editText) == null) {
            this.edtTitle = editText;
        }
    }

    public final void setHasClickedTitle(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048616, this, z2) == null) {
            this.hasClickedTitle = z2;
        }
    }

    public final void setMixVideoView(WorkPublishMixVideoView workPublishMixVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, workPublishMixVideoView) == null) {
            this.mixVideoView = workPublishMixVideoView;
        }
    }

    public final void setNavBack(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, view) == null) {
            this.navBack = view;
        }
    }

    public final void setNavCenterText(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, textView) == null) {
            this.navCenterText = textView;
        }
    }

    public final void setNavCenterTip(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, imageView) == null) {
            this.navCenterTip = imageView;
        }
    }

    public final void setNavPost(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, textView) == null) {
            this.navPost = textView;
        }
    }

    public final void setNavigationBar(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, navigationBar) == null) {
            this.navigationBar = navigationBar;
        }
    }

    public final void setRootView(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, viewGroup) == null) {
            this.rootView = viewGroup;
        }
    }

    public final void setSelectBarView(SelectBarView selectBarView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, selectBarView) == null) {
            this.selectBarView = selectBarView;
        }
    }

    public final void setSelectClassView(SelectClassView selectClassView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, selectClassView) == null) {
            this.selectClassView = selectClassView;
        }
    }

    public final void setSelectPosView(SelectPosView selectPosView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, selectPosView) == null) {
            this.selectPosView = selectPosView;
        }
    }

    public final void setSelectTagView(SelectTagView selectTagView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, selectTagView) == null) {
            this.selectTagView = selectTagView;
        }
    }

    public final void setSelectTopicView(SelectTopicView selectTopicView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, selectTopicView) == null) {
            this.selectTopicView = selectTopicView;
        }
    }

    public final void setShowContent(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, textView) == null) {
            this.showContent = textView;
        }
    }

    public final void setShowTitle(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, textView) == null) {
            this.showTitle = textView;
        }
    }

    public final void setTitleBottomLine(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, view) == null) {
            this.titleBottomLine = view;
        }
    }

    public final void setTitleSign(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, imageView) == null) {
            this.titleSign = imageView;
        }
    }

    public final void setViewModel(WorkPublishViewModel workPublishViewModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, workPublishViewModel) == null) {
            this.viewModel = workPublishViewModel;
        }
    }

    public final void setWorkPublishBg(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, viewGroup) == null) {
            this.workPublishBg = viewGroup;
        }
    }

    public final void stopTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            c.a.q0.i3.r0.g gVar = this.mWriteModel;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
            }
            if (gVar != null) {
                gVar.n();
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
