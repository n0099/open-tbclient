package com.baidu.tieba.write.write.work;

import GetSugTopic.TopicList;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import b.a.q0.s.q.n2;
import b.a.q0.s.s.a;
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
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.PopupDialog;
import com.baidu.tbadk.core.elementsMaven.span.EMRichTextAnyIconSpan;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
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
import com.baidu.tbadk.data.VideoCategoryClassData;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tbadk.switchs.WorkAddTopicSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.tieba.hottopicselect.HotTopicSelectModel;
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
import com.baidu.tieba.write.write.work.topic.SelectTopicLayout;
import com.baidu.tieba.write.write.work.topic.SelectTopicModel;
import com.baidu.tieba.write.write.work.topic.view.SelectTopicToolBar;
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
import java.util.List;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\b¢\u0006\u0005\b\u008f\u0002\u0010\nJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0013\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\nJ\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\nJ\r\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\nJ\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\nJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001d\u0010\u000eJ\u0019\u0010 \u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0014¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\bH\u0014¢\u0006\u0004\b\"\u0010\nJ\u0019\u0010$\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b$\u0010%J-\u0010*\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010(\u001a\u0004\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b*\u0010+J\u0019\u0010,\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b,\u0010%J\u0019\u0010.\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b.\u0010/J!\u00104\u001a\u0002032\u0006\u00100\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\b2\u0006\u00106\u001a\u000203H\u0014¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\b¢\u0006\u0004\b9\u0010\nJ\u000f\u0010:\u001a\u00020\bH\u0016¢\u0006\u0004\b:\u0010\nJ\u0017\u0010<\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u0004H\u0016¢\u0006\u0004\b<\u0010\u000eJ\u0019\u0010?\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010=H\u0014¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\bH\u0002¢\u0006\u0004\bA\u0010\nJ\u000f\u0010B\u001a\u00020\bH\u0002¢\u0006\u0004\bB\u0010\nJ\u0019\u0010D\u001a\u00020\b2\b\b\u0002\u0010C\u001a\u000203H\u0002¢\u0006\u0004\bD\u00108J\r\u0010E\u001a\u00020\b¢\u0006\u0004\bE\u0010\nJ\u000f\u0010F\u001a\u00020\bH\u0002¢\u0006\u0004\bF\u0010\nJ\u000f\u0010G\u001a\u00020\bH\u0002¢\u0006\u0004\bG\u0010\nJ\u000f\u0010H\u001a\u00020\bH\u0002¢\u0006\u0004\bH\u0010\nJ\r\u0010I\u001a\u00020\b¢\u0006\u0004\bI\u0010\nJ'\u0010N\u001a\u00020\b2\u0006\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u0004H\u0002¢\u0006\u0004\bN\u0010OJ\u0017\u0010P\u001a\u00020\b2\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bP\u0010QR\u0016\u0010R\u001a\u00020\u00048\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\bR\u0010SR\"\u0010U\u001a\u00020T8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010\\\u001a\u00020[8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010SR\u0016\u0010c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010SR\"\u0010e\u001a\u00020d8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u0018\u0010l\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\"\u0010o\u001a\u00020n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\"\u0010u\u001a\u0002038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bu\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u00108R\u0016\u0010z\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010vR\u0016\u0010{\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010vR\u0016\u0010|\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010vR\u0016\u0010}\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010vR\u0017\u0010\u007f\u001a\u00020~8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0019\u0010\u0081\u0001\u001a\u00020~8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0080\u0001R\u001a\u0010\u0083\u0001\u001a\u00030\u0082\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u001a\u0010\u0086\u0001\u001a\u00030\u0085\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001a\u0010\u0089\u0001\u001a\u00030\u0088\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0018\u0010\u008b\u0001\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008b\u0001\u0010vR\u001a\u0010\u008d\u0001\u001a\u00030\u008c\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0019\u0010\u008f\u0001\u001a\u00020~8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0080\u0001R\u0019\u0010\u0090\u0001\u001a\u00020~8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0080\u0001R\u0019\u0010\u0091\u0001\u001a\u00020~8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0080\u0001R\u0019\u0010\u0092\u0001\u001a\u00020~8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0080\u0001R\u0019\u0010\u0093\u0001\u001a\u00020~8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0080\u0001R\u0019\u0010\u0094\u0001\u001a\u00020~8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0080\u0001R\u0019\u0010\u0095\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001b\u0010\u0097\u0001\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001b\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u001a\u0010\u009c\u0001\u001a\u00030\u009b\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001a\u0010\u009f\u0001\u001a\u00030\u009e\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R*\u0010¢\u0001\u001a\u00030¡\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b¢\u0001\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R\u0018\u0010¨\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¨\u0001\u0010SR*\u0010ª\u0001\u001a\u00030©\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\bª\u0001\u0010«\u0001\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0006\b®\u0001\u0010¯\u0001R\u0019\u0010°\u0001\u001a\u00020~8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b°\u0001\u0010\u0080\u0001R&\u0010±\u0001\u001a\u00020T8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b±\u0001\u0010V\u001a\u0005\b²\u0001\u0010X\"\u0005\b³\u0001\u0010ZR&\u0010´\u0001\u001a\u00020[8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b´\u0001\u0010]\u001a\u0005\bµ\u0001\u0010_\"\u0005\b¶\u0001\u0010aR&\u0010·\u0001\u001a\u00020[8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\b·\u0001\u0010]\u001a\u0005\b¸\u0001\u0010_\"\u0005\b¹\u0001\u0010aR*\u0010»\u0001\u001a\u00030º\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b»\u0001\u0010¼\u0001\u001a\u0006\b½\u0001\u0010¾\u0001\"\u0006\b¿\u0001\u0010À\u0001R*\u0010Á\u0001\u001a\u00030©\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\bÁ\u0001\u0010«\u0001\u001a\u0006\bÂ\u0001\u0010\u00ad\u0001\"\u0006\bÃ\u0001\u0010¯\u0001R\u001c\u0010Å\u0001\u001a\u0005\u0018\u00010Ä\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R\u001c\u0010È\u0001\u001a\u0005\u0018\u00010Ç\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010É\u0001R*\u0010Ë\u0001\u001a\u00030Ê\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\bË\u0001\u0010Ì\u0001\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R*\u0010Ò\u0001\u001a\u00030Ñ\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\bÒ\u0001\u0010Ó\u0001\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001R*\u0010Ù\u0001\u001a\u00030Ø\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\bÙ\u0001\u0010Ú\u0001\u001a\u0006\bÛ\u0001\u0010Ü\u0001\"\u0006\bÝ\u0001\u0010Þ\u0001R*\u0010à\u0001\u001a\u00030ß\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\bà\u0001\u0010á\u0001\u001a\u0006\bâ\u0001\u0010ã\u0001\"\u0006\bä\u0001\u0010å\u0001R\u001a\u0010ç\u0001\u001a\u00030æ\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bç\u0001\u0010è\u0001R*\u0010ê\u0001\u001a\u00030é\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\bê\u0001\u0010ë\u0001\u001a\u0006\bì\u0001\u0010í\u0001\"\u0006\bî\u0001\u0010ï\u0001R&\u0010ð\u0001\u001a\u00020[8\u0006@\u0006X\u0086.¢\u0006\u0015\n\u0005\bð\u0001\u0010]\u001a\u0005\bñ\u0001\u0010_\"\u0005\bò\u0001\u0010aR*\u0010ô\u0001\u001a\u00030ó\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\bô\u0001\u0010õ\u0001\u001a\u0006\bö\u0001\u0010÷\u0001\"\u0006\bø\u0001\u0010ù\u0001R\u001a\u0010û\u0001\u001a\u00030ú\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bû\u0001\u0010ü\u0001R\u001a\u0010þ\u0001\u001a\u00030ý\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bþ\u0001\u0010ÿ\u0001R\u0018\u0010\u0080\u0002\u001a\u00020T8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u0080\u0002\u0010VR\u0018\u0010\u0081\u0002\u001a\u00020T8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\b\u0081\u0002\u0010VR*\u0010\u0083\u0002\u001a\u00030\u0082\u00028\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u0083\u0002\u0010\u0084\u0002\u001a\u0006\b\u0085\u0002\u0010\u0086\u0002\"\u0006\b\u0087\u0002\u0010\u0088\u0002R*\u0010\u0089\u0002\u001a\u00030©\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u0089\u0002\u0010«\u0001\u001a\u0006\b\u008a\u0002\u0010\u00ad\u0001\"\u0006\b\u008b\u0002\u0010¯\u0001R*\u0010\u008c\u0002\u001a\u00030©\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\b\u008c\u0002\u0010«\u0001\u001a\u0006\b\u008d\u0002\u0010\u00ad\u0001\"\u0006\b\u008e\u0002\u0010¯\u0001¨\u0006\u0090\u0002"}, d2 = {"Lcom/baidu/tieba/write/write/work/WorkPublishActivity;", "Lb/a/r0/d4/u/p/c/a;", "com/baidu/tieba/hottopicselect/HotTopicSelectModel$c", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "", "lenght", "checkTitleSpanLength", "(I)I", "", "clearDraft", "()V", "doPost", "end", "findAndTransPlainTextVideoHotpic", "(I)V", "getFormData", "getTopicData", "getWriteData", "goToSelectLocationActivity", "initNav", "initSelectTopicModel", "initUI", "", "content", "Lcom/baidu/tieba/hottopicselect/TopicListData;", "isVideoHotpic", "(Ljava/lang/String;)Lcom/baidu/tieba/hottopicselect/TopicListData;", "loadData", WriteMulitImageActivityConfig.SKIN_TYPE, "onChangeSkinType", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", MissionEvent.MESSAGE_DESTROY, "errormsg", "onHotSelectDataNoSearchFailed", "(Ljava/lang/String;)V", "Lcom/baidu/tieba/hottopicselect/HotTopicSelectGroupData;", "user", "bang", "video", "onHotSelectDataNoSearchSuccess", "(Lcom/baidu/tieba/hottopicselect/HotTopicSelectGroupData;Lcom/baidu/tieba/hottopicselect/HotTopicSelectGroupData;Lcom/baidu/tieba/hottopicselect/HotTopicSelectGroupData;)V", "onHotSelectDataSearchFailed", "sug", "onHotSelectDataSearchSuccess", "(Lcom/baidu/tieba/hottopicselect/HotTopicSelectGroupData;)V", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKeyDown", "(ILandroid/view/KeyEvent;)Z", "isVisible", "onKeyboardVisibilityChanged", "(Z)V", "onLocViewClickedInInitState", "onMixFail", "status", "onMixStateChanged", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "onTitleEditModeChange", "onTopicBarVisibilityChange", "fromEdit", "openSelectTopicLayout", "popupSaveDraftDialog", "prepareIntent", "processSaveDraft", "showLocPermissionDialog", "stopTask", "", "s", "start", "count", "tryOpenSelectTopicLayout", "(Ljava/lang/CharSequence;II)V", "updateTitleLimit", "(Ljava/lang/CharSequence;)V", "EDIT_INPUT_TITILE_MAX_LENGTH", "I", "Landroid/view/View;", "contentBottomLine", "Landroid/view/View;", "getContentBottomLine", "()Landroid/view/View;", "setContentBottomLine", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "counterTitle", "Landroid/widget/TextView;", "getCounterTitle", "()Landroid/widget/TextView;", "setCounterTitle", "(Landroid/widget/TextView;)V", "curMixVideoViewHeight", "draftType", "Landroid/widget/RelativeLayout;", "editContent", "Landroid/widget/RelativeLayout;", "getEditContent", "()Landroid/widget/RelativeLayout;", "setEditContent", "(Landroid/widget/RelativeLayout;)V", "Landroid/animation/ValueAnimator;", "editModeAnimator", "Landroid/animation/ValueAnimator;", "Lcom/baidu/tbadk/core/view/spanGroup/SpanGroupEditText;", "edtTitle", "Lcom/baidu/tbadk/core/view/spanGroup/SpanGroupEditText;", "getEdtTitle", "()Lcom/baidu/tbadk/core/view/spanGroup/SpanGroupEditText;", "setEdtTitle", "(Lcom/baidu/tbadk/core/view/spanGroup/SpanGroupEditText;)V", "hasClickedTitle", "Z", "getHasClickedTitle", "()Z", "setHasClickedTitle", "isDraftData", "isNeedCleanTag", "isTitleEditMode", "keyboardVisibility", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mAddHotpicListener", "Lcom/baidu/adp/framework/listener/CustomMessageListener;", "mCanChangeBarNameToastListener", "Lcom/baidu/tieba/write/write/HighLightController;", "mHighLightController", "Lcom/baidu/tieba/write/write/HighLightController;", "Lcom/baidu/tieba/hottopicselect/HotTopicSelectModel;", "mHotModel", "Lcom/baidu/tieba/hottopicselect/HotTopicSelectModel;", "Lcom/baidu/tieba/tbadkCore/location/LocationModel;", "mLocationModel", "Lcom/baidu/tieba/tbadkCore/location/LocationModel;", "mNeedDeleteLast", "Lcom/baidu/tieba/tbadkCore/location/LocationModel$OnLocationCallBack;", "mOnLocationCallBack", "Lcom/baidu/tieba/tbadkCore/location/LocationModel$OnLocationCallBack;", "mOnSelectClassListener", "mOnSelectLocationListener", "mOnSelectTagListener", "mOnSelectTopicListener", "mSelectForumListener", "mShowCanNotSelectTagToastListener", "mTitleTemp", "Ljava/lang/String;", "mVideoListData", "Lcom/baidu/tieba/hottopicselect/HotTopicSelectGroupData;", "mVideoSelectData", "Lcom/baidu/tieba/hottopicselect/TopicListData;", "Lcom/baidu/tieba/tbadkCore/writeModel/AsyncWriteHelper;", "mWriteModel", "Lcom/baidu/tieba/tbadkCore/writeModel/AsyncWriteHelper;", "Landroid/text/TextWatcher;", "mWriteTitleTextWatcher", "Landroid/text/TextWatcher;", "Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;", "mixVideoView", "Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;", "getMixVideoView", "()Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;", "setMixVideoView", "(Lcom/baidu/tieba/write/write/work/videoview/WorkPublishMixVideoView;)V", "mixVideoViewHeight", "Landroid/view/ViewGroup;", "mixVideoViewLayout", "Landroid/view/ViewGroup;", "getMixVideoViewLayout", "()Landroid/view/ViewGroup;", "setMixVideoViewLayout", "(Landroid/view/ViewGroup;)V", "muxerSuccListener", "navBack", "getNavBack", "setNavBack", "navCenterText", "getNavCenterText", "setNavCenterText", "navPost", "getNavPost", "setNavPost", "Lcom/baidu/tbadk/core/view/NavigationBar;", "navigationBar", "Lcom/baidu/tbadk/core/view/NavigationBar;", "getNavigationBar", "()Lcom/baidu/tbadk/core/view/NavigationBar;", "setNavigationBar", "(Lcom/baidu/tbadk/core/view/NavigationBar;)V", "rootView", "getRootView", "setRootView", "Lcom/baidu/tbadk/core/dialog/PopupDialog;", "saveDraftDialog", "Lcom/baidu/tbadk/core/dialog/PopupDialog;", "Lcom/baidu/tbadk/core/view/SaveDraftDialogView;", "saveDraftDialogView", "Lcom/baidu/tbadk/core/view/SaveDraftDialogView;", "Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;", "selectBarView", "Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;", "getSelectBarView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;", "setSelectBarView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectBarView;)V", "Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;", "selectClassView", "Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;", "getSelectClassView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;", "setSelectClassView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectClassView;)V", "Lcom/baidu/tieba/write/write/work/selectview/SelectPosView;", "selectPosView", "Lcom/baidu/tieba/write/write/work/selectview/SelectPosView;", "getSelectPosView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectPosView;", "setSelectPosView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectPosView;)V", "Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;", "selectTagView", "Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;", "getSelectTagView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;", "setSelectTagView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectTagView;)V", "Lcom/baidu/tieba/write/write/work/topic/SelectTopicModel;", "selectTopicModel", "Lcom/baidu/tieba/write/write/work/topic/SelectTopicModel;", "Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;", "selectTopicView", "Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;", "getSelectTopicView", "()Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;", "setSelectTopicView", "(Lcom/baidu/tieba/write/write/work/selectview/SelectTopicView;)V", "showTitle", "getShowTitle", "setShowTitle", "Landroid/widget/ImageView;", "titleSign", "Landroid/widget/ImageView;", "getTitleSign", "()Landroid/widget/ImageView;", "setTitleSign", "(Landroid/widget/ImageView;)V", "Lcom/baidu/tieba/write/write/work/topic/SelectTopicLayout;", "topicLayout", "Lcom/baidu/tieba/write/write/work/topic/SelectTopicLayout;", "Lcom/baidu/tieba/write/write/work/topic/view/SelectTopicToolBar;", "topicToolBar", "Lcom/baidu/tieba/write/write/work/topic/view/SelectTopicToolBar;", "topicToolLayout", "topicToolShadow", "Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "viewModel", "Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "getViewModel", "()Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;", "setViewModel", "(Lcom/baidu/tieba/write/write/work/model/WorkPublishViewModel;)V", "workPublishBg", "getWorkPublishBg", "setWorkPublishBg", "workPublishContainer", "getWorkPublishContainer", "setWorkPublishContainer", "<init>", "write_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class WorkPublishActivity extends BaseFragmentActivity implements b.a.r0.d4.u.p.c.a, HotTopicSelectModel.c {
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
    public final b.a.r0.d4.u.c mHighLightController;
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
    public b.a.r0.k1.c mVideoListData;
    public b.a.r0.k1.f mVideoSelectData;
    public b.a.r0.l3.s0.g mWriteModel;
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
    public PopupDialog saveDraftDialog;
    public SaveDraftDialogView saveDraftDialogView;
    public SelectBarView selectBarView;
    public SelectClassView selectClassView;
    public SelectPosView selectPosView;
    public SelectTagView selectTagView;
    public SelectTopicModel selectTopicModel;
    public SelectTopicView selectTopicView;
    public TextView showTitle;
    public ImageView titleSign;
    public SelectTopicLayout topicLayout;
    public SelectTopicToolBar topicToolBar;
    public View topicToolLayout;
    public View topicToolShadow;
    public WorkPublishViewModel viewModel;
    public ViewGroup workPublishBg;
    public ViewGroup workPublishContainer;

    /* loaded from: classes10.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f56179e;

        public a(Ref.ObjectRef objectRef) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {objectRef};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56179e = objectRef;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921633, (b.a.r0.k1.f) this.f56179e.element));
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class a0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56180a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(WorkPublishActivity workPublishActivity, int i2) {
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
            this.f56180a = workPublishActivity;
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
                    new BdTopToast(this.f56180a.getBaseContext()).setIcon(false).setContent(this.f56180a.getResources().getString(R.string.can_not_select_tag)).show(this.f56180a.getNavigationBar());
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56181e;

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
            this.f56181e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (WorkPublishActivity.access$getTopicLayout$p(this.f56181e).isOpen()) {
                    WorkPublishActivity.access$getTopicLayout$p(this.f56181e).close();
                } else {
                    this.f56181e.popupSaveDraftDialog();
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class b0 implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f56182e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56183f;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b0(WorkPublishActivity workPublishActivity) {
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
            this.f56183f = workPublishActivity;
            this.f56182e = "";
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f56183f.getEdtTitle() == null || this.f56183f.getEdtTitle().getText() == null) {
                return;
            }
            if (this.f56183f.mTitleTemp != null && Intrinsics.areEqual(this.f56183f.mTitleTemp, editable.toString())) {
                this.f56183f.getEdtTitle().setSelection(this.f56183f.getEdtTitle().getSelectionEnd());
                return;
            }
            WorkPublishActivity workPublishActivity = this.f56183f;
            workPublishActivity.mTitleTemp = String.valueOf(workPublishActivity.getEdtTitle().getText());
            this.f56183f.findAndTransPlainTextVideoHotpic(0);
            if (this.f56183f.mHighLightController != null) {
                this.f56183f.mHighLightController.h(this.f56183f.getEdtTitle());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                String obj = charSequence.toString();
                if (obj == null) {
                    obj = "";
                }
                this.f56182e = obj;
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
                String str = this.f56182e;
                int length = str != null ? str.length() : 0;
                String obj = charSequence.toString();
                if ((obj != null ? Integer.valueOf(obj.length()) : null).intValue() > length) {
                    this.f56183f.tryOpenSelectTopicLayout(charSequence, i2, i4);
                }
                this.f56183f.updateTitleLimit(charSequence);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56184e;

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
            this.f56184e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (WorkPublishActivity.access$getTopicLayout$p(this.f56184e).isOpen()) {
                    WorkPublishActivity.access$getTopicLayout$p(this.f56184e).close();
                } else if (this.f56184e.getNavPost().getAlpha() == 1.0f) {
                    this.f56184e.doPost();
                    b.a.r0.k1.f fVar = this.f56184e.mVideoSelectData;
                    if (fVar == null || !fVar.i()) {
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_WORK_VIDEO_HAS_TOPIC);
                    Long b2 = fVar.b();
                    Intrinsics.checkExpressionValueIsNotNull(b2, "it.topicId");
                    statisticItem.param("topic_id", b2.longValue());
                    statisticItem.param(IntentConfig.IS_VIDEO_TOPIC, "1");
                    TiebaStatic.log(statisticItem);
                } else if (this.f56184e.getNavPost().getAlpha() == 0.33f) {
                    WorkPublishActivity workPublishActivity = this.f56184e;
                    if (workPublishActivity.checkTitleSpanLength(String.valueOf(workPublishActivity.getEdtTitle().getText()).length()) < 5) {
                        new BdTopToast(this.f56184e).setIcon(false).setContent(this.f56184e.getString(R.string.work_publish_title_too_short)).show(this.f56184e.getRootView());
                    }
                    WorkPublishActivity workPublishActivity2 = this.f56184e;
                    if (workPublishActivity2.checkTitleSpanLength(String.valueOf(workPublishActivity2.getEdtTitle().getText()).length()) > this.f56184e.EDIT_INPUT_TITILE_MAX_LENGTH) {
                        new BdTopToast(this.f56184e).setIcon(false).setContent(this.f56184e.getString(R.string.work_publish_title_too_long)).show(this.f56184e.getRootView());
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class c0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56185a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(WorkPublishActivity workPublishActivity, int i2) {
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
            this.f56185a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof VideoInfo)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    this.f56185a.getViewModel().updateVideo((VideoInfo) data);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.tbadk.coreExtra.data.VideoInfo");
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56186e;

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
            this.f56186e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && WorkPublishActivity.access$getTopicLayout$p(this.f56186e).isOpen()) {
                WorkPublishActivity.access$getTopicLayout$p(this.f56186e).close();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class d0 implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56187e;

        public d0(WorkPublishActivity workPublishActivity) {
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
            this.f56187e = workPublishActivity;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                WorkPublishActivity workPublishActivity = this.f56187e;
                Intrinsics.checkExpressionValueIsNotNull(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                if (animatedValue != null) {
                    workPublishActivity.curMixVideoViewHeight = ((Integer) animatedValue).intValue();
                    this.f56187e.getMixVideoViewLayout().getLayoutParams().height = this.f56187e.curMixVideoViewHeight;
                    this.f56187e.getMixVideoViewLayout().setPadding(0, this.f56187e.curMixVideoViewHeight - this.f56187e.mixVideoViewHeight, 0, 0);
                    this.f56187e.getMixVideoViewLayout().requestLayout();
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class e implements SelectTopicModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56188a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
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
            this.f56188a = workPublishActivity;
        }

        @Override // com.baidu.tieba.write.write.work.topic.SelectTopicModel.b
        public void a(List<b.a.r0.k1.f> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                WorkPublishActivity.access$getTopicToolBar$p(this.f56188a).bindData(list);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class e0 implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56189e;

        public e0(WorkPublishActivity workPublishActivity) {
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
            this.f56189e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View v) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
                PopupDialog popupDialog = this.f56189e.saveDraftDialog;
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
                                this.f56189e.clearDraft();
                            }
                            this.f56189e.setResult(100);
                            this.f56189e.finish();
                            return;
                        } else if (id != R.id.save_draft_dialog_save) {
                            if (id == R.id.save_draft_dialog_cancle && booleanValue) {
                                TiebaStatic.log(new StatisticItem("c14260").param("obj_locate", 0));
                                return;
                            }
                            return;
                        } else if (booleanValue) {
                            TiebaStatic.log(new StatisticItem("c14260").param("obj_locate", 1));
                            this.f56189e.processSaveDraft();
                            this.f56189e.setResult(100);
                            this.f56189e.finish();
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

    /* loaded from: classes10.dex */
    public static final class f<T> implements Observer<ArrayList<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56190e;

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
            this.f56190e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(ArrayList<String> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                SelectTagView selectTagView = this.f56190e.getSelectTagView();
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                selectTagView.bindData(it);
                this.f56190e.getSelectClassView().setMIsSelectedTags(!it.isEmpty());
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class f0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56191e;

        public f0(WorkPublishActivity workPublishActivity) {
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
            this.f56191e = workPublishActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public final void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (!b.a.e.e.p.j.z()) {
                    this.f56191e.mOnLocationCallBack.a();
                } else {
                    WorkPublishActivity.access$getMLocationModel$p(this.f56191e).L();
                }
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class g<T> implements Observer<ArrayList<String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56192e;

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
            this.f56192e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(ArrayList<String> it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                SelectTopicView selectTopicView = this.f56192e.getSelectTopicView();
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                selectTopicView.bindData(it);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class g0 implements a.e {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: e  reason: collision with root package name */
        public static final g0 f56193e;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2120499339, "Lcom/baidu/tieba/write/write/work/WorkPublishActivity$g0;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2120499339, "Lcom/baidu/tieba/write/write/work/WorkPublishActivity$g0;");
                    return;
                }
            }
            f56193e = new g0();
        }

        public g0() {
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

        @Override // b.a.q0.s.s.a.e
        public final void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class h<T> implements Observer<ResponsedSelectLocation> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56194e;

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
            this.f56194e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(ResponsedSelectLocation responsedSelectLocation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedSelectLocation) == null) {
                this.f56194e.getSelectPosView().bindData(responsedSelectLocation);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class i<T> implements Observer<VideoInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56195e;

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
            this.f56195e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(VideoInfo videoInfo) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, videoInfo) == null) || videoInfo == null) {
                return;
            }
            this.f56195e.getMixVideoView().setVideoInfo(videoInfo, false);
        }
    }

    /* loaded from: classes10.dex */
    public static final class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56196e;

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
            this.f56196e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f56196e.onLocViewClickedInInitState();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56197e;

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
            this.f56197e = workPublishActivity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                b.a.e.e.p.l.K(TbadkCoreApplication.getInst(), this.f56197e.getEdtTitle());
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56198e;

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
            this.f56198e = workPublishActivity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WorkPublishActivity.access$getTopicLayout$p(this.f56198e).setTitlePlaceholderHeight(this.f56198e.getNavigationBar().getHeight() + b.a.e.e.p.l.g(this.f56198e, R.dimen.tbds254));
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class m implements SelectTopicLayout.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56199a;

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
            this.f56199a = workPublishActivity;
        }

        @Override // com.baidu.tieba.write.write.work.topic.SelectTopicLayout.f
        public final void a(boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                this.f56199a.onTitleEditModeChange();
                if (z || !z2) {
                    return;
                }
                this.f56199a.getEdtTitle().setFocusable(true);
                this.f56199a.getEdtTitle().setFocusableInTouchMode(true);
                this.f56199a.getEdtTitle().requestFocus();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class n implements SelectTopicToolBar.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56200a;

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
            this.f56200a = workPublishActivity;
        }

        @Override // com.baidu.tieba.write.write.work.topic.view.SelectTopicToolBar.e
        public final void onOpen() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WorkPublishActivity.openSelectTopicLayout$default(this.f56200a, false, 1, null);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class o<T> implements Observer<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56201e;

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
            this.f56201e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bool) == null) {
                if (Intrinsics.areEqual(this.f56201e.getViewModel().isLegal().getValue(), Boolean.FALSE)) {
                    this.f56201e.getNavPost().setAlpha(0.33f);
                    this.f56201e.getNavPost().setEnabled(true);
                    return;
                }
                this.f56201e.getNavPost().setAlpha(1.0f);
                this.f56201e.getNavPost().setEnabled(true);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class p<T> implements Observer<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56202e;

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
            this.f56202e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || str == null || str.equals(String.valueOf(this.f56202e.getEdtTitle().getText()))) {
                return;
            }
            this.f56202e.getEdtTitle().setText(str);
            Editable text = this.f56202e.getEdtTitle().getText();
            if (text != null) {
                this.f56202e.getEdtTitle().setSelection(text.length());
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class q<T> implements Observer<b.a.q0.u.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56203e;

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
            this.f56203e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(b.a.q0.u.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                this.f56203e.getSelectBarView().bindData(jVar);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class r<T> implements Observer<VideoCategoryClassData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56204e;

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
            this.f56204e = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(VideoCategoryClassData it) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, it) == null) {
                this.f56204e.getSelectClassView().bindData(it);
                String firstClass = this.f56204e.getSelectTagView().getFirstClass();
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                if ((!Intrinsics.areEqual(firstClass, it.getFirstClass())) || (!Intrinsics.areEqual(this.f56204e.getSelectTagView().getSecondClass(), it.getSecondClass()))) {
                    SelectTagView selectTagView = this.f56204e.getSelectTagView();
                    String firstClass2 = it.getFirstClass();
                    Intrinsics.checkExpressionValueIsNotNull(firstClass2, "it.firstClass");
                    String secondClass = it.getSecondClass();
                    Intrinsics.checkExpressionValueIsNotNull(secondClass, "it.secondClass");
                    selectTagView.setClassData(firstClass2, secondClass);
                    if (this.f56204e.isNeedCleanTag) {
                        this.f56204e.getViewModel().getTagInfo().setValue(new ArrayList<>());
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class s extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56205a;

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
            this.f56205a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof b.a.r0.k1.f) && this.f56205a.getEdtTitle() != null) {
                int selectionStart = this.f56205a.getEdtTitle().getSelectionStart();
                if (this.f56205a.mNeedDeleteLast && selectionStart > 0) {
                    int i2 = selectionStart - 1;
                    if (String.valueOf(this.f56205a.getEdtTitle().getText()).charAt(i2) == '#') {
                        this.f56205a.getEdtTitle().getEditableText().delete(i2, selectionStart);
                        this.f56205a.mNeedDeleteLast = false;
                    }
                }
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    b.a.r0.k1.f fVar = (b.a.r0.k1.f) data;
                    if (fVar.i()) {
                        this.f56205a.getEdtTitle().addVideoHotpicSpanGroup(fVar.d(), fVar.f() ? 0 : -1, fVar.e());
                    } else {
                        this.f56205a.getEdtTitle().getEditableText().insert(this.f56205a.getEdtTitle().getSelectionStart(), "#" + fVar.d() + "#");
                    }
                    WorkPublishActivity.access$getTopicLayout$p(this.f56205a).clearAllTopicText();
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.tieba.hottopicselect.TopicListData");
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class t extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56206a;

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
            this.f56206a = workPublishActivity;
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
                    new BdTopToast(this.f56206a.getBaseContext()).setIcon(false).setContent(this.f56206a.getResources().getString(R.string.can_not_change_bar_name)).show(this.f56206a.getNavigationBar());
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class u implements LocationModel.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56207a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public u(WorkPublishActivity workPublishActivity) {
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
            this.f56207a = workPublishActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f56207a.showToast(R.string.no_network_guide);
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void b(LocationData locationData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locationData) == null) {
                if (!StringUtils.isNull(locationData.getFormatted_address())) {
                    this.f56207a.goToSelectLocationActivity();
                    return;
                }
                WorkPublishActivity workPublishActivity = this.f56207a;
                workPublishActivity.showToast(workPublishActivity.getString(R.string.location_fail));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.location.LocationModel.e
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                WorkPublishActivity workPublishActivity = this.f56207a;
                if (StringUtils.isNull(str)) {
                    str = this.f56207a.getString(R.string.location_fail);
                }
                workPublishActivity.showToast(str);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class v extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56208a;

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
            this.f56208a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof VideoCategoryClassData)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    this.f56208a.isNeedCleanTag = true;
                    this.f56208a.getViewModel().getClassInfo().setValue((VideoCategoryClassData) data);
                    this.f56208a.getViewModel().checkIsAllLegal();
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.tbadk.data.VideoCategoryClassData");
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class w extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56209a;

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
            this.f56209a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof ResponsedSelectLocation)) {
                ResponsedSelectLocation responsedSelectLocation = (ResponsedSelectLocation) customResponsedMessage;
                if (responsedSelectLocation.isShowLocation()) {
                    WorkPublishActivity.access$getMLocationModel$p(this.f56209a).N(false);
                    WorkPublishActivity.access$getMLocationModel$p(this.f56209a).M(responsedSelectLocation.getName(), responsedSelectLocation.getScreatString());
                } else {
                    WorkPublishActivity.access$getMLocationModel$p(this.f56209a).N(true);
                }
                this.f56209a.getViewModel().getPosInfo().setValue(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class x extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56210a;

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
            this.f56210a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof ArrayList)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    this.f56210a.getViewModel().getTagInfo().setValue((ArrayList) data);
                    this.f56210a.getViewModel().checkIsAllLegal();
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class y extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56211a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(WorkPublishActivity workPublishActivity, int i2) {
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
            this.f56211a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof ArrayList)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    this.f56211a.getViewModel().getTopicInfo().setValue((ArrayList) data);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.String> /* = java.util.ArrayList<kotlin.String> */");
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class z extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WorkPublishActivity f56212a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public z(WorkPublishActivity workPublishActivity, int i2) {
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
            this.f56212a = workPublishActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage.getData() instanceof b.a.q0.u.j)) {
                Object data = customResponsedMessage.getData();
                if (data != null) {
                    this.f56212a.getViewModel().getBarInfo().setValue((b.a.q0.u.j) data);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.tbadk.data.SelectForumData");
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
        this.mHighLightController = new b.a.r0.d4.u.c();
        this.mTitleTemp = "";
        this.EDIT_INPUT_TITILE_MAX_LENGTH = 80;
        this.muxerSuccListener = new c0(this, 2921593);
        this.mSelectForumListener = new z(this, 2921505);
        this.mAddHotpicListener = new s(this, 2921633);
        this.mOnSelectClassListener = new v(this, 2921601);
        this.mOnSelectTagListener = new x(this, 2921604);
        this.mShowCanNotSelectTagToastListener = new a0(this, 2921605);
        this.mCanChangeBarNameToastListener = new t(this, 2921621);
        this.mOnSelectTopicListener = new y(this, 2921602);
        this.mOnSelectLocationListener = new w(this, 2001226);
        this.mOnLocationCallBack = new u(this);
        this.mWriteTitleTextWatcher = new b0(this);
    }

    public static final /* synthetic */ LocationModel access$getMLocationModel$p(WorkPublishActivity workPublishActivity) {
        LocationModel locationModel = workPublishActivity.mLocationModel;
        if (locationModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
        }
        return locationModel;
    }

    public static final /* synthetic */ SelectTopicLayout access$getTopicLayout$p(WorkPublishActivity workPublishActivity) {
        SelectTopicLayout selectTopicLayout = workPublishActivity.topicLayout;
        if (selectTopicLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
        }
        return selectTopicLayout;
    }

    public static final /* synthetic */ SelectTopicToolBar access$getTopicToolBar$p(WorkPublishActivity workPublishActivity) {
        SelectTopicToolBar selectTopicToolBar = workPublishActivity.topicToolBar;
        if (selectTopicToolBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
        }
        return selectTopicToolBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int checkTitleSpanLength(int i2) {
        InterceptResult invokeI;
        SpanGroupManager spanGroupManager;
        List<b.a.q0.s.g0.s.e> E;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65567, this, i2)) == null) {
            SpanGroupEditText spanGroupEditText = this.edtTitle;
            if (spanGroupEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            }
            Integer valueOf = (spanGroupEditText == null || (spanGroupManager = spanGroupEditText.getSpanGroupManager()) == null || (E = spanGroupManager.E()) == null) ? null : Integer.valueOf(E.size());
            if (valueOf == null) {
                Intrinsics.throwNpe();
            }
            if (valueOf.intValue() > 0) {
                SpanGroupEditText spanGroupEditText2 = this.edtTitle;
                if (spanGroupEditText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
                }
                SpanGroupManager spanGroupManager2 = spanGroupEditText2.getSpanGroupManager();
                Intrinsics.checkExpressionValueIsNotNull(spanGroupManager2, "edtTitle.spanGroupManager");
                b.a.q0.s.g0.s.e eVar = spanGroupManager2.E().get(0);
                Intrinsics.checkExpressionValueIsNotNull(eVar, "edtTitle.spanGroupManage…eoHotpicSpanGroups.get(0)");
                String s2 = eVar.s();
                return i2 >= s2.length() ? (i2 - s2.length()) + 1 : i2;
            }
            return i2;
        }
        return invokeI.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel.clearDraft();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void findAndTransPlainTextVideoHotpic(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65569, this, i2) == null) {
            synchronized (this) {
                SpanGroupEditText spanGroupEditText = this.edtTitle;
                if (spanGroupEditText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
                }
                if (spanGroupEditText == null) {
                    return;
                }
                SpanGroupEditText spanGroupEditText2 = this.edtTitle;
                if (spanGroupEditText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
                }
                Editable editableText = spanGroupEditText2.getEditableText();
                Intrinsics.checkExpressionValueIsNotNull(editableText, "edtTitle.editableText");
                Matcher matcher = TbPatternsCompat.PLAIN_TEXT_VIDEO_HOTPIC_NAME.matcher(editableText);
                if (i2 < editableText.length() && matcher.find(i2)) {
                    int start = matcher.start();
                    int end = matcher.end();
                    b.a.r0.k1.f isVideoHotpic = isVideoHotpic(matcher.group(1).toString());
                    if (isVideoHotpic != null && isVideoHotpic.i()) {
                        if (b.a.q0.t0.b.i(editableText, start)) {
                            Object[] spans = editableText.getSpans(start, end + 1, Object.class);
                            Intrinsics.checkExpressionValueIsNotNull(spans, "text.getSpans(plainTextA…Pos + 1, Any::class.java)");
                            for (Object obj : spans) {
                                if (obj instanceof EMRichTextAnyIconSpan) {
                                    editableText.removeSpan(obj);
                                }
                            }
                            SpanGroupEditText spanGroupEditText3 = this.edtTitle;
                            if (spanGroupEditText3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
                            }
                            spanGroupEditText3.getSpanGroupManager().delete(start, end, true);
                        } else {
                            SpanGroupEditText spanGroupEditText4 = this.edtTitle;
                            if (spanGroupEditText4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
                            }
                            if (!spanGroupEditText4.getSpanGroupManager().K(start, end)) {
                                SpanGroupEditText spanGroupEditText5 = this.edtTitle;
                                if (spanGroupEditText5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
                                }
                                spanGroupEditText5.getSpanGroupManager().h(isVideoHotpic.d(), start);
                                this.mVideoSelectData = isVideoHotpic;
                                SelectTopicToolBar selectTopicToolBar = this.topicToolBar;
                                if (selectTopicToolBar == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
                                }
                                Long l2 = isVideoHotpic.c().topic_id;
                                Intrinsics.checkExpressionValueIsNotNull(l2, "resultData.topicList.topic_id");
                                selectTopicToolBar.setSelectTopicId(l2.longValue());
                                SelectTopicLayout selectTopicLayout = this.topicLayout;
                                if (selectTopicLayout == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                                }
                                Long l3 = isVideoHotpic.c().topic_id;
                                Intrinsics.checkExpressionValueIsNotNull(l3, "resultData.topicList.topic_id");
                                selectTopicLayout.setSelectTopicId(l3.longValue());
                            }
                        }
                    }
                    findAndTransPlainTextVideoHotpic(end);
                }
                SpanGroupEditText spanGroupEditText6 = this.edtTitle;
                if (spanGroupEditText6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
                }
                SpanGroupManager spanGroupManager = spanGroupEditText6.getSpanGroupManager();
                Intrinsics.checkExpressionValueIsNotNull(spanGroupManager, "edtTitle.spanGroupManager");
                if (spanGroupManager.E().size() == 0) {
                    this.mVideoSelectData = null;
                    SelectTopicToolBar selectTopicToolBar2 = this.topicToolBar;
                    if (selectTopicToolBar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
                    }
                    selectTopicToolBar2.setSelectTopicId(-1L);
                    SelectTopicLayout selectTopicLayout2 = this.topicLayout;
                    if (selectTopicLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                    }
                    selectTopicLayout2.setSelectTopicId(-1L);
                }
            }
        }
    }

    private final void getFormData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, this) == null) {
            b.a.q0.u.j jVar = new b.a.q0.u.j();
            SelectBarView selectBarView = this.selectBarView;
            if (selectBarView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectBarView");
            }
            selectBarView.setMCanChangeBarName(getIntent().getBooleanExtra(WorkPublishActivityConfig.CAN_CHANGE_SELECT_BAR, true));
            jVar.f14141a = getIntent().getStringExtra("bar_id");
            jVar.f14143c = getIntent().getStringExtra("bar_name");
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel.setCanChangeBarName(getIntent().getBooleanExtra(WorkPublishActivityConfig.CAN_CHANGE_SELECT_BAR, true));
            WorkPublishViewModel workPublishViewModel2 = this.viewModel;
            if (workPublishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel2.setIntentBarInfo(jVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, b.a.r0.k1.f] */
    private final void getTopicData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65571, this) == null) {
            String stringExtra = getIntent().getStringExtra("topic");
            long g2 = b.a.e.e.m.b.g(getIntent().getStringExtra("topicId"), 0L);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? a2 = b.a.r0.k1.f.a(stringExtra, g2, true);
            objectRef.element = a2;
            if (this.isDraftData) {
                ((b.a.r0.k1.f) a2).k(true);
                b.a.e.e.m.e.a().postDelayed(new a(objectRef), 300L);
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921633, (b.a.r0.k1.f) objectRef.element));
        }
    }

    private final void getWriteData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            b.a.q0.u.j jVar = new b.a.q0.u.j();
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
            jVar.f14141a = getIntent().getStringExtra("bar_id");
            jVar.f14143c = getIntent().getStringExtra("bar_name");
            WorkPublishViewModel workPublishViewModel3 = this.viewModel;
            if (workPublishViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel3.getBarInfo().setValue(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goToSelectLocationActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, this) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectLocationActivityConfig(this)));
        }
    }

    private final void initNav() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
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
            addSystemImageButton.setOnClickListener(new b(this));
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
                b.a.q0.s.u.c.d(textView3).z(R.dimen.T_X08);
                TextView textView4 = this.navPost;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("navPost");
                }
                textView4.setOnClickListener(new c(this));
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
                        navigationBar5.setOnClickListener(new d(this));
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
    }

    private final void initSelectTopicModel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, this) == null) {
            SelectTopicModel selectTopicModel = new SelectTopicModel(getPageContext());
            this.selectTopicModel = selectTopicModel;
            if (selectTopicModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectTopicModel");
            }
            selectTopicModel.A(new e(this));
            HotTopicSelectModel hotTopicSelectModel = new HotTopicSelectModel(getPageContext(), this);
            this.mHotModel = hotTopicSelectModel;
            if (hotTopicSelectModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
            }
            hotTopicSelectModel.F(getIntent());
            HotTopicSelectModel hotTopicSelectModel2 = this.mHotModel;
            if (hotTopicSelectModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
            }
            hotTopicSelectModel2.M(true);
            HotTopicSelectModel hotTopicSelectModel3 = this.mHotModel;
            if (hotTopicSelectModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
            }
            hotTopicSelectModel3.I();
            SelectTopicLayout selectTopicLayout = this.topicLayout;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
            }
            HotTopicSelectModel hotTopicSelectModel4 = this.mHotModel;
            if (hotTopicSelectModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
            }
            selectTopicLayout.setHotTopicModel(hotTopicSelectModel4);
            HotTopicSelectModel hotTopicSelectModel5 = this.mHotModel;
            if (hotTopicSelectModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
            }
            hotTopicSelectModel5.B();
            HotTopicSelectModel hotTopicSelectModel6 = this.mHotModel;
            if (hotTopicSelectModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
            }
            hotTopicSelectModel6.J();
        }
    }

    private final void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            SelectTopicModel selectTopicModel = this.selectTopicModel;
            if (selectTopicModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectTopicModel");
            }
            selectTopicModel.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTitleEditModeChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            SelectTopicLayout selectTopicLayout = this.topicLayout;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
            }
            boolean z2 = selectTopicLayout.isOpen() || this.keyboardVisibility;
            if (this.mixVideoViewHeight == 0) {
                WorkPublishMixVideoView workPublishMixVideoView = this.mixVideoView;
                if (workPublishMixVideoView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mixVideoView");
                }
                int height = workPublishMixVideoView.getHeight();
                this.mixVideoViewHeight = height;
                this.curMixVideoViewHeight = height;
            }
            if (z2 == this.isTitleEditMode) {
                return;
            }
            this.isTitleEditMode = z2;
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
                valueAnimator2.addUpdateListener(new d0(this));
            }
            ValueAnimator valueAnimator3 = this.editModeAnimator;
            if (valueAnimator3 != null) {
                valueAnimator3.start();
            }
        }
    }

    private final void onTopicBarVisibilityChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            SpanGroupEditText spanGroupEditText = this.edtTitle;
            if (spanGroupEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            }
            if (spanGroupEditText.isFocused() && this.keyboardVisibility) {
                View view = this.topicToolLayout;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topicToolLayout");
                }
                view.setVisibility(0);
                View view2 = this.topicToolShadow;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topicToolShadow");
                }
                view2.setVisibility(0);
                return;
            }
            View view3 = this.topicToolLayout;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolLayout");
            }
            view3.setVisibility(8);
            View view4 = this.topicToolShadow;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolShadow");
            }
            view4.setVisibility(8);
        }
    }

    private final void openSelectTopicLayout(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65579, this, z2) == null) {
            SpanGroupEditText spanGroupEditText = this.edtTitle;
            if (spanGroupEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            }
            if (spanGroupEditText.isFocused()) {
                SpanGroupEditText spanGroupEditText2 = this.edtTitle;
                if (spanGroupEditText2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
                }
                spanGroupEditText2.setFocusable(false);
                SpanGroupEditText spanGroupEditText3 = this.edtTitle;
                if (spanGroupEditText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
                }
                spanGroupEditText3.setFocusableInTouchMode(true);
                Object systemService = getSystemService("input_method");
                if (systemService != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                    SpanGroupEditText spanGroupEditText4 = this.edtTitle;
                    if (spanGroupEditText4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
                    }
                    HidenSoftKeyPad(inputMethodManager, spanGroupEditText4);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                }
            }
            SelectTopicLayout selectTopicLayout = this.topicLayout;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
            }
            selectTopicLayout.open();
            this.mNeedDeleteLast = z2;
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WORK_VIDEO_TOPIC_LAYOUT_SHOW));
        }
    }

    public static /* synthetic */ void openSelectTopicLayout$default(WorkPublishActivity workPublishActivity, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        workPublishActivity.openSelectTopicLayout(z2);
    }

    private final void prepareIntent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65581, this) == null) {
            int intExtra = getIntent().getIntExtra(WorkPublishActivityConfig.PARAM_SHOW_DRAFT, 0);
            this.draftType = intExtra;
            if (intExtra == b.a.q0.s.m.c.f13160f.a()) {
                this.isDraftData = true;
                WorkPublishViewModel workPublishViewModel = this.viewModel;
                if (workPublishViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                workPublishViewModel.loadDraft();
                getFormData();
            } else if (this.draftType == b.a.q0.s.m.c.f13160f.b()) {
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
            if (!TextUtils.isEmpty(getIntent().getStringExtra("topic"))) {
                getTopicData();
            }
            if (getIntent().getBooleanExtra(WriteActivityConfig.NEED_CLOSE_PRE_PAGE, false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921583));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processSaveDraft() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel.saveDraft();
        }
    }

    private final void showLocPermissionDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(pageContext.getPageActivity());
            aVar.setMessageId(R.string.location_app_permission_prompt).setPositiveButton(R.string.isopen, new f0(this)).setNegativeButton(R.string.cancel, g0.f56193e).create(getPageContext());
            aVar.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryOpenSelectTopicLayout(CharSequence charSequence, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65584, this, charSequence, i2, i3) == null) && i3 == 1 && i2 < charSequence.length() && i2 >= 0 && b.a.q0.t0.b.f(String.valueOf(charSequence.charAt(i2)))) {
            openSelectTopicLayout(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTitleLimit(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65585, this, charSequence) == null) {
            String obj = charSequence.toString();
            int checkTitleSpanLength = checkTitleSpanLength(obj.length());
            TextView textView = this.counterTitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("counterTitle");
            }
            textView.setText("(" + String.valueOf(checkTitleSpanLength) + "/" + this.EDIT_INPUT_TITILE_MAX_LENGTH + SmallTailInfo.EMOTION_SUFFIX);
            if (checkTitleSpanLength > this.EDIT_INPUT_TITILE_MAX_LENGTH) {
                TextView textView2 = this.counterTitle;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("counterTitle");
                }
                textView2.setTextColor(SkinManager.getColor(R.color.CAM_X0301));
            } else {
                TextView textView3 = this.counterTitle;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("counterTitle");
                }
                textView3.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel.updateTitle(obj, checkTitleSpanLength);
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
    /* JADX WARN: Removed duplicated region for block: B:95:0x020a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void doPost() {
        boolean z2;
        WorkPublishViewModel workPublishViewModel;
        WorkPublishViewModel workPublishViewModel2;
        WorkPublishViewModel workPublishViewModel3;
        String a2;
        b.a.r0.l3.s0.g gVar;
        b.a.r0.l3.s0.g gVar2;
        b.a.r0.l3.s0.g j2;
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
            b.a.q0.u.j value3 = workPublishViewModel9.getBarInfo().getValue();
            writeData.setForumId(value3 != null ? value3.f14141a : null);
            WorkPublishViewModel workPublishViewModel10 = this.viewModel;
            if (workPublishViewModel10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            b.a.q0.u.j value4 = workPublishViewModel10.getBarInfo().getValue();
            writeData.setForumName(value4 != null ? value4.f14143c : null);
            WorkPublishViewModel workPublishViewModel11 = this.viewModel;
            if (workPublishViewModel11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            boolean z3 = false;
            if (workPublishViewModel11.getPosInfo().getValue() != null) {
                b.a.r0.l3.o0.b a3 = b.a.r0.l3.o0.b.a();
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
                    a2 = b.a.q0.s.m.b.a();
                    if (!((a2 != null || a2.length() == 0) ? true : true)) {
                        String a4 = b.a.q0.s.m.b.a();
                        Intrinsics.checkExpressionValueIsNotNull(a4, "WorkPublishManager.getObjLocate()");
                        writeData.setStatisticFrom(Integer.parseInt(a4));
                    }
                    gVar = this.mWriteModel;
                    if (gVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                    }
                    gVar.E(writeData);
                    gVar2 = this.mWriteModel;
                    if (gVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                    }
                    gVar2.F();
                    j2 = b.a.r0.l3.s0.g.j();
                    Intrinsics.checkExpressionValueIsNotNull(j2, "AsyncWriteHelper.getInstance()");
                    if (j2.h() != null) {
                        b.a.r0.l3.s0.g helper = b.a.r0.l3.s0.g.j();
                        Intrinsics.checkExpressionValueIsNotNull(helper, "helper");
                        if (!helper.q() && !helper.r()) {
                            VideoWorkListActivityConfig videoWorkListActivityConfig = new VideoWorkListActivityConfig(this);
                            videoWorkListActivityConfig.addType("1");
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoWorkListActivityConfig));
                        } else {
                            n2 n2Var = new n2();
                            n2Var.f13408a = true;
                            n2Var.f13409b = helper.i();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921625, n2Var));
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
            a2 = b.a.q0.s.m.b.a();
            if (!((a2 != null || a2.length() == 0) ? true : true)) {
            }
            gVar = this.mWriteModel;
            if (gVar == null) {
            }
            gVar.E(writeData);
            gVar2 = this.mWriteModel;
            if (gVar2 == null) {
            }
            gVar2.F();
            j2 = b.a.r0.l3.s0.g.j();
            Intrinsics.checkExpressionValueIsNotNull(j2, "AsyncWriteHelper.getInstance()");
            if (j2.h() != null) {
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

    public final TextView getCounterTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            TextView textView = this.counterTitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("counterTitle");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
    }

    public final RelativeLayout getEditContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RelativeLayout relativeLayout = this.editContent;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editContent");
            }
            return relativeLayout;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public final SpanGroupEditText getEdtTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            SpanGroupEditText spanGroupEditText = this.edtTitle;
            if (spanGroupEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            }
            return spanGroupEditText;
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
            if (workPublishMixVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixVideoView");
            }
            return workPublishMixVideoView;
        }
        return (WorkPublishMixVideoView) invokeV.objValue;
    }

    public final ViewGroup getMixVideoViewLayout() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ViewGroup viewGroup = this.mixVideoViewLayout;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixVideoViewLayout");
            }
            return viewGroup;
        }
        return (ViewGroup) invokeV.objValue;
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

    public final TextView getShowTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            TextView textView = this.showTitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showTitle");
            }
            return textView;
        }
        return (TextView) invokeV.objValue;
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

    public final ViewGroup getWorkPublishContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            ViewGroup viewGroup = this.workPublishContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("workPublishContainer");
            }
            return viewGroup;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            initNav();
            View findViewById = findViewById(16908290);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(android.R.id.content)");
            this.rootView = (ViewGroup) findViewById;
            View findViewById2 = findViewById(R.id.videoViewLayout);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.videoViewLayout)");
            this.mixVideoViewLayout = (ViewGroup) findViewById2;
            View findViewById3 = findViewById(R.id.videoView);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.videoView)");
            WorkPublishMixVideoView workPublishMixVideoView = (WorkPublishMixVideoView) findViewById3;
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
            View findViewById4 = findViewById(R.id.work_publish_edtTitle);
            Intrinsics.checkExpressionValueIsNotNull(findViewById4, "findViewById(R.id.work_publish_edtTitle)");
            SpanGroupEditText spanGroupEditText = (SpanGroupEditText) findViewById4;
            this.edtTitle = spanGroupEditText;
            if (spanGroupEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            }
            spanGroupEditText.setTransLink(false);
            SpanGroupEditText spanGroupEditText2 = this.edtTitle;
            if (spanGroupEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            }
            spanGroupEditText2.setTransAt(false);
            View findViewById5 = findViewById(R.id.edit_content);
            Intrinsics.checkExpressionValueIsNotNull(findViewById5, "findViewById(R.id.edit_content)");
            this.editContent = (RelativeLayout) findViewById5;
            View findViewById6 = findViewById(R.id.work_publish_bg);
            Intrinsics.checkExpressionValueIsNotNull(findViewById6, "findViewById(R.id.work_publish_bg)");
            this.workPublishBg = (ViewGroup) findViewById6;
            View findViewById7 = findViewById(R.id.work_publish_container);
            Intrinsics.checkExpressionValueIsNotNull(findViewById7, "findViewById(R.id.work_publish_container)");
            this.workPublishContainer = (ViewGroup) findViewById7;
            View findViewById8 = findViewById(R.id.select_bar_view);
            Intrinsics.checkExpressionValueIsNotNull(findViewById8, "findViewById(R.id.select_bar_view)");
            this.selectBarView = (SelectBarView) findViewById8;
            View findViewById9 = findViewById(R.id.select_class_view);
            Intrinsics.checkExpressionValueIsNotNull(findViewById9, "findViewById(R.id.select_class_view)");
            this.selectClassView = (SelectClassView) findViewById9;
            View findViewById10 = findViewById(R.id.select_topic_view);
            Intrinsics.checkExpressionValueIsNotNull(findViewById10, "findViewById(R.id.select_topic_view)");
            this.selectTopicView = (SelectTopicView) findViewById10;
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
            View findViewById11 = findViewById(R.id.select_tag_view);
            Intrinsics.checkExpressionValueIsNotNull(findViewById11, "findViewById(R.id.select_tag_view)");
            this.selectTagView = (SelectTagView) findViewById11;
            View findViewById12 = findViewById(R.id.select_pos_view);
            Intrinsics.checkExpressionValueIsNotNull(findViewById12, "findViewById(R.id.select_pos_view)");
            SelectPosView selectPosView = (SelectPosView) findViewById12;
            this.selectPosView = selectPosView;
            if (selectPosView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("selectPosView");
            }
            selectPosView.setOnClickListener(new j(this));
            RelativeLayout relativeLayout = this.editContent;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("editContent");
            }
            relativeLayout.setOnClickListener(new k(this));
            View findViewById13 = findViewById(R.id.work_publish_show_title);
            Intrinsics.checkExpressionValueIsNotNull(findViewById13, "findViewById(R.id.work_publish_show_title)");
            this.showTitle = (TextView) findViewById13;
            View findViewById14 = findViewById(R.id.work_publish_title_sign);
            Intrinsics.checkExpressionValueIsNotNull(findViewById14, "findViewById(R.id.work_publish_title_sign)");
            this.titleSign = (ImageView) findViewById14;
            View findViewById15 = findViewById(R.id.sep_line_content);
            Intrinsics.checkExpressionValueIsNotNull(findViewById15, "findViewById(R.id.sep_line_content)");
            this.contentBottomLine = findViewById15;
            View findViewById16 = findViewById(R.id.work_publish_title_counter);
            Intrinsics.checkExpressionValueIsNotNull(findViewById16, "findViewById(R.id.work_publish_title_counter)");
            this.counterTitle = (TextView) findViewById16;
            View findViewById17 = findViewById(R.id.select_topic_layout);
            Intrinsics.checkExpressionValueIsNotNull(findViewById17, "findViewById(R.id.select_topic_layout)");
            this.topicLayout = (SelectTopicLayout) findViewById17;
            NavigationBar navigationBar = this.navigationBar;
            if (navigationBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navigationBar");
            }
            navigationBar.post(new l(this));
            SelectTopicLayout selectTopicLayout = this.topicLayout;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
            }
            selectTopicLayout.setStateListener(new m(this));
            View findViewById18 = findViewById(R.id.topic_tool_layout);
            Intrinsics.checkExpressionValueIsNotNull(findViewById18, "findViewById(R.id.topic_tool_layout)");
            this.topicToolLayout = findViewById18;
            View findViewById19 = findViewById(R.id.topic_tool_shadow);
            Intrinsics.checkExpressionValueIsNotNull(findViewById19, "findViewById(R.id.topic_tool_shadow)");
            this.topicToolShadow = findViewById19;
            View findViewById20 = findViewById(R.id.topic_tool_bar);
            Intrinsics.checkExpressionValueIsNotNull(findViewById20, "findViewById(R.id.topic_tool_bar)");
            SelectTopicToolBar selectTopicToolBar = (SelectTopicToolBar) findViewById20;
            this.topicToolBar = selectTopicToolBar;
            if (selectTopicToolBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
            }
            selectTopicToolBar.setmFromType(1);
            SelectTopicToolBar selectTopicToolBar2 = this.topicToolBar;
            if (selectTopicToolBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
            }
            selectTopicToolBar2.setOpenTopicLayoutListener(new n(this));
            SpanGroupEditText spanGroupEditText3 = this.edtTitle;
            if (spanGroupEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            }
            spanGroupEditText3.addTextChangedListener(this.mWriteTitleTextWatcher);
            WorkPublishViewModel workPublishViewModel = this.viewModel;
            if (workPublishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel.isLegal().observe(this, new o(this));
            WorkPublishViewModel workPublishViewModel2 = this.viewModel;
            if (workPublishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel2.getTitle().observe(this, new p(this));
            WorkPublishViewModel workPublishViewModel3 = this.viewModel;
            if (workPublishViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel3.getBarInfo().observe(this, new q(this));
            WorkPublishViewModel workPublishViewModel4 = this.viewModel;
            if (workPublishViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel4.getClassInfo().observe(this, new r(this));
            WorkPublishViewModel workPublishViewModel5 = this.viewModel;
            if (workPublishViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel5.getTagInfo().observe(this, new f(this));
            WorkPublishViewModel workPublishViewModel6 = this.viewModel;
            if (workPublishViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel6.getTopicInfo().observe(this, new g(this));
            WorkPublishViewModel workPublishViewModel7 = this.viewModel;
            if (workPublishViewModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel7.getPosInfo().observe(this, new h(this));
            WorkPublishViewModel workPublishViewModel8 = this.viewModel;
            if (workPublishViewModel8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            workPublishViewModel8.getVideoInfo().observe(this, new i(this));
        }
    }

    public final b.a.r0.k1.f isVideoHotpic(String str) {
        InterceptResult invokeL;
        b.a.r0.k1.c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (cVar = this.mVideoListData) != null) {
                if (!ListUtils.isEmpty(cVar != null ? cVar.c() : null)) {
                    b.a.r0.k1.c cVar2 = this.mVideoListData;
                    List<b.a.r0.k1.f> c2 = cVar2 != null ? cVar2.c() : null;
                    if (c2 != null) {
                        int size = c2.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            b.a.r0.k1.f fVar = c2.get(i2);
                            if (fVar != null && fVar.c() != null) {
                                TopicList c3 = fVar.c();
                                Intrinsics.checkExpressionValueIsNotNull(c3, "topicListData.topicList");
                                if (c3 != null && Intrinsics.areEqual(str, c3.topic_name)) {
                                    return fVar;
                                }
                            }
                        }
                        return null;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.baidu.tieba.hottopicselect.TopicListData>");
                }
            }
            return null;
        }
        return (b.a.r0.k1.f) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            ViewGroup viewGroup = this.workPublishBg;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("workPublishBg");
            }
            b.a.q0.s.u.c.d(viewGroup).f(R.color.CAM_X0201);
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
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(textView);
            d2.v(R.color.CAM_X0101);
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
            TextView textView7 = this.showTitle;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("showTitle");
            }
            SkinManager.setViewTextColor(textView7, R.color.CAM_X0105);
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
            SelectTopicToolBar selectTopicToolBar = this.topicToolBar;
            if (selectTopicToolBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolBar");
            }
            selectTopicToolBar.onChangeSkin();
            SpanGroupEditText spanGroupEditText = this.edtTitle;
            if (spanGroupEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            }
            spanGroupEditText.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            TextView textView8 = this.counterTitle;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("counterTitle");
            }
            textView8.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            SpanGroupEditText spanGroupEditText2 = this.edtTitle;
            if (spanGroupEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("edtTitle");
            }
            spanGroupEditText2.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            View view = this.contentBottomLine;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentBottomLine");
            }
            SkinManager.setBackgroundColor(view, R.color.CAM_X0210);
            WorkPublishMixVideoView workPublishMixVideoView = this.mixVideoView;
            if (workPublishMixVideoView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mixVideoView");
            }
            workPublishMixVideoView.onChangeSkin();
            View view2 = this.topicToolShadow;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolShadow");
            }
            b.a.q0.s.u.c.d(view2).o(new int[]{R.color.CAM_X0802, R.color.CAM_X0601});
            View view3 = this.topicToolLayout;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicToolLayout");
            }
            b.a.q0.s.u.c.d(view3).f(R.color.CAM_X0207);
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
            locationModel.O(this.mOnLocationCallBack);
            b.a.r0.l3.s0.g j2 = b.a.r0.l3.s0.g.j();
            Intrinsics.checkExpressionValueIsNotNull(j2, "AsyncWriteHelper.getInstance()");
            this.mWriteModel = j2;
            if (j2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
            }
            j2.o(this);
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
            ValueAnimator valueAnimator = this.editModeAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            PopupDialog popupDialog = this.saveDraftDialog;
            if (popupDialog != null) {
                popupDialog.dismiss();
            }
            this.saveDraftDialog = null;
            stopTask();
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataNoSearchFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            SelectTopicLayout selectTopicLayout = this.topicLayout;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
            }
            selectTopicLayout.onHotSelectDataNoSearchFailed(str);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataNoSearchSuccess(b.a.r0.k1.c cVar, b.a.r0.k1.c cVar2, b.a.r0.k1.c cVar3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048605, this, cVar, cVar2, cVar3) == null) {
            if (this.mVideoListData == null) {
                this.mVideoListData = cVar3;
                findAndTransPlainTextVideoHotpic(0);
            } else {
                this.mVideoListData = cVar3;
            }
            SelectTopicLayout selectTopicLayout = this.topicLayout;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
            }
            selectTopicLayout.onHotSelectDataNoSearchSuccess(cVar, cVar2, cVar3);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataSearchFailed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            SelectTopicLayout selectTopicLayout = this.topicLayout;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
            }
            selectTopicLayout.onHotSelectDataSearchFailed(str);
        }
    }

    @Override // com.baidu.tieba.hottopicselect.HotTopicSelectModel.c
    public void onHotSelectDataSearchSuccess(b.a.r0.k1.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, cVar) == null) {
            SelectTopicLayout selectTopicLayout = this.topicLayout;
            if (selectTopicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
            }
            selectTopicLayout.onHotSelectDataSearchSuccess(cVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048608, this, i2, keyEvent)) == null) {
            if (i2 == 4) {
                SelectTopicLayout selectTopicLayout = this.topicLayout;
                if (selectTopicLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                }
                if (selectTopicLayout.isOpen()) {
                    SelectTopicLayout selectTopicLayout2 = this.topicLayout;
                    if (selectTopicLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                    }
                    selectTopicLayout2.close();
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
    public void onKeyboardVisibilityChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048609, this, z2) == null) {
            this.keyboardVisibility = z2;
            onTitleEditModeChange();
            onTopicBarVisibilityChange();
        }
    }

    public final void onLocViewClickedInInitState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            LocationModel locationModel = this.mLocationModel;
            if (locationModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
            }
            TbPageContext<BaseFragmentActivity> pageContext = getPageContext();
            Intrinsics.checkExpressionValueIsNotNull(pageContext, "pageContext");
            if (!locationModel.E(pageContext.getPageActivity())) {
                showToast(R.string.location_system_permission_prompt);
                return;
            }
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            Intrinsics.checkExpressionValueIsNotNull(inst, "TbadkCoreApplication.getInst()");
            if (!inst.getLocationShared()) {
                showLocPermissionDialog();
                return;
            }
            LocationModel locationModel2 = this.mLocationModel;
            if (locationModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
            }
            if (locationModel2.D()) {
                goToSelectLocationActivity();
                return;
            }
            LocationModel locationModel3 = this.mLocationModel;
            if (locationModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
            }
            locationModel3.N(false);
            LocationModel locationModel4 = this.mLocationModel;
            if (locationModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationModel");
            }
            locationModel4.J();
        }
    }

    public void onMixFail() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            showToastWithDefaultIcon(getString(R.string.write_video_mix_fail), BdToast.DefaultIcon.FAILURE);
        }
    }

    @Override // b.a.r0.d4.u.p.c.a
    public void onMixStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i2) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048613, this, intent) == null) {
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
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            if (this.saveDraftDialogView == null) {
                this.saveDraftDialogView = new SaveDraftDialogView(this);
                e0 e0Var = new e0(this);
                SaveDraftDialogView saveDraftDialogView = this.saveDraftDialogView;
                if (saveDraftDialogView == null) {
                    Intrinsics.throwNpe();
                }
                saveDraftDialogView.setOnClickListener(e0Var);
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
        if (interceptable == null || interceptable.invokeL(1048615, this, view) == null) {
            this.contentBottomLine = view;
        }
    }

    public final void setCounterTitle(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, textView) == null) {
            this.counterTitle = textView;
        }
    }

    public final void setEditContent(RelativeLayout relativeLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, relativeLayout) == null) {
            this.editContent = relativeLayout;
        }
    }

    public final void setEdtTitle(SpanGroupEditText spanGroupEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, spanGroupEditText) == null) {
            this.edtTitle = spanGroupEditText;
        }
    }

    public final void setHasClickedTitle(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048619, this, z2) == null) {
            this.hasClickedTitle = z2;
        }
    }

    public final void setMixVideoView(WorkPublishMixVideoView workPublishMixVideoView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, workPublishMixVideoView) == null) {
            this.mixVideoView = workPublishMixVideoView;
        }
    }

    public final void setMixVideoViewLayout(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, viewGroup) == null) {
            this.mixVideoViewLayout = viewGroup;
        }
    }

    public final void setNavBack(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, view) == null) {
            this.navBack = view;
        }
    }

    public final void setNavCenterText(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, textView) == null) {
            this.navCenterText = textView;
        }
    }

    public final void setNavPost(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, textView) == null) {
            this.navPost = textView;
        }
    }

    public final void setNavigationBar(NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, navigationBar) == null) {
            this.navigationBar = navigationBar;
        }
    }

    public final void setRootView(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, viewGroup) == null) {
            this.rootView = viewGroup;
        }
    }

    public final void setSelectBarView(SelectBarView selectBarView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, selectBarView) == null) {
            this.selectBarView = selectBarView;
        }
    }

    public final void setSelectClassView(SelectClassView selectClassView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, selectClassView) == null) {
            this.selectClassView = selectClassView;
        }
    }

    public final void setSelectPosView(SelectPosView selectPosView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, selectPosView) == null) {
            this.selectPosView = selectPosView;
        }
    }

    public final void setSelectTagView(SelectTagView selectTagView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, selectTagView) == null) {
            this.selectTagView = selectTagView;
        }
    }

    public final void setSelectTopicView(SelectTopicView selectTopicView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, selectTopicView) == null) {
            this.selectTopicView = selectTopicView;
        }
    }

    public final void setShowTitle(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, textView) == null) {
            this.showTitle = textView;
        }
    }

    public final void setTitleSign(ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, imageView) == null) {
            this.titleSign = imageView;
        }
    }

    public final void setViewModel(WorkPublishViewModel workPublishViewModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, workPublishViewModel) == null) {
            this.viewModel = workPublishViewModel;
        }
    }

    public final void setWorkPublishBg(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, viewGroup) == null) {
            this.workPublishBg = viewGroup;
        }
    }

    public final void setWorkPublishContainer(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, viewGroup) == null) {
            this.workPublishContainer = viewGroup;
        }
    }

    public final void stopTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            b.a.r0.l3.s0.g gVar = this.mWriteModel;
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
            }
            if (gVar != null) {
                gVar.s();
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
            HotTopicSelectModel hotTopicSelectModel = this.mHotModel;
            if (hotTopicSelectModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHotModel");
            }
            if (hotTopicSelectModel != null) {
                hotTopicSelectModel.onDestroy();
            }
        }
    }
}
