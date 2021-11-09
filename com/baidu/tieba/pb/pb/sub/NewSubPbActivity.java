package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.c0.d;
import b.a.q0.f1.n.f;
import b.a.q0.i.a;
import b.a.q0.s.g0.f;
import b.a.q0.s.q.d2;
import b.a.q0.s.s.a;
import b.a.q0.s.s.b;
import b.a.r0.k2.u.f.w0;
import b.a.r0.x0.q2.a.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.dialog.WriteTipBubbleController;
import com.baidu.tbadk.core.message.GameLaunchMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.PreLoadImageHelper;
import com.baidu.tbadk.core.util.ReplyPrivacyCheckController;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.baidu.tbadk.core.util.videoPreload.PreLoadVideoHelper;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbMoreDialog;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.pb.sub.SubPbModel;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes9.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements VoiceManager.j, b.a.q0.f1.n.i, BdListView.p, b.a.r0.k2.u.a<NewSubPbActivity> {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TB_GAME_TYPE = "tbgametype";
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId MESSAGE_ID_NEWSUB_PB;
    public r0 deleteReplayCallback;
    public r0 forbidUserCallback;
    public boolean hasRemindedEditorTips;
    public int imgIndex;
    public boolean index_valid;
    public boolean isFirstLoadData;
    public boolean isFromVideoMiddle;
    public int lastScrollState;
    public b.a.q0.x.x.b mCheckPostCallBack;
    public View.OnClickListener mCommonClickListener;
    public b.a.e.a.f mCtx;
    public b.a.q0.x.x.h mEditor;
    public TbRichTextMemeInfo mEmotionInfo;
    public b.a.r0.k2.u.f.c1.a mEvent;
    public Object mExtra;
    public int mFromVideoTab;
    public b.a.e.e.k.b<GifView> mGifViewPool;
    public TbRichTextView.z mImageClickListener;
    public b.a.e.e.k.b<ImageView> mImageViewPool;
    public boolean mIsFromCDN;
    public boolean mIsFromFoldComment;
    public boolean mIsFromPb;
    public boolean mIsFromSchema;
    public boolean mIsFromVideoTAb;
    public boolean mIsPaused;
    public boolean mIsRichTextListenerAcked;
    public boolean mIsSoftKeyBoardVisible;
    public PbCommenFloorItemViewHolder mItemClickShowSoftKeyBoardViewHolder;
    public a.InterfaceC0664a mMarkDoneCallBack;
    public b.a.q0.i.a mMarkModel;
    public b.a.e.e.k.b<RelativeLayout> mMemeViewPool;
    public b.a.q0.s.c0.a mMessageHelper;
    public b.a.r0.l3.j0.e mMsgData;
    public final b.c mOnImageSaveClickListener;
    public View.OnLongClickListener mOnLongClickListener;
    public NewWriteModel.g mOnPostWriteNewCallback;
    public final f.g mOnPullRefreshListener;
    public BdUniqueId mOnlyDisagreeId;
    public PermissionJudgePolicy mPermissionJudgement;
    public b.a.e.a.e mPostManageCallBack;
    public ForumManageModel mPostManageModel;
    public PbMoreDialog mPostMoreOptionView;
    public PostWriteCallBackData mPostWriteCallBackData;
    public b.a.q0.x.x.c mPrePostCallBack;
    public b.a.r0.x0.q2.a.c mProfessionController;
    public b.a.r0.k2.o<b.a.r0.k2.r.s> mRefreshData;
    public String mReplyHintText;
    public ReplyPrivacyCheckController mReplyPrivacyController;
    public b.a.e.l.d.a mSaveBdImage;
    public w0 mSaveImageHelper;
    public String mSaveImageUrl;
    public b.a.r0.d4.c mSensitiveProcessController;
    public EditText mSubFloorEditText;
    public SubPbModel.b mSubPbCallBack;
    public SubPbModel mSubPbModel;
    public AbsListView.OnScrollListener mSubPbScrollListener;
    public b.a.r0.k2.u.h.a mSubPbView;
    public b.a.e.e.k.b<TextView> mTextViewPool;
    public b.a.e.e.k.b<LinearLayout> mTextVoiceViewPool;
    public b.a.q0.s.g0.c mToastMute;
    public b.a.r0.k2.u.g.a mUEGReportController;
    public b.a.r0.v3.b mUserBlockController;
    public CustomMessageListener mUserMuteAddListener;
    public CustomMessageListener mUserMuteCheckListener;
    public CustomMessageListener mUserMuteDelListener;
    public BdUniqueId mVideoPageUniqueId;
    public VoiceManager mVoiceManager;
    public b.a.e.e.k.b<View> mVoiceViewPool;
    public boolean needOpenEditor;
    public PostData postData;
    @NonNull
    public TiePlusEventController.d richTextEventAckedCallback;
    public CustomMessageListener richTextIntentClickListener;
    public boolean showTrisectionAndFeedback;
    public CustomMessageListener subpbReplyListener;
    @Nullable
    public TiePlusEventController tiePlusEventController;
    public CustomMessageListener updatePendantMessageListener;

    /* loaded from: classes9.dex */
    public class a implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52581a;

        public a(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52581a = newSubPbActivity;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) && z) {
                this.f52581a.mEditor.F();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a0 implements b.a.e.e.k.c<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52582a;

        public a0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52582a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ RelativeLayout c(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            h(relativeLayout2);
            return relativeLayout2;
        }

        public RelativeLayout e(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: g */
        public RelativeLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new RelativeLayout(this.f52582a.getPageContext().getPageActivity()) : (RelativeLayout) invokeV.objValue;
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52583e;

        public b(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52583e = newSubPbActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f52583e.mSubPbModel == null) {
                return;
            }
            this.f52583e.mSubPbModel.loadData();
        }
    }

    /* loaded from: classes9.dex */
    public class b0 extends b.a.q0.o0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52584a;

        public b0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52584a = newSubPbActivity;
        }

        @Override // b.a.q0.o0.b
        public int getMaxCost() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.a.q0.o0.e.b().c() : invokeV.intValue;
        }

        @Override // b.a.q0.o0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52585a;

        public c(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52585a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.f52585a.mSubPbView.z0(postData);
                this.f52585a.mSubPbView.v0(null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f52586e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52587f;

        public c0(NewSubPbActivity newSubPbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52587f = newSubPbActivity;
            this.f52586e = userMuteAddAndDelCustomMessage;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f52587f.mSubPbView.A0();
                MessageManager.getInstance().sendMessage(this.f52586e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ View f52588a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.x.x.h f52589b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52590c;

        public d(NewSubPbActivity newSubPbActivity, View view, b.a.q0.x.x.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, view, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52590c = newSubPbActivity;
            this.f52588a = view;
            this.f52589b = hVar;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, str) == null) {
                this.f52588a.performClick();
                this.f52589b.q();
                this.f52589b.t().h().setText(str);
                Editable text = this.f52589b.t().h().getText();
                if (TextUtils.isEmpty(text)) {
                    return;
                }
                this.f52589b.t().h().setSelection(text.length());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52591e;

        public d0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52591e = newSubPbActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements SubPbModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52592a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.r0.k2.r.s f52593e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ e f52594f;

            public a(e eVar, b.a.r0.k2.r.s sVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, sVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52594f = eVar;
                this.f52593e = sVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f52594f.f52592a.needOpenEditor = false;
                    this.f52594f.f52592a.openEditor(this.f52593e.i(), false);
                }
            }
        }

        public e(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52592a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.b
        public void a(boolean z, int i2, String str, b.a.r0.k2.r.s sVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), str, sVar}) == null) || this.f52592a.mSubPbView == null) {
                return;
            }
            this.f52592a.mSubPbView.l0();
            if (!z) {
                this.f52592a.onNetOrDataError(i2, str);
                return;
            }
            this.f52592a.mSubPbView.S();
            if (sVar != null) {
                if (sVar.i() != null || this.f52592a.mSubPbModel != null) {
                    sVar.i().A0(this.f52592a.mSubPbModel.w0());
                }
                if (this.f52592a.mSubPbView != null) {
                    this.f52592a.initEditor(sVar.l() != null && sVar.l().Q1());
                    if (this.f52592a.mEditor != null && this.f52592a.mEditor.a() != null) {
                        this.f52592a.mEditor.a().onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
                    }
                    this.f52592a.mSubPbView.H0(sVar, this.f52592a.mSubPbModel.B0(), this.f52592a.mSubPbModel.A0() != null, this.f52592a.isFirstLoadData);
                    if (this.f52592a.isFirstLoadData) {
                        this.f52592a.mSubPbView.G().setSelectionFromTop(this.f52592a.mSubPbView.G().getHeaderViewsCount() + 1, -b.a.e.e.p.l.g(this.f52592a, b.a.r0.k2.g.tbds18));
                        this.f52592a.checkShowKeyboard();
                        this.f52592a.isFirstLoadData = false;
                    }
                }
                if (this.f52592a.mEditor != null) {
                    this.f52592a.mEditor.G(sVar.a());
                    this.f52592a.mEditor.b0(sVar.l());
                    if (this.f52592a.getIntent() != null && this.f52592a.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && this.f52592a.needOpenEditor) {
                        b.a.e.e.m.e.a().postDelayed(new a(this, sVar), 200L);
                    }
                }
                if (this.f52592a.mRefreshData == null) {
                    this.f52592a.mRefreshData = new b.a.r0.k2.o();
                }
                this.f52592a.mRefreshData.b(sVar);
                this.f52592a.mRefreshData.c(0);
                NewSubPbActivity newSubPbActivity = this.f52592a;
                newSubPbActivity.mReplyPrivacyController.setLikeUserData(newSubPbActivity.mSubPbModel.i0());
            }
            String stringExtra = this.f52592a.getIntent().getStringExtra("key_open_editor_tips");
            if (TextUtils.isEmpty(stringExtra) || this.f52592a.hasRemindedEditorTips) {
                return;
            }
            this.f52592a.hasRemindedEditorTips = true;
            NewSubPbActivity newSubPbActivity2 = this.f52592a;
            newSubPbActivity2.showDeleteResumeEditorTips(newSubPbActivity2.mSubPbView.N(), this.f52592a.mEditor, stringExtra);
        }
    }

    /* loaded from: classes9.dex */
    public class e0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52595e;

        public e0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52595e = newSubPbActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements a.InterfaceC0664a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52596a;

        public f(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52596a = newSubPbActivity;
        }

        @Override // b.a.q0.i.a.InterfaceC0664a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.f52596a.mMarkModel != null) {
                        this.f52596a.mMarkModel.h(z2);
                    }
                    MarkData f2 = this.f52596a.mMarkModel.f();
                    b.a.r0.k2.o oVar = new b.a.r0.k2.o();
                    oVar.c(2);
                    if (z2) {
                        oVar.b(f2);
                        if (this.f52596a.mMarkModel != null) {
                            if (f2 != null) {
                                this.f52596a.mSubPbModel.Z0(true);
                                this.f52596a.mSubPbModel.a1(this.f52596a.mSubPbModel.y());
                                this.f52596a.showToast(b.a.r0.k2.l.add_mark_on_pb);
                            } else {
                                NewSubPbActivity newSubPbActivity = this.f52596a;
                                newSubPbActivity.showToast(newSubPbActivity.getPageContext().getString(b.a.r0.k2.l.add_mark));
                            }
                            if (this.f52596a.mSubPbView != null) {
                                this.f52596a.mSubPbView.L0(true);
                            }
                        }
                    } else {
                        oVar.b(null);
                        this.f52596a.mSubPbModel.Z0(false);
                        this.f52596a.mSubPbModel.a1(null);
                        NewSubPbActivity newSubPbActivity2 = this.f52596a;
                        newSubPbActivity2.showToast(newSubPbActivity2.getPageContext().getString(b.a.r0.k2.l.remove_mark));
                        if (this.f52596a.mSubPbView != null) {
                            this.f52596a.mSubPbView.L0(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, oVar));
                    return;
                }
                NewSubPbActivity newSubPbActivity3 = this.f52596a;
                newSubPbActivity3.showToast(newSubPbActivity3.getPageContext().getString(b.a.r0.k2.l.update_mark_failed));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52597e;

        public f0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52597e = newSubPbActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar.dismiss();
                    ((TbPageContext) this.f52597e.mCtx).showToast(b.a.r0.k2.l.frs_header_games_unavailable);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f52597e.mCtx.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements r0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52598a;

        public g(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52598a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.r0
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                Object[] objArr = (Object[]) obj;
                String valueOf = (this.f52598a.mSubPbModel.j0() == null || this.f52598a.mSubPbModel.j0().l() == null || this.f52598a.mSubPbModel.j0().l().J() == null) ? "" : String.valueOf(this.f52598a.mSubPbModel.j0().l().J().getUserId());
                String valueOf2 = objArr.length > 1 ? String.valueOf(objArr[1]) : "";
                String valueOf3 = objArr.length > 2 ? String.valueOf(objArr[2]) : "";
                this.f52598a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f52598a.getPageContext().getPageActivity(), this.f52598a.mSubPbModel.j0().d().getId(), this.f52598a.mSubPbModel.j0().d().getName(), this.f52598a.mSubPbModel.j0().l().f0(), valueOf, valueOf2, objArr.length > 3 ? String.valueOf(objArr[3]) : "", valueOf3, objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g0 implements b.a.q0.x.x.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52599a;

        public g0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52599a = newSubPbActivity;
        }

        @Override // b.a.q0.x.x.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f52599a.mSensitiveProcessController.d()) {
                    NewSubPbActivity newSubPbActivity = this.f52599a;
                    newSubPbActivity.showToast(newSubPbActivity.mSensitiveProcessController.c());
                    if (this.f52599a.mEditor.x()) {
                        this.f52599a.mEditor.v(this.f52599a.mPostWriteCallBackData);
                    }
                    this.f52599a.checkContentSensitiveWord(true);
                    return true;
                }
                NewSubPbActivity newSubPbActivity2 = this.f52599a;
                if (newSubPbActivity2.mReplyPrivacyController == null || newSubPbActivity2.mSubPbModel == null || this.f52599a.mSubPbModel.h0() == null || this.f52599a.isHost(TbadkCoreApplication.getCurrentAccount())) {
                    return false;
                }
                NewSubPbActivity newSubPbActivity3 = this.f52599a;
                return !newSubPbActivity3.mReplyPrivacyController.checkPrivacyBeforeSend(newSubPbActivity3.mSubPbModel.h0().replyPrivateFlag, ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class h implements r0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52600a;

        public h(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52600a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.r0
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (this.f52600a.mPostManageModel.P() || objArr == null || objArr.length < 4) {
                        return;
                    }
                    String valueOf = String.valueOf(objArr[0]);
                    int e2 = b.a.e.e.m.b.e(String.valueOf(objArr[1]), 0);
                    boolean b2 = b.a.e.e.m.b.b(String.valueOf(objArr[2]), false);
                    int e3 = b.a.e.e.m.b.e(String.valueOf(objArr[3]), 0);
                    if (this.f52600a.mSubPbModel == null || this.f52600a.mSubPbModel.j0() == null || this.f52600a.mSubPbModel.j0().d() == null || this.f52600a.mSubPbModel.j0().l() == null) {
                        return;
                    }
                    if (objArr.length > 4) {
                        this.f52600a.mPostManageModel.R(String.valueOf(objArr[4]));
                    }
                    this.f52600a.mPostManageModel.S(this.f52600a.mSubPbModel.j0().d().getId(), this.f52600a.mSubPbModel.j0().d().getName(), this.f52600a.mSubPbModel.j0().l().f0(), valueOf, e3, e2, b2, this.f52600a.mSubPbModel.j0().l().L(), false);
                    return;
                }
                TbadkCoreApplication.getInst().login(this.f52600a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f52600a.getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52601e;

        public h0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52601e = newSubPbActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52602a;

        public i(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52602a = newSubPbActivity;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null) {
                    int loadDataMode = this.f52602a.mPostManageModel.getLoadDataMode();
                    if (loadDataMode == 0) {
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.f52602a.finishDelPost(bVar, (bVar.f54251e != 1002 || bVar.f54252f) ? true : true);
                        return;
                    } else if (loadDataMode != 1) {
                        return;
                    } else {
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.f52602a.mSubPbView.z(1, dVar.f54255a, dVar.f54256b, true);
                        return;
                    }
                }
                this.f52602a.mSubPbView.z(this.f52602a.mPostManageModel.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52603a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i0(NewSubPbActivity newSubPbActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i2)};
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
            this.f52603a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData)) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (StringUtils.isNull(currentAccount)) {
                    return;
                }
                UserPendantData userPendantData = (UserPendantData) customResponsedMessage.getData();
                if (this.f52603a.mSubPbModel.j0() == null || this.f52603a.mSubPbModel.j0().i() == null || this.f52603a.mSubPbModel.j0().i().t() == null || !currentAccount.equals(this.f52603a.mSubPbModel.j0().i().t().getUserId()) || this.f52603a.mSubPbModel.j0().i().t().getPendantData() == null) {
                    return;
                }
                this.f52603a.mSubPbModel.j0().i().t().getPendantData().setImgUrl(userPendantData.getImgUrl());
                this.f52603a.mSubPbModel.j0().i().t().getPendantData().setPropsId(userPendantData.getPropsId());
                this.f52603a.mSubPbView.y(this.f52603a.mSubPbModel.j0(), this.f52603a.mSubPbModel.j0().i(), this.f52603a.mSubPbModel.j0().e(), this.f52603a.mSubPbModel.j0().f(), this.f52603a.mSubPbModel.B0(), this.f52603a.mSubPbModel.A0() != null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f52604e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f52605f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f52606g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52607h;

        public j(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52607h = newSubPbActivity;
            this.f52604e = sparseArray;
            this.f52605f = i2;
            this.f52606g = z;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                if (this.f52607h.deleteReplayCallback != null) {
                    this.f52607h.deleteReplayCallback.a(new Object[]{this.f52604e.get(b.a.r0.k2.i.tag_del_post_id), Integer.valueOf(this.f52605f), Boolean.valueOf(this.f52606g), this.f52604e.get(b.a.r0.k2.i.tag_del_post_type)});
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f52608e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f52609f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52610g;

        public j0(NewSubPbActivity newSubPbActivity, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52610g = newSubPbActivity;
            this.f52608e = i2;
            this.f52609f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52610g.mSubPbView == null || this.f52610g.mSubPbView.G() == null) {
                return;
            }
            this.f52610g.mSubPbView.G().setSelectionFromTop(this.f52608e, this.f52610g.mSubPbView.I() - this.f52609f);
        }
    }

    /* loaded from: classes9.dex */
    public class k implements b.a.q0.x.x.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52611a;

        public k(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52611a = newSubPbActivity;
        }

        @Override // b.a.q0.x.x.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52611a.mSubPbView.x0();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f52612e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f52613f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f52614g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52615h;

        public k0(NewSubPbActivity newSubPbActivity, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52615h = newSubPbActivity;
            this.f52612e = i2;
            this.f52613f = i3;
            this.f52614g = i4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f52615h.mSubPbView == null || this.f52615h.mSubPbView.G() == null) {
                return;
            }
            this.f52615h.mSubPbView.G().setSelectionFromTop(this.f52612e, this.f52615h.mSubPbView.I() + (this.f52613f - this.f52614g));
        }
    }

    /* loaded from: classes9.dex */
    public class l implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52616e;

        public l(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52616e = newSubPbActivity;
        }

        @Override // b.a.q0.s.s.a.e
        public void onClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52617a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l0(NewSubPbActivity newSubPbActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i2)};
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
            this.f52617a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.f52617a.mSubPbModel != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.f52617a.mSubPbModel.x0())) {
                if (this.f52617a.mSensitiveProcessController != null) {
                    this.f52617a.mSensitiveProcessController.n(null);
                    this.f52617a.mSensitiveProcessController.i(null);
                    this.f52617a.mSensitiveProcessController.k(false);
                }
                if (this.f52617a.mEditor != null) {
                    this.f52617a.mEditor.q();
                    this.f52617a.mEditor.H();
                }
                this.f52617a.mSubPbModel.H();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52618e;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.r0.k2.u.f.c1.c f52619e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ PostData f52620f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ m f52621g;

            public a(m mVar, b.a.r0.k2.u.f.c1.c cVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, cVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52621g = mVar;
                this.f52619e = cVar;
                this.f52620f = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.r0.k2.u.f.d dVar = new b.a.r0.k2.u.f.d(new b.a.q0.f1.n.a());
                    dVar.j(b.a.e.e.p.l.g(TbadkCoreApplication.getInst().getContext(), b.a.r0.k2.g.tbds18));
                    dVar.o(TbConfig.getPostLineSpace(), 1.0f);
                    this.f52619e.f19166b.a(null, this.f52621g.f52618e.mSubPbModel.j0().l(), this.f52620f, dVar);
                }
            }
        }

        public m(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52618e = newSubPbActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            PostData postData;
            String b2;
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == null && this.f52618e.mSubPbView == null) {
                    return;
                }
                boolean z = true;
                SparseArray<Object> sparseArray2 = null;
                if (view == this.f52618e.mSubPbView.F()) {
                    this.f52618e.mSubPbView.w();
                    String str2 = view.getTag(b.a.r0.k2.i.tag_user_id) instanceof String ? (String) view.getTag(b.a.r0.k2.i.tag_user_id) : null;
                    String str3 = view.getTag(b.a.r0.k2.i.tag_user_name) instanceof String ? (String) view.getTag(b.a.r0.k2.i.tag_user_name) : null;
                    String str4 = view.getTag(b.a.r0.k2.i.tag_virtual_user_url) instanceof String ? (String) view.getTag(b.a.r0.k2.i.tag_virtual_user_url) : null;
                    if (str4 != null) {
                        if (this.f52618e.checkUpIsLogin()) {
                            UrlManager.getInstance().dealOneLink(this.f52618e.getPageContext(), new String[]{str4});
                        }
                    } else if (str2 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f52618e.getPageContext().getPageActivity(), str2, str3, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                    }
                } else if (view != this.f52618e.mSubPbView.N()) {
                    if (view != this.f52618e.mSubPbView.K()) {
                        if (view == this.f52618e.mSubPbView.L()) {
                            if (this.f52618e.checkUpIsLogin()) {
                                this.f52618e.mSubPbView.K0();
                                this.f52618e.mSubPbView.u();
                                if (this.f52618e.mEditor != null) {
                                    this.f52618e.mEditor.g0();
                                }
                            }
                        } else if (view.getId() != b.a.r0.k2.i.pb_floor_feedback) {
                            if (view == this.f52618e.mSubPbView.H()) {
                                this.f52618e.mSubPbView.w();
                                if (this.f52618e.mSubPbModel.loadData()) {
                                    this.f52618e.mSubPbView.G0();
                                    return;
                                }
                                return;
                            }
                            str = "";
                            if (view == this.f52618e.mSubPbView.D() || view == this.f52618e.mSubPbView.C() || view == this.f52618e.mSubPbView.O()) {
                                if (this.f52618e.mIsRichTextListenerAcked) {
                                    this.f52618e.mIsRichTextListenerAcked = false;
                                    return;
                                }
                                if (this.f52618e.mSubPbModel.j0() != null && this.f52618e.mSubPbModel.j0().l() != null) {
                                    r4 = ThreadCardUtils.isUgcThreadType(this.f52618e.mSubPbModel.j0().l().L());
                                }
                                if (r4) {
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(this.f52618e.getActivity()).createNormalCfg(this.f52618e.mSubPbModel.x0(), null, "");
                                    if (!StringUtils.isNull(this.f52618e.mSubPbModel.getFromForumId())) {
                                        createNormalCfg.setForumId(this.f52618e.mSubPbModel.getFromForumId());
                                    }
                                    if (this.f52618e.mSubPbModel.j0() != null && this.f52618e.mSubPbModel.j0().l() != null) {
                                        createNormalCfg.setBjhData(this.f52618e.mSubPbModel.j0().l().L());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                    return;
                                }
                                PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f52618e.getActivity()).createNormalCfg(this.f52618e.mSubPbModel.x0(), this.f52618e.mSubPbModel.y(), "");
                                if (!StringUtils.isNull(this.f52618e.mSubPbModel.getFromForumId())) {
                                    createNormalCfg2.setForumId(this.f52618e.mSubPbModel.getFromForumId());
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            } else if (this.f52618e.mSubPbView.J() == null || view != this.f52618e.mSubPbView.J().getMarkTextView()) {
                                if (this.f52618e.mSubPbView.J() == null || view != this.f52618e.mSubPbView.J().getDeleteTextView()) {
                                    if (this.f52618e.mSubPbView.J() == null || view != this.f52618e.mSubPbView.J().getManageTextView()) {
                                        if (this.f52618e.mSubPbView.J() == null || view != this.f52618e.mSubPbView.J().getReportTextView()) {
                                            if (this.f52618e.mSubPbView.J() == null || view != this.f52618e.mSubPbView.J().getCopyTextView()) {
                                                if (view != this.f52618e.mSubPbView.E() && view != this.f52618e.mSubPbView.O()) {
                                                    if (view != null && (view.getTag() instanceof PbCommenFloorItemViewHolder)) {
                                                        this.f52618e.mItemClickShowSoftKeyBoardViewHolder = (PbCommenFloorItemViewHolder) view.getTag();
                                                        if (ViewHelper.checkUpIsLogin(this.f52618e.getPageContext().getPageActivity())) {
                                                            if (this.f52618e.mIsRichTextListenerAcked) {
                                                                this.f52618e.mIsRichTextListenerAcked = false;
                                                                return;
                                                            }
                                                            NewSubPbActivity newSubPbActivity = this.f52618e;
                                                            if (newSubPbActivity.mReplyPrivacyController != null && newSubPbActivity.mSubPbModel != null && this.f52618e.mSubPbModel.h0() != null && !this.f52618e.isHost(TbadkCoreApplication.getCurrentAccount())) {
                                                                NewSubPbActivity newSubPbActivity2 = this.f52618e;
                                                                if (!newSubPbActivity2.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.mSubPbModel.h0().replyPrivateFlag)) {
                                                                    return;
                                                                }
                                                            }
                                                            SparseArray sparseArray3 = (SparseArray) view.getTag(b.a.r0.k2.i.tag_from);
                                                            if (sparseArray3 == null) {
                                                                return;
                                                            }
                                                            this.f52618e.openEditor(sparseArray3, ((view.getTag(b.a.r0.k2.i.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(b.a.r0.k2.i.tag_subpb_ban_display_keyboard) == Boolean.TRUE) ? false : false);
                                                            if (sparseArray3.get(b.a.r0.k2.i.tag_clip_board) instanceof PostData) {
                                                                PostData postData2 = (PostData) sparseArray3.get(b.a.r0.k2.i.tag_clip_board);
                                                                b.a.r0.k2.u.h.e.a(this.f52618e.mSubPbModel != null ? this.f52618e.mSubPbModel.x0() : "", postData2.t() == null ? "" : postData2.t().getUserId(), postData2.G());
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } else if (view.getId() != b.a.r0.k2.i.post_info_commont_img && view.getId() != b.a.r0.k2.i.pb_floor_comment_container && (this.f52618e.mPostMoreOptionView == null || view != this.f52618e.mPostMoreOptionView.getReplyTextView())) {
                                                        if (this.f52618e.mPostMoreOptionView == null || view != this.f52618e.mPostMoreOptionView.getReportTextView()) {
                                                            if (this.f52618e.mPostMoreOptionView == null || view != this.f52618e.mPostMoreOptionView.getMarkTextView()) {
                                                                if (this.f52618e.mPostMoreOptionView == null || view != this.f52618e.mPostMoreOptionView.getDeleteTextView()) {
                                                                    if (this.f52618e.mPostMoreOptionView == null || view != this.f52618e.mPostMoreOptionView.getCopyTextView()) {
                                                                        if (this.f52618e.mPostMoreOptionView == null || view != this.f52618e.mPostMoreOptionView.getEmotionTextView()) {
                                                                            if (this.f52618e.mPostMoreOptionView == null || view != this.f52618e.mPostMoreOptionView.getSaveLocalTextView()) {
                                                                                if (this.f52618e.mPostMoreOptionView == null || view != this.f52618e.mPostMoreOptionView.getDisagreeTextView()) {
                                                                                    if (this.f52618e.mPostMoreOptionView == null || view != this.f52618e.mPostMoreOptionView.getManageTextView()) {
                                                                                        if (this.f52618e.mPostMoreOptionView == null || view != this.f52618e.mPostMoreOptionView.getBlockTextView()) {
                                                                                            if (this.f52618e.mPostMoreOptionView != null && view == this.f52618e.mPostMoreOptionView.getShareTextView()) {
                                                                                                if (view.getTag() instanceof SparseArray) {
                                                                                                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                                    if (sparseArray4.get(b.a.r0.k2.i.tag_load_sub_data) instanceof PostData) {
                                                                                                        PostData postData3 = (PostData) sparseArray4.get(b.a.r0.k2.i.tag_load_sub_data);
                                                                                                        b.a.r0.k2.u.f.c1.c cVar = new b.a.r0.k2.u.f.c1.c(this.f52618e.getPageContext());
                                                                                                        if (postData3 != null) {
                                                                                                            b.a.e.e.m.e.a().postDelayed(new a(this, cVar, postData3), 100L);
                                                                                                            String f0 = this.f52618e.mSubPbModel.j0().l().f0();
                                                                                                            if (StringUtils.isNull(f0) || "0".equals(f0)) {
                                                                                                                f0 = this.f52618e.mSubPbModel.j0().l().F0();
                                                                                                            }
                                                                                                            TiebaStatic.log(new StatisticItem("c13700").param("tid", f0).param("fid", this.f52618e.mSubPbModel.j0().l().T()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData3.G()).param("obj_source", 1).param("obj_type", 4));
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                }
                                                                                                return;
                                                                                            }
                                                                                            int id = view.getId();
                                                                                            if (id == b.a.r0.k2.i.pb_item_tail_content) {
                                                                                                if (ViewHelper.checkUpIsLogin(this.f52618e.getPageContext().getPageActivity())) {
                                                                                                    String string = TbadkCoreApplication.getInst().getString(b.a.r0.k2.l.tail_web_view_title);
                                                                                                    String p = b.a.q0.s.e0.b.j().p("tail_link", "");
                                                                                                    if (StringUtils.isNull(p)) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.log("c10056");
                                                                                                    b.a.q0.m.a.p(view.getContext(), string, p, true, true, true);
                                                                                                    return;
                                                                                                }
                                                                                                return;
                                                                                            } else if (id == b.a.r0.k2.i.richText && (view.getTag() instanceof SparseArray)) {
                                                                                                Object obj = ((SparseArray) view.getTag()).get(b.a.r0.k2.i.tag_clip_board);
                                                                                                if (obj instanceof PostData) {
                                                                                                    PostData postData4 = (PostData) obj;
                                                                                                    if (postData4.getType() == PostData.A0 || TextUtils.isEmpty(postData4.u()) || !b.a.q0.s.k.c().g()) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.f52618e.navigateToBubbleWebView(postData4.G());
                                                                                                    return;
                                                                                                }
                                                                                                return;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else if (!b.a.e.e.p.j.z()) {
                                                                                            this.f52618e.showToast(b.a.r0.k2.l.network_not_available);
                                                                                            return;
                                                                                        } else if (!ViewHelper.checkUpIsLogin(this.f52618e.getActivity()) || (b2 = b.a.r0.v3.a.b(view)) == null || this.f52618e.mUserBlockController == null) {
                                                                                            return;
                                                                                        } else {
                                                                                            this.f52618e.mUserBlockController.n(b.a.e.e.m.b.g(b2, 0L));
                                                                                            return;
                                                                                        }
                                                                                    } else if (!b.a.e.e.p.j.z()) {
                                                                                        this.f52618e.showToast(b.a.r0.k2.l.network_not_available);
                                                                                        return;
                                                                                    } else {
                                                                                        SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                                                                                        if (sparseArray5 == null) {
                                                                                            return;
                                                                                        }
                                                                                        boolean booleanValue = ((Boolean) sparseArray5.get(b.a.r0.k2.i.tag_should_manage_visible)).booleanValue();
                                                                                        boolean booleanValue2 = ((Boolean) sparseArray5.get(b.a.r0.k2.i.tag_should_delete_visible)).booleanValue();
                                                                                        boolean booleanValue3 = ((Boolean) sparseArray5.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue();
                                                                                        r4 = sparseArray5.get(b.a.r0.k2.i.tag_is_self_post) instanceof Boolean ? ((Boolean) sparseArray5.get(b.a.r0.k2.i.tag_is_self_post)).booleanValue() : false;
                                                                                        if (!booleanValue) {
                                                                                            if (booleanValue2) {
                                                                                                this.f52618e.mSubPbView.g0(((Integer) sparseArray5.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray5.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) sparseArray5.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray5.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue(), false);
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        } else if (!booleanValue3) {
                                                                                            if (r4) {
                                                                                                sparseArray5.put(b.a.r0.k2.i.tag_check_mute_from, 2);
                                                                                            }
                                                                                            this.f52618e.mSubPbView.i0(view);
                                                                                            return;
                                                                                        } else {
                                                                                            sparseArray5.put(b.a.r0.k2.i.tag_from, 1);
                                                                                            sparseArray5.put(b.a.r0.k2.i.tag_check_mute_from, 2);
                                                                                            this.f52618e.checkMuteState(sparseArray5);
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                } else if (this.f52618e.checkUpIsLogin() && (sparseArray = (SparseArray) view.getTag()) != null) {
                                                                                    PostData postData5 = (PostData) sparseArray.get(b.a.r0.k2.i.tag_clip_board);
                                                                                    if (postData5.q() == null) {
                                                                                        return;
                                                                                    }
                                                                                    this.f52618e.clickOnDisagree(postData5.q());
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (this.f52618e.mSaveBdImage == null || TextUtils.isEmpty(this.f52618e.mSaveImageUrl)) {
                                                                                return;
                                                                            } else {
                                                                                if (this.f52618e.mPermissionJudgement == null) {
                                                                                    this.f52618e.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                this.f52618e.mPermissionJudgement.clearRequestPermissionList();
                                                                                this.f52618e.mPermissionJudgement.appendRequestPermission(this.f52618e.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (this.f52618e.mPermissionJudgement.startRequestPermission(this.f52618e.getPageContext().getPageActivity())) {
                                                                                    return;
                                                                                }
                                                                                if (this.f52618e.mSaveImageHelper == null) {
                                                                                    NewSubPbActivity newSubPbActivity3 = this.f52618e;
                                                                                    newSubPbActivity3.mSaveImageHelper = new w0(newSubPbActivity3.getPageContext());
                                                                                }
                                                                                this.f52618e.mSaveImageHelper.b(this.f52618e.mSaveImageUrl, this.f52618e.mSaveBdImage.n());
                                                                                this.f52618e.mSaveBdImage = null;
                                                                                this.f52618e.mSaveImageUrl = null;
                                                                                return;
                                                                            }
                                                                        } else if (this.f52618e.mSaveBdImage == null || TextUtils.isEmpty(this.f52618e.mSaveImageUrl)) {
                                                                            return;
                                                                        } else {
                                                                            if (this.f52618e.mEmotionInfo == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f52618e.mSaveImageUrl));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.f11986a = this.f52618e.mSaveImageUrl;
                                                                                if (this.f52618e.mEmotionInfo.memeInfo.pck_id.intValue() >= 0) {
                                                                                    str = "" + this.f52618e.mEmotionInfo.memeInfo.pck_id;
                                                                                }
                                                                                aVar.f11987b = str;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            this.f52618e.mSaveBdImage = null;
                                                                            this.f52618e.mSaveImageUrl = null;
                                                                            return;
                                                                        }
                                                                    }
                                                                    NewSubPbActivity newSubPbActivity4 = this.f52618e;
                                                                    PostData postData6 = newSubPbActivity4.postData;
                                                                    if (postData6 != null) {
                                                                        postData6.l0(newSubPbActivity4.getPageContext().getPageActivity());
                                                                        this.f52618e.postData = null;
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                                if (sparseArray6 != null && (sparseArray6.get(b.a.r0.k2.i.tag_del_post_type) instanceof Integer) && (sparseArray6.get(b.a.r0.k2.i.tag_del_post_id) instanceof String) && (sparseArray6.get(b.a.r0.k2.i.tag_manage_user_identity) instanceof Integer) && (sparseArray6.get(b.a.r0.k2.i.tag_del_post_is_self) instanceof Boolean)) {
                                                                    boolean booleanValue4 = ((Boolean) sparseArray6.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue();
                                                                    int intValue = ((Integer) sparseArray6.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue();
                                                                    boolean booleanValue5 = ((Boolean) sparseArray6.get(b.a.r0.k2.i.tag_has_sub_post)).booleanValue();
                                                                    boolean isHost = this.f52618e.isHost(TbadkCoreApplication.getCurrentAccount());
                                                                    if (isHost) {
                                                                        if (!booleanValue5) {
                                                                            this.f52618e.showDelNoSubPostDialog(sparseArray6, intValue, booleanValue4);
                                                                            return;
                                                                        } else {
                                                                            this.f52618e.mSubPbView.g0(((Integer) sparseArray6.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray6.get(b.a.r0.k2.i.tag_del_post_id), intValue, booleanValue4, isHost);
                                                                            return;
                                                                        }
                                                                    } else if (booleanValue4 && !booleanValue5) {
                                                                        this.f52618e.showDelNoSubPostDialog(sparseArray6, intValue, booleanValue4);
                                                                        return;
                                                                    } else {
                                                                        this.f52618e.mSubPbView.g0(((Integer) sparseArray6.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray6.get(b.a.r0.k2.i.tag_del_post_id), intValue, booleanValue4, isHost);
                                                                        return;
                                                                    }
                                                                }
                                                                return;
                                                            } else if (this.f52618e.checkUpIsLogin()) {
                                                                this.f52618e.markFloor(view);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (!b.a.e.e.p.j.z()) {
                                                            this.f52618e.showToast(b.a.r0.k2.l.network_not_available);
                                                            return;
                                                        } else {
                                                            Object tag = view.getTag();
                                                            if (tag instanceof String) {
                                                                this.f52618e.handleReportClicked((String) tag);
                                                                return;
                                                            } else if (tag instanceof SparseArray) {
                                                                SparseArray<Object> sparseArray7 = (SparseArray) tag;
                                                                if ((sparseArray7.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray7.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue()) {
                                                                    sparseArray7.put(b.a.r0.k2.i.tag_from, 0);
                                                                    sparseArray7.put(b.a.r0.k2.i.tag_check_mute_from, 2);
                                                                    this.f52618e.checkMuteState(sparseArray7);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else if (this.f52618e.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                        SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                        if ((sparseArray8.get(b.a.r0.k2.i.tag_load_sub_data) instanceof PostData) && (postData = (PostData) sparseArray8.get(b.a.r0.k2.i.tag_load_sub_data)) != null) {
                                                            if (this.f52618e.mSubPbModel != null) {
                                                                TiebaStatic.log(new StatisticItem("c13700").param("tid", this.f52618e.mSubPbModel.y0()).param("fid", this.f52618e.mSubPbModel.getFromForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.G()).param("obj_source", 1).param("obj_type", 3));
                                                            }
                                                            this.f52618e.openEditor(postData, ((view.getTag(b.a.r0.k2.i.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(b.a.r0.k2.i.tag_subpb_ban_display_keyboard) == Boolean.TRUE) ? false : false);
                                                            return;
                                                        }
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (this.f52618e.checkUpIsLogin()) {
                                                    if (this.f52618e.mEditor.A()) {
                                                        this.f52618e.mEditor.y();
                                                        return;
                                                    } else {
                                                        this.f52618e.mEditor.j0(null, null);
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getTag() == null || !(view.getTag() instanceof SparseArray)) {
                                                return;
                                            } else {
                                                SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                if (sparseArray9.get(b.a.r0.k2.i.tag_clip_board) instanceof PostData) {
                                                    ((PostData) sparseArray9.get(b.a.r0.k2.i.tag_clip_board)).l0(this.f52618e.getPageContext().getPageActivity());
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                        if (!b.a.e.e.p.j.z()) {
                                            this.f52618e.showToast(b.a.r0.k2.l.network_not_available);
                                            return;
                                        }
                                        Object tag2 = view.getTag();
                                        this.f52618e.mSubPbView.w();
                                        if (tag2 instanceof String) {
                                            String str5 = (String) tag2;
                                            if (this.f52618e.checkUpIsLogin()) {
                                                this.f52618e.handleReportClicked(str5);
                                                return;
                                            }
                                            return;
                                        } else if (tag2 instanceof SparseArray) {
                                            SparseArray<Object> sparseArray10 = (SparseArray) tag2;
                                            if ((sparseArray10.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray10.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue()) {
                                                sparseArray10.put(b.a.r0.k2.i.tag_from, 0);
                                                sparseArray10.put(b.a.r0.k2.i.tag_check_mute_from, 2);
                                                this.f52618e.checkMuteState(sparseArray10);
                                                return;
                                            }
                                            return;
                                        } else {
                                            return;
                                        }
                                    } else if (b.a.e.e.p.j.z()) {
                                        this.f52618e.mSubPbView.w();
                                        if (this.f52618e.checkUpIsLogin()) {
                                            this.f52618e.doManager(view);
                                            return;
                                        }
                                        return;
                                    } else {
                                        this.f52618e.showToast(b.a.r0.k2.l.network_not_available);
                                        return;
                                    }
                                }
                                this.f52618e.mSubPbView.w();
                                SparseArray sparseArray11 = (SparseArray) view.getTag();
                                if (sparseArray11 == null) {
                                    return;
                                }
                                this.f52618e.mSubPbView.g0(((Integer) sparseArray11.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray11.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) sparseArray11.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray11.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue(), false);
                            } else {
                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                this.f52618e.mSubPbView.w();
                                if (this.f52618e.checkUpIsLogin() && this.f52618e.mSubPbModel.j0() != null) {
                                    NewSubPbActivity newSubPbActivity5 = this.f52618e;
                                    newSubPbActivity5.markFloor(newSubPbActivity5.mSubPbModel.j0().i());
                                }
                            }
                        } else {
                            try {
                                sparseArray2 = (SparseArray) view.getTag();
                            } catch (ClassCastException e2) {
                                e2.printStackTrace();
                            }
                            if (sparseArray2 == null || ((PostData) sparseArray2.get(b.a.r0.k2.i.tag_clip_board)) == null) {
                                return;
                            }
                            if (this.f52618e.mPostMoreOptionView == null) {
                                this.f52618e.mPostMoreOptionView = new PbMoreDialog(this.f52618e.getPageContext(), this.f52618e.mCommonClickListener);
                                this.f52618e.mSubPbView.w0(this.f52618e.mPostMoreOptionView.getView());
                                this.f52618e.mPostMoreOptionView.changeLoginStyle(this.f52618e.mIsLogin);
                            }
                            this.f52618e.mPostMoreOptionView.showDialog();
                            this.f52618e.mPostMoreOptionView.confirmFeedback(sparseArray2, this.f52618e.getUserIdentity(), (this.f52618e.isShowReportButton(sparseArray2.get(b.a.r0.k2.i.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue() : false) && this.f52618e.isLogin()) ? false : false, this.f52618e.mSubPbModel.j0());
                        }
                    } else if (this.f52618e.checkUpIsLogin()) {
                        this.f52618e.mSubPbView.K0();
                        this.f52618e.mSubPbView.u();
                        if (this.f52618e.mEditor != null) {
                            this.f52618e.mEditor.e0();
                        }
                    }
                } else if (this.f52618e.checkUpIsLogin()) {
                    this.f52618e.processProfessionPermission();
                    if (this.f52618e.mSubPbModel == null || this.f52618e.mSubPbModel.j0() == null || this.f52618e.mSubPbModel.j0().l() == null || this.f52618e.mSubPbModel.j0().l().J() == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.f52618e.mSubPbModel.x0()).param("fid", this.f52618e.mSubPbModel.j0().l().T()).param("obj_locate", 5).param("uid", this.f52618e.mSubPbModel.j0().l().J().getUserId()));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m0 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52622a;

        /* loaded from: classes9.dex */
        public class a implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(m0 m0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes9.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ m0 f52623e;

            public b(m0 m0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f52623e = m0Var;
            }

            @Override // b.a.q0.s.s.a.e
            public void onClick(b.a.q0.s.s.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.f52623e.f52622a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.f52623e.f52622a.getActivity(), 0, 26, 2)));
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW_OPEN_CLICK).param("obj_locate", 1).param("obj_type", 2));
                }
            }
        }

        public m0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52622a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, b.a.q0.t.c.m0 m0Var, WriteData writeData, AntiData antiData) {
            ReplyPrivacyCheckController replyPrivacyCheckController;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, m0Var, writeData, antiData}) == null) {
                if (z && this.f52622a.mEditor != null && this.f52622a.mEditor.a() != null) {
                    this.f52622a.mEditor.a().hide();
                    if (this.f52622a.mSubPbModel.H0()) {
                        TiebaStatic.log(new StatisticItem("c10367").param("post_id", this.f52622a.mSubPbModel.y()));
                    }
                }
                if (z) {
                    this.f52622a.mSensitiveProcessController.n(null);
                    this.f52622a.mSensitiveProcessController.i(null);
                    this.f52622a.mSensitiveProcessController.k(false);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        b.a.q0.t.h.b.a(this.f52622a.getPageContext(), postWriteCallBackData);
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    this.f52622a.mSensitiveProcessController.i(postWriteCallBackData.getSensitiveWords());
                    this.f52622a.mSensitiveProcessController.n(postWriteCallBackData.getErrorString());
                    if (ListUtils.isEmpty(this.f52622a.mSensitiveProcessController.a())) {
                        return;
                    }
                    this.f52622a.mPostWriteCallBackData = postWriteCallBackData;
                    if (this.f52622a.mEditor.x()) {
                        this.f52622a.mEditor.v(this.f52622a.mPostWriteCallBackData);
                    }
                    this.f52622a.checkContentSensitiveWord(true);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (b.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.makeText(this.f52622a.getActivity(), this.f52622a.getActivity().getString(b.a.r0.k2.l.current_links_too_much_please_modify_and_publish), null).show();
                    } else {
                        DefaultNavigationBarCoverTip.makeText(this.f52622a.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.f52622a.getActivity());
                    if (b.a.e.e.p.k.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.f52622a.getActivity().getString(b.a.r0.k2.l.open_member_and_add_more_links));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(b.a.r0.k2.l.cancel, new a(this));
                    aVar.setPositiveButton(b.a.r0.k2.l.open_now, new b(this));
                    aVar.create(this.f52622a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && (replyPrivacyCheckController = this.f52622a.mReplyPrivacyController) != null) {
                    replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                }
                this.f52622a.mSubPbView.l0();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52624e;

        public n(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52624e = newSubPbActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i2, i3, i4) == null) {
                this.f52624e.mSubPbView.f0();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i2) == null) {
                if (i2 == 2 || i2 == 1) {
                    this.f52624e.mSubPbView.w();
                    if (this.f52624e.lastScrollState != 2 && this.f52624e.lastScrollState != 1) {
                        this.f52624e.mSubPbView.T();
                    }
                }
                this.f52624e.mEditor.y();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52625a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n0(NewSubPbActivity newSubPbActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i2)};
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
            this.f52625a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.f52625a.MESSAGE_ID_NEWSUB_PB) {
                this.f52625a.mSubPbView.R();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.f52625a.mToastMute.c(this.f52625a.mCtx.getResources().getString(b.a.r0.k2.l.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.f52625a.mCtx.getResources().getString(b.a.r0.k2.l.mute_error_beyond_limit);
                    }
                    this.f52625a.showUserMuteAddDialog(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.f52625a.showOpenMemberReplyDialog();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (b.a.e.e.p.k.isEmpty(errorString2)) {
                        errorString2 = this.f52625a.mCtx.getResources().getString(b.a.r0.k2.l.mute_fail);
                    }
                    this.f52625a.mToastMute.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52626e;

        public o(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52626e = newSubPbActivity;
        }

        /* JADX WARN: Removed duplicated region for block: B:74:0x0190 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0191  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            SparseArray<Object> sparseArray;
            SparseArray<Object> sparseArray2;
            SparseArray<Object> sparseArray3;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, view)) != null) {
                return invokeL.booleanValue;
            }
            if (this.f52626e.mSubPbView != null && this.f52626e.mSubPbView.Y()) {
                return false;
            }
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null && this.f52626e.isImage(view)) {
                if (view instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) view;
                    this.f52626e.mSaveBdImage = tbImageView.getBdImage();
                    this.f52626e.mSaveImageUrl = tbImageView.getUrl();
                    if (this.f52626e.mSaveBdImage == null || TextUtils.isEmpty(this.f52626e.mSaveImageUrl)) {
                        return true;
                    }
                    if (view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) == null || !(view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.f52626e.mEmotionInfo = null;
                    } else {
                        this.f52626e.mEmotionInfo = (TbRichTextMemeInfo) view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info);
                    }
                } else if (view instanceof GifView) {
                    GifView gifView = (GifView) view;
                    if (gifView.getBdImage() == null) {
                        return true;
                    }
                    this.f52626e.mSaveBdImage = gifView.getBdImage();
                    if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                        this.f52626e.mSaveImageUrl = gifView.getBdImage().q();
                    }
                    if (view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) == null || !(view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.f52626e.mEmotionInfo = null;
                    } else {
                        this.f52626e.mEmotionInfo = (TbRichTextMemeInfo) view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info);
                    }
                } else if (view instanceof TbMemeImageView) {
                    TbMemeImageView tbMemeImageView = (TbMemeImageView) view;
                    if (tbMemeImageView.getBdImage() != null) {
                        this.f52626e.mSaveBdImage = tbMemeImageView.getBdImage();
                        if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                            this.f52626e.mSaveImageUrl = tbMemeImageView.getBdImage().q();
                        }
                        if (view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) == null || !(view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.f52626e.mEmotionInfo = null;
                        } else {
                            this.f52626e.mEmotionInfo = (TbRichTextMemeInfo) view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info);
                        }
                    }
                }
                if (view.getParent() instanceof TbRichTextView) {
                    try {
                        sparseArray3 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                    } catch (ClassCastException e3) {
                        e3.printStackTrace();
                    }
                } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                    this.f52626e.mSubPbView.E0(this.f52626e.mOnImageSaveClickListener, this.f52626e.mSaveBdImage.t());
                } else {
                    try {
                        sparseArray3 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                    } catch (ClassCastException e4) {
                        e4.printStackTrace();
                    }
                }
                sparseArray2 = sparseArray3;
                if (sparseArray2 != null) {
                    return true;
                }
                this.f52626e.postData = (PostData) sparseArray2.get(b.a.r0.k2.i.tag_clip_board);
                NewSubPbActivity newSubPbActivity = this.f52626e;
                if (newSubPbActivity.postData == null || newSubPbActivity.mMarkModel == null) {
                    return true;
                }
                if (this.f52626e.mMarkModel != null) {
                    this.f52626e.mMarkModel.h(this.f52626e.mSubPbModel.L0());
                }
                boolean z = this.f52626e.mMarkModel.e() && this.f52626e.postData.G() != null && this.f52626e.postData.G().equals(this.f52626e.mSubPbModel.s0());
                if (this.f52626e.mPostMoreOptionView == null) {
                    this.f52626e.mPostMoreOptionView = new PbMoreDialog(this.f52626e.getPageContext(), this.f52626e.mCommonClickListener);
                    this.f52626e.mSubPbView.w0(this.f52626e.mPostMoreOptionView.getView());
                    this.f52626e.mPostMoreOptionView.changeLoginStyle(this.f52626e.mIsLogin);
                }
                this.f52626e.mPostMoreOptionView.showDialog();
                boolean z2 = this.f52626e.isShowReportButton(sparseArray2.get(b.a.r0.k2.i.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray2.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue() : false) && this.f52626e.isLogin();
                boolean z3 = (this.f52626e.mSubPbModel.j0() == null || this.f52626e.mSubPbModel.j0().l() == null || !this.f52626e.mSubPbModel.j0().l().Q1()) ? false : true;
                boolean booleanValue = sparseArray2.get(b.a.r0.k2.i.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray2.get(b.a.r0.k2.i.tag_is_subpb)).booleanValue() : false;
                if (z) {
                    this.f52626e.mPostMoreOptionView.getMarkTextView().setText(b.a.r0.k2.l.remove_mark);
                } else {
                    this.f52626e.mPostMoreOptionView.getMarkTextView().setText(b.a.r0.k2.l.mark);
                }
                if (booleanValue || z3) {
                    this.f52626e.mPostMoreOptionView.getMarkTextView().setVisibility(8);
                } else {
                    this.f52626e.mPostMoreOptionView.getMarkTextView().setVisibility(0);
                }
                if (this.f52626e.isImage(view)) {
                    if (this.f52626e.mSaveBdImage != null && !this.f52626e.mSaveBdImage.t()) {
                        sparseArray2.put(b.a.r0.k2.i.tag_richtext_image, Boolean.TRUE);
                    } else {
                        sparseArray2.put(b.a.r0.k2.i.tag_richtext_image, Boolean.FALSE);
                    }
                    sparseArray2.put(b.a.r0.k2.i.tag_richtext_emotion, Boolean.TRUE);
                } else {
                    sparseArray2.put(b.a.r0.k2.i.tag_richtext_image, Boolean.FALSE);
                    sparseArray2.put(b.a.r0.k2.i.tag_richtext_emotion, Boolean.FALSE);
                }
                b.a.r0.k2.r.s j0 = this.f52626e.mSubPbModel.j0();
                this.f52626e.mPostMoreOptionView.setTitleContent(b.a.r0.k2.u.f.f1.a.f(this.f52626e.postData));
                this.f52626e.mPostMoreOptionView.confirmItems(sparseArray2, this.f52626e.getUserIdentity(), z2, this.f52626e.showTrisectionAndFeedback && this.f52626e.postData.o0, j0);
                return true;
            }
            sparseArray2 = sparseArray;
            if (sparseArray2 != null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52627a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(NewSubPbActivity newSubPbActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i2)};
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
            this.f52627a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.f52627a.MESSAGE_ID_NEWSUB_PB) {
                this.f52627a.mSubPbView.R();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.f52627a.mToastMute.c(this.f52627a.mCtx.getResources().getString(b.a.r0.k2.l.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (b.a.e.e.p.k.isEmpty(muteMessage)) {
                    muteMessage = this.f52627a.mCtx.getResources().getString(b.a.r0.k2.l.un_mute_fail);
                }
                this.f52627a.mToastMute.b(muteMessage);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52628a;

        public p(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52628a = newSubPbActivity;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v7, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX DEBUG: Multi-variable search result rejected for r6v8, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            String str2;
            String str3;
            boolean z3;
            String str4;
            String str5;
            boolean z4;
            String str6;
            String str7;
            String str8;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if (view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) == null || !(view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        b.a.r0.k2.r.s j0 = this.f52628a.mSubPbModel.j0();
                        TbRichText validImage = this.f52628a.validImage(str, i2);
                        TbRichTextData tbRichTextData = (validImage == null || validImage.y() == null) ? null : validImage.y().get(this.f52628a.imgIndex);
                        if (tbRichTextData == null) {
                            return;
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!tbRichTextData.C().D()) {
                            String encodeImageUrl = this.f52628a.encodeImageUrl(tbRichTextData);
                            arrayList.add(encodeImageUrl);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = this.f52628a.mIsFromCDN ? 17 : 18;
                            concurrentHashMap.put(encodeImageUrl, imageUrlData);
                            if (j0 != null) {
                                if (j0.d() != null) {
                                    str6 = j0.d().getName();
                                    str7 = j0.d().getId();
                                } else {
                                    str6 = null;
                                    str7 = null;
                                }
                                str8 = j0.l() != null ? j0.l().f0() : null;
                                z4 = true;
                            } else {
                                z4 = false;
                                str6 = null;
                                str7 = null;
                                str8 = null;
                            }
                            if (this.f52628a.mSubPbModel.A0() != null) {
                                concurrentHashMap = this.f52628a.mSubPbModel.A0();
                                z4 = this.f52628a.mSubPbModel.E0();
                                arrayList = this.f52628a.mSubPbModel.z0();
                            }
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(ListUtils.getItem(arrayList, 0));
                            ImageViewerConfig.b bVar = new ImageViewerConfig.b();
                            bVar.x(arrayList2);
                            bVar.z(str6);
                            bVar.y(str7);
                            bVar.O(str8);
                            bVar.C(z4);
                            bVar.J(arrayList.get(0));
                            bVar.F(true);
                            bVar.w(concurrentHashMap);
                            bVar.H(true);
                            bVar.K(false);
                            bVar.G(false);
                            bVar.N(this.f52628a.getThreadData());
                            bVar.L(String.valueOf(validImage.getPostId()));
                            bVar.A(this.f52628a.mSubPbModel.getFromForumId());
                            this.f52628a.sendMessage(new CustomMessage(2010000, bVar.v(this.f52628a.getPageContext().getPageActivity())));
                            return;
                        }
                        this.f52628a.index_valid = false;
                        TbRichText M = j0.i().M();
                        int size = arrayList.size();
                        int imageIndex = this.f52628a.getImageIndex(M, validImage, i2, i2, arrayList, concurrentHashMap);
                        int size2 = arrayList.size();
                        String str9 = size != size2 ? arrayList.get(size2 - 1) : "";
                        if (j0 != null) {
                            if (j0.d() != null) {
                                str5 = j0.d().getName();
                                str3 = j0.d().getId();
                            } else {
                                str5 = null;
                                str3 = null;
                            }
                            str2 = j0.l() != null ? j0.l().f0() : null;
                            z3 = true;
                            str4 = str5;
                        } else {
                            str2 = null;
                            str3 = null;
                            z3 = false;
                            str4 = null;
                        }
                        if (this.f52628a.mSubPbModel.A0() != null) {
                            concurrentHashMap = this.f52628a.mSubPbModel.A0();
                            z3 = this.f52628a.mSubPbModel.E0();
                            arrayList = this.f52628a.mSubPbModel.z0();
                            imageIndex += this.f52628a.mSubPbModel.t0();
                        }
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(ListUtils.getItem(arrayList, imageIndex));
                        ImageViewerConfig.b bVar2 = new ImageViewerConfig.b();
                        bVar2.x(arrayList3);
                        bVar2.z(str4);
                        bVar2.y(str3);
                        bVar2.O(str2);
                        bVar2.C(z3);
                        bVar2.J(str9);
                        bVar2.F(true);
                        bVar2.w(concurrentHashMap);
                        bVar2.H(true);
                        bVar2.K(false);
                        bVar2.G(false);
                        bVar2.N(this.f52628a.getThreadData());
                        bVar2.L(String.valueOf(validImage.getPostId()));
                        bVar2.A(this.f52628a.mSubPbModel.getFromForumId());
                        this.f52628a.sendMessage(new CustomMessage(2010000, bVar2.v(this.f52628a.getPageContext().getPageActivity())));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(b.a.r0.k2.i.tag_rich_text_meme_info);
                    boolean isGif = ((TbImageView) view).isGif();
                    if (tbRichTextMemeInfo == null || tbRichTextMemeInfo.memeInfo == null) {
                        return;
                    }
                    this.f52628a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.f52628a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, isGif)));
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52629a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p0(NewSubPbActivity newSubPbActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i2)};
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
            this.f52629a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof b.a.r0.w3.a) && customResponsedMessage.getOrginalMessage().getTag() == this.f52629a.MESSAGE_ID_NEWSUB_PB) {
                b.a.r0.w3.a aVar = (b.a.r0.w3.a) customResponsedMessage.getData();
                this.f52629a.mSubPbView.R();
                SparseArray<Object> sparseArray = (SparseArray) this.f52629a.mExtra;
                DataRes dataRes = aVar.f25388a;
                if (aVar.f25390c == 0 && dataRes != null) {
                    z = b.a.e.e.m.b.e(dataRes.is_mute, 0) == 1;
                    sparseArray.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(b.a.r0.k2.i.tag_user_mute_msg, dataRes.mute_confirm);
                } else {
                    sparseArray.put(b.a.r0.k2.i.tag_user_mute_visible, Boolean.FALSE);
                    z = false;
                }
                int intValue = sparseArray.get(b.a.r0.k2.i.tag_from) instanceof Integer ? ((Integer) sparseArray.get(b.a.r0.k2.i.tag_from)).intValue() : 0;
                if (intValue == 0) {
                    this.f52629a.showOperateDialog(z, sparseArray);
                } else if (intValue == 1) {
                    this.f52629a.mSubPbView.h0(sparseArray, z);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52630a;

        public q(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52630a = newSubPbActivity;
        }

        @Override // b.a.q0.s.s.b.c
        public void a(b.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                bVar.e();
                if (this.f52630a.mSaveBdImage == null || TextUtils.isEmpty(this.f52630a.mSaveImageUrl)) {
                    return;
                }
                if (i2 == 0) {
                    if (this.f52630a.mEmotionInfo == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f52630a.mSaveImageUrl));
                    } else {
                        d.a aVar = new d.a();
                        aVar.f11986a = this.f52630a.mSaveImageUrl;
                        String str = "";
                        if (this.f52630a.mEmotionInfo.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.f52630a.mEmotionInfo.memeInfo.pck_id;
                        }
                        aVar.f11987b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i2 == 1) {
                    if (this.f52630a.mPermissionJudgement == null) {
                        this.f52630a.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.f52630a.mPermissionJudgement.clearRequestPermissionList();
                    this.f52630a.mPermissionJudgement.appendRequestPermission(this.f52630a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.f52630a.mPermissionJudgement.startRequestPermission(this.f52630a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.f52630a.mSaveImageHelper == null) {
                        NewSubPbActivity newSubPbActivity = this.f52630a;
                        newSubPbActivity.mSaveImageHelper = new w0(newSubPbActivity.getPageContext());
                    }
                    this.f52630a.mSaveImageHelper.b(this.f52630a.mSaveImageUrl, this.f52630a.mSaveBdImage.n());
                }
                this.f52630a.mSaveBdImage = null;
                this.f52630a.mSaveImageUrl = null;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q0 implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52631e;

        public q0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52631e = newSubPbActivity;
        }

        @Override // b.a.q0.s.g0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.f52631e.mSubPbModel == null) {
                return;
            }
            this.f52631e.mSubPbModel.Q0();
        }
    }

    /* loaded from: classes9.dex */
    public class r implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52632a;

        public r(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52632a = newSubPbActivity;
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void a(boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00d7  */
        @Override // b.a.r0.x0.q2.a.c.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(boolean z) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || !z) {
                return;
            }
            NewSubPbActivity newSubPbActivity = this.f52632a;
            if (newSubPbActivity.mReplyPrivacyController != null && newSubPbActivity.mSubPbModel != null && this.f52632a.mSubPbModel.h0() != null && !this.f52632a.isHost(TbadkCoreApplication.getCurrentAccount())) {
                NewSubPbActivity newSubPbActivity2 = this.f52632a;
                if (!newSubPbActivity2.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.mSubPbModel.h0().replyPrivateFlag)) {
                    return;
                }
            }
            if (this.f52632a.mSubPbModel != null && this.f52632a.mSubPbModel.j0() != null && this.f52632a.mSubPbModel.j0().i() != null) {
                PostData i2 = this.f52632a.mSubPbModel.j0().i();
                if (i2.M() != null && i2.t() != null) {
                    str = String.format(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.reply_title), i2.t().getName_show(), i2.M().toString());
                    this.f52632a.mEditor.a().sendAction(new b.a.q0.x.a(45, 27, str));
                    if (!this.f52632a.mEditor.x()) {
                        this.f52632a.mEditor.v(null);
                        return;
                    }
                    this.f52632a.mSubPbView.K0();
                    this.f52632a.mSubPbView.u();
                    if (this.f52632a.mEditor != null) {
                        this.f52632a.mEditor.i0();
                        return;
                    }
                    return;
                }
            }
            str = null;
            this.f52632a.mEditor.a().sendAction(new b.a.q0.x.a(45, 27, str));
            if (!this.f52632a.mEditor.x()) {
            }
        }

        @Override // b.a.r0.x0.q2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface r0 {
        void a(Object obj);
    }

    /* loaded from: classes9.dex */
    public class s implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52633e;

        public s(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52633e = newSubPbActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.f52633e.mSensitiveProcessController == null) {
                return;
            }
            if (!this.f52633e.mSensitiveProcessController.e()) {
                this.f52633e.checkContentSensitiveWord(false);
            }
            this.f52633e.mSensitiveProcessController.l(false);
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
            }
        }
    }

    /* loaded from: classes9.dex */
    public class t implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SparseArray f52634a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f52635b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f52636c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52637d;

        public t(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, sparseArray, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52637d = newSubPbActivity;
            this.f52634a = sparseArray;
            this.f52635b = z;
            this.f52636c = str;
        }

        @Override // b.a.q0.s.s.b.c
        public void a(b.a.q0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (i2 == 0) {
                    String str = this.f52634a.get(b.a.r0.k2.i.tag_user_mute_mute_username) instanceof String ? (String) this.f52634a.get(b.a.r0.k2.i.tag_user_mute_mute_username) : "";
                    String str2 = this.f52634a.get(b.a.r0.k2.i.tag_user_mute_thread_id) instanceof String ? (String) this.f52634a.get(b.a.r0.k2.i.tag_user_mute_thread_id) : "";
                    String str3 = this.f52634a.get(b.a.r0.k2.i.tag_user_mute_post_id) instanceof String ? (String) this.f52634a.get(b.a.r0.k2.i.tag_user_mute_post_id) : "";
                    String str4 = this.f52634a.get(b.a.r0.k2.i.tag_user_mute_msg) instanceof String ? (String) this.f52634a.get(b.a.r0.k2.i.tag_user_mute_msg) : "";
                    String str5 = this.f52634a.get(b.a.r0.k2.i.tag_user_mute_mute_nameshow) instanceof String ? (String) this.f52634a.get(b.a.r0.k2.i.tag_user_mute_mute_nameshow) : "";
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.f52635b, this.f52636c, str, str2, str3, 1, str4, this.f52637d.MESSAGE_ID_NEWSUB_PB);
                    userMuteAddAndDelCustomMessage.setTag(this.f52637d.MESSAGE_ID_NEWSUB_PB);
                    this.f52637d.showUserMuteDialog(this.f52635b, userMuteAddAndDelCustomMessage, str4, str, str5);
                }
                bVar.e();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52638a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(NewSubPbActivity newSubPbActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i2)};
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
            this.f52638a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                b.a.q0.f1.n.f.b(this.f52638a.getPageContext(), aVar.f12438a, aVar.f12439b, aVar.f12440c);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class v implements TiePlusEventController.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52639a;

        public v(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52639a = newSubPbActivity;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.d
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52639a.mIsRichTextListenerAcked = true;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class w implements b.a.e.e.k.c<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52640a;

        public w(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52640a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ GifView c(GifView gifView) {
            GifView gifView2 = gifView;
            h(gifView2);
            return gifView2;
        }

        public GifView e(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gifView)) == null) ? gifView : (GifView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.onDestroy();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new GifView(this.f52640a.getPageContext().getPageActivity()) : (GifView) invokeV.objValue;
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) ? gifView : (GifView) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class x implements b.a.e.e.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52641a;

        public x(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52641a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ ImageView c(ImageView imageView) {
            ImageView imageView2 = imageView;
            h(imageView2);
            return imageView2;
        }

        public ImageView e(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, imageView)) == null) {
                if (imageView instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) imageView;
                    tbImageView.setTag(null);
                    if (b.a.q0.s.k.c().g()) {
                        tbImageView.setAdjustViewBounds(false);
                        tbImageView.setInterceptOnClick(false);
                    } else {
                        tbImageView.setDefaultResource(b.a.r0.k2.h.icon_click);
                        tbImageView.setAdjustViewBounds(true);
                        tbImageView.setInterceptOnClick(true);
                    }
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: f */
        public void b(ImageView imageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, imageView) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(b.a.r0.k2.f.CAM_X0204);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.f52641a.getPageContext().getPageActivity());
                boolean g2 = b.a.q0.s.k.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(b.a.r0.k2.f.common_color_10220));
                if (g2) {
                    foreDrawableImageView.setAdjustViewBounds(false);
                    foreDrawableImageView.setInterceptOnClick(false);
                } else {
                    foreDrawableImageView.setDefaultResource(b.a.r0.k2.h.icon_click);
                    foreDrawableImageView.setAdjustViewBounds(true);
                    foreDrawableImageView.setInterceptOnClick(true);
                }
                return foreDrawableImageView;
            }
            return (ImageView) invokeV.objValue;
        }

        public ImageView h(ImageView imageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, imageView)) == null) {
                imageView.setBackgroundDrawable(null);
                imageView.setImageDrawable(null);
                imageView.setTag(null);
                imageView.setOnClickListener(null);
                if (imageView instanceof ForeDrawableImageView) {
                    ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                    foreDrawableImageView.stopLoading();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(b.a.r0.k2.f.CAM_X0204);
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class y implements b.a.e.e.k.c<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52642a;

        public y(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52642a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ View a(View view) {
            View view2 = view;
            e(view2);
            return view2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ View c(View view) {
            View view2 = view;
            h(view2);
            return view2;
        }

        public View e(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) ? view : (View) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: f */
        public void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
                ((PlayVoiceBntNew) view).reset();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.f52642a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.f52642a.getVoiceManager());
                playVoiceBntNew.setPlayTimeTextView(b.a.r0.k2.g.fontsize28);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
        }

        public View h(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
                ((PlayVoiceBntNew) view).reset();
                return view;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class z implements b.a.e.e.k.c<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f52643a;

        public z(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52643a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ LinearLayout c(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            h(linearLayout2);
            return linearLayout2;
        }

        public LinearLayout e(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, linearLayout)) == null) ? linearLayout : (LinearLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.f52643a.getPageContext().getPageActivity());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.setGravity(16);
                linearLayout.setBaselineAligned(true);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(layoutParams);
                return linearLayout;
            }
            return (LinearLayout) invokeV.objValue;
        }

        public LinearLayout h(LinearLayout linearLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, linearLayout)) == null) {
                linearLayout.removeAllViews();
                return linearLayout;
            }
            return (LinearLayout) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(889977085, "Lcom/baidu/tieba/pb/pb/sub/NewSubPbActivity;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(889977085, "Lcom/baidu/tieba/pb/pb/sub/NewSubPbActivity;");
        }
    }

    public NewSubPbActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsFromCDN = true;
        this.imgIndex = 0;
        this.postData = null;
        this.mMarkDoneCallBack = null;
        this.forbidUserCallback = null;
        this.deleteReplayCallback = null;
        this.mIsPaused = false;
        this.isFirstLoadData = false;
        this.mIsRichTextListenerAcked = false;
        this.mIsFromPb = false;
        this.mIsFromVideoTAb = false;
        this.mIsFromFoldComment = false;
        this.mFromVideoTab = 0;
        this.isFromVideoMiddle = false;
        this.mPrePostCallBack = new k(this);
        this.lastScrollState = 0;
        this.mIsFromSchema = false;
        this.mOnlyDisagreeId = BdUniqueId.gen();
        this.showTrisectionAndFeedback = b.a.q0.b.d.m0();
        this.needOpenEditor = true;
        this.richTextEventAckedCallback = new v(this);
        this.mCheckPostCallBack = new g0(this);
        this.subpbReplyListener = new l0(this, 2921481);
        this.mOnPostWriteNewCallback = new m0(this);
        this.mUserMuteAddListener = new n0(this, 2001427);
        this.mUserMuteDelListener = new o0(this, 2001428);
        this.mUserMuteCheckListener = new p0(this, 2001426);
        this.mOnPullRefreshListener = new q0(this);
        this.index_valid = false;
        this.mOnImageSaveClickListener = new q(this);
        this.richTextIntentClickListener = new u(this, 2001332);
        this.updatePendantMessageListener = new i0(this, 2016485);
    }

    private boolean checkIsIfPostForbid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65603, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null) {
                return false;
            }
            return AntiHelper.d(getPageContext(), subPbModel.h0());
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void clickOnDisagree(AgreeData agreeData) {
        b.a.q0.m0.c k2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65604, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.mMessageHelper == null) {
            this.mMessageHelper = new b.a.q0.s.c0.a();
        }
        if (this.mMsgData == null) {
            b.a.r0.l3.j0.e eVar = new b.a.r0.l3.j0.e();
            this.mMsgData = eVar;
            eVar.f20601a = this.mOnlyDisagreeId;
        }
        b.a.q0.s.q.f fVar = new b.a.q0.s.q.f();
        fVar.f13300b = 12;
        fVar.f13306h = 9;
        fVar.f13305g = 3;
        if (getSubPbModel() != null) {
            fVar.f13304f = getSubPbModel().u0();
        }
        fVar.f13299a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.f13307i = 0;
                k2 = TbPageExtraHelper.k(getActivity());
                if (k2 != null) {
                    agreeData.objSource = k2.a();
                }
                this.mMessageHelper.c(agreeData, i2, getUniqueId(), false);
                this.mMessageHelper.d(agreeData, this.mMsgData);
                if (getSubPbModel() != null || getSubPbModel().j0() == null) {
                }
                this.mMessageHelper.b(this, fVar, agreeData, getSubPbModel().j0().l());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.f13307i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.f13307i = 1;
        }
        i2 = 0;
        k2 = TbPageExtraHelper.k(getActivity());
        if (k2 != null) {
        }
        this.mMessageHelper.c(agreeData, i2, getUniqueId(), false);
        this.mMessageHelper.d(agreeData, this.mMsgData);
        if (getSubPbModel() != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doManager(View view) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65605, this, view) == null) || view == null || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        boolean booleanValue = sparseArray.get(b.a.r0.k2.i.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_should_manage_visible)).booleanValue() : false;
        boolean booleanValue2 = sparseArray.get(b.a.r0.k2.i.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_should_delete_visible)).booleanValue() : false;
        boolean booleanValue3 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue() : false;
        if (booleanValue) {
            if (booleanValue3) {
                sparseArray.put(b.a.r0.k2.i.tag_from, 1);
                checkMuteState(sparseArray);
            } else {
                this.mSubPbView.i0(view);
            }
        } else if (booleanValue2) {
            this.mSubPbView.g0(((Integer) sparseArray.get(b.a.r0.k2.i.tag_del_post_type)).intValue(), (String) sparseArray.get(b.a.r0.k2.i.tag_del_post_id), ((Integer) sparseArray.get(b.a.r0.k2.i.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(b.a.r0.k2.i.tag_del_post_is_self)).booleanValue(), false);
        }
        b.a.e.e.m.g.d(this.mSubPbView.M(), getPageContext().getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String encodeImageUrl(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65606, this, tbRichTextData)) == null) {
            if (tbRichTextData == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder(150);
            TbRichTextImageInfo C = tbRichTextData.C();
            if (C != null) {
                if (!StringUtils.isNull(C.w())) {
                    return C.w();
                }
                if (C.getHeight() * C.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                    double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (C.getHeight() * C.getWidth()));
                    sb.append(BigImageLoaderProc.NCDN_PER);
                    sb.append(String.valueOf((int) (C.getWidth() * sqrt)));
                    sb.append("&height=");
                    sb.append(String.valueOf((int) (C.getHeight() * sqrt)));
                } else {
                    double width = C.getWidth() / C.getHeight();
                    double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                    sb.append(BigImageLoaderProc.NCDN_PER);
                    sb.append(String.valueOf((int) (width * sqrt2)));
                    sb.append("&height=");
                    sb.append(String.valueOf((int) sqrt2));
                }
                sb.append("&src=");
                sb.append(b.a.e.e.p.k.getUrlEncode(C.B()));
                return sb.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    private void fixReplyFloorViewHolderPosition(boolean z2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        int i2;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65607, this, z2) == null) {
            Rect rect = new Rect();
            FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
            if (frameLayout != null && (childAt = frameLayout.getChildAt(0)) != null) {
                frameLayout.getWindowVisibleDisplayFrame(rect);
                if (z2) {
                    ((FrameLayout.LayoutParams) childAt.getLayoutParams()).height = rect.height();
                    childAt.requestLayout();
                }
            }
            b.a.r0.k2.u.h.a aVar = this.mSubPbView;
            if (aVar == null || aVar.G() == null || (pbCommenFloorItemViewHolder = this.mItemClickShowSoftKeyBoardViewHolder) == null || (i2 = pbCommenFloorItemViewHolder.mPosition) == -1) {
                return;
            }
            int headerViewsCount = i2 + this.mSubPbView.G().getHeaderViewsCount();
            if (this.mItemClickShowSoftKeyBoardViewHolder.getView() != null) {
                int height = this.mItemClickShowSoftKeyBoardViewHolder.getView().getHeight();
                int height2 = ((rect.height() - this.mSubPbView.A()) - this.mSubPbView.I()) - this.mSubPbView.B();
                int i3 = height - height2;
                if (i3 > 0) {
                    this.mSubPbView.G().post(new j0(this, headerViewsCount, i3));
                } else {
                    this.mSubPbView.G().post(new k0(this, headerViewsCount, height2, height));
                }
            }
        }
    }

    private TbRichText getImage(PostData postData, String str, int i2) {
        InterceptResult invokeLLI;
        TbRichText M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65608, this, postData, str, i2)) == null) {
            if (postData != null && (M = postData.M()) != null) {
                ArrayList<TbRichTextData> y2 = M.y();
                int size = y2.size();
                int i3 = -1;
                for (int i4 = 0; i4 < size; i4++) {
                    if (y2.get(i4) != null && y2.get(i4).getType() == 8) {
                        i3++;
                        if (y2.get(i4).C().y().equals(str)) {
                            int h2 = (int) b.a.e.e.p.l.h(TbadkCoreApplication.getInst());
                            int width = y2.get(i4).C().getWidth() * h2;
                            int height = y2.get(i4).C().getHeight() * h2;
                            if (width < 80 || height < 80 || width * height < 10000) {
                                return null;
                            }
                            this.imgIndex = i4;
                            return M;
                        } else if (i3 > i2) {
                            break;
                        }
                    }
                }
            }
            return null;
        }
        return (TbRichText) invokeLLI.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getImageIndex(TbRichText tbRichText, TbRichText tbRichText2, int i2, int i3, ArrayList<String> arrayList, ConcurrentHashMap<String, ImageUrlData> concurrentHashMap) {
        InterceptResult invokeCommon;
        TbRichTextImageInfo C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65609, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.index_valid = true;
            }
            if (tbRichText != null && tbRichText.y() != null) {
                int size = tbRichText.y().size();
                int i4 = -1;
                for (int i5 = 0; i5 < size; i5++) {
                    if (tbRichText.y().get(i5) != null && tbRichText.y().get(i5).getType() == 8) {
                        i4++;
                        int h2 = (int) b.a.e.e.p.l.h(TbadkCoreApplication.getInst());
                        int width = tbRichText.y().get(i5).C().getWidth() * h2;
                        int height = tbRichText.y().get(i5).C().getHeight() * h2;
                        if (!(width < 80 || height < 80 || width * height < 10000) && tbRichText.y().get(i5).C().D()) {
                            TbRichTextData tbRichTextData = tbRichText.y().get(i5);
                            String encodeImageUrl = encodeImageUrl(tbRichTextData);
                            arrayList.add(encodeImageUrl);
                            if (!TextUtils.isEmpty(encodeImageUrl) && tbRichTextData != null && (C = tbRichTextData.C()) != null) {
                                String y2 = C.y();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = y2;
                                imageUrlData.urlType = this.mIsFromCDN ? 17 : 18;
                                if (concurrentHashMap != null) {
                                    concurrentHashMap.put(encodeImageUrl, imageUrlData);
                                }
                            }
                            if (!this.index_valid) {
                                i2++;
                            }
                        } else if (tbRichText == tbRichText2 && i4 <= i3) {
                            i2--;
                        }
                    }
                }
            }
            return i2;
        }
        return invokeCommon.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65610, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || subPbModel.j0() == null) {
                return null;
            }
            return this.mSubPbModel.j0().l();
        }
        return (d2) invokeV.objValue;
    }

    private void handleFullScreenEditorResult(int i2, Intent intent) {
        b.a.q0.x.n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65611, this, i2, intent) == null) {
            this.mEditor.a().hideTools();
            this.mEditor.y();
            if (intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                this.mEditor.B(writeData);
                this.mEditor.c0(pbEditorData.getVoiceModel());
                b.a.q0.x.m findToolById = this.mEditor.a().findToolById(6);
                if (findToolById != null && (nVar = findToolById.k) != null) {
                    nVar.onAction(new b.a.q0.x.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.mEditor.F();
                }
                this.mSubPbView.T();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initEditor(boolean z2) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65612, this, z2) == null) {
            b.a.q0.x.x.h hVar = (b.a.q0.x.x.h) new b.a.q0.x.x.i(z2).a(getActivity());
            this.mEditor = hVar;
            if (hVar != null) {
                hVar.N(getPageContext());
                this.mEditor.a0(this.mSubPbModel);
                this.mEditor.Q(this.mOnPostWriteNewCallback);
                this.mEditor.O(2);
                this.mEditor.U(this.mPrePostCallBack);
                this.mEditor.M(this.mCheckPostCallBack);
                this.mEditor.a().showLinePositionBottom(true);
                this.mEditor.z(getPageContext());
                this.mEditor.P(this.mFromVideoTab);
            }
            b.a.r0.k2.u.h.a aVar = this.mSubPbView;
            if (aVar != null) {
                aVar.X(this.mEditor);
            }
            b.a.q0.x.x.h hVar2 = this.mEditor;
            if (hVar2 != null && (subPbModel = this.mSubPbModel) != null) {
                hVar2.G(subPbModel.h0());
                this.mEditor.y();
            }
            b.a.q0.x.x.h hVar3 = this.mEditor;
            if (hVar3 == null) {
                return;
            }
            hVar3.t().j(getReplyHint());
            this.mEditor.t().k(getReplyHint());
            EditText h2 = this.mEditor.t().h();
            this.mSubFloorEditText = h2;
            h2.addTextChangedListener(new s(this));
        }
    }

    private boolean initIsFromFoldComment(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65613, this, bundle)) == null) {
            if (bundle != null) {
                this.mIsFromFoldComment = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, false);
            } else {
                this.mIsFromFoldComment = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_FOLD_COMMENT, false);
            }
            return this.mIsFromFoldComment;
        }
        return invokeL.booleanValue;
    }

    private boolean initIsFromPb(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65614, this, bundle)) == null) {
            if (bundle != null) {
                this.mIsFromPb = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            } else {
                this.mIsFromPb = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_PB, false);
            }
            return this.mIsFromPb;
        }
        return invokeL.booleanValue;
    }

    private boolean initIsFromVideoMiddle(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65615, this, bundle)) == null) {
            if (bundle != null) {
                this.isFromVideoMiddle = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_MIDDLE);
            } else {
                this.isFromVideoMiddle = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_MIDDLE, false);
            }
            return this.isFromVideoMiddle;
        }
        return invokeL.booleanValue;
    }

    private boolean initIsFromVideoTab(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65616, this, bundle)) == null) {
            if (bundle != null) {
                this.mIsFromVideoTAb = bundle.getBoolean(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB, false);
                this.mFromVideoTab = bundle.getInt(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD);
            } else {
                Intent intent = getIntent();
                this.mIsFromVideoTAb = intent.getBooleanExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB, false);
                this.mFromVideoTab = intent.getIntExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD, 0);
            }
            return this.mIsFromVideoTAb;
        }
        return invokeL.booleanValue;
    }

    private int initIsFromVideoTabChild(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65617, this, bundle)) == null) {
            if (bundle != null) {
                this.mFromVideoTab = bundle.getInt(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD);
            } else {
                this.mFromVideoTab = getIntent().getIntExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD, 0);
            }
            return this.mFromVideoTab;
        }
        return invokeL.intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShowReportButton(boolean z2) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65618, this, z2)) == null) {
            if (this.mSubPbModel == null) {
                return false;
            }
            return ((getUserIdentity() != 0) || this.mSubPbModel.j0() == null || this.mSubPbModel.j0().l() == null || this.mSubPbModel.j0().l().J() == null || this.mSubPbModel.j0().l().D2() || TextUtils.equals(this.mSubPbModel.j0().l().J().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    private void jumpToWeb(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65619, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this, "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markFloor(View view) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65620, this, view) == null) {
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(b.a.r0.k2.i.tag_clip_board)) == null) {
                return;
            }
            markFloor(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void navigateToBubbleWebView(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65621, this, str) == null) && !StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String p2 = b.a.q0.s.e0.b.j().p("bubble_link", "");
            if (StringUtils.isNull(p2)) {
                return;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return;
            }
            b.a.q0.m.a.p(getPageContext().getPageActivity(), getResources().getString(b.a.r0.k2.l.editor_privilege), p2 + "?props_id=" + str, true, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNetOrDataError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65622, this, i2, str) == null) {
            if (this.mSubPbModel.D0()) {
                showToast(str);
            } else if (!b.a.e.e.p.l.D()) {
                this.mSubPbView.C0(b.a.r0.k2.l.recommend_pb_no_net_text);
            } else if (i2 == 4) {
                b.a.r0.k2.u.h.a aVar = this.mSubPbView;
                aVar.D0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
            } else if (!TextUtils.isEmpty(str)) {
                b.a.r0.k2.u.h.a aVar2 = this.mSubPbView;
                aVar2.D0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
            } else {
                this.mSubPbView.C0(b.a.r0.k2.l.no_data_text);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openEditor(SparseArray<Object> sparseArray, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65623, this, sparseArray, z2) == null) || sparseArray == null) {
            return;
        }
        if (sparseArray.get(b.a.r0.k2.i.tag_clip_board) instanceof PostData) {
            openEditor((PostData) sparseArray.get(b.a.r0.k2.i.tag_clip_board), z2);
        } else {
            openEditor((PostData) null, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processProfessionPermission() {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65625, this) == null) {
            Intent intent = getIntent();
            boolean booleanExtra = intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false;
            if (checkIsIfPostForbid()) {
                return;
            }
            if (booleanExtra) {
                if (this.mReplyPrivacyController == null || (subPbModel = this.mSubPbModel) == null || subPbModel.h0() == null || isHost(TbadkCoreApplication.getCurrentAccount()) || this.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(this.mSubPbModel.h0().replyPrivateFlag)) {
                    if (this.mEditor.x()) {
                        this.mEditor.v(null);
                        return;
                    }
                    this.mSubPbView.K0();
                    this.mSubPbView.u();
                    b.a.q0.x.x.h hVar = this.mEditor;
                    if (hVar != null) {
                        hVar.i0();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.mProfessionController == null) {
                b.a.r0.x0.q2.a.c cVar = new b.a.r0.x0.q2.a.c(getPageContext());
                this.mProfessionController = cVar;
                cVar.i(new r(this));
            }
            SubPbModel subPbModel2 = this.mSubPbModel;
            if (subPbModel2 == null || subPbModel2.j0() == null || this.mSubPbModel.j0().d() == null) {
                return;
            }
            this.mProfessionController.g(this.mSubPbModel.j0().d().getId(), b.a.e.e.m.b.g(this.mSubPbModel.x0(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDelNoSubPostDialog(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65626, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            b.a.r0.k2.u.f.f1.a.d(this, getPageContext(), new j(this, sparseArray, i2, z2), new l(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDeleteResumeEditorTips(View view, b.a.q0.x.x.h hVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65627, this, view, hVar, str) == null) {
            new WriteTipBubbleController(getPageContext(), new d(this, view, hVar)).d(view, getString(b.a.r0.k2.l.open_editor_tips), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOpenMemberReplyDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65628, this) == null) {
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(getPageContext().getPageActivity());
            aVar.setMessage(getResources().getString(b.a.r0.k2.l.mute_is_super_member_function));
            aVar.setPositiveButton(b.a.r0.k2.l.open_now, new f0(this));
            aVar.setNegativeButton(b.a.r0.k2.l.cancel, new h0(this));
            aVar.create(this.mCtx).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOperateDialog(boolean z2, SparseArray<Object> sparseArray) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65629, this, z2, sparseArray) == null) {
            String str = sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_userid) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_userid) : "";
            if (((Boolean) sparseArray.get(b.a.r0.k2.i.tag_user_mute_visible)).booleanValue()) {
                String[] strArr = new String[1];
                if (z2) {
                    string = getResources().getString(b.a.r0.k2.l.un_mute);
                } else {
                    string = getResources().getString(b.a.r0.k2.l.mute);
                }
                strArr[0] = string;
                b.a.q0.s.s.b bVar = new b.a.q0.s.s.b(getPageContext().getPageActivity());
                bVar.k(b.a.r0.k2.l.operation);
                bVar.j(strArr, new t(this, sparseArray, z2, str));
                bVar.c(getPageContext());
                bVar.m();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUserMuteAddDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65630, this, str) == null) {
            if (str == null) {
                str = "";
            }
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.mCtx.getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(b.a.r0.k2.l.know, new e0(this));
            aVar.create(this.mCtx).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUserMuteDialog(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65631, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                this.mSubPbView.A0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            b.a.q0.s.s.a aVar = new b.a.q0.s.s.a(this.mCtx.getPageActivity());
            if (b.a.e.e.p.k.isEmpty(str)) {
                aVar.setMessage(this.mCtx.getResources().getString(b.a.r0.k2.l.block_mute_message_alert, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(b.a.r0.k2.l.confirm, new c0(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(b.a.r0.k2.l.cancel, new d0(this));
            aVar.create(this.mCtx).show();
        }
    }

    private void startBrowsePageMission() {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65632, this) == null) || (subPbModel = this.mSubPbModel) == null || b.a.e.e.p.k.isEmpty(subPbModel.x0())) {
            return;
        }
        b.a.q0.a.d.y().P(b.a.q0.a.c.W, b.a.e.e.m.b.g(this.mSubPbModel.x0(), 0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText validImage(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65633, this, str, i2)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || subPbModel.j0() == null || str == null || i2 < 0) {
                return null;
            }
            b.a.r0.k2.r.s j02 = this.mSubPbModel.j0();
            TbRichText image = getImage(j02.i(), str, i2);
            if (image != null || (image = getImage(j02.i(), str, i2)) != null) {
            }
            return image;
        }
        return (TbRichText) invokeLI.objValue;
    }

    public void checkContentSensitiveWord(boolean z2) {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048576, this, z2) == null) || (editText = this.mSubFloorEditText) == null || editText.getText() == null) {
            return;
        }
        int selectionEnd = this.mSubFloorEditText.getSelectionEnd();
        SpannableStringBuilder f2 = this.mSensitiveProcessController.f(this.mSubFloorEditText.getText());
        if (f2 != null) {
            this.mSensitiveProcessController.l(true);
            this.mSubFloorEditText.setText(f2);
            if (z2 && this.mSensitiveProcessController.b() >= 0) {
                this.mSubFloorEditText.requestFocus();
                this.mSubFloorEditText.setSelection(this.mSensitiveProcessController.b());
            } else {
                this.mSubFloorEditText.setSelection(selectionEnd);
            }
            b.a.r0.d4.c cVar = this.mSensitiveProcessController;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void checkMuteState(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_userid) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_userid) : "";
            this.mSubPbView.A0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = b.a.e.e.m.b.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = b.a.e.e.m.b.g(str, 0L);
            this.mExtra = sparseArray;
            BdUniqueId bdUniqueId = this.MESSAGE_ID_NEWSUB_PB;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public void checkShowKeyboard() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (!TbadkCoreApplication.isLogin()) {
                this.mEditor.y();
            } else if (StringUtils.isNull(this.mSubPbModel.v0())) {
            } else {
                if (this.mSubPbView.I0() && b.a.e.e.p.l.D()) {
                    this.mSubPbView.p0();
                } else {
                    this.mSubPbView.l0();
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.mIsFromPb && !this.mIsFromSchema && !this.mIsFromVideoTAb && !this.mIsFromFoldComment) {
                ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
            } else {
                super.closeAnimation();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.mIsFromPb && !this.mIsFromSchema && !this.mIsFromVideoTAb && !this.mIsFromFoldComment) {
                ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            } else {
                super.enterExitAnimation();
            }
        }
    }

    public void finishDelPost(ForumManageModel.b bVar, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, bVar, z2) == null) || bVar == null) {
            return;
        }
        int i2 = 0;
        this.mSubPbView.z(0, bVar.f54247a, bVar.f54248b, z2);
        if (bVar.f54247a) {
            int i3 = bVar.f54250d;
            if (i3 == 1) {
                if (this.mSubPbView.G() instanceof BdTypeListView) {
                    List<b.a.e.l.e.n> data = ((BdTypeListView) this.mSubPbView.G()).getData();
                    if (!ListUtils.isEmpty(data)) {
                        while (i2 < data.size() && (!(data.get(i2) instanceof PostData) || !bVar.f54253g.equals(((PostData) data.get(i2)).G()))) {
                            i2++;
                        }
                        if (i2 < data.size()) {
                            data.remove(i2);
                        }
                        this.mSubPbView.a0();
                    }
                }
            } else if (i3 == 2) {
                this.mSubPbModel.f0(bVar.f54253g);
                this.mSubPbView.H0(this.mSubPbModel.j0(), this.mSubPbModel.B0(), this.mSubPbModel.A0() != null, false);
                if (this.mSubPbModel.M0()) {
                    this.mSubPbModel.Y0(false);
                    this.mSubPbView.s();
                    this.mSubPbModel.loadData();
                }
            }
            b.a.r0.k2.o oVar = new b.a.r0.k2.o();
            oVar.b(bVar);
            oVar.c(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, oVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, b.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "a007" : (String) invokeV.objValue;
    }

    @Override // b.a.r0.k2.u.a
    public b.a.r0.k2.u.f.c1.a getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mEvent : (b.a.r0.k2.u.f.c1.a) invokeV.objValue;
    }

    @Override // b.a.r0.k2.u.a
    public String getFromForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || subPbModel.j0() == null || this.mSubPbModel.j0().l() == null) {
                return null;
            }
            return this.mSubPbModel.j0().l().Z();
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.mGifViewPool == null) {
                this.mGifViewPool = new b.a.e.e.k.b<>(new w(this), 20, 0);
            }
            return this.mGifViewPool;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.mImageViewPool == null) {
                this.mImageViewPool = new b.a.e.e.k.b<>(new x(this), 8, 0);
            }
            return this.mImageViewPool;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            b.a.r0.k2.u.h.a aVar = this.mSubPbView;
            if (aVar != null) {
                return aVar.G();
            }
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public long getMissionTid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || b.a.e.e.p.k.isEmpty(subPbModel.x0())) {
                return 0L;
            }
            return b.a.e.e.m.b.g(this.mSubPbModel.x0(), 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public b.a.q0.o0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            b.a.q0.o0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && (subPbModel = this.mSubPbModel) != null) {
                if (subPbModel.j0() != null && this.mSubPbModel.j0().d() != null) {
                    pageStayDurationItem.t(b.a.e.e.m.b.g(this.mSubPbModel.j0().d().getId(), 0L));
                }
                pageStayDurationItem.C(b.a.e.e.m.b.g(this.mSubPbModel.x0(), 0L));
                if (this.mSubPbModel.j0() != null && this.mSubPbModel.j0().l() != null) {
                    d2 l2 = this.mSubPbModel.j0().l();
                    pageStayDurationItem.u(l2.F0());
                    if (l2.o2()) {
                        pageStayDurationItem.t = "1";
                    } else if (l2.E2()) {
                        pageStayDurationItem.t = "2";
                    } else {
                        pageStayDurationItem.t = "3";
                    }
                }
                pageStayDurationItem.w(b.a.e.e.m.b.g(this.mSubPbModel.y(), 0L));
            }
            return pageStayDurationItem;
        }
        return (b.a.q0.o0.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, b.a.q0.o0.a
    public b.a.q0.o0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new b0(this) : (b.a.q0.o0.b) invokeV.objValue;
    }

    public String getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null) {
                return subPbModel.y();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        InterceptResult invokeL;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, voiceData$VoiceModel)) == null) {
            View E = this.mSubPbView.E();
            if (E == null || (findViewWithTag = E.findViewWithTag(voiceData$VoiceModel)) == null) {
                return null;
            }
            return (VoiceManager.i) findViewWithTag;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            b.a.e.e.k.b<RelativeLayout> bVar = new b.a.e.e.k.b<>(new a0(this), 10, 0);
            this.mMemeViewPool = bVar;
            return bVar;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public String getReplyHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (!b.a.e.e.p.k.isEmpty(this.mReplyHintText)) {
                return this.mReplyHintText;
            }
            String string = getResources().getString(b.a.r0.k2.u.f.q0.b());
            this.mReplyHintText = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public SubPbModel getSubPbModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mSubPbModel : (SubPbModel) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.mTextViewPool == null) {
                this.mTextViewPool = TbRichTextView.createTextViewPool(getPageContext().getPageActivity(), 8);
            }
            return this.mTextViewPool;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.mTextVoiceViewPool == null) {
                this.mTextVoiceViewPool = new b.a.e.e.k.b<>(new z(this), 15, 0);
            }
            return this.mTextVoiceViewPool;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public String getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null) {
                return subPbModel.x0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    @Override // b.a.r0.k2.u.a
    public int getUserIdentify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null) {
                return 0;
            }
            return subPbModel.B0();
        }
        return invokeV.intValue;
    }

    public int getUserIdentity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null) {
                return subPbModel.B0();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mVoiceManager : (VoiceManager) invokeV.objValue;
    }

    @Override // b.a.q0.f1.n.i
    public b.a.e.e.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.mVoiceViewPool == null) {
                this.mVoiceViewPool = new b.a.e.e.k.b<>(new y(this), 8, 0);
            }
            return this.mVoiceViewPool;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public void handleMuteClick(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_username) : "";
            String str3 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_thread_id) : "";
            String str4 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_post_id) : "";
            if (sparseArray.get(b.a.r0.k2.i.tag_user_mute_msg) instanceof String) {
                str4 = (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_msg);
            }
            String str5 = str4;
            String str6 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_msg) : "";
            String str7 = sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(b.a.r0.k2.i.tag_user_mute_mute_nameshow) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z2, str, str2, str3, str5, 1, str6, this.MESSAGE_ID_NEWSUB_PB);
            userMuteAddAndDelCustomMessage.setTag(this.MESSAGE_ID_NEWSUB_PB);
            showUserMuteDialog(z2, userMuteAddAndDelCustomMessage, str6, str2, str7);
        }
    }

    public void handleReportClicked(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null && subPbModel.j0() != null && this.mSubPbModel.j0().l() != null && this.mSubPbModel.j0().l().Q1()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.mSubPbModel.x0(), str);
                d2 l2 = this.mSubPbModel.j0().l();
                if (l2.M1()) {
                    format = format + "&channelid=33833";
                } else if (l2.R1()) {
                    format = format + "&channelid=33842";
                } else if (l2.P1()) {
                    format = format + "&channelid=33840";
                }
                jumpToWeb(format);
                return;
            }
            this.mUEGReportController.a(str);
        }
    }

    public void initCallBacks() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.mSubPbCallBack = new e(this);
            this.mMarkDoneCallBack = new f(this);
            this.forbidUserCallback = new g(this);
            this.deleteReplayCallback = new h(this);
            this.mPostManageCallBack = new i(this);
        }
    }

    public void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            SubPbModel subPbModel = new SubPbModel(getPageContext());
            this.mSubPbModel = subPbModel;
            subPbModel.X0(new c(this));
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.mPostManageModel = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.mPostManageCallBack);
            VoiceManager voiceManager = new VoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onCreate(getPageContext());
            b.a.q0.i.a b2 = b.a.q0.i.a.b(this);
            this.mMarkModel = b2;
            if (b2 != null) {
                b2.j(this.mMarkDoneCallBack);
            }
            if (bundle != null) {
                this.mSubPbModel.initWithBundle(bundle);
            } else {
                this.mSubPbModel.initWithIntent(getIntent());
            }
            setForceInterceptStimeStat(this.mSubPbModel.F0());
            this.mSubPbModel.b1(this.mSubPbCallBack);
            if (this.mSubPbModel.I0() && !this.mSubPbModel.O0()) {
                this.mSubPbModel.loadData();
            } else if (!TextUtils.isEmpty(getIntent().getStringExtra("key_open_editor_tips"))) {
                this.mSubPbModel.loadData();
            } else {
                this.mSubPbModel.P0();
            }
        }
    }

    public void initListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            registerListener(this.updatePendantMessageListener);
            this.mCommonClickListener = new m(this);
            this.mSubPbScrollListener = new n(this);
            this.mOnLongClickListener = new o(this);
            this.mImageClickListener = new p(this);
        }
    }

    public void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            b.a.r0.k2.u.h.a aVar = new b.a.r0.k2.u.h.a(this, this.mCommonClickListener);
            this.mSubPbView = aVar;
            aVar.q0(this.mSubPbModel);
            setContentView(this.mSubPbView.P(), new FrameLayout.LayoutParams(-1, -1));
            this.mSubPbView.u0(this.mSubPbScrollListener);
            this.mSubPbView.v0(this);
            this.mSubPbView.r0(this.mImageClickListener);
            this.mSubPbView.s0(this.mOnLongClickListener);
            this.mSubPbView.t0(new b(this));
            this.mSubPbView.m0(this.forbidUserCallback);
            this.mSubPbView.k0(this.deleteReplayCallback);
            this.mSubPbView.o0(this.mOnPullRefreshListener);
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null && subPbModel.I0() && !this.mSubPbModel.N0()) {
                this.mSubPbView.D().setVisibility(8);
            } else {
                this.mSubPbView.D().setVisibility(0);
            }
            SubPbModel subPbModel2 = this.mSubPbModel;
            if (subPbModel2 == null || subPbModel2.I0()) {
                return;
            }
            this.mSubPbView.n0(false);
        }
    }

    public boolean isFromPb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null) {
                return subPbModel.I0();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isH5GameLink(String str) {
        InterceptResult invokeL;
        Map<String, String> paramPair;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (paramPair = UrlManager.getParamPair(UrlManager.getParamStr(str))) == null) {
                return false;
            }
            this.mIsRichTextListenerAcked = true;
            String str2 = paramPair.get("url");
            if (!TextUtils.isEmpty(str2)) {
                return isH5GameLink(b.a.e.e.p.k.getUrlDecode(str2));
            }
            String str3 = paramPair.get(TB_GAME_TYPE);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return invokeL.booleanValue;
    }

    @Override // b.a.r0.k2.u.a
    public boolean isHost(String str) {
        InterceptResult invokeL;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            if (StringUtils.isNull(str) || (subPbModel = this.mSubPbModel) == null || subPbModel.j0() == null || this.mSubPbModel.j0().l() == null || this.mSubPbModel.j0().l().J() == null) {
                return false;
            }
            return str.equals(this.mSubPbModel.j0().l().J().getUserId());
        }
        return invokeL.booleanValue;
    }

    public boolean isImage(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, view)) == null) ? (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView) : invokeL.booleanValue;
    }

    public boolean isPaused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.mIsPaused : invokeV.booleanValue;
    }

    @Override // b.a.r0.k2.u.a
    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || subPbModel.j0() == null || this.mSubPbModel.j0().l() == null) {
                return false;
            }
            return !this.mSubPbModel.j0().l().l2();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048619, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 25035) {
                handleFullScreenEditorResult(i3, intent);
            }
            b.a.q0.x.x.h hVar = this.mEditor;
            if (hVar != null) {
                hVar.C(i2, i3, intent);
            }
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048620, this, context, str) == null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
            this.mIsRichTextListenerAcked = true;
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            b.a.q0.x.x.h hVar = this.mEditor;
            if (hVar != null && hVar.a() != null && this.mEditor.a().isToolVisible()) {
                this.mEditor.a().hideTools();
            } else {
                super.onBackPressed();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mSubPbView.e0(i2);
            if (!this.mIsFromVideoTAb || UtilHelper.isFlyMeOs()) {
                return;
            }
            UtilHelper.changeStatusBarIconAndTextColor(true, this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, bundle) == null) {
            initIsFromPb(bundle);
            initIsFromVideoTab(bundle);
            initIsFromVideoTabChild(bundle);
            initIsFromVideoMiddle(bundle);
            initIsFromFoldComment(bundle);
            if (getIntent() != null) {
                this.mIsFromSchema = getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_FROM_SCHEMA, false);
                if (this.mIsFromVideoTAb) {
                    this.mVideoPageUniqueId = (BdUniqueId) getIntent().getSerializableExtra("key_from_video_page_id");
                }
            }
            super.onCreate(bundle);
            this.mCtx = getPageContext();
            this.isFirstLoadData = true;
            b.a.r0.d4.c cVar = new b.a.r0.d4.c();
            this.mSensitiveProcessController = cVar;
            cVar.h(b.a.r0.k2.f.cp_cont_h_alpha85);
            this.mSensitiveProcessController.j(b.a.r0.k2.f.CAM_X0101);
            initListeners();
            initCallBacks();
            initData(bundle);
            initUI();
            if (this.mIsFromVideoTAb) {
                ((SubPbView) this.mSubPbView.P()).setAnimTime(0);
                ((SubPbView) this.mSubPbView.P()).setIsFromVideoTab(true);
            } else if (this.mIsFromFoldComment) {
                setActivityBgTransparent();
                ((SubPbView) this.mSubPbView.P()).setAnimTime(0);
                ((SubPbView) this.mSubPbView.P()).setIsFromFoldComment(true);
            } else {
                ((SubPbView) this.mSubPbView.P()).setAnimTime(300);
                ((SubPbView) this.mSubPbView.P()).setIsFromVideoTab(false);
            }
            ((SubPbView) this.mSubPbView.P()).show();
            initEditor(false);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.mSubPbView.r(this.mIsFromSchema);
            b.a.q0.s.g0.c cVar2 = new b.a.q0.s.g0.c();
            this.mToastMute = cVar2;
            cVar2.f12958a = 1000L;
            registerListener(this.mUserMuteCheckListener);
            registerListener(this.mUserMuteAddListener);
            registerListener(this.mUserMuteDelListener);
            registerListener(this.subpbReplyListener);
            this.MESSAGE_ID_NEWSUB_PB = getUniqueId();
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
            userMuteAddAndDelCustomMessage.from = 1;
            BdUniqueId bdUniqueId = this.MESSAGE_ID_NEWSUB_PB;
            userMuteAddAndDelCustomMessage.mId = bdUniqueId;
            userMuteAddAndDelCustomMessage.setTag(bdUniqueId);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
            BdUniqueId bdUniqueId2 = this.MESSAGE_ID_NEWSUB_PB;
            userMuteCheckCustomMessage.mId = bdUniqueId2;
            userMuteCheckCustomMessage.setTag(bdUniqueId2);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
            ReplyPrivacyCheckController replyPrivacyCheckController = new ReplyPrivacyCheckController(getPageContext());
            this.mReplyPrivacyController = replyPrivacyCheckController;
            replyPrivacyCheckController.setAttentionCallback(new a(this));
            b.a.r0.k2.u.g.a aVar = new b.a.r0.k2.u.g.a(this);
            this.mUEGReportController = aVar;
            aVar.b(getUniqueId());
            this.mEvent = new b.a.r0.k2.u.f.c1.a(this);
            this.mUserBlockController = new b.a.r0.v3.b(getPageContext(), getUniqueId());
            if (this.tiePlusEventController == null) {
                if (this.isFromVideoMiddle) {
                    this.tiePlusEventController = new TiePlusEventController(this, TiePlusStat.Locate.VIDEO_MIDDLE_COMMENT);
                } else {
                    this.tiePlusEventController = new TiePlusEventController(this, TiePlusStat.Locate.PB_COMMENT);
                }
                this.tiePlusEventController.addEventAckedCallbackWeaked(this.richTextEventAckedCallback);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, this.mRefreshData));
            this.mSubPbModel.cancelLoadData();
            this.mSubPbModel.destory();
            this.mPostManageModel.cancelLoadData();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onDestory(getPageContext());
            }
            this.mSubPbView.w();
            this.mSubPbView.b0();
            MessageManager.getInstance().unRegisterListener(this.mUserMuteAddListener);
            MessageManager.getInstance().unRegisterListener(this.mUserMuteDelListener);
            MessageManager.getInstance().unRegisterListener(this.mUserMuteCheckListener);
            MessageManager.getInstance().unRegisterListener(this.MESSAGE_ID_NEWSUB_PB);
            b.a.r0.v3.b bVar = this.mUserBlockController;
            if (bVar != null) {
                bVar.l();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.mReplyPrivacyController;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            this.mCtx = null;
            this.mToastMute = null;
            TbPageExtraHelper.v(getCurrentPageKey());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onKeyboardVisibilityChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048625, this, z2) == null) {
            super.onKeyboardVisibilityChanged(z2);
            this.mIsSoftKeyBoardVisible = z2;
            fixReplyFloorViewHolderPosition(true);
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, context, str) == null) {
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onLinkClicked(Context context, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048627, this, context, str, z2) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (isH5GameLink(str)) {
            MessageManager.getInstance().dispatchResponsedMessage(new GameLaunchMessage(getApplicationContext(), null, str, null));
            return;
        }
        if (z2) {
            if (!TextUtils.isEmpty(str)) {
                b.a.q0.u.n nVar = new b.a.q0.u.n();
                nVar.f14159a = str;
                nVar.f14160b = 3;
                nVar.f14161c = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, nVar));
            }
        } else {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        }
        this.mIsRichTextListenerAcked = true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.mIsPaused = true;
            super.onPause();
            TiePlusEventController tiePlusEventController = this.tiePlusEventController;
            if (tiePlusEventController != null) {
                tiePlusEventController.onPause();
            }
            b.a.q0.a.d.y().E();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
            this.mSubPbView.c0();
            if (this.mIsFromVideoTAb || this.mIsFromFoldComment) {
                syncFloatBackGround(false);
            }
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048629, this, context, str, str2) == null) {
        }
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048630, this, z2) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, b.a.e.a.i
    public void onPreLoad(b.a.e.l.e.q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, qVar) == null) {
            PreLoadImageHelper.load(qVar, getUniqueId(), 3);
            PreLoadVideoHelper.load(qVar, getUniqueId(), this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            this.mIsPaused = false;
            super.onResume();
            TiePlusEventController tiePlusEventController = this.tiePlusEventController;
            if (tiePlusEventController != null) {
                tiePlusEventController.onResume();
            }
            startBrowsePageMission();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onResume(getPageContext());
            }
            registerListener(this.richTextIntentClickListener);
            this.mSubPbView.d0();
            if (this.mIsFromVideoTAb || this.mIsFromFoldComment) {
                syncFloatBackGround(true);
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048633, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle == null || (subPbModel = this.mSubPbModel) == null) {
                return;
            }
            subPbModel.W0(bundle);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (this.mSubPbView.I0() && b.a.e.e.p.l.D()) {
                this.mSubPbModel.loadData();
            } else {
                this.mSubPbView.l0();
            }
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048635, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048636, this) == null) {
            super.onStart();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onStart(getPageContext());
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048637, this) == null) {
            super.onStop();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onStop(getPageContext());
            }
            this.mEditor.E();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onUserChanged(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048638, this, z2) == null) {
            super.onUserChanged(z2);
            PbMoreDialog pbMoreDialog = this.mPostMoreOptionView;
            if (pbMoreDialog != null) {
                pbMoreDialog.changeLoginStyle(z2);
            }
            b.a.r0.k2.u.h.a aVar = this.mSubPbView;
            if (aVar != null) {
                aVar.t(z2);
            }
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048639, this, context, str) == null) {
        }
    }

    @Override // b.a.q0.f1.n.i
    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048640, this, context, str) == null) {
        }
    }

    public void stopVoice() {
        VoiceManager voiceManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048641, this) == null) || (voiceManager = this.mVoiceManager) == null) {
            return;
        }
        voiceManager.stopPlay();
    }

    public void syncFloatBackGround(boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048642, this, z2) == null) {
            CustomMessage customMessage = new CustomMessage(2921596);
            customMessage.setTag(this.mVideoPageUniqueId);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921596, Boolean.valueOf(z2));
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openEditor(PostData postData, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65624, this, postData, z2) == null) || checkIsIfPostForbid()) {
            return;
        }
        if (postData != null) {
            if (postData.t() != null) {
                MetaData t2 = postData.t();
                this.mEditor.W(t2.getUserId());
                boolean z3 = postData.o0;
                this.mEditor.p(String.format(TbadkCoreApplication.getInst().getResources().getString(b.a.r0.k2.l.reply_title), postData.t().getName_show(), postData.M() != null ? postData.M().toString() : ""));
                if (z3) {
                    if (!z2) {
                        this.mEditor.V(t2.getName_show(), t2.getPortrait());
                    }
                } else if (!z2) {
                    this.mEditor.V(t2.getName_show(), t2.getPortrait());
                }
            }
            this.mSubPbView.u();
        }
        if (this.mIsSoftKeyBoardVisible) {
            fixReplyFloorViewHolderPosition(false);
        }
    }

    public void markFloor(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, postData) == null) || postData == null) {
            return;
        }
        boolean z2 = false;
        if (this.mSubPbModel.L0() && postData.G() != null && postData.G().equals(this.mSubPbModel.s0())) {
            z2 = true;
        }
        MarkData r02 = this.mSubPbModel.r0(postData);
        if (r02 == null) {
            return;
        }
        this.mSubPbView.w();
        b.a.q0.i.a aVar = this.mMarkModel;
        if (aVar != null) {
            aVar.i(r02);
            if (!z2) {
                this.mMarkModel.a();
            } else {
                this.mMarkModel.d();
            }
        }
    }
}
