package com.baidu.tieba.view.headcard.compete;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewCommonUtil;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ad;
import com.baidu.tieba.jta;
import com.baidu.tieba.mta;
import com.baidu.tieba.qta;
import com.baidu.tieba.rta;
import com.baidu.tieba.sta;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.tieba.view.headcard.compete.CompeteCardView;
import com.baidu.tieba.view.headcard.compete.CompeteCardView$dialogClickCallback$2;
import com.baidu.tieba.view.headcard.data.QuizCardRespondedMessage;
import com.baidu.tieba.view.headcard.utils.RaceGuessingDialogHelper;
import com.baidu.tieba.xta;
import com.baidu.tieba.yta;
import com.baidu.tieba.zta;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import tbclient.LinkConf;
import tbclient.QuizCardTopConf;
import tbclient.QuizInfo;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
@Metadata(d1 = {"\u0000Å\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b,*\u0003\u0016¥\u0001\u0018\u0000 â\u00012\u00020\u00012\u00020\u0002:\u0004á\u0001â\u0001B+\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010±\u0001\u001a\u00030²\u0001H\u0002J\u0011\u0010³\u0001\u001a\u00030²\u00012\u0007\u0010´\u0001\u001a\u00020\u001bJ3\u0010µ\u0001\u001a\u00030²\u00012\u0007\u0010´\u0001\u001a\u00020\u001b2\b\u0010¶\u0001\u001a\u00030·\u00012\n\u0010¸\u0001\u001a\u0005\u0018\u00010\u0092\u00012\n\u0010¹\u0001\u001a\u0005\u0018\u00010\u0092\u0001J\u001e\u0010º\u0001\u001a\u00030²\u00012\t\u0010»\u0001\u001a\u0004\u0018\u00010$2\u0007\u0010¼\u0001\u001a\u00020\tH\u0002J\n\u0010½\u0001\u001a\u00030²\u0001H\u0002J\u0013\u0010¾\u0001\u001a\u00030\u0094\u00012\u0007\u0010¿\u0001\u001a\u000205H\u0002J\n\u0010À\u0001\u001a\u00030²\u0001H\u0002J\u0014\u0010Á\u0001\u001a\u00030²\u00012\b\u0010Â\u0001\u001a\u00030\u0094\u0001H\u0002J\n\u0010Ã\u0001\u001a\u00030²\u0001H\u0014J\u0015\u0010Ä\u0001\u001a\u00030²\u00012\t\u0010Å\u0001\u001a\u0004\u0018\u00010$H\u0016J\n\u0010Æ\u0001\u001a\u00030²\u0001H\u0014J8\u0010Ç\u0001\u001a\u00030²\u00012\b\u0010È\u0001\u001a\u00030·\u00012\u0007\u0010É\u0001\u001a\u00020\t2\u0007\u0010Ê\u0001\u001a\u00020\t2\u0007\u0010Ë\u0001\u001a\u00020\t2\u0007\u0010Ì\u0001\u001a\u00020\tH\u0014J\u001c\u0010Í\u0001\u001a\u00030²\u00012\u0007\u0010Î\u0001\u001a\u00020\t2\u0007\u0010Ï\u0001\u001a\u00020\tH\u0014J\u0011\u0010Ð\u0001\u001a\u00030²\u00012\u0007\u0010¼\u0001\u001a\u00020\tJ\b\u0010Ñ\u0001\u001a\u00030²\u0001J\b\u0010Ò\u0001\u001a\u00030²\u0001J%\u0010Ó\u0001\u001a\u00030²\u00012\u0007\u0010´\u0001\u001a\u00020\u001b2\b\u0010Ô\u0001\u001a\u00030·\u00012\b\u0010Õ\u0001\u001a\u00030·\u0001J\n\u0010Ö\u0001\u001a\u00030²\u0001H\u0002J\n\u0010×\u0001\u001a\u00030²\u0001H\u0002J\n\u0010Ø\u0001\u001a\u00030²\u0001H\u0002J\u001b\u0010Ù\u0001\u001a\u00030²\u00012\u0007\u0010¼\u0001\u001a\u00020\t2\b\u0010Ô\u0001\u001a\u00030·\u0001J\u001c\u0010Ú\u0001\u001a\u00030²\u00012\b\u0010Û\u0001\u001a\u00030\u0094\u00012\b\u0010Ü\u0001\u001a\u00030\u0094\u0001J\u0012\u0010Ý\u0001\u001a\u00030²\u00012\u0006\u0010\u0014\u001a\u00020\tH\u0002J\n\u0010Þ\u0001\u001a\u00030²\u0001H\u0002J\u0012\u0010ß\u0001\u001a\u00030²\u00012\u0006\u0010\u0014\u001a\u00020\tH\u0002J\n\u0010à\u0001\u001a\u00030²\u0001H\u0002R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0010\u001a\u0004\b)\u0010&R\u001b\u0010+\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0010\u001a\u0004\b,\u0010-R\u001b\u0010/\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\u0010\u001a\u0004\b1\u00102R\u001b\u00104\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0010\u001a\u0004\b6\u00107R\u001b\u00109\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\u0010\u001a\u0004\b:\u00107R\u001b\u0010<\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\u0010\u001a\u0004\b=\u0010&R\u001b\u0010?\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010\u0010\u001a\u0004\bA\u0010BR\u001b\u0010D\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u0010\u0010\u001a\u0004\bE\u00107R\u001b\u0010G\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010\u0010\u001a\u0004\bH\u00107R\u001b\u0010J\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010\u0010\u001a\u0004\bK\u00107R\u001b\u0010M\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010\u0010\u001a\u0004\bN\u0010&R\u001b\u0010P\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bR\u0010\u0010\u001a\u0004\bQ\u0010BR\u001b\u0010S\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u0010\u001a\u0004\bT\u00107R\u001b\u0010V\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\u0010\u001a\u0004\bW\u00107R\u001b\u0010Y\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\u0010\u001a\u0004\bZ\u00107R\u001b\u0010\\\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010\u0010\u001a\u0004\b]\u0010BR\u000e\u0010_\u001a\u00020`X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010a\u001a\u00020b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010\u0010\u001a\u0004\bc\u0010dR\u001b\u0010f\u001a\u00020g8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bj\u0010\u0010\u001a\u0004\bh\u0010iR\u001b\u0010k\u001a\u00020l8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bo\u0010\u0010\u001a\u0004\bm\u0010nR\u001b\u0010p\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010\u0010\u001a\u0004\bq\u00107R\u001b\u0010s\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bu\u0010\u0010\u001a\u0004\bt\u0010-R\u001b\u0010v\u001a\u00020b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u0010\u0010\u001a\u0004\bw\u0010dR\u001b\u0010y\u001a\u00020g8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b{\u0010\u0010\u001a\u0004\bz\u0010iR\u001b\u0010|\u001a\u00020l8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b~\u0010\u0010\u001a\u0004\b}\u0010nR\u001d\u0010\u007f\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010\u0010\u001a\u0005\b\u0080\u0001\u00107R\u001e\u0010\u0082\u0001\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0084\u0001\u0010\u0010\u001a\u0005\b\u0083\u0001\u0010&R\u001e\u0010\u0085\u0001\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0087\u0001\u0010\u0010\u001a\u0005\b\u0086\u0001\u0010BR\u001e\u0010\u0088\u0001\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010\u0010\u001a\u0005\b\u0089\u0001\u00107R\u001e\u0010\u008b\u0001\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u008d\u0001\u0010\u0010\u001a\u0005\b\u008c\u0001\u00107R\u001e\u0010\u008e\u0001\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0090\u0001\u0010\u0010\u001a\u0005\b\u008f\u0001\u00107R\u0012\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0093\u0001\u001a\u00030\u0094\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0095\u0001\u001a\u00020@8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0097\u0001\u0010\u0010\u001a\u0005\b\u0096\u0001\u0010BR\u001e\u0010\u0098\u0001\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u009a\u0001\u0010\u0010\u001a\u0005\b\u0099\u0001\u00107R\u001e\u0010\u009b\u0001\u001a\u0002058BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u009d\u0001\u0010\u0010\u001a\u0005\b\u009c\u0001\u00107R\u0010\u0010\u009e\u0001\u001a\u00030\u0094\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009f\u0001\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u0001\u001a\u00030\u0094\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¡\u0001\u001a\u00030\u0094\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¢\u0001\u001a\u0005\u0018\u00010\u0092\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010£\u0001\u001a\u0005\u0018\u00010\u0092\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010¤\u0001\u001a\u00030¥\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010¦\u0001R\u0010\u0010§\u0001\u001a\u00030¨\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010©\u0001\u001a\u00030ª\u00018BX\u0082\u0084\u0002¢\u0006\u000f\n\u0005\b\u00ad\u0001\u0010\u0010\u001a\u0006\b«\u0001\u0010¬\u0001R\u001e\u0010®\u0001\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b°\u0001\u0010\u0010\u001a\u0005\b¯\u0001\u0010\u001f¨\u0006ã\u0001"}, d2 = {"Lcom/baidu/tieba/view/headcard/compete/CompeteCardView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Lcom/baidu/tbadk/TbPageContext;", "Lcom/baidu/tbadk/core/BaseFragmentActivity;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Lcom/baidu/tbadk/TbPageContext;Landroid/util/AttributeSet;I)V", "animHandler", "Lcom/baidu/tieba/view/headcard/compete/CompeteCardView$AnimHandler;", "getAnimHandler", "()Lcom/baidu/tieba/view/headcard/compete/CompeteCardView$AnimHandler;", "animHandler$delegate", "Lkotlin/Lazy;", "applyCallBack", "Lcom/baidu/tieba/view/headcard/model/ApplyGuessCallBack;", "Lcom/baidu/tieba/view/headcard/data/QuizCardRespondedMessage$QuizErrorData;", PushConstants.CLICK_TYPE, "dialogClickCallback", "com/baidu/tieba/view/headcard/compete/CompeteCardView$dialogClickCallback$2$1", "getDialogClickCallback", "()Lcom/baidu/tieba/view/headcard/compete/CompeteCardView$dialogClickCallback$2$1;", "dialogClickCallback$delegate", "headQuizCardData", "Lcom/baidu/tieba/view/headcard/data/HeadQuizCardData;", "leftQuizBetLottie", "Lcom/baidu/tbadk/widget/lottie/TBLottieAnimationView;", "getLeftQuizBetLottie", "()Lcom/baidu/tbadk/widget/lottie/TBLottieAnimationView;", "leftQuizBetLottie$delegate", "mApplyGuessModel", "Lcom/baidu/tieba/view/headcard/model/ApplyGuessModel;", "mBodyContainer", "Landroid/view/View;", "getMBodyContainer", "()Landroid/view/View;", "mBodyContainer$delegate", "mBodyParticipate", "getMBodyParticipate", "mBodyParticipate$delegate", "mBottomJumpContainer", "getMBottomJumpContainer", "()Landroid/widget/RelativeLayout;", "mBottomJumpContainer$delegate", "mBottomJumpIcon", "Landroid/widget/ImageView;", "getMBottomJumpIcon", "()Landroid/widget/ImageView;", "mBottomJumpIcon$delegate", "mBottomJumpText", "Landroid/widget/TextView;", "getMBottomJumpText", "()Landroid/widget/TextView;", "mBottomJumpText$delegate", "mCardAbs", "getMCardAbs", "mCardAbs$delegate", "mCardLeftBottom", "getMCardLeftBottom", "mCardLeftBottom$delegate", "mCardLeftIcon", "Lcom/baidu/tbadk/widget/TbImageView;", "getMCardLeftIcon", "()Lcom/baidu/tbadk/widget/TbImageView;", "mCardLeftIcon$delegate", "mCardLeftPartTitle", "getMCardLeftPartTitle", "mCardLeftPartTitle$delegate", "mCardLeftText", "getMCardLeftText", "mCardLeftText$delegate", "mCardLeftTitle", "getMCardLeftTitle", "mCardLeftTitle$delegate", "mCardRightBottom", "getMCardRightBottom", "mCardRightBottom$delegate", "mCardRightIcon", "getMCardRightIcon", "mCardRightIcon$delegate", "mCardRightPartTitle", "getMCardRightPartTitle", "mCardRightPartTitle$delegate", "mCardRightText", "getMCardRightText", "mCardRightText$delegate", "mCardRightTitle", "getMCardRightTitle", "mCardRightTitle$delegate", "mCompeteBackground", "getMCompeteBackground", "mCompeteBackground$delegate", "mCompeteCardViewStaticHelper", "Lcom/baidu/tieba/view/headcard/compete/CompeteCardViewStaticHelper;", "mCompeteLeftHead", "Lcom/baidu/tbadk/core/view/HeadImageView;", "getMCompeteLeftHead", "()Lcom/baidu/tbadk/core/view/HeadImageView;", "mCompeteLeftHead$delegate", "mCompeteLeftHeadContainer", "Lcom/baidu/tieba/view/RoundRelativeLayout;", "getMCompeteLeftHeadContainer", "()Lcom/baidu/tieba/view/RoundRelativeLayout;", "mCompeteLeftHeadContainer$delegate", "mCompeteLeftProgressContainer", "Landroid/widget/LinearLayout;", "getMCompeteLeftProgressContainer", "()Landroid/widget/LinearLayout;", "mCompeteLeftProgressContainer$delegate", "mCompeteLeftProgressNum", "getMCompeteLeftProgressNum", "mCompeteLeftProgressNum$delegate", "mCompeteProgressContainer", "getMCompeteProgressContainer", "mCompeteProgressContainer$delegate", "mCompeteRightHead", "getMCompeteRightHead", "mCompeteRightHead$delegate", "mCompeteRightHeadContainer", "getMCompeteRightHeadContainer", "mCompeteRightHeadContainer$delegate", "mCompeteRightProgressContainer", "getMCompeteRightProgressContainer", "mCompeteRightProgressContainer$delegate", "mCompeteRightProgressNum", "getMCompeteRightProgressNum", "mCompeteRightProgressNum$delegate", "mHeaderContainer", "getMHeaderContainer", "mHeaderContainer$delegate", "mHeaderIcon", "getMHeaderIcon", "mHeaderIcon$delegate", "mHeaderTitle", "getMHeaderTitle", "mHeaderTitle$delegate", "mJoinNum", "getMJoinNum", "mJoinNum$delegate", "mJoinTitle", "getMJoinTitle", "mJoinTitle$delegate", "mJumpToMoreCompeteUrl", "", "mLeftPartNum", "", "mPrizeIcon", "getMPrizeIcon", "mPrizeIcon$delegate", "mPrizeNum", "getMPrizeNum", "mPrizeNum$delegate", "mPrizePrefix", "getMPrizePrefix", "mPrizePrefix$delegate", "mRightPartNum", "mRootView", "mUserAgreeID", "minPureCount", "mmCardLeftTextChangeText", "mmCardRightTextChangeText", "quizInfoCallback", "com/baidu/tieba/view/headcard/compete/CompeteCardView$quizInfoCallback$1", "Lcom/baidu/tieba/view/headcard/compete/CompeteCardView$quizInfoCallback$1;", "quizInfoModel", "Lcom/baidu/tieba/view/headcard/model/QuizInfoModel;", "raceGuessingDialogHelper", "Lcom/baidu/tieba/view/headcard/utils/RaceGuessingDialogHelper;", "getRaceGuessingDialogHelper", "()Lcom/baidu/tieba/view/headcard/utils/RaceGuessingDialogHelper;", "raceGuessingDialogHelper$delegate", "rightQuizBetLottie", "getRightQuizBetLottie", "rightQuizBetLottie$delegate", "addPrizeNum", "", "bindDataToModel", "data", "bindDataToView", "isFromFrs", "", "fid", "forumName", "buttonClickAnim", "view", "type", "doBet", "getTextNum", "textView", "iniQuizBetLottieView", "modifyTotalCount", "addNum", "onAttachedToWindow", "onClick", "v", "onDetachedFromWindow", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onchangeSkinType", "refreshCardAgreeID", "refreshCardDataByLocal", "refreshCardStateData", "isNeedAnim", "refreshTotalCount", "refreshLeftByClick", "refreshProgress", "refreshRightByClick", "refreshViewState", "requestApplyGuess", "pourCount", "optionId", "showBetLottie", "showLeftLottie", "showPrizeNumAnim", "showRightLottie", "AnimHandler", "Companion", "tbadk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class CompeteCardView extends RelativeLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy A;
    public final Lazy B;
    public final Lazy C;
    public final Lazy D;
    public final Lazy E;
    public final Lazy F;
    public final Lazy G;
    public final Lazy H;
    public final Lazy I;
    public yta J;
    public String K;
    public String L;
    public String M;
    public long N;
    public long O;
    public long P;
    public jta Q;
    public final xta<QuizCardRespondedMessage.a> R;
    public final Lazy S;

    /* renamed from: T  reason: collision with root package name */
    public final Lazy f1174T;
    public int U;
    public final zta V;
    public final d W;
    public View a;
    public mta a0;
    public final Lazy b;
    public final Lazy b0;
    public final Lazy c;
    public final Lazy c0;
    public final Lazy d;
    public final Lazy d0;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1614858314, "Lcom/baidu/tieba/view/headcard/compete/CompeteCardView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1614858314, "Lcom/baidu/tieba/view/headcard/compete/CompeteCardView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CompeteCardView(TbPageContext<BaseFragmentActivity> context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* loaded from: classes8.dex */
    public static final class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<CompeteCardView> a;
        public long b;
        public long c;

        public a(CompeteCardView competeCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {competeCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(competeCardView, "competeCardView");
            this.a = new WeakReference<>(competeCardView);
            this.c = 100L;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                super.handleMessage(msg);
                CompeteCardView competeCardView = this.a.get();
                if (competeCardView == null || competeCardView.x(competeCardView.getMPrizeNum()) >= this.b) {
                    return;
                }
                competeCardView.q();
                sendEmptyMessageDelayed(0, this.c);
            }
        }

        public final void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.c = j;
            }
        }

        public final void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.b = j;
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements xta<QuizCardRespondedMessage.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CompeteCardView a;

        public b(CompeteCardView competeCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {competeCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = competeCardView;
        }

        @Override // com.baidu.tieba.xta
        public void a(String msg) {
            qta d;
            Long c;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                mta mtaVar = this.a.a0;
                if (mtaVar != null) {
                    CompeteCardView competeCardView = this.a;
                    boolean f = mtaVar.f();
                    if (!f) {
                        mta mtaVar2 = competeCardView.a0;
                        if (mtaVar2 != null && (d = mtaVar2.d()) != null && (c = d.c()) != null) {
                            competeCardView.z(c.longValue());
                        }
                    } else {
                        competeCardView.J(competeCardView.U);
                        competeCardView.L(competeCardView.U);
                    }
                    competeCardView.B();
                    competeCardView.C();
                    mta mtaVar3 = competeCardView.a0;
                    if (mtaVar3 != null) {
                        competeCardView.D(mtaVar3, true, !f);
                        competeCardView.F();
                    }
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xta
        /* renamed from: c */
        public void b(String msg, int i, QuizCardRespondedMessage.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, msg, i, aVar) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (i == 2530005 && aVar != null && !ad.isEmpty(aVar.a())) {
                    UrlManager.getInstance().dealOneLink(aVar.a());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ CompeteCardView b;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                Intrinsics.checkNotNullParameter(animator, "animator");
            }
        }

        public c(int i, CompeteCardView competeCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), competeCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = competeCardView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                Intrinsics.checkNotNullParameter(animator, "animator");
                if (this.a == 1) {
                    this.b.G();
                }
                if (this.a != 2) {
                    return;
                }
                this.b.E();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d implements zta.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CompeteCardView a;
        public final /* synthetic */ TbPageContext<BaseFragmentActivity> b;

        @Override // com.baidu.tieba.zta.a
        public void onError(int i, String errorMsg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, errorMsg) == null) {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            }
        }

        public d(CompeteCardView competeCardView, TbPageContext<BaseFragmentActivity> tbPageContext) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {competeCardView, tbPageContext};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = competeCardView;
            this.b = tbPageContext;
        }

        @Override // com.baidu.tieba.zta.a
        public void a(QuizInfo quizInfo, sta staVar) {
            qta d;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, quizInfo, staVar) == null) {
                if (quizInfo != null) {
                    CompeteCardView competeCardView = this.a;
                    mta mtaVar = competeCardView.a0;
                    if (mtaVar != null && (d = mtaVar.d()) != null) {
                        d.k(quizInfo);
                    }
                    if (competeCardView.a0 != null) {
                        mta mtaVar2 = competeCardView.a0;
                        Intrinsics.checkNotNull(mtaVar2);
                        competeCardView.D(mtaVar2, true, true);
                        competeCardView.F();
                    }
                }
                mta mtaVar3 = this.a.a0;
                if (mtaVar3 != null) {
                    CompeteCardView competeCardView2 = this.a;
                    TbPageContext<BaseFragmentActivity> tbPageContext = this.b;
                    if (!mtaVar3.f() || staVar == null) {
                        return;
                    }
                    RaceGuessingDialogHelper raceGuessingDialogHelper = competeCardView2.getRaceGuessingDialogHelper();
                    Activity pageActivity = tbPageContext.getPageActivity();
                    Intrinsics.checkNotNullExpressionValue(pageActivity, "context.pageActivity");
                    raceGuessingDialogHelper.d(pageActivity, staVar, competeCardView2.getDialogClickCallback());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CompeteCardView(final TbPageContext<BaseFragmentActivity> context, AttributeSet attributeSet, int i) {
        super(context.getPageActivity(), attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<View>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mHeaderContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return this.this$0.findViewById(R.id.card_header_container);
                }
                return (View) invokeV.objValue;
            }
        });
        this.c = LazyKt__LazyJVMKt.lazy(new Function0<TbImageView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mHeaderIcon$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TbImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TbImageView) this.this$0.findViewById(R.id.card_header_image_view);
                }
                return (TbImageView) invokeV.objValue;
            }
        });
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mHeaderTitle$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.card_header_title_view);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCardAbs$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.card_abs_tittle);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.f = LazyKt__LazyJVMKt.lazy(new Function0<View>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mBodyParticipate$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return this.this$0.findViewById(R.id.card_body_participate);
                }
                return (View) invokeV.objValue;
            }
        });
        this.g = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mPrizePrefix$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.card_prize_prefix);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.h = LazyKt__LazyJVMKt.lazy(new Function0<TbImageView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mPrizeIcon$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TbImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TbImageView) this.this$0.findViewById(R.id.card_prize_icon);
                }
                return (TbImageView) invokeV.objValue;
            }
        });
        this.i = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mPrizeNum$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.card_prize_num);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.j = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mJoinTitle$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.card_join_title);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.k = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mJoinNum$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.card_join_num);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.l = LazyKt__LazyJVMKt.lazy(new Function0<View>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCardLeftBottom$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return this.this$0.findViewById(R.id.card_compete_left_bottom);
                }
                return (View) invokeV.objValue;
            }
        });
        this.m = LazyKt__LazyJVMKt.lazy(new Function0<TbImageView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCardLeftIcon$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TbImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TbImageView) this.this$0.findViewById(R.id.card_compete_left_bottom_icon);
                }
                return (TbImageView) invokeV.objValue;
            }
        });
        this.n = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCardLeftText$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.card_compete_left_bottom_num);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.o = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCardLeftTitle$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.card_compete_left_bottom_text);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.p = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCardLeftPartTitle$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.card_compete_left_title);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.q = LazyKt__LazyJVMKt.lazy(new Function0<View>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCardRightBottom$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return this.this$0.findViewById(R.id.card_compete_right_bottom);
                }
                return (View) invokeV.objValue;
            }
        });
        this.r = LazyKt__LazyJVMKt.lazy(new Function0<TbImageView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCardRightIcon$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TbImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TbImageView) this.this$0.findViewById(R.id.card_compete_right_bottom_icon);
                }
                return (TbImageView) invokeV.objValue;
            }
        });
        this.s = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCardRightText$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.card_compete_right_bottom_num);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.t = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCardRightTitle$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.card_compete_right_bottom_text);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.u = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCardRightPartTitle$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.card_compete_right_title);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.v = LazyKt__LazyJVMKt.lazy(new Function0<View>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mBodyContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return this.this$0.findViewById(R.id.card_body_container);
                }
                return (View) invokeV.objValue;
            }
        });
        this.w = LazyKt__LazyJVMKt.lazy(new Function0<HeadImageView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCompeteLeftHead$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HeadImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (HeadImageView) this.this$0.findViewById(R.id.card_compete_left);
                }
                return (HeadImageView) invokeV.objValue;
            }
        });
        this.x = LazyKt__LazyJVMKt.lazy(new Function0<HeadImageView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCompeteRightHead$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final HeadImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (HeadImageView) this.this$0.findViewById(R.id.card_compete_right);
                }
                return (HeadImageView) invokeV.objValue;
            }
        });
        this.y = LazyKt__LazyJVMKt.lazy(new Function0<RoundRelativeLayout>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCompeteLeftHeadContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RoundRelativeLayout invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (RoundRelativeLayout) this.this$0.findViewById(R.id.card_compete_left_container);
                }
                return (RoundRelativeLayout) invokeV.objValue;
            }
        });
        this.z = LazyKt__LazyJVMKt.lazy(new Function0<RoundRelativeLayout>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCompeteRightHeadContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RoundRelativeLayout invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (RoundRelativeLayout) this.this$0.findViewById(R.id.card_compete_right_container);
                }
                return (RoundRelativeLayout) invokeV.objValue;
            }
        });
        this.A = LazyKt__LazyJVMKt.lazy(new Function0<TbImageView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCompeteBackground$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TbImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TbImageView) this.this$0.findViewById(R.id.card_compete_background);
                }
                return (TbImageView) invokeV.objValue;
            }
        });
        this.B = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCompeteProgressContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RelativeLayout invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (RelativeLayout) this.this$0.findViewById(R.id.conpete_proportion_progress_container);
                }
                return (RelativeLayout) invokeV.objValue;
            }
        });
        this.C = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCompeteLeftProgressContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (LinearLayout) this.this$0.findViewById(R.id.red_container);
                }
                return (LinearLayout) invokeV.objValue;
            }
        });
        this.D = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCompeteLeftProgressNum$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.left_agree_num);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.E = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCompeteRightProgressContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (LinearLayout) this.this$0.findViewById(R.id.blue_container);
                }
                return (LinearLayout) invokeV.objValue;
            }
        });
        this.F = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mCompeteRightProgressNum$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.right_agree_num);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.G = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mBottomJumpContainer$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RelativeLayout invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (RelativeLayout) this.this$0.findViewById(R.id.jump_to_more_compete_container);
                }
                return (RelativeLayout) invokeV.objValue;
            }
        });
        this.H = LazyKt__LazyJVMKt.lazy(new Function0<TextView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mBottomJumpText$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (TextView) this.this$0.findViewById(R.id.jump_to_more_compete_text);
                }
                return (TextView) invokeV.objValue;
            }
        });
        this.I = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$mBottomJumpIcon$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return (ImageView) this.this$0.findViewById(R.id.jump_to_more_compete_icon);
                }
                return (ImageView) invokeV.objValue;
            }
        });
        this.Q = new jta();
        this.R = new b(this);
        this.S = LazyKt__LazyJVMKt.lazy(CompeteCardView$raceGuessingDialogHelper$2.INSTANCE);
        this.f1174T = LazyKt__LazyJVMKt.lazy(new Function0<CompeteCardView$dialogClickCallback$2.a>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$dialogClickCallback$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* loaded from: classes8.dex */
            public static final class a implements RaceGuessingDialogHelper.IDialogClickCallback {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CompeteCardView a;

                public a(CompeteCardView competeCardView) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {competeCardView};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = competeCardView;
                }

                @Override // com.baidu.tieba.view.headcard.utils.RaceGuessingDialogHelper.IDialogClickCallback
                public void a(RaceGuessingDialogHelper.IDialogClickCallback.ClickType clickType) {
                    TextView mCardLeftText;
                    TextView mCardRightText;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, clickType) == null) {
                        Intrinsics.checkNotNullParameter(clickType, "clickType");
                        if (clickType == RaceGuessingDialogHelper.IDialogClickCallback.ClickType.CONFIRM && this.a.a0 != null) {
                            CompeteCardView competeCardView = this.a;
                            if (competeCardView.U == 1) {
                                mCardRightText = competeCardView.getMCardRightText();
                                competeCardView.x(mCardRightText);
                            } else {
                                mCardLeftText = competeCardView.getMCardLeftText();
                                competeCardView.x(mCardLeftText);
                            }
                            competeCardView.u();
                        }
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new a(this.this$0);
                }
                return (a) invokeV.objValue;
            }
        });
        this.W = new d(this, context);
        this.b0 = LazyKt__LazyJVMKt.lazy(new Function0<a>(this) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$animHandler$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CompeteCardView this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CompeteCardView.a invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new CompeteCardView.a(this.this$0);
                }
                return (CompeteCardView.a) invokeV.objValue;
            }
        });
        this.c0 = LazyKt__LazyJVMKt.lazy(new Function0<TBLottieAnimationView>(context) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$rightQuizBetLottie$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ TbPageContext<BaseFragmentActivity> $context;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {context};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$context = context;
            }

            /* loaded from: classes8.dex */
            public static final class a implements Animator.AnimatorListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TBLottieAnimationView a;

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                    }
                }

                public a(TBLottieAnimationView tBLottieAnimationView) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tBLottieAnimationView};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = tBLottieAnimationView;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        this.a.setVisibility(8);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TBLottieAnimationView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.$context.getPageActivity());
                    tBLottieAnimationView.setVisibility(8);
                    tBLottieAnimationView.addAnimatorListener(new a(tBLottieAnimationView));
                    return tBLottieAnimationView;
                }
                return (TBLottieAnimationView) invokeV.objValue;
            }
        });
        this.d0 = LazyKt__LazyJVMKt.lazy(new Function0<TBLottieAnimationView>(context) { // from class: com.baidu.tieba.view.headcard.compete.CompeteCardView$leftQuizBetLottie$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ TbPageContext<BaseFragmentActivity> $context;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {context};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.$context = context;
            }

            /* loaded from: classes8.dex */
            public static final class a implements Animator.AnimatorListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ TBLottieAnimationView a;

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                    }
                }

                public a(TBLottieAnimationView tBLottieAnimationView) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tBLottieAnimationView};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = tBLottieAnimationView;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                        this.a.setVisibility(8);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TBLottieAnimationView invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    TBLottieAnimationView tBLottieAnimationView = new TBLottieAnimationView(this.$context.getPageActivity());
                    tBLottieAnimationView.setVisibility(8);
                    tBLottieAnimationView.addAnimatorListener(new a(tBLottieAnimationView));
                    return tBLottieAnimationView;
                }
                return (TBLottieAnimationView) invokeV.objValue;
            }
        });
        View inflate = LayoutInflater.from(context.getPageActivity()).inflate(R.layout.card_compete_card_view, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context.pageActivit…te_card_view, this, true)");
        this.a = inflate;
        A(SkinManager.getCurrentSkinType());
        this.J = new yta(context);
        zta ztaVar = new zta();
        this.V = ztaVar;
        ztaVar.g(this.W);
        this.V.h(context.getUniqueId());
        this.J.c(this.R);
        getMCardLeftBottom().setOnClickListener(this);
        getMCardRightBottom().setOnClickListener(this);
        getMBottomJumpContainer().setOnClickListener(this);
        y();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void D(mta data, boolean z, boolean z2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        qta d2;
        Long l;
        LinkConf a2;
        String str6;
        LinkConf a3;
        Long l2;
        ArrayList<rta> arrayList;
        ArrayList<rta> arrayList2;
        boolean z3;
        Long g;
        rta rtaVar;
        qta d3;
        boolean z4;
        Long g2;
        Long l3;
        Long l4;
        boolean z5;
        Long l5;
        Long a4;
        Long c2;
        Long l6;
        Long l7;
        boolean z6;
        Long l8;
        Long a5;
        Long c3;
        Long l9;
        Long c4;
        QuizCardTopConf e;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        ThemeElement themeElement2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{data, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            TextView mHeaderTitle = getMHeaderTitle();
            QuizCardTopConf e2 = data.e();
            String str7 = null;
            if (e2 != null) {
                str = e2.text;
            } else {
                str = null;
            }
            mHeaderTitle.setText(str);
            TbImageView mCompeteBackground = getMCompeteBackground();
            ThemeColorInfo b2 = data.b();
            if (b2 != null && (themeElement2 = b2.day) != null) {
                str2 = themeElement2.pattern_image;
            } else {
                str2 = null;
            }
            mCompeteBackground.startLoad(str2);
            TbImageView mHeaderIcon = getMHeaderIcon();
            mta mtaVar = this.a0;
            if (mtaVar != null && (e = mtaVar.e()) != null && (themeColorInfo = e.img) != null && (themeElement = themeColorInfo.day) != null) {
                str3 = themeElement.pattern_image;
            } else {
                str3 = null;
            }
            mHeaderIcon.startLoad(str3);
            TextView mCardAbs = getMCardAbs();
            qta d4 = data.d();
            if (d4 != null) {
                str4 = d4.g();
            } else {
                str4 = null;
            }
            mCardAbs.setText(str4);
            TbImageView mPrizeIcon = getMPrizeIcon();
            qta d5 = data.d();
            if (d5 != null) {
                str5 = d5.i();
            } else {
                str5 = null;
            }
            mPrizeIcon.startLoad(str5);
            qta d6 = data.d();
            if (d6 != null && (c4 = d6.c()) != null) {
                c4.longValue();
            }
            if (z2) {
                TextView mPrizeNum = getMPrizeNum();
                qta d7 = data.d();
                if (d7 != null) {
                    l9 = d7.h();
                } else {
                    l9 = null;
                }
                mPrizeNum.setText(String.valueOf(l9));
            }
            if (data.d() != null) {
                qta d8 = data.d();
                if (d8 != null) {
                    arrayList = d8.d();
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    qta d9 = data.d();
                    if (d9 != null) {
                        arrayList2 = d9.d();
                    } else {
                        arrayList2 = null;
                    }
                    Intrinsics.checkNotNull(arrayList2);
                    if (arrayList2.size() > 1) {
                        qta d10 = data.d();
                        Intrinsics.checkNotNull(d10);
                        rta rtaVar2 = d10.d().get(0);
                        qta d11 = data.d();
                        if (d11 != null && (c3 = d11.c()) != null && c3.longValue() == 0) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            qta d12 = data.d();
                            if (d12 != null && (a5 = d12.a()) != null && a5.longValue() == 2) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            if (!z6) {
                                getMCardLeftIcon().setVisibility(0);
                                getMCardLeftText().setVisibility(0);
                                getMCardLeftIcon().startLoad(rtaVar2.a());
                                TextView mCardLeftText = getMCardLeftText();
                                qta d13 = data.d();
                                if (d13 != null) {
                                    l8 = d13.c();
                                } else {
                                    l8 = null;
                                }
                                mCardLeftText.setText(String.valueOf(l8));
                                getMCompeteLeftHead().setIsRound(true);
                                getMCompeteLeftHead().startLoad(rtaVar2.d());
                                getMCardLeftPartTitle().setText(rtaVar2.e());
                                getMCardLeftTitle().setText(rtaVar2.b());
                                this.M = rtaVar2.c();
                                if (rtaVar2.f() != null) {
                                    qta d14 = data.d();
                                    if (d14 != null) {
                                        l6 = d14.b();
                                    } else {
                                        l6 = null;
                                    }
                                    if (l6 != null) {
                                        Long f = rtaVar2.f();
                                        qta d15 = data.d();
                                        if (d15 != null) {
                                            l7 = d15.b();
                                        } else {
                                            l7 = null;
                                        }
                                        if (Intrinsics.areEqual(f, l7)) {
                                            i = 2;
                                            g = rtaVar2.g();
                                            if (g != null) {
                                                this.N = g.longValue();
                                                TextView mCompeteLeftProgressNum = getMCompeteLeftProgressNum();
                                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                                String string = getContext().getResources().getString(R.string.agree_with_it_num);
                                                Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…string.agree_with_it_num)");
                                                String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(this.N)}, 1));
                                                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                                                mCompeteLeftProgressNum.setText(format);
                                            }
                                            qta d16 = data.d();
                                            Intrinsics.checkNotNull(d16);
                                            rtaVar = d16.d().get(1);
                                            d3 = data.d();
                                            if (d3 == null && (c2 = d3.c()) != null && c2.longValue() == 0) {
                                                z4 = true;
                                            } else {
                                                z4 = false;
                                            }
                                            if (!z4) {
                                                qta d17 = data.d();
                                                if (d17 != null && (a4 = d17.a()) != null && a4.longValue() == 2) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                if (!z5) {
                                                    getMCardRightIcon().setVisibility(0);
                                                    getMCardRightText().setVisibility(0);
                                                    getMCardRightIcon().startLoad(rtaVar.a());
                                                    TextView mCardRightText = getMCardRightText();
                                                    qta d18 = data.d();
                                                    if (d18 != null) {
                                                        l5 = d18.c();
                                                    } else {
                                                        l5 = null;
                                                    }
                                                    mCardRightText.setText(String.valueOf(l5));
                                                    getMCompeteRightHead().setIsRound(true);
                                                    getMCompeteRightHead().startLoad(rtaVar.d());
                                                    getMCardRightPartTitle().setText(rtaVar.e());
                                                    getMCardRightTitle().setText(rtaVar.b());
                                                    this.L = rtaVar.c();
                                                    if (rtaVar.f() != null) {
                                                        qta d19 = data.d();
                                                        if (d19 != null) {
                                                            l3 = d19.b();
                                                        } else {
                                                            l3 = null;
                                                        }
                                                        if (l3 != null) {
                                                            Long f2 = rtaVar.f();
                                                            qta d20 = data.d();
                                                            if (d20 != null) {
                                                                l4 = d20.b();
                                                            } else {
                                                                l4 = null;
                                                            }
                                                            if (Intrinsics.areEqual(f2, l4)) {
                                                                i = 1;
                                                            }
                                                        }
                                                    }
                                                    g2 = rtaVar.g();
                                                    if (g2 != null) {
                                                        this.P = g2.longValue();
                                                        TextView mCompeteRightProgressNum = getMCompeteRightProgressNum();
                                                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                                                        String string2 = getContext().getResources().getString(R.string.agree_with_it_num);
                                                        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr…string.agree_with_it_num)");
                                                        String format2 = String.format(string2, Arrays.copyOf(new Object[]{String.valueOf(this.P)}, 1));
                                                        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                                                        mCompeteRightProgressNum.setText(format2);
                                                    }
                                                    d2 = data.d();
                                                    if (d2 != null) {
                                                        l = d2.j();
                                                    } else {
                                                        l = null;
                                                    }
                                                    if (l != null) {
                                                        qta d21 = data.d();
                                                        if (d21 != null) {
                                                            l2 = d21.j();
                                                        } else {
                                                            l2 = null;
                                                        }
                                                        if (l2 != null) {
                                                            long longValue = l2.longValue();
                                                            TextView mJoinNum = getMJoinNum();
                                                            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                                                            String string3 = getContext().getResources().getString(R.string.prize_join_num);
                                                            Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getStr…(R.string.prize_join_num)");
                                                            String format3 = String.format(string3, Arrays.copyOf(new Object[]{StringHelper.numberUniformFormatExtraWithCollectTwo(longValue)}, 1));
                                                            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
                                                            mJoinNum.setText(format3);
                                                        }
                                                    }
                                                    TextView mBottomJumpText = getMBottomJumpText();
                                                    a2 = data.a();
                                                    if (a2 != null) {
                                                        str6 = a2.text;
                                                    } else {
                                                        str6 = null;
                                                    }
                                                    mBottomJumpText.setText(str6);
                                                    a3 = data.a();
                                                    if (a3 != null) {
                                                        str7 = a3.url;
                                                    }
                                                    this.K = str7;
                                                    r(data);
                                                    A(TbadkApplication.getInst().getSkinType());
                                                    H(i, z);
                                                }
                                            }
                                            getMCardRightIcon().setVisibility(8);
                                            getMCardRightText().setVisibility(8);
                                            getMCompeteRightHead().setIsRound(true);
                                            getMCompeteRightHead().startLoad(rtaVar.d());
                                            getMCardRightPartTitle().setText(rtaVar.e());
                                            getMCardRightTitle().setText(rtaVar.b());
                                            this.L = rtaVar.c();
                                            if (rtaVar.f() != null) {
                                            }
                                            g2 = rtaVar.g();
                                            if (g2 != null) {
                                            }
                                            d2 = data.d();
                                            if (d2 != null) {
                                            }
                                            if (l != null) {
                                            }
                                            TextView mBottomJumpText2 = getMBottomJumpText();
                                            a2 = data.a();
                                            if (a2 != null) {
                                            }
                                            mBottomJumpText2.setText(str6);
                                            a3 = data.a();
                                            if (a3 != null) {
                                            }
                                            this.K = str7;
                                            r(data);
                                            A(TbadkApplication.getInst().getSkinType());
                                            H(i, z);
                                        }
                                    }
                                }
                                i = 0;
                                g = rtaVar2.g();
                                if (g != null) {
                                }
                                qta d162 = data.d();
                                Intrinsics.checkNotNull(d162);
                                rtaVar = d162.d().get(1);
                                d3 = data.d();
                                if (d3 == null) {
                                }
                                z4 = false;
                                if (!z4) {
                                }
                                getMCardRightIcon().setVisibility(8);
                                getMCardRightText().setVisibility(8);
                                getMCompeteRightHead().setIsRound(true);
                                getMCompeteRightHead().startLoad(rtaVar.d());
                                getMCardRightPartTitle().setText(rtaVar.e());
                                getMCardRightTitle().setText(rtaVar.b());
                                this.L = rtaVar.c();
                                if (rtaVar.f() != null) {
                                }
                                g2 = rtaVar.g();
                                if (g2 != null) {
                                }
                                d2 = data.d();
                                if (d2 != null) {
                                }
                                if (l != null) {
                                }
                                TextView mBottomJumpText22 = getMBottomJumpText();
                                a2 = data.a();
                                if (a2 != null) {
                                }
                                mBottomJumpText22.setText(str6);
                                a3 = data.a();
                                if (a3 != null) {
                                }
                                this.K = str7;
                                r(data);
                                A(TbadkApplication.getInst().getSkinType());
                                H(i, z);
                            }
                        }
                        getMCardLeftIcon().setVisibility(8);
                        getMCardLeftText().setVisibility(8);
                        getMCompeteLeftHead().setIsRound(true);
                        getMCompeteLeftHead().startLoad(rtaVar2.d());
                        getMCardLeftPartTitle().setText(rtaVar2.e());
                        getMCardLeftTitle().setText(rtaVar2.b());
                        this.M = rtaVar2.c();
                        if (rtaVar2.f() != null) {
                        }
                        i = 0;
                        g = rtaVar2.g();
                        if (g != null) {
                        }
                        qta d1622 = data.d();
                        Intrinsics.checkNotNull(d1622);
                        rtaVar = d1622.d().get(1);
                        d3 = data.d();
                        if (d3 == null) {
                        }
                        z4 = false;
                        if (!z4) {
                        }
                        getMCardRightIcon().setVisibility(8);
                        getMCardRightText().setVisibility(8);
                        getMCompeteRightHead().setIsRound(true);
                        getMCompeteRightHead().startLoad(rtaVar.d());
                        getMCardRightPartTitle().setText(rtaVar.e());
                        getMCardRightTitle().setText(rtaVar.b());
                        this.L = rtaVar.c();
                        if (rtaVar.f() != null) {
                        }
                        g2 = rtaVar.g();
                        if (g2 != null) {
                        }
                        d2 = data.d();
                        if (d2 != null) {
                        }
                        if (l != null) {
                        }
                        TextView mBottomJumpText222 = getMBottomJumpText();
                        a2 = data.a();
                        if (a2 != null) {
                        }
                        mBottomJumpText222.setText(str6);
                        a3 = data.a();
                        if (a3 != null) {
                        }
                        this.K = str7;
                        r(data);
                        A(TbadkApplication.getInst().getSkinType());
                        H(i, z);
                    }
                }
            }
            i = 0;
            d2 = data.d();
            if (d2 != null) {
            }
            if (l != null) {
            }
            TextView mBottomJumpText2222 = getMBottomJumpText();
            a2 = data.a();
            if (a2 != null) {
            }
            mBottomJumpText2222.setText(str6);
            a3 = data.a();
            if (a3 != null) {
            }
            this.K = str7;
            r(data);
            A(TbadkApplication.getInst().getSkinType());
            H(i, z);
        }
    }

    public /* synthetic */ CompeteCardView(TbPageContext tbPageContext, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(tbPageContext, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void J(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            if (i == 1) {
                M();
            }
            if (i == 2) {
                K();
            }
        }
    }

    public final long x(TextView textView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, textView)) == null) {
            Long longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(textView.getText().toString());
            if (longOrNull != null) {
                return longOrNull.longValue();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    private final a getAnimHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            return (a) this.b0.getValue();
        }
        return (a) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CompeteCardView$dialogClickCallback$2.a getDialogClickCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            return (CompeteCardView$dialogClickCallback$2.a) this.f1174T.getValue();
        }
        return (CompeteCardView$dialogClickCallback$2.a) invokeV.objValue;
    }

    private final TBLottieAnimationView getLeftQuizBetLottie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            return (TBLottieAnimationView) this.d0.getValue();
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    private final View getMBodyContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            Object value = this.v.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mBodyContainer>(...)");
            return (View) value;
        }
        return (View) invokeV.objValue;
    }

    private final View getMBodyParticipate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            Object value = this.f.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mBodyParticipate>(...)");
            return (View) value;
        }
        return (View) invokeV.objValue;
    }

    private final RelativeLayout getMBottomJumpContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) {
            Object value = this.G.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mBottomJumpContainer>(...)");
            return (RelativeLayout) value;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    private final ImageView getMBottomJumpIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            Object value = this.I.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mBottomJumpIcon>(...)");
            return (ImageView) value;
        }
        return (ImageView) invokeV.objValue;
    }

    private final TextView getMBottomJumpText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            Object value = this.H.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mBottomJumpText>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final TextView getMCardAbs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            Object value = this.e.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCardAbs>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final View getMCardLeftBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            Object value = this.l.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCardLeftBottom>(...)");
            return (View) value;
        }
        return (View) invokeV.objValue;
    }

    private final TbImageView getMCardLeftIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            Object value = this.m.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCardLeftIcon>(...)");
            return (TbImageView) value;
        }
        return (TbImageView) invokeV.objValue;
    }

    private final TextView getMCardLeftPartTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, this)) == null) {
            Object value = this.p.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCardLeftPartTitle>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getMCardLeftText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, this)) == null) {
            Object value = this.n.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCardLeftText>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final TextView getMCardLeftTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, this)) == null) {
            Object value = this.o.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCardLeftTitle>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final View getMCardRightBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, this)) == null) {
            Object value = this.q.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCardRightBottom>(...)");
            return (View) value;
        }
        return (View) invokeV.objValue;
    }

    private final TbImageView getMCardRightIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) {
            Object value = this.r.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCardRightIcon>(...)");
            return (TbImageView) value;
        }
        return (TbImageView) invokeV.objValue;
    }

    private final TextView getMCardRightPartTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            Object value = this.u.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCardRightPartTitle>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getMCardRightText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) {
            Object value = this.s.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCardRightText>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final TextView getMCardRightTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65565, this)) == null) {
            Object value = this.t.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCardRightTitle>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final TbImageView getMCompeteBackground() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, this)) == null) {
            Object value = this.A.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCompeteBackground>(...)");
            return (TbImageView) value;
        }
        return (TbImageView) invokeV.objValue;
    }

    private final HeadImageView getMCompeteLeftHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, this)) == null) {
            Object value = this.w.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCompeteLeftHead>(...)");
            return (HeadImageView) value;
        }
        return (HeadImageView) invokeV.objValue;
    }

    private final RoundRelativeLayout getMCompeteLeftHeadContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, this)) == null) {
            Object value = this.y.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCompeteLeftHeadContainer>(...)");
            return (RoundRelativeLayout) value;
        }
        return (RoundRelativeLayout) invokeV.objValue;
    }

    private final LinearLayout getMCompeteLeftProgressContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, this)) == null) {
            Object value = this.C.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCompeteLeftProgressContainer>(...)");
            return (LinearLayout) value;
        }
        return (LinearLayout) invokeV.objValue;
    }

    private final TextView getMCompeteLeftProgressNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, this)) == null) {
            Object value = this.D.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCompeteLeftProgressNum>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final RelativeLayout getMCompeteProgressContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, this)) == null) {
            Object value = this.B.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCompeteProgressContainer>(...)");
            return (RelativeLayout) value;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    private final HeadImageView getMCompeteRightHead() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, this)) == null) {
            Object value = this.x.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCompeteRightHead>(...)");
            return (HeadImageView) value;
        }
        return (HeadImageView) invokeV.objValue;
    }

    private final RoundRelativeLayout getMCompeteRightHeadContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, this)) == null) {
            Object value = this.z.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCompeteRightHeadContainer>(...)");
            return (RoundRelativeLayout) value;
        }
        return (RoundRelativeLayout) invokeV.objValue;
    }

    private final LinearLayout getMCompeteRightProgressContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65574, this)) == null) {
            Object value = this.E.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCompeteRightProgressContainer>(...)");
            return (LinearLayout) value;
        }
        return (LinearLayout) invokeV.objValue;
    }

    private final TextView getMCompeteRightProgressNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, this)) == null) {
            Object value = this.F.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mCompeteRightProgressNum>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final View getMHeaderContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, this)) == null) {
            Object value = this.b.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mHeaderContainer>(...)");
            return (View) value;
        }
        return (View) invokeV.objValue;
    }

    private final TbImageView getMHeaderIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, this)) == null) {
            Object value = this.c.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mHeaderIcon>(...)");
            return (TbImageView) value;
        }
        return (TbImageView) invokeV.objValue;
    }

    private final TextView getMHeaderTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, this)) == null) {
            Object value = this.d.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mHeaderTitle>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final TextView getMJoinNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, this)) == null) {
            Object value = this.k.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mJoinNum>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final TextView getMJoinTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, this)) == null) {
            Object value = this.j.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mJoinTitle>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final TbImageView getMPrizeIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, this)) == null) {
            Object value = this.h.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mPrizeIcon>(...)");
            return (TbImageView) value;
        }
        return (TbImageView) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getMPrizeNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, this)) == null) {
            Object value = this.i.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mPrizeNum>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    private final TextView getMPrizePrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, this)) == null) {
            Object value = this.g.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-mPrizePrefix>(...)");
            return (TextView) value;
        }
        return (TextView) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RaceGuessingDialogHelper getRaceGuessingDialogHelper() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, this)) == null) {
            return (RaceGuessingDialogHelper) this.S.getValue();
        }
        return (RaceGuessingDialogHelper) invokeV.objValue;
    }

    private final TBLottieAnimationView getRightQuizBetLottie() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65585, this)) == null) {
            return (TBLottieAnimationView) this.c0.getValue();
        }
        return (TBLottieAnimationView) invokeV.objValue;
    }

    public final void B() {
        mta mtaVar;
        qta d2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (mtaVar = this.a0) != null && (d2 = mtaVar.d()) != null) {
            d2.l(Long.valueOf(this.O));
        }
    }

    public final void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            getRightQuizBetLottie().setVisibility(8);
            getLeftQuizBetLottie().setVisibility(0);
            getLeftQuizBetLottie().setAnimation(R.raw.quiz_bet_left_lottie);
            getLeftQuizBetLottie().postPlayAnimation();
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            getLeftQuizBetLottie().setVisibility(8);
            getRightQuizBetLottie().setVisibility(0);
            getRightQuizBetLottie().setAnimation(R.raw.quiz_bet_right_lottie);
            getRightQuizBetLottie().playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onAttachedToWindow();
            this.V.f();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDetachedFromWindow();
            this.V.d();
            getRaceGuessingDialogHelper().c();
            this.J.c(null);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            getMPrizeNum().setText(String.valueOf(x(getMPrizeNum()) + 1));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            addView(getRightQuizBetLottie(), new RelativeLayout.LayoutParams(-2, -2));
            addView(getLeftQuizBetLottie(), new RelativeLayout.LayoutParams(-2, -2));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            super.onMeasure(i, i2);
            F();
        }
    }

    public final void t(View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048597, this, view2, i) != null) || view2 == null) {
            return;
        }
        ViewPropertyAnimator animate = view2.animate();
        animate.alpha(0.5f);
        animate.setListener(new c(i, this));
        animate.start();
    }

    public final void A(int i) {
        String str;
        QuizCardTopConf e;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        ThemeColorInfo b2;
        ThemeElement themeElement2;
        String str2;
        QuizCardTopConf e2;
        ThemeColorInfo themeColorInfo2;
        ThemeElement themeElement3;
        ThemeColorInfo b3;
        ThemeElement themeElement4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            EMManager.from(getMCardLeftBottom()).setCorner(R.string.J_X18).setBackGroundColor(R.color.CAM_X0101);
            EMManager.from(getMCardRightBottom()).setCorner(R.string.J_X18).setBackGroundColor(R.color.CAM_X0101);
            EMManager.from(getMCardLeftTitle()).setTextSize(R.dimen.T_X12).setTextColor(R.color.CAM_X0610).setTextStyle(R.string.F_X02);
            EMManager.from(getMCardRightTitle()).setTextSize(R.dimen.T_X12).setTextColor(R.color.CAM_X0610).setTextStyle(R.string.F_X02);
            EMManager.from(getMHeaderTitle()).setTextSize(R.dimen.T_X06).setTextColor(R.color.CAM_X0105).setTextStyle(R.string.F_X02);
            EMManager.from(getMCardAbs()).setTextSize(R.dimen.T_X05).setTextColor(R.color.CAM_X0105).setTextStyle(R.string.F_X02);
            EMManager.from(getMPrizePrefix()).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0107).setTextStyle(R.string.F_X01);
            EMManager.from(getMJoinNum()).setTextSize(R.dimen.T_X08).setTextColor(R.color.CAM_X0107).setTextStyle(R.string.F_X01);
            EMManager.from(getMCardLeftText()).setTextSize(R.dimen.T_X06).setTextColor(R.color.CAM_X0305).setTextStyle(R.string.F_X02);
            EMManager.from(getMCardRightText()).setTextSize(R.dimen.T_X06).setTextColor(R.color.CAM_X0305).setTextStyle(R.string.F_X02);
            EMManager.from(getMPrizeNum()).setTextSize(R.dimen.T_X06).setTextColor(R.color.CAM_X0305).setTextStyle(R.string.F_X02);
            EMManager.from(getMBottomJumpText()).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0108).setTextStyle(R.string.F_X01);
            EMManager.from(getMCardLeftPartTitle()).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0101).setTextStyle(R.string.F_X02);
            EMManager.from(getMCardRightPartTitle()).setTextSize(R.dimen.T_X07).setTextColor(R.color.CAM_X0101).setTextStyle(R.string.F_X02);
            EMManager.from(getMCompeteLeftProgressNum()).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0101).setTextStyle(R.string.F_X01);
            EMManager.from(getMCompeteRightProgressNum()).setTextSize(R.dimen.T_X09).setTextColor(R.color.CAM_X0101).setTextStyle(R.string.F_X01);
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.tbds119);
            getMCompeteLeftHeadContainer().setBackgroundColor(SkinManager.getColor(R.color.CAM_X0622));
            getMCompeteRightHeadContainer().setBackgroundColor(SkinManager.getColor(R.color.CAM_X0622));
            float f = dimens;
            getMCompeteLeftHeadContainer().setRoundLayoutRadius(new float[]{f, f, f, f, f, f, f, f});
            getMCompeteRightHeadContainer().setRoundLayoutRadius(new float[]{f, f, f, f, f, f, f, f});
            SkinManager.setBackgroundResource(getMHeaderContainer(), R.drawable.compete_card_header_background);
            WebPManager.setPureDrawable(getMBottomJumpIcon(), R.drawable.icon_pure_jingchai_right, R.color.CAM_X0108, WebPManager.ResourceStateType.NORMAL);
            String str3 = null;
            if (TbadkApplication.getInst().getSkinType() == 0) {
                TbImageView mCompeteBackground = getMCompeteBackground();
                mta mtaVar = this.a0;
                if (mtaVar != null && (b3 = mtaVar.b()) != null && (themeElement4 = b3.day) != null) {
                    str2 = themeElement4.pattern_image;
                } else {
                    str2 = null;
                }
                mCompeteBackground.startLoad(str2);
                TbImageView mHeaderIcon = getMHeaderIcon();
                mta mtaVar2 = this.a0;
                if (mtaVar2 != null && (e2 = mtaVar2.e()) != null && (themeColorInfo2 = e2.img) != null && (themeElement3 = themeColorInfo2.day) != null) {
                    str3 = themeElement3.pattern_image;
                }
                mHeaderIcon.startLoad(str3);
                return;
            }
            TbImageView mCompeteBackground2 = getMCompeteBackground();
            mta mtaVar3 = this.a0;
            if (mtaVar3 != null && (b2 = mtaVar3.b()) != null && (themeElement2 = b2.night) != null) {
                str = themeElement2.pattern_image;
            } else {
                str = null;
            }
            mCompeteBackground2.startLoad(str);
            TbImageView mHeaderIcon2 = getMHeaderIcon();
            mta mtaVar4 = this.a0;
            if (mtaVar4 != null && (e = mtaVar4.e()) != null && (themeColorInfo = e.img) != null && (themeElement = themeColorInfo.night) != null) {
                str3 = themeElement.pattern_image;
            }
            mHeaderIcon2.startLoad(str3);
        }
    }

    public final void C() {
        qta d2;
        Long j;
        qta qtaVar;
        qta d3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            mta mtaVar = this.a0;
            if (mtaVar != null && (d3 = mtaVar.d()) != null && d3.d().size() > 1) {
                if (this.U == 2 && d3.d().get(0).g() != null) {
                    Long g = d3.d().get(0).g();
                    Intrinsics.checkNotNull(g);
                    d3.d().get(0).i(Long.valueOf(g.longValue() + 1));
                } else if (this.U == 1 && d3.d().get(1).g() != null) {
                    Long g2 = d3.d().get(1).g();
                    Intrinsics.checkNotNull(g2);
                    d3.d().get(1).i(Long.valueOf(g2.longValue() + 1));
                }
            }
            mta mtaVar2 = this.a0;
            if (mtaVar2 != null && (d2 = mtaVar2.d()) != null && (j = d2.j()) != null) {
                long longValue = j.longValue();
                mta mtaVar3 = this.a0;
                if (mtaVar3 != null) {
                    qtaVar = mtaVar3.d();
                } else {
                    qtaVar = null;
                }
                if (qtaVar != null) {
                    qtaVar.n(Long.valueOf(longValue + 1));
                }
            }
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            getMCardLeftBottom().setAlpha(1.0f);
            EMManager.from(getMCardLeftBottom()).setCorner(R.string.J_X18).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0101).setBackGroundColor(R.color.transparent);
            EMManager.from(getMCardLeftTitle()).setTextColor(R.color.CAM_X0101);
            getMCardRightBottom().setAlpha(0.5f);
            getMCardLeftIcon().setVisibility(8);
            getMCardLeftText().setVisibility(8);
            getMCardLeftTitle().setText(this.M);
            getMCardRightBottom().setClickable(false);
            getMCardLeftBottom().setClickable(false);
        }
    }

    public final void F() {
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long j = this.P;
            long j2 = this.N;
            long j3 = j + j2;
            if (j3 != 0) {
                f = ((float) j2) / ((float) j3);
            } else {
                f = 0.5f;
            }
            float measuredWidthAndState = getMCompeteLeftProgressNum().getMeasuredWidthAndState() + getContext().getResources().getDimension(R.dimen.tbds70);
            float measuredWidthAndState2 = getMCompeteRightProgressNum().getMeasuredWidthAndState() + getContext().getResources().getDimension(R.dimen.tbds70);
            int measuredWidthAndState3 = getMCompeteProgressContainer().getMeasuredWidthAndState();
            if (measuredWidthAndState3 != 0) {
                float f2 = measuredWidthAndState3;
                float f3 = f * f2;
                if (f3 < measuredWidthAndState) {
                    ViewCommonUtil.setViewWidthHeight(getMCompeteLeftProgressContainer(), (int) measuredWidthAndState, -3);
                } else if (f2 - f3 > measuredWidthAndState2) {
                    ViewCommonUtil.setViewWidthHeight(getMCompeteLeftProgressContainer(), (int) f3, -3);
                } else {
                    ViewCommonUtil.setViewWidthHeight(getMCompeteLeftProgressContainer(), (int) (f2 - measuredWidthAndState2), -3);
                }
            }
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            getMCardRightBottom().setAlpha(1.0f);
            EMManager.from(getMCardRightBottom()).setCorner(R.string.J_X18).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0101).setBackGroundColor(R.color.transparent);
            EMManager.from(getMCardRightTitle()).setTextColor(R.color.CAM_X0101);
            getMCardLeftBottom().setAlpha(0.5f);
            getMCardRightIcon().setVisibility(8);
            getMCardRightText().setVisibility(8);
            getMCardRightTitle().setText(this.L);
            getMCardRightBottom().setClickable(false);
            getMCardLeftBottom().setEnabled(false);
        }
    }

    public final void u() {
        mta mtaVar;
        qta d2;
        boolean z;
        int i;
        long x;
        Long f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (mtaVar = this.a0) != null && (d2 = mtaVar.d()) != null) {
            if (d2.d().size() > 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                d2 = null;
            }
            if (d2 == null || (i = this.U) == 0) {
                return;
            }
            if (i == 1) {
                x = x(getMCardRightText());
            } else {
                x = x(getMCardLeftText());
            }
            if (this.U == 1) {
                f = d2.d().get(1).f();
            } else {
                f = d2.d().get(0).f();
            }
            if (f != null) {
                I(x, f.longValue());
            }
        }
    }

    public final void H(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i == 1) {
                if (z) {
                    t(getMCardRightBottom(), i);
                } else {
                    G();
                }
            }
            if (i == 2) {
                if (z) {
                    t(getMCardLeftBottom(), i);
                } else {
                    E();
                }
            }
        }
    }

    public final void I(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.J.e(j);
            this.J.d(j2);
            this.J.b();
        }
    }

    public final void L(int i) {
        long x;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048587, this, i) != null) || i == 0) {
            return;
        }
        long j = 0;
        if (i != 1) {
            if (i != 2) {
                x = 0;
            } else {
                x = x(getMCardLeftText());
            }
        } else {
            x = x(getMCardRightText());
        }
        z(x);
        if (x > 100) {
            getMPrizeNum().setText(String.valueOf(x(getMPrizeNum()) + x));
            return;
        }
        if (x <= 10) {
            j = 100;
        }
        getAnimHandler().a(j);
        getAnimHandler().b(x(getMPrizeNum()) + x);
        getAnimHandler().sendEmptyMessage(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, view2) != null) || view2 == null) {
            return;
        }
        if (view2.getId() != R.id.card_compete_left_bottom && view2.getId() != R.id.card_compete_right_bottom) {
            if (view2.getId() == R.id.jump_to_more_compete_container || view2.getId() == R.id.jump_to_more_compete_text || view2.getId() == R.id.jump_to_more_compete_icon) {
                this.Q.d(3);
                if (this.K != null) {
                    UrlManager.getInstance().dealOneLink(this.K);
                    return;
                }
                return;
            }
            return;
        }
        mta mtaVar = this.a0;
        if (mtaVar != null) {
            boolean f = mtaVar.f();
            qta d2 = mtaVar.d();
            if (d2 != null) {
                if (d2.d().size() > 1) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    d2 = null;
                }
                if (d2 != null) {
                    long j = 0;
                    if (view2.getId() == R.id.card_compete_left_bottom) {
                        this.U = 2;
                        this.Q.d(1);
                        if (d2.d().get(0).f() != null) {
                            Long f2 = d2.d().get(0).f();
                            Intrinsics.checkNotNull(f2);
                            j = f2.longValue();
                        }
                    }
                    if (view2.getId() == R.id.card_compete_right_bottom) {
                        this.U = 1;
                        this.Q.d(2);
                        if (d2.d().get(1).f() != null) {
                            Long f3 = d2.d().get(1).f();
                            Intrinsics.checkNotNull(f3);
                            j = f3.longValue();
                        }
                    }
                    this.O = j;
                    this.V.c(String.valueOf(d2.f()), String.valueOf(d2.e()), String.valueOf(j));
                    if (!f) {
                        u();
                    }
                }
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            ViewParent parent = getMPrizeIcon().getParent();
            int left = getMPrizeIcon().getLeft();
            int top = getMPrizeIcon().getTop();
            while (parent != null && !(parent instanceof CompeteCardView)) {
                View view2 = (View) parent;
                left += view2.getLeft();
                top += view2.getTop();
                parent = view2.getParent();
            }
            ViewParent parent2 = getMCardRightBottom().getParent();
            int left2 = getMCardRightBottom().getLeft();
            int top2 = getMCardRightBottom().getTop();
            while (parent2 != null && !(parent2 instanceof CompeteCardView)) {
                View view3 = (View) parent2;
                left2 += view3.getLeft();
                top2 += view3.getTop();
                parent2 = view3.getParent();
            }
            ViewParent parent3 = getMCardLeftBottom().getParent();
            int left3 = getMCardLeftBottom().getLeft();
            int top3 = getMCardLeftBottom().getTop();
            while (parent3 != null && !(parent3 instanceof CompeteCardView)) {
                View view4 = (View) parent3;
                left3 += view4.getLeft();
                top3 += view4.getTop();
                parent3 = view4.getParent();
            }
            ViewGroup.LayoutParams layoutParams = getRightQuizBetLottie().getLayoutParams();
            int width = left2 + getMCardRightBottom().getWidth();
            int height = top2 + getMCardRightBottom().getHeight();
            int i5 = width - left;
            int i6 = height - top;
            getRightQuizBetLottie().setLeft(left);
            getRightQuizBetLottie().setTop(top);
            getRightQuizBetLottie().setRight(width);
            getRightQuizBetLottie().setBottom(height);
            if (i5 != layoutParams.width || i6 != layoutParams.height) {
                layoutParams.width = i5;
                layoutParams.height = i6;
                getRightQuizBetLottie().setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = getLeftQuizBetLottie().getLayoutParams();
            int width2 = left3 + getMCardLeftBottom().getWidth();
            int height2 = top3 + getMCardLeftBottom().getHeight();
            int i7 = width2 - left;
            int i8 = height2 - top;
            int i9 = i7 / 3;
            getLeftQuizBetLottie().setLeft(left - i9);
            getLeftQuizBetLottie().setTop(top);
            getLeftQuizBetLottie().setRight(width2 - i9);
            getLeftQuizBetLottie().setBottom(height2);
            if (i7 != layoutParams2.width || i8 != layoutParams2.height) {
                layoutParams2.width = i7;
                layoutParams2.height = i8;
                getLeftQuizBetLottie().setLayoutParams(layoutParams2);
            }
        }
    }

    public final void r(mta data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            qta d2 = data.d();
            if (d2 != null) {
                Long e = d2.e();
                if (e != null) {
                    this.J.f(e.longValue());
                }
                this.J.h(TbadkCoreApplication.getCurrentAccountId());
                Long f = d2.f();
                if (f != null) {
                    this.J.g(f.longValue());
                }
            }
        }
    }

    public final void z(long j) {
        mta mtaVar;
        qta d2;
        Long h;
        qta qtaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048601, this, j) == null) && (mtaVar = this.a0) != null && (d2 = mtaVar.d()) != null && (h = d2.h()) != null) {
            long longValue = h.longValue();
            mta mtaVar2 = this.a0;
            if (mtaVar2 != null) {
                qtaVar = mtaVar2.d();
            } else {
                qtaVar = null;
            }
            if (qtaVar != null) {
                qtaVar.m(Long.valueOf(longValue + j));
            }
        }
    }

    public final void s(mta data, boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{data, Boolean.valueOf(z), str, str2}) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.a0 = data;
            this.Q.c(data);
            this.Q.a(str);
            this.Q.b(str2);
            if (!data.g()) {
                this.Q.e();
                data.i(true);
            }
            D(data, false, true);
        }
    }
}
