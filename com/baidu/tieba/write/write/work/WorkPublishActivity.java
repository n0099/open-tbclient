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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.frame.IntentData;
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
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
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
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.repackage.ds4;
import com.repackage.g19;
import com.repackage.ie5;
import com.repackage.l57;
import com.repackage.ms4;
import com.repackage.o57;
import com.repackage.og;
import com.repackage.pw4;
import com.repackage.qi;
import com.repackage.rg;
import com.repackage.ru4;
import com.repackage.s29;
import com.repackage.vm8;
import com.repackage.x09;
import com.repackage.yl8;
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
@Metadata(d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u009b\u0001\u001a\u00020\u00062\u0007\u0010\u009c\u0001\u001a\u00020\u0006H\u0002J\n\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0002J\b\u0010\u009f\u0001\u001a\u00030\u009e\u0001J\u0013\u0010 \u0001\u001a\u00030\u009e\u00012\u0007\u0010¡\u0001\u001a\u00020\u0006H\u0002J\n\u0010¢\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010£\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010¤\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010¥\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010¦\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010§\u0001\u001a\u00030\u009e\u0001H\u0002J\b\u0010¨\u0001\u001a\u00030\u009e\u0001J\u0012\u0010©\u0001\u001a\u0004\u0018\u00010F2\u0007\u0010ª\u0001\u001a\u00020BJ\n\u0010«\u0001\u001a\u00030\u009e\u0001H\u0002J\u0013\u0010¬\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u00ad\u0001\u001a\u00020\u0006H\u0014J\u0016\u0010®\u0001\u001a\u00030\u009e\u00012\n\u0010¯\u0001\u001a\u0005\u0018\u00010°\u0001H\u0014J\n\u0010±\u0001\u001a\u00030\u009e\u0001H\u0014J\u0015\u0010²\u0001\u001a\u00030\u009e\u00012\t\u0010³\u0001\u001a\u0004\u0018\u00010BH\u0016J+\u0010´\u0001\u001a\u00030\u009e\u00012\t\u0010µ\u0001\u001a\u0004\u0018\u00010D2\t\u0010¶\u0001\u001a\u0004\u0018\u00010D2\t\u0010·\u0001\u001a\u0004\u0018\u00010DH\u0016J\u0015\u0010¸\u0001\u001a\u00030\u009e\u00012\t\u0010³\u0001\u001a\u0004\u0018\u00010BH\u0016J\u0015\u0010¹\u0001\u001a\u00030\u009e\u00012\t\u0010º\u0001\u001a\u0004\u0018\u00010DH\u0016J\u001e\u0010»\u0001\u001a\u00020$2\u0007\u0010¼\u0001\u001a\u00020\u00062\n\u0010½\u0001\u001a\u0005\u0018\u00010¾\u0001H\u0016J\u0013\u0010¿\u0001\u001a\u00030\u009e\u00012\u0007\u0010À\u0001\u001a\u00020$H\u0014J\b\u0010Á\u0001\u001a\u00030\u009e\u0001J\n\u0010Â\u0001\u001a\u00030\u009e\u0001H\u0016J\u0013\u0010Ã\u0001\u001a\u00030\u009e\u00012\u0007\u0010Ä\u0001\u001a\u00020\u0006H\u0016J\u0016\u0010Å\u0001\u001a\u00030\u009e\u00012\n\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u0001H\u0014J\n\u0010È\u0001\u001a\u00030\u009e\u0001H\u0002J\u0015\u0010É\u0001\u001a\u00030\u009e\u00012\t\b\u0002\u0010Ê\u0001\u001a\u00020$H\u0002J\b\u0010Ë\u0001\u001a\u00030\u009e\u0001J\n\u0010Ì\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010Í\u0001\u001a\u00030\u009e\u0001H\u0002J\n\u0010Î\u0001\u001a\u00030\u009e\u0001H\u0002J\b\u0010Ï\u0001\u001a\u00030\u009e\u0001J&\u0010Ð\u0001\u001a\u00030\u009e\u00012\b\u0010Ñ\u0001\u001a\u00030Ò\u00012\u0007\u0010Ó\u0001\u001a\u00020\u00062\u0007\u0010Ô\u0001\u001a\u00020\u0006H\u0002J\u0014\u0010Õ\u0001\u001a\u00030\u009e\u00012\b\u0010Ñ\u0001\u001a\u00030Ò\u0001H\u0002R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u00020LX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u000e\u0010Q\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010R\u001a\u00020SX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u000e\u0010X\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010Y\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\n\"\u0004\b[\u0010\fR\u001a\u0010\\\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u0010\"\u0004\b^\u0010\u0012R\u001a\u0010_\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0010\"\u0004\ba\u0010\u0012R\u001a\u0010b\u001a\u00020cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001a\u0010h\u001a\u00020SX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010U\"\u0004\bj\u0010WR\u0010\u0010k\u001a\u0004\u0018\u00010lX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u0004\u0018\u00010nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010o\u001a\u00020pX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001a\u0010u\u001a\u00020vX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u001b\u0010{\u001a\u00020|X\u0086.¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u0010\u0010\u0081\u0001\u001a\u00030\u0082\u0001X\u0082.¢\u0006\u0002\n\u0000R \u0010\u0083\u0001\u001a\u00030\u0084\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0010\u0010\u0089\u0001\u001a\u00030\u008a\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u008b\u0001\u001a\u00030\u008c\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010\u008d\u0001\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0001\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R \u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001d\u0010\u0095\u0001\u001a\u00020SX\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010U\"\u0005\b\u0097\u0001\u0010WR\u001d\u0010\u0098\u0001\u001a\u00020SX\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010U\"\u0005\b\u009a\u0001\u0010W¨\u0006Ö\u0001"}, d2 = {"Lcom/baidu/tieba/write/write/work/WorkPublishActivity;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "Lcom/baidu/tieba/write/write/work/interf/IWorkVideoMixListener;", "Lcom/baidu/tieba/hottopicselect/HotTopicSelectModel$HotSelectCallBack;", "()V", "EDIT_INPUT_TITILE_MAX_LENGTH", "", "contentBottomLine", "Landroid/view/View;", "getContentBottomLine", "()Landroid/view/View;", "setContentBottomLine", "(Landroid/view/View;)V", "counterTitle", "Landroid/widget/TextView;", "getCounterTitle", "()Landroid/widget/TextView;", "setCounterTitle", "(Landroid/widget/TextView;)V", "curMixVideoViewHeight", "draftType", "editContent", "Landroid/widget/RelativeLayout;", "getEditContent", "()Landroid/widget/RelativeLayout;", "setEditContent", "(Landroid/widget/RelativeLayout;)V", "editModeAnimator", "Landroid/animation/ValueAnimator;", "edtTitle", "Lcom/baidu/tbadk/core/view/spanGroup/SpanGroupEditText;", "getEdtTitle", "()Lcom/baidu/tbadk/core/view/spanGroup/SpanGroupEditText;", "setEdtTitle", "(Lcom/baidu/tbadk/core/view/spanGroup/SpanGroupEditText;)V", "hasClickedTitle", "", "getHasClickedTitle", "()Z", "setHasClickedTitle", "(Z)V", "isDraftData", "isNeedCleanTag", "isTitleEditMode", "keyboardVisibility", "mAddHotpicListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mCanChangeBarNameToastListener", "mCommunityConventionView", "Lcom/baidu/tbadk/CommunityConventionView;", "mHighLightController", "Lcom/baidu/tieba/write/write/HighLightController;", "mHotModel", "Lcom/baidu/tieba/hottopicselect/HotTopicSelectModel;", "mLocationModel", "Lcom/baidu/tieba/tbadkCore/location/LocationModel;", "mNeedDeleteLast", "mOnLocationCallBack", "Lcom/baidu/tieba/tbadkCore/location/LocationModel$OnLocationCallBack;", "mOnSelectClassListener", "mOnSelectLocationListener", "mOnSelectTagListener", "mOnSelectTopicListener", "mSelectForumListener", "mShowCanNotSelectTagToastListener", "mTitleTemp", "", "mVideoListData", "Lcom/baidu/tieba/hottopicselect/HotTopicSelectGroupData;", "mVideoSelectData", "Lcom/baidu/tieba/hottopicselect/TopicListData;", "mWriteModel", "Lcom/baidu/tieba/tbadkCore/writeModel/AsyncWriteHelper;", "mWriteTitleTextWatcher", "Landroid/text/TextWatcher;", "mixVideoView", "Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;", "getMixVideoView", "()Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;", "setMixVideoView", "(Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;)V", "mixVideoViewHeight", "mixVideoViewLayout", "Landroid/view/ViewGroup;", "getMixVideoViewLayout", "()Landroid/view/ViewGroup;", "setMixVideoViewLayout", "(Landroid/view/ViewGroup;)V", "muxerSuccListener", "navBack", "getNavBack", "setNavBack", "navCenterText", "getNavCenterText", "setNavCenterText", "navPost", "getNavPost", "setNavPost", "navigationBar", "Lcom/baidu/tbadk/core/view/NavigationBar;", "getNavigationBar", "()Lcom/baidu/tbadk/core/view/NavigationBar;", "setNavigationBar", "(Lcom/baidu/tbadk/core/view/NavigationBar;)V", "rootView", "getRootView", "setRootView", "saveDraftDialog", "Lcom/baidu/tbadk/core/dialog/PopupDialog;", "saveDraftDialogView", "Lcom/baidu/tbadk/core/view/SaveDraftDialogView;", "selectBarView", "Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;", "getSelectBarView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;", "setSelectBarView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;)V", "selectClassView", "Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;", "getSelectClassView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;", "setSelectClassView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;)V", "selectTagView", "Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;", "getSelectTagView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;", "setSelectTagView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;)V", "selectTopicModel", "Lcom/baidu/tieba/write/write/work/topic/SelectTopicModel;", "selectTopicView", "Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;", "getSelectTopicView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;", "setSelectTopicView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;)V", "topicLayout", "Lcom/baidu/tieba/write/write/work/topic/SelectTopicLayout;", "topicToolBar", "Lcom/baidu/tieba/write/write/work/topic/view/SelectTopicToolBar;", "topicToolLayout", "topicToolShadow", "viewModel", "Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "getViewModel", "()Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "setViewModel", "(Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;)V", "workPublishBg", "getWorkPublishBg", "setWorkPublishBg", "workPublishContainer", "getWorkPublishContainer", "setWorkPublishContainer", "checkTitleSpanLength", "lenght", "clearDraft", "", "doPost", "findAndTransPlainTextVideoHotpic", "end", "getFormData", "getTopicData", "getWriteData", "goToSelectLocationActivity", "initNav", "initSelectTopicModel", "initUI", "isVideoHotpic", "content", "loadData", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, "onHotSelectDataNoSearchFailed", "errormsg", "onHotSelectDataNoSearchSuccess", "user", "bang", "video", "onHotSelectDataSearchFailed", "onHotSelectDataSearchSuccess", "sug", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyboardVisibilityChanged", "isVisible", "onLocViewClickedInInitState", "onMixFail", "onMixStateChanged", "status", "onNewIntent", IntentData.KEY, "Landroid/content/Intent;", "onTitleEditModeChange", "openSelectTopicLayout", "fromEdit", "popupSaveDraftDialog", "prepareIntent", "processSaveDraft", "showLocPermissionDialog", "stopTask", "tryOpenSelectTopicLayout", "s", "", "start", "count", "updateTitleLimit", "write_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class WorkPublishActivity extends BaseFragmentActivity implements s29, HotTopicSelectModel.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ValueAnimator A;
    public ds4 B;
    public SaveDraftDialogView C;
    public LocationModel D;
    public CommunityConventionView E;
    public vm8 F;
    public int G;
    public boolean H;
    public boolean I;
    public final x09 J;
    public String K;
    public o57 L;
    public l57 M;
    public boolean N;
    @JvmField
    public final int O;
    public SelectTopicModel P;
    public HotTopicSelectModel Q;
    public final CustomMessageListener R;
    public final CustomMessageListener S;
    public final CustomMessageListener T;
    public final CustomMessageListener U;
    public final CustomMessageListener V;
    public final CustomMessageListener W;
    public final CustomMessageListener X;
    public final CustomMessageListener Y;
    public final CustomMessageListener Z;
    public WorkPublishViewModel a;
    public final LocationModel.e a0;
    public ViewGroup b;
    public final TextWatcher b0;
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

    /* loaded from: classes4.dex */
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
        public void a(List<o57> topicList) {
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

    /* loaded from: classes4.dex */
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
        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('#' char), (wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.String : 0x00a5: INVOKE  (r6v4 java.lang.String A[REMOVE]) = (r6v3 com.repackage.o57) type: VIRTUAL call: com.repackage.o57.e():java.lang.String)), ('#' char)] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (!(responsedMessage.getData() instanceof o57) || this.a.f1() == null) {
                    return;
                }
                int selectionStart = this.a.f1().getSelectionStart();
                if (this.a.N && selectionStart > 0) {
                    int i = selectionStart - 1;
                    if (String.valueOf(this.a.f1().getText()).charAt(i) == '#') {
                        this.a.f1().getEditableText().delete(i, selectionStart);
                        this.a.N = false;
                    }
                }
                Object data = responsedMessage.getData();
                if (data != null) {
                    o57 o57Var = (o57) data;
                    if (o57Var.j()) {
                        this.a.f1().d(o57Var.e(), o57Var.g() ? 0 : -1, o57Var.f());
                    } else {
                        Editable editableText = this.a.f1().getEditableText();
                        int selectionStart2 = o57Var.g() ? 0 : this.a.f1().getSelectionStart();
                        StringBuilder sb = new StringBuilder();
                        sb.append('#');
                        sb.append((Object) o57Var.e());
                        sb.append('#');
                        editableText.insert(selectionStart2, sb.toString());
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

    /* loaded from: classes4.dex */
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
                    if (data == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    if (((Boolean) data).booleanValue()) {
                        BdTopToast bdTopToast = new BdTopToast(this.a.getBaseContext());
                        bdTopToast.h(false);
                        bdTopToast.g(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0368));
                        bdTopToast.i(this.a.n1());
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class d implements LocationModel.e {
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

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c76);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (!StringUtils.isNull(data.getFormatted_address())) {
                    this.a.z1();
                    return;
                }
                WorkPublishActivity workPublishActivity = this.a;
                workPublishActivity.showToast(workPublishActivity.getString(R.string.obfuscated_res_0x7f0f0a51));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String errorMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, errorMsg) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                WorkPublishActivity workPublishActivity = this.a;
                if (StringUtils.isNull(errorMsg)) {
                    errorMsg = this.a.getString(R.string.obfuscated_res_0x7f0f0a51);
                }
                workPublishActivity.showToast(errorMsg);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                        this.a.v1().h().setValue((VideoCategoryClassData) data);
                        this.a.v1().a();
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.data.VideoCategoryClassData");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (responsedMessage instanceof ResponsedSelectLocation) {
                    ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) responsedMessage;
                    LocationModel locationModel = null;
                    if (responsedSelectLocation.isShowLocation()) {
                        LocationModel locationModel2 = this.a.D;
                        if (locationModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                            locationModel2 = null;
                        }
                        locationModel2.P(false);
                        LocationModel locationModel3 = this.a.D;
                        if (locationModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                        } else {
                            locationModel = locationModel3;
                        }
                        locationModel.O(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    } else {
                        LocationModel locationModel4 = this.a.D;
                        if (locationModel4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                        } else {
                            locationModel = locationModel4;
                        }
                        locationModel.P(true);
                    }
                    this.a.v1().j().setValue(responsedMessage);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                        this.a.v1().k().setValue((ArrayList) data);
                        this.a.v1().a();
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (responsedMessage.getData() instanceof ArrayList) {
                    Object data = responsedMessage.getData();
                    if (data != null) {
                        this.a.v1().m().setValue((ArrayList) data);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (responsedMessage.getData() instanceof SelectForumData) {
                    Object data = responsedMessage.getData();
                    if (data != null) {
                        this.a.v1().g().setValue((SelectForumData) data);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.data.SelectForumData");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                    if (data == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    if (((Boolean) data).booleanValue()) {
                        BdTopToast bdTopToast = new BdTopToast(this.a.getBaseContext());
                        bdTopToast.h(false);
                        bdTopToast.g(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f036a));
                        bdTopToast.i(this.a.n1());
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                if (this.b.f1() == null || this.b.f1().getText() == null) {
                    return;
                }
                if (this.b.K != null && Intrinsics.areEqual(this.b.K, s.toString())) {
                    this.b.f1().setSelection(this.b.f1().getSelectionEnd());
                    return;
                }
                WorkPublishActivity workPublishActivity = this.b;
                workPublishActivity.K = String.valueOf(workPublishActivity.f1().getText());
                this.b.a1(0);
                if (this.b.J != null) {
                    this.b.J.g(this.b.f1());
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, s, i, i2, i3) == null) {
                Intrinsics.checkNotNullParameter(s, "s");
                String str = this.a;
                int length = str != null ? str.length() : 0;
                String obj = s.toString();
                if ((obj != null ? obj.length() : 0) > length) {
                    this.b.s2(s, i, i3);
                }
                this.b.t2(s);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class l extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WorkPublishActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(WorkPublishActivity workPublishActivity) {
            super(2921593);
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
                if (responsedMessage.getData() instanceof VideoInfo) {
                    Object data = responsedMessage.getData();
                    if (data != null) {
                        this.a.v1().y((VideoInfo) data);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.coreExtra.data.VideoInfo");
                }
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
        this.J = new x09();
        this.K = "";
        this.O = 80;
        this.R = new l(this);
        this.S = new i(this);
        this.T = new b(this);
        this.U = new e(this);
        this.V = new g(this);
        this.W = new j(this);
        this.X = new c(this);
        this.Y = new h(this);
        this.Z = new f(this);
        this.a0 = new d(this);
        this.b0 = new k(this);
    }

    public static final void B1(WorkPublishActivity this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
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
            this$0.Y1();
        }
    }

    public static final void C1(WorkPublishActivity this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, this$0, view2) == null) {
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
            if (this$0.m1().getAlpha() == 1.0f) {
                this$0.Z0();
                o57 o57Var = this$0.L;
                if (o57Var != null && o57Var.j()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_WORK_VIDEO_HAS_TOPIC);
                    Long d2 = o57Var.d();
                    Intrinsics.checkNotNullExpressionValue(d2, "it.topicId");
                    statisticItem.param("topic_id", d2.longValue());
                    statisticItem.param("is_video_topic", "1");
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            if (this$0.m1().getAlpha() == 0.33f) {
                if (this$0.V0(String.valueOf(this$0.f1().getText()).length()) < 5) {
                    BdTopToast bdTopToast = new BdTopToast(this$0);
                    bdTopToast.h(false);
                    bdTopToast.g(this$0.getString(R.string.obfuscated_res_0x7f0f15bf));
                    bdTopToast.i(this$0.o1());
                }
                if (this$0.V0(String.valueOf(this$0.f1().getText()).length()) > this$0.O) {
                    BdTopToast bdTopToast2 = new BdTopToast(this$0);
                    bdTopToast2.h(false);
                    bdTopToast2.g(this$0.getString(R.string.obfuscated_res_0x7f0f15be));
                    bdTopToast2.i(this$0.o1());
                }
            }
        }
    }

    public static final void D1(WorkPublishActivity this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, this$0, view2) == null) {
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

    public static final void G1(WorkPublishActivity this$0, VideoCategoryClassData videoCategoryClassData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, this$0, videoCategoryClassData) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.q1().a(videoCategoryClassData);
            if (Intrinsics.areEqual(this$0.r1().getFirstClass(), videoCategoryClassData.getFirstClass()) && Intrinsics.areEqual(this$0.r1().getSecondClass(), videoCategoryClassData.getSecondClass())) {
                return;
            }
            SelectTagView r1 = this$0.r1();
            String firstClass = videoCategoryClassData.getFirstClass();
            Intrinsics.checkNotNullExpressionValue(firstClass, "it.firstClass");
            String secondClass = videoCategoryClassData.getSecondClass();
            Intrinsics.checkNotNullExpressionValue(secondClass, "it.secondClass");
            r1.setClassData(firstClass, secondClass);
            if (this$0.I) {
                this$0.v1().k().setValue(new ArrayList<>());
            }
        }
    }

    public static final void H1(WorkPublishActivity this$0, ArrayList it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, this$0, it) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SelectTagView r1 = this$0.r1();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            r1.a(it);
            this$0.q1().setMIsSelectedTags(!it.isEmpty());
        }
    }

    public static final void I1(WorkPublishActivity this$0, ArrayList it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, this$0, it) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SelectTopicView s1 = this$0.s1();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            s1.a(it);
        }
    }

    public static final void J1(WorkPublishActivity this$0, VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, this$0, videoInfo) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (videoInfo != null) {
                this$0.i1().setVideoInfo(videoInfo, false);
            }
        }
    }

    public static final void K1(WorkPublishActivity this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_COMMUNITY_CONVENTION_CLICK).addParam("obj_locate", "2").addParam("uid", TbadkCoreApplication.getCurrentAccount()));
            UrlManager.getInstance().dealOneLink(this$0.getPageContext(), new String[]{TbConfig.COMMUNITY_CONVENTION});
        }
    }

    public static final void L1(WorkPublishActivity this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            qi.L(TbadkCoreApplication.getInst(), this$0.f1());
        }
    }

    public static final void M1(WorkPublishActivity this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int height = this$0.n1().getHeight() + qi.f(this$0, R.dimen.tbds254);
            SelectTopicLayout selectTopicLayout = this$0.s;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.setTitlePlaceholderHeight(height);
        }
    }

    public static final void N1(WorkPublishActivity this$0, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, null, new Object[]{this$0, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.U1();
            if (z || !z2) {
                return;
            }
            this$0.f1().setFocusable(true);
            this$0.f1().setFocusableInTouchMode(true);
            this$0.f1().requestFocus();
        }
    }

    public static final void O1(WorkPublishActivity this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65557, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            X1(this$0, false, 1, null);
        }
    }

    public static final void P1(WorkPublishActivity this$0, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, this$0, bool) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (Intrinsics.areEqual(this$0.v1().o().getValue(), Boolean.FALSE)) {
                this$0.m1().setAlpha(0.33f);
                this$0.m1().setEnabled(true);
                return;
            }
            this$0.m1().setAlpha(1.0f);
            this$0.m1().setEnabled(true);
        }
    }

    public static final void Q1(WorkPublishActivity this$0, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, this$0, str) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (str == null || str.equals(String.valueOf(this$0.f1().getText()))) {
                return;
            }
            this$0.f1().setText(str);
            Editable text = this$0.f1().getText();
            if (text == null) {
                return;
            }
            this$0.f1().setSelection(text.length());
        }
    }

    public static final void R1(WorkPublishActivity this$0, SelectForumData selectForumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, this$0, selectForumData) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.p1().a(selectForumData);
        }
    }

    public static final void V1(WorkPublishActivity this$0, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, this$0, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                this$0.z = ((Integer) animatedValue).intValue();
                this$0.j1().getLayoutParams().height = this$0.z;
                this$0.j1().setPadding(0, this$0.z - this$0.y, 0, 0);
                this$0.j1().requestLayout();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static /* synthetic */ void X1(WorkPublishActivity workPublishActivity, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        workPublishActivity.W1(z);
    }

    public static final void Z1(WorkPublishActivity this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ds4 ds4Var = this$0.B;
            Intrinsics.checkNotNull(ds4Var);
            ds4Var.dismiss();
            int id = view2.getId();
            if (view2.getTag(R.id.obfuscated_res_0x7f09101b) instanceof Boolean) {
                Object tag = view2.getTag(R.id.obfuscated_res_0x7f09101b);
                if (tag == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolean booleanValue = ((Boolean) tag).booleanValue();
                if (id == R.id.obfuscated_res_0x7f091d5d) {
                    if (booleanValue) {
                        TiebaStatic.log(new StatisticItem("c14260").param("obj_locate", 2));
                        this$0.W0();
                    }
                    this$0.setResult(100);
                    this$0.finish();
                } else if (id != R.id.obfuscated_res_0x7f091d5e) {
                    if (id == R.id.obfuscated_res_0x7f091d5c && booleanValue) {
                        TiebaStatic.log(new StatisticItem("c14260").param("obj_locate", 0));
                    }
                } else if (booleanValue) {
                    TiebaStatic.log(new StatisticItem("c14260").param("obj_locate", 1));
                    this$0.b2();
                    this$0.setResult(100);
                    this$0.finish();
                }
            }
        }
    }

    public static final void u1(o57 toplist) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, toplist) == null) {
            Intrinsics.checkNotNullParameter(toplist, "$toplist");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921633, toplist));
        }
    }

    public final void A1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f09255c);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.view_navigation_bar)");
            setNavigationBar((NavigationBar) findViewById);
            n1().showBottomLine();
            View addSystemImageButton = n1().addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            Intrinsics.checkNotNullExpressionValue(addSystemImageButton, "navigationBar.addSystemI…ype.BACK_BUTTON\n        )");
            setNavBack(addSystemImageButton);
            k1().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.c29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        WorkPublishActivity.B1(WorkPublishActivity.this, view2);
                    }
                }
            });
            TextView addTextButton = n1().addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.obfuscated_res_0x7f0f085c));
            Intrinsics.checkNotNullExpressionValue(addTextButton, "navigationBar.addTextBut…g.home_publish)\n        )");
            i2(addTextButton);
            m1().getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds130);
            m1().getLayoutParams().height = UtilHelper.getDimenPixelSize(R.dimen.tbds75);
            ViewGroup.LayoutParams layoutParams = m1().getLayoutParams();
            if (layoutParams != null) {
                ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
                ms4.d(m1()).z(R.dimen.T_X08);
                m1().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.v19
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            WorkPublishActivity.C1(WorkPublishActivity.this, view2);
                        }
                    }
                });
                TextView centerTextTitle = n1().setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f15b6));
                Intrinsics.checkNotNullExpressionValue(centerTextTitle, "navigationBar.setCenterT…g(R.string.work_publish))");
                h2(centerTextTitle);
                ViewGroup.LayoutParams layoutParams2 = l1().getLayoutParams();
                if (layoutParams2 != null) {
                    ((LinearLayout.LayoutParams) layoutParams2).leftMargin = 0;
                    ViewGroup.LayoutParams layoutParams3 = l1().getLayoutParams();
                    if (layoutParams3 != null) {
                        ((LinearLayout.LayoutParams) layoutParams3).rightMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds30);
                        n1().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.z19
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                                    WorkPublishActivity.D1(WorkPublishActivity.this, view2);
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

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SelectTopicModel selectTopicModel = new SelectTopicModel(getPageContext());
            this.P = selectTopicModel;
            HotTopicSelectModel hotTopicSelectModel = null;
            if (selectTopicModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectTopicModel");
                selectTopicModel = null;
            }
            selectTopicModel.E(new a(this));
            HotTopicSelectModel hotTopicSelectModel2 = new HotTopicSelectModel(getPageContext(), this);
            this.Q = hotTopicSelectModel2;
            if (hotTopicSelectModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
                hotTopicSelectModel2 = null;
            }
            hotTopicSelectModel2.I(getIntent());
            HotTopicSelectModel hotTopicSelectModel3 = this.Q;
            if (hotTopicSelectModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
                hotTopicSelectModel3 = null;
            }
            hotTopicSelectModel3.P(true);
            HotTopicSelectModel hotTopicSelectModel4 = this.Q;
            if (hotTopicSelectModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
                hotTopicSelectModel4 = null;
            }
            hotTopicSelectModel4.L();
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
            hotTopicSelectModel6.E();
            HotTopicSelectModel hotTopicSelectModel7 = this.Q;
            if (hotTopicSelectModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
            } else {
                hotTopicSelectModel = hotTopicSelectModel7;
            }
            hotTopicSelectModel.M();
        }
    }

    public final void F1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            A1();
            View findViewById = findViewById(16908290);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
            j2((ViewGroup) findViewById);
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f092491);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.videoViewLayout)");
            g2((ViewGroup) findViewById2);
            View findViewById3 = findViewById(R.id.obfuscated_res_0x7f092490);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.videoView)");
            f2((WorkPublishMixVideoView) findViewById3);
            WorkPublishMixVideoView i1 = i1();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            i1.setPageContext(pageContext);
            i1().setIWorkVideoMixListener(this);
            View findViewById4 = findViewById(R.id.obfuscated_res_0x7f09263b);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.work_publish_edtTitle)");
            e2((SpanGroupEditText) findViewById4);
            f1().setTransLink(false);
            f1().setTransAt(false);
            View findViewById5 = findViewById(R.id.obfuscated_res_0x7f090857);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.edit_content)");
            d2((RelativeLayout) findViewById5);
            View findViewById6 = findViewById(R.id.obfuscated_res_0x7f092638);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.work_publish_bg)");
            p2((ViewGroup) findViewById6);
            View findViewById7 = findViewById(R.id.obfuscated_res_0x7f09263a);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.work_publish_container)");
            q2((ViewGroup) findViewById7);
            View findViewById8 = findViewById(R.id.obfuscated_res_0x7f091de6);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.select_bar_view)");
            k2((SelectBarView) findViewById8);
            View findViewById9 = findViewById(R.id.obfuscated_res_0x7f091de9);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.select_class_view)");
            l2((SelectClassView) findViewById9);
            View findViewById10 = findViewById(R.id.obfuscated_res_0x7f091e06);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.select_topic_view)");
            n2((SelectTopicView) findViewById10);
            if (WorkAddTopicSwitch.isOn()) {
                s1().setVisibility(0);
            } else {
                s1().setVisibility(8);
            }
            View findViewById11 = findViewById(R.id.obfuscated_res_0x7f091e00);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.select_tag_view)");
            m2((SelectTagView) findViewById11);
            d1().setOnClickListener(new View.OnClickListener() { // from class: com.repackage.h29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        WorkPublishActivity.L1(WorkPublishActivity.this, view2);
                    }
                }
            });
            View findViewById12 = findViewById(R.id.obfuscated_res_0x7f091e0c);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.sep_line_content)");
            setContentBottomLine(findViewById12);
            View findViewById13 = findViewById(R.id.obfuscated_res_0x7f09263d);
            Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(R.id.work_publish_title_counter)");
            c2((TextView) findViewById13);
            View findViewById14 = findViewById(R.id.obfuscated_res_0x7f091e01);
            Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(R.id.select_topic_layout)");
            this.s = (SelectTopicLayout) findViewById14;
            n1().post(new Runnable() { // from class: com.repackage.g29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        WorkPublishActivity.M1(WorkPublishActivity.this);
                    }
                }
            });
            SelectTopicLayout selectTopicLayout = this.s;
            CommunityConventionView communityConventionView = null;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.setStateListener(new SelectTopicLayout.f() { // from class: com.repackage.b29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.write.write.work.topic.SelectTopicLayout.f
                public final void a(boolean z, boolean z2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                        WorkPublishActivity.N1(WorkPublishActivity.this, z, z2);
                    }
                }
            });
            View findViewById15 = findViewById(R.id.obfuscated_res_0x7f0922b6);
            Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(R.id.topic_tool_layout)");
            this.t = findViewById15;
            View findViewById16 = findViewById(R.id.obfuscated_res_0x7f0922b7);
            Intrinsics.checkNotNullExpressionValue(findViewById16, "findViewById(R.id.topic_tool_shadow)");
            this.u = findViewById16;
            View findViewById17 = findViewById(R.id.obfuscated_res_0x7f0922b5);
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
            selectTopicToolBar2.setOpenTopicLayoutListener(new SelectTopicToolBar.e() { // from class: com.repackage.f29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.write.write.work.topic.view.SelectTopicToolBar.e
                public final void onOpen() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        WorkPublishActivity.O1(WorkPublishActivity.this);
                    }
                }
            });
            f1().addTextChangedListener(this.b0);
            v1().o().observe(this, new Observer() { // from class: com.repackage.a29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.P1(WorkPublishActivity.this, (Boolean) obj);
                    }
                }
            });
            v1().l().observe(this, new Observer() { // from class: com.repackage.d29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.Q1(WorkPublishActivity.this, (String) obj);
                    }
                }
            });
            v1().g().observe(this, new Observer() { // from class: com.repackage.k29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.R1(WorkPublishActivity.this, (SelectForumData) obj);
                    }
                }
            });
            v1().h().observe(this, new Observer() { // from class: com.repackage.w19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.G1(WorkPublishActivity.this, (VideoCategoryClassData) obj);
                    }
                }
            });
            v1().k().observe(this, new Observer() { // from class: com.repackage.x19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.H1(WorkPublishActivity.this, (ArrayList) obj);
                    }
                }
            });
            v1().m().observe(this, new Observer() { // from class: com.repackage.j29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.I1(WorkPublishActivity.this, (ArrayList) obj);
                    }
                }
            });
            v1().n().observe(this, new Observer() { // from class: com.repackage.l29
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.J1(WorkPublishActivity.this, (VideoInfo) obj);
                    }
                }
            });
            View findViewById18 = findViewById(R.id.obfuscated_res_0x7f09068e);
            Intrinsics.checkNotNullExpressionValue(findViewById18, "findViewById(R.id.community_convention)");
            CommunityConventionView communityConventionView2 = (CommunityConventionView) findViewById18;
            this.E = communityConventionView2;
            if (communityConventionView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCommunityConventionView");
            } else {
                communityConventionView = communityConventionView2;
            }
            communityConventionView.setOnClickListener(new View.OnClickListener() { // from class: com.repackage.y19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        WorkPublishActivity.K1(WorkPublishActivity.this, view2);
                    }
                }
            });
        }
    }

    public final o57 S1(String content) {
        InterceptResult invokeL;
        l57 l57Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, content)) == null) {
            Intrinsics.checkNotNullParameter(content, "content");
            if (!TextUtils.isEmpty(content) && (l57Var = this.M) != null) {
                if (!ListUtils.isEmpty(l57Var == null ? null : l57Var.c())) {
                    l57 l57Var2 = this.M;
                    List<o57> c2 = l57Var2 == null ? null : l57Var2.c();
                    if (c2 != null) {
                        int i2 = 0;
                        int size = c2.size() - 1;
                        if (size >= 0) {
                            while (true) {
                                int i3 = i2 + 1;
                                o57 o57Var = c2.get(i2);
                                if (o57Var != null && Intrinsics.areEqual(content, o57Var.e())) {
                                    return o57Var;
                                }
                                if (i3 > size) {
                                    break;
                                }
                                i2 = i3;
                            }
                        }
                        return null;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.baidu.tieba.hottopicselect.TopicListData>");
                }
            }
            return null;
        }
        return (o57) invokeL.objValue;
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            SelectTopicModel selectTopicModel = this.P;
            if (selectTopicModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectTopicModel");
                selectTopicModel = null;
            }
            selectTopicModel.C();
        }
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            SelectTopicLayout selectTopicLayout = this.s;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            boolean z = selectTopicLayout.q() || this.x;
            if (this.y == 0) {
                int height = i1().getHeight();
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
                valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.repackage.e29
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator3) == null) {
                            WorkPublishActivity.V1(WorkPublishActivity.this, valueAnimator3);
                        }
                    }
                });
            }
            ValueAnimator valueAnimator3 = this.A;
            if (valueAnimator3 == null) {
                return;
            }
            valueAnimator3.start();
        }
    }

    public final int V0(int i2) {
        InterceptResult invokeI;
        SpanGroupManager spanGroupManager;
        List<pw4> I;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            SpanGroupEditText f1 = f1();
            Integer num = null;
            if (f1 != null && (spanGroupManager = f1.getSpanGroupManager()) != null && (I = spanGroupManager.I()) != null) {
                num = Integer.valueOf(I.size());
            }
            Intrinsics.checkNotNull(num);
            if (num.intValue() > 0) {
                String u = f1().getSpanGroupManager().I().get(0).u();
                return i2 >= u.length() ? (i2 - u.length()) + 1 : i2;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    public final void W0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            v1().e();
        }
    }

    public final void W1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (f1().isFocused()) {
                f1().setFocusable(false);
                f1().setFocusableInTouchMode(true);
                Object systemService = getSystemService("input_method");
                if (systemService != null) {
                    HidenSoftKeyPad((InputMethodManager) systemService, f1());
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

    public final void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.C == null) {
                this.C = new SaveDraftDialogView(this);
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.repackage.i29
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            WorkPublishActivity.Z1(WorkPublishActivity.this, view2);
                        }
                    }
                };
                SaveDraftDialogView saveDraftDialogView = this.C;
                Intrinsics.checkNotNull(saveDraftDialogView);
                saveDraftDialogView.setOnClickListener(onClickListener);
            }
            if (this.B == null) {
                ds4 ds4Var = new ds4(getPageContext());
                this.B = ds4Var;
                Intrinsics.checkNotNull(ds4Var);
                ds4Var.setContentView(this.C);
            }
            boolean d2 = v1().d();
            SaveDraftDialogView saveDraftDialogView2 = this.C;
            Intrinsics.checkNotNull(saveDraftDialogView2);
            saveDraftDialogView2.setButtonTag(R.id.obfuscated_res_0x7f09101b, Boolean.valueOf(d2));
            SaveDraftDialogView saveDraftDialogView3 = this.C;
            Intrinsics.checkNotNull(saveDraftDialogView3);
            saveDraftDialogView3.setCancelVisible(d2 ? 0 : 8);
            SaveDraftDialogView saveDraftDialogView4 = this.C;
            Intrinsics.checkNotNull(saveDraftDialogView4);
            saveDraftDialogView4.setText(getString(d2 ? R.string.obfuscated_res_0x7f0f15d9 : R.string.obfuscated_res_0x7f0f15da), getString(d2 ? R.string.obfuscated_res_0x7f0f1082 : R.string.obfuscated_res_0x7f0f15dc), getString(d2 ? R.string.obfuscated_res_0x7f0f0ca6 : R.string.obfuscated_res_0x7f0f15db));
            ds4 ds4Var2 = this.B;
            Intrinsics.checkNotNull(ds4Var2);
            ds4Var2.k();
        }
    }

    public final void Z0() {
        Iterator<String> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002016, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("name", "VideoWorkListPage"))));
            WriteData writeData = new WriteData();
            writeData.setVideoInfo(v1().n().getValue());
            String value = v1().l().getValue();
            if (v1().m().getValue() != null) {
                ArrayList<String> value2 = v1().m().getValue();
                Intrinsics.checkNotNull(value2);
                while (value2.iterator().hasNext()) {
                    value = ((Object) value) + '#' + it.next() + '#';
                }
            }
            writeData.setTitle(value);
            writeData.setContent(v1().i().getValue());
            SelectForumData value3 = v1().g().getValue();
            vm8 vm8Var = null;
            writeData.setForumId(value3 == null ? null : value3.forumId);
            SelectForumData value4 = v1().g().getValue();
            writeData.setForumName(value4 == null ? null : value4.forumName);
            writeData.setHasLocationData((v1().j().getValue() == null || yl8.a().d()) ? false : true);
            writeData.setWork(true);
            writeData.setWorkDraft(this.H);
            VideoCategoryClassData videoCategoryClassData = new VideoCategoryClassData();
            VideoCategoryClassData value5 = v1().h().getValue();
            videoCategoryClassData.setFirstClass(value5 == null ? null : value5.getFirstClass());
            VideoCategoryClassData value6 = v1().h().getValue();
            videoCategoryClassData.setSecondClass(value6 == null ? null : value6.getSecondClass());
            if (v1().k().getValue() != null) {
                videoCategoryClassData.setTags(v1().k().getValue());
            }
            writeData.setClassAndTagData(videoCategoryClassData);
            String objLocate = WorkPublishManager.getObjLocate();
            if (!(objLocate == null || objLocate.length() == 0)) {
                String objLocate2 = WorkPublishManager.getObjLocate();
                Intrinsics.checkNotNullExpressionValue(objLocate2, "getObjLocate()");
                writeData.setStatisticFrom(Integer.parseInt(objLocate2));
            }
            boolean booleanExtra = getIntent().getBooleanExtra(WorkPublishActivityConfig.NEED_PUBLISH_END_JUMP_HOME, false);
            vm8 vm8Var2 = this.F;
            if (vm8Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                vm8Var2 = null;
            }
            vm8Var2.H(writeData);
            vm8 vm8Var3 = this.F;
            if (vm8Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                vm8Var3 = null;
            }
            vm8Var3.F(booleanExtra);
            vm8 vm8Var4 = this.F;
            if (vm8Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
            } else {
                vm8Var = vm8Var4;
            }
            vm8Var.I();
            if (booleanExtra) {
                MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2);
                if (UbsABTestHelper.isConcernForumCardShow() && TbadkCoreApplication.isLogin() && ru4.k().l("key_home_concern_all_status", 0) == 1) {
                    createNormalCfg.setSubTabName(getString(R.string.obfuscated_res_0x7f0f02b7));
                } else {
                    createNormalCfg.setSubTabName(getString(R.string.obfuscated_res_0x7f0f134a));
                }
                createNormalCfg.start();
            } else if (vm8.k().i() == null) {
                vm8 k2 = vm8.k();
                if (!k2.r() && !k2.s()) {
                    VideoWorkListActivityConfig videoWorkListActivityConfig = new VideoWorkListActivityConfig(this);
                    videoWorkListActivityConfig.addType("1");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoWorkListActivityConfig));
                } else {
                    WorkPostBackToPersonCenterFlutterData workPostBackToPersonCenterFlutterData = new WorkPostBackToPersonCenterFlutterData();
                    workPostBackToPersonCenterFlutterData.isShowProgressBar = true;
                    workPostBackToPersonCenterFlutterData.pageId = k2.j();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921625, workPostBackToPersonCenterFlutterData));
                }
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921622, Boolean.TRUE));
            }
            setResult(100);
            finish();
        }
    }

    public final synchronized void a1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            synchronized (this) {
                if (f1() == null) {
                    return;
                }
                Editable editableText = f1().getEditableText();
                Intrinsics.checkNotNullExpressionValue(editableText, "edtTitle.editableText");
                Matcher matcher = TbPatternsCompat.PLAIN_TEXT_VIDEO_HOTPIC_NAME.matcher(editableText);
                SelectTopicLayout selectTopicLayout = null;
                if (i2 < editableText.length() && matcher.find(i2)) {
                    int start = matcher.start();
                    int end = matcher.end();
                    o57 S1 = S1(matcher.group(1).toString());
                    if (S1 != null && S1.j()) {
                        if (ie5.g(editableText, start)) {
                            Object[] spans = editableText.getSpans(start, end + 1, Object.class);
                            Intrinsics.checkNotNullExpressionValue(spans, "text.getSpans(plainTextA…Pos + 1, Any::class.java)");
                            int i3 = 0;
                            int length = spans.length;
                            while (i3 < length) {
                                Object obj = spans[i3];
                                i3++;
                                if (obj instanceof EMRichTextAnyIconSpan) {
                                    editableText.removeSpan(obj);
                                }
                            }
                            f1().getSpanGroupManager().delete(start, end, true);
                        } else if (!f1().getSpanGroupManager().N(start, end)) {
                            f1().getSpanGroupManager().h(S1.e(), start);
                            this.L = S1;
                            SelectTopicToolBar selectTopicToolBar = this.v;
                            if (selectTopicToolBar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
                                selectTopicToolBar = null;
                            }
                            Long d2 = S1.d();
                            Intrinsics.checkNotNullExpressionValue(d2, "resultData.topicId");
                            selectTopicToolBar.setSelectTopicId(d2.longValue());
                            SelectTopicLayout selectTopicLayout2 = this.s;
                            if (selectTopicLayout2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                                selectTopicLayout2 = null;
                            }
                            Long d3 = S1.d();
                            Intrinsics.checkNotNullExpressionValue(d3, "resultData.topicId");
                            selectTopicLayout2.setSelectTopicId(d3.longValue());
                        }
                    }
                    a1(end);
                }
                if (f1().getSpanGroupManager().I().size() == 0) {
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

    public final void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int intExtra = getIntent().getIntExtra(WorkPublishActivityConfig.PARAM_SHOW_DRAFT, 0);
            this.G = intExtra;
            if (intExtra == WorkPublishOpenHelper.Companion.a()) {
                this.H = true;
                v1().p();
                h1();
            } else if (this.G == WorkPublishOpenHelper.Companion.b()) {
                Serializable serializableExtra = getIntent().getSerializableExtra(WorkPublishActivityConfig.PARAM_WRITE_DATA);
                if (serializableExtra instanceof WriteData) {
                    WriteData writeData = (WriteData) serializableExtra;
                    v1().s(writeData);
                    this.H = writeData.isWorkDraft();
                    this.I = false;
                }
            } else {
                this.H = false;
                Serializable serializableExtra2 = getIntent().getSerializableExtra(WorkPublishActivityConfig.PARAM_VIDEO_INFO);
                if (serializableExtra2 instanceof VideoInfo) {
                    v1().y((VideoInfo) serializableExtra2);
                }
                x1();
            }
            if (!TextUtils.isEmpty(getIntent().getStringExtra("topic"))) {
                t1();
            }
            if (!getIntent().getBooleanExtra(WorkPublishActivityConfig.VIDEO_MIXING, true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921584, 100));
            }
            if (getIntent().getBooleanExtra(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921583));
            }
        }
    }

    public final View b1() {
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

    public final void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            v1().t();
        }
    }

    public final TextView c1() {
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

    public final void c2(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.g = textView;
        }
    }

    @Override // com.repackage.s29
    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            v1().w(i2);
        }
    }

    public final RelativeLayout d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null) {
                return relativeLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("editContent");
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final void d2(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, relativeLayout) == null) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.d = relativeLayout;
        }
    }

    public final void e2(SpanGroupEditText spanGroupEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, spanGroupEditText) == null) {
            Intrinsics.checkNotNullParameter(spanGroupEditText, "<set-?>");
            this.c = spanGroupEditText;
        }
    }

    public final SpanGroupEditText f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.c;
            if (spanGroupEditText != null) {
                return spanGroupEditText;
            }
            Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            return null;
        }
        return (SpanGroupEditText) invokeV.objValue;
    }

    public final void f2(WorkPublishMixVideoView workPublishMixVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, workPublishMixVideoView) == null) {
            Intrinsics.checkNotNullParameter(workPublishMixVideoView, "<set-?>");
            this.f = workPublishMixVideoView;
        }
    }

    public final void g2(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, viewGroup) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.e = viewGroup;
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void h0(l57 l57Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, l57Var) == null) {
            SelectTopicLayout selectTopicLayout = this.s;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.u(l57Var);
        }
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            SelectForumData selectForumData = new SelectForumData();
            p1().setMCanChangeBarName(getIntent().getBooleanExtra(WorkPublishActivityConfig.CAN_CHANGE_SELECT_BAR, true));
            selectForumData.forumId = getIntent().getStringExtra("bar_id");
            selectForumData.forumName = getIntent().getStringExtra("bar_name");
            v1().u(getIntent().getBooleanExtra(WorkPublishActivityConfig.CAN_CHANGE_SELECT_BAR, true));
            v1().v(selectForumData);
        }
    }

    public final void h2(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.r = textView;
        }
    }

    public final WorkPublishMixVideoView i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            WorkPublishMixVideoView workPublishMixVideoView = this.f;
            if (workPublishMixVideoView != null) {
                return workPublishMixVideoView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mixVideoView");
            return null;
        }
        return (WorkPublishMixVideoView) invokeV.objValue;
    }

    public final void i2(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.q = textView;
        }
    }

    public final ViewGroup j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            ViewGroup viewGroup = this.e;
            if (viewGroup != null) {
                return viewGroup;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mixVideoViewLayout");
            return null;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final void j2(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, viewGroup) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.b = viewGroup;
        }
    }

    public final View k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            View view2 = this.p;
            if (view2 != null) {
                return view2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("navBack");
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final void k2(SelectBarView selectBarView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, selectBarView) == null) {
            Intrinsics.checkNotNullParameter(selectBarView, "<set-?>");
            this.h = selectBarView;
        }
    }

    public final TextView l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            TextView textView = this.r;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("navCenterText");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final void l2(SelectClassView selectClassView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, selectClassView) == null) {
            Intrinsics.checkNotNullParameter(selectClassView, "<set-?>");
            this.i = selectClassView;
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void m0(l57 l57Var, l57 l57Var2, l57 l57Var3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048611, this, l57Var, l57Var2, l57Var3) == null) {
            if (this.M == null) {
                this.M = l57Var3;
                a1(0);
            } else {
                this.M = l57Var3;
            }
            SelectTopicLayout selectTopicLayout = this.s;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.s(l57Var, l57Var2, l57Var3);
        }
    }

    public final TextView m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            TextView textView = this.q;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("navPost");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final void m2(SelectTagView selectTagView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, selectTagView) == null) {
            Intrinsics.checkNotNullParameter(selectTagView, "<set-?>");
            this.k = selectTagView;
        }
    }

    public final NavigationBar n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            NavigationBar navigationBar = this.o;
            if (navigationBar != null) {
                return navigationBar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public final void n2(SelectTopicView selectTopicView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, selectTopicView) == null) {
            Intrinsics.checkNotNullParameter(selectTopicView, "<set-?>");
            this.j = selectTopicView;
        }
    }

    public final ViewGroup o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            ViewGroup viewGroup = this.b;
            if (viewGroup != null) {
                return viewGroup;
            }
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            return null;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final void o2(WorkPublishViewModel workPublishViewModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, workPublishViewModel) == null) {
            Intrinsics.checkNotNullParameter(workPublishViewModel, "<set-?>");
            this.a = workPublishViewModel;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            ms4.d(w1()).f(R.color.CAM_X0201);
            n1().onChangeSkinType(getPageContext(), i2);
            n1().getBackImageView().setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809f2, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            ms4 d2 = ms4.d(m1());
            d2.v(R.color.CAM_X0101);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0302);
            if (Intrinsics.areEqual(v1().o().getValue(), Boolean.FALSE)) {
                m1().setAlpha(0.33f);
                m1().setEnabled(false);
            } else {
                m1().setAlpha(1.0f);
                m1().setEnabled(true);
            }
            l1().setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            p1().d();
            q1().d();
            s1().e();
            r1().e();
            SelectTopicToolBar selectTopicToolBar = this.v;
            View view2 = null;
            if (selectTopicToolBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
                selectTopicToolBar = null;
            }
            selectTopicToolBar.g();
            f1().setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            c1().setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            f1().setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            SkinManager.setBackgroundColor(b1(), R.color.CAM_X0210);
            i1().f();
            View view3 = this.u;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolShadow");
                view3 = null;
            }
            ms4.d(view3).o(new int[]{R.color.CAM_X0802, R.color.CAM_X0601});
            View view4 = this.t;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolLayout");
            } else {
                view2 = view4;
            }
            ms4.d(view2).f(R.color.CAM_X0207);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d005c);
            setSwipeBackEnabled(false);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            ViewModel viewModel = new ViewModelProvider(this).get(WorkPublishViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…ishViewModel::class.java)");
            o2((WorkPublishViewModel) viewModel);
            LocationModel locationModel = new LocationModel(getPageContext());
            this.D = locationModel;
            vm8 vm8Var = null;
            if (locationModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                locationModel = null;
            }
            locationModel.Q(this.a0);
            vm8 k2 = vm8.k();
            Intrinsics.checkNotNullExpressionValue(k2, "getInstance()");
            this.F = k2;
            if (k2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
            } else {
                vm8Var = k2;
            }
            vm8Var.p(this);
            F1();
            E1();
            registerListener(this.S);
            registerListener(this.T);
            registerListener(this.U);
            registerListener(this.Y);
            registerListener(this.Z);
            registerListener(this.R);
            registerListener(this.V);
            registerListener(this.W);
            registerListener(this.X);
            a2();
            T1();
            if (v1().n().getValue() != null && !this.H) {
                StatisticItem statisticItem = new StatisticItem("c14311");
                VideoInfo value = v1().n().getValue();
                Intrinsics.checkNotNull(value);
                TiebaStatic.log(statisticItem.param("obj_source", value.getVideoSource()));
            } else {
                TiebaStatic.log(new StatisticItem("c14311").param("obj_source", 0));
            }
            g19.a(3);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            super.onDestroy();
            ValueAnimator valueAnimator = this.A;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ds4 ds4Var = this.B;
            if (ds4Var != null) {
                ds4Var.dismiss();
            }
            this.B = null;
            r2();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048621, this, i2, keyEvent)) == null) {
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
                Y1();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048622, this, z) == null) {
            this.x = z;
            U1();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, intent) == null) {
            super.onNewIntent(intent);
            Serializable serializableExtra = intent == null ? null : intent.getSerializableExtra(WorkPublishActivityConfig.PARAM_VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                v1().y((VideoInfo) serializableExtra);
            }
        }
    }

    public final SelectBarView p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            SelectBarView selectBarView = this.h;
            if (selectBarView != null) {
                return selectBarView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("selectBarView");
            return null;
        }
        return (SelectBarView) invokeV.objValue;
    }

    public final void p2(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, viewGroup) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.l = viewGroup;
        }
    }

    public final SelectClassView q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            SelectClassView selectClassView = this.i;
            if (selectClassView != null) {
                return selectClassView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("selectClassView");
            return null;
        }
        return (SelectClassView) invokeV.objValue;
    }

    public final void q2(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, viewGroup) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.m = viewGroup;
        }
    }

    public final SelectTagView r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            SelectTagView selectTagView = this.k;
            if (selectTagView != null) {
                return selectTagView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("selectTagView");
            return null;
        }
        return (SelectTagView) invokeV.objValue;
    }

    public final void r2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            vm8 vm8Var = this.F;
            HotTopicSelectModel hotTopicSelectModel = null;
            if (vm8Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                vm8Var = null;
            }
            vm8Var.t();
            LocationModel locationModel = this.D;
            if (locationModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                locationModel = null;
            }
            locationModel.cancelLoadData();
            WorkPublishMixVideoView i1 = i1();
            if (i1 != null) {
                i1.g();
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

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void s0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, str) == null) {
            SelectTopicLayout selectTopicLayout = this.s;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.t(str);
        }
    }

    public final SelectTopicView s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            SelectTopicView selectTopicView = this.j;
            if (selectTopicView != null) {
                return selectTopicView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("selectTopicView");
            return null;
        }
        return (SelectTopicView) invokeV.objValue;
    }

    public final void s2(CharSequence charSequence, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048632, this, charSequence, i2, i3) == null) && i3 == 1 && i2 < charSequence.length() && i2 >= 0 && ie5.f(String.valueOf(charSequence.charAt(i2)))) {
            W1(true);
        }
    }

    public final void setContentBottomLine(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "<set-?>");
            this.n = view2;
        }
    }

    public final void setNavBack(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, view2) == null) {
            Intrinsics.checkNotNullParameter(view2, "<set-?>");
            this.p = view2;
        }
    }

    public final void setNavigationBar(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, navigationBar) == null) {
            Intrinsics.checkNotNullParameter(navigationBar, "<set-?>");
            this.o = navigationBar;
        }
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            final o57 o57Var = new o57(getIntent().getStringExtra("topic"), og.g(getIntent().getStringExtra("topicId"), 0L), og.e(getIntent().getStringExtra("is_video_topic"), 0) == 1);
            if (this.H) {
                o57Var.l(true);
                rg.a().postDelayed(new Runnable() { // from class: com.repackage.u19
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            WorkPublishActivity.u1(o57.this);
                        }
                    }
                }, 300L);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921633, o57Var));
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('(' char), (r0v3 int), (wrap: char : ?: SGET   com.google.android.exoplayer2.text.webvtt.WebvttCueParser.CHAR_SLASH char), (wrap: int : 0x0026: IGET  (r3v3 int A[REMOVE]) = (r4v0 'this' com.baidu.tieba.write.write.work.WorkPublishActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.write.write.work.WorkPublishActivity.O int), (')' char)] */
    public final void t2(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, charSequence) == null) {
            String obj = charSequence.toString();
            int V0 = V0(obj.length());
            TextView c1 = c1();
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(V0);
            sb.append(WebvttCueParser.CHAR_SLASH);
            sb.append(this.O);
            sb.append(')');
            c1.setText(sb.toString());
            if (V0 > this.O) {
                c1().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
            } else {
                c1().setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
            v1().x(obj, V0);
        }
    }

    public final WorkPublishViewModel v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            WorkPublishViewModel workPublishViewModel = this.a;
            if (workPublishViewModel != null) {
                return workPublishViewModel;
            }
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            return null;
        }
        return (WorkPublishViewModel) invokeV.objValue;
    }

    public final ViewGroup w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            ViewGroup viewGroup = this.l;
            if (viewGroup != null) {
                return viewGroup;
            }
            Intrinsics.throwUninitializedPropertyAccessException("workPublishBg");
            return null;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048640, this) == null) {
            SelectForumData selectForumData = new SelectForumData();
            v1().l().setValue(getIntent().getStringExtra("video_title"));
            v1().i().setValue(getIntent().getStringExtra(AlbumFloatActivityConfig.VIDEO_ABSTRACT));
            p1().setMCanChangeBarName(getIntent().getBooleanExtra(AlbumFloatActivityConfig.CAN_CHANGE_BAR_NAME, true));
            selectForumData.forumId = getIntent().getStringExtra("bar_id");
            selectForumData.forumName = getIntent().getStringExtra("bar_name");
            v1().g().setValue(selectForumData);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void y0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, str) == null) {
            SelectTopicLayout selectTopicLayout = this.s;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.r(str);
        }
    }

    public final void z1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this)));
        }
    }
}
