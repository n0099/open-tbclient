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
import c.a.d.f.p.n;
import c.a.o0.r.t.a;
import c.a.p0.s4.u.p.r;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
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
import com.baidu.tieba.write.write.work.selectview.SelectPosView;
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
@Metadata(d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u009f\u0001\u001a\u00020\u00062\u0007\u0010 \u0001\u001a\u00020\u0006H\u0002J\n\u0010¡\u0001\u001a\u00030¢\u0001H\u0002J\b\u0010£\u0001\u001a\u00030¢\u0001J\u0013\u0010¤\u0001\u001a\u00030¢\u00012\u0007\u0010¥\u0001\u001a\u00020\u0006H\u0002J\n\u0010¦\u0001\u001a\u00030¢\u0001H\u0002J\n\u0010§\u0001\u001a\u00030¢\u0001H\u0002J\n\u0010¨\u0001\u001a\u00030¢\u0001H\u0002J\n\u0010©\u0001\u001a\u00030¢\u0001H\u0002J\n\u0010ª\u0001\u001a\u00030¢\u0001H\u0002J\n\u0010«\u0001\u001a\u00030¢\u0001H\u0002J\b\u0010¬\u0001\u001a\u00030¢\u0001J\u0012\u0010\u00ad\u0001\u001a\u0004\u0018\u00010D2\u0007\u0010®\u0001\u001a\u00020@J\n\u0010¯\u0001\u001a\u00030¢\u0001H\u0002J\u0013\u0010°\u0001\u001a\u00030¢\u00012\u0007\u0010±\u0001\u001a\u00020\u0006H\u0014J\u0016\u0010²\u0001\u001a\u00030¢\u00012\n\u0010³\u0001\u001a\u0005\u0018\u00010´\u0001H\u0014J\n\u0010µ\u0001\u001a\u00030¢\u0001H\u0014J\u0015\u0010¶\u0001\u001a\u00030¢\u00012\t\u0010·\u0001\u001a\u0004\u0018\u00010@H\u0016J+\u0010¸\u0001\u001a\u00030¢\u00012\t\u0010¹\u0001\u001a\u0004\u0018\u00010B2\t\u0010º\u0001\u001a\u0004\u0018\u00010B2\t\u0010»\u0001\u001a\u0004\u0018\u00010BH\u0016J\u0015\u0010¼\u0001\u001a\u00030¢\u00012\t\u0010·\u0001\u001a\u0004\u0018\u00010@H\u0016J\u0015\u0010½\u0001\u001a\u00030¢\u00012\t\u0010¾\u0001\u001a\u0004\u0018\u00010BH\u0016J\u001e\u0010¿\u0001\u001a\u00020$2\u0007\u0010À\u0001\u001a\u00020\u00062\n\u0010Á\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0016J\u0013\u0010Ã\u0001\u001a\u00030¢\u00012\u0007\u0010Ä\u0001\u001a\u00020$H\u0014J\b\u0010Å\u0001\u001a\u00030¢\u0001J\n\u0010Æ\u0001\u001a\u00030¢\u0001H\u0016J\u0013\u0010Ç\u0001\u001a\u00030¢\u00012\u0007\u0010È\u0001\u001a\u00020\u0006H\u0016J\u0016\u0010É\u0001\u001a\u00030¢\u00012\n\u0010Ê\u0001\u001a\u0005\u0018\u00010Ë\u0001H\u0014J\n\u0010Ì\u0001\u001a\u00030¢\u0001H\u0002J\u0015\u0010Í\u0001\u001a\u00030¢\u00012\t\b\u0002\u0010Î\u0001\u001a\u00020$H\u0002J\b\u0010Ï\u0001\u001a\u00030¢\u0001J\n\u0010Ð\u0001\u001a\u00030¢\u0001H\u0002J\n\u0010Ñ\u0001\u001a\u00030¢\u0001H\u0002J\n\u0010Ò\u0001\u001a\u00030¢\u0001H\u0002J\b\u0010Ó\u0001\u001a\u00030¢\u0001J&\u0010Ô\u0001\u001a\u00030¢\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u00012\u0007\u0010×\u0001\u001a\u00020\u00062\u0007\u0010Ø\u0001\u001a\u00020\u0006H\u0002J\u0014\u0010Ù\u0001\u001a\u00030¢\u00012\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0002R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087D¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\u00020JX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u000e\u0010O\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010P\u001a\u00020QX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u000e\u0010V\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010W\u001a\u00020\bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\n\"\u0004\bY\u0010\fR\u001a\u0010Z\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u0010\"\u0004\b\\\u0010\u0012R\u001a\u0010]\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u0010\"\u0004\b_\u0010\u0012R\u001a\u0010`\u001a\u00020aX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u001a\u0010f\u001a\u00020QX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010S\"\u0004\bh\u0010UR\u0010\u0010i\u001a\u0004\u0018\u00010jX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u0004\u0018\u00010lX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010m\u001a\u00020nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001a\u0010s\u001a\u00020tX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u001a\u0010y\u001a\u00020zX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u001f\u0010\u007f\u001a\u00030\u0080\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0010\u0010\u0085\u0001\u001a\u00030\u0086\u0001X\u0082.¢\u0006\u0002\n\u0000R \u0010\u0087\u0001\u001a\u00030\u0088\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0010\u0010\u008d\u0001\u001a\u00030\u008e\u0001X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000f\u0010\u0092\u0001\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R \u0010\u0093\u0001\u001a\u00030\u0094\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001d\u0010\u0099\u0001\u001a\u00020QX\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010S\"\u0005\b\u009b\u0001\u0010UR\u001d\u0010\u009c\u0001\u001a\u00020QX\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010S\"\u0005\b\u009e\u0001\u0010U¨\u0006Ú\u0001"}, d2 = {"Lcom/baidu/tieba/write/write/work/WorkPublishActivity;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "Lcom/baidu/tieba/write/write/work/interf/IWorkVideoMixListener;", "Lcom/baidu/tieba/hottopicselect/HotTopicSelectModel$HotSelectCallBack;", "()V", "EDIT_INPUT_TITILE_MAX_LENGTH", "", "contentBottomLine", "Landroid/view/View;", "getContentBottomLine", "()Landroid/view/View;", "setContentBottomLine", "(Landroid/view/View;)V", "counterTitle", "Landroid/widget/TextView;", "getCounterTitle", "()Landroid/widget/TextView;", "setCounterTitle", "(Landroid/widget/TextView;)V", "curMixVideoViewHeight", "draftType", "editContent", "Landroid/widget/RelativeLayout;", "getEditContent", "()Landroid/widget/RelativeLayout;", "setEditContent", "(Landroid/widget/RelativeLayout;)V", "editModeAnimator", "Landroid/animation/ValueAnimator;", "edtTitle", "Lcom/baidu/tbadk/core/view/spanGroup/SpanGroupEditText;", "getEdtTitle", "()Lcom/baidu/tbadk/core/view/spanGroup/SpanGroupEditText;", "setEdtTitle", "(Lcom/baidu/tbadk/core/view/spanGroup/SpanGroupEditText;)V", "hasClickedTitle", "", "getHasClickedTitle", "()Z", "setHasClickedTitle", "(Z)V", "isDraftData", "isNeedCleanTag", "isTitleEditMode", "keyboardVisibility", "mAddHotpicListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mCanChangeBarNameToastListener", "mHighLightController", "Lcom/baidu/tieba/write/write/HighLightController;", "mHotModel", "Lcom/baidu/tieba/hottopicselect/HotTopicSelectModel;", "mLocationModel", "Lcom/baidu/tieba/tbadkCore/location/LocationModel;", "mNeedDeleteLast", "mOnLocationCallBack", "Lcom/baidu/tieba/tbadkCore/location/LocationModel$OnLocationCallBack;", "mOnSelectClassListener", "mOnSelectLocationListener", "mOnSelectTagListener", "mOnSelectTopicListener", "mSelectForumListener", "mShowCanNotSelectTagToastListener", "mTitleTemp", "", "mVideoListData", "Lcom/baidu/tieba/hottopicselect/HotTopicSelectGroupData;", "mVideoSelectData", "Lcom/baidu/tieba/hottopicselect/TopicListData;", "mWriteModel", "Lcom/baidu/tieba/tbadkCore/writeModel/AsyncWriteHelper;", "mWriteTitleTextWatcher", "Landroid/text/TextWatcher;", "mixVideoView", "Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;", "getMixVideoView", "()Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;", "setMixVideoView", "(Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;)V", "mixVideoViewHeight", "mixVideoViewLayout", "Landroid/view/ViewGroup;", "getMixVideoViewLayout", "()Landroid/view/ViewGroup;", "setMixVideoViewLayout", "(Landroid/view/ViewGroup;)V", "muxerSuccListener", "navBack", "getNavBack", "setNavBack", "navCenterText", "getNavCenterText", "setNavCenterText", "navPost", "getNavPost", "setNavPost", "navigationBar", "Lcom/baidu/tbadk/core/view/NavigationBar;", "getNavigationBar", "()Lcom/baidu/tbadk/core/view/NavigationBar;", "setNavigationBar", "(Lcom/baidu/tbadk/core/view/NavigationBar;)V", "rootView", "getRootView", "setRootView", "saveDraftDialog", "Lcom/baidu/tbadk/core/dialog/PopupDialog;", "saveDraftDialogView", "Lcom/baidu/tbadk/core/view/SaveDraftDialogView;", "selectBarView", "Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;", "getSelectBarView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;", "setSelectBarView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;)V", "selectClassView", "Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;", "getSelectClassView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;", "setSelectClassView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;)V", "selectPosView", "Lcom/baidu/tieba/write/write/work/selectview/SelectPosView;", "getSelectPosView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectPosView;", "setSelectPosView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectPosView;)V", "selectTagView", "Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;", "getSelectTagView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;", "setSelectTagView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;)V", "selectTopicModel", "Lcom/baidu/tieba/write/write/work/topic/SelectTopicModel;", "selectTopicView", "Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;", "getSelectTopicView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;", "setSelectTopicView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;)V", "topicLayout", "Lcom/baidu/tieba/write/write/work/topic/SelectTopicLayout;", "topicToolBar", "Lcom/baidu/tieba/write/write/work/topic/view/SelectTopicToolBar;", "topicToolLayout", "topicToolShadow", "viewModel", "Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "getViewModel", "()Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "setViewModel", "(Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;)V", "workPublishBg", "getWorkPublishBg", "setWorkPublishBg", "workPublishContainer", "getWorkPublishContainer", "setWorkPublishContainer", "checkTitleSpanLength", "lenght", "clearDraft", "", "doPost", "findAndTransPlainTextVideoHotpic", "end", "getFormData", "getTopicData", "getWriteData", "goToSelectLocationActivity", "initNav", "initSelectTopicModel", "initUI", "isVideoHotpic", "content", "loadData", "onChangeSkinType", WriteMulitImageActivityConfig.SKIN_TYPE, "onCreate", "savedInstanceState", "Landroid/os/Bundle;", MissionEvent.MESSAGE_DESTROY, "onHotSelectDataNoSearchFailed", "errormsg", "onHotSelectDataNoSearchSuccess", "user", "bang", "video", "onHotSelectDataSearchFailed", "onHotSelectDataSearchSuccess", "sug", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onKeyboardVisibilityChanged", "isVisible", "onLocViewClickedInInitState", "onMixFail", "onMixStateChanged", "status", "onNewIntent", "intent", "Landroid/content/Intent;", "onTitleEditModeChange", "openSelectTopicLayout", "fromEdit", "popupSaveDraftDialog", "prepareIntent", "processSaveDraft", "showLocPermissionDialog", "stopTask", "tryOpenSelectTopicLayout", "s", "", "start", "count", "updateTitleLimit", "write_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class WorkPublishActivity extends BaseFragmentActivity implements c.a.p0.s4.u.p.x.a, HotTopicSelectModel.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @JvmField
    public final int EDIT_INPUT_TITILE_MAX_LENGTH;
    public View contentBottomLine;
    public TextView counterTitle;
    public int curMixVideoViewHeight;
    public int draftType;
    public RelativeLayout editContent;
    public ValueAnimator editModeAnimator;
    public SpanGroupEditText edtTitle;
    public boolean hasClickedTitle;
    public boolean isDraftData;
    public boolean isNeedCleanTag;
    public boolean isTitleEditMode;
    public boolean keyboardVisibility;
    public final CustomMessageListener mAddHotpicListener;
    public final CustomMessageListener mCanChangeBarNameToastListener;
    public final c.a.p0.s4.u.c mHighLightController;
    public HotTopicSelectModel mHotModel;
    public LocationModel mLocationModel;
    public boolean mNeedDeleteLast;
    public final LocationModel.e mOnLocationCallBack;
    public final CustomMessageListener mOnSelectClassListener;
    public final CustomMessageListener mOnSelectLocationListener;
    public final CustomMessageListener mOnSelectTagListener;
    public final CustomMessageListener mOnSelectTopicListener;
    public final CustomMessageListener mSelectForumListener;
    public final CustomMessageListener mShowCanNotSelectTagToastListener;
    public String mTitleTemp;
    public c.a.p0.t1.c mVideoListData;
    public c.a.p0.t1.f mVideoSelectData;
    public c.a.p0.a4.t0.b mWriteModel;
    public final TextWatcher mWriteTitleTextWatcher;
    public WorkPublishMixVideoView mixVideoView;
    public int mixVideoViewHeight;
    public ViewGroup mixVideoViewLayout;
    public final CustomMessageListener muxerSuccListener;
    public View navBack;
    public TextView navCenterText;
    public TextView navPost;
    public NavigationBar navigationBar;
    public ViewGroup rootView;
    public c.a.o0.r.t.j saveDraftDialog;
    public SaveDraftDialogView saveDraftDialogView;
    public SelectBarView selectBarView;
    public SelectClassView selectClassView;
    public SelectPosView selectPosView;
    public SelectTagView selectTagView;
    public SelectTopicModel selectTopicModel;
    public SelectTopicView selectTopicView;
    public SelectTopicLayout topicLayout;
    public SelectTopicToolBar topicToolBar;
    public View topicToolLayout;
    public View topicToolShadow;
    public WorkPublishViewModel viewModel;
    public ViewGroup workPublishBg;
    public ViewGroup workPublishContainer;

    /* loaded from: classes6.dex */
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
        public void a(List<c.a.p0.t1.f> topicList) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, topicList) == null) {
                Intrinsics.checkNotNullParameter(topicList, "topicList");
                SelectTopicToolBar selectTopicToolBar = this.a.topicToolBar;
                if (selectTopicToolBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
                    selectTopicToolBar = null;
                }
                selectTopicToolBar.e(topicList);
            }
        }
    }

    /* loaded from: classes6.dex */
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
        /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('#' char), (wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.String : 0x00a5: INVOKE  (r6v4 java.lang.String A[REMOVE]) = (r6v3 c.a.p0.t1.f) type: VIRTUAL call: c.a.p0.t1.f.e():java.lang.String)), ('#' char)] */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                Intrinsics.checkNotNullParameter(responsedMessage, "responsedMessage");
                if (!(responsedMessage.getData() instanceof c.a.p0.t1.f) || this.a.getEdtTitle() == null) {
                    return;
                }
                int selectionStart = this.a.getEdtTitle().getSelectionStart();
                if (this.a.mNeedDeleteLast && selectionStart > 0) {
                    int i = selectionStart - 1;
                    if (String.valueOf(this.a.getEdtTitle().getText()).charAt(i) == '#') {
                        this.a.getEdtTitle().getEditableText().delete(i, selectionStart);
                        this.a.mNeedDeleteLast = false;
                    }
                }
                Object data = responsedMessage.getData();
                if (data != null) {
                    c.a.p0.t1.f fVar = (c.a.p0.t1.f) data;
                    if (fVar.j()) {
                        this.a.getEdtTitle().d(fVar.e(), fVar.g() ? 0 : -1, fVar.f());
                    } else {
                        Editable editableText = this.a.getEdtTitle().getEditableText();
                        int selectionStart2 = fVar.g() ? 0 : this.a.getEdtTitle().getSelectionStart();
                        StringBuilder sb = new StringBuilder();
                        sb.append('#');
                        sb.append((Object) fVar.e());
                        sb.append('#');
                        editableText.insert(selectionStart2, sb.toString());
                    }
                    SelectTopicLayout selectTopicLayout = this.a.topicLayout;
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

    /* loaded from: classes6.dex */
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
                        bdTopToast.i(false);
                        bdTopToast.h(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0364));
                        bdTopToast.j(this.a.getNavigationBar());
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c4c);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData data) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (!StringUtils.isNull(data.getFormatted_address())) {
                    this.a.goToSelectLocationActivity();
                    return;
                }
                WorkPublishActivity workPublishActivity = this.a;
                workPublishActivity.showToast(workPublishActivity.getString(R.string.obfuscated_res_0x7f0f0a40));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String errorMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, errorMsg) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                WorkPublishActivity workPublishActivity = this.a;
                if (StringUtils.isNull(errorMsg)) {
                    errorMsg = this.a.getString(R.string.obfuscated_res_0x7f0f0a40);
                }
                workPublishActivity.showToast(errorMsg);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                        this.a.isNeedCleanTag = true;
                        this.a.getViewModel().h().setValue((VideoCategoryClassData) data);
                        this.a.getViewModel().a();
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.data.VideoCategoryClassData");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                        LocationModel locationModel2 = this.a.mLocationModel;
                        if (locationModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                            locationModel2 = null;
                        }
                        locationModel2.P(false);
                        LocationModel locationModel3 = this.a.mLocationModel;
                        if (locationModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                        } else {
                            locationModel = locationModel3;
                        }
                        locationModel.O(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                    } else {
                        LocationModel locationModel4 = this.a.mLocationModel;
                        if (locationModel4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                        } else {
                            locationModel = locationModel4;
                        }
                        locationModel.P(true);
                    }
                    this.a.getViewModel().j().setValue(responsedMessage);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                        this.a.getViewModel().k().setValue((ArrayList) data);
                        this.a.getViewModel().a();
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                        this.a.getViewModel().m().setValue((ArrayList) data);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                        this.a.getViewModel().g().setValue((SelectForumData) data);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.tbadk.data.SelectForumData");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                        bdTopToast.i(false);
                        bdTopToast.h(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0366));
                        bdTopToast.j(this.a.getNavigationBar());
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class k implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f37511b;

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
            this.f37511b = workPublishActivity;
            this.a = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, s) == null) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (this.f37511b.getEdtTitle() == null || this.f37511b.getEdtTitle().getText() == null) {
                    return;
                }
                if (this.f37511b.mTitleTemp != null && Intrinsics.areEqual(this.f37511b.mTitleTemp, s.toString())) {
                    this.f37511b.getEdtTitle().setSelection(this.f37511b.getEdtTitle().getSelectionEnd());
                    return;
                }
                WorkPublishActivity workPublishActivity = this.f37511b;
                workPublishActivity.mTitleTemp = String.valueOf(workPublishActivity.getEdtTitle().getText());
                this.f37511b.findAndTransPlainTextVideoHotpic(0);
                if (this.f37511b.mHighLightController != null) {
                    this.f37511b.mHighLightController.h(this.f37511b.getEdtTitle());
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
                    this.f37511b.tryOpenSelectTopicLayout(s, i, i3);
                }
                this.f37511b.updateTitleLimit(s);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                        this.a.getViewModel().y((VideoInfo) data);
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
        this.isNeedCleanTag = true;
        this.mHighLightController = new c.a.p0.s4.u.c();
        this.mTitleTemp = "";
        this.EDIT_INPUT_TITILE_MAX_LENGTH = 80;
        this.muxerSuccListener = new l(this);
        this.mSelectForumListener = new i(this);
        this.mAddHotpicListener = new b(this);
        this.mOnSelectClassListener = new e(this);
        this.mOnSelectTagListener = new g(this);
        this.mShowCanNotSelectTagToastListener = new j(this);
        this.mCanChangeBarNameToastListener = new c(this);
        this.mOnSelectTopicListener = new h(this);
        this.mOnSelectLocationListener = new f(this);
        this.mOnLocationCallBack = new d(this);
        this.mWriteTitleTextWatcher = new k(this);
    }

    private final int checkTitleSpanLength(int i2) {
        InterceptResult invokeI;
        SpanGroupManager spanGroupManager;
        List<c.a.o0.r.l0.s.e> G;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65550, this, i2)) == null) {
            SpanGroupEditText edtTitle = getEdtTitle();
            Integer num = null;
            if (edtTitle != null && (spanGroupManager = edtTitle.getSpanGroupManager()) != null && (G = spanGroupManager.G()) != null) {
                num = Integer.valueOf(G.size());
            }
            Intrinsics.checkNotNull(num);
            if (num.intValue() > 0) {
                String s = getEdtTitle().getSpanGroupManager().G().get(0).s();
                return i2 >= s.length() ? (i2 - s.length()) + 1 : i2;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    private final void clearDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            getViewModel().e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void findAndTransPlainTextVideoHotpic(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65552, this, i2) == null) {
            synchronized (this) {
                if (getEdtTitle() == null) {
                    return;
                }
                Editable editableText = getEdtTitle().getEditableText();
                Intrinsics.checkNotNullExpressionValue(editableText, "edtTitle.editableText");
                Matcher matcher = TbPatternsCompat.PLAIN_TEXT_VIDEO_HOTPIC_NAME.matcher(editableText);
                SelectTopicLayout selectTopicLayout = null;
                if (i2 < editableText.length() && matcher.find(i2)) {
                    int start = matcher.start();
                    int end = matcher.end();
                    c.a.p0.t1.f isVideoHotpic = isVideoHotpic(matcher.group(1).toString());
                    if (isVideoHotpic != null && isVideoHotpic.j()) {
                        if (c.a.o0.t0.a.g(editableText, start)) {
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
                            getEdtTitle().getSpanGroupManager().delete(start, end, true);
                        } else if (!getEdtTitle().getSpanGroupManager().L(start, end)) {
                            getEdtTitle().getSpanGroupManager().h(isVideoHotpic.e(), start);
                            this.mVideoSelectData = isVideoHotpic;
                            SelectTopicToolBar selectTopicToolBar = this.topicToolBar;
                            if (selectTopicToolBar == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
                                selectTopicToolBar = null;
                            }
                            Long d2 = isVideoHotpic.d();
                            Intrinsics.checkNotNullExpressionValue(d2, "resultData.topicId");
                            selectTopicToolBar.setSelectTopicId(d2.longValue());
                            SelectTopicLayout selectTopicLayout2 = this.topicLayout;
                            if (selectTopicLayout2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                                selectTopicLayout2 = null;
                            }
                            Long d3 = isVideoHotpic.d();
                            Intrinsics.checkNotNullExpressionValue(d3, "resultData.topicId");
                            selectTopicLayout2.setSelectTopicId(d3.longValue());
                        }
                    }
                    findAndTransPlainTextVideoHotpic(end);
                }
                if (getEdtTitle().getSpanGroupManager().G().size() == 0) {
                    this.mVideoSelectData = null;
                    SelectTopicToolBar selectTopicToolBar2 = this.topicToolBar;
                    if (selectTopicToolBar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
                        selectTopicToolBar2 = null;
                    }
                    selectTopicToolBar2.setSelectTopicId(-1L);
                    SelectTopicLayout selectTopicLayout3 = this.topicLayout;
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

    private final void getFormData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            SelectForumData selectForumData = new SelectForumData();
            getSelectBarView().setMCanChangeBarName(getIntent().getBooleanExtra(WorkPublishActivityConfig.CAN_CHANGE_SELECT_BAR, true));
            selectForumData.forumId = getIntent().getStringExtra("bar_id");
            selectForumData.forumName = getIntent().getStringExtra("bar_name");
            getViewModel().u(getIntent().getBooleanExtra(WorkPublishActivityConfig.CAN_CHANGE_SELECT_BAR, true));
            getViewModel().v(selectForumData);
        }
    }

    private final void getTopicData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            final c.a.p0.t1.f fVar = new c.a.p0.t1.f(getIntent().getStringExtra("topic"), c.a.d.f.m.b.g(getIntent().getStringExtra("topicId"), 0L), c.a.d.f.m.b.e(getIntent().getStringExtra("is_video_topic"), 0) == 1);
            if (this.isDraftData) {
                fVar.l(true);
                c.a.d.f.m.e.a().postDelayed(new Runnable() { // from class: c.a.p0.s4.u.p.d
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            WorkPublishActivity.m61getTopicData$lambda1(c.a.p0.t1.f.this);
                        }
                    }
                }, 300L);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921633, fVar));
        }
    }

    /* renamed from: getTopicData$lambda-1  reason: not valid java name */
    public static final void m61getTopicData$lambda1(c.a.p0.t1.f toplist) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, toplist) == null) {
            Intrinsics.checkNotNullParameter(toplist, "$toplist");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921633, toplist));
        }
    }

    private final void getWriteData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            SelectForumData selectForumData = new SelectForumData();
            getViewModel().l().setValue(getIntent().getStringExtra("video_title"));
            getViewModel().i().setValue(getIntent().getStringExtra(AlbumFloatActivityConfig.VIDEO_ABSTRACT));
            getSelectBarView().setMCanChangeBarName(getIntent().getBooleanExtra(AlbumFloatActivityConfig.CAN_CHANGE_BAR_NAME, true));
            selectForumData.forumId = getIntent().getStringExtra("bar_id");
            selectForumData.forumName = getIntent().getStringExtra("bar_name");
            getViewModel().g().setValue(selectForumData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goToSelectLocationActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this)));
        }
    }

    private final void initNav() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0923cf);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.view_navigation_bar)");
            setNavigationBar((NavigationBar) findViewById);
            getNavigationBar().showBottomLine();
            View addSystemImageButton = getNavigationBar().addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            Intrinsics.checkNotNullExpressionValue(addSystemImageButton, "navigationBar.addSystemI…ype.BACK_BUTTON\n        )");
            setNavBack(addSystemImageButton);
            getNavBack().setOnClickListener(new View.OnClickListener() { // from class: c.a.p0.s4.u.p.p
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        WorkPublishActivity.m62initNav$lambda16(WorkPublishActivity.this, view);
                    }
                }
            });
            TextView addTextButton = getNavigationBar().addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.obfuscated_res_0x7f0f0848));
            Intrinsics.checkNotNullExpressionValue(addTextButton, "navigationBar.addTextBut…g.home_publish)\n        )");
            setNavPost(addTextButton);
            getNavPost().getLayoutParams().width = UtilHelper.getDimenPixelSize(R.dimen.tbds130);
            getNavPost().getLayoutParams().height = UtilHelper.getDimenPixelSize(R.dimen.tbds75);
            ViewGroup.LayoutParams layoutParams = getNavPost().getLayoutParams();
            if (layoutParams != null) {
                ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
                c.a.o0.r.v.c.d(getNavPost()).z(R.dimen.T_X08);
                getNavPost().setOnClickListener(new View.OnClickListener() { // from class: c.a.p0.s4.u.p.f
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WorkPublishActivity.m63initNav$lambda18(WorkPublishActivity.this, view);
                        }
                    }
                });
                TextView centerTextTitle = getNavigationBar().setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f1568));
                Intrinsics.checkNotNullExpressionValue(centerTextTitle, "navigationBar.setCenterT…g(R.string.work_publish))");
                setNavCenterText(centerTextTitle);
                ViewGroup.LayoutParams layoutParams2 = getNavCenterText().getLayoutParams();
                if (layoutParams2 != null) {
                    ((LinearLayout.LayoutParams) layoutParams2).leftMargin = 0;
                    ViewGroup.LayoutParams layoutParams3 = getNavCenterText().getLayoutParams();
                    if (layoutParams3 != null) {
                        ((LinearLayout.LayoutParams) layoutParams3).rightMargin = UtilHelper.getDimenPixelSize(R.dimen.tbds30);
                        getNavigationBar().setOnClickListener(new View.OnClickListener() { // from class: c.a.p0.s4.u.p.b
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                    WorkPublishActivity.m64initNav$lambda19(WorkPublishActivity.this, view);
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

    /* renamed from: initNav$lambda-16  reason: not valid java name */
    public static final void m62initNav$lambda16(WorkPublishActivity this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SelectTopicLayout selectTopicLayout = this$0.topicLayout;
            SelectTopicLayout selectTopicLayout2 = null;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            if (selectTopicLayout.q()) {
                SelectTopicLayout selectTopicLayout3 = this$0.topicLayout;
                if (selectTopicLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                } else {
                    selectTopicLayout2 = selectTopicLayout3;
                }
                selectTopicLayout2.i();
                return;
            }
            this$0.popupSaveDraftDialog();
        }
    }

    /* renamed from: initNav$lambda-18  reason: not valid java name */
    public static final void m63initNav$lambda18(WorkPublishActivity this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SelectTopicLayout selectTopicLayout = this$0.topicLayout;
            SelectTopicLayout selectTopicLayout2 = null;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            if (selectTopicLayout.q()) {
                SelectTopicLayout selectTopicLayout3 = this$0.topicLayout;
                if (selectTopicLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                } else {
                    selectTopicLayout2 = selectTopicLayout3;
                }
                selectTopicLayout2.i();
                return;
            }
            if (this$0.getNavPost().getAlpha() == 1.0f) {
                this$0.doPost();
                c.a.p0.t1.f fVar = this$0.mVideoSelectData;
                if (fVar != null && fVar.j()) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_WORK_VIDEO_HAS_TOPIC);
                    Long d2 = fVar.d();
                    Intrinsics.checkNotNullExpressionValue(d2, "it.topicId");
                    statisticItem.param("topic_id", d2.longValue());
                    statisticItem.param("is_video_topic", "1");
                    TiebaStatic.log(statisticItem);
                    return;
                }
                return;
            }
            if (this$0.getNavPost().getAlpha() == 0.33f) {
                if (this$0.checkTitleSpanLength(String.valueOf(this$0.getEdtTitle().getText()).length()) < 5) {
                    BdTopToast bdTopToast = new BdTopToast(this$0);
                    bdTopToast.i(false);
                    bdTopToast.h(this$0.getString(R.string.obfuscated_res_0x7f0f1571));
                    bdTopToast.j(this$0.getRootView());
                }
                if (this$0.checkTitleSpanLength(String.valueOf(this$0.getEdtTitle().getText()).length()) > this$0.EDIT_INPUT_TITILE_MAX_LENGTH) {
                    BdTopToast bdTopToast2 = new BdTopToast(this$0);
                    bdTopToast2.i(false);
                    bdTopToast2.h(this$0.getString(R.string.obfuscated_res_0x7f0f1570));
                    bdTopToast2.j(this$0.getRootView());
                }
            }
        }
    }

    /* renamed from: initNav$lambda-19  reason: not valid java name */
    public static final void m64initNav$lambda19(WorkPublishActivity this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65561, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SelectTopicLayout selectTopicLayout = this$0.topicLayout;
            SelectTopicLayout selectTopicLayout2 = null;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            if (selectTopicLayout.q()) {
                SelectTopicLayout selectTopicLayout3 = this$0.topicLayout;
                if (selectTopicLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                } else {
                    selectTopicLayout2 = selectTopicLayout3;
                }
                selectTopicLayout2.i();
            }
        }
    }

    private final void initSelectTopicModel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65562, this) == null) {
            SelectTopicModel selectTopicModel = new SelectTopicModel(getPageContext());
            this.selectTopicModel = selectTopicModel;
            HotTopicSelectModel hotTopicSelectModel = null;
            if (selectTopicModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectTopicModel");
                selectTopicModel = null;
            }
            selectTopicModel.C(new a(this));
            HotTopicSelectModel hotTopicSelectModel2 = new HotTopicSelectModel(getPageContext(), this);
            this.mHotModel = hotTopicSelectModel2;
            if (hotTopicSelectModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
                hotTopicSelectModel2 = null;
            }
            hotTopicSelectModel2.H(getIntent());
            HotTopicSelectModel hotTopicSelectModel3 = this.mHotModel;
            if (hotTopicSelectModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
                hotTopicSelectModel3 = null;
            }
            hotTopicSelectModel3.O(true);
            HotTopicSelectModel hotTopicSelectModel4 = this.mHotModel;
            if (hotTopicSelectModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
                hotTopicSelectModel4 = null;
            }
            hotTopicSelectModel4.K();
            SelectTopicLayout selectTopicLayout = this.topicLayout;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            HotTopicSelectModel hotTopicSelectModel5 = this.mHotModel;
            if (hotTopicSelectModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
                hotTopicSelectModel5 = null;
            }
            selectTopicLayout.setHotTopicModel(hotTopicSelectModel5);
            HotTopicSelectModel hotTopicSelectModel6 = this.mHotModel;
            if (hotTopicSelectModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
                hotTopicSelectModel6 = null;
            }
            hotTopicSelectModel6.D();
            HotTopicSelectModel hotTopicSelectModel7 = this.mHotModel;
            if (hotTopicSelectModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
            } else {
                hotTopicSelectModel = hotTopicSelectModel7;
            }
            hotTopicSelectModel.L();
        }
    }

    /* renamed from: initUI$lambda-10  reason: not valid java name */
    public static final void m65initUI$lambda10(WorkPublishActivity this$0, SelectForumData selectForumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, this$0, selectForumData) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.getSelectBarView().a(selectForumData);
        }
    }

    /* renamed from: initUI$lambda-11  reason: not valid java name */
    public static final void m66initUI$lambda11(WorkPublishActivity this$0, VideoCategoryClassData videoCategoryClassData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, null, this$0, videoCategoryClassData) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.getSelectClassView().a(videoCategoryClassData);
            if (Intrinsics.areEqual(this$0.getSelectTagView().getFirstClass(), videoCategoryClassData.getFirstClass()) && Intrinsics.areEqual(this$0.getSelectTagView().getSecondClass(), videoCategoryClassData.getSecondClass())) {
                return;
            }
            SelectTagView selectTagView = this$0.getSelectTagView();
            String firstClass = videoCategoryClassData.getFirstClass();
            Intrinsics.checkNotNullExpressionValue(firstClass, "it.firstClass");
            String secondClass = videoCategoryClassData.getSecondClass();
            Intrinsics.checkNotNullExpressionValue(secondClass, "it.secondClass");
            selectTagView.setClassData(firstClass, secondClass);
            if (this$0.isNeedCleanTag) {
                this$0.getViewModel().k().setValue(new ArrayList<>());
            }
        }
    }

    /* renamed from: initUI$lambda-12  reason: not valid java name */
    public static final void m67initUI$lambda12(WorkPublishActivity this$0, ArrayList it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, this$0, it) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SelectTagView selectTagView = this$0.getSelectTagView();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            selectTagView.a(it);
            this$0.getSelectClassView().setMIsSelectedTags(!it.isEmpty());
        }
    }

    /* renamed from: initUI$lambda-13  reason: not valid java name */
    public static final void m68initUI$lambda13(WorkPublishActivity this$0, ArrayList it) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65566, null, this$0, it) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            SelectTopicView selectTopicView = this$0.getSelectTopicView();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            selectTopicView.a(it);
        }
    }

    /* renamed from: initUI$lambda-14  reason: not valid java name */
    public static final void m69initUI$lambda14(WorkPublishActivity this$0, ResponsedSelectLocation responsedSelectLocation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, null, this$0, responsedSelectLocation) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.getSelectPosView().e(responsedSelectLocation);
        }
    }

    /* renamed from: initUI$lambda-15  reason: not valid java name */
    public static final void m70initUI$lambda15(WorkPublishActivity this$0, VideoInfo videoInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65568, null, this$0, videoInfo) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (videoInfo != null) {
                this$0.getMixVideoView().setVideoInfo(videoInfo, false);
            }
        }
    }

    /* renamed from: initUI$lambda-2  reason: not valid java name */
    public static final void m71initUI$lambda2(WorkPublishActivity this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65569, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onLocViewClickedInInitState();
        }
    }

    /* renamed from: initUI$lambda-3  reason: not valid java name */
    public static final void m72initUI$lambda3(WorkPublishActivity this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65570, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            n.L(TbadkCoreApplication.getInst(), this$0.getEdtTitle());
        }
    }

    /* renamed from: initUI$lambda-4  reason: not valid java name */
    public static final void m73initUI$lambda4(WorkPublishActivity this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            int height = this$0.getNavigationBar().getHeight() + n.f(this$0, R.dimen.tbds254);
            SelectTopicLayout selectTopicLayout = this$0.topicLayout;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.setTitlePlaceholderHeight(height);
        }
    }

    /* renamed from: initUI$lambda-5  reason: not valid java name */
    public static final void m74initUI$lambda5(WorkPublishActivity this$0, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65572, null, new Object[]{this$0, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.onTitleEditModeChange();
            if (z || !z2) {
                return;
            }
            this$0.getEdtTitle().setFocusable(true);
            this$0.getEdtTitle().setFocusableInTouchMode(true);
            this$0.getEdtTitle().requestFocus();
        }
    }

    /* renamed from: initUI$lambda-6  reason: not valid java name */
    public static final void m75initUI$lambda6(WorkPublishActivity this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            openSelectTopicLayout$default(this$0, false, 1, null);
        }
    }

    /* renamed from: initUI$lambda-7  reason: not valid java name */
    public static final void m76initUI$lambda7(WorkPublishActivity this$0, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65574, null, this$0, bool) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (Intrinsics.areEqual(this$0.getViewModel().o().getValue(), Boolean.FALSE)) {
                this$0.getNavPost().setAlpha(0.33f);
                this$0.getNavPost().setEnabled(true);
                return;
            }
            this$0.getNavPost().setAlpha(1.0f);
            this$0.getNavPost().setEnabled(true);
        }
    }

    /* renamed from: initUI$lambda-9  reason: not valid java name */
    public static final void m77initUI$lambda9(WorkPublishActivity this$0, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65575, null, this$0, str) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (str == null || str.equals(String.valueOf(this$0.getEdtTitle().getText()))) {
                return;
            }
            this$0.getEdtTitle().setText(str);
            Editable text = this$0.getEdtTitle().getText();
            if (text == null) {
                return;
            }
            this$0.getEdtTitle().setSelection(text.length());
        }
    }

    private final void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            SelectTopicModel selectTopicModel = this.selectTopicModel;
            if (selectTopicModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectTopicModel");
                selectTopicModel = null;
            }
            selectTopicModel.A();
        }
    }

    private final void onTitleEditModeChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            SelectTopicLayout selectTopicLayout = this.topicLayout;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            boolean z = selectTopicLayout.q() || this.keyboardVisibility;
            if (this.mixVideoViewHeight == 0) {
                int height = getMixVideoView().getHeight();
                this.mixVideoViewHeight = height;
                this.curMixVideoViewHeight = height;
            }
            if (z == this.isTitleEditMode) {
                return;
            }
            this.isTitleEditMode = z;
            ValueAnimator valueAnimator = this.editModeAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (this.isTitleEditMode) {
                this.editModeAnimator = ValueAnimator.ofInt(this.curMixVideoViewHeight, 0);
            } else {
                this.editModeAnimator = ValueAnimator.ofInt(this.curMixVideoViewHeight, this.mixVideoViewHeight);
            }
            ValueAnimator valueAnimator2 = this.editModeAnimator;
            if (valueAnimator2 != null) {
                valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: c.a.p0.s4.u.p.m
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator3) == null) {
                            WorkPublishActivity.m78onTitleEditModeChange$lambda0(WorkPublishActivity.this, valueAnimator3);
                        }
                    }
                });
            }
            ValueAnimator valueAnimator3 = this.editModeAnimator;
            if (valueAnimator3 == null) {
                return;
            }
            valueAnimator3.start();
        }
    }

    /* renamed from: onTitleEditModeChange$lambda-0  reason: not valid java name */
    public static final void m78onTitleEditModeChange$lambda0(WorkPublishActivity this$0, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65578, null, this$0, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                this$0.curMixVideoViewHeight = ((Integer) animatedValue).intValue();
                this$0.getMixVideoViewLayout().getLayoutParams().height = this$0.curMixVideoViewHeight;
                this$0.getMixVideoViewLayout().setPadding(0, this$0.curMixVideoViewHeight - this$0.mixVideoViewHeight, 0, 0);
                this$0.getMixVideoViewLayout().requestLayout();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    private final void openSelectTopicLayout(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65579, this, z) == null) {
            if (getEdtTitle().isFocused()) {
                getEdtTitle().setFocusable(false);
                getEdtTitle().setFocusableInTouchMode(true);
                Object systemService = getSystemService("input_method");
                if (systemService != null) {
                    HidenSoftKeyPad((InputMethodManager) systemService, getEdtTitle());
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                }
            }
            SelectTopicLayout selectTopicLayout = this.topicLayout;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.w();
            this.mNeedDeleteLast = z;
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WORK_VIDEO_TOPIC_LAYOUT_SHOW));
        }
    }

    public static /* synthetic */ void openSelectTopicLayout$default(WorkPublishActivity workPublishActivity, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        workPublishActivity.openSelectTopicLayout(z);
    }

    /* renamed from: popupSaveDraftDialog$lambda-22  reason: not valid java name */
    public static final void m79popupSaveDraftDialog$lambda22(WorkPublishActivity this$0, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65581, null, this$0, view) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            c.a.o0.r.t.j jVar = this$0.saveDraftDialog;
            Intrinsics.checkNotNull(jVar);
            jVar.dismiss();
            int id = view.getId();
            if (view.getTag(R.id.obfuscated_res_0x7f091002) instanceof Boolean) {
                Object tag = view.getTag(R.id.obfuscated_res_0x7f091002);
                if (tag == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }
                boolean booleanValue = ((Boolean) tag).booleanValue();
                if (id == R.id.obfuscated_res_0x7f091bec) {
                    if (booleanValue) {
                        TiebaStatic.log(new StatisticItem("c14260").param("obj_locate", 2));
                        this$0.clearDraft();
                    }
                    this$0.setResult(100);
                    this$0.finish();
                } else if (id != R.id.obfuscated_res_0x7f091bed) {
                    if (id == R.id.obfuscated_res_0x7f091beb && booleanValue) {
                        TiebaStatic.log(new StatisticItem("c14260").param("obj_locate", 0));
                    }
                } else if (booleanValue) {
                    TiebaStatic.log(new StatisticItem("c14260").param("obj_locate", 1));
                    this$0.processSaveDraft();
                    this$0.setResult(100);
                    this$0.finish();
                }
            }
        }
    }

    private final void prepareIntent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            int intExtra = getIntent().getIntExtra(WorkPublishActivityConfig.PARAM_SHOW_DRAFT, 0);
            this.draftType = intExtra;
            if (intExtra == WorkPublishOpenHelper.Companion.a()) {
                this.isDraftData = true;
                getViewModel().p();
                getFormData();
            } else if (this.draftType == WorkPublishOpenHelper.Companion.b()) {
                Serializable serializableExtra = getIntent().getSerializableExtra(WorkPublishActivityConfig.PARAM_WRITE_DATA);
                if (serializableExtra instanceof WriteData) {
                    WriteData writeData = (WriteData) serializableExtra;
                    getViewModel().s(writeData);
                    this.isDraftData = writeData.isWorkDraft();
                    this.isNeedCleanTag = false;
                }
            } else {
                this.isDraftData = false;
                Serializable serializableExtra2 = getIntent().getSerializableExtra(WorkPublishActivityConfig.PARAM_VIDEO_INFO);
                if (serializableExtra2 instanceof VideoInfo) {
                    getViewModel().y((VideoInfo) serializableExtra2);
                }
                getWriteData();
            }
            if (!TextUtils.isEmpty(getIntent().getStringExtra("topic"))) {
                getTopicData();
            }
            if (!getIntent().getBooleanExtra(WorkPublishActivityConfig.VIDEO_MIXING, true)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921584, 100));
            }
            if (getIntent().getBooleanExtra(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921583));
            }
        }
    }

    private final void processSaveDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            getViewModel().t();
        }
    }

    private final void showLocPermissionDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65584, this) == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getPageContext().getPageActivity());
            aVar.setMessageId(R.string.obfuscated_res_0x7f0f0a3e).setPositiveButton(R.string.obfuscated_res_0x7f0f0964, new a.e() { // from class: c.a.p0.s4.u.p.o
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // c.a.o0.r.t.a.e
                public final void onClick(c.a.o0.r.t.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, aVar2) == null) {
                        WorkPublishActivity.m80showLocPermissionDialog$lambda20(WorkPublishActivity.this, aVar2);
                    }
                }
            }).setNegativeButton(R.string.obfuscated_res_0x7f0f036c, r.a).create(getPageContext());
            aVar.show();
        }
    }

    /* renamed from: showLocPermissionDialog$lambda-20  reason: not valid java name */
    public static final void m80showLocPermissionDialog$lambda20(WorkPublishActivity this$0, c.a.o0.r.t.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65585, null, this$0, aVar) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (c.a.d.f.p.l.z()) {
                LocationModel locationModel = this$0.mLocationModel;
                if (locationModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                    locationModel = null;
                }
                locationModel.N();
            } else {
                this$0.mOnLocationCallBack.a();
            }
            aVar.dismiss();
        }
    }

    /* renamed from: showLocPermissionDialog$lambda-21  reason: not valid java name */
    public static final void m81showLocPermissionDialog$lambda21(c.a.o0.r.t.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65586, null, aVar) == null) {
            aVar.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryOpenSelectTopicLayout(CharSequence charSequence, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65587, this, charSequence, i2, i3) == null) && i3 == 1 && i2 < charSequence.length() && i2 >= 0 && c.a.o0.t0.a.f(String.valueOf(charSequence.charAt(i2)))) {
            openSelectTopicLayout(true);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('(' char), (r0v3 int), (wrap: char : ?: SGET   com.google.android.exoplayer2.text.webvtt.WebvttCueParser.CHAR_SLASH char), (wrap: int : 0x0026: IGET  (r3v3 int A[REMOVE]) = (r4v0 'this' com.baidu.tieba.write.write.work.WorkPublishActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.write.write.work.WorkPublishActivity.EDIT_INPUT_TITILE_MAX_LENGTH int), (')' char)] */
    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTitleLimit(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65588, this, charSequence) == null) {
            String obj = charSequence.toString();
            int checkTitleSpanLength = checkTitleSpanLength(obj.length());
            TextView counterTitle = getCounterTitle();
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(checkTitleSpanLength);
            sb.append(WebvttCueParser.CHAR_SLASH);
            sb.append(this.EDIT_INPUT_TITILE_MAX_LENGTH);
            sb.append(')');
            counterTitle.setText(sb.toString());
            if (checkTitleSpanLength > this.EDIT_INPUT_TITILE_MAX_LENGTH) {
                getCounterTitle().setTextColor(SkinManager.getColor(R.color.CAM_X0301));
            } else {
                getCounterTitle().setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
            getViewModel().x(obj, checkTitleSpanLength);
        }
    }

    public final void doPost() {
        Iterator<String> it;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2002016, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("name", "VideoWorkListPage"))));
            WriteData writeData = new WriteData();
            writeData.setVideoInfo(getViewModel().n().getValue());
            String value = getViewModel().l().getValue();
            if (getViewModel().m().getValue() != null) {
                ArrayList<String> value2 = getViewModel().m().getValue();
                Intrinsics.checkNotNull(value2);
                while (value2.iterator().hasNext()) {
                    value = ((Object) value) + '#' + it.next() + '#';
                }
            }
            writeData.setTitle(value);
            writeData.setContent(getViewModel().i().getValue());
            SelectForumData value3 = getViewModel().g().getValue();
            c.a.p0.a4.t0.b bVar = null;
            writeData.setForumId(value3 == null ? null : value3.forumId);
            SelectForumData value4 = getViewModel().g().getValue();
            writeData.setForumName(value4 == null ? null : value4.forumName);
            writeData.setHasLocationData((getViewModel().j().getValue() == null || c.a.p0.a4.p0.b.a().d()) ? false : true);
            writeData.setWork(true);
            writeData.setWorkDraft(this.isDraftData);
            VideoCategoryClassData videoCategoryClassData = new VideoCategoryClassData();
            VideoCategoryClassData value5 = getViewModel().h().getValue();
            videoCategoryClassData.setFirstClass(value5 == null ? null : value5.getFirstClass());
            VideoCategoryClassData value6 = getViewModel().h().getValue();
            videoCategoryClassData.setSecondClass(value6 == null ? null : value6.getSecondClass());
            if (getViewModel().k().getValue() != null) {
                videoCategoryClassData.setTags(getViewModel().k().getValue());
            }
            writeData.setClassAndTagData(videoCategoryClassData);
            String objLocate = WorkPublishManager.getObjLocate();
            if (!(objLocate == null || objLocate.length() == 0)) {
                String objLocate2 = WorkPublishManager.getObjLocate();
                Intrinsics.checkNotNullExpressionValue(objLocate2, "getObjLocate()");
                writeData.setStatisticFrom(Integer.parseInt(objLocate2));
            }
            boolean booleanExtra = getIntent().getBooleanExtra(WorkPublishActivityConfig.NEED_PUBLISH_END_JUMP_HOME, false);
            c.a.p0.a4.t0.b bVar2 = this.mWriteModel;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                bVar2 = null;
            }
            bVar2.H(writeData);
            c.a.p0.a4.t0.b bVar3 = this.mWriteModel;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                bVar3 = null;
            }
            bVar3.F(booleanExtra);
            c.a.p0.a4.t0.b bVar4 = this.mWriteModel;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
            } else {
                bVar = bVar4;
            }
            bVar.I();
            if (booleanExtra) {
                MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2);
                if (UbsABTestHelper.isConcernForumCardShow() && TbadkCoreApplication.isLogin() && c.a.o0.r.j0.b.k().l("key_home_concern_all_status", 0) == 1) {
                    createNormalCfg.setSubTabName(getString(R.string.obfuscated_res_0x7f0f02a8));
                } else {
                    createNormalCfg.setSubTabName(getString(R.string.obfuscated_res_0x7f0f131c));
                }
                createNormalCfg.start();
            } else if (c.a.p0.a4.t0.b.k().i() == null) {
                c.a.p0.a4.t0.b k2 = c.a.p0.a4.t0.b.k();
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

    public final View getContentBottomLine() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            View view = this.contentBottomLine;
            if (view != null) {
                return view;
            }
            Intrinsics.throwUninitializedPropertyAccessException("contentBottomLine");
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final TextView getCounterTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TextView textView = this.counterTitle;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("counterTitle");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final RelativeLayout getEditContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RelativeLayout relativeLayout = this.editContent;
            if (relativeLayout != null) {
                return relativeLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("editContent");
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final SpanGroupEditText getEdtTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.edtTitle;
            if (spanGroupEditText != null) {
                return spanGroupEditText;
            }
            Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            return null;
        }
        return (SpanGroupEditText) invokeV.objValue;
    }

    public final boolean getHasClickedTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.hasClickedTitle : invokeV.booleanValue;
    }

    public final WorkPublishMixVideoView getMixVideoView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            WorkPublishMixVideoView workPublishMixVideoView = this.mixVideoView;
            if (workPublishMixVideoView != null) {
                return workPublishMixVideoView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mixVideoView");
            return null;
        }
        return (WorkPublishMixVideoView) invokeV.objValue;
    }

    public final ViewGroup getMixVideoViewLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ViewGroup viewGroup = this.mixVideoViewLayout;
            if (viewGroup != null) {
                return viewGroup;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mixVideoViewLayout");
            return null;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final View getNavBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            View view = this.navBack;
            if (view != null) {
                return view;
            }
            Intrinsics.throwUninitializedPropertyAccessException("navBack");
            return null;
        }
        return (View) invokeV.objValue;
    }

    public final TextView getNavCenterText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            TextView textView = this.navCenterText;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("navCenterText");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView getNavPost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            TextView textView = this.navPost;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("navPost");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final NavigationBar getNavigationBar() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            NavigationBar navigationBar = this.navigationBar;
            if (navigationBar != null) {
                return navigationBar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
            return null;
        }
        return (NavigationBar) invokeV.objValue;
    }

    public final ViewGroup getRootView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ViewGroup viewGroup = this.rootView;
            if (viewGroup != null) {
                return viewGroup;
            }
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            return null;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final SelectBarView getSelectBarView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            SelectBarView selectBarView = this.selectBarView;
            if (selectBarView != null) {
                return selectBarView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("selectBarView");
            return null;
        }
        return (SelectBarView) invokeV.objValue;
    }

    public final SelectClassView getSelectClassView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            SelectClassView selectClassView = this.selectClassView;
            if (selectClassView != null) {
                return selectClassView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("selectClassView");
            return null;
        }
        return (SelectClassView) invokeV.objValue;
    }

    public final SelectPosView getSelectPosView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            SelectPosView selectPosView = this.selectPosView;
            if (selectPosView != null) {
                return selectPosView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("selectPosView");
            return null;
        }
        return (SelectPosView) invokeV.objValue;
    }

    public final SelectTagView getSelectTagView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            SelectTagView selectTagView = this.selectTagView;
            if (selectTagView != null) {
                return selectTagView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("selectTagView");
            return null;
        }
        return (SelectTagView) invokeV.objValue;
    }

    public final SelectTopicView getSelectTopicView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            SelectTopicView selectTopicView = this.selectTopicView;
            if (selectTopicView != null) {
                return selectTopicView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("selectTopicView");
            return null;
        }
        return (SelectTopicView) invokeV.objValue;
    }

    public final WorkPublishViewModel getViewModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel != null) {
                return workPublishViewModel;
            }
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            return null;
        }
        return (WorkPublishViewModel) invokeV.objValue;
    }

    public final ViewGroup getWorkPublishBg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            ViewGroup viewGroup = this.workPublishBg;
            if (viewGroup != null) {
                return viewGroup;
            }
            Intrinsics.throwUninitializedPropertyAccessException("workPublishBg");
            return null;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final ViewGroup getWorkPublishContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            ViewGroup viewGroup = this.workPublishContainer;
            if (viewGroup != null) {
                return viewGroup;
            }
            Intrinsics.throwUninitializedPropertyAccessException("workPublishContainer");
            return null;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            initNav();
            View findViewById = findViewById(16908290);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
            setRootView((ViewGroup) findViewById);
            View findViewById2 = findViewById(R.id.obfuscated_res_0x7f0922fd);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.videoViewLayout)");
            setMixVideoViewLayout((ViewGroup) findViewById2);
            View findViewById3 = findViewById(R.id.obfuscated_res_0x7f0922fc);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.videoView)");
            setMixVideoView((WorkPublishMixVideoView) findViewById3);
            WorkPublishMixVideoView mixVideoView = getMixVideoView();
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkNotNullExpressionValue(pageContext, "pageContext");
            mixVideoView.setPageContext(pageContext);
            getMixVideoView().setIWorkVideoMixListener(this);
            View findViewById4 = findViewById(R.id.obfuscated_res_0x7f092495);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.work_publish_edtTitle)");
            setEdtTitle((SpanGroupEditText) findViewById4);
            getEdtTitle().setTransLink(false);
            getEdtTitle().setTransAt(false);
            View findViewById5 = findViewById(R.id.obfuscated_res_0x7f09084c);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.edit_content)");
            setEditContent((RelativeLayout) findViewById5);
            View findViewById6 = findViewById(R.id.obfuscated_res_0x7f092492);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.work_publish_bg)");
            setWorkPublishBg((ViewGroup) findViewById6);
            View findViewById7 = findViewById(R.id.obfuscated_res_0x7f092494);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.work_publish_container)");
            setWorkPublishContainer((ViewGroup) findViewById7);
            View findViewById8 = findViewById(R.id.obfuscated_res_0x7f091c6d);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.select_bar_view)");
            setSelectBarView((SelectBarView) findViewById8);
            View findViewById9 = findViewById(R.id.obfuscated_res_0x7f091c70);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.select_class_view)");
            setSelectClassView((SelectClassView) findViewById9);
            View findViewById10 = findViewById(R.id.obfuscated_res_0x7f091c92);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.select_topic_view)");
            setSelectTopicView((SelectTopicView) findViewById10);
            if (WorkAddTopicSwitch.isOn()) {
                getSelectTopicView().setVisibility(0);
            } else {
                getSelectTopicView().setVisibility(8);
            }
            View findViewById11 = findViewById(R.id.obfuscated_res_0x7f091c8c);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.select_tag_view)");
            setSelectTagView((SelectTagView) findViewById11);
            View findViewById12 = findViewById(R.id.obfuscated_res_0x7f091c86);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.select_pos_view)");
            setSelectPosView((SelectPosView) findViewById12);
            getSelectPosView().setOnClickListener(new View.OnClickListener() { // from class: c.a.p0.s4.u.p.q
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        WorkPublishActivity.m71initUI$lambda2(WorkPublishActivity.this, view);
                    }
                }
            });
            getEditContent().setOnClickListener(new View.OnClickListener() { // from class: c.a.p0.s4.u.p.e
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        WorkPublishActivity.m72initUI$lambda3(WorkPublishActivity.this, view);
                    }
                }
            });
            View findViewById13 = findViewById(R.id.obfuscated_res_0x7f091c98);
            Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(R.id.sep_line_content)");
            setContentBottomLine(findViewById13);
            View findViewById14 = findViewById(R.id.obfuscated_res_0x7f092497);
            Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(R.id.work_publish_title_counter)");
            setCounterTitle((TextView) findViewById14);
            View findViewById15 = findViewById(R.id.obfuscated_res_0x7f091c8d);
            Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(R.id.select_topic_layout)");
            this.topicLayout = (SelectTopicLayout) findViewById15;
            getNavigationBar().post(new Runnable() { // from class: c.a.p0.s4.u.p.i
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        WorkPublishActivity.m73initUI$lambda4(WorkPublishActivity.this);
                    }
                }
            });
            SelectTopicLayout selectTopicLayout = this.topicLayout;
            SelectTopicToolBar selectTopicToolBar = null;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.setStateListener(new SelectTopicLayout.f() { // from class: c.a.p0.s4.u.p.c
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.write.write.work.topic.SelectTopicLayout.f
                public final void a(boolean z, boolean z2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                        WorkPublishActivity.m74initUI$lambda5(WorkPublishActivity.this, z, z2);
                    }
                }
            });
            View findViewById16 = findViewById(R.id.obfuscated_res_0x7f09212e);
            Intrinsics.checkNotNullExpressionValue(findViewById16, "findViewById(R.id.topic_tool_layout)");
            this.topicToolLayout = findViewById16;
            View findViewById17 = findViewById(R.id.obfuscated_res_0x7f09212f);
            Intrinsics.checkNotNullExpressionValue(findViewById17, "findViewById(R.id.topic_tool_shadow)");
            this.topicToolShadow = findViewById17;
            View findViewById18 = findViewById(R.id.obfuscated_res_0x7f09212d);
            Intrinsics.checkNotNullExpressionValue(findViewById18, "findViewById(R.id.topic_tool_bar)");
            SelectTopicToolBar selectTopicToolBar2 = (SelectTopicToolBar) findViewById18;
            this.topicToolBar = selectTopicToolBar2;
            if (selectTopicToolBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
                selectTopicToolBar2 = null;
            }
            selectTopicToolBar2.setmFromType(1);
            SelectTopicToolBar selectTopicToolBar3 = this.topicToolBar;
            if (selectTopicToolBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
            } else {
                selectTopicToolBar = selectTopicToolBar3;
            }
            selectTopicToolBar.setOpenTopicLayoutListener(new SelectTopicToolBar.e() { // from class: c.a.p0.s4.u.p.j
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.write.write.work.topic.view.SelectTopicToolBar.e
                public final void onOpen() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        WorkPublishActivity.m75initUI$lambda6(WorkPublishActivity.this);
                    }
                }
            });
            getEdtTitle().addTextChangedListener(this.mWriteTitleTextWatcher);
            getViewModel().o().observe(this, new Observer() { // from class: c.a.p0.s4.u.p.n
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.m76initUI$lambda7(WorkPublishActivity.this, (Boolean) obj);
                    }
                }
            });
            getViewModel().l().observe(this, new Observer() { // from class: c.a.p0.s4.u.p.u
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.m77initUI$lambda9(WorkPublishActivity.this, (String) obj);
                    }
                }
            });
            getViewModel().g().observe(this, new Observer() { // from class: c.a.p0.s4.u.p.h
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.m65initUI$lambda10(WorkPublishActivity.this, (SelectForumData) obj);
                    }
                }
            });
            getViewModel().h().observe(this, new Observer() { // from class: c.a.p0.s4.u.p.a
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.m66initUI$lambda11(WorkPublishActivity.this, (VideoCategoryClassData) obj);
                    }
                }
            });
            getViewModel().k().observe(this, new Observer() { // from class: c.a.p0.s4.u.p.t
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.m67initUI$lambda12(WorkPublishActivity.this, (ArrayList) obj);
                    }
                }
            });
            getViewModel().m().observe(this, new Observer() { // from class: c.a.p0.s4.u.p.l
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.m68initUI$lambda13(WorkPublishActivity.this, (ArrayList) obj);
                    }
                }
            });
            getViewModel().j().observe(this, new Observer() { // from class: c.a.p0.s4.u.p.s
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.m69initUI$lambda14(WorkPublishActivity.this, (ResponsedSelectLocation) obj);
                    }
                }
            });
            getViewModel().n().observe(this, new Observer() { // from class: c.a.p0.s4.u.p.k
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        WorkPublishActivity.m70initUI$lambda15(WorkPublishActivity.this, (VideoInfo) obj);
                    }
                }
            });
        }
    }

    public final c.a.p0.t1.f isVideoHotpic(String content) {
        InterceptResult invokeL;
        c.a.p0.t1.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, content)) == null) {
            Intrinsics.checkNotNullParameter(content, "content");
            if (!TextUtils.isEmpty(content) && (cVar = this.mVideoListData) != null) {
                if (!ListUtils.isEmpty(cVar == null ? null : cVar.c())) {
                    c.a.p0.t1.c cVar2 = this.mVideoListData;
                    List<c.a.p0.t1.f> c2 = cVar2 == null ? null : cVar2.c();
                    if (c2 != null) {
                        int i2 = 0;
                        int size = c2.size() - 1;
                        if (size >= 0) {
                            while (true) {
                                int i3 = i2 + 1;
                                c.a.p0.t1.f fVar = c2.get(i2);
                                if (fVar != null && Intrinsics.areEqual(content, fVar.e())) {
                                    return fVar;
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
        return (c.a.p0.t1.f) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            c.a.o0.r.v.c.d(getWorkPublishBg()).f(R.color.CAM_X0201);
            getNavigationBar().onChangeSkinType(getPageContext(), i2);
            getNavigationBar().getBackImageView().setImageDrawable(WebPManager.getPureDrawable(R.drawable.obfuscated_res_0x7f0809af, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(getNavPost());
            d2.v(R.color.CAM_X0101);
            d2.n(R.string.J_X01);
            d2.f(R.color.CAM_X0302);
            if (Intrinsics.areEqual(getViewModel().o().getValue(), Boolean.FALSE)) {
                getNavPost().setAlpha(0.33f);
                getNavPost().setEnabled(false);
            } else {
                getNavPost().setAlpha(1.0f);
                getNavPost().setEnabled(true);
            }
            getNavCenterText().setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            getSelectBarView().d();
            getSelectPosView().d();
            getSelectClassView().d();
            getSelectTopicView().e();
            getSelectTagView().e();
            SelectTopicToolBar selectTopicToolBar = this.topicToolBar;
            View view = null;
            if (selectTopicToolBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
                selectTopicToolBar = null;
            }
            selectTopicToolBar.g();
            getEdtTitle().setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            getCounterTitle().setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            getEdtTitle().setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            SkinManager.setBackgroundColor(getContentBottomLine(), R.color.CAM_X0210);
            getMixVideoView().f();
            View view2 = this.topicToolShadow;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolShadow");
                view2 = null;
            }
            c.a.o0.r.v.c.d(view2).o(new int[]{R.color.CAM_X0802, R.color.CAM_X0601});
            View view3 = this.topicToolLayout;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolLayout");
            } else {
                view = view3;
            }
            c.a.o0.r.v.c.d(view).f(R.color.CAM_X0207);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d005f);
            setSwipeBackEnabled(false);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            ViewModel viewModel = new ViewModelProvider(this).get(WorkPublishViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…ishViewModel::class.java)");
            setViewModel((WorkPublishViewModel) viewModel);
            LocationModel locationModel = new LocationModel(getPageContext());
            this.mLocationModel = locationModel;
            c.a.p0.a4.t0.b bVar = null;
            if (locationModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                locationModel = null;
            }
            locationModel.Q(this.mOnLocationCallBack);
            c.a.p0.a4.t0.b k2 = c.a.p0.a4.t0.b.k();
            Intrinsics.checkNotNullExpressionValue(k2, "getInstance()");
            this.mWriteModel = k2;
            if (k2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
            } else {
                bVar = k2;
            }
            bVar.p(this);
            initUI();
            initSelectTopicModel();
            registerListener(this.mSelectForumListener);
            registerListener(this.mAddHotpicListener);
            registerListener(this.mOnSelectClassListener);
            registerListener(this.mOnSelectTopicListener);
            registerListener(this.mOnSelectLocationListener);
            registerListener(this.muxerSuccListener);
            registerListener(this.mOnSelectTagListener);
            registerListener(this.mShowCanNotSelectTagToastListener);
            registerListener(this.mCanChangeBarNameToastListener);
            prepareIntent();
            loadData();
            if (getViewModel().n().getValue() != null && !this.isDraftData) {
                StatisticItem statisticItem = new StatisticItem("c14311");
                VideoInfo value = getViewModel().n().getValue();
                Intrinsics.checkNotNull(value);
                TiebaStatic.log(statisticItem.param("obj_source", value.getVideoSource()));
                return;
            }
            TiebaStatic.log(new StatisticItem("c14311").param("obj_source", 0));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            super.onDestroy();
            ValueAnimator valueAnimator = this.editModeAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            c.a.o0.r.t.j jVar = this.saveDraftDialog;
            if (jVar != null) {
                jVar.dismiss();
            }
            this.saveDraftDialog = null;
            stopTask();
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataNoSearchFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            SelectTopicLayout selectTopicLayout = this.topicLayout;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.r(str);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataNoSearchSuccess(c.a.p0.t1.c cVar, c.a.p0.t1.c cVar2, c.a.p0.t1.c cVar3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048603, this, cVar, cVar2, cVar3) == null) {
            if (this.mVideoListData == null) {
                this.mVideoListData = cVar3;
                findAndTransPlainTextVideoHotpic(0);
            } else {
                this.mVideoListData = cVar3;
            }
            SelectTopicLayout selectTopicLayout = this.topicLayout;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.s(cVar, cVar2, cVar3);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataSearchFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            SelectTopicLayout selectTopicLayout = this.topicLayout;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.t(str);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataSearchSuccess(c.a.p0.t1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, cVar) == null) {
            SelectTopicLayout selectTopicLayout = this.topicLayout;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                selectTopicLayout = null;
            }
            selectTopicLayout.u(cVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048606, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                SelectTopicLayout selectTopicLayout = this.topicLayout;
                SelectTopicLayout selectTopicLayout2 = null;
                if (selectTopicLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                    selectTopicLayout = null;
                }
                if (selectTopicLayout.q()) {
                    SelectTopicLayout selectTopicLayout3 = this.topicLayout;
                    if (selectTopicLayout3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                    } else {
                        selectTopicLayout2 = selectTopicLayout3;
                    }
                    selectTopicLayout2.i();
                    return true;
                }
                popupSaveDraftDialog();
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.keyboardVisibility = z;
            onTitleEditModeChange();
        }
    }

    public final void onLocViewClickedInInitState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            LocationModel locationModel = this.mLocationModel;
            LocationModel locationModel2 = null;
            if (locationModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                locationModel = null;
            }
            if (!locationModel.G(getPageContext().getPageActivity())) {
                showToast(R.string.obfuscated_res_0x7f0f0a45);
            } else if (!TbadkCoreApplication.getInst().getLocationShared()) {
                showLocPermissionDialog();
            } else {
                LocationModel locationModel3 = this.mLocationModel;
                if (locationModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                    locationModel3 = null;
                }
                if (locationModel3.F()) {
                    goToSelectLocationActivity();
                    return;
                }
                LocationModel locationModel4 = this.mLocationModel;
                if (locationModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                    locationModel4 = null;
                }
                locationModel4.P(false);
                LocationModel locationModel5 = this.mLocationModel;
                if (locationModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                } else {
                    locationModel2 = locationModel5;
                }
                locationModel2.L();
            }
        }
    }

    public void onMixFail() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            showToastWithDefaultIcon(getString(R.string.obfuscated_res_0x7f0f1596), BdToast.DefaultIcon.FAILURE);
        }
    }

    @Override // c.a.p0.s4.u.p.x.a
    public void onMixStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            getViewModel().w(i2);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, intent) == null) {
            super.onNewIntent(intent);
            Serializable serializableExtra = intent == null ? null : intent.getSerializableExtra(WorkPublishActivityConfig.PARAM_VIDEO_INFO);
            if (serializableExtra instanceof VideoInfo) {
                getViewModel().y((VideoInfo) serializableExtra);
            }
        }
    }

    public final void popupSaveDraftDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            if (this.saveDraftDialogView == null) {
                this.saveDraftDialogView = new SaveDraftDialogView(this);
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: c.a.p0.s4.u.p.g
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            WorkPublishActivity.m79popupSaveDraftDialog$lambda22(WorkPublishActivity.this, view);
                        }
                    }
                };
                SaveDraftDialogView saveDraftDialogView = this.saveDraftDialogView;
                Intrinsics.checkNotNull(saveDraftDialogView);
                saveDraftDialogView.setOnClickListener(onClickListener);
            }
            if (this.saveDraftDialog == null) {
                c.a.o0.r.t.j jVar = new c.a.o0.r.t.j(getPageContext());
                this.saveDraftDialog = jVar;
                Intrinsics.checkNotNull(jVar);
                jVar.setContentView(this.saveDraftDialogView);
            }
            boolean d2 = getViewModel().d();
            SaveDraftDialogView saveDraftDialogView2 = this.saveDraftDialogView;
            Intrinsics.checkNotNull(saveDraftDialogView2);
            saveDraftDialogView2.setButtonTag(R.id.obfuscated_res_0x7f091002, Boolean.valueOf(d2));
            SaveDraftDialogView saveDraftDialogView3 = this.saveDraftDialogView;
            Intrinsics.checkNotNull(saveDraftDialogView3);
            saveDraftDialogView3.setCancelVisible(d2 ? 0 : 8);
            SaveDraftDialogView saveDraftDialogView4 = this.saveDraftDialogView;
            Intrinsics.checkNotNull(saveDraftDialogView4);
            saveDraftDialogView4.setText(getString(d2 ? R.string.obfuscated_res_0x7f0f1589 : R.string.obfuscated_res_0x7f0f158a), null, getString(d2 ? R.string.obfuscated_res_0x7f0f105d : R.string.obfuscated_res_0x7f0f158c), getString(d2 ? R.string.obfuscated_res_0x7f0f0c7a : R.string.obfuscated_res_0x7f0f158b));
            c.a.o0.r.t.j jVar2 = this.saveDraftDialog;
            Intrinsics.checkNotNull(jVar2);
            jVar2.m();
        }
    }

    public final void setContentBottomLine(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, view) == null) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.contentBottomLine = view;
        }
    }

    public final void setCounterTitle(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.counterTitle = textView;
        }
    }

    public final void setEditContent(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, relativeLayout) == null) {
            Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
            this.editContent = relativeLayout;
        }
    }

    public final void setEdtTitle(SpanGroupEditText spanGroupEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, spanGroupEditText) == null) {
            Intrinsics.checkNotNullParameter(spanGroupEditText, "<set-?>");
            this.edtTitle = spanGroupEditText;
        }
    }

    public final void setHasClickedTitle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048617, this, z) == null) {
            this.hasClickedTitle = z;
        }
    }

    public final void setMixVideoView(WorkPublishMixVideoView workPublishMixVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, workPublishMixVideoView) == null) {
            Intrinsics.checkNotNullParameter(workPublishMixVideoView, "<set-?>");
            this.mixVideoView = workPublishMixVideoView;
        }
    }

    public final void setMixVideoViewLayout(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, viewGroup) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.mixVideoViewLayout = viewGroup;
        }
    }

    public final void setNavBack(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, view) == null) {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.navBack = view;
        }
    }

    public final void setNavCenterText(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.navCenterText = textView;
        }
    }

    public final void setNavPost(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.navPost = textView;
        }
    }

    public final void setNavigationBar(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, navigationBar) == null) {
            Intrinsics.checkNotNullParameter(navigationBar, "<set-?>");
            this.navigationBar = navigationBar;
        }
    }

    public final void setRootView(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, viewGroup) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.rootView = viewGroup;
        }
    }

    public final void setSelectBarView(SelectBarView selectBarView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, selectBarView) == null) {
            Intrinsics.checkNotNullParameter(selectBarView, "<set-?>");
            this.selectBarView = selectBarView;
        }
    }

    public final void setSelectClassView(SelectClassView selectClassView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, selectClassView) == null) {
            Intrinsics.checkNotNullParameter(selectClassView, "<set-?>");
            this.selectClassView = selectClassView;
        }
    }

    public final void setSelectPosView(SelectPosView selectPosView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, selectPosView) == null) {
            Intrinsics.checkNotNullParameter(selectPosView, "<set-?>");
            this.selectPosView = selectPosView;
        }
    }

    public final void setSelectTagView(SelectTagView selectTagView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, selectTagView) == null) {
            Intrinsics.checkNotNullParameter(selectTagView, "<set-?>");
            this.selectTagView = selectTagView;
        }
    }

    public final void setSelectTopicView(SelectTopicView selectTopicView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, selectTopicView) == null) {
            Intrinsics.checkNotNullParameter(selectTopicView, "<set-?>");
            this.selectTopicView = selectTopicView;
        }
    }

    public final void setViewModel(WorkPublishViewModel workPublishViewModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, workPublishViewModel) == null) {
            Intrinsics.checkNotNullParameter(workPublishViewModel, "<set-?>");
            this.viewModel = workPublishViewModel;
        }
    }

    public final void setWorkPublishBg(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, viewGroup) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.workPublishBg = viewGroup;
        }
    }

    public final void setWorkPublishContainer(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, viewGroup) == null) {
            Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
            this.workPublishContainer = viewGroup;
        }
    }

    public final void stopTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            c.a.p0.a4.t0.b bVar = this.mWriteModel;
            HotTopicSelectModel hotTopicSelectModel = null;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                bVar = null;
            }
            bVar.t();
            LocationModel locationModel = this.mLocationModel;
            if (locationModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
                locationModel = null;
            }
            locationModel.cancelLoadData();
            WorkPublishMixVideoView mixVideoView = getMixVideoView();
            if (mixVideoView != null) {
                mixVideoView.g();
            }
            HotTopicSelectModel hotTopicSelectModel2 = this.mHotModel;
            if (hotTopicSelectModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
            } else {
                hotTopicSelectModel = hotTopicSelectModel2;
            }
            hotTopicSelectModel.onDestroy();
        }
    }
}
