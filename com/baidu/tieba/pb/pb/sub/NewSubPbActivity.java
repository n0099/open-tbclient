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
import c.a.o0.b0.d;
import c.a.o0.e1.n.f;
import c.a.o0.h.a;
import c.a.o0.r.l0.f;
import c.a.o0.r.t.a;
import c.a.o0.r.t.c;
import c.a.p0.f1.i2.a.c;
import c.a.p0.w2.m.f.e1;
import c.a.p0.w2.m.f.y0;
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
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
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
/* loaded from: classes5.dex */
public class NewSubPbActivity extends BaseActivity<NewSubPbActivity> implements VoiceManager.j, c.a.o0.e1.n.i, BdListView.p, c.a.p0.w2.m.a<NewSubPbActivity> {
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
    public c.a.o0.w.y.b mCheckPostCallBack;
    public View.OnClickListener mCommonClickListener;
    public c.a.d.a.f mCtx;
    public c.a.o0.w.y.h mEditor;
    public TbRichTextMemeInfo mEmotionInfo;
    public c.a.p0.w2.m.f.k1.a mEvent;
    public Object mExtra;
    public int mFromVideoTab;
    public c.a.d.f.k.b<GifView> mGifViewPool;
    public TbRichTextView.y mImageClickListener;
    public c.a.d.f.k.b<ImageView> mImageViewPool;
    public boolean mIsFromCDN;
    public boolean mIsFromFoldComment;
    public boolean mIsFromPb;
    public boolean mIsFromSchema;
    public boolean mIsFromVideoTAb;
    public boolean mIsPaused;
    public boolean mIsRichTextListenerAcked;
    public boolean mIsSoftKeyBoardVisible;
    public PbCommenFloorItemViewHolder mItemClickShowSoftKeyBoardViewHolder;
    public a.InterfaceC0810a mMarkDoneCallBack;
    public c.a.o0.h.a mMarkModel;
    public c.a.d.f.k.b<RelativeLayout> mMemeViewPool;
    public c.a.o0.r.g0.a mMessageHelper;
    public c.a.p0.a4.k0.e mMsgData;
    public final c.InterfaceC0843c mOnImageSaveClickListener;
    public View.OnLongClickListener mOnLongClickListener;
    public NewWriteModel.g mOnPostWriteNewCallback;
    public final f.g mOnPullRefreshListener;
    public BdUniqueId mOnlyDisagreeId;
    public PermissionJudgePolicy mPermissionJudgement;
    public c.a.d.a.e mPostManageCallBack;
    public ForumManageModel mPostManageModel;
    public c.a.p0.w2.m.f.j0 mPostMoreOptionView;
    public PostWriteCallBackData mPostWriteCallBackData;
    public c.a.o0.w.y.c mPrePostCallBack;
    public c.a.p0.f1.i2.a.c mProfessionController;
    public c.a.p0.w2.f<c.a.p0.w2.i.u> mRefreshData;
    public String mReplyHintText;
    public ReplyPrivacyCheckController mReplyPrivacyController;
    public c.a.d.o.d.a mSaveBdImage;
    public e1 mSaveImageHelper;
    public String mSaveImageUrl;
    public c.a.p0.s4.c mSensitiveProcessController;
    public EditText mSubFloorEditText;
    public SubPbModel.b mSubPbCallBack;
    public SubPbModel mSubPbModel;
    public AbsListView.OnScrollListener mSubPbScrollListener;
    public c.a.p0.w2.m.h.a mSubPbView;
    public c.a.d.f.k.b<TextView> mTextViewPool;
    public c.a.d.f.k.b<LinearLayout> mTextVoiceViewPool;
    public c.a.o0.r.l0.c mToastMute;
    public c.a.p0.w2.m.g.a mUEGReportController;
    public c.a.p0.j4.b mUserBlockController;
    public CustomMessageListener mUserMuteAddListener;
    public CustomMessageListener mUserMuteCheckListener;
    public CustomMessageListener mUserMuteDelListener;
    public BdUniqueId mVideoPageUniqueId;
    public VoiceManager mVoiceManager;
    public c.a.d.f.k.b<View> mVoiceViewPool;
    public boolean needOpenEditor;
    public PostData postData;
    @NonNull
    public TiePlusEventController.f richTextEventAckedCallback;
    public CustomMessageListener richTextIntentClickListener;
    public boolean showTrisectionAndFeedback;
    public CustomMessageListener subpbReplyListener;
    @Nullable
    public TiePlusEventController tiePlusEventController;
    public CustomMessageListener updatePendantMessageListener;

    /* loaded from: classes5.dex */
    public class a implements ReplyPrivacyCheckController.IAfterAttentionCallBack {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public a(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tbadk.core.util.ReplyPrivacyCheckController.IAfterAttentionCallBack
        public void sendAfterAttention(boolean z, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) && z) {
                this.a.mEditor.F();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a0 implements c.a.d.f.k.c<RelativeLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public a0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ RelativeLayout a(RelativeLayout relativeLayout) {
            RelativeLayout relativeLayout2 = relativeLayout;
            e(relativeLayout2);
            return relativeLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(RelativeLayout relativeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, relativeLayout) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public RelativeLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new RelativeLayout(this.a.getPageContext().getPageActivity()) : (RelativeLayout) invokeV.objValue;
        }

        public RelativeLayout h(RelativeLayout relativeLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, relativeLayout)) == null) ? relativeLayout : (RelativeLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public b(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.mSubPbModel == null) {
                return;
            }
            this.a.mSubPbModel.loadData();
        }
    }

    /* loaded from: classes5.dex */
    public class b0 extends c.a.o0.p0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f35094b;

        public b0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35094b = newSubPbActivity;
        }

        @Override // c.a.o0.p0.b
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? c.a.o0.p0.e.b().c() : invokeV.intValue;
        }

        @Override // c.a.o0.p0.b
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements PbFakeFloorModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public c(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.b
        public void a(PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
                this.a.mSubPbView.A0(postData);
                this.a.mSubPbView.w0(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserMuteAddAndDelCustomMessage a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f35095b;

        public c0(NewSubPbActivity newSubPbActivity, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35095b = newSubPbActivity;
            this.a = userMuteAddAndDelCustomMessage;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f35095b.mSubPbView.B0();
                MessageManager.getInstance().sendMessage(this.a);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.o0.w.y.h f35096b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f35097c;

        public d(NewSubPbActivity newSubPbActivity, View view, c.a.o0.w.y.h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, view, hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35097c = newSubPbActivity;
            this.a = view;
            this.f35096b = hVar;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, str) == null) {
                this.a.performClick();
                this.f35096b.q();
                this.f35096b.t().h().setText(str);
                Editable text = this.f35096b.t().h().getText();
                if (TextUtils.isEmpty(text)) {
                    return;
                }
                this.f35096b.t().h().setSelection(text.length());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public d0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements SubPbModel.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.p0.w2.i.u a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ e f35098b;

            public a(e eVar, c.a.p0.w2.i.u uVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar, uVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35098b = eVar;
                this.a = uVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f35098b.a.needOpenEditor = false;
                    this.f35098b.a.openEditor(this.a.i(), false);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.sub.SubPbModel.b
        public void a(boolean z, int i, String str, c.a.p0.w2.i.u uVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str, uVar}) == null) || this.a.mSubPbView == null) {
                return;
            }
            this.a.mSubPbView.m0();
            if (!z) {
                this.a.onNetOrDataError(i, str);
                return;
            }
            this.a.mSubPbView.T();
            if (uVar != null) {
                if (uVar.i() != null || this.a.mSubPbModel != null) {
                    uVar.i().B0(this.a.mSubPbModel.y0());
                }
                if (this.a.mSubPbView != null) {
                    this.a.initEditor(uVar.l() != null && uVar.l().isBjh());
                    if (this.a.mEditor != null && this.a.mEditor.a() != null) {
                        this.a.mEditor.a().w(TbadkCoreApplication.getInst().getSkinType());
                    }
                    this.a.mSubPbView.I0(uVar, this.a.mSubPbModel.D0(), this.a.mSubPbModel.C0() != null, this.a.isFirstLoadData);
                    if (this.a.isFirstLoadData) {
                        this.a.mSubPbView.H().setSelectionFromTop(this.a.mSubPbView.H().getHeaderViewsCount() + 1, -c.a.d.f.p.n.f(this.a, R.dimen.tbds18));
                        this.a.checkShowKeyboard();
                        this.a.isFirstLoadData = false;
                    }
                }
                if (this.a.mEditor != null) {
                    this.a.mEditor.G(uVar.a());
                    this.a.mEditor.b0(uVar.l());
                    if (this.a.getIntent() != null && this.a.getIntent().getBooleanExtra(SubPbActivityConfig.KEY_IS_OPEN_EDITOR, false) && this.a.needOpenEditor) {
                        c.a.d.f.m.e.a().postDelayed(new a(this, uVar), 200L);
                    }
                }
                if (this.a.mRefreshData == null) {
                    this.a.mRefreshData = new c.a.p0.w2.f();
                }
                this.a.mRefreshData.b(uVar);
                this.a.mRefreshData.c(0);
                NewSubPbActivity newSubPbActivity = this.a;
                newSubPbActivity.mReplyPrivacyController.setLikeUserData(newSubPbActivity.mSubPbModel.k0());
            }
            String stringExtra = this.a.getIntent().getStringExtra("key_open_editor_tips");
            if (TextUtils.isEmpty(stringExtra) || this.a.hasRemindedEditorTips) {
                return;
            }
            this.a.hasRemindedEditorTips = true;
            NewSubPbActivity newSubPbActivity2 = this.a;
            newSubPbActivity2.showDeleteResumeEditorTips(newSubPbActivity2.mSubPbView.O(), this.a.mEditor, stringExtra);
            if (!this.a.mIsFromVideoTAb || this.a.mSubPbView.B() == null) {
                return;
            }
            NewSubPbActivity newSubPbActivity3 = this.a;
            newSubPbActivity3.hideLoadingView(newSubPbActivity3.mSubPbView.B());
        }
    }

    /* loaded from: classes5.dex */
    public class e0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public e0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.InterfaceC0810a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public f(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // c.a.o0.h.a.InterfaceC0810a
        public void a(boolean z, boolean z2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str}) == null) {
                if (z) {
                    if (this.a.mMarkModel != null) {
                        this.a.mMarkModel.h(z2);
                    }
                    MarkData f2 = this.a.mMarkModel.f();
                    c.a.p0.w2.f fVar = new c.a.p0.w2.f();
                    fVar.c(2);
                    if (z2) {
                        fVar.b(f2);
                        if (this.a.mMarkModel != null) {
                            if (f2 != null) {
                                this.a.mSubPbModel.b1(true);
                                this.a.mSubPbModel.c1(this.a.mSubPbModel.A());
                                this.a.showToast(R.string.obfuscated_res_0x7f0f00cd);
                            } else {
                                NewSubPbActivity newSubPbActivity = this.a;
                                newSubPbActivity.showToast(newSubPbActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f00cc));
                            }
                            if (this.a.mSubPbView != null) {
                                this.a.mSubPbView.M0(true);
                            }
                        }
                    } else {
                        fVar.b(null);
                        this.a.mSubPbModel.b1(false);
                        this.a.mSubPbModel.c1(null);
                        NewSubPbActivity newSubPbActivity2 = this.a;
                        newSubPbActivity2.showToast(newSubPbActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0f80));
                        if (this.a.mSubPbView != null) {
                            this.a.mSubPbView.M0(false);
                        }
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, fVar));
                    return;
                }
                NewSubPbActivity newSubPbActivity3 = this.a;
                newSubPbActivity3.showToast(newSubPbActivity3.getPageContext().getString(R.string.obfuscated_res_0x7f0f1486));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public f0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (Build.VERSION.SDK_INT < 11) {
                    aVar.dismiss();
                    ((TbPageContext) this.a.mCtx).showToast(R.string.obfuscated_res_0x7f0f06ed);
                    return;
                }
                TiebaStatic.log("c10025");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.a.mCtx.getPageActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements r0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public g(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.r0
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                Object[] objArr = (Object[]) obj;
                String valueOf = (this.a.mSubPbModel.l0() == null || this.a.mSubPbModel.l0().l() == null || this.a.mSubPbModel.l0().l().getAuthor() == null) ? "" : String.valueOf(this.a.mSubPbModel.l0().l().getAuthor().getUserId());
                String valueOf2 = objArr.length > 1 ? String.valueOf(objArr[1]) : "";
                String valueOf3 = objArr.length > 2 ? String.valueOf(objArr[2]) : "";
                this.a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.a.getPageContext().getPageActivity(), this.a.mSubPbModel.l0().d().getId(), this.a.mSubPbModel.l0().d().getName(), this.a.mSubPbModel.l0().l().getId(), valueOf, valueOf2, objArr.length > 3 ? String.valueOf(objArr[3]) : "", valueOf3, objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g0 implements c.a.o0.w.y.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public g0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // c.a.o0.w.y.b
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.mSensitiveProcessController.d()) {
                    NewSubPbActivity newSubPbActivity = this.a;
                    newSubPbActivity.showToast(newSubPbActivity.mSensitiveProcessController.c());
                    if (this.a.mEditor.x()) {
                        this.a.mEditor.v(this.a.mPostWriteCallBackData);
                    }
                    this.a.checkContentSensitiveWord(true);
                    return true;
                }
                NewSubPbActivity newSubPbActivity2 = this.a;
                if (newSubPbActivity2.mReplyPrivacyController == null || newSubPbActivity2.mSubPbModel == null || this.a.mSubPbModel.j0() == null || this.a.isHost(TbadkCoreApplication.getCurrentAccount())) {
                    return false;
                }
                NewSubPbActivity newSubPbActivity3 = this.a;
                return !newSubPbActivity3.mReplyPrivacyController.checkPrivacyBeforeSend(newSubPbActivity3.mSubPbModel.j0().replyPrivateFlag, ReplyPrivacyCheckController.TYPE_FLOOR);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class h implements r0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public h(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.pb.pb.sub.NewSubPbActivity.r0
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                Object[] objArr = (Object[]) obj;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount != null && currentAccount.length() > 0) {
                    if (this.a.mPostManageModel.R() || objArr == null || objArr.length < 4) {
                        return;
                    }
                    String valueOf = String.valueOf(objArr[0]);
                    int e2 = c.a.d.f.m.b.e(String.valueOf(objArr[1]), 0);
                    boolean b2 = c.a.d.f.m.b.b(String.valueOf(objArr[2]), false);
                    int e3 = c.a.d.f.m.b.e(String.valueOf(objArr[3]), 0);
                    if (this.a.mSubPbModel == null || this.a.mSubPbModel.l0() == null || this.a.mSubPbModel.l0().d() == null || this.a.mSubPbModel.l0().l() == null) {
                        return;
                    }
                    if (objArr.length > 4) {
                        this.a.mPostManageModel.T(String.valueOf(objArr[4]));
                    }
                    this.a.mPostManageModel.U(this.a.mSubPbModel.l0().d().getId(), this.a.mSubPbModel.l0().d().getName(), this.a.mSubPbModel.l0().l().getId(), valueOf, e3, e2, b2, this.a.mSubPbModel.l0().l().getBaijiahaoData(), false);
                    return;
                }
                TbadkCoreApplication.getInst().login(this.a.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.a.getPageContext().getPageActivity(), true, 11017)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h0 implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public h0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i extends c.a.d.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public i(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // c.a.d.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                boolean z = false;
                if (obj != null) {
                    int loadDataMode = this.a.mPostManageModel.getLoadDataMode();
                    if (loadDataMode == 0) {
                        ForumManageModel.b bVar = (ForumManageModel.b) obj;
                        this.a.finishDelPost(bVar, (bVar.f36159e != 1002 || bVar.f36160f) ? true : true);
                        return;
                    } else if (loadDataMode != 1) {
                        return;
                    } else {
                        ForumManageModel.d dVar = (ForumManageModel.d) obj;
                        this.a.mSubPbView.z(1, dVar.a, dVar.f36163b, true);
                        return;
                    }
                }
                this.a.mSubPbView.z(this.a.mPostManageModel.getLoadDataMode(), false, null, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i0(NewSubPbActivity newSubPbActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
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
                if (this.a.mSubPbModel.l0() == null || this.a.mSubPbModel.l0().i() == null || this.a.mSubPbModel.l0().i().s() == null || !currentAccount.equals(this.a.mSubPbModel.l0().i().s().getUserId()) || this.a.mSubPbModel.l0().i().s().getPendantData() == null) {
                    return;
                }
                this.a.mSubPbModel.l0().i().s().getPendantData().setImgUrl(userPendantData.getImgUrl());
                this.a.mSubPbModel.l0().i().s().getPendantData().setPropsId(userPendantData.getPropsId());
                this.a.mSubPbView.y(this.a.mSubPbModel.l0(), this.a.mSubPbModel.l0().i(), this.a.mSubPbModel.l0().e(), this.a.mSubPbModel.l0().f(), this.a.mSubPbModel.D0(), this.a.mSubPbModel.C0() != null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f35099b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f35100c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f35101d;

        public j(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, sparseArray, Integer.valueOf(i), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35101d = newSubPbActivity;
            this.a = sparseArray;
            this.f35099b = i;
            this.f35100c = z;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                if (this.f35101d.deleteReplayCallback != null) {
                    this.f35101d.deleteReplayCallback.a(new Object[]{this.a.get(R.id.obfuscated_res_0x7f091e6b), Integer.valueOf(this.f35099b), Boolean.valueOf(this.f35100c), this.a.get(R.id.obfuscated_res_0x7f091e6d)});
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f35102b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f35103c;

        public j0(NewSubPbActivity newSubPbActivity, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35103c = newSubPbActivity;
            this.a = i;
            this.f35102b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f35103c.mSubPbView == null || this.f35103c.mSubPbView.H() == null) {
                return;
            }
            this.f35103c.mSubPbView.H().setSelectionFromTop(this.a, this.f35103c.mSubPbView.J() - this.f35102b);
        }
    }

    /* loaded from: classes5.dex */
    public class k implements c.a.o0.w.y.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public k(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // c.a.o0.w.y.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mSubPbView.y0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k0 implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f35104b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f35105c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f35106d;

        public k0(NewSubPbActivity newSubPbActivity, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35106d = newSubPbActivity;
            this.a = i;
            this.f35104b = i2;
            this.f35105c = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f35106d.mSubPbView == null || this.f35106d.mSubPbView.H() == null) {
                return;
            }
            this.f35106d.mSubPbView.H().setSelectionFromTop(this.a, this.f35106d.mSubPbView.J() + (this.f35104b - this.f35105c));
        }
    }

    /* loaded from: classes5.dex */
    public class l implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public l(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l0(NewSubPbActivity newSubPbActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && this.a.mSubPbModel != null && (customResponsedMessage.getData() instanceof PostWriteCallBackData) && StringHelper.equals(((PostWriteCallBackData) customResponsedMessage.getData()).getThreadId(), this.a.mSubPbModel.z0())) {
                if (this.a.mSensitiveProcessController != null) {
                    this.a.mSensitiveProcessController.n(null);
                    this.a.mSensitiveProcessController.i(null);
                    this.a.mSensitiveProcessController.k(false);
                }
                if (this.a.mEditor != null) {
                    this.a.mEditor.q();
                    this.a.mEditor.H();
                }
                this.a.mSubPbModel.J();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.p0.w2.m.f.k1.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ PostData f35107b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ m f35108c;

            public a(m mVar, c.a.p0.w2.m.f.k1.c cVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {mVar, cVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f35108c = mVar;
                this.a = cVar;
                this.f35107b = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.w2.m.f.h hVar = new c.a.p0.w2.m.f.h(new c.a.o0.e1.n.a());
                    hVar.j(c.a.d.f.p.n.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18));
                    hVar.o(TbConfig.getPostLineSpace(), 1.0f);
                    this.a.f20191b.a(null, this.f35108c.a.mSubPbModel.l0().l(), this.f35107b, hVar);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray;
            String str;
            PostData postData;
            String b2;
            SparseArray sparseArray2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view == null && this.a.mSubPbView == null) {
                    return;
                }
                boolean z = true;
                if (view == this.a.mSubPbView.G()) {
                    this.a.mSubPbView.w();
                    String str2 = view.getTag(R.id.obfuscated_res_0x7f091eb7) instanceof String ? (String) view.getTag(R.id.obfuscated_res_0x7f091eb7) : null;
                    String str3 = view.getTag(R.id.obfuscated_res_0x7f091ebf) instanceof String ? (String) view.getTag(R.id.obfuscated_res_0x7f091ebf) : null;
                    String str4 = view.getTag(R.id.obfuscated_res_0x7f091ec1) instanceof String ? (String) view.getTag(R.id.obfuscated_res_0x7f091ec1) : null;
                    if (str4 != null) {
                        if (this.a.checkUpIsLogin()) {
                            UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{str4});
                        }
                    } else if (str2 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getPageContext().getPageActivity(), str2, str3, null, AddFriendActivityConfig.TYPE_PB_FLOOR)));
                    }
                } else if (view != this.a.mSubPbView.O()) {
                    if (view != this.a.mSubPbView.L()) {
                        if (view == this.a.mSubPbView.M()) {
                            if (this.a.checkUpIsLogin()) {
                                this.a.mSubPbView.L0();
                                this.a.mSubPbView.u();
                                if (this.a.mEditor != null) {
                                    this.a.mEditor.g0();
                                }
                            }
                        } else if (view.getId() != R.id.obfuscated_res_0x7f0916b4) {
                            if (view == this.a.mSubPbView.I()) {
                                this.a.mSubPbView.w();
                                if (this.a.mSubPbModel.loadData()) {
                                    this.a.mSubPbView.H0();
                                    return;
                                }
                                return;
                            }
                            str = "";
                            if (view == this.a.mSubPbView.E() || view == this.a.mSubPbView.D() || view == this.a.mSubPbView.P()) {
                                if (this.a.mIsRichTextListenerAcked) {
                                    this.a.mIsRichTextListenerAcked = false;
                                    return;
                                }
                                if (this.a.mSubPbModel.l0() != null && this.a.mSubPbModel.l0().l() != null) {
                                    r4 = ThreadCardUtils.isUgcThreadType(this.a.mSubPbModel.l0().l().getBaijiahaoData());
                                }
                                if (r4) {
                                    PbActivityConfig createNormalCfg = new PbActivityConfig(this.a.getActivity()).createNormalCfg(this.a.mSubPbModel.z0(), null, "");
                                    if (!StringUtils.isNull(this.a.mSubPbModel.getFromForumId())) {
                                        createNormalCfg.setForumId(this.a.mSubPbModel.getFromForumId());
                                    }
                                    if (this.a.mSubPbModel.l0() != null && this.a.mSubPbModel.l0().l() != null) {
                                        createNormalCfg.setBjhData(this.a.mSubPbModel.l0().l().getBaijiahaoData());
                                    }
                                    MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                                    return;
                                }
                                PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.a.getActivity()).createNormalCfg(this.a.mSubPbModel.z0(), this.a.mSubPbModel.A(), "");
                                if (!StringUtils.isNull(this.a.mSubPbModel.getFromForumId())) {
                                    createNormalCfg2.setForumId(this.a.mSubPbModel.getFromForumId());
                                }
                                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg2));
                            } else if (this.a.mSubPbView.K() == null || view != this.a.mSubPbView.K().A()) {
                                if (this.a.mSubPbView.K() == null || view != this.a.mSubPbView.K().u()) {
                                    if (this.a.mSubPbView.K() == null || view != this.a.mSubPbView.K().z()) {
                                        if (this.a.mSubPbView.K() == null || view != this.a.mSubPbView.K().D()) {
                                            if (this.a.mSubPbView.K() == null || view != this.a.mSubPbView.K().t()) {
                                                if (view != this.a.mSubPbView.F() && view != this.a.mSubPbView.P()) {
                                                    if (view != null && (view.getTag() instanceof PbCommenFloorItemViewHolder)) {
                                                        this.a.mItemClickShowSoftKeyBoardViewHolder = (PbCommenFloorItemViewHolder) view.getTag();
                                                        if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                            if (this.a.mIsRichTextListenerAcked) {
                                                                this.a.mIsRichTextListenerAcked = false;
                                                                return;
                                                            }
                                                            NewSubPbActivity newSubPbActivity = this.a;
                                                            if (newSubPbActivity.mReplyPrivacyController != null && newSubPbActivity.mSubPbModel != null && this.a.mSubPbModel.j0() != null && !this.a.isHost(TbadkCoreApplication.getCurrentAccount())) {
                                                                NewSubPbActivity newSubPbActivity2 = this.a;
                                                                if (!newSubPbActivity2.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.mSubPbModel.j0().replyPrivateFlag)) {
                                                                    return;
                                                                }
                                                            }
                                                            SparseArray sparseArray3 = (SparseArray) view.getTag(R.id.obfuscated_res_0x7f091e7c);
                                                            if (sparseArray3 == null) {
                                                                return;
                                                            }
                                                            if ((view.getTag(R.id.obfuscated_res_0x7f091eaf) instanceof Boolean) && view.getTag(R.id.obfuscated_res_0x7f091eaf) == Boolean.TRUE) {
                                                                r4 = true;
                                                            }
                                                            this.a.openEditor(sparseArray3, r4);
                                                            if (sparseArray3.get(R.id.obfuscated_res_0x7f091e69) instanceof PostData) {
                                                                PostData postData2 = (PostData) sparseArray3.get(R.id.obfuscated_res_0x7f091e69);
                                                                c.a.p0.w2.m.h.e.a(this.a.mSubPbModel != null ? this.a.mSubPbModel.z0() : "", postData2.s() == null ? "" : postData2.s().getUserId(), postData2.G());
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        return;
                                                    } else if (view.getId() != R.id.obfuscated_res_0x7f0918b2 && view.getId() != R.id.obfuscated_res_0x7f0916b0 && (this.a.mPostMoreOptionView == null || view != this.a.mPostMoreOptionView.C())) {
                                                        if (this.a.mPostMoreOptionView == null || view != this.a.mPostMoreOptionView.D()) {
                                                            if (this.a.mPostMoreOptionView == null || view != this.a.mPostMoreOptionView.A()) {
                                                                if (this.a.mPostMoreOptionView == null || view != this.a.mPostMoreOptionView.u()) {
                                                                    if (this.a.mPostMoreOptionView == null || view != this.a.mPostMoreOptionView.t()) {
                                                                        if (this.a.mPostMoreOptionView == null || view != this.a.mPostMoreOptionView.w()) {
                                                                            if (this.a.mPostMoreOptionView == null || view != this.a.mPostMoreOptionView.E()) {
                                                                                if (this.a.mPostMoreOptionView == null || view != this.a.mPostMoreOptionView.v()) {
                                                                                    if (this.a.mPostMoreOptionView == null || view != this.a.mPostMoreOptionView.z()) {
                                                                                        if (this.a.mPostMoreOptionView == null || view != this.a.mPostMoreOptionView.s()) {
                                                                                            if (this.a.mPostMoreOptionView != null && view == this.a.mPostMoreOptionView.F()) {
                                                                                                if (view.getTag() instanceof SparseArray) {
                                                                                                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                                                                                                    if (sparseArray4.get(R.id.obfuscated_res_0x7f091e85) instanceof PostData) {
                                                                                                        PostData postData3 = (PostData) sparseArray4.get(R.id.obfuscated_res_0x7f091e85);
                                                                                                        c.a.p0.w2.m.f.k1.c cVar = new c.a.p0.w2.m.f.k1.c(this.a.getPageContext());
                                                                                                        if (postData3 != null) {
                                                                                                            c.a.d.f.m.e.a().postDelayed(new a(this, cVar, postData3), 100L);
                                                                                                            String id = this.a.mSubPbModel.l0().l().getId();
                                                                                                            if (StringUtils.isNull(id) || "0".equals(id)) {
                                                                                                                id = this.a.mSubPbModel.l0().l().getNid();
                                                                                                            }
                                                                                                            TiebaStatic.log(new StatisticItem("c13700").param("tid", id).param("fid", this.a.mSubPbModel.l0().l().getFid()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData3.G()).param("obj_source", 1).param("obj_type", 4));
                                                                                                            return;
                                                                                                        }
                                                                                                        return;
                                                                                                    }
                                                                                                    return;
                                                                                                }
                                                                                                return;
                                                                                            }
                                                                                            int id2 = view.getId();
                                                                                            if (id2 == R.id.obfuscated_res_0x7f0916de) {
                                                                                                if (ViewHelper.checkUpIsLogin(this.a.getPageContext().getPageActivity())) {
                                                                                                    String string = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f133a);
                                                                                                    String q = c.a.o0.r.j0.b.k().q("tail_link", "");
                                                                                                    if (StringUtils.isNull(q)) {
                                                                                                        return;
                                                                                                    }
                                                                                                    TiebaStatic.log("c10056");
                                                                                                    c.a.o0.l.a.q(view.getContext(), string, q, true, true, true);
                                                                                                    return;
                                                                                                }
                                                                                                return;
                                                                                            } else if (id2 == R.id.obfuscated_res_0x7f091a8a && (view.getTag() instanceof SparseArray)) {
                                                                                                Object obj = ((SparseArray) view.getTag()).get(R.id.obfuscated_res_0x7f091e69);
                                                                                                if (obj instanceof PostData) {
                                                                                                    PostData postData4 = (PostData) obj;
                                                                                                    if (postData4.getType() == PostData.y0 || TextUtils.isEmpty(postData4.u()) || !c.a.o0.r.l.c().g()) {
                                                                                                        return;
                                                                                                    }
                                                                                                    this.a.navigateToBubbleWebView(postData4.G());
                                                                                                    return;
                                                                                                }
                                                                                                return;
                                                                                            } else {
                                                                                                return;
                                                                                            }
                                                                                        } else if (!c.a.d.f.p.l.z()) {
                                                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                                                                                            return;
                                                                                        } else if (!ViewHelper.checkUpIsLogin(this.a.getActivity()) || (b2 = c.a.p0.j4.a.b(view)) == null || this.a.mUserBlockController == null) {
                                                                                            return;
                                                                                        } else {
                                                                                            this.a.mUserBlockController.n(c.a.d.f.m.b.g(b2, 0L));
                                                                                            return;
                                                                                        }
                                                                                    } else if (!c.a.d.f.p.l.z()) {
                                                                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                                                                                        return;
                                                                                    } else {
                                                                                        SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                                                                                        if (sparseArray5 == null) {
                                                                                            return;
                                                                                        }
                                                                                        boolean booleanValue = ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f091eab)).booleanValue();
                                                                                        boolean booleanValue2 = ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f091ea9)).booleanValue();
                                                                                        boolean booleanValue3 = ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue();
                                                                                        r4 = sparseArray5.get(R.id.obfuscated_res_0x7f091e81) instanceof Boolean ? ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f091e81)).booleanValue() : false;
                                                                                        if (!booleanValue) {
                                                                                            if (booleanValue2) {
                                                                                                this.a.mSubPbView.h0(((Integer) sparseArray5.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) sparseArray5.get(R.id.obfuscated_res_0x7f091e6b), ((Integer) sparseArray5.get(R.id.obfuscated_res_0x7f091e88)).intValue(), ((Boolean) sparseArray5.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue(), false);
                                                                                                return;
                                                                                            }
                                                                                            return;
                                                                                        } else if (!booleanValue3) {
                                                                                            if (r4) {
                                                                                                sparseArray5.put(R.id.obfuscated_res_0x7f091e65, 2);
                                                                                            }
                                                                                            this.a.mSubPbView.j0(view);
                                                                                            return;
                                                                                        } else {
                                                                                            sparseArray5.put(R.id.obfuscated_res_0x7f091e7c, 1);
                                                                                            sparseArray5.put(R.id.obfuscated_res_0x7f091e65, 2);
                                                                                            this.a.checkMuteState(sparseArray5);
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                } else if (this.a.checkUpIsLogin() && (sparseArray2 = (SparseArray) view.getTag()) != null) {
                                                                                    PostData postData5 = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f091e69);
                                                                                    if (postData5.q() == null) {
                                                                                        return;
                                                                                    }
                                                                                    this.a.clickOnDisagree(postData5.q());
                                                                                    return;
                                                                                } else {
                                                                                    return;
                                                                                }
                                                                            } else if (this.a.mSaveBdImage == null || TextUtils.isEmpty(this.a.mSaveImageUrl)) {
                                                                                return;
                                                                            } else {
                                                                                if (this.a.mPermissionJudgement == null) {
                                                                                    this.a.mPermissionJudgement = new PermissionJudgePolicy();
                                                                                }
                                                                                this.a.mPermissionJudgement.clearRequestPermissionList();
                                                                                this.a.mPermissionJudgement.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                                                                                if (this.a.mPermissionJudgement.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                                                                                    return;
                                                                                }
                                                                                if (this.a.mSaveImageHelper == null) {
                                                                                    NewSubPbActivity newSubPbActivity3 = this.a;
                                                                                    newSubPbActivity3.mSaveImageHelper = new e1(newSubPbActivity3.getPageContext());
                                                                                }
                                                                                this.a.mSaveImageHelper.b(this.a.mSaveImageUrl, this.a.mSaveBdImage.n());
                                                                                this.a.mSaveBdImage = null;
                                                                                this.a.mSaveImageUrl = null;
                                                                                return;
                                                                            }
                                                                        } else if (this.a.mSaveBdImage == null || TextUtils.isEmpty(this.a.mSaveImageUrl)) {
                                                                            return;
                                                                        } else {
                                                                            if (this.a.mEmotionInfo == null) {
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.mSaveImageUrl));
                                                                            } else {
                                                                                d.a aVar = new d.a();
                                                                                aVar.a = this.a.mSaveImageUrl;
                                                                                if (this.a.mEmotionInfo.memeInfo.pck_id.intValue() >= 0) {
                                                                                    str = "" + this.a.mEmotionInfo.memeInfo.pck_id;
                                                                                }
                                                                                aVar.f9865b = str;
                                                                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                                                                            }
                                                                            this.a.mSaveBdImage = null;
                                                                            this.a.mSaveImageUrl = null;
                                                                            return;
                                                                        }
                                                                    }
                                                                    PostData postData6 = this.a.postData;
                                                                    if (postData6 != null) {
                                                                        postData6.m0();
                                                                        this.a.postData = null;
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                SparseArray sparseArray6 = (SparseArray) view.getTag();
                                                                if (sparseArray6 != null && (sparseArray6.get(R.id.obfuscated_res_0x7f091e6d) instanceof Integer) && (sparseArray6.get(R.id.obfuscated_res_0x7f091e6b) instanceof String) && (sparseArray6.get(R.id.obfuscated_res_0x7f091e88) instanceof Integer) && (sparseArray6.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean)) {
                                                                    boolean booleanValue4 = ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue();
                                                                    int intValue = ((Integer) sparseArray6.get(R.id.obfuscated_res_0x7f091e88)).intValue();
                                                                    boolean booleanValue5 = ((Boolean) sparseArray6.get(R.id.obfuscated_res_0x7f091e7d)).booleanValue();
                                                                    boolean isHost = this.a.isHost(TbadkCoreApplication.getCurrentAccount());
                                                                    if (isHost) {
                                                                        if (!booleanValue5) {
                                                                            this.a.showDelNoSubPostDialog(sparseArray6, intValue, booleanValue4);
                                                                            return;
                                                                        } else {
                                                                            this.a.mSubPbView.h0(((Integer) sparseArray6.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) sparseArray6.get(R.id.obfuscated_res_0x7f091e6b), intValue, booleanValue4, isHost);
                                                                            return;
                                                                        }
                                                                    } else if (booleanValue4 && !booleanValue5) {
                                                                        this.a.showDelNoSubPostDialog(sparseArray6, intValue, booleanValue4);
                                                                        return;
                                                                    } else {
                                                                        this.a.mSubPbView.h0(((Integer) sparseArray6.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) sparseArray6.get(R.id.obfuscated_res_0x7f091e6b), intValue, booleanValue4, isHost);
                                                                        return;
                                                                    }
                                                                }
                                                                return;
                                                            } else if (this.a.checkUpIsLogin()) {
                                                                this.a.markFloor(view);
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        } else if (!c.a.d.f.p.l.z()) {
                                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                                                            return;
                                                        } else {
                                                            Object tag = view.getTag();
                                                            if (tag instanceof String) {
                                                                this.a.handleReportClicked((String) tag);
                                                                return;
                                                            } else if (tag instanceof SparseArray) {
                                                                SparseArray<Object> sparseArray7 = (SparseArray) tag;
                                                                if ((sparseArray7.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean) && ((Boolean) sparseArray7.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue()) {
                                                                    sparseArray7.put(R.id.obfuscated_res_0x7f091e7c, 0);
                                                                    sparseArray7.put(R.id.obfuscated_res_0x7f091e65, 2);
                                                                    this.a.checkMuteState(sparseArray7);
                                                                    return;
                                                                }
                                                                return;
                                                            } else {
                                                                return;
                                                            }
                                                        }
                                                    } else if (this.a.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                                                        SparseArray sparseArray8 = (SparseArray) view.getTag();
                                                        if ((sparseArray8.get(R.id.obfuscated_res_0x7f091e85) instanceof PostData) && (postData = (PostData) sparseArray8.get(R.id.obfuscated_res_0x7f091e85)) != null) {
                                                            if (this.a.mSubPbModel != null) {
                                                                TiebaStatic.log(new StatisticItem("c13700").param("tid", this.a.mSubPbModel.A0()).param("fid", this.a.mSubPbModel.getFromForumId()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.G()).param("obj_source", 1).param("obj_type", 3));
                                                            }
                                                            this.a.openEditor(postData, (view.getTag(R.id.obfuscated_res_0x7f091eaf) instanceof Boolean) && view.getTag(R.id.obfuscated_res_0x7f091eaf) == Boolean.TRUE);
                                                            return;
                                                        }
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (this.a.checkUpIsLogin()) {
                                                    if (this.a.mEditor.A()) {
                                                        this.a.mEditor.y();
                                                        return;
                                                    } else {
                                                        this.a.mEditor.j0(null, null);
                                                        return;
                                                    }
                                                } else {
                                                    return;
                                                }
                                            } else if (view.getTag() == null || !(view.getTag() instanceof SparseArray)) {
                                                return;
                                            } else {
                                                SparseArray sparseArray9 = (SparseArray) view.getTag();
                                                if (sparseArray9.get(R.id.obfuscated_res_0x7f091e69) instanceof PostData) {
                                                    ((PostData) sparseArray9.get(R.id.obfuscated_res_0x7f091e69)).m0();
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                                        if (!c.a.d.f.p.l.z()) {
                                            this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                                            return;
                                        }
                                        Object tag2 = view.getTag();
                                        this.a.mSubPbView.w();
                                        if (tag2 instanceof String) {
                                            String str5 = (String) tag2;
                                            if (this.a.checkUpIsLogin()) {
                                                this.a.handleReportClicked(str5);
                                                return;
                                            }
                                            return;
                                        } else if (tag2 instanceof SparseArray) {
                                            SparseArray<Object> sparseArray10 = (SparseArray) tag2;
                                            if ((sparseArray10.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean) && ((Boolean) sparseArray10.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue()) {
                                                sparseArray10.put(R.id.obfuscated_res_0x7f091e7c, 0);
                                                sparseArray10.put(R.id.obfuscated_res_0x7f091e65, 2);
                                                this.a.checkMuteState(sparseArray10);
                                                return;
                                            }
                                            return;
                                        } else {
                                            return;
                                        }
                                    } else if (c.a.d.f.p.l.z()) {
                                        this.a.mSubPbView.w();
                                        if (this.a.checkUpIsLogin()) {
                                            this.a.doManager(view);
                                            return;
                                        }
                                        return;
                                    } else {
                                        this.a.showToast(R.string.obfuscated_res_0x7f0f0c16);
                                        return;
                                    }
                                }
                                this.a.mSubPbView.w();
                                SparseArray sparseArray11 = (SparseArray) view.getTag();
                                if (sparseArray11 == null) {
                                    return;
                                }
                                this.a.mSubPbView.h0(((Integer) sparseArray11.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) sparseArray11.get(R.id.obfuscated_res_0x7f091e6b), ((Integer) sparseArray11.get(R.id.obfuscated_res_0x7f091e88)).intValue(), ((Boolean) sparseArray11.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue(), false);
                            } else {
                                TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                                this.a.mSubPbView.w();
                                if (this.a.checkUpIsLogin() && this.a.mSubPbModel.l0() != null) {
                                    NewSubPbActivity newSubPbActivity4 = this.a;
                                    newSubPbActivity4.markFloor(newSubPbActivity4.mSubPbModel.l0().i());
                                }
                            }
                        } else {
                            try {
                                sparseArray = (SparseArray) view.getTag();
                            } catch (ClassCastException e2) {
                                e2.printStackTrace();
                                sparseArray = null;
                            }
                            if (sparseArray == null || ((PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e69)) == null) {
                                return;
                            }
                            if (this.a.mPostMoreOptionView == null) {
                                this.a.mPostMoreOptionView = new c.a.p0.w2.m.f.j0(this.a.getPageContext(), this.a.mCommonClickListener);
                                this.a.mSubPbView.x0(this.a.mPostMoreOptionView.G());
                                this.a.mPostMoreOptionView.o(this.a.mIsLogin);
                            }
                            this.a.mPostMoreOptionView.m();
                            this.a.mPostMoreOptionView.p(sparseArray, this.a.getUserIdentity(), (this.a.isShowReportButton(sparseArray.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue() : false) && this.a.isLogin()) ? false : false, this.a.mSubPbModel.l0());
                        }
                    } else if (this.a.checkUpIsLogin()) {
                        this.a.mSubPbView.L0();
                        this.a.mSubPbView.u();
                        if (this.a.mEditor != null) {
                            this.a.mEditor.e0();
                        }
                    }
                } else if (this.a.checkUpIsLogin()) {
                    this.a.processProfessionPermission();
                    if (this.a.mSubPbModel == null || this.a.mSubPbModel.l0() == null || this.a.mSubPbModel.l0().l() == null || this.a.mSubPbModel.l0().l().getAuthor() == null) {
                        return;
                    }
                    TiebaStatic.log(new StatisticItem("c13402").param("tid", this.a.mSubPbModel.z0()).param("fid", this.a.mSubPbModel.l0().l().getFid()).param("obj_locate", 5).param("uid", this.a.mSubPbModel.l0().l().getAuthor().getUserId()));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m0 implements NewWriteModel.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* loaded from: classes5.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ m0 a;

            public b(m0 m0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {m0Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = m0Var;
            }

            @Override // c.a.o0.r.t.a.e
            public void onClick(c.a.o0.r.t.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                    aVar.dismiss();
                    this.a.a.sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.a.a.getActivity(), 0, 26, 2)));
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.g
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, c.a.o0.s.c.l0 l0Var, WriteData writeData, AntiData antiData) {
            ReplyPrivacyCheckController replyPrivacyCheckController;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, l0Var, writeData, antiData}) == null) {
                if (z && this.a.mEditor != null && this.a.mEditor.a() != null) {
                    this.a.mEditor.a().o();
                    if (this.a.mSubPbModel.J0()) {
                        TiebaStatic.log(new StatisticItem("c10367").param("post_id", this.a.mSubPbModel.A()));
                    }
                }
                if (z) {
                    this.a.mSensitiveProcessController.n(null);
                    this.a.mSensitiveProcessController.i(null);
                    this.a.mSensitiveProcessController.k(false);
                    if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                        c.a.o0.s.h.c.c(this.a.getPageContext(), postWriteCallBackData, 2);
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                    this.a.mSensitiveProcessController.i(postWriteCallBackData.getSensitiveWords());
                    this.a.mSensitiveProcessController.n(postWriteCallBackData.getErrorString());
                    if (ListUtils.isEmpty(this.a.mSensitiveProcessController.a())) {
                        return;
                    }
                    this.a.mPostWriteCallBackData = postWriteCallBackData;
                    if (this.a.mEditor.x()) {
                        this.a.mEditor.v(this.a.mPostWriteCallBackData);
                    }
                    this.a.checkContentSensitiveWord(true);
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                    if (c.a.d.f.p.m.isEmpty(postWriteCallBackData.getErrorString())) {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f045f), null).u();
                    } else {
                        DefaultNavigationBarCoverTip.s(this.a.getActivity(), postWriteCallBackData.getErrorString(), null).u();
                    }
                } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                    c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.a.getActivity());
                    if (c.a.d.f.p.m.isEmpty(postWriteCallBackData.getErrorString())) {
                        aVar.setMessage(this.a.getActivity().getString(R.string.obfuscated_res_0x7f0f0cc7));
                    } else {
                        aVar.setMessage(postWriteCallBackData.getErrorString());
                    }
                    aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new a(this));
                    aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f0cc9, new b(this));
                    aVar.create(this.a.getPageContext()).show();
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.WRITE_MORE_LINK_DIALOG_SHOW).param("obj_locate", 1).param("obj_type", 2));
                } else if (postWriteCallBackData != null && postWriteCallBackData.getErrorCode() == 238010 && (replyPrivacyCheckController = this.a.mReplyPrivacyController) != null) {
                    replyPrivacyCheckController.showAttentionDialog(postWriteCallBackData.getReplyPrivacyTip());
                }
                this.a.mSubPbView.m0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public n(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
                this.a.mSubPbView.g0();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                if (i == 2 || i == 1) {
                    this.a.mSubPbView.w();
                    if (this.a.lastScrollState != 2 && this.a.lastScrollState != 1) {
                        this.a.mSubPbView.U();
                    }
                }
                this.a.mEditor.y();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n0(NewSubPbActivity newSubPbActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.MESSAGE_ID_NEWSUB_PB) {
                this.a.mSubPbView.S();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    this.a.mToastMute.c(this.a.mCtx.getResources().getString(R.string.obfuscated_res_0x7f0f0b18));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = this.a.mCtx.getResources().getString(R.string.obfuscated_res_0x7f0f0b14);
                    }
                    this.a.showUserMuteAddDialog(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    this.a.showOpenMemberReplyDialog();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (c.a.d.f.p.m.isEmpty(errorString2)) {
                        errorString2 = this.a.mCtx.getResources().getString(R.string.obfuscated_res_0x7f0f0b15);
                    }
                    this.a.mToastMute.b(errorString2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public o(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        /* JADX WARN: Removed duplicated region for block: B:74:0x0181 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0182  */
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
            if (this.a.mSubPbView != null && this.a.mSubPbView.Z()) {
                return false;
            }
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null && this.a.isImage(view)) {
                if (view instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) view;
                    this.a.mSaveBdImage = tbImageView.getBdImage();
                    this.a.mSaveImageUrl = tbImageView.getUrl();
                    if (this.a.mSaveBdImage == null || TextUtils.isEmpty(this.a.mSaveImageUrl)) {
                        return true;
                    }
                    if (view.getTag(R.id.obfuscated_res_0x7f091e9f) == null || !(view.getTag(R.id.obfuscated_res_0x7f091e9f) instanceof TbRichTextImageInfo)) {
                        this.a.mEmotionInfo = null;
                    } else {
                        this.a.mEmotionInfo = (TbRichTextMemeInfo) view.getTag(R.id.obfuscated_res_0x7f091e9f);
                    }
                } else if (view instanceof GifView) {
                    GifView gifView = (GifView) view;
                    if (gifView.getBdImage() == null) {
                        return true;
                    }
                    this.a.mSaveBdImage = gifView.getBdImage();
                    if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                        this.a.mSaveImageUrl = gifView.getBdImage().q();
                    }
                    if (view.getTag(R.id.obfuscated_res_0x7f091e9f) == null || !(view.getTag(R.id.obfuscated_res_0x7f091e9f) instanceof TbRichTextImageInfo)) {
                        this.a.mEmotionInfo = null;
                    } else {
                        this.a.mEmotionInfo = (TbRichTextMemeInfo) view.getTag(R.id.obfuscated_res_0x7f091e9f);
                    }
                } else if (view instanceof TbMemeImageView) {
                    TbMemeImageView tbMemeImageView = (TbMemeImageView) view;
                    if (tbMemeImageView.getBdImage() != null) {
                        this.a.mSaveBdImage = tbMemeImageView.getBdImage();
                        if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                            this.a.mSaveImageUrl = tbMemeImageView.getBdImage().q();
                        }
                        if (view.getTag(R.id.obfuscated_res_0x7f091e9f) == null || !(view.getTag(R.id.obfuscated_res_0x7f091e9f) instanceof TbRichTextImageInfo)) {
                            this.a.mEmotionInfo = null;
                        } else {
                            this.a.mEmotionInfo = (TbRichTextMemeInfo) view.getTag(R.id.obfuscated_res_0x7f091e9f);
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
                    this.a.mSubPbView.F0(this.a.mOnImageSaveClickListener, this.a.mSaveBdImage.t());
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
                this.a.postData = (PostData) sparseArray2.get(R.id.obfuscated_res_0x7f091e69);
                NewSubPbActivity newSubPbActivity = this.a;
                if (newSubPbActivity.postData == null || newSubPbActivity.mMarkModel == null) {
                    return true;
                }
                if (this.a.mMarkModel != null) {
                    this.a.mMarkModel.h(this.a.mSubPbModel.N0());
                }
                boolean z = this.a.mMarkModel.e() && this.a.postData.G() != null && this.a.postData.G().equals(this.a.mSubPbModel.u0());
                if (this.a.mPostMoreOptionView == null) {
                    this.a.mPostMoreOptionView = new c.a.p0.w2.m.f.j0(this.a.getPageContext(), this.a.mCommonClickListener);
                    this.a.mSubPbView.x0(this.a.mPostMoreOptionView.G());
                    this.a.mPostMoreOptionView.o(this.a.mIsLogin);
                }
                this.a.mPostMoreOptionView.m();
                boolean z2 = this.a.isShowReportButton(sparseArray2.get(R.id.obfuscated_res_0x7f091e6c) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue() : false) && this.a.isLogin();
                boolean z3 = (this.a.mSubPbModel.l0() == null || this.a.mSubPbModel.l0().l() == null || !this.a.mSubPbModel.l0().l().isBjh()) ? false : true;
                boolean booleanValue = sparseArray2.get(R.id.obfuscated_res_0x7f091e82) instanceof Boolean ? ((Boolean) sparseArray2.get(R.id.obfuscated_res_0x7f091e82)).booleanValue() : false;
                if (z) {
                    this.a.mPostMoreOptionView.A().setText(R.string.obfuscated_res_0x7f0f0f80);
                } else {
                    this.a.mPostMoreOptionView.A().setText(R.string.obfuscated_res_0x7f0f0a7f);
                }
                if (booleanValue || z3) {
                    this.a.mPostMoreOptionView.A().setVisibility(8);
                } else {
                    this.a.mPostMoreOptionView.A().setVisibility(0);
                }
                if (this.a.isImage(view)) {
                    if (this.a.mSaveBdImage != null && !this.a.mSaveBdImage.t()) {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091ea4, Boolean.TRUE);
                    } else {
                        sparseArray2.put(R.id.obfuscated_res_0x7f091ea4, Boolean.FALSE);
                    }
                    sparseArray2.put(R.id.obfuscated_res_0x7f091ea3, Boolean.TRUE);
                } else {
                    sparseArray2.put(R.id.obfuscated_res_0x7f091ea4, Boolean.FALSE);
                    sparseArray2.put(R.id.obfuscated_res_0x7f091ea3, Boolean.FALSE);
                }
                c.a.p0.w2.i.u l0 = this.a.mSubPbModel.l0();
                this.a.mPostMoreOptionView.k(c.a.p0.w2.m.f.n1.a.f(this.a.postData));
                this.a.mPostMoreOptionView.q(sparseArray2, this.a.getUserIdentity(), z2, this.a.showTrisectionAndFeedback && this.a.postData.l0, l0);
                return true;
            }
            sparseArray2 = sparseArray;
            if (sparseArray2 != null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o0(NewSubPbActivity newSubPbActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == this.a.MESSAGE_ID_NEWSUB_PB) {
                this.a.mSubPbView.S();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    this.a.mToastMute.c(this.a.mCtx.getResources().getString(R.string.obfuscated_res_0x7f0f1462));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (c.a.d.f.p.m.isEmpty(muteMessage)) {
                    muteMessage = this.a.mCtx.getResources().getString(R.string.obfuscated_res_0x7f0f1461);
                }
                this.a.mToastMute.b(muteMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements TbRichTextView.y {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public p(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX DEBUG: Multi-variable search result rejected for r6v8, resolved type: com.baidu.tbadk.core.atomData.ImageViewerConfig$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.y
        public void a(View view, String str, int i, boolean z, boolean z2) {
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
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                try {
                    if (view.getTag(R.id.obfuscated_res_0x7f091e9f) == null || !(view.getTag(R.id.obfuscated_res_0x7f091e9f) instanceof TbRichTextMemeInfo) || !(view instanceof TbImageView)) {
                        c.a.p0.w2.i.u l0 = this.a.mSubPbModel.l0();
                        TbRichText validImage = this.a.validImage(str, i);
                        TbRichTextData tbRichTextData = (validImage == null || validImage.A() == null) ? null : validImage.A().get(this.a.imgIndex);
                        if (tbRichTextData == null) {
                            return;
                        }
                        ArrayList<String> arrayList = new ArrayList<>();
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        if (!tbRichTextData.E().F()) {
                            String encodeImageUrl = this.a.encodeImageUrl(tbRichTextData);
                            arrayList.add(encodeImageUrl);
                            ImageUrlData imageUrlData = new ImageUrlData();
                            imageUrlData.imageUrl = str;
                            imageUrlData.urlType = this.a.mIsFromCDN ? 17 : 18;
                            concurrentHashMap.put(encodeImageUrl, imageUrlData);
                            if (l0 != null) {
                                if (l0.d() != null) {
                                    str6 = l0.d().getName();
                                    str7 = l0.d().getId();
                                } else {
                                    str6 = null;
                                    str7 = null;
                                }
                                str8 = l0.l() != null ? l0.l().getId() : null;
                                z4 = true;
                            } else {
                                z4 = false;
                                str6 = null;
                                str7 = null;
                                str8 = null;
                            }
                            if (this.a.mSubPbModel.C0() != null) {
                                concurrentHashMap = this.a.mSubPbModel.C0();
                                z4 = this.a.mSubPbModel.G0();
                                arrayList = this.a.mSubPbModel.B0();
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
                            bVar.N(this.a.getThreadData());
                            bVar.L(String.valueOf(validImage.getPostId()));
                            bVar.A(this.a.mSubPbModel.getFromForumId());
                            this.a.sendMessage(new CustomMessage(2010000, bVar.v(this.a.getPageContext().getPageActivity())));
                            return;
                        }
                        this.a.index_valid = false;
                        TbRichText N = l0.i().N();
                        int size = arrayList.size();
                        int imageIndex = this.a.getImageIndex(N, validImage, i, i, arrayList, concurrentHashMap);
                        int size2 = arrayList.size();
                        String str9 = size != size2 ? arrayList.get(size2 - 1) : "";
                        if (l0 != null) {
                            if (l0.d() != null) {
                                str5 = l0.d().getName();
                                str3 = l0.d().getId();
                            } else {
                                str5 = null;
                                str3 = null;
                            }
                            str2 = l0.l() != null ? l0.l().getId() : null;
                            z3 = true;
                            str4 = str5;
                        } else {
                            str2 = null;
                            str3 = null;
                            z3 = false;
                            str4 = null;
                        }
                        if (this.a.mSubPbModel.C0() != null) {
                            concurrentHashMap = this.a.mSubPbModel.C0();
                            z3 = this.a.mSubPbModel.G0();
                            arrayList = this.a.mSubPbModel.B0();
                            imageIndex += this.a.mSubPbModel.v0();
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
                        bVar2.N(this.a.getThreadData());
                        bVar2.L(String.valueOf(validImage.getPostId()));
                        bVar2.A(this.a.mSubPbModel.getFromForumId());
                        this.a.sendMessage(new CustomMessage(2010000, bVar2.v(this.a.getPageContext().getPageActivity())));
                        return;
                    }
                    TbRichTextMemeInfo tbRichTextMemeInfo = (TbRichTextMemeInfo) view.getTag(R.id.obfuscated_res_0x7f091e9f);
                    boolean w = ((TbImageView) view).w();
                    if (tbRichTextMemeInfo == null || tbRichTextMemeInfo.memeInfo == null) {
                        return;
                    }
                    this.a.sendMessage(new CustomMessage(2002001, new EmotionDetailActivityConfig(this.a.getPageContext().getPageActivity(), tbRichTextMemeInfo.memeInfo.pck_id.intValue(), tbRichTextMemeInfo.memeInfo.pic_id.longValue(), 25033, w)));
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p0 extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p0(NewSubPbActivity newSubPbActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof c.a.p0.k4.a) && customResponsedMessage.getOrginalMessage().getTag() == this.a.MESSAGE_ID_NEWSUB_PB) {
                c.a.p0.k4.a aVar = (c.a.p0.k4.a) customResponsedMessage.getData();
                this.a.mSubPbView.S();
                SparseArray<Object> sparseArray = (SparseArray) this.a.mExtra;
                DataRes dataRes = aVar.a;
                if (aVar.f15970c == 0 && dataRes != null) {
                    z = c.a.d.f.m.b.e(dataRes.is_mute, 0) == 1;
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebe, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091eb8, dataRes.mute_confirm);
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091ebe, Boolean.FALSE);
                    z = false;
                }
                int intValue = sparseArray.get(R.id.obfuscated_res_0x7f091e7c) instanceof Integer ? ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e7c)).intValue() : 0;
                if (intValue == 0) {
                    this.a.showOperateDialog(z, sparseArray);
                } else if (intValue == 1) {
                    this.a.mSubPbView.i0(sparseArray, z);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements c.InterfaceC0843c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public q(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // c.a.o0.r.t.c.InterfaceC0843c
        public void a(c.a.o0.r.t.c cVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cVar, i, view) == null) {
                cVar.e();
                if (this.a.mSaveBdImage == null || TextUtils.isEmpty(this.a.mSaveImageUrl)) {
                    return;
                }
                if (i == 0) {
                    if (this.a.mEmotionInfo == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.a.mSaveImageUrl));
                    } else {
                        d.a aVar = new d.a();
                        aVar.a = this.a.mSaveImageUrl;
                        String str = "";
                        if (this.a.mEmotionInfo.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.a.mEmotionInfo.memeInfo.pck_id;
                        }
                        aVar.f9865b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i == 1) {
                    if (this.a.mPermissionJudgement == null) {
                        this.a.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    this.a.mPermissionJudgement.clearRequestPermissionList();
                    this.a.mPermissionJudgement.appendRequestPermission(this.a.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (this.a.mPermissionJudgement.startRequestPermission(this.a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.a.mSaveImageHelper == null) {
                        NewSubPbActivity newSubPbActivity = this.a;
                        newSubPbActivity.mSaveImageHelper = new e1(newSubPbActivity.getPageContext());
                    }
                    this.a.mSaveImageHelper.b(this.a.mSaveImageUrl, this.a.mSaveBdImage.n());
                }
                this.a.mSaveBdImage = null;
                this.a.mSaveImageUrl = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q0 implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public q0(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // c.a.o0.r.l0.f.g
        public void onListPullRefresh(boolean z) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZ(1048576, this, z) == null) || this.a.mSubPbModel == null) {
                return;
            }
            this.a.mSubPbModel.S0();
        }
    }

    /* loaded from: classes5.dex */
    public class r implements c.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public r(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // c.a.p0.f1.i2.a.c.d
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00ce  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00d8  */
        @Override // c.a.p0.f1.i2.a.c.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(boolean z) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) != null) || !z) {
                return;
            }
            NewSubPbActivity newSubPbActivity = this.a;
            if (newSubPbActivity.mReplyPrivacyController != null && newSubPbActivity.mSubPbModel != null && this.a.mSubPbModel.j0() != null && !this.a.isHost(TbadkCoreApplication.getCurrentAccount())) {
                NewSubPbActivity newSubPbActivity2 = this.a;
                if (!newSubPbActivity2.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(newSubPbActivity2.mSubPbModel.j0().replyPrivateFlag)) {
                    return;
                }
            }
            if (this.a.mSubPbModel != null && this.a.mSubPbModel.l0() != null && this.a.mSubPbModel.l0().i() != null) {
                PostData i = this.a.mSubPbModel.l0().i();
                if (i.N() != null && i.s() != null) {
                    str = String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f98), i.s().getName_show(), i.N().toString());
                    this.a.mEditor.a().A(new c.a.o0.w.a(45, 27, str));
                    if (!this.a.mEditor.x()) {
                        this.a.mEditor.v(null);
                        return;
                    }
                    this.a.mSubPbView.L0();
                    this.a.mSubPbView.u();
                    if (this.a.mEditor != null) {
                        this.a.mEditor.i0();
                        return;
                    }
                    return;
                }
            }
            str = null;
            this.a.mEditor.a().A(new c.a.o0.w.a(45, 27, str));
            if (!this.a.mEditor.x()) {
            }
        }

        @Override // c.a.p0.f1.i2.a.c.d
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface r0 {
        void a(Object obj);
    }

    /* loaded from: classes5.dex */
    public class s implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public s(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, editable) == null) || this.a.mSensitiveProcessController == null) {
                return;
            }
            if (!this.a.mSensitiveProcessController.e()) {
                this.a.checkContentSensitiveWord(false);
            }
            this.a.mSensitiveProcessController.l(false);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements c.InterfaceC0843c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SparseArray a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ boolean f35109b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f35110c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ NewSubPbActivity f35111d;

        public t(NewSubPbActivity newSubPbActivity, SparseArray sparseArray, boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, sparseArray, Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35111d = newSubPbActivity;
            this.a = sparseArray;
            this.f35109b = z;
            this.f35110c = str;
        }

        @Override // c.a.o0.r.t.c.InterfaceC0843c
        public void a(c.a.o0.r.t.c cVar, int i, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, cVar, i, view) == null) {
                if (i == 0) {
                    String str = this.a.get(R.id.obfuscated_res_0x7f091ebb) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f091ebb) : "";
                    String str2 = this.a.get(R.id.obfuscated_res_0x7f091ebd) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f091ebd) : "";
                    String str3 = this.a.get(R.id.obfuscated_res_0x7f091ebc) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f091ebc) : "";
                    String str4 = this.a.get(R.id.obfuscated_res_0x7f091eb8) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f091eb8) : "";
                    String str5 = this.a.get(R.id.obfuscated_res_0x7f091eb9) instanceof String ? (String) this.a.get(R.id.obfuscated_res_0x7f091eb9) : "";
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.f35109b, this.f35110c, str, str2, str3, 1, str4, this.f35111d.MESSAGE_ID_NEWSUB_PB);
                    userMuteAddAndDelCustomMessage.setTag(this.f35111d.MESSAGE_ID_NEWSUB_PB);
                    this.f35111d.showUserMuteDialog(this.f35109b, userMuteAddAndDelCustomMessage, str4, str, str5);
                }
                cVar.e();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class u extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(NewSubPbActivity newSubPbActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                c.a.o0.e1.n.f.b(this.a.getPageContext(), aVar.a, aVar.f10185b, aVar.f10186c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class v implements TiePlusEventController.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public v(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        @Override // com.baidu.tbadk.widget.tiejia.TiePlusEventController.f
        public void call() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.mIsRichTextListenerAcked = true;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class w implements c.a.d.f.k.c<GifView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public w(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ GifView a(GifView gifView) {
            GifView gifView2 = gifView;
            e(gifView2);
            return gifView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(GifView gifView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, gifView) == null) {
                gifView.Y();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public GifView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new GifView(this.a.getPageContext().getPageActivity()) : (GifView) invokeV.objValue;
        }

        public GifView h(GifView gifView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, gifView)) == null) ? gifView : (GifView) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class x implements c.a.d.f.k.c<ImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public x(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ ImageView a(ImageView imageView) {
            ImageView imageView2 = imageView;
            e(imageView2);
            return imageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
                    if (c.a.o0.r.l.c().g()) {
                        tbImageView.setAdjustViewBounds(false);
                        tbImageView.setInterceptOnClick(false);
                    } else {
                        tbImageView.setDefaultResource(R.drawable.icon_click);
                        tbImageView.setAdjustViewBounds(true);
                        tbImageView.setInterceptOnClick(true);
                    }
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
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
                    foreDrawableImageView.N();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public ImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(this.a.getPageContext().getPageActivity());
                boolean g2 = c.a.o0.r.l.c().g();
                foreDrawableImageView.setDefaultBg(SkinManager.getDrawable(R.color.common_color_10220));
                if (g2) {
                    foreDrawableImageView.setAdjustViewBounds(false);
                    foreDrawableImageView.setInterceptOnClick(false);
                } else {
                    foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
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
                    foreDrawableImageView.N();
                    foreDrawableImageView.setForegroundDrawable(0);
                    foreDrawableImageView.setDefaultBgResource(R.color.CAM_X0204);
                }
                return imageView;
            }
            return (ImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class y implements c.a.d.f.k.c<View> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public y(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ View a(View view) {
            View view2 = view;
            e(view2);
            return view2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
                ((PlayVoiceBntNew) view).n();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(this.a.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                playVoiceBntNew.setVoiceManager(this.a.getVoiceManager());
                playVoiceBntNew.setPlayTimeTextView(R.dimen.obfuscated_res_0x7f0702b5);
                return playVoiceBntNew;
            }
            return (View) invokeV.objValue;
        }

        public View h(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
                ((PlayVoiceBntNew) view).n();
                return view;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class z implements c.a.d.f.k.c<LinearLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NewSubPbActivity a;

        public z(NewSubPbActivity newSubPbActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newSubPbActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = newSubPbActivity;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ LinearLayout a(LinearLayout linearLayout) {
            LinearLayout linearLayout2 = linearLayout;
            e(linearLayout2);
            return linearLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, linearLayout) == null) {
                linearLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public LinearLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                LinearLayout linearLayout = new LinearLayout(this.a.getPageContext().getPageActivity());
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
        this.showTrisectionAndFeedback = UbsABTestHelper.showTrisectionAndFeedback();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65604, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null) {
                return false;
            }
            return AntiHelper.d(getPageContext(), subPbModel.j0());
        }
        return invokeV.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void clickOnDisagree(AgreeData agreeData) {
        c.a.o0.n0.c currentVisiblePageExtra;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65605, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.mMessageHelper == null) {
            this.mMessageHelper = new c.a.o0.r.g0.a();
        }
        if (this.mMsgData == null) {
            c.a.p0.a4.k0.e eVar = new c.a.p0.a4.k0.e();
            this.mMsgData = eVar;
            eVar.a = this.mOnlyDisagreeId;
        }
        c.a.o0.r.r.f fVar = new c.a.o0.r.r.f();
        fVar.f10852b = 12;
        fVar.f10858h = 9;
        fVar.f10857g = 3;
        if (getSubPbModel() != null) {
            fVar.f10856f = getSubPbModel().w0();
        }
        fVar.a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.i = 0;
                currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getActivity());
                if (currentVisiblePageExtra != null) {
                    agreeData.objSource = currentVisiblePageExtra.a();
                }
                this.mMessageHelper.c(agreeData, i2, getUniqueId(), false);
                this.mMessageHelper.d(agreeData, this.mMsgData);
                if (getSubPbModel() != null || getSubPbModel().l0() == null) {
                }
                this.mMessageHelper.b(this, fVar, agreeData, getSubPbModel().l0().l());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.i = 1;
        }
        i2 = 0;
        currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(getActivity());
        if (currentVisiblePageExtra != null) {
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
        if (!(interceptable == null || interceptable.invokeL(65606, this, view) == null) || view == null || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        boolean booleanValue = sparseArray.get(R.id.obfuscated_res_0x7f091eab) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091eab)).booleanValue() : false;
        boolean booleanValue2 = sparseArray.get(R.id.obfuscated_res_0x7f091ea9) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ea9)).booleanValue() : false;
        boolean booleanValue3 = sparseArray.get(R.id.obfuscated_res_0x7f091ebe) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue() : false;
        if (booleanValue) {
            if (booleanValue3) {
                sparseArray.put(R.id.obfuscated_res_0x7f091e7c, 1);
                checkMuteState(sparseArray);
            } else {
                this.mSubPbView.j0(view);
            }
        } else if (booleanValue2) {
            this.mSubPbView.h0(((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e6d)).intValue(), (String) sparseArray.get(R.id.obfuscated_res_0x7f091e6b), ((Integer) sparseArray.get(R.id.obfuscated_res_0x7f091e88)).intValue(), ((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091e6c)).booleanValue(), false);
        }
        c.a.d.f.m.g.d(this.mSubPbView.N(), getPageContext().getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String encodeImageUrl(TbRichTextData tbRichTextData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65607, this, tbRichTextData)) == null) {
            if (tbRichTextData == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder(150);
            TbRichTextImageInfo E = tbRichTextData.E();
            if (E != null) {
                if (!StringUtils.isNull(E.y())) {
                    return E.y();
                }
                if (E.getHeight() * E.getWidth() > TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) {
                    double sqrt = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / (E.getHeight() * E.getWidth()));
                    sb.append(BigImageLoaderProc.NCDN_PER);
                    sb.append(String.valueOf((int) (E.getWidth() * sqrt)));
                    sb.append("&height=");
                    sb.append(String.valueOf((int) (E.getHeight() * sqrt)));
                } else {
                    double width = E.getWidth() / E.getHeight();
                    double sqrt2 = Math.sqrt((TbConfig.getThreadImageMaxWidth() * TbConfig.getThreadImageMaxWidth()) / width);
                    sb.append(BigImageLoaderProc.NCDN_PER);
                    sb.append(String.valueOf((int) (width * sqrt2)));
                    sb.append("&height=");
                    sb.append(String.valueOf((int) sqrt2));
                }
                sb.append("&src=");
                sb.append(c.a.d.f.p.m.getUrlEncode(E.D()));
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
        if (interceptable == null || interceptable.invokeZ(65608, this, z2) == null) {
            Rect rect = new Rect();
            FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
            if (frameLayout != null && (childAt = frameLayout.getChildAt(0)) != null) {
                frameLayout.getWindowVisibleDisplayFrame(rect);
                if (z2) {
                    ((FrameLayout.LayoutParams) childAt.getLayoutParams()).height = rect.height();
                    childAt.requestLayout();
                }
            }
            c.a.p0.w2.m.h.a aVar = this.mSubPbView;
            if (aVar == null || aVar.H() == null || (pbCommenFloorItemViewHolder = this.mItemClickShowSoftKeyBoardViewHolder) == null || (i2 = pbCommenFloorItemViewHolder.X) == -1) {
                return;
            }
            int headerViewsCount = i2 + this.mSubPbView.H().getHeaderViewsCount();
            if (this.mItemClickShowSoftKeyBoardViewHolder.b() != null) {
                int height = this.mItemClickShowSoftKeyBoardViewHolder.b().getHeight();
                int height2 = ((rect.height() - this.mSubPbView.A()) - this.mSubPbView.J()) - this.mSubPbView.C();
                int i3 = height - height2;
                if (i3 > 0) {
                    this.mSubPbView.H().post(new j0(this, headerViewsCount, i3));
                } else {
                    this.mSubPbView.H().post(new k0(this, headerViewsCount, height2, height));
                }
            }
        }
    }

    private TbRichText getImage(PostData postData, String str, int i2) {
        InterceptResult invokeLLI;
        TbRichText N;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65609, this, postData, str, i2)) == null) {
            if (postData != null && (N = postData.N()) != null) {
                ArrayList<TbRichTextData> A = N.A();
                int size = A.size();
                int i3 = -1;
                for (int i4 = 0; i4 < size; i4++) {
                    if (A.get(i4) != null && A.get(i4).getType() == 8) {
                        i3++;
                        if (A.get(i4).E().A().equals(str)) {
                            int h2 = (int) c.a.d.f.p.n.h(TbadkCoreApplication.getInst());
                            int width = A.get(i4).E().getWidth() * h2;
                            int height = A.get(i4).E().getHeight() * h2;
                            if (width < 80 || height < 80 || width * height < 10000) {
                                return null;
                            }
                            this.imgIndex = i4;
                            return N;
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
        TbRichTextImageInfo E;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65610, this, new Object[]{tbRichText, tbRichText2, Integer.valueOf(i2), Integer.valueOf(i3), arrayList, concurrentHashMap})) == null) {
            if (tbRichText == tbRichText2) {
                this.index_valid = true;
            }
            if (tbRichText != null && tbRichText.A() != null) {
                int size = tbRichText.A().size();
                int i4 = -1;
                for (int i5 = 0; i5 < size; i5++) {
                    if (tbRichText.A().get(i5) != null && tbRichText.A().get(i5).getType() == 8) {
                        i4++;
                        int h2 = (int) c.a.d.f.p.n.h(TbadkCoreApplication.getInst());
                        int width = tbRichText.A().get(i5).E().getWidth() * h2;
                        int height = tbRichText.A().get(i5).E().getHeight() * h2;
                        if (!(width < 80 || height < 80 || width * height < 10000) && tbRichText.A().get(i5).E().F()) {
                            TbRichTextData tbRichTextData = tbRichText.A().get(i5);
                            String encodeImageUrl = encodeImageUrl(tbRichTextData);
                            arrayList.add(encodeImageUrl);
                            if (!TextUtils.isEmpty(encodeImageUrl) && tbRichTextData != null && (E = tbRichTextData.E()) != null) {
                                String A = E.A();
                                ImageUrlData imageUrlData = new ImageUrlData();
                                imageUrlData.imageUrl = A;
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
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65611, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || subPbModel.l0() == null) {
                return null;
            }
            return this.mSubPbModel.l0().l();
        }
        return (ThreadData) invokeV.objValue;
    }

    private void handleFullScreenEditorResult(int i2, Intent intent) {
        c.a.o0.w.n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65612, this, i2, intent) == null) {
            this.mEditor.a().q();
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
                c.a.o0.w.m n2 = this.mEditor.a().n(6);
                if (n2 != null && (nVar = n2.k) != null) {
                    nVar.onAction(new c.a.o0.w.a(52, 0, pbEditorData.getVoiceModel()));
                }
                if (i2 == -1) {
                    this.mEditor.F();
                }
                this.mSubPbView.U();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initEditor(boolean z2) {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65613, this, z2) == null) {
            c.a.o0.w.y.h hVar = (c.a.o0.w.y.h) new c.a.o0.w.y.i(z2).a(getActivity());
            this.mEditor = hVar;
            if (hVar != null) {
                hVar.N(getPageContext());
                this.mEditor.a0(this.mSubPbModel);
                this.mEditor.Q(this.mOnPostWriteNewCallback);
                this.mEditor.O(2);
                this.mEditor.U(this.mPrePostCallBack);
                this.mEditor.M(this.mCheckPostCallBack);
                this.mEditor.a().C(true);
                this.mEditor.z(getPageContext());
                this.mEditor.P(this.mFromVideoTab);
            }
            c.a.p0.w2.m.h.a aVar = this.mSubPbView;
            if (aVar != null) {
                aVar.Y(this.mEditor);
            }
            c.a.o0.w.y.h hVar2 = this.mEditor;
            if (hVar2 != null && (subPbModel = this.mSubPbModel) != null) {
                hVar2.G(subPbModel.j0());
                this.mEditor.y();
            }
            c.a.o0.w.y.h hVar3 = this.mEditor;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65614, this, bundle)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65615, this, bundle)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65616, this, bundle)) == null) {
            if (bundle != null) {
                this.isFromVideoMiddle = bundle.getBoolean("is_jump_from_video_middle");
            } else {
                this.isFromVideoMiddle = getIntent().getBooleanExtra("is_jump_from_video_middle", false);
            }
            return this.isFromVideoMiddle;
        }
        return invokeL.booleanValue;
    }

    private boolean initIsFromVideoTab(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65617, this, bundle)) == null) {
            if (bundle != null) {
                this.mIsFromVideoTAb = bundle.getBoolean("is_jump_from_video_tab", false);
                this.mFromVideoTab = bundle.getInt(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD);
            } else {
                Intent intent = getIntent();
                this.mIsFromVideoTAb = intent.getBooleanExtra("is_jump_from_video_tab", false);
                this.mFromVideoTab = intent.getIntExtra(SubPbActivityConfig.KEY_IS_JUMP_FROM_VIDEO_TAB_CHILD, 0);
            }
            return this.mIsFromVideoTAb;
        }
        return invokeL.booleanValue;
    }

    private int initIsFromVideoTabChild(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65618, this, bundle)) == null) {
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
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65619, this, z2)) == null) {
            if (this.mSubPbModel == null) {
                return false;
            }
            return ((getUserIdentity() != 0) || this.mSubPbModel.l0() == null || this.mSubPbModel.l0().l() == null || this.mSubPbModel.l0().l().getAuthor() == null || this.mSubPbModel.l0().l().isUgcThreadType() || TextUtils.equals(this.mSubPbModel.l0().l().getAuthor().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z2) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    private void jumpToWeb(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65620, this, str) == null) {
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
        if (interceptable == null || interceptable.invokeL(65621, this, view) == null) {
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e69)) == null) {
                return;
            }
            markFloor(postData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void navigateToBubbleWebView(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65622, this, str) == null) && !StringUtils.isNull(str) && ViewHelper.checkUpIsLogin(getPageContext().getPageActivity())) {
            String q2 = c.a.o0.r.j0.b.k().q("bubble_link", "");
            if (StringUtils.isNull(q2)) {
                return;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return;
            }
            c.a.o0.l.a.q(getPageContext().getPageActivity(), getResources().getString(R.string.obfuscated_res_0x7f0f0521), q2 + "?props_id=" + str, true, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNetOrDataError(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65623, this, i2, str) == null) {
            if (this.mSubPbModel.F0()) {
                showToast(str);
            } else if (!c.a.d.f.p.n.C()) {
                this.mSubPbView.D0(R.string.obfuscated_res_0x7f0f0f57);
            } else if (i2 == 4) {
                c.a.p0.w2.m.h.a aVar = this.mSubPbView;
                aVar.E0(str + "(4" + SmallTailInfo.EMOTION_SUFFIX, true);
            } else if (!TextUtils.isEmpty(str)) {
                c.a.p0.w2.m.h.a aVar2 = this.mSubPbView;
                aVar2.E0(str + "(" + i2 + SmallTailInfo.EMOTION_SUFFIX, true);
            } else {
                this.mSubPbView.D0(R.string.obfuscated_res_0x7f0f0c2d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openEditor(SparseArray<Object> sparseArray, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65624, this, sparseArray, z2) == null) || sparseArray == null) {
            return;
        }
        if (sparseArray.get(R.id.obfuscated_res_0x7f091e69) instanceof PostData) {
            openEditor((PostData) sparseArray.get(R.id.obfuscated_res_0x7f091e69), z2);
        } else {
            openEditor((PostData) null, z2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processProfessionPermission() {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65626, this) == null) {
            Intent intent = getIntent();
            boolean booleanExtra = intent != null ? intent.getBooleanExtra("key_is_from_dynamic", false) : false;
            if (checkIsIfPostForbid()) {
                return;
            }
            if (booleanExtra) {
                if (this.mReplyPrivacyController == null || (subPbModel = this.mSubPbModel) == null || subPbModel.j0() == null || isHost(TbadkCoreApplication.getCurrentAccount()) || this.mReplyPrivacyController.checkPrivacyBeforeInvokeEditor(this.mSubPbModel.j0().replyPrivateFlag)) {
                    if (this.mEditor.x()) {
                        this.mEditor.v(null);
                        return;
                    }
                    this.mSubPbView.L0();
                    this.mSubPbView.u();
                    c.a.o0.w.y.h hVar = this.mEditor;
                    if (hVar != null) {
                        hVar.i0();
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.mProfessionController == null) {
                c.a.p0.f1.i2.a.c cVar = new c.a.p0.f1.i2.a.c(getPageContext());
                this.mProfessionController = cVar;
                cVar.i(new r(this));
            }
            SubPbModel subPbModel2 = this.mSubPbModel;
            if (subPbModel2 == null || subPbModel2.l0() == null || this.mSubPbModel.l0().d() == null) {
                return;
            }
            this.mProfessionController.g(this.mSubPbModel.l0().d().getId(), c.a.d.f.m.b.g(this.mSubPbModel.z0(), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDelNoSubPostDialog(SparseArray<Object> sparseArray, int i2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65627, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z2)}) == null) {
            c.a.p0.w2.m.f.n1.a.d(this, getPageContext(), new j(this, sparseArray, i2, z2), new l(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDeleteResumeEditorTips(View view, c.a.o0.w.y.h hVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65628, this, view, hVar, str) == null) {
            new WriteTipBubbleController(getPageContext(), new d(this, view, hVar)).d(view, getString(R.string.obfuscated_res_0x7f0f0cc4), str, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_PB_REPLY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOpenMemberReplyDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65629, this) == null) {
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getPageContext().getPageActivity());
            aVar.setMessage(getResources().getString(R.string.obfuscated_res_0x7f0f0b16));
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f0cc9, new f0(this));
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new h0(this));
            aVar.create(this.mCtx).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOperateDialog(boolean z2, SparseArray<Object> sparseArray) {
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65630, this, z2, sparseArray) == null) {
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091eba) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091eba) : "";
            if (((Boolean) sparseArray.get(R.id.obfuscated_res_0x7f091ebe)).booleanValue()) {
                String[] strArr = new String[1];
                if (z2) {
                    string = getResources().getString(R.string.obfuscated_res_0x7f0f1460);
                } else {
                    string = getResources().getString(R.string.obfuscated_res_0x7f0f0b13);
                }
                strArr[0] = string;
                c.a.o0.r.t.c cVar = new c.a.o0.r.t.c(getPageContext().getPageActivity());
                cVar.k(R.string.obfuscated_res_0x7f0f0cd8);
                cVar.j(strArr, new t(this, sparseArray, z2, str));
                cVar.c(getPageContext());
                cVar.m();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUserMuteAddDialog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65631, this, str) == null) {
            if (str == null) {
                str = "";
            }
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.mCtx.getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f0984, new e0(this));
            aVar.create(this.mCtx).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showUserMuteDialog(boolean z2, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65632, this, new Object[]{Boolean.valueOf(z2), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z2) {
                this.mSubPbView.B0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(this.mCtx.getPageActivity());
            if (c.a.d.f.p.m.isEmpty(str)) {
                aVar.setMessage(this.mCtx.getResources().getString(R.string.obfuscated_res_0x7f0f030f, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(R.string.obfuscated_res_0x7f0f041a, new c0(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new d0(this));
            aVar.create(this.mCtx).show();
        }
    }

    private void startBrowsePageMission() {
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65633, this) == null) || (subPbModel = this.mSubPbModel) == null || c.a.d.f.p.m.isEmpty(subPbModel.z0())) {
            return;
        }
        c.a.o0.a.d.y().R(c.a.o0.a.c.X, c.a.d.f.m.b.g(this.mSubPbModel.z0(), 0L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TbRichText validImage(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65634, this, str, i2)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || subPbModel.l0() == null || str == null || i2 < 0) {
                return null;
            }
            c.a.p0.w2.i.u l02 = this.mSubPbModel.l0();
            TbRichText image = getImage(l02.i(), str, i2);
            if (image != null || (image = getImage(l02.i(), str, i2)) != null) {
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
            c.a.p0.s4.c cVar = this.mSensitiveProcessController;
            cVar.k(cVar.b() >= 0);
        }
    }

    public void checkMuteState(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            String str = sparseArray.get(R.id.obfuscated_res_0x7f091eba) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091eba) : "";
            this.mSubPbView.B0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = c.a.d.f.m.b.g(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = c.a.d.f.m.b.g(str, 0L);
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
            } else if (StringUtils.isNull(this.mSubPbModel.x0())) {
            } else {
                if (this.mSubPbView.J0() && c.a.d.f.p.n.C()) {
                    this.mSubPbView.q0();
                } else {
                    this.mSubPbView.m0();
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
        this.mSubPbView.z(0, bVar.a, bVar.f36156b, z2);
        if (bVar.a) {
            int i3 = bVar.f36158d;
            if (i3 == 1) {
                if (this.mSubPbView.H() instanceof BdTypeListView) {
                    List<c.a.d.o.e.n> data = ((BdTypeListView) this.mSubPbView.H()).getData();
                    if (!ListUtils.isEmpty(data)) {
                        while (i2 < data.size() && (!(data.get(i2) instanceof PostData) || !bVar.f36161g.equals(((PostData) data.get(i2)).G()))) {
                            i2++;
                        }
                        if (i2 < data.size()) {
                            data.remove(i2);
                        }
                        this.mSubPbView.b0();
                    }
                }
            } else if (i3 == 2) {
                this.mSubPbModel.h0(bVar.f36161g);
                this.mSubPbView.I0(this.mSubPbModel.l0(), this.mSubPbModel.D0(), this.mSubPbModel.C0() != null, false);
                if (this.mSubPbModel.O0()) {
                    this.mSubPbModel.a1(false);
                    this.mSubPbView.s();
                    this.mSubPbModel.loadData();
                }
            }
            c.a.p0.w2.f fVar = new c.a.p0.w2.f();
            fVar.b(bVar);
            fVar.c(1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004007, fVar));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, c.a.o0.p0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "a007" : (String) invokeV.objValue;
    }

    @Override // c.a.p0.w2.m.a
    public c.a.p0.w2.m.f.k1.a getEventController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mEvent : (c.a.p0.w2.m.f.k1.a) invokeV.objValue;
    }

    @Override // c.a.p0.w2.m.a
    public String getFromForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || subPbModel.l0() == null || this.mSubPbModel.l0().l() == null) {
                return null;
            }
            return this.mSubPbModel.l0().l().getForum_name();
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.mGifViewPool == null) {
                this.mGifViewPool = new c.a.d.f.k.b<>(new w(this), 20, 0);
            }
            return this.mGifViewPool;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.mImageViewPool == null) {
                this.mImageViewPool = new c.a.d.f.k.b<>(new x(this), 8, 0);
            }
            return this.mImageViewPool;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            c.a.p0.w2.m.h.a aVar = this.mSubPbView;
            if (aVar != null) {
                return aVar.H();
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
            if (subPbModel == null || c.a.d.f.p.m.isEmpty(subPbModel.z0())) {
                return 0L;
            }
            return c.a.d.f.m.b.g(this.mSubPbModel.z0(), 0L);
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public c.a.o0.p0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.o0.p0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null && (subPbModel = this.mSubPbModel) != null) {
                if (subPbModel.l0() != null && this.mSubPbModel.l0().d() != null) {
                    pageStayDurationItem.t(c.a.d.f.m.b.g(this.mSubPbModel.l0().d().getId(), 0L));
                }
                pageStayDurationItem.C(c.a.d.f.m.b.g(this.mSubPbModel.z0(), 0L));
                if (this.mSubPbModel.l0() != null && this.mSubPbModel.l0().l() != null) {
                    ThreadData l2 = this.mSubPbModel.l0().l();
                    pageStayDurationItem.u(l2.getNid());
                    if (l2.isNormalThreadType()) {
                        pageStayDurationItem.t = "1";
                    } else if (l2.isVideoThreadType()) {
                        pageStayDurationItem.t = "2";
                    } else {
                        pageStayDurationItem.t = "3";
                    }
                }
                pageStayDurationItem.w(c.a.d.f.m.b.g(this.mSubPbModel.A(), 0L));
            }
            return pageStayDurationItem;
        }
        return (c.a.o0.p0.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, c.a.o0.p0.a
    public c.a.o0.p0.b getPageStayFilter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? new b0(this) : (c.a.o0.p0.b) invokeV.objValue;
    }

    public String getPostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null) {
                return subPbModel.A();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData.VoiceModel voiceModel) {
        InterceptResult invokeL;
        View findViewWithTag;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, voiceModel)) == null) {
            View F = this.mSubPbView.F();
            if (F == null || (findViewWithTag = F.findViewWithTag(voiceModel)) == null) {
                return null;
            }
            return (VoiceManager.i) findViewWithTag;
        }
        return (VoiceManager.i) invokeL.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            c.a.d.f.k.b<RelativeLayout> bVar = new c.a.d.f.k.b<>(new a0(this), 10, 0);
            this.mMemeViewPool = bVar;
            return bVar;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public String getReplyHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (!c.a.d.f.p.m.isEmpty(this.mReplyHintText)) {
                return this.mReplyHintText;
            }
            String string = getResources().getString(y0.b());
            this.mReplyHintText = string;
            return string;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
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

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.mTextViewPool == null) {
                this.mTextViewPool = TbRichTextView.C(getPageContext().getPageActivity(), 8);
            }
            return this.mTextViewPool;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.mTextVoiceViewPool == null) {
                this.mTextVoiceViewPool = new c.a.d.f.k.b<>(new z(this), 15, 0);
            }
            return this.mTextVoiceViewPool;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public String getThreadId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null) {
                return subPbModel.z0();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    @Override // c.a.p0.w2.m.a
    public int getUserIdentify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null) {
                return 0;
            }
            return subPbModel.D0();
        }
        return invokeV.intValue;
    }

    public int getUserIdentity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null) {
                return subPbModel.D0();
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

    @Override // c.a.o0.e1.n.i
    public c.a.d.f.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            if (this.mVoiceViewPool == null) {
                this.mVoiceViewPool = new c.a.d.f.k.b<>(new y(this), 8, 0);
            }
            return this.mVoiceViewPool;
        }
        return (c.a.d.f.k.b) invokeV.objValue;
    }

    public void handleMuteClick(boolean z2, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Boolean.valueOf(z2), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.obfuscated_res_0x7f091ebb) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ebb) : "";
            String str3 = sparseArray.get(R.id.obfuscated_res_0x7f091ebd) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ebd) : "";
            String str4 = sparseArray.get(R.id.obfuscated_res_0x7f091ebc) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091ebc) : "";
            if (sparseArray.get(R.id.obfuscated_res_0x7f091eb8) instanceof String) {
                str4 = (String) sparseArray.get(R.id.obfuscated_res_0x7f091eb8);
            }
            String str5 = str4;
            String str6 = sparseArray.get(R.id.obfuscated_res_0x7f091eb8) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091eb8) : "";
            String str7 = sparseArray.get(R.id.obfuscated_res_0x7f091eb9) instanceof String ? (String) sparseArray.get(R.id.obfuscated_res_0x7f091eb9) : "";
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
            if (subPbModel != null && subPbModel.l0() != null && this.mSubPbModel.l0().l() != null && this.mSubPbModel.l0().l().isBjh()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.mSubPbModel.z0(), str);
                ThreadData l2 = this.mSubPbModel.l0().l();
                if (l2.isBJHArticleThreadType()) {
                    format = format + "&channelid=33833";
                } else if (l2.isBjhDynamicThread()) {
                    format = format + "&channelid=33842";
                } else if (l2.isBJHVideoThreadType()) {
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
            subPbModel.Z0(new c(this));
            ForumManageModel forumManageModel = new ForumManageModel(getPageContext());
            this.mPostManageModel = forumManageModel;
            forumManageModel.setLoadDataCallBack(this.mPostManageCallBack);
            VoiceManager voiceManager = new VoiceManager();
            this.mVoiceManager = voiceManager;
            voiceManager.onCreate(getPageContext());
            c.a.o0.h.a b2 = c.a.o0.h.a.b(this);
            this.mMarkModel = b2;
            if (b2 != null) {
                b2.j(this.mMarkDoneCallBack);
            }
            if (bundle != null) {
                this.mSubPbModel.initWithBundle(bundle);
            } else {
                this.mSubPbModel.initWithIntent(getIntent());
            }
            setForceInterceptStimeStat(this.mSubPbModel.H0());
            this.mSubPbModel.d1(this.mSubPbCallBack);
            if (this.mSubPbModel.K0() && !this.mSubPbModel.Q0()) {
                this.mSubPbModel.loadData();
            } else if (!TextUtils.isEmpty(getIntent().getStringExtra("key_open_editor_tips"))) {
                this.mSubPbModel.loadData();
            } else {
                this.mSubPbModel.R0();
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
            c.a.p0.w2.m.h.a aVar = new c.a.p0.w2.m.h.a(this, this.mCommonClickListener);
            this.mSubPbView = aVar;
            aVar.r0(this.mSubPbModel);
            setContentView(this.mSubPbView.Q(), new FrameLayout.LayoutParams(-1, -1));
            this.mSubPbView.v0(this.mSubPbScrollListener);
            this.mSubPbView.w0(this);
            this.mSubPbView.s0(this.mImageClickListener);
            this.mSubPbView.t0(this.mOnLongClickListener);
            this.mSubPbView.u0(new b(this));
            this.mSubPbView.n0(this.forbidUserCallback);
            this.mSubPbView.l0(this.deleteReplayCallback);
            this.mSubPbView.p0(this.mOnPullRefreshListener);
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null && subPbModel.K0() && !this.mSubPbModel.P0()) {
                this.mSubPbView.E().setVisibility(8);
            } else {
                this.mSubPbView.E().setVisibility(0);
            }
            SubPbModel subPbModel2 = this.mSubPbModel;
            if (subPbModel2 == null || subPbModel2.K0()) {
                return;
            }
            this.mSubPbView.o0(false);
        }
    }

    public boolean isFromPb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel != null) {
                return subPbModel.K0();
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
                return isH5GameLink(c.a.d.f.p.m.getUrlDecode(str2));
            }
            String str3 = paramPair.get(TB_GAME_TYPE);
            return !TextUtils.isEmpty(str3) && str3.equals("1");
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.p0.w2.m.a
    public boolean isHost(String str) {
        InterceptResult invokeL;
        SubPbModel subPbModel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            if (StringUtils.isNull(str) || (subPbModel = this.mSubPbModel) == null || subPbModel.l0() == null || this.mSubPbModel.l0().l() == null || this.mSubPbModel.l0().l().getAuthor() == null) {
                return false;
            }
            return str.equals(this.mSubPbModel.l0().l().getAuthor().getUserId());
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

    @Override // c.a.p0.w2.m.a
    public boolean isSimpleForum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            SubPbModel subPbModel = this.mSubPbModel;
            if (subPbModel == null || subPbModel.l0() == null || this.mSubPbModel.l0().l() == null) {
                return false;
            }
            return !this.mSubPbModel.l0().l().isMutiForumThread();
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
            c.a.o0.w.y.h hVar = this.mEditor;
            if (hVar != null) {
                hVar.C(i2, i3, intent);
            }
        }
    }

    @Override // c.a.o0.e1.n.i
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
            c.a.o0.w.y.h hVar = this.mEditor;
            if (hVar != null && hVar.a() != null && this.mEditor.a().u()) {
                this.mEditor.a().q();
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
            this.mSubPbView.f0(i2);
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
            c.a.p0.s4.c cVar = new c.a.p0.s4.c();
            this.mSensitiveProcessController = cVar;
            cVar.h(R.color.cp_cont_h_alpha85);
            this.mSensitiveProcessController.j(R.color.CAM_X0101);
            initListeners();
            initCallBacks();
            initData(bundle);
            initUI();
            if (this.mIsFromVideoTAb && this.mSubPbView.B() != null) {
                showLoadingView(this.mSubPbView.B(), true, UtilHelper.getDimenPixelSize(R.dimen.tbds300));
            }
            if (this.mIsFromVideoTAb) {
                ((SubPbView) this.mSubPbView.Q()).setAnimTime(0);
                ((SubPbView) this.mSubPbView.Q()).setIsFromVideoTab(true);
            } else if (this.mIsFromFoldComment) {
                setActivityBgTransparent();
                ((SubPbView) this.mSubPbView.Q()).setAnimTime(0);
                ((SubPbView) this.mSubPbView.Q()).setIsFromFoldComment(true);
            } else {
                ((SubPbView) this.mSubPbView.Q()).setAnimTime(300);
                ((SubPbView) this.mSubPbView.Q()).setIsFromVideoTab(false);
            }
            ((SubPbView) this.mSubPbView.Q()).h();
            initEditor(false);
            addGlobalLayoutListener();
            adjustResizeForSoftInput();
            this.mSubPbView.r(this.mIsFromSchema);
            c.a.o0.r.l0.c cVar2 = new c.a.o0.r.l0.c();
            this.mToastMute = cVar2;
            cVar2.a = 1000L;
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
            c.a.p0.w2.m.g.a aVar = new c.a.p0.w2.m.g.a(this);
            this.mUEGReportController = aVar;
            aVar.b(getUniqueId());
            this.mEvent = new c.a.p0.w2.m.f.k1.a(this);
            this.mUserBlockController = new c.a.p0.j4.b(getPageContext(), getUniqueId());
            if (this.tiePlusEventController == null) {
                if (this.isFromVideoMiddle) {
                    this.tiePlusEventController = new TiePlusEventController(this, TiePlusStat.Locate.VIDEO_MIDDLE_COMMENT);
                } else {
                    this.tiePlusEventController = new TiePlusEventController(this, TiePlusStat.Locate.PB_COMMENT);
                }
                this.tiePlusEventController.d(this.richTextEventAckedCallback);
            }
            c.a.o0.s.h.b.b(false);
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
            this.mSubPbView.c0();
            MessageManager.getInstance().unRegisterListener(this.mUserMuteAddListener);
            MessageManager.getInstance().unRegisterListener(this.mUserMuteDelListener);
            MessageManager.getInstance().unRegisterListener(this.mUserMuteCheckListener);
            MessageManager.getInstance().unRegisterListener(this.MESSAGE_ID_NEWSUB_PB);
            c.a.p0.j4.b bVar = this.mUserBlockController;
            if (bVar != null) {
                bVar.l();
            }
            ReplyPrivacyCheckController replyPrivacyCheckController = this.mReplyPrivacyController;
            if (replyPrivacyCheckController != null) {
                replyPrivacyCheckController.onDestroy();
            }
            this.mCtx = null;
            this.mToastMute = null;
            TbPageExtraHelper.setPrePageKey(getCurrentPageKey());
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

    @Override // c.a.o0.e1.n.i
    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, context, str) == null) {
        }
    }

    @Override // c.a.o0.e1.n.i
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
                c.a.o0.t.p pVar = new c.a.o0.t.p();
                pVar.a = str;
                pVar.f11477b = 3;
                pVar.f11478c = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016493, pVar));
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
            c.a.o0.a.d.y().G();
            VoiceManager voiceManager = this.mVoiceManager;
            if (voiceManager != null) {
                voiceManager.onPause(getPageContext());
            }
            MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
            this.mSubPbView.d0();
            if (this.mIsFromVideoTAb || this.mIsFromFoldComment) {
                syncFloatBackGround(false);
            }
        }
    }

    @Override // c.a.o0.e1.n.i
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

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, c.a.d.a.i
    public void onPreLoad(c.a.d.o.e.q qVar) {
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
            this.mSubPbView.e0();
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
            subPbModel.Y0(bundle);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            if (this.mSubPbView.J0() && c.a.d.f.p.n.C()) {
                this.mSubPbModel.loadData();
            } else {
                this.mSubPbView.m0();
            }
        }
    }

    @Override // c.a.o0.e1.n.i
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
            c.a.p0.w2.m.f.j0 j0Var = this.mPostMoreOptionView;
            if (j0Var != null) {
                j0Var.o(z2);
            }
            c.a.p0.w2.m.h.a aVar = this.mSubPbView;
            if (aVar != null) {
                aVar.t(z2);
            }
        }
    }

    @Override // c.a.o0.e1.n.i
    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048639, this, context, str) == null) {
        }
    }

    @Override // c.a.o0.e1.n.i
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
        if (!(interceptable == null || interceptable.invokeLZ(65625, this, postData, z2) == null) || checkIsIfPostForbid()) {
            return;
        }
        if (postData != null) {
            if (postData.s() != null) {
                MetaData s2 = postData.s();
                this.mEditor.W(s2.getUserId());
                boolean z3 = postData.l0;
                this.mEditor.p(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0f98), postData.s().getName_show(), postData.N() != null ? postData.N().toString() : ""));
                if (z3) {
                    if (!z2) {
                        this.mEditor.V(s2.getName_show(), s2.getPortrait());
                    }
                } else if (!z2) {
                    this.mEditor.V(s2.getName_show(), s2.getPortrait());
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
        if (this.mSubPbModel.N0() && postData.G() != null && postData.G().equals(this.mSubPbModel.u0())) {
            z2 = true;
        }
        MarkData t0 = this.mSubPbModel.t0(postData);
        if (t0 == null) {
            return;
        }
        this.mSubPbView.w();
        c.a.o0.h.a aVar = this.mMarkModel;
        if (aVar != null) {
            aVar.i(t0);
            if (!z2) {
                this.mMarkModel.a();
            } else {
                this.mMarkModel.d();
            }
        }
    }
}
