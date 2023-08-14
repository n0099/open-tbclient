package com.baidu.tieba.write.write.work;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.CommunityConventionView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.SelectLocationActivityConfig;
import com.baidu.tbadk.core.atomData.VideoWorkListActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishActivityConfig;
import com.baidu.tbadk.core.atomData.WorkPublishManager;
import com.baidu.tbadk.core.atomData.WorkPublishOpenHelper;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.WorkPostBackToPersonCenterFlutterData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.SaveDraftDialogView;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.VideoInfo;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tbadk.data.VideoCategoryClassData;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.WorkAddTopicSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopicselect.HotTopicSelectModel;
import com.baidu.tieba.iza;
import com.baidu.tieba.l98;
import com.baidu.tieba.o98;
import com.baidu.tieba.ov5;
import com.baidu.tieba.pda;
import com.baidu.tieba.pua;
import com.baidu.tieba.qca;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.tieba.tbadkCore.writeModel.WriteMsgHolder;
import com.baidu.tieba.u45;
import com.baidu.tieba.va5;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.write.write.work.WorkPublishActivity;
import com.baidu.tieba.write.write.work.model.WorkPublishViewModel;
import com.baidu.tieba.write.write.work.selectview.SelectBarView;
import com.baidu.tieba.write.write.work.selectview.SelectClassView;
import com.baidu.tieba.write.write.work.selectview.SelectTagView;
import com.baidu.tieba.write.write.work.selectview.SelectTopicView;
import com.baidu.tieba.write.write.work.topic.SelectTopicLayout;
import com.baidu.tieba.write.write.work.topic.SelectTopicModel;
import com.baidu.tieba.write.write.work.topic.view.SelectTopicToolBar;
import com.baidu.tieba.write.write.work.videoview.WorkPublishMixVideoView;
import com.baidu.tieba.yua;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u009a\u0001\u001a\u00020\u00062\u0007\u0010\u009b\u0001\u001a\u00020\u0006H\u0002J\n\u0010\u009c\u0001\u001a\u00030\u009d\u0001H\u0002J\b\u0010\u009e\u0001\u001a\u00030\u009d\u0001J\u0013\u0010\u009f\u0001\u001a\u00030\u009d\u00012\u0007\u0010 \u0001\u001a\u00020\u0006H\u0002J\n\u0010¡\u0001\u001a\u00030\u009d\u0001H\u0002J\n\u0010¢\u0001\u001a\u00030\u009d\u0001H\u0002J\n\u0010£\u0001\u001a\u00030\u009d\u0001H\u0002J\n\u0010¤\u0001\u001a\u00030\u009d\u0001H\u0002J\n\u0010¥\u0001\u001a\u00030\u009d\u0001H\u0002J\n\u0010¦\u0001\u001a\u00030\u009d\u0001H\u0002J\b\u0010§\u0001\u001a\u00030\u009d\u0001J\u0012\u0010¨\u0001\u001a\u0004\u0018\u00010F2\u0007\u0010©\u0001\u001a\u00020BJ\n\u0010ª\u0001\u001a\u00030\u009d\u0001H\u0002J\u0013\u0010«\u0001\u001a\u00030\u009d\u00012\u0007\u0010¬\u0001\u001a\u00020\u0006H\u0014J\u0016\u0010\u00ad\u0001\u001a\u00030\u009d\u00012\n\u0010®\u0001\u001a\u0005\u0018\u00010¯\u0001H\u0014J\n\u0010°\u0001\u001a\u00030\u009d\u0001H\u0014J\u0015\u0010±\u0001\u001a\u00030\u009d\u00012\t\u0010²\u0001\u001a\u0004\u0018\u00010BH\u0016J+\u0010³\u0001\u001a\u00030\u009d\u00012\t\u0010´\u0001\u001a\u0004\u0018\u00010D2\t\u0010µ\u0001\u001a\u0004\u0018\u00010D2\t\u0010¶\u0001\u001a\u0004\u0018\u00010DH\u0016J\u0015\u0010·\u0001\u001a\u00030\u009d\u00012\t\u0010²\u0001\u001a\u0004\u0018\u00010BH\u0016J\u0015\u0010¸\u0001\u001a\u00030\u009d\u00012\t\u0010¹\u0001\u001a\u0004\u0018\u00010DH\u0016J\u001e\u0010º\u0001\u001a\u00020$2\u0007\u0010»\u0001\u001a\u00020\u00062\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001H\u0016J\u0013\u0010¾\u0001\u001a\u00030\u009d\u00012\u0007\u0010¿\u0001\u001a\u00020$H\u0014J\b\u0010À\u0001\u001a\u00030\u009d\u0001J\n\u0010Á\u0001\u001a\u00030\u009d\u0001H\u0016J\u0013\u0010Â\u0001\u001a\u00030\u009d\u00012\u0007\u0010Ã\u0001\u001a\u00020\u0006H\u0016J\u0014\u0010Ä\u0001\u001a\u00030\u009d\u00012\b\u0010Å\u0001\u001a\u00030Æ\u0001H\u0016J\u0016\u0010Ç\u0001\u001a\u00030\u009d\u00012\n\u0010È\u0001\u001a\u0005\u0018\u00010É\u0001H\u0014J\n\u0010Ê\u0001\u001a\u00030\u009d\u0001H\u0014J\n\u0010Ë\u0001\u001a\u00030\u009d\u0001H\u0002J\u0015\u0010Ì\u0001\u001a\u00030\u009d\u00012\t\b\u0002\u0010Í\u0001\u001a\u00020$H\u0002J\b\u0010Î\u0001\u001a\u00030\u009d\u0001J\n\u0010Ï\u0001\u001a\u00030\u009d\u0001H\u0002J\n\u0010Ð\u0001\u001a\u00030\u009d\u0001H\u0002J\n\u0010Ñ\u0001\u001a\u00030\u009d\u0001H\u0002J\b\u0010Ò\u0001\u001a\u00030\u009d\u0001J&\u0010Ó\u0001\u001a\u00030\u009d\u00012\b\u0010Ô\u0001\u001a\u00030Õ\u00012\u0007\u0010Ö\u0001\u001a\u00020\u00062\u0007\u0010×\u0001\u001a\u00020\u0006H\u0002J\u0014\u0010Ø\u0001\u001a\u00030\u009d\u00012\b\u0010Ô\u0001\u001a\u00030Õ\u0001H\u0002R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u00020LX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u000e\u0010Q\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010R\u001a\u00020SX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001a\u0010X\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\n\"\u0004\bZ\u0010\fR\u001a\u0010[\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0010\"\u0004\b]\u0010\u0012R\u001a\u0010^\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0010\"\u0004\b`\u0010\u0012R\u001a\u0010a\u001a\u00020bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001a\u0010g\u001a\u00020SX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010U\"\u0004\bi\u0010WR\u0010\u0010j\u001a\u0004\u0018\u00010kX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010l\u001a\u0004\u0018\u00010mX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010n\u001a\u00020oX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001a\u0010t\u001a\u00020uX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001a\u0010z\u001a\u00020{X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\u0010\u0010\u0080\u0001\u001a\u00030\u0081\u0001X\u0082.¢\u0006\u0002\n\u0000R \u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0010\u0010\u0088\u0001\u001a\u00030\u0089\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u008a\u0001\u001a\u00030\u008b\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010\u008c\u0001\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R \u0010\u008e\u0001\u001a\u00030\u008f\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001d\u0010\u0094\u0001\u001a\u00020SX\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010U\"\u0005\b\u0096\u0001\u0010WR\u001d\u0010\u0097\u0001\u001a\u00020SX\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010U\"\u0005\b\u0099\u0001\u0010W¨\u0006Ù\u0001"}, d2 = {"Lcom/baidu/tieba/write/write/work/WorkPublishActivity;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "Lcom/baidu/tieba/write/write/work/interf/IWorkVideoMixListener;", "Lcom/baidu/tieba/hottopicselect/HotTopicSelectModel$HotSelectCallBack;", "()V", "EDIT_INPUT_TITILE_MAX_LENGTH", "", "contentBottomLine", "Landroid/view/View;", "getContentBottomLine", "()Landroid/view/View;", "setContentBottomLine", "(Landroid/view/View;)V", "counterTitle", "Landroid/widget/TextView;", "getCounterTitle", "()Landroid/widget/TextView;", "setCounterTitle", "(Landroid/widget/TextView;)V", "curMixVideoViewHeight", "draftType", "editContent", "Landroid/widget/RelativeLayout;", "getEditContent", "()Landroid/widget/RelativeLayout;", "setEditContent", "(Landroid/widget/RelativeLayout;)V", "editModeAnimator", "Landroid/animation/ValueAnimator;", "edtTitle", "Lcom/baidu/tbadk/core/view/spanGroup/SpanGroupEditText;", "getEdtTitle", "()Lcom/baidu/tbadk/core/view/spanGroup/SpanGroupEditText;", "setEdtTitle", "(Lcom/baidu/tbadk/core/view/spanGroup/SpanGroupEditText;)V", "hasClickedTitle", "", "getHasClickedTitle", "()Z", "setHasClickedTitle", "(Z)V", "isDraftData", "isNeedCleanTag", "isTitleEditMode", "keyboardVisibility", "mAddHotpicListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mCanChangeBarNameToastListener", "mCommunityConventionView", "Lcom/baidu/tbadk/CommunityConventionView;", "mHighLightController", "Lcom/baidu/tieba/write/write/HighLightController;", "mHotModel", "Lcom/baidu/tieba/hottopicselect/HotTopicSelectModel;", "mLocationModel", "Lcom/baidu/tieba/tbadkCore/location/LocationModel;", "mNeedDeleteLast", "mOnLocationCallBack", "Lcom/baidu/tieba/tbadkCore/location/LocationModel$OnLocationCallBack;", "mOnSelectClassListener", "mOnSelectLocationListener", "mOnSelectTagListener", "mOnSelectTopicListener", "mSelectForumListener", "mShowCanNotSelectTagToastListener", "mTitleTemp", "", "mVideoListData", "Lcom/baidu/tieba/hottopicselect/HotTopicSelectGroupData;", "mVideoSelectData", "Lcom/baidu/tieba/hottopicselect/TopicListData;", "mWriteModel", "Lcom/baidu/tieba/tbadkCore/writeModel/AsyncWriteHelper;", "mWriteTitleTextWatcher", "Landroid/text/TextWatcher;", "mixVideoView", "Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;", "getMixVideoView", "()Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;", "setMixVideoView", "(Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;)V", "mixVideoViewHeight", "mixVideoViewLayout", "Landroid/view/ViewGroup;", "getMixVideoViewLayout", "()Landroid/view/ViewGroup;", "setMixVideoViewLayout", "(Landroid/view/ViewGroup;)V", "navBack", "getNavBack", "setNavBack", "navCenterText", "getNavCenterText", "setNavCenterText", "navPost", "getNavPost", "setNavPost", "navigationBar", "Lcom/baidu/tbadk/core/view/NavigationBar;", "getNavigationBar", "()Lcom/baidu/tbadk/core/view/NavigationBar;", "setNavigationBar", "(Lcom/baidu/tbadk/core/view/NavigationBar;)V", "rootView", "getRootView", "setRootView", "saveDraftDialog", "Lcom/baidu/tbadk/core/dialog/PopupDialog;", "saveDraftDialogView", "Lcom/baidu/tbadk/core/view/SaveDraftDialogView;", "selectBarView", "Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;", "getSelectBarView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;", "setSelectBarView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;)V", "selectClassView", "Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;", "getSelectClassView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;", "setSelectClassView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;)V", "selectTagView", "Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;", "getSelectTagView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;", "setSelectTagView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;)V", "selectTopicModel", "Lcom/baidu/tieba/write/write/work/topic/SelectTopicModel;", "selectTopicView", "Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;", "getSelectTopicView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;", "setSelectTopicView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;)V", "topicLayout", "Lcom/baidu/tieba/write/write/work/topic/SelectTopicLayout;", "topicToolBar", "Lcom/baidu/tieba/write/write/work/topic/view/SelectTopicToolBar;", "topicToolLayout", "topicToolShadow", "viewModel", "Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "getViewModel", "()Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "setViewModel", "(Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;)V", "workPublishBg", "getWorkPublishBg", "setWorkPublishBg", "workPublishContainer", "getWorkPublishContainer", "setWorkPublishContainer", "checkTitleSpanLength", "lenght", "clearDraft", "", "doPost", "findAndTransPlainTextVideoHotpic", "end", "getFormData", "getTopicData", "getWriteData", "goToSelectLocationActivity", "initNav", "initSelectTopicModel", "initUI", "isVideoHotpic", "content", "loadData", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, "onHotSelectDataNoSearchFailed", "errormsg", "onHotSelectDataNoSearchSuccess", "user", "bang", "video", "onHotSelectDataSearchFailed", "onHotSelectDataSearchSuccess", "sug", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyboardVisibilityChanged", "isVisible", "onLocViewClickedInInitState", "onMixFail", "onMixStateChanged", "status", "onMixSuccess", "videoInfo", "Lcom/baidu/tbadk/coreExtra/data/VideoInfo;", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "onTitleEditModeChange", "openSelectTopicLayout", "fromEdit", "popupSaveDraftDialog", "prepareIntent", "processSaveDraft", "showLocPermissionDialog", "stopTask", "tryOpenSelectTopicLayout", "s", "", "start", "count", "updateTitleLimit", "write_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class WorkPublishActivity extends BaseFragmentActivity implements iza, HotTopicSelectModel.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ValueAnimator A;
    public u45 B;
    public SaveDraftDialogView C;
    public LocationModel D;
    public CommunityConventionView E;
    public pda F;
    public int G;
    public boolean H;
    public boolean I;
    public final pua J;
    public String K;
    public o98 L;
    public l98 M;
    public boolean N;
    @JvmField
    public final int O;
    public SelectTopicModel P;
    public HotTopicSelectModel Q;
    public final CustomMessageListener R;
    public final CustomMessageListener S;

    /* renamed from: T  reason: collision with root package name */
    public final CustomMessageListener f1185T;
    public final CustomMessageListener U;
    public final CustomMessageListener V;
    public final CustomMessageListener W;
    public final CustomMessageListener X;
    public final CustomMessageListener Y;
    public final LocationModel.c Z;
    public WorkPublishViewModel a;
    public final TextWatcher a0;
    public ViewGroup b;
    public SpanGroupEditText c;
    public RelativeLayout d;
    public ViewGroup e;
    public WorkPublishMixVideoView f;
    public TextView g;
    public SelectBarView h;
    public SelectClassView i;
    public SelectTopicView j;
    public SelectTagView k;
    public ViewGroup l;
    public ViewGroup m;
    public View n;
    public NavigationBar o;
    public View p;
    public TextView q;
    public TextView r;
    public SelectTopicLayout s;
    public View t;
    public View u;
    public SelectTopicToolBar v;
    public boolean w;
    public boolean x;
    public int y;
    public int z;

    /* loaded from: classes8.dex */
    public static final class a implements SelectTopicModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishActivity a;

        public a(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishActivity;
        }

        @Override // com.baidu.tieba.write.write.work.topic.SelectTopicModel.b
        public void a(List<o98> topicList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, topicList) == null) {
                Intrinsics.checkNotNullParameter(topicList, "topicList");
                SelectTopicToolBar selectTopicToolBar = this.a.v;
                if (selectTopicToolBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
                    selectTopicToolBar = null;
                }
                selectTopicToolBar.e(topicList);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(WorkPublishActivity workPublishActivity) {
            super(2921633);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if ((responsedMessage.getData() instanceof o98) && this.a.O1() != null) {
                    int selectionStart = this.a.O1().getSelectionStart();
                    int i = 0;
                    if (this.a.N && selectionStart > 0) {
                        int i2 = selectionStart - 1;
                        if (String.valueOf(this.a.O1().getText()).charAt(i2) == '#') {
                            this.a.O1().getEditableText().delete(i2, selectionStart);
                            this.a.N = false;
                        }
                    }
                    Object data = responsedMessage.getData();
                    if (data != null) {
                        o98 o98Var = (o98) data;
                        if (o98Var.j()) {
                            SpanGroupEditText O1 = this.a.O1();
                            String e = o98Var.e();
                            if (!o98Var.g()) {
                                i = -1;
                            }
                            O1.d(e, i, o98Var.f());
                        } else {
                            Editable editableText = this.a.O1().getEditableText();
                            if (!o98Var.g()) {
                                i = this.a.O1().getSelectionStart();
                            }
                            editableText.insert(i, '#' + o98Var.e() + '#');
                        }
                        SelectTopicLayout selectTopicLayout = this.a.s;
                        if (selectTopicLayout == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                            selectTopicLayout = null;
                        }
                        selectTopicLayout.h();
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.hottopicselect.TopicListData");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(WorkPublishActivity workPublishActivity) {
            super(2921621);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getData() instanceof Boolean) {
                    Object data = responsedMessage.getData();
                    if (data != null) {
                        if (((Boolean) data).booleanValue()) {
                            new BdTopToast(this.a.getBaseContext()).setIcon(false).setContent(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03c5)).show(this.a.V1());
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d implements LocationModel.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishActivity a;

        public d(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.c
        public void a(LocationData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (StringUtils.isNull(data.getFormatted_address())) {
                    WorkPublishActivity workPublishActivity = this.a;
                    workPublishActivity.showToast(workPublishActivity.getString(R.string.location_fail));
                    return;
                }
                this.a.g2();
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.c
        public void onFail(String errorMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, errorMsg) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                WorkPublishActivity workPublishActivity = this.a;
                if (StringUtils.isNull(errorMsg)) {
                    errorMsg = this.a.getString(R.string.location_fail);
                }
                workPublishActivity.showToast(errorMsg);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(WorkPublishActivity workPublishActivity) {
            super(2921601);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getData() instanceof VideoCategoryClassData) {
                    Object data = responsedMessage.getData();
                    if (data != null) {
                        this.a.I = true;
                        this.a.d2().k().setValue((VideoCategoryClassData) data);
                        this.a.d2().a();
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.data.VideoCategoryClassData");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(WorkPublishActivity workPublishActivity) {
            super(2001226);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (!(responsedMessage instanceof ResponsedSelectLocation)) {
                    return;
                }
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) responsedMessage;
                LocationModel locationModel = null;
                if (responsedSelectLocation.isShowLocation()) {
                    LocationModel locationModel2 = this.a.D;
                    if (locationModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                        locationModel2 = null;
                    }
                    locationModel2.V(false);
                    LocationModel locationModel3 = this.a.D;
                    if (locationModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                    } else {
                        locationModel = locationModel3;
                    }
                    locationModel.U(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                } else {
                    LocationModel locationModel4 = this.a.D;
                    if (locationModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                    } else {
                        locationModel = locationModel4;
                    }
                    locationModel.V(true);
                }
                this.a.d2().m().setValue(responsedMessage);
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(WorkPublishActivity workPublishActivity) {
            super(2921604);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getData() instanceof ArrayList) {
                    Object data = responsedMessage.getData();
                    if (data != null) {
                        this.a.d2().n().setValue((ArrayList) data);
                        this.a.d2().a();
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(WorkPublishActivity workPublishActivity) {
            super(2921602);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            ArrayList<String> arrayList;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                Object data = responsedMessage.getData();
                if (data instanceof ArrayList) {
                    arrayList = (ArrayList) data;
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    this.a.d2().p().setValue(arrayList);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class i extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(WorkPublishActivity workPublishActivity) {
            super(2921505);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (!(responsedMessage.getData() instanceof SelectForumData)) {
                    return;
                }
                Object data = responsedMessage.getData();
                if (data != null) {
                    this.a.d2().j().setValue((SelectForumData) data);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.data.SelectForumData");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class j extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(WorkPublishActivity workPublishActivity) {
            super(2921605);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getData() instanceof Boolean) {
                    Object data = responsedMessage.getData();
                    if (data != null) {
                        if (((Boolean) data).booleanValue()) {
                            new BdTopToast(this.a.getBaseContext()).setIcon(false).setContent(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f03c8)).show(this.a.V1());
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class k implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ WorkPublishActivity b;

        public k(WorkPublishActivity workPublishActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {workPublishActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = workPublishActivity;
            this.a = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s) == null) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (this.b.O1() != null && this.b.O1().getText() != null) {
                    if (this.b.K != null && Intrinsics.areEqual(this.b.K, s.toString())) {
                        this.b.O1().setSelection(this.b.O1().getSelectionEnd());
                        return;
                    }
                    WorkPublishActivity workPublishActivity = this.b;
                    workPublishActivity.K = String.valueOf(workPublishActivity.O1().getText());
                    this.b.K1(0);
                    if (this.b.J != null) {
                        this.b.J.g(this.b.O1());
                    }
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s, i, i2, i3) == null) {
                Intrinsics.checkNotNullParameter(s, "s");
                String obj = s.toString();
                if (obj == null) {
                    obj = "";
                }
                this.a = obj;
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, s, i, i2, i3) == null) {
                Intrinsics.checkNotNullParameter(s, "s");
                String str = this.a;
                int i5 = 0;
                if (str != null) {
                    i4 = str.length();
                } else {
                    i4 = 0;
                }
                String obj = s.toString();
                if (obj != null) {
                    i5 = obj.length();
                }
                if (i5 > i4) {
                    this.b.Z2(s, i, i3);
                }
                this.b.a3(s);
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
        this.I = true;
        this.J = new pua();
        this.K = "";
        this.O = 80;
        this.R = new i(this);
        this.S = new b(this);
        this.f1185T = new e(this);
        this.U = new g(this);
        this.V = new j(this);
        this.W = new c(this);
        this.X = new h(this);
        this.Y = new f(this);
        this.Z = new d(this);
        this.a0 = new k(this);
    }

    public final void B2() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SelectTopicLayout selectTopicLayout = this.s;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            if (!selectTopicLayout.q() && !this.x) {
                z = false;
            } else {
                z = true;
            }
            if (this.y == 0) {
                int height = Q1().getHeight();
                this.y = height;
                this.z = height;
            }
            if (z == this.w) {
                return;
            }
            this.w = z;
            ValueAnimator valueAnimator = this.A;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (this.w) {
                this.A = ValueAnimator.ofInt(this.z, 0);
            } else {
                this.A = ValueAnimator.ofInt(this.z, this.y);
            }
            ValueAnimator valueAnimator2 = this.A;
            if (valueAnimator2 != null) {
                valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.uya
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator3) == null) {
                            WorkPublishActivity.C2(WorkPublishActivity.this, valueAnimator3);
                        }
                    }
                });
            }
            ValueAnimator valueAnimator3 = this.A;
            if (valueAnimator3 != null) {
                valueAnimator3.start();
            }
        }
    }

    public final void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            String stringExtra = getIntent().getStringExtra("topic");
            long j2 = JavaTypesHelper.toLong(getIntent().getStringExtra("topicId"), 0L);
            boolean z = false;
            if (JavaTypesHelper.toInt(getIntent().getStringExtra("is_video_topic"), 0) == 1) {
                z = true;
            }
            final o98 o98Var = new o98(stringExtra, j2, z);
            if (this.H) {
                o98Var.l(true);
                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.kya
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            WorkPublishActivity.c2(o98.this);
                        }
                    }
                }, 300L);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921633, o98Var));
        }
    }

    public final void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            SelectForumData selectForumData = new SelectForumData();
            d2().o().setValue(getIntent().getStringExtra("video_title"));
            d2().l().setValue(getIntent().getStringExtra(AlbumFloatActivityConfig.VIDEO_ABSTRACT));
            X1().setMCanChangeBarName(getIntent().getBooleanExtra(AlbumFloatActivityConfig.CAN_CHANGE_BAR_NAME, true));
            selectForumData.forumId = getIntent().getStringExtra("bar_id");
            selectForumData.forumName = getIntent().getStringExtra("bar_name");
            d2().j().setValue(selectForumData);
        }
    }

    public final void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            SelectTopicModel selectTopicModel = new SelectTopicModel(getPageContext());
            this.P = selectTopicModel;
            HotTopicSelectModel hotTopicSelectModel = null;
            if (selectTopicModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectTopicModel");
                selectTopicModel = null;
            }
            selectTopicModel.S(new a(this));
            HotTopicSelectModel hotTopicSelectModel2 = new HotTopicSelectModel(getPageContext(), this);
            this.Q = hotTopicSelectModel2;
            if (hotTopicSelectModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
                hotTopicSelectModel2 = null;
            }
            hotTopicSelectModel2.W(getIntent());
            HotTopicSelectModel hotTopicSelectModel3 = this.Q;
            if (hotTopicSelectModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
                hotTopicSelectModel3 = null;
            }
            hotTopicSelectModel3.d0(true);
            HotTopicSelectModel hotTopicSelectModel4 = this.Q;
            if (hotTopicSelectModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
                hotTopicSelectModel4 = null;
            }
            hotTopicSelectModel4.Z();
            SelectTopicLayout selectTopicLayout = this.s;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            HotTopicSelectModel hotTopicSelectModel5 = this.Q;
            if (hotTopicSelectModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
                hotTopicSelectModel5 = null;
            }
            selectTopicLayout.setHotTopicModel(hotTopicSelectModel5);
            HotTopicSelectModel hotTopicSelectModel6 = this.Q;
            if (hotTopicSelectModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
                hotTopicSelectModel6 = null;
            }
            hotTopicSelectModel6.S();
            HotTopicSelectModel hotTopicSelectModel7 = this.Q;
            if (hotTopicSelectModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
            } else {
                hotTopicSelectModel = hotTopicSelectModel7;
            }
            hotTopicSelectModel.a0();
        }
    }

    public static final void o2(WorkPublishActivity this$0, ArrayList it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, this$0, it) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SelectTagView Z1 = this$0.Z1();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Z1.a(it);
            this$0.Y1().setMIsSelectedTags(!it.isEmpty());
        }
    }

    public static final void p2(WorkPublishActivity this$0, ArrayList it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, this$0, it) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SelectTopicView a2 = this$0.a2();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            a2.a(it);
        }
    }

    public static final void q2(WorkPublishActivity this$0, VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65552, null, this$0, videoInfo) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (videoInfo != null) {
                this$0.Q1().setVideoInfo(videoInfo, false);
            }
        }
    }

    public static final void s2(WorkPublishActivity this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            BdUtilHelper.showSoftKeyPad(TbadkCoreApplication.getInst(), this$0.O1());
        }
    }

    public static final void y2(WorkPublishActivity this$0, SelectForumData selectForumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, null, this$0, selectForumData) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.X1().a(selectForumData);
        }
    }

    public static final void C2(WorkPublishActivity this$0, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, this$0, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                this$0.z = ((Integer) animatedValue).intValue();
                this$0.R1().getLayoutParams().height = this$0.z;
                this$0.R1().setPadding(0, this$0.z - this$0.y, 0, 0);
                this$0.R1().requestLayout();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final void w2(WorkPublishActivity this$0, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, this$0, bool) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (Intrinsics.areEqual(this$0.d2().r().getValue(), Boolean.FALSE)) {
                this$0.U1().setAlpha(0.33f);
                this$0.U1().setEnabled(true);
                return;
            }
            this$0.U1().setAlpha(1.0f);
            this$0.U1().setEnabled(true);
        }
    }

    public static final void x2(WorkPublishActivity this$0, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, this$0, str) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (str != null && !str.equals(String.valueOf(this$0.O1().getText()))) {
                this$0.O1().setText(str);
                Editable text = this$0.O1().getText();
                if (text != null) {
                    this$0.O1().setSelection(text.length());
                }
            }
        }
    }

    public static /* synthetic */ void E2(WorkPublishActivity workPublishActivity, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        workPublishActivity.D2(z);
    }

    public static final void G2(WorkPublishActivity this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            u45 u45Var = this$0.B;
            Intrinsics.checkNotNull(u45Var);
            u45Var.dismiss();
            int id = view2.getId();
            if (view2.getTag(R.id.obfuscated_res_0x7f091244) instanceof Boolean) {
                Object tag = view2.getTag(R.id.obfuscated_res_0x7f091244);
                if (tag != null) {
                    boolean booleanValue = ((Boolean) tag).booleanValue();
                    if (id == R.id.save_draft_dialog_not_save) {
                        if (booleanValue) {
                            TiebaStatic.log(new StatisticItem("c14260").param("obj_locate", 2));
                            this$0.I1();
                        }
                        this$0.setResult(100);
                        this$0.finish();
                        return;
                    } else if (id == R.id.save_draft_dialog_save) {
                        if (booleanValue) {
                            TiebaStatic.log(new StatisticItem("c14260").param("obj_locate", 1));
                            this$0.I2();
                            this$0.setResult(100);
                            this$0.finish();
                            return;
                        }
                        return;
                    } else if (id == R.id.save_draft_dialog_cancle && booleanValue) {
                        TiebaStatic.log(new StatisticItem("c14260").param("obj_locate", 0));
                        return;
                    } else {
                        return;
                    }
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
        }
    }

    public static final void c2(o98 toplist) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, toplist) == null) {
            Intrinsics.checkNotNullParameter(toplist, "$toplist");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921633, toplist));
        }
    }

    public static final void v2(WorkPublishActivity this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65561, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            E2(this$0, false, 1, null);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void G0(l98 l98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, l98Var) == null) {
            SelectTopicLayout selectTopicLayout = this.s;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.u(l98Var);
        }
    }

    public final void J2(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.g = textView;
        }
    }

    public final void K2(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, relativeLayout) == null) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.d = relativeLayout;
        }
    }

    public final void L2(SpanGroupEditText spanGroupEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, spanGroupEditText) == null) {
            Intrinsics.checkNotNullParameter(spanGroupEditText, "<set-?>");
            this.c = spanGroupEditText;
        }
    }

    public final void M2(WorkPublishMixVideoView workPublishMixVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, workPublishMixVideoView) == null) {
            Intrinsics.checkNotNullParameter(workPublishMixVideoView, "<set-?>");
            this.f = workPublishMixVideoView;
        }
    }

    public final void N2(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, viewGroup) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.e = viewGroup;
        }
    }

    public final void O2(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.r = textView;
        }
    }

    public final void P2(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.q = textView;
        }
    }

    public final void Q2(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, viewGroup) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.b = viewGroup;
        }
    }

    public final void R2(SelectBarView selectBarView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, selectBarView) == null) {
            Intrinsics.checkNotNullParameter(selectBarView, "<set-?>");
            this.h = selectBarView;
        }
    }

    public final void S2(SelectClassView selectClassView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, selectClassView) == null) {
            Intrinsics.checkNotNullParameter(selectClassView, "<set-?>");
            this.i = selectClassView;
        }
    }

    public final void T2(SelectTagView selectTagView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, selectTagView) == null) {
            Intrinsics.checkNotNullParameter(selectTagView, "<set-?>");
            this.k = selectTagView;
        }
    }

    public final void U2(SelectTopicView selectTopicView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, selectTopicView) == null) {
            Intrinsics.checkNotNullParameter(selectTopicView, "<set-?>");
            this.j = selectTopicView;
        }
    }

    public final void V2(WorkPublishViewModel workPublishViewModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, workPublishViewModel) == null) {
            Intrinsics.checkNotNullParameter(workPublishViewModel, "<set-?>");
            this.a = workPublishViewModel;
        }
    }

    public final void W2(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, viewGroup) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.l = viewGroup;
        }
    }

    public final void X2(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, viewGroup) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.m = viewGroup;
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void b1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            SelectTopicLayout selectTopicLayout = this.s;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.t(str);
        }
    }

    @Override // com.baidu.tieba.iza
    public void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048629, this, i2) == null) {
            d2().z(i2);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void l1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            SelectTopicLayout selectTopicLayout = this.s;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.r(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048637, this, z) == null) {
            this.x = z;
            B2();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Serializable serializable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, intent) == null) {
            super.onNewIntent(intent);
            if (intent != null) {
                serializable = intent.getSerializableExtra(WorkPublishActivityConfig.PARAM_VIDEO_INFO);
            } else {
                serializable = null;
            }
            if (serializable instanceof VideoInfo) {
                d2().B((VideoInfo) serializable);
            }
        }
    }

    @Override // com.baidu.tieba.iza
    public void r1(VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048640, this, videoInfo) == null) {
            Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
            d2().B(videoInfo);
        }
    }

    public final void setContentBottomLine(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "<set-?>");
            this.n = view2;
        }
    }

    public final void setNavBack(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048642, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "<set-?>");
            this.p = view2;
        }
    }

    public final void setNavigationBar(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, navigationBar) == null) {
            Intrinsics.checkNotNullParameter(navigationBar, "<set-?>");
            this.o = navigationBar;
        }
    }

    public static final void i2(WorkPublishActivity this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SelectTopicLayout selectTopicLayout = this$0.s;
            SelectTopicLayout selectTopicLayout2 = null;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            if (selectTopicLayout.q()) {
                SelectTopicLayout selectTopicLayout3 = this$0.s;
                if (selectTopicLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                } else {
                    selectTopicLayout2 = selectTopicLayout3;
                }
                selectTopicLayout2.i();
                return;
            }
            this$0.F2();
        }
    }

    public static final void k2(WorkPublishActivity this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SelectTopicLayout selectTopicLayout = this$0.s;
            SelectTopicLayout selectTopicLayout2 = null;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            if (selectTopicLayout.q()) {
                SelectTopicLayout selectTopicLayout3 = this$0.s;
                if (selectTopicLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                } else {
                    selectTopicLayout2 = selectTopicLayout3;
                }
                selectTopicLayout2.i();
            }
        }
    }

    public static final void r2(WorkPublishActivity this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_COMMUNITY_CONVENTION_CLICK).addParam("obj_locate", "2").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
            UrlManager.getInstance().dealOneLink(this$0.getPageContext(), new String[]{TbConfig.COMMUNITY_CONVENTION});
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048636, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                SelectTopicLayout selectTopicLayout = this.s;
                SelectTopicLayout selectTopicLayout2 = null;
                if (selectTopicLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                    selectTopicLayout = null;
                }
                if (selectTopicLayout.q()) {
                    SelectTopicLayout selectTopicLayout3 = this.s;
                    if (selectTopicLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                    } else {
                        selectTopicLayout2 = selectTopicLayout3;
                    }
                    selectTopicLayout2.i();
                    return true;
                }
                F2();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public static final void j2(WorkPublishActivity this$0, View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SelectTopicLayout selectTopicLayout = this$0.s;
            SelectTopicLayout selectTopicLayout2 = null;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            if (selectTopicLayout.q()) {
                SelectTopicLayout selectTopicLayout3 = this$0.s;
                if (selectTopicLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                } else {
                    selectTopicLayout2 = selectTopicLayout3;
                }
                selectTopicLayout2.i();
                return;
            }
            boolean z2 = true;
            if (this$0.U1().getAlpha() == 1.0f) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this$0.J1();
                o98 o98Var = this$0.L;
                if (o98Var != null && o98Var.j()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_WORK_VIDEO_HAS_TOPIC);
                    Long d2 = o98Var.d();
                    Intrinsics.checkNotNullExpressionValue(d2, "it.topicId");
                    statisticItem.param("topic_id", d2.longValue());
                    statisticItem.param("is_video_topic", "1");
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            if (this$0.U1().getAlpha() != 0.33f) {
                z2 = false;
            }
            if (z2) {
                if (this$0.G1(String.valueOf(this$0.O1().getText()).length()) < 5) {
                    new BdTopToast(this$0).setIcon(false).setContent(this$0.getString(R.string.obfuscated_res_0x7f0f18a8)).show(this$0.W1());
                }
                if (this$0.G1(String.valueOf(this$0.O1().getText()).length()) > this$0.O) {
                    new BdTopToast(this$0).setIcon(false).setContent(this$0.getString(R.string.obfuscated_res_0x7f0f18a7)).show(this$0.W1());
                }
            }
        }
    }

    public static final void n2(WorkPublishActivity this$0, VideoCategoryClassData videoCategoryClassData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, this$0, videoCategoryClassData) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Y1().a(videoCategoryClassData);
            if (!Intrinsics.areEqual(this$0.Z1().getFirstClass(), videoCategoryClassData.getFirstClass()) || !Intrinsics.areEqual(this$0.Z1().getSecondClass(), videoCategoryClassData.getSecondClass())) {
                SelectTagView Z1 = this$0.Z1();
                String firstClass = videoCategoryClassData.getFirstClass();
                Intrinsics.checkNotNullExpressionValue(firstClass, "it.firstClass");
                String secondClass = videoCategoryClassData.getSecondClass();
                Intrinsics.checkNotNullExpressionValue(secondClass, "it.secondClass");
                Z1.setClassData(firstClass, secondClass);
                if (this$0.I) {
                    this$0.d2().n().setValue(new ArrayList<>());
                }
            }
        }
    }

    public static final void t2(WorkPublishActivity this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int height = this$0.V1().getHeight() + BdUtilHelper.getDimens(this$0, R.dimen.tbds254);
            SelectTopicLayout selectTopicLayout = this$0.s;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.setTitlePlaceholderHeight(height);
        }
    }

    public static final void u2(WorkPublishActivity this$0, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65559, null, new Object[]{this$0, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.B2();
            if (!z && z2) {
                this$0.O1().setFocusable(true);
                this$0.O1().setFocusableInTouchMode(true);
                this$0.O1().requestFocus();
            }
        }
    }

    public final void A2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            SelectTopicModel selectTopicModel = this.P;
            if (selectTopicModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectTopicModel");
                selectTopicModel = null;
            }
            selectTopicModel.Q();
        }
    }

    public final void I1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d2().g();
        }
    }

    public final void I2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            d2().w();
        }
    }

    public final View L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            View view2 = this.n;
            if (view2 != null) {
                return view2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("contentBottomLine");
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final TextView M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            TextView textView = this.g;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("counterTitle");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final RelativeLayout N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null) {
                return relativeLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("editContent");
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final SpanGroupEditText O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.c;
            if (spanGroupEditText != null) {
                return spanGroupEditText;
            }
            Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            return null;
        }
        return (SpanGroupEditText) invokeV.objValue;
    }

    public final WorkPublishMixVideoView Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            WorkPublishMixVideoView workPublishMixVideoView = this.f;
            if (workPublishMixVideoView != null) {
                return workPublishMixVideoView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mixVideoView");
            return null;
        }
        return (WorkPublishMixVideoView) invokeV.objValue;
    }

    public final ViewGroup R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            ViewGroup viewGroup = this.e;
            if (viewGroup != null) {
                return viewGroup;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mixVideoViewLayout");
            return null;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final View S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            View view2 = this.p;
            if (view2 != null) {
                return view2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("navBack");
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final TextView T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            TextView textView = this.r;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("navCenterText");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            TextView textView = this.q;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("navPost");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final NavigationBar V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            NavigationBar navigationBar = this.o;
            if (navigationBar != null) {
                return navigationBar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public final ViewGroup W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            ViewGroup viewGroup = this.b;
            if (viewGroup != null) {
                return viewGroup;
            }
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            return null;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final SelectBarView X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            SelectBarView selectBarView = this.h;
            if (selectBarView != null) {
                return selectBarView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("selectBarView");
            return null;
        }
        return (SelectBarView) invokeV.objValue;
    }

    public final SelectClassView Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            SelectClassView selectClassView = this.i;
            if (selectClassView != null) {
                return selectClassView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("selectClassView");
            return null;
        }
        return (SelectClassView) invokeV.objValue;
    }

    public final SelectTagView Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            SelectTagView selectTagView = this.k;
            if (selectTagView != null) {
                return selectTagView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("selectTagView");
            return null;
        }
        return (SelectTagView) invokeV.objValue;
    }

    public final SelectTopicView a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            SelectTopicView selectTopicView = this.j;
            if (selectTopicView != null) {
                return selectTopicView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("selectTopicView");
            return null;
        }
        return (SelectTopicView) invokeV.objValue;
    }

    public final WorkPublishViewModel d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            WorkPublishViewModel workPublishViewModel = this.a;
            if (workPublishViewModel != null) {
                return workPublishViewModel;
            }
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            return null;
        }
        return (WorkPublishViewModel) invokeV.objValue;
    }

    public final ViewGroup e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            ViewGroup viewGroup = this.l;
            if (viewGroup != null) {
                return viewGroup;
            }
            Intrinsics.throwUninitializedPropertyAccessException("workPublishBg");
            return null;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final void g2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            super.onDestroy();
            ValueAnimator valueAnimator = this.A;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            u45 u45Var = this.B;
            if (u45Var != null) {
                u45Var.dismiss();
            }
            this.B = null;
            Y2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048639, this) == null) {
            super.onResume();
            pda pdaVar = this.F;
            if (pdaVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                pdaVar = null;
            }
            pdaVar.p(getPageContext());
        }
    }

    public final void D2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            if (O1().isFocused()) {
                O1().setFocusable(false);
                O1().setFocusableInTouchMode(true);
                Object systemService = getSystemService("input_method");
                if (systemService != null) {
                    HidenSoftKeyPad((InputMethodManager) systemService, O1());
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                }
            }
            SelectTopicLayout selectTopicLayout = this.s;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.w();
            this.N = z;
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WORK_VIDEO_TOPIC_LAYOUT_SHOW));
        }
    }

    public final int G1(int i2) {
        InterceptResult invokeI;
        Integer num;
        SpanGroupManager spanGroupManager;
        List<va5> I;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            SpanGroupEditText O1 = O1();
            if (O1 != null && (spanGroupManager = O1.getSpanGroupManager()) != null && (I = spanGroupManager.I()) != null) {
                num = Integer.valueOf(I.size());
            } else {
                num = null;
            }
            Intrinsics.checkNotNull(num);
            if (num.intValue() > 0) {
                String u = O1().getSpanGroupManager().I().get(0).u();
                if (i2 >= u.length()) {
                    return (i2 - u.length()) + 1;
                }
                return i2;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public final void F2() {
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.C == null) {
                this.C = new SaveDraftDialogView(this);
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.yya
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            WorkPublishActivity.G2(WorkPublishActivity.this, view2);
                        }
                    }
                };
                SaveDraftDialogView saveDraftDialogView = this.C;
                Intrinsics.checkNotNull(saveDraftDialogView);
                saveDraftDialogView.setOnClickListener(onClickListener);
            }
            if (this.B == null) {
                u45 u45Var = new u45(getPageContext());
                this.B = u45Var;
                Intrinsics.checkNotNull(u45Var);
                u45Var.setContentView(this.C);
            }
            boolean f2 = d2().f();
            SaveDraftDialogView saveDraftDialogView2 = this.C;
            Intrinsics.checkNotNull(saveDraftDialogView2);
            saveDraftDialogView2.setButtonTag(R.id.obfuscated_res_0x7f091244, Boolean.valueOf(f2));
            SaveDraftDialogView saveDraftDialogView3 = this.C;
            Intrinsics.checkNotNull(saveDraftDialogView3);
            if (f2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            saveDraftDialogView3.setCancelVisible(i2);
            SaveDraftDialogView saveDraftDialogView4 = this.C;
            Intrinsics.checkNotNull(saveDraftDialogView4);
            if (f2) {
                i3 = R.string.write_save_draft_dialog_normal_title;
            } else {
                i3 = R.string.write_save_draft_failed_unfinish_zip_title;
            }
            String string = getString(i3);
            if (f2) {
                i4 = R.string.obfuscated_res_0x7f0f12cc;
            } else {
                i4 = R.string.write_save_draft_stay;
            }
            String string2 = getString(i4);
            if (f2) {
                i5 = R.string.not_save;
            } else {
                i5 = R.string.write_save_draft_leave;
            }
            saveDraftDialogView4.setText(string, string2, getString(i5));
            u45 u45Var2 = this.B;
            Intrinsics.checkNotNull(u45Var2);
            u45Var2.l();
        }
    }

    public final void H2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int intExtra = getIntent().getIntExtra(WorkPublishActivityConfig.PARAM_SHOW_DRAFT, 0);
            this.G = intExtra;
            if (intExtra == WorkPublishOpenHelper.Companion.a()) {
                this.H = true;
                d2().s();
                P1();
            } else if (this.G == WorkPublishOpenHelper.Companion.b()) {
                Serializable serializableExtra = getIntent().getSerializableExtra(WorkPublishActivityConfig.PARAM_WRITE_DATA);
                if (serializableExtra instanceof WriteData) {
                    WriteData writeData = (WriteData) serializableExtra;
                    d2().v(writeData);
                    this.H = writeData.isWorkDraft();
                    this.I = false;
                }
            } else {
                this.H = false;
                Serializable serializableExtra2 = getIntent().getSerializableExtra(WorkPublishActivityConfig.PARAM_VIDEO_INFO);
                if (serializableExtra2 instanceof VideoInfo) {
                    d2().B((VideoInfo) serializableExtra2);
                }
                f2();
            }
            if (!TextUtils.isEmpty(getIntent().getStringExtra("topic"))) {
                b2();
            }
            if (!getIntent().getBooleanExtra(WorkPublishActivityConfig.VIDEO_MIXING, true)) {
                Q1().i(2, 100);
            }
            if (getIntent().getBooleanExtra(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921583));
            }
        }
    }

    public final void J1() {
        String str;
        String str2;
        boolean z;
        String str3;
        String str4;
        boolean z2;
        Iterator<String> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002016, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("name", "VideoWorkListPage"))));
            WriteData writeData = new WriteData();
            writeData.setVideoInfo(d2().q().getValue());
            String value = d2().o().getValue();
            if (d2().p().getValue() != null) {
                ArrayList<String> value2 = d2().p().getValue();
                Intrinsics.checkNotNull(value2);
                while (value2.iterator().hasNext()) {
                    value = value + '#' + it.next() + '#';
                }
            }
            writeData.setTitle(value);
            writeData.setContent(d2().l().getValue());
            SelectForumData value3 = d2().j().getValue();
            pda pdaVar = null;
            if (value3 != null) {
                str = value3.forumId;
            } else {
                str = null;
            }
            writeData.setForumId(str);
            SelectForumData value4 = d2().j().getValue();
            if (value4 != null) {
                str2 = value4.forumName;
            } else {
                str2 = null;
            }
            writeData.setForumName(str2);
            if (d2().m().getValue() != null && !qca.a().c()) {
                z = true;
            } else {
                z = false;
            }
            writeData.setHasLocationData(z);
            writeData.setWork(true);
            writeData.setWorkDraft(this.H);
            VideoCategoryClassData videoCategoryClassData = new VideoCategoryClassData();
            VideoCategoryClassData value5 = d2().k().getValue();
            if (value5 != null) {
                str3 = value5.getFirstClass();
            } else {
                str3 = null;
            }
            videoCategoryClassData.setFirstClass(str3);
            VideoCategoryClassData value6 = d2().k().getValue();
            if (value6 != null) {
                str4 = value6.getSecondClass();
            } else {
                str4 = null;
            }
            videoCategoryClassData.setSecondClass(str4);
            if (d2().n().getValue() != null) {
                videoCategoryClassData.setTags(d2().n().getValue());
            }
            writeData.setClassAndTagData(videoCategoryClassData);
            String objLocate = WorkPublishManager.getObjLocate();
            if (objLocate != null && objLocate.length() != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                String objLocate2 = WorkPublishManager.getObjLocate();
                Intrinsics.checkNotNullExpressionValue(objLocate2, "getObjLocate()");
                writeData.setStatisticFrom(Integer.parseInt(objLocate2));
            }
            boolean booleanExtra = getIntent().getBooleanExtra(WorkPublishActivityConfig.NEED_PUBLISH_END_JUMP_HOME, false);
            pda pdaVar2 = this.F;
            if (pdaVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                pdaVar2 = null;
            }
            pdaVar2.y(writeData);
            pda pdaVar3 = this.F;
            if (pdaVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                pdaVar3 = null;
            }
            pdaVar3.x(booleanExtra);
            pda pdaVar4 = this.F;
            if (pdaVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
            } else {
                pdaVar = pdaVar4;
            }
            pdaVar.z();
            if (booleanExtra) {
                MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2);
                if (UbsABTestHelper.isConcernForumCardShow() && TbadkCoreApplication.isLogin() && SharedPrefHelper.getInstance().getInt("key_home_concern_all_status", 0) == 1) {
                    createNormalCfg.setSubTabName(getString(R.string.attention_person));
                } else {
                    createNormalCfg.setSubTabName(getString(R.string.tab_name_concern));
                }
                createNormalCfg.start();
            } else if (WriteMsgHolder.getCurrentWriteActivityFromTag() == null) {
                if (!WriteMsgHolder.isFromPersonCenter() && !WriteMsgHolder.isFromVideoHotTopic()) {
                    VideoWorkListActivityConfig videoWorkListActivityConfig = new VideoWorkListActivityConfig(this);
                    videoWorkListActivityConfig.addType("1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoWorkListActivityConfig));
                } else {
                    WorkPostBackToPersonCenterFlutterData workPostBackToPersonCenterFlutterData = new WorkPostBackToPersonCenterFlutterData();
                    workPostBackToPersonCenterFlutterData.isShowProgressBar = true;
                    workPostBackToPersonCenterFlutterData.pageId = WriteMsgHolder.getFlutterPageId();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921625, workPostBackToPersonCenterFlutterData));
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921622, Boolean.TRUE));
            }
            setResult(100);
            finish();
        }
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            h2();
            View findViewById = findViewById(16908290);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
            Q2((ViewGroup) findViewById);
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f092886);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.videoViewLayout)");
            N2((ViewGroup) findViewById2);
            View findViewById3 = findViewById(R.id.obfuscated_res_0x7f092885);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.videoView)");
            M2((WorkPublishMixVideoView) findViewById3);
            WorkPublishMixVideoView Q1 = Q1();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            Q1.setPageContext(pageContext);
            Q1().setIWorkVideoMixListener(this);
            View findViewById4 = findViewById(R.id.obfuscated_res_0x7f092a40);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.work_publish_edtTitle)");
            L2((SpanGroupEditText) findViewById4);
            O1().setTransLink(false);
            O1().setTransAt(false);
            View findViewById5 = findViewById(R.id.obfuscated_res_0x7f090973);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.edit_content)");
            K2((RelativeLayout) findViewById5);
            View findViewById6 = findViewById(R.id.obfuscated_res_0x7f092a3d);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.work_publish_bg)");
            W2((ViewGroup) findViewById6);
            View findViewById7 = findViewById(R.id.obfuscated_res_0x7f092a3f);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.work_publish_container)");
            X2((ViewGroup) findViewById7);
            View findViewById8 = findViewById(R.id.obfuscated_res_0x7f092144);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.select_bar_view)");
            R2((SelectBarView) findViewById8);
            View findViewById9 = findViewById(R.id.obfuscated_res_0x7f092147);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.select_class_view)");
            S2((SelectClassView) findViewById9);
            View findViewById10 = findViewById(R.id.obfuscated_res_0x7f092165);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.select_topic_view)");
            U2((SelectTopicView) findViewById10);
            if (WorkAddTopicSwitch.isOn()) {
                a2().setVisibility(0);
            } else {
                a2().setVisibility(8);
            }
            View findViewById11 = findViewById(R.id.obfuscated_res_0x7f09215f);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.select_tag_view)");
            T2((SelectTagView) findViewById11);
            N1().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.xya
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        WorkPublishActivity.s2(WorkPublishActivity.this, view2);
                    }
                }
            });
            View findViewById12 = findViewById(R.id.obfuscated_res_0x7f09216d);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.sep_line_content)");
            setContentBottomLine(findViewById12);
            View findViewById13 = findViewById(R.id.obfuscated_res_0x7f092a42);
            Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(R.id.work_publish_title_counter)");
            J2((TextView) findViewById13);
            View findViewById14 = findViewById(R.id.obfuscated_res_0x7f092160);
            Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(R.id.select_topic_layout)");
            this.s = (SelectTopicLayout) findViewById14;
            V1().post(new Runnable() { // from class: com.baidu.tieba.wya
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        WorkPublishActivity.t2(WorkPublishActivity.this);
                    }
                }
            });
            SelectTopicLayout selectTopicLayout = this.s;
            CommunityConventionView communityConventionView = null;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.setStateListener(new SelectTopicLayout.f() { // from class: com.baidu.tieba.rya
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.write.write.work.topic.SelectTopicLayout.f
                public final void a(boolean z, boolean z2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                        WorkPublishActivity.u2(WorkPublishActivity.this, z, z2);
                    }
                }
            });
            View findViewById15 = findViewById(R.id.obfuscated_res_0x7f092673);
            Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(R.id.topic_tool_layout)");
            this.t = findViewById15;
            View findViewById16 = findViewById(R.id.obfuscated_res_0x7f092674);
            Intrinsics.checkNotNullExpressionValue(findViewById16, "findViewById(R.id.topic_tool_shadow)");
            this.u = findViewById16;
            View findViewById17 = findViewById(R.id.obfuscated_res_0x7f092672);
            Intrinsics.checkNotNullExpressionValue(findViewById17, "findViewById(R.id.topic_tool_bar)");
            SelectTopicToolBar selectTopicToolBar = (SelectTopicToolBar) findViewById17;
            this.v = selectTopicToolBar;
            if (selectTopicToolBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
                selectTopicToolBar = null;
            }
            selectTopicToolBar.setmFromType(1);
            SelectTopicToolBar selectTopicToolBar2 = this.v;
            if (selectTopicToolBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
                selectTopicToolBar2 = null;
            }
            selectTopicToolBar2.setOpenTopicLayoutListener(new SelectTopicToolBar.e() { // from class: com.baidu.tieba.vya
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.write.write.work.topic.view.SelectTopicToolBar.e
                public final void onOpen() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        WorkPublishActivity.v2(WorkPublishActivity.this);
                    }
                }
            });
            O1().addTextChangedListener(this.a0);
            d2().r().observe(this, new Observer() { // from class: com.baidu.tieba.qya
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.w2(WorkPublishActivity.this, (Boolean) obj);
                    }
                }
            });
            d2().o().observe(this, new Observer() { // from class: com.baidu.tieba.tya
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.x2(WorkPublishActivity.this, (String) obj);
                    }
                }
            });
            d2().j().observe(this, new Observer() { // from class: com.baidu.tieba.aza
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.y2(WorkPublishActivity.this, (SelectForumData) obj);
                    }
                }
            });
            d2().k().observe(this, new Observer() { // from class: com.baidu.tieba.mya
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.n2(WorkPublishActivity.this, (VideoCategoryClassData) obj);
                    }
                }
            });
            d2().n().observe(this, new Observer() { // from class: com.baidu.tieba.nya
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.o2(WorkPublishActivity.this, (ArrayList) obj);
                    }
                }
            });
            d2().p().observe(this, new Observer() { // from class: com.baidu.tieba.zya
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.p2(WorkPublishActivity.this, (ArrayList) obj);
                    }
                }
            });
            d2().q().observe(this, new Observer() { // from class: com.baidu.tieba.bza
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.q2(WorkPublishActivity.this, (VideoInfo) obj);
                    }
                }
            });
            View findViewById18 = findViewById(R.id.obfuscated_res_0x7f090786);
            Intrinsics.checkNotNullExpressionValue(findViewById18, "findViewById(R.id.community_convention)");
            CommunityConventionView communityConventionView2 = (CommunityConventionView) findViewById18;
            this.E = communityConventionView2;
            if (communityConventionView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommunityConventionView");
            } else {
                communityConventionView = communityConventionView2;
            }
            communityConventionView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.oya
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        WorkPublishActivity.r2(WorkPublishActivity.this, view2);
                    }
                }
            });
        }
    }

    public final synchronized void K1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            synchronized (this) {
                if (O1() == null) {
                    return;
                }
                Editable editableText = O1().getEditableText();
                Intrinsics.checkNotNullExpressionValue(editableText, "edtTitle.editableText");
                Matcher matcher = TbPatternsCompat.PLAIN_TEXT_VIDEO_HOTPIC_NAME.matcher(editableText);
                SelectTopicLayout selectTopicLayout = null;
                if (i2 < editableText.length() && matcher.find(i2)) {
                    int start = matcher.start();
                    int end = matcher.end();
                    o98 z2 = z2(matcher.group(1).toString());
                    if (z2 != null && z2.j()) {
                        if (ov5.g(editableText, start)) {
                            Object[] spans = editableText.getSpans(start, end + 1, Object.class);
                            Intrinsics.checkNotNullExpressionValue(spans, "text.getSpans(plainTextA…Pos + 1, Any::class.java)");
                            for (Object obj : spans) {
                                if (obj instanceof EMRichTextAnyIconSpan) {
                                    editableText.removeSpan(obj);
                                }
                            }
                            O1().getSpanGroupManager().delete(start, end, true);
                        } else if (!O1().getSpanGroupManager().P(start, end)) {
                            O1().getSpanGroupManager().i(z2.e(), start);
                            this.L = z2;
                            SelectTopicToolBar selectTopicToolBar = this.v;
                            if (selectTopicToolBar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
                                selectTopicToolBar = null;
                            }
                            Long d2 = z2.d();
                            Intrinsics.checkNotNullExpressionValue(d2, "resultData.topicId");
                            selectTopicToolBar.setSelectTopicId(d2.longValue());
                            SelectTopicLayout selectTopicLayout2 = this.s;
                            if (selectTopicLayout2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                                selectTopicLayout2 = null;
                            }
                            Long d3 = z2.d();
                            Intrinsics.checkNotNullExpressionValue(d3, "resultData.topicId");
                            selectTopicLayout2.setSelectTopicId(d3.longValue());
                        }
                    }
                    K1(end);
                }
                if (O1().getSpanGroupManager().I().size() == 0) {
                    this.L = null;
                    SelectTopicToolBar selectTopicToolBar2 = this.v;
                    if (selectTopicToolBar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
                        selectTopicToolBar2 = null;
                    }
                    selectTopicToolBar2.setSelectTopicId(-1L);
                    SelectTopicLayout selectTopicLayout3 = this.s;
                    if (selectTopicLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                    } else {
                        selectTopicLayout = selectTopicLayout3;
                    }
                    selectTopicLayout.setSelectTopicId(-1L);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0060);
            setSwipeBackEnabled(false);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            ViewModel viewModel = new ViewModelProvider(this).get(WorkPublishViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…ishViewModel::class.java)");
            V2((WorkPublishViewModel) viewModel);
            LocationModel locationModel = new LocationModel(getPageContext());
            this.D = locationModel;
            pda pdaVar = null;
            if (locationModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                locationModel = null;
            }
            locationModel.W(this.Z);
            pda k2 = pda.k();
            Intrinsics.checkNotNullExpressionValue(k2, "getInstance()");
            this.F = k2;
            if (k2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
            } else {
                pdaVar = k2;
            }
            pdaVar.m(this);
            m2();
            l2();
            registerListener(this.R);
            registerListener(this.S);
            registerListener(this.f1185T);
            registerListener(this.X);
            registerListener(this.Y);
            registerListener(this.U);
            registerListener(this.V);
            registerListener(this.W);
            H2();
            A2();
            if (d2().q().getValue() != null && !this.H) {
                StatisticItem statisticItem = new StatisticItem("c14311");
                VideoInfo value = d2().q().getValue();
                Intrinsics.checkNotNull(value);
                TiebaStatic.log(statisticItem.param("obj_source", value.getVideoSource()));
            } else {
                TiebaStatic.log(new StatisticItem("c14311").param("obj_source", 0));
            }
            yua.a(3);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void O0(l98 l98Var, l98 l98Var2, l98 l98Var3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, l98Var, l98Var2, l98Var3) == null) {
            if (this.M == null) {
                this.M = l98Var3;
                K1(0);
            } else {
                this.M = l98Var3;
            }
            SelectTopicLayout selectTopicLayout = this.s;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.s(l98Var, l98Var2, l98Var3);
        }
    }

    public final void Z2(CharSequence charSequence, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048619, this, charSequence, i2, i3) == null) && i3 == 1 && i2 < charSequence.length() && i2 >= 0 && ov5.f(String.valueOf(charSequence.charAt(i2)))) {
            D2(true);
        }
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            SelectForumData selectForumData = new SelectForumData();
            X1().setMCanChangeBarName(getIntent().getBooleanExtra(WorkPublishActivityConfig.CAN_CHANGE_SELECT_BAR, true));
            selectForumData.forumId = getIntent().getStringExtra("bar_id");
            selectForumData.forumName = getIntent().getStringExtra("bar_name");
            d2().x(getIntent().getBooleanExtra(WorkPublishActivityConfig.CAN_CHANGE_SELECT_BAR, true));
            d2().y(selectForumData);
        }
    }

    public final void Y2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            pda pdaVar = this.F;
            HotTopicSelectModel hotTopicSelectModel = null;
            if (pdaVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                pdaVar = null;
            }
            pdaVar.o(getPageContext());
            LocationModel locationModel = this.D;
            if (locationModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                locationModel = null;
            }
            locationModel.cancelLoadData();
            WorkPublishMixVideoView Q1 = Q1();
            if (Q1 != null) {
                Q1.h();
            }
            HotTopicSelectModel hotTopicSelectModel2 = this.Q;
            if (hotTopicSelectModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
            } else {
                hotTopicSelectModel = hotTopicSelectModel2;
            }
            hotTopicSelectModel.onDestroy();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('(' char), (r0v3 int), (wrap: char : ?: SGET   com.google.android.exoplayer2.text.webvtt.WebvttCueParser.CHAR_SLASH char), (wrap: int : 0x0026: IGET  (r3v3 int A[REMOVE]) = (r4v0 'this' com.baidu.tieba.write.write.work.WorkPublishActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.write.write.work.WorkPublishActivity.O int), (')' char)] */
    public final void a3(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, charSequence) == null) {
            String obj = charSequence.toString();
            int G1 = G1(obj.length());
            TextView M1 = M1();
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(G1);
            sb.append(WebvttCueParser.CHAR_SLASH);
            sb.append(this.O);
            sb.append(')');
            M1.setText(sb.toString());
            if (G1 > this.O) {
                M1().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
            } else {
                M1().setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
            d2().A(obj, G1);
        }
    }

    public final o98 z2(String content) {
        InterceptResult invokeL;
        l98 l98Var;
        List<o98> list;
        List<o98> list2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, content)) == null) {
            Intrinsics.checkNotNullParameter(content, "content");
            if (!TextUtils.isEmpty(content) && (l98Var = this.M) != null) {
                if (l98Var != null) {
                    list = l98Var.c();
                } else {
                    list = null;
                }
                if (!ListUtils.isEmpty(list)) {
                    l98 l98Var2 = this.M;
                    if (l98Var2 != null) {
                        list2 = l98Var2.c();
                    } else {
                        list2 = null;
                    }
                    if (list2 != null) {
                        int size = list2.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            o98 o98Var = list2.get(i2);
                            if (o98Var != null && Intrinsics.areEqual(content, o98Var.e())) {
                                return o98Var;
                            }
                        }
                        return null;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.baidu.tieba.hottopicselect.TopicListData>");
                }
            }
            return null;
        }
        return (o98) invokeL.objValue;
    }

    public final void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            View findViewById = findViewById(R.id.view_navigation_bar);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.view_navigation_bar)");
            setNavigationBar((NavigationBar) findViewById);
            V1().showBottomLine();
            View addSystemImageButton = V1().addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            Intrinsics.checkNotNullExpressionValue(addSystemImageButton, "navigationBar.addSystemI…ype.BACK_BUTTON\n        )");
            setNavBack(addSystemImageButton);
            S1().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.sya
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        WorkPublishActivity.i2(WorkPublishActivity.this, view2);
                    }
                }
            });
            TextView addTextButton = V1().addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.home_publish));
            Intrinsics.checkNotNullExpressionValue(addTextButton, "navigationBar.addTextBut…g.home_publish)\n        )");
            P2(addTextButton);
            U1().getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds130);
            U1().getLayoutParams().height = UtilHelper.getDimenPixelSize(R.dimen.tbds75);
            ViewGroup.LayoutParams layoutParams = U1().getLayoutParams();
            if (layoutParams != null) {
                ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
                EMManager.from(U1()).setTextSize(R.dimen.T_X08);
                U1().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lya
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            WorkPublishActivity.j2(WorkPublishActivity.this, view2);
                        }
                    }
                });
                TextView centerTextTitle = V1().setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f189f));
                Intrinsics.checkNotNullExpressionValue(centerTextTitle, "navigationBar.setCenterT…g(R.string.work_publish))");
                O2(centerTextTitle);
                ViewGroup.LayoutParams layoutParams2 = T1().getLayoutParams();
                if (layoutParams2 != null) {
                    ((LinearLayout.LayoutParams) layoutParams2).leftMargin = 0;
                    ViewGroup.LayoutParams layoutParams3 = T1().getLayoutParams();
                    if (layoutParams3 != null) {
                        ((LinearLayout.LayoutParams) layoutParams3).rightMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds30);
                        V1().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pya
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                    WorkPublishActivity.k2(WorkPublishActivity.this, view2);
                                }
                            }
                        });
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048633, this, i2) == null) {
            EMManager.from(e2()).setBackGroundColor(R.color.CAM_X0201);
            V1().onChangeSkinType(getPageContext(), i2);
            V1().getBackImageView().setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_close40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            EMManager.from(U1()).setTextColor(R.color.CAM_X0101).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0302);
            if (Intrinsics.areEqual(d2().r().getValue(), Boolean.FALSE)) {
                U1().setAlpha(0.33f);
                U1().setEnabled(false);
            } else {
                U1().setAlpha(1.0f);
                U1().setEnabled(true);
            }
            T1().setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            X1().d();
            Y1().d();
            a2().e();
            Z1().e();
            SelectTopicToolBar selectTopicToolBar = this.v;
            View view2 = null;
            if (selectTopicToolBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
                selectTopicToolBar = null;
            }
            selectTopicToolBar.g();
            O1().setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            M1().setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            O1().setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            SkinManager.setBackgroundColor(L1(), R.color.CAM_X0210);
            Q1().g();
            View view3 = this.u;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolShadow");
                view3 = null;
            }
            EMManager.from(view3).setGradientColor(new int[]{R.color.CAM_X0802, R.color.CAM_X0601});
            View view4 = this.t;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolLayout");
            } else {
                view2 = view4;
            }
            EMManager.from(view2).setBackGroundColor(R.color.CAM_X0207);
        }
    }
}
